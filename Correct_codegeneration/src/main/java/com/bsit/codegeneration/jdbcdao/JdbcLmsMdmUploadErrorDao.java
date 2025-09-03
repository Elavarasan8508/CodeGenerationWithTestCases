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

public class JdbcLmsMdmUploadErrorDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLmsMdmUploadErrorDao.class);

    private static final String TABLE = "LMS_MDM_UPLOAD_ERROR";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_UPLOAD_ID = "UPLOAD_ID";

    private static final String COL_ERROR_CODE = "ERROR_CODE";

    private static final String COL_GRAVITY = "GRAVITY";

    private static final String COL_ERROR_VALUE = "ERROR_VALUE";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_COLUMN_NO = "COLUMN_NO";

    private static final String COL_UPLOAD_VERSION_ID = "UPLOAD_VERSION_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_UPLOAD_ID, COL_ERROR_CODE, COL_GRAVITY, COL_ERROR_VALUE, COL_LINE_NO, COL_COLUMN_NO, COL_UPLOAD_VERSION_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, UPLOAD_VERSION_ID, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, UPLOAD_VERSION_ID, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_UPLOAD_ID, COL_ERROR_CODE, COL_GRAVITY, COL_ERROR_VALUE, COL_LINE_NO, COL_COLUMN_NO, COL_UPLOAD_VERSION_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, LmsMdmUploadError lmsmdmuploaderror) throws SQLException {
        logger.debug("Inserting lmsmdmuploaderror: {}", lmsmdmuploaderror);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLmsMdmUploadErrorParams(ps, lmsmdmuploaderror);
            ps.executeUpdate();
            return lmsmdmuploaderror.getID();
        }
    }

    public int[] insertAll(Connection conn, List<LmsMdmUploadError> lmsmdmuploaderrors) throws SQLException {
        if (lmsmdmuploaderrors == null || lmsmdmuploaderrors.isEmpty())
            return new int[0];
        for (int i = 0; i < lmsmdmuploaderrors.size(); i++) {
            if (lmsmdmuploaderrors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmUploadError>> batches = chunkList(lmsmdmuploaderrors, batchSize);
        int[] totalResults = new int[lmsmdmuploaderrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmUploadError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LmsMdmUploadError lmsmdmuploaderror : batch) {
                        setLmsMdmUploadErrorParams(ps, lmsmdmuploaderror);
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

    public LmsMdmUploadError findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LmsMdmUploadError> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LmsMdmUploadError> list = new ArrayList<>();
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

    public boolean update(Connection conn, LmsMdmUploadError lmsmdmuploaderror) throws SQLException {
        if (lmsmdmuploaderror.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLmsMdmUploadErrorParams(ps, lmsmdmuploaderror);
            ps.setInt(27, lmsmdmuploaderror.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LmsMdmUploadError> lmsmdmuploaderrors) throws SQLException {
        if (lmsmdmuploaderrors == null || lmsmdmuploaderrors.isEmpty())
            return new int[0];
        for (LmsMdmUploadError lmsmdmuploaderror : lmsmdmuploaderrors) {
            if (lmsmdmuploaderror == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (lmsmdmuploaderror.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LmsMdmUploadError>> batches = chunkList(lmsmdmuploaderrors, batchSize);
        int[] totalResults = new int[lmsmdmuploaderrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LmsMdmUploadError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LmsMdmUploadError lmsmdmuploaderror : batch) {
                        setLmsMdmUploadErrorParams(ps, lmsmdmuploaderror);
                        ps.setInt(27, lmsmdmuploaderror.getID());
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

    private void setLmsMdmUploadErrorParams(PreparedStatement ps, LmsMdmUploadError lmsmdmuploaderror) throws SQLException {
        Integer val1 = lmsmdmuploaderror.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = lmsmdmuploaderror.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, lmsmdmuploaderror.getTypeCode());
        ps.setString(4, lmsmdmuploaderror.getSubTypeCode());
        ps.setString(5, lmsmdmuploaderror.getActiveCode());
        ps.setString(6, lmsmdmuploaderror.getStageCode());
        ps.setString(7, lmsmdmuploaderror.getStatusCode());
        Integer val8 = lmsmdmuploaderror.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, lmsmdmuploaderror.getCreatedOn());
        java.math.BigDecimal val10 = lmsmdmuploaderror.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, lmsmdmuploaderror.getLastUpdatedOn());
        java.math.BigDecimal val12 = lmsmdmuploaderror.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, lmsmdmuploaderror.getLastAuthorisedOn());
        java.math.BigDecimal val14 = lmsmdmuploaderror.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, lmsmdmuploaderror.getTemplate());
        ps.setString(16, lmsmdmuploaderror.getApplicantParty());
        ps.setString(17, lmsmdmuploaderror.getFulfillmentParty());
        java.math.BigDecimal val18 = lmsmdmuploaderror.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = lmsmdmuploaderror.getUploadID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, lmsmdmuploaderror.getErrorCode());
        ps.setString(21, lmsmdmuploaderror.getGravity());
        ps.setString(22, lmsmdmuploaderror.getErrorValue());
        java.math.BigDecimal val23 = lmsmdmuploaderror.getLineNo();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = lmsmdmuploaderror.getColumnNo();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        Integer val25 = lmsmdmuploaderror.getUploadVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = lmsmdmuploaderror.getParentRefID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = lmsmdmuploaderror.getParentVersionID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
    }

    private LmsMdmUploadError extract(ResultSet rs) throws SQLException {
        LmsMdmUploadError lmsmdmuploaderror = new LmsMdmUploadError();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        lmsmdmuploaderror.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        lmsmdmuploaderror.setReferenceID(REFERENCE_ID);
        lmsmdmuploaderror.setTypeCode(rs.getString(COL_TYPE_CODE));
        lmsmdmuploaderror.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        lmsmdmuploaderror.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        lmsmdmuploaderror.setStageCode(rs.getString(COL_STAGE_CODE));
        lmsmdmuploaderror.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        lmsmdmuploaderror.setProcessID(PROCESS_ID);
        lmsmdmuploaderror.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        lmsmdmuploaderror.setCreatedBy(CREATED_BY);
        lmsmdmuploaderror.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        lmsmdmuploaderror.setLastUpdatedBy(LAST_UPDATED_BY);
        lmsmdmuploaderror.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        lmsmdmuploaderror.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        lmsmdmuploaderror.setTemplate(rs.getString(COL_TEMPLATE));
        lmsmdmuploaderror.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        lmsmdmuploaderror.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        lmsmdmuploaderror.setIsTemplate(IS_TEMPLATE);
        Integer UPLOAD_ID = rs.getObject(COL_UPLOAD_ID, Integer.class);
        lmsmdmuploaderror.setUploadID(UPLOAD_ID);
        lmsmdmuploaderror.setErrorCode(rs.getString(COL_ERROR_CODE));
        lmsmdmuploaderror.setGravity(rs.getString(COL_GRAVITY));
        lmsmdmuploaderror.setErrorValue(rs.getString(COL_ERROR_VALUE));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        lmsmdmuploaderror.setLineNo(LINE_NO);
        java.math.BigDecimal COLUMN_NO = rs.getObject(COL_COLUMN_NO, java.math.BigDecimal.class);
        lmsmdmuploaderror.setColumnNo(COLUMN_NO);
        Integer UPLOAD_VERSION_ID = rs.getObject(COL_UPLOAD_VERSION_ID, Integer.class);
        lmsmdmuploaderror.setUploadVersionID(UPLOAD_VERSION_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        lmsmdmuploaderror.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        lmsmdmuploaderror.setParentVersionID(PARENT_VERSION_ID);
        return lmsmdmuploaderror;
    }
}
