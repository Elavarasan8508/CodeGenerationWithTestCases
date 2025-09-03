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

public class JdbcFgActHiTaskinstDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiTaskinstDao.class);

    private static final String TABLE = "FG_ACT_HI_TASKINST";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TASK_DEF_KEY_ = "TASK_DEF_KEY_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_CASE_DEF_KEY_ = "CASE_DEF_KEY_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_EXECUTION_ID_ = "CASE_EXECUTION_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_PARENT_TASK_ID_ = "PARENT_TASK_ID_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_DESCRIPTION_ = "DESCRIPTION_";

    private static final String COL_OWNER_ = "OWNER_";

    private static final String COL_ASSIGNEE_ = "ASSIGNEE_";

    private static final String COL_START_TIME_ = "START_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_DURATION_ = "DURATION_";

    private static final String COL_DELETE_REASON_ = "DELETE_REASON_";

    private static final String COL_PRIORITY_ = "PRIORITY_";

    private static final String COL_DUE_DATE_ = "DUE_DATE_";

    private static final String COL_FOLLOW_UP_DATE_ = "FOLLOW_UP_DATE_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TASK_DEF_KEY_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_ACT_INST_ID_, COL_PARENT_TASK_ID_, COL_NAME_, COL_DESCRIPTION_, COL_OWNER_, COL_ASSIGNEE_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_DELETE_REASON_, COL_PRIORITY_, COL_DUE_DATE_, COL_FOLLOW_UP_DATE_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TASK_DEF_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, ACT_INST_ID_, PARENT_TASK_ID_, NAME_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, DELETE_REASON_, PRIORITY_, DUE_DATE_, FOLLOW_UP_DATE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TASK_DEF_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, ACT_INST_ID_, PARENT_TASK_ID_, NAME_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, DELETE_REASON_, PRIORITY_, DUE_DATE_, FOLLOW_UP_DATE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TASK_DEF_KEY_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_ACT_INST_ID_, COL_PARENT_TASK_ID_, COL_NAME_, COL_DESCRIPTION_, COL_OWNER_, COL_ASSIGNEE_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_DELETE_REASON_, COL_PRIORITY_, COL_DUE_DATE_, COL_FOLLOW_UP_DATE_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiTaskinst fgacthitaskinst) throws SQLException {
        logger.debug("Inserting fgacthitaskinst: {}", fgacthitaskinst);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiTaskinstParams(ps, fgacthitaskinst);
            ps.executeUpdate();
            return fgacthitaskinst.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiTaskinst> fgacthitaskinsts) throws SQLException {
        if (fgacthitaskinsts == null || fgacthitaskinsts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthitaskinsts.size(); i++) {
            if (fgacthitaskinsts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiTaskinst>> batches = chunkList(fgacthitaskinsts, batchSize);
        int[] totalResults = new int[fgacthitaskinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiTaskinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiTaskinst fgacthitaskinst : batch) {
                        setFgActHiTaskinstParams(ps, fgacthitaskinst);
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

    public FgActHiTaskinst findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiTaskinst> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiTaskinst> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiTaskinst fgacthitaskinst) throws SQLException {
        if (fgacthitaskinst.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiTaskinstParams(ps, fgacthitaskinst);
            ps.setString(26, fgacthitaskinst.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiTaskinst> fgacthitaskinsts) throws SQLException {
        if (fgacthitaskinsts == null || fgacthitaskinsts.isEmpty())
            return new int[0];
        for (FgActHiTaskinst fgacthitaskinst : fgacthitaskinsts) {
            if (fgacthitaskinst == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthitaskinst.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiTaskinst>> batches = chunkList(fgacthitaskinsts, batchSize);
        int[] totalResults = new int[fgacthitaskinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiTaskinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiTaskinst fgacthitaskinst : batch) {
                        setFgActHiTaskinstParams(ps, fgacthitaskinst);
                        ps.setString(26, fgacthitaskinst.getID_());
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

    private void setFgActHiTaskinstParams(PreparedStatement ps, FgActHiTaskinst fgacthitaskinst) throws SQLException {
        ps.setString(1, fgacthitaskinst.getID_());
        ps.setString(2, fgacthitaskinst.getTaskDefKey_());
        ps.setString(3, fgacthitaskinst.getProcDefKey_());
        ps.setString(4, fgacthitaskinst.getProcDefID_());
        ps.setString(5, fgacthitaskinst.getProcInstID_());
        ps.setString(6, fgacthitaskinst.getExecutionID_());
        ps.setString(7, fgacthitaskinst.getCaseDefKey_());
        ps.setString(8, fgacthitaskinst.getCaseDefID_());
        ps.setString(9, fgacthitaskinst.getCaseInstID_());
        ps.setString(10, fgacthitaskinst.getCaseExecutionID_());
        ps.setString(11, fgacthitaskinst.getActInstID_());
        ps.setString(12, fgacthitaskinst.getParentTaskID_());
        ps.setString(13, fgacthitaskinst.getName_());
        ps.setString(14, fgacthitaskinst.getDescription_());
        ps.setString(15, fgacthitaskinst.getOwner_());
        ps.setString(16, fgacthitaskinst.getAssignee_());
        ps.setString(17, fgacthitaskinst.getStartTime_());
        ps.setString(18, fgacthitaskinst.getEndTime_());
        Integer val19 = fgacthitaskinst.getDuration_();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgacthitaskinst.getDeleteReason_());
        java.math.BigDecimal val21 = fgacthitaskinst.getPriority_();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgacthitaskinst.getDueDate_());
        ps.setString(23, fgacthitaskinst.getFollowUpDate_());
        ps.setString(24, fgacthitaskinst.getTenantID_());
        ps.setString(25, fgacthitaskinst.getRootProcInstID_());
        ps.setString(26, fgacthitaskinst.getRemovalTime_());
    }

    private FgActHiTaskinst extract(ResultSet rs) throws SQLException {
        FgActHiTaskinst fgacthitaskinst = new FgActHiTaskinst();
        fgacthitaskinst.setID_(rs.getString(COL_ID_));
        fgacthitaskinst.setTaskDefKey_(rs.getString(COL_TASK_DEF_KEY_));
        fgacthitaskinst.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthitaskinst.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthitaskinst.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthitaskinst.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthitaskinst.setCaseDefKey_(rs.getString(COL_CASE_DEF_KEY_));
        fgacthitaskinst.setCaseDefID_(rs.getString(COL_CASE_DEF_ID_));
        fgacthitaskinst.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthitaskinst.setCaseExecutionID_(rs.getString(COL_CASE_EXECUTION_ID_));
        fgacthitaskinst.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        fgacthitaskinst.setParentTaskID_(rs.getString(COL_PARENT_TASK_ID_));
        fgacthitaskinst.setName_(rs.getString(COL_NAME_));
        fgacthitaskinst.setDescription_(rs.getString(COL_DESCRIPTION_));
        fgacthitaskinst.setOwner_(rs.getString(COL_OWNER_));
        fgacthitaskinst.setAssignee_(rs.getString(COL_ASSIGNEE_));
        fgacthitaskinst.setStartTime_(rs.getString(COL_START_TIME_));
        fgacthitaskinst.setEndTime_(rs.getString(COL_END_TIME_));
        Integer DURATION_ = rs.getObject(COL_DURATION_, Integer.class);
        fgacthitaskinst.setDuration_(DURATION_);
        fgacthitaskinst.setDeleteReason_(rs.getString(COL_DELETE_REASON_));
        java.math.BigDecimal PRIORITY_ = rs.getObject(COL_PRIORITY_, java.math.BigDecimal.class);
        fgacthitaskinst.setPriority_(PRIORITY_);
        fgacthitaskinst.setDueDate_(rs.getString(COL_DUE_DATE_));
        fgacthitaskinst.setFollowUpDate_(rs.getString(COL_FOLLOW_UP_DATE_));
        fgacthitaskinst.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthitaskinst.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthitaskinst.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthitaskinst;
    }
}
