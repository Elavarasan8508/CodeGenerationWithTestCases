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

public class JdbcFgAlsAccountsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAlsAccountsDao.class);

    private static final String TABLE = "FG_ALS_ACCOUNTS";

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

    private static final String COL_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_LOGIC_OF_SETTLEMENT = "LOGIC_OF_SETTLEMENT";

    private static final String COL_MAX_SETTLEMENT_PERCENTAGE = "MAX_SETTLEMENT_PERCENTAGE";

    private static final String COL_MAX_SETTLEMENT_AMOUNT = "MAX_SETTLEMENT_AMOUNT";

    private static final String COL_REPAYMENT_ACTION = "REPAYMENT_ACTION";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ACCOUNT_NUMBER, COL_PRODUCT_CODE, COL_LOGIC_OF_SETTLEMENT, COL_MAX_SETTLEMENT_PERCENTAGE, COL_MAX_SETTLEMENT_AMOUNT, COL_REPAYMENT_ACTION, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_PROCESS_ID, COL_IS_MASTER_VERSION, COL_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, PARENT_REF_ID, PARENT_VERSION_ID, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, PARENT_REF_ID, PARENT_VERSION_ID, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ACCOUNT_NUMBER, COL_PRODUCT_CODE, COL_LOGIC_OF_SETTLEMENT, COL_MAX_SETTLEMENT_PERCENTAGE, COL_MAX_SETTLEMENT_AMOUNT, COL_REPAYMENT_ACTION, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_PROCESS_ID, COL_IS_MASTER_VERSION, COL_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgAlsAccounts fgalsaccounts) throws SQLException {
        logger.debug("Inserting fgalsaccounts: {}", fgalsaccounts);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAlsAccountsParams(ps, fgalsaccounts);
            ps.executeUpdate();
            return fgalsaccounts.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAlsAccounts> fgalsaccountss) throws SQLException {
        if (fgalsaccountss == null || fgalsaccountss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgalsaccountss.size(); i++) {
            if (fgalsaccountss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsAccounts>> batches = chunkList(fgalsaccountss, batchSize);
        int[] totalResults = new int[fgalsaccountss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsAccounts> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAlsAccounts fgalsaccounts : batch) {
                        setFgAlsAccountsParams(ps, fgalsaccounts);
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

    public FgAlsAccounts findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAlsAccounts> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAlsAccounts> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAlsAccounts fgalsaccounts) throws SQLException {
        if (fgalsaccounts.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAlsAccountsParams(ps, fgalsaccounts);
            ps.setInt(26, fgalsaccounts.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAlsAccounts> fgalsaccountss) throws SQLException {
        if (fgalsaccountss == null || fgalsaccountss.isEmpty())
            return new int[0];
        for (FgAlsAccounts fgalsaccounts : fgalsaccountss) {
            if (fgalsaccounts == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgalsaccounts.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAlsAccounts>> batches = chunkList(fgalsaccountss, batchSize);
        int[] totalResults = new int[fgalsaccountss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAlsAccounts> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAlsAccounts fgalsaccounts : batch) {
                        setFgAlsAccountsParams(ps, fgalsaccounts);
                        ps.setInt(26, fgalsaccounts.getID());
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

    private void setFgAlsAccountsParams(PreparedStatement ps, FgAlsAccounts fgalsaccounts) throws SQLException {
        Integer val1 = fgalsaccounts.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgalsaccounts.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgalsaccounts.getTypeCode());
        ps.setString(4, fgalsaccounts.getSubTypeCode());
        ps.setString(5, fgalsaccounts.getActiveCode());
        ps.setString(6, fgalsaccounts.getStageCode());
        ps.setString(7, fgalsaccounts.getStatusCode());
        ps.setString(8, fgalsaccounts.getCreatedOn());
        java.math.BigDecimal val9 = fgalsaccounts.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgalsaccounts.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgalsaccounts.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgalsaccounts.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgalsaccounts.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgalsaccounts.getTemplate());
        java.math.BigDecimal val15 = fgalsaccounts.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgalsaccounts.getAccountNumber());
        ps.setString(17, fgalsaccounts.getProductCode());
        ps.setString(18, fgalsaccounts.getLogicOfSettlement());
        java.math.BigDecimal val19 = fgalsaccounts.getMaxSettlementPercentage();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgalsaccounts.getMaxSettlementAmount();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgalsaccounts.getRepaymentAction());
        Integer val22 = fgalsaccounts.getParentRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        Integer val23 = fgalsaccounts.getParentVersionID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fgalsaccounts.getProcessID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgalsaccounts.getIsMasterVersion();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        Integer val26 = fgalsaccounts.getVersionID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
    }

    private FgAlsAccounts extract(ResultSet rs) throws SQLException {
        FgAlsAccounts fgalsaccounts = new FgAlsAccounts();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgalsaccounts.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgalsaccounts.setReferenceID(REFERENCE_ID);
        fgalsaccounts.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgalsaccounts.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgalsaccounts.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgalsaccounts.setStageCode(rs.getString(COL_STAGE_CODE));
        fgalsaccounts.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgalsaccounts.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgalsaccounts.setCreatedBy(CREATED_BY);
        fgalsaccounts.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgalsaccounts.setLastUpdatedBy(LAST_UPDATED_BY);
        fgalsaccounts.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgalsaccounts.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgalsaccounts.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgalsaccounts.setIsTemplate(IS_TEMPLATE);
        fgalsaccounts.setAccountNumber(rs.getString(COL_ACCOUNT_NUMBER));
        fgalsaccounts.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgalsaccounts.setLogicOfSettlement(rs.getString(COL_LOGIC_OF_SETTLEMENT));
        java.math.BigDecimal MAX_SETTLEMENT_PERCENTAGE = rs.getObject(COL_MAX_SETTLEMENT_PERCENTAGE, java.math.BigDecimal.class);
        fgalsaccounts.setMaxSettlementPercentage(MAX_SETTLEMENT_PERCENTAGE);
        java.math.BigDecimal MAX_SETTLEMENT_AMOUNT = rs.getObject(COL_MAX_SETTLEMENT_AMOUNT, java.math.BigDecimal.class);
        fgalsaccounts.setMaxSettlementAmount(MAX_SETTLEMENT_AMOUNT);
        fgalsaccounts.setRepaymentAction(rs.getString(COL_REPAYMENT_ACTION));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgalsaccounts.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgalsaccounts.setParentVersionID(PARENT_VERSION_ID);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgalsaccounts.setProcessID(PROCESS_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgalsaccounts.setIsMasterVersion(IS_MASTER_VERSION);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgalsaccounts.setVersionID(VERSION_ID);
        return fgalsaccounts;
    }
}
