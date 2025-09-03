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

public class JdbcFgActRuMeterLogDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuMeterLogDao.class);

    private static final String TABLE = "FG_ACT_RU_METER_LOG";

    private static final String COL_ID_ = "ID_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_REPORTER_ = "REPORTER_";

    private static final String COL_VALUE_ = "VALUE_";

    private static final String COL_TIMESTAMP_ = "TIMESTAMP_";

    private static final String COL_MILLISECONDS_ = "MILLISECONDS_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_NAME_, COL_REPORTER_, COL_VALUE_, COL_TIMESTAMP_, COL_MILLISECONDS_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, NAME_, REPORTER_, VALUE_, TIMESTAMP_, MILLISECONDS_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, NAME_, REPORTER_, VALUE_, TIMESTAMP_, MILLISECONDS_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME_, COL_REPORTER_, COL_VALUE_, COL_TIMESTAMP_, COL_MILLISECONDS_, COL_ID_);

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

    public String insert(Connection conn, FgActRuMeterLog fgactrumeterlog) throws SQLException {
        logger.debug("Inserting fgactrumeterlog: {}", fgactrumeterlog);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuMeterLogParams(ps, fgactrumeterlog);
            ps.executeUpdate();
            return fgactrumeterlog.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuMeterLog> fgactrumeterlogs) throws SQLException {
        if (fgactrumeterlogs == null || fgactrumeterlogs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrumeterlogs.size(); i++) {
            if (fgactrumeterlogs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuMeterLog>> batches = chunkList(fgactrumeterlogs, batchSize);
        int[] totalResults = new int[fgactrumeterlogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuMeterLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuMeterLog fgactrumeterlog : batch) {
                        setFgActRuMeterLogParams(ps, fgactrumeterlog);
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

    public FgActRuMeterLog findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuMeterLog> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuMeterLog> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuMeterLog fgactrumeterlog) throws SQLException {
        if (fgactrumeterlog.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuMeterLogParams(ps, fgactrumeterlog);
            ps.setString(6, fgactrumeterlog.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuMeterLog> fgactrumeterlogs) throws SQLException {
        if (fgactrumeterlogs == null || fgactrumeterlogs.isEmpty())
            return new int[0];
        for (FgActRuMeterLog fgactrumeterlog : fgactrumeterlogs) {
            if (fgactrumeterlog == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrumeterlog.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuMeterLog>> batches = chunkList(fgactrumeterlogs, batchSize);
        int[] totalResults = new int[fgactrumeterlogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuMeterLog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuMeterLog fgactrumeterlog : batch) {
                        setFgActRuMeterLogParams(ps, fgactrumeterlog);
                        ps.setString(6, fgactrumeterlog.getID_());
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

    private void setFgActRuMeterLogParams(PreparedStatement ps, FgActRuMeterLog fgactrumeterlog) throws SQLException {
        ps.setString(1, fgactrumeterlog.getID_());
        ps.setString(2, fgactrumeterlog.getName_());
        ps.setString(3, fgactrumeterlog.getReporter_());
        java.math.BigDecimal val4 = fgactrumeterlog.getValue_();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        ps.setString(5, fgactrumeterlog.getTimestamp_());
        java.math.BigDecimal val6 = fgactrumeterlog.getMilliseconds_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
    }

    private FgActRuMeterLog extract(ResultSet rs) throws SQLException {
        FgActRuMeterLog fgactrumeterlog = new FgActRuMeterLog();
        fgactrumeterlog.setID_(rs.getString(COL_ID_));
        fgactrumeterlog.setName_(rs.getString(COL_NAME_));
        fgactrumeterlog.setReporter_(rs.getString(COL_REPORTER_));
        java.math.BigDecimal VALUE_ = rs.getObject(COL_VALUE_, java.math.BigDecimal.class);
        fgactrumeterlog.setValue_(VALUE_);
        fgactrumeterlog.setTimestamp_(rs.getString(COL_TIMESTAMP_));
        java.math.BigDecimal MILLISECONDS_ = rs.getObject(COL_MILLISECONDS_, java.math.BigDecimal.class);
        fgactrumeterlog.setMilliseconds_(MILLISECONDS_);
        return fgactrumeterlog;
    }
}
