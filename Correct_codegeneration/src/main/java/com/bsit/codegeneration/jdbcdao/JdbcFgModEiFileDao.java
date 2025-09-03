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

public class JdbcFgModEiFileDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModEiFileDao.class);

    private static final String TABLE = "FG_MOD_EI_FILE";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_PARTY_REF_ID = "PARTY_REF_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String COL_EVENT_CODE = "EVENT_CODE";

    private static final String COL_EVENT_DIRECTION_CODE = "EVENT_DIRECTION_CODE";

    private static final String COL_ENDPOINT_CODE = "ENDPOINT_CODE";

    private static final String COL_ENDPOINT_PATH = "ENDPOINT_PATH";

    private static final String COL_ENDPOINT_DIRECTORY = "ENDPOINT_DIRECTORY";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_SUCCESS_COUNT = "SUCCESS_COUNT";

    private static final String COL_ERROR_COUNT = "ERROR_COUNT";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_PARTY_REF_ID, COL_PARTY_VERSION_ID, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_EVENT_CODE, COL_EVENT_DIRECTION_CODE, COL_ENDPOINT_CODE, COL_ENDPOINT_PATH, COL_ENDPOINT_DIRECTORY, COL_FILE_NAME, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_CATEGORY_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, PARTY_REF_ID, PARTY_VERSION_ID, ENTITY_REF_ID, ENTITY_VERSION_ID, EVENT_CODE, EVENT_DIRECTION_CODE, ENDPOINT_CODE, ENDPOINT_PATH, ENDPOINT_DIRECTORY, FILE_NAME, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, PARTY_REF_ID, PARTY_VERSION_ID, ENTITY_REF_ID, ENTITY_VERSION_ID, EVENT_CODE, EVENT_DIRECTION_CODE, ENDPOINT_CODE, ENDPOINT_PATH, ENDPOINT_DIRECTORY, FILE_NAME, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_PARTY_REF_ID, COL_PARTY_VERSION_ID, COL_ENTITY_REF_ID, COL_ENTITY_VERSION_ID, COL_EVENT_CODE, COL_EVENT_DIRECTION_CODE, COL_ENDPOINT_CODE, COL_ENDPOINT_PATH, COL_ENDPOINT_DIRECTORY, COL_FILE_NAME, COL_TOTAL_COUNT, COL_SUCCESS_COUNT, COL_ERROR_COUNT, COL_CATEGORY_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgModEiFile fgmodeifile) throws SQLException {
        logger.debug("Inserting fgmodeifile: {}", fgmodeifile);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModEiFileParams(ps, fgmodeifile);
            ps.executeUpdate();
            return fgmodeifile.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModEiFile> fgmodeifiles) throws SQLException {
        if (fgmodeifiles == null || fgmodeifiles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodeifiles.size(); i++) {
            if (fgmodeifiles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModEiFile>> batches = chunkList(fgmodeifiles, batchSize);
        int[] totalResults = new int[fgmodeifiles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModEiFile> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModEiFile fgmodeifile : batch) {
                        setFgModEiFileParams(ps, fgmodeifile);
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

    public FgModEiFile findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModEiFile> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModEiFile> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModEiFile fgmodeifile) throws SQLException {
        if (fgmodeifile.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModEiFileParams(ps, fgmodeifile);
            ps.setInt(24, fgmodeifile.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModEiFile> fgmodeifiles) throws SQLException {
        if (fgmodeifiles == null || fgmodeifiles.isEmpty())
            return new int[0];
        for (FgModEiFile fgmodeifile : fgmodeifiles) {
            if (fgmodeifile == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodeifile.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModEiFile>> batches = chunkList(fgmodeifiles, batchSize);
        int[] totalResults = new int[fgmodeifiles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModEiFile> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModEiFile fgmodeifile : batch) {
                        setFgModEiFileParams(ps, fgmodeifile);
                        ps.setInt(24, fgmodeifile.getID());
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

    private void setFgModEiFileParams(PreparedStatement ps, FgModEiFile fgmodeifile) throws SQLException {
        Integer val1 = fgmodeifile.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodeifile.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgmodeifile.getPartyRefID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = fgmodeifile.getPartyVersionID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgmodeifile.getEntityRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Integer val6 = fgmodeifile.getEntityVersionID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        ps.setString(7, fgmodeifile.getEventCode());
        ps.setString(8, fgmodeifile.getEventDirectionCode());
        ps.setString(9, fgmodeifile.getEndpointCode());
        ps.setString(10, fgmodeifile.getEndpointPath());
        ps.setString(11, fgmodeifile.getEndpointDirectory());
        ps.setString(12, fgmodeifile.getFileName());
        java.math.BigDecimal val13 = fgmodeifile.getTotalCount();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = fgmodeifile.getSuccessCount();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgmodeifile.getErrorCount();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgmodeifile.getCategoryCode());
        ps.setString(17, fgmodeifile.getActiveCode());
        ps.setString(18, fgmodeifile.getStatusCode());
        ps.setString(19, fgmodeifile.getCreatedOn());
        java.math.BigDecimal val20 = fgmodeifile.getCreatedBy();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgmodeifile.getLastUpdatedOn());
        java.math.BigDecimal val22 = fgmodeifile.getLastUpdatedBy();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgmodeifile.getLastAuthorisedOn());
        java.math.BigDecimal val24 = fgmodeifile.getLastAuthorisedBy();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
    }

    private FgModEiFile extract(ResultSet rs) throws SQLException {
        FgModEiFile fgmodeifile = new FgModEiFile();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodeifile.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodeifile.setReferenceID(REFERENCE_ID);
        Integer PARTY_REF_ID = rs.getObject(COL_PARTY_REF_ID, Integer.class);
        fgmodeifile.setPartyRefID(PARTY_REF_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgmodeifile.setPartyVersionID(PARTY_VERSION_ID);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgmodeifile.setEntityRefID(ENTITY_REF_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgmodeifile.setEntityVersionID(ENTITY_VERSION_ID);
        fgmodeifile.setEventCode(rs.getString(COL_EVENT_CODE));
        fgmodeifile.setEventDirectionCode(rs.getString(COL_EVENT_DIRECTION_CODE));
        fgmodeifile.setEndpointCode(rs.getString(COL_ENDPOINT_CODE));
        fgmodeifile.setEndpointPath(rs.getString(COL_ENDPOINT_PATH));
        fgmodeifile.setEndpointDirectory(rs.getString(COL_ENDPOINT_DIRECTORY));
        fgmodeifile.setFileName(rs.getString(COL_FILE_NAME));
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        fgmodeifile.setTotalCount(TOTAL_COUNT);
        java.math.BigDecimal SUCCESS_COUNT = rs.getObject(COL_SUCCESS_COUNT, java.math.BigDecimal.class);
        fgmodeifile.setSuccessCount(SUCCESS_COUNT);
        java.math.BigDecimal ERROR_COUNT = rs.getObject(COL_ERROR_COUNT, java.math.BigDecimal.class);
        fgmodeifile.setErrorCount(ERROR_COUNT);
        fgmodeifile.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgmodeifile.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodeifile.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodeifile.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodeifile.setCreatedBy(CREATED_BY);
        fgmodeifile.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodeifile.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodeifile.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodeifile.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgmodeifile;
    }
}
