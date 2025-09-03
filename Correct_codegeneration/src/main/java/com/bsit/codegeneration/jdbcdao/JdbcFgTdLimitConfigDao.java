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

public class JdbcFgTdLimitConfigDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdLimitConfigDao.class);

    private static final String TABLE = "FG_TD_LIMIT_CONFIG";

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

    private static final String COL_LIQ_MAX_LIMIT = "LIQ_MAX_LIMIT";

    private static final String COL_MIN_BOOK_LIMIT = "MIN_BOOK_LIMIT";

    private static final String COL_MAX_BOOK_LIMIT = "MAX_BOOK_LIMIT";

    private static final String COL_DAILY_BOOKING_LIMIT = "DAILY_BOOKING_LIMIT";

    private static final String COL_TENOR_MAX_AMOUNT = "TENOR_MAX_AMOUNT";

    private static final String COL_TENOR_MIN_DAYS = "TENOR_MIN_DAYS";

    private static final String COL_TENOR_MAX_DAYS = "TENOR_MAX_DAYS";

    private static final String COL_SCHEME_CODES = "SCHEME_CODES";

    private static final String COL_ABOVE_AMT = "ABOVE_AMT";

    private static final String COL_BELOW_AMT = "BELOW_AMT";

    private static final String COL_A_START_NUMBER = "A_START_NUMBER";

    private static final String COL_A_START_TYPE = "A_START_TYPE";

    private static final String COL_A_END_NUMBER = "A_END_NUMBER";

    private static final String COL_A_END_TYPE = "A_END_TYPE";

    private static final String COL_B_START_NUMBER = "B_START_NUMBER";

    private static final String COL_B_START_TYPE = "B_START_TYPE";

    private static final String COL_B_END_NUMBER = "B_END_NUMBER";

    private static final String COL_B_END_TYPE = "B_END_TYPE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_ID = "PARENT_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_ABOVE_RANGE = "ABOVE_RANGE";

    private static final String COL_BELOW_RANGE = "BELOW_RANGE";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_MIN_TENOR = "MIN_TENOR";

    private static final String COL_MAX_TENOR = "MAX_TENOR";

    private static final String COL_MIN_TENOR_TYPE = "MIN_TENOR_TYPE";

    private static final String COL_MAX_TENOR_TYPE = "MAX_TENOR_TYPE";

    private static final String COL_ORIGIN = "ORIGIN";

    private static final String COL_TD_TYPE = "TD_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_LIQ_MAX_LIMIT, COL_MIN_BOOK_LIMIT, COL_MAX_BOOK_LIMIT, COL_DAILY_BOOKING_LIMIT, COL_TENOR_MAX_AMOUNT, COL_TENOR_MIN_DAYS, COL_TENOR_MAX_DAYS, COL_SCHEME_CODES, COL_ABOVE_AMT, COL_BELOW_AMT, COL_A_START_NUMBER, COL_A_START_TYPE, COL_A_END_NUMBER, COL_A_END_TYPE, COL_B_START_NUMBER, COL_B_START_TYPE, COL_B_END_NUMBER, COL_B_END_TYPE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PARENT_REF_ID, COL_PARENT_ID, COL_PARENT_VERSION_ID, COL_ABOVE_RANGE, COL_BELOW_RANGE, COL_TASK_REASON, COL_MIN_TENOR, COL_MAX_TENOR, COL_MIN_TENOR_TYPE, COL_MAX_TENOR_TYPE, COL_ORIGIN, COL_TD_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LIQ_MAX_LIMIT, MIN_BOOK_LIMIT, MAX_BOOK_LIMIT, DAILY_BOOKING_LIMIT, TENOR_MAX_AMOUNT, TENOR_MIN_DAYS, TENOR_MAX_DAYS, SCHEME_CODES, ABOVE_AMT, BELOW_AMT, A_START_NUMBER, A_START_TYPE, A_END_NUMBER, A_END_TYPE, B_START_NUMBER, B_START_TYPE, B_END_NUMBER, B_END_TYPE, VERSION_ID, IS_MASTER_VERSION, PARENT_REF_ID, PARENT_ID, PARENT_VERSION_ID, ABOVE_RANGE, BELOW_RANGE, TASK_REASON, MIN_TENOR, MAX_TENOR, MIN_TENOR_TYPE, MAX_TENOR_TYPE, ORIGIN, TD_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LIQ_MAX_LIMIT, MIN_BOOK_LIMIT, MAX_BOOK_LIMIT, DAILY_BOOKING_LIMIT, TENOR_MAX_AMOUNT, TENOR_MIN_DAYS, TENOR_MAX_DAYS, SCHEME_CODES, ABOVE_AMT, BELOW_AMT, A_START_NUMBER, A_START_TYPE, A_END_NUMBER, A_END_TYPE, B_START_NUMBER, B_START_TYPE, B_END_NUMBER, B_END_TYPE, VERSION_ID, IS_MASTER_VERSION, PARENT_REF_ID, PARENT_ID, PARENT_VERSION_ID, ABOVE_RANGE, BELOW_RANGE, TASK_REASON, MIN_TENOR, MAX_TENOR, MIN_TENOR_TYPE, MAX_TENOR_TYPE, ORIGIN, TD_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_LIQ_MAX_LIMIT, COL_MIN_BOOK_LIMIT, COL_MAX_BOOK_LIMIT, COL_DAILY_BOOKING_LIMIT, COL_TENOR_MAX_AMOUNT, COL_TENOR_MIN_DAYS, COL_TENOR_MAX_DAYS, COL_SCHEME_CODES, COL_ABOVE_AMT, COL_BELOW_AMT, COL_A_START_NUMBER, COL_A_START_TYPE, COL_A_END_NUMBER, COL_A_END_TYPE, COL_B_START_NUMBER, COL_B_START_TYPE, COL_B_END_NUMBER, COL_B_END_TYPE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PARENT_REF_ID, COL_PARENT_ID, COL_PARENT_VERSION_ID, COL_ABOVE_RANGE, COL_BELOW_RANGE, COL_TASK_REASON, COL_MIN_TENOR, COL_MAX_TENOR, COL_MIN_TENOR_TYPE, COL_MAX_TENOR_TYPE, COL_ORIGIN, COL_TD_TYPE, COL_ID);

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

    public int insert(Connection conn, FgTdLimitConfig fgtdlimitconfig) throws SQLException {
        logger.debug("Inserting fgtdlimitconfig: {}", fgtdlimitconfig);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdLimitConfigParams(ps, fgtdlimitconfig);
            ps.executeUpdate();
            return fgtdlimitconfig.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdLimitConfig> fgtdlimitconfigs) throws SQLException {
        if (fgtdlimitconfigs == null || fgtdlimitconfigs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdlimitconfigs.size(); i++) {
            if (fgtdlimitconfigs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdLimitConfig>> batches = chunkList(fgtdlimitconfigs, batchSize);
        int[] totalResults = new int[fgtdlimitconfigs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdLimitConfig> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdLimitConfig fgtdlimitconfig : batch) {
                        setFgTdLimitConfigParams(ps, fgtdlimitconfig);
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

    public FgTdLimitConfig findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdLimitConfig> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdLimitConfig> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdLimitConfig fgtdlimitconfig) throws SQLException {
        if (fgtdlimitconfig.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdLimitConfigParams(ps, fgtdlimitconfig);
            ps.setInt(48, fgtdlimitconfig.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdLimitConfig> fgtdlimitconfigs) throws SQLException {
        if (fgtdlimitconfigs == null || fgtdlimitconfigs.isEmpty())
            return new int[0];
        for (FgTdLimitConfig fgtdlimitconfig : fgtdlimitconfigs) {
            if (fgtdlimitconfig == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdlimitconfig.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdLimitConfig>> batches = chunkList(fgtdlimitconfigs, batchSize);
        int[] totalResults = new int[fgtdlimitconfigs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdLimitConfig> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdLimitConfig fgtdlimitconfig : batch) {
                        setFgTdLimitConfigParams(ps, fgtdlimitconfig);
                        ps.setInt(48, fgtdlimitconfig.getID());
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

    private void setFgTdLimitConfigParams(PreparedStatement ps, FgTdLimitConfig fgtdlimitconfig) throws SQLException {
        Integer val1 = fgtdlimitconfig.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtdlimitconfig.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtdlimitconfig.getTypeCode());
        ps.setString(4, fgtdlimitconfig.getSubTypeCode());
        ps.setString(5, fgtdlimitconfig.getActiveCode());
        ps.setString(6, fgtdlimitconfig.getStageCode());
        ps.setString(7, fgtdlimitconfig.getStatusCode());
        Integer val8 = fgtdlimitconfig.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtdlimitconfig.getCreatedOn());
        java.math.BigDecimal val10 = fgtdlimitconfig.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtdlimitconfig.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtdlimitconfig.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtdlimitconfig.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtdlimitconfig.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtdlimitconfig.getTemplate());
        java.math.BigDecimal val16 = fgtdlimitconfig.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.math.BigDecimal val17 = fgtdlimitconfig.getLiqMaxLimit();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = fgtdlimitconfig.getMinBookLimit();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgtdlimitconfig.getMaxBookLimit();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtdlimitconfig.getDailyBookingLimit();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtdlimitconfig.getTenorMaxAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtdlimitconfig.getTenorMinDays();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtdlimitconfig.getTenorMaxDays();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgtdlimitconfig.getSchemeCodes());
        java.math.BigDecimal val25 = fgtdlimitconfig.getAboveAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgtdlimitconfig.getBelowAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgtdlimitconfig.getAStartNumber();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgtdlimitconfig.getAStartType());
        java.math.BigDecimal val29 = fgtdlimitconfig.getAEndNumber();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgtdlimitconfig.getAEndType());
        java.math.BigDecimal val31 = fgtdlimitconfig.getBStartNumber();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, fgtdlimitconfig.getBStartType());
        java.math.BigDecimal val33 = fgtdlimitconfig.getBEndNumber();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        ps.setString(34, fgtdlimitconfig.getBEndType());
        Integer val35 = fgtdlimitconfig.getVersionID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
        java.math.BigDecimal val36 = fgtdlimitconfig.getIsMasterVersion();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        Integer val37 = fgtdlimitconfig.getParentRefID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        Integer val38 = fgtdlimitconfig.getParentID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
        Integer val39 = fgtdlimitconfig.getParentVersionID();
        if (val39 != null) {
            ps.setInt(39, val39);
        } else {
            ps.setNull(39, Types.INTEGER);
        }
        ps.setString(40, fgtdlimitconfig.getAboveRange());
        ps.setString(41, fgtdlimitconfig.getBelowRange());
        ps.setString(42, fgtdlimitconfig.getTaskReason());
        java.math.BigDecimal val43 = fgtdlimitconfig.getMinTenor();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        java.math.BigDecimal val44 = fgtdlimitconfig.getMaxTenor();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        ps.setString(45, fgtdlimitconfig.getMinTenorType());
        ps.setString(46, fgtdlimitconfig.getMaxTenorType());
        ps.setString(47, fgtdlimitconfig.getOrigin());
        ps.setString(48, fgtdlimitconfig.getTdType());
    }

    private FgTdLimitConfig extract(ResultSet rs) throws SQLException {
        FgTdLimitConfig fgtdlimitconfig = new FgTdLimitConfig();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtdlimitconfig.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdlimitconfig.setReferenceID(REFERENCE_ID);
        fgtdlimitconfig.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdlimitconfig.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdlimitconfig.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtdlimitconfig.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdlimitconfig.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdlimitconfig.setProcessID(PROCESS_ID);
        fgtdlimitconfig.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtdlimitconfig.setCreatedBy(CREATED_BY);
        fgtdlimitconfig.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtdlimitconfig.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtdlimitconfig.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtdlimitconfig.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtdlimitconfig.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtdlimitconfig.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal LIQ_MAX_LIMIT = rs.getObject(COL_LIQ_MAX_LIMIT, java.math.BigDecimal.class);
        fgtdlimitconfig.setLiqMaxLimit(LIQ_MAX_LIMIT);
        java.math.BigDecimal MIN_BOOK_LIMIT = rs.getObject(COL_MIN_BOOK_LIMIT, java.math.BigDecimal.class);
        fgtdlimitconfig.setMinBookLimit(MIN_BOOK_LIMIT);
        java.math.BigDecimal MAX_BOOK_LIMIT = rs.getObject(COL_MAX_BOOK_LIMIT, java.math.BigDecimal.class);
        fgtdlimitconfig.setMaxBookLimit(MAX_BOOK_LIMIT);
        java.math.BigDecimal DAILY_BOOKING_LIMIT = rs.getObject(COL_DAILY_BOOKING_LIMIT, java.math.BigDecimal.class);
        fgtdlimitconfig.setDailyBookingLimit(DAILY_BOOKING_LIMIT);
        java.math.BigDecimal TENOR_MAX_AMOUNT = rs.getObject(COL_TENOR_MAX_AMOUNT, java.math.BigDecimal.class);
        fgtdlimitconfig.setTenorMaxAmount(TENOR_MAX_AMOUNT);
        java.math.BigDecimal TENOR_MIN_DAYS = rs.getObject(COL_TENOR_MIN_DAYS, java.math.BigDecimal.class);
        fgtdlimitconfig.setTenorMinDays(TENOR_MIN_DAYS);
        java.math.BigDecimal TENOR_MAX_DAYS = rs.getObject(COL_TENOR_MAX_DAYS, java.math.BigDecimal.class);
        fgtdlimitconfig.setTenorMaxDays(TENOR_MAX_DAYS);
        fgtdlimitconfig.setSchemeCodes(rs.getString(COL_SCHEME_CODES));
        java.math.BigDecimal ABOVE_AMT = rs.getObject(COL_ABOVE_AMT, java.math.BigDecimal.class);
        fgtdlimitconfig.setAboveAmt(ABOVE_AMT);
        java.math.BigDecimal BELOW_AMT = rs.getObject(COL_BELOW_AMT, java.math.BigDecimal.class);
        fgtdlimitconfig.setBelowAmt(BELOW_AMT);
        java.math.BigDecimal A_START_NUMBER = rs.getObject(COL_A_START_NUMBER, java.math.BigDecimal.class);
        fgtdlimitconfig.setAStartNumber(A_START_NUMBER);
        fgtdlimitconfig.setAStartType(rs.getString(COL_A_START_TYPE));
        java.math.BigDecimal A_END_NUMBER = rs.getObject(COL_A_END_NUMBER, java.math.BigDecimal.class);
        fgtdlimitconfig.setAEndNumber(A_END_NUMBER);
        fgtdlimitconfig.setAEndType(rs.getString(COL_A_END_TYPE));
        java.math.BigDecimal B_START_NUMBER = rs.getObject(COL_B_START_NUMBER, java.math.BigDecimal.class);
        fgtdlimitconfig.setBStartNumber(B_START_NUMBER);
        fgtdlimitconfig.setBStartType(rs.getString(COL_B_START_TYPE));
        java.math.BigDecimal B_END_NUMBER = rs.getObject(COL_B_END_NUMBER, java.math.BigDecimal.class);
        fgtdlimitconfig.setBEndNumber(B_END_NUMBER);
        fgtdlimitconfig.setBEndType(rs.getString(COL_B_END_TYPE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtdlimitconfig.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtdlimitconfig.setIsMasterVersion(IS_MASTER_VERSION);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtdlimitconfig.setParentRefID(PARENT_REF_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        fgtdlimitconfig.setParentID(PARENT_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtdlimitconfig.setParentVersionID(PARENT_VERSION_ID);
        fgtdlimitconfig.setAboveRange(rs.getString(COL_ABOVE_RANGE));
        fgtdlimitconfig.setBelowRange(rs.getString(COL_BELOW_RANGE));
        fgtdlimitconfig.setTaskReason(rs.getString(COL_TASK_REASON));
        java.math.BigDecimal MIN_TENOR = rs.getObject(COL_MIN_TENOR, java.math.BigDecimal.class);
        fgtdlimitconfig.setMinTenor(MIN_TENOR);
        java.math.BigDecimal MAX_TENOR = rs.getObject(COL_MAX_TENOR, java.math.BigDecimal.class);
        fgtdlimitconfig.setMaxTenor(MAX_TENOR);
        fgtdlimitconfig.setMinTenorType(rs.getString(COL_MIN_TENOR_TYPE));
        fgtdlimitconfig.setMaxTenorType(rs.getString(COL_MAX_TENOR_TYPE));
        fgtdlimitconfig.setOrigin(rs.getString(COL_ORIGIN));
        fgtdlimitconfig.setTdType(rs.getString(COL_TD_TYPE));
        return fgtdlimitconfig;
    }
}
