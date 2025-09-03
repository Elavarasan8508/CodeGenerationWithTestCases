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

public class JdbcFgProductRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductRoleDao.class);

    private static final String TABLE = "FG_PRODUCT_ROLE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PARTY_ROLE_CODE = "PARTY_ROLE_CODE";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_NO = "ENTITY_VERSION_NO";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_VALID_FROM = "VALID_FROM";

    private static final String COL_VALID_TO = "VALID_TO";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ID = "ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_NO, COL_PARTY_CODE, COL_VALID_FROM, COL_VALID_TO, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UPLOAD_REF_ID, COL_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, PARTY_CODE, VALID_FROM, VALID_TO, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UPLOAD_REF_ID, ID", TABLE, COL_ENTITY_REF_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, PARTY_CODE, VALID_FROM, VALID_TO, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UPLOAD_REF_ID, ID", TABLE, COL_ENTITY_REF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_ROLE_CODE, COL_ENTITY_VERSION_NO, COL_PARTY_CODE, COL_VALID_FROM, COL_VALID_TO, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UPLOAD_REF_ID, COL_ID, COL_ENTITY_REF_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_REF_ID);

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

    public int insert(Connection conn, FgProductRole fgproductrole) throws SQLException {
        logger.debug("Inserting fgproductrole: {}", fgproductrole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductRoleParams(ps, fgproductrole);
            ps.executeUpdate();
            return fgproductrole.getEntityRefID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductRole> fgproductroles) throws SQLException {
        if (fgproductroles == null || fgproductroles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductroles.size(); i++) {
            if (fgproductroles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductRole>> batches = chunkList(fgproductroles, batchSize);
        int[] totalResults = new int[fgproductroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductRole fgproductrole : batch) {
                        setFgProductRoleParams(ps, fgproductrole);
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

    public FgProductRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductRole fgproductrole) throws SQLException {
        if (fgproductrole.getEntityRefID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductRoleParams(ps, fgproductrole);
            ps.setInt(20, fgproductrole.getEntityRefID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductRole> fgproductroles) throws SQLException {
        if (fgproductroles == null || fgproductroles.isEmpty())
            return new int[0];
        for (FgProductRole fgproductrole : fgproductroles) {
            if (fgproductrole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductrole.getEntityRefID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductRole>> batches = chunkList(fgproductroles, batchSize);
        int[] totalResults = new int[fgproductroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductRole fgproductrole : batch) {
                        setFgProductRoleParams(ps, fgproductrole);
                        ps.setInt(20, fgproductrole.getEntityRefID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ENTITY_REF_ID, placeholders);
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

    private void setFgProductRoleParams(PreparedStatement ps, FgProductRole fgproductrole) throws SQLException {
        ps.setString(1, fgproductrole.getEntityTypeCode());
        ps.setString(2, fgproductrole.getEntitySubTypeCode());
        ps.setString(3, fgproductrole.getPartyTypeCode());
        ps.setString(4, fgproductrole.getPartySubTypeCode());
        ps.setString(5, fgproductrole.getPartyRoleCode());
        Integer val6 = fgproductrole.getEntityRefID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        java.math.BigDecimal val7 = fgproductrole.getEntityVersionNo();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgproductrole.getPartyCode());
        java.time.LocalDateTime val9 = fgproductrole.getValidFrom();
        if (val9 != null) {
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(val9));
        } else {
            ps.setNull(9, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val10 = fgproductrole.getValidTo();
        if (val10 != null) {
            ps.setTimestamp(10, java.sql.Timestamp.valueOf(val10));
        } else {
            ps.setNull(10, Types.TIMESTAMP);
        }
        ps.setString(11, fgproductrole.getActiveCode());
        ps.setString(12, fgproductrole.getStatusCode());
        ps.setString(13, fgproductrole.getCreatedOn());
        java.math.BigDecimal val14 = fgproductrole.getCreatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgproductrole.getLastUpdatedOn());
        java.math.BigDecimal val16 = fgproductrole.getLastUpdatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgproductrole.getLastAuthorisedOn());
        java.math.BigDecimal val18 = fgproductrole.getLastAuthorisedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = fgproductrole.getUploadRefID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = fgproductrole.getID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
    }

    private FgProductRole extract(ResultSet rs) throws SQLException {
        FgProductRole fgproductrole = new FgProductRole();
        fgproductrole.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductrole.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgproductrole.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgproductrole.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgproductrole.setPartyRoleCode(rs.getString(COL_PARTY_ROLE_CODE));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductrole.setEntityRefID(ENTITY_REF_ID);
        java.math.BigDecimal ENTITY_VERSION_NO = rs.getObject(COL_ENTITY_VERSION_NO, java.math.BigDecimal.class);
        fgproductrole.setEntityVersionNo(ENTITY_VERSION_NO);
        fgproductrole.setPartyCode(rs.getString(COL_PARTY_CODE));
        Timestamp VALID_FROM = rs.getTimestamp(COL_VALID_FROM);
        if (VALID_FROM != null)
            fgproductrole.setValidFrom(VALID_FROM.toLocalDateTime());
        Timestamp VALID_TO = rs.getTimestamp(COL_VALID_TO);
        if (VALID_TO != null)
            fgproductrole.setValidTo(VALID_TO.toLocalDateTime());
        fgproductrole.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductrole.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductrole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductrole.setCreatedBy(CREATED_BY);
        fgproductrole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductrole.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductrole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductrole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgproductrole.setUploadRefID(UPLOAD_REF_ID);
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductrole.setID(ID);
        return fgproductrole;
    }
}
