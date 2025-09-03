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

public class JdbcFgSdkProvisioningTemplateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkProvisioningTemplateDao.class);

    private static final String TABLE = "FG_SDK_PROVISIONING_TEMPLATE";

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

    private static final String COL_TEMPLATE_NAME = "TEMPLATE_NAME";

    private static final String COL_TEMPLATE_CODE = "TEMPLATE_CODE";

    private static final String COL_TEMPLATE_DESCRIPTION = "TEMPLATE_DESCRIPTION";

    private static final String COL_TEMPLATE_TYPE = "TEMPLATE_TYPE";

    private static final String COL_RULE_TEMPLATE = "RULE_TEMPLATE";

    private static final String COL_MODEL_SUBTYPE_CODE = "MODEL_SUBTYPE_CODE";

    private static final String COL_ACTION_TYPE = "ACTION_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TEMPLATE_NAME, COL_TEMPLATE_CODE, COL_TEMPLATE_DESCRIPTION, COL_TEMPLATE_TYPE, COL_RULE_TEMPLATE, COL_MODEL_SUBTYPE_CODE, COL_ACTION_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE_NAME, TEMPLATE_CODE, TEMPLATE_DESCRIPTION, TEMPLATE_TYPE, RULE_TEMPLATE, MODEL_SUBTYPE_CODE, ACTION_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE_NAME, TEMPLATE_CODE, TEMPLATE_DESCRIPTION, TEMPLATE_TYPE, RULE_TEMPLATE, MODEL_SUBTYPE_CODE, ACTION_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TEMPLATE_NAME, COL_TEMPLATE_CODE, COL_TEMPLATE_DESCRIPTION, COL_TEMPLATE_TYPE, COL_RULE_TEMPLATE, COL_MODEL_SUBTYPE_CODE, COL_ACTION_TYPE, COL_ID);

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

    public int insert(Connection conn, FgSdkProvisioningTemplate fgsdkprovisioningtemplate) throws SQLException {
        logger.debug("Inserting fgsdkprovisioningtemplate: {}", fgsdkprovisioningtemplate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkProvisioningTemplateParams(ps, fgsdkprovisioningtemplate);
            ps.executeUpdate();
            return fgsdkprovisioningtemplate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkProvisioningTemplate> fgsdkprovisioningtemplates) throws SQLException {
        if (fgsdkprovisioningtemplates == null || fgsdkprovisioningtemplates.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkprovisioningtemplates.size(); i++) {
            if (fgsdkprovisioningtemplates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkProvisioningTemplate>> batches = chunkList(fgsdkprovisioningtemplates, batchSize);
        int[] totalResults = new int[fgsdkprovisioningtemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkProvisioningTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkProvisioningTemplate fgsdkprovisioningtemplate : batch) {
                        setFgSdkProvisioningTemplateParams(ps, fgsdkprovisioningtemplate);
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

    public FgSdkProvisioningTemplate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkProvisioningTemplate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkProvisioningTemplate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkProvisioningTemplate fgsdkprovisioningtemplate) throws SQLException {
        if (fgsdkprovisioningtemplate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkProvisioningTemplateParams(ps, fgsdkprovisioningtemplate);
            ps.setInt(30, fgsdkprovisioningtemplate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkProvisioningTemplate> fgsdkprovisioningtemplates) throws SQLException {
        if (fgsdkprovisioningtemplates == null || fgsdkprovisioningtemplates.isEmpty())
            return new int[0];
        for (FgSdkProvisioningTemplate fgsdkprovisioningtemplate : fgsdkprovisioningtemplates) {
            if (fgsdkprovisioningtemplate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkprovisioningtemplate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkProvisioningTemplate>> batches = chunkList(fgsdkprovisioningtemplates, batchSize);
        int[] totalResults = new int[fgsdkprovisioningtemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkProvisioningTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkProvisioningTemplate fgsdkprovisioningtemplate : batch) {
                        setFgSdkProvisioningTemplateParams(ps, fgsdkprovisioningtemplate);
                        ps.setInt(30, fgsdkprovisioningtemplate.getID());
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

    private void setFgSdkProvisioningTemplateParams(PreparedStatement ps, FgSdkProvisioningTemplate fgsdkprovisioningtemplate) throws SQLException {
        Integer val1 = fgsdkprovisioningtemplate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkprovisioningtemplate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkprovisioningtemplate.getTypeCode());
        ps.setString(4, fgsdkprovisioningtemplate.getSubTypeCode());
        ps.setString(5, fgsdkprovisioningtemplate.getActiveCode());
        ps.setString(6, fgsdkprovisioningtemplate.getStageCode());
        ps.setString(7, fgsdkprovisioningtemplate.getStatusCode());
        Integer val8 = fgsdkprovisioningtemplate.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgsdkprovisioningtemplate.getCreatedOn());
        java.math.BigDecimal val10 = fgsdkprovisioningtemplate.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgsdkprovisioningtemplate.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgsdkprovisioningtemplate.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkprovisioningtemplate.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgsdkprovisioningtemplate.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkprovisioningtemplate.getTemplate());
        ps.setString(16, fgsdkprovisioningtemplate.getApplicantParty());
        ps.setString(17, fgsdkprovisioningtemplate.getFulfillmentParty());
        Integer val18 = fgsdkprovisioningtemplate.getUploadRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = fgsdkprovisioningtemplate.getAttachmentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgsdkprovisioningtemplate.getParentID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = fgsdkprovisioningtemplate.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgsdkprovisioningtemplate.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fgsdkprovisioningtemplate.getIsTemplate();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgsdkprovisioningtemplate.getTemplateName());
        ps.setString(25, fgsdkprovisioningtemplate.getTemplateCode());
        ps.setString(26, fgsdkprovisioningtemplate.getTemplateDescription());
        ps.setString(27, fgsdkprovisioningtemplate.getTemplateType());
        ps.setString(28, fgsdkprovisioningtemplate.getRuleTemplate());
        ps.setString(29, fgsdkprovisioningtemplate.getModelSubtypeCode());
        ps.setString(30, fgsdkprovisioningtemplate.getActionType());
    }

    private FgSdkProvisioningTemplate extract(ResultSet rs) throws SQLException {
        FgSdkProvisioningTemplate fgsdkprovisioningtemplate = new FgSdkProvisioningTemplate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkprovisioningtemplate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkprovisioningtemplate.setReferenceID(REFERENCE_ID);
        fgsdkprovisioningtemplate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkprovisioningtemplate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkprovisioningtemplate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkprovisioningtemplate.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkprovisioningtemplate.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgsdkprovisioningtemplate.setProcessID(PROCESS_ID);
        fgsdkprovisioningtemplate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkprovisioningtemplate.setCreatedBy(CREATED_BY);
        fgsdkprovisioningtemplate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkprovisioningtemplate.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkprovisioningtemplate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkprovisioningtemplate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkprovisioningtemplate.setTemplate(rs.getString(COL_TEMPLATE));
        fgsdkprovisioningtemplate.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgsdkprovisioningtemplate.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgsdkprovisioningtemplate.setUploadRefID(UPLOAD_REF_ID);
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgsdkprovisioningtemplate.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        fgsdkprovisioningtemplate.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgsdkprovisioningtemplate.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgsdkprovisioningtemplate.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkprovisioningtemplate.setIsTemplate(IS_TEMPLATE);
        fgsdkprovisioningtemplate.setTemplateName(rs.getString(COL_TEMPLATE_NAME));
        fgsdkprovisioningtemplate.setTemplateCode(rs.getString(COL_TEMPLATE_CODE));
        fgsdkprovisioningtemplate.setTemplateDescription(rs.getString(COL_TEMPLATE_DESCRIPTION));
        fgsdkprovisioningtemplate.setTemplateType(rs.getString(COL_TEMPLATE_TYPE));
        fgsdkprovisioningtemplate.setRuleTemplate(rs.getString(COL_RULE_TEMPLATE));
        fgsdkprovisioningtemplate.setModelSubtypeCode(rs.getString(COL_MODEL_SUBTYPE_CODE));
        fgsdkprovisioningtemplate.setActionType(rs.getString(COL_ACTION_TYPE));
        return fgsdkprovisioningtemplate;
    }
}
