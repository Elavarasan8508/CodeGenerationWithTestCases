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

public class JdbcFgSettingCutoffBkp0410Dao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSettingCutoffBkp0410Dao.class);

    private static final String TABLE = "FG_SETTING_CUTOFF_BKP0410";

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

    private static final String COL_SCOPE_TYPE = "SCOPE_TYPE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_SCOPE_LEVEL = "SCOPE_LEVEL";

    private static final String COL_SCOPE_VALUE = "SCOPE_VALUE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_ENTITY_CODE = "ENTITY_CODE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FG_GROUP_SCOPE = "FG_GROUP_SCOPE";

    private static final String COL_FG_ROLE_SCOPE = "FG_ROLE_SCOPE";

    private static final String COL_CORPORATE_CRN = "CORPORATE_CRN";

    private static final String COL_ENTITY_NAME = "ENTITY_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCOPE_TYPE, COL_PRODUCT_CODE, COL_SCOPE_LEVEL, COL_SCOPE_VALUE, COL_SUB_PRODUCT_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_RATE_TYPE, COL_ENTITY_CODE, COL_UPLOAD_REF_ID, COL_FG_GROUP_SCOPE, COL_FG_ROLE_SCOPE, COL_CORPORATE_CRN, COL_ENTITY_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCOPE_TYPE, COL_PRODUCT_CODE, COL_SCOPE_LEVEL, COL_SCOPE_VALUE, COL_SUB_PRODUCT_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_RATE_TYPE, COL_ENTITY_CODE, COL_UPLOAD_REF_ID, COL_FG_GROUP_SCOPE, COL_FG_ROLE_SCOPE, COL_CORPORATE_CRN, COL_ENTITY_NAME, COL_ID);

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

    public int insert(Connection conn, FgSettingCutoffBkp0410 fgsettingcutoffbkp0410) throws SQLException {
        logger.debug("Inserting fgsettingcutoffbkp0410: {}", fgsettingcutoffbkp0410);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSettingCutoffBkp0410Params(ps, fgsettingcutoffbkp0410);
            ps.executeUpdate();
            return fgsettingcutoffbkp0410.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSettingCutoffBkp0410> fgsettingcutoffbkp0410s) throws SQLException {
        if (fgsettingcutoffbkp0410s == null || fgsettingcutoffbkp0410s.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsettingcutoffbkp0410s.size(); i++) {
            if (fgsettingcutoffbkp0410s.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettingCutoffBkp0410>> batches = chunkList(fgsettingcutoffbkp0410s, batchSize);
        int[] totalResults = new int[fgsettingcutoffbkp0410s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettingCutoffBkp0410> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSettingCutoffBkp0410 fgsettingcutoffbkp0410 : batch) {
                        setFgSettingCutoffBkp0410Params(ps, fgsettingcutoffbkp0410);
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

    public FgSettingCutoffBkp0410 findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSettingCutoffBkp0410> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSettingCutoffBkp0410> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSettingCutoffBkp0410 fgsettingcutoffbkp0410) throws SQLException {
        if (fgsettingcutoffbkp0410.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSettingCutoffBkp0410Params(ps, fgsettingcutoffbkp0410);
            ps.setInt(32, fgsettingcutoffbkp0410.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSettingCutoffBkp0410> fgsettingcutoffbkp0410s) throws SQLException {
        if (fgsettingcutoffbkp0410s == null || fgsettingcutoffbkp0410s.isEmpty())
            return new int[0];
        for (FgSettingCutoffBkp0410 fgsettingcutoffbkp0410 : fgsettingcutoffbkp0410s) {
            if (fgsettingcutoffbkp0410 == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsettingcutoffbkp0410.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettingCutoffBkp0410>> batches = chunkList(fgsettingcutoffbkp0410s, batchSize);
        int[] totalResults = new int[fgsettingcutoffbkp0410s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettingCutoffBkp0410> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSettingCutoffBkp0410 fgsettingcutoffbkp0410 : batch) {
                        setFgSettingCutoffBkp0410Params(ps, fgsettingcutoffbkp0410);
                        ps.setInt(32, fgsettingcutoffbkp0410.getID());
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

    private void setFgSettingCutoffBkp0410Params(PreparedStatement ps, FgSettingCutoffBkp0410 fgsettingcutoffbkp0410) throws SQLException {
        Integer val1 = fgsettingcutoffbkp0410.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsettingcutoffbkp0410.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsettingcutoffbkp0410.getTypeCode());
        ps.setString(4, fgsettingcutoffbkp0410.getSubTypeCode());
        ps.setString(5, fgsettingcutoffbkp0410.getActiveCode());
        ps.setString(6, fgsettingcutoffbkp0410.getStageCode());
        ps.setString(7, fgsettingcutoffbkp0410.getStatusCode());
        Integer val8 = fgsettingcutoffbkp0410.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgsettingcutoffbkp0410.getCreatedOn());
        java.math.BigDecimal val10 = fgsettingcutoffbkp0410.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgsettingcutoffbkp0410.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgsettingcutoffbkp0410.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsettingcutoffbkp0410.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgsettingcutoffbkp0410.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsettingcutoffbkp0410.getTemplate());
        ps.setString(16, fgsettingcutoffbkp0410.getApplicantParty());
        ps.setString(17, fgsettingcutoffbkp0410.getFulfillmentParty());
        java.math.BigDecimal val18 = fgsettingcutoffbkp0410.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsettingcutoffbkp0410.getScopeType());
        ps.setString(20, fgsettingcutoffbkp0410.getProductCode());
        ps.setString(21, fgsettingcutoffbkp0410.getScopeLevel());
        ps.setString(22, fgsettingcutoffbkp0410.getScopeValue());
        ps.setString(23, fgsettingcutoffbkp0410.getSubProductCode());
        Integer val24 = fgsettingcutoffbkp0410.getVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgsettingcutoffbkp0410.getIsMasterVersion();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgsettingcutoffbkp0410.getRateType();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgsettingcutoffbkp0410.getEntityCode());
        Integer val28 = fgsettingcutoffbkp0410.getUploadRefID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        ps.setString(29, fgsettingcutoffbkp0410.getFgGroupScope());
        ps.setString(30, fgsettingcutoffbkp0410.getFgRoleScope());
        java.math.BigDecimal val31 = fgsettingcutoffbkp0410.getCorporateCrn();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, fgsettingcutoffbkp0410.getEntityName());
    }

    private FgSettingCutoffBkp0410 extract(ResultSet rs) throws SQLException {
        FgSettingCutoffBkp0410 fgsettingcutoffbkp0410 = new FgSettingCutoffBkp0410();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsettingcutoffbkp0410.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsettingcutoffbkp0410.setReferenceID(REFERENCE_ID);
        fgsettingcutoffbkp0410.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsettingcutoffbkp0410.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsettingcutoffbkp0410.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsettingcutoffbkp0410.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsettingcutoffbkp0410.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgsettingcutoffbkp0410.setProcessID(PROCESS_ID);
        fgsettingcutoffbkp0410.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setCreatedBy(CREATED_BY);
        fgsettingcutoffbkp0410.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsettingcutoffbkp0410.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsettingcutoffbkp0410.setTemplate(rs.getString(COL_TEMPLATE));
        fgsettingcutoffbkp0410.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgsettingcutoffbkp0410.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setIsTemplate(IS_TEMPLATE);
        fgsettingcutoffbkp0410.setScopeType(rs.getString(COL_SCOPE_TYPE));
        fgsettingcutoffbkp0410.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgsettingcutoffbkp0410.setScopeLevel(rs.getString(COL_SCOPE_LEVEL));
        fgsettingcutoffbkp0410.setScopeValue(rs.getString(COL_SCOPE_VALUE));
        fgsettingcutoffbkp0410.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgsettingcutoffbkp0410.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setIsMasterVersion(IS_MASTER_VERSION);
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setRateType(RATE_TYPE);
        fgsettingcutoffbkp0410.setEntityCode(rs.getString(COL_ENTITY_CODE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgsettingcutoffbkp0410.setUploadRefID(UPLOAD_REF_ID);
        fgsettingcutoffbkp0410.setFgGroupScope(rs.getString(COL_FG_GROUP_SCOPE));
        fgsettingcutoffbkp0410.setFgRoleScope(rs.getString(COL_FG_ROLE_SCOPE));
        java.math.BigDecimal CORPORATE_CRN = rs.getObject(COL_CORPORATE_CRN, java.math.BigDecimal.class);
        fgsettingcutoffbkp0410.setCorporateCrn(CORPORATE_CRN);
        fgsettingcutoffbkp0410.setEntityName(rs.getString(COL_ENTITY_NAME));
        return fgsettingcutoffbkp0410;
    }
}
