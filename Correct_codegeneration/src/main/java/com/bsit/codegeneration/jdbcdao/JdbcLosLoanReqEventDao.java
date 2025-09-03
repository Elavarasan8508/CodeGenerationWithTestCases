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

public class JdbcLosLoanReqEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLosLoanReqEventDao.class);

    private static final String TABLE = "LOS_LOAN_REQ_EVENT";

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

    private static final String COL_EVENT_COMMENTS = "EVENT_COMMENTS";

    private static final String COL_EVENT_DUE_DATE = "EVENT_DUE_DATE";

    private static final String COL_EVENT_RESPONDED_ON = "EVENT_RESPONDED_ON";

    private static final String COL_EVENT_COMPLETED_OM = "EVENT_COMPLETED_OM";

    private static final String COL_EVENT_EXPIRED_ON = "EVENT_EXPIRED_ON";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_REJECTION_REASON_CODE = "REJECTION_REASON_CODE";

    private static final String COL_REJECTION_COMMENTS = "REJECTION_COMMENTS";

    private static final String COL_EVENT_CATEGORY_CODE = "EVENT_CATEGORY_CODE";

    private static final String COL_EVENT_TYPE_CODE = "EVENT_TYPE_CODE";

    private static final String COL_EVENT_OCCURRED_ON = "EVENT_OCCURRED_ON";

    private static final String COL_EVENT_TRIGGER_ROLE = "EVENT_TRIGGER_ROLE";

    private static final String COL_ACTION_COMMENTS = "ACTION_COMMENTS";

    private static final String COL_ACTION_REQUIRED_FLAG = "ACTION_REQUIRED_FLAG";

    private static final String COL_ACTION_TYPE_CODE = "ACTION_TYPE_CODE";

    private static final String COL_ACTION_STATUS_CODE = "ACTION_STATUS_CODE";

    private static final String COL_ACTION_PERFORMER_ROLE = "ACTION_PERFORMER_ROLE";

    private static final String COL_LOAN_REQUEST_REFERENCE = "LOAN_REQUEST_REFERENCE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_EVENT_SUBJECT = "EVENT_SUBJECT";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String COL_ACCEPTANCE_PARTY = "ACCEPTANCE_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_EVENT_COMMENTS, COL_EVENT_DUE_DATE, COL_EVENT_RESPONDED_ON, COL_EVENT_COMPLETED_OM, COL_EVENT_EXPIRED_ON, COL_UPLOAD_REF_ID, COL_REJECTION_REASON_CODE, COL_REJECTION_COMMENTS, COL_EVENT_CATEGORY_CODE, COL_EVENT_TYPE_CODE, COL_EVENT_OCCURRED_ON, COL_EVENT_TRIGGER_ROLE, COL_ACTION_COMMENTS, COL_ACTION_REQUIRED_FLAG, COL_ACTION_TYPE_CODE, COL_ACTION_STATUS_CODE, COL_ACTION_PERFORMER_ROLE, COL_LOAN_REQUEST_REFERENCE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_EVENT_SUBJECT, COL_PRODUCT_STATUS_CODE, COL_ACCEPTANCE_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EVENT_COMMENTS, EVENT_DUE_DATE, EVENT_RESPONDED_ON, EVENT_COMPLETED_OM, EVENT_EXPIRED_ON, UPLOAD_REF_ID, REJECTION_REASON_CODE, REJECTION_COMMENTS, EVENT_CATEGORY_CODE, EVENT_TYPE_CODE, EVENT_OCCURRED_ON, EVENT_TRIGGER_ROLE, ACTION_COMMENTS, ACTION_REQUIRED_FLAG, ACTION_TYPE_CODE, ACTION_STATUS_CODE, ACTION_PERFORMER_ROLE, LOAN_REQUEST_REFERENCE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, VERSION_ID, IS_MASTER_VERSION, EVENT_SUBJECT, PRODUCT_STATUS_CODE, ACCEPTANCE_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EVENT_COMMENTS, EVENT_DUE_DATE, EVENT_RESPONDED_ON, EVENT_COMPLETED_OM, EVENT_EXPIRED_ON, UPLOAD_REF_ID, REJECTION_REASON_CODE, REJECTION_COMMENTS, EVENT_CATEGORY_CODE, EVENT_TYPE_CODE, EVENT_OCCURRED_ON, EVENT_TRIGGER_ROLE, ACTION_COMMENTS, ACTION_REQUIRED_FLAG, ACTION_TYPE_CODE, ACTION_STATUS_CODE, ACTION_PERFORMER_ROLE, LOAN_REQUEST_REFERENCE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, VERSION_ID, IS_MASTER_VERSION, EVENT_SUBJECT, PRODUCT_STATUS_CODE, ACCEPTANCE_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_EVENT_COMMENTS, COL_EVENT_DUE_DATE, COL_EVENT_RESPONDED_ON, COL_EVENT_COMPLETED_OM, COL_EVENT_EXPIRED_ON, COL_UPLOAD_REF_ID, COL_REJECTION_REASON_CODE, COL_REJECTION_COMMENTS, COL_EVENT_CATEGORY_CODE, COL_EVENT_TYPE_CODE, COL_EVENT_OCCURRED_ON, COL_EVENT_TRIGGER_ROLE, COL_ACTION_COMMENTS, COL_ACTION_REQUIRED_FLAG, COL_ACTION_TYPE_CODE, COL_ACTION_STATUS_CODE, COL_ACTION_PERFORMER_ROLE, COL_LOAN_REQUEST_REFERENCE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_EVENT_SUBJECT, COL_PRODUCT_STATUS_CODE, COL_ACCEPTANCE_PARTY, COL_ID);

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

    public int insert(Connection conn, LosLoanReqEvent losloanreqevent) throws SQLException {
        logger.debug("Inserting losloanreqevent: {}", losloanreqevent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLosLoanReqEventParams(ps, losloanreqevent);
            ps.executeUpdate();
            return losloanreqevent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LosLoanReqEvent> losloanreqevents) throws SQLException {
        if (losloanreqevents == null || losloanreqevents.isEmpty())
            return new int[0];
        for (int i = 0; i < losloanreqevents.size(); i++) {
            if (losloanreqevents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LosLoanReqEvent>> batches = chunkList(losloanreqevents, batchSize);
        int[] totalResults = new int[losloanreqevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LosLoanReqEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LosLoanReqEvent losloanreqevent : batch) {
                        setLosLoanReqEventParams(ps, losloanreqevent);
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

    public LosLoanReqEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LosLoanReqEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LosLoanReqEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, LosLoanReqEvent losloanreqevent) throws SQLException {
        if (losloanreqevent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLosLoanReqEventParams(ps, losloanreqevent);
            ps.setInt(44, losloanreqevent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LosLoanReqEvent> losloanreqevents) throws SQLException {
        if (losloanreqevents == null || losloanreqevents.isEmpty())
            return new int[0];
        for (LosLoanReqEvent losloanreqevent : losloanreqevents) {
            if (losloanreqevent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (losloanreqevent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LosLoanReqEvent>> batches = chunkList(losloanreqevents, batchSize);
        int[] totalResults = new int[losloanreqevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LosLoanReqEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LosLoanReqEvent losloanreqevent : batch) {
                        setLosLoanReqEventParams(ps, losloanreqevent);
                        ps.setInt(44, losloanreqevent.getID());
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

    private void setLosLoanReqEventParams(PreparedStatement ps, LosLoanReqEvent losloanreqevent) throws SQLException {
        Integer val1 = losloanreqevent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = losloanreqevent.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, losloanreqevent.getTypeCode());
        ps.setString(4, losloanreqevent.getSubTypeCode());
        ps.setString(5, losloanreqevent.getActiveCode());
        ps.setString(6, losloanreqevent.getStageCode());
        ps.setString(7, losloanreqevent.getStatusCode());
        Integer val8 = losloanreqevent.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, losloanreqevent.getCreatedOn());
        java.math.BigDecimal val10 = losloanreqevent.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, losloanreqevent.getLastUpdatedOn());
        java.math.BigDecimal val12 = losloanreqevent.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, losloanreqevent.getLastAuthorisedOn());
        java.math.BigDecimal val14 = losloanreqevent.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, losloanreqevent.getTemplate());
        ps.setString(16, losloanreqevent.getApplicantParty());
        ps.setString(17, losloanreqevent.getFulfillmentParty());
        java.math.BigDecimal val18 = losloanreqevent.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, losloanreqevent.getEventComments());
        java.time.LocalDateTime val20 = losloanreqevent.getEventDueDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, losloanreqevent.getEventRespondedOn());
        ps.setString(22, losloanreqevent.getEventCompletedOm());
        ps.setString(23, losloanreqevent.getEventExpiredOn());
        Integer val24 = losloanreqevent.getUploadRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        ps.setString(25, losloanreqevent.getRejectionReasonCode());
        ps.setString(26, losloanreqevent.getRejectionComments());
        ps.setString(27, losloanreqevent.getEventCategoryCode());
        ps.setString(28, losloanreqevent.getEventTypeCode());
        ps.setString(29, losloanreqevent.getEventOccurredOn());
        ps.setString(30, losloanreqevent.getEventTriggerRole());
        ps.setString(31, losloanreqevent.getActionComments());
        java.math.BigDecimal val32 = losloanreqevent.getActionRequiredFlag();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, losloanreqevent.getActionTypeCode());
        ps.setString(34, losloanreqevent.getActionStatusCode());
        ps.setString(35, losloanreqevent.getActionPerformerRole());
        ps.setString(36, losloanreqevent.getLoanRequestReference());
        ps.setString(37, losloanreqevent.getProductCode());
        ps.setString(38, losloanreqevent.getSubProductCode());
        ps.setString(39, losloanreqevent.getSegmentCode());
        Integer val40 = losloanreqevent.getVersionID();
        if (val40 != null) {
            ps.setInt(40, val40);
        } else {
            ps.setNull(40, Types.INTEGER);
        }
        java.math.BigDecimal val41 = losloanreqevent.getIsMasterVersion();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, losloanreqevent.getEventSubject());
        ps.setString(43, losloanreqevent.getProductStatusCode());
        ps.setString(44, losloanreqevent.getAcceptanceParty());
    }

    private LosLoanReqEvent extract(ResultSet rs) throws SQLException {
        LosLoanReqEvent losloanreqevent = new LosLoanReqEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        losloanreqevent.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        losloanreqevent.setReferenceID(REFERENCE_ID);
        losloanreqevent.setTypeCode(rs.getString(COL_TYPE_CODE));
        losloanreqevent.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        losloanreqevent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        losloanreqevent.setStageCode(rs.getString(COL_STAGE_CODE));
        losloanreqevent.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        losloanreqevent.setProcessID(PROCESS_ID);
        losloanreqevent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        losloanreqevent.setCreatedBy(CREATED_BY);
        losloanreqevent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        losloanreqevent.setLastUpdatedBy(LAST_UPDATED_BY);
        losloanreqevent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        losloanreqevent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        losloanreqevent.setTemplate(rs.getString(COL_TEMPLATE));
        losloanreqevent.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        losloanreqevent.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        losloanreqevent.setIsTemplate(IS_TEMPLATE);
        losloanreqevent.setEventComments(rs.getString(COL_EVENT_COMMENTS));
        Timestamp EVENT_DUE_DATE = rs.getTimestamp(COL_EVENT_DUE_DATE);
        if (EVENT_DUE_DATE != null)
            losloanreqevent.setEventDueDate(EVENT_DUE_DATE.toLocalDateTime());
        losloanreqevent.setEventRespondedOn(rs.getString(COL_EVENT_RESPONDED_ON));
        losloanreqevent.setEventCompletedOm(rs.getString(COL_EVENT_COMPLETED_OM));
        losloanreqevent.setEventExpiredOn(rs.getString(COL_EVENT_EXPIRED_ON));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        losloanreqevent.setUploadRefID(UPLOAD_REF_ID);
        losloanreqevent.setRejectionReasonCode(rs.getString(COL_REJECTION_REASON_CODE));
        losloanreqevent.setRejectionComments(rs.getString(COL_REJECTION_COMMENTS));
        losloanreqevent.setEventCategoryCode(rs.getString(COL_EVENT_CATEGORY_CODE));
        losloanreqevent.setEventTypeCode(rs.getString(COL_EVENT_TYPE_CODE));
        losloanreqevent.setEventOccurredOn(rs.getString(COL_EVENT_OCCURRED_ON));
        losloanreqevent.setEventTriggerRole(rs.getString(COL_EVENT_TRIGGER_ROLE));
        losloanreqevent.setActionComments(rs.getString(COL_ACTION_COMMENTS));
        java.math.BigDecimal ACTION_REQUIRED_FLAG = rs.getObject(COL_ACTION_REQUIRED_FLAG, java.math.BigDecimal.class);
        losloanreqevent.setActionRequiredFlag(ACTION_REQUIRED_FLAG);
        losloanreqevent.setActionTypeCode(rs.getString(COL_ACTION_TYPE_CODE));
        losloanreqevent.setActionStatusCode(rs.getString(COL_ACTION_STATUS_CODE));
        losloanreqevent.setActionPerformerRole(rs.getString(COL_ACTION_PERFORMER_ROLE));
        losloanreqevent.setLoanRequestReference(rs.getString(COL_LOAN_REQUEST_REFERENCE));
        losloanreqevent.setProductCode(rs.getString(COL_PRODUCT_CODE));
        losloanreqevent.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        losloanreqevent.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        losloanreqevent.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        losloanreqevent.setIsMasterVersion(IS_MASTER_VERSION);
        losloanreqevent.setEventSubject(rs.getString(COL_EVENT_SUBJECT));
        losloanreqevent.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        losloanreqevent.setAcceptanceParty(rs.getString(COL_ACCEPTANCE_PARTY));
        return losloanreqevent;
    }
}
