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

public class JdbcFgEdpmsSbReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEdpmsSbReqDao.class);

    private static final String TABLE = "FG_EDPMS_SB_REQ";

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

    private static final String COL_EXIST_AD = "EXIST_AD";

    private static final String COL_NEW_AD = "NEW_AD";

    private static final String COL_ADJ_REF_NO = "ADJ_REF_NO";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_ADJ_IND = "ADJ_IND";

    private static final String COL_ADJ_AMT = "ADJ_AMT";

    private static final String COL_BILL_CL_IND = "BILL_CL_IND";

    private static final String COL_EXT_REF_NO = "EXT_REF_NO";

    private static final String COL_EXT_BY = "EXT_BY";

    private static final String COL_EXT_DATE_SB = "EXT_DATE_SB";

    private static final String COL_REMARKS_SB = "REMARKS_SB";

    private static final String COL_BANK_REF_NO = "BANK_REF_NO";

    private static final String COL_AMT_UTIL = "AMT_UTIL";

    private static final String COL_PORTCODE = "PORTCODE";

    private static final String COL_EXP_TYPE = "EXP_TYPE";

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_SHIPBILLDATE = "SHIPBILLDATE";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_EXP_AGENCY = "EXP_AGENCY";

    private static final String COL_LEO_DATE = "LEO_DATE";

    private static final String COL_OS_PERIOD = "OS_PERIOD";

    private static final String COL_AD_BILL_NO = "AD_BILL_NO";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_STATUS = "INV_STATUS";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_FOB_CCY = "FOB_CCY";

    private static final String COL_UTIL_FOB_AMT = "UTIL_FOB_AMT";

    private static final String COL_FREIGHT_AMT = "FREIGHT_AMT";

    private static final String COL_FREIGHT_CCY = "FREIGHT_CCY";

    private static final String COL_UTIL_FREIGHT_AMT = "UTIL_FREIGHT_AMT";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_INS_CCY = "INS_CCY";

    private static final String COL_UTIL_INS_AMT = "UTIL_INS_AMT";

    private static final String COL_MASTER_ID = "MASTER_ID";

    private static final String COL_DETAIL_ID = "DETAIL_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_TRRACS_STATUS = "TRRACS_STATUS";

    private static final String COL_TRRACS_ERROR_CODE = "TRRACS_ERROR_CODE";

    private static final String COL_TRRACS_ERROR_DECS = "TRRACS_ERROR_DECS";

    private static final String COL_COUNTER_PARTY = "COUNTER_PARTY";

    private static final String COL_WRITE_OFF_BY = "WRITE_OFF_BY";

    private static final String COL_WRITE_OFF_REASON = "WRITE_OFF_REASON";

    private static final String COL_SB_AMOUNT = "SB_AMOUNT";

    private static final String COL_SB_CCY = "SB_CCY";

    private static final String COL_SB_UTIL_AMT = "SB_UTIL_AMT";

    private static final String COL_SB_OS_AMT = "SB_OS_AMT";

    private static final String COL_BILLREFNO = "BILLREFNO";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_FINAL_ERROR_DESC = "FINAL_ERROR_DESC";

    private static final String COL_FINAL_STATUS = "FINAL_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_EXIST_AD, COL_NEW_AD, COL_ADJ_REF_NO, COL_INV_SL_NO, COL_INV_NO, COL_ADJ_IND, COL_ADJ_AMT, COL_BILL_CL_IND, COL_EXT_REF_NO, COL_EXT_BY, COL_EXT_DATE_SB, COL_REMARKS_SB, COL_BANK_REF_NO, COL_AMT_UTIL, COL_PORTCODE, COL_EXP_TYPE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_AD_CODE, COL_IE_CODE, COL_EXP_AGENCY, COL_LEO_DATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_STATUS, COL_INV_DATE, COL_INV_STATUS, COL_FOB_AMT, COL_FOB_CCY, COL_UTIL_FOB_AMT, COL_FREIGHT_AMT, COL_FREIGHT_CCY, COL_UTIL_FREIGHT_AMT, COL_INS_AMT, COL_INS_CCY, COL_UTIL_INS_AMT, COL_MASTER_ID, COL_DETAIL_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DECS, COL_COUNTER_PARTY, COL_WRITE_OFF_BY, COL_WRITE_OFF_REASON, COL_SB_AMOUNT, COL_SB_CCY, COL_SB_UTIL_AMT, COL_SB_OS_AMT, COL_BILLREFNO, COL_BILL_NO, COL_REQ_TYPE, COL_REMARKS, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, EXIST_AD, NEW_AD, ADJ_REF_NO, INV_SL_NO, INV_NO, ADJ_IND, ADJ_AMT, BILL_CL_IND, EXT_REF_NO, EXT_BY, EXT_DATE_SB, REMARKS_SB, BANK_REF_NO, AMT_UTIL, PORTCODE, EXP_TYPE, SHIPBILLNO, SHIPBILLDATE, FORMNO, AD_CODE, IE_CODE, EXP_AGENCY, LEO_DATE, OS_PERIOD, AD_BILL_NO, STATUS, INV_DATE, INV_STATUS, FOB_AMT, FOB_CCY, UTIL_FOB_AMT, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT, MASTER_ID, DETAIL_ID, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, COUNTER_PARTY, WRITE_OFF_BY, WRITE_OFF_REASON, SB_AMOUNT, SB_CCY, SB_UTIL_AMT, SB_OS_AMT, BILLREFNO, BILL_NO, REQ_TYPE, REMARKS, FINAL_ERROR_DESC, FINAL_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, EXIST_AD, NEW_AD, ADJ_REF_NO, INV_SL_NO, INV_NO, ADJ_IND, ADJ_AMT, BILL_CL_IND, EXT_REF_NO, EXT_BY, EXT_DATE_SB, REMARKS_SB, BANK_REF_NO, AMT_UTIL, PORTCODE, EXP_TYPE, SHIPBILLNO, SHIPBILLDATE, FORMNO, AD_CODE, IE_CODE, EXP_AGENCY, LEO_DATE, OS_PERIOD, AD_BILL_NO, STATUS, INV_DATE, INV_STATUS, FOB_AMT, FOB_CCY, UTIL_FOB_AMT, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT, MASTER_ID, DETAIL_ID, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, COUNTER_PARTY, WRITE_OFF_BY, WRITE_OFF_REASON, SB_AMOUNT, SB_CCY, SB_UTIL_AMT, SB_OS_AMT, BILLREFNO, BILL_NO, REQ_TYPE, REMARKS, FINAL_ERROR_DESC, FINAL_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_EXIST_AD, COL_NEW_AD, COL_ADJ_REF_NO, COL_INV_SL_NO, COL_INV_NO, COL_ADJ_IND, COL_ADJ_AMT, COL_BILL_CL_IND, COL_EXT_REF_NO, COL_EXT_BY, COL_EXT_DATE_SB, COL_REMARKS_SB, COL_BANK_REF_NO, COL_AMT_UTIL, COL_PORTCODE, COL_EXP_TYPE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_AD_CODE, COL_IE_CODE, COL_EXP_AGENCY, COL_LEO_DATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_STATUS, COL_INV_DATE, COL_INV_STATUS, COL_FOB_AMT, COL_FOB_CCY, COL_UTIL_FOB_AMT, COL_FREIGHT_AMT, COL_FREIGHT_CCY, COL_UTIL_FREIGHT_AMT, COL_INS_AMT, COL_INS_CCY, COL_UTIL_INS_AMT, COL_MASTER_ID, COL_DETAIL_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_STATUS, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DECS, COL_COUNTER_PARTY, COL_WRITE_OFF_BY, COL_WRITE_OFF_REASON, COL_SB_AMOUNT, COL_SB_CCY, COL_SB_UTIL_AMT, COL_SB_OS_AMT, COL_BILLREFNO, COL_BILL_NO, COL_REQ_TYPE, COL_REMARKS, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS, COL_ID);

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

    public int insert(Connection conn, FgEdpmsSbReq fgedpmssbreq) throws SQLException {
        logger.debug("Inserting fgedpmssbreq: {}", fgedpmssbreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEdpmsSbReqParams(ps, fgedpmssbreq);
            ps.executeUpdate();
            return fgedpmssbreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEdpmsSbReq> fgedpmssbreqs) throws SQLException {
        if (fgedpmssbreqs == null || fgedpmssbreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgedpmssbreqs.size(); i++) {
            if (fgedpmssbreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsSbReq>> batches = chunkList(fgedpmssbreqs, batchSize);
        int[] totalResults = new int[fgedpmssbreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsSbReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEdpmsSbReq fgedpmssbreq : batch) {
                        setFgEdpmsSbReqParams(ps, fgedpmssbreq);
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

    public FgEdpmsSbReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEdpmsSbReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEdpmsSbReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEdpmsSbReq fgedpmssbreq) throws SQLException {
        if (fgedpmssbreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEdpmsSbReqParams(ps, fgedpmssbreq);
            ps.setInt(72, fgedpmssbreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEdpmsSbReq> fgedpmssbreqs) throws SQLException {
        if (fgedpmssbreqs == null || fgedpmssbreqs.isEmpty())
            return new int[0];
        for (FgEdpmsSbReq fgedpmssbreq : fgedpmssbreqs) {
            if (fgedpmssbreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgedpmssbreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsSbReq>> batches = chunkList(fgedpmssbreqs, batchSize);
        int[] totalResults = new int[fgedpmssbreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsSbReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEdpmsSbReq fgedpmssbreq : batch) {
                        setFgEdpmsSbReqParams(ps, fgedpmssbreq);
                        ps.setInt(72, fgedpmssbreq.getID());
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

    private void setFgEdpmsSbReqParams(PreparedStatement ps, FgEdpmsSbReq fgedpmssbreq) throws SQLException {
        Integer val1 = fgedpmssbreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgedpmssbreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgedpmssbreq.getTypeCode());
        ps.setString(4, fgedpmssbreq.getSubTypeCode());
        ps.setString(5, fgedpmssbreq.getActiveCode());
        ps.setString(6, fgedpmssbreq.getStageCode());
        ps.setString(7, fgedpmssbreq.getStatusCode());
        ps.setString(8, fgedpmssbreq.getCreatedOn());
        java.math.BigDecimal val9 = fgedpmssbreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgedpmssbreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgedpmssbreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgedpmssbreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgedpmssbreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgedpmssbreq.getTemplate());
        java.math.BigDecimal val15 = fgedpmssbreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgedpmssbreq.getExistAd());
        ps.setString(17, fgedpmssbreq.getNewAd());
        ps.setString(18, fgedpmssbreq.getAdjRefNo());
        java.math.BigDecimal val19 = fgedpmssbreq.getInvSlNo();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgedpmssbreq.getInvNo());
        ps.setString(21, fgedpmssbreq.getAdjInd());
        java.math.BigDecimal val22 = fgedpmssbreq.getAdjAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgedpmssbreq.getBillClInd());
        ps.setString(24, fgedpmssbreq.getExtRefNo());
        ps.setString(25, fgedpmssbreq.getExtBy());
        java.time.LocalDateTime val26 = fgedpmssbreq.getExtDateSb();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        ps.setString(27, fgedpmssbreq.getRemarksSb());
        ps.setString(28, fgedpmssbreq.getBankRefNo());
        java.math.BigDecimal val29 = fgedpmssbreq.getAmtUtil();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgedpmssbreq.getPortcode());
        ps.setString(31, fgedpmssbreq.getExpType());
        ps.setString(32, fgedpmssbreq.getShipbillno());
        java.time.LocalDateTime val33 = fgedpmssbreq.getShipbilldate();
        if (val33 != null) {
            ps.setTimestamp(33, java.sql.Timestamp.valueOf(val33));
        } else {
            ps.setNull(33, Types.TIMESTAMP);
        }
        ps.setString(34, fgedpmssbreq.getFormno());
        ps.setString(35, fgedpmssbreq.getAdCode());
        ps.setString(36, fgedpmssbreq.getIeCode());
        ps.setString(37, fgedpmssbreq.getExpAgency());
        java.time.LocalDateTime val38 = fgedpmssbreq.getLeoDate();
        if (val38 != null) {
            ps.setTimestamp(38, java.sql.Timestamp.valueOf(val38));
        } else {
            ps.setNull(38, Types.TIMESTAMP);
        }
        java.math.BigDecimal val39 = fgedpmssbreq.getOsPeriod();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgedpmssbreq.getAdBillNo());
        ps.setString(41, fgedpmssbreq.getStatus());
        java.time.LocalDateTime val42 = fgedpmssbreq.getInvDate();
        if (val42 != null) {
            ps.setTimestamp(42, java.sql.Timestamp.valueOf(val42));
        } else {
            ps.setNull(42, Types.TIMESTAMP);
        }
        ps.setString(43, fgedpmssbreq.getInvStatus());
        java.math.BigDecimal val44 = fgedpmssbreq.getFobAmt();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        ps.setString(45, fgedpmssbreq.getFobCcy());
        java.math.BigDecimal val46 = fgedpmssbreq.getUtilFobAmt();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = fgedpmssbreq.getFreightAmt();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        ps.setString(48, fgedpmssbreq.getFreightCcy());
        java.math.BigDecimal val49 = fgedpmssbreq.getUtilFreightAmt();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = fgedpmssbreq.getInsAmt();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        ps.setString(51, fgedpmssbreq.getInsCcy());
        java.math.BigDecimal val52 = fgedpmssbreq.getUtilInsAmt();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        Integer val53 = fgedpmssbreq.getMasterID();
        if (val53 != null) {
            ps.setInt(53, val53);
        } else {
            ps.setNull(53, Types.INTEGER);
        }
        Integer val54 = fgedpmssbreq.getDetailID();
        if (val54 != null) {
            ps.setInt(54, val54);
        } else {
            ps.setNull(54, Types.INTEGER);
        }
        Integer val55 = fgedpmssbreq.getParentRefID();
        if (val55 != null) {
            ps.setInt(55, val55);
        } else {
            ps.setNull(55, Types.INTEGER);
        }
        Integer val56 = fgedpmssbreq.getParentVersionID();
        if (val56 != null) {
            ps.setInt(56, val56);
        } else {
            ps.setNull(56, Types.INTEGER);
        }
        ps.setString(57, fgedpmssbreq.getTrracsStatus());
        ps.setString(58, fgedpmssbreq.getTrracsErrorCode());
        ps.setString(59, fgedpmssbreq.getTrracsErrorDecs());
        ps.setString(60, fgedpmssbreq.getCounterParty());
        ps.setString(61, fgedpmssbreq.getWriteOffBy());
        ps.setString(62, fgedpmssbreq.getWriteOffReason());
        java.math.BigDecimal val63 = fgedpmssbreq.getSbAmount();
        if (val63 != null) {
            ps.setBigDecimal(63, val63);
        } else {
            ps.setNull(63, Types.DECIMAL);
        }
        ps.setString(64, fgedpmssbreq.getSbCcy());
        java.math.BigDecimal val65 = fgedpmssbreq.getSbUtilAmt();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        java.math.BigDecimal val66 = fgedpmssbreq.getSbOsAmt();
        if (val66 != null) {
            ps.setBigDecimal(66, val66);
        } else {
            ps.setNull(66, Types.DECIMAL);
        }
        ps.setString(67, fgedpmssbreq.getBillrefno());
        ps.setString(68, fgedpmssbreq.getBillNo());
        ps.setString(69, fgedpmssbreq.getReqType());
        ps.setString(70, fgedpmssbreq.getRemarks());
        ps.setString(71, fgedpmssbreq.getFinalErrorDesc());
        ps.setString(72, fgedpmssbreq.getFinalStatus());
    }

    private FgEdpmsSbReq extract(ResultSet rs) throws SQLException {
        FgEdpmsSbReq fgedpmssbreq = new FgEdpmsSbReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgedpmssbreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgedpmssbreq.setReferenceID(REFERENCE_ID);
        fgedpmssbreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgedpmssbreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgedpmssbreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgedpmssbreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgedpmssbreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgedpmssbreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgedpmssbreq.setCreatedBy(CREATED_BY);
        fgedpmssbreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgedpmssbreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgedpmssbreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgedpmssbreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgedpmssbreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgedpmssbreq.setIsTemplate(IS_TEMPLATE);
        fgedpmssbreq.setExistAd(rs.getString(COL_EXIST_AD));
        fgedpmssbreq.setNewAd(rs.getString(COL_NEW_AD));
        fgedpmssbreq.setAdjRefNo(rs.getString(COL_ADJ_REF_NO));
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        fgedpmssbreq.setInvSlNo(INV_SL_NO);
        fgedpmssbreq.setInvNo(rs.getString(COL_INV_NO));
        fgedpmssbreq.setAdjInd(rs.getString(COL_ADJ_IND));
        java.math.BigDecimal ADJ_AMT = rs.getObject(COL_ADJ_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setAdjAmt(ADJ_AMT);
        fgedpmssbreq.setBillClInd(rs.getString(COL_BILL_CL_IND));
        fgedpmssbreq.setExtRefNo(rs.getString(COL_EXT_REF_NO));
        fgedpmssbreq.setExtBy(rs.getString(COL_EXT_BY));
        Timestamp EXT_DATE_SB = rs.getTimestamp(COL_EXT_DATE_SB);
        if (EXT_DATE_SB != null)
            fgedpmssbreq.setExtDateSb(EXT_DATE_SB.toLocalDateTime());
        fgedpmssbreq.setRemarksSb(rs.getString(COL_REMARKS_SB));
        fgedpmssbreq.setBankRefNo(rs.getString(COL_BANK_REF_NO));
        java.math.BigDecimal AMT_UTIL = rs.getObject(COL_AMT_UTIL, java.math.BigDecimal.class);
        fgedpmssbreq.setAmtUtil(AMT_UTIL);
        fgedpmssbreq.setPortcode(rs.getString(COL_PORTCODE));
        fgedpmssbreq.setExpType(rs.getString(COL_EXP_TYPE));
        fgedpmssbreq.setShipbillno(rs.getString(COL_SHIPBILLNO));
        Timestamp SHIPBILLDATE = rs.getTimestamp(COL_SHIPBILLDATE);
        if (SHIPBILLDATE != null)
            fgedpmssbreq.setShipbilldate(SHIPBILLDATE.toLocalDateTime());
        fgedpmssbreq.setFormno(rs.getString(COL_FORMNO));
        fgedpmssbreq.setAdCode(rs.getString(COL_AD_CODE));
        fgedpmssbreq.setIeCode(rs.getString(COL_IE_CODE));
        fgedpmssbreq.setExpAgency(rs.getString(COL_EXP_AGENCY));
        Timestamp LEO_DATE = rs.getTimestamp(COL_LEO_DATE);
        if (LEO_DATE != null)
            fgedpmssbreq.setLeoDate(LEO_DATE.toLocalDateTime());
        java.math.BigDecimal OS_PERIOD = rs.getObject(COL_OS_PERIOD, java.math.BigDecimal.class);
        fgedpmssbreq.setOsPeriod(OS_PERIOD);
        fgedpmssbreq.setAdBillNo(rs.getString(COL_AD_BILL_NO));
        fgedpmssbreq.setStatus(rs.getString(COL_STATUS));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgedpmssbreq.setInvDate(INV_DATE.toLocalDateTime());
        fgedpmssbreq.setInvStatus(rs.getString(COL_INV_STATUS));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setFobAmt(FOB_AMT);
        fgedpmssbreq.setFobCcy(rs.getString(COL_FOB_CCY));
        java.math.BigDecimal UTIL_FOB_AMT = rs.getObject(COL_UTIL_FOB_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setUtilFobAmt(UTIL_FOB_AMT);
        java.math.BigDecimal FREIGHT_AMT = rs.getObject(COL_FREIGHT_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setFreightAmt(FREIGHT_AMT);
        fgedpmssbreq.setFreightCcy(rs.getString(COL_FREIGHT_CCY));
        java.math.BigDecimal UTIL_FREIGHT_AMT = rs.getObject(COL_UTIL_FREIGHT_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setUtilFreightAmt(UTIL_FREIGHT_AMT);
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setInsAmt(INS_AMT);
        fgedpmssbreq.setInsCcy(rs.getString(COL_INS_CCY));
        java.math.BigDecimal UTIL_INS_AMT = rs.getObject(COL_UTIL_INS_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setUtilInsAmt(UTIL_INS_AMT);
        Integer MASTER_ID = rs.getObject(COL_MASTER_ID, Integer.class);
        fgedpmssbreq.setMasterID(MASTER_ID);
        Integer DETAIL_ID = rs.getObject(COL_DETAIL_ID, Integer.class);
        fgedpmssbreq.setDetailID(DETAIL_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgedpmssbreq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgedpmssbreq.setParentVersionID(PARENT_VERSION_ID);
        fgedpmssbreq.setTrracsStatus(rs.getString(COL_TRRACS_STATUS));
        fgedpmssbreq.setTrracsErrorCode(rs.getString(COL_TRRACS_ERROR_CODE));
        fgedpmssbreq.setTrracsErrorDecs(rs.getString(COL_TRRACS_ERROR_DECS));
        fgedpmssbreq.setCounterParty(rs.getString(COL_COUNTER_PARTY));
        fgedpmssbreq.setWriteOffBy(rs.getString(COL_WRITE_OFF_BY));
        fgedpmssbreq.setWriteOffReason(rs.getString(COL_WRITE_OFF_REASON));
        java.math.BigDecimal SB_AMOUNT = rs.getObject(COL_SB_AMOUNT, java.math.BigDecimal.class);
        fgedpmssbreq.setSbAmount(SB_AMOUNT);
        fgedpmssbreq.setSbCcy(rs.getString(COL_SB_CCY));
        java.math.BigDecimal SB_UTIL_AMT = rs.getObject(COL_SB_UTIL_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setSbUtilAmt(SB_UTIL_AMT);
        java.math.BigDecimal SB_OS_AMT = rs.getObject(COL_SB_OS_AMT, java.math.BigDecimal.class);
        fgedpmssbreq.setSbOsAmt(SB_OS_AMT);
        fgedpmssbreq.setBillrefno(rs.getString(COL_BILLREFNO));
        fgedpmssbreq.setBillNo(rs.getString(COL_BILL_NO));
        fgedpmssbreq.setReqType(rs.getString(COL_REQ_TYPE));
        fgedpmssbreq.setRemarks(rs.getString(COL_REMARKS));
        fgedpmssbreq.setFinalErrorDesc(rs.getString(COL_FINAL_ERROR_DESC));
        fgedpmssbreq.setFinalStatus(rs.getString(COL_FINAL_STATUS));
        return fgedpmssbreq;
    }
}
