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

public class JdbcFgPartyAddressDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyAddressDao.class);

    private static final String TABLE = "FG_PARTY_ADDRESS";

    private static final String COL_ID = "ID";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_ADDRESS_ID = "ADDRESS_ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PURPOSE_CODE, COL_ADDRESS_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_ADDRESS_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PURPOSE_CODE, COL_ADDRESS_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgPartyAddress fgpartyaddress) throws SQLException {
        logger.debug("Inserting fgpartyaddress: {}", fgpartyaddress);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyAddressParams(ps, fgpartyaddress);
            ps.executeUpdate();
            return fgpartyaddress.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyAddress> fgpartyaddresss) throws SQLException {
        if (fgpartyaddresss == null || fgpartyaddresss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyaddresss.size(); i++) {
            if (fgpartyaddresss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyAddress>> batches = chunkList(fgpartyaddresss, batchSize);
        int[] totalResults = new int[fgpartyaddresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyAddress> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyAddress fgpartyaddress : batch) {
                        setFgPartyAddressParams(ps, fgpartyaddress);
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

    public FgPartyAddress findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyAddress> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyAddress> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyAddress fgpartyaddress) throws SQLException {
        if (fgpartyaddress.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyAddressParams(ps, fgpartyaddress);
            ps.setInt(11, fgpartyaddress.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyAddress> fgpartyaddresss) throws SQLException {
        if (fgpartyaddresss == null || fgpartyaddresss.isEmpty())
            return new int[0];
        for (FgPartyAddress fgpartyaddress : fgpartyaddresss) {
            if (fgpartyaddress == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyaddress.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyAddress>> batches = chunkList(fgpartyaddresss, batchSize);
        int[] totalResults = new int[fgpartyaddresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyAddress> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyAddress fgpartyaddress : batch) {
                        setFgPartyAddressParams(ps, fgpartyaddress);
                        ps.setInt(11, fgpartyaddress.getID());
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

    public List<FgPartyAddress> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<FgPartyAddress> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ADDRESS_ID_SQL)) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgPartyAddress> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgPartyAddress> list = new ArrayList<>();
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

    public List<FgPartyAddress> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgPartyAddress> list = new ArrayList<>();
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

    private void setFgPartyAddressParams(PreparedStatement ps, FgPartyAddress fgpartyaddress) throws SQLException {
        Integer val1 = fgpartyaddress.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpartyaddress.getPurposeCode());
        if (fgpartyaddress.getAddress() != null) {
            ps.setInt(3, fgpartyaddress.getAddress().getFgAddressID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (fgpartyaddress.getParty() != null) {
            ps.setInt(4, fgpartyaddress.getParty().getFgPartyID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (fgpartyaddress.getPartyVersion() != null) {
            ps.setInt(5, fgpartyaddress.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgpartyaddress.getCreatedOn());
        java.math.BigDecimal val7 = fgpartyaddress.getCreatedBy();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgpartyaddress.getLastUpdatedOn());
        java.math.BigDecimal val9 = fgpartyaddress.getLastUpdatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpartyaddress.getLastAuthorisedOn());
        java.math.BigDecimal val11 = fgpartyaddress.getLastAuthorisedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
    }

    private FgPartyAddress extract(ResultSet rs) throws SQLException {
        FgPartyAddress fgpartyaddress = new FgPartyAddress();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyaddress.setID(ID);
        fgpartyaddress.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        Integer ADDRESS_ID = rs.getObject(COL_ADDRESS_ID, Integer.class);
        fgpartyaddress.setAddressID(ADDRESS_ID);
        if (ADDRESS_ID != null) {
            FgAddress address = new FgAddress();
            address.setFgAddressID(ADDRESS_ID);
            fgpartyaddress.setAddress(address);
        }
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyaddress.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fgpartyaddress.setParty(party);
        }
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyaddress.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fgpartyaddress.setPartyVersion(partyVersion);
        }
        fgpartyaddress.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyaddress.setCreatedBy(CREATED_BY);
        fgpartyaddress.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyaddress.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyaddress.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyaddress.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgpartyaddress;
    }
}
