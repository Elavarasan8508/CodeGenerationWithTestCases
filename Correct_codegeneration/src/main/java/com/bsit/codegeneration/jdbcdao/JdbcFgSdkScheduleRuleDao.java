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

public class JdbcFgSdkScheduleRuleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkScheduleRuleDao.class);

    private static final String TABLE = "FG_SDK_SCHEDULE_RULE";

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

    private static final String COL_SCHEDULE_TYPE = "SCHEDULE_TYPE";

    private static final String COL_SUBSCRIPTION_NAME = "SUBSCRIPTION_NAME";

    private static final String COL_OWNER_ORG_TYPE_CODE = "OWNER_ORG_TYPE_CODE";

    private static final String COL_OWNER_ORG_CODE = "OWNER_ORG_CODE";

    private static final String COL_SUBSCRIBER_ORG_TYPE_CODE = "SUBSCRIBER_ORG_TYPE_CODE";

    private static final String COL_SUBSCRIBER_ORG_CODE = "SUBSCRIBER_ORG_CODE";

    private static final String COL_CRON_EXPRESSION = "CRON_EXPRESSION";

    private static final String COL_SCHEDULE_CHANNEL_CODE = "SCHEDULE_CHANNEL_CODE";

    private static final String COL_ALERT_TEMPLATE_ID = "ALERT_TEMPLATE_ID";

    private static final String COL_EXTERNAL_EMAIL = "EXTERNAL_EMAIL";

    private static final String COL_CHANNEL_EMAIL_TITLE = "CHANNEL_EMAIL_TITLE";

    private static final String COL_CHANNEL_EMAIL_CONTENT = "CHANNEL_EMAIL_CONTENT";

    private static final String COL_SCHEDULE_START_DATE = "SCHEDULE_START_DATE";

    private static final String COL_SCHEDULE_END_DATE = "SCHEDULE_END_DATE";

    private static final String COL_H2H_DATASOURCE_ID = "H2H_DATASOURCE_ID";

    private static final String COL_H2H_DATASET_ID = "H2H_DATASET_ID";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_SOURCE_REF_ID = "SOURCE_REF_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_CRON_OBJ = "CRON_OBJ";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEDULE_TYPE, COL_SUBSCRIPTION_NAME, COL_OWNER_ORG_TYPE_CODE, COL_OWNER_ORG_CODE, COL_SUBSCRIBER_ORG_TYPE_CODE, COL_SUBSCRIBER_ORG_CODE, COL_CRON_EXPRESSION, COL_SCHEDULE_CHANNEL_CODE, COL_ALERT_TEMPLATE_ID, COL_EXTERNAL_EMAIL, COL_CHANNEL_EMAIL_TITLE, COL_CHANNEL_EMAIL_CONTENT, COL_SCHEDULE_START_DATE, COL_SCHEDULE_END_DATE, COL_H2H_DATASOURCE_ID, COL_H2H_DATASET_ID, COL_ENTITY_SUB_TYPE_CODE, COL_SOURCE_REF_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_CRON_OBJ);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEDULE_TYPE, SUBSCRIPTION_NAME, OWNER_ORG_TYPE_CODE, OWNER_ORG_CODE, SUBSCRIBER_ORG_TYPE_CODE, SUBSCRIBER_ORG_CODE, CRON_EXPRESSION, SCHEDULE_CHANNEL_CODE, ALERT_TEMPLATE_ID, EXTERNAL_EMAIL, CHANNEL_EMAIL_TITLE, CHANNEL_EMAIL_CONTENT, SCHEDULE_START_DATE, SCHEDULE_END_DATE, H2H_DATASOURCE_ID, H2H_DATASET_ID, ENTITY_SUB_TYPE_CODE, SOURCE_REF_ID, VERSION_ID, IS_MASTER_VERSION, CRON_OBJ", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEDULE_TYPE, SUBSCRIPTION_NAME, OWNER_ORG_TYPE_CODE, OWNER_ORG_CODE, SUBSCRIBER_ORG_TYPE_CODE, SUBSCRIBER_ORG_CODE, CRON_EXPRESSION, SCHEDULE_CHANNEL_CODE, ALERT_TEMPLATE_ID, EXTERNAL_EMAIL, CHANNEL_EMAIL_TITLE, CHANNEL_EMAIL_CONTENT, SCHEDULE_START_DATE, SCHEDULE_END_DATE, H2H_DATASOURCE_ID, H2H_DATASET_ID, ENTITY_SUB_TYPE_CODE, SOURCE_REF_ID, VERSION_ID, IS_MASTER_VERSION, CRON_OBJ", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEDULE_TYPE, COL_SUBSCRIPTION_NAME, COL_OWNER_ORG_TYPE_CODE, COL_OWNER_ORG_CODE, COL_SUBSCRIBER_ORG_TYPE_CODE, COL_SUBSCRIBER_ORG_CODE, COL_CRON_EXPRESSION, COL_SCHEDULE_CHANNEL_CODE, COL_ALERT_TEMPLATE_ID, COL_EXTERNAL_EMAIL, COL_CHANNEL_EMAIL_TITLE, COL_CHANNEL_EMAIL_CONTENT, COL_SCHEDULE_START_DATE, COL_SCHEDULE_END_DATE, COL_H2H_DATASOURCE_ID, COL_H2H_DATASET_ID, COL_ENTITY_SUB_TYPE_CODE, COL_SOURCE_REF_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_CRON_OBJ, COL_ID);

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

    public int insert(Connection conn, FgSdkScheduleRule fgsdkschedulerule) throws SQLException {
        logger.debug("Inserting fgsdkschedulerule: {}", fgsdkschedulerule);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkScheduleRuleParams(ps, fgsdkschedulerule);
            ps.executeUpdate();
            return fgsdkschedulerule.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkScheduleRule> fgsdkschedulerules) throws SQLException {
        if (fgsdkschedulerules == null || fgsdkschedulerules.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkschedulerules.size(); i++) {
            if (fgsdkschedulerules.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkScheduleRule>> batches = chunkList(fgsdkschedulerules, batchSize);
        int[] totalResults = new int[fgsdkschedulerules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkScheduleRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkScheduleRule fgsdkschedulerule : batch) {
                        setFgSdkScheduleRuleParams(ps, fgsdkschedulerule);
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

    public FgSdkScheduleRule findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkScheduleRule> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkScheduleRule> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkScheduleRule fgsdkschedulerule) throws SQLException {
        if (fgsdkschedulerule.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkScheduleRuleParams(ps, fgsdkschedulerule);
            ps.setInt(39, fgsdkschedulerule.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkScheduleRule> fgsdkschedulerules) throws SQLException {
        if (fgsdkschedulerules == null || fgsdkschedulerules.isEmpty())
            return new int[0];
        for (FgSdkScheduleRule fgsdkschedulerule : fgsdkschedulerules) {
            if (fgsdkschedulerule == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkschedulerule.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkScheduleRule>> batches = chunkList(fgsdkschedulerules, batchSize);
        int[] totalResults = new int[fgsdkschedulerules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkScheduleRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkScheduleRule fgsdkschedulerule : batch) {
                        setFgSdkScheduleRuleParams(ps, fgsdkschedulerule);
                        ps.setInt(39, fgsdkschedulerule.getID());
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

    private void setFgSdkScheduleRuleParams(PreparedStatement ps, FgSdkScheduleRule fgsdkschedulerule) throws SQLException {
        Integer val1 = fgsdkschedulerule.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkschedulerule.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkschedulerule.getTypeCode());
        ps.setString(4, fgsdkschedulerule.getSubTypeCode());
        ps.setString(5, fgsdkschedulerule.getActiveCode());
        ps.setString(6, fgsdkschedulerule.getStageCode());
        ps.setString(7, fgsdkschedulerule.getStatusCode());
        Integer val8 = fgsdkschedulerule.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgsdkschedulerule.getCreatedOn());
        java.math.BigDecimal val10 = fgsdkschedulerule.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgsdkschedulerule.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgsdkschedulerule.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkschedulerule.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgsdkschedulerule.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkschedulerule.getTemplate());
        ps.setString(16, fgsdkschedulerule.getApplicantParty());
        ps.setString(17, fgsdkschedulerule.getFulfillmentParty());
        java.math.BigDecimal val18 = fgsdkschedulerule.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsdkschedulerule.getScheduleType());
        ps.setString(20, fgsdkschedulerule.getSubscriptionName());
        ps.setString(21, fgsdkschedulerule.getOwnerOrgTypeCode());
        ps.setString(22, fgsdkschedulerule.getOwnerOrgCode());
        ps.setString(23, fgsdkschedulerule.getSubscriberOrgTypeCode());
        ps.setString(24, fgsdkschedulerule.getSubscriberOrgCode());
        ps.setString(25, fgsdkschedulerule.getCronExpression());
        ps.setString(26, fgsdkschedulerule.getScheduleChannelCode());
        Integer val27 = fgsdkschedulerule.getAlertTemplateID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgsdkschedulerule.getExternalEmail());
        ps.setString(29, fgsdkschedulerule.getChannelEmailTitle());
        ps.setString(30, fgsdkschedulerule.getChannelEmailContent());
        ps.setString(31, fgsdkschedulerule.getScheduleStartDate());
        ps.setString(32, fgsdkschedulerule.getScheduleEndDate());
        Integer val33 = fgsdkschedulerule.getH2hDatasourceID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        Integer val34 = fgsdkschedulerule.getH2hDatasetID();
        if (val34 != null) {
            ps.setInt(34, val34);
        } else {
            ps.setNull(34, Types.INTEGER);
        }
        ps.setString(35, fgsdkschedulerule.getEntitySubTypeCode());
        Integer val36 = fgsdkschedulerule.getSourceRefID();
        if (val36 != null) {
            ps.setInt(36, val36);
        } else {
            ps.setNull(36, Types.INTEGER);
        }
        Integer val37 = fgsdkschedulerule.getVersionID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        java.math.BigDecimal val38 = fgsdkschedulerule.getIsMasterVersion();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgsdkschedulerule.getCronObj());
    }

    private FgSdkScheduleRule extract(ResultSet rs) throws SQLException {
        FgSdkScheduleRule fgsdkschedulerule = new FgSdkScheduleRule();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkschedulerule.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkschedulerule.setReferenceID(REFERENCE_ID);
        fgsdkschedulerule.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkschedulerule.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkschedulerule.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkschedulerule.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkschedulerule.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgsdkschedulerule.setProcessID(PROCESS_ID);
        fgsdkschedulerule.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkschedulerule.setCreatedBy(CREATED_BY);
        fgsdkschedulerule.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkschedulerule.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkschedulerule.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkschedulerule.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkschedulerule.setTemplate(rs.getString(COL_TEMPLATE));
        fgsdkschedulerule.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgsdkschedulerule.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkschedulerule.setIsTemplate(IS_TEMPLATE);
        fgsdkschedulerule.setScheduleType(rs.getString(COL_SCHEDULE_TYPE));
        fgsdkschedulerule.setSubscriptionName(rs.getString(COL_SUBSCRIPTION_NAME));
        fgsdkschedulerule.setOwnerOrgTypeCode(rs.getString(COL_OWNER_ORG_TYPE_CODE));
        fgsdkschedulerule.setOwnerOrgCode(rs.getString(COL_OWNER_ORG_CODE));
        fgsdkschedulerule.setSubscriberOrgTypeCode(rs.getString(COL_SUBSCRIBER_ORG_TYPE_CODE));
        fgsdkschedulerule.setSubscriberOrgCode(rs.getString(COL_SUBSCRIBER_ORG_CODE));
        fgsdkschedulerule.setCronExpression(rs.getString(COL_CRON_EXPRESSION));
        fgsdkschedulerule.setScheduleChannelCode(rs.getString(COL_SCHEDULE_CHANNEL_CODE));
        Integer ALERT_TEMPLATE_ID = rs.getObject(COL_ALERT_TEMPLATE_ID, Integer.class);
        fgsdkschedulerule.setAlertTemplateID(ALERT_TEMPLATE_ID);
        fgsdkschedulerule.setExternalEmail(rs.getString(COL_EXTERNAL_EMAIL));
        fgsdkschedulerule.setChannelEmailTitle(rs.getString(COL_CHANNEL_EMAIL_TITLE));
        fgsdkschedulerule.setChannelEmailContent(rs.getString(COL_CHANNEL_EMAIL_CONTENT));
        fgsdkschedulerule.setScheduleStartDate(rs.getString(COL_SCHEDULE_START_DATE));
        fgsdkschedulerule.setScheduleEndDate(rs.getString(COL_SCHEDULE_END_DATE));
        Integer H2H_DATASOURCE_ID = rs.getObject(COL_H2H_DATASOURCE_ID, Integer.class);
        fgsdkschedulerule.setH2hDatasourceID(H2H_DATASOURCE_ID);
        Integer H2H_DATASET_ID = rs.getObject(COL_H2H_DATASET_ID, Integer.class);
        fgsdkschedulerule.setH2hDatasetID(H2H_DATASET_ID);
        fgsdkschedulerule.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer SOURCE_REF_ID = rs.getObject(COL_SOURCE_REF_ID, Integer.class);
        fgsdkschedulerule.setSourceRefID(SOURCE_REF_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgsdkschedulerule.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgsdkschedulerule.setIsMasterVersion(IS_MASTER_VERSION);
        fgsdkschedulerule.setCronObj(rs.getString(COL_CRON_OBJ));
        return fgsdkschedulerule;
    }
}
