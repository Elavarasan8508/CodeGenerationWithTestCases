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

public class JdbcFgPartyMemberRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyMemberRoleDao.class);

    private static final String TABLE = "FG_PARTY_MEMBER_ROLE";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_REF_ID = "PARTY_REF_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_ROLE_CODE = "ROLE_CODE";

    private static final String COL_EFFECTIVE_FROM = "EFFECTIVE_FROM";

    private static final String COL_EFFECTIVE_TO = "EFFECTIVE_TO";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_SYSTEM_SOURCE_CODE = "SYSTEM_SOURCE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_TYPE_CODE, COL_PARTY_CODE, COL_PARTY_REF_ID, COL_PARTY_VERSION_ID, COL_ROLE_CODE, COL_EFFECTIVE_FROM, COL_EFFECTIVE_TO, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SYSTEM_SOURCE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_CODE, PARTY_REF_ID, PARTY_VERSION_ID, ROLE_CODE, EFFECTIVE_FROM, EFFECTIVE_TO, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_CODE, PARTY_REF_ID, PARTY_VERSION_ID, ROLE_CODE, EFFECTIVE_FROM, EFFECTIVE_TO, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_TYPE_CODE, COL_PARTY_CODE, COL_PARTY_REF_ID, COL_PARTY_VERSION_ID, COL_ROLE_CODE, COL_EFFECTIVE_FROM, COL_EFFECTIVE_TO, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SYSTEM_SOURCE_CODE, COL_ID);

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

    public int insert(Connection conn, FgPartyMemberRole fgpartymemberrole) throws SQLException {
        logger.debug("Inserting fgpartymemberrole: {}", fgpartymemberrole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyMemberRoleParams(ps, fgpartymemberrole);
            ps.executeUpdate();
            return fgpartymemberrole.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyMemberRole> fgpartymemberroles) throws SQLException {
        if (fgpartymemberroles == null || fgpartymemberroles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartymemberroles.size(); i++) {
            if (fgpartymemberroles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyMemberRole>> batches = chunkList(fgpartymemberroles, batchSize);
        int[] totalResults = new int[fgpartymemberroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyMemberRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyMemberRole fgpartymemberrole : batch) {
                        setFgPartyMemberRoleParams(ps, fgpartymemberrole);
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

    public FgPartyMemberRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyMemberRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyMemberRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyMemberRole fgpartymemberrole) throws SQLException {
        if (fgpartymemberrole.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyMemberRoleParams(ps, fgpartymemberrole);
            ps.setInt(18, fgpartymemberrole.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyMemberRole> fgpartymemberroles) throws SQLException {
        if (fgpartymemberroles == null || fgpartymemberroles.isEmpty())
            return new int[0];
        for (FgPartyMemberRole fgpartymemberrole : fgpartymemberroles) {
            if (fgpartymemberrole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartymemberrole.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyMemberRole>> batches = chunkList(fgpartymemberroles, batchSize);
        int[] totalResults = new int[fgpartymemberroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyMemberRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyMemberRole fgpartymemberrole : batch) {
                        setFgPartyMemberRoleParams(ps, fgpartymemberrole);
                        ps.setInt(18, fgpartymemberrole.getID());
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

    private void setFgPartyMemberRoleParams(PreparedStatement ps, FgPartyMemberRole fgpartymemberrole) throws SQLException {
        Integer val1 = fgpartymemberrole.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpartymemberrole.getPartyTypeCode());
        ps.setString(3, fgpartymemberrole.getPartyCode());
        Integer val4 = fgpartymemberrole.getPartyRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgpartymemberrole.getPartyVersionID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgpartymemberrole.getRoleCode());
        java.time.LocalDateTime val7 = fgpartymemberrole.getEffectiveFrom();
        if (val7 != null) {
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(val7));
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val8 = fgpartymemberrole.getEffectiveTo();
        if (val8 != null) {
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(val8));
        } else {
            ps.setNull(8, Types.TIMESTAMP);
        }
        ps.setString(9, fgpartymemberrole.getDescription());
        ps.setString(10, fgpartymemberrole.getActiveCode());
        ps.setString(11, fgpartymemberrole.getStatusCode());
        ps.setString(12, fgpartymemberrole.getCreatedOn());
        java.math.BigDecimal val13 = fgpartymemberrole.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartymemberrole.getLastUpdatedOn());
        java.math.BigDecimal val15 = fgpartymemberrole.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpartymemberrole.getLastAuthorisedOn());
        java.math.BigDecimal val17 = fgpartymemberrole.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgpartymemberrole.getSystemSourceCode());
    }

    private FgPartyMemberRole extract(ResultSet rs) throws SQLException {
        FgPartyMemberRole fgpartymemberrole = new FgPartyMemberRole();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartymemberrole.setID(ID);
        fgpartymemberrole.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgpartymemberrole.setPartyCode(rs.getString(COL_PARTY_CODE));
        Integer PARTY_REF_ID = rs.getObject(COL_PARTY_REF_ID, Integer.class);
        fgpartymemberrole.setPartyRefID(PARTY_REF_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartymemberrole.setPartyVersionID(PARTY_VERSION_ID);
        fgpartymemberrole.setRoleCode(rs.getString(COL_ROLE_CODE));
        Timestamp EFFECTIVE_FROM = rs.getTimestamp(COL_EFFECTIVE_FROM);
        if (EFFECTIVE_FROM != null)
            fgpartymemberrole.setEffectiveFrom(EFFECTIVE_FROM.toLocalDateTime());
        Timestamp EFFECTIVE_TO = rs.getTimestamp(COL_EFFECTIVE_TO);
        if (EFFECTIVE_TO != null)
            fgpartymemberrole.setEffectiveTo(EFFECTIVE_TO.toLocalDateTime());
        fgpartymemberrole.setDescription(rs.getString(COL_DESCRIPTION));
        fgpartymemberrole.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartymemberrole.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartymemberrole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartymemberrole.setCreatedBy(CREATED_BY);
        fgpartymemberrole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartymemberrole.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartymemberrole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartymemberrole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartymemberrole.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        return fgpartymemberrole;
    }
}
