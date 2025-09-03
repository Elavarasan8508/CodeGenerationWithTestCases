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

public class JdbcFgEkycReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEkycReqDao.class);

    private static final String TABLE = "FG_EKYC_REQ";

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

    private static final String COL_CLIENT_CRN_REF = "CLIENT_CRN_REF";

    private static final String COL_FIRST_NAME = "FIRST_NAME";

    private static final String COL_LAST_NAME = "LAST_NAME";

    private static final String COL_EMAIL = "EMAIL";

    private static final String COL_MOBILE = "MOBILE";

    private static final String COL_FATHER_NAME = "FATHER_NAME";

    private static final String COL_MOTHER_MAIDEN_NAME = "MOTHER_MAIDEN_NAME";

    private static final String COL_OCCUPATION = "OCCUPATION";

    private static final String COL_GENDER = "GENDER";

    private static final String COL_MARITAL_STATUS = "MARITAL_STATUS";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_REFERENCE_ID = "ENTITY_REFERENCE_ID";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_ENTITY_CUSTOMER_CRN = "ENTITY_CUSTOMER_CRN";

    private static final String COL_ENTITY_APPLICANT_USER_CRN = "ENTITY_APPLICANT_USER_CRN";

    private static final String COL_AADHAAR_OPTION = "AADHAAR_OPTION";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_EXPIRES_ON = "EXPIRES_ON";

    private static final String COL_EKYC_DISPLAY_STATUS = "EKYC_DISPLAY_STATUS";

    private static final String COL_EMAIL_STATUS_CODE = "EMAIL_STATUS_CODE";

    private static final String COL_MOBILE_STATUS_CODE = "MOBILE_STATUS_CODE";

    private static final String COL_TC_STATUS_CODE = "TC_STATUS_CODE";

    private static final String COL_AADHAAR_CONSENT_STATUS_CODE = "AADHAAR_CONSENT_STATUS_CODE";

    private static final String COL_AADHAAR_VERIFY_STATUS_CODE = "AADHAAR_VERIFY_STATUS_CODE";

    private static final String COL_AADHAAR_INFO_STATUS_CODE = "AADHAAR_INFO_STATUS_CODE";

    private static final String COL_PAN_LINK_STATUS_CODE = "PAN_LINK_STATUS_CODE";

    private static final String COL_PAN_NAME_STATUS_CODE = "PAN_NAME_STATUS_CODE";

    private static final String COL_PAN_VERIFY_STATUS_CODE = "PAN_VERIFY_STATUS_CODE";

    private static final String COL_PERSONAL_INFO_STATUS_CODE = "PERSONAL_INFO_STATUS_CODE";

    private static final String COL_AADHAAR_ID_REFERENCE_ENC = "AADHAAR_ID_REFERENCE_ENC";

    private static final String COL_AADHAAR_VID_REFERENCE_ENC = "AADHAAR_VID_REFERENCE_ENC";

    private static final String COL_AADHAAR_ID_REFERENCE_MASK = "AADHAAR_ID_REFERENCE_MASK";

    private static final String COL_AADHAAR_VID_REFERENCE_MASK = "AADHAAR_VID_REFERENCE_MASK";

    private static final String COL_PAN_ID_REFERENCE_ENC = "PAN_ID_REFERENCE_ENC";

    private static final String COL_CURRENT_STEP_CODE = "CURRENT_STEP_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_RESEND_ATTEMPT_CNT = "RESEND_ATTEMPT_CNT";

    private static final String COL_RESEND_LAST_ATTEMPT_ON = "RESEND_LAST_ATTEMPT_ON";

    private static final String COL_AADHAAR_CONSENT_LANG_CODE = "AADHAAR_CONSENT_LANG_CODE";

    private static final String COL_AADHAAR_MOBILE = "AADHAAR_MOBILE";

    private static final String COL_AADHAAR_NAME = "AADHAAR_NAME";

    private static final String COL_AADHAAR_ADDRESS = "AADHAAR_ADDRESS";

    private static final String COL_AADHAAR_GENDER = "AADHAAR_GENDER";

    private static final String COL_PRODUCT_REQ_ACCOUNT_REF = "PRODUCT_REQ_ACCOUNT_REF";

    private static final String COL_CURRENT_TXN_ID = "CURRENT_TXN_ID";

    private static final String COL_PAN_NUMBER = "PAN_NUMBER";

    private static final String COL_RESEND_ATTEMPT_LOCK_EXP_TIME = "RESEND_ATTEMPT_LOCK_EXP_TIME";

    private static final String COL_SUBMIT_OTP_COUNT = "SUBMIT_OTP_COUNT";

    private static final String COL_VALIDATE_OTP_GENERATE_TIME = "VALIDATE_OTP_GENERATE_TIME";

    private static final String COL_AADHAAR_DOB = "AADHAAR_DOB";

    private static final String COL_EKYC_LINK_STATUS = "EKYC_LINK_STATUS";

    private static final String COL_HOME_BRANCH = "HOME_BRANCH";

    private static final String COL_PARENT_ACCOUNT_NO = "PARENT_ACCOUNT_NO";

    private static final String COL_ACCOUNT_TYPE = "ACCOUNT_TYPE";

    private static final String COL_NEW_USER_CRN = "NEW_USER_CRN";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_ACCOUNT_LINK_STATUS = "ACCOUNT_LINK_STATUS";

    private static final String COL_REGEN_LINK_COUNT = "REGEN_LINK_COUNT";

    private static final String COL_OPS_USER_ID = "OPS_USER_ID";

    private static final String COL_ANNUAL_INCOME_SLAB = "ANNUAL_INCOME_SLAB";

    private static final String COL_ANNUAL_INCOME = "ANNUAL_INCOME";

    private static final String COL_EMAIL_LINK_OTP_COUNT = "EMAIL_LINK_OTP_COUNT";

    private static final String COL_AADHAAR_UID = "AADHAAR_UID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CLIENT_CRN_REF, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_MOBILE, COL_FATHER_NAME, COL_MOTHER_MAIDEN_NAME, COL_OCCUPATION, COL_GENDER, COL_MARITAL_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID, COL_USER_NAME, COL_ENTITY_CUSTOMER_CRN, COL_ENTITY_APPLICANT_USER_CRN, COL_AADHAAR_OPTION, COL_APPLICANT_PARTY_CODE, COL_EXPIRES_ON, COL_EKYC_DISPLAY_STATUS, COL_EMAIL_STATUS_CODE, COL_MOBILE_STATUS_CODE, COL_TC_STATUS_CODE, COL_AADHAAR_CONSENT_STATUS_CODE, COL_AADHAAR_VERIFY_STATUS_CODE, COL_AADHAAR_INFO_STATUS_CODE, COL_PAN_LINK_STATUS_CODE, COL_PAN_NAME_STATUS_CODE, COL_PAN_VERIFY_STATUS_CODE, COL_PERSONAL_INFO_STATUS_CODE, COL_AADHAAR_ID_REFERENCE_ENC, COL_AADHAAR_VID_REFERENCE_ENC, COL_AADHAAR_ID_REFERENCE_MASK, COL_AADHAAR_VID_REFERENCE_MASK, COL_PAN_ID_REFERENCE_ENC, COL_CURRENT_STEP_CODE, COL_ISSUING_PARTY_CODE, COL_RESEND_ATTEMPT_CNT, COL_RESEND_LAST_ATTEMPT_ON, COL_AADHAAR_CONSENT_LANG_CODE, COL_AADHAAR_MOBILE, COL_AADHAAR_NAME, COL_AADHAAR_ADDRESS, COL_AADHAAR_GENDER, COL_PRODUCT_REQ_ACCOUNT_REF, COL_CURRENT_TXN_ID, COL_PAN_NUMBER, COL_RESEND_ATTEMPT_LOCK_EXP_TIME, COL_SUBMIT_OTP_COUNT, COL_VALIDATE_OTP_GENERATE_TIME, COL_AADHAAR_DOB, COL_EKYC_LINK_STATUS, COL_HOME_BRANCH, COL_PARENT_ACCOUNT_NO, COL_ACCOUNT_TYPE, COL_NEW_USER_CRN, COL_REMARKS, COL_ACCOUNT_LINK_STATUS, COL_REGEN_LINK_COUNT, COL_OPS_USER_ID, COL_ANNUAL_INCOME_SLAB, COL_ANNUAL_INCOME, COL_EMAIL_LINK_OTP_COUNT, COL_AADHAAR_UID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CRN_REF, FIRST_NAME, LAST_NAME, EMAIL, MOBILE, FATHER_NAME, MOTHER_MAIDEN_NAME, OCCUPATION, GENDER, MARITAL_STATUS, VERSION_ID, IS_MASTER_VERSION, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, USER_NAME, ENTITY_CUSTOMER_CRN, ENTITY_APPLICANT_USER_CRN, AADHAAR_OPTION, APPLICANT_PARTY_CODE, EXPIRES_ON, EKYC_DISPLAY_STATUS, EMAIL_STATUS_CODE, MOBILE_STATUS_CODE, TC_STATUS_CODE, AADHAAR_CONSENT_STATUS_CODE, AADHAAR_VERIFY_STATUS_CODE, AADHAAR_INFO_STATUS_CODE, PAN_LINK_STATUS_CODE, PAN_NAME_STATUS_CODE, PAN_VERIFY_STATUS_CODE, PERSONAL_INFO_STATUS_CODE, AADHAAR_ID_REFERENCE_ENC, AADHAAR_VID_REFERENCE_ENC, AADHAAR_ID_REFERENCE_MASK, AADHAAR_VID_REFERENCE_MASK, PAN_ID_REFERENCE_ENC, CURRENT_STEP_CODE, ISSUING_PARTY_CODE, RESEND_ATTEMPT_CNT, RESEND_LAST_ATTEMPT_ON, AADHAAR_CONSENT_LANG_CODE, AADHAAR_MOBILE, AADHAAR_NAME, AADHAAR_ADDRESS, AADHAAR_GENDER, PRODUCT_REQ_ACCOUNT_REF, CURRENT_TXN_ID, PAN_NUMBER, RESEND_ATTEMPT_LOCK_EXP_TIME, SUBMIT_OTP_COUNT, VALIDATE_OTP_GENERATE_TIME, AADHAAR_DOB, EKYC_LINK_STATUS, HOME_BRANCH, PARENT_ACCOUNT_NO, ACCOUNT_TYPE, NEW_USER_CRN, REMARKS, ACCOUNT_LINK_STATUS, REGEN_LINK_COUNT, OPS_USER_ID, ANNUAL_INCOME_SLAB, ANNUAL_INCOME, EMAIL_LINK_OTP_COUNT, AADHAAR_UID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CRN_REF, FIRST_NAME, LAST_NAME, EMAIL, MOBILE, FATHER_NAME, MOTHER_MAIDEN_NAME, OCCUPATION, GENDER, MARITAL_STATUS, VERSION_ID, IS_MASTER_VERSION, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, USER_NAME, ENTITY_CUSTOMER_CRN, ENTITY_APPLICANT_USER_CRN, AADHAAR_OPTION, APPLICANT_PARTY_CODE, EXPIRES_ON, EKYC_DISPLAY_STATUS, EMAIL_STATUS_CODE, MOBILE_STATUS_CODE, TC_STATUS_CODE, AADHAAR_CONSENT_STATUS_CODE, AADHAAR_VERIFY_STATUS_CODE, AADHAAR_INFO_STATUS_CODE, PAN_LINK_STATUS_CODE, PAN_NAME_STATUS_CODE, PAN_VERIFY_STATUS_CODE, PERSONAL_INFO_STATUS_CODE, AADHAAR_ID_REFERENCE_ENC, AADHAAR_VID_REFERENCE_ENC, AADHAAR_ID_REFERENCE_MASK, AADHAAR_VID_REFERENCE_MASK, PAN_ID_REFERENCE_ENC, CURRENT_STEP_CODE, ISSUING_PARTY_CODE, RESEND_ATTEMPT_CNT, RESEND_LAST_ATTEMPT_ON, AADHAAR_CONSENT_LANG_CODE, AADHAAR_MOBILE, AADHAAR_NAME, AADHAAR_ADDRESS, AADHAAR_GENDER, PRODUCT_REQ_ACCOUNT_REF, CURRENT_TXN_ID, PAN_NUMBER, RESEND_ATTEMPT_LOCK_EXP_TIME, SUBMIT_OTP_COUNT, VALIDATE_OTP_GENERATE_TIME, AADHAAR_DOB, EKYC_LINK_STATUS, HOME_BRANCH, PARENT_ACCOUNT_NO, ACCOUNT_TYPE, NEW_USER_CRN, REMARKS, ACCOUNT_LINK_STATUS, REGEN_LINK_COUNT, OPS_USER_ID, ANNUAL_INCOME_SLAB, ANNUAL_INCOME, EMAIL_LINK_OTP_COUNT, AADHAAR_UID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CLIENT_CRN_REF, COL_FIRST_NAME, COL_LAST_NAME, COL_EMAIL, COL_MOBILE, COL_FATHER_NAME, COL_MOTHER_MAIDEN_NAME, COL_OCCUPATION, COL_GENDER, COL_MARITAL_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID, COL_USER_NAME, COL_ENTITY_CUSTOMER_CRN, COL_ENTITY_APPLICANT_USER_CRN, COL_AADHAAR_OPTION, COL_APPLICANT_PARTY_CODE, COL_EXPIRES_ON, COL_EKYC_DISPLAY_STATUS, COL_EMAIL_STATUS_CODE, COL_MOBILE_STATUS_CODE, COL_TC_STATUS_CODE, COL_AADHAAR_CONSENT_STATUS_CODE, COL_AADHAAR_VERIFY_STATUS_CODE, COL_AADHAAR_INFO_STATUS_CODE, COL_PAN_LINK_STATUS_CODE, COL_PAN_NAME_STATUS_CODE, COL_PAN_VERIFY_STATUS_CODE, COL_PERSONAL_INFO_STATUS_CODE, COL_AADHAAR_ID_REFERENCE_ENC, COL_AADHAAR_VID_REFERENCE_ENC, COL_AADHAAR_ID_REFERENCE_MASK, COL_AADHAAR_VID_REFERENCE_MASK, COL_PAN_ID_REFERENCE_ENC, COL_CURRENT_STEP_CODE, COL_ISSUING_PARTY_CODE, COL_RESEND_ATTEMPT_CNT, COL_RESEND_LAST_ATTEMPT_ON, COL_AADHAAR_CONSENT_LANG_CODE, COL_AADHAAR_MOBILE, COL_AADHAAR_NAME, COL_AADHAAR_ADDRESS, COL_AADHAAR_GENDER, COL_PRODUCT_REQ_ACCOUNT_REF, COL_CURRENT_TXN_ID, COL_PAN_NUMBER, COL_RESEND_ATTEMPT_LOCK_EXP_TIME, COL_SUBMIT_OTP_COUNT, COL_VALIDATE_OTP_GENERATE_TIME, COL_AADHAAR_DOB, COL_EKYC_LINK_STATUS, COL_HOME_BRANCH, COL_PARENT_ACCOUNT_NO, COL_ACCOUNT_TYPE, COL_NEW_USER_CRN, COL_REMARKS, COL_ACCOUNT_LINK_STATUS, COL_REGEN_LINK_COUNT, COL_OPS_USER_ID, COL_ANNUAL_INCOME_SLAB, COL_ANNUAL_INCOME, COL_EMAIL_LINK_OTP_COUNT, COL_AADHAAR_UID, COL_ID);

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

    public int insert(Connection conn, FgEkycReq fgekycreq) throws SQLException {
        logger.debug("Inserting fgekycreq: {}", fgekycreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEkycReqParams(ps, fgekycreq);
            ps.executeUpdate();
            return fgekycreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEkycReq> fgekycreqs) throws SQLException {
        if (fgekycreqs == null || fgekycreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgekycreqs.size(); i++) {
            if (fgekycreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEkycReq>> batches = chunkList(fgekycreqs, batchSize);
        int[] totalResults = new int[fgekycreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEkycReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEkycReq fgekycreq : batch) {
                        setFgEkycReqParams(ps, fgekycreq);
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

    public FgEkycReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEkycReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEkycReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEkycReq fgekycreq) throws SQLException {
        if (fgekycreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEkycReqParams(ps, fgekycreq);
            ps.setInt(81, fgekycreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEkycReq> fgekycreqs) throws SQLException {
        if (fgekycreqs == null || fgekycreqs.isEmpty())
            return new int[0];
        for (FgEkycReq fgekycreq : fgekycreqs) {
            if (fgekycreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgekycreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEkycReq>> batches = chunkList(fgekycreqs, batchSize);
        int[] totalResults = new int[fgekycreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEkycReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEkycReq fgekycreq : batch) {
                        setFgEkycReqParams(ps, fgekycreq);
                        ps.setInt(81, fgekycreq.getID());
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

    private void setFgEkycReqParams(PreparedStatement ps, FgEkycReq fgekycreq) throws SQLException {
        Integer val1 = fgekycreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgekycreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgekycreq.getTypeCode());
        ps.setString(4, fgekycreq.getSubTypeCode());
        ps.setString(5, fgekycreq.getActiveCode());
        ps.setString(6, fgekycreq.getStageCode());
        ps.setString(7, fgekycreq.getStatusCode());
        ps.setString(8, fgekycreq.getCreatedOn());
        java.math.BigDecimal val9 = fgekycreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgekycreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgekycreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgekycreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgekycreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgekycreq.getTemplate());
        java.math.BigDecimal val15 = fgekycreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgekycreq.getClientCrnRef());
        ps.setString(17, fgekycreq.getFirstName());
        ps.setString(18, fgekycreq.getLastName());
        ps.setString(19, fgekycreq.getEmail());
        ps.setString(20, fgekycreq.getMobile());
        ps.setString(21, fgekycreq.getFatherName());
        ps.setString(22, fgekycreq.getMotherMaidenName());
        ps.setString(23, fgekycreq.getOccupation());
        ps.setString(24, fgekycreq.getGender());
        ps.setString(25, fgekycreq.getMaritalStatus());
        Integer val26 = fgekycreq.getVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        java.math.BigDecimal val27 = fgekycreq.getIsMasterVersion();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgekycreq.getEntityTypeCode());
        ps.setString(29, fgekycreq.getEntitySubTypeCode());
        Integer val30 = fgekycreq.getEntityReferenceID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        ps.setString(31, fgekycreq.getUserName());
        ps.setString(32, fgekycreq.getEntityCustomerCrn());
        ps.setString(33, fgekycreq.getEntityApplicantUserCrn());
        ps.setString(34, fgekycreq.getAadhaarOption());
        ps.setString(35, fgekycreq.getApplicantPartyCode());
        ps.setString(36, fgekycreq.getExpiresOn());
        ps.setString(37, fgekycreq.getEkycDisplayStatus());
        ps.setString(38, fgekycreq.getEmailStatusCode());
        ps.setString(39, fgekycreq.getMobileStatusCode());
        ps.setString(40, fgekycreq.getTcStatusCode());
        ps.setString(41, fgekycreq.getAadhaarConsentStatusCode());
        ps.setString(42, fgekycreq.getAadhaarVerifyStatusCode());
        ps.setString(43, fgekycreq.getAadhaarInfoStatusCode());
        ps.setString(44, fgekycreq.getPanLinkStatusCode());
        ps.setString(45, fgekycreq.getPanNameStatusCode());
        ps.setString(46, fgekycreq.getPanVerifyStatusCode());
        ps.setString(47, fgekycreq.getPersonalInfoStatusCode());
        ps.setString(48, fgekycreq.getAadhaarIDReferenceEnc());
        ps.setString(49, fgekycreq.getAadhaarVidReferenceEnc());
        ps.setString(50, fgekycreq.getAadhaarIDReferenceMask());
        ps.setString(51, fgekycreq.getAadhaarVidReferenceMask());
        ps.setString(52, fgekycreq.getPanIDReferenceEnc());
        ps.setString(53, fgekycreq.getCurrentStepCode());
        ps.setString(54, fgekycreq.getIssuingPartyCode());
        java.math.BigDecimal val55 = fgekycreq.getResendAttemptCnt();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, fgekycreq.getResendLastAttemptOn());
        ps.setString(57, fgekycreq.getAadhaarConsentLangCode());
        ps.setString(58, fgekycreq.getAadhaarMobile());
        ps.setString(59, fgekycreq.getAadhaarName());
        ps.setString(60, fgekycreq.getAadhaarAddress());
        ps.setString(61, fgekycreq.getAadhaarGender());
        ps.setString(62, fgekycreq.getProductReqAccountRef());
        Integer val63 = fgekycreq.getCurrentTxnID();
        if (val63 != null) {
            ps.setInt(63, val63);
        } else {
            ps.setNull(63, Types.INTEGER);
        }
        ps.setString(64, fgekycreq.getPanNumber());
        ps.setString(65, fgekycreq.getResendAttemptLockExpTime());
        java.math.BigDecimal val66 = fgekycreq.getSubmitOtpCount();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        ps.setString(67, fgekycreq.getValidateOtpGenerateTime());
        ps.setString(68, fgekycreq.getAadhaarDob());
        ps.setString(69, fgekycreq.getEkycLinkStatus());
        ps.setString(70, fgekycreq.getHomeBranch());
        ps.setString(71, fgekycreq.getParentAccountNo());
        ps.setString(72, fgekycreq.getAccountType());
        ps.setString(73, fgekycreq.getNewUserCrn());
        ps.setString(74, fgekycreq.getRemarks());
        ps.setString(75, fgekycreq.getAccountLinkStatus());
        java.math.BigDecimal val76 = fgekycreq.getRegenLinkCount();
        if (val76 != null) {
            ps.setBigDecimal(76, val76);
        } else {
            ps.setNull(76, Types.DECIMAL);
        }
        Integer val77 = fgekycreq.getOpsUserID();
        if (val77 != null) {
            ps.setInt(77, val77);
        } else {
            ps.setNull(77, Types.INTEGER);
        }
        ps.setString(78, fgekycreq.getAnnualIncomeSlab());
        ps.setString(79, fgekycreq.getAnnualIncome());
        java.math.BigDecimal val80 = fgekycreq.getEmailLinkOtpCount();
        if (val80 != null) {
            ps.setBigDecimal(80, val80);
        } else {
            ps.setNull(80, Types.DECIMAL);
        }
        ps.setString(81, fgekycreq.getAadhaarUid());
    }

    private FgEkycReq extract(ResultSet rs) throws SQLException {
        FgEkycReq fgekycreq = new FgEkycReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgekycreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgekycreq.setReferenceID(REFERENCE_ID);
        fgekycreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgekycreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgekycreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgekycreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgekycreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgekycreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgekycreq.setCreatedBy(CREATED_BY);
        fgekycreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgekycreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgekycreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgekycreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgekycreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgekycreq.setIsTemplate(IS_TEMPLATE);
        fgekycreq.setClientCrnRef(rs.getString(COL_CLIENT_CRN_REF));
        fgekycreq.setFirstName(rs.getString(COL_FIRST_NAME));
        fgekycreq.setLastName(rs.getString(COL_LAST_NAME));
        fgekycreq.setEmail(rs.getString(COL_EMAIL));
        fgekycreq.setMobile(rs.getString(COL_MOBILE));
        fgekycreq.setFatherName(rs.getString(COL_FATHER_NAME));
        fgekycreq.setMotherMaidenName(rs.getString(COL_MOTHER_MAIDEN_NAME));
        fgekycreq.setOccupation(rs.getString(COL_OCCUPATION));
        fgekycreq.setGender(rs.getString(COL_GENDER));
        fgekycreq.setMaritalStatus(rs.getString(COL_MARITAL_STATUS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgekycreq.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgekycreq.setIsMasterVersion(IS_MASTER_VERSION);
        fgekycreq.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgekycreq.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ENTITY_REFERENCE_ID = rs.getObject(COL_ENTITY_REFERENCE_ID, Integer.class);
        fgekycreq.setEntityReferenceID(ENTITY_REFERENCE_ID);
        fgekycreq.setUserName(rs.getString(COL_USER_NAME));
        fgekycreq.setEntityCustomerCrn(rs.getString(COL_ENTITY_CUSTOMER_CRN));
        fgekycreq.setEntityApplicantUserCrn(rs.getString(COL_ENTITY_APPLICANT_USER_CRN));
        fgekycreq.setAadhaarOption(rs.getString(COL_AADHAAR_OPTION));
        fgekycreq.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgekycreq.setExpiresOn(rs.getString(COL_EXPIRES_ON));
        fgekycreq.setEkycDisplayStatus(rs.getString(COL_EKYC_DISPLAY_STATUS));
        fgekycreq.setEmailStatusCode(rs.getString(COL_EMAIL_STATUS_CODE));
        fgekycreq.setMobileStatusCode(rs.getString(COL_MOBILE_STATUS_CODE));
        fgekycreq.setTcStatusCode(rs.getString(COL_TC_STATUS_CODE));
        fgekycreq.setAadhaarConsentStatusCode(rs.getString(COL_AADHAAR_CONSENT_STATUS_CODE));
        fgekycreq.setAadhaarVerifyStatusCode(rs.getString(COL_AADHAAR_VERIFY_STATUS_CODE));
        fgekycreq.setAadhaarInfoStatusCode(rs.getString(COL_AADHAAR_INFO_STATUS_CODE));
        fgekycreq.setPanLinkStatusCode(rs.getString(COL_PAN_LINK_STATUS_CODE));
        fgekycreq.setPanNameStatusCode(rs.getString(COL_PAN_NAME_STATUS_CODE));
        fgekycreq.setPanVerifyStatusCode(rs.getString(COL_PAN_VERIFY_STATUS_CODE));
        fgekycreq.setPersonalInfoStatusCode(rs.getString(COL_PERSONAL_INFO_STATUS_CODE));
        fgekycreq.setAadhaarIDReferenceEnc(rs.getString(COL_AADHAAR_ID_REFERENCE_ENC));
        fgekycreq.setAadhaarVidReferenceEnc(rs.getString(COL_AADHAAR_VID_REFERENCE_ENC));
        fgekycreq.setAadhaarIDReferenceMask(rs.getString(COL_AADHAAR_ID_REFERENCE_MASK));
        fgekycreq.setAadhaarVidReferenceMask(rs.getString(COL_AADHAAR_VID_REFERENCE_MASK));
        fgekycreq.setPanIDReferenceEnc(rs.getString(COL_PAN_ID_REFERENCE_ENC));
        fgekycreq.setCurrentStepCode(rs.getString(COL_CURRENT_STEP_CODE));
        fgekycreq.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal RESEND_ATTEMPT_CNT = rs.getObject(COL_RESEND_ATTEMPT_CNT, java.math.BigDecimal.class);
        fgekycreq.setResendAttemptCnt(RESEND_ATTEMPT_CNT);
        fgekycreq.setResendLastAttemptOn(rs.getString(COL_RESEND_LAST_ATTEMPT_ON));
        fgekycreq.setAadhaarConsentLangCode(rs.getString(COL_AADHAAR_CONSENT_LANG_CODE));
        fgekycreq.setAadhaarMobile(rs.getString(COL_AADHAAR_MOBILE));
        fgekycreq.setAadhaarName(rs.getString(COL_AADHAAR_NAME));
        fgekycreq.setAadhaarAddress(rs.getString(COL_AADHAAR_ADDRESS));
        fgekycreq.setAadhaarGender(rs.getString(COL_AADHAAR_GENDER));
        fgekycreq.setProductReqAccountRef(rs.getString(COL_PRODUCT_REQ_ACCOUNT_REF));
        Integer CURRENT_TXN_ID = rs.getObject(COL_CURRENT_TXN_ID, Integer.class);
        fgekycreq.setCurrentTxnID(CURRENT_TXN_ID);
        fgekycreq.setPanNumber(rs.getString(COL_PAN_NUMBER));
        fgekycreq.setResendAttemptLockExpTime(rs.getString(COL_RESEND_ATTEMPT_LOCK_EXP_TIME));
        java.math.BigDecimal SUBMIT_OTP_COUNT = rs.getObject(COL_SUBMIT_OTP_COUNT, java.math.BigDecimal.class);
        fgekycreq.setSubmitOtpCount(SUBMIT_OTP_COUNT);
        fgekycreq.setValidateOtpGenerateTime(rs.getString(COL_VALIDATE_OTP_GENERATE_TIME));
        fgekycreq.setAadhaarDob(rs.getString(COL_AADHAAR_DOB));
        fgekycreq.setEkycLinkStatus(rs.getString(COL_EKYC_LINK_STATUS));
        fgekycreq.setHomeBranch(rs.getString(COL_HOME_BRANCH));
        fgekycreq.setParentAccountNo(rs.getString(COL_PARENT_ACCOUNT_NO));
        fgekycreq.setAccountType(rs.getString(COL_ACCOUNT_TYPE));
        fgekycreq.setNewUserCrn(rs.getString(COL_NEW_USER_CRN));
        fgekycreq.setRemarks(rs.getString(COL_REMARKS));
        fgekycreq.setAccountLinkStatus(rs.getString(COL_ACCOUNT_LINK_STATUS));
        java.math.BigDecimal REGEN_LINK_COUNT = rs.getObject(COL_REGEN_LINK_COUNT, java.math.BigDecimal.class);
        fgekycreq.setRegenLinkCount(REGEN_LINK_COUNT);
        Integer OPS_USER_ID = rs.getObject(COL_OPS_USER_ID, Integer.class);
        fgekycreq.setOpsUserID(OPS_USER_ID);
        fgekycreq.setAnnualIncomeSlab(rs.getString(COL_ANNUAL_INCOME_SLAB));
        fgekycreq.setAnnualIncome(rs.getString(COL_ANNUAL_INCOME));
        java.math.BigDecimal EMAIL_LINK_OTP_COUNT = rs.getObject(COL_EMAIL_LINK_OTP_COUNT, java.math.BigDecimal.class);
        fgekycreq.setEmailLinkOtpCount(EMAIL_LINK_OTP_COUNT);
        fgekycreq.setAadhaarUid(rs.getString(COL_AADHAAR_UID));
        return fgekycreq;
    }
}
