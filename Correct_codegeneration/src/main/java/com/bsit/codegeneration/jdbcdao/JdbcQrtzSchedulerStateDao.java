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

public class JdbcQrtzSchedulerStateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzSchedulerStateDao.class);

    private static final String TABLE = "QRTZ_SCHEDULER_STATE";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_INSTANCE_NAME = "INSTANCE_NAME";

    private static final String COL_LAST_CHECKIN_TIME = "LAST_CHECKIN_TIME";

    private static final String COL_CHECKIN_INTERVAL = "CHECKIN_INTERVAL";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s)
        VALUES (?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_INSTANCE_NAME, COL_LAST_CHECKIN_TIME, COL_CHECKIN_INTERVAL);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, INSTANCE_NAME, LAST_CHECKIN_TIME, CHECKIN_INTERVAL", TABLE, COL_SCHED_NAME);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, INSTANCE_NAME, LAST_CHECKIN_TIME, CHECKIN_INTERVAL", TABLE, COL_SCHED_NAME);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_INSTANCE_NAME, COL_LAST_CHECKIN_TIME, COL_CHECKIN_INTERVAL, COL_SCHED_NAME);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_SCHED_NAME);

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

    public String insert(Connection conn, QrtzSchedulerState qrtzschedulerstate) throws SQLException {
        logger.debug("Inserting qrtzschedulerstate: {}", qrtzschedulerstate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzSchedulerStateParams(ps, qrtzschedulerstate);
            ps.executeUpdate();
            return qrtzschedulerstate.getSchedName();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzSchedulerState> qrtzschedulerstates) throws SQLException {
        if (qrtzschedulerstates == null || qrtzschedulerstates.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzschedulerstates.size(); i++) {
            if (qrtzschedulerstates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSchedulerState>> batches = chunkList(qrtzschedulerstates, batchSize);
        int[] totalResults = new int[qrtzschedulerstates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSchedulerState> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzSchedulerState qrtzschedulerstate : batch) {
                        setQrtzSchedulerStateParams(ps, qrtzschedulerstate);
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

    public QrtzSchedulerState findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzSchedulerState> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzSchedulerState> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzSchedulerState qrtzschedulerstate) throws SQLException {
        if (qrtzschedulerstate.getSchedName() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzSchedulerStateParams(ps, qrtzschedulerstate);
            ps.setString(4, qrtzschedulerstate.getSchedName());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzSchedulerState> qrtzschedulerstates) throws SQLException {
        if (qrtzschedulerstates == null || qrtzschedulerstates.isEmpty())
            return new int[0];
        for (QrtzSchedulerState qrtzschedulerstate : qrtzschedulerstates) {
            if (qrtzschedulerstate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzschedulerstate.getSchedName() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSchedulerState>> batches = chunkList(qrtzschedulerstates, batchSize);
        int[] totalResults = new int[qrtzschedulerstates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSchedulerState> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzSchedulerState qrtzschedulerstate : batch) {
                        setQrtzSchedulerStateParams(ps, qrtzschedulerstate);
                        ps.setString(4, qrtzschedulerstate.getSchedName());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_SCHED_NAME, placeholders);
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

    private void setQrtzSchedulerStateParams(PreparedStatement ps, QrtzSchedulerState qrtzschedulerstate) throws SQLException {
        ps.setString(1, qrtzschedulerstate.getSchedName());
        ps.setString(2, qrtzschedulerstate.getInstanceName());
        java.math.BigDecimal val3 = qrtzschedulerstate.getLastCheckinTime();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = qrtzschedulerstate.getCheckinInterval();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
    }

    private QrtzSchedulerState extract(ResultSet rs) throws SQLException {
        QrtzSchedulerState qrtzschedulerstate = new QrtzSchedulerState();
        qrtzschedulerstate.setSchedName(rs.getString(COL_SCHED_NAME));
        qrtzschedulerstate.setInstanceName(rs.getString(COL_INSTANCE_NAME));
        java.math.BigDecimal LAST_CHECKIN_TIME = rs.getObject(COL_LAST_CHECKIN_TIME, java.math.BigDecimal.class);
        qrtzschedulerstate.setLastCheckinTime(LAST_CHECKIN_TIME);
        java.math.BigDecimal CHECKIN_INTERVAL = rs.getObject(COL_CHECKIN_INTERVAL, java.math.BigDecimal.class);
        qrtzschedulerstate.setCheckinInterval(CHECKIN_INTERVAL);
        return qrtzschedulerstate;
    }
}
