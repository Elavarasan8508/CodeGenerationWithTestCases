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

public class JdbcFgBankGuaranteeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBankGuaranteeDao.class);

    private static final String TABLE = "FG_BANK_GUARANTEE";

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

    private static final String COL_BANK_GUARANTEE_NUMBER = "BANK_GUARANTEE_NUMBER";

    private static final String COL_ISSUING_BANK_NAME = "ISSUING_BANK_NAME";

    private static final String COL_ISSUING_BANK_IFSC_OR_BIC = "ISSUING_BANK_IFSC_OR_BIC";

    private static final String COL_ISSUING_BANK_ADDRESS = "ISSUING_BANK_ADDRESS";

    private static final String COL_APPLICANT_CODE = "APPLICANT_CODE";

    private static final String COL_APPLICANT_NAME = "APPLICANT_NAME";

    private static final String COL_APPLICANT_ADDRESS = "APPLICANT_ADDRESS";

    private static final String COL_APPLICANT_PAN = "APPLICANT_PAN";

    private static final String COL_APPLICANT_GSTIN = "APPLICANT_GSTIN";

    private static final String COL_APPLICANT_AADHAAR = "APPLICANT_AADHAAR";

    private static final String COL_DATE_OF_ISSUANCE = "DATE_OF_ISSUANCE";

    private static final String COL_EFFECTIVE_DATE = "EFFECTIVE_DATE";

    private static final String COL_FACE_VALUE = "FACE_VALUE";

    private static final String COL_EXPIRY_DATE = "EXPIRY_DATE";

    private static final String COL_CLAIM_EXPIRY_DATE = "CLAIM_EXPIRY_DATE";

    private static final String COL_IFIN760COVER_REFERENCE = "IFIN760COVER_REFERENCE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BANK_GUARANTEE_NUMBER, COL_ISSUING_BANK_NAME, COL_ISSUING_BANK_IFSC_OR_BIC, COL_ISSUING_BANK_ADDRESS, COL_APPLICANT_CODE, COL_APPLICANT_NAME, COL_APPLICANT_ADDRESS, COL_APPLICANT_PAN, COL_APPLICANT_GSTIN, COL_APPLICANT_AADHAAR, COL_DATE_OF_ISSUANCE, COL_EFFECTIVE_DATE, COL_FACE_VALUE, COL_EXPIRY_DATE, COL_CLAIM_EXPIRY_DATE, COL_IFIN760COVER_REFERENCE, COL_UPLOAD_REF_ID, COL_DMS_EVENT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BANK_GUARANTEE_NUMBER, ISSUING_BANK_NAME, ISSUING_BANK_IFSC_OR_BIC, ISSUING_BANK_ADDRESS, APPLICANT_CODE, APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PAN, APPLICANT_GSTIN, APPLICANT_AADHAAR, DATE_OF_ISSUANCE, EFFECTIVE_DATE, FACE_VALUE, EXPIRY_DATE, CLAIM_EXPIRY_DATE, IFIN760COVER_REFERENCE, UPLOAD_REF_ID, DMS_EVENT_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BANK_GUARANTEE_NUMBER, ISSUING_BANK_NAME, ISSUING_BANK_IFSC_OR_BIC, ISSUING_BANK_ADDRESS, APPLICANT_CODE, APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PAN, APPLICANT_GSTIN, APPLICANT_AADHAAR, DATE_OF_ISSUANCE, EFFECTIVE_DATE, FACE_VALUE, EXPIRY_DATE, CLAIM_EXPIRY_DATE, IFIN760COVER_REFERENCE, UPLOAD_REF_ID, DMS_EVENT_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BANK_GUARANTEE_NUMBER, COL_ISSUING_BANK_NAME, COL_ISSUING_BANK_IFSC_OR_BIC, COL_ISSUING_BANK_ADDRESS, COL_APPLICANT_CODE, COL_APPLICANT_NAME, COL_APPLICANT_ADDRESS, COL_APPLICANT_PAN, COL_APPLICANT_GSTIN, COL_APPLICANT_AADHAAR, COL_DATE_OF_ISSUANCE, COL_EFFECTIVE_DATE, COL_FACE_VALUE, COL_EXPIRY_DATE, COL_CLAIM_EXPIRY_DATE, COL_IFIN760COVER_REFERENCE, COL_UPLOAD_REF_ID, COL_DMS_EVENT_ID, COL_ID);

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

    public int insert(Connection conn, FgBankGuarantee fgbankguarantee) throws SQLException {
        logger.debug("Inserting fgbankguarantee: {}", fgbankguarantee);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBankGuaranteeParams(ps, fgbankguarantee);
            ps.executeUpdate();
            return fgbankguarantee.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBankGuarantee> fgbankguarantees) throws SQLException {
        if (fgbankguarantees == null || fgbankguarantees.isEmpty())
            return new int[0];
        for (int i = 0; i < fgbankguarantees.size(); i++) {
            if (fgbankguarantees.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBankGuarantee>> batches = chunkList(fgbankguarantees, batchSize);
        int[] totalResults = new int[fgbankguarantees.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBankGuarantee> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBankGuarantee fgbankguarantee : batch) {
                        setFgBankGuaranteeParams(ps, fgbankguarantee);
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

    public FgBankGuarantee findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBankGuarantee> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBankGuarantee> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBankGuarantee fgbankguarantee) throws SQLException {
        if (fgbankguarantee.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBankGuaranteeParams(ps, fgbankguarantee);
            ps.setInt(33, fgbankguarantee.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBankGuarantee> fgbankguarantees) throws SQLException {
        if (fgbankguarantees == null || fgbankguarantees.isEmpty())
            return new int[0];
        for (FgBankGuarantee fgbankguarantee : fgbankguarantees) {
            if (fgbankguarantee == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgbankguarantee.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBankGuarantee>> batches = chunkList(fgbankguarantees, batchSize);
        int[] totalResults = new int[fgbankguarantees.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBankGuarantee> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBankGuarantee fgbankguarantee : batch) {
                        setFgBankGuaranteeParams(ps, fgbankguarantee);
                        ps.setInt(33, fgbankguarantee.getID());
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

    private void setFgBankGuaranteeParams(PreparedStatement ps, FgBankGuarantee fgbankguarantee) throws SQLException {
        Integer val1 = fgbankguarantee.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgbankguarantee.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgbankguarantee.getTypeCode());
        ps.setString(4, fgbankguarantee.getSubTypeCode());
        ps.setString(5, fgbankguarantee.getActiveCode());
        ps.setString(6, fgbankguarantee.getStageCode());
        ps.setString(7, fgbankguarantee.getStatusCode());
        ps.setString(8, fgbankguarantee.getCreatedOn());
        java.math.BigDecimal val9 = fgbankguarantee.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgbankguarantee.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgbankguarantee.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgbankguarantee.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgbankguarantee.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgbankguarantee.getTemplate());
        java.math.BigDecimal val15 = fgbankguarantee.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgbankguarantee.getBankGuaranteeNumber());
        ps.setString(17, fgbankguarantee.getIssuingBankName());
        ps.setString(18, fgbankguarantee.getIssuingBankIfscOrBic());
        ps.setString(19, fgbankguarantee.getIssuingBankAddress());
        ps.setString(20, fgbankguarantee.getApplicantCode());
        ps.setString(21, fgbankguarantee.getApplicantName());
        ps.setString(22, fgbankguarantee.getApplicantAddress());
        ps.setString(23, fgbankguarantee.getApplicantPan());
        ps.setString(24, fgbankguarantee.getApplicantGstin());
        ps.setString(25, fgbankguarantee.getApplicantAadhaar());
        java.time.LocalDateTime val26 = fgbankguarantee.getDateOfIssuance();
        if (val26 != null) {
            ps.setTimestamp(26, java.sql.Timestamp.valueOf(val26));
        } else {
            ps.setNull(26, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val27 = fgbankguarantee.getEffectiveDate();
        if (val27 != null) {
            ps.setTimestamp(27, java.sql.Timestamp.valueOf(val27));
        } else {
            ps.setNull(27, Types.TIMESTAMP);
        }
        java.math.BigDecimal val28 = fgbankguarantee.getFaceValue();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.time.LocalDateTime val29 = fgbankguarantee.getExpiryDate();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val30 = fgbankguarantee.getClaimExpiryDate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        ps.setString(31, fgbankguarantee.getIfin760coverReference());
        Integer val32 = fgbankguarantee.getUploadRefID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        Integer val33 = fgbankguarantee.getDmsEventID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
    }

    private FgBankGuarantee extract(ResultSet rs) throws SQLException {
        FgBankGuarantee fgbankguarantee = new FgBankGuarantee();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgbankguarantee.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgbankguarantee.setReferenceID(REFERENCE_ID);
        fgbankguarantee.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgbankguarantee.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgbankguarantee.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgbankguarantee.setStageCode(rs.getString(COL_STAGE_CODE));
        fgbankguarantee.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgbankguarantee.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgbankguarantee.setCreatedBy(CREATED_BY);
        fgbankguarantee.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgbankguarantee.setLastUpdatedBy(LAST_UPDATED_BY);
        fgbankguarantee.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgbankguarantee.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgbankguarantee.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgbankguarantee.setIsTemplate(IS_TEMPLATE);
        fgbankguarantee.setBankGuaranteeNumber(rs.getString(COL_BANK_GUARANTEE_NUMBER));
        fgbankguarantee.setIssuingBankName(rs.getString(COL_ISSUING_BANK_NAME));
        fgbankguarantee.setIssuingBankIfscOrBic(rs.getString(COL_ISSUING_BANK_IFSC_OR_BIC));
        fgbankguarantee.setIssuingBankAddress(rs.getString(COL_ISSUING_BANK_ADDRESS));
        fgbankguarantee.setApplicantCode(rs.getString(COL_APPLICANT_CODE));
        fgbankguarantee.setApplicantName(rs.getString(COL_APPLICANT_NAME));
        fgbankguarantee.setApplicantAddress(rs.getString(COL_APPLICANT_ADDRESS));
        fgbankguarantee.setApplicantPan(rs.getString(COL_APPLICANT_PAN));
        fgbankguarantee.setApplicantGstin(rs.getString(COL_APPLICANT_GSTIN));
        fgbankguarantee.setApplicantAadhaar(rs.getString(COL_APPLICANT_AADHAAR));
        Timestamp DATE_OF_ISSUANCE = rs.getTimestamp(COL_DATE_OF_ISSUANCE);
        if (DATE_OF_ISSUANCE != null)
            fgbankguarantee.setDateOfIssuance(DATE_OF_ISSUANCE.toLocalDateTime());
        Timestamp EFFECTIVE_DATE = rs.getTimestamp(COL_EFFECTIVE_DATE);
        if (EFFECTIVE_DATE != null)
            fgbankguarantee.setEffectiveDate(EFFECTIVE_DATE.toLocalDateTime());
        java.math.BigDecimal FACE_VALUE = rs.getObject(COL_FACE_VALUE, java.math.BigDecimal.class);
        fgbankguarantee.setFaceValue(FACE_VALUE);
        Timestamp EXPIRY_DATE = rs.getTimestamp(COL_EXPIRY_DATE);
        if (EXPIRY_DATE != null)
            fgbankguarantee.setExpiryDate(EXPIRY_DATE.toLocalDateTime());
        Timestamp CLAIM_EXPIRY_DATE = rs.getTimestamp(COL_CLAIM_EXPIRY_DATE);
        if (CLAIM_EXPIRY_DATE != null)
            fgbankguarantee.setClaimExpiryDate(CLAIM_EXPIRY_DATE.toLocalDateTime());
        fgbankguarantee.setIfin760coverReference(rs.getString(COL_IFIN760COVER_REFERENCE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgbankguarantee.setUploadRefID(UPLOAD_REF_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgbankguarantee.setDmsEventID(DMS_EVENT_ID);
        return fgbankguarantee;
    }
}
