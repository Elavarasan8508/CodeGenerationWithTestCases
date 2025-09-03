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

public class JdbcFgPartyContactDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyContactDao.class);

    private static final String TABLE = "FG_PARTY_CONTACT";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_REFERENCE = "REFERENCE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_SYSTEM_SOURCE_CODE = "SYSTEM_SOURCE_CODE";

    private static final String COL_SYS_DEFINED = "SYS_DEFINED";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PURPOSE_CODE, COL_REFERENCE, COL_TYPE_CODE, COL_PARTY_VERSION_ID, COL_DESCRIPTION, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SYSTEM_SOURCE_CODE, COL_SYS_DEFINED);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED", TABLE, COL_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED", TABLE, COL_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PURPOSE_CODE, COL_REFERENCE, COL_TYPE_CODE, COL_PARTY_VERSION_ID, COL_DESCRIPTION, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SYSTEM_SOURCE_CODE, COL_SYS_DEFINED, COL_ID);

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

    public int insert(Connection conn, FgPartyContact fgpartycontact) throws SQLException {
        logger.debug("Inserting fgpartycontact: {}", fgpartycontact);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyContactParams(ps, fgpartycontact);
            ps.executeUpdate();
            return fgpartycontact.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyContact> fgpartycontacts) throws SQLException {
        if (fgpartycontacts == null || fgpartycontacts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartycontacts.size(); i++) {
            if (fgpartycontacts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyContact>> batches = chunkList(fgpartycontacts, batchSize);
        int[] totalResults = new int[fgpartycontacts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyContact> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyContact fgpartycontact : batch) {
                        setFgPartyContactParams(ps, fgpartycontact);
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

    public FgPartyContact findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyContact> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyContact> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyContact fgpartycontact) throws SQLException {
        if (fgpartycontact.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyContactParams(ps, fgpartycontact);
            ps.setInt(15, fgpartycontact.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyContact> fgpartycontacts) throws SQLException {
        if (fgpartycontacts == null || fgpartycontacts.isEmpty())
            return new int[0];
        for (FgPartyContact fgpartycontact : fgpartycontacts) {
            if (fgpartycontact == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartycontact.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyContact>> batches = chunkList(fgpartycontacts, batchSize);
        int[] totalResults = new int[fgpartycontacts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyContact> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyContact fgpartycontact : batch) {
                        setFgPartyContactParams(ps, fgpartycontact);
                        ps.setInt(15, fgpartycontact.getID());
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

    public List<FgPartyContact> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgPartyContact> list = new ArrayList<>();
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

    public List<FgPartyContact> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgPartyContact> list = new ArrayList<>();
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

    private void setFgPartyContactParams(PreparedStatement ps, FgPartyContact fgpartycontact) throws SQLException {
        Integer val1 = fgpartycontact.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (fgpartycontact.getParty() != null) {
            ps.setInt(2, fgpartycontact.getParty().getFgPartyID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgpartycontact.getPurposeCode());
        ps.setString(4, fgpartycontact.getReference());
        ps.setString(5, fgpartycontact.getTypeCode());
        if (fgpartycontact.getPartyVersion() != null) {
            ps.setInt(6, fgpartycontact.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        ps.setString(7, fgpartycontact.getDescription());
        ps.setString(8, fgpartycontact.getCreatedOn());
        java.math.BigDecimal val9 = fgpartycontact.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpartycontact.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgpartycontact.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpartycontact.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgpartycontact.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartycontact.getSystemSourceCode());
        java.math.BigDecimal val15 = fgpartycontact.getSysDefined();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
    }

    private FgPartyContact extract(ResultSet rs) throws SQLException {
        FgPartyContact fgpartycontact = new FgPartyContact();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartycontact.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartycontact.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fgpartycontact.setParty(party);
        }
        fgpartycontact.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgpartycontact.setReference(rs.getString(COL_REFERENCE));
        fgpartycontact.setTypeCode(rs.getString(COL_TYPE_CODE));
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartycontact.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fgpartycontact.setPartyVersion(partyVersion);
        }
        fgpartycontact.setDescription(rs.getString(COL_DESCRIPTION));
        fgpartycontact.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartycontact.setCreatedBy(CREATED_BY);
        fgpartycontact.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartycontact.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartycontact.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartycontact.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartycontact.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        java.math.BigDecimal SYS_DEFINED = rs.getObject(COL_SYS_DEFINED, java.math.BigDecimal.class);
        fgpartycontact.setSysDefined(SYS_DEFINED);
        return fgpartycontact;
    }
}
