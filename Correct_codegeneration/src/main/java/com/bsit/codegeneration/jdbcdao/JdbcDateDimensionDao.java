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

public class JdbcDateDimensionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDateDimensionDao.class);

    private static final String TABLE = "DATE_DIMENSION";

    private static final String COL_PRESENT_DATE = "PRESENT_DATE";

    private static final String COL_GENERICENDDATERANGE = "GENERICENDDATERANGE";

    private static final String COL_YEAR = "YEAR";

    private static final String COL_MONTH_NUM = "MONTH_NUM";

    private static final String COL_DATE_DD = "DATE_DD";

    private static final String COL_WEEK_DAY = "WEEK_DAY";

    private static final String COL_WEEK = "WEEK";

    private static final String COL_GENERICWEEKDAYSTARTONMONDAY = "GENERICWEEKDAYSTARTONMONDAY";

    private static final String COL_DAY = "DAY";

    private static final String COL_DAY_SHORT = "DAY_SHORT";

    private static final String COL_MONTH = "MONTH";

    private static final String COL_MONTH_SHORT = "MONTH_SHORT";

    private static final String COL_GENERICWEEKNUMBER = "GENERICWEEKNUMBER";

    private static final String COL_QUARTER = "QUARTER";

    private static final String COL_GENERICLASTDAY = "GENERICLASTDAY";

    private static final String COL_GENERICNUMBERCONSTANT = "GENERICNUMBERCONSTANT";

    private static final String COL_GENERICDATECOUNTER = "GENERICDATECOUNTER";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_PRESENT_DATE, COL_GENERICENDDATERANGE, COL_YEAR, COL_MONTH_NUM, COL_DATE_DD, COL_WEEK_DAY, COL_WEEK, COL_GENERICWEEKDAYSTARTONMONDAY, COL_DAY, COL_DAY_SHORT, COL_MONTH, COL_MONTH_SHORT, COL_GENERICWEEKNUMBER, COL_QUARTER, COL_GENERICLASTDAY, COL_GENERICNUMBERCONSTANT, COL_GENERICDATECOUNTER);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("PRESENT_DATE, GENERICENDDATERANGE, YEAR, MONTH_NUM, DATE_DD, WEEK_DAY, WEEK, GENERICWEEKDAYSTARTONMONDAY, DAY, DAY_SHORT, MONTH, MONTH_SHORT, GENERICWEEKNUMBER, QUARTER, GENERICLASTDAY, GENERICNUMBERCONSTANT, GENERICDATECOUNTER", TABLE, COL_PRESENT_DATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("PRESENT_DATE, GENERICENDDATERANGE, YEAR, MONTH_NUM, DATE_DD, WEEK_DAY, WEEK, GENERICWEEKDAYSTARTONMONDAY, DAY, DAY_SHORT, MONTH, MONTH_SHORT, GENERICWEEKNUMBER, QUARTER, GENERICLASTDAY, GENERICNUMBERCONSTANT, GENERICDATECOUNTER", TABLE, COL_PRESENT_DATE);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_GENERICENDDATERANGE, COL_YEAR, COL_MONTH_NUM, COL_DATE_DD, COL_WEEK_DAY, COL_WEEK, COL_GENERICWEEKDAYSTARTONMONDAY, COL_DAY, COL_DAY_SHORT, COL_MONTH, COL_MONTH_SHORT, COL_GENERICWEEKNUMBER, COL_QUARTER, COL_GENERICLASTDAY, COL_GENERICNUMBERCONSTANT, COL_GENERICDATECOUNTER, COL_PRESENT_DATE);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PRESENT_DATE);

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

    public java.time.LocalDateTime insert(Connection conn, DateDimension datedimension) throws SQLException {
        logger.debug("Inserting datedimension: {}", datedimension);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setDateDimensionParams(ps, datedimension);
            ps.executeUpdate();
            return datedimension.getPresentDate();
        }
    }

    public int[] insertAll(Connection conn, List<DateDimension> datedimensions) throws SQLException {
        if (datedimensions == null || datedimensions.isEmpty())
            return new int[0];
        for (int i = 0; i < datedimensions.size(); i++) {
            if (datedimensions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<DateDimension>> batches = chunkList(datedimensions, batchSize);
        int[] totalResults = new int[datedimensions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<DateDimension> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (DateDimension datedimension : batch) {
                        setDateDimensionParams(ps, datedimension);
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

    public DateDimension findById(Connection conn, java.time.LocalDateTime id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setTimestamp(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<DateDimension> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<DateDimension> list = new ArrayList<>();
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

    public boolean update(Connection conn, DateDimension datedimension) throws SQLException {
        if (datedimension.getPresentDate() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setDateDimensionParams(ps, datedimension);
            ps.setTimestamp(17, datedimension.getPresentDate());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<DateDimension> datedimensions) throws SQLException {
        if (datedimensions == null || datedimensions.isEmpty())
            return new int[0];
        for (DateDimension datedimension : datedimensions) {
            if (datedimension == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (datedimension.getPresentDate() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<DateDimension>> batches = chunkList(datedimensions, batchSize);
        int[] totalResults = new int[datedimensions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<DateDimension> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (DateDimension datedimension : batch) {
                        setDateDimensionParams(ps, datedimension);
                        ps.setTimestamp(17, datedimension.getPresentDate());
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

    public boolean deleteById(Connection conn, java.time.LocalDateTime id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setTimestamp(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<java.time.LocalDateTime> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (java.time.LocalDateTime id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<java.time.LocalDateTime>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<java.time.LocalDateTime> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PRESENT_DATE, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setTimestamp(i + 1, chunk.get(i));
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

    private void setDateDimensionParams(PreparedStatement ps, DateDimension datedimension) throws SQLException {
        java.time.LocalDateTime val1 = datedimension.getPresentDate();
        if (val1 != null) {
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(val1));
        } else {
            ps.setNull(1, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val2 = datedimension.getGenericenddaterange();
        if (val2 != null) {
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(val2));
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
        Integer val3 = datedimension.getYear();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, datedimension.getMonthNum());
        ps.setString(5, datedimension.getDateDd());
        java.math.BigDecimal val6 = datedimension.getWeekDay();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, datedimension.getWeek());
        java.math.BigDecimal val8 = datedimension.getGenericweekdaystartonmonday();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, datedimension.getDay());
        ps.setString(10, datedimension.getDayShort());
        ps.setString(11, datedimension.getMonth());
        ps.setString(12, datedimension.getMonthShort());
        ps.setString(13, datedimension.getGenericweeknumber());
        ps.setString(14, datedimension.getQuarter());
        java.time.LocalDateTime val15 = datedimension.getGenericlastday();
        if (val15 != null) {
            ps.setTimestamp(15, java.sql.Timestamp.valueOf(val15));
        } else {
            ps.setNull(15, Types.TIMESTAMP);
        }
        java.math.BigDecimal val16 = datedimension.getGenericnumberconstant();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.math.BigDecimal val17 = datedimension.getGenericdatecounter();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
    }

    private DateDimension extract(ResultSet rs) throws SQLException {
        DateDimension datedimension = new DateDimension();
        Timestamp PRESENT_DATE = rs.getTimestamp(COL_PRESENT_DATE);
        if (PRESENT_DATE != null)
            datedimension.setPresentDate(PRESENT_DATE.toLocalDateTime());
        Timestamp GENERICENDDATERANGE = rs.getTimestamp(COL_GENERICENDDATERANGE);
        if (GENERICENDDATERANGE != null)
            datedimension.setGenericenddaterange(GENERICENDDATERANGE.toLocalDateTime());
        Integer YEAR = rs.getObject(COL_YEAR, Integer.class);
        datedimension.setYear(YEAR);
        datedimension.setMonthNum(rs.getString(COL_MONTH_NUM));
        datedimension.setDateDd(rs.getString(COL_DATE_DD));
        java.math.BigDecimal WEEK_DAY = rs.getObject(COL_WEEK_DAY, java.math.BigDecimal.class);
        datedimension.setWeekDay(WEEK_DAY);
        datedimension.setWeek(rs.getString(COL_WEEK));
        java.math.BigDecimal GENERICWEEKDAYSTARTONMONDAY = rs.getObject(COL_GENERICWEEKDAYSTARTONMONDAY, java.math.BigDecimal.class);
        datedimension.setGenericweekdaystartonmonday(GENERICWEEKDAYSTARTONMONDAY);
        datedimension.setDay(rs.getString(COL_DAY));
        datedimension.setDayShort(rs.getString(COL_DAY_SHORT));
        datedimension.setMonth(rs.getString(COL_MONTH));
        datedimension.setMonthShort(rs.getString(COL_MONTH_SHORT));
        datedimension.setGenericweeknumber(rs.getString(COL_GENERICWEEKNUMBER));
        datedimension.setQuarter(rs.getString(COL_QUARTER));
        Timestamp GENERICLASTDAY = rs.getTimestamp(COL_GENERICLASTDAY);
        if (GENERICLASTDAY != null)
            datedimension.setGenericlastday(GENERICLASTDAY.toLocalDateTime());
        java.math.BigDecimal GENERICNUMBERCONSTANT = rs.getObject(COL_GENERICNUMBERCONSTANT, java.math.BigDecimal.class);
        datedimension.setGenericnumberconstant(GENERICNUMBERCONSTANT);
        java.math.BigDecimal GENERICDATECOUNTER = rs.getObject(COL_GENERICDATECOUNTER, java.math.BigDecimal.class);
        datedimension.setGenericdatecounter(GENERICDATECOUNTER);
        return datedimension;
    }
}
