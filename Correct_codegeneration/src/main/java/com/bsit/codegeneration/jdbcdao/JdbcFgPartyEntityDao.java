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

public class JdbcFgPartyEntityDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyEntityDao.class);

    private static final String TABLE = "FG_PARTY_ENTITY";

    private static final String COL_ID = "ID";

    private static final String COL_PARENT_PARTY_CODE = "PARENT_PARTY_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_REF_CODE = "ENTITY_REF_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_MASK = "MASK";

    private static final String COL_GRANTING = "GRANTING";

    private static final String COL_IS_MASTER = "IS_MASTER";

    private static final String COL_VERSION_NO = "VERSION_NO";

    private static final String COL_INITIATE_BY = "INITIATE_BY";

    private static final String COL_IS_TRANSACTION = "IS_TRANSACTION";

    private static final String COL_IS_VIEW = "IS_VIEW";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_AUTH_STATUS_CODE = "AUTH_STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_PARENT_PARTY_ID = "PARENT_PARTY_ID";

    private static final String COL_PARENT_PARTY_VERSION_ID = "PARENT_PARTY_VERSION_ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_ENTITY_ID = "ENTITY_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARENT_PARTY_CODE, COL_PARTY_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_ENTITY_REF_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_MASK, COL_GRANTING, COL_IS_MASTER, COL_VERSION_NO, COL_INITIATE_BY, COL_IS_TRANSACTION, COL_IS_VIEW, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_AUTH_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PARENT_PARTY_ID, COL_PARENT_PARTY_VERSION_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ENTITY_ID, COL_ENTITY_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARENT_PARTY_CODE, PARTY_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_REF_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, MASK, GRANTING, IS_MASTER, VERSION_NO, INITIATE_BY, IS_TRANSACTION, IS_VIEW, ACTIVE_CODE, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_ID, PARENT_PARTY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ENTITY_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARENT_PARTY_CODE, PARTY_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_REF_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, MASK, GRANTING, IS_MASTER, VERSION_NO, INITIATE_BY, IS_TRANSACTION, IS_VIEW, ACTIVE_CODE, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_ID, PARENT_PARTY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ENTITY_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARENT_PARTY_CODE, COL_PARTY_CODE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_ENTITY_REF_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_MASK, COL_GRANTING, COL_IS_MASTER, COL_VERSION_NO, COL_INITIATE_BY, COL_IS_TRANSACTION, COL_IS_VIEW, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_AUTH_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PARENT_PARTY_ID, COL_PARENT_PARTY_VERSION_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ENTITY_ID, COL_ENTITY_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgPartyEntity fgpartyentity) throws SQLException {
        logger.debug("Inserting fgpartyentity: {}", fgpartyentity);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyEntityParams(ps, fgpartyentity);
            ps.executeUpdate();
            return fgpartyentity.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyEntity> fgpartyentitys) throws SQLException {
        if (fgpartyentitys == null || fgpartyentitys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyentitys.size(); i++) {
            if (fgpartyentitys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyEntity>> batches = chunkList(fgpartyentitys, batchSize);
        int[] totalResults = new int[fgpartyentitys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyEntity> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyEntity fgpartyentity : batch) {
                        setFgPartyEntityParams(ps, fgpartyentity);
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

    public FgPartyEntity findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyEntity> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyEntity> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyEntity fgpartyentity) throws SQLException {
        if (fgpartyentity.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyEntityParams(ps, fgpartyentity);
            ps.setInt(30, fgpartyentity.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyEntity> fgpartyentitys) throws SQLException {
        if (fgpartyentitys == null || fgpartyentitys.isEmpty())
            return new int[0];
        for (FgPartyEntity fgpartyentity : fgpartyentitys) {
            if (fgpartyentity == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyentity.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyEntity>> batches = chunkList(fgpartyentitys, batchSize);
        int[] totalResults = new int[fgpartyentitys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyEntity> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyEntity fgpartyentity : batch) {
                        setFgPartyEntityParams(ps, fgpartyentity);
                        ps.setInt(30, fgpartyentity.getID());
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

    private void setFgPartyEntityParams(PreparedStatement ps, FgPartyEntity fgpartyentity) throws SQLException {
        Integer val1 = fgpartyentity.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpartyentity.getParentPartyCode());
        ps.setString(3, fgpartyentity.getPartyCode());
        ps.setString(4, fgpartyentity.getPartyTypeCode());
        ps.setString(5, fgpartyentity.getPartySubTypeCode());
        ps.setString(6, fgpartyentity.getEntityRefCode());
        ps.setString(7, fgpartyentity.getEntityTypeCode());
        ps.setString(8, fgpartyentity.getEntitySubTypeCode());
        java.math.BigDecimal val9 = fgpartyentity.getMask();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        java.math.BigDecimal val10 = fgpartyentity.getGranting();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.math.BigDecimal val11 = fgpartyentity.getIsMaster();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = fgpartyentity.getVersionNo();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgpartyentity.getInitiateBy());
        java.math.BigDecimal val14 = fgpartyentity.getIsTransaction();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgpartyentity.getIsView();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpartyentity.getActiveCode());
        ps.setString(17, fgpartyentity.getStatusCode());
        ps.setString(18, fgpartyentity.getAuthStatusCode());
        ps.setString(19, fgpartyentity.getCreatedOn());
        java.math.BigDecimal val20 = fgpartyentity.getCreatedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgpartyentity.getLastUpdatedOn());
        java.math.BigDecimal val22 = fgpartyentity.getLastUpdatedBy();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgpartyentity.getLastAuthorisedOn());
        java.math.BigDecimal val24 = fgpartyentity.getLastAuthorisedBy();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        Integer val25 = fgpartyentity.getParentPartyID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgpartyentity.getParentPartyVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgpartyentity.getPartyID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        Integer val28 = fgpartyentity.getPartyVersionID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        Integer val29 = fgpartyentity.getEntityID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        Integer val30 = fgpartyentity.getEntityVersionID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
    }

    private FgPartyEntity extract(ResultSet rs) throws SQLException {
        FgPartyEntity fgpartyentity = new FgPartyEntity();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyentity.setID(ID);
        fgpartyentity.setParentPartyCode(rs.getString(COL_PARENT_PARTY_CODE));
        fgpartyentity.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgpartyentity.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgpartyentity.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgpartyentity.setEntityRefCode(rs.getString(COL_ENTITY_REF_CODE));
        fgpartyentity.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgpartyentity.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        java.math.BigDecimal MASK = rs.getObject(COL_MASK, java.math.BigDecimal.class);
        fgpartyentity.setMask(MASK);
        java.math.BigDecimal GRANTING = rs.getObject(COL_GRANTING, java.math.BigDecimal.class);
        fgpartyentity.setGranting(GRANTING);
        java.math.BigDecimal IS_MASTER = rs.getObject(COL_IS_MASTER, java.math.BigDecimal.class);
        fgpartyentity.setIsMaster(IS_MASTER);
        java.math.BigDecimal VERSION_NO = rs.getObject(COL_VERSION_NO, java.math.BigDecimal.class);
        fgpartyentity.setVersionNo(VERSION_NO);
        fgpartyentity.setInitiateBy(rs.getString(COL_INITIATE_BY));
        java.math.BigDecimal IS_TRANSACTION = rs.getObject(COL_IS_TRANSACTION, java.math.BigDecimal.class);
        fgpartyentity.setIsTransaction(IS_TRANSACTION);
        java.math.BigDecimal IS_VIEW = rs.getObject(COL_IS_VIEW, java.math.BigDecimal.class);
        fgpartyentity.setIsView(IS_VIEW);
        fgpartyentity.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyentity.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyentity.setAuthStatusCode(rs.getString(COL_AUTH_STATUS_CODE));
        fgpartyentity.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyentity.setCreatedBy(CREATED_BY);
        fgpartyentity.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyentity.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyentity.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyentity.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PARENT_PARTY_ID = rs.getObject(COL_PARENT_PARTY_ID, Integer.class);
        fgpartyentity.setParentPartyID(PARENT_PARTY_ID);
        Integer PARENT_PARTY_VERSION_ID = rs.getObject(COL_PARENT_PARTY_VERSION_ID, Integer.class);
        fgpartyentity.setParentPartyVersionID(PARENT_PARTY_VERSION_ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyentity.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyentity.setPartyVersionID(PARTY_VERSION_ID);
        Integer ENTITY_ID = rs.getObject(COL_ENTITY_ID, Integer.class);
        fgpartyentity.setEntityID(ENTITY_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgpartyentity.setEntityVersionID(ENTITY_VERSION_ID);
        return fgpartyentity;
    }
}
