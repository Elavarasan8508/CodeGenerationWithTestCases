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

public class JdbcFgProductReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductReqDao.class);

    private static final String TABLE = "FG_PRODUCT_REQ";

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

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_APPLICANT_USER_CRN = "APPLICANT_USER_CRN";

    private static final String COL_APPLICATION_DATE = "APPLICATION_DATE";

    private static final String COL_APPROVAL_DATE = "APPROVAL_DATE";

    private static final String COL_PROCESSED_DATE = "PROCESSED_DATE";

    private static final String COL_USER_ROLE = "USER_ROLE";

    private static final String COL_USER_CRN = "USER_CRN";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_USER_EMAIL = "USER_EMAIL";

    private static final String COL_ADDRESS_LINE_1 = "ADDRESS_LINE_1";

    private static final String COL_ADDRESS_LINE_2 = "ADDRESS_LINE_2";

    private static final String COL_ADDRESS_LINE_3 = "ADDRESS_LINE_3";

    private static final String COL_CUSTOMER_CITY = "CUSTOMER_CITY";

    private static final String COL_CUSTOMER_PINCODE = "CUSTOMER_PINCODE";

    private static final String COL_PRODUCT_CODES = "PRODUCT_CODES";

    private static final String COL_CONTACT_NAME = "CONTACT_NAME";

    private static final String COL_CONTACT_DESIGNATION = "CONTACT_DESIGNATION";

    private static final String COL_CONTACT_EMAIL = "CONTACT_EMAIL";

    private static final String COL_CONTACT_PHONE = "CONTACT_PHONE";

    private static final String COL_CONTACT_MOBILE = "CONTACT_MOBILE";

    private static final String COL_PARENT_ACCOUNT_NO = "PARENT_ACCOUNT_NO";

    private static final String COL_ACCOUNTS = "ACCOUNTS";

    private static final String COL_REPORT_NAME = "REPORT_NAME";

    private static final String COL_REPORT_RECIPIENT_EMAIL = "REPORT_RECIPIENT_EMAIL";

    private static final String COL_APPLICATION_STAGE = "APPLICATION_STAGE";

    private static final String COL_APPLICATION_STATUS = "APPLICATION_STATUS";

    private static final String COL_REJECT_REASON_CODE = "REJECT_REASON_CODE";

    private static final String COL_REJECT_REASON = "REJECT_REASON";

    private static final String COL_NOTIFICATION_ENABLED = "NOTIFICATION_ENABLED";

    private static final String COL_ACC_PROCESSED_DATE = "ACC_PROCESSED_DATE";

    private static final String COL_CUSTOMER_STATE = "CUSTOMER_STATE";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String COL_APPROVAL_STATUS = "APPROVAL_STATUS";

    private static final String COL_APPROVAL_DESCRIPTION = "APPROVAL_DESCRIPTION";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_FULLFILMENT_PARTY = "FULLFILMENT_PARTY";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE = "ACTIVE";

    private static final String COL_CUSTOMER_TYPE = "CUSTOMER_TYPE";

    private static final String COL_FAILURE_REASON = "FAILURE_REASON";

    private static final String COL_PARENT_ACCOUNT_NO1 = "PARENT_ACCOUNT_NO1";

    private static final String COL_APPLICANT_USER_NAME = "APPLICANT_USER_NAME";

    private static final String COL_PROD_NAME_DESC = "PROD_NAME_DESC";

    private static final String COL_CUSTOMER_TYPE_DESC = "CUSTOMER_TYPE_DESC";

    private static final String COL_TASK_ACTION = "TASK_ACTION";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_SIGNATORY_DATE = "SIGNATORY_DATE";

    private static final String COL_SIGNATORY_DESC = "SIGNATORY_DESC";

    private static final String COL_ENRICH_COMMENTS = "ENRICH_COMMENTS";

    private static final String COL_FULLFILMENT_COMMENTS = "FULLFILMENT_COMMENTS";

    private static final String COL_PRODUCT_DISPLAY_STATUS = "PRODUCT_DISPLAY_STATUS";

    private static final String COL_SHOW_AUTH_STEPPER = "SHOW_AUTH_STEPPER";

    private static final String COL_AUTHORISATION_TYPE = "AUTHORISATION_TYPE";

    private static final String COL_MODE_OF_OPERATION = "MODE_OF_OPERATION";

    private static final String COL_SLAB_TYPE = "SLAB_TYPE";

    private static final String COL_TAT_START_TIME = "TAT_START_TIME";

    private static final String COL_TAT_END_TIME = "TAT_END_TIME";

    private static final String COL_USERROLE_TRADE = "USERROLE_TRADE";

    private static final String COL_PARENT_ACCOUNT_NAME = "PARENT_ACCOUNT_NAME";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_PARENT_ACCOUNT_NO_DISPLAY = "PARENT_ACCOUNT_NO_DISPLAY";

    private static final String COL_PARENT_ACCOUNT_NO_ORG = "PARENT_ACCOUNT_NO_ORG";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_APPLICANT_USER_CRN, COL_APPLICATION_DATE, COL_APPROVAL_DATE, COL_PROCESSED_DATE, COL_USER_ROLE, COL_USER_CRN, COL_USER_NAME, COL_USER_EMAIL, COL_ADDRESS_LINE_1, COL_ADDRESS_LINE_2, COL_ADDRESS_LINE_3, COL_CUSTOMER_CITY, COL_CUSTOMER_PINCODE, COL_PRODUCT_CODES, COL_CONTACT_NAME, COL_CONTACT_DESIGNATION, COL_CONTACT_EMAIL, COL_CONTACT_PHONE, COL_CONTACT_MOBILE, COL_PARENT_ACCOUNT_NO, COL_ACCOUNTS, COL_REPORT_NAME, COL_REPORT_RECIPIENT_EMAIL, COL_APPLICATION_STAGE, COL_APPLICATION_STATUS, COL_REJECT_REASON_CODE, COL_REJECT_REASON, COL_NOTIFICATION_ENABLED, COL_ACC_PROCESSED_DATE, COL_CUSTOMER_STATE, COL_CUSTOMER_NAME, COL_APPROVAL_STATUS, COL_APPROVAL_DESCRIPTION, COL_PROCESS_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FULLFILMENT_PARTY, COL_PRODUCT_CODE, COL_NAME, COL_DESCRIPTION, COL_ACTIVE, COL_CUSTOMER_TYPE, COL_FAILURE_REASON, COL_PARENT_ACCOUNT_NO1, COL_APPLICANT_USER_NAME, COL_PROD_NAME_DESC, COL_CUSTOMER_TYPE_DESC, COL_TASK_ACTION, COL_TASK_REASON, COL_SIGNATORY_DATE, COL_SIGNATORY_DESC, COL_ENRICH_COMMENTS, COL_FULLFILMENT_COMMENTS, COL_PRODUCT_DISPLAY_STATUS, COL_SHOW_AUTH_STEPPER, COL_AUTHORISATION_TYPE, COL_MODE_OF_OPERATION, COL_SLAB_TYPE, COL_TAT_START_TIME, COL_TAT_END_TIME, COL_USERROLE_TRADE, COL_PARENT_ACCOUNT_NAME, COL_DISPLAY_STATUS, COL_PARENT_ACCOUNT_NO_DISPLAY, COL_PARENT_ACCOUNT_NO_ORG);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, APPLICANT_USER_CRN, APPLICATION_DATE, APPROVAL_DATE, PROCESSED_DATE, USER_ROLE, USER_CRN, USER_NAME, USER_EMAIL, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CUSTOMER_CITY, CUSTOMER_PINCODE, PRODUCT_CODES, CONTACT_NAME, CONTACT_DESIGNATION, CONTACT_EMAIL, CONTACT_PHONE, CONTACT_MOBILE, PARENT_ACCOUNT_NO, ACCOUNTS, REPORT_NAME, REPORT_RECIPIENT_EMAIL, APPLICATION_STAGE, APPLICATION_STATUS, REJECT_REASON_CODE, REJECT_REASON, NOTIFICATION_ENABLED, ACC_PROCESSED_DATE, CUSTOMER_STATE, CUSTOMER_NAME, APPROVAL_STATUS, APPROVAL_DESCRIPTION, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FULLFILMENT_PARTY, PRODUCT_CODE, NAME, DESCRIPTION, ACTIVE, CUSTOMER_TYPE, FAILURE_REASON, PARENT_ACCOUNT_NO1, APPLICANT_USER_NAME, PROD_NAME_DESC, CUSTOMER_TYPE_DESC, TASK_ACTION, TASK_REASON, SIGNATORY_DATE, SIGNATORY_DESC, ENRICH_COMMENTS, FULLFILMENT_COMMENTS, PRODUCT_DISPLAY_STATUS, SHOW_AUTH_STEPPER, AUTHORISATION_TYPE, MODE_OF_OPERATION, SLAB_TYPE, TAT_START_TIME, TAT_END_TIME, USERROLE_TRADE, PARENT_ACCOUNT_NAME, DISPLAY_STATUS, PARENT_ACCOUNT_NO_DISPLAY, PARENT_ACCOUNT_NO_ORG", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, APPLICANT_USER_CRN, APPLICATION_DATE, APPROVAL_DATE, PROCESSED_DATE, USER_ROLE, USER_CRN, USER_NAME, USER_EMAIL, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CUSTOMER_CITY, CUSTOMER_PINCODE, PRODUCT_CODES, CONTACT_NAME, CONTACT_DESIGNATION, CONTACT_EMAIL, CONTACT_PHONE, CONTACT_MOBILE, PARENT_ACCOUNT_NO, ACCOUNTS, REPORT_NAME, REPORT_RECIPIENT_EMAIL, APPLICATION_STAGE, APPLICATION_STATUS, REJECT_REASON_CODE, REJECT_REASON, NOTIFICATION_ENABLED, ACC_PROCESSED_DATE, CUSTOMER_STATE, CUSTOMER_NAME, APPROVAL_STATUS, APPROVAL_DESCRIPTION, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FULLFILMENT_PARTY, PRODUCT_CODE, NAME, DESCRIPTION, ACTIVE, CUSTOMER_TYPE, FAILURE_REASON, PARENT_ACCOUNT_NO1, APPLICANT_USER_NAME, PROD_NAME_DESC, CUSTOMER_TYPE_DESC, TASK_ACTION, TASK_REASON, SIGNATORY_DATE, SIGNATORY_DESC, ENRICH_COMMENTS, FULLFILMENT_COMMENTS, PRODUCT_DISPLAY_STATUS, SHOW_AUTH_STEPPER, AUTHORISATION_TYPE, MODE_OF_OPERATION, SLAB_TYPE, TAT_START_TIME, TAT_END_TIME, USERROLE_TRADE, PARENT_ACCOUNT_NAME, DISPLAY_STATUS, PARENT_ACCOUNT_NO_DISPLAY, PARENT_ACCOUNT_NO_ORG", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_APPLICANT_USER_CRN, COL_APPLICATION_DATE, COL_APPROVAL_DATE, COL_PROCESSED_DATE, COL_USER_ROLE, COL_USER_CRN, COL_USER_NAME, COL_USER_EMAIL, COL_ADDRESS_LINE_1, COL_ADDRESS_LINE_2, COL_ADDRESS_LINE_3, COL_CUSTOMER_CITY, COL_CUSTOMER_PINCODE, COL_PRODUCT_CODES, COL_CONTACT_NAME, COL_CONTACT_DESIGNATION, COL_CONTACT_EMAIL, COL_CONTACT_PHONE, COL_CONTACT_MOBILE, COL_PARENT_ACCOUNT_NO, COL_ACCOUNTS, COL_REPORT_NAME, COL_REPORT_RECIPIENT_EMAIL, COL_APPLICATION_STAGE, COL_APPLICATION_STATUS, COL_REJECT_REASON_CODE, COL_REJECT_REASON, COL_NOTIFICATION_ENABLED, COL_ACC_PROCESSED_DATE, COL_CUSTOMER_STATE, COL_CUSTOMER_NAME, COL_APPROVAL_STATUS, COL_APPROVAL_DESCRIPTION, COL_PROCESS_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FULLFILMENT_PARTY, COL_PRODUCT_CODE, COL_NAME, COL_DESCRIPTION, COL_ACTIVE, COL_CUSTOMER_TYPE, COL_FAILURE_REASON, COL_PARENT_ACCOUNT_NO1, COL_APPLICANT_USER_NAME, COL_PROD_NAME_DESC, COL_CUSTOMER_TYPE_DESC, COL_TASK_ACTION, COL_TASK_REASON, COL_SIGNATORY_DATE, COL_SIGNATORY_DESC, COL_ENRICH_COMMENTS, COL_FULLFILMENT_COMMENTS, COL_PRODUCT_DISPLAY_STATUS, COL_SHOW_AUTH_STEPPER, COL_AUTHORISATION_TYPE, COL_MODE_OF_OPERATION, COL_SLAB_TYPE, COL_TAT_START_TIME, COL_TAT_END_TIME, COL_USERROLE_TRADE, COL_PARENT_ACCOUNT_NAME, COL_DISPLAY_STATUS, COL_PARENT_ACCOUNT_NO_DISPLAY, COL_PARENT_ACCOUNT_NO_ORG, COL_ID);

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

    public int insert(Connection conn, FgProductReq fgproductreq) throws SQLException {
        logger.debug("Inserting fgproductreq: {}", fgproductreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductReqParams(ps, fgproductreq);
            ps.executeUpdate();
            return fgproductreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductReq> fgproductreqs) throws SQLException {
        if (fgproductreqs == null || fgproductreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductreqs.size(); i++) {
            if (fgproductreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductReq>> batches = chunkList(fgproductreqs, batchSize);
        int[] totalResults = new int[fgproductreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductReq fgproductreq : batch) {
                        setFgProductReqParams(ps, fgproductreq);
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

    public FgProductReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductReq fgproductreq) throws SQLException {
        if (fgproductreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductReqParams(ps, fgproductreq);
            ps.setInt(83, fgproductreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductReq> fgproductreqs) throws SQLException {
        if (fgproductreqs == null || fgproductreqs.isEmpty())
            return new int[0];
        for (FgProductReq fgproductreq : fgproductreqs) {
            if (fgproductreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductReq>> batches = chunkList(fgproductreqs, batchSize);
        int[] totalResults = new int[fgproductreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductReq fgproductreq : batch) {
                        setFgProductReqParams(ps, fgproductreq);
                        ps.setInt(83, fgproductreq.getID());
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

    private void setFgProductReqParams(PreparedStatement ps, FgProductReq fgproductreq) throws SQLException {
        Integer val1 = fgproductreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproductreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgproductreq.getTypeCode());
        ps.setString(4, fgproductreq.getSubTypeCode());
        ps.setString(5, fgproductreq.getActiveCode());
        ps.setString(6, fgproductreq.getStageCode());
        ps.setString(7, fgproductreq.getStatusCode());
        ps.setString(8, fgproductreq.getCreatedOn());
        java.math.BigDecimal val9 = fgproductreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgproductreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgproductreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgproductreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgproductreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductreq.getTemplate());
        java.math.BigDecimal val15 = fgproductreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgproductreq.getCustomerCrn());
        ps.setString(17, fgproductreq.getApplicantUserCrn());
        java.time.LocalDateTime val18 = fgproductreq.getApplicationDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val19 = fgproductreq.getApprovalDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val20 = fgproductreq.getProcessedDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fgproductreq.getUserRole());
        ps.setString(22, fgproductreq.getUserCrn());
        ps.setString(23, fgproductreq.getUserName());
        ps.setString(24, fgproductreq.getUserEmail());
        ps.setString(25, fgproductreq.getAddressLine1());
        ps.setString(26, fgproductreq.getAddressLine2());
        ps.setString(27, fgproductreq.getAddressLine3());
        ps.setString(28, fgproductreq.getCustomerCity());
        ps.setString(29, fgproductreq.getCustomerPincode());
        ps.setString(30, fgproductreq.getProductCodes());
        ps.setString(31, fgproductreq.getContactName());
        ps.setString(32, fgproductreq.getContactDesignation());
        ps.setString(33, fgproductreq.getContactEmail());
        java.math.BigDecimal val34 = fgproductreq.getContactPhone();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgproductreq.getContactMobile();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgproductreq.getParentAccountNo());
        ps.setString(37, fgproductreq.getAccounts());
        ps.setString(38, fgproductreq.getReportName());
        ps.setString(39, fgproductreq.getReportRecipientEmail());
        ps.setString(40, fgproductreq.getApplicationStage());
        ps.setString(41, fgproductreq.getApplicationStatus());
        ps.setString(42, fgproductreq.getRejectReasonCode());
        ps.setString(43, fgproductreq.getRejectReason());
        ps.setString(44, fgproductreq.getNotificationEnabled());
        java.time.LocalDateTime val45 = fgproductreq.getAccProcessedDate();
        if (val45 != null) {
            ps.setTimestamp(45, java.sql.Timestamp.valueOf(val45));
        } else {
            ps.setNull(45, Types.TIMESTAMP);
        }
        ps.setString(46, fgproductreq.getCustomerState());
        ps.setString(47, fgproductreq.getCustomerName());
        ps.setString(48, fgproductreq.getApprovalStatus());
        ps.setString(49, fgproductreq.getApprovalDescription());
        Integer val50 = fgproductreq.getProcessID();
        if (val50 != null) {
            ps.setInt(50, val50);
        } else {
            ps.setNull(50, Types.INTEGER);
        }
        Integer val51 = fgproductreq.getVersionID();
        if (val51 != null) {
            ps.setInt(51, val51);
        } else {
            ps.setNull(51, Types.INTEGER);
        }
        java.math.BigDecimal val52 = fgproductreq.getIsMasterVersion();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        ps.setString(53, fgproductreq.getApplicantPartyCode());
        ps.setString(54, fgproductreq.getIssuingPartyCode());
        ps.setString(55, fgproductreq.getFullfilmentParty());
        ps.setString(56, fgproductreq.getProductCode());
        ps.setString(57, fgproductreq.getName());
        ps.setString(58, fgproductreq.getDescription());
        Boolean val59 = fgproductreq.getActive();
        if (val59 != null) {
            ps.setBoolean(59, val59);
        } else {
            ps.setNull(59, Types.BOOLEAN);
        }
        ps.setString(60, fgproductreq.getCustomerType());
        ps.setString(61, fgproductreq.getFailureReason());
        ps.setString(62, fgproductreq.getParentAccountNo1());
        ps.setString(63, fgproductreq.getApplicantUserName());
        ps.setString(64, fgproductreq.getProdNameDesc());
        ps.setString(65, fgproductreq.getCustomerTypeDesc());
        ps.setString(66, fgproductreq.getTaskAction());
        ps.setString(67, fgproductreq.getTaskReason());
        java.time.LocalDateTime val68 = fgproductreq.getSignatoryDate();
        if (val68 != null) {
            ps.setTimestamp(68, java.sql.Timestamp.valueOf(val68));
        } else {
            ps.setNull(68, Types.TIMESTAMP);
        }
        ps.setString(69, fgproductreq.getSignatoryDesc());
        ps.setString(70, fgproductreq.getEnrichComments());
        ps.setString(71, fgproductreq.getFullfilmentComments());
        ps.setString(72, fgproductreq.getProductDisplayStatus());
        ps.setString(73, fgproductreq.getShowAuthStepper());
        ps.setString(74, fgproductreq.getAuthorisationType());
        ps.setString(75, fgproductreq.getModeOfOperation());
        ps.setString(76, fgproductreq.getSlabType());
        ps.setString(77, fgproductreq.getTatStartTime());
        ps.setString(78, fgproductreq.getTatEndTime());
        ps.setString(79, fgproductreq.getUserroleTrade());
        ps.setString(80, fgproductreq.getParentAccountName());
        ps.setString(81, fgproductreq.getDisplayStatus());
        ps.setString(82, fgproductreq.getParentAccountNoDisplay());
        ps.setString(83, fgproductreq.getParentAccountNoOrg());
    }

    private FgProductReq extract(ResultSet rs) throws SQLException {
        FgProductReq fgproductreq = new FgProductReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgproductreq.setReferenceID(REFERENCE_ID);
        fgproductreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgproductreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgproductreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductreq.setCreatedBy(CREATED_BY);
        fgproductreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgproductreq.setIsTemplate(IS_TEMPLATE);
        fgproductreq.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        fgproductreq.setApplicantUserCrn(rs.getString(COL_APPLICANT_USER_CRN));
        Timestamp APPLICATION_DATE = rs.getTimestamp(COL_APPLICATION_DATE);
        if (APPLICATION_DATE != null)
            fgproductreq.setApplicationDate(APPLICATION_DATE.toLocalDateTime());
        Timestamp APPROVAL_DATE = rs.getTimestamp(COL_APPROVAL_DATE);
        if (APPROVAL_DATE != null)
            fgproductreq.setApprovalDate(APPROVAL_DATE.toLocalDateTime());
        Timestamp PROCESSED_DATE = rs.getTimestamp(COL_PROCESSED_DATE);
        if (PROCESSED_DATE != null)
            fgproductreq.setProcessedDate(PROCESSED_DATE.toLocalDateTime());
        fgproductreq.setUserRole(rs.getString(COL_USER_ROLE));
        fgproductreq.setUserCrn(rs.getString(COL_USER_CRN));
        fgproductreq.setUserName(rs.getString(COL_USER_NAME));
        fgproductreq.setUserEmail(rs.getString(COL_USER_EMAIL));
        fgproductreq.setAddressLine1(rs.getString(COL_ADDRESS_LINE_1));
        fgproductreq.setAddressLine2(rs.getString(COL_ADDRESS_LINE_2));
        fgproductreq.setAddressLine3(rs.getString(COL_ADDRESS_LINE_3));
        fgproductreq.setCustomerCity(rs.getString(COL_CUSTOMER_CITY));
        fgproductreq.setCustomerPincode(rs.getString(COL_CUSTOMER_PINCODE));
        fgproductreq.setProductCodes(rs.getString(COL_PRODUCT_CODES));
        fgproductreq.setContactName(rs.getString(COL_CONTACT_NAME));
        fgproductreq.setContactDesignation(rs.getString(COL_CONTACT_DESIGNATION));
        fgproductreq.setContactEmail(rs.getString(COL_CONTACT_EMAIL));
        java.math.BigDecimal CONTACT_PHONE = rs.getObject(COL_CONTACT_PHONE, java.math.BigDecimal.class);
        fgproductreq.setContactPhone(CONTACT_PHONE);
        java.math.BigDecimal CONTACT_MOBILE = rs.getObject(COL_CONTACT_MOBILE, java.math.BigDecimal.class);
        fgproductreq.setContactMobile(CONTACT_MOBILE);
        fgproductreq.setParentAccountNo(rs.getString(COL_PARENT_ACCOUNT_NO));
        fgproductreq.setAccounts(rs.getString(COL_ACCOUNTS));
        fgproductreq.setReportName(rs.getString(COL_REPORT_NAME));
        fgproductreq.setReportRecipientEmail(rs.getString(COL_REPORT_RECIPIENT_EMAIL));
        fgproductreq.setApplicationStage(rs.getString(COL_APPLICATION_STAGE));
        fgproductreq.setApplicationStatus(rs.getString(COL_APPLICATION_STATUS));
        fgproductreq.setRejectReasonCode(rs.getString(COL_REJECT_REASON_CODE));
        fgproductreq.setRejectReason(rs.getString(COL_REJECT_REASON));
        fgproductreq.setNotificationEnabled(rs.getString(COL_NOTIFICATION_ENABLED));
        Timestamp ACC_PROCESSED_DATE = rs.getTimestamp(COL_ACC_PROCESSED_DATE);
        if (ACC_PROCESSED_DATE != null)
            fgproductreq.setAccProcessedDate(ACC_PROCESSED_DATE.toLocalDateTime());
        fgproductreq.setCustomerState(rs.getString(COL_CUSTOMER_STATE));
        fgproductreq.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        fgproductreq.setApprovalStatus(rs.getString(COL_APPROVAL_STATUS));
        fgproductreq.setApprovalDescription(rs.getString(COL_APPROVAL_DESCRIPTION));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgproductreq.setProcessID(PROCESS_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgproductreq.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgproductreq.setIsMasterVersion(IS_MASTER_VERSION);
        fgproductreq.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgproductreq.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgproductreq.setFullfilmentParty(rs.getString(COL_FULLFILMENT_PARTY));
        fgproductreq.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgproductreq.setName(rs.getString(COL_NAME));
        fgproductreq.setDescription(rs.getString(COL_DESCRIPTION));
        Boolean ACTIVE = rs.getObject(COL_ACTIVE, Boolean.class);
        fgproductreq.setActive(ACTIVE);
        fgproductreq.setCustomerType(rs.getString(COL_CUSTOMER_TYPE));
        fgproductreq.setFailureReason(rs.getString(COL_FAILURE_REASON));
        fgproductreq.setParentAccountNo1(rs.getString(COL_PARENT_ACCOUNT_NO1));
        fgproductreq.setApplicantUserName(rs.getString(COL_APPLICANT_USER_NAME));
        fgproductreq.setProdNameDesc(rs.getString(COL_PROD_NAME_DESC));
        fgproductreq.setCustomerTypeDesc(rs.getString(COL_CUSTOMER_TYPE_DESC));
        fgproductreq.setTaskAction(rs.getString(COL_TASK_ACTION));
        fgproductreq.setTaskReason(rs.getString(COL_TASK_REASON));
        Timestamp SIGNATORY_DATE = rs.getTimestamp(COL_SIGNATORY_DATE);
        if (SIGNATORY_DATE != null)
            fgproductreq.setSignatoryDate(SIGNATORY_DATE.toLocalDateTime());
        fgproductreq.setSignatoryDesc(rs.getString(COL_SIGNATORY_DESC));
        fgproductreq.setEnrichComments(rs.getString(COL_ENRICH_COMMENTS));
        fgproductreq.setFullfilmentComments(rs.getString(COL_FULLFILMENT_COMMENTS));
        fgproductreq.setProductDisplayStatus(rs.getString(COL_PRODUCT_DISPLAY_STATUS));
        fgproductreq.setShowAuthStepper(rs.getString(COL_SHOW_AUTH_STEPPER));
        fgproductreq.setAuthorisationType(rs.getString(COL_AUTHORISATION_TYPE));
        fgproductreq.setModeOfOperation(rs.getString(COL_MODE_OF_OPERATION));
        fgproductreq.setSlabType(rs.getString(COL_SLAB_TYPE));
        fgproductreq.setTatStartTime(rs.getString(COL_TAT_START_TIME));
        fgproductreq.setTatEndTime(rs.getString(COL_TAT_END_TIME));
        fgproductreq.setUserroleTrade(rs.getString(COL_USERROLE_TRADE));
        fgproductreq.setParentAccountName(rs.getString(COL_PARENT_ACCOUNT_NAME));
        fgproductreq.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        fgproductreq.setParentAccountNoDisplay(rs.getString(COL_PARENT_ACCOUNT_NO_DISPLAY));
        fgproductreq.setParentAccountNoOrg(rs.getString(COL_PARENT_ACCOUNT_NO_ORG));
        return fgproductreq;
    }
}
