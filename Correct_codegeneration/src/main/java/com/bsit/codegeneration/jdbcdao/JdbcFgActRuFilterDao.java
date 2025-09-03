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

public class JdbcFgActRuFilterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuFilterDao.class);

    private static final String TABLE = "FG_ACT_RU_FILTER";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_RESOURCE_TYPE_ = "RESOURCE_TYPE_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_OWNER_ = "OWNER_";

    private static final String COL_QUERY_ = "QUERY_";

    private static final String COL_PROPERTIES_ = "PROPERTIES_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_RESOURCE_TYPE_, COL_NAME_, COL_OWNER_, COL_QUERY_, COL_PROPERTIES_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, RESOURCE_TYPE_, NAME_, OWNER_, QUERY_, PROPERTIES_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, RESOURCE_TYPE_, NAME_, OWNER_, QUERY_, PROPERTIES_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_RESOURCE_TYPE_, COL_NAME_, COL_OWNER_, COL_QUERY_, COL_PROPERTIES_, COL_ID_);

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

    public String insert(Connection conn, FgActRuFilter fgactrufilter) throws SQLException {
        logger.debug("Inserting fgactrufilter: {}", fgactrufilter);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuFilterParams(ps, fgactrufilter);
            ps.executeUpdate();
            return fgactrufilter.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuFilter> fgactrufilters) throws SQLException {
        if (fgactrufilters == null || fgactrufilters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrufilters.size(); i++) {
            if (fgactrufilters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuFilter>> batches = chunkList(fgactrufilters, batchSize);
        int[] totalResults = new int[fgactrufilters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuFilter> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuFilter fgactrufilter : batch) {
                        setFgActRuFilterParams(ps, fgactrufilter);
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

    public FgActRuFilter findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuFilter> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuFilter> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuFilter fgactrufilter) throws SQLException {
        if (fgactrufilter.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuFilterParams(ps, fgactrufilter);
            ps.setString(7, fgactrufilter.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuFilter> fgactrufilters) throws SQLException {
        if (fgactrufilters == null || fgactrufilters.isEmpty())
            return new int[0];
        for (FgActRuFilter fgactrufilter : fgactrufilters) {
            if (fgactrufilter == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrufilter.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuFilter>> batches = chunkList(fgactrufilters, batchSize);
        int[] totalResults = new int[fgactrufilters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuFilter> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuFilter fgactrufilter : batch) {
                        setFgActRuFilterParams(ps, fgactrufilter);
                        ps.setString(7, fgactrufilter.getID_());
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

    private void setFgActRuFilterParams(PreparedStatement ps, FgActRuFilter fgactrufilter) throws SQLException {
        ps.setString(1, fgactrufilter.getID_());
        java.math.BigDecimal val2 = fgactrufilter.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrufilter.getResourceType_());
        ps.setString(4, fgactrufilter.getName_());
        ps.setString(5, fgactrufilter.getOwner_());
        ps.setString(6, fgactrufilter.getQuery_());
        ps.setString(7, fgactrufilter.getProperties_());
    }

    private FgActRuFilter extract(ResultSet rs) throws SQLException {
        FgActRuFilter fgactrufilter = new FgActRuFilter();
        fgactrufilter.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrufilter.setRev_(REV_);
        fgactrufilter.setResourceType_(rs.getString(COL_RESOURCE_TYPE_));
        fgactrufilter.setName_(rs.getString(COL_NAME_));
        fgactrufilter.setOwner_(rs.getString(COL_OWNER_));
        fgactrufilter.setQuery_(rs.getString(COL_QUERY_));
        fgactrufilter.setProperties_(rs.getString(COL_PROPERTIES_));
        return fgactrufilter;
    }
}
