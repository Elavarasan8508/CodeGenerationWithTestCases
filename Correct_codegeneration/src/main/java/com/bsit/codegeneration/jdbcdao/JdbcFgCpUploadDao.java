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

public class JdbcFgCpUploadDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgCpUploadDao.class);

    private static final String TABLE = "FG_CP_UPLOAD";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_UUID = "UUID";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_SUCCESS_COUNT = "SUCCESS_COUNT";

    private static final String COL_ERROR_COUNT = "ERROR_COUNT";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_LAYOUT_TEMPLATE_VERSION_ID = "LAYOUT_TEMPLATE_VERSION_ID";

    private static final String COL_AUTH_LEVEL_CODE = "AUTH_LEVEL_CODE";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_CATEGORY_SUB_TYPE = "CATEGORY_SUB_TYPE";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FORMAT_NAME = "FORMAT_NAME";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_UUID, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_FILE_NAME, COL_CATEGORY_SUB_TYPE, COL_TASK_REASON, COL_UPLOAD_REF_ID, COL_FORMAT_NAME, COL_DISPLAY_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, UUID, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, FILE_NAME, CATEGORY_SUB_TYPE, TASK_REASON, UPLOAD_REF_ID, FORMAT_NAME, DISPLAY_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, UUID, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, FILE_NAME, CATEGORY_SUB_TYPE, TASK_REASON, UPLOAD_REF_ID, FORMAT_NAME, DISPLAY_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_UUID, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_FILE_NAME, COL_CATEGORY_SUB_TYPE, COL_TASK_REASON, COL_UPLOAD_REF_ID, COL_FORMAT_NAME, COL_DISPLAY_STATUS, COL_ID);

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

    public int insert(Connection conn, FgCpUpload fgcpupload) throws SQLException {
        logger.debug("Inserting fgcpupload: {}", fgcpupload);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgCpUploadParams(ps, fgcpupload);
            ps.executeUpdate();
            return fgcpupload.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgCpUpload> fgcpuploads) throws SQLException {
        if (fgcpuploads == null || fgcpuploads.isEmpty())
            return new int[0];
        for (int i = 0; i < fgcpuploads.size(); i++) {
            if (fgcpuploads.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCpUpload>> batches = chunkList(fgcpuploads, batchSize);
        int[] totalResults = new int[fgcpuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCpUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgCpUpload fgcpupload : batch) {
                        setFgCpUploadParams(ps, fgcpupload);
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

    public FgCpUpload findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgCpUpload> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgCpUpload> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgCpUpload fgcpupload) throws SQLException {
        if (fgcpupload.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgCpUploadParams(ps, fgcpupload);
            ps.setInt(34, fgcpupload.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgCpUpload> fgcpuploads) throws SQLException {
        if (fgcpuploads == null || fgcpuploads.isEmpty())
            return new int[0];
        for (FgCpUpload fgcpupload : fgcpuploads) {
            if (fgcpupload == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgcpupload.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCpUpload>> batches = chunkList(fgcpuploads, batchSize);
        int[] totalResults = new int[fgcpuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCpUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgCpUpload fgcpupload : batch) {
                        setFgCpUploadParams(ps, fgcpupload);
                        ps.setInt(34, fgcpupload.getID());
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

    private void setFgCpUploadParams(PreparedStatement ps, FgCpUpload fgcpupload) throws SQLException {
        Integer val1 = fgcpupload.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgcpupload.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgcpupload.getTypeCode());
        ps.setString(4, fgcpupload.getSubTypeCode());
        ps.setString(5, fgcpupload.getActiveCode());
        ps.setString(6, fgcpupload.getStageCode());
        ps.setString(7, fgcpupload.getStatusCode());
        Integer val8 = fgcpupload.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgcpupload.getCreatedOn());
        java.math.BigDecimal val10 = fgcpupload.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgcpupload.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgcpupload.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgcpupload.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgcpupload.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgcpupload.getTemplate());
        ps.setString(16, fgcpupload.getApplicantPartyCode());
        ps.setString(17, fgcpupload.getIssuingPartyCode());
        java.math.BigDecimal val18 = fgcpupload.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgcpupload.getUuid());
        Integer val20 = fgcpupload.getLayoutTemplateID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = fgcpupload.getDmsEventID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.math.BigDecimal val22 = fgcpupload.getTotalCount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgcpupload.getSuccessCount());
        ps.setString(24, fgcpupload.getErrorCount());
        ps.setString(25, fgcpupload.getEntityTypeCode());
        ps.setString(26, fgcpupload.getEntitySubTypeCode());
        Integer val27 = fgcpupload.getLayoutTemplateVersionID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgcpupload.getAuthLevelCode());
        ps.setString(29, fgcpupload.getFileName());
        ps.setString(30, fgcpupload.getCategorySubType());
        ps.setString(31, fgcpupload.getTaskReason());
        Integer val32 = fgcpupload.getUploadRefID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        ps.setString(33, fgcpupload.getFormatName());
        ps.setString(34, fgcpupload.getDisplayStatus());
    }

    private FgCpUpload extract(ResultSet rs) throws SQLException {
        FgCpUpload fgcpupload = new FgCpUpload();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgcpupload.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgcpupload.setReferenceID(REFERENCE_ID);
        fgcpupload.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgcpupload.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgcpupload.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgcpupload.setStageCode(rs.getString(COL_STAGE_CODE));
        fgcpupload.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgcpupload.setProcessID(PROCESS_ID);
        fgcpupload.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgcpupload.setCreatedBy(CREATED_BY);
        fgcpupload.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgcpupload.setLastUpdatedBy(LAST_UPDATED_BY);
        fgcpupload.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgcpupload.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgcpupload.setTemplate(rs.getString(COL_TEMPLATE));
        fgcpupload.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgcpupload.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgcpupload.setIsTemplate(IS_TEMPLATE);
        fgcpupload.setUuid(rs.getString(COL_UUID));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgcpupload.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgcpupload.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        fgcpupload.setTotalCount(TOTAL_COUNT);
        fgcpupload.setSuccessCount(rs.getString(COL_SUCCESS_COUNT));
        fgcpupload.setErrorCount(rs.getString(COL_ERROR_COUNT));
        fgcpupload.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgcpupload.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer LAYOUT_TEMPLATE_VERSION_ID = rs.getObject(COL_LAYOUT_TEMPLATE_VERSION_ID, Integer.class);
        fgcpupload.setLayoutTemplateVersionID(LAYOUT_TEMPLATE_VERSION_ID);
        fgcpupload.setAuthLevelCode(rs.getString(COL_AUTH_LEVEL_CODE));
        fgcpupload.setFileName(rs.getString(COL_FILE_NAME));
        fgcpupload.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        fgcpupload.setTaskReason(rs.getString(COL_TASK_REASON));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgcpupload.setUploadRefID(UPLOAD_REF_ID);
        fgcpupload.setFormatName(rs.getString(COL_FORMAT_NAME));
        fgcpupload.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        return fgcpupload;
    }
}
