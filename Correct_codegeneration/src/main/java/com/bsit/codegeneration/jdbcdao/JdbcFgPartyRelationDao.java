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

public class JdbcFgPartyRelationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyRelationDao.class);

    private static final String TABLE = "FG_PARTY_RELATION";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_FROM_ROLE_CODE = "PARTY_FROM_ROLE_CODE";

    private static final String COL_PARTY_TO_ROLE_CODE = "PARTY_TO_ROLE_CODE";

    private static final String COL_FROM_PARTY_ID = "FROM_PARTY_ID";

    private static final String COL_FROM_PARTY_VERSION_ID = "FROM_PARTY_VERSION_ID";

    private static final String COL_TO_PARTY_ID = "TO_PARTY_ID";

    private static final String COL_TO_PARTY_VERSION_ID = "TO_PARTY_VERSION_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_FROM_PARTY_USER_CODE = "FROM_PARTY_USER_CODE";

    private static final String COL_FROM_PARTY_USER_ID = "FROM_PARTY_USER_ID";

    private static final String COL_FROM_PARTY_USER_VERSION_ID = "FROM_PARTY_USER_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_FROM_ROLE_CODE, COL_PARTY_TO_ROLE_CODE, COL_FROM_PARTY_ID, COL_FROM_PARTY_VERSION_ID, COL_TO_PARTY_ID, COL_TO_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_FROM_PARTY_USER_CODE, COL_FROM_PARTY_USER_ID, COL_FROM_PARTY_USER_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_BY_FROM_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_FROM_PARTY_ID);

    private static final String SELECT_BY_TO_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_TO_PARTY_ID);

    private static final String SELECT_BY_FROM_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_FROM_PARTY_VERSION_ID);

    private static final String SELECT_BY_TO_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID", TABLE, COL_TO_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_FROM_ROLE_CODE, COL_PARTY_TO_ROLE_CODE, COL_FROM_PARTY_ID, COL_FROM_PARTY_VERSION_ID, COL_TO_PARTY_ID, COL_TO_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_FROM_PARTY_USER_CODE, COL_FROM_PARTY_USER_ID, COL_FROM_PARTY_USER_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgPartyRelation fgpartyrelation) throws SQLException {
        logger.debug("Inserting fgpartyrelation: {}", fgpartyrelation);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyRelationParams(ps, fgpartyrelation);
            ps.executeUpdate();
            return fgpartyrelation.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyRelation> fgpartyrelations) throws SQLException {
        if (fgpartyrelations == null || fgpartyrelations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyrelations.size(); i++) {
            if (fgpartyrelations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRelation>> batches = chunkList(fgpartyrelations, batchSize);
        int[] totalResults = new int[fgpartyrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyRelation fgpartyrelation : batch) {
                        setFgPartyRelationParams(ps, fgpartyrelation);
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

    public FgPartyRelation findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyRelation> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyRelation> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyRelation fgpartyrelation) throws SQLException {
        if (fgpartyrelation.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyRelationParams(ps, fgpartyrelation);
            ps.setInt(16, fgpartyrelation.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyRelation> fgpartyrelations) throws SQLException {
        if (fgpartyrelations == null || fgpartyrelations.isEmpty())
            return new int[0];
        for (FgPartyRelation fgpartyrelation : fgpartyrelations) {
            if (fgpartyrelation == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyrelation.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRelation>> batches = chunkList(fgpartyrelations, batchSize);
        int[] totalResults = new int[fgpartyrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyRelation fgpartyrelation : batch) {
                        setFgPartyRelationParams(ps, fgpartyrelation);
                        ps.setInt(16, fgpartyrelation.getID());
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

    public List<FgPartyRelation> findByFromPartyID(Connection conn, int fromPartyID) throws SQLException {
        List<FgPartyRelation> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FROM_PARTY_ID_SQL)) {
            ps.setInt(1, fromPartyID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyRelation> findByToPartyID(Connection conn, int toPartyID) throws SQLException {
        List<FgPartyRelation> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_TO_PARTY_ID_SQL)) {
            ps.setInt(1, toPartyID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyRelation> findByFromPartyVersionID(Connection conn, int fromPartyVersionID) throws SQLException {
        List<FgPartyRelation> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FROM_PARTY_VERSION_ID_SQL)) {
            ps.setInt(1, fromPartyVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyRelation> findByToPartyVersionID(Connection conn, int toPartyVersionID) throws SQLException {
        List<FgPartyRelation> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_TO_PARTY_VERSION_ID_SQL)) {
            ps.setInt(1, toPartyVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgPartyRelationParams(PreparedStatement ps, FgPartyRelation fgpartyrelation) throws SQLException {
        Integer val1 = fgpartyrelation.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpartyrelation.getPartyFromRoleCode());
        ps.setString(3, fgpartyrelation.getPartyToRoleCode());
        if (fgpartyrelation.getFromParty() != null) {
            ps.setInt(4, fgpartyrelation.getFromParty().getFgPartyID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (fgpartyrelation.getFromPartyVersion() != null) {
            ps.setInt(5, fgpartyrelation.getFromPartyVersion().getFgPartyID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        if (fgpartyrelation.getToParty() != null) {
            ps.setInt(6, fgpartyrelation.getToParty().getFgPartyID());
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        if (fgpartyrelation.getToPartyVersion() != null) {
            ps.setInt(7, fgpartyrelation.getToPartyVersion().getFgPartyID());
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgpartyrelation.getCreatedOn());
        java.math.BigDecimal val9 = fgpartyrelation.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpartyrelation.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgpartyrelation.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpartyrelation.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgpartyrelation.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartyrelation.getFromPartyUserCode());
        Integer val15 = fgpartyrelation.getFromPartyUserID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
        Integer val16 = fgpartyrelation.getFromPartyUserVersionID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
    }

    private FgPartyRelation extract(ResultSet rs) throws SQLException {
        FgPartyRelation fgpartyrelation = new FgPartyRelation();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyrelation.setID(ID);
        fgpartyrelation.setPartyFromRoleCode(rs.getString(COL_PARTY_FROM_ROLE_CODE));
        fgpartyrelation.setPartyToRoleCode(rs.getString(COL_PARTY_TO_ROLE_CODE));
        Integer FROM_PARTY_ID = rs.getObject(COL_FROM_PARTY_ID, Integer.class);
        fgpartyrelation.setFromPartyID(FROM_PARTY_ID);
        if (FROM_PARTY_ID != null) {
            FgParty fromParty = new FgParty();
            fromParty.setFgPartyID(FROM_PARTY_ID);
            fgpartyrelation.setFromParty(fromParty);
        }
        Integer FROM_PARTY_VERSION_ID = rs.getObject(COL_FROM_PARTY_VERSION_ID, Integer.class);
        fgpartyrelation.setFromPartyVersionID(FROM_PARTY_VERSION_ID);
        if (FROM_PARTY_VERSION_ID != null) {
            FgParty fromPartyVersion = new FgParty();
            fromPartyVersion.setFgPartyID(FROM_PARTY_VERSION_ID);
            fgpartyrelation.setFromPartyVersion(fromPartyVersion);
        }
        Integer TO_PARTY_ID = rs.getObject(COL_TO_PARTY_ID, Integer.class);
        fgpartyrelation.setToPartyID(TO_PARTY_ID);
        if (TO_PARTY_ID != null) {
            FgParty toParty = new FgParty();
            toParty.setFgPartyID(TO_PARTY_ID);
            fgpartyrelation.setToParty(toParty);
        }
        Integer TO_PARTY_VERSION_ID = rs.getObject(COL_TO_PARTY_VERSION_ID, Integer.class);
        fgpartyrelation.setToPartyVersionID(TO_PARTY_VERSION_ID);
        if (TO_PARTY_VERSION_ID != null) {
            FgParty toPartyVersion = new FgParty();
            toPartyVersion.setFgPartyID(TO_PARTY_VERSION_ID);
            fgpartyrelation.setToPartyVersion(toPartyVersion);
        }
        fgpartyrelation.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyrelation.setCreatedBy(CREATED_BY);
        fgpartyrelation.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyrelation.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyrelation.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyrelation.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyrelation.setFromPartyUserCode(rs.getString(COL_FROM_PARTY_USER_CODE));
        Integer FROM_PARTY_USER_ID = rs.getObject(COL_FROM_PARTY_USER_ID, Integer.class);
        fgpartyrelation.setFromPartyUserID(FROM_PARTY_USER_ID);
        Integer FROM_PARTY_USER_VERSION_ID = rs.getObject(COL_FROM_PARTY_USER_VERSION_ID, Integer.class);
        fgpartyrelation.setFromPartyUserVersionID(FROM_PARTY_USER_VERSION_ID);
        return fgpartyrelation;
    }
}
