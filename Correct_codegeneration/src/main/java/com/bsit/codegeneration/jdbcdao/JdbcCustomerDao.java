package com.bsit.codegeneration.jdbcdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.time.LocalDate;
import com.bsit.codegeneration.pojo.Customer;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Store;

public class JdbcCustomerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCustomerDao.class);

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

    private static final String SELECT_COLUMNS = "customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_STORE_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_ADDRESS_ID, COL_ACTIVE, COL_CREATE_DATE, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_CUSTOMER_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_ADDRESS_ID, COL_ACTIVE, COL_CREATE_DATE, COL_LAST_UPDATE, COL_CUSTOMER_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    private static String getSelectByColumnSql(String column) {
        return """
            SELECT %s FROM %s WHERE %s = ?
            """.formatted(SELECT_COLUMNS, TABLE, column);
    }

    private static void setNullable(PreparedStatement ps, int index, Object value, int sqlType) throws SQLException {
        if (value != null)
            ps.setObject(index, value, sqlType);
        else
            ps.setNull(index, sqlType);
    }

    public int insert(Connection conn, Customer customer) throws SQLException {
        LOGGER.debug("Inserting customer: {}", customer);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setCustomerParams(ps, customer);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    customer.setCustomerID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted customer");
                    throw new SQLException("Failed to retrieve generated ID for inserted customer");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Customer> customers) throws SQLException {
        if (isInvalidCustomerList(customers)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Customer>> batches = chunkList(customers, batchSize);
        int[] totalResults = new int[customers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Customer> batch : batches) {
                int[] results = processBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidCustomerList(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            return true;
        }
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Customer> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Customer customer : batch) {
                setCustomerParams(ps, customer);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Inserted {} rows in batch", results.length);
            try (ResultSet rs = ps.getGeneratedKeys()) {
                List<Integer> keys = new ArrayList<>();
                while (rs.next()) {
                    keys.add(rs.getInt(1));
                }
                for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                    batch.get(i).setCustomerID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Customer findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_CUSTOMER_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Customer> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Customer> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * pageSize);
            ps.setInt(2, pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Customer customer) throws SQLException {
        if (customer.getCustomerID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCustomerParams(ps, customer);
            ps.setInt(9, customer.getCustomerID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Customer> customers) throws SQLException {
        if (isInvalidUpdateCustomerList(customers)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Customer>> batches = chunkList(customers, batchSize);
        int[] totalResults = new int[customers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Customer> batch : batches) {
                int[] results = processUpdateBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidUpdateCustomerList(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            return true;
        }
        for (Customer customer : customers) {
            if (customer == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (customer.getCustomerID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Customer> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Customer customer : batch) {
                setCustomerParams(ps, customer);
                ps.setInt(9, customer.getCustomerID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Updated {} rows in batch", results.length);
            return results;
        } catch (SQLException e) {
            LOGGER.error("Batch update failed", e);
            throw e;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (isInvalidIdsList(ids)) {
            return 0;
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                int affected = processDeleteChunk(conn, chunk);
                totalDeleted += affected;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
    }

    private boolean isInvalidIdsList(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        return false;
    }

    private int processDeleteChunk(Connection conn, List<Integer> chunk) throws SQLException {
        String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_CUSTOMER_ID, placeholders);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < chunk.size(); i++) {
                ps.setInt(i + 1, chunk.get(i));
            }
            int affected = ps.executeUpdate();
            LOGGER.debug("Deleted {} rows in batch", affected);
            return affected;
        } catch (SQLException e) {
            LOGGER.error("Batch delete failed", e);
            throw e;
        }
    }

    public List<Customer> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Customer> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_ADDRESS_ID))) {
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
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_STORE_ID))) {
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
        setNullable(ps, 1, customer.getStore() != null ? customer.getStore().getStoreID() : null, Types.INTEGER);
        setNullable(ps, 2, customer.getFirstName(), Types.VARCHAR);
        setNullable(ps, 3, customer.getLastName(), Types.VARCHAR);
        setNullable(ps, 4, customer.getEmail(), Types.VARCHAR);
        setNullable(ps, 5, customer.getAddress() != null ? customer.getAddress().getAddressID() : null, Types.INTEGER);
        setNullable(ps, 6, customer.getActive(), Types.BOOLEAN);
        setNullable(ps, 7, customer.getCreateDate() != null ? java.sql.Date.valueOf(customer.getCreateDate()) : null, Types.DATE);
        setNullable(ps, 8, customer.getLastUpdate() != null ? java.sql.Timestamp.valueOf(customer.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private Customer extract(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        customer.setCustomerID(customer_id);
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        customer.setStoreID(store_id);
        if (store_id != null) {
            Store store = new Store();
            store.setStoreID(store_id);
            customer.setStore(store);
        }
        customer.setFirstName(rs.getString(COL_FIRST_NAME));
        customer.setLastName(rs.getString(COL_LAST_NAME));
        customer.setEmail(rs.getString(COL_EMAIL));
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        customer.setAddressID(address_id);
        if (address_id != null) {
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
