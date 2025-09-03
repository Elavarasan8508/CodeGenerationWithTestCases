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

public class JdbcFgScf3TransactionsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgScf3TransactionsDao.class);

    private static final String TABLE = "FG_SCF3_TRANSACTIONS";

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

    private static final String COL_INVOICE_NO = "INVOICE_NO";

    private static final String COL_VENDOR_CODE = "VENDOR_CODE";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_DUE_DATE = "DUE_DATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INVOICE_NO, COL_VENDOR_CODE, COL_INVOICE_AMOUNT, COL_INVOICE_DATE, COL_DUE_DATE, COL_UPLOAD_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, VENDOR_CODE, INVOICE_AMOUNT, INVOICE_DATE, DUE_DATE, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, VENDOR_CODE, INVOICE_AMOUNT, INVOICE_DATE, DUE_DATE, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INVOICE_NO, COL_VENDOR_CODE, COL_INVOICE_AMOUNT, COL_INVOICE_DATE, COL_DUE_DATE, COL_UPLOAD_REF_ID, COL_ID);

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

    public int insert(Connection conn, FgScf3Transactions fgscf3transactions) throws SQLException {
        logger.debug("Inserting fgscf3transactions: {}", fgscf3transactions);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgScf3TransactionsParams(ps, fgscf3transactions);
            ps.executeUpdate();
            return fgscf3transactions.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgScf3Transactions> fgscf3transactionss) throws SQLException {
        if (fgscf3transactionss == null || fgscf3transactionss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgscf3transactionss.size(); i++) {
            if (fgscf3transactionss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgScf3Transactions>> batches = chunkList(fgscf3transactionss, batchSize);
        int[] totalResults = new int[fgscf3transactionss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgScf3Transactions> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgScf3Transactions fgscf3transactions : batch) {
                        setFgScf3TransactionsParams(ps, fgscf3transactions);
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

    public FgScf3Transactions findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgScf3Transactions> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgScf3Transactions> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgScf3Transactions fgscf3transactions) throws SQLException {
        if (fgscf3transactions.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgScf3TransactionsParams(ps, fgscf3transactions);
            ps.setInt(24, fgscf3transactions.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgScf3Transactions> fgscf3transactionss) throws SQLException {
        if (fgscf3transactionss == null || fgscf3transactionss.isEmpty())
            return new int[0];
        for (FgScf3Transactions fgscf3transactions : fgscf3transactionss) {
            if (fgscf3transactions == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgscf3transactions.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgScf3Transactions>> batches = chunkList(fgscf3transactionss, batchSize);
        int[] totalResults = new int[fgscf3transactionss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgScf3Transactions> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgScf3Transactions fgscf3transactions : batch) {
                        setFgScf3TransactionsParams(ps, fgscf3transactions);
                        ps.setInt(24, fgscf3transactions.getID());
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

    private void setFgScf3TransactionsParams(PreparedStatement ps, FgScf3Transactions fgscf3transactions) throws SQLException {
        Integer val1 = fgscf3transactions.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgscf3transactions.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgscf3transactions.getTypeCode());
        ps.setString(4, fgscf3transactions.getSubTypeCode());
        ps.setString(5, fgscf3transactions.getActiveCode());
        ps.setString(6, fgscf3transactions.getStageCode());
        ps.setString(7, fgscf3transactions.getStatusCode());
        Integer val8 = fgscf3transactions.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgscf3transactions.getCreatedOn());
        java.math.BigDecimal val10 = fgscf3transactions.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgscf3transactions.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgscf3transactions.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgscf3transactions.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgscf3transactions.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgscf3transactions.getTemplate());
        ps.setString(16, fgscf3transactions.getApplicantParty());
        ps.setString(17, fgscf3transactions.getFulfillmentParty());
        java.math.BigDecimal val18 = fgscf3transactions.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgscf3transactions.getInvoiceNo());
        ps.setString(20, fgscf3transactions.getVendorCode());
        java.math.BigDecimal val21 = fgscf3transactions.getInvoiceAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.time.LocalDateTime val22 = fgscf3transactions.getInvoiceDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val23 = fgscf3transactions.getDueDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        Integer val24 = fgscf3transactions.getUploadRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
    }

    private FgScf3Transactions extract(ResultSet rs) throws SQLException {
        FgScf3Transactions fgscf3transactions = new FgScf3Transactions();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgscf3transactions.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgscf3transactions.setReferenceID(REFERENCE_ID);
        fgscf3transactions.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgscf3transactions.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgscf3transactions.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgscf3transactions.setStageCode(rs.getString(COL_STAGE_CODE));
        fgscf3transactions.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgscf3transactions.setProcessID(PROCESS_ID);
        fgscf3transactions.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgscf3transactions.setCreatedBy(CREATED_BY);
        fgscf3transactions.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgscf3transactions.setLastUpdatedBy(LAST_UPDATED_BY);
        fgscf3transactions.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgscf3transactions.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgscf3transactions.setTemplate(rs.getString(COL_TEMPLATE));
        fgscf3transactions.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgscf3transactions.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgscf3transactions.setIsTemplate(IS_TEMPLATE);
        fgscf3transactions.setInvoiceNo(rs.getString(COL_INVOICE_NO));
        fgscf3transactions.setVendorCode(rs.getString(COL_VENDOR_CODE));
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        fgscf3transactions.setInvoiceAmount(INVOICE_AMOUNT);
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fgscf3transactions.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        Timestamp DUE_DATE = rs.getTimestamp(COL_DUE_DATE);
        if (DUE_DATE != null)
            fgscf3transactions.setDueDate(DUE_DATE.toLocalDateTime());
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgscf3transactions.setUploadRefID(UPLOAD_REF_ID);
        return fgscf3transactions;
    }
}
