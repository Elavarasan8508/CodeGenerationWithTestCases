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

public class JdbcQrtzFiredTriggersDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzFiredTriggersDao.class);

    private static final String TABLE = "QRTZ_FIRED_TRIGGERS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_ENTRY_ID = "ENTRY_ID";

    private static final String COL_TRIGGER_NAME = "TRIGGER_NAME";

    private static final String COL_TRIGGER_GROUP = "TRIGGER_GROUP";

    private static final String COL_INSTANCE_NAME = "INSTANCE_NAME";

    private static final String COL_FIRED_TIME = "FIRED_TIME";

    private static final String COL_SCHED_TIME = "SCHED_TIME";

    private static final String COL_PRIORITY = "PRIORITY";

    private static final String COL_STATE = "STATE";

    private static final String COL_JOB_NAME = "JOB_NAME";

    private static final String COL_JOB_GROUP = "JOB_GROUP";

    private static final String COL_IS_NONCONCURRENT = "IS_NONCONCURRENT";

    private static final String COL_REQUESTS_RECOVERY = "REQUESTS_RECOVERY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_ENTRY_ID, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_INSTANCE_NAME, COL_FIRED_TIME, COL_SCHED_TIME, COL_PRIORITY, COL_STATE, COL_JOB_NAME, COL_JOB_GROUP, COL_IS_NONCONCURRENT, COL_REQUESTS_RECOVERY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, ENTRY_ID, TRIGGER_NAME, TRIGGER_GROUP, INSTANCE_NAME, FIRED_TIME, SCHED_TIME, PRIORITY, STATE, JOB_NAME, JOB_GROUP, IS_NONCONCURRENT, REQUESTS_RECOVERY", TABLE, COL_ENTRY_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, ENTRY_ID, TRIGGER_NAME, TRIGGER_GROUP, INSTANCE_NAME, FIRED_TIME, SCHED_TIME, PRIORITY, STATE, JOB_NAME, JOB_GROUP, IS_NONCONCURRENT, REQUESTS_RECOVERY", TABLE, COL_ENTRY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_INSTANCE_NAME, COL_FIRED_TIME, COL_SCHED_TIME, COL_PRIORITY, COL_STATE, COL_JOB_NAME, COL_JOB_GROUP, COL_IS_NONCONCURRENT, COL_REQUESTS_RECOVERY, COL_ENTRY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ENTRY_ID);

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

    public int insert(Connection conn, QrtzFiredTriggers qrtzfiredtriggers) throws SQLException {
        logger.debug("Inserting qrtzfiredtriggers: {}", qrtzfiredtriggers);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzFiredTriggersParams(ps, qrtzfiredtriggers);
            ps.executeUpdate();
            return qrtzfiredtriggers.getEntryID();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzFiredTriggers> qrtzfiredtriggerss) throws SQLException {
        if (qrtzfiredtriggerss == null || qrtzfiredtriggerss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzfiredtriggerss.size(); i++) {
            if (qrtzfiredtriggerss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzFiredTriggers>> batches = chunkList(qrtzfiredtriggerss, batchSize);
        int[] totalResults = new int[qrtzfiredtriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzFiredTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzFiredTriggers qrtzfiredtriggers : batch) {
                        setQrtzFiredTriggersParams(ps, qrtzfiredtriggers);
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

    public QrtzFiredTriggers findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzFiredTriggers> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzFiredTriggers> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzFiredTriggers qrtzfiredtriggers) throws SQLException {
        if (qrtzfiredtriggers.getEntryID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzFiredTriggersParams(ps, qrtzfiredtriggers);
            ps.setInt(13, qrtzfiredtriggers.getEntryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzFiredTriggers> qrtzfiredtriggerss) throws SQLException {
        if (qrtzfiredtriggerss == null || qrtzfiredtriggerss.isEmpty())
            return new int[0];
        for (QrtzFiredTriggers qrtzfiredtriggers : qrtzfiredtriggerss) {
            if (qrtzfiredtriggers == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzfiredtriggers.getEntryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzFiredTriggers>> batches = chunkList(qrtzfiredtriggerss, batchSize);
        int[] totalResults = new int[qrtzfiredtriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzFiredTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzFiredTriggers qrtzfiredtriggers : batch) {
                        setQrtzFiredTriggersParams(ps, qrtzfiredtriggers);
                        ps.setInt(13, qrtzfiredtriggers.getEntryID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ENTRY_ID, placeholders);
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

    private void setQrtzFiredTriggersParams(PreparedStatement ps, QrtzFiredTriggers qrtzfiredtriggers) throws SQLException {
        ps.setString(1, qrtzfiredtriggers.getSchedName());
        Integer val2 = qrtzfiredtriggers.getEntryID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, qrtzfiredtriggers.getTriggerName());
        ps.setString(4, qrtzfiredtriggers.getTriggerGroup());
        ps.setString(5, qrtzfiredtriggers.getInstanceName());
        java.math.BigDecimal val6 = qrtzfiredtriggers.getFiredTime();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = qrtzfiredtriggers.getSchedTime();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = qrtzfiredtriggers.getPriority();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, qrtzfiredtriggers.getState());
        ps.setString(10, qrtzfiredtriggers.getJobName());
        ps.setString(11, qrtzfiredtriggers.getJobGroup());
        ps.setString(12, qrtzfiredtriggers.getIsNonconcurrent());
        ps.setString(13, qrtzfiredtriggers.getRequestsRecovery());
    }

    private QrtzFiredTriggers extract(ResultSet rs) throws SQLException {
        QrtzFiredTriggers qrtzfiredtriggers = new QrtzFiredTriggers();
        qrtzfiredtriggers.setSchedName(rs.getString(COL_SCHED_NAME));
        Integer ENTRY_ID = rs.getObject(COL_ENTRY_ID, Integer.class);
        qrtzfiredtriggers.setEntryID(ENTRY_ID);
        qrtzfiredtriggers.setTriggerName(rs.getString(COL_TRIGGER_NAME));
        qrtzfiredtriggers.setTriggerGroup(rs.getString(COL_TRIGGER_GROUP));
        qrtzfiredtriggers.setInstanceName(rs.getString(COL_INSTANCE_NAME));
        java.math.BigDecimal FIRED_TIME = rs.getObject(COL_FIRED_TIME, java.math.BigDecimal.class);
        qrtzfiredtriggers.setFiredTime(FIRED_TIME);
        java.math.BigDecimal SCHED_TIME = rs.getObject(COL_SCHED_TIME, java.math.BigDecimal.class);
        qrtzfiredtriggers.setSchedTime(SCHED_TIME);
        java.math.BigDecimal PRIORITY = rs.getObject(COL_PRIORITY, java.math.BigDecimal.class);
        qrtzfiredtriggers.setPriority(PRIORITY);
        qrtzfiredtriggers.setState(rs.getString(COL_STATE));
        qrtzfiredtriggers.setJobName(rs.getString(COL_JOB_NAME));
        qrtzfiredtriggers.setJobGroup(rs.getString(COL_JOB_GROUP));
        qrtzfiredtriggers.setIsNonconcurrent(rs.getString(COL_IS_NONCONCURRENT));
        qrtzfiredtriggers.setRequestsRecovery(rs.getString(COL_REQUESTS_RECOVERY));
        return qrtzfiredtriggers;
    }
}
