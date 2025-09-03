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

public class JdbcFgActHiActinstDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiActinstDao.class);

    private static final String TABLE = "FG_ACT_HI_ACTINST";

    private static final String COL_ID_ = "ID_";

    private static final String COL_PARENT_ACT_INST_ID_ = "PARENT_ACT_INST_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_CALL_PROC_INST_ID_ = "CALL_PROC_INST_ID_";

    private static final String COL_CALL_CASE_INST_ID_ = "CALL_CASE_INST_ID_";

    private static final String COL_ACT_NAME_ = "ACT_NAME_";

    private static final String COL_ACT_TYPE_ = "ACT_TYPE_";

    private static final String COL_ASSIGNEE_ = "ASSIGNEE_";

    private static final String COL_START_TIME_ = "START_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_DURATION_ = "DURATION_";

    private static final String COL_ACT_INST_STATE_ = "ACT_INST_STATE_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_PARENT_ACT_INST_ID_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_ACT_ID_, COL_TASK_ID_, COL_CALL_PROC_INST_ID_, COL_CALL_CASE_INST_ID_, COL_ACT_NAME_, COL_ACT_TYPE_, COL_ASSIGNEE_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_ACT_INST_STATE_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, PARENT_ACT_INST_ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, ACT_INST_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, PARENT_ACT_INST_ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, ACT_INST_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARENT_ACT_INST_ID_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_ACT_ID_, COL_TASK_ID_, COL_CALL_PROC_INST_ID_, COL_CALL_CASE_INST_ID_, COL_ACT_NAME_, COL_ACT_TYPE_, COL_ASSIGNEE_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_ACT_INST_STATE_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiActinst fgacthiactinst) throws SQLException {
        logger.debug("Inserting fgacthiactinst: {}", fgacthiactinst);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiActinstParams(ps, fgacthiactinst);
            ps.executeUpdate();
            return fgacthiactinst.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiActinst> fgacthiactinsts) throws SQLException {
        if (fgacthiactinsts == null || fgacthiactinsts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthiactinsts.size(); i++) {
            if (fgacthiactinsts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiActinst>> batches = chunkList(fgacthiactinsts, batchSize);
        int[] totalResults = new int[fgacthiactinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiActinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiActinst fgacthiactinst : batch) {
                        setFgActHiActinstParams(ps, fgacthiactinst);
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

    public FgActHiActinst findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiActinst> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiActinst> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiActinst fgacthiactinst) throws SQLException {
        if (fgacthiactinst.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiActinstParams(ps, fgacthiactinst);
            ps.setString(21, fgacthiactinst.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiActinst> fgacthiactinsts) throws SQLException {
        if (fgacthiactinsts == null || fgacthiactinsts.isEmpty())
            return new int[0];
        for (FgActHiActinst fgacthiactinst : fgacthiactinsts) {
            if (fgacthiactinst == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthiactinst.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiActinst>> batches = chunkList(fgacthiactinsts, batchSize);
        int[] totalResults = new int[fgacthiactinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiActinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiActinst fgacthiactinst : batch) {
                        setFgActHiActinstParams(ps, fgacthiactinst);
                        ps.setString(21, fgacthiactinst.getID_());
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

    private void setFgActHiActinstParams(PreparedStatement ps, FgActHiActinst fgacthiactinst) throws SQLException {
        ps.setString(1, fgacthiactinst.getID_());
        ps.setString(2, fgacthiactinst.getParentActInstID_());
        ps.setString(3, fgacthiactinst.getProcDefKey_());
        ps.setString(4, fgacthiactinst.getProcDefID_());
        ps.setString(5, fgacthiactinst.getProcInstID_());
        ps.setString(6, fgacthiactinst.getExecutionID_());
        ps.setString(7, fgacthiactinst.getActID_());
        ps.setString(8, fgacthiactinst.getTaskID_());
        ps.setString(9, fgacthiactinst.getCallProcInstID_());
        ps.setString(10, fgacthiactinst.getCallCaseInstID_());
        ps.setString(11, fgacthiactinst.getActName_());
        ps.setString(12, fgacthiactinst.getActType_());
        ps.setString(13, fgacthiactinst.getAssignee_());
        ps.setString(14, fgacthiactinst.getStartTime_());
        ps.setString(15, fgacthiactinst.getEndTime_());
        Integer val16 = fgacthiactinst.getDuration_();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        java.math.BigDecimal val17 = fgacthiactinst.getActInstState_();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = fgacthiactinst.getSequenceCounter_();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgacthiactinst.getTenantID_());
        ps.setString(20, fgacthiactinst.getRootProcInstID_());
        ps.setString(21, fgacthiactinst.getRemovalTime_());
    }

    private FgActHiActinst extract(ResultSet rs) throws SQLException {
        FgActHiActinst fgacthiactinst = new FgActHiActinst();
        fgacthiactinst.setID_(rs.getString(COL_ID_));
        fgacthiactinst.setParentActInstID_(rs.getString(COL_PARENT_ACT_INST_ID_));
        fgacthiactinst.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthiactinst.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthiactinst.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthiactinst.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthiactinst.setActID_(rs.getString(COL_ACT_ID_));
        fgacthiactinst.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthiactinst.setCallProcInstID_(rs.getString(COL_CALL_PROC_INST_ID_));
        fgacthiactinst.setCallCaseInstID_(rs.getString(COL_CALL_CASE_INST_ID_));
        fgacthiactinst.setActName_(rs.getString(COL_ACT_NAME_));
        fgacthiactinst.setActType_(rs.getString(COL_ACT_TYPE_));
        fgacthiactinst.setAssignee_(rs.getString(COL_ASSIGNEE_));
        fgacthiactinst.setStartTime_(rs.getString(COL_START_TIME_));
        fgacthiactinst.setEndTime_(rs.getString(COL_END_TIME_));
        Integer DURATION_ = rs.getObject(COL_DURATION_, Integer.class);
        fgacthiactinst.setDuration_(DURATION_);
        java.math.BigDecimal ACT_INST_STATE_ = rs.getObject(COL_ACT_INST_STATE_, java.math.BigDecimal.class);
        fgacthiactinst.setActInstState_(ACT_INST_STATE_);
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgacthiactinst.setSequenceCounter_(SEQUENCE_COUNTER_);
        fgacthiactinst.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthiactinst.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthiactinst.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthiactinst;
    }
}
