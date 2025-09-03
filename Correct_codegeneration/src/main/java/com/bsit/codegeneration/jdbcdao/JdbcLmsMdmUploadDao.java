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

public class JdbcLmsMdmUploadDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmUploadDao.class);

    private static final String TABLE = "LMS_MDM_UPLOAD";

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

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_SUCCESS_COUNT = "SUCCESS_COUNT";

    private static final String COL_ERROR_COUNT = "ERROR_COUNT";

    private static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    private static final String COL_TOTAL_SUCCESS_AMOUNT = "TOTAL_SUCCESS_AMOUNT";

    private static final String COL_TOTAL_FAILED_AMOUNT = "TOTAL_FAILED_AMOUNT";

    private static final String COL_PARTY_ROLE_CODE = "PARTY_ROLE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_FILE_STATUS = "FILE_STATUS";

    private static final String COL_TASK_REASON_CODE = "TASK_REASON_CODE";

    private static final String COL_TASK_REASON_TEXT = "TASK_REASON_TEXT";

    private static final String COL_WARNING_COUNT = "WARNING_COUNT";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_LAYOUT_TEMPLATE_VERSION_ID = "LAYOUT_TEMPLATE_VERSION_ID";

    private static final String COL_AUTH_LEVEL_CODE = "AUTH_LEVEL_CODE";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ENTITY_NAME = "ENTITY_NAME";

    private static final String COL_TNX_TYPE_CODE = "TNX_TYPE_CODE";

    private static final String COL_REVERSE_FILE_STATUS = "REVERSE_FILE_STATUS";

    private static final String COL_SEGMENT_TEAMS = "SEGMENT_TEAMS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_TASK_REASON, COL_FILE_NAME, COL_DISPLAY_STATUS, COL_UPLOAD_REF_ID, COL_ENTITY_NAME, COL_TNX_TYPE_CODE, COL_REVERSE_FILE_STATUS, COL_SEGMENT_TEAMS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, TASK_REASON, FILE_NAME, DISPLAY_STATUS, UPLOAD_REF_ID, ENTITY_NAME, TNX_TYPE_CODE, REVERSE_FILE_STATUS, SEGMENT_TEAMS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, TASK_REASON, FILE_NAME, DISPLAY_STATUS, UPLOAD_REF_ID, ENTITY_NAME, TNX_TYPE_CODE, REVERSE_FILE_STATUS, SEGMENT_TEAMS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_TASK_REASON, COL_FILE_NAME, COL_DISPLAY_STATUS, COL_UPLOAD_REF_ID, COL_ENTITY_NAME, COL_TNX_TYPE_CODE, COL_REVERSE_FILE_STATUS, COL_SEGMENT_TEAMS, COL_ID);

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

    public int insert(Connection conn, LmsMdmUpload lmsmdmupload) throws SQLException {
        logger.debug("Inserting lmsmdmupload: {}", lmsmdmupload);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmUploadParams(ps, lmsmdmupload);
            ps.executeUpdate();
            return lmsmdmupload.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmUpload> lmsmdmuploads) throws SQLException {
        if (lmsmdmuploads == null || lmsmdmuploads.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmuploads.size(); i++) {
            if (lmsmdmuploads.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmUpload>> batches = chunkList(lmsmdmuploads, batchSize);
        int[] totalResults = new int[lmsmdmuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmUpload lmsmdmupload : batch) {
                        setLmsMdmUploadParams(ps, lmsmdmupload);
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

    public LmsMdmUpload findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmUpload> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmUpload> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmUpload lmsmdmupload) throws SQLException {
        if (lmsmdmupload.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmUploadParams(ps, lmsmdmupload);
            ps.setInt(44, lmsmdmupload.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmUpload> lmsmdmuploads) throws SQLException {
        if (lmsmdmuploads == null || lmsmdmuploads.isEmpty())
            return new int[0];
        for (LmsMdmUpload lmsmdmupload : lmsmdmuploads) {
            if (lmsmdmupload == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmupload.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmUpload>> batches = chunkList(lmsmdmuploads, batchSize);
        int[] totalResults = new int[lmsmdmuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmUpload lmsmdmupload : batch) {
                        setLmsMdmUploadParams(ps, lmsmdmupload);
                        ps.setInt(44, lmsmdmupload.getID());
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

    private void setLmsMdmUploadParams(PreparedStatement ps, LmsMdmUpload lmsmdmupload) throws SQLException {
        Integer val1 = lmsmdmupload.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmupload.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmupload.getTypeCode());
        ps.setString(4, lmsmdmupload.getSubTypeCode());
        ps.setString(5, lmsmdmupload.getActiveCode());
        ps.setString(6, lmsmdmupload.getStageCode());
        ps.setString(7, lmsmdmupload.getStatusCode());
        Integer val8 = lmsmdmupload.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmupload.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmupload.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmupload.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmupload.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmupload.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmupload.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmupload.getTemplate());
        ps.setString(16, lmsmdmupload.getApplicantParty());
        ps.setString(17, lmsmdmupload.getFulfillmentParty());
        java.math.BigDecimal val18 = lmsmdmupload.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = lmsmdmupload.getLayoutTemplateID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = lmsmdmupload.getDmsEventID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        java.math.BigDecimal val21 = lmsmdmupload.getTotalCount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, lmsmdmupload.getSuccessCount());
        ps.setString(23, lmsmdmupload.getErrorCount());
        java.math.BigDecimal val24 = lmsmdmupload.getTotalAmount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = lmsmdmupload.getTotalSuccessAmount();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = lmsmdmupload.getTotalFailedAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, lmsmdmupload.getPartyRoleCode());
        ps.setString(28, lmsmdmupload.getEntityTypeCode());
        ps.setString(29, lmsmdmupload.getEntitySubTypeCode());
        ps.setString(30, lmsmdmupload.getFileStatus());
        ps.setString(31, lmsmdmupload.getTaskReasonCode());
        ps.setString(32, lmsmdmupload.getTaskReasonText());
        java.math.BigDecimal val33 = lmsmdmupload.getWarningCount();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        ps.setString(34, lmsmdmupload.getLayoutName());
        Integer val35 = lmsmdmupload.getLayoutTemplateVersionID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
        ps.setString(36, lmsmdmupload.getAuthLevelCode());
        ps.setString(37, lmsmdmupload.getTaskReason());
        ps.setString(38, lmsmdmupload.getFileName());
        ps.setString(39, lmsmdmupload.getDisplayStatus());
        Integer val40 = lmsmdmupload.getUploadRefID();
        if (val40 != null) {
            ps.setInt(40, val40);
        } else {
            ps.setNull(40, Types.INTEGER);
        }
        ps.setString(41, lmsmdmupload.getEntityName());
        ps.setString(42, lmsmdmupload.getTnxTypeCode());
        ps.setString(43, lmsmdmupload.getReverseFileStatus());
        ps.setString(44, lmsmdmupload.getSegmentTeams());
    }

    private LmsMdmUpload extract(ResultSet rs) throws SQLException {
        LmsMdmUpload lmsmdmupload = new LmsMdmUpload();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmupload.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmupload.setReferenceID(REFERENCE_ID);
        lmsmdmupload.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmupload.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmupload.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmupload.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmupload.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmupload.setProcessID(PROCESS_ID);
        lmsmdmupload.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmupload.setCreatedBy(CREATED_BY);
        lmsmdmupload.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmupload.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmupload.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmupload.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmupload.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmupload.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmupload.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmupload.setIsTemplate(IS_TEMPLATE);
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        lmsmdmupload.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        lmsmdmupload.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        lmsmdmupload.setTotalCount(TOTAL_COUNT);
        lmsmdmupload.setSuccessCount(rs.getString(COL_SUCCESS_COUNT));
        lmsmdmupload.setErrorCount(rs.getString(COL_ERROR_COUNT));
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        lmsmdmupload.setTotalAmount(TOTAL_AMOUNT);
        java.math.BigDecimal TOTAL_SUCCESS_AMOUNT = rs.getObject(COL_TOTAL_SUCCESS_AMOUNT, java.math.BigDecimal.class);
        lmsmdmupload.setTotalSuccessAmount(TOTAL_SUCCESS_AMOUNT);
        java.math.BigDecimal TOTAL_FAILED_AMOUNT = rs.getObject(COL_TOTAL_FAILED_AMOUNT, java.math.BigDecimal.class);
        lmsmdmupload.setTotalFailedAmount(TOTAL_FAILED_AMOUNT);
        lmsmdmupload.setPartyRoleCode(rs.getString(COL_PARTY_ROLE_CODE));
        lmsmdmupload.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        lmsmdmupload.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        lmsmdmupload.setFileStatus(rs.getString(COL_FILE_STATUS));
        lmsmdmupload.setTaskReasonCode(rs.getString(COL_TASK_REASON_CODE));
        lmsmdmupload.setTaskReasonText(rs.getString(COL_TASK_REASON_TEXT));
        java.math.BigDecimal WARNING_COUNT = rs.getObject(COL_WARNING_COUNT, java.math.BigDecimal.class);
        lmsmdmupload.setWarningCount(WARNING_COUNT);
        lmsmdmupload.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer LAYOUT_TEMPLATE_VERSION_ID = rs.getObject(COL_LAYOUT_TEMPLATE_VERSION_ID, Integer.class);
        lmsmdmupload.setLayoutTemplateVersionID(LAYOUT_TEMPLATE_VERSION_ID);
        lmsmdmupload.setAuthLevelCode(rs.getString(COL_AUTH_LEVEL_CODE));
        lmsmdmupload.setTaskReason(rs.getString(COL_TASK_REASON));
        lmsmdmupload.setFileName(rs.getString(COL_FILE_NAME));
        lmsmdmupload.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        lmsmdmupload.setUploadRefID(UPLOAD_REF_ID);
        lmsmdmupload.setEntityName(rs.getString(COL_ENTITY_NAME));
        lmsmdmupload.setTnxTypeCode(rs.getString(COL_TNX_TYPE_CODE));
        lmsmdmupload.setReverseFileStatus(rs.getString(COL_REVERSE_FILE_STATUS));
        lmsmdmupload.setSegmentTeams(rs.getString(COL_SEGMENT_TEAMS));
        return lmsmdmupload;
    }
}
