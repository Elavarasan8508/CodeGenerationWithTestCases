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

public class JdbcFgApplicationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgApplicationDao.class);

    private static final String TABLE = "FG_APPLICATION";

    private static final String COL_ID = "ID";

    private static final String COL_CODE = "CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_SUB_TITLE = "SUB_TITLE";

    private static final String COL_ICON = "ICON";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_NAVIGATION_SCHEMA = "NAVIGATION_SCHEMA";

    private static final String COL_IS_SECURED = "IS_SECURED";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_APPLICATION_TYPE = "APPLICATION_TYPE";

    private static final String COL_UUID = "UUID";

    private static final String COL_TAGS = "TAGS";

    private static final String COL_APP_TITLE = "APP_TITLE";

    private static final String COL_DEVICE_CHANNEL = "DEVICE_CHANNEL";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_MASTER_TEMPLATE = "MASTER_TEMPLATE";

    private static final String COL_MASTER_CONTENT_HASH = "MASTER_CONTENT_HASH";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_CODE, COL_NAME, COL_SUB_TITLE, COL_ICON, COL_DESCRIPTION, COL_NAVIGATION_SCHEMA, COL_IS_SECURED, COL_ACTIVE_CODE, COL_APPLICATION_TYPE, COL_UUID, COL_TAGS, COL_APP_TITLE, COL_DEVICE_CHANNEL, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_IS_MASTER_VERSION, COL_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, CODE, NAME, SUB_TITLE, ICON, DESCRIPTION, NAVIGATION_SCHEMA, IS_SECURED, ACTIVE_CODE, APPLICATION_TYPE, UUID, TAGS, APP_TITLE, DEVICE_CHANNEL, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, CODE, NAME, SUB_TITLE, ICON, DESCRIPTION, NAVIGATION_SCHEMA, IS_SECURED, ACTIVE_CODE, APPLICATION_TYPE, UUID, TAGS, APP_TITLE, DEVICE_CHANNEL, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CODE, COL_NAME, COL_SUB_TITLE, COL_ICON, COL_DESCRIPTION, COL_NAVIGATION_SCHEMA, COL_IS_SECURED, COL_ACTIVE_CODE, COL_APPLICATION_TYPE, COL_UUID, COL_TAGS, COL_APP_TITLE, COL_DEVICE_CHANNEL, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_MASTER_TEMPLATE, COL_MASTER_CONTENT_HASH, COL_IS_MASTER_VERSION, COL_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgApplication fgapplication) throws SQLException {
        logger.debug("Inserting fgapplication: {}", fgapplication);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgApplicationParams(ps, fgapplication);
            ps.executeUpdate();
            return fgapplication.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgApplication> fgapplications) throws SQLException {
        if (fgapplications == null || fgapplications.isEmpty())
            return new int[0];
        for (int i = 0; i < fgapplications.size(); i++) {
            if (fgapplications.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgApplication>> batches = chunkList(fgapplications, batchSize);
        int[] totalResults = new int[fgapplications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgApplication> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgApplication fgapplication : batch) {
                        setFgApplicationParams(ps, fgapplication);
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

    public FgApplication findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgApplication> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgApplication> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgApplication fgapplication) throws SQLException {
        if (fgapplication.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgApplicationParams(ps, fgapplication);
            ps.setInt(24, fgapplication.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgApplication> fgapplications) throws SQLException {
        if (fgapplications == null || fgapplications.isEmpty())
            return new int[0];
        for (FgApplication fgapplication : fgapplications) {
            if (fgapplication == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgapplication.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgApplication>> batches = chunkList(fgapplications, batchSize);
        int[] totalResults = new int[fgapplications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgApplication> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgApplication fgapplication : batch) {
                        setFgApplicationParams(ps, fgapplication);
                        ps.setInt(24, fgapplication.getID());
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

    private void setFgApplicationParams(PreparedStatement ps, FgApplication fgapplication) throws SQLException {
        Integer val1 = fgapplication.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgapplication.getCode());
        ps.setString(3, fgapplication.getName());
        ps.setString(4, fgapplication.getSubTitle());
        ps.setString(5, fgapplication.getIcon());
        ps.setString(6, fgapplication.getDescription());
        ps.setString(7, fgapplication.getNavigationSchema());
        java.math.BigDecimal val8 = fgapplication.getIsSecured();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgapplication.getActiveCode());
        ps.setString(10, fgapplication.getApplicationType());
        ps.setString(11, fgapplication.getUuid());
        ps.setString(12, fgapplication.getTags());
        ps.setString(13, fgapplication.getAppTitle());
        ps.setString(14, fgapplication.getDeviceChannel());
        ps.setString(15, fgapplication.getCreatedOn());
        java.math.BigDecimal val16 = fgapplication.getCreatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgapplication.getLastUpdatedOn());
        java.math.BigDecimal val18 = fgapplication.getLastUpdatedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgapplication.getLastAuthorisedOn());
        java.math.BigDecimal val20 = fgapplication.getLastAuthorisedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgapplication.getMasterTemplate());
        ps.setString(22, fgapplication.getMasterContentHash());
        java.math.BigDecimal val23 = fgapplication.getIsMasterVersion();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        Integer val24 = fgapplication.getVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
    }

    private FgApplication extract(ResultSet rs) throws SQLException {
        FgApplication fgapplication = new FgApplication();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgapplication.setID(ID);
        fgapplication.setCode(rs.getString(COL_CODE));
        fgapplication.setName(rs.getString(COL_NAME));
        fgapplication.setSubTitle(rs.getString(COL_SUB_TITLE));
        fgapplication.setIcon(rs.getString(COL_ICON));
        fgapplication.setDescription(rs.getString(COL_DESCRIPTION));
        fgapplication.setNavigationSchema(rs.getString(COL_NAVIGATION_SCHEMA));
        java.math.BigDecimal IS_SECURED = rs.getObject(COL_IS_SECURED, java.math.BigDecimal.class);
        fgapplication.setIsSecured(IS_SECURED);
        fgapplication.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgapplication.setApplicationType(rs.getString(COL_APPLICATION_TYPE));
        fgapplication.setUuid(rs.getString(COL_UUID));
        fgapplication.setTags(rs.getString(COL_TAGS));
        fgapplication.setAppTitle(rs.getString(COL_APP_TITLE));
        fgapplication.setDeviceChannel(rs.getString(COL_DEVICE_CHANNEL));
        fgapplication.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgapplication.setCreatedBy(CREATED_BY);
        fgapplication.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgapplication.setLastUpdatedBy(LAST_UPDATED_BY);
        fgapplication.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgapplication.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgapplication.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        fgapplication.setMasterContentHash(rs.getString(COL_MASTER_CONTENT_HASH));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgapplication.setIsMasterVersion(IS_MASTER_VERSION);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgapplication.setVersionID(VERSION_ID);
        return fgapplication;
    }
}
