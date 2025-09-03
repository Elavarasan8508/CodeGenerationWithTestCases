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

public class JdbcBkp110824FgLayoutTemplateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBkp110824FgLayoutTemplateDao.class);

    private static final String TABLE = "BKP110824_FG_LAYOUT_TEMPLATE";

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

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_REFERENCE_ID, COL_CATEGORY, COL_CONTENT, COL_UUID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE, COL_DEVICE_TYPE, COL_VERSION_NO, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_REFERENCE_ID, COL_CATEGORY, COL_CONTENT, COL_UUID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE, COL_DEVICE_TYPE, COL_VERSION_NO, COL_MASTER_CONTENT_HASH, COL_TEMPLATE_HASH, COL_ID);

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

    public int insert(Connection conn, Bkp110824FgLayoutTemplate bkp110824fglayouttemplate) throws SQLException {
        logger.debug("Inserting bkp110824fglayouttemplate: {}", bkp110824fglayouttemplate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBkp110824FgLayoutTemplateParams(ps, bkp110824fglayouttemplate);
            ps.executeUpdate();
            return bkp110824fglayouttemplate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<Bkp110824FgLayoutTemplate> bkp110824fglayouttemplates) throws SQLException {
        if (bkp110824fglayouttemplates == null || bkp110824fglayouttemplates.isEmpty())
            return new int[0];
        for (int i = 0; i < bkp110824fglayouttemplates.size(); i++) {
            if (bkp110824fglayouttemplates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Bkp110824FgLayoutTemplate>> batches = chunkList(bkp110824fglayouttemplates, batchSize);
        int[] totalResults = new int[bkp110824fglayouttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Bkp110824FgLayoutTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Bkp110824FgLayoutTemplate bkp110824fglayouttemplate : batch) {
                        setBkp110824FgLayoutTemplateParams(ps, bkp110824fglayouttemplate);
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

    public Bkp110824FgLayoutTemplate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Bkp110824FgLayoutTemplate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Bkp110824FgLayoutTemplate> list = new ArrayList<>();
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

    public boolean update(Connection conn, Bkp110824FgLayoutTemplate bkp110824fglayouttemplate) throws SQLException {
        if (bkp110824fglayouttemplate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBkp110824FgLayoutTemplateParams(ps, bkp110824fglayouttemplate);
            ps.setInt(32, bkp110824fglayouttemplate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Bkp110824FgLayoutTemplate> bkp110824fglayouttemplates) throws SQLException {
        if (bkp110824fglayouttemplates == null || bkp110824fglayouttemplates.isEmpty())
            return new int[0];
        for (Bkp110824FgLayoutTemplate bkp110824fglayouttemplate : bkp110824fglayouttemplates) {
            if (bkp110824fglayouttemplate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (bkp110824fglayouttemplate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Bkp110824FgLayoutTemplate>> batches = chunkList(bkp110824fglayouttemplates, batchSize);
        int[] totalResults = new int[bkp110824fglayouttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Bkp110824FgLayoutTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Bkp110824FgLayoutTemplate bkp110824fglayouttemplate : batch) {
                        setBkp110824FgLayoutTemplateParams(ps, bkp110824fglayouttemplate);
                        ps.setInt(32, bkp110824fglayouttemplate.getID());
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

    private void setBkp110824FgLayoutTemplateParams(PreparedStatement ps, Bkp110824FgLayoutTemplate bkp110824fglayouttemplate) throws SQLException {
        Integer val1 = bkp110824fglayouttemplate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, bkp110824fglayouttemplate.getFileExtension());
        ps.setString(3, bkp110824fglayouttemplate.getFileType());
        ps.setString(4, bkp110824fglayouttemplate.getName());
        ps.setString(5, bkp110824fglayouttemplate.getTemplate());
        ps.setString(6, bkp110824fglayouttemplate.getTypeCode());
        ps.setString(7, bkp110824fglayouttemplate.getSubTypeCode());
        ps.setString(8, bkp110824fglayouttemplate.getDescription());
        ps.setString(9, bkp110824fglayouttemplate.getActiveCode());
        ps.setString(10, bkp110824fglayouttemplate.getStatusCode());
        ps.setString(11, bkp110824fglayouttemplate.getCreatedOn());
        java.math.BigDecimal val12 = bkp110824fglayouttemplate.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, bkp110824fglayouttemplate.getLastUpdatedOn());
        java.math.BigDecimal val14 = bkp110824fglayouttemplate.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, bkp110824fglayouttemplate.getLastAuthorisedOn());
        java.math.BigDecimal val16 = bkp110824fglayouttemplate.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        Integer val17 = bkp110824fglayouttemplate.getProcessID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = bkp110824fglayouttemplate.getReferenceID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, bkp110824fglayouttemplate.getCategory());
        ps.setString(20, bkp110824fglayouttemplate.getContent());
        ps.setString(21, bkp110824fglayouttemplate.getUuid());
        ps.setString(22, bkp110824fglayouttemplate.getCategoryType());
        ps.setString(23, bkp110824fglayouttemplate.getCategorySubType());
        ps.setString(24, bkp110824fglayouttemplate.getTags());
        Integer val25 = bkp110824fglayouttemplate.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = bkp110824fglayouttemplate.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, bkp110824fglayouttemplate.getStageCode());
        ps.setString(28, bkp110824fglayouttemplate.getApplicantPartyCode());
        ps.setString(29, bkp110824fglayouttemplate.getDeviceType());
        java.math.BigDecimal val30 = bkp110824fglayouttemplate.getVersionNo();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, bkp110824fglayouttemplate.getMasterContentHash());
        ps.setString(32, bkp110824fglayouttemplate.getTemplateHash());
    }

    private Bkp110824FgLayoutTemplate extract(ResultSet rs) throws SQLException {
        Bkp110824FgLayoutTemplate bkp110824fglayouttemplate = new Bkp110824FgLayoutTemplate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        bkp110824fglayouttemplate.setID(ID);
        bkp110824fglayouttemplate.setFileExtension(rs.getString(COL_FILE_EXTENSION));
        bkp110824fglayouttemplate.setFileType(rs.getString(COL_FILE_TYPE));
        bkp110824fglayouttemplate.setName(rs.getString(COL_NAME));
        bkp110824fglayouttemplate.setTemplate(rs.getString(COL_TEMPLATE));
        bkp110824fglayouttemplate.setTypeCode(rs.getString(COL_TYPE_CODE));
        bkp110824fglayouttemplate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        bkp110824fglayouttemplate.setDescription(rs.getString(COL_DESCRIPTION));
        bkp110824fglayouttemplate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        bkp110824fglayouttemplate.setStatusCode(rs.getString(COL_STATUS_CODE));
        bkp110824fglayouttemplate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        bkp110824fglayouttemplate.setCreatedBy(CREATED_BY);
        bkp110824fglayouttemplate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        bkp110824fglayouttemplate.setLastUpdatedBy(LAST_UPDATED_BY);
        bkp110824fglayouttemplate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        bkp110824fglayouttemplate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        bkp110824fglayouttemplate.setProcessID(PROCESS_ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        bkp110824fglayouttemplate.setReferenceID(REFERENCE_ID);
        bkp110824fglayouttemplate.setCategory(rs.getString(COL_CATEGORY));
        bkp110824fglayouttemplate.setContent(rs.getString(COL_CONTENT));
        bkp110824fglayouttemplate.setUuid(rs.getString(COL_UUID));
        bkp110824fglayouttemplate.setCategoryType(rs.getString(COL_CATEGORY_TYPE));
        bkp110824fglayouttemplate.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        bkp110824fglayouttemplate.setTags(rs.getString(COL_TAGS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        bkp110824fglayouttemplate.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        bkp110824fglayouttemplate.setIsMasterVersion(IS_MASTER_VERSION);
        bkp110824fglayouttemplate.setStageCode(rs.getString(COL_STAGE_CODE));
        bkp110824fglayouttemplate.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        bkp110824fglayouttemplate.setDeviceType(rs.getString(COL_DEVICE_TYPE));
        java.math.BigDecimal VERSION_NO = rs.getObject(COL_VERSION_NO, java.math.BigDecimal.class);
        bkp110824fglayouttemplate.setVersionNo(VERSION_NO);
        bkp110824fglayouttemplate.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        bkp110824fglayouttemplate.setTemplateHash(rs.getString(COL_TEMPLATE_HASH));
        return bkp110824fglayouttemplate;
    }
}
