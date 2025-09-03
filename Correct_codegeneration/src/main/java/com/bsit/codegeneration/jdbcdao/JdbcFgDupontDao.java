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

public class JdbcFgDupontDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDupontDao.class);

    private static final String TABLE = "FG_DUPONT";

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

    private static final String COL_RAISED_BY = "RAISED_BY";

    private static final String COL_UPLOAD_DATE = "UPLOAD_DATE";

    private static final String COL_VENDOR_NAME = "VENDOR_NAME";

    private static final String COL_CRN = "CRN";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_DUE_DATE_OF_INVOICE = "DUE_DATE_OF_INVOICE";

    private static final String COL_CURRENCY = "CURRENCY";

    private static final String COL_STATE = "STATE";

    private static final String COL_VENDOR_CODE = "VENDOR_CODE";

    private static final String COL_DISCOUNTING_DATE = "DISCOUNTING_DATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_FUNDING_AMOUNT = "FUNDING_AMOUNT";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_CUSTOMER_AC_NO = "CUSTOMER_AC_NO";

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

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_BATCH_STATUS = "BATCH_STATUS";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_BATCH_REMARKS = "BATCH_REMARKS";

    private static final String COL_TI_STATUS = "TI_STATUS";

    private static final String COL_TI_BATCH_REF_ID = "TI_BATCH_REF_ID";

    private static final String COL_TI_REMARKS = "TI_REMARKS";

    private static final String COL_TNX_DISPLAY_STATUS = "TNX_DISPLAY_STATUS";

    private static final String COL_TNX_DISPLAY_BATCH_ID = "TNX_DISPLAY_BATCH_ID";

    private static final String COL_TNX_DISPLAY_REMARKS = "TNX_DISPLAY_REMARKS";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_ADVANCE_INTEREST = "ADVANCE_INTEREST";

    private static final String COL_NET_PAYMENT = "NET_PAYMENT";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_UTR_NUMBER = "UTR_NUMBER";

    private static final String COL_CHARGES = "CHARGES";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_CUSTOM_MATURITY_DATE = "CUSTOM_MATURITY_DATE";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_LOAN_REQUEST_TYPE = "LOAN_REQUEST_TYPE";

    private static final String COL_FINANCE_PARTY = "FINANCE_PARTY";

    private static final String COL_FINANCE_REQUEST_STATUS = "FINANCE_REQUEST_STATUS";

    private static final String COL_FINANCE_REQUESTED = "FINANCE_REQUESTED";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RAISED_BY, COL_UPLOAD_DATE, COL_VENDOR_NAME, COL_CRN, COL_INVOICE_DATE, COL_INVOICE_NUMBER, COL_DUE_DATE_OF_INVOICE, COL_CURRENCY, COL_STATE, COL_VENDOR_CODE, COL_DISCOUNTING_DATE, COL_UPLOAD_REF_ID, COL_INVOICE_AMOUNT, COL_FUNDING_AMOUNT, COL_LINE_NO, COL_CUSTOMER_AC_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_LAYOUT_NAME, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED, COL_LAYOUT_TEMPLATE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RAISED_BY, UPLOAD_DATE, VENDOR_NAME, CRN, INVOICE_DATE, INVOICE_NUMBER, DUE_DATE_OF_INVOICE, CURRENCY, STATE, VENDOR_CODE, DISCOUNTING_DATE, UPLOAD_REF_ID, INVOICE_AMOUNT, FUNDING_AMOUNT, LINE_NO, CUSTOMER_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED, LAYOUT_TEMPLATE_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RAISED_BY, UPLOAD_DATE, VENDOR_NAME, CRN, INVOICE_DATE, INVOICE_NUMBER, DUE_DATE_OF_INVOICE, CURRENCY, STATE, VENDOR_CODE, DISCOUNTING_DATE, UPLOAD_REF_ID, INVOICE_AMOUNT, FUNDING_AMOUNT, LINE_NO, CUSTOMER_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED, LAYOUT_TEMPLATE_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RAISED_BY, COL_UPLOAD_DATE, COL_VENDOR_NAME, COL_CRN, COL_INVOICE_DATE, COL_INVOICE_NUMBER, COL_DUE_DATE_OF_INVOICE, COL_CURRENCY, COL_STATE, COL_VENDOR_CODE, COL_DISCOUNTING_DATE, COL_UPLOAD_REF_ID, COL_INVOICE_AMOUNT, COL_FUNDING_AMOUNT, COL_LINE_NO, COL_CUSTOMER_AC_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_LAYOUT_NAME, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED, COL_LAYOUT_TEMPLATE_ID, COL_ID);

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

    public int insert(Connection conn, FgDupont fgdupont) throws SQLException {
        logger.debug("Inserting fgdupont: {}", fgdupont);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDupontParams(ps, fgdupont);
            ps.executeUpdate();
            return fgdupont.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDupont> fgduponts) throws SQLException {
        if (fgduponts == null || fgduponts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgduponts.size(); i++) {
            if (fgduponts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDupont>> batches = chunkList(fgduponts, batchSize);
        int[] totalResults = new int[fgduponts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDupont> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDupont fgdupont : batch) {
                        setFgDupontParams(ps, fgdupont);
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

    public FgDupont findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDupont> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDupont> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDupont fgdupont) throws SQLException {
        if (fgdupont.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDupontParams(ps, fgdupont);
            ps.setInt(66, fgdupont.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDupont> fgduponts) throws SQLException {
        if (fgduponts == null || fgduponts.isEmpty())
            return new int[0];
        for (FgDupont fgdupont : fgduponts) {
            if (fgdupont == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdupont.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDupont>> batches = chunkList(fgduponts, batchSize);
        int[] totalResults = new int[fgduponts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDupont> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDupont fgdupont : batch) {
                        setFgDupontParams(ps, fgdupont);
                        ps.setInt(66, fgdupont.getID());
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

    private void setFgDupontParams(PreparedStatement ps, FgDupont fgdupont) throws SQLException {
        Integer val1 = fgdupont.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgdupont.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgdupont.getTypeCode());
        ps.setString(4, fgdupont.getSubTypeCode());
        ps.setString(5, fgdupont.getActiveCode());
        ps.setString(6, fgdupont.getStageCode());
        ps.setString(7, fgdupont.getStatusCode());
        ps.setString(8, fgdupont.getCreatedOn());
        java.math.BigDecimal val9 = fgdupont.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgdupont.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgdupont.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgdupont.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgdupont.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgdupont.getTemplate());
        java.math.BigDecimal val15 = fgdupont.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgdupont.getRaisedBy());
        java.time.LocalDateTime val17 = fgdupont.getUploadDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgdupont.getVendorName());
        ps.setString(19, fgdupont.getCrn());
        java.time.LocalDateTime val20 = fgdupont.getInvoiceDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fgdupont.getInvoiceNumber());
        java.time.LocalDateTime val22 = fgdupont.getDueDateOfInvoice();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgdupont.getCurrency());
        ps.setString(24, fgdupont.getState());
        ps.setString(25, fgdupont.getVendorCode());
        java.time.LocalDateTime val26 = fgdupont.getDiscountingDate();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        Integer val27 = fgdupont.getUploadRefID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = fgdupont.getInvoiceAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = fgdupont.getFundingAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = fgdupont.getLineNo();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgdupont.getCustomerAcNo());
        java.math.BigDecimal val32 = fgdupont.getEquivalentAmount();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, fgdupont.getEquivalentCurrency());
        java.math.BigDecimal val34 = fgdupont.getDisplayAmount();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fgdupont.getDisplayCurrency());
        java.math.BigDecimal val36 = fgdupont.getAuthEquivalentAmount();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, fgdupont.getAuthEquivalentCurrency());
        java.math.BigDecimal val38 = fgdupont.getDisplayEquivalentAmount();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgdupont.getDisplayEquivalentCurrency());
        java.math.BigDecimal val40 = fgdupont.getAuthFxBaseRate();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        java.math.BigDecimal val41 = fgdupont.getDisplayFxBaseRate();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, fgdupont.getFileName());
        ps.setString(43, fgdupont.getBatchStatus());
        Integer val44 = fgdupont.getBatchRefID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        ps.setString(45, fgdupont.getBatchRemarks());
        ps.setString(46, fgdupont.getTiStatus());
        Integer val47 = fgdupont.getTiBatchRefID();
        if (val47 != null) {
            ps.setInt(47, val47);
        } else {
            ps.setNull(47, Types.INTEGER);
        }
        ps.setString(48, fgdupont.getTiRemarks());
        ps.setString(49, fgdupont.getTnxDisplayStatus());
        Integer val50 = fgdupont.getTnxDisplayBatchID();
        if (val50 != null) {
            ps.setInt(50, val50);
        } else {
            ps.setNull(50, Types.INTEGER);
        }
        ps.setString(51, fgdupont.getTnxDisplayRemarks());
        ps.setString(52, fgdupont.getApplicantPartyCode());
        ps.setString(53, fgdupont.getIssuingPartyCode());
        java.math.BigDecimal val54 = fgdupont.getAdvanceInterest();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        java.math.BigDecimal val55 = fgdupont.getNetPayment();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, fgdupont.getValueDate());
        ps.setString(57, fgdupont.getUtrNumber());
        java.math.BigDecimal val58 = fgdupont.getCharges();
        if (val58 != null) {
            ps.setBigDecimal(58, val58);
        } else {
            ps.setNull(58, Types.DECIMAL);
        }
        ps.setString(59, fgdupont.getLayoutName());
        java.time.LocalDateTime val60 = fgdupont.getCustomMaturityDate();
        if (val60 != null) {
            ps.setTimestamp(60, java.sql.Timestamp.valueOf(val60));
        } else {
            ps.setNull(60, Types.TIMESTAMP);
        }
        ps.setString(61, fgdupont.getLayoutUuid());
        ps.setString(62, fgdupont.getLoanRequestType());
        ps.setString(63, fgdupont.getFinanceParty());
        ps.setString(64, fgdupont.getFinanceRequestStatus());
        ps.setString(65, fgdupont.getFinanceRequested());
        Integer val66 = fgdupont.getLayoutTemplateID();
        if (val66 != null) {
            ps.setInt(66, val66);
        } else {
            ps.setNull(66, Types.INTEGER);
        }
    }

    private FgDupont extract(ResultSet rs) throws SQLException {
        FgDupont fgdupont = new FgDupont();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdupont.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgdupont.setReferenceID(REFERENCE_ID);
        fgdupont.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgdupont.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgdupont.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdupont.setStageCode(rs.getString(COL_STAGE_CODE));
        fgdupont.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdupont.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdupont.setCreatedBy(CREATED_BY);
        fgdupont.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdupont.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdupont.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdupont.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgdupont.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgdupont.setIsTemplate(IS_TEMPLATE);
        fgdupont.setRaisedBy(rs.getString(COL_RAISED_BY));
        Timestamp UPLOAD_DATE = rs.getTimestamp(COL_UPLOAD_DATE);
        if (UPLOAD_DATE != null)
            fgdupont.setUploadDate(UPLOAD_DATE.toLocalDateTime());
        fgdupont.setVendorName(rs.getString(COL_VENDOR_NAME));
        fgdupont.setCrn(rs.getString(COL_CRN));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fgdupont.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        fgdupont.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        Timestamp DUE_DATE_OF_INVOICE = rs.getTimestamp(COL_DUE_DATE_OF_INVOICE);
        if (DUE_DATE_OF_INVOICE != null)
            fgdupont.setDueDateOfInvoice(DUE_DATE_OF_INVOICE.toLocalDateTime());
        fgdupont.setCurrency(rs.getString(COL_CURRENCY));
        fgdupont.setState(rs.getString(COL_STATE));
        fgdupont.setVendorCode(rs.getString(COL_VENDOR_CODE));
        Timestamp DISCOUNTING_DATE = rs.getTimestamp(COL_DISCOUNTING_DATE);
        if (DISCOUNTING_DATE != null)
            fgdupont.setDiscountingDate(DISCOUNTING_DATE.toLocalDateTime());
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgdupont.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setInvoiceAmount(INVOICE_AMOUNT);
        java.math.BigDecimal FUNDING_AMOUNT = rs.getObject(COL_FUNDING_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setFundingAmount(FUNDING_AMOUNT);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgdupont.setLineNo(LINE_NO);
        fgdupont.setCustomerAcNo(rs.getString(COL_CUSTOMER_AC_NO));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgdupont.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setDisplayAmount(DISPLAY_AMOUNT);
        fgdupont.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgdupont.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgdupont.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgdupont.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgdupont.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgdupont.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgdupont.setFileName(rs.getString(COL_FILE_NAME));
        fgdupont.setBatchStatus(rs.getString(COL_BATCH_STATUS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgdupont.setBatchRefID(BATCH_REF_ID);
        fgdupont.setBatchRemarks(rs.getString(COL_BATCH_REMARKS));
        fgdupont.setTiStatus(rs.getString(COL_TI_STATUS));
        Integer TI_BATCH_REF_ID = rs.getObject(COL_TI_BATCH_REF_ID, Integer.class);
        fgdupont.setTiBatchRefID(TI_BATCH_REF_ID);
        fgdupont.setTiRemarks(rs.getString(COL_TI_REMARKS));
        fgdupont.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        Integer TNX_DISPLAY_BATCH_ID = rs.getObject(COL_TNX_DISPLAY_BATCH_ID, Integer.class);
        fgdupont.setTnxDisplayBatchID(TNX_DISPLAY_BATCH_ID);
        fgdupont.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        fgdupont.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgdupont.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        fgdupont.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        fgdupont.setNetPayment(NET_PAYMENT);
        fgdupont.setValueDate(rs.getString(COL_VALUE_DATE));
        fgdupont.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        fgdupont.setCharges(CHARGES);
        fgdupont.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Timestamp CUSTOM_MATURITY_DATE = rs.getTimestamp(COL_CUSTOM_MATURITY_DATE);
        if (CUSTOM_MATURITY_DATE != null)
            fgdupont.setCustomMaturityDate(CUSTOM_MATURITY_DATE.toLocalDateTime());
        fgdupont.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        fgdupont.setLoanRequestType(rs.getString(COL_LOAN_REQUEST_TYPE));
        fgdupont.setFinanceParty(rs.getString(COL_FINANCE_PARTY));
        fgdupont.setFinanceRequestStatus(rs.getString(COL_FINANCE_REQUEST_STATUS));
        fgdupont.setFinanceRequested(rs.getString(COL_FINANCE_REQUESTED));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgdupont.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        return fgdupont;
    }
}
