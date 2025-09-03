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

public class JdbcFgProductStageDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductStageDao.class);

    private static final String TABLE = "FG_PRODUCT_STAGE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_PERF_PTY_SUBTYP_CODE = "PERF_PTY_SUBTYP_CODE";

    private static final String COL_PERF_PTY_TYP_CODE = "PERF_PTY_TYP_CODE";

    private static final String COL_PERF_PTY_ROLE_CODE = "PERF_PTY_ROLE_CODE";

    private static final String COL_STP = "STP";

    private static final String COL_STAGE_ORDER_IDX = "STAGE_ORDER_IDX";

    private static final String COL_AUTO_SUBMIT = "AUTO_SUBMIT";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_AUTH_STATUS_CODE = "AUTH_STATUS_CODE";

    private static final String COL_TNX_STATUS_CODE = "TNX_STATUS_CODE";

    private static final String COL_AUTHORIZATION = "AUTHORIZATION";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_AUTO_AUTHORISE = "AUTO_AUTHORISE";

    private static final String COL_PERF_PTY_FIELD_CODE = "PERF_PTY_FIELD_CODE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ID = "ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_STAGE_CODE, COL_PERF_PTY_SUBTYP_CODE, COL_PERF_PTY_TYP_CODE, COL_PERF_PTY_ROLE_CODE, COL_STP, COL_STAGE_ORDER_IDX, COL_AUTO_SUBMIT, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_REF_ID, COL_AUTH_STATUS_CODE, COL_TNX_STATUS_CODE, COL_AUTHORIZATION, COL_ENTITY_VERSION_ID, COL_AUTO_AUTHORISE, COL_PERF_PTY_FIELD_CODE, COL_UPLOAD_REF_ID, COL_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, AUTO_SUBMIT, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_REF_ID, AUTH_STATUS_CODE, TNX_STATUS_CODE, AUTHORIZATION, ENTITY_VERSION_ID, AUTO_AUTHORISE, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID", TABLE, COL_ENTITY_REF_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, AUTO_SUBMIT, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_REF_ID, AUTH_STATUS_CODE, TNX_STATUS_CODE, AUTHORIZATION, ENTITY_VERSION_ID, AUTO_AUTHORISE, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID", TABLE, COL_ENTITY_REF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_STAGE_CODE, COL_PERF_PTY_SUBTYP_CODE, COL_PERF_PTY_TYP_CODE, COL_PERF_PTY_ROLE_CODE, COL_STP, COL_STAGE_ORDER_IDX, COL_AUTO_SUBMIT, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_AUTH_STATUS_CODE, COL_TNX_STATUS_CODE, COL_AUTHORIZATION, COL_ENTITY_VERSION_ID, COL_AUTO_AUTHORISE, COL_PERF_PTY_FIELD_CODE, COL_UPLOAD_REF_ID, COL_ID, COL_ENTITY_REF_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_REF_ID);

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

    public int insert(Connection conn, FgProductStage fgproductstage) throws SQLException {
        logger.debug("Inserting fgproductstage: {}", fgproductstage);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductStageParams(ps, fgproductstage);
            ps.executeUpdate();
            return fgproductstage.getEntityRefID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductStage> fgproductstages) throws SQLException {
        if (fgproductstages == null || fgproductstages.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproductstages.size(); i++) {
            if (fgproductstages.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductStage>> batches = chunkList(fgproductstages, batchSize);
        int[] totalResults = new int[fgproductstages.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductStage> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductStage fgproductstage : batch) {
                        setFgProductStageParams(ps, fgproductstage);
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

    public FgProductStage findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductStage> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductStage> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductStage fgproductstage) throws SQLException {
        if (fgproductstage.getEntityRefID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductStageParams(ps, fgproductstage);
            ps.setInt(26, fgproductstage.getEntityRefID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductStage> fgproductstages) throws SQLException {
        if (fgproductstages == null || fgproductstages.isEmpty())
            return new int[0];
        for (FgProductStage fgproductstage : fgproductstages) {
            if (fgproductstage == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproductstage.getEntityRefID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductStage>> batches = chunkList(fgproductstages, batchSize);
        int[] totalResults = new int[fgproductstages.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductStage> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductStage fgproductstage : batch) {
                        setFgProductStageParams(ps, fgproductstage);
                        ps.setInt(26, fgproductstage.getEntityRefID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ENTITY_REF_ID, placeholders);
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

    private void setFgProductStageParams(PreparedStatement ps, FgProductStage fgproductstage) throws SQLException {
        ps.setString(1, fgproductstage.getEntityTypeCode());
        ps.setString(2, fgproductstage.getEntitySubTypeCode());
        ps.setString(3, fgproductstage.getStageCode());
        ps.setString(4, fgproductstage.getPerfPtySubtypCode());
        ps.setString(5, fgproductstage.getPerfPtyTypCode());
        ps.setString(6, fgproductstage.getPerfPtyRoleCode());
        java.math.BigDecimal val7 = fgproductstage.getStp();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = fgproductstage.getStageOrderIdx();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = fgproductstage.getAutoSubmit();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgproductstage.getActiveCode());
        ps.setString(11, fgproductstage.getStatusCode());
        ps.setString(12, fgproductstage.getCreatedOn());
        java.math.BigDecimal val13 = fgproductstage.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproductstage.getLastUpdatedOn());
        java.math.BigDecimal val15 = fgproductstage.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgproductstage.getLastAuthorisedOn());
        java.math.BigDecimal val17 = fgproductstage.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        Integer val18 = fgproductstage.getEntityRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fgproductstage.getAuthStatusCode());
        ps.setString(20, fgproductstage.getTnxStatusCode());
        ps.setString(21, fgproductstage.getAuthorization());
        Integer val22 = fgproductstage.getEntityVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fgproductstage.getAutoAuthorise();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgproductstage.getPerfPtyFieldCode());
        Integer val25 = fgproductstage.getUploadRefID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgproductstage.getID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
    }

    private FgProductStage extract(ResultSet rs) throws SQLException {
        FgProductStage fgproductstage = new FgProductStage();
        fgproductstage.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgproductstage.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgproductstage.setStageCode(rs.getString(COL_STAGE_CODE));
        fgproductstage.setPerfPtySubtypCode(rs.getString(COL_PERF_PTY_SUBTYP_CODE));
        fgproductstage.setPerfPtyTypCode(rs.getString(COL_PERF_PTY_TYP_CODE));
        fgproductstage.setPerfPtyRoleCode(rs.getString(COL_PERF_PTY_ROLE_CODE));
        java.math.BigDecimal STP = rs.getObject(COL_STP, java.math.BigDecimal.class);
        fgproductstage.setStp(STP);
        java.math.BigDecimal STAGE_ORDER_IDX = rs.getObject(COL_STAGE_ORDER_IDX, java.math.BigDecimal.class);
        fgproductstage.setStageOrderIdx(STAGE_ORDER_IDX);
        java.math.BigDecimal AUTO_SUBMIT = rs.getObject(COL_AUTO_SUBMIT, java.math.BigDecimal.class);
        fgproductstage.setAutoSubmit(AUTO_SUBMIT);
        fgproductstage.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproductstage.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproductstage.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproductstage.setCreatedBy(CREATED_BY);
        fgproductstage.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproductstage.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproductstage.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproductstage.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgproductstage.setEntityRefID(ENTITY_REF_ID);
        fgproductstage.setAuthStatusCode(rs.getString(COL_AUTH_STATUS_CODE));
        fgproductstage.setTnxStatusCode(rs.getString(COL_TNX_STATUS_CODE));
        fgproductstage.setAuthorization(rs.getString(COL_AUTHORIZATION));
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgproductstage.setEntityVersionID(ENTITY_VERSION_ID);
        java.math.BigDecimal AUTO_AUTHORISE = rs.getObject(COL_AUTO_AUTHORISE, java.math.BigDecimal.class);
        fgproductstage.setAutoAuthorise(AUTO_AUTHORISE);
        fgproductstage.setPerfPtyFieldCode(rs.getString(COL_PERF_PTY_FIELD_CODE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgproductstage.setUploadRefID(UPLOAD_REF_ID);
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproductstage.setID(ID);
        return fgproductstage;
    }
}
