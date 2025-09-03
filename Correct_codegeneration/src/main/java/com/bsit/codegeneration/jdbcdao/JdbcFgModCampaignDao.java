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

public class JdbcFgModCampaignDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModCampaignDao.class);

    private static final String TABLE = "FG_MOD_CAMPAIGN";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

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

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_BO_RESPONSE = "BO_RESPONSE";

    private static final String COL_BO_STATUS = "BO_STATUS";

    private static final String COL_STATUS_ID = "STATUS_ID";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TEMPLATE_REF_ID = "TEMPLATE_REF_ID";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_TITLE = "TITLE";

    private static final String COL_APPLICATION_DATE = "APPLICATION_DATE";

    private static final String COL_EFFECTIVE_FROM = "EFFECTIVE_FROM";

    private static final String COL_EFFECTIVE_TO = "EFFECTIVE_TO";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_TEMPLATE, COL_PROCESS_ID, COL_BO_RESPONSE, COL_BO_STATUS, COL_STATUS_ID, COL_COMMENTS, COL_DESCRIPTION, COL_TEMPLATE_REF_ID, COL_PURPOSE_CODE, COL_TITLE, COL_APPLICATION_DATE, COL_EFFECTIVE_FROM, COL_EFFECTIVE_TO, COL_TEMPLATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, PROCESS_ID, BO_RESPONSE, BO_STATUS, STATUS_ID, COMMENTS, DESCRIPTION, TEMPLATE_REF_ID, PURPOSE_CODE, TITLE, APPLICATION_DATE, EFFECTIVE_FROM, EFFECTIVE_TO, TEMPLATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, PROCESS_ID, BO_RESPONSE, BO_STATUS, STATUS_ID, COMMENTS, DESCRIPTION, TEMPLATE_REF_ID, PURPOSE_CODE, TITLE, APPLICATION_DATE, EFFECTIVE_FROM, EFFECTIVE_TO, TEMPLATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_TEMPLATE, COL_PROCESS_ID, COL_BO_RESPONSE, COL_BO_STATUS, COL_STATUS_ID, COL_COMMENTS, COL_DESCRIPTION, COL_TEMPLATE_REF_ID, COL_PURPOSE_CODE, COL_TITLE, COL_APPLICATION_DATE, COL_EFFECTIVE_FROM, COL_EFFECTIVE_TO, COL_TEMPLATE, COL_ID);

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

    public int insert(Connection conn, FgModCampaign fgmodcampaign) throws SQLException {
        logger.debug("Inserting fgmodcampaign: {}", fgmodcampaign);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModCampaignParams(ps, fgmodcampaign);
            ps.executeUpdate();
            return fgmodcampaign.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModCampaign> fgmodcampaigns) throws SQLException {
        if (fgmodcampaigns == null || fgmodcampaigns.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodcampaigns.size(); i++) {
            if (fgmodcampaigns.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCampaign>> batches = chunkList(fgmodcampaigns, batchSize);
        int[] totalResults = new int[fgmodcampaigns.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCampaign> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModCampaign fgmodcampaign : batch) {
                        setFgModCampaignParams(ps, fgmodcampaign);
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

    public FgModCampaign findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModCampaign> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModCampaign> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModCampaign fgmodcampaign) throws SQLException {
        if (fgmodcampaign.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModCampaignParams(ps, fgmodcampaign);
            ps.setInt(27, fgmodcampaign.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModCampaign> fgmodcampaigns) throws SQLException {
        if (fgmodcampaigns == null || fgmodcampaigns.isEmpty())
            return new int[0];
        for (FgModCampaign fgmodcampaign : fgmodcampaigns) {
            if (fgmodcampaign == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodcampaign.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCampaign>> batches = chunkList(fgmodcampaigns, batchSize);
        int[] totalResults = new int[fgmodcampaigns.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCampaign> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModCampaign fgmodcampaign : batch) {
                        setFgModCampaignParams(ps, fgmodcampaign);
                        ps.setInt(27, fgmodcampaign.getID());
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

    private void setFgModCampaignParams(PreparedStatement ps, FgModCampaign fgmodcampaign) throws SQLException {
        Integer val1 = fgmodcampaign.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodcampaign.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodcampaign.getTypeCode());
        ps.setString(4, fgmodcampaign.getSubTypeCode());
        ps.setString(5, fgmodcampaign.getActiveCode());
        ps.setString(6, fgmodcampaign.getStageCode());
        ps.setString(7, fgmodcampaign.getStatusCode());
        ps.setString(8, fgmodcampaign.getCreatedOn());
        java.math.BigDecimal val9 = fgmodcampaign.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodcampaign.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmodcampaign.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmodcampaign.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgmodcampaign.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = fgmodcampaign.getIsTemplate();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        Integer val15 = fgmodcampaign.getProcessID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
        ps.setString(16, fgmodcampaign.getBoResponse());
        ps.setString(17, fgmodcampaign.getBoStatus());
        Integer val18 = fgmodcampaign.getStatusID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fgmodcampaign.getComments());
        ps.setString(20, fgmodcampaign.getDescription());
        Integer val21 = fgmodcampaign.getTemplateRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        ps.setString(22, fgmodcampaign.getPurposeCode());
        ps.setString(23, fgmodcampaign.getTitle());
        java.time.LocalDateTime val24 = fgmodcampaign.getApplicationDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val25 = fgmodcampaign.getEffectiveFrom();
        if (val25 != null) {
            ps.setTimestamp(25, java.sql.Timestamp.valueOf(val25));
        } else {
            ps.setNull(25, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val26 = fgmodcampaign.getEffectiveTo();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        ps.setString(27, fgmodcampaign.getTemplate());
    }

    private FgModCampaign extract(ResultSet rs) throws SQLException {
        FgModCampaign fgmodcampaign = new FgModCampaign();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodcampaign.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodcampaign.setReferenceID(REFERENCE_ID);
        fgmodcampaign.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodcampaign.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmodcampaign.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodcampaign.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmodcampaign.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodcampaign.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodcampaign.setCreatedBy(CREATED_BY);
        fgmodcampaign.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodcampaign.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodcampaign.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodcampaign.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgmodcampaign.setIsTemplate(IS_TEMPLATE);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgmodcampaign.setProcessID(PROCESS_ID);
        fgmodcampaign.setBoResponse(rs.getString(COL_BO_RESPONSE));
        fgmodcampaign.setBoStatus(rs.getString(COL_BO_STATUS));
        Integer STATUS_ID = rs.getObject(COL_STATUS_ID, Integer.class);
        fgmodcampaign.setStatusID(STATUS_ID);
        fgmodcampaign.setComments(rs.getString(COL_COMMENTS));
        fgmodcampaign.setDescription(rs.getString(COL_DESCRIPTION));
        Integer TEMPLATE_REF_ID = rs.getObject(COL_TEMPLATE_REF_ID, Integer.class);
        fgmodcampaign.setTemplateRefID(TEMPLATE_REF_ID);
        fgmodcampaign.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgmodcampaign.setTitle(rs.getString(COL_TITLE));
        Timestamp APPLICATION_DATE = rs.getTimestamp(COL_APPLICATION_DATE);
        if (APPLICATION_DATE != null)
            fgmodcampaign.setApplicationDate(APPLICATION_DATE.toLocalDateTime());
        Timestamp EFFECTIVE_FROM = rs.getTimestamp(COL_EFFECTIVE_FROM);
        if (EFFECTIVE_FROM != null)
            fgmodcampaign.setEffectiveFrom(EFFECTIVE_FROM.toLocalDateTime());
        Timestamp EFFECTIVE_TO = rs.getTimestamp(COL_EFFECTIVE_TO);
        if (EFFECTIVE_TO != null)
            fgmodcampaign.setEffectiveTo(EFFECTIVE_TO.toLocalDateTime());
        fgmodcampaign.setTemplate(rs.getString(COL_TEMPLATE));
        return fgmodcampaign;
    }
}
