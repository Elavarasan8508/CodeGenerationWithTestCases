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

public class JdbcFgDatasetDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDatasetDao.class);

    private static final String TABLE = "FG_DATASET";

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

    private static final String COL_MASTER_TEMPLATE = "MASTER_TEMPLATE";

    private static final String COL_MASTER_CONTENT_HASH = "MASTER_CONTENT_HASH";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_DATASOURCE_ID, COL_CODE, COL_NAME, COL_MODEL_CODE, COL_CONFIG, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UUID, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_IS_MASTER_VERSION, COL_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DATASOURCE_ID, COL_CODE, COL_NAME, COL_MODEL_CODE, COL_CONFIG, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_UUID, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_IS_MASTER_VERSION, COL_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgDataset fgdataset) throws SQLException {
        logger.debug("Inserting fgdataset: {}", fgdataset);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDatasetParams(ps, fgdataset);
            ps.executeUpdate();
            return fgdataset.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDataset> fgdatasets) throws SQLException {
        if (fgdatasets == null || fgdatasets.isEmpty())
            return new int[0];
        for (int i = 0; i < fgdatasets.size(); i++) {
            if (fgdatasets.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDataset>> batches = chunkList(fgdatasets, batchSize);
        int[] totalResults = new int[fgdatasets.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDataset> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDataset fgdataset : batch) {
                        setFgDatasetParams(ps, fgdataset);
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

    public FgDataset findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDataset> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDataset> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDataset fgdataset) throws SQLException {
        if (fgdataset.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDatasetParams(ps, fgdataset);
            ps.setInt(20, fgdataset.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDataset> fgdatasets) throws SQLException {
        if (fgdatasets == null || fgdatasets.isEmpty())
            return new int[0];
        for (FgDataset fgdataset : fgdatasets) {
            if (fgdataset == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdataset.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDataset>> batches = chunkList(fgdatasets, batchSize);
        int[] totalResults = new int[fgdatasets.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDataset> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDataset fgdataset : batch) {
                        setFgDatasetParams(ps, fgdataset);
                        ps.setInt(20, fgdataset.getID());
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

    private void setFgDatasetParams(PreparedStatement ps, FgDataset fgdataset) throws SQLException {
        Integer val1 = fgdataset.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgdataset.getDatasourceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgdataset.getCode());
        ps.setString(4, fgdataset.getName());
        ps.setString(5, fgdataset.getModelCode());
        ps.setString(6, fgdataset.getConfig());
        ps.setString(7, fgdataset.getDescription());
        ps.setString(8, fgdataset.getActiveCode());
        ps.setString(9, fgdataset.getStatusCode());
        ps.setString(10, fgdataset.getCreatedOn());
        java.math.BigDecimal val11 = fgdataset.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgdataset.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgdataset.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgdataset.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgdataset.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgdataset.getUuid());
        ps.setString(17, fgdataset.getMasterTemplate());
        ps.setString(18, fgdataset.getMasterContentHash());
        java.math.BigDecimal val19 = fgdataset.getIsMasterVersion();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        Integer val20 = fgdataset.getVersionID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
    }

    private FgDataset extract(ResultSet rs) throws SQLException {
        FgDataset fgdataset = new FgDataset();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdataset.setID(ID);
        Integer DATASOURCE_ID = rs.getObject(COL_DATASOURCE_ID, Integer.class);
        fgdataset.setDatasourceID(DATASOURCE_ID);
        fgdataset.setCode(rs.getString(COL_CODE));
        fgdataset.setName(rs.getString(COL_NAME));
        fgdataset.setModelCode(rs.getString(COL_MODEL_CODE));
        fgdataset.setConfig(rs.getString(COL_CONFIG));
        fgdataset.setDescription(rs.getString(COL_DESCRIPTION));
        fgdataset.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdataset.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdataset.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdataset.setCreatedBy(CREATED_BY);
        fgdataset.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdataset.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdataset.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdataset.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgdataset.setUuid(rs.getString(COL_UUID));
        fgdataset.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        fgdataset.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgdataset.setIsMasterVersion(IS_MASTER_VERSION);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgdataset.setVersionID(VERSION_ID);
        return fgdataset;
    }
}
