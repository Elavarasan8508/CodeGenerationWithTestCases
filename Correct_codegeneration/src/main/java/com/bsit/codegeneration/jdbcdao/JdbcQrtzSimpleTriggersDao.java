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

public class JdbcQrtzSimpleTriggersDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzSimpleTriggersDao.class);

    private static final String TABLE = "QRTZ_SIMPLE_TRIGGERS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_TRIGGER_NAME = "TRIGGER_NAME";

    private static final String COL_TRIGGER_GROUP = "TRIGGER_GROUP";

    private static final String COL_REPEAT_COUNT = "REPEAT_COUNT";

    private static final String COL_REPEAT_INTERVAL = "REPEAT_INTERVAL";

    private static final String COL_TIMES_TRIGGERED = "TIMES_TRIGGERED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_REPEAT_COUNT, COL_REPEAT_INTERVAL, COL_TIMES_TRIGGERED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED", TABLE, COL_SCHED_NAME);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_SCHED_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_TRIGGER_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED", TABLE, COL_TRIGGER_NAME);

    private static final String SELECT_BY_TRIGGER_GROUP_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED", TABLE, COL_TRIGGER_GROUP);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_REPEAT_COUNT, COL_REPEAT_INTERVAL, COL_TIMES_TRIGGERED, COL_SCHED_NAME);

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

    public String insert(Connection conn, QrtzSimpleTriggers qrtzsimpletriggers) throws SQLException {
        logger.debug("Inserting qrtzsimpletriggers: {}", qrtzsimpletriggers);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzSimpleTriggersParams(ps, qrtzsimpletriggers);
            ps.executeUpdate();
            return qrtzsimpletriggers.getSchedName();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzSimpleTriggers> qrtzsimpletriggerss) throws SQLException {
        if (qrtzsimpletriggerss == null || qrtzsimpletriggerss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzsimpletriggerss.size(); i++) {
            if (qrtzsimpletriggerss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSimpleTriggers>> batches = chunkList(qrtzsimpletriggerss, batchSize);
        int[] totalResults = new int[qrtzsimpletriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSimpleTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzSimpleTriggers qrtzsimpletriggers : batch) {
                        setQrtzSimpleTriggersParams(ps, qrtzsimpletriggers);
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

    public QrtzSimpleTriggers findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzSimpleTriggers> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzSimpleTriggers> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzSimpleTriggers qrtzsimpletriggers) throws SQLException {
        if (qrtzsimpletriggers.getSchedName() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzSimpleTriggersParams(ps, qrtzsimpletriggers);
            ps.setString(6, qrtzsimpletriggers.getSchedName());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzSimpleTriggers> qrtzsimpletriggerss) throws SQLException {
        if (qrtzsimpletriggerss == null || qrtzsimpletriggerss.isEmpty())
            return new int[0];
        for (QrtzSimpleTriggers qrtzsimpletriggers : qrtzsimpletriggerss) {
            if (qrtzsimpletriggers == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzsimpletriggers.getSchedName() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSimpleTriggers>> batches = chunkList(qrtzsimpletriggerss, batchSize);
        int[] totalResults = new int[qrtzsimpletriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSimpleTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzSimpleTriggers qrtzsimpletriggers : batch) {
                        setQrtzSimpleTriggersParams(ps, qrtzsimpletriggers);
                        ps.setString(6, qrtzsimpletriggers.getSchedName());
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

    public List<QrtzSimpleTriggers> findBySchedName(Connection conn, String schedName) throws SQLException {
        List<QrtzSimpleTriggers> list = new ArrayList<>();
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

    public List<QrtzSimpleTriggers> findByTriggerName(Connection conn, String triggerName) throws SQLException {
        List<QrtzSimpleTriggers> list = new ArrayList<>();
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

    public List<QrtzSimpleTriggers> findByTriggerGroup(Connection conn, String triggerGroup) throws SQLException {
        List<QrtzSimpleTriggers> list = new ArrayList<>();
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

    private void setQrtzSimpleTriggersParams(PreparedStatement ps, QrtzSimpleTriggers qrtzsimpletriggers) throws SQLException {
        if (qrtzsimpletriggers.getSchedName() != null) {
            ps.setString(1, qrtzsimpletriggers.getSchedName().getQrtzTriggersID());
        } else {
            ps.setNull(1, Types.VARCHAR);
        }
        if (qrtzsimpletriggers.getTriggerName() != null) {
            ps.setString(2, qrtzsimpletriggers.getTriggerName().getQrtzTriggersID());
        } else {
            ps.setNull(2, Types.VARCHAR);
        }
        if (qrtzsimpletriggers.getTriggerGroup() != null) {
            ps.setString(3, qrtzsimpletriggers.getTriggerGroup().getQrtzTriggersID());
        } else {
            ps.setNull(3, Types.VARCHAR);
        }
        java.math.BigDecimal val4 = qrtzsimpletriggers.getRepeatCount();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = qrtzsimpletriggers.getRepeatInterval();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = qrtzsimpletriggers.getTimesTriggered();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
    }

    private QrtzSimpleTriggers extract(ResultSet rs) throws SQLException {
        QrtzSimpleTriggers qrtzsimpletriggers = new QrtzSimpleTriggers();
        String SCHED_NAME = rs.getObject(COL_SCHED_NAME, String.class);
        qrtzsimpletriggers.setSchedName(SCHED_NAME);
        if (SCHED_NAME != null) {
            QrtzTriggers schedName = new QrtzTriggers();
            schedName.setQrtzTriggersID(SCHED_NAME);
            qrtzsimpletriggers.setSchedName(schedName);
        }
        String TRIGGER_NAME = rs.getObject(COL_TRIGGER_NAME, String.class);
        qrtzsimpletriggers.setTriggerName(TRIGGER_NAME);
        if (TRIGGER_NAME != null) {
            QrtzTriggers triggerName = new QrtzTriggers();
            triggerName.setQrtzTriggersID(TRIGGER_NAME);
            qrtzsimpletriggers.setTriggerName(triggerName);
        }
        String TRIGGER_GROUP = rs.getObject(COL_TRIGGER_GROUP, String.class);
        qrtzsimpletriggers.setTriggerGroup(TRIGGER_GROUP);
        if (TRIGGER_GROUP != null) {
            QrtzTriggers triggerGroup = new QrtzTriggers();
            triggerGroup.setQrtzTriggersID(TRIGGER_GROUP);
            qrtzsimpletriggers.setTriggerGroup(triggerGroup);
        }
        java.math.BigDecimal REPEAT_COUNT = rs.getObject(COL_REPEAT_COUNT, java.math.BigDecimal.class);
        qrtzsimpletriggers.setRepeatCount(REPEAT_COUNT);
        java.math.BigDecimal REPEAT_INTERVAL = rs.getObject(COL_REPEAT_INTERVAL, java.math.BigDecimal.class);
        qrtzsimpletriggers.setRepeatInterval(REPEAT_INTERVAL);
        java.math.BigDecimal TIMES_TRIGGERED = rs.getObject(COL_TIMES_TRIGGERED, java.math.BigDecimal.class);
        qrtzsimpletriggers.setTimesTriggered(TIMES_TRIGGERED);
        return qrtzsimpletriggers;
    }
}
