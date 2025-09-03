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

public class JdbcFgChetakKonetDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgChetakKonetDao.class);

    private static final String TABLE = "FG_CHETAK_KONET";

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

    private static final String COL_CRN_NO = "CRN_NO";

    private static final String COL_OPERATIVE_ACC = "OPERATIVE_ACC";

    private static final String COL_BUY_SUPLR_NAME = "BUY_SUPLR_NAME";

    private static final String COL_COMMR_INV_NO = "COMMR_INV_NO";

    private static final String COL_COMMR_INV_CURRENCY = "COMMR_INV_CURRENCY";

    private static final String COL_COMMR_INV_AMOUNT = "COMMR_INV_AMOUNT";

    private static final String COL_MISC_FREIGHT_CHARGE = "MISC_FREIGHT_CHARGE";

    private static final String COL_GOOD_DESCR = "GOOD_DESCR";

    private static final String COL_PAYMENT_TERM = "PAYMENT_TERM";

    private static final String COL_COUNTRY_OF_ORIGIN = "COUNTRY_OF_ORIGIN";

    private static final String COL_BOE_NO = "BOE_NO";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_PORT_OF_DISCHARGE = "PORT_OF_DISCHARGE";

    private static final String COL_PORT_OF_LOADING = "PORT_OF_LOADING";

    private static final String COL_BL_NUM = "BL_NUM";

    private static final String COL_FLIGHT_NAME = "FLIGHT_NAME";

    private static final String COL_CUST_REF_NO = "CUST_REF_NO";

    private static final String COL_PAYMENT_DETAILS = "PAYMENT_DETAILS";

    private static final String COL_FX_CONTRACT_REF_NO = "FX_CONTRACT_REF_NO";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_DUE_OR_VALUE_DATE = "DUE_OR_VALUE_DATE";

    private static final String COL_BL_DATE = "BL_DATE";

    private static final String COL_SHIPMENT_DATE = "SHIPMENT_DATE";

    private static final String COL_COMMR_INV_DATE = "COMMR_INV_DATE";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_HAWB_DATE = "HAWB_DATE";

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
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CRN_NO, COL_OPERATIVE_ACC, COL_BUY_SUPLR_NAME, COL_COMMR_INV_NO, COL_COMMR_INV_CURRENCY, COL_COMMR_INV_AMOUNT, COL_MISC_FREIGHT_CHARGE, COL_GOOD_DESCR, COL_PAYMENT_TERM, COL_COUNTRY_OF_ORIGIN, COL_BOE_NO, COL_AD_CODE, COL_PORT_OF_DISCHARGE, COL_PORT_OF_LOADING, COL_BL_NUM, COL_FLIGHT_NAME, COL_CUST_REF_NO, COL_PAYMENT_DETAILS, COL_FX_CONTRACT_REF_NO, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_DUE_OR_VALUE_DATE, COL_BL_DATE, COL_SHIPMENT_DATE, COL_COMMR_INV_DATE, COL_BOE_DATE, COL_HAWB_DATE, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CRN_NO, OPERATIVE_ACC, BUY_SUPLR_NAME, COMMR_INV_NO, COMMR_INV_CURRENCY, COMMR_INV_AMOUNT, MISC_FREIGHT_CHARGE, GOOD_DESCR, PAYMENT_TERM, COUNTRY_OF_ORIGIN, BOE_NO, AD_CODE, PORT_OF_DISCHARGE, PORT_OF_LOADING, BL_NUM, FLIGHT_NAME, CUST_REF_NO, PAYMENT_DETAILS, FX_CONTRACT_REF_NO, UPLOAD_REF_ID, LINE_NO, DUE_OR_VALUE_DATE, BL_DATE, SHIPMENT_DATE, COMMR_INV_DATE, BOE_DATE, HAWB_DATE, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CRN_NO, OPERATIVE_ACC, BUY_SUPLR_NAME, COMMR_INV_NO, COMMR_INV_CURRENCY, COMMR_INV_AMOUNT, MISC_FREIGHT_CHARGE, GOOD_DESCR, PAYMENT_TERM, COUNTRY_OF_ORIGIN, BOE_NO, AD_CODE, PORT_OF_DISCHARGE, PORT_OF_LOADING, BL_NUM, FLIGHT_NAME, CUST_REF_NO, PAYMENT_DETAILS, FX_CONTRACT_REF_NO, UPLOAD_REF_ID, LINE_NO, DUE_OR_VALUE_DATE, BL_DATE, SHIPMENT_DATE, COMMR_INV_DATE, BOE_DATE, HAWB_DATE, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CRN_NO, COL_OPERATIVE_ACC, COL_BUY_SUPLR_NAME, COL_COMMR_INV_NO, COL_COMMR_INV_CURRENCY, COL_COMMR_INV_AMOUNT, COL_MISC_FREIGHT_CHARGE, COL_GOOD_DESCR, COL_PAYMENT_TERM, COL_COUNTRY_OF_ORIGIN, COL_BOE_NO, COL_AD_CODE, COL_PORT_OF_DISCHARGE, COL_PORT_OF_LOADING, COL_BL_NUM, COL_FLIGHT_NAME, COL_CUST_REF_NO, COL_PAYMENT_DETAILS, COL_FX_CONTRACT_REF_NO, COL_UPLOAD_REF_ID, COL_LINE_NO, COL_DUE_OR_VALUE_DATE, COL_BL_DATE, COL_SHIPMENT_DATE, COL_COMMR_INV_DATE, COL_BOE_DATE, COL_HAWB_DATE, COL_AUTH_EQUIVALENT_AMOUNT, COL_AUTH_EQUIVALENT_CURRENCY, COL_DISPLAY_EQUIVALENT_AMOUNT, COL_DISPLAY_EQUIVALENT_CURRENCY, COL_AUTH_FX_BASE_RATE, COL_DISPLAY_FX_BASE_RATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_FILE_NAME, COL_ID);

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

    public int insert(Connection conn, FgChetakKonet fgchetakkonet) throws SQLException {
        logger.debug("Inserting fgchetakkonet: {}", fgchetakkonet);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgChetakKonetParams(ps, fgchetakkonet);
            ps.executeUpdate();
            return fgchetakkonet.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgChetakKonet> fgchetakkonets) throws SQLException {
        if (fgchetakkonets == null || fgchetakkonets.isEmpty())
            return new int[0];
        for (int i = 0; i < fgchetakkonets.size(); i++) {
            if (fgchetakkonets.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChetakKonet>> batches = chunkList(fgchetakkonets, batchSize);
        int[] totalResults = new int[fgchetakkonets.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChetakKonet> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgChetakKonet fgchetakkonet : batch) {
                        setFgChetakKonetParams(ps, fgchetakkonet);
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

    public FgChetakKonet findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgChetakKonet> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgChetakKonet> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgChetakKonet fgchetakkonet) throws SQLException {
        if (fgchetakkonet.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgChetakKonetParams(ps, fgchetakkonet);
            ps.setInt(51, fgchetakkonet.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgChetakKonet> fgchetakkonets) throws SQLException {
        if (fgchetakkonets == null || fgchetakkonets.isEmpty())
            return new int[0];
        for (FgChetakKonet fgchetakkonet : fgchetakkonets) {
            if (fgchetakkonet == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgchetakkonet.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChetakKonet>> batches = chunkList(fgchetakkonets, batchSize);
        int[] totalResults = new int[fgchetakkonets.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChetakKonet> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgChetakKonet fgchetakkonet : batch) {
                        setFgChetakKonetParams(ps, fgchetakkonet);
                        ps.setInt(51, fgchetakkonet.getID());
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

    private void setFgChetakKonetParams(PreparedStatement ps, FgChetakKonet fgchetakkonet) throws SQLException {
        Integer val1 = fgchetakkonet.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgchetakkonet.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgchetakkonet.getTypeCode());
        ps.setString(4, fgchetakkonet.getSubTypeCode());
        ps.setString(5, fgchetakkonet.getActiveCode());
        ps.setString(6, fgchetakkonet.getStageCode());
        ps.setString(7, fgchetakkonet.getStatusCode());
        ps.setString(8, fgchetakkonet.getCreatedOn());
        java.math.BigDecimal val9 = fgchetakkonet.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgchetakkonet.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgchetakkonet.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgchetakkonet.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgchetakkonet.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgchetakkonet.getTemplate());
        java.math.BigDecimal val15 = fgchetakkonet.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgchetakkonet.getCrnNo());
        ps.setString(17, fgchetakkonet.getOperativeAcc());
        ps.setString(18, fgchetakkonet.getBuySuplrName());
        ps.setString(19, fgchetakkonet.getCommrInvNo());
        ps.setString(20, fgchetakkonet.getCommrInvCurrency());
        java.math.BigDecimal val21 = fgchetakkonet.getCommrInvAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgchetakkonet.getMiscFreightCharge();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgchetakkonet.getGoodDescr());
        ps.setString(24, fgchetakkonet.getPaymentTerm());
        ps.setString(25, fgchetakkonet.getCountryOfOrigin());
        ps.setString(26, fgchetakkonet.getBoeNo());
        ps.setString(27, fgchetakkonet.getAdCode());
        ps.setString(28, fgchetakkonet.getPortOfDischarge());
        ps.setString(29, fgchetakkonet.getPortOfLoading());
        ps.setString(30, fgchetakkonet.getBlNum());
        ps.setString(31, fgchetakkonet.getFlightName());
        ps.setString(32, fgchetakkonet.getCustRefNo());
        ps.setString(33, fgchetakkonet.getPaymentDetails());
        ps.setString(34, fgchetakkonet.getFxContractRefNo());
        Integer val35 = fgchetakkonet.getUploadRefID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
        java.math.BigDecimal val36 = fgchetakkonet.getLineNo();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, fgchetakkonet.getDueOrValueDate());
        ps.setString(38, fgchetakkonet.getBlDate());
        ps.setString(39, fgchetakkonet.getShipmentDate());
        ps.setString(40, fgchetakkonet.getCommrInvDate());
        ps.setString(41, fgchetakkonet.getBoeDate());
        ps.setString(42, fgchetakkonet.getHawbDate());
        java.math.BigDecimal val43 = fgchetakkonet.getAuthEquivalentAmount();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, fgchetakkonet.getAuthEquivalentCurrency());
        java.math.BigDecimal val45 = fgchetakkonet.getDisplayEquivalentAmount();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        ps.setString(46, fgchetakkonet.getDisplayEquivalentCurrency());
        java.math.BigDecimal val47 = fgchetakkonet.getAuthFxBaseRate();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = fgchetakkonet.getDisplayFxBaseRate();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        ps.setString(49, fgchetakkonet.getApplicantPartyCode());
        ps.setString(50, fgchetakkonet.getIssuingPartyCode());
        ps.setString(51, fgchetakkonet.getFileName());
    }

    private FgChetakKonet extract(ResultSet rs) throws SQLException {
        FgChetakKonet fgchetakkonet = new FgChetakKonet();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgchetakkonet.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgchetakkonet.setReferenceID(REFERENCE_ID);
        fgchetakkonet.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgchetakkonet.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgchetakkonet.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgchetakkonet.setStageCode(rs.getString(COL_STAGE_CODE));
        fgchetakkonet.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgchetakkonet.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgchetakkonet.setCreatedBy(CREATED_BY);
        fgchetakkonet.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgchetakkonet.setLastUpdatedBy(LAST_UPDATED_BY);
        fgchetakkonet.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgchetakkonet.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgchetakkonet.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgchetakkonet.setIsTemplate(IS_TEMPLATE);
        fgchetakkonet.setCrnNo(rs.getString(COL_CRN_NO));
        fgchetakkonet.setOperativeAcc(rs.getString(COL_OPERATIVE_ACC));
        fgchetakkonet.setBuySuplrName(rs.getString(COL_BUY_SUPLR_NAME));
        fgchetakkonet.setCommrInvNo(rs.getString(COL_COMMR_INV_NO));
        fgchetakkonet.setCommrInvCurrency(rs.getString(COL_COMMR_INV_CURRENCY));
        java.math.BigDecimal COMMR_INV_AMOUNT = rs.getObject(COL_COMMR_INV_AMOUNT, java.math.BigDecimal.class);
        fgchetakkonet.setCommrInvAmount(COMMR_INV_AMOUNT);
        java.math.BigDecimal MISC_FREIGHT_CHARGE = rs.getObject(COL_MISC_FREIGHT_CHARGE, java.math.BigDecimal.class);
        fgchetakkonet.setMiscFreightCharge(MISC_FREIGHT_CHARGE);
        fgchetakkonet.setGoodDescr(rs.getString(COL_GOOD_DESCR));
        fgchetakkonet.setPaymentTerm(rs.getString(COL_PAYMENT_TERM));
        fgchetakkonet.setCountryOfOrigin(rs.getString(COL_COUNTRY_OF_ORIGIN));
        fgchetakkonet.setBoeNo(rs.getString(COL_BOE_NO));
        fgchetakkonet.setAdCode(rs.getString(COL_AD_CODE));
        fgchetakkonet.setPortOfDischarge(rs.getString(COL_PORT_OF_DISCHARGE));
        fgchetakkonet.setPortOfLoading(rs.getString(COL_PORT_OF_LOADING));
        fgchetakkonet.setBlNum(rs.getString(COL_BL_NUM));
        fgchetakkonet.setFlightName(rs.getString(COL_FLIGHT_NAME));
        fgchetakkonet.setCustRefNo(rs.getString(COL_CUST_REF_NO));
        fgchetakkonet.setPaymentDetails(rs.getString(COL_PAYMENT_DETAILS));
        fgchetakkonet.setFxContractRefNo(rs.getString(COL_FX_CONTRACT_REF_NO));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgchetakkonet.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgchetakkonet.setLineNo(LINE_NO);
        fgchetakkonet.setDueOrValueDate(rs.getString(COL_DUE_OR_VALUE_DATE));
        fgchetakkonet.setBlDate(rs.getString(COL_BL_DATE));
        fgchetakkonet.setShipmentDate(rs.getString(COL_SHIPMENT_DATE));
        fgchetakkonet.setCommrInvDate(rs.getString(COL_COMMR_INV_DATE));
        fgchetakkonet.setBoeDate(rs.getString(COL_BOE_DATE));
        fgchetakkonet.setHawbDate(rs.getString(COL_HAWB_DATE));
        java.math.BigDecimal AUTH_EQUIVALENT_AMOUNT = rs.getObject(COL_AUTH_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakkonet.setAuthEquivalentAmount(AUTH_EQUIVALENT_AMOUNT);
        fgchetakkonet.setAuthEquivalentCurrency(rs.getString(COL_AUTH_EQUIVALENT_CURRENCY));
        java.math.BigDecimal DISPLAY_EQUIVALENT_AMOUNT = rs.getObject(COL_DISPLAY_EQUIVALENT_AMOUNT, java.math.BigDecimal.class);
        fgchetakkonet.setDisplayEquivalentAmount(DISPLAY_EQUIVALENT_AMOUNT);
        fgchetakkonet.setDisplayEquivalentCurrency(rs.getString(COL_DISPLAY_EQUIVALENT_CURRENCY));
        java.math.BigDecimal AUTH_FX_BASE_RATE = rs.getObject(COL_AUTH_FX_BASE_RATE, java.math.BigDecimal.class);
        fgchetakkonet.setAuthFxBaseRate(AUTH_FX_BASE_RATE);
        java.math.BigDecimal DISPLAY_FX_BASE_RATE = rs.getObject(COL_DISPLAY_FX_BASE_RATE, java.math.BigDecimal.class);
        fgchetakkonet.setDisplayFxBaseRate(DISPLAY_FX_BASE_RATE);
        fgchetakkonet.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgchetakkonet.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgchetakkonet.setFileName(rs.getString(COL_FILE_NAME));
        return fgchetakkonet;
    }
}
