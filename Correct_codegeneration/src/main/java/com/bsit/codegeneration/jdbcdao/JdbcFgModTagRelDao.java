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

public class JdbcFgModTagRelDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModTagRelDao.class);

    private static final String TABLE = "FG_MOD_TAG_REL";

    private static final String COL_ID = "ID";

    private static final String COL_TAG_REFERENCE_NO = "TAG_REFERENCE_NO";

    private static final String COL_TARGET_ENTITY_TYPE_CODE = "TARGET_ENTITY_TYPE_CODE";

    private static final String COL_TARGET_ENTITY_SUB_TYPE_CODE = "TARGET_ENTITY_SUB_TYPE_CODE";

    private static final String COL_TARGET_ENTITY_REF_NO = "TARGET_ENTITY_REF_NO";

    private static final String COL_TARGET_ENTITY_VERSIONID = "TARGET_ENTITY_VERSIONID";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_TAG_REFERENCE_NO, COL_TARGET_ENTITY_TYPE_CODE, COL_TARGET_ENTITY_SUB_TYPE_CODE, COL_TARGET_ENTITY_REF_NO, COL_TARGET_ENTITY_VERSIONID, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TAG_REFERENCE_NO, COL_TARGET_ENTITY_TYPE_CODE, COL_TARGET_ENTITY_SUB_TYPE_CODE, COL_TARGET_ENTITY_REF_NO, COL_TARGET_ENTITY_VERSIONID, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgModTagRel fgmodtagrel) throws SQLException {
        logger.debug("Inserting fgmodtagrel: {}", fgmodtagrel);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModTagRelParams(ps, fgmodtagrel);
            ps.executeUpdate();
            return fgmodtagrel.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModTagRel> fgmodtagrels) throws SQLException {
        if (fgmodtagrels == null || fgmodtagrels.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodtagrels.size(); i++) {
            if (fgmodtagrels.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModTagRel>> batches = chunkList(fgmodtagrels, batchSize);
        int[] totalResults = new int[fgmodtagrels.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModTagRel> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModTagRel fgmodtagrel : batch) {
                        setFgModTagRelParams(ps, fgmodtagrel);
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

    public FgModTagRel findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModTagRel> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModTagRel> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModTagRel fgmodtagrel) throws SQLException {
        if (fgmodtagrel.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModTagRelParams(ps, fgmodtagrel);
            ps.setInt(12, fgmodtagrel.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModTagRel> fgmodtagrels) throws SQLException {
        if (fgmodtagrels == null || fgmodtagrels.isEmpty())
            return new int[0];
        for (FgModTagRel fgmodtagrel : fgmodtagrels) {
            if (fgmodtagrel == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodtagrel.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModTagRel>> batches = chunkList(fgmodtagrels, batchSize);
        int[] totalResults = new int[fgmodtagrels.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModTagRel> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModTagRel fgmodtagrel : batch) {
                        setFgModTagRelParams(ps, fgmodtagrel);
                        ps.setInt(12, fgmodtagrel.getID());
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

    private void setFgModTagRelParams(PreparedStatement ps, FgModTagRel fgmodtagrel) throws SQLException {
        Integer val1 = fgmodtagrel.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgmodtagrel.getTagReferenceNo());
        ps.setString(3, fgmodtagrel.getTargetEntityTypeCode());
        ps.setString(4, fgmodtagrel.getTargetEntitySubTypeCode());
        ps.setString(5, fgmodtagrel.getTargetEntityRefNo());
        java.math.BigDecimal val6 = fgmodtagrel.getTargetEntityVersionid();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = fgmodtagrel.getCreatedBy();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgmodtagrel.getCreatedOn());
        java.math.BigDecimal val9 = fgmodtagrel.getLastUpdatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodtagrel.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmodtagrel.getLastAuthorisedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmodtagrel.getLastAuthorisedOn());
    }

    private FgModTagRel extract(ResultSet rs) throws SQLException {
        FgModTagRel fgmodtagrel = new FgModTagRel();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodtagrel.setID(ID);
        fgmodtagrel.setTagReferenceNo(rs.getString(COL_TAG_REFERENCE_NO));
        fgmodtagrel.setTargetEntityTypeCode(rs.getString(COL_TARGET_ENTITY_TYPE_CODE));
        fgmodtagrel.setTargetEntitySubTypeCode(rs.getString(COL_TARGET_ENTITY_SUB_TYPE_CODE));
        fgmodtagrel.setTargetEntityRefNo(rs.getString(COL_TARGET_ENTITY_REF_NO));
        java.math.BigDecimal TARGET_ENTITY_VERSIONID = rs.getObject(COL_TARGET_ENTITY_VERSIONID, java.math.BigDecimal.class);
        fgmodtagrel.setTargetEntityVersionid(TARGET_ENTITY_VERSIONID);
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodtagrel.setCreatedBy(CREATED_BY);
        fgmodtagrel.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodtagrel.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodtagrel.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodtagrel.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodtagrel.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgmodtagrel;
    }
}
