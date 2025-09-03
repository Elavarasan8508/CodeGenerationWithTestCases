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

public class JdbcFgLiquidationReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLiquidationReqDao.class);

    private static final String TABLE = "FG_LIQUIDATION_REQ";

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

    private static final String COL_TD_ACCOUNT = "TD_ACCOUNT";

    private static final String COL_ACCOUNT_NAME = "ACCOUNT_NAME";

    private static final String COL_PRINCIPAL_AMOUNT = "PRINCIPAL_AMOUNT";

    private static final String COL_LIQ_INTEREST_RATE = "LIQ_INTEREST_RATE";

    private static final String COL_CURRENT_BALANCE = "CURRENT_BALANCE";

    private static final String COL_START_DATE = "START_DATE";

    private static final String COL_LIQ_MATURITY_DATE = "LIQ_MATURITY_DATE";

    private static final String COL_MATURITY_AMOUNT = "MATURITY_AMOUNT";

    private static final String COL_INTEREST_ACCOUNT = "INTEREST_ACCOUNT";

    private static final String COL_PRINCIPAL_ACCOUNT = "PRINCIPAL_ACCOUNT";

    private static final String COL_LIQUID_TYPE = "LIQUID_TYPE";

    private static final String COL_LIQ_WITHDRAWN_AMOUNT = "LIQ_WITHDRAWN_AMOUNT";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_TERMS = "TERMS";

    private static final String COL_AVAILABLE_BALANCE = "AVAILABLE_BALANCE";

    private static final String COL_LIQ_DEBIT_ACC_NO = "LIQ_DEBIT_ACC_NO";

    private static final String COL_LIQ_DEPOSIT_ACC_NO = "LIQ_DEPOSIT_ACC_NO";

    private static final String COL_LIQ_DEPOSIT_AMOUNT = "LIQ_DEPOSIT_AMOUNT";

    private static final String COL_LIEN_MARKED = "LIEN_MARKED";

    private static final String COL_NAME_OF_ACC = "NAME_OF_ACC";

    private static final String COL_LIEN_AMOUNT = "LIEN_AMOUNT";

    private static final String COL_TRANSFER_TO = "TRANSFER_TO";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_USER_TYPE = "USER_TYPE";

    private static final String COL_MAX_BOOKING_LIMIT = "MAX_BOOKING_LIMIT";

    private static final String COL_OTP_COUNT = "OTP_COUNT";

    private static final String COL_OTP_RESENT = "OTP_RESENT";

    private static final String COL_OTP_SENT_TIME = "OTP_SENT_TIME";

    private static final String COL_OTP_LOCKED_TIME = "OTP_LOCKED_TIME";

    private static final String COL_OTP_UNLOCK_TIME = "OTP_UNLOCK_TIME";

    private static final String COL_OTP_FAILED_COUNT = "OTP_FAILED_COUNT";

    private static final String COL_UTILIZED_BOOKING_LIMIT = "UTILIZED_BOOKING_LIMIT";

    private static final String COL_AVAILABLE_BOOKING_LIMIT = "AVAILABLE_BOOKING_LIMIT";

    private static final String COL_PENDING_UTILISED_LIMIT = "PENDING_UTILISED_LIMIT";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_FINACLE_STATUS = "FINACLE_STATUS";

    private static final String COL_FINACLE_ERROR_CODE = "FINACLE_ERROR_CODE";

    private static final String COL_FINACLE_ERROR_DESC = "FINACLE_ERROR_DESC";

    private static final String COL_LIQ_WITHDRAWAL_INTEREST = "LIQ_WITHDRAWAL_INTEREST";

    private static final String COL_ORIGIN = "ORIGIN";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TD_ACCOUNT, COL_ACCOUNT_NAME, COL_PRINCIPAL_AMOUNT, COL_LIQ_INTEREST_RATE, COL_CURRENT_BALANCE, COL_START_DATE, COL_LIQ_MATURITY_DATE, COL_MATURITY_AMOUNT, COL_INTEREST_ACCOUNT, COL_PRINCIPAL_ACCOUNT, COL_LIQUID_TYPE, COL_LIQ_WITHDRAWN_AMOUNT, COL_REMARKS, COL_TERMS, COL_AVAILABLE_BALANCE, COL_LIQ_DEBIT_ACC_NO, COL_LIQ_DEPOSIT_ACC_NO, COL_LIQ_DEPOSIT_AMOUNT, COL_LIEN_MARKED, COL_NAME_OF_ACC, COL_LIEN_AMOUNT, COL_TRANSFER_TO, COL_TASK_REASON, COL_SCHEME_CODE, COL_USER_TYPE, COL_MAX_BOOKING_LIMIT, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_OTP_FAILED_COUNT, COL_UTILIZED_BOOKING_LIMIT, COL_AVAILABLE_BOOKING_LIMIT, COL_PENDING_UTILISED_LIMIT, COL_PRODUCT_STATUS, COL_FINACLE_STATUS, COL_FINACLE_ERROR_CODE, COL_FINACLE_ERROR_DESC, COL_LIQ_WITHDRAWAL_INTEREST, COL_ORIGIN);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_ACCOUNT, ACCOUNT_NAME, PRINCIPAL_AMOUNT, LIQ_INTEREST_RATE, CURRENT_BALANCE, START_DATE, LIQ_MATURITY_DATE, MATURITY_AMOUNT, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIQUID_TYPE, LIQ_WITHDRAWN_AMOUNT, REMARKS, TERMS, AVAILABLE_BALANCE, LIQ_DEBIT_ACC_NO, LIQ_DEPOSIT_ACC_NO, LIQ_DEPOSIT_AMOUNT, LIEN_MARKED, NAME_OF_ACC, LIEN_AMOUNT, TRANSFER_TO, TASK_REASON, SCHEME_CODE, USER_TYPE, MAX_BOOKING_LIMIT, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, UTILIZED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, PRODUCT_STATUS, FINACLE_STATUS, FINACLE_ERROR_CODE, FINACLE_ERROR_DESC, LIQ_WITHDRAWAL_INTEREST, ORIGIN", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_ACCOUNT, ACCOUNT_NAME, PRINCIPAL_AMOUNT, LIQ_INTEREST_RATE, CURRENT_BALANCE, START_DATE, LIQ_MATURITY_DATE, MATURITY_AMOUNT, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIQUID_TYPE, LIQ_WITHDRAWN_AMOUNT, REMARKS, TERMS, AVAILABLE_BALANCE, LIQ_DEBIT_ACC_NO, LIQ_DEPOSIT_ACC_NO, LIQ_DEPOSIT_AMOUNT, LIEN_MARKED, NAME_OF_ACC, LIEN_AMOUNT, TRANSFER_TO, TASK_REASON, SCHEME_CODE, USER_TYPE, MAX_BOOKING_LIMIT, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, UTILIZED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, PRODUCT_STATUS, FINACLE_STATUS, FINACLE_ERROR_CODE, FINACLE_ERROR_DESC, LIQ_WITHDRAWAL_INTEREST, ORIGIN", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TD_ACCOUNT, COL_ACCOUNT_NAME, COL_PRINCIPAL_AMOUNT, COL_LIQ_INTEREST_RATE, COL_CURRENT_BALANCE, COL_START_DATE, COL_LIQ_MATURITY_DATE, COL_MATURITY_AMOUNT, COL_INTEREST_ACCOUNT, COL_PRINCIPAL_ACCOUNT, COL_LIQUID_TYPE, COL_LIQ_WITHDRAWN_AMOUNT, COL_REMARKS, COL_TERMS, COL_AVAILABLE_BALANCE, COL_LIQ_DEBIT_ACC_NO, COL_LIQ_DEPOSIT_ACC_NO, COL_LIQ_DEPOSIT_AMOUNT, COL_LIEN_MARKED, COL_NAME_OF_ACC, COL_LIEN_AMOUNT, COL_TRANSFER_TO, COL_TASK_REASON, COL_SCHEME_CODE, COL_USER_TYPE, COL_MAX_BOOKING_LIMIT, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_OTP_FAILED_COUNT, COL_UTILIZED_BOOKING_LIMIT, COL_AVAILABLE_BOOKING_LIMIT, COL_PENDING_UTILISED_LIMIT, COL_PRODUCT_STATUS, COL_FINACLE_STATUS, COL_FINACLE_ERROR_CODE, COL_FINACLE_ERROR_DESC, COL_LIQ_WITHDRAWAL_INTEREST, COL_ORIGIN, COL_ID);

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

    public int insert(Connection conn, FgLiquidationReq fgliquidationreq) throws SQLException {
        logger.debug("Inserting fgliquidationreq: {}", fgliquidationreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLiquidationReqParams(ps, fgliquidationreq);
            ps.executeUpdate();
            return fgliquidationreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLiquidationReq> fgliquidationreqs) throws SQLException {
        if (fgliquidationreqs == null || fgliquidationreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgliquidationreqs.size(); i++) {
            if (fgliquidationreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLiquidationReq>> batches = chunkList(fgliquidationreqs, batchSize);
        int[] totalResults = new int[fgliquidationreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLiquidationReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLiquidationReq fgliquidationreq : batch) {
                        setFgLiquidationReqParams(ps, fgliquidationreq);
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

    public FgLiquidationReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLiquidationReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLiquidationReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLiquidationReq fgliquidationreq) throws SQLException {
        if (fgliquidationreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLiquidationReqParams(ps, fgliquidationreq);
            ps.setInt(59, fgliquidationreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLiquidationReq> fgliquidationreqs) throws SQLException {
        if (fgliquidationreqs == null || fgliquidationreqs.isEmpty())
            return new int[0];
        for (FgLiquidationReq fgliquidationreq : fgliquidationreqs) {
            if (fgliquidationreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgliquidationreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLiquidationReq>> batches = chunkList(fgliquidationreqs, batchSize);
        int[] totalResults = new int[fgliquidationreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLiquidationReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLiquidationReq fgliquidationreq : batch) {
                        setFgLiquidationReqParams(ps, fgliquidationreq);
                        ps.setInt(59, fgliquidationreq.getID());
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

    private void setFgLiquidationReqParams(PreparedStatement ps, FgLiquidationReq fgliquidationreq) throws SQLException {
        Integer val1 = fgliquidationreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgliquidationreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgliquidationreq.getTypeCode());
        ps.setString(4, fgliquidationreq.getSubTypeCode());
        ps.setString(5, fgliquidationreq.getActiveCode());
        ps.setString(6, fgliquidationreq.getStageCode());
        ps.setString(7, fgliquidationreq.getStatusCode());
        Integer val8 = fgliquidationreq.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgliquidationreq.getCreatedOn());
        java.math.BigDecimal val10 = fgliquidationreq.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgliquidationreq.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgliquidationreq.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgliquidationreq.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgliquidationreq.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgliquidationreq.getTemplate());
        ps.setString(16, fgliquidationreq.getApplicantParty());
        ps.setString(17, fgliquidationreq.getFulfillmentParty());
        java.math.BigDecimal val18 = fgliquidationreq.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgliquidationreq.getTdAccount());
        ps.setString(20, fgliquidationreq.getAccountName());
        java.math.BigDecimal val21 = fgliquidationreq.getPrincipalAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgliquidationreq.getLiqInterestRate();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgliquidationreq.getCurrentBalance();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgliquidationreq.getStartDate());
        ps.setString(25, fgliquidationreq.getLiqMaturityDate());
        java.math.BigDecimal val26 = fgliquidationreq.getMaturityAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgliquidationreq.getInterestAccount());
        ps.setString(28, fgliquidationreq.getPrincipalAccount());
        ps.setString(29, fgliquidationreq.getLiquidType());
        java.math.BigDecimal val30 = fgliquidationreq.getLiqWithdrawnAmount();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgliquidationreq.getRemarks());
        java.math.BigDecimal val32 = fgliquidationreq.getTerms();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = fgliquidationreq.getAvailableBalance();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        ps.setString(34, fgliquidationreq.getLiqDebitAccNo());
        ps.setString(35, fgliquidationreq.getLiqDepositAccNo());
        java.math.BigDecimal val36 = fgliquidationreq.getLiqDepositAmount();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = fgliquidationreq.getLienMarked();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        ps.setString(38, fgliquidationreq.getNameOfAcc());
        java.math.BigDecimal val39 = fgliquidationreq.getLienAmount();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgliquidationreq.getTransferTo());
        ps.setString(41, fgliquidationreq.getTaskReason());
        ps.setString(42, fgliquidationreq.getSchemeCode());
        ps.setString(43, fgliquidationreq.getUserType());
        java.math.BigDecimal val44 = fgliquidationreq.getMaxBookingLimit();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        java.math.BigDecimal val45 = fgliquidationreq.getOtpCount();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = fgliquidationreq.getOtpResent();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgliquidationreq.getOtpSentTime());
        ps.setString(48, fgliquidationreq.getOtpLockedTime());
        ps.setString(49, fgliquidationreq.getOtpUnlockTime());
        java.math.BigDecimal val50 = fgliquidationreq.getOtpFailedCount();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = fgliquidationreq.getUtilizedBookingLimit();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        java.math.BigDecimal val52 = fgliquidationreq.getAvailableBookingLimit();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        java.math.BigDecimal val53 = fgliquidationreq.getPendingUtilisedLimit();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, fgliquidationreq.getProductStatus());
        ps.setString(55, fgliquidationreq.getFinacleStatus());
        ps.setString(56, fgliquidationreq.getFinacleErrorCode());
        ps.setString(57, fgliquidationreq.getFinacleErrorDesc());
        java.math.BigDecimal val58 = fgliquidationreq.getLiqWithdrawalInterest();
        if (val58 != null) {
            ps.setBigDecimal(58, val58);
        } else {
            ps.setNull(58, Types.DECIMAL);
        }
        ps.setString(59, fgliquidationreq.getOrigin());
    }

    private FgLiquidationReq extract(ResultSet rs) throws SQLException {
        FgLiquidationReq fgliquidationreq = new FgLiquidationReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgliquidationreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgliquidationreq.setReferenceID(REFERENCE_ID);
        fgliquidationreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgliquidationreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgliquidationreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgliquidationreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgliquidationreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgliquidationreq.setProcessID(PROCESS_ID);
        fgliquidationreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgliquidationreq.setCreatedBy(CREATED_BY);
        fgliquidationreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgliquidationreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgliquidationreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgliquidationreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgliquidationreq.setTemplate(rs.getString(COL_TEMPLATE));
        fgliquidationreq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgliquidationreq.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgliquidationreq.setIsTemplate(IS_TEMPLATE);
        fgliquidationreq.setTdAccount(rs.getString(COL_TD_ACCOUNT));
        fgliquidationreq.setAccountName(rs.getString(COL_ACCOUNT_NAME));
        java.math.BigDecimal PRINCIPAL_AMOUNT = rs.getObject(COL_PRINCIPAL_AMOUNT, java.math.BigDecimal.class);
        fgliquidationreq.setPrincipalAmount(PRINCIPAL_AMOUNT);
        java.math.BigDecimal LIQ_INTEREST_RATE = rs.getObject(COL_LIQ_INTEREST_RATE, java.math.BigDecimal.class);
        fgliquidationreq.setLiqInterestRate(LIQ_INTEREST_RATE);
        java.math.BigDecimal CURRENT_BALANCE = rs.getObject(COL_CURRENT_BALANCE, java.math.BigDecimal.class);
        fgliquidationreq.setCurrentBalance(CURRENT_BALANCE);
        fgliquidationreq.setStartDate(rs.getString(COL_START_DATE));
        fgliquidationreq.setLiqMaturityDate(rs.getString(COL_LIQ_MATURITY_DATE));
        java.math.BigDecimal MATURITY_AMOUNT = rs.getObject(COL_MATURITY_AMOUNT, java.math.BigDecimal.class);
        fgliquidationreq.setMaturityAmount(MATURITY_AMOUNT);
        fgliquidationreq.setInterestAccount(rs.getString(COL_INTEREST_ACCOUNT));
        fgliquidationreq.setPrincipalAccount(rs.getString(COL_PRINCIPAL_ACCOUNT));
        fgliquidationreq.setLiquidType(rs.getString(COL_LIQUID_TYPE));
        java.math.BigDecimal LIQ_WITHDRAWN_AMOUNT = rs.getObject(COL_LIQ_WITHDRAWN_AMOUNT, java.math.BigDecimal.class);
        fgliquidationreq.setLiqWithdrawnAmount(LIQ_WITHDRAWN_AMOUNT);
        fgliquidationreq.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal TERMS = rs.getObject(COL_TERMS, java.math.BigDecimal.class);
        fgliquidationreq.setTerms(TERMS);
        java.math.BigDecimal AVAILABLE_BALANCE = rs.getObject(COL_AVAILABLE_BALANCE, java.math.BigDecimal.class);
        fgliquidationreq.setAvailableBalance(AVAILABLE_BALANCE);
        fgliquidationreq.setLiqDebitAccNo(rs.getString(COL_LIQ_DEBIT_ACC_NO));
        fgliquidationreq.setLiqDepositAccNo(rs.getString(COL_LIQ_DEPOSIT_ACC_NO));
        java.math.BigDecimal LIQ_DEPOSIT_AMOUNT = rs.getObject(COL_LIQ_DEPOSIT_AMOUNT, java.math.BigDecimal.class);
        fgliquidationreq.setLiqDepositAmount(LIQ_DEPOSIT_AMOUNT);
        java.math.BigDecimal LIEN_MARKED = rs.getObject(COL_LIEN_MARKED, java.math.BigDecimal.class);
        fgliquidationreq.setLienMarked(LIEN_MARKED);
        fgliquidationreq.setNameOfAcc(rs.getString(COL_NAME_OF_ACC));
        java.math.BigDecimal LIEN_AMOUNT = rs.getObject(COL_LIEN_AMOUNT, java.math.BigDecimal.class);
        fgliquidationreq.setLienAmount(LIEN_AMOUNT);
        fgliquidationreq.setTransferTo(rs.getString(COL_TRANSFER_TO));
        fgliquidationreq.setTaskReason(rs.getString(COL_TASK_REASON));
        fgliquidationreq.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        fgliquidationreq.setUserType(rs.getString(COL_USER_TYPE));
        java.math.BigDecimal MAX_BOOKING_LIMIT = rs.getObject(COL_MAX_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgliquidationreq.setMaxBookingLimit(MAX_BOOKING_LIMIT);
        java.math.BigDecimal OTP_COUNT = rs.getObject(COL_OTP_COUNT, java.math.BigDecimal.class);
        fgliquidationreq.setOtpCount(OTP_COUNT);
        java.math.BigDecimal OTP_RESENT = rs.getObject(COL_OTP_RESENT, java.math.BigDecimal.class);
        fgliquidationreq.setOtpResent(OTP_RESENT);
        fgliquidationreq.setOtpSentTime(rs.getString(COL_OTP_SENT_TIME));
        fgliquidationreq.setOtpLockedTime(rs.getString(COL_OTP_LOCKED_TIME));
        fgliquidationreq.setOtpUnlockTime(rs.getString(COL_OTP_UNLOCK_TIME));
        java.math.BigDecimal OTP_FAILED_COUNT = rs.getObject(COL_OTP_FAILED_COUNT, java.math.BigDecimal.class);
        fgliquidationreq.setOtpFailedCount(OTP_FAILED_COUNT);
        java.math.BigDecimal UTILIZED_BOOKING_LIMIT = rs.getObject(COL_UTILIZED_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgliquidationreq.setUtilizedBookingLimit(UTILIZED_BOOKING_LIMIT);
        java.math.BigDecimal AVAILABLE_BOOKING_LIMIT = rs.getObject(COL_AVAILABLE_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgliquidationreq.setAvailableBookingLimit(AVAILABLE_BOOKING_LIMIT);
        java.math.BigDecimal PENDING_UTILISED_LIMIT = rs.getObject(COL_PENDING_UTILISED_LIMIT, java.math.BigDecimal.class);
        fgliquidationreq.setPendingUtilisedLimit(PENDING_UTILISED_LIMIT);
        fgliquidationreq.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        fgliquidationreq.setFinacleStatus(rs.getString(COL_FINACLE_STATUS));
        fgliquidationreq.setFinacleErrorCode(rs.getString(COL_FINACLE_ERROR_CODE));
        fgliquidationreq.setFinacleErrorDesc(rs.getString(COL_FINACLE_ERROR_DESC));
        java.math.BigDecimal LIQ_WITHDRAWAL_INTEREST = rs.getObject(COL_LIQ_WITHDRAWAL_INTEREST, java.math.BigDecimal.class);
        fgliquidationreq.setLiqWithdrawalInterest(LIQ_WITHDRAWAL_INTEREST);
        fgliquidationreq.setOrigin(rs.getString(COL_ORIGIN));
        return fgliquidationreq;
    }
}
