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

public class JdbcFgAlsExecutionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAlsExecutionDao.class);

    private static final String TABLE = "FG_ALS_EXECUTION";

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

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_ACCOUNT_NO = "ACCOUNT_NO";

    private static final String COL_LAST_EXECUTION = "LAST_EXECUTION";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_TOTAL_LOANS = "TOTAL_LOANS";

    private static final String COL_PROCESSED_LOANS = "PROCESSED_LOANS";

    private static final String COL_ERROR_DESC = "ERROR_DESC";

    private static final String COL_ACCOUNT_BALANCE = "ACCOUNT_BALANCE";

    private static final String COL_TOTAL_BALANCE = "TOTAL_BALANCE";

    private static final String COL_REASON = "REASON";

    private static final String COL_EXECUTION_START_TIME = "EXECUTION_START_TIME";

    private static final String COL_EXECUTION_END_TIME = "EXECUTION_END_TIME";

    private static final String COL_FINACLE_STATUS = "FINACLE_STATUS";

    private static final String COL_ACCOUNT_STATUS = "ACCOUNT_STATUS";

    private static final String COL_DEBIT_LOCK = "DEBIT_LOCK";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_ACCOUNT_NO, COL_LAST_EXECUTION, COL_STATUS, COL_TOTAL_LOANS, COL_PROCESSED_LOANS, COL_ERROR_DESC, COL_ACCOUNT_BALANCE, COL_TOTAL_BALANCE, COL_REASON, COL_EXECUTION_START_TIME, COL_EXECUTION_END_TIME, COL_FINACLE_STATUS, COL_ACCOUNT_STATUS, COL_DEBIT_LOCK, COL_CUSTOMER_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NO, LAST_EXECUTION, STATUS, TOTAL_LOANS, PROCESSED_LOANS, ERROR_DESC, ACCOUNT_BALANCE, TOTAL_BALANCE, REASON, EXECUTION_START_TIME, EXECUTION_END_TIME, FINACLE_STATUS, ACCOUNT_STATUS, DEBIT_LOCK, CUSTOMER_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NO, LAST_EXECUTION, STATUS, TOTAL_LOANS, PROCESSED_LOANS, ERROR_DESC, ACCOUNT_BALANCE, TOTAL_BALANCE, REASON, EXECUTION_START_TIME, EXECUTION_END_TIME, FINACLE_STATUS, ACCOUNT_STATUS, DEBIT_LOCK, CUSTOMER_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUSTOMER_CRN, COL_ACCOUNT_NO, COL_LAST_EXECUTION, COL_STATUS, COL_TOTAL_LOANS, COL_PROCESSED_LOANS, COL_ERROR_DESC, COL_ACCOUNT_BALANCE, COL_TOTAL_BALANCE, COL_REASON, COL_EXECUTION_START_TIME, COL_EXECUTION_END_TIME, COL_FINACLE_STATUS, COL_ACCOUNT_STATUS, COL_DEBIT_LOCK, COL_CUSTOMER_NAME, COL_ID);

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

    public int insert(Connection conn, FgAlsExecution fgalsexecution) throws SQLException {
        logger.debug("Inserting fgalsexecution: {}", fgalsexecution);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAlsExecutionParams(ps, fgalsexecution);
            ps.executeUpdate();
            return fgalsexecution.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAlsExecution> fgalsexecutions) throws SQLException {
        if (fgalsexecutions == null || fgalsexecutions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgalsexecutions.size(); i++) {
            if (fgalsexecutions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsExecution>> batches = chunkList(fgalsexecutions, batchSize);
        int[] totalResults = new int[fgalsexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAlsExecution fgalsexecution : batch) {
                        setFgAlsExecutionParams(ps, fgalsexecution);
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

    public FgAlsExecution findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAlsExecution> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAlsExecution> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAlsExecution fgalsexecution) throws SQLException {
        if (fgalsexecution.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAlsExecutionParams(ps, fgalsexecution);
            ps.setInt(34, fgalsexecution.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAlsExecution> fgalsexecutions) throws SQLException {
        if (fgalsexecutions == null || fgalsexecutions.isEmpty())
            return new int[0];
        for (FgAlsExecution fgalsexecution : fgalsexecutions) {
            if (fgalsexecution == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgalsexecution.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsExecution>> batches = chunkList(fgalsexecutions, batchSize);
        int[] totalResults = new int[fgalsexecutions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsExecution> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAlsExecution fgalsexecution : batch) {
                        setFgAlsExecutionParams(ps, fgalsexecution);
                        ps.setInt(34, fgalsexecution.getID());
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

    private void setFgAlsExecutionParams(PreparedStatement ps, FgAlsExecution fgalsexecution) throws SQLException {
        Integer val1 = fgalsexecution.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgalsexecution.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgalsexecution.getTypeCode());
        ps.setString(4, fgalsexecution.getSubTypeCode());
        ps.setString(5, fgalsexecution.getActiveCode());
        ps.setString(6, fgalsexecution.getStageCode());
        ps.setString(7, fgalsexecution.getStatusCode());
        Integer val8 = fgalsexecution.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgalsexecution.getCreatedOn());
        java.math.BigDecimal val10 = fgalsexecution.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgalsexecution.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgalsexecution.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgalsexecution.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgalsexecution.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgalsexecution.getTemplate());
        ps.setString(16, fgalsexecution.getApplicantParty());
        ps.setString(17, fgalsexecution.getFulfillmentParty());
        java.math.BigDecimal val18 = fgalsexecution.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgalsexecution.getCustomerCrn());
        ps.setString(20, fgalsexecution.getAccountNo());
        ps.setString(21, fgalsexecution.getLastExecution());
        ps.setString(22, fgalsexecution.getStatus());
        java.math.BigDecimal val23 = fgalsexecution.getTotalLoans();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgalsexecution.getProcessedLoans();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgalsexecution.getErrorDesc());
        java.math.BigDecimal val26 = fgalsexecution.getAccountBalance();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgalsexecution.getTotalBalance();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgalsexecution.getReason());
        ps.setString(29, fgalsexecution.getExecutionStartTime());
        ps.setString(30, fgalsexecution.getExecutionEndTime());
        ps.setString(31, fgalsexecution.getFinacleStatus());
        ps.setString(32, fgalsexecution.getAccountStatus());
        ps.setString(33, fgalsexecution.getDebitLock());
        ps.setString(34, fgalsexecution.getCustomerName());
    }

    private FgAlsExecution extract(ResultSet rs) throws SQLException {
        FgAlsExecution fgalsexecution = new FgAlsExecution();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgalsexecution.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgalsexecution.setReferenceID(REFERENCE_ID);
        fgalsexecution.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgalsexecution.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgalsexecution.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgalsexecution.setStageCode(rs.getString(COL_STAGE_CODE));
        fgalsexecution.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgalsexecution.setProcessID(PROCESS_ID);
        fgalsexecution.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgalsexecution.setCreatedBy(CREATED_BY);
        fgalsexecution.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgalsexecution.setLastUpdatedBy(LAST_UPDATED_BY);
        fgalsexecution.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgalsexecution.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgalsexecution.setTemplate(rs.getString(COL_TEMPLATE));
        fgalsexecution.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgalsexecution.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgalsexecution.setIsTemplate(IS_TEMPLATE);
        fgalsexecution.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        fgalsexecution.setAccountNo(rs.getString(COL_ACCOUNT_NO));
        fgalsexecution.setLastExecution(rs.getString(COL_LAST_EXECUTION));
        fgalsexecution.setStatus(rs.getString(COL_STATUS));
        java.math.BigDecimal TOTAL_LOANS = rs.getObject(COL_TOTAL_LOANS, java.math.BigDecimal.class);
        fgalsexecution.setTotalLoans(TOTAL_LOANS);
        java.math.BigDecimal PROCESSED_LOANS = rs.getObject(COL_PROCESSED_LOANS, java.math.BigDecimal.class);
        fgalsexecution.setProcessedLoans(PROCESSED_LOANS);
        fgalsexecution.setErrorDesc(rs.getString(COL_ERROR_DESC));
        java.math.BigDecimal ACCOUNT_BALANCE = rs.getObject(COL_ACCOUNT_BALANCE, java.math.BigDecimal.class);
        fgalsexecution.setAccountBalance(ACCOUNT_BALANCE);
        java.math.BigDecimal TOTAL_BALANCE = rs.getObject(COL_TOTAL_BALANCE, java.math.BigDecimal.class);
        fgalsexecution.setTotalBalance(TOTAL_BALANCE);
        fgalsexecution.setReason(rs.getString(COL_REASON));
        fgalsexecution.setExecutionStartTime(rs.getString(COL_EXECUTION_START_TIME));
        fgalsexecution.setExecutionEndTime(rs.getString(COL_EXECUTION_END_TIME));
        fgalsexecution.setFinacleStatus(rs.getString(COL_FINACLE_STATUS));
        fgalsexecution.setAccountStatus(rs.getString(COL_ACCOUNT_STATUS));
        fgalsexecution.setDebitLock(rs.getString(COL_DEBIT_LOCK));
        fgalsexecution.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        return fgalsexecution;
    }
}
