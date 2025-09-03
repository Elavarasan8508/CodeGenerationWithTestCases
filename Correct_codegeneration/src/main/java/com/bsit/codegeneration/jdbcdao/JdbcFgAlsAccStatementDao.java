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

public class JdbcFgAlsAccStatementDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAlsAccStatementDao.class);

    private static final String TABLE = "FG_ALS_ACC_STATEMENT";

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

    private static final String COL_TXN_TYPE = "TXN_TYPE";

    private static final String COL_TRANSACTION_DATE = "TRANSACTION_DATE";

    private static final String COL_VIRTUAL_ACCOUNT_NUMBER = "VIRTUAL_ACCOUNT_NUMBER";

    private static final String COL_VALUE_DATE = "VALUE_DATE";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_PARTICULARS = "PARTICULARS";

    private static final String COL_CURRENCY = "CURRENCY";

    private static final String COL_DEBIT_AMOUNT = "DEBIT_AMOUNT";

    private static final String COL_CREDIT_AMOUNT = "CREDIT_AMOUNT";

    private static final String COL_BALANCE = "BALANCE";

    private static final String COL_TXN_STATUS = "TXN_STATUS";

    private static final String COL_LEDGER_TYPE = "LEDGER_TYPE";

    private static final String COL_TI_THEIR_REFERENCE = "TI_THEIR_REFERENCE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TXN_TYPE, COL_TRANSACTION_DATE, COL_VIRTUAL_ACCOUNT_NUMBER, COL_VALUE_DATE, COL_REMARKS, COL_PARTICULARS, COL_CURRENCY, COL_DEBIT_AMOUNT, COL_CREDIT_AMOUNT, COL_BALANCE, COL_TXN_STATUS, COL_LEDGER_TYPE, COL_TI_THEIR_REFERENCE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TXN_TYPE, TRANSACTION_DATE, VIRTUAL_ACCOUNT_NUMBER, VALUE_DATE, REMARKS, PARTICULARS, CURRENCY, DEBIT_AMOUNT, CREDIT_AMOUNT, BALANCE, TXN_STATUS, LEDGER_TYPE, TI_THEIR_REFERENCE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TXN_TYPE, TRANSACTION_DATE, VIRTUAL_ACCOUNT_NUMBER, VALUE_DATE, REMARKS, PARTICULARS, CURRENCY, DEBIT_AMOUNT, CREDIT_AMOUNT, BALANCE, TXN_STATUS, LEDGER_TYPE, TI_THEIR_REFERENCE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TXN_TYPE, COL_TRANSACTION_DATE, COL_VIRTUAL_ACCOUNT_NUMBER, COL_VALUE_DATE, COL_REMARKS, COL_PARTICULARS, COL_CURRENCY, COL_DEBIT_AMOUNT, COL_CREDIT_AMOUNT, COL_BALANCE, COL_TXN_STATUS, COL_LEDGER_TYPE, COL_TI_THEIR_REFERENCE, COL_ID);

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

    public int insert(Connection conn, FgAlsAccStatement fgalsaccstatement) throws SQLException {
        logger.debug("Inserting fgalsaccstatement: {}", fgalsaccstatement);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAlsAccStatementParams(ps, fgalsaccstatement);
            ps.executeUpdate();
            return fgalsaccstatement.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAlsAccStatement> fgalsaccstatements) throws SQLException {
        if (fgalsaccstatements == null || fgalsaccstatements.isEmpty())
            return new int[0];
        for (int i = 0; i < fgalsaccstatements.size(); i++) {
            if (fgalsaccstatements.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsAccStatement>> batches = chunkList(fgalsaccstatements, batchSize);
        int[] totalResults = new int[fgalsaccstatements.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsAccStatement> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAlsAccStatement fgalsaccstatement : batch) {
                        setFgAlsAccStatementParams(ps, fgalsaccstatement);
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

    public FgAlsAccStatement findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAlsAccStatement> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAlsAccStatement> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAlsAccStatement fgalsaccstatement) throws SQLException {
        if (fgalsaccstatement.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAlsAccStatementParams(ps, fgalsaccstatement);
            ps.setInt(31, fgalsaccstatement.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAlsAccStatement> fgalsaccstatements) throws SQLException {
        if (fgalsaccstatements == null || fgalsaccstatements.isEmpty())
            return new int[0];
        for (FgAlsAccStatement fgalsaccstatement : fgalsaccstatements) {
            if (fgalsaccstatement == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgalsaccstatement.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsAccStatement>> batches = chunkList(fgalsaccstatements, batchSize);
        int[] totalResults = new int[fgalsaccstatements.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsAccStatement> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAlsAccStatement fgalsaccstatement : batch) {
                        setFgAlsAccStatementParams(ps, fgalsaccstatement);
                        ps.setInt(31, fgalsaccstatement.getID());
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

    private void setFgAlsAccStatementParams(PreparedStatement ps, FgAlsAccStatement fgalsaccstatement) throws SQLException {
        Integer val1 = fgalsaccstatement.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgalsaccstatement.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgalsaccstatement.getTypeCode());
        ps.setString(4, fgalsaccstatement.getSubTypeCode());
        ps.setString(5, fgalsaccstatement.getActiveCode());
        ps.setString(6, fgalsaccstatement.getStageCode());
        ps.setString(7, fgalsaccstatement.getStatusCode());
        Integer val8 = fgalsaccstatement.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgalsaccstatement.getCreatedOn());
        java.math.BigDecimal val10 = fgalsaccstatement.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgalsaccstatement.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgalsaccstatement.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgalsaccstatement.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgalsaccstatement.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgalsaccstatement.getTemplate());
        ps.setString(16, fgalsaccstatement.getApplicantParty());
        ps.setString(17, fgalsaccstatement.getFulfillmentParty());
        java.math.BigDecimal val18 = fgalsaccstatement.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgalsaccstatement.getTxnType());
        java.time.LocalDateTime val20 = fgalsaccstatement.getTransactionDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fgalsaccstatement.getVirtualAccountNumber());
        java.time.LocalDateTime val22 = fgalsaccstatement.getValueDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgalsaccstatement.getRemarks());
        ps.setString(24, fgalsaccstatement.getParticulars());
        ps.setString(25, fgalsaccstatement.getCurrency());
        java.math.BigDecimal val26 = fgalsaccstatement.getDebitAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgalsaccstatement.getCreditAmount();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgalsaccstatement.getBalance();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, fgalsaccstatement.getTxnStatus());
        ps.setString(30, fgalsaccstatement.getLedgerType());
        ps.setString(31, fgalsaccstatement.getTiTheirReference());
    }

    private FgAlsAccStatement extract(ResultSet rs) throws SQLException {
        FgAlsAccStatement fgalsaccstatement = new FgAlsAccStatement();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgalsaccstatement.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgalsaccstatement.setReferenceID(REFERENCE_ID);
        fgalsaccstatement.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgalsaccstatement.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgalsaccstatement.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgalsaccstatement.setStageCode(rs.getString(COL_STAGE_CODE));
        fgalsaccstatement.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgalsaccstatement.setProcessID(PROCESS_ID);
        fgalsaccstatement.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgalsaccstatement.setCreatedBy(CREATED_BY);
        fgalsaccstatement.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgalsaccstatement.setLastUpdatedBy(LAST_UPDATED_BY);
        fgalsaccstatement.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgalsaccstatement.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgalsaccstatement.setTemplate(rs.getString(COL_TEMPLATE));
        fgalsaccstatement.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgalsaccstatement.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgalsaccstatement.setIsTemplate(IS_TEMPLATE);
        fgalsaccstatement.setTxnType(rs.getString(COL_TXN_TYPE));
        Timestamp TRANSACTION_DATE = rs.getTimestamp(COL_TRANSACTION_DATE);
        if (TRANSACTION_DATE != null)
            fgalsaccstatement.setTransactionDate(TRANSACTION_DATE.toLocalDateTime());
        fgalsaccstatement.setVirtualAccountNumber(rs.getString(COL_VIRTUAL_ACCOUNT_NUMBER));
        Timestamp VALUE_DATE = rs.getTimestamp(COL_VALUE_DATE);
        if (VALUE_DATE != null)
            fgalsaccstatement.setValueDate(VALUE_DATE.toLocalDateTime());
        fgalsaccstatement.setRemarks(rs.getString(COL_REMARKS));
        fgalsaccstatement.setParticulars(rs.getString(COL_PARTICULARS));
        fgalsaccstatement.setCurrency(rs.getString(COL_CURRENCY));
        java.math.BigDecimal DEBIT_AMOUNT = rs.getObject(COL_DEBIT_AMOUNT, java.math.BigDecimal.class);
        fgalsaccstatement.setDebitAmount(DEBIT_AMOUNT);
        java.math.BigDecimal CREDIT_AMOUNT = rs.getObject(COL_CREDIT_AMOUNT, java.math.BigDecimal.class);
        fgalsaccstatement.setCreditAmount(CREDIT_AMOUNT);
        java.math.BigDecimal BALANCE = rs.getObject(COL_BALANCE, java.math.BigDecimal.class);
        fgalsaccstatement.setBalance(BALANCE);
        fgalsaccstatement.setTxnStatus(rs.getString(COL_TXN_STATUS));
        fgalsaccstatement.setLedgerType(rs.getString(COL_LEDGER_TYPE));
        fgalsaccstatement.setTiTheirReference(rs.getString(COL_TI_THEIR_REFERENCE));
        return fgalsaccstatement;
    }
}
