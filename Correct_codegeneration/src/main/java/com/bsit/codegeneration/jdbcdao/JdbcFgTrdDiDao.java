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

public class JdbcFgTrdDiDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdDiDao.class);

    private static final String TABLE = "FG_TRD_DI";

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

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ISSUING_PARTY = "ISSUING_PARTY";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_CHECKBOX_1 = "CHECKBOX_1";

    private static final String COL_CHECKBOX_2 = "CHECKBOX_2";

    private static final String COL_CHECKBOX_3 = "CHECKBOX_3";

    private static final String COL_CHECKBOX_4 = "CHECKBOX_4";

    private static final String COL_CHECKBOX_5 = "CHECKBOX_5";

    private static final String COL_CHECKBOX_6 = "CHECKBOX_6";

    private static final String COL_CHECKBOX_7 = "CHECKBOX_7";

    private static final String COL_CHECKBOX_8 = "CHECKBOX_8";

    private static final String COL_SWIFT_MSG_TYPE = "SWIFT_MSG_TYPE";

    private static final String COL_DETAILS_CHARGE = "DETAILS_CHARGE";

    private static final String COL_CUST_REF_ID = "CUST_REF_ID";

    private static final String COL_IR_REM_INFO = "IR_REM_INFO";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_1 = "BENEFICIARY_ADDRESS_LINE_1";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_2 = "BENEFICIARY_ADDRESS_LINE_2";

    private static final String COL_REMITTER_ADDRESS_LINE_1 = "REMITTER_ADDRESS_LINE_1";

    private static final String COL_REMITTER_ADDRESS_LINE_2 = "REMITTER_ADDRESS_LINE_2";

    private static final String COL_BO_REF_ID = "BO_REF_ID";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_TASK_ID = "TASK_ID";

    private static final String COL_DEBIT_ACC_NO = "DEBIT_ACC_NO";

    private static final String COL_LTEA_INDICATOR = "LTEA_INDICATOR";

    private static final String COL_COPY_FROM = "COPY_FROM";

    private static final String COL_IR_ORDR_INSTITUTION = "IR_ORDR_INSTITUTION";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_EVENT = "EVENT";

    private static final String COL_ENTITY = "ENTITY";

    private static final String COL_PRE_REM_AMT_ACC_NO_CB = "PRE_REM_AMT_ACC_NO_CB";

    private static final String COL_TI_MASTER_REF = "TI_MASTER_REF";

    private static final String COL_SWIFT_MESSAGE_DATA = "SWIFT_MESSAGE_DATA";

    private static final String COL_BENEF_ADDR3 = "BENEF_ADDR3";

    private static final String COL_BENEF_ADDR2 = "BENEF_ADDR2";

    private static final String COL_BENEF_ADDR1 = "BENEF_ADDR1";

    private static final String COL_BENEF_NAME = "BENEF_NAME";

    private static final String COL_BENEF_NO = "BENEF_NO";

    private static final String COL_ORD_ADDR3 = "ORD_ADDR3";

    private static final String COL_ORD_ADDR2 = "ORD_ADDR2";

    private static final String COL_ORD_ADDR1 = "ORD_ADDR1";

    private static final String COL_ORD_NAME = "ORD_NAME";

    private static final String COL_ORD_ACCNO = "ORD_ACCNO";

    private static final String COL_SENDER = "SENDER";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IR_NOSTRO_NUMBER, COL_IR_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_CUR_CODE, COL_AMT, COL_TRADE_DSP_AMT, COL_FUNDS_DSP_AMT, COL_TO_BE_DISPOSED_AMT, COL_BANK_TO_BE_BOOK, COL_BOOK_NEW_DEAL, COL_PROVIDED_TRD_DSP_AMT, COL_TO_BE_DSP_TRD_AMT, COL_OFC_MAX_DSP_AMT, COL_OFC_DSP_AMT, COL_ELC_MAX_DSP_AMT, COL_ELC_DSP_AMT, COL_PROVIDED_FUND_DSP_AMT, COL_TO_BE_DSP_FUND_AMT, COL_POST_SHIP_DSP_AMT, COL_PRE_SHIP_MAX_DSP_AMT, COL_PRE_SHIP_DSP_AMT, COL_PRE_REM_AMT_ACC_NO, COL_ACC_MAX_DSP_AMT, COL_ACC_DSP_AMT, COL_REM_AMT_ACC_NO, COL_PROCESS_ID, COL_STAGE_CODE, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_IR_REFERENCE_ID, COL_CHECKBOX_1, COL_CHECKBOX_2, COL_CHECKBOX_3, COL_CHECKBOX_4, COL_CHECKBOX_5, COL_CHECKBOX_6, COL_CHECKBOX_7, COL_CHECKBOX_8, COL_SWIFT_MSG_TYPE, COL_DETAILS_CHARGE, COL_CUST_REF_ID, COL_IR_REM_INFO, COL_BENEFICIARY_NAME, COL_REMITTER_NAME, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_REMITTER_ADDRESS_LINE_1, COL_REMITTER_ADDRESS_LINE_2, COL_BO_REF_ID, COL_PRODUCT_STATUS, COL_TASK_ID, COL_DEBIT_ACC_NO, COL_LTEA_INDICATOR, COL_COPY_FROM, COL_IR_ORDR_INSTITUTION, COL_DMS_EVENT_ID, COL_EVENT, COL_ENTITY, COL_PRE_REM_AMT_ACC_NO_CB, COL_TI_MASTER_REF, COL_SWIFT_MESSAGE_DATA, COL_BENEF_ADDR3, COL_BENEF_ADDR2, COL_BENEF_ADDR1, COL_BENEF_NAME, COL_BENEF_NO, COL_ORD_ADDR3, COL_ORD_ADDR2, COL_ORD_ADDR1, COL_ORD_NAME, COL_ORD_ACCNO, COL_SENDER);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, PROCESS_ID, STAGE_CODE, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CHECKBOX_1, CHECKBOX_2, CHECKBOX_3, CHECKBOX_4, CHECKBOX_5, CHECKBOX_6, CHECKBOX_7, CHECKBOX_8, SWIFT_MSG_TYPE, DETAILS_CHARGE, CUST_REF_ID, IR_REM_INFO, BENEFICIARY_NAME, REMITTER_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DEBIT_ACC_NO, LTEA_INDICATOR, COPY_FROM, IR_ORDR_INSTITUTION, DMS_EVENT_ID, EVENT, ENTITY, PRE_REM_AMT_ACC_NO_CB, TI_MASTER_REF, SWIFT_MESSAGE_DATA, BENEF_ADDR3, BENEF_ADDR2, BENEF_ADDR1, BENEF_NAME, BENEF_NO, ORD_ADDR3, ORD_ADDR2, ORD_ADDR1, ORD_NAME, ORD_ACCNO, SENDER", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, PROCESS_ID, STAGE_CODE, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CHECKBOX_1, CHECKBOX_2, CHECKBOX_3, CHECKBOX_4, CHECKBOX_5, CHECKBOX_6, CHECKBOX_7, CHECKBOX_8, SWIFT_MSG_TYPE, DETAILS_CHARGE, CUST_REF_ID, IR_REM_INFO, BENEFICIARY_NAME, REMITTER_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DEBIT_ACC_NO, LTEA_INDICATOR, COPY_FROM, IR_ORDR_INSTITUTION, DMS_EVENT_ID, EVENT, ENTITY, PRE_REM_AMT_ACC_NO_CB, TI_MASTER_REF, SWIFT_MESSAGE_DATA, BENEF_ADDR3, BENEF_ADDR2, BENEF_ADDR1, BENEF_NAME, BENEF_NO, ORD_ADDR3, ORD_ADDR2, ORD_ADDR1, ORD_NAME, ORD_ACCNO, SENDER", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IR_NOSTRO_NUMBER, COL_IR_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_CUR_CODE, COL_AMT, COL_TRADE_DSP_AMT, COL_FUNDS_DSP_AMT, COL_TO_BE_DISPOSED_AMT, COL_BANK_TO_BE_BOOK, COL_BOOK_NEW_DEAL, COL_PROVIDED_TRD_DSP_AMT, COL_TO_BE_DSP_TRD_AMT, COL_OFC_MAX_DSP_AMT, COL_OFC_DSP_AMT, COL_ELC_MAX_DSP_AMT, COL_ELC_DSP_AMT, COL_PROVIDED_FUND_DSP_AMT, COL_TO_BE_DSP_FUND_AMT, COL_POST_SHIP_DSP_AMT, COL_PRE_SHIP_MAX_DSP_AMT, COL_PRE_SHIP_DSP_AMT, COL_PRE_REM_AMT_ACC_NO, COL_ACC_MAX_DSP_AMT, COL_ACC_DSP_AMT, COL_REM_AMT_ACC_NO, COL_PROCESS_ID, COL_STAGE_CODE, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_IR_REFERENCE_ID, COL_CHECKBOX_1, COL_CHECKBOX_2, COL_CHECKBOX_3, COL_CHECKBOX_4, COL_CHECKBOX_5, COL_CHECKBOX_6, COL_CHECKBOX_7, COL_CHECKBOX_8, COL_SWIFT_MSG_TYPE, COL_DETAILS_CHARGE, COL_CUST_REF_ID, COL_IR_REM_INFO, COL_BENEFICIARY_NAME, COL_REMITTER_NAME, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_REMITTER_ADDRESS_LINE_1, COL_REMITTER_ADDRESS_LINE_2, COL_BO_REF_ID, COL_PRODUCT_STATUS, COL_TASK_ID, COL_DEBIT_ACC_NO, COL_LTEA_INDICATOR, COL_COPY_FROM, COL_IR_ORDR_INSTITUTION, COL_DMS_EVENT_ID, COL_EVENT, COL_ENTITY, COL_PRE_REM_AMT_ACC_NO_CB, COL_TI_MASTER_REF, COL_SWIFT_MESSAGE_DATA, COL_BENEF_ADDR3, COL_BENEF_ADDR2, COL_BENEF_ADDR1, COL_BENEF_NAME, COL_BENEF_NO, COL_ORD_ADDR3, COL_ORD_ADDR2, COL_ORD_ADDR1, COL_ORD_NAME, COL_ORD_ACCNO, COL_SENDER, COL_ID);

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

    public int insert(Connection conn, FgTrdDi fgtrddi) throws SQLException {
        logger.debug("Inserting fgtrddi: {}", fgtrddi);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdDiParams(ps, fgtrddi);
            ps.executeUpdate();
            return fgtrddi.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdDi> fgtrddis) throws SQLException {
        if (fgtrddis == null || fgtrddis.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrddis.size(); i++) {
            if (fgtrddis.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdDi>> batches = chunkList(fgtrddis, batchSize);
        int[] totalResults = new int[fgtrddis.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdDi> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdDi fgtrddi : batch) {
                        setFgTrdDiParams(ps, fgtrddi);
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

    public FgTrdDi findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdDi> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdDi> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdDi fgtrddi) throws SQLException {
        if (fgtrddi.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdDiParams(ps, fgtrddi);
            ps.setInt(87, fgtrddi.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdDi> fgtrddis) throws SQLException {
        if (fgtrddis == null || fgtrddis.isEmpty())
            return new int[0];
        for (FgTrdDi fgtrddi : fgtrddis) {
            if (fgtrddi == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrddi.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdDi>> batches = chunkList(fgtrddis, batchSize);
        int[] totalResults = new int[fgtrddis.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdDi> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdDi fgtrddi : batch) {
                        setFgTrdDiParams(ps, fgtrddi);
                        ps.setInt(87, fgtrddi.getID());
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

    private void setFgTrdDiParams(PreparedStatement ps, FgTrdDi fgtrddi) throws SQLException {
        Integer val1 = fgtrddi.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrddi.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrddi.getTypeCode());
        ps.setString(4, fgtrddi.getSubTypeCode());
        ps.setString(5, fgtrddi.getActiveCode());
        ps.setString(6, fgtrddi.getStatusCode());
        ps.setString(7, fgtrddi.getCreatedOn());
        java.math.BigDecimal val8 = fgtrddi.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgtrddi.getLastUpdatedOn());
        java.math.BigDecimal val10 = fgtrddi.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtrddi.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgtrddi.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtrddi.getTemplate());
        java.math.BigDecimal val14 = fgtrddi.getIsTemplate();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtrddi.getIrNostroNumber());
        java.time.LocalDateTime val16 = fgtrddi.getIrValueDate();
        if (val16 != null) {
            ps.setTimestamp(16, java.sql.Timestamp.valueOf(val16));
        } else {
            ps.setNull(16, Types.TIMESTAMP);
        }
        ps.setString(17, fgtrddi.getIrCurCode());
        java.math.BigDecimal val18 = fgtrddi.getIrAmt();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtrddi.getCurCode());
        java.math.BigDecimal val20 = fgtrddi.getAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrddi.getTradeDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrddi.getFundsDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtrddi.getToBeDisposedAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgtrddi.getBankToBeBook();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgtrddi.getBookNewDeal();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgtrddi.getProvidedTrdDspAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgtrddi.getToBeDspTrdAmt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgtrddi.getOfcMaxDspAmt();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = fgtrddi.getOfcDspAmt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = fgtrddi.getElcMaxDspAmt();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = fgtrddi.getElcDspAmt();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = fgtrddi.getProvidedFundDspAmt();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = fgtrddi.getToBeDspFundAmt();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgtrddi.getPostShipDspAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgtrddi.getPreShipMaxDspAmt();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.math.BigDecimal val36 = fgtrddi.getPreShipDspAmt();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, fgtrddi.getPreRemAmtAccNo());
        java.math.BigDecimal val38 = fgtrddi.getAccMaxDspAmt();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = fgtrddi.getAccDspAmt();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgtrddi.getRemAmtAccNo());
        Integer val41 = fgtrddi.getProcessID();
        if (val41 != null) {
            ps.setInt(41, val41);
        } else {
            ps.setNull(41, Types.INTEGER);
        }
        ps.setString(42, fgtrddi.getStageCode());
        ps.setString(43, fgtrddi.getApplicantParty());
        ps.setString(44, fgtrddi.getIssuingParty());
        Integer val45 = fgtrddi.getIrReferenceID();
        if (val45 != null) {
            ps.setInt(45, val45);
        } else {
            ps.setNull(45, Types.INTEGER);
        }
        java.math.BigDecimal val46 = fgtrddi.getCheckbox1();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = fgtrddi.getCheckbox2();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = fgtrddi.getCheckbox3();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        java.math.BigDecimal val49 = fgtrddi.getCheckbox4();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = fgtrddi.getCheckbox5();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = fgtrddi.getCheckbox6();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        java.math.BigDecimal val52 = fgtrddi.getCheckbox7();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        java.math.BigDecimal val53 = fgtrddi.getCheckbox8();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, fgtrddi.getSwiftMsgType());
        ps.setString(55, fgtrddi.getDetailsCharge());
        Integer val56 = fgtrddi.getCustRefID();
        if (val56 != null) {
            ps.setInt(56, val56);
        } else {
            ps.setNull(56, Types.INTEGER);
        }
        ps.setString(57, fgtrddi.getIrRemInfo());
        ps.setString(58, fgtrddi.getBeneficiaryName());
        ps.setString(59, fgtrddi.getRemitterName());
        ps.setString(60, fgtrddi.getBeneficiaryAddressLine1());
        ps.setString(61, fgtrddi.getBeneficiaryAddressLine2());
        ps.setString(62, fgtrddi.getRemitterAddressLine1());
        ps.setString(63, fgtrddi.getRemitterAddressLine2());
        Integer val64 = fgtrddi.getBoRefID();
        if (val64 != null) {
            ps.setInt(64, val64);
        } else {
            ps.setNull(64, Types.INTEGER);
        }
        ps.setString(65, fgtrddi.getProductStatus());
        Integer val66 = fgtrddi.getTaskID();
        if (val66 != null) {
            ps.setInt(66, val66);
        } else {
            ps.setNull(66, Types.INTEGER);
        }
        ps.setString(67, fgtrddi.getDebitAccNo());
        java.math.BigDecimal val68 = fgtrddi.getLteaIndicator();
        if (val68 != null) {
            ps.setBigDecimal(68, val68);
        } else {
            ps.setNull(68, Types.DECIMAL);
        }
        ps.setString(69, fgtrddi.getCopyFrom());
        ps.setString(70, fgtrddi.getIrOrdrInstitution());
        Integer val71 = fgtrddi.getDmsEventID();
        if (val71 != null) {
            ps.setInt(71, val71);
        } else {
            ps.setNull(71, Types.INTEGER);
        }
        ps.setString(72, fgtrddi.getEvent());
        ps.setString(73, fgtrddi.getEntity());
        java.math.BigDecimal val74 = fgtrddi.getPreRemAmtAccNoCb();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        ps.setString(75, fgtrddi.getTiMasterRef());
        ps.setString(76, fgtrddi.getSwiftMessageData());
        ps.setString(77, fgtrddi.getBenefAddr3());
        ps.setString(78, fgtrddi.getBenefAddr2());
        ps.setString(79, fgtrddi.getBenefAddr1());
        ps.setString(80, fgtrddi.getBenefName());
        ps.setString(81, fgtrddi.getBenefNo());
        ps.setString(82, fgtrddi.getOrdAddr3());
        ps.setString(83, fgtrddi.getOrdAddr2());
        ps.setString(84, fgtrddi.getOrdAddr1());
        ps.setString(85, fgtrddi.getOrdName());
        ps.setString(86, fgtrddi.getOrdAccno());
        ps.setString(87, fgtrddi.getSender());
    }

    private FgTrdDi extract(ResultSet rs) throws SQLException {
        FgTrdDi fgtrddi = new FgTrdDi();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrddi.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrddi.setReferenceID(REFERENCE_ID);
        fgtrddi.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrddi.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrddi.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrddi.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrddi.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrddi.setCreatedBy(CREATED_BY);
        fgtrddi.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrddi.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrddi.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrddi.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrddi.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrddi.setIsTemplate(IS_TEMPLATE);
        fgtrddi.setIrNostroNumber(rs.getString(COL_IR_NOSTRO_NUMBER));
        Timestamp IR_VALUE_DATE = rs.getTimestamp(COL_IR_VALUE_DATE);
        if (IR_VALUE_DATE != null)
            fgtrddi.setIrValueDate(IR_VALUE_DATE.toLocalDateTime());
        fgtrddi.setIrCurCode(rs.getString(COL_IR_CUR_CODE));
        java.math.BigDecimal IR_AMT = rs.getObject(COL_IR_AMT, java.math.BigDecimal.class);
        fgtrddi.setIrAmt(IR_AMT);
        fgtrddi.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal AMT = rs.getObject(COL_AMT, java.math.BigDecimal.class);
        fgtrddi.setAmt(AMT);
        java.math.BigDecimal TRADE_DSP_AMT = rs.getObject(COL_TRADE_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setTradeDspAmt(TRADE_DSP_AMT);
        java.math.BigDecimal FUNDS_DSP_AMT = rs.getObject(COL_FUNDS_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setFundsDspAmt(FUNDS_DSP_AMT);
        java.math.BigDecimal TO_BE_DISPOSED_AMT = rs.getObject(COL_TO_BE_DISPOSED_AMT, java.math.BigDecimal.class);
        fgtrddi.setToBeDisposedAmt(TO_BE_DISPOSED_AMT);
        java.math.BigDecimal BANK_TO_BE_BOOK = rs.getObject(COL_BANK_TO_BE_BOOK, java.math.BigDecimal.class);
        fgtrddi.setBankToBeBook(BANK_TO_BE_BOOK);
        java.math.BigDecimal BOOK_NEW_DEAL = rs.getObject(COL_BOOK_NEW_DEAL, java.math.BigDecimal.class);
        fgtrddi.setBookNewDeal(BOOK_NEW_DEAL);
        java.math.BigDecimal PROVIDED_TRD_DSP_AMT = rs.getObject(COL_PROVIDED_TRD_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setProvidedTrdDspAmt(PROVIDED_TRD_DSP_AMT);
        java.math.BigDecimal TO_BE_DSP_TRD_AMT = rs.getObject(COL_TO_BE_DSP_TRD_AMT, java.math.BigDecimal.class);
        fgtrddi.setToBeDspTrdAmt(TO_BE_DSP_TRD_AMT);
        java.math.BigDecimal OFC_MAX_DSP_AMT = rs.getObject(COL_OFC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setOfcMaxDspAmt(OFC_MAX_DSP_AMT);
        java.math.BigDecimal OFC_DSP_AMT = rs.getObject(COL_OFC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setOfcDspAmt(OFC_DSP_AMT);
        java.math.BigDecimal ELC_MAX_DSP_AMT = rs.getObject(COL_ELC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setElcMaxDspAmt(ELC_MAX_DSP_AMT);
        java.math.BigDecimal ELC_DSP_AMT = rs.getObject(COL_ELC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setElcDspAmt(ELC_DSP_AMT);
        java.math.BigDecimal PROVIDED_FUND_DSP_AMT = rs.getObject(COL_PROVIDED_FUND_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setProvidedFundDspAmt(PROVIDED_FUND_DSP_AMT);
        java.math.BigDecimal TO_BE_DSP_FUND_AMT = rs.getObject(COL_TO_BE_DSP_FUND_AMT, java.math.BigDecimal.class);
        fgtrddi.setToBeDspFundAmt(TO_BE_DSP_FUND_AMT);
        java.math.BigDecimal POST_SHIP_DSP_AMT = rs.getObject(COL_POST_SHIP_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setPostShipDspAmt(POST_SHIP_DSP_AMT);
        java.math.BigDecimal PRE_SHIP_MAX_DSP_AMT = rs.getObject(COL_PRE_SHIP_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setPreShipMaxDspAmt(PRE_SHIP_MAX_DSP_AMT);
        java.math.BigDecimal PRE_SHIP_DSP_AMT = rs.getObject(COL_PRE_SHIP_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setPreShipDspAmt(PRE_SHIP_DSP_AMT);
        fgtrddi.setPreRemAmtAccNo(rs.getString(COL_PRE_REM_AMT_ACC_NO));
        java.math.BigDecimal ACC_MAX_DSP_AMT = rs.getObject(COL_ACC_MAX_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setAccMaxDspAmt(ACC_MAX_DSP_AMT);
        java.math.BigDecimal ACC_DSP_AMT = rs.getObject(COL_ACC_DSP_AMT, java.math.BigDecimal.class);
        fgtrddi.setAccDspAmt(ACC_DSP_AMT);
        fgtrddi.setRemAmtAccNo(rs.getString(COL_REM_AMT_ACC_NO));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrddi.setProcessID(PROCESS_ID);
        fgtrddi.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrddi.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtrddi.setIssuingParty(rs.getString(COL_ISSUING_PARTY));
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrddi.setIrReferenceID(IR_REFERENCE_ID);
        java.math.BigDecimal CHECKBOX_1 = rs.getObject(COL_CHECKBOX_1, java.math.BigDecimal.class);
        fgtrddi.setCheckbox1(CHECKBOX_1);
        java.math.BigDecimal CHECKBOX_2 = rs.getObject(COL_CHECKBOX_2, java.math.BigDecimal.class);
        fgtrddi.setCheckbox2(CHECKBOX_2);
        java.math.BigDecimal CHECKBOX_3 = rs.getObject(COL_CHECKBOX_3, java.math.BigDecimal.class);
        fgtrddi.setCheckbox3(CHECKBOX_3);
        java.math.BigDecimal CHECKBOX_4 = rs.getObject(COL_CHECKBOX_4, java.math.BigDecimal.class);
        fgtrddi.setCheckbox4(CHECKBOX_4);
        java.math.BigDecimal CHECKBOX_5 = rs.getObject(COL_CHECKBOX_5, java.math.BigDecimal.class);
        fgtrddi.setCheckbox5(CHECKBOX_5);
        java.math.BigDecimal CHECKBOX_6 = rs.getObject(COL_CHECKBOX_6, java.math.BigDecimal.class);
        fgtrddi.setCheckbox6(CHECKBOX_6);
        java.math.BigDecimal CHECKBOX_7 = rs.getObject(COL_CHECKBOX_7, java.math.BigDecimal.class);
        fgtrddi.setCheckbox7(CHECKBOX_7);
        java.math.BigDecimal CHECKBOX_8 = rs.getObject(COL_CHECKBOX_8, java.math.BigDecimal.class);
        fgtrddi.setCheckbox8(CHECKBOX_8);
        fgtrddi.setSwiftMsgType(rs.getString(COL_SWIFT_MSG_TYPE));
        fgtrddi.setDetailsCharge(rs.getString(COL_DETAILS_CHARGE));
        Integer CUST_REF_ID = rs.getObject(COL_CUST_REF_ID, Integer.class);
        fgtrddi.setCustRefID(CUST_REF_ID);
        fgtrddi.setIrRemInfo(rs.getString(COL_IR_REM_INFO));
        fgtrddi.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        fgtrddi.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgtrddi.setBeneficiaryAddressLine1(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_1));
        fgtrddi.setBeneficiaryAddressLine2(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_2));
        fgtrddi.setRemitterAddressLine1(rs.getString(COL_REMITTER_ADDRESS_LINE_1));
        fgtrddi.setRemitterAddressLine2(rs.getString(COL_REMITTER_ADDRESS_LINE_2));
        Integer BO_REF_ID = rs.getObject(COL_BO_REF_ID, Integer.class);
        fgtrddi.setBoRefID(BO_REF_ID);
        fgtrddi.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        Integer TASK_ID = rs.getObject(COL_TASK_ID, Integer.class);
        fgtrddi.setTaskID(TASK_ID);
        fgtrddi.setDebitAccNo(rs.getString(COL_DEBIT_ACC_NO));
        java.math.BigDecimal LTEA_INDICATOR = rs.getObject(COL_LTEA_INDICATOR, java.math.BigDecimal.class);
        fgtrddi.setLteaIndicator(LTEA_INDICATOR);
        fgtrddi.setCopyFrom(rs.getString(COL_COPY_FROM));
        fgtrddi.setIrOrdrInstitution(rs.getString(COL_IR_ORDR_INSTITUTION));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgtrddi.setDmsEventID(DMS_EVENT_ID);
        fgtrddi.setEvent(rs.getString(COL_EVENT));
        fgtrddi.setEntity(rs.getString(COL_ENTITY));
        java.math.BigDecimal PRE_REM_AMT_ACC_NO_CB = rs.getObject(COL_PRE_REM_AMT_ACC_NO_CB, java.math.BigDecimal.class);
        fgtrddi.setPreRemAmtAccNoCb(PRE_REM_AMT_ACC_NO_CB);
        fgtrddi.setTiMasterRef(rs.getString(COL_TI_MASTER_REF));
        fgtrddi.setSwiftMessageData(rs.getString(COL_SWIFT_MESSAGE_DATA));
        fgtrddi.setBenefAddr3(rs.getString(COL_BENEF_ADDR3));
        fgtrddi.setBenefAddr2(rs.getString(COL_BENEF_ADDR2));
        fgtrddi.setBenefAddr1(rs.getString(COL_BENEF_ADDR1));
        fgtrddi.setBenefName(rs.getString(COL_BENEF_NAME));
        fgtrddi.setBenefNo(rs.getString(COL_BENEF_NO));
        fgtrddi.setOrdAddr3(rs.getString(COL_ORD_ADDR3));
        fgtrddi.setOrdAddr2(rs.getString(COL_ORD_ADDR2));
        fgtrddi.setOrdAddr1(rs.getString(COL_ORD_ADDR1));
        fgtrddi.setOrdName(rs.getString(COL_ORD_NAME));
        fgtrddi.setOrdAccno(rs.getString(COL_ORD_ACCNO));
        fgtrddi.setSender(rs.getString(COL_SENDER));
        return fgtrddi;
    }
}
