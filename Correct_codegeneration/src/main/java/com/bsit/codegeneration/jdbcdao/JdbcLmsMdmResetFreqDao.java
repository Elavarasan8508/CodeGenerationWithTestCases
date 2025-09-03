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

public class JdbcLmsMdmResetFreqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmResetFreqDao.class);

    private static final String TABLE = "LMS_MDM_RESET_FREQ";

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

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String COL_PARENT_ID = "PARENT_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_TENOR_START_SLAB = "TENOR_START_SLAB";

    private static final String COL_TENOR_END_SLAB = "TENOR_END_SLAB";

    private static final String COL_MIN_TENOR_UOM_CODE = "MIN_TENOR_UOM_CODE";

    private static final String COL_TENOR_SLAB_RULE_EXPRESSION = "TENOR_SLAB_RULE_EXPRESSION";

    private static final String COL_RESET_VALUE = "RESET_VALUE";

    private static final String COL_RESET_PERIOD_UOM_CODE = "RESET_PERIOD_UOM_CODE";

    private static final String COL_RESET_DESCRIPTION = "RESET_DESCRIPTION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_RESET_STATUS_CODE = "RESET_STATUS_CODE";

    private static final String COL_RULE_TYPE = "RULE_TYPE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_MAX_TENOR_UOM_CODE = "MAX_TENOR_UOM_CODE";

    private static final String COL_SEGMENT_TEAMS = "SEGMENT_TEAMS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_MIN_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_RESET_VALUE, COL_RESET_PERIOD_UOM_CODE, COL_RESET_DESCRIPTION, COL_UPLOAD_REF_ID, COL_RESET_STATUS_CODE, COL_RULE_TYPE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_MAX_TENOR_UOM_CODE, COL_SEGMENT_TEAMS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, MIN_TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RESET_VALUE, RESET_PERIOD_UOM_CODE, RESET_DESCRIPTION, UPLOAD_REF_ID, RESET_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, MAX_TENOR_UOM_CODE, SEGMENT_TEAMS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, MIN_TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RESET_VALUE, RESET_PERIOD_UOM_CODE, RESET_DESCRIPTION, UPLOAD_REF_ID, RESET_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, MAX_TENOR_UOM_CODE, SEGMENT_TEAMS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_MIN_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_RESET_VALUE, COL_RESET_PERIOD_UOM_CODE, COL_RESET_DESCRIPTION, COL_UPLOAD_REF_ID, COL_RESET_STATUS_CODE, COL_RULE_TYPE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_MAX_TENOR_UOM_CODE, COL_SEGMENT_TEAMS, COL_ID);

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

    public int insert(Connection conn, LmsMdmResetFreq lmsmdmresetfreq) throws SQLException {
        logger.debug("Inserting lmsmdmresetfreq: {}", lmsmdmresetfreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmResetFreqParams(ps, lmsmdmresetfreq);
            ps.executeUpdate();
            return lmsmdmresetfreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmResetFreq> lmsmdmresetfreqs) throws SQLException {
        if (lmsmdmresetfreqs == null || lmsmdmresetfreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmresetfreqs.size(); i++) {
            if (lmsmdmresetfreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmResetFreq>> batches = chunkList(lmsmdmresetfreqs, batchSize);
        int[] totalResults = new int[lmsmdmresetfreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmResetFreq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmResetFreq lmsmdmresetfreq : batch) {
                        setLmsMdmResetFreqParams(ps, lmsmdmresetfreq);
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

    public LmsMdmResetFreq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmResetFreq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmResetFreq> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmResetFreq lmsmdmresetfreq) throws SQLException {
        if (lmsmdmresetfreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmResetFreqParams(ps, lmsmdmresetfreq);
            ps.setInt(37, lmsmdmresetfreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmResetFreq> lmsmdmresetfreqs) throws SQLException {
        if (lmsmdmresetfreqs == null || lmsmdmresetfreqs.isEmpty())
            return new int[0];
        for (LmsMdmResetFreq lmsmdmresetfreq : lmsmdmresetfreqs) {
            if (lmsmdmresetfreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmresetfreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmResetFreq>> batches = chunkList(lmsmdmresetfreqs, batchSize);
        int[] totalResults = new int[lmsmdmresetfreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmResetFreq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmResetFreq lmsmdmresetfreq : batch) {
                        setLmsMdmResetFreqParams(ps, lmsmdmresetfreq);
                        ps.setInt(37, lmsmdmresetfreq.getID());
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

    private void setLmsMdmResetFreqParams(PreparedStatement ps, LmsMdmResetFreq lmsmdmresetfreq) throws SQLException {
        Integer val1 = lmsmdmresetfreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmresetfreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmresetfreq.getTypeCode());
        ps.setString(4, lmsmdmresetfreq.getSubTypeCode());
        ps.setString(5, lmsmdmresetfreq.getActiveCode());
        ps.setString(6, lmsmdmresetfreq.getStageCode());
        ps.setString(7, lmsmdmresetfreq.getStatusCode());
        Integer val8 = lmsmdmresetfreq.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmresetfreq.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmresetfreq.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmresetfreq.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmresetfreq.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmresetfreq.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmresetfreq.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmresetfreq.getTemplate());
        ps.setString(16, lmsmdmresetfreq.getApplicantParty());
        ps.setString(17, lmsmdmresetfreq.getFulfillmentParty());
        Integer val18 = lmsmdmresetfreq.getAttachmentID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = lmsmdmresetfreq.getParentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = lmsmdmresetfreq.getParentRefID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = lmsmdmresetfreq.getParentVersionID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.math.BigDecimal val22 = lmsmdmresetfreq.getIsTemplate();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = lmsmdmresetfreq.getTenorStartSlab();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = lmsmdmresetfreq.getTenorEndSlab();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, lmsmdmresetfreq.getMinTenorUomCode());
        ps.setString(26, lmsmdmresetfreq.getTenorSlabRuleExpression());
        java.math.BigDecimal val27 = lmsmdmresetfreq.getResetValue();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, lmsmdmresetfreq.getResetPeriodUomCode());
        ps.setString(29, lmsmdmresetfreq.getResetDescription());
        Integer val30 = lmsmdmresetfreq.getUploadRefID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        ps.setString(31, lmsmdmresetfreq.getResetStatusCode());
        ps.setString(32, lmsmdmresetfreq.getRuleType());
        ps.setString(33, lmsmdmresetfreq.getSegmentCode());
        ps.setString(34, lmsmdmresetfreq.getProductCode());
        ps.setString(35, lmsmdmresetfreq.getSubProductCode());
        ps.setString(36, lmsmdmresetfreq.getMaxTenorUomCode());
        ps.setString(37, lmsmdmresetfreq.getSegmentTeams());
    }

    private LmsMdmResetFreq extract(ResultSet rs) throws SQLException {
        LmsMdmResetFreq lmsmdmresetfreq = new LmsMdmResetFreq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmresetfreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmresetfreq.setReferenceID(REFERENCE_ID);
        lmsmdmresetfreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmresetfreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmresetfreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmresetfreq.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmresetfreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmresetfreq.setProcessID(PROCESS_ID);
        lmsmdmresetfreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmresetfreq.setCreatedBy(CREATED_BY);
        lmsmdmresetfreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmresetfreq.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmresetfreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmresetfreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmresetfreq.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmresetfreq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmresetfreq.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        lmsmdmresetfreq.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        lmsmdmresetfreq.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        lmsmdmresetfreq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        lmsmdmresetfreq.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmresetfreq.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal TENOR_START_SLAB = rs.getObject(COL_TENOR_START_SLAB, java.math.BigDecimal.class);
        lmsmdmresetfreq.setTenorStartSlab(TENOR_START_SLAB);
        java.math.BigDecimal TENOR_END_SLAB = rs.getObject(COL_TENOR_END_SLAB, java.math.BigDecimal.class);
        lmsmdmresetfreq.setTenorEndSlab(TENOR_END_SLAB);
        lmsmdmresetfreq.setMinTenorUomCode(rs.getString(COL_MIN_TENOR_UOM_CODE));
        lmsmdmresetfreq.setTenorSlabRuleExpression(rs.getString(COL_TENOR_SLAB_RULE_EXPRESSION));
        java.math.BigDecimal RESET_VALUE = rs.getObject(COL_RESET_VALUE, java.math.BigDecimal.class);
        lmsmdmresetfreq.setResetValue(RESET_VALUE);
        lmsmdmresetfreq.setResetPeriodUomCode(rs.getString(COL_RESET_PERIOD_UOM_CODE));
        lmsmdmresetfreq.setResetDescription(rs.getString(COL_RESET_DESCRIPTION));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        lmsmdmresetfreq.setUploadRefID(UPLOAD_REF_ID);
        lmsmdmresetfreq.setResetStatusCode(rs.getString(COL_RESET_STATUS_CODE));
        lmsmdmresetfreq.setRuleType(rs.getString(COL_RULE_TYPE));
        lmsmdmresetfreq.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        lmsmdmresetfreq.setProductCode(rs.getString(COL_PRODUCT_CODE));
        lmsmdmresetfreq.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        lmsmdmresetfreq.setMaxTenorUomCode(rs.getString(COL_MAX_TENOR_UOM_CODE));
        lmsmdmresetfreq.setSegmentTeams(rs.getString(COL_SEGMENT_TEAMS));
        return lmsmdmresetfreq;
    }
}
