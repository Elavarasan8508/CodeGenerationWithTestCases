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

public class JdbcFgUserDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgUserDao.class);

    private static final String TABLE = "FG_USER";

    private static final String COL_ID = "ID";

    private static final String COL_USER_PASSWORD = "USER_PASSWORD";

    private static final String COL_USER_SECRET = "USER_SECRET";

    private static final String COL_USER_TYPE_CODE = "USER_TYPE_CODE";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_IS_USING_2FA = "IS_USING_2FA";

    private static final String COL_FIRST_TIME_LOGIN = "FIRST_TIME_LOGIN";

    private static final String COL_LOGIN_ATTEMPTS = "LOGIN_ATTEMPTS";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_IS_AUTHORISE_OWN_TNX = "IS_AUTHORISE_OWN_TNX";

    private static final String COL_LAST_LOGIN_TIME = "LAST_LOGIN_TIME";

    private static final String COL_CURRENT_LOGIN_TIME = "CURRENT_LOGIN_TIME";

    private static final String COL_LAST_LOGOUT_TIME = "LAST_LOGOUT_TIME";

    private static final String COL_CURR_SESSION_ID = "CURR_SESSION_ID";

    private static final String COL_LAST_SESSION_ID = "LAST_SESSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_USER_PASSWORD, COL_USER_SECRET, COL_USER_TYPE_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_IS_USING_2FA, COL_FIRST_TIME_LOGIN, COL_LOGIN_ATTEMPTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_USER_ID, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_AUTHORISE_OWN_TNX, COL_LAST_LOGIN_TIME, COL_CURRENT_LOGIN_TIME, COL_LAST_LOGOUT_TIME, COL_CURR_SESSION_ID, COL_LAST_SESSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID", TABLE, COL_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID", TABLE, COL_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_USER_PASSWORD, COL_USER_SECRET, COL_USER_TYPE_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_IS_USING_2FA, COL_FIRST_TIME_LOGIN, COL_LOGIN_ATTEMPTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_USER_ID, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_AUTHORISE_OWN_TNX, COL_LAST_LOGIN_TIME, COL_CURRENT_LOGIN_TIME, COL_LAST_LOGOUT_TIME, COL_CURR_SESSION_ID, COL_LAST_SESSION_ID, COL_ID);

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

    public int insert(Connection conn, FgUser fguser) throws SQLException {
        logger.debug("Inserting fguser: {}", fguser);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgUserParams(ps, fguser);
            ps.executeUpdate();
            return fguser.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgUser> fgusers) throws SQLException {
        if (fgusers == null || fgusers.isEmpty())
            return new int[0];
        for (int i = 0; i < fgusers.size(); i++) {
            if (fgusers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUser>> batches = chunkList(fgusers, batchSize);
        int[] totalResults = new int[fgusers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUser> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgUser fguser : batch) {
                        setFgUserParams(ps, fguser);
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

    public FgUser findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgUser> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgUser> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgUser fguser) throws SQLException {
        if (fguser.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgUserParams(ps, fguser);
            ps.setInt(24, fguser.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgUser> fgusers) throws SQLException {
        if (fgusers == null || fgusers.isEmpty())
            return new int[0];
        for (FgUser fguser : fgusers) {
            if (fguser == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fguser.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUser>> batches = chunkList(fgusers, batchSize);
        int[] totalResults = new int[fgusers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUser> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgUser fguser : batch) {
                        setFgUserParams(ps, fguser);
                        ps.setInt(24, fguser.getID());
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

    public List<FgUser> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgUser> list = new ArrayList<>();
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

    public List<FgUser> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgUser> list = new ArrayList<>();
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

    private void setFgUserParams(PreparedStatement ps, FgUser fguser) throws SQLException {
        Integer val1 = fguser.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fguser.getUserPassword());
        ps.setString(3, fguser.getUserSecret());
        ps.setString(4, fguser.getUserTypeCode());
        if (fguser.getParty() != null) {
            ps.setInt(5, fguser.getParty().getFgPartyID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        if (fguser.getPartyVersion() != null) {
            ps.setInt(6, fguser.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        java.math.BigDecimal val7 = fguser.getIsUsing2fa();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = fguser.getFirstTimeLogin();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = fguser.getLoginAttempts();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fguser.getActiveCode());
        ps.setString(11, fguser.getStatusCode());
        ps.setString(12, fguser.getCreatedOn());
        java.math.BigDecimal val13 = fguser.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fguser.getLastUpdatedOn());
        java.math.BigDecimal val15 = fguser.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fguser.getUserID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, fguser.getLastAuthorisedOn());
        java.math.BigDecimal val18 = fguser.getLastAuthorisedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fguser.getIsAuthoriseOwnTnx();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fguser.getLastLoginTime());
        ps.setString(21, fguser.getCurrentLoginTime());
        ps.setString(22, fguser.getLastLogoutTime());
        Integer val23 = fguser.getCurrSessionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fguser.getLastSessionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
    }

    private FgUser extract(ResultSet rs) throws SQLException {
        FgUser fguser = new FgUser();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fguser.setID(ID);
        fguser.setUserPassword(rs.getString(COL_USER_PASSWORD));
        fguser.setUserSecret(rs.getString(COL_USER_SECRET));
        fguser.setUserTypeCode(rs.getString(COL_USER_TYPE_CODE));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fguser.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fguser.setParty(party);
        }
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fguser.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fguser.setPartyVersion(partyVersion);
        }
        java.math.BigDecimal IS_USING_2FA = rs.getObject(COL_IS_USING_2FA, java.math.BigDecimal.class);
        fguser.setIsUsing2fa(IS_USING_2FA);
        java.math.BigDecimal FIRST_TIME_LOGIN = rs.getObject(COL_FIRST_TIME_LOGIN, java.math.BigDecimal.class);
        fguser.setFirstTimeLogin(FIRST_TIME_LOGIN);
        java.math.BigDecimal LOGIN_ATTEMPTS = rs.getObject(COL_LOGIN_ATTEMPTS, java.math.BigDecimal.class);
        fguser.setLoginAttempts(LOGIN_ATTEMPTS);
        fguser.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fguser.setStatusCode(rs.getString(COL_STATUS_CODE));
        fguser.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fguser.setCreatedBy(CREATED_BY);
        fguser.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fguser.setLastUpdatedBy(LAST_UPDATED_BY);
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        fguser.setUserID(USER_ID);
        fguser.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fguser.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        java.math.BigDecimal IS_AUTHORISE_OWN_TNX = rs.getObject(COL_IS_AUTHORISE_OWN_TNX, java.math.BigDecimal.class);
        fguser.setIsAuthoriseOwnTnx(IS_AUTHORISE_OWN_TNX);
        fguser.setLastLoginTime(rs.getString(COL_LAST_LOGIN_TIME));
        fguser.setCurrentLoginTime(rs.getString(COL_CURRENT_LOGIN_TIME));
        fguser.setLastLogoutTime(rs.getString(COL_LAST_LOGOUT_TIME));
        Integer CURR_SESSION_ID = rs.getObject(COL_CURR_SESSION_ID, Integer.class);
        fguser.setCurrSessionID(CURR_SESSION_ID);
        Integer LAST_SESSION_ID = rs.getObject(COL_LAST_SESSION_ID, Integer.class);
        fguser.setLastSessionID(LAST_SESSION_ID);
        return fguser;
    }
}
