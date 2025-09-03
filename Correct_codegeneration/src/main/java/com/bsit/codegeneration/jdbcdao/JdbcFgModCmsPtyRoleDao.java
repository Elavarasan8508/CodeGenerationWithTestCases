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

public class JdbcFgModCmsPtyRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModCmsPtyRoleDao.class);

    private static final String TABLE = "FG_MOD_CMS_PTY_ROLE";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_TYPE_CODE = "PARTY_TYPE_CODE";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PARTY_REF_NO = "PARTY_REF_NO";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARTY_ROLE = "PARTY_ROLE";

    private static final String COL_SPACE_REF_NO = "SPACE_REF_NO";

    private static final String COL_SPACE_VERSION_ID = "SPACE_VERSION_ID";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_REF_NO, COL_PARTY_VERSION_ID, COL_PARTY_ROLE, COL_SPACE_REF_NO, COL_SPACE_VERSION_ID, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_REF_NO, PARTY_VERSION_ID, PARTY_ROLE, SPACE_REF_NO, SPACE_VERSION_ID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_REF_NO, PARTY_VERSION_ID, PARTY_ROLE, SPACE_REF_NO, SPACE_VERSION_ID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_TYPE_CODE, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_REF_NO, COL_PARTY_VERSION_ID, COL_PARTY_ROLE, COL_SPACE_REF_NO, COL_SPACE_VERSION_ID, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_ID);

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

    public int insert(Connection conn, FgModCmsPtyRole fgmodcmsptyrole) throws SQLException {
        logger.debug("Inserting fgmodcmsptyrole: {}", fgmodcmsptyrole);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModCmsPtyRoleParams(ps, fgmodcmsptyrole);
            ps.executeUpdate();
            return fgmodcmsptyrole.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModCmsPtyRole> fgmodcmsptyroles) throws SQLException {
        if (fgmodcmsptyroles == null || fgmodcmsptyroles.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodcmsptyroles.size(); i++) {
            if (fgmodcmsptyroles.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsPtyRole>> batches = chunkList(fgmodcmsptyroles, batchSize);
        int[] totalResults = new int[fgmodcmsptyroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsPtyRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModCmsPtyRole fgmodcmsptyrole : batch) {
                        setFgModCmsPtyRoleParams(ps, fgmodcmsptyrole);
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

    public FgModCmsPtyRole findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModCmsPtyRole> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModCmsPtyRole> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModCmsPtyRole fgmodcmsptyrole) throws SQLException {
        if (fgmodcmsptyrole.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModCmsPtyRoleParams(ps, fgmodcmsptyrole);
            ps.setInt(14, fgmodcmsptyrole.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModCmsPtyRole> fgmodcmsptyroles) throws SQLException {
        if (fgmodcmsptyroles == null || fgmodcmsptyroles.isEmpty())
            return new int[0];
        for (FgModCmsPtyRole fgmodcmsptyrole : fgmodcmsptyroles) {
            if (fgmodcmsptyrole == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodcmsptyrole.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCmsPtyRole>> batches = chunkList(fgmodcmsptyroles, batchSize);
        int[] totalResults = new int[fgmodcmsptyroles.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCmsPtyRole> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModCmsPtyRole fgmodcmsptyrole : batch) {
                        setFgModCmsPtyRoleParams(ps, fgmodcmsptyrole);
                        ps.setInt(14, fgmodcmsptyrole.getID());
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

    private void setFgModCmsPtyRoleParams(PreparedStatement ps, FgModCmsPtyRole fgmodcmsptyrole) throws SQLException {
        Integer val1 = fgmodcmsptyrole.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgmodcmsptyrole.getPartyTypeCode());
        ps.setString(3, fgmodcmsptyrole.getPartySubTypeCode());
        ps.setString(4, fgmodcmsptyrole.getPartyRefNo());
        Integer val5 = fgmodcmsptyrole.getPartyVersionID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgmodcmsptyrole.getPartyRole());
        ps.setString(7, fgmodcmsptyrole.getSpaceRefNo());
        Integer val8 = fgmodcmsptyrole.getSpaceVersionID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        java.math.BigDecimal val9 = fgmodcmsptyrole.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodcmsptyrole.getCreatedOn());
        java.math.BigDecimal val11 = fgmodcmsptyrole.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmodcmsptyrole.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgmodcmsptyrole.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgmodcmsptyrole.getLastAuthorisedOn());
    }

    private FgModCmsPtyRole extract(ResultSet rs) throws SQLException {
        FgModCmsPtyRole fgmodcmsptyrole = new FgModCmsPtyRole();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodcmsptyrole.setID(ID);
        fgmodcmsptyrole.setPartyTypeCode(rs.getString(COL_PARTY_TYPE_CODE));
        fgmodcmsptyrole.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgmodcmsptyrole.setPartyRefNo(rs.getString(COL_PARTY_REF_NO));
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgmodcmsptyrole.setPartyVersionID(PARTY_VERSION_ID);
        fgmodcmsptyrole.setPartyRole(rs.getString(COL_PARTY_ROLE));
        fgmodcmsptyrole.setSpaceRefNo(rs.getString(COL_SPACE_REF_NO));
        Integer SPACE_VERSION_ID = rs.getObject(COL_SPACE_VERSION_ID, Integer.class);
        fgmodcmsptyrole.setSpaceVersionID(SPACE_VERSION_ID);
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodcmsptyrole.setCreatedBy(CREATED_BY);
        fgmodcmsptyrole.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodcmsptyrole.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodcmsptyrole.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodcmsptyrole.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodcmsptyrole.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        return fgmodcmsptyrole;
    }
}
