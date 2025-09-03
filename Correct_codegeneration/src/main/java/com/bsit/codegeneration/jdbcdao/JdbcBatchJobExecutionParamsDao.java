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

public class JdbcBatchJobExecutionParamsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBatchJobExecutionParamsDao.class);

    private static final String TABLE = "BATCH_JOB_EXECUTION_PARAMS";

    private static final String COL_JOB_EXECUTION_ID = "JOB_EXECUTION_ID";

    private static final String COL_PARAMETER_NAME = "PARAMETER_NAME";

    private static final String COL_PARAMETER_TYPE = "PARAMETER_TYPE";

    private static final String COL_PARAMETER_VALUE = "PARAMETER_VALUE";

    private static final String COL_IDENTIFYING = "IDENTIFYING";

    private static final String COL_DOUBLE_VAL = "DOUBLE_VAL";

    private static final String COL_LONG_VAL = "LONG_VAL";

    private static final String COL_DATE_VAL = "DATE_VAL";

    private static final String COL_KEY_NAME = "KEY_NAME";

    private static final String COL_STRING_VAL = "STRING_VAL";

    private static final String COL_TYPE_CD = "TYPE_CD";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_JOB_EXECUTION_ID, COL_PARAMETER_NAME, COL_PARAMETER_TYPE, COL_PARAMETER_VALUE, COL_IDENTIFYING, COL_DOUBLE_VAL, COL_LONG_VAL, COL_DATE_VAL, COL_KEY_NAME, COL_STRING_VAL, COL_TYPE_CD);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_BY_JOB_EXECUTION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD", TABLE, COL_JOB_EXECUTION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARAMETER_NAME, COL_PARAMETER_TYPE, COL_PARAMETER_VALUE, COL_IDENTIFYING, COL_DOUBLE_VAL, COL_LONG_VAL, COL_DATE_VAL, COL_KEY_NAME, COL_STRING_VAL, COL_TYPE_CD, COL_JOB_EXECUTION_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_JOB_EXECUTION_ID);

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

    public int insert(Connection conn, BatchJobExecutionParams batchjobexecutionparams) throws SQLException {
        logger.debug("Inserting batchjobexecutionparams: {}", batchjobexecutionparams);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBatchJobExecutionParamsParams(ps, batchjobexecutionparams);
            ps.executeUpdate();
            return batchjobexecutionparams.getJobExecutionID();
        }
    }

    public int[] insertAll(Connection conn, List<BatchJobExecutionParams> batchjobexecutionparamss) throws SQLException {
        if (batchjobexecutionparamss == null || batchjobexecutionparamss.isEmpty())
            return new int[0];
        for (int i = 0; i < batchjobexecutionparamss.size(); i++) {
            if (batchjobexecutionparamss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecutionParams>> batches = chunkList(batchjobexecutionparamss, batchSize);
        int[] totalResults = new int[batchjobexecutionparamss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecutionParams> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (BatchJobExecutionParams batchjobexecutionparams : batch) {
                        setBatchJobExecutionParamsParams(ps, batchjobexecutionparams);
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

    public BatchJobExecutionParams findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<BatchJobExecutionParams> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<BatchJobExecutionParams> list = new ArrayList<>();
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

    public boolean update(Connection conn, BatchJobExecutionParams batchjobexecutionparams) throws SQLException {
        if (batchjobexecutionparams.getJobExecutionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBatchJobExecutionParamsParams(ps, batchjobexecutionparams);
            ps.setInt(11, batchjobexecutionparams.getJobExecutionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<BatchJobExecutionParams> batchjobexecutionparamss) throws SQLException {
        if (batchjobexecutionparamss == null || batchjobexecutionparamss.isEmpty())
            return new int[0];
        for (BatchJobExecutionParams batchjobexecutionparams : batchjobexecutionparamss) {
            if (batchjobexecutionparams == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (batchjobexecutionparams.getJobExecutionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecutionParams>> batches = chunkList(batchjobexecutionparamss, batchSize);
        int[] totalResults = new int[batchjobexecutionparamss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecutionParams> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (BatchJobExecutionParams batchjobexecutionparams : batch) {
                        setBatchJobExecutionParamsParams(ps, batchjobexecutionparams);
                        ps.setInt(11, batchjobexecutionparams.getJobExecutionID());
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

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Integer> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_JOB_EXECUTION_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
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

    public List<BatchJobExecutionParams> findByJobExecutionID(Connection conn, int jobExecutionID) throws SQLException {
        List<BatchJobExecutionParams> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_JOB_EXECUTION_ID_SQL)) {
            ps.setInt(1, jobExecutionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setBatchJobExecutionParamsParams(PreparedStatement ps, BatchJobExecutionParams batchjobexecutionparams) throws SQLException {
        if (batchjobexecutionparams.getJobExecution() != null) {
            ps.setInt(1, batchjobexecutionparams.getJobExecution().getBatchJobExecutionID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, batchjobexecutionparams.getParameterName());
        ps.setString(3, batchjobexecutionparams.getParameterType());
        ps.setString(4, batchjobexecutionparams.getParameterValue());
        ps.setString(5, batchjobexecutionparams.getIdentifying());
        java.math.BigDecimal val6 = batchjobexecutionparams.getDoubleVal();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = batchjobexecutionparams.getLongVal();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, batchjobexecutionparams.getDateVal());
        ps.setString(9, batchjobexecutionparams.getKeyName());
        ps.setString(10, batchjobexecutionparams.getStringVal());
        ps.setString(11, batchjobexecutionparams.getTypeCd());
    }

    private BatchJobExecutionParams extract(ResultSet rs) throws SQLException {
        BatchJobExecutionParams batchjobexecutionparams = new BatchJobExecutionParams();
        Integer JOB_EXECUTION_ID = rs.getObject(COL_JOB_EXECUTION_ID, Integer.class);
        batchjobexecutionparams.setJobExecutionID(JOB_EXECUTION_ID);
        if (JOB_EXECUTION_ID != null) {
            BatchJobExecution jobExecution = new BatchJobExecution();
            jobExecution.setBatchJobExecutionID(JOB_EXECUTION_ID);
            batchjobexecutionparams.setJobExecution(jobExecution);
        }
        batchjobexecutionparams.setParameterName(rs.getString(COL_PARAMETER_NAME));
        batchjobexecutionparams.setParameterType(rs.getString(COL_PARAMETER_TYPE));
        batchjobexecutionparams.setParameterValue(rs.getString(COL_PARAMETER_VALUE));
        batchjobexecutionparams.setIdentifying(rs.getString(COL_IDENTIFYING));
        java.math.BigDecimal DOUBLE_VAL = rs.getObject(COL_DOUBLE_VAL, java.math.BigDecimal.class);
        batchjobexecutionparams.setDoubleVal(DOUBLE_VAL);
        java.math.BigDecimal LONG_VAL = rs.getObject(COL_LONG_VAL, java.math.BigDecimal.class);
        batchjobexecutionparams.setLongVal(LONG_VAL);
        batchjobexecutionparams.setDateVal(rs.getString(COL_DATE_VAL));
        batchjobexecutionparams.setKeyName(rs.getString(COL_KEY_NAME));
        batchjobexecutionparams.setStringVal(rs.getString(COL_STRING_VAL));
        batchjobexecutionparams.setTypeCd(rs.getString(COL_TYPE_CD));
        return batchjobexecutionparams;
    }
}
