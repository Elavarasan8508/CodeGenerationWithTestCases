package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.stream.Collectors;

public class JdbcStoreDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcStoreDao.class);

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
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("store_id, manager_staff_id, address_id, last_update", TABLE, COL_STORE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("store_id, manager_staff_id, address_id, last_update", TABLE, COL_STORE_ID);

    private static final String SELECT_BY_ADDRESS_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("store_id, manager_staff_id, address_id, last_update", TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_MANAGER_STAFF_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("store_id, manager_staff_id, address_id, last_update", TABLE, COL_MANAGER_STAFF_ID);

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

    public int insert(Connection conn, Store store) throws SQLException {
        logger.debug("Inserting store: {}", store);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setStoreParams(ps, store);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    store.setStoreID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted store");
                    throw new SQLException("Failed to retrieve generated ID for inserted store");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Store> stores) throws SQLException {
        if (stores == null || stores.isEmpty())
            return new int[0];
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Store>> batches = chunkList(stores, batchSize);
        int[] totalResults = new int[stores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Store> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Store store : batch) {
                        setStoreParams(ps, store);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Inserted {} rows in batch", results.length);
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        List<Integer> keys = new ArrayList<>();
                        while (rs.next()) {
                            keys.add(rs.getInt(1));
                        }
                        for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                            batch.get(i).setStoreID(keys.get(i));
                        }
                    }
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
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
        if (stores == null || stores.isEmpty())
            return new int[0];
        for (Store store : stores) {
            if (store == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (store.getStoreID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Store>> batches = chunkList(stores, batchSize);
        int[] totalResults = new int[stores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Store> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Store store : batch) {
                        setStoreParams(ps, store);
                        ps.setInt(4, store.getStoreID());
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Updated {} rows in batch", results.length);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return 0;
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_STORE_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
                    }
                    int affected = ps.executeUpdate();
                    totalDeleted += affected;
                    logger.debug("Deleted {} rows in batch", affected);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
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
        if (store.getManagerStaff() != null) {
            ps.setObject(1, store.getManagerStaff().getStaffID(), Types.INTEGER);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (store.getAddress() != null) {
            ps.setObject(2, store.getAddress().getAddressID(), Types.INTEGER);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.time.LocalDateTime val3 = store.getLastUpdate();
        if (val3 != null) {
            ps.setObject(3, java.sql.Timestamp.valueOf(val3), Types.TIMESTAMP);
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
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
