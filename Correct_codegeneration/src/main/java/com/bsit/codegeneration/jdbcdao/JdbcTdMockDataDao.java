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

public class JdbcTdMockDataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTdMockDataDao.class);

    private static final String TABLE = "TD_MOCK_DATA";

    private static final String COL_BANK_ID = "BANK_ID";

    private static final String COL_ACCOUNT_NAME = "ACCOUNT_NAME";

    private static final String COL_TD_ACCOUNT_NO = "TD_ACCOUNT_NO";

    private static final String COL_TD_ACC_TEMP = "TD_ACC_TEMP";

    private static final String COL_CIF_ID = "CIF_ID";

    private static final String COL_DEPOSIT_AMOUNT = "DEPOSIT_AMOUNT";

    private static final String COL_MATURITY_AMOUNT = "MATURITY_AMOUNT";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_AVAILABLE_AMOUNT = "AVAILABLE_AMOUNT";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_LINKED_ACCOUNT = "LINKED_ACCOUNT";

    private static final String COL_BRANCH = "BRANCH";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_BANK_ID, COL_ACCOUNT_NAME, COL_TD_ACCOUNT_NO, COL_TD_ACC_TEMP, COL_CIF_ID, COL_DEPOSIT_AMOUNT, COL_MATURITY_AMOUNT, COL_EFFECTIVE_DATE, COL_MATURITY_DATE, COL_AVAILABLE_AMOUNT, COL_END_DATE, COL_INTEREST_RATE, COL_LINKED_ACCOUNT, COL_BRANCH);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("BANK_ID, ACCOUNT_NAME, TD_ACCOUNT_NO, TD_ACC_TEMP, CIF_ID, DEPOSIT_AMOUNT, MATURITY_AMOUNT, EFFECTIVE_DATE, MATURITY_DATE, AVAILABLE_AMOUNT, END_DATE, INTEREST_RATE, LINKED_ACCOUNT, BRANCH", TABLE, COL_BANK_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("BANK_ID, ACCOUNT_NAME, TD_ACCOUNT_NO, TD_ACC_TEMP, CIF_ID, DEPOSIT_AMOUNT, MATURITY_AMOUNT, EFFECTIVE_DATE, MATURITY_DATE, AVAILABLE_AMOUNT, END_DATE, INTEREST_RATE, LINKED_ACCOUNT, BRANCH", TABLE, COL_BANK_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ACCOUNT_NAME, COL_TD_ACCOUNT_NO, COL_TD_ACC_TEMP, COL_CIF_ID, COL_DEPOSIT_AMOUNT, COL_MATURITY_AMOUNT, COL_EFFECTIVE_DATE, COL_MATURITY_DATE, COL_AVAILABLE_AMOUNT, COL_END_DATE, COL_INTEREST_RATE, COL_LINKED_ACCOUNT, COL_BRANCH, COL_BANK_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_BANK_ID);

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

    public int insert(Connection conn, TdMockData tdmockdata) throws SQLException {
        logger.debug("Inserting tdmockdata: {}", tdmockdata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setTdMockDataParams(ps, tdmockdata);
            ps.executeUpdate();
            return tdmockdata.getBankID();
        }
    }

    public int[] insertAll(Connection conn, List<TdMockData> tdmockdatas) throws SQLException {
        if (tdmockdatas == null || tdmockdatas.isEmpty())
            return new int[0];
        for (int i = 0; i < tdmockdatas.size(); i++) {
            if (tdmockdatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TdMockData>> batches = chunkList(tdmockdatas, batchSize);
        int[] totalResults = new int[tdmockdatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TdMockData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (TdMockData tdmockdata : batch) {
                        setTdMockDataParams(ps, tdmockdata);
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

    public TdMockData findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<TdMockData> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<TdMockData> list = new ArrayList<>();
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

    public boolean update(Connection conn, TdMockData tdmockdata) throws SQLException {
        if (tdmockdata.getBankID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setTdMockDataParams(ps, tdmockdata);
            ps.setInt(14, tdmockdata.getBankID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<TdMockData> tdmockdatas) throws SQLException {
        if (tdmockdatas == null || tdmockdatas.isEmpty())
            return new int[0];
        for (TdMockData tdmockdata : tdmockdatas) {
            if (tdmockdata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (tdmockdata.getBankID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TdMockData>> batches = chunkList(tdmockdatas, batchSize);
        int[] totalResults = new int[tdmockdatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TdMockData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (TdMockData tdmockdata : batch) {
                        setTdMockDataParams(ps, tdmockdata);
                        ps.setInt(14, tdmockdata.getBankID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_BANK_ID, placeholders);
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

    private void setTdMockDataParams(PreparedStatement ps, TdMockData tdmockdata) throws SQLException {
        Integer val1 = tdmockdata.getBankID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, tdmockdata.getAccountName());
        ps.setString(3, tdmockdata.getTdAccountNo());
        ps.setString(4, tdmockdata.getTdAccTemp());
        Integer val5 = tdmockdata.getCifID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        java.math.BigDecimal val6 = tdmockdata.getDepositAmount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = tdmockdata.getMaturityAmount();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.time.LocalDateTime val8 = tdmockdata.getEffectiveDate();
        if (val8 != null) {
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(val8));
        } else {
            ps.setNull(8, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val9 = tdmockdata.getMaturityDate();
        if (val9 != null) {
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(val9));
        } else {
            ps.setNull(9, Types.TIMESTAMP);
        }
        java.math.BigDecimal val10 = tdmockdata.getAvailableAmount();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.time.LocalDateTime val11 = tdmockdata.getEndDate();
        if (val11 != null) {
            ps.setTimestamp(11, java.sql.Timestamp.valueOf(val11));
        } else {
            ps.setNull(11, Types.TIMESTAMP);
        }
        java.math.BigDecimal val12 = tdmockdata.getInterestRate();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, tdmockdata.getLinkedAccount());
        ps.setString(14, tdmockdata.getBranch());
    }

    private TdMockData extract(ResultSet rs) throws SQLException {
        TdMockData tdmockdata = new TdMockData();
        Integer BANK_ID = rs.getObject(COL_BANK_ID, Integer.class);
        tdmockdata.setBankID(BANK_ID);
        tdmockdata.setAccountName(rs.getString(COL_ACCOUNT_NAME));
        tdmockdata.setTdAccountNo(rs.getString(COL_TD_ACCOUNT_NO));
        tdmockdata.setTdAccTemp(rs.getString(COL_TD_ACC_TEMP));
        Integer CIF_ID = rs.getObject(COL_CIF_ID, Integer.class);
        tdmockdata.setCifID(CIF_ID);
        java.math.BigDecimal DEPOSIT_AMOUNT = rs.getObject(COL_DEPOSIT_AMOUNT, java.math.BigDecimal.class);
        tdmockdata.setDepositAmount(DEPOSIT_AMOUNT);
        java.math.BigDecimal MATURITY_AMOUNT = rs.getObject(COL_MATURITY_AMOUNT, java.math.BigDecimal.class);
        tdmockdata.setMaturityAmount(MATURITY_AMOUNT);
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            tdmockdata.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            tdmockdata.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        java.math.BigDecimal AVAILABLE_AMOUNT = rs.getObject(COL_AVAILABLE_AMOUNT, java.math.BigDecimal.class);
        tdmockdata.setAvailableAmount(AVAILABLE_AMOUNT);
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            tdmockdata.setEndDate(END_DATE.toLocalDateTime());
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        tdmockdata.setInterestRate(INTEREST_RATE);
        tdmockdata.setLinkedAccount(rs.getString(COL_LINKED_ACCOUNT));
        tdmockdata.setBranch(rs.getString(COL_BRANCH));
        return tdmockdata;
    }
}
