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

public class JdbcFgTdTenureDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdTenureDao.class);

    private static final String TABLE = "FG_TD_TENURE";

    private static final String COL_TENURE = "TENURE";

    private static final String COL_INTEREST_RATES = "INTEREST_RATES";

    private static final String COL_RECOMMENDED = "RECOMMENDED";

    private static final String COL_INTEREST = "INTEREST";

    private static final String COL_DAYS = "DAYS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_TENURE, COL_INTEREST_RATES, COL_RECOMMENDED, COL_INTEREST, COL_DAYS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("TENURE, INTEREST_RATES, RECOMMENDED, INTEREST, DAYS", TABLE, COL_TENURE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("TENURE, INTEREST_RATES, RECOMMENDED, INTEREST, DAYS", TABLE, COL_TENURE);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_INTEREST_RATES, COL_RECOMMENDED, COL_INTEREST, COL_DAYS, COL_TENURE);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_TENURE);

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

    public String insert(Connection conn, FgTdTenure fgtdtenure) throws SQLException {
        logger.debug("Inserting fgtdtenure: {}", fgtdtenure);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdTenureParams(ps, fgtdtenure);
            ps.executeUpdate();
            return fgtdtenure.getTenure();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdTenure> fgtdtenures) throws SQLException {
        if (fgtdtenures == null || fgtdtenures.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdtenures.size(); i++) {
            if (fgtdtenures.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdTenure>> batches = chunkList(fgtdtenures, batchSize);
        int[] totalResults = new int[fgtdtenures.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdTenure> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdTenure fgtdtenure : batch) {
                        setFgTdTenureParams(ps, fgtdtenure);
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

    public FgTdTenure findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdTenure> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdTenure> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdTenure fgtdtenure) throws SQLException {
        if (fgtdtenure.getTenure() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdTenureParams(ps, fgtdtenure);
            ps.setString(5, fgtdtenure.getTenure());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdTenure> fgtdtenures) throws SQLException {
        if (fgtdtenures == null || fgtdtenures.isEmpty())
            return new int[0];
        for (FgTdTenure fgtdtenure : fgtdtenures) {
            if (fgtdtenure == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdtenure.getTenure() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdTenure>> batches = chunkList(fgtdtenures, batchSize);
        int[] totalResults = new int[fgtdtenures.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdTenure> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdTenure fgtdtenure : batch) {
                        setFgTdTenureParams(ps, fgtdtenure);
                        ps.setString(5, fgtdtenure.getTenure());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_TENURE, placeholders);
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

    private void setFgTdTenureParams(PreparedStatement ps, FgTdTenure fgtdtenure) throws SQLException {
        ps.setString(1, fgtdtenure.getTenure());
        java.math.BigDecimal val2 = fgtdtenure.getInterestRates();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgtdtenure.getRecommended());
        ps.setString(4, fgtdtenure.getInterest());
        ps.setString(5, fgtdtenure.getDays());
    }

    private FgTdTenure extract(ResultSet rs) throws SQLException {
        FgTdTenure fgtdtenure = new FgTdTenure();
        fgtdtenure.setTenure(rs.getString(COL_TENURE));
        java.math.BigDecimal INTEREST_RATES = rs.getObject(COL_INTEREST_RATES, java.math.BigDecimal.class);
        fgtdtenure.setInterestRates(INTEREST_RATES);
        fgtdtenure.setRecommended(rs.getString(COL_RECOMMENDED));
        fgtdtenure.setInterest(rs.getString(COL_INTEREST));
        fgtdtenure.setDays(rs.getString(COL_DAYS));
        return fgtdtenure;
    }
}
