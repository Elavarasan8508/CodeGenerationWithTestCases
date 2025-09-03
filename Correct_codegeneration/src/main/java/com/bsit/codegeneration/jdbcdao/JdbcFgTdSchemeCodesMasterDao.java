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

public class JdbcFgTdSchemeCodesMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdSchemeCodesMasterDao.class);

    private static final String TABLE = "FG_TD_SCHEME_CODES_MASTER";

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

    private static final String COL_TENOR = "TENOR";

    private static final String COL_INTEREST_VALUE = "INTEREST_VALUE";

    private static final String COL_FIN_SCHEME_CODE = "FIN_SCHEME_CODE";

    private static final String COL_INTEREST_CALCULATION = "INTEREST_CALCULATION";

    private static final String COL_START_TENOR = "START_TENOR";

    private static final String COL_END_TENOR = "END_TENOR";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_ORIGIN = "ORIGIN";

    private static final String COL_ACCOUNT_SCHEME_CODE = "ACCOUNT_SCHEME_CODE";

    private static final String COL_TD_TYPE = "TD_TYPE";

    private static final String COL_MIN_AMOUNT = "MIN_AMOUNT";

    private static final String COL_MAX_AMOUNT = "MAX_AMOUNT";

    private static final String COL_TD_REQUEST = "TD_REQUEST";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TENOR, COL_INTEREST_VALUE, COL_FIN_SCHEME_CODE, COL_INTEREST_CALCULATION, COL_START_TENOR, COL_END_TENOR, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON, COL_PARENT_VERSION_ID, COL_PARENT_REF_ID, COL_ORIGIN, COL_ACCOUNT_SCHEME_CODE, COL_TD_TYPE, COL_MIN_AMOUNT, COL_MAX_AMOUNT, COL_TD_REQUEST);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TENOR, INTEREST_VALUE, FIN_SCHEME_CODE, INTEREST_CALCULATION, START_TENOR, END_TENOR, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN, ACCOUNT_SCHEME_CODE, TD_TYPE, MIN_AMOUNT, MAX_AMOUNT, TD_REQUEST", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TENOR, INTEREST_VALUE, FIN_SCHEME_CODE, INTEREST_CALCULATION, START_TENOR, END_TENOR, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN, ACCOUNT_SCHEME_CODE, TD_TYPE, MIN_AMOUNT, MAX_AMOUNT, TD_REQUEST", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TENOR, COL_INTEREST_VALUE, COL_FIN_SCHEME_CODE, COL_INTEREST_CALCULATION, COL_START_TENOR, COL_END_TENOR, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_TASK_REASON, COL_PARENT_VERSION_ID, COL_PARENT_REF_ID, COL_ORIGIN, COL_ACCOUNT_SCHEME_CODE, COL_TD_TYPE, COL_MIN_AMOUNT, COL_MAX_AMOUNT, COL_TD_REQUEST, COL_ID);

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

    public int insert(Connection conn, FgTdSchemeCodesMaster fgtdschemecodesmaster) throws SQLException {
        logger.debug("Inserting fgtdschemecodesmaster: {}", fgtdschemecodesmaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdSchemeCodesMasterParams(ps, fgtdschemecodesmaster);
            ps.executeUpdate();
            return fgtdschemecodesmaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdSchemeCodesMaster> fgtdschemecodesmasters) throws SQLException {
        if (fgtdschemecodesmasters == null || fgtdschemecodesmasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdschemecodesmasters.size(); i++) {
            if (fgtdschemecodesmasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdSchemeCodesMaster>> batches = chunkList(fgtdschemecodesmasters, batchSize);
        int[] totalResults = new int[fgtdschemecodesmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdSchemeCodesMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdSchemeCodesMaster fgtdschemecodesmaster : batch) {
                        setFgTdSchemeCodesMasterParams(ps, fgtdschemecodesmaster);
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

    public FgTdSchemeCodesMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdSchemeCodesMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdSchemeCodesMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdSchemeCodesMaster fgtdschemecodesmaster) throws SQLException {
        if (fgtdschemecodesmaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdSchemeCodesMasterParams(ps, fgtdschemecodesmaster);
            ps.setInt(35, fgtdschemecodesmaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdSchemeCodesMaster> fgtdschemecodesmasters) throws SQLException {
        if (fgtdschemecodesmasters == null || fgtdschemecodesmasters.isEmpty())
            return new int[0];
        for (FgTdSchemeCodesMaster fgtdschemecodesmaster : fgtdschemecodesmasters) {
            if (fgtdschemecodesmaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdschemecodesmaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdSchemeCodesMaster>> batches = chunkList(fgtdschemecodesmasters, batchSize);
        int[] totalResults = new int[fgtdschemecodesmasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdSchemeCodesMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdSchemeCodesMaster fgtdschemecodesmaster : batch) {
                        setFgTdSchemeCodesMasterParams(ps, fgtdschemecodesmaster);
                        ps.setInt(35, fgtdschemecodesmaster.getID());
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

    private void setFgTdSchemeCodesMasterParams(PreparedStatement ps, FgTdSchemeCodesMaster fgtdschemecodesmaster) throws SQLException {
        Integer val1 = fgtdschemecodesmaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtdschemecodesmaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtdschemecodesmaster.getTypeCode());
        ps.setString(4, fgtdschemecodesmaster.getSubTypeCode());
        ps.setString(5, fgtdschemecodesmaster.getActiveCode());
        ps.setString(6, fgtdschemecodesmaster.getStageCode());
        ps.setString(7, fgtdschemecodesmaster.getStatusCode());
        Integer val8 = fgtdschemecodesmaster.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtdschemecodesmaster.getCreatedOn());
        java.math.BigDecimal val10 = fgtdschemecodesmaster.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtdschemecodesmaster.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtdschemecodesmaster.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtdschemecodesmaster.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtdschemecodesmaster.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtdschemecodesmaster.getTemplate());
        ps.setString(16, fgtdschemecodesmaster.getApplicantParty());
        ps.setString(17, fgtdschemecodesmaster.getFulfillmentParty());
        java.math.BigDecimal val18 = fgtdschemecodesmaster.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtdschemecodesmaster.getTenor());
        ps.setString(20, fgtdschemecodesmaster.getInterestValue());
        ps.setString(21, fgtdschemecodesmaster.getFinSchemeCode());
        ps.setString(22, fgtdschemecodesmaster.getInterestCalculation());
        java.math.BigDecimal val23 = fgtdschemecodesmaster.getStartTenor();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgtdschemecodesmaster.getEndTenor();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        Integer val25 = fgtdschemecodesmaster.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = fgtdschemecodesmaster.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgtdschemecodesmaster.getTaskReason());
        Integer val28 = fgtdschemecodesmaster.getParentVersionID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        Integer val29 = fgtdschemecodesmaster.getParentRefID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, fgtdschemecodesmaster.getOrigin());
        ps.setString(31, fgtdschemecodesmaster.getAccountSchemeCode());
        ps.setString(32, fgtdschemecodesmaster.getTdType());
        java.math.BigDecimal val33 = fgtdschemecodesmaster.getMinAmount();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgtdschemecodesmaster.getMaxAmount();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, fgtdschemecodesmaster.getTdRequest());
    }

    private FgTdSchemeCodesMaster extract(ResultSet rs) throws SQLException {
        FgTdSchemeCodesMaster fgtdschemecodesmaster = new FgTdSchemeCodesMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtdschemecodesmaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdschemecodesmaster.setReferenceID(REFERENCE_ID);
        fgtdschemecodesmaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdschemecodesmaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdschemecodesmaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtdschemecodesmaster.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdschemecodesmaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdschemecodesmaster.setProcessID(PROCESS_ID);
        fgtdschemecodesmaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setCreatedBy(CREATED_BY);
        fgtdschemecodesmaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtdschemecodesmaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtdschemecodesmaster.setTemplate(rs.getString(COL_TEMPLATE));
        fgtdschemecodesmaster.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtdschemecodesmaster.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setIsTemplate(IS_TEMPLATE);
        fgtdschemecodesmaster.setTenor(rs.getString(COL_TENOR));
        fgtdschemecodesmaster.setInterestValue(rs.getString(COL_INTEREST_VALUE));
        fgtdschemecodesmaster.setFinSchemeCode(rs.getString(COL_FIN_SCHEME_CODE));
        fgtdschemecodesmaster.setInterestCalculation(rs.getString(COL_INTEREST_CALCULATION));
        java.math.BigDecimal START_TENOR = rs.getObject(COL_START_TENOR, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setStartTenor(START_TENOR);
        java.math.BigDecimal END_TENOR = rs.getObject(COL_END_TENOR, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setEndTenor(END_TENOR);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtdschemecodesmaster.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setIsMasterVersion(IS_MASTER_VERSION);
        fgtdschemecodesmaster.setTaskReason(rs.getString(COL_TASK_REASON));
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtdschemecodesmaster.setParentVersionID(PARENT_VERSION_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtdschemecodesmaster.setParentRefID(PARENT_REF_ID);
        fgtdschemecodesmaster.setOrigin(rs.getString(COL_ORIGIN));
        fgtdschemecodesmaster.setAccountSchemeCode(rs.getString(COL_ACCOUNT_SCHEME_CODE));
        fgtdschemecodesmaster.setTdType(rs.getString(COL_TD_TYPE));
        java.math.BigDecimal MIN_AMOUNT = rs.getObject(COL_MIN_AMOUNT, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setMinAmount(MIN_AMOUNT);
        java.math.BigDecimal MAX_AMOUNT = rs.getObject(COL_MAX_AMOUNT, java.math.BigDecimal.class);
        fgtdschemecodesmaster.setMaxAmount(MAX_AMOUNT);
        fgtdschemecodesmaster.setTdRequest(rs.getString(COL_TD_REQUEST));
        return fgtdschemecodesmaster;
    }
}
