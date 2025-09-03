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

public class JdbcFgLayoutTemplateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLayoutTemplateDao.class);

    private static final String TABLE = "FG_LAYOUT_TEMPLATE";

    private static final String COL_ID = "ID";

    private static final String COL_FILE_EXTENSION = "FILE_EXTENSION";

    private static final String COL_FILE_TYPE = "FILE_TYPE";

    private static final String COL_NAME = "NAME";

    private static final String COL_TEMPLATE = "TEMPLATE";

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

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_CATEGORY = "CATEGORY";

    private static final String COL_CONTENT = "CONTENT";

    private static final String COL_UUID = "UUID";

    private static final String COL_CATEGORY_TYPE = "CATEGORY_TYPE";

    private static final String COL_CATEGORY_SUB_TYPE = "CATEGORY_SUB_TYPE";

    private static final String COL_TAGS = "TAGS";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_DEVICE_TYPE = "DEVICE_TYPE";

    private static final String COL_VERSION_NO = "VERSION_NO";

    private static final String COL_MASTER_CONTENT_HASH = "MASTER_CONTENT_HASH";

    private static final String COL_TEMPLATE_HASH = "TEMPLATE_HASH";

    private static final String COL_MASTER_TEMPLATE = "MASTER_TEMPLATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_REFERENCE_ID, COL_CATEGORY, COL_CONTENT, COL_UUID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE, COL_DEVICE_TYPE, COL_VERSION_NO, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH, COL_MASTER_TEMPLATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_REFERENCE_ID, COL_CATEGORY, COL_CONTENT, COL_UUID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE, COL_DEVICE_TYPE, COL_VERSION_NO, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH, COL_MASTER_TEMPLATE, COL_ID);

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

    public int insert(Connection conn, FgLayoutTemplate fglayouttemplate) throws SQLException {
        logger.debug("Inserting fglayouttemplate: {}", fglayouttemplate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLayoutTemplateParams(ps, fglayouttemplate);
            ps.executeUpdate();
            return fglayouttemplate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLayoutTemplate> fglayouttemplates) throws SQLException {
        if (fglayouttemplates == null || fglayouttemplates.isEmpty())
            return new int[0];
        for (int i = 0; i < fglayouttemplates.size(); i++) {
            if (fglayouttemplates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplate>> batches = chunkList(fglayouttemplates, batchSize);
        int[] totalResults = new int[fglayouttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLayoutTemplate fglayouttemplate : batch) {
                        setFgLayoutTemplateParams(ps, fglayouttemplate);
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

    public FgLayoutTemplate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLayoutTemplate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLayoutTemplate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLayoutTemplate fglayouttemplate) throws SQLException {
        if (fglayouttemplate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLayoutTemplateParams(ps, fglayouttemplate);
            ps.setInt(33, fglayouttemplate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLayoutTemplate> fglayouttemplates) throws SQLException {
        if (fglayouttemplates == null || fglayouttemplates.isEmpty())
            return new int[0];
        for (FgLayoutTemplate fglayouttemplate : fglayouttemplates) {
            if (fglayouttemplate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglayouttemplate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplate>> batches = chunkList(fglayouttemplates, batchSize);
        int[] totalResults = new int[fglayouttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLayoutTemplate fglayouttemplate : batch) {
                        setFgLayoutTemplateParams(ps, fglayouttemplate);
                        ps.setInt(33, fglayouttemplate.getID());
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

    private void setFgLayoutTemplateParams(PreparedStatement ps, FgLayoutTemplate fglayouttemplate) throws SQLException {
        Integer val1 = fglayouttemplate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fglayouttemplate.getFileExtension());
        ps.setString(3, fglayouttemplate.getFileType());
        ps.setString(4, fglayouttemplate.getName());
        ps.setString(5, fglayouttemplate.getTemplate());
        ps.setString(6, fglayouttemplate.getTypeCode());
        ps.setString(7, fglayouttemplate.getSubTypeCode());
        ps.setString(8, fglayouttemplate.getDescription());
        ps.setString(9, fglayouttemplate.getActiveCode());
        ps.setString(10, fglayouttemplate.getStatusCode());
        ps.setString(11, fglayouttemplate.getCreatedOn());
        java.math.BigDecimal val12 = fglayouttemplate.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglayouttemplate.getLastUpdatedOn());
        java.math.BigDecimal val14 = fglayouttemplate.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglayouttemplate.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fglayouttemplate.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        Integer val17 = fglayouttemplate.getProcessID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = fglayouttemplate.getReferenceID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fglayouttemplate.getCategory());
        ps.setString(20, fglayouttemplate.getContent());
        ps.setString(21, fglayouttemplate.getUuid());
        ps.setString(22, fglayouttemplate.getCategoryType());
        ps.setString(23, fglayouttemplate.getCategorySubType());
        ps.setString(24, fglayouttemplate.getTags());
        Integer val25 = fglayouttemplate.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = fglayouttemplate.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fglayouttemplate.getStageCode());
        ps.setString(28, fglayouttemplate.getApplicantPartyCode());
        ps.setString(29, fglayouttemplate.getDeviceType());
        java.math.BigDecimal val30 = fglayouttemplate.getVersionNo();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fglayouttemplate.getMasterContentHash());
        ps.setString(32, fglayouttemplate.getTemplateHash());
        ps.setString(33, fglayouttemplate.getMasterTemplate());
    }

    private FgLayoutTemplate extract(ResultSet rs) throws SQLException {
        FgLayoutTemplate fglayouttemplate = new FgLayoutTemplate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglayouttemplate.setID(ID);
        fglayouttemplate.setFileExtension(rs.getString(COL_FILE_EXTENSION));
        fglayouttemplate.setFileType(rs.getString(COL_FILE_TYPE));
        fglayouttemplate.setName(rs.getString(COL_NAME));
        fglayouttemplate.setTemplate(rs.getString(COL_TEMPLATE));
        fglayouttemplate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglayouttemplate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglayouttemplate.setDescription(rs.getString(COL_DESCRIPTION));
        fglayouttemplate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglayouttemplate.setStatusCode(rs.getString(COL_STATUS_CODE));
        fglayouttemplate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglayouttemplate.setCreatedBy(CREATED_BY);
        fglayouttemplate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglayouttemplate.setLastUpdatedBy(LAST_UPDATED_BY);
        fglayouttemplate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglayouttemplate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglayouttemplate.setProcessID(PROCESS_ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglayouttemplate.setReferenceID(REFERENCE_ID);
        fglayouttemplate.setCategory(rs.getString(COL_CATEGORY));
        fglayouttemplate.setContent(rs.getString(COL_CONTENT));
        fglayouttemplate.setUuid(rs.getString(COL_UUID));
        fglayouttemplate.setCategoryType(rs.getString(COL_CATEGORY_TYPE));
        fglayouttemplate.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        fglayouttemplate.setTags(rs.getString(COL_TAGS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fglayouttemplate.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fglayouttemplate.setIsMasterVersion(IS_MASTER_VERSION);
        fglayouttemplate.setStageCode(rs.getString(COL_STAGE_CODE));
        fglayouttemplate.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fglayouttemplate.setDeviceType(rs.getString(COL_DEVICE_TYPE));
        java.math.BigDecimal VERSION_NO = rs.getObject(COL_VERSION_NO, java.math.BigDecimal.class);
        fglayouttemplate.setVersionNo(VERSION_NO);
        fglayouttemplate.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        fglayouttemplate.setTemplateHash(rs.getString(COL_TEMPLATE_HASH));
        fglayouttemplate.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        return fglayouttemplate;
    }
}
