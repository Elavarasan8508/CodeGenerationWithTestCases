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

public class JdbcLmsMdmConfigDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmConfigDao.class);

    private static final String TABLE = "LMS_MDM_CONFIG";

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

    private static final String COL_ENTITY_TYPE = "ENTITY_TYPE";

    private static final String COL_ROLE_TYPE = "ROLE_TYPE";

    private static final String COL_NO_OF_DAYS = "NO_OF_DAYS";

    private static final String COL_REJECT_HOUR = "REJECT_HOUR";

    private static final String COL_REJECT_MINUTE = "REJECT_MINUTE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_REJECT_TIME = "REJECT_TIME";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ENTITY_TYPE, COL_ROLE_TYPE, COL_NO_OF_DAYS, COL_REJECT_HOUR, COL_REJECT_MINUTE, COL_DESCRIPTION, COL_REJECT_TIME, COL_VERSION_ID, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ENTITY_TYPE, ROLE_TYPE, NO_OF_DAYS, REJECT_HOUR, REJECT_MINUTE, DESCRIPTION, REJECT_TIME, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ENTITY_TYPE, ROLE_TYPE, NO_OF_DAYS, REJECT_HOUR, REJECT_MINUTE, DESCRIPTION, REJECT_TIME, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ENTITY_TYPE, COL_ROLE_TYPE, COL_NO_OF_DAYS, COL_REJECT_HOUR, COL_REJECT_MINUTE, COL_DESCRIPTION, COL_REJECT_TIME, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, LmsMdmConfig lmsmdmconfig) throws SQLException {
        logger.debug("Inserting lmsmdmconfig: {}", lmsmdmconfig);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmConfigParams(ps, lmsmdmconfig);
            ps.executeUpdate();
            return lmsmdmconfig.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmConfig> lmsmdmconfigs) throws SQLException {
        if (lmsmdmconfigs == null || lmsmdmconfigs.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmconfigs.size(); i++) {
            if (lmsmdmconfigs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmConfig>> batches = chunkList(lmsmdmconfigs, batchSize);
        int[] totalResults = new int[lmsmdmconfigs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmConfig> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmConfig lmsmdmconfig : batch) {
                        setLmsMdmConfigParams(ps, lmsmdmconfig);
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

    public LmsMdmConfig findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmConfig> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmConfig> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmConfig lmsmdmconfig) throws SQLException {
        if (lmsmdmconfig.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmConfigParams(ps, lmsmdmconfig);
            ps.setInt(27, lmsmdmconfig.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmConfig> lmsmdmconfigs) throws SQLException {
        if (lmsmdmconfigs == null || lmsmdmconfigs.isEmpty())
            return new int[0];
        for (LmsMdmConfig lmsmdmconfig : lmsmdmconfigs) {
            if (lmsmdmconfig == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmconfig.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmConfig>> batches = chunkList(lmsmdmconfigs, batchSize);
        int[] totalResults = new int[lmsmdmconfigs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmConfig> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmConfig lmsmdmconfig : batch) {
                        setLmsMdmConfigParams(ps, lmsmdmconfig);
                        ps.setInt(27, lmsmdmconfig.getID());
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

    private void setLmsMdmConfigParams(PreparedStatement ps, LmsMdmConfig lmsmdmconfig) throws SQLException {
        Integer val1 = lmsmdmconfig.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmconfig.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmconfig.getTypeCode());
        ps.setString(4, lmsmdmconfig.getSubTypeCode());
        ps.setString(5, lmsmdmconfig.getActiveCode());
        ps.setString(6, lmsmdmconfig.getStageCode());
        ps.setString(7, lmsmdmconfig.getStatusCode());
        Integer val8 = lmsmdmconfig.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmconfig.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmconfig.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmconfig.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmconfig.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmconfig.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmconfig.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmconfig.getTemplate());
        ps.setString(16, lmsmdmconfig.getApplicantParty());
        ps.setString(17, lmsmdmconfig.getFulfillmentParty());
        java.math.BigDecimal val18 = lmsmdmconfig.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, lmsmdmconfig.getEntityType());
        ps.setString(20, lmsmdmconfig.getRoleType());
        java.math.BigDecimal val21 = lmsmdmconfig.getNoOfDays();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = lmsmdmconfig.getRejectHour();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = lmsmdmconfig.getRejectMinute();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, lmsmdmconfig.getDescription());
        ps.setString(25, lmsmdmconfig.getRejectTime());
        Integer val26 = lmsmdmconfig.getVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        java.math.BigDecimal val27 = lmsmdmconfig.getIsMasterVersion();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
    }

    private LmsMdmConfig extract(ResultSet rs) throws SQLException {
        LmsMdmConfig lmsmdmconfig = new LmsMdmConfig();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmconfig.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmconfig.setReferenceID(REFERENCE_ID);
        lmsmdmconfig.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmconfig.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmconfig.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmconfig.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmconfig.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmconfig.setProcessID(PROCESS_ID);
        lmsmdmconfig.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmconfig.setCreatedBy(CREATED_BY);
        lmsmdmconfig.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmconfig.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmconfig.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmconfig.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmconfig.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmconfig.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmconfig.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmconfig.setIsTemplate(IS_TEMPLATE);
        lmsmdmconfig.setEntityType(rs.getString(COL_ENTITY_TYPE));
        lmsmdmconfig.setRoleType(rs.getString(COL_ROLE_TYPE));
        java.math.BigDecimal NO_OF_DAYS = rs.getObject(COL_NO_OF_DAYS, java.math.BigDecimal.class);
        lmsmdmconfig.setNoOfDays(NO_OF_DAYS);
        java.math.BigDecimal REJECT_HOUR = rs.getObject(COL_REJECT_HOUR, java.math.BigDecimal.class);
        lmsmdmconfig.setRejectHour(REJECT_HOUR);
        java.math.BigDecimal REJECT_MINUTE = rs.getObject(COL_REJECT_MINUTE, java.math.BigDecimal.class);
        lmsmdmconfig.setRejectMinute(REJECT_MINUTE);
        lmsmdmconfig.setDescription(rs.getString(COL_DESCRIPTION));
        lmsmdmconfig.setRejectTime(rs.getString(COL_REJECT_TIME));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        lmsmdmconfig.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        lmsmdmconfig.setIsMasterVersion(IS_MASTER_VERSION);
        return lmsmdmconfig;
    }
}
