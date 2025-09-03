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

public class JdbcGtpXchRatesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcGtpXchRatesDao.class);

    private static final String TABLE = "GTP_XCH_RATES";

    private static final String COL_BANK_ABBV_NAME = "BANK_ABBV_NAME";

    private static final String COL_ISO_CODE = "ISO_CODE";

    private static final String COL_BASE_ISO_CODE = "BASE_ISO_CODE";

    private static final String COL_BRCH_CODE = "BRCH_CODE";

    private static final String COL_BUY_TT_RATE = "BUY_TT_RATE";

    private static final String COL_EURO_IN_CURRENCY = "EURO_IN_CURRENCY";

    private static final String COL_EURO_RATE = "EURO_RATE";

    private static final String COL_MID_TT_RATE = "MID_TT_RATE";

    private static final String COL_PATY_VAL = "PATY_VAL";

    private static final String COL_SELL_TT_RATE = "SELL_TT_RATE";

    private static final String COL_UPDATE_DATE = "UPDATE_DATE";

    private static final String COL_START_VALUE_DATE = "START_VALUE_DATE";

    private static final String COL_END_VALUE_DATE = "END_VALUE_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_BANK_ABBV_NAME, COL_ISO_CODE, COL_BASE_ISO_CODE, COL_BRCH_CODE, COL_BUY_TT_RATE, COL_EURO_IN_CURRENCY, COL_EURO_RATE, COL_MID_TT_RATE, COL_PATY_VAL, COL_SELL_TT_RATE, COL_UPDATE_DATE, COL_START_VALUE_DATE, COL_END_VALUE_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("BANK_ABBV_NAME, ISO_CODE, BASE_ISO_CODE, BRCH_CODE, BUY_TT_RATE, EURO_IN_CURRENCY, EURO_RATE, MID_TT_RATE, PATY_VAL, SELL_TT_RATE, UPDATE_DATE, START_VALUE_DATE, END_VALUE_DATE", TABLE, COL_BANK_ABBV_NAME);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("BANK_ABBV_NAME, ISO_CODE, BASE_ISO_CODE, BRCH_CODE, BUY_TT_RATE, EURO_IN_CURRENCY, EURO_RATE, MID_TT_RATE, PATY_VAL, SELL_TT_RATE, UPDATE_DATE, START_VALUE_DATE, END_VALUE_DATE", TABLE, COL_BANK_ABBV_NAME);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ISO_CODE, COL_BASE_ISO_CODE, COL_BRCH_CODE, COL_BUY_TT_RATE, COL_EURO_IN_CURRENCY, COL_EURO_RATE, COL_MID_TT_RATE, COL_PATY_VAL, COL_SELL_TT_RATE, COL_UPDATE_DATE, COL_START_VALUE_DATE, COL_END_VALUE_DATE, COL_BANK_ABBV_NAME);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_BANK_ABBV_NAME);

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

    public String insert(Connection conn, GtpXchRates gtpxchrates) throws SQLException {
        logger.debug("Inserting gtpxchrates: {}", gtpxchrates);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setGtpXchRatesParams(ps, gtpxchrates);
            ps.executeUpdate();
            return gtpxchrates.getBankAbbvName();
        }
    }

    public int[] insertAll(Connection conn, List<GtpXchRates> gtpxchratess) throws SQLException {
        if (gtpxchratess == null || gtpxchratess.isEmpty())
            return new int[0];
        for (int i = 0; i < gtpxchratess.size(); i++) {
            if (gtpxchratess.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<GtpXchRates>> batches = chunkList(gtpxchratess, batchSize);
        int[] totalResults = new int[gtpxchratess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<GtpXchRates> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (GtpXchRates gtpxchrates : batch) {
                        setGtpXchRatesParams(ps, gtpxchrates);
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

    public GtpXchRates findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<GtpXchRates> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<GtpXchRates> list = new ArrayList<>();
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

    public boolean update(Connection conn, GtpXchRates gtpxchrates) throws SQLException {
        if (gtpxchrates.getBankAbbvName() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setGtpXchRatesParams(ps, gtpxchrates);
            ps.setString(13, gtpxchrates.getBankAbbvName());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<GtpXchRates> gtpxchratess) throws SQLException {
        if (gtpxchratess == null || gtpxchratess.isEmpty())
            return new int[0];
        for (GtpXchRates gtpxchrates : gtpxchratess) {
            if (gtpxchrates == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (gtpxchrates.getBankAbbvName() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<GtpXchRates>> batches = chunkList(gtpxchratess, batchSize);
        int[] totalResults = new int[gtpxchratess.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<GtpXchRates> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (GtpXchRates gtpxchrates : batch) {
                        setGtpXchRatesParams(ps, gtpxchrates);
                        ps.setString(13, gtpxchrates.getBankAbbvName());
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

    public boolean deleteById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<String> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (String id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<String>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<String> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_BANK_ABBV_NAME, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setString(i + 1, chunk.get(i));
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

    private void setGtpXchRatesParams(PreparedStatement ps, GtpXchRates gtpxchrates) throws SQLException {
        ps.setString(1, gtpxchrates.getBankAbbvName());
        ps.setString(2, gtpxchrates.getIsoCode());
        ps.setString(3, gtpxchrates.getBaseIsoCode());
        ps.setString(4, gtpxchrates.getBrchCode());
        java.math.BigDecimal val5 = gtpxchrates.getBuyTtRate();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, gtpxchrates.getEuroInCurrency());
        java.math.BigDecimal val7 = gtpxchrates.getEuroRate();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = gtpxchrates.getMidTtRate();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = gtpxchrates.getPatyVal();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        java.math.BigDecimal val10 = gtpxchrates.getSellTtRate();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, gtpxchrates.getUpdateDate());
        ps.setString(12, gtpxchrates.getStartValueDate());
        ps.setString(13, gtpxchrates.getEndValueDate());
    }

    private GtpXchRates extract(ResultSet rs) throws SQLException {
        GtpXchRates gtpxchrates = new GtpXchRates();
        gtpxchrates.setBankAbbvName(rs.getString(COL_BANK_ABBV_NAME));
        gtpxchrates.setIsoCode(rs.getString(COL_ISO_CODE));
        gtpxchrates.setBaseIsoCode(rs.getString(COL_BASE_ISO_CODE));
        gtpxchrates.setBrchCode(rs.getString(COL_BRCH_CODE));
        java.math.BigDecimal BUY_TT_RATE = rs.getObject(COL_BUY_TT_RATE, java.math.BigDecimal.class);
        gtpxchrates.setBuyTtRate(BUY_TT_RATE);
        gtpxchrates.setEuroInCurrency(rs.getString(COL_EURO_IN_CURRENCY));
        java.math.BigDecimal EURO_RATE = rs.getObject(COL_EURO_RATE, java.math.BigDecimal.class);
        gtpxchrates.setEuroRate(EURO_RATE);
        java.math.BigDecimal MID_TT_RATE = rs.getObject(COL_MID_TT_RATE, java.math.BigDecimal.class);
        gtpxchrates.setMidTtRate(MID_TT_RATE);
        java.math.BigDecimal PATY_VAL = rs.getObject(COL_PATY_VAL, java.math.BigDecimal.class);
        gtpxchrates.setPatyVal(PATY_VAL);
        java.math.BigDecimal SELL_TT_RATE = rs.getObject(COL_SELL_TT_RATE, java.math.BigDecimal.class);
        gtpxchrates.setSellTtRate(SELL_TT_RATE);
        gtpxchrates.setUpdateDate(rs.getString(COL_UPDATE_DATE));
        gtpxchrates.setStartValueDate(rs.getString(COL_START_VALUE_DATE));
        gtpxchrates.setEndValueDate(rs.getString(COL_END_VALUE_DATE));
        return gtpxchrates;
    }
}
