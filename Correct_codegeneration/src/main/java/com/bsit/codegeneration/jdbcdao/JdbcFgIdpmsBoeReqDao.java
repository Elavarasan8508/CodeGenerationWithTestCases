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

public class JdbcFgIdpmsBoeReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgIdpmsBoeReqDao.class);

    private static final String TABLE = "FG_IDPMS_BOE_REQ";

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

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_PORT_OF_DIS = "PORT_OF_DIS";

    private static final String COL_IMPORT_AGENCY = "IMPORT_AGENCY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_OVERDUE_PERIOD = "OVERDUE_PERIOD";

    private static final String COL_INVOICE_SL_NO = "INVOICE_SL_NO";

    private static final String COL_INV_NUM = "INV_NUM";

    private static final String COL_TERMS_OF_INV = "TERMS_OF_INV";

    private static final String COL_INV_CCY = "INV_CCY";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_SUPPLIER_ADDR = "SUPPLIER_ADDR";

    private static final String COL_SUPPLIER_COUNTRY = "SUPPLIER_COUNTRY";

    private static final String COL_SELLER_NAME = "SELLER_NAME";

    private static final String COL_SELLER_ADDR = "SELLER_ADDR";

    private static final String COL_SELLER_COUNTRY = "SELLER_COUNTRY";

    private static final String COL_UTILIZED_INV_AMT = "UTILIZED_INV_AMT";

    private static final String COL_OS_INV_AMT = "OS_INV_AMT";

    private static final String COL_ENDORSED_AMT = "ENDORSED_AMT";

    private static final String COL_CLOSURE_INDICATOR = "CLOSURE_INDICATOR";

    private static final String COL_ADJ_AMT = "ADJ_AMT";

    private static final String COL_ADJ_REASON = "ADJ_REASON";

    private static final String COL_EXTENDED_DATE = "EXTENDED_DATE";

    private static final String COL_EXTENDED_BY = "EXTENDED_BY";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_TRRACS_STATUS = "TRRACS_STATUS";

    private static final String COL_TRRACS_ERROR_CODE = "TRRACS_ERROR_CODE";

    private static final String COL_TRRACS_ERROR_DESC = "TRRACS_ERROR_DESC";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_FINAL_ERROR_DESC = "FINAL_ERROR_DESC";

    private static final String COL_FINAL_ERROR_CODE = "FINAL_ERROR_CODE";

    private static final String COL_FINAL_STATUS = "FINAL_STATUS";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_DOC_NO = "DOC_NO";

    private static final String COL_DOC_DATE = "DOC_DATE";

    private static final String COL_LETTER_DATE = "LETTER_DATE";

    private static final String COL_LETTER_NO = "LETTER_NO";

    private static final String COL_APPROVED_BY = "APPROVED_BY";

    private static final String COL_CHECKBOX = "CHECKBOX";

    private static final String COL_RBI_STATUS = "RBI_STATUS";

    private static final String COL_RBI_ERROR_DESC = "RBI_ERROR_DESC";

    private static final String COL_RBI_ERROR_CODE = "RBI_ERROR_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_IE_CODE, COL_OVERDUE_PERIOD, COL_INVOICE_SL_NO, COL_INV_NUM, COL_TERMS_OF_INV, COL_INV_CCY, COL_INV_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_UTILIZED_INV_AMT, COL_OS_INV_AMT, COL_ENDORSED_AMT, COL_CLOSURE_INDICATOR, COL_ADJ_AMT, COL_ADJ_REASON, COL_EXTENDED_DATE, COL_EXTENDED_BY, COL_REMARKS, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DESC, COL_REQ_TYPE, COL_FINAL_ERROR_DESC, COL_FINAL_ERROR_CODE, COL_FINAL_STATUS, COL_AD_CODE, COL_DOC_NO, COL_DOC_DATE, COL_LETTER_DATE, COL_LETTER_NO, COL_APPROVED_BY, COL_CHECKBOX, COL_RBI_STATUS, COL_RBI_ERROR_DESC, COL_RBI_ERROR_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT, ENDORSED_AMT, CLOSURE_INDICATOR, ADJ_AMT, ADJ_REASON, EXTENDED_DATE, EXTENDED_BY, REMARKS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, FINAL_ERROR_DESC, FINAL_ERROR_CODE, FINAL_STATUS, AD_CODE, DOC_NO, DOC_DATE, LETTER_DATE, LETTER_NO, APPROVED_BY, CHECKBOX, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT, ENDORSED_AMT, CLOSURE_INDICATOR, ADJ_AMT, ADJ_REASON, EXTENDED_DATE, EXTENDED_BY, REMARKS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, FINAL_ERROR_DESC, FINAL_ERROR_CODE, FINAL_STATUS, AD_CODE, DOC_NO, DOC_DATE, LETTER_DATE, LETTER_NO, APPROVED_BY, CHECKBOX, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_IE_CODE, COL_OVERDUE_PERIOD, COL_INVOICE_SL_NO, COL_INV_NUM, COL_TERMS_OF_INV, COL_INV_CCY, COL_INV_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_UTILIZED_INV_AMT, COL_OS_INV_AMT, COL_ENDORSED_AMT, COL_CLOSURE_INDICATOR, COL_ADJ_AMT, COL_ADJ_REASON, COL_EXTENDED_DATE, COL_EXTENDED_BY, COL_REMARKS, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DESC, COL_REQ_TYPE, COL_FINAL_ERROR_DESC, COL_FINAL_ERROR_CODE, COL_FINAL_STATUS, COL_AD_CODE, COL_DOC_NO, COL_DOC_DATE, COL_LETTER_DATE, COL_LETTER_NO, COL_APPROVED_BY, COL_CHECKBOX, COL_RBI_STATUS, COL_RBI_ERROR_DESC, COL_RBI_ERROR_CODE, COL_ID);

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

    public int insert(Connection conn, FgIdpmsBoeReq fgidpmsboereq) throws SQLException {
        logger.debug("Inserting fgidpmsboereq: {}", fgidpmsboereq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgIdpmsBoeReqParams(ps, fgidpmsboereq);
            ps.executeUpdate();
            return fgidpmsboereq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgIdpmsBoeReq> fgidpmsboereqs) throws SQLException {
        if (fgidpmsboereqs == null || fgidpmsboereqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgidpmsboereqs.size(); i++) {
            if (fgidpmsboereqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsBoeReq>> batches = chunkList(fgidpmsboereqs, batchSize);
        int[] totalResults = new int[fgidpmsboereqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsBoeReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgIdpmsBoeReq fgidpmsboereq : batch) {
                        setFgIdpmsBoeReqParams(ps, fgidpmsboereq);
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

    public FgIdpmsBoeReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgIdpmsBoeReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgIdpmsBoeReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgIdpmsBoeReq fgidpmsboereq) throws SQLException {
        if (fgidpmsboereq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgIdpmsBoeReqParams(ps, fgidpmsboereq);
            ps.setInt(60, fgidpmsboereq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgIdpmsBoeReq> fgidpmsboereqs) throws SQLException {
        if (fgidpmsboereqs == null || fgidpmsboereqs.isEmpty())
            return new int[0];
        for (FgIdpmsBoeReq fgidpmsboereq : fgidpmsboereqs) {
            if (fgidpmsboereq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgidpmsboereq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsBoeReq>> batches = chunkList(fgidpmsboereqs, batchSize);
        int[] totalResults = new int[fgidpmsboereqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsBoeReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgIdpmsBoeReq fgidpmsboereq : batch) {
                        setFgIdpmsBoeReqParams(ps, fgidpmsboereq);
                        ps.setInt(60, fgidpmsboereq.getID());
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

    private void setFgIdpmsBoeReqParams(PreparedStatement ps, FgIdpmsBoeReq fgidpmsboereq) throws SQLException {
        Integer val1 = fgidpmsboereq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgidpmsboereq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgidpmsboereq.getTypeCode());
        ps.setString(4, fgidpmsboereq.getSubTypeCode());
        ps.setString(5, fgidpmsboereq.getActiveCode());
        ps.setString(6, fgidpmsboereq.getStageCode());
        ps.setString(7, fgidpmsboereq.getStatusCode());
        ps.setString(8, fgidpmsboereq.getCreatedOn());
        java.math.BigDecimal val9 = fgidpmsboereq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgidpmsboereq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgidpmsboereq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgidpmsboereq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgidpmsboereq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgidpmsboereq.getTemplate());
        java.math.BigDecimal val15 = fgidpmsboereq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgidpmsboereq.getBoeNumber());
        java.time.LocalDateTime val17 = fgidpmsboereq.getBoeDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgidpmsboereq.getPortOfDis());
        ps.setString(19, fgidpmsboereq.getImportAgency());
        ps.setString(20, fgidpmsboereq.getIeCode());
        java.time.LocalDateTime val21 = fgidpmsboereq.getOverduePeriod();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        ps.setString(22, fgidpmsboereq.getInvoiceSlNo());
        ps.setString(23, fgidpmsboereq.getInvNum());
        ps.setString(24, fgidpmsboereq.getTermsOfInv());
        ps.setString(25, fgidpmsboereq.getInvCcy());
        java.math.BigDecimal val26 = fgidpmsboereq.getInvAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgidpmsboereq.getSupplierName());
        ps.setString(28, fgidpmsboereq.getSupplierAddr());
        ps.setString(29, fgidpmsboereq.getSupplierCountry());
        ps.setString(30, fgidpmsboereq.getSellerName());
        ps.setString(31, fgidpmsboereq.getSellerAddr());
        ps.setString(32, fgidpmsboereq.getSellerCountry());
        java.math.BigDecimal val33 = fgidpmsboereq.getUtilizedInvAmt();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgidpmsboereq.getOsInvAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgidpmsboereq.getEndorsedAmt();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgidpmsboereq.getClosureIndicator());
        java.math.BigDecimal val37 = fgidpmsboereq.getAdjAmt();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        ps.setString(38, fgidpmsboereq.getAdjReason());
        java.time.LocalDateTime val39 = fgidpmsboereq.getExtendedDate();
        if (val39 != null) {
            ps.setTimestamp(39, java.sql.Timestamp.valueOf(val39));
        } else {
            ps.setNull(39, Types.TIMESTAMP);
        }
        ps.setString(40, fgidpmsboereq.getExtendedBy());
        ps.setString(41, fgidpmsboereq.getRemarks());
        Integer val42 = fgidpmsboereq.getParentRefID();
        if (val42 != null) {
            ps.setInt(42, val42);
        } else {
            ps.setNull(42, Types.INTEGER);
        }
        Integer val43 = fgidpmsboereq.getParentVersionID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        ps.setString(44, fgidpmsboereq.getTrracsStatus());
        ps.setString(45, fgidpmsboereq.getTrracsErrorCode());
        ps.setString(46, fgidpmsboereq.getTrracsErrorDesc());
        ps.setString(47, fgidpmsboereq.getReqType());
        ps.setString(48, fgidpmsboereq.getFinalErrorDesc());
        ps.setString(49, fgidpmsboereq.getFinalErrorCode());
        ps.setString(50, fgidpmsboereq.getFinalStatus());
        ps.setString(51, fgidpmsboereq.getAdCode());
        ps.setString(52, fgidpmsboereq.getDocNo());
        java.time.LocalDateTime val53 = fgidpmsboereq.getDocDate();
        if (val53 != null) {
            ps.setTimestamp(53, java.sql.Timestamp.valueOf(val53));
        } else {
            ps.setNull(53, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val54 = fgidpmsboereq.getLetterDate();
        if (val54 != null) {
            ps.setTimestamp(54, java.sql.Timestamp.valueOf(val54));
        } else {
            ps.setNull(54, Types.TIMESTAMP);
        }
        ps.setString(55, fgidpmsboereq.getLetterNo());
        ps.setString(56, fgidpmsboereq.getApprovedBy());
        java.math.BigDecimal val57 = fgidpmsboereq.getCheckbox();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, fgidpmsboereq.getRbiStatus());
        ps.setString(59, fgidpmsboereq.getRbiErrorDesc());
        ps.setString(60, fgidpmsboereq.getRbiErrorCode());
    }

    private FgIdpmsBoeReq extract(ResultSet rs) throws SQLException {
        FgIdpmsBoeReq fgidpmsboereq = new FgIdpmsBoeReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgidpmsboereq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgidpmsboereq.setReferenceID(REFERENCE_ID);
        fgidpmsboereq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgidpmsboereq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgidpmsboereq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgidpmsboereq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgidpmsboereq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgidpmsboereq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgidpmsboereq.setCreatedBy(CREATED_BY);
        fgidpmsboereq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgidpmsboereq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgidpmsboereq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgidpmsboereq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgidpmsboereq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgidpmsboereq.setIsTemplate(IS_TEMPLATE);
        fgidpmsboereq.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgidpmsboereq.setBoeDate(BOE_DATE.toLocalDateTime());
        fgidpmsboereq.setPortOfDis(rs.getString(COL_PORT_OF_DIS));
        fgidpmsboereq.setImportAgency(rs.getString(COL_IMPORT_AGENCY));
        fgidpmsboereq.setIeCode(rs.getString(COL_IE_CODE));
        Timestamp OVERDUE_PERIOD = rs.getTimestamp(COL_OVERDUE_PERIOD);
        if (OVERDUE_PERIOD != null)
            fgidpmsboereq.setOverduePeriod(OVERDUE_PERIOD.toLocalDateTime());
        fgidpmsboereq.setInvoiceSlNo(rs.getString(COL_INVOICE_SL_NO));
        fgidpmsboereq.setInvNum(rs.getString(COL_INV_NUM));
        fgidpmsboereq.setTermsOfInv(rs.getString(COL_TERMS_OF_INV));
        fgidpmsboereq.setInvCcy(rs.getString(COL_INV_CCY));
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        fgidpmsboereq.setInvAmt(INV_AMT);
        fgidpmsboereq.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        fgidpmsboereq.setSupplierAddr(rs.getString(COL_SUPPLIER_ADDR));
        fgidpmsboereq.setSupplierCountry(rs.getString(COL_SUPPLIER_COUNTRY));
        fgidpmsboereq.setSellerName(rs.getString(COL_SELLER_NAME));
        fgidpmsboereq.setSellerAddr(rs.getString(COL_SELLER_ADDR));
        fgidpmsboereq.setSellerCountry(rs.getString(COL_SELLER_COUNTRY));
        java.math.BigDecimal UTILIZED_INV_AMT = rs.getObject(COL_UTILIZED_INV_AMT, java.math.BigDecimal.class);
        fgidpmsboereq.setUtilizedInvAmt(UTILIZED_INV_AMT);
        java.math.BigDecimal OS_INV_AMT = rs.getObject(COL_OS_INV_AMT, java.math.BigDecimal.class);
        fgidpmsboereq.setOsInvAmt(OS_INV_AMT);
        java.math.BigDecimal ENDORSED_AMT = rs.getObject(COL_ENDORSED_AMT, java.math.BigDecimal.class);
        fgidpmsboereq.setEndorsedAmt(ENDORSED_AMT);
        fgidpmsboereq.setClosureIndicator(rs.getString(COL_CLOSURE_INDICATOR));
        java.math.BigDecimal ADJ_AMT = rs.getObject(COL_ADJ_AMT, java.math.BigDecimal.class);
        fgidpmsboereq.setAdjAmt(ADJ_AMT);
        fgidpmsboereq.setAdjReason(rs.getString(COL_ADJ_REASON));
        Timestamp EXTENDED_DATE = rs.getTimestamp(COL_EXTENDED_DATE);
        if (EXTENDED_DATE != null)
            fgidpmsboereq.setExtendedDate(EXTENDED_DATE.toLocalDateTime());
        fgidpmsboereq.setExtendedBy(rs.getString(COL_EXTENDED_BY));
        fgidpmsboereq.setRemarks(rs.getString(COL_REMARKS));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgidpmsboereq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgidpmsboereq.setParentVersionID(PARENT_VERSION_ID);
        fgidpmsboereq.setTrracsStatus(rs.getString(COL_TRRACS_STATUS));
        fgidpmsboereq.setTrracsErrorCode(rs.getString(COL_TRRACS_ERROR_CODE));
        fgidpmsboereq.setTrracsErrorDesc(rs.getString(COL_TRRACS_ERROR_DESC));
        fgidpmsboereq.setReqType(rs.getString(COL_REQ_TYPE));
        fgidpmsboereq.setFinalErrorDesc(rs.getString(COL_FINAL_ERROR_DESC));
        fgidpmsboereq.setFinalErrorCode(rs.getString(COL_FINAL_ERROR_CODE));
        fgidpmsboereq.setFinalStatus(rs.getString(COL_FINAL_STATUS));
        fgidpmsboereq.setAdCode(rs.getString(COL_AD_CODE));
        fgidpmsboereq.setDocNo(rs.getString(COL_DOC_NO));
        Timestamp DOC_DATE = rs.getTimestamp(COL_DOC_DATE);
        if (DOC_DATE != null)
            fgidpmsboereq.setDocDate(DOC_DATE.toLocalDateTime());
        Timestamp LETTER_DATE = rs.getTimestamp(COL_LETTER_DATE);
        if (LETTER_DATE != null)
            fgidpmsboereq.setLetterDate(LETTER_DATE.toLocalDateTime());
        fgidpmsboereq.setLetterNo(rs.getString(COL_LETTER_NO));
        fgidpmsboereq.setApprovedBy(rs.getString(COL_APPROVED_BY));
        java.math.BigDecimal CHECKBOX = rs.getObject(COL_CHECKBOX, java.math.BigDecimal.class);
        fgidpmsboereq.setCheckbox(CHECKBOX);
        fgidpmsboereq.setRbiStatus(rs.getString(COL_RBI_STATUS));
        fgidpmsboereq.setRbiErrorDesc(rs.getString(COL_RBI_ERROR_DESC));
        fgidpmsboereq.setRbiErrorCode(rs.getString(COL_RBI_ERROR_CODE));
        return fgidpmsboereq;
    }
}
