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

public class JdbcFgTdAccountMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdAccountMasterDao.class);

    private static final String TABLE = "FG_TD_ACCOUNT_MASTER";

    private static final String COL_DEBIT_ACC_NUM = "DEBIT_ACC_NUM";

    private static final String COL_ACC_USER_NAME = "ACC_USER_NAME";

    private static final String COL_USER_TYPE = "USER_TYPE";

    private static final String COL_AVAIL_BALANCE = "AVAIL_BALANCE";

    private static final String COL_ACCT_TYPE = "ACCT_TYPE";

    private static final String COL_ACCT_NAME = "ACCT_NAME";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_CCY = "CCY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_DEBIT_ACC_NUM, COL_ACC_USER_NAME, COL_USER_TYPE, COL_AVAIL_BALANCE, COL_ACCT_TYPE, COL_ACCT_NAME, COL_SCHEME_CODE, COL_CCY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("DEBIT_ACC_NUM, ACC_USER_NAME, USER_TYPE, AVAIL_BALANCE, ACCT_TYPE, ACCT_NAME, SCHEME_CODE, CCY", TABLE, COL_DEBIT_ACC_NUM);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("DEBIT_ACC_NUM, ACC_USER_NAME, USER_TYPE, AVAIL_BALANCE, ACCT_TYPE, ACCT_NAME, SCHEME_CODE, CCY", TABLE, COL_DEBIT_ACC_NUM);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ACC_USER_NAME, COL_USER_TYPE, COL_AVAIL_BALANCE, COL_ACCT_TYPE, COL_ACCT_NAME, COL_SCHEME_CODE, COL_CCY, COL_DEBIT_ACC_NUM);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_DEBIT_ACC_NUM);

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

    public String insert(Connection conn, FgTdAccountMaster fgtdaccountmaster) throws SQLException {
        logger.debug("Inserting fgtdaccountmaster: {}", fgtdaccountmaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdAccountMasterParams(ps, fgtdaccountmaster);
            ps.executeUpdate();
            return fgtdaccountmaster.getDebitAccNum();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdAccountMaster> fgtdaccountmasters) throws SQLException {
        if (fgtdaccountmasters == null || fgtdaccountmasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdaccountmasters.size(); i++) {
            if (fgtdaccountmasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdAccountMaster>> batches = chunkList(fgtdaccountmasters, batchSize);
        int[] totalResults = new int[fgtdaccountmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdAccountMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdAccountMaster fgtdaccountmaster : batch) {
                        setFgTdAccountMasterParams(ps, fgtdaccountmaster);
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

    public FgTdAccountMaster findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdAccountMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdAccountMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdAccountMaster fgtdaccountmaster) throws SQLException {
        if (fgtdaccountmaster.getDebitAccNum() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdAccountMasterParams(ps, fgtdaccountmaster);
            ps.setString(8, fgtdaccountmaster.getDebitAccNum());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdAccountMaster> fgtdaccountmasters) throws SQLException {
        if (fgtdaccountmasters == null || fgtdaccountmasters.isEmpty())
            return new int[0];
        for (FgTdAccountMaster fgtdaccountmaster : fgtdaccountmasters) {
            if (fgtdaccountmaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdaccountmaster.getDebitAccNum() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdAccountMaster>> batches = chunkList(fgtdaccountmasters, batchSize);
        int[] totalResults = new int[fgtdaccountmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdAccountMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdAccountMaster fgtdaccountmaster : batch) {
                        setFgTdAccountMasterParams(ps, fgtdaccountmaster);
                        ps.setString(8, fgtdaccountmaster.getDebitAccNum());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_DEBIT_ACC_NUM, placeholders);
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

    private void setFgTdAccountMasterParams(PreparedStatement ps, FgTdAccountMaster fgtdaccountmaster) throws SQLException {
        ps.setString(1, fgtdaccountmaster.getDebitAccNum());
        ps.setString(2, fgtdaccountmaster.getAccUserName());
        ps.setString(3, fgtdaccountmaster.getUserType());
        java.math.BigDecimal val4 = fgtdaccountmaster.getAvailBalance();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        ps.setString(5, fgtdaccountmaster.getAcctType());
        ps.setString(6, fgtdaccountmaster.getAcctName());
        ps.setString(7, fgtdaccountmaster.getSchemeCode());
        ps.setString(8, fgtdaccountmaster.getCcy());
    }

    private FgTdAccountMaster extract(ResultSet rs) throws SQLException {
        FgTdAccountMaster fgtdaccountmaster = new FgTdAccountMaster();
        fgtdaccountmaster.setDebitAccNum(rs.getString(COL_DEBIT_ACC_NUM));
        fgtdaccountmaster.setAccUserName(rs.getString(COL_ACC_USER_NAME));
        fgtdaccountmaster.setUserType(rs.getString(COL_USER_TYPE));
        java.math.BigDecimal AVAIL_BALANCE = rs.getObject(COL_AVAIL_BALANCE, java.math.BigDecimal.class);
        fgtdaccountmaster.setAvailBalance(AVAIL_BALANCE);
        fgtdaccountmaster.setAcctType(rs.getString(COL_ACCT_TYPE));
        fgtdaccountmaster.setAcctName(rs.getString(COL_ACCT_NAME));
        fgtdaccountmaster.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        fgtdaccountmaster.setCcy(rs.getString(COL_CCY));
        return fgtdaccountmaster;
    }
}
