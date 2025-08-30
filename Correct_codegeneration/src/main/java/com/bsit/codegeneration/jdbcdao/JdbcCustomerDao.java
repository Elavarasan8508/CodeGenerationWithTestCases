package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcCustomerDao {

    private static final String TABLE = "customer";

    private static final String COL_CUSTOMER_ID = "customer_id";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_FIRST_NAME = "first_name";

    private static final String COL_LAST_NAME = "last_name";

    private static final String COL_EMAIL = "email";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_ACTIVE = "active";

    private static final String COL_CREATE_DATE = "create_date";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_STORE_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_ADDRESS_ID, COL_ACTIVE, COL_CREATE_DATE, COL_LAST_UPDATE, COL_CUSTOMER_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    private static final String SELECT_BY_ADDRESS_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_STORE_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_ADDRESS_ID, COL_ACTIVE, COL_CREATE_DATE, COL_LAST_UPDATE, COL_CUSTOMER_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    public int insert(Connection conn, Customer customer) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCustomerParams(ps, customer);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    customer.setCustomerID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Customer> customers) throws SQLException {
        if (customers == null || customers.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[customers.size()];
            for (int i = 0; i < customers.size(); i++) {
                Customer item = customers.get(i);
                setCustomerParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setCustomerID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Customer findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Customer> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Customer> list = new ArrayList<>();
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

    public boolean update(Connection conn, Customer customer) throws SQLException {
        if (customer.getCustomerID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCustomerParams(ps, customer);
            ps.setInt(9, customer.getCustomerID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Customer> customers) throws SQLException {
        if (customers == null || customers.isEmpty())
            return new int[0];
        for (Customer customer : customers) {
            if (customer == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (customer.getCustomerID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Customer customer : customers) {
                setCustomerParams(ps, customer);
                ps.setInt(9, customer.getCustomerID());
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

    public List<Customer> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Customer> list = new ArrayList<>();
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

    public List<Customer> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<Customer> list = new ArrayList<>();
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

    private void setCustomerParams(PreparedStatement ps, Customer customer) throws SQLException {
        if (customer.getStore() != null && customer.getStore().getStoreID() > 0) {
            ps.setInt(1, customer.getStore().getStoreID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, customer.getFirstName());
        ps.setString(3, customer.getLastName());
        ps.setString(4, customer.getEmail());
        if (customer.getAddress() != null && customer.getAddress().getAddressID() > 0) {
            ps.setInt(5, customer.getAddress().getAddressID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Boolean val6 = customer.getActive();
        if (val6 != null) {
            ps.setBoolean(6, val6);
        } else {
            ps.setNull(6, Types.BOOLEAN);
        }
        java.time.LocalDate val7 = customer.getCreateDate();
        if (val7 != null) {
            ps.setDate(7, java.sql.Date.valueOf(val7));
        } else {
            ps.setNull(7, Types.DATE);
        }
        LocalDateTime updateTime8 = Objects.requireNonNullElse(customer.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(8, Timestamp.valueOf(updateTime8));
    }

    private Customer extract(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        customer.setCustomerID(customer_id);
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        customer.setStoreID(store_id);
        if (store_id != null && store_id > 0) {
            Store store = new Store();
            store.setStoreID(store_id);
            customer.setStore(store);
        }
        customer.setFirstName(rs.getString(COL_FIRST_NAME));
        customer.setLastName(rs.getString(COL_LAST_NAME));
        customer.setEmail(rs.getString(COL_EMAIL));
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        customer.setAddressID(address_id);
        if (address_id != null && address_id > 0) {
            Address address = new Address();
            address.setAddressID(address_id);
            customer.setAddress(address);
        }
        Boolean active = rs.getObject(COL_ACTIVE, Boolean.class);
        customer.setActive(active);
        java.sql.Date create_date = rs.getDate(COL_CREATE_DATE);
        if (create_date != null)
            customer.setCreateDate(create_date.toLocalDate());
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            customer.setLastUpdate(last_update.toLocalDateTime());
        return customer;
    }
}
