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

public class JdbcBatchJobExecutionContextDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBatchJobExecutionContextDao.class);

    private static final String TABLE = "BATCH_JOB_EXECUTION_CONTEXT";

    private static final String COL_JOB_EXECUTION_ID = "JOB_EXECUTION_ID";

    private static final String COL_SHORT_CONTEXT = "SHORT_CONTEXT";

    private static final String COL_SERIALIZED_CONTEXT = "SERIALIZED_CONTEXT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_JOB_EXECUTION_ID, COL_SHORT_CONTEXT, COL_SERIALIZED_CONTEXT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT", TABLE, COL_JOB_EXECUTION_ID);

    private static final String SELECT_BY_JOB_EXECUTION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT", TABLE, COL_JOB_EXECUTION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SHORT_CONTEXT, COL_SERIALIZED_CONTEXT, COL_JOB_EXECUTION_ID);

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

    public int insert(Connection conn, BatchJobExecutionContext batchjobexecutioncontext) throws SQLException {
        logger.debug("Inserting batchjobexecutioncontext: {}", batchjobexecutioncontext);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBatchJobExecutionContextParams(ps, batchjobexecutioncontext);
            ps.executeUpdate();
            return batchjobexecutioncontext.getJobExecutionID();
        }
    }

    public int[] insertAll(Connection conn, List<BatchJobExecutionContext> batchjobexecutioncontexts) throws SQLException {
        if (batchjobexecutioncontexts == null || batchjobexecutioncontexts.isEmpty())
            return new int[0];
        for (int i = 0; i < batchjobexecutioncontexts.size(); i++) {
            if (batchjobexecutioncontexts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecutionContext>> batches = chunkList(batchjobexecutioncontexts, batchSize);
        int[] totalResults = new int[batchjobexecutioncontexts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecutionContext> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (BatchJobExecutionContext batchjobexecutioncontext : batch) {
                        setBatchJobExecutionContextParams(ps, batchjobexecutioncontext);
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

    public BatchJobExecutionContext findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<BatchJobExecutionContext> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<BatchJobExecutionContext> list = new ArrayList<>();
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

    public boolean update(Connection conn, BatchJobExecutionContext batchjobexecutioncontext) throws SQLException {
        if (batchjobexecutioncontext.getJobExecutionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBatchJobExecutionContextParams(ps, batchjobexecutioncontext);
            ps.setInt(3, batchjobexecutioncontext.getJobExecutionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<BatchJobExecutionContext> batchjobexecutioncontexts) throws SQLException {
        if (batchjobexecutioncontexts == null || batchjobexecutioncontexts.isEmpty())
            return new int[0];
        for (BatchJobExecutionContext batchjobexecutioncontext : batchjobexecutioncontexts) {
            if (batchjobexecutioncontext == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (batchjobexecutioncontext.getJobExecutionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BatchJobExecutionContext>> batches = chunkList(batchjobexecutioncontexts, batchSize);
        int[] totalResults = new int[batchjobexecutioncontexts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BatchJobExecutionContext> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (BatchJobExecutionContext batchjobexecutioncontext : batch) {
                        setBatchJobExecutionContextParams(ps, batchjobexecutioncontext);
                        ps.setInt(3, batchjobexecutioncontext.getJobExecutionID());
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

    public List<BatchJobExecutionContext> findByJobExecutionID(Connection conn, int jobExecutionID) throws SQLException {
        List<BatchJobExecutionContext> list = new ArrayList<>();
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

    private void setBatchJobExecutionContextParams(PreparedStatement ps, BatchJobExecutionContext batchjobexecutioncontext) throws SQLException {
        if (batchjobexecutioncontext.getJobExecution() != null) {
            ps.setInt(1, batchjobexecutioncontext.getJobExecution().getBatchJobExecutionID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, batchjobexecutioncontext.getShortContext());
        ps.setString(3, batchjobexecutioncontext.getSerializedContext());
    }

    private BatchJobExecutionContext extract(ResultSet rs) throws SQLException {
        BatchJobExecutionContext batchjobexecutioncontext = new BatchJobExecutionContext();
        Integer JOB_EXECUTION_ID = rs.getObject(COL_JOB_EXECUTION_ID, Integer.class);
        batchjobexecutioncontext.setJobExecutionID(JOB_EXECUTION_ID);
        if (JOB_EXECUTION_ID != null) {
            BatchJobExecution jobExecution = new BatchJobExecution();
            jobExecution.setBatchJobExecutionID(JOB_EXECUTION_ID);
            batchjobexecutioncontext.setJobExecution(jobExecution);
        }
        batchjobexecutioncontext.setShortContext(rs.getString(COL_SHORT_CONTEXT));
        batchjobexecutioncontext.setSerializedContext(rs.getString(COL_SERIALIZED_CONTEXT));
        return batchjobexecutioncontext;
    }
}
