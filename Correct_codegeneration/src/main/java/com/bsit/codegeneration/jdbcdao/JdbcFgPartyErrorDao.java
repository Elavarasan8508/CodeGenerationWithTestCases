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

public class JdbcFgPartyErrorDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyErrorDao.class);

    private static final String TABLE = "FG_PARTY_ERROR";

    private static final String COL_IGNORE = "IGNORE";

    private static final String COL_CATEGORY = "CATEGORY";

    private static final String COL_SEVERITY = "SEVERITY";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_PARTY_REFERENCE_ID = "PARTY_REFERENCE_ID";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_MESSAGE = "MESSAGE";

    private static final String COL_DETAILS = "DETAILS";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_PARENT_PARTY_CODE = "PARENT_PARTY_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_IGNORE, COL_CATEGORY, COL_SEVERITY, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PARTY_REFERENCE_ID, COL_PARTY_CODE, COL_MESSAGE, COL_DETAILS, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_PARENT_PARTY_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("IGNORE, CATEGORY, SEVERITY, TYPE_CODE, SUB_TYPE_CODE, PARTY_REFERENCE_ID, PARTY_CODE, MESSAGE, DETAILS, CREATED_ON, LAST_UPDATED_ON, PARENT_PARTY_CODE", TABLE, COL_PARTY_REFERENCE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("IGNORE, CATEGORY, SEVERITY, TYPE_CODE, SUB_TYPE_CODE, PARTY_REFERENCE_ID, PARTY_CODE, MESSAGE, DETAILS, CREATED_ON, LAST_UPDATED_ON, PARENT_PARTY_CODE", TABLE, COL_PARTY_REFERENCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_IGNORE, COL_CATEGORY, COL_SEVERITY, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PARTY_CODE, COL_MESSAGE, COL_DETAILS, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_PARENT_PARTY_CODE, COL_PARTY_REFERENCE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_REFERENCE_ID);

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

    public int insert(Connection conn, FgPartyError fgpartyerror) throws SQLException {
        logger.debug("Inserting fgpartyerror: {}", fgpartyerror);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyErrorParams(ps, fgpartyerror);
            ps.executeUpdate();
            return fgpartyerror.getPartyReferenceID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyError> fgpartyerrors) throws SQLException {
        if (fgpartyerrors == null || fgpartyerrors.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyerrors.size(); i++) {
            if (fgpartyerrors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyError>> batches = chunkList(fgpartyerrors, batchSize);
        int[] totalResults = new int[fgpartyerrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyError fgpartyerror : batch) {
                        setFgPartyErrorParams(ps, fgpartyerror);
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

    public FgPartyError findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyError> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyError> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyError fgpartyerror) throws SQLException {
        if (fgpartyerror.getPartyReferenceID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyErrorParams(ps, fgpartyerror);
            ps.setInt(12, fgpartyerror.getPartyReferenceID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyError> fgpartyerrors) throws SQLException {
        if (fgpartyerrors == null || fgpartyerrors.isEmpty())
            return new int[0];
        for (FgPartyError fgpartyerror : fgpartyerrors) {
            if (fgpartyerror == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyerror.getPartyReferenceID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyError>> batches = chunkList(fgpartyerrors, batchSize);
        int[] totalResults = new int[fgpartyerrors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyError> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyError fgpartyerror : batch) {
                        setFgPartyErrorParams(ps, fgpartyerror);
                        ps.setInt(12, fgpartyerror.getPartyReferenceID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PARTY_REFERENCE_ID, placeholders);
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

    private void setFgPartyErrorParams(PreparedStatement ps, FgPartyError fgpartyerror) throws SQLException {
        java.math.BigDecimal val1 = fgpartyerror.getIgnore();
        if (val1 != null) {
            ps.setBigDecimal(1, val1);
        } else {
            ps.setNull(1, Types.DECIMAL);
        }
        ps.setString(2, fgpartyerror.getCategory());
        ps.setString(3, fgpartyerror.getSeverity());
        ps.setString(4, fgpartyerror.getTypeCode());
        ps.setString(5, fgpartyerror.getSubTypeCode());
        Integer val6 = fgpartyerror.getPartyReferenceID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        ps.setString(7, fgpartyerror.getPartyCode());
        ps.setString(8, fgpartyerror.getMessage());
        ps.setString(9, fgpartyerror.getDetails());
        java.time.LocalDateTime val10 = fgpartyerror.getCreatedOn();
        if (val10 != null) {
            ps.setTimestamp(10, java.sql.Timestamp.valueOf(val10));
        } else {
            ps.setNull(10, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val11 = fgpartyerror.getLastUpdatedOn();
        if (val11 != null) {
            ps.setTimestamp(11, java.sql.Timestamp.valueOf(val11));
        } else {
            ps.setNull(11, Types.TIMESTAMP);
        }
        ps.setString(12, fgpartyerror.getParentPartyCode());
    }

    private FgPartyError extract(ResultSet rs) throws SQLException {
        FgPartyError fgpartyerror = new FgPartyError();
        java.math.BigDecimal IGNORE = rs.getObject(COL_IGNORE, java.math.BigDecimal.class);
        fgpartyerror.setIgnore(IGNORE);
        fgpartyerror.setCategory(rs.getString(COL_CATEGORY));
        fgpartyerror.setSeverity(rs.getString(COL_SEVERITY));
        fgpartyerror.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgpartyerror.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer PARTY_REFERENCE_ID = rs.getObject(COL_PARTY_REFERENCE_ID, Integer.class);
        fgpartyerror.setPartyReferenceID(PARTY_REFERENCE_ID);
        fgpartyerror.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgpartyerror.setMessage(rs.getString(COL_MESSAGE));
        fgpartyerror.setDetails(rs.getString(COL_DETAILS));
        Timestamp CREATED_ON = rs.getTimestamp(COL_CREATED_ON);
        if (CREATED_ON != null)
            fgpartyerror.setCreatedOn(CREATED_ON.toLocalDateTime());
        Timestamp LAST_UPDATED_ON = rs.getTimestamp(COL_LAST_UPDATED_ON);
        if (LAST_UPDATED_ON != null)
            fgpartyerror.setLastUpdatedOn(LAST_UPDATED_ON.toLocalDateTime());
        fgpartyerror.setParentPartyCode(rs.getString(COL_PARENT_PARTY_CODE));
        return fgpartyerror;
    }
}
