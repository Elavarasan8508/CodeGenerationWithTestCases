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

public class JdbcFgActHiCaseactinstDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiCaseactinstDao.class);

    private static final String TABLE = "FG_ACT_HI_CASEACTINST";

    private static final String COL_ID_ = "ID_";

    private static final String COL_PARENT_ACT_INST_ID_ = "PARENT_ACT_INST_ID_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_ACT_ID_ = "CASE_ACT_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_CALL_PROC_INST_ID_ = "CALL_PROC_INST_ID_";

    private static final String COL_CALL_CASE_INST_ID_ = "CALL_CASE_INST_ID_";

    private static final String COL_CASE_ACT_NAME_ = "CASE_ACT_NAME_";

    private static final String COL_CASE_ACT_TYPE_ = "CASE_ACT_TYPE_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_DURATION_ = "DURATION_";

    private static final String COL_STATE_ = "STATE_";

    private static final String COL_REQUIRED_ = "REQUIRED_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_PARENT_ACT_INST_ID_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_ACT_ID_, COL_TASK_ID_, COL_CALL_PROC_INST_ID_, COL_CALL_CASE_INST_ID_, COL_CASE_ACT_NAME_, COL_CASE_ACT_TYPE_, COL_CREATE_TIME_, COL_END_TIME_, COL_DURATION_, COL_STATE_, COL_REQUIRED_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, PARENT_ACT_INST_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, CASE_ACT_NAME_, CASE_ACT_TYPE_, CREATE_TIME_, END_TIME_, DURATION_, STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, PARENT_ACT_INST_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, CASE_ACT_NAME_, CASE_ACT_TYPE_, CREATE_TIME_, END_TIME_, DURATION_, STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARENT_ACT_INST_ID_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_ACT_ID_, COL_TASK_ID_, COL_CALL_PROC_INST_ID_, COL_CALL_CASE_INST_ID_, COL_CASE_ACT_NAME_, COL_CASE_ACT_TYPE_, COL_CREATE_TIME_, COL_END_TIME_, COL_DURATION_, COL_STATE_, COL_REQUIRED_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActHiCaseactinst fgacthicaseactinst) throws SQLException {
        logger.debug("Inserting fgacthicaseactinst: {}", fgacthicaseactinst);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiCaseactinstParams(ps, fgacthicaseactinst);
            ps.executeUpdate();
            return fgacthicaseactinst.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiCaseactinst> fgacthicaseactinsts) throws SQLException {
        if (fgacthicaseactinsts == null || fgacthicaseactinsts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthicaseactinsts.size(); i++) {
            if (fgacthicaseactinsts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiCaseactinst>> batches = chunkList(fgacthicaseactinsts, batchSize);
        int[] totalResults = new int[fgacthicaseactinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiCaseactinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiCaseactinst fgacthicaseactinst : batch) {
                        setFgActHiCaseactinstParams(ps, fgacthicaseactinst);
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

    public FgActHiCaseactinst findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiCaseactinst> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiCaseactinst> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiCaseactinst fgacthicaseactinst) throws SQLException {
        if (fgacthicaseactinst.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiCaseactinstParams(ps, fgacthicaseactinst);
            ps.setString(16, fgacthicaseactinst.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiCaseactinst> fgacthicaseactinsts) throws SQLException {
        if (fgacthicaseactinsts == null || fgacthicaseactinsts.isEmpty())
            return new int[0];
        for (FgActHiCaseactinst fgacthicaseactinst : fgacthicaseactinsts) {
            if (fgacthicaseactinst == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthicaseactinst.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiCaseactinst>> batches = chunkList(fgacthicaseactinsts, batchSize);
        int[] totalResults = new int[fgacthicaseactinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiCaseactinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiCaseactinst fgacthicaseactinst : batch) {
                        setFgActHiCaseactinstParams(ps, fgacthicaseactinst);
                        ps.setString(16, fgacthicaseactinst.getID_());
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

    private void setFgActHiCaseactinstParams(PreparedStatement ps, FgActHiCaseactinst fgacthicaseactinst) throws SQLException {
        ps.setString(1, fgacthicaseactinst.getID_());
        ps.setString(2, fgacthicaseactinst.getParentActInstID_());
        ps.setString(3, fgacthicaseactinst.getCaseDefID_());
        ps.setString(4, fgacthicaseactinst.getCaseInstID_());
        ps.setString(5, fgacthicaseactinst.getCaseActID_());
        ps.setString(6, fgacthicaseactinst.getTaskID_());
        ps.setString(7, fgacthicaseactinst.getCallProcInstID_());
        ps.setString(8, fgacthicaseactinst.getCallCaseInstID_());
        ps.setString(9, fgacthicaseactinst.getCaseActName_());
        ps.setString(10, fgacthicaseactinst.getCaseActType_());
        ps.setString(11, fgacthicaseactinst.getCreateTime_());
        ps.setString(12, fgacthicaseactinst.getEndTime_());
        Integer val13 = fgacthicaseactinst.getDuration_();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        java.math.BigDecimal val14 = fgacthicaseactinst.getState_();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgacthicaseactinst.getRequired_();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgacthicaseactinst.getTenantID_());
    }

    private FgActHiCaseactinst extract(ResultSet rs) throws SQLException {
        FgActHiCaseactinst fgacthicaseactinst = new FgActHiCaseactinst();
        fgacthicaseactinst.setID_(rs.getString(COL_ID_));
        fgacthicaseactinst.setParentActInstID_(rs.getString(COL_PARENT_ACT_INST_ID_));
        fgacthicaseactinst.setCaseDefID_(rs.getString(COL_CASE_DEF_ID_));
        fgacthicaseactinst.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthicaseactinst.setCaseActID_(rs.getString(COL_CASE_ACT_ID_));
        fgacthicaseactinst.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthicaseactinst.setCallProcInstID_(rs.getString(COL_CALL_PROC_INST_ID_));
        fgacthicaseactinst.setCallCaseInstID_(rs.getString(COL_CALL_CASE_INST_ID_));
        fgacthicaseactinst.setCaseActName_(rs.getString(COL_CASE_ACT_NAME_));
        fgacthicaseactinst.setCaseActType_(rs.getString(COL_CASE_ACT_TYPE_));
        fgacthicaseactinst.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        fgacthicaseactinst.setEndTime_(rs.getString(COL_END_TIME_));
        Integer DURATION_ = rs.getObject(COL_DURATION_, Integer.class);
        fgacthicaseactinst.setDuration_(DURATION_);
        java.math.BigDecimal STATE_ = rs.getObject(COL_STATE_, java.math.BigDecimal.class);
        fgacthicaseactinst.setState_(STATE_);
        java.math.BigDecimal REQUIRED_ = rs.getObject(COL_REQUIRED_, java.math.BigDecimal.class);
        fgacthicaseactinst.setRequired_(REQUIRED_);
        fgacthicaseactinst.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgacthicaseactinst;
    }
}
