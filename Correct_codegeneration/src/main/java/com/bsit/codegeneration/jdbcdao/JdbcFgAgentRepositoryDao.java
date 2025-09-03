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

public class JdbcFgAgentRepositoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAgentRepositoryDao.class);

    private static final String TABLE = "FG_AGENT_REPOSITORY";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_AGENT_CATEGORY = "AGENT_CATEGORY";

    private static final String COL_AGENT_TYPE = "AGENT_TYPE";

    private static final String COL_AGENT_SCOPE = "AGENT_SCOPE";

    private static final String COL_AGENT_POOL_CODE = "AGENT_POOL_CODE";

    private static final String COL_OWNER_ORG_TYPE = "OWNER_ORG_TYPE";

    private static final String COL_OWNER_ORG_CODE = "OWNER_ORG_CODE";

    private static final String COL_SCOPE_ORG_TYPE = "SCOPE_ORG_TYPE";

    private static final String COL_SCOPE_ORG_CODE = "SCOPE_ORG_CODE";

    private static final String COL_START_TIME = "START_TIME";

    private static final String COL_LAST_RUN_TIME = "LAST_RUN_TIME";

    private static final String COL_LAST_RUN_STATUS = "LAST_RUN_STATUS";

    private static final String COL_LAST_HEALTH_TIME = "LAST_HEALTH_TIME";

    private static final String COL_LAST_HEALTH_STATUS = "LAST_HEALTH_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_AGENT_CATEGORY, COL_AGENT_TYPE, COL_AGENT_SCOPE, COL_AGENT_POOL_CODE, COL_OWNER_ORG_TYPE, COL_OWNER_ORG_CODE, COL_SCOPE_ORG_TYPE, COL_SCOPE_ORG_CODE, COL_START_TIME, COL_LAST_RUN_TIME, COL_LAST_RUN_STATUS, COL_LAST_HEALTH_TIME, COL_LAST_HEALTH_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_AGENT_CATEGORY, COL_AGENT_TYPE, COL_AGENT_SCOPE, COL_AGENT_POOL_CODE, COL_OWNER_ORG_TYPE, COL_OWNER_ORG_CODE, COL_SCOPE_ORG_TYPE, COL_SCOPE_ORG_CODE, COL_START_TIME, COL_LAST_RUN_TIME, COL_LAST_RUN_STATUS, COL_LAST_HEALTH_TIME, COL_LAST_HEALTH_STATUS, COL_ID);

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

    public int insert(Connection conn, FgAgentRepository fgagentrepository) throws SQLException {
        logger.debug("Inserting fgagentrepository: {}", fgagentrepository);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAgentRepositoryParams(ps, fgagentrepository);
            ps.executeUpdate();
            return fgagentrepository.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAgentRepository> fgagentrepositorys) throws SQLException {
        if (fgagentrepositorys == null || fgagentrepositorys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgagentrepositorys.size(); i++) {
            if (fgagentrepositorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAgentRepository>> batches = chunkList(fgagentrepositorys, batchSize);
        int[] totalResults = new int[fgagentrepositorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAgentRepository> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAgentRepository fgagentrepository : batch) {
                        setFgAgentRepositoryParams(ps, fgagentrepository);
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

    public FgAgentRepository findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAgentRepository> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAgentRepository> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAgentRepository fgagentrepository) throws SQLException {
        if (fgagentrepository.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAgentRepositoryParams(ps, fgagentrepository);
            ps.setInt(29, fgagentrepository.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAgentRepository> fgagentrepositorys) throws SQLException {
        if (fgagentrepositorys == null || fgagentrepositorys.isEmpty())
            return new int[0];
        for (FgAgentRepository fgagentrepository : fgagentrepositorys) {
            if (fgagentrepository == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgagentrepository.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAgentRepository>> batches = chunkList(fgagentrepositorys, batchSize);
        int[] totalResults = new int[fgagentrepositorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAgentRepository> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAgentRepository fgagentrepository : batch) {
                        setFgAgentRepositoryParams(ps, fgagentrepository);
                        ps.setInt(29, fgagentrepository.getID());
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

    private void setFgAgentRepositoryParams(PreparedStatement ps, FgAgentRepository fgagentrepository) throws SQLException {
        Integer val1 = fgagentrepository.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgagentrepository.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgagentrepository.getTypeCode());
        ps.setString(4, fgagentrepository.getSubTypeCode());
        ps.setString(5, fgagentrepository.getActiveCode());
        ps.setString(6, fgagentrepository.getStageCode());
        ps.setString(7, fgagentrepository.getStatusCode());
        ps.setString(8, fgagentrepository.getCreatedOn());
        java.math.BigDecimal val9 = fgagentrepository.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgagentrepository.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgagentrepository.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgagentrepository.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgagentrepository.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgagentrepository.getTemplate());
        java.math.BigDecimal val15 = fgagentrepository.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgagentrepository.getPurposeCode());
        ps.setString(17, fgagentrepository.getAgentCategory());
        ps.setString(18, fgagentrepository.getAgentType());
        ps.setString(19, fgagentrepository.getAgentScope());
        ps.setString(20, fgagentrepository.getAgentPoolCode());
        ps.setString(21, fgagentrepository.getOwnerOrgType());
        ps.setString(22, fgagentrepository.getOwnerOrgCode());
        ps.setString(23, fgagentrepository.getScopeOrgType());
        ps.setString(24, fgagentrepository.getScopeOrgCode());
        ps.setString(25, fgagentrepository.getStartTime());
        ps.setString(26, fgagentrepository.getLastRunTime());
        ps.setString(27, fgagentrepository.getLastRunStatus());
        ps.setString(28, fgagentrepository.getLastHealthTime());
        ps.setString(29, fgagentrepository.getLastHealthStatus());
    }

    private FgAgentRepository extract(ResultSet rs) throws SQLException {
        FgAgentRepository fgagentrepository = new FgAgentRepository();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgagentrepository.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgagentrepository.setReferenceID(REFERENCE_ID);
        fgagentrepository.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgagentrepository.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgagentrepository.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgagentrepository.setStageCode(rs.getString(COL_STAGE_CODE));
        fgagentrepository.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgagentrepository.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgagentrepository.setCreatedBy(CREATED_BY);
        fgagentrepository.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgagentrepository.setLastUpdatedBy(LAST_UPDATED_BY);
        fgagentrepository.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgagentrepository.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgagentrepository.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgagentrepository.setIsTemplate(IS_TEMPLATE);
        fgagentrepository.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgagentrepository.setAgentCategory(rs.getString(COL_AGENT_CATEGORY));
        fgagentrepository.setAgentType(rs.getString(COL_AGENT_TYPE));
        fgagentrepository.setAgentScope(rs.getString(COL_AGENT_SCOPE));
        fgagentrepository.setAgentPoolCode(rs.getString(COL_AGENT_POOL_CODE));
        fgagentrepository.setOwnerOrgType(rs.getString(COL_OWNER_ORG_TYPE));
        fgagentrepository.setOwnerOrgCode(rs.getString(COL_OWNER_ORG_CODE));
        fgagentrepository.setScopeOrgType(rs.getString(COL_SCOPE_ORG_TYPE));
        fgagentrepository.setScopeOrgCode(rs.getString(COL_SCOPE_ORG_CODE));
        fgagentrepository.setStartTime(rs.getString(COL_START_TIME));
        fgagentrepository.setLastRunTime(rs.getString(COL_LAST_RUN_TIME));
        fgagentrepository.setLastRunStatus(rs.getString(COL_LAST_RUN_STATUS));
        fgagentrepository.setLastHealthTime(rs.getString(COL_LAST_HEALTH_TIME));
        fgagentrepository.setLastHealthStatus(rs.getString(COL_LAST_HEALTH_STATUS));
        return fgagentrepository;
    }
}
