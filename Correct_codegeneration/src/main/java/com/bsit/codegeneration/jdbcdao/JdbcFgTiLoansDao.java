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

public class JdbcFgTiLoansDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTiLoansDao.class);

    private static final String TABLE = "FG_TI_LOANS";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_CUST_MNM = "CUST_MNM";

    private static final String COL_DISB_DATE = "DISB_DATE";

    private static final String COL_INTEREST_REPAYMENT_AMOUNT = "INTEREST_REPAYMENT_AMOUNT";

    private static final String COL_MASTER_REF = "MASTER_REF";

    private static final String COL_MATURITY_DATE = "MATURITY_DATE";

    private static final String COL_OVERDUE_Y_N = "OVERDUE_Y_N";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_TOTAL_REPAYMENT_AMOUNT = "TOTAL_REPAYMENT_AMOUNT";

    private static final String COL_PRINCIPLE_REPAYMENT_AMOUNT = "PRINCIPLE_REPAYMENT_AMOUNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUST_MNM, COL_DISB_DATE, COL_INTEREST_REPAYMENT_AMOUNT, COL_MASTER_REF, COL_MATURITY_DATE, COL_OVERDUE_Y_N, COL_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TOTAL_REPAYMENT_AMOUNT, COL_PRINCIPLE_REPAYMENT_AMOUNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUST_MNM, DISB_DATE, INTEREST_REPAYMENT_AMOUNT, MASTER_REF, MATURITY_DATE, OVERDUE_Y_N, STATUS, VERSION_ID, IS_MASTER_VERSION, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUST_MNM, DISB_DATE, INTEREST_REPAYMENT_AMOUNT, MASTER_REF, MATURITY_DATE, OVERDUE_Y_N, STATUS, VERSION_ID, IS_MASTER_VERSION, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CUST_MNM, COL_DISB_DATE, COL_INTEREST_REPAYMENT_AMOUNT, COL_MASTER_REF, COL_MATURITY_DATE, COL_OVERDUE_Y_N, COL_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TOTAL_REPAYMENT_AMOUNT, COL_PRINCIPLE_REPAYMENT_AMOUNT, COL_ID);

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

    public int insert(Connection conn, FgTiLoans fgtiloans) throws SQLException {
        logger.debug("Inserting fgtiloans: {}", fgtiloans);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTiLoansParams(ps, fgtiloans);
            ps.executeUpdate();
            return fgtiloans.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTiLoans> fgtiloanss) throws SQLException {
        if (fgtiloanss == null || fgtiloanss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtiloanss.size(); i++) {
            if (fgtiloanss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTiLoans>> batches = chunkList(fgtiloanss, batchSize);
        int[] totalResults = new int[fgtiloanss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTiLoans> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTiLoans fgtiloans : batch) {
                        setFgTiLoansParams(ps, fgtiloans);
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

    public FgTiLoans findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTiLoans> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTiLoans> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTiLoans fgtiloans) throws SQLException {
        if (fgtiloans.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTiLoansParams(ps, fgtiloans);
            ps.setInt(29, fgtiloans.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTiLoans> fgtiloanss) throws SQLException {
        if (fgtiloanss == null || fgtiloanss.isEmpty())
            return new int[0];
        for (FgTiLoans fgtiloans : fgtiloanss) {
            if (fgtiloans == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtiloans.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTiLoans>> batches = chunkList(fgtiloanss, batchSize);
        int[] totalResults = new int[fgtiloanss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTiLoans> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTiLoans fgtiloans : batch) {
                        setFgTiLoansParams(ps, fgtiloans);
                        ps.setInt(29, fgtiloans.getID());
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

    private void setFgTiLoansParams(PreparedStatement ps, FgTiLoans fgtiloans) throws SQLException {
        Integer val1 = fgtiloans.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtiloans.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtiloans.getTypeCode());
        ps.setString(4, fgtiloans.getSubTypeCode());
        ps.setString(5, fgtiloans.getActiveCode());
        ps.setString(6, fgtiloans.getStageCode());
        ps.setString(7, fgtiloans.getStatusCode());
        Integer val8 = fgtiloans.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtiloans.getCreatedOn());
        java.math.BigDecimal val10 = fgtiloans.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtiloans.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtiloans.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtiloans.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtiloans.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtiloans.getTemplate());
        ps.setString(16, fgtiloans.getApplicantParty());
        ps.setString(17, fgtiloans.getFulfillmentParty());
        java.math.BigDecimal val18 = fgtiloans.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtiloans.getCustMnm());
        java.time.LocalDateTime val20 = fgtiloans.getDisbDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        java.math.BigDecimal val21 = fgtiloans.getInterestRepaymentAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgtiloans.getMasterRef());
        java.time.LocalDateTime val23 = fgtiloans.getMaturityDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, fgtiloans.getOverdueYN());
        ps.setString(25, fgtiloans.getStatus());
        Integer val26 = fgtiloans.getVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        java.math.BigDecimal val27 = fgtiloans.getIsMasterVersion();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgtiloans.getTotalRepaymentAmount();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = fgtiloans.getPrincipleRepaymentAmount();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
    }

    private FgTiLoans extract(ResultSet rs) throws SQLException {
        FgTiLoans fgtiloans = new FgTiLoans();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtiloans.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtiloans.setReferenceID(REFERENCE_ID);
        fgtiloans.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtiloans.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtiloans.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtiloans.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtiloans.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtiloans.setProcessID(PROCESS_ID);
        fgtiloans.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtiloans.setCreatedBy(CREATED_BY);
        fgtiloans.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtiloans.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtiloans.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtiloans.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtiloans.setTemplate(rs.getString(COL_TEMPLATE));
        fgtiloans.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtiloans.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtiloans.setIsTemplate(IS_TEMPLATE);
        fgtiloans.setCustMnm(rs.getString(COL_CUST_MNM));
        Timestamp DISB_DATE = rs.getTimestamp(COL_DISB_DATE);
        if (DISB_DATE != null)
            fgtiloans.setDisbDate(DISB_DATE.toLocalDateTime());
        java.math.BigDecimal INTEREST_REPAYMENT_AMOUNT = rs.getObject(COL_INTEREST_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgtiloans.setInterestRepaymentAmount(INTEREST_REPAYMENT_AMOUNT);
        fgtiloans.setMasterRef(rs.getString(COL_MASTER_REF));
        Timestamp MATURITY_DATE = rs.getTimestamp(COL_MATURITY_DATE);
        if (MATURITY_DATE != null)
            fgtiloans.setMaturityDate(MATURITY_DATE.toLocalDateTime());
        fgtiloans.setOverdueYN(rs.getString(COL_OVERDUE_Y_N));
        fgtiloans.setStatus(rs.getString(COL_STATUS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtiloans.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtiloans.setIsMasterVersion(IS_MASTER_VERSION);
        java.math.BigDecimal TOTAL_REPAYMENT_AMOUNT = rs.getObject(COL_TOTAL_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgtiloans.setTotalRepaymentAmount(TOTAL_REPAYMENT_AMOUNT);
        java.math.BigDecimal PRINCIPLE_REPAYMENT_AMOUNT = rs.getObject(COL_PRINCIPLE_REPAYMENT_AMOUNT, java.math.BigDecimal.class);
        fgtiloans.setPrincipleRepaymentAmount(PRINCIPLE_REPAYMENT_AMOUNT);
        return fgtiloans;
    }
}
