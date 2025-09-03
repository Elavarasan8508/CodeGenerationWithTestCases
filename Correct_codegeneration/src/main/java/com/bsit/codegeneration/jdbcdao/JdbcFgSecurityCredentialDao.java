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

public class JdbcFgSecurityCredentialDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSecurityCredentialDao.class);

    private static final String TABLE = "FG_SECURITY_CREDENTIAL";

    private static final String COL_ID = "ID";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_USER_CODE = "USER_CODE";

    private static final String COL_USER_SUB_TYPE_CODE = "USER_SUB_TYPE_CODE";

    private static final String COL_CREDENTIAL_TYPE_CODE = "CREDENTIAL_TYPE_CODE";

    private static final String COL_CREDENTIAL_VALUE = "CREDENTIAL_VALUE";

    private static final String COL_EXPIRES_ON = "EXPIRES_ON";

    private static final String COL_MOBILE_NO = "MOBILE_NO";

    private static final String COL_IMEI_NO = "IMEI_NO";

    private static final String COL_DEVICE = "DEVICE";

    private static final String COL_DEVICE_ID = "DEVICE_ID";

    private static final String COL_DEVICE_BRAND = "DEVICE_BRAND";

    private static final String COL_DEVICE_MFCT = "DEVICE_MFCT";

    private static final String COL_DEVICE_MODEL = "DEVICE_MODEL";

    private static final String COL_DEVICE_PRODUCT = "DEVICE_PRODUCT";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_CREDENTIAL_KEY = "CREDENTIAL_KEY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PURPOSE_CODE, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_USER_CODE, COL_USER_SUB_TYPE_CODE, COL_CREDENTIAL_TYPE_CODE, COL_CREDENTIAL_VALUE, COL_EXPIRES_ON, COL_MOBILE_NO, COL_IMEI_NO, COL_DEVICE, COL_DEVICE_ID, COL_DEVICE_BRAND, COL_DEVICE_MFCT, COL_DEVICE_MODEL, COL_DEVICE_PRODUCT, COL_USER_NAME, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_CREDENTIAL_KEY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, EXPIRES_ON, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, USER_NAME, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CREDENTIAL_KEY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, EXPIRES_ON, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, USER_NAME, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CREDENTIAL_KEY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PURPOSE_CODE, COL_PARTY_CODE, COL_PARTY_SUB_TYPE_CODE, COL_USER_CODE, COL_USER_SUB_TYPE_CODE, COL_CREDENTIAL_TYPE_CODE, COL_CREDENTIAL_VALUE, COL_EXPIRES_ON, COL_MOBILE_NO, COL_IMEI_NO, COL_DEVICE, COL_DEVICE_ID, COL_DEVICE_BRAND, COL_DEVICE_MFCT, COL_DEVICE_MODEL, COL_DEVICE_PRODUCT, COL_USER_NAME, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_CREDENTIAL_KEY, COL_ID);

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

    public int insert(Connection conn, FgSecurityCredential fgsecuritycredential) throws SQLException {
        logger.debug("Inserting fgsecuritycredential: {}", fgsecuritycredential);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSecurityCredentialParams(ps, fgsecuritycredential);
            ps.executeUpdate();
            return fgsecuritycredential.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSecurityCredential> fgsecuritycredentials) throws SQLException {
        if (fgsecuritycredentials == null || fgsecuritycredentials.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsecuritycredentials.size(); i++) {
            if (fgsecuritycredentials.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSecurityCredential>> batches = chunkList(fgsecuritycredentials, batchSize);
        int[] totalResults = new int[fgsecuritycredentials.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSecurityCredential> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSecurityCredential fgsecuritycredential : batch) {
                        setFgSecurityCredentialParams(ps, fgsecuritycredential);
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

    public FgSecurityCredential findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSecurityCredential> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSecurityCredential> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSecurityCredential fgsecuritycredential) throws SQLException {
        if (fgsecuritycredential.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSecurityCredentialParams(ps, fgsecuritycredential);
            ps.setInt(27, fgsecuritycredential.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSecurityCredential> fgsecuritycredentials) throws SQLException {
        if (fgsecuritycredentials == null || fgsecuritycredentials.isEmpty())
            return new int[0];
        for (FgSecurityCredential fgsecuritycredential : fgsecuritycredentials) {
            if (fgsecuritycredential == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsecuritycredential.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSecurityCredential>> batches = chunkList(fgsecuritycredentials, batchSize);
        int[] totalResults = new int[fgsecuritycredentials.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSecurityCredential> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSecurityCredential fgsecuritycredential : batch) {
                        setFgSecurityCredentialParams(ps, fgsecuritycredential);
                        ps.setInt(27, fgsecuritycredential.getID());
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

    private void setFgSecurityCredentialParams(PreparedStatement ps, FgSecurityCredential fgsecuritycredential) throws SQLException {
        Integer val1 = fgsecuritycredential.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgsecuritycredential.getPurposeCode());
        ps.setString(3, fgsecuritycredential.getPartyCode());
        ps.setString(4, fgsecuritycredential.getPartySubTypeCode());
        ps.setString(5, fgsecuritycredential.getUserCode());
        ps.setString(6, fgsecuritycredential.getUserSubTypeCode());
        ps.setString(7, fgsecuritycredential.getCredentialTypeCode());
        ps.setString(8, fgsecuritycredential.getCredentialValue());
        ps.setString(9, fgsecuritycredential.getExpiresOn());
        ps.setString(10, fgsecuritycredential.getMobileNo());
        ps.setString(11, fgsecuritycredential.getImeiNo());
        ps.setString(12, fgsecuritycredential.getDevice());
        Integer val13 = fgsecuritycredential.getDeviceID();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        ps.setString(14, fgsecuritycredential.getDeviceBrand());
        ps.setString(15, fgsecuritycredential.getDeviceMfct());
        ps.setString(16, fgsecuritycredential.getDeviceModel());
        ps.setString(17, fgsecuritycredential.getDeviceProduct());
        ps.setString(18, fgsecuritycredential.getUserName());
        ps.setString(19, fgsecuritycredential.getActiveCode());
        ps.setString(20, fgsecuritycredential.getStatusCode());
        ps.setString(21, fgsecuritycredential.getCreatedOn());
        java.math.BigDecimal val22 = fgsecuritycredential.getCreatedBy();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgsecuritycredential.getLastUpdatedOn());
        java.math.BigDecimal val24 = fgsecuritycredential.getLastUpdatedBy();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgsecuritycredential.getLastAuthorisedOn());
        java.math.BigDecimal val26 = fgsecuritycredential.getLastAuthorisedBy();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgsecuritycredential.getCredentialKey());
    }

    private FgSecurityCredential extract(ResultSet rs) throws SQLException {
        FgSecurityCredential fgsecuritycredential = new FgSecurityCredential();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsecuritycredential.setID(ID);
        fgsecuritycredential.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgsecuritycredential.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgsecuritycredential.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgsecuritycredential.setUserCode(rs.getString(COL_USER_CODE));
        fgsecuritycredential.setUserSubTypeCode(rs.getString(COL_USER_SUB_TYPE_CODE));
        fgsecuritycredential.setCredentialTypeCode(rs.getString(COL_CREDENTIAL_TYPE_CODE));
        fgsecuritycredential.setCredentialValue(rs.getString(COL_CREDENTIAL_VALUE));
        fgsecuritycredential.setExpiresOn(rs.getString(COL_EXPIRES_ON));
        fgsecuritycredential.setMobileNo(rs.getString(COL_MOBILE_NO));
        fgsecuritycredential.setImeiNo(rs.getString(COL_IMEI_NO));
        fgsecuritycredential.setDevice(rs.getString(COL_DEVICE));
        Integer DEVICE_ID = rs.getObject(COL_DEVICE_ID, Integer.class);
        fgsecuritycredential.setDeviceID(DEVICE_ID);
        fgsecuritycredential.setDeviceBrand(rs.getString(COL_DEVICE_BRAND));
        fgsecuritycredential.setDeviceMfct(rs.getString(COL_DEVICE_MFCT));
        fgsecuritycredential.setDeviceModel(rs.getString(COL_DEVICE_MODEL));
        fgsecuritycredential.setDeviceProduct(rs.getString(COL_DEVICE_PRODUCT));
        fgsecuritycredential.setUserName(rs.getString(COL_USER_NAME));
        fgsecuritycredential.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsecuritycredential.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsecuritycredential.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsecuritycredential.setCreatedBy(CREATED_BY);
        fgsecuritycredential.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsecuritycredential.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsecuritycredential.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsecuritycredential.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsecuritycredential.setCredentialKey(rs.getString(COL_CREDENTIAL_KEY));
        return fgsecuritycredential;
    }
}
