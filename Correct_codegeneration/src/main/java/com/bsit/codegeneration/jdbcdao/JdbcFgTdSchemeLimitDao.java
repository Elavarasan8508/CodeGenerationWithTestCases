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

public class JdbcFgTdSchemeLimitDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdSchemeLimitDao.class);

    private static final String TABLE = "FG_TD_SCHEME_LIMIT";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_TENOR_START_DAYS = "TENOR_START_DAYS";

    private static final String COL_TENOR_END_DAYS = "TENOR_END_DAYS";

    private static final String COL_TENOR_MIN_AMOUNT = "TENOR_MIN_AMOUNT";

    private static final String COL_TENOR_MAX_AMOUNT = "TENOR_MAX_AMOUNT";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_TENOR_START_DAYS, COL_TENOR_END_DAYS, COL_TENOR_MIN_AMOUNT, COL_TENOR_MAX_AMOUNT, COL_VALUE_DATE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_TENOR_START_DAYS, COL_TENOR_END_DAYS, COL_TENOR_MIN_AMOUNT, COL_TENOR_MAX_AMOUNT, COL_VALUE_DATE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON, COL_ID);

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

    public int insert(Connection conn, FgTdSchemeLimit fgtdschemelimit) throws SQLException {
        logger.debug("Inserting fgtdschemelimit: {}", fgtdschemelimit);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdSchemeLimitParams(ps, fgtdschemelimit);
            ps.executeUpdate();
            return fgtdschemelimit.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdSchemeLimit> fgtdschemelimits) throws SQLException {
        if (fgtdschemelimits == null || fgtdschemelimits.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdschemelimits.size(); i++) {
            if (fgtdschemelimits.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdSchemeLimit>> batches = chunkList(fgtdschemelimits, batchSize);
        int[] totalResults = new int[fgtdschemelimits.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdSchemeLimit> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdSchemeLimit fgtdschemelimit : batch) {
                        setFgTdSchemeLimitParams(ps, fgtdschemelimit);
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

    public FgTdSchemeLimit findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdSchemeLimit> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdSchemeLimit> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdSchemeLimit fgtdschemelimit) throws SQLException {
        if (fgtdschemelimit.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdSchemeLimitParams(ps, fgtdschemelimit);
            ps.setInt(26, fgtdschemelimit.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdSchemeLimit> fgtdschemelimits) throws SQLException {
        if (fgtdschemelimits == null || fgtdschemelimits.isEmpty())
            return new int[0];
        for (FgTdSchemeLimit fgtdschemelimit : fgtdschemelimits) {
            if (fgtdschemelimit == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdschemelimit.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdSchemeLimit>> batches = chunkList(fgtdschemelimits, batchSize);
        int[] totalResults = new int[fgtdschemelimits.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdSchemeLimit> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdSchemeLimit fgtdschemelimit : batch) {
                        setFgTdSchemeLimitParams(ps, fgtdschemelimit);
                        ps.setInt(26, fgtdschemelimit.getID());
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

    private void setFgTdSchemeLimitParams(PreparedStatement ps, FgTdSchemeLimit fgtdschemelimit) throws SQLException {
        Integer val1 = fgtdschemelimit.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtdschemelimit.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtdschemelimit.getTypeCode());
        ps.setString(4, fgtdschemelimit.getSubTypeCode());
        ps.setString(5, fgtdschemelimit.getActiveCode());
        ps.setString(6, fgtdschemelimit.getStageCode());
        ps.setString(7, fgtdschemelimit.getStatusCode());
        Integer val8 = fgtdschemelimit.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtdschemelimit.getCreatedOn());
        java.math.BigDecimal val10 = fgtdschemelimit.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtdschemelimit.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtdschemelimit.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtdschemelimit.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtdschemelimit.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtdschemelimit.getTemplate());
        java.math.BigDecimal val16 = fgtdschemelimit.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgtdschemelimit.getTenorStartDays());
        ps.setString(18, fgtdschemelimit.getTenorEndDays());
        java.math.BigDecimal val19 = fgtdschemelimit.getTenorMinAmount();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtdschemelimit.getTenorMaxAmount();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.time.LocalDateTime val21 = fgtdschemelimit.getValueDate();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        Integer val22 = fgtdschemelimit.getParentRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = fgtdschemelimit.getParentVersionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fgtdschemelimit.getVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgtdschemelimit.getIsMasterVersion();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgtdschemelimit.getTaskReason());
    }

    private FgTdSchemeLimit extract(ResultSet rs) throws SQLException {
        FgTdSchemeLimit fgtdschemelimit = new FgTdSchemeLimit();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtdschemelimit.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdschemelimit.setReferenceID(REFERENCE_ID);
        fgtdschemelimit.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdschemelimit.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdschemelimit.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtdschemelimit.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdschemelimit.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdschemelimit.setProcessID(PROCESS_ID);
        fgtdschemelimit.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtdschemelimit.setCreatedBy(CREATED_BY);
        fgtdschemelimit.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtdschemelimit.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtdschemelimit.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtdschemelimit.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtdschemelimit.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtdschemelimit.setIsTemplate(IS_TEMPLATE);
        fgtdschemelimit.setTenorStartDays(rs.getString(COL_TENOR_START_DAYS));
        fgtdschemelimit.setTenorEndDays(rs.getString(COL_TENOR_END_DAYS));
        java.math.BigDecimal TENOR_MIN_AMOUNT = rs.getObject(COL_TENOR_MIN_AMOUNT, java.math.BigDecimal.class);
        fgtdschemelimit.setTenorMinAmount(TENOR_MIN_AMOUNT);
        java.math.BigDecimal TENOR_MAX_AMOUNT = rs.getObject(COL_TENOR_MAX_AMOUNT, java.math.BigDecimal.class);
        fgtdschemelimit.setTenorMaxAmount(TENOR_MAX_AMOUNT);
        Timestamp VALUE_DATE = rs.getTimestamp(COL_VALUE_DATE);
        if (VALUE_DATE != null)
            fgtdschemelimit.setValueDate(VALUE_DATE.toLocalDateTime());
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtdschemelimit.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtdschemelimit.setParentVersionID(PARENT_VERSION_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtdschemelimit.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtdschemelimit.setIsMasterVersion(IS_MASTER_VERSION);
        fgtdschemelimit.setTaskReason(rs.getString(COL_TASK_REASON));
        return fgtdschemelimit;
    }
}
