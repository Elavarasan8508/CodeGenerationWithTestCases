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

public class JdbcFgPersonDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPersonDao.class);

    private static final String TABLE = "FG_PERSON";

    private static final String COL_ID = "ID";

    private static final String COL_BIRTH_COUNTRY_CODE = "BIRTH_COUNTRY_CODE";

    private static final String COL_BIRTH_NAME = "BIRTH_NAME";

    private static final String COL_CITY_OF_BIRTH = "CITY_OF_BIRTH";

    private static final String COL_DOMICILE_COUNTRY_CODE = "DOMICILE_COUNTRY_CODE";

    private static final String COL_GENDER_CODE = "GENDER_CODE";

    private static final String COL_GIVEN_NAME = "GIVEN_NAME";

    private static final String COL_LANGUAGE_CODE = "LANGUAGE_CODE";

    private static final String COL_MIDDLE_NAME = "MIDDLE_NAME";

    private static final String COL_MINOR_INDICATOR = "MINOR_INDICATOR";

    private static final String COL_NAME = "NAME";

    private static final String COL_NAME_PREFIX_CODE = "NAME_PREFIX_CODE";

    private static final String COL_NAME_SUFFIX = "NAME_SUFFIX";

    private static final String COL_NATIONALITY_CODE = "NATIONALITY_CODE";

    private static final String COL_PROFESSION = "PROFESSION";

    private static final String COL_PROVINCE_OF_BIRTH = "PROVINCE_OF_BIRTH";

    private static final String COL_RESIDENCE_COUNTRY_CODE = "RESIDENCE_COUNTRY_CODE";

    private static final String COL_RESIDENTIAL_STATUS_CODE = "RESIDENTIAL_STATUS_CODE";

    private static final String COL_TAXATION_COUNTRY_CODE = "TAXATION_COUNTRY_CODE";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_EMPLOYEE_NO = "EMPLOYEE_NO";

    private static final String COL_DATE_OF_BIRTH = "DATE_OF_BIRTH";

    private static final String COL_DATE_OF_JOINING = "DATE_OF_JOINING";

    private static final String COL_DESIGNATION = "DESIGNATION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_BIRTH_COUNTRY_CODE, COL_BIRTH_NAME, COL_CITY_OF_BIRTH, COL_DOMICILE_COUNTRY_CODE, COL_GENDER_CODE, COL_GIVEN_NAME, COL_LANGUAGE_CODE, COL_MIDDLE_NAME, COL_MINOR_INDICATOR, COL_NAME, COL_NAME_PREFIX_CODE, COL_NAME_SUFFIX, COL_NATIONALITY_CODE, COL_PROFESSION, COL_PROVINCE_OF_BIRTH, COL_RESIDENCE_COUNTRY_CODE, COL_RESIDENTIAL_STATUS_CODE, COL_TAXATION_COUNTRY_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_EMPLOYEE_NO, COL_DATE_OF_BIRTH, COL_DATE_OF_JOINING, COL_DESIGNATION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, BIRTH_COUNTRY_CODE, BIRTH_NAME, CITY_OF_BIRTH, DOMICILE_COUNTRY_CODE, GENDER_CODE, GIVEN_NAME, LANGUAGE_CODE, MIDDLE_NAME, MINOR_INDICATOR, NAME, NAME_PREFIX_CODE, NAME_SUFFIX, NATIONALITY_CODE, PROFESSION, PROVINCE_OF_BIRTH, RESIDENCE_COUNTRY_CODE, RESIDENTIAL_STATUS_CODE, TAXATION_COUNTRY_CODE, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, EMPLOYEE_NO, DATE_OF_BIRTH, DATE_OF_JOINING, DESIGNATION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, BIRTH_COUNTRY_CODE, BIRTH_NAME, CITY_OF_BIRTH, DOMICILE_COUNTRY_CODE, GENDER_CODE, GIVEN_NAME, LANGUAGE_CODE, MIDDLE_NAME, MINOR_INDICATOR, NAME, NAME_PREFIX_CODE, NAME_SUFFIX, NATIONALITY_CODE, PROFESSION, PROVINCE_OF_BIRTH, RESIDENCE_COUNTRY_CODE, RESIDENTIAL_STATUS_CODE, TAXATION_COUNTRY_CODE, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, EMPLOYEE_NO, DATE_OF_BIRTH, DATE_OF_JOINING, DESIGNATION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_BIRTH_COUNTRY_CODE, COL_BIRTH_NAME, COL_CITY_OF_BIRTH, COL_DOMICILE_COUNTRY_CODE, COL_GENDER_CODE, COL_GIVEN_NAME, COL_LANGUAGE_CODE, COL_MIDDLE_NAME, COL_MINOR_INDICATOR, COL_NAME, COL_NAME_PREFIX_CODE, COL_NAME_SUFFIX, COL_NATIONALITY_CODE, COL_PROFESSION, COL_PROVINCE_OF_BIRTH, COL_RESIDENCE_COUNTRY_CODE, COL_RESIDENTIAL_STATUS_CODE, COL_TAXATION_COUNTRY_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_EMPLOYEE_NO, COL_DATE_OF_BIRTH, COL_DATE_OF_JOINING, COL_DESIGNATION, COL_ID);

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

    public int insert(Connection conn, FgPerson fgperson) throws SQLException {
        logger.debug("Inserting fgperson: {}", fgperson);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPersonParams(ps, fgperson);
            ps.executeUpdate();
            return fgperson.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPerson> fgpersons) throws SQLException {
        if (fgpersons == null || fgpersons.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpersons.size(); i++) {
            if (fgpersons.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPerson>> batches = chunkList(fgpersons, batchSize);
        int[] totalResults = new int[fgpersons.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPerson> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPerson fgperson : batch) {
                        setFgPersonParams(ps, fgperson);
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

    public FgPerson findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPerson> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPerson> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPerson fgperson) throws SQLException {
        if (fgperson.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPersonParams(ps, fgperson);
            ps.setInt(31, fgperson.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPerson> fgpersons) throws SQLException {
        if (fgpersons == null || fgpersons.isEmpty())
            return new int[0];
        for (FgPerson fgperson : fgpersons) {
            if (fgperson == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgperson.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPerson>> batches = chunkList(fgpersons, batchSize);
        int[] totalResults = new int[fgpersons.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPerson> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPerson fgperson : batch) {
                        setFgPersonParams(ps, fgperson);
                        ps.setInt(31, fgperson.getID());
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

    private void setFgPersonParams(PreparedStatement ps, FgPerson fgperson) throws SQLException {
        Integer val1 = fgperson.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgperson.getBirthCountryCode());
        ps.setString(3, fgperson.getBirthName());
        ps.setString(4, fgperson.getCityOfBirth());
        ps.setString(5, fgperson.getDomicileCountryCode());
        ps.setString(6, fgperson.getGenderCode());
        ps.setString(7, fgperson.getGivenName());
        ps.setString(8, fgperson.getLanguageCode());
        ps.setString(9, fgperson.getMiddleName());
        ps.setString(10, fgperson.getMinorIndicator());
        ps.setString(11, fgperson.getName());
        ps.setString(12, fgperson.getNamePrefixCode());
        ps.setString(13, fgperson.getNameSuffix());
        ps.setString(14, fgperson.getNationalityCode());
        ps.setString(15, fgperson.getProfession());
        ps.setString(16, fgperson.getProvinceOfBirth());
        ps.setString(17, fgperson.getResidenceCountryCode());
        ps.setString(18, fgperson.getResidentialStatusCode());
        ps.setString(19, fgperson.getTaxationCountryCode());
        Integer val20 = fgperson.getPartyID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = fgperson.getPartyVersionID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        ps.setString(22, fgperson.getCreatedOn());
        java.math.BigDecimal val23 = fgperson.getCreatedBy();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgperson.getLastUpdatedOn());
        java.math.BigDecimal val25 = fgperson.getLastUpdatedBy();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgperson.getLastAuthorisedOn());
        java.math.BigDecimal val27 = fgperson.getLastAuthorisedBy();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgperson.getEmployeeNo());
        java.time.LocalDateTime val29 = fgperson.getDateOfBirth();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val30 = fgperson.getDateOfJoining();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        ps.setString(31, fgperson.getDesignation());
    }

    private FgPerson extract(ResultSet rs) throws SQLException {
        FgPerson fgperson = new FgPerson();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgperson.setID(ID);
        fgperson.setBirthCountryCode(rs.getString(COL_BIRTH_COUNTRY_CODE));
        fgperson.setBirthName(rs.getString(COL_BIRTH_NAME));
        fgperson.setCityOfBirth(rs.getString(COL_CITY_OF_BIRTH));
        fgperson.setDomicileCountryCode(rs.getString(COL_DOMICILE_COUNTRY_CODE));
        fgperson.setGenderCode(rs.getString(COL_GENDER_CODE));
        fgperson.setGivenName(rs.getString(COL_GIVEN_NAME));
        fgperson.setLanguageCode(rs.getString(COL_LANGUAGE_CODE));
        fgperson.setMiddleName(rs.getString(COL_MIDDLE_NAME));
        fgperson.setMinorIndicator(rs.getString(COL_MINOR_INDICATOR));
        fgperson.setName(rs.getString(COL_NAME));
        fgperson.setNamePrefixCode(rs.getString(COL_NAME_PREFIX_CODE));
        fgperson.setNameSuffix(rs.getString(COL_NAME_SUFFIX));
        fgperson.setNationalityCode(rs.getString(COL_NATIONALITY_CODE));
        fgperson.setProfession(rs.getString(COL_PROFESSION));
        fgperson.setProvinceOfBirth(rs.getString(COL_PROVINCE_OF_BIRTH));
        fgperson.setResidenceCountryCode(rs.getString(COL_RESIDENCE_COUNTRY_CODE));
        fgperson.setResidentialStatusCode(rs.getString(COL_RESIDENTIAL_STATUS_CODE));
        fgperson.setTaxationCountryCode(rs.getString(COL_TAXATION_COUNTRY_CODE));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgperson.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgperson.setPartyVersionID(PARTY_VERSION_ID);
        fgperson.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgperson.setCreatedBy(CREATED_BY);
        fgperson.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgperson.setLastUpdatedBy(LAST_UPDATED_BY);
        fgperson.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgperson.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgperson.setEmployeeNo(rs.getString(COL_EMPLOYEE_NO));
        Timestamp DATE_OF_BIRTH = rs.getTimestamp(COL_DATE_OF_BIRTH);
        if (DATE_OF_BIRTH != null)
            fgperson.setDateOfBirth(DATE_OF_BIRTH.toLocalDateTime());
        Timestamp DATE_OF_JOINING = rs.getTimestamp(COL_DATE_OF_JOINING);
        if (DATE_OF_JOINING != null)
            fgperson.setDateOfJoining(DATE_OF_JOINING.toLocalDateTime());
        fgperson.setDesignation(rs.getString(COL_DESIGNATION));
        return fgperson;
    }
}
