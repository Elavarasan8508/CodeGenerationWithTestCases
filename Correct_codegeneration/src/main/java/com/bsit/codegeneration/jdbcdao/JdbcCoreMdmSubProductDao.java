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

public class JdbcCoreMdmSubProductDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCoreMdmSubProductDao.class);

    private static final String TABLE = "CORE_MDM_SUB_PRODUCT";

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

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PRODUCT_NAME = "PRODUCT_NAME";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_PRODUCT_GROUP_CODE = "PRODUCT_GROUP_CODE";

    private static final String COL_PRODUCT_SUBGROUP_CODE = "PRODUCT_SUBGROUP_CODE";

    private static final String COL_ASSET_LIABILITY_APPLICABLE = "ASSET_LIABILITY_APPLICABLE";

    private static final String COL_CREDIT_LINE_APPLICABLE = "CREDIT_LINE_APPLICABLE";

    private static final String COL_AUTO_CLOSURE_APPLICABLE = "AUTO_CLOSURE_APPLICABLE";

    private static final String COL_RECOURSE_APPLICABLE = "RECOURSE_APPLICABLE";

    private static final String COL_MIN_TENOR_ALLOWED = "MIN_TENOR_ALLOWED";

    private static final String COL_MAX_TENOR_ALLOWED = "MAX_TENOR_ALLOWED";

    private static final String COL_GRACE_DAYS = "GRACE_DAYS";

    private static final String COL_MAX_FINANCE_PERCENT = "MAX_FINANCE_PERCENT";

    private static final String COL_RECOURSE_PERCENT = "RECOURSE_PERCENT";

    private static final String COL_HOLIDAY_TREATMENT = "HOLIDAY_TREATMENT";

    private static final String COL_NO_OF_DAYS_FROM_GRACE_DAYS = "NO_OF_DAYS_FROM_GRACE_DAYS";

    private static final String COL_MULTIPLE_DISBURSEMENT_ALLOWED = "MULTIPLE_DISBURSEMENT_ALLOWED";

    private static final String COL_NO_OF_DISBURSEMENTS_ALLOWED = "NO_OF_DISBURSEMENTS_ALLOWED";

    private static final String COL_DISBURSEMENT_SCHEDULE = "DISBURSEMENT_SCHEDULE";

    private static final String COL_DISBURSEMENT_DAYS = "DISBURSEMENT_DAYS";

    private static final String COL_PRE_PAYMENT_ALLOWED = "PRE_PAYMENT_ALLOWED";

    private static final String COL_PART_REPAYMENT_ALLOWED = "PART_REPAYMENT_ALLOWED";

    private static final String COL_AUTO_DEBIT_ALLOWED = "AUTO_DEBIT_ALLOWED";

    private static final String COL_ALLOWED_MODE = "ALLOWED_MODE";

    private static final String COL_NO_OF_RETRIES = "NO_OF_RETRIES";

    private static final String COL_AUTO_DEBIT_TYPE = "AUTO_DEBIT_TYPE";

    private static final String COL_INTRA_DAY_DEBIT_FREQUENCY = "INTRA_DAY_DEBIT_FREQUENCY";

    private static final String COL_TIME_OF_FIRST_DEBIT = "TIME_OF_FIRST_DEBIT";

    private static final String COL_PRE_CLOSURE_ALLOWED = "PRE_CLOSURE_ALLOWED";

    private static final String COL_ALLOW_DEBIT_CREDIT_ADJUSTMENTS = "ALLOW_DEBIT_CREDIT_ADJUSTMENTS";

    private static final String COL_REPAYMENT_AMOUNT_ALLOCATION = "REPAYMENT_AMOUNT_ALLOCATION";

    private static final String COL_ALLOCATION_RULE = "ALLOCATION_RULE";

    private static final String COL_APPROPRIATION_SEQUENCE = "APPROPRIATION_SEQUENCE";

    private static final String COL_NPA_APPROPRIATION_SEQUENCE = "NPA_APPROPRIATION_SEQUENCE";

    private static final String COL_PENALTY_CALCULATION_FROM = "PENALTY_CALCULATION_FROM";

    private static final String COL_FEES_AND_CHARGES_SCHEME = "FEES_AND_CHARGES_SCHEME";

    private static final String COL_ALERTS_NOTIFICATIONS_SCHEME = "ALERTS_NOTIFICATIONS_SCHEME";

    private static final String COL_ADVICES_SCHEME = "ADVICES_SCHEME";

    private static final String COL_ASSET_SCHEME = "ASSET_SCHEME";

    private static final String COL_LIMIT_AND_COLLATERAL_SCHEME = "LIMIT_AND_COLLATERAL_SCHEME";

    private static final String COL_NPA_DELINQUENCY = "NPA_DELINQUENCY";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String COL_SUFFIX_ID = "SUFFIX_ID";

    private static final String COL_SUFFIX_NAME = "SUFFIX_NAME";

    private static final String COL_SUFFIX_DESCRIPTION = "SUFFIX_DESCRIPTION";

    private static final String COL_SOURCE_SYSTEM_CODE = "SOURCE_SYSTEM_CODE";

    private static final String COL_BA_SHORT_NAME = "BA_SHORT_NAME";

    private static final String COL_CLASSIFICATION = "CLASSIFICATION";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_DESCRIPTION = "SUB_PRODUCT_DESCRIPTION";

    private static final String COL_PRIMARY_PARTY = "PRIMARY_PARTY";

    private static final String COL_FINANCING_METHOD = "FINANCING_METHOD";

    private static final String COL_ANCHOR_PARTY = "ANCHOR_PARTY";

    private static final String COL_BORROWER_PARTY = "BORROWER_PARTY";

    private static final String COL_EXPOSURE_MAINTANANCE_REQ = "EXPOSURE_MAINTANANCE_REQ";

    private static final String COL_INVOICE_BY = "INVOICE_BY";

    private static final String COL_FINANCE_BY = "FINANCE_BY";

    private static final String COL_INTEREST_CALCULATION = "INTEREST_CALCULATION";

    private static final String COL_ACCRUAL_AMORTIZE = "ACCRUAL_AMORTIZE";

    private static final String COL_FINANCE_DEBIT_PARTY = "FINANCE_DEBIT_PARTY";

    private static final String COL_FINANCE_TO_PARTY = "FINANCE_TO_PARTY";

    private static final String COL_SUB_PRODUCT_NAME = "SUB_PRODUCT_NAME";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_CUTOFF_APPLICABLE = "CUTOFF_APPLICABLE";

    private static final String COL_CHARGES_APPLICABLE = "CHARGES_APPLICABLE";

    private static final String COL_HOLIDAY_APPLICABLE = "HOLIDAY_APPLICABLE";

    private static final String COL_ALLOW_PAYMENT = "ALLOW_PAYMENT";

    private static final String COL_ALLOW_COLLECTION = "ALLOW_COLLECTION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_PRODUCT_DESCRIPTION, COL_PRODUCT_GROUP_CODE, COL_PRODUCT_SUBGROUP_CODE, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_AUTO_CLOSURE_APPLICABLE, COL_RECOURSE_APPLICABLE, COL_MIN_TENOR_ALLOWED, COL_MAX_TENOR_ALLOWED, COL_GRACE_DAYS, COL_MAX_FINANCE_PERCENT, COL_RECOURSE_PERCENT, COL_HOLIDAY_TREATMENT, COL_NO_OF_DAYS_FROM_GRACE_DAYS, COL_MULTIPLE_DISBURSEMENT_ALLOWED, COL_NO_OF_DISBURSEMENTS_ALLOWED, COL_DISBURSEMENT_SCHEDULE, COL_DISBURSEMENT_DAYS, COL_PRE_PAYMENT_ALLOWED, COL_PART_REPAYMENT_ALLOWED, COL_AUTO_DEBIT_ALLOWED, COL_ALLOWED_MODE, COL_NO_OF_RETRIES, COL_AUTO_DEBIT_TYPE, COL_INTRA_DAY_DEBIT_FREQUENCY, COL_TIME_OF_FIRST_DEBIT, COL_PRE_CLOSURE_ALLOWED, COL_ALLOW_DEBIT_CREDIT_ADJUSTMENTS, COL_REPAYMENT_AMOUNT_ALLOCATION, COL_ALLOCATION_RULE, COL_APPROPRIATION_SEQUENCE, COL_NPA_APPROPRIATION_SEQUENCE, COL_PENALTY_CALCULATION_FROM, COL_FEES_AND_CHARGES_SCHEME, COL_ALERTS_NOTIFICATIONS_SCHEME, COL_ADVICES_SCHEME, COL_ASSET_SCHEME, COL_LIMIT_AND_COLLATERAL_SCHEME, COL_NPA_DELINQUENCY, COL_PRODUCT_STATUS_CODE, COL_SUFFIX_ID, COL_SUFFIX_NAME, COL_SUFFIX_DESCRIPTION, COL_SOURCE_SYSTEM_CODE, COL_BA_SHORT_NAME, COL_CLASSIFICATION, COL_SUB_PRODUCT_CODE, COL_SUB_PRODUCT_DESCRIPTION, COL_PRIMARY_PARTY, COL_FINANCING_METHOD, COL_ANCHOR_PARTY, COL_BORROWER_PARTY, COL_EXPOSURE_MAINTANANCE_REQ, COL_INVOICE_BY, COL_FINANCE_BY, COL_INTEREST_CALCULATION, COL_ACCRUAL_AMORTIZE, COL_FINANCE_DEBIT_PARTY, COL_FINANCE_TO_PARTY, COL_SUB_PRODUCT_NAME, COL_SEGMENT_CODE, COL_CUTOFF_APPLICABLE, COL_CHARGES_APPLICABLE, COL_HOLIDAY_APPLICABLE, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, NO_OF_DAYS_FROM_GRACE_DAYS, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENTS_ALLOWED, DISBURSEMENT_SCHEDULE, DISBURSEMENT_DAYS, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, NO_OF_RETRIES, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, TIME_OF_FIRST_DEBIT, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUSTMENTS, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_AND_COLLATERAL_SCHEME, NPA_DELINQUENCY, PRODUCT_STATUS_CODE, SUFFIX_ID, SUFFIX_NAME, SUFFIX_DESCRIPTION, SOURCE_SYSTEM_CODE, BA_SHORT_NAME, CLASSIFICATION, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ANCHOR_PARTY, BORROWER_PARTY, EXPOSURE_MAINTANANCE_REQ, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SUB_PRODUCT_NAME, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, NO_OF_DAYS_FROM_GRACE_DAYS, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENTS_ALLOWED, DISBURSEMENT_SCHEDULE, DISBURSEMENT_DAYS, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, NO_OF_RETRIES, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, TIME_OF_FIRST_DEBIT, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUSTMENTS, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_AND_COLLATERAL_SCHEME, NPA_DELINQUENCY, PRODUCT_STATUS_CODE, SUFFIX_ID, SUFFIX_NAME, SUFFIX_DESCRIPTION, SOURCE_SYSTEM_CODE, BA_SHORT_NAME, CLASSIFICATION, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ANCHOR_PARTY, BORROWER_PARTY, EXPOSURE_MAINTANANCE_REQ, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SUB_PRODUCT_NAME, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_PRODUCT_DESCRIPTION, COL_PRODUCT_GROUP_CODE, COL_PRODUCT_SUBGROUP_CODE, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_AUTO_CLOSURE_APPLICABLE, COL_RECOURSE_APPLICABLE, COL_MIN_TENOR_ALLOWED, COL_MAX_TENOR_ALLOWED, COL_GRACE_DAYS, COL_MAX_FINANCE_PERCENT, COL_RECOURSE_PERCENT, COL_HOLIDAY_TREATMENT, COL_NO_OF_DAYS_FROM_GRACE_DAYS, COL_MULTIPLE_DISBURSEMENT_ALLOWED, COL_NO_OF_DISBURSEMENTS_ALLOWED, COL_DISBURSEMENT_SCHEDULE, COL_DISBURSEMENT_DAYS, COL_PRE_PAYMENT_ALLOWED, COL_PART_REPAYMENT_ALLOWED, COL_AUTO_DEBIT_ALLOWED, COL_ALLOWED_MODE, COL_NO_OF_RETRIES, COL_AUTO_DEBIT_TYPE, COL_INTRA_DAY_DEBIT_FREQUENCY, COL_TIME_OF_FIRST_DEBIT, COL_PRE_CLOSURE_ALLOWED, COL_ALLOW_DEBIT_CREDIT_ADJUSTMENTS, COL_REPAYMENT_AMOUNT_ALLOCATION, COL_ALLOCATION_RULE, COL_APPROPRIATION_SEQUENCE, COL_NPA_APPROPRIATION_SEQUENCE, COL_PENALTY_CALCULATION_FROM, COL_FEES_AND_CHARGES_SCHEME, COL_ALERTS_NOTIFICATIONS_SCHEME, COL_ADVICES_SCHEME, COL_ASSET_SCHEME, COL_LIMIT_AND_COLLATERAL_SCHEME, COL_NPA_DELINQUENCY, COL_PRODUCT_STATUS_CODE, COL_SUFFIX_ID, COL_SUFFIX_NAME, COL_SUFFIX_DESCRIPTION, COL_SOURCE_SYSTEM_CODE, COL_BA_SHORT_NAME, COL_CLASSIFICATION, COL_SUB_PRODUCT_CODE, COL_SUB_PRODUCT_DESCRIPTION, COL_PRIMARY_PARTY, COL_FINANCING_METHOD, COL_ANCHOR_PARTY, COL_BORROWER_PARTY, COL_EXPOSURE_MAINTANANCE_REQ, COL_INVOICE_BY, COL_FINANCE_BY, COL_INTEREST_CALCULATION, COL_ACCRUAL_AMORTIZE, COL_FINANCE_DEBIT_PARTY, COL_FINANCE_TO_PARTY, COL_SUB_PRODUCT_NAME, COL_SEGMENT_CODE, COL_CUTOFF_APPLICABLE, COL_CHARGES_APPLICABLE, COL_HOLIDAY_APPLICABLE, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID, COL_ID);

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

    public int insert(Connection conn, CoreMdmSubProduct coremdmsubproduct) throws SQLException {
        logger.debug("Inserting coremdmsubproduct: {}", coremdmsubproduct);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCoreMdmSubProductParams(ps, coremdmsubproduct);
            ps.executeUpdate();
            return coremdmsubproduct.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CoreMdmSubProduct> coremdmsubproducts) throws SQLException {
        if (coremdmsubproducts == null || coremdmsubproducts.isEmpty())
            return new int[0];
        for (int i = 0; i < coremdmsubproducts.size(); i++) {
            if (coremdmsubproducts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmSubProduct>> batches = chunkList(coremdmsubproducts, batchSize);
        int[] totalResults = new int[coremdmsubproducts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmSubProduct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CoreMdmSubProduct coremdmsubproduct : batch) {
                        setCoreMdmSubProductParams(ps, coremdmsubproduct);
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

    public CoreMdmSubProduct findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CoreMdmSubProduct> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CoreMdmSubProduct> list = new ArrayList<>();
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

    public boolean update(Connection conn, CoreMdmSubProduct coremdmsubproduct) throws SQLException {
        if (coremdmsubproduct.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCoreMdmSubProductParams(ps, coremdmsubproduct);
            ps.setInt(89, coremdmsubproduct.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CoreMdmSubProduct> coremdmsubproducts) throws SQLException {
        if (coremdmsubproducts == null || coremdmsubproducts.isEmpty())
            return new int[0];
        for (CoreMdmSubProduct coremdmsubproduct : coremdmsubproducts) {
            if (coremdmsubproduct == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (coremdmsubproduct.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmSubProduct>> batches = chunkList(coremdmsubproducts, batchSize);
        int[] totalResults = new int[coremdmsubproducts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmSubProduct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CoreMdmSubProduct coremdmsubproduct : batch) {
                        setCoreMdmSubProductParams(ps, coremdmsubproduct);
                        ps.setInt(89, coremdmsubproduct.getID());
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

    private void setCoreMdmSubProductParams(PreparedStatement ps, CoreMdmSubProduct coremdmsubproduct) throws SQLException {
        Integer val1 = coremdmsubproduct.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = coremdmsubproduct.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, coremdmsubproduct.getTypeCode());
        ps.setString(4, coremdmsubproduct.getSubTypeCode());
        ps.setString(5, coremdmsubproduct.getActiveCode());
        ps.setString(6, coremdmsubproduct.getStageCode());
        ps.setString(7, coremdmsubproduct.getStatusCode());
        Integer val8 = coremdmsubproduct.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, coremdmsubproduct.getCreatedOn());
        java.math.BigDecimal val10 = coremdmsubproduct.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, coremdmsubproduct.getLastUpdatedOn());
        java.math.BigDecimal val12 = coremdmsubproduct.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, coremdmsubproduct.getLastAuthorisedOn());
        java.math.BigDecimal val14 = coremdmsubproduct.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, coremdmsubproduct.getTemplate());
        ps.setString(16, coremdmsubproduct.getApplicantParty());
        ps.setString(17, coremdmsubproduct.getFulfillmentParty());
        java.math.BigDecimal val18 = coremdmsubproduct.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, coremdmsubproduct.getProductCode());
        ps.setString(20, coremdmsubproduct.getProductName());
        ps.setString(21, coremdmsubproduct.getProductDescription());
        ps.setString(22, coremdmsubproduct.getProductGroupCode());
        ps.setString(23, coremdmsubproduct.getProductSubgroupCode());
        java.math.BigDecimal val24 = coremdmsubproduct.getAssetLiabilityApplicable();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = coremdmsubproduct.getCreditLineApplicable();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, coremdmsubproduct.getAutoClosureApplicable());
        ps.setString(27, coremdmsubproduct.getRecourseApplicable());
        java.math.BigDecimal val28 = coremdmsubproduct.getMinTenorAllowed();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = coremdmsubproduct.getMaxTenorAllowed();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, coremdmsubproduct.getGraceDays());
        ps.setString(31, coremdmsubproduct.getMaxFinancePercent());
        java.math.BigDecimal val32 = coremdmsubproduct.getRecoursePercent();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = coremdmsubproduct.getHolidayTreatment();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = coremdmsubproduct.getNoOfDaysFromGraceDays();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, coremdmsubproduct.getMultipleDisbursementAllowed());
        java.math.BigDecimal val36 = coremdmsubproduct.getNoOfDisbursementsAllowed();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, coremdmsubproduct.getDisbursementSchedule());
        java.math.BigDecimal val38 = coremdmsubproduct.getDisbursementDays();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, coremdmsubproduct.getPrePaymentAllowed());
        ps.setString(40, coremdmsubproduct.getPartRepaymentAllowed());
        ps.setString(41, coremdmsubproduct.getAutoDebitAllowed());
        ps.setString(42, coremdmsubproduct.getAllowedMode());
        java.math.BigDecimal val43 = coremdmsubproduct.getNoOfRetries();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, coremdmsubproduct.getAutoDebitType());
        ps.setString(45, coremdmsubproduct.getIntraDayDebitFrequency());
        ps.setString(46, coremdmsubproduct.getTimeOfFirstDebit());
        ps.setString(47, coremdmsubproduct.getPreClosureAllowed());
        ps.setString(48, coremdmsubproduct.getAllowDebitCreditAdjustments());
        java.math.BigDecimal val49 = coremdmsubproduct.getRepaymentAmountAllocation();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        ps.setString(50, coremdmsubproduct.getAllocationRule());
        ps.setString(51, coremdmsubproduct.getAppropriationSequence());
        ps.setString(52, coremdmsubproduct.getNpaAppropriationSequence());
        ps.setString(53, coremdmsubproduct.getPenaltyCalculationFrom());
        java.math.BigDecimal val54 = coremdmsubproduct.getFeesAndChargesScheme();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        ps.setString(55, coremdmsubproduct.getAlertsNotificationsScheme());
        ps.setString(56, coremdmsubproduct.getAdvicesScheme());
        ps.setString(57, coremdmsubproduct.getAssetScheme());
        ps.setString(58, coremdmsubproduct.getLimitAndCollateralScheme());
        ps.setString(59, coremdmsubproduct.getNpaDelinquency());
        ps.setString(60, coremdmsubproduct.getProductStatusCode());
        Integer val61 = coremdmsubproduct.getSuffixID();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        ps.setString(62, coremdmsubproduct.getSuffixName());
        ps.setString(63, coremdmsubproduct.getSuffixDescription());
        ps.setString(64, coremdmsubproduct.getSourceSystemCode());
        ps.setString(65, coremdmsubproduct.getBaShortName());
        ps.setString(66, coremdmsubproduct.getClassification());
        ps.setString(67, coremdmsubproduct.getSubProductCode());
        ps.setString(68, coremdmsubproduct.getSubProductDescription());
        ps.setString(69, coremdmsubproduct.getPrimaryParty());
        ps.setString(70, coremdmsubproduct.getFinancingMethod());
        ps.setString(71, coremdmsubproduct.getAnchorParty());
        ps.setString(72, coremdmsubproduct.getBorrowerParty());
        java.math.BigDecimal val73 = coremdmsubproduct.getExposureMaintananceReq();
        if (val73 != null) {
            ps.setBigDecimal(73, val73);
        } else {
            ps.setNull(73, Types.DECIMAL);
        }
        ps.setString(74, coremdmsubproduct.getInvoiceBy());
        ps.setString(75, coremdmsubproduct.getFinanceBy());
        java.math.BigDecimal val76 = coremdmsubproduct.getInterestCalculation();
        if (val76 != null) {
            ps.setBigDecimal(76, val76);
        } else {
            ps.setNull(76, Types.DECIMAL);
        }
        java.math.BigDecimal val77 = coremdmsubproduct.getAccrualAmortize();
        if (val77 != null) {
            ps.setBigDecimal(77, val77);
        } else {
            ps.setNull(77, Types.DECIMAL);
        }
        ps.setString(78, coremdmsubproduct.getFinanceDebitParty());
        ps.setString(79, coremdmsubproduct.getFinanceToParty());
        ps.setString(80, coremdmsubproduct.getSubProductName());
        ps.setString(81, coremdmsubproduct.getSegmentCode());
        java.math.BigDecimal val82 = coremdmsubproduct.getCutoffApplicable();
        if (val82 != null) {
            ps.setBigDecimal(82, val82);
        } else {
            ps.setNull(82, Types.DECIMAL);
        }
        java.math.BigDecimal val83 = coremdmsubproduct.getChargesApplicable();
        if (val83 != null) {
            ps.setBigDecimal(83, val83);
        } else {
            ps.setNull(83, Types.DECIMAL);
        }
        java.math.BigDecimal val84 = coremdmsubproduct.getHolidayApplicable();
        if (val84 != null) {
            ps.setBigDecimal(84, val84);
        } else {
            ps.setNull(84, Types.DECIMAL);
        }
        java.math.BigDecimal val85 = coremdmsubproduct.getAllowPayment();
        if (val85 != null) {
            ps.setBigDecimal(85, val85);
        } else {
            ps.setNull(85, Types.DECIMAL);
        }
        java.math.BigDecimal val86 = coremdmsubproduct.getAllowCollection();
        if (val86 != null) {
            ps.setBigDecimal(86, val86);
        } else {
            ps.setNull(86, Types.DECIMAL);
        }
        Integer val87 = coremdmsubproduct.getVersionID();
        if (val87 != null) {
            ps.setInt(87, val87);
        } else {
            ps.setNull(87, Types.INTEGER);
        }
        java.math.BigDecimal val88 = coremdmsubproduct.getIsMasterVersion();
        if (val88 != null) {
            ps.setBigDecimal(88, val88);
        } else {
            ps.setNull(88, Types.DECIMAL);
        }
        Integer val89 = coremdmsubproduct.getUploadRefID();
        if (val89 != null) {
            ps.setInt(89, val89);
        } else {
            ps.setNull(89, Types.INTEGER);
        }
    }

    private CoreMdmSubProduct extract(ResultSet rs) throws SQLException {
        CoreMdmSubProduct coremdmsubproduct = new CoreMdmSubProduct();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        coremdmsubproduct.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        coremdmsubproduct.setReferenceID(REFERENCE_ID);
        coremdmsubproduct.setTypeCode(rs.getString(COL_TYPE_CODE));
        coremdmsubproduct.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        coremdmsubproduct.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        coremdmsubproduct.setStageCode(rs.getString(COL_STAGE_CODE));
        coremdmsubproduct.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        coremdmsubproduct.setProcessID(PROCESS_ID);
        coremdmsubproduct.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        coremdmsubproduct.setCreatedBy(CREATED_BY);
        coremdmsubproduct.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        coremdmsubproduct.setLastUpdatedBy(LAST_UPDATED_BY);
        coremdmsubproduct.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        coremdmsubproduct.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        coremdmsubproduct.setTemplate(rs.getString(COL_TEMPLATE));
        coremdmsubproduct.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        coremdmsubproduct.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        coremdmsubproduct.setIsTemplate(IS_TEMPLATE);
        coremdmsubproduct.setProductCode(rs.getString(COL_PRODUCT_CODE));
        coremdmsubproduct.setProductName(rs.getString(COL_PRODUCT_NAME));
        coremdmsubproduct.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        coremdmsubproduct.setProductGroupCode(rs.getString(COL_PRODUCT_GROUP_CODE));
        coremdmsubproduct.setProductSubgroupCode(rs.getString(COL_PRODUCT_SUBGROUP_CODE));
        java.math.BigDecimal ASSET_LIABILITY_APPLICABLE = rs.getObject(COL_ASSET_LIABILITY_APPLICABLE, java.math.BigDecimal.class);
        coremdmsubproduct.setAssetLiabilityApplicable(ASSET_LIABILITY_APPLICABLE);
        java.math.BigDecimal CREDIT_LINE_APPLICABLE = rs.getObject(COL_CREDIT_LINE_APPLICABLE, java.math.BigDecimal.class);
        coremdmsubproduct.setCreditLineApplicable(CREDIT_LINE_APPLICABLE);
        coremdmsubproduct.setAutoClosureApplicable(rs.getString(COL_AUTO_CLOSURE_APPLICABLE));
        coremdmsubproduct.setRecourseApplicable(rs.getString(COL_RECOURSE_APPLICABLE));
        java.math.BigDecimal MIN_TENOR_ALLOWED = rs.getObject(COL_MIN_TENOR_ALLOWED, java.math.BigDecimal.class);
        coremdmsubproduct.setMinTenorAllowed(MIN_TENOR_ALLOWED);
        java.math.BigDecimal MAX_TENOR_ALLOWED = rs.getObject(COL_MAX_TENOR_ALLOWED, java.math.BigDecimal.class);
        coremdmsubproduct.setMaxTenorAllowed(MAX_TENOR_ALLOWED);
        coremdmsubproduct.setGraceDays(rs.getString(COL_GRACE_DAYS));
        coremdmsubproduct.setMaxFinancePercent(rs.getString(COL_MAX_FINANCE_PERCENT));
        java.math.BigDecimal RECOURSE_PERCENT = rs.getObject(COL_RECOURSE_PERCENT, java.math.BigDecimal.class);
        coremdmsubproduct.setRecoursePercent(RECOURSE_PERCENT);
        java.math.BigDecimal HOLIDAY_TREATMENT = rs.getObject(COL_HOLIDAY_TREATMENT, java.math.BigDecimal.class);
        coremdmsubproduct.setHolidayTreatment(HOLIDAY_TREATMENT);
        java.math.BigDecimal NO_OF_DAYS_FROM_GRACE_DAYS = rs.getObject(COL_NO_OF_DAYS_FROM_GRACE_DAYS, java.math.BigDecimal.class);
        coremdmsubproduct.setNoOfDaysFromGraceDays(NO_OF_DAYS_FROM_GRACE_DAYS);
        coremdmsubproduct.setMultipleDisbursementAllowed(rs.getString(COL_MULTIPLE_DISBURSEMENT_ALLOWED));
        java.math.BigDecimal NO_OF_DISBURSEMENTS_ALLOWED = rs.getObject(COL_NO_OF_DISBURSEMENTS_ALLOWED, java.math.BigDecimal.class);
        coremdmsubproduct.setNoOfDisbursementsAllowed(NO_OF_DISBURSEMENTS_ALLOWED);
        coremdmsubproduct.setDisbursementSchedule(rs.getString(COL_DISBURSEMENT_SCHEDULE));
        java.math.BigDecimal DISBURSEMENT_DAYS = rs.getObject(COL_DISBURSEMENT_DAYS, java.math.BigDecimal.class);
        coremdmsubproduct.setDisbursementDays(DISBURSEMENT_DAYS);
        coremdmsubproduct.setPrePaymentAllowed(rs.getString(COL_PRE_PAYMENT_ALLOWED));
        coremdmsubproduct.setPartRepaymentAllowed(rs.getString(COL_PART_REPAYMENT_ALLOWED));
        coremdmsubproduct.setAutoDebitAllowed(rs.getString(COL_AUTO_DEBIT_ALLOWED));
        coremdmsubproduct.setAllowedMode(rs.getString(COL_ALLOWED_MODE));
        java.math.BigDecimal NO_OF_RETRIES = rs.getObject(COL_NO_OF_RETRIES, java.math.BigDecimal.class);
        coremdmsubproduct.setNoOfRetries(NO_OF_RETRIES);
        coremdmsubproduct.setAutoDebitType(rs.getString(COL_AUTO_DEBIT_TYPE));
        coremdmsubproduct.setIntraDayDebitFrequency(rs.getString(COL_INTRA_DAY_DEBIT_FREQUENCY));
        coremdmsubproduct.setTimeOfFirstDebit(rs.getString(COL_TIME_OF_FIRST_DEBIT));
        coremdmsubproduct.setPreClosureAllowed(rs.getString(COL_PRE_CLOSURE_ALLOWED));
        coremdmsubproduct.setAllowDebitCreditAdjustments(rs.getString(COL_ALLOW_DEBIT_CREDIT_ADJUSTMENTS));
        java.math.BigDecimal REPAYMENT_AMOUNT_ALLOCATION = rs.getObject(COL_REPAYMENT_AMOUNT_ALLOCATION, java.math.BigDecimal.class);
        coremdmsubproduct.setRepaymentAmountAllocation(REPAYMENT_AMOUNT_ALLOCATION);
        coremdmsubproduct.setAllocationRule(rs.getString(COL_ALLOCATION_RULE));
        coremdmsubproduct.setAppropriationSequence(rs.getString(COL_APPROPRIATION_SEQUENCE));
        coremdmsubproduct.setNpaAppropriationSequence(rs.getString(COL_NPA_APPROPRIATION_SEQUENCE));
        coremdmsubproduct.setPenaltyCalculationFrom(rs.getString(COL_PENALTY_CALCULATION_FROM));
        java.math.BigDecimal FEES_AND_CHARGES_SCHEME = rs.getObject(COL_FEES_AND_CHARGES_SCHEME, java.math.BigDecimal.class);
        coremdmsubproduct.setFeesAndChargesScheme(FEES_AND_CHARGES_SCHEME);
        coremdmsubproduct.setAlertsNotificationsScheme(rs.getString(COL_ALERTS_NOTIFICATIONS_SCHEME));
        coremdmsubproduct.setAdvicesScheme(rs.getString(COL_ADVICES_SCHEME));
        coremdmsubproduct.setAssetScheme(rs.getString(COL_ASSET_SCHEME));
        coremdmsubproduct.setLimitAndCollateralScheme(rs.getString(COL_LIMIT_AND_COLLATERAL_SCHEME));
        coremdmsubproduct.setNpaDelinquency(rs.getString(COL_NPA_DELINQUENCY));
        coremdmsubproduct.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        Integer SUFFIX_ID = rs.getObject(COL_SUFFIX_ID, Integer.class);
        coremdmsubproduct.setSuffixID(SUFFIX_ID);
        coremdmsubproduct.setSuffixName(rs.getString(COL_SUFFIX_NAME));
        coremdmsubproduct.setSuffixDescription(rs.getString(COL_SUFFIX_DESCRIPTION));
        coremdmsubproduct.setSourceSystemCode(rs.getString(COL_SOURCE_SYSTEM_CODE));
        coremdmsubproduct.setBaShortName(rs.getString(COL_BA_SHORT_NAME));
        coremdmsubproduct.setClassification(rs.getString(COL_CLASSIFICATION));
        coremdmsubproduct.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        coremdmsubproduct.setSubProductDescription(rs.getString(COL_SUB_PRODUCT_DESCRIPTION));
        coremdmsubproduct.setPrimaryParty(rs.getString(COL_PRIMARY_PARTY));
        coremdmsubproduct.setFinancingMethod(rs.getString(COL_FINANCING_METHOD));
        coremdmsubproduct.setAnchorParty(rs.getString(COL_ANCHOR_PARTY));
        coremdmsubproduct.setBorrowerParty(rs.getString(COL_BORROWER_PARTY));
        java.math.BigDecimal EXPOSURE_MAINTANANCE_REQ = rs.getObject(COL_EXPOSURE_MAINTANANCE_REQ, java.math.BigDecimal.class);
        coremdmsubproduct.setExposureMaintananceReq(EXPOSURE_MAINTANANCE_REQ);
        coremdmsubproduct.setInvoiceBy(rs.getString(COL_INVOICE_BY));
        coremdmsubproduct.setFinanceBy(rs.getString(COL_FINANCE_BY));
        java.math.BigDecimal INTEREST_CALCULATION = rs.getObject(COL_INTEREST_CALCULATION, java.math.BigDecimal.class);
        coremdmsubproduct.setInterestCalculation(INTEREST_CALCULATION);
        java.math.BigDecimal ACCRUAL_AMORTIZE = rs.getObject(COL_ACCRUAL_AMORTIZE, java.math.BigDecimal.class);
        coremdmsubproduct.setAccrualAmortize(ACCRUAL_AMORTIZE);
        coremdmsubproduct.setFinanceDebitParty(rs.getString(COL_FINANCE_DEBIT_PARTY));
        coremdmsubproduct.setFinanceToParty(rs.getString(COL_FINANCE_TO_PARTY));
        coremdmsubproduct.setSubProductName(rs.getString(COL_SUB_PRODUCT_NAME));
        coremdmsubproduct.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        java.math.BigDecimal CUTOFF_APPLICABLE = rs.getObject(COL_CUTOFF_APPLICABLE, java.math.BigDecimal.class);
        coremdmsubproduct.setCutoffApplicable(CUTOFF_APPLICABLE);
        java.math.BigDecimal CHARGES_APPLICABLE = rs.getObject(COL_CHARGES_APPLICABLE, java.math.BigDecimal.class);
        coremdmsubproduct.setChargesApplicable(CHARGES_APPLICABLE);
        java.math.BigDecimal HOLIDAY_APPLICABLE = rs.getObject(COL_HOLIDAY_APPLICABLE, java.math.BigDecimal.class);
        coremdmsubproduct.setHolidayApplicable(HOLIDAY_APPLICABLE);
        java.math.BigDecimal ALLOW_PAYMENT = rs.getObject(COL_ALLOW_PAYMENT, java.math.BigDecimal.class);
        coremdmsubproduct.setAllowPayment(ALLOW_PAYMENT);
        java.math.BigDecimal ALLOW_COLLECTION = rs.getObject(COL_ALLOW_COLLECTION, java.math.BigDecimal.class);
        coremdmsubproduct.setAllowCollection(ALLOW_COLLECTION);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        coremdmsubproduct.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        coremdmsubproduct.setIsMasterVersion(IS_MASTER_VERSION);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        coremdmsubproduct.setUploadRefID(UPLOAD_REF_ID);
        return coremdmsubproduct;
    }
}
