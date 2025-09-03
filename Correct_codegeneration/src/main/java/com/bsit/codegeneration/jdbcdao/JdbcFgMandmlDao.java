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

public class JdbcFgMandmlDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMandmlDao.class);

    private static final String TABLE = "FG_MANDML";

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

    private static final String COL_RECORD_INDICATOR = "RECORD_INDICATOR";

    private static final String COL_VENDOR_NAME = "VENDOR_NAME";

    private static final String COL_PAYEE_NAME = "PAYEE_NAME";

    private static final String COL_ADDRESS_1 = "ADDRESS_1";

    private static final String COL_ADDRESS_2 = "ADDRESS_2";

    private static final String COL_ADDRESS_3 = "ADDRESS_3";

    private static final String COL_CITY = "CITY";

    private static final String COL_PAYEE_TYPE = "PAYEE_TYPE";

    private static final String COL_PAYEE_ACCOUNT = "PAYEE_ACCOUNT";

    private static final String COL_IFSC = "IFSC";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_CURRENCY_CODE = "CURRENCY_CODE";

    private static final String COL_AMOUNT = "AMOUNT";

    private static final String COL_START_DATE = "START_DATE";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_TRANS_ID = "TRANS_ID";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_EMAIL = "EMAIL";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_CLIENT_CODE = "CLIENT_CODE";

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

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

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

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_FINANCE_REQUESTED = "FINANCE_REQUESTED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RECORD_INDICATOR, COL_VENDOR_NAME, COL_PAYEE_NAME, COL_ADDRESS_1, COL_ADDRESS_2, COL_ADDRESS_3, COL_CITY, COL_PAYEE_TYPE, COL_PAYEE_ACCOUNT, COL_IFSC, COL_INVOICE_NUMBER, COL_CURRENCY_CODE, COL_AMOUNT, COL_START_DATE, COL_END_DATE, COL_TRANS_ID, COL_INTEREST_RATE, COL_EMAIL, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_CLIENT_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_ISSUING_PARTY_CODE, COL_APPLICANT_PARTY_CODE, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_LAYOUT_NAME, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_FINANCE_REQUESTED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_INDICATOR, VENDOR_NAME, PAYEE_NAME, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PAYEE_TYPE, PAYEE_ACCOUNT, IFSC, INVOICE_NUMBER, CURRENCY_CODE, AMOUNT, START_DATE, END_DATE, TRANS_ID, INTEREST_RATE, EMAIL, UPLOAD_REF_ID, LINE_NO, CLIENT_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, ISSUING_PARTY_CODE, APPLICANT_PARTY_CODE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, LAYOUT_TEMPLATE_ID, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_INDICATOR, VENDOR_NAME, PAYEE_NAME, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PAYEE_TYPE, PAYEE_ACCOUNT, IFSC, INVOICE_NUMBER, CURRENCY_CODE, AMOUNT, START_DATE, END_DATE, TRANS_ID, INTEREST_RATE, EMAIL, UPLOAD_REF_ID, LINE_NO, CLIENT_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, ISSUING_PARTY_CODE, APPLICANT_PARTY_CODE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, LAYOUT_TEMPLATE_ID, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RECORD_INDICATOR, COL_VENDOR_NAME, COL_PAYEE_NAME, COL_ADDRESS_1, COL_ADDRESS_2, COL_ADDRESS_3, COL_CITY, COL_PAYEE_TYPE, COL_PAYEE_ACCOUNT, COL_IFSC, COL_INVOICE_NUMBER, COL_CURRENCY_CODE, COL_AMOUNT, COL_START_DATE, COL_END_DATE, COL_TRANS_ID, COL_INTEREST_RATE, COL_EMAIL, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_CLIENT_CODE, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_ISSUING_PARTY_CODE, COL_APPLICANT_PARTY_CODE, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_LAYOUT_NAME, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_FINANCE_REQUESTED, COL_ID);

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

    public int insert(Connection conn, FgMandml fgmandml) throws SQLException {
        logger.debug("Inserting fgmandml: {}", fgmandml);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMandmlParams(ps, fgmandml);
            ps.executeUpdate();
            return fgmandml.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgMandml> fgmandmls) throws SQLException {
        if (fgmandmls == null || fgmandmls.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmandmls.size(); i++) {
            if (fgmandmls.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMandml>> batches = chunkList(fgmandmls, batchSize);
        int[] totalResults = new int[fgmandmls.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMandml> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMandml fgmandml : batch) {
                        setFgMandmlParams(ps, fgmandml);
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

    public FgMandml findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMandml> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMandml> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMandml fgmandml) throws SQLException {
        if (fgmandml.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMandmlParams(ps, fgmandml);
            ps.setInt(71, fgmandml.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMandml> fgmandmls) throws SQLException {
        if (fgmandmls == null || fgmandmls.isEmpty())
            return new int[0];
        for (FgMandml fgmandml : fgmandmls) {
            if (fgmandml == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmandml.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMandml>> batches = chunkList(fgmandmls, batchSize);
        int[] totalResults = new int[fgmandmls.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMandml> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMandml fgmandml : batch) {
                        setFgMandmlParams(ps, fgmandml);
                        ps.setInt(71, fgmandml.getID());
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

    private void setFgMandmlParams(PreparedStatement ps, FgMandml fgmandml) throws SQLException {
        Integer val1 = fgmandml.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmandml.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmandml.getTypeCode());
        ps.setString(4, fgmandml.getSubTypeCode());
        ps.setString(5, fgmandml.getActiveCode());
        ps.setString(6, fgmandml.getStageCode());
        ps.setString(7, fgmandml.getStatusCode());
        ps.setString(8, fgmandml.getCreatedOn());
        java.math.BigDecimal val9 = fgmandml.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmandml.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmandml.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmandml.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgmandml.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgmandml.getTemplate());
        java.math.BigDecimal val15 = fgmandml.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgmandml.getRecordIndicator());
        ps.setString(17, fgmandml.getVendorName());
        ps.setString(18, fgmandml.getPayeeName());
        ps.setString(19, fgmandml.getAddress1());
        ps.setString(20, fgmandml.getAddress2());
        ps.setString(21, fgmandml.getAddress3());
        ps.setString(22, fgmandml.getCity());
        ps.setString(23, fgmandml.getPayeeType());
        ps.setString(24, fgmandml.getPayeeAccount());
        ps.setString(25, fgmandml.getIfsc());
        ps.setString(26, fgmandml.getInvoiceNumber());
        ps.setString(27, fgmandml.getCurrencyCode());
        java.math.BigDecimal val28 = fgmandml.getAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.time.LocalDateTime val29 = fgmandml.getStartDate();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val30 = fgmandml.getEndDate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        Integer val31 = fgmandml.getTransID();
        if (val31 != null) {
            ps.setInt(31, val31);
        } else {
            ps.setNull(31, Types.INTEGER);
        }
        java.math.BigDecimal val32 = fgmandml.getInterestRate();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, fgmandml.getEmail());
        Integer val34 = fgmandml.getUploadRefID();
        if (val34 != null) {
            ps.setInt(34, val34);
        } else {
            ps.setNull(34, Types.INTEGER);
        }
        java.math.BigDecimal val35 = fgmandml.getLineNo();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgmandml.getClientCode());
        java.math.BigDecimal val37 = fgmandml.getEquivalentAmount();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        ps.setString(38, fgmandml.getEquivalentCurrency());
        java.math.BigDecimal val39 = fgmandml.getDisplayAmount();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgmandml.getDisplayCurrency());
        java.math.BigDecimal val41 = fgmandml.getAuthEquivalentAmount();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, fgmandml.getAuthEquivalentCurrency());
        java.math.BigDecimal val43 = fgmandml.getDisplayEquivalentAmount();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, fgmandml.getDisplayEquivalentCurrency());
        java.math.BigDecimal val45 = fgmandml.getAuthFxBaseRate();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = fgmandml.getDisplayFxBaseRate();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        ps.setString(47, fgmandml.getIssuingPartyCode());
        ps.setString(48, fgmandml.getApplicantPartyCode());
        ps.setString(49, fgmandml.getFileName());
        ps.setString(50, fgmandml.getBatchStatus());
        Integer val51 = fgmandml.getBatchRefID();
        if (val51 != null) {
            ps.setInt(51, val51);
        } else {
            ps.setNull(51, Types.INTEGER);
        }
        ps.setString(52, fgmandml.getBatchRemarks());
        ps.setString(53, fgmandml.getTiStatus());
        Integer val54 = fgmandml.getTiBatchRefID();
        if (val54 != null) {
            ps.setInt(54, val54);
        } else {
            ps.setNull(54, Types.INTEGER);
        }
        ps.setString(55, fgmandml.getTiRemarks());
        ps.setString(56, fgmandml.getTnxDisplayStatus());
        Integer val57 = fgmandml.getTnxDisplayBatchID();
        if (val57 != null) {
            ps.setInt(57, val57);
        } else {
            ps.setNull(57, Types.INTEGER);
        }
        ps.setString(58, fgmandml.getTnxDisplayRemarks());
        java.math.BigDecimal val59 = fgmandml.getAdvanceInterest();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        java.math.BigDecimal val60 = fgmandml.getNetPayment();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        ps.setString(61, fgmandml.getValueDate());
        ps.setString(62, fgmandml.getUtrNumber());
        java.math.BigDecimal val63 = fgmandml.getCharges();
        if (val63 != null) {
            ps.setBigDecimal(63, val63);
        } else {
            ps.setNull(63, Types.DECIMAL);
        }
        ps.setString(64, fgmandml.getLayoutName());
        java.time.LocalDateTime val65 = fgmandml.getCustomMaturityDate();
        if (val65 != null) {
            ps.setTimestamp(65, java.sql.Timestamp.valueOf(val65));
        } else {
            ps.setNull(65, Types.TIMESTAMP);
        }
        ps.setString(66, fgmandml.getLayoutUuid());
        ps.setString(67, fgmandml.getLoanRequestType());
        ps.setString(68, fgmandml.getFinanceParty());
        ps.setString(69, fgmandml.getFinanceRequestStatus());
        Integer val70 = fgmandml.getLayoutTemplateID();
        if (val70 != null) {
            ps.setInt(70, val70);
        } else {
            ps.setNull(70, Types.INTEGER);
        }
        ps.setString(71, fgmandml.getFinanceRequested());
    }

    private FgMandml extract(ResultSet rs) throws SQLException {
        FgMandml fgmandml = new FgMandml();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmandml.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmandml.setReferenceID(REFERENCE_ID);
        fgmandml.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmandml.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmandml.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmandml.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmandml.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmandml.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmandml.setCreatedBy(CREATED_BY);
        fgmandml.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmandml.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmandml.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmandml.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmandml.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgmandml.setIsTemplate(IS_TEMPLATE);
        fgmandml.setRecordIndicator(rs.getString(COL_RECORD_INDICATOR));
        fgmandml.setVendorName(rs.getString(COL_VENDOR_NAME));
        fgmandml.setPayeeName(rs.getString(COL_PAYEE_NAME));
        fgmandml.setAddress1(rs.getString(COL_ADDRESS_1));
        fgmandml.setAddress2(rs.getString(COL_ADDRESS_2));
        fgmandml.setAddress3(rs.getString(COL_ADDRESS_3));
        fgmandml.setCity(rs.getString(COL_CITY));
        fgmandml.setPayeeType(rs.getString(COL_PAYEE_TYPE));
        fgmandml.setPayeeAccount(rs.getString(COL_PAYEE_ACCOUNT));
        fgmandml.setIfsc(rs.getString(COL_IFSC));
        fgmandml.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        fgmandml.setCurrencyCode(rs.getString(COL_CURRENCY_CODE));
        java.math.BigDecimal AMOUNT = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        fgmandml.setAmount(AMOUNT);
        Timestamp START_DATE = rs.getTimestamp(COL_START_DATE);
        if (START_DATE != null)
            fgmandml.setStartDate(START_DATE.toLocalDateTime());
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            fgmandml.setEndDate(END_DATE.toLocalDateTime());
        Integer TRANS_ID = rs.getObject(COL_TRANS_ID, Integer.class);
        fgmandml.setTransID(TRANS_ID);
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        fgmandml.setInterestRate(INTEREST_RATE);
        fgmandml.setEmail(rs.getString(COL_EMAIL));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgmandml.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgmandml.setLineNo(LINE_NO);
        fgmandml.setClientCode(rs.getString(COL_CLIENT_CODE));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgmandml.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgmandml.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgmandml.setDisplayAmount(DISPLAY_AMOUNT);
        fgmandml.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgmandml.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgmandml.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgmandml.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgmandml.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgmandml.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgmandml.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgmandml.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgmandml.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgmandml.setFileName(rs.getString(COL_FILE_NAME));
        fgmandml.setBatchStatus(rs.getString(COL_BATCH_STATUS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgmandml.setBatchRefID(BATCH_REF_ID);
        fgmandml.setBatchRemarks(rs.getString(COL_BATCH_REMARKS));
        fgmandml.setTiStatus(rs.getString(COL_TI_STATUS));
        Integer TI_BATCH_REF_ID = rs.getObject(COL_TI_BATCH_REF_ID, Integer.class);
        fgmandml.setTiBatchRefID(TI_BATCH_REF_ID);
        fgmandml.setTiRemarks(rs.getString(COL_TI_REMARKS));
        fgmandml.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        Integer TNX_DISPLAY_BATCH_ID = rs.getObject(COL_TNX_DISPLAY_BATCH_ID, Integer.class);
        fgmandml.setTnxDisplayBatchID(TNX_DISPLAY_BATCH_ID);
        fgmandml.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        fgmandml.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        fgmandml.setNetPayment(NET_PAYMENT);
        fgmandml.setValueDate(rs.getString(COL_VALUE_DATE));
        fgmandml.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        fgmandml.setCharges(CHARGES);
        fgmandml.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Timestamp CUSTOM_MATURITY_DATE = rs.getTimestamp(COL_CUSTOM_MATURITY_DATE);
        if (CUSTOM_MATURITY_DATE != null)
            fgmandml.setCustomMaturityDate(CUSTOM_MATURITY_DATE.toLocalDateTime());
        fgmandml.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        fgmandml.setLoanRequestType(rs.getString(COL_LOAN_REQUEST_TYPE));
        fgmandml.setFinanceParty(rs.getString(COL_FINANCE_PARTY));
        fgmandml.setFinanceRequestStatus(rs.getString(COL_FINANCE_REQUEST_STATUS));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgmandml.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fgmandml.setFinanceRequested(rs.getString(COL_FINANCE_REQUESTED));
        return fgmandml;
    }
}
