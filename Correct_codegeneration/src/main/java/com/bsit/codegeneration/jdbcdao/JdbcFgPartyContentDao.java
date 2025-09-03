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

public class JdbcFgPartyContentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyContentDao.class);

    private static final String TABLE = "FG_PARTY_CONTENT";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARTY_SUB_TYPE = "PARTY_SUB_TYPE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_CONTENT_TYPE_CODE = "CONTENT_TYPE_CODE";

    private static final String COL_CONTENT_SUB_TYPE_CODE = "CONTENT_SUB_TYPE_CODE";

    private static final String COL_CONTENT_DOC_NO = "CONTENT_DOC_NO";

    private static final String COL_CONTENT_FILE_NAME = "CONTENT_FILE_NAME";

    private static final String COL_CONTENT_STORAGE_CODE = "CONTENT_STORAGE_CODE";

    private static final String COL_CONTENT_ATTACHMENT_ID = "CONTENT_ATTACHMENT_ID";

    private static final String COL_CONTENT_DMS_ID = "CONTENT_DMS_ID";

    private static final String COL_CONTENT_DMS_URL = "CONTENT_DMS_URL";

    private static final String COL_CONTENT_TAGS = "CONTENT_TAGS";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE, COL_PARTY_CODE, COL_CONTENT_TYPE_CODE, COL_CONTENT_SUB_TYPE_CODE, COL_CONTENT_DOC_NO, COL_CONTENT_FILE_NAME, COL_CONTENT_STORAGE_CODE, COL_CONTENT_ATTACHMENT_ID, COL_CONTENT_DMS_ID, COL_CONTENT_DMS_URL, COL_CONTENT_TAGS, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE, PARTY_CODE, CONTENT_TYPE_CODE, CONTENT_SUB_TYPE_CODE, CONTENT_DOC_NO, CONTENT_FILE_NAME, CONTENT_STORAGE_CODE, CONTENT_ATTACHMENT_ID, CONTENT_DMS_ID, CONTENT_DMS_URL, CONTENT_TAGS, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE, PARTY_CODE, CONTENT_TYPE_CODE, CONTENT_SUB_TYPE_CODE, CONTENT_DOC_NO, CONTENT_FILE_NAME, CONTENT_STORAGE_CODE, CONTENT_ATTACHMENT_ID, CONTENT_DMS_ID, CONTENT_DMS_URL, CONTENT_TAGS, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE, COL_PARTY_CODE, COL_CONTENT_TYPE_CODE, COL_CONTENT_SUB_TYPE_CODE, COL_CONTENT_DOC_NO, COL_CONTENT_FILE_NAME, COL_CONTENT_STORAGE_CODE, COL_CONTENT_ATTACHMENT_ID, COL_CONTENT_DMS_ID, COL_CONTENT_DMS_URL, COL_CONTENT_TAGS, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgPartyContent fgpartycontent) throws SQLException {
        logger.debug("Inserting fgpartycontent: {}", fgpartycontent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyContentParams(ps, fgpartycontent);
            ps.executeUpdate();
            return fgpartycontent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyContent> fgpartycontents) throws SQLException {
        if (fgpartycontents == null || fgpartycontents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartycontents.size(); i++) {
            if (fgpartycontents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyContent>> batches = chunkList(fgpartycontents, batchSize);
        int[] totalResults = new int[fgpartycontents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyContent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyContent fgpartycontent : batch) {
                        setFgPartyContentParams(ps, fgpartycontent);
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

    public FgPartyContent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyContent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyContent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyContent fgpartycontent) throws SQLException {
        if (fgpartycontent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyContentParams(ps, fgpartycontent);
            ps.setInt(23, fgpartycontent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyContent> fgpartycontents) throws SQLException {
        if (fgpartycontents == null || fgpartycontents.isEmpty())
            return new int[0];
        for (FgPartyContent fgpartycontent : fgpartycontents) {
            if (fgpartycontent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartycontent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyContent>> batches = chunkList(fgpartycontents, batchSize);
        int[] totalResults = new int[fgpartycontents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyContent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyContent fgpartycontent : batch) {
                        setFgPartyContentParams(ps, fgpartycontent);
                        ps.setInt(23, fgpartycontent.getID());
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

    private void setFgPartyContentParams(PreparedStatement ps, FgPartyContent fgpartycontent) throws SQLException {
        Integer val1 = fgpartycontent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpartycontent.getPartyID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgpartycontent.getPartyVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgpartycontent.getPartySubType());
        ps.setString(5, fgpartycontent.getPartyCode());
        ps.setString(6, fgpartycontent.getContentTypeCode());
        ps.setString(7, fgpartycontent.getContentSubTypeCode());
        ps.setString(8, fgpartycontent.getContentDocNo());
        ps.setString(9, fgpartycontent.getContentFileName());
        ps.setString(10, fgpartycontent.getContentStorageCode());
        Integer val11 = fgpartycontent.getContentAttachmentID();
        if (val11 != null) {
            ps.setInt(11, val11);
        } else {
            ps.setNull(11, Types.INTEGER);
        }
        Integer val12 = fgpartycontent.getContentDmsID();
        if (val12 != null) {
            ps.setInt(12, val12);
        } else {
            ps.setNull(12, Types.INTEGER);
        }
        ps.setString(13, fgpartycontent.getContentDmsURL());
        ps.setString(14, fgpartycontent.getContentTags());
        ps.setString(15, fgpartycontent.getComments());
        ps.setString(16, fgpartycontent.getActiveCode());
        ps.setString(17, fgpartycontent.getStatusCode());
        ps.setString(18, fgpartycontent.getCreatedOn());
        java.math.BigDecimal val19 = fgpartycontent.getCreatedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgpartycontent.getLastUpdatedOn());
        java.math.BigDecimal val21 = fgpartycontent.getLastUpdatedBy();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgpartycontent.getLastAuthorisedOn());
        java.math.BigDecimal val23 = fgpartycontent.getLastAuthorisedBy();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
    }

    private FgPartyContent extract(ResultSet rs) throws SQLException {
        FgPartyContent fgpartycontent = new FgPartyContent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartycontent.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartycontent.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartycontent.setPartyVersionID(PARTY_VERSION_ID);
        fgpartycontent.setPartySubType(rs.getString(COL_PARTY_SUB_TYPE));
        fgpartycontent.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgpartycontent.setContentTypeCode(rs.getString(COL_CONTENT_TYPE_CODE));
        fgpartycontent.setContentSubTypeCode(rs.getString(COL_CONTENT_SUB_TYPE_CODE));
        fgpartycontent.setContentDocNo(rs.getString(COL_CONTENT_DOC_NO));
        fgpartycontent.setContentFileName(rs.getString(COL_CONTENT_FILE_NAME));
        fgpartycontent.setContentStorageCode(rs.getString(COL_CONTENT_STORAGE_CODE));
        Integer CONTENT_ATTACHMENT_ID = rs.getObject(COL_CONTENT_ATTACHMENT_ID, Integer.class);
        fgpartycontent.setContentAttachmentID(CONTENT_ATTACHMENT_ID);
        Integer CONTENT_DMS_ID = rs.getObject(COL_CONTENT_DMS_ID, Integer.class);
        fgpartycontent.setContentDmsID(CONTENT_DMS_ID);
        fgpartycontent.setContentDmsURL(rs.getString(COL_CONTENT_DMS_URL));
        fgpartycontent.setContentTags(rs.getString(COL_CONTENT_TAGS));
        fgpartycontent.setComments(rs.getString(COL_COMMENTS));
        fgpartycontent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartycontent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartycontent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartycontent.setCreatedBy(CREATED_BY);
        fgpartycontent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartycontent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartycontent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartycontent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgpartycontent;
    }
}
