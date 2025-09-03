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

public class JdbcFgTrdPostLoansViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdPostLoansViewDao.class);

    private static final String TABLE = "FG_TRD_POST_LOANS_VIEW";

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

    private static final String COL_POST_LOAN_REF_ID = "POST_LOAN_REF_ID";

    private static final String COL_TXN_REF_ID = "TXN_REF_ID";

    private static final String COL_LOAN_REF_ID = "LOAN_REF_ID";

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_PRINCIPAL_OUTSTANDING = "PRINCIPAL_OUTSTANDING";

    private static final String COL_DSP_AMT = "DSP_AMT";

    private static final String COL_EQU_DSP_AMT = "EQU_DSP_AMT";

    private static final String COL_COLLECT_SHORT = "COLLECT_SHORT";

    private static final String COL_ACC_NO = "ACC_NO";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_POST_LOAN_REF_ID, COL_TXN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_COLLECT_SHORT, COL_ACC_NO, COL_APPLICANT_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_POST_LOAN_REF_ID, COL_TXN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_COLLECT_SHORT, COL_ACC_NO, COL_APPLICANT_PARTY, COL_ID);

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

    public int insert(Connection conn, FgTrdPostLoansView fgtrdpostloansview) throws SQLException {
        logger.debug("Inserting fgtrdpostloansview: {}", fgtrdpostloansview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdPostLoansViewParams(ps, fgtrdpostloansview);
            ps.executeUpdate();
            return fgtrdpostloansview.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdPostLoansView> fgtrdpostloansviews) throws SQLException {
        if (fgtrdpostloansviews == null || fgtrdpostloansviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdpostloansviews.size(); i++) {
            if (fgtrdpostloansviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostLoansView>> batches = chunkList(fgtrdpostloansviews, batchSize);
        int[] totalResults = new int[fgtrdpostloansviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostLoansView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdPostLoansView fgtrdpostloansview : batch) {
                        setFgTrdPostLoansViewParams(ps, fgtrdpostloansview);
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

    public FgTrdPostLoansView findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdPostLoansView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdPostLoansView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdPostLoansView fgtrdpostloansview) throws SQLException {
        if (fgtrdpostloansview.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdPostLoansViewParams(ps, fgtrdpostloansview);
            ps.setInt(25, fgtrdpostloansview.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdPostLoansView> fgtrdpostloansviews) throws SQLException {
        if (fgtrdpostloansviews == null || fgtrdpostloansviews.isEmpty())
            return new int[0];
        for (FgTrdPostLoansView fgtrdpostloansview : fgtrdpostloansviews) {
            if (fgtrdpostloansview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdpostloansview.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostLoansView>> batches = chunkList(fgtrdpostloansviews, batchSize);
        int[] totalResults = new int[fgtrdpostloansviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostLoansView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdPostLoansView fgtrdpostloansview : batch) {
                        setFgTrdPostLoansViewParams(ps, fgtrdpostloansview);
                        ps.setInt(25, fgtrdpostloansview.getID());
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

    private void setFgTrdPostLoansViewParams(PreparedStatement ps, FgTrdPostLoansView fgtrdpostloansview) throws SQLException {
        Integer val1 = fgtrdpostloansview.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdpostloansview.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdpostloansview.getTypeCode());
        ps.setString(4, fgtrdpostloansview.getSubTypeCode());
        ps.setString(5, fgtrdpostloansview.getActiveCode());
        ps.setString(6, fgtrdpostloansview.getStageCode());
        ps.setString(7, fgtrdpostloansview.getStatusCode());
        ps.setString(8, fgtrdpostloansview.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdpostloansview.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdpostloansview.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdpostloansview.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdpostloansview.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdpostloansview.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdpostloansview.getTemplate());
        java.math.BigDecimal val15 = fgtrdpostloansview.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdpostloansview.getPostLoanRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgtrdpostloansview.getTxnRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = fgtrdpostloansview.getLoanRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fgtrdpostloansview.getCurCode());
        java.math.BigDecimal val20 = fgtrdpostloansview.getPrincipalOutstanding();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdpostloansview.getDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdpostloansview.getEquDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgtrdpostloansview.getCollectShort());
        ps.setString(24, fgtrdpostloansview.getAccNo());
        ps.setString(25, fgtrdpostloansview.getApplicantParty());
    }

    private FgTrdPostLoansView extract(ResultSet rs) throws SQLException {
        FgTrdPostLoansView fgtrdpostloansview = new FgTrdPostLoansView();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdpostloansview.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdpostloansview.setReferenceID(REFERENCE_ID);
        fgtrdpostloansview.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdpostloansview.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdpostloansview.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdpostloansview.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdpostloansview.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdpostloansview.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdpostloansview.setCreatedBy(CREATED_BY);
        fgtrdpostloansview.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdpostloansview.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdpostloansview.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdpostloansview.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdpostloansview.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdpostloansview.setIsTemplate(IS_TEMPLATE);
        Integer POST_LOAN_REF_ID = rs.getObject(COL_POST_LOAN_REF_ID, Integer.class);
        fgtrdpostloansview.setPostLoanRefID(POST_LOAN_REF_ID);
        Integer TXN_REF_ID = rs.getObject(COL_TXN_REF_ID, Integer.class);
        fgtrdpostloansview.setTxnRefID(TXN_REF_ID);
        Integer LOAN_REF_ID = rs.getObject(COL_LOAN_REF_ID, Integer.class);
        fgtrdpostloansview.setLoanRefID(LOAN_REF_ID);
        fgtrdpostloansview.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal PRINCIPAL_OUTSTANDING = rs.getObject(COL_PRINCIPAL_OUTSTANDING, java.math.BigDecimal.class);
        fgtrdpostloansview.setPrincipalOutstanding(PRINCIPAL_OUTSTANDING);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpostloansview.setDspAmt(DSP_AMT);
        java.math.BigDecimal EQU_DSP_AMT = rs.getObject(COL_EQU_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpostloansview.setEquDspAmt(EQU_DSP_AMT);
        fgtrdpostloansview.setCollectShort(rs.getString(COL_COLLECT_SHORT));
        fgtrdpostloansview.setAccNo(rs.getString(COL_ACC_NO));
        fgtrdpostloansview.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        return fgtrdpostloansview;
    }
}
