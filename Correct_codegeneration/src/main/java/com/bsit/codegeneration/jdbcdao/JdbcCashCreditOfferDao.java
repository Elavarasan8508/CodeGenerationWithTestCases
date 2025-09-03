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

public class JdbcCashCreditOfferDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCashCreditOfferDao.class);

    private static final String TABLE = "CASH_CREDIT_OFFER";

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

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String COL_PARENT_ID = "PARENT_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_OFFER_ID = "OFFER_ID";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_OFFER_TYPE_CODE = "OFFER_TYPE_CODE";

    private static final String COL_OFFER_START_DATE = "OFFER_START_DATE";

    private static final String COL_OFFER_END_DATE = "OFFER_END_DATE";

    private static final String COL_INTEREST_TYPE_CODE = "INTEREST_TYPE_CODE";

    private static final String COL_RATE_OF_INTEREST = "RATE_OF_INTEREST";

    private static final String COL_BENCHMARK_CODE = "BENCHMARK_CODE";

    private static final String COL_RESET_FREQUENCY_PERIOD_CODE = "RESET_FREQUENCY_PERIOD_CODE";

    private static final String COL_TENOR_UOM = "TENOR_UOM";

    private static final String COL_TENOR_MIN = "TENOR_MIN";

    private static final String COL_TENOR_MAX = "TENOR_MAX";

    private static final String COL_PROCESSING_MODE_CODE = "PROCESSING_MODE_CODE";

    private static final String COL_OFFER_SPREAD_PERCENTAGE = "OFFER_SPREAD_PERCENTAGE";

    private static final String COL_FTP_CODE = "FTP_CODE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_OFFER_ID, COL_NAME, COL_DESCRIPTION, COL_OFFER_TYPE_CODE, COL_OFFER_START_DATE, COL_OFFER_END_DATE, COL_INTEREST_TYPE_CODE, COL_RATE_OF_INTEREST, COL_BENCHMARK_CODE, COL_RESET_FREQUENCY_PERIOD_CODE, COL_TENOR_UOM, COL_TENOR_MIN, COL_TENOR_MAX, COL_PROCESSING_MODE_CODE, COL_OFFER_SPREAD_PERCENTAGE, COL_FTP_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, NAME, DESCRIPTION, OFFER_TYPE_CODE, OFFER_START_DATE, OFFER_END_DATE, INTEREST_TYPE_CODE, RATE_OF_INTEREST, BENCHMARK_CODE, RESET_FREQUENCY_PERIOD_CODE, TENOR_UOM, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, OFFER_SPREAD_PERCENTAGE, FTP_CODE, VERSION_ID, IS_MASTER_VERSION, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, NAME, DESCRIPTION, OFFER_TYPE_CODE, OFFER_START_DATE, OFFER_END_DATE, INTEREST_TYPE_CODE, RATE_OF_INTEREST, BENCHMARK_CODE, RESET_FREQUENCY_PERIOD_CODE, TENOR_UOM, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, OFFER_SPREAD_PERCENTAGE, FTP_CODE, VERSION_ID, IS_MASTER_VERSION, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_OFFER_ID, COL_NAME, COL_DESCRIPTION, COL_OFFER_TYPE_CODE, COL_OFFER_START_DATE, COL_OFFER_END_DATE, COL_INTEREST_TYPE_CODE, COL_RATE_OF_INTEREST, COL_BENCHMARK_CODE, COL_RESET_FREQUENCY_PERIOD_CODE, COL_TENOR_UOM, COL_TENOR_MIN, COL_TENOR_MAX, COL_PROCESSING_MODE_CODE, COL_OFFER_SPREAD_PERCENTAGE, COL_FTP_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_ID);

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

    public int insert(Connection conn, CashCreditOffer cashcreditoffer) throws SQLException {
        logger.debug("Inserting cashcreditoffer: {}", cashcreditoffer);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCashCreditOfferParams(ps, cashcreditoffer);
            ps.executeUpdate();
            return cashcreditoffer.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CashCreditOffer> cashcreditoffers) throws SQLException {
        if (cashcreditoffers == null || cashcreditoffers.isEmpty())
            return new int[0];
        for (int i = 0; i < cashcreditoffers.size(); i++) {
            if (cashcreditoffers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CashCreditOffer>> batches = chunkList(cashcreditoffers, batchSize);
        int[] totalResults = new int[cashcreditoffers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CashCreditOffer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CashCreditOffer cashcreditoffer : batch) {
                        setCashCreditOfferParams(ps, cashcreditoffer);
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

    public CashCreditOffer findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CashCreditOffer> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CashCreditOffer> list = new ArrayList<>();
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

    public boolean update(Connection conn, CashCreditOffer cashcreditoffer) throws SQLException {
        if (cashcreditoffer.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCashCreditOfferParams(ps, cashcreditoffer);
            ps.setInt(44, cashcreditoffer.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CashCreditOffer> cashcreditoffers) throws SQLException {
        if (cashcreditoffers == null || cashcreditoffers.isEmpty())
            return new int[0];
        for (CashCreditOffer cashcreditoffer : cashcreditoffers) {
            if (cashcreditoffer == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (cashcreditoffer.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CashCreditOffer>> batches = chunkList(cashcreditoffers, batchSize);
        int[] totalResults = new int[cashcreditoffers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CashCreditOffer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CashCreditOffer cashcreditoffer : batch) {
                        setCashCreditOfferParams(ps, cashcreditoffer);
                        ps.setInt(44, cashcreditoffer.getID());
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

    private void setCashCreditOfferParams(PreparedStatement ps, CashCreditOffer cashcreditoffer) throws SQLException {
        Integer val1 = cashcreditoffer.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = cashcreditoffer.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, cashcreditoffer.getTypeCode());
        ps.setString(4, cashcreditoffer.getSubTypeCode());
        ps.setString(5, cashcreditoffer.getActiveCode());
        ps.setString(6, cashcreditoffer.getStageCode());
        ps.setString(7, cashcreditoffer.getStatusCode());
        Integer val8 = cashcreditoffer.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, cashcreditoffer.getCreatedOn());
        java.math.BigDecimal val10 = cashcreditoffer.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, cashcreditoffer.getLastUpdatedOn());
        java.math.BigDecimal val12 = cashcreditoffer.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, cashcreditoffer.getLastAuthorisedOn());
        java.math.BigDecimal val14 = cashcreditoffer.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, cashcreditoffer.getTemplate());
        ps.setString(16, cashcreditoffer.getApplicantParty());
        ps.setString(17, cashcreditoffer.getFulfillmentParty());
        Integer val18 = cashcreditoffer.getUploadRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = cashcreditoffer.getAttachmentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = cashcreditoffer.getParentID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = cashcreditoffer.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = cashcreditoffer.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = cashcreditoffer.getIsTemplate();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        Integer val24 = cashcreditoffer.getOfferID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        ps.setString(25, cashcreditoffer.getName());
        ps.setString(26, cashcreditoffer.getDescription());
        ps.setString(27, cashcreditoffer.getOfferTypeCode());
        java.time.LocalDateTime val28 = cashcreditoffer.getOfferStartDate();
        if (val28 != null) {
            ps.setTimestamp(28, java.sql.Timestamp.valueOf(val28));
        } else {
            ps.setNull(28, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val29 = cashcreditoffer.getOfferEndDate();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        ps.setString(30, cashcreditoffer.getInterestTypeCode());
        java.math.BigDecimal val31 = cashcreditoffer.getRateOfInterest();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, cashcreditoffer.getBenchmarkCode());
        ps.setString(33, cashcreditoffer.getResetFrequencyPeriodCode());
        ps.setString(34, cashcreditoffer.getTenorUom());
        java.math.BigDecimal val35 = cashcreditoffer.getTenorMin();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.math.BigDecimal val36 = cashcreditoffer.getTenorMax();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, cashcreditoffer.getProcessingModeCode());
        java.math.BigDecimal val38 = cashcreditoffer.getOfferSpreadPercentage();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = cashcreditoffer.getFtpCode();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        Integer val40 = cashcreditoffer.getVersionID();
        if (val40 != null) {
            ps.setInt(40, val40);
        } else {
            ps.setNull(40, Types.INTEGER);
        }
        java.math.BigDecimal val41 = cashcreditoffer.getIsMasterVersion();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, cashcreditoffer.getProductCode());
        ps.setString(43, cashcreditoffer.getSubProductCode());
        ps.setString(44, cashcreditoffer.getSegmentCode());
    }

    private CashCreditOffer extract(ResultSet rs) throws SQLException {
        CashCreditOffer cashcreditoffer = new CashCreditOffer();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        cashcreditoffer.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        cashcreditoffer.setReferenceID(REFERENCE_ID);
        cashcreditoffer.setTypeCode(rs.getString(COL_TYPE_CODE));
        cashcreditoffer.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        cashcreditoffer.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        cashcreditoffer.setStageCode(rs.getString(COL_STAGE_CODE));
        cashcreditoffer.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        cashcreditoffer.setProcessID(PROCESS_ID);
        cashcreditoffer.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        cashcreditoffer.setCreatedBy(CREATED_BY);
        cashcreditoffer.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        cashcreditoffer.setLastUpdatedBy(LAST_UPDATED_BY);
        cashcreditoffer.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        cashcreditoffer.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        cashcreditoffer.setTemplate(rs.getString(COL_TEMPLATE));
        cashcreditoffer.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        cashcreditoffer.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        cashcreditoffer.setUploadRefID(UPLOAD_REF_ID);
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        cashcreditoffer.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        cashcreditoffer.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        cashcreditoffer.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        cashcreditoffer.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        cashcreditoffer.setIsTemplate(IS_TEMPLATE);
        Integer OFFER_ID = rs.getObject(COL_OFFER_ID, Integer.class);
        cashcreditoffer.setOfferID(OFFER_ID);
        cashcreditoffer.setName(rs.getString(COL_NAME));
        cashcreditoffer.setDescription(rs.getString(COL_DESCRIPTION));
        cashcreditoffer.setOfferTypeCode(rs.getString(COL_OFFER_TYPE_CODE));
        Timestamp OFFER_START_DATE = rs.getTimestamp(COL_OFFER_START_DATE);
        if (OFFER_START_DATE != null)
            cashcreditoffer.setOfferStartDate(OFFER_START_DATE.toLocalDateTime());
        Timestamp OFFER_END_DATE = rs.getTimestamp(COL_OFFER_END_DATE);
        if (OFFER_END_DATE != null)
            cashcreditoffer.setOfferEndDate(OFFER_END_DATE.toLocalDateTime());
        cashcreditoffer.setInterestTypeCode(rs.getString(COL_INTEREST_TYPE_CODE));
        java.math.BigDecimal RATE_OF_INTEREST = rs.getObject(COL_RATE_OF_INTEREST, java.math.BigDecimal.class);
        cashcreditoffer.setRateOfInterest(RATE_OF_INTEREST);
        cashcreditoffer.setBenchmarkCode(rs.getString(COL_BENCHMARK_CODE));
        cashcreditoffer.setResetFrequencyPeriodCode(rs.getString(COL_RESET_FREQUENCY_PERIOD_CODE));
        cashcreditoffer.setTenorUom(rs.getString(COL_TENOR_UOM));
        java.math.BigDecimal TENOR_MIN = rs.getObject(COL_TENOR_MIN, java.math.BigDecimal.class);
        cashcreditoffer.setTenorMin(TENOR_MIN);
        java.math.BigDecimal TENOR_MAX = rs.getObject(COL_TENOR_MAX, java.math.BigDecimal.class);
        cashcreditoffer.setTenorMax(TENOR_MAX);
        cashcreditoffer.setProcessingModeCode(rs.getString(COL_PROCESSING_MODE_CODE));
        java.math.BigDecimal OFFER_SPREAD_PERCENTAGE = rs.getObject(COL_OFFER_SPREAD_PERCENTAGE, java.math.BigDecimal.class);
        cashcreditoffer.setOfferSpreadPercentage(OFFER_SPREAD_PERCENTAGE);
        java.math.BigDecimal FTP_CODE = rs.getObject(COL_FTP_CODE, java.math.BigDecimal.class);
        cashcreditoffer.setFtpCode(FTP_CODE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        cashcreditoffer.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        cashcreditoffer.setIsMasterVersion(IS_MASTER_VERSION);
        cashcreditoffer.setProductCode(rs.getString(COL_PRODUCT_CODE));
        cashcreditoffer.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        cashcreditoffer.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        return cashcreditoffer;
    }
}
