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

public class JdbcFgFintechUploadDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFintechUploadDao.class);

    private static final String TABLE = "FG_FINTECH_UPLOAD";

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

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_CHANNELS = "CHANNELS";

    private static final String COL_TRANSFER_STATUS = "TRANSFER_STATUS";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_FILECONTENT = "FILECONTENT";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_REMARKS = "REMARKS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_CHANNELS, COL_TRANSFER_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_FILECONTENT, COL_UPLOAD_REF_ID, COL_FILE_NAME, COL_DMS_EVENT_ID, COL_REMARKS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, CHANNELS, TRANSFER_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILECONTENT, UPLOAD_REF_ID, FILE_NAME, DMS_EVENT_ID, REMARKS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, CHANNELS, TRANSFER_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILECONTENT, UPLOAD_REF_ID, FILE_NAME, DMS_EVENT_ID, REMARKS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_ISSUING_PARTY_CODE, COL_IS_TEMPLATE, COL_CHANNELS, COL_TRANSFER_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_FILECONTENT, COL_UPLOAD_REF_ID, COL_FILE_NAME, COL_DMS_EVENT_ID, COL_REMARKS, COL_ID);

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

    public int insert(Connection conn, FgFintechUpload fgfintechupload) throws SQLException {
        logger.debug("Inserting fgfintechupload: {}", fgfintechupload);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFintechUploadParams(ps, fgfintechupload);
            ps.executeUpdate();
            return fgfintechupload.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFintechUpload> fgfintechuploads) throws SQLException {
        if (fgfintechuploads == null || fgfintechuploads.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfintechuploads.size(); i++) {
            if (fgfintechuploads.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFintechUpload>> batches = chunkList(fgfintechuploads, batchSize);
        int[] totalResults = new int[fgfintechuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFintechUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFintechUpload fgfintechupload : batch) {
                        setFgFintechUploadParams(ps, fgfintechupload);
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

    public FgFintechUpload findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFintechUpload> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFintechUpload> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFintechUpload fgfintechupload) throws SQLException {
        if (fgfintechupload.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFintechUploadParams(ps, fgfintechupload);
            ps.setInt(27, fgfintechupload.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFintechUpload> fgfintechuploads) throws SQLException {
        if (fgfintechuploads == null || fgfintechuploads.isEmpty())
            return new int[0];
        for (FgFintechUpload fgfintechupload : fgfintechuploads) {
            if (fgfintechupload == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfintechupload.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFintechUpload>> batches = chunkList(fgfintechuploads, batchSize);
        int[] totalResults = new int[fgfintechuploads.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFintechUpload> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFintechUpload fgfintechupload : batch) {
                        setFgFintechUploadParams(ps, fgfintechupload);
                        ps.setInt(27, fgfintechupload.getID());
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

    private void setFgFintechUploadParams(PreparedStatement ps, FgFintechUpload fgfintechupload) throws SQLException {
        Integer val1 = fgfintechupload.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfintechupload.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfintechupload.getTypeCode());
        ps.setString(4, fgfintechupload.getSubTypeCode());
        ps.setString(5, fgfintechupload.getActiveCode());
        ps.setString(6, fgfintechupload.getStageCode());
        ps.setString(7, fgfintechupload.getStatusCode());
        Integer val8 = fgfintechupload.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgfintechupload.getCreatedOn());
        java.math.BigDecimal val10 = fgfintechupload.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgfintechupload.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgfintechupload.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgfintechupload.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgfintechupload.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgfintechupload.getTemplate());
        ps.setString(16, fgfintechupload.getApplicantPartyCode());
        ps.setString(17, fgfintechupload.getIssuingPartyCode());
        java.math.BigDecimal val18 = fgfintechupload.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgfintechupload.getChannels());
        ps.setString(20, fgfintechupload.getTransferStatus());
        Integer val21 = fgfintechupload.getLayoutTemplateID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        ps.setString(22, fgfintechupload.getLayoutName());
        ps.setBytes(23, fgfintechupload.getFilecontent());
        Integer val24 = fgfintechupload.getUploadRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        ps.setString(25, fgfintechupload.getFileName());
        Integer val26 = fgfintechupload.getDmsEventID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, fgfintechupload.getRemarks());
    }

    private FgFintechUpload extract(ResultSet rs) throws SQLException {
        FgFintechUpload fgfintechupload = new FgFintechUpload();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfintechupload.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfintechupload.setReferenceID(REFERENCE_ID);
        fgfintechupload.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfintechupload.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfintechupload.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfintechupload.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfintechupload.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgfintechupload.setProcessID(PROCESS_ID);
        fgfintechupload.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfintechupload.setCreatedBy(CREATED_BY);
        fgfintechupload.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfintechupload.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfintechupload.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfintechupload.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfintechupload.setTemplate(rs.getString(COL_TEMPLATE));
        fgfintechupload.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgfintechupload.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfintechupload.setIsTemplate(IS_TEMPLATE);
        fgfintechupload.setChannels(rs.getString(COL_CHANNELS));
        fgfintechupload.setTransferStatus(rs.getString(COL_TRANSFER_STATUS));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgfintechupload.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fgfintechupload.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        fgfintechupload.setFilecontent(rs.getBytes(COL_FILECONTENT));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfintechupload.setUploadRefID(UPLOAD_REF_ID);
        fgfintechupload.setFileName(rs.getString(COL_FILE_NAME));
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        fgfintechupload.setDmsEventID(DMS_EVENT_ID);
        fgfintechupload.setRemarks(rs.getString(COL_REMARKS));
        return fgfintechupload;
    }
}
