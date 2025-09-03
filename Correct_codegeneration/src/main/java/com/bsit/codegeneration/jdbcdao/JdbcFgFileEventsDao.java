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

public class JdbcFgFileEventsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFileEventsDao.class);

    private static final String TABLE = "FG_FILE_EVENTS";

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

    private static final String COL_EVENT_TYPE = "EVENT_TYPE";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_EVENT_NAME = "EVENT_NAME";

    private static final String COL_EVENT_SOURCE = "EVENT_SOURCE";

    private static final String COL_EVENT_TARGET = "EVENT_TARGET";

    private static final String COL_ENTITY_NAME = "ENTITY_NAME";

    private static final String COL_RECORD_COUNT = "RECORD_COUNT";

    private static final String COL_FILE_ATTACH_REF_NO = "FILE_ATTACH_REF_NO";

    private static final String COL_EVENT_STATUS = "EVENT_STATUS";

    private static final String COL_EVENT_REMARKS = "EVENT_REMARKS";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FILE_MASTER_REF_NO = "FILE_MASTER_REF_NO";

    private static final String COL_EVENT_BATCH_ID = "EVENT_BATCH_ID";

    private static final String COL_DISPLAY_SOURCE = "DISPLAY_SOURCE";

    private static final String COL_DISPLAY_TARGET = "DISPLAY_TARGET";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_TEMPLATE_VERSION_ID = "LAYOUT_TEMPLATE_VERSION_ID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_EVENT_TYPE, COL_EVENT_CODE, COL_EVENT_NAME, COL_EVENT_SOURCE, COL_EVENT_TARGET, COL_ENTITY_NAME, COL_RECORD_COUNT, COL_FILE_ATTACH_REF_NO, COL_EVENT_STATUS, COL_EVENT_REMARKS, COL_FILE_NAME, COL_FILE_MASTER_REF_NO, COL_EVENT_BATCH_ID, COL_DISPLAY_SOURCE, COL_DISPLAY_TARGET, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_UPLOAD_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, LAYOUT_NAME, LAYOUT_TEMPLATE_ID, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, LAYOUT_NAME, LAYOUT_TEMPLATE_ID, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_EVENT_TYPE, COL_EVENT_CODE, COL_EVENT_NAME, COL_EVENT_SOURCE, COL_EVENT_TARGET, COL_ENTITY_NAME, COL_RECORD_COUNT, COL_FILE_ATTACH_REF_NO, COL_EVENT_STATUS, COL_EVENT_REMARKS, COL_FILE_NAME, COL_FILE_MASTER_REF_NO, COL_EVENT_BATCH_ID, COL_DISPLAY_SOURCE, COL_DISPLAY_TARGET, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_UPLOAD_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ID);

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

    public int insert(Connection conn, FgFileEvents fgfileevents) throws SQLException {
        logger.debug("Inserting fgfileevents: {}", fgfileevents);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFileEventsParams(ps, fgfileevents);
            ps.executeUpdate();
            return fgfileevents.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFileEvents> fgfileeventss) throws SQLException {
        if (fgfileeventss == null || fgfileeventss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfileeventss.size(); i++) {
            if (fgfileeventss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileEvents>> batches = chunkList(fgfileeventss, batchSize);
        int[] totalResults = new int[fgfileeventss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileEvents> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFileEvents fgfileevents : batch) {
                        setFgFileEventsParams(ps, fgfileevents);
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

    public FgFileEvents findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFileEvents> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFileEvents> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFileEvents fgfileevents) throws SQLException {
        if (fgfileevents.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFileEventsParams(ps, fgfileevents);
            ps.setInt(37, fgfileevents.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFileEvents> fgfileeventss) throws SQLException {
        if (fgfileeventss == null || fgfileeventss.isEmpty())
            return new int[0];
        for (FgFileEvents fgfileevents : fgfileeventss) {
            if (fgfileevents == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfileevents.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileEvents>> batches = chunkList(fgfileeventss, batchSize);
        int[] totalResults = new int[fgfileeventss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileEvents> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFileEvents fgfileevents : batch) {
                        setFgFileEventsParams(ps, fgfileevents);
                        ps.setInt(37, fgfileevents.getID());
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

    private void setFgFileEventsParams(PreparedStatement ps, FgFileEvents fgfileevents) throws SQLException {
        Integer val1 = fgfileevents.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfileevents.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfileevents.getTypeCode());
        ps.setString(4, fgfileevents.getSubTypeCode());
        ps.setString(5, fgfileevents.getActiveCode());
        ps.setString(6, fgfileevents.getStageCode());
        ps.setString(7, fgfileevents.getStatusCode());
        ps.setString(8, fgfileevents.getCreatedOn());
        java.math.BigDecimal val9 = fgfileevents.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgfileevents.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgfileevents.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgfileevents.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgfileevents.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgfileevents.getTemplate());
        java.math.BigDecimal val15 = fgfileevents.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgfileevents.getAnchorCrn());
        ps.setString(17, fgfileevents.getEventType());
        ps.setString(18, fgfileevents.getEventCode());
        ps.setString(19, fgfileevents.getEventName());
        ps.setString(20, fgfileevents.getEventSource());
        ps.setString(21, fgfileevents.getEventTarget());
        ps.setString(22, fgfileevents.getEntityName());
        java.math.BigDecimal val23 = fgfileevents.getRecordCount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgfileevents.getFileAttachRefNo());
        ps.setString(25, fgfileevents.getEventStatus());
        ps.setString(26, fgfileevents.getEventRemarks());
        ps.setString(27, fgfileevents.getFileName());
        ps.setString(28, fgfileevents.getFileMasterRefNo());
        Integer val29 = fgfileevents.getEventBatchID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgfileevents.getDisplaySource());
        ps.setString(31, fgfileevents.getDisplayTarget());
        ps.setString(32, fgfileevents.getLayoutName());
        Integer val33 = fgfileevents.getLayoutTemplateID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        Integer val34 = fgfileevents.getLayoutTemplateVersionID();
        if (val34 != null) {
            ps.setInt(34, val34);
        } else {
            ps.setNull(34, Types.INTEGER);
        }
        Integer val35 = fgfileevents.getUploadRefID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
        ps.setString(36, fgfileevents.getEntitySubTypeCode());
        ps.setString(37, fgfileevents.getEntityTypeCode());
    }

    private FgFileEvents extract(ResultSet rs) throws SQLException {
        FgFileEvents fgfileevents = new FgFileEvents();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfileevents.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfileevents.setReferenceID(REFERENCE_ID);
        fgfileevents.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfileevents.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfileevents.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfileevents.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfileevents.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgfileevents.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfileevents.setCreatedBy(CREATED_BY);
        fgfileevents.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfileevents.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfileevents.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfileevents.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfileevents.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfileevents.setIsTemplate(IS_TEMPLATE);
        fgfileevents.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        fgfileevents.setEventType(rs.getString(COL_EVENT_TYPE));
        fgfileevents.setEventCode(rs.getString(COL_EVENT_CODE));
        fgfileevents.setEventName(rs.getString(COL_EVENT_NAME));
        fgfileevents.setEventSource(rs.getString(COL_EVENT_SOURCE));
        fgfileevents.setEventTarget(rs.getString(COL_EVENT_TARGET));
        fgfileevents.setEntityName(rs.getString(COL_ENTITY_NAME));
        java.math.BigDecimal RECORD_COUNT = rs.getObject(COL_RECORD_COUNT, java.math.BigDecimal.class);
        fgfileevents.setRecordCount(RECORD_COUNT);
        fgfileevents.setFileAttachRefNo(rs.getString(COL_FILE_ATTACH_REF_NO));
        fgfileevents.setEventStatus(rs.getString(COL_EVENT_STATUS));
        fgfileevents.setEventRemarks(rs.getString(COL_EVENT_REMARKS));
        fgfileevents.setFileName(rs.getString(COL_FILE_NAME));
        fgfileevents.setFileMasterRefNo(rs.getString(COL_FILE_MASTER_REF_NO));
        Integer EVENT_BATCH_ID = rs.getObject(COL_EVENT_BATCH_ID, Integer.class);
        fgfileevents.setEventBatchID(EVENT_BATCH_ID);
        fgfileevents.setDisplaySource(rs.getString(COL_DISPLAY_SOURCE));
        fgfileevents.setDisplayTarget(rs.getString(COL_DISPLAY_TARGET));
        fgfileevents.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgfileevents.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        Integer LAYOUT_TEMPLATE_VERSION_ID = rs.getObject(COL_LAYOUT_TEMPLATE_VERSION_ID, Integer.class);
        fgfileevents.setLayoutTemplateVersionID(LAYOUT_TEMPLATE_VERSION_ID);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfileevents.setUploadRefID(UPLOAD_REF_ID);
        fgfileevents.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgfileevents.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        return fgfileevents;
    }
}
