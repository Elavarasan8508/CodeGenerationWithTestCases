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

public class JdbcFgActRuExtTaskDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuExtTaskDao.class);

    private static final String TABLE = "FG_ACT_RU_EXT_TASK";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_WORKER_ID_ = "WORKER_ID_";

    private static final String COL_TOPIC_NAME_ = "TOPIC_NAME_";

    private static final String COL_RETRIES_ = "RETRIES_";

    private static final String COL_ERROR_MSG_ = "ERROR_MSG_";

    private static final String COL_ERROR_DETAILS_ID_ = "ERROR_DETAILS_ID_";

    private static final String COL_LOCK_EXP_TIME_ = "LOCK_EXP_TIME_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_PRIORITY_ = "PRIORITY_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_WORKER_ID_, COL_TOPIC_NAME_, COL_RETRIES_, COL_ERROR_MSG_, COL_ERROR_DETAILS_ID_, COL_LOCK_EXP_TIME_, COL_SUSPENSION_STATE_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_TENANT_ID_, COL_PRIORITY_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_", TABLE, COL_ID_);

    private static final String SELECT_BY_ERROR_DETAILS_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_", TABLE, COL_ERROR_DETAILS_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_WORKER_ID_, COL_TOPIC_NAME_, COL_RETRIES_, COL_ERROR_MSG_, COL_ERROR_DETAILS_ID_, COL_LOCK_EXP_TIME_, COL_SUSPENSION_STATE_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_TENANT_ID_, COL_PRIORITY_, COL_ID_);

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

    public String insert(Connection conn, FgActRuExtTask fgactruexttask) throws SQLException {
        logger.debug("Inserting fgactruexttask: {}", fgactruexttask);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuExtTaskParams(ps, fgactruexttask);
            ps.executeUpdate();
            return fgactruexttask.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuExtTask> fgactruexttasks) throws SQLException {
        if (fgactruexttasks == null || fgactruexttasks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruexttasks.size(); i++) {
            if (fgactruexttasks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuExtTask>> batches = chunkList(fgactruexttasks, batchSize);
        int[] totalResults = new int[fgactruexttasks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuExtTask> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuExtTask fgactruexttask : batch) {
                        setFgActRuExtTaskParams(ps, fgactruexttask);
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

    public FgActRuExtTask findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuExtTask> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuExtTask> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuExtTask fgactruexttask) throws SQLException {
        if (fgactruexttask.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuExtTaskParams(ps, fgactruexttask);
            ps.setString(17, fgactruexttask.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuExtTask> fgactruexttasks) throws SQLException {
        if (fgactruexttasks == null || fgactruexttasks.isEmpty())
            return new int[0];
        for (FgActRuExtTask fgactruexttask : fgactruexttasks) {
            if (fgactruexttask == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruexttask.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuExtTask>> batches = chunkList(fgactruexttasks, batchSize);
        int[] totalResults = new int[fgactruexttasks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuExtTask> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuExtTask fgactruexttask : batch) {
                        setFgActRuExtTaskParams(ps, fgactruexttask);
                        ps.setString(17, fgactruexttask.getID_());
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

    public List<FgActRuExtTask> findByErrorDetailsID_(Connection conn, String errorDetailsID_) throws SQLException {
        List<FgActRuExtTask> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ERROR_DETAILS_ID__SQL)) {
            ps.setString(1, errorDetailsID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuExtTaskParams(PreparedStatement ps, FgActRuExtTask fgactruexttask) throws SQLException {
        ps.setString(1, fgactruexttask.getID_());
        java.math.BigDecimal val2 = fgactruexttask.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactruexttask.getWorkerID_());
        ps.setString(4, fgactruexttask.getTopicName_());
        java.math.BigDecimal val5 = fgactruexttask.getRetries_();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, fgactruexttask.getErrorMsg_());
        if (fgactruexttask.getErrorDetailsID_() != null) {
            ps.setString(7, fgactruexttask.getErrorDetailsID_().getFgActGeBytearrayID());
        } else {
            ps.setNull(7, Types.VARCHAR);
        }
        ps.setString(8, fgactruexttask.getLockExpTime_());
        java.math.BigDecimal val9 = fgactruexttask.getSuspensionState_();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgactruexttask.getExecutionID_());
        ps.setString(11, fgactruexttask.getProcInstID_());
        ps.setString(12, fgactruexttask.getProcDefID_());
        ps.setString(13, fgactruexttask.getProcDefKey_());
        ps.setString(14, fgactruexttask.getActID_());
        ps.setString(15, fgactruexttask.getActInstID_());
        ps.setString(16, fgactruexttask.getTenantID_());
        java.math.BigDecimal val17 = fgactruexttask.getPriority_();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
    }

    private FgActRuExtTask extract(ResultSet rs) throws SQLException {
        FgActRuExtTask fgactruexttask = new FgActRuExtTask();
        fgactruexttask.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruexttask.setRev_(REV_);
        fgactruexttask.setWorkerID_(rs.getString(COL_WORKER_ID_));
        fgactruexttask.setTopicName_(rs.getString(COL_TOPIC_NAME_));
        java.math.BigDecimal RETRIES_ = rs.getObject(COL_RETRIES_, java.math.BigDecimal.class);
        fgactruexttask.setRetries_(RETRIES_);
        fgactruexttask.setErrorMsg_(rs.getString(COL_ERROR_MSG_));
        String ERROR_DETAILS_ID_ = rs.getObject(COL_ERROR_DETAILS_ID_, String.class);
        fgactruexttask.setErrorDetailsID_(ERROR_DETAILS_ID_);
        if (ERROR_DETAILS_ID_ != null) {
            FgActGeBytearray errorDetailsID_ = new FgActGeBytearray();
            errorDetailsID_.setFgActGeBytearrayID(ERROR_DETAILS_ID_);
            fgactruexttask.setErrorDetailsID_(errorDetailsID_);
        }
        fgactruexttask.setLockExpTime_(rs.getString(COL_LOCK_EXP_TIME_));
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactruexttask.setSuspensionState_(SUSPENSION_STATE_);
        fgactruexttask.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactruexttask.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgactruexttask.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgactruexttask.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgactruexttask.setActID_(rs.getString(COL_ACT_ID_));
        fgactruexttask.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        fgactruexttask.setTenantID_(rs.getString(COL_TENANT_ID_));
        java.math.BigDecimal PRIORITY_ = rs.getObject(COL_PRIORITY_, java.math.BigDecimal.class);
        fgactruexttask.setPriority_(PRIORITY_);
        return fgactruexttask;
    }
}
