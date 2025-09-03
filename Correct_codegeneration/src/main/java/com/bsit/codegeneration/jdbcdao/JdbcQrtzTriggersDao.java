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

public class JdbcQrtzTriggersDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzTriggersDao.class);

    private static final String TABLE = "QRTZ_TRIGGERS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_TRIGGER_NAME = "TRIGGER_NAME";

    private static final String COL_TRIGGER_GROUP = "TRIGGER_GROUP";

    private static final String COL_JOB_NAME = "JOB_NAME";

    private static final String COL_JOB_GROUP = "JOB_GROUP";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_NEXT_FIRE_TIME = "NEXT_FIRE_TIME";

    private static final String COL_PREV_FIRE_TIME = "PREV_FIRE_TIME";

    private static final String COL_PRIORITY = "PRIORITY";

    private static final String COL_TRIGGER_STATE = "TRIGGER_STATE";

    private static final String COL_TRIGGER_TYPE = "TRIGGER_TYPE";

    private static final String COL_START_TIME = "START_TIME";

    private static final String COL_END_TIME = "END_TIME";

    private static final String COL_CALENDAR_NAME = "CALENDAR_NAME";

    private static final String COL_MISFIRE_INSTR = "MISFIRE_INSTR";

    private static final String COL_JOB_DATA = "JOB_DATA";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_JOB_NAME, COL_JOB_GROUP, COL_DESCRIPTION, COL_NEXT_FIRE_TIME, COL_PREV_FIRE_TIME, COL_PRIORITY, COL_TRIGGER_STATE, COL_TRIGGER_TYPE, COL_START_TIME, COL_END_TIME, COL_CALENDAR_NAME, COL_MISFIRE_INSTR, COL_JOB_DATA);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA", TABLE, COL_SCHED_NAME);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_SCHED_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_JOB_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA", TABLE, COL_JOB_NAME);

    private static final String SELECT_BY_JOB_GROUP_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA", TABLE, COL_JOB_GROUP);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_JOB_NAME, COL_JOB_GROUP, COL_DESCRIPTION, COL_NEXT_FIRE_TIME, COL_PREV_FIRE_TIME, COL_PRIORITY, COL_TRIGGER_STATE, COL_TRIGGER_TYPE, COL_START_TIME, COL_END_TIME, COL_CALENDAR_NAME, COL_MISFIRE_INSTR, COL_JOB_DATA, COL_SCHED_NAME);

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

    public String insert(Connection conn, QrtzTriggers qrtztriggers) throws SQLException {
        logger.debug("Inserting qrtztriggers: {}", qrtztriggers);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzTriggersParams(ps, qrtztriggers);
            ps.executeUpdate();
            return qrtztriggers.getSchedName();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzTriggers> qrtztriggerss) throws SQLException {
        if (qrtztriggerss == null || qrtztriggerss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtztriggerss.size(); i++) {
            if (qrtztriggerss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzTriggers>> batches = chunkList(qrtztriggerss, batchSize);
        int[] totalResults = new int[qrtztriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzTriggers qrtztriggers : batch) {
                        setQrtzTriggersParams(ps, qrtztriggers);
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

    public QrtzTriggers findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzTriggers> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzTriggers> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzTriggers qrtztriggers) throws SQLException {
        if (qrtztriggers.getSchedName() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzTriggersParams(ps, qrtztriggers);
            ps.setString(16, qrtztriggers.getSchedName());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzTriggers> qrtztriggerss) throws SQLException {
        if (qrtztriggerss == null || qrtztriggerss.isEmpty())
            return new int[0];
        for (QrtzTriggers qrtztriggers : qrtztriggerss) {
            if (qrtztriggers == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtztriggers.getSchedName() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzTriggers>> batches = chunkList(qrtztriggerss, batchSize);
        int[] totalResults = new int[qrtztriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzTriggers qrtztriggers : batch) {
                        setQrtzTriggersParams(ps, qrtztriggers);
                        ps.setString(16, qrtztriggers.getSchedName());
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

    public List<QrtzTriggers> findBySchedName(Connection conn, String schedName) throws SQLException {
        List<QrtzTriggers> list = new ArrayList<>();
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

    public List<QrtzTriggers> findByJobName(Connection conn, String jobName) throws SQLException {
        List<QrtzTriggers> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_JOB_NAME_SQL)) {
            ps.setString(1, jobName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<QrtzTriggers> findByJobGroup(Connection conn, String jobGroup) throws SQLException {
        List<QrtzTriggers> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_JOB_GROUP_SQL)) {
            ps.setString(1, jobGroup);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setQrtzTriggersParams(PreparedStatement ps, QrtzTriggers qrtztriggers) throws SQLException {
        if (qrtztriggers.getSchedName() != null) {
            ps.setString(1, qrtztriggers.getSchedName().getQrtzJobDetailsID());
        } else {
            ps.setNull(1, Types.VARCHAR);
        }
        ps.setString(2, qrtztriggers.getTriggerName());
        ps.setString(3, qrtztriggers.getTriggerGroup());
        if (qrtztriggers.getJobName() != null) {
            ps.setString(4, qrtztriggers.getJobName().getQrtzJobDetailsID());
        } else {
            ps.setNull(4, Types.VARCHAR);
        }
        if (qrtztriggers.getJobGroup() != null) {
            ps.setString(5, qrtztriggers.getJobGroup().getQrtzJobDetailsID());
        } else {
            ps.setNull(5, Types.VARCHAR);
        }
        ps.setString(6, qrtztriggers.getDescription());
        java.math.BigDecimal val7 = qrtztriggers.getNextFireTime();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = qrtztriggers.getPrevFireTime();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = qrtztriggers.getPriority();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, qrtztriggers.getTriggerState());
        ps.setString(11, qrtztriggers.getTriggerType());
        java.math.BigDecimal val12 = qrtztriggers.getStartTime();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        java.math.BigDecimal val13 = qrtztriggers.getEndTime();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, qrtztriggers.getCalendarName());
        java.math.BigDecimal val15 = qrtztriggers.getMisfireInstr();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setBytes(16, qrtztriggers.getJobData());
    }

    private QrtzTriggers extract(ResultSet rs) throws SQLException {
        QrtzTriggers qrtztriggers = new QrtzTriggers();
        String SCHED_NAME = rs.getObject(COL_SCHED_NAME, String.class);
        qrtztriggers.setSchedName(SCHED_NAME);
        if (SCHED_NAME != null) {
            QrtzJobDetails schedName = new QrtzJobDetails();
            schedName.setQrtzJobDetailsID(SCHED_NAME);
            qrtztriggers.setSchedName(schedName);
        }
        qrtztriggers.setTriggerName(rs.getString(COL_TRIGGER_NAME));
        qrtztriggers.setTriggerGroup(rs.getString(COL_TRIGGER_GROUP));
        String JOB_NAME = rs.getObject(COL_JOB_NAME, String.class);
        qrtztriggers.setJobName(JOB_NAME);
        if (JOB_NAME != null) {
            QrtzJobDetails jobName = new QrtzJobDetails();
            jobName.setQrtzJobDetailsID(JOB_NAME);
            qrtztriggers.setJobName(jobName);
        }
        String JOB_GROUP = rs.getObject(COL_JOB_GROUP, String.class);
        qrtztriggers.setJobGroup(JOB_GROUP);
        if (JOB_GROUP != null) {
            QrtzJobDetails jobGroup = new QrtzJobDetails();
            jobGroup.setQrtzJobDetailsID(JOB_GROUP);
            qrtztriggers.setJobGroup(jobGroup);
        }
        qrtztriggers.setDescription(rs.getString(COL_DESCRIPTION));
        java.math.BigDecimal NEXT_FIRE_TIME = rs.getObject(COL_NEXT_FIRE_TIME, java.math.BigDecimal.class);
        qrtztriggers.setNextFireTime(NEXT_FIRE_TIME);
        java.math.BigDecimal PREV_FIRE_TIME = rs.getObject(COL_PREV_FIRE_TIME, java.math.BigDecimal.class);
        qrtztriggers.setPrevFireTime(PREV_FIRE_TIME);
        java.math.BigDecimal PRIORITY = rs.getObject(COL_PRIORITY, java.math.BigDecimal.class);
        qrtztriggers.setPriority(PRIORITY);
        qrtztriggers.setTriggerState(rs.getString(COL_TRIGGER_STATE));
        qrtztriggers.setTriggerType(rs.getString(COL_TRIGGER_TYPE));
        java.math.BigDecimal START_TIME = rs.getObject(COL_START_TIME, java.math.BigDecimal.class);
        qrtztriggers.setStartTime(START_TIME);
        java.math.BigDecimal END_TIME = rs.getObject(COL_END_TIME, java.math.BigDecimal.class);
        qrtztriggers.setEndTime(END_TIME);
        qrtztriggers.setCalendarName(rs.getString(COL_CALENDAR_NAME));
        java.math.BigDecimal MISFIRE_INSTR = rs.getObject(COL_MISFIRE_INSTR, java.math.BigDecimal.class);
        qrtztriggers.setMisfireInstr(MISFIRE_INSTR);
        qrtztriggers.setJobData(rs.getBytes(COL_JOB_DATA));
        return qrtztriggers;
    }
}
