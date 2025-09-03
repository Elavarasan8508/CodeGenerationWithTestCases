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

public class JdbcBatchStepExecutionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBatchStepExecutionDao.class);

    private static final String TABLE = "BATCH_STEP_EXECUTION";

    private static final String COL_STEP_EXECUTION_ID = "STEP_EXECUTION_ID";

    private static final String COL_VERSION = "VERSION";

    private static final String COL_STEP_NAME = "STEP_NAME";

    private static final String COL_JOB_EXECUTION_ID = "JOB_EXECUTION_ID";

    private static final String COL_CREATE_TIME = "CREATE_TIME";

    private static final String COL_START_TIME = "START_TIME";

    private static final String COL_END_TIME = "END_TIME";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_COMMIT_COUNT = "COMMIT_COUNT";

    private static final String COL_READ_COUNT = "READ_COUNT";

    private static final String COL_FILTER_COUNT = "FILTER_COUNT";

    private static final String COL_WRITE_COUNT = "WRITE_COUNT";

    private static final String COL_READ_SKIP_COUNT = "READ_SKIP_COUNT";

    private static final String COL_WRITE_SKIP_COUNT = "WRITE_SKIP_COUNT";

    private static final String COL_PROCESS_SKIP_COUNT = "PROCESS_SKIP_COUNT";

    private static final String COL_ROLLBACK_COUNT = "ROLLBACK_COUNT";

    private static final String COL_EXIT_CODE = "EXIT_CODE";

    private static final String COL_EXIT_MESSAGE = "EXIT_MESSAGE";

    private static final String COL_LAST_UPDATED = "LAST_UPDATED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_STEP_EXECUTION_ID, COL_VERSION, COL_STEP_NAME, COL_JOB_EXECUTION_ID, COL_CREATE_TIME, COL_START_TIME, COL_END_TIME, COL_STATUS, COL_COMMIT_COUNT, COL_READ_COUNT, COL_FILTER_COUNT, COL_WRITE_COUNT, COL_READ_SKIP_COUNT, COL_WRITE_SKIP_COUNT, COL_PROCESS_SKIP_COUNT, COL_ROLLBACK_COUNT, COL_EXIT_CODE, COL_EXIT_MESSAGE, COL_LAST_UPDATED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED", TABLE, COL_STEP_EXECUTION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED", TABLE, COL_STEP_EXECUTION_ID);

    private static final String SELECT_BY_JOB_EXECUTION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED", TABLE, COL_JOB_EXECUTION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION, COL_STEP_NAME, COL_JOB_EXECUTION_ID, COL_CREATE_TIME, COL_START_TIME, COL_END_TIME, COL_STATUS, COL_COMMIT_COUNT, COL_READ_COUNT, COL_FILTER_COUNT, COL_WRITE_COUNT, COL_READ_SKIP_COUNT, COL_WRITE_SKIP_COUNT, COL_PROCESS_SKIP_COUNT, COL_ROLLBACK_COUNT, COL_EXIT_CODE, COL_EXIT_MESSAGE, COL_LAST_UPDATED, COL_STEP_EXECUTION_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STEP_EXECUTION_ID);

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

    public int insert(Connection conn, BatchStepExecution batchstepexecution) throws SQLException {
        logger.debug("Inserting batchstepexecution: {}", batchstepexecution);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBatchStepExecutionParams(ps, batchstepexecution);
            ps.executeUpdate();
            return batchstepexecution.getStepExecutionID();
        }
    }

    public int[] insertAll(Connection conn, List<BatchStepExecution> batchstepexecutions) throws SQLException {
        if (batchstepexecutions == null || batchstepexecutions.isEmpty())
            return new int[0];
        for (int i = 0; i < batchstepexecutions.size(); i++) {
            if (batchstepexecutions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchStepExecution>> batches = chunkList(batchstepexecutions, batchSize);
        int[] totalResults = new int[batchstepexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchStepExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (BatchStepExecution batchstepexecution : batch) {
                        setBatchStepExecutionParams(ps, batchstepexecution);
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

    public BatchStepExecution findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<BatchStepExecution> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<BatchStepExecution> list = new ArrayList<>();
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

    public boolean update(Connection conn, BatchStepExecution batchstepexecution) throws SQLException {
        if (batchstepexecution.getStepExecutionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBatchStepExecutionParams(ps, batchstepexecution);
            ps.setInt(19, batchstepexecution.getStepExecutionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<BatchStepExecution> batchstepexecutions) throws SQLException {
        if (batchstepexecutions == null || batchstepexecutions.isEmpty())
            return new int[0];
        for (BatchStepExecution batchstepexecution : batchstepexecutions) {
            if (batchstepexecution == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (batchstepexecution.getStepExecutionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchStepExecution>> batches = chunkList(batchstepexecutions, batchSize);
        int[] totalResults = new int[batchstepexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchStepExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (BatchStepExecution batchstepexecution : batch) {
                        setBatchStepExecutionParams(ps, batchstepexecution);
                        ps.setInt(19, batchstepexecution.getStepExecutionID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_STEP_EXECUTION_ID, placeholders);
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

    public List<BatchStepExecution> findByJobExecutionID(Connection conn, int jobExecutionID) throws SQLException {
        List<BatchStepExecution> list = new ArrayList<>();
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

    private void setBatchStepExecutionParams(PreparedStatement ps, BatchStepExecution batchstepexecution) throws SQLException {
        Integer val1 = batchstepexecution.getStepExecutionID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        java.math.BigDecimal val2 = batchstepexecution.getVersion();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, batchstepexecution.getStepName());
        if (batchstepexecution.getJobExecution() != null) {
            ps.setInt(4, batchstepexecution.getJobExecution().getBatchJobExecutionID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, batchstepexecution.getCreateTime());
        ps.setString(6, batchstepexecution.getStartTime());
        ps.setString(7, batchstepexecution.getEndTime());
        ps.setString(8, batchstepexecution.getStatus());
        java.math.BigDecimal val9 = batchstepexecution.getCommitCount();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        java.math.BigDecimal val10 = batchstepexecution.getReadCount();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.math.BigDecimal val11 = batchstepexecution.getFilterCount();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = batchstepexecution.getWriteCount();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        java.math.BigDecimal val13 = batchstepexecution.getReadSkipCount();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = batchstepexecution.getWriteSkipCount();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = batchstepexecution.getProcessSkipCount();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = batchstepexecution.getRollbackCount();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, batchstepexecution.getExitCode());
        ps.setString(18, batchstepexecution.getExitMessage());
        ps.setString(19, batchstepexecution.getLastUpdated());
    }

    private BatchStepExecution extract(ResultSet rs) throws SQLException {
        BatchStepExecution batchstepexecution = new BatchStepExecution();
        Integer STEP_EXECUTION_ID = rs.getObject(COL_STEP_EXECUTION_ID, Integer.class);
        batchstepexecution.setStepExecutionID(STEP_EXECUTION_ID);
        java.math.BigDecimal VERSION = rs.getObject(COL_VERSION, java.math.BigDecimal.class);
        batchstepexecution.setVersion(VERSION);
        batchstepexecution.setStepName(rs.getString(COL_STEP_NAME));
        Integer JOB_EXECUTION_ID = rs.getObject(COL_JOB_EXECUTION_ID, Integer.class);
        batchstepexecution.setJobExecutionID(JOB_EXECUTION_ID);
        if (JOB_EXECUTION_ID != null) {
            BatchJobExecution jobExecution = new BatchJobExecution();
            jobExecution.setBatchJobExecutionID(JOB_EXECUTION_ID);
            batchstepexecution.setJobExecution(jobExecution);
        }
        batchstepexecution.setCreateTime(rs.getString(COL_CREATE_TIME));
        batchstepexecution.setStartTime(rs.getString(COL_START_TIME));
        batchstepexecution.setEndTime(rs.getString(COL_END_TIME));
        batchstepexecution.setStatus(rs.getString(COL_STATUS));
        java.math.BigDecimal COMMIT_COUNT = rs.getObject(COL_COMMIT_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setCommitCount(COMMIT_COUNT);
        java.math.BigDecimal READ_COUNT = rs.getObject(COL_READ_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setReadCount(READ_COUNT);
        java.math.BigDecimal FILTER_COUNT = rs.getObject(COL_FILTER_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setFilterCount(FILTER_COUNT);
        java.math.BigDecimal WRITE_COUNT = rs.getObject(COL_WRITE_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setWriteCount(WRITE_COUNT);
        java.math.BigDecimal READ_SKIP_COUNT = rs.getObject(COL_READ_SKIP_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setReadSkipCount(READ_SKIP_COUNT);
        java.math.BigDecimal WRITE_SKIP_COUNT = rs.getObject(COL_WRITE_SKIP_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setWriteSkipCount(WRITE_SKIP_COUNT);
        java.math.BigDecimal PROCESS_SKIP_COUNT = rs.getObject(COL_PROCESS_SKIP_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setProcessSkipCount(PROCESS_SKIP_COUNT);
        java.math.BigDecimal ROLLBACK_COUNT = rs.getObject(COL_ROLLBACK_COUNT, java.math.BigDecimal.class);
        batchstepexecution.setRollbackCount(ROLLBACK_COUNT);
        batchstepexecution.setExitCode(rs.getString(COL_EXIT_CODE));
        batchstepexecution.setExitMessage(rs.getString(COL_EXIT_MESSAGE));
        batchstepexecution.setLastUpdated(rs.getString(COL_LAST_UPDATED));
        return batchstepexecution;
    }
}
