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

public class JdbcFgUploadAdviceDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgUploadAdviceDao.class);

    private static final String TABLE = "FG_UPLOAD_ADVICE";

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

    private static final String COL_VENDOR_CODE = "VENDOR_CODE";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_BILL_DUE_DATE = "BILL_DUE_DATE";

    private static final String COL_CURRENCY = "CURRENCY";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_INVOICE_REF = "INVOICE_REF";

    private static final String COL_SERIAL_NO = "SERIAL_NO";

    private static final String COL_DOCUMENT_NO = "DOCUMENT_NO";

    private static final String COL_OTHER_DEDUCTIONS = "OTHER_DEDUCTIONS";

    private static final String COL_TOTAL_DEDUCTED_AMOUNT = "TOTAL_DEDUCTED_AMOUNT";

    private static final String COL_NET_AMOUNT_PAYABLE = "NET_AMOUNT_PAYABLE";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_PAYMENT_DETAILS_6 = "PAYMENT_DETAILS_6";

    private static final String COL_PAYMENT_DETAILS_7 = "PAYMENT_DETAILS_7";

    private static final String COL_PAYMENT_DETAILS_8 = "PAYMENT_DETAILS_8";

    private static final String COL_PAYMENT_DETAILS_9 = "PAYMENT_DETAILS_9";

    private static final String COL_PAYMENT_DETAILS_10 = "PAYMENT_DETAILS_10";

    private static final String COL_CLIENT_REF_NO = "CLIENT_REF_NO";

    private static final String COL_INVOICE_DR_NOTE_DATE = "INVOICE_DR_NOTE_DATE";

    private static final String COL_INVOICE_DR_NOTE_NO = "INVOICE_DR_NOTE_NO";

    private static final String COL_TENURE = "TENURE";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_AMOUNT_A = "AMOUNT_A";

    private static final String COL_AMOUNT_B = "AMOUNT_B";

    private static final String COL_AMOUNT_C = "AMOUNT_C";

    private static final String COL_INVOICE_DEBIT_NOTE_AMOUNT = "INVOICE_DEBIT_NOTE_AMOUNT";

    private static final String COL_NARRATION = "NARRATION";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_NET_AMOUNT = "NET_AMOUNT";

    private static final String COL_BILL_DATE = "BILL_DATE";

    private static final String COL_HUNDI_NUMBER = "HUNDI_NUMBER";

    private static final String COL_LINE_NO_OF_ADVICE = "LINE_NO_OF_ADVICE";

    private static final String COL_ANNEXURE_TEXT_CONTENT = "ANNEXURE_TEXT_CONTENT";

    private static final String COL_INVOICE_DATE_SOMANY = "INVOICE_DATE_SOMANY";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_DISCOUNT_RATE = "DISCOUNT_RATE";

    private static final String COL_GROSS_AMOUNT = "GROSS_AMOUNT";

    private static final String COL_TDS_AMOUNT = "TDS_AMOUNT";

    private static final String COL_BANK_CHARGES = "BANK_CHARGES";

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

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VENDOR_CODE, COL_INVOICE_NUMBER, COL_INVOICE_DATE, COL_BILL_DUE_DATE, COL_CURRENCY, COL_INVOICE_AMOUNT, COL_INVOICE_REF, COL_SERIAL_NO, COL_DOCUMENT_NO, COL_OTHER_DEDUCTIONS, COL_TOTAL_DEDUCTED_AMOUNT, COL_NET_AMOUNT_PAYABLE, COL_BOE_DATE, COL_PAYMENT_DETAILS_6, COL_PAYMENT_DETAILS_7, COL_PAYMENT_DETAILS_8, COL_PAYMENT_DETAILS_9, COL_PAYMENT_DETAILS_10, COL_CLIENT_REF_NO, COL_INVOICE_DR_NOTE_DATE, COL_INVOICE_DR_NOTE_NO, COL_TENURE, COL_INTEREST_RATE, COL_AMOUNT_A, COL_AMOUNT_B, COL_AMOUNT_C, COL_INVOICE_DEBIT_NOTE_AMOUNT, COL_NARRATION, COL_BILL_NO, COL_NET_AMOUNT, COL_BILL_DATE, COL_HUNDI_NUMBER, COL_LINE_NO_OF_ADVICE, COL_ANNEXURE_TEXT_CONTENT, COL_INVOICE_DATE_SOMANY, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_DISCOUNT_RATE, COL_GROSS_AMOUNT, COL_TDS_AMOUNT, COL_BANK_CHARGES, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VENDOR_CODE, INVOICE_NUMBER, INVOICE_DATE, BILL_DUE_DATE, CURRENCY, INVOICE_AMOUNT, INVOICE_REF, SERIAL_NO, DOCUMENT_NO, OTHER_DEDUCTIONS, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, BOE_DATE, PAYMENT_DETAILS_6, PAYMENT_DETAILS_7, PAYMENT_DETAILS_8, PAYMENT_DETAILS_9, PAYMENT_DETAILS_10, CLIENT_REF_NO, INVOICE_DR_NOTE_DATE, INVOICE_DR_NOTE_NO, TENURE, INTEREST_RATE, AMOUNT_A, AMOUNT_B, AMOUNT_C, INVOICE_DEBIT_NOTE_AMOUNT, NARRATION, BILL_NO, NET_AMOUNT, BILL_DATE, HUNDI_NUMBER, LINE_NO_OF_ADVICE, ANNEXURE_TEXT_CONTENT, INVOICE_DATE_SOMANY, PARENT_REF_ID, PARENT_VERSION_ID, DISCOUNT_RATE, GROSS_AMOUNT, TDS_AMOUNT, BANK_CHARGES, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VENDOR_CODE, INVOICE_NUMBER, INVOICE_DATE, BILL_DUE_DATE, CURRENCY, INVOICE_AMOUNT, INVOICE_REF, SERIAL_NO, DOCUMENT_NO, OTHER_DEDUCTIONS, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, BOE_DATE, PAYMENT_DETAILS_6, PAYMENT_DETAILS_7, PAYMENT_DETAILS_8, PAYMENT_DETAILS_9, PAYMENT_DETAILS_10, CLIENT_REF_NO, INVOICE_DR_NOTE_DATE, INVOICE_DR_NOTE_NO, TENURE, INTEREST_RATE, AMOUNT_A, AMOUNT_B, AMOUNT_C, INVOICE_DEBIT_NOTE_AMOUNT, NARRATION, BILL_NO, NET_AMOUNT, BILL_DATE, HUNDI_NUMBER, LINE_NO_OF_ADVICE, ANNEXURE_TEXT_CONTENT, INVOICE_DATE_SOMANY, PARENT_REF_ID, PARENT_VERSION_ID, DISCOUNT_RATE, GROSS_AMOUNT, TDS_AMOUNT, BANK_CHARGES, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VENDOR_CODE, COL_INVOICE_NUMBER, COL_INVOICE_DATE, COL_BILL_DUE_DATE, COL_CURRENCY, COL_INVOICE_AMOUNT, COL_INVOICE_REF, COL_SERIAL_NO, COL_DOCUMENT_NO, COL_OTHER_DEDUCTIONS, COL_TOTAL_DEDUCTED_AMOUNT, COL_NET_AMOUNT_PAYABLE, COL_BOE_DATE, COL_PAYMENT_DETAILS_6, COL_PAYMENT_DETAILS_7, COL_PAYMENT_DETAILS_8, COL_PAYMENT_DETAILS_9, COL_PAYMENT_DETAILS_10, COL_CLIENT_REF_NO, COL_INVOICE_DR_NOTE_DATE, COL_INVOICE_DR_NOTE_NO, COL_TENURE, COL_INTEREST_RATE, COL_AMOUNT_A, COL_AMOUNT_B, COL_AMOUNT_C, COL_INVOICE_DEBIT_NOTE_AMOUNT, COL_NARRATION, COL_BILL_NO, COL_NET_AMOUNT, COL_BILL_DATE, COL_HUNDI_NUMBER, COL_LINE_NO_OF_ADVICE, COL_ANNEXURE_TEXT_CONTENT, COL_INVOICE_DATE_SOMANY, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_DISCOUNT_RATE, COL_GROSS_AMOUNT, COL_TDS_AMOUNT, COL_BANK_CHARGES, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_ID);

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

    public int insert(Connection conn, FgUploadAdvice fguploadadvice) throws SQLException {
        logger.debug("Inserting fguploadadvice: {}", fguploadadvice);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgUploadAdviceParams(ps, fguploadadvice);
            ps.executeUpdate();
            return fguploadadvice.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgUploadAdvice> fguploadadvices) throws SQLException {
        if (fguploadadvices == null || fguploadadvices.isEmpty())
            return new int[0];
        for (int i = 0; i < fguploadadvices.size(); i++) {
            if (fguploadadvices.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUploadAdvice>> batches = chunkList(fguploadadvices, batchSize);
        int[] totalResults = new int[fguploadadvices.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUploadAdvice> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgUploadAdvice fguploadadvice : batch) {
                        setFgUploadAdviceParams(ps, fguploadadvice);
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

    public FgUploadAdvice findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgUploadAdvice> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgUploadAdvice> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgUploadAdvice fguploadadvice) throws SQLException {
        if (fguploadadvice.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgUploadAdviceParams(ps, fguploadadvice);
            ps.setInt(66, fguploadadvice.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgUploadAdvice> fguploadadvices) throws SQLException {
        if (fguploadadvices == null || fguploadadvices.isEmpty())
            return new int[0];
        for (FgUploadAdvice fguploadadvice : fguploadadvices) {
            if (fguploadadvice == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fguploadadvice.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUploadAdvice>> batches = chunkList(fguploadadvices, batchSize);
        int[] totalResults = new int[fguploadadvices.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUploadAdvice> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgUploadAdvice fguploadadvice : batch) {
                        setFgUploadAdviceParams(ps, fguploadadvice);
                        ps.setInt(66, fguploadadvice.getID());
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

    private void setFgUploadAdviceParams(PreparedStatement ps, FgUploadAdvice fguploadadvice) throws SQLException {
        Integer val1 = fguploadadvice.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fguploadadvice.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fguploadadvice.getTypeCode());
        ps.setString(4, fguploadadvice.getSubTypeCode());
        ps.setString(5, fguploadadvice.getActiveCode());
        ps.setString(6, fguploadadvice.getStageCode());
        ps.setString(7, fguploadadvice.getStatusCode());
        ps.setString(8, fguploadadvice.getCreatedOn());
        java.math.BigDecimal val9 = fguploadadvice.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fguploadadvice.getLastUpdatedOn());
        java.math.BigDecimal val11 = fguploadadvice.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fguploadadvice.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fguploadadvice.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fguploadadvice.getTemplate());
        java.math.BigDecimal val15 = fguploadadvice.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fguploadadvice.getVendorCode());
        ps.setString(17, fguploadadvice.getInvoiceNumber());
        java.time.LocalDateTime val18 = fguploadadvice.getInvoiceDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val19 = fguploadadvice.getBillDueDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        ps.setString(20, fguploadadvice.getCurrency());
        java.math.BigDecimal val21 = fguploadadvice.getInvoiceAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fguploadadvice.getInvoiceRef());
        ps.setString(23, fguploadadvice.getSerialNo());
        ps.setString(24, fguploadadvice.getDocumentNo());
        java.math.BigDecimal val25 = fguploadadvice.getOtherDeductions();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fguploadadvice.getTotalDeductedAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fguploadadvice.getNetAmountPayable();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.time.LocalDateTime val28 = fguploadadvice.getBoeDate();
        if (val28 != null) {
            ps.setTimestamp(28, java.sql.Timestamp.valueOf(val28));
        } else {
            ps.setNull(28, Types.TIMESTAMP);
        }
        ps.setString(29, fguploadadvice.getPaymentDetails6());
        ps.setString(30, fguploadadvice.getPaymentDetails7());
        ps.setString(31, fguploadadvice.getPaymentDetails8());
        ps.setString(32, fguploadadvice.getPaymentDetails9());
        ps.setString(33, fguploadadvice.getPaymentDetails10());
        ps.setString(34, fguploadadvice.getClientRefNo());
        java.time.LocalDateTime val35 = fguploadadvice.getInvoiceDrNoteDate();
        if (val35 != null) {
            ps.setTimestamp(35, java.sql.Timestamp.valueOf(val35));
        } else {
            ps.setNull(35, Types.TIMESTAMP);
        }
        ps.setString(36, fguploadadvice.getInvoiceDrNoteNo());
        ps.setString(37, fguploadadvice.getTenure());
        java.math.BigDecimal val38 = fguploadadvice.getInterestRate();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = fguploadadvice.getAmountA();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        java.math.BigDecimal val40 = fguploadadvice.getAmountB();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        java.math.BigDecimal val41 = fguploadadvice.getAmountC();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        java.math.BigDecimal val42 = fguploadadvice.getInvoiceDebitNoteAmount();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        ps.setString(43, fguploadadvice.getNarration());
        ps.setString(44, fguploadadvice.getBillNo());
        java.math.BigDecimal val45 = fguploadadvice.getNetAmount();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.time.LocalDateTime val46 = fguploadadvice.getBillDate();
        if (val46 != null) {
            ps.setTimestamp(46, java.sql.Timestamp.valueOf(val46));
        } else {
            ps.setNull(46, Types.TIMESTAMP);
        }
        ps.setString(47, fguploadadvice.getHundiNumber());
        ps.setString(48, fguploadadvice.getLineNoOfAdvice());
        ps.setString(49, fguploadadvice.getAnnexureTextContent());
        ps.setString(50, fguploadadvice.getInvoiceDateSomany());
        Integer val51 = fguploadadvice.getParentRefID();
        if (val51 != null) {
            ps.setInt(51, val51);
        } else {
            ps.setNull(51, Types.INTEGER);
        }
        Integer val52 = fguploadadvice.getParentVersionID();
        if (val52 != null) {
            ps.setInt(52, val52);
        } else {
            ps.setNull(52, Types.INTEGER);
        }
        java.math.BigDecimal val53 = fguploadadvice.getDiscountRate();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        java.math.BigDecimal val54 = fguploadadvice.getGrossAmount();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        java.math.BigDecimal val55 = fguploadadvice.getTdsAmount();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, fguploadadvice.getBankCharges());
        java.math.BigDecimal val57 = fguploadadvice.getEquivalentAmount();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, fguploadadvice.getEquivalentCurrency());
        java.math.BigDecimal val59 = fguploadadvice.getDisplayAmount();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        ps.setString(60, fguploadadvice.getDisplayCurrency());
        java.math.BigDecimal val61 = fguploadadvice.getAuthEquivalentAmount();
        if (val61 != null) {
            ps.setBigDecimal(61, val61);
        } else {
            ps.setNull(61, Types.DECIMAL);
        }
        ps.setString(62, fguploadadvice.getAuthEquivalentCurrency());
        java.math.BigDecimal val63 = fguploadadvice.getDisplayEquivalentAmount();
        if (val63 != null) {
            ps.setBigDecimal(63, val63);
        } else {
            ps.setNull(63, Types.DECIMAL);
        }
        ps.setString(64, fguploadadvice.getDisplayEquivalentCurrency());
        java.math.BigDecimal val65 = fguploadadvice.getAuthFxBaseRate();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        java.math.BigDecimal val66 = fguploadadvice.getDisplayFxBaseRate();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
    }

    private FgUploadAdvice extract(ResultSet rs) throws SQLException {
        FgUploadAdvice fguploadadvice = new FgUploadAdvice();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fguploadadvice.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fguploadadvice.setReferenceID(REFERENCE_ID);
        fguploadadvice.setTypeCode(rs.getString(COL_TYPE_CODE));
        fguploadadvice.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fguploadadvice.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fguploadadvice.setStageCode(rs.getString(COL_STAGE_CODE));
        fguploadadvice.setStatusCode(rs.getString(COL_STATUS_CODE));
        fguploadadvice.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fguploadadvice.setCreatedBy(CREATED_BY);
        fguploadadvice.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fguploadadvice.setLastUpdatedBy(LAST_UPDATED_BY);
        fguploadadvice.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fguploadadvice.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fguploadadvice.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fguploadadvice.setIsTemplate(IS_TEMPLATE);
        fguploadadvice.setVendorCode(rs.getString(COL_VENDOR_CODE));
        fguploadadvice.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fguploadadvice.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        Timestamp BILL_DUE_DATE = rs.getTimestamp(COL_BILL_DUE_DATE);
        if (BILL_DUE_DATE != null)
            fguploadadvice.setBillDueDate(BILL_DUE_DATE.toLocalDateTime());
        fguploadadvice.setCurrency(rs.getString(COL_CURRENCY));
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setInvoiceAmount(INVOICE_AMOUNT);
        fguploadadvice.setInvoiceRef(rs.getString(COL_INVOICE_REF));
        fguploadadvice.setSerialNo(rs.getString(COL_SERIAL_NO));
        fguploadadvice.setDocumentNo(rs.getString(COL_DOCUMENT_NO));
        java.math.BigDecimal OTHER_DEDUCTIONS = rs.getObject(COL_OTHER_DEDUCTIONS, java.math.BigDecimal.class);
        fguploadadvice.setOtherDeductions(OTHER_DEDUCTIONS);
        java.math.BigDecimal TOTAL_DEDUCTED_AMOUNT = rs.getObject(COL_TOTAL_DEDUCTED_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setTotalDeductedAmount(TOTAL_DEDUCTED_AMOUNT);
        java.math.BigDecimal NET_AMOUNT_PAYABLE = rs.getObject(COL_NET_AMOUNT_PAYABLE, java.math.BigDecimal.class);
        fguploadadvice.setNetAmountPayable(NET_AMOUNT_PAYABLE);
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fguploadadvice.setBoeDate(BOE_DATE.toLocalDateTime());
        fguploadadvice.setPaymentDetails6(rs.getString(COL_PAYMENT_DETAILS_6));
        fguploadadvice.setPaymentDetails7(rs.getString(COL_PAYMENT_DETAILS_7));
        fguploadadvice.setPaymentDetails8(rs.getString(COL_PAYMENT_DETAILS_8));
        fguploadadvice.setPaymentDetails9(rs.getString(COL_PAYMENT_DETAILS_9));
        fguploadadvice.setPaymentDetails10(rs.getString(COL_PAYMENT_DETAILS_10));
        fguploadadvice.setClientRefNo(rs.getString(COL_CLIENT_REF_NO));
        Timestamp INVOICE_DR_NOTE_DATE = rs.getTimestamp(COL_INVOICE_DR_NOTE_DATE);
        if (INVOICE_DR_NOTE_DATE != null)
            fguploadadvice.setInvoiceDrNoteDate(INVOICE_DR_NOTE_DATE.toLocalDateTime());
        fguploadadvice.setInvoiceDrNoteNo(rs.getString(COL_INVOICE_DR_NOTE_NO));
        fguploadadvice.setTenure(rs.getString(COL_TENURE));
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        fguploadadvice.setInterestRate(INTEREST_RATE);
        java.math.BigDecimal AMOUNT_A = rs.getObject(COL_AMOUNT_A, java.math.BigDecimal.class);
        fguploadadvice.setAmountA(AMOUNT_A);
        java.math.BigDecimal AMOUNT_B = rs.getObject(COL_AMOUNT_B, java.math.BigDecimal.class);
        fguploadadvice.setAmountB(AMOUNT_B);
        java.math.BigDecimal AMOUNT_C = rs.getObject(COL_AMOUNT_C, java.math.BigDecimal.class);
        fguploadadvice.setAmountC(AMOUNT_C);
        java.math.BigDecimal INVOICE_DEBIT_NOTE_AMOUNT = rs.getObject(COL_INVOICE_DEBIT_NOTE_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setInvoiceDebitNoteAmount(INVOICE_DEBIT_NOTE_AMOUNT);
        fguploadadvice.setNarration(rs.getString(COL_NARRATION));
        fguploadadvice.setBillNo(rs.getString(COL_BILL_NO));
        java.math.BigDecimal NET_AMOUNT = rs.getObject(COL_NET_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setNetAmount(NET_AMOUNT);
        Timestamp BILL_DATE = rs.getTimestamp(COL_BILL_DATE);
        if (BILL_DATE != null)
            fguploadadvice.setBillDate(BILL_DATE.toLocalDateTime());
        fguploadadvice.setHundiNumber(rs.getString(COL_HUNDI_NUMBER));
        fguploadadvice.setLineNoOfAdvice(rs.getString(COL_LINE_NO_OF_ADVICE));
        fguploadadvice.setAnnexureTextContent(rs.getString(COL_ANNEXURE_TEXT_CONTENT));
        fguploadadvice.setInvoiceDateSomany(rs.getString(COL_INVOICE_DATE_SOMANY));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fguploadadvice.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fguploadadvice.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal DISCOUNT_RATE = rs.getObject(COL_DISCOUNT_RATE, java.math.BigDecimal.class);
        fguploadadvice.setDiscountRate(DISCOUNT_RATE);
        java.math.BigDecimal GROSS_AMOUNT = rs.getObject(COL_GROSS_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setGrossAmount(GROSS_AMOUNT);
        java.math.BigDecimal TDS_AMOUNT = rs.getObject(COL_TDS_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setTdsAmount(TDS_AMOUNT);
        fguploadadvice.setBankCharges(rs.getString(COL_BANK_CHARGES));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fguploadadvice.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setDisplayAmount(DISPLAY_AMOUNT);
        fguploadadvice.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fguploadadvice.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fguploadadvice.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fguploadadvice.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fguploadadvice.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fguploadadvice.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        return fguploadadvice;
    }
}
