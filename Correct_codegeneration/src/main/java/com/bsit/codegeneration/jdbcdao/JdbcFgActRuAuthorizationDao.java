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

public class JdbcFgActRuAuthorizationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuAuthorizationDao.class);

    private static final String TABLE = "FG_ACT_RU_AUTHORIZATION";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_GROUP_ID_ = "GROUP_ID_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_RESOURCE_TYPE_ = "RESOURCE_TYPE_";

    private static final String COL_RESOURCE_ID_ = "RESOURCE_ID_";

    private static final String COL_PERMS_ = "PERMS_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_TYPE_, COL_GROUP_ID_, COL_USER_ID_, COL_RESOURCE_TYPE_, COL_RESOURCE_ID_, COL_PERMS_, COL_REMOVAL_TIME_, COL_ROOT_PROC_INST_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, TYPE_, GROUP_ID_, USER_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REMOVAL_TIME_, ROOT_PROC_INST_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, TYPE_, GROUP_ID_, USER_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REMOVAL_TIME_, ROOT_PROC_INST_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_TYPE_, COL_GROUP_ID_, COL_USER_ID_, COL_RESOURCE_TYPE_, COL_RESOURCE_ID_, COL_PERMS_, COL_REMOVAL_TIME_, COL_ROOT_PROC_INST_ID_, COL_ID_);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID_);

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

    public String insert(Connection conn, FgActRuAuthorization fgactruauthorization) throws SQLException {
        logger.debug("Inserting fgactruauthorization: {}", fgactruauthorization);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuAuthorizationParams(ps, fgactruauthorization);
            ps.executeUpdate();
            return fgactruauthorization.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuAuthorization> fgactruauthorizations) throws SQLException {
        if (fgactruauthorizations == null || fgactruauthorizations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruauthorizations.size(); i++) {
            if (fgactruauthorizations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuAuthorization>> batches = chunkList(fgactruauthorizations, batchSize);
        int[] totalResults = new int[fgactruauthorizations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuAuthorization> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuAuthorization fgactruauthorization : batch) {
                        setFgActRuAuthorizationParams(ps, fgactruauthorization);
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

    public FgActRuAuthorization findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuAuthorization> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuAuthorization> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuAuthorization fgactruauthorization) throws SQLException {
        if (fgactruauthorization.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuAuthorizationParams(ps, fgactruauthorization);
            ps.setString(10, fgactruauthorization.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuAuthorization> fgactruauthorizations) throws SQLException {
        if (fgactruauthorizations == null || fgactruauthorizations.isEmpty())
            return new int[0];
        for (FgActRuAuthorization fgactruauthorization : fgactruauthorizations) {
            if (fgactruauthorization == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruauthorization.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuAuthorization>> batches = chunkList(fgactruauthorizations, batchSize);
        int[] totalResults = new int[fgactruauthorizations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuAuthorization> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuAuthorization fgactruauthorization : batch) {
                        setFgActRuAuthorizationParams(ps, fgactruauthorization);
                        ps.setString(10, fgactruauthorization.getID_());
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

    public boolean deleteById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<String> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (String id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<String>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<String> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID_, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setString(i + 1, chunk.get(i));
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

    private void setFgActRuAuthorizationParams(PreparedStatement ps, FgActRuAuthorization fgactruauthorization) throws SQLException {
        ps.setString(1, fgactruauthorization.getID_());
        java.math.BigDecimal val2 = fgactruauthorization.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        java.math.BigDecimal val3 = fgactruauthorization.getType_();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        ps.setString(4, fgactruauthorization.getGroupID_());
        ps.setString(5, fgactruauthorization.getUserID_());
        java.math.BigDecimal val6 = fgactruauthorization.getResourceType_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgactruauthorization.getResourceID_());
        java.math.BigDecimal val8 = fgactruauthorization.getPerms_();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgactruauthorization.getRemovalTime_());
        ps.setString(10, fgactruauthorization.getRootProcInstID_());
    }

    private FgActRuAuthorization extract(ResultSet rs) throws SQLException {
        FgActRuAuthorization fgactruauthorization = new FgActRuAuthorization();
        fgactruauthorization.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruauthorization.setRev_(REV_);
        java.math.BigDecimal TYPE_ = rs.getObject(COL_TYPE_, java.math.BigDecimal.class);
        fgactruauthorization.setType_(TYPE_);
        fgactruauthorization.setGroupID_(rs.getString(COL_GROUP_ID_));
        fgactruauthorization.setUserID_(rs.getString(COL_USER_ID_));
        java.math.BigDecimal RESOURCE_TYPE_ = rs.getObject(COL_RESOURCE_TYPE_, java.math.BigDecimal.class);
        fgactruauthorization.setResourceType_(RESOURCE_TYPE_);
        fgactruauthorization.setResourceID_(rs.getString(COL_RESOURCE_ID_));
        java.math.BigDecimal PERMS_ = rs.getObject(COL_PERMS_, java.math.BigDecimal.class);
        fgactruauthorization.setPerms_(PERMS_);
        fgactruauthorization.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        fgactruauthorization.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        return fgactruauthorization;
    }
}
