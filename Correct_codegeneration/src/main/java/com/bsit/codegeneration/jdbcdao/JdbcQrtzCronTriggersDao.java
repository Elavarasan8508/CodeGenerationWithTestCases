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

public class JdbcQrtzCronTriggersDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzCronTriggersDao.class);

    private static final String TABLE = "QRTZ_CRON_TRIGGERS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_TRIGGER_NAME = "TRIGGER_NAME";

    private static final String COL_TRIGGER_GROUP = "TRIGGER_GROUP";

    private static final String COL_CRON_EXPRESSION = "CRON_EXPRESSION";

    private static final String COL_TIME_ZONE_ID = "TIME_ZONE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_CRON_EXPRESSION, COL_TIME_ZONE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID", TABLE, COL_TIME_ZONE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID", TABLE, COL_TIME_ZONE_ID);

    private static final String SELECT_BY_SCHED_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_TRIGGER_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID", TABLE, COL_TRIGGER_NAME);

    private static final String SELECT_BY_TRIGGER_GROUP_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID", TABLE, COL_TRIGGER_GROUP);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_CRON_EXPRESSION, COL_TIME_ZONE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_TIME_ZONE_ID);

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

    public int insert(Connection conn, QrtzCronTriggers qrtzcrontriggers) throws SQLException {
        logger.debug("Inserting qrtzcrontriggers: {}", qrtzcrontriggers);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzCronTriggersParams(ps, qrtzcrontriggers);
            ps.executeUpdate();
            return qrtzcrontriggers.getTimeZoneID();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzCronTriggers> qrtzcrontriggerss) throws SQLException {
        if (qrtzcrontriggerss == null || qrtzcrontriggerss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzcrontriggerss.size(); i++) {
            if (qrtzcrontriggerss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzCronTriggers>> batches = chunkList(qrtzcrontriggerss, batchSize);
        int[] totalResults = new int[qrtzcrontriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzCronTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzCronTriggers qrtzcrontriggers : batch) {
                        setQrtzCronTriggersParams(ps, qrtzcrontriggers);
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

    public QrtzCronTriggers findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzCronTriggers> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzCronTriggers> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzCronTriggers qrtzcrontriggers) throws SQLException {
        if (qrtzcrontriggers.getTimeZoneID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzCronTriggersParams(ps, qrtzcrontriggers);
            ps.setInt(5, qrtzcrontriggers.getTimeZoneID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzCronTriggers> qrtzcrontriggerss) throws SQLException {
        if (qrtzcrontriggerss == null || qrtzcrontriggerss.isEmpty())
            return new int[0];
        for (QrtzCronTriggers qrtzcrontriggers : qrtzcrontriggerss) {
            if (qrtzcrontriggers == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzcrontriggers.getTimeZoneID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzCronTriggers>> batches = chunkList(qrtzcrontriggerss, batchSize);
        int[] totalResults = new int[qrtzcrontriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzCronTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzCronTriggers qrtzcrontriggers : batch) {
                        setQrtzCronTriggersParams(ps, qrtzcrontriggers);
                        ps.setInt(5, qrtzcrontriggers.getTimeZoneID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_TIME_ZONE_ID, placeholders);
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

    public List<QrtzCronTriggers> findBySchedName(Connection conn, String schedName) throws SQLException {
        List<QrtzCronTriggers> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_SCHED_NAME_SQL)) {
            ps.setString(1, schedName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<QrtzCronTriggers> findByTriggerName(Connection conn, String triggerName) throws SQLException {
        List<QrtzCronTriggers> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_TRIGGER_NAME_SQL)) {
            ps.setString(1, triggerName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<QrtzCronTriggers> findByTriggerGroup(Connection conn, String triggerGroup) throws SQLException {
        List<QrtzCronTriggers> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_TRIGGER_GROUP_SQL)) {
            ps.setString(1, triggerGroup);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setQrtzCronTriggersParams(PreparedStatement ps, QrtzCronTriggers qrtzcrontriggers) throws SQLException {
        if (qrtzcrontriggers.getSchedName() != null) {
            ps.setString(1, qrtzcrontriggers.getSchedName().getQrtzTriggersID());
        } else {
            ps.setNull(1, Types.VARCHAR);
        }
        if (qrtzcrontriggers.getTriggerName() != null) {
            ps.setString(2, qrtzcrontriggers.getTriggerName().getQrtzTriggersID());
        } else {
            ps.setNull(2, Types.VARCHAR);
        }
        if (qrtzcrontriggers.getTriggerGroup() != null) {
            ps.setString(3, qrtzcrontriggers.getTriggerGroup().getQrtzTriggersID());
        } else {
            ps.setNull(3, Types.VARCHAR);
        }
        ps.setString(4, qrtzcrontriggers.getCronExpression());
        Integer val5 = qrtzcrontriggers.getTimeZoneID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
    }

    private QrtzCronTriggers extract(ResultSet rs) throws SQLException {
        QrtzCronTriggers qrtzcrontriggers = new QrtzCronTriggers();
        String SCHED_NAME = rs.getObject(COL_SCHED_NAME, String.class);
        qrtzcrontriggers.setSchedName(SCHED_NAME);
        if (SCHED_NAME != null) {
            QrtzTriggers schedName = new QrtzTriggers();
            schedName.setQrtzTriggersID(SCHED_NAME);
            qrtzcrontriggers.setSchedName(schedName);
        }
        String TRIGGER_NAME = rs.getObject(COL_TRIGGER_NAME, String.class);
        qrtzcrontriggers.setTriggerName(TRIGGER_NAME);
        if (TRIGGER_NAME != null) {
            QrtzTriggers triggerName = new QrtzTriggers();
            triggerName.setQrtzTriggersID(TRIGGER_NAME);
            qrtzcrontriggers.setTriggerName(triggerName);
        }
        String TRIGGER_GROUP = rs.getObject(COL_TRIGGER_GROUP, String.class);
        qrtzcrontriggers.setTriggerGroup(TRIGGER_GROUP);
        if (TRIGGER_GROUP != null) {
            QrtzTriggers triggerGroup = new QrtzTriggers();
            triggerGroup.setQrtzTriggersID(TRIGGER_GROUP);
            qrtzcrontriggers.setTriggerGroup(triggerGroup);
        }
        qrtzcrontriggers.setCronExpression(rs.getString(COL_CRON_EXPRESSION));
        Integer TIME_ZONE_ID = rs.getObject(COL_TIME_ZONE_ID, Integer.class);
        qrtzcrontriggers.setTimeZoneID(TIME_ZONE_ID);
        return qrtzcrontriggers;
    }
}
