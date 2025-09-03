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

public class JdbcFgActHiExtTaskLogDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiExtTaskLogDao.class);

    private static final String TABLE = "FG_ACT_HI_EXT_TASK_LOG";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TIMESTAMP_ = "TIMESTAMP_";

    private static final String COL_EXT_TASK_ID_ = "EXT_TASK_ID_";

    private static final String COL_RETRIES_ = "RETRIES_";

    private static final String COL_TOPIC_NAME_ = "TOPIC_NAME_";

    private static final String COL_WORKER_ID_ = "WORKER_ID_";

    private static final String COL_PRIORITY_ = "PRIORITY_";

    private static final String COL_ERROR_MSG_ = "ERROR_MSG_";

    private static final String COL_ERROR_DETAILS_ID_ = "ERROR_DETAILS_ID_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_STATE_ = "STATE_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TIMESTAMP_, COL_EXT_TASK_ID_, COL_RETRIES_, COL_TOPIC_NAME_, COL_WORKER_ID_, COL_PRIORITY_, COL_ERROR_MSG_, COL_ERROR_DETAILS_ID_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_TENANT_ID_, COL_STATE_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TIMESTAMP_, EXT_TASK_ID_, RETRIES_, TOPIC_NAME_, WORKER_ID_, PRIORITY_, ERROR_MSG_, ERROR_DETAILS_ID_, ACT_ID_, ACT_INST_ID_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TIMESTAMP_, EXT_TASK_ID_, RETRIES_, TOPIC_NAME_, WORKER_ID_, PRIORITY_, ERROR_MSG_, ERROR_DETAILS_ID_, ACT_ID_, ACT_INST_ID_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TIMESTAMP_, COL_EXT_TASK_ID_, COL_RETRIES_, COL_TOPIC_NAME_, COL_WORKER_ID_, COL_PRIORITY_, COL_ERROR_MSG_, COL_ERROR_DETAILS_ID_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_TENANT_ID_, COL_STATE_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiExtTaskLog fgacthiexttasklog) throws SQLException {
        logger.debug("Inserting fgacthiexttasklog: {}", fgacthiexttasklog);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiExtTaskLogParams(ps, fgacthiexttasklog);
            ps.executeUpdate();
            return fgacthiexttasklog.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiExtTaskLog> fgacthiexttasklogs) throws SQLException {
        if (fgacthiexttasklogs == null || fgacthiexttasklogs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthiexttasklogs.size(); i++) {
            if (fgacthiexttasklogs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiExtTaskLog>> batches = chunkList(fgacthiexttasklogs, batchSize);
        int[] totalResults = new int[fgacthiexttasklogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiExtTaskLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiExtTaskLog fgacthiexttasklog : batch) {
                        setFgActHiExtTaskLogParams(ps, fgacthiexttasklog);
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

    public FgActHiExtTaskLog findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiExtTaskLog> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiExtTaskLog> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiExtTaskLog fgacthiexttasklog) throws SQLException {
        if (fgacthiexttasklog.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiExtTaskLogParams(ps, fgacthiexttasklog);
            ps.setString(19, fgacthiexttasklog.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiExtTaskLog> fgacthiexttasklogs) throws SQLException {
        if (fgacthiexttasklogs == null || fgacthiexttasklogs.isEmpty())
            return new int[0];
        for (FgActHiExtTaskLog fgacthiexttasklog : fgacthiexttasklogs) {
            if (fgacthiexttasklog == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthiexttasklog.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiExtTaskLog>> batches = chunkList(fgacthiexttasklogs, batchSize);
        int[] totalResults = new int[fgacthiexttasklogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiExtTaskLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiExtTaskLog fgacthiexttasklog : batch) {
                        setFgActHiExtTaskLogParams(ps, fgacthiexttasklog);
                        ps.setString(19, fgacthiexttasklog.getID_());
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

    private void setFgActHiExtTaskLogParams(PreparedStatement ps, FgActHiExtTaskLog fgacthiexttasklog) throws SQLException {
        ps.setString(1, fgacthiexttasklog.getID_());
        ps.setString(2, fgacthiexttasklog.getTimestamp_());
        ps.setString(3, fgacthiexttasklog.getExtTaskID_());
        java.math.BigDecimal val4 = fgacthiexttasklog.getRetries_();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        ps.setString(5, fgacthiexttasklog.getTopicName_());
        ps.setString(6, fgacthiexttasklog.getWorkerID_());
        java.math.BigDecimal val7 = fgacthiexttasklog.getPriority_();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgacthiexttasklog.getErrorMsg_());
        ps.setString(9, fgacthiexttasklog.getErrorDetailsID_());
        ps.setString(10, fgacthiexttasklog.getActID_());
        ps.setString(11, fgacthiexttasklog.getActInstID_());
        ps.setString(12, fgacthiexttasklog.getExecutionID_());
        ps.setString(13, fgacthiexttasklog.getProcInstID_());
        ps.setString(14, fgacthiexttasklog.getProcDefID_());
        ps.setString(15, fgacthiexttasklog.getProcDefKey_());
        ps.setString(16, fgacthiexttasklog.getTenantID_());
        java.math.BigDecimal val17 = fgacthiexttasklog.getState_();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgacthiexttasklog.getRootProcInstID_());
        ps.setString(19, fgacthiexttasklog.getRemovalTime_());
    }

    private FgActHiExtTaskLog extract(ResultSet rs) throws SQLException {
        FgActHiExtTaskLog fgacthiexttasklog = new FgActHiExtTaskLog();
        fgacthiexttasklog.setID_(rs.getString(COL_ID_));
        fgacthiexttasklog.setTimestamp_(rs.getString(COL_TIMESTAMP_));
        fgacthiexttasklog.setExtTaskID_(rs.getString(COL_EXT_TASK_ID_));
        java.math.BigDecimal RETRIES_ = rs.getObject(COL_RETRIES_, java.math.BigDecimal.class);
        fgacthiexttasklog.setRetries_(RETRIES_);
        fgacthiexttasklog.setTopicName_(rs.getString(COL_TOPIC_NAME_));
        fgacthiexttasklog.setWorkerID_(rs.getString(COL_WORKER_ID_));
        java.math.BigDecimal PRIORITY_ = rs.getObject(COL_PRIORITY_, java.math.BigDecimal.class);
        fgacthiexttasklog.setPriority_(PRIORITY_);
        fgacthiexttasklog.setErrorMsg_(rs.getString(COL_ERROR_MSG_));
        fgacthiexttasklog.setErrorDetailsID_(rs.getString(COL_ERROR_DETAILS_ID_));
        fgacthiexttasklog.setActID_(rs.getString(COL_ACT_ID_));
        fgacthiexttasklog.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        fgacthiexttasklog.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthiexttasklog.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthiexttasklog.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthiexttasklog.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthiexttasklog.setTenantID_(rs.getString(COL_TENANT_ID_));
        java.math.BigDecimal STATE_ = rs.getObject(COL_STATE_, java.math.BigDecimal.class);
        fgacthiexttasklog.setState_(STATE_);
        fgacthiexttasklog.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthiexttasklog.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthiexttasklog;
    }
}
