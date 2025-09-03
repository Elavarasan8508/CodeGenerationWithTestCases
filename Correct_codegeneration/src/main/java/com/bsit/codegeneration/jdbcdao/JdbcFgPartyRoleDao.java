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

public class JdbcFgPartyRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyRoleDao.class);

    private static final String TABLE = "FG_PARTY_ROLE";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_ROLE_ID = "ROLE_ID";

    private static final String COL_ROLE_VERSION_ID = "ROLE_VERSION_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_PARTY_VERSION_ID);

    private static final String SELECT_BY_ROLE_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ROLE_VERSION_ID);

    private static final String SELECT_BY_ROLE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ROLE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ROLE_ID, COL_ROLE_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgPartyRole fgpartyrole) throws SQLException {
        logger.debug("Inserting fgpartyrole: {}", fgpartyrole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyRoleParams(ps, fgpartyrole);
            ps.executeUpdate();
            return fgpartyrole.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyRole> fgpartyroles) throws SQLException {
        if (fgpartyroles == null || fgpartyroles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyroles.size(); i++) {
            if (fgpartyroles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRole>> batches = chunkList(fgpartyroles, batchSize);
        int[] totalResults = new int[fgpartyroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyRole fgpartyrole : batch) {
                        setFgPartyRoleParams(ps, fgpartyrole);
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

    public FgPartyRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyRole fgpartyrole) throws SQLException {
        if (fgpartyrole.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyRoleParams(ps, fgpartyrole);
            ps.setInt(13, fgpartyrole.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyRole> fgpartyroles) throws SQLException {
        if (fgpartyroles == null || fgpartyroles.isEmpty())
            return new int[0];
        for (FgPartyRole fgpartyrole : fgpartyroles) {
            if (fgpartyrole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyrole.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRole>> batches = chunkList(fgpartyroles, batchSize);
        int[] totalResults = new int[fgpartyroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyRole fgpartyrole : batch) {
                        setFgPartyRoleParams(ps, fgpartyrole);
                        ps.setInt(13, fgpartyrole.getID());
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

    public List<FgPartyRole> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgPartyRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PARTY_ID_SQL)) {
            ps.setInt(1, partyID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyRole> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgPartyRole> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PARTY_VERSION_ID_SQL)) {
            ps.setInt(1, partyVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyRole> findByRoleVersionID(Connection conn, int roleVersionID) throws SQLException {
        List<FgPartyRole> list = new ArrayList<>();
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

    public List<FgPartyRole> findByRoleID(Connection conn, int roleID) throws SQLException {
        List<FgPartyRole> list = new ArrayList<>();
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

    private void setFgPartyRoleParams(PreparedStatement ps, FgPartyRole fgpartyrole) throws SQLException {
        Integer val1 = fgpartyrole.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (fgpartyrole.getParty() != null) {
            ps.setInt(2, fgpartyrole.getParty().getFgPartyID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        if (fgpartyrole.getPartyVersion() != null) {
            ps.setInt(3, fgpartyrole.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (fgpartyrole.getRole() != null) {
            ps.setInt(4, fgpartyrole.getRole().getFgRoleID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (fgpartyrole.getRoleVersion() != null) {
            ps.setInt(5, fgpartyrole.getRoleVersion().getFgRoleID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgpartyrole.getActiveCode());
        ps.setString(7, fgpartyrole.getStatusCode());
        ps.setString(8, fgpartyrole.getCreatedOn());
        java.math.BigDecimal val9 = fgpartyrole.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpartyrole.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgpartyrole.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = fgpartyrole.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgpartyrole.getLastAuthorisedOn());
    }

    private FgPartyRole extract(ResultSet rs) throws SQLException {
        FgPartyRole fgpartyrole = new FgPartyRole();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyrole.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyrole.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fgpartyrole.setParty(party);
        }
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyrole.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fgpartyrole.setPartyVersion(partyVersion);
        }
        Integer ROLE_ID = rs.getObject(COL_ROLE_ID, Integer.class);
        fgpartyrole.setRoleID(ROLE_ID);
        if (ROLE_ID != null) {
            FgRole role = new FgRole();
            role.setFgRoleID(ROLE_ID);
            fgpartyrole.setRole(role);
        }
        Integer ROLE_VERSION_ID = rs.getObject(COL_ROLE_VERSION_ID, Integer.class);
        fgpartyrole.setRoleVersionID(ROLE_VERSION_ID);
        if (ROLE_VERSION_ID != null) {
            FgRole roleVersion = new FgRole();
            roleVersion.setFgRoleID(ROLE_VERSION_ID);
            fgpartyrole.setRoleVersion(roleVersion);
        }
        fgpartyrole.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyrole.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyrole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyrole.setCreatedBy(CREATED_BY);
        fgpartyrole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyrole.setLastUpdatedBy(LAST_UPDATED_BY);
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyrole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyrole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgpartyrole;
    }
}
