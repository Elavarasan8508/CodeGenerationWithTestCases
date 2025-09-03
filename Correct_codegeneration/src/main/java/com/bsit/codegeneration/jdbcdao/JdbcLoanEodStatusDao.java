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

public class JdbcLoanEodStatusDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLoanEodStatusDao.class);

    private static final String TABLE = "LOAN_EOD_STATUS";

    private static final String COL_JOB_ID = "JOB_ID";

    private static final String COL_JOB_NAME = "JOB_NAME";

    private static final String COL_JOB_STATUS = "JOB_STATUS";

    private static final String COL_JOB_EXIT_CODE = "JOB_EXIT_CODE";

    private static final String COL_EOD_START_DATE = "EOD_START_DATE";

    private static final String COL_EOD_END_DATE = "EOD_END_DATE";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_STATUS = "STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_JOB_ID, COL_JOB_NAME, COL_JOB_STATUS, COL_JOB_EXIT_CODE, COL_EOD_START_DATE, COL_EOD_END_DATE, COL_REMARKS, COL_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("JOB_ID, JOB_NAME, JOB_STATUS, JOB_EXIT_CODE, EOD_START_DATE, EOD_END_DATE, REMARKS, STATUS", TABLE, COL_JOB_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("JOB_ID, JOB_NAME, JOB_STATUS, JOB_EXIT_CODE, EOD_START_DATE, EOD_END_DATE, REMARKS, STATUS", TABLE, COL_JOB_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_JOB_NAME, COL_JOB_STATUS, COL_JOB_EXIT_CODE, COL_EOD_START_DATE, COL_EOD_END_DATE, COL_REMARKS, COL_STATUS, COL_JOB_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_JOB_ID);

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

    public int insert(Connection conn, LoanEodStatus loaneodstatus) throws SQLException {
        logger.debug("Inserting loaneodstatus: {}", loaneodstatus);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLoanEodStatusParams(ps, loaneodstatus);
            ps.executeUpdate();
            return loaneodstatus.getJobID();
        }
    }

    public int[] insertAll(Connection conn, List<LoanEodStatus> loaneodstatuss) throws SQLException {
        if (loaneodstatuss == null || loaneodstatuss.isEmpty())
            return new int[0];
        for (int i = 0; i < loaneodstatuss.size(); i++) {
            if (loaneodstatuss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LoanEodStatus>> batches = chunkList(loaneodstatuss, batchSize);
        int[] totalResults = new int[loaneodstatuss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LoanEodStatus> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (LoanEodStatus loaneodstatus : batch) {
                        setLoanEodStatusParams(ps, loaneodstatus);
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

    public LoanEodStatus findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LoanEodStatus> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<LoanEodStatus> list = new ArrayList<>();
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

    public boolean update(Connection conn, LoanEodStatus loaneodstatus) throws SQLException {
        if (loaneodstatus.getJobID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLoanEodStatusParams(ps, loaneodstatus);
            ps.setInt(8, loaneodstatus.getJobID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<LoanEodStatus> loaneodstatuss) throws SQLException {
        if (loaneodstatuss == null || loaneodstatuss.isEmpty())
            return new int[0];
        for (LoanEodStatus loaneodstatus : loaneodstatuss) {
            if (loaneodstatus == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (loaneodstatus.getJobID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<LoanEodStatus>> batches = chunkList(loaneodstatuss, batchSize);
        int[] totalResults = new int[loaneodstatuss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<LoanEodStatus> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (LoanEodStatus loaneodstatus : batch) {
                        setLoanEodStatusParams(ps, loaneodstatus);
                        ps.setInt(8, loaneodstatus.getJobID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_JOB_ID, placeholders);
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

    private void setLoanEodStatusParams(PreparedStatement ps, LoanEodStatus loaneodstatus) throws SQLException {
        Integer val1 = loaneodstatus.getJobID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, loaneodstatus.getJobName());
        ps.setString(3, loaneodstatus.getJobStatus());
        ps.setString(4, loaneodstatus.getJobExitCode());
        ps.setString(5, loaneodstatus.getEodStartDate());
        ps.setString(6, loaneodstatus.getEodEndDate());
        ps.setString(7, loaneodstatus.getRemarks());
        ps.setString(8, loaneodstatus.getStatus());
    }

    private LoanEodStatus extract(ResultSet rs) throws SQLException {
        LoanEodStatus loaneodstatus = new LoanEodStatus();
        Integer JOB_ID = rs.getObject(COL_JOB_ID, Integer.class);
        loaneodstatus.setJobID(JOB_ID);
        loaneodstatus.setJobName(rs.getString(COL_JOB_NAME));
        loaneodstatus.setJobStatus(rs.getString(COL_JOB_STATUS));
        loaneodstatus.setJobExitCode(rs.getString(COL_JOB_EXIT_CODE));
        loaneodstatus.setEodStartDate(rs.getString(COL_EOD_START_DATE));
        loaneodstatus.setEodEndDate(rs.getString(COL_EOD_END_DATE));
        loaneodstatus.setRemarks(rs.getString(COL_REMARKS));
        loaneodstatus.setStatus(rs.getString(COL_STATUS));
        return loaneodstatus;
    }
}
