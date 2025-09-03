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

public class JdbcFgTrdBillIrmDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdBillIrmDao.class);

    private static final String TABLE = "FG_TRD_BILL_IRM";

    private static final String COL_IRM_NUMBER = "IRM_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_IRM_OS_AMT = "IRM_OS_AMT";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_REMITTANCE_DATE = "REMITTANCE_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_IRM_NUMBER, COL_AD_CODE, COL_IRM_AMT, COL_IRM_OS_AMT, COL_IRM_CCY, COL_REMITTANCE_DATE, COL_IE_CODE, COL_REMITTER_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("IRM_NUMBER, AD_CODE, IRM_AMT, IRM_OS_AMT, IRM_CCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME", TABLE, COL_IRM_NUMBER);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("IRM_NUMBER, AD_CODE, IRM_AMT, IRM_OS_AMT, IRM_CCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME", TABLE, COL_IRM_NUMBER);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AD_CODE, COL_IRM_AMT, COL_IRM_OS_AMT, COL_IRM_CCY, COL_REMITTANCE_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_IRM_NUMBER);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_IRM_NUMBER);

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

    public String insert(Connection conn, FgTrdBillIrm fgtrdbillirm) throws SQLException {
        logger.debug("Inserting fgtrdbillirm: {}", fgtrdbillirm);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdBillIrmParams(ps, fgtrdbillirm);
            ps.executeUpdate();
            return fgtrdbillirm.getIrmNumber();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdBillIrm> fgtrdbillirms) throws SQLException {
        if (fgtrdbillirms == null || fgtrdbillirms.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdbillirms.size(); i++) {
            if (fgtrdbillirms.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillIrm>> batches = chunkList(fgtrdbillirms, batchSize);
        int[] totalResults = new int[fgtrdbillirms.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillIrm> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdBillIrm fgtrdbillirm : batch) {
                        setFgTrdBillIrmParams(ps, fgtrdbillirm);
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

    public FgTrdBillIrm findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdBillIrm> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdBillIrm> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdBillIrm fgtrdbillirm) throws SQLException {
        if (fgtrdbillirm.getIrmNumber() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdBillIrmParams(ps, fgtrdbillirm);
            ps.setString(8, fgtrdbillirm.getIrmNumber());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdBillIrm> fgtrdbillirms) throws SQLException {
        if (fgtrdbillirms == null || fgtrdbillirms.isEmpty())
            return new int[0];
        for (FgTrdBillIrm fgtrdbillirm : fgtrdbillirms) {
            if (fgtrdbillirm == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdbillirm.getIrmNumber() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillIrm>> batches = chunkList(fgtrdbillirms, batchSize);
        int[] totalResults = new int[fgtrdbillirms.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillIrm> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdBillIrm fgtrdbillirm : batch) {
                        setFgTrdBillIrmParams(ps, fgtrdbillirm);
                        ps.setString(8, fgtrdbillirm.getIrmNumber());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_IRM_NUMBER, placeholders);
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

    private void setFgTrdBillIrmParams(PreparedStatement ps, FgTrdBillIrm fgtrdbillirm) throws SQLException {
        ps.setString(1, fgtrdbillirm.getIrmNumber());
        ps.setString(2, fgtrdbillirm.getAdCode());
        java.math.BigDecimal val3 = fgtrdbillirm.getIrmAmt();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = fgtrdbillirm.getIrmOsAmt();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        ps.setString(5, fgtrdbillirm.getIrmCcy());
        java.time.LocalDateTime val6 = fgtrdbillirm.getRemittanceDate();
        if (val6 != null) {
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(val6));
        } else {
            ps.setNull(6, Types.TIMESTAMP);
        }
        ps.setString(7, fgtrdbillirm.getIeCode());
        ps.setString(8, fgtrdbillirm.getRemitterName());
    }

    private FgTrdBillIrm extract(ResultSet rs) throws SQLException {
        FgTrdBillIrm fgtrdbillirm = new FgTrdBillIrm();
        fgtrdbillirm.setIrmNumber(rs.getString(COL_IRM_NUMBER));
        fgtrdbillirm.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgtrdbillirm.setIrmAmt(IRM_AMT);
        java.math.BigDecimal IRM_OS_AMT = rs.getObject(COL_IRM_OS_AMT, java.math.BigDecimal.class);
        fgtrdbillirm.setIrmOsAmt(IRM_OS_AMT);
        fgtrdbillirm.setIrmCcy(rs.getString(COL_IRM_CCY));
        Timestamp REMITTANCE_DATE = rs.getTimestamp(COL_REMITTANCE_DATE);
        if (REMITTANCE_DATE != null)
            fgtrdbillirm.setRemittanceDate(REMITTANCE_DATE.toLocalDateTime());
        fgtrdbillirm.setIeCode(rs.getString(COL_IE_CODE));
        fgtrdbillirm.setRemitterName(rs.getString(COL_REMITTER_NAME));
        return fgtrdbillirm;
    }
}
