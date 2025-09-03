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

public class JdbcCvpfDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCvpfDao.class);

    private static final String TABLE = "CVPF";

    private static final String COL_CVYOC = "CVYOC";

    private static final String COL_CVCCY = "CVCCY";

    private static final String COL_CVCNA = "CVCNA";

    private static final String COL_CVCLD = "CVCLD";

    private static final String COL_CVDIW = "CVDIW";

    private static final String COL_CVDIY = "CVDIY";

    private static final String COL_CVDOO = "CVDOO";

    private static final String COL_MNT_IN_BO = "MNT_IN_BO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_CVYOC, COL_CVCCY, COL_CVCNA, COL_CVCLD, COL_CVDIW, COL_CVDIY, COL_CVDOO, COL_MNT_IN_BO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("CVYOC, CVCCY, CVCNA, CVCLD, CVDIW, CVDIY, CVDOO, MNT_IN_BO", TABLE, COL_CVYOC);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("CVYOC, CVCCY, CVCNA, CVCLD, CVDIW, CVDIY, CVDOO, MNT_IN_BO", TABLE, COL_CVYOC);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CVCCY, COL_CVCNA, COL_CVCLD, COL_CVDIW, COL_CVDIY, COL_CVDOO, COL_MNT_IN_BO, COL_CVYOC);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CVYOC);

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

    public java.math.BigDecimal insert(Connection conn, Cvpf cvpf) throws SQLException {
        logger.debug("Inserting cvpf: {}", cvpf);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCvpfParams(ps, cvpf);
            ps.executeUpdate();
            return cvpf.getCvyoc();
        }
    }

    public int[] insertAll(Connection conn, List<Cvpf> cvpfs) throws SQLException {
        if (cvpfs == null || cvpfs.isEmpty())
            return new int[0];
        for (int i = 0; i < cvpfs.size(); i++) {
            if (cvpfs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Cvpf>> batches = chunkList(cvpfs, batchSize);
        int[] totalResults = new int[cvpfs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Cvpf> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Cvpf cvpf : batch) {
                        setCvpfParams(ps, cvpf);
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

    public Cvpf findById(Connection conn, java.math.BigDecimal id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setBigDecimal(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Cvpf> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Cvpf> list = new ArrayList<>();
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

    public boolean update(Connection conn, Cvpf cvpf) throws SQLException {
        if (cvpf.getCvyoc() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCvpfParams(ps, cvpf);
            ps.setBigDecimal(8, cvpf.getCvyoc());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Cvpf> cvpfs) throws SQLException {
        if (cvpfs == null || cvpfs.isEmpty())
            return new int[0];
        for (Cvpf cvpf : cvpfs) {
            if (cvpf == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (cvpf.getCvyoc() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Cvpf>> batches = chunkList(cvpfs, batchSize);
        int[] totalResults = new int[cvpfs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Cvpf> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Cvpf cvpf : batch) {
                        setCvpfParams(ps, cvpf);
                        ps.setBigDecimal(8, cvpf.getCvyoc());
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

    public boolean deleteById(Connection conn, java.math.BigDecimal id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setBigDecimal(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<java.math.BigDecimal> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (java.math.BigDecimal id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<java.math.BigDecimal>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<java.math.BigDecimal> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_CVYOC, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setBigDecimal(i + 1, chunk.get(i));
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

    private void setCvpfParams(PreparedStatement ps, Cvpf cvpf) throws SQLException {
        java.math.BigDecimal val1 = cvpf.getCvyoc();
        if (val1 != null) {
            ps.setBigDecimal(1, val1);
        } else {
            ps.setNull(1, Types.DECIMAL);
        }
        ps.setString(2, cvpf.getCvccy());
        ps.setString(3, cvpf.getCvcna());
        ps.setString(4, cvpf.getCvcld());
        ps.setString(5, cvpf.getCvdiw());
        ps.setString(6, cvpf.getCvdiy());
        java.math.BigDecimal val7 = cvpf.getCvdoo();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        ps.setString(8, cvpf.getMntInBo());
    }

    private Cvpf extract(ResultSet rs) throws SQLException {
        Cvpf cvpf = new Cvpf();
        java.math.BigDecimal CVYOC = rs.getObject(COL_CVYOC, java.math.BigDecimal.class);
        cvpf.setCvyoc(CVYOC);
        cvpf.setCvccy(rs.getString(COL_CVCCY));
        cvpf.setCvcna(rs.getString(COL_CVCNA));
        cvpf.setCvcld(rs.getString(COL_CVCLD));
        cvpf.setCvdiw(rs.getString(COL_CVDIW));
        cvpf.setCvdiy(rs.getString(COL_CVDIY));
        java.math.BigDecimal CVDOO = rs.getObject(COL_CVDOO, java.math.BigDecimal.class);
        cvpf.setCvdoo(CVDOO);
        cvpf.setMntInBo(rs.getString(COL_MNT_IN_BO));
        return cvpf;
    }
}
