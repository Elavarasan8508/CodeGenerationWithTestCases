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

public class JdbcKmblScfFinReqBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcKmblScfFinReqBatchDao.class);

    private static final String TABLE = "KMBL_SCF_FIN_REQ_BATCH";

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

    private static final String COL_PARTY_TYPE = "PARTY_TYPE";

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_PROGRAM_LAYOUT = "PROGRAM_LAYOUT";

    private static final String COL_BATCH_VALUE_DATE = "BATCH_VALUE_DATE";

    private static final String COL_LOAN_REF_ID = "LOAN_REF_ID";

    private static final String COL_LOAN_DUE_DATE = "LOAN_DUE_DATE";

    private static final String COL_REQUEST_AMOUNT = "REQUEST_AMOUNT";

    private static final String COL_CCY = "CCY";

    private static final String COL_RETURN_TEXT = "RETURN_TEXT";

    private static final String COL_BATCH_AMOUNT = "BATCH_AMOUNT";

    private static final String COL_LIMIT_NODE_REFERENCE = "LIMIT_NODE_REFERENCE";

    private static final String COL_SNAPSHOT_LIMIT = "SNAPSHOT_LIMIT";

    private static final String COL_REMARKS = "REMARKS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PARTY_TYPE, COL_CUSTOMER_CRN, COL_PROGRAM_LAYOUT, COL_BATCH_VALUE_DATE, COL_LOAN_REF_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_CCY, COL_RETURN_TEXT, COL_BATCH_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_SNAPSHOT_LIMIT, COL_REMARKS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, REMARKS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, REMARKS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PARTY_TYPE, COL_CUSTOMER_CRN, COL_PROGRAM_LAYOUT, COL_BATCH_VALUE_DATE, COL_LOAN_REF_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_CCY, COL_RETURN_TEXT, COL_BATCH_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_SNAPSHOT_LIMIT, COL_REMARKS, COL_ID);

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

    public int insert(Connection conn, KmblScfFinReqBatch kmblscffinreqbatch) throws SQLException {
        logger.debug("Inserting kmblscffinreqbatch: {}", kmblscffinreqbatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setKmblScfFinReqBatchParams(ps, kmblscffinreqbatch);
            ps.executeUpdate();
            return kmblscffinreqbatch.getID();
        }
    }

    public int[] insertAll(Connection conn, List<KmblScfFinReqBatch> kmblscffinreqbatchs) throws SQLException {
        if (kmblscffinreqbatchs == null || kmblscffinreqbatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < kmblscffinreqbatchs.size(); i++) {
            if (kmblscffinreqbatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfFinReqBatch>> batches = chunkList(kmblscffinreqbatchs, batchSize);
        int[] totalResults = new int[kmblscffinreqbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfFinReqBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (KmblScfFinReqBatch kmblscffinreqbatch : batch) {
                        setKmblScfFinReqBatchParams(ps, kmblscffinreqbatch);
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

    public KmblScfFinReqBatch findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<KmblScfFinReqBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<KmblScfFinReqBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, KmblScfFinReqBatch kmblscffinreqbatch) throws SQLException {
        if (kmblscffinreqbatch.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setKmblScfFinReqBatchParams(ps, kmblscffinreqbatch);
            ps.setInt(31, kmblscffinreqbatch.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<KmblScfFinReqBatch> kmblscffinreqbatchs) throws SQLException {
        if (kmblscffinreqbatchs == null || kmblscffinreqbatchs.isEmpty())
            return new int[0];
        for (KmblScfFinReqBatch kmblscffinreqbatch : kmblscffinreqbatchs) {
            if (kmblscffinreqbatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (kmblscffinreqbatch.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfFinReqBatch>> batches = chunkList(kmblscffinreqbatchs, batchSize);
        int[] totalResults = new int[kmblscffinreqbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfFinReqBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (KmblScfFinReqBatch kmblscffinreqbatch : batch) {
                        setKmblScfFinReqBatchParams(ps, kmblscffinreqbatch);
                        ps.setInt(31, kmblscffinreqbatch.getID());
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

    private void setKmblScfFinReqBatchParams(PreparedStatement ps, KmblScfFinReqBatch kmblscffinreqbatch) throws SQLException {
        Integer val1 = kmblscffinreqbatch.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = kmblscffinreqbatch.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, kmblscffinreqbatch.getTypeCode());
        ps.setString(4, kmblscffinreqbatch.getSubTypeCode());
        ps.setString(5, kmblscffinreqbatch.getActiveCode());
        ps.setString(6, kmblscffinreqbatch.getStageCode());
        ps.setString(7, kmblscffinreqbatch.getStatusCode());
        Integer val8 = kmblscffinreqbatch.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, kmblscffinreqbatch.getCreatedOn());
        java.math.BigDecimal val10 = kmblscffinreqbatch.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, kmblscffinreqbatch.getLastUpdatedOn());
        java.math.BigDecimal val12 = kmblscffinreqbatch.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, kmblscffinreqbatch.getLastAuthorisedOn());
        java.math.BigDecimal val14 = kmblscffinreqbatch.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, kmblscffinreqbatch.getTemplate());
        ps.setString(16, kmblscffinreqbatch.getApplicantParty());
        ps.setString(17, kmblscffinreqbatch.getFulfillmentParty());
        java.math.BigDecimal val18 = kmblscffinreqbatch.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, kmblscffinreqbatch.getPartyType());
        ps.setString(20, kmblscffinreqbatch.getCustomerCrn());
        ps.setString(21, kmblscffinreqbatch.getProgramLayout());
        java.time.LocalDateTime val22 = kmblscffinreqbatch.getBatchValueDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        Integer val23 = kmblscffinreqbatch.getLoanRefID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        java.time.LocalDateTime val24 = kmblscffinreqbatch.getLoanDueDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        java.math.BigDecimal val25 = kmblscffinreqbatch.getRequestAmount();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, kmblscffinreqbatch.getCcy());
        ps.setString(27, kmblscffinreqbatch.getReturnText());
        java.math.BigDecimal val28 = kmblscffinreqbatch.getBatchAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, kmblscffinreqbatch.getLimitNodeReference());
        java.math.BigDecimal val30 = kmblscffinreqbatch.getSnapshotLimit();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, kmblscffinreqbatch.getRemarks());
    }

    private KmblScfFinReqBatch extract(ResultSet rs) throws SQLException {
        KmblScfFinReqBatch kmblscffinreqbatch = new KmblScfFinReqBatch();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        kmblscffinreqbatch.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        kmblscffinreqbatch.setReferenceID(REFERENCE_ID);
        kmblscffinreqbatch.setTypeCode(rs.getString(COL_TYPE_CODE));
        kmblscffinreqbatch.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        kmblscffinreqbatch.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        kmblscffinreqbatch.setStageCode(rs.getString(COL_STAGE_CODE));
        kmblscffinreqbatch.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        kmblscffinreqbatch.setProcessID(PROCESS_ID);
        kmblscffinreqbatch.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        kmblscffinreqbatch.setCreatedBy(CREATED_BY);
        kmblscffinreqbatch.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        kmblscffinreqbatch.setLastUpdatedBy(LAST_UPDATED_BY);
        kmblscffinreqbatch.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        kmblscffinreqbatch.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        kmblscffinreqbatch.setTemplate(rs.getString(COL_TEMPLATE));
        kmblscffinreqbatch.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        kmblscffinreqbatch.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        kmblscffinreqbatch.setIsTemplate(IS_TEMPLATE);
        kmblscffinreqbatch.setPartyType(rs.getString(COL_PARTY_TYPE));
        kmblscffinreqbatch.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        kmblscffinreqbatch.setProgramLayout(rs.getString(COL_PROGRAM_LAYOUT));
        Timestamp BATCH_VALUE_DATE = rs.getTimestamp(COL_BATCH_VALUE_DATE);
        if (BATCH_VALUE_DATE != null)
            kmblscffinreqbatch.setBatchValueDate(BATCH_VALUE_DATE.toLocalDateTime());
        Integer LOAN_REF_ID = rs.getObject(COL_LOAN_REF_ID, Integer.class);
        kmblscffinreqbatch.setLoanRefID(LOAN_REF_ID);
        Timestamp LOAN_DUE_DATE = rs.getTimestamp(COL_LOAN_DUE_DATE);
        if (LOAN_DUE_DATE != null)
            kmblscffinreqbatch.setLoanDueDate(LOAN_DUE_DATE.toLocalDateTime());
        java.math.BigDecimal REQUEST_AMOUNT = rs.getObject(COL_REQUEST_AMOUNT, java.math.BigDecimal.class);
        kmblscffinreqbatch.setRequestAmount(REQUEST_AMOUNT);
        kmblscffinreqbatch.setCcy(rs.getString(COL_CCY));
        kmblscffinreqbatch.setReturnText(rs.getString(COL_RETURN_TEXT));
        java.math.BigDecimal BATCH_AMOUNT = rs.getObject(COL_BATCH_AMOUNT, java.math.BigDecimal.class);
        kmblscffinreqbatch.setBatchAmount(BATCH_AMOUNT);
        kmblscffinreqbatch.setLimitNodeReference(rs.getString(COL_LIMIT_NODE_REFERENCE));
        java.math.BigDecimal SNAPSHOT_LIMIT = rs.getObject(COL_SNAPSHOT_LIMIT, java.math.BigDecimal.class);
        kmblscffinreqbatch.setSnapshotLimit(SNAPSHOT_LIMIT);
        kmblscffinreqbatch.setRemarks(rs.getString(COL_REMARKS));
        return kmblscffinreqbatch;
    }
}
