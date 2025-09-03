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

public class JdbcFccOrmStaggingDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFccOrmStaggingDao.class);

    private static final String TABLE = "FCC_ORM_STAGGING";

    private static final String COL_SEQ_ID = "SEQ_ID";

    private static final String COL_REFERENCEID = "REFERENCEID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_UPLOAD_TNX_ID = "UPLOAD_TNX_ID";

    private static final String COL_REQUEST = "REQUEST";

    private static final String COL_RESPONSE = "RESPONSE";

    private static final String COL_ERROR_MSG = "ERROR_MSG";

    private static final String COL_INSERTED_ON = "INSERTED_ON";

    private static final String COL_TNX_STAT_CODE = "TNX_STAT_CODE";

    private static final String COL_PROD_STAT_CODE = "PROD_STAT_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_SEQ_ID, COL_REFERENCEID, COL_UPLOAD_REF_ID, COL_UPLOAD_TNX_ID, COL_REQUEST, COL_RESPONSE, COL_ERROR_MSG, COL_INSERTED_ON, COL_TNX_STAT_CODE, COL_PROD_STAT_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("SEQ_ID, REFERENCEID, UPLOAD_REF_ID, UPLOAD_TNX_ID, REQUEST, RESPONSE, ERROR_MSG, INSERTED_ON, TNX_STAT_CODE, PROD_STAT_CODE", TABLE, COL_SEQ_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("SEQ_ID, REFERENCEID, UPLOAD_REF_ID, UPLOAD_TNX_ID, REQUEST, RESPONSE, ERROR_MSG, INSERTED_ON, TNX_STAT_CODE, PROD_STAT_CODE", TABLE, COL_SEQ_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCEID, COL_UPLOAD_REF_ID, COL_UPLOAD_TNX_ID, COL_REQUEST, COL_RESPONSE, COL_ERROR_MSG, COL_INSERTED_ON, COL_TNX_STAT_CODE, COL_PROD_STAT_CODE, COL_SEQ_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_SEQ_ID);

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

    public int insert(Connection conn, FccOrmStagging fccormstagging) throws SQLException {
        logger.debug("Inserting fccormstagging: {}", fccormstagging);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFccOrmStaggingParams(ps, fccormstagging);
            ps.executeUpdate();
            return fccormstagging.getSeqID();
        }
    }

    public int[] insertAll(Connection conn, List<FccOrmStagging> fccormstaggings) throws SQLException {
        if (fccormstaggings == null || fccormstaggings.isEmpty())
            return new int[0];
        for (int i = 0; i < fccormstaggings.size(); i++) {
            if (fccormstaggings.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FccOrmStagging>> batches = chunkList(fccormstaggings, batchSize);
        int[] totalResults = new int[fccormstaggings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FccOrmStagging> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FccOrmStagging fccormstagging : batch) {
                        setFccOrmStaggingParams(ps, fccormstagging);
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

    public FccOrmStagging findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FccOrmStagging> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FccOrmStagging> list = new ArrayList<>();
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

    public boolean update(Connection conn, FccOrmStagging fccormstagging) throws SQLException {
        if (fccormstagging.getSeqID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFccOrmStaggingParams(ps, fccormstagging);
            ps.setInt(10, fccormstagging.getSeqID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FccOrmStagging> fccormstaggings) throws SQLException {
        if (fccormstaggings == null || fccormstaggings.isEmpty())
            return new int[0];
        for (FccOrmStagging fccormstagging : fccormstaggings) {
            if (fccormstagging == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fccormstagging.getSeqID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FccOrmStagging>> batches = chunkList(fccormstaggings, batchSize);
        int[] totalResults = new int[fccormstaggings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FccOrmStagging> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FccOrmStagging fccormstagging : batch) {
                        setFccOrmStaggingParams(ps, fccormstagging);
                        ps.setInt(10, fccormstagging.getSeqID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_SEQ_ID, placeholders);
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

    private void setFccOrmStaggingParams(PreparedStatement ps, FccOrmStagging fccormstagging) throws SQLException {
        Integer val1 = fccormstagging.getSeqID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fccormstagging.getReferenceid());
        Integer val3 = fccormstagging.getUploadRefID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = fccormstagging.getUploadTnxID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fccormstagging.getRequest());
        ps.setString(6, fccormstagging.getResponse());
        ps.setString(7, fccormstagging.getErrorMsg());
        ps.setString(8, fccormstagging.getInsertedOn());
        ps.setString(9, fccormstagging.getTnxStatCode());
        ps.setString(10, fccormstagging.getProdStatCode());
    }

    private FccOrmStagging extract(ResultSet rs) throws SQLException {
        FccOrmStagging fccormstagging = new FccOrmStagging();
        Integer SEQ_ID = rs.getObject(COL_SEQ_ID, Integer.class);
        fccormstagging.setSeqID(SEQ_ID);
        fccormstagging.setReferenceid(rs.getString(COL_REFERENCEID));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fccormstagging.setUploadRefID(UPLOAD_REF_ID);
        Integer UPLOAD_TNX_ID = rs.getObject(COL_UPLOAD_TNX_ID, Integer.class);
        fccormstagging.setUploadTnxID(UPLOAD_TNX_ID);
        fccormstagging.setRequest(rs.getString(COL_REQUEST));
        fccormstagging.setResponse(rs.getString(COL_RESPONSE));
        fccormstagging.setErrorMsg(rs.getString(COL_ERROR_MSG));
        fccormstagging.setInsertedOn(rs.getString(COL_INSERTED_ON));
        fccormstagging.setTnxStatCode(rs.getString(COL_TNX_STAT_CODE));
        fccormstagging.setProdStatCode(rs.getString(COL_PROD_STAT_CODE));
        return fccormstagging;
    }
}
