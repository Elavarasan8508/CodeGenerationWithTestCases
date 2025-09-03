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

public class JdbcFgModCmsSpaceDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModCmsSpaceDao.class);

    private static final String TABLE = "FG_MOD_CMS_SPACE";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_SPACE_CODE = "SPACE_CODE";

    private static final String COL_PARENT_SPACE_CODE = "PARENT_SPACE_CODE";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_VISIBILITY_CODE = "VISIBILITY_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_PUBLISH_DATE = "PUBLISH_DATE";

    private static final String COL_EXPIRE_DATE = "EXPIRE_DATE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_SPACE_CODE, COL_PARENT_SPACE_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_VISIBILITY_CODE, COL_NAME, COL_DESCRIPTION, COL_PUBLISH_DATE, COL_EXPIRE_DATE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, SPACE_CODE, PARENT_SPACE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE, NAME, DESCRIPTION, PUBLISH_DATE, EXPIRE_DATE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, SPACE_CODE, PARENT_SPACE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE, NAME, DESCRIPTION, PUBLISH_DATE, EXPIRE_DATE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_SPACE_CODE, COL_PARENT_SPACE_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_VISIBILITY_CODE, COL_NAME, COL_DESCRIPTION, COL_PUBLISH_DATE, COL_EXPIRE_DATE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, FgModCmsSpace fgmodcmsspace) throws SQLException {
        logger.debug("Inserting fgmodcmsspace: {}", fgmodcmsspace);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModCmsSpaceParams(ps, fgmodcmsspace);
            ps.executeUpdate();
            return fgmodcmsspace.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModCmsSpace> fgmodcmsspaces) throws SQLException {
        if (fgmodcmsspaces == null || fgmodcmsspaces.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodcmsspaces.size(); i++) {
            if (fgmodcmsspaces.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsSpace>> batches = chunkList(fgmodcmsspaces, batchSize);
        int[] totalResults = new int[fgmodcmsspaces.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsSpace> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModCmsSpace fgmodcmsspace : batch) {
                        setFgModCmsSpaceParams(ps, fgmodcmsspace);
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

    public FgModCmsSpace findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModCmsSpace> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModCmsSpace> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModCmsSpace fgmodcmsspace) throws SQLException {
        if (fgmodcmsspace.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModCmsSpaceParams(ps, fgmodcmsspace);
            ps.setInt(22, fgmodcmsspace.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModCmsSpace> fgmodcmsspaces) throws SQLException {
        if (fgmodcmsspaces == null || fgmodcmsspaces.isEmpty())
            return new int[0];
        for (FgModCmsSpace fgmodcmsspace : fgmodcmsspaces) {
            if (fgmodcmsspace == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodcmsspace.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsSpace>> batches = chunkList(fgmodcmsspaces, batchSize);
        int[] totalResults = new int[fgmodcmsspaces.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsSpace> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModCmsSpace fgmodcmsspace : batch) {
                        setFgModCmsSpaceParams(ps, fgmodcmsspace);
                        ps.setInt(22, fgmodcmsspace.getID());
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

    private void setFgModCmsSpaceParams(PreparedStatement ps, FgModCmsSpace fgmodcmsspace) throws SQLException {
        Integer val1 = fgmodcmsspace.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodcmsspace.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodcmsspace.getSpaceCode());
        ps.setString(4, fgmodcmsspace.getParentSpaceCode());
        ps.setString(5, fgmodcmsspace.getPartyTypeCode());
        ps.setString(6, fgmodcmsspace.getPartySubTypeCode());
        ps.setString(7, fgmodcmsspace.getEntityTypeCode());
        ps.setString(8, fgmodcmsspace.getEntitySubTypeCode());
        ps.setString(9, fgmodcmsspace.getVisibilityCode());
        ps.setString(10, fgmodcmsspace.getName());
        ps.setString(11, fgmodcmsspace.getDescription());
        ps.setString(12, fgmodcmsspace.getPublishDate());
        ps.setString(13, fgmodcmsspace.getExpireDate());
        ps.setString(14, fgmodcmsspace.getStatusCode());
        ps.setString(15, fgmodcmsspace.getActiveCode());
        java.math.BigDecimal val16 = fgmodcmsspace.getCreatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgmodcmsspace.getCreatedOn());
        java.math.BigDecimal val18 = fgmodcmsspace.getLastUpdatedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgmodcmsspace.getLastUpdatedOn());
        java.math.BigDecimal val20 = fgmodcmsspace.getLastAuthorisedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgmodcmsspace.getLastAuthorisedOn());
        java.math.BigDecimal val22 = fgmodcmsspace.getIsMasterVersion();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
    }

    private FgModCmsSpace extract(ResultSet rs) throws SQLException {
        FgModCmsSpace fgmodcmsspace = new FgModCmsSpace();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodcmsspace.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodcmsspace.setVersionID(VERSION_ID);
        fgmodcmsspace.setSpaceCode(rs.getString(COL_SPACE_CODE));
        fgmodcmsspace.setParentSpaceCode(rs.getString(COL_PARENT_SPACE_CODE));
        fgmodcmsspace.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgmodcmsspace.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgmodcmsspace.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgmodcmsspace.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgmodcmsspace.setVisibilityCode(rs.getString(COL_VISIBILITY_CODE));
        fgmodcmsspace.setName(rs.getString(COL_NAME));
        fgmodcmsspace.setDescription(rs.getString(COL_DESCRIPTION));
        fgmodcmsspace.setPublishDate(rs.getString(COL_PUBLISH_DATE));
        fgmodcmsspace.setExpireDate(rs.getString(COL_EXPIRE_DATE));
        fgmodcmsspace.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodcmsspace.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodcmsspace.setCreatedBy(CREATED_BY);
        fgmodcmsspace.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodcmsspace.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodcmsspace.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodcmsspace.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodcmsspace.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodcmsspace.setIsMasterVersion(IS_MASTER_VERSION);
        return fgmodcmsspace;
    }
}
