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

public class JdbcFgPartyProfileDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyProfileDao.class);

    private static final String TABLE = "FG_PARTY_PROFILE";

    private static final String COL_ID = "ID";

    private static final String COL_ORG_ID = "ORG_ID";

    private static final String COL_ORG_VERSION_ID = "ORG_VERSION_ID";

    private static final String COL_ORG_CODE = "ORG_CODE";

    private static final String COL_PROFILE_TYPE_CODE = "PROFILE_TYPE_CODE";

    private static final String COL_PROFILE_TEXT = "PROFILE_TEXT";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_USER_VERSION_ID = "USER_VERSION_ID";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_AUTH_STATUS_CODE = "AUTH_STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ORG_ID, COL_ORG_VERSION_ID, COL_ORG_CODE, COL_PROFILE_TYPE_CODE, COL_PROFILE_TEXT, COL_TEMPLATE, COL_USER_ID, COL_USER_VERSION_ID, COL_STATUS_CODE, COL_AUTH_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_ORG_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ORG_ID);

    private static final String SELECT_BY_ORG_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ORG_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ORG_ID, COL_ORG_VERSION_ID, COL_ORG_CODE, COL_PROFILE_TYPE_CODE, COL_PROFILE_TEXT, COL_TEMPLATE, COL_USER_ID, COL_USER_VERSION_ID, COL_STATUS_CODE, COL_AUTH_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgPartyProfile fgpartyprofile) throws SQLException {
        logger.debug("Inserting fgpartyprofile: {}", fgpartyprofile);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyProfileParams(ps, fgpartyprofile);
            ps.executeUpdate();
            return fgpartyprofile.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyProfile> fgpartyprofiles) throws SQLException {
        if (fgpartyprofiles == null || fgpartyprofiles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyprofiles.size(); i++) {
            if (fgpartyprofiles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyProfile>> batches = chunkList(fgpartyprofiles, batchSize);
        int[] totalResults = new int[fgpartyprofiles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyProfile> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyProfile fgpartyprofile : batch) {
                        setFgPartyProfileParams(ps, fgpartyprofile);
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

    public FgPartyProfile findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyProfile> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyProfile> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyProfile fgpartyprofile) throws SQLException {
        if (fgpartyprofile.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyProfileParams(ps, fgpartyprofile);
            ps.setInt(17, fgpartyprofile.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyProfile> fgpartyprofiles) throws SQLException {
        if (fgpartyprofiles == null || fgpartyprofiles.isEmpty())
            return new int[0];
        for (FgPartyProfile fgpartyprofile : fgpartyprofiles) {
            if (fgpartyprofile == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyprofile.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyProfile>> batches = chunkList(fgpartyprofiles, batchSize);
        int[] totalResults = new int[fgpartyprofiles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyProfile> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyProfile fgpartyprofile : batch) {
                        setFgPartyProfileParams(ps, fgpartyprofile);
                        ps.setInt(17, fgpartyprofile.getID());
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

    public List<FgPartyProfile> findByOrgID(Connection conn, int orgID) throws SQLException {
        List<FgPartyProfile> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ORG_ID_SQL)) {
            ps.setInt(1, orgID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyProfile> findByOrgVersionID(Connection conn, int orgVersionID) throws SQLException {
        List<FgPartyProfile> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ORG_VERSION_ID_SQL)) {
            ps.setInt(1, orgVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgPartyProfileParams(PreparedStatement ps, FgPartyProfile fgpartyprofile) throws SQLException {
        Integer val1 = fgpartyprofile.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (fgpartyprofile.getOrg() != null) {
            ps.setInt(2, fgpartyprofile.getOrg().getFgPartyID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        if (fgpartyprofile.getOrgVersion() != null) {
            ps.setInt(3, fgpartyprofile.getOrgVersion().getFgPartyID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgpartyprofile.getOrgCode());
        ps.setString(5, fgpartyprofile.getProfileTypeCode());
        ps.setString(6, fgpartyprofile.getProfileText());
        ps.setString(7, fgpartyprofile.getTemplate());
        Integer val8 = fgpartyprofile.getUserID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        Integer val9 = fgpartyprofile.getUserVersionID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, fgpartyprofile.getStatusCode());
        ps.setString(11, fgpartyprofile.getAuthStatusCode());
        ps.setString(12, fgpartyprofile.getCreatedOn());
        java.math.BigDecimal val13 = fgpartyprofile.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartyprofile.getLastUpdatedOn());
        java.math.BigDecimal val15 = fgpartyprofile.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpartyprofile.getLastAuthorisedOn());
        java.math.BigDecimal val17 = fgpartyprofile.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
    }

    private FgPartyProfile extract(ResultSet rs) throws SQLException {
        FgPartyProfile fgpartyprofile = new FgPartyProfile();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyprofile.setID(ID);
        Integer ORG_ID = rs.getObject(COL_ORG_ID, Integer.class);
        fgpartyprofile.setOrgID(ORG_ID);
        if (ORG_ID != null) {
            FgParty org = new FgParty();
            org.setFgPartyID(ORG_ID);
            fgpartyprofile.setOrg(org);
        }
        Integer ORG_VERSION_ID = rs.getObject(COL_ORG_VERSION_ID, Integer.class);
        fgpartyprofile.setOrgVersionID(ORG_VERSION_ID);
        if (ORG_VERSION_ID != null) {
            FgParty orgVersion = new FgParty();
            orgVersion.setFgPartyID(ORG_VERSION_ID);
            fgpartyprofile.setOrgVersion(orgVersion);
        }
        fgpartyprofile.setOrgCode(rs.getString(COL_ORG_CODE));
        fgpartyprofile.setProfileTypeCode(rs.getString(COL_PROFILE_TYPE_CODE));
        fgpartyprofile.setProfileText(rs.getString(COL_PROFILE_TEXT));
        fgpartyprofile.setTemplate(rs.getString(COL_TEMPLATE));
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        fgpartyprofile.setUserID(USER_ID);
        Integer USER_VERSION_ID = rs.getObject(COL_USER_VERSION_ID, Integer.class);
        fgpartyprofile.setUserVersionID(USER_VERSION_ID);
        fgpartyprofile.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyprofile.setAuthStatusCode(rs.getString(COL_AUTH_STATUS_CODE));
        fgpartyprofile.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyprofile.setCreatedBy(CREATED_BY);
        fgpartyprofile.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyprofile.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyprofile.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyprofile.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgpartyprofile;
    }
}
