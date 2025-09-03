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

public class JdbcFgSdkUploadDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkUploadDao.class);

    private static final String TABLE = "FG_SDK_UPLOAD";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_SUCCESS_COUNT = "SUCCESS_COUNT";

    private static final String COL_ERROR_COUNT = "ERROR_COUNT";

    private static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    private static final String COL_TOTAL_SUCCESS_AMOUNT = "TOTAL_SUCCESS_AMOUNT";

    private static final String COL_TOTAL_FAILED_AMOUNT = "TOTAL_FAILED_AMOUNT";

    private static final String COL_FINANCE_TYPE_CODE = "FINANCE_TYPE_CODE";

    private static final String COL_FINANCE_DISPLAY_STATUS = "FINANCE_DISPLAY_STATUS";

    private static final String COL_PROGRAM_NAME = "PROGRAM_NAME";

    private static final String COL_PROGRAM_CODE = "PROGRAM_CODE";

    private static final String COL_PARTY_ROLE_CODE = "PARTY_ROLE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_FILE_STATUS = "FILE_STATUS";

    private static final String COL_TASK_REASON_CODE = "TASK_REASON_CODE";

    private static final String COL_TASK_REASON_TEXT = "TASK_REASON_TEXT";

    private static final String COL_WARNING_COUNT = "WARNING_COUNT";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_FINANCE_TYPE_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_NAME, COL_PROGRAM_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_FINANCE_TYPE_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_NAME, COL_PROGRAM_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_ID, COL_ID);

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

    public int insert(Connection conn, FgSdkUpload fgsdkupload) throws SQLException {
        logger.debug("Inserting fgsdkupload: {}", fgsdkupload);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkUploadParams(ps, fgsdkupload);
            ps.executeUpdate();
            return fgsdkupload.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkUpload> fgsdkuploads) throws SQLException {
        if (fgsdkuploads == null || fgsdkuploads.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkuploads.size(); i++) {
            if (fgsdkuploads.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkUpload>> batches = chunkList(fgsdkuploads, batchSize);
        int[] totalResults = new int[fgsdkuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkUpload fgsdkupload : batch) {
                        setFgSdkUploadParams(ps, fgsdkupload);
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

    public FgSdkUpload findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkUpload> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkUpload> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkUpload fgsdkupload) throws SQLException {
        if (fgsdkupload.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkUploadParams(ps, fgsdkupload);
            ps.setInt(38, fgsdkupload.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkUpload> fgsdkuploads) throws SQLException {
        if (fgsdkuploads == null || fgsdkuploads.isEmpty())
            return new int[0];
        for (FgSdkUpload fgsdkupload : fgsdkuploads) {
            if (fgsdkupload == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkupload.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkUpload>> batches = chunkList(fgsdkuploads, batchSize);
        int[] totalResults = new int[fgsdkuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkUpload fgsdkupload : batch) {
                        setFgSdkUploadParams(ps, fgsdkupload);
                        ps.setInt(38, fgsdkupload.getID());
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

    private void setFgSdkUploadParams(PreparedStatement ps, FgSdkUpload fgsdkupload) throws SQLException {
        Integer val1 = fgsdkupload.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkupload.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkupload.getApplicantPartyCode());
        Integer val4 = fgsdkupload.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgsdkupload.getIssuingPartyCode());
        ps.setString(6, fgsdkupload.getTypeCode());
        ps.setString(7, fgsdkupload.getSubTypeCode());
        ps.setString(8, fgsdkupload.getActiveCode());
        ps.setString(9, fgsdkupload.getStageCode());
        ps.setString(10, fgsdkupload.getStatusCode());
        ps.setString(11, fgsdkupload.getCreatedOn());
        java.math.BigDecimal val12 = fgsdkupload.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkupload.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgsdkupload.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkupload.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgsdkupload.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgsdkupload.getTemplate());
        java.math.BigDecimal val18 = fgsdkupload.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = fgsdkupload.getLayoutTemplateID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgsdkupload.getDmsEventID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        java.math.BigDecimal val21 = fgsdkupload.getTotalCount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgsdkupload.getSuccessCount());
        ps.setString(23, fgsdkupload.getErrorCount());
        java.math.BigDecimal val24 = fgsdkupload.getTotalAmount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgsdkupload.getTotalSuccessAmount();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgsdkupload.getTotalFailedAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgsdkupload.getFinanceTypeCode());
        ps.setString(28, fgsdkupload.getFinanceDisplayStatus());
        ps.setString(29, fgsdkupload.getProgramName());
        ps.setString(30, fgsdkupload.getProgramCode());
        ps.setString(31, fgsdkupload.getPartyRoleCode());
        ps.setString(32, fgsdkupload.getEntityTypeCode());
        ps.setString(33, fgsdkupload.getEntitySubTypeCode());
        ps.setString(34, fgsdkupload.getFileStatus());
        ps.setString(35, fgsdkupload.getTaskReasonCode());
        ps.setString(36, fgsdkupload.getTaskReasonText());
        java.math.BigDecimal val37 = fgsdkupload.getWarningCount();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        Integer val38 = fgsdkupload.getLayoutID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
    }

    private FgSdkUpload extract(ResultSet rs) throws SQLException {
        FgSdkUpload fgsdkupload = new FgSdkUpload();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkupload.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkupload.setReferenceID(REFERENCE_ID);
        fgsdkupload.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgsdkupload.setApplicantRefID(APPLICANT_REF_ID);
        fgsdkupload.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgsdkupload.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkupload.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkupload.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkupload.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkupload.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsdkupload.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkupload.setCreatedBy(CREATED_BY);
        fgsdkupload.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkupload.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkupload.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkupload.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkupload.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkupload.setIsTemplate(IS_TEMPLATE);
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgsdkupload.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgsdkupload.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        fgsdkupload.setTotalCount(TOTAL_COUNT);
        fgsdkupload.setSuccessCount(rs.getString(COL_SUCCESS_COUNT));
        fgsdkupload.setErrorCount(rs.getString(COL_ERROR_COUNT));
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgsdkupload.setTotalAmount(TOTAL_AMOUNT);
        java.math.BigDecimal TOTAL_SUCCESS_AMOUNT = rs.getObject(COL_TOTAL_SUCCESS_AMOUNT, java.math.BigDecimal.class);
        fgsdkupload.setTotalSuccessAmount(TOTAL_SUCCESS_AMOUNT);
        java.math.BigDecimal TOTAL_FAILED_AMOUNT = rs.getObject(COL_TOTAL_FAILED_AMOUNT, java.math.BigDecimal.class);
        fgsdkupload.setTotalFailedAmount(TOTAL_FAILED_AMOUNT);
        fgsdkupload.setFinanceTypeCode(rs.getString(COL_FINANCE_TYPE_CODE));
        fgsdkupload.setFinanceDisplayStatus(rs.getString(COL_FINANCE_DISPLAY_STATUS));
        fgsdkupload.setProgramName(rs.getString(COL_PROGRAM_NAME));
        fgsdkupload.setProgramCode(rs.getString(COL_PROGRAM_CODE));
        fgsdkupload.setPartyRoleCode(rs.getString(COL_PARTY_ROLE_CODE));
        fgsdkupload.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgsdkupload.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgsdkupload.setFileStatus(rs.getString(COL_FILE_STATUS));
        fgsdkupload.setTaskReasonCode(rs.getString(COL_TASK_REASON_CODE));
        fgsdkupload.setTaskReasonText(rs.getString(COL_TASK_REASON_TEXT));
        java.math.BigDecimal WARNING_COUNT = rs.getObject(COL_WARNING_COUNT, java.math.BigDecimal.class);
        fgsdkupload.setWarningCount(WARNING_COUNT);
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        fgsdkupload.setLayoutID(LAYOUT_ID);
        return fgsdkupload;
    }
}
