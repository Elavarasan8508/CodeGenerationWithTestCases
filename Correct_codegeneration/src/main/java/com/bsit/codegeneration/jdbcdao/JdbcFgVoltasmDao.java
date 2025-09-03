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

public class JdbcFgVoltasmDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgVoltasmDao.class);

    private static final String TABLE = "FG_VOLTASM";

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

    private static final String COL_CLIENT_CODE = "CLIENT_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PAYMENT_TYPE = "PAYMENT_TYPE";

    private static final String COL_PAYMENT_REF_NO = "PAYMENT_REF_NO";

    private static final String COL_PAYMENT_DATE = "PAYMENT_DATE";

    private static final String COL_INSTRUMENT_DATE = "INSTRUMENT_DATE";

    private static final String COL_AMOUNT = "AMOUNT";

    private static final String COL_BANK_CODE_INDICATOR = "BANK_CODE_INDICATOR";

    private static final String COL_BENEFICIARY_CODE = "BENEFICIARY_CODE";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_BENEFICIARY_BANK = "BENEFICIARY_BANK";

    private static final String COL_BENEFICIARY_BRANCH = "BENEFICIARY_BRANCH";

    private static final String COL_LOCATION = "LOCATION";

    private static final String COL_PRINT_LOCATION = "PRINT_LOCATION";

    private static final String COL_INSTRUMENT_NO = "INSTRUMENT_NO";

    private static final String COL_BENEFICIARY_ADDRESS_1 = "BENEFICIARY_ADDRESS_1";

    private static final String COL_BENEFICIARY_ADDRESS_2 = "BENEFICIARY_ADDRESS_2";

    private static final String COL_BENEFICIARY_ADDRESS_3 = "BENEFICIARY_ADDRESS_3";

    private static final String COL_BENEFICIARY_ADDRESS_4 = "BENEFICIARY_ADDRESS_4";

    private static final String COL_BENEFICIARY_EMAIL = "BENEFICIARY_EMAIL";

    private static final String COL_BENEFICIARY_MOBILE = "BENEFICIARY_MOBILE";

    private static final String COL_DEBIT_NARRATION = "DEBIT_NARRATION";

    private static final String COL_CREDIT_NARRATION = "CREDIT_NARRATION";

    private static final String COL_PAYMENT_DETAILS_1 = "PAYMENT_DETAILS_1";

    private static final String COL_PAYMENT_DETAILS_2 = "PAYMENT_DETAILS_2";

    private static final String COL_PAYMENT_DETAILS_3 = "PAYMENT_DETAILS_3";

    private static final String COL_PAYMENT_DETAILS_4 = "PAYMENT_DETAILS_4";

    private static final String COL_SR_NO = "SR_NO";

    private static final String COL_DOCUMENT_NO = "DOCUMENT_NO";

    private static final String COL_INV_REF_NO = "INV_REF_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_AMOUNT = "INV_AMOUNT";

    private static final String COL_OTHER_DEDUCTIONS = "OTHER_DEDUCTIONS";

    private static final String COL_TDS_AMOUNT = "TDS_AMOUNT";

    private static final String COL_TOTAL_DEDUCTED_AMOUNT = "TOTAL_DEDUCTED_AMOUNT";

    private static final String COL_NET_AMOUNT_PAYABLE = "NET_AMOUNT_PAYABLE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_UPLOAD_LAYOUT_UUID = "UPLOAD_LAYOUT_UUID";

    private static final String COL_BENEFICIARY_ACC_NO = "BENEFICIARY_ACC_NO";

    private static final String COL_DR_AC_NO = "DR_AC_NO";

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
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CLIENT_CODE, COL_PRODUCT_CODE, COL_PAYMENT_TYPE, COL_PAYMENT_REF_NO, COL_PAYMENT_DATE, COL_INSTRUMENT_DATE, COL_AMOUNT, COL_BANK_CODE_INDICATOR, COL_BENEFICIARY_CODE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_BANK, COL_BENEFICIARY_BRANCH, COL_LOCATION, COL_PRINT_LOCATION, COL_INSTRUMENT_NO, COL_BENEFICIARY_ADDRESS_1, COL_BENEFICIARY_ADDRESS_2, COL_BENEFICIARY_ADDRESS_3, COL_BENEFICIARY_ADDRESS_4, COL_BENEFICIARY_EMAIL, COL_BENEFICIARY_MOBILE, COL_DEBIT_NARRATION, COL_CREDIT_NARRATION, COL_PAYMENT_DETAILS_1, COL_PAYMENT_DETAILS_2, COL_PAYMENT_DETAILS_3, COL_PAYMENT_DETAILS_4, COL_SR_NO, COL_DOCUMENT_NO, COL_INV_REF_NO, COL_INV_DATE, COL_INV_AMOUNT, COL_OTHER_DEDUCTIONS, COL_TDS_AMOUNT, COL_TOTAL_DEDUCTED_AMOUNT, COL_NET_AMOUNT_PAYABLE, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_UPLOAD_LAYOUT_UUID, COL_BENEFICIARY_ACC_NO, COL_DR_AC_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CODE, PRODUCT_CODE, PAYMENT_TYPE, PAYMENT_REF_NO, PAYMENT_DATE, INSTRUMENT_DATE, AMOUNT, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_NAME, BENEFICIARY_BANK, BENEFICIARY_BRANCH, LOCATION, PRINT_LOCATION, INSTRUMENT_NO, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, SR_NO, DOCUMENT_NO, INV_REF_NO, INV_DATE, INV_AMOUNT, OTHER_DEDUCTIONS, TDS_AMOUNT, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, UPLOAD_REF_ID, LINE_NO, UPLOAD_LAYOUT_UUID, BENEFICIARY_ACC_NO, DR_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CODE, PRODUCT_CODE, PAYMENT_TYPE, PAYMENT_REF_NO, PAYMENT_DATE, INSTRUMENT_DATE, AMOUNT, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_NAME, BENEFICIARY_BANK, BENEFICIARY_BRANCH, LOCATION, PRINT_LOCATION, INSTRUMENT_NO, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, SR_NO, DOCUMENT_NO, INV_REF_NO, INV_DATE, INV_AMOUNT, OTHER_DEDUCTIONS, TDS_AMOUNT, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, UPLOAD_REF_ID, LINE_NO, UPLOAD_LAYOUT_UUID, BENEFICIARY_ACC_NO, DR_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CLIENT_CODE, COL_PRODUCT_CODE, COL_PAYMENT_TYPE, COL_PAYMENT_REF_NO, COL_PAYMENT_DATE, COL_INSTRUMENT_DATE, COL_AMOUNT, COL_BANK_CODE_INDICATOR, COL_BENEFICIARY_CODE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_BANK, COL_BENEFICIARY_BRANCH, COL_LOCATION, COL_PRINT_LOCATION, COL_INSTRUMENT_NO, COL_BENEFICIARY_ADDRESS_1, COL_BENEFICIARY_ADDRESS_2, COL_BENEFICIARY_ADDRESS_3, COL_BENEFICIARY_ADDRESS_4, COL_BENEFICIARY_EMAIL, COL_BENEFICIARY_MOBILE, COL_DEBIT_NARRATION, COL_CREDIT_NARRATION, COL_PAYMENT_DETAILS_1, COL_PAYMENT_DETAILS_2, COL_PAYMENT_DETAILS_3, COL_PAYMENT_DETAILS_4, COL_SR_NO, COL_DOCUMENT_NO, COL_INV_REF_NO, COL_INV_DATE, COL_INV_AMOUNT, COL_OTHER_DEDUCTIONS, COL_TDS_AMOUNT, COL_TOTAL_DEDUCTED_AMOUNT, COL_NET_AMOUNT_PAYABLE, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_UPLOAD_LAYOUT_UUID, COL_BENEFICIARY_ACC_NO, COL_DR_AC_NO, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_DISPLAY_AMOUNT, COL_DISPLAY_CURRENCY, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_ID);

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

    public int insert(Connection conn, FgVoltasm fgvoltasm) throws SQLException {
        logger.debug("Inserting fgvoltasm: {}", fgvoltasm);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgVoltasmParams(ps, fgvoltasm);
            ps.executeUpdate();
            return fgvoltasm.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgVoltasm> fgvoltasms) throws SQLException {
        if (fgvoltasms == null || fgvoltasms.isEmpty())
            return new int[0];
        for (int i = 0; i < fgvoltasms.size(); i++) {
            if (fgvoltasms.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgVoltasm>> batches = chunkList(fgvoltasms, batchSize);
        int[] totalResults = new int[fgvoltasms.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgVoltasm> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgVoltasm fgvoltasm : batch) {
                        setFgVoltasmParams(ps, fgvoltasm);
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

    public FgVoltasm findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgVoltasm> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgVoltasm> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgVoltasm fgvoltasm) throws SQLException {
        if (fgvoltasm.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgVoltasmParams(ps, fgvoltasm);
            ps.setInt(69, fgvoltasm.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgVoltasm> fgvoltasms) throws SQLException {
        if (fgvoltasms == null || fgvoltasms.isEmpty())
            return new int[0];
        for (FgVoltasm fgvoltasm : fgvoltasms) {
            if (fgvoltasm == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgvoltasm.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgVoltasm>> batches = chunkList(fgvoltasms, batchSize);
        int[] totalResults = new int[fgvoltasms.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgVoltasm> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgVoltasm fgvoltasm : batch) {
                        setFgVoltasmParams(ps, fgvoltasm);
                        ps.setInt(69, fgvoltasm.getID());
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

    private void setFgVoltasmParams(PreparedStatement ps, FgVoltasm fgvoltasm) throws SQLException {
        Integer val1 = fgvoltasm.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgvoltasm.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgvoltasm.getTypeCode());
        ps.setString(4, fgvoltasm.getSubTypeCode());
        ps.setString(5, fgvoltasm.getActiveCode());
        ps.setString(6, fgvoltasm.getStageCode());
        ps.setString(7, fgvoltasm.getStatusCode());
        ps.setString(8, fgvoltasm.getCreatedOn());
        java.math.BigDecimal val9 = fgvoltasm.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgvoltasm.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgvoltasm.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgvoltasm.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgvoltasm.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgvoltasm.getTemplate());
        java.math.BigDecimal val15 = fgvoltasm.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgvoltasm.getClientCode());
        ps.setString(17, fgvoltasm.getProductCode());
        ps.setString(18, fgvoltasm.getPaymentType());
        ps.setString(19, fgvoltasm.getPaymentRefNo());
        java.time.LocalDateTime val20 = fgvoltasm.getPaymentDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val21 = fgvoltasm.getInstrumentDate();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        java.math.BigDecimal val22 = fgvoltasm.getAmount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgvoltasm.getBankCodeIndicator());
        ps.setString(24, fgvoltasm.getBeneficiaryCode());
        ps.setString(25, fgvoltasm.getBeneficiaryName());
        ps.setString(26, fgvoltasm.getBeneficiaryBank());
        ps.setString(27, fgvoltasm.getBeneficiaryBranch());
        ps.setString(28, fgvoltasm.getLocation());
        ps.setString(29, fgvoltasm.getPrintLocation());
        java.math.BigDecimal val30 = fgvoltasm.getInstrumentNo();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgvoltasm.getBeneficiaryAddress1());
        ps.setString(32, fgvoltasm.getBeneficiaryAddress2());
        ps.setString(33, fgvoltasm.getBeneficiaryAddress3());
        ps.setString(34, fgvoltasm.getBeneficiaryAddress4());
        ps.setString(35, fgvoltasm.getBeneficiaryEmail());
        ps.setString(36, fgvoltasm.getBeneficiaryMobile());
        ps.setString(37, fgvoltasm.getDebitNarration());
        ps.setString(38, fgvoltasm.getCreditNarration());
        ps.setString(39, fgvoltasm.getPaymentDetails1());
        ps.setString(40, fgvoltasm.getPaymentDetails2());
        ps.setString(41, fgvoltasm.getPaymentDetails3());
        ps.setString(42, fgvoltasm.getPaymentDetails4());
        ps.setString(43, fgvoltasm.getSrNo());
        ps.setString(44, fgvoltasm.getDocumentNo());
        ps.setString(45, fgvoltasm.getInvRefNo());
        java.time.LocalDateTime val46 = fgvoltasm.getInvDate();
        if (val46 != null) {
            ps.setTimestamp(46, java.sql.Timestamp.valueOf(val46));
        } else {
            ps.setNull(46, Types.TIMESTAMP);
        }
        java.math.BigDecimal val47 = fgvoltasm.getInvAmount();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = fgvoltasm.getOtherDeductions();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        java.math.BigDecimal val49 = fgvoltasm.getTdsAmount();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = fgvoltasm.getTotalDeductedAmount();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = fgvoltasm.getNetAmountPayable();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        Integer val52 = fgvoltasm.getUploadRefID();
        if (val52 != null) {
            ps.setInt(52, val52);
        } else {
            ps.setNull(52, Types.INTEGER);
        }
        java.math.BigDecimal val53 = fgvoltasm.getLineNo();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, fgvoltasm.getUploadLayoutUuid());
        ps.setString(55, fgvoltasm.getBeneficiaryAccNo());
        ps.setString(56, fgvoltasm.getDrAcNo());
        java.math.BigDecimal val57 = fgvoltasm.getEquivalentAmount();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, fgvoltasm.getEquivalentCurrency());
        java.math.BigDecimal val59 = fgvoltasm.getDisplayAmount();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        ps.setString(60, fgvoltasm.getDisplayCurrency());
        java.math.BigDecimal val61 = fgvoltasm.getAuthEquivalentAmount();
        if (val61 != null) {
            ps.setBigDecimal(61, val61);
        } else {
            ps.setNull(61, Types.DECIMAL);
        }
        ps.setString(62, fgvoltasm.getAuthEquivalentCurrency());
        java.math.BigDecimal val63 = fgvoltasm.getDisplayEquivalentAmount();
        if (val63 != null) {
            ps.setBigDecimal(63, val63);
        } else {
            ps.setNull(63, Types.DECIMAL);
        }
        ps.setString(64, fgvoltasm.getDisplayEquivalentCurrency());
        java.math.BigDecimal val65 = fgvoltasm.getAuthFxBaseRate();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        java.math.BigDecimal val66 = fgvoltasm.getDisplayFxBaseRate();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        ps.setString(67, fgvoltasm.getApplicantPartyCode());
        ps.setString(68, fgvoltasm.getIssuingPartyCode());
        ps.setString(69, fgvoltasm.getFileName());
    }

    private FgVoltasm extract(ResultSet rs) throws SQLException {
        FgVoltasm fgvoltasm = new FgVoltasm();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgvoltasm.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgvoltasm.setReferenceID(REFERENCE_ID);
        fgvoltasm.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgvoltasm.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgvoltasm.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgvoltasm.setStageCode(rs.getString(COL_STAGE_CODE));
        fgvoltasm.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgvoltasm.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgvoltasm.setCreatedBy(CREATED_BY);
        fgvoltasm.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgvoltasm.setLastUpdatedBy(LAST_UPDATED_BY);
        fgvoltasm.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgvoltasm.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgvoltasm.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgvoltasm.setIsTemplate(IS_TEMPLATE);
        fgvoltasm.setClientCode(rs.getString(COL_CLIENT_CODE));
        fgvoltasm.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgvoltasm.setPaymentType(rs.getString(COL_PAYMENT_TYPE));
        fgvoltasm.setPaymentRefNo(rs.getString(COL_PAYMENT_REF_NO));
        Timestamp PAYMENT_DATE = rs.getTimestamp(COL_PAYMENT_DATE);
        if (PAYMENT_DATE != null)
            fgvoltasm.setPaymentDate(PAYMENT_DATE.toLocalDateTime());
        Timestamp INSTRUMENT_DATE = rs.getTimestamp(COL_INSTRUMENT_DATE);
        if (INSTRUMENT_DATE != null)
            fgvoltasm.setInstrumentDate(INSTRUMENT_DATE.toLocalDateTime());
        java.math.BigDecimal AMOUNT = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setAmount(AMOUNT);
        fgvoltasm.setBankCodeIndicator(rs.getString(COL_BANK_CODE_INDICATOR));
        fgvoltasm.setBeneficiaryCode(rs.getString(COL_BENEFICIARY_CODE));
        fgvoltasm.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        fgvoltasm.setBeneficiaryBank(rs.getString(COL_BENEFICIARY_BANK));
        fgvoltasm.setBeneficiaryBranch(rs.getString(COL_BENEFICIARY_BRANCH));
        fgvoltasm.setLocation(rs.getString(COL_LOCATION));
        fgvoltasm.setPrintLocation(rs.getString(COL_PRINT_LOCATION));
        java.math.BigDecimal INSTRUMENT_NO = rs.getObject(COL_INSTRUMENT_NO, java.math.BigDecimal.class);
        fgvoltasm.setInstrumentNo(INSTRUMENT_NO);
        fgvoltasm.setBeneficiaryAddress1(rs.getString(COL_BENEFICIARY_ADDRESS_1));
        fgvoltasm.setBeneficiaryAddress2(rs.getString(COL_BENEFICIARY_ADDRESS_2));
        fgvoltasm.setBeneficiaryAddress3(rs.getString(COL_BENEFICIARY_ADDRESS_3));
        fgvoltasm.setBeneficiaryAddress4(rs.getString(COL_BENEFICIARY_ADDRESS_4));
        fgvoltasm.setBeneficiaryEmail(rs.getString(COL_BENEFICIARY_EMAIL));
        fgvoltasm.setBeneficiaryMobile(rs.getString(COL_BENEFICIARY_MOBILE));
        fgvoltasm.setDebitNarration(rs.getString(COL_DEBIT_NARRATION));
        fgvoltasm.setCreditNarration(rs.getString(COL_CREDIT_NARRATION));
        fgvoltasm.setPaymentDetails1(rs.getString(COL_PAYMENT_DETAILS_1));
        fgvoltasm.setPaymentDetails2(rs.getString(COL_PAYMENT_DETAILS_2));
        fgvoltasm.setPaymentDetails3(rs.getString(COL_PAYMENT_DETAILS_3));
        fgvoltasm.setPaymentDetails4(rs.getString(COL_PAYMENT_DETAILS_4));
        fgvoltasm.setSrNo(rs.getString(COL_SR_NO));
        fgvoltasm.setDocumentNo(rs.getString(COL_DOCUMENT_NO));
        fgvoltasm.setInvRefNo(rs.getString(COL_INV_REF_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgvoltasm.setInvDate(INV_DATE.toLocalDateTime());
        java.math.BigDecimal INV_AMOUNT = rs.getObject(COL_INV_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setInvAmount(INV_AMOUNT);
        java.math.BigDecimal OTHER_DEDUCTIONS = rs.getObject(COL_OTHER_DEDUCTIONS, java.math.BigDecimal.class);
        fgvoltasm.setOtherDeductions(OTHER_DEDUCTIONS);
        java.math.BigDecimal TDS_AMOUNT = rs.getObject(COL_TDS_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setTdsAmount(TDS_AMOUNT);
        java.math.BigDecimal TOTAL_DEDUCTED_AMOUNT = rs.getObject(COL_TOTAL_DEDUCTED_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setTotalDeductedAmount(TOTAL_DEDUCTED_AMOUNT);
        java.math.BigDecimal NET_AMOUNT_PAYABLE = rs.getObject(COL_NET_AMOUNT_PAYABLE, java.math.BigDecimal.class);
        fgvoltasm.setNetAmountPayable(NET_AMOUNT_PAYABLE);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgvoltasm.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgvoltasm.setLineNo(LINE_NO);
        fgvoltasm.setUploadLayoutUuid(rs.getString(COL_UPLOAD_LAYOUT_UUID));
        fgvoltasm.setBeneficiaryAccNo(rs.getString(COL_BENEFICIARY_ACC_NO));
        fgvoltasm.setDrAcNo(rs.getString(COL_DR_AC_NO));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fgvoltasm.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_AMOUNT = rs.getObject(COL_DISPLAY_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setDisplayAmount(DISPLAY_AMOUNT);
        fgvoltasm.setDisplayCurrency(rs.getString(COL_DISPLAY_CURRENCY));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgvoltasm.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgvoltasm.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgvoltasm.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgvoltasm.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgvoltasm.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgvoltasm.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgvoltasm.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgvoltasm.setFileName(rs.getString(COL_FILE_NAME));
        return fgvoltasm;
    }
}
