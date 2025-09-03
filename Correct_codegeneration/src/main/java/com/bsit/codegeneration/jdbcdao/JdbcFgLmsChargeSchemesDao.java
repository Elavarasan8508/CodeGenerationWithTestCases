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

public class JdbcFgLmsChargeSchemesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLmsChargeSchemesDao.class);

    private static final String TABLE = "FG_LMS_CHARGE_SCHEMES";

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

    private static final String COL_SCHEME_NAME = "SCHEME_NAME";

    private static final String COL_SCHEME_DESCRIPTION = "SCHEME_DESCRIPTION";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_EXPIRY_DATE = "EXPIRY_DATE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PRODUCT = "PRODUCT";

    private static final String COL_SUB_PRODUCT = "SUB_PRODUCT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_NAME, COL_SCHEME_DESCRIPTION, COL_PRODUCT_CODE, COL_PRODUCT_DESCRIPTION, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PRODUCT, COL_SUB_PRODUCT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, VERSION_ID, IS_MASTER_VERSION, PRODUCT, SUB_PRODUCT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, VERSION_ID, IS_MASTER_VERSION, PRODUCT, SUB_PRODUCT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_NAME, COL_SCHEME_DESCRIPTION, COL_PRODUCT_CODE, COL_PRODUCT_DESCRIPTION, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PRODUCT, COL_SUB_PRODUCT, COL_ID);

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

    public int insert(Connection conn, FgLmsChargeSchemes fglmschargeschemes) throws SQLException {
        logger.debug("Inserting fglmschargeschemes: {}", fglmschargeschemes);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLmsChargeSchemesParams(ps, fglmschargeschemes);
            ps.executeUpdate();
            return fglmschargeschemes.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLmsChargeSchemes> fglmschargeschemess) throws SQLException {
        if (fglmschargeschemess == null || fglmschargeschemess.isEmpty())
            return new int[0];
        for (int i = 0; i < fglmschargeschemess.size(); i++) {
            if (fglmschargeschemess.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsChargeSchemes>> batches = chunkList(fglmschargeschemess, batchSize);
        int[] totalResults = new int[fglmschargeschemess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsChargeSchemes> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLmsChargeSchemes fglmschargeschemes : batch) {
                        setFgLmsChargeSchemesParams(ps, fglmschargeschemes);
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

    public FgLmsChargeSchemes findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLmsChargeSchemes> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLmsChargeSchemes> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLmsChargeSchemes fglmschargeschemes) throws SQLException {
        if (fglmschargeschemes.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLmsChargeSchemesParams(ps, fglmschargeschemes);
            ps.setInt(28, fglmschargeschemes.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLmsChargeSchemes> fglmschargeschemess) throws SQLException {
        if (fglmschargeschemess == null || fglmschargeschemess.isEmpty())
            return new int[0];
        for (FgLmsChargeSchemes fglmschargeschemes : fglmschargeschemess) {
            if (fglmschargeschemes == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglmschargeschemes.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsChargeSchemes>> batches = chunkList(fglmschargeschemess, batchSize);
        int[] totalResults = new int[fglmschargeschemess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsChargeSchemes> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLmsChargeSchemes fglmschargeschemes : batch) {
                        setFgLmsChargeSchemesParams(ps, fglmschargeschemes);
                        ps.setInt(28, fglmschargeschemes.getID());
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

    private void setFgLmsChargeSchemesParams(PreparedStatement ps, FgLmsChargeSchemes fglmschargeschemes) throws SQLException {
        Integer val1 = fglmschargeschemes.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fglmschargeschemes.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fglmschargeschemes.getTypeCode());
        ps.setString(4, fglmschargeschemes.getSubTypeCode());
        ps.setString(5, fglmschargeschemes.getActiveCode());
        ps.setString(6, fglmschargeschemes.getStageCode());
        ps.setString(7, fglmschargeschemes.getStatusCode());
        Integer val8 = fglmschargeschemes.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fglmschargeschemes.getCreatedOn());
        java.math.BigDecimal val10 = fglmschargeschemes.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fglmschargeschemes.getLastUpdatedOn());
        java.math.BigDecimal val12 = fglmschargeschemes.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglmschargeschemes.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fglmschargeschemes.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglmschargeschemes.getTemplate());
        ps.setString(16, fglmschargeschemes.getApplicantParty());
        ps.setString(17, fglmschargeschemes.getFulfillmentParty());
        java.math.BigDecimal val18 = fglmschargeschemes.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fglmschargeschemes.getSchemeName());
        ps.setString(20, fglmschargeschemes.getSchemeDescription());
        ps.setString(21, fglmschargeschemes.getProductCode());
        ps.setString(22, fglmschargeschemes.getProductDescription());
        java.time.LocalDateTime val23 = fglmschargeschemes.getEffectiveDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val24 = fglmschargeschemes.getExpiryDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        Integer val25 = fglmschargeschemes.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = fglmschargeschemes.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fglmschargeschemes.getProduct());
        ps.setString(28, fglmschargeschemes.getSubProduct());
    }

    private FgLmsChargeSchemes extract(ResultSet rs) throws SQLException {
        FgLmsChargeSchemes fglmschargeschemes = new FgLmsChargeSchemes();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglmschargeschemes.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglmschargeschemes.setReferenceID(REFERENCE_ID);
        fglmschargeschemes.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglmschargeschemes.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglmschargeschemes.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglmschargeschemes.setStageCode(rs.getString(COL_STAGE_CODE));
        fglmschargeschemes.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglmschargeschemes.setProcessID(PROCESS_ID);
        fglmschargeschemes.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglmschargeschemes.setCreatedBy(CREATED_BY);
        fglmschargeschemes.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglmschargeschemes.setLastUpdatedBy(LAST_UPDATED_BY);
        fglmschargeschemes.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglmschargeschemes.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fglmschargeschemes.setTemplate(rs.getString(COL_TEMPLATE));
        fglmschargeschemes.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fglmschargeschemes.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fglmschargeschemes.setIsTemplate(IS_TEMPLATE);
        fglmschargeschemes.setSchemeName(rs.getString(COL_SCHEME_NAME));
        fglmschargeschemes.setSchemeDescription(rs.getString(COL_SCHEME_DESCRIPTION));
        fglmschargeschemes.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fglmschargeschemes.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            fglmschargeschemes.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        Timestamp EXPIRY_DATE = rs.getTimestamp(COL_EXPIRY_DATE);
        if (EXPIRY_DATE != null)
            fglmschargeschemes.setExpiryDate(EXPIRY_DATE.toLocalDateTime());
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fglmschargeschemes.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fglmschargeschemes.setIsMasterVersion(IS_MASTER_VERSION);
        fglmschargeschemes.setProduct(rs.getString(COL_PRODUCT));
        fglmschargeschemes.setSubProduct(rs.getString(COL_SUB_PRODUCT));
        return fglmschargeschemes;
    }
}
