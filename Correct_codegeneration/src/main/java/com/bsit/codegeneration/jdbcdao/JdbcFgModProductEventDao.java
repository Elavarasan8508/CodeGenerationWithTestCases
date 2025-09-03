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

public class JdbcFgModProductEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModProductEventDao.class);

    private static final String TABLE = "FG_MOD_PRODUCT_EVENT";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_EVENT_STAGE_CODE = "EVENT_STAGE_CODE";

    private static final String COL_EVENT_FORM_ID = "EVENT_FORM_ID";

    private static final String COL_EVENT_BO_REF_NO = "EVENT_BO_REF_NO";

    private static final String COL_EVENT_BO_CODE = "EVENT_BO_CODE";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_NO = "ENTITY_VERSION_NO";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_BO_REF_NO = "ENTITY_BO_REF_NO";

    private static final String COL_ENTITY_BO_CODE = "ENTITY_BO_CODE";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_EVENT_STATUS_CODE = "EVENT_STATUS_CODE";

    private static final String COL_EVENT_TYPE_CODE = "EVENT_TYPE_CODE";

    private static final String COL_EVENT_SUB_TYPE_CODE = "EVENT_SUB_TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_REFERENCE_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_EVENT_CODE, COL_EVENT_STAGE_CODE, COL_EVENT_FORM_ID, COL_EVENT_BO_REF_NO, COL_EVENT_BO_CODE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_NO, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_BO_REF_NO, COL_ENTITY_BO_CODE, COL_TEMPLATE, COL_STAGE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_EVENT_STATUS_CODE, COL_EVENT_TYPE_CODE, COL_EVENT_SUB_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, EVENT_CODE, EVENT_STAGE_CODE, EVENT_FORM_ID, EVENT_BO_REF_NO, EVENT_BO_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_BO_REF_NO, ENTITY_BO_CODE, TEMPLATE, STAGE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, EVENT_STATUS_CODE, EVENT_TYPE_CODE, EVENT_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, EVENT_CODE, EVENT_STAGE_CODE, EVENT_FORM_ID, EVENT_BO_REF_NO, EVENT_BO_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_BO_REF_NO, ENTITY_BO_CODE, TEMPLATE, STAGE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, EVENT_STATUS_CODE, EVENT_TYPE_CODE, EVENT_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_REFERENCE_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_EVENT_CODE, COL_EVENT_STAGE_CODE, COL_EVENT_FORM_ID, COL_EVENT_BO_REF_NO, COL_EVENT_BO_CODE, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_NO, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_BO_REF_NO, COL_ENTITY_BO_CODE, COL_TEMPLATE, COL_STAGE_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_EVENT_STATUS_CODE, COL_EVENT_TYPE_CODE, COL_EVENT_SUB_TYPE_CODE, COL_ID);

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

    public int insert(Connection conn, FgModProductEvent fgmodproductevent) throws SQLException {
        logger.debug("Inserting fgmodproductevent: {}", fgmodproductevent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModProductEventParams(ps, fgmodproductevent);
            ps.executeUpdate();
            return fgmodproductevent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModProductEvent> fgmodproductevents) throws SQLException {
        if (fgmodproductevents == null || fgmodproductevents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodproductevents.size(); i++) {
            if (fgmodproductevents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductEvent>> batches = chunkList(fgmodproductevents, batchSize);
        int[] totalResults = new int[fgmodproductevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModProductEvent fgmodproductevent : batch) {
                        setFgModProductEventParams(ps, fgmodproductevent);
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

    public FgModProductEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModProductEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModProductEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModProductEvent fgmodproductevent) throws SQLException {
        if (fgmodproductevent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModProductEventParams(ps, fgmodproductevent);
            ps.setInt(33, fgmodproductevent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModProductEvent> fgmodproductevents) throws SQLException {
        if (fgmodproductevents == null || fgmodproductevents.isEmpty())
            return new int[0];
        for (FgModProductEvent fgmodproductevent : fgmodproductevents) {
            if (fgmodproductevent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodproductevent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductEvent>> batches = chunkList(fgmodproductevents, batchSize);
        int[] totalResults = new int[fgmodproductevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModProductEvent fgmodproductevent : batch) {
                        setFgModProductEventParams(ps, fgmodproductevent);
                        ps.setInt(33, fgmodproductevent.getID());
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

    private void setFgModProductEventParams(PreparedStatement ps, FgModProductEvent fgmodproductevent) throws SQLException {
        Integer val1 = fgmodproductevent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodproductevent.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.math.BigDecimal val3 = fgmodproductevent.getIsMasterVersion();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        Integer val4 = fgmodproductevent.getReferenceID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgmodproductevent.getParentRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Integer val6 = fgmodproductevent.getParentVersionID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        ps.setString(7, fgmodproductevent.getTypeCode());
        ps.setString(8, fgmodproductevent.getSubTypeCode());
        ps.setString(9, fgmodproductevent.getEventCode());
        ps.setString(10, fgmodproductevent.getEventStageCode());
        Integer val11 = fgmodproductevent.getEventFormID();
        if (val11 != null) {
            ps.setInt(11, val11);
        } else {
            ps.setNull(11, Types.INTEGER);
        }
        ps.setString(12, fgmodproductevent.getEventBoRefNo());
        ps.setString(13, fgmodproductevent.getEventBoCode());
        Integer val14 = fgmodproductevent.getEntityRefID();
        if (val14 != null) {
            ps.setInt(14, val14);
        } else {
            ps.setNull(14, Types.INTEGER);
        }
        java.math.BigDecimal val15 = fgmodproductevent.getEntityVersionNo();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgmodproductevent.getEntityTypeCode());
        ps.setString(17, fgmodproductevent.getEntitySubTypeCode());
        ps.setString(18, fgmodproductevent.getEntityBoRefNo());
        ps.setString(19, fgmodproductevent.getEntityBoCode());
        ps.setString(20, fgmodproductevent.getTemplate());
        ps.setString(21, fgmodproductevent.getStageCode());
        ps.setString(22, fgmodproductevent.getActiveCode());
        ps.setString(23, fgmodproductevent.getStatusCode());
        ps.setString(24, fgmodproductevent.getCreatedOn());
        java.math.BigDecimal val25 = fgmodproductevent.getCreatedBy();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgmodproductevent.getLastUpdatedOn());
        java.math.BigDecimal val27 = fgmodproductevent.getLastUpdatedBy();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgmodproductevent.getLastAuthorisedOn());
        java.math.BigDecimal val29 = fgmodproductevent.getLastAuthorisedBy();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        Integer val30 = fgmodproductevent.getProcessID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        ps.setString(31, fgmodproductevent.getEventStatusCode());
        ps.setString(32, fgmodproductevent.getEventTypeCode());
        ps.setString(33, fgmodproductevent.getEventSubTypeCode());
    }

    private FgModProductEvent extract(ResultSet rs) throws SQLException {
        FgModProductEvent fgmodproductevent = new FgModProductEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodproductevent.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodproductevent.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodproductevent.setIsMasterVersion(IS_MASTER_VERSION);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodproductevent.setReferenceID(REFERENCE_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgmodproductevent.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgmodproductevent.setParentVersionID(PARENT_VERSION_ID);
        fgmodproductevent.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodproductevent.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmodproductevent.setEventCode(rs.getString(COL_EVENT_CODE));
        fgmodproductevent.setEventStageCode(rs.getString(COL_EVENT_STAGE_CODE));
        Integer EVENT_FORM_ID = rs.getObject(COL_EVENT_FORM_ID, Integer.class);
        fgmodproductevent.setEventFormID(EVENT_FORM_ID);
        fgmodproductevent.setEventBoRefNo(rs.getString(COL_EVENT_BO_REF_NO));
        fgmodproductevent.setEventBoCode(rs.getString(COL_EVENT_BO_CODE));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgmodproductevent.setEntityRefID(ENTITY_REF_ID);
        java.math.BigDecimal ENTITY_VERSION_NO = rs.getObject(COL_ENTITY_VERSION_NO, java.math.BigDecimal.class);
        fgmodproductevent.setEntityVersionNo(ENTITY_VERSION_NO);
        fgmodproductevent.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgmodproductevent.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgmodproductevent.setEntityBoRefNo(rs.getString(COL_ENTITY_BO_REF_NO));
        fgmodproductevent.setEntityBoCode(rs.getString(COL_ENTITY_BO_CODE));
        fgmodproductevent.setTemplate(rs.getString(COL_TEMPLATE));
        fgmodproductevent.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmodproductevent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodproductevent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodproductevent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodproductevent.setCreatedBy(CREATED_BY);
        fgmodproductevent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodproductevent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodproductevent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodproductevent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgmodproductevent.setProcessID(PROCESS_ID);
        fgmodproductevent.setEventStatusCode(rs.getString(COL_EVENT_STATUS_CODE));
        fgmodproductevent.setEventTypeCode(rs.getString(COL_EVENT_TYPE_CODE));
        fgmodproductevent.setEventSubTypeCode(rs.getString(COL_EVENT_SUB_TYPE_CODE));
        return fgmodproductevent;
    }
}
