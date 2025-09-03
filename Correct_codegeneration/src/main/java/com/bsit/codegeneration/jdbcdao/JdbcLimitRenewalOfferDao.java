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

public class JdbcLimitRenewalOfferDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLimitRenewalOfferDao.class);

    private static final String TABLE = "LIMIT_RENEWAL_OFFER";

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

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_LOB = "LOB";

    private static final String COL_CRN_BOR = "CRN_BOR";

    private static final String COL_PROSPECT_ID = "PROSPECT_ID";

    private static final String COL_VALID_TO = "VALID_TO";

    private static final String COL_PROC_FEE = "PROC_FEE";

    private static final String COL_PROC_FEE_GST = "PROC_FEE_GST";

    private static final String COL_ALREADY_COLLECTED = "ALREADY_COLLECTED";

    private static final String COL_ALREADY_COLLECTED_GST = "ALREADY_COLLECTED_GST";

    private static final String COL_BAL_COLLECTED = "BAL_COLLECTED";

    private static final String COL_BAL_COLLECTED_GST = "BAL_COLLECTED_GST";

    private static final String COL_ADMIN_CHRGS = "ADMIN_CHRGS";

    private static final String COL_ADMIN_CHRGS_GST = "ADMIN_CHRGS_GST";

    private static final String COL_TECHNICAL_FEES = "TECHNICAL_FEES";

    private static final String COL_TECHNICAL_FEES_GST = "TECHNICAL_FEES_GST";

    private static final String COL_NEXT_REVIEW_DATE = "NEXT_REVIEW_DATE";

    private static final String COL_LAST_REVIEW_DATE = "LAST_REVIEW_DATE";

    private static final String COL_VAR_LIMIT_APPLICABLE = "VAR_LIMIT_APPLICABLE";

    private static final String COL_GML_LIMIT_APPLICABLE = "GML_LIMIT_APPLICABLE";

    private static final String COL_CGTMSE = "CGTMSE";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_TERM_LOAN = "TERM_LOAN";

    private static final String COL_SIDBI = "SIDBI";

    private static final String COL_CCOD = "CCOD";

    private static final String COL_SEASONAL_AD_HOC = "SEASONAL_AD_HOC";

    private static final String COL_CRN_NAME = "CRN_NAME";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_ADMIN_CHARGES = "ADMIN_CHARGES";

    private static final String COL_ADMIN_CHARGES_GST = "ADMIN_CHARGES_GST";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LOB, COL_CRN_BOR, COL_PROSPECT_ID, COL_VALID_TO, COL_PROC_FEE, COL_PROC_FEE_GST, COL_ALREADY_COLLECTED, COL_ALREADY_COLLECTED_GST, COL_BAL_COLLECTED, COL_BAL_COLLECTED_GST, COL_ADMIN_CHRGS, COL_ADMIN_CHRGS_GST, COL_TECHNICAL_FEES, COL_TECHNICAL_FEES_GST, COL_NEXT_REVIEW_DATE, COL_LAST_REVIEW_DATE, COL_VAR_LIMIT_APPLICABLE, COL_GML_LIMIT_APPLICABLE, COL_CGTMSE, COL_REMARKS, COL_TERM_LOAN, COL_SIDBI, COL_CCOD, COL_SEASONAL_AD_HOC, COL_CRN_NAME, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ADMIN_CHARGES, COL_ADMIN_CHARGES_GST);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LOB, CRN_BOR, PROSPECT_ID, VALID_TO, PROC_FEE, PROC_FEE_GST, ALREADY_COLLECTED, ALREADY_COLLECTED_GST, BAL_COLLECTED, BAL_COLLECTED_GST, ADMIN_CHRGS, ADMIN_CHRGS_GST, TECHNICAL_FEES, TECHNICAL_FEES_GST, NEXT_REVIEW_DATE, LAST_REVIEW_DATE, VAR_LIMIT_APPLICABLE, GML_LIMIT_APPLICABLE, CGTMSE, REMARKS, TERM_LOAN, SIDBI, CCOD, SEASONAL_AD_HOC, CRN_NAME, VERSION_ID, IS_MASTER_VERSION, ADMIN_CHARGES, ADMIN_CHARGES_GST", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LOB, CRN_BOR, PROSPECT_ID, VALID_TO, PROC_FEE, PROC_FEE_GST, ALREADY_COLLECTED, ALREADY_COLLECTED_GST, BAL_COLLECTED, BAL_COLLECTED_GST, ADMIN_CHRGS, ADMIN_CHRGS_GST, TECHNICAL_FEES, TECHNICAL_FEES_GST, NEXT_REVIEW_DATE, LAST_REVIEW_DATE, VAR_LIMIT_APPLICABLE, GML_LIMIT_APPLICABLE, CGTMSE, REMARKS, TERM_LOAN, SIDBI, CCOD, SEASONAL_AD_HOC, CRN_NAME, VERSION_ID, IS_MASTER_VERSION, ADMIN_CHARGES, ADMIN_CHARGES_GST", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LOB, COL_CRN_BOR, COL_PROSPECT_ID, COL_VALID_TO, COL_PROC_FEE, COL_PROC_FEE_GST, COL_ALREADY_COLLECTED, COL_ALREADY_COLLECTED_GST, COL_BAL_COLLECTED, COL_BAL_COLLECTED_GST, COL_ADMIN_CHRGS, COL_ADMIN_CHRGS_GST, COL_TECHNICAL_FEES, COL_TECHNICAL_FEES_GST, COL_NEXT_REVIEW_DATE, COL_LAST_REVIEW_DATE, COL_VAR_LIMIT_APPLICABLE, COL_GML_LIMIT_APPLICABLE, COL_CGTMSE, COL_REMARKS, COL_TERM_LOAN, COL_SIDBI, COL_CCOD, COL_SEASONAL_AD_HOC, COL_CRN_NAME, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ADMIN_CHARGES, COL_ADMIN_CHARGES_GST, COL_ID);

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

    public int insert(Connection conn, LimitRenewalOffer limitrenewaloffer) throws SQLException {
        logger.debug("Inserting limitrenewaloffer: {}", limitrenewaloffer);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLimitRenewalOfferParams(ps, limitrenewaloffer);
            ps.executeUpdate();
            return limitrenewaloffer.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LimitRenewalOffer> limitrenewaloffers) throws SQLException {
        if (limitrenewaloffers == null || limitrenewaloffers.isEmpty())
            return new int[0];
        for (int i = 0; i < limitrenewaloffers.size(); i++) {
            if (limitrenewaloffers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LimitRenewalOffer>> batches = chunkList(limitrenewaloffers, batchSize);
        int[] totalResults = new int[limitrenewaloffers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LimitRenewalOffer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LimitRenewalOffer limitrenewaloffer : batch) {
                        setLimitRenewalOfferParams(ps, limitrenewaloffer);
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

    public LimitRenewalOffer findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LimitRenewalOffer> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LimitRenewalOffer> list = new ArrayList<>();
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

    public boolean update(Connection conn, LimitRenewalOffer limitrenewaloffer) throws SQLException {
        if (limitrenewaloffer.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLimitRenewalOfferParams(ps, limitrenewaloffer);
            ps.setInt(47, limitrenewaloffer.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LimitRenewalOffer> limitrenewaloffers) throws SQLException {
        if (limitrenewaloffers == null || limitrenewaloffers.isEmpty())
            return new int[0];
        for (LimitRenewalOffer limitrenewaloffer : limitrenewaloffers) {
            if (limitrenewaloffer == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (limitrenewaloffer.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LimitRenewalOffer>> batches = chunkList(limitrenewaloffers, batchSize);
        int[] totalResults = new int[limitrenewaloffers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LimitRenewalOffer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LimitRenewalOffer limitrenewaloffer : batch) {
                        setLimitRenewalOfferParams(ps, limitrenewaloffer);
                        ps.setInt(47, limitrenewaloffer.getID());
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

    private void setLimitRenewalOfferParams(PreparedStatement ps, LimitRenewalOffer limitrenewaloffer) throws SQLException {
        Integer val1 = limitrenewaloffer.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = limitrenewaloffer.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, limitrenewaloffer.getTypeCode());
        ps.setString(4, limitrenewaloffer.getSubTypeCode());
        ps.setString(5, limitrenewaloffer.getActiveCode());
        ps.setString(6, limitrenewaloffer.getStageCode());
        ps.setString(7, limitrenewaloffer.getStatusCode());
        Integer val8 = limitrenewaloffer.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, limitrenewaloffer.getCreatedOn());
        java.math.BigDecimal val10 = limitrenewaloffer.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, limitrenewaloffer.getLastUpdatedOn());
        java.math.BigDecimal val12 = limitrenewaloffer.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, limitrenewaloffer.getLastAuthorisedOn());
        java.math.BigDecimal val14 = limitrenewaloffer.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, limitrenewaloffer.getTemplate());
        ps.setString(16, limitrenewaloffer.getApplicantParty());
        ps.setString(17, limitrenewaloffer.getFulfillmentParty());
        java.math.BigDecimal val18 = limitrenewaloffer.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = limitrenewaloffer.getLob();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = limitrenewaloffer.getCrnBor();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        Integer val21 = limitrenewaloffer.getProspectID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.time.LocalDateTime val22 = limitrenewaloffer.getValidTo();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = limitrenewaloffer.getProcFee();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = limitrenewaloffer.getProcFeeGst();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = limitrenewaloffer.getAlreadyCollected();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = limitrenewaloffer.getAlreadyCollectedGst();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = limitrenewaloffer.getBalCollected();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = limitrenewaloffer.getBalCollectedGst();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = limitrenewaloffer.getAdminChrgs();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = limitrenewaloffer.getAdminChrgsGst();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = limitrenewaloffer.getTechnicalFees();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = limitrenewaloffer.getTechnicalFeesGst();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.time.LocalDateTime val33 = limitrenewaloffer.getNextReviewDate();
        if (val33 != null) {
            ps.setTimestamp(33, java.sql.Timestamp.valueOf(val33));
        } else {
            ps.setNull(33, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val34 = limitrenewaloffer.getLastReviewDate();
        if (val34 != null) {
            ps.setTimestamp(34, java.sql.Timestamp.valueOf(val34));
        } else {
            ps.setNull(34, Types.TIMESTAMP);
        }
        ps.setString(35, limitrenewaloffer.getVarLimitApplicable());
        ps.setString(36, limitrenewaloffer.getGmlLimitApplicable());
        ps.setString(37, limitrenewaloffer.getCgtmse());
        ps.setString(38, limitrenewaloffer.getRemarks());
        ps.setString(39, limitrenewaloffer.getTermLoan());
        ps.setString(40, limitrenewaloffer.getSidbi());
        ps.setString(41, limitrenewaloffer.getCcod());
        ps.setString(42, limitrenewaloffer.getSeasonalAdHoc());
        ps.setString(43, limitrenewaloffer.getCrnName());
        Integer val44 = limitrenewaloffer.getVersionID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        java.math.BigDecimal val45 = limitrenewaloffer.getIsMasterVersion();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = limitrenewaloffer.getAdminCharges();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = limitrenewaloffer.getAdminChargesGst();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
    }

    private LimitRenewalOffer extract(ResultSet rs) throws SQLException {
        LimitRenewalOffer limitrenewaloffer = new LimitRenewalOffer();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        limitrenewaloffer.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        limitrenewaloffer.setReferenceID(REFERENCE_ID);
        limitrenewaloffer.setTypeCode(rs.getString(COL_TYPE_CODE));
        limitrenewaloffer.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        limitrenewaloffer.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        limitrenewaloffer.setStageCode(rs.getString(COL_STAGE_CODE));
        limitrenewaloffer.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        limitrenewaloffer.setProcessID(PROCESS_ID);
        limitrenewaloffer.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        limitrenewaloffer.setCreatedBy(CREATED_BY);
        limitrenewaloffer.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        limitrenewaloffer.setLastUpdatedBy(LAST_UPDATED_BY);
        limitrenewaloffer.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        limitrenewaloffer.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        limitrenewaloffer.setTemplate(rs.getString(COL_TEMPLATE));
        limitrenewaloffer.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        limitrenewaloffer.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        limitrenewaloffer.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal LOB = rs.getObject(COL_LOB, java.math.BigDecimal.class);
        limitrenewaloffer.setLob(LOB);
        java.math.BigDecimal CRN_BOR = rs.getObject(COL_CRN_BOR, java.math.BigDecimal.class);
        limitrenewaloffer.setCrnBor(CRN_BOR);
        Integer PROSPECT_ID = rs.getObject(COL_PROSPECT_ID, Integer.class);
        limitrenewaloffer.setProspectID(PROSPECT_ID);
        Timestamp VALID_TO = rs.getTimestamp(COL_VALID_TO);
        if (VALID_TO != null)
            limitrenewaloffer.setValidTo(VALID_TO.toLocalDateTime());
        java.math.BigDecimal PROC_FEE = rs.getObject(COL_PROC_FEE, java.math.BigDecimal.class);
        limitrenewaloffer.setProcFee(PROC_FEE);
        java.math.BigDecimal PROC_FEE_GST = rs.getObject(COL_PROC_FEE_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setProcFeeGst(PROC_FEE_GST);
        java.math.BigDecimal ALREADY_COLLECTED = rs.getObject(COL_ALREADY_COLLECTED, java.math.BigDecimal.class);
        limitrenewaloffer.setAlreadyCollected(ALREADY_COLLECTED);
        java.math.BigDecimal ALREADY_COLLECTED_GST = rs.getObject(COL_ALREADY_COLLECTED_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setAlreadyCollectedGst(ALREADY_COLLECTED_GST);
        java.math.BigDecimal BAL_COLLECTED = rs.getObject(COL_BAL_COLLECTED, java.math.BigDecimal.class);
        limitrenewaloffer.setBalCollected(BAL_COLLECTED);
        java.math.BigDecimal BAL_COLLECTED_GST = rs.getObject(COL_BAL_COLLECTED_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setBalCollectedGst(BAL_COLLECTED_GST);
        java.math.BigDecimal ADMIN_CHRGS = rs.getObject(COL_ADMIN_CHRGS, java.math.BigDecimal.class);
        limitrenewaloffer.setAdminChrgs(ADMIN_CHRGS);
        java.math.BigDecimal ADMIN_CHRGS_GST = rs.getObject(COL_ADMIN_CHRGS_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setAdminChrgsGst(ADMIN_CHRGS_GST);
        java.math.BigDecimal TECHNICAL_FEES = rs.getObject(COL_TECHNICAL_FEES, java.math.BigDecimal.class);
        limitrenewaloffer.setTechnicalFees(TECHNICAL_FEES);
        java.math.BigDecimal TECHNICAL_FEES_GST = rs.getObject(COL_TECHNICAL_FEES_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setTechnicalFeesGst(TECHNICAL_FEES_GST);
        Timestamp NEXT_REVIEW_DATE = rs.getTimestamp(COL_NEXT_REVIEW_DATE);
        if (NEXT_REVIEW_DATE != null)
            limitrenewaloffer.setNextReviewDate(NEXT_REVIEW_DATE.toLocalDateTime());
        Timestamp LAST_REVIEW_DATE = rs.getTimestamp(COL_LAST_REVIEW_DATE);
        if (LAST_REVIEW_DATE != null)
            limitrenewaloffer.setLastReviewDate(LAST_REVIEW_DATE.toLocalDateTime());
        limitrenewaloffer.setVarLimitApplicable(rs.getString(COL_VAR_LIMIT_APPLICABLE));
        limitrenewaloffer.setGmlLimitApplicable(rs.getString(COL_GML_LIMIT_APPLICABLE));
        limitrenewaloffer.setCgtmse(rs.getString(COL_CGTMSE));
        limitrenewaloffer.setRemarks(rs.getString(COL_REMARKS));
        limitrenewaloffer.setTermLoan(rs.getString(COL_TERM_LOAN));
        limitrenewaloffer.setSidbi(rs.getString(COL_SIDBI));
        limitrenewaloffer.setCcod(rs.getString(COL_CCOD));
        limitrenewaloffer.setSeasonalAdHoc(rs.getString(COL_SEASONAL_AD_HOC));
        limitrenewaloffer.setCrnName(rs.getString(COL_CRN_NAME));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        limitrenewaloffer.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        limitrenewaloffer.setIsMasterVersion(IS_MASTER_VERSION);
        java.math.BigDecimal ADMIN_CHARGES = rs.getObject(COL_ADMIN_CHARGES, java.math.BigDecimal.class);
        limitrenewaloffer.setAdminCharges(ADMIN_CHARGES);
        java.math.BigDecimal ADMIN_CHARGES_GST = rs.getObject(COL_ADMIN_CHARGES_GST, java.math.BigDecimal.class);
        limitrenewaloffer.setAdminChargesGst(ADMIN_CHARGES_GST);
        return limitrenewaloffer;
    }
}
