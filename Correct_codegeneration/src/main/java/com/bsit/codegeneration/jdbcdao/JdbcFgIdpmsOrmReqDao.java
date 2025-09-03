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

public class JdbcFgIdpmsOrmReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgIdpmsOrmReqDao.class);

    private static final String TABLE = "FG_IDPMS_ORM_REQ";

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

    private static final String COL_ORM_NUMBER = "ORM_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_ORM_AMOUNT = "ORM_AMOUNT";

    private static final String COL_ORM_UTILIZED_AMT = "ORM_UTILIZED_AMT";

    private static final String COL_ORM_OS_AMT = "ORM_OS_AMT";

    private static final String COL_ORM_CCY = "ORM_CCY";

    private static final String COL_ORM_DATE = "ORM_DATE";

    private static final String COL_IE_NAME = "IE_NAME";

    private static final String COL_IE_CODE_ORM = "IE_CODE_ORM";

    private static final String COL_BENE_NAME = "BENE_NAME";

    private static final String COL_BENE_COUNTRY = "BENE_COUNTRY";

    private static final String COL_REMITTER_BANK_NAME = "REMITTER_BANK_NAME";

    private static final String COL_PUR_OF_REMIT = "PUR_OF_REMIT";

    private static final String COL_ADJ_AMT_ORM = "ADJ_AMT_ORM";

    private static final String COL_REASON_INDICATOR = "REASON_INDICATOR";

    private static final String COL_REMARKS_ORM = "REMARKS_ORM";

    private static final String COL_PAYMENT_TERMS = "PAYMENT_TERMS";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_TRRACS_STATUS = "TRRACS_STATUS";

    private static final String COL_TRRACS_ERROR_CODE = "TRRACS_ERROR_CODE";

    private static final String COL_TRRACS_ERROR_DESC = "TRRACS_ERROR_DESC";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_NAME_MATCH = "NAME_MATCH";

    private static final String COL_UTIL_AMT = "UTIL_AMT";

    private static final String COL_APPROVED_BY = "APPROVED_BY";

    private static final String COL_PAYMENT_PARTY = "PAYMENT_PARTY";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_AD_CODE_BOE = "AD_CODE_BOE";

    private static final String COL_INVOICE_SL_NO = "INVOICE_SL_NO";

    private static final String COL_INV_NUM = "INV_NUM";

    private static final String COL_DOC_NO = "DOC_NO";

    private static final String COL_DOC_DATE = "DOC_DATE";

    private static final String COL_CLOSURE_INDICATOR = "CLOSURE_INDICATOR";

    private static final String COL_ENDORSED_AMT = "ENDORSED_AMT";

    private static final String COL_FINAL_ERROR_DESC = "FINAL_ERROR_DESC";

    private static final String COL_FINAL_STATUS = "FINAL_STATUS";

    private static final String COL_FINAL_ERROR_CODE = "FINAL_ERROR_CODE";

    private static final String COL_LETTER_NO = "LETTER_NO";

    private static final String COL_RBI_STATUS = "RBI_STATUS";

    private static final String COL_RBI_ERROR_DESC = "RBI_ERROR_DESC";

    private static final String COL_RBI_ERROR_CODE = "RBI_ERROR_CODE";

    private static final String COL_LETTER_DATE = "LETTER_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTANCE_CURRENCY = "REMITTANCE_CURRENCY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_OS_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_IE_CODE_ORM, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT, COL_ADJ_AMT_ORM, COL_REASON_INDICATOR, COL_REMARKS_ORM, COL_PAYMENT_TERMS, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DESC, COL_REQ_TYPE, COL_NAME_MATCH, COL_UTIL_AMT, COL_APPROVED_BY, COL_PAYMENT_PARTY, COL_PORT_CODE, COL_BOE_NUMBER, COL_BOE_DATE, COL_AD_CODE_BOE, COL_INVOICE_SL_NO, COL_INV_NUM, COL_DOC_NO, COL_DOC_DATE, COL_CLOSURE_INDICATOR, COL_ENDORSED_AMT, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS, COL_FINAL_ERROR_CODE, COL_LETTER_NO, COL_RBI_STATUS, COL_RBI_ERROR_DESC, COL_RBI_ERROR_CODE, COL_LETTER_DATE, COL_IE_CODE, COL_REMITTANCE_CURRENCY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE_ORM, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, ADJ_AMT_ORM, REASON_INDICATOR, REMARKS_ORM, PAYMENT_TERMS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, NAME_MATCH, UTIL_AMT, APPROVED_BY, PAYMENT_PARTY, PORT_CODE, BOE_NUMBER, BOE_DATE, AD_CODE_BOE, INVOICE_SL_NO, INV_NUM, DOC_NO, DOC_DATE, CLOSURE_INDICATOR, ENDORSED_AMT, FINAL_ERROR_DESC, FINAL_STATUS, FINAL_ERROR_CODE, LETTER_NO, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE, LETTER_DATE, IE_CODE, REMITTANCE_CURRENCY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE_ORM, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, ADJ_AMT_ORM, REASON_INDICATOR, REMARKS_ORM, PAYMENT_TERMS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, NAME_MATCH, UTIL_AMT, APPROVED_BY, PAYMENT_PARTY, PORT_CODE, BOE_NUMBER, BOE_DATE, AD_CODE_BOE, INVOICE_SL_NO, INV_NUM, DOC_NO, DOC_DATE, CLOSURE_INDICATOR, ENDORSED_AMT, FINAL_ERROR_DESC, FINAL_STATUS, FINAL_ERROR_CODE, LETTER_NO, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE, LETTER_DATE, IE_CODE, REMITTANCE_CURRENCY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_OS_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_IE_CODE_ORM, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT, COL_ADJ_AMT_ORM, COL_REASON_INDICATOR, COL_REMARKS_ORM, COL_PAYMENT_TERMS, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DESC, COL_REQ_TYPE, COL_NAME_MATCH, COL_UTIL_AMT, COL_APPROVED_BY, COL_PAYMENT_PARTY, COL_PORT_CODE, COL_BOE_NUMBER, COL_BOE_DATE, COL_AD_CODE_BOE, COL_INVOICE_SL_NO, COL_INV_NUM, COL_DOC_NO, COL_DOC_DATE, COL_CLOSURE_INDICATOR, COL_ENDORSED_AMT, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS, COL_FINAL_ERROR_CODE, COL_LETTER_NO, COL_RBI_STATUS, COL_RBI_ERROR_DESC, COL_RBI_ERROR_CODE, COL_LETTER_DATE, COL_IE_CODE, COL_REMITTANCE_CURRENCY, COL_ID);

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

    public int insert(Connection conn, FgIdpmsOrmReq fgidpmsormreq) throws SQLException {
        logger.debug("Inserting fgidpmsormreq: {}", fgidpmsormreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgIdpmsOrmReqParams(ps, fgidpmsormreq);
            ps.executeUpdate();
            return fgidpmsormreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgIdpmsOrmReq> fgidpmsormreqs) throws SQLException {
        if (fgidpmsormreqs == null || fgidpmsormreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgidpmsormreqs.size(); i++) {
            if (fgidpmsormreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsOrmReq>> batches = chunkList(fgidpmsormreqs, batchSize);
        int[] totalResults = new int[fgidpmsormreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsOrmReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgIdpmsOrmReq fgidpmsormreq : batch) {
                        setFgIdpmsOrmReqParams(ps, fgidpmsormreq);
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

    public FgIdpmsOrmReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgIdpmsOrmReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgIdpmsOrmReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgIdpmsOrmReq fgidpmsormreq) throws SQLException {
        if (fgidpmsormreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgIdpmsOrmReqParams(ps, fgidpmsormreq);
            ps.setInt(62, fgidpmsormreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgIdpmsOrmReq> fgidpmsormreqs) throws SQLException {
        if (fgidpmsormreqs == null || fgidpmsormreqs.isEmpty())
            return new int[0];
        for (FgIdpmsOrmReq fgidpmsormreq : fgidpmsormreqs) {
            if (fgidpmsormreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgidpmsormreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsOrmReq>> batches = chunkList(fgidpmsormreqs, batchSize);
        int[] totalResults = new int[fgidpmsormreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsOrmReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgIdpmsOrmReq fgidpmsormreq : batch) {
                        setFgIdpmsOrmReqParams(ps, fgidpmsormreq);
                        ps.setInt(62, fgidpmsormreq.getID());
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

    private void setFgIdpmsOrmReqParams(PreparedStatement ps, FgIdpmsOrmReq fgidpmsormreq) throws SQLException {
        Integer val1 = fgidpmsormreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgidpmsormreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgidpmsormreq.getTypeCode());
        ps.setString(4, fgidpmsormreq.getSubTypeCode());
        ps.setString(5, fgidpmsormreq.getActiveCode());
        ps.setString(6, fgidpmsormreq.getStageCode());
        ps.setString(7, fgidpmsormreq.getStatusCode());
        ps.setString(8, fgidpmsormreq.getCreatedOn());
        java.math.BigDecimal val9 = fgidpmsormreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgidpmsormreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgidpmsormreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgidpmsormreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgidpmsormreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgidpmsormreq.getTemplate());
        java.math.BigDecimal val15 = fgidpmsormreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgidpmsormreq.getOrmNumber());
        ps.setString(17, fgidpmsormreq.getAdCode());
        java.math.BigDecimal val18 = fgidpmsormreq.getOrmAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgidpmsormreq.getOrmUtilizedAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgidpmsormreq.getOrmOsAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgidpmsormreq.getOrmCcy());
        java.time.LocalDateTime val22 = fgidpmsormreq.getOrmDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgidpmsormreq.getIeName());
        ps.setString(24, fgidpmsormreq.getIeCodeOrm());
        ps.setString(25, fgidpmsormreq.getBeneName());
        ps.setString(26, fgidpmsormreq.getBeneCountry());
        ps.setString(27, fgidpmsormreq.getRemitterBankName());
        ps.setString(28, fgidpmsormreq.getPurOfRemit());
        java.math.BigDecimal val29 = fgidpmsormreq.getAdjAmtOrm();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgidpmsormreq.getReasonIndicator());
        ps.setString(31, fgidpmsormreq.getRemarksOrm());
        ps.setString(32, fgidpmsormreq.getPaymentTerms());
        Integer val33 = fgidpmsormreq.getParentRefID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        Integer val34 = fgidpmsormreq.getParentVersionID();
        if (val34 != null) {
            ps.setInt(34, val34);
        } else {
            ps.setNull(34, Types.INTEGER);
        }
        ps.setString(35, fgidpmsormreq.getTrracsStatus());
        ps.setString(36, fgidpmsormreq.getTrracsErrorCode());
        ps.setString(37, fgidpmsormreq.getTrracsErrorDesc());
        ps.setString(38, fgidpmsormreq.getReqType());
        java.math.BigDecimal val39 = fgidpmsormreq.getNameMatch();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        java.math.BigDecimal val40 = fgidpmsormreq.getUtilAmt();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgidpmsormreq.getApprovedBy());
        ps.setString(42, fgidpmsormreq.getPaymentParty());
        ps.setString(43, fgidpmsormreq.getPortCode());
        ps.setString(44, fgidpmsormreq.getBoeNumber());
        java.time.LocalDateTime val45 = fgidpmsormreq.getBoeDate();
        if (val45 != null) {
            ps.setTimestamp(45, java.sql.Timestamp.valueOf(val45));
        } else {
            ps.setNull(45, Types.TIMESTAMP);
        }
        ps.setString(46, fgidpmsormreq.getAdCodeBoe());
        ps.setString(47, fgidpmsormreq.getInvoiceSlNo());
        ps.setString(48, fgidpmsormreq.getInvNum());
        ps.setString(49, fgidpmsormreq.getDocNo());
        java.time.LocalDateTime val50 = fgidpmsormreq.getDocDate();
        if (val50 != null) {
            ps.setTimestamp(50, java.sql.Timestamp.valueOf(val50));
        } else {
            ps.setNull(50, Types.TIMESTAMP);
        }
        ps.setString(51, fgidpmsormreq.getClosureIndicator());
        java.math.BigDecimal val52 = fgidpmsormreq.getEndorsedAmt();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        ps.setString(53, fgidpmsormreq.getFinalErrorDesc());
        ps.setString(54, fgidpmsormreq.getFinalStatus());
        ps.setString(55, fgidpmsormreq.getFinalErrorCode());
        ps.setString(56, fgidpmsormreq.getLetterNo());
        ps.setString(57, fgidpmsormreq.getRbiStatus());
        ps.setString(58, fgidpmsormreq.getRbiErrorDesc());
        ps.setString(59, fgidpmsormreq.getRbiErrorCode());
        java.time.LocalDateTime val60 = fgidpmsormreq.getLetterDate();
        if (val60 != null) {
            ps.setTimestamp(60, java.sql.Timestamp.valueOf(val60));
        } else {
            ps.setNull(60, Types.TIMESTAMP);
        }
        ps.setString(61, fgidpmsormreq.getIeCode());
        ps.setString(62, fgidpmsormreq.getRemittanceCurrency());
    }

    private FgIdpmsOrmReq extract(ResultSet rs) throws SQLException {
        FgIdpmsOrmReq fgidpmsormreq = new FgIdpmsOrmReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgidpmsormreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgidpmsormreq.setReferenceID(REFERENCE_ID);
        fgidpmsormreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgidpmsormreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgidpmsormreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgidpmsormreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgidpmsormreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgidpmsormreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgidpmsormreq.setCreatedBy(CREATED_BY);
        fgidpmsormreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgidpmsormreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgidpmsormreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgidpmsormreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgidpmsormreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgidpmsormreq.setIsTemplate(IS_TEMPLATE);
        fgidpmsormreq.setOrmNumber(rs.getString(COL_ORM_NUMBER));
        fgidpmsormreq.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal ORM_AMOUNT = rs.getObject(COL_ORM_AMOUNT, java.math.BigDecimal.class);
        fgidpmsormreq.setOrmAmount(ORM_AMOUNT);
        java.math.BigDecimal ORM_UTILIZED_AMT = rs.getObject(COL_ORM_UTILIZED_AMT, java.math.BigDecimal.class);
        fgidpmsormreq.setOrmUtilizedAmt(ORM_UTILIZED_AMT);
        java.math.BigDecimal ORM_OS_AMT = rs.getObject(COL_ORM_OS_AMT, java.math.BigDecimal.class);
        fgidpmsormreq.setOrmOsAmt(ORM_OS_AMT);
        fgidpmsormreq.setOrmCcy(rs.getString(COL_ORM_CCY));
        Timestamp ORM_DATE = rs.getTimestamp(COL_ORM_DATE);
        if (ORM_DATE != null)
            fgidpmsormreq.setOrmDate(ORM_DATE.toLocalDateTime());
        fgidpmsormreq.setIeName(rs.getString(COL_IE_NAME));
        fgidpmsormreq.setIeCodeOrm(rs.getString(COL_IE_CODE_ORM));
        fgidpmsormreq.setBeneName(rs.getString(COL_BENE_NAME));
        fgidpmsormreq.setBeneCountry(rs.getString(COL_BENE_COUNTRY));
        fgidpmsormreq.setRemitterBankName(rs.getString(COL_REMITTER_BANK_NAME));
        fgidpmsormreq.setPurOfRemit(rs.getString(COL_PUR_OF_REMIT));
        java.math.BigDecimal ADJ_AMT_ORM = rs.getObject(COL_ADJ_AMT_ORM, java.math.BigDecimal.class);
        fgidpmsormreq.setAdjAmtOrm(ADJ_AMT_ORM);
        fgidpmsormreq.setReasonIndicator(rs.getString(COL_REASON_INDICATOR));
        fgidpmsormreq.setRemarksOrm(rs.getString(COL_REMARKS_ORM));
        fgidpmsormreq.setPaymentTerms(rs.getString(COL_PAYMENT_TERMS));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgidpmsormreq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgidpmsormreq.setParentVersionID(PARENT_VERSION_ID);
        fgidpmsormreq.setTrracsStatus(rs.getString(COL_TRRACS_STATUS));
        fgidpmsormreq.setTrracsErrorCode(rs.getString(COL_TRRACS_ERROR_CODE));
        fgidpmsormreq.setTrracsErrorDesc(rs.getString(COL_TRRACS_ERROR_DESC));
        fgidpmsormreq.setReqType(rs.getString(COL_REQ_TYPE));
        java.math.BigDecimal NAME_MATCH = rs.getObject(COL_NAME_MATCH, java.math.BigDecimal.class);
        fgidpmsormreq.setNameMatch(NAME_MATCH);
        java.math.BigDecimal UTIL_AMT = rs.getObject(COL_UTIL_AMT, java.math.BigDecimal.class);
        fgidpmsormreq.setUtilAmt(UTIL_AMT);
        fgidpmsormreq.setApprovedBy(rs.getString(COL_APPROVED_BY));
        fgidpmsormreq.setPaymentParty(rs.getString(COL_PAYMENT_PARTY));
        fgidpmsormreq.setPortCode(rs.getString(COL_PORT_CODE));
        fgidpmsormreq.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgidpmsormreq.setBoeDate(BOE_DATE.toLocalDateTime());
        fgidpmsormreq.setAdCodeBoe(rs.getString(COL_AD_CODE_BOE));
        fgidpmsormreq.setInvoiceSlNo(rs.getString(COL_INVOICE_SL_NO));
        fgidpmsormreq.setInvNum(rs.getString(COL_INV_NUM));
        fgidpmsormreq.setDocNo(rs.getString(COL_DOC_NO));
        Timestamp DOC_DATE = rs.getTimestamp(COL_DOC_DATE);
        if (DOC_DATE != null)
            fgidpmsormreq.setDocDate(DOC_DATE.toLocalDateTime());
        fgidpmsormreq.setClosureIndicator(rs.getString(COL_CLOSURE_INDICATOR));
        java.math.BigDecimal ENDORSED_AMT = rs.getObject(COL_ENDORSED_AMT, java.math.BigDecimal.class);
        fgidpmsormreq.setEndorsedAmt(ENDORSED_AMT);
        fgidpmsormreq.setFinalErrorDesc(rs.getString(COL_FINAL_ERROR_DESC));
        fgidpmsormreq.setFinalStatus(rs.getString(COL_FINAL_STATUS));
        fgidpmsormreq.setFinalErrorCode(rs.getString(COL_FINAL_ERROR_CODE));
        fgidpmsormreq.setLetterNo(rs.getString(COL_LETTER_NO));
        fgidpmsormreq.setRbiStatus(rs.getString(COL_RBI_STATUS));
        fgidpmsormreq.setRbiErrorDesc(rs.getString(COL_RBI_ERROR_DESC));
        fgidpmsormreq.setRbiErrorCode(rs.getString(COL_RBI_ERROR_CODE));
        Timestamp LETTER_DATE = rs.getTimestamp(COL_LETTER_DATE);
        if (LETTER_DATE != null)
            fgidpmsormreq.setLetterDate(LETTER_DATE.toLocalDateTime());
        fgidpmsormreq.setIeCode(rs.getString(COL_IE_CODE));
        fgidpmsormreq.setRemittanceCurrency(rs.getString(COL_REMITTANCE_CURRENCY));
        return fgidpmsormreq;
    }
}
