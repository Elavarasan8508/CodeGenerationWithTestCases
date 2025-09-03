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

public class JdbcFgFileUploadDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFileUploadDao.class);

    private static final String TABLE = "FG_FILE_UPLOAD";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

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

    private static final String COL_FG_CLIENT_CODE = "FG_CLIENT_CODE";

    private static final String COL_FG_FILLER_1 = "FG_FILLER_1";

    private static final String COL_FG_FILLER_2 = "FG_FILLER_2";

    private static final String COL_FG_FILLER_3 = "FG_FILLER_3";

    private static final String COL_FG_FILE_NAME_HDR = "FG_FILE_NAME_HDR";

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

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_LAYOUT_TEMPLATE_VERSION_ID = "LAYOUT_TEMPLATE_VERSION_ID";

    private static final String COL_AUTH_LEVEL_CODE = "AUTH_LEVEL_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_FG_SOURCE_CODE = "FG_SOURCE_CODE";

    private static final String COL_FT_TOTAL_NO_OF_INSTRUCTIONS = "FT_TOTAL_NO_OF_INSTRUCTIONS";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FG_BATCH_REF_NUMBER = "FG_BATCH_REF_NUMBER";

    private static final String COL_FG_PRODUCT_CODE = "FG_PRODUCT_CODE";

    private static final String COL_CATEGORY_SUB_TYPE = "CATEGORY_SUB_TYPE";

    private static final String COL_FG_INSTRUCTIONS_COUNT = "FG_INSTRUCTIONS_COUNT";

    private static final String COL_FG_TOTAL_AMOUNT = "FG_TOTAL_AMOUNT";

    private static final String COL_FG_TOTAL_INSTRUMENTS = "FG_TOTAL_INSTRUMENTS";

    private static final String COL_FT_TOTAL_INSTRUMENTS = "FT_TOTAL_INSTRUMENTS";

    private static final String COL_FT_TOTAL_AMOUNT = "FT_TOTAL_AMOUNT";

    private static final String COL_FG_BATCH_DATE = "FG_BATCH_DATE";

    private static final String COL_FG_PAYMENT_DATE = "FG_PAYMENT_DATE";

    private static final String COL_UUID = "UUID";

    private static final String COL_ENTITY = "ENTITY";

    private static final String COL_ISSUERS_REF = "ISSUERS_REF";

    private static final String COL_EQU_CCY = "EQU_CCY";

    private static final String COL_EQU_AMOUNT = "EQU_AMOUNT";

    private static final String COL_BLANKET_AMOUNT = "BLANKET_AMOUNT";

    private static final String COL_TERMS = "TERMS";

    private static final String COL_AUTH_EQU_CCY = "AUTH_EQU_CCY";

    private static final String COL_AUTH_EQU_AMOUNT = "AUTH_EQU_AMOUNT";

    private static final String COL_AUTH_BLANKET_AMOUNT = "AUTH_BLANKET_AMOUNT";

    private static final String COL_DISPLAY_EQU_CCY = "DISPLAY_EQU_CCY";

    private static final String COL_DISPLAY_EQU_AMOUNT = "DISPLAY_EQU_AMOUNT";

    private static final String COL_DISPLAY_BLANKET_AMOUNT = "DISPLAY_BLANKET_AMOUNT";

    private static final String COL_AUTH_FX_BASE_RATE = "AUTH_FX_BASE_RATE";

    private static final String COL_DISPLAY_FX_BASE_RATE = "DISPLAY_FX_BASE_RATE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_OPT_DECLARE = "OPT_DECLARE";

    private static final String COL_FILE_SOURCE = "FILE_SOURCE";

    private static final String COL_STREET_NAME = "STREET_NAME";

    private static final String COL_TOWN_NAME = "TOWN_NAME";

    private static final String COL_COUNTRY_SUB_DIV = "COUNTRY_SUB_DIV";

    private static final String COL_BANK_ABBV_NAME = "BANK_ABBV_NAME";

    private static final String COL_OPTIONAL_DECLARATION = "OPTIONAL_DECLARATION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FG_CLIENT_CODE, COL_FG_FILLER_1, COL_FG_FILLER_2, COL_FG_FILLER_3, COL_FG_FILE_NAME_HDR, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_FINANCE_TYPE_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_NAME, COL_PROGRAM_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON, COL_DISPLAY_STATUS, COL_FG_SOURCE_CODE, COL_FT_TOTAL_NO_OF_INSTRUCTIONS, COL_FILE_NAME, COL_FG_BATCH_REF_NUMBER, COL_FG_PRODUCT_CODE, COL_CATEGORY_SUB_TYPE, COL_FG_INSTRUCTIONS_COUNT, COL_FG_TOTAL_AMOUNT, COL_FG_TOTAL_INSTRUMENTS, COL_FT_TOTAL_INSTRUMENTS, COL_FT_TOTAL_AMOUNT, COL_FG_BATCH_DATE, COL_FG_PAYMENT_DATE, COL_UUID, COL_ENTITY, COL_ISSUERS_REF, COL_EQU_CCY, COL_EQU_AMOUNT, COL_BLANKET_AMOUNT, COL_TERMS, COL_AUTH_EQU_CCY, COL_AUTH_EQU_AMOUNT, COL_AUTH_BLANKET_AMOUNT, COL_DISPLAY_EQU_CCY, COL_DISPLAY_EQU_AMOUNT, COL_DISPLAY_BLANKET_AMOUNT, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_OPT_DECLARE, COL_FILE_SOURCE, COL_STREET_NAME, COL_TOWN_NAME, COL_COUNTRY_SUB_DIV, COL_BANK_ABBV_NAME, COL_OPTIONAL_DECLARATION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FG_CLIENT_CODE, FG_FILLER_1, FG_FILLER_2, FG_FILLER_3, FG_FILE_NAME_HDR, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, PROCESS_ID, UPLOAD_REF_ID, IS_MASTER_VERSION, TASK_REASON, DISPLAY_STATUS, FG_SOURCE_CODE, FT_TOTAL_NO_OF_INSTRUCTIONS, FILE_NAME, FG_BATCH_REF_NUMBER, FG_PRODUCT_CODE, CATEGORY_SUB_TYPE, FG_INSTRUCTIONS_COUNT, FG_TOTAL_AMOUNT, FG_TOTAL_INSTRUMENTS, FT_TOTAL_INSTRUMENTS, FT_TOTAL_AMOUNT, FG_BATCH_DATE, FG_PAYMENT_DATE, UUID, ENTITY, ISSUERS_REF, EQU_CCY, EQU_AMOUNT, BLANKET_AMOUNT, TERMS, AUTH_EQU_CCY, AUTH_EQU_AMOUNT, AUTH_BLANKET_AMOUNT, DISPLAY_EQU_CCY, DISPLAY_EQU_AMOUNT, DISPLAY_BLANKET_AMOUNT, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, OPT_DECLARE, FILE_SOURCE, STREET_NAME, TOWN_NAME, COUNTRY_SUB_DIV, BANK_ABBV_NAME, OPTIONAL_DECLARATION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FG_CLIENT_CODE, FG_FILLER_1, FG_FILLER_2, FG_FILLER_3, FG_FILE_NAME_HDR, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, PROCESS_ID, UPLOAD_REF_ID, IS_MASTER_VERSION, TASK_REASON, DISPLAY_STATUS, FG_SOURCE_CODE, FT_TOTAL_NO_OF_INSTRUCTIONS, FILE_NAME, FG_BATCH_REF_NUMBER, FG_PRODUCT_CODE, CATEGORY_SUB_TYPE, FG_INSTRUCTIONS_COUNT, FG_TOTAL_AMOUNT, FG_TOTAL_INSTRUMENTS, FT_TOTAL_INSTRUMENTS, FT_TOTAL_AMOUNT, FG_BATCH_DATE, FG_PAYMENT_DATE, UUID, ENTITY, ISSUERS_REF, EQU_CCY, EQU_AMOUNT, BLANKET_AMOUNT, TERMS, AUTH_EQU_CCY, AUTH_EQU_AMOUNT, AUTH_BLANKET_AMOUNT, DISPLAY_EQU_CCY, DISPLAY_EQU_AMOUNT, DISPLAY_BLANKET_AMOUNT, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, OPT_DECLARE, FILE_SOURCE, STREET_NAME, TOWN_NAME, COUNTRY_SUB_DIV, BANK_ABBV_NAME, OPTIONAL_DECLARATION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FG_CLIENT_CODE, COL_FG_FILLER_1, COL_FG_FILLER_2, COL_FG_FILLER_3, COL_FG_FILE_NAME_HDR, COL_LAYOUT_TEMPLATE_ID, COL_DMS_EVENT_ID, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_TOTAL_AMOUNT, COL_TOTAL_SUCCESS_AMOUNT, COL_TOTAL_FAILED_AMOUNT, COL_FINANCE_TYPE_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_NAME, COL_PROGRAM_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_FILE_STATUS, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_WARNING_COUNT, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_AUTH_LEVEL_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON, COL_DISPLAY_STATUS, COL_FG_SOURCE_CODE, COL_FT_TOTAL_NO_OF_INSTRUCTIONS, COL_FILE_NAME, COL_FG_BATCH_REF_NUMBER, COL_FG_PRODUCT_CODE, COL_CATEGORY_SUB_TYPE, COL_FG_INSTRUCTIONS_COUNT, COL_FG_TOTAL_AMOUNT, COL_FG_TOTAL_INSTRUMENTS, COL_FT_TOTAL_INSTRUMENTS, COL_FT_TOTAL_AMOUNT, COL_FG_BATCH_DATE, COL_FG_PAYMENT_DATE, COL_UUID, COL_ENTITY, COL_ISSUERS_REF, COL_EQU_CCY, COL_EQU_AMOUNT, COL_BLANKET_AMOUNT, COL_TERMS, COL_AUTH_EQU_CCY, COL_AUTH_EQU_AMOUNT, COL_AUTH_BLANKET_AMOUNT, COL_DISPLAY_EQU_CCY, COL_DISPLAY_EQU_AMOUNT, COL_DISPLAY_BLANKET_AMOUNT, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_OPT_DECLARE, COL_FILE_SOURCE, COL_STREET_NAME, COL_TOWN_NAME, COL_COUNTRY_SUB_DIV, COL_BANK_ABBV_NAME, COL_OPTIONAL_DECLARATION, COL_ID);

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

    public int insert(Connection conn, FgFileUpload fgfileupload) throws SQLException {
        logger.debug("Inserting fgfileupload: {}", fgfileupload);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFileUploadParams(ps, fgfileupload);
            ps.executeUpdate();
            return fgfileupload.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFileUpload> fgfileuploads) throws SQLException {
        if (fgfileuploads == null || fgfileuploads.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfileuploads.size(); i++) {
            if (fgfileuploads.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileUpload>> batches = chunkList(fgfileuploads, batchSize);
        int[] totalResults = new int[fgfileuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFileUpload fgfileupload : batch) {
                        setFgFileUploadParams(ps, fgfileupload);
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

    public FgFileUpload findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFileUpload> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFileUpload> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFileUpload fgfileupload) throws SQLException {
        if (fgfileupload.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFileUploadParams(ps, fgfileupload);
            ps.setInt(85, fgfileupload.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFileUpload> fgfileuploads) throws SQLException {
        if (fgfileuploads == null || fgfileuploads.isEmpty())
            return new int[0];
        for (FgFileUpload fgfileupload : fgfileuploads) {
            if (fgfileupload == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfileupload.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileUpload>> batches = chunkList(fgfileuploads, batchSize);
        int[] totalResults = new int[fgfileuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFileUpload fgfileupload : batch) {
                        setFgFileUploadParams(ps, fgfileupload);
                        ps.setInt(85, fgfileupload.getID());
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

    private void setFgFileUploadParams(PreparedStatement ps, FgFileUpload fgfileupload) throws SQLException {
        Integer val1 = fgfileupload.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfileupload.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfileupload.getTypeCode());
        ps.setString(4, fgfileupload.getSubTypeCode());
        ps.setString(5, fgfileupload.getActiveCode());
        ps.setString(6, fgfileupload.getStageCode());
        ps.setString(7, fgfileupload.getStatusCode());
        ps.setString(8, fgfileupload.getCreatedOn());
        java.math.BigDecimal val9 = fgfileupload.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgfileupload.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgfileupload.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgfileupload.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgfileupload.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgfileupload.getTemplate());
        java.math.BigDecimal val15 = fgfileupload.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgfileupload.getFgClientCode());
        ps.setString(17, fgfileupload.getFgFiller1());
        ps.setString(18, fgfileupload.getFgFiller2());
        ps.setString(19, fgfileupload.getFgFiller3());
        ps.setString(20, fgfileupload.getFgFileNameHdr());
        Integer val21 = fgfileupload.getLayoutTemplateID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgfileupload.getDmsEventID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fgfileupload.getTotalCount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgfileupload.getSuccessCount());
        ps.setString(25, fgfileupload.getErrorCount());
        java.math.BigDecimal val26 = fgfileupload.getTotalAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgfileupload.getTotalSuccessAmount();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgfileupload.getTotalFailedAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, fgfileupload.getFinanceTypeCode());
        ps.setString(30, fgfileupload.getFinanceDisplayStatus());
        ps.setString(31, fgfileupload.getProgramName());
        ps.setString(32, fgfileupload.getProgramCode());
        ps.setString(33, fgfileupload.getPartyRoleCode());
        ps.setString(34, fgfileupload.getEntityTypeCode());
        ps.setString(35, fgfileupload.getEntitySubTypeCode());
        ps.setString(36, fgfileupload.getFileStatus());
        ps.setString(37, fgfileupload.getTaskReasonCode());
        ps.setString(38, fgfileupload.getTaskReasonText());
        java.math.BigDecimal val39 = fgfileupload.getWarningCount();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgfileupload.getLayoutName());
        Integer val41 = fgfileupload.getLayoutTemplateVersionID();
        if (val41 != null) {
            ps.setInt(41, val41);
        } else {
            ps.setNull(41, Types.INTEGER);
        }
        ps.setString(42, fgfileupload.getAuthLevelCode());
        Integer val43 = fgfileupload.getApplicantRefID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        ps.setString(44, fgfileupload.getIssuingPartyCode());
        Integer val45 = fgfileupload.getProcessID();
        if (val45 != null) {
            ps.setInt(45, val45);
        } else {
            ps.setNull(45, Types.INTEGER);
        }
        Integer val46 = fgfileupload.getUploadRefID();
        if (val46 != null) {
            ps.setInt(46, val46);
        } else {
            ps.setNull(46, Types.INTEGER);
        }
        java.math.BigDecimal val47 = fgfileupload.getIsMasterVersion();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        ps.setString(48, fgfileupload.getTaskReason());
        ps.setString(49, fgfileupload.getDisplayStatus());
        ps.setString(50, fgfileupload.getFgSourceCode());
        java.math.BigDecimal val51 = fgfileupload.getFtTotalNoOfInstructions();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        ps.setString(52, fgfileupload.getFileName());
        ps.setString(53, fgfileupload.getFgBatchRefNumber());
        ps.setString(54, fgfileupload.getFgProductCode());
        ps.setString(55, fgfileupload.getCategorySubType());
        java.math.BigDecimal val56 = fgfileupload.getFgInstructionsCount();
        if (val56 != null) {
            ps.setBigDecimal(56, val56);
        } else {
            ps.setNull(56, Types.DECIMAL);
        }
        java.math.BigDecimal val57 = fgfileupload.getFgTotalAmount();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        java.math.BigDecimal val58 = fgfileupload.getFgTotalInstruments();
        if (val58 != null) {
            ps.setBigDecimal(58, val58);
        } else {
            ps.setNull(58, Types.DECIMAL);
        }
        java.math.BigDecimal val59 = fgfileupload.getFtTotalInstruments();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        java.math.BigDecimal val60 = fgfileupload.getFtTotalAmount();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        java.time.LocalDateTime val61 = fgfileupload.getFgBatchDate();
        if (val61 != null) {
            ps.setTimestamp(61, java.sql.Timestamp.valueOf(val61));
        } else {
            ps.setNull(61, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val62 = fgfileupload.getFgPaymentDate();
        if (val62 != null) {
            ps.setTimestamp(62, java.sql.Timestamp.valueOf(val62));
        } else {
            ps.setNull(62, Types.TIMESTAMP);
        }
        ps.setString(63, fgfileupload.getUuid());
        ps.setString(64, fgfileupload.getEntity());
        ps.setString(65, fgfileupload.getIssuersRef());
        ps.setString(66, fgfileupload.getEquCcy());
        java.math.BigDecimal val67 = fgfileupload.getEquAmount();
        if (val67 != null) {
            ps.setBigDecimal(67, val67);
        } else {
            ps.setNull(67, Types.DECIMAL);
        }
        java.math.BigDecimal val68 = fgfileupload.getBlanketAmount();
        if (val68 != null) {
            ps.setBigDecimal(68, val68);
        } else {
            ps.setNull(68, Types.DECIMAL);
        }
        java.math.BigDecimal val69 = fgfileupload.getTerms();
        if (val69 != null) {
            ps.setBigDecimal(69, val69);
        } else {
            ps.setNull(69, Types.DECIMAL);
        }
        ps.setString(70, fgfileupload.getAuthEquCcy());
        java.math.BigDecimal val71 = fgfileupload.getAuthEquAmount();
        if (val71 != null) {
            ps.setBigDecimal(71, val71);
        } else {
            ps.setNull(71, Types.DECIMAL);
        }
        java.math.BigDecimal val72 = fgfileupload.getAuthBlanketAmount();
        if (val72 != null) {
            ps.setBigDecimal(72, val72);
        } else {
            ps.setNull(72, Types.DECIMAL);
        }
        ps.setString(73, fgfileupload.getDisplayEquCcy());
        java.math.BigDecimal val74 = fgfileupload.getDisplayEquAmount();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        java.math.BigDecimal val75 = fgfileupload.getDisplayBlanketAmount();
        if (val75 != null) {
            ps.setBigDecimal(75, val75);
        } else {
            ps.setNull(75, Types.DECIMAL);
        }
        java.math.BigDecimal val76 = fgfileupload.getAuthFxBaseRate();
        if (val76 != null) {
            ps.setBigDecimal(76, val76);
        } else {
            ps.setNull(76, Types.DECIMAL);
        }
        java.math.BigDecimal val77 = fgfileupload.getDisplayFxBaseRate();
        if (val77 != null) {
            ps.setBigDecimal(77, val77);
        } else {
            ps.setNull(77, Types.DECIMAL);
        }
        ps.setString(78, fgfileupload.getApplicantPartyCode());
        java.math.BigDecimal val79 = fgfileupload.getOptDeclare();
        if (val79 != null) {
            ps.setBigDecimal(79, val79);
        } else {
            ps.setNull(79, Types.DECIMAL);
        }
        ps.setString(80, fgfileupload.getFileSource());
        ps.setString(81, fgfileupload.getStreetName());
        ps.setString(82, fgfileupload.getTownName());
        ps.setString(83, fgfileupload.getCountrySubDiv());
        ps.setString(84, fgfileupload.getBankAbbvName());
        java.math.BigDecimal val85 = fgfileupload.getOptionalDeclaration();
        if (val85 != null) {
            ps.setBigDecimal(85, val85);
        } else {
            ps.setNull(85, Types.DECIMAL);
        }
    }

    private FgFileUpload extract(ResultSet rs) throws SQLException {
        FgFileUpload fgfileupload = new FgFileUpload();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfileupload.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfileupload.setReferenceID(REFERENCE_ID);
        fgfileupload.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfileupload.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfileupload.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfileupload.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfileupload.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgfileupload.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfileupload.setCreatedBy(CREATED_BY);
        fgfileupload.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfileupload.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfileupload.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfileupload.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfileupload.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfileupload.setIsTemplate(IS_TEMPLATE);
        fgfileupload.setFgClientCode(rs.getString(COL_FG_CLIENT_CODE));
        fgfileupload.setFgFiller1(rs.getString(COL_FG_FILLER_1));
        fgfileupload.setFgFiller2(rs.getString(COL_FG_FILLER_2));
        fgfileupload.setFgFiller3(rs.getString(COL_FG_FILLER_3));
        fgfileupload.setFgFileNameHdr(rs.getString(COL_FG_FILE_NAME_HDR));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgfileupload.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgfileupload.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        fgfileupload.setTotalCount(TOTAL_COUNT);
        fgfileupload.setSuccessCount(rs.getString(COL_SUCCESS_COUNT));
        fgfileupload.setErrorCount(rs.getString(COL_ERROR_COUNT));
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setTotalAmount(TOTAL_AMOUNT);
        java.math.BigDecimal TOTAL_SUCCESS_AMOUNT = rs.getObject(COL_TOTAL_SUCCESS_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setTotalSuccessAmount(TOTAL_SUCCESS_AMOUNT);
        java.math.BigDecimal TOTAL_FAILED_AMOUNT = rs.getObject(COL_TOTAL_FAILED_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setTotalFailedAmount(TOTAL_FAILED_AMOUNT);
        fgfileupload.setFinanceTypeCode(rs.getString(COL_FINANCE_TYPE_CODE));
        fgfileupload.setFinanceDisplayStatus(rs.getString(COL_FINANCE_DISPLAY_STATUS));
        fgfileupload.setProgramName(rs.getString(COL_PROGRAM_NAME));
        fgfileupload.setProgramCode(rs.getString(COL_PROGRAM_CODE));
        fgfileupload.setPartyRoleCode(rs.getString(COL_PARTY_ROLE_CODE));
        fgfileupload.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgfileupload.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgfileupload.setFileStatus(rs.getString(COL_FILE_STATUS));
        fgfileupload.setTaskReasonCode(rs.getString(COL_TASK_REASON_CODE));
        fgfileupload.setTaskReasonText(rs.getString(COL_TASK_REASON_TEXT));
        java.math.BigDecimal WARNING_COUNT = rs.getObject(COL_WARNING_COUNT, java.math.BigDecimal.class);
        fgfileupload.setWarningCount(WARNING_COUNT);
        fgfileupload.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer LAYOUT_TEMPLATE_VERSION_ID = rs.getObject(COL_LAYOUT_TEMPLATE_VERSION_ID, Integer.class);
        fgfileupload.setLayoutTemplateVersionID(LAYOUT_TEMPLATE_VERSION_ID);
        fgfileupload.setAuthLevelCode(rs.getString(COL_AUTH_LEVEL_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgfileupload.setApplicantRefID(APPLICANT_REF_ID);
        fgfileupload.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgfileupload.setProcessID(PROCESS_ID);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfileupload.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgfileupload.setIsMasterVersion(IS_MASTER_VERSION);
        fgfileupload.setTaskReason(rs.getString(COL_TASK_REASON));
        fgfileupload.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        fgfileupload.setFgSourceCode(rs.getString(COL_FG_SOURCE_CODE));
        java.math.BigDecimal FT_TOTAL_NO_OF_INSTRUCTIONS = rs.getObject(COL_FT_TOTAL_NO_OF_INSTRUCTIONS, java.math.BigDecimal.class);
        fgfileupload.setFtTotalNoOfInstructions(FT_TOTAL_NO_OF_INSTRUCTIONS);
        fgfileupload.setFileName(rs.getString(COL_FILE_NAME));
        fgfileupload.setFgBatchRefNumber(rs.getString(COL_FG_BATCH_REF_NUMBER));
        fgfileupload.setFgProductCode(rs.getString(COL_FG_PRODUCT_CODE));
        fgfileupload.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        java.math.BigDecimal FG_INSTRUCTIONS_COUNT = rs.getObject(COL_FG_INSTRUCTIONS_COUNT, java.math.BigDecimal.class);
        fgfileupload.setFgInstructionsCount(FG_INSTRUCTIONS_COUNT);
        java.math.BigDecimal FG_TOTAL_AMOUNT = rs.getObject(COL_FG_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setFgTotalAmount(FG_TOTAL_AMOUNT);
        java.math.BigDecimal FG_TOTAL_INSTRUMENTS = rs.getObject(COL_FG_TOTAL_INSTRUMENTS, java.math.BigDecimal.class);
        fgfileupload.setFgTotalInstruments(FG_TOTAL_INSTRUMENTS);
        java.math.BigDecimal FT_TOTAL_INSTRUMENTS = rs.getObject(COL_FT_TOTAL_INSTRUMENTS, java.math.BigDecimal.class);
        fgfileupload.setFtTotalInstruments(FT_TOTAL_INSTRUMENTS);
        java.math.BigDecimal FT_TOTAL_AMOUNT = rs.getObject(COL_FT_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setFtTotalAmount(FT_TOTAL_AMOUNT);
        Timestamp FG_BATCH_DATE = rs.getTimestamp(COL_FG_BATCH_DATE);
        if (FG_BATCH_DATE != null)
            fgfileupload.setFgBatchDate(FG_BATCH_DATE.toLocalDateTime());
        Timestamp FG_PAYMENT_DATE = rs.getTimestamp(COL_FG_PAYMENT_DATE);
        if (FG_PAYMENT_DATE != null)
            fgfileupload.setFgPaymentDate(FG_PAYMENT_DATE.toLocalDateTime());
        fgfileupload.setUuid(rs.getString(COL_UUID));
        fgfileupload.setEntity(rs.getString(COL_ENTITY));
        fgfileupload.setIssuersRef(rs.getString(COL_ISSUERS_REF));
        fgfileupload.setEquCcy(rs.getString(COL_EQU_CCY));
        java.math.BigDecimal EQU_AMOUNT = rs.getObject(COL_EQU_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setEquAmount(EQU_AMOUNT);
        java.math.BigDecimal BLANKET_AMOUNT = rs.getObject(COL_BLANKET_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setBlanketAmount(BLANKET_AMOUNT);
        java.math.BigDecimal TERMS = rs.getObject(COL_TERMS, java.math.BigDecimal.class);
        fgfileupload.setTerms(TERMS);
        fgfileupload.setAuthEquCcy(rs.getString(COL_AUTH_EQU_CCY));
        java.math.BigDecimal AUTH_EQU_AMOUNT = rs.getObject(COL_AUTH_EQU_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setAuthEquAmount(AUTH_EQU_AMOUNT);
        java.math.BigDecimal AUTH_BLANKET_AMOUNT = rs.getObject(COL_AUTH_BLANKET_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setAuthBlanketAmount(AUTH_BLANKET_AMOUNT);
        fgfileupload.setDisplayEquCcy(rs.getString(COL_DISPLAY_EQU_CCY));
        java.math.BigDecimal DISPLAY_EQU_AMOUNT = rs.getObject(COL_DISPLAY_EQU_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setDisplayEquAmount(DISPLAY_EQU_AMOUNT);
        java.math.BigDecimal DISPLAY_BLANKET_AMOUNT = rs.getObject(COL_DISPLAY_BLANKET_AMOUNT, java.math.BigDecimal.class);
        fgfileupload.setDisplayBlanketAmount(DISPLAY_BLANKET_AMOUNT);
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgfileupload.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgfileupload.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgfileupload.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        java.math.BigDecimal OPT_DECLARE = rs.getObject(COL_OPT_DECLARE, java.math.BigDecimal.class);
        fgfileupload.setOptDeclare(OPT_DECLARE);
        fgfileupload.setFileSource(rs.getString(COL_FILE_SOURCE));
        fgfileupload.setStreetName(rs.getString(COL_STREET_NAME));
        fgfileupload.setTownName(rs.getString(COL_TOWN_NAME));
        fgfileupload.setCountrySubDiv(rs.getString(COL_COUNTRY_SUB_DIV));
        fgfileupload.setBankAbbvName(rs.getString(COL_BANK_ABBV_NAME));
        java.math.BigDecimal OPTIONAL_DECLARATION = rs.getObject(COL_OPTIONAL_DECLARATION, java.math.BigDecimal.class);
        fgfileupload.setOptionalDeclaration(OPTIONAL_DECLARATION);
        return fgfileupload;
    }
}
