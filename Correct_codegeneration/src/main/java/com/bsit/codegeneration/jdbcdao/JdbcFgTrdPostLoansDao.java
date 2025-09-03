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

public class JdbcFgTrdPostLoansDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdPostLoansDao.class);

    private static final String TABLE = "FG_TRD_POST_LOANS";

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

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_BILL_REF_ID = "BILL_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_POST_LOAN_REF_ID, COL_TXN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_COLLECT_SHORT, COL_ACC_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_PARTY, COL_BILL_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY, BILL_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY, BILL_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_POST_LOAN_REF_ID, COL_TXN_REF_ID, COL_LOAN_REF_ID, COL_CUR_CODE, COL_PRINCIPAL_OUTSTANDING, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_COLLECT_SHORT, COL_ACC_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_PARTY, COL_BILL_REF_ID, COL_ID);

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

    public int insert(Connection conn, FgTrdPostLoans fgtrdpostloans) throws SQLException {
        logger.debug("Inserting fgtrdpostloans: {}", fgtrdpostloans);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdPostLoansParams(ps, fgtrdpostloans);
            ps.executeUpdate();
            return fgtrdpostloans.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdPostLoans> fgtrdpostloanss) throws SQLException {
        if (fgtrdpostloanss == null || fgtrdpostloanss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdpostloanss.size(); i++) {
            if (fgtrdpostloanss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostLoans>> batches = chunkList(fgtrdpostloanss, batchSize);
        int[] totalResults = new int[fgtrdpostloanss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostLoans> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdPostLoans fgtrdpostloans : batch) {
                        setFgTrdPostLoansParams(ps, fgtrdpostloans);
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

    public FgTrdPostLoans findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdPostLoans> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdPostLoans> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdPostLoans fgtrdpostloans) throws SQLException {
        if (fgtrdpostloans.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdPostLoansParams(ps, fgtrdpostloans);
            ps.setInt(29, fgtrdpostloans.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdPostLoans> fgtrdpostloanss) throws SQLException {
        if (fgtrdpostloanss == null || fgtrdpostloanss.isEmpty())
            return new int[0];
        for (FgTrdPostLoans fgtrdpostloans : fgtrdpostloanss) {
            if (fgtrdpostloans == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdpostloans.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostLoans>> batches = chunkList(fgtrdpostloanss, batchSize);
        int[] totalResults = new int[fgtrdpostloanss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostLoans> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdPostLoans fgtrdpostloans : batch) {
                        setFgTrdPostLoansParams(ps, fgtrdpostloans);
                        ps.setInt(29, fgtrdpostloans.getID());
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

    private void setFgTrdPostLoansParams(PreparedStatement ps, FgTrdPostLoans fgtrdpostloans) throws SQLException {
        Integer val1 = fgtrdpostloans.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdpostloans.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdpostloans.getTypeCode());
        ps.setString(4, fgtrdpostloans.getSubTypeCode());
        ps.setString(5, fgtrdpostloans.getActiveCode());
        ps.setString(6, fgtrdpostloans.getStageCode());
        ps.setString(7, fgtrdpostloans.getStatusCode());
        ps.setString(8, fgtrdpostloans.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdpostloans.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdpostloans.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdpostloans.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdpostloans.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdpostloans.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdpostloans.getTemplate());
        java.math.BigDecimal val15 = fgtrdpostloans.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdpostloans.getPostLoanRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgtrdpostloans.getTxnRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        Integer val18 = fgtrdpostloans.getLoanRefID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fgtrdpostloans.getCurCode());
        java.math.BigDecimal val20 = fgtrdpostloans.getPrincipalOutstanding();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdpostloans.getDspAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdpostloans.getEquDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgtrdpostloans.getCollectShort());
        ps.setString(24, fgtrdpostloans.getAccNo());
        Integer val25 = fgtrdpostloans.getParentRefID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgtrdpostloans.getParentVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgtrdpostloans.getIrReferenceID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgtrdpostloans.getApplicantParty());
        Integer val29 = fgtrdpostloans.getBillRefID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
    }

    private FgTrdPostLoans extract(ResultSet rs) throws SQLException {
        FgTrdPostLoans fgtrdpostloans = new FgTrdPostLoans();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdpostloans.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdpostloans.setReferenceID(REFERENCE_ID);
        fgtrdpostloans.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdpostloans.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdpostloans.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdpostloans.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdpostloans.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdpostloans.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdpostloans.setCreatedBy(CREATED_BY);
        fgtrdpostloans.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdpostloans.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdpostloans.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdpostloans.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdpostloans.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdpostloans.setIsTemplate(IS_TEMPLATE);
        Integer POST_LOAN_REF_ID = rs.getObject(COL_POST_LOAN_REF_ID, Integer.class);
        fgtrdpostloans.setPostLoanRefID(POST_LOAN_REF_ID);
        Integer TXN_REF_ID = rs.getObject(COL_TXN_REF_ID, Integer.class);
        fgtrdpostloans.setTxnRefID(TXN_REF_ID);
        Integer LOAN_REF_ID = rs.getObject(COL_LOAN_REF_ID, Integer.class);
        fgtrdpostloans.setLoanRefID(LOAN_REF_ID);
        fgtrdpostloans.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal PRINCIPAL_OUTSTANDING = rs.getObject(COL_PRINCIPAL_OUTSTANDING, java.math.BigDecimal.class);
        fgtrdpostloans.setPrincipalOutstanding(PRINCIPAL_OUTSTANDING);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpostloans.setDspAmt(DSP_AMT);
        java.math.BigDecimal EQU_DSP_AMT = rs.getObject(COL_EQU_DSP_AMT, java.math.BigDecimal.class);
        fgtrdpostloans.setEquDspAmt(EQU_DSP_AMT);
        fgtrdpostloans.setCollectShort(rs.getString(COL_COLLECT_SHORT));
        fgtrdpostloans.setAccNo(rs.getString(COL_ACC_NO));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtrdpostloans.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtrdpostloans.setParentVersionID(PARENT_VERSION_ID);
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrdpostloans.setIrReferenceID(IR_REFERENCE_ID);
        fgtrdpostloans.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        Integer BILL_REF_ID = rs.getObject(COL_BILL_REF_ID, Integer.class);
        fgtrdpostloans.setBillRefID(BILL_REF_ID);
        return fgtrdpostloans;
    }
}
