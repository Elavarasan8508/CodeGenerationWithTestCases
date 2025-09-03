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

public class JdbcFgSdkBotIntentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkBotIntentDao.class);

    private static final String TABLE = "FG_SDK_BOT_INTENT";

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

    private static final String COL_INTENT_MODEL = "INTENT_MODEL";

    private static final String COL_INTENT_NAME = "INTENT_NAME";

    private static final String COL_PARENT_INTENT = "PARENT_INTENT";

    private static final String COL_DATASET = "DATASET";

    private static final String COL_INTENT_TYPE = "INTENT_TYPE";

    private static final String COL_AUTHORIZATION = "AUTHORIZATION";

    private static final String COL_SHOW = "SHOW";

    private static final String COL_PROMPT = "PROMPT";

    private static final String COL_PHRASE_NAME = "PHRASE_NAME";

    private static final String COL_PHRASE_STATUS = "PHRASE_STATUS";

    private static final String COL_PARAMETER_FIELD = "PARAMETER_FIELD";

    private static final String COL_PARAMETER_DATATYPE = "PARAMETER_DATATYPE";

    private static final String COL_PARAMETER = "PARAMETER";

    private static final String COL_PARAMETER_STATUS = "PARAMETER_STATUS";

    private static final String COL_INPUT = "INPUT";

    private static final String COL_REQUIRED = "REQUIRED";

    private static final String COL_API_METHOD = "API_METHOD";

    private static final String COL_CONTENT = "CONTENT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INTENT_MODEL, COL_INTENT_NAME, COL_PARENT_INTENT, COL_DATASET, COL_INTENT_TYPE, COL_AUTHORIZATION, COL_SHOW, COL_PROMPT, COL_PHRASE_NAME, COL_PHRASE_STATUS, COL_PARAMETER_FIELD, COL_PARAMETER_DATATYPE, COL_PARAMETER, COL_PARAMETER_STATUS, COL_INPUT, COL_REQUIRED, COL_API_METHOD, COL_CONTENT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INTENT_MODEL, INTENT_NAME, PARENT_INTENT, DATASET, INTENT_TYPE, AUTHORIZATION, SHOW, PROMPT, PHRASE_NAME, PHRASE_STATUS, PARAMETER_FIELD, PARAMETER_DATATYPE, PARAMETER, PARAMETER_STATUS, INPUT, REQUIRED, API_METHOD, CONTENT, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INTENT_MODEL, INTENT_NAME, PARENT_INTENT, DATASET, INTENT_TYPE, AUTHORIZATION, SHOW, PROMPT, PHRASE_NAME, PHRASE_STATUS, PARAMETER_FIELD, PARAMETER_DATATYPE, PARAMETER, PARAMETER_STATUS, INPUT, REQUIRED, API_METHOD, CONTENT, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INTENT_MODEL, COL_INTENT_NAME, COL_PARENT_INTENT, COL_DATASET, COL_INTENT_TYPE, COL_AUTHORIZATION, COL_SHOW, COL_PROMPT, COL_PHRASE_NAME, COL_PHRASE_STATUS, COL_PARAMETER_FIELD, COL_PARAMETER_DATATYPE, COL_PARAMETER, COL_PARAMETER_STATUS, COL_INPUT, COL_REQUIRED, COL_API_METHOD, COL_CONTENT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgSdkBotIntent fgsdkbotintent) throws SQLException {
        logger.debug("Inserting fgsdkbotintent: {}", fgsdkbotintent);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkBotIntentParams(ps, fgsdkbotintent);
            ps.executeUpdate();
            return fgsdkbotintent.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkBotIntent> fgsdkbotintents) throws SQLException {
        if (fgsdkbotintents == null || fgsdkbotintents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkbotintents.size(); i++) {
            if (fgsdkbotintents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkBotIntent>> batches = chunkList(fgsdkbotintents, batchSize);
        int[] totalResults = new int[fgsdkbotintents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkBotIntent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkBotIntent fgsdkbotintent : batch) {
                        setFgSdkBotIntentParams(ps, fgsdkbotintent);
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

    public FgSdkBotIntent findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkBotIntent> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkBotIntent> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkBotIntent fgsdkbotintent) throws SQLException {
        if (fgsdkbotintent.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkBotIntentParams(ps, fgsdkbotintent);
            ps.setInt(38, fgsdkbotintent.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkBotIntent> fgsdkbotintents) throws SQLException {
        if (fgsdkbotintents == null || fgsdkbotintents.isEmpty())
            return new int[0];
        for (FgSdkBotIntent fgsdkbotintent : fgsdkbotintents) {
            if (fgsdkbotintent == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkbotintent.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkBotIntent>> batches = chunkList(fgsdkbotintents, batchSize);
        int[] totalResults = new int[fgsdkbotintents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkBotIntent> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkBotIntent fgsdkbotintent : batch) {
                        setFgSdkBotIntentParams(ps, fgsdkbotintent);
                        ps.setInt(38, fgsdkbotintent.getID());
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

    private void setFgSdkBotIntentParams(PreparedStatement ps, FgSdkBotIntent fgsdkbotintent) throws SQLException {
        Integer val1 = fgsdkbotintent.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkbotintent.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkbotintent.getApplicantPartyCode());
        Integer val4 = fgsdkbotintent.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgsdkbotintent.getIssuingPartyCode());
        ps.setString(6, fgsdkbotintent.getTypeCode());
        ps.setString(7, fgsdkbotintent.getSubTypeCode());
        ps.setString(8, fgsdkbotintent.getActiveCode());
        ps.setString(9, fgsdkbotintent.getStageCode());
        ps.setString(10, fgsdkbotintent.getStatusCode());
        ps.setString(11, fgsdkbotintent.getCreatedOn());
        java.math.BigDecimal val12 = fgsdkbotintent.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkbotintent.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgsdkbotintent.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkbotintent.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgsdkbotintent.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgsdkbotintent.getTemplate());
        java.math.BigDecimal val18 = fgsdkbotintent.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsdkbotintent.getIntentModel());
        ps.setString(20, fgsdkbotintent.getIntentName());
        ps.setString(21, fgsdkbotintent.getParentIntent());
        ps.setString(22, fgsdkbotintent.getDataset());
        ps.setString(23, fgsdkbotintent.getIntentType());
        java.math.BigDecimal val24 = fgsdkbotintent.getAuthorization();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgsdkbotintent.getShow();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgsdkbotintent.getPrompt());
        ps.setString(27, fgsdkbotintent.getPhraseName());
        ps.setString(28, fgsdkbotintent.getPhraseStatus());
        ps.setString(29, fgsdkbotintent.getParameterField());
        ps.setString(30, fgsdkbotintent.getParameterDatatype());
        ps.setString(31, fgsdkbotintent.getParameter());
        ps.setString(32, fgsdkbotintent.getParameterStatus());
        java.math.BigDecimal val33 = fgsdkbotintent.getInput();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgsdkbotintent.getRequired();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fgsdkbotintent.getAPIMethod());
        ps.setString(36, fgsdkbotintent.getContent());
        Integer val37 = fgsdkbotintent.getParentRefID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        Integer val38 = fgsdkbotintent.getParentVersionID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
    }

    private FgSdkBotIntent extract(ResultSet rs) throws SQLException {
        FgSdkBotIntent fgsdkbotintent = new FgSdkBotIntent();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkbotintent.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkbotintent.setReferenceID(REFERENCE_ID);
        fgsdkbotintent.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgsdkbotintent.setApplicantRefID(APPLICANT_REF_ID);
        fgsdkbotintent.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgsdkbotintent.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkbotintent.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkbotintent.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkbotintent.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkbotintent.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsdkbotintent.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkbotintent.setCreatedBy(CREATED_BY);
        fgsdkbotintent.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkbotintent.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkbotintent.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkbotintent.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkbotintent.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkbotintent.setIsTemplate(IS_TEMPLATE);
        fgsdkbotintent.setIntentModel(rs.getString(COL_INTENT_MODEL));
        fgsdkbotintent.setIntentName(rs.getString(COL_INTENT_NAME));
        fgsdkbotintent.setParentIntent(rs.getString(COL_PARENT_INTENT));
        fgsdkbotintent.setDataset(rs.getString(COL_DATASET));
        fgsdkbotintent.setIntentType(rs.getString(COL_INTENT_TYPE));
        java.math.BigDecimal AUTHORIZATION = rs.getObject(COL_AUTHORIZATION, java.math.BigDecimal.class);
        fgsdkbotintent.setAuthorization(AUTHORIZATION);
        java.math.BigDecimal SHOW = rs.getObject(COL_SHOW, java.math.BigDecimal.class);
        fgsdkbotintent.setShow(SHOW);
        fgsdkbotintent.setPrompt(rs.getString(COL_PROMPT));
        fgsdkbotintent.setPhraseName(rs.getString(COL_PHRASE_NAME));
        fgsdkbotintent.setPhraseStatus(rs.getString(COL_PHRASE_STATUS));
        fgsdkbotintent.setParameterField(rs.getString(COL_PARAMETER_FIELD));
        fgsdkbotintent.setParameterDatatype(rs.getString(COL_PARAMETER_DATATYPE));
        fgsdkbotintent.setParameter(rs.getString(COL_PARAMETER));
        fgsdkbotintent.setParameterStatus(rs.getString(COL_PARAMETER_STATUS));
        java.math.BigDecimal INPUT = rs.getObject(COL_INPUT, java.math.BigDecimal.class);
        fgsdkbotintent.setInput(INPUT);
        java.math.BigDecimal REQUIRED = rs.getObject(COL_REQUIRED, java.math.BigDecimal.class);
        fgsdkbotintent.setRequired(REQUIRED);
        fgsdkbotintent.setAPIMethod(rs.getString(COL_API_METHOD));
        fgsdkbotintent.setContent(rs.getString(COL_CONTENT));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgsdkbotintent.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgsdkbotintent.setParentVersionID(PARENT_VERSION_ID);
        return fgsdkbotintent;
    }
}
