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

public class JdbcFgSecurityCredentialHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSecurityCredentialHistoryDao.class);

    private static final String TABLE = "FG_SECURITY_CREDENTIAL_HISTORY";

    private static final String COL_ID = "ID";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_USER_CODE = "USER_CODE";

    private static final String COL_USER_SUB_TYPE_CODE = "USER_SUB_TYPE_CODE";

    private static final String COL_CREDENTIAL_TYPE_CODE = "CREDENTIAL_TYPE_CODE";

    private static final String COL_CREDENTIAL_VALUE = "CREDENTIAL_VALUE";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_MOBILE_NO = "MOBILE_NO";

    private static final String COL_IMEI_NO = "IMEI_NO";

    private static final String COL_DEVICE = "DEVICE";

    private static final String COL_DEVICE_ID = "DEVICE_ID";

    private static final String COL_DEVICE_BRAND = "DEVICE_BRAND";

    private static final String COL_DEVICE_MFCT = "DEVICE_MFCT";

    private static final String COL_DEVICE_MODEL = "DEVICE_MODEL";

    private static final String COL_DEVICE_PRODUCT = "DEVICE_PRODUCT";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PURPOSE_CODE, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_USER_CODE, COL_USER_SUB_TYPE_CODE, COL_CREDENTIAL_TYPE_CODE, COL_CREDENTIAL_VALUE, COL_USER_NAME, COL_MOBILE_NO, COL_IMEI_NO, COL_DEVICE, COL_DEVICE_ID, COL_DEVICE_BRAND, COL_DEVICE_MFCT, COL_DEVICE_MODEL, COL_DEVICE_PRODUCT, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ACTIVE_CODE, COL_STATUS_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, USER_NAME, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ACTIVE_CODE, STATUS_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, USER_NAME, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ACTIVE_CODE, STATUS_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PURPOSE_CODE, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_USER_CODE, COL_USER_SUB_TYPE_CODE, COL_CREDENTIAL_TYPE_CODE, COL_CREDENTIAL_VALUE, COL_USER_NAME, COL_MOBILE_NO, COL_IMEI_NO, COL_DEVICE, COL_DEVICE_ID, COL_DEVICE_BRAND, COL_DEVICE_MFCT, COL_DEVICE_MODEL, COL_DEVICE_PRODUCT, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_ID);

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

    public int insert(Connection conn, FgSecurityCredentialHistory fgsecuritycredentialhistory) throws SQLException {
        logger.debug("Inserting fgsecuritycredentialhistory: {}", fgsecuritycredentialhistory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSecurityCredentialHistoryParams(ps, fgsecuritycredentialhistory);
            ps.executeUpdate();
            return fgsecuritycredentialhistory.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSecurityCredentialHistory> fgsecuritycredentialhistorys) throws SQLException {
        if (fgsecuritycredentialhistorys == null || fgsecuritycredentialhistorys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsecuritycredentialhistorys.size(); i++) {
            if (fgsecuritycredentialhistorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSecurityCredentialHistory>> batches = chunkList(fgsecuritycredentialhistorys, batchSize);
        int[] totalResults = new int[fgsecuritycredentialhistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSecurityCredentialHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSecurityCredentialHistory fgsecuritycredentialhistory : batch) {
                        setFgSecurityCredentialHistoryParams(ps, fgsecuritycredentialhistory);
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

    public FgSecurityCredentialHistory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSecurityCredentialHistory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSecurityCredentialHistory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSecurityCredentialHistory fgsecuritycredentialhistory) throws SQLException {
        if (fgsecuritycredentialhistory.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSecurityCredentialHistoryParams(ps, fgsecuritycredentialhistory);
            ps.setInt(25, fgsecuritycredentialhistory.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSecurityCredentialHistory> fgsecuritycredentialhistorys) throws SQLException {
        if (fgsecuritycredentialhistorys == null || fgsecuritycredentialhistorys.isEmpty())
            return new int[0];
        for (FgSecurityCredentialHistory fgsecuritycredentialhistory : fgsecuritycredentialhistorys) {
            if (fgsecuritycredentialhistory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsecuritycredentialhistory.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSecurityCredentialHistory>> batches = chunkList(fgsecuritycredentialhistorys, batchSize);
        int[] totalResults = new int[fgsecuritycredentialhistorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSecurityCredentialHistory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSecurityCredentialHistory fgsecuritycredentialhistory : batch) {
                        setFgSecurityCredentialHistoryParams(ps, fgsecuritycredentialhistory);
                        ps.setInt(25, fgsecuritycredentialhistory.getID());
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

    private void setFgSecurityCredentialHistoryParams(PreparedStatement ps, FgSecurityCredentialHistory fgsecuritycredentialhistory) throws SQLException {
        Integer val1 = fgsecuritycredentialhistory.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgsecuritycredentialhistory.getPurposeCode());
        ps.setString(3, fgsecuritycredentialhistory.getPartyCode());
        ps.setString(4, fgsecuritycredentialhistory.getPartySubTypeCode());
        ps.setString(5, fgsecuritycredentialhistory.getUserCode());
        ps.setString(6, fgsecuritycredentialhistory.getUserSubTypeCode());
        ps.setString(7, fgsecuritycredentialhistory.getCredentialTypeCode());
        ps.setString(8, fgsecuritycredentialhistory.getCredentialValue());
        ps.setString(9, fgsecuritycredentialhistory.getUserName());
        ps.setString(10, fgsecuritycredentialhistory.getMobileNo());
        ps.setString(11, fgsecuritycredentialhistory.getImeiNo());
        ps.setString(12, fgsecuritycredentialhistory.getDevice());
        Integer val13 = fgsecuritycredentialhistory.getDeviceID();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        ps.setString(14, fgsecuritycredentialhistory.getDeviceBrand());
        ps.setString(15, fgsecuritycredentialhistory.getDeviceMfct());
        ps.setString(16, fgsecuritycredentialhistory.getDeviceModel());
        ps.setString(17, fgsecuritycredentialhistory.getDeviceProduct());
        ps.setString(18, fgsecuritycredentialhistory.getCreatedOn());
        java.math.BigDecimal val19 = fgsecuritycredentialhistory.getCreatedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgsecuritycredentialhistory.getLastUpdatedOn());
        java.math.BigDecimal val21 = fgsecuritycredentialhistory.getLastUpdatedBy();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgsecuritycredentialhistory.getLastAuthorisedOn());
        java.math.BigDecimal val23 = fgsecuritycredentialhistory.getLastAuthorisedBy();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgsecuritycredentialhistory.getActiveCode());
        ps.setString(25, fgsecuritycredentialhistory.getStatusCode());
    }

    private FgSecurityCredentialHistory extract(ResultSet rs) throws SQLException {
        FgSecurityCredentialHistory fgsecuritycredentialhistory = new FgSecurityCredentialHistory();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsecuritycredentialhistory.setID(ID);
        fgsecuritycredentialhistory.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgsecuritycredentialhistory.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgsecuritycredentialhistory.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgsecuritycredentialhistory.setUserCode(rs.getString(COL_USER_CODE));
        fgsecuritycredentialhistory.setUserSubTypeCode(rs.getString(COL_USER_SUB_TYPE_CODE));
        fgsecuritycredentialhistory.setCredentialTypeCode(rs.getString(COL_CREDENTIAL_TYPE_CODE));
        fgsecuritycredentialhistory.setCredentialValue(rs.getString(COL_CREDENTIAL_VALUE));
        fgsecuritycredentialhistory.setUserName(rs.getString(COL_USER_NAME));
        fgsecuritycredentialhistory.setMobileNo(rs.getString(COL_MOBILE_NO));
        fgsecuritycredentialhistory.setImeiNo(rs.getString(COL_IMEI_NO));
        fgsecuritycredentialhistory.setDevice(rs.getString(COL_DEVICE));
        Integer DEVICE_ID = rs.getObject(COL_DEVICE_ID, Integer.class);
        fgsecuritycredentialhistory.setDeviceID(DEVICE_ID);
        fgsecuritycredentialhistory.setDeviceBrand(rs.getString(COL_DEVICE_BRAND));
        fgsecuritycredentialhistory.setDeviceMfct(rs.getString(COL_DEVICE_MFCT));
        fgsecuritycredentialhistory.setDeviceModel(rs.getString(COL_DEVICE_MODEL));
        fgsecuritycredentialhistory.setDeviceProduct(rs.getString(COL_DEVICE_PRODUCT));
        fgsecuritycredentialhistory.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsecuritycredentialhistory.setCreatedBy(CREATED_BY);
        fgsecuritycredentialhistory.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsecuritycredentialhistory.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsecuritycredentialhistory.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsecuritycredentialhistory.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsecuritycredentialhistory.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsecuritycredentialhistory.setStatusCode(rs.getString(COL_STATUS_CODE));
        return fgsecuritycredentialhistory;
    }
}
