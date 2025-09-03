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

public class JdbcFgProductIntEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductIntEventDao.class);

    private static final String TABLE = "FG_PRODUCT_INT_EVENT";

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

    private static final String COL_SOURCE_SYSTEM = "SOURCE_SYSTEM";

    private static final String COL_SOURCE_PRODUCT = "SOURCE_PRODUCT";

    private static final String COL_SOURCE_EVENT = "SOURCE_EVENT";

    private static final String COL_TARGET_SYSTEM = "TARGET_SYSTEM";

    private static final String COL_TARGET_PRODUCT = "TARGET_PRODUCT";

    private static final String COL_TARGET_EVENT = "TARGET_EVENT";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_TEST = "TEST";

    private static final String COL_TEST1 = "TEST1";

    private static final String COL_TEST2 = "TEST2";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_BO_REF_NO = "BO_REF_NO";

    private static final String COL_BO_STATUS = "BO_STATUS";

    private static final String COL_BO_COMMENTS = "BO_COMMENTS";

    private static final String COL_TRANSLATOR_CODE = "TRANSLATOR_CODE";

    private static final String COL_STAGING_TYPE = "STAGING_TYPE";

    private static final String COL_INT_STATUS_CODE = "INT_STATUS_CODE";

    private static final String COL_STAGING_STATUS_CODE = "STAGING_STATUS_CODE";

    private static final String COL_STAGING_REQUEST = "STAGING_REQUEST";

    private static final String COL_STAGING_RESPONSE = "STAGING_RESPONSE";

    private static final String COL_EVENT_TYPE = "EVENT_TYPE";

    private static final String COL_EVENT_STATUS = "EVENT_STATUS";

    private static final String COL_SERVER_DETAILS = "SERVER_DETAILS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SOURCE_SYSTEM, COL_SOURCE_PRODUCT, COL_SOURCE_EVENT, COL_TARGET_SYSTEM, COL_TARGET_PRODUCT, COL_TARGET_EVENT, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_TEST, COL_TEST1, COL_TEST2, COL_ENTITY_SUB_TYPE_CODE, COL_BO_REF_NO, COL_BO_STATUS, COL_BO_COMMENTS, COL_TRANSLATOR_CODE, COL_STAGING_TYPE, COL_INT_STATUS_CODE, COL_STAGING_STATUS_CODE, COL_STAGING_REQUEST, COL_STAGING_RESPONSE, COL_EVENT_TYPE, COL_EVENT_STATUS, COL_SERVER_DETAILS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SOURCE_SYSTEM, SOURCE_PRODUCT, SOURCE_EVENT, TARGET_SYSTEM, TARGET_PRODUCT, TARGET_EVENT, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, TEST, TEST1, TEST2, ENTITY_SUB_TYPE_CODE, BO_REF_NO, BO_STATUS, BO_COMMENTS, TRANSLATOR_CODE, STAGING_TYPE, INT_STATUS_CODE, STAGING_STATUS_CODE, STAGING_REQUEST, STAGING_RESPONSE, EVENT_TYPE, EVENT_STATUS, SERVER_DETAILS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SOURCE_SYSTEM, SOURCE_PRODUCT, SOURCE_EVENT, TARGET_SYSTEM, TARGET_PRODUCT, TARGET_EVENT, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, TEST, TEST1, TEST2, ENTITY_SUB_TYPE_CODE, BO_REF_NO, BO_STATUS, BO_COMMENTS, TRANSLATOR_CODE, STAGING_TYPE, INT_STATUS_CODE, STAGING_STATUS_CODE, STAGING_REQUEST, STAGING_RESPONSE, EVENT_TYPE, EVENT_STATUS, SERVER_DETAILS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SOURCE_SYSTEM, COL_SOURCE_PRODUCT, COL_SOURCE_EVENT, COL_TARGET_SYSTEM, COL_TARGET_PRODUCT, COL_TARGET_EVENT, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_ENTITY_TYPE_CODE, COL_TEST, COL_TEST1, COL_TEST2, COL_ENTITY_SUB_TYPE_CODE, COL_BO_REF_NO, COL_BO_STATUS, COL_BO_COMMENTS, COL_TRANSLATOR_CODE, COL_STAGING_TYPE, COL_INT_STATUS_CODE, COL_STAGING_STATUS_CODE, COL_STAGING_REQUEST, COL_STAGING_RESPONSE, COL_EVENT_TYPE, COL_EVENT_STATUS, COL_SERVER_DETAILS, COL_ID);

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

    public int insert(Connection conn, FgProductIntEvent fgproductintevent) throws SQLException {
        logger.debug("Inserting fgproductintevent: {}", fgproductintevent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductIntEventParams(ps, fgproductintevent);
            ps.executeUpdate();
            return fgproductintevent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductIntEvent> fgproductintevents) throws SQLException {
        if (fgproductintevents == null || fgproductintevents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductintevents.size(); i++) {
            if (fgproductintevents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductIntEvent>> batches = chunkList(fgproductintevents, batchSize);
        int[] totalResults = new int[fgproductintevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductIntEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductIntEvent fgproductintevent : batch) {
                        setFgProductIntEventParams(ps, fgproductintevent);
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

    public FgProductIntEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductIntEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductIntEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductIntEvent fgproductintevent) throws SQLException {
        if (fgproductintevent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductIntEventParams(ps, fgproductintevent);
            ps.setInt(40, fgproductintevent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductIntEvent> fgproductintevents) throws SQLException {
        if (fgproductintevents == null || fgproductintevents.isEmpty())
            return new int[0];
        for (FgProductIntEvent fgproductintevent : fgproductintevents) {
            if (fgproductintevent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductintevent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductIntEvent>> batches = chunkList(fgproductintevents, batchSize);
        int[] totalResults = new int[fgproductintevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductIntEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductIntEvent fgproductintevent : batch) {
                        setFgProductIntEventParams(ps, fgproductintevent);
                        ps.setInt(40, fgproductintevent.getID());
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

    private void setFgProductIntEventParams(PreparedStatement ps, FgProductIntEvent fgproductintevent) throws SQLException {
        Integer val1 = fgproductintevent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproductintevent.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgproductintevent.getTypeCode());
        ps.setString(4, fgproductintevent.getSubTypeCode());
        ps.setString(5, fgproductintevent.getActiveCode());
        ps.setString(6, fgproductintevent.getStageCode());
        ps.setString(7, fgproductintevent.getStatusCode());
        ps.setString(8, fgproductintevent.getCreatedOn());
        java.math.BigDecimal val9 = fgproductintevent.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgproductintevent.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgproductintevent.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgproductintevent.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgproductintevent.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductintevent.getTemplate());
        java.math.BigDecimal val15 = fgproductintevent.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgproductintevent.getSourceSystem());
        ps.setString(17, fgproductintevent.getSourceProduct());
        ps.setString(18, fgproductintevent.getSourceEvent());
        ps.setString(19, fgproductintevent.getTargetSystem());
        ps.setString(20, fgproductintevent.getTargetProduct());
        ps.setString(21, fgproductintevent.getTargetEvent());
        Integer val22 = fgproductintevent.getEntityRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = fgproductintevent.getEntityVersionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, fgproductintevent.getEntityTypeCode());
        ps.setString(25, fgproductintevent.getTest());
        ps.setString(26, fgproductintevent.getTest1());
        ps.setString(27, fgproductintevent.getTest2());
        ps.setString(28, fgproductintevent.getEntitySubTypeCode());
        ps.setString(29, fgproductintevent.getBoRefNo());
        ps.setString(30, fgproductintevent.getBoStatus());
        ps.setString(31, fgproductintevent.getBoComments());
        ps.setString(32, fgproductintevent.getTranslatorCode());
        ps.setString(33, fgproductintevent.getStagingType());
        ps.setString(34, fgproductintevent.getIntStatusCode());
        ps.setString(35, fgproductintevent.getStagingStatusCode());
        ps.setString(36, fgproductintevent.getStagingRequest());
        ps.setString(37, fgproductintevent.getStagingResponse());
        ps.setString(38, fgproductintevent.getEventType());
        ps.setString(39, fgproductintevent.getEventStatus());
        ps.setString(40, fgproductintevent.getServerDetails());
    }

    private FgProductIntEvent extract(ResultSet rs) throws SQLException {
        FgProductIntEvent fgproductintevent = new FgProductIntEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductintevent.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgproductintevent.setReferenceID(REFERENCE_ID);
        fgproductintevent.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgproductintevent.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgproductintevent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductintevent.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductintevent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductintevent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductintevent.setCreatedBy(CREATED_BY);
        fgproductintevent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductintevent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductintevent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductintevent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductintevent.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgproductintevent.setIsTemplate(IS_TEMPLATE);
        fgproductintevent.setSourceSystem(rs.getString(COL_SOURCE_SYSTEM));
        fgproductintevent.setSourceProduct(rs.getString(COL_SOURCE_PRODUCT));
        fgproductintevent.setSourceEvent(rs.getString(COL_SOURCE_EVENT));
        fgproductintevent.setTargetSystem(rs.getString(COL_TARGET_SYSTEM));
        fgproductintevent.setTargetProduct(rs.getString(COL_TARGET_PRODUCT));
        fgproductintevent.setTargetEvent(rs.getString(COL_TARGET_EVENT));
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductintevent.setEntityRefID(ENTITY_REF_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgproductintevent.setEntityVersionID(ENTITY_VERSION_ID);
        fgproductintevent.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductintevent.setTest(rs.getString(COL_TEST));
        fgproductintevent.setTest1(rs.getString(COL_TEST1));
        fgproductintevent.setTest2(rs.getString(COL_TEST2));
        fgproductintevent.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgproductintevent.setBoRefNo(rs.getString(COL_BO_REF_NO));
        fgproductintevent.setBoStatus(rs.getString(COL_BO_STATUS));
        fgproductintevent.setBoComments(rs.getString(COL_BO_COMMENTS));
        fgproductintevent.setTranslatorCode(rs.getString(COL_TRANSLATOR_CODE));
        fgproductintevent.setStagingType(rs.getString(COL_STAGING_TYPE));
        fgproductintevent.setIntStatusCode(rs.getString(COL_INT_STATUS_CODE));
        fgproductintevent.setStagingStatusCode(rs.getString(COL_STAGING_STATUS_CODE));
        fgproductintevent.setStagingRequest(rs.getString(COL_STAGING_REQUEST));
        fgproductintevent.setStagingResponse(rs.getString(COL_STAGING_RESPONSE));
        fgproductintevent.setEventType(rs.getString(COL_EVENT_TYPE));
        fgproductintevent.setEventStatus(rs.getString(COL_EVENT_STATUS));
        fgproductintevent.setServerDetails(rs.getString(COL_SERVER_DETAILS));
        return fgproductintevent;
    }
}
