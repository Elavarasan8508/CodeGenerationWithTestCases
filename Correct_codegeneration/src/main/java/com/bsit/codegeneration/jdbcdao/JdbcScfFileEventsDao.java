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

public class JdbcScfFileEventsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfFileEventsDao.class);

    private static final String TABLE = "SCF_FILE_EVENTS";

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

    private static final String COL_RETRIGGER_COUNT = "RETRIGGER_COUNT";

    private static final String COL_EVENT_FINPAY_ID = "EVENT_FINPAY_ID";

    private static final String COL_FINTECH_SOURCE = "FINTECH_SOURCE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_EVENT_TYPE, COL_EVENT_CODE, COL_EVENT_NAME, COL_EVENT_SOURCE, COL_EVENT_TARGET, COL_ENTITY_NAME, COL_RECORD_COUNT, COL_FILE_ATTACH_REF_NO, COL_EVENT_STATUS, COL_EVENT_REMARKS, COL_FILE_NAME, COL_FILE_MASTER_REF_NO, COL_EVENT_BATCH_ID, COL_DISPLAY_SOURCE, COL_DISPLAY_TARGET, COL_RETRIGGER_COUNT, COL_EVENT_FINPAY_ID, COL_FINTECH_SOURCE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, RETRIGGER_COUNT, EVENT_FINPAY_ID, FINTECH_SOURCE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, RETRIGGER_COUNT, EVENT_FINPAY_ID, FINTECH_SOURCE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_EVENT_TYPE, COL_EVENT_CODE, COL_EVENT_NAME, COL_EVENT_SOURCE, COL_EVENT_TARGET, COL_ENTITY_NAME, COL_RECORD_COUNT, COL_FILE_ATTACH_REF_NO, COL_EVENT_STATUS, COL_EVENT_REMARKS, COL_FILE_NAME, COL_FILE_MASTER_REF_NO, COL_EVENT_BATCH_ID, COL_DISPLAY_SOURCE, COL_DISPLAY_TARGET, COL_RETRIGGER_COUNT, COL_EVENT_FINPAY_ID, COL_FINTECH_SOURCE, COL_ID);

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

    public int insert(Connection conn, ScfFileEvents scffileevents) throws SQLException {
        logger.debug("Inserting scffileevents: {}", scffileevents);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfFileEventsParams(ps, scffileevents);
            ps.executeUpdate();
            return scffileevents.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfFileEvents> scffileeventss) throws SQLException {
        if (scffileeventss == null || scffileeventss.isEmpty())
            return new int[0];
        for (int i = 0; i < scffileeventss.size(); i++) {
            if (scffileeventss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileEvents>> batches = chunkList(scffileeventss, batchSize);
        int[] totalResults = new int[scffileeventss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileEvents> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfFileEvents scffileevents : batch) {
                        setScfFileEventsParams(ps, scffileevents);
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

    public ScfFileEvents findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfFileEvents> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfFileEvents> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfFileEvents scffileevents) throws SQLException {
        if (scffileevents.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfFileEventsParams(ps, scffileevents);
            ps.setInt(34, scffileevents.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfFileEvents> scffileeventss) throws SQLException {
        if (scffileeventss == null || scffileeventss.isEmpty())
            return new int[0];
        for (ScfFileEvents scffileevents : scffileeventss) {
            if (scffileevents == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scffileevents.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileEvents>> batches = chunkList(scffileeventss, batchSize);
        int[] totalResults = new int[scffileeventss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileEvents> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfFileEvents scffileevents : batch) {
                        setScfFileEventsParams(ps, scffileevents);
                        ps.setInt(34, scffileevents.getID());
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

    private void setScfFileEventsParams(PreparedStatement ps, ScfFileEvents scffileevents) throws SQLException {
        Integer val1 = scffileevents.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scffileevents.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scffileevents.getTypeCode());
        ps.setString(4, scffileevents.getSubTypeCode());
        ps.setString(5, scffileevents.getActiveCode());
        ps.setString(6, scffileevents.getStageCode());
        ps.setString(7, scffileevents.getStatusCode());
        ps.setString(8, scffileevents.getCreatedOn());
        java.math.BigDecimal val9 = scffileevents.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scffileevents.getLastUpdatedOn());
        java.math.BigDecimal val11 = scffileevents.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scffileevents.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scffileevents.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scffileevents.getTemplate());
        java.math.BigDecimal val15 = scffileevents.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scffileevents.getAnchorCrn());
        ps.setString(17, scffileevents.getEventType());
        ps.setString(18, scffileevents.getEventCode());
        ps.setString(19, scffileevents.getEventName());
        ps.setString(20, scffileevents.getEventSource());
        ps.setString(21, scffileevents.getEventTarget());
        ps.setString(22, scffileevents.getEntityName());
        java.math.BigDecimal val23 = scffileevents.getRecordCount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, scffileevents.getFileAttachRefNo());
        ps.setString(25, scffileevents.getEventStatus());
        ps.setString(26, scffileevents.getEventRemarks());
        ps.setString(27, scffileevents.getFileName());
        ps.setString(28, scffileevents.getFileMasterRefNo());
        Integer val29 = scffileevents.getEventBatchID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, scffileevents.getDisplaySource());
        ps.setString(31, scffileevents.getDisplayTarget());
        java.math.BigDecimal val32 = scffileevents.getRetriggerCount();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        Integer val33 = scffileevents.getEventFinpayID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        ps.setString(34, scffileevents.getFintechSource());
    }

    private ScfFileEvents extract(ResultSet rs) throws SQLException {
        ScfFileEvents scffileevents = new ScfFileEvents();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scffileevents.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scffileevents.setReferenceID(REFERENCE_ID);
        scffileevents.setTypeCode(rs.getString(COL_TYPE_CODE));
        scffileevents.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scffileevents.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scffileevents.setStageCode(rs.getString(COL_STAGE_CODE));
        scffileevents.setStatusCode(rs.getString(COL_STATUS_CODE));
        scffileevents.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scffileevents.setCreatedBy(CREATED_BY);
        scffileevents.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scffileevents.setLastUpdatedBy(LAST_UPDATED_BY);
        scffileevents.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scffileevents.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scffileevents.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scffileevents.setIsTemplate(IS_TEMPLATE);
        scffileevents.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scffileevents.setEventType(rs.getString(COL_EVENT_TYPE));
        scffileevents.setEventCode(rs.getString(COL_EVENT_CODE));
        scffileevents.setEventName(rs.getString(COL_EVENT_NAME));
        scffileevents.setEventSource(rs.getString(COL_EVENT_SOURCE));
        scffileevents.setEventTarget(rs.getString(COL_EVENT_TARGET));
        scffileevents.setEntityName(rs.getString(COL_ENTITY_NAME));
        java.math.BigDecimal RECORD_COUNT = rs.getObject(COL_RECORD_COUNT, java.math.BigDecimal.class);
        scffileevents.setRecordCount(RECORD_COUNT);
        scffileevents.setFileAttachRefNo(rs.getString(COL_FILE_ATTACH_REF_NO));
        scffileevents.setEventStatus(rs.getString(COL_EVENT_STATUS));
        scffileevents.setEventRemarks(rs.getString(COL_EVENT_REMARKS));
        scffileevents.setFileName(rs.getString(COL_FILE_NAME));
        scffileevents.setFileMasterRefNo(rs.getString(COL_FILE_MASTER_REF_NO));
        Integer EVENT_BATCH_ID = rs.getObject(COL_EVENT_BATCH_ID, Integer.class);
        scffileevents.setEventBatchID(EVENT_BATCH_ID);
        scffileevents.setDisplaySource(rs.getString(COL_DISPLAY_SOURCE));
        scffileevents.setDisplayTarget(rs.getString(COL_DISPLAY_TARGET));
        java.math.BigDecimal RETRIGGER_COUNT = rs.getObject(COL_RETRIGGER_COUNT, java.math.BigDecimal.class);
        scffileevents.setRetriggerCount(RETRIGGER_COUNT);
        Integer EVENT_FINPAY_ID = rs.getObject(COL_EVENT_FINPAY_ID, Integer.class);
        scffileevents.setEventFinpayID(EVENT_FINPAY_ID);
        scffileevents.setFintechSource(rs.getString(COL_FINTECH_SOURCE));
        return scffileevents;
    }
}
