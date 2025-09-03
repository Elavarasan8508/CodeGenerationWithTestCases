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

public class JdbcFinReqBatchItemDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFinReqBatchItemDao.class);

    private static final String TABLE = "FIN_REQ_BATCH_ITEM";

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

    private static final String COL_BATCH_REF_NUM = "BATCH_REF_NUM";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_INSTRUMENT_ID = "INSTRUMENT_ID";

    private static final String COL_LOAN_DUE_DATE = "LOAN_DUE_DATE";

    private static final String COL_REQUEST_AMOUNT = "REQUEST_AMOUNT";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_FILE_CONTENT = "FILE_CONTENT";

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_TNX_REF_ID = "TNX_REF_ID";

    private static final String COL_FINANCE_AMOUNT = "FINANCE_AMOUNT";

    private static final String COL_FINANCING_AMOUNT = "FINANCING_AMOUNT";

    private static final String COL_TENOR_IN_DAYS = "TENOR_IN_DAYS";

    private static final String COL_INT_PERIOD_IN_DAYS = "INT_PERIOD_IN_DAYS";

    private static final String COL_CONTRACT_PERIOD = "CONTRACT_PERIOD";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_REMOVE_BATCH_ITEM = "REMOVE_BATCH_ITEM";

    private static final String COL_TXN_TYPE_CODE = "TXN_TYPE_CODE";

    private static final String COL_TXN_SUB_TYPE_CODE = "TXN_SUB_TYPE_CODE";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_CP_CODE = "CP_CODE";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_TNX_DISPLAY_REMARKS = "TNX_DISPLAY_REMARKS";

    private static final String COL_TNX_DISPLAY_BATCH_ID = "TNX_DISPLAY_BATCH_ID";

    private static final String COL_TNX_DISPLAY_STATUS = "TNX_DISPLAY_STATUS";

    private static final String COL_PAYMENT_MODE = "PAYMENT_MODE";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_ANCHOR_NAME = "ANCHOR_NAME";

    private static final String COL_COUNTER_PARTY_CRN = "COUNTER_PARTY_CRN";

    private static final String COL_COUNTER_PARTY_NAME = "COUNTER_PARTY_NAME";

    private static final String COL_INPUT_BRANCH = "INPUT_BRANCH";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_DEBIT_PARTY_CRN = "DEBIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_CRN = "CREDIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_NAME = "CREDIT_PARTY_NAME";

    private static final String COL_SPREAD_RATE = "SPREAD_RATE";

    private static final String COL_MARGIN_RATE = "MARGIN_RATE";

    private static final String COL_PENALTY_PERCENT = "PENALTY_PERCENT";

    private static final String COL_INTEREST_TYPE = "INTEREST_TYPE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_BASE_CODE = "BASE_CODE";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_GRACE_PERIOD = "GRACE_PERIOD";

    private static final String COL_LIMIT_NODE1 = "LIMIT_NODE1";

    private static final String COL_LIMIT_NODE2 = "LIMIT_NODE2";

    private static final String COL_BENE_BRANCH = "BENE_BRANCH";

    private static final String COL_BENE_ACC_NO = "BENE_ACC_NO";

    private static final String COL_SELLER_ID_CRN = "SELLER_ID_CRN";

    private static final String COL_BUYER_ID_CRN = "BUYER_ID_CRN";

    private static final String COL_CP_ROLE = "CP_ROLE";

    private static final String COL_BENE_LEI = "BENE_LEI";

    private static final String COL_ADVANCE_INTEREST = "ADVANCE_INTEREST";

    private static final String COL_NET_PAYMENT = "NET_PAYMENT";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_UTR_NUMBER = "UTR_NUMBER";

    private static final String COL_CHARGES = "CHARGES";

    private static final String COL_UTR_DATE = "UTR_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_BATCH_REF_NUM, COL_UPLOAD_REF_ID, COL_INSTRUMENT_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_INVOICE_AMOUNT, COL_FILE_CONTENT, COL_CUSTOMER_CRN, COL_TNX_REF_ID, COL_FINANCE_AMOUNT, COL_FINANCING_AMOUNT, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_CONTRACT_PERIOD, COL_PARENT_REF_ID, COL_INV_NO, COL_INV_DATE, COL_INV_AMT, COL_MATURITY_DATE, COL_REMOVE_BATCH_ITEM, COL_TXN_TYPE_CODE, COL_TXN_SUB_TYPE_CODE, COL_PARENT_VERSION_ID, COL_LAYOUT_ID, COL_CP_CODE, COL_FILE_NAME, COL_TNX_DISPLAY_REMARKS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_STATUS, COL_PAYMENT_MODE, COL_INTEREST_RATE, COL_ANCHOR_NAME, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SPREAD_RATE, COL_MARGIN_RATE, COL_PENALTY_PERCENT, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE1, COL_LIMIT_NODE2, COL_BENE_BRANCH, COL_BENE_ACC_NO, COL_SELLER_ID_CRN, COL_BUYER_ID_CRN, COL_CP_ROLE, COL_BENE_LEI, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_UTR_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BATCH_REF_NUM, UPLOAD_REF_ID, INSTRUMENT_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, INVOICE_AMOUNT, FILE_CONTENT, CUSTOMER_CRN, TNX_REF_ID, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, PARENT_REF_ID, INV_NO, INV_DATE, INV_AMT, MATURITY_DATE, REMOVE_BATCH_ITEM, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE, PARENT_VERSION_ID, LAYOUT_ID, CP_CODE, FILE_NAME, TNX_DISPLAY_REMARKS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_STATUS, PAYMENT_MODE, INTEREST_RATE, ANCHOR_NAME, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, MARGIN_RATE, PENALTY_PERCENT, INTEREST_TYPE, RATE_TYPE, BASE_CODE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, BENE_BRANCH, BENE_ACC_NO, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, UTR_DATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BATCH_REF_NUM, UPLOAD_REF_ID, INSTRUMENT_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, INVOICE_AMOUNT, FILE_CONTENT, CUSTOMER_CRN, TNX_REF_ID, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, PARENT_REF_ID, INV_NO, INV_DATE, INV_AMT, MATURITY_DATE, REMOVE_BATCH_ITEM, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE, PARENT_VERSION_ID, LAYOUT_ID, CP_CODE, FILE_NAME, TNX_DISPLAY_REMARKS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_STATUS, PAYMENT_MODE, INTEREST_RATE, ANCHOR_NAME, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, MARGIN_RATE, PENALTY_PERCENT, INTEREST_TYPE, RATE_TYPE, BASE_CODE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, BENE_BRANCH, BENE_ACC_NO, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, UTR_DATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_BATCH_REF_NUM, COL_UPLOAD_REF_ID, COL_INSTRUMENT_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_INVOICE_AMOUNT, COL_FILE_CONTENT, COL_CUSTOMER_CRN, COL_TNX_REF_ID, COL_FINANCE_AMOUNT, COL_FINANCING_AMOUNT, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_CONTRACT_PERIOD, COL_PARENT_REF_ID, COL_INV_NO, COL_INV_DATE, COL_INV_AMT, COL_MATURITY_DATE, COL_REMOVE_BATCH_ITEM, COL_TXN_TYPE_CODE, COL_TXN_SUB_TYPE_CODE, COL_PARENT_VERSION_ID, COL_LAYOUT_ID, COL_CP_CODE, COL_FILE_NAME, COL_TNX_DISPLAY_REMARKS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_STATUS, COL_PAYMENT_MODE, COL_INTEREST_RATE, COL_ANCHOR_NAME, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SPREAD_RATE, COL_MARGIN_RATE, COL_PENALTY_PERCENT, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE1, COL_LIMIT_NODE2, COL_BENE_BRANCH, COL_BENE_ACC_NO, COL_SELLER_ID_CRN, COL_BUYER_ID_CRN, COL_CP_ROLE, COL_BENE_LEI, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_UTR_DATE, COL_ID);

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

    public int insert(Connection conn, FinReqBatchItem finreqbatchitem) throws SQLException {
        logger.debug("Inserting finreqbatchitem: {}", finreqbatchitem);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFinReqBatchItemParams(ps, finreqbatchitem);
            ps.executeUpdate();
            return finreqbatchitem.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FinReqBatchItem> finreqbatchitems) throws SQLException {
        if (finreqbatchitems == null || finreqbatchitems.isEmpty())
            return new int[0];
        for (int i = 0; i < finreqbatchitems.size(); i++) {
            if (finreqbatchitems.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FinReqBatchItem>> batches = chunkList(finreqbatchitems, batchSize);
        int[] totalResults = new int[finreqbatchitems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FinReqBatchItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FinReqBatchItem finreqbatchitem : batch) {
                        setFinReqBatchItemParams(ps, finreqbatchitem);
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

    public FinReqBatchItem findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FinReqBatchItem> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FinReqBatchItem> list = new ArrayList<>();
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

    public boolean update(Connection conn, FinReqBatchItem finreqbatchitem) throws SQLException {
        if (finreqbatchitem.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFinReqBatchItemParams(ps, finreqbatchitem);
            ps.setInt(79, finreqbatchitem.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FinReqBatchItem> finreqbatchitems) throws SQLException {
        if (finreqbatchitems == null || finreqbatchitems.isEmpty())
            return new int[0];
        for (FinReqBatchItem finreqbatchitem : finreqbatchitems) {
            if (finreqbatchitem == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (finreqbatchitem.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FinReqBatchItem>> batches = chunkList(finreqbatchitems, batchSize);
        int[] totalResults = new int[finreqbatchitems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FinReqBatchItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FinReqBatchItem finreqbatchitem : batch) {
                        setFinReqBatchItemParams(ps, finreqbatchitem);
                        ps.setInt(79, finreqbatchitem.getID());
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

    private void setFinReqBatchItemParams(PreparedStatement ps, FinReqBatchItem finreqbatchitem) throws SQLException {
        Integer val1 = finreqbatchitem.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = finreqbatchitem.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, finreqbatchitem.getTypeCode());
        ps.setString(4, finreqbatchitem.getSubTypeCode());
        ps.setString(5, finreqbatchitem.getActiveCode());
        ps.setString(6, finreqbatchitem.getStageCode());
        ps.setString(7, finreqbatchitem.getStatusCode());
        Integer val8 = finreqbatchitem.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, finreqbatchitem.getCreatedOn());
        java.math.BigDecimal val10 = finreqbatchitem.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, finreqbatchitem.getLastUpdatedOn());
        java.math.BigDecimal val12 = finreqbatchitem.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, finreqbatchitem.getLastAuthorisedOn());
        java.math.BigDecimal val14 = finreqbatchitem.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, finreqbatchitem.getTemplate());
        ps.setString(16, finreqbatchitem.getApplicantParty());
        ps.setString(17, finreqbatchitem.getFulfillmentParty());
        java.math.BigDecimal val18 = finreqbatchitem.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, finreqbatchitem.getBatchRefNum());
        Integer val20 = finreqbatchitem.getUploadRefID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = finreqbatchitem.getInstrumentID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.time.LocalDateTime val22 = finreqbatchitem.getLoanDueDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = finreqbatchitem.getRequestAmount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = finreqbatchitem.getInvoiceAmount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, finreqbatchitem.getFileContent());
        ps.setString(26, finreqbatchitem.getCustomerCrn());
        Integer val27 = finreqbatchitem.getTnxRefID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = finreqbatchitem.getFinanceAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = finreqbatchitem.getFinancingAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = finreqbatchitem.getTenorInDays();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = finreqbatchitem.getIntPeriodInDays();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = finreqbatchitem.getContractPeriod();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        Integer val33 = finreqbatchitem.getParentRefID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        ps.setString(34, finreqbatchitem.getInvNo());
        java.time.LocalDateTime val35 = finreqbatchitem.getInvDate();
        if (val35 != null) {
            ps.setTimestamp(35, java.sql.Timestamp.valueOf(val35));
        } else {
            ps.setNull(35, Types.TIMESTAMP);
        }
        java.math.BigDecimal val36 = finreqbatchitem.getInvAmt();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.time.LocalDateTime val37 = finreqbatchitem.getMaturityDate();
        if (val37 != null) {
            ps.setTimestamp(37, java.sql.Timestamp.valueOf(val37));
        } else {
            ps.setNull(37, Types.TIMESTAMP);
        }
        java.math.BigDecimal val38 = finreqbatchitem.getRemoveBatchItem();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, finreqbatchitem.getTxnTypeCode());
        ps.setString(40, finreqbatchitem.getTxnSubTypeCode());
        Integer val41 = finreqbatchitem.getParentVersionID();
        if (val41 != null) {
            ps.setInt(41, val41);
        } else {
            ps.setNull(41, Types.INTEGER);
        }
        Integer val42 = finreqbatchitem.getLayoutID();
        if (val42 != null) {
            ps.setInt(42, val42);
        } else {
            ps.setNull(42, Types.INTEGER);
        }
        ps.setString(43, finreqbatchitem.getCpCode());
        ps.setString(44, finreqbatchitem.getFileName());
        ps.setString(45, finreqbatchitem.getTnxDisplayRemarks());
        Integer val46 = finreqbatchitem.getTnxDisplayBatchID();
        if (val46 != null) {
            ps.setInt(46, val46);
        } else {
            ps.setNull(46, Types.INTEGER);
        }
        ps.setString(47, finreqbatchitem.getTnxDisplayStatus());
        ps.setString(48, finreqbatchitem.getPaymentMode());
        java.math.BigDecimal val49 = finreqbatchitem.getInterestRate();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        ps.setString(50, finreqbatchitem.getAnchorName());
        ps.setString(51, finreqbatchitem.getCounterPartyCrn());
        ps.setString(52, finreqbatchitem.getCounterPartyName());
        ps.setString(53, finreqbatchitem.getInputBranch());
        ps.setString(54, finreqbatchitem.getBehalfOfBranch());
        ps.setString(55, finreqbatchitem.getDebitPartyCrn());
        ps.setString(56, finreqbatchitem.getCreditPartyCrn());
        ps.setString(57, finreqbatchitem.getCreditPartyName());
        java.math.BigDecimal val58 = finreqbatchitem.getSpreadRate();
        if (val58 != null) {
            ps.setBigDecimal(58, val58);
        } else {
            ps.setNull(58, Types.DECIMAL);
        }
        java.math.BigDecimal val59 = finreqbatchitem.getMarginRate();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        java.math.BigDecimal val60 = finreqbatchitem.getPenaltyPercent();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        ps.setString(61, finreqbatchitem.getInterestType());
        java.math.BigDecimal val62 = finreqbatchitem.getRateType();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        ps.setString(63, finreqbatchitem.getBaseCode());
        ps.setString(64, finreqbatchitem.getProductType());
        java.math.BigDecimal val65 = finreqbatchitem.getGracePeriod();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        ps.setString(66, finreqbatchitem.getLimitNode1());
        ps.setString(67, finreqbatchitem.getLimitNode2());
        ps.setString(68, finreqbatchitem.getBeneBranch());
        ps.setString(69, finreqbatchitem.getBeneAccNo());
        ps.setString(70, finreqbatchitem.getSellerIDCrn());
        ps.setString(71, finreqbatchitem.getBuyerIDCrn());
        ps.setString(72, finreqbatchitem.getCpRole());
        ps.setString(73, finreqbatchitem.getBeneLei());
        java.math.BigDecimal val74 = finreqbatchitem.getAdvanceInterest();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        java.math.BigDecimal val75 = finreqbatchitem.getNetPayment();
        if (val75 != null) {
            ps.setBigDecimal(75, val75);
        } else {
            ps.setNull(75, Types.DECIMAL);
        }
        ps.setString(76, finreqbatchitem.getValueDate());
        ps.setString(77, finreqbatchitem.getUtrNumber());
        java.math.BigDecimal val78 = finreqbatchitem.getCharges();
        if (val78 != null) {
            ps.setBigDecimal(78, val78);
        } else {
            ps.setNull(78, Types.DECIMAL);
        }
        java.time.LocalDateTime val79 = finreqbatchitem.getUtrDate();
        if (val79 != null) {
            ps.setTimestamp(79, java.sql.Timestamp.valueOf(val79));
        } else {
            ps.setNull(79, Types.TIMESTAMP);
        }
    }

    private FinReqBatchItem extract(ResultSet rs) throws SQLException {
        FinReqBatchItem finreqbatchitem = new FinReqBatchItem();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        finreqbatchitem.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        finreqbatchitem.setReferenceID(REFERENCE_ID);
        finreqbatchitem.setTypeCode(rs.getString(COL_TYPE_CODE));
        finreqbatchitem.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        finreqbatchitem.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        finreqbatchitem.setStageCode(rs.getString(COL_STAGE_CODE));
        finreqbatchitem.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        finreqbatchitem.setProcessID(PROCESS_ID);
        finreqbatchitem.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        finreqbatchitem.setCreatedBy(CREATED_BY);
        finreqbatchitem.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        finreqbatchitem.setLastUpdatedBy(LAST_UPDATED_BY);
        finreqbatchitem.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        finreqbatchitem.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        finreqbatchitem.setTemplate(rs.getString(COL_TEMPLATE));
        finreqbatchitem.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        finreqbatchitem.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        finreqbatchitem.setIsTemplate(IS_TEMPLATE);
        finreqbatchitem.setBatchRefNum(rs.getString(COL_BATCH_REF_NUM));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        finreqbatchitem.setUploadRefID(UPLOAD_REF_ID);
        Integer INSTRUMENT_ID = rs.getObject(COL_INSTRUMENT_ID, Integer.class);
        finreqbatchitem.setInstrumentID(INSTRUMENT_ID);
        Timestamp LOAN_DUE_DATE = rs.getTimestamp(COL_LOAN_DUE_DATE);
        if (LOAN_DUE_DATE != null)
            finreqbatchitem.setLoanDueDate(LOAN_DUE_DATE.toLocalDateTime());
        java.math.BigDecimal REQUEST_AMOUNT = rs.getObject(COL_REQUEST_AMOUNT, java.math.BigDecimal.class);
        finreqbatchitem.setRequestAmount(REQUEST_AMOUNT);
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        finreqbatchitem.setInvoiceAmount(INVOICE_AMOUNT);
        finreqbatchitem.setFileContent(rs.getString(COL_FILE_CONTENT));
        finreqbatchitem.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        Integer TNX_REF_ID = rs.getObject(COL_TNX_REF_ID, Integer.class);
        finreqbatchitem.setTnxRefID(TNX_REF_ID);
        java.math.BigDecimal FINANCE_AMOUNT = rs.getObject(COL_FINANCE_AMOUNT, java.math.BigDecimal.class);
        finreqbatchitem.setFinanceAmount(FINANCE_AMOUNT);
        java.math.BigDecimal FINANCING_AMOUNT = rs.getObject(COL_FINANCING_AMOUNT, java.math.BigDecimal.class);
        finreqbatchitem.setFinancingAmount(FINANCING_AMOUNT);
        java.math.BigDecimal TENOR_IN_DAYS = rs.getObject(COL_TENOR_IN_DAYS, java.math.BigDecimal.class);
        finreqbatchitem.setTenorInDays(TENOR_IN_DAYS);
        java.math.BigDecimal INT_PERIOD_IN_DAYS = rs.getObject(COL_INT_PERIOD_IN_DAYS, java.math.BigDecimal.class);
        finreqbatchitem.setIntPeriodInDays(INT_PERIOD_IN_DAYS);
        java.math.BigDecimal CONTRACT_PERIOD = rs.getObject(COL_CONTRACT_PERIOD, java.math.BigDecimal.class);
        finreqbatchitem.setContractPeriod(CONTRACT_PERIOD);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        finreqbatchitem.setParentRefID(PARENT_REF_ID);
        finreqbatchitem.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            finreqbatchitem.setInvDate(INV_DATE.toLocalDateTime());
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        finreqbatchitem.setInvAmt(INV_AMT);
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            finreqbatchitem.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        java.math.BigDecimal REMOVE_BATCH_ITEM = rs.getObject(COL_REMOVE_BATCH_ITEM, java.math.BigDecimal.class);
        finreqbatchitem.setRemoveBatchItem(REMOVE_BATCH_ITEM);
        finreqbatchitem.setTxnTypeCode(rs.getString(COL_TXN_TYPE_CODE));
        finreqbatchitem.setTxnSubTypeCode(rs.getString(COL_TXN_SUB_TYPE_CODE));
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        finreqbatchitem.setParentVersionID(PARENT_VERSION_ID);
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        finreqbatchitem.setLayoutID(LAYOUT_ID);
        finreqbatchitem.setCpCode(rs.getString(COL_CP_CODE));
        finreqbatchitem.setFileName(rs.getString(COL_FILE_NAME));
        finreqbatchitem.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        Integer TNX_DISPLAY_BATCH_ID = rs.getObject(COL_TNX_DISPLAY_BATCH_ID, Integer.class);
        finreqbatchitem.setTnxDisplayBatchID(TNX_DISPLAY_BATCH_ID);
        finreqbatchitem.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        finreqbatchitem.setPaymentMode(rs.getString(COL_PAYMENT_MODE));
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        finreqbatchitem.setInterestRate(INTEREST_RATE);
        finreqbatchitem.setAnchorName(rs.getString(COL_ANCHOR_NAME));
        finreqbatchitem.setCounterPartyCrn(rs.getString(COL_COUNTER_PARTY_CRN));
        finreqbatchitem.setCounterPartyName(rs.getString(COL_COUNTER_PARTY_NAME));
        finreqbatchitem.setInputBranch(rs.getString(COL_INPUT_BRANCH));
        finreqbatchitem.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        finreqbatchitem.setDebitPartyCrn(rs.getString(COL_DEBIT_PARTY_CRN));
        finreqbatchitem.setCreditPartyCrn(rs.getString(COL_CREDIT_PARTY_CRN));
        finreqbatchitem.setCreditPartyName(rs.getString(COL_CREDIT_PARTY_NAME));
        java.math.BigDecimal SPREAD_RATE = rs.getObject(COL_SPREAD_RATE, java.math.BigDecimal.class);
        finreqbatchitem.setSpreadRate(SPREAD_RATE);
        java.math.BigDecimal MARGIN_RATE = rs.getObject(COL_MARGIN_RATE, java.math.BigDecimal.class);
        finreqbatchitem.setMarginRate(MARGIN_RATE);
        java.math.BigDecimal PENALTY_PERCENT = rs.getObject(COL_PENALTY_PERCENT, java.math.BigDecimal.class);
        finreqbatchitem.setPenaltyPercent(PENALTY_PERCENT);
        finreqbatchitem.setInterestType(rs.getString(COL_INTEREST_TYPE));
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        finreqbatchitem.setRateType(RATE_TYPE);
        finreqbatchitem.setBaseCode(rs.getString(COL_BASE_CODE));
        finreqbatchitem.setProductType(rs.getString(COL_PRODUCT_TYPE));
        java.math.BigDecimal GRACE_PERIOD = rs.getObject(COL_GRACE_PERIOD, java.math.BigDecimal.class);
        finreqbatchitem.setGracePeriod(GRACE_PERIOD);
        finreqbatchitem.setLimitNode1(rs.getString(COL_LIMIT_NODE1));
        finreqbatchitem.setLimitNode2(rs.getString(COL_LIMIT_NODE2));
        finreqbatchitem.setBeneBranch(rs.getString(COL_BENE_BRANCH));
        finreqbatchitem.setBeneAccNo(rs.getString(COL_BENE_ACC_NO));
        finreqbatchitem.setSellerIDCrn(rs.getString(COL_SELLER_ID_CRN));
        finreqbatchitem.setBuyerIDCrn(rs.getString(COL_BUYER_ID_CRN));
        finreqbatchitem.setCpRole(rs.getString(COL_CP_ROLE));
        finreqbatchitem.setBeneLei(rs.getString(COL_BENE_LEI));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        finreqbatchitem.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        finreqbatchitem.setNetPayment(NET_PAYMENT);
        finreqbatchitem.setValueDate(rs.getString(COL_VALUE_DATE));
        finreqbatchitem.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        finreqbatchitem.setCharges(CHARGES);
        Timestamp UTR_DATE = rs.getTimestamp(COL_UTR_DATE);
        if (UTR_DATE != null)
            finreqbatchitem.setUtrDate(UTR_DATE.toLocalDateTime());
        return finreqbatchitem;
    }
}
