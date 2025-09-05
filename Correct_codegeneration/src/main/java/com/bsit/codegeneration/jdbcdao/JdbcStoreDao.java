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
import com.bsit.codegeneration.pojo.Store;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Staff;

public class JdbcStoreDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcStoreDao.class);

    private static final String TABLE = "store";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_MANAGER_STAFF_ID = "manager_staff_id";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "store_id, manager_staff_id, address_id, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_MANAGER_STAFF_ID, COL_ADDRESS_ID, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_STORE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_MANAGER_STAFF_ID, COL_ADDRESS_ID, COL_LAST_UPDATE, COL_STORE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

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

    public int insert(Connection conn, Store store) throws SQLException {
        LOGGER.debug("Inserting store: {}", store);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setStoreParams(ps, store);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    store.setStoreID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted store");
                    throw new SQLException("Failed to retrieve generated ID for inserted store");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Store> stores) throws SQLException {
        if (isInvalidStoreList(stores)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Store>> batches = chunkList(stores, batchSize);
        int[] totalResults = new int[stores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Store> batch : batches) {
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

    private boolean isInvalidStoreList(List<Store> stores) {
        if (stores == null || stores.isEmpty()) {
            return true;
        }
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Store> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Store store : batch) {
                setStoreParams(ps, store);
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
                    batch.get(i).setStoreID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Store findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_STORE_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Store> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Store> list = new ArrayList<>();
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
        if (isInvalidUpdateStoreList(stores)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Store>> batches = chunkList(stores, batchSize);
        int[] totalResults = new int[stores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Store> batch : batches) {
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

    private boolean isInvalidUpdateStoreList(List<Store> stores) {
        if (stores == null || stores.isEmpty()) {
            return true;
        }
        for (Store store : stores) {
            if (store == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (store.getStoreID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Store> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Store store : batch) {
                setStoreParams(ps, store);
                ps.setInt(4, store.getStoreID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_STORE_ID, placeholders);
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

    public List<Store> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Store> list = new ArrayList<>();
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

    public List<Store> findByManagerStaffID(Connection conn, int managerStaffID) throws SQLException {
        List<Store> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_MANAGER_STAFF_ID))) {
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
        setNullable(ps, 1, store.getManagerStaff() != null ? store.getManagerStaff().getStaffID() : null, Types.INTEGER);
        setNullable(ps, 2, store.getAddress() != null ? store.getAddress().getAddressID() : null, Types.INTEGER);
        setNullable(ps, 3, store.getLastUpdate() != null ? java.sql.Timestamp.valueOf(store.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private Store extract(ResultSet rs) throws SQLException {
        Store store = new Store();
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        store.setStoreID(store_id);
        Integer manager_staff_id = rs.getObject(COL_MANAGER_STAFF_ID, Integer.class);
        store.setManagerStaffID(manager_staff_id);
        if (manager_staff_id != null) {
            Staff managerStaff = new Staff();
            managerStaff.setStaffID(manager_staff_id);
            store.setManagerStaff(managerStaff);
        }
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        store.setAddressID(address_id);
        if (address_id != null) {
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
