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

public class JdbcFgProductWfTaskQueueDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductWfTaskQueueDao.class);

    private static final String TABLE = "FG_PRODUCT_WF_TASK_QUEUE";

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

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_ENTITY_CODE = "ENTITY_CODE";

    private static final String COL_ENTITY_NAME = "ENTITY_NAME";

    private static final String COL_ACTION_CODE = "ACTION_CODE";

    private static final String COL_ACTION_REASON_CODE = "ACTION_REASON_CODE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_PERF_PARTY_CODE = "PERF_PARTY_CODE";

    private static final String COL_PERF_USER_CODE = "PERF_USER_CODE";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_CONFIG_STATUS_CODE = "CONFIG_STATUS_CODE";

    private static final String COL_ENTITY_ID = "ENTITY_ID";

    private static final String COL_ENTITY_ACTION_CODE = "ENTITY_ACTION_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_TASK_ID = "TASK_ID";

    private static final String COL_TASK_NAME = "TASK_NAME";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_GROUP_ID = "GROUP_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ENTITY_REF_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_VERSION_ID, COL_ENTITY_CODE, COL_ENTITY_NAME, COL_ACTION_CODE, COL_ACTION_REASON_CODE, COL_APPLICANT_PARTY, COL_PERF_PARTY_CODE, COL_PERF_USER_CODE, COL_CATEGORY_CODE, COL_CONFIG_STATUS_CODE, COL_ENTITY_ID, COL_ENTITY_ACTION_CODE, COL_PROCESS_ID, COL_TASK_ID, COL_TASK_NAME, COL_LAYOUT_NAME, COL_GROUP_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_VERSION_ID, ENTITY_CODE, ENTITY_NAME, ACTION_CODE, ACTION_REASON_CODE, APPLICANT_PARTY, PERF_PARTY_CODE, PERF_USER_CODE, CATEGORY_CODE, CONFIG_STATUS_CODE, ENTITY_ID, ENTITY_ACTION_CODE, PROCESS_ID, TASK_ID, TASK_NAME, LAYOUT_NAME, GROUP_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_VERSION_ID, ENTITY_CODE, ENTITY_NAME, ACTION_CODE, ACTION_REASON_CODE, APPLICANT_PARTY, PERF_PARTY_CODE, PERF_USER_CODE, CATEGORY_CODE, CONFIG_STATUS_CODE, ENTITY_ID, ENTITY_ACTION_CODE, PROCESS_ID, TASK_ID, TASK_NAME, LAYOUT_NAME, GROUP_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ENTITY_REF_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_VERSION_ID, COL_ENTITY_CODE, COL_ENTITY_NAME, COL_ACTION_CODE, COL_ACTION_REASON_CODE, COL_APPLICANT_PARTY, COL_PERF_PARTY_CODE, COL_PERF_USER_CODE, COL_CATEGORY_CODE, COL_CONFIG_STATUS_CODE, COL_ENTITY_ID, COL_ENTITY_ACTION_CODE, COL_PROCESS_ID, COL_TASK_ID, COL_TASK_NAME, COL_LAYOUT_NAME, COL_GROUP_ID, COL_ID);

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

    public int insert(Connection conn, FgProductWfTaskQueue fgproductwftaskqueue) throws SQLException {
        logger.debug("Inserting fgproductwftaskqueue: {}", fgproductwftaskqueue);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductWfTaskQueueParams(ps, fgproductwftaskqueue);
            ps.executeUpdate();
            return fgproductwftaskqueue.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductWfTaskQueue> fgproductwftaskqueues) throws SQLException {
        if (fgproductwftaskqueues == null || fgproductwftaskqueues.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductwftaskqueues.size(); i++) {
            if (fgproductwftaskqueues.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductWfTaskQueue>> batches = chunkList(fgproductwftaskqueues, batchSize);
        int[] totalResults = new int[fgproductwftaskqueues.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductWfTaskQueue> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductWfTaskQueue fgproductwftaskqueue : batch) {
                        setFgProductWfTaskQueueParams(ps, fgproductwftaskqueue);
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

    public FgProductWfTaskQueue findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductWfTaskQueue> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductWfTaskQueue> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductWfTaskQueue fgproductwftaskqueue) throws SQLException {
        if (fgproductwftaskqueue.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductWfTaskQueueParams(ps, fgproductwftaskqueue);
            ps.setInt(35, fgproductwftaskqueue.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductWfTaskQueue> fgproductwftaskqueues) throws SQLException {
        if (fgproductwftaskqueues == null || fgproductwftaskqueues.isEmpty())
            return new int[0];
        for (FgProductWfTaskQueue fgproductwftaskqueue : fgproductwftaskqueues) {
            if (fgproductwftaskqueue == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductwftaskqueue.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductWfTaskQueue>> batches = chunkList(fgproductwftaskqueues, batchSize);
        int[] totalResults = new int[fgproductwftaskqueues.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductWfTaskQueue> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductWfTaskQueue fgproductwftaskqueue : batch) {
                        setFgProductWfTaskQueueParams(ps, fgproductwftaskqueue);
                        ps.setInt(35, fgproductwftaskqueue.getID());
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

    private void setFgProductWfTaskQueueParams(PreparedStatement ps, FgProductWfTaskQueue fgproductwftaskqueue) throws SQLException {
        Integer val1 = fgproductwftaskqueue.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproductwftaskqueue.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgproductwftaskqueue.getTypeCode());
        ps.setString(4, fgproductwftaskqueue.getSubTypeCode());
        ps.setString(5, fgproductwftaskqueue.getActiveCode());
        ps.setString(6, fgproductwftaskqueue.getStageCode());
        ps.setString(7, fgproductwftaskqueue.getStatusCode());
        ps.setString(8, fgproductwftaskqueue.getCreatedOn());
        java.math.BigDecimal val9 = fgproductwftaskqueue.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgproductwftaskqueue.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgproductwftaskqueue.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgproductwftaskqueue.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgproductwftaskqueue.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductwftaskqueue.getTemplate());
        java.math.BigDecimal val15 = fgproductwftaskqueue.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgproductwftaskqueue.getEntityRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, fgproductwftaskqueue.getEntityTypeCode());
        ps.setString(18, fgproductwftaskqueue.getEntitySubTypeCode());
        Integer val19 = fgproductwftaskqueue.getEntityVersionID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgproductwftaskqueue.getEntityCode());
        ps.setString(21, fgproductwftaskqueue.getEntityName());
        ps.setString(22, fgproductwftaskqueue.getActionCode());
        ps.setString(23, fgproductwftaskqueue.getActionReasonCode());
        ps.setString(24, fgproductwftaskqueue.getApplicantParty());
        ps.setString(25, fgproductwftaskqueue.getPerfPartyCode());
        ps.setString(26, fgproductwftaskqueue.getPerfUserCode());
        ps.setString(27, fgproductwftaskqueue.getCategoryCode());
        ps.setString(28, fgproductwftaskqueue.getConfigStatusCode());
        Integer val29 = fgproductwftaskqueue.getEntityID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgproductwftaskqueue.getEntityActionCode());
        Integer val31 = fgproductwftaskqueue.getProcessID();
        if (val31 != null) {
            ps.setInt(31, val31);
        } else {
            ps.setNull(31, Types.INTEGER);
        }
        Integer val32 = fgproductwftaskqueue.getTaskID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        ps.setString(33, fgproductwftaskqueue.getTaskName());
        ps.setString(34, fgproductwftaskqueue.getLayoutName());
        Integer val35 = fgproductwftaskqueue.getGroupID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
    }

    private FgProductWfTaskQueue extract(ResultSet rs) throws SQLException {
        FgProductWfTaskQueue fgproductwftaskqueue = new FgProductWfTaskQueue();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductwftaskqueue.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgproductwftaskqueue.setReferenceID(REFERENCE_ID);
        fgproductwftaskqueue.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgproductwftaskqueue.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgproductwftaskqueue.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductwftaskqueue.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductwftaskqueue.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductwftaskqueue.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductwftaskqueue.setCreatedBy(CREATED_BY);
        fgproductwftaskqueue.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductwftaskqueue.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductwftaskqueue.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductwftaskqueue.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductwftaskqueue.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgproductwftaskqueue.setIsTemplate(IS_TEMPLATE);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductwftaskqueue.setEntityRefID(ENTITY_REF_ID);
        fgproductwftaskqueue.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductwftaskqueue.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgproductwftaskqueue.setEntityVersionID(ENTITY_VERSION_ID);
        fgproductwftaskqueue.setEntityCode(rs.getString(COL_ENTITY_CODE));
        fgproductwftaskqueue.setEntityName(rs.getString(COL_ENTITY_NAME));
        fgproductwftaskqueue.setActionCode(rs.getString(COL_ACTION_CODE));
        fgproductwftaskqueue.setActionReasonCode(rs.getString(COL_ACTION_REASON_CODE));
        fgproductwftaskqueue.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgproductwftaskqueue.setPerfPartyCode(rs.getString(COL_PERF_PARTY_CODE));
        fgproductwftaskqueue.setPerfUserCode(rs.getString(COL_PERF_USER_CODE));
        fgproductwftaskqueue.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgproductwftaskqueue.setConfigStatusCode(rs.getString(COL_CONFIG_STATUS_CODE));
        Integer ENTITY_ID = rs.getObject(COL_ENTITY_ID, Integer.class);
        fgproductwftaskqueue.setEntityID(ENTITY_ID);
        fgproductwftaskqueue.setEntityActionCode(rs.getString(COL_ENTITY_ACTION_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgproductwftaskqueue.setProcessID(PROCESS_ID);
        Integer TASK_ID = rs.getObject(COL_TASK_ID, Integer.class);
        fgproductwftaskqueue.setTaskID(TASK_ID);
        fgproductwftaskqueue.setTaskName(rs.getString(COL_TASK_NAME));
        fgproductwftaskqueue.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer GROUP_ID = rs.getObject(COL_GROUP_ID, Integer.class);
        fgproductwftaskqueue.setGroupID(GROUP_ID);
        return fgproductwftaskqueue;
    }
}
