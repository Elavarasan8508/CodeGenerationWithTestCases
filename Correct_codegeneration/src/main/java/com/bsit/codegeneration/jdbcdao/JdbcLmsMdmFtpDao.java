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

public class JdbcLmsMdmFtpDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmFtpDao.class);

    private static final String TABLE = "LMS_MDM_FTP";

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

    private static final String COL_TENOR_UOM_CODE = "TENOR_UOM_CODE";

    private static final String COL_TENOR_SLAB_RULE_EXPRESSION = "TENOR_SLAB_RULE_EXPRESSION";

    private static final String COL_RATE_OF_INTEREST = "RATE_OF_INTEREST";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FTP_STATUS_CODE = "FTP_STATUS_CODE";

    private static final String COL_RULE_TYPE = "RULE_TYPE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_EFFECTIVE_START_DATE = "EFFECTIVE_START_DATE";

    private static final String COL_EFFECTIVE_END_DATE = "EFFECTIVE_END_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_RATE_OF_INTEREST, COL_UPLOAD_REF_ID, COL_FTP_STATUS_CODE, COL_RULE_TYPE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_EFFECTIVE_START_DATE, COL_EFFECTIVE_END_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RATE_OF_INTEREST, UPLOAD_REF_ID, FTP_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, EFFECTIVE_START_DATE, EFFECTIVE_END_DATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RATE_OF_INTEREST, UPLOAD_REF_ID, FTP_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, EFFECTIVE_START_DATE, EFFECTIVE_END_DATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TENOR_START_SLAB, COL_TENOR_END_SLAB, COL_TENOR_UOM_CODE, COL_TENOR_SLAB_RULE_EXPRESSION, COL_RATE_OF_INTEREST, COL_UPLOAD_REF_ID, COL_FTP_STATUS_CODE, COL_RULE_TYPE, COL_SEGMENT_CODE, COL_PRODUCT_CODE, COL_SUB_PRODUCT_CODE, COL_EFFECTIVE_START_DATE, COL_EFFECTIVE_END_DATE, COL_ID);

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

    public int insert(Connection conn, LmsMdmFtp lmsmdmftp) throws SQLException {
        logger.debug("Inserting lmsmdmftp: {}", lmsmdmftp);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmFtpParams(ps, lmsmdmftp);
            ps.executeUpdate();
            return lmsmdmftp.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmFtp> lmsmdmftps) throws SQLException {
        if (lmsmdmftps == null || lmsmdmftps.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmftps.size(); i++) {
            if (lmsmdmftps.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmFtp>> batches = chunkList(lmsmdmftps, batchSize);
        int[] totalResults = new int[lmsmdmftps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmFtp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmFtp lmsmdmftp : batch) {
                        setLmsMdmFtpParams(ps, lmsmdmftp);
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

    public LmsMdmFtp findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmFtp> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmFtp> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmFtp lmsmdmftp) throws SQLException {
        if (lmsmdmftp.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmFtpParams(ps, lmsmdmftp);
            ps.setInt(35, lmsmdmftp.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmFtp> lmsmdmftps) throws SQLException {
        if (lmsmdmftps == null || lmsmdmftps.isEmpty())
            return new int[0];
        for (LmsMdmFtp lmsmdmftp : lmsmdmftps) {
            if (lmsmdmftp == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmftp.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmFtp>> batches = chunkList(lmsmdmftps, batchSize);
        int[] totalResults = new int[lmsmdmftps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmFtp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmFtp lmsmdmftp : batch) {
                        setLmsMdmFtpParams(ps, lmsmdmftp);
                        ps.setInt(35, lmsmdmftp.getID());
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

    private void setLmsMdmFtpParams(PreparedStatement ps, LmsMdmFtp lmsmdmftp) throws SQLException {
        Integer val1 = lmsmdmftp.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmftp.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmftp.getTypeCode());
        ps.setString(4, lmsmdmftp.getSubTypeCode());
        ps.setString(5, lmsmdmftp.getActiveCode());
        ps.setString(6, lmsmdmftp.getStageCode());
        ps.setString(7, lmsmdmftp.getStatusCode());
        Integer val8 = lmsmdmftp.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmftp.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmftp.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmftp.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmftp.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmftp.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmftp.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmftp.getTemplate());
        ps.setString(16, lmsmdmftp.getApplicantParty());
        ps.setString(17, lmsmdmftp.getFulfillmentParty());
        Integer val18 = lmsmdmftp.getAttachmentID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = lmsmdmftp.getParentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = lmsmdmftp.getParentRefID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = lmsmdmftp.getParentVersionID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.math.BigDecimal val22 = lmsmdmftp.getIsTemplate();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = lmsmdmftp.getTenorStartSlab();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = lmsmdmftp.getTenorEndSlab();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, lmsmdmftp.getTenorUomCode());
        ps.setString(26, lmsmdmftp.getTenorSlabRuleExpression());
        java.math.BigDecimal val27 = lmsmdmftp.getRateOfInterest();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        Integer val28 = lmsmdmftp.getUploadRefID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        ps.setString(29, lmsmdmftp.getFtpStatusCode());
        ps.setString(30, lmsmdmftp.getRuleType());
        ps.setString(31, lmsmdmftp.getSegmentCode());
        ps.setString(32, lmsmdmftp.getProductCode());
        ps.setString(33, lmsmdmftp.getSubProductCode());
        java.time.LocalDateTime val34 = lmsmdmftp.getEffectiveStartDate();
        if (val34 != null) {
            ps.setTimestamp(34, java.sql.Timestamp.valueOf(val34));
        } else {
            ps.setNull(34, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val35 = lmsmdmftp.getEffectiveEndDate();
        if (val35 != null) {
            ps.setTimestamp(35, java.sql.Timestamp.valueOf(val35));
        } else {
            ps.setNull(35, Types.TIMESTAMP);
        }
    }

    private LmsMdmFtp extract(ResultSet rs) throws SQLException {
        LmsMdmFtp lmsmdmftp = new LmsMdmFtp();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmftp.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmftp.setReferenceID(REFERENCE_ID);
        lmsmdmftp.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmftp.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmftp.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmftp.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmftp.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmftp.setProcessID(PROCESS_ID);
        lmsmdmftp.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmftp.setCreatedBy(CREATED_BY);
        lmsmdmftp.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmftp.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmftp.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmftp.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmftp.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmftp.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmftp.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        lmsmdmftp.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        lmsmdmftp.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        lmsmdmftp.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        lmsmdmftp.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmftp.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal TENOR_START_SLAB = rs.getObject(COL_TENOR_START_SLAB, java.math.BigDecimal.class);
        lmsmdmftp.setTenorStartSlab(TENOR_START_SLAB);
        java.math.BigDecimal TENOR_END_SLAB = rs.getObject(COL_TENOR_END_SLAB, java.math.BigDecimal.class);
        lmsmdmftp.setTenorEndSlab(TENOR_END_SLAB);
        lmsmdmftp.setTenorUomCode(rs.getString(COL_TENOR_UOM_CODE));
        lmsmdmftp.setTenorSlabRuleExpression(rs.getString(COL_TENOR_SLAB_RULE_EXPRESSION));
        java.math.BigDecimal RATE_OF_INTEREST = rs.getObject(COL_RATE_OF_INTEREST, java.math.BigDecimal.class);
        lmsmdmftp.setRateOfInterest(RATE_OF_INTEREST);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        lmsmdmftp.setUploadRefID(UPLOAD_REF_ID);
        lmsmdmftp.setFtpStatusCode(rs.getString(COL_FTP_STATUS_CODE));
        lmsmdmftp.setRuleType(rs.getString(COL_RULE_TYPE));
        lmsmdmftp.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        lmsmdmftp.setProductCode(rs.getString(COL_PRODUCT_CODE));
        lmsmdmftp.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        Timestamp EFFECTIVE_START_DATE = rs.getTimestamp(COL_EFFECTIVE_START_DATE);
        if (EFFECTIVE_START_DATE != null)
            lmsmdmftp.setEffectiveStartDate(EFFECTIVE_START_DATE.toLocalDateTime());
        Timestamp EFFECTIVE_END_DATE = rs.getTimestamp(COL_EFFECTIVE_END_DATE);
        if (EFFECTIVE_END_DATE != null)
            lmsmdmftp.setEffectiveEndDate(EFFECTIVE_END_DATE.toLocalDateTime());
        return lmsmdmftp;
    }
}
