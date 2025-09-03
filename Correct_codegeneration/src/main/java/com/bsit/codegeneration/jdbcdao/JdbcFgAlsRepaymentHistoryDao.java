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

public class JdbcFgAlsRepaymentHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAlsRepaymentHistoryDao.class);

    private static final String TABLE = "FG_ALS_REPAYMENT_HISTORY";

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

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_SETTLEMENT_AMT = "SETTLEMENT_AMT";

    private static final String COL_ACCOUNT_NO = "ACCOUNT_NO";

    private static final String COL_WEIGHT = "WEIGHT";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_DISB_DATE = "DISB_DATE";

    private static final String COL_OVERDUE_Y_N = "OVERDUE_Y_N";

    private static final String COL_MASTER_REF = "MASTER_REF";

    private static final String COL_LOGIC_OF_SETTLEMENT = "LOGIC_OF_SETTLEMENT";

    private static final String COL_AVAILABLE_BALANCE = "AVAILABLE_BALANCE";

    private static final String COL_TOTAL_BALANCE = "TOTAL_BALANCE";

    private static final String COL_TOTAL_REPAYMENT_AMOUNT = "TOTAL_REPAYMENT_AMOUNT";

    private static final String COL_PRINCIPLE_REPAYMENT_AMOUNT = "PRINCIPLE_REPAYMENT_AMOUNT";

    private static final String COL_INTEREST_REPAYMENT_AMOUNT = "INTEREST_REPAYMENT_AMOUNT";

    private static final String COL_ACCOUNT_BALANCE = "ACCOUNT_BALANCE";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_SETTLEMENT_AMT, COL_ACCOUNT_NO, COL_WEIGHT, COL_STATUS, COL_MATURITY_DATE, COL_DISB_DATE, COL_OVERDUE_Y_N, COL_MASTER_REF, COL_LOGIC_OF_SETTLEMENT, COL_AVAILABLE_BALANCE, COL_TOTAL_BALANCE, COL_TOTAL_REPAYMENT_AMOUNT, COL_PRINCIPLE_REPAYMENT_AMOUNT, COL_INTEREST_REPAYMENT_AMOUNT, COL_ACCOUNT_BALANCE, COL_CUSTOMER_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, SETTLEMENT_AMT, ACCOUNT_NO, WEIGHT, STATUS, MATURITY_DATE, DISB_DATE, OVERDUE_Y_N, MASTER_REF, LOGIC_OF_SETTLEMENT, AVAILABLE_BALANCE, TOTAL_BALANCE, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT, INTEREST_REPAYMENT_AMOUNT, ACCOUNT_BALANCE, CUSTOMER_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, SETTLEMENT_AMT, ACCOUNT_NO, WEIGHT, STATUS, MATURITY_DATE, DISB_DATE, OVERDUE_Y_N, MASTER_REF, LOGIC_OF_SETTLEMENT, AVAILABLE_BALANCE, TOTAL_BALANCE, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT, INTEREST_REPAYMENT_AMOUNT, ACCOUNT_BALANCE, CUSTOMER_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_SETTLEMENT_AMT, COL_ACCOUNT_NO, COL_WEIGHT, COL_STATUS, COL_MATURITY_DATE, COL_DISB_DATE, COL_OVERDUE_Y_N, COL_MASTER_REF, COL_LOGIC_OF_SETTLEMENT, COL_AVAILABLE_BALANCE, COL_TOTAL_BALANCE, COL_TOTAL_REPAYMENT_AMOUNT, COL_PRINCIPLE_REPAYMENT_AMOUNT, COL_INTEREST_REPAYMENT_AMOUNT, COL_ACCOUNT_BALANCE, COL_CUSTOMER_NAME, COL_ID);

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

    public int insert(Connection conn, FgAlsRepaymentHistory fgalsrepaymenthistory) throws SQLException {
        logger.debug("Inserting fgalsrepaymenthistory: {}", fgalsrepaymenthistory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAlsRepaymentHistoryParams(ps, fgalsrepaymenthistory);
            ps.executeUpdate();
            return fgalsrepaymenthistory.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAlsRepaymentHistory> fgalsrepaymenthistorys) throws SQLException {
        if (fgalsrepaymenthistorys == null || fgalsrepaymenthistorys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgalsrepaymenthistorys.size(); i++) {
            if (fgalsrepaymenthistorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsRepaymentHistory>> batches = chunkList(fgalsrepaymenthistorys, batchSize);
        int[] totalResults = new int[fgalsrepaymenthistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsRepaymentHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAlsRepaymentHistory fgalsrepaymenthistory : batch) {
                        setFgAlsRepaymentHistoryParams(ps, fgalsrepaymenthistory);
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

    public FgAlsRepaymentHistory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAlsRepaymentHistory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAlsRepaymentHistory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAlsRepaymentHistory fgalsrepaymenthistory) throws SQLException {
        if (fgalsrepaymenthistory.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAlsRepaymentHistoryParams(ps, fgalsrepaymenthistory);
            ps.setInt(35, fgalsrepaymenthistory.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAlsRepaymentHistory> fgalsrepaymenthistorys) throws SQLException {
        if (fgalsrepaymenthistorys == null || fgalsrepaymenthistorys.isEmpty())
            return new int[0];
        for (FgAlsRepaymentHistory fgalsrepaymenthistory : fgalsrepaymenthistorys) {
            if (fgalsrepaymenthistory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgalsrepaymenthistory.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsRepaymentHistory>> batches = chunkList(fgalsrepaymenthistorys, batchSize);
        int[] totalResults = new int[fgalsrepaymenthistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsRepaymentHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAlsRepaymentHistory fgalsrepaymenthistory : batch) {
                        setFgAlsRepaymentHistoryParams(ps, fgalsrepaymenthistory);
                        ps.setInt(35, fgalsrepaymenthistory.getID());
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

    private void setFgAlsRepaymentHistoryParams(PreparedStatement ps, FgAlsRepaymentHistory fgalsrepaymenthistory) throws SQLException {
        Integer val1 = fgalsrepaymenthistory.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgalsrepaymenthistory.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgalsrepaymenthistory.getTypeCode());
        ps.setString(4, fgalsrepaymenthistory.getSubTypeCode());
        ps.setString(5, fgalsrepaymenthistory.getActiveCode());
        ps.setString(6, fgalsrepaymenthistory.getStageCode());
        ps.setString(7, fgalsrepaymenthistory.getStatusCode());
        Integer val8 = fgalsrepaymenthistory.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgalsrepaymenthistory.getCreatedOn());
        java.math.BigDecimal val10 = fgalsrepaymenthistory.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgalsrepaymenthistory.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgalsrepaymenthistory.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgalsrepaymenthistory.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgalsrepaymenthistory.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgalsrepaymenthistory.getTemplate());
        ps.setString(16, fgalsrepaymenthistory.getApplicantParty());
        ps.setString(17, fgalsrepaymenthistory.getFulfillmentParty());
        java.math.BigDecimal val18 = fgalsrepaymenthistory.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgalsrepaymenthistory.getCustomerCrn());
        ps.setString(20, fgalsrepaymenthistory.getSettlementAmt());
        ps.setString(21, fgalsrepaymenthistory.getAccountNo());
        java.math.BigDecimal val22 = fgalsrepaymenthistory.getWeight();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgalsrepaymenthistory.getStatus());
        java.time.LocalDateTime val24 = fgalsrepaymenthistory.getMaturityDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val25 = fgalsrepaymenthistory.getDisbDate();
        if (val25 != null) {
            ps.setTimestamp(25, java.sql.Timestamp.valueOf(val25));
        } else {
            ps.setNull(25, Types.TIMESTAMP);
        }
        ps.setString(26, fgalsrepaymenthistory.getOverdueYN());
        ps.setString(27, fgalsrepaymenthistory.getMasterRef());
        ps.setString(28, fgalsrepaymenthistory.getLogicOfSettlement());
        java.math.BigDecimal val29 = fgalsrepaymenthistory.getAvailableBalance();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = fgalsrepaymenthistory.getTotalBalance();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = fgalsrepaymenthistory.getTotalRepaymentAmount();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = fgalsrepaymenthistory.getPrincipleRepaymentAmount();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = fgalsrepaymenthistory.getInterestRepaymentAmount();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgalsrepaymenthistory.getAccountBalance();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fgalsrepaymenthistory.getCustomerName());
    }

    private FgAlsRepaymentHistory extract(ResultSet rs) throws SQLException {
        FgAlsRepaymentHistory fgalsrepaymenthistory = new FgAlsRepaymentHistory();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgalsrepaymenthistory.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgalsrepaymenthistory.setReferenceID(REFERENCE_ID);
        fgalsrepaymenthistory.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgalsrepaymenthistory.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgalsrepaymenthistory.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgalsrepaymenthistory.setStageCode(rs.getString(COL_STAGE_CODE));
        fgalsrepaymenthistory.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgalsrepaymenthistory.setProcessID(PROCESS_ID);
        fgalsrepaymenthistory.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setCreatedBy(CREATED_BY);
        fgalsrepaymenthistory.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setLastUpdatedBy(LAST_UPDATED_BY);
        fgalsrepaymenthistory.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgalsrepaymenthistory.setTemplate(rs.getString(COL_TEMPLATE));
        fgalsrepaymenthistory.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgalsrepaymenthistory.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setIsTemplate(IS_TEMPLATE);
        fgalsrepaymenthistory.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        fgalsrepaymenthistory.setSettlementAmt(rs.getString(COL_SETTLEMENT_AMT));
        fgalsrepaymenthistory.setAccountNo(rs.getString(COL_ACCOUNT_NO));
        java.math.BigDecimal WEIGHT = rs.getObject(COL_WEIGHT, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setWeight(WEIGHT);
        fgalsrepaymenthistory.setStatus(rs.getString(COL_STATUS));
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            fgalsrepaymenthistory.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        Timestamp DISB_DATE = rs.getTimestamp(COL_DISB_DATE);
        if (DISB_DATE != null)
            fgalsrepaymenthistory.setDisbDate(DISB_DATE.toLocalDateTime());
        fgalsrepaymenthistory.setOverdueYN(rs.getString(COL_OVERDUE_Y_N));
        fgalsrepaymenthistory.setMasterRef(rs.getString(COL_MASTER_REF));
        fgalsrepaymenthistory.setLogicOfSettlement(rs.getString(COL_LOGIC_OF_SETTLEMENT));
        java.math.BigDecimal AVAILABLE_BALANCE = rs.getObject(COL_AVAILABLE_BALANCE, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setAvailableBalance(AVAILABLE_BALANCE);
        java.math.BigDecimal TOTAL_BALANCE = rs.getObject(COL_TOTAL_BALANCE, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setTotalBalance(TOTAL_BALANCE);
        java.math.BigDecimal TOTAL_REPAYMENT_AMOUNT = rs.getObject(COL_TOTAL_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setTotalRepaymentAmount(TOTAL_REPAYMENT_AMOUNT);
        java.math.BigDecimal PRINCIPLE_REPAYMENT_AMOUNT = rs.getObject(COL_PRINCIPLE_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setPrincipleRepaymentAmount(PRINCIPLE_REPAYMENT_AMOUNT);
        java.math.BigDecimal INTEREST_REPAYMENT_AMOUNT = rs.getObject(COL_INTEREST_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setInterestRepaymentAmount(INTEREST_REPAYMENT_AMOUNT);
        java.math.BigDecimal ACCOUNT_BALANCE = rs.getObject(COL_ACCOUNT_BALANCE, java.math.BigDecimal.class);
        fgalsrepaymenthistory.setAccountBalance(ACCOUNT_BALANCE);
        fgalsrepaymenthistory.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        return fgalsrepaymenthistory;
    }
}
