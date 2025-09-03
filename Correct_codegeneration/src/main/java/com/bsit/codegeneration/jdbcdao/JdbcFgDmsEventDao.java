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

public class JdbcFgDmsEventDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDmsEventDao.class);

    private static final String TABLE = "FG_DMS_EVENT";

    private static final String COL_ID = "ID";

    private static final String COL_ACTION_CODE = "ACTION_CODE";

    private static final String COL_ENTITY_REFERENCE_ID = "ENTITY_REFERENCE_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ACTION_CODE, COL_ENTITY_REFERENCE_ID, COL_ENTITY_VERSION_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ACTION_CODE, ENTITY_REFERENCE_ID, ENTITY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ACTION_CODE, ENTITY_REFERENCE_ID, ENTITY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ACTION_CODE, COL_ENTITY_REFERENCE_ID, COL_ENTITY_VERSION_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ID);

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

    public int insert(Connection conn, FgDmsEvent fgdmsevent) throws SQLException {
        logger.debug("Inserting fgdmsevent: {}", fgdmsevent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDmsEventParams(ps, fgdmsevent);
            ps.executeUpdate();
            return fgdmsevent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDmsEvent> fgdmsevents) throws SQLException {
        if (fgdmsevents == null || fgdmsevents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgdmsevents.size(); i++) {
            if (fgdmsevents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDmsEvent>> batches = chunkList(fgdmsevents, batchSize);
        int[] totalResults = new int[fgdmsevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDmsEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDmsEvent fgdmsevent : batch) {
                        setFgDmsEventParams(ps, fgdmsevent);
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

    public FgDmsEvent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDmsEvent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDmsEvent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDmsEvent fgdmsevent) throws SQLException {
        if (fgdmsevent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDmsEventParams(ps, fgdmsevent);
            ps.setInt(16, fgdmsevent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDmsEvent> fgdmsevents) throws SQLException {
        if (fgdmsevents == null || fgdmsevents.isEmpty())
            return new int[0];
        for (FgDmsEvent fgdmsevent : fgdmsevents) {
            if (fgdmsevent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdmsevent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDmsEvent>> batches = chunkList(fgdmsevents, batchSize);
        int[] totalResults = new int[fgdmsevents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDmsEvent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDmsEvent fgdmsevent : batch) {
                        setFgDmsEventParams(ps, fgdmsevent);
                        ps.setInt(16, fgdmsevent.getID());
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

    private void setFgDmsEventParams(PreparedStatement ps, FgDmsEvent fgdmsevent) throws SQLException {
        Integer val1 = fgdmsevent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgdmsevent.getActionCode());
        Integer val3 = fgdmsevent.getEntityReferenceID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = fgdmsevent.getEntityVersionID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgdmsevent.getPartyID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Integer val6 = fgdmsevent.getPartyVersionID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        ps.setString(7, fgdmsevent.getActiveCode());
        ps.setString(8, fgdmsevent.getStatusCode());
        ps.setString(9, fgdmsevent.getCreatedOn());
        java.math.BigDecimal val10 = fgdmsevent.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgdmsevent.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgdmsevent.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgdmsevent.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgdmsevent.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgdmsevent.getEntityTypeCode());
        ps.setString(16, fgdmsevent.getEntitySubTypeCode());
    }

    private FgDmsEvent extract(ResultSet rs) throws SQLException {
        FgDmsEvent fgdmsevent = new FgDmsEvent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdmsevent.setID(ID);
        fgdmsevent.setActionCode(rs.getString(COL_ACTION_CODE));
        Integer ENTITY_REFERENCE_ID = rs.getObject(COL_ENTITY_REFERENCE_ID, Integer.class);
        fgdmsevent.setEntityReferenceID(ENTITY_REFERENCE_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgdmsevent.setEntityVersionID(ENTITY_VERSION_ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgdmsevent.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgdmsevent.setPartyVersionID(PARTY_VERSION_ID);
        fgdmsevent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdmsevent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdmsevent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdmsevent.setCreatedBy(CREATED_BY);
        fgdmsevent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdmsevent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdmsevent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdmsevent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgdmsevent.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgdmsevent.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        return fgdmsevent;
    }
}
