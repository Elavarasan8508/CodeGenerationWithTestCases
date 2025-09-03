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

public class JdbcScfFileLinesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfFileLinesDao.class);

    private static final String TABLE = "SCF_FILE_LINES";

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

    private static final String COL_ANCHOR_CRN = "ANCHOR_CRN";

    private static final String COL_FILE_MASTER_REF_NO = "FILE_MASTER_REF_NO";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_LINE_CONTENT = "LINE_CONTENT";

    private static final String COL_LINE_CONTENT_HASH_VALUE = "LINE_CONTENT_HASH_VALUE";

    private static final String COL_LINE_RECORD_TYPE = "LINE_RECORD_TYPE";

    private static final String COL_LINE_STATUS = "LINE_STATUS";

    private static final String COL_LINE_STATUS_REMARKS = "LINE_STATUS_REMARKS";

    private static final String COL_LINE_HASH_VAL_STATUS = "LINE_HASH_VAL_STATUS";

    private static final String COL_LINE_HASH_VAL_REMARKS = "LINE_HASH_VAL_REMARKS";

    private static final String COL_FILE_EVENT_REF_NO = "FILE_EVENT_REF_NO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_LINE_NO, COL_LINE_CONTENT, COL_LINE_CONTENT_HASH_VALUE, COL_LINE_RECORD_TYPE, COL_LINE_STATUS, COL_LINE_STATUS_REMARKS, COL_LINE_HASH_VAL_STATUS, COL_LINE_HASH_VAL_REMARKS, COL_FILE_EVENT_REF_NO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, LINE_NO, LINE_CONTENT, LINE_CONTENT_HASH_VALUE, LINE_RECORD_TYPE, LINE_STATUS, LINE_STATUS_REMARKS, LINE_HASH_VAL_STATUS, LINE_HASH_VAL_REMARKS, FILE_EVENT_REF_NO", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, LINE_NO, LINE_CONTENT, LINE_CONTENT_HASH_VALUE, LINE_RECORD_TYPE, LINE_STATUS, LINE_STATUS_REMARKS, LINE_HASH_VAL_STATUS, LINE_HASH_VAL_REMARKS, FILE_EVENT_REF_NO", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_LINE_NO, COL_LINE_CONTENT, COL_LINE_CONTENT_HASH_VALUE, COL_LINE_RECORD_TYPE, COL_LINE_STATUS, COL_LINE_STATUS_REMARKS, COL_LINE_HASH_VAL_STATUS, COL_LINE_HASH_VAL_REMARKS, COL_FILE_EVENT_REF_NO, COL_ID);

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

    public int insert(Connection conn, ScfFileLines scffilelines) throws SQLException {
        logger.debug("Inserting scffilelines: {}", scffilelines);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfFileLinesParams(ps, scffilelines);
            ps.executeUpdate();
            return scffilelines.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfFileLines> scffileliness) throws SQLException {
        if (scffileliness == null || scffileliness.isEmpty())
            return new int[0];
        for (int i = 0; i < scffileliness.size(); i++) {
            if (scffileliness.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileLines>> batches = chunkList(scffileliness, batchSize);
        int[] totalResults = new int[scffileliness.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileLines> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfFileLines scffilelines : batch) {
                        setScfFileLinesParams(ps, scffilelines);
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

    public ScfFileLines findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfFileLines> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfFileLines> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfFileLines scffilelines) throws SQLException {
        if (scffilelines.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfFileLinesParams(ps, scffilelines);
            ps.setInt(26, scffilelines.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfFileLines> scffileliness) throws SQLException {
        if (scffileliness == null || scffileliness.isEmpty())
            return new int[0];
        for (ScfFileLines scffilelines : scffileliness) {
            if (scffilelines == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scffilelines.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileLines>> batches = chunkList(scffileliness, batchSize);
        int[] totalResults = new int[scffileliness.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileLines> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfFileLines scffilelines : batch) {
                        setScfFileLinesParams(ps, scffilelines);
                        ps.setInt(26, scffilelines.getID());
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

    private void setScfFileLinesParams(PreparedStatement ps, ScfFileLines scffilelines) throws SQLException {
        Integer val1 = scffilelines.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scffilelines.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scffilelines.getTypeCode());
        ps.setString(4, scffilelines.getSubTypeCode());
        ps.setString(5, scffilelines.getActiveCode());
        ps.setString(6, scffilelines.getStageCode());
        ps.setString(7, scffilelines.getStatusCode());
        ps.setString(8, scffilelines.getCreatedOn());
        java.math.BigDecimal val9 = scffilelines.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scffilelines.getLastUpdatedOn());
        java.math.BigDecimal val11 = scffilelines.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scffilelines.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scffilelines.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scffilelines.getTemplate());
        java.math.BigDecimal val15 = scffilelines.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scffilelines.getAnchorCrn());
        ps.setString(17, scffilelines.getFileMasterRefNo());
        java.math.BigDecimal val18 = scffilelines.getLineNo();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, scffilelines.getLineContent());
        ps.setString(20, scffilelines.getLineContentHashValue());
        ps.setString(21, scffilelines.getLineRecordType());
        ps.setString(22, scffilelines.getLineStatus());
        ps.setString(23, scffilelines.getLineStatusRemarks());
        ps.setString(24, scffilelines.getLineHashValStatus());
        ps.setString(25, scffilelines.getLineHashValRemarks());
        ps.setString(26, scffilelines.getFileEventRefNo());
    }

    private ScfFileLines extract(ResultSet rs) throws SQLException {
        ScfFileLines scffilelines = new ScfFileLines();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scffilelines.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scffilelines.setReferenceID(REFERENCE_ID);
        scffilelines.setTypeCode(rs.getString(COL_TYPE_CODE));
        scffilelines.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scffilelines.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scffilelines.setStageCode(rs.getString(COL_STAGE_CODE));
        scffilelines.setStatusCode(rs.getString(COL_STATUS_CODE));
        scffilelines.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scffilelines.setCreatedBy(CREATED_BY);
        scffilelines.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scffilelines.setLastUpdatedBy(LAST_UPDATED_BY);
        scffilelines.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scffilelines.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scffilelines.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scffilelines.setIsTemplate(IS_TEMPLATE);
        scffilelines.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scffilelines.setFileMasterRefNo(rs.getString(COL_FILE_MASTER_REF_NO));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        scffilelines.setLineNo(LINE_NO);
        scffilelines.setLineContent(rs.getString(COL_LINE_CONTENT));
        scffilelines.setLineContentHashValue(rs.getString(COL_LINE_CONTENT_HASH_VALUE));
        scffilelines.setLineRecordType(rs.getString(COL_LINE_RECORD_TYPE));
        scffilelines.setLineStatus(rs.getString(COL_LINE_STATUS));
        scffilelines.setLineStatusRemarks(rs.getString(COL_LINE_STATUS_REMARKS));
        scffilelines.setLineHashValStatus(rs.getString(COL_LINE_HASH_VAL_STATUS));
        scffilelines.setLineHashValRemarks(rs.getString(COL_LINE_HASH_VAL_REMARKS));
        scffilelines.setFileEventRefNo(rs.getString(COL_FILE_EVENT_REF_NO));
        return scffilelines;
    }
}
