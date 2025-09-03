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

public class JdbcTdAccountListDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTdAccountListDao.class);

    private static final String TABLE = "TD_ACCOUNT_LIST";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ACCOUNT_NAME = "ACCOUNT_NAME";

    private static final String COL_TD_ACCOUNT = "TD_ACCOUNT";

    private static final String COL_ACCOUNT_NO = "ACCOUNT_NO";

    private static final String COL_LIQ_DEPOSIT_AMOUNT = "LIQ_DEPOSIT_AMOUNT";

    private static final String COL_MATURITY_AMOUNT = "MATURITY_AMOUNT";

    private static final String COL_ACCOUNT_SCHEME_CODE = "ACCOUNT_SCHEME_CODE";

    private static final String COL_START_DATE = "START_DATE";

    private static final String COL_LIQ_MATURITY_DATE = "LIQ_MATURITY_DATE";

    private static final String COL_START_DATE_DISPLAY = "START_DATE_DISPLAY";

    private static final String COL_LIQ_MATURITY_DATE_DISPLAY = "LIQ_MATURITY_DATE_DISPLAY";

    private static final String COL_AVAILABLE_BALANCE = "AVAILABLE_BALANCE";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_FREEZEED_ACCOUNT = "FREEZEED_ACCOUNT";

    private static final String COL_LIEN_AMOUNT = "LIEN_AMOUNT";

    private static final String COL_LIQ_INTEREST_RATE = "LIQ_INTEREST_RATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_APPLICANT_PARTY, COL_ACCOUNT_NAME, COL_TD_ACCOUNT, COL_ACCOUNT_NO, COL_LIQ_DEPOSIT_AMOUNT, COL_MATURITY_AMOUNT, COL_ACCOUNT_SCHEME_CODE, COL_START_DATE, COL_LIQ_MATURITY_DATE, COL_START_DATE_DISPLAY, COL_LIQ_MATURITY_DATE_DISPLAY, COL_AVAILABLE_BALANCE, COL_END_DATE, COL_FREEZEED_ACCOUNT, COL_LIEN_AMOUNT, COL_LIQ_INTEREST_RATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("APPLICANT_PARTY, ACCOUNT_NAME, TD_ACCOUNT, ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE, START_DATE, LIQ_MATURITY_DATE, START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE, END_DATE, FREEZEED_ACCOUNT, LIEN_AMOUNT, LIQ_INTEREST_RATE", TABLE, COL_APPLICANT_PARTY);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("APPLICANT_PARTY, ACCOUNT_NAME, TD_ACCOUNT, ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE, START_DATE, LIQ_MATURITY_DATE, START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE, END_DATE, FREEZEED_ACCOUNT, LIEN_AMOUNT, LIQ_INTEREST_RATE", TABLE, COL_APPLICANT_PARTY);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ACCOUNT_NAME, COL_TD_ACCOUNT, COL_ACCOUNT_NO, COL_LIQ_DEPOSIT_AMOUNT, COL_MATURITY_AMOUNT, COL_ACCOUNT_SCHEME_CODE, COL_START_DATE, COL_LIQ_MATURITY_DATE, COL_START_DATE_DISPLAY, COL_LIQ_MATURITY_DATE_DISPLAY, COL_AVAILABLE_BALANCE, COL_END_DATE, COL_FREEZEED_ACCOUNT, COL_LIEN_AMOUNT, COL_LIQ_INTEREST_RATE, COL_APPLICANT_PARTY);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_APPLICANT_PARTY);

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

    public String insert(Connection conn, TdAccountList tdaccountlist) throws SQLException {
        logger.debug("Inserting tdaccountlist: {}", tdaccountlist);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setTdAccountListParams(ps, tdaccountlist);
            ps.executeUpdate();
            return tdaccountlist.getApplicantParty();
        }
    }

    public int[] insertAll(Connection conn, List<TdAccountList> tdaccountlists) throws SQLException {
        if (tdaccountlists == null || tdaccountlists.isEmpty())
            return new int[0];
        for (int i = 0; i < tdaccountlists.size(); i++) {
            if (tdaccountlists.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TdAccountList>> batches = chunkList(tdaccountlists, batchSize);
        int[] totalResults = new int[tdaccountlists.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TdAccountList> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (TdAccountList tdaccountlist : batch) {
                        setTdAccountListParams(ps, tdaccountlist);
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

    public TdAccountList findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<TdAccountList> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<TdAccountList> list = new ArrayList<>();
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

    public boolean update(Connection conn, TdAccountList tdaccountlist) throws SQLException {
        if (tdaccountlist.getApplicantParty() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setTdAccountListParams(ps, tdaccountlist);
            ps.setString(16, tdaccountlist.getApplicantParty());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<TdAccountList> tdaccountlists) throws SQLException {
        if (tdaccountlists == null || tdaccountlists.isEmpty())
            return new int[0];
        for (TdAccountList tdaccountlist : tdaccountlists) {
            if (tdaccountlist == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (tdaccountlist.getApplicantParty() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TdAccountList>> batches = chunkList(tdaccountlists, batchSize);
        int[] totalResults = new int[tdaccountlists.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TdAccountList> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (TdAccountList tdaccountlist : batch) {
                        setTdAccountListParams(ps, tdaccountlist);
                        ps.setString(16, tdaccountlist.getApplicantParty());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_APPLICANT_PARTY, placeholders);
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

    private void setTdAccountListParams(PreparedStatement ps, TdAccountList tdaccountlist) throws SQLException {
        ps.setString(1, tdaccountlist.getApplicantParty());
        ps.setString(2, tdaccountlist.getAccountName());
        ps.setString(3, tdaccountlist.getTdAccount());
        ps.setString(4, tdaccountlist.getAccountNo());
        java.math.BigDecimal val5 = tdaccountlist.getLiqDepositAmount();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = tdaccountlist.getMaturityAmount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, tdaccountlist.getAccountSchemeCode());
        java.time.LocalDateTime val8 = tdaccountlist.getStartDate();
        if (val8 != null) {
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(val8));
        } else {
            ps.setNull(8, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val9 = tdaccountlist.getLiqMaturityDate();
        if (val9 != null) {
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(val9));
        } else {
            ps.setNull(9, Types.TIMESTAMP);
        }
        ps.setString(10, tdaccountlist.getStartDateDisplay());
        ps.setString(11, tdaccountlist.getLiqMaturityDateDisplay());
        java.math.BigDecimal val12 = tdaccountlist.getAvailableBalance();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        java.time.LocalDateTime val13 = tdaccountlist.getEndDate();
        if (val13 != null) {
            ps.setTimestamp(13, java.sql.Timestamp.valueOf(val13));
        } else {
            ps.setNull(13, Types.TIMESTAMP);
        }
        ps.setString(14, tdaccountlist.getFreezeedAccount());
        java.math.BigDecimal val15 = tdaccountlist.getLienAmount();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = tdaccountlist.getLiqInterestRate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
    }

    private TdAccountList extract(ResultSet rs) throws SQLException {
        TdAccountList tdaccountlist = new TdAccountList();
        tdaccountlist.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        tdaccountlist.setAccountName(rs.getString(COL_ACCOUNT_NAME));
        tdaccountlist.setTdAccount(rs.getString(COL_TD_ACCOUNT));
        tdaccountlist.setAccountNo(rs.getString(COL_ACCOUNT_NO));
        java.math.BigDecimal LIQ_DEPOSIT_AMOUNT = rs.getObject(COL_LIQ_DEPOSIT_AMOUNT, java.math.BigDecimal.class);
        tdaccountlist.setLiqDepositAmount(LIQ_DEPOSIT_AMOUNT);
        java.math.BigDecimal MATURITY_AMOUNT = rs.getObject(COL_MATURITY_AMOUNT, java.math.BigDecimal.class);
        tdaccountlist.setMaturityAmount(MATURITY_AMOUNT);
        tdaccountlist.setAccountSchemeCode(rs.getString(COL_ACCOUNT_SCHEME_CODE));
        Timestamp START_DATE = rs.getTimestamp(COL_START_DATE);
        if (START_DATE != null)
            tdaccountlist.setStartDate(START_DATE.toLocalDateTime());
        Timestamp LIQ_MATURITY_DATE = rs.getTimestamp(COL_LIQ_MATURITY_DATE);
        if (LIQ_MATURITY_DATE != null)
            tdaccountlist.setLiqMaturityDate(LIQ_MATURITY_DATE.toLocalDateTime());
        tdaccountlist.setStartDateDisplay(rs.getString(COL_START_DATE_DISPLAY));
        tdaccountlist.setLiqMaturityDateDisplay(rs.getString(COL_LIQ_MATURITY_DATE_DISPLAY));
        java.math.BigDecimal AVAILABLE_BALANCE = rs.getObject(COL_AVAILABLE_BALANCE, java.math.BigDecimal.class);
        tdaccountlist.setAvailableBalance(AVAILABLE_BALANCE);
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            tdaccountlist.setEndDate(END_DATE.toLocalDateTime());
        tdaccountlist.setFreezeedAccount(rs.getString(COL_FREEZEED_ACCOUNT));
        java.math.BigDecimal LIEN_AMOUNT = rs.getObject(COL_LIEN_AMOUNT, java.math.BigDecimal.class);
        tdaccountlist.setLienAmount(LIEN_AMOUNT);
        java.math.BigDecimal LIQ_INTEREST_RATE = rs.getObject(COL_LIQ_INTEREST_RATE, java.math.BigDecimal.class);
        tdaccountlist.setLiqInterestRate(LIQ_INTEREST_RATE);
        return tdaccountlist;
    }
}
