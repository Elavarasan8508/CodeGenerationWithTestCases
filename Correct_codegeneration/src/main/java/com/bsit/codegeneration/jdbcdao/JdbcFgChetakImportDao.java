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

public class JdbcFgChetakImportDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgChetakImportDao.class);

    private static final String TABLE = "FG_CHETAK_IMPORT";

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

    private static final String COL_THEIR_REF = "THEIR_REF";

    private static final String COL_COLLECTING_BANK = "COLLECTING_BANK";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_DRAWER = "DRAWER";

    private static final String COL_DRAWEE_CUSTOMER_ID = "DRAWEE_CUSTOMER_ID";

    private static final String COL_DRAWEE_NAME_ADDRESS = "DRAWEE_NAME_ADDRESS";

    private static final String COL_DRAWEE_COUNTRY = "DRAWEE_COUNTRY";

    private static final String COL_CHARGE_DEBIT_ACC_NO = "CHARGE_DEBIT_ACC_NO";

    private static final String COL_COLLECTION_AMOUNT = "COLLECTION_AMOUNT";

    private static final String COL_COLLECTION_CURRENCY = "COLLECTION_CURRENCY";

    private static final String COL_SHIPMENT_TO_COUNTRY = "SHIPMENT_TO_COUNTRY";

    private static final String COL_SHIPMENT_FROM_COUNTRY = "SHIPMENT_FROM_COUNTRY";

    private static final String COL_HS_CODE = "HS_CODE";

    private static final String COL_GOODS_CODE = "GOODS_CODE";

    private static final String COL_GOODS_DESCRIPTION = "GOODS_DESCRIPTION";

    private static final String COL_INCOTERMS = "INCOTERMS";

    private static final String COL_PORT_OF_DESTINATION = "PORT_OF_DESTINATION";

    private static final String COL_PORT_OF_LOADING = "PORT_OF_LOADING";

    private static final String COL_TRANSPORT_DOC_NUMBER = "TRANSPORT_DOC_NUMBER";

    private static final String COL_TRANSPORT_DOC_DATE = "TRANSPORT_DOC_DATE";

    private static final String COL_INVOICE_NO = "INVOICE_NO";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_FORM_TYPE = "FORM_TYPE";

    private static final String COL_SHIPPING_BILL_NO = "SHIPPING_BILL_NO";

    private static final String COL_BILL_DATE = "BILL_DATE";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_FORM_NO = "FORM_NO";

    private static final String COL_SHIPPING_AMOUNT = "SHIPPING_AMOUNT";

    private static final String COL_SHIPPING_CURRENCY = "SHIPPING_CURRENCY";

    private static final String COL_REASON_SHORT_SHP_AMT = "REASON_SHORT_SHP_AMT";

    private static final String COL_SHORT_SHP_AMT = "SHORT_SHP_AMT";

    private static final String COL_REPAYMENT_AMOUNT = "REPAYMENT_AMOUNT";

    private static final String COL_SHORT_COLLECTION_AMT = "SHORT_COLLECTION_AMT";

    private static final String COL_REMITTANCE_NO = "REMITTANCE_NO";

    private static final String COL_FIRC_NO = "FIRC_NO";

    private static final String COL_REMITTANCE_AMT = "REMITTANCE_AMT";

    private static final String COL_UTILIZATION_AMT = "UTILIZATION_AMT";

    private static final String COL_REMITTANCE_AD_CODE = "REMITTANCE_AD_CODE";

    private static final String COL_REMITERS_NAME = "REMITERS_NAME";

    private static final String COL_REMITERS_DATE = "REMITERS_DATE";

    private static final String COL_REMITER_COUNTRY = "REMITER_COUNTRY";

    private static final String COL_CIF_NO = "CIF_NO";

    private static final String COL_LEO_DATE = "LEO_DATE";

    private static final String COL_EXPORT_AGENCY = "EXPORT_AGENCY";

    private static final String COL_EXPORT_TYPE = "EXPORT_TYPE";

    private static final String COL_DESTINATION_COUNTRY = "DESTINATION_COUNTRY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_CUSTOMS_NO = "CUSTOMS_NO";

    private static final String COL_SHIPPING_INV_SR_NO = "SHIPPING_INV_SR_NO";

    private static final String COL_SHIPPING_INV_NO = "SHIPPING_INV_NO";

    private static final String COL_SHIPPING_INV_DATE = "SHIPPING_INV_DATE";

    private static final String COL_FOB_AMOUNT = "FOB_AMOUNT";

    private static final String COL_FRIGHT_AMOUNT = "FRIGHT_AMOUNT";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_COMMISSION_AMT = "COMMISSION_AMT";

    private static final String COL_DISCOUNT_AMT = "DISCOUNT_AMT";

    private static final String COL_DEDUCTION_AMT = "DEDUCTION_AMT";

    private static final String COL_PACKAGE_AMT = "PACKAGE_AMT";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_EQUIVALENT_AMOUNT = "EQUIVALENT_AMOUNT";

    private static final String COL_EQUIVALENT_CURRENCY = "EQUIVALENT_CURRENCY";

    private static final String COL_DISPLAY_CURRENCY = "DISPLAY_CURRENCY";

    private static final String COL_DISPLAY_AMOUNT = "DISPLAY_AMOUNT";

    private static final String COL_AUTH_EQUIVALENT_AMOUNT = "AUTH_EQUIVALENT_AMOUNT";

    private static final String COL_AUTH_EQUIVALENT_CURRENCY = "AUTH_EQUIVALENT_CURRENCY";

    private static final String COL_DISPLAY_EQUIVALENT_AMOUNT = "DISPLAY_EQUIVALENT_AMOUNT";

    private static final String COL_DISPLAY_EQUIVALENT_CURRENCY = "DISPLAY_EQUIVALENT_CURRENCY";

    private static final String COL_AUTH_FX_BASE_RATE = "AUTH_FX_BASE_RATE";

    private static final String COL_DISPLAY_FX_BASE_RATE = "DISPLAY_FX_BASE_RATE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_THEIR_REF, COL_COLLECTING_BANK, COL_BEHALF_OF_BRANCH, COL_DRAWER, COL_DRAWEE_CUSTOMER_ID, COL_DRAWEE_NAME_ADDRESS, COL_DRAWEE_COUNTRY, COL_CHARGE_DEBIT_ACC_NO, COL_COLLECTION_AMOUNT, COL_COLLECTION_CURRENCY, COL_SHIPMENT_TO_COUNTRY, COL_SHIPMENT_FROM_COUNTRY, COL_HS_CODE, COL_GOODS_CODE, COL_GOODS_DESCRIPTION, COL_INCOTERMS, COL_PORT_OF_DESTINATION, COL_PORT_OF_LOADING, COL_TRANSPORT_DOC_NUMBER, COL_TRANSPORT_DOC_DATE, COL_INVOICE_NO, COL_INVOICE_DATE, COL_FORM_TYPE, COL_SHIPPING_BILL_NO, COL_BILL_DATE, COL_PORT_CODE, COL_FORM_NO, COL_SHIPPING_AMOUNT, COL_SHIPPING_CURRENCY, COL_REASON_SHORT_SHP_AMT, COL_SHORT_SHP_AMT, COL_REPAYMENT_AMOUNT, COL_SHORT_COLLECTION_AMT, COL_REMITTANCE_NO, COL_FIRC_NO, COL_REMITTANCE_AMT, COL_UTILIZATION_AMT, COL_REMITTANCE_AD_CODE, COL_REMITERS_NAME, COL_REMITERS_DATE, COL_REMITER_COUNTRY, COL_CIF_NO, COL_LEO_DATE, COL_EXPORT_AGENCY, COL_EXPORT_TYPE, COL_DESTINATION_COUNTRY, COL_IE_CODE, COL_AD_CODE, COL_CUSTOMS_NO, COL_SHIPPING_INV_SR_NO, COL_SHIPPING_INV_NO, COL_SHIPPING_INV_DATE, COL_FOB_AMOUNT, COL_FRIGHT_AMOUNT, COL_INS_AMT, COL_COMMISSION_AMT, COL_DISCOUNT_AMT, COL_DEDUCTION_AMT, COL_PACKAGE_AMT, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_CURRENCY, COL_DISPLAY_AMOUNT, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, THEIR_REF, COLLECTING_BANK, BEHALF_OF_BRANCH, DRAWER, DRAWEE_CUSTOMER_ID, DRAWEE_NAME_ADDRESS, DRAWEE_COUNTRY, CHARGE_DEBIT_ACC_NO, COLLECTION_AMOUNT, COLLECTION_CURRENCY, SHIPMENT_TO_COUNTRY, SHIPMENT_FROM_COUNTRY, HS_CODE, GOODS_CODE, GOODS_DESCRIPTION, INCOTERMS, PORT_OF_DESTINATION, PORT_OF_LOADING, TRANSPORT_DOC_NUMBER, TRANSPORT_DOC_DATE, INVOICE_NO, INVOICE_DATE, FORM_TYPE, SHIPPING_BILL_NO, BILL_DATE, PORT_CODE, FORM_NO, SHIPPING_AMOUNT, SHIPPING_CURRENCY, REASON_SHORT_SHP_AMT, SHORT_SHP_AMT, REPAYMENT_AMOUNT, SHORT_COLLECTION_AMT, REMITTANCE_NO, FIRC_NO, REMITTANCE_AMT, UTILIZATION_AMT, REMITTANCE_AD_CODE, REMITERS_NAME, REMITERS_DATE, REMITER_COUNTRY, CIF_NO, LEO_DATE, EXPORT_AGENCY, EXPORT_TYPE, DESTINATION_COUNTRY, IE_CODE, AD_CODE, CUSTOMS_NO, SHIPPING_INV_SR_NO, SHIPPING_INV_NO, SHIPPING_INV_DATE, FOB_AMOUNT, FRIGHT_AMOUNT, INS_AMT, COMMISSION_AMT, DISCOUNT_AMT, DEDUCTION_AMT, PACKAGE_AMT, UPLOAD_REF_ID, LINE_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_CURRENCY, DISPLAY_AMOUNT, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, THEIR_REF, COLLECTING_BANK, BEHALF_OF_BRANCH, DRAWER, DRAWEE_CUSTOMER_ID, DRAWEE_NAME_ADDRESS, DRAWEE_COUNTRY, CHARGE_DEBIT_ACC_NO, COLLECTION_AMOUNT, COLLECTION_CURRENCY, SHIPMENT_TO_COUNTRY, SHIPMENT_FROM_COUNTRY, HS_CODE, GOODS_CODE, GOODS_DESCRIPTION, INCOTERMS, PORT_OF_DESTINATION, PORT_OF_LOADING, TRANSPORT_DOC_NUMBER, TRANSPORT_DOC_DATE, INVOICE_NO, INVOICE_DATE, FORM_TYPE, SHIPPING_BILL_NO, BILL_DATE, PORT_CODE, FORM_NO, SHIPPING_AMOUNT, SHIPPING_CURRENCY, REASON_SHORT_SHP_AMT, SHORT_SHP_AMT, REPAYMENT_AMOUNT, SHORT_COLLECTION_AMT, REMITTANCE_NO, FIRC_NO, REMITTANCE_AMT, UTILIZATION_AMT, REMITTANCE_AD_CODE, REMITERS_NAME, REMITERS_DATE, REMITER_COUNTRY, CIF_NO, LEO_DATE, EXPORT_AGENCY, EXPORT_TYPE, DESTINATION_COUNTRY, IE_CODE, AD_CODE, CUSTOMS_NO, SHIPPING_INV_SR_NO, SHIPPING_INV_NO, SHIPPING_INV_DATE, FOB_AMOUNT, FRIGHT_AMOUNT, INS_AMT, COMMISSION_AMT, DISCOUNT_AMT, DEDUCTION_AMT, PACKAGE_AMT, UPLOAD_REF_ID, LINE_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_CURRENCY, DISPLAY_AMOUNT, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_THEIR_REF, COL_COLLECTING_BANK, COL_BEHALF_OF_BRANCH, COL_DRAWER, COL_DRAWEE_CUSTOMER_ID, COL_DRAWEE_NAME_ADDRESS, COL_DRAWEE_COUNTRY, COL_CHARGE_DEBIT_ACC_NO, COL_COLLECTION_AMOUNT, COL_COLLECTION_CURRENCY, COL_SHIPMENT_TO_COUNTRY, COL_SHIPMENT_FROM_COUNTRY, COL_HS_CODE, COL_GOODS_CODE, COL_GOODS_DESCRIPTION, COL_INCOTERMS, COL_PORT_OF_DESTINATION, COL_PORT_OF_LOADING, COL_TRANSPORT_DOC_NUMBER, COL_TRANSPORT_DOC_DATE, COL_INVOICE_NO, COL_INVOICE_DATE, COL_FORM_TYPE, COL_SHIPPING_BILL_NO, COL_BILL_DATE, COL_PORT_CODE, COL_FORM_NO, COL_SHIPPING_AMOUNT, COL_SHIPPING_CURRENCY, COL_REASON_SHORT_SHP_AMT, COL_SHORT_SHP_AMT, COL_REPAYMENT_AMOUNT, COL_SHORT_COLLECTION_AMT, COL_REMITTANCE_NO, COL_FIRC_NO, COL_REMITTANCE_AMT, COL_UTILIZATION_AMT, COL_REMITTANCE_AD_CODE, COL_REMITERS_NAME, COL_REMITERS_DATE, COL_REMITER_COUNTRY, COL_CIF_NO, COL_LEO_DATE, COL_EXPORT_AGENCY, COL_EXPORT_TYPE, COL_DESTINATION_COUNTRY, COL_IE_CODE, COL_AD_CODE, COL_CUSTOMS_NO, COL_SHIPPING_INV_SR_NO, COL_SHIPPING_INV_NO, COL_SHIPPING_INV_DATE, COL_FOB_AMOUNT, COL_FRIGHT_AMOUNT, COL_INS_AMT, COL_COMMISSION_AMT, COL_DISCOUNT_AMT, COL_DEDUCTION_AMT, COL_PACKAGE_AMT, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_CURRENCY, COL_DISPLAY_AMOUNT, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_ID);

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

    public int insert(Connection conn, FgChetakImport fgchetakimport) throws SQLException {
        logger.debug("Inserting fgchetakimport: {}", fgchetakimport);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgChetakImportParams(ps, fgchetakimport);
            ps.executeUpdate();
            return fgchetakimport.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgChetakImport> fgchetakimports) throws SQLException {
        if (fgchetakimports == null || fgchetakimports.isEmpty())
            return new int[0];
        for (int i = 0; i < fgchetakimports.size(); i++) {
            if (fgchetakimports.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChetakImport>> batches = chunkList(fgchetakimports, batchSize);
        int[] totalResults = new int[fgchetakimports.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChetakImport> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgChetakImport fgchetakimport : batch) {
                        setFgChetakImportParams(ps, fgchetakimport);
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

    public FgChetakImport findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgChetakImport> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgChetakImport> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgChetakImport fgchetakimport) throws SQLException {
        if (fgchetakimport.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgChetakImportParams(ps, fgchetakimport);
            ps.setInt(89, fgchetakimport.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgChetakImport> fgchetakimports) throws SQLException {
        if (fgchetakimports == null || fgchetakimports.isEmpty())
            return new int[0];
        for (FgChetakImport fgchetakimport : fgchetakimports) {
            if (fgchetakimport == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgchetakimport.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChetakImport>> batches = chunkList(fgchetakimports, batchSize);
        int[] totalResults = new int[fgchetakimports.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChetakImport> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgChetakImport fgchetakimport : batch) {
                        setFgChetakImportParams(ps, fgchetakimport);
                        ps.setInt(89, fgchetakimport.getID());
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

    private void setFgChetakImportParams(PreparedStatement ps, FgChetakImport fgchetakimport) throws SQLException {
        Integer val1 = fgchetakimport.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgchetakimport.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgchetakimport.getTypeCode());
        ps.setString(4, fgchetakimport.getSubTypeCode());
        ps.setString(5, fgchetakimport.getActiveCode());
        ps.setString(6, fgchetakimport.getStageCode());
        ps.setString(7, fgchetakimport.getStatusCode());
        ps.setString(8, fgchetakimport.getCreatedOn());
        java.math.BigDecimal val9 = fgchetakimport.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgchetakimport.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgchetakimport.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgchetakimport.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgchetakimport.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgchetakimport.getTemplate());
        java.math.BigDecimal val15 = fgchetakimport.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgchetakimport.getTheirRef());
        ps.setString(17, fgchetakimport.getCollectingBank());
        ps.setString(18, fgchetakimport.getBehalfOfBranch());
        ps.setString(19, fgchetakimport.getDrawer());
        Integer val20 = fgchetakimport.getDraweeCustomerID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        ps.setString(21, fgchetakimport.getDraweeNameAddress());
        ps.setString(22, fgchetakimport.getDraweeCountry());
        ps.setString(23, fgchetakimport.getChargeDebitAccNo());
        java.math.BigDecimal val24 = fgchetakimport.getCollectionAmount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgchetakimport.getCollectionCurrency());
        ps.setString(26, fgchetakimport.getShipmentToCountry());
        ps.setString(27, fgchetakimport.getShipmentFromCountry());
        ps.setString(28, fgchetakimport.getHsCode());
        ps.setString(29, fgchetakimport.getGoodsCode());
        ps.setString(30, fgchetakimport.getGoodsDescription());
        ps.setString(31, fgchetakimport.getIncoterms());
        ps.setString(32, fgchetakimport.getPortOfDestination());
        ps.setString(33, fgchetakimport.getPortOfLoading());
        ps.setString(34, fgchetakimport.getTransportDocNumber());
        java.time.LocalDateTime val35 = fgchetakimport.getTransportDocDate();
        if (val35 != null) {
            ps.setTimestamp(35, java.sql.Timestamp.valueOf(val35));
        } else {
            ps.setNull(35, Types.TIMESTAMP);
        }
        ps.setString(36, fgchetakimport.getInvoiceNo());
        java.time.LocalDateTime val37 = fgchetakimport.getInvoiceDate();
        if (val37 != null) {
            ps.setTimestamp(37, java.sql.Timestamp.valueOf(val37));
        } else {
            ps.setNull(37, Types.TIMESTAMP);
        }
        ps.setString(38, fgchetakimport.getFormType());
        ps.setString(39, fgchetakimport.getShippingBillNo());
        java.time.LocalDateTime val40 = fgchetakimport.getBillDate();
        if (val40 != null) {
            ps.setTimestamp(40, java.sql.Timestamp.valueOf(val40));
        } else {
            ps.setNull(40, Types.TIMESTAMP);
        }
        ps.setString(41, fgchetakimport.getPortCode());
        ps.setString(42, fgchetakimport.getFormNo());
        java.math.BigDecimal val43 = fgchetakimport.getShippingAmount();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, fgchetakimport.getShippingCurrency());
        java.math.BigDecimal val45 = fgchetakimport.getReasonShortShpAmt();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = fgchetakimport.getShortShpAmt();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = fgchetakimport.getRepaymentAmount();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = fgchetakimport.getShortCollectionAmt();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, fgchetakimport.getRemittanceNo());
        ps.setString(50, fgchetakimport.getFircNo());
        java.math.BigDecimal val51 = fgchetakimport.getRemittanceAmt();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        java.math.BigDecimal val52 = fgchetakimport.getUtilizationAmt();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        ps.setString(53, fgchetakimport.getRemittanceAdCode());
        ps.setString(54, fgchetakimport.getRemitersName());
        java.time.LocalDateTime val55 = fgchetakimport.getRemitersDate();
        if (val55 != null) {
            ps.setTimestamp(55, java.sql.Timestamp.valueOf(val55));
        } else {
            ps.setNull(55, Types.TIMESTAMP);
        }
        ps.setString(56, fgchetakimport.getRemiterCountry());
        ps.setString(57, fgchetakimport.getCifNo());
        java.time.LocalDateTime val58 = fgchetakimport.getLeoDate();
        if (val58 != null) {
            ps.setTimestamp(58, java.sql.Timestamp.valueOf(val58));
        } else {
            ps.setNull(58, Types.TIMESTAMP);
        }
        ps.setString(59, fgchetakimport.getExportAgency());
        ps.setString(60, fgchetakimport.getExportType());
        ps.setString(61, fgchetakimport.getDestinationCountry());
        ps.setString(62, fgchetakimport.getIeCode());
        ps.setString(63, fgchetakimport.getAdCode());
        ps.setString(64, fgchetakimport.getCustomsNo());
        ps.setString(65, fgchetakimport.getShippingInvSrNo());
        ps.setString(66, fgchetakimport.getShippingInvNo());
        java.time.LocalDateTime val67 = fgchetakimport.getShippingInvDate();
        if (val67 != null) {
            ps.setTimestamp(67, java.sql.Timestamp.valueOf(val67));
        } else {
            ps.setNull(67, Types.TIMESTAMP);
        }
        java.math.BigDecimal val68 = fgchetakimport.getFobAmount();
        if (val68 != null) {
            ps.setBigDecimal(68, val68);
        } else {
            ps.setNull(68, Types.DECIMAL);
        }
        java.math.BigDecimal val69 = fgchetakimport.getFrightAmount();
        if (val69 != null) {
            ps.setBigDecimal(69, val69);
        } else {
            ps.setNull(69, Types.DECIMAL);
        }
        java.math.BigDecimal val70 = fgchetakimport.getInsAmt();
        if (val70 != null) {
            ps.setBigDecimal(70, val70);
        } else {
            ps.setNull(70, Types.DECIMAL);
        }
        java.math.BigDecimal val71 = fgchetakimport.getCommissionAmt();
        if (val71 != null) {
            ps.setBigDecimal(71, val71);
        } else {
            ps.setNull(71, Types.DECIMAL);
        }
        java.math.BigDecimal val72 = fgchetakimport.getDiscountAmt();
        if (val72 != null) {
            ps.setBigDecimal(72, val72);
        } else {
            ps.setNull(72, Types.DECIMAL);
        }
        java.math.BigDecimal val73 = fgchetakimport.getDeductionAmt();
        if (val73 != null) {
            ps.setBigDecimal(73, val73);
        } else {
            ps.setNull(73, Types.DECIMAL);
        }
        java.math.BigDecimal val74 = fgchetakimport.getPackageAmt();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        Integer val75 = fgchetakimport.getUploadRefID();
        if (val75 != null) {
            ps.setInt(75, val75);
        } else {
            ps.setNull(75, Types.INTEGER);
        }
        java.math.BigDecimal val76 = fgchetakimport.getLineNo();
        if (val76 != null) {
            ps.setBigDecimal(76, val76);
        } else {
            ps.setNull(76, Types.DECIMAL);
        }
        java.math.BigDecimal val77 = fgchetakimport.getEquivalentAmount();
        if (val77 != null) {
            ps.setBigDecimal(77, val77);
        } else {
            ps.setNull(77, Types.DECIMAL);
        }
        ps.setString(78, fgchetakimport.getEquivalentCurrency());
        ps.setString(79, fgchetakimport.getDisplayCurrency());
        java.math.BigDecimal val80 = fgchetakimport.getDisplayAmount();
        if (val80 != null) {
            ps.setBigDecimal(80, val80);
        } else {
            ps.setNull(80, Types.DECIMAL);
        }
        java.math.BigDecimal val81 = fgchetakimport.getAuthEquivalentAmount();
        if (val81 != null) {
            ps.setBigDecimal(81, val81);
        } else {
            ps.setNull(81, Types.DECIMAL);
        }
        ps.setString(82, fgchetakimport.getAuthEquivalentCurrency());
        java.math.BigDecimal val83 = fgchetakimport.getDisplayEquivalentAmount();
        if (val83 != null) {
            ps.setBigDecimal(83, val83);
        } else {
            ps.setNull(83, Types.DECIMAL);
        }
        ps.setString(84, fgchetakimport.getDisplayEquivalentCurrency());
        java.math.BigDecimal val85 = fgchetakimport.getAuthFxBaseRate();
        if (val85 != null) {
            ps.setBigDecimal(85, val85);
        } else {
            ps.setNull(85, Types.DECIMAL);
        }
        java.math.BigDecimal val86 = fgchetakimport.getDisplayFxBaseRate();
        if (val86 != null) {
            ps.setBigDecimal(86, val86);
        } else {
            ps.setNull(86, Types.DECIMAL);
        }
        ps.setString(87, fgchetakimport.getApplicantPartyCode());
        ps.setString(88, fgchetakimport.getIssuingPartyCode());
        ps.setString(89, fgchetakimport.getFileName());
    }

    private FgChetakImport extract(ResultSet rs) throws SQLException {
        FgChetakImport fgchetakimport = new FgChetakImport();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgchetakimport.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgchetakimport.setReferenceID(REFERENCE_ID);
        fgchetakimport.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgchetakimport.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgchetakimport.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgchetakimport.setStageCode(rs.getString(COL_STAGE_CODE));
        fgchetakimport.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgchetakimport.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgchetakimport.setCreatedBy(CREATED_BY);
        fgchetakimport.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgchetakimport.setLastUpdatedBy(LAST_UPDATED_BY);
        fgchetakimport.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgchetakimport.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgchetakimport.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgchetakimport.setIsTemplate(IS_TEMPLATE);
        fgchetakimport.setTheirRef(rs.getString(COL_THEIR_REF));
        fgchetakimport.setCollectingBank(rs.getString(COL_COLLECTING_BANK));
        fgchetakimport.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        fgchetakimport.setDrawer(rs.getString(COL_DRAWER));
        Integer DRAWEE_CUSTOMER_ID = rs.getObject(COL_DRAWEE_CUSTOMER_ID, Integer.class);
        fgchetakimport.setDraweeCustomerID(DRAWEE_CUSTOMER_ID);
        fgchetakimport.setDraweeNameAddress(rs.getString(COL_DRAWEE_NAME_ADDRESS));
        fgchetakimport.setDraweeCountry(rs.getString(COL_DRAWEE_COUNTRY));
        fgchetakimport.setChargeDebitAccNo(rs.getString(COL_CHARGE_DEBIT_ACC_NO));
        java.math.BigDecimal COLLECTION_AMOUNT = rs.getObject(COL_COLLECTION_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setCollectionAmount(COLLECTION_AMOUNT);
        fgchetakimport.setCollectionCurrency(rs.getString(COL_COLLECTION_CURRENCY));
        fgchetakimport.setShipmentToCountry(rs.getString(COL_SHIPMENT_TO_COUNTRY));
        fgchetakimport.setShipmentFromCountry(rs.getString(COL_SHIPMENT_FROM_COUNTRY));
        fgchetakimport.setHsCode(rs.getString(COL_HS_CODE));
        fgchetakimport.setGoodsCode(rs.getString(COL_GOODS_CODE));
        fgchetakimport.setGoodsDescription(rs.getString(COL_GOODS_DESCRIPTION));
        fgchetakimport.setIncoterms(rs.getString(COL_INCOTERMS));
        fgchetakimport.setPortOfDestination(rs.getString(COL_PORT_OF_DESTINATION));
        fgchetakimport.setPortOfLoading(rs.getString(COL_PORT_OF_LOADING));
        fgchetakimport.setTransportDocNumber(rs.getString(COL_TRANSPORT_DOC_NUMBER));
        Timestamp TRANSPORT_DOC_DATE = rs.getTimestamp(COL_TRANSPORT_DOC_DATE);
        if (TRANSPORT_DOC_DATE != null)
            fgchetakimport.setTransportDocDate(TRANSPORT_DOC_DATE.toLocalDateTime());
        fgchetakimport.setInvoiceNo(rs.getString(COL_INVOICE_NO));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fgchetakimport.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        fgchetakimport.setFormType(rs.getString(COL_FORM_TYPE));
        fgchetakimport.setShippingBillNo(rs.getString(COL_SHIPPING_BILL_NO));
        Timestamp BILL_DATE = rs.getTimestamp(COL_BILL_DATE);
        if (BILL_DATE != null)
            fgchetakimport.setBillDate(BILL_DATE.toLocalDateTime());
        fgchetakimport.setPortCode(rs.getString(COL_PORT_CODE));
        fgchetakimport.setFormNo(rs.getString(COL_FORM_NO));
        java.math.BigDecimal SHIPPING_AMOUNT = rs.getObject(COL_SHIPPING_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setShippingAmount(SHIPPING_AMOUNT);
        fgchetakimport.setShippingCurrency(rs.getString(COL_SHIPPING_CURRENCY));
        java.math.BigDecimal REASON_SHORT_SHP_AMT = rs.getObject(COL_REASON_SHORT_SHP_AMT, java.math.BigDecimal.class);
        fgchetakimport.setReasonShortShpAmt(REASON_SHORT_SHP_AMT);
        java.math.BigDecimal SHORT_SHP_AMT = rs.getObject(COL_SHORT_SHP_AMT, java.math.BigDecimal.class);
        fgchetakimport.setShortShpAmt(SHORT_SHP_AMT);
        java.math.BigDecimal REPAYMENT_AMOUNT = rs.getObject(COL_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setRepaymentAmount(REPAYMENT_AMOUNT);
        java.math.BigDecimal SHORT_COLLECTION_AMT = rs.getObject(COL_SHORT_COLLECTION_AMT, java.math.BigDecimal.class);
        fgchetakimport.setShortCollectionAmt(SHORT_COLLECTION_AMT);
        fgchetakimport.setRemittanceNo(rs.getString(COL_REMITTANCE_NO));
        fgchetakimport.setFircNo(rs.getString(COL_FIRC_NO));
        java.math.BigDecimal REMITTANCE_AMT = rs.getObject(COL_REMITTANCE_AMT, java.math.BigDecimal.class);
        fgchetakimport.setRemittanceAmt(REMITTANCE_AMT);
        java.math.BigDecimal UTILIZATION_AMT = rs.getObject(COL_UTILIZATION_AMT, java.math.BigDecimal.class);
        fgchetakimport.setUtilizationAmt(UTILIZATION_AMT);
        fgchetakimport.setRemittanceAdCode(rs.getString(COL_REMITTANCE_AD_CODE));
        fgchetakimport.setRemitersName(rs.getString(COL_REMITERS_NAME));
        Timestamp REMITERS_DATE = rs.getTimestamp(COL_REMITERS_DATE);
        if (REMITERS_DATE != null)
            fgchetakimport.setRemitersDate(REMITERS_DATE.toLocalDateTime());
        fgchetakimport.setRemiterCountry(rs.getString(COL_REMITER_COUNTRY));
        fgchetakimport.setCifNo(rs.getString(COL_CIF_NO));
        Timestamp LEO_DATE = rs.getTimestamp(COL_LEO_DATE);
        if (LEO_DATE != null)
            fgchetakimport.setLeoDate(LEO_DATE.toLocalDateTime());
        fgchetakimport.setExportAgency(rs.getString(COL_EXPORT_AGENCY));
        fgchetakimport.setExportType(rs.getString(COL_EXPORT_TYPE));
        fgchetakimport.setDestinationCountry(rs.getString(COL_DESTINATION_COUNTRY));
        fgchetakimport.setIeCode(rs.getString(COL_IE_CODE));
        fgchetakimport.setAdCode(rs.getString(COL_AD_CODE));
        fgchetakimport.setCustomsNo(rs.getString(COL_CUSTOMS_NO));
        fgchetakimport.setShippingInvSrNo(rs.getString(COL_SHIPPING_INV_SR_NO));
        fgchetakimport.setShippingInvNo(rs.getString(COL_SHIPPING_INV_NO));
        Timestamp SHIPPING_INV_DATE = rs.getTimestamp(COL_SHIPPING_INV_DATE);
        if (SHIPPING_INV_DATE != null)
            fgchetakimport.setShippingInvDate(SHIPPING_INV_DATE.toLocalDateTime());
        java.math.BigDecimal FOB_AMOUNT = rs.getObject(COL_FOB_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setFobAmount(FOB_AMOUNT);
        java.math.BigDecimal FRIGHT_AMOUNT = rs.getObject(COL_FRIGHT_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setFrightAmount(FRIGHT_AMOUNT);
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgchetakimport.setInsAmt(INS_AMT);
        java.math.BigDecimal COMMISSION_AMT = rs.getObject(COL_COMMISSION_AMT, java.math.BigDecimal.class);
        fgchetakimport.setCommissionAmt(COMMISSION_AMT);
        java.math.BigDecimal DISCOUNT_AMT = rs.getObject(COL_DISCOUNT_AMT, java.math.BigDecimal.class);
        fgchetakimport.setDiscountAmt(DISCOUNT_AMT);
        java.math.BigDecimal DEDUCTION_AMT = rs.getObject(COL_DEDUCTION_AMT, java.math.BigDecimal.class);
        fgchetakimport.setDeductionAmt(DEDUCTION_AMT);
        java.math.BigDecimal PACKAGE_AMT = rs.getObject(COL_PACKAGE_AMT, java.math.BigDecimal.class);
        fgchetakimport.setPackageAmt(PACKAGE_AMT);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgchetakimport.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgchetakimport.setLineNo(LINE_NO);
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgchetakimport.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        fgchetakimport.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setDisplayAmount(DISPLAY_AMOUNT);
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgchetakimport.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakimport.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgchetakimport.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgchetakimport.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgchetakimport.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgchetakimport.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgchetakimport.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgchetakimport.setFileName(rs.getString(COL_FILE_NAME));
        return fgchetakimport;
    }
}
