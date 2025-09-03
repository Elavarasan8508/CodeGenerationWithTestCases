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

public class JdbcFgAutoloanAcctDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAutoloanAcctDao.class);

    private static final String TABLE = "FG_AUTOLOAN_ACCT";

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

    private static final String COL_ACCT_NUM = "ACCT_NUM";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_MAX_SET_PERCENT = "MAX_SET_PERCENT";

    private static final String COL_MAX_SET_AMOUNT = "MAX_SET_AMOUNT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_LOGIC_SETTLE = "LOGIC_SETTLE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ACCT_NUM, COL_PRODUCT_CODE, COL_MAX_SET_PERCENT, COL_MAX_SET_AMOUNT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_LOGIC_SETTLE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ACCT_NUM, PRODUCT_CODE, MAX_SET_PERCENT, MAX_SET_AMOUNT, PARENT_REF_ID, PARENT_VERSION_ID, LOGIC_SETTLE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ACCT_NUM, PRODUCT_CODE, MAX_SET_PERCENT, MAX_SET_AMOUNT, PARENT_REF_ID, PARENT_VERSION_ID, LOGIC_SETTLE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ACCT_NUM, COL_PRODUCT_CODE, COL_MAX_SET_PERCENT, COL_MAX_SET_AMOUNT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_LOGIC_SETTLE, COL_ID);

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

    public int insert(Connection conn, FgAutoloanAcct fgautoloanacct) throws SQLException {
        logger.debug("Inserting fgautoloanacct: {}", fgautoloanacct);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAutoloanAcctParams(ps, fgautoloanacct);
            ps.executeUpdate();
            return fgautoloanacct.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAutoloanAcct> fgautoloanaccts) throws SQLException {
        if (fgautoloanaccts == null || fgautoloanaccts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgautoloanaccts.size(); i++) {
            if (fgautoloanaccts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAutoloanAcct>> batches = chunkList(fgautoloanaccts, batchSize);
        int[] totalResults = new int[fgautoloanaccts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAutoloanAcct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAutoloanAcct fgautoloanacct : batch) {
                        setFgAutoloanAcctParams(ps, fgautoloanacct);
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

    public FgAutoloanAcct findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAutoloanAcct> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAutoloanAcct> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAutoloanAcct fgautoloanacct) throws SQLException {
        if (fgautoloanacct.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAutoloanAcctParams(ps, fgautoloanacct);
            ps.setInt(25, fgautoloanacct.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAutoloanAcct> fgautoloanaccts) throws SQLException {
        if (fgautoloanaccts == null || fgautoloanaccts.isEmpty())
            return new int[0];
        for (FgAutoloanAcct fgautoloanacct : fgautoloanaccts) {
            if (fgautoloanacct == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgautoloanacct.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAutoloanAcct>> batches = chunkList(fgautoloanaccts, batchSize);
        int[] totalResults = new int[fgautoloanaccts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAutoloanAcct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAutoloanAcct fgautoloanacct : batch) {
                        setFgAutoloanAcctParams(ps, fgautoloanacct);
                        ps.setInt(25, fgautoloanacct.getID());
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

    private void setFgAutoloanAcctParams(PreparedStatement ps, FgAutoloanAcct fgautoloanacct) throws SQLException {
        Integer val1 = fgautoloanacct.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgautoloanacct.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgautoloanacct.getTypeCode());
        ps.setString(4, fgautoloanacct.getSubTypeCode());
        ps.setString(5, fgautoloanacct.getActiveCode());
        ps.setString(6, fgautoloanacct.getStageCode());
        ps.setString(7, fgautoloanacct.getStatusCode());
        Integer val8 = fgautoloanacct.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgautoloanacct.getCreatedOn());
        java.math.BigDecimal val10 = fgautoloanacct.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgautoloanacct.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgautoloanacct.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgautoloanacct.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgautoloanacct.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgautoloanacct.getTemplate());
        ps.setString(16, fgautoloanacct.getApplicantParty());
        ps.setString(17, fgautoloanacct.getFulfillmentParty());
        java.math.BigDecimal val18 = fgautoloanacct.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgautoloanacct.getAcctNum());
        ps.setString(20, fgautoloanacct.getProductCode());
        ps.setString(21, fgautoloanacct.getMaxSetPercent());
        java.math.BigDecimal val22 = fgautoloanacct.getMaxSetAmount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        Integer val23 = fgautoloanacct.getParentRefID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fgautoloanacct.getParentVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        ps.setString(25, fgautoloanacct.getLogicSettle());
    }

    private FgAutoloanAcct extract(ResultSet rs) throws SQLException {
        FgAutoloanAcct fgautoloanacct = new FgAutoloanAcct();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgautoloanacct.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgautoloanacct.setReferenceID(REFERENCE_ID);
        fgautoloanacct.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgautoloanacct.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgautoloanacct.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgautoloanacct.setStageCode(rs.getString(COL_STAGE_CODE));
        fgautoloanacct.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgautoloanacct.setProcessID(PROCESS_ID);
        fgautoloanacct.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgautoloanacct.setCreatedBy(CREATED_BY);
        fgautoloanacct.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgautoloanacct.setLastUpdatedBy(LAST_UPDATED_BY);
        fgautoloanacct.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgautoloanacct.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgautoloanacct.setTemplate(rs.getString(COL_TEMPLATE));
        fgautoloanacct.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgautoloanacct.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgautoloanacct.setIsTemplate(IS_TEMPLATE);
        fgautoloanacct.setAcctNum(rs.getString(COL_ACCT_NUM));
        fgautoloanacct.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgautoloanacct.setMaxSetPercent(rs.getString(COL_MAX_SET_PERCENT));
        java.math.BigDecimal MAX_SET_AMOUNT = rs.getObject(COL_MAX_SET_AMOUNT, java.math.BigDecimal.class);
        fgautoloanacct.setMaxSetAmount(MAX_SET_AMOUNT);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgautoloanacct.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgautoloanacct.setParentVersionID(PARENT_VERSION_ID);
        fgautoloanacct.setLogicSettle(rs.getString(COL_LOGIC_SETTLE));
        return fgautoloanacct;
    }
}
