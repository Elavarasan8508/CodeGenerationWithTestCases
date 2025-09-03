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

public class JdbcFgEventNotificationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEventNotificationDao.class);

    private static final String TABLE = "FG_EVENT_NOTIFICATION";

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

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_EVENT_TYPE = "EVENT_TYPE";

    private static final String COL_EVENT_STATUS = "EVENT_STATUS";

    private static final String COL_CHANNEL = "CHANNEL";

    private static final String COL_NOTIFICATION_PURPOSE = "NOTIFICATION_PURPOSE";

    private static final String COL_STAGES = "STAGES";

    private static final String COL_EVENT_TEMPLATE_ID = "EVENT_TEMPLATE_ID";

    private static final String COL_RECIPIENT_MOBILE_NUMBER = "RECIPIENT_MOBILE_NUMBER";

    private static final String COL_RECIPIENT_EMAIL_ADDRESS = "RECIPIENT_EMAIL_ADDRESS";

    private static final String COL_SENDERS_EMAIL_ADDRESS = "SENDERS_EMAIL_ADDRESS";

    private static final String COL_SUBJECT = "SUBJECT";

    private static final String COL_CONTENT = "CONTENT";

    private static final String COL_ATTACHMENTS = "ATTACHMENTS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_EVENT_TYPE, COL_EVENT_STATUS, COL_CHANNEL, COL_NOTIFICATION_PURPOSE, COL_STAGES, COL_EVENT_TEMPLATE_ID, COL_RECIPIENT_MOBILE_NUMBER, COL_RECIPIENT_EMAIL_ADDRESS, COL_SENDERS_EMAIL_ADDRESS, COL_SUBJECT, COL_CONTENT, COL_ATTACHMENTS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, EVENT_TYPE, EVENT_STATUS, CHANNEL, NOTIFICATION_PURPOSE, STAGES, EVENT_TEMPLATE_ID, RECIPIENT_MOBILE_NUMBER, RECIPIENT_EMAIL_ADDRESS, SENDERS_EMAIL_ADDRESS, SUBJECT, CONTENT, ATTACHMENTS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, EVENT_TYPE, EVENT_STATUS, CHANNEL, NOTIFICATION_PURPOSE, STAGES, EVENT_TEMPLATE_ID, RECIPIENT_MOBILE_NUMBER, RECIPIENT_EMAIL_ADDRESS, SENDERS_EMAIL_ADDRESS, SUBJECT, CONTENT, ATTACHMENTS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_EVENT_TYPE, COL_EVENT_STATUS, COL_CHANNEL, COL_NOTIFICATION_PURPOSE, COL_STAGES, COL_EVENT_TEMPLATE_ID, COL_RECIPIENT_MOBILE_NUMBER, COL_RECIPIENT_EMAIL_ADDRESS, COL_SENDERS_EMAIL_ADDRESS, COL_SUBJECT, COL_CONTENT, COL_ATTACHMENTS, COL_ID);

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

    public int insert(Connection conn, FgEventNotification fgeventnotification) throws SQLException {
        logger.debug("Inserting fgeventnotification: {}", fgeventnotification);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEventNotificationParams(ps, fgeventnotification);
            ps.executeUpdate();
            return fgeventnotification.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEventNotification> fgeventnotifications) throws SQLException {
        if (fgeventnotifications == null || fgeventnotifications.isEmpty())
            return new int[0];
        for (int i = 0; i < fgeventnotifications.size(); i++) {
            if (fgeventnotifications.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEventNotification>> batches = chunkList(fgeventnotifications, batchSize);
        int[] totalResults = new int[fgeventnotifications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEventNotification> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEventNotification fgeventnotification : batch) {
                        setFgEventNotificationParams(ps, fgeventnotification);
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

    public FgEventNotification findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEventNotification> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEventNotification> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEventNotification fgeventnotification) throws SQLException {
        if (fgeventnotification.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEventNotificationParams(ps, fgeventnotification);
            ps.setInt(31, fgeventnotification.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEventNotification> fgeventnotifications) throws SQLException {
        if (fgeventnotifications == null || fgeventnotifications.isEmpty())
            return new int[0];
        for (FgEventNotification fgeventnotification : fgeventnotifications) {
            if (fgeventnotification == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgeventnotification.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEventNotification>> batches = chunkList(fgeventnotifications, batchSize);
        int[] totalResults = new int[fgeventnotifications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEventNotification> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEventNotification fgeventnotification : batch) {
                        setFgEventNotificationParams(ps, fgeventnotification);
                        ps.setInt(31, fgeventnotification.getID());
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

    private void setFgEventNotificationParams(PreparedStatement ps, FgEventNotification fgeventnotification) throws SQLException {
        Integer val1 = fgeventnotification.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgeventnotification.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgeventnotification.getTypeCode());
        ps.setString(4, fgeventnotification.getSubTypeCode());
        ps.setString(5, fgeventnotification.getActiveCode());
        ps.setString(6, fgeventnotification.getStageCode());
        ps.setString(7, fgeventnotification.getStatusCode());
        ps.setString(8, fgeventnotification.getCreatedOn());
        java.math.BigDecimal val9 = fgeventnotification.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgeventnotification.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgeventnotification.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgeventnotification.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgeventnotification.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgeventnotification.getTemplate());
        java.math.BigDecimal val15 = fgeventnotification.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgeventnotification.getEntityRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgeventnotification.getEntityVersionID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        ps.setString(18, fgeventnotification.getEntityTypeCode());
        ps.setString(19, fgeventnotification.getEntitySubTypeCode());
        ps.setString(20, fgeventnotification.getEventType());
        ps.setString(21, fgeventnotification.getEventStatus());
        ps.setString(22, fgeventnotification.getChannel());
        ps.setString(23, fgeventnotification.getNotificationPurpose());
        ps.setString(24, fgeventnotification.getStages());
        Integer val25 = fgeventnotification.getEventTemplateID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        ps.setString(26, fgeventnotification.getRecipientMobileNumber());
        ps.setString(27, fgeventnotification.getRecipientEmailAddress());
        ps.setString(28, fgeventnotification.getSendersEmailAddress());
        ps.setString(29, fgeventnotification.getSubject());
        ps.setString(30, fgeventnotification.getContent());
        java.math.BigDecimal val31 = fgeventnotification.getAttachments();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
    }

    private FgEventNotification extract(ResultSet rs) throws SQLException {
        FgEventNotification fgeventnotification = new FgEventNotification();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgeventnotification.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgeventnotification.setReferenceID(REFERENCE_ID);
        fgeventnotification.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgeventnotification.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgeventnotification.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgeventnotification.setStageCode(rs.getString(COL_STAGE_CODE));
        fgeventnotification.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgeventnotification.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgeventnotification.setCreatedBy(CREATED_BY);
        fgeventnotification.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgeventnotification.setLastUpdatedBy(LAST_UPDATED_BY);
        fgeventnotification.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgeventnotification.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgeventnotification.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgeventnotification.setIsTemplate(IS_TEMPLATE);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgeventnotification.setEntityRefID(ENTITY_REF_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgeventnotification.setEntityVersionID(ENTITY_VERSION_ID);
        fgeventnotification.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgeventnotification.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgeventnotification.setEventType(rs.getString(COL_EVENT_TYPE));
        fgeventnotification.setEventStatus(rs.getString(COL_EVENT_STATUS));
        fgeventnotification.setChannel(rs.getString(COL_CHANNEL));
        fgeventnotification.setNotificationPurpose(rs.getString(COL_NOTIFICATION_PURPOSE));
        fgeventnotification.setStages(rs.getString(COL_STAGES));
        Integer EVENT_TEMPLATE_ID = rs.getObject(COL_EVENT_TEMPLATE_ID, Integer.class);
        fgeventnotification.setEventTemplateID(EVENT_TEMPLATE_ID);
        fgeventnotification.setRecipientMobileNumber(rs.getString(COL_RECIPIENT_MOBILE_NUMBER));
        fgeventnotification.setRecipientEmailAddress(rs.getString(COL_RECIPIENT_EMAIL_ADDRESS));
        fgeventnotification.setSendersEmailAddress(rs.getString(COL_SENDERS_EMAIL_ADDRESS));
        fgeventnotification.setSubject(rs.getString(COL_SUBJECT));
        fgeventnotification.setContent(rs.getString(COL_CONTENT));
        java.math.BigDecimal ATTACHMENTS = rs.getObject(COL_ATTACHMENTS, java.math.BigDecimal.class);
        fgeventnotification.setAttachments(ATTACHMENTS);
        return fgeventnotification;
    }
}
