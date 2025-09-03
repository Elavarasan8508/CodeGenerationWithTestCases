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

public class JdbcFgTrdDiVersionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdDiVersionDao.class);

    private static final String TABLE = "FG_TRD_DI_VERSION";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_IR_NOSTRO_NUMBER = "IR_NOSTRO_NUMBER";

    private static final String COL_IR_VALUE_DATE = "IR_VALUE_DATE";

    private static final String COL_IR_CUR_CODE = "IR_CUR_CODE";

    private static final String COL_IR_AMT = "IR_AMT";

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_AMT = "AMT";

    private static final String COL_TRADE_DSP_AMT = "TRADE_DSP_AMT";

    private static final String COL_FUNDS_DSP_AMT = "FUNDS_DSP_AMT";

    private static final String COL_TO_BE_DISPOSED_AMT = "TO_BE_DISPOSED_AMT";

    private static final String COL_BANK_TO_BE_BOOK = "BANK_TO_BE_BOOK";

    private static final String COL_BOOK_NEW_DEAL = "BOOK_NEW_DEAL";

    private static final String COL_PROVIDED_TRD_DSP_AMT = "PROVIDED_TRD_DSP_AMT";

    private static final String COL_TO_BE_DSP_TRD_AMT = "TO_BE_DSP_TRD_AMT";

    private static final String COL_OFC_MAX_DSP_AMT = "OFC_MAX_DSP_AMT";

    private static final String COL_OFC_DSP_AMT = "OFC_DSP_AMT";

    private static final String COL_ELC_MAX_DSP_AMT = "ELC_MAX_DSP_AMT";

    private static final String COL_ELC_DSP_AMT = "ELC_DSP_AMT";

    private static final String COL_PROVIDED_FUND_DSP_AMT = "PROVIDED_FUND_DSP_AMT";

    private static final String COL_TO_BE_DSP_FUND_AMT = "TO_BE_DSP_FUND_AMT";

    private static final String COL_POST_SHIP_DSP_AMT = "POST_SHIP_DSP_AMT";

    private static final String COL_PRE_SHIP_MAX_DSP_AMT = "PRE_SHIP_MAX_DSP_AMT";

    private static final String COL_PRE_SHIP_DSP_AMT = "PRE_SHIP_DSP_AMT";

    private static final String COL_PRE_REM_AMT_ACC_NO = "PRE_REM_AMT_ACC_NO";

    private static final String COL_ACC_MAX_DSP_AMT = "ACC_MAX_DSP_AMT";

    private static final String COL_ACC_DSP_AMT = "ACC_DSP_AMT";

    private static final String COL_REM_AMT_ACC_NO = "REM_AMT_ACC_NO";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ISSUING_PARTY = "ISSUING_PARTY";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_CUST_REF_ID = "CUST_REF_ID";

    private static final String COL_DETAILS_CHARGE = "DETAILS_CHARGE";

    private static final String COL_IR_REM_INFO = "IR_REM_INFO";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_SWIFT_MSG_TYPE = "SWIFT_MSG_TYPE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_CHECKBOX_8 = "CHECKBOX_8";

    private static final String COL_REMITTER_ADDRESS_LINE_2 = "REMITTER_ADDRESS_LINE_2";

    private static final String COL_REMITTER_ADDRESS_LINE_1 = "REMITTER_ADDRESS_LINE_1";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_1 = "BENEFICIARY_ADDRESS_LINE_1";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_2 = "BENEFICIARY_ADDRESS_LINE_2";

    private static final String COL_BO_REF_ID = "BO_REF_ID";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_TASK_ID = "TASK_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_STEPPER_COMPLETION_PERCENTAGE = "STEPPER_COMPLETION_PERCENTAGE";

    private static final String COL_LTEA_INDICATOR = "LTEA_INDICATOR";

    private static final String COL_GENERAL_DETAILS = "GENERAL_DETAILS";

    private static final String COL_DISPOSAL_INSTRUCTION = "DISPOSAL_INSTRUCTION";

    private static final String COL_TRADE_DISPOSAL = "TRADE_DISPOSAL";

    private static final String COL_FUNDS_DISPOSAL = "FUNDS_DISPOSAL";

    private static final String COL_DECLARATION = "DECLARATION";

    private static final String COL_ATTACHMENTS = "ATTACHMENTS";

    private static final String COL_PREVIEW = "PREVIEW";

    private static final String COL_IR_ORDR_INSTITUTION = "IR_ORDR_INSTITUTION";

    private static final String COL_COPY_FROM = "COPY_FROM";

    private static final String COL_DEBIT_ACC_NO = "DEBIT_ACC_NO";

    private static final String COL_MIS_PRODUCT = "MIS_PRODUCT";

    private static final String COL_XAR_PRODUCT = "XAR_PRODUCT";

    private static final String COL_PRE_REM_AMT_ACC_NO_CB = "PRE_REM_AMT_ACC_NO_CB";

    private static final String COL_SENDER = "SENDER";

    private static final String COL_ORD_ACCNO = "ORD_ACCNO";

    private static final String COL_ORD_NAME = "ORD_NAME";

    private static final String COL_ORD_ADDR1 = "ORD_ADDR1";

    private static final String COL_ORD_ADDR2 = "ORD_ADDR2";

    private static final String COL_ORD_ADDR3 = "ORD_ADDR3";

    private static final String COL_BENEF_NO = "BENEF_NO";

    private static final String COL_BENEF_NAME = "BENEF_NAME";

    private static final String COL_BENEF_ADDR1 = "BENEF_ADDR1";

    private static final String COL_BENEF_ADDR2 = "BENEF_ADDR2";

    private static final String COL_BENEF_ADDR3 = "BENEF_ADDR3";

    private static final String COL_SWIFT_MESSAGE_DATA = "SWIFT_MESSAGE_DATA";

    private static final String COL_TI_MASTER_REF = "TI_MASTER_REF";

    private static final String COL_PRE_REMT_ACC_NO_CUR = "PRE_REMT_ACC_NO_CUR";

    private static final String COL_REMT_ACC_NO_CUR = "REMT_ACC_NO_CUR";

    private static final String COL_DEBIT_ACC_NO_CUR = "DEBIT_ACC_NO_CUR";

    private static final String COL_ACK_MESSAGE = "ACK_MESSAGE";

    private static final String COL_ACK_STATUS = "ACK_STATUS";

    private static final String COL_FG_TRD_PURPOSE_CODE = "FG_TRD_PURPOSE_CODE";

    private static final String COL_FG_TRD_ACCOUNTS = "FG_TRD_ACCOUNTS";

    private static final String COL_FG_TRD_FX_RATE = "FG_TRD_FX_RATE";

    private static final String COL_FG_TRD_POST_LOANS = "FG_TRD_POST_LOANS";

    private static final String COL_FG_TRD_PRE_LOANS = "FG_TRD_PRE_LOANS";

    private static final String COL_FG_TRD_LC = "FG_TRD_LC";

    private static final String COL_FG_TRD_APPL_FX_RATE = "FG_TRD_APPL_FX_RATE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IR_NOSTRO_NUMBER, COL_IR_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_CUR_CODE, COL_AMT, COL_TRADE_DSP_AMT, COL_FUNDS_DSP_AMT, COL_TO_BE_DISPOSED_AMT, COL_BANK_TO_BE_BOOK, COL_BOOK_NEW_DEAL, COL_PROVIDED_TRD_DSP_AMT, COL_TO_BE_DSP_TRD_AMT, COL_OFC_MAX_DSP_AMT, COL_OFC_DSP_AMT, COL_ELC_MAX_DSP_AMT, COL_ELC_DSP_AMT, COL_PROVIDED_FUND_DSP_AMT, COL_TO_BE_DSP_FUND_AMT, COL_POST_SHIP_DSP_AMT, COL_PRE_SHIP_MAX_DSP_AMT, COL_PRE_SHIP_DSP_AMT, COL_PRE_REM_AMT_ACC_NO, COL_ACC_MAX_DSP_AMT, COL_ACC_DSP_AMT, COL_REM_AMT_ACC_NO, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_IR_REFERENCE_ID, COL_CUST_REF_ID, COL_DETAILS_CHARGE, COL_IR_REM_INFO, COL_REMITTER_NAME, COL_BENEFICIARY_NAME, COL_SWIFT_MSG_TYPE, COL_PROCESS_ID, COL_STAGE_CODE, COL_CHECKBOX_8, COL_REMITTER_ADDRESS_LINE_2, COL_REMITTER_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_BO_REF_ID, COL_PRODUCT_STATUS, COL_TASK_ID, COL_DMS_EVENT_ID, COL_STEPPER_COMPLETION_PERCENTAGE, COL_LTEA_INDICATOR, COL_GENERAL_DETAILS, COL_DISPOSAL_INSTRUCTION, COL_TRADE_DISPOSAL, COL_FUNDS_DISPOSAL, COL_DECLARATION, COL_ATTACHMENTS, COL_PREVIEW, COL_IR_ORDR_INSTITUTION, COL_COPY_FROM, COL_DEBIT_ACC_NO, COL_MIS_PRODUCT, COL_XAR_PRODUCT, COL_PRE_REM_AMT_ACC_NO_CB, COL_SENDER, COL_ORD_ACCNO, COL_ORD_NAME, COL_ORD_ADDR1, COL_ORD_ADDR2, COL_ORD_ADDR3, COL_BENEF_NO, COL_BENEF_NAME, COL_BENEF_ADDR1, COL_BENEF_ADDR2, COL_BENEF_ADDR3, COL_SWIFT_MESSAGE_DATA, COL_TI_MASTER_REF, COL_PRE_REMT_ACC_NO_CUR, COL_REMT_ACC_NO_CUR, COL_DEBIT_ACC_NO_CUR, COL_ACK_MESSAGE, COL_ACK_STATUS, COL_FG_TRD_PURPOSE_CODE, COL_FG_TRD_ACCOUNTS, COL_FG_TRD_FX_RATE, COL_FG_TRD_POST_LOANS, COL_FG_TRD_PRE_LOANS, COL_FG_TRD_LC, COL_FG_TRD_APPL_FX_RATE, COL_VERSION_ID, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CUST_REF_ID, DETAILS_CHARGE, IR_REM_INFO, REMITTER_NAME, BENEFICIARY_NAME, SWIFT_MSG_TYPE, PROCESS_ID, STAGE_CODE, CHECKBOX_8, REMITTER_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DMS_EVENT_ID, STEPPER_COMPLETION_PERCENTAGE, LTEA_INDICATOR, GENERAL_DETAILS, DISPOSAL_INSTRUCTION, TRADE_DISPOSAL, FUNDS_DISPOSAL, DECLARATION, ATTACHMENTS, PREVIEW, IR_ORDR_INSTITUTION, COPY_FROM, DEBIT_ACC_NO, MIS_PRODUCT, XAR_PRODUCT, PRE_REM_AMT_ACC_NO_CB, SENDER, ORD_ACCNO, ORD_NAME, ORD_ADDR1, ORD_ADDR2, ORD_ADDR3, BENEF_NO, BENEF_NAME, BENEF_ADDR1, BENEF_ADDR2, BENEF_ADDR3, SWIFT_MESSAGE_DATA, TI_MASTER_REF, PRE_REMT_ACC_NO_CUR, REMT_ACC_NO_CUR, DEBIT_ACC_NO_CUR, ACK_MESSAGE, ACK_STATUS, FG_TRD_PURPOSE_CODE, FG_TRD_ACCOUNTS, FG_TRD_FX_RATE, FG_TRD_POST_LOANS, FG_TRD_PRE_LOANS, FG_TRD_LC, FG_TRD_APPL_FX_RATE, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CUST_REF_ID, DETAILS_CHARGE, IR_REM_INFO, REMITTER_NAME, BENEFICIARY_NAME, SWIFT_MSG_TYPE, PROCESS_ID, STAGE_CODE, CHECKBOX_8, REMITTER_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DMS_EVENT_ID, STEPPER_COMPLETION_PERCENTAGE, LTEA_INDICATOR, GENERAL_DETAILS, DISPOSAL_INSTRUCTION, TRADE_DISPOSAL, FUNDS_DISPOSAL, DECLARATION, ATTACHMENTS, PREVIEW, IR_ORDR_INSTITUTION, COPY_FROM, DEBIT_ACC_NO, MIS_PRODUCT, XAR_PRODUCT, PRE_REM_AMT_ACC_NO_CB, SENDER, ORD_ACCNO, ORD_NAME, ORD_ADDR1, ORD_ADDR2, ORD_ADDR3, BENEF_NO, BENEF_NAME, BENEF_ADDR1, BENEF_ADDR2, BENEF_ADDR3, SWIFT_MESSAGE_DATA, TI_MASTER_REF, PRE_REMT_ACC_NO_CUR, REMT_ACC_NO_CUR, DEBIT_ACC_NO_CUR, ACK_MESSAGE, ACK_STATUS, FG_TRD_PURPOSE_CODE, FG_TRD_ACCOUNTS, FG_TRD_FX_RATE, FG_TRD_POST_LOANS, FG_TRD_PRE_LOANS, FG_TRD_LC, FG_TRD_APPL_FX_RATE, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IR_NOSTRO_NUMBER, COL_IR_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_CUR_CODE, COL_AMT, COL_TRADE_DSP_AMT, COL_FUNDS_DSP_AMT, COL_TO_BE_DISPOSED_AMT, COL_BANK_TO_BE_BOOK, COL_BOOK_NEW_DEAL, COL_PROVIDED_TRD_DSP_AMT, COL_TO_BE_DSP_TRD_AMT, COL_OFC_MAX_DSP_AMT, COL_OFC_DSP_AMT, COL_ELC_MAX_DSP_AMT, COL_ELC_DSP_AMT, COL_PROVIDED_FUND_DSP_AMT, COL_TO_BE_DSP_FUND_AMT, COL_POST_SHIP_DSP_AMT, COL_PRE_SHIP_MAX_DSP_AMT, COL_PRE_SHIP_DSP_AMT, COL_PRE_REM_AMT_ACC_NO, COL_ACC_MAX_DSP_AMT, COL_ACC_DSP_AMT, COL_REM_AMT_ACC_NO, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_IR_REFERENCE_ID, COL_CUST_REF_ID, COL_DETAILS_CHARGE, COL_IR_REM_INFO, COL_REMITTER_NAME, COL_BENEFICIARY_NAME, COL_SWIFT_MSG_TYPE, COL_PROCESS_ID, COL_STAGE_CODE, COL_CHECKBOX_8, COL_REMITTER_ADDRESS_LINE_2, COL_REMITTER_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_BO_REF_ID, COL_PRODUCT_STATUS, COL_TASK_ID, COL_DMS_EVENT_ID, COL_STEPPER_COMPLETION_PERCENTAGE, COL_LTEA_INDICATOR, COL_GENERAL_DETAILS, COL_DISPOSAL_INSTRUCTION, COL_TRADE_DISPOSAL, COL_FUNDS_DISPOSAL, COL_DECLARATION, COL_ATTACHMENTS, COL_PREVIEW, COL_IR_ORDR_INSTITUTION, COL_COPY_FROM, COL_DEBIT_ACC_NO, COL_MIS_PRODUCT, COL_XAR_PRODUCT, COL_PRE_REM_AMT_ACC_NO_CB, COL_SENDER, COL_ORD_ACCNO, COL_ORD_NAME, COL_ORD_ADDR1, COL_ORD_ADDR2, COL_ORD_ADDR3, COL_BENEF_NO, COL_BENEF_NAME, COL_BENEF_ADDR1, COL_BENEF_ADDR2, COL_BENEF_ADDR3, COL_SWIFT_MESSAGE_DATA, COL_TI_MASTER_REF, COL_PRE_REMT_ACC_NO_CUR, COL_REMT_ACC_NO_CUR, COL_DEBIT_ACC_NO_CUR, COL_ACK_MESSAGE, COL_ACK_STATUS, COL_FG_TRD_PURPOSE_CODE, COL_FG_TRD_ACCOUNTS, COL_FG_TRD_FX_RATE, COL_FG_TRD_POST_LOANS, COL_FG_TRD_PRE_LOANS, COL_FG_TRD_LC, COL_FG_TRD_APPL_FX_RATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, FgTrdDiVersion fgtrddiversion) throws SQLException {
        logger.debug("Inserting fgtrddiversion: {}", fgtrddiversion);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdDiVersionParams(ps, fgtrddiversion);
            ps.executeUpdate();
            return fgtrddiversion.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdDiVersion> fgtrddiversions) throws SQLException {
        if (fgtrddiversions == null || fgtrddiversions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrddiversions.size(); i++) {
            if (fgtrddiversions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdDiVersion>> batches = chunkList(fgtrddiversions, batchSize);
        int[] totalResults = new int[fgtrddiversions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdDiVersion> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdDiVersion fgtrddiversion : batch) {
                        setFgTrdDiVersionParams(ps, fgtrddiversion);
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

    public FgTrdDiVersion findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdDiVersion> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdDiVersion> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdDiVersion fgtrddiversion) throws SQLException {
        if (fgtrddiversion.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdDiVersionParams(ps, fgtrddiversion);
            ps.setInt(102, fgtrddiversion.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdDiVersion> fgtrddiversions) throws SQLException {
        if (fgtrddiversions == null || fgtrddiversions.isEmpty())
            return new int[0];
        for (FgTrdDiVersion fgtrddiversion : fgtrddiversions) {
            if (fgtrddiversion == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrddiversion.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdDiVersion>> batches = chunkList(fgtrddiversions, batchSize);
        int[] totalResults = new int[fgtrddiversions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdDiVersion> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdDiVersion fgtrddiversion : batch) {
                        setFgTrdDiVersionParams(ps, fgtrddiversion);
                        ps.setInt(102, fgtrddiversion.getID());
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

    private void setFgTrdDiVersionParams(PreparedStatement ps, FgTrdDiVersion fgtrddiversion) throws SQLException {
        Integer val1 = fgtrddiversion.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrddiversion.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrddiversion.getTypeCode());
        ps.setString(4, fgtrddiversion.getSubTypeCode());
        ps.setString(5, fgtrddiversion.getActiveCode());
        ps.setString(6, fgtrddiversion.getStatusCode());
        ps.setString(7, fgtrddiversion.getCreatedOn());
        java.math.BigDecimal val8 = fgtrddiversion.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgtrddiversion.getLastUpdatedOn());
        java.math.BigDecimal val10 = fgtrddiversion.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtrddiversion.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgtrddiversion.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtrddiversion.getTemplate());
        java.math.BigDecimal val14 = fgtrddiversion.getIsTemplate();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtrddiversion.getIrNostroNumber());
        java.time.LocalDateTime val16 = fgtrddiversion.getIrValueDate();
        if (val16 != null) {
            ps.setTimestamp(16, java.sql.Timestamp.valueOf(val16));
        } else {
            ps.setNull(16, Types.TIMESTAMP);
        }
        ps.setString(17, fgtrddiversion.getIrCurCode());
        java.math.BigDecimal val18 = fgtrddiversion.getIrAmt();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtrddiversion.getCurCode());
        java.math.BigDecimal val20 = fgtrddiversion.getAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrddiversion.getTradeDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrddiversion.getFundsDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtrddiversion.getToBeDisposedAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgtrddiversion.getBankToBeBook();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgtrddiversion.getBookNewDeal();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgtrddiversion.getProvidedTrdDspAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgtrddiversion.getToBeDspTrdAmt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgtrddiversion.getOfcMaxDspAmt();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = fgtrddiversion.getOfcDspAmt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = fgtrddiversion.getElcMaxDspAmt();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = fgtrddiversion.getElcDspAmt();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = fgtrddiversion.getProvidedFundDspAmt();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = fgtrddiversion.getToBeDspFundAmt();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgtrddiversion.getPostShipDspAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgtrddiversion.getPreShipMaxDspAmt();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.math.BigDecimal val36 = fgtrddiversion.getPreShipDspAmt();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, fgtrddiversion.getPreRemAmtAccNo());
        java.math.BigDecimal val38 = fgtrddiversion.getAccMaxDspAmt();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = fgtrddiversion.getAccDspAmt();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgtrddiversion.getRemAmtAccNo());
        ps.setString(41, fgtrddiversion.getApplicantParty());
        ps.setString(42, fgtrddiversion.getIssuingParty());
        Integer val43 = fgtrddiversion.getIrReferenceID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        Integer val44 = fgtrddiversion.getCustRefID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        ps.setString(45, fgtrddiversion.getDetailsCharge());
        ps.setString(46, fgtrddiversion.getIrRemInfo());
        ps.setString(47, fgtrddiversion.getRemitterName());
        ps.setString(48, fgtrddiversion.getBeneficiaryName());
        ps.setString(49, fgtrddiversion.getSwiftMsgType());
        Integer val50 = fgtrddiversion.getProcessID();
        if (val50 != null) {
            ps.setInt(50, val50);
        } else {
            ps.setNull(50, Types.INTEGER);
        }
        ps.setString(51, fgtrddiversion.getStageCode());
        java.math.BigDecimal val52 = fgtrddiversion.getCheckbox8();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        ps.setString(53, fgtrddiversion.getRemitterAddressLine2());
        ps.setString(54, fgtrddiversion.getRemitterAddressLine1());
        ps.setString(55, fgtrddiversion.getBeneficiaryAddressLine1());
        ps.setString(56, fgtrddiversion.getBeneficiaryAddressLine2());
        Integer val57 = fgtrddiversion.getBoRefID();
        if (val57 != null) {
            ps.setInt(57, val57);
        } else {
            ps.setNull(57, Types.INTEGER);
        }
        ps.setString(58, fgtrddiversion.getProductStatus());
        Integer val59 = fgtrddiversion.getTaskID();
        if (val59 != null) {
            ps.setInt(59, val59);
        } else {
            ps.setNull(59, Types.INTEGER);
        }
        Integer val60 = fgtrddiversion.getDmsEventID();
        if (val60 != null) {
            ps.setInt(60, val60);
        } else {
            ps.setNull(60, Types.INTEGER);
        }
        java.math.BigDecimal val61 = fgtrddiversion.getStepperCompletionPercentage();
        if (val61 != null) {
            ps.setBigDecimal(61, val61);
        } else {
            ps.setNull(61, Types.DECIMAL);
        }
        java.math.BigDecimal val62 = fgtrddiversion.getLteaIndicator();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        ps.setString(63, fgtrddiversion.getGeneralDetails());
        ps.setString(64, fgtrddiversion.getDisposalInstruction());
        ps.setString(65, fgtrddiversion.getTradeDisposal());
        ps.setString(66, fgtrddiversion.getFundsDisposal());
        ps.setString(67, fgtrddiversion.getDeclaration());
        ps.setString(68, fgtrddiversion.getAttachments());
        ps.setString(69, fgtrddiversion.getPreview());
        ps.setString(70, fgtrddiversion.getIrOrdrInstitution());
        ps.setString(71, fgtrddiversion.getCopyFrom());
        ps.setString(72, fgtrddiversion.getDebitAccNo());
        java.math.BigDecimal val73 = fgtrddiversion.getMisProduct();
        if (val73 != null) {
            ps.setBigDecimal(73, val73);
        } else {
            ps.setNull(73, Types.DECIMAL);
        }
        java.math.BigDecimal val74 = fgtrddiversion.getXarProduct();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        java.math.BigDecimal val75 = fgtrddiversion.getPreRemAmtAccNoCb();
        if (val75 != null) {
            ps.setBigDecimal(75, val75);
        } else {
            ps.setNull(75, Types.DECIMAL);
        }
        ps.setString(76, fgtrddiversion.getSender());
        ps.setString(77, fgtrddiversion.getOrdAccno());
        ps.setString(78, fgtrddiversion.getOrdName());
        ps.setString(79, fgtrddiversion.getOrdAddr1());
        ps.setString(80, fgtrddiversion.getOrdAddr2());
        ps.setString(81, fgtrddiversion.getOrdAddr3());
        ps.setString(82, fgtrddiversion.getBenefNo());
        ps.setString(83, fgtrddiversion.getBenefName());
        ps.setString(84, fgtrddiversion.getBenefAddr1());
        ps.setString(85, fgtrddiversion.getBenefAddr2());
        ps.setString(86, fgtrddiversion.getBenefAddr3());
        ps.setString(87, fgtrddiversion.getSwiftMessageData());
        ps.setString(88, fgtrddiversion.getTiMasterRef());
        ps.setString(89, fgtrddiversion.getPreRemtAccNoCur());
        ps.setString(90, fgtrddiversion.getRemtAccNoCur());
        ps.setString(91, fgtrddiversion.getDebitAccNoCur());
        ps.setString(92, fgtrddiversion.getAckMessage());
        ps.setString(93, fgtrddiversion.getAckStatus());
        ps.setString(94, fgtrddiversion.getFgTrdPurposeCode());
        ps.setString(95, fgtrddiversion.getFgTrdAccounts());
        java.math.BigDecimal val96 = fgtrddiversion.getFgTrdFxRate();
        if (val96 != null) {
            ps.setBigDecimal(96, val96);
        } else {
            ps.setNull(96, Types.DECIMAL);
        }
        ps.setString(97, fgtrddiversion.getFgTrdPostLoans());
        ps.setString(98, fgtrddiversion.getFgTrdPreLoans());
        ps.setString(99, fgtrddiversion.getFgTrdLc());
        java.math.BigDecimal val100 = fgtrddiversion.getFgTrdApplFxRate();
        if (val100 != null) {
            ps.setBigDecimal(100, val100);
        } else {
            ps.setNull(100, Types.DECIMAL);
        }
        Integer val101 = fgtrddiversion.getVersionID();
        if (val101 != null) {
            ps.setInt(101, val101);
        } else {
            ps.setNull(101, Types.INTEGER);
        }
        java.math.BigDecimal val102 = fgtrddiversion.getIsMasterVersion();
        if (val102 != null) {
            ps.setBigDecimal(102, val102);
        } else {
            ps.setNull(102, Types.DECIMAL);
        }
    }

    private FgTrdDiVersion extract(ResultSet rs) throws SQLException {
        FgTrdDiVersion fgtrddiversion = new FgTrdDiVersion();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrddiversion.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrddiversion.setReferenceID(REFERENCE_ID);
        fgtrddiversion.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrddiversion.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrddiversion.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrddiversion.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrddiversion.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrddiversion.setCreatedBy(CREATED_BY);
        fgtrddiversion.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrddiversion.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrddiversion.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrddiversion.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrddiversion.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrddiversion.setIsTemplate(IS_TEMPLATE);
        fgtrddiversion.setIrNostroNumber(rs.getString(COL_IR_NOSTRO_NUMBER));
        Timestamp IR_VALUE_DATE = rs.getTimestamp(COL_IR_VALUE_DATE);
        if (IR_VALUE_DATE != null)
            fgtrddiversion.setIrValueDate(IR_VALUE_DATE.toLocalDateTime());
        fgtrddiversion.setIrCurCode(rs.getString(COL_IR_CUR_CODE));
        java.math.BigDecimal IR_AMT = rs.getObject(COL_IR_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setIrAmt(IR_AMT);
        fgtrddiversion.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal AMT = rs.getObject(COL_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setAmt(AMT);
        java.math.BigDecimal TRADE_DSP_AMT = rs.getObject(COL_TRADE_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setTradeDspAmt(TRADE_DSP_AMT);
        java.math.BigDecimal FUNDS_DSP_AMT = rs.getObject(COL_FUNDS_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setFundsDspAmt(FUNDS_DSP_AMT);
        java.math.BigDecimal TO_BE_DISPOSED_AMT = rs.getObject(COL_TO_BE_DISPOSED_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setToBeDisposedAmt(TO_BE_DISPOSED_AMT);
        java.math.BigDecimal BANK_TO_BE_BOOK = rs.getObject(COL_BANK_TO_BE_BOOK, java.math.BigDecimal.class);
        fgtrddiversion.setBankToBeBook(BANK_TO_BE_BOOK);
        java.math.BigDecimal BOOK_NEW_DEAL = rs.getObject(COL_BOOK_NEW_DEAL, java.math.BigDecimal.class);
        fgtrddiversion.setBookNewDeal(BOOK_NEW_DEAL);
        java.math.BigDecimal PROVIDED_TRD_DSP_AMT = rs.getObject(COL_PROVIDED_TRD_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setProvidedTrdDspAmt(PROVIDED_TRD_DSP_AMT);
        java.math.BigDecimal TO_BE_DSP_TRD_AMT = rs.getObject(COL_TO_BE_DSP_TRD_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setToBeDspTrdAmt(TO_BE_DSP_TRD_AMT);
        java.math.BigDecimal OFC_MAX_DSP_AMT = rs.getObject(COL_OFC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setOfcMaxDspAmt(OFC_MAX_DSP_AMT);
        java.math.BigDecimal OFC_DSP_AMT = rs.getObject(COL_OFC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setOfcDspAmt(OFC_DSP_AMT);
        java.math.BigDecimal ELC_MAX_DSP_AMT = rs.getObject(COL_ELC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setElcMaxDspAmt(ELC_MAX_DSP_AMT);
        java.math.BigDecimal ELC_DSP_AMT = rs.getObject(COL_ELC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setElcDspAmt(ELC_DSP_AMT);
        java.math.BigDecimal PROVIDED_FUND_DSP_AMT = rs.getObject(COL_PROVIDED_FUND_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setProvidedFundDspAmt(PROVIDED_FUND_DSP_AMT);
        java.math.BigDecimal TO_BE_DSP_FUND_AMT = rs.getObject(COL_TO_BE_DSP_FUND_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setToBeDspFundAmt(TO_BE_DSP_FUND_AMT);
        java.math.BigDecimal POST_SHIP_DSP_AMT = rs.getObject(COL_POST_SHIP_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setPostShipDspAmt(POST_SHIP_DSP_AMT);
        java.math.BigDecimal PRE_SHIP_MAX_DSP_AMT = rs.getObject(COL_PRE_SHIP_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setPreShipMaxDspAmt(PRE_SHIP_MAX_DSP_AMT);
        java.math.BigDecimal PRE_SHIP_DSP_AMT = rs.getObject(COL_PRE_SHIP_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setPreShipDspAmt(PRE_SHIP_DSP_AMT);
        fgtrddiversion.setPreRemAmtAccNo(rs.getString(COL_PRE_REM_AMT_ACC_NO));
        java.math.BigDecimal ACC_MAX_DSP_AMT = rs.getObject(COL_ACC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setAccMaxDspAmt(ACC_MAX_DSP_AMT);
        java.math.BigDecimal ACC_DSP_AMT = rs.getObject(COL_ACC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddiversion.setAccDspAmt(ACC_DSP_AMT);
        fgtrddiversion.setRemAmtAccNo(rs.getString(COL_REM_AMT_ACC_NO));
        fgtrddiversion.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtrddiversion.setIssuingParty(rs.getString(COL_ISSUING_PARTY));
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrddiversion.setIrReferenceID(IR_REFERENCE_ID);
        Integer CUST_REF_ID = rs.getObject(COL_CUST_REF_ID, Integer.class);
        fgtrddiversion.setCustRefID(CUST_REF_ID);
        fgtrddiversion.setDetailsCharge(rs.getString(COL_DETAILS_CHARGE));
        fgtrddiversion.setIrRemInfo(rs.getString(COL_IR_REM_INFO));
        fgtrddiversion.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgtrddiversion.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        fgtrddiversion.setSwiftMsgType(rs.getString(COL_SWIFT_MSG_TYPE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrddiversion.setProcessID(PROCESS_ID);
        fgtrddiversion.setStageCode(rs.getString(COL_STAGE_CODE));
        java.math.BigDecimal CHECKBOX_8 = rs.getObject(COL_CHECKBOX_8, java.math.BigDecimal.class);
        fgtrddiversion.setCheckbox8(CHECKBOX_8);
        fgtrddiversion.setRemitterAddressLine2(rs.getString(COL_REMITTER_ADDRESS_LINE_2));
        fgtrddiversion.setRemitterAddressLine1(rs.getString(COL_REMITTER_ADDRESS_LINE_1));
        fgtrddiversion.setBeneficiaryAddressLine1(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_1));
        fgtrddiversion.setBeneficiaryAddressLine2(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_2));
        Integer BO_REF_ID = rs.getObject(COL_BO_REF_ID, Integer.class);
        fgtrddiversion.setBoRefID(BO_REF_ID);
        fgtrddiversion.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        Integer TASK_ID = rs.getObject(COL_TASK_ID, Integer.class);
        fgtrddiversion.setTaskID(TASK_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgtrddiversion.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal STEPPER_COMPLETION_PERCENTAGE = rs.getObject(COL_STEPPER_COMPLETION_PERCENTAGE, java.math.BigDecimal.class);
        fgtrddiversion.setStepperCompletionPercentage(STEPPER_COMPLETION_PERCENTAGE);
        java.math.BigDecimal LTEA_INDICATOR = rs.getObject(COL_LTEA_INDICATOR, java.math.BigDecimal.class);
        fgtrddiversion.setLteaIndicator(LTEA_INDICATOR);
        fgtrddiversion.setGeneralDetails(rs.getString(COL_GENERAL_DETAILS));
        fgtrddiversion.setDisposalInstruction(rs.getString(COL_DISPOSAL_INSTRUCTION));
        fgtrddiversion.setTradeDisposal(rs.getString(COL_TRADE_DISPOSAL));
        fgtrddiversion.setFundsDisposal(rs.getString(COL_FUNDS_DISPOSAL));
        fgtrddiversion.setDeclaration(rs.getString(COL_DECLARATION));
        fgtrddiversion.setAttachments(rs.getString(COL_ATTACHMENTS));
        fgtrddiversion.setPreview(rs.getString(COL_PREVIEW));
        fgtrddiversion.setIrOrdrInstitution(rs.getString(COL_IR_ORDR_INSTITUTION));
        fgtrddiversion.setCopyFrom(rs.getString(COL_COPY_FROM));
        fgtrddiversion.setDebitAccNo(rs.getString(COL_DEBIT_ACC_NO));
        java.math.BigDecimal MIS_PRODUCT = rs.getObject(COL_MIS_PRODUCT, java.math.BigDecimal.class);
        fgtrddiversion.setMisProduct(MIS_PRODUCT);
        java.math.BigDecimal XAR_PRODUCT = rs.getObject(COL_XAR_PRODUCT, java.math.BigDecimal.class);
        fgtrddiversion.setXarProduct(XAR_PRODUCT);
        java.math.BigDecimal PRE_REM_AMT_ACC_NO_CB = rs.getObject(COL_PRE_REM_AMT_ACC_NO_CB, java.math.BigDecimal.class);
        fgtrddiversion.setPreRemAmtAccNoCb(PRE_REM_AMT_ACC_NO_CB);
        fgtrddiversion.setSender(rs.getString(COL_SENDER));
        fgtrddiversion.setOrdAccno(rs.getString(COL_ORD_ACCNO));
        fgtrddiversion.setOrdName(rs.getString(COL_ORD_NAME));
        fgtrddiversion.setOrdAddr1(rs.getString(COL_ORD_ADDR1));
        fgtrddiversion.setOrdAddr2(rs.getString(COL_ORD_ADDR2));
        fgtrddiversion.setOrdAddr3(rs.getString(COL_ORD_ADDR3));
        fgtrddiversion.setBenefNo(rs.getString(COL_BENEF_NO));
        fgtrddiversion.setBenefName(rs.getString(COL_BENEF_NAME));
        fgtrddiversion.setBenefAddr1(rs.getString(COL_BENEF_ADDR1));
        fgtrddiversion.setBenefAddr2(rs.getString(COL_BENEF_ADDR2));
        fgtrddiversion.setBenefAddr3(rs.getString(COL_BENEF_ADDR3));
        fgtrddiversion.setSwiftMessageData(rs.getString(COL_SWIFT_MESSAGE_DATA));
        fgtrddiversion.setTiMasterRef(rs.getString(COL_TI_MASTER_REF));
        fgtrddiversion.setPreRemtAccNoCur(rs.getString(COL_PRE_REMT_ACC_NO_CUR));
        fgtrddiversion.setRemtAccNoCur(rs.getString(COL_REMT_ACC_NO_CUR));
        fgtrddiversion.setDebitAccNoCur(rs.getString(COL_DEBIT_ACC_NO_CUR));
        fgtrddiversion.setAckMessage(rs.getString(COL_ACK_MESSAGE));
        fgtrddiversion.setAckStatus(rs.getString(COL_ACK_STATUS));
        fgtrddiversion.setFgTrdPurposeCode(rs.getString(COL_FG_TRD_PURPOSE_CODE));
        fgtrddiversion.setFgTrdAccounts(rs.getString(COL_FG_TRD_ACCOUNTS));
        java.math.BigDecimal FG_TRD_FX_RATE = rs.getObject(COL_FG_TRD_FX_RATE, java.math.BigDecimal.class);
        fgtrddiversion.setFgTrdFxRate(FG_TRD_FX_RATE);
        fgtrddiversion.setFgTrdPostLoans(rs.getString(COL_FG_TRD_POST_LOANS));
        fgtrddiversion.setFgTrdPreLoans(rs.getString(COL_FG_TRD_PRE_LOANS));
        fgtrddiversion.setFgTrdLc(rs.getString(COL_FG_TRD_LC));
        java.math.BigDecimal FG_TRD_APPL_FX_RATE = rs.getObject(COL_FG_TRD_APPL_FX_RATE, java.math.BigDecimal.class);
        fgtrddiversion.setFgTrdApplFxRate(FG_TRD_APPL_FX_RATE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtrddiversion.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtrddiversion.setIsMasterVersion(IS_MASTER_VERSION);
        return fgtrddiversion;
    }
}
