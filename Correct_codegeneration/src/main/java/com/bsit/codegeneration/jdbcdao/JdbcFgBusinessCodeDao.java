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

public class JdbcFgBusinessCodeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBusinessCodeDao.class);

    private static final String TABLE = "FG_BUSINESS_CODE";

    private static final String COL_ID = "ID";

    private static final String COL_NAME = "NAME";

    private static final String COL_CODE_TYPE = "CODE_TYPE";

    private static final String COL_CODE_VALUE = "CODE_VALUE";

    private static final String COL_PARENT_CODE = "PARENT_CODE";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARENT_TYPE = "PARENT_TYPE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_TAGS = "TAGS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_NAME, COL_CODE_TYPE, COL_CODE_VALUE, COL_PARENT_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARENT_TYPE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_PARENT_REF_ID, COL_TAGS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_CODE_TYPE, COL_CODE_VALUE, COL_PARENT_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARENT_TYPE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_PARENT_REF_ID, COL_TAGS, COL_ID);

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

    public int insert(Connection conn, FgBusinessCode fgbusinesscode) throws SQLException {
        logger.debug("Inserting fgbusinesscode: {}", fgbusinesscode);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBusinessCodeParams(ps, fgbusinesscode);
            ps.executeUpdate();
            return fgbusinesscode.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBusinessCode> fgbusinesscodes) throws SQLException {
        if (fgbusinesscodes == null || fgbusinesscodes.isEmpty())
            return new int[0];
        for (int i = 0; i < fgbusinesscodes.size(); i++) {
            if (fgbusinesscodes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBusinessCode>> batches = chunkList(fgbusinesscodes, batchSize);
        int[] totalResults = new int[fgbusinesscodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBusinessCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBusinessCode fgbusinesscode : batch) {
                        setFgBusinessCodeParams(ps, fgbusinesscode);
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

    public FgBusinessCode findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBusinessCode> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBusinessCode> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBusinessCode fgbusinesscode) throws SQLException {
        if (fgbusinesscode.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBusinessCodeParams(ps, fgbusinesscode);
            ps.setInt(20, fgbusinesscode.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBusinessCode> fgbusinesscodes) throws SQLException {
        if (fgbusinesscodes == null || fgbusinesscodes.isEmpty())
            return new int[0];
        for (FgBusinessCode fgbusinesscode : fgbusinesscodes) {
            if (fgbusinesscode == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgbusinesscode.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBusinessCode>> batches = chunkList(fgbusinesscodes, batchSize);
        int[] totalResults = new int[fgbusinesscodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBusinessCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBusinessCode fgbusinesscode : batch) {
                        setFgBusinessCodeParams(ps, fgbusinesscode);
                        ps.setInt(20, fgbusinesscode.getID());
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

    public List<FgBusinessCode> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgBusinessCode> list = new ArrayList<>();
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

    public List<FgBusinessCode> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgBusinessCode> list = new ArrayList<>();
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

    private void setFgBusinessCodeParams(PreparedStatement ps, FgBusinessCode fgbusinesscode) throws SQLException {
        Integer val1 = fgbusinesscode.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgbusinesscode.getName());
        ps.setString(3, fgbusinesscode.getCodeType());
        ps.setString(4, fgbusinesscode.getCodeValue());
        ps.setString(5, fgbusinesscode.getParentCode());
        if (fgbusinesscode.getParty() != null) {
            ps.setInt(6, fgbusinesscode.getParty().getFgPartyID());
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        if (fgbusinesscode.getPartyVersion() != null) {
            ps.setInt(7, fgbusinesscode.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgbusinesscode.getParentType());
        ps.setString(9, fgbusinesscode.getDescription());
        ps.setString(10, fgbusinesscode.getActiveCode());
        ps.setString(11, fgbusinesscode.getStatusCode());
        ps.setString(12, fgbusinesscode.getCreatedOn());
        java.math.BigDecimal val13 = fgbusinesscode.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgbusinesscode.getLastUpdatedOn());
        java.math.BigDecimal val15 = fgbusinesscode.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgbusinesscode.getLastAuthorisedOn());
        java.math.BigDecimal val17 = fgbusinesscode.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgbusinesscode.getTemplate());
        Integer val19 = fgbusinesscode.getParentRefID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgbusinesscode.getTags());
    }

    private FgBusinessCode extract(ResultSet rs) throws SQLException {
        FgBusinessCode fgbusinesscode = new FgBusinessCode();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgbusinesscode.setID(ID);
        fgbusinesscode.setName(rs.getString(COL_NAME));
        fgbusinesscode.setCodeType(rs.getString(COL_CODE_TYPE));
        fgbusinesscode.setCodeValue(rs.getString(COL_CODE_VALUE));
        fgbusinesscode.setParentCode(rs.getString(COL_PARENT_CODE));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgbusinesscode.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fgbusinesscode.setParty(party);
        }
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgbusinesscode.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fgbusinesscode.setPartyVersion(partyVersion);
        }
        fgbusinesscode.setParentType(rs.getString(COL_PARENT_TYPE));
        fgbusinesscode.setDescription(rs.getString(COL_DESCRIPTION));
        fgbusinesscode.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgbusinesscode.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgbusinesscode.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgbusinesscode.setCreatedBy(CREATED_BY);
        fgbusinesscode.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgbusinesscode.setLastUpdatedBy(LAST_UPDATED_BY);
        fgbusinesscode.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgbusinesscode.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgbusinesscode.setTemplate(rs.getString(COL_TEMPLATE));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgbusinesscode.setParentRefID(PARENT_REF_ID);
        fgbusinesscode.setTags(rs.getString(COL_TAGS));
        return fgbusinesscode;
    }
}
