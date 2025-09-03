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

public class JdbcFgTdOtpReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdOtpReqDao.class);

    private static final String TABLE = "FG_TD_OTP_REQ";

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

    private static final String COL_OTP_COUNT = "OTP_COUNT";

    private static final String COL_OTP_RESENT = "OTP_RESENT";

    private static final String COL_OTP_FAILED_COUNT = "OTP_FAILED_COUNT";

    private static final String COL_OTP_SENT_TIME = "OTP_SENT_TIME";

    private static final String COL_OTP_LOCKED_TIME = "OTP_LOCKED_TIME";

    private static final String COL_OTP_UNLOCK_TIME = "OTP_UNLOCK_TIME";

    private static final String COL_USER_CRN = "USER_CRN";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_MOBILE_MASKED = "MOBILE_MASKED";

    private static final String COL_EMAIL_MASKED = "EMAIL_MASKED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_FAILED_COUNT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_USER_CRN, COL_ENTITY_TYPE_CODE, COL_MOBILE_MASKED, COL_EMAIL_MASKED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, OTP_COUNT, OTP_RESENT, OTP_FAILED_COUNT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, USER_CRN, ENTITY_TYPE_CODE, MOBILE_MASKED, EMAIL_MASKED", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, OTP_COUNT, OTP_RESENT, OTP_FAILED_COUNT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, USER_CRN, ENTITY_TYPE_CODE, MOBILE_MASKED, EMAIL_MASKED", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_OTP_COUNT, COL_OTP_RESENT, COL_OTP_FAILED_COUNT, COL_OTP_SENT_TIME, COL_OTP_LOCKED_TIME, COL_OTP_UNLOCK_TIME, COL_USER_CRN, COL_ENTITY_TYPE_CODE, COL_MOBILE_MASKED, COL_EMAIL_MASKED, COL_ID);

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

    public int insert(Connection conn, FgTdOtpReq fgtdotpreq) throws SQLException {
        logger.debug("Inserting fgtdotpreq: {}", fgtdotpreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdOtpReqParams(ps, fgtdotpreq);
            ps.executeUpdate();
            return fgtdotpreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdOtpReq> fgtdotpreqs) throws SQLException {
        if (fgtdotpreqs == null || fgtdotpreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdotpreqs.size(); i++) {
            if (fgtdotpreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdOtpReq>> batches = chunkList(fgtdotpreqs, batchSize);
        int[] totalResults = new int[fgtdotpreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdOtpReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdOtpReq fgtdotpreq : batch) {
                        setFgTdOtpReqParams(ps, fgtdotpreq);
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

    public FgTdOtpReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdOtpReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdOtpReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdOtpReq fgtdotpreq) throws SQLException {
        if (fgtdotpreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdOtpReqParams(ps, fgtdotpreq);
            ps.setInt(28, fgtdotpreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdOtpReq> fgtdotpreqs) throws SQLException {
        if (fgtdotpreqs == null || fgtdotpreqs.isEmpty())
            return new int[0];
        for (FgTdOtpReq fgtdotpreq : fgtdotpreqs) {
            if (fgtdotpreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdotpreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdOtpReq>> batches = chunkList(fgtdotpreqs, batchSize);
        int[] totalResults = new int[fgtdotpreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdOtpReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdOtpReq fgtdotpreq : batch) {
                        setFgTdOtpReqParams(ps, fgtdotpreq);
                        ps.setInt(28, fgtdotpreq.getID());
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

    private void setFgTdOtpReqParams(PreparedStatement ps, FgTdOtpReq fgtdotpreq) throws SQLException {
        Integer val1 = fgtdotpreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtdotpreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtdotpreq.getTypeCode());
        ps.setString(4, fgtdotpreq.getSubTypeCode());
        ps.setString(5, fgtdotpreq.getActiveCode());
        ps.setString(6, fgtdotpreq.getStageCode());
        ps.setString(7, fgtdotpreq.getStatusCode());
        Integer val8 = fgtdotpreq.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtdotpreq.getCreatedOn());
        java.math.BigDecimal val10 = fgtdotpreq.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtdotpreq.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtdotpreq.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtdotpreq.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtdotpreq.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtdotpreq.getTemplate());
        ps.setString(16, fgtdotpreq.getApplicantParty());
        ps.setString(17, fgtdotpreq.getFulfillmentParty());
        java.math.BigDecimal val18 = fgtdotpreq.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgtdotpreq.getOtpCount();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtdotpreq.getOtpResent();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtdotpreq.getOtpFailedCount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgtdotpreq.getOtpSentTime());
        ps.setString(23, fgtdotpreq.getOtpLockedTime());
        ps.setString(24, fgtdotpreq.getOtpUnlockTime());
        ps.setString(25, fgtdotpreq.getUserCrn());
        ps.setString(26, fgtdotpreq.getEntityTypeCode());
        ps.setString(27, fgtdotpreq.getMobileMasked());
        ps.setString(28, fgtdotpreq.getEmailMasked());
    }

    private FgTdOtpReq extract(ResultSet rs) throws SQLException {
        FgTdOtpReq fgtdotpreq = new FgTdOtpReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtdotpreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdotpreq.setReferenceID(REFERENCE_ID);
        fgtdotpreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdotpreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdotpreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtdotpreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdotpreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdotpreq.setProcessID(PROCESS_ID);
        fgtdotpreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtdotpreq.setCreatedBy(CREATED_BY);
        fgtdotpreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtdotpreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtdotpreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtdotpreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtdotpreq.setTemplate(rs.getString(COL_TEMPLATE));
        fgtdotpreq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtdotpreq.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtdotpreq.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal OTP_COUNT = rs.getObject(COL_OTP_COUNT, java.math.BigDecimal.class);
        fgtdotpreq.setOtpCount(OTP_COUNT);
        java.math.BigDecimal OTP_RESENT = rs.getObject(COL_OTP_RESENT, java.math.BigDecimal.class);
        fgtdotpreq.setOtpResent(OTP_RESENT);
        java.math.BigDecimal OTP_FAILED_COUNT = rs.getObject(COL_OTP_FAILED_COUNT, java.math.BigDecimal.class);
        fgtdotpreq.setOtpFailedCount(OTP_FAILED_COUNT);
        fgtdotpreq.setOtpSentTime(rs.getString(COL_OTP_SENT_TIME));
        fgtdotpreq.setOtpLockedTime(rs.getString(COL_OTP_LOCKED_TIME));
        fgtdotpreq.setOtpUnlockTime(rs.getString(COL_OTP_UNLOCK_TIME));
        fgtdotpreq.setUserCrn(rs.getString(COL_USER_CRN));
        fgtdotpreq.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgtdotpreq.setMobileMasked(rs.getString(COL_MOBILE_MASKED));
        fgtdotpreq.setEmailMasked(rs.getString(COL_EMAIL_MASKED));
        return fgtdotpreq;
    }
}
