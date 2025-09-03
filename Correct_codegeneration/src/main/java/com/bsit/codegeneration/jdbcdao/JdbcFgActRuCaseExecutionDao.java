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

public class JdbcFgActRuCaseExecutionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuCaseExecutionDao.class);

    private static final String TABLE = "FG_ACT_RU_CASE_EXECUTION";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_SUPER_CASE_EXEC_ = "SUPER_CASE_EXEC_";

    private static final String COL_SUPER_EXEC_ = "SUPER_EXEC_";

    private static final String COL_BUSINESS_KEY_ = "BUSINESS_KEY_";

    private static final String COL_PARENT_ID_ = "PARENT_ID_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_PREV_STATE_ = "PREV_STATE_";

    private static final String COL_CURRENT_STATE_ = "CURRENT_STATE_";

    private static final String COL_REQUIRED_ = "REQUIRED_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_CASE_INST_ID_, COL_SUPER_CASE_EXEC_, COL_SUPER_EXEC_, COL_BUSINESS_KEY_, COL_PARENT_ID_, COL_CASE_DEF_ID_, COL_ACT_ID_, COL_PREV_STATE_, COL_CURRENT_STATE_, COL_REQUIRED_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_CASE_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_CASE_DEF_ID_);

    private static final String SELECT_BY_PARENT_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_PARENT_ID_);

    private static final String SELECT_BY_CASE_INST_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_", TABLE, COL_CASE_INST_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_CASE_INST_ID_, COL_SUPER_CASE_EXEC_, COL_SUPER_EXEC_, COL_BUSINESS_KEY_, COL_PARENT_ID_, COL_CASE_DEF_ID_, COL_ACT_ID_, COL_PREV_STATE_, COL_CURRENT_STATE_, COL_REQUIRED_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuCaseExecution fgactrucaseexecution) throws SQLException {
        logger.debug("Inserting fgactrucaseexecution: {}", fgactrucaseexecution);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuCaseExecutionParams(ps, fgactrucaseexecution);
            ps.executeUpdate();
            return fgactrucaseexecution.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuCaseExecution> fgactrucaseexecutions) throws SQLException {
        if (fgactrucaseexecutions == null || fgactrucaseexecutions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrucaseexecutions.size(); i++) {
            if (fgactrucaseexecutions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuCaseExecution>> batches = chunkList(fgactrucaseexecutions, batchSize);
        int[] totalResults = new int[fgactrucaseexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuCaseExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuCaseExecution fgactrucaseexecution : batch) {
                        setFgActRuCaseExecutionParams(ps, fgactrucaseexecution);
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

    public FgActRuCaseExecution findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuCaseExecution> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuCaseExecution> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuCaseExecution fgactrucaseexecution) throws SQLException {
        if (fgactrucaseexecution.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuCaseExecutionParams(ps, fgactrucaseexecution);
            ps.setString(13, fgactrucaseexecution.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuCaseExecution> fgactrucaseexecutions) throws SQLException {
        if (fgactrucaseexecutions == null || fgactrucaseexecutions.isEmpty())
            return new int[0];
        for (FgActRuCaseExecution fgactrucaseexecution : fgactrucaseexecutions) {
            if (fgactrucaseexecution == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrucaseexecution.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuCaseExecution>> batches = chunkList(fgactrucaseexecutions, batchSize);
        int[] totalResults = new int[fgactrucaseexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuCaseExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuCaseExecution fgactrucaseexecution : batch) {
                        setFgActRuCaseExecutionParams(ps, fgactrucaseexecution);
                        ps.setString(13, fgactrucaseexecution.getID_());
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

    public List<FgActRuCaseExecution> findByCaseDefID_(Connection conn, String caseDefID_) throws SQLException {
        List<FgActRuCaseExecution> list = new ArrayList<>();
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

    public List<FgActRuCaseExecution> findByParentID_(Connection conn, String parentID_) throws SQLException {
        List<FgActRuCaseExecution> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PARENT_ID__SQL)) {
            ps.setString(1, parentID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuCaseExecution> findByCaseInstID_(Connection conn, String caseInstID_) throws SQLException {
        List<FgActRuCaseExecution> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CASE_INST_ID__SQL)) {
            ps.setString(1, caseInstID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuCaseExecutionParams(PreparedStatement ps, FgActRuCaseExecution fgactrucaseexecution) throws SQLException {
        ps.setString(1, fgactrucaseexecution.getID_());
        java.math.BigDecimal val2 = fgactrucaseexecution.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        if (fgactrucaseexecution.getCaseInstID_() != null) {
            ps.setString(3, fgactrucaseexecution.getCaseInstID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(3, Types.VARCHAR);
        }
        ps.setString(4, fgactrucaseexecution.getSuperCaseExec_());
        ps.setString(5, fgactrucaseexecution.getSuperExec_());
        ps.setString(6, fgactrucaseexecution.getBusinessKey_());
        if (fgactrucaseexecution.getParentID_() != null) {
            ps.setString(7, fgactrucaseexecution.getParentID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(7, Types.VARCHAR);
        }
        if (fgactrucaseexecution.getCaseDefID_() != null) {
            ps.setString(8, fgactrucaseexecution.getCaseDefID_().getFgActReCaseDefID());
        } else {
            ps.setNull(8, Types.VARCHAR);
        }
        ps.setString(9, fgactrucaseexecution.getActID_());
        java.math.BigDecimal val10 = fgactrucaseexecution.getPrevState_();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.math.BigDecimal val11 = fgactrucaseexecution.getCurrentState_();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = fgactrucaseexecution.getRequired_();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgactrucaseexecution.getTenantID_());
    }

    private FgActRuCaseExecution extract(ResultSet rs) throws SQLException {
        FgActRuCaseExecution fgactrucaseexecution = new FgActRuCaseExecution();
        fgactrucaseexecution.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrucaseexecution.setRev_(REV_);
        String CASE_INST_ID_ = rs.getObject(COL_CASE_INST_ID_, String.class);
        fgactrucaseexecution.setCaseInstID_(CASE_INST_ID_);
        if (CASE_INST_ID_ != null) {
            FgActRuCaseExecution caseInstID_ = new FgActRuCaseExecution();
            caseInstID_.setFgActRuCaseExecutionID(CASE_INST_ID_);
            fgactrucaseexecution.setCaseInstID_(caseInstID_);
        }
        fgactrucaseexecution.setSuperCaseExec_(rs.getString(COL_SUPER_CASE_EXEC_));
        fgactrucaseexecution.setSuperExec_(rs.getString(COL_SUPER_EXEC_));
        fgactrucaseexecution.setBusinessKey_(rs.getString(COL_BUSINESS_KEY_));
        String PARENT_ID_ = rs.getObject(COL_PARENT_ID_, String.class);
        fgactrucaseexecution.setParentID_(PARENT_ID_);
        if (PARENT_ID_ != null) {
            FgActRuCaseExecution parentID_ = new FgActRuCaseExecution();
            parentID_.setFgActRuCaseExecutionID(PARENT_ID_);
            fgactrucaseexecution.setParentID_(parentID_);
        }
        String CASE_DEF_ID_ = rs.getObject(COL_CASE_DEF_ID_, String.class);
        fgactrucaseexecution.setCaseDefID_(CASE_DEF_ID_);
        if (CASE_DEF_ID_ != null) {
            FgActReCaseDef caseDefID_ = new FgActReCaseDef();
            caseDefID_.setFgActReCaseDefID(CASE_DEF_ID_);
            fgactrucaseexecution.setCaseDefID_(caseDefID_);
        }
        fgactrucaseexecution.setActID_(rs.getString(COL_ACT_ID_));
        java.math.BigDecimal PREV_STATE_ = rs.getObject(COL_PREV_STATE_, java.math.BigDecimal.class);
        fgactrucaseexecution.setPrevState_(PREV_STATE_);
        java.math.BigDecimal CURRENT_STATE_ = rs.getObject(COL_CURRENT_STATE_, java.math.BigDecimal.class);
        fgactrucaseexecution.setCurrentState_(CURRENT_STATE_);
        java.math.BigDecimal REQUIRED_ = rs.getObject(COL_REQUIRED_, java.math.BigDecimal.class);
        fgactrucaseexecution.setRequired_(REQUIRED_);
        fgactrucaseexecution.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgactrucaseexecution;
    }
}
