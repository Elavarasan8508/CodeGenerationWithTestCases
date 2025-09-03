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

public class JdbcFgModRuleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModRuleDao.class);

    private static final String TABLE = "FG_MOD_RULE";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_RULE_TYPE_CODE = "RULE_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_RULE_OBJECT = "RULE_OBJECT";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_DEPLOYMENT_ID = "DEPLOYMENT_ID";

    private static final String COL_DEPLOYMENT_TIME = "DEPLOYMENT_TIME";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_CODE = "CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_AUTHORISED_RULE = "AUTHORISED_RULE";

    private static final String COL_IS_SYNC = "IS_SYNC";

    private static final String COL_SYNC_TARGET_SUB_TYPE_CODE = "SYNC_TARGET_SUB_TYPE_CODE";

    private static final String COL_SYNC_SOURCE_SUB_TYPE_CODE = "SYNC_SOURCE_SUB_TYPE_CODE";

    private static final String COL_LAST_SYNCED_ON = "LAST_SYNCED_ON";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_OWNER_PARTY_CODE = "OWNER_PARTY_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_RULE_TYPE_CODE, COL_PARTY_CODE, COL_NAME, COL_REFERENCE_ID, COL_RULE_OBJECT, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_DEPLOYMENT_ID, COL_DEPLOYMENT_TIME, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_CODE, COL_STAGE_CODE, COL_AUTHORISED_RULE, COL_IS_SYNC, COL_SYNC_TARGET_SUB_TYPE_CODE, COL_SYNC_SOURCE_SUB_TYPE_CODE, COL_LAST_SYNCED_ON, COL_APPLICANT_PARTY, COL_OWNER_PARTY_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, RULE_TYPE_CODE, PARTY_CODE, NAME, REFERENCE_ID, RULE_OBJECT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, DEPLOYMENT_ID, DEPLOYMENT_TIME, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, CODE, STAGE_CODE, AUTHORISED_RULE, IS_SYNC, SYNC_TARGET_SUB_TYPE_CODE, SYNC_SOURCE_SUB_TYPE_CODE, LAST_SYNCED_ON, APPLICANT_PARTY, OWNER_PARTY_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, RULE_TYPE_CODE, PARTY_CODE, NAME, REFERENCE_ID, RULE_OBJECT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, DEPLOYMENT_ID, DEPLOYMENT_TIME, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, CODE, STAGE_CODE, AUTHORISED_RULE, IS_SYNC, SYNC_TARGET_SUB_TYPE_CODE, SYNC_SOURCE_SUB_TYPE_CODE, LAST_SYNCED_ON, APPLICANT_PARTY, OWNER_PARTY_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_RULE_TYPE_CODE, COL_PARTY_CODE, COL_NAME, COL_REFERENCE_ID, COL_RULE_OBJECT, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_DEPLOYMENT_ID, COL_DEPLOYMENT_TIME, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_CODE, COL_STAGE_CODE, COL_AUTHORISED_RULE, COL_IS_SYNC, COL_SYNC_TARGET_SUB_TYPE_CODE, COL_SYNC_SOURCE_SUB_TYPE_CODE, COL_LAST_SYNCED_ON, COL_APPLICANT_PARTY, COL_OWNER_PARTY_CODE, COL_ID);

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

    public int insert(Connection conn, FgModRule fgmodrule) throws SQLException {
        logger.debug("Inserting fgmodrule: {}", fgmodrule);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModRuleParams(ps, fgmodrule);
            ps.executeUpdate();
            return fgmodrule.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModRule> fgmodrules) throws SQLException {
        if (fgmodrules == null || fgmodrules.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodrules.size(); i++) {
            if (fgmodrules.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModRule>> batches = chunkList(fgmodrules, batchSize);
        int[] totalResults = new int[fgmodrules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModRule fgmodrule : batch) {
                        setFgModRuleParams(ps, fgmodrule);
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

    public FgModRule findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModRule> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModRule> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModRule fgmodrule) throws SQLException {
        if (fgmodrule.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModRuleParams(ps, fgmodrule);
            ps.setInt(30, fgmodrule.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModRule> fgmodrules) throws SQLException {
        if (fgmodrules == null || fgmodrules.isEmpty())
            return new int[0];
        for (FgModRule fgmodrule : fgmodrules) {
            if (fgmodrule == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodrule.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModRule>> batches = chunkList(fgmodrules, batchSize);
        int[] totalResults = new int[fgmodrules.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModRule> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModRule fgmodrule : batch) {
                        setFgModRuleParams(ps, fgmodrule);
                        ps.setInt(30, fgmodrule.getID());
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

    private void setFgModRuleParams(PreparedStatement ps, FgModRule fgmodrule) throws SQLException {
        Integer val1 = fgmodrule.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgmodrule.getPartyTypeCode());
        ps.setString(3, fgmodrule.getPartySubTypeCode());
        ps.setString(4, fgmodrule.getRuleTypeCode());
        ps.setString(5, fgmodrule.getPartyCode());
        ps.setString(6, fgmodrule.getName());
        Integer val7 = fgmodrule.getReferenceID();
        if (val7 != null) {
            ps.setInt(7, val7);
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgmodrule.getRuleObject());
        ps.setString(9, fgmodrule.getDescription());
        ps.setString(10, fgmodrule.getActiveCode());
        ps.setString(11, fgmodrule.getStatusCode());
        Integer val12 = fgmodrule.getDeploymentID();
        if (val12 != null) {
            ps.setInt(12, val12);
        } else {
            ps.setNull(12, Types.INTEGER);
        }
        java.time.LocalDateTime val13 = fgmodrule.getDeploymentTime();
        if (val13 != null) {
            ps.setTimestamp(13, java.sql.Timestamp.valueOf(val13));
        } else {
            ps.setNull(13, Types.TIMESTAMP);
        }
        ps.setString(14, fgmodrule.getCreatedOn());
        java.math.BigDecimal val15 = fgmodrule.getCreatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgmodrule.getLastUpdatedOn());
        java.math.BigDecimal val17 = fgmodrule.getLastUpdatedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgmodrule.getLastAuthorisedOn());
        java.math.BigDecimal val19 = fgmodrule.getLastAuthorisedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgmodrule.getTypeCode());
        ps.setString(21, fgmodrule.getSubTypeCode());
        ps.setString(22, fgmodrule.getCode());
        ps.setString(23, fgmodrule.getStageCode());
        ps.setString(24, fgmodrule.getAuthorisedRule());
        java.math.BigDecimal val25 = fgmodrule.getIsSync();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgmodrule.getSyncTargetSubTypeCode());
        ps.setString(27, fgmodrule.getSyncSourceSubTypeCode());
        ps.setString(28, fgmodrule.getLastSyncedOn());
        ps.setString(29, fgmodrule.getApplicantParty());
        ps.setString(30, fgmodrule.getOwnerPartyCode());
    }

    private FgModRule extract(ResultSet rs) throws SQLException {
        FgModRule fgmodrule = new FgModRule();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodrule.setID(ID);
        fgmodrule.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgmodrule.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgmodrule.setRuleTypeCode(rs.getString(COL_RULE_TYPE_CODE));
        fgmodrule.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgmodrule.setName(rs.getString(COL_NAME));
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodrule.setReferenceID(REFERENCE_ID);
        fgmodrule.setRuleObject(rs.getString(COL_RULE_OBJECT));
        fgmodrule.setDescription(rs.getString(COL_DESCRIPTION));
        fgmodrule.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodrule.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer DEPLOYMENT_ID = rs.getObject(COL_DEPLOYMENT_ID, Integer.class);
        fgmodrule.setDeploymentID(DEPLOYMENT_ID);
        Timestamp DEPLOYMENT_TIME = rs.getTimestamp(COL_DEPLOYMENT_TIME);
        if (DEPLOYMENT_TIME != null)
            fgmodrule.setDeploymentTime(DEPLOYMENT_TIME.toLocalDateTime());
        fgmodrule.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodrule.setCreatedBy(CREATED_BY);
        fgmodrule.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodrule.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodrule.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodrule.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodrule.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodrule.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmodrule.setCode(rs.getString(COL_CODE));
        fgmodrule.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmodrule.setAuthorisedRule(rs.getString(COL_AUTHORISED_RULE));
        java.math.BigDecimal IS_SYNC = rs.getObject(COL_IS_SYNC, java.math.BigDecimal.class);
        fgmodrule.setIsSync(IS_SYNC);
        fgmodrule.setSyncTargetSubTypeCode(rs.getString(COL_SYNC_TARGET_SUB_TYPE_CODE));
        fgmodrule.setSyncSourceSubTypeCode(rs.getString(COL_SYNC_SOURCE_SUB_TYPE_CODE));
        fgmodrule.setLastSyncedOn(rs.getString(COL_LAST_SYNCED_ON));
        fgmodrule.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgmodrule.setOwnerPartyCode(rs.getString(COL_OWNER_PARTY_CODE));
        return fgmodrule;
    }
}
