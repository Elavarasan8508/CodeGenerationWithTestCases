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

public class JdbcQrtzJobDetailsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcQrtzJobDetailsDao.class);

    private static final String TABLE = "QRTZ_JOB_DETAILS";

    private static final String COL_SCHED_NAME = "SCHED_NAME";

    private static final String COL_JOB_NAME = "JOB_NAME";

    private static final String COL_JOB_GROUP = "JOB_GROUP";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_JOB_CLASS_NAME = "JOB_CLASS_NAME";

    private static final String COL_IS_DURABLE = "IS_DURABLE";

    private static final String COL_IS_NONCONCURRENT = "IS_NONCONCURRENT";

    private static final String COL_IS_UPDATE_DATA = "IS_UPDATE_DATA";

    private static final String COL_REQUESTS_RECOVERY = "REQUESTS_RECOVERY";

    private static final String COL_JOB_DATA = "JOB_DATA";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SCHED_NAME, COL_JOB_NAME, COL_JOB_GROUP, COL_DESCRIPTION, COL_JOB_CLASS_NAME, COL_IS_DURABLE, COL_IS_NONCONCURRENT, COL_IS_UPDATE_DATA, COL_REQUESTS_RECOVERY, COL_JOB_DATA);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA", TABLE, COL_SCHED_NAME);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA", TABLE, COL_SCHED_NAME);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_JOB_NAME, COL_JOB_GROUP, COL_DESCRIPTION, COL_JOB_CLASS_NAME, COL_IS_DURABLE, COL_IS_NONCONCURRENT, COL_IS_UPDATE_DATA, COL_REQUESTS_RECOVERY, COL_JOB_DATA, COL_SCHED_NAME);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_SCHED_NAME);

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

    public String insert(Connection conn, QrtzJobDetails qrtzjobdetails) throws SQLException {
        logger.debug("Inserting qrtzjobdetails: {}", qrtzjobdetails);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setQrtzJobDetailsParams(ps, qrtzjobdetails);
            ps.executeUpdate();
            return qrtzjobdetails.getSchedName();
        }
    }

    public int[] insertAll(Connection conn, List<QrtzJobDetails> qrtzjobdetailss) throws SQLException {
        if (qrtzjobdetailss == null || qrtzjobdetailss.isEmpty())
            return new int[0];
        for (int i = 0; i < qrtzjobdetailss.size(); i++) {
            if (qrtzjobdetailss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzJobDetails>> batches = chunkList(qrtzjobdetailss, batchSize);
        int[] totalResults = new int[qrtzjobdetailss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzJobDetails> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (QrtzJobDetails qrtzjobdetails : batch) {
                        setQrtzJobDetailsParams(ps, qrtzjobdetails);
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

    public QrtzJobDetails findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<QrtzJobDetails> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<QrtzJobDetails> list = new ArrayList<>();
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

    public boolean update(Connection conn, QrtzJobDetails qrtzjobdetails) throws SQLException {
        if (qrtzjobdetails.getSchedName() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setQrtzJobDetailsParams(ps, qrtzjobdetails);
            ps.setString(10, qrtzjobdetails.getSchedName());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<QrtzJobDetails> qrtzjobdetailss) throws SQLException {
        if (qrtzjobdetailss == null || qrtzjobdetailss.isEmpty())
            return new int[0];
        for (QrtzJobDetails qrtzjobdetails : qrtzjobdetailss) {
            if (qrtzjobdetails == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (qrtzjobdetails.getSchedName() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<QrtzJobDetails>> batches = chunkList(qrtzjobdetailss, batchSize);
        int[] totalResults = new int[qrtzjobdetailss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<QrtzJobDetails> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (QrtzJobDetails qrtzjobdetails : batch) {
                        setQrtzJobDetailsParams(ps, qrtzjobdetails);
                        ps.setString(10, qrtzjobdetails.getSchedName());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_SCHED_NAME, placeholders);
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

    private void setQrtzJobDetailsParams(PreparedStatement ps, QrtzJobDetails qrtzjobdetails) throws SQLException {
        ps.setString(1, qrtzjobdetails.getSchedName());
        ps.setString(2, qrtzjobdetails.getJobName());
        ps.setString(3, qrtzjobdetails.getJobGroup());
        ps.setString(4, qrtzjobdetails.getDescription());
        ps.setString(5, qrtzjobdetails.getJobClassName());
        ps.setString(6, qrtzjobdetails.getIsDurable());
        ps.setString(7, qrtzjobdetails.getIsNonconcurrent());
        ps.setString(8, qrtzjobdetails.getIsUpdateData());
        ps.setString(9, qrtzjobdetails.getRequestsRecovery());
        ps.setBytes(10, qrtzjobdetails.getJobData());
    }

    private QrtzJobDetails extract(ResultSet rs) throws SQLException {
        QrtzJobDetails qrtzjobdetails = new QrtzJobDetails();
        qrtzjobdetails.setSchedName(rs.getString(COL_SCHED_NAME));
        qrtzjobdetails.setJobName(rs.getString(COL_JOB_NAME));
        qrtzjobdetails.setJobGroup(rs.getString(COL_JOB_GROUP));
        qrtzjobdetails.setDescription(rs.getString(COL_DESCRIPTION));
        qrtzjobdetails.setJobClassName(rs.getString(COL_JOB_CLASS_NAME));
        qrtzjobdetails.setIsDurable(rs.getString(COL_IS_DURABLE));
        qrtzjobdetails.setIsNonconcurrent(rs.getString(COL_IS_NONCONCURRENT));
        qrtzjobdetails.setIsUpdateData(rs.getString(COL_IS_UPDATE_DATA));
        qrtzjobdetails.setRequestsRecovery(rs.getString(COL_REQUESTS_RECOVERY));
        qrtzjobdetails.setJobData(rs.getBytes(COL_JOB_DATA));
        return qrtzjobdetails;
    }
}
