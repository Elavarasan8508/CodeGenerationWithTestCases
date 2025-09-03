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

public class JdbcQrtzSimpropTriggersDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzSimpropTriggersDao.class);

    private static final String TABLE = "QRTZ_SIMPROP_TRIGGERS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_TRIGGER_NAME = "TRIGGER_NAME";

    private static final String COL_TRIGGER_GROUP = "TRIGGER_GROUP";

    private static final String COL_STR_PROP_1 = "STR_PROP_1";

    private static final String COL_STR_PROP_2 = "STR_PROP_2";

    private static final String COL_STR_PROP_3 = "STR_PROP_3";

    private static final String COL_INT_PROP_1 = "INT_PROP_1";

    private static final String COL_INT_PROP_2 = "INT_PROP_2";

    private static final String COL_LONG_PROP_1 = "LONG_PROP_1";

    private static final String COL_LONG_PROP_2 = "LONG_PROP_2";

    private static final String COL_DEC_PROP_1 = "DEC_PROP_1";

    private static final String COL_DEC_PROP_2 = "DEC_PROP_2";

    private static final String COL_BOOL_PROP_1 = "BOOL_PROP_1";

    private static final String COL_BOOL_PROP_2 = "BOOL_PROP_2";

    private static final String COL_TIME_ZONE_ID = "TIME_ZONE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_STR_PROP_1, COL_STR_PROP_2, COL_STR_PROP_3, COL_INT_PROP_1, COL_INT_PROP_2, COL_LONG_PROP_1, COL_LONG_PROP_2, COL_DEC_PROP_1, COL_DEC_PROP_2, COL_BOOL_PROP_1, COL_BOOL_PROP_2, COL_TIME_ZONE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID", TABLE, COL_TIME_ZONE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID", TABLE, COL_TIME_ZONE_ID);

    private static final String SELECT_BY_SCHED_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID", TABLE, COL_SCHED_NAME);

    private static final String SELECT_BY_TRIGGER_NAME_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID", TABLE, COL_TRIGGER_NAME);

    private static final String SELECT_BY_TRIGGER_GROUP_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID", TABLE, COL_TRIGGER_GROUP);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SCHED_NAME, COL_TRIGGER_NAME, COL_TRIGGER_GROUP, COL_STR_PROP_1, COL_STR_PROP_2, COL_STR_PROP_3, COL_INT_PROP_1, COL_INT_PROP_2, COL_LONG_PROP_1, COL_LONG_PROP_2, COL_DEC_PROP_1, COL_DEC_PROP_2, COL_BOOL_PROP_1, COL_BOOL_PROP_2, COL_TIME_ZONE_ID);

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

    public int insert(Connection conn, QrtzSimpropTriggers qrtzsimproptriggers) throws SQLException {
        logger.debug("Inserting qrtzsimproptriggers: {}", qrtzsimproptriggers);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzSimpropTriggersParams(ps, qrtzsimproptriggers);
            ps.executeUpdate();
            return qrtzsimproptriggers.getTimeZoneID();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzSimpropTriggers> qrtzsimproptriggerss) throws SQLException {
        if (qrtzsimproptriggerss == null || qrtzsimproptriggerss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzsimproptriggerss.size(); i++) {
            if (qrtzsimproptriggerss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSimpropTriggers>> batches = chunkList(qrtzsimproptriggerss, batchSize);
        int[] totalResults = new int[qrtzsimproptriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSimpropTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzSimpropTriggers qrtzsimproptriggers : batch) {
                        setQrtzSimpropTriggersParams(ps, qrtzsimproptriggers);
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

    public QrtzSimpropTriggers findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzSimpropTriggers> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzSimpropTriggers> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzSimpropTriggers qrtzsimproptriggers) throws SQLException {
        if (qrtzsimproptriggers.getTimeZoneID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzSimpropTriggersParams(ps, qrtzsimproptriggers);
            ps.setInt(15, qrtzsimproptriggers.getTimeZoneID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzSimpropTriggers> qrtzsimproptriggerss) throws SQLException {
        if (qrtzsimproptriggerss == null || qrtzsimproptriggerss.isEmpty())
            return new int[0];
        for (QrtzSimpropTriggers qrtzsimproptriggers : qrtzsimproptriggerss) {
            if (qrtzsimproptriggers == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzsimproptriggers.getTimeZoneID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzSimpropTriggers>> batches = chunkList(qrtzsimproptriggerss, batchSize);
        int[] totalResults = new int[qrtzsimproptriggerss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzSimpropTriggers> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzSimpropTriggers qrtzsimproptriggers : batch) {
                        setQrtzSimpropTriggersParams(ps, qrtzsimproptriggers);
                        ps.setInt(15, qrtzsimproptriggers.getTimeZoneID());
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

    public List<QrtzSimpropTriggers> findBySchedName(Connection conn, String schedName) throws SQLException {
        List<QrtzSimpropTriggers> list = new ArrayList<>();
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

    public List<QrtzSimpropTriggers> findByTriggerName(Connection conn, String triggerName) throws SQLException {
        List<QrtzSimpropTriggers> list = new ArrayList<>();
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

    public List<QrtzSimpropTriggers> findByTriggerGroup(Connection conn, String triggerGroup) throws SQLException {
        List<QrtzSimpropTriggers> list = new ArrayList<>();
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

    private void setQrtzSimpropTriggersParams(PreparedStatement ps, QrtzSimpropTriggers qrtzsimproptriggers) throws SQLException {
        if (qrtzsimproptriggers.getSchedName() != null) {
            ps.setString(1, qrtzsimproptriggers.getSchedName().getQrtzTriggersID());
        } else {
            ps.setNull(1, Types.VARCHAR);
        }
        if (qrtzsimproptriggers.getTriggerName() != null) {
            ps.setString(2, qrtzsimproptriggers.getTriggerName().getQrtzTriggersID());
        } else {
            ps.setNull(2, Types.VARCHAR);
        }
        if (qrtzsimproptriggers.getTriggerGroup() != null) {
            ps.setString(3, qrtzsimproptriggers.getTriggerGroup().getQrtzTriggersID());
        } else {
            ps.setNull(3, Types.VARCHAR);
        }
        ps.setString(4, qrtzsimproptriggers.getStrProp1());
        ps.setString(5, qrtzsimproptriggers.getStrProp2());
        ps.setString(6, qrtzsimproptriggers.getStrProp3());
        java.math.BigDecimal val7 = qrtzsimproptriggers.getIntProp1();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = qrtzsimproptriggers.getIntProp2();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = qrtzsimproptriggers.getLongProp1();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        java.math.BigDecimal val10 = qrtzsimproptriggers.getLongProp2();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.math.BigDecimal val11 = qrtzsimproptriggers.getDecProp1();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = qrtzsimproptriggers.getDecProp2();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, qrtzsimproptriggers.getBoolProp1());
        ps.setString(14, qrtzsimproptriggers.getBoolProp2());
        Integer val15 = qrtzsimproptriggers.getTimeZoneID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
    }

    private QrtzSimpropTriggers extract(ResultSet rs) throws SQLException {
        QrtzSimpropTriggers qrtzsimproptriggers = new QrtzSimpropTriggers();
        String SCHED_NAME = rs.getObject(COL_SCHED_NAME, String.class);
        qrtzsimproptriggers.setSchedName(SCHED_NAME);
        if (SCHED_NAME != null) {
            QrtzTriggers schedName = new QrtzTriggers();
            schedName.setQrtzTriggersID(SCHED_NAME);
            qrtzsimproptriggers.setSchedName(schedName);
        }
        String TRIGGER_NAME = rs.getObject(COL_TRIGGER_NAME, String.class);
        qrtzsimproptriggers.setTriggerName(TRIGGER_NAME);
        if (TRIGGER_NAME != null) {
            QrtzTriggers triggerName = new QrtzTriggers();
            triggerName.setQrtzTriggersID(TRIGGER_NAME);
            qrtzsimproptriggers.setTriggerName(triggerName);
        }
        String TRIGGER_GROUP = rs.getObject(COL_TRIGGER_GROUP, String.class);
        qrtzsimproptriggers.setTriggerGroup(TRIGGER_GROUP);
        if (TRIGGER_GROUP != null) {
            QrtzTriggers triggerGroup = new QrtzTriggers();
            triggerGroup.setQrtzTriggersID(TRIGGER_GROUP);
            qrtzsimproptriggers.setTriggerGroup(triggerGroup);
        }
        qrtzsimproptriggers.setStrProp1(rs.getString(COL_STR_PROP_1));
        qrtzsimproptriggers.setStrProp2(rs.getString(COL_STR_PROP_2));
        qrtzsimproptriggers.setStrProp3(rs.getString(COL_STR_PROP_3));
        java.math.BigDecimal INT_PROP_1 = rs.getObject(COL_INT_PROP_1, java.math.BigDecimal.class);
        qrtzsimproptriggers.setIntProp1(INT_PROP_1);
        java.math.BigDecimal INT_PROP_2 = rs.getObject(COL_INT_PROP_2, java.math.BigDecimal.class);
        qrtzsimproptriggers.setIntProp2(INT_PROP_2);
        java.math.BigDecimal LONG_PROP_1 = rs.getObject(COL_LONG_PROP_1, java.math.BigDecimal.class);
        qrtzsimproptriggers.setLongProp1(LONG_PROP_1);
        java.math.BigDecimal LONG_PROP_2 = rs.getObject(COL_LONG_PROP_2, java.math.BigDecimal.class);
        qrtzsimproptriggers.setLongProp2(LONG_PROP_2);
        java.math.BigDecimal DEC_PROP_1 = rs.getObject(COL_DEC_PROP_1, java.math.BigDecimal.class);
        qrtzsimproptriggers.setDecProp1(DEC_PROP_1);
        java.math.BigDecimal DEC_PROP_2 = rs.getObject(COL_DEC_PROP_2, java.math.BigDecimal.class);
        qrtzsimproptriggers.setDecProp2(DEC_PROP_2);
        qrtzsimproptriggers.setBoolProp1(rs.getString(COL_BOOL_PROP_1));
        qrtzsimproptriggers.setBoolProp2(rs.getString(COL_BOOL_PROP_2));
        Integer TIME_ZONE_ID = rs.getObject(COL_TIME_ZONE_ID, Integer.class);
        qrtzsimproptriggers.setTimeZoneID(TIME_ZONE_ID);
        return qrtzsimproptriggers;
    }
}
