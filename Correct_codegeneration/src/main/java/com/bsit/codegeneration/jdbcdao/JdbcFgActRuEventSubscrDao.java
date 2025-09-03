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

public class JdbcFgActRuEventSubscrDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuEventSubscrDao.class);

    private static final String TABLE = "FG_ACT_RU_EVENT_SUBSCR";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_EVENT_TYPE_ = "EVENT_TYPE_";

    private static final String COL_EVENT_NAME_ = "EVENT_NAME_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_ACTIVITY_ID_ = "ACTIVITY_ID_";

    private static final String COL_CONFIGURATION_ = "CONFIGURATION_";

    private static final String COL_CREATED_ = "CREATED_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_EVENT_TYPE_, COL_EVENT_NAME_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_ACTIVITY_ID_, COL_CONFIGURATION_, COL_CREATED_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, EVENT_TYPE_, EVENT_NAME_, EXECUTION_ID_, PROC_INST_ID_, ACTIVITY_ID_, CONFIGURATION_, CREATED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, EVENT_TYPE_, EVENT_NAME_, EXECUTION_ID_, PROC_INST_ID_, ACTIVITY_ID_, CONFIGURATION_, CREATED_, TENANT_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_EVENT_TYPE_, COL_EVENT_NAME_, COL_EXECUTION_ID_, COL_PROC_INST_ID_, COL_ACTIVITY_ID_, COL_CONFIGURATION_, COL_CREATED_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuEventSubscr fgactrueventsubscr) throws SQLException {
        logger.debug("Inserting fgactrueventsubscr: {}", fgactrueventsubscr);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuEventSubscrParams(ps, fgactrueventsubscr);
            ps.executeUpdate();
            return fgactrueventsubscr.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuEventSubscr> fgactrueventsubscrs) throws SQLException {
        if (fgactrueventsubscrs == null || fgactrueventsubscrs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrueventsubscrs.size(); i++) {
            if (fgactrueventsubscrs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuEventSubscr>> batches = chunkList(fgactrueventsubscrs, batchSize);
        int[] totalResults = new int[fgactrueventsubscrs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuEventSubscr> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuEventSubscr fgactrueventsubscr : batch) {
                        setFgActRuEventSubscrParams(ps, fgactrueventsubscr);
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

    public FgActRuEventSubscr findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuEventSubscr> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuEventSubscr> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuEventSubscr fgactrueventsubscr) throws SQLException {
        if (fgactrueventsubscr.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuEventSubscrParams(ps, fgactrueventsubscr);
            ps.setString(10, fgactrueventsubscr.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuEventSubscr> fgactrueventsubscrs) throws SQLException {
        if (fgactrueventsubscrs == null || fgactrueventsubscrs.isEmpty())
            return new int[0];
        for (FgActRuEventSubscr fgactrueventsubscr : fgactrueventsubscrs) {
            if (fgactrueventsubscr == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrueventsubscr.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuEventSubscr>> batches = chunkList(fgactrueventsubscrs, batchSize);
        int[] totalResults = new int[fgactrueventsubscrs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuEventSubscr> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuEventSubscr fgactrueventsubscr : batch) {
                        setFgActRuEventSubscrParams(ps, fgactrueventsubscr);
                        ps.setString(10, fgactrueventsubscr.getID_());
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

    private void setFgActRuEventSubscrParams(PreparedStatement ps, FgActRuEventSubscr fgactrueventsubscr) throws SQLException {
        ps.setString(1, fgactrueventsubscr.getID_());
        java.math.BigDecimal val2 = fgactrueventsubscr.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrueventsubscr.getEventType_());
        ps.setString(4, fgactrueventsubscr.getEventName_());
        ps.setString(5, fgactrueventsubscr.getExecutionID_());
        ps.setString(6, fgactrueventsubscr.getProcInstID_());
        ps.setString(7, fgactrueventsubscr.getActivityID_());
        ps.setString(8, fgactrueventsubscr.getConfiguration_());
        ps.setString(9, fgactrueventsubscr.getCreated_());
        ps.setString(10, fgactrueventsubscr.getTenantID_());
    }

    private FgActRuEventSubscr extract(ResultSet rs) throws SQLException {
        FgActRuEventSubscr fgactrueventsubscr = new FgActRuEventSubscr();
        fgactrueventsubscr.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrueventsubscr.setRev_(REV_);
        fgactrueventsubscr.setEventType_(rs.getString(COL_EVENT_TYPE_));
        fgactrueventsubscr.setEventName_(rs.getString(COL_EVENT_NAME_));
        fgactrueventsubscr.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactrueventsubscr.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgactrueventsubscr.setActivityID_(rs.getString(COL_ACTIVITY_ID_));
        fgactrueventsubscr.setConfiguration_(rs.getString(COL_CONFIGURATION_));
        fgactrueventsubscr.setCreated_(rs.getString(COL_CREATED_));
        fgactrueventsubscr.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgactrueventsubscr;
    }
}
