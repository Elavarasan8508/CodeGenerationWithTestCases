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

public class JdbcFgTrdLcDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdLcDao.class);

    private static final String TABLE = "FG_TRD_LC";

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

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_APPLICANT_NAME = "APPLICANT_NAME";

    private static final String COL_ELC_REF_ID = "ELC_REF_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_BILL_REF_ID = "BILL_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_KOTAK_BILL_REF_ID, COL_ISS_BANK_LC_REF_ID, COL_TENOR, COL_CUR_CODE, COL_LODGE_DATE, COL_OUTSTANDING_AMT, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_NAME, COL_ELC_REF_ID, COL_APPLICANT_PARTY, COL_BILL_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_NAME, ELC_REF_ID, APPLICANT_PARTY, BILL_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_NAME, ELC_REF_ID, APPLICANT_PARTY, BILL_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_KOTAK_BILL_REF_ID, COL_ISS_BANK_LC_REF_ID, COL_TENOR, COL_CUR_CODE, COL_LODGE_DATE, COL_OUTSTANDING_AMT, COL_DSP_AMT, COL_DEDUCTION, COL_REASON, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_NAME, COL_ELC_REF_ID, COL_APPLICANT_PARTY, COL_BILL_REF_ID, COL_ID);

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

    public int insert(Connection conn, FgTrdLc fgtrdlc) throws SQLException {
        logger.debug("Inserting fgtrdlc: {}", fgtrdlc);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdLcParams(ps, fgtrdlc);
            ps.executeUpdate();
            return fgtrdlc.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdLc> fgtrdlcs) throws SQLException {
        if (fgtrdlcs == null || fgtrdlcs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdlcs.size(); i++) {
            if (fgtrdlcs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdLc>> batches = chunkList(fgtrdlcs, batchSize);
        int[] totalResults = new int[fgtrdlcs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdLc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdLc fgtrdlc : batch) {
                        setFgTrdLcParams(ps, fgtrdlc);
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

    public FgTrdLc findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdLc> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdLc> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdLc fgtrdlc) throws SQLException {
        if (fgtrdlc.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdLcParams(ps, fgtrdlc);
            ps.setInt(31, fgtrdlc.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdLc> fgtrdlcs) throws SQLException {
        if (fgtrdlcs == null || fgtrdlcs.isEmpty())
            return new int[0];
        for (FgTrdLc fgtrdlc : fgtrdlcs) {
            if (fgtrdlc == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdlc.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdLc>> batches = chunkList(fgtrdlcs, batchSize);
        int[] totalResults = new int[fgtrdlcs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdLc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdLc fgtrdlc : batch) {
                        setFgTrdLcParams(ps, fgtrdlc);
                        ps.setInt(31, fgtrdlc.getID());
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

    private void setFgTrdLcParams(PreparedStatement ps, FgTrdLc fgtrdlc) throws SQLException {
        Integer val1 = fgtrdlc.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdlc.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdlc.getTypeCode());
        ps.setString(4, fgtrdlc.getSubTypeCode());
        ps.setString(5, fgtrdlc.getActiveCode());
        ps.setString(6, fgtrdlc.getStageCode());
        ps.setString(7, fgtrdlc.getStatusCode());
        ps.setString(8, fgtrdlc.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdlc.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdlc.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdlc.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdlc.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdlc.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdlc.getTemplate());
        java.math.BigDecimal val15 = fgtrdlc.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdlc.getKotakBillRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = fgtrdlc.getIssBankLcRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        ps.setString(18, fgtrdlc.getTenor());
        ps.setString(19, fgtrdlc.getCurCode());
        java.time.LocalDateTime val20 = fgtrdlc.getLodgeDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        java.math.BigDecimal val21 = fgtrdlc.getOutstandingAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdlc.getDspAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtrdlc.getDeduction();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgtrdlc.getReason());
        Integer val25 = fgtrdlc.getParentRefID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgtrdlc.getParentVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgtrdlc.getIrReferenceID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgtrdlc.getApplicantName());
        Integer val29 = fgtrdlc.getElcRefID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgtrdlc.getApplicantParty());
        Integer val31 = fgtrdlc.getBillRefID();
        if (val31 != null) {
            ps.setInt(31, val31);
        } else {
            ps.setNull(31, Types.INTEGER);
        }
    }

    private FgTrdLc extract(ResultSet rs) throws SQLException {
        FgTrdLc fgtrdlc = new FgTrdLc();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdlc.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdlc.setReferenceID(REFERENCE_ID);
        fgtrdlc.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdlc.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdlc.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdlc.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdlc.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdlc.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdlc.setCreatedBy(CREATED_BY);
        fgtrdlc.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdlc.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdlc.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdlc.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdlc.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdlc.setIsTemplate(IS_TEMPLATE);
        Integer KOTAK_BILL_REF_ID = rs.getObject(COL_KOTAK_BILL_REF_ID, Integer.class);
        fgtrdlc.setKotakBillRefID(KOTAK_BILL_REF_ID);
        Integer ISS_BANK_LC_REF_ID = rs.getObject(COL_ISS_BANK_LC_REF_ID, Integer.class);
        fgtrdlc.setIssBankLcRefID(ISS_BANK_LC_REF_ID);
        fgtrdlc.setTenor(rs.getString(COL_TENOR));
        fgtrdlc.setCurCode(rs.getString(COL_CUR_CODE));
        Timestamp LODGE_DATE = rs.getTimestamp(COL_LODGE_DATE);
        if (LODGE_DATE != null)
            fgtrdlc.setLodgeDate(LODGE_DATE.toLocalDateTime());
        java.math.BigDecimal OUTSTANDING_AMT = rs.getObject(COL_OUTSTANDING_AMT, java.math.BigDecimal.class);
        fgtrdlc.setOutstandingAmt(OUTSTANDING_AMT);
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdlc.setDspAmt(DSP_AMT);
        java.math.BigDecimal DEDUCTION = rs.getObject(COL_DEDUCTION, java.math.BigDecimal.class);
        fgtrdlc.setDeduction(DEDUCTION);
        fgtrdlc.setReason(rs.getString(COL_REASON));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtrdlc.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtrdlc.setParentVersionID(PARENT_VERSION_ID);
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrdlc.setIrReferenceID(IR_REFERENCE_ID);
        fgtrdlc.setApplicantName(rs.getString(COL_APPLICANT_NAME));
        Integer ELC_REF_ID = rs.getObject(COL_ELC_REF_ID, Integer.class);
        fgtrdlc.setElcRefID(ELC_REF_ID);
        fgtrdlc.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        Integer BILL_REF_ID = rs.getObject(COL_BILL_REF_ID, Integer.class);
        fgtrdlc.setBillRefID(BILL_REF_ID);
        return fgtrdlc;
    }
}
