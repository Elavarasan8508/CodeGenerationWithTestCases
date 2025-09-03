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

public class JdbcFgStateTransitionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgStateTransitionDao.class);

    private static final String TABLE = "FG_STATE_TRANSITION";

    private static final String COL_ID = "ID";

    private static final String COL_ACTION_CODE = "ACTION_CODE";

    private static final String COL_ACTION_NAME = "ACTION_NAME";

    private static final String COL_START_STATE_CODE = "START_STATE_CODE";

    private static final String COL_TARGET_STATE_CODE = "TARGET_STATE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ACTION_CODE, COL_ACTION_NAME, COL_START_STATE_CODE, COL_TARGET_STATE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ACTION_CODE, ACTION_NAME, START_STATE_CODE, TARGET_STATE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ACTION_CODE, ACTION_NAME, START_STATE_CODE, TARGET_STATE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ACTION_CODE, COL_ACTION_NAME, COL_START_STATE_CODE, COL_TARGET_STATE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID);

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

    public int insert(Connection conn, FgStateTransition fgstatetransition) throws SQLException {
        logger.debug("Inserting fgstatetransition: {}", fgstatetransition);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgStateTransitionParams(ps, fgstatetransition);
            ps.executeUpdate();
            return fgstatetransition.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgStateTransition> fgstatetransitions) throws SQLException {
        if (fgstatetransitions == null || fgstatetransitions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgstatetransitions.size(); i++) {
            if (fgstatetransitions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgStateTransition>> batches = chunkList(fgstatetransitions, batchSize);
        int[] totalResults = new int[fgstatetransitions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgStateTransition> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgStateTransition fgstatetransition : batch) {
                        setFgStateTransitionParams(ps, fgstatetransition);
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

    public FgStateTransition findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgStateTransition> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgStateTransition> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgStateTransition fgstatetransition) throws SQLException {
        if (fgstatetransition.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgStateTransitionParams(ps, fgstatetransition);
            ps.setInt(13, fgstatetransition.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgStateTransition> fgstatetransitions) throws SQLException {
        if (fgstatetransitions == null || fgstatetransitions.isEmpty())
            return new int[0];
        for (FgStateTransition fgstatetransition : fgstatetransitions) {
            if (fgstatetransition == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgstatetransition.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgStateTransition>> batches = chunkList(fgstatetransitions, batchSize);
        int[] totalResults = new int[fgstatetransitions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgStateTransition> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgStateTransition fgstatetransition : batch) {
                        setFgStateTransitionParams(ps, fgstatetransition);
                        ps.setInt(13, fgstatetransition.getID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID, placeholders);
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

    private void setFgStateTransitionParams(PreparedStatement ps, FgStateTransition fgstatetransition) throws SQLException {
        Integer val1 = fgstatetransition.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgstatetransition.getActionCode());
        ps.setString(3, fgstatetransition.getActionName());
        ps.setString(4, fgstatetransition.getStartStateCode());
        ps.setString(5, fgstatetransition.getTargetStateCode());
        ps.setString(6, fgstatetransition.getActiveCode());
        ps.setString(7, fgstatetransition.getStatusCode());
        java.math.BigDecimal val8 = fgstatetransition.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgstatetransition.getCreatedOn());
        java.math.BigDecimal val10 = fgstatetransition.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgstatetransition.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgstatetransition.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgstatetransition.getLastAuthorisedOn());
    }

    private FgStateTransition extract(ResultSet rs) throws SQLException {
        FgStateTransition fgstatetransition = new FgStateTransition();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgstatetransition.setID(ID);
        fgstatetransition.setActionCode(rs.getString(COL_ACTION_CODE));
        fgstatetransition.setActionName(rs.getString(COL_ACTION_NAME));
        fgstatetransition.setStartStateCode(rs.getString(COL_START_STATE_CODE));
        fgstatetransition.setTargetStateCode(rs.getString(COL_TARGET_STATE_CODE));
        fgstatetransition.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgstatetransition.setStatusCode(rs.getString(COL_STATUS_CODE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgstatetransition.setCreatedBy(CREATED_BY);
        fgstatetransition.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgstatetransition.setLastUpdatedBy(LAST_UPDATED_BY);
        fgstatetransition.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgstatetransition.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgstatetransition.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgstatetransition;
    }
}
