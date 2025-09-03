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

public class JdbcFgBusinessCodeBkpDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBusinessCodeBkpDao.class);

    private static final String TABLE = "FG_BUSINESS_CODE_BKP";

    private static final String COL_ID = "ID";

    private static final String COL_NAME = "NAME";

    private static final String COL_CODE_TYPE = "CODE_TYPE";

    private static final String COL_CODE_VALUE = "CODE_VALUE";

    private static final String COL_PARENT_CODE = "PARENT_CODE";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARENT_TYPE = "PARENT_TYPE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_TAGS = "TAGS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_NAME, COL_CODE_TYPE, COL_CODE_VALUE, COL_PARENT_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARENT_TYPE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_PARENT_REF_ID, COL_TAGS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_CODE_TYPE, COL_CODE_VALUE, COL_PARENT_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARENT_TYPE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_PARENT_REF_ID, COL_TAGS, COL_ID);

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

    public int insert(Connection conn, FgBusinessCodeBkp fgbusinesscodebkp) throws SQLException {
        logger.debug("Inserting fgbusinesscodebkp: {}", fgbusinesscodebkp);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBusinessCodeBkpParams(ps, fgbusinesscodebkp);
            ps.executeUpdate();
            return fgbusinesscodebkp.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBusinessCodeBkp> fgbusinesscodebkps) throws SQLException {
        if (fgbusinesscodebkps == null || fgbusinesscodebkps.isEmpty())
            return new int[0];
        for (int i = 0; i < fgbusinesscodebkps.size(); i++) {
            if (fgbusinesscodebkps.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBusinessCodeBkp>> batches = chunkList(fgbusinesscodebkps, batchSize);
        int[] totalResults = new int[fgbusinesscodebkps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBusinessCodeBkp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBusinessCodeBkp fgbusinesscodebkp : batch) {
                        setFgBusinessCodeBkpParams(ps, fgbusinesscodebkp);
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

    public FgBusinessCodeBkp findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBusinessCodeBkp> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBusinessCodeBkp> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBusinessCodeBkp fgbusinesscodebkp) throws SQLException {
        if (fgbusinesscodebkp.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBusinessCodeBkpParams(ps, fgbusinesscodebkp);
            ps.setInt(20, fgbusinesscodebkp.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBusinessCodeBkp> fgbusinesscodebkps) throws SQLException {
        if (fgbusinesscodebkps == null || fgbusinesscodebkps.isEmpty())
            return new int[0];
        for (FgBusinessCodeBkp fgbusinesscodebkp : fgbusinesscodebkps) {
            if (fgbusinesscodebkp == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgbusinesscodebkp.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBusinessCodeBkp>> batches = chunkList(fgbusinesscodebkps, batchSize);
        int[] totalResults = new int[fgbusinesscodebkps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBusinessCodeBkp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBusinessCodeBkp fgbusinesscodebkp : batch) {
                        setFgBusinessCodeBkpParams(ps, fgbusinesscodebkp);
                        ps.setInt(20, fgbusinesscodebkp.getID());
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

    private void setFgBusinessCodeBkpParams(PreparedStatement ps, FgBusinessCodeBkp fgbusinesscodebkp) throws SQLException {
        Integer val1 = fgbusinesscodebkp.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgbusinesscodebkp.getName());
        ps.setString(3, fgbusinesscodebkp.getCodeType());
        ps.setString(4, fgbusinesscodebkp.getCodeValue());
        ps.setString(5, fgbusinesscodebkp.getParentCode());
        Integer val6 = fgbusinesscodebkp.getPartyID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        Integer val7 = fgbusinesscodebkp.getPartyVersionID();
        if (val7 != null) {
            ps.setInt(7, val7);
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgbusinesscodebkp.getParentType());
        ps.setString(9, fgbusinesscodebkp.getDescription());
        ps.setString(10, fgbusinesscodebkp.getActiveCode());
        ps.setString(11, fgbusinesscodebkp.getStatusCode());
        ps.setString(12, fgbusinesscodebkp.getCreatedOn());
        java.math.BigDecimal val13 = fgbusinesscodebkp.getCreatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgbusinesscodebkp.getLastUpdatedOn());
        java.math.BigDecimal val15 = fgbusinesscodebkp.getLastUpdatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgbusinesscodebkp.getLastAuthorisedOn());
        java.math.BigDecimal val17 = fgbusinesscodebkp.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgbusinesscodebkp.getTemplate());
        Integer val19 = fgbusinesscodebkp.getParentRefID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        ps.setString(20, fgbusinesscodebkp.getTags());
    }

    private FgBusinessCodeBkp extract(ResultSet rs) throws SQLException {
        FgBusinessCodeBkp fgbusinesscodebkp = new FgBusinessCodeBkp();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgbusinesscodebkp.setID(ID);
        fgbusinesscodebkp.setName(rs.getString(COL_NAME));
        fgbusinesscodebkp.setCodeType(rs.getString(COL_CODE_TYPE));
        fgbusinesscodebkp.setCodeValue(rs.getString(COL_CODE_VALUE));
        fgbusinesscodebkp.setParentCode(rs.getString(COL_PARENT_CODE));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgbusinesscodebkp.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgbusinesscodebkp.setPartyVersionID(PARTY_VERSION_ID);
        fgbusinesscodebkp.setParentType(rs.getString(COL_PARENT_TYPE));
        fgbusinesscodebkp.setDescription(rs.getString(COL_DESCRIPTION));
        fgbusinesscodebkp.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgbusinesscodebkp.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgbusinesscodebkp.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgbusinesscodebkp.setCreatedBy(CREATED_BY);
        fgbusinesscodebkp.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgbusinesscodebkp.setLastUpdatedBy(LAST_UPDATED_BY);
        fgbusinesscodebkp.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgbusinesscodebkp.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgbusinesscodebkp.setTemplate(rs.getString(COL_TEMPLATE));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgbusinesscodebkp.setParentRefID(PARENT_REF_ID);
        fgbusinesscodebkp.setTags(rs.getString(COL_TAGS));
        return fgbusinesscodebkp;
    }
}
