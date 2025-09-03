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

public class JdbcFgAgentRepositoryEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAgentRepositoryEventDao.class);

    private static final String TABLE = "FG_AGENT_REPOSITORY_EVENT";

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

    private static final String COL_AGENT_REF_ID = "AGENT_REF_ID";

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
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_AGENT_REF_ID, COL_PURPOSE_CODE, COL_AGENT_CATEGORY, COL_AGENT_TYPE, COL_AGENT_SCOPE, COL_AGENT_POOL_CODE, COL_OWNER_ORG_TYPE, COL_OWNER_ORG_CODE, COL_SCOPE_ORG_TYPE, COL_SCOPE_ORG_CODE, COL_START_TIME, COL_LAST_RUN_TIME, COL_LAST_RUN_STATUS, COL_LAST_HEALTH_TIME, COL_LAST_HEALTH_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, AGENT_REF_ID, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, AGENT_REF_ID, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_AGENT_REF_ID, COL_PURPOSE_CODE, COL_AGENT_CATEGORY, COL_AGENT_TYPE, COL_AGENT_SCOPE, COL_AGENT_POOL_CODE, COL_OWNER_ORG_TYPE, COL_OWNER_ORG_CODE, COL_SCOPE_ORG_TYPE, COL_SCOPE_ORG_CODE, COL_START_TIME, COL_LAST_RUN_TIME, COL_LAST_RUN_STATUS, COL_LAST_HEALTH_TIME, COL_LAST_HEALTH_STATUS, COL_ID);

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

    public int insert(Connection conn, FgAgentRepositoryEvent fgagentrepositoryevent) throws SQLException {
        logger.debug("Inserting fgagentrepositoryevent: {}", fgagentrepositoryevent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAgentRepositoryEventParams(ps, fgagentrepositoryevent);
            ps.executeUpdate();
            return fgagentrepositoryevent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAgentRepositoryEvent> fgagentrepositoryevents) throws SQLException {
        if (fgagentrepositoryevents == null || fgagentrepositoryevents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgagentrepositoryevents.size(); i++) {
            if (fgagentrepositoryevents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAgentRepositoryEvent>> batches = chunkList(fgagentrepositoryevents, batchSize);
        int[] totalResults = new int[fgagentrepositoryevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAgentRepositoryEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAgentRepositoryEvent fgagentrepositoryevent : batch) {
                        setFgAgentRepositoryEventParams(ps, fgagentrepositoryevent);
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

    public FgAgentRepositoryEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAgentRepositoryEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAgentRepositoryEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAgentRepositoryEvent fgagentrepositoryevent) throws SQLException {
        if (fgagentrepositoryevent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAgentRepositoryEventParams(ps, fgagentrepositoryevent);
            ps.setInt(30, fgagentrepositoryevent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAgentRepositoryEvent> fgagentrepositoryevents) throws SQLException {
        if (fgagentrepositoryevents == null || fgagentrepositoryevents.isEmpty())
            return new int[0];
        for (FgAgentRepositoryEvent fgagentrepositoryevent : fgagentrepositoryevents) {
            if (fgagentrepositoryevent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgagentrepositoryevent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAgentRepositoryEvent>> batches = chunkList(fgagentrepositoryevents, batchSize);
        int[] totalResults = new int[fgagentrepositoryevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAgentRepositoryEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAgentRepositoryEvent fgagentrepositoryevent : batch) {
                        setFgAgentRepositoryEventParams(ps, fgagentrepositoryevent);
                        ps.setInt(30, fgagentrepositoryevent.getID());
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

    private void setFgAgentRepositoryEventParams(PreparedStatement ps, FgAgentRepositoryEvent fgagentrepositoryevent) throws SQLException {
        Integer val1 = fgagentrepositoryevent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgagentrepositoryevent.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgagentrepositoryevent.getTypeCode());
        ps.setString(4, fgagentrepositoryevent.getSubTypeCode());
        ps.setString(5, fgagentrepositoryevent.getActiveCode());
        ps.setString(6, fgagentrepositoryevent.getStageCode());
        ps.setString(7, fgagentrepositoryevent.getStatusCode());
        ps.setString(8, fgagentrepositoryevent.getCreatedOn());
        java.math.BigDecimal val9 = fgagentrepositoryevent.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgagentrepositoryevent.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgagentrepositoryevent.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgagentrepositoryevent.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgagentrepositoryevent.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgagentrepositoryevent.getTemplate());
        java.math.BigDecimal val15 = fgagentrepositoryevent.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgagentrepositoryevent.getAgentRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, fgagentrepositoryevent.getPurposeCode());
        ps.setString(18, fgagentrepositoryevent.getAgentCategory());
        ps.setString(19, fgagentrepositoryevent.getAgentType());
        ps.setString(20, fgagentrepositoryevent.getAgentScope());
        ps.setString(21, fgagentrepositoryevent.getAgentPoolCode());
        ps.setString(22, fgagentrepositoryevent.getOwnerOrgType());
        ps.setString(23, fgagentrepositoryevent.getOwnerOrgCode());
        ps.setString(24, fgagentrepositoryevent.getScopeOrgType());
        ps.setString(25, fgagentrepositoryevent.getScopeOrgCode());
        ps.setString(26, fgagentrepositoryevent.getStartTime());
        ps.setString(27, fgagentrepositoryevent.getLastRunTime());
        ps.setString(28, fgagentrepositoryevent.getLastRunStatus());
        ps.setString(29, fgagentrepositoryevent.getLastHealthTime());
        ps.setString(30, fgagentrepositoryevent.getLastHealthStatus());
    }

    private FgAgentRepositoryEvent extract(ResultSet rs) throws SQLException {
        FgAgentRepositoryEvent fgagentrepositoryevent = new FgAgentRepositoryEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgagentrepositoryevent.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgagentrepositoryevent.setReferenceID(REFERENCE_ID);
        fgagentrepositoryevent.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgagentrepositoryevent.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgagentrepositoryevent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgagentrepositoryevent.setStageCode(rs.getString(COL_STAGE_CODE));
        fgagentrepositoryevent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgagentrepositoryevent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgagentrepositoryevent.setCreatedBy(CREATED_BY);
        fgagentrepositoryevent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgagentrepositoryevent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgagentrepositoryevent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgagentrepositoryevent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgagentrepositoryevent.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgagentrepositoryevent.setIsTemplate(IS_TEMPLATE);
        Integer AGENT_REF_ID = rs.getObject(COL_AGENT_REF_ID, Integer.class);
        fgagentrepositoryevent.setAgentRefID(AGENT_REF_ID);
        fgagentrepositoryevent.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgagentrepositoryevent.setAgentCategory(rs.getString(COL_AGENT_CATEGORY));
        fgagentrepositoryevent.setAgentType(rs.getString(COL_AGENT_TYPE));
        fgagentrepositoryevent.setAgentScope(rs.getString(COL_AGENT_SCOPE));
        fgagentrepositoryevent.setAgentPoolCode(rs.getString(COL_AGENT_POOL_CODE));
        fgagentrepositoryevent.setOwnerOrgType(rs.getString(COL_OWNER_ORG_TYPE));
        fgagentrepositoryevent.setOwnerOrgCode(rs.getString(COL_OWNER_ORG_CODE));
        fgagentrepositoryevent.setScopeOrgType(rs.getString(COL_SCOPE_ORG_TYPE));
        fgagentrepositoryevent.setScopeOrgCode(rs.getString(COL_SCOPE_ORG_CODE));
        fgagentrepositoryevent.setStartTime(rs.getString(COL_START_TIME));
        fgagentrepositoryevent.setLastRunTime(rs.getString(COL_LAST_RUN_TIME));
        fgagentrepositoryevent.setLastRunStatus(rs.getString(COL_LAST_RUN_STATUS));
        fgagentrepositoryevent.setLastHealthTime(rs.getString(COL_LAST_HEALTH_TIME));
        fgagentrepositoryevent.setLastHealthStatus(rs.getString(COL_LAST_HEALTH_STATUS));
        return fgagentrepositoryevent;
    }
}
