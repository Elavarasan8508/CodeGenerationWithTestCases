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

public class JdbcFgModBiDashboardReposDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModBiDashboardReposDao.class);

    private static final String TABLE = "FG_MOD_BI_DASHBOARD_REPOS";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_BOARD_ID = "BOARD_ID";

    private static final String COL_BOARD_NAME = "BOARD_NAME";

    private static final String COL_CATEGORY_NAME = "CATEGORY_NAME";

    private static final String COL_PARTY_TYPE = "PARTY_TYPE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_PARTY_USER_TYPE = "PARTY_USER_TYPE";

    private static final String COL_PARTY_USER_CODE = "PARTY_USER_CODE";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_LAYOUT_JSON = "LAYOUT_JSON";

    private static final String COL_COMPANY_ID = "COMPANY_ID";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_IS_DEFAULT = "IS_DEFAULT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_VERSION_ID, COL_BOARD_ID, COL_BOARD_NAME, COL_CATEGORY_NAME, COL_PARTY_TYPE, COL_PARTY_CODE, COL_PARTY_USER_TYPE, COL_PARTY_USER_CODE, COL_IS_MASTER_VERSION, COL_LAYOUT_JSON, COL_COMPANY_ID, COL_USER_ID, COL_IS_DEFAULT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, VERSION_ID, BOARD_ID, BOARD_NAME, CATEGORY_NAME, PARTY_TYPE, PARTY_CODE, PARTY_USER_TYPE, PARTY_USER_CODE, IS_MASTER_VERSION, LAYOUT_JSON, COMPANY_ID, USER_ID, IS_DEFAULT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, VERSION_ID, BOARD_ID, BOARD_NAME, CATEGORY_NAME, PARTY_TYPE, PARTY_CODE, PARTY_USER_TYPE, PARTY_USER_CODE, IS_MASTER_VERSION, LAYOUT_JSON, COMPANY_ID, USER_ID, IS_DEFAULT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_VERSION_ID, COL_BOARD_ID, COL_BOARD_NAME, COL_CATEGORY_NAME, COL_PARTY_TYPE, COL_PARTY_CODE, COL_PARTY_USER_TYPE, COL_PARTY_USER_CODE, COL_IS_MASTER_VERSION, COL_LAYOUT_JSON, COL_COMPANY_ID, COL_USER_ID, COL_IS_DEFAULT, COL_ID);

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

    public int insert(Connection conn, FgModBiDashboardRepos fgmodbidashboardrepos) throws SQLException {
        logger.debug("Inserting fgmodbidashboardrepos: {}", fgmodbidashboardrepos);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModBiDashboardReposParams(ps, fgmodbidashboardrepos);
            ps.executeUpdate();
            return fgmodbidashboardrepos.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModBiDashboardRepos> fgmodbidashboardreposs) throws SQLException {
        if (fgmodbidashboardreposs == null || fgmodbidashboardreposs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodbidashboardreposs.size(); i++) {
            if (fgmodbidashboardreposs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModBiDashboardRepos>> batches = chunkList(fgmodbidashboardreposs, batchSize);
        int[] totalResults = new int[fgmodbidashboardreposs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModBiDashboardRepos> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModBiDashboardRepos fgmodbidashboardrepos : batch) {
                        setFgModBiDashboardReposParams(ps, fgmodbidashboardrepos);
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

    public FgModBiDashboardRepos findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModBiDashboardRepos> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModBiDashboardRepos> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModBiDashboardRepos fgmodbidashboardrepos) throws SQLException {
        if (fgmodbidashboardrepos.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModBiDashboardReposParams(ps, fgmodbidashboardrepos);
            ps.setInt(26, fgmodbidashboardrepos.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModBiDashboardRepos> fgmodbidashboardreposs) throws SQLException {
        if (fgmodbidashboardreposs == null || fgmodbidashboardreposs.isEmpty())
            return new int[0];
        for (FgModBiDashboardRepos fgmodbidashboardrepos : fgmodbidashboardreposs) {
            if (fgmodbidashboardrepos == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodbidashboardrepos.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModBiDashboardRepos>> batches = chunkList(fgmodbidashboardreposs, batchSize);
        int[] totalResults = new int[fgmodbidashboardreposs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModBiDashboardRepos> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModBiDashboardRepos fgmodbidashboardrepos : batch) {
                        setFgModBiDashboardReposParams(ps, fgmodbidashboardrepos);
                        ps.setInt(26, fgmodbidashboardrepos.getID());
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

    private void setFgModBiDashboardReposParams(PreparedStatement ps, FgModBiDashboardRepos fgmodbidashboardrepos) throws SQLException {
        Integer val1 = fgmodbidashboardrepos.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodbidashboardrepos.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodbidashboardrepos.getTypeCode());
        ps.setString(4, fgmodbidashboardrepos.getSubTypeCode());
        ps.setString(5, fgmodbidashboardrepos.getDescription());
        ps.setString(6, fgmodbidashboardrepos.getActiveCode());
        ps.setString(7, fgmodbidashboardrepos.getStatusCode());
        ps.setString(8, fgmodbidashboardrepos.getCreatedOn());
        java.math.BigDecimal val9 = fgmodbidashboardrepos.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodbidashboardrepos.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmodbidashboardrepos.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        java.math.BigDecimal val12 = fgmodbidashboardrepos.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgmodbidashboardrepos.getLastAuthorisedOn());
        Integer val14 = fgmodbidashboardrepos.getVersionID();
        if (val14 != null) {
            ps.setInt(14, val14);
        } else {
            ps.setNull(14, Types.INTEGER);
        }
        Integer val15 = fgmodbidashboardrepos.getBoardID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
        ps.setString(16, fgmodbidashboardrepos.getBoardName());
        ps.setString(17, fgmodbidashboardrepos.getCategoryName());
        ps.setString(18, fgmodbidashboardrepos.getPartyType());
        ps.setString(19, fgmodbidashboardrepos.getPartyCode());
        ps.setString(20, fgmodbidashboardrepos.getPartyUserType());
        ps.setString(21, fgmodbidashboardrepos.getPartyUserCode());
        java.math.BigDecimal val22 = fgmodbidashboardrepos.getIsMasterVersion();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgmodbidashboardrepos.getLayoutJson());
        Integer val24 = fgmodbidashboardrepos.getCompanyID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        Integer val25 = fgmodbidashboardrepos.getUserID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = fgmodbidashboardrepos.getIsDefault();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
    }

    private FgModBiDashboardRepos extract(ResultSet rs) throws SQLException {
        FgModBiDashboardRepos fgmodbidashboardrepos = new FgModBiDashboardRepos();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodbidashboardrepos.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodbidashboardrepos.setReferenceID(REFERENCE_ID);
        fgmodbidashboardrepos.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodbidashboardrepos.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmodbidashboardrepos.setDescription(rs.getString(COL_DESCRIPTION));
        fgmodbidashboardrepos.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodbidashboardrepos.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodbidashboardrepos.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodbidashboardrepos.setCreatedBy(CREATED_BY);
        fgmodbidashboardrepos.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodbidashboardrepos.setLastUpdatedBy(LAST_UPDATED_BY);
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodbidashboardrepos.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodbidashboardrepos.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodbidashboardrepos.setVersionID(VERSION_ID);
        Integer BOARD_ID = rs.getObject(COL_BOARD_ID, Integer.class);
        fgmodbidashboardrepos.setBoardID(BOARD_ID);
        fgmodbidashboardrepos.setBoardName(rs.getString(COL_BOARD_NAME));
        fgmodbidashboardrepos.setCategoryName(rs.getString(COL_CATEGORY_NAME));
        fgmodbidashboardrepos.setPartyType(rs.getString(COL_PARTY_TYPE));
        fgmodbidashboardrepos.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgmodbidashboardrepos.setPartyUserType(rs.getString(COL_PARTY_USER_TYPE));
        fgmodbidashboardrepos.setPartyUserCode(rs.getString(COL_PARTY_USER_CODE));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodbidashboardrepos.setIsMasterVersion(IS_MASTER_VERSION);
        fgmodbidashboardrepos.setLayoutJson(rs.getString(COL_LAYOUT_JSON));
        Integer COMPANY_ID = rs.getObject(COL_COMPANY_ID, Integer.class);
        fgmodbidashboardrepos.setCompanyID(COMPANY_ID);
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        fgmodbidashboardrepos.setUserID(USER_ID);
        java.math.BigDecimal IS_DEFAULT = rs.getObject(COL_IS_DEFAULT, java.math.BigDecimal.class);
        fgmodbidashboardrepos.setIsDefault(IS_DEFAULT);
        return fgmodbidashboardrepos;
    }
}
