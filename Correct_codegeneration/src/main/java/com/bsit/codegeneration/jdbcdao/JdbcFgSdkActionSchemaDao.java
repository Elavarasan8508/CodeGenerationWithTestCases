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

public class JdbcFgSdkActionSchemaDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkActionSchemaDao.class);

    private static final String TABLE = "FG_SDK_ACTION_SCHEMA";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_NAME = "NAME";

    private static final String COL_SOURCE_PRODUCT = "SOURCE_PRODUCT";

    private static final String COL_TAGS = "TAGS";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_DATASETID = "DATASETID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_SOURCE_PRODUCT, COL_TAGS, COL_DESCRIPTION, COL_DATASETID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, SOURCE_PRODUCT, TAGS, DESCRIPTION, DATASETID", TABLE, COL_REFERENCE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, SOURCE_PRODUCT, TAGS, DESCRIPTION, DATASETID", TABLE, COL_REFERENCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_SOURCE_PRODUCT, COL_TAGS, COL_DESCRIPTION, COL_DATASETID, COL_REFERENCE_ID);

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

    public int insert(Connection conn, FgSdkActionSchema fgsdkactionschema) throws SQLException {
        logger.debug("Inserting fgsdkactionschema: {}", fgsdkactionschema);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkActionSchemaParams(ps, fgsdkactionschema);
            ps.executeUpdate();
            return fgsdkactionschema.getReferenceID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkActionSchema> fgsdkactionschemas) throws SQLException {
        if (fgsdkactionschemas == null || fgsdkactionschemas.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkactionschemas.size(); i++) {
            if (fgsdkactionschemas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkActionSchema>> batches = chunkList(fgsdkactionschemas, batchSize);
        int[] totalResults = new int[fgsdkactionschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkActionSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkActionSchema fgsdkactionschema : batch) {
                        setFgSdkActionSchemaParams(ps, fgsdkactionschema);
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

    public FgSdkActionSchema findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkActionSchema> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkActionSchema> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkActionSchema fgsdkactionschema) throws SQLException {
        if (fgsdkactionschema.getReferenceID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkActionSchemaParams(ps, fgsdkactionschema);
            ps.setInt(22, fgsdkactionschema.getReferenceID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkActionSchema> fgsdkactionschemas) throws SQLException {
        if (fgsdkactionschemas == null || fgsdkactionschemas.isEmpty())
            return new int[0];
        for (FgSdkActionSchema fgsdkactionschema : fgsdkactionschemas) {
            if (fgsdkactionschema == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkactionschema.getReferenceID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkActionSchema>> batches = chunkList(fgsdkactionschemas, batchSize);
        int[] totalResults = new int[fgsdkactionschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkActionSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkActionSchema fgsdkactionschema : batch) {
                        setFgSdkActionSchemaParams(ps, fgsdkactionschema);
                        ps.setInt(22, fgsdkactionschema.getReferenceID());
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

    private void setFgSdkActionSchemaParams(PreparedStatement ps, FgSdkActionSchema fgsdkactionschema) throws SQLException {
        Integer val1 = fgsdkactionschema.getReferenceID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgsdkactionschema.getApplicantPartyCode());
        Integer val3 = fgsdkactionschema.getApplicantRefID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgsdkactionschema.getIssuingPartyCode());
        ps.setString(5, fgsdkactionschema.getTypeCode());
        ps.setString(6, fgsdkactionschema.getSubTypeCode());
        ps.setString(7, fgsdkactionschema.getActiveCode());
        ps.setString(8, fgsdkactionschema.getStageCode());
        ps.setString(9, fgsdkactionschema.getStatusCode());
        ps.setString(10, fgsdkactionschema.getCreatedOn());
        java.math.BigDecimal val11 = fgsdkactionschema.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgsdkactionschema.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgsdkactionschema.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgsdkactionschema.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgsdkactionschema.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgsdkactionschema.getTemplate());
        java.math.BigDecimal val17 = fgsdkactionschema.getIsTemplate();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgsdkactionschema.getName());
        ps.setString(19, fgsdkactionschema.getSourceProduct());
        ps.setString(20, fgsdkactionschema.getTags());
        ps.setString(21, fgsdkactionschema.getDescription());
        ps.setString(22, fgsdkactionschema.getDatasetid());
    }

    private FgSdkActionSchema extract(ResultSet rs) throws SQLException {
        FgSdkActionSchema fgsdkactionschema = new FgSdkActionSchema();
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkactionschema.setReferenceID(REFERENCE_ID);
        fgsdkactionschema.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgsdkactionschema.setApplicantRefID(APPLICANT_REF_ID);
        fgsdkactionschema.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgsdkactionschema.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkactionschema.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkactionschema.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkactionschema.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkactionschema.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsdkactionschema.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkactionschema.setCreatedBy(CREATED_BY);
        fgsdkactionschema.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkactionschema.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkactionschema.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkactionschema.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkactionschema.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkactionschema.setIsTemplate(IS_TEMPLATE);
        fgsdkactionschema.setName(rs.getString(COL_NAME));
        fgsdkactionschema.setSourceProduct(rs.getString(COL_SOURCE_PRODUCT));
        fgsdkactionschema.setTags(rs.getString(COL_TAGS));
        fgsdkactionschema.setDescription(rs.getString(COL_DESCRIPTION));
        fgsdkactionschema.setDatasetid(rs.getString(COL_DATASETID));
        return fgsdkactionschema;
    }
}
