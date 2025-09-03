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

public class JdbcFxRateTdDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFxRateTdDao.class);

    private static final String TABLE = "FX_RATE_TD";

    private static final String COL_INT_TBL_CODE = "INT_TBL_CODE";

    private static final String COL_CRNCY_CODE = "CRNCY_CODE";

    private static final String COL_INT_SLAB_SRL_NUM = "INT_SLAB_SRL_NUM";

    private static final String COL_MAX_PERIOD_RUN_MTHS = "MAX_PERIOD_RUN_MTHS";

    private static final String COL_MAX_PERIOD_RUN_DAYS = "MAX_PERIOD_RUN_DAYS";

    private static final String COL_BEGIN_SLAB_AMOUNT = "BEGIN_SLAB_AMOUNT";

    private static final String COL_MAX_SLAB_AMOUNT = "MAX_SLAB_AMOUNT";

    private static final String COL_NRML_INT_PCNT = "NRML_INT_PCNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_INT_TBL_CODE, COL_CRNCY_CODE, COL_INT_SLAB_SRL_NUM, COL_MAX_PERIOD_RUN_MTHS, COL_MAX_PERIOD_RUN_DAYS, COL_BEGIN_SLAB_AMOUNT, COL_MAX_SLAB_AMOUNT, COL_NRML_INT_PCNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("INT_TBL_CODE, CRNCY_CODE, INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT, NRML_INT_PCNT", TABLE, COL_INT_TBL_CODE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("INT_TBL_CODE, CRNCY_CODE, INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT, NRML_INT_PCNT", TABLE, COL_INT_TBL_CODE);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CRNCY_CODE, COL_INT_SLAB_SRL_NUM, COL_MAX_PERIOD_RUN_MTHS, COL_MAX_PERIOD_RUN_DAYS, COL_BEGIN_SLAB_AMOUNT, COL_MAX_SLAB_AMOUNT, COL_NRML_INT_PCNT, COL_INT_TBL_CODE);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_INT_TBL_CODE);

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

    public String insert(Connection conn, FxRateTd fxratetd) throws SQLException {
        logger.debug("Inserting fxratetd: {}", fxratetd);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFxRateTdParams(ps, fxratetd);
            ps.executeUpdate();
            return fxratetd.getIntTblCode();
        }
    }

    public int[] insertAll(Connection conn, List<FxRateTd> fxratetds) throws SQLException {
        if (fxratetds == null || fxratetds.isEmpty())
            return new int[0];
        for (int i = 0; i < fxratetds.size(); i++) {
            if (fxratetds.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FxRateTd>> batches = chunkList(fxratetds, batchSize);
        int[] totalResults = new int[fxratetds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FxRateTd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FxRateTd fxratetd : batch) {
                        setFxRateTdParams(ps, fxratetd);
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

    public FxRateTd findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FxRateTd> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FxRateTd> list = new ArrayList<>();
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

    public boolean update(Connection conn, FxRateTd fxratetd) throws SQLException {
        if (fxratetd.getIntTblCode() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFxRateTdParams(ps, fxratetd);
            ps.setString(8, fxratetd.getIntTblCode());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FxRateTd> fxratetds) throws SQLException {
        if (fxratetds == null || fxratetds.isEmpty())
            return new int[0];
        for (FxRateTd fxratetd : fxratetds) {
            if (fxratetd == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fxratetd.getIntTblCode() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FxRateTd>> batches = chunkList(fxratetds, batchSize);
        int[] totalResults = new int[fxratetds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FxRateTd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FxRateTd fxratetd : batch) {
                        setFxRateTdParams(ps, fxratetd);
                        ps.setString(8, fxratetd.getIntTblCode());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_INT_TBL_CODE, placeholders);
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

    private void setFxRateTdParams(PreparedStatement ps, FxRateTd fxratetd) throws SQLException {
        ps.setString(1, fxratetd.getIntTblCode());
        ps.setString(2, fxratetd.getCrncyCode());
        ps.setString(3, fxratetd.getIntSlabSrlNum());
        java.math.BigDecimal val4 = fxratetd.getMaxPeriodRunMths();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = fxratetd.getMaxPeriodRunDays();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = fxratetd.getBeginSlabAmount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = fxratetd.getMaxSlabAmount();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = fxratetd.getNrmlIntPcnt();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
    }

    private FxRateTd extract(ResultSet rs) throws SQLException {
        FxRateTd fxratetd = new FxRateTd();
        fxratetd.setIntTblCode(rs.getString(COL_INT_TBL_CODE));
        fxratetd.setCrncyCode(rs.getString(COL_CRNCY_CODE));
        fxratetd.setIntSlabSrlNum(rs.getString(COL_INT_SLAB_SRL_NUM));
        java.math.BigDecimal MAX_PERIOD_RUN_MTHS = rs.getObject(COL_MAX_PERIOD_RUN_MTHS, java.math.BigDecimal.class);
        fxratetd.setMaxPeriodRunMths(MAX_PERIOD_RUN_MTHS);
        java.math.BigDecimal MAX_PERIOD_RUN_DAYS = rs.getObject(COL_MAX_PERIOD_RUN_DAYS, java.math.BigDecimal.class);
        fxratetd.setMaxPeriodRunDays(MAX_PERIOD_RUN_DAYS);
        java.math.BigDecimal BEGIN_SLAB_AMOUNT = rs.getObject(COL_BEGIN_SLAB_AMOUNT, java.math.BigDecimal.class);
        fxratetd.setBeginSlabAmount(BEGIN_SLAB_AMOUNT);
        java.math.BigDecimal MAX_SLAB_AMOUNT = rs.getObject(COL_MAX_SLAB_AMOUNT, java.math.BigDecimal.class);
        fxratetd.setMaxSlabAmount(MAX_SLAB_AMOUNT);
        java.math.BigDecimal NRML_INT_PCNT = rs.getObject(COL_NRML_INT_PCNT, java.math.BigDecimal.class);
        fxratetd.setNrmlIntPcnt(NRML_INT_PCNT);
        return fxratetd;
    }
}
