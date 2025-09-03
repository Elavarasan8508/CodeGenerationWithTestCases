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

public class JdbcFgLayoutTemplateColumnsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLayoutTemplateColumnsDao.class);

    private static final String TABLE = "FG_LAYOUT_TEMPLATE_COLUMNS";

    private static final String COL_ID = "ID";

    private static final String COL_NAME = "NAME";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE_COLUMNS = "TEMPLATE_COLUMNS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_NAME, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE_COLUMNS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NAME, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_COLUMNS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, NAME, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_COLUMNS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE_COLUMNS, COL_ID);

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

    public int insert(Connection conn, FgLayoutTemplateColumns fglayouttemplatecolumns) throws SQLException {
        logger.debug("Inserting fglayouttemplatecolumns: {}", fglayouttemplatecolumns);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLayoutTemplateColumnsParams(ps, fglayouttemplatecolumns);
            ps.executeUpdate();
            return fglayouttemplatecolumns.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLayoutTemplateColumns> fglayouttemplatecolumnss) throws SQLException {
        if (fglayouttemplatecolumnss == null || fglayouttemplatecolumnss.isEmpty())
            return new int[0];
        for (int i = 0; i < fglayouttemplatecolumnss.size(); i++) {
            if (fglayouttemplatecolumnss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplateColumns>> batches = chunkList(fglayouttemplatecolumnss, batchSize);
        int[] totalResults = new int[fglayouttemplatecolumnss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplateColumns> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLayoutTemplateColumns fglayouttemplatecolumns : batch) {
                        setFgLayoutTemplateColumnsParams(ps, fglayouttemplatecolumns);
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

    public FgLayoutTemplateColumns findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLayoutTemplateColumns> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLayoutTemplateColumns> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLayoutTemplateColumns fglayouttemplatecolumns) throws SQLException {
        if (fglayouttemplatecolumns.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLayoutTemplateColumnsParams(ps, fglayouttemplatecolumns);
            ps.setInt(14, fglayouttemplatecolumns.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLayoutTemplateColumns> fglayouttemplatecolumnss) throws SQLException {
        if (fglayouttemplatecolumnss == null || fglayouttemplatecolumnss.isEmpty())
            return new int[0];
        for (FgLayoutTemplateColumns fglayouttemplatecolumns : fglayouttemplatecolumnss) {
            if (fglayouttemplatecolumns == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglayouttemplatecolumns.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplateColumns>> batches = chunkList(fglayouttemplatecolumnss, batchSize);
        int[] totalResults = new int[fglayouttemplatecolumnss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplateColumns> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLayoutTemplateColumns fglayouttemplatecolumns : batch) {
                        setFgLayoutTemplateColumnsParams(ps, fglayouttemplatecolumns);
                        ps.setInt(14, fglayouttemplatecolumns.getID());
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

    private void setFgLayoutTemplateColumnsParams(PreparedStatement ps, FgLayoutTemplateColumns fglayouttemplatecolumns) throws SQLException {
        Integer val1 = fglayouttemplatecolumns.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fglayouttemplatecolumns.getName());
        ps.setString(3, fglayouttemplatecolumns.getTypeCode());
        ps.setString(4, fglayouttemplatecolumns.getSubTypeCode());
        ps.setString(5, fglayouttemplatecolumns.getDescription());
        ps.setString(6, fglayouttemplatecolumns.getActiveCode());
        ps.setString(7, fglayouttemplatecolumns.getStatusCode());
        ps.setString(8, fglayouttemplatecolumns.getCreatedOn());
        java.math.BigDecimal val9 = fglayouttemplatecolumns.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fglayouttemplatecolumns.getLastUpdatedOn());
        java.math.BigDecimal val11 = fglayouttemplatecolumns.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fglayouttemplatecolumns.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fglayouttemplatecolumns.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fglayouttemplatecolumns.getTemplateColumns());
    }

    private FgLayoutTemplateColumns extract(ResultSet rs) throws SQLException {
        FgLayoutTemplateColumns fglayouttemplatecolumns = new FgLayoutTemplateColumns();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglayouttemplatecolumns.setID(ID);
        fglayouttemplatecolumns.setName(rs.getString(COL_NAME));
        fglayouttemplatecolumns.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglayouttemplatecolumns.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglayouttemplatecolumns.setDescription(rs.getString(COL_DESCRIPTION));
        fglayouttemplatecolumns.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglayouttemplatecolumns.setStatusCode(rs.getString(COL_STATUS_CODE));
        fglayouttemplatecolumns.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglayouttemplatecolumns.setCreatedBy(CREATED_BY);
        fglayouttemplatecolumns.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglayouttemplatecolumns.setLastUpdatedBy(LAST_UPDATED_BY);
        fglayouttemplatecolumns.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglayouttemplatecolumns.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fglayouttemplatecolumns.setTemplateColumns(rs.getString(COL_TEMPLATE_COLUMNS));
        return fglayouttemplatecolumns;
    }
}
