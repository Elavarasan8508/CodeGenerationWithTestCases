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

public class JdbcFgFinanceTransactionsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFinanceTransactionsDao.class);

    private static final String TABLE = "FG_FINANCE_TRANSACTIONS";

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

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_ANCHOR_CRN = "ANCHOR_CRN";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String COL_COUNTER_PARTY_CRN = "COUNTER_PARTY_CRN";

    private static final String COL_COUNTER_PARTY_NAME = "COUNTER_PARTY_NAME";

    private static final String COL_INPUT_BRANCH = "INPUT_BRANCH";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_DEBIT_PARTY_CRN = "DEBIT_PARTY_CRN";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_FINANCING_AMOUNT = "FINANCING_AMOUNT";

    private static final String COL_CREDIT_PARTY_CRN = "CREDIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_NAME = "CREDIT_PARTY_NAME";

    private static final String COL_SPREAD_RATE = "SPREAD_RATE";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_MARGIN_RATE = "MARGIN_RATE";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_PENALTY_PERCENT = "PENALTY_PERCENT";

    private static final String COL_INT_START_DATE = "INT_START_DATE";

    private static final String COL_INTEREST_TYPE = "INTEREST_TYPE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_BASE_CODE = "BASE_CODE";

    private static final String COL_TENOR_IN_DAYS = "TENOR_IN_DAYS";

    private static final String COL_INT_PERIOD_IN_DAYS = "INT_PERIOD_IN_DAYS";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_CONTRACT_PERIOD = "CONTRACT_PERIOD";

    private static final String COL_GRACE_PERIOD = "GRACE_PERIOD";

    private static final String COL_LIMIT_NODE1 = "LIMIT_NODE1";

    private static final String COL_LIMIT_NODE2 = "LIMIT_NODE2";

    private static final String COL_PAYMENT_MODE = "PAYMENT_MODE";

    private static final String COL_BENE_BRANCH = "BENE_BRANCH";

    private static final String COL_BENE_ACC_NO = "BENE_ACC_NO";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_ADVANCE_INTEREST = "ADVANCE_INTEREST";

    private static final String COL_NET_PAYMENT = "NET_PAYMENT";

    private static final String COL_VAL_DATE = "VAL_DATE";

    private static final String COL_UTR_NUMBER = "UTR_NUMBER";

    private static final String COL_CHARGES = "CHARGES";

    private static final String COL_TI_STATUS = "TI_STATUS";

    private static final String COL_TI_BATCH_REF_ID = "TI_BATCH_REF_ID";

    private static final String COL_TI_REMARKS = "TI_REMARKS";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_FINANCE_FILE_GENERATED = "FINANCE_FILE_GENERATED";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_FINANCE_REMARKS = "FINANCE_REMARKS";

    private static final String COL_SELLER_ID_CRN = "SELLER_ID_CRN";

    private static final String COL_BUYER_ID_CRN = "BUYER_ID_CRN";

    private static final String COL_CP_ROLE = "CP_ROLE";

    private static final String COL_BENE_LEI = "BENE_LEI";

    private static final String COL_FINANCE_AMOUNT = "FINANCE_AMOUNT";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_FILE_NAME, COL_ANCHOR_CRN, COL_INV_NO, COL_INV_DATE, COL_INV_AMT, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_DEBIT_PARTY_CRN, COL_EFFECTIVE_DATE, COL_FINANCING_AMOUNT, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SPREAD_RATE, COL_INTEREST_RATE, COL_MARGIN_RATE, COL_MATURITY_DATE, COL_PENALTY_PERCENT, COL_INT_START_DATE, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_PRODUCT_TYPE, COL_CONTRACT_PERIOD, COL_GRACE_PERIOD, COL_LIMIT_NODE1, COL_LIMIT_NODE2, COL_PAYMENT_MODE, COL_BENE_BRANCH, COL_BENE_ACC_NO, COL_STATUS, COL_BATCH_REF_ID, COL_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VAL_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_UPLOAD_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_FINANCE_FILE_GENERATED, COL_ENTITY_REF_ID, COL_FINANCE_REMARKS, COL_SELLER_ID_CRN, COL_BUYER_ID_CRN, COL_CP_ROLE, COL_BENE_LEI, COL_FINANCE_AMOUNT, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_VALUE_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_NAME, ANCHOR_CRN, INV_NO, INV_DATE, INV_AMT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INT_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, PRODUCT_TYPE, CONTRACT_PERIOD, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, PAYMENT_MODE, BENE_BRANCH, BENE_ACC_NO, STATUS, BATCH_REF_ID, REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VAL_DATE, UTR_NUMBER, CHARGES, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, FINANCE_FILE_GENERATED, ENTITY_REF_ID, FINANCE_REMARKS, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, FINANCE_AMOUNT, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, VALUE_DATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_NAME, ANCHOR_CRN, INV_NO, INV_DATE, INV_AMT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INT_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, PRODUCT_TYPE, CONTRACT_PERIOD, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, PAYMENT_MODE, BENE_BRANCH, BENE_ACC_NO, STATUS, BATCH_REF_ID, REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VAL_DATE, UTR_NUMBER, CHARGES, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, FINANCE_FILE_GENERATED, ENTITY_REF_ID, FINANCE_REMARKS, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, FINANCE_AMOUNT, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, VALUE_DATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_FILE_NAME, COL_ANCHOR_CRN, COL_INV_NO, COL_INV_DATE, COL_INV_AMT, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_DEBIT_PARTY_CRN, COL_EFFECTIVE_DATE, COL_FINANCING_AMOUNT, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SPREAD_RATE, COL_INTEREST_RATE, COL_MARGIN_RATE, COL_MATURITY_DATE, COL_PENALTY_PERCENT, COL_INT_START_DATE, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_PRODUCT_TYPE, COL_CONTRACT_PERIOD, COL_GRACE_PERIOD, COL_LIMIT_NODE1, COL_LIMIT_NODE2, COL_PAYMENT_MODE, COL_BENE_BRANCH, COL_BENE_ACC_NO, COL_STATUS, COL_BATCH_REF_ID, COL_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VAL_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_UPLOAD_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_FINANCE_FILE_GENERATED, COL_ENTITY_REF_ID, COL_FINANCE_REMARKS, COL_SELLER_ID_CRN, COL_BUYER_ID_CRN, COL_CP_ROLE, COL_BENE_LEI, COL_FINANCE_AMOUNT, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_VALUE_DATE, COL_ID);

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

    public int insert(Connection conn, FgFinanceTransactions fgfinancetransactions) throws SQLException {
        logger.debug("Inserting fgfinancetransactions: {}", fgfinancetransactions);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFinanceTransactionsParams(ps, fgfinancetransactions);
            ps.executeUpdate();
            return fgfinancetransactions.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFinanceTransactions> fgfinancetransactionss) throws SQLException {
        if (fgfinancetransactionss == null || fgfinancetransactionss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfinancetransactionss.size(); i++) {
            if (fgfinancetransactionss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceTransactions>> batches = chunkList(fgfinancetransactionss, batchSize);
        int[] totalResults = new int[fgfinancetransactionss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceTransactions> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFinanceTransactions fgfinancetransactions : batch) {
                        setFgFinanceTransactionsParams(ps, fgfinancetransactions);
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

    public FgFinanceTransactions findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFinanceTransactions> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFinanceTransactions> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFinanceTransactions fgfinancetransactions) throws SQLException {
        if (fgfinancetransactions.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFinanceTransactionsParams(ps, fgfinancetransactions);
            ps.setInt(76, fgfinancetransactions.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFinanceTransactions> fgfinancetransactionss) throws SQLException {
        if (fgfinancetransactionss == null || fgfinancetransactionss.isEmpty())
            return new int[0];
        for (FgFinanceTransactions fgfinancetransactions : fgfinancetransactionss) {
            if (fgfinancetransactions == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfinancetransactions.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceTransactions>> batches = chunkList(fgfinancetransactionss, batchSize);
        int[] totalResults = new int[fgfinancetransactionss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceTransactions> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFinanceTransactions fgfinancetransactions : batch) {
                        setFgFinanceTransactionsParams(ps, fgfinancetransactions);
                        ps.setInt(76, fgfinancetransactions.getID());
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

    private void setFgFinanceTransactionsParams(PreparedStatement ps, FgFinanceTransactions fgfinancetransactions) throws SQLException {
        Integer val1 = fgfinancetransactions.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfinancetransactions.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfinancetransactions.getTypeCode());
        ps.setString(4, fgfinancetransactions.getSubTypeCode());
        ps.setString(5, fgfinancetransactions.getActiveCode());
        ps.setString(6, fgfinancetransactions.getStageCode());
        ps.setString(7, fgfinancetransactions.getStatusCode());
        Integer val8 = fgfinancetransactions.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgfinancetransactions.getCreatedOn());
        java.math.BigDecimal val10 = fgfinancetransactions.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgfinancetransactions.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgfinancetransactions.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgfinancetransactions.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgfinancetransactions.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgfinancetransactions.getTemplate());
        ps.setString(16, fgfinancetransactions.getApplicantParty());
        ps.setString(17, fgfinancetransactions.getFulfillmentParty());
        java.math.BigDecimal val18 = fgfinancetransactions.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgfinancetransactions.getFileName());
        ps.setString(20, fgfinancetransactions.getAnchorCrn());
        ps.setString(21, fgfinancetransactions.getInvNo());
        java.time.LocalDateTime val22 = fgfinancetransactions.getInvDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = fgfinancetransactions.getInvAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgfinancetransactions.getCounterPartyCrn());
        ps.setString(25, fgfinancetransactions.getCounterPartyName());
        ps.setString(26, fgfinancetransactions.getInputBranch());
        ps.setString(27, fgfinancetransactions.getBehalfOfBranch());
        ps.setString(28, fgfinancetransactions.getDebitPartyCrn());
        java.time.LocalDateTime val29 = fgfinancetransactions.getEffectiveDate();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        java.math.BigDecimal val30 = fgfinancetransactions.getFinancingAmount();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgfinancetransactions.getCreditPartyCrn());
        ps.setString(32, fgfinancetransactions.getCreditPartyName());
        java.math.BigDecimal val33 = fgfinancetransactions.getSpreadRate();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgfinancetransactions.getInterestRate();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgfinancetransactions.getMarginRate();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.time.LocalDateTime val36 = fgfinancetransactions.getMaturityDate();
        if (val36 != null) {
            ps.setTimestamp(36, java.sql.Timestamp.valueOf(val36));
        } else {
            ps.setNull(36, Types.TIMESTAMP);
        }
        java.math.BigDecimal val37 = fgfinancetransactions.getPenaltyPercent();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.time.LocalDateTime val38 = fgfinancetransactions.getIntStartDate();
        if (val38 != null) {
            ps.setTimestamp(38, java.sql.Timestamp.valueOf(val38));
        } else {
            ps.setNull(38, Types.TIMESTAMP);
        }
        ps.setString(39, fgfinancetransactions.getInterestType());
        java.math.BigDecimal val40 = fgfinancetransactions.getRateType();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgfinancetransactions.getBaseCode());
        java.math.BigDecimal val42 = fgfinancetransactions.getTenorInDays();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        java.math.BigDecimal val43 = fgfinancetransactions.getIntPeriodInDays();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, fgfinancetransactions.getProductType());
        java.math.BigDecimal val45 = fgfinancetransactions.getContractPeriod();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = fgfinancetransactions.getGracePeriod();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgfinancetransactions.getLimitNode1());
        ps.setString(48, fgfinancetransactions.getLimitNode2());
        ps.setString(49, fgfinancetransactions.getPaymentMode());
        ps.setString(50, fgfinancetransactions.getBeneBranch());
        ps.setString(51, fgfinancetransactions.getBeneAccNo());
        ps.setString(52, fgfinancetransactions.getStatus());
        Integer val53 = fgfinancetransactions.getBatchRefID();
        if (val53 != null) {
            ps.setInt(53, val53);
        } else {
            ps.setNull(53, Types.INTEGER);
        }
        ps.setString(54, fgfinancetransactions.getRemarks());
        java.math.BigDecimal val55 = fgfinancetransactions.getAdvanceInterest();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        java.math.BigDecimal val56 = fgfinancetransactions.getNetPayment();
        if (val56 != null) {
            ps.setBigDecimal(56, val56);
        } else {
            ps.setNull(56, Types.DECIMAL);
        }
        ps.setString(57, fgfinancetransactions.getValDate());
        ps.setString(58, fgfinancetransactions.getUtrNumber());
        java.math.BigDecimal val59 = fgfinancetransactions.getCharges();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        ps.setString(60, fgfinancetransactions.getTiStatus());
        Integer val61 = fgfinancetransactions.getTiBatchRefID();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        ps.setString(62, fgfinancetransactions.getTiRemarks());
        Integer val63 = fgfinancetransactions.getUploadRefID();
        if (val63 != null) {
            ps.setInt(63, val63);
        } else {
            ps.setNull(63, Types.INTEGER);
        }
        ps.setString(64, fgfinancetransactions.getEntitySubTypeCode());
        ps.setString(65, fgfinancetransactions.getEntityTypeCode());
        java.math.BigDecimal val66 = fgfinancetransactions.getFinanceFileGenerated();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        Integer val67 = fgfinancetransactions.getEntityRefID();
        if (val67 != null) {
            ps.setInt(67, val67);
        } else {
            ps.setNull(67, Types.INTEGER);
        }
        ps.setString(68, fgfinancetransactions.getFinanceRemarks());
        ps.setString(69, fgfinancetransactions.getSellerIDCrn());
        ps.setString(70, fgfinancetransactions.getBuyerIDCrn());
        ps.setString(71, fgfinancetransactions.getCpRole());
        ps.setString(72, fgfinancetransactions.getBeneLei());
        java.math.BigDecimal val73 = fgfinancetransactions.getFinanceAmount();
        if (val73 != null) {
            ps.setBigDecimal(73, val73);
        } else {
            ps.setNull(73, Types.DECIMAL);
        }
        Integer val74 = fgfinancetransactions.getLayoutTemplateID();
        if (val74 != null) {
            ps.setInt(74, val74);
        } else {
            ps.setNull(74, Types.INTEGER);
        }
        ps.setString(75, fgfinancetransactions.getLayoutName());
        ps.setString(76, fgfinancetransactions.getValueDate());
    }

    private FgFinanceTransactions extract(ResultSet rs) throws SQLException {
        FgFinanceTransactions fgfinancetransactions = new FgFinanceTransactions();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfinancetransactions.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfinancetransactions.setReferenceID(REFERENCE_ID);
        fgfinancetransactions.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfinancetransactions.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfinancetransactions.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfinancetransactions.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfinancetransactions.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgfinancetransactions.setProcessID(PROCESS_ID);
        fgfinancetransactions.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfinancetransactions.setCreatedBy(CREATED_BY);
        fgfinancetransactions.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfinancetransactions.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfinancetransactions.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfinancetransactions.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfinancetransactions.setTemplate(rs.getString(COL_TEMPLATE));
        fgfinancetransactions.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgfinancetransactions.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfinancetransactions.setIsTemplate(IS_TEMPLATE);
        fgfinancetransactions.setFileName(rs.getString(COL_FILE_NAME));
        fgfinancetransactions.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        fgfinancetransactions.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgfinancetransactions.setInvDate(INV_DATE.toLocalDateTime());
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        fgfinancetransactions.setInvAmt(INV_AMT);
        fgfinancetransactions.setCounterPartyCrn(rs.getString(COL_COUNTER_PARTY_CRN));
        fgfinancetransactions.setCounterPartyName(rs.getString(COL_COUNTER_PARTY_NAME));
        fgfinancetransactions.setInputBranch(rs.getString(COL_INPUT_BRANCH));
        fgfinancetransactions.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        fgfinancetransactions.setDebitPartyCrn(rs.getString(COL_DEBIT_PARTY_CRN));
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            fgfinancetransactions.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        java.math.BigDecimal FINANCING_AMOUNT = rs.getObject(COL_FINANCING_AMOUNT, java.math.BigDecimal.class);
        fgfinancetransactions.setFinancingAmount(FINANCING_AMOUNT);
        fgfinancetransactions.setCreditPartyCrn(rs.getString(COL_CREDIT_PARTY_CRN));
        fgfinancetransactions.setCreditPartyName(rs.getString(COL_CREDIT_PARTY_NAME));
        java.math.BigDecimal SPREAD_RATE = rs.getObject(COL_SPREAD_RATE, java.math.BigDecimal.class);
        fgfinancetransactions.setSpreadRate(SPREAD_RATE);
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        fgfinancetransactions.setInterestRate(INTEREST_RATE);
        java.math.BigDecimal MARGIN_RATE = rs.getObject(COL_MARGIN_RATE, java.math.BigDecimal.class);
        fgfinancetransactions.setMarginRate(MARGIN_RATE);
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            fgfinancetransactions.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        java.math.BigDecimal PENALTY_PERCENT = rs.getObject(COL_PENALTY_PERCENT, java.math.BigDecimal.class);
        fgfinancetransactions.setPenaltyPercent(PENALTY_PERCENT);
        Timestamp INT_START_DATE = rs.getTimestamp(COL_INT_START_DATE);
        if (INT_START_DATE != null)
            fgfinancetransactions.setIntStartDate(INT_START_DATE.toLocalDateTime());
        fgfinancetransactions.setInterestType(rs.getString(COL_INTEREST_TYPE));
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        fgfinancetransactions.setRateType(RATE_TYPE);
        fgfinancetransactions.setBaseCode(rs.getString(COL_BASE_CODE));
        java.math.BigDecimal TENOR_IN_DAYS = rs.getObject(COL_TENOR_IN_DAYS, java.math.BigDecimal.class);
        fgfinancetransactions.setTenorInDays(TENOR_IN_DAYS);
        java.math.BigDecimal INT_PERIOD_IN_DAYS = rs.getObject(COL_INT_PERIOD_IN_DAYS, java.math.BigDecimal.class);
        fgfinancetransactions.setIntPeriodInDays(INT_PERIOD_IN_DAYS);
        fgfinancetransactions.setProductType(rs.getString(COL_PRODUCT_TYPE));
        java.math.BigDecimal CONTRACT_PERIOD = rs.getObject(COL_CONTRACT_PERIOD, java.math.BigDecimal.class);
        fgfinancetransactions.setContractPeriod(CONTRACT_PERIOD);
        java.math.BigDecimal GRACE_PERIOD = rs.getObject(COL_GRACE_PERIOD, java.math.BigDecimal.class);
        fgfinancetransactions.setGracePeriod(GRACE_PERIOD);
        fgfinancetransactions.setLimitNode1(rs.getString(COL_LIMIT_NODE1));
        fgfinancetransactions.setLimitNode2(rs.getString(COL_LIMIT_NODE2));
        fgfinancetransactions.setPaymentMode(rs.getString(COL_PAYMENT_MODE));
        fgfinancetransactions.setBeneBranch(rs.getString(COL_BENE_BRANCH));
        fgfinancetransactions.setBeneAccNo(rs.getString(COL_BENE_ACC_NO));
        fgfinancetransactions.setStatus(rs.getString(COL_STATUS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgfinancetransactions.setBatchRefID(BATCH_REF_ID);
        fgfinancetransactions.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        fgfinancetransactions.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        fgfinancetransactions.setNetPayment(NET_PAYMENT);
        fgfinancetransactions.setValDate(rs.getString(COL_VAL_DATE));
        fgfinancetransactions.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        fgfinancetransactions.setCharges(CHARGES);
        fgfinancetransactions.setTiStatus(rs.getString(COL_TI_STATUS));
        Integer TI_BATCH_REF_ID = rs.getObject(COL_TI_BATCH_REF_ID, Integer.class);
        fgfinancetransactions.setTiBatchRefID(TI_BATCH_REF_ID);
        fgfinancetransactions.setTiRemarks(rs.getString(COL_TI_REMARKS));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfinancetransactions.setUploadRefID(UPLOAD_REF_ID);
        fgfinancetransactions.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgfinancetransactions.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        java.math.BigDecimal FINANCE_FILE_GENERATED = rs.getObject(COL_FINANCE_FILE_GENERATED, java.math.BigDecimal.class);
        fgfinancetransactions.setFinanceFileGenerated(FINANCE_FILE_GENERATED);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgfinancetransactions.setEntityRefID(ENTITY_REF_ID);
        fgfinancetransactions.setFinanceRemarks(rs.getString(COL_FINANCE_REMARKS));
        fgfinancetransactions.setSellerIDCrn(rs.getString(COL_SELLER_ID_CRN));
        fgfinancetransactions.setBuyerIDCrn(rs.getString(COL_BUYER_ID_CRN));
        fgfinancetransactions.setCpRole(rs.getString(COL_CP_ROLE));
        fgfinancetransactions.setBeneLei(rs.getString(COL_BENE_LEI));
        java.math.BigDecimal FINANCE_AMOUNT = rs.getObject(COL_FINANCE_AMOUNT, java.math.BigDecimal.class);
        fgfinancetransactions.setFinanceAmount(FINANCE_AMOUNT);
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgfinancetransactions.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fgfinancetransactions.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        fgfinancetransactions.setValueDate(rs.getString(COL_VALUE_DATE));
        return fgfinancetransactions;
    }
}
