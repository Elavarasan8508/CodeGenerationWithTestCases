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

public class JdbcFgTdLiqViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdLiqViewDao.class);

    private static final String TABLE = "FG_TD_LIQ_VIEW";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_REFERENCE_ID, COL_PRODUCT_STATUS, COL_STATUS_CODE, COL_STAGE_CODE, COL_SUB_TYPE_CODE, COL_TYPE_CODE, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_PROCESS_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("REFERENCE_ID, PRODUCT_STATUS, STATUS_CODE, STAGE_CODE, SUB_TYPE_CODE, TYPE_CODE, CREATED_ON, LAST_UPDATED_ON, PROCESS_ID", TABLE, COL_REFERENCE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("REFERENCE_ID, PRODUCT_STATUS, STATUS_CODE, STAGE_CODE, SUB_TYPE_CODE, TYPE_CODE, CREATED_ON, LAST_UPDATED_ON, PROCESS_ID", TABLE, COL_REFERENCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PRODUCT_STATUS, COL_STATUS_CODE, COL_STAGE_CODE, COL_SUB_TYPE_CODE, COL_TYPE_CODE, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_PROCESS_ID, COL_REFERENCE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID);

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

    public int insert(Connection conn, FgTdLiqView fgtdliqview) throws SQLException {
        logger.debug("Inserting fgtdliqview: {}", fgtdliqview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdLiqViewParams(ps, fgtdliqview);
            ps.executeUpdate();
            return fgtdliqview.getReferenceID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdLiqView> fgtdliqviews) throws SQLException {
        if (fgtdliqviews == null || fgtdliqviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdliqviews.size(); i++) {
            if (fgtdliqviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdLiqView>> batches = chunkList(fgtdliqviews, batchSize);
        int[] totalResults = new int[fgtdliqviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdLiqView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdLiqView fgtdliqview : batch) {
                        setFgTdLiqViewParams(ps, fgtdliqview);
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

    public FgTdLiqView findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdLiqView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdLiqView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdLiqView fgtdliqview) throws SQLException {
        if (fgtdliqview.getReferenceID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdLiqViewParams(ps, fgtdliqview);
            ps.setInt(9, fgtdliqview.getReferenceID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdLiqView> fgtdliqviews) throws SQLException {
        if (fgtdliqviews == null || fgtdliqviews.isEmpty())
            return new int[0];
        for (FgTdLiqView fgtdliqview : fgtdliqviews) {
            if (fgtdliqview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdliqview.getReferenceID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdLiqView>> batches = chunkList(fgtdliqviews, batchSize);
        int[] totalResults = new int[fgtdliqviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdLiqView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdLiqView fgtdliqview : batch) {
                        setFgTdLiqViewParams(ps, fgtdliqview);
                        ps.setInt(9, fgtdliqview.getReferenceID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_REFERENCE_ID, placeholders);
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

    private void setFgTdLiqViewParams(PreparedStatement ps, FgTdLiqView fgtdliqview) throws SQLException {
        Integer val1 = fgtdliqview.getReferenceID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgtdliqview.getProductStatus());
        ps.setString(3, fgtdliqview.getStatusCode());
        ps.setString(4, fgtdliqview.getStageCode());
        ps.setString(5, fgtdliqview.getSubTypeCode());
        ps.setString(6, fgtdliqview.getTypeCode());
        ps.setString(7, fgtdliqview.getCreatedOn());
        ps.setString(8, fgtdliqview.getLastUpdatedOn());
        Integer val9 = fgtdliqview.getProcessID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
    }

    private FgTdLiqView extract(ResultSet rs) throws SQLException {
        FgTdLiqView fgtdliqview = new FgTdLiqView();
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdliqview.setReferenceID(REFERENCE_ID);
        fgtdliqview.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        fgtdliqview.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtdliqview.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdliqview.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdliqview.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdliqview.setCreatedOn(rs.getString(COL_CREATED_ON));
        fgtdliqview.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdliqview.setProcessID(PROCESS_ID);
        return fgtdliqview;
    }
}
