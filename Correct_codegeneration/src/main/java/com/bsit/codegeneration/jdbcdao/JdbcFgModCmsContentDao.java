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

public class JdbcFgModCmsContentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModCmsContentDao.class);

    private static final String TABLE = "FG_MOD_CMS_CONTENT";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_OWNER_PARTY_CODE = "OWNER_PARTY_CODE";

    private static final String COL_OWNER_TYPE_CODE = "OWNER_TYPE_CODE";

    private static final String COL_SPACE_CODE = "SPACE_CODE";

    private static final String COL_CONTENT_REF_NO = "CONTENT_REF_NO";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_TITLE = "TITLE";

    private static final String COL_SUB_TITLE = "SUB_TITLE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_CONTENT_DATA = "CONTENT_DATA";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PUBLISH_DATE = "PUBLISH_DATE";

    private static final String COL_EXPIRE_DATE = "EXPIRE_DATE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_OWNER_PARTY_CODE, COL_OWNER_TYPE_CODE, COL_SPACE_CODE, COL_CONTENT_REF_NO, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_NAME, COL_TITLE, COL_SUB_TITLE, COL_DESCRIPTION, COL_CONTENT_DATA, COL_IS_MASTER_VERSION, COL_PUBLISH_DATE, COL_EXPIRE_DATE, COL_STAGE_CODE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, OWNER_PARTY_CODE, OWNER_TYPE_CODE, SPACE_CODE, CONTENT_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, CONTENT_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, OWNER_PARTY_CODE, OWNER_TYPE_CODE, SPACE_CODE, CONTENT_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, CONTENT_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_OWNER_PARTY_CODE, COL_OWNER_TYPE_CODE, COL_SPACE_CODE, COL_CONTENT_REF_NO, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_NAME, COL_TITLE, COL_SUB_TITLE, COL_DESCRIPTION, COL_CONTENT_DATA, COL_IS_MASTER_VERSION, COL_PUBLISH_DATE, COL_EXPIRE_DATE, COL_STAGE_CODE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgModCmsContent fgmodcmscontent) throws SQLException {
        logger.debug("Inserting fgmodcmscontent: {}", fgmodcmscontent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModCmsContentParams(ps, fgmodcmscontent);
            ps.executeUpdate();
            return fgmodcmscontent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModCmsContent> fgmodcmscontents) throws SQLException {
        if (fgmodcmscontents == null || fgmodcmscontents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodcmscontents.size(); i++) {
            if (fgmodcmscontents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsContent>> batches = chunkList(fgmodcmscontents, batchSize);
        int[] totalResults = new int[fgmodcmscontents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsContent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModCmsContent fgmodcmscontent : batch) {
                        setFgModCmsContentParams(ps, fgmodcmscontent);
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

    public FgModCmsContent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModCmsContent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModCmsContent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModCmsContent fgmodcmscontent) throws SQLException {
        if (fgmodcmscontent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModCmsContentParams(ps, fgmodcmscontent);
            ps.setInt(25, fgmodcmscontent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModCmsContent> fgmodcmscontents) throws SQLException {
        if (fgmodcmscontents == null || fgmodcmscontents.isEmpty())
            return new int[0];
        for (FgModCmsContent fgmodcmscontent : fgmodcmscontents) {
            if (fgmodcmscontent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodcmscontent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsContent>> batches = chunkList(fgmodcmscontents, batchSize);
        int[] totalResults = new int[fgmodcmscontents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsContent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModCmsContent fgmodcmscontent : batch) {
                        setFgModCmsContentParams(ps, fgmodcmscontent);
                        ps.setInt(25, fgmodcmscontent.getID());
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

    private void setFgModCmsContentParams(PreparedStatement ps, FgModCmsContent fgmodcmscontent) throws SQLException {
        Integer val1 = fgmodcmscontent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodcmscontent.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodcmscontent.getOwnerPartyCode());
        ps.setString(4, fgmodcmscontent.getOwnerTypeCode());
        ps.setString(5, fgmodcmscontent.getSpaceCode());
        ps.setString(6, fgmodcmscontent.getContentRefNo());
        ps.setString(7, fgmodcmscontent.getEntityTypeCode());
        ps.setString(8, fgmodcmscontent.getEntitySubTypeCode());
        ps.setString(9, fgmodcmscontent.getName());
        ps.setString(10, fgmodcmscontent.getTitle());
        ps.setString(11, fgmodcmscontent.getSubTitle());
        ps.setString(12, fgmodcmscontent.getDescription());
        ps.setString(13, fgmodcmscontent.getContentData());
        java.math.BigDecimal val14 = fgmodcmscontent.getIsMasterVersion();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgmodcmscontent.getPublishDate());
        ps.setString(16, fgmodcmscontent.getExpireDate());
        ps.setString(17, fgmodcmscontent.getStageCode());
        ps.setString(18, fgmodcmscontent.getStatusCode());
        ps.setString(19, fgmodcmscontent.getActiveCode());
        java.math.BigDecimal val20 = fgmodcmscontent.getCreatedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgmodcmscontent.getCreatedOn());
        java.math.BigDecimal val22 = fgmodcmscontent.getLastUpdatedBy();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgmodcmscontent.getLastUpdatedOn());
        java.math.BigDecimal val24 = fgmodcmscontent.getLastAuthorisedBy();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgmodcmscontent.getLastAuthorisedOn());
    }

    private FgModCmsContent extract(ResultSet rs) throws SQLException {
        FgModCmsContent fgmodcmscontent = new FgModCmsContent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodcmscontent.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodcmscontent.setVersionID(VERSION_ID);
        fgmodcmscontent.setOwnerPartyCode(rs.getString(COL_OWNER_PARTY_CODE));
        fgmodcmscontent.setOwnerTypeCode(rs.getString(COL_OWNER_TYPE_CODE));
        fgmodcmscontent.setSpaceCode(rs.getString(COL_SPACE_CODE));
        fgmodcmscontent.setContentRefNo(rs.getString(COL_CONTENT_REF_NO));
        fgmodcmscontent.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgmodcmscontent.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgmodcmscontent.setName(rs.getString(COL_NAME));
        fgmodcmscontent.setTitle(rs.getString(COL_TITLE));
        fgmodcmscontent.setSubTitle(rs.getString(COL_SUB_TITLE));
        fgmodcmscontent.setDescription(rs.getString(COL_DESCRIPTION));
        fgmodcmscontent.setContentData(rs.getString(COL_CONTENT_DATA));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodcmscontent.setIsMasterVersion(IS_MASTER_VERSION);
        fgmodcmscontent.setPublishDate(rs.getString(COL_PUBLISH_DATE));
        fgmodcmscontent.setExpireDate(rs.getString(COL_EXPIRE_DATE));
        fgmodcmscontent.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmodcmscontent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodcmscontent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodcmscontent.setCreatedBy(CREATED_BY);
        fgmodcmscontent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodcmscontent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodcmscontent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodcmscontent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodcmscontent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgmodcmscontent;
    }
}
