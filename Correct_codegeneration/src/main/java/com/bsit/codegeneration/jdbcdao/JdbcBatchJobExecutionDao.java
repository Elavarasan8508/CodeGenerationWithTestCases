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

public class JdbcBatchJobExecutionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBatchJobExecutionDao.class);

    private static final String TABLE = "BATCH_JOB_EXECUTION";

    private static final String COL_JOB_EXECUTION_ID = "JOB_EXECUTION_ID";

    private static final String COL_VERSION = "VERSION";

    private static final String COL_JOB_INSTANCE_ID = "JOB_INSTANCE_ID";

    private static final String COL_CREATE_TIME = "CREATE_TIME";

    private static final String COL_START_TIME = "START_TIME";

    private static final String COL_END_TIME = "END_TIME";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_EXIT_CODE = "EXIT_CODE";

    private static final String COL_EXIT_MESSAGE = "EXIT_MESSAGE";

    private static final String COL_LAST_UPDATED = "LAST_UPDATED";

    private static final String COL_JOB_CONFIGURATION_LOCATION = "JOB_CONFIGURATION_LOCATION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_JOB_EXECUTION_ID, COL_VERSION, COL_JOB_INSTANCE_ID, COL_CREATE_TIME, COL_START_TIME, COL_END_TIME, COL_STATUS, COL_EXIT_CODE, COL_EXIT_MESSAGE, COL_LAST_UPDATED, COL_JOB_CONFIGURATION_LOCATION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_BY_JOB_INSTANCE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION", TABLE, COL_JOB_INSTANCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION, COL_JOB_INSTANCE_ID, COL_CREATE_TIME, COL_START_TIME, COL_END_TIME, COL_STATUS, COL_EXIT_CODE, COL_EXIT_MESSAGE, COL_LAST_UPDATED, COL_JOB_CONFIGURATION_LOCATION, COL_JOB_EXECUTION_ID);

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

    public int insert(Connection conn, BatchJobExecution batchjobexecution) throws SQLException {
        logger.debug("Inserting batchjobexecution: {}", batchjobexecution);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBatchJobExecutionParams(ps, batchjobexecution);
            ps.executeUpdate();
            return batchjobexecution.getJobExecutionID();
        }
    }

    public int[] insertAll(Connection conn, List<BatchJobExecution> batchjobexecutions) throws SQLException {
        if (batchjobexecutions == null || batchjobexecutions.isEmpty())
            return new int[0];
        for (int i = 0; i < batchjobexecutions.size(); i++) {
            if (batchjobexecutions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecution>> batches = chunkList(batchjobexecutions, batchSize);
        int[] totalResults = new int[batchjobexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (BatchJobExecution batchjobexecution : batch) {
                        setBatchJobExecutionParams(ps, batchjobexecution);
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

    public BatchJobExecution findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<BatchJobExecution> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<BatchJobExecution> list = new ArrayList<>();
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

    public boolean update(Connection conn, BatchJobExecution batchjobexecution) throws SQLException {
        if (batchjobexecution.getJobExecutionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBatchJobExecutionParams(ps, batchjobexecution);
            ps.setInt(11, batchjobexecution.getJobExecutionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<BatchJobExecution> batchjobexecutions) throws SQLException {
        if (batchjobexecutions == null || batchjobexecutions.isEmpty())
            return new int[0];
        for (BatchJobExecution batchjobexecution : batchjobexecutions) {
            if (batchjobexecution == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (batchjobexecution.getJobExecutionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecution>> batches = chunkList(batchjobexecutions, batchSize);
        int[] totalResults = new int[batchjobexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (BatchJobExecution batchjobexecution : batch) {
                        setBatchJobExecutionParams(ps, batchjobexecution);
                        ps.setInt(11, batchjobexecution.getJobExecutionID());
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

    public List<BatchJobExecution> findByJobInstanceID(Connection conn, int jobInstanceID) throws SQLException {
        List<BatchJobExecution> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_JOB_INSTANCE_ID_SQL)) {
            ps.setInt(1, jobInstanceID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setBatchJobExecutionParams(PreparedStatement ps, BatchJobExecution batchjobexecution) throws SQLException {
        Integer val1 = batchjobexecution.getJobExecutionID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        java.math.BigDecimal val2 = batchjobexecution.getVersion();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        if (batchjobexecution.getJobInstance() != null) {
            ps.setInt(3, batchjobexecution.getJobInstance().getBatchJobInstanceID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, batchjobexecution.getCreateTime());
        ps.setString(5, batchjobexecution.getStartTime());
        ps.setString(6, batchjobexecution.getEndTime());
        ps.setString(7, batchjobexecution.getStatus());
        ps.setString(8, batchjobexecution.getExitCode());
        ps.setString(9, batchjobexecution.getExitMessage());
        ps.setString(10, batchjobexecution.getLastUpdated());
        ps.setString(11, batchjobexecution.getJobConfigurationLocation());
    }

    private BatchJobExecution extract(ResultSet rs) throws SQLException {
        BatchJobExecution batchjobexecution = new BatchJobExecution();
        Integer JOB_EXECUTION_ID = rs.getObject(COL_JOB_EXECUTION_ID, Integer.class);
        batchjobexecution.setJobExecutionID(JOB_EXECUTION_ID);
        java.math.BigDecimal VERSION = rs.getObject(COL_VERSION, java.math.BigDecimal.class);
        batchjobexecution.setVersion(VERSION);
        Integer JOB_INSTANCE_ID = rs.getObject(COL_JOB_INSTANCE_ID, Integer.class);
        batchjobexecution.setJobInstanceID(JOB_INSTANCE_ID);
        if (JOB_INSTANCE_ID != null) {
            BatchJobInstance jobInstance = new BatchJobInstance();
            jobInstance.setBatchJobInstanceID(JOB_INSTANCE_ID);
            batchjobexecution.setJobInstance(jobInstance);
        }
        batchjobexecution.setCreateTime(rs.getString(COL_CREATE_TIME));
        batchjobexecution.setStartTime(rs.getString(COL_START_TIME));
        batchjobexecution.setEndTime(rs.getString(COL_END_TIME));
        batchjobexecution.setStatus(rs.getString(COL_STATUS));
        batchjobexecution.setExitCode(rs.getString(COL_EXIT_CODE));
        batchjobexecution.setExitMessage(rs.getString(COL_EXIT_MESSAGE));
        batchjobexecution.setLastUpdated(rs.getString(COL_LAST_UPDATED));
        batchjobexecution.setJobConfigurationLocation(rs.getString(COL_JOB_CONFIGURATION_LOCATION));
        return batchjobexecution;
    }
}
