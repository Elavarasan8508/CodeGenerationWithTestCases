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

public class JdbcFgProcessDecisionAuditDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProcessDecisionAuditDao.class);

    private static final String TABLE = "FG_PROCESS_DECISION_AUDIT";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_DECISION_DEF_ID = "DECISION_DEF_ID";

    private static final String COL_DECISION_OUTPUT_HASH = "DECISION_OUTPUT_HASH";

    private static final String COL_DECISION_OUTPUT_RULE = "DECISION_OUTPUT_RULE";

    private static final String COL_LAST_EVALUATION_TIME = "LAST_EVALUATION_TIME";

    private static final String COL_PERF_PARTY_CODE = "PERF_PARTY_CODE";

    private static final String COL_WF_PROCESS_DEF_ID = "WF_PROCESS_DEF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_DECISION_DEF_ID, COL_DECISION_OUTPUT_HASH, COL_DECISION_OUTPUT_RULE, COL_LAST_EVALUATION_TIME, COL_PERF_PARTY_CODE, COL_WF_PROCESS_DEF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DECISION_DEF_ID, DECISION_OUTPUT_HASH, DECISION_OUTPUT_RULE, LAST_EVALUATION_TIME, PERF_PARTY_CODE, WF_PROCESS_DEF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DECISION_DEF_ID, DECISION_OUTPUT_HASH, DECISION_OUTPUT_RULE, LAST_EVALUATION_TIME, PERF_PARTY_CODE, WF_PROCESS_DEF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_DECISION_DEF_ID, COL_DECISION_OUTPUT_HASH, COL_DECISION_OUTPUT_RULE, COL_LAST_EVALUATION_TIME, COL_PERF_PARTY_CODE, COL_WF_PROCESS_DEF_ID, COL_ID);

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

    public int insert(Connection conn, FgProcessDecisionAudit fgprocessdecisionaudit) throws SQLException {
        logger.debug("Inserting fgprocessdecisionaudit: {}", fgprocessdecisionaudit);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProcessDecisionAuditParams(ps, fgprocessdecisionaudit);
            ps.executeUpdate();
            return fgprocessdecisionaudit.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProcessDecisionAudit> fgprocessdecisionaudits) throws SQLException {
        if (fgprocessdecisionaudits == null || fgprocessdecisionaudits.isEmpty())
            return new int[0];
        for (int i = 0; i < fgprocessdecisionaudits.size(); i++) {
            if (fgprocessdecisionaudits.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProcessDecisionAudit>> batches = chunkList(fgprocessdecisionaudits, batchSize);
        int[] totalResults = new int[fgprocessdecisionaudits.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProcessDecisionAudit> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProcessDecisionAudit fgprocessdecisionaudit : batch) {
                        setFgProcessDecisionAuditParams(ps, fgprocessdecisionaudit);
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

    public FgProcessDecisionAudit findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProcessDecisionAudit> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProcessDecisionAudit> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProcessDecisionAudit fgprocessdecisionaudit) throws SQLException {
        if (fgprocessdecisionaudit.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProcessDecisionAuditParams(ps, fgprocessdecisionaudit);
            ps.setInt(24, fgprocessdecisionaudit.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProcessDecisionAudit> fgprocessdecisionaudits) throws SQLException {
        if (fgprocessdecisionaudits == null || fgprocessdecisionaudits.isEmpty())
            return new int[0];
        for (FgProcessDecisionAudit fgprocessdecisionaudit : fgprocessdecisionaudits) {
            if (fgprocessdecisionaudit == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgprocessdecisionaudit.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProcessDecisionAudit>> batches = chunkList(fgprocessdecisionaudits, batchSize);
        int[] totalResults = new int[fgprocessdecisionaudits.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProcessDecisionAudit> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProcessDecisionAudit fgprocessdecisionaudit : batch) {
                        setFgProcessDecisionAuditParams(ps, fgprocessdecisionaudit);
                        ps.setInt(24, fgprocessdecisionaudit.getID());
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

    private void setFgProcessDecisionAuditParams(PreparedStatement ps, FgProcessDecisionAudit fgprocessdecisionaudit) throws SQLException {
        Integer val1 = fgprocessdecisionaudit.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgprocessdecisionaudit.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgprocessdecisionaudit.getTypeCode());
        ps.setString(4, fgprocessdecisionaudit.getSubTypeCode());
        ps.setString(5, fgprocessdecisionaudit.getActiveCode());
        ps.setString(6, fgprocessdecisionaudit.getStageCode());
        ps.setString(7, fgprocessdecisionaudit.getStatusCode());
        Integer val8 = fgprocessdecisionaudit.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgprocessdecisionaudit.getCreatedOn());
        java.math.BigDecimal val10 = fgprocessdecisionaudit.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgprocessdecisionaudit.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgprocessdecisionaudit.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgprocessdecisionaudit.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgprocessdecisionaudit.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgprocessdecisionaudit.getTemplate());
        ps.setString(16, fgprocessdecisionaudit.getApplicantParty());
        ps.setString(17, fgprocessdecisionaudit.getFulfillmentParty());
        java.math.BigDecimal val18 = fgprocessdecisionaudit.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = fgprocessdecisionaudit.getDecisionDefID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgprocessdecisionaudit.getDecisionOutputHash());
        ps.setString(21, fgprocessdecisionaudit.getDecisionOutputRule());
        ps.setString(22, fgprocessdecisionaudit.getLastEvaluationTime());
        ps.setString(23, fgprocessdecisionaudit.getPerfPartyCode());
        Integer val24 = fgprocessdecisionaudit.getWfProcessDefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
    }

    private FgProcessDecisionAudit extract(ResultSet rs) throws SQLException {
        FgProcessDecisionAudit fgprocessdecisionaudit = new FgProcessDecisionAudit();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgprocessdecisionaudit.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgprocessdecisionaudit.setReferenceID(REFERENCE_ID);
        fgprocessdecisionaudit.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgprocessdecisionaudit.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgprocessdecisionaudit.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgprocessdecisionaudit.setStageCode(rs.getString(COL_STAGE_CODE));
        fgprocessdecisionaudit.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgprocessdecisionaudit.setProcessID(PROCESS_ID);
        fgprocessdecisionaudit.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgprocessdecisionaudit.setCreatedBy(CREATED_BY);
        fgprocessdecisionaudit.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgprocessdecisionaudit.setLastUpdatedBy(LAST_UPDATED_BY);
        fgprocessdecisionaudit.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgprocessdecisionaudit.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgprocessdecisionaudit.setTemplate(rs.getString(COL_TEMPLATE));
        fgprocessdecisionaudit.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgprocessdecisionaudit.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgprocessdecisionaudit.setIsTemplate(IS_TEMPLATE);
        Integer DECISION_DEF_ID = rs.getObject(COL_DECISION_DEF_ID, Integer.class);
        fgprocessdecisionaudit.setDecisionDefID(DECISION_DEF_ID);
        fgprocessdecisionaudit.setDecisionOutputHash(rs.getString(COL_DECISION_OUTPUT_HASH));
        fgprocessdecisionaudit.setDecisionOutputRule(rs.getString(COL_DECISION_OUTPUT_RULE));
        fgprocessdecisionaudit.setLastEvaluationTime(rs.getString(COL_LAST_EVALUATION_TIME));
        fgprocessdecisionaudit.setPerfPartyCode(rs.getString(COL_PERF_PARTY_CODE));
        Integer WF_PROCESS_DEF_ID = rs.getObject(COL_WF_PROCESS_DEF_ID, Integer.class);
        fgprocessdecisionaudit.setWfProcessDefID(WF_PROCESS_DEF_ID);
        return fgprocessdecisionaudit;
    }
}
