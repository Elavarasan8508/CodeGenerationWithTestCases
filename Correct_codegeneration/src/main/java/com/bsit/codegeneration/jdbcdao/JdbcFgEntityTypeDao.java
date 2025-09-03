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

public class JdbcFgEntityTypeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEntityTypeDao.class);

    private static final String TABLE = "FG_ENTITY_TYPE";

    private static final String COL_ID = "ID";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_CODE = "CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_PARENT_TYPE_CODE = "PARENT_TYPE_CODE";

    private static final String COL_IS_MASTER = "IS_MASTER";

    private static final String COL_IS_PRODUCT = "IS_PRODUCT";

    private static final String COL_ENTITY_CLASS_CODE = "ENTITY_CLASS_CODE";

    private static final String COL_CONFIG_STATUS_CODE = "CONFIG_STATUS_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE_SCHEMA = "TEMPLATE_SCHEMA";

    private static final String COL_IS_ANALYTICS_ENABLED = "IS_ANALYTICS_ENABLED";

    private static final String COL_IS_REPORT_ENABLED = "IS_REPORT_ENABLED";

    private static final String COL_TAGS = "TAGS";

    private static final String COL_IS_PUBLIC = "IS_PUBLIC";

    private static final String COL_MASTER_TEMPLATE = "MASTER_TEMPLATE";

    private static final String COL_MASTER_CONTENT_HASH = "MASTER_CONTENT_HASH";

    private static final String COL_TEMPLATE_HASH = "TEMPLATE_HASH";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_CATEGORY_CODE, COL_CODE, COL_NAME, COL_PARENT_TYPE_CODE, COL_IS_MASTER, COL_IS_PRODUCT, COL_ENTITY_CLASS_CODE, COL_CONFIG_STATUS_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE_SCHEMA, COL_IS_ANALYTICS_ENABLED, COL_IS_REPORT_ENABLED, COL_TAGS, COL_IS_PUBLIC, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH, COL_VERSION_ID, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, CATEGORY_CODE, CODE, NAME, PARENT_TYPE_CODE, IS_MASTER, IS_PRODUCT, ENTITY_CLASS_CODE, CONFIG_STATUS_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_SCHEMA, IS_ANALYTICS_ENABLED, IS_REPORT_ENABLED, TAGS, IS_PUBLIC, MASTER_TEMPLATE, MASTER_CONTENT_HASH, TEMPLATE_HASH, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, CATEGORY_CODE, CODE, NAME, PARENT_TYPE_CODE, IS_MASTER, IS_PRODUCT, ENTITY_CLASS_CODE, CONFIG_STATUS_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_SCHEMA, IS_ANALYTICS_ENABLED, IS_REPORT_ENABLED, TAGS, IS_PUBLIC, MASTER_TEMPLATE, MASTER_CONTENT_HASH, TEMPLATE_HASH, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_CODE, COL_CODE, COL_NAME, COL_PARENT_TYPE_CODE, COL_IS_MASTER, COL_IS_PRODUCT, COL_ENTITY_CLASS_CODE, COL_CONFIG_STATUS_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE_SCHEMA, COL_IS_ANALYTICS_ENABLED, COL_IS_REPORT_ENABLED, COL_TAGS, COL_IS_PUBLIC, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, FgEntityType fgentitytype) throws SQLException {
        logger.debug("Inserting fgentitytype: {}", fgentitytype);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEntityTypeParams(ps, fgentitytype);
            ps.executeUpdate();
            return fgentitytype.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEntityType> fgentitytypes) throws SQLException {
        if (fgentitytypes == null || fgentitytypes.isEmpty())
            return new int[0];
        for (int i = 0; i < fgentitytypes.size(); i++) {
            if (fgentitytypes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEntityType>> batches = chunkList(fgentitytypes, batchSize);
        int[] totalResults = new int[fgentitytypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEntityType> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEntityType fgentitytype : batch) {
                        setFgEntityTypeParams(ps, fgentitytype);
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

    public FgEntityType findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEntityType> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEntityType> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEntityType fgentitytype) throws SQLException {
        if (fgentitytype.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEntityTypeParams(ps, fgentitytype);
            ps.setInt(28, fgentitytype.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEntityType> fgentitytypes) throws SQLException {
        if (fgentitytypes == null || fgentitytypes.isEmpty())
            return new int[0];
        for (FgEntityType fgentitytype : fgentitytypes) {
            if (fgentitytype == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgentitytype.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEntityType>> batches = chunkList(fgentitytypes, batchSize);
        int[] totalResults = new int[fgentitytypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEntityType> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEntityType fgentitytype : batch) {
                        setFgEntityTypeParams(ps, fgentitytype);
                        ps.setInt(28, fgentitytype.getID());
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

    private void setFgEntityTypeParams(PreparedStatement ps, FgEntityType fgentitytype) throws SQLException {
        Integer val1 = fgentitytype.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgentitytype.getCategoryCode());
        ps.setString(3, fgentitytype.getCode());
        ps.setString(4, fgentitytype.getName());
        ps.setString(5, fgentitytype.getParentTypeCode());
        java.math.BigDecimal val6 = fgentitytype.getIsMaster();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = fgentitytype.getIsProduct();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgentitytype.getEntityClassCode());
        java.math.BigDecimal val9 = fgentitytype.getConfigStatusCode();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgentitytype.getDescription());
        ps.setString(11, fgentitytype.getActiveCode());
        ps.setString(12, fgentitytype.getStatusCode());
        ps.setString(13, fgentitytype.getCreatedOn());
        java.math.BigDecimal val14 = fgentitytype.getCreatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgentitytype.getLastUpdatedOn());
        java.math.BigDecimal val16 = fgentitytype.getLastUpdatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgentitytype.getLastAuthorisedOn());
        java.math.BigDecimal val18 = fgentitytype.getLastAuthorisedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgentitytype.getTemplateSchema());
        java.math.BigDecimal val20 = fgentitytype.getIsAnalyticsEnabled();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgentitytype.getIsReportEnabled();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgentitytype.getTags());
        java.math.BigDecimal val23 = fgentitytype.getIsPublic();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgentitytype.getMasterTemplate());
        ps.setString(25, fgentitytype.getMasterContentHash());
        ps.setString(26, fgentitytype.getTemplateHash());
        Integer val27 = fgentitytype.getVersionID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = fgentitytype.getIsMasterVersion();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
    }

    private FgEntityType extract(ResultSet rs) throws SQLException {
        FgEntityType fgentitytype = new FgEntityType();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgentitytype.setID(ID);
        fgentitytype.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgentitytype.setCode(rs.getString(COL_CODE));
        fgentitytype.setName(rs.getString(COL_NAME));
        fgentitytype.setParentTypeCode(rs.getString(COL_PARENT_TYPE_CODE));
        java.math.BigDecimal IS_MASTER = rs.getObject(COL_IS_MASTER, java.math.BigDecimal.class);
        fgentitytype.setIsMaster(IS_MASTER);
        java.math.BigDecimal IS_PRODUCT = rs.getObject(COL_IS_PRODUCT, java.math.BigDecimal.class);
        fgentitytype.setIsProduct(IS_PRODUCT);
        fgentitytype.setEntityClassCode(rs.getString(COL_ENTITY_CLASS_CODE));
        java.math.BigDecimal CONFIG_STATUS_CODE = rs.getObject(COL_CONFIG_STATUS_CODE, java.math.BigDecimal.class);
        fgentitytype.setConfigStatusCode(CONFIG_STATUS_CODE);
        fgentitytype.setDescription(rs.getString(COL_DESCRIPTION));
        fgentitytype.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgentitytype.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgentitytype.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgentitytype.setCreatedBy(CREATED_BY);
        fgentitytype.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgentitytype.setLastUpdatedBy(LAST_UPDATED_BY);
        fgentitytype.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgentitytype.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgentitytype.setTemplateSchema(rs.getString(COL_TEMPLATE_SCHEMA));
        java.math.BigDecimal IS_ANALYTICS_ENABLED = rs.getObject(COL_IS_ANALYTICS_ENABLED, java.math.BigDecimal.class);
        fgentitytype.setIsAnalyticsEnabled(IS_ANALYTICS_ENABLED);
        java.math.BigDecimal IS_REPORT_ENABLED = rs.getObject(COL_IS_REPORT_ENABLED, java.math.BigDecimal.class);
        fgentitytype.setIsReportEnabled(IS_REPORT_ENABLED);
        fgentitytype.setTags(rs.getString(COL_TAGS));
        java.math.BigDecimal IS_PUBLIC = rs.getObject(COL_IS_PUBLIC, java.math.BigDecimal.class);
        fgentitytype.setIsPublic(IS_PUBLIC);
        fgentitytype.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        fgentitytype.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        fgentitytype.setTemplateHash(rs.getString(COL_TEMPLATE_HASH));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgentitytype.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgentitytype.setIsMasterVersion(IS_MASTER_VERSION);
        return fgentitytype;
    }
}
