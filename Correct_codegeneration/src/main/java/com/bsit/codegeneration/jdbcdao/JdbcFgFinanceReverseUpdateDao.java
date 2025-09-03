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

public class JdbcFgFinanceReverseUpdateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFinanceReverseUpdateDao.class);

    private static final String TABLE = "FG_FINANCE_REVERSE_UPDATE";

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

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_FIN_FILE_CONTENT = "FIN_FILE_CONTENT";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FINANCE_FILE_NAME = "FINANCE_FILE_NAME";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_EVENT_NAME = "EVENT_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_FIN_FILE_CONTENT, COL_UPLOAD_REF_ID, COL_FINANCE_FILE_NAME, COL_BATCH_REF_ID, COL_EVENT_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, FIN_FILE_CONTENT, UPLOAD_REF_ID, FINANCE_FILE_NAME, BATCH_REF_ID, EVENT_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, FIN_FILE_CONTENT, UPLOAD_REF_ID, FINANCE_FILE_NAME, BATCH_REF_ID, EVENT_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_FIN_FILE_CONTENT, COL_UPLOAD_REF_ID, COL_FINANCE_FILE_NAME, COL_BATCH_REF_ID, COL_EVENT_NAME, COL_ID);

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

    public int insert(Connection conn, FgFinanceReverseUpdate fgfinancereverseupdate) throws SQLException {
        logger.debug("Inserting fgfinancereverseupdate: {}", fgfinancereverseupdate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFinanceReverseUpdateParams(ps, fgfinancereverseupdate);
            ps.executeUpdate();
            return fgfinancereverseupdate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFinanceReverseUpdate> fgfinancereverseupdates) throws SQLException {
        if (fgfinancereverseupdates == null || fgfinancereverseupdates.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfinancereverseupdates.size(); i++) {
            if (fgfinancereverseupdates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceReverseUpdate>> batches = chunkList(fgfinancereverseupdates, batchSize);
        int[] totalResults = new int[fgfinancereverseupdates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceReverseUpdate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFinanceReverseUpdate fgfinancereverseupdate : batch) {
                        setFgFinanceReverseUpdateParams(ps, fgfinancereverseupdate);
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

    public FgFinanceReverseUpdate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFinanceReverseUpdate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFinanceReverseUpdate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFinanceReverseUpdate fgfinancereverseupdate) throws SQLException {
        if (fgfinancereverseupdate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFinanceReverseUpdateParams(ps, fgfinancereverseupdate);
            ps.setInt(23, fgfinancereverseupdate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFinanceReverseUpdate> fgfinancereverseupdates) throws SQLException {
        if (fgfinancereverseupdates == null || fgfinancereverseupdates.isEmpty())
            return new int[0];
        for (FgFinanceReverseUpdate fgfinancereverseupdate : fgfinancereverseupdates) {
            if (fgfinancereverseupdate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfinancereverseupdate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceReverseUpdate>> batches = chunkList(fgfinancereverseupdates, batchSize);
        int[] totalResults = new int[fgfinancereverseupdates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceReverseUpdate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFinanceReverseUpdate fgfinancereverseupdate : batch) {
                        setFgFinanceReverseUpdateParams(ps, fgfinancereverseupdate);
                        ps.setInt(23, fgfinancereverseupdate.getID());
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

    private void setFgFinanceReverseUpdateParams(PreparedStatement ps, FgFinanceReverseUpdate fgfinancereverseupdate) throws SQLException {
        Integer val1 = fgfinancereverseupdate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfinancereverseupdate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfinancereverseupdate.getTypeCode());
        ps.setString(4, fgfinancereverseupdate.getSubTypeCode());
        ps.setString(5, fgfinancereverseupdate.getActiveCode());
        ps.setString(6, fgfinancereverseupdate.getStageCode());
        ps.setString(7, fgfinancereverseupdate.getStatusCode());
        Integer val8 = fgfinancereverseupdate.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgfinancereverseupdate.getCreatedOn());
        java.math.BigDecimal val10 = fgfinancereverseupdate.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgfinancereverseupdate.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgfinancereverseupdate.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgfinancereverseupdate.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgfinancereverseupdate.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgfinancereverseupdate.getTemplate());
        ps.setString(16, fgfinancereverseupdate.getApplicantPartyCode());
        ps.setString(17, fgfinancereverseupdate.getIssuingPartyCode());
        java.math.BigDecimal val18 = fgfinancereverseupdate.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgfinancereverseupdate.getFinFileContent());
        Integer val20 = fgfinancereverseupdate.getUploadRefID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        ps.setString(21, fgfinancereverseupdate.getFinanceFileName());
        Integer val22 = fgfinancereverseupdate.getBatchRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fgfinancereverseupdate.getEventName());
    }

    private FgFinanceReverseUpdate extract(ResultSet rs) throws SQLException {
        FgFinanceReverseUpdate fgfinancereverseupdate = new FgFinanceReverseUpdate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfinancereverseupdate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfinancereverseupdate.setReferenceID(REFERENCE_ID);
        fgfinancereverseupdate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfinancereverseupdate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfinancereverseupdate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfinancereverseupdate.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfinancereverseupdate.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgfinancereverseupdate.setProcessID(PROCESS_ID);
        fgfinancereverseupdate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfinancereverseupdate.setCreatedBy(CREATED_BY);
        fgfinancereverseupdate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfinancereverseupdate.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfinancereverseupdate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfinancereverseupdate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfinancereverseupdate.setTemplate(rs.getString(COL_TEMPLATE));
        fgfinancereverseupdate.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgfinancereverseupdate.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfinancereverseupdate.setIsTemplate(IS_TEMPLATE);
        fgfinancereverseupdate.setFinFileContent(rs.getString(COL_FIN_FILE_CONTENT));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfinancereverseupdate.setUploadRefID(UPLOAD_REF_ID);
        fgfinancereverseupdate.setFinanceFileName(rs.getString(COL_FINANCE_FILE_NAME));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgfinancereverseupdate.setBatchRefID(BATCH_REF_ID);
        fgfinancereverseupdate.setEventName(rs.getString(COL_EVENT_NAME));
        return fgfinancereverseupdate;
    }
}
