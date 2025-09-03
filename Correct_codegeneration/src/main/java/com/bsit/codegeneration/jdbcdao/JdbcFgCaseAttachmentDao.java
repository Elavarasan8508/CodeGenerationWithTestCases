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

public class JdbcFgCaseAttachmentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgCaseAttachmentDao.class);

    private static final String TABLE = "FG_CASE_ATTACHMENT";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

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

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FG_FILE_TITLE = "FG_FILE_TITLE";

    private static final String COL_FG_DOC_PURPOSE = "FG_DOC_PURPOSE";

    private static final String COL_FG_FILENAME = "FG_FILENAME";

    private static final String COL_FG_FILETYPE = "FG_FILETYPE";

    private static final String COL_FG_FILESIZE = "FG_FILESIZE";

    private static final String COL_FG_FILE_CREATED_ON = "FG_FILE_CREATED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_FG_FILE_TITLE, COL_FG_DOC_PURPOSE, COL_FG_FILENAME, COL_FG_FILETYPE, COL_FG_FILESIZE, COL_FG_FILE_CREATED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, UPLOAD_REF_ID, FG_FILE_TITLE, FG_DOC_PURPOSE, FG_FILENAME, FG_FILETYPE, FG_FILESIZE, FG_FILE_CREATED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, UPLOAD_REF_ID, FG_FILE_TITLE, FG_DOC_PURPOSE, FG_FILENAME, FG_FILETYPE, FG_FILESIZE, FG_FILE_CREATED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_FG_FILE_TITLE, COL_FG_DOC_PURPOSE, COL_FG_FILENAME, COL_FG_FILETYPE, COL_FG_FILESIZE, COL_FG_FILE_CREATED_ON, COL_ID);

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

    public int insert(Connection conn, FgCaseAttachment fgcaseattachment) throws SQLException {
        logger.debug("Inserting fgcaseattachment: {}", fgcaseattachment);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgCaseAttachmentParams(ps, fgcaseattachment);
            ps.executeUpdate();
            return fgcaseattachment.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgCaseAttachment> fgcaseattachments) throws SQLException {
        if (fgcaseattachments == null || fgcaseattachments.isEmpty())
            return new int[0];
        for (int i = 0; i < fgcaseattachments.size(); i++) {
            if (fgcaseattachments.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCaseAttachment>> batches = chunkList(fgcaseattachments, batchSize);
        int[] totalResults = new int[fgcaseattachments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCaseAttachment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgCaseAttachment fgcaseattachment : batch) {
                        setFgCaseAttachmentParams(ps, fgcaseattachment);
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

    public FgCaseAttachment findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgCaseAttachment> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgCaseAttachment> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgCaseAttachment fgcaseattachment) throws SQLException {
        if (fgcaseattachment.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgCaseAttachmentParams(ps, fgcaseattachment);
            ps.setInt(28, fgcaseattachment.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgCaseAttachment> fgcaseattachments) throws SQLException {
        if (fgcaseattachments == null || fgcaseattachments.isEmpty())
            return new int[0];
        for (FgCaseAttachment fgcaseattachment : fgcaseattachments) {
            if (fgcaseattachment == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgcaseattachment.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCaseAttachment>> batches = chunkList(fgcaseattachments, batchSize);
        int[] totalResults = new int[fgcaseattachments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCaseAttachment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgCaseAttachment fgcaseattachment : batch) {
                        setFgCaseAttachmentParams(ps, fgcaseattachment);
                        ps.setInt(28, fgcaseattachment.getID());
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

    private void setFgCaseAttachmentParams(PreparedStatement ps, FgCaseAttachment fgcaseattachment) throws SQLException {
        Integer val1 = fgcaseattachment.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgcaseattachment.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgcaseattachment.getApplicantPartyCode());
        Integer val4 = fgcaseattachment.getApplicantRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgcaseattachment.getIssuingPartyCode());
        ps.setString(6, fgcaseattachment.getTypeCode());
        ps.setString(7, fgcaseattachment.getSubTypeCode());
        ps.setString(8, fgcaseattachment.getActiveCode());
        ps.setString(9, fgcaseattachment.getStageCode());
        ps.setString(10, fgcaseattachment.getStatusCode());
        ps.setString(11, fgcaseattachment.getCreatedOn());
        java.math.BigDecimal val12 = fgcaseattachment.getCreatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgcaseattachment.getLastUpdatedOn());
        java.math.BigDecimal val14 = fgcaseattachment.getLastUpdatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgcaseattachment.getLastAuthorisedOn());
        java.math.BigDecimal val16 = fgcaseattachment.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgcaseattachment.getTemplate());
        java.math.BigDecimal val18 = fgcaseattachment.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        Integer val19 = fgcaseattachment.getVersionID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        java.math.BigDecimal val20 = fgcaseattachment.getIsMasterVersion();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        Integer val21 = fgcaseattachment.getProcessID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgcaseattachment.getUploadRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fgcaseattachment.getFgFileTitle());
        ps.setString(24, fgcaseattachment.getFgDocPurpose());
        ps.setString(25, fgcaseattachment.getFgFilename());
        ps.setString(26, fgcaseattachment.getFgFiletype());
        ps.setString(27, fgcaseattachment.getFgFilesize());
        java.time.LocalDateTime val28 = fgcaseattachment.getFgFileCreatedOn();
        if (val28 != null) {
            ps.setTimestamp(28, java.sql.Timestamp.valueOf(val28));
        } else {
            ps.setNull(28, Types.TIMESTAMP);
        }
    }

    private FgCaseAttachment extract(ResultSet rs) throws SQLException {
        FgCaseAttachment fgcaseattachment = new FgCaseAttachment();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgcaseattachment.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgcaseattachment.setReferenceID(REFERENCE_ID);
        fgcaseattachment.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgcaseattachment.setApplicantRefID(APPLICANT_REF_ID);
        fgcaseattachment.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgcaseattachment.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgcaseattachment.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgcaseattachment.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgcaseattachment.setStageCode(rs.getString(COL_STAGE_CODE));
        fgcaseattachment.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgcaseattachment.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgcaseattachment.setCreatedBy(CREATED_BY);
        fgcaseattachment.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgcaseattachment.setLastUpdatedBy(LAST_UPDATED_BY);
        fgcaseattachment.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgcaseattachment.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgcaseattachment.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgcaseattachment.setIsTemplate(IS_TEMPLATE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgcaseattachment.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgcaseattachment.setIsMasterVersion(IS_MASTER_VERSION);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgcaseattachment.setProcessID(PROCESS_ID);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgcaseattachment.setUploadRefID(UPLOAD_REF_ID);
        fgcaseattachment.setFgFileTitle(rs.getString(COL_FG_FILE_TITLE));
        fgcaseattachment.setFgDocPurpose(rs.getString(COL_FG_DOC_PURPOSE));
        fgcaseattachment.setFgFilename(rs.getString(COL_FG_FILENAME));
        fgcaseattachment.setFgFiletype(rs.getString(COL_FG_FILETYPE));
        fgcaseattachment.setFgFilesize(rs.getString(COL_FG_FILESIZE));
        Timestamp FG_FILE_CREATED_ON = rs.getTimestamp(COL_FG_FILE_CREATED_ON);
        if (FG_FILE_CREATED_ON != null)
            fgcaseattachment.setFgFileCreatedOn(FG_FILE_CREATED_ON.toLocalDateTime());
        return fgcaseattachment;
    }
}
