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

public class JdbcFgLmsAssetSchemesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLmsAssetSchemesDao.class);

    private static final String TABLE = "FG_LMS_ASSET_SCHEMES";

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

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_EXPIRY_DATE = "EXPIRY_DATE";

    private static final String COL_ASSET_SCHEME_CODE = "ASSET_SCHEME_CODE";

    private static final String COL_ASSET_SCHEME_NAME = "ASSET_SCHEME_NAME";

    private static final String COL_ASSET_CLASSIFICATION_BASED_ON = "ASSET_CLASSIFICATION_BASED_ON";

    private static final String COL_FORWARD_MOVEMENT = "FORWARD_MOVEMENT";

    private static final String COL_BACKWARD_MOVEMENT = "BACKWARD_MOVEMENT";

    private static final String COL_PAST_DUE_DAYS_FROM = "PAST_DUE_DAYS_FROM";

    private static final String COL_PAST_DUE_DAYS_TO = "PAST_DUE_DAYS_TO";

    private static final String COL_DELINQUENCY_STAGE_NAME = "DELINQUENCY_STAGE_NAME";

    private static final String COL_DELINQUENCY_STAGE_CODE = "DELINQUENCY_STAGE_CODE";

    private static final String COL_STOP_ACCRUAL = "STOP_ACCRUAL";

    private static final String COL_DERECOGNIZE_INCOME = "DERECOGNIZE_INCOME";

    private static final String COL_PROVISION = "PROVISION";

    private static final String COL_EROSION_FROM = "EROSION_FROM";

    private static final String COL_EROSION_TO = "EROSION_TO";

    private static final String COL_IS_INCOME_DERECOGNIZED = "IS_INCOME_DERECOGNIZED";

    private static final String COL_SCHEME_NAME = "SCHEME_NAME";

    private static final String COL_SCHEME_DESCRIPTION = "SCHEME_DESCRIPTION";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_PRODUCT = "PRODUCT";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_EFFECTIVE_DATE_CHARGE = "EFFECTIVE_DATE_CHARGE";

    private static final String COL_EXPIRY_DATE_CHARGE = "EXPIRY_DATE_CHARGE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_ASSET_SCHEME_CODE, COL_ASSET_SCHEME_NAME, COL_ASSET_CLASSIFICATION_BASED_ON, COL_FORWARD_MOVEMENT, COL_BACKWARD_MOVEMENT, COL_PAST_DUE_DAYS_FROM, COL_PAST_DUE_DAYS_TO, COL_DELINQUENCY_STAGE_NAME, COL_DELINQUENCY_STAGE_CODE, COL_STOP_ACCRUAL, COL_DERECOGNIZE_INCOME, COL_PROVISION, COL_EROSION_FROM, COL_EROSION_TO, COL_IS_INCOME_DERECOGNIZED, COL_SCHEME_NAME, COL_SCHEME_DESCRIPTION, COL_PRODUCT_CODE, COL_PRODUCT_DESCRIPTION, COL_PRODUCT, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_EFFECTIVE_DATE_CHARGE, COL_EXPIRY_DATE_CHARGE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EFFECTIVE_DATE, EXPIRY_DATE, ASSET_SCHEME_CODE, ASSET_SCHEME_NAME, ASSET_CLASSIFICATION_BASED_ON, FORWARD_MOVEMENT, BACKWARD_MOVEMENT, PAST_DUE_DAYS_FROM, PAST_DUE_DAYS_TO, DELINQUENCY_STAGE_NAME, DELINQUENCY_STAGE_CODE, STOP_ACCRUAL, DERECOGNIZE_INCOME, PROVISION, EROSION_FROM, EROSION_TO, IS_INCOME_DERECOGNIZED, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, PRODUCT, VERSION_ID, IS_MASTER_VERSION, EFFECTIVE_DATE_CHARGE, EXPIRY_DATE_CHARGE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EFFECTIVE_DATE, EXPIRY_DATE, ASSET_SCHEME_CODE, ASSET_SCHEME_NAME, ASSET_CLASSIFICATION_BASED_ON, FORWARD_MOVEMENT, BACKWARD_MOVEMENT, PAST_DUE_DAYS_FROM, PAST_DUE_DAYS_TO, DELINQUENCY_STAGE_NAME, DELINQUENCY_STAGE_CODE, STOP_ACCRUAL, DERECOGNIZE_INCOME, PROVISION, EROSION_FROM, EROSION_TO, IS_INCOME_DERECOGNIZED, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, PRODUCT, VERSION_ID, IS_MASTER_VERSION, EFFECTIVE_DATE_CHARGE, EXPIRY_DATE_CHARGE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_EFFECTIVE_DATE, COL_EXPIRY_DATE, COL_ASSET_SCHEME_CODE, COL_ASSET_SCHEME_NAME, COL_ASSET_CLASSIFICATION_BASED_ON, COL_FORWARD_MOVEMENT, COL_BACKWARD_MOVEMENT, COL_PAST_DUE_DAYS_FROM, COL_PAST_DUE_DAYS_TO, COL_DELINQUENCY_STAGE_NAME, COL_DELINQUENCY_STAGE_CODE, COL_STOP_ACCRUAL, COL_DERECOGNIZE_INCOME, COL_PROVISION, COL_EROSION_FROM, COL_EROSION_TO, COL_IS_INCOME_DERECOGNIZED, COL_SCHEME_NAME, COL_SCHEME_DESCRIPTION, COL_PRODUCT_CODE, COL_PRODUCT_DESCRIPTION, COL_PRODUCT, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_EFFECTIVE_DATE_CHARGE, COL_EXPIRY_DATE_CHARGE, COL_ID);

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

    public int insert(Connection conn, FgLmsAssetSchemes fglmsassetschemes) throws SQLException {
        logger.debug("Inserting fglmsassetschemes: {}", fglmsassetschemes);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLmsAssetSchemesParams(ps, fglmsassetschemes);
            ps.executeUpdate();
            return fglmsassetschemes.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLmsAssetSchemes> fglmsassetschemess) throws SQLException {
        if (fglmsassetschemess == null || fglmsassetschemess.isEmpty())
            return new int[0];
        for (int i = 0; i < fglmsassetschemess.size(); i++) {
            if (fglmsassetschemess.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsAssetSchemes>> batches = chunkList(fglmsassetschemess, batchSize);
        int[] totalResults = new int[fglmsassetschemess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsAssetSchemes> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLmsAssetSchemes fglmsassetschemes : batch) {
                        setFgLmsAssetSchemesParams(ps, fglmsassetschemes);
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

    public FgLmsAssetSchemes findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLmsAssetSchemes> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLmsAssetSchemes> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLmsAssetSchemes fglmsassetschemes) throws SQLException {
        if (fglmsassetschemes.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLmsAssetSchemesParams(ps, fglmsassetschemes);
            ps.setInt(44, fglmsassetschemes.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLmsAssetSchemes> fglmsassetschemess) throws SQLException {
        if (fglmsassetschemess == null || fglmsassetschemess.isEmpty())
            return new int[0];
        for (FgLmsAssetSchemes fglmsassetschemes : fglmsassetschemess) {
            if (fglmsassetschemes == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglmsassetschemes.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsAssetSchemes>> batches = chunkList(fglmsassetschemess, batchSize);
        int[] totalResults = new int[fglmsassetschemess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsAssetSchemes> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLmsAssetSchemes fglmsassetschemes : batch) {
                        setFgLmsAssetSchemesParams(ps, fglmsassetschemes);
                        ps.setInt(44, fglmsassetschemes.getID());
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

    private void setFgLmsAssetSchemesParams(PreparedStatement ps, FgLmsAssetSchemes fglmsassetschemes) throws SQLException {
        Integer val1 = fglmsassetschemes.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fglmsassetschemes.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fglmsassetschemes.getTypeCode());
        ps.setString(4, fglmsassetschemes.getSubTypeCode());
        ps.setString(5, fglmsassetschemes.getActiveCode());
        ps.setString(6, fglmsassetschemes.getStageCode());
        ps.setString(7, fglmsassetschemes.getStatusCode());
        Integer val8 = fglmsassetschemes.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fglmsassetschemes.getCreatedOn());
        java.math.BigDecimal val10 = fglmsassetschemes.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fglmsassetschemes.getLastUpdatedOn());
        java.math.BigDecimal val12 = fglmsassetschemes.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglmsassetschemes.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fglmsassetschemes.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglmsassetschemes.getTemplate());
        ps.setString(16, fglmsassetschemes.getApplicantParty());
        ps.setString(17, fglmsassetschemes.getFulfillmentParty());
        java.math.BigDecimal val18 = fglmsassetschemes.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.time.LocalDateTime val19 = fglmsassetschemes.getEffectiveDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val20 = fglmsassetschemes.getExpiryDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fglmsassetschemes.getAssetSchemeCode());
        ps.setString(22, fglmsassetschemes.getAssetSchemeName());
        ps.setString(23, fglmsassetschemes.getAssetClassificationBasedOn());
        ps.setString(24, fglmsassetschemes.getForwardMovement());
        ps.setString(25, fglmsassetschemes.getBackwardMovement());
        java.math.BigDecimal val26 = fglmsassetschemes.getPastDueDaysFrom();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fglmsassetschemes.getPastDueDaysTo();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fglmsassetschemes.getDelinquencyStageName());
        ps.setString(29, fglmsassetschemes.getDelinquencyStageCode());
        ps.setString(30, fglmsassetschemes.getStopAccrual());
        ps.setString(31, fglmsassetschemes.getDerecognizeIncome());
        java.math.BigDecimal val32 = fglmsassetschemes.getProvision();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = fglmsassetschemes.getErosionFrom();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fglmsassetschemes.getErosionTo();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fglmsassetschemes.getIsIncomeDerecognized());
        ps.setString(36, fglmsassetschemes.getSchemeName());
        ps.setString(37, fglmsassetschemes.getSchemeDescription());
        ps.setString(38, fglmsassetschemes.getProductCode());
        ps.setString(39, fglmsassetschemes.getProductDescription());
        ps.setString(40, fglmsassetschemes.getProduct());
        Integer val41 = fglmsassetschemes.getVersionID();
        if (val41 != null) {
            ps.setInt(41, val41);
        } else {
            ps.setNull(41, Types.INTEGER);
        }
        java.math.BigDecimal val42 = fglmsassetschemes.getIsMasterVersion();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        java.time.LocalDateTime val43 = fglmsassetschemes.getEffectiveDateCharge();
        if (val43 != null) {
            ps.setTimestamp(43, java.sql.Timestamp.valueOf(val43));
        } else {
            ps.setNull(43, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val44 = fglmsassetschemes.getExpiryDateCharge();
        if (val44 != null) {
            ps.setTimestamp(44, java.sql.Timestamp.valueOf(val44));
        } else {
            ps.setNull(44, Types.TIMESTAMP);
        }
    }

    private FgLmsAssetSchemes extract(ResultSet rs) throws SQLException {
        FgLmsAssetSchemes fglmsassetschemes = new FgLmsAssetSchemes();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglmsassetschemes.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglmsassetschemes.setReferenceID(REFERENCE_ID);
        fglmsassetschemes.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglmsassetschemes.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglmsassetschemes.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglmsassetschemes.setStageCode(rs.getString(COL_STAGE_CODE));
        fglmsassetschemes.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglmsassetschemes.setProcessID(PROCESS_ID);
        fglmsassetschemes.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglmsassetschemes.setCreatedBy(CREATED_BY);
        fglmsassetschemes.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglmsassetschemes.setLastUpdatedBy(LAST_UPDATED_BY);
        fglmsassetschemes.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglmsassetschemes.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fglmsassetschemes.setTemplate(rs.getString(COL_TEMPLATE));
        fglmsassetschemes.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fglmsassetschemes.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fglmsassetschemes.setIsTemplate(IS_TEMPLATE);
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            fglmsassetschemes.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        Timestamp EXPIRY_DATE = rs.getTimestamp(COL_EXPIRY_DATE);
        if (EXPIRY_DATE != null)
            fglmsassetschemes.setExpiryDate(EXPIRY_DATE.toLocalDateTime());
        fglmsassetschemes.setAssetSchemeCode(rs.getString(COL_ASSET_SCHEME_CODE));
        fglmsassetschemes.setAssetSchemeName(rs.getString(COL_ASSET_SCHEME_NAME));
        fglmsassetschemes.setAssetClassificationBasedOn(rs.getString(COL_ASSET_CLASSIFICATION_BASED_ON));
        fglmsassetschemes.setForwardMovement(rs.getString(COL_FORWARD_MOVEMENT));
        fglmsassetschemes.setBackwardMovement(rs.getString(COL_BACKWARD_MOVEMENT));
        java.math.BigDecimal PAST_DUE_DAYS_FROM = rs.getObject(COL_PAST_DUE_DAYS_FROM, java.math.BigDecimal.class);
        fglmsassetschemes.setPastDueDaysFrom(PAST_DUE_DAYS_FROM);
        java.math.BigDecimal PAST_DUE_DAYS_TO = rs.getObject(COL_PAST_DUE_DAYS_TO, java.math.BigDecimal.class);
        fglmsassetschemes.setPastDueDaysTo(PAST_DUE_DAYS_TO);
        fglmsassetschemes.setDelinquencyStageName(rs.getString(COL_DELINQUENCY_STAGE_NAME));
        fglmsassetschemes.setDelinquencyStageCode(rs.getString(COL_DELINQUENCY_STAGE_CODE));
        fglmsassetschemes.setStopAccrual(rs.getString(COL_STOP_ACCRUAL));
        fglmsassetschemes.setDerecognizeIncome(rs.getString(COL_DERECOGNIZE_INCOME));
        java.math.BigDecimal PROVISION = rs.getObject(COL_PROVISION, java.math.BigDecimal.class);
        fglmsassetschemes.setProvision(PROVISION);
        java.math.BigDecimal EROSION_FROM = rs.getObject(COL_EROSION_FROM, java.math.BigDecimal.class);
        fglmsassetschemes.setErosionFrom(EROSION_FROM);
        java.math.BigDecimal EROSION_TO = rs.getObject(COL_EROSION_TO, java.math.BigDecimal.class);
        fglmsassetschemes.setErosionTo(EROSION_TO);
        fglmsassetschemes.setIsIncomeDerecognized(rs.getString(COL_IS_INCOME_DERECOGNIZED));
        fglmsassetschemes.setSchemeName(rs.getString(COL_SCHEME_NAME));
        fglmsassetschemes.setSchemeDescription(rs.getString(COL_SCHEME_DESCRIPTION));
        fglmsassetschemes.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fglmsassetschemes.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        fglmsassetschemes.setProduct(rs.getString(COL_PRODUCT));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fglmsassetschemes.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fglmsassetschemes.setIsMasterVersion(IS_MASTER_VERSION);
        Timestamp EFFECTIVE_DATE_CHARGE = rs.getTimestamp(COL_EFFECTIVE_DATE_CHARGE);
        if (EFFECTIVE_DATE_CHARGE != null)
            fglmsassetschemes.setEffectiveDateCharge(EFFECTIVE_DATE_CHARGE.toLocalDateTime());
        Timestamp EXPIRY_DATE_CHARGE = rs.getTimestamp(COL_EXPIRY_DATE_CHARGE);
        if (EXPIRY_DATE_CHARGE != null)
            fglmsassetschemes.setExpiryDateCharge(EXPIRY_DATE_CHARGE.toLocalDateTime());
        return fglmsassetschemes;
    }
}
