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

public class JdbcFgProductEntityLockDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductEntityLockDao.class);

    private static final String TABLE = "FG_PRODUCT_ENTITY_LOCK";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_USER_CODE = "USER_CODE";

    private static final String COL_ORG_CODE = "ORG_CODE";

    private static final String COL_ENTITY_VERSION = "ENTITY_VERSION";

    private static final String COL_ATTEMPT_COUNT = "ATTEMPT_COUNT";

    private static final String COL_ACTION_CODE = "ACTION_CODE";

    private static final String COL_LOCK_TIME = "LOCK_TIME";

    private static final String COL_EXPIRY_TIME = "EXPIRY_TIME";

    private static final String COL_USER_ROLE = "USER_ROLE";

    private static final String COL_LOCK_COUNT = "LOCK_COUNT";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_REFERENCE_ID = "ENTITY_REFERENCE_ID";

    private static final String COL_RESEND_ATTEMPT_COUNT = "RESEND_ATTEMPT_COUNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_USER_CODE, COL_ORG_CODE, COL_ENTITY_VERSION, COL_ATTEMPT_COUNT, COL_ACTION_CODE, COL_LOCK_TIME, COL_EXPIRY_TIME, COL_USER_ROLE, COL_LOCK_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID, COL_RESEND_ATTEMPT_COUNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, USER_CODE, ORG_CODE, ENTITY_VERSION, ATTEMPT_COUNT, ACTION_CODE, LOCK_TIME, EXPIRY_TIME, USER_ROLE, LOCK_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, RESEND_ATTEMPT_COUNT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, USER_CODE, ORG_CODE, ENTITY_VERSION, ATTEMPT_COUNT, ACTION_CODE, LOCK_TIME, EXPIRY_TIME, USER_ROLE, LOCK_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, RESEND_ATTEMPT_COUNT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_USER_CODE, COL_ORG_CODE, COL_ENTITY_VERSION, COL_ATTEMPT_COUNT, COL_ACTION_CODE, COL_LOCK_TIME, COL_EXPIRY_TIME, COL_USER_ROLE, COL_LOCK_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID, COL_RESEND_ATTEMPT_COUNT, COL_ID);

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

    public int insert(Connection conn, FgProductEntityLock fgproductentitylock) throws SQLException {
        logger.debug("Inserting fgproductentitylock: {}", fgproductentitylock);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductEntityLockParams(ps, fgproductentitylock);
            ps.executeUpdate();
            return fgproductentitylock.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductEntityLock> fgproductentitylocks) throws SQLException {
        if (fgproductentitylocks == null || fgproductentitylocks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductentitylocks.size(); i++) {
            if (fgproductentitylocks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductEntityLock>> batches = chunkList(fgproductentitylocks, batchSize);
        int[] totalResults = new int[fgproductentitylocks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductEntityLock> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductEntityLock fgproductentitylock : batch) {
                        setFgProductEntityLockParams(ps, fgproductentitylock);
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

    public FgProductEntityLock findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductEntityLock> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductEntityLock> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductEntityLock fgproductentitylock) throws SQLException {
        if (fgproductentitylock.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductEntityLockParams(ps, fgproductentitylock);
            ps.setInt(28, fgproductentitylock.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductEntityLock> fgproductentitylocks) throws SQLException {
        if (fgproductentitylocks == null || fgproductentitylocks.isEmpty())
            return new int[0];
        for (FgProductEntityLock fgproductentitylock : fgproductentitylocks) {
            if (fgproductentitylock == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductentitylock.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductEntityLock>> batches = chunkList(fgproductentitylocks, batchSize);
        int[] totalResults = new int[fgproductentitylocks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductEntityLock> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductEntityLock fgproductentitylock : batch) {
                        setFgProductEntityLockParams(ps, fgproductentitylock);
                        ps.setInt(28, fgproductentitylock.getID());
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

    private void setFgProductEntityLockParams(PreparedStatement ps, FgProductEntityLock fgproductentitylock) throws SQLException {
        Integer val1 = fgproductentitylock.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproductentitylock.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgproductentitylock.getTypeCode());
        ps.setString(4, fgproductentitylock.getSubTypeCode());
        ps.setString(5, fgproductentitylock.getActiveCode());
        ps.setString(6, fgproductentitylock.getStageCode());
        ps.setString(7, fgproductentitylock.getStatusCode());
        ps.setString(8, fgproductentitylock.getCreatedOn());
        java.math.BigDecimal val9 = fgproductentitylock.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgproductentitylock.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgproductentitylock.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgproductentitylock.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgproductentitylock.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductentitylock.getTemplate());
        java.math.BigDecimal val15 = fgproductentitylock.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgproductentitylock.getUserCode());
        ps.setString(17, fgproductentitylock.getOrgCode());
        java.math.BigDecimal val18 = fgproductentitylock.getEntityVersion();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgproductentitylock.getAttemptCount();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgproductentitylock.getActionCode());
        ps.setString(21, fgproductentitylock.getLockTime());
        ps.setString(22, fgproductentitylock.getExpiryTime());
        ps.setString(23, fgproductentitylock.getUserRole());
        java.math.BigDecimal val24 = fgproductentitylock.getLockCount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgproductentitylock.getEntityTypeCode());
        ps.setString(26, fgproductentitylock.getEntitySubTypeCode());
        Integer val27 = fgproductentitylock.getEntityReferenceID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = fgproductentitylock.getResendAttemptCount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
    }

    private FgProductEntityLock extract(ResultSet rs) throws SQLException {
        FgProductEntityLock fgproductentitylock = new FgProductEntityLock();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductentitylock.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgproductentitylock.setReferenceID(REFERENCE_ID);
        fgproductentitylock.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgproductentitylock.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgproductentitylock.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductentitylock.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductentitylock.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductentitylock.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductentitylock.setCreatedBy(CREATED_BY);
        fgproductentitylock.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductentitylock.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductentitylock.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductentitylock.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductentitylock.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgproductentitylock.setIsTemplate(IS_TEMPLATE);
        fgproductentitylock.setUserCode(rs.getString(COL_USER_CODE));
        fgproductentitylock.setOrgCode(rs.getString(COL_ORG_CODE));
        java.math.BigDecimal ENTITY_VERSION = rs.getObject(COL_ENTITY_VERSION, java.math.BigDecimal.class);
        fgproductentitylock.setEntityVersion(ENTITY_VERSION);
        java.math.BigDecimal ATTEMPT_COUNT = rs.getObject(COL_ATTEMPT_COUNT, java.math.BigDecimal.class);
        fgproductentitylock.setAttemptCount(ATTEMPT_COUNT);
        fgproductentitylock.setActionCode(rs.getString(COL_ACTION_CODE));
        fgproductentitylock.setLockTime(rs.getString(COL_LOCK_TIME));
        fgproductentitylock.setExpiryTime(rs.getString(COL_EXPIRY_TIME));
        fgproductentitylock.setUserRole(rs.getString(COL_USER_ROLE));
        java.math.BigDecimal LOCK_COUNT = rs.getObject(COL_LOCK_COUNT, java.math.BigDecimal.class);
        fgproductentitylock.setLockCount(LOCK_COUNT);
        fgproductentitylock.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductentitylock.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ENTITY_REFERENCE_ID = rs.getObject(COL_ENTITY_REFERENCE_ID, Integer.class);
        fgproductentitylock.setEntityReferenceID(ENTITY_REFERENCE_ID);
        java.math.BigDecimal RESEND_ATTEMPT_COUNT = rs.getObject(COL_RESEND_ATTEMPT_COUNT, java.math.BigDecimal.class);
        fgproductentitylock.setResendAttemptCount(RESEND_ATTEMPT_COUNT);
        return fgproductentitylock;
    }
}
