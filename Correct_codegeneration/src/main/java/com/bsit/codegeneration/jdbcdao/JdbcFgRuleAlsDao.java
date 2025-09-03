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

public class JdbcFgRuleAlsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgRuleAlsDao.class);

    private static final String TABLE = "FG_RULE_ALS";

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

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_CUSTOMER_CRN = "CUSTOMER_CRN";

    private static final String COL_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_LOGIC_OF_SETTLEMENT = "LOGIC_OF_SETTLEMENT";

    private static final String COL_MAX_SETTLEMENT_PERCENTAGE = "MAX_SETTLEMENT_PERCENTAGE";

    private static final String COL_MAX_SETTLEMENT_AMOUNT = "MAX_SETTLEMENT_AMOUNT";

    private static final String COL_REPAYMENT_ACTION = "REPAYMENT_ACTION";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_DEBIT_LOCK = "DEBIT_LOCK";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_SLOT_REFERENCE = "SLOT_REFERENCE";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String COL_MONTHEND_SLOT = "MONTHEND_SLOT";

    private static final String COL_VIRTUAL_ACCOUNT_NUMBER = "VIRTUAL_ACCOUNT_NUMBER";

    private static final String COL_ACCOUNT_TYPE = "ACCOUNT_TYPE";

    private static final String COL_COUNTERPARTY_CRN = "COUNTERPARTY_CRN";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_CUSTOMER_CRN, COL_ACCOUNT_NUMBER, COL_PRODUCT_CODE, COL_LOGIC_OF_SETTLEMENT, COL_MAX_SETTLEMENT_PERCENTAGE, COL_MAX_SETTLEMENT_AMOUNT, COL_REPAYMENT_ACTION, COL_STATUS, COL_DEBIT_LOCK, COL_PROCESS_ID, COL_SLOT_REFERENCE, COL_CUSTOMER_NAME, COL_MONTHEND_SLOT, COL_VIRTUAL_ACCOUNT_NUMBER, COL_ACCOUNT_TYPE, COL_COUNTERPARTY_CRN);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, CUSTOMER_CRN, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, STATUS, DEBIT_LOCK, PROCESS_ID, SLOT_REFERENCE, CUSTOMER_NAME, MONTHEND_SLOT, VIRTUAL_ACCOUNT_NUMBER, ACCOUNT_TYPE, COUNTERPARTY_CRN", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, CUSTOMER_CRN, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, STATUS, DEBIT_LOCK, PROCESS_ID, SLOT_REFERENCE, CUSTOMER_NAME, MONTHEND_SLOT, VIRTUAL_ACCOUNT_NUMBER, ACCOUNT_TYPE, COUNTERPARTY_CRN", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_CUSTOMER_CRN, COL_ACCOUNT_NUMBER, COL_PRODUCT_CODE, COL_LOGIC_OF_SETTLEMENT, COL_MAX_SETTLEMENT_PERCENTAGE, COL_MAX_SETTLEMENT_AMOUNT, COL_REPAYMENT_ACTION, COL_STATUS, COL_DEBIT_LOCK, COL_PROCESS_ID, COL_SLOT_REFERENCE, COL_CUSTOMER_NAME, COL_MONTHEND_SLOT, COL_VIRTUAL_ACCOUNT_NUMBER, COL_ACCOUNT_TYPE, COL_COUNTERPARTY_CRN, COL_ID);

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

    public int insert(Connection conn, FgRuleAls fgruleals) throws SQLException {
        logger.debug("Inserting fgruleals: {}", fgruleals);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgRuleAlsParams(ps, fgruleals);
            ps.executeUpdate();
            return fgruleals.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgRuleAls> fgrulealss) throws SQLException {
        if (fgrulealss == null || fgrulealss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgrulealss.size(); i++) {
            if (fgrulealss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRuleAls>> batches = chunkList(fgrulealss, batchSize);
        int[] totalResults = new int[fgrulealss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRuleAls> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgRuleAls fgruleals : batch) {
                        setFgRuleAlsParams(ps, fgruleals);
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

    public FgRuleAls findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgRuleAls> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgRuleAls> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgRuleAls fgruleals) throws SQLException {
        if (fgruleals.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgRuleAlsParams(ps, fgruleals);
            ps.setInt(33, fgruleals.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgRuleAls> fgrulealss) throws SQLException {
        if (fgrulealss == null || fgrulealss.isEmpty())
            return new int[0];
        for (FgRuleAls fgruleals : fgrulealss) {
            if (fgruleals == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgruleals.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRuleAls>> batches = chunkList(fgrulealss, batchSize);
        int[] totalResults = new int[fgrulealss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRuleAls> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgRuleAls fgruleals : batch) {
                        setFgRuleAlsParams(ps, fgruleals);
                        ps.setInt(33, fgruleals.getID());
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

    private void setFgRuleAlsParams(PreparedStatement ps, FgRuleAls fgruleals) throws SQLException {
        Integer val1 = fgruleals.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgruleals.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgruleals.getTypeCode());
        ps.setString(4, fgruleals.getSubTypeCode());
        ps.setString(5, fgruleals.getActiveCode());
        ps.setString(6, fgruleals.getStageCode());
        ps.setString(7, fgruleals.getStatusCode());
        ps.setString(8, fgruleals.getCreatedOn());
        java.math.BigDecimal val9 = fgruleals.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgruleals.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgruleals.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgruleals.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgruleals.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgruleals.getTemplate());
        java.math.BigDecimal val15 = fgruleals.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgruleals.getVersionID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        java.math.BigDecimal val17 = fgruleals.getIsMasterVersion();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgruleals.getCustomerCrn());
        ps.setString(19, fgruleals.getAccountNumber());
        ps.setString(20, fgruleals.getProductCode());
        ps.setString(21, fgruleals.getLogicOfSettlement());
        java.math.BigDecimal val22 = fgruleals.getMaxSettlementPercentage();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgruleals.getMaxSettlementAmount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgruleals.getRepaymentAction());
        ps.setString(25, fgruleals.getStatus());
        ps.setString(26, fgruleals.getDebitLock());
        Integer val27 = fgruleals.getProcessID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgruleals.getSlotReference());
        ps.setString(29, fgruleals.getCustomerName());
        ps.setString(30, fgruleals.getMonthendSlot());
        ps.setString(31, fgruleals.getVirtualAccountNumber());
        ps.setString(32, fgruleals.getAccountType());
        ps.setString(33, fgruleals.getCounterpartyCrn());
    }

    private FgRuleAls extract(ResultSet rs) throws SQLException {
        FgRuleAls fgruleals = new FgRuleAls();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgruleals.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgruleals.setReferenceID(REFERENCE_ID);
        fgruleals.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgruleals.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgruleals.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgruleals.setStageCode(rs.getString(COL_STAGE_CODE));
        fgruleals.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgruleals.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgruleals.setCreatedBy(CREATED_BY);
        fgruleals.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgruleals.setLastUpdatedBy(LAST_UPDATED_BY);
        fgruleals.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgruleals.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgruleals.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgruleals.setIsTemplate(IS_TEMPLATE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgruleals.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgruleals.setIsMasterVersion(IS_MASTER_VERSION);
        fgruleals.setCustomerCrn(rs.getString(COL_CUSTOMER_CRN));
        fgruleals.setAccountNumber(rs.getString(COL_ACCOUNT_NUMBER));
        fgruleals.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgruleals.setLogicOfSettlement(rs.getString(COL_LOGIC_OF_SETTLEMENT));
        java.math.BigDecimal MAX_SETTLEMENT_PERCENTAGE = rs.getObject(COL_MAX_SETTLEMENT_PERCENTAGE, java.math.BigDecimal.class);
        fgruleals.setMaxSettlementPercentage(MAX_SETTLEMENT_PERCENTAGE);
        java.math.BigDecimal MAX_SETTLEMENT_AMOUNT = rs.getObject(COL_MAX_SETTLEMENT_AMOUNT, java.math.BigDecimal.class);
        fgruleals.setMaxSettlementAmount(MAX_SETTLEMENT_AMOUNT);
        fgruleals.setRepaymentAction(rs.getString(COL_REPAYMENT_ACTION));
        fgruleals.setStatus(rs.getString(COL_STATUS));
        fgruleals.setDebitLock(rs.getString(COL_DEBIT_LOCK));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgruleals.setProcessID(PROCESS_ID);
        fgruleals.setSlotReference(rs.getString(COL_SLOT_REFERENCE));
        fgruleals.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        fgruleals.setMonthendSlot(rs.getString(COL_MONTHEND_SLOT));
        fgruleals.setVirtualAccountNumber(rs.getString(COL_VIRTUAL_ACCOUNT_NUMBER));
        fgruleals.setAccountType(rs.getString(COL_ACCOUNT_TYPE));
        fgruleals.setCounterpartyCrn(rs.getString(COL_COUNTERPARTY_CRN));
        return fgruleals;
    }
}
