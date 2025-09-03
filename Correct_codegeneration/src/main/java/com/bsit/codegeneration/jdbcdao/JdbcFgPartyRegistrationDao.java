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

public class JdbcFgPartyRegistrationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyRegistrationDao.class);

    private static final String TABLE = "FG_PARTY_REGISTRATION";

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

    private static final String COL_NAME = "NAME";

    private static final String COL_EMAIL = "EMAIL";

    private static final String COL_PHONE = "PHONE";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_PURPOSE = "PURPOSE";

    private static final String COL_OTP_VERIFY = "OTP_VERIFY";

    private static final String COL_LAST_NAME = "LAST_NAME";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_PASSWORD = "PASSWORD";

    private static final String COL_COUNTRY = "COUNTRY";

    private static final String COL_CUSTOMER_ID = "CUSTOMER_ID";

    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";

    private static final String COL_COMPANY_NAME = "COMPANY_NAME";

    private static final String COL_ADDRESS_LINE_1 = "ADDRESS_LINE_1";

    private static final String COL_ADDRESS_LINE_2 = "ADDRESS_LINE_2";

    private static final String COL_ADDRESS_LINE_3 = "ADDRESS_LINE_3";

    private static final String COL_CITY = "CITY";

    private static final String COL_STATE = "STATE";

    private static final String COL_ZIP = "ZIP";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_EMAIL, COL_PHONE, COL_COMMENTS, COL_PURPOSE, COL_OTP_VERIFY, COL_LAST_NAME, COL_USER_NAME, COL_PASSWORD, COL_COUNTRY, COL_CUSTOMER_ID, COL_CUSTOMER_NAME, COL_COMPANY_NAME, COL_ADDRESS_LINE_1, COL_ADDRESS_LINE_2, COL_ADDRESS_LINE_3, COL_CITY, COL_STATE, COL_ZIP);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, EMAIL, PHONE, COMMENTS, PURPOSE, OTP_VERIFY, LAST_NAME, USER_NAME, PASSWORD, COUNTRY, CUSTOMER_ID, CUSTOMER_NAME, COMPANY_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE, ZIP", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, EMAIL, PHONE, COMMENTS, PURPOSE, OTP_VERIFY, LAST_NAME, USER_NAME, PASSWORD, COUNTRY, CUSTOMER_ID, CUSTOMER_NAME, COMPANY_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE, ZIP", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_EMAIL, COL_PHONE, COL_COMMENTS, COL_PURPOSE, COL_OTP_VERIFY, COL_LAST_NAME, COL_USER_NAME, COL_PASSWORD, COL_COUNTRY, COL_CUSTOMER_ID, COL_CUSTOMER_NAME, COL_COMPANY_NAME, COL_ADDRESS_LINE_1, COL_ADDRESS_LINE_2, COL_ADDRESS_LINE_3, COL_CITY, COL_STATE, COL_ZIP, COL_ID);

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

    public int insert(Connection conn, FgPartyRegistration fgpartyregistration) throws SQLException {
        logger.debug("Inserting fgpartyregistration: {}", fgpartyregistration);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyRegistrationParams(ps, fgpartyregistration);
            ps.executeUpdate();
            return fgpartyregistration.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyRegistration> fgpartyregistrations) throws SQLException {
        if (fgpartyregistrations == null || fgpartyregistrations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyregistrations.size(); i++) {
            if (fgpartyregistrations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRegistration>> batches = chunkList(fgpartyregistrations, batchSize);
        int[] totalResults = new int[fgpartyregistrations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRegistration> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyRegistration fgpartyregistration : batch) {
                        setFgPartyRegistrationParams(ps, fgpartyregistration);
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

    public FgPartyRegistration findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyRegistration> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyRegistration> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyRegistration fgpartyregistration) throws SQLException {
        if (fgpartyregistration.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyRegistrationParams(ps, fgpartyregistration);
            ps.setInt(34, fgpartyregistration.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyRegistration> fgpartyregistrations) throws SQLException {
        if (fgpartyregistrations == null || fgpartyregistrations.isEmpty())
            return new int[0];
        for (FgPartyRegistration fgpartyregistration : fgpartyregistrations) {
            if (fgpartyregistration == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyregistration.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyRegistration>> batches = chunkList(fgpartyregistrations, batchSize);
        int[] totalResults = new int[fgpartyregistrations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyRegistration> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyRegistration fgpartyregistration : batch) {
                        setFgPartyRegistrationParams(ps, fgpartyregistration);
                        ps.setInt(34, fgpartyregistration.getID());
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

    private void setFgPartyRegistrationParams(PreparedStatement ps, FgPartyRegistration fgpartyregistration) throws SQLException {
        Integer val1 = fgpartyregistration.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpartyregistration.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgpartyregistration.getTypeCode());
        ps.setString(4, fgpartyregistration.getSubTypeCode());
        ps.setString(5, fgpartyregistration.getActiveCode());
        ps.setString(6, fgpartyregistration.getStageCode());
        ps.setString(7, fgpartyregistration.getStatusCode());
        ps.setString(8, fgpartyregistration.getCreatedOn());
        java.math.BigDecimal val9 = fgpartyregistration.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpartyregistration.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgpartyregistration.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpartyregistration.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgpartyregistration.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpartyregistration.getTemplate());
        java.math.BigDecimal val15 = fgpartyregistration.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpartyregistration.getName());
        ps.setString(17, fgpartyregistration.getEmail());
        ps.setString(18, fgpartyregistration.getPhone());
        ps.setString(19, fgpartyregistration.getComments());
        ps.setString(20, fgpartyregistration.getPurpose());
        ps.setString(21, fgpartyregistration.getOtpVerify());
        ps.setString(22, fgpartyregistration.getLastName());
        ps.setString(23, fgpartyregistration.getUserName());
        ps.setString(24, fgpartyregistration.getPassword());
        ps.setString(25, fgpartyregistration.getCountry());
        Integer val26 = fgpartyregistration.getCustomerID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, fgpartyregistration.getCustomerName());
        ps.setString(28, fgpartyregistration.getCompanyName());
        ps.setString(29, fgpartyregistration.getAddressLine1());
        ps.setString(30, fgpartyregistration.getAddressLine2());
        ps.setString(31, fgpartyregistration.getAddressLine3());
        ps.setString(32, fgpartyregistration.getCity());
        ps.setString(33, fgpartyregistration.getState());
        ps.setString(34, fgpartyregistration.getZip());
    }

    private FgPartyRegistration extract(ResultSet rs) throws SQLException {
        FgPartyRegistration fgpartyregistration = new FgPartyRegistration();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyregistration.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgpartyregistration.setReferenceID(REFERENCE_ID);
        fgpartyregistration.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgpartyregistration.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgpartyregistration.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyregistration.setStageCode(rs.getString(COL_STAGE_CODE));
        fgpartyregistration.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyregistration.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyregistration.setCreatedBy(CREATED_BY);
        fgpartyregistration.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyregistration.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyregistration.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyregistration.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyregistration.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgpartyregistration.setIsTemplate(IS_TEMPLATE);
        fgpartyregistration.setName(rs.getString(COL_NAME));
        fgpartyregistration.setEmail(rs.getString(COL_EMAIL));
        fgpartyregistration.setPhone(rs.getString(COL_PHONE));
        fgpartyregistration.setComments(rs.getString(COL_COMMENTS));
        fgpartyregistration.setPurpose(rs.getString(COL_PURPOSE));
        fgpartyregistration.setOtpVerify(rs.getString(COL_OTP_VERIFY));
        fgpartyregistration.setLastName(rs.getString(COL_LAST_NAME));
        fgpartyregistration.setUserName(rs.getString(COL_USER_NAME));
        fgpartyregistration.setPassword(rs.getString(COL_PASSWORD));
        fgpartyregistration.setCountry(rs.getString(COL_COUNTRY));
        Integer CUSTOMER_ID = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        fgpartyregistration.setCustomerID(CUSTOMER_ID);
        fgpartyregistration.setCustomerName(rs.getString(COL_CUSTOMER_NAME));
        fgpartyregistration.setCompanyName(rs.getString(COL_COMPANY_NAME));
        fgpartyregistration.setAddressLine1(rs.getString(COL_ADDRESS_LINE_1));
        fgpartyregistration.setAddressLine2(rs.getString(COL_ADDRESS_LINE_2));
        fgpartyregistration.setAddressLine3(rs.getString(COL_ADDRESS_LINE_3));
        fgpartyregistration.setCity(rs.getString(COL_CITY));
        fgpartyregistration.setState(rs.getString(COL_STATE));
        fgpartyregistration.setZip(rs.getString(COL_ZIP));
        return fgpartyregistration;
    }
}
