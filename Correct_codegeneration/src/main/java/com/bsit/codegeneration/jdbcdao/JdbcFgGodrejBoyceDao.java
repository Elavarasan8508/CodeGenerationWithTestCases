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

public class JdbcFgGodrejBoyceDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgGodrejBoyceDao.class);

    private static final String TABLE = "FG_GODREJ_BOYCE";

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

    private static final String COL_SELLER_ID = "SELLER_ID";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_BUYER_ID = "BUYER_ID";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_INVOICE_NO = "INVOICE_NO";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_CURRENCY = "CURRENCY";

    private static final String COL_DUE_DATE = "DUE_DATE";

    private static final String COL_REFERENCE_NO = "REFERENCE_NO";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_SR_NO = "SR_NO";

    private static final String COL_TEST1 = "TEST1";

    private static final String COL_TEST2 = "TEST2";

    private static final String COL_TEST3 = "TEST3";

    private static final String COL_TEST4 = "TEST4";

    private static final String COL_AUTH_EQUIVALENT_AMOUNT = "AUTH_EQUIVALENT_AMOUNT";

    private static final String COL_AUTH_EQUIVALENT_CURRENCY = "AUTH_EQUIVALENT_CURRENCY";

    private static final String COL_DISPLAY_EQUIVALENT_AMOUNT = "DISPLAY_EQUIVALENT_AMOUNT";

    private static final String COL_DISPLAY_EQUIVALENT_CURRENCY = "DISPLAY_EQUIVALENT_CURRENCY";

    private static final String COL_EQUIVALENT_AMOUNT = "EQUIVALENT_AMOUNT";

    private static final String COL_EQUIVALENT_CURRENCY = "EQUIVALENT_CURRENCY";

    private static final String COL_AUTH_FX_BASE_RATE = "AUTH_FX_BASE_RATE";

    private static final String COL_DISPLAY_FX_BASE_RATE = "DISPLAY_FX_BASE_RATE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

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

    private static final String COL_FREE_TEXT_1 = "FREE_TEXT_1";

    private static final String COL_FREE_TEXT_2 = "FREE_TEXT_2";

    private static final String COL_FREE_TEXT_3 = "FREE_TEXT_3";

    private static final String COL_PROGRAM_TYPE = "PROGRAM_TYPE";

    private static final String COL_CUSTOM_MATURITY_DATE = "CUSTOM_MATURITY_DATE";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_LOAN_REQUEST_TYPE = "LOAN_REQUEST_TYPE";

    private static final String COL_PORTAL_BATCH_REF_ID = "PORTAL_BATCH_REF_ID";

    private static final String COL_FINANCE_PARTY = "FINANCE_PARTY";

    private static final String COL_FINANCE_REQUEST_STATUS = "FINANCE_REQUEST_STATUS";

    private static final String COL_FINANCE_REQUESTED = "FINANCE_REQUESTED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SELLER_ID, COL_SUPPLIER_NAME, COL_BUYER_ID, COL_INVOICE_DATE, COL_INVOICE_NO, COL_INVOICE_AMOUNT, COL_CURRENCY, COL_DUE_DATE, COL_REFERENCE_NO, COL_UPLOAD_REF_ID, COL_REMARKS, COL_LINE_NO, COL_SR_NO, COL_TEST1, COL_TEST2, COL_TEST3, COL_TEST4, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_APPLICANT_PARTY, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_FREE_TEXT_1, COL_FREE_TEXT_2, COL_FREE_TEXT_3, COL_PROGRAM_TYPE, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_ID, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_PORTAL_BATCH_REF_ID, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SELLER_ID, SUPPLIER_NAME, BUYER_ID, INVOICE_DATE, INVOICE_NO, INVOICE_AMOUNT, CURRENCY, DUE_DATE, REFERENCE_NO, UPLOAD_REF_ID, REMARKS, LINE_NO, SR_NO, TEST1, TEST2, TEST3, TEST4, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, APPLICANT_PARTY, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, FREE_TEXT_1, FREE_TEXT_2, FREE_TEXT_3, PROGRAM_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_ID, LAYOUT_UUID, LOAN_REQUEST_TYPE, PORTAL_BATCH_REF_ID, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SELLER_ID, SUPPLIER_NAME, BUYER_ID, INVOICE_DATE, INVOICE_NO, INVOICE_AMOUNT, CURRENCY, DUE_DATE, REFERENCE_NO, UPLOAD_REF_ID, REMARKS, LINE_NO, SR_NO, TEST1, TEST2, TEST3, TEST4, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, APPLICANT_PARTY, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, FREE_TEXT_1, FREE_TEXT_2, FREE_TEXT_3, PROGRAM_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_ID, LAYOUT_UUID, LOAN_REQUEST_TYPE, PORTAL_BATCH_REF_ID, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SELLER_ID, COL_SUPPLIER_NAME, COL_BUYER_ID, COL_INVOICE_DATE, COL_INVOICE_NO, COL_INVOICE_AMOUNT, COL_CURRENCY, COL_DUE_DATE, COL_REFERENCE_NO, COL_UPLOAD_REF_ID, COL_REMARKS, COL_LINE_NO, COL_SR_NO, COL_TEST1, COL_TEST2, COL_TEST3, COL_TEST4, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_EQUIVALENT_AMOUNT, COL_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_APPLICANT_PARTY, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_FILE_NAME, COL_BATCH_STATUS, COL_BATCH_REF_ID, COL_BATCH_REMARKS, COL_TI_STATUS, COL_TI_BATCH_REF_ID, COL_TI_REMARKS, COL_TNX_DISPLAY_STATUS, COL_TNX_DISPLAY_BATCH_ID, COL_TNX_DISPLAY_REMARKS, COL_ADVANCE_INTEREST, COL_NET_PAYMENT, COL_VALUE_DATE, COL_UTR_NUMBER, COL_CHARGES, COL_FREE_TEXT_1, COL_FREE_TEXT_2, COL_FREE_TEXT_3, COL_PROGRAM_TYPE, COL_CUSTOM_MATURITY_DATE, COL_LAYOUT_ID, COL_LAYOUT_UUID, COL_LOAN_REQUEST_TYPE, COL_PORTAL_BATCH_REF_ID, COL_FINANCE_PARTY, COL_FINANCE_REQUEST_STATUS, COL_FINANCE_REQUESTED, COL_ID);

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

    public int insert(Connection conn, FgGodrejBoyce fggodrejboyce) throws SQLException {
        logger.debug("Inserting fggodrejboyce: {}", fggodrejboyce);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgGodrejBoyceParams(ps, fggodrejboyce);
            ps.executeUpdate();
            return fggodrejboyce.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgGodrejBoyce> fggodrejboyces) throws SQLException {
        if (fggodrejboyces == null || fggodrejboyces.isEmpty())
            return new int[0];
        for (int i = 0; i < fggodrejboyces.size(); i++) {
            if (fggodrejboyces.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgGodrejBoyce>> batches = chunkList(fggodrejboyces, batchSize);
        int[] totalResults = new int[fggodrejboyces.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgGodrejBoyce> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgGodrejBoyce fggodrejboyce : batch) {
                        setFgGodrejBoyceParams(ps, fggodrejboyce);
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

    public FgGodrejBoyce findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgGodrejBoyce> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgGodrejBoyce> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgGodrejBoyce fggodrejboyce) throws SQLException {
        if (fggodrejboyce.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgGodrejBoyceParams(ps, fggodrejboyce);
            ps.setInt(72, fggodrejboyce.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgGodrejBoyce> fggodrejboyces) throws SQLException {
        if (fggodrejboyces == null || fggodrejboyces.isEmpty())
            return new int[0];
        for (FgGodrejBoyce fggodrejboyce : fggodrejboyces) {
            if (fggodrejboyce == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fggodrejboyce.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgGodrejBoyce>> batches = chunkList(fggodrejboyces, batchSize);
        int[] totalResults = new int[fggodrejboyces.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgGodrejBoyce> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgGodrejBoyce fggodrejboyce : batch) {
                        setFgGodrejBoyceParams(ps, fggodrejboyce);
                        ps.setInt(72, fggodrejboyce.getID());
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

    private void setFgGodrejBoyceParams(PreparedStatement ps, FgGodrejBoyce fggodrejboyce) throws SQLException {
        Integer val1 = fggodrejboyce.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fggodrejboyce.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fggodrejboyce.getTypeCode());
        ps.setString(4, fggodrejboyce.getSubTypeCode());
        ps.setString(5, fggodrejboyce.getActiveCode());
        ps.setString(6, fggodrejboyce.getStageCode());
        ps.setString(7, fggodrejboyce.getStatusCode());
        ps.setString(8, fggodrejboyce.getCreatedOn());
        java.math.BigDecimal val9 = fggodrejboyce.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fggodrejboyce.getLastUpdatedOn());
        java.math.BigDecimal val11 = fggodrejboyce.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fggodrejboyce.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fggodrejboyce.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fggodrejboyce.getTemplate());
        java.math.BigDecimal val15 = fggodrejboyce.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fggodrejboyce.getSellerID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, fggodrejboyce.getSupplierName());
        Integer val18 = fggodrejboyce.getBuyerID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        java.time.LocalDateTime val19 = fggodrejboyce.getInvoiceDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        ps.setString(20, fggodrejboyce.getInvoiceNo());
        java.math.BigDecimal val21 = fggodrejboyce.getInvoiceAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fggodrejboyce.getCurrency());
        java.time.LocalDateTime val23 = fggodrejboyce.getDueDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, fggodrejboyce.getReferenceNo());
        Integer val25 = fggodrejboyce.getUploadRefID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        ps.setString(26, fggodrejboyce.getRemarks());
        java.math.BigDecimal val27 = fggodrejboyce.getLineNo();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fggodrejboyce.getSrNo());
        ps.setString(29, fggodrejboyce.getTest1());
        ps.setString(30, fggodrejboyce.getTest2());
        ps.setString(31, fggodrejboyce.getTest3());
        ps.setString(32, fggodrejboyce.getTest4());
        java.math.BigDecimal val33 = fggodrejboyce.getAuthEquivalentAmount();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        ps.setString(34, fggodrejboyce.getAuthEquivalentCurrency());
        java.math.BigDecimal val35 = fggodrejboyce.getDisplayEquivalentAmount();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fggodrejboyce.getDisplayEquivalentCurrency());
        java.math.BigDecimal val37 = fggodrejboyce.getEquivalentAmount();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        ps.setString(38, fggodrejboyce.getEquivalentCurrency());
        java.math.BigDecimal val39 = fggodrejboyce.getAuthFxBaseRate();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        java.math.BigDecimal val40 = fggodrejboyce.getDisplayFxBaseRate();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fggodrejboyce.getApplicantPartyCode());
        ps.setString(42, fggodrejboyce.getIssuingPartyCode());
        ps.setString(43, fggodrejboyce.getApplicantParty());
        Integer val44 = fggodrejboyce.getLayoutTemplateID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        ps.setString(45, fggodrejboyce.getLayoutName());
        ps.setString(46, fggodrejboyce.getFileName());
        ps.setString(47, fggodrejboyce.getBatchStatus());
        Integer val48 = fggodrejboyce.getBatchRefID();
        if (val48 != null) {
            ps.setInt(48, val48);
        } else {
            ps.setNull(48, Types.INTEGER);
        }
        ps.setString(49, fggodrejboyce.getBatchRemarks());
        ps.setString(50, fggodrejboyce.getTiStatus());
        Integer val51 = fggodrejboyce.getTiBatchRefID();
        if (val51 != null) {
            ps.setInt(51, val51);
        } else {
            ps.setNull(51, Types.INTEGER);
        }
        ps.setString(52, fggodrejboyce.getTiRemarks());
        ps.setString(53, fggodrejboyce.getTnxDisplayStatus());
        Integer val54 = fggodrejboyce.getTnxDisplayBatchID();
        if (val54 != null) {
            ps.setInt(54, val54);
        } else {
            ps.setNull(54, Types.INTEGER);
        }
        ps.setString(55, fggodrejboyce.getTnxDisplayRemarks());
        java.math.BigDecimal val56 = fggodrejboyce.getAdvanceInterest();
        if (val56 != null) {
            ps.setBigDecimal(56, val56);
        } else {
            ps.setNull(56, Types.DECIMAL);
        }
        java.math.BigDecimal val57 = fggodrejboyce.getNetPayment();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, fggodrejboyce.getValueDate());
        ps.setString(59, fggodrejboyce.getUtrNumber());
        java.math.BigDecimal val60 = fggodrejboyce.getCharges();
        if (val60 != null) {
            ps.setBigDecimal(60, val60);
        } else {
            ps.setNull(60, Types.DECIMAL);
        }
        ps.setString(61, fggodrejboyce.getFreeText1());
        ps.setString(62, fggodrejboyce.getFreeText2());
        ps.setString(63, fggodrejboyce.getFreeText3());
        ps.setString(64, fggodrejboyce.getProgramType());
        java.time.LocalDateTime val65 = fggodrejboyce.getCustomMaturityDate();
        if (val65 != null) {
            ps.setTimestamp(65, java.sql.Timestamp.valueOf(val65));
        } else {
            ps.setNull(65, Types.TIMESTAMP);
        }
        Integer val66 = fggodrejboyce.getLayoutID();
        if (val66 != null) {
            ps.setInt(66, val66);
        } else {
            ps.setNull(66, Types.INTEGER);
        }
        ps.setString(67, fggodrejboyce.getLayoutUuid());
        ps.setString(68, fggodrejboyce.getLoanRequestType());
        Integer val69 = fggodrejboyce.getPortalBatchRefID();
        if (val69 != null) {
            ps.setInt(69, val69);
        } else {
            ps.setNull(69, Types.INTEGER);
        }
        ps.setString(70, fggodrejboyce.getFinanceParty());
        ps.setString(71, fggodrejboyce.getFinanceRequestStatus());
        ps.setString(72, fggodrejboyce.getFinanceRequested());
    }

    private FgGodrejBoyce extract(ResultSet rs) throws SQLException {
        FgGodrejBoyce fggodrejboyce = new FgGodrejBoyce();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fggodrejboyce.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fggodrejboyce.setReferenceID(REFERENCE_ID);
        fggodrejboyce.setTypeCode(rs.getString(COL_TYPE_CODE));
        fggodrejboyce.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fggodrejboyce.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fggodrejboyce.setStageCode(rs.getString(COL_STAGE_CODE));
        fggodrejboyce.setStatusCode(rs.getString(COL_STATUS_CODE));
        fggodrejboyce.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fggodrejboyce.setCreatedBy(CREATED_BY);
        fggodrejboyce.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fggodrejboyce.setLastUpdatedBy(LAST_UPDATED_BY);
        fggodrejboyce.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fggodrejboyce.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fggodrejboyce.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fggodrejboyce.setIsTemplate(IS_TEMPLATE);
        Integer SELLER_ID = rs.getObject(COL_SELLER_ID, Integer.class);
        fggodrejboyce.setSellerID(SELLER_ID);
        fggodrejboyce.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        Integer BUYER_ID = rs.getObject(COL_BUYER_ID, Integer.class);
        fggodrejboyce.setBuyerID(BUYER_ID);
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fggodrejboyce.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        fggodrejboyce.setInvoiceNo(rs.getString(COL_INVOICE_NO));
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        fggodrejboyce.setInvoiceAmount(INVOICE_AMOUNT);
        fggodrejboyce.setCurrency(rs.getString(COL_CURRENCY));
        Timestamp DUE_DATE = rs.getTimestamp(COL_DUE_DATE);
        if (DUE_DATE != null)
            fggodrejboyce.setDueDate(DUE_DATE.toLocalDateTime());
        fggodrejboyce.setReferenceNo(rs.getString(COL_REFERENCE_NO));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fggodrejboyce.setUploadRefID(UPLOAD_REF_ID);
        fggodrejboyce.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fggodrejboyce.setLineNo(LINE_NO);
        fggodrejboyce.setSrNo(rs.getString(COL_SR_NO));
        fggodrejboyce.setTest1(rs.getString(COL_TEST1));
        fggodrejboyce.setTest2(rs.getString(COL_TEST2));
        fggodrejboyce.setTest3(rs.getString(COL_TEST3));
        fggodrejboyce.setTest4(rs.getString(COL_TEST4));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fggodrejboyce.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fggodrejboyce.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fggodrejboyce.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fggodrejboyce.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal EQUIVALENT_AMOUNT = rs.getObject(COL_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fggodrejboyce.setEquivalentAmount(EQUIVALENT_AMOUNT);
        fggodrejboyce.setEquivalentCurrency(rs.getString(COL_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fggodrejboyce.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fggodrejboyce.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fggodrejboyce.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fggodrejboyce.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fggodrejboyce.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fggodrejboyce.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fggodrejboyce.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        fggodrejboyce.setFileName(rs.getString(COL_FILE_NAME));
        fggodrejboyce.setBatchStatus(rs.getString(COL_BATCH_STATUS));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fggodrejboyce.setBatchRefID(BATCH_REF_ID);
        fggodrejboyce.setBatchRemarks(rs.getString(COL_BATCH_REMARKS));
        fggodrejboyce.setTiStatus(rs.getString(COL_TI_STATUS));
        Integer TI_BATCH_REF_ID = rs.getObject(COL_TI_BATCH_REF_ID, Integer.class);
        fggodrejboyce.setTiBatchRefID(TI_BATCH_REF_ID);
        fggodrejboyce.setTiRemarks(rs.getString(COL_TI_REMARKS));
        fggodrejboyce.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        Integer TNX_DISPLAY_BATCH_ID = rs.getObject(COL_TNX_DISPLAY_BATCH_ID, Integer.class);
        fggodrejboyce.setTnxDisplayBatchID(TNX_DISPLAY_BATCH_ID);
        fggodrejboyce.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        java.math.BigDecimal ADVANCE_INTEREST = rs.getObject(COL_ADVANCE_INTEREST, java.math.BigDecimal.class);
        fggodrejboyce.setAdvanceInterest(ADVANCE_INTEREST);
        java.math.BigDecimal NET_PAYMENT = rs.getObject(COL_NET_PAYMENT, java.math.BigDecimal.class);
        fggodrejboyce.setNetPayment(NET_PAYMENT);
        fggodrejboyce.setValueDate(rs.getString(COL_VALUE_DATE));
        fggodrejboyce.setUtrNumber(rs.getString(COL_UTR_NUMBER));
        java.math.BigDecimal CHARGES = rs.getObject(COL_CHARGES, java.math.BigDecimal.class);
        fggodrejboyce.setCharges(CHARGES);
        fggodrejboyce.setFreeText1(rs.getString(COL_FREE_TEXT_1));
        fggodrejboyce.setFreeText2(rs.getString(COL_FREE_TEXT_2));
        fggodrejboyce.setFreeText3(rs.getString(COL_FREE_TEXT_3));
        fggodrejboyce.setProgramType(rs.getString(COL_PROGRAM_TYPE));
        Timestamp CUSTOM_MATURITY_DATE = rs.getTimestamp(COL_CUSTOM_MATURITY_DATE);
        if (CUSTOM_MATURITY_DATE != null)
            fggodrejboyce.setCustomMaturityDate(CUSTOM_MATURITY_DATE.toLocalDateTime());
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        fggodrejboyce.setLayoutID(LAYOUT_ID);
        fggodrejboyce.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        fggodrejboyce.setLoanRequestType(rs.getString(COL_LOAN_REQUEST_TYPE));
        Integer PORTAL_BATCH_REF_ID = rs.getObject(COL_PORTAL_BATCH_REF_ID, Integer.class);
        fggodrejboyce.setPortalBatchRefID(PORTAL_BATCH_REF_ID);
        fggodrejboyce.setFinanceParty(rs.getString(COL_FINANCE_PARTY));
        fggodrejboyce.setFinanceRequestStatus(rs.getString(COL_FINANCE_REQUEST_STATUS));
        fggodrejboyce.setFinanceRequested(rs.getString(COL_FINANCE_REQUESTED));
        return fggodrejboyce;
    }
}
