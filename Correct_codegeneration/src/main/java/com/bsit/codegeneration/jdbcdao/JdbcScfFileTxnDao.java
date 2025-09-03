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

public class JdbcScfFileTxnDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfFileTxnDao.class);

    private static final String TABLE = "SCF_FILE_TXN";

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

    private static final String COL_ANCHOR_CRN = "ANCHOR_CRN";

    private static final String COL_FILE_MASTER_REF_NO = "FILE_MASTER_REF_NO";

    private static final String COL_FILE_LINES_REF_NO = "FILE_LINES_REF_NO";

    private static final String COL_TXN_NO = "TXN_NO";

    private static final String COL_TXN_DATE = "TXN_DATE";

    private static final String COL_TXN_CURRENCY = "TXN_CURRENCY";

    private static final String COL_TXN_DUE_DATE = "TXN_DUE_DATE";

    private static final String COL_TXN_AMOUNT = "TXN_AMOUNT";

    private static final String COL_COUNTER_PARTY_CRN = "COUNTER_PARTY_CRN";

    private static final String COL_COUNTER_PARTY_NAME = "COUNTER_PARTY_NAME";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_INPUT_BRANCH = "INPUT_BRANCH";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_FINANCE_AMOUNT = "FINANCE_AMOUNT";

    private static final String COL_DEBIT_PARTY_CRN = "DEBIT_PARTY_CRN";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_FINANCING_AMOUNT = "FINANCING_AMOUNT";

    private static final String COL_CREDIT_PARTY_CRN = "CREDIT_PARTY_CRN";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_MARGIN_RATE = "MARGIN_RATE";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_PENALTY_PERCENT = "PENALTY_PERCENT";

    private static final String COL_INTEREST_START_DATE = "INTEREST_START_DATE";

    private static final String COL_INTEREST_TYPE = "INTEREST_TYPE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_BASE_CODE = "BASE_CODE";

    private static final String COL_TENOR = "TENOR";

    private static final String COL_INTEREST_PERIOD = "INTEREST_PERIOD";

    private static final String COL_CONTRACT_PERIOD = "CONTRACT_PERIOD";

    private static final String COL_GRACE_PERIOD = "GRACE_PERIOD";

    private static final String COL_BUYER_ID = "BUYER_ID";

    private static final String COL_SELLER_ID = "SELLER_ID";

    private static final String COL_FINANCE_REF_NO = "FINANCE_REF_NO";

    private static final String COL_PAYMENT_TYPE = "PAYMENT_TYPE";

    private static final String COL_PAYMENT_DATE = "PAYMENT_DATE";

    private static final String COL_DEBIT_ACC_NO = "DEBIT_ACC_NO";

    private static final String COL_PAYMENT_AMOUNT = "PAYMENT_AMOUNT";

    private static final String COL_BENE_NAME = "BENE_NAME";

    private static final String COL_BENE_BRANCH = "BENE_BRANCH";

    private static final String COL_UTR_NUMBER = "UTR_NUMBER";

    private static final String COL_PROCESSING_DATE = "PROCESSING_DATE";

    private static final String COL_CMS_REF_NO = "CMS_REF_NO";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_LIMIT_NODE1 = "LIMIT_NODE1";

    private static final String COL_VAL_STATUS = "VAL_STATUS";

    private static final String COL_VAL_REMARKS = "VAL_REMARKS";

    private static final String COL_VAL_REQ_FILENAME = "VAL_REQ_FILENAME";

    private static final String COL_VAL_REQ_EVENT_REF_ID = "VAL_REQ_EVENT_REF_ID";

    private static final String COL_VAL_REQ_START_TIME = "VAL_REQ_START_TIME";

    private static final String COL_VAL_REQ_END_TIME = "VAL_REQ_END_TIME";

    private static final String COL_VAL_REQ_STATUS = "VAL_REQ_STATUS";

    private static final String COL_VAL_REQ_REMARKS = "VAL_REQ_REMARKS";

    private static final String COL_VAL_RES_FILENAME = "VAL_RES_FILENAME";

    private static final String COL_VAL_RES_EVENT_REF_ID = "VAL_RES_EVENT_REF_ID";

    private static final String COL_VAL_RES_START_TIME = "VAL_RES_START_TIME";

    private static final String COL_VAL_RES_END_TIME = "VAL_RES_END_TIME";

    private static final String COL_VAL_RES_STATUS = "VAL_RES_STATUS";

    private static final String COL_VAL_RES_REMARKS = "VAL_RES_REMARKS";

    private static final String COL_FINPAY_REQ_FILENAME = "FINPAY_REQ_FILENAME";

    private static final String COL_FINPAY_REQ_EVENT_REF_ID = "FINPAY_REQ_EVENT_REF_ID";

    private static final String COL_FINPAY_REQ_START_TIME = "FINPAY_REQ_START_TIME";

    private static final String COL_FINPAY_REQ_END_TIME = "FINPAY_REQ_END_TIME";

    private static final String COL_FINPAY_REQ_STATUS = "FINPAY_REQ_STATUS";

    private static final String COL_FINPAY_REQ_REMARKS = "FINPAY_REQ_REMARKS";

    private static final String COL_FINPAY_RES_FILENAME = "FINPAY_RES_FILENAME";

    private static final String COL_FINPAY_RES_EVENT_REF_ID = "FINPAY_RES_EVENT_REF_ID";

    private static final String COL_FINPAY_RES_START_TIME = "FINPAY_RES_START_TIME";

    private static final String COL_FINPAY_RES_END_TIME = "FINPAY_RES_END_TIME";

    private static final String COL_FINPAY_RES_STATUS = "FINPAY_RES_STATUS";

    private static final String COL_FINPAY_RES_REMARKS = "FINPAY_RES_REMARKS";

    private static final String COL_FINPAY_EOD_FILENAME = "FINPAY_EOD_FILENAME";

    private static final String COL_FINPAY_EOD_EVENT_REF_ID = "FINPAY_EOD_EVENT_REF_ID";

    private static final String COL_FINPAY_EOD_START_TIME = "FINPAY_EOD_START_TIME";

    private static final String COL_FINPAY_EOD_END_TIME = "FINPAY_EOD_END_TIME";

    private static final String COL_FINPAY_EOD_STATUS = "FINPAY_EOD_STATUS";

    private static final String COL_FINPAY_EOD_REMARKS = "FINPAY_EOD_REMARKS";

    private static final String COL_CMS_REQ_FILENAME = "CMS_REQ_FILENAME";

    private static final String COL_CMS_REQ_EVENT_REF_ID = "CMS_REQ_EVENT_REF_ID";

    private static final String COL_CMS_REQ_START_TIME = "CMS_REQ_START_TIME";

    private static final String COL_CMS_REQ_END_TIME = "CMS_REQ_END_TIME";

    private static final String COL_CMS_REQ_STATUS = "CMS_REQ_STATUS";

    private static final String COL_CMS_REQ_REMARKS = "CMS_REQ_REMARKS";

    private static final String COL_CMS_RES_FILENAME = "CMS_RES_FILENAME";

    private static final String COL_CMS_RES_EVENT_REF_ID = "CMS_RES_EVENT_REF_ID";

    private static final String COL_CMS_RES_START_TIME = "CMS_RES_START_TIME";

    private static final String COL_CMS_RES_END_TIME = "CMS_RES_END_TIME";

    private static final String COL_CMS_RES_STATUS = "CMS_RES_STATUS";

    private static final String COL_CMS_RES_REMARKS = "CMS_RES_REMARKS";

    private static final String COL_FBTI_REQ_CORR_ID = "FBTI_REQ_CORR_ID";

    private static final String COL_FBTI_REQ_EVENT_REF_ID = "FBTI_REQ_EVENT_REF_ID";

    private static final String COL_FBTI_REQ_START_TIME = "FBTI_REQ_START_TIME";

    private static final String COL_FBTI_REQ_END_TIME = "FBTI_REQ_END_TIME";

    private static final String COL_FBTI_REQ_STATUS = "FBTI_REQ_STATUS";

    private static final String COL_FBTI_REQ_REMARKS = "FBTI_REQ_REMARKS";

    private static final String COL_FBTI_RES_CORR_ID = "FBTI_RES_CORR_ID";

    private static final String COL_FBTI_RES_EVENT_REF_ID = "FBTI_RES_EVENT_REF_ID";

    private static final String COL_FBTI_RES_START_TIME = "FBTI_RES_START_TIME";

    private static final String COL_FBTI_RES_END_TIME = "FBTI_RES_END_TIME";

    private static final String COL_FBTI_RES_STATUS = "FBTI_RES_STATUS";

    private static final String COL_FBTI_RES_REMARKS = "FBTI_RES_REMARKS";

    private static final String COL_CURRENT_EVENT_NAME = "CURRENT_EVENT_NAME";

    private static final String COL_VAL_LINE_NO = "VAL_LINE_NO";

    private static final String COL_VAL_LINE_CONTENT = "VAL_LINE_CONTENT";

    private static final String COL_LIMIT_NODE2 = "LIMIT_NODE2";

    private static final String COL_EOD_STATUS = "EOD_STATUS";

    private static final String COL_FINPAY_LINE_CONTENT = "FINPAY_LINE_CONTENT";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_PAYMENT_MODE = "PAYMENT_MODE";

    private static final String COL_BENE_ACC_NO = "BENE_ACC_NO";

    private static final String COL_NET_PAYMENT = "NET_PAYMENT";

    private static final String COL_ADVANCE_INTEREST = "ADVANCE_INTEREST";

    private static final String COL_SPREAD_RATE = "SPREAD_RATE";

    private static final String COL_ANCHOR_NAME = "ANCHOR_NAME";

    private static final String COL_SOURCE_OF_CREATION = "SOURCE_OF_CREATION";

    private static final String COL_CHARGES = "CHARGES";

    private static final String COL_CLIENT_CODE = "CLIENT_CODE";

    private static final String COL_SOURCE_SYSTEM = "SOURCE_SYSTEM";

    private static final String COL_DISPLAY_SOURCE_SYSTEM = "DISPLAY_SOURCE_SYSTEM";

    private static final String COL_EVENT_FINPAY_ID = "EVENT_FINPAY_ID";

    private static final String COL_INSTRUMENT_DATE = "INSTRUMENT_DATE";

    private static final String COL_BANK_CODE_INDICATOR = "BANK_CODE_INDICATOR";

    private static final String COL_BENEFICIARY_CODE = "BENEFICIARY_CODE";

    private static final String COL_BENEFICIARY_BANK = "BENEFICIARY_BANK";

    private static final String COL_LOCATION = "LOCATION";

    private static final String COL_PRINT_LOCATION = "PRINT_LOCATION";

    private static final String COL_INSTRUMENT_NUMBER = "INSTRUMENT_NUMBER";

    private static final String COL_BENEFICIARY_ADDRESS_1 = "BENEFICIARY_ADDRESS_1";

    private static final String COL_BENEFICIARY_ADDRESS_2 = "BENEFICIARY_ADDRESS_2";

    private static final String COL_BENEFICIARY_ADDRESS_3 = "BENEFICIARY_ADDRESS_3";

    private static final String COL_BENEFICIARY_ADDRESS_4 = "BENEFICIARY_ADDRESS_4";

    private static final String COL_BENEFICIARY_EMAIL = "BENEFICIARY_EMAIL";

    private static final String COL_BENEFICIARY_MOBILE = "BENEFICIARY_MOBILE";

    private static final String COL_DEBIT_NARRATION = "DEBIT_NARRATION";

    private static final String COL_CREDIT_NARRATION = "CREDIT_NARRATION";

    private static final String COL_PAYMENT_DETAILS_1 = "PAYMENT_DETAILS_1";

    private static final String COL_PAYMENT_DETAILS_2 = "PAYMENT_DETAILS_2";

    private static final String COL_PAYMENT_DETAILS_3 = "PAYMENT_DETAILS_3";

    private static final String COL_PAYMENT_DETAILS_4 = "PAYMENT_DETAILS_4";

    private static final String COL_ENRICHMENT_1 = "ENRICHMENT_1";

    private static final String COL_ENRICHMENT_2 = "ENRICHMENT_2";

    private static final String COL_ENRICHMENT_3 = "ENRICHMENT_3";

    private static final String COL_ENRICHMENT_4 = "ENRICHMENT_4";

    private static final String COL_ENRICHMENT_5 = "ENRICHMENT_5";

    private static final String COL_ENRICHMENT_6 = "ENRICHMENT_6";

    private static final String COL_ENRICHMENT_7 = "ENRICHMENT_7";

    private static final String COL_ENRICHMENT_8 = "ENRICHMENT_8";

    private static final String COL_ENRICHMENT_9 = "ENRICHMENT_9";

    private static final String COL_ENRICHMENT_10 = "ENRICHMENT_10";

    private static final String COL_ENRICHMENT_11 = "ENRICHMENT_11";

    private static final String COL_ENRICHMENT_12 = "ENRICHMENT_12";

    private static final String COL_ENRICHMENT_13 = "ENRICHMENT_13";

    private static final String COL_ENRICHMENT_14 = "ENRICHMENT_14";

    private static final String COL_ENRICHMENT_15 = "ENRICHMENT_15";

    private static final String COL_ENRICHMENT_16 = "ENRICHMENT_16";

    private static final String COL_ENRICHMENT_17 = "ENRICHMENT_17";

    private static final String COL_ENRICHMENT_18 = "ENRICHMENT_18";

    private static final String COL_ENRICHMENT_19 = "ENRICHMENT_19";

    private static final String COL_ENRICHMENT_20 = "ENRICHMENT_20";

    private static final String COL_ORIG_TXN_AMOUNT = "ORIG_TXN_AMOUNT";

    private static final String COL_CREDIT_PARTY_NAME = "CREDIT_PARTY_NAME";

    private static final String COL_COUNTER_PARTY_ROLE = "COUNTER_PARTY_ROLE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_FILE_LINES_REF_NO, COL_TXN_NO, COL_TXN_DATE, COL_TXN_CURRENCY, COL_TXN_DUE_DATE, COL_TXN_AMOUNT, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_PRODUCT_TYPE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_FINANCE_AMOUNT, COL_DEBIT_PARTY_CRN, COL_EFFECTIVE_DATE, COL_FINANCING_AMOUNT, COL_CREDIT_PARTY_CRN, COL_INTEREST_RATE, COL_MARGIN_RATE, COL_MATURITY_DATE, COL_PENALTY_PERCENT, COL_INTEREST_START_DATE, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_TENOR, COL_INTEREST_PERIOD, COL_CONTRACT_PERIOD, COL_GRACE_PERIOD, COL_BUYER_ID, COL_SELLER_ID, COL_FINANCE_REF_NO, COL_PAYMENT_TYPE, COL_PAYMENT_DATE, COL_DEBIT_ACC_NO, COL_PAYMENT_AMOUNT, COL_BENE_NAME, COL_BENE_BRANCH, COL_UTR_NUMBER, COL_PROCESSING_DATE, COL_CMS_REF_NO, COL_FILE_NAME, COL_STATUS, COL_REMARKS, COL_BATCH_REF_ID, COL_LIMIT_NODE1, COL_VAL_STATUS, COL_VAL_REMARKS, COL_VAL_REQ_FILENAME, COL_VAL_REQ_EVENT_REF_ID, COL_VAL_REQ_START_TIME, COL_VAL_REQ_END_TIME, COL_VAL_REQ_STATUS, COL_VAL_REQ_REMARKS, COL_VAL_RES_FILENAME, COL_VAL_RES_EVENT_REF_ID, COL_VAL_RES_START_TIME, COL_VAL_RES_END_TIME, COL_VAL_RES_STATUS, COL_VAL_RES_REMARKS, COL_FINPAY_REQ_FILENAME, COL_FINPAY_REQ_EVENT_REF_ID, COL_FINPAY_REQ_START_TIME, COL_FINPAY_REQ_END_TIME, COL_FINPAY_REQ_STATUS, COL_FINPAY_REQ_REMARKS, COL_FINPAY_RES_FILENAME, COL_FINPAY_RES_EVENT_REF_ID, COL_FINPAY_RES_START_TIME, COL_FINPAY_RES_END_TIME, COL_FINPAY_RES_STATUS, COL_FINPAY_RES_REMARKS, COL_FINPAY_EOD_FILENAME, COL_FINPAY_EOD_EVENT_REF_ID, COL_FINPAY_EOD_START_TIME, COL_FINPAY_EOD_END_TIME, COL_FINPAY_EOD_STATUS, COL_FINPAY_EOD_REMARKS, COL_CMS_REQ_FILENAME, COL_CMS_REQ_EVENT_REF_ID, COL_CMS_REQ_START_TIME, COL_CMS_REQ_END_TIME, COL_CMS_REQ_STATUS, COL_CMS_REQ_REMARKS, COL_CMS_RES_FILENAME, COL_CMS_RES_EVENT_REF_ID, COL_CMS_RES_START_TIME, COL_CMS_RES_END_TIME, COL_CMS_RES_STATUS, COL_CMS_RES_REMARKS, COL_FBTI_REQ_CORR_ID, COL_FBTI_REQ_EVENT_REF_ID, COL_FBTI_REQ_START_TIME, COL_FBTI_REQ_END_TIME, COL_FBTI_REQ_STATUS, COL_FBTI_REQ_REMARKS, COL_FBTI_RES_CORR_ID, COL_FBTI_RES_EVENT_REF_ID, COL_FBTI_RES_START_TIME, COL_FBTI_RES_END_TIME, COL_FBTI_RES_STATUS, COL_FBTI_RES_REMARKS, COL_CURRENT_EVENT_NAME, COL_VAL_LINE_NO, COL_VAL_LINE_CONTENT, COL_LIMIT_NODE2, COL_EOD_STATUS, COL_FINPAY_LINE_CONTENT, COL_VALUE_DATE, COL_PAYMENT_MODE, COL_BENE_ACC_NO, COL_NET_PAYMENT, COL_ADVANCE_INTEREST, COL_SPREAD_RATE, COL_ANCHOR_NAME, COL_SOURCE_OF_CREATION, COL_CHARGES, COL_CLIENT_CODE, COL_SOURCE_SYSTEM, COL_DISPLAY_SOURCE_SYSTEM, COL_EVENT_FINPAY_ID, COL_INSTRUMENT_DATE, COL_BANK_CODE_INDICATOR, COL_BENEFICIARY_CODE, COL_BENEFICIARY_BANK, COL_LOCATION, COL_PRINT_LOCATION, COL_INSTRUMENT_NUMBER, COL_BENEFICIARY_ADDRESS_1, COL_BENEFICIARY_ADDRESS_2, COL_BENEFICIARY_ADDRESS_3, COL_BENEFICIARY_ADDRESS_4, COL_BENEFICIARY_EMAIL, COL_BENEFICIARY_MOBILE, COL_DEBIT_NARRATION, COL_CREDIT_NARRATION, COL_PAYMENT_DETAILS_1, COL_PAYMENT_DETAILS_2, COL_PAYMENT_DETAILS_3, COL_PAYMENT_DETAILS_4, COL_ENRICHMENT_1, COL_ENRICHMENT_2, COL_ENRICHMENT_3, COL_ENRICHMENT_4, COL_ENRICHMENT_5, COL_ENRICHMENT_6, COL_ENRICHMENT_7, COL_ENRICHMENT_8, COL_ENRICHMENT_9, COL_ENRICHMENT_10, COL_ENRICHMENT_11, COL_ENRICHMENT_12, COL_ENRICHMENT_13, COL_ENRICHMENT_14, COL_ENRICHMENT_15, COL_ENRICHMENT_16, COL_ENRICHMENT_17, COL_ENRICHMENT_18, COL_ENRICHMENT_19, COL_ENRICHMENT_20, COL_ORIG_TXN_AMOUNT, COL_CREDIT_PARTY_NAME, COL_COUNTER_PARTY_ROLE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, FILE_LINES_REF_NO, TXN_NO, TXN_DATE, TXN_CURRENCY, TXN_DUE_DATE, TXN_AMOUNT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, PRODUCT_TYPE, INPUT_BRANCH, BEHALF_OF_BRANCH, FINANCE_AMOUNT, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INTEREST_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR, INTEREST_PERIOD, CONTRACT_PERIOD, GRACE_PERIOD, BUYER_ID, SELLER_ID, FINANCE_REF_NO, PAYMENT_TYPE, PAYMENT_DATE, DEBIT_ACC_NO, PAYMENT_AMOUNT, BENE_NAME, BENE_BRANCH, UTR_NUMBER, PROCESSING_DATE, CMS_REF_NO, FILE_NAME, STATUS, REMARKS, BATCH_REF_ID, LIMIT_NODE1, VAL_STATUS, VAL_REMARKS, VAL_REQ_FILENAME, VAL_REQ_EVENT_REF_ID, VAL_REQ_START_TIME, VAL_REQ_END_TIME, VAL_REQ_STATUS, VAL_REQ_REMARKS, VAL_RES_FILENAME, VAL_RES_EVENT_REF_ID, VAL_RES_START_TIME, VAL_RES_END_TIME, VAL_RES_STATUS, VAL_RES_REMARKS, FINPAY_REQ_FILENAME, FINPAY_REQ_EVENT_REF_ID, FINPAY_REQ_START_TIME, FINPAY_REQ_END_TIME, FINPAY_REQ_STATUS, FINPAY_REQ_REMARKS, FINPAY_RES_FILENAME, FINPAY_RES_EVENT_REF_ID, FINPAY_RES_START_TIME, FINPAY_RES_END_TIME, FINPAY_RES_STATUS, FINPAY_RES_REMARKS, FINPAY_EOD_FILENAME, FINPAY_EOD_EVENT_REF_ID, FINPAY_EOD_START_TIME, FINPAY_EOD_END_TIME, FINPAY_EOD_STATUS, FINPAY_EOD_REMARKS, CMS_REQ_FILENAME, CMS_REQ_EVENT_REF_ID, CMS_REQ_START_TIME, CMS_REQ_END_TIME, CMS_REQ_STATUS, CMS_REQ_REMARKS, CMS_RES_FILENAME, CMS_RES_EVENT_REF_ID, CMS_RES_START_TIME, CMS_RES_END_TIME, CMS_RES_STATUS, CMS_RES_REMARKS, FBTI_REQ_CORR_ID, FBTI_REQ_EVENT_REF_ID, FBTI_REQ_START_TIME, FBTI_REQ_END_TIME, FBTI_REQ_STATUS, FBTI_REQ_REMARKS, FBTI_RES_CORR_ID, FBTI_RES_EVENT_REF_ID, FBTI_RES_START_TIME, FBTI_RES_END_TIME, FBTI_RES_STATUS, FBTI_RES_REMARKS, CURRENT_EVENT_NAME, VAL_LINE_NO, VAL_LINE_CONTENT, LIMIT_NODE2, EOD_STATUS, FINPAY_LINE_CONTENT, VALUE_DATE, PAYMENT_MODE, BENE_ACC_NO, NET_PAYMENT, ADVANCE_INTEREST, SPREAD_RATE, ANCHOR_NAME, SOURCE_OF_CREATION, CHARGES, CLIENT_CODE, SOURCE_SYSTEM, DISPLAY_SOURCE_SYSTEM, EVENT_FINPAY_ID, INSTRUMENT_DATE, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_BANK, LOCATION, PRINT_LOCATION, INSTRUMENT_NUMBER, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, ENRICHMENT_1, ENRICHMENT_2, ENRICHMENT_3, ENRICHMENT_4, ENRICHMENT_5, ENRICHMENT_6, ENRICHMENT_7, ENRICHMENT_8, ENRICHMENT_9, ENRICHMENT_10, ENRICHMENT_11, ENRICHMENT_12, ENRICHMENT_13, ENRICHMENT_14, ENRICHMENT_15, ENRICHMENT_16, ENRICHMENT_17, ENRICHMENT_18, ENRICHMENT_19, ENRICHMENT_20, ORIG_TXN_AMOUNT, CREDIT_PARTY_NAME, COUNTER_PARTY_ROLE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, FILE_LINES_REF_NO, TXN_NO, TXN_DATE, TXN_CURRENCY, TXN_DUE_DATE, TXN_AMOUNT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, PRODUCT_TYPE, INPUT_BRANCH, BEHALF_OF_BRANCH, FINANCE_AMOUNT, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INTEREST_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR, INTEREST_PERIOD, CONTRACT_PERIOD, GRACE_PERIOD, BUYER_ID, SELLER_ID, FINANCE_REF_NO, PAYMENT_TYPE, PAYMENT_DATE, DEBIT_ACC_NO, PAYMENT_AMOUNT, BENE_NAME, BENE_BRANCH, UTR_NUMBER, PROCESSING_DATE, CMS_REF_NO, FILE_NAME, STATUS, REMARKS, BATCH_REF_ID, LIMIT_NODE1, VAL_STATUS, VAL_REMARKS, VAL_REQ_FILENAME, VAL_REQ_EVENT_REF_ID, VAL_REQ_START_TIME, VAL_REQ_END_TIME, VAL_REQ_STATUS, VAL_REQ_REMARKS, VAL_RES_FILENAME, VAL_RES_EVENT_REF_ID, VAL_RES_START_TIME, VAL_RES_END_TIME, VAL_RES_STATUS, VAL_RES_REMARKS, FINPAY_REQ_FILENAME, FINPAY_REQ_EVENT_REF_ID, FINPAY_REQ_START_TIME, FINPAY_REQ_END_TIME, FINPAY_REQ_STATUS, FINPAY_REQ_REMARKS, FINPAY_RES_FILENAME, FINPAY_RES_EVENT_REF_ID, FINPAY_RES_START_TIME, FINPAY_RES_END_TIME, FINPAY_RES_STATUS, FINPAY_RES_REMARKS, FINPAY_EOD_FILENAME, FINPAY_EOD_EVENT_REF_ID, FINPAY_EOD_START_TIME, FINPAY_EOD_END_TIME, FINPAY_EOD_STATUS, FINPAY_EOD_REMARKS, CMS_REQ_FILENAME, CMS_REQ_EVENT_REF_ID, CMS_REQ_START_TIME, CMS_REQ_END_TIME, CMS_REQ_STATUS, CMS_REQ_REMARKS, CMS_RES_FILENAME, CMS_RES_EVENT_REF_ID, CMS_RES_START_TIME, CMS_RES_END_TIME, CMS_RES_STATUS, CMS_RES_REMARKS, FBTI_REQ_CORR_ID, FBTI_REQ_EVENT_REF_ID, FBTI_REQ_START_TIME, FBTI_REQ_END_TIME, FBTI_REQ_STATUS, FBTI_REQ_REMARKS, FBTI_RES_CORR_ID, FBTI_RES_EVENT_REF_ID, FBTI_RES_START_TIME, FBTI_RES_END_TIME, FBTI_RES_STATUS, FBTI_RES_REMARKS, CURRENT_EVENT_NAME, VAL_LINE_NO, VAL_LINE_CONTENT, LIMIT_NODE2, EOD_STATUS, FINPAY_LINE_CONTENT, VALUE_DATE, PAYMENT_MODE, BENE_ACC_NO, NET_PAYMENT, ADVANCE_INTEREST, SPREAD_RATE, ANCHOR_NAME, SOURCE_OF_CREATION, CHARGES, CLIENT_CODE, SOURCE_SYSTEM, DISPLAY_SOURCE_SYSTEM, EVENT_FINPAY_ID, INSTRUMENT_DATE, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_BANK, LOCATION, PRINT_LOCATION, INSTRUMENT_NUMBER, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, ENRICHMENT_1, ENRICHMENT_2, ENRICHMENT_3, ENRICHMENT_4, ENRICHMENT_5, ENRICHMENT_6, ENRICHMENT_7, ENRICHMENT_8, ENRICHMENT_9, ENRICHMENT_10, ENRICHMENT_11, ENRICHMENT_12, ENRICHMENT_13, ENRICHMENT_14, ENRICHMENT_15, ENRICHMENT_16, ENRICHMENT_17, ENRICHMENT_18, ENRICHMENT_19, ENRICHMENT_20, ORIG_TXN_AMOUNT, CREDIT_PARTY_NAME, COUNTER_PARTY_ROLE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_FILE_LINES_REF_NO, COL_TXN_NO, COL_TXN_DATE, COL_TXN_CURRENCY, COL_TXN_DUE_DATE, COL_TXN_AMOUNT, COL_COUNTER_PARTY_CRN, COL_COUNTER_PARTY_NAME, COL_PRODUCT_TYPE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_FINANCE_AMOUNT, COL_DEBIT_PARTY_CRN, COL_EFFECTIVE_DATE, COL_FINANCING_AMOUNT, COL_CREDIT_PARTY_CRN, COL_INTEREST_RATE, COL_MARGIN_RATE, COL_MATURITY_DATE, COL_PENALTY_PERCENT, COL_INTEREST_START_DATE, COL_INTEREST_TYPE, COL_RATE_TYPE, COL_BASE_CODE, COL_TENOR, COL_INTEREST_PERIOD, COL_CONTRACT_PERIOD, COL_GRACE_PERIOD, COL_BUYER_ID, COL_SELLER_ID, COL_FINANCE_REF_NO, COL_PAYMENT_TYPE, COL_PAYMENT_DATE, COL_DEBIT_ACC_NO, COL_PAYMENT_AMOUNT, COL_BENE_NAME, COL_BENE_BRANCH, COL_UTR_NUMBER, COL_PROCESSING_DATE, COL_CMS_REF_NO, COL_FILE_NAME, COL_STATUS, COL_REMARKS, COL_BATCH_REF_ID, COL_LIMIT_NODE1, COL_VAL_STATUS, COL_VAL_REMARKS, COL_VAL_REQ_FILENAME, COL_VAL_REQ_EVENT_REF_ID, COL_VAL_REQ_START_TIME, COL_VAL_REQ_END_TIME, COL_VAL_REQ_STATUS, COL_VAL_REQ_REMARKS, COL_VAL_RES_FILENAME, COL_VAL_RES_EVENT_REF_ID, COL_VAL_RES_START_TIME, COL_VAL_RES_END_TIME, COL_VAL_RES_STATUS, COL_VAL_RES_REMARKS, COL_FINPAY_REQ_FILENAME, COL_FINPAY_REQ_EVENT_REF_ID, COL_FINPAY_REQ_START_TIME, COL_FINPAY_REQ_END_TIME, COL_FINPAY_REQ_STATUS, COL_FINPAY_REQ_REMARKS, COL_FINPAY_RES_FILENAME, COL_FINPAY_RES_EVENT_REF_ID, COL_FINPAY_RES_START_TIME, COL_FINPAY_RES_END_TIME, COL_FINPAY_RES_STATUS, COL_FINPAY_RES_REMARKS, COL_FINPAY_EOD_FILENAME, COL_FINPAY_EOD_EVENT_REF_ID, COL_FINPAY_EOD_START_TIME, COL_FINPAY_EOD_END_TIME, COL_FINPAY_EOD_STATUS, COL_FINPAY_EOD_REMARKS, COL_CMS_REQ_FILENAME, COL_CMS_REQ_EVENT_REF_ID, COL_CMS_REQ_START_TIME, COL_CMS_REQ_END_TIME, COL_CMS_REQ_STATUS, COL_CMS_REQ_REMARKS, COL_CMS_RES_FILENAME, COL_CMS_RES_EVENT_REF_ID, COL_CMS_RES_START_TIME, COL_CMS_RES_END_TIME, COL_CMS_RES_STATUS, COL_CMS_RES_REMARKS, COL_FBTI_REQ_CORR_ID, COL_FBTI_REQ_EVENT_REF_ID, COL_FBTI_REQ_START_TIME, COL_FBTI_REQ_END_TIME, COL_FBTI_REQ_STATUS, COL_FBTI_REQ_REMARKS, COL_FBTI_RES_CORR_ID, COL_FBTI_RES_EVENT_REF_ID, COL_FBTI_RES_START_TIME, COL_FBTI_RES_END_TIME, COL_FBTI_RES_STATUS, COL_FBTI_RES_REMARKS, COL_CURRENT_EVENT_NAME, COL_VAL_LINE_NO, COL_VAL_LINE_CONTENT, COL_LIMIT_NODE2, COL_EOD_STATUS, COL_FINPAY_LINE_CONTENT, COL_VALUE_DATE, COL_PAYMENT_MODE, COL_BENE_ACC_NO, COL_NET_PAYMENT, COL_ADVANCE_INTEREST, COL_SPREAD_RATE, COL_ANCHOR_NAME, COL_SOURCE_OF_CREATION, COL_CHARGES, COL_CLIENT_CODE, COL_SOURCE_SYSTEM, COL_DISPLAY_SOURCE_SYSTEM, COL_EVENT_FINPAY_ID, COL_INSTRUMENT_DATE, COL_BANK_CODE_INDICATOR, COL_BENEFICIARY_CODE, COL_BENEFICIARY_BANK, COL_LOCATION, COL_PRINT_LOCATION, COL_INSTRUMENT_NUMBER, COL_BENEFICIARY_ADDRESS_1, COL_BENEFICIARY_ADDRESS_2, COL_BENEFICIARY_ADDRESS_3, COL_BENEFICIARY_ADDRESS_4, COL_BENEFICIARY_EMAIL, COL_BENEFICIARY_MOBILE, COL_DEBIT_NARRATION, COL_CREDIT_NARRATION, COL_PAYMENT_DETAILS_1, COL_PAYMENT_DETAILS_2, COL_PAYMENT_DETAILS_3, COL_PAYMENT_DETAILS_4, COL_ENRICHMENT_1, COL_ENRICHMENT_2, COL_ENRICHMENT_3, COL_ENRICHMENT_4, COL_ENRICHMENT_5, COL_ENRICHMENT_6, COL_ENRICHMENT_7, COL_ENRICHMENT_8, COL_ENRICHMENT_9, COL_ENRICHMENT_10, COL_ENRICHMENT_11, COL_ENRICHMENT_12, COL_ENRICHMENT_13, COL_ENRICHMENT_14, COL_ENRICHMENT_15, COL_ENRICHMENT_16, COL_ENRICHMENT_17, COL_ENRICHMENT_18, COL_ENRICHMENT_19, COL_ENRICHMENT_20, COL_ORIG_TXN_AMOUNT, COL_CREDIT_PARTY_NAME, COL_COUNTER_PARTY_ROLE, COL_ID);

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

    public int insert(Connection conn, ScfFileTxn scffiletxn) throws SQLException {
        logger.debug("Inserting scffiletxn: {}", scffiletxn);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfFileTxnParams(ps, scffiletxn);
            ps.executeUpdate();
            return scffiletxn.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfFileTxn> scffiletxns) throws SQLException {
        if (scffiletxns == null || scffiletxns.isEmpty())
            return new int[0];
        for (int i = 0; i < scffiletxns.size(); i++) {
            if (scffiletxns.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileTxn>> batches = chunkList(scffiletxns, batchSize);
        int[] totalResults = new int[scffiletxns.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileTxn> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfFileTxn scffiletxn : batch) {
                        setScfFileTxnParams(ps, scffiletxn);
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

    public ScfFileTxn findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfFileTxn> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfFileTxn> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfFileTxn scffiletxn) throws SQLException {
        if (scffiletxn.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfFileTxnParams(ps, scffiletxn);
            ps.setInt(179, scffiletxn.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfFileTxn> scffiletxns) throws SQLException {
        if (scffiletxns == null || scffiletxns.isEmpty())
            return new int[0];
        for (ScfFileTxn scffiletxn : scffiletxns) {
            if (scffiletxn == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scffiletxn.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileTxn>> batches = chunkList(scffiletxns, batchSize);
        int[] totalResults = new int[scffiletxns.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileTxn> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfFileTxn scffiletxn : batch) {
                        setScfFileTxnParams(ps, scffiletxn);
                        ps.setInt(179, scffiletxn.getID());
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

    private void setScfFileTxnParams(PreparedStatement ps, ScfFileTxn scffiletxn) throws SQLException {
        Integer val1 = scffiletxn.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scffiletxn.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scffiletxn.getTypeCode());
        ps.setString(4, scffiletxn.getSubTypeCode());
        ps.setString(5, scffiletxn.getActiveCode());
        ps.setString(6, scffiletxn.getStageCode());
        ps.setString(7, scffiletxn.getStatusCode());
        ps.setString(8, scffiletxn.getCreatedOn());
        java.math.BigDecimal val9 = scffiletxn.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scffiletxn.getLastUpdatedOn());
        java.math.BigDecimal val11 = scffiletxn.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scffiletxn.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scffiletxn.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scffiletxn.getTemplate());
        java.math.BigDecimal val15 = scffiletxn.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scffiletxn.getAnchorCrn());
        ps.setString(17, scffiletxn.getFileMasterRefNo());
        ps.setString(18, scffiletxn.getFileLinesRefNo());
        ps.setString(19, scffiletxn.getTxnNo());
        java.time.LocalDateTime val20 = scffiletxn.getTxnDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, scffiletxn.getTxnCurrency());
        java.time.LocalDateTime val22 = scffiletxn.getTxnDueDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = scffiletxn.getTxnAmount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, scffiletxn.getCounterPartyCrn());
        ps.setString(25, scffiletxn.getCounterPartyName());
        ps.setString(26, scffiletxn.getProductType());
        ps.setString(27, scffiletxn.getInputBranch());
        ps.setString(28, scffiletxn.getBehalfOfBranch());
        java.math.BigDecimal val29 = scffiletxn.getFinanceAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, scffiletxn.getDebitPartyCrn());
        java.time.LocalDateTime val31 = scffiletxn.getEffectiveDate();
        if (val31 != null) {
            ps.setTimestamp(31, java.sql.Timestamp.valueOf(val31));
        } else {
            ps.setNull(31, Types.TIMESTAMP);
        }
        java.math.BigDecimal val32 = scffiletxn.getFinancingAmount();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, scffiletxn.getCreditPartyCrn());
        java.math.BigDecimal val34 = scffiletxn.getInterestRate();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = scffiletxn.getMarginRate();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.time.LocalDateTime val36 = scffiletxn.getMaturityDate();
        if (val36 != null) {
            ps.setTimestamp(36, java.sql.Timestamp.valueOf(val36));
        } else {
            ps.setNull(36, Types.TIMESTAMP);
        }
        java.math.BigDecimal val37 = scffiletxn.getPenaltyPercent();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.time.LocalDateTime val38 = scffiletxn.getInterestStartDate();
        if (val38 != null) {
            ps.setTimestamp(38, java.sql.Timestamp.valueOf(val38));
        } else {
            ps.setNull(38, Types.TIMESTAMP);
        }
        ps.setString(39, scffiletxn.getInterestType());
        java.math.BigDecimal val40 = scffiletxn.getRateType();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, scffiletxn.getBaseCode());
        java.math.BigDecimal val42 = scffiletxn.getTenor();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        java.math.BigDecimal val43 = scffiletxn.getInterestPeriod();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        java.math.BigDecimal val44 = scffiletxn.getContractPeriod();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        java.math.BigDecimal val45 = scffiletxn.getGracePeriod();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        Integer val46 = scffiletxn.getBuyerID();
        if (val46 != null) {
            ps.setInt(46, val46);
        } else {
            ps.setNull(46, Types.INTEGER);
        }
        Integer val47 = scffiletxn.getSellerID();
        if (val47 != null) {
            ps.setInt(47, val47);
        } else {
            ps.setNull(47, Types.INTEGER);
        }
        ps.setString(48, scffiletxn.getFinanceRefNo());
        ps.setString(49, scffiletxn.getPaymentType());
        java.time.LocalDateTime val50 = scffiletxn.getPaymentDate();
        if (val50 != null) {
            ps.setTimestamp(50, java.sql.Timestamp.valueOf(val50));
        } else {
            ps.setNull(50, Types.TIMESTAMP);
        }
        ps.setString(51, scffiletxn.getDebitAccNo());
        java.math.BigDecimal val52 = scffiletxn.getPaymentAmount();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        ps.setString(53, scffiletxn.getBeneName());
        ps.setString(54, scffiletxn.getBeneBranch());
        ps.setString(55, scffiletxn.getUtrNumber());
        java.time.LocalDateTime val56 = scffiletxn.getProcessingDate();
        if (val56 != null) {
            ps.setTimestamp(56, java.sql.Timestamp.valueOf(val56));
        } else {
            ps.setNull(56, Types.TIMESTAMP);
        }
        ps.setString(57, scffiletxn.getCmsRefNo());
        ps.setString(58, scffiletxn.getFileName());
        ps.setString(59, scffiletxn.getStatus());
        ps.setString(60, scffiletxn.getRemarks());
        Integer val61 = scffiletxn.getBatchRefID();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        ps.setString(62, scffiletxn.getLimitNode1());
        ps.setString(63, scffiletxn.getValStatus());
        ps.setString(64, scffiletxn.getValRemarks());
        ps.setString(65, scffiletxn.getValReqFilename());
        Integer val66 = scffiletxn.getValReqEventRefID();
        if (val66 != null) {
            ps.setInt(66, val66);
        } else {
            ps.setNull(66, Types.INTEGER);
        }
        ps.setString(67, scffiletxn.getValReqStartTime());
        ps.setString(68, scffiletxn.getValReqEndTime());
        ps.setString(69, scffiletxn.getValReqStatus());
        ps.setString(70, scffiletxn.getValReqRemarks());
        ps.setString(71, scffiletxn.getValResFilename());
        Integer val72 = scffiletxn.getValResEventRefID();
        if (val72 != null) {
            ps.setInt(72, val72);
        } else {
            ps.setNull(72, Types.INTEGER);
        }
        ps.setString(73, scffiletxn.getValResStartTime());
        ps.setString(74, scffiletxn.getValResEndTime());
        ps.setString(75, scffiletxn.getValResStatus());
        ps.setString(76, scffiletxn.getValResRemarks());
        ps.setString(77, scffiletxn.getFinpayReqFilename());
        Integer val78 = scffiletxn.getFinpayReqEventRefID();
        if (val78 != null) {
            ps.setInt(78, val78);
        } else {
            ps.setNull(78, Types.INTEGER);
        }
        ps.setString(79, scffiletxn.getFinpayReqStartTime());
        ps.setString(80, scffiletxn.getFinpayReqEndTime());
        ps.setString(81, scffiletxn.getFinpayReqStatus());
        ps.setString(82, scffiletxn.getFinpayReqRemarks());
        ps.setString(83, scffiletxn.getFinpayResFilename());
        Integer val84 = scffiletxn.getFinpayResEventRefID();
        if (val84 != null) {
            ps.setInt(84, val84);
        } else {
            ps.setNull(84, Types.INTEGER);
        }
        ps.setString(85, scffiletxn.getFinpayResStartTime());
        ps.setString(86, scffiletxn.getFinpayResEndTime());
        ps.setString(87, scffiletxn.getFinpayResStatus());
        ps.setString(88, scffiletxn.getFinpayResRemarks());
        ps.setString(89, scffiletxn.getFinpayEodFilename());
        Integer val90 = scffiletxn.getFinpayEodEventRefID();
        if (val90 != null) {
            ps.setInt(90, val90);
        } else {
            ps.setNull(90, Types.INTEGER);
        }
        ps.setString(91, scffiletxn.getFinpayEodStartTime());
        ps.setString(92, scffiletxn.getFinpayEodEndTime());
        ps.setString(93, scffiletxn.getFinpayEodStatus());
        ps.setString(94, scffiletxn.getFinpayEodRemarks());
        ps.setString(95, scffiletxn.getCmsReqFilename());
        Integer val96 = scffiletxn.getCmsReqEventRefID();
        if (val96 != null) {
            ps.setInt(96, val96);
        } else {
            ps.setNull(96, Types.INTEGER);
        }
        ps.setString(97, scffiletxn.getCmsReqStartTime());
        ps.setString(98, scffiletxn.getCmsReqEndTime());
        ps.setString(99, scffiletxn.getCmsReqStatus());
        ps.setString(100, scffiletxn.getCmsReqRemarks());
        ps.setString(101, scffiletxn.getCmsResFilename());
        Integer val102 = scffiletxn.getCmsResEventRefID();
        if (val102 != null) {
            ps.setInt(102, val102);
        } else {
            ps.setNull(102, Types.INTEGER);
        }
        ps.setString(103, scffiletxn.getCmsResStartTime());
        ps.setString(104, scffiletxn.getCmsResEndTime());
        ps.setString(105, scffiletxn.getCmsResStatus());
        ps.setString(106, scffiletxn.getCmsResRemarks());
        Integer val107 = scffiletxn.getFbtiReqCorrID();
        if (val107 != null) {
            ps.setInt(107, val107);
        } else {
            ps.setNull(107, Types.INTEGER);
        }
        Integer val108 = scffiletxn.getFbtiReqEventRefID();
        if (val108 != null) {
            ps.setInt(108, val108);
        } else {
            ps.setNull(108, Types.INTEGER);
        }
        ps.setString(109, scffiletxn.getFbtiReqStartTime());
        ps.setString(110, scffiletxn.getFbtiReqEndTime());
        ps.setString(111, scffiletxn.getFbtiReqStatus());
        ps.setString(112, scffiletxn.getFbtiReqRemarks());
        Integer val113 = scffiletxn.getFbtiResCorrID();
        if (val113 != null) {
            ps.setInt(113, val113);
        } else {
            ps.setNull(113, Types.INTEGER);
        }
        Integer val114 = scffiletxn.getFbtiResEventRefID();
        if (val114 != null) {
            ps.setInt(114, val114);
        } else {
            ps.setNull(114, Types.INTEGER);
        }
        ps.setString(115, scffiletxn.getFbtiResStartTime());
        ps.setString(116, scffiletxn.getFbtiResEndTime());
        ps.setString(117, scffiletxn.getFbtiResStatus());
        ps.setString(118, scffiletxn.getFbtiResRemarks());
        ps.setString(119, scffiletxn.getCurrentEventName());
        java.math.BigDecimal val120 = scffiletxn.getValLineNo();
        if (val120 != null) {
            ps.setBigDecimal(120, val120);
        } else {
            ps.setNull(120, Types.DECIMAL);
        }
        ps.setString(121, scffiletxn.getValLineContent());
        ps.setString(122, scffiletxn.getLimitNode2());
        ps.setString(123, scffiletxn.getEodStatus());
        ps.setString(124, scffiletxn.getFinpayLineContent());
        ps.setString(125, scffiletxn.getValueDate());
        ps.setString(126, scffiletxn.getPaymentMode());
        ps.setString(127, scffiletxn.getBeneAccNo());
        java.math.BigDecimal val128 = scffiletxn.getNetPayment();
        if (val128 != null) {
            ps.setBigDecimal(128, val128);
        } else {
            ps.setNull(128, Types.DECIMAL);
        }
        java.math.BigDecimal val129 = scffiletxn.getAdvanceInterest();
        if (val129 != null) {
            ps.setBigDecimal(129, val129);
        } else {
            ps.setNull(129, Types.DECIMAL);
        }
        java.math.BigDecimal val130 = scffiletxn.getSpreadRate();
        if (val130 != null) {
            ps.setBigDecimal(130, val130);
        } else {
            ps.setNull(130, Types.DECIMAL);
        }
        ps.setString(131, scffiletxn.getAnchorName());
        ps.setString(132, scffiletxn.getSourceOfCreation());
        java.math.BigDecimal val133 = scffiletxn.getCharges();
        if (val133 != null) {
            ps.setBigDecimal(133, val133);
        } else {
            ps.setNull(133, Types.DECIMAL);
        }
        ps.setString(134, scffiletxn.getClientCode());
        ps.setString(135, scffiletxn.getSourceSystem());
        ps.setString(136, scffiletxn.getDisplaySourceSystem());
        Integer val137 = scffiletxn.getEventFinpayID();
        if (val137 != null) {
            ps.setInt(137, val137);
        } else {
            ps.setNull(137, Types.INTEGER);
        }
        java.time.LocalDateTime val138 = scffiletxn.getInstrumentDate();
        if (val138 != null) {
            ps.setTimestamp(138, java.sql.Timestamp.valueOf(val138));
        } else {
            ps.setNull(138, Types.TIMESTAMP);
        }
        ps.setString(139, scffiletxn.getBankCodeIndicator());
        ps.setString(140, scffiletxn.getBeneficiaryCode());
        ps.setString(141, scffiletxn.getBeneficiaryBank());
        ps.setString(142, scffiletxn.getLocation());
        ps.setString(143, scffiletxn.getPrintLocation());
        java.math.BigDecimal val144 = scffiletxn.getInstrumentNumber();
        if (val144 != null) {
            ps.setBigDecimal(144, val144);
        } else {
            ps.setNull(144, Types.DECIMAL);
        }
        ps.setString(145, scffiletxn.getBeneficiaryAddress1());
        ps.setString(146, scffiletxn.getBeneficiaryAddress2());
        ps.setString(147, scffiletxn.getBeneficiaryAddress3());
        ps.setString(148, scffiletxn.getBeneficiaryAddress4());
        ps.setString(149, scffiletxn.getBeneficiaryEmail());
        java.math.BigDecimal val150 = scffiletxn.getBeneficiaryMobile();
        if (val150 != null) {
            ps.setBigDecimal(150, val150);
        } else {
            ps.setNull(150, Types.DECIMAL);
        }
        ps.setString(151, scffiletxn.getDebitNarration());
        ps.setString(152, scffiletxn.getCreditNarration());
        ps.setString(153, scffiletxn.getPaymentDetails1());
        ps.setString(154, scffiletxn.getPaymentDetails2());
        ps.setString(155, scffiletxn.getPaymentDetails3());
        ps.setString(156, scffiletxn.getPaymentDetails4());
        ps.setString(157, scffiletxn.getEnrichment1());
        ps.setString(158, scffiletxn.getEnrichment2());
        ps.setString(159, scffiletxn.getEnrichment3());
        ps.setString(160, scffiletxn.getEnrichment4());
        ps.setString(161, scffiletxn.getEnrichment5());
        ps.setString(162, scffiletxn.getEnrichment6());
        ps.setString(163, scffiletxn.getEnrichment7());
        ps.setString(164, scffiletxn.getEnrichment8());
        ps.setString(165, scffiletxn.getEnrichment9());
        ps.setString(166, scffiletxn.getEnrichment10());
        ps.setString(167, scffiletxn.getEnrichment11());
        ps.setString(168, scffiletxn.getEnrichment12());
        ps.setString(169, scffiletxn.getEnrichment13());
        ps.setString(170, scffiletxn.getEnrichment14());
        ps.setString(171, scffiletxn.getEnrichment15());
        ps.setString(172, scffiletxn.getEnrichment16());
        ps.setString(173, scffiletxn.getEnrichment17());
        ps.setString(174, scffiletxn.getEnrichment18());
        ps.setString(175, scffiletxn.getEnrichment19());
        ps.setString(176, scffiletxn.getEnrichment20());
        java.math.BigDecimal val177 = scffiletxn.getOrigTxnAmount();
        if (val177 != null) {
            ps.setBigDecimal(177, val177);
        } else {
            ps.setNull(177, Types.DECIMAL);
        }
        ps.setString(178, scffiletxn.getCreditPartyName());
        ps.setString(179, scffiletxn.getCounterPartyRole());
    }

    private ScfFileTxn extract(ResultSet rs) throws SQLException {
        ScfFileTxn scffiletxn = new ScfFileTxn();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scffiletxn.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scffiletxn.setReferenceID(REFERENCE_ID);
        scffiletxn.setTypeCode(rs.getString(COL_TYPE_CODE));
        scffiletxn.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scffiletxn.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scffiletxn.setStageCode(rs.getString(COL_STAGE_CODE));
        scffiletxn.setStatusCode(rs.getString(COL_STATUS_CODE));
        scffiletxn.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scffiletxn.setCreatedBy(CREATED_BY);
        scffiletxn.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scffiletxn.setLastUpdatedBy(LAST_UPDATED_BY);
        scffiletxn.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scffiletxn.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scffiletxn.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scffiletxn.setIsTemplate(IS_TEMPLATE);
        scffiletxn.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scffiletxn.setFileMasterRefNo(rs.getString(COL_FILE_MASTER_REF_NO));
        scffiletxn.setFileLinesRefNo(rs.getString(COL_FILE_LINES_REF_NO));
        scffiletxn.setTxnNo(rs.getString(COL_TXN_NO));
        Timestamp TXN_DATE = rs.getTimestamp(COL_TXN_DATE);
        if (TXN_DATE != null)
            scffiletxn.setTxnDate(TXN_DATE.toLocalDateTime());
        scffiletxn.setTxnCurrency(rs.getString(COL_TXN_CURRENCY));
        Timestamp TXN_DUE_DATE = rs.getTimestamp(COL_TXN_DUE_DATE);
        if (TXN_DUE_DATE != null)
            scffiletxn.setTxnDueDate(TXN_DUE_DATE.toLocalDateTime());
        java.math.BigDecimal TXN_AMOUNT = rs.getObject(COL_TXN_AMOUNT, java.math.BigDecimal.class);
        scffiletxn.setTxnAmount(TXN_AMOUNT);
        scffiletxn.setCounterPartyCrn(rs.getString(COL_COUNTER_PARTY_CRN));
        scffiletxn.setCounterPartyName(rs.getString(COL_COUNTER_PARTY_NAME));
        scffiletxn.setProductType(rs.getString(COL_PRODUCT_TYPE));
        scffiletxn.setInputBranch(rs.getString(COL_INPUT_BRANCH));
        scffiletxn.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        java.math.BigDecimal FINANCE_AMOUNT = rs.getObject(COL_FINANCE_AMOUNT, java.math.BigDecimal.class);
        scffiletxn.setFinanceAmount(FINANCE_AMOUNT);
        scffiletxn.setDebitPartyCrn(rs.getString(COL_DEBIT_PARTY_CRN));
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            scffiletxn.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        java.math.BigDecimal FINANCING_AMOUNT = rs.getObject(COL_FINANCING_AMOUNT, java.math.BigDecimal.class);
        scffiletxn.setFinancingAmount(FINANCING_AMOUNT);
        scffiletxn.setCreditPartyCrn(rs.getString(COL_CREDIT_PARTY_CRN));
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        scffiletxn.setInterestRate(INTEREST_RATE);
        java.math.BigDecimal MARGIN_RATE = rs.getObject(COL_MARGIN_RATE, java.math.BigDecimal.class);
        scffiletxn.setMarginRate(MARGIN_RATE);
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            scffiletxn.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        java.math.BigDecimal PENALTY_PERCENT = rs.getObject(COL_PENALTY_PERCENT, java.math.BigDecimal.class);
        scffiletxn.setPenaltyPercent(PENALTY_PERCENT);
        Timestamp INTEREST_START_DATE = rs.getTimestamp(COL_INTEREST_START_DATE);
        if (INTEREST_START_DATE != null)
            scffiletxn.setInterestStartDate(INTEREST_START_DATE.toLocalDateTime());
        scffiletxn.setInterestType(rs.getString(COL_INTEREST_TYPE));
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        scffiletxn.setRateType(RATE_TYPE);
        scffiletxn.setBaseCode(rs.getString(COL_BASE_CODE));
        java.math.BigDecimal TENOR = rs.getObject(COL_TENOR, java.math.BigDecimal.class);
        scffiletxn.setTenor(TENOR);
        java.math.BigDecimal INTEREST_PERIOD = rs.getObject(COL_INTEREST_PERIOD, java.math.BigDecimal.class);
        scffiletxn.setInterestPeriod(INTEREST_PERIOD);
        java.math.BigDecimal CONTRACT_PERIOD = rs.getObject(COL_CONTRACT_PERIOD, java.math.BigDecimal.class);
        scffiletxn.setContractPeriod(CONTRACT_PERIOD);
        java.math.BigDecimal GRACE_PERIOD = rs.getObject(COL_GRACE_PERIOD, java.math.BigDecimal.class);
        scffiletxn.setGracePeriod(GRACE_PERIOD);
        Integer BUYER_ID = rs.getObject(COL_BUYER_ID, Integer.class);
        scffiletxn.setBuyerID(BUYER_ID);
        Integer SELLER_ID = rs.getObject(COL_SELLER_ID, Integer.class);
        scffiletxn.setSellerID(SELLER_ID);
        scffiletxn.setFinanceRefNo(rs.getString(COL_FINANCE_REF_NO));
        scffiletxn.setPaymentType(rs.getString(COL_PAYMENT_TYPE));
        Timestamp PAYMENT_DATE = rs.getTimestamp(COL_PAYMENT_DATE);
        if (PAYMENT_DATE != null)
            scffiletxn.setPaymentDate(PAYMENT_DATE.toLocalDateTime());
        scffiletxn.setDebitAccNo(rs.getString(COL_DEBIT_ACC_NO));
        java.math.BigDecimal PAYMENT_AMOUNT = rs.getObject(COL_PAYMENT_AMOUNT, java.math.BigDecimal.class);
        scffiletxn.setPaymentAmount(PAYMENT_AMOUNT);
        scffiletxn.setBeneName(rs.getString(COL_BENE_NAME));
        scffiletxn.setBeneBranch(rs.getString(COL_BENE_BRANCH));
        scffiletxn.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        Timestamp PROCESSING_DATE = rs.getTimestamp(COL_PROCESSING_DATE);
        if (PROCESSING_DATE != null)
            scffiletxn.setProcessingDate(PROCESSING_DATE.toLocalDateTime());
        scffiletxn.setCmsRefNo(rs.getString(COL_CMS_REF_NO));
        scffiletxn.setFileName(rs.getString(COL_FILE_NAME));
        scffiletxn.setStatus(rs.getString(COL_STATUS));
        scffiletxn.setRemarks(rs.getString(COL_REMARKS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        scffiletxn.setBatchRefID(BATCH_REF_ID);
        scffiletxn.setLimitNode1(rs.getString(COL_LIMIT_NODE1));
        scffiletxn.setValStatus(rs.getString(COL_VAL_STATUS));
        scffiletxn.setValRemarks(rs.getString(COL_VAL_REMARKS));
        scffiletxn.setValReqFilename(rs.getString(COL_VAL_REQ_FILENAME));
        Integer VAL_REQ_EVENT_REF_ID = rs.getObject(COL_VAL_REQ_EVENT_REF_ID, Integer.class);
        scffiletxn.setValReqEventRefID(VAL_REQ_EVENT_REF_ID);
        scffiletxn.setValReqStartTime(rs.getString(COL_VAL_REQ_START_TIME));
        scffiletxn.setValReqEndTime(rs.getString(COL_VAL_REQ_END_TIME));
        scffiletxn.setValReqStatus(rs.getString(COL_VAL_REQ_STATUS));
        scffiletxn.setValReqRemarks(rs.getString(COL_VAL_REQ_REMARKS));
        scffiletxn.setValResFilename(rs.getString(COL_VAL_RES_FILENAME));
        Integer VAL_RES_EVENT_REF_ID = rs.getObject(COL_VAL_RES_EVENT_REF_ID, Integer.class);
        scffiletxn.setValResEventRefID(VAL_RES_EVENT_REF_ID);
        scffiletxn.setValResStartTime(rs.getString(COL_VAL_RES_START_TIME));
        scffiletxn.setValResEndTime(rs.getString(COL_VAL_RES_END_TIME));
        scffiletxn.setValResStatus(rs.getString(COL_VAL_RES_STATUS));
        scffiletxn.setValResRemarks(rs.getString(COL_VAL_RES_REMARKS));
        scffiletxn.setFinpayReqFilename(rs.getString(COL_FINPAY_REQ_FILENAME));
        Integer FINPAY_REQ_EVENT_REF_ID = rs.getObject(COL_FINPAY_REQ_EVENT_REF_ID, Integer.class);
        scffiletxn.setFinpayReqEventRefID(FINPAY_REQ_EVENT_REF_ID);
        scffiletxn.setFinpayReqStartTime(rs.getString(COL_FINPAY_REQ_START_TIME));
        scffiletxn.setFinpayReqEndTime(rs.getString(COL_FINPAY_REQ_END_TIME));
        scffiletxn.setFinpayReqStatus(rs.getString(COL_FINPAY_REQ_STATUS));
        scffiletxn.setFinpayReqRemarks(rs.getString(COL_FINPAY_REQ_REMARKS));
        scffiletxn.setFinpayResFilename(rs.getString(COL_FINPAY_RES_FILENAME));
        Integer FINPAY_RES_EVENT_REF_ID = rs.getObject(COL_FINPAY_RES_EVENT_REF_ID, Integer.class);
        scffiletxn.setFinpayResEventRefID(FINPAY_RES_EVENT_REF_ID);
        scffiletxn.setFinpayResStartTime(rs.getString(COL_FINPAY_RES_START_TIME));
        scffiletxn.setFinpayResEndTime(rs.getString(COL_FINPAY_RES_END_TIME));
        scffiletxn.setFinpayResStatus(rs.getString(COL_FINPAY_RES_STATUS));
        scffiletxn.setFinpayResRemarks(rs.getString(COL_FINPAY_RES_REMARKS));
        scffiletxn.setFinpayEodFilename(rs.getString(COL_FINPAY_EOD_FILENAME));
        Integer FINPAY_EOD_EVENT_REF_ID = rs.getObject(COL_FINPAY_EOD_EVENT_REF_ID, Integer.class);
        scffiletxn.setFinpayEodEventRefID(FINPAY_EOD_EVENT_REF_ID);
        scffiletxn.setFinpayEodStartTime(rs.getString(COL_FINPAY_EOD_START_TIME));
        scffiletxn.setFinpayEodEndTime(rs.getString(COL_FINPAY_EOD_END_TIME));
        scffiletxn.setFinpayEodStatus(rs.getString(COL_FINPAY_EOD_STATUS));
        scffiletxn.setFinpayEodRemarks(rs.getString(COL_FINPAY_EOD_REMARKS));
        scffiletxn.setCmsReqFilename(rs.getString(COL_CMS_REQ_FILENAME));
        Integer CMS_REQ_EVENT_REF_ID = rs.getObject(COL_CMS_REQ_EVENT_REF_ID, Integer.class);
        scffiletxn.setCmsReqEventRefID(CMS_REQ_EVENT_REF_ID);
        scffiletxn.setCmsReqStartTime(rs.getString(COL_CMS_REQ_START_TIME));
        scffiletxn.setCmsReqEndTime(rs.getString(COL_CMS_REQ_END_TIME));
        scffiletxn.setCmsReqStatus(rs.getString(COL_CMS_REQ_STATUS));
        scffiletxn.setCmsReqRemarks(rs.getString(COL_CMS_REQ_REMARKS));
        scffiletxn.setCmsResFilename(rs.getString(COL_CMS_RES_FILENAME));
        Integer CMS_RES_EVENT_REF_ID = rs.getObject(COL_CMS_RES_EVENT_REF_ID, Integer.class);
        scffiletxn.setCmsResEventRefID(CMS_RES_EVENT_REF_ID);
        scffiletxn.setCmsResStartTime(rs.getString(COL_CMS_RES_START_TIME));
        scffiletxn.setCmsResEndTime(rs.getString(COL_CMS_RES_END_TIME));
        scffiletxn.setCmsResStatus(rs.getString(COL_CMS_RES_STATUS));
        scffiletxn.setCmsResRemarks(rs.getString(COL_CMS_RES_REMARKS));
        Integer FBTI_REQ_CORR_ID = rs.getObject(COL_FBTI_REQ_CORR_ID, Integer.class);
        scffiletxn.setFbtiReqCorrID(FBTI_REQ_CORR_ID);
        Integer FBTI_REQ_EVENT_REF_ID = rs.getObject(COL_FBTI_REQ_EVENT_REF_ID, Integer.class);
        scffiletxn.setFbtiReqEventRefID(FBTI_REQ_EVENT_REF_ID);
        scffiletxn.setFbtiReqStartTime(rs.getString(COL_FBTI_REQ_START_TIME));
        scffiletxn.setFbtiReqEndTime(rs.getString(COL_FBTI_REQ_END_TIME));
        scffiletxn.setFbtiReqStatus(rs.getString(COL_FBTI_REQ_STATUS));
        scffiletxn.setFbtiReqRemarks(rs.getString(COL_FBTI_REQ_REMARKS));
        Integer FBTI_RES_CORR_ID = rs.getObject(COL_FBTI_RES_CORR_ID, Integer.class);
        scffiletxn.setFbtiResCorrID(FBTI_RES_CORR_ID);
        Integer FBTI_RES_EVENT_REF_ID = rs.getObject(COL_FBTI_RES_EVENT_REF_ID, Integer.class);
        scffiletxn.setFbtiResEventRefID(FBTI_RES_EVENT_REF_ID);
        scffiletxn.setFbtiResStartTime(rs.getString(COL_FBTI_RES_START_TIME));
        scffiletxn.setFbtiResEndTime(rs.getString(COL_FBTI_RES_END_TIME));
        scffiletxn.setFbtiResStatus(rs.getString(COL_FBTI_RES_STATUS));
        scffiletxn.setFbtiResRemarks(rs.getString(COL_FBTI_RES_REMARKS));
        scffiletxn.setCurrentEventName(rs.getString(COL_CURRENT_EVENT_NAME));
        java.math.BigDecimal VAL_LINE_NO = rs.getObject(COL_VAL_LINE_NO, java.math.BigDecimal.class);
        scffiletxn.setValLineNo(VAL_LINE_NO);
        scffiletxn.setValLineContent(rs.getString(COL_VAL_LINE_CONTENT));
        scffiletxn.setLimitNode2(rs.getString(COL_LIMIT_NODE2));
        scffiletxn.setEodStatus(rs.getString(COL_EOD_STATUS));
        scffiletxn.setFinpayLineContent(rs.getString(COL_FINPAY_LINE_CONTENT));
        scffiletxn.setValueDate(rs.getString(COL_VALUE_DATE));
        scffiletxn.setPaymentMode(rs.getString(COL_PAYMENT_MODE));
        scffiletxn.setBeneAccNo(rs.getString(COL_BENE_ACC_NO));
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        scffiletxn.setNetPayment(NET_PAYMENT);
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        scffiletxn.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal SPREAD_RATE = rs.getObject(COL_SPREAD_RATE, java.math.BigDecimal.class);
        scffiletxn.setSpreadRate(SPREAD_RATE);
        scffiletxn.setAnchorName(rs.getString(COL_ANCHOR_NAME));
        scffiletxn.setSourceOfCreation(rs.getString(COL_SOURCE_OF_CREATION));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        scffiletxn.setCharges(CHARGES);
        scffiletxn.setClientCode(rs.getString(COL_CLIENT_CODE));
        scffiletxn.setSourceSystem(rs.getString(COL_SOURCE_SYSTEM));
        scffiletxn.setDisplaySourceSystem(rs.getString(COL_DISPLAY_SOURCE_SYSTEM));
        Integer EVENT_FINPAY_ID = rs.getObject(COL_EVENT_FINPAY_ID, Integer.class);
        scffiletxn.setEventFinpayID(EVENT_FINPAY_ID);
        Timestamp INSTRUMENT_DATE = rs.getTimestamp(COL_INSTRUMENT_DATE);
        if (INSTRUMENT_DATE != null)
            scffiletxn.setInstrumentDate(INSTRUMENT_DATE.toLocalDateTime());
        scffiletxn.setBankCodeIndicator(rs.getString(COL_BANK_CODE_INDICATOR));
        scffiletxn.setBeneficiaryCode(rs.getString(COL_BENEFICIARY_CODE));
        scffiletxn.setBeneficiaryBank(rs.getString(COL_BENEFICIARY_BANK));
        scffiletxn.setLocation(rs.getString(COL_LOCATION));
        scffiletxn.setPrintLocation(rs.getString(COL_PRINT_LOCATION));
        java.math.BigDecimal INSTRUMENT_NUMBER = rs.getObject(COL_INSTRUMENT_NUMBER, java.math.BigDecimal.class);
        scffiletxn.setInstrumentNumber(INSTRUMENT_NUMBER);
        scffiletxn.setBeneficiaryAddress1(rs.getString(COL_BENEFICIARY_ADDRESS_1));
        scffiletxn.setBeneficiaryAddress2(rs.getString(COL_BENEFICIARY_ADDRESS_2));
        scffiletxn.setBeneficiaryAddress3(rs.getString(COL_BENEFICIARY_ADDRESS_3));
        scffiletxn.setBeneficiaryAddress4(rs.getString(COL_BENEFICIARY_ADDRESS_4));
        scffiletxn.setBeneficiaryEmail(rs.getString(COL_BENEFICIARY_EMAIL));
        java.math.BigDecimal BENEFICIARY_MOBILE = rs.getObject(COL_BENEFICIARY_MOBILE, java.math.BigDecimal.class);
        scffiletxn.setBeneficiaryMobile(BENEFICIARY_MOBILE);
        scffiletxn.setDebitNarration(rs.getString(COL_DEBIT_NARRATION));
        scffiletxn.setCreditNarration(rs.getString(COL_CREDIT_NARRATION));
        scffiletxn.setPaymentDetails1(rs.getString(COL_PAYMENT_DETAILS_1));
        scffiletxn.setPaymentDetails2(rs.getString(COL_PAYMENT_DETAILS_2));
        scffiletxn.setPaymentDetails3(rs.getString(COL_PAYMENT_DETAILS_3));
        scffiletxn.setPaymentDetails4(rs.getString(COL_PAYMENT_DETAILS_4));
        scffiletxn.setEnrichment1(rs.getString(COL_ENRICHMENT_1));
        scffiletxn.setEnrichment2(rs.getString(COL_ENRICHMENT_2));
        scffiletxn.setEnrichment3(rs.getString(COL_ENRICHMENT_3));
        scffiletxn.setEnrichment4(rs.getString(COL_ENRICHMENT_4));
        scffiletxn.setEnrichment5(rs.getString(COL_ENRICHMENT_5));
        scffiletxn.setEnrichment6(rs.getString(COL_ENRICHMENT_6));
        scffiletxn.setEnrichment7(rs.getString(COL_ENRICHMENT_7));
        scffiletxn.setEnrichment8(rs.getString(COL_ENRICHMENT_8));
        scffiletxn.setEnrichment9(rs.getString(COL_ENRICHMENT_9));
        scffiletxn.setEnrichment10(rs.getString(COL_ENRICHMENT_10));
        scffiletxn.setEnrichment11(rs.getString(COL_ENRICHMENT_11));
        scffiletxn.setEnrichment12(rs.getString(COL_ENRICHMENT_12));
        scffiletxn.setEnrichment13(rs.getString(COL_ENRICHMENT_13));
        scffiletxn.setEnrichment14(rs.getString(COL_ENRICHMENT_14));
        scffiletxn.setEnrichment15(rs.getString(COL_ENRICHMENT_15));
        scffiletxn.setEnrichment16(rs.getString(COL_ENRICHMENT_16));
        scffiletxn.setEnrichment17(rs.getString(COL_ENRICHMENT_17));
        scffiletxn.setEnrichment18(rs.getString(COL_ENRICHMENT_18));
        scffiletxn.setEnrichment19(rs.getString(COL_ENRICHMENT_19));
        scffiletxn.setEnrichment20(rs.getString(COL_ENRICHMENT_20));
        java.math.BigDecimal ORIG_TXN_AMOUNT = rs.getObject(COL_ORIG_TXN_AMOUNT, java.math.BigDecimal.class);
        scffiletxn.setOrigTxnAmount(ORIG_TXN_AMOUNT);
        scffiletxn.setCreditPartyName(rs.getString(COL_CREDIT_PARTY_NAME));
        scffiletxn.setCounterPartyRole(rs.getString(COL_COUNTER_PARTY_ROLE));
        return scffiletxn;
    }
}
