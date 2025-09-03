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

public class JdbcCoreProductPartyMapDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCoreProductPartyMapDao.class);

    private static final String TABLE = "CORE_PRODUCT_PARTY_MAP";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

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

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_DESCRIPTION = "SUB_PRODUCT_DESCRIPTION";

    private static final String COL_PRIMARY_PARTY = "PRIMARY_PARTY";

    private static final String COL_FINANCING_METHOD = "FINANCING_METHOD";

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

    private static final String COL_MULTIPLE_DISBURSEMENT_ALLOWED = "MULTIPLE_DISBURSEMENT_ALLOWED";

    private static final String COL_NO_OF_DISBURSEMENT_ALLOWED = "NO_OF_DISBURSEMENT_ALLOWED";

    private static final String COL_PRE_PAYMENT_ALLOWED = "PRE_PAYMENT_ALLOWED";

    private static final String COL_PART_REPAYMENT_ALLOWED = "PART_REPAYMENT_ALLOWED";

    private static final String COL_AUTO_DEBIT_ALLOWED = "AUTO_DEBIT_ALLOWED";

    private static final String COL_ALLOWED_MODE = "ALLOWED_MODE";

    private static final String COL_PRE_CLOSURE_ALLOWED = "PRE_CLOSURE_ALLOWED";

    private static final String COL_ALLOW_DEBIT_CREDIT_ADJUST = "ALLOW_DEBIT_CREDIT_ADJUST";

    private static final String COL_RECESSION_PERIOD = "RECESSION_PERIOD";

    private static final String COL_REPAYMENT_AMOUNT_ALLOCATION = "REPAYMENT_AMOUNT_ALLOCATION";

    private static final String COL_ALLOCATION_RULE = "ALLOCATION_RULE";

    private static final String COL_APPROPRIATION_SEQUENCE = "APPROPRIATION_SEQUENCE";

    private static final String COL_NPA_APPROPRIATION_SEQUENCE = "NPA_APPROPRIATION_SEQUENCE";

    private static final String COL_PENALTY_CALCULATION_FROM = "PENALTY_CALCULATION_FROM";

    private static final String COL_NO_OF_RETRIES = "NO_OF_RETRIES";

    private static final String COL_DISBURSEMENT_SCHEDULE = "DISBURSEMENT_SCHEDULE";

    private static final String COL_AUTO_DEBIT_TYPE = "AUTO_DEBIT_TYPE";

    private static final String COL_INTRA_DAY_DEBIT_FREQUENCY = "INTRA_DAY_DEBIT_FREQUENCY";

    private static final String COL_DISBURSEMENT_DAYS = "DISBURSEMENT_DAYS";

    private static final String COL_FEES_AND_CHARGES_SCHEME = "FEES_AND_CHARGES_SCHEME";

    private static final String COL_ALERTS_NOTIFICATIONS_SCHEME = "ALERTS_NOTIFICATIONS_SCHEME";

    private static final String COL_ADVICES_SCHEME = "ADVICES_SCHEME";

    private static final String COL_ASSET_SCHEME = "ASSET_SCHEME";

    private static final String COL_LIMIT_COLLATERAL_SCHEME = "LIMIT_COLLATERAL_SCHEME";

    private static final String COL_NPA_DELINQUENCY_WRITEOFF = "NPA_DELINQUENCY_WRITEOFF";

    private static final String COL_ALLOWED_BRANCHES = "ALLOWED_BRANCHES";

    private static final String COL_ALLOWED_CUSTOMER_TYPE = "ALLOWED_CUSTOMER_TYPE";

    private static final String COL_TIME_OF_FIRST_DEBIT = "TIME_OF_FIRST_DEBIT";

    private static final String COL_NO_OF_DAYS_FROM_GRACE_DAYS = "NO_OF_DAYS_FROM_GRACE_DAYS";

    private static final String COL_CUSTOMER_ID = "CUSTOMER_ID";

    private static final String COL_CUSTOMER_PRODUCTS = "CUSTOMER_PRODUCTS";

    private static final String COL_MAX_DURATION = "MAX_DURATION";

    private static final String COL_MIN_DURATION = "MIN_DURATION";

    private static final String COL_STALE_PERIOD = "STALE_PERIOD";

    private static final String COL_ACCEPTANCE_REQUIRED = "ACCEPTANCE_REQUIRED";

    private static final String COL_DISBURSEMENT_ACCOUNT = "DISBURSEMENT_ACCOUNT";

    private static final String COL_MARGIN_ACCOUNT = "MARGIN_ACCOUNT";

    private static final String COL_ONLINE_CHARGES_ACC = "ONLINE_CHARGES_ACC";

    private static final String COL_BATCH_BILLING_CHARGES_ACC = "BATCH_BILLING_CHARGES_ACC";

    private static final String COL_INTEREST_COLLECTION_ACC = "INTEREST_COLLECTION_ACC";

    private static final String COL_SETTLEMENT_AUTO_DEBIT_AC = "SETTLEMENT_AUTO_DEBIT_AC";

    private static final String COL_ANCHOR_PARTY = "ANCHOR_PARTY";

    private static final String COL_BORROWER_PARTY = "BORROWER_PARTY";

    private static final String COL_INVOICE_BY = "INVOICE_BY";

    private static final String COL_FINANCE_BY = "FINANCE_BY";

    private static final String COL_INTEREST_CALCULATION = "INTEREST_CALCULATION";

    private static final String COL_EXPOSURE_MAINTANANCE_REQ = "EXPOSURE_MAINTANANCE_REQ";

    private static final String COL_ACCRUAL_FREQUENCY = "ACCRUAL_FREQUENCY";

    private static final String COL_LIMIT_ID = "LIMIT_ID";

    private static final String COL_LIMIT_TYPE = "LIMIT_TYPE";

    private static final String COL_LIMIT_EFFECTIVE_DATE = "LIMIT_EFFECTIVE_DATE";

    private static final String COL_LIMIT_EXPIRY_DATE = "LIMIT_EXPIRY_DATE";

    private static final String COL_LIMIT_AMOUNT = "LIMIT_AMOUNT";

    private static final String COL_LIMIT_UTILIZED_LIMIT = "LIMIT_UTILIZED_LIMIT";

    private static final String COL_LIMIT_AVAILABLE_LIMIT = "LIMIT_AVAILABLE_LIMIT";

    private static final String COL_LIMIT_RECOURSE_PERCENT = "LIMIT_RECOURSE_PERCENT";

    private static final String COL_LIMIT_RECOURSE_APPLICABLE = "LIMIT_RECOURSE_APPLICABLE";

    private static final String COL_FINANCE_TO_PARTY = "FINANCE_TO_PARTY";

    private static final String COL_FINANCE_DEBIT_PARTY = "FINANCE_DEBIT_PARTY";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PRODUCT_NAME = "PRODUCT_NAME";

    private static final String COL_SUB_PRODUCT_NAME = "SUB_PRODUCT_NAME";

    private static final String COL_ALLOW_PAYMENT = "ALLOW_PAYMENT";

    private static final String COL_ALLOW_COLLECTION = "ALLOW_COLLECTION";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PROCESS_ID, COL_SUB_PRODUCT_CODE, COL_SUB_PRODUCT_DESCRIPTION, COL_PRIMARY_PARTY, COL_FINANCING_METHOD, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_AUTO_CLOSURE_APPLICABLE, COL_RECOURSE_APPLICABLE, COL_MIN_TENOR_ALLOWED, COL_MAX_TENOR_ALLOWED, COL_GRACE_DAYS, COL_MAX_FINANCE_PERCENT, COL_RECOURSE_PERCENT, COL_HOLIDAY_TREATMENT, COL_MULTIPLE_DISBURSEMENT_ALLOWED, COL_NO_OF_DISBURSEMENT_ALLOWED, COL_PRE_PAYMENT_ALLOWED, COL_PART_REPAYMENT_ALLOWED, COL_AUTO_DEBIT_ALLOWED, COL_ALLOWED_MODE, COL_PRE_CLOSURE_ALLOWED, COL_ALLOW_DEBIT_CREDIT_ADJUST, COL_RECESSION_PERIOD, COL_REPAYMENT_AMOUNT_ALLOCATION, COL_ALLOCATION_RULE, COL_APPROPRIATION_SEQUENCE, COL_NPA_APPROPRIATION_SEQUENCE, COL_PENALTY_CALCULATION_FROM, COL_NO_OF_RETRIES, COL_DISBURSEMENT_SCHEDULE, COL_AUTO_DEBIT_TYPE, COL_INTRA_DAY_DEBIT_FREQUENCY, COL_DISBURSEMENT_DAYS, COL_FEES_AND_CHARGES_SCHEME, COL_ALERTS_NOTIFICATIONS_SCHEME, COL_ADVICES_SCHEME, COL_ASSET_SCHEME, COL_LIMIT_COLLATERAL_SCHEME, COL_NPA_DELINQUENCY_WRITEOFF, COL_ALLOWED_BRANCHES, COL_ALLOWED_CUSTOMER_TYPE, COL_TIME_OF_FIRST_DEBIT, COL_NO_OF_DAYS_FROM_GRACE_DAYS, COL_CUSTOMER_ID, COL_CUSTOMER_PRODUCTS, COL_MAX_DURATION, COL_MIN_DURATION, COL_STALE_PERIOD, COL_ACCEPTANCE_REQUIRED, COL_DISBURSEMENT_ACCOUNT, COL_MARGIN_ACCOUNT, COL_ONLINE_CHARGES_ACC, COL_BATCH_BILLING_CHARGES_ACC, COL_INTEREST_COLLECTION_ACC, COL_SETTLEMENT_AUTO_DEBIT_AC, COL_ANCHOR_PARTY, COL_BORROWER_PARTY, COL_INVOICE_BY, COL_FINANCE_BY, COL_INTEREST_CALCULATION, COL_EXPOSURE_MAINTANANCE_REQ, COL_ACCRUAL_FREQUENCY, COL_LIMIT_ID, COL_LIMIT_TYPE, COL_LIMIT_EFFECTIVE_DATE, COL_LIMIT_EXPIRY_DATE, COL_LIMIT_AMOUNT, COL_LIMIT_UTILIZED_LIMIT, COL_LIMIT_AVAILABLE_LIMIT, COL_LIMIT_RECOURSE_PERCENT, COL_LIMIT_RECOURSE_APPLICABLE, COL_FINANCE_TO_PARTY, COL_FINANCE_DEBIT_PARTY, COL_PRODUCT_STATUS_CODE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_SUB_PRODUCT_NAME, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENT_ALLOWED, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUST, RECESSION_PERIOD, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, NO_OF_RETRIES, DISBURSEMENT_SCHEDULE, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, DISBURSEMENT_DAYS, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_COLLATERAL_SCHEME, NPA_DELINQUENCY_WRITEOFF, ALLOWED_BRANCHES, ALLOWED_CUSTOMER_TYPE, TIME_OF_FIRST_DEBIT, NO_OF_DAYS_FROM_GRACE_DAYS, CUSTOMER_ID, CUSTOMER_PRODUCTS, MAX_DURATION, MIN_DURATION, STALE_PERIOD, ACCEPTANCE_REQUIRED, DISBURSEMENT_ACCOUNT, MARGIN_ACCOUNT, ONLINE_CHARGES_ACC, BATCH_BILLING_CHARGES_ACC, INTEREST_COLLECTION_ACC, SETTLEMENT_AUTO_DEBIT_AC, ANCHOR_PARTY, BORROWER_PARTY, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, EXPOSURE_MAINTANANCE_REQ, ACCRUAL_FREQUENCY, LIMIT_ID, LIMIT_TYPE, LIMIT_EFFECTIVE_DATE, LIMIT_EXPIRY_DATE, LIMIT_AMOUNT, LIMIT_UTILIZED_LIMIT, LIMIT_AVAILABLE_LIMIT, LIMIT_RECOURSE_PERCENT, LIMIT_RECOURSE_APPLICABLE, FINANCE_TO_PARTY, FINANCE_DEBIT_PARTY, PRODUCT_STATUS_CODE, SEGMENT_CODE, PRODUCT_CODE, PRODUCT_NAME, SUB_PRODUCT_NAME, ALLOW_PAYMENT, ALLOW_COLLECTION, APPLICANT_PARTY, FULFILLMENT_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENT_ALLOWED, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUST, RECESSION_PERIOD, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, NO_OF_RETRIES, DISBURSEMENT_SCHEDULE, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, DISBURSEMENT_DAYS, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_COLLATERAL_SCHEME, NPA_DELINQUENCY_WRITEOFF, ALLOWED_BRANCHES, ALLOWED_CUSTOMER_TYPE, TIME_OF_FIRST_DEBIT, NO_OF_DAYS_FROM_GRACE_DAYS, CUSTOMER_ID, CUSTOMER_PRODUCTS, MAX_DURATION, MIN_DURATION, STALE_PERIOD, ACCEPTANCE_REQUIRED, DISBURSEMENT_ACCOUNT, MARGIN_ACCOUNT, ONLINE_CHARGES_ACC, BATCH_BILLING_CHARGES_ACC, INTEREST_COLLECTION_ACC, SETTLEMENT_AUTO_DEBIT_AC, ANCHOR_PARTY, BORROWER_PARTY, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, EXPOSURE_MAINTANANCE_REQ, ACCRUAL_FREQUENCY, LIMIT_ID, LIMIT_TYPE, LIMIT_EFFECTIVE_DATE, LIMIT_EXPIRY_DATE, LIMIT_AMOUNT, LIMIT_UTILIZED_LIMIT, LIMIT_AVAILABLE_LIMIT, LIMIT_RECOURSE_PERCENT, LIMIT_RECOURSE_APPLICABLE, FINANCE_TO_PARTY, FINANCE_DEBIT_PARTY, PRODUCT_STATUS_CODE, SEGMENT_CODE, PRODUCT_CODE, PRODUCT_NAME, SUB_PRODUCT_NAME, ALLOW_PAYMENT, ALLOW_COLLECTION, APPLICANT_PARTY, FULFILLMENT_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PROCESS_ID, COL_SUB_PRODUCT_CODE, COL_SUB_PRODUCT_DESCRIPTION, COL_PRIMARY_PARTY, COL_FINANCING_METHOD, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_AUTO_CLOSURE_APPLICABLE, COL_RECOURSE_APPLICABLE, COL_MIN_TENOR_ALLOWED, COL_MAX_TENOR_ALLOWED, COL_GRACE_DAYS, COL_MAX_FINANCE_PERCENT, COL_RECOURSE_PERCENT, COL_HOLIDAY_TREATMENT, COL_MULTIPLE_DISBURSEMENT_ALLOWED, COL_NO_OF_DISBURSEMENT_ALLOWED, COL_PRE_PAYMENT_ALLOWED, COL_PART_REPAYMENT_ALLOWED, COL_AUTO_DEBIT_ALLOWED, COL_ALLOWED_MODE, COL_PRE_CLOSURE_ALLOWED, COL_ALLOW_DEBIT_CREDIT_ADJUST, COL_RECESSION_PERIOD, COL_REPAYMENT_AMOUNT_ALLOCATION, COL_ALLOCATION_RULE, COL_APPROPRIATION_SEQUENCE, COL_NPA_APPROPRIATION_SEQUENCE, COL_PENALTY_CALCULATION_FROM, COL_NO_OF_RETRIES, COL_DISBURSEMENT_SCHEDULE, COL_AUTO_DEBIT_TYPE, COL_INTRA_DAY_DEBIT_FREQUENCY, COL_DISBURSEMENT_DAYS, COL_FEES_AND_CHARGES_SCHEME, COL_ALERTS_NOTIFICATIONS_SCHEME, COL_ADVICES_SCHEME, COL_ASSET_SCHEME, COL_LIMIT_COLLATERAL_SCHEME, COL_NPA_DELINQUENCY_WRITEOFF, COL_ALLOWED_BRANCHES, COL_ALLOWED_CUSTOMER_TYPE, COL_TIME_OF_FIRST_DEBIT, COL_NO_OF_DAYS_FROM_GRACE_DAYS, COL_CUSTOMER_ID, COL_CUSTOMER_PRODUCTS, COL_MAX_DURATION, COL_MIN_DURATION, COL_STALE_PERIOD, COL_ACCEPTANCE_REQUIRED, COL_DISBURSEMENT_ACCOUNT, COL_MARGIN_ACCOUNT, COL_ONLINE_CHARGES_ACC, COL_BATCH_BILLING_CHARGES_ACC, COL_INTEREST_COLLECTION_ACC, COL_SETTLEMENT_AUTO_DEBIT_AC, COL_ANCHOR_PARTY, COL_BORROWER_PARTY, COL_INVOICE_BY, COL_FINANCE_BY, COL_INTEREST_CALCULATION, COL_EXPOSURE_MAINTANANCE_REQ, COL_ACCRUAL_FREQUENCY, COL_LIMIT_ID, COL_LIMIT_TYPE, COL_LIMIT_EFFECTIVE_DATE, COL_LIMIT_EXPIRY_DATE, COL_LIMIT_AMOUNT, COL_LIMIT_UTILIZED_LIMIT, COL_LIMIT_AVAILABLE_LIMIT, COL_LIMIT_RECOURSE_PERCENT, COL_LIMIT_RECOURSE_APPLICABLE, COL_FINANCE_TO_PARTY, COL_FINANCE_DEBIT_PARTY, COL_PRODUCT_STATUS_CODE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_SUB_PRODUCT_NAME, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ID);

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

    public int insert(Connection conn, CoreProductPartyMap coreproductpartymap) throws SQLException {
        logger.debug("Inserting coreproductpartymap: {}", coreproductpartymap);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCoreProductPartyMapParams(ps, coreproductpartymap);
            ps.executeUpdate();
            return coreproductpartymap.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CoreProductPartyMap> coreproductpartymaps) throws SQLException {
        if (coreproductpartymaps == null || coreproductpartymaps.isEmpty())
            return new int[0];
        for (int i = 0; i < coreproductpartymaps.size(); i++) {
            if (coreproductpartymaps.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreProductPartyMap>> batches = chunkList(coreproductpartymaps, batchSize);
        int[] totalResults = new int[coreproductpartymaps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreProductPartyMap> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CoreProductPartyMap coreproductpartymap : batch) {
                        setCoreProductPartyMapParams(ps, coreproductpartymap);
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

    public CoreProductPartyMap findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CoreProductPartyMap> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CoreProductPartyMap> list = new ArrayList<>();
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

    public boolean update(Connection conn, CoreProductPartyMap coreproductpartymap) throws SQLException {
        if (coreproductpartymap.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCoreProductPartyMapParams(ps, coreproductpartymap);
            ps.setInt(101, coreproductpartymap.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CoreProductPartyMap> coreproductpartymaps) throws SQLException {
        if (coreproductpartymaps == null || coreproductpartymaps.isEmpty())
            return new int[0];
        for (CoreProductPartyMap coreproductpartymap : coreproductpartymaps) {
            if (coreproductpartymap == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (coreproductpartymap.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreProductPartyMap>> batches = chunkList(coreproductpartymaps, batchSize);
        int[] totalResults = new int[coreproductpartymaps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreProductPartyMap> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CoreProductPartyMap coreproductpartymap : batch) {
                        setCoreProductPartyMapParams(ps, coreproductpartymap);
                        ps.setInt(101, coreproductpartymap.getID());
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

    private void setCoreProductPartyMapParams(PreparedStatement ps, CoreProductPartyMap coreproductpartymap) throws SQLException {
        Integer val1 = coreproductpartymap.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = coreproductpartymap.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, coreproductpartymap.getApplicantPartyCode());
        Integer val4 = coreproductpartymap.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, coreproductpartymap.getIssuingPartyCode());
        ps.setString(6, coreproductpartymap.getTypeCode());
        ps.setString(7, coreproductpartymap.getSubTypeCode());
        ps.setString(8, coreproductpartymap.getActiveCode());
        ps.setString(9, coreproductpartymap.getStageCode());
        ps.setString(10, coreproductpartymap.getStatusCode());
        ps.setString(11, coreproductpartymap.getCreatedOn());
        java.math.BigDecimal val12 = coreproductpartymap.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, coreproductpartymap.getLastUpdatedOn());
        java.math.BigDecimal val14 = coreproductpartymap.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, coreproductpartymap.getLastAuthorisedOn());
        java.math.BigDecimal val16 = coreproductpartymap.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, coreproductpartymap.getTemplate());
        java.math.BigDecimal val18 = coreproductpartymap.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = coreproductpartymap.getProcessID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, coreproductpartymap.getSubProductCode());
        ps.setString(21, coreproductpartymap.getSubProductDescription());
        ps.setString(22, coreproductpartymap.getPrimaryParty());
        ps.setString(23, coreproductpartymap.getFinancingMethod());
        java.math.BigDecimal val24 = coreproductpartymap.getAssetLiabilityApplicable();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = coreproductpartymap.getCreditLineApplicable();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, coreproductpartymap.getAutoClosureApplicable());
        ps.setString(27, coreproductpartymap.getRecourseApplicable());
        java.math.BigDecimal val28 = coreproductpartymap.getMinTenorAllowed();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = coreproductpartymap.getMaxTenorAllowed();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = coreproductpartymap.getGraceDays();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = coreproductpartymap.getMaxFinancePercent();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = coreproductpartymap.getRecoursePercent();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, coreproductpartymap.getHolidayTreatment());
        ps.setString(34, coreproductpartymap.getMultipleDisbursementAllowed());
        java.math.BigDecimal val35 = coreproductpartymap.getNoOfDisbursementAllowed();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, coreproductpartymap.getPrePaymentAllowed());
        ps.setString(37, coreproductpartymap.getPartRepaymentAllowed());
        ps.setString(38, coreproductpartymap.getAutoDebitAllowed());
        ps.setString(39, coreproductpartymap.getAllowedMode());
        ps.setString(40, coreproductpartymap.getPreClosureAllowed());
        ps.setString(41, coreproductpartymap.getAllowDebitCreditAdjust());
        ps.setString(42, coreproductpartymap.getRecessionPeriod());
        java.math.BigDecimal val43 = coreproductpartymap.getRepaymentAmountAllocation();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, coreproductpartymap.getAllocationRule());
        ps.setString(45, coreproductpartymap.getAppropriationSequence());
        ps.setString(46, coreproductpartymap.getNpaAppropriationSequence());
        ps.setString(47, coreproductpartymap.getPenaltyCalculationFrom());
        java.math.BigDecimal val48 = coreproductpartymap.getNoOfRetries();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, coreproductpartymap.getDisbursementSchedule());
        ps.setString(50, coreproductpartymap.getAutoDebitType());
        ps.setString(51, coreproductpartymap.getIntraDayDebitFrequency());
        java.math.BigDecimal val52 = coreproductpartymap.getDisbursementDays();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        java.math.BigDecimal val53 = coreproductpartymap.getFeesAndChargesScheme();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, coreproductpartymap.getAlertsNotificationsScheme());
        ps.setString(55, coreproductpartymap.getAdvicesScheme());
        ps.setString(56, coreproductpartymap.getAssetScheme());
        ps.setString(57, coreproductpartymap.getLimitCollateralScheme());
        ps.setString(58, coreproductpartymap.getNpaDelinquencyWriteoff());
        ps.setString(59, coreproductpartymap.getAllowedBranches());
        ps.setString(60, coreproductpartymap.getAllowedCustomerType());
        ps.setString(61, coreproductpartymap.getTimeOfFirstDebit());
        java.math.BigDecimal val62 = coreproductpartymap.getNoOfDaysFromGraceDays();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        Integer val63 = coreproductpartymap.getCustomerID();
        if (val63 != null) {
            ps.setInt(63, val63);
        } else {
            ps.setNull(63, Types.INTEGER);
        }
        ps.setString(64, coreproductpartymap.getCustomerProducts());
        Integer val65 = coreproductpartymap.getMaxDuration();
        if (val65 != null) {
            ps.setInt(65, val65);
        } else {
            ps.setNull(65, Types.INTEGER);
        }
        Integer val66 = coreproductpartymap.getMinDuration();
        if (val66 != null) {
            ps.setInt(66, val66);
        } else {
            ps.setNull(66, Types.INTEGER);
        }
        java.math.BigDecimal val67 = coreproductpartymap.getStalePeriod();
        if (val67 != null) {
            ps.setBigDecimal(67, val67);
        } else {
            ps.setNull(67, Types.DECIMAL);
        }
        ps.setString(68, coreproductpartymap.getAcceptanceRequired());
        ps.setString(69, coreproductpartymap.getDisbursementAccount());
        ps.setString(70, coreproductpartymap.getMarginAccount());
        ps.setString(71, coreproductpartymap.getOnlineChargesAcc());
        ps.setString(72, coreproductpartymap.getBatchBillingChargesAcc());
        ps.setString(73, coreproductpartymap.getInterestCollectionAcc());
        ps.setString(74, coreproductpartymap.getSettlementAutoDebitAc());
        ps.setString(75, coreproductpartymap.getAnchorParty());
        ps.setString(76, coreproductpartymap.getBorrowerParty());
        ps.setString(77, coreproductpartymap.getInvoiceBy());
        ps.setString(78, coreproductpartymap.getFinanceBy());
        java.math.BigDecimal val79 = coreproductpartymap.getInterestCalculation();
        if (val79 != null) {
            ps.setBigDecimal(79, val79);
        } else {
            ps.setNull(79, Types.DECIMAL);
        }
        java.math.BigDecimal val80 = coreproductpartymap.getExposureMaintananceReq();
        if (val80 != null) {
            ps.setBigDecimal(80, val80);
        } else {
            ps.setNull(80, Types.DECIMAL);
        }
        ps.setString(81, coreproductpartymap.getAccrualFrequency());
        Integer val82 = coreproductpartymap.getLimitID();
        if (val82 != null) {
            ps.setInt(82, val82);
        } else {
            ps.setNull(82, Types.INTEGER);
        }
        ps.setString(83, coreproductpartymap.getLimitType());
        ps.setString(84, coreproductpartymap.getLimitEffectiveDate());
        ps.setString(85, coreproductpartymap.getLimitExpiryDate());
        java.math.BigDecimal val86 = coreproductpartymap.getLimitAmount();
        if (val86 != null) {
            ps.setBigDecimal(86, val86);
        } else {
            ps.setNull(86, Types.DECIMAL);
        }
        java.math.BigDecimal val87 = coreproductpartymap.getLimitUtilizedLimit();
        if (val87 != null) {
            ps.setBigDecimal(87, val87);
        } else {
            ps.setNull(87, Types.DECIMAL);
        }
        java.math.BigDecimal val88 = coreproductpartymap.getLimitAvailableLimit();
        if (val88 != null) {
            ps.setBigDecimal(88, val88);
        } else {
            ps.setNull(88, Types.DECIMAL);
        }
        java.math.BigDecimal val89 = coreproductpartymap.getLimitRecoursePercent();
        if (val89 != null) {
            ps.setBigDecimal(89, val89);
        } else {
            ps.setNull(89, Types.DECIMAL);
        }
        ps.setString(90, coreproductpartymap.getLimitRecourseApplicable());
        ps.setString(91, coreproductpartymap.getFinanceToParty());
        ps.setString(92, coreproductpartymap.getFinanceDebitParty());
        ps.setString(93, coreproductpartymap.getProductStatusCode());
        ps.setString(94, coreproductpartymap.getSegmentCode());
        ps.setString(95, coreproductpartymap.getProductCode());
        ps.setString(96, coreproductpartymap.getProductName());
        ps.setString(97, coreproductpartymap.getSubProductName());
        java.math.BigDecimal val98 = coreproductpartymap.getAllowPayment();
        if (val98 != null) {
            ps.setBigDecimal(98, val98);
        } else {
            ps.setNull(98, Types.DECIMAL);
        }
        java.math.BigDecimal val99 = coreproductpartymap.getAllowCollection();
        if (val99 != null) {
            ps.setBigDecimal(99, val99);
        } else {
            ps.setNull(99, Types.DECIMAL);
        }
        ps.setString(100, coreproductpartymap.getApplicantParty());
        ps.setString(101, coreproductpartymap.getFulfillmentParty());
    }

    private CoreProductPartyMap extract(ResultSet rs) throws SQLException {
        CoreProductPartyMap coreproductpartymap = new CoreProductPartyMap();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        coreproductpartymap.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        coreproductpartymap.setReferenceID(REFERENCE_ID);
        coreproductpartymap.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        coreproductpartymap.setApplicantRefID(APPLICANT_REF_ID);
        coreproductpartymap.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        coreproductpartymap.setTypeCode(rs.getString(COL_TYPE_CODE));
        coreproductpartymap.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        coreproductpartymap.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        coreproductpartymap.setStageCode(rs.getString(COL_STAGE_CODE));
        coreproductpartymap.setStatusCode(rs.getString(COL_STATUS_CODE));
        coreproductpartymap.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        coreproductpartymap.setCreatedBy(CREATED_BY);
        coreproductpartymap.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        coreproductpartymap.setLastUpdatedBy(LAST_UPDATED_BY);
        coreproductpartymap.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        coreproductpartymap.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        coreproductpartymap.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        coreproductpartymap.setIsTemplate(IS_TEMPLATE);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        coreproductpartymap.setProcessID(PROCESS_ID);
        coreproductpartymap.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        coreproductpartymap.setSubProductDescription(rs.getString(COL_SUB_PRODUCT_DESCRIPTION));
        coreproductpartymap.setPrimaryParty(rs.getString(COL_PRIMARY_PARTY));
        coreproductpartymap.setFinancingMethod(rs.getString(COL_FINANCING_METHOD));
        java.math.BigDecimal ASSET_LIABILITY_APPLICABLE = rs.getObject(COL_ASSET_LIABILITY_APPLICABLE, java.math.BigDecimal.class);
        coreproductpartymap.setAssetLiabilityApplicable(ASSET_LIABILITY_APPLICABLE);
        java.math.BigDecimal CREDIT_LINE_APPLICABLE = rs.getObject(COL_CREDIT_LINE_APPLICABLE, java.math.BigDecimal.class);
        coreproductpartymap.setCreditLineApplicable(CREDIT_LINE_APPLICABLE);
        coreproductpartymap.setAutoClosureApplicable(rs.getString(COL_AUTO_CLOSURE_APPLICABLE));
        coreproductpartymap.setRecourseApplicable(rs.getString(COL_RECOURSE_APPLICABLE));
        java.math.BigDecimal MIN_TENOR_ALLOWED = rs.getObject(COL_MIN_TENOR_ALLOWED, java.math.BigDecimal.class);
        coreproductpartymap.setMinTenorAllowed(MIN_TENOR_ALLOWED);
        java.math.BigDecimal MAX_TENOR_ALLOWED = rs.getObject(COL_MAX_TENOR_ALLOWED, java.math.BigDecimal.class);
        coreproductpartymap.setMaxTenorAllowed(MAX_TENOR_ALLOWED);
        java.math.BigDecimal GRACE_DAYS = rs.getObject(COL_GRACE_DAYS, java.math.BigDecimal.class);
        coreproductpartymap.setGraceDays(GRACE_DAYS);
        java.math.BigDecimal MAX_FINANCE_PERCENT = rs.getObject(COL_MAX_FINANCE_PERCENT, java.math.BigDecimal.class);
        coreproductpartymap.setMaxFinancePercent(MAX_FINANCE_PERCENT);
        java.math.BigDecimal RECOURSE_PERCENT = rs.getObject(COL_RECOURSE_PERCENT, java.math.BigDecimal.class);
        coreproductpartymap.setRecoursePercent(RECOURSE_PERCENT);
        coreproductpartymap.setHolidayTreatment(rs.getString(COL_HOLIDAY_TREATMENT));
        coreproductpartymap.setMultipleDisbursementAllowed(rs.getString(COL_MULTIPLE_DISBURSEMENT_ALLOWED));
        java.math.BigDecimal NO_OF_DISBURSEMENT_ALLOWED = rs.getObject(COL_NO_OF_DISBURSEMENT_ALLOWED, java.math.BigDecimal.class);
        coreproductpartymap.setNoOfDisbursementAllowed(NO_OF_DISBURSEMENT_ALLOWED);
        coreproductpartymap.setPrePaymentAllowed(rs.getString(COL_PRE_PAYMENT_ALLOWED));
        coreproductpartymap.setPartRepaymentAllowed(rs.getString(COL_PART_REPAYMENT_ALLOWED));
        coreproductpartymap.setAutoDebitAllowed(rs.getString(COL_AUTO_DEBIT_ALLOWED));
        coreproductpartymap.setAllowedMode(rs.getString(COL_ALLOWED_MODE));
        coreproductpartymap.setPreClosureAllowed(rs.getString(COL_PRE_CLOSURE_ALLOWED));
        coreproductpartymap.setAllowDebitCreditAdjust(rs.getString(COL_ALLOW_DEBIT_CREDIT_ADJUST));
        coreproductpartymap.setRecessionPeriod(rs.getString(COL_RECESSION_PERIOD));
        java.math.BigDecimal REPAYMENT_AMOUNT_ALLOCATION = rs.getObject(COL_REPAYMENT_AMOUNT_ALLOCATION, java.math.BigDecimal.class);
        coreproductpartymap.setRepaymentAmountAllocation(REPAYMENT_AMOUNT_ALLOCATION);
        coreproductpartymap.setAllocationRule(rs.getString(COL_ALLOCATION_RULE));
        coreproductpartymap.setAppropriationSequence(rs.getString(COL_APPROPRIATION_SEQUENCE));
        coreproductpartymap.setNpaAppropriationSequence(rs.getString(COL_NPA_APPROPRIATION_SEQUENCE));
        coreproductpartymap.setPenaltyCalculationFrom(rs.getString(COL_PENALTY_CALCULATION_FROM));
        java.math.BigDecimal NO_OF_RETRIES = rs.getObject(COL_NO_OF_RETRIES, java.math.BigDecimal.class);
        coreproductpartymap.setNoOfRetries(NO_OF_RETRIES);
        coreproductpartymap.setDisbursementSchedule(rs.getString(COL_DISBURSEMENT_SCHEDULE));
        coreproductpartymap.setAutoDebitType(rs.getString(COL_AUTO_DEBIT_TYPE));
        coreproductpartymap.setIntraDayDebitFrequency(rs.getString(COL_INTRA_DAY_DEBIT_FREQUENCY));
        java.math.BigDecimal DISBURSEMENT_DAYS = rs.getObject(COL_DISBURSEMENT_DAYS, java.math.BigDecimal.class);
        coreproductpartymap.setDisbursementDays(DISBURSEMENT_DAYS);
        java.math.BigDecimal FEES_AND_CHARGES_SCHEME = rs.getObject(COL_FEES_AND_CHARGES_SCHEME, java.math.BigDecimal.class);
        coreproductpartymap.setFeesAndChargesScheme(FEES_AND_CHARGES_SCHEME);
        coreproductpartymap.setAlertsNotificationsScheme(rs.getString(COL_ALERTS_NOTIFICATIONS_SCHEME));
        coreproductpartymap.setAdvicesScheme(rs.getString(COL_ADVICES_SCHEME));
        coreproductpartymap.setAssetScheme(rs.getString(COL_ASSET_SCHEME));
        coreproductpartymap.setLimitCollateralScheme(rs.getString(COL_LIMIT_COLLATERAL_SCHEME));
        coreproductpartymap.setNpaDelinquencyWriteoff(rs.getString(COL_NPA_DELINQUENCY_WRITEOFF));
        coreproductpartymap.setAllowedBranches(rs.getString(COL_ALLOWED_BRANCHES));
        coreproductpartymap.setAllowedCustomerType(rs.getString(COL_ALLOWED_CUSTOMER_TYPE));
        coreproductpartymap.setTimeOfFirstDebit(rs.getString(COL_TIME_OF_FIRST_DEBIT));
        java.math.BigDecimal NO_OF_DAYS_FROM_GRACE_DAYS = rs.getObject(COL_NO_OF_DAYS_FROM_GRACE_DAYS, java.math.BigDecimal.class);
        coreproductpartymap.setNoOfDaysFromGraceDays(NO_OF_DAYS_FROM_GRACE_DAYS);
        Integer CUSTOMER_ID = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        coreproductpartymap.setCustomerID(CUSTOMER_ID);
        coreproductpartymap.setCustomerProducts(rs.getString(COL_CUSTOMER_PRODUCTS));
        Integer MAX_DURATION = rs.getObject(COL_MAX_DURATION, Integer.class);
        coreproductpartymap.setMaxDuration(MAX_DURATION);
        Integer MIN_DURATION = rs.getObject(COL_MIN_DURATION, Integer.class);
        coreproductpartymap.setMinDuration(MIN_DURATION);
        java.math.BigDecimal STALE_PERIOD = rs.getObject(COL_STALE_PERIOD, java.math.BigDecimal.class);
        coreproductpartymap.setStalePeriod(STALE_PERIOD);
        coreproductpartymap.setAcceptanceRequired(rs.getString(COL_ACCEPTANCE_REQUIRED));
        coreproductpartymap.setDisbursementAccount(rs.getString(COL_DISBURSEMENT_ACCOUNT));
        coreproductpartymap.setMarginAccount(rs.getString(COL_MARGIN_ACCOUNT));
        coreproductpartymap.setOnlineChargesAcc(rs.getString(COL_ONLINE_CHARGES_ACC));
        coreproductpartymap.setBatchBillingChargesAcc(rs.getString(COL_BATCH_BILLING_CHARGES_ACC));
        coreproductpartymap.setInterestCollectionAcc(rs.getString(COL_INTEREST_COLLECTION_ACC));
        coreproductpartymap.setSettlementAutoDebitAc(rs.getString(COL_SETTLEMENT_AUTO_DEBIT_AC));
        coreproductpartymap.setAnchorParty(rs.getString(COL_ANCHOR_PARTY));
        coreproductpartymap.setBorrowerParty(rs.getString(COL_BORROWER_PARTY));
        coreproductpartymap.setInvoiceBy(rs.getString(COL_INVOICE_BY));
        coreproductpartymap.setFinanceBy(rs.getString(COL_FINANCE_BY));
        java.math.BigDecimal INTEREST_CALCULATION = rs.getObject(COL_INTEREST_CALCULATION, java.math.BigDecimal.class);
        coreproductpartymap.setInterestCalculation(INTEREST_CALCULATION);
        java.math.BigDecimal EXPOSURE_MAINTANANCE_REQ = rs.getObject(COL_EXPOSURE_MAINTANANCE_REQ, java.math.BigDecimal.class);
        coreproductpartymap.setExposureMaintananceReq(EXPOSURE_MAINTANANCE_REQ);
        coreproductpartymap.setAccrualFrequency(rs.getString(COL_ACCRUAL_FREQUENCY));
        Integer LIMIT_ID = rs.getObject(COL_LIMIT_ID, Integer.class);
        coreproductpartymap.setLimitID(LIMIT_ID);
        coreproductpartymap.setLimitType(rs.getString(COL_LIMIT_TYPE));
        coreproductpartymap.setLimitEffectiveDate(rs.getString(COL_LIMIT_EFFECTIVE_DATE));
        coreproductpartymap.setLimitExpiryDate(rs.getString(COL_LIMIT_EXPIRY_DATE));
        java.math.BigDecimal LIMIT_AMOUNT = rs.getObject(COL_LIMIT_AMOUNT, java.math.BigDecimal.class);
        coreproductpartymap.setLimitAmount(LIMIT_AMOUNT);
        java.math.BigDecimal LIMIT_UTILIZED_LIMIT = rs.getObject(COL_LIMIT_UTILIZED_LIMIT, java.math.BigDecimal.class);
        coreproductpartymap.setLimitUtilizedLimit(LIMIT_UTILIZED_LIMIT);
        java.math.BigDecimal LIMIT_AVAILABLE_LIMIT = rs.getObject(COL_LIMIT_AVAILABLE_LIMIT, java.math.BigDecimal.class);
        coreproductpartymap.setLimitAvailableLimit(LIMIT_AVAILABLE_LIMIT);
        java.math.BigDecimal LIMIT_RECOURSE_PERCENT = rs.getObject(COL_LIMIT_RECOURSE_PERCENT, java.math.BigDecimal.class);
        coreproductpartymap.setLimitRecoursePercent(LIMIT_RECOURSE_PERCENT);
        coreproductpartymap.setLimitRecourseApplicable(rs.getString(COL_LIMIT_RECOURSE_APPLICABLE));
        coreproductpartymap.setFinanceToParty(rs.getString(COL_FINANCE_TO_PARTY));
        coreproductpartymap.setFinanceDebitParty(rs.getString(COL_FINANCE_DEBIT_PARTY));
        coreproductpartymap.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        coreproductpartymap.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        coreproductpartymap.setProductCode(rs.getString(COL_PRODUCT_CODE));
        coreproductpartymap.setProductName(rs.getString(COL_PRODUCT_NAME));
        coreproductpartymap.setSubProductName(rs.getString(COL_SUB_PRODUCT_NAME));
        java.math.BigDecimal ALLOW_PAYMENT = rs.getObject(COL_ALLOW_PAYMENT, java.math.BigDecimal.class);
        coreproductpartymap.setAllowPayment(ALLOW_PAYMENT);
        java.math.BigDecimal ALLOW_COLLECTION = rs.getObject(COL_ALLOW_COLLECTION, java.math.BigDecimal.class);
        coreproductpartymap.setAllowCollection(ALLOW_COLLECTION);
        coreproductpartymap.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        coreproductpartymap.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        return coreproductpartymap;
    }
}
