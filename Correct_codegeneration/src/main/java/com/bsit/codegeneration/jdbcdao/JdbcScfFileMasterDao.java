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

public class JdbcScfFileMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfFileMasterDao.class);

    private static final String TABLE = "SCF_FILE_MASTER";

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

    private static final String COL_FULLFILMENT_PARTY = "FULLFILMENT_PARTY";

    private static final String COL_SOURCE_OF_CREATION = "SOURCE_OF_CREATION";

    private static final String COL_NUMBER_OF_FIELDS = "NUMBER_OF_FIELDS";

    private static final String COL_FINTECH_SOURCE = "FINTECH_SOURCE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_ATTACH_REF_NO, COL_FILE_STATUS, COL_REMARKS, COL_LINE_COUNT, COL_TXN_COUNT, COL_TXN_VAL_SUCCESS_CNT, COL_TXN_LISTING_CNT, COL_TXN_LISTING_ACK_CNT, COL_FINPAY_REQ_CNT, COL_INTEGRITY_SUCCESS_CNT, COL_STAGESTATUS, COL_FINPAY_RESP_CNT, COL_ANCHOR_NAME, COL_DISPLAY_FILE_NAME, COL_HASH_KEY, COL_PURPOSE_CODE, COL_DISPLAY_STATUS, COL_FULLFILMENT_PARTY, COL_SOURCE_OF_CREATION, COL_NUMBER_OF_FIELDS, COL_FINTECH_SOURCE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, FULLFILMENT_PARTY, SOURCE_OF_CREATION, NUMBER_OF_FIELDS, FINTECH_SOURCE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, FULLFILMENT_PARTY, SOURCE_OF_CREATION, NUMBER_OF_FIELDS, FINTECH_SOURCE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ANCHOR_CRN, COL_FILE_NAME, COL_FILE_ATTACH_REF_NO, COL_FILE_STATUS, COL_REMARKS, COL_LINE_COUNT, COL_TXN_COUNT, COL_TXN_VAL_SUCCESS_CNT, COL_TXN_LISTING_CNT, COL_TXN_LISTING_ACK_CNT, COL_FINPAY_REQ_CNT, COL_INTEGRITY_SUCCESS_CNT, COL_STAGESTATUS, COL_FINPAY_RESP_CNT, COL_ANCHOR_NAME, COL_DISPLAY_FILE_NAME, COL_HASH_KEY, COL_PURPOSE_CODE, COL_DISPLAY_STATUS, COL_FULLFILMENT_PARTY, COL_SOURCE_OF_CREATION, COL_NUMBER_OF_FIELDS, COL_FINTECH_SOURCE, COL_ID);

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

    public int insert(Connection conn, ScfFileMaster scffilemaster) throws SQLException {
        logger.debug("Inserting scffilemaster: {}", scffilemaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfFileMasterParams(ps, scffilemaster);
            ps.executeUpdate();
            return scffilemaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfFileMaster> scffilemasters) throws SQLException {
        if (scffilemasters == null || scffilemasters.isEmpty())
            return new int[0];
        for (int i = 0; i < scffilemasters.size(); i++) {
            if (scffilemasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileMaster>> batches = chunkList(scffilemasters, batchSize);
        int[] totalResults = new int[scffilemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfFileMaster scffilemaster : batch) {
                        setScfFileMasterParams(ps, scffilemaster);
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

    public ScfFileMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfFileMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfFileMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfFileMaster scffilemaster) throws SQLException {
        if (scffilemaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfFileMasterParams(ps, scffilemaster);
            ps.setInt(38, scffilemaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfFileMaster> scffilemasters) throws SQLException {
        if (scffilemasters == null || scffilemasters.isEmpty())
            return new int[0];
        for (ScfFileMaster scffilemaster : scffilemasters) {
            if (scffilemaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scffilemaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfFileMaster>> batches = chunkList(scffilemasters, batchSize);
        int[] totalResults = new int[scffilemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfFileMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfFileMaster scffilemaster : batch) {
                        setScfFileMasterParams(ps, scffilemaster);
                        ps.setInt(38, scffilemaster.getID());
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

    private void setScfFileMasterParams(PreparedStatement ps, ScfFileMaster scffilemaster) throws SQLException {
        Integer val1 = scffilemaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scffilemaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scffilemaster.getTypeCode());
        ps.setString(4, scffilemaster.getSubTypeCode());
        ps.setString(5, scffilemaster.getActiveCode());
        ps.setString(6, scffilemaster.getStageCode());
        ps.setString(7, scffilemaster.getStatusCode());
        ps.setString(8, scffilemaster.getCreatedOn());
        java.math.BigDecimal val9 = scffilemaster.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scffilemaster.getLastUpdatedOn());
        java.math.BigDecimal val11 = scffilemaster.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scffilemaster.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scffilemaster.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scffilemaster.getTemplate());
        java.math.BigDecimal val15 = scffilemaster.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, scffilemaster.getAnchorCrn());
        ps.setString(17, scffilemaster.getFileName());
        ps.setString(18, scffilemaster.getFileAttachRefNo());
        ps.setString(19, scffilemaster.getFileStatus());
        ps.setString(20, scffilemaster.getRemarks());
        java.math.BigDecimal val21 = scffilemaster.getLineCount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = scffilemaster.getTxnCount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = scffilemaster.getTxnValSuccessCnt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = scffilemaster.getTxnListingCnt();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = scffilemaster.getTxnListingAckCnt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = scffilemaster.getFinpayReqCnt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.math.BigDecimal val27 = scffilemaster.getIntegritySuccessCnt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, scffilemaster.getStagestatus());
        java.math.BigDecimal val29 = scffilemaster.getFinpayRespCnt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, scffilemaster.getAnchorName());
        ps.setString(31, scffilemaster.getDisplayFileName());
        ps.setString(32, scffilemaster.getHashKey());
        ps.setString(33, scffilemaster.getPurposeCode());
        ps.setString(34, scffilemaster.getDisplayStatus());
        ps.setString(35, scffilemaster.getFullfilmentParty());
        ps.setString(36, scffilemaster.getSourceOfCreation());
        ps.setString(37, scffilemaster.getNumberOfFields());
        ps.setString(38, scffilemaster.getFintechSource());
    }

    private ScfFileMaster extract(ResultSet rs) throws SQLException {
        ScfFileMaster scffilemaster = new ScfFileMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scffilemaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scffilemaster.setReferenceID(REFERENCE_ID);
        scffilemaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        scffilemaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scffilemaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scffilemaster.setStageCode(rs.getString(COL_STAGE_CODE));
        scffilemaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        scffilemaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scffilemaster.setCreatedBy(CREATED_BY);
        scffilemaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scffilemaster.setLastUpdatedBy(LAST_UPDATED_BY);
        scffilemaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scffilemaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scffilemaster.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scffilemaster.setIsTemplate(IS_TEMPLATE);
        scffilemaster.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scffilemaster.setFileName(rs.getString(COL_FILE_NAME));
        scffilemaster.setFileAttachRefNo(rs.getString(COL_FILE_ATTACH_REF_NO));
        scffilemaster.setFileStatus(rs.getString(COL_FILE_STATUS));
        scffilemaster.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal LINE_COUNT = rs.getObject(COL_LINE_COUNT, java.math.BigDecimal.class);
        scffilemaster.setLineCount(LINE_COUNT);
        java.math.BigDecimal TXN_COUNT = rs.getObject(COL_TXN_COUNT, java.math.BigDecimal.class);
        scffilemaster.setTxnCount(TXN_COUNT);
        java.math.BigDecimal TXN_VAL_SUCCESS_CNT = rs.getObject(COL_TXN_VAL_SUCCESS_CNT, java.math.BigDecimal.class);
        scffilemaster.setTxnValSuccessCnt(TXN_VAL_SUCCESS_CNT);
        java.math.BigDecimal TXN_LISTING_CNT = rs.getObject(COL_TXN_LISTING_CNT, java.math.BigDecimal.class);
        scffilemaster.setTxnListingCnt(TXN_LISTING_CNT);
        java.math.BigDecimal TXN_LISTING_ACK_CNT = rs.getObject(COL_TXN_LISTING_ACK_CNT, java.math.BigDecimal.class);
        scffilemaster.setTxnListingAckCnt(TXN_LISTING_ACK_CNT);
        java.math.BigDecimal FINPAY_REQ_CNT = rs.getObject(COL_FINPAY_REQ_CNT, java.math.BigDecimal.class);
        scffilemaster.setFinpayReqCnt(FINPAY_REQ_CNT);
        java.math.BigDecimal INTEGRITY_SUCCESS_CNT = rs.getObject(COL_INTEGRITY_SUCCESS_CNT, java.math.BigDecimal.class);
        scffilemaster.setIntegritySuccessCnt(INTEGRITY_SUCCESS_CNT);
        scffilemaster.setStagestatus(rs.getString(COL_STAGESTATUS));
        java.math.BigDecimal FINPAY_RESP_CNT = rs.getObject(COL_FINPAY_RESP_CNT, java.math.BigDecimal.class);
        scffilemaster.setFinpayRespCnt(FINPAY_RESP_CNT);
        scffilemaster.setAnchorName(rs.getString(COL_ANCHOR_NAME));
        scffilemaster.setDisplayFileName(rs.getString(COL_DISPLAY_FILE_NAME));
        scffilemaster.setHashKey(rs.getString(COL_HASH_KEY));
        scffilemaster.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        scffilemaster.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        scffilemaster.setFullfilmentParty(rs.getString(COL_FULLFILMENT_PARTY));
        scffilemaster.setSourceOfCreation(rs.getString(COL_SOURCE_OF_CREATION));
        scffilemaster.setNumberOfFields(rs.getString(COL_NUMBER_OF_FIELDS));
        scffilemaster.setFintechSource(rs.getString(COL_FINTECH_SOURCE));
        return scffilemaster;
    }
}
