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

public class JdbcFgActRuVariableDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuVariableDao.class);

    private static final String TABLE = "FG_ACT_RU_VARIABLE";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_CASE_EXECUTION_ID_ = "CASE_EXECUTION_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_BYTEARRAY_ID_ = "BYTEARRAY_ID_";

    private static final String COL_DOUBLE_ = "DOUBLE_";

    private static final String COL_LONG_ = "LONG_";

    private static final String COL_TEXT_ = "TEXT_";

    private static final String COL_TEXT2_ = "TEXT2_";

    private static final String COL_VAR_SCOPE_ = "VAR_SCOPE_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_IS_CONCURRENT_LOCAL_ = "IS_CONCURRENT_LOCAL_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_BATCH_ID_ = "BATCH_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_TYPE_, COL_NAME_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_CASE_EXECUTION_ID_, COL_CASE_INST_ID_, COL_TASK_ID_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_VAR_SCOPE_, COL_SEQUENCE_COUNTER_, COL_IS_CONCURRENT_LOCAL_, COL_TENANT_ID_, COL_PROC_DEF_ID_, COL_BATCH_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_BYTEARRAY_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_BYTEARRAY_ID_);

    private static final String SELECT_BY_BATCH_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_BATCH_ID_);

    private static final String SELECT_BY_CASE_INST_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_CASE_INST_ID_);

    private static final String SELECT_BY_CASE_EXECUTION_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_", TABLE, COL_CASE_EXECUTION_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_TYPE_, COL_NAME_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_CASE_EXECUTION_ID_, COL_CASE_INST_ID_, COL_TASK_ID_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_VAR_SCOPE_, COL_SEQUENCE_COUNTER_, COL_IS_CONCURRENT_LOCAL_, COL_TENANT_ID_, COL_PROC_DEF_ID_, COL_BATCH_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuVariable fgactruvariable) throws SQLException {
        logger.debug("Inserting fgactruvariable: {}", fgactruvariable);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuVariableParams(ps, fgactruvariable);
            ps.executeUpdate();
            return fgactruvariable.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuVariable> fgactruvariables) throws SQLException {
        if (fgactruvariables == null || fgactruvariables.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruvariables.size(); i++) {
            if (fgactruvariables.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuVariable>> batches = chunkList(fgactruvariables, batchSize);
        int[] totalResults = new int[fgactruvariables.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuVariable> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuVariable fgactruvariable : batch) {
                        setFgActRuVariableParams(ps, fgactruvariable);
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

    public FgActRuVariable findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuVariable> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuVariable> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuVariable fgactruvariable) throws SQLException {
        if (fgactruvariable.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuVariableParams(ps, fgactruvariable);
            ps.setString(20, fgactruvariable.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuVariable> fgactruvariables) throws SQLException {
        if (fgactruvariables == null || fgactruvariables.isEmpty())
            return new int[0];
        for (FgActRuVariable fgactruvariable : fgactruvariables) {
            if (fgactruvariable == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruvariable.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuVariable>> batches = chunkList(fgactruvariables, batchSize);
        int[] totalResults = new int[fgactruvariables.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuVariable> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuVariable fgactruvariable : batch) {
                        setFgActRuVariableParams(ps, fgactruvariable);
                        ps.setString(20, fgactruvariable.getID_());
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

    public List<FgActRuVariable> findByBytearrayID_(Connection conn, String bytearrayID_) throws SQLException {
        List<FgActRuVariable> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_BYTEARRAY_ID__SQL)) {
            ps.setString(1, bytearrayID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuVariable> findByBatchID_(Connection conn, String batchID_) throws SQLException {
        List<FgActRuVariable> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_BATCH_ID__SQL)) {
            ps.setString(1, batchID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuVariable> findByCaseInstID_(Connection conn, String caseInstID_) throws SQLException {
        List<FgActRuVariable> list = new ArrayList<>();
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

    public List<FgActRuVariable> findByCaseExecutionID_(Connection conn, String caseExecutionID_) throws SQLException {
        List<FgActRuVariable> list = new ArrayList<>();
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

    private void setFgActRuVariableParams(PreparedStatement ps, FgActRuVariable fgactruvariable) throws SQLException {
        ps.setString(1, fgactruvariable.getID_());
        java.math.BigDecimal val2 = fgactruvariable.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactruvariable.getType_());
        ps.setString(4, fgactruvariable.getName_());
        ps.setString(5, fgactruvariable.getExecutionID_());
        ps.setString(6, fgactruvariable.getProcInstID_());
        if (fgactruvariable.getCaseExecutionID_() != null) {
            ps.setString(7, fgactruvariable.getCaseExecutionID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(7, Types.VARCHAR);
        }
        if (fgactruvariable.getCaseInstID_() != null) {
            ps.setString(8, fgactruvariable.getCaseInstID_().getFgActRuCaseExecutionID());
        } else {
            ps.setNull(8, Types.VARCHAR);
        }
        ps.setString(9, fgactruvariable.getTaskID_());
        if (fgactruvariable.getBytearrayID_() != null) {
            ps.setString(10, fgactruvariable.getBytearrayID_().getFgActGeBytearrayID());
        } else {
            ps.setNull(10, Types.VARCHAR);
        }
        java.math.BigDecimal val11 = fgactruvariable.getDouble_();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = fgactruvariable.getLong_();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgactruvariable.getText_());
        ps.setString(14, fgactruvariable.getText2_());
        ps.setString(15, fgactruvariable.getVarScope_());
        java.math.BigDecimal val16 = fgactruvariable.getSequenceCounter_();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.math.BigDecimal val17 = fgactruvariable.getIsConcurrentLocal_();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgactruvariable.getTenantID_());
        ps.setString(19, fgactruvariable.getProcDefID_());
        if (fgactruvariable.getBatchID_() != null) {
            ps.setString(20, fgactruvariable.getBatchID_().getFgActRuBatchID());
        } else {
            ps.setNull(20, Types.VARCHAR);
        }
    }

    private FgActRuVariable extract(ResultSet rs) throws SQLException {
        FgActRuVariable fgactruvariable = new FgActRuVariable();
        fgactruvariable.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruvariable.setRev_(REV_);
        fgactruvariable.setType_(rs.getString(COL_TYPE_));
        fgactruvariable.setName_(rs.getString(COL_NAME_));
        fgactruvariable.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactruvariable.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        String CASE_EXECUTION_ID_ = rs.getObject(COL_CASE_EXECUTION_ID_, String.class);
        fgactruvariable.setCaseExecutionID_(CASE_EXECUTION_ID_);
        if (CASE_EXECUTION_ID_ != null) {
            FgActRuCaseExecution caseExecutionID_ = new FgActRuCaseExecution();
            caseExecutionID_.setFgActRuCaseExecutionID(CASE_EXECUTION_ID_);
            fgactruvariable.setCaseExecutionID_(caseExecutionID_);
        }
        String CASE_INST_ID_ = rs.getObject(COL_CASE_INST_ID_, String.class);
        fgactruvariable.setCaseInstID_(CASE_INST_ID_);
        if (CASE_INST_ID_ != null) {
            FgActRuCaseExecution caseInstID_ = new FgActRuCaseExecution();
            caseInstID_.setFgActRuCaseExecutionID(CASE_INST_ID_);
            fgactruvariable.setCaseInstID_(caseInstID_);
        }
        fgactruvariable.setTaskID_(rs.getString(COL_TASK_ID_));
        String BYTEARRAY_ID_ = rs.getObject(COL_BYTEARRAY_ID_, String.class);
        fgactruvariable.setBytearrayID_(BYTEARRAY_ID_);
        if (BYTEARRAY_ID_ != null) {
            FgActGeBytearray bytearrayID_ = new FgActGeBytearray();
            bytearrayID_.setFgActGeBytearrayID(BYTEARRAY_ID_);
            fgactruvariable.setBytearrayID_(bytearrayID_);
        }
        java.math.BigDecimal DOUBLE_ = rs.getObject(COL_DOUBLE_, java.math.BigDecimal.class);
        fgactruvariable.setDouble_(DOUBLE_);
        java.math.BigDecimal LONG_ = rs.getObject(COL_LONG_, java.math.BigDecimal.class);
        fgactruvariable.setLong_(LONG_);
        fgactruvariable.setText_(rs.getString(COL_TEXT_));
        fgactruvariable.setText2_(rs.getString(COL_TEXT2_));
        fgactruvariable.setVarScope_(rs.getString(COL_VAR_SCOPE_));
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgactruvariable.setSequenceCounter_(SEQUENCE_COUNTER_);
        java.math.BigDecimal IS_CONCURRENT_LOCAL_ = rs.getObject(COL_IS_CONCURRENT_LOCAL_, java.math.BigDecimal.class);
        fgactruvariable.setIsConcurrentLocal_(IS_CONCURRENT_LOCAL_);
        fgactruvariable.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactruvariable.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        String BATCH_ID_ = rs.getObject(COL_BATCH_ID_, String.class);
        fgactruvariable.setBatchID_(BATCH_ID_);
        if (BATCH_ID_ != null) {
            FgActRuBatch batchID_ = new FgActRuBatch();
            batchID_.setFgActRuBatchID(BATCH_ID_);
            fgactruvariable.setBatchID_(batchID_);
        }
        return fgactruvariable;
    }
}
