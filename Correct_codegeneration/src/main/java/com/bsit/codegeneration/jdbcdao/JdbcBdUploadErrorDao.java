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

public class JdbcBdUploadErrorDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcBdUploadErrorDao.class);

    private static final String TABLE = "BD_UPLOAD_ERROR";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_UPLOAD_ID = "UPLOAD_ID";

    private static final String COL_ERROR_CODE = "ERROR_CODE";

    private static final String COL_GRAVITY = "GRAVITY";

    private static final String COL_ERROR_VALUE = "ERROR_VALUE";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_COLUMN_NO = "COLUMN_NO";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_UPLOAD_ID, COL_ERROR_CODE, COL_GRAVITY, COL_ERROR_VALUE, COL_LINE_NO, COL_COLUMN_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_UPLOAD_ID, COL_ERROR_CODE, COL_GRAVITY, COL_ERROR_VALUE, COL_LINE_NO, COL_COLUMN_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, BdUploadError bduploaderror) throws SQLException {
        logger.debug("Inserting bduploaderror: {}", bduploaderror);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setBdUploadErrorParams(ps, bduploaderror);
            ps.executeUpdate();
            return bduploaderror.getID();
        }
    }

    public int[] insertAll(Connection conn, List<BdUploadError> bduploaderrors) throws SQLException {
        if (bduploaderrors == null || bduploaderrors.isEmpty())
            return new int[0];
        for (int i = 0; i < bduploaderrors.size(); i++) {
            if (bduploaderrors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BdUploadError>> batches = chunkList(bduploaderrors, batchSize);
        int[] totalResults = new int[bduploaderrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BdUploadError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (BdUploadError bduploaderror : batch) {
                        setBdUploadErrorParams(ps, bduploaderror);
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

    public BdUploadError findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<BdUploadError> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<BdUploadError> list = new ArrayList<>();
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

    public boolean update(Connection conn, BdUploadError bduploaderror) throws SQLException {
        if (bduploaderror.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setBdUploadErrorParams(ps, bduploaderror);
            ps.setInt(23, bduploaderror.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<BdUploadError> bduploaderrors) throws SQLException {
        if (bduploaderrors == null || bduploaderrors.isEmpty())
            return new int[0];
        for (BdUploadError bduploaderror : bduploaderrors) {
            if (bduploaderror == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (bduploaderror.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<BdUploadError>> batches = chunkList(bduploaderrors, batchSize);
        int[] totalResults = new int[bduploaderrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<BdUploadError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (BdUploadError bduploaderror : batch) {
                        setBdUploadErrorParams(ps, bduploaderror);
                        ps.setInt(23, bduploaderror.getID());
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

    private void setBdUploadErrorParams(PreparedStatement ps, BdUploadError bduploaderror) throws SQLException {
        Integer val1 = bduploaderror.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = bduploaderror.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, bduploaderror.getTypeCode());
        ps.setString(4, bduploaderror.getSubTypeCode());
        ps.setString(5, bduploaderror.getActiveCode());
        ps.setString(6, bduploaderror.getStageCode());
        ps.setString(7, bduploaderror.getStatusCode());
        ps.setString(8, bduploaderror.getCreatedOn());
        java.math.BigDecimal val9 = bduploaderror.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, bduploaderror.getLastUpdatedOn());
        java.math.BigDecimal val11 = bduploaderror.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, bduploaderror.getLastAuthorisedOn());
        java.math.BigDecimal val13 = bduploaderror.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, bduploaderror.getTemplate());
        java.math.BigDecimal val15 = bduploaderror.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = bduploaderror.getUploadID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, bduploaderror.getErrorCode());
        ps.setString(18, bduploaderror.getGravity());
        ps.setString(19, bduploaderror.getErrorValue());
        java.math.BigDecimal val20 = bduploaderror.getLineNo();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = bduploaderror.getColumnNo();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        Integer val22 = bduploaderror.getParentRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = bduploaderror.getParentVersionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
    }

    private BdUploadError extract(ResultSet rs) throws SQLException {
        BdUploadError bduploaderror = new BdUploadError();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        bduploaderror.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        bduploaderror.setReferenceID(REFERENCE_ID);
        bduploaderror.setTypeCode(rs.getString(COL_TYPE_CODE));
        bduploaderror.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        bduploaderror.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        bduploaderror.setStageCode(rs.getString(COL_STAGE_CODE));
        bduploaderror.setStatusCode(rs.getString(COL_STATUS_CODE));
        bduploaderror.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        bduploaderror.setCreatedBy(CREATED_BY);
        bduploaderror.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        bduploaderror.setLastUpdatedBy(LAST_UPDATED_BY);
        bduploaderror.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        bduploaderror.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        bduploaderror.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        bduploaderror.setIsTemplate(IS_TEMPLATE);
        Integer UPLOAD_ID = rs.getObject(COL_UPLOAD_ID, Integer.class);
        bduploaderror.setUploadID(UPLOAD_ID);
        bduploaderror.setErrorCode(rs.getString(COL_ERROR_CODE));
        bduploaderror.setGravity(rs.getString(COL_GRAVITY));
        bduploaderror.setErrorValue(rs.getString(COL_ERROR_VALUE));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        bduploaderror.setLineNo(LINE_NO);
        java.math.BigDecimal COLUMN_NO = rs.getObject(COL_COLUMN_NO, java.math.BigDecimal.class);
        bduploaderror.setColumnNo(COLUMN_NO);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        bduploaderror.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        bduploaderror.setParentVersionID(PARENT_VERSION_ID);
        return bduploaderror;
    }
}
