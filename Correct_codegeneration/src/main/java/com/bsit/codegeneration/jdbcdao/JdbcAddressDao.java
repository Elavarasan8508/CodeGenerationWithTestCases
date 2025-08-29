package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcAddressDao {

    private static final String TABLE = "address";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_ADDRESS = "address";

    private static final String COL_ADDRESS2 = "address2";

    private static final String COL_DISTRICT = "district";

    private static final String COL_CITY_ID = "city_id";

    private static final String COL_POSTAL_CODE = "postal_code";

    private static final String COL_PHONE = "phone";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ADDRESS, COL_ADDRESS2, COL_DISTRICT, COL_CITY_ID, COL_POSTAL_CODE, COL_PHONE, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_CITY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CITY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS, COL_ADDRESS2, COL_DISTRICT, COL_CITY_ID, COL_POSTAL_CODE, COL_PHONE, COL_LAST_UPDATE, COL_ADDRESS_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    public int insert(Connection conn, Address address) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setAddressParams(ps, address);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    address.setAddressID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Address> addresss) throws SQLException {
        if (addresss == null || addresss.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < addresss.size(); i++) {
            if (addresss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Address address : addresss) {
                setAddressParams(ps, address);
                ps.addBatch();
            }
            results = ps.executeBatch();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                int index = 0;
                while (rs.next() && index < addresss.size()) {
                    try {
                        addresss.get(index).setAddressID(rs.getInt(1));
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

    public Address findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Address> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Address> list = new ArrayList<>();
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

    public boolean update(Connection conn, Address address) throws SQLException {
        if (address.getAddressID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAddressParams(ps, address);
            ps.setInt(8, address.getAddressID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Address> addresss) throws SQLException {
        if (addresss == null || addresss.isEmpty())
            return new int[0];
        for (Address address : addresss) {
            if (address == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (address.getAddressID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Address address : addresss) {
                setAddressParams(ps, address);
                ps.setInt(8, address.getAddressID());
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

    public List<Address> findByCityID(Connection conn, int cityID) throws SQLException {
        List<Address> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CITY_ID_SQL)) {
            ps.setInt(1, cityID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setAddressParams(PreparedStatement ps, Address address) throws SQLException {
        ps.setString(1, address.getAddress());
        ps.setString(2, address.getAddress2());
        ps.setString(3, address.getDistrict());
        if (address.getCity() != null && address.getCity().getCityID() > 0) {
            ps.setInt(4, address.getCity().getCityID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, address.getPostalCode());
        ps.setString(6, address.getPhone());
        LocalDateTime updateTime7 = Objects.requireNonNullElse(address.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(7, Timestamp.valueOf(updateTime7));
    }

    private Address extract(ResultSet rs) throws SQLException {
        Address address = new Address();
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        address.setAddressID(address_id);
        address.setAddress(rs.getString(COL_ADDRESS));
        address.setAddress2(rs.getString(COL_ADDRESS2));
        address.setDistrict(rs.getString(COL_DISTRICT));
        Integer city_id = rs.getObject(COL_CITY_ID, Integer.class);
        address.setCityID(city_id);
        if (city_id != null && city_id > 0) {
            City city = new City();
            city.setCityID(city_id);
            address.setCity(city);
        }
        address.setPostalCode(rs.getString(COL_POSTAL_CODE));
        address.setPhone(rs.getString(COL_PHONE));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            address.setLastUpdate(last_update.toLocalDateTime());
        return address;
    }
}
