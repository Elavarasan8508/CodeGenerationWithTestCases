package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcStoreDao {

    private static final String TABLE = "store";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_MANAGER_STAFF_ID = "manager_staff_id";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_MANAGER_STAFF_ID, COL_ADDRESS_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_STORE_ID);

    private static final String SELECT_BY_ADDRESS_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_MANAGER_STAFF_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_MANAGER_STAFF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_MANAGER_STAFF_ID, COL_ADDRESS_ID, COL_LAST_UPDATE, COL_STORE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

    public int insert(Connection conn, Store store) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setStoreParams(ps, store);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    store.setStoreID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Store> stores) throws SQLException {
        if (stores == null || stores.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Store store : stores) {
                setStoreParams(ps, store);
                ps.addBatch();
            }
            results = ps.executeBatch();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                int index = 0;
                while (rs.next() && index < stores.size()) {
                    try {
                        stores.get(index).setStoreID(rs.getInt(1));
                    } catch (Exception e) {
                        // if mapping the key fails, wrap to give context
                        throw new SQLException("Failed to set generated key for index " + index + ": " + e.getMessage(), e);
                    }
                    index++;
                }
            }
        }
        return results;
    }

    public Store findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Store> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Store> list = new ArrayList<>();
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

    public boolean update(Connection conn, Store store) throws SQLException {
        if (store.getStoreID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setStoreParams(ps, store);
            ps.setInt(4, store.getStoreID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Store> stores) throws SQLException {
        if (stores == null || stores.isEmpty())
            return new int[0];
        for (Store store : stores) {
            if (store == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (store.getStoreID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Store store : stores) {
                setStoreParams(ps, store);
                ps.setInt(4, store.getStoreID());
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

    public List<Store> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Store> list = new ArrayList<>();
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

    public List<Store> findByManagerStaffID(Connection conn, int managerStaffID) throws SQLException {
        List<Store> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_MANAGER_STAFF_ID_SQL)) {
            ps.setInt(1, managerStaffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setStoreParams(PreparedStatement ps, Store store) throws SQLException {
        if (store.getManagerStaff() != null && store.getManagerStaff().getStaffID() > 0) {
            ps.setInt(1, store.getManagerStaff().getStaffID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (store.getAddress() != null && store.getAddress().getAddressID() > 0) {
            ps.setInt(2, store.getAddress().getAddressID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        LocalDateTime updateTime3 = Objects.requireNonNullElse(store.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private Store extract(ResultSet rs) throws SQLException {
        Store store = new Store();
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        store.setStoreID(store_id);
        Integer manager_staff_id = rs.getObject(COL_MANAGER_STAFF_ID, Integer.class);
        store.setManagerStaffID(manager_staff_id);
        if (manager_staff_id != null && manager_staff_id > 0) {
            Staff managerStaff = new Staff();
            managerStaff.setStaffID(manager_staff_id);
            store.setManagerStaff(managerStaff);
        }
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        store.setAddressID(address_id);
        if (address_id != null && address_id > 0) {
            Address address = new Address();
            address.setAddressID(address_id);
            store.setAddress(address);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            store.setLastUpdate(last_update.toLocalDateTime());
        return store;
    }
}
