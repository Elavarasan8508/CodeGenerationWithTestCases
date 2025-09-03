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

public class JdbcLimitRenewalReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLimitRenewalReqDao.class);

    private static final String TABLE = "LIMIT_RENEWAL_REQ";

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

    private static final String COL_CORP_CRN = "CORP_CRN";

    private static final String COL_CORP_CRN_NAME = "CORP_CRN_NAME";

    private static final String COL_USER_CRN = "USER_CRN";

    private static final String COL_USER_CRN_NAME = "USER_CRN_NAME";

    private static final String COL_NEXT_REVIEW_DATE = "NEXT_REVIEW_DATE";

    private static final String COL_TECHNICAL_FEES = "TECHNICAL_FEES";

    private static final String COL_ADMIN_CHRGS = "ADMIN_CHRGS";

    private static final String COL_PROC_FEE = "PROC_FEE";

    private static final String COL_TOTAL_GST = "TOTAL_GST";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_OFFER_REFERENCE = "OFFER_REFERENCE";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CORP_CRN, COL_CORP_CRN_NAME, COL_USER_CRN, COL_USER_CRN_NAME, COL_NEXT_REVIEW_DATE, COL_TECHNICAL_FEES, COL_ADMIN_CHRGS, COL_PROC_FEE, COL_TOTAL_GST, COL_REMARKS, COL_OFFER_REFERENCE, COL_PRODUCT_STATUS_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CORP_CRN, CORP_CRN_NAME, USER_CRN, USER_CRN_NAME, NEXT_REVIEW_DATE, TECHNICAL_FEES, ADMIN_CHRGS, PROC_FEE, TOTAL_GST, REMARKS, OFFER_REFERENCE, PRODUCT_STATUS_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CORP_CRN, CORP_CRN_NAME, USER_CRN, USER_CRN_NAME, NEXT_REVIEW_DATE, TECHNICAL_FEES, ADMIN_CHRGS, PROC_FEE, TOTAL_GST, REMARKS, OFFER_REFERENCE, PRODUCT_STATUS_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CORP_CRN, COL_CORP_CRN_NAME, COL_USER_CRN, COL_USER_CRN_NAME, COL_NEXT_REVIEW_DATE, COL_TECHNICAL_FEES, COL_ADMIN_CHRGS, COL_PROC_FEE, COL_TOTAL_GST, COL_REMARKS, COL_OFFER_REFERENCE, COL_PRODUCT_STATUS_CODE, COL_ID);

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

    public int insert(Connection conn, LimitRenewalReq limitrenewalreq) throws SQLException {
        logger.debug("Inserting limitrenewalreq: {}", limitrenewalreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLimitRenewalReqParams(ps, limitrenewalreq);
            ps.executeUpdate();
            return limitrenewalreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LimitRenewalReq> limitrenewalreqs) throws SQLException {
        if (limitrenewalreqs == null || limitrenewalreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < limitrenewalreqs.size(); i++) {
            if (limitrenewalreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LimitRenewalReq>> batches = chunkList(limitrenewalreqs, batchSize);
        int[] totalResults = new int[limitrenewalreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LimitRenewalReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LimitRenewalReq limitrenewalreq : batch) {
                        setLimitRenewalReqParams(ps, limitrenewalreq);
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

    public LimitRenewalReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LimitRenewalReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LimitRenewalReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, LimitRenewalReq limitrenewalreq) throws SQLException {
        if (limitrenewalreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLimitRenewalReqParams(ps, limitrenewalreq);
            ps.setInt(30, limitrenewalreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LimitRenewalReq> limitrenewalreqs) throws SQLException {
        if (limitrenewalreqs == null || limitrenewalreqs.isEmpty())
            return new int[0];
        for (LimitRenewalReq limitrenewalreq : limitrenewalreqs) {
            if (limitrenewalreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (limitrenewalreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LimitRenewalReq>> batches = chunkList(limitrenewalreqs, batchSize);
        int[] totalResults = new int[limitrenewalreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LimitRenewalReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LimitRenewalReq limitrenewalreq : batch) {
                        setLimitRenewalReqParams(ps, limitrenewalreq);
                        ps.setInt(30, limitrenewalreq.getID());
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

    private void setLimitRenewalReqParams(PreparedStatement ps, LimitRenewalReq limitrenewalreq) throws SQLException {
        Integer val1 = limitrenewalreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = limitrenewalreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, limitrenewalreq.getTypeCode());
        ps.setString(4, limitrenewalreq.getSubTypeCode());
        ps.setString(5, limitrenewalreq.getActiveCode());
        ps.setString(6, limitrenewalreq.getStageCode());
        ps.setString(7, limitrenewalreq.getStatusCode());
        Integer val8 = limitrenewalreq.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, limitrenewalreq.getCreatedOn());
        java.math.BigDecimal val10 = limitrenewalreq.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, limitrenewalreq.getLastUpdatedOn());
        java.math.BigDecimal val12 = limitrenewalreq.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, limitrenewalreq.getLastAuthorisedOn());
        java.math.BigDecimal val14 = limitrenewalreq.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, limitrenewalreq.getTemplate());
        ps.setString(16, limitrenewalreq.getApplicantParty());
        ps.setString(17, limitrenewalreq.getFulfillmentParty());
        java.math.BigDecimal val18 = limitrenewalreq.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = limitrenewalreq.getCorpCrn();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, limitrenewalreq.getCorpCrnName());
        java.math.BigDecimal val21 = limitrenewalreq.getUserCrn();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, limitrenewalreq.getUserCrnName());
        java.time.LocalDateTime val23 = limitrenewalreq.getNextReviewDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        java.math.BigDecimal val24 = limitrenewalreq.getTechnicalFees();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = limitrenewalreq.getAdminChrgs();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = limitrenewalreq.getProcFee();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = limitrenewalreq.getTotalGst();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, limitrenewalreq.getRemarks());
        ps.setString(29, limitrenewalreq.getOfferReference());
        ps.setString(30, limitrenewalreq.getProductStatusCode());
    }

    private LimitRenewalReq extract(ResultSet rs) throws SQLException {
        LimitRenewalReq limitrenewalreq = new LimitRenewalReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        limitrenewalreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        limitrenewalreq.setReferenceID(REFERENCE_ID);
        limitrenewalreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        limitrenewalreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        limitrenewalreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        limitrenewalreq.setStageCode(rs.getString(COL_STAGE_CODE));
        limitrenewalreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        limitrenewalreq.setProcessID(PROCESS_ID);
        limitrenewalreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        limitrenewalreq.setCreatedBy(CREATED_BY);
        limitrenewalreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        limitrenewalreq.setLastUpdatedBy(LAST_UPDATED_BY);
        limitrenewalreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        limitrenewalreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        limitrenewalreq.setTemplate(rs.getString(COL_TEMPLATE));
        limitrenewalreq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        limitrenewalreq.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        limitrenewalreq.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal CORP_CRN = rs.getObject(COL_CORP_CRN, java.math.BigDecimal.class);
        limitrenewalreq.setCorpCrn(CORP_CRN);
        limitrenewalreq.setCorpCrnName(rs.getString(COL_CORP_CRN_NAME));
        java.math.BigDecimal USER_CRN = rs.getObject(COL_USER_CRN, java.math.BigDecimal.class);
        limitrenewalreq.setUserCrn(USER_CRN);
        limitrenewalreq.setUserCrnName(rs.getString(COL_USER_CRN_NAME));
        Timestamp NEXT_REVIEW_DATE = rs.getTimestamp(COL_NEXT_REVIEW_DATE);
        if (NEXT_REVIEW_DATE != null)
            limitrenewalreq.setNextReviewDate(NEXT_REVIEW_DATE.toLocalDateTime());
        java.math.BigDecimal TECHNICAL_FEES = rs.getObject(COL_TECHNICAL_FEES, java.math.BigDecimal.class);
        limitrenewalreq.setTechnicalFees(TECHNICAL_FEES);
        java.math.BigDecimal ADMIN_CHRGS = rs.getObject(COL_ADMIN_CHRGS, java.math.BigDecimal.class);
        limitrenewalreq.setAdminChrgs(ADMIN_CHRGS);
        java.math.BigDecimal PROC_FEE = rs.getObject(COL_PROC_FEE, java.math.BigDecimal.class);
        limitrenewalreq.setProcFee(PROC_FEE);
        java.math.BigDecimal TOTAL_GST = rs.getObject(COL_TOTAL_GST, java.math.BigDecimal.class);
        limitrenewalreq.setTotalGst(TOTAL_GST);
        limitrenewalreq.setRemarks(rs.getString(COL_REMARKS));
        limitrenewalreq.setOfferReference(rs.getString(COL_OFFER_REFERENCE));
        limitrenewalreq.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        return limitrenewalreq;
    }
}
