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

public class JdbcFgProductWfActHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductWfActHistoryDao.class);

    private static final String TABLE = "FG_PRODUCT_WF_ACT_HISTORY";

    private static final String COL_WF_PROCESS_ID = "WF_PROCESS_ID";

    private static final String COL_WF_DEFINITION_ID = "WF_DEFINITION_ID";

    private static final String COL_WF_ACTIVITY_ID = "WF_ACTIVITY_ID";

    private static final String COL_WF_ACTIVITY_TYPE_CODE = "WF_ACTIVITY_TYPE_CODE";

    private static final String COL_PERF_PARTY_CODE = "PERF_PARTY_CODE";

    private static final String COL_PERF_PARTY_USER_CODE = "PERF_PARTY_USER_CODE";

    private static final String COL_WF_ACTIVITY_START_DATE = "WF_ACTIVITY_START_DATE";

    private static final String COL_WF_ACTIVITY_END_DATE = "WF_ACTIVITY_END_DATE";

    private static final String COL_WF_ACTIVITY_RESULT_CODE = "WF_ACTIVITY_RESULT_CODE";

    private static final String COL_WF_ACTIVITY_ACTION_CODE = "WF_ACTIVITY_ACTION_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_MESSAGE = "MESSAGE";

    private static final String COL_WF_TASK_NAME = "WF_TASK_NAME";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ID = "ID";

    private static final String COL_TASK_CONSENT = "TASK_CONSENT";

    private static final String COL_IS_TASK_CONSENT = "IS_TASK_CONSENT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_WF_PROCESS_ID, COL_WF_DEFINITION_ID, COL_WF_ACTIVITY_ID, COL_WF_ACTIVITY_TYPE_CODE, COL_PERF_PARTY_CODE, COL_PERF_PARTY_USER_CODE, COL_WF_ACTIVITY_START_DATE, COL_WF_ACTIVITY_END_DATE, COL_WF_ACTIVITY_RESULT_CODE, COL_WF_ACTIVITY_ACTION_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_STAGE_CODE, COL_MESSAGE, COL_WF_TASK_NAME, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ID, COL_TASK_CONSENT, COL_IS_TASK_CONSENT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("WF_PROCESS_ID, WF_DEFINITION_ID, WF_ACTIVITY_ID, WF_ACTIVITY_TYPE_CODE, PERF_PARTY_CODE, PERF_PARTY_USER_CODE, WF_ACTIVITY_START_DATE, WF_ACTIVITY_END_DATE, WF_ACTIVITY_RESULT_CODE, WF_ACTIVITY_ACTION_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, STAGE_CODE, MESSAGE, WF_TASK_NAME, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ID, TASK_CONSENT, IS_TASK_CONSENT", TABLE, COL_WF_PROCESS_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("WF_PROCESS_ID, WF_DEFINITION_ID, WF_ACTIVITY_ID, WF_ACTIVITY_TYPE_CODE, PERF_PARTY_CODE, PERF_PARTY_USER_CODE, WF_ACTIVITY_START_DATE, WF_ACTIVITY_END_DATE, WF_ACTIVITY_RESULT_CODE, WF_ACTIVITY_ACTION_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, STAGE_CODE, MESSAGE, WF_TASK_NAME, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ID, TASK_CONSENT, IS_TASK_CONSENT", TABLE, COL_WF_PROCESS_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_WF_DEFINITION_ID, COL_WF_ACTIVITY_ID, COL_WF_ACTIVITY_TYPE_CODE, COL_PERF_PARTY_CODE, COL_PERF_PARTY_USER_CODE, COL_WF_ACTIVITY_START_DATE, COL_WF_ACTIVITY_END_DATE, COL_WF_ACTIVITY_RESULT_CODE, COL_WF_ACTIVITY_ACTION_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_STAGE_CODE, COL_MESSAGE, COL_WF_TASK_NAME, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ID, COL_TASK_CONSENT, COL_IS_TASK_CONSENT, COL_WF_PROCESS_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_WF_PROCESS_ID);

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

    public int insert(Connection conn, FgProductWfActHistory fgproductwfacthistory) throws SQLException {
        logger.debug("Inserting fgproductwfacthistory: {}", fgproductwfacthistory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductWfActHistoryParams(ps, fgproductwfacthistory);
            ps.executeUpdate();
            return fgproductwfacthistory.getWfProcessID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductWfActHistory> fgproductwfacthistorys) throws SQLException {
        if (fgproductwfacthistorys == null || fgproductwfacthistorys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductwfacthistorys.size(); i++) {
            if (fgproductwfacthistorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductWfActHistory>> batches = chunkList(fgproductwfacthistorys, batchSize);
        int[] totalResults = new int[fgproductwfacthistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductWfActHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductWfActHistory fgproductwfacthistory : batch) {
                        setFgProductWfActHistoryParams(ps, fgproductwfacthistory);
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

    public FgProductWfActHistory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductWfActHistory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductWfActHistory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductWfActHistory fgproductwfacthistory) throws SQLException {
        if (fgproductwfacthistory.getWfProcessID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductWfActHistoryParams(ps, fgproductwfacthistory);
            ps.setInt(28, fgproductwfacthistory.getWfProcessID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductWfActHistory> fgproductwfacthistorys) throws SQLException {
        if (fgproductwfacthistorys == null || fgproductwfacthistorys.isEmpty())
            return new int[0];
        for (FgProductWfActHistory fgproductwfacthistory : fgproductwfacthistorys) {
            if (fgproductwfacthistory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductwfacthistory.getWfProcessID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductWfActHistory>> batches = chunkList(fgproductwfacthistorys, batchSize);
        int[] totalResults = new int[fgproductwfacthistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductWfActHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductWfActHistory fgproductwfacthistory : batch) {
                        setFgProductWfActHistoryParams(ps, fgproductwfacthistory);
                        ps.setInt(28, fgproductwfacthistory.getWfProcessID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_WF_PROCESS_ID, placeholders);
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

    private void setFgProductWfActHistoryParams(PreparedStatement ps, FgProductWfActHistory fgproductwfacthistory) throws SQLException {
        Integer val1 = fgproductwfacthistory.getWfProcessID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproductwfacthistory.getWfDefinitionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgproductwfacthistory.getWfActivityID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgproductwfacthistory.getWfActivityTypeCode());
        ps.setString(5, fgproductwfacthistory.getPerfPartyCode());
        ps.setString(6, fgproductwfacthistory.getPerfPartyUserCode());
        ps.setString(7, fgproductwfacthistory.getWfActivityStartDate());
        ps.setString(8, fgproductwfacthistory.getWfActivityEndDate());
        ps.setString(9, fgproductwfacthistory.getWfActivityResultCode());
        ps.setString(10, fgproductwfacthistory.getWfActivityActionCode());
        ps.setString(11, fgproductwfacthistory.getActiveCode());
        ps.setString(12, fgproductwfacthistory.getStatusCode());
        java.math.BigDecimal val13 = fgproductwfacthistory.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductwfacthistory.getCreatedOn());
        java.math.BigDecimal val15 = fgproductwfacthistory.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgproductwfacthistory.getLastUpdatedOn());
        java.math.BigDecimal val17 = fgproductwfacthistory.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgproductwfacthistory.getLastAuthorisedOn());
        ps.setString(19, fgproductwfacthistory.getStageCode());
        ps.setString(20, fgproductwfacthistory.getMessage());
        ps.setString(21, fgproductwfacthistory.getWfTaskName());
        Integer val22 = fgproductwfacthistory.getEntityRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = fgproductwfacthistory.getEntityVersionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, fgproductwfacthistory.getEntityTypeCode());
        ps.setString(25, fgproductwfacthistory.getEntitySubTypeCode());
        Integer val26 = fgproductwfacthistory.getID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, fgproductwfacthistory.getTaskConsent());
        java.math.BigDecimal val28 = fgproductwfacthistory.getIsTaskConsent();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
    }

    private FgProductWfActHistory extract(ResultSet rs) throws SQLException {
        FgProductWfActHistory fgproductwfacthistory = new FgProductWfActHistory();
        Integer WF_PROCESS_ID = rs.getObject(COL_WF_PROCESS_ID, Integer.class);
        fgproductwfacthistory.setWfProcessID(WF_PROCESS_ID);
        Integer WF_DEFINITION_ID = rs.getObject(COL_WF_DEFINITION_ID, Integer.class);
        fgproductwfacthistory.setWfDefinitionID(WF_DEFINITION_ID);
        Integer WF_ACTIVITY_ID = rs.getObject(COL_WF_ACTIVITY_ID, Integer.class);
        fgproductwfacthistory.setWfActivityID(WF_ACTIVITY_ID);
        fgproductwfacthistory.setWfActivityTypeCode(rs.getString(COL_WF_ACTIVITY_TYPE_CODE));
        fgproductwfacthistory.setPerfPartyCode(rs.getString(COL_PERF_PARTY_CODE));
        fgproductwfacthistory.setPerfPartyUserCode(rs.getString(COL_PERF_PARTY_USER_CODE));
        fgproductwfacthistory.setWfActivityStartDate(rs.getString(COL_WF_ACTIVITY_START_DATE));
        fgproductwfacthistory.setWfActivityEndDate(rs.getString(COL_WF_ACTIVITY_END_DATE));
        fgproductwfacthistory.setWfActivityResultCode(rs.getString(COL_WF_ACTIVITY_RESULT_CODE));
        fgproductwfacthistory.setWfActivityActionCode(rs.getString(COL_WF_ACTIVITY_ACTION_CODE));
        fgproductwfacthistory.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductwfacthistory.setStatusCode(rs.getString(COL_STATUS_CODE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductwfacthistory.setCreatedBy(CREATED_BY);
        fgproductwfacthistory.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductwfacthistory.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductwfacthistory.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductwfacthistory.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductwfacthistory.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        fgproductwfacthistory.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductwfacthistory.setMessage(rs.getString(COL_MESSAGE));
        fgproductwfacthistory.setWfTaskName(rs.getString(COL_WF_TASK_NAME));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductwfacthistory.setEntityRefID(ENTITY_REF_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgproductwfacthistory.setEntityVersionID(ENTITY_VERSION_ID);
        fgproductwfacthistory.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductwfacthistory.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductwfacthistory.setID(ID);
        fgproductwfacthistory.setTaskConsent(rs.getString(COL_TASK_CONSENT));
        java.math.BigDecimal IS_TASK_CONSENT = rs.getObject(COL_IS_TASK_CONSENT, java.math.BigDecimal.class);
        fgproductwfacthistory.setIsTaskConsent(IS_TASK_CONSENT);
        return fgproductwfacthistory;
    }
}
