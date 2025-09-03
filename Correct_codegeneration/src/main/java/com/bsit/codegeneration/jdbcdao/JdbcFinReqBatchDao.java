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

public class JdbcFinReqBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFinReqBatchDao.class);

    private static final String TABLE = "FIN_REQ_BATCH";

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

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_BATCH_VALUE_DATE = "BATCH_VALUE_DATE";

    private static final String COL_LOAN_REF_ID = "LOAN_REF_ID";

    private static final String COL_LOAN_DUE_DATE = "LOAN_DUE_DATE";

    private static final String COL_REQUEST_AMOUNT = "REQUEST_AMOUNT";

    private static final String COL_CCY = "CCY";

    private static final String COL_RETURN_TEXT = "RETURN_TEXT";

    private static final String COL_BATCH_AMOUNT = "BATCH_AMOUNT";

    private static final String COL_LIMIT_NODE_REFERENCE = "LIMIT_NODE_REFERENCE";

    private static final String COL_SNAPSHOT_LIMIT = "SNAPSHOT_LIMIT";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_FINANCE_AMOUNT = "FINANCE_AMOUNT";

    private static final String COL_FINANCING_AMOUNT = "FINANCING_AMOUNT";

    private static final String COL_TENOR_IN_DAYS = "TENOR_IN_DAYS";

    private static final String COL_INT_PERIOD_IN_DAYS = "INT_PERIOD_IN_DAYS";

    private static final String COL_CONTRACT_PERIOD = "CONTRACT_PERIOD";

    private static final String COL_TNX_DISPLAY_REMARKS = "TNX_DISPLAY_REMARKS";

    private static final String COL_TNX_DISPLAY_STATUS = "TNX_DISPLAY_STATUS";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_LIMIT_NODE_REFERENCE2 = "LIMIT_NODE_REFERENCE2";

    private static final String COL_BATCH_DISPLAY_STATUS = "BATCH_DISPLAY_STATUS";

    private static final String COL_BATCH_DISPLAY_REMARKS = "BATCH_DISPLAY_REMARKS";

    private static final String COL_REQUEST_INITIATION_TYPE = "REQUEST_INITIATION_TYPE";

    private static final String COL_LOAN_REQUEST_TYPE = "LOAN_REQUEST_TYPE";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_BATCH_STATUS = "BATCH_STATUS";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_CUSTOMER_ROLE = "CUSTOMER_ROLE";

    private static final String COL_CP_CODE = "CP_CODE";

    private static final String COL_BATCH_ACTION = "BATCH_ACTION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_OWNER_PARTY = "OWNER_PARTY";

    private static final String COL_APPLICANT_NAME = "APPLICANT_NAME";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FINANCE_PARTY = "FINANCE_PARTY";

    private static final String COL_CP_NAME = "CP_NAME";

    private static final String COL_ANCHOR_NAME = "ANCHOR_NAME";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PARTY_TYPE, COL_CUSTOMER_CRN, COL_PROGRAM_LAYOUT, COL_LAYOUT_NAME, COL_BATCH_VALUE_DATE, COL_LOAN_REF_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_CCY, COL_RETURN_TEXT, COL_BATCH_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_SNAPSHOT_LIMIT, COL_TASK_REASON, COL_PRODUCT_TYPE, COL_FINANCE_AMOUNT, COL_FINANCING_AMOUNT, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_CONTRACT_PERIOD, COL_TNX_DISPLAY_REMARKS, COL_TNX_DISPLAY_STATUS, COL_MATURITY_DATE, COL_LIMIT_NODE_REFERENCE2, COL_BATCH_DISPLAY_STATUS, COL_BATCH_DISPLAY_REMARKS, COL_REQUEST_INITIATION_TYPE, COL_LOAN_REQUEST_TYPE, COL_LAYOUT_UUID, COL_BATCH_STATUS, COL_PRODUCT_STATUS, COL_TOTAL_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_LAYOUT_ID, COL_CUSTOMER_ROLE, COL_CP_CODE, COL_BATCH_ACTION, COL_UPLOAD_REF_ID, COL_OWNER_PARTY, COL_APPLICANT_NAME, COL_FILE_NAME, COL_FINANCE_PARTY, COL_CP_NAME, COL_ANCHOR_NAME);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, LAYOUT_NAME, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, TASK_REASON, PRODUCT_TYPE, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, TNX_DISPLAY_REMARKS, TNX_DISPLAY_STATUS, MATURITY_DATE, LIMIT_NODE_REFERENCE2, BATCH_DISPLAY_STATUS, BATCH_DISPLAY_REMARKS, REQUEST_INITIATION_TYPE, LOAN_REQUEST_TYPE, LAYOUT_UUID, BATCH_STATUS, PRODUCT_STATUS, TOTAL_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VERSION_ID, IS_MASTER_VERSION, LAYOUT_ID, CUSTOMER_ROLE, CP_CODE, BATCH_ACTION, UPLOAD_REF_ID, OWNER_PARTY, APPLICANT_NAME, FILE_NAME, FINANCE_PARTY, CP_NAME, ANCHOR_NAME", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, LAYOUT_NAME, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, TASK_REASON, PRODUCT_TYPE, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, TNX_DISPLAY_REMARKS, TNX_DISPLAY_STATUS, MATURITY_DATE, LIMIT_NODE_REFERENCE2, BATCH_DISPLAY_STATUS, BATCH_DISPLAY_REMARKS, REQUEST_INITIATION_TYPE, LOAN_REQUEST_TYPE, LAYOUT_UUID, BATCH_STATUS, PRODUCT_STATUS, TOTAL_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VERSION_ID, IS_MASTER_VERSION, LAYOUT_ID, CUSTOMER_ROLE, CP_CODE, BATCH_ACTION, UPLOAD_REF_ID, OWNER_PARTY, APPLICANT_NAME, FILE_NAME, FINANCE_PARTY, CP_NAME, ANCHOR_NAME", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PARTY_TYPE, COL_CUSTOMER_CRN, COL_PROGRAM_LAYOUT, COL_LAYOUT_NAME, COL_BATCH_VALUE_DATE, COL_LOAN_REF_ID, COL_LOAN_DUE_DATE, COL_REQUEST_AMOUNT, COL_CCY, COL_RETURN_TEXT, COL_BATCH_AMOUNT, COL_LIMIT_NODE_REFERENCE, COL_SNAPSHOT_LIMIT, COL_TASK_REASON, COL_PRODUCT_TYPE, COL_FINANCE_AMOUNT, COL_FINANCING_AMOUNT, COL_TENOR_IN_DAYS, COL_INT_PERIOD_IN_DAYS, COL_CONTRACT_PERIOD, COL_TNX_DISPLAY_REMARKS, COL_TNX_DISPLAY_STATUS, COL_MATURITY_DATE, COL_LIMIT_NODE_REFERENCE2, COL_BATCH_DISPLAY_STATUS, COL_BATCH_DISPLAY_REMARKS, COL_REQUEST_INITIATION_TYPE, COL_LOAN_REQUEST_TYPE, COL_LAYOUT_UUID, COL_BATCH_STATUS, COL_PRODUCT_STATUS, COL_TOTAL_COUNT, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_LAYOUT_ID, COL_CUSTOMER_ROLE, COL_CP_CODE, COL_BATCH_ACTION, COL_UPLOAD_REF_ID, COL_OWNER_PARTY, COL_APPLICANT_NAME, COL_FILE_NAME, COL_FINANCE_PARTY, COL_CP_NAME, COL_ANCHOR_NAME, COL_ID);

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

    public int insert(Connection conn, FinReqBatch finreqbatch) throws SQLException {
        logger.debug("Inserting finreqbatch: {}", finreqbatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFinReqBatchParams(ps, finreqbatch);
            ps.executeUpdate();
            return finreqbatch.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FinReqBatch> finreqbatchs) throws SQLException {
        if (finreqbatchs == null || finreqbatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < finreqbatchs.size(); i++) {
            if (finreqbatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FinReqBatch>> batches = chunkList(finreqbatchs, batchSize);
        int[] totalResults = new int[finreqbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FinReqBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FinReqBatch finreqbatch : batch) {
                        setFinReqBatchParams(ps, finreqbatch);
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

    public FinReqBatch findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FinReqBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FinReqBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, FinReqBatch finreqbatch) throws SQLException {
        if (finreqbatch.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFinReqBatchParams(ps, finreqbatch);
            ps.setInt(65, finreqbatch.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FinReqBatch> finreqbatchs) throws SQLException {
        if (finreqbatchs == null || finreqbatchs.isEmpty())
            return new int[0];
        for (FinReqBatch finreqbatch : finreqbatchs) {
            if (finreqbatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (finreqbatch.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FinReqBatch>> batches = chunkList(finreqbatchs, batchSize);
        int[] totalResults = new int[finreqbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FinReqBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FinReqBatch finreqbatch : batch) {
                        setFinReqBatchParams(ps, finreqbatch);
                        ps.setInt(65, finreqbatch.getID());
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

    private void setFinReqBatchParams(PreparedStatement ps, FinReqBatch finreqbatch) throws SQLException {
        Integer val1 = finreqbatch.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = finreqbatch.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, finreqbatch.getTypeCode());
        ps.setString(4, finreqbatch.getSubTypeCode());
        ps.setString(5, finreqbatch.getActiveCode());
        ps.setString(6, finreqbatch.getStageCode());
        ps.setString(7, finreqbatch.getStatusCode());
        Integer val8 = finreqbatch.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, finreqbatch.getCreatedOn());
        java.math.BigDecimal val10 = finreqbatch.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, finreqbatch.getLastUpdatedOn());
        java.math.BigDecimal val12 = finreqbatch.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, finreqbatch.getLastAuthorisedOn());
        java.math.BigDecimal val14 = finreqbatch.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, finreqbatch.getTemplate());
        ps.setString(16, finreqbatch.getApplicantParty());
        ps.setString(17, finreqbatch.getFulfillmentParty());
        java.math.BigDecimal val18 = finreqbatch.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, finreqbatch.getPartyType());
        ps.setString(20, finreqbatch.getCustomerCrn());
        ps.setString(21, finreqbatch.getProgramLayout());
        ps.setString(22, finreqbatch.getLayoutName());
        java.time.LocalDateTime val23 = finreqbatch.getBatchValueDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        Integer val24 = finreqbatch.getLoanRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.time.LocalDateTime val25 = finreqbatch.getLoanDueDate();
        if (val25 != null) {
            ps.setTimestamp(25, java.sql.Timestamp.valueOf(val25));
        } else {
            ps.setNull(25, Types.TIMESTAMP);
        }
        java.math.BigDecimal val26 = finreqbatch.getRequestAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, finreqbatch.getCcy());
        ps.setString(28, finreqbatch.getReturnText());
        java.math.BigDecimal val29 = finreqbatch.getBatchAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, finreqbatch.getLimitNodeReference());
        java.math.BigDecimal val31 = finreqbatch.getSnapshotLimit();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, finreqbatch.getTaskReason());
        ps.setString(33, finreqbatch.getProductType());
        java.math.BigDecimal val34 = finreqbatch.getFinanceAmount();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = finreqbatch.getFinancingAmount();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.math.BigDecimal val36 = finreqbatch.getTenorInDays();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = finreqbatch.getIntPeriodInDays();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = finreqbatch.getContractPeriod();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, finreqbatch.getTnxDisplayRemarks());
        ps.setString(40, finreqbatch.getTnxDisplayStatus());
        java.time.LocalDateTime val41 = finreqbatch.getMaturityDate();
        if (val41 != null) {
            ps.setTimestamp(41, java.sql.Timestamp.valueOf(val41));
        } else {
            ps.setNull(41, Types.TIMESTAMP);
        }
        ps.setString(42, finreqbatch.getLimitNodeReference2());
        ps.setString(43, finreqbatch.getBatchDisplayStatus());
        ps.setString(44, finreqbatch.getBatchDisplayRemarks());
        ps.setString(45, finreqbatch.getRequestInitiationType());
        ps.setString(46, finreqbatch.getLoanRequestType());
        ps.setString(47, finreqbatch.getLayoutUuid());
        ps.setString(48, finreqbatch.getBatchStatus());
        ps.setString(49, finreqbatch.getProductStatus());
        java.math.BigDecimal val50 = finreqbatch.getTotalCount();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        ps.setString(51, finreqbatch.getEntityTypeCode());
        ps.setString(52, finreqbatch.getEntitySubTypeCode());
        Integer val53 = finreqbatch.getVersionID();
        if (val53 != null) {
            ps.setInt(53, val53);
        } else {
            ps.setNull(53, Types.INTEGER);
        }
        java.math.BigDecimal val54 = finreqbatch.getIsMasterVersion();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        Integer val55 = finreqbatch.getLayoutID();
        if (val55 != null) {
            ps.setInt(55, val55);
        } else {
            ps.setNull(55, Types.INTEGER);
        }
        ps.setString(56, finreqbatch.getCustomerRole());
        ps.setString(57, finreqbatch.getCpCode());
        ps.setString(58, finreqbatch.getBatchAction());
        Integer val59 = finreqbatch.getUploadRefID();
        if (val59 != null) {
            ps.setInt(59, val59);
        } else {
            ps.setNull(59, Types.INTEGER);
        }
        ps.setString(60, finreqbatch.getOwnerParty());
        ps.setString(61, finreqbatch.getApplicantName());
        ps.setString(62, finreqbatch.getFileName());
        ps.setString(63, finreqbatch.getFinanceParty());
        ps.setString(64, finreqbatch.getCpName());
        ps.setString(65, finreqbatch.getAnchorName());
    }

    private FinReqBatch extract(ResultSet rs) throws SQLException {
        FinReqBatch finreqbatch = new FinReqBatch();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        finreqbatch.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        finreqbatch.setReferenceID(REFERENCE_ID);
        finreqbatch.setTypeCode(rs.getString(COL_TYPE_CODE));
        finreqbatch.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        finreqbatch.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        finreqbatch.setStageCode(rs.getString(COL_STAGE_CODE));
        finreqbatch.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        finreqbatch.setProcessID(PROCESS_ID);
        finreqbatch.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        finreqbatch.setCreatedBy(CREATED_BY);
        finreqbatch.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        finreqbatch.setLastUpdatedBy(LAST_UPDATED_BY);
        finreqbatch.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        finreqbatch.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        finreqbatch.setTemplate(rs.getString(COL_TEMPLATE));
        finreqbatch.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        finreqbatch.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        finreqbatch.setIsTemplate(IS_TEMPLATE);
        finreqbatch.setPartyType(rs.getString(COL_PARTY_TYPE));
        finreqbatch.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        finreqbatch.setProgramLayout(rs.getString(COL_PROGRAM_LAYOUT));
        finreqbatch.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Timestamp BATCH_VALUE_DATE = rs.getTimestamp(COL_BATCH_VALUE_DATE);
        if (BATCH_VALUE_DATE != null)
            finreqbatch.setBatchValueDate(BATCH_VALUE_DATE.toLocalDateTime());
        Integer LOAN_REF_ID = rs.getObject(COL_LOAN_REF_ID, Integer.class);
        finreqbatch.setLoanRefID(LOAN_REF_ID);
        Timestamp LOAN_DUE_DATE = rs.getTimestamp(COL_LOAN_DUE_DATE);
        if (LOAN_DUE_DATE != null)
            finreqbatch.setLoanDueDate(LOAN_DUE_DATE.toLocalDateTime());
        java.math.BigDecimal REQUEST_AMOUNT = rs.getObject(COL_REQUEST_AMOUNT, java.math.BigDecimal.class);
        finreqbatch.setRequestAmount(REQUEST_AMOUNT);
        finreqbatch.setCcy(rs.getString(COL_CCY));
        finreqbatch.setReturnText(rs.getString(COL_RETURN_TEXT));
        java.math.BigDecimal BATCH_AMOUNT = rs.getObject(COL_BATCH_AMOUNT, java.math.BigDecimal.class);
        finreqbatch.setBatchAmount(BATCH_AMOUNT);
        finreqbatch.setLimitNodeReference(rs.getString(COL_LIMIT_NODE_REFERENCE));
        java.math.BigDecimal SNAPSHOT_LIMIT = rs.getObject(COL_SNAPSHOT_LIMIT, java.math.BigDecimal.class);
        finreqbatch.setSnapshotLimit(SNAPSHOT_LIMIT);
        finreqbatch.setTaskReason(rs.getString(COL_TASK_REASON));
        finreqbatch.setProductType(rs.getString(COL_PRODUCT_TYPE));
        java.math.BigDecimal FINANCE_AMOUNT = rs.getObject(COL_FINANCE_AMOUNT, java.math.BigDecimal.class);
        finreqbatch.setFinanceAmount(FINANCE_AMOUNT);
        java.math.BigDecimal FINANCING_AMOUNT = rs.getObject(COL_FINANCING_AMOUNT, java.math.BigDecimal.class);
        finreqbatch.setFinancingAmount(FINANCING_AMOUNT);
        java.math.BigDecimal TENOR_IN_DAYS = rs.getObject(COL_TENOR_IN_DAYS, java.math.BigDecimal.class);
        finreqbatch.setTenorInDays(TENOR_IN_DAYS);
        java.math.BigDecimal INT_PERIOD_IN_DAYS = rs.getObject(COL_INT_PERIOD_IN_DAYS, java.math.BigDecimal.class);
        finreqbatch.setIntPeriodInDays(INT_PERIOD_IN_DAYS);
        java.math.BigDecimal CONTRACT_PERIOD = rs.getObject(COL_CONTRACT_PERIOD, java.math.BigDecimal.class);
        finreqbatch.setContractPeriod(CONTRACT_PERIOD);
        finreqbatch.setTnxDisplayRemarks(rs.getString(COL_TNX_DISPLAY_REMARKS));
        finreqbatch.setTnxDisplayStatus(rs.getString(COL_TNX_DISPLAY_STATUS));
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            finreqbatch.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        finreqbatch.setLimitNodeReference2(rs.getString(COL_LIMIT_NODE_REFERENCE2));
        finreqbatch.setBatchDisplayStatus(rs.getString(COL_BATCH_DISPLAY_STATUS));
        finreqbatch.setBatchDisplayRemarks(rs.getString(COL_BATCH_DISPLAY_REMARKS));
        finreqbatch.setRequestInitiationType(rs.getString(COL_REQUEST_INITIATION_TYPE));
        finreqbatch.setLoanRequestType(rs.getString(COL_LOAN_REQUEST_TYPE));
        finreqbatch.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        finreqbatch.setBatchStatus(rs.getString(COL_BATCH_STATUS));
        finreqbatch.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        finreqbatch.setTotalCount(TOTAL_COUNT);
        finreqbatch.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        finreqbatch.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        finreqbatch.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        finreqbatch.setIsMasterVersion(IS_MASTER_VERSION);
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        finreqbatch.setLayoutID(LAYOUT_ID);
        finreqbatch.setCustomerRole(rs.getString(COL_CUSTOMER_ROLE));
        finreqbatch.setCpCode(rs.getString(COL_CP_CODE));
        finreqbatch.setBatchAction(rs.getString(COL_BATCH_ACTION));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        finreqbatch.setUploadRefID(UPLOAD_REF_ID);
        finreqbatch.setOwnerParty(rs.getString(COL_OWNER_PARTY));
        finreqbatch.setApplicantName(rs.getString(COL_APPLICANT_NAME));
        finreqbatch.setFileName(rs.getString(COL_FILE_NAME));
        finreqbatch.setFinanceParty(rs.getString(COL_FINANCE_PARTY));
        finreqbatch.setCpName(rs.getString(COL_CP_NAME));
        finreqbatch.setAnchorName(rs.getString(COL_ANCHOR_NAME));
        return finreqbatch;
    }
}
