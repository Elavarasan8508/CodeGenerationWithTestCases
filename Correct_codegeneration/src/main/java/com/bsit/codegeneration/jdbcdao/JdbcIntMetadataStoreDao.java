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

public class JdbcIntMetadataStoreDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcIntMetadataStoreDao.class);

    private static final String TABLE = "INT_METADATA_STORE";

    private static final String COL_METADATA_KEY = "METADATA_KEY";

    private static final String COL_METADATA_VALUE = "METADATA_VALUE";

    private static final String COL_REGION = "REGION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_METADATA_KEY, COL_METADATA_VALUE, COL_REGION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("METADATA_KEY, METADATA_VALUE, REGION", TABLE, COL_METADATA_KEY);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("METADATA_KEY, METADATA_VALUE, REGION", TABLE, COL_METADATA_KEY);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_METADATA_VALUE, COL_REGION, COL_METADATA_KEY);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_METADATA_KEY);

    private static String getDbVendor(Connection conn) throws SQLException {
        String dbName = conn.getMetaData().getDatabaseProductName().toLowerCase();
        if (dbName.contains("oracle"))
            return "oracle";
        if (dbName.contains("postgres"))
            return "postgres";
        return "other";
    }

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public String insert(Connection conn, IntMetadataStore intmetadatastore) throws SQLException {
        logger.debug("Inserting intmetadatastore: {}", intmetadatastore);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setIntMetadataStoreParams(ps, intmetadatastore);
            ps.executeUpdate();
            return intmetadatastore.getMetadataKey();
        }
    }

    public int[] insertAll(Connection conn, List<IntMetadataStore> intmetadatastores) throws SQLException {
        if (intmetadatastores == null || intmetadatastores.isEmpty())
            return new int[0];
        for (int i = 0; i < intmetadatastores.size(); i++) {
            if (intmetadatastores.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IntMetadataStore>> batches = chunkList(intmetadatastores, batchSize);
        int[] totalResults = new int[intmetadatastores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IntMetadataStore> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (IntMetadataStore intmetadatastore : batch) {
                        setIntMetadataStoreParams(ps, intmetadatastore);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch insert failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public IntMetadataStore findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<IntMetadataStore> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<IntMetadataStore> list = new ArrayList<>();
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        String sql = SELECT_ALL_BASE;
        if (isOracle)
            sql += " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        else
            sql += " LIMIT ? OFFSET ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (isOracle) {
                ps.setInt(1, (page - 1) * pageSize);
                ps.setInt(2, pageSize);
            } else {
                ps.setInt(1, pageSize);
                ps.setInt(2, (page - 1) * pageSize);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, IntMetadataStore intmetadatastore) throws SQLException {
        if (intmetadatastore.getMetadataKey() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setIntMetadataStoreParams(ps, intmetadatastore);
            ps.setString(3, intmetadatastore.getMetadataKey());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<IntMetadataStore> intmetadatastores) throws SQLException {
        if (intmetadatastores == null || intmetadatastores.isEmpty())
            return new int[0];
        for (IntMetadataStore intmetadatastore : intmetadatastores) {
            if (intmetadatastore == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (intmetadatastore.getMetadataKey() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IntMetadataStore>> batches = chunkList(intmetadatastores, batchSize);
        int[] totalResults = new int[intmetadatastores.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IntMetadataStore> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (IntMetadataStore intmetadatastore : batch) {
                        setIntMetadataStoreParams(ps, intmetadatastore);
                        ps.setString(3, intmetadatastore.getMetadataKey());
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch update failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public boolean deleteById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<String> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (String id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<String>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<String> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_METADATA_KEY, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setString(i + 1, chunk.get(i));
                    }
                    int affected = ps.executeUpdate();
                    for (int j = 0; j < affected; j++) {
                        totalResults[resultIndex++] = 1;
                    }
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch delete failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private void setIntMetadataStoreParams(PreparedStatement ps, IntMetadataStore intmetadatastore) throws SQLException {
        ps.setString(1, intmetadatastore.getMetadataKey());
        ps.setString(2, intmetadatastore.getMetadataValue());
        ps.setString(3, intmetadatastore.getRegion());
    }

    private IntMetadataStore extract(ResultSet rs) throws SQLException {
        IntMetadataStore intmetadatastore = new IntMetadataStore();
        intmetadatastore.setMetadataKey(rs.getString(COL_METADATA_KEY));
        intmetadatastore.setMetadataValue(rs.getString(COL_METADATA_VALUE));
        intmetadatastore.setRegion(rs.getString(COL_REGION));
        return intmetadatastore;
    }
}
