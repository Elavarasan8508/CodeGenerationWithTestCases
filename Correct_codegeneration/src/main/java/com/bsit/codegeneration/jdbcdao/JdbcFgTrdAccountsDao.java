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

public class JdbcFgTrdAccountsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdAccountsDao.class);

    private static final String TABLE = "FG_TRD_ACCOUNTS";

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

    private static final String COL_ACC_NO = "ACC_NO";

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_IN_ACC_CUR = "IN_ACC_CUR";

    private static final String COL_DSP_AMT = "DSP_AMT";

    private static final String COL_EQU_DSP_AMT = "EQU_DSP_AMT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ACC_NO, COL_CUR_CODE, COL_IN_ACC_CUR, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ACC_NO, COL_CUR_CODE, COL_IN_ACC_CUR, COL_DSP_AMT, COL_EQU_DSP_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IR_REFERENCE_ID, COL_APPLICANT_PARTY, COL_ID);

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

    public int insert(Connection conn, FgTrdAccounts fgtrdaccounts) throws SQLException {
        logger.debug("Inserting fgtrdaccounts: {}", fgtrdaccounts);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdAccountsParams(ps, fgtrdaccounts);
            ps.executeUpdate();
            return fgtrdaccounts.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdAccounts> fgtrdaccountss) throws SQLException {
        if (fgtrdaccountss == null || fgtrdaccountss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdaccountss.size(); i++) {
            if (fgtrdaccountss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdAccounts>> batches = chunkList(fgtrdaccountss, batchSize);
        int[] totalResults = new int[fgtrdaccountss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdAccounts> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdAccounts fgtrdaccounts : batch) {
                        setFgTrdAccountsParams(ps, fgtrdaccounts);
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

    public FgTrdAccounts findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdAccounts> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdAccounts> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdAccounts fgtrdaccounts) throws SQLException {
        if (fgtrdaccounts.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdAccountsParams(ps, fgtrdaccounts);
            ps.setInt(24, fgtrdaccounts.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdAccounts> fgtrdaccountss) throws SQLException {
        if (fgtrdaccountss == null || fgtrdaccountss.isEmpty())
            return new int[0];
        for (FgTrdAccounts fgtrdaccounts : fgtrdaccountss) {
            if (fgtrdaccounts == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdaccounts.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdAccounts>> batches = chunkList(fgtrdaccountss, batchSize);
        int[] totalResults = new int[fgtrdaccountss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdAccounts> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdAccounts fgtrdaccounts : batch) {
                        setFgTrdAccountsParams(ps, fgtrdaccounts);
                        ps.setInt(24, fgtrdaccounts.getID());
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

    private void setFgTrdAccountsParams(PreparedStatement ps, FgTrdAccounts fgtrdaccounts) throws SQLException {
        Integer val1 = fgtrdaccounts.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdaccounts.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdaccounts.getTypeCode());
        ps.setString(4, fgtrdaccounts.getSubTypeCode());
        ps.setString(5, fgtrdaccounts.getActiveCode());
        ps.setString(6, fgtrdaccounts.getStageCode());
        ps.setString(7, fgtrdaccounts.getStatusCode());
        ps.setString(8, fgtrdaccounts.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdaccounts.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdaccounts.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdaccounts.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdaccounts.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdaccounts.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdaccounts.getTemplate());
        java.math.BigDecimal val15 = fgtrdaccounts.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdaccounts.getAccNo());
        ps.setString(17, fgtrdaccounts.getCurCode());
        ps.setString(18, fgtrdaccounts.getInAccCur());
        java.math.BigDecimal val19 = fgtrdaccounts.getDspAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtrdaccounts.getEquDspAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        Integer val21 = fgtrdaccounts.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgtrdaccounts.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = fgtrdaccounts.getIrReferenceID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, fgtrdaccounts.getApplicantParty());
    }

    private FgTrdAccounts extract(ResultSet rs) throws SQLException {
        FgTrdAccounts fgtrdaccounts = new FgTrdAccounts();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdaccounts.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdaccounts.setReferenceID(REFERENCE_ID);
        fgtrdaccounts.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdaccounts.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdaccounts.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdaccounts.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdaccounts.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdaccounts.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdaccounts.setCreatedBy(CREATED_BY);
        fgtrdaccounts.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdaccounts.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdaccounts.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdaccounts.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdaccounts.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdaccounts.setIsTemplate(IS_TEMPLATE);
        fgtrdaccounts.setAccNo(rs.getString(COL_ACC_NO));
        fgtrdaccounts.setCurCode(rs.getString(COL_CUR_CODE));
        fgtrdaccounts.setInAccCur(rs.getString(COL_IN_ACC_CUR));
        java.math.BigDecimal DSP_AMT = rs.getObject(COL_DSP_AMT, java.math.BigDecimal.class);
        fgtrdaccounts.setDspAmt(DSP_AMT);
        java.math.BigDecimal EQU_DSP_AMT = rs.getObject(COL_EQU_DSP_AMT, java.math.BigDecimal.class);
        fgtrdaccounts.setEquDspAmt(EQU_DSP_AMT);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtrdaccounts.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtrdaccounts.setParentVersionID(PARENT_VERSION_ID);
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrdaccounts.setIrReferenceID(IR_REFERENCE_ID);
        fgtrdaccounts.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        return fgtrdaccounts;
    }
}
