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

public class JdbcKmblScfCounterpartyRelDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcKmblScfCounterpartyRelDao.class);

    private static final String TABLE = "KMBL_SCF_COUNTERPARTY_REL";

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

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_CP_ABBV_NAME = "CP_ABBV_NAME";

    private static final String COL_CP_NAME = "CP_NAME";

    private static final String COL_CP_CODE = "CP_CODE";

    private static final String COL_CP_ROLE = "CP_ROLE";

    private static final String COL_CP_RATE_TYPE = "CP_RATE_TYPE";

    private static final String COL_CP_LIMIT_NODE_2 = "CP_LIMIT_NODE_2";

    private static final String COL_CP_ACCOUNT_NUMBER = "CP_ACCOUNT_NUMBER";

    private static final String COL_CP_IFSC_CODE = "CP_IFSC_CODE";

    private static final String COL_CP_BANK_NAME = "CP_BANK_NAME";

    private static final String COL_CP_PAYMENT_TYPE = "CP_PAYMENT_TYPE";

    private static final String COL_CP_INT_TYPE = "CP_INT_TYPE";

    private static final String COL_CP_PENAL_SPREAD = "CP_PENAL_SPREAD";

    private static final String COL_CP_BASE_CODE = "CP_BASE_CODE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_DISPLAY_STATUS = "DISPLAY_STATUS";

    private static final String COL_INT_BEARING_PARTY = "INT_BEARING_PARTY";

    private static final String COL_ABBV_NAME = "ABBV_NAME";

    private static final String COL_CUSTOMER_ROLE = "CUSTOMER_ROLE";

    private static final String COL_PRODUCT_TYPE = "PRODUCT_TYPE";

    private static final String COL_LAYOUT_NAME = "LAYOUT_NAME";

    private static final String COL_PORTAL_REF_ID = "PORTAL_REF_ID";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_CP_GRACE_PERIOD = "CP_GRACE_PERIOD";

    private static final String COL_CP_SPREAD_RATE = "CP_SPREAD_RATE";

    private static final String COL_CP_MARGIN_RATE = "CP_MARGIN_RATE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_DMS_EVENT_ID = "DMS_EVENT_ID";

    private static final String COL_CP_BENE_LEI = "CP_BENE_LEI";

    private static final String COL_REQUEST_INITIATION_TYPE = "REQUEST_INITIATION_TYPE";

    private static final String COL_PROGRAM_LAYOUT_NAME = "PROGRAM_LAYOUT_NAME";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_CP_RATE_TYPE, COL_CP_LIMIT_NODE_2, COL_CP_ACCOUNT_NUMBER, COL_CP_IFSC_CODE, COL_CP_BANK_NAME, COL_CP_PAYMENT_TYPE, COL_CP_INT_TYPE, COL_CP_PENAL_SPREAD, COL_CP_BASE_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_DISPLAY_STATUS, COL_INT_BEARING_PARTY, COL_ABBV_NAME, COL_CUSTOMER_ROLE, COL_PRODUCT_TYPE, COL_LAYOUT_NAME, COL_PORTAL_REF_ID, COL_TASK_REASON, COL_CP_GRACE_PERIOD, COL_CP_SPREAD_RATE, COL_CP_MARGIN_RATE, COL_UPLOAD_REF_ID, COL_DMS_EVENT_ID, COL_CP_BENE_LEI, COL_REQUEST_INITIATION_TYPE, COL_PROGRAM_LAYOUT_NAME, COL_LAYOUT_ID, COL_LAYOUT_UUID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, CP_RATE_TYPE, CP_LIMIT_NODE_2, CP_ACCOUNT_NUMBER, CP_IFSC_CODE, CP_BANK_NAME, CP_PAYMENT_TYPE, CP_INT_TYPE, CP_PENAL_SPREAD, CP_BASE_CODE, VERSION_ID, IS_MASTER_VERSION, DISPLAY_STATUS, INT_BEARING_PARTY, ABBV_NAME, CUSTOMER_ROLE, PRODUCT_TYPE, LAYOUT_NAME, PORTAL_REF_ID, TASK_REASON, CP_GRACE_PERIOD, CP_SPREAD_RATE, CP_MARGIN_RATE, UPLOAD_REF_ID, DMS_EVENT_ID, CP_BENE_LEI, REQUEST_INITIATION_TYPE, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, CP_RATE_TYPE, CP_LIMIT_NODE_2, CP_ACCOUNT_NUMBER, CP_IFSC_CODE, CP_BANK_NAME, CP_PAYMENT_TYPE, CP_INT_TYPE, CP_PENAL_SPREAD, CP_BASE_CODE, VERSION_ID, IS_MASTER_VERSION, DISPLAY_STATUS, INT_BEARING_PARTY, ABBV_NAME, CUSTOMER_ROLE, PRODUCT_TYPE, LAYOUT_NAME, PORTAL_REF_ID, TASK_REASON, CP_GRACE_PERIOD, CP_SPREAD_RATE, CP_MARGIN_RATE, UPLOAD_REF_ID, DMS_EVENT_ID, CP_BENE_LEI, REQUEST_INITIATION_TYPE, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CP_ABBV_NAME, COL_CP_NAME, COL_CP_CODE, COL_CP_ROLE, COL_CP_RATE_TYPE, COL_CP_LIMIT_NODE_2, COL_CP_ACCOUNT_NUMBER, COL_CP_IFSC_CODE, COL_CP_BANK_NAME, COL_CP_PAYMENT_TYPE, COL_CP_INT_TYPE, COL_CP_PENAL_SPREAD, COL_CP_BASE_CODE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_DISPLAY_STATUS, COL_INT_BEARING_PARTY, COL_ABBV_NAME, COL_CUSTOMER_ROLE, COL_PRODUCT_TYPE, COL_LAYOUT_NAME, COL_PORTAL_REF_ID, COL_TASK_REASON, COL_CP_GRACE_PERIOD, COL_CP_SPREAD_RATE, COL_CP_MARGIN_RATE, COL_UPLOAD_REF_ID, COL_DMS_EVENT_ID, COL_CP_BENE_LEI, COL_REQUEST_INITIATION_TYPE, COL_PROGRAM_LAYOUT_NAME, COL_LAYOUT_ID, COL_LAYOUT_UUID, COL_ID);

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

    public int insert(Connection conn, KmblScfCounterpartyRel kmblscfcounterpartyrel) throws SQLException {
        logger.debug("Inserting kmblscfcounterpartyrel: {}", kmblscfcounterpartyrel);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setKmblScfCounterpartyRelParams(ps, kmblscfcounterpartyrel);
            ps.executeUpdate();
            return kmblscfcounterpartyrel.getID();
        }
    }

    public int[] insertAll(Connection conn, List<KmblScfCounterpartyRel> kmblscfcounterpartyrels) throws SQLException {
        if (kmblscfcounterpartyrels == null || kmblscfcounterpartyrels.isEmpty())
            return new int[0];
        for (int i = 0; i < kmblscfcounterpartyrels.size(); i++) {
            if (kmblscfcounterpartyrels.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfCounterpartyRel>> batches = chunkList(kmblscfcounterpartyrels, batchSize);
        int[] totalResults = new int[kmblscfcounterpartyrels.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfCounterpartyRel> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (KmblScfCounterpartyRel kmblscfcounterpartyrel : batch) {
                        setKmblScfCounterpartyRelParams(ps, kmblscfcounterpartyrel);
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

    public KmblScfCounterpartyRel findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<KmblScfCounterpartyRel> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<KmblScfCounterpartyRel> list = new ArrayList<>();
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

    public boolean update(Connection conn, KmblScfCounterpartyRel kmblscfcounterpartyrel) throws SQLException {
        if (kmblscfcounterpartyrel.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setKmblScfCounterpartyRelParams(ps, kmblscfcounterpartyrel);
            ps.setInt(49, kmblscfcounterpartyrel.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<KmblScfCounterpartyRel> kmblscfcounterpartyrels) throws SQLException {
        if (kmblscfcounterpartyrels == null || kmblscfcounterpartyrels.isEmpty())
            return new int[0];
        for (KmblScfCounterpartyRel kmblscfcounterpartyrel : kmblscfcounterpartyrels) {
            if (kmblscfcounterpartyrel == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (kmblscfcounterpartyrel.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<KmblScfCounterpartyRel>> batches = chunkList(kmblscfcounterpartyrels, batchSize);
        int[] totalResults = new int[kmblscfcounterpartyrels.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<KmblScfCounterpartyRel> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (KmblScfCounterpartyRel kmblscfcounterpartyrel : batch) {
                        setKmblScfCounterpartyRelParams(ps, kmblscfcounterpartyrel);
                        ps.setInt(49, kmblscfcounterpartyrel.getID());
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

    private void setKmblScfCounterpartyRelParams(PreparedStatement ps, KmblScfCounterpartyRel kmblscfcounterpartyrel) throws SQLException {
        Integer val1 = kmblscfcounterpartyrel.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = kmblscfcounterpartyrel.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, kmblscfcounterpartyrel.getTypeCode());
        ps.setString(4, kmblscfcounterpartyrel.getSubTypeCode());
        ps.setString(5, kmblscfcounterpartyrel.getActiveCode());
        ps.setString(6, kmblscfcounterpartyrel.getStageCode());
        ps.setString(7, kmblscfcounterpartyrel.getStatusCode());
        Integer val8 = kmblscfcounterpartyrel.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, kmblscfcounterpartyrel.getCreatedOn());
        java.math.BigDecimal val10 = kmblscfcounterpartyrel.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, kmblscfcounterpartyrel.getLastUpdatedOn());
        java.math.BigDecimal val12 = kmblscfcounterpartyrel.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, kmblscfcounterpartyrel.getLastAuthorisedOn());
        java.math.BigDecimal val14 = kmblscfcounterpartyrel.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, kmblscfcounterpartyrel.getTemplate());
        java.math.BigDecimal val16 = kmblscfcounterpartyrel.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, kmblscfcounterpartyrel.getCpAbbvName());
        ps.setString(18, kmblscfcounterpartyrel.getCpName());
        ps.setString(19, kmblscfcounterpartyrel.getCpCode());
        ps.setString(20, kmblscfcounterpartyrel.getCpRole());
        java.math.BigDecimal val21 = kmblscfcounterpartyrel.getCpRateType();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, kmblscfcounterpartyrel.getCpLimitNode2());
        ps.setString(23, kmblscfcounterpartyrel.getCpAccountNumber());
        ps.setString(24, kmblscfcounterpartyrel.getCpIfscCode());
        ps.setString(25, kmblscfcounterpartyrel.getCpBankName());
        ps.setString(26, kmblscfcounterpartyrel.getCpPaymentType());
        ps.setString(27, kmblscfcounterpartyrel.getCpIntType());
        ps.setString(28, kmblscfcounterpartyrel.getCpPenalSpread());
        ps.setString(29, kmblscfcounterpartyrel.getCpBaseCode());
        Integer val30 = kmblscfcounterpartyrel.getVersionID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        java.math.BigDecimal val31 = kmblscfcounterpartyrel.getIsMasterVersion();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
        ps.setString(32, kmblscfcounterpartyrel.getDisplayStatus());
        ps.setString(33, kmblscfcounterpartyrel.getIntBearingParty());
        ps.setString(34, kmblscfcounterpartyrel.getAbbvName());
        ps.setString(35, kmblscfcounterpartyrel.getCustomerRole());
        ps.setString(36, kmblscfcounterpartyrel.getProductType());
        ps.setString(37, kmblscfcounterpartyrel.getLayoutName());
        Integer val38 = kmblscfcounterpartyrel.getPortalRefID();
        if (val38 != null) {
            ps.setInt(38, val38);
        } else {
            ps.setNull(38, Types.INTEGER);
        }
        ps.setString(39, kmblscfcounterpartyrel.getTaskReason());
        java.math.BigDecimal val40 = kmblscfcounterpartyrel.getCpGracePeriod();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        java.math.BigDecimal val41 = kmblscfcounterpartyrel.getCpSpreadRate();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        java.math.BigDecimal val42 = kmblscfcounterpartyrel.getCpMarginRate();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        Integer val43 = kmblscfcounterpartyrel.getUploadRefID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        Integer val44 = kmblscfcounterpartyrel.getDmsEventID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        ps.setString(45, kmblscfcounterpartyrel.getCpBeneLei());
        ps.setString(46, kmblscfcounterpartyrel.getRequestInitiationType());
        ps.setString(47, kmblscfcounterpartyrel.getProgramLayoutName());
        Integer val48 = kmblscfcounterpartyrel.getLayoutID();
        if (val48 != null) {
            ps.setInt(48, val48);
        } else {
            ps.setNull(48, Types.INTEGER);
        }
        ps.setString(49, kmblscfcounterpartyrel.getLayoutUuid());
    }

    private KmblScfCounterpartyRel extract(ResultSet rs) throws SQLException {
        KmblScfCounterpartyRel kmblscfcounterpartyrel = new KmblScfCounterpartyRel();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        kmblscfcounterpartyrel.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        kmblscfcounterpartyrel.setReferenceID(REFERENCE_ID);
        kmblscfcounterpartyrel.setTypeCode(rs.getString(COL_TYPE_CODE));
        kmblscfcounterpartyrel.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        kmblscfcounterpartyrel.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        kmblscfcounterpartyrel.setStageCode(rs.getString(COL_STAGE_CODE));
        kmblscfcounterpartyrel.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        kmblscfcounterpartyrel.setProcessID(PROCESS_ID);
        kmblscfcounterpartyrel.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setCreatedBy(CREATED_BY);
        kmblscfcounterpartyrel.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setLastUpdatedBy(LAST_UPDATED_BY);
        kmblscfcounterpartyrel.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        kmblscfcounterpartyrel.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setIsTemplate(IS_TEMPLATE);
        kmblscfcounterpartyrel.setCpAbbvName(rs.getString(COL_CP_ABBV_NAME));
        kmblscfcounterpartyrel.setCpName(rs.getString(COL_CP_NAME));
        kmblscfcounterpartyrel.setCpCode(rs.getString(COL_CP_CODE));
        kmblscfcounterpartyrel.setCpRole(rs.getString(COL_CP_ROLE));
        java.math.BigDecimal CP_RATE_TYPE = rs.getObject(COL_CP_RATE_TYPE, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setCpRateType(CP_RATE_TYPE);
        kmblscfcounterpartyrel.setCpLimitNode2(rs.getString(COL_CP_LIMIT_NODE_2));
        kmblscfcounterpartyrel.setCpAccountNumber(rs.getString(COL_CP_ACCOUNT_NUMBER));
        kmblscfcounterpartyrel.setCpIfscCode(rs.getString(COL_CP_IFSC_CODE));
        kmblscfcounterpartyrel.setCpBankName(rs.getString(COL_CP_BANK_NAME));
        kmblscfcounterpartyrel.setCpPaymentType(rs.getString(COL_CP_PAYMENT_TYPE));
        kmblscfcounterpartyrel.setCpIntType(rs.getString(COL_CP_INT_TYPE));
        kmblscfcounterpartyrel.setCpPenalSpread(rs.getString(COL_CP_PENAL_SPREAD));
        kmblscfcounterpartyrel.setCpBaseCode(rs.getString(COL_CP_BASE_CODE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        kmblscfcounterpartyrel.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setIsMasterVersion(IS_MASTER_VERSION);
        kmblscfcounterpartyrel.setDisplayStatus(rs.getString(COL_DISPLAY_STATUS));
        kmblscfcounterpartyrel.setIntBearingParty(rs.getString(COL_INT_BEARING_PARTY));
        kmblscfcounterpartyrel.setAbbvName(rs.getString(COL_ABBV_NAME));
        kmblscfcounterpartyrel.setCustomerRole(rs.getString(COL_CUSTOMER_ROLE));
        kmblscfcounterpartyrel.setProductType(rs.getString(COL_PRODUCT_TYPE));
        kmblscfcounterpartyrel.setLayoutName(rs.getString(COL_LAYOUT_NAME));
        Integer PORTAL_REF_ID = rs.getObject(COL_PORTAL_REF_ID, Integer.class);
        kmblscfcounterpartyrel.setPortalRefID(PORTAL_REF_ID);
        kmblscfcounterpartyrel.setTaskReason(rs.getString(COL_TASK_REASON));
        java.math.BigDecimal CP_GRACE_PERIOD = rs.getObject(COL_CP_GRACE_PERIOD, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setCpGracePeriod(CP_GRACE_PERIOD);
        java.math.BigDecimal CP_SPREAD_RATE = rs.getObject(COL_CP_SPREAD_RATE, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setCpSpreadRate(CP_SPREAD_RATE);
        java.math.BigDecimal CP_MARGIN_RATE = rs.getObject(COL_CP_MARGIN_RATE, java.math.BigDecimal.class);
        kmblscfcounterpartyrel.setCpMarginRate(CP_MARGIN_RATE);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        kmblscfcounterpartyrel.setUploadRefID(UPLOAD_REF_ID);
        Integer DMS_EVENT_ID = rs.getObject(COL_DMS_EVENT_ID, Integer.class);
        kmblscfcounterpartyrel.setDmsEventID(DMS_EVENT_ID);
        kmblscfcounterpartyrel.setCpBeneLei(rs.getString(COL_CP_BENE_LEI));
        kmblscfcounterpartyrel.setRequestInitiationType(rs.getString(COL_REQUEST_INITIATION_TYPE));
        kmblscfcounterpartyrel.setProgramLayoutName(rs.getString(COL_PROGRAM_LAYOUT_NAME));
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        kmblscfcounterpartyrel.setLayoutID(LAYOUT_ID);
        kmblscfcounterpartyrel.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        return kmblscfcounterpartyrel;
    }
}
