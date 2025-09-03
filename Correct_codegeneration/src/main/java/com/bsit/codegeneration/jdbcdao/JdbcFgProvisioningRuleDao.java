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

public class JdbcFgProvisioningRuleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProvisioningRuleDao.class);

    private static final String TABLE = "FG_PROVISIONING_RULE";

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

    private static final String COL_TARGET_ORG_TYPE = "TARGET_ORG_TYPE";

    private static final String COL_TARGET_ORG_PARTY_CODE = "TARGET_ORG_PARTY_CODE";

    private static final String COL_RULE_TYPE = "RULE_TYPE";

    private static final String COL_TARGET_ORG_ENTITY_CODE = "TARGET_ORG_ENTITY_CODE";

    private static final String COL_MODEL_SUBTYPE_CODE = "MODEL_SUBTYPE_CODE";

    private static final String COL_RULE_INHERITANCE_FLAG = "RULE_INHERITANCE_FLAG";

    private static final String COL_INHERITANCE_TARGET_SUBTYPE = "INHERITANCE_TARGET_SUBTYPE";

    private static final String COL_MOD_RULE_TEMPLATE = "MOD_RULE_TEMPLATE";

    private static final String COL_PROVISIONING_STATUS = "PROVISIONING_STATUS";

    private static final String COL_PROVISIONING_DATE = "PROVISIONING_DATE";

    private static final String COL_PROVISIONING_ERROR = "PROVISIONING_ERROR";

    private static final String COL_PROVISIOINING_REMARKS = "PROVISIOINING_REMARKS";

    private static final String COL_ACTION_CODE = "ACTION_CODE";

    private static final String COL_DEPLOYMENT_ID = "DEPLOYMENT_ID";

    private static final String COL_VERSION = "VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TARGET_ORG_TYPE, COL_TARGET_ORG_PARTY_CODE, COL_RULE_TYPE, COL_TARGET_ORG_ENTITY_CODE, COL_MODEL_SUBTYPE_CODE, COL_RULE_INHERITANCE_FLAG, COL_INHERITANCE_TARGET_SUBTYPE, COL_MOD_RULE_TEMPLATE, COL_PROVISIONING_STATUS, COL_PROVISIONING_DATE, COL_PROVISIONING_ERROR, COL_PROVISIOINING_REMARKS, COL_ACTION_CODE, COL_DEPLOYMENT_ID, COL_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TARGET_ORG_TYPE, TARGET_ORG_PARTY_CODE, RULE_TYPE, TARGET_ORG_ENTITY_CODE, MODEL_SUBTYPE_CODE, RULE_INHERITANCE_FLAG, INHERITANCE_TARGET_SUBTYPE, MOD_RULE_TEMPLATE, PROVISIONING_STATUS, PROVISIONING_DATE, PROVISIONING_ERROR, PROVISIOINING_REMARKS, ACTION_CODE, DEPLOYMENT_ID, VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TARGET_ORG_TYPE, TARGET_ORG_PARTY_CODE, RULE_TYPE, TARGET_ORG_ENTITY_CODE, MODEL_SUBTYPE_CODE, RULE_INHERITANCE_FLAG, INHERITANCE_TARGET_SUBTYPE, MOD_RULE_TEMPLATE, PROVISIONING_STATUS, PROVISIONING_DATE, PROVISIONING_ERROR, PROVISIOINING_REMARKS, ACTION_CODE, DEPLOYMENT_ID, VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TARGET_ORG_TYPE, COL_TARGET_ORG_PARTY_CODE, COL_RULE_TYPE, COL_TARGET_ORG_ENTITY_CODE, COL_MODEL_SUBTYPE_CODE, COL_RULE_INHERITANCE_FLAG, COL_INHERITANCE_TARGET_SUBTYPE, COL_MOD_RULE_TEMPLATE, COL_PROVISIONING_STATUS, COL_PROVISIONING_DATE, COL_PROVISIONING_ERROR, COL_PROVISIOINING_REMARKS, COL_ACTION_CODE, COL_DEPLOYMENT_ID, COL_VERSION, COL_ID);

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

    public int insert(Connection conn, FgProvisioningRule fgprovisioningrule) throws SQLException {
        logger.debug("Inserting fgprovisioningrule: {}", fgprovisioningrule);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProvisioningRuleParams(ps, fgprovisioningrule);
            ps.executeUpdate();
            return fgprovisioningrule.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProvisioningRule> fgprovisioningrules) throws SQLException {
        if (fgprovisioningrules == null || fgprovisioningrules.isEmpty())
            return new int[0];
        for (int i = 0; i < fgprovisioningrules.size(); i++) {
            if (fgprovisioningrules.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProvisioningRule>> batches = chunkList(fgprovisioningrules, batchSize);
        int[] totalResults = new int[fgprovisioningrules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProvisioningRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProvisioningRule fgprovisioningrule : batch) {
                        setFgProvisioningRuleParams(ps, fgprovisioningrule);
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

    public FgProvisioningRule findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProvisioningRule> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProvisioningRule> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProvisioningRule fgprovisioningrule) throws SQLException {
        if (fgprovisioningrule.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProvisioningRuleParams(ps, fgprovisioningrule);
            ps.setInt(38, fgprovisioningrule.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProvisioningRule> fgprovisioningrules) throws SQLException {
        if (fgprovisioningrules == null || fgprovisioningrules.isEmpty())
            return new int[0];
        for (FgProvisioningRule fgprovisioningrule : fgprovisioningrules) {
            if (fgprovisioningrule == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgprovisioningrule.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProvisioningRule>> batches = chunkList(fgprovisioningrules, batchSize);
        int[] totalResults = new int[fgprovisioningrules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProvisioningRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProvisioningRule fgprovisioningrule : batch) {
                        setFgProvisioningRuleParams(ps, fgprovisioningrule);
                        ps.setInt(38, fgprovisioningrule.getID());
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

    private void setFgProvisioningRuleParams(PreparedStatement ps, FgProvisioningRule fgprovisioningrule) throws SQLException {
        Integer val1 = fgprovisioningrule.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgprovisioningrule.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgprovisioningrule.getTypeCode());
        ps.setString(4, fgprovisioningrule.getSubTypeCode());
        ps.setString(5, fgprovisioningrule.getActiveCode());
        ps.setString(6, fgprovisioningrule.getStageCode());
        ps.setString(7, fgprovisioningrule.getStatusCode());
        Integer val8 = fgprovisioningrule.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgprovisioningrule.getCreatedOn());
        java.math.BigDecimal val10 = fgprovisioningrule.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgprovisioningrule.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgprovisioningrule.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgprovisioningrule.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgprovisioningrule.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgprovisioningrule.getTemplate());
        ps.setString(16, fgprovisioningrule.getApplicantParty());
        ps.setString(17, fgprovisioningrule.getFulfillmentParty());
        Integer val18 = fgprovisioningrule.getUploadRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = fgprovisioningrule.getAttachmentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgprovisioningrule.getParentID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = fgprovisioningrule.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgprovisioningrule.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fgprovisioningrule.getIsTemplate();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgprovisioningrule.getTargetOrgType());
        ps.setString(25, fgprovisioningrule.getTargetOrgPartyCode());
        ps.setString(26, fgprovisioningrule.getRuleType());
        ps.setString(27, fgprovisioningrule.getTargetOrgEntityCode());
        ps.setString(28, fgprovisioningrule.getModelSubtypeCode());
        ps.setString(29, fgprovisioningrule.getRuleInheritanceFlag());
        ps.setString(30, fgprovisioningrule.getInheritanceTargetSubtype());
        ps.setString(31, fgprovisioningrule.getModRuleTemplate());
        ps.setString(32, fgprovisioningrule.getProvisioningStatus());
        ps.setString(33, fgprovisioningrule.getProvisioningDate());
        ps.setString(34, fgprovisioningrule.getProvisioningError());
        ps.setString(35, fgprovisioningrule.getProvisioiningRemarks());
        ps.setString(36, fgprovisioningrule.getActionCode());
        Integer val37 = fgprovisioningrule.getDeploymentID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        ps.setString(38, fgprovisioningrule.getVersion());
    }

    private FgProvisioningRule extract(ResultSet rs) throws SQLException {
        FgProvisioningRule fgprovisioningrule = new FgProvisioningRule();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgprovisioningrule.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgprovisioningrule.setReferenceID(REFERENCE_ID);
        fgprovisioningrule.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgprovisioningrule.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgprovisioningrule.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgprovisioningrule.setStageCode(rs.getString(COL_STAGE_CODE));
        fgprovisioningrule.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgprovisioningrule.setProcessID(PROCESS_ID);
        fgprovisioningrule.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgprovisioningrule.setCreatedBy(CREATED_BY);
        fgprovisioningrule.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgprovisioningrule.setLastUpdatedBy(LAST_UPDATED_BY);
        fgprovisioningrule.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgprovisioningrule.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgprovisioningrule.setTemplate(rs.getString(COL_TEMPLATE));
        fgprovisioningrule.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgprovisioningrule.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgprovisioningrule.setUploadRefID(UPLOAD_REF_ID);
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgprovisioningrule.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        fgprovisioningrule.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgprovisioningrule.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgprovisioningrule.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgprovisioningrule.setIsTemplate(IS_TEMPLATE);
        fgprovisioningrule.setTargetOrgType(rs.getString(COL_TARGET_ORG_TYPE));
        fgprovisioningrule.setTargetOrgPartyCode(rs.getString(COL_TARGET_ORG_PARTY_CODE));
        fgprovisioningrule.setRuleType(rs.getString(COL_RULE_TYPE));
        fgprovisioningrule.setTargetOrgEntityCode(rs.getString(COL_TARGET_ORG_ENTITY_CODE));
        fgprovisioningrule.setModelSubtypeCode(rs.getString(COL_MODEL_SUBTYPE_CODE));
        fgprovisioningrule.setRuleInheritanceFlag(rs.getString(COL_RULE_INHERITANCE_FLAG));
        fgprovisioningrule.setInheritanceTargetSubtype(rs.getString(COL_INHERITANCE_TARGET_SUBTYPE));
        fgprovisioningrule.setModRuleTemplate(rs.getString(COL_MOD_RULE_TEMPLATE));
        fgprovisioningrule.setProvisioningStatus(rs.getString(COL_PROVISIONING_STATUS));
        fgprovisioningrule.setProvisioningDate(rs.getString(COL_PROVISIONING_DATE));
        fgprovisioningrule.setProvisioningError(rs.getString(COL_PROVISIONING_ERROR));
        fgprovisioningrule.setProvisioiningRemarks(rs.getString(COL_PROVISIOINING_REMARKS));
        fgprovisioningrule.setActionCode(rs.getString(COL_ACTION_CODE));
        Integer DEPLOYMENT_ID = rs.getObject(COL_DEPLOYMENT_ID, Integer.class);
        fgprovisioningrule.setDeploymentID(DEPLOYMENT_ID);
        fgprovisioningrule.setVersion(rs.getString(COL_VERSION));
        return fgprovisioningrule;
    }
}
