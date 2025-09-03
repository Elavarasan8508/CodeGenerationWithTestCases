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

public class JdbcFgDmsContentCopyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDmsContentCopyDao.class);

    private static final String TABLE = "FG_DMS_CONTENT_COPY";

    private static final String COL_ID = "ID";

    private static final String COL_DMS_DOC_PATH = "DMS_DOC_PATH";

    private static final String COL_DMS_DOC_REFERENCE_ID = "DMS_DOC_REFERENCE_ID";

    private static final String COL_FILE_CONTENT = "FILE_CONTENT";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FILE_SIZE = "FILE_SIZE";

    private static final String COL_FILE_TYPE = "FILE_TYPE";

    private static final String COL_TITLE = "TITLE";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_FILE_PURPOSE_CODE = "FILE_PURPOSE_CODE";

    private static final String COL_DMS_REFERENCE = "DMS_REFERENCE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_DMS_DOC_PATH, COL_DMS_DOC_REFERENCE_ID, COL_FILE_CONTENT, COL_FILE_NAME, COL_FILE_SIZE, COL_FILE_TYPE, COL_TITLE, COL_DMS_EVENT_ID, COL_DESCRIPTION, COL_FILE_PURPOSE_CODE, COL_DMS_REFERENCE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DMS_DOC_PATH, COL_DMS_DOC_REFERENCE_ID, COL_FILE_CONTENT, COL_FILE_NAME, COL_FILE_SIZE, COL_FILE_TYPE, COL_TITLE, COL_DMS_EVENT_ID, COL_DESCRIPTION, COL_FILE_PURPOSE_CODE, COL_DMS_REFERENCE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgDmsContentCopy fgdmscontentcopy) throws SQLException {
        logger.debug("Inserting fgdmscontentcopy: {}", fgdmscontentcopy);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDmsContentCopyParams(ps, fgdmscontentcopy);
            ps.executeUpdate();
            return fgdmscontentcopy.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDmsContentCopy> fgdmscontentcopys) throws SQLException {
        if (fgdmscontentcopys == null || fgdmscontentcopys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgdmscontentcopys.size(); i++) {
            if (fgdmscontentcopys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDmsContentCopy>> batches = chunkList(fgdmscontentcopys, batchSize);
        int[] totalResults = new int[fgdmscontentcopys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDmsContentCopy> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDmsContentCopy fgdmscontentcopy : batch) {
                        setFgDmsContentCopyParams(ps, fgdmscontentcopy);
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

    public FgDmsContentCopy findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDmsContentCopy> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDmsContentCopy> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDmsContentCopy fgdmscontentcopy) throws SQLException {
        if (fgdmscontentcopy.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDmsContentCopyParams(ps, fgdmscontentcopy);
            ps.setInt(20, fgdmscontentcopy.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDmsContentCopy> fgdmscontentcopys) throws SQLException {
        if (fgdmscontentcopys == null || fgdmscontentcopys.isEmpty())
            return new int[0];
        for (FgDmsContentCopy fgdmscontentcopy : fgdmscontentcopys) {
            if (fgdmscontentcopy == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdmscontentcopy.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDmsContentCopy>> batches = chunkList(fgdmscontentcopys, batchSize);
        int[] totalResults = new int[fgdmscontentcopys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDmsContentCopy> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDmsContentCopy fgdmscontentcopy : batch) {
                        setFgDmsContentCopyParams(ps, fgdmscontentcopy);
                        ps.setInt(20, fgdmscontentcopy.getID());
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

    private void setFgDmsContentCopyParams(PreparedStatement ps, FgDmsContentCopy fgdmscontentcopy) throws SQLException {
        Integer val1 = fgdmscontentcopy.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgdmscontentcopy.getDmsDocPath());
        Integer val3 = fgdmscontentcopy.getDmsDocReferenceID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setBytes(4, fgdmscontentcopy.getFileContent());
        ps.setString(5, fgdmscontentcopy.getFileName());
        ps.setString(6, fgdmscontentcopy.getFileSize());
        ps.setString(7, fgdmscontentcopy.getFileType());
        ps.setString(8, fgdmscontentcopy.getTitle());
        Integer val9 = fgdmscontentcopy.getDmsEventID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, fgdmscontentcopy.getDescription());
        ps.setString(11, fgdmscontentcopy.getFilePurposeCode());
        ps.setString(12, fgdmscontentcopy.getDmsReference());
        ps.setString(13, fgdmscontentcopy.getActiveCode());
        ps.setString(14, fgdmscontentcopy.getStatusCode());
        ps.setString(15, fgdmscontentcopy.getCreatedOn());
        java.math.BigDecimal val16 = fgdmscontentcopy.getCreatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgdmscontentcopy.getLastUpdatedOn());
        java.math.BigDecimal val18 = fgdmscontentcopy.getLastUpdatedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgdmscontentcopy.getLastAuthorisedOn());
        java.math.BigDecimal val20 = fgdmscontentcopy.getLastAuthorisedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
    }

    private FgDmsContentCopy extract(ResultSet rs) throws SQLException {
        FgDmsContentCopy fgdmscontentcopy = new FgDmsContentCopy();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdmscontentcopy.setID(ID);
        fgdmscontentcopy.setDmsDocPath(rs.getString(COL_DMS_DOC_PATH));
        Integer DMS_DOC_REFERENCE_ID = rs.getObject(COL_DMS_DOC_REFERENCE_ID, Integer.class);
        fgdmscontentcopy.setDmsDocReferenceID(DMS_DOC_REFERENCE_ID);
        fgdmscontentcopy.setFileContent(rs.getBytes(COL_FILE_CONTENT));
        fgdmscontentcopy.setFileName(rs.getString(COL_FILE_NAME));
        fgdmscontentcopy.setFileSize(rs.getString(COL_FILE_SIZE));
        fgdmscontentcopy.setFileType(rs.getString(COL_FILE_TYPE));
        fgdmscontentcopy.setTitle(rs.getString(COL_TITLE));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgdmscontentcopy.setDmsEventID(DMS_EVENT_ID);
        fgdmscontentcopy.setDescription(rs.getString(COL_DESCRIPTION));
        fgdmscontentcopy.setFilePurposeCode(rs.getString(COL_FILE_PURPOSE_CODE));
        fgdmscontentcopy.setDmsReference(rs.getString(COL_DMS_REFERENCE));
        fgdmscontentcopy.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdmscontentcopy.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdmscontentcopy.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdmscontentcopy.setCreatedBy(CREATED_BY);
        fgdmscontentcopy.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdmscontentcopy.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdmscontentcopy.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdmscontentcopy.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgdmscontentcopy;
    }
}
