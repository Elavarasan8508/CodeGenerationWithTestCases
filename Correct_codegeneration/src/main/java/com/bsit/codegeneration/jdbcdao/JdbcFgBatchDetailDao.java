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

public class JdbcFgBatchDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBatchDetailDao.class);

    private static final String TABLE = "FG_BATCH_DETAIL";

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

    private static final String COL_PAYMENT_REF_NO = "PAYMENT_REF_NO";

    private static final String COL_PAYMENT_TYPE = "PAYMENT_TYPE";

    private static final String COL_PAYMENT_DATE = "PAYMENT_DATE";

    private static final String COL_INSTRUMENT_DATE = "INSTRUMENT_DATE";

    private static final String COL_INSTRUMENT_NUMBER = "INSTRUMENT_NUMBER";

    private static final String COL_DR_DESCRIPTION = "DR_DESCRIPTION";

    private static final String COL_DR_REF_NO = "DR_REF_NO";

    private static final String COL_CR_REF_NO = "CR_REF_NO";

    private static final String COL_BANK_CODE_INDICATOR = "BANK_CODE_INDICATOR";

    private static final String COL_BENE_CODE = "BENE_CODE";

    private static final String COL_BENE_NAME = "BENE_NAME";

    private static final String COL_BENE_BANK = "BENE_BANK";

    private static final String COL_BENE_BANK_AND_IFSC_CODE = "BENE_BANK_AND_IFSC_CODE";

    private static final String COL_LOCATION = "LOCATION";

    private static final String COL_PRINT_LOCATION = "PRINT_LOCATION";

    private static final String COL_BENE_ADD_1 = "BENE_ADD_1";

    private static final String COL_BENE_ADD_2 = "BENE_ADD_2";

    private static final String COL_BENE_ADD_3 = "BENE_ADD_3";

    private static final String COL_BENE_ADD_4 = "BENE_ADD_4";

    private static final String COL_BENE_ADD_5 = "BENE_ADD_5";

    private static final String COL_BENE_CITY = "BENE_CITY";

    private static final String COL_BENE_STATE = "BENE_STATE";

    private static final String COL_BENE_EMAIL = "BENE_EMAIL";

    private static final String COL_PAYMENT_DET_1 = "PAYMENT_DET_1";

    private static final String COL_PAYMENT_DET_2 = "PAYMENT_DET_2";

    private static final String COL_PAYMENT_DET_3 = "PAYMENT_DET_3";

    private static final String COL_PAYMENT_DET_4 = "PAYMENT_DET_4";

    private static final String COL_DELIVERY_MODE = "DELIVERY_MODE";

    private static final String COL_TRANSACTION_TYPE = "TRANSACTION_TYPE";

    private static final String COL_HUNDI_NUMBER = "HUNDI_NUMBER";

    private static final String COL_BOE_TENOR = "BOE_TENOR";

    private static final String COL_BOE_TENOR_1 = "BOE_TENOR_1";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_BOE_DUE_DATE = "BOE_DUE_DATE";

    private static final String COL_BOE_DUE_DATE_DEL_HOLIDAYS = "BOE_DUE_DATE_DEL_HOLIDAYS";

    private static final String COL_BOE_DUE_DATE_ACTUAL_PREPAY = "BOE_DUE_DATE_ACTUAL_PREPAY";

    private static final String COL_CHEQUE_NUMBER = "CHEQUE_NUMBER";

    private static final String COL_DRAWER_CODE = "DRAWER_CODE";

    private static final String COL_DRWR_COLLECTION_AREA_NAME = "DRWR_COLLECTION_AREA_NAME";

    private static final String COL_DRWR_FULL_NAME = "DRWR_FULL_NAME";

    private static final String COL_DRWR_LOCATION_CODE = "DRWR_LOCATION_CODE";

    private static final String COL_DRWR_ADDRESS_LINE = "DRWR_ADDRESS_LINE";

    private static final String COL_DRWR_BSNS_AREA_CODE = "DRWR_BSNS_AREA_CODE";

    private static final String COL_DRWR_BSNS_AREA_NAME = "DRWR_BSNS_AREA_NAME";

    private static final String COL_DRWR_BANK_NAME = "DRWR_BANK_NAME";

    private static final String COL_DRWE_MICR_CODE = "DRWE_MICR_CODE";

    private static final String COL_DRWE_BANK_IFC_CODE = "DRWE_BANK_IFC_CODE";

    private static final String COL_ACC_TYPE = "ACC_TYPE";

    private static final String COL_DRWE_FULL_NAME = "DRWE_FULL_NAME";

    private static final String COL_DRWE_ADDR_LINE_1 = "DRWE_ADDR_LINE_1";

    private static final String COL_DRWE_ADDR_LINE_2 = "DRWE_ADDR_LINE_2";

    private static final String COL_DRWE_ADDR_LINE_3 = "DRWE_ADDR_LINE_3";

    private static final String COL_DRWE_ADDR_LINE_4 = "DRWE_ADDR_LINE_4";

    private static final String COL_DRWE_ADDR_LINE_5 = "DRWE_ADDR_LINE_5";

    private static final String COL_DRWE_LOCATION_CODE = "DRWE_LOCATION_CODE";

    private static final String COL_DRWE_BSNS_AREA_CODE = "DRWE_BSNS_AREA_CODE";

    private static final String COL_DD_PAYABLE_LOCATION = "DD_PAYABLE_LOCATION";

    private static final String COL_COUNT_OF_ANNXR_REC = "COUNT_OF_ANNXR_REC";

    private static final String COL_CUST_SPECIALS_REF_NO = "CUST_SPECIALS_REF_NO";

    private static final String COL_DRWR_COLLECTION_AREA_CODE = "DRWR_COLLECTION_AREA_CODE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_DRWR_ACC_NO_OTHER_BANK = "DRWR_ACC_NO_OTHER_BANK";

    private static final String COL_DRWE_BMS_AC_NO = "DRWE_BMS_AC_NO";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_BENE_ZIPCODE = "BENE_ZIPCODE";

    private static final String COL_BOE_AMOUNT = "BOE_AMOUNT";

    private static final String COL_AMOUNT = "AMOUNT";

    private static final String COL_DR_AC_NO = "DR_AC_NO";

    private static final String COL_BENE_MOBILE = "BENE_MOBILE";

    private static final String COL_BENE_ACC_NO = "BENE_ACC_NO";

    private static final String COL_CLIENT_CODE_DYNAMIC = "CLIENT_CODE_DYNAMIC";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_EQUIVALENT_AMOUNT = "EQUIVALENT_AMOUNT";

    private static final String COL_EQUIVALENT_CURRENCY = "EQUIVALENT_CURRENCY";

    private static final String COL_DISPLAY_AMOUNT = "DISPLAY_AMOUNT";

    private static final String COL_DISPLAY_CURRENCY = "DISPLAY_CURRENCY";

    private static final String COL_AUTH_EQUIVALENT_AMOUNT = "AUTH_EQUIVALENT_AMOUNT";

    private static final String COL_AUTH_EQUIVALENT_CURRENCY = "AUTH_EQUIVALENT_CURRENCY";

    private static final String COL_DISPLAY_EQUIVALENT_AMOUNT = "DISPLAY_EQUIVALENT_AMOUNT";

    private static final String COL_DISPLAY_EQUIVALENT_CURRENCY = "DISPLAY_EQUIVALENT_CURRENCY";

    private static final String COL_AUTH_FX_BASE_RATE = "AUTH_FX_BASE_RATE";

    private static final String COL_DISPLAY_FX_BASE_RATE = "DISPLAY_FX_BASE_RATE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_BATCH_STATUS = "BATCH_STATUS";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_BATCH_REMARKS = "BATCH_REMARKS";

    private static final String COL_TI_STATUS = "TI_STATUS";

    private static final String COL_TI_BATCH_REF_ID = "TI_BATCH_REF_ID";

    private static final String COL_TI_REMARKS = "TI_REMARKS";

    private static final String COL_TNX_DISPLAY_STATUS = "TNX_DISPLAY_STATUS";

    private static final String COL_TNX_DISPLAY_BATCH_ID = "TNX_DISPLAY_BATCH_ID";

    private static final String COL_TNX_DISPLAY_REMARKS = "TNX_DISPLAY_REMARKS";

    private static final String COL_ADVANCE_INTEREST = "ADVANCE_INTEREST";

    private static final String COL_NET_PAYMENT = "NET_PAYMENT";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_UTR_NUMBER = "UTR_NUMBER";

    private static final String COL_CHARGES = "CHARGES";

    private static final String COL_CHECK_BOX = "CHECK_BOX";

    private static final String COL_COMPANY_CODE = "COMPANY_CODE";

    private static final String COL_COMPANY_NAME = "COMPANY_NAME";

    private static final String COL_FISCAL_YEAR = "FISCAL_YEAR";

    private static final String COL_CUSTOMER_CODE = "CUSTOMER_CODE";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String COL_GST_INV_NO = "GST_INV_NO";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_INV_AMOUNT = "INV_AMOUNT";

    private static final String COL_GRN_NO = "GRN_NO";

    private static final String COL_GRN_DATE = "GRN_DATE";

    private static final String COL_PAYMENT_TERM = "PAYMENT_TERM";

    private static final String COL_DUE_DATE = "DUE_DATE";

    private static final String COL_TYPE_OF_TRANSACTION = "TYPE_OF_TRANSACTION";

    private static final String COL_FINANCE_PARTY = "FINANCE_PARTY";

    private static final String COL_LOAN_REQUEST_TYPE = "LOAN_REQUEST_TYPE";

    private static final String COL_CUSTOM_MATURITY_DATE = "CUSTOM_MATURITY_DATE";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_FINANCE_REQUEST_STATUS = "FINANCE_REQUEST_STATUS";

    private static final String COL_FINANCE_REQUESTED = "FINANCE_REQUESTED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PAYMENT_REF_NO, COL_PAYMENT_TYPE, COL_PAYMENT_DATE, COL_INSTRUMENT_DATE, COL_INSTRUMENT_NUMBER, COL_DR_DESCRIPTION, COL_DR_REF_NO, COL_CR_REF_NO, COL_BANK_CODE_INDICATOR, COL_BENE_CODE, COL_BENE_NAME, COL_BENE_BANK, COL_BENE_BANK_AND_IFSC_CODE, COL_LOCATION, COL_PRINT_LOCATION, COL_BENE_ADD_1, COL_BENE_ADD_2, COL_BENE_ADD_3, COL_BENE_ADD_4, COL_BENE_ADD_5, COL_BENE_CITY, COL_BENE_STATE, COL_BENE_EMAIL, COL_PAYMENT_DET_1, COL_PAYMENT_DET_2, COL_PAYMENT_DET_3, COL_PAYMENT_DET_4, COL_DELIVERY_MODE, COL_TRANSACTION_TYPE, COL_HUNDI_NUMBER, COL_BOE_TENOR, COL_BOE_TENOR_1, COL_BOE_DATE, COL_BOE_DUE_DATE, COL_BOE_DUE_DATE_DEL_HOLIDAYS, COL_BOE_DUE_DATE_ACTUAL_PREPAY, COL_CHEQUE_NUMBER, COL_DRAWER_CODE, COL_DRWR_COLLECTION_AREA_NAME, COL_DRWR_FULL_NAME, COL_DRWR_LOCATION_CODE, COL_DRWR_ADDRESS_LINE, COL_DRWR_BSNS_AREA_CODE, COL_DRWR_BSNS_AREA_NAME, COL_DRWR_BANK_NAME, COL_DRWE_MICR_CODE, COL_DRWE_BANK_IFC_CODE, COL_ACC_TYPE, COL_DRWE_FULL_NAME, COL_DRWE_ADDR_LINE_1, COL_DRWE_ADDR_LINE_2, COL_DRWE_ADDR_LINE_3, COL_DRWE_ADDR_LINE_4, COL_DRWE_ADDR_LINE_5, COL_DRWE_LOCATION_CODE, COL_DRWE_BSNS_AREA_CODE, COL_DD_PAYABLE_LOCATION, COL_COUNT_OF_ANNXR_REC, COL_CUST_SPECIALS_REF_NO, COL_DRWR_COLLECTION_AREA_CODE, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_DRWR_ACC_NO_OTHER_BANK, COL_DRWE_BMS_AC_NO, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_BENE_ZIPCODE, COL_BOE_AMOUNT, COL_AMOUNT, COL_DR_AC_NO, COL_BENE_MOBILE, COL_BENE_ACC_NO, COL_CLIENT_CODE_DYNAMIC, COL_FILE_NAME, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_CHECK_BOX, COL_COMPANY_CODE, COL_COMPANY_NAME, COL_FISCAL_YEAR, COL_CUSTOMER_CODE, COL_CUSTOMER_NAME, COL_GST_INV_NO, COL_INVOICE_NUMBER, COL_INVOICE_DATE, COL_INV_AMOUNT, COL_GRN_NO, COL_GRN_DATE, COL_PAYMENT_TERM, COL_DUE_DATE, COL_TYPE_OF_TRANSACTION, COL_FINANCE_PARTY, COL_LOAN_REQUEST_TYPE, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PAYMENT_REF_NO, PAYMENT_TYPE, PAYMENT_DATE, INSTRUMENT_DATE, INSTRUMENT_NUMBER, DR_DESCRIPTION, DR_REF_NO, CR_REF_NO, BANK_CODE_INDICATOR, BENE_CODE, BENE_NAME, BENE_BANK, BENE_BANK_AND_IFSC_CODE, LOCATION, PRINT_LOCATION, BENE_ADD_1, BENE_ADD_2, BENE_ADD_3, BENE_ADD_4, BENE_ADD_5, BENE_CITY, BENE_STATE, BENE_EMAIL, PAYMENT_DET_1, PAYMENT_DET_2, PAYMENT_DET_3, PAYMENT_DET_4, DELIVERY_MODE, TRANSACTION_TYPE, HUNDI_NUMBER, BOE_TENOR, BOE_TENOR_1, BOE_DATE, BOE_DUE_DATE, BOE_DUE_DATE_DEL_HOLIDAYS, BOE_DUE_DATE_ACTUAL_PREPAY, CHEQUE_NUMBER, DRAWER_CODE, DRWR_COLLECTION_AREA_NAME, DRWR_FULL_NAME, DRWR_LOCATION_CODE, DRWR_ADDRESS_LINE, DRWR_BSNS_AREA_CODE, DRWR_BSNS_AREA_NAME, DRWR_BANK_NAME, DRWE_MICR_CODE, DRWE_BANK_IFC_CODE, ACC_TYPE, DRWE_FULL_NAME, DRWE_ADDR_LINE_1, DRWE_ADDR_LINE_2, DRWE_ADDR_LINE_3, DRWE_ADDR_LINE_4, DRWE_ADDR_LINE_5, DRWE_LOCATION_CODE, DRWE_BSNS_AREA_CODE, DD_PAYABLE_LOCATION, COUNT_OF_ANNXR_REC, CUST_SPECIALS_REF_NO, DRWR_COLLECTION_AREA_CODE, UPLOAD_REF_ID, LINE_NO, DRWR_ACC_NO_OTHER_BANK, DRWE_BMS_AC_NO, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, BENE_ZIPCODE, BOE_AMOUNT, AMOUNT, DR_AC_NO, BENE_MOBILE, BENE_ACC_NO, CLIENT_CODE_DYNAMIC, FILE_NAME, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, CHECK_BOX, COMPANY_CODE, COMPANY_NAME, FISCAL_YEAR, CUSTOMER_CODE, CUSTOMER_NAME, GST_INV_NO, INVOICE_NUMBER, INVOICE_DATE, INV_AMOUNT, GRN_NO, GRN_DATE, PAYMENT_TERM, DUE_DATE, TYPE_OF_TRANSACTION, FINANCE_PARTY, LOAN_REQUEST_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_UUID, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PAYMENT_REF_NO, PAYMENT_TYPE, PAYMENT_DATE, INSTRUMENT_DATE, INSTRUMENT_NUMBER, DR_DESCRIPTION, DR_REF_NO, CR_REF_NO, BANK_CODE_INDICATOR, BENE_CODE, BENE_NAME, BENE_BANK, BENE_BANK_AND_IFSC_CODE, LOCATION, PRINT_LOCATION, BENE_ADD_1, BENE_ADD_2, BENE_ADD_3, BENE_ADD_4, BENE_ADD_5, BENE_CITY, BENE_STATE, BENE_EMAIL, PAYMENT_DET_1, PAYMENT_DET_2, PAYMENT_DET_3, PAYMENT_DET_4, DELIVERY_MODE, TRANSACTION_TYPE, HUNDI_NUMBER, BOE_TENOR, BOE_TENOR_1, BOE_DATE, BOE_DUE_DATE, BOE_DUE_DATE_DEL_HOLIDAYS, BOE_DUE_DATE_ACTUAL_PREPAY, CHEQUE_NUMBER, DRAWER_CODE, DRWR_COLLECTION_AREA_NAME, DRWR_FULL_NAME, DRWR_LOCATION_CODE, DRWR_ADDRESS_LINE, DRWR_BSNS_AREA_CODE, DRWR_BSNS_AREA_NAME, DRWR_BANK_NAME, DRWE_MICR_CODE, DRWE_BANK_IFC_CODE, ACC_TYPE, DRWE_FULL_NAME, DRWE_ADDR_LINE_1, DRWE_ADDR_LINE_2, DRWE_ADDR_LINE_3, DRWE_ADDR_LINE_4, DRWE_ADDR_LINE_5, DRWE_LOCATION_CODE, DRWE_BSNS_AREA_CODE, DD_PAYABLE_LOCATION, COUNT_OF_ANNXR_REC, CUST_SPECIALS_REF_NO, DRWR_COLLECTION_AREA_CODE, UPLOAD_REF_ID, LINE_NO, DRWR_ACC_NO_OTHER_BANK, DRWE_BMS_AC_NO, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, BENE_ZIPCODE, BOE_AMOUNT, AMOUNT, DR_AC_NO, BENE_MOBILE, BENE_ACC_NO, CLIENT_CODE_DYNAMIC, FILE_NAME, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, CHECK_BOX, COMPANY_CODE, COMPANY_NAME, FISCAL_YEAR, CUSTOMER_CODE, CUSTOMER_NAME, GST_INV_NO, INVOICE_NUMBER, INVOICE_DATE, INV_AMOUNT, GRN_NO, GRN_DATE, PAYMENT_TERM, DUE_DATE, TYPE_OF_TRANSACTION, FINANCE_PARTY, LOAN_REQUEST_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_UUID, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PAYMENT_REF_NO, COL_PAYMENT_TYPE, COL_PAYMENT_DATE, COL_INSTRUMENT_DATE, COL_INSTRUMENT_NUMBER, COL_DR_DESCRIPTION, COL_DR_REF_NO, COL_CR_REF_NO, COL_BANK_CODE_INDICATOR, COL_BENE_CODE, COL_BENE_NAME, COL_BENE_BANK, COL_BENE_BANK_AND_IFSC_CODE, COL_LOCATION, COL_PRINT_LOCATION, COL_BENE_ADD_1, COL_BENE_ADD_2, COL_BENE_ADD_3, COL_BENE_ADD_4, COL_BENE_ADD_5, COL_BENE_CITY, COL_BENE_STATE, COL_BENE_EMAIL, COL_PAYMENT_DET_1, COL_PAYMENT_DET_2, COL_PAYMENT_DET_3, COL_PAYMENT_DET_4, COL_DELIVERY_MODE, COL_TRANSACTION_TYPE, COL_HUNDI_NUMBER, COL_BOE_TENOR, COL_BOE_TENOR_1, COL_BOE_DATE, COL_BOE_DUE_DATE, COL_BOE_DUE_DATE_DEL_HOLIDAYS, COL_BOE_DUE_DATE_ACTUAL_PREPAY, COL_CHEQUE_NUMBER, COL_DRAWER_CODE, COL_DRWR_COLLECTION_AREA_NAME, COL_DRWR_FULL_NAME, COL_DRWR_LOCATION_CODE, COL_DRWR_ADDRESS_LINE, COL_DRWR_BSNS_AREA_CODE, COL_DRWR_BSNS_AREA_NAME, COL_DRWR_BANK_NAME, COL_DRWE_MICR_CODE, COL_DRWE_BANK_IFC_CODE, COL_ACC_TYPE, COL_DRWE_FULL_NAME, COL_DRWE_ADDR_LINE_1, COL_DRWE_ADDR_LINE_2, COL_DRWE_ADDR_LINE_3, COL_DRWE_ADDR_LINE_4, COL_DRWE_ADDR_LINE_5, COL_DRWE_LOCATION_CODE, COL_DRWE_BSNS_AREA_CODE, COL_DD_PAYABLE_LOCATION, COL_COUNT_OF_ANNXR_REC, COL_CUST_SPECIALS_REF_NO, COL_DRWR_COLLECTION_AREA_CODE, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_DRWR_ACC_NO_OTHER_BANK, COL_DRWE_BMS_AC_NO, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_BENE_ZIPCODE, COL_BOE_AMOUNT, COL_AMOUNT, COL_DR_AC_NO, COL_BENE_MOBILE, COL_BENE_ACC_NO, COL_CLIENT_CODE_DYNAMIC, COL_FILE_NAME, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_CHECK_BOX, COL_COMPANY_CODE, COL_COMPANY_NAME, COL_FISCAL_YEAR, COL_CUSTOMER_CODE, COL_CUSTOMER_NAME, COL_GST_INV_NO, COL_INVOICE_NUMBER, COL_INVOICE_DATE, COL_INV_AMOUNT, COL_GRN_NO, COL_GRN_DATE, COL_PAYMENT_TERM, COL_DUE_DATE, COL_TYPE_OF_TRANSACTION, COL_FINANCE_PARTY, COL_LOAN_REQUEST_TYPE, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED, COL_ID);

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

    public int insert(Connection conn, FgBatchDetail fgbatchdetail) throws SQLException {
        logger.debug("Inserting fgbatchdetail: {}", fgbatchdetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBatchDetailParams(ps, fgbatchdetail);
            ps.executeUpdate();
            return fgbatchdetail.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBatchDetail> fgbatchdetails) throws SQLException {
        if (fgbatchdetails == null || fgbatchdetails.isEmpty())
            return new int[0];
        for (int i = 0; i < fgbatchdetails.size(); i++) {
            if (fgbatchdetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBatchDetail>> batches = chunkList(fgbatchdetails, batchSize);
        int[] totalResults = new int[fgbatchdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBatchDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBatchDetail fgbatchdetail : batch) {
                        setFgBatchDetailParams(ps, fgbatchdetail);
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

    public FgBatchDetail findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBatchDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBatchDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBatchDetail fgbatchdetail) throws SQLException {
        if (fgbatchdetail.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBatchDetailParams(ps, fgbatchdetail);
            ps.setInt(136, fgbatchdetail.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBatchDetail> fgbatchdetails) throws SQLException {
        if (fgbatchdetails == null || fgbatchdetails.isEmpty())
            return new int[0];
        for (FgBatchDetail fgbatchdetail : fgbatchdetails) {
            if (fgbatchdetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgbatchdetail.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBatchDetail>> batches = chunkList(fgbatchdetails, batchSize);
        int[] totalResults = new int[fgbatchdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBatchDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBatchDetail fgbatchdetail : batch) {
                        setFgBatchDetailParams(ps, fgbatchdetail);
                        ps.setInt(136, fgbatchdetail.getID());
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

    private void setFgBatchDetailParams(PreparedStatement ps, FgBatchDetail fgbatchdetail) throws SQLException {
        Integer val1 = fgbatchdetail.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgbatchdetail.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgbatchdetail.getTypeCode());
        ps.setString(4, fgbatchdetail.getSubTypeCode());
        ps.setString(5, fgbatchdetail.getActiveCode());
        ps.setString(6, fgbatchdetail.getStageCode());
        ps.setString(7, fgbatchdetail.getStatusCode());
        ps.setString(8, fgbatchdetail.getCreatedOn());
        java.math.BigDecimal val9 = fgbatchdetail.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgbatchdetail.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgbatchdetail.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgbatchdetail.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgbatchdetail.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgbatchdetail.getTemplate());
        java.math.BigDecimal val15 = fgbatchdetail.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgbatchdetail.getPaymentRefNo());
        ps.setString(17, fgbatchdetail.getPaymentType());
        java.time.LocalDateTime val18 = fgbatchdetail.getPaymentDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val19 = fgbatchdetail.getInstrumentDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        java.math.BigDecimal val20 = fgbatchdetail.getInstrumentNumber();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgbatchdetail.getDrDescription());
        ps.setString(22, fgbatchdetail.getDrRefNo());
        ps.setString(23, fgbatchdetail.getCrRefNo());
        ps.setString(24, fgbatchdetail.getBankCodeIndicator());
        ps.setString(25, fgbatchdetail.getBeneCode());
        ps.setString(26, fgbatchdetail.getBeneName());
        ps.setString(27, fgbatchdetail.getBeneBank());
        ps.setString(28, fgbatchdetail.getBeneBankAndIfscCode());
        ps.setString(29, fgbatchdetail.getLocation());
        ps.setString(30, fgbatchdetail.getPrintLocation());
        ps.setString(31, fgbatchdetail.getBeneAdd1());
        ps.setString(32, fgbatchdetail.getBeneAdd2());
        ps.setString(33, fgbatchdetail.getBeneAdd3());
        ps.setString(34, fgbatchdetail.getBeneAdd4());
        ps.setString(35, fgbatchdetail.getBeneAdd5());
        ps.setString(36, fgbatchdetail.getBeneCity());
        ps.setString(37, fgbatchdetail.getBeneState());
        ps.setString(38, fgbatchdetail.getBeneEmail());
        ps.setString(39, fgbatchdetail.getPaymentDet1());
        ps.setString(40, fgbatchdetail.getPaymentDet2());
        ps.setString(41, fgbatchdetail.getPaymentDet3());
        ps.setString(42, fgbatchdetail.getPaymentDet4());
        ps.setString(43, fgbatchdetail.getDeliveryMode());
        ps.setString(44, fgbatchdetail.getTransactionType());
        ps.setString(45, fgbatchdetail.getHundiNumber());
        ps.setString(46, fgbatchdetail.getBoeTenor());
        ps.setString(47, fgbatchdetail.getBoeTenor1());
        java.time.LocalDateTime val48 = fgbatchdetail.getBoeDate();
        if (val48 != null) {
            ps.setTimestamp(48, java.sql.Timestamp.valueOf(val48));
        } else {
            ps.setNull(48, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val49 = fgbatchdetail.getBoeDueDate();
        if (val49 != null) {
            ps.setTimestamp(49, java.sql.Timestamp.valueOf(val49));
        } else {
            ps.setNull(49, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val50 = fgbatchdetail.getBoeDueDateDelHolidays();
        if (val50 != null) {
            ps.setTimestamp(50, java.sql.Timestamp.valueOf(val50));
        } else {
            ps.setNull(50, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val51 = fgbatchdetail.getBoeDueDateActualPrepay();
        if (val51 != null) {
            ps.setTimestamp(51, java.sql.Timestamp.valueOf(val51));
        } else {
            ps.setNull(51, Types.TIMESTAMP);
        }
        ps.setString(52, fgbatchdetail.getChequeNumber());
        ps.setString(53, fgbatchdetail.getDrawerCode());
        ps.setString(54, fgbatchdetail.getDrwrCollectionAreaName());
        ps.setString(55, fgbatchdetail.getDrwrFullName());
        ps.setString(56, fgbatchdetail.getDrwrLocationCode());
        ps.setString(57, fgbatchdetail.getDrwrAddressLine());
        ps.setString(58, fgbatchdetail.getDrwrBsnsAreaCode());
        ps.setString(59, fgbatchdetail.getDrwrBsnsAreaName());
        ps.setString(60, fgbatchdetail.getDrwrBankName());
        ps.setString(61, fgbatchdetail.getDrweMicrCode());
        ps.setString(62, fgbatchdetail.getDrweBankIfcCode());
        ps.setString(63, fgbatchdetail.getAccType());
        ps.setString(64, fgbatchdetail.getDrweFullName());
        ps.setString(65, fgbatchdetail.getDrweAddrLine1());
        ps.setString(66, fgbatchdetail.getDrweAddrLine2());
        ps.setString(67, fgbatchdetail.getDrweAddrLine3());
        ps.setString(68, fgbatchdetail.getDrweAddrLine4());
        ps.setString(69, fgbatchdetail.getDrweAddrLine5());
        ps.setString(70, fgbatchdetail.getDrweLocationCode());
        ps.setString(71, fgbatchdetail.getDrweBsnsAreaCode());
        ps.setString(72, fgbatchdetail.getDdPayableLocation());
        ps.setString(73, fgbatchdetail.getCountOfAnnxrRec());
        ps.setString(74, fgbatchdetail.getCustSpecialsRefNo());
        ps.setString(75, fgbatchdetail.getDrwrCollectionAreaCode());
        Integer val76 = fgbatchdetail.getUploadRefID();
        if (val76 != null) {
            ps.setInt(76, val76);
        } else {
            ps.setNull(76, Types.INTEGER);
        }
        java.math.BigDecimal val77 = fgbatchdetail.getLineNo();
        if (val77 != null) {
            ps.setBigDecimal(77, val77);
        } else {
            ps.setNull(77, Types.DECIMAL);
        }
        ps.setString(78, fgbatchdetail.getDrwrAccNoOtherBank());
        ps.setString(79, fgbatchdetail.getDrweBmsAcNo());
        Integer val80 = fgbatchdetail.getLayoutTemplateID();
        if (val80 != null) {
            ps.setInt(80, val80);
        } else {
            ps.setNull(80, Types.INTEGER);
        }
        ps.setString(81, fgbatchdetail.getLayoutName());
        java.math.BigDecimal val82 = fgbatchdetail.getBeneZipcode();
        if (val82 != null) {
            ps.setBigDecimal(82, val82);
        } else {
            ps.setNull(82, Types.DECIMAL);
        }
        java.math.BigDecimal val83 = fgbatchdetail.getBoeAmount();
        if (val83 != null) {
            ps.setBigDecimal(83, val83);
        } else {
            ps.setNull(83, Types.DECIMAL);
        }
        java.math.BigDecimal val84 = fgbatchdetail.getAmount();
        if (val84 != null) {
            ps.setBigDecimal(84, val84);
        } else {
            ps.setNull(84, Types.DECIMAL);
        }
        ps.setString(85, fgbatchdetail.getDrAcNo());
        ps.setString(86, fgbatchdetail.getBeneMobile());
        ps.setString(87, fgbatchdetail.getBeneAccNo());
        ps.setString(88, fgbatchdetail.getClientCodeDynamic());
        ps.setString(89, fgbatchdetail.getFileName());
        java.math.BigDecimal val90 = fgbatchdetail.getEquivalentAmount();
        if (val90 != null) {
            ps.setBigDecimal(90, val90);
        } else {
            ps.setNull(90, Types.DECIMAL);
        }
        ps.setString(91, fgbatchdetail.getEquivalentCurrency());
        java.math.BigDecimal val92 = fgbatchdetail.getDisplayAmount();
        if (val92 != null) {
            ps.setBigDecimal(92, val92);
        } else {
            ps.setNull(92, Types.DECIMAL);
        }
        ps.setString(93, fgbatchdetail.getDisplayCurrency());
        java.math.BigDecimal val94 = fgbatchdetail.getAuthEquivalentAmount();
        if (val94 != null) {
            ps.setBigDecimal(94, val94);
        } else {
            ps.setNull(94, Types.DECIMAL);
        }
        ps.setString(95, fgbatchdetail.getAuthEquivalentCurrency());
        java.math.BigDecimal val96 = fgbatchdetail.getDisplayEquivalentAmount();
        if (val96 != null) {
            ps.setBigDecimal(96, val96);
        } else {
            ps.setNull(96, Types.DECIMAL);
        }
        ps.setString(97, fgbatchdetail.getDisplayEquivalentCurrency());
        java.math.BigDecimal val98 = fgbatchdetail.getAuthFxBaseRate();
        if (val98 != null) {
            ps.setBigDecimal(98, val98);
        } else {
            ps.setNull(98, Types.DECIMAL);
        }
        java.math.BigDecimal val99 = fgbatchdetail.getDisplayFxBaseRate();
        if (val99 != null) {
            ps.setBigDecimal(99, val99);
        } else {
            ps.setNull(99, Types.DECIMAL);
        }
        ps.setString(100, fgbatchdetail.getApplicantPartyCode());
        ps.setString(101, fgbatchdetail.getIssuingPartyCode());
        ps.setString(102, fgbatchdetail.getBatchStatus());
        Integer val103 = fgbatchdetail.getBatchRefID();
        if (val103 != null) {
            ps.setInt(103, val103);
        } else {
            ps.setNull(103, Types.INTEGER);
        }
        ps.setString(104, fgbatchdetail.getBatchRemarks());
        ps.setString(105, fgbatchdetail.getTiStatus());
        Integer val106 = fgbatchdetail.getTiBatchRefID();
        if (val106 != null) {
            ps.setInt(106, val106);
        } else {
            ps.setNull(106, Types.INTEGER);
        }
        ps.setString(107, fgbatchdetail.getTiRemarks());
        ps.setString(108, fgbatchdetail.getTnxDisplayStatus());
        Integer val109 = fgbatchdetail.getTnxDisplayBatchID();
        if (val109 != null) {
            ps.setInt(109, val109);
        } else {
            ps.setNull(109, Types.INTEGER);
        }
        ps.setString(110, fgbatchdetail.getTnxDisplayRemarks());
        java.math.BigDecimal val111 = fgbatchdetail.getAdvanceInterest();
        if (val111 != null) {
            ps.setBigDecimal(111, val111);
        } else {
            ps.setNull(111, Types.DECIMAL);
        }
        java.math.BigDecimal val112 = fgbatchdetail.getNetPayment();
        if (val112 != null) {
            ps.setBigDecimal(112, val112);
        } else {
            ps.setNull(112, Types.DECIMAL);
        }
        ps.setString(113, fgbatchdetail.getValueDate());
        ps.setString(114, fgbatchdetail.getUtrNumber());
        java.math.BigDecimal val115 = fgbatchdetail.getCharges();
        if (val115 != null) {
            ps.setBigDecimal(115, val115);
        } else {
            ps.setNull(115, Types.DECIMAL);
        }
        ps.setString(116, fgbatchdetail.getCheckBox());
        ps.setString(117, fgbatchdetail.getCompanyCode());
        ps.setString(118, fgbatchdetail.getCompanyName());
        java.math.BigDecimal val119 = fgbatchdetail.getFiscalYear();
        if (val119 != null) {
            ps.setBigDecimal(119, val119);
        } else {
            ps.setNull(119, Types.DECIMAL);
        }
        ps.setString(120, fgbatchdetail.getCustomerCode());
        ps.setString(121, fgbatchdetail.getCustomerName());
        ps.setString(122, fgbatchdetail.getGstInvNo());
        ps.setString(123, fgbatchdetail.getInvoiceNumber());
        java.time.LocalDateTime val124 = fgbatchdetail.getInvoiceDate();
        if (val124 != null) {
            ps.setTimestamp(124, java.sql.Timestamp.valueOf(val124));
        } else {
            ps.setNull(124, Types.TIMESTAMP);
        }
        java.math.BigDecimal val125 = fgbatchdetail.getInvAmount();
        if (val125 != null) {
            ps.setBigDecimal(125, val125);
        } else {
            ps.setNull(125, Types.DECIMAL);
        }
        ps.setString(126, fgbatchdetail.getGrnNo());
        java.time.LocalDateTime val127 = fgbatchdetail.getGrnDate();
        if (val127 != null) {
            ps.setTimestamp(127, java.sql.Timestamp.valueOf(val127));
        } else {
            ps.setNull(127, Types.TIMESTAMP);
        }
        ps.setString(128, fgbatchdetail.getPaymentTerm());
        java.time.LocalDateTime val129 = fgbatchdetail.getDueDate();
        if (val129 != null) {
            ps.setTimestamp(129, java.sql.Timestamp.valueOf(val129));
        } else {
            ps.setNull(129, Types.TIMESTAMP);
        }
        ps.setString(130, fgbatchdetail.getTypeOfTransaction());
        ps.setString(131, fgbatchdetail.getFinanceParty());
        ps.setString(132, fgbatchdetail.getLoanRequestType());
        java.time.LocalDateTime val133 = fgbatchdetail.getCustomMaturityDate();
        if (val133 != null) {
            ps.setTimestamp(133, java.sql.Timestamp.valueOf(val133));
        } else {
            ps.setNull(133, Types.TIMESTAMP);
        }
        ps.setString(134, fgbatchdetail.getLayoutUuid());
        ps.setString(135, fgbatchdetail.getFinanceRequestStatus());
        ps.setString(136, fgbatchdetail.getFinanceRequested());
    }

    private FgBatchDetail extract(ResultSet rs) throws SQLException {
        FgBatchDetail fgbatchdetail = new FgBatchDetail();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgbatchdetail.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgbatchdetail.setReferenceID(REFERENCE_ID);
        fgbatchdetail.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgbatchdetail.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgbatchdetail.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgbatchdetail.setStageCode(rs.getString(COL_STAGE_CODE));
        fgbatchdetail.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgbatchdetail.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgbatchdetail.setCreatedBy(CREATED_BY);
        fgbatchdetail.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgbatchdetail.setLastUpdatedBy(LAST_UPDATED_BY);
        fgbatchdetail.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgbatchdetail.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgbatchdetail.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgbatchdetail.setIsTemplate(IS_TEMPLATE);
        fgbatchdetail.setPaymentRefNo(rs.getString(COL_PAYMENT_REF_NO));
        fgbatchdetail.setPaymentType(rs.getString(COL_PAYMENT_TYPE));
        Timestamp PAYMENT_DATE = rs.getTimestamp(COL_PAYMENT_DATE);
        if (PAYMENT_DATE != null)
            fgbatchdetail.setPaymentDate(PAYMENT_DATE.toLocalDateTime());
        Timestamp INSTRUMENT_DATE = rs.getTimestamp(COL_INSTRUMENT_DATE);
        if (INSTRUMENT_DATE != null)
            fgbatchdetail.setInstrumentDate(INSTRUMENT_DATE.toLocalDateTime());
        java.math.BigDecimal INSTRUMENT_NUMBER = rs.getObject(COL_INSTRUMENT_NUMBER, java.math.BigDecimal.class);
        fgbatchdetail.setInstrumentNumber(INSTRUMENT_NUMBER);
        fgbatchdetail.setDrDescription(rs.getString(COL_DR_DESCRIPTION));
        fgbatchdetail.setDrRefNo(rs.getString(COL_DR_REF_NO));
        fgbatchdetail.setCrRefNo(rs.getString(COL_CR_REF_NO));
        fgbatchdetail.setBankCodeIndicator(rs.getString(COL_BANK_CODE_INDICATOR));
        fgbatchdetail.setBeneCode(rs.getString(COL_BENE_CODE));
        fgbatchdetail.setBeneName(rs.getString(COL_BENE_NAME));
        fgbatchdetail.setBeneBank(rs.getString(COL_BENE_BANK));
        fgbatchdetail.setBeneBankAndIfscCode(rs.getString(COL_BENE_BANK_AND_IFSC_CODE));
        fgbatchdetail.setLocation(rs.getString(COL_LOCATION));
        fgbatchdetail.setPrintLocation(rs.getString(COL_PRINT_LOCATION));
        fgbatchdetail.setBeneAdd1(rs.getString(COL_BENE_ADD_1));
        fgbatchdetail.setBeneAdd2(rs.getString(COL_BENE_ADD_2));
        fgbatchdetail.setBeneAdd3(rs.getString(COL_BENE_ADD_3));
        fgbatchdetail.setBeneAdd4(rs.getString(COL_BENE_ADD_4));
        fgbatchdetail.setBeneAdd5(rs.getString(COL_BENE_ADD_5));
        fgbatchdetail.setBeneCity(rs.getString(COL_BENE_CITY));
        fgbatchdetail.setBeneState(rs.getString(COL_BENE_STATE));
        fgbatchdetail.setBeneEmail(rs.getString(COL_BENE_EMAIL));
        fgbatchdetail.setPaymentDet1(rs.getString(COL_PAYMENT_DET_1));
        fgbatchdetail.setPaymentDet2(rs.getString(COL_PAYMENT_DET_2));
        fgbatchdetail.setPaymentDet3(rs.getString(COL_PAYMENT_DET_3));
        fgbatchdetail.setPaymentDet4(rs.getString(COL_PAYMENT_DET_4));
        fgbatchdetail.setDeliveryMode(rs.getString(COL_DELIVERY_MODE));
        fgbatchdetail.setTransactionType(rs.getString(COL_TRANSACTION_TYPE));
        fgbatchdetail.setHundiNumber(rs.getString(COL_HUNDI_NUMBER));
        fgbatchdetail.setBoeTenor(rs.getString(COL_BOE_TENOR));
        fgbatchdetail.setBoeTenor1(rs.getString(COL_BOE_TENOR_1));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgbatchdetail.setBoeDate(BOE_DATE.toLocalDateTime());
        Timestamp BOE_DUE_DATE = rs.getTimestamp(COL_BOE_DUE_DATE);
        if (BOE_DUE_DATE != null)
            fgbatchdetail.setBoeDueDate(BOE_DUE_DATE.toLocalDateTime());
        Timestamp BOE_DUE_DATE_DEL_HOLIDAYS = rs.getTimestamp(COL_BOE_DUE_DATE_DEL_HOLIDAYS);
        if (BOE_DUE_DATE_DEL_HOLIDAYS != null)
            fgbatchdetail.setBoeDueDateDelHolidays(BOE_DUE_DATE_DEL_HOLIDAYS.toLocalDateTime());
        Timestamp BOE_DUE_DATE_ACTUAL_PREPAY = rs.getTimestamp(COL_BOE_DUE_DATE_ACTUAL_PREPAY);
        if (BOE_DUE_DATE_ACTUAL_PREPAY != null)
            fgbatchdetail.setBoeDueDateActualPrepay(BOE_DUE_DATE_ACTUAL_PREPAY.toLocalDateTime());
        fgbatchdetail.setChequeNumber(rs.getString(COL_CHEQUE_NUMBER));
        fgbatchdetail.setDrawerCode(rs.getString(COL_DRAWER_CODE));
        fgbatchdetail.setDrwrCollectionAreaName(rs.getString(COL_DRWR_COLLECTION_AREA_NAME));
        fgbatchdetail.setDrwrFullName(rs.getString(COL_DRWR_FULL_NAME));
        fgbatchdetail.setDrwrLocationCode(rs.getString(COL_DRWR_LOCATION_CODE));
        fgbatchdetail.setDrwrAddressLine(rs.getString(COL_DRWR_ADDRESS_LINE));
        fgbatchdetail.setDrwrBsnsAreaCode(rs.getString(COL_DRWR_BSNS_AREA_CODE));
        fgbatchdetail.setDrwrBsnsAreaName(rs.getString(COL_DRWR_BSNS_AREA_NAME));
        fgbatchdetail.setDrwrBankName(rs.getString(COL_DRWR_BANK_NAME));
        fgbatchdetail.setDrweMicrCode(rs.getString(COL_DRWE_MICR_CODE));
        fgbatchdetail.setDrweBankIfcCode(rs.getString(COL_DRWE_BANK_IFC_CODE));
        fgbatchdetail.setAccType(rs.getString(COL_ACC_TYPE));
        fgbatchdetail.setDrweFullName(rs.getString(COL_DRWE_FULL_NAME));
        fgbatchdetail.setDrweAddrLine1(rs.getString(COL_DRWE_ADDR_LINE_1));
        fgbatchdetail.setDrweAddrLine2(rs.getString(COL_DRWE_ADDR_LINE_2));
        fgbatchdetail.setDrweAddrLine3(rs.getString(COL_DRWE_ADDR_LINE_3));
        fgbatchdetail.setDrweAddrLine4(rs.getString(COL_DRWE_ADDR_LINE_4));
        fgbatchdetail.setDrweAddrLine5(rs.getString(COL_DRWE_ADDR_LINE_5));
        fgbatchdetail.setDrweLocationCode(rs.getString(COL_DRWE_LOCATION_CODE));
        fgbatchdetail.setDrweBsnsAreaCode(rs.getString(COL_DRWE_BSNS_AREA_CODE));
        fgbatchdetail.setDdPayableLocation(rs.getString(COL_DD_PAYABLE_LOCATION));
        fgbatchdetail.setCountOfAnnxrRec(rs.getString(COL_COUNT_OF_ANNXR_REC));
        fgbatchdetail.setCustSpecialsRefNo(rs.getString(COL_CUST_SPECIALS_REF_NO));
        fgbatchdetail.setDrwrCollectionAreaCode(rs.getString(COL_DRWR_COLLECTION_AREA_CODE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgbatchdetail.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgbatchdetail.setLineNo(LINE_NO);
        fgbatchdetail.setDrwrAccNoOtherBank(rs.getString(COL_DRWR_ACC_NO_OTHER_BANK));
        fgbatchdetail.setDrweBmsAcNo(rs.getString(COL_DRWE_BMS_AC_NO));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgbatchdetail.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fgbatchdetail.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        java.math.BigDecimal BENE_ZIPCODE = rs.getObject(COL_BENE_ZIPCODE, java.math.BigDecimal.class);
        fgbatchdetail.setBeneZipcode(BENE_ZIPCODE);
        java.math.BigDecimal BOE_AMOUNT = rs.getObject(COL_BOE_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setBoeAmount(BOE_AMOUNT);
        java.math.BigDecimal AMOUNT = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setAmount(AMOUNT);
        fgbatchdetail.setDrAcNo(rs.getString(COL_DR_AC_NO));
        fgbatchdetail.setBeneMobile(rs.getString(COL_BENE_MOBILE));
        fgbatchdetail.setBeneAccNo(rs.getString(COL_BENE_ACC_NO));
        fgbatchdetail.setClientCodeDynamic(rs.getString(COL_CLIENT_CODE_DYNAMIC));
        fgbatchdetail.setFileName(rs.getString(COL_FILE_NAME));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgbatchdetail.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setDisplayAmount(DISPLAY_AMOUNT);
        fgbatchdetail.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgbatchdetail.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgbatchdetail.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgbatchdetail.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgbatchdetail.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgbatchdetail.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgbatchdetail.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgbatchdetail.setBatchStatus(rs.getString(COL_BATCH_STATUS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgbatchdetail.setBatchRefID(BATCH_REF_ID);
        fgbatchdetail.setBatchRemarks(rs.getString(COL_BATCH_REMARKS));
        fgbatchdetail.setTiStatus(rs.getString(COL_TI_STATUS));
        Integer TI_BATCH_REF_ID = rs.getObject(COL_TI_BATCH_REF_ID, Integer.class);
        fgbatchdetail.setTiBatchRefID(TI_BATCH_REF_ID);
        fgbatchdetail.setTiRemarks(rs.getString(COL_TI_REMARKS));
        fgbatchdetail.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        Integer TNX_DISPLAY_BATCH_ID = rs.getObject(COL_TNX_DISPLAY_BATCH_ID, Integer.class);
        fgbatchdetail.setTnxDisplayBatchID(TNX_DISPLAY_BATCH_ID);
        fgbatchdetail.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        fgbatchdetail.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        fgbatchdetail.setNetPayment(NET_PAYMENT);
        fgbatchdetail.setValueDate(rs.getString(COL_VALUE_DATE));
        fgbatchdetail.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        fgbatchdetail.setCharges(CHARGES);
        fgbatchdetail.setCheckBox(rs.getString(COL_CHECK_BOX));
        fgbatchdetail.setCompanyCode(rs.getString(COL_COMPANY_CODE));
        fgbatchdetail.setCompanyName(rs.getString(COL_COMPANY_NAME));
        java.math.BigDecimal FISCAL_YEAR = rs.getObject(COL_FISCAL_YEAR, java.math.BigDecimal.class);
        fgbatchdetail.setFiscalYear(FISCAL_YEAR);
        fgbatchdetail.setCustomerCode(rs.getString(COL_CUSTOMER_CODE));
        fgbatchdetail.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        fgbatchdetail.setGstInvNo(rs.getString(COL_GST_INV_NO));
        fgbatchdetail.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fgbatchdetail.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        java.math.BigDecimal INV_AMOUNT = rs.getObject(COL_INV_AMOUNT, java.math.BigDecimal.class);
        fgbatchdetail.setInvAmount(INV_AMOUNT);
        fgbatchdetail.setGrnNo(rs.getString(COL_GRN_NO));
        Timestamp GRN_DATE = rs.getTimestamp(COL_GRN_DATE);
        if (GRN_DATE != null)
            fgbatchdetail.setGrnDate(GRN_DATE.toLocalDateTime());
        fgbatchdetail.setPaymentTerm(rs.getString(COL_PAYMENT_TERM));
        Timestamp DUE_DATE = rs.getTimestamp(COL_DUE_DATE);
        if (DUE_DATE != null)
            fgbatchdetail.setDueDate(DUE_DATE.toLocalDateTime());
        fgbatchdetail.setTypeOfTransaction(rs.getString(COL_TYPE_OF_TRANSACTION));
        fgbatchdetail.setFinanceParty(rs.getString(COL_FINANCE_PARTY));
        fgbatchdetail.setLoanRequestType(rs.getString(COL_LOAN_REQUEST_TYPE));
        Timestamp CUSTOM_MATURITY_DATE = rs.getTimestamp(COL_CUSTOM_MATURITY_DATE);
        if (CUSTOM_MATURITY_DATE != null)
            fgbatchdetail.setCustomMaturityDate(CUSTOM_MATURITY_DATE.toLocalDateTime());
        fgbatchdetail.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        fgbatchdetail.setFinanceRequestStatus(rs.getString(COL_FINANCE_REQUEST_STATUS));
        fgbatchdetail.setFinanceRequested(rs.getString(COL_FINANCE_REQUESTED));
        return fgbatchdetail;
    }
}
