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

public class JdbcFgMbiEfircDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMbiEfircDao.class);

    private static final String TABLE = "FG_MBI_EFIRC";

    private static final String COL_FIRC_NUMBER = "FIRC_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_FIRC_AMT = "FIRC_AMT";

    private static final String COL_FIRC_UTIL_AMT = "FIRC_UTIL_AMT";

    private static final String COL_FIRC_OS_AMT = "FIRC_OS_AMT";

    private static final String COL_FIRC_CCY = "FIRC_CCY";

    private static final String COL_FIRC_DATE = "FIRC_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_FIRC_NUMBER, COL_AD_CODE, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_FIRC_CCY, COL_FIRC_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY", TABLE, COL_FIRC_NUMBER);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY", TABLE, COL_FIRC_NUMBER);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AD_CODE, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_FIRC_CCY, COL_FIRC_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_FIRC_NUMBER);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FIRC_NUMBER);

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

    public String insert(Connection conn, FgMbiEfirc fgmbiefirc) throws SQLException {
        logger.debug("Inserting fgmbiefirc: {}", fgmbiefirc);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMbiEfircParams(ps, fgmbiefirc);
            ps.executeUpdate();
            return fgmbiefirc.getFircNumber();
        }
    }

    public int[] insertAll(Connection conn, List<FgMbiEfirc> fgmbiefircs) throws SQLException {
        if (fgmbiefircs == null || fgmbiefircs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmbiefircs.size(); i++) {
            if (fgmbiefircs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiEfirc>> batches = chunkList(fgmbiefircs, batchSize);
        int[] totalResults = new int[fgmbiefircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiEfirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMbiEfirc fgmbiefirc : batch) {
                        setFgMbiEfircParams(ps, fgmbiefirc);
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

    public FgMbiEfirc findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMbiEfirc> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMbiEfirc> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMbiEfirc fgmbiefirc) throws SQLException {
        if (fgmbiefirc.getFircNumber() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMbiEfircParams(ps, fgmbiefirc);
            ps.setString(11, fgmbiefirc.getFircNumber());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMbiEfirc> fgmbiefircs) throws SQLException {
        if (fgmbiefircs == null || fgmbiefircs.isEmpty())
            return new int[0];
        for (FgMbiEfirc fgmbiefirc : fgmbiefircs) {
            if (fgmbiefirc == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmbiefirc.getFircNumber() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiEfirc>> batches = chunkList(fgmbiefircs, batchSize);
        int[] totalResults = new int[fgmbiefircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiEfirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMbiEfirc fgmbiefirc : batch) {
                        setFgMbiEfircParams(ps, fgmbiefirc);
                        ps.setString(11, fgmbiefirc.getFircNumber());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_FIRC_NUMBER, placeholders);
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

    private void setFgMbiEfircParams(PreparedStatement ps, FgMbiEfirc fgmbiefirc) throws SQLException {
        ps.setString(1, fgmbiefirc.getFircNumber());
        ps.setString(2, fgmbiefirc.getAdCode());
        java.math.BigDecimal val3 = fgmbiefirc.getFircAmt();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = fgmbiefirc.getFircUtilAmt();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = fgmbiefirc.getFircOsAmt();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, fgmbiefirc.getFircCcy());
        java.time.LocalDateTime val7 = fgmbiefirc.getFircDate();
        if (val7 != null) {
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(val7));
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
        ps.setString(8, fgmbiefirc.getIeCode());
        ps.setString(9, fgmbiefirc.getRemitterName());
        ps.setString(10, fgmbiefirc.getRemitterCountry());
        ps.setString(11, fgmbiefirc.getRemitBankCountry());
    }

    private FgMbiEfirc extract(ResultSet rs) throws SQLException {
        FgMbiEfirc fgmbiefirc = new FgMbiEfirc();
        fgmbiefirc.setFircNumber(rs.getString(COL_FIRC_NUMBER));
        fgmbiefirc.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal FIRC_AMT = rs.getObject(COL_FIRC_AMT, java.math.BigDecimal.class);
        fgmbiefirc.setFircAmt(FIRC_AMT);
        java.math.BigDecimal FIRC_UTIL_AMT = rs.getObject(COL_FIRC_UTIL_AMT, java.math.BigDecimal.class);
        fgmbiefirc.setFircUtilAmt(FIRC_UTIL_AMT);
        java.math.BigDecimal FIRC_OS_AMT = rs.getObject(COL_FIRC_OS_AMT, java.math.BigDecimal.class);
        fgmbiefirc.setFircOsAmt(FIRC_OS_AMT);
        fgmbiefirc.setFircCcy(rs.getString(COL_FIRC_CCY));
        Timestamp FIRC_DATE = rs.getTimestamp(COL_FIRC_DATE);
        if (FIRC_DATE != null)
            fgmbiefirc.setFircDate(FIRC_DATE.toLocalDateTime());
        fgmbiefirc.setIeCode(rs.getString(COL_IE_CODE));
        fgmbiefirc.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgmbiefirc.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgmbiefirc.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        return fgmbiefirc;
    }
}
