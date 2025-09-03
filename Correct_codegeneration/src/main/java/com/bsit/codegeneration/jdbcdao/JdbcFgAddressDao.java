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

public class JdbcFgAddressDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAddressDao.class);

    private static final String TABLE = "FG_ADDRESS";

    private static final String COL_ID = "ID";

    private static final String COL_ADDRESS_LINE1 = "ADDRESS_LINE1";

    private static final String COL_ADDRESS_LINE2 = "ADDRESS_LINE2";

    private static final String COL_ADDRESS_LINE3 = "ADDRESS_LINE3";

    private static final String COL_COUNTRY_CODE = "COUNTRY_CODE";

    private static final String COL_STATE_CODE = "STATE_CODE";

    private static final String COL_CITY_CODE = "CITY_CODE";

    private static final String COL_LAND_MARK = "LAND_MARK";

    private static final String COL_POST_CODE = "POST_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LATITUDE = "LATITUDE";

    private static final String COL_LONGITUDE = "LONGITUDE";

    private static final String COL_SYS_DEFINED = "SYS_DEFINED";

    private static final String COL_SYSTEM_SOURCE_CODE = "SYSTEM_SOURCE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ADDRESS_LINE1, COL_ADDRESS_LINE2, COL_ADDRESS_LINE3, COL_COUNTRY_CODE, COL_STATE_CODE, COL_CITY_CODE, COL_LAND_MARK, COL_POST_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_LATITUDE, COL_LONGITUDE, COL_SYS_DEFINED, COL_SYSTEM_SOURCE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ADDRESS_LINE1, ADDRESS_LINE2, ADDRESS_LINE3, COUNTRY_CODE, STATE_CODE, CITY_CODE, LAND_MARK, POST_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, LATITUDE, LONGITUDE, SYS_DEFINED, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ADDRESS_LINE1, ADDRESS_LINE2, ADDRESS_LINE3, COUNTRY_CODE, STATE_CODE, CITY_CODE, LAND_MARK, POST_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, LATITUDE, LONGITUDE, SYS_DEFINED, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_LINE1, COL_ADDRESS_LINE2, COL_ADDRESS_LINE3, COL_COUNTRY_CODE, COL_STATE_CODE, COL_CITY_CODE, COL_LAND_MARK, COL_POST_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_LATITUDE, COL_LONGITUDE, COL_SYS_DEFINED, COL_SYSTEM_SOURCE_CODE, COL_ID);

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

    public int insert(Connection conn, FgAddress fgaddress) throws SQLException {
        logger.debug("Inserting fgaddress: {}", fgaddress);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAddressParams(ps, fgaddress);
            ps.executeUpdate();
            return fgaddress.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgAddress> fgaddresss) throws SQLException {
        if (fgaddresss == null || fgaddresss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgaddresss.size(); i++) {
            if (fgaddresss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAddress>> batches = chunkList(fgaddresss, batchSize);
        int[] totalResults = new int[fgaddresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAddress> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAddress fgaddress : batch) {
                        setFgAddressParams(ps, fgaddress);
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

    public FgAddress findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAddress> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAddress> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAddress fgaddress) throws SQLException {
        if (fgaddress.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAddressParams(ps, fgaddress);
            ps.setInt(19, fgaddress.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAddress> fgaddresss) throws SQLException {
        if (fgaddresss == null || fgaddresss.isEmpty())
            return new int[0];
        for (FgAddress fgaddress : fgaddresss) {
            if (fgaddress == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgaddress.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAddress>> batches = chunkList(fgaddresss, batchSize);
        int[] totalResults = new int[fgaddresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAddress> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAddress fgaddress : batch) {
                        setFgAddressParams(ps, fgaddress);
                        ps.setInt(19, fgaddress.getID());
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

    private void setFgAddressParams(PreparedStatement ps, FgAddress fgaddress) throws SQLException {
        Integer val1 = fgaddress.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgaddress.getAddressLine1());
        ps.setString(3, fgaddress.getAddressLine2());
        ps.setString(4, fgaddress.getAddressLine3());
        ps.setString(5, fgaddress.getCountryCode());
        ps.setString(6, fgaddress.getStateCode());
        ps.setString(7, fgaddress.getCityCode());
        ps.setString(8, fgaddress.getLandMark());
        ps.setString(9, fgaddress.getPostCode());
        ps.setString(10, fgaddress.getCreatedOn());
        java.math.BigDecimal val11 = fgaddress.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgaddress.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgaddress.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgaddress.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgaddress.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgaddress.getLatitude());
        ps.setString(17, fgaddress.getLongitude());
        java.math.BigDecimal val18 = fgaddress.getSysDefined();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgaddress.getSystemSourceCode());
    }

    private FgAddress extract(ResultSet rs) throws SQLException {
        FgAddress fgaddress = new FgAddress();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgaddress.setID(ID);
        fgaddress.setAddressLine1(rs.getString(COL_ADDRESS_LINE1));
        fgaddress.setAddressLine2(rs.getString(COL_ADDRESS_LINE2));
        fgaddress.setAddressLine3(rs.getString(COL_ADDRESS_LINE3));
        fgaddress.setCountryCode(rs.getString(COL_COUNTRY_CODE));
        fgaddress.setStateCode(rs.getString(COL_STATE_CODE));
        fgaddress.setCityCode(rs.getString(COL_CITY_CODE));
        fgaddress.setLandMark(rs.getString(COL_LAND_MARK));
        fgaddress.setPostCode(rs.getString(COL_POST_CODE));
        fgaddress.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgaddress.setCreatedBy(CREATED_BY);
        fgaddress.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgaddress.setLastUpdatedBy(LAST_UPDATED_BY);
        fgaddress.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgaddress.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgaddress.setLatitude(rs.getString(COL_LATITUDE));
        fgaddress.setLongitude(rs.getString(COL_LONGITUDE));
        java.math.BigDecimal SYS_DEFINED = rs.getObject(COL_SYS_DEFINED, java.math.BigDecimal.class);
        fgaddress.setSysDefined(SYS_DEFINED);
        fgaddress.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        return fgaddress;
    }
}
