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

public class JdbcFgLayoutTemplateBkp020725Dao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLayoutTemplateBkp020725Dao.class);

    private static final String TABLE = "FG_LAYOUT_TEMPLATE_BKP020725";

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

    public int insert(Connection conn, FgLayoutTemplateBkp020725 fglayouttemplatebkp020725) throws SQLException {
        logger.debug("Inserting fglayouttemplatebkp020725: {}", fglayouttemplatebkp020725);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLayoutTemplateBkp020725Params(ps, fglayouttemplatebkp020725);
            ps.executeUpdate();
            return fglayouttemplatebkp020725.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLayoutTemplateBkp020725> fglayouttemplatebkp020725s) throws SQLException {
        if (fglayouttemplatebkp020725s == null || fglayouttemplatebkp020725s.isEmpty())
            return new int[0];
        for (int i = 0; i < fglayouttemplatebkp020725s.size(); i++) {
            if (fglayouttemplatebkp020725s.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplateBkp020725>> batches = chunkList(fglayouttemplatebkp020725s, batchSize);
        int[] totalResults = new int[fglayouttemplatebkp020725s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplateBkp020725> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLayoutTemplateBkp020725 fglayouttemplatebkp020725 : batch) {
                        setFgLayoutTemplateBkp020725Params(ps, fglayouttemplatebkp020725);
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

    public FgLayoutTemplateBkp020725 findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLayoutTemplateBkp020725> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLayoutTemplateBkp020725> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLayoutTemplateBkp020725 fglayouttemplatebkp020725) throws SQLException {
        if (fglayouttemplatebkp020725.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLayoutTemplateBkp020725Params(ps, fglayouttemplatebkp020725);
            ps.setInt(32, fglayouttemplatebkp020725.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLayoutTemplateBkp020725> fglayouttemplatebkp020725s) throws SQLException {
        if (fglayouttemplatebkp020725s == null || fglayouttemplatebkp020725s.isEmpty())
            return new int[0];
        for (FgLayoutTemplateBkp020725 fglayouttemplatebkp020725 : fglayouttemplatebkp020725s) {
            if (fglayouttemplatebkp020725 == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglayouttemplatebkp020725.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutTemplateBkp020725>> batches = chunkList(fglayouttemplatebkp020725s, batchSize);
        int[] totalResults = new int[fglayouttemplatebkp020725s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutTemplateBkp020725> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLayoutTemplateBkp020725 fglayouttemplatebkp020725 : batch) {
                        setFgLayoutTemplateBkp020725Params(ps, fglayouttemplatebkp020725);
                        ps.setInt(32, fglayouttemplatebkp020725.getID());
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

    private void setFgLayoutTemplateBkp020725Params(PreparedStatement ps, FgLayoutTemplateBkp020725 fglayouttemplatebkp020725) throws SQLException {
        Integer val1 = fglayouttemplatebkp020725.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fglayouttemplatebkp020725.getFileExtension());
        ps.setString(3, fglayouttemplatebkp020725.getFileType());
        ps.setString(4, fglayouttemplatebkp020725.getName());
        ps.setString(5, fglayouttemplatebkp020725.getTemplate());
        ps.setString(6, fglayouttemplatebkp020725.getTypeCode());
        ps.setString(7, fglayouttemplatebkp020725.getSubTypeCode());
        ps.setString(8, fglayouttemplatebkp020725.getDescription());
        ps.setString(9, fglayouttemplatebkp020725.getActiveCode());
        ps.setString(10, fglayouttemplatebkp020725.getStatusCode());
        ps.setString(11, fglayouttemplatebkp020725.getCreatedOn());
        java.math.BigDecimal val12 = fglayouttemplatebkp020725.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglayouttemplatebkp020725.getLastUpdatedOn());
        java.math.BigDecimal val14 = fglayouttemplatebkp020725.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglayouttemplatebkp020725.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fglayouttemplatebkp020725.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        Integer val17 = fglayouttemplatebkp020725.getProcessID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = fglayouttemplatebkp020725.getReferenceID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fglayouttemplatebkp020725.getCategory());
        ps.setString(20, fglayouttemplatebkp020725.getContent());
        ps.setString(21, fglayouttemplatebkp020725.getUuid());
        ps.setString(22, fglayouttemplatebkp020725.getCategoryType());
        ps.setString(23, fglayouttemplatebkp020725.getCategorySubType());
        ps.setString(24, fglayouttemplatebkp020725.getTags());
        Integer val25 = fglayouttemplatebkp020725.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = fglayouttemplatebkp020725.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fglayouttemplatebkp020725.getStageCode());
        ps.setString(28, fglayouttemplatebkp020725.getApplicantPartyCode());
        ps.setString(29, fglayouttemplatebkp020725.getDeviceType());
        java.math.BigDecimal val30 = fglayouttemplatebkp020725.getVersionNo();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fglayouttemplatebkp020725.getMasterContentHash());
        ps.setString(32, fglayouttemplatebkp020725.getTemplateHash());
    }

    private FgLayoutTemplateBkp020725 extract(ResultSet rs) throws SQLException {
        FgLayoutTemplateBkp020725 fglayouttemplatebkp020725 = new FgLayoutTemplateBkp020725();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglayouttemplatebkp020725.setID(ID);
        fglayouttemplatebkp020725.setFileExtension(rs.getString(COL_FILE_EXTENSION));
        fglayouttemplatebkp020725.setFileType(rs.getString(COL_FILE_TYPE));
        fglayouttemplatebkp020725.setName(rs.getString(COL_NAME));
        fglayouttemplatebkp020725.setTemplate(rs.getString(COL_TEMPLATE));
        fglayouttemplatebkp020725.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglayouttemplatebkp020725.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglayouttemplatebkp020725.setDescription(rs.getString(COL_DESCRIPTION));
        fglayouttemplatebkp020725.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglayouttemplatebkp020725.setStatusCode(rs.getString(COL_STATUS_CODE));
        fglayouttemplatebkp020725.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglayouttemplatebkp020725.setCreatedBy(CREATED_BY);
        fglayouttemplatebkp020725.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglayouttemplatebkp020725.setLastUpdatedBy(LAST_UPDATED_BY);
        fglayouttemplatebkp020725.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglayouttemplatebkp020725.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglayouttemplatebkp020725.setProcessID(PROCESS_ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglayouttemplatebkp020725.setReferenceID(REFERENCE_ID);
        fglayouttemplatebkp020725.setCategory(rs.getString(COL_CATEGORY));
        fglayouttemplatebkp020725.setContent(rs.getString(COL_CONTENT));
        fglayouttemplatebkp020725.setUuid(rs.getString(COL_UUID));
        fglayouttemplatebkp020725.setCategoryType(rs.getString(COL_CATEGORY_TYPE));
        fglayouttemplatebkp020725.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        fglayouttemplatebkp020725.setTags(rs.getString(COL_TAGS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fglayouttemplatebkp020725.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fglayouttemplatebkp020725.setIsMasterVersion(IS_MASTER_VERSION);
        fglayouttemplatebkp020725.setStageCode(rs.getString(COL_STAGE_CODE));
        fglayouttemplatebkp020725.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fglayouttemplatebkp020725.setDeviceType(rs.getString(COL_DEVICE_TYPE));
        java.math.BigDecimal VERSION_NO = rs.getObject(COL_VERSION_NO, java.math.BigDecimal.class);
        fglayouttemplatebkp020725.setVersionNo(VERSION_NO);
        fglayouttemplatebkp020725.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        fglayouttemplatebkp020725.setTemplateHash(rs.getString(COL_TEMPLATE_HASH));
        return fglayouttemplatebkp020725;
    }
}
