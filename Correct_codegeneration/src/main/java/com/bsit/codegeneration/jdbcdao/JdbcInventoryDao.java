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

public class JdbcInventoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcInventoryDao.class);

    private static final String TABLE = "inventory";

    private static final String COL_INVENTORY_ID = "inventory_id";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_FILM_ID, COL_STORE_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("inventory_id, film_id, store_id, last_update", TABLE, COL_INVENTORY_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("inventory_id, film_id, store_id, last_update", TABLE, COL_INVENTORY_ID);

    private static final String SELECT_BY_FILM_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("inventory_id, film_id, store_id, last_update", TABLE, COL_FILM_ID);

    private static final String SELECT_BY_STORE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("inventory_id, film_id, store_id, last_update", TABLE, COL_STORE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID, COL_STORE_ID, COL_LAST_UPDATE, COL_INVENTORY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_INVENTORY_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public int insert(Connection conn, Inventory inventory) throws SQLException {
        logger.debug("Inserting inventory: {}", inventory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setInventoryParams(ps, inventory);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    inventory.setInventoryID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted inventory");
                    throw new SQLException("Failed to retrieve generated ID for inserted inventory");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Inventory> inventorys) throws SQLException {
        if (inventorys == null || inventorys.isEmpty())
            return new int[0];
        for (int i = 0; i < inventorys.size(); i++) {
            if (inventorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Inventory>> batches = chunkList(inventorys, batchSize);
        int[] totalResults = new int[inventorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Inventory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Inventory inventory : batch) {
                        setInventoryParams(ps, inventory);
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
                            batch.get(i).setInventoryID(keys.get(i));
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

    public Inventory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Inventory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Inventory> list = new ArrayList<>();
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

    public boolean update(Connection conn, Inventory inventory) throws SQLException {
        if (inventory.getInventoryID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setInventoryParams(ps, inventory);
            ps.setInt(4, inventory.getInventoryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Inventory> inventorys) throws SQLException {
        if (inventorys == null || inventorys.isEmpty())
            return new int[0];
        for (Inventory inventory : inventorys) {
            if (inventory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (inventory.getInventoryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Inventory>> batches = chunkList(inventorys, batchSize);
        int[] totalResults = new int[inventorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Inventory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Inventory inventory : batch) {
                        setInventoryParams(ps, inventory);
                        ps.setInt(4, inventory.getInventoryID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_INVENTORY_ID, placeholders);
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

    public List<Inventory> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<Inventory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Inventory> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<Inventory> list = new ArrayList<>();
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

    private void setInventoryParams(PreparedStatement ps, Inventory inventory) throws SQLException {
        if (inventory.getFilm() != null) {
            ps.setObject(1, inventory.getFilm().getFilmID(), Types.INTEGER);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (inventory.getStore() != null) {
            ps.setObject(2, inventory.getStore().getStoreID(), Types.INTEGER);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.time.LocalDateTime val3 = inventory.getLastUpdate();
        if (val3 != null) {
            ps.setObject(3, java.sql.Timestamp.valueOf(val3), Types.TIMESTAMP);
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
    }

    private Inventory extract(ResultSet rs) throws SQLException {
        Inventory inventory = new Inventory();
        Integer inventory_id = rs.getObject(COL_INVENTORY_ID, Integer.class);
        inventory.setInventoryID(inventory_id);
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        inventory.setFilmID(film_id);
        if (film_id != null) {
            Film film = new Film();
            film.setFilmID(film_id);
            inventory.setFilm(film);
        }
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        inventory.setStoreID(store_id);
        if (store_id != null) {
            Store store = new Store();
            store.setStoreID(store_id);
            inventory.setStore(store);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            inventory.setLastUpdate(last_update.toLocalDateTime());
        return inventory;
    }
}
