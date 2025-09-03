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

public class JdbcFgTokenBkDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTokenBkDao.class);

    private static final String TABLE = "FG_TOKEN_BK";

    private static final String COL_ID = "ID";

    private static final String COL_DOMAIN_CODE = "DOMAIN_CODE";

    private static final String COL_USER_NAME = "USER_NAME";

    private static final String COL_LOGIN_ID = "LOGIN_ID";

    private static final String COL_TOKEN_NAME = "TOKEN_NAME";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_REQ_SYSTEM = "REQ_SYSTEM";

    private static final String COL_ISSUED_ON = "ISSUED_ON";

    private static final String COL_ACCESSED_ON = "ACCESSED_ON";

    private static final String COL_VAL_DURATION = "VAL_DURATION";

    private static final String COL_REQ_TIME = "REQ_TIME";

    private static final String COL_EXPIRES_ON = "EXPIRES_ON";

    private static final String COL_CREATED_DATE = "CREATED_DATE";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_TOKEN_VALUE = "TOKEN_VALUE";

    private static final String COL_CHANNEL = "CHANNEL";

    private static final String COL_CHANNEL_TYPE = "CHANNEL_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_DOMAIN_CODE, COL_USER_NAME, COL_LOGIN_ID, COL_TOKEN_NAME, COL_STATUS, COL_REQ_SYSTEM, COL_ISSUED_ON, COL_ACCESSED_ON, COL_VAL_DURATION, COL_REQ_TIME, COL_EXPIRES_ON, COL_CREATED_DATE, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_TOKEN_VALUE, COL_CHANNEL, COL_CHANNEL_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, CREATED_DATE, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, CREATED_DATE, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DOMAIN_CODE, COL_USER_NAME, COL_LOGIN_ID, COL_TOKEN_NAME, COL_STATUS, COL_REQ_SYSTEM, COL_ISSUED_ON, COL_ACCESSED_ON, COL_VAL_DURATION, COL_REQ_TIME, COL_EXPIRES_ON, COL_CREATED_DATE, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_TOKEN_VALUE, COL_CHANNEL, COL_CHANNEL_TYPE, COL_ID);

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

    public int insert(Connection conn, FgTokenBk fgtokenbk) throws SQLException {
        logger.debug("Inserting fgtokenbk: {}", fgtokenbk);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTokenBkParams(ps, fgtokenbk);
            ps.executeUpdate();
            return fgtokenbk.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTokenBk> fgtokenbks) throws SQLException {
        if (fgtokenbks == null || fgtokenbks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtokenbks.size(); i++) {
            if (fgtokenbks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTokenBk>> batches = chunkList(fgtokenbks, batchSize);
        int[] totalResults = new int[fgtokenbks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTokenBk> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTokenBk fgtokenbk : batch) {
                        setFgTokenBkParams(ps, fgtokenbk);
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

    public FgTokenBk findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTokenBk> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTokenBk> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTokenBk fgtokenbk) throws SQLException {
        if (fgtokenbk.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTokenBkParams(ps, fgtokenbk);
            ps.setInt(22, fgtokenbk.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTokenBk> fgtokenbks) throws SQLException {
        if (fgtokenbks == null || fgtokenbks.isEmpty())
            return new int[0];
        for (FgTokenBk fgtokenbk : fgtokenbks) {
            if (fgtokenbk == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtokenbk.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTokenBk>> batches = chunkList(fgtokenbks, batchSize);
        int[] totalResults = new int[fgtokenbks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTokenBk> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTokenBk fgtokenbk : batch) {
                        setFgTokenBkParams(ps, fgtokenbk);
                        ps.setInt(22, fgtokenbk.getID());
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

    private void setFgTokenBkParams(PreparedStatement ps, FgTokenBk fgtokenbk) throws SQLException {
        Integer val1 = fgtokenbk.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgtokenbk.getDomainCode());
        ps.setString(3, fgtokenbk.getUserName());
        Integer val4 = fgtokenbk.getLoginID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgtokenbk.getTokenName());
        java.math.BigDecimal val6 = fgtokenbk.getStatus();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgtokenbk.getReqSystem());
        ps.setString(8, fgtokenbk.getIssuedOn());
        ps.setString(9, fgtokenbk.getAccessedOn());
        Integer val10 = fgtokenbk.getValDuration();
        if (val10 != null) {
            ps.setInt(10, val10);
        } else {
            ps.setNull(10, Types.INTEGER);
        }
        ps.setString(11, fgtokenbk.getReqTime());
        ps.setString(12, fgtokenbk.getExpiresOn());
        ps.setString(13, fgtokenbk.getCreatedDate());
        java.math.BigDecimal val14 = fgtokenbk.getCreatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgtokenbk.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        java.math.BigDecimal val16 = fgtokenbk.getLastAuthorisedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgtokenbk.getCreatedOn());
        ps.setString(18, fgtokenbk.getLastUpdatedOn());
        ps.setString(19, fgtokenbk.getLastAuthorisedOn());
        ps.setString(20, fgtokenbk.getTokenValue());
        ps.setString(21, fgtokenbk.getChannel());
        ps.setString(22, fgtokenbk.getChannelType());
    }

    private FgTokenBk extract(ResultSet rs) throws SQLException {
        FgTokenBk fgtokenbk = new FgTokenBk();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtokenbk.setID(ID);
        fgtokenbk.setDomainCode(rs.getString(COL_DOMAIN_CODE));
        fgtokenbk.setUserName(rs.getString(COL_USER_NAME));
        Integer LOGIN_ID = rs.getObject(COL_LOGIN_ID, Integer.class);
        fgtokenbk.setLoginID(LOGIN_ID);
        fgtokenbk.setTokenName(rs.getString(COL_TOKEN_NAME));
        java.math.BigDecimal STATUS = rs.getObject(COL_STATUS, java.math.BigDecimal.class);
        fgtokenbk.setStatus(STATUS);
        fgtokenbk.setReqSystem(rs.getString(COL_REQ_SYSTEM));
        fgtokenbk.setIssuedOn(rs.getString(COL_ISSUED_ON));
        fgtokenbk.setAccessedOn(rs.getString(COL_ACCESSED_ON));
        Integer VAL_DURATION = rs.getObject(COL_VAL_DURATION, Integer.class);
        fgtokenbk.setValDuration(VAL_DURATION);
        fgtokenbk.setReqTime(rs.getString(COL_REQ_TIME));
        fgtokenbk.setExpiresOn(rs.getString(COL_EXPIRES_ON));
        fgtokenbk.setCreatedDate(rs.getString(COL_CREATED_DATE));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtokenbk.setCreatedBy(CREATED_BY);
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtokenbk.setLastUpdatedBy(LAST_UPDATED_BY);
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtokenbk.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtokenbk.setCreatedOn(rs.getString(COL_CREATED_ON));
        fgtokenbk.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        fgtokenbk.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        fgtokenbk.setTokenValue(rs.getString(COL_TOKEN_VALUE));
        fgtokenbk.setChannel(rs.getString(COL_CHANNEL));
        fgtokenbk.setChannelType(rs.getString(COL_CHANNEL_TYPE));
        return fgtokenbk;
    }
}
