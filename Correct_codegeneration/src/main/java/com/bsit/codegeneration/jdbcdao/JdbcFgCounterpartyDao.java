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

public class JdbcFgCounterpartyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgCounterpartyDao.class);

    private static final String TABLE = "FG_COUNTERPARTY";

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

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ABBV_NAME = "ABBV_NAME";

    private static final String COL_NAME = "NAME";

    private static final String COL_CUSTOMER_ROLE = "CUSTOMER_ROLE";

    private static final String COL_INPUT_BRANCH = "INPUT_BRANCH";

    private static final String COL_BEHALF_OF_BRANCH = "BEHALF_OF_BRANCH";

    private static final String COL_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static final String COL_IFSC_CODE = "IFSC_CODE";

    private static final String COL_BANK_NAME = "BANK_NAME";

    private static final String COL_LIMIT_NODE_1 = "LIMIT_NODE_1";

    private static final String COL_PAYMENT_TYPE = "PAYMENT_TYPE";

    private static final String COL_INT_BEARING_PARTY = "INT_BEARING_PARTY";

    private static final String COL_DEBIT_PARTY = "DEBIT_PARTY";

    private static final String COL_INT_TYPE = "INT_TYPE";

    private static final String COL_BASE_CODE = "BASE_CODE";

    private static final String COL_PENEL_SPREAD = "PENEL_SPREAD";

    private static final String COL_CP_ABBV_NAME = "CP_ABBV_NAME";

    private static final String COL_CP_NAME = "CP_NAME";

    private static final String COL_CP_CODE = "CP_CODE";

    private static final String COL_CP_ROLE = "CP_ROLE";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_GRACE_PERIOD = "GRACE_PERIOD";

    private static final String COL_LIMIT_NODE_2 = "LIMIT_NODE_2";

    private static final String COL_MARGIN_RATE = "MARGIN_RATE";

    private static final String COL_SPREAD_RATE = "SPREAD_RATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_INTEREST_RATE = "INTEREST_RATE";

    private static final String COL_RATE_TYPE = "RATE_TYPE";

    private static final String COL_DEBIT_PARTY_CRN = "DEBIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_CRN = "CREDIT_PARTY_CRN";

    private static final String COL_CREDIT_PARTY_NAME = "CREDIT_PARTY_NAME";

    private static final String COL_BUYER_ID = "BUYER_ID";

    private static final String COL_SELLER_ID = "SELLER_ID";

    private static final String COL_CP_STATUS = "CP_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ABBV_NAME, COL_NAME, COL_CUSTOMER_ROLE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_ACCOUNT_NUMBER, COL_IFSC_CODE, COL_BANK_NAME, COL_LIMIT_NODE_1, COL_PAYMENT_TYPE, COL_INT_BEARING_PARTY, COL_DEBIT_PARTY, COL_INT_TYPE, COL_BASE_CODE, COL_PENEL_SPREAD, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE_2, COL_MARGIN_RATE, COL_SPREAD_RATE, COL_UPLOAD_REF_ID, COL_INTEREST_RATE, COL_RATE_TYPE, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_BUYER_ID, COL_SELLER_ID, COL_CP_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, BUYER_ID, SELLER_ID, CP_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, BUYER_ID, SELLER_ID, CP_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY_CODE, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_ABBV_NAME, COL_NAME, COL_CUSTOMER_ROLE, COL_INPUT_BRANCH, COL_BEHALF_OF_BRANCH, COL_ACCOUNT_NUMBER, COL_IFSC_CODE, COL_BANK_NAME, COL_LIMIT_NODE_1, COL_PAYMENT_TYPE, COL_INT_BEARING_PARTY, COL_DEBIT_PARTY, COL_INT_TYPE, COL_BASE_CODE, COL_PENEL_SPREAD, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_PRODUCT_TYPE, COL_GRACE_PERIOD, COL_LIMIT_NODE_2, COL_MARGIN_RATE, COL_SPREAD_RATE, COL_UPLOAD_REF_ID, COL_INTEREST_RATE, COL_RATE_TYPE, COL_DEBIT_PARTY_CRN, COL_CREDIT_PARTY_CRN, COL_CREDIT_PARTY_NAME, COL_BUYER_ID, COL_SELLER_ID, COL_CP_STATUS, COL_ID);

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

    public int insert(Connection conn, FgCounterparty fgcounterparty) throws SQLException {
        logger.debug("Inserting fgcounterparty: {}", fgcounterparty);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgCounterpartyParams(ps, fgcounterparty);
            ps.executeUpdate();
            return fgcounterparty.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgCounterparty> fgcounterpartys) throws SQLException {
        if (fgcounterpartys == null || fgcounterpartys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgcounterpartys.size(); i++) {
            if (fgcounterpartys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCounterparty>> batches = chunkList(fgcounterpartys, batchSize);
        int[] totalResults = new int[fgcounterpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCounterparty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgCounterparty fgcounterparty : batch) {
                        setFgCounterpartyParams(ps, fgcounterparty);
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

    public FgCounterparty findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgCounterparty> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgCounterparty> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgCounterparty fgcounterparty) throws SQLException {
        if (fgcounterparty.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgCounterpartyParams(ps, fgcounterparty);
            ps.setInt(51, fgcounterparty.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgCounterparty> fgcounterpartys) throws SQLException {
        if (fgcounterpartys == null || fgcounterpartys.isEmpty())
            return new int[0];
        for (FgCounterparty fgcounterparty : fgcounterpartys) {
            if (fgcounterparty == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgcounterparty.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgCounterparty>> batches = chunkList(fgcounterpartys, batchSize);
        int[] totalResults = new int[fgcounterpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgCounterparty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgCounterparty fgcounterparty : batch) {
                        setFgCounterpartyParams(ps, fgcounterparty);
                        ps.setInt(51, fgcounterparty.getID());
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

    private void setFgCounterpartyParams(PreparedStatement ps, FgCounterparty fgcounterparty) throws SQLException {
        Integer val1 = fgcounterparty.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgcounterparty.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgcounterparty.getTypeCode());
        ps.setString(4, fgcounterparty.getSubTypeCode());
        ps.setString(5, fgcounterparty.getActiveCode());
        ps.setString(6, fgcounterparty.getStageCode());
        ps.setString(7, fgcounterparty.getStatusCode());
        Integer val8 = fgcounterparty.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgcounterparty.getCreatedOn());
        java.math.BigDecimal val10 = fgcounterparty.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgcounterparty.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgcounterparty.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgcounterparty.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgcounterparty.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgcounterparty.getTemplate());
        ps.setString(16, fgcounterparty.getApplicantPartyCode());
        ps.setString(17, fgcounterparty.getFulfillmentParty());
        java.math.BigDecimal val18 = fgcounterparty.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgcounterparty.getAbbvName());
        ps.setString(20, fgcounterparty.getName());
        ps.setString(21, fgcounterparty.getCustomerRole());
        ps.setString(22, fgcounterparty.getInputBranch());
        ps.setString(23, fgcounterparty.getBehalfOfBranch());
        ps.setString(24, fgcounterparty.getAccountNumber());
        ps.setString(25, fgcounterparty.getIfscCode());
        ps.setString(26, fgcounterparty.getBankName());
        ps.setString(27, fgcounterparty.getLimitNode1());
        ps.setString(28, fgcounterparty.getPaymentType());
        ps.setString(29, fgcounterparty.getIntBearingParty());
        ps.setString(30, fgcounterparty.getDebitParty());
        ps.setString(31, fgcounterparty.getIntType());
        ps.setString(32, fgcounterparty.getBaseCode());
        ps.setString(33, fgcounterparty.getPenelSpread());
        ps.setString(34, fgcounterparty.getCpAbbvName());
        ps.setString(35, fgcounterparty.getCpName());
        ps.setString(36, fgcounterparty.getCpCode());
        ps.setString(37, fgcounterparty.getCpRole());
        ps.setString(38, fgcounterparty.getProductType());
        java.math.BigDecimal val39 = fgcounterparty.getGracePeriod();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgcounterparty.getLimitNode2());
        java.math.BigDecimal val41 = fgcounterparty.getMarginRate();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        java.math.BigDecimal val42 = fgcounterparty.getSpreadRate();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        Integer val43 = fgcounterparty.getUploadRefID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        java.math.BigDecimal val44 = fgcounterparty.getInterestRate();
        if (val44 != null) {
            ps.setBigDecimal(44, val44);
        } else {
            ps.setNull(44, Types.DECIMAL);
        }
        java.math.BigDecimal val45 = fgcounterparty.getRateType();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        ps.setString(46, fgcounterparty.getDebitPartyCrn());
        ps.setString(47, fgcounterparty.getCreditPartyCrn());
        ps.setString(48, fgcounterparty.getCreditPartyName());
        Integer val49 = fgcounterparty.getBuyerID();
        if (val49 != null) {
            ps.setInt(49, val49);
        } else {
            ps.setNull(49, Types.INTEGER);
        }
        Integer val50 = fgcounterparty.getSellerID();
        if (val50 != null) {
            ps.setInt(50, val50);
        } else {
            ps.setNull(50, Types.INTEGER);
        }
        ps.setString(51, fgcounterparty.getCpStatus());
    }

    private FgCounterparty extract(ResultSet rs) throws SQLException {
        FgCounterparty fgcounterparty = new FgCounterparty();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgcounterparty.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgcounterparty.setReferenceID(REFERENCE_ID);
        fgcounterparty.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgcounterparty.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgcounterparty.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgcounterparty.setStageCode(rs.getString(COL_STAGE_CODE));
        fgcounterparty.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgcounterparty.setProcessID(PROCESS_ID);
        fgcounterparty.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgcounterparty.setCreatedBy(CREATED_BY);
        fgcounterparty.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgcounterparty.setLastUpdatedBy(LAST_UPDATED_BY);
        fgcounterparty.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgcounterparty.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgcounterparty.setTemplate(rs.getString(COL_TEMPLATE));
        fgcounterparty.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgcounterparty.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgcounterparty.setIsTemplate(IS_TEMPLATE);
        fgcounterparty.setAbbvName(rs.getString(COL_ABBV_NAME));
        fgcounterparty.setName(rs.getString(COL_NAME));
        fgcounterparty.setCustomerRole(rs.getString(COL_CUSTOMER_ROLE));
        fgcounterparty.setInputBranch(rs.getString(COL_INPUT_BRANCH));
        fgcounterparty.setBehalfOfBranch(rs.getString(COL_BEHALF_OF_BRANCH));
        fgcounterparty.setAccountNumber(rs.getString(COL_ACCOUNT_NUMBER));
        fgcounterparty.setIfscCode(rs.getString(COL_IFSC_CODE));
        fgcounterparty.setBankName(rs.getString(COL_BANK_NAME));
        fgcounterparty.setLimitNode1(rs.getString(COL_LIMIT_NODE_1));
        fgcounterparty.setPaymentType(rs.getString(COL_PAYMENT_TYPE));
        fgcounterparty.setIntBearingParty(rs.getString(COL_INT_BEARING_PARTY));
        fgcounterparty.setDebitParty(rs.getString(COL_DEBIT_PARTY));
        fgcounterparty.setIntType(rs.getString(COL_INT_TYPE));
        fgcounterparty.setBaseCode(rs.getString(COL_BASE_CODE));
        fgcounterparty.setPenelSpread(rs.getString(COL_PENEL_SPREAD));
        fgcounterparty.setCpAbbvName(rs.getString(COL_CP_ABBV_NAME));
        fgcounterparty.setCpName(rs.getString(COL_CP_NAME));
        fgcounterparty.setCpCode(rs.getString(COL_CP_CODE));
        fgcounterparty.setCpRole(rs.getString(COL_CP_ROLE));
        fgcounterparty.setProductType(rs.getString(COL_PRODUCT_TYPE));
        java.math.BigDecimal GRACE_PERIOD = rs.getObject(COL_GRACE_PERIOD, java.math.BigDecimal.class);
        fgcounterparty.setGracePeriod(GRACE_PERIOD);
        fgcounterparty.setLimitNode2(rs.getString(COL_LIMIT_NODE_2));
        java.math.BigDecimal MARGIN_RATE = rs.getObject(COL_MARGIN_RATE, java.math.BigDecimal.class);
        fgcounterparty.setMarginRate(MARGIN_RATE);
        java.math.BigDecimal SPREAD_RATE = rs.getObject(COL_SPREAD_RATE, java.math.BigDecimal.class);
        fgcounterparty.setSpreadRate(SPREAD_RATE);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgcounterparty.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal INTEREST_RATE = rs.getObject(COL_INTEREST_RATE, java.math.BigDecimal.class);
        fgcounterparty.setInterestRate(INTEREST_RATE);
        java.math.BigDecimal RATE_TYPE = rs.getObject(COL_RATE_TYPE, java.math.BigDecimal.class);
        fgcounterparty.setRateType(RATE_TYPE);
        fgcounterparty.setDebitPartyCrn(rs.getString(COL_DEBIT_PARTY_CRN));
        fgcounterparty.setCreditPartyCrn(rs.getString(COL_CREDIT_PARTY_CRN));
        fgcounterparty.setCreditPartyName(rs.getString(COL_CREDIT_PARTY_NAME));
        Integer BUYER_ID = rs.getObject(COL_BUYER_ID, Integer.class);
        fgcounterparty.setBuyerID(BUYER_ID);
        Integer SELLER_ID = rs.getObject(COL_SELLER_ID, Integer.class);
        fgcounterparty.setSellerID(SELLER_ID);
        fgcounterparty.setCpStatus(rs.getString(COL_CP_STATUS));
        return fgcounterparty;
    }
}
