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

public class JdbcFgTermDepositReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTermDepositReqDao.class);

    private static final String TABLE = "FG_TERM_DEPOSIT_REQ";

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

    private static final String COL_USER_CRN = "USER_CRN";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_USER_EMAIL = "USER_EMAIL";

    private static final String COL_USER_MOBILE = "USER_MOBILE";

    private static final String COL_DEPOSIT_AMOUNT = "DEPOSIT_AMOUNT";

    private static final String COL_CCY = "CCY";

    private static final String COL_ACCOUNT_NAME = "ACCOUNT_NAME";

    private static final String COL_ACCOUNT_TYPE = "ACCOUNT_TYPE";

    private static final String COL_TENURE_DAYS = "TENURE_DAYS";

    private static final String COL_CUSTOM_TENURE = "CUSTOM_TENURE";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_DEBIT_ACC_NUM = "DEBIT_ACC_NUM";

    private static final String COL_INTEREST_ACCOUNT = "INTEREST_ACCOUNT";

    private static final String COL_PRINCIPAL_ACCOUNT = "PRINCIPAL_ACCOUNT";

    private static final String COL_LIEN_AMOUNT = "LIEN_AMOUNT";

    private static final String COL_LIEN_MARKED = "LIEN_MARKED";

    private static final String COL_ACC_BALANCE = "ACC_BALANCE";

    private static final String COL_PRINCIPAL_AMOUNT = "PRINCIPAL_AMOUNT";

    private static final String COL_MATURITY_AMOUNT = "MATURITY_AMOUNT";

    private static final String COL_INTEREST_AMOUNT = "INTEREST_AMOUNT";

    private static final String COL_INTEREST_PAY_PLAN = "INTEREST_PAY_PLAN";

    private static final String COL_INTEREST_DESCRIPTION = "INTEREST_DESCRIPTION";

    private static final String COL_MATURITY_INSTRUCTION = "MATURITY_INSTRUCTION";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_USER_TYPE = "USER_TYPE";

    private static final String COL_TERMS = "TERMS";

    private static final String COL_IT_TYPE = "IT_TYPE";

    private static final String COL_OTP_COUNT = "OTP_COUNT";

    private static final String COL_OTP_RESENT = "OTP_RESENT";

    private static final String COL_OTP_SENT_TIME = "OTP_SENT_TIME";

    private static final String COL_OTP_LOCKED_TIME = "OTP_LOCKED_TIME";

    private static final String COL_OTP_UNLOCK_TIME = "OTP_UNLOCK_TIME";

    private static final String COL_OTP_FAILED_COUNT = "OTP_FAILED_COUNT";

    private static final String COL_TD_MIN_AMOUNT = "TD_MIN_AMOUNT";

    private static final String COL_TD_MAX_AMOUNT = "TD_MAX_AMOUNT";

    private static final String COL_MAX_BOOKING_LIMIT = "MAX_BOOKING_LIMIT";

    private static final String COL_UTILISED_BOOKING_LIMIT = "UTILISED_BOOKING_LIMIT";

    private static final String COL_AVAILABLE_BOOKING_LIMIT = "AVAILABLE_BOOKING_LIMIT";

    private static final String COL_PENDING_UTILISED_LIMIT = "PENDING_UTILISED_LIMIT";

    private static final String COL_YEAR = "YEAR";

    private static final String COL_MONTH = "MONTH";

    private static final String COL_DAYS = "DAYS";

    private static final String COL_TD_ACCOUNT_NUMBER = "TD_ACCOUNT_NUMBER";

    private static final String COL_FINACLE_STATUS = "FINACLE_STATUS";

    private static final String COL_OPTIONAL_RANGE = "OPTIONAL_RANGE";

    private static final String COL_ORIGIN = "ORIGIN";

    private static final String COL_TD_TYPE = "TD_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_USER_CRN, COL_USER_NAME, COL_USER_EMAIL, COL_USER_MOBILE, COL_DEPOSIT_AMOUNT, COL_CCY, COL_ACCOUNT_NAME, COL_ACCOUNT_TYPE, COL_TENURE_DAYS, COL_CUSTOM_TENURE, COL_INTEREST_RATE, COL_MATURITY_DATE, COL_PRODUCT_STATUS, COL_TASK_REASON, COL_DEBIT_ACC_NUM, COL_INTEREST_ACCOUNT, COL_PRINCIPAL_ACCOUNT, COL_LIEN_AMOUNT, COL_LIEN_MARKED, COL_ACC_BALANCE, COL_PRINCIPAL_AMOUNT, COL_MATURITY_AMOUNT, COL_INTEREST_AMOUNT, COL_INTEREST_PAY_PLAN, COL_INTEREST_DESCRIPTION, COL_MATURITY_INSTRUCTION, COL_SCHEME_CODE, COL_USER_TYPE, COL_TERMS, COL_IT_TYPE, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_OTP_FAILED_COUNT, COL_TD_MIN_AMOUNT, COL_TD_MAX_AMOUNT, COL_MAX_BOOKING_LIMIT, COL_UTILISED_BOOKING_LIMIT, COL_AVAILABLE_BOOKING_LIMIT, COL_PENDING_UTILISED_LIMIT, COL_YEAR, COL_MONTH, COL_DAYS, COL_TD_ACCOUNT_NUMBER, COL_FINACLE_STATUS, COL_OPTIONAL_RANGE, COL_ORIGIN, COL_TD_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, USER_CRN, USER_NAME, USER_EMAIL, USER_MOBILE, DEPOSIT_AMOUNT, CCY, ACCOUNT_NAME, ACCOUNT_TYPE, TENURE_DAYS, CUSTOM_TENURE, INTEREST_RATE, MATURITY_DATE, PRODUCT_STATUS, TASK_REASON, DEBIT_ACC_NUM, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIEN_AMOUNT, LIEN_MARKED, ACC_BALANCE, PRINCIPAL_AMOUNT, MATURITY_AMOUNT, INTEREST_AMOUNT, INTEREST_PAY_PLAN, INTEREST_DESCRIPTION, MATURITY_INSTRUCTION, SCHEME_CODE, USER_TYPE, TERMS, IT_TYPE, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, TD_MIN_AMOUNT, TD_MAX_AMOUNT, MAX_BOOKING_LIMIT, UTILISED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, YEAR, MONTH, DAYS, TD_ACCOUNT_NUMBER, FINACLE_STATUS, OPTIONAL_RANGE, ORIGIN, TD_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, USER_CRN, USER_NAME, USER_EMAIL, USER_MOBILE, DEPOSIT_AMOUNT, CCY, ACCOUNT_NAME, ACCOUNT_TYPE, TENURE_DAYS, CUSTOM_TENURE, INTEREST_RATE, MATURITY_DATE, PRODUCT_STATUS, TASK_REASON, DEBIT_ACC_NUM, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIEN_AMOUNT, LIEN_MARKED, ACC_BALANCE, PRINCIPAL_AMOUNT, MATURITY_AMOUNT, INTEREST_AMOUNT, INTEREST_PAY_PLAN, INTEREST_DESCRIPTION, MATURITY_INSTRUCTION, SCHEME_CODE, USER_TYPE, TERMS, IT_TYPE, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, TD_MIN_AMOUNT, TD_MAX_AMOUNT, MAX_BOOKING_LIMIT, UTILISED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, YEAR, MONTH, DAYS, TD_ACCOUNT_NUMBER, FINACLE_STATUS, OPTIONAL_RANGE, ORIGIN, TD_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_USER_CRN, COL_USER_NAME, COL_USER_EMAIL, COL_USER_MOBILE, COL_DEPOSIT_AMOUNT, COL_CCY, COL_ACCOUNT_NAME, COL_ACCOUNT_TYPE, COL_TENURE_DAYS, COL_CUSTOM_TENURE, COL_INTEREST_RATE, COL_MATURITY_DATE, COL_PRODUCT_STATUS, COL_TASK_REASON, COL_DEBIT_ACC_NUM, COL_INTEREST_ACCOUNT, COL_PRINCIPAL_ACCOUNT, COL_LIEN_AMOUNT, COL_LIEN_MARKED, COL_ACC_BALANCE, COL_PRINCIPAL_AMOUNT, COL_MATURITY_AMOUNT, COL_INTEREST_AMOUNT, COL_INTEREST_PAY_PLAN, COL_INTEREST_DESCRIPTION, COL_MATURITY_INSTRUCTION, COL_SCHEME_CODE, COL_USER_TYPE, COL_TERMS, COL_IT_TYPE, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_OTP_FAILED_COUNT, COL_TD_MIN_AMOUNT, COL_TD_MAX_AMOUNT, COL_MAX_BOOKING_LIMIT, COL_UTILISED_BOOKING_LIMIT, COL_AVAILABLE_BOOKING_LIMIT, COL_PENDING_UTILISED_LIMIT, COL_YEAR, COL_MONTH, COL_DAYS, COL_TD_ACCOUNT_NUMBER, COL_FINACLE_STATUS, COL_OPTIONAL_RANGE, COL_ORIGIN, COL_TD_TYPE, COL_ID);

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

    public int insert(Connection conn, FgTermDepositReq fgtermdepositreq) throws SQLException {
        logger.debug("Inserting fgtermdepositreq: {}", fgtermdepositreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTermDepositReqParams(ps, fgtermdepositreq);
            ps.executeUpdate();
            return fgtermdepositreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTermDepositReq> fgtermdepositreqs) throws SQLException {
        if (fgtermdepositreqs == null || fgtermdepositreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtermdepositreqs.size(); i++) {
            if (fgtermdepositreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTermDepositReq>> batches = chunkList(fgtermdepositreqs, batchSize);
        int[] totalResults = new int[fgtermdepositreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTermDepositReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTermDepositReq fgtermdepositreq : batch) {
                        setFgTermDepositReqParams(ps, fgtermdepositreq);
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

    public FgTermDepositReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTermDepositReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTermDepositReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTermDepositReq fgtermdepositreq) throws SQLException {
        if (fgtermdepositreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTermDepositReqParams(ps, fgtermdepositreq);
            ps.setInt(68, fgtermdepositreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTermDepositReq> fgtermdepositreqs) throws SQLException {
        if (fgtermdepositreqs == null || fgtermdepositreqs.isEmpty())
            return new int[0];
        for (FgTermDepositReq fgtermdepositreq : fgtermdepositreqs) {
            if (fgtermdepositreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtermdepositreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTermDepositReq>> batches = chunkList(fgtermdepositreqs, batchSize);
        int[] totalResults = new int[fgtermdepositreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTermDepositReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTermDepositReq fgtermdepositreq : batch) {
                        setFgTermDepositReqParams(ps, fgtermdepositreq);
                        ps.setInt(68, fgtermdepositreq.getID());
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

    private void setFgTermDepositReqParams(PreparedStatement ps, FgTermDepositReq fgtermdepositreq) throws SQLException {
        Integer val1 = fgtermdepositreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtermdepositreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtermdepositreq.getTypeCode());
        ps.setString(4, fgtermdepositreq.getSubTypeCode());
        ps.setString(5, fgtermdepositreq.getActiveCode());
        ps.setString(6, fgtermdepositreq.getStageCode());
        ps.setString(7, fgtermdepositreq.getStatusCode());
        Integer val8 = fgtermdepositreq.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtermdepositreq.getCreatedOn());
        java.math.BigDecimal val10 = fgtermdepositreq.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtermdepositreq.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtermdepositreq.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtermdepositreq.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtermdepositreq.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtermdepositreq.getTemplate());
        ps.setString(16, fgtermdepositreq.getApplicantParty());
        ps.setString(17, fgtermdepositreq.getFulfillmentParty());
        java.math.BigDecimal val18 = fgtermdepositreq.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtermdepositreq.getUserCrn());
        ps.setString(20, fgtermdepositreq.getUserName());
        ps.setString(21, fgtermdepositreq.getUserEmail());
        ps.setString(22, fgtermdepositreq.getUserMobile());
        java.math.BigDecimal val23 = fgtermdepositreq.getDepositAmount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgtermdepositreq.getCcy());
        ps.setString(25, fgtermdepositreq.getAccountName());
        ps.setString(26, fgtermdepositreq.getAccountType());
        ps.setString(27, fgtermdepositreq.getTenureDays());
        ps.setString(28, fgtermdepositreq.getCustomTenure());
        java.math.BigDecimal val29 = fgtermdepositreq.getInterestRate();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.time.LocalDateTime val30 = fgtermdepositreq.getMaturityDate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        ps.setString(31, fgtermdepositreq.getProductStatus());
        ps.setString(32, fgtermdepositreq.getTaskReason());
        ps.setString(33, fgtermdepositreq.getDebitAccNum());
        ps.setString(34, fgtermdepositreq.getInterestAccount());
        ps.setString(35, fgtermdepositreq.getPrincipalAccount());
        java.math.BigDecimal val36 = fgtermdepositreq.getLienAmount();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = fgtermdepositreq.getLienMarked();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = fgtermdepositreq.getAccBalance();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = fgtermdepositreq.getPrincipalAmount();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        java.math.BigDecimal val40 = fgtermdepositreq.getMaturityAmount();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        java.math.BigDecimal val41 = fgtermdepositreq.getInterestAmount();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, fgtermdepositreq.getInterestPayPlan());
        ps.setString(43, fgtermdepositreq.getInterestDescription());
        ps.setString(44, fgtermdepositreq.getMaturityInstruction());
        ps.setString(45, fgtermdepositreq.getSchemeCode());
        ps.setString(46, fgtermdepositreq.getUserType());
        java.math.BigDecimal val47 = fgtermdepositreq.getTerms();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        ps.setString(48, fgtermdepositreq.getItType());
        java.math.BigDecimal val49 = fgtermdepositreq.getOtpCount();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = fgtermdepositreq.getOtpResent();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        ps.setString(51, fgtermdepositreq.getOtpSentTime());
        ps.setString(52, fgtermdepositreq.getOtpLockedTime());
        ps.setString(53, fgtermdepositreq.getOtpUnlockTime());
        java.math.BigDecimal val54 = fgtermdepositreq.getOtpFailedCount();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        java.math.BigDecimal val55 = fgtermdepositreq.getTdMinAmount();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        java.math.BigDecimal val56 = fgtermdepositreq.getTdMaxAmount();
        if (val56 != null) {
            ps.setBigDecimal(56, val56);
        } else {
            ps.setNull(56, Types.DECIMAL);
        }
        java.math.BigDecimal val57 = fgtermdepositreq.getMaxBookingLimit();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        java.math.BigDecimal val58 = fgtermdepositreq.getUtilisedBookingLimit();
        if (val58 != null) {
            ps.setBigDecimal(58, val58);
        } else {
            ps.setNull(58, Types.DECIMAL);
        }
        java.math.BigDecimal val59 = fgtermdepositreq.getAvailableBookingLimit();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        java.math.BigDecimal val60 = fgtermdepositreq.getPendingUtilisedLimit();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        Integer val61 = fgtermdepositreq.getYear();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        java.math.BigDecimal val62 = fgtermdepositreq.getMonth();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        java.math.BigDecimal val63 = fgtermdepositreq.getDays();
        if (val63 != null) {
            ps.setBigDecimal(63, val63);
        } else {
            ps.setNull(63, Types.DECIMAL);
        }
        ps.setString(64, fgtermdepositreq.getTdAccountNumber());
        ps.setString(65, fgtermdepositreq.getFinacleStatus());
        ps.setString(66, fgtermdepositreq.getOptionalRange());
        ps.setString(67, fgtermdepositreq.getOrigin());
        ps.setString(68, fgtermdepositreq.getTdType());
    }

    private FgTermDepositReq extract(ResultSet rs) throws SQLException {
        FgTermDepositReq fgtermdepositreq = new FgTermDepositReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtermdepositreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtermdepositreq.setReferenceID(REFERENCE_ID);
        fgtermdepositreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtermdepositreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtermdepositreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtermdepositreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtermdepositreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtermdepositreq.setProcessID(PROCESS_ID);
        fgtermdepositreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtermdepositreq.setCreatedBy(CREATED_BY);
        fgtermdepositreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtermdepositreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtermdepositreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtermdepositreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtermdepositreq.setTemplate(rs.getString(COL_TEMPLATE));
        fgtermdepositreq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtermdepositreq.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtermdepositreq.setIsTemplate(IS_TEMPLATE);
        fgtermdepositreq.setUserCrn(rs.getString(COL_USER_CRN));
        fgtermdepositreq.setUserName(rs.getString(COL_USER_NAME));
        fgtermdepositreq.setUserEmail(rs.getString(COL_USER_EMAIL));
        fgtermdepositreq.setUserMobile(rs.getString(COL_USER_MOBILE));
        java.math.BigDecimal DEPOSIT_AMOUNT = rs.getObject(COL_DEPOSIT_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setDepositAmount(DEPOSIT_AMOUNT);
        fgtermdepositreq.setCcy(rs.getString(COL_CCY));
        fgtermdepositreq.setAccountName(rs.getString(COL_ACCOUNT_NAME));
        fgtermdepositreq.setAccountType(rs.getString(COL_ACCOUNT_TYPE));
        fgtermdepositreq.setTenureDays(rs.getString(COL_TENURE_DAYS));
        fgtermdepositreq.setCustomTenure(rs.getString(COL_CUSTOM_TENURE));
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        fgtermdepositreq.setInterestRate(INTEREST_RATE);
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            fgtermdepositreq.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        fgtermdepositreq.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        fgtermdepositreq.setTaskReason(rs.getString(COL_TASK_REASON));
        fgtermdepositreq.setDebitAccNum(rs.getString(COL_DEBIT_ACC_NUM));
        fgtermdepositreq.setInterestAccount(rs.getString(COL_INTEREST_ACCOUNT));
        fgtermdepositreq.setPrincipalAccount(rs.getString(COL_PRINCIPAL_ACCOUNT));
        java.math.BigDecimal LIEN_AMOUNT = rs.getObject(COL_LIEN_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setLienAmount(LIEN_AMOUNT);
        java.math.BigDecimal LIEN_MARKED = rs.getObject(COL_LIEN_MARKED, java.math.BigDecimal.class);
        fgtermdepositreq.setLienMarked(LIEN_MARKED);
        java.math.BigDecimal ACC_BALANCE = rs.getObject(COL_ACC_BALANCE, java.math.BigDecimal.class);
        fgtermdepositreq.setAccBalance(ACC_BALANCE);
        java.math.BigDecimal PRINCIPAL_AMOUNT = rs.getObject(COL_PRINCIPAL_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setPrincipalAmount(PRINCIPAL_AMOUNT);
        java.math.BigDecimal MATURITY_AMOUNT = rs.getObject(COL_MATURITY_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setMaturityAmount(MATURITY_AMOUNT);
        java.math.BigDecimal INTEREST_AMOUNT = rs.getObject(COL_INTEREST_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setInterestAmount(INTEREST_AMOUNT);
        fgtermdepositreq.setInterestPayPlan(rs.getString(COL_INTEREST_PAY_PLAN));
        fgtermdepositreq.setInterestDescription(rs.getString(COL_INTEREST_DESCRIPTION));
        fgtermdepositreq.setMaturityInstruction(rs.getString(COL_MATURITY_INSTRUCTION));
        fgtermdepositreq.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        fgtermdepositreq.setUserType(rs.getString(COL_USER_TYPE));
        java.math.BigDecimal TERMS = rs.getObject(COL_TERMS, java.math.BigDecimal.class);
        fgtermdepositreq.setTerms(TERMS);
        fgtermdepositreq.setItType(rs.getString(COL_IT_TYPE));
        java.math.BigDecimal OTP_COUNT = rs.getObject(COL_OTP_COUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setOtpCount(OTP_COUNT);
        java.math.BigDecimal OTP_RESENT = rs.getObject(COL_OTP_RESENT, java.math.BigDecimal.class);
        fgtermdepositreq.setOtpResent(OTP_RESENT);
        fgtermdepositreq.setOtpSentTime(rs.getString(COL_OTP_SENT_TIME));
        fgtermdepositreq.setOtpLockedTime(rs.getString(COL_OTP_LOCKED_TIME));
        fgtermdepositreq.setOtpUnlockTime(rs.getString(COL_OTP_UNLOCK_TIME));
        java.math.BigDecimal OTP_FAILED_COUNT = rs.getObject(COL_OTP_FAILED_COUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setOtpFailedCount(OTP_FAILED_COUNT);
        java.math.BigDecimal TD_MIN_AMOUNT = rs.getObject(COL_TD_MIN_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setTdMinAmount(TD_MIN_AMOUNT);
        java.math.BigDecimal TD_MAX_AMOUNT = rs.getObject(COL_TD_MAX_AMOUNT, java.math.BigDecimal.class);
        fgtermdepositreq.setTdMaxAmount(TD_MAX_AMOUNT);
        java.math.BigDecimal MAX_BOOKING_LIMIT = rs.getObject(COL_MAX_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgtermdepositreq.setMaxBookingLimit(MAX_BOOKING_LIMIT);
        java.math.BigDecimal UTILISED_BOOKING_LIMIT = rs.getObject(COL_UTILISED_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgtermdepositreq.setUtilisedBookingLimit(UTILISED_BOOKING_LIMIT);
        java.math.BigDecimal AVAILABLE_BOOKING_LIMIT = rs.getObject(COL_AVAILABLE_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgtermdepositreq.setAvailableBookingLimit(AVAILABLE_BOOKING_LIMIT);
        java.math.BigDecimal PENDING_UTILISED_LIMIT = rs.getObject(COL_PENDING_UTILISED_LIMIT, java.math.BigDecimal.class);
        fgtermdepositreq.setPendingUtilisedLimit(PENDING_UTILISED_LIMIT);
        Integer YEAR = rs.getObject(COL_YEAR, Integer.class);
        fgtermdepositreq.setYear(YEAR);
        java.math.BigDecimal MONTH = rs.getObject(COL_MONTH, java.math.BigDecimal.class);
        fgtermdepositreq.setMonth(MONTH);
        java.math.BigDecimal DAYS = rs.getObject(COL_DAYS, java.math.BigDecimal.class);
        fgtermdepositreq.setDays(DAYS);
        fgtermdepositreq.setTdAccountNumber(rs.getString(COL_TD_ACCOUNT_NUMBER));
        fgtermdepositreq.setFinacleStatus(rs.getString(COL_FINACLE_STATUS));
        fgtermdepositreq.setOptionalRange(rs.getString(COL_OPTIONAL_RANGE));
        fgtermdepositreq.setOrigin(rs.getString(COL_ORIGIN));
        fgtermdepositreq.setTdType(rs.getString(COL_TD_TYPE));
        return fgtermdepositreq;
    }
}
