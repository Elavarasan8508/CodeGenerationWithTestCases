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

public class JdbcScfFileAttachmentsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfFileAttachmentsDao.class);

    private static final String TABLE = "SCF_FILE_ATTACHMENTS";

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

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FILE_TYPE = "FILE_TYPE";

    private static final String COL_FILE_SIZE = "FILE_SIZE";

    private static final String COL_FILE_ATTACHMENT = "FILE_ATTACHMENT";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_TYPE, COL_FILE_SIZE, COL_FILE_ATTACHMENT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_TYPE, FILE_SIZE, FILE_ATTACHMENT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REF_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_TYPE, FILE_SIZE, FILE_ATTACHMENT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REF_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_TYPE, COL_FILE_SIZE, COL_FILE_ATTACHMENT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, ScfFileAttachments scffileattachments) throws SQLException {
        logger.debug("Inserting scffileattachments: {}", scffileattachments);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfFileAttachmentsParams(ps, scffileattachments);
            ps.executeUpdate();
            return scffileattachments.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfFileAttachments> scffileattachmentss) throws SQLException {
        if (scffileattachmentss == null || scffileattachmentss.isEmpty())
            return new int[0];
        for (int i = 0; i < scffileattachmentss.size(); i++) {
            if (scffileattachmentss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileAttachments>> batches = chunkList(scffileattachmentss, batchSize);
        int[] totalResults = new int[scffileattachmentss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileAttachments> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfFileAttachments scffileattachments : batch) {
                        setScfFileAttachmentsParams(ps, scffileattachments);
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

    public ScfFileAttachments findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfFileAttachments> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfFileAttachments> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfFileAttachments scffileattachments) throws SQLException {
        if (scffileattachments.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfFileAttachmentsParams(ps, scffileattachments);
            ps.setInt(24, scffileattachments.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfFileAttachments> scffileattachmentss) throws SQLException {
        if (scffileattachmentss == null || scffileattachmentss.isEmpty())
            return new int[0];
        for (ScfFileAttachments scffileattachments : scffileattachmentss) {
            if (scffileattachments == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scffileattachments.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileAttachments>> batches = chunkList(scffileattachmentss, batchSize);
        int[] totalResults = new int[scffileattachmentss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileAttachments> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfFileAttachments scffileattachments : batch) {
                        setScfFileAttachmentsParams(ps, scffileattachments);
                        ps.setInt(24, scffileattachments.getID());
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

    private void setScfFileAttachmentsParams(PreparedStatement ps, ScfFileAttachments scffileattachments) throws SQLException {
        Integer val1 = scffileattachments.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scffileattachments.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scffileattachments.getTypeCode());
        ps.setString(4, scffileattachments.getSubTypeCode());
        ps.setString(5, scffileattachments.getActiveCode());
        ps.setString(6, scffileattachments.getStageCode());
        ps.setString(7, scffileattachments.getStatusCode());
        ps.setString(8, scffileattachments.getCreatedOn());
        java.math.BigDecimal val9 = scffileattachments.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scffileattachments.getLastUpdatedOn());
        java.math.BigDecimal val11 = scffileattachments.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scffileattachments.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scffileattachments.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scffileattachments.getTemplate());
        java.math.BigDecimal val15 = scffileattachments.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scffileattachments.getAnchorCrn());
        ps.setString(17, scffileattachments.getFileName());
        ps.setString(18, scffileattachments.getFileType());
        java.math.BigDecimal val19 = scffileattachments.getFileSize();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, scffileattachments.getFileAttachment());
        ps.setString(21, scffileattachments.getEntityTypeCode());
        ps.setString(22, scffileattachments.getEntitySubTypeCode());
        Integer val23 = scffileattachments.getEntityRefID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = scffileattachments.getEntityVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
    }

    private ScfFileAttachments extract(ResultSet rs) throws SQLException {
        ScfFileAttachments scffileattachments = new ScfFileAttachments();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scffileattachments.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scffileattachments.setReferenceID(REFERENCE_ID);
        scffileattachments.setTypeCode(rs.getString(COL_TYPE_CODE));
        scffileattachments.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scffileattachments.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scffileattachments.setStageCode(rs.getString(COL_STAGE_CODE));
        scffileattachments.setStatusCode(rs.getString(COL_STATUS_CODE));
        scffileattachments.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scffileattachments.setCreatedBy(CREATED_BY);
        scffileattachments.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scffileattachments.setLastUpdatedBy(LAST_UPDATED_BY);
        scffileattachments.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scffileattachments.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scffileattachments.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scffileattachments.setIsTemplate(IS_TEMPLATE);
        scffileattachments.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scffileattachments.setFileName(rs.getString(COL_FILE_NAME));
        scffileattachments.setFileType(rs.getString(COL_FILE_TYPE));
        java.math.BigDecimal FILE_SIZE = rs.getObject(COL_FILE_SIZE, java.math.BigDecimal.class);
        scffileattachments.setFileSize(FILE_SIZE);
        scffileattachments.setFileAttachment(rs.getString(COL_FILE_ATTACHMENT));
        scffileattachments.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        scffileattachments.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        scffileattachments.setEntityRefID(ENTITY_REF_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        scffileattachments.setEntityVersionID(ENTITY_VERSION_ID);
        return scffileattachments;
    }
}
