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

public class JdbcFgTrdElcViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdElcViewDao.class);

    private static final String TABLE = "FG_TRD_ELC_VIEW";

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

    private static final String COL_KOTAK_BILL_REF_ID = "KOTAK_BILL_REF_ID";

    private static final String COL_ISS_BANK_LC_REF_ID = "ISS_BANK_LC_REF_ID";

    private static final String COL_TENOR = "TENOR";

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_LODGE_DATE = "LODGE_DATE";

    private static final String COL_OUTSTANDING_AMT = "OUTSTANDING_AMT";

    private static final String COL_DSP_AMT = "DSP_AMT";

    private static final String COL_DEDUCTION = "DEDUCTION";

    private static final String COL_REASON = "REASON";

    private static final String COL_APPLICANT_NAME = "APPLICANT_NAME";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_KOTAK_BILL_REF_ID, COL_ISS_BANK_LC_REF_ID, COL_TENOR, COL_CUR_CODE, COL_LODGE_DATE, COL_OUTSTANDING_AMT, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_APPLICANT_NAME, COL_APPLICANT_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, APPLICANT_NAME, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, APPLICANT_NAME, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_KOTAK_BILL_REF_ID, COL_ISS_BANK_LC_REF_ID, COL_TENOR, COL_CUR_CODE, COL_LODGE_DATE, COL_OUTSTANDING_AMT, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_APPLICANT_NAME, COL_APPLICANT_PARTY, COL_ID);

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

    public int insert(Connection conn, FgTrdElcView fgtrdelcview) throws SQLException {
        logger.debug("Inserting fgtrdelcview: {}", fgtrdelcview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdElcViewParams(ps, fgtrdelcview);
            ps.executeUpdate();
            return fgtrdelcview.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdElcView> fgtrdelcviews) throws SQLException {
        if (fgtrdelcviews == null || fgtrdelcviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdelcviews.size(); i++) {
            if (fgtrdelcviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdElcView>> batches = chunkList(fgtrdelcviews, batchSize);
        int[] totalResults = new int[fgtrdelcviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdElcView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdElcView fgtrdelcview : batch) {
                        setFgTrdElcViewParams(ps, fgtrdelcview);
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

    public FgTrdElcView findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdElcView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdElcView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdElcView fgtrdelcview) throws SQLException {
        if (fgtrdelcview.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdElcViewParams(ps, fgtrdelcview);
            ps.setInt(26, fgtrdelcview.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdElcView> fgtrdelcviews) throws SQLException {
        if (fgtrdelcviews == null || fgtrdelcviews.isEmpty())
            return new int[0];
        for (FgTrdElcView fgtrdelcview : fgtrdelcviews) {
            if (fgtrdelcview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdelcview.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdElcView>> batches = chunkList(fgtrdelcviews, batchSize);
        int[] totalResults = new int[fgtrdelcviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdElcView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdElcView fgtrdelcview : batch) {
                        setFgTrdElcViewParams(ps, fgtrdelcview);
                        ps.setInt(26, fgtrdelcview.getID());
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

    private void setFgTrdElcViewParams(PreparedStatement ps, FgTrdElcView fgtrdelcview) throws SQLException {
        Integer val1 = fgtrdelcview.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdelcview.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdelcview.getTypeCode());
        ps.setString(4, fgtrdelcview.getSubTypeCode());
        ps.setString(5, fgtrdelcview.getActiveCode());
        ps.setString(6, fgtrdelcview.getStageCode());
        ps.setString(7, fgtrdelcview.getStatusCode());
        ps.setString(8, fgtrdelcview.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdelcview.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdelcview.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdelcview.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdelcview.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdelcview.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdelcview.getTemplate());
        java.math.BigDecimal val15 = fgtrdelcview.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdelcview.getKotakBillRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgtrdelcview.getIssBankLcRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        ps.setString(18, fgtrdelcview.getTenor());
        ps.setString(19, fgtrdelcview.getCurCode());
        java.time.LocalDateTime val20 = fgtrdelcview.getLodgeDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        java.math.BigDecimal val21 = fgtrdelcview.getOutstandingAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdelcview.getDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtrdelcview.getDeduction();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgtrdelcview.getReason());
        ps.setString(25, fgtrdelcview.getApplicantName());
        ps.setString(26, fgtrdelcview.getApplicantParty());
    }

    private FgTrdElcView extract(ResultSet rs) throws SQLException {
        FgTrdElcView fgtrdelcview = new FgTrdElcView();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdelcview.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdelcview.setReferenceID(REFERENCE_ID);
        fgtrdelcview.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdelcview.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdelcview.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdelcview.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdelcview.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdelcview.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdelcview.setCreatedBy(CREATED_BY);
        fgtrdelcview.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdelcview.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdelcview.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdelcview.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdelcview.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdelcview.setIsTemplate(IS_TEMPLATE);
        Integer KOTAK_BILL_REF_ID = rs.getObject(COL_KOTAK_BILL_REF_ID, Integer.class);
        fgtrdelcview.setKotakBillRefID(KOTAK_BILL_REF_ID);
        Integer ISS_BANK_LC_REF_ID = rs.getObject(COL_ISS_BANK_LC_REF_ID, Integer.class);
        fgtrdelcview.setIssBankLcRefID(ISS_BANK_LC_REF_ID);
        fgtrdelcview.setTenor(rs.getString(COL_TENOR));
        fgtrdelcview.setCurCode(rs.getString(COL_CUR_CODE));
        Timestamp LODGE_DATE = rs.getTimestamp(COL_LODGE_DATE);
        if (LODGE_DATE != null)
            fgtrdelcview.setLodgeDate(LODGE_DATE.toLocalDateTime());
        java.math.BigDecimal OUTSTANDING_AMT = rs.getObject(COL_OUTSTANDING_AMT, java.math.BigDecimal.class);
        fgtrdelcview.setOutstandingAmt(OUTSTANDING_AMT);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdelcview.setDspAmt(DSP_AMT);
        java.math.BigDecimal DEDUCTION = rs.getObject(COL_DEDUCTION, java.math.BigDecimal.class);
        fgtrdelcview.setDeduction(DEDUCTION);
        fgtrdelcview.setReason(rs.getString(COL_REASON));
        fgtrdelcview.setApplicantName(rs.getString(COL_APPLICANT_NAME));
        fgtrdelcview.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        return fgtrdelcview;
    }
}
