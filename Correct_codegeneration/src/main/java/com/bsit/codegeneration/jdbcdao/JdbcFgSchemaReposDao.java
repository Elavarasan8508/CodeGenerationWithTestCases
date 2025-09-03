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

public class JdbcFgSchemaReposDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSchemaReposDao.class);

    private static final String TABLE = "FG_SCHEMA_REPOS";

    private static final String COL_FILE_EXTENSION = "FILE_EXTENSION";

    private static final String COL_FILE_TYPE = "FILE_TYPE";

    private static final String COL_NAME = "NAME";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_CATEGORY = "CATEGORY";

    private static final String COL_CONTENT = "CONTENT";

    private static final String COL_ID = "ID";

    private static final String COL_CATEGORY_TYPE = "CATEGORY_TYPE";

    private static final String COL_CATEGORY_SUB_TYPE = "CATEGORY_SUB_TYPE";

    private static final String COL_TAGS = "TAGS";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_REFERENCE_ID, COL_CATEGORY, COL_CONTENT, COL_ID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, REFERENCE_ID, CATEGORY, CONTENT, ID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, STAGE_CODE, APPLICANT_PARTY_CODE", TABLE, COL_REFERENCE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, REFERENCE_ID, CATEGORY, CONTENT, ID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, STAGE_CODE, APPLICANT_PARTY_CODE", TABLE, COL_REFERENCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILE_EXTENSION, COL_FILE_TYPE, COL_NAME, COL_TEMPLATE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_CATEGORY, COL_CONTENT, COL_ID, COL_CATEGORY_TYPE, COL_CATEGORY_SUB_TYPE, COL_TAGS, COL_STAGE_CODE, COL_APPLICANT_PARTY_CODE, COL_REFERENCE_ID);

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

    public int insert(Connection conn, FgSchemaRepos fgschemarepos) throws SQLException {
        logger.debug("Inserting fgschemarepos: {}", fgschemarepos);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSchemaReposParams(ps, fgschemarepos);
            ps.executeUpdate();
            return fgschemarepos.getReferenceID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSchemaRepos> fgschemareposs) throws SQLException {
        if (fgschemareposs == null || fgschemareposs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgschemareposs.size(); i++) {
            if (fgschemareposs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSchemaRepos>> batches = chunkList(fgschemareposs, batchSize);
        int[] totalResults = new int[fgschemareposs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSchemaRepos> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSchemaRepos fgschemarepos : batch) {
                        setFgSchemaReposParams(ps, fgschemarepos);
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

    public FgSchemaRepos findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSchemaRepos> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSchemaRepos> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSchemaRepos fgschemarepos) throws SQLException {
        if (fgschemarepos.getReferenceID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSchemaReposParams(ps, fgschemarepos);
            ps.setInt(24, fgschemarepos.getReferenceID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSchemaRepos> fgschemareposs) throws SQLException {
        if (fgschemareposs == null || fgschemareposs.isEmpty())
            return new int[0];
        for (FgSchemaRepos fgschemarepos : fgschemareposs) {
            if (fgschemarepos == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgschemarepos.getReferenceID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSchemaRepos>> batches = chunkList(fgschemareposs, batchSize);
        int[] totalResults = new int[fgschemareposs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSchemaRepos> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSchemaRepos fgschemarepos : batch) {
                        setFgSchemaReposParams(ps, fgschemarepos);
                        ps.setInt(24, fgschemarepos.getReferenceID());
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

    private void setFgSchemaReposParams(PreparedStatement ps, FgSchemaRepos fgschemarepos) throws SQLException {
        ps.setString(1, fgschemarepos.getFileExtension());
        ps.setString(2, fgschemarepos.getFileType());
        ps.setString(3, fgschemarepos.getName());
        ps.setString(4, fgschemarepos.getTemplate());
        ps.setString(5, fgschemarepos.getTypeCode());
        ps.setString(6, fgschemarepos.getSubTypeCode());
        ps.setString(7, fgschemarepos.getDescription());
        ps.setString(8, fgschemarepos.getActiveCode());
        ps.setString(9, fgschemarepos.getStatusCode());
        ps.setString(10, fgschemarepos.getCreatedOn());
        java.math.BigDecimal val11 = fgschemarepos.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgschemarepos.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgschemarepos.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgschemarepos.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgschemarepos.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgschemarepos.getReferenceID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        ps.setString(17, fgschemarepos.getCategory());
        ps.setString(18, fgschemarepos.getContent());
        Integer val19 = fgschemarepos.getID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgschemarepos.getCategoryType());
        ps.setString(21, fgschemarepos.getCategorySubType());
        ps.setString(22, fgschemarepos.getTags());
        ps.setString(23, fgschemarepos.getStageCode());
        ps.setString(24, fgschemarepos.getApplicantPartyCode());
    }

    private FgSchemaRepos extract(ResultSet rs) throws SQLException {
        FgSchemaRepos fgschemarepos = new FgSchemaRepos();
        fgschemarepos.setFileExtension(rs.getString(COL_FILE_EXTENSION));
        fgschemarepos.setFileType(rs.getString(COL_FILE_TYPE));
        fgschemarepos.setName(rs.getString(COL_NAME));
        fgschemarepos.setTemplate(rs.getString(COL_TEMPLATE));
        fgschemarepos.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgschemarepos.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgschemarepos.setDescription(rs.getString(COL_DESCRIPTION));
        fgschemarepos.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgschemarepos.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgschemarepos.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgschemarepos.setCreatedBy(CREATED_BY);
        fgschemarepos.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgschemarepos.setLastUpdatedBy(LAST_UPDATED_BY);
        fgschemarepos.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgschemarepos.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgschemarepos.setReferenceID(REFERENCE_ID);
        fgschemarepos.setCategory(rs.getString(COL_CATEGORY));
        fgschemarepos.setContent(rs.getString(COL_CONTENT));
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgschemarepos.setID(ID);
        fgschemarepos.setCategoryType(rs.getString(COL_CATEGORY_TYPE));
        fgschemarepos.setCategorySubType(rs.getString(COL_CATEGORY_SUB_TYPE));
        fgschemarepos.setTags(rs.getString(COL_TAGS));
        fgschemarepos.setStageCode(rs.getString(COL_STAGE_CODE));
        fgschemarepos.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        return fgschemarepos;
    }
}
