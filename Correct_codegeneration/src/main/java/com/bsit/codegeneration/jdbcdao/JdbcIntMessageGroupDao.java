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

public class JdbcIntMessageGroupDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcIntMessageGroupDao.class);

    private static final String TABLE = "INT_MESSAGE_GROUP";

    private static final String COL_GROUP_KEY = "GROUP_KEY";

    private static final String COL_REGION = "REGION";

    private static final String COL_MARKED = "MARKED";

    private static final String COL_COMPLETE = "COMPLETE";

    private static final String COL_LAST_RELEASED_SEQUENCE = "LAST_RELEASED_SEQUENCE";

    private static final String COL_CREATED_DATE = "CREATED_DATE";

    private static final String COL_UPDATED_DATE = "UPDATED_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_GROUP_KEY, COL_REGION, COL_MARKED, COL_COMPLETE, COL_LAST_RELEASED_SEQUENCE, COL_CREATED_DATE, COL_UPDATED_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("GROUP_KEY, REGION, MARKED, COMPLETE, LAST_RELEASED_SEQUENCE, CREATED_DATE, UPDATED_DATE", TABLE, COL_GROUP_KEY);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("GROUP_KEY, REGION, MARKED, COMPLETE, LAST_RELEASED_SEQUENCE, CREATED_DATE, UPDATED_DATE", TABLE, COL_GROUP_KEY);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REGION, COL_MARKED, COL_COMPLETE, COL_LAST_RELEASED_SEQUENCE, COL_CREATED_DATE, COL_UPDATED_DATE, COL_GROUP_KEY);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_GROUP_KEY);

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

    public String insert(Connection conn, IntMessageGroup intmessagegroup) throws SQLException {
        logger.debug("Inserting intmessagegroup: {}", intmessagegroup);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setIntMessageGroupParams(ps, intmessagegroup);
            ps.executeUpdate();
            return intmessagegroup.getGroupKey();
        }
    }

    public int[] insertAll(Connection conn, List<IntMessageGroup> intmessagegroups) throws SQLException {
        if (intmessagegroups == null || intmessagegroups.isEmpty())
            return new int[0];
        for (int i = 0; i < intmessagegroups.size(); i++) {
            if (intmessagegroups.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IntMessageGroup>> batches = chunkList(intmessagegroups, batchSize);
        int[] totalResults = new int[intmessagegroups.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IntMessageGroup> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (IntMessageGroup intmessagegroup : batch) {
                        setIntMessageGroupParams(ps, intmessagegroup);
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

    public IntMessageGroup findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<IntMessageGroup> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<IntMessageGroup> list = new ArrayList<>();
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

    public boolean update(Connection conn, IntMessageGroup intmessagegroup) throws SQLException {
        if (intmessagegroup.getGroupKey() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setIntMessageGroupParams(ps, intmessagegroup);
            ps.setString(7, intmessagegroup.getGroupKey());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<IntMessageGroup> intmessagegroups) throws SQLException {
        if (intmessagegroups == null || intmessagegroups.isEmpty())
            return new int[0];
        for (IntMessageGroup intmessagegroup : intmessagegroups) {
            if (intmessagegroup == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (intmessagegroup.getGroupKey() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IntMessageGroup>> batches = chunkList(intmessagegroups, batchSize);
        int[] totalResults = new int[intmessagegroups.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IntMessageGroup> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (IntMessageGroup intmessagegroup : batch) {
                        setIntMessageGroupParams(ps, intmessagegroup);
                        ps.setString(7, intmessagegroup.getGroupKey());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_GROUP_KEY, placeholders);
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

    private void setIntMessageGroupParams(PreparedStatement ps, IntMessageGroup intmessagegroup) throws SQLException {
        ps.setString(1, intmessagegroup.getGroupKey());
        ps.setString(2, intmessagegroup.getRegion());
        java.math.BigDecimal val3 = intmessagegroup.getMarked();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = intmessagegroup.getComplete();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = intmessagegroup.getLastReleasedSequence();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, intmessagegroup.getCreatedDate());
        ps.setString(7, intmessagegroup.getUpdatedDate());
    }

    private IntMessageGroup extract(ResultSet rs) throws SQLException {
        IntMessageGroup intmessagegroup = new IntMessageGroup();
        intmessagegroup.setGroupKey(rs.getString(COL_GROUP_KEY));
        intmessagegroup.setRegion(rs.getString(COL_REGION));
        java.math.BigDecimal MARKED = rs.getObject(COL_MARKED, java.math.BigDecimal.class);
        intmessagegroup.setMarked(MARKED);
        java.math.BigDecimal COMPLETE = rs.getObject(COL_COMPLETE, java.math.BigDecimal.class);
        intmessagegroup.setComplete(COMPLETE);
        java.math.BigDecimal LAST_RELEASED_SEQUENCE = rs.getObject(COL_LAST_RELEASED_SEQUENCE, java.math.BigDecimal.class);
        intmessagegroup.setLastReleasedSequence(LAST_RELEASED_SEQUENCE);
        intmessagegroup.setCreatedDate(rs.getString(COL_CREATED_DATE));
        intmessagegroup.setUpdatedDate(rs.getString(COL_UPDATED_DATE));
        return intmessagegroup;
    }
}
