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

public class JdbcFgIrNostroStaggingDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgIrNostroStaggingDao.class);

    private static final String TABLE = "FG_IR_NOSTRO_STAGGING";

    private static final String COL_ID = "ID";

    private static final String COL_NOSTRO_NUMBER = "NOSTRO_NUMBER";

    private static final String COL_NOSTRO_XML = "NOSTRO_XML";

    private static final String COL_INSERTED_ON = "INSERTED_ON";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_NODE = "NODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_NOSTRO_NUMBER, COL_NOSTRO_XML, COL_INSERTED_ON, COL_STATUS, COL_NODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NOSTRO_NUMBER, NOSTRO_XML, INSERTED_ON, STATUS, NODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, NOSTRO_NUMBER, NOSTRO_XML, INSERTED_ON, STATUS, NODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NOSTRO_NUMBER, COL_NOSTRO_XML, COL_INSERTED_ON, COL_STATUS, COL_NODE, COL_ID);

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

    public int insert(Connection conn, FgIrNostroStagging fgirnostrostagging) throws SQLException {
        logger.debug("Inserting fgirnostrostagging: {}", fgirnostrostagging);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgIrNostroStaggingParams(ps, fgirnostrostagging);
            ps.executeUpdate();
            return fgirnostrostagging.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgIrNostroStagging> fgirnostrostaggings) throws SQLException {
        if (fgirnostrostaggings == null || fgirnostrostaggings.isEmpty())
            return new int[0];
        for (int i = 0; i < fgirnostrostaggings.size(); i++) {
            if (fgirnostrostaggings.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIrNostroStagging>> batches = chunkList(fgirnostrostaggings, batchSize);
        int[] totalResults = new int[fgirnostrostaggings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIrNostroStagging> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgIrNostroStagging fgirnostrostagging : batch) {
                        setFgIrNostroStaggingParams(ps, fgirnostrostagging);
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

    public FgIrNostroStagging findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgIrNostroStagging> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgIrNostroStagging> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgIrNostroStagging fgirnostrostagging) throws SQLException {
        if (fgirnostrostagging.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgIrNostroStaggingParams(ps, fgirnostrostagging);
            ps.setInt(6, fgirnostrostagging.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgIrNostroStagging> fgirnostrostaggings) throws SQLException {
        if (fgirnostrostaggings == null || fgirnostrostaggings.isEmpty())
            return new int[0];
        for (FgIrNostroStagging fgirnostrostagging : fgirnostrostaggings) {
            if (fgirnostrostagging == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgirnostrostagging.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIrNostroStagging>> batches = chunkList(fgirnostrostaggings, batchSize);
        int[] totalResults = new int[fgirnostrostaggings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIrNostroStagging> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgIrNostroStagging fgirnostrostagging : batch) {
                        setFgIrNostroStaggingParams(ps, fgirnostrostagging);
                        ps.setInt(6, fgirnostrostagging.getID());
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

    private void setFgIrNostroStaggingParams(PreparedStatement ps, FgIrNostroStagging fgirnostrostagging) throws SQLException {
        Integer val1 = fgirnostrostagging.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgirnostrostagging.getNostroNumber());
        ps.setString(3, fgirnostrostagging.getNostroXml());
        ps.setString(4, fgirnostrostagging.getInsertedOn());
        ps.setString(5, fgirnostrostagging.getStatus());
        ps.setString(6, fgirnostrostagging.getNode());
    }

    private FgIrNostroStagging extract(ResultSet rs) throws SQLException {
        FgIrNostroStagging fgirnostrostagging = new FgIrNostroStagging();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgirnostrostagging.setID(ID);
        fgirnostrostagging.setNostroNumber(rs.getString(COL_NOSTRO_NUMBER));
        fgirnostrostagging.setNostroXml(rs.getString(COL_NOSTRO_XML));
        fgirnostrostagging.setInsertedOn(rs.getString(COL_INSERTED_ON));
        fgirnostrostagging.setStatus(rs.getString(COL_STATUS));
        fgirnostrostagging.setNode(rs.getString(COL_NODE));
        return fgirnostrostagging;
    }
}
