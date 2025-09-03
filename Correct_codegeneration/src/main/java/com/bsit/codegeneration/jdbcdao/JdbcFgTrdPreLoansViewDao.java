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

public class JdbcFgTrdPreLoansViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdPreLoansViewDao.class);

    private static final String TABLE = "FG_TRD_PRE_LOANS_VIEW";

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

    private static final String COL_PRE_LOAN_REF_ID = "PRE_LOAN_REF_ID";

    private static final String COL_LOAN_REF_ID = "LOAN_REF_ID";

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_PRINCIPAL_OUTSTANDING = "PRINCIPAL_OUTSTANDING";

    private static final String COL_IN_LOAN_CUR = "IN_LOAN_CUR";

    private static final String COL_DSP_AMT = "DSP_AMT";

    private static final String COL_EQU_DSP_AMT = "EQU_DSP_AMT";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_DISB_DATE = "DISB_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PRE_LOAN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_IN_LOAN_CUR, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_APPLICANT_PARTY, COL_DISB_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY, DISB_DATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY, DISB_DATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PRE_LOAN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_IN_LOAN_CUR, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_APPLICANT_PARTY, COL_DISB_DATE, COL_ID);

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

    public int insert(Connection conn, FgTrdPreLoansView fgtrdpreloansview) throws SQLException {
        logger.debug("Inserting fgtrdpreloansview: {}", fgtrdpreloansview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdPreLoansViewParams(ps, fgtrdpreloansview);
            ps.executeUpdate();
            return fgtrdpreloansview.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdPreLoansView> fgtrdpreloansviews) throws SQLException {
        if (fgtrdpreloansviews == null || fgtrdpreloansviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdpreloansviews.size(); i++) {
            if (fgtrdpreloansviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPreLoansView>> batches = chunkList(fgtrdpreloansviews, batchSize);
        int[] totalResults = new int[fgtrdpreloansviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPreLoansView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdPreLoansView fgtrdpreloansview : batch) {
                        setFgTrdPreLoansViewParams(ps, fgtrdpreloansview);
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

    public FgTrdPreLoansView findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdPreLoansView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdPreLoansView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdPreLoansView fgtrdpreloansview) throws SQLException {
        if (fgtrdpreloansview.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdPreLoansViewParams(ps, fgtrdpreloansview);
            ps.setInt(24, fgtrdpreloansview.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdPreLoansView> fgtrdpreloansviews) throws SQLException {
        if (fgtrdpreloansviews == null || fgtrdpreloansviews.isEmpty())
            return new int[0];
        for (FgTrdPreLoansView fgtrdpreloansview : fgtrdpreloansviews) {
            if (fgtrdpreloansview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdpreloansview.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPreLoansView>> batches = chunkList(fgtrdpreloansviews, batchSize);
        int[] totalResults = new int[fgtrdpreloansviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPreLoansView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdPreLoansView fgtrdpreloansview : batch) {
                        setFgTrdPreLoansViewParams(ps, fgtrdpreloansview);
                        ps.setInt(24, fgtrdpreloansview.getID());
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

    private void setFgTrdPreLoansViewParams(PreparedStatement ps, FgTrdPreLoansView fgtrdpreloansview) throws SQLException {
        Integer val1 = fgtrdpreloansview.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdpreloansview.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdpreloansview.getTypeCode());
        ps.setString(4, fgtrdpreloansview.getSubTypeCode());
        ps.setString(5, fgtrdpreloansview.getActiveCode());
        ps.setString(6, fgtrdpreloansview.getStageCode());
        ps.setString(7, fgtrdpreloansview.getStatusCode());
        ps.setString(8, fgtrdpreloansview.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdpreloansview.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdpreloansview.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdpreloansview.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdpreloansview.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdpreloansview.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdpreloansview.getTemplate());
        java.math.BigDecimal val15 = fgtrdpreloansview.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdpreloansview.getPreLoanRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgtrdpreloansview.getLoanRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        ps.setString(18, fgtrdpreloansview.getCurCode());
        java.math.BigDecimal val19 = fgtrdpreloansview.getPrincipalOutstanding();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtrdpreloansview.getInLoanCur();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdpreloansview.getDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdpreloansview.getEquDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgtrdpreloansview.getApplicantParty());
        java.time.LocalDateTime val24 = fgtrdpreloansview.getDisbDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
    }

    private FgTrdPreLoansView extract(ResultSet rs) throws SQLException {
        FgTrdPreLoansView fgtrdpreloansview = new FgTrdPreLoansView();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdpreloansview.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdpreloansview.setReferenceID(REFERENCE_ID);
        fgtrdpreloansview.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdpreloansview.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdpreloansview.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdpreloansview.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdpreloansview.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdpreloansview.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdpreloansview.setCreatedBy(CREATED_BY);
        fgtrdpreloansview.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdpreloansview.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdpreloansview.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdpreloansview.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdpreloansview.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdpreloansview.setIsTemplate(IS_TEMPLATE);
        Integer PRE_LOAN_REF_ID = rs.getObject(COL_PRE_LOAN_REF_ID, Integer.class);
        fgtrdpreloansview.setPreLoanRefID(PRE_LOAN_REF_ID);
        Integer LOAN_REF_ID = rs.getObject(COL_LOAN_REF_ID, Integer.class);
        fgtrdpreloansview.setLoanRefID(LOAN_REF_ID);
        fgtrdpreloansview.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal PRINCIPAL_OUTSTANDING = rs.getObject(COL_PRINCIPAL_OUTSTANDING, java.math.BigDecimal.class);
        fgtrdpreloansview.setPrincipalOutstanding(PRINCIPAL_OUTSTANDING);
        java.math.BigDecimal IN_LOAN_CUR = rs.getObject(COL_IN_LOAN_CUR, java.math.BigDecimal.class);
        fgtrdpreloansview.setInLoanCur(IN_LOAN_CUR);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpreloansview.setDspAmt(DSP_AMT);
        java.math.BigDecimal EQU_DSP_AMT = rs.getObject(COL_EQU_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpreloansview.setEquDspAmt(EQU_DSP_AMT);
        fgtrdpreloansview.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        Timestamp DISB_DATE = rs.getTimestamp(COL_DISB_DATE);
        if (DISB_DATE != null)
            fgtrdpreloansview.setDisbDate(DISB_DATE.toLocalDateTime());
        return fgtrdpreloansview;
    }
}
