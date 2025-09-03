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

public class JdbcFgGroupRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgGroupRoleDao.class);

    private static final String TABLE = "FG_GROUP_ROLE";

    private static final String COL_ID = "ID";

    private static final String COL_GROUP_ID = "GROUP_ID";

    private static final String COL_GROUP_VERSION_ID = "GROUP_VERSION_ID";

    private static final String COL_ROLE_ID = "ROLE_ID";

    private static final String COL_ROLE_VERSION_ID = "ROLE_VERSION_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_GROUP_ID, COL_GROUP_VERSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_GROUP_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_GROUP_ID);

    private static final String SELECT_BY_ROLE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ROLE_ID);

    private static final String SELECT_BY_ROLE_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ROLE_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_GROUP_ID, COL_GROUP_VERSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgGroupRole fggrouprole) throws SQLException {
        logger.debug("Inserting fggrouprole: {}", fggrouprole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgGroupRoleParams(ps, fggrouprole);
            ps.executeUpdate();
            return fggrouprole.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgGroupRole> fggrouproles) throws SQLException {
        if (fggrouproles == null || fggrouproles.isEmpty())
            return new int[0];
        for (int i = 0; i < fggrouproles.size(); i++) {
            if (fggrouproles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgGroupRole>> batches = chunkList(fggrouproles, batchSize);
        int[] totalResults = new int[fggrouproles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgGroupRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgGroupRole fggrouprole : batch) {
                        setFgGroupRoleParams(ps, fggrouprole);
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

    public FgGroupRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgGroupRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgGroupRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgGroupRole fggrouprole) throws SQLException {
        if (fggrouprole.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgGroupRoleParams(ps, fggrouprole);
            ps.setInt(13, fggrouprole.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgGroupRole> fggrouproles) throws SQLException {
        if (fggrouproles == null || fggrouproles.isEmpty())
            return new int[0];
        for (FgGroupRole fggrouprole : fggrouproles) {
            if (fggrouprole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fggrouprole.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgGroupRole>> batches = chunkList(fggrouproles, batchSize);
        int[] totalResults = new int[fggrouproles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgGroupRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgGroupRole fggrouprole : batch) {
                        setFgGroupRoleParams(ps, fggrouprole);
                        ps.setInt(13, fggrouprole.getID());
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

    public List<FgGroupRole> findByGroupID(Connection conn, int groupID) throws SQLException {
        List<FgGroupRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_GROUP_ID_SQL)) {
            ps.setInt(1, groupID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgGroupRole> findByRoleID(Connection conn, int roleID) throws SQLException {
        List<FgGroupRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ROLE_ID_SQL)) {
            ps.setInt(1, roleID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgGroupRole> findByRoleVersionID(Connection conn, int roleVersionID) throws SQLException {
        List<FgGroupRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ROLE_VERSION_ID_SQL)) {
            ps.setInt(1, roleVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgGroupRoleParams(PreparedStatement ps, FgGroupRole fggrouprole) throws SQLException {
        Integer val1 = fggrouprole.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (fggrouprole.getGroup() != null) {
            ps.setInt(2, fggrouprole.getGroup().getFgGroupID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fggrouprole.getGroupVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (fggrouprole.getRole() != null) {
            ps.setInt(4, fggrouprole.getRole().getFgRoleID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (fggrouprole.getRoleVersion() != null) {
            ps.setInt(5, fggrouprole.getRoleVersion().getFgRoleID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fggrouprole.getActiveCode());
        ps.setString(7, fggrouprole.getStatusCode());
        ps.setString(8, fggrouprole.getCreatedOn());
        java.math.BigDecimal val9 = fggrouprole.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fggrouprole.getLastUpdatedOn());
        java.math.BigDecimal val11 = fggrouprole.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fggrouprole.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fggrouprole.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
    }

    private FgGroupRole extract(ResultSet rs) throws SQLException {
        FgGroupRole fggrouprole = new FgGroupRole();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fggrouprole.setID(ID);
        Integer GROUP_ID = rs.getObject(COL_GROUP_ID, Integer.class);
        fggrouprole.setGroupID(GROUP_ID);
        if (GROUP_ID != null) {
            FgGroup group = new FgGroup();
            group.setFgGroupID(GROUP_ID);
            fggrouprole.setGroup(group);
        }
        Integer GROUP_VERSION_ID = rs.getObject(COL_GROUP_VERSION_ID, Integer.class);
        fggrouprole.setGroupVersionID(GROUP_VERSION_ID);
        Integer ROLE_ID = rs.getObject(COL_ROLE_ID, Integer.class);
        fggrouprole.setRoleID(ROLE_ID);
        if (ROLE_ID != null) {
            FgRole role = new FgRole();
            role.setFgRoleID(ROLE_ID);
            fggrouprole.setRole(role);
        }
        Integer ROLE_VERSION_ID = rs.getObject(COL_ROLE_VERSION_ID, Integer.class);
        fggrouprole.setRoleVersionID(ROLE_VERSION_ID);
        if (ROLE_VERSION_ID != null) {
            FgRole roleVersion = new FgRole();
            roleVersion.setFgRoleID(ROLE_VERSION_ID);
            fggrouprole.setRoleVersion(roleVersion);
        }
        fggrouprole.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fggrouprole.setStatusCode(rs.getString(COL_STATUS_CODE));
        fggrouprole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fggrouprole.setCreatedBy(CREATED_BY);
        fggrouprole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fggrouprole.setLastUpdatedBy(LAST_UPDATED_BY);
        fggrouprole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fggrouprole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fggrouprole;
    }
}
