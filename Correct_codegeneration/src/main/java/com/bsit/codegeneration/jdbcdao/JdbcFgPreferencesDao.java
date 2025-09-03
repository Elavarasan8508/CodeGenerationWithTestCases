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

public class JdbcFgPreferencesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPreferencesDao.class);

    private static final String TABLE = "FG_PREFERENCES";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_PREF_CATEGORY_CODE = "PREF_CATEGORY_CODE";

    private static final String COL_PREF_TYPE_CODE = "PREF_TYPE_CODE";

    private static final String COL_PREF_CODE = "PREF_CODE";

    private static final String COL_ORG_PARTY_CODE = "ORG_PARTY_CODE";

    private static final String COL_ORG_PARTY_SUB_TYPE_CODE = "ORG_PARTY_SUB_TYPE_CODE";

    private static final String COL_USER_PARTY_CODE = "USER_PARTY_CODE";

    private static final String COL_USER_PARTY_SUB_TYPE_CODE = "USER_PARTY_SUB_TYPE_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PREF_CATEGORY_CODE, COL_PREF_TYPE_CODE, COL_PREF_CODE, COL_ORG_PARTY_CODE, COL_ORG_PARTY_SUB_TYPE_CODE, COL_USER_PARTY_CODE, COL_USER_PARTY_SUB_TYPE_CODE, COL_NAME, COL_DESCRIPTION, COL_TEMPLATE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE, NAME, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE, NAME, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PREF_CATEGORY_CODE, COL_PREF_TYPE_CODE, COL_PREF_CODE, COL_ORG_PARTY_CODE, COL_ORG_PARTY_SUB_TYPE_CODE, COL_USER_PARTY_CODE, COL_USER_PARTY_SUB_TYPE_CODE, COL_NAME, COL_DESCRIPTION, COL_TEMPLATE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgPreferences fgpreferences) throws SQLException {
        logger.debug("Inserting fgpreferences: {}", fgpreferences);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPreferencesParams(ps, fgpreferences);
            ps.executeUpdate();
            return fgpreferences.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPreferences> fgpreferencess) throws SQLException {
        if (fgpreferencess == null || fgpreferencess.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpreferencess.size(); i++) {
            if (fgpreferencess.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPreferences>> batches = chunkList(fgpreferencess, batchSize);
        int[] totalResults = new int[fgpreferencess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPreferences> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPreferences fgpreferences : batch) {
                        setFgPreferencesParams(ps, fgpreferences);
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

    public FgPreferences findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPreferences> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPreferences> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPreferences fgpreferences) throws SQLException {
        if (fgpreferences.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPreferencesParams(ps, fgpreferences);
            ps.setInt(22, fgpreferences.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPreferences> fgpreferencess) throws SQLException {
        if (fgpreferencess == null || fgpreferencess.isEmpty())
            return new int[0];
        for (FgPreferences fgpreferences : fgpreferencess) {
            if (fgpreferences == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpreferences.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPreferences>> batches = chunkList(fgpreferencess, batchSize);
        int[] totalResults = new int[fgpreferencess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPreferences> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPreferences fgpreferences : batch) {
                        setFgPreferencesParams(ps, fgpreferences);
                        ps.setInt(22, fgpreferences.getID());
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

    private void setFgPreferencesParams(PreparedStatement ps, FgPreferences fgpreferences) throws SQLException {
        Integer val1 = fgpreferences.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpreferences.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgpreferences.getTypeCode());
        ps.setString(4, fgpreferences.getSubTypeCode());
        ps.setString(5, fgpreferences.getPrefCategoryCode());
        ps.setString(6, fgpreferences.getPrefTypeCode());
        ps.setString(7, fgpreferences.getPrefCode());
        ps.setString(8, fgpreferences.getOrgPartyCode());
        ps.setString(9, fgpreferences.getOrgPartySubTypeCode());
        ps.setString(10, fgpreferences.getUserPartyCode());
        ps.setString(11, fgpreferences.getUserPartySubTypeCode());
        ps.setString(12, fgpreferences.getName());
        ps.setString(13, fgpreferences.getDescription());
        ps.setString(14, fgpreferences.getTemplate());
        ps.setString(15, fgpreferences.getActiveCode());
        ps.setString(16, fgpreferences.getStatusCode());
        ps.setString(17, fgpreferences.getCreatedOn());
        java.math.BigDecimal val18 = fgpreferences.getCreatedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgpreferences.getLastUpdatedOn());
        java.math.BigDecimal val20 = fgpreferences.getLastUpdatedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgpreferences.getLastAuthorisedBy();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgpreferences.getLastAuthorisedOn());
    }

    private FgPreferences extract(ResultSet rs) throws SQLException {
        FgPreferences fgpreferences = new FgPreferences();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpreferences.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgpreferences.setVersionID(VERSION_ID);
        fgpreferences.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgpreferences.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgpreferences.setPrefCategoryCode(rs.getString(COL_PREF_CATEGORY_CODE));
        fgpreferences.setPrefTypeCode(rs.getString(COL_PREF_TYPE_CODE));
        fgpreferences.setPrefCode(rs.getString(COL_PREF_CODE));
        fgpreferences.setOrgPartyCode(rs.getString(COL_ORG_PARTY_CODE));
        fgpreferences.setOrgPartySubTypeCode(rs.getString(COL_ORG_PARTY_SUB_TYPE_CODE));
        fgpreferences.setUserPartyCode(rs.getString(COL_USER_PARTY_CODE));
        fgpreferences.setUserPartySubTypeCode(rs.getString(COL_USER_PARTY_SUB_TYPE_CODE));
        fgpreferences.setName(rs.getString(COL_NAME));
        fgpreferences.setDescription(rs.getString(COL_DESCRIPTION));
        fgpreferences.setTemplate(rs.getString(COL_TEMPLATE));
        fgpreferences.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpreferences.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpreferences.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpreferences.setCreatedBy(CREATED_BY);
        fgpreferences.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpreferences.setLastUpdatedBy(LAST_UPDATED_BY);
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpreferences.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpreferences.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgpreferences;
    }
}
