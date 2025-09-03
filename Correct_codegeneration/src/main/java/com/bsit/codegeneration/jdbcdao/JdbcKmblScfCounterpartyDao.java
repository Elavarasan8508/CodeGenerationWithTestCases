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

public class JdbcKmblScfCounterpartyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcKmblScfCounterpartyDao.class);

    private static final String TABLE = "KMBL_SCF_COUNTERPARTY";

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

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ABBV_NAME = "ABBV_NAME";

    private static final String COL_NAME = "NAME";

    private static final String COL_CUSTOMER_ROLE = "CUSTOMER_ROLE";

    private static final String COL_INPUT_BRANCH = "INPUT_BRANCH";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static final String COL_IFSC_CODE = "IFSC_CODE";

    private static final String COL_BANK_NAME = "BANK_NAME";

    private static final String COL_LIMIT_NODE_1 = "LIMIT_NODE_1";

    private static final String COL_PAYMENT_TYPE = "PAYMENT_TYPE";

    private static final String COL_INT_BEARING_PARTY = "INT_BEARING_PARTY";

    private static final String COL_DEBIT_PARTY = "DEBIT_PARTY";

    private static final String COL_INT_TYPE = "INT_TYPE";

    private static final String COL_BASE_CODE = "BASE_CODE";

    private static final String COL_PENEL_SPREAD = "PENEL_SPREAD";

    private static final String COL_CP_ABBV_NAME = "CP_ABBV_NAME";

    private static final String COL_CP_NAME = "CP_NAME";

    private static final String COL_CP_CODE = "CP_CODE";

    private static final String COL_CP_ROLE = "CP_ROLE";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_GRACE_PERIOD = "GRACE_PERIOD";

    private static final String COL_LIMIT_NODE_2 = "LIMIT_NODE_2";

    private static final String COL_MARGIN_RATE = "MARGIN_RATE";

    private static final String COL_SPREAD_RATE = "SPREAD_RATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_DEBIT_PARTY_CRN = "DEBIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_CRN = "CREDIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_NAME = "CREDIT_PARTY_NAME";

    private static final String COL_SELLER_ID_CRN = "SELLER_ID_CRN";

    private static final String COL_CP_STATUS = "CP_STATUS";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_ANC_ACCOUNT_NUMBER = "ANC_ACCOUNT_NUMBER";

    private static final String COL_ANC_IFSC_CODE = "ANC_IFSC_CODE";

    private static final String COL_ANC_BANK_NAME = "ANC_BANK_NAME";

    private static final String COL_ANC_PAYMENT_TYPE = "ANC_PAYMENT_TYPE";

    private static final String COL_ANC_INT_TYPE = "ANC_INT_TYPE";

    private static final String COL_ANC_PENAL_SPREAD = "ANC_PENAL_SPREAD";

    private static final String COL_ANC_BASE_CODE = "ANC_BASE_CODE";

    private static final String COL_ANC_SPREAD_RATE = "ANC_SPREAD_RATE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_BUYER_ID_CRN = "BUYER_ID_CRN";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_BASE_RATE = "BASE_RATE";

    private static final String COL_MIGRATION_STATUS = "MIGRATION_STATUS";

    private static final String COL_MIGRATION_DATE = "MIGRATION_DATE";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_ANC_BENE_LEI = "ANC_BENE_LEI";

    private static final String COL_ACTIVE_PERIOD_UOM = "ACTIVE_PERIOD_UOM";

    private static final String COL_ACTIVE_PERIOD = "ACTIVE_PERIOD";

    private static final String COL_ACTV_DATE_FIELD = "ACTV_DATE_FIELD";

    private static final String COL_LOAN_REPAYMENT_DATE = "LOAN_REPAYMENT_DATE";

    private static final String COL_LOAN_TENOR = "LOAN_TENOR";

    private static final String COL_LOAN_TENOR_UOM = "LOAN_TENOR_UOM";

    private static final String COL_PROGRAM_LAYOUT_NAME = "PROGRAM_LAYOUT_NAME";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_ACTV_DATE_DISPLAY = "ACTV_DATE_DISPLAY";

    private static final String COL_LOAN_TENOR_DAYS = "LOAN_TENOR_DAYS";

    private static final String COL_LOAN_TENOR_DISPLAY = "LOAN_TENOR_DISPLAY";

    private static final String COL_LOAN_REPAYMENT_DATE_DISPLAY = "LOAN_REPAYMENT_DATE_DISPLAY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ABBV_NAME, COL_NAME, COL_CUSTOMER_ROLE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_ACCOUNT_NUMBER, COL_IFSC_CODE, COL_BANK_NAME, COL_LIMIT_NODE_1, COL_PAYMENT_TYPE, COL_INT_BEARING_PARTY, COL_DEBIT_PARTY, COL_INT_TYPE, COL_BASE_CODE, COL_PENEL_SPREAD, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE_2, COL_MARGIN_RATE, COL_SPREAD_RATE, COL_UPLOAD_REF_ID, COL_INTEREST_RATE, COL_RATE_TYPE, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SELLER_ID_CRN, COL_CP_STATUS, COL_DISPLAY_STATUS, COL_LINE_NO, COL_ANC_ACCOUNT_NUMBER, COL_ANC_IFSC_CODE, COL_ANC_BANK_NAME, COL_ANC_PAYMENT_TYPE, COL_ANC_INT_TYPE, COL_ANC_PENAL_SPREAD, COL_ANC_BASE_CODE, COL_ANC_SPREAD_RATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_BUYER_ID_CRN, COL_LAYOUT_NAME, COL_TASK_REASON, COL_BASE_RATE, COL_MIGRATION_STATUS, COL_MIGRATION_DATE, COL_DMS_EVENT_ID, COL_ANC_BENE_LEI, COL_ACTIVE_PERIOD_UOM, COL_ACTIVE_PERIOD, COL_ACTV_DATE_FIELD, COL_LOAN_REPAYMENT_DATE, COL_LOAN_TENOR, COL_LOAN_TENOR_UOM, COL_PROGRAM_LAYOUT_NAME, COL_LAYOUT_ID, COL_LAYOUT_UUID, COL_ACTV_DATE_DISPLAY, COL_LOAN_TENOR_DAYS, COL_LOAN_TENOR_DISPLAY, COL_LOAN_REPAYMENT_DATE_DISPLAY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SELLER_ID_CRN, CP_STATUS, DISPLAY_STATUS, LINE_NO, ANC_ACCOUNT_NUMBER, ANC_IFSC_CODE, ANC_BANK_NAME, ANC_PAYMENT_TYPE, ANC_INT_TYPE, ANC_PENAL_SPREAD, ANC_BASE_CODE, ANC_SPREAD_RATE, VERSION_ID, IS_MASTER_VERSION, BUYER_ID_CRN, LAYOUT_NAME, TASK_REASON, BASE_RATE, MIGRATION_STATUS, MIGRATION_DATE, DMS_EVENT_ID, ANC_BENE_LEI, ACTIVE_PERIOD_UOM, ACTIVE_PERIOD, ACTV_DATE_FIELD, LOAN_REPAYMENT_DATE, LOAN_TENOR, LOAN_TENOR_UOM, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID, ACTV_DATE_DISPLAY, LOAN_TENOR_DAYS, LOAN_TENOR_DISPLAY, LOAN_REPAYMENT_DATE_DISPLAY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SELLER_ID_CRN, CP_STATUS, DISPLAY_STATUS, LINE_NO, ANC_ACCOUNT_NUMBER, ANC_IFSC_CODE, ANC_BANK_NAME, ANC_PAYMENT_TYPE, ANC_INT_TYPE, ANC_PENAL_SPREAD, ANC_BASE_CODE, ANC_SPREAD_RATE, VERSION_ID, IS_MASTER_VERSION, BUYER_ID_CRN, LAYOUT_NAME, TASK_REASON, BASE_RATE, MIGRATION_STATUS, MIGRATION_DATE, DMS_EVENT_ID, ANC_BENE_LEI, ACTIVE_PERIOD_UOM, ACTIVE_PERIOD, ACTV_DATE_FIELD, LOAN_REPAYMENT_DATE, LOAN_TENOR, LOAN_TENOR_UOM, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID, ACTV_DATE_DISPLAY, LOAN_TENOR_DAYS, LOAN_TENOR_DISPLAY, LOAN_REPAYMENT_DATE_DISPLAY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ABBV_NAME, COL_NAME, COL_CUSTOMER_ROLE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_ACCOUNT_NUMBER, COL_IFSC_CODE, COL_BANK_NAME, COL_LIMIT_NODE_1, COL_PAYMENT_TYPE, COL_INT_BEARING_PARTY, COL_DEBIT_PARTY, COL_INT_TYPE, COL_BASE_CODE, COL_PENEL_SPREAD, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE_2, COL_MARGIN_RATE, COL_SPREAD_RATE, COL_UPLOAD_REF_ID, COL_INTEREST_RATE, COL_RATE_TYPE, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_SELLER_ID_CRN, COL_CP_STATUS, COL_DISPLAY_STATUS, COL_LINE_NO, COL_ANC_ACCOUNT_NUMBER, COL_ANC_IFSC_CODE, COL_ANC_BANK_NAME, COL_ANC_PAYMENT_TYPE, COL_ANC_INT_TYPE, COL_ANC_PENAL_SPREAD, COL_ANC_BASE_CODE, COL_ANC_SPREAD_RATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_BUYER_ID_CRN, COL_LAYOUT_NAME, COL_TASK_REASON, COL_BASE_RATE, COL_MIGRATION_STATUS, COL_MIGRATION_DATE, COL_DMS_EVENT_ID, COL_ANC_BENE_LEI, COL_ACTIVE_PERIOD_UOM, COL_ACTIVE_PERIOD, COL_ACTV_DATE_FIELD, COL_LOAN_REPAYMENT_DATE, COL_LOAN_TENOR, COL_LOAN_TENOR_UOM, COL_PROGRAM_LAYOUT_NAME, COL_LAYOUT_ID, COL_LAYOUT_UUID, COL_ACTV_DATE_DISPLAY, COL_LOAN_TENOR_DAYS, COL_LOAN_TENOR_DISPLAY, COL_LOAN_REPAYMENT_DATE_DISPLAY, COL_ID);

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

    public int insert(Connection conn, KmblScfCounterparty kmblscfcounterparty) throws SQLException {
        logger.debug("Inserting kmblscfcounterparty: {}", kmblscfcounterparty);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setKmblScfCounterpartyParams(ps, kmblscfcounterparty);
            ps.executeUpdate();
            return kmblscfcounterparty.getID();
        }
    }

    public int[] insertAll(Connection conn, List<KmblScfCounterparty> kmblscfcounterpartys) throws SQLException {
        if (kmblscfcounterpartys == null || kmblscfcounterpartys.isEmpty())
            return new int[0];
        for (int i = 0; i < kmblscfcounterpartys.size(); i++) {
            if (kmblscfcounterpartys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfCounterparty>> batches = chunkList(kmblscfcounterpartys, batchSize);
        int[] totalResults = new int[kmblscfcounterpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfCounterparty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (KmblScfCounterparty kmblscfcounterparty : batch) {
                        setKmblScfCounterpartyParams(ps, kmblscfcounterparty);
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

    public KmblScfCounterparty findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<KmblScfCounterparty> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<KmblScfCounterparty> list = new ArrayList<>();
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

    public boolean update(Connection conn, KmblScfCounterparty kmblscfcounterparty) throws SQLException {
        if (kmblscfcounterparty.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setKmblScfCounterpartyParams(ps, kmblscfcounterparty);
            ps.setInt(83, kmblscfcounterparty.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<KmblScfCounterparty> kmblscfcounterpartys) throws SQLException {
        if (kmblscfcounterpartys == null || kmblscfcounterpartys.isEmpty())
            return new int[0];
        for (KmblScfCounterparty kmblscfcounterparty : kmblscfcounterpartys) {
            if (kmblscfcounterparty == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (kmblscfcounterparty.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfCounterparty>> batches = chunkList(kmblscfcounterpartys, batchSize);
        int[] totalResults = new int[kmblscfcounterpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfCounterparty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (KmblScfCounterparty kmblscfcounterparty : batch) {
                        setKmblScfCounterpartyParams(ps, kmblscfcounterparty);
                        ps.setInt(83, kmblscfcounterparty.getID());
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

    private void setKmblScfCounterpartyParams(PreparedStatement ps, KmblScfCounterparty kmblscfcounterparty) throws SQLException {
        Integer val1 = kmblscfcounterparty.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = kmblscfcounterparty.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, kmblscfcounterparty.getTypeCode());
        ps.setString(4, kmblscfcounterparty.getSubTypeCode());
        ps.setString(5, kmblscfcounterparty.getActiveCode());
        ps.setString(6, kmblscfcounterparty.getStageCode());
        ps.setString(7, kmblscfcounterparty.getStatusCode());
        Integer val8 = kmblscfcounterparty.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, kmblscfcounterparty.getCreatedOn());
        java.math.BigDecimal val10 = kmblscfcounterparty.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, kmblscfcounterparty.getLastUpdatedOn());
        java.math.BigDecimal val12 = kmblscfcounterparty.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, kmblscfcounterparty.getLastAuthorisedOn());
        java.math.BigDecimal val14 = kmblscfcounterparty.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, kmblscfcounterparty.getTemplate());
        ps.setString(16, kmblscfcounterparty.getApplicantPartyCode());
        ps.setString(17, kmblscfcounterparty.getFulfillmentParty());
        java.math.BigDecimal val18 = kmblscfcounterparty.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, kmblscfcounterparty.getAbbvName());
        ps.setString(20, kmblscfcounterparty.getName());
        ps.setString(21, kmblscfcounterparty.getCustomerRole());
        ps.setString(22, kmblscfcounterparty.getInputBranch());
        ps.setString(23, kmblscfcounterparty.getBehalfOfBranch());
        ps.setString(24, kmblscfcounterparty.getAccountNumber());
        ps.setString(25, kmblscfcounterparty.getIfscCode());
        ps.setString(26, kmblscfcounterparty.getBankName());
        ps.setString(27, kmblscfcounterparty.getLimitNode1());
        ps.setString(28, kmblscfcounterparty.getPaymentType());
        ps.setString(29, kmblscfcounterparty.getIntBearingParty());
        ps.setString(30, kmblscfcounterparty.getDebitParty());
        ps.setString(31, kmblscfcounterparty.getIntType());
        ps.setString(32, kmblscfcounterparty.getBaseCode());
        ps.setString(33, kmblscfcounterparty.getPenelSpread());
        ps.setString(34, kmblscfcounterparty.getCpAbbvName());
        ps.setString(35, kmblscfcounterparty.getCpName());
        ps.setString(36, kmblscfcounterparty.getCpCode());
        ps.setString(37, kmblscfcounterparty.getCpRole());
        ps.setString(38, kmblscfcounterparty.getProductType());
        java.math.BigDecimal val39 = kmblscfcounterparty.getGracePeriod();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, kmblscfcounterparty.getLimitNode2());
        java.math.BigDecimal val41 = kmblscfcounterparty.getMarginRate();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        java.math.BigDecimal val42 = kmblscfcounterparty.getSpreadRate();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        Integer val43 = kmblscfcounterparty.getUploadRefID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        java.math.BigDecimal val44 = kmblscfcounterparty.getInterestRate();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        java.math.BigDecimal val45 = kmblscfcounterparty.getRateType();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        ps.setString(46, kmblscfcounterparty.getDebitPartyCrn());
        ps.setString(47, kmblscfcounterparty.getCreditPartyCrn());
        ps.setString(48, kmblscfcounterparty.getCreditPartyName());
        ps.setString(49, kmblscfcounterparty.getSellerIDCrn());
        ps.setString(50, kmblscfcounterparty.getCpStatus());
        ps.setString(51, kmblscfcounterparty.getDisplayStatus());
        ps.setString(52, kmblscfcounterparty.getLineNo());
        ps.setString(53, kmblscfcounterparty.getAncAccountNumber());
        ps.setString(54, kmblscfcounterparty.getAncIfscCode());
        ps.setString(55, kmblscfcounterparty.getAncBankName());
        ps.setString(56, kmblscfcounterparty.getAncPaymentType());
        ps.setString(57, kmblscfcounterparty.getAncIntType());
        ps.setString(58, kmblscfcounterparty.getAncPenalSpread());
        ps.setString(59, kmblscfcounterparty.getAncBaseCode());
        java.math.BigDecimal val60 = kmblscfcounterparty.getAncSpreadRate();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        Integer val61 = kmblscfcounterparty.getVersionID();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        java.math.BigDecimal val62 = kmblscfcounterparty.getIsMasterVersion();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        ps.setString(63, kmblscfcounterparty.getBuyerIDCrn());
        ps.setString(64, kmblscfcounterparty.getLayoutName());
        ps.setString(65, kmblscfcounterparty.getTaskReason());
        java.math.BigDecimal val66 = kmblscfcounterparty.getBaseRate();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        ps.setString(67, kmblscfcounterparty.getMigrationStatus());
        ps.setString(68, kmblscfcounterparty.getMigrationDate());
        Integer val69 = kmblscfcounterparty.getDmsEventID();
        if (val69 != null) {
            ps.setInt(69, val69);
        } else {
            ps.setNull(69, Types.INTEGER);
        }
        ps.setString(70, kmblscfcounterparty.getAncBeneLei());
        ps.setString(71, kmblscfcounterparty.getActivePeriodUom());
        java.math.BigDecimal val72 = kmblscfcounterparty.getActivePeriod();
        if (val72 != null) {
            ps.setBigDecimal(72, val72);
        } else {
            ps.setNull(72, Types.DECIMAL);
        }
        ps.setString(73, kmblscfcounterparty.getActvDateField());
        ps.setString(74, kmblscfcounterparty.getLoanRepaymentDate());
        ps.setString(75, kmblscfcounterparty.getLoanTenor());
        ps.setString(76, kmblscfcounterparty.getLoanTenorUom());
        ps.setString(77, kmblscfcounterparty.getProgramLayoutName());
        Integer val78 = kmblscfcounterparty.getLayoutID();
        if (val78 != null) {
            ps.setInt(78, val78);
        } else {
            ps.setNull(78, Types.INTEGER);
        }
        ps.setString(79, kmblscfcounterparty.getLayoutUuid());
        ps.setString(80, kmblscfcounterparty.getActvDateDisplay());
        java.math.BigDecimal val81 = kmblscfcounterparty.getLoanTenorDays();
        if (val81 != null) {
            ps.setBigDecimal(81, val81);
        } else {
            ps.setNull(81, Types.DECIMAL);
        }
        ps.setString(82, kmblscfcounterparty.getLoanTenorDisplay());
        ps.setString(83, kmblscfcounterparty.getLoanRepaymentDateDisplay());
    }

    private KmblScfCounterparty extract(ResultSet rs) throws SQLException {
        KmblScfCounterparty kmblscfcounterparty = new KmblScfCounterparty();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        kmblscfcounterparty.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        kmblscfcounterparty.setReferenceID(REFERENCE_ID);
        kmblscfcounterparty.setTypeCode(rs.getString(COL_TYPE_CODE));
        kmblscfcounterparty.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        kmblscfcounterparty.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        kmblscfcounterparty.setStageCode(rs.getString(COL_STAGE_CODE));
        kmblscfcounterparty.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        kmblscfcounterparty.setProcessID(PROCESS_ID);
        kmblscfcounterparty.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        kmblscfcounterparty.setCreatedBy(CREATED_BY);
        kmblscfcounterparty.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        kmblscfcounterparty.setLastUpdatedBy(LAST_UPDATED_BY);
        kmblscfcounterparty.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        kmblscfcounterparty.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        kmblscfcounterparty.setTemplate(rs.getString(COL_TEMPLATE));
        kmblscfcounterparty.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        kmblscfcounterparty.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setIsTemplate(IS_TEMPLATE);
        kmblscfcounterparty.setAbbvName(rs.getString(COL_ABBV_NAME));
        kmblscfcounterparty.setName(rs.getString(COL_NAME));
        kmblscfcounterparty.setCustomerRole(rs.getString(COL_CUSTOMER_ROLE));
        kmblscfcounterparty.setInputBranch(rs.getString(COL_INPUT_BRANCH));
        kmblscfcounterparty.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        kmblscfcounterparty.setAccountNumber(rs.getString(COL_ACCOUNT_NUMBER));
        kmblscfcounterparty.setIfscCode(rs.getString(COL_IFSC_CODE));
        kmblscfcounterparty.setBankName(rs.getString(COL_BANK_NAME));
        kmblscfcounterparty.setLimitNode1(rs.getString(COL_LIMIT_NODE_1));
        kmblscfcounterparty.setPaymentType(rs.getString(COL_PAYMENT_TYPE));
        kmblscfcounterparty.setIntBearingParty(rs.getString(COL_INT_BEARING_PARTY));
        kmblscfcounterparty.setDebitParty(rs.getString(COL_DEBIT_PARTY));
        kmblscfcounterparty.setIntType(rs.getString(COL_INT_TYPE));
        kmblscfcounterparty.setBaseCode(rs.getString(COL_BASE_CODE));
        kmblscfcounterparty.setPenelSpread(rs.getString(COL_PENEL_SPREAD));
        kmblscfcounterparty.setCpAbbvName(rs.getString(COL_CP_ABBV_NAME));
        kmblscfcounterparty.setCpName(rs.getString(COL_CP_NAME));
        kmblscfcounterparty.setCpCode(rs.getString(COL_CP_CODE));
        kmblscfcounterparty.setCpRole(rs.getString(COL_CP_ROLE));
        kmblscfcounterparty.setProductType(rs.getString(COL_PRODUCT_TYPE));
        java.math.BigDecimal GRACE_PERIOD = rs.getObject(COL_GRACE_PERIOD, java.math.BigDecimal.class);
        kmblscfcounterparty.setGracePeriod(GRACE_PERIOD);
        kmblscfcounterparty.setLimitNode2(rs.getString(COL_LIMIT_NODE_2));
        java.math.BigDecimal MARGIN_RATE = rs.getObject(COL_MARGIN_RATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setMarginRate(MARGIN_RATE);
        java.math.BigDecimal SPREAD_RATE = rs.getObject(COL_SPREAD_RATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setSpreadRate(SPREAD_RATE);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        kmblscfcounterparty.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setInterestRate(INTEREST_RATE);
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        kmblscfcounterparty.setRateType(RATE_TYPE);
        kmblscfcounterparty.setDebitPartyCrn(rs.getString(COL_DEBIT_PARTY_CRN));
        kmblscfcounterparty.setCreditPartyCrn(rs.getString(COL_CREDIT_PARTY_CRN));
        kmblscfcounterparty.setCreditPartyName(rs.getString(COL_CREDIT_PARTY_NAME));
        kmblscfcounterparty.setSellerIDCrn(rs.getString(COL_SELLER_ID_CRN));
        kmblscfcounterparty.setCpStatus(rs.getString(COL_CP_STATUS));
        kmblscfcounterparty.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        kmblscfcounterparty.setLineNo(rs.getString(COL_LINE_NO));
        kmblscfcounterparty.setAncAccountNumber(rs.getString(COL_ANC_ACCOUNT_NUMBER));
        kmblscfcounterparty.setAncIfscCode(rs.getString(COL_ANC_IFSC_CODE));
        kmblscfcounterparty.setAncBankName(rs.getString(COL_ANC_BANK_NAME));
        kmblscfcounterparty.setAncPaymentType(rs.getString(COL_ANC_PAYMENT_TYPE));
        kmblscfcounterparty.setAncIntType(rs.getString(COL_ANC_INT_TYPE));
        kmblscfcounterparty.setAncPenalSpread(rs.getString(COL_ANC_PENAL_SPREAD));
        kmblscfcounterparty.setAncBaseCode(rs.getString(COL_ANC_BASE_CODE));
        java.math.BigDecimal ANC_SPREAD_RATE = rs.getObject(COL_ANC_SPREAD_RATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setAncSpreadRate(ANC_SPREAD_RATE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        kmblscfcounterparty.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        kmblscfcounterparty.setIsMasterVersion(IS_MASTER_VERSION);
        kmblscfcounterparty.setBuyerIDCrn(rs.getString(COL_BUYER_ID_CRN));
        kmblscfcounterparty.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        kmblscfcounterparty.setTaskReason(rs.getString(COL_TASK_REASON));
        java.math.BigDecimal BASE_RATE = rs.getObject(COL_BASE_RATE, java.math.BigDecimal.class);
        kmblscfcounterparty.setBaseRate(BASE_RATE);
        kmblscfcounterparty.setMigrationStatus(rs.getString(COL_MIGRATION_STATUS));
        kmblscfcounterparty.setMigrationDate(rs.getString(COL_MIGRATION_DATE));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        kmblscfcounterparty.setDmsEventID(DMS_EVENT_ID);
        kmblscfcounterparty.setAncBeneLei(rs.getString(COL_ANC_BENE_LEI));
        kmblscfcounterparty.setActivePeriodUom(rs.getString(COL_ACTIVE_PERIOD_UOM));
        java.math.BigDecimal ACTIVE_PERIOD = rs.getObject(COL_ACTIVE_PERIOD, java.math.BigDecimal.class);
        kmblscfcounterparty.setActivePeriod(ACTIVE_PERIOD);
        kmblscfcounterparty.setActvDateField(rs.getString(COL_ACTV_DATE_FIELD));
        kmblscfcounterparty.setLoanRepaymentDate(rs.getString(COL_LOAN_REPAYMENT_DATE));
        kmblscfcounterparty.setLoanTenor(rs.getString(COL_LOAN_TENOR));
        kmblscfcounterparty.setLoanTenorUom(rs.getString(COL_LOAN_TENOR_UOM));
        kmblscfcounterparty.setProgramLayoutName(rs.getString(COL_PROGRAM_LAYOUT_NAME));
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        kmblscfcounterparty.setLayoutID(LAYOUT_ID);
        kmblscfcounterparty.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        kmblscfcounterparty.setActvDateDisplay(rs.getString(COL_ACTV_DATE_DISPLAY));
        java.math.BigDecimal LOAN_TENOR_DAYS = rs.getObject(COL_LOAN_TENOR_DAYS, java.math.BigDecimal.class);
        kmblscfcounterparty.setLoanTenorDays(LOAN_TENOR_DAYS);
        kmblscfcounterparty.setLoanTenorDisplay(rs.getString(COL_LOAN_TENOR_DISPLAY));
        kmblscfcounterparty.setLoanRepaymentDateDisplay(rs.getString(COL_LOAN_REPAYMENT_DATE_DISPLAY));
        return kmblscfcounterparty;
    }
}
