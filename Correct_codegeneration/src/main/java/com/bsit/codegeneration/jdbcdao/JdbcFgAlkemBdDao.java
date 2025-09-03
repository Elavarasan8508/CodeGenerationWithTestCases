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

public class JdbcFgAlkemBdDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAlkemBdDao.class);

    private static final String TABLE = "FG_ALKEM_BD";

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

    private static final String COL_INVOICE_CURRENCY = "INVOICE_CURRENCY";

    private static final String COL_EXPORT_COUNTRY_SAP = "EXPORT_COUNTRY_SAP";

    private static final String COL_CUSTOMER_DESCRIPTION = "CUSTOMER_DESCRIPTION";

    private static final String COL_COUNTRY_SOLD_TO_PART = "COUNTRY_SOLD_TO_PART";

    private static final String COL_COUNTRY_CODE_SOLD_TO = "COUNTRY_CODE_SOLD_TO";

    private static final String COL_B_L_AWB_NO = "B_L_AWB_NO";

    private static final String COL_BILL_OF_LANDING_AWB = "BILL_OF_LANDING_AWB";

    private static final String COL_MATERIAL_NO = "MATERIAL_NO";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_FINAL_INV_NO = "FINAL_INV_NO";

    private static final String COL_FINAL_INV_DATE = "FINAL_INV_DATE";

    private static final String COL_CUSTOMS_INV_NO = "CUSTOMS_INV_NO";

    private static final String COL_CUSTOMS_INV_DATE = "CUSTOMS_INV_DATE";

    private static final String COL_SHIPPING_BILL_NO = "SHIPPING_BILL_NO";

    private static final String COL_SHIPPING_BILL_DATE = "SHIPPING_BILL_DATE";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_PORT_LOAD = "PORT_LOAD";

    private static final String COL_BILL_DUE_DATE = "BILL_DUE_DATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_IEC_CODE = "IEC_CODE";

    private static final String COL_FINAL_INV_AMOUNT = "FINAL_INV_AMOUNT";

    private static final String COL_INVOICE_VALUE = "INVOICE_VALUE";

    private static final String COL_INVOICE_QUANTITY = "INVOICE_QUANTITY";

    private static final String COL_DECLARED_DEDUCTED = "DECLARED_DEDUCTED";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_HS_CODE = "HS_CODE";

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

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_BANK_REF_NO = "BANK_REF_NO";

    private static final String COL_BASE_DATE = "BASE_DATE";

    private static final String COL_BILL_AMOUNT = "BILL_AMOUNT";

    private static final String COL_BILL_CCY = "BILL_CCY";

    private static final String COL_BUYER_COUNTRY1 = "BUYER_COUNTRY1";

    private static final String COL_BUYER_COUNTRY2 = "BUYER_COUNTRY2";

    private static final String COL_BUYER_ID = "BUYER_ID";

    private static final String COL_BUYER_NAME = "BUYER_NAME";

    private static final String COL_CHARGES_DBT_ACC_NO = "CHARGES_DBT_ACC_NO";

    private static final String COL_COLLECTING_BANK = "COLLECTING_BANK";

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_DEST_PORT_CODE = "DEST_PORT_CODE";

    private static final String COL_GOODS_CODE = "GOODS_CODE";

    private static final String COL_GOODS_DESC = "GOODS_DESC";

    private static final String COL_HSN_CODE = "HSN_CODE";

    private static final String COL_INCOTERMS = "INCOTERMS";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_PORD_CODE_FOR_LOADING = "PORD_CODE_FOR_LOADING";

    private static final String COL_SHIPPING_BILL_AMOUNT = "SHIPPING_BILL_AMOUNT";

    private static final String COL_SHIPPING_BILL_CCY = "SHIPPING_BILL_CCY";

    private static final String COL_SOFTEX_NUMBER = "SOFTEX_NUMBER";

    private static final String COL_TENOR_IN_DAYS = "TENOR_IN_DAYS";

    private static final String COL_THIRD_PARTY = "THIRD_PARTY";

    private static final String COL_THIRD_PARTY_ADD = "THIRD_PARTY_ADD";

    private static final String COL_THIRD_PARTY_COUNTRY = "THIRD_PARTY_COUNTRY";

    private static final String COL_THIRD_PARTY_NAME = "THIRD_PARTY_NAME";

    private static final String COL_VESSEL_O_FLIGHT_NAME = "VESSEL_O_FLIGHT_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INVOICE_CURRENCY, COL_EXPORT_COUNTRY_SAP, COL_CUSTOMER_DESCRIPTION, COL_COUNTRY_SOLD_TO_PART, COL_COUNTRY_CODE_SOLD_TO, COL_B_L_AWB_NO, COL_BILL_OF_LANDING_AWB, COL_MATERIAL_NO, COL_PRODUCT_DESCRIPTION, COL_FINAL_INV_NO, COL_FINAL_INV_DATE, COL_CUSTOMS_INV_NO, COL_CUSTOMS_INV_DATE, COL_SHIPPING_BILL_NO, COL_SHIPPING_BILL_DATE, COL_PORT_CODE, COL_PORT_LOAD, COL_BILL_DUE_DATE, COL_UPLOAD_REF_ID, COL_IEC_CODE, COL_FINAL_INV_AMOUNT, COL_INVOICE_VALUE, COL_INVOICE_QUANTITY, COL_DECLARED_DEDUCTED, COL_LINE_NO, COL_HS_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_BANK_REF_NO, COL_BASE_DATE, COL_BILL_AMOUNT, COL_BILL_CCY, COL_BUYER_COUNTRY1, COL_BUYER_COUNTRY2, COL_BUYER_ID, COL_BUYER_NAME, COL_CHARGES_DBT_ACC_NO, COL_COLLECTING_BANK, COL_CUSTOMER_CRN, COL_DEST_PORT_CODE, COL_GOODS_CODE, COL_GOODS_DESC, COL_HSN_CODE, COL_INCOTERMS, COL_INV_DATE, COL_INV_NO, COL_PORD_CODE_FOR_LOADING, COL_SHIPPING_BILL_AMOUNT, COL_SHIPPING_BILL_CCY, COL_SOFTEX_NUMBER, COL_TENOR_IN_DAYS, COL_THIRD_PARTY, COL_THIRD_PARTY_ADD, COL_THIRD_PARTY_COUNTRY, COL_THIRD_PARTY_NAME, COL_VESSEL_O_FLIGHT_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, BILL_DUE_DATE, UPLOAD_REF_ID, IEC_CODE, FINAL_INV_AMOUNT, INVOICE_VALUE, INVOICE_QUANTITY, DECLARED_DEDUCTED, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME, BANK_REF_NO, BASE_DATE, BILL_AMOUNT, BILL_CCY, BUYER_COUNTRY1, BUYER_COUNTRY2, BUYER_ID, BUYER_NAME, CHARGES_DBT_ACC_NO, COLLECTING_BANK, CUSTOMER_CRN, DEST_PORT_CODE, GOODS_CODE, GOODS_DESC, HSN_CODE, INCOTERMS, INV_DATE, INV_NO, PORD_CODE_FOR_LOADING, SHIPPING_BILL_AMOUNT, SHIPPING_BILL_CCY, SOFTEX_NUMBER, TENOR_IN_DAYS, THIRD_PARTY, THIRD_PARTY_ADD, THIRD_PARTY_COUNTRY, THIRD_PARTY_NAME, VESSEL_O_FLIGHT_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, BILL_DUE_DATE, UPLOAD_REF_ID, IEC_CODE, FINAL_INV_AMOUNT, INVOICE_VALUE, INVOICE_QUANTITY, DECLARED_DEDUCTED, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME, BANK_REF_NO, BASE_DATE, BILL_AMOUNT, BILL_CCY, BUYER_COUNTRY1, BUYER_COUNTRY2, BUYER_ID, BUYER_NAME, CHARGES_DBT_ACC_NO, COLLECTING_BANK, CUSTOMER_CRN, DEST_PORT_CODE, GOODS_CODE, GOODS_DESC, HSN_CODE, INCOTERMS, INV_DATE, INV_NO, PORD_CODE_FOR_LOADING, SHIPPING_BILL_AMOUNT, SHIPPING_BILL_CCY, SOFTEX_NUMBER, TENOR_IN_DAYS, THIRD_PARTY, THIRD_PARTY_ADD, THIRD_PARTY_COUNTRY, THIRD_PARTY_NAME, VESSEL_O_FLIGHT_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INVOICE_CURRENCY, COL_EXPORT_COUNTRY_SAP, COL_CUSTOMER_DESCRIPTION, COL_COUNTRY_SOLD_TO_PART, COL_COUNTRY_CODE_SOLD_TO, COL_B_L_AWB_NO, COL_BILL_OF_LANDING_AWB, COL_MATERIAL_NO, COL_PRODUCT_DESCRIPTION, COL_FINAL_INV_NO, COL_FINAL_INV_DATE, COL_CUSTOMS_INV_NO, COL_CUSTOMS_INV_DATE, COL_SHIPPING_BILL_NO, COL_SHIPPING_BILL_DATE, COL_PORT_CODE, COL_PORT_LOAD, COL_BILL_DUE_DATE, COL_UPLOAD_REF_ID, COL_IEC_CODE, COL_FINAL_INV_AMOUNT, COL_INVOICE_VALUE, COL_INVOICE_QUANTITY, COL_DECLARED_DEDUCTED, COL_LINE_NO, COL_HS_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_BANK_REF_NO, COL_BASE_DATE, COL_BILL_AMOUNT, COL_BILL_CCY, COL_BUYER_COUNTRY1, COL_BUYER_COUNTRY2, COL_BUYER_ID, COL_BUYER_NAME, COL_CHARGES_DBT_ACC_NO, COL_COLLECTING_BANK, COL_CUSTOMER_CRN, COL_DEST_PORT_CODE, COL_GOODS_CODE, COL_GOODS_DESC, COL_HSN_CODE, COL_INCOTERMS, COL_INV_DATE, COL_INV_NO, COL_PORD_CODE_FOR_LOADING, COL_SHIPPING_BILL_AMOUNT, COL_SHIPPING_BILL_CCY, COL_SOFTEX_NUMBER, COL_TENOR_IN_DAYS, COL_THIRD_PARTY, COL_THIRD_PARTY_ADD, COL_THIRD_PARTY_COUNTRY, COL_THIRD_PARTY_NAME, COL_VESSEL_O_FLIGHT_NAME, COL_ID);

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

    public int insert(Connection conn, FgAlkemBd fgalkembd) throws SQLException {
        logger.debug("Inserting fgalkembd: {}", fgalkembd);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAlkemBdParams(ps, fgalkembd);
            ps.executeUpdate();
            return fgalkembd.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAlkemBd> fgalkembds) throws SQLException {
        if (fgalkembds == null || fgalkembds.isEmpty())
            return new int[0];
        for (int i = 0; i < fgalkembds.size(); i++) {
            if (fgalkembds.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlkemBd>> batches = chunkList(fgalkembds, batchSize);
        int[] totalResults = new int[fgalkembds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlkemBd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAlkemBd fgalkembd : batch) {
                        setFgAlkemBdParams(ps, fgalkembd);
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

    public FgAlkemBd findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAlkemBd> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAlkemBd> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAlkemBd fgalkembd) throws SQLException {
        if (fgalkembd.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAlkemBdParams(ps, fgalkembd);
            ps.setInt(82, fgalkembd.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAlkemBd> fgalkembds) throws SQLException {
        if (fgalkembds == null || fgalkembds.isEmpty())
            return new int[0];
        for (FgAlkemBd fgalkembd : fgalkembds) {
            if (fgalkembd == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgalkembd.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlkemBd>> batches = chunkList(fgalkembds, batchSize);
        int[] totalResults = new int[fgalkembds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlkemBd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAlkemBd fgalkembd : batch) {
                        setFgAlkemBdParams(ps, fgalkembd);
                        ps.setInt(82, fgalkembd.getID());
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

    private void setFgAlkemBdParams(PreparedStatement ps, FgAlkemBd fgalkembd) throws SQLException {
        Integer val1 = fgalkembd.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgalkembd.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgalkembd.getTypeCode());
        ps.setString(4, fgalkembd.getSubTypeCode());
        ps.setString(5, fgalkembd.getActiveCode());
        ps.setString(6, fgalkembd.getStageCode());
        ps.setString(7, fgalkembd.getStatusCode());
        ps.setString(8, fgalkembd.getCreatedOn());
        java.math.BigDecimal val9 = fgalkembd.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgalkembd.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgalkembd.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgalkembd.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgalkembd.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgalkembd.getTemplate());
        java.math.BigDecimal val15 = fgalkembd.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgalkembd.getInvoiceCurrency());
        ps.setString(17, fgalkembd.getExportCountrySap());
        ps.setString(18, fgalkembd.getCustomerDescription());
        ps.setString(19, fgalkembd.getCountrySoldToPart());
        ps.setString(20, fgalkembd.getCountryCodeSoldTo());
        ps.setString(21, fgalkembd.getBLAwbNo());
        java.time.LocalDateTime val22 = fgalkembd.getBillOfLandingAwb();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgalkembd.getMaterialNo());
        ps.setString(24, fgalkembd.getProductDescription());
        ps.setString(25, fgalkembd.getFinalInvNo());
        java.time.LocalDateTime val26 = fgalkembd.getFinalInvDate();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        ps.setString(27, fgalkembd.getCustomsInvNo());
        java.time.LocalDateTime val28 = fgalkembd.getCustomsInvDate();
        if (val28 != null) {
            ps.setTimestamp(28, java.sql.Timestamp.valueOf(val28));
        } else {
            ps.setNull(28, Types.TIMESTAMP);
        }
        ps.setString(29, fgalkembd.getShippingBillNo());
        java.time.LocalDateTime val30 = fgalkembd.getShippingBillDate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        ps.setString(31, fgalkembd.getPortCode());
        ps.setString(32, fgalkembd.getPortLoad());
        java.time.LocalDateTime val33 = fgalkembd.getBillDueDate();
        if (val33 != null) {
            ps.setTimestamp(33, java.sql.Timestamp.valueOf(val33));
        } else {
            ps.setNull(33, Types.TIMESTAMP);
        }
        Integer val34 = fgalkembd.getUploadRefID();
        if (val34 != null) {
            ps.setInt(34, val34);
        } else {
            ps.setNull(34, Types.INTEGER);
        }
        ps.setString(35, fgalkembd.getIecCode());
        java.math.BigDecimal val36 = fgalkembd.getFinalInvAmount();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = fgalkembd.getInvoiceValue();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = fgalkembd.getInvoiceQuantity();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = fgalkembd.getDeclaredDeducted();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        java.math.BigDecimal val40 = fgalkembd.getLineNo();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgalkembd.getHsCode());
        java.math.BigDecimal val42 = fgalkembd.getEquivalentAmount();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        ps.setString(43, fgalkembd.getEquivalentCurrency());
        java.math.BigDecimal val44 = fgalkembd.getDisplayAmount();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        ps.setString(45, fgalkembd.getDisplayCurrency());
        java.math.BigDecimal val46 = fgalkembd.getAuthEquivalentAmount();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgalkembd.getAuthEquivalentCurrency());
        java.math.BigDecimal val48 = fgalkembd.getDisplayEquivalentAmount();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, fgalkembd.getDisplayEquivalentCurrency());
        java.math.BigDecimal val50 = fgalkembd.getAuthFxBaseRate();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = fgalkembd.getDisplayFxBaseRate();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        ps.setString(52, fgalkembd.getApplicantPartyCode());
        ps.setString(53, fgalkembd.getIssuingPartyCode());
        ps.setString(54, fgalkembd.getFileName());
        ps.setString(55, fgalkembd.getBankRefNo());
        java.time.LocalDateTime val56 = fgalkembd.getBaseDate();
        if (val56 != null) {
            ps.setTimestamp(56, java.sql.Timestamp.valueOf(val56));
        } else {
            ps.setNull(56, Types.TIMESTAMP);
        }
        java.math.BigDecimal val57 = fgalkembd.getBillAmount();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, fgalkembd.getBillCcy());
        ps.setString(59, fgalkembd.getBuyerCountry1());
        ps.setString(60, fgalkembd.getBuyerCountry2());
        Integer val61 = fgalkembd.getBuyerID();
        if (val61 != null) {
            ps.setInt(61, val61);
        } else {
            ps.setNull(61, Types.INTEGER);
        }
        ps.setString(62, fgalkembd.getBuyerName());
        ps.setString(63, fgalkembd.getChargesDbtAccNo());
        ps.setString(64, fgalkembd.getCollectingBank());
        ps.setString(65, fgalkembd.getCustomerCrn());
        ps.setString(66, fgalkembd.getDestPortCode());
        ps.setString(67, fgalkembd.getGoodsCode());
        ps.setString(68, fgalkembd.getGoodsDesc());
        ps.setString(69, fgalkembd.getHsnCode());
        ps.setString(70, fgalkembd.getIncoterms());
        java.time.LocalDateTime val71 = fgalkembd.getInvDate();
        if (val71 != null) {
            ps.setTimestamp(71, java.sql.Timestamp.valueOf(val71));
        } else {
            ps.setNull(71, Types.TIMESTAMP);
        }
        ps.setString(72, fgalkembd.getInvNo());
        ps.setString(73, fgalkembd.getPordCodeForLoading());
        java.math.BigDecimal val74 = fgalkembd.getShippingBillAmount();
        if (val74 != null) {
            ps.setBigDecimal(74, val74);
        } else {
            ps.setNull(74, Types.DECIMAL);
        }
        ps.setString(75, fgalkembd.getShippingBillCcy());
        ps.setString(76, fgalkembd.getSoftexNumber());
        java.math.BigDecimal val77 = fgalkembd.getTenorInDays();
        if (val77 != null) {
            ps.setBigDecimal(77, val77);
        } else {
            ps.setNull(77, Types.DECIMAL);
        }
        ps.setString(78, fgalkembd.getThirdParty());
        ps.setString(79, fgalkembd.getThirdPartyAdd());
        ps.setString(80, fgalkembd.getThirdPartyCountry());
        ps.setString(81, fgalkembd.getThirdPartyName());
        ps.setString(82, fgalkembd.getVesselOFlightName());
    }

    private FgAlkemBd extract(ResultSet rs) throws SQLException {
        FgAlkemBd fgalkembd = new FgAlkemBd();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgalkembd.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgalkembd.setReferenceID(REFERENCE_ID);
        fgalkembd.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgalkembd.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgalkembd.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgalkembd.setStageCode(rs.getString(COL_STAGE_CODE));
        fgalkembd.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgalkembd.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgalkembd.setCreatedBy(CREATED_BY);
        fgalkembd.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgalkembd.setLastUpdatedBy(LAST_UPDATED_BY);
        fgalkembd.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgalkembd.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgalkembd.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgalkembd.setIsTemplate(IS_TEMPLATE);
        fgalkembd.setInvoiceCurrency(rs.getString(COL_INVOICE_CURRENCY));
        fgalkembd.setExportCountrySap(rs.getString(COL_EXPORT_COUNTRY_SAP));
        fgalkembd.setCustomerDescription(rs.getString(COL_CUSTOMER_DESCRIPTION));
        fgalkembd.setCountrySoldToPart(rs.getString(COL_COUNTRY_SOLD_TO_PART));
        fgalkembd.setCountryCodeSoldTo(rs.getString(COL_COUNTRY_CODE_SOLD_TO));
        fgalkembd.setBLAwbNo(rs.getString(COL_B_L_AWB_NO));
        Timestamp BILL_OF_LANDING_AWB = rs.getTimestamp(COL_BILL_OF_LANDING_AWB);
        if (BILL_OF_LANDING_AWB != null)
            fgalkembd.setBillOfLandingAwb(BILL_OF_LANDING_AWB.toLocalDateTime());
        fgalkembd.setMaterialNo(rs.getString(COL_MATERIAL_NO));
        fgalkembd.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        fgalkembd.setFinalInvNo(rs.getString(COL_FINAL_INV_NO));
        Timestamp FINAL_INV_DATE = rs.getTimestamp(COL_FINAL_INV_DATE);
        if (FINAL_INV_DATE != null)
            fgalkembd.setFinalInvDate(FINAL_INV_DATE.toLocalDateTime());
        fgalkembd.setCustomsInvNo(rs.getString(COL_CUSTOMS_INV_NO));
        Timestamp CUSTOMS_INV_DATE = rs.getTimestamp(COL_CUSTOMS_INV_DATE);
        if (CUSTOMS_INV_DATE != null)
            fgalkembd.setCustomsInvDate(CUSTOMS_INV_DATE.toLocalDateTime());
        fgalkembd.setShippingBillNo(rs.getString(COL_SHIPPING_BILL_NO));
        Timestamp SHIPPING_BILL_DATE = rs.getTimestamp(COL_SHIPPING_BILL_DATE);
        if (SHIPPING_BILL_DATE != null)
            fgalkembd.setShippingBillDate(SHIPPING_BILL_DATE.toLocalDateTime());
        fgalkembd.setPortCode(rs.getString(COL_PORT_CODE));
        fgalkembd.setPortLoad(rs.getString(COL_PORT_LOAD));
        Timestamp BILL_DUE_DATE = rs.getTimestamp(COL_BILL_DUE_DATE);
        if (BILL_DUE_DATE != null)
            fgalkembd.setBillDueDate(BILL_DUE_DATE.toLocalDateTime());
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgalkembd.setUploadRefID(UPLOAD_REF_ID);
        fgalkembd.setIecCode(rs.getString(COL_IEC_CODE));
        java.math.BigDecimal FINAL_INV_AMOUNT = rs.getObject(COL_FINAL_INV_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setFinalInvAmount(FINAL_INV_AMOUNT);
        java.math.BigDecimal INVOICE_VALUE = rs.getObject(COL_INVOICE_VALUE, java.math.BigDecimal.class);
        fgalkembd.setInvoiceValue(INVOICE_VALUE);
        java.math.BigDecimal INVOICE_QUANTITY = rs.getObject(COL_INVOICE_QUANTITY, java.math.BigDecimal.class);
        fgalkembd.setInvoiceQuantity(INVOICE_QUANTITY);
        java.math.BigDecimal DECLARED_DEDUCTED = rs.getObject(COL_DECLARED_DEDUCTED, java.math.BigDecimal.class);
        fgalkembd.setDeclaredDeducted(DECLARED_DEDUCTED);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgalkembd.setLineNo(LINE_NO);
        fgalkembd.setHsCode(rs.getString(COL_HS_CODE));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgalkembd.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setDisplayAmount(DISPLAY_AMOUNT);
        fgalkembd.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgalkembd.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgalkembd.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgalkembd.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgalkembd.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgalkembd.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgalkembd.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgalkembd.setFileName(rs.getString(COL_FILE_NAME));
        fgalkembd.setBankRefNo(rs.getString(COL_BANK_REF_NO));
        Timestamp BASE_DATE = rs.getTimestamp(COL_BASE_DATE);
        if (BASE_DATE != null)
            fgalkembd.setBaseDate(BASE_DATE.toLocalDateTime());
        java.math.BigDecimal BILL_AMOUNT = rs.getObject(COL_BILL_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setBillAmount(BILL_AMOUNT);
        fgalkembd.setBillCcy(rs.getString(COL_BILL_CCY));
        fgalkembd.setBuyerCountry1(rs.getString(COL_BUYER_COUNTRY1));
        fgalkembd.setBuyerCountry2(rs.getString(COL_BUYER_COUNTRY2));
        Integer BUYER_ID = rs.getObject(COL_BUYER_ID, Integer.class);
        fgalkembd.setBuyerID(BUYER_ID);
        fgalkembd.setBuyerName(rs.getString(COL_BUYER_NAME));
        fgalkembd.setChargesDbtAccNo(rs.getString(COL_CHARGES_DBT_ACC_NO));
        fgalkembd.setCollectingBank(rs.getString(COL_COLLECTING_BANK));
        fgalkembd.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        fgalkembd.setDestPortCode(rs.getString(COL_DEST_PORT_CODE));
        fgalkembd.setGoodsCode(rs.getString(COL_GOODS_CODE));
        fgalkembd.setGoodsDesc(rs.getString(COL_GOODS_DESC));
        fgalkembd.setHsnCode(rs.getString(COL_HSN_CODE));
        fgalkembd.setIncoterms(rs.getString(COL_INCOTERMS));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgalkembd.setInvDate(INV_DATE.toLocalDateTime());
        fgalkembd.setInvNo(rs.getString(COL_INV_NO));
        fgalkembd.setPordCodeForLoading(rs.getString(COL_PORD_CODE_FOR_LOADING));
        java.math.BigDecimal SHIPPING_BILL_AMOUNT = rs.getObject(COL_SHIPPING_BILL_AMOUNT, java.math.BigDecimal.class);
        fgalkembd.setShippingBillAmount(SHIPPING_BILL_AMOUNT);
        fgalkembd.setShippingBillCcy(rs.getString(COL_SHIPPING_BILL_CCY));
        fgalkembd.setSoftexNumber(rs.getString(COL_SOFTEX_NUMBER));
        java.math.BigDecimal TENOR_IN_DAYS = rs.getObject(COL_TENOR_IN_DAYS, java.math.BigDecimal.class);
        fgalkembd.setTenorInDays(TENOR_IN_DAYS);
        fgalkembd.setThirdParty(rs.getString(COL_THIRD_PARTY));
        fgalkembd.setThirdPartyAdd(rs.getString(COL_THIRD_PARTY_ADD));
        fgalkembd.setThirdPartyCountry(rs.getString(COL_THIRD_PARTY_COUNTRY));
        fgalkembd.setThirdPartyName(rs.getString(COL_THIRD_PARTY_NAME));
        fgalkembd.setVesselOFlightName(rs.getString(COL_VESSEL_O_FLIGHT_NAME));
        return fgalkembd;
    }
}
