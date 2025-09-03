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

public class JdbcFgActRuTaskDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuTaskDao.class);

    private static final String TABLE = "FG_ACT_RU_TASK";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_CASE_EXECUTION_ID_ = "CASE_EXECUTION_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_PARENT_TASK_ID_ = "PARENT_TASK_ID_";

    private static final String COL_DESCRIPTION_ = "DESCRIPTION_";

    private static final String COL_TASK_DEF_KEY_ = "TASK_DEF_KEY_";

    private static final String COL_OWNER_ = "OWNER_";

    private static final String COL_ASSIGNEE_ = "ASSIGNEE_";

    private static final String COL_DELEGATION_ = "DELEGATION_";

    private static final String COL_PRIORITY_ = "PRIORITY_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_DUE_DATE_ = "DUE_DATE_";

    private static final String COL_FOLLOW_UP_DATE_ = "FOLLOW_UP_DATE_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_CASE_EXECUTION_ID_, COL_CASE_INST_ID_, COL_CASE_DEF_ID_, COL_NAME_, COL_PARENT_TASK_ID_, COL_DESCRIPTION_, COL_TASK_DEF_KEY_, COL_OWNER_, COL_ASSIGNEE_, COL_DELEGATION_, COL_PRIORITY_, COL_CREATE_TIME_, COL_DUE_DATE_, COL_FOLLOW_UP_DATE_, COL_SUSPENSION_STATE_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_CASE_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_", TABLE, COL_CASE_DEF_ID_);

    private static final String SELECT_BY_CASE_EXECUTION_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_", TABLE, COL_CASE_EXECUTION_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_CASE_EXECUTION_ID_, COL_CASE_INST_ID_, COL_CASE_DEF_ID_, COL_NAME_, COL_PARENT_TASK_ID_, COL_DESCRIPTION_, COL_TASK_DEF_KEY_, COL_OWNER_, COL_ASSIGNEE_, COL_DELEGATION_, COL_PRIORITY_, COL_CREATE_TIME_, COL_DUE_DATE_, COL_FOLLOW_UP_DATE_, COL_SUSPENSION_STATE_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuTask fgactrutask) throws SQLException {
        logger.debug("Inserting fgactrutask: {}", fgactrutask);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuTaskParams(ps, fgactrutask);
            ps.executeUpdate();
            return fgactrutask.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuTask> fgactrutasks) throws SQLException {
        if (fgactrutasks == null || fgactrutasks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrutasks.size(); i++) {
            if (fgactrutasks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuTask>> batches = chunkList(fgactrutasks, batchSize);
        int[] totalResults = new int[fgactrutasks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuTask> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuTask fgactrutask : batch) {
                        setFgActRuTaskParams(ps, fgactrutask);
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

    public FgActRuTask findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuTask> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuTask> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuTask fgactrutask) throws SQLException {
        if (fgactrutask.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuTaskParams(ps, fgactrutask);
            ps.setString(21, fgactrutask.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuTask> fgactrutasks) throws SQLException {
        if (fgactrutasks == null || fgactrutasks.isEmpty())
            return new int[0];
        for (FgActRuTask fgactrutask : fgactrutasks) {
            if (fgactrutask == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrutask.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuTask>> batches = chunkList(fgactrutasks, batchSize);
        int[] totalResults = new int[fgactrutasks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuTask> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuTask fgactrutask : batch) {
                        setFgActRuTaskParams(ps, fgactrutask);
                        ps.setString(21, fgactrutask.getID_());
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

    public List<FgActRuTask> findByCaseDefID_(Connection conn, String caseDefID_) throws SQLException {
        List<FgActRuTask> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CASE_DEF_ID__SQL)) {
            ps.setString(1, caseDefID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuTask> findByCaseExecutionID_(Connection conn, String caseExecutionID_) throws SQLException {
        List<FgActRuTask> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CASE_EXECUTION_ID__SQL)) {
            ps.setString(1, caseExecutionID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuTaskParams(PreparedStatement ps, FgActRuTask fgactrutask) throws SQLException {
        ps.setString(1, fgactrutask.getID_());
        java.math.BigDecimal val2 = fgactrutask.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrutask.getExecutionID_());
        ps.setString(4, fgactrutask.getProcInstID_());
        ps.setString(5, fgactrutask.getProcDefID_());
        if (fgactrutask.getCaseExecutionID_() != null) {
            ps.setString(6, fgactrutask.getCaseExecutionID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(6, Types.VARCHAR);
        }
        ps.setString(7, fgactrutask.getCaseInstID_());
        if (fgactrutask.getCaseDefID_() != null) {
            ps.setString(8, fgactrutask.getCaseDefID_().getFgActReCaseDefID());
        } else {
            ps.setNull(8, Types.VARCHAR);
        }
        ps.setString(9, fgactrutask.getName_());
        ps.setString(10, fgactrutask.getParentTaskID_());
        ps.setString(11, fgactrutask.getDescription_());
        ps.setString(12, fgactrutask.getTaskDefKey_());
        ps.setString(13, fgactrutask.getOwner_());
        ps.setString(14, fgactrutask.getAssignee_());
        ps.setString(15, fgactrutask.getDelegation_());
        java.math.BigDecimal val16 = fgactrutask.getPriority_();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgactrutask.getCreateTime_());
        ps.setString(18, fgactrutask.getDueDate_());
        ps.setString(19, fgactrutask.getFollowUpDate_());
        java.math.BigDecimal val20 = fgactrutask.getSuspensionState_();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgactrutask.getTenantID_());
    }

    private FgActRuTask extract(ResultSet rs) throws SQLException {
        FgActRuTask fgactrutask = new FgActRuTask();
        fgactrutask.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrutask.setRev_(REV_);
        fgactrutask.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactrutask.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgactrutask.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        String CASE_EXECUTION_ID_ = rs.getObject(COL_CASE_EXECUTION_ID_, String.class);
        fgactrutask.setCaseExecutionID_(CASE_EXECUTION_ID_);
        if (CASE_EXECUTION_ID_ != null) {
            FgActRuCaseExecution caseExecutionID_ = new FgActRuCaseExecution();
            caseExecutionID_.setFgActRuCaseExecutionID(CASE_EXECUTION_ID_);
            fgactrutask.setCaseExecutionID_(caseExecutionID_);
        }
        fgactrutask.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        String CASE_DEF_ID_ = rs.getObject(COL_CASE_DEF_ID_, String.class);
        fgactrutask.setCaseDefID_(CASE_DEF_ID_);
        if (CASE_DEF_ID_ != null) {
            FgActReCaseDef caseDefID_ = new FgActReCaseDef();
            caseDefID_.setFgActReCaseDefID(CASE_DEF_ID_);
            fgactrutask.setCaseDefID_(caseDefID_);
        }
        fgactrutask.setName_(rs.getString(COL_NAME_));
        fgactrutask.setParentTaskID_(rs.getString(COL_PARENT_TASK_ID_));
        fgactrutask.setDescription_(rs.getString(COL_DESCRIPTION_));
        fgactrutask.setTaskDefKey_(rs.getString(COL_TASK_DEF_KEY_));
        fgactrutask.setOwner_(rs.getString(COL_OWNER_));
        fgactrutask.setAssignee_(rs.getString(COL_ASSIGNEE_));
        fgactrutask.setDelegation_(rs.getString(COL_DELEGATION_));
        java.math.BigDecimal PRIORITY_ = rs.getObject(COL_PRIORITY_, java.math.BigDecimal.class);
        fgactrutask.setPriority_(PRIORITY_);
        fgactrutask.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        fgactrutask.setDueDate_(rs.getString(COL_DUE_DATE_));
        fgactrutask.setFollowUpDate_(rs.getString(COL_FOLLOW_UP_DATE_));
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactrutask.setSuspensionState_(SUSPENSION_STATE_);
        fgactrutask.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgactrutask;
    }
}
