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

public class JdbcFgPreferencesRelationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPreferencesRelationDao.class);

    private static final String TABLE = "FG_PREFERENCES_RELATION";

    private static final String COL_ID = "ID";

    private static final String COL_PREF_CATEGORY_CODE = "PREF_CATEGORY_CODE";

    private static final String COL_PREF_TYPE_CODE = "PREF_TYPE_CODE";

    private static final String COL_PREF_CODE = "PREF_CODE";

    private static final String COL_SCOPE_CODE = "SCOPE_CODE";

    private static final String COL_SCOPE_VALUE = "SCOPE_VALUE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PREF_CATEGORY_CODE, COL_PREF_TYPE_CODE, COL_PREF_CODE, COL_SCOPE_CODE, COL_SCOPE_VALUE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, SCOPE_CODE, SCOPE_VALUE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, SCOPE_CODE, SCOPE_VALUE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PREF_CATEGORY_CODE, COL_PREF_TYPE_CODE, COL_PREF_CODE, COL_SCOPE_CODE, COL_SCOPE_VALUE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgPreferencesRelation fgpreferencesrelation) throws SQLException {
        logger.debug("Inserting fgpreferencesrelation: {}", fgpreferencesrelation);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPreferencesRelationParams(ps, fgpreferencesrelation);
            ps.executeUpdate();
            return fgpreferencesrelation.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPreferencesRelation> fgpreferencesrelations) throws SQLException {
        if (fgpreferencesrelations == null || fgpreferencesrelations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpreferencesrelations.size(); i++) {
            if (fgpreferencesrelations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPreferencesRelation>> batches = chunkList(fgpreferencesrelations, batchSize);
        int[] totalResults = new int[fgpreferencesrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPreferencesRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPreferencesRelation fgpreferencesrelation : batch) {
                        setFgPreferencesRelationParams(ps, fgpreferencesrelation);
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

    public FgPreferencesRelation findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPreferencesRelation> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPreferencesRelation> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPreferencesRelation fgpreferencesrelation) throws SQLException {
        if (fgpreferencesrelation.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPreferencesRelationParams(ps, fgpreferencesrelation);
            ps.setInt(15, fgpreferencesrelation.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPreferencesRelation> fgpreferencesrelations) throws SQLException {
        if (fgpreferencesrelations == null || fgpreferencesrelations.isEmpty())
            return new int[0];
        for (FgPreferencesRelation fgpreferencesrelation : fgpreferencesrelations) {
            if (fgpreferencesrelation == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpreferencesrelation.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPreferencesRelation>> batches = chunkList(fgpreferencesrelations, batchSize);
        int[] totalResults = new int[fgpreferencesrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPreferencesRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPreferencesRelation fgpreferencesrelation : batch) {
                        setFgPreferencesRelationParams(ps, fgpreferencesrelation);
                        ps.setInt(15, fgpreferencesrelation.getID());
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

    private void setFgPreferencesRelationParams(PreparedStatement ps, FgPreferencesRelation fgpreferencesrelation) throws SQLException {
        Integer val1 = fgpreferencesrelation.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpreferencesrelation.getPrefCategoryCode());
        ps.setString(3, fgpreferencesrelation.getPrefTypeCode());
        ps.setString(4, fgpreferencesrelation.getPrefCode());
        ps.setString(5, fgpreferencesrelation.getScopeCode());
        ps.setString(6, fgpreferencesrelation.getScopeValue());
        ps.setString(7, fgpreferencesrelation.getDescription());
        ps.setString(8, fgpreferencesrelation.getActiveCode());
        ps.setString(9, fgpreferencesrelation.getStatusCode());
        ps.setString(10, fgpreferencesrelation.getCreatedOn());
        java.math.BigDecimal val11 = fgpreferencesrelation.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpreferencesrelation.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgpreferencesrelation.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = fgpreferencesrelation.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgpreferencesrelation.getLastAuthorisedOn());
    }

    private FgPreferencesRelation extract(ResultSet rs) throws SQLException {
        FgPreferencesRelation fgpreferencesrelation = new FgPreferencesRelation();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpreferencesrelation.setID(ID);
        fgpreferencesrelation.setPrefCategoryCode(rs.getString(COL_PREF_CATEGORY_CODE));
        fgpreferencesrelation.setPrefTypeCode(rs.getString(COL_PREF_TYPE_CODE));
        fgpreferencesrelation.setPrefCode(rs.getString(COL_PREF_CODE));
        fgpreferencesrelation.setScopeCode(rs.getString(COL_SCOPE_CODE));
        fgpreferencesrelation.setScopeValue(rs.getString(COL_SCOPE_VALUE));
        fgpreferencesrelation.setDescription(rs.getString(COL_DESCRIPTION));
        fgpreferencesrelation.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpreferencesrelation.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpreferencesrelation.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpreferencesrelation.setCreatedBy(CREATED_BY);
        fgpreferencesrelation.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpreferencesrelation.setLastUpdatedBy(LAST_UPDATED_BY);
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpreferencesrelation.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpreferencesrelation.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgpreferencesrelation;
    }
}
