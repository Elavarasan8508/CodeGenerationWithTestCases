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

public class JdbcFgActRuCaseSentryPartDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuCaseSentryPartDao.class);

    private static final String TABLE = "FG_ACT_RU_CASE_SENTRY_PART";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_EXEC_ID_ = "CASE_EXEC_ID_";

    private static final String COL_SENTRY_ID_ = "SENTRY_ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_SOURCE_CASE_EXEC_ID_ = "SOURCE_CASE_EXEC_ID_";

    private static final String COL_STANDARD_EVENT_ = "STANDARD_EVENT_";

    private static final String COL_SOURCE_ = "SOURCE_";

    private static final String COL_VARIABLE_EVENT_ = "VARIABLE_EVENT_";

    private static final String COL_VARIABLE_NAME_ = "VARIABLE_NAME_";

    private static final String COL_SATISFIED_ = "SATISFIED_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_CASE_INST_ID_, COL_CASE_EXEC_ID_, COL_SENTRY_ID_, COL_TYPE_, COL_SOURCE_CASE_EXEC_ID_, COL_STANDARD_EVENT_, COL_SOURCE_, COL_VARIABLE_EVENT_, COL_VARIABLE_NAME_, COL_SATISFIED_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_CASE_INST_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_", TABLE, COL_CASE_INST_ID_);

    private static final String SELECT_BY_CASE_EXEC_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_", TABLE, COL_CASE_EXEC_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_CASE_INST_ID_, COL_CASE_EXEC_ID_, COL_SENTRY_ID_, COL_TYPE_, COL_SOURCE_CASE_EXEC_ID_, COL_STANDARD_EVENT_, COL_SOURCE_, COL_VARIABLE_EVENT_, COL_VARIABLE_NAME_, COL_SATISFIED_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuCaseSentryPart fgactrucasesentrypart) throws SQLException {
        logger.debug("Inserting fgactrucasesentrypart: {}", fgactrucasesentrypart);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuCaseSentryPartParams(ps, fgactrucasesentrypart);
            ps.executeUpdate();
            return fgactrucasesentrypart.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuCaseSentryPart> fgactrucasesentryparts) throws SQLException {
        if (fgactrucasesentryparts == null || fgactrucasesentryparts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrucasesentryparts.size(); i++) {
            if (fgactrucasesentryparts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuCaseSentryPart>> batches = chunkList(fgactrucasesentryparts, batchSize);
        int[] totalResults = new int[fgactrucasesentryparts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuCaseSentryPart> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuCaseSentryPart fgactrucasesentrypart : batch) {
                        setFgActRuCaseSentryPartParams(ps, fgactrucasesentrypart);
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

    public FgActRuCaseSentryPart findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuCaseSentryPart> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuCaseSentryPart> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuCaseSentryPart fgactrucasesentrypart) throws SQLException {
        if (fgactrucasesentrypart.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuCaseSentryPartParams(ps, fgactrucasesentrypart);
            ps.setString(13, fgactrucasesentrypart.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuCaseSentryPart> fgactrucasesentryparts) throws SQLException {
        if (fgactrucasesentryparts == null || fgactrucasesentryparts.isEmpty())
            return new int[0];
        for (FgActRuCaseSentryPart fgactrucasesentrypart : fgactrucasesentryparts) {
            if (fgactrucasesentrypart == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrucasesentrypart.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuCaseSentryPart>> batches = chunkList(fgactrucasesentryparts, batchSize);
        int[] totalResults = new int[fgactrucasesentryparts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuCaseSentryPart> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuCaseSentryPart fgactrucasesentrypart : batch) {
                        setFgActRuCaseSentryPartParams(ps, fgactrucasesentrypart);
                        ps.setString(13, fgactrucasesentrypart.getID_());
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

    public List<FgActRuCaseSentryPart> findByCaseInstID_(Connection conn, String caseInstID_) throws SQLException {
        List<FgActRuCaseSentryPart> list = new ArrayList<>();
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

    public List<FgActRuCaseSentryPart> findByCaseExecID_(Connection conn, String caseExecID_) throws SQLException {
        List<FgActRuCaseSentryPart> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CASE_EXEC_ID__SQL)) {
            ps.setString(1, caseExecID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuCaseSentryPartParams(PreparedStatement ps, FgActRuCaseSentryPart fgactrucasesentrypart) throws SQLException {
        ps.setString(1, fgactrucasesentrypart.getID_());
        java.math.BigDecimal val2 = fgactrucasesentrypart.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        if (fgactrucasesentrypart.getCaseInstID_() != null) {
            ps.setString(3, fgactrucasesentrypart.getCaseInstID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(3, Types.VARCHAR);
        }
        if (fgactrucasesentrypart.getCaseExecID_() != null) {
            ps.setString(4, fgactrucasesentrypart.getCaseExecID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(4, Types.VARCHAR);
        }
        ps.setString(5, fgactrucasesentrypart.getSentryID_());
        ps.setString(6, fgactrucasesentrypart.getType_());
        ps.setString(7, fgactrucasesentrypart.getSourceCaseExecID_());
        ps.setString(8, fgactrucasesentrypart.getStandardEvent_());
        ps.setString(9, fgactrucasesentrypart.getSource_());
        ps.setString(10, fgactrucasesentrypart.getVariableEvent_());
        ps.setString(11, fgactrucasesentrypart.getVariableName_());
        java.math.BigDecimal val12 = fgactrucasesentrypart.getSatisfied_();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgactrucasesentrypart.getTenantID_());
    }

    private FgActRuCaseSentryPart extract(ResultSet rs) throws SQLException {
        FgActRuCaseSentryPart fgactrucasesentrypart = new FgActRuCaseSentryPart();
        fgactrucasesentrypart.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrucasesentrypart.setRev_(REV_);
        String CASE_INST_ID_ = rs.getObject(COL_CASE_INST_ID_, String.class);
        fgactrucasesentrypart.setCaseInstID_(CASE_INST_ID_);
        if (CASE_INST_ID_ != null) {
            FgActRuCaseExecution caseInstID_ = new FgActRuCaseExecution();
            caseInstID_.setFgActRuCaseExecutionID(CASE_INST_ID_);
            fgactrucasesentrypart.setCaseInstID_(caseInstID_);
        }
        String CASE_EXEC_ID_ = rs.getObject(COL_CASE_EXEC_ID_, String.class);
        fgactrucasesentrypart.setCaseExecID_(CASE_EXEC_ID_);
        if (CASE_EXEC_ID_ != null) {
            FgActRuCaseExecution caseExecID_ = new FgActRuCaseExecution();
            caseExecID_.setFgActRuCaseExecutionID(CASE_EXEC_ID_);
            fgactrucasesentrypart.setCaseExecID_(caseExecID_);
        }
        fgactrucasesentrypart.setSentryID_(rs.getString(COL_SENTRY_ID_));
        fgactrucasesentrypart.setType_(rs.getString(COL_TYPE_));
        fgactrucasesentrypart.setSourceCaseExecID_(rs.getString(COL_SOURCE_CASE_EXEC_ID_));
        fgactrucasesentrypart.setStandardEvent_(rs.getString(COL_STANDARD_EVENT_));
        fgactrucasesentrypart.setSource_(rs.getString(COL_SOURCE_));
        fgactrucasesentrypart.setVariableEvent_(rs.getString(COL_VARIABLE_EVENT_));
        fgactrucasesentrypart.setVariableName_(rs.getString(COL_VARIABLE_NAME_));
        java.math.BigDecimal SATISFIED_ = rs.getObject(COL_SATISFIED_, java.math.BigDecimal.class);
        fgactrucasesentrypart.setSatisfied_(SATISFIED_);
        fgactrucasesentrypart.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgactrucasesentrypart;
    }
}
