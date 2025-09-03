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

public class JdbcFgTrdImpRegRqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdImpRegRqDao.class);

    private static final String TABLE = "FG_TRD_IMP_REG_RQ";

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

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_PRODUCT_STATUS = "PRODUCT_STATUS";

    private static final String COL_BANK_CODE = "BANK_CODE";

    private static final String COL_BANK_NAME = "BANK_NAME";

    private static final String COL_TRAN_REQ = "TRAN_REQ";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ISSUING_PARTY = "ISSUING_PARTY";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_NAME_MATCH = "NAME_MATCH";

    private static final String COL_CHECKBOX = "CHECKBOX";

    private static final String COL_BANK_USER_ID = "BANK_USER_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_IE_CODE, COL_INVOICE_NUMBER, COL_PORT_CODE, COL_PRODUCT_STATUS, COL_BANK_CODE, COL_BANK_NAME, COL_TRAN_REQ, COL_REQ_TYPE, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_DMS_EVENT_ID, COL_TASK_REASON, COL_NAME_MATCH, COL_CHECKBOX, COL_BANK_USER_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, BANK_CODE, BANK_NAME, TRAN_REQ, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, TASK_REASON, NAME_MATCH, CHECKBOX, BANK_USER_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, BANK_CODE, BANK_NAME, TRAN_REQ, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, TASK_REASON, NAME_MATCH, CHECKBOX, BANK_USER_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_IE_CODE, COL_INVOICE_NUMBER, COL_PORT_CODE, COL_PRODUCT_STATUS, COL_BANK_CODE, COL_BANK_NAME, COL_TRAN_REQ, COL_REQ_TYPE, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_DMS_EVENT_ID, COL_TASK_REASON, COL_NAME_MATCH, COL_CHECKBOX, COL_BANK_USER_ID, COL_ID);

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

    public int insert(Connection conn, FgTrdImpRegRq fgtrdimpregrq) throws SQLException {
        logger.debug("Inserting fgtrdimpregrq: {}", fgtrdimpregrq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdImpRegRqParams(ps, fgtrdimpregrq);
            ps.executeUpdate();
            return fgtrdimpregrq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdImpRegRq> fgtrdimpregrqs) throws SQLException {
        if (fgtrdimpregrqs == null || fgtrdimpregrqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdimpregrqs.size(); i++) {
            if (fgtrdimpregrqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdImpRegRq>> batches = chunkList(fgtrdimpregrqs, batchSize);
        int[] totalResults = new int[fgtrdimpregrqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdImpRegRq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdImpRegRq fgtrdimpregrq : batch) {
                        setFgTrdImpRegRqParams(ps, fgtrdimpregrq);
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

    public FgTrdImpRegRq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdImpRegRq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdImpRegRq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdImpRegRq fgtrdimpregrq) throws SQLException {
        if (fgtrdimpregrq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdImpRegRqParams(ps, fgtrdimpregrq);
            ps.setInt(33, fgtrdimpregrq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdImpRegRq> fgtrdimpregrqs) throws SQLException {
        if (fgtrdimpregrqs == null || fgtrdimpregrqs.isEmpty())
            return new int[0];
        for (FgTrdImpRegRq fgtrdimpregrq : fgtrdimpregrqs) {
            if (fgtrdimpregrq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdimpregrq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdImpRegRq>> batches = chunkList(fgtrdimpregrqs, batchSize);
        int[] totalResults = new int[fgtrdimpregrqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdImpRegRq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdImpRegRq fgtrdimpregrq : batch) {
                        setFgTrdImpRegRqParams(ps, fgtrdimpregrq);
                        ps.setInt(33, fgtrdimpregrq.getID());
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

    private void setFgTrdImpRegRqParams(PreparedStatement ps, FgTrdImpRegRq fgtrdimpregrq) throws SQLException {
        Integer val1 = fgtrdimpregrq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdimpregrq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdimpregrq.getTypeCode());
        ps.setString(4, fgtrdimpregrq.getSubTypeCode());
        ps.setString(5, fgtrdimpregrq.getActiveCode());
        ps.setString(6, fgtrdimpregrq.getStageCode());
        ps.setString(7, fgtrdimpregrq.getStatusCode());
        ps.setString(8, fgtrdimpregrq.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdimpregrq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdimpregrq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdimpregrq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdimpregrq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdimpregrq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdimpregrq.getTemplate());
        java.math.BigDecimal val15 = fgtrdimpregrq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = fgtrdimpregrq.getBoeNumber();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.time.LocalDateTime val17 = fgtrdimpregrq.getBoeDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrdimpregrq.getIeCode());
        java.math.BigDecimal val19 = fgtrdimpregrq.getInvoiceNumber();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgtrdimpregrq.getPortCode());
        ps.setString(21, fgtrdimpregrq.getProductStatus());
        ps.setString(22, fgtrdimpregrq.getBankCode());
        ps.setString(23, fgtrdimpregrq.getBankName());
        ps.setString(24, fgtrdimpregrq.getTranReq());
        ps.setString(25, fgtrdimpregrq.getReqType());
        Integer val26 = fgtrdimpregrq.getProcessID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, fgtrdimpregrq.getApplicantParty());
        ps.setString(28, fgtrdimpregrq.getIssuingParty());
        Integer val29 = fgtrdimpregrq.getDmsEventID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgtrdimpregrq.getTaskReason());
        java.math.BigDecimal val31 = fgtrdimpregrq.getNameMatch();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        java.math.BigDecimal val32 = fgtrdimpregrq.getCheckbox();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        Integer val33 = fgtrdimpregrq.getBankUserID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
    }

    private FgTrdImpRegRq extract(ResultSet rs) throws SQLException {
        FgTrdImpRegRq fgtrdimpregrq = new FgTrdImpRegRq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdimpregrq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdimpregrq.setReferenceID(REFERENCE_ID);
        fgtrdimpregrq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdimpregrq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdimpregrq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdimpregrq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdimpregrq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdimpregrq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdimpregrq.setCreatedBy(CREATED_BY);
        fgtrdimpregrq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdimpregrq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdimpregrq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdimpregrq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdimpregrq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdimpregrq.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal BOE_NUMBER = rs.getObject(COL_BOE_NUMBER, java.math.BigDecimal.class);
        fgtrdimpregrq.setBoeNumber(BOE_NUMBER);
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgtrdimpregrq.setBoeDate(BOE_DATE.toLocalDateTime());
        fgtrdimpregrq.setIeCode(rs.getString(COL_IE_CODE));
        java.math.BigDecimal INVOICE_NUMBER = rs.getObject(COL_INVOICE_NUMBER, java.math.BigDecimal.class);
        fgtrdimpregrq.setInvoiceNumber(INVOICE_NUMBER);
        fgtrdimpregrq.setPortCode(rs.getString(COL_PORT_CODE));
        fgtrdimpregrq.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        fgtrdimpregrq.setBankCode(rs.getString(COL_BANK_CODE));
        fgtrdimpregrq.setBankName(rs.getString(COL_BANK_NAME));
        fgtrdimpregrq.setTranReq(rs.getString(COL_TRAN_REQ));
        fgtrdimpregrq.setReqType(rs.getString(COL_REQ_TYPE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrdimpregrq.setProcessID(PROCESS_ID);
        fgtrdimpregrq.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtrdimpregrq.setIssuingParty(rs.getString(COL_ISSUING_PARTY));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgtrdimpregrq.setDmsEventID(DMS_EVENT_ID);
        fgtrdimpregrq.setTaskReason(rs.getString(COL_TASK_REASON));
        java.math.BigDecimal NAME_MATCH = rs.getObject(COL_NAME_MATCH, java.math.BigDecimal.class);
        fgtrdimpregrq.setNameMatch(NAME_MATCH);
        java.math.BigDecimal CHECKBOX = rs.getObject(COL_CHECKBOX, java.math.BigDecimal.class);
        fgtrdimpregrq.setCheckbox(CHECKBOX);
        Integer BANK_USER_ID = rs.getObject(COL_BANK_USER_ID, Integer.class);
        fgtrdimpregrq.setBankUserID(BANK_USER_ID);
        return fgtrdimpregrq;
    }
}
