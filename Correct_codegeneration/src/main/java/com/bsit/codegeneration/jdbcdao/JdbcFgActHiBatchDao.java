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

public class JdbcFgActHiBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiBatchDao.class);

    private static final String TABLE = "FG_ACT_HI_BATCH";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_TOTAL_JOBS_ = "TOTAL_JOBS_";

    private static final String COL_JOBS_PER_SEED_ = "JOBS_PER_SEED_";

    private static final String COL_INVOCATIONS_PER_JOB_ = "INVOCATIONS_PER_JOB_";

    private static final String COL_SEED_JOB_DEF_ID_ = "SEED_JOB_DEF_ID_";

    private static final String COL_MONITOR_JOB_DEF_ID_ = "MONITOR_JOB_DEF_ID_";

    private static final String COL_BATCH_JOB_DEF_ID_ = "BATCH_JOB_DEF_ID_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_START_TIME_ = "START_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_CREATE_USER_ID_ = "CREATE_USER_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TYPE_, COL_TOTAL_JOBS_, COL_JOBS_PER_SEED_, COL_INVOCATIONS_PER_JOB_, COL_SEED_JOB_DEF_ID_, COL_MONITOR_JOB_DEF_ID_, COL_BATCH_JOB_DEF_ID_, COL_TENANT_ID_, COL_START_TIME_, COL_END_TIME_, COL_CREATE_USER_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, TENANT_ID_, START_TIME_, END_TIME_, CREATE_USER_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, TENANT_ID_, START_TIME_, END_TIME_, CREATE_USER_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TYPE_, COL_TOTAL_JOBS_, COL_JOBS_PER_SEED_, COL_INVOCATIONS_PER_JOB_, COL_SEED_JOB_DEF_ID_, COL_MONITOR_JOB_DEF_ID_, COL_BATCH_JOB_DEF_ID_, COL_TENANT_ID_, COL_START_TIME_, COL_END_TIME_, COL_CREATE_USER_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiBatch fgacthibatch) throws SQLException {
        logger.debug("Inserting fgacthibatch: {}", fgacthibatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiBatchParams(ps, fgacthibatch);
            ps.executeUpdate();
            return fgacthibatch.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiBatch> fgacthibatchs) throws SQLException {
        if (fgacthibatchs == null || fgacthibatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthibatchs.size(); i++) {
            if (fgacthibatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiBatch>> batches = chunkList(fgacthibatchs, batchSize);
        int[] totalResults = new int[fgacthibatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiBatch fgacthibatch : batch) {
                        setFgActHiBatchParams(ps, fgacthibatch);
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

    public FgActHiBatch findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiBatch fgacthibatch) throws SQLException {
        if (fgacthibatch.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiBatchParams(ps, fgacthibatch);
            ps.setString(13, fgacthibatch.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiBatch> fgacthibatchs) throws SQLException {
        if (fgacthibatchs == null || fgacthibatchs.isEmpty())
            return new int[0];
        for (FgActHiBatch fgacthibatch : fgacthibatchs) {
            if (fgacthibatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthibatch.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiBatch>> batches = chunkList(fgacthibatchs, batchSize);
        int[] totalResults = new int[fgacthibatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiBatch fgacthibatch : batch) {
                        setFgActHiBatchParams(ps, fgacthibatch);
                        ps.setString(13, fgacthibatch.getID_());
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

    private void setFgActHiBatchParams(PreparedStatement ps, FgActHiBatch fgacthibatch) throws SQLException {
        ps.setString(1, fgacthibatch.getID_());
        ps.setString(2, fgacthibatch.getType_());
        java.math.BigDecimal val3 = fgacthibatch.getTotalJobs_();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = fgacthibatch.getJobsPerSeed_();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = fgacthibatch.getInvocationsPerJob_();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, fgacthibatch.getSeedJobDefID_());
        ps.setString(7, fgacthibatch.getMonitorJobDefID_());
        ps.setString(8, fgacthibatch.getBatchJobDefID_());
        ps.setString(9, fgacthibatch.getTenantID_());
        ps.setString(10, fgacthibatch.getStartTime_());
        ps.setString(11, fgacthibatch.getEndTime_());
        ps.setString(12, fgacthibatch.getCreateUserID_());
        ps.setString(13, fgacthibatch.getRemovalTime_());
    }

    private FgActHiBatch extract(ResultSet rs) throws SQLException {
        FgActHiBatch fgacthibatch = new FgActHiBatch();
        fgacthibatch.setID_(rs.getString(COL_ID_));
        fgacthibatch.setType_(rs.getString(COL_TYPE_));
        java.math.BigDecimal TOTAL_JOBS_ = rs.getObject(COL_TOTAL_JOBS_, java.math.BigDecimal.class);
        fgacthibatch.setTotalJobs_(TOTAL_JOBS_);
        java.math.BigDecimal JOBS_PER_SEED_ = rs.getObject(COL_JOBS_PER_SEED_, java.math.BigDecimal.class);
        fgacthibatch.setJobsPerSeed_(JOBS_PER_SEED_);
        java.math.BigDecimal INVOCATIONS_PER_JOB_ = rs.getObject(COL_INVOCATIONS_PER_JOB_, java.math.BigDecimal.class);
        fgacthibatch.setInvocationsPerJob_(INVOCATIONS_PER_JOB_);
        fgacthibatch.setSeedJobDefID_(rs.getString(COL_SEED_JOB_DEF_ID_));
        fgacthibatch.setMonitorJobDefID_(rs.getString(COL_MONITOR_JOB_DEF_ID_));
        fgacthibatch.setBatchJobDefID_(rs.getString(COL_BATCH_JOB_DEF_ID_));
        fgacthibatch.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthibatch.setStartTime_(rs.getString(COL_START_TIME_));
        fgacthibatch.setEndTime_(rs.getString(COL_END_TIME_));
        fgacthibatch.setCreateUserID_(rs.getString(COL_CREATE_USER_ID_));
        fgacthibatch.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthibatch;
    }
}
