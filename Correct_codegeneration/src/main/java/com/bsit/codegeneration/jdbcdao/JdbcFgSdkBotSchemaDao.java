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

public class JdbcFgSdkBotSchemaDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSdkBotSchemaDao.class);

    private static final String TABLE = "FG_SDK_BOT_SCHEMA";

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

    private static final String COL_BOT_NAME = "BOT_NAME";

    private static final String COL_VERSION = "VERSION";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_LANGUAGE = "LANGUAGE";

    private static final String COL_PUBLISH_DATE = "PUBLISH_DATE";

    private static final String COL_SESSION_TIME_OUT = "SESSION_TIME_OUT";

    private static final String COL_IDLE_TIME_OUT = "IDLE_TIME_OUT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOT_NAME, COL_VERSION, COL_STATUS, COL_DESCRIPTION, COL_LANGUAGE, COL_PUBLISH_DATE, COL_SESSION_TIME_OUT, COL_IDLE_TIME_OUT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOT_NAME, VERSION, STATUS, DESCRIPTION, LANGUAGE, PUBLISH_DATE, SESSION_TIME_OUT, IDLE_TIME_OUT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOT_NAME, VERSION, STATUS, DESCRIPTION, LANGUAGE, PUBLISH_DATE, SESSION_TIME_OUT, IDLE_TIME_OUT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOT_NAME, COL_VERSION, COL_STATUS, COL_DESCRIPTION, COL_LANGUAGE, COL_PUBLISH_DATE, COL_SESSION_TIME_OUT, COL_IDLE_TIME_OUT, COL_ID);

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

    public int insert(Connection conn, FgSdkBotSchema fgsdkbotschema) throws SQLException {
        logger.debug("Inserting fgsdkbotschema: {}", fgsdkbotschema);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSdkBotSchemaParams(ps, fgsdkbotschema);
            ps.executeUpdate();
            return fgsdkbotschema.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSdkBotSchema> fgsdkbotschemas) throws SQLException {
        if (fgsdkbotschemas == null || fgsdkbotschemas.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsdkbotschemas.size(); i++) {
            if (fgsdkbotschemas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkBotSchema>> batches = chunkList(fgsdkbotschemas, batchSize);
        int[] totalResults = new int[fgsdkbotschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkBotSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSdkBotSchema fgsdkbotschema : batch) {
                        setFgSdkBotSchemaParams(ps, fgsdkbotschema);
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

    public FgSdkBotSchema findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSdkBotSchema> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSdkBotSchema> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSdkBotSchema fgsdkbotschema) throws SQLException {
        if (fgsdkbotschema.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSdkBotSchemaParams(ps, fgsdkbotschema);
            ps.setInt(26, fgsdkbotschema.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSdkBotSchema> fgsdkbotschemas) throws SQLException {
        if (fgsdkbotschemas == null || fgsdkbotschemas.isEmpty())
            return new int[0];
        for (FgSdkBotSchema fgsdkbotschema : fgsdkbotschemas) {
            if (fgsdkbotschema == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsdkbotschema.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSdkBotSchema>> batches = chunkList(fgsdkbotschemas, batchSize);
        int[] totalResults = new int[fgsdkbotschemas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSdkBotSchema> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSdkBotSchema fgsdkbotschema : batch) {
                        setFgSdkBotSchemaParams(ps, fgsdkbotschema);
                        ps.setInt(26, fgsdkbotschema.getID());
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

    private void setFgSdkBotSchemaParams(PreparedStatement ps, FgSdkBotSchema fgsdkbotschema) throws SQLException {
        Integer val1 = fgsdkbotschema.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsdkbotschema.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsdkbotschema.getApplicantPartyCode());
        Integer val4 = fgsdkbotschema.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgsdkbotschema.getIssuingPartyCode());
        ps.setString(6, fgsdkbotschema.getTypeCode());
        ps.setString(7, fgsdkbotschema.getSubTypeCode());
        ps.setString(8, fgsdkbotschema.getActiveCode());
        ps.setString(9, fgsdkbotschema.getStageCode());
        ps.setString(10, fgsdkbotschema.getStatusCode());
        ps.setString(11, fgsdkbotschema.getCreatedOn());
        java.math.BigDecimal val12 = fgsdkbotschema.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsdkbotschema.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgsdkbotschema.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsdkbotschema.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgsdkbotschema.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgsdkbotschema.getTemplate());
        java.math.BigDecimal val18 = fgsdkbotschema.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsdkbotschema.getBotName());
        ps.setString(20, fgsdkbotschema.getVersion());
        ps.setString(21, fgsdkbotschema.getStatus());
        ps.setString(22, fgsdkbotschema.getDescription());
        ps.setString(23, fgsdkbotschema.getLanguage());
        java.time.LocalDateTime val24 = fgsdkbotschema.getPublishDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        ps.setString(25, fgsdkbotschema.getSessionTimeOut());
        ps.setString(26, fgsdkbotschema.getIdleTimeOut());
    }

    private FgSdkBotSchema extract(ResultSet rs) throws SQLException {
        FgSdkBotSchema fgsdkbotschema = new FgSdkBotSchema();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsdkbotschema.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsdkbotschema.setReferenceID(REFERENCE_ID);
        fgsdkbotschema.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgsdkbotschema.setApplicantRefID(APPLICANT_REF_ID);
        fgsdkbotschema.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgsdkbotschema.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsdkbotschema.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsdkbotschema.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsdkbotschema.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsdkbotschema.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsdkbotschema.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsdkbotschema.setCreatedBy(CREATED_BY);
        fgsdkbotschema.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsdkbotschema.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsdkbotschema.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsdkbotschema.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsdkbotschema.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsdkbotschema.setIsTemplate(IS_TEMPLATE);
        fgsdkbotschema.setBotName(rs.getString(COL_BOT_NAME));
        fgsdkbotschema.setVersion(rs.getString(COL_VERSION));
        fgsdkbotschema.setStatus(rs.getString(COL_STATUS));
        fgsdkbotschema.setDescription(rs.getString(COL_DESCRIPTION));
        fgsdkbotschema.setLanguage(rs.getString(COL_LANGUAGE));
        Timestamp PUBLISH_DATE = rs.getTimestamp(COL_PUBLISH_DATE);
        if (PUBLISH_DATE != null)
            fgsdkbotschema.setPublishDate(PUBLISH_DATE.toLocalDateTime());
        fgsdkbotschema.setSessionTimeOut(rs.getString(COL_SESSION_TIME_OUT));
        fgsdkbotschema.setIdleTimeOut(rs.getString(COL_IDLE_TIME_OUT));
        return fgsdkbotschema;
    }
}
