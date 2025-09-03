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

public class JdbcExtifsccDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcExtifsccDao.class);

    private static final String TABLE = "EXTIFSCC";

    private static final String COL_IFSCSN = "IFSCSN";

    private static final String COL_IFSC = "IFSC";

    private static final String COL_BANK = "BANK";

    private static final String COL_BRANCH = "BRANCH";

    private static final String COL_BRAADD = "BRAADD";

    private static final String COL_CITY = "CITY";

    private static final String COL_STATE = "STATE";

    private static final String COL_RTGS = "RTGS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_IFSCSN, COL_IFSC, COL_BANK, COL_BRANCH, COL_BRAADD, COL_CITY, COL_STATE, COL_RTGS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("IFSCSN, IFSC, BANK, BRANCH, BRAADD, CITY, STATE, RTGS", TABLE, COL_IFSCSN);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("IFSCSN, IFSC, BANK, BRANCH, BRAADD, CITY, STATE, RTGS", TABLE, COL_IFSCSN);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_IFSC, COL_BANK, COL_BRANCH, COL_BRAADD, COL_CITY, COL_STATE, COL_RTGS, COL_IFSCSN);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_IFSCSN);

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

    public String insert(Connection conn, Extifscc extifscc) throws SQLException {
        logger.debug("Inserting extifscc: {}", extifscc);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setExtifsccParams(ps, extifscc);
            ps.executeUpdate();
            return extifscc.getIfscsn();
        }
    }

    public int[] insertAll(Connection conn, List<Extifscc> extifsccs) throws SQLException {
        if (extifsccs == null || extifsccs.isEmpty())
            return new int[0];
        for (int i = 0; i < extifsccs.size(); i++) {
            if (extifsccs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Extifscc>> batches = chunkList(extifsccs, batchSize);
        int[] totalResults = new int[extifsccs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Extifscc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Extifscc extifscc : batch) {
                        setExtifsccParams(ps, extifscc);
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

    public Extifscc findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Extifscc> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Extifscc> list = new ArrayList<>();
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

    public boolean update(Connection conn, Extifscc extifscc) throws SQLException {
        if (extifscc.getIfscsn() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setExtifsccParams(ps, extifscc);
            ps.setString(8, extifscc.getIfscsn());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Extifscc> extifsccs) throws SQLException {
        if (extifsccs == null || extifsccs.isEmpty())
            return new int[0];
        for (Extifscc extifscc : extifsccs) {
            if (extifscc == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (extifscc.getIfscsn() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Extifscc>> batches = chunkList(extifsccs, batchSize);
        int[] totalResults = new int[extifsccs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Extifscc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Extifscc extifscc : batch) {
                        setExtifsccParams(ps, extifscc);
                        ps.setString(8, extifscc.getIfscsn());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_IFSCSN, placeholders);
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

    private void setExtifsccParams(PreparedStatement ps, Extifscc extifscc) throws SQLException {
        ps.setString(1, extifscc.getIfscsn());
        ps.setString(2, extifscc.getIfsc());
        ps.setString(3, extifscc.getBank());
        ps.setString(4, extifscc.getBranch());
        ps.setString(5, extifscc.getBraadd());
        ps.setString(6, extifscc.getCity());
        ps.setString(7, extifscc.getState());
        ps.setString(8, extifscc.getRtgs());
    }

    private Extifscc extract(ResultSet rs) throws SQLException {
        Extifscc extifscc = new Extifscc();
        extifscc.setIfscsn(rs.getString(COL_IFSCSN));
        extifscc.setIfsc(rs.getString(COL_IFSC));
        extifscc.setBank(rs.getString(COL_BANK));
        extifscc.setBranch(rs.getString(COL_BRANCH));
        extifscc.setBraadd(rs.getString(COL_BRAADD));
        extifscc.setCity(rs.getString(COL_CITY));
        extifscc.setState(rs.getString(COL_STATE));
        extifscc.setRtgs(rs.getString(COL_RTGS));
        return extifscc;
    }
}
