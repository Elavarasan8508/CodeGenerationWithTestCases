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

public class JdbcFgTrdExpRegRqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdExpRegRqDao.class);

    private static final String TABLE = "FG_TRD_EXP_REG_RQ";

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

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_EXP_TYPE = "EXP_TYPE";

    private static final String COL_SB_NO = "SB_NO";

    private static final String COL_SB_DATE = "SB_DATE";

    private static final String COL_FORM_NO = "FORM_NO";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_IRM_NO = "IRM_NO";

    private static final String COL_IRM_AD = "IRM_AD";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_OS_AMT_IRM = "OS_AMT_IRM";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ISSUING_PARTY = "ISSUING_PARTY";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_EXP_AGENCY = "EXP_AGENCY";

    private static final String COL_DEBIT_ACC_NUM = "DEBIT_ACC_NUM";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PORT_CODE, COL_EXP_TYPE, COL_SB_NO, COL_SB_DATE, COL_FORM_NO, COL_IE_CODE, COL_REQ_TYPE, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_OS_AMT_IRM, COL_IRM_CCY, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_PRODUCT_STATUS, COL_PROCESS_ID, COL_DMS_EVENT_ID, COL_EXP_AGENCY, COL_DEBIT_ACC_NUM);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PORT_CODE, EXP_TYPE, SB_NO, SB_DATE, FORM_NO, IE_CODE, REQ_TYPE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, APPLICANT_PARTY, ISSUING_PARTY, PRODUCT_STATUS, PROCESS_ID, DMS_EVENT_ID, EXP_AGENCY, DEBIT_ACC_NUM", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PORT_CODE, EXP_TYPE, SB_NO, SB_DATE, FORM_NO, IE_CODE, REQ_TYPE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, APPLICANT_PARTY, ISSUING_PARTY, PRODUCT_STATUS, PROCESS_ID, DMS_EVENT_ID, EXP_AGENCY, DEBIT_ACC_NUM", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PORT_CODE, COL_EXP_TYPE, COL_SB_NO, COL_SB_DATE, COL_FORM_NO, COL_IE_CODE, COL_REQ_TYPE, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_OS_AMT_IRM, COL_IRM_CCY, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_PRODUCT_STATUS, COL_PROCESS_ID, COL_DMS_EVENT_ID, COL_EXP_AGENCY, COL_DEBIT_ACC_NUM, COL_ID);

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

    public int insert(Connection conn, FgTrdExpRegRq fgtrdexpregrq) throws SQLException {
        logger.debug("Inserting fgtrdexpregrq: {}", fgtrdexpregrq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdExpRegRqParams(ps, fgtrdexpregrq);
            ps.executeUpdate();
            return fgtrdexpregrq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdExpRegRq> fgtrdexpregrqs) throws SQLException {
        if (fgtrdexpregrqs == null || fgtrdexpregrqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdexpregrqs.size(); i++) {
            if (fgtrdexpregrqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdExpRegRq>> batches = chunkList(fgtrdexpregrqs, batchSize);
        int[] totalResults = new int[fgtrdexpregrqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdExpRegRq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdExpRegRq fgtrdexpregrq : batch) {
                        setFgTrdExpRegRqParams(ps, fgtrdexpregrq);
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

    public FgTrdExpRegRq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdExpRegRq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdExpRegRq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdExpRegRq fgtrdexpregrq) throws SQLException {
        if (fgtrdexpregrq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdExpRegRqParams(ps, fgtrdexpregrq);
            ps.setInt(34, fgtrdexpregrq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdExpRegRq> fgtrdexpregrqs) throws SQLException {
        if (fgtrdexpregrqs == null || fgtrdexpregrqs.isEmpty())
            return new int[0];
        for (FgTrdExpRegRq fgtrdexpregrq : fgtrdexpregrqs) {
            if (fgtrdexpregrq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdexpregrq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdExpRegRq>> batches = chunkList(fgtrdexpregrqs, batchSize);
        int[] totalResults = new int[fgtrdexpregrqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdExpRegRq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdExpRegRq fgtrdexpregrq : batch) {
                        setFgTrdExpRegRqParams(ps, fgtrdexpregrq);
                        ps.setInt(34, fgtrdexpregrq.getID());
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

    private void setFgTrdExpRegRqParams(PreparedStatement ps, FgTrdExpRegRq fgtrdexpregrq) throws SQLException {
        Integer val1 = fgtrdexpregrq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdexpregrq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdexpregrq.getTypeCode());
        ps.setString(4, fgtrdexpregrq.getSubTypeCode());
        ps.setString(5, fgtrdexpregrq.getActiveCode());
        ps.setString(6, fgtrdexpregrq.getStageCode());
        ps.setString(7, fgtrdexpregrq.getStatusCode());
        ps.setString(8, fgtrdexpregrq.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdexpregrq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdexpregrq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdexpregrq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdexpregrq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdexpregrq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdexpregrq.getTemplate());
        java.math.BigDecimal val15 = fgtrdexpregrq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdexpregrq.getPortCode());
        ps.setString(17, fgtrdexpregrq.getExpType());
        ps.setString(18, fgtrdexpregrq.getSbNo());
        java.time.LocalDateTime val19 = fgtrdexpregrq.getSbDate();
        if (val19 != null) {
            ps.setTimestamp(19, java.sql.Timestamp.valueOf(val19));
        } else {
            ps.setNull(19, Types.TIMESTAMP);
        }
        ps.setString(20, fgtrdexpregrq.getFormNo());
        ps.setString(21, fgtrdexpregrq.getIeCode());
        ps.setString(22, fgtrdexpregrq.getReqType());
        ps.setString(23, fgtrdexpregrq.getIrmNo());
        ps.setString(24, fgtrdexpregrq.getIrmAd());
        java.math.BigDecimal val25 = fgtrdexpregrq.getIrmAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgtrdexpregrq.getOsAmtIrm();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgtrdexpregrq.getIrmCcy());
        ps.setString(28, fgtrdexpregrq.getApplicantParty());
        ps.setString(29, fgtrdexpregrq.getIssuingParty());
        ps.setString(30, fgtrdexpregrq.getProductStatus());
        Integer val31 = fgtrdexpregrq.getProcessID();
        if (val31 != null) {
            ps.setInt(31, val31);
        } else {
            ps.setNull(31, Types.INTEGER);
        }
        Integer val32 = fgtrdexpregrq.getDmsEventID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        ps.setString(33, fgtrdexpregrq.getExpAgency());
        ps.setString(34, fgtrdexpregrq.getDebitAccNum());
    }

    private FgTrdExpRegRq extract(ResultSet rs) throws SQLException {
        FgTrdExpRegRq fgtrdexpregrq = new FgTrdExpRegRq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdexpregrq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdexpregrq.setReferenceID(REFERENCE_ID);
        fgtrdexpregrq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdexpregrq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdexpregrq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdexpregrq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdexpregrq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdexpregrq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdexpregrq.setCreatedBy(CREATED_BY);
        fgtrdexpregrq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdexpregrq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdexpregrq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdexpregrq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdexpregrq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdexpregrq.setIsTemplate(IS_TEMPLATE);
        fgtrdexpregrq.setPortCode(rs.getString(COL_PORT_CODE));
        fgtrdexpregrq.setExpType(rs.getString(COL_EXP_TYPE));
        fgtrdexpregrq.setSbNo(rs.getString(COL_SB_NO));
        Timestamp SB_DATE = rs.getTimestamp(COL_SB_DATE);
        if (SB_DATE != null)
            fgtrdexpregrq.setSbDate(SB_DATE.toLocalDateTime());
        fgtrdexpregrq.setFormNo(rs.getString(COL_FORM_NO));
        fgtrdexpregrq.setIeCode(rs.getString(COL_IE_CODE));
        fgtrdexpregrq.setReqType(rs.getString(COL_REQ_TYPE));
        fgtrdexpregrq.setIrmNo(rs.getString(COL_IRM_NO));
        fgtrdexpregrq.setIrmAd(rs.getString(COL_IRM_AD));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgtrdexpregrq.setIrmAmt(IRM_AMT);
        java.math.BigDecimal OS_AMT_IRM = rs.getObject(COL_OS_AMT_IRM, java.math.BigDecimal.class);
        fgtrdexpregrq.setOsAmtIrm(OS_AMT_IRM);
        fgtrdexpregrq.setIrmCcy(rs.getString(COL_IRM_CCY));
        fgtrdexpregrq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtrdexpregrq.setIssuingParty(rs.getString(COL_ISSUING_PARTY));
        fgtrdexpregrq.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrdexpregrq.setProcessID(PROCESS_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgtrdexpregrq.setDmsEventID(DMS_EVENT_ID);
        fgtrdexpregrq.setExpAgency(rs.getString(COL_EXP_AGENCY));
        fgtrdexpregrq.setDebitAccNum(rs.getString(COL_DEBIT_ACC_NUM));
        return fgtrdexpregrq;
    }
}
