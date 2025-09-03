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

public class JdbcScfTxnBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfTxnBatchDao.class);

    private static final String TABLE = "SCF_TXN_BATCH";

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

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ANCHOR_CRN = "ANCHOR_CRN";

    private static final String COL_FILE_MASTER_REF_NO = "FILE_MASTER_REF_NO";

    private static final String COL_SCF_REQ_REF_NO = "SCF_REQ_REF_NO";

    private static final String COL_TXN_BATCH_COUNT = "TXN_BATCH_COUNT";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_UTR_REF_NO = "UTR_REF_NO";

    private static final String COL_FINANCE_REF_NO = "FINANCE_REF_NO";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_EVENTS_PAY_RES_REF_NO = "EVENTS_PAY_RES_REF_NO";

    private static final String COL_CMS_REF_NO = "CMS_REF_NO";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_SCF_REQ_REF_NO, COL_TXN_BATCH_COUNT, COL_PRODUCT_TYPE, COL_UTR_REF_NO, COL_FINANCE_REF_NO, COL_STATUS, COL_REMARKS, COL_EVENTS_PAY_RES_REF_NO, COL_CMS_REF_NO, COL_PURPOSE_CODE, COL_TOTAL_COUNT, COL_TOTAL_AMOUNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, SCF_REQ_REF_NO, TXN_BATCH_COUNT, PRODUCT_TYPE, UTR_REF_NO, FINANCE_REF_NO, STATUS, REMARKS, EVENTS_PAY_RES_REF_NO, CMS_REF_NO, PURPOSE_CODE, TOTAL_COUNT, TOTAL_AMOUNT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, SCF_REQ_REF_NO, TXN_BATCH_COUNT, PRODUCT_TYPE, UTR_REF_NO, FINANCE_REF_NO, STATUS, REMARKS, EVENTS_PAY_RES_REF_NO, CMS_REF_NO, PURPOSE_CODE, TOTAL_COUNT, TOTAL_AMOUNT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_MASTER_REF_NO, COL_SCF_REQ_REF_NO, COL_TXN_BATCH_COUNT, COL_PRODUCT_TYPE, COL_UTR_REF_NO, COL_FINANCE_REF_NO, COL_STATUS, COL_REMARKS, COL_EVENTS_PAY_RES_REF_NO, COL_CMS_REF_NO, COL_PURPOSE_CODE, COL_TOTAL_COUNT, COL_TOTAL_AMOUNT, COL_ID);

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

    public int insert(Connection conn, ScfTxnBatch scftxnbatch) throws SQLException {
        logger.debug("Inserting scftxnbatch: {}", scftxnbatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfTxnBatchParams(ps, scftxnbatch);
            ps.executeUpdate();
            return scftxnbatch.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfTxnBatch> scftxnbatchs) throws SQLException {
        if (scftxnbatchs == null || scftxnbatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < scftxnbatchs.size(); i++) {
            if (scftxnbatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfTxnBatch>> batches = chunkList(scftxnbatchs, batchSize);
        int[] totalResults = new int[scftxnbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfTxnBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfTxnBatch scftxnbatch : batch) {
                        setScfTxnBatchParams(ps, scftxnbatch);
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

    public ScfTxnBatch findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfTxnBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfTxnBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfTxnBatch scftxnbatch) throws SQLException {
        if (scftxnbatch.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfTxnBatchParams(ps, scftxnbatch);
            ps.setInt(29, scftxnbatch.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfTxnBatch> scftxnbatchs) throws SQLException {
        if (scftxnbatchs == null || scftxnbatchs.isEmpty())
            return new int[0];
        for (ScfTxnBatch scftxnbatch : scftxnbatchs) {
            if (scftxnbatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scftxnbatch.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfTxnBatch>> batches = chunkList(scftxnbatchs, batchSize);
        int[] totalResults = new int[scftxnbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfTxnBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfTxnBatch scftxnbatch : batch) {
                        setScfTxnBatchParams(ps, scftxnbatch);
                        ps.setInt(29, scftxnbatch.getID());
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

    private void setScfTxnBatchParams(PreparedStatement ps, ScfTxnBatch scftxnbatch) throws SQLException {
        Integer val1 = scftxnbatch.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scftxnbatch.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scftxnbatch.getTypeCode());
        ps.setString(4, scftxnbatch.getSubTypeCode());
        ps.setString(5, scftxnbatch.getActiveCode());
        ps.setString(6, scftxnbatch.getStageCode());
        ps.setString(7, scftxnbatch.getStatusCode());
        ps.setString(8, scftxnbatch.getCreatedOn());
        java.math.BigDecimal val9 = scftxnbatch.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scftxnbatch.getLastUpdatedOn());
        java.math.BigDecimal val11 = scftxnbatch.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scftxnbatch.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scftxnbatch.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scftxnbatch.getTemplate());
        java.math.BigDecimal val15 = scftxnbatch.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scftxnbatch.getAnchorCrn());
        ps.setString(17, scftxnbatch.getFileMasterRefNo());
        ps.setString(18, scftxnbatch.getScfReqRefNo());
        java.math.BigDecimal val19 = scftxnbatch.getTxnBatchCount();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, scftxnbatch.getProductType());
        ps.setString(21, scftxnbatch.getUtrRefNo());
        ps.setString(22, scftxnbatch.getFinanceRefNo());
        ps.setString(23, scftxnbatch.getStatus());
        ps.setString(24, scftxnbatch.getRemarks());
        ps.setString(25, scftxnbatch.getEventsPayResRefNo());
        ps.setString(26, scftxnbatch.getCmsRefNo());
        ps.setString(27, scftxnbatch.getPurposeCode());
        java.math.BigDecimal val28 = scftxnbatch.getTotalCount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = scftxnbatch.getTotalAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
    }

    private ScfTxnBatch extract(ResultSet rs) throws SQLException {
        ScfTxnBatch scftxnbatch = new ScfTxnBatch();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scftxnbatch.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scftxnbatch.setReferenceID(REFERENCE_ID);
        scftxnbatch.setTypeCode(rs.getString(COL_TYPE_CODE));
        scftxnbatch.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scftxnbatch.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scftxnbatch.setStageCode(rs.getString(COL_STAGE_CODE));
        scftxnbatch.setStatusCode(rs.getString(COL_STATUS_CODE));
        scftxnbatch.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scftxnbatch.setCreatedBy(CREATED_BY);
        scftxnbatch.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scftxnbatch.setLastUpdatedBy(LAST_UPDATED_BY);
        scftxnbatch.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scftxnbatch.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scftxnbatch.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scftxnbatch.setIsTemplate(IS_TEMPLATE);
        scftxnbatch.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scftxnbatch.setFileMasterRefNo(rs.getString(COL_FILE_MASTER_REF_NO));
        scftxnbatch.setScfReqRefNo(rs.getString(COL_SCF_REQ_REF_NO));
        java.math.BigDecimal TXN_BATCH_COUNT = rs.getObject(COL_TXN_BATCH_COUNT, java.math.BigDecimal.class);
        scftxnbatch.setTxnBatchCount(TXN_BATCH_COUNT);
        scftxnbatch.setProductType(rs.getString(COL_PRODUCT_TYPE));
        scftxnbatch.setUtrRefNo(rs.getString(COL_UTR_REF_NO));
        scftxnbatch.setFinanceRefNo(rs.getString(COL_FINANCE_REF_NO));
        scftxnbatch.setStatus(rs.getString(COL_STATUS));
        scftxnbatch.setRemarks(rs.getString(COL_REMARKS));
        scftxnbatch.setEventsPayResRefNo(rs.getString(COL_EVENTS_PAY_RES_REF_NO));
        scftxnbatch.setCmsRefNo(rs.getString(COL_CMS_REF_NO));
        scftxnbatch.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        scftxnbatch.setTotalCount(TOTAL_COUNT);
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        scftxnbatch.setTotalAmount(TOTAL_AMOUNT);
        return scftxnbatch;
    }
}
