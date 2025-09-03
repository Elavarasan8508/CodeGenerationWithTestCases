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

public class JdbcFgEdpmsIrmReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEdpmsIrmReqDao.class);

    private static final String TABLE = "FG_EDPMS_IRM_REQ";

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

    private static final String COL_IRM_NO = "IRM_NO";

    private static final String COL_IRM_AD = "IRM_AD";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_OS_AMT_IRM = "OS_AMT_IRM";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_IE_CODE_IRM = "IE_CODE_IRM";

    private static final String COL_IRM_DATE = "IRM_DATE";

    private static final String COL_IRM_UTIL_AMT = "IRM_UTIL_AMT";

    private static final String COL_REMIT_NAME = "REMIT_NAME";

    private static final String COL_REMIT_COUNTRY = "REMIT_COUNTRY";

    private static final String COL_REMIT_BANK_NAME = "REMIT_BANK_NAME";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String COL_SWIFT_OTHER_BANK_REF = "SWIFT_OTHER_BANK_REF";

    private static final String COL_PUR_OF_REMIT = "PUR_OF_REMIT";

    private static final String COL_AMT_UTIL = "AMT_UTIL";

    private static final String COL_EXT_DATE_IRM = "EXT_DATE_IRM";

    private static final String COL_REMARKS_IRME = "REMARKS_IRME";

    private static final String COL_IRM_ADJ_NO = "IRM_ADJ_NO";

    private static final String COL_BANK_REF_NO = "BANK_REF_NO";

    private static final String COL_ADJ_AMT_IRM = "ADJ_AMT_IRM";

    private static final String COL_REMARKS_IRMA = "REMARKS_IRMA";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_TRRACS_ERROR_CODE = "TRRACS_ERROR_CODE";

    private static final String COL_TRRACS_ERROR_DECS = "TRRACS_ERROR_DECS";

    private static final String COL_TRRACS_STATUS = "TRRACS_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_OS_AMT_IRM, COL_IRM_CCY, COL_IE_CODE_IRM, COL_IRM_DATE, COL_IRM_UTIL_AMT, COL_REMIT_NAME, COL_REMIT_COUNTRY, COL_REMIT_BANK_NAME, COL_REMIT_BANK_COUNTRY, COL_SWIFT_OTHER_BANK_REF, COL_PUR_OF_REMIT, COL_AMT_UTIL, COL_EXT_DATE_IRM, COL_REMARKS_IRME, COL_IRM_ADJ_NO, COL_BANK_REF_NO, COL_ADJ_AMT_IRM, COL_REMARKS_IRMA, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DECS, COL_TRRACS_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, IE_CODE_IRM, IRM_DATE, IRM_UTIL_AMT, REMIT_NAME, REMIT_COUNTRY, REMIT_BANK_NAME, REMIT_BANK_COUNTRY, SWIFT_OTHER_BANK_REF, PUR_OF_REMIT, AMT_UTIL, EXT_DATE_IRM, REMARKS_IRME, IRM_ADJ_NO, BANK_REF_NO, ADJ_AMT_IRM, REMARKS_IRMA, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, TRRACS_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, IE_CODE_IRM, IRM_DATE, IRM_UTIL_AMT, REMIT_NAME, REMIT_COUNTRY, REMIT_BANK_NAME, REMIT_BANK_COUNTRY, SWIFT_OTHER_BANK_REF, PUR_OF_REMIT, AMT_UTIL, EXT_DATE_IRM, REMARKS_IRME, IRM_ADJ_NO, BANK_REF_NO, ADJ_AMT_IRM, REMARKS_IRMA, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, TRRACS_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_OS_AMT_IRM, COL_IRM_CCY, COL_IE_CODE_IRM, COL_IRM_DATE, COL_IRM_UTIL_AMT, COL_REMIT_NAME, COL_REMIT_COUNTRY, COL_REMIT_BANK_NAME, COL_REMIT_BANK_COUNTRY, COL_SWIFT_OTHER_BANK_REF, COL_PUR_OF_REMIT, COL_AMT_UTIL, COL_EXT_DATE_IRM, COL_REMARKS_IRME, COL_IRM_ADJ_NO, COL_BANK_REF_NO, COL_ADJ_AMT_IRM, COL_REMARKS_IRMA, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_TRRACS_ERROR_CODE, COL_TRRACS_ERROR_DECS, COL_TRRACS_STATUS, COL_ID);

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

    public int insert(Connection conn, FgEdpmsIrmReq fgedpmsirmreq) throws SQLException {
        logger.debug("Inserting fgedpmsirmreq: {}", fgedpmsirmreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEdpmsIrmReqParams(ps, fgedpmsirmreq);
            ps.executeUpdate();
            return fgedpmsirmreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEdpmsIrmReq> fgedpmsirmreqs) throws SQLException {
        if (fgedpmsirmreqs == null || fgedpmsirmreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgedpmsirmreqs.size(); i++) {
            if (fgedpmsirmreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsIrmReq>> batches = chunkList(fgedpmsirmreqs, batchSize);
        int[] totalResults = new int[fgedpmsirmreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsIrmReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEdpmsIrmReq fgedpmsirmreq : batch) {
                        setFgEdpmsIrmReqParams(ps, fgedpmsirmreq);
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

    public FgEdpmsIrmReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEdpmsIrmReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEdpmsIrmReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEdpmsIrmReq fgedpmsirmreq) throws SQLException {
        if (fgedpmsirmreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEdpmsIrmReqParams(ps, fgedpmsirmreq);
            ps.setInt(41, fgedpmsirmreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEdpmsIrmReq> fgedpmsirmreqs) throws SQLException {
        if (fgedpmsirmreqs == null || fgedpmsirmreqs.isEmpty())
            return new int[0];
        for (FgEdpmsIrmReq fgedpmsirmreq : fgedpmsirmreqs) {
            if (fgedpmsirmreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgedpmsirmreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsIrmReq>> batches = chunkList(fgedpmsirmreqs, batchSize);
        int[] totalResults = new int[fgedpmsirmreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsIrmReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEdpmsIrmReq fgedpmsirmreq : batch) {
                        setFgEdpmsIrmReqParams(ps, fgedpmsirmreq);
                        ps.setInt(41, fgedpmsirmreq.getID());
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

    private void setFgEdpmsIrmReqParams(PreparedStatement ps, FgEdpmsIrmReq fgedpmsirmreq) throws SQLException {
        Integer val1 = fgedpmsirmreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgedpmsirmreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgedpmsirmreq.getTypeCode());
        ps.setString(4, fgedpmsirmreq.getSubTypeCode());
        ps.setString(5, fgedpmsirmreq.getActiveCode());
        ps.setString(6, fgedpmsirmreq.getStageCode());
        ps.setString(7, fgedpmsirmreq.getStatusCode());
        ps.setString(8, fgedpmsirmreq.getCreatedOn());
        java.math.BigDecimal val9 = fgedpmsirmreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgedpmsirmreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgedpmsirmreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgedpmsirmreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgedpmsirmreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgedpmsirmreq.getTemplate());
        java.math.BigDecimal val15 = fgedpmsirmreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgedpmsirmreq.getIrmNo());
        ps.setString(17, fgedpmsirmreq.getIrmAd());
        java.math.BigDecimal val18 = fgedpmsirmreq.getIrmAmt();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgedpmsirmreq.getOsAmtIrm();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgedpmsirmreq.getIrmCcy());
        ps.setString(21, fgedpmsirmreq.getIeCodeIrm());
        java.time.LocalDateTime val22 = fgedpmsirmreq.getIrmDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = fgedpmsirmreq.getIrmUtilAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgedpmsirmreq.getRemitName());
        ps.setString(25, fgedpmsirmreq.getRemitCountry());
        ps.setString(26, fgedpmsirmreq.getRemitBankName());
        ps.setString(27, fgedpmsirmreq.getRemitBankCountry());
        ps.setString(28, fgedpmsirmreq.getSwiftOtherBankRef());
        ps.setString(29, fgedpmsirmreq.getPurOfRemit());
        java.math.BigDecimal val30 = fgedpmsirmreq.getAmtUtil();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        java.time.LocalDateTime val31 = fgedpmsirmreq.getExtDateIrm();
        if (val31 != null) {
            ps.setTimestamp(31, java.sql.Timestamp.valueOf(val31));
        } else {
            ps.setNull(31, Types.TIMESTAMP);
        }
        ps.setString(32, fgedpmsirmreq.getRemarksIrme());
        ps.setString(33, fgedpmsirmreq.getIrmAdjNo());
        ps.setString(34, fgedpmsirmreq.getBankRefNo());
        java.math.BigDecimal val35 = fgedpmsirmreq.getAdjAmtIrm();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgedpmsirmreq.getRemarksIrma());
        Integer val37 = fgedpmsirmreq.getParentRefID();
        if (val37 != null) {
            ps.setInt(37, val37);
        } else {
            ps.setNull(37, Types.INTEGER);
        }
        Integer val38 = fgedpmsirmreq.getParentVersionID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
        ps.setString(39, fgedpmsirmreq.getTrracsErrorCode());
        ps.setString(40, fgedpmsirmreq.getTrracsErrorDecs());
        ps.setString(41, fgedpmsirmreq.getTrracsStatus());
    }

    private FgEdpmsIrmReq extract(ResultSet rs) throws SQLException {
        FgEdpmsIrmReq fgedpmsirmreq = new FgEdpmsIrmReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgedpmsirmreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgedpmsirmreq.setReferenceID(REFERENCE_ID);
        fgedpmsirmreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgedpmsirmreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgedpmsirmreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgedpmsirmreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgedpmsirmreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgedpmsirmreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgedpmsirmreq.setCreatedBy(CREATED_BY);
        fgedpmsirmreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgedpmsirmreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgedpmsirmreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgedpmsirmreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgedpmsirmreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgedpmsirmreq.setIsTemplate(IS_TEMPLATE);
        fgedpmsirmreq.setIrmNo(rs.getString(COL_IRM_NO));
        fgedpmsirmreq.setIrmAd(rs.getString(COL_IRM_AD));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgedpmsirmreq.setIrmAmt(IRM_AMT);
        java.math.BigDecimal OS_AMT_IRM = rs.getObject(COL_OS_AMT_IRM, java.math.BigDecimal.class);
        fgedpmsirmreq.setOsAmtIrm(OS_AMT_IRM);
        fgedpmsirmreq.setIrmCcy(rs.getString(COL_IRM_CCY));
        fgedpmsirmreq.setIeCodeIrm(rs.getString(COL_IE_CODE_IRM));
        Timestamp IRM_DATE = rs.getTimestamp(COL_IRM_DATE);
        if (IRM_DATE != null)
            fgedpmsirmreq.setIrmDate(IRM_DATE.toLocalDateTime());
        java.math.BigDecimal IRM_UTIL_AMT = rs.getObject(COL_IRM_UTIL_AMT, java.math.BigDecimal.class);
        fgedpmsirmreq.setIrmUtilAmt(IRM_UTIL_AMT);
        fgedpmsirmreq.setRemitName(rs.getString(COL_REMIT_NAME));
        fgedpmsirmreq.setRemitCountry(rs.getString(COL_REMIT_COUNTRY));
        fgedpmsirmreq.setRemitBankName(rs.getString(COL_REMIT_BANK_NAME));
        fgedpmsirmreq.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        fgedpmsirmreq.setSwiftOtherBankRef(rs.getString(COL_SWIFT_OTHER_BANK_REF));
        fgedpmsirmreq.setPurOfRemit(rs.getString(COL_PUR_OF_REMIT));
        java.math.BigDecimal AMT_UTIL = rs.getObject(COL_AMT_UTIL, java.math.BigDecimal.class);
        fgedpmsirmreq.setAmtUtil(AMT_UTIL);
        Timestamp EXT_DATE_IRM = rs.getTimestamp(COL_EXT_DATE_IRM);
        if (EXT_DATE_IRM != null)
            fgedpmsirmreq.setExtDateIrm(EXT_DATE_IRM.toLocalDateTime());
        fgedpmsirmreq.setRemarksIrme(rs.getString(COL_REMARKS_IRME));
        fgedpmsirmreq.setIrmAdjNo(rs.getString(COL_IRM_ADJ_NO));
        fgedpmsirmreq.setBankRefNo(rs.getString(COL_BANK_REF_NO));
        java.math.BigDecimal ADJ_AMT_IRM = rs.getObject(COL_ADJ_AMT_IRM, java.math.BigDecimal.class);
        fgedpmsirmreq.setAdjAmtIrm(ADJ_AMT_IRM);
        fgedpmsirmreq.setRemarksIrma(rs.getString(COL_REMARKS_IRMA));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgedpmsirmreq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgedpmsirmreq.setParentVersionID(PARENT_VERSION_ID);
        fgedpmsirmreq.setTrracsErrorCode(rs.getString(COL_TRRACS_ERROR_CODE));
        fgedpmsirmreq.setTrracsErrorDecs(rs.getString(COL_TRRACS_ERROR_DECS));
        fgedpmsirmreq.setTrracsStatus(rs.getString(COL_TRRACS_STATUS));
        return fgedpmsirmreq;
    }
}
