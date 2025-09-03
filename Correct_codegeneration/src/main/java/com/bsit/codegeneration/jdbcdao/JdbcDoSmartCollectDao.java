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

public class JdbcDoSmartCollectDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDoSmartCollectDao.class);

    private static final String TABLE = "DO_SMART_COLLECT";

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

    private static final String COL_APPLICANT_USER_CRN = "APPLICANT_USER_CRN";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_COMPANY_NAME = "COMPANY_NAME";

    private static final String COL_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static final String COL_MAILING_ADDRESS = "MAILING_ADDRESS";

    private static final String COL_CONTACT_PERSON = "CONTACT_PERSON";

    private static final String COL_CONTACT_MOBILE_NUMBER = "CONTACT_MOBILE_NUMBER";

    private static final String COL_APPLICATION_REFERENCE = "APPLICATION_REFERENCE";

    private static final String COL_REPORTING_FREQUENCY = "REPORTING_FREQUENCY";

    private static final String COL_PRODUCT_NAME = "PRODUCT_NAME";

    private static final String COL_PRODUCT_DISPLAY_STATUS = "PRODUCT_DISPLAY_STATUS";

    private static final String COL_TAT_START_TIME = "TAT_START_TIME";

    private static final String COL_TAT_END_TIME = "TAT_END_TIME";

    private static final String COL_EXISTING_USER_NAME = "EXISTING_USER_NAME";

    private static final String COL_USER_EMAIL = "USER_EMAIL";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_CUSTOMER_TYPE_DESC = "CUSTOMER_TYPE_DESC";

    private static final String COL_APPLICANT_USER_NAME = "APPLICANT_USER_NAME";

    private static final String COL_MAKER_COMMENTS = "MAKER_COMMENTS";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_COMPANY_CRN = "COMPANY_CRN";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_USER_CRN, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_COMPANY_NAME, COL_ACCOUNT_NUMBER, COL_MAILING_ADDRESS, COL_CONTACT_PERSON, COL_CONTACT_MOBILE_NUMBER, COL_APPLICATION_REFERENCE, COL_REPORTING_FREQUENCY, COL_PRODUCT_NAME, COL_PRODUCT_DISPLAY_STATUS, COL_TAT_START_TIME, COL_TAT_END_TIME, COL_EXISTING_USER_NAME, COL_USER_EMAIL, COL_ISSUING_PARTY_CODE, COL_CUSTOMER_TYPE_DESC, COL_APPLICANT_USER_NAME, COL_MAKER_COMMENTS, COL_TASK_REASON, COL_COMPANY_CRN);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_USER_CRN, FULFILLMENT_PARTY, IS_TEMPLATE, COMPANY_NAME, ACCOUNT_NUMBER, MAILING_ADDRESS, CONTACT_PERSON, CONTACT_MOBILE_NUMBER, APPLICATION_REFERENCE, REPORTING_FREQUENCY, PRODUCT_NAME, PRODUCT_DISPLAY_STATUS, TAT_START_TIME, TAT_END_TIME, EXISTING_USER_NAME, USER_EMAIL, ISSUING_PARTY_CODE, CUSTOMER_TYPE_DESC, APPLICANT_USER_NAME, MAKER_COMMENTS, TASK_REASON, COMPANY_CRN", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_USER_CRN, FULFILLMENT_PARTY, IS_TEMPLATE, COMPANY_NAME, ACCOUNT_NUMBER, MAILING_ADDRESS, CONTACT_PERSON, CONTACT_MOBILE_NUMBER, APPLICATION_REFERENCE, REPORTING_FREQUENCY, PRODUCT_NAME, PRODUCT_DISPLAY_STATUS, TAT_START_TIME, TAT_END_TIME, EXISTING_USER_NAME, USER_EMAIL, ISSUING_PARTY_CODE, CUSTOMER_TYPE_DESC, APPLICANT_USER_NAME, MAKER_COMMENTS, TASK_REASON, COMPANY_CRN", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_USER_CRN, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_COMPANY_NAME, COL_ACCOUNT_NUMBER, COL_MAILING_ADDRESS, COL_CONTACT_PERSON, COL_CONTACT_MOBILE_NUMBER, COL_APPLICATION_REFERENCE, COL_REPORTING_FREQUENCY, COL_PRODUCT_NAME, COL_PRODUCT_DISPLAY_STATUS, COL_TAT_START_TIME, COL_TAT_END_TIME, COL_EXISTING_USER_NAME, COL_USER_EMAIL, COL_ISSUING_PARTY_CODE, COL_CUSTOMER_TYPE_DESC, COL_APPLICANT_USER_NAME, COL_MAKER_COMMENTS, COL_TASK_REASON, COL_COMPANY_CRN, COL_ID);

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

    public int insert(Connection conn, DoSmartCollect dosmartcollect) throws SQLException {
        logger.debug("Inserting dosmartcollect: {}", dosmartcollect);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setDoSmartCollectParams(ps, dosmartcollect);
            ps.executeUpdate();
            return dosmartcollect.getID();
        }
    }

    public int[] insertAll(Connection conn, List<DoSmartCollect> dosmartcollects) throws SQLException {
        if (dosmartcollects == null || dosmartcollects.isEmpty())
            return new int[0];
        for (int i = 0; i < dosmartcollects.size(); i++) {
            if (dosmartcollects.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<DoSmartCollect>> batches = chunkList(dosmartcollects, batchSize);
        int[] totalResults = new int[dosmartcollects.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<DoSmartCollect> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (DoSmartCollect dosmartcollect : batch) {
                        setDoSmartCollectParams(ps, dosmartcollect);
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

    public DoSmartCollect findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<DoSmartCollect> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<DoSmartCollect> list = new ArrayList<>();
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

    public boolean update(Connection conn, DoSmartCollect dosmartcollect) throws SQLException {
        if (dosmartcollect.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setDoSmartCollectParams(ps, dosmartcollect);
            ps.setInt(37, dosmartcollect.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<DoSmartCollect> dosmartcollects) throws SQLException {
        if (dosmartcollects == null || dosmartcollects.isEmpty())
            return new int[0];
        for (DoSmartCollect dosmartcollect : dosmartcollects) {
            if (dosmartcollect == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (dosmartcollect.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<DoSmartCollect>> batches = chunkList(dosmartcollects, batchSize);
        int[] totalResults = new int[dosmartcollects.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<DoSmartCollect> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (DoSmartCollect dosmartcollect : batch) {
                        setDoSmartCollectParams(ps, dosmartcollect);
                        ps.setInt(37, dosmartcollect.getID());
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

    private void setDoSmartCollectParams(PreparedStatement ps, DoSmartCollect dosmartcollect) throws SQLException {
        Integer val1 = dosmartcollect.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = dosmartcollect.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, dosmartcollect.getTypeCode());
        ps.setString(4, dosmartcollect.getSubTypeCode());
        ps.setString(5, dosmartcollect.getActiveCode());
        ps.setString(6, dosmartcollect.getStageCode());
        ps.setString(7, dosmartcollect.getStatusCode());
        Integer val8 = dosmartcollect.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, dosmartcollect.getCreatedOn());
        java.math.BigDecimal val10 = dosmartcollect.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, dosmartcollect.getLastUpdatedOn());
        java.math.BigDecimal val12 = dosmartcollect.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, dosmartcollect.getLastAuthorisedOn());
        java.math.BigDecimal val14 = dosmartcollect.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, dosmartcollect.getTemplate());
        ps.setString(16, dosmartcollect.getApplicantUserCrn());
        ps.setString(17, dosmartcollect.getFulfillmentParty());
        java.math.BigDecimal val18 = dosmartcollect.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, dosmartcollect.getCompanyName());
        ps.setString(20, dosmartcollect.getAccountNumber());
        ps.setString(21, dosmartcollect.getMailingAddress());
        ps.setString(22, dosmartcollect.getContactPerson());
        java.math.BigDecimal val23 = dosmartcollect.getContactMobileNumber();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, dosmartcollect.getApplicationReference());
        ps.setString(25, dosmartcollect.getReportingFrequency());
        ps.setString(26, dosmartcollect.getProductName());
        ps.setString(27, dosmartcollect.getProductDisplayStatus());
        ps.setString(28, dosmartcollect.getTatStartTime());
        ps.setString(29, dosmartcollect.getTatEndTime());
        ps.setString(30, dosmartcollect.getExistingUserName());
        ps.setString(31, dosmartcollect.getUserEmail());
        ps.setString(32, dosmartcollect.getIssuingPartyCode());
        ps.setString(33, dosmartcollect.getCustomerTypeDesc());
        ps.setString(34, dosmartcollect.getApplicantUserName());
        ps.setString(35, dosmartcollect.getMakerComments());
        ps.setString(36, dosmartcollect.getTaskReason());
        ps.setString(37, dosmartcollect.getCompanyCrn());
    }

    private DoSmartCollect extract(ResultSet rs) throws SQLException {
        DoSmartCollect dosmartcollect = new DoSmartCollect();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        dosmartcollect.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        dosmartcollect.setReferenceID(REFERENCE_ID);
        dosmartcollect.setTypeCode(rs.getString(COL_TYPE_CODE));
        dosmartcollect.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        dosmartcollect.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        dosmartcollect.setStageCode(rs.getString(COL_STAGE_CODE));
        dosmartcollect.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        dosmartcollect.setProcessID(PROCESS_ID);
        dosmartcollect.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        dosmartcollect.setCreatedBy(CREATED_BY);
        dosmartcollect.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        dosmartcollect.setLastUpdatedBy(LAST_UPDATED_BY);
        dosmartcollect.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        dosmartcollect.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        dosmartcollect.setTemplate(rs.getString(COL_TEMPLATE));
        dosmartcollect.setApplicantUserCrn(rs.getString(COL_APPLICANT_USER_CRN));
        dosmartcollect.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        dosmartcollect.setIsTemplate(IS_TEMPLATE);
        dosmartcollect.setCompanyName(rs.getString(COL_COMPANY_NAME));
        dosmartcollect.setAccountNumber(rs.getString(COL_ACCOUNT_NUMBER));
        dosmartcollect.setMailingAddress(rs.getString(COL_MAILING_ADDRESS));
        dosmartcollect.setContactPerson(rs.getString(COL_CONTACT_PERSON));
        java.math.BigDecimal CONTACT_MOBILE_NUMBER = rs.getObject(COL_CONTACT_MOBILE_NUMBER, java.math.BigDecimal.class);
        dosmartcollect.setContactMobileNumber(CONTACT_MOBILE_NUMBER);
        dosmartcollect.setApplicationReference(rs.getString(COL_APPLICATION_REFERENCE));
        dosmartcollect.setReportingFrequency(rs.getString(COL_REPORTING_FREQUENCY));
        dosmartcollect.setProductName(rs.getString(COL_PRODUCT_NAME));
        dosmartcollect.setProductDisplayStatus(rs.getString(COL_PRODUCT_DISPLAY_STATUS));
        dosmartcollect.setTatStartTime(rs.getString(COL_TAT_START_TIME));
        dosmartcollect.setTatEndTime(rs.getString(COL_TAT_END_TIME));
        dosmartcollect.setExistingUserName(rs.getString(COL_EXISTING_USER_NAME));
        dosmartcollect.setUserEmail(rs.getString(COL_USER_EMAIL));
        dosmartcollect.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        dosmartcollect.setCustomerTypeDesc(rs.getString(COL_CUSTOMER_TYPE_DESC));
        dosmartcollect.setApplicantUserName(rs.getString(COL_APPLICANT_USER_NAME));
        dosmartcollect.setMakerComments(rs.getString(COL_MAKER_COMMENTS));
        dosmartcollect.setTaskReason(rs.getString(COL_TASK_REASON));
        dosmartcollect.setCompanyCrn(rs.getString(COL_COMPANY_CRN));
        return dosmartcollect;
    }
}
