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

public class JdbcFgFinanceMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFinanceMasterDao.class);

    private static final String TABLE = "FG_FINANCE_MASTER";

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

    private static final String COL_FILE_CONTENT = "FILE_CONTENT";

    private static final String COL_RETRIGGER_COUNT = "RETRIGGER_COUNT";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FINANCE_FILE_NAME = "FINANCE_FILE_NAME";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_SEND_FINANCE_FILE = "SEND_FINANCE_FILE";

    private static final String COL_IS_FINANCE_SENT = "IS_FINANCE_SENT";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_CUTOFF_TIME = "CUTOFF_TIME";

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_BATCH_ACTION = "BATCH_ACTION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_FILE_CONTENT, COL_RETRIGGER_COUNT, COL_UPLOAD_REF_ID, COL_FINANCE_FILE_NAME, COL_APPLICANT_PARTY_CODE, COL_SEND_FINANCE_FILE, COL_IS_FINANCE_SENT, COL_FILE_NAME, COL_REMARKS, COL_CUTOFF_TIME, COL_BATCH_REF_ID, COL_BATCH_ACTION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_CONTENT, RETRIGGER_COUNT, UPLOAD_REF_ID, FINANCE_FILE_NAME, APPLICANT_PARTY_CODE, SEND_FINANCE_FILE, IS_FINANCE_SENT, FILE_NAME, REMARKS, CUTOFF_TIME, BATCH_REF_ID, BATCH_ACTION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_CONTENT, RETRIGGER_COUNT, UPLOAD_REF_ID, FINANCE_FILE_NAME, APPLICANT_PARTY_CODE, SEND_FINANCE_FILE, IS_FINANCE_SENT, FILE_NAME, REMARKS, CUTOFF_TIME, BATCH_REF_ID, BATCH_ACTION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_FILE_CONTENT, COL_RETRIGGER_COUNT, COL_UPLOAD_REF_ID, COL_FINANCE_FILE_NAME, COL_APPLICANT_PARTY_CODE, COL_SEND_FINANCE_FILE, COL_IS_FINANCE_SENT, COL_FILE_NAME, COL_REMARKS, COL_CUTOFF_TIME, COL_BATCH_REF_ID, COL_BATCH_ACTION, COL_ID);

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

    public int insert(Connection conn, FgFinanceMaster fgfinancemaster) throws SQLException {
        logger.debug("Inserting fgfinancemaster: {}", fgfinancemaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFinanceMasterParams(ps, fgfinancemaster);
            ps.executeUpdate();
            return fgfinancemaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFinanceMaster> fgfinancemasters) throws SQLException {
        if (fgfinancemasters == null || fgfinancemasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfinancemasters.size(); i++) {
            if (fgfinancemasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceMaster>> batches = chunkList(fgfinancemasters, batchSize);
        int[] totalResults = new int[fgfinancemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFinanceMaster fgfinancemaster : batch) {
                        setFgFinanceMasterParams(ps, fgfinancemaster);
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

    public FgFinanceMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFinanceMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFinanceMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFinanceMaster fgfinancemaster) throws SQLException {
        if (fgfinancemaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFinanceMasterParams(ps, fgfinancemaster);
            ps.setInt(30, fgfinancemaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFinanceMaster> fgfinancemasters) throws SQLException {
        if (fgfinancemasters == null || fgfinancemasters.isEmpty())
            return new int[0];
        for (FgFinanceMaster fgfinancemaster : fgfinancemasters) {
            if (fgfinancemaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfinancemaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFinanceMaster>> batches = chunkList(fgfinancemasters, batchSize);
        int[] totalResults = new int[fgfinancemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFinanceMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFinanceMaster fgfinancemaster : batch) {
                        setFgFinanceMasterParams(ps, fgfinancemaster);
                        ps.setInt(30, fgfinancemaster.getID());
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

    private void setFgFinanceMasterParams(PreparedStatement ps, FgFinanceMaster fgfinancemaster) throws SQLException {
        Integer val1 = fgfinancemaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfinancemaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfinancemaster.getTypeCode());
        ps.setString(4, fgfinancemaster.getSubTypeCode());
        ps.setString(5, fgfinancemaster.getActiveCode());
        ps.setString(6, fgfinancemaster.getStageCode());
        ps.setString(7, fgfinancemaster.getStatusCode());
        Integer val8 = fgfinancemaster.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgfinancemaster.getCreatedOn());
        java.math.BigDecimal val10 = fgfinancemaster.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgfinancemaster.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgfinancemaster.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgfinancemaster.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgfinancemaster.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgfinancemaster.getTemplate());
        ps.setString(16, fgfinancemaster.getApplicantParty());
        ps.setString(17, fgfinancemaster.getFulfillmentParty());
        java.math.BigDecimal val18 = fgfinancemaster.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgfinancemaster.getFileContent());
        ps.setString(20, fgfinancemaster.getRetriggerCount());
        Integer val21 = fgfinancemaster.getUploadRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        ps.setString(22, fgfinancemaster.getFinanceFileName());
        ps.setString(23, fgfinancemaster.getApplicantPartyCode());
        ps.setString(24, fgfinancemaster.getSendFinanceFile());
        ps.setString(25, fgfinancemaster.getIsFinanceSent());
        ps.setString(26, fgfinancemaster.getFileName());
        ps.setString(27, fgfinancemaster.getRemarks());
        ps.setString(28, fgfinancemaster.getCutoffTime());
        Integer val29 = fgfinancemaster.getBatchRefID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgfinancemaster.getBatchAction());
    }

    private FgFinanceMaster extract(ResultSet rs) throws SQLException {
        FgFinanceMaster fgfinancemaster = new FgFinanceMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfinancemaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfinancemaster.setReferenceID(REFERENCE_ID);
        fgfinancemaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfinancemaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfinancemaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfinancemaster.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfinancemaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgfinancemaster.setProcessID(PROCESS_ID);
        fgfinancemaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfinancemaster.setCreatedBy(CREATED_BY);
        fgfinancemaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfinancemaster.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfinancemaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfinancemaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfinancemaster.setTemplate(rs.getString(COL_TEMPLATE));
        fgfinancemaster.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgfinancemaster.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfinancemaster.setIsTemplate(IS_TEMPLATE);
        fgfinancemaster.setFileContent(rs.getString(COL_FILE_CONTENT));
        fgfinancemaster.setRetriggerCount(rs.getString(COL_RETRIGGER_COUNT));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfinancemaster.setUploadRefID(UPLOAD_REF_ID);
        fgfinancemaster.setFinanceFileName(rs.getString(COL_FINANCE_FILE_NAME));
        fgfinancemaster.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgfinancemaster.setSendFinanceFile(rs.getString(COL_SEND_FINANCE_FILE));
        fgfinancemaster.setIsFinanceSent(rs.getString(COL_IS_FINANCE_SENT));
        fgfinancemaster.setFileName(rs.getString(COL_FILE_NAME));
        fgfinancemaster.setRemarks(rs.getString(COL_REMARKS));
        fgfinancemaster.setCutoffTime(rs.getString(COL_CUTOFF_TIME));
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        fgfinancemaster.setBatchRefID(BATCH_REF_ID);
        fgfinancemaster.setBatchAction(rs.getString(COL_BATCH_ACTION));
        return fgfinancemaster;
    }
}
