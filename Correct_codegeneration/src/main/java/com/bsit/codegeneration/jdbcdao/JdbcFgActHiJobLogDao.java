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

public class JdbcFgActHiJobLogDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiJobLogDao.class);

    private static final String TABLE = "FG_ACT_HI_JOB_LOG";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TIMESTAMP_ = "TIMESTAMP_";

    private static final String COL_JOB_ID_ = "JOB_ID_";

    private static final String COL_JOB_DUEDATE_ = "JOB_DUEDATE_";

    private static final String COL_JOB_RETRIES_ = "JOB_RETRIES_";

    private static final String COL_JOB_PRIORITY_ = "JOB_PRIORITY_";

    private static final String COL_JOB_EXCEPTION_MSG_ = "JOB_EXCEPTION_MSG_";

    private static final String COL_JOB_EXCEPTION_STACK_ID_ = "JOB_EXCEPTION_STACK_ID_";

    private static final String COL_JOB_STATE_ = "JOB_STATE_";

    private static final String COL_JOB_DEF_ID_ = "JOB_DEF_ID_";

    private static final String COL_JOB_DEF_TYPE_ = "JOB_DEF_TYPE_";

    private static final String COL_JOB_DEF_CONFIGURATION_ = "JOB_DEF_CONFIGURATION_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROCESS_INSTANCE_ID_ = "PROCESS_INSTANCE_ID_";

    private static final String COL_PROCESS_DEF_ID_ = "PROCESS_DEF_ID_";

    private static final String COL_PROCESS_DEF_KEY_ = "PROCESS_DEF_KEY_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String COL_HOSTNAME_ = "HOSTNAME_";

    private static final String COL_FAILED_ACT_ID_ = "FAILED_ACT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TIMESTAMP_, COL_JOB_ID_, COL_JOB_DUEDATE_, COL_JOB_RETRIES_, COL_JOB_PRIORITY_, COL_JOB_EXCEPTION_MSG_, COL_JOB_EXCEPTION_STACK_ID_, COL_JOB_STATE_, COL_JOB_DEF_ID_, COL_JOB_DEF_TYPE_, COL_JOB_DEF_CONFIGURATION_, COL_ACT_ID_, COL_EXECUTION_ID_, COL_PROCESS_INSTANCE_ID_, COL_PROCESS_DEF_ID_, COL_PROCESS_DEF_KEY_, COL_DEPLOYMENT_ID_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_HOSTNAME_, COL_FAILED_ACT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TIMESTAMP_, JOB_ID_, JOB_DUEDATE_, JOB_RETRIES_, JOB_PRIORITY_, JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_, JOB_STATE_, JOB_DEF_ID_, JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_, ACT_ID_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, DEPLOYMENT_ID_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HOSTNAME_, FAILED_ACT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TIMESTAMP_, JOB_ID_, JOB_DUEDATE_, JOB_RETRIES_, JOB_PRIORITY_, JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_, JOB_STATE_, JOB_DEF_ID_, JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_, ACT_ID_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, DEPLOYMENT_ID_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HOSTNAME_, FAILED_ACT_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TIMESTAMP_, COL_JOB_ID_, COL_JOB_DUEDATE_, COL_JOB_RETRIES_, COL_JOB_PRIORITY_, COL_JOB_EXCEPTION_MSG_, COL_JOB_EXCEPTION_STACK_ID_, COL_JOB_STATE_, COL_JOB_DEF_ID_, COL_JOB_DEF_TYPE_, COL_JOB_DEF_CONFIGURATION_, COL_ACT_ID_, COL_EXECUTION_ID_, COL_PROCESS_INSTANCE_ID_, COL_PROCESS_DEF_ID_, COL_PROCESS_DEF_KEY_, COL_DEPLOYMENT_ID_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_HOSTNAME_, COL_FAILED_ACT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActHiJobLog fgacthijoblog) throws SQLException {
        logger.debug("Inserting fgacthijoblog: {}", fgacthijoblog);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiJobLogParams(ps, fgacthijoblog);
            ps.executeUpdate();
            return fgacthijoblog.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiJobLog> fgacthijoblogs) throws SQLException {
        if (fgacthijoblogs == null || fgacthijoblogs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthijoblogs.size(); i++) {
            if (fgacthijoblogs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiJobLog>> batches = chunkList(fgacthijoblogs, batchSize);
        int[] totalResults = new int[fgacthijoblogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiJobLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiJobLog fgacthijoblog : batch) {
                        setFgActHiJobLogParams(ps, fgacthijoblog);
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

    public FgActHiJobLog findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiJobLog> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiJobLog> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiJobLog fgacthijoblog) throws SQLException {
        if (fgacthijoblog.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiJobLogParams(ps, fgacthijoblog);
            ps.setString(24, fgacthijoblog.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiJobLog> fgacthijoblogs) throws SQLException {
        if (fgacthijoblogs == null || fgacthijoblogs.isEmpty())
            return new int[0];
        for (FgActHiJobLog fgacthijoblog : fgacthijoblogs) {
            if (fgacthijoblog == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthijoblog.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiJobLog>> batches = chunkList(fgacthijoblogs, batchSize);
        int[] totalResults = new int[fgacthijoblogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiJobLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiJobLog fgacthijoblog : batch) {
                        setFgActHiJobLogParams(ps, fgacthijoblog);
                        ps.setString(24, fgacthijoblog.getID_());
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

    private void setFgActHiJobLogParams(PreparedStatement ps, FgActHiJobLog fgacthijoblog) throws SQLException {
        ps.setString(1, fgacthijoblog.getID_());
        ps.setString(2, fgacthijoblog.getTimestamp_());
        ps.setString(3, fgacthijoblog.getJobID_());
        ps.setString(4, fgacthijoblog.getJobDuedate_());
        java.math.BigDecimal val5 = fgacthijoblog.getJobRetries_();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = fgacthijoblog.getJobPriority_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgacthijoblog.getJobExceptionMsg_());
        ps.setString(8, fgacthijoblog.getJobExceptionStackID_());
        java.math.BigDecimal val9 = fgacthijoblog.getJobState_();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgacthijoblog.getJobDefID_());
        ps.setString(11, fgacthijoblog.getJobDefType_());
        ps.setString(12, fgacthijoblog.getJobDefConfiguration_());
        ps.setString(13, fgacthijoblog.getActID_());
        ps.setString(14, fgacthijoblog.getExecutionID_());
        ps.setString(15, fgacthijoblog.getProcessInstanceID_());
        ps.setString(16, fgacthijoblog.getProcessDefID_());
        ps.setString(17, fgacthijoblog.getProcessDefKey_());
        ps.setString(18, fgacthijoblog.getDeploymentID_());
        java.math.BigDecimal val19 = fgacthijoblog.getSequenceCounter_();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgacthijoblog.getTenantID_());
        ps.setString(21, fgacthijoblog.getRootProcInstID_());
        ps.setString(22, fgacthijoblog.getRemovalTime_());
        ps.setString(23, fgacthijoblog.getHostname_());
        ps.setString(24, fgacthijoblog.getFailedActID_());
    }

    private FgActHiJobLog extract(ResultSet rs) throws SQLException {
        FgActHiJobLog fgacthijoblog = new FgActHiJobLog();
        fgacthijoblog.setID_(rs.getString(COL_ID_));
        fgacthijoblog.setTimestamp_(rs.getString(COL_TIMESTAMP_));
        fgacthijoblog.setJobID_(rs.getString(COL_JOB_ID_));
        fgacthijoblog.setJobDuedate_(rs.getString(COL_JOB_DUEDATE_));
        java.math.BigDecimal JOB_RETRIES_ = rs.getObject(COL_JOB_RETRIES_, java.math.BigDecimal.class);
        fgacthijoblog.setJobRetries_(JOB_RETRIES_);
        java.math.BigDecimal JOB_PRIORITY_ = rs.getObject(COL_JOB_PRIORITY_, java.math.BigDecimal.class);
        fgacthijoblog.setJobPriority_(JOB_PRIORITY_);
        fgacthijoblog.setJobExceptionMsg_(rs.getString(COL_JOB_EXCEPTION_MSG_));
        fgacthijoblog.setJobExceptionStackID_(rs.getString(COL_JOB_EXCEPTION_STACK_ID_));
        java.math.BigDecimal JOB_STATE_ = rs.getObject(COL_JOB_STATE_, java.math.BigDecimal.class);
        fgacthijoblog.setJobState_(JOB_STATE_);
        fgacthijoblog.setJobDefID_(rs.getString(COL_JOB_DEF_ID_));
        fgacthijoblog.setJobDefType_(rs.getString(COL_JOB_DEF_TYPE_));
        fgacthijoblog.setJobDefConfiguration_(rs.getString(COL_JOB_DEF_CONFIGURATION_));
        fgacthijoblog.setActID_(rs.getString(COL_ACT_ID_));
        fgacthijoblog.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthijoblog.setProcessInstanceID_(rs.getString(COL_PROCESS_INSTANCE_ID_));
        fgacthijoblog.setProcessDefID_(rs.getString(COL_PROCESS_DEF_ID_));
        fgacthijoblog.setProcessDefKey_(rs.getString(COL_PROCESS_DEF_KEY_));
        fgacthijoblog.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgacthijoblog.setSequenceCounter_(SEQUENCE_COUNTER_);
        fgacthijoblog.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthijoblog.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthijoblog.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        fgacthijoblog.setHostname_(rs.getString(COL_HOSTNAME_));
        fgacthijoblog.setFailedActID_(rs.getString(COL_FAILED_ACT_ID_));
        return fgacthijoblog;
    }
}
