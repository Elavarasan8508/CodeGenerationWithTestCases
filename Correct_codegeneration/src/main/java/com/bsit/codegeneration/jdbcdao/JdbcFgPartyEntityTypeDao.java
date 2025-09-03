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

public class JdbcFgPartyEntityTypeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyEntityTypeDao.class);

    private static final String TABLE = "FG_PARTY_ENTITY_TYPE";

    private static final String COL_ID = "ID";

    private static final String COL_IS_ENABLED = "IS_ENABLED";

    private static final String COL_PARTY_REFERENCE_ID = "PARTY_REFERENCE_ID";

    private static final String COL_ENTITY_CATEGORY_CODE = "ENTITY_CATEGORY_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_USER_OBJECT_TYPE = "USER_OBJECT_TYPE";

    private static final String COL_USER_OBJECT_REFERENCE_ID = "USER_OBJECT_REFERENCE_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_ENTITY_TYPE_NAME = "ENTITY_TYPE_NAME";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_USER_OBJECT_ID = "USER_OBJECT_ID";

    private static final String COL_USER_OBJECT_VERSION_ID = "USER_OBJECT_VERSION_ID";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_ENTITY_ACTION = "ENTITY_ACTION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_IS_ENABLED, COL_PARTY_REFERENCE_ID, COL_ENTITY_CATEGORY_CODE, COL_ENTITY_TYPE_CODE, COL_USER_OBJECT_TYPE, COL_USER_OBJECT_REFERENCE_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_TYPE_NAME, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_USER_OBJECT_ID, COL_USER_OBJECT_VERSION_ID, COL_TEMPLATE, COL_ENTITY_ACTION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, IS_ENABLED, PARTY_REFERENCE_ID, ENTITY_CATEGORY_CODE, ENTITY_TYPE_CODE, USER_OBJECT_TYPE, USER_OBJECT_REFERENCE_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_NAME, PARTY_ID, PARTY_VERSION_ID, USER_OBJECT_ID, USER_OBJECT_VERSION_ID, TEMPLATE, ENTITY_ACTION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, IS_ENABLED, PARTY_REFERENCE_ID, ENTITY_CATEGORY_CODE, ENTITY_TYPE_CODE, USER_OBJECT_TYPE, USER_OBJECT_REFERENCE_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_NAME, PARTY_ID, PARTY_VERSION_ID, USER_OBJECT_ID, USER_OBJECT_VERSION_ID, TEMPLATE, ENTITY_ACTION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_IS_ENABLED, COL_PARTY_REFERENCE_ID, COL_ENTITY_CATEGORY_CODE, COL_ENTITY_TYPE_CODE, COL_USER_OBJECT_TYPE, COL_USER_OBJECT_REFERENCE_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_TYPE_NAME, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_USER_OBJECT_ID, COL_USER_OBJECT_VERSION_ID, COL_TEMPLATE, COL_ENTITY_ACTION, COL_ID);

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

    public int insert(Connection conn, FgPartyEntityType fgpartyentitytype) throws SQLException {
        logger.debug("Inserting fgpartyentitytype: {}", fgpartyentitytype);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyEntityTypeParams(ps, fgpartyentitytype);
            ps.executeUpdate();
            return fgpartyentitytype.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyEntityType> fgpartyentitytypes) throws SQLException {
        if (fgpartyentitytypes == null || fgpartyentitytypes.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyentitytypes.size(); i++) {
            if (fgpartyentitytypes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyEntityType>> batches = chunkList(fgpartyentitytypes, batchSize);
        int[] totalResults = new int[fgpartyentitytypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyEntityType> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyEntityType fgpartyentitytype : batch) {
                        setFgPartyEntityTypeParams(ps, fgpartyentitytype);
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

    public FgPartyEntityType findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyEntityType> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyEntityType> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyEntityType fgpartyentitytype) throws SQLException {
        if (fgpartyentitytype.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyEntityTypeParams(ps, fgpartyentitytype);
            ps.setInt(22, fgpartyentitytype.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyEntityType> fgpartyentitytypes) throws SQLException {
        if (fgpartyentitytypes == null || fgpartyentitytypes.isEmpty())
            return new int[0];
        for (FgPartyEntityType fgpartyentitytype : fgpartyentitytypes) {
            if (fgpartyentitytype == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyentitytype.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyEntityType>> batches = chunkList(fgpartyentitytypes, batchSize);
        int[] totalResults = new int[fgpartyentitytypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyEntityType> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyEntityType fgpartyentitytype : batch) {
                        setFgPartyEntityTypeParams(ps, fgpartyentitytype);
                        ps.setInt(22, fgpartyentitytype.getID());
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

    private void setFgPartyEntityTypeParams(PreparedStatement ps, FgPartyEntityType fgpartyentitytype) throws SQLException {
        Integer val1 = fgpartyentitytype.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Boolean val2 = fgpartyentitytype.getIsEnabled();
        if (val2 != null) {
            ps.setBoolean(2, val2);
        } else {
            ps.setNull(2, Types.BOOLEAN);
        }
        Integer val3 = fgpartyentitytype.getPartyReferenceID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgpartyentitytype.getEntityCategoryCode());
        ps.setString(5, fgpartyentitytype.getEntityTypeCode());
        ps.setString(6, fgpartyentitytype.getUserObjectType());
        Integer val7 = fgpartyentitytype.getUserObjectReferenceID();
        if (val7 != null) {
            ps.setInt(7, val7);
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgpartyentitytype.getActiveCode());
        ps.setString(9, fgpartyentitytype.getStatusCode());
        ps.setString(10, fgpartyentitytype.getCreatedOn());
        java.math.BigDecimal val11 = fgpartyentitytype.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpartyentitytype.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgpartyentitytype.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartyentitytype.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgpartyentitytype.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpartyentitytype.getEntityTypeName());
        Integer val17 = fgpartyentitytype.getPartyID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = fgpartyentitytype.getPartyVersionID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = fgpartyentitytype.getUserObjectID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgpartyentitytype.getUserObjectVersionID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        ps.setString(21, fgpartyentitytype.getTemplate());
        ps.setString(22, fgpartyentitytype.getEntityAction());
    }

    private FgPartyEntityType extract(ResultSet rs) throws SQLException {
        FgPartyEntityType fgpartyentitytype = new FgPartyEntityType();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyentitytype.setID(ID);
        Boolean IS_ENABLED = rs.getObject(COL_IS_ENABLED, Boolean.class);
        fgpartyentitytype.setIsEnabled(IS_ENABLED);
        Integer PARTY_REFERENCE_ID = rs.getObject(COL_PARTY_REFERENCE_ID, Integer.class);
        fgpartyentitytype.setPartyReferenceID(PARTY_REFERENCE_ID);
        fgpartyentitytype.setEntityCategoryCode(rs.getString(COL_ENTITY_CATEGORY_CODE));
        fgpartyentitytype.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgpartyentitytype.setUserObjectType(rs.getString(COL_USER_OBJECT_TYPE));
        Integer USER_OBJECT_REFERENCE_ID = rs.getObject(COL_USER_OBJECT_REFERENCE_ID, Integer.class);
        fgpartyentitytype.setUserObjectReferenceID(USER_OBJECT_REFERENCE_ID);
        fgpartyentitytype.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyentitytype.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyentitytype.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyentitytype.setCreatedBy(CREATED_BY);
        fgpartyentitytype.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyentitytype.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyentitytype.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyentitytype.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyentitytype.setEntityTypeName(rs.getString(COL_ENTITY_TYPE_NAME));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyentitytype.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyentitytype.setPartyVersionID(PARTY_VERSION_ID);
        Integer USER_OBJECT_ID = rs.getObject(COL_USER_OBJECT_ID, Integer.class);
        fgpartyentitytype.setUserObjectID(USER_OBJECT_ID);
        Integer USER_OBJECT_VERSION_ID = rs.getObject(COL_USER_OBJECT_VERSION_ID, Integer.class);
        fgpartyentitytype.setUserObjectVersionID(USER_OBJECT_VERSION_ID);
        fgpartyentitytype.setTemplate(rs.getString(COL_TEMPLATE));
        fgpartyentitytype.setEntityAction(rs.getString(COL_ENTITY_ACTION));
        return fgpartyentitytype;
    }
}
