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

public class JdbcFgSdkDocTemplateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkDocTemplateDao.class);

    private static final String TABLE = "FG_SDK_DOC_TEMPLATE";

    private static final String COL_ID = "ID";

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

    private static final String COL_PURPOSE = "PURPOSE";

    private static final String COL_RENDER_TYPE = "RENDER_TYPE";

    private static final String COL_PARENT_TYPE = "PARENT_TYPE";

    private static final String COL_IS_DEFAULT = "IS_DEFAULT";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TEMPLATE_TYPE = "TEMPLATE_TYPE";

    private static final String COL_SAMPLE_JSON = "SAMPLE_JSON";

    private static final String COL_DOC_TEMPLATE = "DOC_TEMPLATE";

    private static final String COL_NAME = "NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE, COL_RENDER_TYPE, COL_PARENT_TYPE, COL_IS_DEFAULT, COL_DESCRIPTION, COL_TEMPLATE_TYPE, COL_SAMPLE_JSON, COL_DOC_TEMPLATE, COL_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE, RENDER_TYPE, PARENT_TYPE, IS_DEFAULT, DESCRIPTION, TEMPLATE_TYPE, SAMPLE_JSON, DOC_TEMPLATE, NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE, RENDER_TYPE, PARENT_TYPE, IS_DEFAULT, DESCRIPTION, TEMPLATE_TYPE, SAMPLE_JSON, DOC_TEMPLATE, NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE, COL_RENDER_TYPE, COL_PARENT_TYPE, COL_IS_DEFAULT, COL_DESCRIPTION, COL_TEMPLATE_TYPE, COL_SAMPLE_JSON, COL_DOC_TEMPLATE, COL_NAME, COL_ID);

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

    public int insert(Connection conn, FgSdkDocTemplate fgsdkdoctemplate) throws SQLException {
        logger.debug("Inserting fgsdkdoctemplate: {}", fgsdkdoctemplate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkDocTemplateParams(ps, fgsdkdoctemplate);
            ps.executeUpdate();
            return fgsdkdoctemplate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkDocTemplate> fgsdkdoctemplates) throws SQLException {
        if (fgsdkdoctemplates == null || fgsdkdoctemplates.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkdoctemplates.size(); i++) {
            if (fgsdkdoctemplates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkDocTemplate>> batches = chunkList(fgsdkdoctemplates, batchSize);
        int[] totalResults = new int[fgsdkdoctemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkDocTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkDocTemplate fgsdkdoctemplate : batch) {
                        setFgSdkDocTemplateParams(ps, fgsdkdoctemplate);
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

    public FgSdkDocTemplate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkDocTemplate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkDocTemplate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkDocTemplate fgsdkdoctemplate) throws SQLException {
        if (fgsdkdoctemplate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkDocTemplateParams(ps, fgsdkdoctemplate);
            ps.setInt(27, fgsdkdoctemplate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkDocTemplate> fgsdkdoctemplates) throws SQLException {
        if (fgsdkdoctemplates == null || fgsdkdoctemplates.isEmpty())
            return new int[0];
        for (FgSdkDocTemplate fgsdkdoctemplate : fgsdkdoctemplates) {
            if (fgsdkdoctemplate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkdoctemplate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkDocTemplate>> batches = chunkList(fgsdkdoctemplates, batchSize);
        int[] totalResults = new int[fgsdkdoctemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkDocTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkDocTemplate fgsdkdoctemplate : batch) {
                        setFgSdkDocTemplateParams(ps, fgsdkdoctemplate);
                        ps.setInt(27, fgsdkdoctemplate.getID());
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

    private void setFgSdkDocTemplateParams(PreparedStatement ps, FgSdkDocTemplate fgsdkdoctemplate) throws SQLException {
        Integer val1 = fgsdkdoctemplate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkdoctemplate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkdoctemplate.getApplicantPartyCode());
        Integer val4 = fgsdkdoctemplate.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgsdkdoctemplate.getIssuingPartyCode());
        ps.setString(6, fgsdkdoctemplate.getTypeCode());
        ps.setString(7, fgsdkdoctemplate.getSubTypeCode());
        ps.setString(8, fgsdkdoctemplate.getActiveCode());
        ps.setString(9, fgsdkdoctemplate.getStageCode());
        ps.setString(10, fgsdkdoctemplate.getStatusCode());
        ps.setString(11, fgsdkdoctemplate.getCreatedOn());
        java.math.BigDecimal val12 = fgsdkdoctemplate.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkdoctemplate.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgsdkdoctemplate.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkdoctemplate.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgsdkdoctemplate.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgsdkdoctemplate.getTemplate());
        java.math.BigDecimal val18 = fgsdkdoctemplate.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsdkdoctemplate.getPurpose());
        ps.setString(20, fgsdkdoctemplate.getRenderType());
        ps.setString(21, fgsdkdoctemplate.getParentType());
        java.math.BigDecimal val22 = fgsdkdoctemplate.getIsDefault();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgsdkdoctemplate.getDescription());
        ps.setString(24, fgsdkdoctemplate.getTemplateType());
        ps.setString(25, fgsdkdoctemplate.getSampleJson());
        ps.setString(26, fgsdkdoctemplate.getDocTemplate());
        ps.setString(27, fgsdkdoctemplate.getName());
    }

    private FgSdkDocTemplate extract(ResultSet rs) throws SQLException {
        FgSdkDocTemplate fgsdkdoctemplate = new FgSdkDocTemplate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkdoctemplate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkdoctemplate.setReferenceID(REFERENCE_ID);
        fgsdkdoctemplate.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgsdkdoctemplate.setApplicantRefID(APPLICANT_REF_ID);
        fgsdkdoctemplate.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgsdkdoctemplate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkdoctemplate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkdoctemplate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkdoctemplate.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkdoctemplate.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsdkdoctemplate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkdoctemplate.setCreatedBy(CREATED_BY);
        fgsdkdoctemplate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkdoctemplate.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkdoctemplate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkdoctemplate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkdoctemplate.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkdoctemplate.setIsTemplate(IS_TEMPLATE);
        fgsdkdoctemplate.setPurpose(rs.getString(COL_PURPOSE));
        fgsdkdoctemplate.setRenderType(rs.getString(COL_RENDER_TYPE));
        fgsdkdoctemplate.setParentType(rs.getString(COL_PARENT_TYPE));
        java.math.BigDecimal IS_DEFAULT = rs.getObject(COL_IS_DEFAULT, java.math.BigDecimal.class);
        fgsdkdoctemplate.setIsDefault(IS_DEFAULT);
        fgsdkdoctemplate.setDescription(rs.getString(COL_DESCRIPTION));
        fgsdkdoctemplate.setTemplateType(rs.getString(COL_TEMPLATE_TYPE));
        fgsdkdoctemplate.setSampleJson(rs.getString(COL_SAMPLE_JSON));
        fgsdkdoctemplate.setDocTemplate(rs.getString(COL_DOC_TEMPLATE));
        fgsdkdoctemplate.setName(rs.getString(COL_NAME));
        return fgsdkdoctemplate;
    }
}
