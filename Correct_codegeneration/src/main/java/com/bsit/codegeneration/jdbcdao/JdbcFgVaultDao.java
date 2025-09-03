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

public class JdbcFgVaultDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgVaultDao.class);

    private static final String TABLE = "FG_VAULT";

    private static final String COL_ID = "ID";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_VAULT_TYPE = "VAULT_TYPE";

    private static final String COL_VAULT_DATA = "VAULT_DATA";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_ENTITY_ID = "ENTITY_ID";

    private static final String COL_ENTITY_VERSION_ID = "ENTITY_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ENTITY_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_VAULT_TYPE, COL_VAULT_DATA, COL_ACTIVE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_ID, COL_ENTITY_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, VAULT_TYPE, VAULT_DATA, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, VAULT_TYPE, VAULT_DATA, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_ID, ENTITY_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ENTITY_REF_ID, COL_ENTITY_SUB_TYPE_CODE, COL_VAULT_TYPE, COL_VAULT_DATA, COL_ACTIVE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ENTITY_ID, COL_ENTITY_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgVault fgvault) throws SQLException {
        logger.debug("Inserting fgvault: {}", fgvault);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgVaultParams(ps, fgvault);
            ps.executeUpdate();
            return fgvault.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgVault> fgvaults) throws SQLException {
        if (fgvaults == null || fgvaults.isEmpty())
            return new int[0];
        for (int i = 0; i < fgvaults.size(); i++) {
            if (fgvaults.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgVault>> batches = chunkList(fgvaults, batchSize);
        int[] totalResults = new int[fgvaults.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgVault> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgVault fgvault : batch) {
                        setFgVaultParams(ps, fgvault);
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

    public FgVault findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgVault> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgVault> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgVault fgvault) throws SQLException {
        if (fgvault.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgVaultParams(ps, fgvault);
            ps.setInt(14, fgvault.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgVault> fgvaults) throws SQLException {
        if (fgvaults == null || fgvaults.isEmpty())
            return new int[0];
        for (FgVault fgvault : fgvaults) {
            if (fgvault == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgvault.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgVault>> batches = chunkList(fgvaults, batchSize);
        int[] totalResults = new int[fgvaults.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgVault> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgVault fgvault : batch) {
                        setFgVaultParams(ps, fgvault);
                        ps.setInt(14, fgvault.getID());
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

    private void setFgVaultParams(PreparedStatement ps, FgVault fgvault) throws SQLException {
        Integer val1 = fgvault.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgvault.getEntityRefID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgvault.getEntitySubTypeCode());
        ps.setString(4, fgvault.getVaultType());
        ps.setString(5, fgvault.getVaultData());
        ps.setString(6, fgvault.getActiveCode());
        ps.setString(7, fgvault.getCreatedOn());
        java.math.BigDecimal val8 = fgvault.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgvault.getLastUpdatedOn());
        java.math.BigDecimal val10 = fgvault.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgvault.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgvault.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        Integer val13 = fgvault.getEntityID();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        Integer val14 = fgvault.getEntityVersionID();
        if (val14 != null) {
            ps.setInt(14, val14);
        } else {
            ps.setNull(14, Types.INTEGER);
        }
    }

    private FgVault extract(ResultSet rs) throws SQLException {
        FgVault fgvault = new FgVault();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgvault.setID(ID);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgvault.setEntityRefID(ENTITY_REF_ID);
        fgvault.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        fgvault.setVaultType(rs.getString(COL_VAULT_TYPE));
        fgvault.setVaultData(rs.getString(COL_VAULT_DATA));
        fgvault.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgvault.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgvault.setCreatedBy(CREATED_BY);
        fgvault.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgvault.setLastUpdatedBy(LAST_UPDATED_BY);
        fgvault.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgvault.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer ENTITY_ID = rs.getObject(COL_ENTITY_ID, Integer.class);
        fgvault.setEntityID(ENTITY_ID);
        Integer ENTITY_VERSION_ID = rs.getObject(COL_ENTITY_VERSION_ID, Integer.class);
        fgvault.setEntityVersionID(ENTITY_VERSION_ID);
        return fgvault;
    }
}
