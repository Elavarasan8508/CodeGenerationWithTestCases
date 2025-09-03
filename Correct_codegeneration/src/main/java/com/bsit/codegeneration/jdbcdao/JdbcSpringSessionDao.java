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
import java.math.BigDecimal;

public class JdbcSpringSessionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcSpringSessionDao.class);

    private static final String TABLE = "SPRING_SESSION";

    private static final String COL_PRIMARY_ID = "PRIMARY_ID";

    private static final String COL_SESSION_ID = "SESSION_ID";

    private static final String COL_CREATION_TIME = "CREATION_TIME";

    private static final String COL_LAST_ACCESS_TIME = "LAST_ACCESS_TIME";

    private static final String COL_MAX_INACTIVE_INTERVAL = "MAX_INACTIVE_INTERVAL";

    private static final String COL_EXPIRY_TIME = "EXPIRY_TIME";

    private static final String COL_PRINCIPAL_NAME = "PRINCIPAL_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_PRIMARY_ID, COL_SESSION_ID, COL_CREATION_TIME, COL_LAST_ACCESS_TIME, COL_MAX_INACTIVE_INTERVAL, COL_EXPIRY_TIME, COL_PRINCIPAL_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME", TABLE, COL_PRIMARY_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME", TABLE, COL_PRIMARY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SESSION_ID, COL_CREATION_TIME, COL_LAST_ACCESS_TIME, COL_MAX_INACTIVE_INTERVAL, COL_EXPIRY_TIME, COL_PRINCIPAL_NAME, COL_PRIMARY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PRIMARY_ID);

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

    public int insert(Connection conn, SpringSession springsession) throws SQLException {
        logger.debug("Inserting springsession: {}", springsession);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setSpringSessionParams(ps, springsession);
            ps.executeUpdate();
            return springsession.getPrimaryID();
        }
    }

    public int[] insertAll(Connection conn, List<SpringSession> springsessions) throws SQLException {
        if (springsessions == null || springsessions.isEmpty())
            return new int[0];
        for (int i = 0; i < springsessions.size(); i++) {
            if (springsessions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<SpringSession>> batches = chunkList(springsessions, batchSize);
        int[] totalResults = new int[springsessions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<SpringSession> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (SpringSession springsession : batch) {
                        setSpringSessionParams(ps, springsession);
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

    public SpringSession findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<SpringSession> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<SpringSession> list = new ArrayList<>();
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

    public boolean update(Connection conn, SpringSession springsession) throws SQLException {
        if (springsession.getPrimaryID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setSpringSessionParams(ps, springsession);
            ps.setInt(7, springsession.getPrimaryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<SpringSession> springsessions) throws SQLException {
        if (springsessions == null || springsessions.isEmpty())
            return new int[0];
        for (SpringSession springsession : springsessions) {
            if (springsession == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (springsession.getPrimaryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<SpringSession>> batches = chunkList(springsessions, batchSize);
        int[] totalResults = new int[springsessions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<SpringSession> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (SpringSession springsession : batch) {
                        setSpringSessionParams(ps, springsession);
                        ps.setInt(7, springsession.getPrimaryID());
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
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Integer> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PRIMARY_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
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

    private void setSpringSessionParams(PreparedStatement ps, SpringSession springsession) throws SQLException {
        Integer val1 = springsession.getPrimaryID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = springsession.getSessionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.math.BigDecimal val3 = springsession.getCreationTime();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = springsession.getLastAccessTime();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = springsession.getMaxInactiveInterval();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = springsession.getExpiryTime();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, springsession.getPrincipalName());
    }

    private SpringSession extract(ResultSet rs) throws SQLException {
        SpringSession springsession = new SpringSession();
        Integer PRIMARY_ID = rs.getObject(COL_PRIMARY_ID, Integer.class);
        springsession.setPrimaryID(PRIMARY_ID);
        Integer SESSION_ID = rs.getObject(COL_SESSION_ID, Integer.class);
        springsession.setSessionID(SESSION_ID);
        java.math.BigDecimal CREATION_TIME = rs.getObject(COL_CREATION_TIME, java.math.BigDecimal.class);
        springsession.setCreationTime(CREATION_TIME);
        java.math.BigDecimal LAST_ACCESS_TIME = rs.getObject(COL_LAST_ACCESS_TIME, java.math.BigDecimal.class);
        springsession.setLastAccessTime(LAST_ACCESS_TIME);
        java.math.BigDecimal MAX_INACTIVE_INTERVAL = rs.getObject(COL_MAX_INACTIVE_INTERVAL, java.math.BigDecimal.class);
        springsession.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
        java.math.BigDecimal EXPIRY_TIME = rs.getObject(COL_EXPIRY_TIME, java.math.BigDecimal.class);
        springsession.setExpiryTime(EXPIRY_TIME);
        springsession.setPrincipalName(rs.getString(COL_PRINCIPAL_NAME));
        return springsession;
    }
}
