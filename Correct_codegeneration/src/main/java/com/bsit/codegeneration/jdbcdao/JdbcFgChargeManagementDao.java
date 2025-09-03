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

public class JdbcFgChargeManagementDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgChargeManagementDao.class);

    private static final String TABLE = "FG_CHARGE_MANAGEMENT";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_CHARGE_TYPE_CODE = "CHARGE_TYPE_CODE";

    private static final String COL_CHARGE_STATUS_CODE = "CHARGE_STATUS_CODE";

    private static final String COL_CHARGE_CODE = "CHARGE_CODE";

    private static final String COL_CURRENCY_CODE = "CURRENCY_CODE";

    private static final String COL_TAX_CODE = "TAX_CODE";

    private static final String COL_CHARGE_BASIS_CODE = "CHARGE_BASIS_CODE";

    private static final String COL_IS_RECURRING = "IS_RECURRING";

    private static final String COL_VALID_FROM = "VALID_FROM";

    private static final String COL_VALID_TO = "VALID_TO";

    private static final String COL_CHARGE_AMOUNT = "CHARGE_AMOUNT";

    private static final String COL_UOM_CODE = "UOM_CODE";

    private static final String COL_LIMIT_AMOUNT = "LIMIT_AMOUNT";

    private static final String COL_FREE_LIMIT = "FREE_LIMIT";

    private static final String COL_LIMIT_PERIOD_CODE = "LIMIT_PERIOD_CODE";

    private static final String COL_CHARGE_PERCENTAGE = "CHARGE_PERCENTAGE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_VERSION_ID, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PRODUCT_CODE, COL_EVENT_CODE, COL_CATEGORY_CODE, COL_CHARGE_TYPE_CODE, COL_CHARGE_STATUS_CODE, COL_CHARGE_CODE, COL_CURRENCY_CODE, COL_TAX_CODE, COL_CHARGE_BASIS_CODE, COL_IS_RECURRING, COL_VALID_FROM, COL_VALID_TO, COL_CHARGE_AMOUNT, COL_UOM_CODE, COL_LIMIT_AMOUNT, COL_FREE_LIMIT, COL_LIMIT_PERIOD_CODE, COL_CHARGE_PERCENTAGE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, PRODUCT_CODE, EVENT_CODE, CATEGORY_CODE, CHARGE_TYPE_CODE, CHARGE_STATUS_CODE, CHARGE_CODE, CURRENCY_CODE, TAX_CODE, CHARGE_BASIS_CODE, IS_RECURRING, VALID_FROM, VALID_TO, CHARGE_AMOUNT, UOM_CODE, LIMIT_AMOUNT, FREE_LIMIT, LIMIT_PERIOD_CODE, CHARGE_PERCENTAGE, STATUS_CODE, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, PRODUCT_CODE, EVENT_CODE, CATEGORY_CODE, CHARGE_TYPE_CODE, CHARGE_STATUS_CODE, CHARGE_CODE, CURRENCY_CODE, TAX_CODE, CHARGE_BASIS_CODE, IS_RECURRING, VALID_FROM, VALID_TO, CHARGE_AMOUNT, UOM_CODE, LIMIT_AMOUNT, FREE_LIMIT, LIMIT_PERIOD_CODE, CHARGE_PERCENTAGE, STATUS_CODE, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_VERSION_ID, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PRODUCT_CODE, COL_EVENT_CODE, COL_CATEGORY_CODE, COL_CHARGE_TYPE_CODE, COL_CHARGE_STATUS_CODE, COL_CHARGE_CODE, COL_CURRENCY_CODE, COL_TAX_CODE, COL_CHARGE_BASIS_CODE, COL_IS_RECURRING, COL_VALID_FROM, COL_VALID_TO, COL_CHARGE_AMOUNT, COL_UOM_CODE, COL_LIMIT_AMOUNT, COL_FREE_LIMIT, COL_LIMIT_PERIOD_CODE, COL_CHARGE_PERCENTAGE, COL_STATUS_CODE, COL_ACTIVE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_ID);

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

    public int insert(Connection conn, FgChargeManagement fgchargemanagement) throws SQLException {
        logger.debug("Inserting fgchargemanagement: {}", fgchargemanagement);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgChargeManagementParams(ps, fgchargemanagement);
            ps.executeUpdate();
            return fgchargemanagement.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgChargeManagement> fgchargemanagements) throws SQLException {
        if (fgchargemanagements == null || fgchargemanagements.isEmpty())
            return new int[0];
        for (int i = 0; i < fgchargemanagements.size(); i++) {
            if (fgchargemanagements.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChargeManagement>> batches = chunkList(fgchargemanagements, batchSize);
        int[] totalResults = new int[fgchargemanagements.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChargeManagement> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgChargeManagement fgchargemanagement : batch) {
                        setFgChargeManagementParams(ps, fgchargemanagement);
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

    public FgChargeManagement findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgChargeManagement> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgChargeManagement> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgChargeManagement fgchargemanagement) throws SQLException {
        if (fgchargemanagement.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgChargeManagementParams(ps, fgchargemanagement);
            ps.setInt(32, fgchargemanagement.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgChargeManagement> fgchargemanagements) throws SQLException {
        if (fgchargemanagements == null || fgchargemanagements.isEmpty())
            return new int[0];
        for (FgChargeManagement fgchargemanagement : fgchargemanagements) {
            if (fgchargemanagement == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgchargemanagement.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgChargeManagement>> batches = chunkList(fgchargemanagements, batchSize);
        int[] totalResults = new int[fgchargemanagements.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgChargeManagement> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgChargeManagement fgchargemanagement : batch) {
                        setFgChargeManagementParams(ps, fgchargemanagement);
                        ps.setInt(32, fgchargemanagement.getID());
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

    private void setFgChargeManagementParams(PreparedStatement ps, FgChargeManagement fgchargemanagement) throws SQLException {
        Integer val1 = fgchargemanagement.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgchargemanagement.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgchargemanagement.getVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgchargemanagement.getPartyCode());
        ps.setString(5, fgchargemanagement.getPartySubTypeCode());
        ps.setString(6, fgchargemanagement.getProductCode());
        ps.setString(7, fgchargemanagement.getEventCode());
        ps.setString(8, fgchargemanagement.getCategoryCode());
        ps.setString(9, fgchargemanagement.getChargeTypeCode());
        ps.setString(10, fgchargemanagement.getChargeStatusCode());
        ps.setString(11, fgchargemanagement.getChargeCode());
        ps.setString(12, fgchargemanagement.getCurrencyCode());
        ps.setString(13, fgchargemanagement.getTaxCode());
        ps.setString(14, fgchargemanagement.getChargeBasisCode());
        java.math.BigDecimal val15 = fgchargemanagement.getIsRecurring();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.time.LocalDateTime val16 = fgchargemanagement.getValidFrom();
        if (val16 != null) {
            ps.setTimestamp(16, java.sql.Timestamp.valueOf(val16));
        } else {
            ps.setNull(16, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val17 = fgchargemanagement.getValidTo();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        java.math.BigDecimal val18 = fgchargemanagement.getChargeAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgchargemanagement.getUomCode());
        java.math.BigDecimal val20 = fgchargemanagement.getLimitAmount();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgchargemanagement.getFreeLimit();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgchargemanagement.getLimitPeriodCode());
        java.math.BigDecimal val23 = fgchargemanagement.getChargePercentage();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgchargemanagement.getStatusCode());
        ps.setString(25, fgchargemanagement.getActiveCode());
        ps.setString(26, fgchargemanagement.getCreatedOn());
        java.math.BigDecimal val27 = fgchargemanagement.getCreatedBy();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgchargemanagement.getLastUpdatedOn());
        java.math.BigDecimal val29 = fgchargemanagement.getLastUpdatedBy();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgchargemanagement.getLastAuthorisedOn());
        java.math.BigDecimal val31 = fgchargemanagement.getLastAuthorisedBy();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, fgchargemanagement.getTemplate());
    }

    private FgChargeManagement extract(ResultSet rs) throws SQLException {
        FgChargeManagement fgchargemanagement = new FgChargeManagement();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgchargemanagement.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgchargemanagement.setReferenceID(REFERENCE_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgchargemanagement.setVersionID(VERSION_ID);
        fgchargemanagement.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgchargemanagement.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgchargemanagement.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgchargemanagement.setEventCode(rs.getString(COL_EVENT_CODE));
        fgchargemanagement.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgchargemanagement.setChargeTypeCode(rs.getString(COL_CHARGE_TYPE_CODE));
        fgchargemanagement.setChargeStatusCode(rs.getString(COL_CHARGE_STATUS_CODE));
        fgchargemanagement.setChargeCode(rs.getString(COL_CHARGE_CODE));
        fgchargemanagement.setCurrencyCode(rs.getString(COL_CURRENCY_CODE));
        fgchargemanagement.setTaxCode(rs.getString(COL_TAX_CODE));
        fgchargemanagement.setChargeBasisCode(rs.getString(COL_CHARGE_BASIS_CODE));
        java.math.BigDecimal IS_RECURRING = rs.getObject(COL_IS_RECURRING, java.math.BigDecimal.class);
        fgchargemanagement.setIsRecurring(IS_RECURRING);
        Timestamp VALID_FROM = rs.getTimestamp(COL_VALID_FROM);
        if (VALID_FROM != null)
            fgchargemanagement.setValidFrom(VALID_FROM.toLocalDateTime());
        Timestamp VALID_TO = rs.getTimestamp(COL_VALID_TO);
        if (VALID_TO != null)
            fgchargemanagement.setValidTo(VALID_TO.toLocalDateTime());
        java.math.BigDecimal CHARGE_AMOUNT = rs.getObject(COL_CHARGE_AMOUNT, java.math.BigDecimal.class);
        fgchargemanagement.setChargeAmount(CHARGE_AMOUNT);
        fgchargemanagement.setUomCode(rs.getString(COL_UOM_CODE));
        java.math.BigDecimal LIMIT_AMOUNT = rs.getObject(COL_LIMIT_AMOUNT, java.math.BigDecimal.class);
        fgchargemanagement.setLimitAmount(LIMIT_AMOUNT);
        java.math.BigDecimal FREE_LIMIT = rs.getObject(COL_FREE_LIMIT, java.math.BigDecimal.class);
        fgchargemanagement.setFreeLimit(FREE_LIMIT);
        fgchargemanagement.setLimitPeriodCode(rs.getString(COL_LIMIT_PERIOD_CODE));
        java.math.BigDecimal CHARGE_PERCENTAGE = rs.getObject(COL_CHARGE_PERCENTAGE, java.math.BigDecimal.class);
        fgchargemanagement.setChargePercentage(CHARGE_PERCENTAGE);
        fgchargemanagement.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgchargemanagement.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgchargemanagement.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgchargemanagement.setCreatedBy(CREATED_BY);
        fgchargemanagement.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgchargemanagement.setLastUpdatedBy(LAST_UPDATED_BY);
        fgchargemanagement.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgchargemanagement.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgchargemanagement.setTemplate(rs.getString(COL_TEMPLATE));
        return fgchargemanagement;
    }
}
