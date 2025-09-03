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

public class JdbcD4pfDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcD4pfDao.class);

    private static final String TABLE = "D4PF";

    private static final String COL_D4BRANCH = "D4BRANCH";

    private static final String COL_D4BRR = "D4BRR";

    private static final String COL_D4DFLG = "D4DFLG";

    private static final String COL_D4DTEH = "D4DTEH";

    private static final String COL_D4DTE = "D4DTE";

    private static final String COL_D4BRAR = "D4BRAR";

    private static final String COL_D4DLM = "D4DLM";

    private static final String COL_MNT_IN_BO = "MNT_IN_BO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_D4BRANCH, COL_D4BRR, COL_D4DFLG, COL_D4DTEH, COL_D4DTE, COL_D4BRAR, COL_D4DLM, COL_MNT_IN_BO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("D4BRANCH, D4BRR, D4DFLG, D4DTEH, D4DTE, D4BRAR, D4DLM, MNT_IN_BO", TABLE, COL_D4BRANCH);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("D4BRANCH, D4BRR, D4DFLG, D4DTEH, D4DTE, D4BRAR, D4DLM, MNT_IN_BO", TABLE, COL_D4BRANCH);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_D4BRR, COL_D4DFLG, COL_D4DTEH, COL_D4DTE, COL_D4BRAR, COL_D4DLM, COL_MNT_IN_BO, COL_D4BRANCH);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_D4BRANCH);

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

    public String insert(Connection conn, D4pf d4pf) throws SQLException {
        logger.debug("Inserting d4pf: {}", d4pf);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setD4pfParams(ps, d4pf);
            ps.executeUpdate();
            return d4pf.getD4branch();
        }
    }

    public int[] insertAll(Connection conn, List<D4pf> d4pfs) throws SQLException {
        if (d4pfs == null || d4pfs.isEmpty())
            return new int[0];
        for (int i = 0; i < d4pfs.size(); i++) {
            if (d4pfs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<D4pf>> batches = chunkList(d4pfs, batchSize);
        int[] totalResults = new int[d4pfs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<D4pf> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (D4pf d4pf : batch) {
                        setD4pfParams(ps, d4pf);
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

    public D4pf findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<D4pf> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<D4pf> list = new ArrayList<>();
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

    public boolean update(Connection conn, D4pf d4pf) throws SQLException {
        if (d4pf.getD4branch() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setD4pfParams(ps, d4pf);
            ps.setString(8, d4pf.getD4branch());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<D4pf> d4pfs) throws SQLException {
        if (d4pfs == null || d4pfs.isEmpty())
            return new int[0];
        for (D4pf d4pf : d4pfs) {
            if (d4pf == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (d4pf.getD4branch() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<D4pf>> batches = chunkList(d4pfs, batchSize);
        int[] totalResults = new int[d4pfs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<D4pf> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (D4pf d4pf : batch) {
                        setD4pfParams(ps, d4pf);
                        ps.setString(8, d4pf.getD4branch());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_D4BRANCH, placeholders);
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

    private void setD4pfParams(PreparedStatement ps, D4pf d4pf) throws SQLException {
        ps.setString(1, d4pf.getD4branch());
        ps.setString(2, d4pf.getD4brr());
        ps.setString(3, d4pf.getD4dflg());
        java.math.BigDecimal val4 = d4pf.getD4dteh();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = d4pf.getD4dte();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        java.math.BigDecimal val6 = d4pf.getD4brar();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        java.math.BigDecimal val7 = d4pf.getD4dlm();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, d4pf.getMntInBo());
    }

    private D4pf extract(ResultSet rs) throws SQLException {
        D4pf d4pf = new D4pf();
        d4pf.setD4branch(rs.getString(COL_D4BRANCH));
        d4pf.setD4brr(rs.getString(COL_D4BRR));
        d4pf.setD4dflg(rs.getString(COL_D4DFLG));
        java.math.BigDecimal D4DTEH = rs.getObject(COL_D4DTEH, java.math.BigDecimal.class);
        d4pf.setD4dteh(D4DTEH);
        java.math.BigDecimal D4DTE = rs.getObject(COL_D4DTE, java.math.BigDecimal.class);
        d4pf.setD4dte(D4DTE);
        java.math.BigDecimal D4BRAR = rs.getObject(COL_D4BRAR, java.math.BigDecimal.class);
        d4pf.setD4brar(D4BRAR);
        java.math.BigDecimal D4DLM = rs.getObject(COL_D4DLM, java.math.BigDecimal.class);
        d4pf.setD4dlm(D4DLM);
        d4pf.setMntInBo(rs.getString(COL_MNT_IN_BO));
        return d4pf;
    }
}
