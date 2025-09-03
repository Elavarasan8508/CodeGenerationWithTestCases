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

public class JdbcActiveTdDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcActiveTdDao.class);

    private static final String TABLE = "ACTIVE_TD";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_AVAILABLE_AMOUNT = "AVAILABLE_AMOUNT";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_ACCOUNT_NAME = "ACCOUNT_NAME";

    private static final String COL_MATURITY_AMOUNT = "MATURITY_AMOUNT";

    private static final String COL_TD_ACCOUNT_NO = "TD_ACCOUNT_NO";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_LINKED_ACCOUNT = "LINKED_ACCOUNT";

    private static final String COL_RN = "RN";

    private static final String COL_DEPOSIT_AMOUNT = "DEPOSIT_AMOUNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_EFFECTIVE_DATE, COL_AVAILABLE_AMOUNT, COL_END_DATE, COL_MATURITY_DATE, COL_ACCOUNT_NAME, COL_MATURITY_AMOUNT, COL_TD_ACCOUNT_NO, COL_INTEREST_RATE, COL_LINKED_ACCOUNT, COL_RN, COL_DEPOSIT_AMOUNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("EFFECTIVE_DATE, AVAILABLE_AMOUNT, END_DATE, MATURITY_DATE, ACCOUNT_NAME, MATURITY_AMOUNT, TD_ACCOUNT_NO, INTEREST_RATE, LINKED_ACCOUNT, RN, DEPOSIT_AMOUNT", TABLE, COL_EFFECTIVE_DATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("EFFECTIVE_DATE, AVAILABLE_AMOUNT, END_DATE, MATURITY_DATE, ACCOUNT_NAME, MATURITY_AMOUNT, TD_ACCOUNT_NO, INTEREST_RATE, LINKED_ACCOUNT, RN, DEPOSIT_AMOUNT", TABLE, COL_EFFECTIVE_DATE);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AVAILABLE_AMOUNT, COL_END_DATE, COL_MATURITY_DATE, COL_ACCOUNT_NAME, COL_MATURITY_AMOUNT, COL_TD_ACCOUNT_NO, COL_INTEREST_RATE, COL_LINKED_ACCOUNT, COL_RN, COL_DEPOSIT_AMOUNT, COL_EFFECTIVE_DATE);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_EFFECTIVE_DATE);

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

    public java.time.LocalDateTime insert(Connection conn, ActiveTd activetd) throws SQLException {
        logger.debug("Inserting activetd: {}", activetd);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setActiveTdParams(ps, activetd);
            ps.executeUpdate();
            return activetd.getEffectiveDate();
        }
    }

    public int[] insertAll(Connection conn, List<ActiveTd> activetds) throws SQLException {
        if (activetds == null || activetds.isEmpty())
            return new int[0];
        for (int i = 0; i < activetds.size(); i++) {
            if (activetds.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ActiveTd>> batches = chunkList(activetds, batchSize);
        int[] totalResults = new int[activetds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ActiveTd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ActiveTd activetd : batch) {
                        setActiveTdParams(ps, activetd);
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

    public ActiveTd findById(Connection conn, java.time.LocalDateTime id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setTimestamp(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ActiveTd> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ActiveTd> list = new ArrayList<>();
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

    public boolean update(Connection conn, ActiveTd activetd) throws SQLException {
        if (activetd.getEffectiveDate() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setActiveTdParams(ps, activetd);
            ps.setTimestamp(11, activetd.getEffectiveDate());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ActiveTd> activetds) throws SQLException {
        if (activetds == null || activetds.isEmpty())
            return new int[0];
        for (ActiveTd activetd : activetds) {
            if (activetd == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (activetd.getEffectiveDate() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ActiveTd>> batches = chunkList(activetds, batchSize);
        int[] totalResults = new int[activetds.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ActiveTd> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ActiveTd activetd : batch) {
                        setActiveTdParams(ps, activetd);
                        ps.setTimestamp(11, activetd.getEffectiveDate());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_EFFECTIVE_DATE, placeholders);
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

    private void setActiveTdParams(PreparedStatement ps, ActiveTd activetd) throws SQLException {
        java.time.LocalDateTime val1 = activetd.getEffectiveDate();
        if (val1 != null) {
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(val1));
        } else {
            ps.setNull(1, Types.TIMESTAMP);
        }
        java.math.BigDecimal val2 = activetd.getAvailableAmount();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        java.time.LocalDateTime val3 = activetd.getEndDate();
        if (val3 != null) {
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(val3));
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val4 = activetd.getMaturityDate();
        if (val4 != null) {
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(val4));
        } else {
            ps.setNull(4, Types.TIMESTAMP);
        }
        ps.setString(5, activetd.getAccountName());
        java.math.BigDecimal val6 = activetd.getMaturityAmount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, activetd.getTdAccountNo());
        java.math.BigDecimal val8 = activetd.getInterestRate();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, activetd.getLinkedAccount());
        ps.setString(10, activetd.getRn());
        java.math.BigDecimal val11 = activetd.getDepositAmount();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
    }

    private ActiveTd extract(ResultSet rs) throws SQLException {
        ActiveTd activetd = new ActiveTd();
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            activetd.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        java.math.BigDecimal AVAILABLE_AMOUNT = rs.getObject(COL_AVAILABLE_AMOUNT, java.math.BigDecimal.class);
        activetd.setAvailableAmount(AVAILABLE_AMOUNT);
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            activetd.setEndDate(END_DATE.toLocalDateTime());
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            activetd.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        activetd.setAccountName(rs.getString(COL_ACCOUNT_NAME));
        java.math.BigDecimal MATURITY_AMOUNT = rs.getObject(COL_MATURITY_AMOUNT, java.math.BigDecimal.class);
        activetd.setMaturityAmount(MATURITY_AMOUNT);
        activetd.setTdAccountNo(rs.getString(COL_TD_ACCOUNT_NO));
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        activetd.setInterestRate(INTEREST_RATE);
        activetd.setLinkedAccount(rs.getString(COL_LINKED_ACCOUNT));
        activetd.setRn(rs.getString(COL_RN));
        java.math.BigDecimal DEPOSIT_AMOUNT = rs.getObject(COL_DEPOSIT_AMOUNT, java.math.BigDecimal.class);
        activetd.setDepositAmount(DEPOSIT_AMOUNT);
        return activetd;
    }
}
