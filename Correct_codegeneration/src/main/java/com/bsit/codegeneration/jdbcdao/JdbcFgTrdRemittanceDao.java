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

public class JdbcFgTrdRemittanceDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdRemittanceDao.class);

    private static final String TABLE = "FG_TRD_REMITTANCE";

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

    private static final String COL_CUST_REF_ID = "CUST_REF_ID";

    private static final String COL_TNX_TYPE = "TNX_TYPE";

    private static final String COL_PROD_STAT_CODE = "PROD_STAT_CODE";

    private static final String COL_TNX_STAT_CODE = "TNX_STAT_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_APPL_DATE = "APPL_DATE";

    private static final String COL_IR_TYPE_CODE = "IR_TYPE_CODE";

    private static final String COL_TNX_VALUE_DATE = "TNX_VALUE_DATE";

    private static final String COL_IR_CUR_CODE = "IR_CUR_CODE";

    private static final String COL_IR_AMT = "IR_AMT";

    private static final String COL_TNX_CUR_CODE = "TNX_CUR_CODE";

    private static final String COL_TNX_AMT = "TNX_AMT";

    private static final String COL_ACT_NO = "ACT_NO";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_1 = "BENEFICIARY_ADDRESS_LINE_1";

    private static final String COL_BENEFICIARY_ADDRESS_LINE_2 = "BENEFICIARY_ADDRESS_LINE_2";

    private static final String COL_BENEFICIARY_REFERENCE = "BENEFICIARY_REFERENCE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_ADDRESS_LINE_1 = "REMITTER_ADDRESS_LINE_1";

    private static final String COL_REMITTER_ADDRESS_LINE_2 = "REMITTER_ADDRESS_LINE_2";

    private static final String COL_NOSTRO_NUMBER = "NOSTRO_NUMBER";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_IR_VALUE_DATE = "IR_VALUE_DATE";

    private static final String COL_SWIFT_MSG_TYPE = "SWIFT_MSG_TYPE";

    private static final String COL_IR_ORDR_INSTITUTION = "IR_ORDR_INSTITUTION";

    private static final String COL_IR_REM_INFO = "IR_REM_INFO";

    private static final String COL_IR_DTL_CHRGS = "IR_DTL_CHRGS";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_BO_REF_ID = "BO_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUST_REF_ID, COL_TNX_TYPE, COL_PROD_STAT_CODE, COL_TNX_STAT_CODE, COL_PRODUCT_CODE, COL_APPL_DATE, COL_IR_TYPE_CODE, COL_TNX_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_TNX_CUR_CODE, COL_TNX_AMT, COL_ACT_NO, COL_BENEFICIARY_NAME, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_BENEFICIARY_REFERENCE, COL_REMITTER_NAME, COL_REMITTER_ADDRESS_LINE_1, COL_REMITTER_ADDRESS_LINE_2, COL_NOSTRO_NUMBER, COL_SUB_PRODUCT_CODE, COL_IR_VALUE_DATE, COL_SWIFT_MSG_TYPE, COL_IR_ORDR_INSTITUTION, COL_IR_REM_INFO, COL_IR_DTL_CHRGS, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_BO_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUST_REF_ID, TNX_TYPE, PROD_STAT_CODE, TNX_STAT_CODE, PRODUCT_CODE, APPL_DATE, IR_TYPE_CODE, TNX_VALUE_DATE, IR_CUR_CODE, IR_AMT, TNX_CUR_CODE, TNX_AMT, ACT_NO, BENEFICIARY_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BENEFICIARY_REFERENCE, REMITTER_NAME, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, NOSTRO_NUMBER, SUB_PRODUCT_CODE, IR_VALUE_DATE, SWIFT_MSG_TYPE, IR_ORDR_INSTITUTION, IR_REM_INFO, IR_DTL_CHRGS, PROCESS_ID, APPLICANT_PARTY, BO_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUST_REF_ID, TNX_TYPE, PROD_STAT_CODE, TNX_STAT_CODE, PRODUCT_CODE, APPL_DATE, IR_TYPE_CODE, TNX_VALUE_DATE, IR_CUR_CODE, IR_AMT, TNX_CUR_CODE, TNX_AMT, ACT_NO, BENEFICIARY_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BENEFICIARY_REFERENCE, REMITTER_NAME, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, NOSTRO_NUMBER, SUB_PRODUCT_CODE, IR_VALUE_DATE, SWIFT_MSG_TYPE, IR_ORDR_INSTITUTION, IR_REM_INFO, IR_DTL_CHRGS, PROCESS_ID, APPLICANT_PARTY, BO_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUST_REF_ID, COL_TNX_TYPE, COL_PROD_STAT_CODE, COL_TNX_STAT_CODE, COL_PRODUCT_CODE, COL_APPL_DATE, COL_IR_TYPE_CODE, COL_TNX_VALUE_DATE, COL_IR_CUR_CODE, COL_IR_AMT, COL_TNX_CUR_CODE, COL_TNX_AMT, COL_ACT_NO, COL_BENEFICIARY_NAME, COL_BENEFICIARY_ADDRESS_LINE_1, COL_BENEFICIARY_ADDRESS_LINE_2, COL_BENEFICIARY_REFERENCE, COL_REMITTER_NAME, COL_REMITTER_ADDRESS_LINE_1, COL_REMITTER_ADDRESS_LINE_2, COL_NOSTRO_NUMBER, COL_SUB_PRODUCT_CODE, COL_IR_VALUE_DATE, COL_SWIFT_MSG_TYPE, COL_IR_ORDR_INSTITUTION, COL_IR_REM_INFO, COL_IR_DTL_CHRGS, COL_PROCESS_ID, COL_APPLICANT_PARTY, COL_BO_REF_ID, COL_ID);

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

    public int insert(Connection conn, FgTrdRemittance fgtrdremittance) throws SQLException {
        logger.debug("Inserting fgtrdremittance: {}", fgtrdremittance);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdRemittanceParams(ps, fgtrdremittance);
            ps.executeUpdate();
            return fgtrdremittance.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdRemittance> fgtrdremittances) throws SQLException {
        if (fgtrdremittances == null || fgtrdremittances.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdremittances.size(); i++) {
            if (fgtrdremittances.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdRemittance>> batches = chunkList(fgtrdremittances, batchSize);
        int[] totalResults = new int[fgtrdremittances.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdRemittance> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdRemittance fgtrdremittance : batch) {
                        setFgTrdRemittanceParams(ps, fgtrdremittance);
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

    public FgTrdRemittance findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdRemittance> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdRemittance> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdRemittance fgtrdremittance) throws SQLException {
        if (fgtrdremittance.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdRemittanceParams(ps, fgtrdremittance);
            ps.setInt(45, fgtrdremittance.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdRemittance> fgtrdremittances) throws SQLException {
        if (fgtrdremittances == null || fgtrdremittances.isEmpty())
            return new int[0];
        for (FgTrdRemittance fgtrdremittance : fgtrdremittances) {
            if (fgtrdremittance == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdremittance.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdRemittance>> batches = chunkList(fgtrdremittances, batchSize);
        int[] totalResults = new int[fgtrdremittances.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdRemittance> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdRemittance fgtrdremittance : batch) {
                        setFgTrdRemittanceParams(ps, fgtrdremittance);
                        ps.setInt(45, fgtrdremittance.getID());
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

    private void setFgTrdRemittanceParams(PreparedStatement ps, FgTrdRemittance fgtrdremittance) throws SQLException {
        Integer val1 = fgtrdremittance.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdremittance.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdremittance.getTypeCode());
        ps.setString(4, fgtrdremittance.getSubTypeCode());
        ps.setString(5, fgtrdremittance.getActiveCode());
        ps.setString(6, fgtrdremittance.getStageCode());
        ps.setString(7, fgtrdremittance.getStatusCode());
        ps.setString(8, fgtrdremittance.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdremittance.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdremittance.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdremittance.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdremittance.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdremittance.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdremittance.getTemplate());
        java.math.BigDecimal val15 = fgtrdremittance.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgtrdremittance.getCustRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        java.math.BigDecimal val17 = fgtrdremittance.getTnxType();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = fgtrdremittance.getProdStatCode();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgtrdremittance.getTnxStatCode();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgtrdremittance.getProductCode());
        java.time.LocalDateTime val21 = fgtrdremittance.getApplDate();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        java.math.BigDecimal val22 = fgtrdremittance.getIrTypeCode();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.time.LocalDateTime val23 = fgtrdremittance.getTnxValueDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, fgtrdremittance.getIrCurCode());
        java.math.BigDecimal val25 = fgtrdremittance.getIrAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgtrdremittance.getTnxCurCode());
        java.math.BigDecimal val27 = fgtrdremittance.getTnxAmt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgtrdremittance.getActNo());
        ps.setString(29, fgtrdremittance.getBeneficiaryName());
        ps.setString(30, fgtrdremittance.getBeneficiaryAddressLine1());
        ps.setString(31, fgtrdremittance.getBeneficiaryAddressLine2());
        ps.setString(32, fgtrdremittance.getBeneficiaryReference());
        ps.setString(33, fgtrdremittance.getRemitterName());
        ps.setString(34, fgtrdremittance.getRemitterAddressLine1());
        ps.setString(35, fgtrdremittance.getRemitterAddressLine2());
        ps.setString(36, fgtrdremittance.getNostroNumber());
        ps.setString(37, fgtrdremittance.getSubProductCode());
        java.time.LocalDateTime val38 = fgtrdremittance.getIrValueDate();
        if (val38 != null) {
            ps.setTimestamp(38, java.sql.Timestamp.valueOf(val38));
        } else {
            ps.setNull(38, Types.TIMESTAMP);
        }
        ps.setString(39, fgtrdremittance.getSwiftMsgType());
        ps.setString(40, fgtrdremittance.getIrOrdrInstitution());
        ps.setString(41, fgtrdremittance.getIrRemInfo());
        ps.setString(42, fgtrdremittance.getIrDtlChrgs());
        Integer val43 = fgtrdremittance.getProcessID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        ps.setString(44, fgtrdremittance.getApplicantParty());
        Integer val45 = fgtrdremittance.getBoRefID();
        if (val45 != null) {
            ps.setInt(45, val45);
        } else {
            ps.setNull(45, Types.INTEGER);
        }
    }

    private FgTrdRemittance extract(ResultSet rs) throws SQLException {
        FgTrdRemittance fgtrdremittance = new FgTrdRemittance();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdremittance.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdremittance.setReferenceID(REFERENCE_ID);
        fgtrdremittance.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdremittance.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdremittance.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdremittance.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdremittance.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdremittance.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdremittance.setCreatedBy(CREATED_BY);
        fgtrdremittance.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdremittance.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdremittance.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdremittance.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdremittance.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdremittance.setIsTemplate(IS_TEMPLATE);
        Integer CUST_REF_ID = rs.getObject(COL_CUST_REF_ID, Integer.class);
        fgtrdremittance.setCustRefID(CUST_REF_ID);
        java.math.BigDecimal TNX_TYPE = rs.getObject(COL_TNX_TYPE, java.math.BigDecimal.class);
        fgtrdremittance.setTnxType(TNX_TYPE);
        java.math.BigDecimal PROD_STAT_CODE = rs.getObject(COL_PROD_STAT_CODE, java.math.BigDecimal.class);
        fgtrdremittance.setProdStatCode(PROD_STAT_CODE);
        java.math.BigDecimal TNX_STAT_CODE = rs.getObject(COL_TNX_STAT_CODE, java.math.BigDecimal.class);
        fgtrdremittance.setTnxStatCode(TNX_STAT_CODE);
        fgtrdremittance.setProductCode(rs.getString(COL_PRODUCT_CODE));
        Timestamp APPL_DATE = rs.getTimestamp(COL_APPL_DATE);
        if (APPL_DATE != null)
            fgtrdremittance.setApplDate(APPL_DATE.toLocalDateTime());
        java.math.BigDecimal IR_TYPE_CODE = rs.getObject(COL_IR_TYPE_CODE, java.math.BigDecimal.class);
        fgtrdremittance.setIrTypeCode(IR_TYPE_CODE);
        Timestamp TNX_VALUE_DATE = rs.getTimestamp(COL_TNX_VALUE_DATE);
        if (TNX_VALUE_DATE != null)
            fgtrdremittance.setTnxValueDate(TNX_VALUE_DATE.toLocalDateTime());
        fgtrdremittance.setIrCurCode(rs.getString(COL_IR_CUR_CODE));
        java.math.BigDecimal IR_AMT = rs.getObject(COL_IR_AMT, java.math.BigDecimal.class);
        fgtrdremittance.setIrAmt(IR_AMT);
        fgtrdremittance.setTnxCurCode(rs.getString(COL_TNX_CUR_CODE));
        java.math.BigDecimal TNX_AMT = rs.getObject(COL_TNX_AMT, java.math.BigDecimal.class);
        fgtrdremittance.setTnxAmt(TNX_AMT);
        fgtrdremittance.setActNo(rs.getString(COL_ACT_NO));
        fgtrdremittance.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        fgtrdremittance.setBeneficiaryAddressLine1(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_1));
        fgtrdremittance.setBeneficiaryAddressLine2(rs.getString(COL_BENEFICIARY_ADDRESS_LINE_2));
        fgtrdremittance.setBeneficiaryReference(rs.getString(COL_BENEFICIARY_REFERENCE));
        fgtrdremittance.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgtrdremittance.setRemitterAddressLine1(rs.getString(COL_REMITTER_ADDRESS_LINE_1));
        fgtrdremittance.setRemitterAddressLine2(rs.getString(COL_REMITTER_ADDRESS_LINE_2));
        fgtrdremittance.setNostroNumber(rs.getString(COL_NOSTRO_NUMBER));
        fgtrdremittance.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        Timestamp IR_VALUE_DATE = rs.getTimestamp(COL_IR_VALUE_DATE);
        if (IR_VALUE_DATE != null)
            fgtrdremittance.setIrValueDate(IR_VALUE_DATE.toLocalDateTime());
        fgtrdremittance.setSwiftMsgType(rs.getString(COL_SWIFT_MSG_TYPE));
        fgtrdremittance.setIrOrdrInstitution(rs.getString(COL_IR_ORDR_INSTITUTION));
        fgtrdremittance.setIrRemInfo(rs.getString(COL_IR_REM_INFO));
        fgtrdremittance.setIrDtlChrgs(rs.getString(COL_IR_DTL_CHRGS));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtrdremittance.setProcessID(PROCESS_ID);
        fgtrdremittance.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        Integer BO_REF_ID = rs.getObject(COL_BO_REF_ID, Integer.class);
        fgtrdremittance.setBoRefID(BO_REF_ID);
        return fgtrdremittance;
    }
}
