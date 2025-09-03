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

public class JdbcLmsMdmAlcoMinRateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmAlcoMinRateDao.class);

    private static final String TABLE = "LMS_MDM_ALCO_MIN_RATE";

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

    private static final String COL_TENOR_START_SLAB = "TENOR_START_SLAB";

    private static final String COL_TENOR_END_SLAB = "TENOR_END_SLAB";

    private static final String COL_TENOR_UOM_CODE = "TENOR_UOM_CODE";

    private static final String COL_TENOR_SLAB_RULE_EXPRESSION = "TENOR_SLAB_RULE_EXPRESSION";

    private static final String COL_BENCHMARK_CODE = "BENCHMARK_CODE";

    private static final String COL_RATE_OF_INTEREST = "RATE_OF_INTEREST";

    private static final String COL_ALCO_RATE_STATUS_CODE = "ALCO_RATE_STATUS_CODE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_RULE_TYPE_CODE = "RULE_TYPE_CODE";

    private static final String COL_RESET_PERIOD_UOM_CODE = "RESET_PERIOD_UOM_CODE";

    private static final String COL_RESET_VALUE = "RESET_VALUE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_BENCHMARK_CODE, COL_RATE_OF_INTEREST, COL_ALCO_RATE_STATUS_CODE, COL_RATE_TYPE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_RULE_TYPE_CODE, COL_RESET_PERIOD_UOM_CODE, COL_RESET_VALUE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, BENCHMARK_CODE, RATE_OF_INTEREST, ALCO_RATE_STATUS_CODE, RATE_TYPE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, RULE_TYPE_CODE, RESET_PERIOD_UOM_CODE, RESET_VALUE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, BENCHMARK_CODE, RATE_OF_INTEREST, ALCO_RATE_STATUS_CODE, RATE_TYPE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, RULE_TYPE_CODE, RESET_PERIOD_UOM_CODE, RESET_VALUE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_UPLOAD_REF_ID, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_BENCHMARK_CODE, COL_RATE_OF_INTEREST, COL_ALCO_RATE_STATUS_CODE, COL_RATE_TYPE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_RULE_TYPE_CODE, COL_RESET_PERIOD_UOM_CODE, COL_RESET_VALUE, COL_ID);

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

    public int insert(Connection conn, LmsMdmAlcoMinRate lmsmdmalcominrate) throws SQLException {
        logger.debug("Inserting lmsmdmalcominrate: {}", lmsmdmalcominrate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmAlcoMinRateParams(ps, lmsmdmalcominrate);
            ps.executeUpdate();
            return lmsmdmalcominrate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmAlcoMinRate> lmsmdmalcominrates) throws SQLException {
        if (lmsmdmalcominrates == null || lmsmdmalcominrates.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmalcominrates.size(); i++) {
            if (lmsmdmalcominrates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmAlcoMinRate>> batches = chunkList(lmsmdmalcominrates, batchSize);
        int[] totalResults = new int[lmsmdmalcominrates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmAlcoMinRate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmAlcoMinRate lmsmdmalcominrate : batch) {
                        setLmsMdmAlcoMinRateParams(ps, lmsmdmalcominrate);
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

    public LmsMdmAlcoMinRate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmAlcoMinRate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmAlcoMinRate> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmAlcoMinRate lmsmdmalcominrate) throws SQLException {
        if (lmsmdmalcominrate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmAlcoMinRateParams(ps, lmsmdmalcominrate);
            ps.setInt(37, lmsmdmalcominrate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmAlcoMinRate> lmsmdmalcominrates) throws SQLException {
        if (lmsmdmalcominrates == null || lmsmdmalcominrates.isEmpty())
            return new int[0];
        for (LmsMdmAlcoMinRate lmsmdmalcominrate : lmsmdmalcominrates) {
            if (lmsmdmalcominrate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmalcominrate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmAlcoMinRate>> batches = chunkList(lmsmdmalcominrates, batchSize);
        int[] totalResults = new int[lmsmdmalcominrates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmAlcoMinRate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmAlcoMinRate lmsmdmalcominrate : batch) {
                        setLmsMdmAlcoMinRateParams(ps, lmsmdmalcominrate);
                        ps.setInt(37, lmsmdmalcominrate.getID());
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

    private void setLmsMdmAlcoMinRateParams(PreparedStatement ps, LmsMdmAlcoMinRate lmsmdmalcominrate) throws SQLException {
        Integer val1 = lmsmdmalcominrate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmalcominrate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmalcominrate.getTypeCode());
        ps.setString(4, lmsmdmalcominrate.getSubTypeCode());
        ps.setString(5, lmsmdmalcominrate.getActiveCode());
        ps.setString(6, lmsmdmalcominrate.getStageCode());
        ps.setString(7, lmsmdmalcominrate.getStatusCode());
        Integer val8 = lmsmdmalcominrate.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmalcominrate.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmalcominrate.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmalcominrate.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmalcominrate.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmalcominrate.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmalcominrate.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmalcominrate.getTemplate());
        ps.setString(16, lmsmdmalcominrate.getApplicantParty());
        ps.setString(17, lmsmdmalcominrate.getFulfillmentParty());
        Integer val18 = lmsmdmalcominrate.getUploadRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = lmsmdmalcominrate.getAttachmentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = lmsmdmalcominrate.getParentID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = lmsmdmalcominrate.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = lmsmdmalcominrate.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = lmsmdmalcominrate.getIsTemplate();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = lmsmdmalcominrate.getTenorStartSlab();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = lmsmdmalcominrate.getTenorEndSlab();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, lmsmdmalcominrate.getTenorUomCode());
        ps.setString(27, lmsmdmalcominrate.getTenorSlabRuleExpression());
        ps.setString(28, lmsmdmalcominrate.getBenchmarkCode());
        java.math.BigDecimal val29 = lmsmdmalcominrate.getRateOfInterest();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = lmsmdmalcominrate.getAlcoRateStatusCode();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.math.BigDecimal val31 = lmsmdmalcominrate.getRateType();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, lmsmdmalcominrate.getProductCode());
        ps.setString(33, lmsmdmalcominrate.getSubProductCode());
        ps.setString(34, lmsmdmalcominrate.getSegmentCode());
        ps.setString(35, lmsmdmalcominrate.getRuleTypeCode());
        ps.setString(36, lmsmdmalcominrate.getResetPeriodUomCode());
        ps.setString(37, lmsmdmalcominrate.getResetValue());
    }

    private LmsMdmAlcoMinRate extract(ResultSet rs) throws SQLException {
        LmsMdmAlcoMinRate lmsmdmalcominrate = new LmsMdmAlcoMinRate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmalcominrate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmalcominrate.setReferenceID(REFERENCE_ID);
        lmsmdmalcominrate.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmalcominrate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmalcominrate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmalcominrate.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmalcominrate.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmalcominrate.setProcessID(PROCESS_ID);
        lmsmdmalcominrate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmalcominrate.setCreatedBy(CREATED_BY);
        lmsmdmalcominrate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmalcominrate.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmalcominrate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmalcominrate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmalcominrate.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmalcominrate.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmalcominrate.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        lmsmdmalcominrate.setUploadRefID(UPLOAD_REF_ID);
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        lmsmdmalcominrate.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        lmsmdmalcominrate.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        lmsmdmalcominrate.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        lmsmdmalcominrate.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmalcominrate.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal TENOR_START_SLAB = rs.getObject(COL_TENOR_START_SLAB, java.math.BigDecimal.class);
        lmsmdmalcominrate.setTenorStartSlab(TENOR_START_SLAB);
        java.math.BigDecimal TENOR_END_SLAB = rs.getObject(COL_TENOR_END_SLAB, java.math.BigDecimal.class);
        lmsmdmalcominrate.setTenorEndSlab(TENOR_END_SLAB);
        lmsmdmalcominrate.setTenorUomCode(rs.getString(COL_TENOR_UOM_CODE));
        lmsmdmalcominrate.setTenorSlabRuleExpression(rs.getString(COL_TENOR_SLAB_RULE_EXPRESSION));
        lmsmdmalcominrate.setBenchmarkCode(rs.getString(COL_BENCHMARK_CODE));
        java.math.BigDecimal RATE_OF_INTEREST = rs.getObject(COL_RATE_OF_INTEREST, java.math.BigDecimal.class);
        lmsmdmalcominrate.setRateOfInterest(RATE_OF_INTEREST);
        java.math.BigDecimal ALCO_RATE_STATUS_CODE = rs.getObject(COL_ALCO_RATE_STATUS_CODE, java.math.BigDecimal.class);
        lmsmdmalcominrate.setAlcoRateStatusCode(ALCO_RATE_STATUS_CODE);
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        lmsmdmalcominrate.setRateType(RATE_TYPE);
        lmsmdmalcominrate.setProductCode(rs.getString(COL_PRODUCT_CODE));
        lmsmdmalcominrate.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        lmsmdmalcominrate.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        lmsmdmalcominrate.setRuleTypeCode(rs.getString(COL_RULE_TYPE_CODE));
        lmsmdmalcominrate.setResetPeriodUomCode(rs.getString(COL_RESET_PERIOD_UOM_CODE));
        lmsmdmalcominrate.setResetValue(rs.getString(COL_RESET_VALUE));
        return lmsmdmalcominrate;
    }
}
