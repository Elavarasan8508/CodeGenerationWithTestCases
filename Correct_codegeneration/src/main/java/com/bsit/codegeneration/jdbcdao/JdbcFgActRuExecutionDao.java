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

public class JdbcFgActRuExecutionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuExecutionDao.class);

    private static final String TABLE = "FG_ACT_RU_EXECUTION";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_BUSINESS_KEY_ = "BUSINESS_KEY_";

    private static final String COL_PARENT_ID_ = "PARENT_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_SUPER_EXEC_ = "SUPER_EXEC_";

    private static final String COL_SUPER_CASE_EXEC_ = "SUPER_CASE_EXEC_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_IS_ACTIVE_ = "IS_ACTIVE_";

    private static final String COL_IS_CONCURRENT_ = "IS_CONCURRENT_";

    private static final String COL_IS_SCOPE_ = "IS_SCOPE_";

    private static final String COL_IS_EVENT_SCOPE_ = "IS_EVENT_SCOPE_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_CACHED_ENT_STATE_ = "CACHED_ENT_STATE_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_PROC_INST_ID_, COL_BUSINESS_KEY_, COL_PARENT_ID_, COL_PROC_DEF_ID_, COL_SUPER_EXEC_, COL_SUPER_CASE_EXEC_, COL_CASE_INST_ID_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_IS_ACTIVE_, COL_IS_CONCURRENT_, COL_IS_SCOPE_, COL_IS_EVENT_SCOPE_, COL_SUSPENSION_STATE_, COL_CACHED_ENT_STATE_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PARENT_ID_, PROC_DEF_ID_, SUPER_EXEC_, SUPER_CASE_EXEC_, CASE_INST_ID_, ACT_ID_, ACT_INST_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_, IS_EVENT_SCOPE_, SUSPENSION_STATE_, CACHED_ENT_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PARENT_ID_, PROC_DEF_ID_, SUPER_EXEC_, SUPER_CASE_EXEC_, CASE_INST_ID_, ACT_ID_, ACT_INST_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_, IS_EVENT_SCOPE_, SUSPENSION_STATE_, CACHED_ENT_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_PROC_INST_ID_, COL_BUSINESS_KEY_, COL_PARENT_ID_, COL_PROC_DEF_ID_, COL_SUPER_EXEC_, COL_SUPER_CASE_EXEC_, COL_CASE_INST_ID_, COL_ACT_ID_, COL_ACT_INST_ID_, COL_IS_ACTIVE_, COL_IS_CONCURRENT_, COL_IS_SCOPE_, COL_IS_EVENT_SCOPE_, COL_SUSPENSION_STATE_, COL_CACHED_ENT_STATE_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuExecution fgactruexecution) throws SQLException {
        logger.debug("Inserting fgactruexecution: {}", fgactruexecution);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuExecutionParams(ps, fgactruexecution);
            ps.executeUpdate();
            return fgactruexecution.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuExecution> fgactruexecutions) throws SQLException {
        if (fgactruexecutions == null || fgactruexecutions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruexecutions.size(); i++) {
            if (fgactruexecutions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuExecution>> batches = chunkList(fgactruexecutions, batchSize);
        int[] totalResults = new int[fgactruexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuExecution fgactruexecution : batch) {
                        setFgActRuExecutionParams(ps, fgactruexecution);
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

    public FgActRuExecution findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuExecution> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuExecution> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuExecution fgactruexecution) throws SQLException {
        if (fgactruexecution.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuExecutionParams(ps, fgactruexecution);
            ps.setString(20, fgactruexecution.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuExecution> fgactruexecutions) throws SQLException {
        if (fgactruexecutions == null || fgactruexecutions.isEmpty())
            return new int[0];
        for (FgActRuExecution fgactruexecution : fgactruexecutions) {
            if (fgactruexecution == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruexecution.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuExecution>> batches = chunkList(fgactruexecutions, batchSize);
        int[] totalResults = new int[fgactruexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuExecution fgactruexecution : batch) {
                        setFgActRuExecutionParams(ps, fgactruexecution);
                        ps.setString(20, fgactruexecution.getID_());
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

    private void setFgActRuExecutionParams(PreparedStatement ps, FgActRuExecution fgactruexecution) throws SQLException {
        ps.setString(1, fgactruexecution.getID_());
        java.math.BigDecimal val2 = fgactruexecution.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactruexecution.getProcInstID_());
        ps.setString(4, fgactruexecution.getBusinessKey_());
        ps.setString(5, fgactruexecution.getParentID_());
        ps.setString(6, fgactruexecution.getProcDefID_());
        ps.setString(7, fgactruexecution.getSuperExec_());
        ps.setString(8, fgactruexecution.getSuperCaseExec_());
        ps.setString(9, fgactruexecution.getCaseInstID_());
        ps.setString(10, fgactruexecution.getActID_());
        ps.setString(11, fgactruexecution.getActInstID_());
        java.math.BigDecimal val12 = fgactruexecution.getIsActive_();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        java.math.BigDecimal val13 = fgactruexecution.getIsConcurrent_();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = fgactruexecution.getIsScope_();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgactruexecution.getIsEventScope_();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = fgactruexecution.getSuspensionState_();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.math.BigDecimal val17 = fgactruexecution.getCachedEntState_();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = fgactruexecution.getSequenceCounter_();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgactruexecution.getTenantID_());
        ps.setString(20, fgactruexecution.getRootProcInstID_());
    }

    private FgActRuExecution extract(ResultSet rs) throws SQLException {
        FgActRuExecution fgactruexecution = new FgActRuExecution();
        fgactruexecution.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruexecution.setRev_(REV_);
        fgactruexecution.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgactruexecution.setBusinessKey_(rs.getString(COL_BUSINESS_KEY_));
        fgactruexecution.setParentID_(rs.getString(COL_PARENT_ID_));
        fgactruexecution.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgactruexecution.setSuperExec_(rs.getString(COL_SUPER_EXEC_));
        fgactruexecution.setSuperCaseExec_(rs.getString(COL_SUPER_CASE_EXEC_));
        fgactruexecution.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgactruexecution.setActID_(rs.getString(COL_ACT_ID_));
        fgactruexecution.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        java.math.BigDecimal IS_ACTIVE_ = rs.getObject(COL_IS_ACTIVE_, java.math.BigDecimal.class);
        fgactruexecution.setIsActive_(IS_ACTIVE_);
        java.math.BigDecimal IS_CONCURRENT_ = rs.getObject(COL_IS_CONCURRENT_, java.math.BigDecimal.class);
        fgactruexecution.setIsConcurrent_(IS_CONCURRENT_);
        java.math.BigDecimal IS_SCOPE_ = rs.getObject(COL_IS_SCOPE_, java.math.BigDecimal.class);
        fgactruexecution.setIsScope_(IS_SCOPE_);
        java.math.BigDecimal IS_EVENT_SCOPE_ = rs.getObject(COL_IS_EVENT_SCOPE_, java.math.BigDecimal.class);
        fgactruexecution.setIsEventScope_(IS_EVENT_SCOPE_);
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactruexecution.setSuspensionState_(SUSPENSION_STATE_);
        java.math.BigDecimal CACHED_ENT_STATE_ = rs.getObject(COL_CACHED_ENT_STATE_, java.math.BigDecimal.class);
        fgactruexecution.setCachedEntState_(CACHED_ENT_STATE_);
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgactruexecution.setSequenceCounter_(SEQUENCE_COUNTER_);
        fgactruexecution.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactruexecution.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        return fgactruexecution;
    }
}
