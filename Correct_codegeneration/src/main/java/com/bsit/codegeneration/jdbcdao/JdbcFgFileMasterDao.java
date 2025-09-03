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

public class JdbcFgFileMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgFileMasterDao.class);

    private static final String TABLE = "FG_FILE_MASTER";

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

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FILE_ATTACH_REF_NO = "FILE_ATTACH_REF_NO";

    private static final String COL_FILE_STATUS = "FILE_STATUS";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_LINE_COUNT = "LINE_COUNT";

    private static final String COL_TXN_COUNT = "TXN_COUNT";

    private static final String COL_TXN_VAL_SUCCESS_CNT = "TXN_VAL_SUCCESS_CNT";

    private static final String COL_TXN_LISTING_CNT = "TXN_LISTING_CNT";

    private static final String COL_TXN_LISTING_ACK_CNT = "TXN_LISTING_ACK_CNT";

    private static final String COL_FINPAY_REQ_CNT = "FINPAY_REQ_CNT";

    private static final String COL_INTEGRITY_SUCCESS_CNT = "INTEGRITY_SUCCESS_CNT";

    private static final String COL_STAGESTATUS = "STAGESTATUS";

    private static final String COL_FINPAY_RESP_CNT = "FINPAY_RESP_CNT";

    private static final String COL_ANCHOR_NAME = "ANCHOR_NAME";

    private static final String COL_DISPLAY_FILE_NAME = "DISPLAY_FILE_NAME";

    private static final String COL_HASH_KEY = "HASH_KEY";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_LAYOUT_TEMPLATE_ID = "LAYOUT_TEMPLATE_ID";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_LAYOUT_TEMPLATE_VERSION_ID = "LAYOUT_TEMPLATE_VERSION_ID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_ATTACH_REF_NO, COL_FILE_STATUS, COL_REMARKS, COL_LINE_COUNT, COL_TXN_COUNT, COL_TXN_VAL_SUCCESS_CNT, COL_TXN_LISTING_CNT, COL_TXN_LISTING_ACK_CNT, COL_FINPAY_REQ_CNT, COL_INTEGRITY_SUCCESS_CNT, COL_STAGESTATUS, COL_FINPAY_RESP_CNT, COL_ANCHOR_NAME, COL_DISPLAY_FILE_NAME, COL_HASH_KEY, COL_PURPOSE_CODE, COL_DISPLAY_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_UPLOAD_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_ATTACH_REF_NO, COL_FILE_STATUS, COL_REMARKS, COL_LINE_COUNT, COL_TXN_COUNT, COL_TXN_VAL_SUCCESS_CNT, COL_TXN_LISTING_CNT, COL_TXN_LISTING_ACK_CNT, COL_FINPAY_REQ_CNT, COL_INTEGRITY_SUCCESS_CNT, COL_STAGESTATUS, COL_FINPAY_RESP_CNT, COL_ANCHOR_NAME, COL_DISPLAY_FILE_NAME, COL_HASH_KEY, COL_PURPOSE_CODE, COL_DISPLAY_STATUS, COL_LAYOUT_TEMPLATE_ID, COL_LAYOUT_NAME, COL_LAYOUT_TEMPLATE_VERSION_ID, COL_UPLOAD_REF_ID, COL_ID);

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

    public int insert(Connection conn, FgFileMaster fgfilemaster) throws SQLException {
        logger.debug("Inserting fgfilemaster: {}", fgfilemaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgFileMasterParams(ps, fgfilemaster);
            ps.executeUpdate();
            return fgfilemaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgFileMaster> fgfilemasters) throws SQLException {
        if (fgfilemasters == null || fgfilemasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgfilemasters.size(); i++) {
            if (fgfilemasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileMaster>> batches = chunkList(fgfilemasters, batchSize);
        int[] totalResults = new int[fgfilemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgFileMaster fgfilemaster : batch) {
                        setFgFileMasterParams(ps, fgfilemaster);
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

    public FgFileMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgFileMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgFileMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgFileMaster fgfilemaster) throws SQLException {
        if (fgfilemaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgFileMasterParams(ps, fgfilemaster);
            ps.setInt(38, fgfilemaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgFileMaster> fgfilemasters) throws SQLException {
        if (fgfilemasters == null || fgfilemasters.isEmpty())
            return new int[0];
        for (FgFileMaster fgfilemaster : fgfilemasters) {
            if (fgfilemaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgfilemaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgFileMaster>> batches = chunkList(fgfilemasters, batchSize);
        int[] totalResults = new int[fgfilemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgFileMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgFileMaster fgfilemaster : batch) {
                        setFgFileMasterParams(ps, fgfilemaster);
                        ps.setInt(38, fgfilemaster.getID());
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

    private void setFgFileMasterParams(PreparedStatement ps, FgFileMaster fgfilemaster) throws SQLException {
        Integer val1 = fgfilemaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgfilemaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgfilemaster.getTypeCode());
        ps.setString(4, fgfilemaster.getSubTypeCode());
        ps.setString(5, fgfilemaster.getActiveCode());
        ps.setString(6, fgfilemaster.getStageCode());
        ps.setString(7, fgfilemaster.getStatusCode());
        ps.setString(8, fgfilemaster.getCreatedOn());
        java.math.BigDecimal val9 = fgfilemaster.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgfilemaster.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgfilemaster.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgfilemaster.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgfilemaster.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgfilemaster.getTemplate());
        java.math.BigDecimal val15 = fgfilemaster.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgfilemaster.getAnchorCrn());
        ps.setString(17, fgfilemaster.getFileName());
        ps.setString(18, fgfilemaster.getFileAttachRefNo());
        ps.setString(19, fgfilemaster.getFileStatus());
        ps.setString(20, fgfilemaster.getRemarks());
        java.math.BigDecimal val21 = fgfilemaster.getLineCount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgfilemaster.getTxnCount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgfilemaster.getTxnValSuccessCnt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgfilemaster.getTxnListingCnt();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgfilemaster.getTxnListingAckCnt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgfilemaster.getFinpayReqCnt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = fgfilemaster.getIntegritySuccessCnt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgfilemaster.getStagestatus());
        java.math.BigDecimal val29 = fgfilemaster.getFinpayRespCnt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgfilemaster.getAnchorName());
        ps.setString(31, fgfilemaster.getDisplayFileName());
        ps.setString(32, fgfilemaster.getHashKey());
        ps.setString(33, fgfilemaster.getPurposeCode());
        ps.setString(34, fgfilemaster.getDisplayStatus());
        Integer val35 = fgfilemaster.getLayoutTemplateID();
        if (val35 != null) {
            ps.setInt(35, val35);
        } else {
            ps.setNull(35, Types.INTEGER);
        }
        ps.setString(36, fgfilemaster.getLayoutName());
        Integer val37 = fgfilemaster.getLayoutTemplateVersionID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        Integer val38 = fgfilemaster.getUploadRefID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
    }

    private FgFileMaster extract(ResultSet rs) throws SQLException {
        FgFileMaster fgfilemaster = new FgFileMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgfilemaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgfilemaster.setReferenceID(REFERENCE_ID);
        fgfilemaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgfilemaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgfilemaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgfilemaster.setStageCode(rs.getString(COL_STAGE_CODE));
        fgfilemaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgfilemaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgfilemaster.setCreatedBy(CREATED_BY);
        fgfilemaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgfilemaster.setLastUpdatedBy(LAST_UPDATED_BY);
        fgfilemaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgfilemaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgfilemaster.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgfilemaster.setIsTemplate(IS_TEMPLATE);
        fgfilemaster.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        fgfilemaster.setFileName(rs.getString(COL_FILE_NAME));
        fgfilemaster.setFileAttachRefNo(rs.getString(COL_FILE_ATTACH_REF_NO));
        fgfilemaster.setFileStatus(rs.getString(COL_FILE_STATUS));
        fgfilemaster.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal LINE_COUNT = rs.getObject(COL_LINE_COUNT, java.math.BigDecimal.class);
        fgfilemaster.setLineCount(LINE_COUNT);
        java.math.BigDecimal TXN_COUNT = rs.getObject(COL_TXN_COUNT, java.math.BigDecimal.class);
        fgfilemaster.setTxnCount(TXN_COUNT);
        java.math.BigDecimal TXN_VAL_SUCCESS_CNT = rs.getObject(COL_TXN_VAL_SUCCESS_CNT, java.math.BigDecimal.class);
        fgfilemaster.setTxnValSuccessCnt(TXN_VAL_SUCCESS_CNT);
        java.math.BigDecimal TXN_LISTING_CNT = rs.getObject(COL_TXN_LISTING_CNT, java.math.BigDecimal.class);
        fgfilemaster.setTxnListingCnt(TXN_LISTING_CNT);
        java.math.BigDecimal TXN_LISTING_ACK_CNT = rs.getObject(COL_TXN_LISTING_ACK_CNT, java.math.BigDecimal.class);
        fgfilemaster.setTxnListingAckCnt(TXN_LISTING_ACK_CNT);
        java.math.BigDecimal FINPAY_REQ_CNT = rs.getObject(COL_FINPAY_REQ_CNT, java.math.BigDecimal.class);
        fgfilemaster.setFinpayReqCnt(FINPAY_REQ_CNT);
        java.math.BigDecimal INTEGRITY_SUCCESS_CNT = rs.getObject(COL_INTEGRITY_SUCCESS_CNT, java.math.BigDecimal.class);
        fgfilemaster.setIntegritySuccessCnt(INTEGRITY_SUCCESS_CNT);
        fgfilemaster.setStagestatus(rs.getString(COL_STAGESTATUS));
        java.math.BigDecimal FINPAY_RESP_CNT = rs.getObject(COL_FINPAY_RESP_CNT, java.math.BigDecimal.class);
        fgfilemaster.setFinpayRespCnt(FINPAY_RESP_CNT);
        fgfilemaster.setAnchorName(rs.getString(COL_ANCHOR_NAME));
        fgfilemaster.setDisplayFileName(rs.getString(COL_DISPLAY_FILE_NAME));
        fgfilemaster.setHashKey(rs.getString(COL_HASH_KEY));
        fgfilemaster.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgfilemaster.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        Integer LAYOUT_TEMPLATE_ID = rs.getObject(COL_LAYOUT_TEMPLATE_ID, Integer.class);
        fgfilemaster.setLayoutTemplateID(LAYOUT_TEMPLATE_ID);
        fgfilemaster.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer LAYOUT_TEMPLATE_VERSION_ID = rs.getObject(COL_LAYOUT_TEMPLATE_VERSION_ID, Integer.class);
        fgfilemaster.setLayoutTemplateVersionID(LAYOUT_TEMPLATE_VERSION_ID);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgfilemaster.setUploadRefID(UPLOAD_REF_ID);
        return fgfilemaster;
    }
}
