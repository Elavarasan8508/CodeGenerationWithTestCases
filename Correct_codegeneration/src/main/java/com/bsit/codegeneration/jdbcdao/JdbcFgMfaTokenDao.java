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

public class JdbcFgMfaTokenDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMfaTokenDao.class);

    private static final String TABLE = "FG_MFA_TOKEN";

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

    private static final String COL_UUID = "UUID";

    private static final String COL_ORG_CODE = "ORG_CODE";

    private static final String COL_USER_CODE = "USER_CODE";

    private static final String COL_EVENT_TYPE_CODE = "EVENT_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_REFERENCE = "ENTITY_TYPE_REFERENCE";

    private static final String COL_CHANNEL = "CHANNEL";

    private static final String COL_PRIMARY = "PRIMARY";

    private static final String COL_SECONDARY = "SECONDARY";

    private static final String COL_FACTOR_STAGE = "FACTOR_STAGE";

    private static final String COL_FAILURE_REASON = "FAILURE_REASON";

    private static final String COL_CONTENT = "CONTENT";

    private static final String COL_PRIMARY_TRIGGERED_ON = "PRIMARY_TRIGGERED_ON";

    private static final String COL_PRIMARY_EXPIRE_ON = "PRIMARY_EXPIRE_ON";

    private static final String COL_SECONDARY_TRIGGERED_ON = "SECONDARY_TRIGGERED_ON";

    private static final String COL_SECONDARY_EXPIRE_ON = "SECONDARY_EXPIRE_ON";

    private static final String COL_LOCKED_ON = "LOCKED_ON";

    private static final String COL_RELEASE_ON = "RELEASE_ON";

    private static final String COL_ATTEMPT_COUNT = "ATTEMPT_COUNT";

    private static final String COL_IS_LOCKED = "IS_LOCKED";

    private static final String COL_AUTHENTICATION_CODE = "AUTHENTICATION_CODE";

    private static final String COL_DELIVERY_CHANNEL = "DELIVERY_CHANNEL";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_UUID, COL_ORG_CODE, COL_USER_CODE, COL_EVENT_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_TYPE_REFERENCE, COL_CHANNEL, COL_PRIMARY, COL_SECONDARY, COL_FACTOR_STAGE, COL_FAILURE_REASON, COL_CONTENT, COL_PRIMARY_TRIGGERED_ON, COL_PRIMARY_EXPIRE_ON, COL_SECONDARY_TRIGGERED_ON, COL_SECONDARY_EXPIRE_ON, COL_LOCKED_ON, COL_RELEASE_ON, COL_ATTEMPT_COUNT, COL_IS_LOCKED, COL_AUTHENTICATION_CODE, COL_DELIVERY_CHANNEL);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, UUID, ORG_CODE, USER_CODE, EVENT_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_TYPE_REFERENCE, CHANNEL, PRIMARY, SECONDARY, FACTOR_STAGE, FAILURE_REASON, CONTENT, PRIMARY_TRIGGERED_ON, PRIMARY_EXPIRE_ON, SECONDARY_TRIGGERED_ON, SECONDARY_EXPIRE_ON, LOCKED_ON, RELEASE_ON, ATTEMPT_COUNT, IS_LOCKED, AUTHENTICATION_CODE, DELIVERY_CHANNEL", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, UUID, ORG_CODE, USER_CODE, EVENT_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_TYPE_REFERENCE, CHANNEL, PRIMARY, SECONDARY, FACTOR_STAGE, FAILURE_REASON, CONTENT, PRIMARY_TRIGGERED_ON, PRIMARY_EXPIRE_ON, SECONDARY_TRIGGERED_ON, SECONDARY_EXPIRE_ON, LOCKED_ON, RELEASE_ON, ATTEMPT_COUNT, IS_LOCKED, AUTHENTICATION_CODE, DELIVERY_CHANNEL", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_UUID, COL_ORG_CODE, COL_USER_CODE, COL_EVENT_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_TYPE_REFERENCE, COL_CHANNEL, COL_PRIMARY, COL_SECONDARY, COL_FACTOR_STAGE, COL_FAILURE_REASON, COL_CONTENT, COL_PRIMARY_TRIGGERED_ON, COL_PRIMARY_EXPIRE_ON, COL_SECONDARY_TRIGGERED_ON, COL_SECONDARY_EXPIRE_ON, COL_LOCKED_ON, COL_RELEASE_ON, COL_ATTEMPT_COUNT, COL_IS_LOCKED, COL_AUTHENTICATION_CODE, COL_DELIVERY_CHANNEL, COL_ID);

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

    public int insert(Connection conn, FgMfaToken fgmfatoken) throws SQLException {
        logger.debug("Inserting fgmfatoken: {}", fgmfatoken);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMfaTokenParams(ps, fgmfatoken);
            ps.executeUpdate();
            return fgmfatoken.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgMfaToken> fgmfatokens) throws SQLException {
        if (fgmfatokens == null || fgmfatokens.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmfatokens.size(); i++) {
            if (fgmfatokens.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMfaToken>> batches = chunkList(fgmfatokens, batchSize);
        int[] totalResults = new int[fgmfatokens.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMfaToken> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMfaToken fgmfatoken : batch) {
                        setFgMfaTokenParams(ps, fgmfatoken);
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

    public FgMfaToken findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMfaToken> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMfaToken> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMfaToken fgmfatoken) throws SQLException {
        if (fgmfatoken.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMfaTokenParams(ps, fgmfatoken);
            ps.setInt(45, fgmfatoken.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMfaToken> fgmfatokens) throws SQLException {
        if (fgmfatokens == null || fgmfatokens.isEmpty())
            return new int[0];
        for (FgMfaToken fgmfatoken : fgmfatokens) {
            if (fgmfatoken == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmfatoken.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMfaToken>> batches = chunkList(fgmfatokens, batchSize);
        int[] totalResults = new int[fgmfatokens.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMfaToken> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMfaToken fgmfatoken : batch) {
                        setFgMfaTokenParams(ps, fgmfatoken);
                        ps.setInt(45, fgmfatoken.getID());
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

    private void setFgMfaTokenParams(PreparedStatement ps, FgMfaToken fgmfatoken) throws SQLException {
        Integer val1 = fgmfatoken.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmfatoken.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmfatoken.getTypeCode());
        ps.setString(4, fgmfatoken.getSubTypeCode());
        ps.setString(5, fgmfatoken.getActiveCode());
        ps.setString(6, fgmfatoken.getStageCode());
        ps.setString(7, fgmfatoken.getStatusCode());
        Integer val8 = fgmfatoken.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgmfatoken.getCreatedOn());
        java.math.BigDecimal val10 = fgmfatoken.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgmfatoken.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgmfatoken.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgmfatoken.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgmfatoken.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgmfatoken.getTemplate());
        ps.setString(16, fgmfatoken.getApplicantParty());
        ps.setString(17, fgmfatoken.getFulfillmentParty());
        Integer val18 = fgmfatoken.getUploadRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = fgmfatoken.getAttachmentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgmfatoken.getParentID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = fgmfatoken.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgmfatoken.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fgmfatoken.getIsTemplate();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgmfatoken.getUuid());
        ps.setString(25, fgmfatoken.getOrgCode());
        ps.setString(26, fgmfatoken.getUserCode());
        ps.setString(27, fgmfatoken.getEventTypeCode());
        ps.setString(28, fgmfatoken.getEntityTypeCode());
        ps.setString(29, fgmfatoken.getEntityTypeReference());
        ps.setString(30, fgmfatoken.getChannel());
        ps.setString(31, fgmfatoken.getPrimary());
        ps.setString(32, fgmfatoken.getSecondary());
        ps.setString(33, fgmfatoken.getFactorStage());
        ps.setString(34, fgmfatoken.getFailureReason());
        ps.setString(35, fgmfatoken.getContent());
        ps.setString(36, fgmfatoken.getPrimaryTriggeredOn());
        ps.setString(37, fgmfatoken.getPrimaryExpireOn());
        ps.setString(38, fgmfatoken.getSecondaryTriggeredOn());
        ps.setString(39, fgmfatoken.getSecondaryExpireOn());
        ps.setString(40, fgmfatoken.getLockedOn());
        ps.setString(41, fgmfatoken.getReleaseOn());
        java.math.BigDecimal val42 = fgmfatoken.getAttemptCount();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        java.math.BigDecimal val43 = fgmfatoken.getIsLocked();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        ps.setString(44, fgmfatoken.getAuthenticationCode());
        ps.setString(45, fgmfatoken.getDeliveryChannel());
    }

    private FgMfaToken extract(ResultSet rs) throws SQLException {
        FgMfaToken fgmfatoken = new FgMfaToken();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmfatoken.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmfatoken.setReferenceID(REFERENCE_ID);
        fgmfatoken.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmfatoken.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmfatoken.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmfatoken.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmfatoken.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgmfatoken.setProcessID(PROCESS_ID);
        fgmfatoken.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmfatoken.setCreatedBy(CREATED_BY);
        fgmfatoken.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmfatoken.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmfatoken.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmfatoken.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmfatoken.setTemplate(rs.getString(COL_TEMPLATE));
        fgmfatoken.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgmfatoken.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgmfatoken.setUploadRefID(UPLOAD_REF_ID);
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgmfatoken.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        fgmfatoken.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgmfatoken.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgmfatoken.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgmfatoken.setIsTemplate(IS_TEMPLATE);
        fgmfatoken.setUuid(rs.getString(COL_UUID));
        fgmfatoken.setOrgCode(rs.getString(COL_ORG_CODE));
        fgmfatoken.setUserCode(rs.getString(COL_USER_CODE));
        fgmfatoken.setEventTypeCode(rs.getString(COL_EVENT_TYPE_CODE));
        fgmfatoken.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgmfatoken.setEntityTypeReference(rs.getString(COL_ENTITY_TYPE_REFERENCE));
        fgmfatoken.setChannel(rs.getString(COL_CHANNEL));
        fgmfatoken.setPrimary(rs.getString(COL_PRIMARY));
        fgmfatoken.setSecondary(rs.getString(COL_SECONDARY));
        fgmfatoken.setFactorStage(rs.getString(COL_FACTOR_STAGE));
        fgmfatoken.setFailureReason(rs.getString(COL_FAILURE_REASON));
        fgmfatoken.setContent(rs.getString(COL_CONTENT));
        fgmfatoken.setPrimaryTriggeredOn(rs.getString(COL_PRIMARY_TRIGGERED_ON));
        fgmfatoken.setPrimaryExpireOn(rs.getString(COL_PRIMARY_EXPIRE_ON));
        fgmfatoken.setSecondaryTriggeredOn(rs.getString(COL_SECONDARY_TRIGGERED_ON));
        fgmfatoken.setSecondaryExpireOn(rs.getString(COL_SECONDARY_EXPIRE_ON));
        fgmfatoken.setLockedOn(rs.getString(COL_LOCKED_ON));
        fgmfatoken.setReleaseOn(rs.getString(COL_RELEASE_ON));
        java.math.BigDecimal ATTEMPT_COUNT = rs.getObject(COL_ATTEMPT_COUNT, java.math.BigDecimal.class);
        fgmfatoken.setAttemptCount(ATTEMPT_COUNT);
        java.math.BigDecimal IS_LOCKED = rs.getObject(COL_IS_LOCKED, java.math.BigDecimal.class);
        fgmfatoken.setIsLocked(IS_LOCKED);
        fgmfatoken.setAuthenticationCode(rs.getString(COL_AUTHENTICATION_CODE));
        fgmfatoken.setDeliveryChannel(rs.getString(COL_DELIVERY_CHANNEL));
        return fgmfatoken;
    }
}
