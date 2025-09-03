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

public class JdbcFgActRuBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuBatchDao.class);

    private static final String TABLE = "FG_ACT_RU_BATCH";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_TOTAL_JOBS_ = "TOTAL_JOBS_";

    private static final String COL_JOBS_CREATED_ = "JOBS_CREATED_";

    private static final String COL_JOBS_PER_SEED_ = "JOBS_PER_SEED_";

    private static final String COL_INVOCATIONS_PER_JOB_ = "INVOCATIONS_PER_JOB_";

    private static final String COL_SEED_JOB_DEF_ID_ = "SEED_JOB_DEF_ID_";

    private static final String COL_BATCH_JOB_DEF_ID_ = "BATCH_JOB_DEF_ID_";

    private static final String COL_MONITOR_JOB_DEF_ID_ = "MONITOR_JOB_DEF_ID_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_CONFIGURATION_ = "CONFIGURATION_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_CREATE_USER_ID_ = "CREATE_USER_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_TYPE_, COL_TOTAL_JOBS_, COL_JOBS_CREATED_, COL_JOBS_PER_SEED_, COL_INVOCATIONS_PER_JOB_, COL_SEED_JOB_DEF_ID_, COL_BATCH_JOB_DEF_ID_, COL_MONITOR_JOB_DEF_ID_, COL_SUSPENSION_STATE_, COL_CONFIGURATION_, COL_TENANT_ID_, COL_CREATE_USER_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_BATCH_JOB_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_", TABLE, COL_BATCH_JOB_DEF_ID_);

    private static final String SELECT_BY_SEED_JOB_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_", TABLE, COL_SEED_JOB_DEF_ID_);

    private static final String SELECT_BY_MONITOR_JOB_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_", TABLE, COL_MONITOR_JOB_DEF_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_TYPE_, COL_TOTAL_JOBS_, COL_JOBS_CREATED_, COL_JOBS_PER_SEED_, COL_INVOCATIONS_PER_JOB_, COL_SEED_JOB_DEF_ID_, COL_BATCH_JOB_DEF_ID_, COL_MONITOR_JOB_DEF_ID_, COL_SUSPENSION_STATE_, COL_CONFIGURATION_, COL_TENANT_ID_, COL_CREATE_USER_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuBatch fgactrubatch) throws SQLException {
        logger.debug("Inserting fgactrubatch: {}", fgactrubatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuBatchParams(ps, fgactrubatch);
            ps.executeUpdate();
            return fgactrubatch.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuBatch> fgactrubatchs) throws SQLException {
        if (fgactrubatchs == null || fgactrubatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrubatchs.size(); i++) {
            if (fgactrubatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuBatch>> batches = chunkList(fgactrubatchs, batchSize);
        int[] totalResults = new int[fgactrubatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuBatch fgactrubatch : batch) {
                        setFgActRuBatchParams(ps, fgactrubatch);
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

    public FgActRuBatch findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuBatch fgactrubatch) throws SQLException {
        if (fgactrubatch.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuBatchParams(ps, fgactrubatch);
            ps.setString(14, fgactrubatch.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuBatch> fgactrubatchs) throws SQLException {
        if (fgactrubatchs == null || fgactrubatchs.isEmpty())
            return new int[0];
        for (FgActRuBatch fgactrubatch : fgactrubatchs) {
            if (fgactrubatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrubatch.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuBatch>> batches = chunkList(fgactrubatchs, batchSize);
        int[] totalResults = new int[fgactrubatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuBatch fgactrubatch : batch) {
                        setFgActRuBatchParams(ps, fgactrubatch);
                        ps.setString(14, fgactrubatch.getID_());
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

    public List<FgActRuBatch> findByBatchJobDefID_(Connection conn, String batchJobDefID_) throws SQLException {
        List<FgActRuBatch> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_BATCH_JOB_DEF_ID__SQL)) {
            ps.setString(1, batchJobDefID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuBatch> findBySeedJobDefID_(Connection conn, String seedJobDefID_) throws SQLException {
        List<FgActRuBatch> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_SEED_JOB_DEF_ID__SQL)) {
            ps.setString(1, seedJobDefID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuBatch> findByMonitorJobDefID_(Connection conn, String monitorJobDefID_) throws SQLException {
        List<FgActRuBatch> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_MONITOR_JOB_DEF_ID__SQL)) {
            ps.setString(1, monitorJobDefID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuBatchParams(PreparedStatement ps, FgActRuBatch fgactrubatch) throws SQLException {
        ps.setString(1, fgactrubatch.getID_());
        java.math.BigDecimal val2 = fgactrubatch.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrubatch.getType_());
        java.math.BigDecimal val4 = fgactrubatch.getTotalJobs_();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = fgactrubatch.getJobsCreated_();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = fgactrubatch.getJobsPerSeed_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = fgactrubatch.getInvocationsPerJob_();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        if (fgactrubatch.getSeedJobDefID_() != null) {
            ps.setString(8, fgactrubatch.getSeedJobDefID_().getFgActRuJobdefID());
        } else {
            ps.setNull(8, Types.VARCHAR);
        }
        if (fgactrubatch.getBatchJobDefID_() != null) {
            ps.setString(9, fgactrubatch.getBatchJobDefID_().getFgActRuJobdefID());
        } else {
            ps.setNull(9, Types.VARCHAR);
        }
        if (fgactrubatch.getMonitorJobDefID_() != null) {
            ps.setString(10, fgactrubatch.getMonitorJobDefID_().getFgActRuJobdefID());
        } else {
            ps.setNull(10, Types.VARCHAR);
        }
        java.math.BigDecimal val11 = fgactrubatch.getSuspensionState_();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgactrubatch.getConfiguration_());
        ps.setString(13, fgactrubatch.getTenantID_());
        ps.setString(14, fgactrubatch.getCreateUserID_());
    }

    private FgActRuBatch extract(ResultSet rs) throws SQLException {
        FgActRuBatch fgactrubatch = new FgActRuBatch();
        fgactrubatch.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrubatch.setRev_(REV_);
        fgactrubatch.setType_(rs.getString(COL_TYPE_));
        java.math.BigDecimal TOTAL_JOBS_ = rs.getObject(COL_TOTAL_JOBS_, java.math.BigDecimal.class);
        fgactrubatch.setTotalJobs_(TOTAL_JOBS_);
        java.math.BigDecimal JOBS_CREATED_ = rs.getObject(COL_JOBS_CREATED_, java.math.BigDecimal.class);
        fgactrubatch.setJobsCreated_(JOBS_CREATED_);
        java.math.BigDecimal JOBS_PER_SEED_ = rs.getObject(COL_JOBS_PER_SEED_, java.math.BigDecimal.class);
        fgactrubatch.setJobsPerSeed_(JOBS_PER_SEED_);
        java.math.BigDecimal INVOCATIONS_PER_JOB_ = rs.getObject(COL_INVOCATIONS_PER_JOB_, java.math.BigDecimal.class);
        fgactrubatch.setInvocationsPerJob_(INVOCATIONS_PER_JOB_);
        String SEED_JOB_DEF_ID_ = rs.getObject(COL_SEED_JOB_DEF_ID_, String.class);
        fgactrubatch.setSeedJobDefID_(SEED_JOB_DEF_ID_);
        if (SEED_JOB_DEF_ID_ != null) {
            FgActRuJobdef seedJobDefID_ = new FgActRuJobdef();
            seedJobDefID_.setFgActRuJobdefID(SEED_JOB_DEF_ID_);
            fgactrubatch.setSeedJobDefID_(seedJobDefID_);
        }
        String BATCH_JOB_DEF_ID_ = rs.getObject(COL_BATCH_JOB_DEF_ID_, String.class);
        fgactrubatch.setBatchJobDefID_(BATCH_JOB_DEF_ID_);
        if (BATCH_JOB_DEF_ID_ != null) {
            FgActRuJobdef batchJobDefID_ = new FgActRuJobdef();
            batchJobDefID_.setFgActRuJobdefID(BATCH_JOB_DEF_ID_);
            fgactrubatch.setBatchJobDefID_(batchJobDefID_);
        }
        String MONITOR_JOB_DEF_ID_ = rs.getObject(COL_MONITOR_JOB_DEF_ID_, String.class);
        fgactrubatch.setMonitorJobDefID_(MONITOR_JOB_DEF_ID_);
        if (MONITOR_JOB_DEF_ID_ != null) {
            FgActRuJobdef monitorJobDefID_ = new FgActRuJobdef();
            monitorJobDefID_.setFgActRuJobdefID(MONITOR_JOB_DEF_ID_);
            fgactrubatch.setMonitorJobDefID_(monitorJobDefID_);
        }
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactrubatch.setSuspensionState_(SUSPENSION_STATE_);
        fgactrubatch.setConfiguration_(rs.getString(COL_CONFIGURATION_));
        fgactrubatch.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactrubatch.setCreateUserID_(rs.getString(COL_CREATE_USER_ID_));
        return fgactrubatch;
    }
}
