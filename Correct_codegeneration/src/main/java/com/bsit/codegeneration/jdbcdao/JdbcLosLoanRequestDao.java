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

public class JdbcLosLoanRequestDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLosLoanRequestDao.class);

    private static final String TABLE = "LOS_LOAN_REQUEST";

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

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_UTILIZED_AMOUNT = "UTILIZED_AMOUNT";

    private static final String COL_OUTSTANDING_AMOUNT = "OUTSTANDING_AMOUNT";

    private static final String COL_LIMIT_NODE_REFERENCE = "LIMIT_NODE_REFERENCE";

    private static final String COL_REQUEST_TENOR = "REQUEST_TENOR";

    private static final String COL_REQUEST_STATUS_CODE = "REQUEST_STATUS_CODE";

    private static final String COL_REQUEST_DISBURSEMENT_DATE = "REQUEST_DISBURSEMENT_DATE";

    private static final String COL_RM_PARTY_REFERENCE = "RM_PARTY_REFERENCE";

    private static final String COL_PARENT_FACILITY_LIMIT_ID = "PARENT_FACILITY_LIMIT_ID";

    private static final String COL_FACILITY_LIMIT_ID = "FACILITY_LIMIT_ID";

    private static final String COL_LEI_NUMBER = "LEI_NUMBER";

    private static final String COL_LEI_STATUS_CODE = "LEI_STATUS_CODE";

    private static final String COL_INTEREST_TYPE_CODE = "INTEREST_TYPE_CODE";

    private static final String COL_OFFER_CODE = "OFFER_CODE";

    private static final String COL_TENOR_MIN = "TENOR_MIN";

    private static final String COL_TENOR_MAX = "TENOR_MAX";

    private static final String COL_PROCESSING_MODE_CODE = "PROCESSING_MODE_CODE";

    private static final String COL_RESET_FREQUENCT_PERIOD_CODE = "RESET_FREQUENCT_PERIOD_CODE";

    private static final String COL_LOAN_ACCOUNT_NUMBER = "LOAN_ACCOUNT_NUMBER";

    private static final String COL_LOAN_START_DATE = "LOAN_START_DATE";

    private static final String COL_SANCTIONED_AMOUNT_CCY_CODE = "SANCTIONED_AMOUNT_CCY_CODE";

    private static final String COL_SANCTIONED_AMOUNT = "SANCTIONED_AMOUNT";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_SANCTIONED_DATE = "SANCTIONED_DATE";

    private static final String COL_DISBURSEMENT_ACCOUNT = "DISBURSEMENT_ACCOUNT";

    private static final String COL_DISBURSED_DATE = "DISBURSED_DATE";

    private static final String COL_SETTLEMENT_ACCOUNT = "SETTLEMENT_ACCOUNT";

    private static final String COL_WCDL_LIMIT_AVAILABLE = "WCDL_LIMIT_AVAILABLE";

    private static final String COL_WCDL_FACILITY_VALIDITY = "WCDL_FACILITY_VALIDITY";

    private static final String COL_LOAN_OVERDUE_CHECK = "LOAN_OVERDUE_CHECK";

    private static final String COL_COOLING_PERIOD_CHECK = "COOLING_PERIOD_CHECK";

    private static final String COL_LEI_AVAILABLE_CHECK = "LEI_AVAILABLE_CHECK";

    private static final String COL_INTERNAL_RATING_TYPE_CODE = "INTERNAL_RATING_TYPE_CODE";

    private static final String COL_INTERNAL_RATING_VALUE = "INTERNAL_RATING_VALUE";

    private static final String COL_RAROC_STATUS_CHECK = "RAROC_STATUS_CHECK";

    private static final String COL_RAROC_FACILITY_CHECK = "RAROC_FACILITY_CHECK";

    private static final String COL_PSL_AVAILABILITY_CHECK = "PSL_AVAILABILITY_CHECK";

    private static final String COL_FLOW_TYPE_CODE = "FLOW_TYPE_CODE";

    private static final String COL_DIGITAL_FLOW_FLAG = "DIGITAL_FLOW_FLAG";

    private static final String COL_LOB_CODE = "LOB_CODE";

    private static final String COL_REQUEST_DATE = "REQUEST_DATE";

    private static final String COL_REQUEST_CATEGORY_CODE = "REQUEST_CATEGORY_CODE";

    private static final String COL_REQUEST_TYPE_CODE = "REQUEST_TYPE_CODE";

    private static final String COL_REQUEST_CURRENCY_CODE = "REQUEST_CURRENCY_CODE";

    private static final String COL_REQUEST_AMOUNT = "REQUEST_AMOUNT";

    private static final String COL_REQUEST_TENOR_UOM = "REQUEST_TENOR_UOM";

    private static final String COL_ORG_CIF_CODE = "ORG_CIF_CODE";

    private static final String COL_ORG_USER_CIF_CODE = "ORG_USER_CIF_CODE";

    private static final String COL_FACILITY_TYPE_CODE = "FACILITY_TYPE_CODE";

    private static final String COL_RATE_OF_INTEREST = "RATE_OF_INTEREST";

    private static final String COL_TENOR_UOM = "TENOR_UOM";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_EXTERNAL_RATING_TYPE_CODE = "EXTERNAL_RATING_TYPE_CODE";

    private static final String COL_EXTERNAL_RATING_VALUE = "EXTERNAL_RATING_VALUE";

    private static final String COL_OFFER_TYPE_CODE = "OFFER_TYPE_CODE";

    private static final String COL_ACCEPTANCE_PARTY = "ACCEPTANCE_PARTY";

    private static final String COL_ASSESSMENT_PARTY = "ASSESSMENT_PARTY";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String COL_ACCEPTANCE_REASON_CODE = "ACCEPTANCE_REASON_CODE";

    private static final String COL_ACCEPTANCE_COMMENTS = "ACCEPTANCE_COMMENTS";

    private static final String COL_ACCEPTANCE_DATE = "ACCEPTANCE_DATE";

    private static final String COL_ASSESSMENT_REASON_CODE = "ASSESSMENT_REASON_CODE";

    private static final String COL_ASSESSMENT_COMMENTS = "ASSESSMENT_COMMENTS";

    private static final String COL_ASSESSMENT_DATE = "ASSESSMENT_DATE";

    private static final String COL_TENURE_DAYS = "TENURE_DAYS";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ROUTING_CODE = "ROUTING_CODE";

    private static final String COL_ROUTING_TYPE_CODE = "ROUTING_TYPE_CODE";

    private static final String COL_BANK_CODE = "BANK_CODE";

    private static final String COL_TRANSACTION_ID = "TRANSACTION_ID";

    private static final String COL_OFFER_BENCHMARK = "OFFER_BENCHMARK";

    private static final String COL_AVAILABLE_LIMIT = "AVAILABLE_LIMIT";

    private static final String COL_PRIORITY = "PRIORITY";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_ACCOUNT_OPENING_DATE = "ACCOUNT_OPENING_DATE";

    private static final String COL_NOTES = "NOTES";

    private static final String COL_REPRICING_PLAN = "REPRICING_PLAN";

    private static final String COL_RATE_FIXING_METHOD = "RATE_FIXING_METHOD";

    private static final String COL_PEGGING_REVIEW_DATE = "PEGGING_REVIEW_DATE";

    private static final String COL_PEGGING_FREQUENCY = "PEGGING_FREQUENCY";

    private static final String COL_INTEREST_RATE_CODE = "INTEREST_RATE_CODE";

    private static final String COL_SPREAD = "SPREAD";

    private static final String COL_CUSTOMER_PREFERENTIAL_INTEREST = "CUSTOMER_PREFERENTIAL_INTEREST";

    private static final String COL_PENAL_INTEREST_TABLE_CODE = "PENAL_INTEREST_TABLE_CODE";

    private static final String COL_PENAL_PREFERENTIAL_PERCENTAGE = "PENAL_PREFERENTIAL_PERCENTAGE";

    private static final String COL_HOLD_IN_OPT_ACC_FOR_AMT_DUE = "HOLD_IN_OPT_ACC_FOR_AMT_DUE";

    private static final String COL_REPAYMENT_METHOD = "REPAYMENT_METHOD";

    private static final String COL_RECY_ONLY_INT_BY_ACC_DEBIT = "RECY_ONLY_INT_BY_ACC_DEBIT";

    private static final String COL_OPERATIVE_ACCOUNT_NO = "OPERATIVE_ACCOUNT_NO";

    private static final String COL_HUNTING_REQUIRED = "HUNTING_REQUIRED";

    private static final String COL_STRUC_REPAYMENT_SCHEDULE = "STRUC_REPAYMENT_SCHEDULE";

    private static final String COL_EQUATED_INSTALMENT = "EQUATED_INSTALMENT";

    private static final String COL_NO_OF_INSTALMENT = "NO_OF_INSTALMENT";

    private static final String COL_INSTALMENT_START_DATE = "INSTALMENT_START_DATE";

    private static final String COL_INSTALMENT_FREQUENCY = "INSTALMENT_FREQUENCY";

    private static final String COL_INTEREST_FREQUENCY = "INTEREST_FREQUENCY";

    private static final String COL_INSTL_FREQUENCY_START_DATE = "INSTL_FREQUENCY_START_DATE";

    private static final String COL_INTEREST_FREQUENCY_START_DATE = "INTEREST_FREQUENCY_START_DATE";

    private static final String COL_MORATORIUM_PERIOD = "MORATORIUM_PERIOD";

    private static final String COL_MORATORIUM_INTEREST_START_DATE = "MORATORIUM_INTEREST_START_DATE";

    private static final String COL_MORATORIUM_PERIOD_INT_FREQ = "MORATORIUM_PERIOD_INT_FREQ";

    private static final String COL_MORATORIUM_INT_FREQ_START_DATE = "MORATORIUM_INT_FREQ_START_DATE";

    private static final String COL_SUBSECTOR_CODE = "SUBSECTOR_CODE";

    private static final String COL_SECTOR_CODE = "SECTOR_CODE";

    private static final String COL_MODE_OF_ADVANCE = "MODE_OF_ADVANCE";

    private static final String COL_ROLLOVER_FLAG = "ROLLOVER_FLAG";

    private static final String COL_DISB_AUTH_REMARKS = "DISB_AUTH_REMARKS";

    private static final String COL_PAYMENT_MODE = "PAYMENT_MODE";

    private static final String COL_AMOUNT = "AMOUNT";

    private static final String COL_BENEFICIARY_ACCOUNT_NO = "BENEFICIARY_ACCOUNT_NO";

    private static final String COL_BENEFICIARY_ACCOUNT_TYPE = "BENEFICIARY_ACCOUNT_TYPE";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_BENEFICIARY_ADDRESS = "BENEFICIARY_ADDRESS";

    private static final String COL_IFSC_CODE = "IFSC_CODE";

    private static final String COL_PAYMENT_PRODUCT = "PAYMENT_PRODUCT";

    private static final String COL_CCY_RATE = "CCY_RATE";

    private static final String COL_BENEFICIARY_TYPE = "BENEFICIARY_TYPE";

    private static final String COL_BENEFICIARY_LEI_NUMBER = "BENEFICIARY_LEI_NUMBER";

    private static final String COL_MAKER_TEMP_NO = "MAKER_TEMP_NO";

    private static final String COL_AMT_IN_WORDS = "AMT_IN_WORDS";

    private static final String COL_DRAWING_POWER = "DRAWING_POWER";

    private static final String COL_LIMIT_AS_PER_SYSTEM = "LIMIT_AS_PER_SYSTEM";

    private static final String COL_DISB_TILL_DT_UNDER_CONTRACT = "DISB_TILL_DT_UNDER_CONTRACT";

    private static final String COL_FREE_LIMITS_FOR_DISB = "FREE_LIMITS_FOR_DISB";

    private static final String COL_DISB_TILL_DT_UNDER_FACILITY = "DISB_TILL_DT_UNDER_FACILITY";

    private static final String COL_PO_LIMIT = "PO_LIMIT";

    private static final String COL_SYSTEM_FREE_PO_LIMIT = "SYSTEM_FREE_PO_LIMIT";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_LOAN_SPREAD = "LOAN_SPREAD";

    private static final String COL_MIN_RAROC_SPREAD = "MIN_RAROC_SPREAD";

    private static final String COL_MIN_FBIL_FIMMDA_SPREAD = "MIN_FBIL_FIMMDA_SPREAD";

    private static final String COL_BR_DATE = "BR_DATE";

    private static final String COL_TERM_SHEET = "TERM_SHEET";

    private static final String COL_PRICING_SHEET = "PRICING_SHEET";

    private static final String COL_PSL_UPDATION = "PSL_UPDATION";

    private static final String COL_PF_COLLECTED = "PF_COLLECTED";

    private static final String COL_INTERNAL_CONDITIONS = "INTERNAL_CONDITIONS";

    private static final String COL_OVERDUES = "OVERDUES";

    private static final String COL_BRANCH = "BRANCH";

    private static final String COL_MIN_LOAN_AMT = "MIN_LOAN_AMT";

    private static final String COL_MAX_LOAN_AMT = "MAX_LOAN_AMT";

    private static final String COL_SANCTION_LIMIT = "SANCTION_LIMIT";

    private static final String COL_OPERATION_TYPE = "OPERATION_TYPE";

    private static final String COL_UPLOADED_DATE = "UPLOADED_DATE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_DISBURSEMENT_AMOUNT = "DISBURSEMENT_AMOUNT";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_ORG_CIF_NAME = "ORG_CIF_NAME";

    private static final String COL_SEGMENT_TEAMS = "SEGMENT_TEAMS";

    private static final String COL_IS_ACCEPT_LOAN_AGREEMENT = "IS_ACCEPT_LOAN_AGREEMENT";

    private static final String COL_RECOVERY_ACCOUNT_NO = "RECOVERY_ACCOUNT_NO";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_DOWNLOAD_STATUS = "DOWNLOAD_STATUS";

    private static final String COL_DOWNLOAD_TIME = "DOWNLOAD_TIME";

    private static final String COL_REVERSE_FILE_STATUS = "REVERSE_FILE_STATUS";

    private static final String COL_END_USE = "END_USE";

    private static final String COL_REVERSE_STATUS = "REVERSE_STATUS";

    private static final String COL_SPREAD_DISPLAY = "SPREAD_DISPLAY";

    private static final String COL_RESET_FREQUENCY = "RESET_FREQUENCY";

    private static final String COL_RESET_FREQ_UOM = "RESET_FREQ_UOM";

    private static final String COL_RESET_FREQ_VALUE = "RESET_FREQ_VALUE";

    private static final String COL_OVERALL_LIMIT = "OVERALL_LIMIT";

    private static final String COL_GST = "GST";

    private static final String COL_PROC_FEE = "PROC_FEE";

    private static final String COL_BENCHMARK = "BENCHMARK";

    private static final String COL_ROI_BENCHMARK = "ROI_BENCHMARK";

    private static final String COL_INTEREST_START_DATE = "INTEREST_START_DATE";

    private static final String COL_ALERT_STATUS = "ALERT_STATUS";

    private static final String COL_USER_CRN = "USER_CRN";

    private static final String COL_MAKER_TASK_CONSENT = "MAKER_TASK_CONSENT";

    private static final String COL_REVERSE_UPLOAD_REF_ID = "REVERSE_UPLOAD_REF_ID";

    private static final String COL_OFFER_VERSION_ID = "OFFER_VERSION_ID";

    private static final String COL_TENURE_DAYS_LIST = "TENURE_DAYS_LIST";

    private static final String COL_RM_NAME = "RM_NAME";

    private static final String COL_AMT_IN_WORDS_REQ_LETTER = "AMT_IN_WORDS_REQ_LETTER";

    private static final String COL_STP_STATUS = "STP_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_UTILIZED_AMOUNT, COL_OUTSTANDING_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_REQUEST_TENOR, COL_REQUEST_STATUS_CODE, COL_REQUEST_DISBURSEMENT_DATE, COL_RM_PARTY_REFERENCE, COL_PARENT_FACILITY_LIMIT_ID, COL_FACILITY_LIMIT_ID, COL_LEI_NUMBER, COL_LEI_STATUS_CODE, COL_INTEREST_TYPE_CODE, COL_OFFER_CODE, COL_TENOR_MIN, COL_TENOR_MAX, COL_PROCESSING_MODE_CODE, COL_RESET_FREQUENCT_PERIOD_CODE, COL_LOAN_ACCOUNT_NUMBER, COL_LOAN_START_DATE, COL_SANCTIONED_AMOUNT_CCY_CODE, COL_SANCTIONED_AMOUNT, COL_APPLICANT_PARTY, COL_SANCTIONED_DATE, COL_DISBURSEMENT_ACCOUNT, COL_DISBURSED_DATE, COL_SETTLEMENT_ACCOUNT, COL_WCDL_LIMIT_AVAILABLE, COL_WCDL_FACILITY_VALIDITY, COL_LOAN_OVERDUE_CHECK, COL_COOLING_PERIOD_CHECK, COL_LEI_AVAILABLE_CHECK, COL_INTERNAL_RATING_TYPE_CODE, COL_INTERNAL_RATING_VALUE, COL_RAROC_STATUS_CHECK, COL_RAROC_FACILITY_CHECK, COL_PSL_AVAILABILITY_CHECK, COL_FLOW_TYPE_CODE, COL_DIGITAL_FLOW_FLAG, COL_LOB_CODE, COL_REQUEST_DATE, COL_REQUEST_CATEGORY_CODE, COL_REQUEST_TYPE_CODE, COL_REQUEST_CURRENCY_CODE, COL_REQUEST_AMOUNT, COL_REQUEST_TENOR_UOM, COL_ORG_CIF_CODE, COL_ORG_USER_CIF_CODE, COL_FACILITY_TYPE_CODE, COL_RATE_OF_INTEREST, COL_TENOR_UOM, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_EXTERNAL_RATING_TYPE_CODE, COL_EXTERNAL_RATING_VALUE, COL_OFFER_TYPE_CODE, COL_ACCEPTANCE_PARTY, COL_ASSESSMENT_PARTY, COL_PRODUCT_STATUS_CODE, COL_ACCEPTANCE_REASON_CODE, COL_ACCEPTANCE_COMMENTS, COL_ACCEPTANCE_DATE, COL_ASSESSMENT_REASON_CODE, COL_ASSESSMENT_COMMENTS, COL_ASSESSMENT_DATE, COL_TENURE_DAYS, COL_UPLOAD_REF_ID, COL_ROUTING_CODE, COL_ROUTING_TYPE_CODE, COL_BANK_CODE, COL_TRANSACTION_ID, COL_OFFER_BENCHMARK, COL_AVAILABLE_LIMIT, COL_PRIORITY, COL_SCHEME_CODE, COL_ACCOUNT_OPENING_DATE, COL_NOTES, COL_REPRICING_PLAN, COL_RATE_FIXING_METHOD, COL_PEGGING_REVIEW_DATE, COL_PEGGING_FREQUENCY, COL_INTEREST_RATE_CODE, COL_SPREAD, COL_CUSTOMER_PREFERENTIAL_INTEREST, COL_PENAL_INTEREST_TABLE_CODE, COL_PENAL_PREFERENTIAL_PERCENTAGE, COL_HOLD_IN_OPT_ACC_FOR_AMT_DUE, COL_REPAYMENT_METHOD, COL_RECY_ONLY_INT_BY_ACC_DEBIT, COL_OPERATIVE_ACCOUNT_NO, COL_HUNTING_REQUIRED, COL_STRUC_REPAYMENT_SCHEDULE, COL_EQUATED_INSTALMENT, COL_NO_OF_INSTALMENT, COL_INSTALMENT_START_DATE, COL_INSTALMENT_FREQUENCY, COL_INTEREST_FREQUENCY, COL_INSTL_FREQUENCY_START_DATE, COL_INTEREST_FREQUENCY_START_DATE, COL_MORATORIUM_PERIOD, COL_MORATORIUM_INTEREST_START_DATE, COL_MORATORIUM_PERIOD_INT_FREQ, COL_MORATORIUM_INT_FREQ_START_DATE, COL_SUBSECTOR_CODE, COL_SECTOR_CODE, COL_MODE_OF_ADVANCE, COL_ROLLOVER_FLAG, COL_DISB_AUTH_REMARKS, COL_PAYMENT_MODE, COL_AMOUNT, COL_BENEFICIARY_ACCOUNT_NO, COL_BENEFICIARY_ACCOUNT_TYPE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_ADDRESS, COL_IFSC_CODE, COL_PAYMENT_PRODUCT, COL_CCY_RATE, COL_BENEFICIARY_TYPE, COL_BENEFICIARY_LEI_NUMBER, COL_MAKER_TEMP_NO, COL_AMT_IN_WORDS, COL_DRAWING_POWER, COL_LIMIT_AS_PER_SYSTEM, COL_DISB_TILL_DT_UNDER_CONTRACT, COL_FREE_LIMITS_FOR_DISB, COL_DISB_TILL_DT_UNDER_FACILITY, COL_PO_LIMIT, COL_SYSTEM_FREE_PO_LIMIT, COL_MATURITY_DATE, COL_LOAN_SPREAD, COL_MIN_RAROC_SPREAD, COL_MIN_FBIL_FIMMDA_SPREAD, COL_BR_DATE, COL_TERM_SHEET, COL_PRICING_SHEET, COL_PSL_UPDATION, COL_PF_COLLECTED, COL_INTERNAL_CONDITIONS, COL_OVERDUES, COL_BRANCH, COL_MIN_LOAN_AMT, COL_MAX_LOAN_AMT, COL_SANCTION_LIMIT, COL_OPERATION_TYPE, COL_UPLOADED_DATE, COL_SEGMENT_CODE, COL_DISBURSEMENT_AMOUNT, COL_REMARKS, COL_ORG_CIF_NAME, COL_SEGMENT_TEAMS, COL_IS_ACCEPT_LOAN_AGREEMENT, COL_RECOVERY_ACCOUNT_NO, COL_TASK_REASON, COL_DOWNLOAD_STATUS, COL_DOWNLOAD_TIME, COL_REVERSE_FILE_STATUS, COL_END_USE, COL_REVERSE_STATUS, COL_SPREAD_DISPLAY, COL_RESET_FREQUENCY, COL_RESET_FREQ_UOM, COL_RESET_FREQ_VALUE, COL_OVERALL_LIMIT, COL_GST, COL_PROC_FEE, COL_BENCHMARK, COL_ROI_BENCHMARK, COL_INTEREST_START_DATE, COL_ALERT_STATUS, COL_USER_CRN, COL_MAKER_TASK_CONSENT, COL_REVERSE_UPLOAD_REF_ID, COL_OFFER_VERSION_ID, COL_TENURE_DAYS_LIST, COL_RM_NAME, COL_AMT_IN_WORDS_REQ_LETTER, COL_STP_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, FULFILLMENT_PARTY, IS_TEMPLATE, UTILIZED_AMOUNT, OUTSTANDING_AMOUNT, LIMIT_NODE_REFERENCE, REQUEST_TENOR, REQUEST_STATUS_CODE, REQUEST_DISBURSEMENT_DATE, RM_PARTY_REFERENCE, PARENT_FACILITY_LIMIT_ID, FACILITY_LIMIT_ID, LEI_NUMBER, LEI_STATUS_CODE, INTEREST_TYPE_CODE, OFFER_CODE, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, RESET_FREQUENCT_PERIOD_CODE, LOAN_ACCOUNT_NUMBER, LOAN_START_DATE, SANCTIONED_AMOUNT_CCY_CODE, SANCTIONED_AMOUNT, APPLICANT_PARTY, SANCTIONED_DATE, DISBURSEMENT_ACCOUNT, DISBURSED_DATE, SETTLEMENT_ACCOUNT, WCDL_LIMIT_AVAILABLE, WCDL_FACILITY_VALIDITY, LOAN_OVERDUE_CHECK, COOLING_PERIOD_CHECK, LEI_AVAILABLE_CHECK, INTERNAL_RATING_TYPE_CODE, INTERNAL_RATING_VALUE, RAROC_STATUS_CHECK, RAROC_FACILITY_CHECK, PSL_AVAILABILITY_CHECK, FLOW_TYPE_CODE, DIGITAL_FLOW_FLAG, LOB_CODE, REQUEST_DATE, REQUEST_CATEGORY_CODE, REQUEST_TYPE_CODE, REQUEST_CURRENCY_CODE, REQUEST_AMOUNT, REQUEST_TENOR_UOM, ORG_CIF_CODE, ORG_USER_CIF_CODE, FACILITY_TYPE_CODE, RATE_OF_INTEREST, TENOR_UOM, PRODUCT_CODE, SUB_PRODUCT_CODE, EXTERNAL_RATING_TYPE_CODE, EXTERNAL_RATING_VALUE, OFFER_TYPE_CODE, ACCEPTANCE_PARTY, ASSESSMENT_PARTY, PRODUCT_STATUS_CODE, ACCEPTANCE_REASON_CODE, ACCEPTANCE_COMMENTS, ACCEPTANCE_DATE, ASSESSMENT_REASON_CODE, ASSESSMENT_COMMENTS, ASSESSMENT_DATE, TENURE_DAYS, UPLOAD_REF_ID, ROUTING_CODE, ROUTING_TYPE_CODE, BANK_CODE, TRANSACTION_ID, OFFER_BENCHMARK, AVAILABLE_LIMIT, PRIORITY, SCHEME_CODE, ACCOUNT_OPENING_DATE, NOTES, REPRICING_PLAN, RATE_FIXING_METHOD, PEGGING_REVIEW_DATE, PEGGING_FREQUENCY, INTEREST_RATE_CODE, SPREAD, CUSTOMER_PREFERENTIAL_INTEREST, PENAL_INTEREST_TABLE_CODE, PENAL_PREFERENTIAL_PERCENTAGE, HOLD_IN_OPT_ACC_FOR_AMT_DUE, REPAYMENT_METHOD, RECY_ONLY_INT_BY_ACC_DEBIT, OPERATIVE_ACCOUNT_NO, HUNTING_REQUIRED, STRUC_REPAYMENT_SCHEDULE, EQUATED_INSTALMENT, NO_OF_INSTALMENT, INSTALMENT_START_DATE, INSTALMENT_FREQUENCY, INTEREST_FREQUENCY, INSTL_FREQUENCY_START_DATE, INTEREST_FREQUENCY_START_DATE, MORATORIUM_PERIOD, MORATORIUM_INTEREST_START_DATE, MORATORIUM_PERIOD_INT_FREQ, MORATORIUM_INT_FREQ_START_DATE, SUBSECTOR_CODE, SECTOR_CODE, MODE_OF_ADVANCE, ROLLOVER_FLAG, DISB_AUTH_REMARKS, PAYMENT_MODE, AMOUNT, BENEFICIARY_ACCOUNT_NO, BENEFICIARY_ACCOUNT_TYPE, BENEFICIARY_NAME, BENEFICIARY_ADDRESS, IFSC_CODE, PAYMENT_PRODUCT, CCY_RATE, BENEFICIARY_TYPE, BENEFICIARY_LEI_NUMBER, MAKER_TEMP_NO, AMT_IN_WORDS, DRAWING_POWER, LIMIT_AS_PER_SYSTEM, DISB_TILL_DT_UNDER_CONTRACT, FREE_LIMITS_FOR_DISB, DISB_TILL_DT_UNDER_FACILITY, PO_LIMIT, SYSTEM_FREE_PO_LIMIT, MATURITY_DATE, LOAN_SPREAD, MIN_RAROC_SPREAD, MIN_FBIL_FIMMDA_SPREAD, BR_DATE, TERM_SHEET, PRICING_SHEET, PSL_UPDATION, PF_COLLECTED, INTERNAL_CONDITIONS, OVERDUES, BRANCH, MIN_LOAN_AMT, MAX_LOAN_AMT, SANCTION_LIMIT, OPERATION_TYPE, UPLOADED_DATE, SEGMENT_CODE, DISBURSEMENT_AMOUNT, REMARKS, ORG_CIF_NAME, SEGMENT_TEAMS, IS_ACCEPT_LOAN_AGREEMENT, RECOVERY_ACCOUNT_NO, TASK_REASON, DOWNLOAD_STATUS, DOWNLOAD_TIME, REVERSE_FILE_STATUS, END_USE, REVERSE_STATUS, SPREAD_DISPLAY, RESET_FREQUENCY, RESET_FREQ_UOM, RESET_FREQ_VALUE, OVERALL_LIMIT, GST, PROC_FEE, BENCHMARK, ROI_BENCHMARK, INTEREST_START_DATE, ALERT_STATUS, USER_CRN, MAKER_TASK_CONSENT, REVERSE_UPLOAD_REF_ID, OFFER_VERSION_ID, TENURE_DAYS_LIST, RM_NAME, AMT_IN_WORDS_REQ_LETTER, STP_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, FULFILLMENT_PARTY, IS_TEMPLATE, UTILIZED_AMOUNT, OUTSTANDING_AMOUNT, LIMIT_NODE_REFERENCE, REQUEST_TENOR, REQUEST_STATUS_CODE, REQUEST_DISBURSEMENT_DATE, RM_PARTY_REFERENCE, PARENT_FACILITY_LIMIT_ID, FACILITY_LIMIT_ID, LEI_NUMBER, LEI_STATUS_CODE, INTEREST_TYPE_CODE, OFFER_CODE, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, RESET_FREQUENCT_PERIOD_CODE, LOAN_ACCOUNT_NUMBER, LOAN_START_DATE, SANCTIONED_AMOUNT_CCY_CODE, SANCTIONED_AMOUNT, APPLICANT_PARTY, SANCTIONED_DATE, DISBURSEMENT_ACCOUNT, DISBURSED_DATE, SETTLEMENT_ACCOUNT, WCDL_LIMIT_AVAILABLE, WCDL_FACILITY_VALIDITY, LOAN_OVERDUE_CHECK, COOLING_PERIOD_CHECK, LEI_AVAILABLE_CHECK, INTERNAL_RATING_TYPE_CODE, INTERNAL_RATING_VALUE, RAROC_STATUS_CHECK, RAROC_FACILITY_CHECK, PSL_AVAILABILITY_CHECK, FLOW_TYPE_CODE, DIGITAL_FLOW_FLAG, LOB_CODE, REQUEST_DATE, REQUEST_CATEGORY_CODE, REQUEST_TYPE_CODE, REQUEST_CURRENCY_CODE, REQUEST_AMOUNT, REQUEST_TENOR_UOM, ORG_CIF_CODE, ORG_USER_CIF_CODE, FACILITY_TYPE_CODE, RATE_OF_INTEREST, TENOR_UOM, PRODUCT_CODE, SUB_PRODUCT_CODE, EXTERNAL_RATING_TYPE_CODE, EXTERNAL_RATING_VALUE, OFFER_TYPE_CODE, ACCEPTANCE_PARTY, ASSESSMENT_PARTY, PRODUCT_STATUS_CODE, ACCEPTANCE_REASON_CODE, ACCEPTANCE_COMMENTS, ACCEPTANCE_DATE, ASSESSMENT_REASON_CODE, ASSESSMENT_COMMENTS, ASSESSMENT_DATE, TENURE_DAYS, UPLOAD_REF_ID, ROUTING_CODE, ROUTING_TYPE_CODE, BANK_CODE, TRANSACTION_ID, OFFER_BENCHMARK, AVAILABLE_LIMIT, PRIORITY, SCHEME_CODE, ACCOUNT_OPENING_DATE, NOTES, REPRICING_PLAN, RATE_FIXING_METHOD, PEGGING_REVIEW_DATE, PEGGING_FREQUENCY, INTEREST_RATE_CODE, SPREAD, CUSTOMER_PREFERENTIAL_INTEREST, PENAL_INTEREST_TABLE_CODE, PENAL_PREFERENTIAL_PERCENTAGE, HOLD_IN_OPT_ACC_FOR_AMT_DUE, REPAYMENT_METHOD, RECY_ONLY_INT_BY_ACC_DEBIT, OPERATIVE_ACCOUNT_NO, HUNTING_REQUIRED, STRUC_REPAYMENT_SCHEDULE, EQUATED_INSTALMENT, NO_OF_INSTALMENT, INSTALMENT_START_DATE, INSTALMENT_FREQUENCY, INTEREST_FREQUENCY, INSTL_FREQUENCY_START_DATE, INTEREST_FREQUENCY_START_DATE, MORATORIUM_PERIOD, MORATORIUM_INTEREST_START_DATE, MORATORIUM_PERIOD_INT_FREQ, MORATORIUM_INT_FREQ_START_DATE, SUBSECTOR_CODE, SECTOR_CODE, MODE_OF_ADVANCE, ROLLOVER_FLAG, DISB_AUTH_REMARKS, PAYMENT_MODE, AMOUNT, BENEFICIARY_ACCOUNT_NO, BENEFICIARY_ACCOUNT_TYPE, BENEFICIARY_NAME, BENEFICIARY_ADDRESS, IFSC_CODE, PAYMENT_PRODUCT, CCY_RATE, BENEFICIARY_TYPE, BENEFICIARY_LEI_NUMBER, MAKER_TEMP_NO, AMT_IN_WORDS, DRAWING_POWER, LIMIT_AS_PER_SYSTEM, DISB_TILL_DT_UNDER_CONTRACT, FREE_LIMITS_FOR_DISB, DISB_TILL_DT_UNDER_FACILITY, PO_LIMIT, SYSTEM_FREE_PO_LIMIT, MATURITY_DATE, LOAN_SPREAD, MIN_RAROC_SPREAD, MIN_FBIL_FIMMDA_SPREAD, BR_DATE, TERM_SHEET, PRICING_SHEET, PSL_UPDATION, PF_COLLECTED, INTERNAL_CONDITIONS, OVERDUES, BRANCH, MIN_LOAN_AMT, MAX_LOAN_AMT, SANCTION_LIMIT, OPERATION_TYPE, UPLOADED_DATE, SEGMENT_CODE, DISBURSEMENT_AMOUNT, REMARKS, ORG_CIF_NAME, SEGMENT_TEAMS, IS_ACCEPT_LOAN_AGREEMENT, RECOVERY_ACCOUNT_NO, TASK_REASON, DOWNLOAD_STATUS, DOWNLOAD_TIME, REVERSE_FILE_STATUS, END_USE, REVERSE_STATUS, SPREAD_DISPLAY, RESET_FREQUENCY, RESET_FREQ_UOM, RESET_FREQ_VALUE, OVERALL_LIMIT, GST, PROC_FEE, BENCHMARK, ROI_BENCHMARK, INTEREST_START_DATE, ALERT_STATUS, USER_CRN, MAKER_TASK_CONSENT, REVERSE_UPLOAD_REF_ID, OFFER_VERSION_ID, TENURE_DAYS_LIST, RM_NAME, AMT_IN_WORDS_REQ_LETTER, STP_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_UTILIZED_AMOUNT, COL_OUTSTANDING_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_REQUEST_TENOR, COL_REQUEST_STATUS_CODE, COL_REQUEST_DISBURSEMENT_DATE, COL_RM_PARTY_REFERENCE, COL_PARENT_FACILITY_LIMIT_ID, COL_FACILITY_LIMIT_ID, COL_LEI_NUMBER, COL_LEI_STATUS_CODE, COL_INTEREST_TYPE_CODE, COL_OFFER_CODE, COL_TENOR_MIN, COL_TENOR_MAX, COL_PROCESSING_MODE_CODE, COL_RESET_FREQUENCT_PERIOD_CODE, COL_LOAN_ACCOUNT_NUMBER, COL_LOAN_START_DATE, COL_SANCTIONED_AMOUNT_CCY_CODE, COL_SANCTIONED_AMOUNT, COL_APPLICANT_PARTY, COL_SANCTIONED_DATE, COL_DISBURSEMENT_ACCOUNT, COL_DISBURSED_DATE, COL_SETTLEMENT_ACCOUNT, COL_WCDL_LIMIT_AVAILABLE, COL_WCDL_FACILITY_VALIDITY, COL_LOAN_OVERDUE_CHECK, COL_COOLING_PERIOD_CHECK, COL_LEI_AVAILABLE_CHECK, COL_INTERNAL_RATING_TYPE_CODE, COL_INTERNAL_RATING_VALUE, COL_RAROC_STATUS_CHECK, COL_RAROC_FACILITY_CHECK, COL_PSL_AVAILABILITY_CHECK, COL_FLOW_TYPE_CODE, COL_DIGITAL_FLOW_FLAG, COL_LOB_CODE, COL_REQUEST_DATE, COL_REQUEST_CATEGORY_CODE, COL_REQUEST_TYPE_CODE, COL_REQUEST_CURRENCY_CODE, COL_REQUEST_AMOUNT, COL_REQUEST_TENOR_UOM, COL_ORG_CIF_CODE, COL_ORG_USER_CIF_CODE, COL_FACILITY_TYPE_CODE, COL_RATE_OF_INTEREST, COL_TENOR_UOM, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_EXTERNAL_RATING_TYPE_CODE, COL_EXTERNAL_RATING_VALUE, COL_OFFER_TYPE_CODE, COL_ACCEPTANCE_PARTY, COL_ASSESSMENT_PARTY, COL_PRODUCT_STATUS_CODE, COL_ACCEPTANCE_REASON_CODE, COL_ACCEPTANCE_COMMENTS, COL_ACCEPTANCE_DATE, COL_ASSESSMENT_REASON_CODE, COL_ASSESSMENT_COMMENTS, COL_ASSESSMENT_DATE, COL_TENURE_DAYS, COL_UPLOAD_REF_ID, COL_ROUTING_CODE, COL_ROUTING_TYPE_CODE, COL_BANK_CODE, COL_TRANSACTION_ID, COL_OFFER_BENCHMARK, COL_AVAILABLE_LIMIT, COL_PRIORITY, COL_SCHEME_CODE, COL_ACCOUNT_OPENING_DATE, COL_NOTES, COL_REPRICING_PLAN, COL_RATE_FIXING_METHOD, COL_PEGGING_REVIEW_DATE, COL_PEGGING_FREQUENCY, COL_INTEREST_RATE_CODE, COL_SPREAD, COL_CUSTOMER_PREFERENTIAL_INTEREST, COL_PENAL_INTEREST_TABLE_CODE, COL_PENAL_PREFERENTIAL_PERCENTAGE, COL_HOLD_IN_OPT_ACC_FOR_AMT_DUE, COL_REPAYMENT_METHOD, COL_RECY_ONLY_INT_BY_ACC_DEBIT, COL_OPERATIVE_ACCOUNT_NO, COL_HUNTING_REQUIRED, COL_STRUC_REPAYMENT_SCHEDULE, COL_EQUATED_INSTALMENT, COL_NO_OF_INSTALMENT, COL_INSTALMENT_START_DATE, COL_INSTALMENT_FREQUENCY, COL_INTEREST_FREQUENCY, COL_INSTL_FREQUENCY_START_DATE, COL_INTEREST_FREQUENCY_START_DATE, COL_MORATORIUM_PERIOD, COL_MORATORIUM_INTEREST_START_DATE, COL_MORATORIUM_PERIOD_INT_FREQ, COL_MORATORIUM_INT_FREQ_START_DATE, COL_SUBSECTOR_CODE, COL_SECTOR_CODE, COL_MODE_OF_ADVANCE, COL_ROLLOVER_FLAG, COL_DISB_AUTH_REMARKS, COL_PAYMENT_MODE, COL_AMOUNT, COL_BENEFICIARY_ACCOUNT_NO, COL_BENEFICIARY_ACCOUNT_TYPE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_ADDRESS, COL_IFSC_CODE, COL_PAYMENT_PRODUCT, COL_CCY_RATE, COL_BENEFICIARY_TYPE, COL_BENEFICIARY_LEI_NUMBER, COL_MAKER_TEMP_NO, COL_AMT_IN_WORDS, COL_DRAWING_POWER, COL_LIMIT_AS_PER_SYSTEM, COL_DISB_TILL_DT_UNDER_CONTRACT, COL_FREE_LIMITS_FOR_DISB, COL_DISB_TILL_DT_UNDER_FACILITY, COL_PO_LIMIT, COL_SYSTEM_FREE_PO_LIMIT, COL_MATURITY_DATE, COL_LOAN_SPREAD, COL_MIN_RAROC_SPREAD, COL_MIN_FBIL_FIMMDA_SPREAD, COL_BR_DATE, COL_TERM_SHEET, COL_PRICING_SHEET, COL_PSL_UPDATION, COL_PF_COLLECTED, COL_INTERNAL_CONDITIONS, COL_OVERDUES, COL_BRANCH, COL_MIN_LOAN_AMT, COL_MAX_LOAN_AMT, COL_SANCTION_LIMIT, COL_OPERATION_TYPE, COL_UPLOADED_DATE, COL_SEGMENT_CODE, COL_DISBURSEMENT_AMOUNT, COL_REMARKS, COL_ORG_CIF_NAME, COL_SEGMENT_TEAMS, COL_IS_ACCEPT_LOAN_AGREEMENT, COL_RECOVERY_ACCOUNT_NO, COL_TASK_REASON, COL_DOWNLOAD_STATUS, COL_DOWNLOAD_TIME, COL_REVERSE_FILE_STATUS, COL_END_USE, COL_REVERSE_STATUS, COL_SPREAD_DISPLAY, COL_RESET_FREQUENCY, COL_RESET_FREQ_UOM, COL_RESET_FREQ_VALUE, COL_OVERALL_LIMIT, COL_GST, COL_PROC_FEE, COL_BENCHMARK, COL_ROI_BENCHMARK, COL_INTEREST_START_DATE, COL_ALERT_STATUS, COL_USER_CRN, COL_MAKER_TASK_CONSENT, COL_REVERSE_UPLOAD_REF_ID, COL_OFFER_VERSION_ID, COL_TENURE_DAYS_LIST, COL_RM_NAME, COL_AMT_IN_WORDS_REQ_LETTER, COL_STP_STATUS, COL_ID);

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

    public int insert(Connection conn, LosLoanRequest losloanrequest) throws SQLException {
        logger.debug("Inserting losloanrequest: {}", losloanrequest);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLosLoanRequestParams(ps, losloanrequest);
            ps.executeUpdate();
            return losloanrequest.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LosLoanRequest> losloanrequests) throws SQLException {
        if (losloanrequests == null || losloanrequests.isEmpty())
            return new int[0];
        for (int i = 0; i < losloanrequests.size(); i++) {
            if (losloanrequests.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LosLoanRequest>> batches = chunkList(losloanrequests, batchSize);
        int[] totalResults = new int[losloanrequests.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LosLoanRequest> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LosLoanRequest losloanrequest : batch) {
                        setLosLoanRequestParams(ps, losloanrequest);
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

    public LosLoanRequest findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LosLoanRequest> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LosLoanRequest> list = new ArrayList<>();
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

    public boolean update(Connection conn, LosLoanRequest losloanrequest) throws SQLException {
        if (losloanrequest.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLosLoanRequestParams(ps, losloanrequest);
            ps.setInt(193, losloanrequest.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LosLoanRequest> losloanrequests) throws SQLException {
        if (losloanrequests == null || losloanrequests.isEmpty())
            return new int[0];
        for (LosLoanRequest losloanrequest : losloanrequests) {
            if (losloanrequest == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (losloanrequest.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LosLoanRequest>> batches = chunkList(losloanrequests, batchSize);
        int[] totalResults = new int[losloanrequests.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LosLoanRequest> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LosLoanRequest losloanrequest : batch) {
                        setLosLoanRequestParams(ps, losloanrequest);
                        ps.setInt(193, losloanrequest.getID());
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

    private void setLosLoanRequestParams(PreparedStatement ps, LosLoanRequest losloanrequest) throws SQLException {
        Integer val1 = losloanrequest.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = losloanrequest.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, losloanrequest.getTypeCode());
        ps.setString(4, losloanrequest.getSubTypeCode());
        ps.setString(5, losloanrequest.getActiveCode());
        ps.setString(6, losloanrequest.getStageCode());
        ps.setString(7, losloanrequest.getStatusCode());
        Integer val8 = losloanrequest.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, losloanrequest.getCreatedOn());
        java.math.BigDecimal val10 = losloanrequest.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, losloanrequest.getLastUpdatedOn());
        java.math.BigDecimal val12 = losloanrequest.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, losloanrequest.getLastAuthorisedOn());
        java.math.BigDecimal val14 = losloanrequest.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, losloanrequest.getTemplate());
        ps.setString(16, losloanrequest.getFulfillmentParty());
        java.math.BigDecimal val17 = losloanrequest.getIsTemplate();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = losloanrequest.getUtilizedAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = losloanrequest.getOutstandingAmount();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, losloanrequest.getLimitNodeReference());
        java.math.BigDecimal val21 = losloanrequest.getRequestTenor();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, losloanrequest.getRequestStatusCode());
        java.time.LocalDateTime val23 = losloanrequest.getRequestDisbursementDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, losloanrequest.getRmPartyReference());
        Integer val25 = losloanrequest.getParentFacilityLimitID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = losloanrequest.getFacilityLimitID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, losloanrequest.getLeiNumber());
        ps.setString(28, losloanrequest.getLeiStatusCode());
        ps.setString(29, losloanrequest.getInterestTypeCode());
        ps.setString(30, losloanrequest.getOfferCode());
        java.math.BigDecimal val31 = losloanrequest.getTenorMin();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = losloanrequest.getTenorMax();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, losloanrequest.getProcessingModeCode());
        ps.setString(34, losloanrequest.getResetFrequenctPeriodCode());
        ps.setString(35, losloanrequest.getLoanAccountNumber());
        java.time.LocalDateTime val36 = losloanrequest.getLoanStartDate();
        if (val36 != null) {
            ps.setTimestamp(36, java.sql.Timestamp.valueOf(val36));
        } else {
            ps.setNull(36, Types.TIMESTAMP);
        }
        java.math.BigDecimal val37 = losloanrequest.getSanctionedAmountCcyCode();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = losloanrequest.getSanctionedAmount();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, losloanrequest.getApplicantParty());
        ps.setString(40, losloanrequest.getSanctionedDate());
        ps.setString(41, losloanrequest.getDisbursementAccount());
        java.time.LocalDateTime val42 = losloanrequest.getDisbursedDate();
        if (val42 != null) {
            ps.setTimestamp(42, java.sql.Timestamp.valueOf(val42));
        } else {
            ps.setNull(42, Types.TIMESTAMP);
        }
        ps.setString(43, losloanrequest.getSettlementAccount());
        java.math.BigDecimal val44 = losloanrequest.getWcdlLimitAvailable();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        java.math.BigDecimal val45 = losloanrequest.getWcdlFacilityValidity();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = losloanrequest.getLoanOverdueCheck();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = losloanrequest.getCoolingPeriodCheck();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = losloanrequest.getLeiAvailableCheck();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, losloanrequest.getInternalRatingTypeCode());
        ps.setString(50, losloanrequest.getInternalRatingValue());
        java.math.BigDecimal val51 = losloanrequest.getRarocStatusCheck();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        java.math.BigDecimal val52 = losloanrequest.getRarocFacilityCheck();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        java.math.BigDecimal val53 = losloanrequest.getPslAvailabilityCheck();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, losloanrequest.getFlowTypeCode());
        java.math.BigDecimal val55 = losloanrequest.getDigitalFlowFlag();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, losloanrequest.getLobCode());
        ps.setString(57, losloanrequest.getRequestDate());
        ps.setString(58, losloanrequest.getRequestCategoryCode());
        ps.setString(59, losloanrequest.getRequestTypeCode());
        ps.setString(60, losloanrequest.getRequestCurrencyCode());
        java.math.BigDecimal val61 = losloanrequest.getRequestAmount();
        if (val61 != null) {
            ps.setBigDecimal(61, val61);
        } else {
            ps.setNull(61, Types.DECIMAL);
        }
        ps.setString(62, losloanrequest.getRequestTenorUom());
        ps.setString(63, losloanrequest.getOrgCifCode());
        ps.setString(64, losloanrequest.getOrgUserCifCode());
        ps.setString(65, losloanrequest.getFacilityTypeCode());
        java.math.BigDecimal val66 = losloanrequest.getRateOfInterest();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        ps.setString(67, losloanrequest.getTenorUom());
        ps.setString(68, losloanrequest.getProductCode());
        ps.setString(69, losloanrequest.getSubProductCode());
        ps.setString(70, losloanrequest.getExternalRatingTypeCode());
        ps.setString(71, losloanrequest.getExternalRatingValue());
        ps.setString(72, losloanrequest.getOfferTypeCode());
        ps.setString(73, losloanrequest.getAcceptanceParty());
        ps.setString(74, losloanrequest.getAssessmentParty());
        ps.setString(75, losloanrequest.getProductStatusCode());
        ps.setString(76, losloanrequest.getAcceptanceReasonCode());
        ps.setString(77, losloanrequest.getAcceptanceComments());
        java.time.LocalDateTime val78 = losloanrequest.getAcceptanceDate();
        if (val78 != null) {
            ps.setTimestamp(78, java.sql.Timestamp.valueOf(val78));
        } else {
            ps.setNull(78, Types.TIMESTAMP);
        }
        ps.setString(79, losloanrequest.getAssessmentReasonCode());
        ps.setString(80, losloanrequest.getAssessmentComments());
        java.time.LocalDateTime val81 = losloanrequest.getAssessmentDate();
        if (val81 != null) {
            ps.setTimestamp(81, java.sql.Timestamp.valueOf(val81));
        } else {
            ps.setNull(81, Types.TIMESTAMP);
        }
        ps.setString(82, losloanrequest.getTenureDays());
        Integer val83 = losloanrequest.getUploadRefID();
        if (val83 != null) {
            ps.setInt(83, val83);
        } else {
            ps.setNull(83, Types.INTEGER);
        }
        ps.setString(84, losloanrequest.getRoutingCode());
        ps.setString(85, losloanrequest.getRoutingTypeCode());
        ps.setString(86, losloanrequest.getBankCode());
        Integer val87 = losloanrequest.getTransactionID();
        if (val87 != null) {
            ps.setInt(87, val87);
        } else {
            ps.setNull(87, Types.INTEGER);
        }
        ps.setString(88, losloanrequest.getOfferBenchmark());
        java.math.BigDecimal val89 = losloanrequest.getAvailableLimit();
        if (val89 != null) {
            ps.setBigDecimal(89, val89);
        } else {
            ps.setNull(89, Types.DECIMAL);
        }
        ps.setString(90, losloanrequest.getPriority());
        ps.setString(91, losloanrequest.getSchemeCode());
        ps.setString(92, losloanrequest.getAccountOpeningDate());
        ps.setString(93, losloanrequest.getNotes());
        ps.setString(94, losloanrequest.getRepricingPlan());
        java.math.BigDecimal val95 = losloanrequest.getRateFixingMethod();
        if (val95 != null) {
            ps.setBigDecimal(95, val95);
        } else {
            ps.setNull(95, Types.DECIMAL);
        }
        java.time.LocalDateTime val96 = losloanrequest.getPeggingReviewDate();
        if (val96 != null) {
            ps.setTimestamp(96, java.sql.Timestamp.valueOf(val96));
        } else {
            ps.setNull(96, Types.TIMESTAMP);
        }
        ps.setString(97, losloanrequest.getPeggingFrequency());
        java.math.BigDecimal val98 = losloanrequest.getInterestRateCode();
        if (val98 != null) {
            ps.setBigDecimal(98, val98);
        } else {
            ps.setNull(98, Types.DECIMAL);
        }
        java.math.BigDecimal val99 = losloanrequest.getSpread();
        if (val99 != null) {
            ps.setBigDecimal(99, val99);
        } else {
            ps.setNull(99, Types.DECIMAL);
        }
        java.math.BigDecimal val100 = losloanrequest.getCustomerPreferentialInterest();
        if (val100 != null) {
            ps.setBigDecimal(100, val100);
        } else {
            ps.setNull(100, Types.DECIMAL);
        }
        ps.setString(101, losloanrequest.getPenalInterestTableCode());
        ps.setString(102, losloanrequest.getPenalPreferentialPercentage());
        ps.setString(103, losloanrequest.getHoldInOptAccForAmtDue());
        ps.setString(104, losloanrequest.getRepaymentMethod());
        ps.setString(105, losloanrequest.getRecyOnlyIntByAccDebit());
        java.math.BigDecimal val106 = losloanrequest.getOperativeAccountNo();
        if (val106 != null) {
            ps.setBigDecimal(106, val106);
        } else {
            ps.setNull(106, Types.DECIMAL);
        }
        ps.setString(107, losloanrequest.getHuntingRequired());
        ps.setString(108, losloanrequest.getStrucRepaymentSchedule());
        ps.setString(109, losloanrequest.getEquatedInstalment());
        ps.setString(110, losloanrequest.getNoOfInstalment());
        java.time.LocalDateTime val111 = losloanrequest.getInstalmentStartDate();
        if (val111 != null) {
            ps.setTimestamp(111, java.sql.Timestamp.valueOf(val111));
        } else {
            ps.setNull(111, Types.TIMESTAMP);
        }
        ps.setString(112, losloanrequest.getInstalmentFrequency());
        ps.setString(113, losloanrequest.getInterestFrequency());
        java.time.LocalDateTime val114 = losloanrequest.getInstlFrequencyStartDate();
        if (val114 != null) {
            ps.setTimestamp(114, java.sql.Timestamp.valueOf(val114));
        } else {
            ps.setNull(114, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val115 = losloanrequest.getInterestFrequencyStartDate();
        if (val115 != null) {
            ps.setTimestamp(115, java.sql.Timestamp.valueOf(val115));
        } else {
            ps.setNull(115, Types.TIMESTAMP);
        }
        ps.setString(116, losloanrequest.getMoratoriumPeriod());
        java.time.LocalDateTime val117 = losloanrequest.getMoratoriumInterestStartDate();
        if (val117 != null) {
            ps.setTimestamp(117, java.sql.Timestamp.valueOf(val117));
        } else {
            ps.setNull(117, Types.TIMESTAMP);
        }
        ps.setString(118, losloanrequest.getMoratoriumPeriodIntFreq());
        java.time.LocalDateTime val119 = losloanrequest.getMoratoriumIntFreqStartDate();
        if (val119 != null) {
            ps.setTimestamp(119, java.sql.Timestamp.valueOf(val119));
        } else {
            ps.setNull(119, Types.TIMESTAMP);
        }
        ps.setString(120, losloanrequest.getSubsectorCode());
        ps.setString(121, losloanrequest.getSectorCode());
        ps.setString(122, losloanrequest.getModeOfAdvance());
        ps.setString(123, losloanrequest.getRolloverFlag());
        ps.setString(124, losloanrequest.getDisbAuthRemarks());
        ps.setString(125, losloanrequest.getPaymentMode());
        java.math.BigDecimal val126 = losloanrequest.getAmount();
        if (val126 != null) {
            ps.setBigDecimal(126, val126);
        } else {
            ps.setNull(126, Types.DECIMAL);
        }
        ps.setString(127, losloanrequest.getBeneficiaryAccountNo());
        ps.setString(128, losloanrequest.getBeneficiaryAccountType());
        ps.setString(129, losloanrequest.getBeneficiaryName());
        ps.setString(130, losloanrequest.getBeneficiaryAddress());
        ps.setString(131, losloanrequest.getIfscCode());
        ps.setString(132, losloanrequest.getPaymentProduct());
        java.math.BigDecimal val133 = losloanrequest.getCcyRate();
        if (val133 != null) {
            ps.setBigDecimal(133, val133);
        } else {
            ps.setNull(133, Types.DECIMAL);
        }
        ps.setString(134, losloanrequest.getBeneficiaryType());
        ps.setString(135, losloanrequest.getBeneficiaryLeiNumber());
        ps.setString(136, losloanrequest.getMakerTempNo());
        ps.setString(137, losloanrequest.getAmtInWords());
        java.math.BigDecimal val138 = losloanrequest.getDrawingPower();
        if (val138 != null) {
            ps.setBigDecimal(138, val138);
        } else {
            ps.setNull(138, Types.DECIMAL);
        }
        java.math.BigDecimal val139 = losloanrequest.getLimitAsPerSystem();
        if (val139 != null) {
            ps.setBigDecimal(139, val139);
        } else {
            ps.setNull(139, Types.DECIMAL);
        }
        ps.setString(140, losloanrequest.getDisbTillDtUnderContract());
        java.math.BigDecimal val141 = losloanrequest.getFreeLimitsForDisb();
        if (val141 != null) {
            ps.setBigDecimal(141, val141);
        } else {
            ps.setNull(141, Types.DECIMAL);
        }
        ps.setString(142, losloanrequest.getDisbTillDtUnderFacility());
        java.math.BigDecimal val143 = losloanrequest.getPoLimit();
        if (val143 != null) {
            ps.setBigDecimal(143, val143);
        } else {
            ps.setNull(143, Types.DECIMAL);
        }
        java.math.BigDecimal val144 = losloanrequest.getSystemFreePoLimit();
        if (val144 != null) {
            ps.setBigDecimal(144, val144);
        } else {
            ps.setNull(144, Types.DECIMAL);
        }
        java.time.LocalDateTime val145 = losloanrequest.getMaturityDate();
        if (val145 != null) {
            ps.setTimestamp(145, java.sql.Timestamp.valueOf(val145));
        } else {
            ps.setNull(145, Types.TIMESTAMP);
        }
        java.math.BigDecimal val146 = losloanrequest.getLoanSpread();
        if (val146 != null) {
            ps.setBigDecimal(146, val146);
        } else {
            ps.setNull(146, Types.DECIMAL);
        }
        java.math.BigDecimal val147 = losloanrequest.getMinRarocSpread();
        if (val147 != null) {
            ps.setBigDecimal(147, val147);
        } else {
            ps.setNull(147, Types.DECIMAL);
        }
        java.math.BigDecimal val148 = losloanrequest.getMinFbilFimmdaSpread();
        if (val148 != null) {
            ps.setBigDecimal(148, val148);
        } else {
            ps.setNull(148, Types.DECIMAL);
        }
        java.time.LocalDateTime val149 = losloanrequest.getBrDate();
        if (val149 != null) {
            ps.setTimestamp(149, java.sql.Timestamp.valueOf(val149));
        } else {
            ps.setNull(149, Types.TIMESTAMP);
        }
        ps.setString(150, losloanrequest.getTermSheet());
        ps.setString(151, losloanrequest.getPricingSheet());
        ps.setString(152, losloanrequest.getPslUpdation());
        ps.setString(153, losloanrequest.getPfCollected());
        ps.setString(154, losloanrequest.getInternalConditions());
        java.math.BigDecimal val155 = losloanrequest.getOverdues();
        if (val155 != null) {
            ps.setBigDecimal(155, val155);
        } else {
            ps.setNull(155, Types.DECIMAL);
        }
        ps.setString(156, losloanrequest.getBranch());
        java.math.BigDecimal val157 = losloanrequest.getMinLoanAmt();
        if (val157 != null) {
            ps.setBigDecimal(157, val157);
        } else {
            ps.setNull(157, Types.DECIMAL);
        }
        java.math.BigDecimal val158 = losloanrequest.getMaxLoanAmt();
        if (val158 != null) {
            ps.setBigDecimal(158, val158);
        } else {
            ps.setNull(158, Types.DECIMAL);
        }
        java.math.BigDecimal val159 = losloanrequest.getSanctionLimit();
        if (val159 != null) {
            ps.setBigDecimal(159, val159);
        } else {
            ps.setNull(159, Types.DECIMAL);
        }
        ps.setString(160, losloanrequest.getOperationType());
        java.time.LocalDateTime val161 = losloanrequest.getUploadedDate();
        if (val161 != null) {
            ps.setTimestamp(161, java.sql.Timestamp.valueOf(val161));
        } else {
            ps.setNull(161, Types.TIMESTAMP);
        }
        ps.setString(162, losloanrequest.getSegmentCode());
        java.math.BigDecimal val163 = losloanrequest.getDisbursementAmount();
        if (val163 != null) {
            ps.setBigDecimal(163, val163);
        } else {
            ps.setNull(163, Types.DECIMAL);
        }
        ps.setString(164, losloanrequest.getRemarks());
        ps.setString(165, losloanrequest.getOrgCifName());
        ps.setString(166, losloanrequest.getSegmentTeams());
        java.math.BigDecimal val167 = losloanrequest.getIsAcceptLoanAgreement();
        if (val167 != null) {
            ps.setBigDecimal(167, val167);
        } else {
            ps.setNull(167, Types.DECIMAL);
        }
        ps.setString(168, losloanrequest.getRecoveryAccountNo());
        ps.setString(169, losloanrequest.getTaskReason());
        ps.setString(170, losloanrequest.getDownloadStatus());
        ps.setString(171, losloanrequest.getDownloadTime());
        ps.setString(172, losloanrequest.getReverseFileStatus());
        ps.setString(173, losloanrequest.getEndUse());
        ps.setString(174, losloanrequest.getReverseStatus());
        ps.setString(175, losloanrequest.getSpreadDisplay());
        ps.setString(176, losloanrequest.getResetFrequency());
        ps.setString(177, losloanrequest.getResetFreqUom());
        java.math.BigDecimal val178 = losloanrequest.getResetFreqValue();
        if (val178 != null) {
            ps.setBigDecimal(178, val178);
        } else {
            ps.setNull(178, Types.DECIMAL);
        }
        java.math.BigDecimal val179 = losloanrequest.getOverallLimit();
        if (val179 != null) {
            ps.setBigDecimal(179, val179);
        } else {
            ps.setNull(179, Types.DECIMAL);
        }
        java.math.BigDecimal val180 = losloanrequest.getGst();
        if (val180 != null) {
            ps.setBigDecimal(180, val180);
        } else {
            ps.setNull(180, Types.DECIMAL);
        }
        java.math.BigDecimal val181 = losloanrequest.getProcFee();
        if (val181 != null) {
            ps.setBigDecimal(181, val181);
        } else {
            ps.setNull(181, Types.DECIMAL);
        }
        ps.setString(182, losloanrequest.getBenchmark());
        java.math.BigDecimal val183 = losloanrequest.getRoiBenchmark();
        if (val183 != null) {
            ps.setBigDecimal(183, val183);
        } else {
            ps.setNull(183, Types.DECIMAL);
        }
        java.time.LocalDateTime val184 = losloanrequest.getInterestStartDate();
        if (val184 != null) {
            ps.setTimestamp(184, java.sql.Timestamp.valueOf(val184));
        } else {
            ps.setNull(184, Types.TIMESTAMP);
        }
        ps.setString(185, losloanrequest.getAlertStatus());
        ps.setString(186, losloanrequest.getUserCrn());
        ps.setString(187, losloanrequest.getMakerTaskConsent());
        Integer val188 = losloanrequest.getReverseUploadRefID();
        if (val188 != null) {
            ps.setInt(188, val188);
        } else {
            ps.setNull(188, Types.INTEGER);
        }
        Integer val189 = losloanrequest.getOfferVersionID();
        if (val189 != null) {
            ps.setInt(189, val189);
        } else {
            ps.setNull(189, Types.INTEGER);
        }
        ps.setString(190, losloanrequest.getTenureDaysList());
        ps.setString(191, losloanrequest.getRmName());
        ps.setString(192, losloanrequest.getAmtInWordsReqLetter());
        ps.setString(193, losloanrequest.getStpStatus());
    }

    private LosLoanRequest extract(ResultSet rs) throws SQLException {
        LosLoanRequest losloanrequest = new LosLoanRequest();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        losloanrequest.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        losloanrequest.setReferenceID(REFERENCE_ID);
        losloanrequest.setTypeCode(rs.getString(COL_TYPE_CODE));
        losloanrequest.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        losloanrequest.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        losloanrequest.setStageCode(rs.getString(COL_STAGE_CODE));
        losloanrequest.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        losloanrequest.setProcessID(PROCESS_ID);
        losloanrequest.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        losloanrequest.setCreatedBy(CREATED_BY);
        losloanrequest.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        losloanrequest.setLastUpdatedBy(LAST_UPDATED_BY);
        losloanrequest.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        losloanrequest.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        losloanrequest.setTemplate(rs.getString(COL_TEMPLATE));
        losloanrequest.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        losloanrequest.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal UTILIZED_AMOUNT = rs.getObject(COL_UTILIZED_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setUtilizedAmount(UTILIZED_AMOUNT);
        java.math.BigDecimal OUTSTANDING_AMOUNT = rs.getObject(COL_OUTSTANDING_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setOutstandingAmount(OUTSTANDING_AMOUNT);
        losloanrequest.setLimitNodeReference(rs.getString(COL_LIMIT_NODE_REFERENCE));
        java.math.BigDecimal REQUEST_TENOR = rs.getObject(COL_REQUEST_TENOR, java.math.BigDecimal.class);
        losloanrequest.setRequestTenor(REQUEST_TENOR);
        losloanrequest.setRequestStatusCode(rs.getString(COL_REQUEST_STATUS_CODE));
        Timestamp REQUEST_DISBURSEMENT_DATE = rs.getTimestamp(COL_REQUEST_DISBURSEMENT_DATE);
        if (REQUEST_DISBURSEMENT_DATE != null)
            losloanrequest.setRequestDisbursementDate(REQUEST_DISBURSEMENT_DATE.toLocalDateTime());
        losloanrequest.setRmPartyReference(rs.getString(COL_RM_PARTY_REFERENCE));
        Integer PARENT_FACILITY_LIMIT_ID = rs.getObject(COL_PARENT_FACILITY_LIMIT_ID, Integer.class);
        losloanrequest.setParentFacilityLimitID(PARENT_FACILITY_LIMIT_ID);
        Integer FACILITY_LIMIT_ID = rs.getObject(COL_FACILITY_LIMIT_ID, Integer.class);
        losloanrequest.setFacilityLimitID(FACILITY_LIMIT_ID);
        losloanrequest.setLeiNumber(rs.getString(COL_LEI_NUMBER));
        losloanrequest.setLeiStatusCode(rs.getString(COL_LEI_STATUS_CODE));
        losloanrequest.setInterestTypeCode(rs.getString(COL_INTEREST_TYPE_CODE));
        losloanrequest.setOfferCode(rs.getString(COL_OFFER_CODE));
        java.math.BigDecimal TENOR_MIN = rs.getObject(COL_TENOR_MIN, java.math.BigDecimal.class);
        losloanrequest.setTenorMin(TENOR_MIN);
        java.math.BigDecimal TENOR_MAX = rs.getObject(COL_TENOR_MAX, java.math.BigDecimal.class);
        losloanrequest.setTenorMax(TENOR_MAX);
        losloanrequest.setProcessingModeCode(rs.getString(COL_PROCESSING_MODE_CODE));
        losloanrequest.setResetFrequenctPeriodCode(rs.getString(COL_RESET_FREQUENCT_PERIOD_CODE));
        losloanrequest.setLoanAccountNumber(rs.getString(COL_LOAN_ACCOUNT_NUMBER));
        Timestamp LOAN_START_DATE = rs.getTimestamp(COL_LOAN_START_DATE);
        if (LOAN_START_DATE != null)
            losloanrequest.setLoanStartDate(LOAN_START_DATE.toLocalDateTime());
        java.math.BigDecimal SANCTIONED_AMOUNT_CCY_CODE = rs.getObject(COL_SANCTIONED_AMOUNT_CCY_CODE, java.math.BigDecimal.class);
        losloanrequest.setSanctionedAmountCcyCode(SANCTIONED_AMOUNT_CCY_CODE);
        java.math.BigDecimal SANCTIONED_AMOUNT = rs.getObject(COL_SANCTIONED_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setSanctionedAmount(SANCTIONED_AMOUNT);
        losloanrequest.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        losloanrequest.setSanctionedDate(rs.getString(COL_SANCTIONED_DATE));
        losloanrequest.setDisbursementAccount(rs.getString(COL_DISBURSEMENT_ACCOUNT));
        Timestamp DISBURSED_DATE = rs.getTimestamp(COL_DISBURSED_DATE);
        if (DISBURSED_DATE != null)
            losloanrequest.setDisbursedDate(DISBURSED_DATE.toLocalDateTime());
        losloanrequest.setSettlementAccount(rs.getString(COL_SETTLEMENT_ACCOUNT));
        java.math.BigDecimal WCDL_LIMIT_AVAILABLE = rs.getObject(COL_WCDL_LIMIT_AVAILABLE, java.math.BigDecimal.class);
        losloanrequest.setWcdlLimitAvailable(WCDL_LIMIT_AVAILABLE);
        java.math.BigDecimal WCDL_FACILITY_VALIDITY = rs.getObject(COL_WCDL_FACILITY_VALIDITY, java.math.BigDecimal.class);
        losloanrequest.setWcdlFacilityValidity(WCDL_FACILITY_VALIDITY);
        java.math.BigDecimal LOAN_OVERDUE_CHECK = rs.getObject(COL_LOAN_OVERDUE_CHECK, java.math.BigDecimal.class);
        losloanrequest.setLoanOverdueCheck(LOAN_OVERDUE_CHECK);
        java.math.BigDecimal COOLING_PERIOD_CHECK = rs.getObject(COL_COOLING_PERIOD_CHECK, java.math.BigDecimal.class);
        losloanrequest.setCoolingPeriodCheck(COOLING_PERIOD_CHECK);
        java.math.BigDecimal LEI_AVAILABLE_CHECK = rs.getObject(COL_LEI_AVAILABLE_CHECK, java.math.BigDecimal.class);
        losloanrequest.setLeiAvailableCheck(LEI_AVAILABLE_CHECK);
        losloanrequest.setInternalRatingTypeCode(rs.getString(COL_INTERNAL_RATING_TYPE_CODE));
        losloanrequest.setInternalRatingValue(rs.getString(COL_INTERNAL_RATING_VALUE));
        java.math.BigDecimal RAROC_STATUS_CHECK = rs.getObject(COL_RAROC_STATUS_CHECK, java.math.BigDecimal.class);
        losloanrequest.setRarocStatusCheck(RAROC_STATUS_CHECK);
        java.math.BigDecimal RAROC_FACILITY_CHECK = rs.getObject(COL_RAROC_FACILITY_CHECK, java.math.BigDecimal.class);
        losloanrequest.setRarocFacilityCheck(RAROC_FACILITY_CHECK);
        java.math.BigDecimal PSL_AVAILABILITY_CHECK = rs.getObject(COL_PSL_AVAILABILITY_CHECK, java.math.BigDecimal.class);
        losloanrequest.setPslAvailabilityCheck(PSL_AVAILABILITY_CHECK);
        losloanrequest.setFlowTypeCode(rs.getString(COL_FLOW_TYPE_CODE));
        java.math.BigDecimal DIGITAL_FLOW_FLAG = rs.getObject(COL_DIGITAL_FLOW_FLAG, java.math.BigDecimal.class);
        losloanrequest.setDigitalFlowFlag(DIGITAL_FLOW_FLAG);
        losloanrequest.setLobCode(rs.getString(COL_LOB_CODE));
        losloanrequest.setRequestDate(rs.getString(COL_REQUEST_DATE));
        losloanrequest.setRequestCategoryCode(rs.getString(COL_REQUEST_CATEGORY_CODE));
        losloanrequest.setRequestTypeCode(rs.getString(COL_REQUEST_TYPE_CODE));
        losloanrequest.setRequestCurrencyCode(rs.getString(COL_REQUEST_CURRENCY_CODE));
        java.math.BigDecimal REQUEST_AMOUNT = rs.getObject(COL_REQUEST_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setRequestAmount(REQUEST_AMOUNT);
        losloanrequest.setRequestTenorUom(rs.getString(COL_REQUEST_TENOR_UOM));
        losloanrequest.setOrgCifCode(rs.getString(COL_ORG_CIF_CODE));
        losloanrequest.setOrgUserCifCode(rs.getString(COL_ORG_USER_CIF_CODE));
        losloanrequest.setFacilityTypeCode(rs.getString(COL_FACILITY_TYPE_CODE));
        java.math.BigDecimal RATE_OF_INTEREST = rs.getObject(COL_RATE_OF_INTEREST, java.math.BigDecimal.class);
        losloanrequest.setRateOfInterest(RATE_OF_INTEREST);
        losloanrequest.setTenorUom(rs.getString(COL_TENOR_UOM));
        losloanrequest.setProductCode(rs.getString(COL_PRODUCT_CODE));
        losloanrequest.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        losloanrequest.setExternalRatingTypeCode(rs.getString(COL_EXTERNAL_RATING_TYPE_CODE));
        losloanrequest.setExternalRatingValue(rs.getString(COL_EXTERNAL_RATING_VALUE));
        losloanrequest.setOfferTypeCode(rs.getString(COL_OFFER_TYPE_CODE));
        losloanrequest.setAcceptanceParty(rs.getString(COL_ACCEPTANCE_PARTY));
        losloanrequest.setAssessmentParty(rs.getString(COL_ASSESSMENT_PARTY));
        losloanrequest.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        losloanrequest.setAcceptanceReasonCode(rs.getString(COL_ACCEPTANCE_REASON_CODE));
        losloanrequest.setAcceptanceComments(rs.getString(COL_ACCEPTANCE_COMMENTS));
        Timestamp ACCEPTANCE_DATE = rs.getTimestamp(COL_ACCEPTANCE_DATE);
        if (ACCEPTANCE_DATE != null)
            losloanrequest.setAcceptanceDate(ACCEPTANCE_DATE.toLocalDateTime());
        losloanrequest.setAssessmentReasonCode(rs.getString(COL_ASSESSMENT_REASON_CODE));
        losloanrequest.setAssessmentComments(rs.getString(COL_ASSESSMENT_COMMENTS));
        Timestamp ASSESSMENT_DATE = rs.getTimestamp(COL_ASSESSMENT_DATE);
        if (ASSESSMENT_DATE != null)
            losloanrequest.setAssessmentDate(ASSESSMENT_DATE.toLocalDateTime());
        losloanrequest.setTenureDays(rs.getString(COL_TENURE_DAYS));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        losloanrequest.setUploadRefID(UPLOAD_REF_ID);
        losloanrequest.setRoutingCode(rs.getString(COL_ROUTING_CODE));
        losloanrequest.setRoutingTypeCode(rs.getString(COL_ROUTING_TYPE_CODE));
        losloanrequest.setBankCode(rs.getString(COL_BANK_CODE));
        Integer TRANSACTION_ID = rs.getObject(COL_TRANSACTION_ID, Integer.class);
        losloanrequest.setTransactionID(TRANSACTION_ID);
        losloanrequest.setOfferBenchmark(rs.getString(COL_OFFER_BENCHMARK));
        java.math.BigDecimal AVAILABLE_LIMIT = rs.getObject(COL_AVAILABLE_LIMIT, java.math.BigDecimal.class);
        losloanrequest.setAvailableLimit(AVAILABLE_LIMIT);
        losloanrequest.setPriority(rs.getString(COL_PRIORITY));
        losloanrequest.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        losloanrequest.setAccountOpeningDate(rs.getString(COL_ACCOUNT_OPENING_DATE));
        losloanrequest.setNotes(rs.getString(COL_NOTES));
        losloanrequest.setRepricingPlan(rs.getString(COL_REPRICING_PLAN));
        java.math.BigDecimal RATE_FIXING_METHOD = rs.getObject(COL_RATE_FIXING_METHOD, java.math.BigDecimal.class);
        losloanrequest.setRateFixingMethod(RATE_FIXING_METHOD);
        Timestamp PEGGING_REVIEW_DATE = rs.getTimestamp(COL_PEGGING_REVIEW_DATE);
        if (PEGGING_REVIEW_DATE != null)
            losloanrequest.setPeggingReviewDate(PEGGING_REVIEW_DATE.toLocalDateTime());
        losloanrequest.setPeggingFrequency(rs.getString(COL_PEGGING_FREQUENCY));
        java.math.BigDecimal INTEREST_RATE_CODE = rs.getObject(COL_INTEREST_RATE_CODE, java.math.BigDecimal.class);
        losloanrequest.setInterestRateCode(INTEREST_RATE_CODE);
        java.math.BigDecimal SPREAD = rs.getObject(COL_SPREAD, java.math.BigDecimal.class);
        losloanrequest.setSpread(SPREAD);
        java.math.BigDecimal CUSTOMER_PREFERENTIAL_INTEREST = rs.getObject(COL_CUSTOMER_PREFERENTIAL_INTEREST, java.math.BigDecimal.class);
        losloanrequest.setCustomerPreferentialInterest(CUSTOMER_PREFERENTIAL_INTEREST);
        losloanrequest.setPenalInterestTableCode(rs.getString(COL_PENAL_INTEREST_TABLE_CODE));
        losloanrequest.setPenalPreferentialPercentage(rs.getString(COL_PENAL_PREFERENTIAL_PERCENTAGE));
        losloanrequest.setHoldInOptAccForAmtDue(rs.getString(COL_HOLD_IN_OPT_ACC_FOR_AMT_DUE));
        losloanrequest.setRepaymentMethod(rs.getString(COL_REPAYMENT_METHOD));
        losloanrequest.setRecyOnlyIntByAccDebit(rs.getString(COL_RECY_ONLY_INT_BY_ACC_DEBIT));
        java.math.BigDecimal OPERATIVE_ACCOUNT_NO = rs.getObject(COL_OPERATIVE_ACCOUNT_NO, java.math.BigDecimal.class);
        losloanrequest.setOperativeAccountNo(OPERATIVE_ACCOUNT_NO);
        losloanrequest.setHuntingRequired(rs.getString(COL_HUNTING_REQUIRED));
        losloanrequest.setStrucRepaymentSchedule(rs.getString(COL_STRUC_REPAYMENT_SCHEDULE));
        losloanrequest.setEquatedInstalment(rs.getString(COL_EQUATED_INSTALMENT));
        losloanrequest.setNoOfInstalment(rs.getString(COL_NO_OF_INSTALMENT));
        Timestamp INSTALMENT_START_DATE = rs.getTimestamp(COL_INSTALMENT_START_DATE);
        if (INSTALMENT_START_DATE != null)
            losloanrequest.setInstalmentStartDate(INSTALMENT_START_DATE.toLocalDateTime());
        losloanrequest.setInstalmentFrequency(rs.getString(COL_INSTALMENT_FREQUENCY));
        losloanrequest.setInterestFrequency(rs.getString(COL_INTEREST_FREQUENCY));
        Timestamp INSTL_FREQUENCY_START_DATE = rs.getTimestamp(COL_INSTL_FREQUENCY_START_DATE);
        if (INSTL_FREQUENCY_START_DATE != null)
            losloanrequest.setInstlFrequencyStartDate(INSTL_FREQUENCY_START_DATE.toLocalDateTime());
        Timestamp INTEREST_FREQUENCY_START_DATE = rs.getTimestamp(COL_INTEREST_FREQUENCY_START_DATE);
        if (INTEREST_FREQUENCY_START_DATE != null)
            losloanrequest.setInterestFrequencyStartDate(INTEREST_FREQUENCY_START_DATE.toLocalDateTime());
        losloanrequest.setMoratoriumPeriod(rs.getString(COL_MORATORIUM_PERIOD));
        Timestamp MORATORIUM_INTEREST_START_DATE = rs.getTimestamp(COL_MORATORIUM_INTEREST_START_DATE);
        if (MORATORIUM_INTEREST_START_DATE != null)
            losloanrequest.setMoratoriumInterestStartDate(MORATORIUM_INTEREST_START_DATE.toLocalDateTime());
        losloanrequest.setMoratoriumPeriodIntFreq(rs.getString(COL_MORATORIUM_PERIOD_INT_FREQ));
        Timestamp MORATORIUM_INT_FREQ_START_DATE = rs.getTimestamp(COL_MORATORIUM_INT_FREQ_START_DATE);
        if (MORATORIUM_INT_FREQ_START_DATE != null)
            losloanrequest.setMoratoriumIntFreqStartDate(MORATORIUM_INT_FREQ_START_DATE.toLocalDateTime());
        losloanrequest.setSubsectorCode(rs.getString(COL_SUBSECTOR_CODE));
        losloanrequest.setSectorCode(rs.getString(COL_SECTOR_CODE));
        losloanrequest.setModeOfAdvance(rs.getString(COL_MODE_OF_ADVANCE));
        losloanrequest.setRolloverFlag(rs.getString(COL_ROLLOVER_FLAG));
        losloanrequest.setDisbAuthRemarks(rs.getString(COL_DISB_AUTH_REMARKS));
        losloanrequest.setPaymentMode(rs.getString(COL_PAYMENT_MODE));
        java.math.BigDecimal AMOUNT = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setAmount(AMOUNT);
        losloanrequest.setBeneficiaryAccountNo(rs.getString(COL_BENEFICIARY_ACCOUNT_NO));
        losloanrequest.setBeneficiaryAccountType(rs.getString(COL_BENEFICIARY_ACCOUNT_TYPE));
        losloanrequest.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        losloanrequest.setBeneficiaryAddress(rs.getString(COL_BENEFICIARY_ADDRESS));
        losloanrequest.setIfscCode(rs.getString(COL_IFSC_CODE));
        losloanrequest.setPaymentProduct(rs.getString(COL_PAYMENT_PRODUCT));
        java.math.BigDecimal CCY_RATE = rs.getObject(COL_CCY_RATE, java.math.BigDecimal.class);
        losloanrequest.setCcyRate(CCY_RATE);
        losloanrequest.setBeneficiaryType(rs.getString(COL_BENEFICIARY_TYPE));
        losloanrequest.setBeneficiaryLeiNumber(rs.getString(COL_BENEFICIARY_LEI_NUMBER));
        losloanrequest.setMakerTempNo(rs.getString(COL_MAKER_TEMP_NO));
        losloanrequest.setAmtInWords(rs.getString(COL_AMT_IN_WORDS));
        java.math.BigDecimal DRAWING_POWER = rs.getObject(COL_DRAWING_POWER, java.math.BigDecimal.class);
        losloanrequest.setDrawingPower(DRAWING_POWER);
        java.math.BigDecimal LIMIT_AS_PER_SYSTEM = rs.getObject(COL_LIMIT_AS_PER_SYSTEM, java.math.BigDecimal.class);
        losloanrequest.setLimitAsPerSystem(LIMIT_AS_PER_SYSTEM);
        losloanrequest.setDisbTillDtUnderContract(rs.getString(COL_DISB_TILL_DT_UNDER_CONTRACT));
        java.math.BigDecimal FREE_LIMITS_FOR_DISB = rs.getObject(COL_FREE_LIMITS_FOR_DISB, java.math.BigDecimal.class);
        losloanrequest.setFreeLimitsForDisb(FREE_LIMITS_FOR_DISB);
        losloanrequest.setDisbTillDtUnderFacility(rs.getString(COL_DISB_TILL_DT_UNDER_FACILITY));
        java.math.BigDecimal PO_LIMIT = rs.getObject(COL_PO_LIMIT, java.math.BigDecimal.class);
        losloanrequest.setPoLimit(PO_LIMIT);
        java.math.BigDecimal SYSTEM_FREE_PO_LIMIT = rs.getObject(COL_SYSTEM_FREE_PO_LIMIT, java.math.BigDecimal.class);
        losloanrequest.setSystemFreePoLimit(SYSTEM_FREE_PO_LIMIT);
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            losloanrequest.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        java.math.BigDecimal LOAN_SPREAD = rs.getObject(COL_LOAN_SPREAD, java.math.BigDecimal.class);
        losloanrequest.setLoanSpread(LOAN_SPREAD);
        java.math.BigDecimal MIN_RAROC_SPREAD = rs.getObject(COL_MIN_RAROC_SPREAD, java.math.BigDecimal.class);
        losloanrequest.setMinRarocSpread(MIN_RAROC_SPREAD);
        java.math.BigDecimal MIN_FBIL_FIMMDA_SPREAD = rs.getObject(COL_MIN_FBIL_FIMMDA_SPREAD, java.math.BigDecimal.class);
        losloanrequest.setMinFbilFimmdaSpread(MIN_FBIL_FIMMDA_SPREAD);
        Timestamp BR_DATE = rs.getTimestamp(COL_BR_DATE);
        if (BR_DATE != null)
            losloanrequest.setBrDate(BR_DATE.toLocalDateTime());
        losloanrequest.setTermSheet(rs.getString(COL_TERM_SHEET));
        losloanrequest.setPricingSheet(rs.getString(COL_PRICING_SHEET));
        losloanrequest.setPslUpdation(rs.getString(COL_PSL_UPDATION));
        losloanrequest.setPfCollected(rs.getString(COL_PF_COLLECTED));
        losloanrequest.setInternalConditions(rs.getString(COL_INTERNAL_CONDITIONS));
        java.math.BigDecimal OVERDUES = rs.getObject(COL_OVERDUES, java.math.BigDecimal.class);
        losloanrequest.setOverdues(OVERDUES);
        losloanrequest.setBranch(rs.getString(COL_BRANCH));
        java.math.BigDecimal MIN_LOAN_AMT = rs.getObject(COL_MIN_LOAN_AMT, java.math.BigDecimal.class);
        losloanrequest.setMinLoanAmt(MIN_LOAN_AMT);
        java.math.BigDecimal MAX_LOAN_AMT = rs.getObject(COL_MAX_LOAN_AMT, java.math.BigDecimal.class);
        losloanrequest.setMaxLoanAmt(MAX_LOAN_AMT);
        java.math.BigDecimal SANCTION_LIMIT = rs.getObject(COL_SANCTION_LIMIT, java.math.BigDecimal.class);
        losloanrequest.setSanctionLimit(SANCTION_LIMIT);
        losloanrequest.setOperationType(rs.getString(COL_OPERATION_TYPE));
        Timestamp UPLOADED_DATE = rs.getTimestamp(COL_UPLOADED_DATE);
        if (UPLOADED_DATE != null)
            losloanrequest.setUploadedDate(UPLOADED_DATE.toLocalDateTime());
        losloanrequest.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        java.math.BigDecimal DISBURSEMENT_AMOUNT = rs.getObject(COL_DISBURSEMENT_AMOUNT, java.math.BigDecimal.class);
        losloanrequest.setDisbursementAmount(DISBURSEMENT_AMOUNT);
        losloanrequest.setRemarks(rs.getString(COL_REMARKS));
        losloanrequest.setOrgCifName(rs.getString(COL_ORG_CIF_NAME));
        losloanrequest.setSegmentTeams(rs.getString(COL_SEGMENT_TEAMS));
        java.math.BigDecimal IS_ACCEPT_LOAN_AGREEMENT = rs.getObject(COL_IS_ACCEPT_LOAN_AGREEMENT, java.math.BigDecimal.class);
        losloanrequest.setIsAcceptLoanAgreement(IS_ACCEPT_LOAN_AGREEMENT);
        losloanrequest.setRecoveryAccountNo(rs.getString(COL_RECOVERY_ACCOUNT_NO));
        losloanrequest.setTaskReason(rs.getString(COL_TASK_REASON));
        losloanrequest.setDownloadStatus(rs.getString(COL_DOWNLOAD_STATUS));
        losloanrequest.setDownloadTime(rs.getString(COL_DOWNLOAD_TIME));
        losloanrequest.setReverseFileStatus(rs.getString(COL_REVERSE_FILE_STATUS));
        losloanrequest.setEndUse(rs.getString(COL_END_USE));
        losloanrequest.setReverseStatus(rs.getString(COL_REVERSE_STATUS));
        losloanrequest.setSpreadDisplay(rs.getString(COL_SPREAD_DISPLAY));
        losloanrequest.setResetFrequency(rs.getString(COL_RESET_FREQUENCY));
        losloanrequest.setResetFreqUom(rs.getString(COL_RESET_FREQ_UOM));
        java.math.BigDecimal RESET_FREQ_VALUE = rs.getObject(COL_RESET_FREQ_VALUE, java.math.BigDecimal.class);
        losloanrequest.setResetFreqValue(RESET_FREQ_VALUE);
        java.math.BigDecimal OVERALL_LIMIT = rs.getObject(COL_OVERALL_LIMIT, java.math.BigDecimal.class);
        losloanrequest.setOverallLimit(OVERALL_LIMIT);
        java.math.BigDecimal GST = rs.getObject(COL_GST, java.math.BigDecimal.class);
        losloanrequest.setGst(GST);
        java.math.BigDecimal PROC_FEE = rs.getObject(COL_PROC_FEE, java.math.BigDecimal.class);
        losloanrequest.setProcFee(PROC_FEE);
        losloanrequest.setBenchmark(rs.getString(COL_BENCHMARK));
        java.math.BigDecimal ROI_BENCHMARK = rs.getObject(COL_ROI_BENCHMARK, java.math.BigDecimal.class);
        losloanrequest.setRoiBenchmark(ROI_BENCHMARK);
        Timestamp INTEREST_START_DATE = rs.getTimestamp(COL_INTEREST_START_DATE);
        if (INTEREST_START_DATE != null)
            losloanrequest.setInterestStartDate(INTEREST_START_DATE.toLocalDateTime());
        losloanrequest.setAlertStatus(rs.getString(COL_ALERT_STATUS));
        losloanrequest.setUserCrn(rs.getString(COL_USER_CRN));
        losloanrequest.setMakerTaskConsent(rs.getString(COL_MAKER_TASK_CONSENT));
        Integer REVERSE_UPLOAD_REF_ID = rs.getObject(COL_REVERSE_UPLOAD_REF_ID, Integer.class);
        losloanrequest.setReverseUploadRefID(REVERSE_UPLOAD_REF_ID);
        Integer OFFER_VERSION_ID = rs.getObject(COL_OFFER_VERSION_ID, Integer.class);
        losloanrequest.setOfferVersionID(OFFER_VERSION_ID);
        losloanrequest.setTenureDaysList(rs.getString(COL_TENURE_DAYS_LIST));
        losloanrequest.setRmName(rs.getString(COL_RM_NAME));
        losloanrequest.setAmtInWordsReqLetter(rs.getString(COL_AMT_IN_WORDS_REQ_LETTER));
        losloanrequest.setStpStatus(rs.getString(COL_STP_STATUS));
        return losloanrequest;
    }
}
