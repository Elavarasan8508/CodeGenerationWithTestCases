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

public class JdbcFgActRuJobDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuJobDao.class);

    private static final String TABLE = "FG_ACT_RU_JOB";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_LOCK_EXP_TIME_ = "LOCK_EXP_TIME_";

    private static final String COL_LOCK_OWNER_ = "LOCK_OWNER_";

    private static final String COL_EXCLUSIVE_ = "EXCLUSIVE_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROCESS_INSTANCE_ID_ = "PROCESS_INSTANCE_ID_";

    private static final String COL_PROCESS_DEF_ID_ = "PROCESS_DEF_ID_";

    private static final String COL_PROCESS_DEF_KEY_ = "PROCESS_DEF_KEY_";

    private static final String COL_RETRIES_ = "RETRIES_";

    private static final String COL_EXCEPTION_STACK_ID_ = "EXCEPTION_STACK_ID_";

    private static final String COL_EXCEPTION_MSG_ = "EXCEPTION_MSG_";

    private static final String COL_DUEDATE_ = "DUEDATE_";

    private static final String COL_REPEAT_ = "REPEAT_";

    private static final String COL_HANDLER_TYPE_ = "HANDLER_TYPE_";

    private static final String COL_HANDLER_CFG_ = "HANDLER_CFG_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_JOB_DEF_ID_ = "JOB_DEF_ID_";

    private static final String COL_PRIORITY_ = "PRIORITY_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_REPEAT_OFFSET_ = "REPEAT_OFFSET_";

    private static final String COL_FAILED_ACT_ID_ = "FAILED_ACT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_TYPE_, COL_LOCK_EXP_TIME_, COL_LOCK_OWNER_, COL_EXCLUSIVE_, COL_EXECUTION_ID_, COL_PROCESS_INSTANCE_ID_, COL_PROCESS_DEF_ID_, COL_PROCESS_DEF_KEY_, COL_RETRIES_, COL_EXCEPTION_STACK_ID_, COL_EXCEPTION_MSG_, COL_DUEDATE_, COL_REPEAT_, COL_HANDLER_TYPE_, COL_HANDLER_CFG_, COL_DEPLOYMENT_ID_, COL_SUSPENSION_STATE_, COL_JOB_DEF_ID_, COL_PRIORITY_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_CREATE_TIME_, COL_REPEAT_OFFSET_, COL_FAILED_ACT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_EXCEPTION_STACK_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_", TABLE, COL_EXCEPTION_STACK_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_TYPE_, COL_LOCK_EXP_TIME_, COL_LOCK_OWNER_, COL_EXCLUSIVE_, COL_EXECUTION_ID_, COL_PROCESS_INSTANCE_ID_, COL_PROCESS_DEF_ID_, COL_PROCESS_DEF_KEY_, COL_RETRIES_, COL_EXCEPTION_STACK_ID_, COL_EXCEPTION_MSG_, COL_DUEDATE_, COL_REPEAT_, COL_HANDLER_TYPE_, COL_HANDLER_CFG_, COL_DEPLOYMENT_ID_, COL_SUSPENSION_STATE_, COL_JOB_DEF_ID_, COL_PRIORITY_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_CREATE_TIME_, COL_REPEAT_OFFSET_, COL_FAILED_ACT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuJob fgactrujob) throws SQLException {
        logger.debug("Inserting fgactrujob: {}", fgactrujob);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuJobParams(ps, fgactrujob);
            ps.executeUpdate();
            return fgactrujob.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuJob> fgactrujobs) throws SQLException {
        if (fgactrujobs == null || fgactrujobs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrujobs.size(); i++) {
            if (fgactrujobs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuJob>> batches = chunkList(fgactrujobs, batchSize);
        int[] totalResults = new int[fgactrujobs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuJob> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuJob fgactrujob : batch) {
                        setFgActRuJobParams(ps, fgactrujob);
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

    public FgActRuJob findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuJob> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuJob> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuJob fgactrujob) throws SQLException {
        if (fgactrujob.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuJobParams(ps, fgactrujob);
            ps.setString(26, fgactrujob.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuJob> fgactrujobs) throws SQLException {
        if (fgactrujobs == null || fgactrujobs.isEmpty())
            return new int[0];
        for (FgActRuJob fgactrujob : fgactrujobs) {
            if (fgactrujob == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrujob.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuJob>> batches = chunkList(fgactrujobs, batchSize);
        int[] totalResults = new int[fgactrujobs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuJob> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuJob fgactrujob : batch) {
                        setFgActRuJobParams(ps, fgactrujob);
                        ps.setString(26, fgactrujob.getID_());
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

    public List<FgActRuJob> findByExceptionStackID_(Connection conn, String exceptionStackID_) throws SQLException {
        List<FgActRuJob> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_EXCEPTION_STACK_ID__SQL)) {
            ps.setString(1, exceptionStackID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuJobParams(PreparedStatement ps, FgActRuJob fgactrujob) throws SQLException {
        ps.setString(1, fgactrujob.getID_());
        java.math.BigDecimal val2 = fgactrujob.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrujob.getType_());
        ps.setString(4, fgactrujob.getLockExpTime_());
        ps.setString(5, fgactrujob.getLockOwner_());
        java.math.BigDecimal val6 = fgactrujob.getExclusive_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgactrujob.getExecutionID_());
        ps.setString(8, fgactrujob.getProcessInstanceID_());
        ps.setString(9, fgactrujob.getProcessDefID_());
        ps.setString(10, fgactrujob.getProcessDefKey_());
        java.math.BigDecimal val11 = fgactrujob.getRetries_();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        if (fgactrujob.getExceptionStackID_() != null) {
            ps.setString(12, fgactrujob.getExceptionStackID_().getFgActGeBytearrayID());
        } else {
            ps.setNull(12, Types.VARCHAR);
        }
        ps.setString(13, fgactrujob.getExceptionMsg_());
        ps.setString(14, fgactrujob.getDuedate_());
        ps.setString(15, fgactrujob.getRepeat_());
        ps.setString(16, fgactrujob.getHandlerType_());
        ps.setString(17, fgactrujob.getHandlerCfg_());
        ps.setString(18, fgactrujob.getDeploymentID_());
        java.math.BigDecimal val19 = fgactrujob.getSuspensionState_();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgactrujob.getJobDefID_());
        java.math.BigDecimal val21 = fgactrujob.getPriority_();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgactrujob.getSequenceCounter_();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgactrujob.getTenantID_());
        ps.setString(24, fgactrujob.getCreateTime_());
        java.math.BigDecimal val25 = fgactrujob.getRepeatOffset_();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgactrujob.getFailedActID_());
    }

    private FgActRuJob extract(ResultSet rs) throws SQLException {
        FgActRuJob fgactrujob = new FgActRuJob();
        fgactrujob.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrujob.setRev_(REV_);
        fgactrujob.setType_(rs.getString(COL_TYPE_));
        fgactrujob.setLockExpTime_(rs.getString(COL_LOCK_EXP_TIME_));
        fgactrujob.setLockOwner_(rs.getString(COL_LOCK_OWNER_));
        java.math.BigDecimal EXCLUSIVE_ = rs.getObject(COL_EXCLUSIVE_, java.math.BigDecimal.class);
        fgactrujob.setExclusive_(EXCLUSIVE_);
        fgactrujob.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactrujob.setProcessInstanceID_(rs.getString(COL_PROCESS_INSTANCE_ID_));
        fgactrujob.setProcessDefID_(rs.getString(COL_PROCESS_DEF_ID_));
        fgactrujob.setProcessDefKey_(rs.getString(COL_PROCESS_DEF_KEY_));
        java.math.BigDecimal RETRIES_ = rs.getObject(COL_RETRIES_, java.math.BigDecimal.class);
        fgactrujob.setRetries_(RETRIES_);
        String EXCEPTION_STACK_ID_ = rs.getObject(COL_EXCEPTION_STACK_ID_, String.class);
        fgactrujob.setExceptionStackID_(EXCEPTION_STACK_ID_);
        if (EXCEPTION_STACK_ID_ != null) {
            FgActGeBytearray exceptionStackID_ = new FgActGeBytearray();
            exceptionStackID_.setFgActGeBytearrayID(EXCEPTION_STACK_ID_);
            fgactrujob.setExceptionStackID_(exceptionStackID_);
        }
        fgactrujob.setExceptionMsg_(rs.getString(COL_EXCEPTION_MSG_));
        fgactrujob.setDuedate_(rs.getString(COL_DUEDATE_));
        fgactrujob.setRepeat_(rs.getString(COL_REPEAT_));
        fgactrujob.setHandlerType_(rs.getString(COL_HANDLER_TYPE_));
        fgactrujob.setHandlerCfg_(rs.getString(COL_HANDLER_CFG_));
        fgactrujob.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactrujob.setSuspensionState_(SUSPENSION_STATE_);
        fgactrujob.setJobDefID_(rs.getString(COL_JOB_DEF_ID_));
        java.math.BigDecimal PRIORITY_ = rs.getObject(COL_PRIORITY_, java.math.BigDecimal.class);
        fgactrujob.setPriority_(PRIORITY_);
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgactrujob.setSequenceCounter_(SEQUENCE_COUNTER_);
        fgactrujob.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactrujob.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        java.math.BigDecimal REPEAT_OFFSET_ = rs.getObject(COL_REPEAT_OFFSET_, java.math.BigDecimal.class);
        fgactrujob.setRepeatOffset_(REPEAT_OFFSET_);
        fgactrujob.setFailedActID_(rs.getString(COL_FAILED_ACT_ID_));
        return fgactrujob;
    }
}
