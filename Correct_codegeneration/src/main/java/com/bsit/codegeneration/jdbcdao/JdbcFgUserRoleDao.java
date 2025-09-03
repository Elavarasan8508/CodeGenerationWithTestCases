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

public class JdbcFgUserRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgUserRoleDao.class);

    private static final String TABLE = "FG_USER_ROLE";

    private static final String COL_ID = "ID";

    private static final String COL_ROLE_ID = "ROLE_ID";

    private static final String COL_ROLE_VERSION_ID = "ROLE_VERSION_ID";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_USER_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_USER_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_USER_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_USER_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgUserRole fguserrole) throws SQLException {
        logger.debug("Inserting fguserrole: {}", fguserrole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgUserRoleParams(ps, fguserrole);
            ps.executeUpdate();
            return fguserrole.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgUserRole> fguserroles) throws SQLException {
        if (fguserroles == null || fguserroles.isEmpty())
            return new int[0];
        for (int i = 0; i < fguserroles.size(); i++) {
            if (fguserroles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUserRole>> batches = chunkList(fguserroles, batchSize);
        int[] totalResults = new int[fguserroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUserRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgUserRole fguserrole : batch) {
                        setFgUserRoleParams(ps, fguserrole);
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

    public FgUserRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgUserRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgUserRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgUserRole fguserrole) throws SQLException {
        if (fguserrole.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgUserRoleParams(ps, fguserrole);
            ps.setInt(12, fguserrole.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgUserRole> fguserroles) throws SQLException {
        if (fguserroles == null || fguserroles.isEmpty())
            return new int[0];
        for (FgUserRole fguserrole : fguserroles) {
            if (fguserrole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fguserrole.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUserRole>> batches = chunkList(fguserroles, batchSize);
        int[] totalResults = new int[fguserroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUserRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgUserRole fguserrole : batch) {
                        setFgUserRoleParams(ps, fguserrole);
                        ps.setInt(12, fguserrole.getID());
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

    public List<FgUserRole> findByUserID(Connection conn, int userID) throws SQLException {
        List<FgUserRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_USER_ID_SQL)) {
            ps.setInt(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgUserRoleParams(PreparedStatement ps, FgUserRole fguserrole) throws SQLException {
        Integer val1 = fguserrole.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fguserrole.getRoleID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fguserrole.getRoleVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (fguserrole.getUser() != null) {
            ps.setInt(4, fguserrole.getUser().getFgUserID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fguserrole.getActiveCode());
        ps.setString(6, fguserrole.getStatusCode());
        ps.setString(7, fguserrole.getCreatedOn());
        java.math.BigDecimal val8 = fguserrole.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fguserrole.getLastUpdatedOn());
        java.math.BigDecimal val10 = fguserrole.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fguserrole.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fguserrole.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
    }

    private FgUserRole extract(ResultSet rs) throws SQLException {
        FgUserRole fguserrole = new FgUserRole();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fguserrole.setID(ID);
        Integer ROLE_ID = rs.getObject(COL_ROLE_ID, Integer.class);
        fguserrole.setRoleID(ROLE_ID);
        Integer ROLE_VERSION_ID = rs.getObject(COL_ROLE_VERSION_ID, Integer.class);
        fguserrole.setRoleVersionID(ROLE_VERSION_ID);
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        fguserrole.setUserID(USER_ID);
        if (USER_ID != null) {
            FgUser user = new FgUser();
            user.setFgUserID(USER_ID);
            fguserrole.setUser(user);
        }
        fguserrole.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fguserrole.setStatusCode(rs.getString(COL_STATUS_CODE));
        fguserrole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fguserrole.setCreatedBy(CREATED_BY);
        fguserrole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fguserrole.setLastUpdatedBy(LAST_UPDATED_BY);
        fguserrole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fguserrole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fguserrole;
    }
}
