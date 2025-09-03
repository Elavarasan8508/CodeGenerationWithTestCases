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

public class JdbcFgRolePermissionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgRolePermissionDao.class);

    private static final String TABLE = "FG_ROLE_PERMISSION";

    private static final String COL_ID = "ID";

    private static final String COL_PERMISSION_ID = "PERMISSION_ID";

    private static final String COL_ROLE_ID = "ROLE_ID";

    private static final String COL_ROLE_VERSION_ID = "ROLE_VERSION_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PERMISSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_PERMISSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_PERMISSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PERMISSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgRolePermission fgrolepermission) throws SQLException {
        logger.debug("Inserting fgrolepermission: {}", fgrolepermission);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgRolePermissionParams(ps, fgrolepermission);
            ps.executeUpdate();
            return fgrolepermission.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgRolePermission> fgrolepermissions) throws SQLException {
        if (fgrolepermissions == null || fgrolepermissions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgrolepermissions.size(); i++) {
            if (fgrolepermissions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRolePermission>> batches = chunkList(fgrolepermissions, batchSize);
        int[] totalResults = new int[fgrolepermissions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRolePermission> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgRolePermission fgrolepermission : batch) {
                        setFgRolePermissionParams(ps, fgrolepermission);
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

    public FgRolePermission findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgRolePermission> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgRolePermission> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgRolePermission fgrolepermission) throws SQLException {
        if (fgrolepermission.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgRolePermissionParams(ps, fgrolepermission);
            ps.setInt(12, fgrolepermission.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgRolePermission> fgrolepermissions) throws SQLException {
        if (fgrolepermissions == null || fgrolepermissions.isEmpty())
            return new int[0];
        for (FgRolePermission fgrolepermission : fgrolepermissions) {
            if (fgrolepermission == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgrolepermission.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRolePermission>> batches = chunkList(fgrolepermissions, batchSize);
        int[] totalResults = new int[fgrolepermissions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRolePermission> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgRolePermission fgrolepermission : batch) {
                        setFgRolePermissionParams(ps, fgrolepermission);
                        ps.setInt(12, fgrolepermission.getID());
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

    public List<FgRolePermission> findByPermissionID(Connection conn, int permissionID) throws SQLException {
        List<FgRolePermission> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PERMISSION_ID_SQL)) {
            ps.setInt(1, permissionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgRolePermissionParams(PreparedStatement ps, FgRolePermission fgrolepermission) throws SQLException {
        Integer val1 = fgrolepermission.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (fgrolepermission.getPermission() != null) {
            ps.setInt(2, fgrolepermission.getPermission().getFgPermissionID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgrolepermission.getRoleID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = fgrolepermission.getRoleVersionID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgrolepermission.getActiveCode());
        ps.setString(6, fgrolepermission.getStatusCode());
        ps.setString(7, fgrolepermission.getCreatedOn());
        java.math.BigDecimal val8 = fgrolepermission.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = fgrolepermission.getLastUpdatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgrolepermission.getLastUpdatedOn());
        ps.setString(11, fgrolepermission.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgrolepermission.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
    }

    private FgRolePermission extract(ResultSet rs) throws SQLException {
        FgRolePermission fgrolepermission = new FgRolePermission();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgrolepermission.setID(ID);
        Integer PERMISSION_ID = rs.getObject(COL_PERMISSION_ID, Integer.class);
        fgrolepermission.setPermissionID(PERMISSION_ID);
        if (PERMISSION_ID != null) {
            FgPermission permission = new FgPermission();
            permission.setFgPermissionID(PERMISSION_ID);
            fgrolepermission.setPermission(permission);
        }
        Integer ROLE_ID = rs.getObject(COL_ROLE_ID, Integer.class);
        fgrolepermission.setRoleID(ROLE_ID);
        Integer ROLE_VERSION_ID = rs.getObject(COL_ROLE_VERSION_ID, Integer.class);
        fgrolepermission.setRoleVersionID(ROLE_VERSION_ID);
        fgrolepermission.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgrolepermission.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgrolepermission.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgrolepermission.setCreatedBy(CREATED_BY);
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgrolepermission.setLastUpdatedBy(LAST_UPDATED_BY);
        fgrolepermission.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        fgrolepermission.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgrolepermission.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgrolepermission;
    }
}
