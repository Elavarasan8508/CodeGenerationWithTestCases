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

public class JdbcFgActRuIdentitylinkDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuIdentitylinkDao.class);

    private static final String TABLE = "FG_ACT_RU_IDENTITYLINK";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_GROUP_ID_ = "GROUP_ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_GROUP_ID_, COL_TYPE_, COL_USER_ID_, COL_TASK_ID_, COL_PROC_DEF_ID_, COL_TENANT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_TASK_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_", TABLE, COL_TASK_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_GROUP_ID_, COL_TYPE_, COL_USER_ID_, COL_TASK_ID_, COL_PROC_DEF_ID_, COL_TENANT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuIdentitylink fgactruidentitylink) throws SQLException {
        logger.debug("Inserting fgactruidentitylink: {}", fgactruidentitylink);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuIdentitylinkParams(ps, fgactruidentitylink);
            ps.executeUpdate();
            return fgactruidentitylink.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuIdentitylink> fgactruidentitylinks) throws SQLException {
        if (fgactruidentitylinks == null || fgactruidentitylinks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruidentitylinks.size(); i++) {
            if (fgactruidentitylinks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuIdentitylink>> batches = chunkList(fgactruidentitylinks, batchSize);
        int[] totalResults = new int[fgactruidentitylinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuIdentitylink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuIdentitylink fgactruidentitylink : batch) {
                        setFgActRuIdentitylinkParams(ps, fgactruidentitylink);
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

    public FgActRuIdentitylink findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuIdentitylink> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuIdentitylink> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuIdentitylink fgactruidentitylink) throws SQLException {
        if (fgactruidentitylink.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuIdentitylinkParams(ps, fgactruidentitylink);
            ps.setString(8, fgactruidentitylink.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuIdentitylink> fgactruidentitylinks) throws SQLException {
        if (fgactruidentitylinks == null || fgactruidentitylinks.isEmpty())
            return new int[0];
        for (FgActRuIdentitylink fgactruidentitylink : fgactruidentitylinks) {
            if (fgactruidentitylink == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruidentitylink.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuIdentitylink>> batches = chunkList(fgactruidentitylinks, batchSize);
        int[] totalResults = new int[fgactruidentitylinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuIdentitylink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuIdentitylink fgactruidentitylink : batch) {
                        setFgActRuIdentitylinkParams(ps, fgactruidentitylink);
                        ps.setString(8, fgactruidentitylink.getID_());
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

    public List<FgActRuIdentitylink> findByTaskID_(Connection conn, String taskID_) throws SQLException {
        List<FgActRuIdentitylink> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_TASK_ID__SQL)) {
            ps.setString(1, taskID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuIdentitylinkParams(PreparedStatement ps, FgActRuIdentitylink fgactruidentitylink) throws SQLException {
        ps.setString(1, fgactruidentitylink.getID_());
        java.math.BigDecimal val2 = fgactruidentitylink.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactruidentitylink.getGroupID_());
        ps.setString(4, fgactruidentitylink.getType_());
        ps.setString(5, fgactruidentitylink.getUserID_());
        if (fgactruidentitylink.getTaskID_() != null) {
            ps.setString(6, fgactruidentitylink.getTaskID_().getFgActRuTaskID());
        } else {
            ps.setNull(6, Types.VARCHAR);
        }
        ps.setString(7, fgactruidentitylink.getProcDefID_());
        ps.setString(8, fgactruidentitylink.getTenantID_());
    }

    private FgActRuIdentitylink extract(ResultSet rs) throws SQLException {
        FgActRuIdentitylink fgactruidentitylink = new FgActRuIdentitylink();
        fgactruidentitylink.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruidentitylink.setRev_(REV_);
        fgactruidentitylink.setGroupID_(rs.getString(COL_GROUP_ID_));
        fgactruidentitylink.setType_(rs.getString(COL_TYPE_));
        fgactruidentitylink.setUserID_(rs.getString(COL_USER_ID_));
        String TASK_ID_ = rs.getObject(COL_TASK_ID_, String.class);
        fgactruidentitylink.setTaskID_(TASK_ID_);
        if (TASK_ID_ != null) {
            FgActRuTask taskID_ = new FgActRuTask();
            taskID_.setFgActRuTaskID(TASK_ID_);
            fgactruidentitylink.setTaskID_(taskID_);
        }
        fgactruidentitylink.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgactruidentitylink.setTenantID_(rs.getString(COL_TENANT_ID_));
        return fgactruidentitylink;
    }
}
