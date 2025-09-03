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

public class JdbcFgConfigSchemaDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgConfigSchemaDao.class);

    private static final String TABLE = "FG_CONFIG_SCHEMA";

    private static final String COL_ID = "ID";

    private static final String COL_CONFIG_CODE = "CONFIG_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_PARENT_CODE = "PARENT_CODE";

    private static final String COL_FIELD_DATA = "FIELD_DATA";

    private static final String COL_FORM_DATA = "FORM_DATA";

    private static final String COL_AUTH_FORM_DATA = "AUTH_FORM_DATA";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_CONFIG_CODE, COL_NAME, COL_PARENT_CODE, COL_FIELD_DATA, COL_FORM_DATA, COL_AUTH_FORM_DATA, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_CATEGORY_CODE, COL_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, CONFIG_CODE, NAME, PARENT_CODE, FIELD_DATA, FORM_DATA, AUTH_FORM_DATA, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CATEGORY_CODE, TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, CONFIG_CODE, NAME, PARENT_CODE, FIELD_DATA, FORM_DATA, AUTH_FORM_DATA, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CATEGORY_CODE, TYPE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CONFIG_CODE, COL_NAME, COL_PARENT_CODE, COL_FIELD_DATA, COL_FORM_DATA, COL_AUTH_FORM_DATA, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_CATEGORY_CODE, COL_TYPE_CODE, COL_ID);

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

    public int insert(Connection conn, FgConfigSchema fgconfigschema) throws SQLException {
        logger.debug("Inserting fgconfigschema: {}", fgconfigschema);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgConfigSchemaParams(ps, fgconfigschema);
            ps.executeUpdate();
            return fgconfigschema.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgConfigSchema> fgconfigschemas) throws SQLException {
        if (fgconfigschemas == null || fgconfigschemas.isEmpty())
            return new int[0];
        for (int i = 0; i < fgconfigschemas.size(); i++) {
            if (fgconfigschemas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgConfigSchema>> batches = chunkList(fgconfigschemas, batchSize);
        int[] totalResults = new int[fgconfigschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgConfigSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgConfigSchema fgconfigschema : batch) {
                        setFgConfigSchemaParams(ps, fgconfigschema);
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

    public FgConfigSchema findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgConfigSchema> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgConfigSchema> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgConfigSchema fgconfigschema) throws SQLException {
        if (fgconfigschema.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgConfigSchemaParams(ps, fgconfigschema);
            ps.setInt(18, fgconfigschema.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgConfigSchema> fgconfigschemas) throws SQLException {
        if (fgconfigschemas == null || fgconfigschemas.isEmpty())
            return new int[0];
        for (FgConfigSchema fgconfigschema : fgconfigschemas) {
            if (fgconfigschema == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgconfigschema.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgConfigSchema>> batches = chunkList(fgconfigschemas, batchSize);
        int[] totalResults = new int[fgconfigschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgConfigSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgConfigSchema fgconfigschema : batch) {
                        setFgConfigSchemaParams(ps, fgconfigschema);
                        ps.setInt(18, fgconfigschema.getID());
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

    private void setFgConfigSchemaParams(PreparedStatement ps, FgConfigSchema fgconfigschema) throws SQLException {
        Integer val1 = fgconfigschema.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgconfigschema.getConfigCode());
        ps.setString(3, fgconfigschema.getName());
        ps.setString(4, fgconfigschema.getParentCode());
        ps.setString(5, fgconfigschema.getFieldData());
        ps.setString(6, fgconfigschema.getFormData());
        ps.setString(7, fgconfigschema.getAuthFormData());
        ps.setString(8, fgconfigschema.getDescription());
        ps.setString(9, fgconfigschema.getActiveCode());
        ps.setString(10, fgconfigschema.getStatusCode());
        ps.setString(11, fgconfigschema.getCreatedOn());
        java.math.BigDecimal val12 = fgconfigschema.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgconfigschema.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgconfigschema.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgconfigschema.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgconfigschema.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgconfigschema.getCategoryCode());
        ps.setString(18, fgconfigschema.getTypeCode());
    }

    private FgConfigSchema extract(ResultSet rs) throws SQLException {
        FgConfigSchema fgconfigschema = new FgConfigSchema();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgconfigschema.setID(ID);
        fgconfigschema.setConfigCode(rs.getString(COL_CONFIG_CODE));
        fgconfigschema.setName(rs.getString(COL_NAME));
        fgconfigschema.setParentCode(rs.getString(COL_PARENT_CODE));
        fgconfigschema.setFieldData(rs.getString(COL_FIELD_DATA));
        fgconfigschema.setFormData(rs.getString(COL_FORM_DATA));
        fgconfigschema.setAuthFormData(rs.getString(COL_AUTH_FORM_DATA));
        fgconfigschema.setDescription(rs.getString(COL_DESCRIPTION));
        fgconfigschema.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgconfigschema.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgconfigschema.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgconfigschema.setCreatedBy(CREATED_BY);
        fgconfigschema.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgconfigschema.setLastUpdatedBy(LAST_UPDATED_BY);
        fgconfigschema.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgconfigschema.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgconfigschema.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgconfigschema.setTypeCode(rs.getString(COL_TYPE_CODE));
        return fgconfigschema;
    }
}
