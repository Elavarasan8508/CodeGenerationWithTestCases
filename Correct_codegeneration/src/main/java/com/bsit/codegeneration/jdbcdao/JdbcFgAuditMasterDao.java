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

public class JdbcFgAuditMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAuditMasterDao.class);

    private static final String TABLE = "FG_AUDIT_MASTER";

    private static final String COL_UUID = "UUID";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_USER_CODE = "USER_CODE";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SOURCE = "SOURCE";

    private static final String COL_ENDPOINT_CODE = "ENDPOINT_CODE";

    private static final String COL_ENTITY_CODE = "ENTITY_CODE";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_SERVERITY_CODE = "SERVERITY_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_OCCURED_ON = "OCCURED_ON";

    private static final String COL_SESSION_ID = "SESSION_ID";

    private static final String COL_SESSION_ADDRESS = "SESSION_ADDRESS";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_REL_ORG_CODE = "REL_ORG_CODE";

    private static final String COL_REL_ORG_SUB_TYPE_CODE = "REL_ORG_SUB_TYPE_CODE";

    private static final String COL_REL_ORG_TYPE_CODE = "REL_ORG_TYPE_CODE";

    private static final String COL_REL_ORG_PARENT_CODE = "REL_ORG_PARENT_CODE";

    private static final String COL_TOKEN_VALUE = "TOKEN_VALUE";

    private static final String COL_ENDS_ON = "ENDS_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_UUID, COL_PARTY_CODE, COL_USER_CODE, COL_CATEGORY_CODE, COL_TYPE_CODE, COL_SOURCE, COL_ENDPOINT_CODE, COL_ENTITY_CODE, COL_EVENT_CODE, COL_SERVERITY_CODE, COL_STATUS_CODE, COL_OCCURED_ON, COL_SESSION_ID, COL_SESSION_ADDRESS, COL_ENTITY_REF_ID, COL_REL_ORG_CODE, COL_REL_ORG_SUB_TYPE_CODE, COL_REL_ORG_TYPE_CODE, COL_REL_ORG_PARENT_CODE, COL_TOKEN_VALUE, COL_ENDS_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("UUID, PARTY_CODE, USER_CODE, CATEGORY_CODE, TYPE_CODE, SOURCE, ENDPOINT_CODE, ENTITY_CODE, EVENT_CODE, SERVERITY_CODE, STATUS_CODE, OCCURED_ON, SESSION_ID, SESSION_ADDRESS, ENTITY_REF_ID, REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE, TOKEN_VALUE, ENDS_ON", TABLE, COL_SESSION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("UUID, PARTY_CODE, USER_CODE, CATEGORY_CODE, TYPE_CODE, SOURCE, ENDPOINT_CODE, ENTITY_CODE, EVENT_CODE, SERVERITY_CODE, STATUS_CODE, OCCURED_ON, SESSION_ID, SESSION_ADDRESS, ENTITY_REF_ID, REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE, TOKEN_VALUE, ENDS_ON", TABLE, COL_SESSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_UUID, COL_PARTY_CODE, COL_USER_CODE, COL_CATEGORY_CODE, COL_TYPE_CODE, COL_SOURCE, COL_ENDPOINT_CODE, COL_ENTITY_CODE, COL_EVENT_CODE, COL_SERVERITY_CODE, COL_STATUS_CODE, COL_OCCURED_ON, COL_SESSION_ADDRESS, COL_ENTITY_REF_ID, COL_REL_ORG_CODE, COL_REL_ORG_SUB_TYPE_CODE, COL_REL_ORG_TYPE_CODE, COL_REL_ORG_PARENT_CODE, COL_TOKEN_VALUE, COL_ENDS_ON, COL_SESSION_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_SESSION_ID);

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

    public int insert(Connection conn, FgAuditMaster fgauditmaster) throws SQLException {
        logger.debug("Inserting fgauditmaster: {}", fgauditmaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAuditMasterParams(ps, fgauditmaster);
            ps.executeUpdate();
            return fgauditmaster.getSessionID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAuditMaster> fgauditmasters) throws SQLException {
        if (fgauditmasters == null || fgauditmasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgauditmasters.size(); i++) {
            if (fgauditmasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAuditMaster>> batches = chunkList(fgauditmasters, batchSize);
        int[] totalResults = new int[fgauditmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAuditMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAuditMaster fgauditmaster : batch) {
                        setFgAuditMasterParams(ps, fgauditmaster);
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

    public FgAuditMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAuditMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAuditMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAuditMaster fgauditmaster) throws SQLException {
        if (fgauditmaster.getSessionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAuditMasterParams(ps, fgauditmaster);
            ps.setInt(21, fgauditmaster.getSessionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAuditMaster> fgauditmasters) throws SQLException {
        if (fgauditmasters == null || fgauditmasters.isEmpty())
            return new int[0];
        for (FgAuditMaster fgauditmaster : fgauditmasters) {
            if (fgauditmaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgauditmaster.getSessionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAuditMaster>> batches = chunkList(fgauditmasters, batchSize);
        int[] totalResults = new int[fgauditmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAuditMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAuditMaster fgauditmaster : batch) {
                        setFgAuditMasterParams(ps, fgauditmaster);
                        ps.setInt(21, fgauditmaster.getSessionID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_SESSION_ID, placeholders);
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

    private void setFgAuditMasterParams(PreparedStatement ps, FgAuditMaster fgauditmaster) throws SQLException {
        ps.setString(1, fgauditmaster.getUuid());
        ps.setString(2, fgauditmaster.getPartyCode());
        ps.setString(3, fgauditmaster.getUserCode());
        ps.setString(4, fgauditmaster.getCategoryCode());
        ps.setString(5, fgauditmaster.getTypeCode());
        ps.setString(6, fgauditmaster.getSource());
        ps.setString(7, fgauditmaster.getEndpointCode());
        ps.setString(8, fgauditmaster.getEntityCode());
        ps.setString(9, fgauditmaster.getEventCode());
        ps.setString(10, fgauditmaster.getServerityCode());
        ps.setString(11, fgauditmaster.getStatusCode());
        ps.setString(12, fgauditmaster.getOccuredOn());
        Integer val13 = fgauditmaster.getSessionID();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        ps.setString(14, fgauditmaster.getSessionAddress());
        Integer val15 = fgauditmaster.getEntityRefID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
        ps.setString(16, fgauditmaster.getRelOrgCode());
        ps.setString(17, fgauditmaster.getRelOrgSubTypeCode());
        ps.setString(18, fgauditmaster.getRelOrgTypeCode());
        ps.setString(19, fgauditmaster.getRelOrgParentCode());
        ps.setString(20, fgauditmaster.getTokenValue());
        ps.setString(21, fgauditmaster.getEndsOn());
    }

    private FgAuditMaster extract(ResultSet rs) throws SQLException {
        FgAuditMaster fgauditmaster = new FgAuditMaster();
        fgauditmaster.setUuid(rs.getString(COL_UUID));
        fgauditmaster.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgauditmaster.setUserCode(rs.getString(COL_USER_CODE));
        fgauditmaster.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgauditmaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgauditmaster.setSource(rs.getString(COL_SOURCE));
        fgauditmaster.setEndpointCode(rs.getString(COL_ENDPOINT_CODE));
        fgauditmaster.setEntityCode(rs.getString(COL_ENTITY_CODE));
        fgauditmaster.setEventCode(rs.getString(COL_EVENT_CODE));
        fgauditmaster.setServerityCode(rs.getString(COL_SERVERITY_CODE));
        fgauditmaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgauditmaster.setOccuredOn(rs.getString(COL_OCCURED_ON));
        Integer SESSION_ID = rs.getObject(COL_SESSION_ID, Integer.class);
        fgauditmaster.setSessionID(SESSION_ID);
        fgauditmaster.setSessionAddress(rs.getString(COL_SESSION_ADDRESS));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgauditmaster.setEntityRefID(ENTITY_REF_ID);
        fgauditmaster.setRelOrgCode(rs.getString(COL_REL_ORG_CODE));
        fgauditmaster.setRelOrgSubTypeCode(rs.getString(COL_REL_ORG_SUB_TYPE_CODE));
        fgauditmaster.setRelOrgTypeCode(rs.getString(COL_REL_ORG_TYPE_CODE));
        fgauditmaster.setRelOrgParentCode(rs.getString(COL_REL_ORG_PARENT_CODE));
        fgauditmaster.setTokenValue(rs.getString(COL_TOKEN_VALUE));
        fgauditmaster.setEndsOn(rs.getString(COL_ENDS_ON));
        return fgauditmaster;
    }
}
