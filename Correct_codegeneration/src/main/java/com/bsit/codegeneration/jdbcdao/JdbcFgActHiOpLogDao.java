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

public class JdbcFgActHiOpLogDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiOpLogDao.class);

    private static final String TABLE = "FG_ACT_HI_OP_LOG";

    private static final String COL_ID_ = "ID_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_EXECUTION_ID_ = "CASE_EXECUTION_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_JOB_ID_ = "JOB_ID_";

    private static final String COL_JOB_DEF_ID_ = "JOB_DEF_ID_";

    private static final String COL_BATCH_ID_ = "BATCH_ID_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_TIMESTAMP_ = "TIMESTAMP_";

    private static final String COL_OPERATION_TYPE_ = "OPERATION_TYPE_";

    private static final String COL_OPERATION_ID_ = "OPERATION_ID_";

    private static final String COL_ENTITY_TYPE_ = "ENTITY_TYPE_";

    private static final String COL_PROPERTY_ = "PROPERTY_";

    private static final String COL_ORG_VALUE_ = "ORG_VALUE_";

    private static final String COL_NEW_VALUE_ = "NEW_VALUE_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String COL_CATEGORY_ = "CATEGORY_";

    private static final String COL_EXTERNAL_TASK_ID_ = "EXTERNAL_TASK_ID_";

    private static final String COL_ANNOTATION_ = "ANNOTATION_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_DEPLOYMENT_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_TASK_ID_, COL_JOB_ID_, COL_JOB_DEF_ID_, COL_BATCH_ID_, COL_USER_ID_, COL_TIMESTAMP_, COL_OPERATION_TYPE_, COL_OPERATION_ID_, COL_ENTITY_TYPE_, COL_PROPERTY_, COL_ORG_VALUE_, COL_NEW_VALUE_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_CATEGORY_, COL_EXTERNAL_TASK_ID_, COL_ANNOTATION_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, DEPLOYMENT_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, JOB_ID_, JOB_DEF_ID_, BATCH_ID_, USER_ID_, TIMESTAMP_, OPERATION_TYPE_, OPERATION_ID_, ENTITY_TYPE_, PROPERTY_, ORG_VALUE_, NEW_VALUE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, CATEGORY_, EXTERNAL_TASK_ID_, ANNOTATION_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, DEPLOYMENT_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, JOB_ID_, JOB_DEF_ID_, BATCH_ID_, USER_ID_, TIMESTAMP_, OPERATION_TYPE_, OPERATION_ID_, ENTITY_TYPE_, PROPERTY_, ORG_VALUE_, NEW_VALUE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, CATEGORY_, EXTERNAL_TASK_ID_, ANNOTATION_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DEPLOYMENT_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_TASK_ID_, COL_JOB_ID_, COL_JOB_DEF_ID_, COL_BATCH_ID_, COL_USER_ID_, COL_TIMESTAMP_, COL_OPERATION_TYPE_, COL_OPERATION_ID_, COL_ENTITY_TYPE_, COL_PROPERTY_, COL_ORG_VALUE_, COL_NEW_VALUE_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_CATEGORY_, COL_EXTERNAL_TASK_ID_, COL_ANNOTATION_, COL_ID_);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID_);

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

    public String insert(Connection conn, FgActHiOpLog fgacthioplog) throws SQLException {
        logger.debug("Inserting fgacthioplog: {}", fgacthioplog);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiOpLogParams(ps, fgacthioplog);
            ps.executeUpdate();
            return fgacthioplog.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiOpLog> fgacthioplogs) throws SQLException {
        if (fgacthioplogs == null || fgacthioplogs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthioplogs.size(); i++) {
            if (fgacthioplogs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiOpLog>> batches = chunkList(fgacthioplogs, batchSize);
        int[] totalResults = new int[fgacthioplogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiOpLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiOpLog fgacthioplog : batch) {
                        setFgActHiOpLogParams(ps, fgacthioplog);
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

    public FgActHiOpLog findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiOpLog> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiOpLog> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiOpLog fgacthioplog) throws SQLException {
        if (fgacthioplog.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiOpLogParams(ps, fgacthioplog);
            ps.setString(27, fgacthioplog.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiOpLog> fgacthioplogs) throws SQLException {
        if (fgacthioplogs == null || fgacthioplogs.isEmpty())
            return new int[0];
        for (FgActHiOpLog fgacthioplog : fgacthioplogs) {
            if (fgacthioplog == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthioplog.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiOpLog>> batches = chunkList(fgacthioplogs, batchSize);
        int[] totalResults = new int[fgacthioplogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiOpLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiOpLog fgacthioplog : batch) {
                        setFgActHiOpLogParams(ps, fgacthioplog);
                        ps.setString(27, fgacthioplog.getID_());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID_, placeholders);
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

    private void setFgActHiOpLogParams(PreparedStatement ps, FgActHiOpLog fgacthioplog) throws SQLException {
        ps.setString(1, fgacthioplog.getID_());
        ps.setString(2, fgacthioplog.getDeploymentID_());
        ps.setString(3, fgacthioplog.getProcDefID_());
        ps.setString(4, fgacthioplog.getProcDefKey_());
        ps.setString(5, fgacthioplog.getProcInstID_());
        ps.setString(6, fgacthioplog.getExecutionID_());
        ps.setString(7, fgacthioplog.getCaseDefID_());
        ps.setString(8, fgacthioplog.getCaseInstID_());
        ps.setString(9, fgacthioplog.getCaseExecutionID_());
        ps.setString(10, fgacthioplog.getTaskID_());
        ps.setString(11, fgacthioplog.getJobID_());
        ps.setString(12, fgacthioplog.getJobDefID_());
        ps.setString(13, fgacthioplog.getBatchID_());
        ps.setString(14, fgacthioplog.getUserID_());
        ps.setString(15, fgacthioplog.getTimestamp_());
        ps.setString(16, fgacthioplog.getOperationType_());
        ps.setString(17, fgacthioplog.getOperationID_());
        ps.setString(18, fgacthioplog.getEntityType_());
        ps.setString(19, fgacthioplog.getProperty_());
        ps.setString(20, fgacthioplog.getOrgValue_());
        ps.setString(21, fgacthioplog.getNewValue_());
        ps.setString(22, fgacthioplog.getTenantID_());
        ps.setString(23, fgacthioplog.getRootProcInstID_());
        ps.setString(24, fgacthioplog.getRemovalTime_());
        ps.setString(25, fgacthioplog.getCategory_());
        ps.setString(26, fgacthioplog.getExternalTaskID_());
        ps.setString(27, fgacthioplog.getAnnotation_());
    }

    private FgActHiOpLog extract(ResultSet rs) throws SQLException {
        FgActHiOpLog fgacthioplog = new FgActHiOpLog();
        fgacthioplog.setID_(rs.getString(COL_ID_));
        fgacthioplog.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        fgacthioplog.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthioplog.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthioplog.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthioplog.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthioplog.setCaseDefID_(rs.getString(COL_CASE_DEF_ID_));
        fgacthioplog.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthioplog.setCaseExecutionID_(rs.getString(COL_CASE_EXECUTION_ID_));
        fgacthioplog.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthioplog.setJobID_(rs.getString(COL_JOB_ID_));
        fgacthioplog.setJobDefID_(rs.getString(COL_JOB_DEF_ID_));
        fgacthioplog.setBatchID_(rs.getString(COL_BATCH_ID_));
        fgacthioplog.setUserID_(rs.getString(COL_USER_ID_));
        fgacthioplog.setTimestamp_(rs.getString(COL_TIMESTAMP_));
        fgacthioplog.setOperationType_(rs.getString(COL_OPERATION_TYPE_));
        fgacthioplog.setOperationID_(rs.getString(COL_OPERATION_ID_));
        fgacthioplog.setEntityType_(rs.getString(COL_ENTITY_TYPE_));
        fgacthioplog.setProperty_(rs.getString(COL_PROPERTY_));
        fgacthioplog.setOrgValue_(rs.getString(COL_ORG_VALUE_));
        fgacthioplog.setNewValue_(rs.getString(COL_NEW_VALUE_));
        fgacthioplog.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthioplog.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthioplog.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        fgacthioplog.setCategory_(rs.getString(COL_CATEGORY_));
        fgacthioplog.setExternalTaskID_(rs.getString(COL_EXTERNAL_TASK_ID_));
        fgacthioplog.setAnnotation_(rs.getString(COL_ANNOTATION_));
        return fgacthioplog;
    }
}
