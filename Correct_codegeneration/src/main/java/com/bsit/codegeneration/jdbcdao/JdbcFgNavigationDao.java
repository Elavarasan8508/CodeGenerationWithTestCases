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

public class JdbcFgNavigationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgNavigationDao.class);

    private static final String TABLE = "FG_NAVIGATION";

    private static final String COL_ID = "ID";

    private static final String COL_APPLIED_DATE = "APPLIED_DATE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_NAVIGATION_CONTENT = "NAVIGATION_CONTENT";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_APPLIED_DATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_NAVIGATION_CONTENT, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, APPLIED_DATE, TYPE_CODE, SUB_TYPE_CODE, NAVIGATION_CONTENT, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, APPLIED_DATE, TYPE_CODE, SUB_TYPE_CODE, NAVIGATION_CONTENT, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_APPLIED_DATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_NAVIGATION_CONTENT, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID);

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

    public int insert(Connection conn, FgNavigation fgnavigation) throws SQLException {
        logger.debug("Inserting fgnavigation: {}", fgnavigation);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgNavigationParams(ps, fgnavigation);
            ps.executeUpdate();
            return fgnavigation.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgNavigation> fgnavigations) throws SQLException {
        if (fgnavigations == null || fgnavigations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgnavigations.size(); i++) {
            if (fgnavigations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgNavigation>> batches = chunkList(fgnavigations, batchSize);
        int[] totalResults = new int[fgnavigations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgNavigation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgNavigation fgnavigation : batch) {
                        setFgNavigationParams(ps, fgnavigation);
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

    public FgNavigation findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgNavigation> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgNavigation> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgNavigation fgnavigation) throws SQLException {
        if (fgnavigation.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgNavigationParams(ps, fgnavigation);
            ps.setInt(11, fgnavigation.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgNavigation> fgnavigations) throws SQLException {
        if (fgnavigations == null || fgnavigations.isEmpty())
            return new int[0];
        for (FgNavigation fgnavigation : fgnavigations) {
            if (fgnavigation == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgnavigation.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgNavigation>> batches = chunkList(fgnavigations, batchSize);
        int[] totalResults = new int[fgnavigations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgNavigation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgNavigation fgnavigation : batch) {
                        setFgNavigationParams(ps, fgnavigation);
                        ps.setInt(11, fgnavigation.getID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID, placeholders);
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

    private void setFgNavigationParams(PreparedStatement ps, FgNavigation fgnavigation) throws SQLException {
        Integer val1 = fgnavigation.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgnavigation.getAppliedDate());
        ps.setString(3, fgnavigation.getTypeCode());
        ps.setString(4, fgnavigation.getSubTypeCode());
        ps.setString(5, fgnavigation.getNavigationContent());
        java.math.BigDecimal val6 = fgnavigation.getCreatedBy();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgnavigation.getCreatedOn());
        java.math.BigDecimal val8 = fgnavigation.getLastAuthorisedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgnavigation.getLastAuthorisedOn());
        java.math.BigDecimal val10 = fgnavigation.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgnavigation.getLastUpdatedOn());
    }

    private FgNavigation extract(ResultSet rs) throws SQLException {
        FgNavigation fgnavigation = new FgNavigation();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgnavigation.setID(ID);
        fgnavigation.setAppliedDate(rs.getString(COL_APPLIED_DATE));
        fgnavigation.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgnavigation.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgnavigation.setNavigationContent(rs.getString(COL_NAVIGATION_CONTENT));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgnavigation.setCreatedBy(CREATED_BY);
        fgnavigation.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgnavigation.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgnavigation.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgnavigation.setLastUpdatedBy(LAST_UPDATED_BY);
        fgnavigation.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        return fgnavigation;
    }
}
