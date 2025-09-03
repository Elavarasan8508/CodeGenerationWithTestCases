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

public class JdbcFgOnlineImportDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgOnlineImportDao.class);

    private static final String TABLE = "FG_ONLINE_IMPORT";

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

    private static final String COL_FINAL_INV_AMOUNT = "FINAL_INV_AMOUNT";

    private static final String COL_FINAL_INV_NO = "FINAL_INV_NO";

    private static final String COL_FINAL_INV_DATE = "FINAL_INV_DATE";

    private static final String COL_CUSTOMS_INV_NO = "CUSTOMS_INV_NO";

    private static final String COL_CUSTOMS_INV_DATE = "CUSTOMS_INV_DATE";

    private static final String COL_SHIPPING_BILL_NO = "SHIPPING_BILL_NO";

    private static final String COL_SHIPPING_BILL_DATE = "SHIPPING_BILL_DATE";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_PORT_LOAD = "PORT_LOAD";

    private static final String COL_DECLARED_DEDUCTED = "DECLARED_DEDUCTED";

    private static final String COL_BILL_DUE_DATE = "BILL_DUE_DATE";

    private static final String COL_IEC_CODE = "IEC_CODE";

    private static final String COL_INVOICE_CURRENCY = "INVOICE_CURRENCY";

    private static final String COL_EXPORT_COUNTRY_SAP = "EXPORT_COUNTRY_SAP";

    private static final String COL_INV_QUANTITY = "INV_QUANTITY";

    private static final String COL_INVOICE_VALUE = "INVOICE_VALUE";

    private static final String COL_CUSTOMER_DESCRIPTION = "CUSTOMER_DESCRIPTION";

    private static final String COL_COUNTRY_SOLD_TO_PART = "COUNTRY_SOLD_TO_PART";

    private static final String COL_COUNTRY_CODE_SOLD_TO = "COUNTRY_CODE_SOLD_TO";

    private static final String COL_B_L_AWB_NO = "B_L_AWB_NO";

    private static final String COL_BILL_OF_LANDING_AWB = "BILL_OF_LANDING_AWB";

    private static final String COL_MATERIAL_NO = "MATERIAL_NO";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

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

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FINAL_INV_AMOUNT, COL_FINAL_INV_NO, COL_FINAL_INV_DATE, COL_CUSTOMS_INV_NO, COL_CUSTOMS_INV_DATE, COL_SHIPPING_BILL_NO, COL_SHIPPING_BILL_DATE, COL_PORT_CODE, COL_PORT_LOAD, COL_DECLARED_DEDUCTED, COL_BILL_DUE_DATE, COL_IEC_CODE, COL_INVOICE_CURRENCY, COL_EXPORT_COUNTRY_SAP, COL_INV_QUANTITY, COL_INVOICE_VALUE, COL_CUSTOMER_DESCRIPTION, COL_COUNTRY_SOLD_TO_PART, COL_COUNTRY_CODE_SOLD_TO, COL_B_L_AWB_NO, COL_BILL_OF_LANDING_AWB, COL_MATERIAL_NO, COL_PRODUCT_DESCRIPTION, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_HS_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FINAL_INV_AMOUNT, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, DECLARED_DEDUCTED, BILL_DUE_DATE, IEC_CODE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, INV_QUANTITY, INVOICE_VALUE, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, UPLOAD_REF_ID, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FINAL_INV_AMOUNT, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, DECLARED_DEDUCTED, BILL_DUE_DATE, IEC_CODE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, INV_QUANTITY, INVOICE_VALUE, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, UPLOAD_REF_ID, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FINAL_INV_AMOUNT, COL_FINAL_INV_NO, COL_FINAL_INV_DATE, COL_CUSTOMS_INV_NO, COL_CUSTOMS_INV_DATE, COL_SHIPPING_BILL_NO, COL_SHIPPING_BILL_DATE, COL_PORT_CODE, COL_PORT_LOAD, COL_DECLARED_DEDUCTED, COL_BILL_DUE_DATE, COL_IEC_CODE, COL_INVOICE_CURRENCY, COL_EXPORT_COUNTRY_SAP, COL_INV_QUANTITY, COL_INVOICE_VALUE, COL_CUSTOMER_DESCRIPTION, COL_COUNTRY_SOLD_TO_PART, COL_COUNTRY_CODE_SOLD_TO, COL_B_L_AWB_NO, COL_BILL_OF_LANDING_AWB, COL_MATERIAL_NO, COL_PRODUCT_DESCRIPTION, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_HS_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_ID);

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

    public int insert(Connection conn, FgOnlineImport fgonlineimport) throws SQLException {
        logger.debug("Inserting fgonlineimport: {}", fgonlineimport);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgOnlineImportParams(ps, fgonlineimport);
            ps.executeUpdate();
            return fgonlineimport.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgOnlineImport> fgonlineimports) throws SQLException {
        if (fgonlineimports == null || fgonlineimports.isEmpty())
            return new int[0];
        for (int i = 0; i < fgonlineimports.size(); i++) {
            if (fgonlineimports.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOnlineImport>> batches = chunkList(fgonlineimports, batchSize);
        int[] totalResults = new int[fgonlineimports.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOnlineImport> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgOnlineImport fgonlineimport : batch) {
                        setFgOnlineImportParams(ps, fgonlineimport);
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

    public FgOnlineImport findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgOnlineImport> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgOnlineImport> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgOnlineImport fgonlineimport) throws SQLException {
        if (fgonlineimport.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgOnlineImportParams(ps, fgonlineimport);
            ps.setInt(54, fgonlineimport.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgOnlineImport> fgonlineimports) throws SQLException {
        if (fgonlineimports == null || fgonlineimports.isEmpty())
            return new int[0];
        for (FgOnlineImport fgonlineimport : fgonlineimports) {
            if (fgonlineimport == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgonlineimport.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOnlineImport>> batches = chunkList(fgonlineimports, batchSize);
        int[] totalResults = new int[fgonlineimports.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOnlineImport> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgOnlineImport fgonlineimport : batch) {
                        setFgOnlineImportParams(ps, fgonlineimport);
                        ps.setInt(54, fgonlineimport.getID());
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

    private void setFgOnlineImportParams(PreparedStatement ps, FgOnlineImport fgonlineimport) throws SQLException {
        Integer val1 = fgonlineimport.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgonlineimport.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgonlineimport.getTypeCode());
        ps.setString(4, fgonlineimport.getSubTypeCode());
        ps.setString(5, fgonlineimport.getActiveCode());
        ps.setString(6, fgonlineimport.getStageCode());
        ps.setString(7, fgonlineimport.getStatusCode());
        ps.setString(8, fgonlineimport.getCreatedOn());
        java.math.BigDecimal val9 = fgonlineimport.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgonlineimport.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgonlineimport.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgonlineimport.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgonlineimport.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgonlineimport.getTemplate());
        java.math.BigDecimal val15 = fgonlineimport.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = fgonlineimport.getFinalInvAmount();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgonlineimport.getFinalInvNo());
        java.time.LocalDateTime val18 = fgonlineimport.getFinalInvDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        ps.setString(19, fgonlineimport.getCustomsInvNo());
        java.time.LocalDateTime val20 = fgonlineimport.getCustomsInvDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fgonlineimport.getShippingBillNo());
        java.time.LocalDateTime val22 = fgonlineimport.getShippingBillDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgonlineimport.getPortCode());
        ps.setString(24, fgonlineimport.getPortLoad());
        java.math.BigDecimal val25 = fgonlineimport.getDeclaredDeducted();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.time.LocalDateTime val26 = fgonlineimport.getBillDueDate();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        ps.setString(27, fgonlineimport.getIecCode());
        ps.setString(28, fgonlineimport.getInvoiceCurrency());
        ps.setString(29, fgonlineimport.getExportCountrySap());
        java.math.BigDecimal val30 = fgonlineimport.getInvQuantity();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = fgonlineimport.getInvoiceValue();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, fgonlineimport.getCustomerDescription());
        ps.setString(33, fgonlineimport.getCountrySoldToPart());
        ps.setString(34, fgonlineimport.getCountryCodeSoldTo());
        ps.setString(35, fgonlineimport.getBLAwbNo());
        java.time.LocalDateTime val36 = fgonlineimport.getBillOfLandingAwb();
        if (val36 != null) {
            ps.setTimestamp(36, java.sql.Timestamp.valueOf(val36));
        } else {
            ps.setNull(36, Types.TIMESTAMP);
        }
        ps.setString(37, fgonlineimport.getMaterialNo());
        ps.setString(38, fgonlineimport.getProductDescription());
        Integer val39 = fgonlineimport.getUploadRefID();
        if (val39 != null) {
            ps.setInt(39, val39);
        } else {
            ps.setNull(39, Types.INTEGER);
        }
        java.math.BigDecimal val40 = fgonlineimport.getLineNo();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgonlineimport.getHsCode());
        java.math.BigDecimal val42 = fgonlineimport.getEquivalentAmount();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        ps.setString(43, fgonlineimport.getEquivalentCurrency());
        java.math.BigDecimal val44 = fgonlineimport.getDisplayAmount();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        ps.setString(45, fgonlineimport.getDisplayCurrency());
        java.math.BigDecimal val46 = fgonlineimport.getAuthEquivalentAmount();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgonlineimport.getAuthEquivalentCurrency());
        java.math.BigDecimal val48 = fgonlineimport.getDisplayEquivalentAmount();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, fgonlineimport.getDisplayEquivalentCurrency());
        java.math.BigDecimal val50 = fgonlineimport.getAuthFxBaseRate();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = fgonlineimport.getDisplayFxBaseRate();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        ps.setString(52, fgonlineimport.getApplicantPartyCode());
        ps.setString(53, fgonlineimport.getIssuingPartyCode());
        ps.setString(54, fgonlineimport.getFileName());
    }

    private FgOnlineImport extract(ResultSet rs) throws SQLException {
        FgOnlineImport fgonlineimport = new FgOnlineImport();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgonlineimport.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgonlineimport.setReferenceID(REFERENCE_ID);
        fgonlineimport.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgonlineimport.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgonlineimport.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgonlineimport.setStageCode(rs.getString(COL_STAGE_CODE));
        fgonlineimport.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgonlineimport.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgonlineimport.setCreatedBy(CREATED_BY);
        fgonlineimport.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgonlineimport.setLastUpdatedBy(LAST_UPDATED_BY);
        fgonlineimport.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgonlineimport.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgonlineimport.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgonlineimport.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal FINAL_INV_AMOUNT = rs.getObject(COL_FINAL_INV_AMOUNT, java.math.BigDecimal.class);
        fgonlineimport.setFinalInvAmount(FINAL_INV_AMOUNT);
        fgonlineimport.setFinalInvNo(rs.getString(COL_FINAL_INV_NO));
        Timestamp FINAL_INV_DATE = rs.getTimestamp(COL_FINAL_INV_DATE);
        if (FINAL_INV_DATE != null)
            fgonlineimport.setFinalInvDate(FINAL_INV_DATE.toLocalDateTime());
        fgonlineimport.setCustomsInvNo(rs.getString(COL_CUSTOMS_INV_NO));
        Timestamp CUSTOMS_INV_DATE = rs.getTimestamp(COL_CUSTOMS_INV_DATE);
        if (CUSTOMS_INV_DATE != null)
            fgonlineimport.setCustomsInvDate(CUSTOMS_INV_DATE.toLocalDateTime());
        fgonlineimport.setShippingBillNo(rs.getString(COL_SHIPPING_BILL_NO));
        Timestamp SHIPPING_BILL_DATE = rs.getTimestamp(COL_SHIPPING_BILL_DATE);
        if (SHIPPING_BILL_DATE != null)
            fgonlineimport.setShippingBillDate(SHIPPING_BILL_DATE.toLocalDateTime());
        fgonlineimport.setPortCode(rs.getString(COL_PORT_CODE));
        fgonlineimport.setPortLoad(rs.getString(COL_PORT_LOAD));
        java.math.BigDecimal DECLARED_DEDUCTED = rs.getObject(COL_DECLARED_DEDUCTED, java.math.BigDecimal.class);
        fgonlineimport.setDeclaredDeducted(DECLARED_DEDUCTED);
        Timestamp BILL_DUE_DATE = rs.getTimestamp(COL_BILL_DUE_DATE);
        if (BILL_DUE_DATE != null)
            fgonlineimport.setBillDueDate(BILL_DUE_DATE.toLocalDateTime());
        fgonlineimport.setIecCode(rs.getString(COL_IEC_CODE));
        fgonlineimport.setInvoiceCurrency(rs.getString(COL_INVOICE_CURRENCY));
        fgonlineimport.setExportCountrySap(rs.getString(COL_EXPORT_COUNTRY_SAP));
        java.math.BigDecimal INV_QUANTITY = rs.getObject(COL_INV_QUANTITY, java.math.BigDecimal.class);
        fgonlineimport.setInvQuantity(INV_QUANTITY);
        java.math.BigDecimal INVOICE_VALUE = rs.getObject(COL_INVOICE_VALUE, java.math.BigDecimal.class);
        fgonlineimport.setInvoiceValue(INVOICE_VALUE);
        fgonlineimport.setCustomerDescription(rs.getString(COL_CUSTOMER_DESCRIPTION));
        fgonlineimport.setCountrySoldToPart(rs.getString(COL_COUNTRY_SOLD_TO_PART));
        fgonlineimport.setCountryCodeSoldTo(rs.getString(COL_COUNTRY_CODE_SOLD_TO));
        fgonlineimport.setBLAwbNo(rs.getString(COL_B_L_AWB_NO));
        Timestamp BILL_OF_LANDING_AWB = rs.getTimestamp(COL_BILL_OF_LANDING_AWB);
        if (BILL_OF_LANDING_AWB != null)
            fgonlineimport.setBillOfLandingAwb(BILL_OF_LANDING_AWB.toLocalDateTime());
        fgonlineimport.setMaterialNo(rs.getString(COL_MATERIAL_NO));
        fgonlineimport.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgonlineimport.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgonlineimport.setLineNo(LINE_NO);
        fgonlineimport.setHsCode(rs.getString(COL_HS_CODE));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgonlineimport.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgonlineimport.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgonlineimport.setDisplayAmount(DISPLAY_AMOUNT);
        fgonlineimport.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgonlineimport.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgonlineimport.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgonlineimport.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgonlineimport.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgonlineimport.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgonlineimport.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgonlineimport.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgonlineimport.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgonlineimport.setFileName(rs.getString(COL_FILE_NAME));
        return fgonlineimport;
    }
}
