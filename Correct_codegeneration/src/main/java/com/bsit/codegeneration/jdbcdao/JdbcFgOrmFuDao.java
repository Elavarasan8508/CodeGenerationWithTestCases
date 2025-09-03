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

public class JdbcFgOrmFuDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgOrmFuDao.class);

    private static final String TABLE = "FG_ORM_FU";

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

    private static final String COL_REMITTANCE_TYPE = "REMITTANCE_TYPE";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_PURPOSE_OF_REM = "PURPOSE_OF_REM";

    private static final String COL_REGULARATORY_REPORT = "REGULARATORY_REPORT";

    private static final String COL_CAPITAL_GOODS = "CAPITAL_GOODS";

    private static final String COL_TRANSPORT_DOC_NO = "TRANSPORT_DOC_NO";

    private static final String COL_COUNTRY_PROVIDING = "COUNTRY_PROVIDING";

    private static final String COL_TRANSFER_REF = "TRANSFER_REF";

    private static final String COL_CUSTOMER_REF = "CUSTOMER_REF";

    private static final String COL_ENTITY = "ENTITY";

    private static final String COL_BENE_COUNTRY = "BENE_COUNTRY";

    private static final String COL_BENE_ACCT = "BENE_ACCT";

    private static final String COL_CHARGE_INSTRUCTION = "CHARGE_INSTRUCTION";

    private static final String COL_EXECUTION_DATE = "EXECUTION_DATE";

    private static final String COL_PAYMENT_INSTRUCTION = "PAYMENT_INSTRUCTION";

    private static final String COL_ISSUING_BANK = "ISSUING_BANK";

    private static final String COL_ISSUERS_REF = "ISSUERS_REF";

    private static final String COL_INTER_BANK_SWIFT = "INTER_BANK_SWIFT";

    private static final String COL_INTER_BANK_NAME = "INTER_BANK_NAME";

    private static final String COL_INTER_BANK_ADDR_1 = "INTER_BANK_ADDR_1";

    private static final String COL_INTER_BANK_ADDR_2 = "INTER_BANK_ADDR_2";

    private static final String COL_INTER_BANK_ADDR_3 = "INTER_BANK_ADDR_3";

    private static final String COL_CHARGE_ACCT = "CHARGE_ACCT";

    private static final String COL_ATTACHMENTS = "ATTACHMENTS";

    private static final String COL_PORT_DISCHARGE = "PORT_DISCHARGE";

    private static final String COL_DUPLICATE_CHECK = "DUPLICATE_CHECK";

    private static final String COL_OTHERS = "OTHERS";

    private static final String COL_DEBIT_ACCTNO = "DEBIT_ACCTNO";

    private static final String COL_TRASACTION_CCY = "TRASACTION_CCY";

    private static final String COL_TRASACTION_AMT = "TRASACTION_AMT";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_SUPPLIER_ACCTNO = "SUPPLIER_ACCTNO";

    private static final String COL_SUPPLIER_ADDR_1 = "SUPPLIER_ADDR_1";

    private static final String COL_SUPPLIER_ADDR_2 = "SUPPLIER_ADDR_2";

    private static final String COL_SUPPLIER_ADDR_3 = "SUPPLIER_ADDR_3";

    private static final String COL_NOTIFY_PARTIES = "NOTIFY_PARTIES";

    private static final String COL_ORIGIN_OF_GOODS = "ORIGIN_OF_GOODS";

    private static final String COL_THIRD_PARTY_NAME = "THIRD_PARTY_NAME";

    private static final String COL_THIRD_PARTY_ADDR1 = "THIRD_PARTY_ADDR1";

    private static final String COL_THIRD_PARTY_ADDR2 = "THIRD_PARTY_ADDR2";

    private static final String COL_THIRD_PARTY_ADDR3 = "THIRD_PARTY_ADDR3";

    private static final String COL_CONSIGNOR_NAME = "CONSIGNOR_NAME";

    private static final String COL_CONSIGNOR_ADDR1 = "CONSIGNOR_ADDR1";

    private static final String COL_CONSIGNOR_ADDR2 = "CONSIGNOR_ADDR2";

    private static final String COL_CONSIGNOR_ADDR3 = "CONSIGNOR_ADDR3";

    private static final String COL_CONSIGNEE_NAME = "CONSIGNEE_NAME";

    private static final String COL_CONSIGNEE_ADDR1 = "CONSIGNEE_ADDR1";

    private static final String COL_CONSIGNEE_ADDR2 = "CONSIGNEE_ADDR2";

    private static final String COL_CONSIGNEE_ADDR3 = "CONSIGNEE_ADDR3";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_SUPPLIER_BANK_SWIFT = "SUPPLIER_BANK_SWIFT";

    private static final String COL_FX_DEAL_REF = "FX_DEAL_REF";

    private static final String COL_GOODS_DESC = "GOODS_DESC";

    private static final String COL_PURPOSE_OF_PAYMENT = "PURPOSE_OF_PAYMENT";

    private static final String COL_GSTIN = "GSTIN";

    private static final String COL_CHARGE_ACCTNO = "CHARGE_ACCTNO";

    private static final String COL_SUPPLIER_INSTRUCTION = "SUPPLIER_INSTRUCTION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_FCC_STATUS = "FCC_STATUS";

    private static final String COL_FCC_STAGE = "FCC_STAGE";

    private static final String COL_FCC_COMMENTS = "FCC_COMMENTS";

    private static final String COL_BENE_CURRENCY = "BENE_CURRENCY";

    private static final String COL_ISSUING_BANK_NAME = "ISSUING_BANK_NAME";

    private static final String COL_TXN_STATUS = "TXN_STATUS";

    private static final String COL_TXN_REFERENCE = "TXN_REFERENCE";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_API_ERROR_DESC = "API_ERROR_DESC";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_RATE_DETAILS = "RATE_DETAILS";

    private static final String COL_DEAL_TYPE = "DEAL_TYPE";

    private static final String COL_BENE_BAN_SWIFT = "BENE_BAN_SWIFT";

    private static final String COL_BANK_ABBV_NAME = "BANK_ABBV_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_REMITTANCE_TYPE, COL_PURPOSE_CODE, COL_PURPOSE_OF_REM, COL_REGULARATORY_REPORT, COL_CAPITAL_GOODS, COL_TRANSPORT_DOC_NO, COL_COUNTRY_PROVIDING, COL_TRANSFER_REF, COL_CUSTOMER_REF, COL_ENTITY, COL_BENE_COUNTRY, COL_BENE_ACCT, COL_CHARGE_INSTRUCTION, COL_EXECUTION_DATE, COL_PAYMENT_INSTRUCTION, COL_ISSUING_BANK, COL_ISSUERS_REF, COL_INTER_BANK_SWIFT, COL_INTER_BANK_NAME, COL_INTER_BANK_ADDR_1, COL_INTER_BANK_ADDR_2, COL_INTER_BANK_ADDR_3, COL_CHARGE_ACCT, COL_ATTACHMENTS, COL_PORT_DISCHARGE, COL_DUPLICATE_CHECK, COL_OTHERS, COL_DEBIT_ACCTNO, COL_TRASACTION_CCY, COL_TRASACTION_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ACCTNO, COL_SUPPLIER_ADDR_1, COL_SUPPLIER_ADDR_2, COL_SUPPLIER_ADDR_3, COL_NOTIFY_PARTIES, COL_ORIGIN_OF_GOODS, COL_THIRD_PARTY_NAME, COL_THIRD_PARTY_ADDR1, COL_THIRD_PARTY_ADDR2, COL_THIRD_PARTY_ADDR3, COL_CONSIGNOR_NAME, COL_CONSIGNOR_ADDR1, COL_CONSIGNOR_ADDR2, COL_CONSIGNOR_ADDR3, COL_CONSIGNEE_NAME, COL_CONSIGNEE_ADDR1, COL_CONSIGNEE_ADDR2, COL_CONSIGNEE_ADDR3, COL_BOE_DATE, COL_SUPPLIER_BANK_SWIFT, COL_FX_DEAL_REF, COL_GOODS_DESC, COL_PURPOSE_OF_PAYMENT, COL_GSTIN, COL_CHARGE_ACCTNO, COL_SUPPLIER_INSTRUCTION, COL_UPLOAD_REF_ID, COL_DISPLAY_STATUS, COL_BOE_NUMBER, COL_FCC_STATUS, COL_FCC_STAGE, COL_FCC_COMMENTS, COL_BENE_CURRENCY, COL_ISSUING_BANK_NAME, COL_TXN_STATUS, COL_TXN_REFERENCE, COL_FILE_NAME, COL_API_ERROR_DESC, COL_LINE_NO, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_RATE_DETAILS, COL_DEAL_TYPE, COL_BENE_BAN_SWIFT, COL_BANK_ABBV_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REMITTANCE_TYPE, PURPOSE_CODE, PURPOSE_OF_REM, REGULARATORY_REPORT, CAPITAL_GOODS, TRANSPORT_DOC_NO, COUNTRY_PROVIDING, TRANSFER_REF, CUSTOMER_REF, ENTITY, BENE_COUNTRY, BENE_ACCT, CHARGE_INSTRUCTION, EXECUTION_DATE, PAYMENT_INSTRUCTION, ISSUING_BANK, ISSUERS_REF, INTER_BANK_SWIFT, INTER_BANK_NAME, INTER_BANK_ADDR_1, INTER_BANK_ADDR_2, INTER_BANK_ADDR_3, CHARGE_ACCT, ATTACHMENTS, PORT_DISCHARGE, DUPLICATE_CHECK, OTHERS, DEBIT_ACCTNO, TRASACTION_CCY, TRASACTION_AMT, SUPPLIER_NAME, SUPPLIER_ACCTNO, SUPPLIER_ADDR_1, SUPPLIER_ADDR_2, SUPPLIER_ADDR_3, NOTIFY_PARTIES, ORIGIN_OF_GOODS, THIRD_PARTY_NAME, THIRD_PARTY_ADDR1, THIRD_PARTY_ADDR2, THIRD_PARTY_ADDR3, CONSIGNOR_NAME, CONSIGNOR_ADDR1, CONSIGNOR_ADDR2, CONSIGNOR_ADDR3, CONSIGNEE_NAME, CONSIGNEE_ADDR1, CONSIGNEE_ADDR2, CONSIGNEE_ADDR3, BOE_DATE, SUPPLIER_BANK_SWIFT, FX_DEAL_REF, GOODS_DESC, PURPOSE_OF_PAYMENT, GSTIN, CHARGE_ACCTNO, SUPPLIER_INSTRUCTION, UPLOAD_REF_ID, DISPLAY_STATUS, BOE_NUMBER, FCC_STATUS, FCC_STAGE, FCC_COMMENTS, BENE_CURRENCY, ISSUING_BANK_NAME, TXN_STATUS, TXN_REFERENCE, FILE_NAME, API_ERROR_DESC, LINE_NO, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, RATE_DETAILS, DEAL_TYPE, BENE_BAN_SWIFT, BANK_ABBV_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REMITTANCE_TYPE, PURPOSE_CODE, PURPOSE_OF_REM, REGULARATORY_REPORT, CAPITAL_GOODS, TRANSPORT_DOC_NO, COUNTRY_PROVIDING, TRANSFER_REF, CUSTOMER_REF, ENTITY, BENE_COUNTRY, BENE_ACCT, CHARGE_INSTRUCTION, EXECUTION_DATE, PAYMENT_INSTRUCTION, ISSUING_BANK, ISSUERS_REF, INTER_BANK_SWIFT, INTER_BANK_NAME, INTER_BANK_ADDR_1, INTER_BANK_ADDR_2, INTER_BANK_ADDR_3, CHARGE_ACCT, ATTACHMENTS, PORT_DISCHARGE, DUPLICATE_CHECK, OTHERS, DEBIT_ACCTNO, TRASACTION_CCY, TRASACTION_AMT, SUPPLIER_NAME, SUPPLIER_ACCTNO, SUPPLIER_ADDR_1, SUPPLIER_ADDR_2, SUPPLIER_ADDR_3, NOTIFY_PARTIES, ORIGIN_OF_GOODS, THIRD_PARTY_NAME, THIRD_PARTY_ADDR1, THIRD_PARTY_ADDR2, THIRD_PARTY_ADDR3, CONSIGNOR_NAME, CONSIGNOR_ADDR1, CONSIGNOR_ADDR2, CONSIGNOR_ADDR3, CONSIGNEE_NAME, CONSIGNEE_ADDR1, CONSIGNEE_ADDR2, CONSIGNEE_ADDR3, BOE_DATE, SUPPLIER_BANK_SWIFT, FX_DEAL_REF, GOODS_DESC, PURPOSE_OF_PAYMENT, GSTIN, CHARGE_ACCTNO, SUPPLIER_INSTRUCTION, UPLOAD_REF_ID, DISPLAY_STATUS, BOE_NUMBER, FCC_STATUS, FCC_STAGE, FCC_COMMENTS, BENE_CURRENCY, ISSUING_BANK_NAME, TXN_STATUS, TXN_REFERENCE, FILE_NAME, API_ERROR_DESC, LINE_NO, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, RATE_DETAILS, DEAL_TYPE, BENE_BAN_SWIFT, BANK_ABBV_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_REMITTANCE_TYPE, COL_PURPOSE_CODE, COL_PURPOSE_OF_REM, COL_REGULARATORY_REPORT, COL_CAPITAL_GOODS, COL_TRANSPORT_DOC_NO, COL_COUNTRY_PROVIDING, COL_TRANSFER_REF, COL_CUSTOMER_REF, COL_ENTITY, COL_BENE_COUNTRY, COL_BENE_ACCT, COL_CHARGE_INSTRUCTION, COL_EXECUTION_DATE, COL_PAYMENT_INSTRUCTION, COL_ISSUING_BANK, COL_ISSUERS_REF, COL_INTER_BANK_SWIFT, COL_INTER_BANK_NAME, COL_INTER_BANK_ADDR_1, COL_INTER_BANK_ADDR_2, COL_INTER_BANK_ADDR_3, COL_CHARGE_ACCT, COL_ATTACHMENTS, COL_PORT_DISCHARGE, COL_DUPLICATE_CHECK, COL_OTHERS, COL_DEBIT_ACCTNO, COL_TRASACTION_CCY, COL_TRASACTION_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ACCTNO, COL_SUPPLIER_ADDR_1, COL_SUPPLIER_ADDR_2, COL_SUPPLIER_ADDR_3, COL_NOTIFY_PARTIES, COL_ORIGIN_OF_GOODS, COL_THIRD_PARTY_NAME, COL_THIRD_PARTY_ADDR1, COL_THIRD_PARTY_ADDR2, COL_THIRD_PARTY_ADDR3, COL_CONSIGNOR_NAME, COL_CONSIGNOR_ADDR1, COL_CONSIGNOR_ADDR2, COL_CONSIGNOR_ADDR3, COL_CONSIGNEE_NAME, COL_CONSIGNEE_ADDR1, COL_CONSIGNEE_ADDR2, COL_CONSIGNEE_ADDR3, COL_BOE_DATE, COL_SUPPLIER_BANK_SWIFT, COL_FX_DEAL_REF, COL_GOODS_DESC, COL_PURPOSE_OF_PAYMENT, COL_GSTIN, COL_CHARGE_ACCTNO, COL_SUPPLIER_INSTRUCTION, COL_UPLOAD_REF_ID, COL_DISPLAY_STATUS, COL_BOE_NUMBER, COL_FCC_STATUS, COL_FCC_STAGE, COL_FCC_COMMENTS, COL_BENE_CURRENCY, COL_ISSUING_BANK_NAME, COL_TXN_STATUS, COL_TXN_REFERENCE, COL_FILE_NAME, COL_API_ERROR_DESC, COL_LINE_NO, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_RATE_DETAILS, COL_DEAL_TYPE, COL_BENE_BAN_SWIFT, COL_BANK_ABBV_NAME, COL_ID);

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

    public int insert(Connection conn, FgOrmFu fgormfu) throws SQLException {
        logger.debug("Inserting fgormfu: {}", fgormfu);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgOrmFuParams(ps, fgormfu);
            ps.executeUpdate();
            return fgormfu.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgOrmFu> fgormfus) throws SQLException {
        if (fgormfus == null || fgormfus.isEmpty())
            return new int[0];
        for (int i = 0; i < fgormfus.size(); i++) {
            if (fgormfus.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmFu>> batches = chunkList(fgormfus, batchSize);
        int[] totalResults = new int[fgormfus.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmFu> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgOrmFu fgormfu : batch) {
                        setFgOrmFuParams(ps, fgormfu);
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

    public FgOrmFu findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgOrmFu> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgOrmFu> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgOrmFu fgormfu) throws SQLException {
        if (fgormfu.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgOrmFuParams(ps, fgormfu);
            ps.setInt(94, fgormfu.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgOrmFu> fgormfus) throws SQLException {
        if (fgormfus == null || fgormfus.isEmpty())
            return new int[0];
        for (FgOrmFu fgormfu : fgormfus) {
            if (fgormfu == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgormfu.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmFu>> batches = chunkList(fgormfus, batchSize);
        int[] totalResults = new int[fgormfus.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmFu> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgOrmFu fgormfu : batch) {
                        setFgOrmFuParams(ps, fgormfu);
                        ps.setInt(94, fgormfu.getID());
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

    private void setFgOrmFuParams(PreparedStatement ps, FgOrmFu fgormfu) throws SQLException {
        Integer val1 = fgormfu.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgormfu.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgormfu.getTypeCode());
        ps.setString(4, fgormfu.getSubTypeCode());
        ps.setString(5, fgormfu.getActiveCode());
        ps.setString(6, fgormfu.getStageCode());
        ps.setString(7, fgormfu.getStatusCode());
        Integer val8 = fgormfu.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgormfu.getCreatedOn());
        java.math.BigDecimal val10 = fgormfu.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgormfu.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgormfu.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgormfu.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgormfu.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgormfu.getTemplate());
        ps.setString(16, fgormfu.getApplicantParty());
        ps.setString(17, fgormfu.getFulfillmentParty());
        java.math.BigDecimal val18 = fgormfu.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgormfu.getRemittanceType());
        ps.setString(20, fgormfu.getPurposeCode());
        ps.setString(21, fgormfu.getPurposeOfRem());
        ps.setString(22, fgormfu.getRegularatoryReport());
        ps.setString(23, fgormfu.getCapitalGoods());
        ps.setString(24, fgormfu.getTransportDocNo());
        ps.setString(25, fgormfu.getCountryProviding());
        ps.setString(26, fgormfu.getTransferRef());
        ps.setString(27, fgormfu.getCustomerRef());
        ps.setString(28, fgormfu.getEntity());
        ps.setString(29, fgormfu.getBeneCountry());
        ps.setString(30, fgormfu.getBeneAcct());
        ps.setString(31, fgormfu.getChargeInstruction());
        java.time.LocalDateTime val32 = fgormfu.getExecutionDate();
        if (val32 != null) {
            ps.setTimestamp(32, java.sql.Timestamp.valueOf(val32));
        } else {
            ps.setNull(32, Types.TIMESTAMP);
        }
        ps.setString(33, fgormfu.getPaymentInstruction());
        ps.setString(34, fgormfu.getIssuingBank());
        ps.setString(35, fgormfu.getIssuersRef());
        ps.setString(36, fgormfu.getInterBankSwift());
        ps.setString(37, fgormfu.getInterBankName());
        ps.setString(38, fgormfu.getInterBankAddr1());
        ps.setString(39, fgormfu.getInterBankAddr2());
        ps.setString(40, fgormfu.getInterBankAddr3());
        ps.setString(41, fgormfu.getChargeAcct());
        ps.setString(42, fgormfu.getAttachments());
        ps.setString(43, fgormfu.getPortDischarge());
        ps.setString(44, fgormfu.getDuplicateCheck());
        ps.setString(45, fgormfu.getOthers());
        java.math.BigDecimal val46 = fgormfu.getDebitAcctno();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgormfu.getTrasactionCcy());
        java.math.BigDecimal val48 = fgormfu.getTrasactionAmt();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, fgormfu.getSupplierName());
        ps.setString(50, fgormfu.getSupplierAcctno());
        ps.setString(51, fgormfu.getSupplierAddr1());
        ps.setString(52, fgormfu.getSupplierAddr2());
        ps.setString(53, fgormfu.getSupplierAddr3());
        ps.setString(54, fgormfu.getNotifyParties());
        ps.setString(55, fgormfu.getOriginOfGoods());
        ps.setString(56, fgormfu.getThirdPartyName());
        ps.setString(57, fgormfu.getThirdPartyAddr1());
        ps.setString(58, fgormfu.getThirdPartyAddr2());
        ps.setString(59, fgormfu.getThirdPartyAddr3());
        ps.setString(60, fgormfu.getConsignorName());
        ps.setString(61, fgormfu.getConsignorAddr1());
        ps.setString(62, fgormfu.getConsignorAddr2());
        ps.setString(63, fgormfu.getConsignorAddr3());
        ps.setString(64, fgormfu.getConsigneeName());
        ps.setString(65, fgormfu.getConsigneeAddr1());
        ps.setString(66, fgormfu.getConsigneeAddr2());
        ps.setString(67, fgormfu.getConsigneeAddr3());
        ps.setString(68, fgormfu.getBoeDate());
        ps.setString(69, fgormfu.getSupplierBankSwift());
        ps.setString(70, fgormfu.getFxDealRef());
        ps.setString(71, fgormfu.getGoodsDesc());
        ps.setString(72, fgormfu.getPurposeOfPayment());
        ps.setString(73, fgormfu.getGstin());
        java.math.BigDecimal val74 = fgormfu.getChargeAcctno();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        ps.setString(75, fgormfu.getSupplierInstruction());
        Integer val76 = fgormfu.getUploadRefID();
        if (val76 != null) {
            ps.setInt(76, val76);
        } else {
            ps.setNull(76, Types.INTEGER);
        }
        ps.setString(77, fgormfu.getDisplayStatus());
        ps.setString(78, fgormfu.getBoeNumber());
        ps.setString(79, fgormfu.getFccStatus());
        ps.setString(80, fgormfu.getFccStage());
        ps.setString(81, fgormfu.getFccComments());
        ps.setString(82, fgormfu.getBeneCurrency());
        ps.setString(83, fgormfu.getIssuingBankName());
        ps.setString(84, fgormfu.getTxnStatus());
        ps.setString(85, fgormfu.getTxnReference());
        ps.setString(86, fgormfu.getFileName());
        ps.setString(87, fgormfu.getAPIErrorDesc());
        ps.setString(88, fgormfu.getLineNo());
        ps.setString(89, fgormfu.getApplicantPartyCode());
        ps.setString(90, fgormfu.getIssuingPartyCode());
        java.math.BigDecimal val91 = fgormfu.getRateDetails();
        if (val91 != null) {
            ps.setBigDecimal(91, val91);
        } else {
            ps.setNull(91, Types.DECIMAL);
        }
        ps.setString(92, fgormfu.getDealType());
        ps.setString(93, fgormfu.getBeneBanSwift());
        ps.setString(94, fgormfu.getBankAbbvName());
    }

    private FgOrmFu extract(ResultSet rs) throws SQLException {
        FgOrmFu fgormfu = new FgOrmFu();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgormfu.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgormfu.setReferenceID(REFERENCE_ID);
        fgormfu.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgormfu.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgormfu.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgormfu.setStageCode(rs.getString(COL_STAGE_CODE));
        fgormfu.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgormfu.setProcessID(PROCESS_ID);
        fgormfu.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgormfu.setCreatedBy(CREATED_BY);
        fgormfu.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgormfu.setLastUpdatedBy(LAST_UPDATED_BY);
        fgormfu.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgormfu.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgormfu.setTemplate(rs.getString(COL_TEMPLATE));
        fgormfu.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgormfu.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgormfu.setIsTemplate(IS_TEMPLATE);
        fgormfu.setRemittanceType(rs.getString(COL_REMITTANCE_TYPE));
        fgormfu.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgormfu.setPurposeOfRem(rs.getString(COL_PURPOSE_OF_REM));
        fgormfu.setRegularatoryReport(rs.getString(COL_REGULARATORY_REPORT));
        fgormfu.setCapitalGoods(rs.getString(COL_CAPITAL_GOODS));
        fgormfu.setTransportDocNo(rs.getString(COL_TRANSPORT_DOC_NO));
        fgormfu.setCountryProviding(rs.getString(COL_COUNTRY_PROVIDING));
        fgormfu.setTransferRef(rs.getString(COL_TRANSFER_REF));
        fgormfu.setCustomerRef(rs.getString(COL_CUSTOMER_REF));
        fgormfu.setEntity(rs.getString(COL_ENTITY));
        fgormfu.setBeneCountry(rs.getString(COL_BENE_COUNTRY));
        fgormfu.setBeneAcct(rs.getString(COL_BENE_ACCT));
        fgormfu.setChargeInstruction(rs.getString(COL_CHARGE_INSTRUCTION));
        Timestamp EXECUTION_DATE = rs.getTimestamp(COL_EXECUTION_DATE);
        if (EXECUTION_DATE != null)
            fgormfu.setExecutionDate(EXECUTION_DATE.toLocalDateTime());
        fgormfu.setPaymentInstruction(rs.getString(COL_PAYMENT_INSTRUCTION));
        fgormfu.setIssuingBank(rs.getString(COL_ISSUING_BANK));
        fgormfu.setIssuersRef(rs.getString(COL_ISSUERS_REF));
        fgormfu.setInterBankSwift(rs.getString(COL_INTER_BANK_SWIFT));
        fgormfu.setInterBankName(rs.getString(COL_INTER_BANK_NAME));
        fgormfu.setInterBankAddr1(rs.getString(COL_INTER_BANK_ADDR_1));
        fgormfu.setInterBankAddr2(rs.getString(COL_INTER_BANK_ADDR_2));
        fgormfu.setInterBankAddr3(rs.getString(COL_INTER_BANK_ADDR_3));
        fgormfu.setChargeAcct(rs.getString(COL_CHARGE_ACCT));
        fgormfu.setAttachments(rs.getString(COL_ATTACHMENTS));
        fgormfu.setPortDischarge(rs.getString(COL_PORT_DISCHARGE));
        fgormfu.setDuplicateCheck(rs.getString(COL_DUPLICATE_CHECK));
        fgormfu.setOthers(rs.getString(COL_OTHERS));
        java.math.BigDecimal DEBIT_ACCTNO = rs.getObject(COL_DEBIT_ACCTNO, java.math.BigDecimal.class);
        fgormfu.setDebitAcctno(DEBIT_ACCTNO);
        fgormfu.setTrasactionCcy(rs.getString(COL_TRASACTION_CCY));
        java.math.BigDecimal TRASACTION_AMT = rs.getObject(COL_TRASACTION_AMT, java.math.BigDecimal.class);
        fgormfu.setTrasactionAmt(TRASACTION_AMT);
        fgormfu.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        fgormfu.setSupplierAcctno(rs.getString(COL_SUPPLIER_ACCTNO));
        fgormfu.setSupplierAddr1(rs.getString(COL_SUPPLIER_ADDR_1));
        fgormfu.setSupplierAddr2(rs.getString(COL_SUPPLIER_ADDR_2));
        fgormfu.setSupplierAddr3(rs.getString(COL_SUPPLIER_ADDR_3));
        fgormfu.setNotifyParties(rs.getString(COL_NOTIFY_PARTIES));
        fgormfu.setOriginOfGoods(rs.getString(COL_ORIGIN_OF_GOODS));
        fgormfu.setThirdPartyName(rs.getString(COL_THIRD_PARTY_NAME));
        fgormfu.setThirdPartyAddr1(rs.getString(COL_THIRD_PARTY_ADDR1));
        fgormfu.setThirdPartyAddr2(rs.getString(COL_THIRD_PARTY_ADDR2));
        fgormfu.setThirdPartyAddr3(rs.getString(COL_THIRD_PARTY_ADDR3));
        fgormfu.setConsignorName(rs.getString(COL_CONSIGNOR_NAME));
        fgormfu.setConsignorAddr1(rs.getString(COL_CONSIGNOR_ADDR1));
        fgormfu.setConsignorAddr2(rs.getString(COL_CONSIGNOR_ADDR2));
        fgormfu.setConsignorAddr3(rs.getString(COL_CONSIGNOR_ADDR3));
        fgormfu.setConsigneeName(rs.getString(COL_CONSIGNEE_NAME));
        fgormfu.setConsigneeAddr1(rs.getString(COL_CONSIGNEE_ADDR1));
        fgormfu.setConsigneeAddr2(rs.getString(COL_CONSIGNEE_ADDR2));
        fgormfu.setConsigneeAddr3(rs.getString(COL_CONSIGNEE_ADDR3));
        fgormfu.setBoeDate(rs.getString(COL_BOE_DATE));
        fgormfu.setSupplierBankSwift(rs.getString(COL_SUPPLIER_BANK_SWIFT));
        fgormfu.setFxDealRef(rs.getString(COL_FX_DEAL_REF));
        fgormfu.setGoodsDesc(rs.getString(COL_GOODS_DESC));
        fgormfu.setPurposeOfPayment(rs.getString(COL_PURPOSE_OF_PAYMENT));
        fgormfu.setGstin(rs.getString(COL_GSTIN));
        java.math.BigDecimal CHARGE_ACCTNO = rs.getObject(COL_CHARGE_ACCTNO, java.math.BigDecimal.class);
        fgormfu.setChargeAcctno(CHARGE_ACCTNO);
        fgormfu.setSupplierInstruction(rs.getString(COL_SUPPLIER_INSTRUCTION));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgormfu.setUploadRefID(UPLOAD_REF_ID);
        fgormfu.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        fgormfu.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        fgormfu.setFccStatus(rs.getString(COL_FCC_STATUS));
        fgormfu.setFccStage(rs.getString(COL_FCC_STAGE));
        fgormfu.setFccComments(rs.getString(COL_FCC_COMMENTS));
        fgormfu.setBeneCurrency(rs.getString(COL_BENE_CURRENCY));
        fgormfu.setIssuingBankName(rs.getString(COL_ISSUING_BANK_NAME));
        fgormfu.setTxnStatus(rs.getString(COL_TXN_STATUS));
        fgormfu.setTxnReference(rs.getString(COL_TXN_REFERENCE));
        fgormfu.setFileName(rs.getString(COL_FILE_NAME));
        fgormfu.setAPIErrorDesc(rs.getString(COL_API_ERROR_DESC));
        fgormfu.setLineNo(rs.getString(COL_LINE_NO));
        fgormfu.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgormfu.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal RATE_DETAILS = rs.getObject(COL_RATE_DETAILS, java.math.BigDecimal.class);
        fgormfu.setRateDetails(RATE_DETAILS);
        fgormfu.setDealType(rs.getString(COL_DEAL_TYPE));
        fgormfu.setBeneBanSwift(rs.getString(COL_BENE_BAN_SWIFT));
        fgormfu.setBankAbbvName(rs.getString(COL_BANK_ABBV_NAME));
        return fgormfu;
    }
}
