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

public class JdbcFgPartyOrgMembershipDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyOrgMembershipDao.class);

    private static final String TABLE = "FG_PARTY_ORG_MEMBERSHIP";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_MEMBER_CAT_CODE = "MEMBER_CAT_CODE";

    private static final String COL_MEMBER_TYPE_CODE = "MEMBER_TYPE_CODE";

    private static final String COL_MEMBER_SUB_TYPE_CODE = "MEMBER_SUB_TYPE_CODE";

    private static final String COL_PARTY_USER_ID = "PARTY_USER_ID";

    private static final String COL_PARTY_USER_VERSION_ID = "PARTY_USER_VERSION_ID";

    private static final String COL_USER_LOGIN_ID = "USER_LOGIN_ID";

    private static final String COL_NAME = "NAME";

    private static final String COL_AGE = "AGE";

    private static final String COL_ADDRESS = "ADDRESS";

    private static final String COL_QUALIFICATION = "QUALIFICATION";

    private static final String COL_DESIGNATION_CODE = "DESIGNATION_CODE";

    private static final String COL_TITLE_CODE = "TITLE_CODE";

    private static final String COL_NET_WORTH = "NET_WORTH";

    private static final String COL_RELATIONSHIP_CODE = "RELATIONSHIP_CODE";

    private static final String COL_SHARE_HOLDING_CODE = "SHARE_HOLDING_CODE";

    private static final String COL_SHARE_PERCENTAGE = "SHARE_PERCENTAGE";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_USER_SUB_TYPE_CODE = "USER_SUB_TYPE_CODE";

    private static final String COL_EMAIL_ID = "EMAIL_ID";

    private static final String COL_PHONE_NO = "PHONE_NO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_MEMBER_CAT_CODE, COL_MEMBER_TYPE_CODE, COL_MEMBER_SUB_TYPE_CODE, COL_PARTY_USER_ID, COL_PARTY_USER_VERSION_ID, COL_USER_LOGIN_ID, COL_NAME, COL_AGE, COL_ADDRESS, COL_QUALIFICATION, COL_DESIGNATION_CODE, COL_TITLE_CODE, COL_NET_WORTH, COL_RELATIONSHIP_CODE, COL_SHARE_HOLDING_CODE, COL_SHARE_PERCENTAGE, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_USER_SUB_TYPE_CODE, COL_EMAIL_ID, COL_PHONE_NO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, MEMBER_CAT_CODE, MEMBER_TYPE_CODE, MEMBER_SUB_TYPE_CODE, PARTY_USER_ID, PARTY_USER_VERSION_ID, USER_LOGIN_ID, NAME, AGE, ADDRESS, QUALIFICATION, DESIGNATION_CODE, TITLE_CODE, NET_WORTH, RELATIONSHIP_CODE, SHARE_HOLDING_CODE, SHARE_PERCENTAGE, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, USER_SUB_TYPE_CODE, EMAIL_ID, PHONE_NO", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, MEMBER_CAT_CODE, MEMBER_TYPE_CODE, MEMBER_SUB_TYPE_CODE, PARTY_USER_ID, PARTY_USER_VERSION_ID, USER_LOGIN_ID, NAME, AGE, ADDRESS, QUALIFICATION, DESIGNATION_CODE, TITLE_CODE, NET_WORTH, RELATIONSHIP_CODE, SHARE_HOLDING_CODE, SHARE_PERCENTAGE, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, USER_SUB_TYPE_CODE, EMAIL_ID, PHONE_NO", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_MEMBER_CAT_CODE, COL_MEMBER_TYPE_CODE, COL_MEMBER_SUB_TYPE_CODE, COL_PARTY_USER_ID, COL_PARTY_USER_VERSION_ID, COL_USER_LOGIN_ID, COL_NAME, COL_AGE, COL_ADDRESS, COL_QUALIFICATION, COL_DESIGNATION_CODE, COL_TITLE_CODE, COL_NET_WORTH, COL_RELATIONSHIP_CODE, COL_SHARE_HOLDING_CODE, COL_SHARE_PERCENTAGE, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_USER_SUB_TYPE_CODE, COL_EMAIL_ID, COL_PHONE_NO, COL_ID);

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

    public int insert(Connection conn, FgPartyOrgMembership fgpartyorgmembership) throws SQLException {
        logger.debug("Inserting fgpartyorgmembership: {}", fgpartyorgmembership);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyOrgMembershipParams(ps, fgpartyorgmembership);
            ps.executeUpdate();
            return fgpartyorgmembership.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyOrgMembership> fgpartyorgmemberships) throws SQLException {
        if (fgpartyorgmemberships == null || fgpartyorgmemberships.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyorgmemberships.size(); i++) {
            if (fgpartyorgmemberships.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyOrgMembership>> batches = chunkList(fgpartyorgmemberships, batchSize);
        int[] totalResults = new int[fgpartyorgmemberships.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyOrgMembership> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyOrgMembership fgpartyorgmembership : batch) {
                        setFgPartyOrgMembershipParams(ps, fgpartyorgmembership);
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

    public FgPartyOrgMembership findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyOrgMembership> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyOrgMembership> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyOrgMembership fgpartyorgmembership) throws SQLException {
        if (fgpartyorgmembership.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyOrgMembershipParams(ps, fgpartyorgmembership);
            ps.setInt(33, fgpartyorgmembership.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyOrgMembership> fgpartyorgmemberships) throws SQLException {
        if (fgpartyorgmemberships == null || fgpartyorgmemberships.isEmpty())
            return new int[0];
        for (FgPartyOrgMembership fgpartyorgmembership : fgpartyorgmemberships) {
            if (fgpartyorgmembership == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyorgmembership.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyOrgMembership>> batches = chunkList(fgpartyorgmemberships, batchSize);
        int[] totalResults = new int[fgpartyorgmemberships.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyOrgMembership> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyOrgMembership fgpartyorgmembership : batch) {
                        setFgPartyOrgMembershipParams(ps, fgpartyorgmembership);
                        ps.setInt(33, fgpartyorgmembership.getID());
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

    private void setFgPartyOrgMembershipParams(PreparedStatement ps, FgPartyOrgMembership fgpartyorgmembership) throws SQLException {
        Integer val1 = fgpartyorgmembership.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpartyorgmembership.getPartyID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgpartyorgmembership.getPartyVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgpartyorgmembership.getPartySubTypeCode());
        ps.setString(5, fgpartyorgmembership.getPartyCode());
        ps.setString(6, fgpartyorgmembership.getMemberCatCode());
        ps.setString(7, fgpartyorgmembership.getMemberTypeCode());
        ps.setString(8, fgpartyorgmembership.getMemberSubTypeCode());
        Integer val9 = fgpartyorgmembership.getPartyUserID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        Integer val10 = fgpartyorgmembership.getPartyUserVersionID();
        if (val10 != null) {
            ps.setInt(10, val10);
        } else {
            ps.setNull(10, Types.INTEGER);
        }
        Integer val11 = fgpartyorgmembership.getUserLoginID();
        if (val11 != null) {
            ps.setInt(11, val11);
        } else {
            ps.setNull(11, Types.INTEGER);
        }
        ps.setString(12, fgpartyorgmembership.getName());
        java.math.BigDecimal val13 = fgpartyorgmembership.getAge();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartyorgmembership.getAddress());
        ps.setString(15, fgpartyorgmembership.getQualification());
        ps.setString(16, fgpartyorgmembership.getDesignationCode());
        ps.setString(17, fgpartyorgmembership.getTitleCode());
        ps.setString(18, fgpartyorgmembership.getNetWorth());
        ps.setString(19, fgpartyorgmembership.getRelationshipCode());
        ps.setString(20, fgpartyorgmembership.getShareHoldingCode());
        ps.setString(21, fgpartyorgmembership.getSharePercentage());
        ps.setString(22, fgpartyorgmembership.getComments());
        ps.setString(23, fgpartyorgmembership.getActiveCode());
        ps.setString(24, fgpartyorgmembership.getStatusCode());
        ps.setString(25, fgpartyorgmembership.getCreatedOn());
        java.math.BigDecimal val26 = fgpartyorgmembership.getCreatedBy();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgpartyorgmembership.getLastUpdatedOn());
        java.math.BigDecimal val28 = fgpartyorgmembership.getLastUpdatedBy();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, fgpartyorgmembership.getLastAuthorisedOn());
        java.math.BigDecimal val30 = fgpartyorgmembership.getLastAuthorisedBy();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgpartyorgmembership.getUserSubTypeCode());
        Integer val32 = fgpartyorgmembership.getEmailID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        ps.setString(33, fgpartyorgmembership.getPhoneNo());
    }

    private FgPartyOrgMembership extract(ResultSet rs) throws SQLException {
        FgPartyOrgMembership fgpartyorgmembership = new FgPartyOrgMembership();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyorgmembership.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyorgmembership.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyorgmembership.setPartyVersionID(PARTY_VERSION_ID);
        fgpartyorgmembership.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgpartyorgmembership.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgpartyorgmembership.setMemberCatCode(rs.getString(COL_MEMBER_CAT_CODE));
        fgpartyorgmembership.setMemberTypeCode(rs.getString(COL_MEMBER_TYPE_CODE));
        fgpartyorgmembership.setMemberSubTypeCode(rs.getString(COL_MEMBER_SUB_TYPE_CODE));
        Integer PARTY_USER_ID = rs.getObject(COL_PARTY_USER_ID, Integer.class);
        fgpartyorgmembership.setPartyUserID(PARTY_USER_ID);
        Integer PARTY_USER_VERSION_ID = rs.getObject(COL_PARTY_USER_VERSION_ID, Integer.class);
        fgpartyorgmembership.setPartyUserVersionID(PARTY_USER_VERSION_ID);
        Integer USER_LOGIN_ID = rs.getObject(COL_USER_LOGIN_ID, Integer.class);
        fgpartyorgmembership.setUserLoginID(USER_LOGIN_ID);
        fgpartyorgmembership.setName(rs.getString(COL_NAME));
        java.math.BigDecimal AGE = rs.getObject(COL_AGE, java.math.BigDecimal.class);
        fgpartyorgmembership.setAge(AGE);
        fgpartyorgmembership.setAddress(rs.getString(COL_ADDRESS));
        fgpartyorgmembership.setQualification(rs.getString(COL_QUALIFICATION));
        fgpartyorgmembership.setDesignationCode(rs.getString(COL_DESIGNATION_CODE));
        fgpartyorgmembership.setTitleCode(rs.getString(COL_TITLE_CODE));
        fgpartyorgmembership.setNetWorth(rs.getString(COL_NET_WORTH));
        fgpartyorgmembership.setRelationshipCode(rs.getString(COL_RELATIONSHIP_CODE));
        fgpartyorgmembership.setShareHoldingCode(rs.getString(COL_SHARE_HOLDING_CODE));
        fgpartyorgmembership.setSharePercentage(rs.getString(COL_SHARE_PERCENTAGE));
        fgpartyorgmembership.setComments(rs.getString(COL_COMMENTS));
        fgpartyorgmembership.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyorgmembership.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyorgmembership.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyorgmembership.setCreatedBy(CREATED_BY);
        fgpartyorgmembership.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyorgmembership.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyorgmembership.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyorgmembership.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyorgmembership.setUserSubTypeCode(rs.getString(COL_USER_SUB_TYPE_CODE));
        Integer EMAIL_ID = rs.getObject(COL_EMAIL_ID, Integer.class);
        fgpartyorgmembership.setEmailID(EMAIL_ID);
        fgpartyorgmembership.setPhoneNo(rs.getString(COL_PHONE_NO));
        return fgpartyorgmembership;
    }
}
