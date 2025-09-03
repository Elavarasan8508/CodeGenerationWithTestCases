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

public class JdbcDatabasechangelogDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDatabasechangelogDao.class);

    private static final String TABLE = "DATABASECHANGELOG";

    private static final String COL_ID = "ID";

    private static final String COL_AUTHOR = "AUTHOR";

    private static final String COL_FILENAME = "FILENAME";

    private static final String COL_DATEEXECUTED = "DATEEXECUTED";

    private static final String COL_ORDEREXECUTED = "ORDEREXECUTED";

    private static final String COL_EXECTYPE = "EXECTYPE";

    private static final String COL_MD5SUM = "MD5SUM";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_TAG = "TAG";

    private static final String COL_LIQUIBASE = "LIQUIBASE";

    private static final String COL_CONTEXTS = "CONTEXTS";

    private static final String COL_LABELS = "LABELS";

    private static final String COL_DEPLOYMENT_ID = "DEPLOYMENT_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_AUTHOR, COL_FILENAME, COL_DATEEXECUTED, COL_ORDEREXECUTED, COL_EXECTYPE, COL_MD5SUM, COL_DESCRIPTION, COL_COMMENTS, COL_TAG, COL_LIQUIBASE, COL_CONTEXTS, COL_LABELS, COL_DEPLOYMENT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, EXECTYPE, MD5SUM, DESCRIPTION, COMMENTS, TAG, LIQUIBASE, CONTEXTS, LABELS, DEPLOYMENT_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, EXECTYPE, MD5SUM, DESCRIPTION, COMMENTS, TAG, LIQUIBASE, CONTEXTS, LABELS, DEPLOYMENT_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AUTHOR, COL_FILENAME, COL_DATEEXECUTED, COL_ORDEREXECUTED, COL_EXECTYPE, COL_MD5SUM, COL_DESCRIPTION, COL_COMMENTS, COL_TAG, COL_LIQUIBASE, COL_CONTEXTS, COL_LABELS, COL_DEPLOYMENT_ID, COL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID);

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

    public int insert(Connection conn, Databasechangelog databasechangelog) throws SQLException {
        logger.debug("Inserting databasechangelog: {}", databasechangelog);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setDatabasechangelogParams(ps, databasechangelog);
            ps.executeUpdate();
            return databasechangelog.getID();
        }
    }

    public int[] insertAll(Connection conn, List<Databasechangelog> databasechangelogs) throws SQLException {
        if (databasechangelogs == null || databasechangelogs.isEmpty())
            return new int[0];
        for (int i = 0; i < databasechangelogs.size(); i++) {
            if (databasechangelogs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Databasechangelog>> batches = chunkList(databasechangelogs, batchSize);
        int[] totalResults = new int[databasechangelogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Databasechangelog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Databasechangelog databasechangelog : batch) {
                        setDatabasechangelogParams(ps, databasechangelog);
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

    public Databasechangelog findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Databasechangelog> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Databasechangelog> list = new ArrayList<>();
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

    public boolean update(Connection conn, Databasechangelog databasechangelog) throws SQLException {
        if (databasechangelog.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setDatabasechangelogParams(ps, databasechangelog);
            ps.setInt(14, databasechangelog.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Databasechangelog> databasechangelogs) throws SQLException {
        if (databasechangelogs == null || databasechangelogs.isEmpty())
            return new int[0];
        for (Databasechangelog databasechangelog : databasechangelogs) {
            if (databasechangelog == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (databasechangelog.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Databasechangelog>> batches = chunkList(databasechangelogs, batchSize);
        int[] totalResults = new int[databasechangelogs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Databasechangelog> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Databasechangelog databasechangelog : batch) {
                        setDatabasechangelogParams(ps, databasechangelog);
                        ps.setInt(14, databasechangelog.getID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID, placeholders);
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

    private void setDatabasechangelogParams(PreparedStatement ps, Databasechangelog databasechangelog) throws SQLException {
        Integer val1 = databasechangelog.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, databasechangelog.getAuthor());
        ps.setString(3, databasechangelog.getFilename());
        ps.setString(4, databasechangelog.getDateexecuted());
        java.math.BigDecimal val5 = databasechangelog.getOrderexecuted();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, databasechangelog.getExectype());
        ps.setString(7, databasechangelog.getMd5sum());
        ps.setString(8, databasechangelog.getDescription());
        ps.setString(9, databasechangelog.getComments());
        ps.setString(10, databasechangelog.getTag());
        ps.setString(11, databasechangelog.getLiquibase());
        ps.setString(12, databasechangelog.getContexts());
        ps.setString(13, databasechangelog.getLabels());
        Integer val14 = databasechangelog.getDeploymentID();
        if (val14 != null) {
            ps.setInt(14, val14);
        } else {
            ps.setNull(14, Types.INTEGER);
        }
    }

    private Databasechangelog extract(ResultSet rs) throws SQLException {
        Databasechangelog databasechangelog = new Databasechangelog();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        databasechangelog.setID(ID);
        databasechangelog.setAuthor(rs.getString(COL_AUTHOR));
        databasechangelog.setFilename(rs.getString(COL_FILENAME));
        databasechangelog.setDateexecuted(rs.getString(COL_DATEEXECUTED));
        java.math.BigDecimal ORDEREXECUTED = rs.getObject(COL_ORDEREXECUTED, java.math.BigDecimal.class);
        databasechangelog.setOrderexecuted(ORDEREXECUTED);
        databasechangelog.setExectype(rs.getString(COL_EXECTYPE));
        databasechangelog.setMd5sum(rs.getString(COL_MD5SUM));
        databasechangelog.setDescription(rs.getString(COL_DESCRIPTION));
        databasechangelog.setComments(rs.getString(COL_COMMENTS));
        databasechangelog.setTag(rs.getString(COL_TAG));
        databasechangelog.setLiquibase(rs.getString(COL_LIQUIBASE));
        databasechangelog.setContexts(rs.getString(COL_CONTEXTS));
        databasechangelog.setLabels(rs.getString(COL_LABELS));
        Integer DEPLOYMENT_ID = rs.getObject(COL_DEPLOYMENT_ID, Integer.class);
        databasechangelog.setDeploymentID(DEPLOYMENT_ID);
        return databasechangelog;
    }
}
