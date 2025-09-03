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

public class JdbcFgModEiEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModEiEventDao.class);

    private static final String TABLE = "FG_MOD_EI_EVENT";

    private static final String COL_ID = "ID";

    private static final String COL_FILE_REF_ID = "FILE_REF_ID";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_EVENT_DIRECTION_CODE = "EVENT_DIRECTION_CODE";

    private static final String COL_EVENT_STATUS_CODE = "EVENT_STATUS_CODE";

    private static final String COL_SOURCE_ENDPOINT_CODE = "SOURCE_ENDPOINT_CODE";

    private static final String COL_TARGET_ENDPOINT_CODE = "TARGET_ENDPOINT_CODE";

    private static final String COL_EVENT_REQ_FILE_NAME = "EVENT_REQ_FILE_NAME";

    private static final String COL_EVENT_REQUEST_DATE = "EVENT_REQUEST_DATE";

    private static final String COL_EVENT_REQUEST = "EVENT_REQUEST";

    private static final String COL_EVENT_RES_FILE_NAME = "EVENT_RES_FILE_NAME";

    private static final String COL_EVENT_RESPONSE_DATE = "EVENT_RESPONSE_DATE";

    private static final String COL_EVENT_RESPONSE = "EVENT_RESPONSE";

    private static final String COL_EVENT_ERROR_FILE_NAME = "EVENT_ERROR_FILE_NAME";

    private static final String COL_EVENT_ERROR_DATE = "EVENT_ERROR_DATE";

    private static final String COL_EVENT_ERROR = "EVENT_ERROR";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_MOD_EI_FILE_ID = "MOD_EI_FILE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_FILE_REF_ID, COL_EVENT_CODE, COL_EVENT_DIRECTION_CODE, COL_EVENT_STATUS_CODE, COL_SOURCE_ENDPOINT_CODE, COL_TARGET_ENDPOINT_CODE, COL_EVENT_REQ_FILE_NAME, COL_EVENT_REQUEST_DATE, COL_EVENT_REQUEST, COL_EVENT_RES_FILE_NAME, COL_EVENT_RESPONSE_DATE, COL_EVENT_RESPONSE, COL_EVENT_ERROR_FILE_NAME, COL_EVENT_ERROR_DATE, COL_EVENT_ERROR, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_MOD_EI_FILE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, FILE_REF_ID, EVENT_CODE, EVENT_DIRECTION_CODE, EVENT_STATUS_CODE, SOURCE_ENDPOINT_CODE, TARGET_ENDPOINT_CODE, EVENT_REQ_FILE_NAME, EVENT_REQUEST_DATE, EVENT_REQUEST, EVENT_RES_FILE_NAME, EVENT_RESPONSE_DATE, EVENT_RESPONSE, EVENT_ERROR_FILE_NAME, EVENT_ERROR_DATE, EVENT_ERROR, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MOD_EI_FILE_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, FILE_REF_ID, EVENT_CODE, EVENT_DIRECTION_CODE, EVENT_STATUS_CODE, SOURCE_ENDPOINT_CODE, TARGET_ENDPOINT_CODE, EVENT_REQ_FILE_NAME, EVENT_REQUEST_DATE, EVENT_REQUEST, EVENT_RES_FILE_NAME, EVENT_RESPONSE_DATE, EVENT_RESPONSE, EVENT_ERROR_FILE_NAME, EVENT_ERROR_DATE, EVENT_ERROR, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MOD_EI_FILE_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILE_REF_ID, COL_EVENT_CODE, COL_EVENT_DIRECTION_CODE, COL_EVENT_STATUS_CODE, COL_SOURCE_ENDPOINT_CODE, COL_TARGET_ENDPOINT_CODE, COL_EVENT_REQ_FILE_NAME, COL_EVENT_REQUEST_DATE, COL_EVENT_REQUEST, COL_EVENT_RES_FILE_NAME, COL_EVENT_RESPONSE_DATE, COL_EVENT_RESPONSE, COL_EVENT_ERROR_FILE_NAME, COL_EVENT_ERROR_DATE, COL_EVENT_ERROR, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_MOD_EI_FILE_ID, COL_ID);

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

    public int insert(Connection conn, FgModEiEvent fgmodeievent) throws SQLException {
        logger.debug("Inserting fgmodeievent: {}", fgmodeievent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModEiEventParams(ps, fgmodeievent);
            ps.executeUpdate();
            return fgmodeievent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModEiEvent> fgmodeievents) throws SQLException {
        if (fgmodeievents == null || fgmodeievents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodeievents.size(); i++) {
            if (fgmodeievents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModEiEvent>> batches = chunkList(fgmodeievents, batchSize);
        int[] totalResults = new int[fgmodeievents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModEiEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModEiEvent fgmodeievent : batch) {
                        setFgModEiEventParams(ps, fgmodeievent);
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

    public FgModEiEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModEiEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModEiEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModEiEvent fgmodeievent) throws SQLException {
        if (fgmodeievent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModEiEventParams(ps, fgmodeievent);
            ps.setInt(25, fgmodeievent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModEiEvent> fgmodeievents) throws SQLException {
        if (fgmodeievents == null || fgmodeievents.isEmpty())
            return new int[0];
        for (FgModEiEvent fgmodeievent : fgmodeievents) {
            if (fgmodeievent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodeievent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModEiEvent>> batches = chunkList(fgmodeievents, batchSize);
        int[] totalResults = new int[fgmodeievents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModEiEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModEiEvent fgmodeievent : batch) {
                        setFgModEiEventParams(ps, fgmodeievent);
                        ps.setInt(25, fgmodeievent.getID());
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

    private void setFgModEiEventParams(PreparedStatement ps, FgModEiEvent fgmodeievent) throws SQLException {
        Integer val1 = fgmodeievent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodeievent.getFileRefID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodeievent.getEventCode());
        ps.setString(4, fgmodeievent.getEventDirectionCode());
        ps.setString(5, fgmodeievent.getEventStatusCode());
        ps.setString(6, fgmodeievent.getSourceEndpointCode());
        ps.setString(7, fgmodeievent.getTargetEndpointCode());
        ps.setString(8, fgmodeievent.getEventReqFileName());
        ps.setString(9, fgmodeievent.getEventRequestDate());
        ps.setString(10, fgmodeievent.getEventRequest());
        ps.setString(11, fgmodeievent.getEventResFileName());
        ps.setString(12, fgmodeievent.getEventResponseDate());
        ps.setString(13, fgmodeievent.getEventResponse());
        ps.setString(14, fgmodeievent.getEventErrorFileName());
        ps.setString(15, fgmodeievent.getEventErrorDate());
        ps.setString(16, fgmodeievent.getEventError());
        ps.setString(17, fgmodeievent.getActiveCode());
        ps.setString(18, fgmodeievent.getStatusCode());
        ps.setString(19, fgmodeievent.getCreatedOn());
        java.math.BigDecimal val20 = fgmodeievent.getCreatedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgmodeievent.getLastUpdatedOn());
        java.math.BigDecimal val22 = fgmodeievent.getLastUpdatedBy();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgmodeievent.getLastAuthorisedOn());
        java.math.BigDecimal val24 = fgmodeievent.getLastAuthorisedBy();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        Integer val25 = fgmodeievent.getModEiFileID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
    }

    private FgModEiEvent extract(ResultSet rs) throws SQLException {
        FgModEiEvent fgmodeievent = new FgModEiEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodeievent.setID(ID);
        Integer FILE_REF_ID = rs.getObject(COL_FILE_REF_ID, Integer.class);
        fgmodeievent.setFileRefID(FILE_REF_ID);
        fgmodeievent.setEventCode(rs.getString(COL_EVENT_CODE));
        fgmodeievent.setEventDirectionCode(rs.getString(COL_EVENT_DIRECTION_CODE));
        fgmodeievent.setEventStatusCode(rs.getString(COL_EVENT_STATUS_CODE));
        fgmodeievent.setSourceEndpointCode(rs.getString(COL_SOURCE_ENDPOINT_CODE));
        fgmodeievent.setTargetEndpointCode(rs.getString(COL_TARGET_ENDPOINT_CODE));
        fgmodeievent.setEventReqFileName(rs.getString(COL_EVENT_REQ_FILE_NAME));
        fgmodeievent.setEventRequestDate(rs.getString(COL_EVENT_REQUEST_DATE));
        fgmodeievent.setEventRequest(rs.getString(COL_EVENT_REQUEST));
        fgmodeievent.setEventResFileName(rs.getString(COL_EVENT_RES_FILE_NAME));
        fgmodeievent.setEventResponseDate(rs.getString(COL_EVENT_RESPONSE_DATE));
        fgmodeievent.setEventResponse(rs.getString(COL_EVENT_RESPONSE));
        fgmodeievent.setEventErrorFileName(rs.getString(COL_EVENT_ERROR_FILE_NAME));
        fgmodeievent.setEventErrorDate(rs.getString(COL_EVENT_ERROR_DATE));
        fgmodeievent.setEventError(rs.getString(COL_EVENT_ERROR));
        fgmodeievent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodeievent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodeievent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodeievent.setCreatedBy(CREATED_BY);
        fgmodeievent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodeievent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodeievent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodeievent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer MOD_EI_FILE_ID = rs.getObject(COL_MOD_EI_FILE_ID, Integer.class);
        fgmodeievent.setModEiFileID(MOD_EI_FILE_ID);
        return fgmodeievent;
    }
}
