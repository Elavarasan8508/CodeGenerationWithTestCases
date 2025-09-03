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

public class JdbcCoreMdmProductSchemeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCoreMdmProductSchemeDao.class);

    private static final String TABLE = "CORE_MDM_PRODUCT_SCHEME";

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

    private static final String COL_SCHEME_TYPE = "SCHEME_TYPE";

    private static final String COL_SCHEME_NAME = "SCHEME_NAME";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_SCHEME_DESCRIPTION = "SCHEME_DESCRIPTION";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_EXPIRY_DATE = "EXPIRY_DATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_TYPE, COL_SCHEME_NAME, COL_SCHEME_CODE, COL_SCHEME_DESCRIPTION, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_UPLOAD_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_TYPE, SCHEME_NAME, SCHEME_CODE, SCHEME_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_TYPE, SCHEME_NAME, SCHEME_CODE, SCHEME_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_TYPE, COL_SCHEME_NAME, COL_SCHEME_CODE, COL_SCHEME_DESCRIPTION, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_UPLOAD_REF_ID, COL_ID);

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

    public int insert(Connection conn, CoreMdmProductScheme coremdmproductscheme) throws SQLException {
        logger.debug("Inserting coremdmproductscheme: {}", coremdmproductscheme);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCoreMdmProductSchemeParams(ps, coremdmproductscheme);
            ps.executeUpdate();
            return coremdmproductscheme.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CoreMdmProductScheme> coremdmproductschemes) throws SQLException {
        if (coremdmproductschemes == null || coremdmproductschemes.isEmpty())
            return new int[0];
        for (int i = 0; i < coremdmproductschemes.size(); i++) {
            if (coremdmproductschemes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmProductScheme>> batches = chunkList(coremdmproductschemes, batchSize);
        int[] totalResults = new int[coremdmproductschemes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmProductScheme> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CoreMdmProductScheme coremdmproductscheme : batch) {
                        setCoreMdmProductSchemeParams(ps, coremdmproductscheme);
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

    public CoreMdmProductScheme findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CoreMdmProductScheme> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CoreMdmProductScheme> list = new ArrayList<>();
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

    public boolean update(Connection conn, CoreMdmProductScheme coremdmproductscheme) throws SQLException {
        if (coremdmproductscheme.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCoreMdmProductSchemeParams(ps, coremdmproductscheme);
            ps.setInt(25, coremdmproductscheme.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CoreMdmProductScheme> coremdmproductschemes) throws SQLException {
        if (coremdmproductschemes == null || coremdmproductschemes.isEmpty())
            return new int[0];
        for (CoreMdmProductScheme coremdmproductscheme : coremdmproductschemes) {
            if (coremdmproductscheme == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (coremdmproductscheme.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmProductScheme>> batches = chunkList(coremdmproductschemes, batchSize);
        int[] totalResults = new int[coremdmproductschemes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmProductScheme> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CoreMdmProductScheme coremdmproductscheme : batch) {
                        setCoreMdmProductSchemeParams(ps, coremdmproductscheme);
                        ps.setInt(25, coremdmproductscheme.getID());
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

    private void setCoreMdmProductSchemeParams(PreparedStatement ps, CoreMdmProductScheme coremdmproductscheme) throws SQLException {
        Integer val1 = coremdmproductscheme.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = coremdmproductscheme.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, coremdmproductscheme.getTypeCode());
        ps.setString(4, coremdmproductscheme.getSubTypeCode());
        ps.setString(5, coremdmproductscheme.getActiveCode());
        ps.setString(6, coremdmproductscheme.getStageCode());
        ps.setString(7, coremdmproductscheme.getStatusCode());
        Integer val8 = coremdmproductscheme.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, coremdmproductscheme.getCreatedOn());
        java.math.BigDecimal val10 = coremdmproductscheme.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, coremdmproductscheme.getLastUpdatedOn());
        java.math.BigDecimal val12 = coremdmproductscheme.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, coremdmproductscheme.getLastAuthorisedOn());
        java.math.BigDecimal val14 = coremdmproductscheme.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, coremdmproductscheme.getTemplate());
        ps.setString(16, coremdmproductscheme.getApplicantParty());
        ps.setString(17, coremdmproductscheme.getFulfillmentParty());
        java.math.BigDecimal val18 = coremdmproductscheme.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, coremdmproductscheme.getSchemeType());
        ps.setString(20, coremdmproductscheme.getSchemeName());
        ps.setString(21, coremdmproductscheme.getSchemeCode());
        ps.setString(22, coremdmproductscheme.getSchemeDescription());
        java.time.LocalDateTime val23 = coremdmproductscheme.getEffectiveDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val24 = coremdmproductscheme.getExpiryDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        Integer val25 = coremdmproductscheme.getUploadRefID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
    }

    private CoreMdmProductScheme extract(ResultSet rs) throws SQLException {
        CoreMdmProductScheme coremdmproductscheme = new CoreMdmProductScheme();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        coremdmproductscheme.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        coremdmproductscheme.setReferenceID(REFERENCE_ID);
        coremdmproductscheme.setTypeCode(rs.getString(COL_TYPE_CODE));
        coremdmproductscheme.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        coremdmproductscheme.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        coremdmproductscheme.setStageCode(rs.getString(COL_STAGE_CODE));
        coremdmproductscheme.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        coremdmproductscheme.setProcessID(PROCESS_ID);
        coremdmproductscheme.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        coremdmproductscheme.setCreatedBy(CREATED_BY);
        coremdmproductscheme.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        coremdmproductscheme.setLastUpdatedBy(LAST_UPDATED_BY);
        coremdmproductscheme.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        coremdmproductscheme.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        coremdmproductscheme.setTemplate(rs.getString(COL_TEMPLATE));
        coremdmproductscheme.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        coremdmproductscheme.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        coremdmproductscheme.setIsTemplate(IS_TEMPLATE);
        coremdmproductscheme.setSchemeType(rs.getString(COL_SCHEME_TYPE));
        coremdmproductscheme.setSchemeName(rs.getString(COL_SCHEME_NAME));
        coremdmproductscheme.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        coremdmproductscheme.setSchemeDescription(rs.getString(COL_SCHEME_DESCRIPTION));
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            coremdmproductscheme.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        Timestamp EXPIRY_DATE = rs.getTimestamp(COL_EXPIRY_DATE);
        if (EXPIRY_DATE != null)
            coremdmproductscheme.setExpiryDate(EXPIRY_DATE.toLocalDateTime());
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        coremdmproductscheme.setUploadRefID(UPLOAD_REF_ID);
        return coremdmproductscheme;
    }
}
