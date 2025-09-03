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

public class JdbcFgDatasetBkp191224Dao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDatasetBkp191224Dao.class);

    private static final String TABLE = "FG_DATASET_BKP191224";

    private static final String COL_ID = "ID";

    private static final String COL_DATASOURCE_ID = "DATASOURCE_ID";

    private static final String COL_CODE = "CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_MODEL_CODE = "MODEL_CODE";

    private static final String COL_CONFIG = "CONFIG";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_UUID = "UUID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_DATASOURCE_ID, COL_CODE, COL_NAME, COL_MODEL_CODE, COL_CONFIG, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UUID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DATASOURCE_ID, COL_CODE, COL_NAME, COL_MODEL_CODE, COL_CONFIG, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UUID, COL_ID);

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

    public int insert(Connection conn, FgDatasetBkp191224 fgdatasetbkp191224) throws SQLException {
        logger.debug("Inserting fgdatasetbkp191224: {}", fgdatasetbkp191224);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDatasetBkp191224Params(ps, fgdatasetbkp191224);
            ps.executeUpdate();
            return fgdatasetbkp191224.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDatasetBkp191224> fgdatasetbkp191224s) throws SQLException {
        if (fgdatasetbkp191224s == null || fgdatasetbkp191224s.isEmpty())
            return new int[0];
        for (int i = 0; i < fgdatasetbkp191224s.size(); i++) {
            if (fgdatasetbkp191224s.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDatasetBkp191224>> batches = chunkList(fgdatasetbkp191224s, batchSize);
        int[] totalResults = new int[fgdatasetbkp191224s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDatasetBkp191224> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDatasetBkp191224 fgdatasetbkp191224 : batch) {
                        setFgDatasetBkp191224Params(ps, fgdatasetbkp191224);
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

    public FgDatasetBkp191224 findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDatasetBkp191224> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDatasetBkp191224> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDatasetBkp191224 fgdatasetbkp191224) throws SQLException {
        if (fgdatasetbkp191224.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDatasetBkp191224Params(ps, fgdatasetbkp191224);
            ps.setInt(16, fgdatasetbkp191224.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDatasetBkp191224> fgdatasetbkp191224s) throws SQLException {
        if (fgdatasetbkp191224s == null || fgdatasetbkp191224s.isEmpty())
            return new int[0];
        for (FgDatasetBkp191224 fgdatasetbkp191224 : fgdatasetbkp191224s) {
            if (fgdatasetbkp191224 == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdatasetbkp191224.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDatasetBkp191224>> batches = chunkList(fgdatasetbkp191224s, batchSize);
        int[] totalResults = new int[fgdatasetbkp191224s.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDatasetBkp191224> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDatasetBkp191224 fgdatasetbkp191224 : batch) {
                        setFgDatasetBkp191224Params(ps, fgdatasetbkp191224);
                        ps.setInt(16, fgdatasetbkp191224.getID());
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

    private void setFgDatasetBkp191224Params(PreparedStatement ps, FgDatasetBkp191224 fgdatasetbkp191224) throws SQLException {
        Integer val1 = fgdatasetbkp191224.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgdatasetbkp191224.getDatasourceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgdatasetbkp191224.getCode());
        ps.setString(4, fgdatasetbkp191224.getName());
        ps.setString(5, fgdatasetbkp191224.getModelCode());
        ps.setString(6, fgdatasetbkp191224.getConfig());
        ps.setString(7, fgdatasetbkp191224.getDescription());
        ps.setString(8, fgdatasetbkp191224.getActiveCode());
        ps.setString(9, fgdatasetbkp191224.getStatusCode());
        ps.setString(10, fgdatasetbkp191224.getCreatedOn());
        java.math.BigDecimal val11 = fgdatasetbkp191224.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgdatasetbkp191224.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgdatasetbkp191224.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgdatasetbkp191224.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgdatasetbkp191224.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgdatasetbkp191224.getUuid());
    }

    private FgDatasetBkp191224 extract(ResultSet rs) throws SQLException {
        FgDatasetBkp191224 fgdatasetbkp191224 = new FgDatasetBkp191224();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdatasetbkp191224.setID(ID);
        Integer DATASOURCE_ID = rs.getObject(COL_DATASOURCE_ID, Integer.class);
        fgdatasetbkp191224.setDatasourceID(DATASOURCE_ID);
        fgdatasetbkp191224.setCode(rs.getString(COL_CODE));
        fgdatasetbkp191224.setName(rs.getString(COL_NAME));
        fgdatasetbkp191224.setModelCode(rs.getString(COL_MODEL_CODE));
        fgdatasetbkp191224.setConfig(rs.getString(COL_CONFIG));
        fgdatasetbkp191224.setDescription(rs.getString(COL_DESCRIPTION));
        fgdatasetbkp191224.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdatasetbkp191224.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdatasetbkp191224.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdatasetbkp191224.setCreatedBy(CREATED_BY);
        fgdatasetbkp191224.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdatasetbkp191224.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdatasetbkp191224.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdatasetbkp191224.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgdatasetbkp191224.setUuid(rs.getString(COL_UUID));
        return fgdatasetbkp191224;
    }
}
