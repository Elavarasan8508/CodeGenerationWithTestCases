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

public class JdbcFgActHiDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiDetailDao.class);

    private static final String TABLE = "FG_ACT_HI_DETAIL";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_CASE_DEF_KEY_ = "CASE_DEF_KEY_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_CASE_EXECUTION_ID_ = "CASE_EXECUTION_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_VAR_INST_ID_ = "VAR_INST_ID_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_VAR_TYPE_ = "VAR_TYPE_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_TIME_ = "TIME_";

    private static final String COL_BYTEARRAY_ID_ = "BYTEARRAY_ID_";

    private static final String COL_DOUBLE_ = "DOUBLE_";

    private static final String COL_LONG_ = "LONG_";

    private static final String COL_TEXT_ = "TEXT_";

    private static final String COL_TEXT2_ = "TEXT2_";

    private static final String COL_SEQUENCE_COUNTER_ = "SEQUENCE_COUNTER_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_OPERATION_ID_ = "OPERATION_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String COL_INITIAL_ = "INITIAL_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TYPE_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_TASK_ID_, COL_ACT_INST_ID_, COL_VAR_INST_ID_, COL_NAME_, COL_VAR_TYPE_, COL_REV_, COL_TIME_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_OPERATION_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_INITIAL_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TYPE_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, ACT_INST_ID_, VAR_INST_ID_, NAME_, VAR_TYPE_, REV_, TIME_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, SEQUENCE_COUNTER_, TENANT_ID_, OPERATION_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, INITIAL_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TYPE_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, ACT_INST_ID_, VAR_INST_ID_, NAME_, VAR_TYPE_, REV_, TIME_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, SEQUENCE_COUNTER_, TENANT_ID_, OPERATION_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, INITIAL_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TYPE_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_CASE_EXECUTION_ID_, COL_TASK_ID_, COL_ACT_INST_ID_, COL_VAR_INST_ID_, COL_NAME_, COL_VAR_TYPE_, COL_REV_, COL_TIME_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_SEQUENCE_COUNTER_, COL_TENANT_ID_, COL_OPERATION_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_INITIAL_, COL_ID_);

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

    public String insert(Connection conn, FgActHiDetail fgacthidetail) throws SQLException {
        logger.debug("Inserting fgacthidetail: {}", fgacthidetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiDetailParams(ps, fgacthidetail);
            ps.executeUpdate();
            return fgacthidetail.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiDetail> fgacthidetails) throws SQLException {
        if (fgacthidetails == null || fgacthidetails.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthidetails.size(); i++) {
            if (fgacthidetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDetail>> batches = chunkList(fgacthidetails, batchSize);
        int[] totalResults = new int[fgacthidetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiDetail fgacthidetail : batch) {
                        setFgActHiDetailParams(ps, fgacthidetail);
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

    public FgActHiDetail findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiDetail fgacthidetail) throws SQLException {
        if (fgacthidetail.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiDetailParams(ps, fgacthidetail);
            ps.setString(28, fgacthidetail.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiDetail> fgacthidetails) throws SQLException {
        if (fgacthidetails == null || fgacthidetails.isEmpty())
            return new int[0];
        for (FgActHiDetail fgacthidetail : fgacthidetails) {
            if (fgacthidetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthidetail.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDetail>> batches = chunkList(fgacthidetails, batchSize);
        int[] totalResults = new int[fgacthidetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiDetail fgacthidetail : batch) {
                        setFgActHiDetailParams(ps, fgacthidetail);
                        ps.setString(28, fgacthidetail.getID_());
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

    private void setFgActHiDetailParams(PreparedStatement ps, FgActHiDetail fgacthidetail) throws SQLException {
        ps.setString(1, fgacthidetail.getID_());
        ps.setString(2, fgacthidetail.getType_());
        ps.setString(3, fgacthidetail.getProcDefKey_());
        ps.setString(4, fgacthidetail.getProcDefID_());
        ps.setString(5, fgacthidetail.getProcInstID_());
        ps.setString(6, fgacthidetail.getExecutionID_());
        ps.setString(7, fgacthidetail.getCaseDefKey_());
        ps.setString(8, fgacthidetail.getCaseDefID_());
        ps.setString(9, fgacthidetail.getCaseInstID_());
        ps.setString(10, fgacthidetail.getCaseExecutionID_());
        ps.setString(11, fgacthidetail.getTaskID_());
        ps.setString(12, fgacthidetail.getActInstID_());
        ps.setString(13, fgacthidetail.getVarInstID_());
        ps.setString(14, fgacthidetail.getName_());
        ps.setString(15, fgacthidetail.getVarType_());
        java.math.BigDecimal val16 = fgacthidetail.getRev_();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgacthidetail.getTime_());
        ps.setString(18, fgacthidetail.getBytearrayID_());
        java.math.BigDecimal val19 = fgacthidetail.getDouble_();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgacthidetail.getLong_();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgacthidetail.getText_());
        ps.setString(22, fgacthidetail.getText2_());
        java.math.BigDecimal val23 = fgacthidetail.getSequenceCounter_();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgacthidetail.getTenantID_());
        ps.setString(25, fgacthidetail.getOperationID_());
        ps.setString(26, fgacthidetail.getRootProcInstID_());
        ps.setString(27, fgacthidetail.getRemovalTime_());
        java.math.BigDecimal val28 = fgacthidetail.getInitial_();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
    }

    private FgActHiDetail extract(ResultSet rs) throws SQLException {
        FgActHiDetail fgacthidetail = new FgActHiDetail();
        fgacthidetail.setID_(rs.getString(COL_ID_));
        fgacthidetail.setType_(rs.getString(COL_TYPE_));
        fgacthidetail.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthidetail.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthidetail.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthidetail.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthidetail.setCaseDefKey_(rs.getString(COL_CASE_DEF_KEY_));
        fgacthidetail.setCaseDefID_(rs.getString(COL_CASE_DEF_ID_));
        fgacthidetail.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthidetail.setCaseExecutionID_(rs.getString(COL_CASE_EXECUTION_ID_));
        fgacthidetail.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthidetail.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        fgacthidetail.setVarInstID_(rs.getString(COL_VAR_INST_ID_));
        fgacthidetail.setName_(rs.getString(COL_NAME_));
        fgacthidetail.setVarType_(rs.getString(COL_VAR_TYPE_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgacthidetail.setRev_(REV_);
        fgacthidetail.setTime_(rs.getString(COL_TIME_));
        fgacthidetail.setBytearrayID_(rs.getString(COL_BYTEARRAY_ID_));
        java.math.BigDecimal DOUBLE_ = rs.getObject(COL_DOUBLE_, java.math.BigDecimal.class);
        fgacthidetail.setDouble_(DOUBLE_);
        java.math.BigDecimal LONG_ = rs.getObject(COL_LONG_, java.math.BigDecimal.class);
        fgacthidetail.setLong_(LONG_);
        fgacthidetail.setText_(rs.getString(COL_TEXT_));
        fgacthidetail.setText2_(rs.getString(COL_TEXT2_));
        java.math.BigDecimal SEQUENCE_COUNTER_ = rs.getObject(COL_SEQUENCE_COUNTER_, java.math.BigDecimal.class);
        fgacthidetail.setSequenceCounter_(SEQUENCE_COUNTER_);
        fgacthidetail.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthidetail.setOperationID_(rs.getString(COL_OPERATION_ID_));
        fgacthidetail.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthidetail.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        java.math.BigDecimal INITIAL_ = rs.getObject(COL_INITIAL_, java.math.BigDecimal.class);
        fgacthidetail.setInitial_(INITIAL_);
        return fgacthidetail;
    }
}
