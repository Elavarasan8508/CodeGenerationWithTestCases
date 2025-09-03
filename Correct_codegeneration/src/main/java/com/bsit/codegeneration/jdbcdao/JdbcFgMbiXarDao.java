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

public class JdbcFgMbiXarDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMbiXarDao.class);

    private static final String TABLE = "FG_MBI_XAR";

    private static final String COL_IRM_NO = "IRM_NO";

    private static final String COL_IRM_DATE = "IRM_DATE";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_IRM_OS_AMT = "IRM_OS_AMT";

    private static final String COL_IRM_UTIL_AMT = "IRM_UTIL_AMT";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String COL_PURPOSE_OF_REMITTANCE = "PURPOSE_OF_REMITTANCE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_IRM_NO, COL_IRM_DATE, COL_AD_CODE, COL_IRM_CCY, COL_IRM_AMT, COL_IRM_OS_AMT, COL_IRM_UTIL_AMT, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_PURPOSE_OF_REMITTANCE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("IRM_NO, IRM_DATE, AD_CODE, IRM_CCY, IRM_AMT, IRM_OS_AMT, IRM_UTIL_AMT, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE", TABLE, COL_IRM_NO);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("IRM_NO, IRM_DATE, AD_CODE, IRM_CCY, IRM_AMT, IRM_OS_AMT, IRM_UTIL_AMT, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE", TABLE, COL_IRM_NO);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_IRM_DATE, COL_AD_CODE, COL_IRM_CCY, COL_IRM_AMT, COL_IRM_OS_AMT, COL_IRM_UTIL_AMT, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_PURPOSE_OF_REMITTANCE, COL_IRM_NO);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_IRM_NO);

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

    public String insert(Connection conn, FgMbiXar fgmbixar) throws SQLException {
        logger.debug("Inserting fgmbixar: {}", fgmbixar);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMbiXarParams(ps, fgmbixar);
            ps.executeUpdate();
            return fgmbixar.getIrmNo();
        }
    }

    public int[] insertAll(Connection conn, List<FgMbiXar> fgmbixars) throws SQLException {
        if (fgmbixars == null || fgmbixars.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmbixars.size(); i++) {
            if (fgmbixars.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiXar>> batches = chunkList(fgmbixars, batchSize);
        int[] totalResults = new int[fgmbixars.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiXar> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMbiXar fgmbixar : batch) {
                        setFgMbiXarParams(ps, fgmbixar);
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

    public FgMbiXar findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMbiXar> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMbiXar> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMbiXar fgmbixar) throws SQLException {
        if (fgmbixar.getIrmNo() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMbiXarParams(ps, fgmbixar);
            ps.setString(12, fgmbixar.getIrmNo());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMbiXar> fgmbixars) throws SQLException {
        if (fgmbixars == null || fgmbixars.isEmpty())
            return new int[0];
        for (FgMbiXar fgmbixar : fgmbixars) {
            if (fgmbixar == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmbixar.getIrmNo() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiXar>> batches = chunkList(fgmbixars, batchSize);
        int[] totalResults = new int[fgmbixars.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiXar> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMbiXar fgmbixar : batch) {
                        setFgMbiXarParams(ps, fgmbixar);
                        ps.setString(12, fgmbixar.getIrmNo());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_IRM_NO, placeholders);
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

    private void setFgMbiXarParams(PreparedStatement ps, FgMbiXar fgmbixar) throws SQLException {
        ps.setString(1, fgmbixar.getIrmNo());
        java.time.LocalDateTime val2 = fgmbixar.getIrmDate();
        if (val2 != null) {
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(val2));
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
        ps.setString(3, fgmbixar.getAdCode());
        ps.setString(4, fgmbixar.getIrmCcy());
        java.math.BigDecimal val5 = fgmbixar.getIrmAmt();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = fgmbixar.getIrmOsAmt();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = fgmbixar.getIrmUtilAmt();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, fgmbixar.getIeCode());
        ps.setString(9, fgmbixar.getRemitterName());
        ps.setString(10, fgmbixar.getRemitterCountry());
        ps.setString(11, fgmbixar.getRemitBankCountry());
        ps.setString(12, fgmbixar.getPurposeOfRemittance());
    }

    private FgMbiXar extract(ResultSet rs) throws SQLException {
        FgMbiXar fgmbixar = new FgMbiXar();
        fgmbixar.setIrmNo(rs.getString(COL_IRM_NO));
        Timestamp IRM_DATE = rs.getTimestamp(COL_IRM_DATE);
        if (IRM_DATE != null)
            fgmbixar.setIrmDate(IRM_DATE.toLocalDateTime());
        fgmbixar.setAdCode(rs.getString(COL_AD_CODE));
        fgmbixar.setIrmCcy(rs.getString(COL_IRM_CCY));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgmbixar.setIrmAmt(IRM_AMT);
        java.math.BigDecimal IRM_OS_AMT = rs.getObject(COL_IRM_OS_AMT, java.math.BigDecimal.class);
        fgmbixar.setIrmOsAmt(IRM_OS_AMT);
        java.math.BigDecimal IRM_UTIL_AMT = rs.getObject(COL_IRM_UTIL_AMT, java.math.BigDecimal.class);
        fgmbixar.setIrmUtilAmt(IRM_UTIL_AMT);
        fgmbixar.setIeCode(rs.getString(COL_IE_CODE));
        fgmbixar.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgmbixar.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgmbixar.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        fgmbixar.setPurposeOfRemittance(rs.getString(COL_PURPOSE_OF_REMITTANCE));
        return fgmbixar;
    }
}
