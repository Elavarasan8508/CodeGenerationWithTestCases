package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcStaffDao {

    private static final String TABLE = "staff";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_FIRST_NAME = "first_name";

    private static final String COL_LAST_NAME = "last_name";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_EMAIL = "email";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_ACTIVE = "active";

    private static final String COL_USERNAME = "username";

    private static final String COL_PASSWORD = "password";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String COL_PICTURE = "picture";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_ADDRESS_ID, COL_EMAIL, COL_STORE_ID, COL_ACTIVE, COL_USERNAME, COL_PASSWORD, COL_LAST_UPDATE, COL_PICTURE, COL_STAFF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STAFF_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_STAFF_ID);

    private static final String SELECT_BY_ADDRESS_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_STORE_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_ADDRESS_ID, COL_EMAIL, COL_STORE_ID, COL_ACTIVE, COL_USERNAME, COL_PASSWORD, COL_LAST_UPDATE, COL_PICTURE, COL_STAFF_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STAFF_ID);

    public int insert(Connection conn, Staff staff) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setStaffParams(ps, staff);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    staff.setStaffID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Staff> staffs) throws SQLException {
        if (staffs == null || staffs.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[staffs.size()];
            for (int i = 0; i < staffs.size(); i++) {
                Staff item = staffs.get(i);
                setStaffParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setStaffID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Staff findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Staff> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Staff> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Staff staff) throws SQLException {
        if (staff.getStaffID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setStaffParams(ps, staff);
            ps.setInt(11, staff.getStaffID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Staff> staffs) throws SQLException {
        if (staffs == null || staffs.isEmpty())
            return new int[0];
        for (Staff staff : staffs) {
            if (staff == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (staff.getStaffID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Staff staff : staffs) {
                setStaffParams(ps, staff);
                ps.setInt(11, staff.getStaffID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            for (Integer id : ids) {
                ps.setInt(1, id);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
    }

    public List<Staff> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Staff> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ADDRESS_ID_SQL)) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Staff> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<Staff> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STORE_ID_SQL)) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setStaffParams(PreparedStatement ps, Staff staff) throws SQLException {
        ps.setString(1, staff.getFirstName());
        ps.setString(2, staff.getLastName());
        if (staff.getAddress() != null && staff.getAddress().getAddressID() > 0) {
            ps.setInt(3, staff.getAddress().getAddressID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, staff.getEmail());
        if (staff.getStore() != null && staff.getStore().getStoreID() > 0) {
            ps.setInt(5, staff.getStore().getStoreID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Boolean val6 = staff.getActive();
        if (val6 != null) {
            ps.setBoolean(6, val6);
        } else {
            ps.setNull(6, Types.BOOLEAN);
        }
        ps.setString(7, staff.getUsername());
        ps.setString(8, staff.getPassword());
        LocalDateTime updateTime9 = Objects.requireNonNullElse(staff.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(9, Timestamp.valueOf(updateTime9));
        ps.setString(10, staff.getPicture());
    }

    private Staff extract(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        staff.setStaffID(staff_id);
        staff.setFirstName(rs.getString(COL_FIRST_NAME));
        staff.setLastName(rs.getString(COL_LAST_NAME));
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        staff.setAddressID(address_id);
        if (address_id != null && address_id > 0) {
            Address address = new Address();
            address.setAddressID(address_id);
            staff.setAddress(address);
        }
        staff.setEmail(rs.getString(COL_EMAIL));
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        staff.setStoreID(store_id);
        if (store_id != null && store_id > 0) {
            Store store = new Store();
            store.setStoreID(store_id);
            staff.setStore(store);
        }
        Boolean active = rs.getObject(COL_ACTIVE, Boolean.class);
        staff.setActive(active);
        staff.setUsername(rs.getString(COL_USERNAME));
        staff.setPassword(rs.getString(COL_PASSWORD));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            staff.setLastUpdate(last_update.toLocalDateTime());
        staff.setPicture(rs.getString(COL_PICTURE));
        return staff;
    }
}
