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

public class JdbcFgTrdImpRegRqVerDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdImpRegRqVerDao.class);

    private static final String TABLE = "FG_TRD_IMP_REG_RQ_VER";

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

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_ISSUING_PARTY = "ISSUING_PARTY";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_CHECKBOX = "CHECKBOX";

    private static final String COL_ACK_MESSAGE = "ACK_MESSAGE";

    private static final String COL_ACK_STATUS = "ACK_STATUS";

    private static final String COL_NAME_MATCH = "NAME_MATCH";

    private static final String COL_GENERAL_DETAILS = "GENERAL_DETAILS";

    private static final String COL_ATTACHMENTS = "ATTACHMENTS";

    private static final String COL_PREVIEW = "PREVIEW";

    private static final String COL_STEPPER_COMPLETION_PERCENTAGE = "STEPPER_COMPLETION_PERCENTAGE";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_BANK_USER_ID = "BANK_USER_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_IE_CODE, COL_INVOICE_NUMBER, COL_PORT_CODE, COL_PRODUCT_STATUS, COL_REQ_TYPE, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_DMS_EVENT_ID, COL_CHECKBOX, COL_ACK_MESSAGE, COL_ACK_STATUS, COL_NAME_MATCH, COL_GENERAL_DETAILS, COL_ATTACHMENTS, COL_PREVIEW, COL_STEPPER_COMPLETION_PERCENTAGE, COL_TASK_REASON, COL_BANK_USER_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, CHECKBOX, ACK_MESSAGE, ACK_STATUS, NAME_MATCH, GENERAL_DETAILS, ATTACHMENTS, PREVIEW, STEPPER_COMPLETION_PERCENTAGE, TASK_REASON, BANK_USER_ID, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, CHECKBOX, ACK_MESSAGE, ACK_STATUS, NAME_MATCH, GENERAL_DETAILS, ATTACHMENTS, PREVIEW, STEPPER_COMPLETION_PERCENTAGE, TASK_REASON, BANK_USER_ID, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_IE_CODE, COL_INVOICE_NUMBER, COL_PORT_CODE, COL_PRODUCT_STATUS, COL_REQ_TYPE, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_ISSUING_PARTY, COL_DMS_EVENT_ID, COL_CHECKBOX, COL_ACK_MESSAGE, COL_ACK_STATUS, COL_NAME_MATCH, COL_GENERAL_DETAILS, COL_ATTACHMENTS, COL_PREVIEW, COL_STEPPER_COMPLETION_PERCENTAGE, COL_TASK_REASON, COL_BANK_USER_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, FgTrdImpRegRqVer fgtrdimpregrqver) throws SQLException {
        logger.debug("Inserting fgtrdimpregrqver: {}", fgtrdimpregrqver);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdImpRegRqVerParams(ps, fgtrdimpregrqver);
            ps.executeUpdate();
            return fgtrdimpregrqver.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdImpRegRqVer> fgtrdimpregrqvers) throws SQLException {
        if (fgtrdimpregrqvers == null || fgtrdimpregrqvers.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdimpregrqvers.size(); i++) {
            if (fgtrdimpregrqvers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdImpRegRqVer>> batches = chunkList(fgtrdimpregrqvers, batchSize);
        int[] totalResults = new int[fgtrdimpregrqvers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdImpRegRqVer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdImpRegRqVer fgtrdimpregrqver : batch) {
                        setFgTrdImpRegRqVerParams(ps, fgtrdimpregrqver);
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

    public FgTrdImpRegRqVer findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdImpRegRqVer> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdImpRegRqVer> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdImpRegRqVer fgtrdimpregrqver) throws SQLException {
        if (fgtrdimpregrqver.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdImpRegRqVerParams(ps, fgtrdimpregrqver);
            ps.setInt(38, fgtrdimpregrqver.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdImpRegRqVer> fgtrdimpregrqvers) throws SQLException {
        if (fgtrdimpregrqvers == null || fgtrdimpregrqvers.isEmpty())
            return new int[0];
        for (FgTrdImpRegRqVer fgtrdimpregrqver : fgtrdimpregrqvers) {
            if (fgtrdimpregrqver == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdimpregrqver.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdImpRegRqVer>> batches = chunkList(fgtrdimpregrqvers, batchSize);
        int[] totalResults = new int[fgtrdimpregrqvers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdImpRegRqVer> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdImpRegRqVer fgtrdimpregrqver : batch) {
                        setFgTrdImpRegRqVerParams(ps, fgtrdimpregrqver);
                        ps.setInt(38, fgtrdimpregrqver.getID());
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

    private void setFgTrdImpRegRqVerParams(PreparedStatement ps, FgTrdImpRegRqVer fgtrdimpregrqver) throws SQLException {
        Integer val1 = fgtrdimpregrqver.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdimpregrqver.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdimpregrqver.getTypeCode());
        ps.setString(4, fgtrdimpregrqver.getSubTypeCode());
        ps.setString(5, fgtrdimpregrqver.getActiveCode());
        ps.setString(6, fgtrdimpregrqver.getStageCode());
        ps.setString(7, fgtrdimpregrqver.getStatusCode());
        ps.setString(8, fgtrdimpregrqver.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdimpregrqver.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdimpregrqver.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdimpregrqver.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdimpregrqver.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdimpregrqver.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdimpregrqver.getTemplate());
        java.math.BigDecimal val15 = fgtrdimpregrqver.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = fgtrdimpregrqver.getBoeNumber();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.time.LocalDateTime val17 = fgtrdimpregrqver.getBoeDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrdimpregrqver.getIeCode());
        java.math.BigDecimal val19 = fgtrdimpregrqver.getInvoiceNumber();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgtrdimpregrqver.getPortCode());
        ps.setString(21, fgtrdimpregrqver.getProductStatus());
        ps.setString(22, fgtrdimpregrqver.getReqType());
        Integer val23 = fgtrdimpregrqver.getProcessID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, fgtrdimpregrqver.getApplicantParty());
        ps.setString(25, fgtrdimpregrqver.getIssuingParty());
        Integer val26 = fgtrdimpregrqver.getDmsEventID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        java.math.BigDecimal val27 = fgtrdimpregrqver.getCheckbox();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgtrdimpregrqver.getAckMessage());
        ps.setString(29, fgtrdimpregrqver.getAckStatus());
        java.math.BigDecimal val30 = fgtrdimpregrqver.getNameMatch();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgtrdimpregrqver.getGeneralDetails());
        ps.setString(32, fgtrdimpregrqver.getAttachments());
        ps.setString(33, fgtrdimpregrqver.getPreview());
        java.math.BigDecimal val34 = fgtrdimpregrqver.getStepperCompletionPercentage();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fgtrdimpregrqver.getTaskReason());
        Integer val36 = fgtrdimpregrqver.getBankUserID();
        if (val36 != null) {
            ps.setInt(36, val36);
        } else {
            ps.setNull(36, Types.INTEGER);
        }
        Integer val37 = fgtrdimpregrqver.getVersionID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        java.math.BigDecimal val38 = fgtrdimpregrqver.getIsMasterVersion();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
    }

    private FgTrdImpRegRqVer extract(ResultSet rs) throws SQLException {
        FgTrdImpRegRqVer fgtrdimpregrqver = new FgTrdImpRegRqVer();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdimpregrqver.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdimpregrqver.setReferenceID(REFERENCE_ID);
        fgtrdimpregrqver.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdimpregrqver.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdimpregrqver.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdimpregrqver.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdimpregrqver.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdimpregrqver.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdimpregrqver.setCreatedBy(CREATED_BY);
        fgtrdimpregrqver.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdimpregrqver.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdimpregrqver.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdimpregrqver.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdimpregrqver.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdimpregrqver.setIsTemplate(IS_TEMPLATE);
        java.math.BigDecimal BOE_NUMBER = rs.getObject(COL_BOE_NUMBER, java.math.BigDecimal.class);
        fgtrdimpregrqver.setBoeNumber(BOE_NUMBER);
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgtrdimpregrqver.setBoeDate(BOE_DATE.toLocalDateTime());
        fgtrdimpregrqver.setIeCode(rs.getString(COL_IE_CODE));
        java.math.BigDecimal INVOICE_NUMBER = rs.getObject(COL_INVOICE_NUMBER, java.math.BigDecimal.class);
        fgtrdimpregrqver.setInvoiceNumber(INVOICE_NUMBER);
        fgtrdimpregrqver.setPortCode(rs.getString(COL_PORT_CODE));
        fgtrdimpregrqver.setProductStatus(rs.getString(COL_PRODUCT_STATUS));
        fgtrdimpregrqver.setReqType(rs.getString(COL_REQ_TYPE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrdimpregrqver.setProcessID(PROCESS_ID);
        fgtrdimpregrqver.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtrdimpregrqver.setIssuingParty(rs.getString(COL_ISSUING_PARTY));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgtrdimpregrqver.setDmsEventID(DMS_EVENT_ID);
        java.math.BigDecimal CHECKBOX = rs.getObject(COL_CHECKBOX, java.math.BigDecimal.class);
        fgtrdimpregrqver.setCheckbox(CHECKBOX);
        fgtrdimpregrqver.setAckMessage(rs.getString(COL_ACK_MESSAGE));
        fgtrdimpregrqver.setAckStatus(rs.getString(COL_ACK_STATUS));
        java.math.BigDecimal NAME_MATCH = rs.getObject(COL_NAME_MATCH, java.math.BigDecimal.class);
        fgtrdimpregrqver.setNameMatch(NAME_MATCH);
        fgtrdimpregrqver.setGeneralDetails(rs.getString(COL_GENERAL_DETAILS));
        fgtrdimpregrqver.setAttachments(rs.getString(COL_ATTACHMENTS));
        fgtrdimpregrqver.setPreview(rs.getString(COL_PREVIEW));
        java.math.BigDecimal STEPPER_COMPLETION_PERCENTAGE = rs.getObject(COL_STEPPER_COMPLETION_PERCENTAGE, java.math.BigDecimal.class);
        fgtrdimpregrqver.setStepperCompletionPercentage(STEPPER_COMPLETION_PERCENTAGE);
        fgtrdimpregrqver.setTaskReason(rs.getString(COL_TASK_REASON));
        Integer BANK_USER_ID = rs.getObject(COL_BANK_USER_ID, Integer.class);
        fgtrdimpregrqver.setBankUserID(BANK_USER_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtrdimpregrqver.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtrdimpregrqver.setIsMasterVersion(IS_MASTER_VERSION);
        return fgtrdimpregrqver;
    }
}
