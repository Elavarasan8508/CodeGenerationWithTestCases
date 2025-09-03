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

public class JdbcFgProductStageHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductStageHistoryDao.class);

    private static final String TABLE = "FG_PRODUCT_STAGE_HISTORY";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_WF_PROCESS_ID = "WF_PROCESS_ID";

    private static final String COL_WF_DEFINITION_ID = "WF_DEFINITION_ID";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_NO = "ENTITY_VERSION_NO";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_PERF_PTY_SUBTYP_CODE = "PERF_PTY_SUBTYP_CODE";

    private static final String COL_PERF_PTY_TYP_CODE = "PERF_PTY_TYP_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PERF_PTY_ROLE_CODE = "PERF_PTY_ROLE_CODE";

    private static final String COL_STP = "STP";

    private static final String COL_STAGE_ORDER_IDX = "STAGE_ORDER_IDX";

    private static final String COL_STAGE_START_TIME = "STAGE_START_TIME";

    private static final String COL_STAGE_END_TIME = "STAGE_END_TIME";

    private static final String COL_WF_PROCESS_STATUS_CODE = "WF_PROCESS_STATUS_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_PERF_PTY_FIELD_CODE = "PERF_PTY_FIELD_CODE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ID = "ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_WF_PROCESS_ID, COL_WF_DEFINITION_ID, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_NO, COL_STAGE_CODE, COL_PERF_PTY_SUBTYP_CODE, COL_PERF_PTY_TYP_CODE, COL_PARTY_CODE, COL_PERF_PTY_ROLE_CODE, COL_STP, COL_STAGE_ORDER_IDX, COL_STAGE_START_TIME, COL_STAGE_END_TIME, COL_WF_PROCESS_STATUS_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_PERF_PTY_FIELD_CODE, COL_UPLOAD_REF_ID, COL_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, WF_PROCESS_ID, WF_DEFINITION_ID, ENTITY_REF_ID, ENTITY_VERSION_NO, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PARTY_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, STAGE_START_TIME, STAGE_END_TIME, WF_PROCESS_STATUS_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID", TABLE, COL_WF_PROCESS_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, WF_PROCESS_ID, WF_DEFINITION_ID, ENTITY_REF_ID, ENTITY_VERSION_NO, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PARTY_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, STAGE_START_TIME, STAGE_END_TIME, WF_PROCESS_STATUS_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID", TABLE, COL_WF_PROCESS_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_WF_DEFINITION_ID, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_NO, COL_STAGE_CODE, COL_PERF_PTY_SUBTYP_CODE, COL_PERF_PTY_TYP_CODE, COL_PARTY_CODE, COL_PERF_PTY_ROLE_CODE, COL_STP, COL_STAGE_ORDER_IDX, COL_STAGE_START_TIME, COL_STAGE_END_TIME, COL_WF_PROCESS_STATUS_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_PERF_PTY_FIELD_CODE, COL_UPLOAD_REF_ID, COL_ID, COL_WF_PROCESS_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_WF_PROCESS_ID);

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

    public int insert(Connection conn, FgProductStageHistory fgproductstagehistory) throws SQLException {
        logger.debug("Inserting fgproductstagehistory: {}", fgproductstagehistory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductStageHistoryParams(ps, fgproductstagehistory);
            ps.executeUpdate();
            return fgproductstagehistory.getWfProcessID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductStageHistory> fgproductstagehistorys) throws SQLException {
        if (fgproductstagehistorys == null || fgproductstagehistorys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductstagehistorys.size(); i++) {
            if (fgproductstagehistorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductStageHistory>> batches = chunkList(fgproductstagehistorys, batchSize);
        int[] totalResults = new int[fgproductstagehistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductStageHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductStageHistory fgproductstagehistory : batch) {
                        setFgProductStageHistoryParams(ps, fgproductstagehistory);
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

    public FgProductStageHistory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductStageHistory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductStageHistory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductStageHistory fgproductstagehistory) throws SQLException {
        if (fgproductstagehistory.getWfProcessID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductStageHistoryParams(ps, fgproductstagehistory);
            ps.setInt(27, fgproductstagehistory.getWfProcessID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductStageHistory> fgproductstagehistorys) throws SQLException {
        if (fgproductstagehistorys == null || fgproductstagehistorys.isEmpty())
            return new int[0];
        for (FgProductStageHistory fgproductstagehistory : fgproductstagehistorys) {
            if (fgproductstagehistory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductstagehistory.getWfProcessID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductStageHistory>> batches = chunkList(fgproductstagehistorys, batchSize);
        int[] totalResults = new int[fgproductstagehistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductStageHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductStageHistory fgproductstagehistory : batch) {
                        setFgProductStageHistoryParams(ps, fgproductstagehistory);
                        ps.setInt(27, fgproductstagehistory.getWfProcessID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_WF_PROCESS_ID, placeholders);
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

    private void setFgProductStageHistoryParams(PreparedStatement ps, FgProductStageHistory fgproductstagehistory) throws SQLException {
        ps.setString(1, fgproductstagehistory.getEntityTypeCode());
        ps.setString(2, fgproductstagehistory.getEntitySubTypeCode());
        Integer val3 = fgproductstagehistory.getWfProcessID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = fgproductstagehistory.getWfDefinitionID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgproductstagehistory.getEntityRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        java.math.BigDecimal val6 = fgproductstagehistory.getEntityVersionNo();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgproductstagehistory.getStageCode());
        ps.setString(8, fgproductstagehistory.getPerfPtySubtypCode());
        ps.setString(9, fgproductstagehistory.getPerfPtyTypCode());
        ps.setString(10, fgproductstagehistory.getPartyCode());
        ps.setString(11, fgproductstagehistory.getPerfPtyRoleCode());
        java.math.BigDecimal val12 = fgproductstagehistory.getStp();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        java.math.BigDecimal val13 = fgproductstagehistory.getStageOrderIdx();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductstagehistory.getStageStartTime());
        ps.setString(15, fgproductstagehistory.getStageEndTime());
        ps.setString(16, fgproductstagehistory.getWfProcessStatusCode());
        ps.setString(17, fgproductstagehistory.getActiveCode());
        ps.setString(18, fgproductstagehistory.getStatusCode());
        java.math.BigDecimal val19 = fgproductstagehistory.getCreatedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgproductstagehistory.getCreatedOn());
        java.math.BigDecimal val21 = fgproductstagehistory.getLastUpdatedBy();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgproductstagehistory.getLastUpdatedOn());
        java.math.BigDecimal val23 = fgproductstagehistory.getLastAuthorisedBy();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgproductstagehistory.getLastAuthorisedOn());
        ps.setString(25, fgproductstagehistory.getPerfPtyFieldCode());
        Integer val26 = fgproductstagehistory.getUploadRefID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgproductstagehistory.getID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
    }

    private FgProductStageHistory extract(ResultSet rs) throws SQLException {
        FgProductStageHistory fgproductstagehistory = new FgProductStageHistory();
        fgproductstagehistory.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductstagehistory.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer WF_PROCESS_ID = rs.getObject(COL_WF_PROCESS_ID, Integer.class);
        fgproductstagehistory.setWfProcessID(WF_PROCESS_ID);
        Integer WF_DEFINITION_ID = rs.getObject(COL_WF_DEFINITION_ID, Integer.class);
        fgproductstagehistory.setWfDefinitionID(WF_DEFINITION_ID);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductstagehistory.setEntityRefID(ENTITY_REF_ID);
        java.math.BigDecimal ENTITY_VERSION_NO = rs.getObject(COL_ENTITY_VERSION_NO, java.math.BigDecimal.class);
        fgproductstagehistory.setEntityVersionNo(ENTITY_VERSION_NO);
        fgproductstagehistory.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductstagehistory.setPerfPtySubtypCode(rs.getString(COL_PERF_PTY_SUBTYP_CODE));
        fgproductstagehistory.setPerfPtyTypCode(rs.getString(COL_PERF_PTY_TYP_CODE));
        fgproductstagehistory.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgproductstagehistory.setPerfPtyRoleCode(rs.getString(COL_PERF_PTY_ROLE_CODE));
        java.math.BigDecimal STP = rs.getObject(COL_STP, java.math.BigDecimal.class);
        fgproductstagehistory.setStp(STP);
        java.math.BigDecimal STAGE_ORDER_IDX = rs.getObject(COL_STAGE_ORDER_IDX, java.math.BigDecimal.class);
        fgproductstagehistory.setStageOrderIdx(STAGE_ORDER_IDX);
        fgproductstagehistory.setStageStartTime(rs.getString(COL_STAGE_START_TIME));
        fgproductstagehistory.setStageEndTime(rs.getString(COL_STAGE_END_TIME));
        fgproductstagehistory.setWfProcessStatusCode(rs.getString(COL_WF_PROCESS_STATUS_CODE));
        fgproductstagehistory.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductstagehistory.setStatusCode(rs.getString(COL_STATUS_CODE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductstagehistory.setCreatedBy(CREATED_BY);
        fgproductstagehistory.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductstagehistory.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductstagehistory.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductstagehistory.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgproductstagehistory.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        fgproductstagehistory.setPerfPtyFieldCode(rs.getString(COL_PERF_PTY_FIELD_CODE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgproductstagehistory.setUploadRefID(UPLOAD_REF_ID);
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductstagehistory.setID(ID);
        return fgproductstagehistory;
    }
}
