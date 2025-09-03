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

public class JdbcFgTrdFtViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdFtViewDao.class);

    private static final String TABLE = "FG_TRD_FT_VIEW";

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

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_LODGE_DATE = "LODGE_DATE";

    private static final String COL_DRAWEE = "DRAWEE";

    private static final String COL_OUTSTANDING_AMT = "OUTSTANDING_AMT";

    private static final String COL_OUTSTANDING_AMT_SETTLED = "OUTSTANDING_AMT_SETTLED";

    private static final String COL_DSP_AMT = "DSP_AMT";

    private static final String COL_DEDUCTION = "DEDUCTION";

    private static final String COL_REASON = "REASON";

    private static final String COL_OCF_REF_ID = "OCF_REF_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUR_CODE, COL_LODGE_DATE, COL_DRAWEE, COL_OUTSTANDING_AMT, COL_OUTSTANDING_AMT_SETTLED, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_OCF_REF_ID, COL_APPLICANT_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, OCF_REF_ID, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, OCF_REF_ID, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUR_CODE, COL_LODGE_DATE, COL_DRAWEE, COL_OUTSTANDING_AMT, COL_OUTSTANDING_AMT_SETTLED, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_OCF_REF_ID, COL_APPLICANT_PARTY, COL_ID);

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

    public int insert(Connection conn, FgTrdFtView fgtrdftview) throws SQLException {
        logger.debug("Inserting fgtrdftview: {}", fgtrdftview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdFtViewParams(ps, fgtrdftview);
            ps.executeUpdate();
            return fgtrdftview.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdFtView> fgtrdftviews) throws SQLException {
        if (fgtrdftviews == null || fgtrdftviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdftviews.size(); i++) {
            if (fgtrdftviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdFtView>> batches = chunkList(fgtrdftviews, batchSize);
        int[] totalResults = new int[fgtrdftviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdFtView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdFtView fgtrdftview : batch) {
                        setFgTrdFtViewParams(ps, fgtrdftview);
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

    public FgTrdFtView findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdFtView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdFtView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdFtView fgtrdftview) throws SQLException {
        if (fgtrdftview.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdFtViewParams(ps, fgtrdftview);
            ps.setInt(25, fgtrdftview.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdFtView> fgtrdftviews) throws SQLException {
        if (fgtrdftviews == null || fgtrdftviews.isEmpty())
            return new int[0];
        for (FgTrdFtView fgtrdftview : fgtrdftviews) {
            if (fgtrdftview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdftview.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdFtView>> batches = chunkList(fgtrdftviews, batchSize);
        int[] totalResults = new int[fgtrdftviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdFtView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdFtView fgtrdftview : batch) {
                        setFgTrdFtViewParams(ps, fgtrdftview);
                        ps.setInt(25, fgtrdftview.getID());
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

    private void setFgTrdFtViewParams(PreparedStatement ps, FgTrdFtView fgtrdftview) throws SQLException {
        Integer val1 = fgtrdftview.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdftview.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdftview.getTypeCode());
        ps.setString(4, fgtrdftview.getSubTypeCode());
        ps.setString(5, fgtrdftview.getActiveCode());
        ps.setString(6, fgtrdftview.getStageCode());
        ps.setString(7, fgtrdftview.getStatusCode());
        ps.setString(8, fgtrdftview.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdftview.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdftview.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdftview.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdftview.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdftview.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdftview.getTemplate());
        java.math.BigDecimal val15 = fgtrdftview.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdftview.getCurCode());
        java.time.LocalDateTime val17 = fgtrdftview.getLodgeDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrdftview.getDrawee());
        java.math.BigDecimal val19 = fgtrdftview.getOutstandingAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtrdftview.getOutstandingAmtSettled();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdftview.getDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdftview.getDeduction();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgtrdftview.getReason());
        Integer val24 = fgtrdftview.getOcfRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        ps.setString(25, fgtrdftview.getApplicantParty());
    }

    private FgTrdFtView extract(ResultSet rs) throws SQLException {
        FgTrdFtView fgtrdftview = new FgTrdFtView();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdftview.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdftview.setReferenceID(REFERENCE_ID);
        fgtrdftview.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdftview.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdftview.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdftview.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdftview.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdftview.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdftview.setCreatedBy(CREATED_BY);
        fgtrdftview.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdftview.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdftview.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdftview.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdftview.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdftview.setIsTemplate(IS_TEMPLATE);
        fgtrdftview.setCurCode(rs.getString(COL_CUR_CODE));
        Timestamp LODGE_DATE = rs.getTimestamp(COL_LODGE_DATE);
        if (LODGE_DATE != null)
            fgtrdftview.setLodgeDate(LODGE_DATE.toLocalDateTime());
        fgtrdftview.setDrawee(rs.getString(COL_DRAWEE));
        java.math.BigDecimal OUTSTANDING_AMT = rs.getObject(COL_OUTSTANDING_AMT, java.math.BigDecimal.class);
        fgtrdftview.setOutstandingAmt(OUTSTANDING_AMT);
        java.math.BigDecimal OUTSTANDING_AMT_SETTLED = rs.getObject(COL_OUTSTANDING_AMT_SETTLED, java.math.BigDecimal.class);
        fgtrdftview.setOutstandingAmtSettled(OUTSTANDING_AMT_SETTLED);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdftview.setDspAmt(DSP_AMT);
        java.math.BigDecimal DEDUCTION = rs.getObject(COL_DEDUCTION, java.math.BigDecimal.class);
        fgtrdftview.setDeduction(DEDUCTION);
        fgtrdftview.setReason(rs.getString(COL_REASON));
        Integer OCF_REF_ID = rs.getObject(COL_OCF_REF_ID, Integer.class);
        fgtrdftview.setOcfRefID(OCF_REF_ID);
        fgtrdftview.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        return fgtrdftview;
    }
}
