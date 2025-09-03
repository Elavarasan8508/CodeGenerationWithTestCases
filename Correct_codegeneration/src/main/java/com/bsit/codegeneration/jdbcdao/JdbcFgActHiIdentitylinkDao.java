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

public class JdbcFgActHiIdentitylinkDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiIdentitylinkDao.class);

    private static final String TABLE = "FG_ACT_HI_IDENTITYLINK";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TIMESTAMP_ = "TIMESTAMP_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_GROUP_ID_ = "GROUP_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_OPERATION_TYPE_ = "OPERATION_TYPE_";

    private static final String COL_ASSIGNER_ID_ = "ASSIGNER_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TIMESTAMP_, COL_TYPE_, COL_USER_ID_, COL_GROUP_ID_, COL_TASK_ID_, COL_PROC_DEF_ID_, COL_OPERATION_TYPE_, COL_ASSIGNER_ID_, COL_PROC_DEF_KEY_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TIMESTAMP_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_DEF_ID_, OPERATION_TYPE_, ASSIGNER_ID_, PROC_DEF_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TIMESTAMP_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_DEF_ID_, OPERATION_TYPE_, ASSIGNER_ID_, PROC_DEF_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TIMESTAMP_, COL_TYPE_, COL_USER_ID_, COL_GROUP_ID_, COL_TASK_ID_, COL_PROC_DEF_ID_, COL_OPERATION_TYPE_, COL_ASSIGNER_ID_, COL_PROC_DEF_KEY_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiIdentitylink fgacthiidentitylink) throws SQLException {
        logger.debug("Inserting fgacthiidentitylink: {}", fgacthiidentitylink);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiIdentitylinkParams(ps, fgacthiidentitylink);
            ps.executeUpdate();
            return fgacthiidentitylink.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiIdentitylink> fgacthiidentitylinks) throws SQLException {
        if (fgacthiidentitylinks == null || fgacthiidentitylinks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthiidentitylinks.size(); i++) {
            if (fgacthiidentitylinks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiIdentitylink>> batches = chunkList(fgacthiidentitylinks, batchSize);
        int[] totalResults = new int[fgacthiidentitylinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiIdentitylink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiIdentitylink fgacthiidentitylink : batch) {
                        setFgActHiIdentitylinkParams(ps, fgacthiidentitylink);
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

    public FgActHiIdentitylink findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiIdentitylink> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiIdentitylink> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiIdentitylink fgacthiidentitylink) throws SQLException {
        if (fgacthiidentitylink.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiIdentitylinkParams(ps, fgacthiidentitylink);
            ps.setString(13, fgacthiidentitylink.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiIdentitylink> fgacthiidentitylinks) throws SQLException {
        if (fgacthiidentitylinks == null || fgacthiidentitylinks.isEmpty())
            return new int[0];
        for (FgActHiIdentitylink fgacthiidentitylink : fgacthiidentitylinks) {
            if (fgacthiidentitylink == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthiidentitylink.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiIdentitylink>> batches = chunkList(fgacthiidentitylinks, batchSize);
        int[] totalResults = new int[fgacthiidentitylinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiIdentitylink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiIdentitylink fgacthiidentitylink : batch) {
                        setFgActHiIdentitylinkParams(ps, fgacthiidentitylink);
                        ps.setString(13, fgacthiidentitylink.getID_());
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

    private void setFgActHiIdentitylinkParams(PreparedStatement ps, FgActHiIdentitylink fgacthiidentitylink) throws SQLException {
        ps.setString(1, fgacthiidentitylink.getID_());
        ps.setString(2, fgacthiidentitylink.getTimestamp_());
        ps.setString(3, fgacthiidentitylink.getType_());
        ps.setString(4, fgacthiidentitylink.getUserID_());
        ps.setString(5, fgacthiidentitylink.getGroupID_());
        ps.setString(6, fgacthiidentitylink.getTaskID_());
        ps.setString(7, fgacthiidentitylink.getProcDefID_());
        ps.setString(8, fgacthiidentitylink.getOperationType_());
        ps.setString(9, fgacthiidentitylink.getAssignerID_());
        ps.setString(10, fgacthiidentitylink.getProcDefKey_());
        ps.setString(11, fgacthiidentitylink.getTenantID_());
        ps.setString(12, fgacthiidentitylink.getRootProcInstID_());
        ps.setString(13, fgacthiidentitylink.getRemovalTime_());
    }

    private FgActHiIdentitylink extract(ResultSet rs) throws SQLException {
        FgActHiIdentitylink fgacthiidentitylink = new FgActHiIdentitylink();
        fgacthiidentitylink.setID_(rs.getString(COL_ID_));
        fgacthiidentitylink.setTimestamp_(rs.getString(COL_TIMESTAMP_));
        fgacthiidentitylink.setType_(rs.getString(COL_TYPE_));
        fgacthiidentitylink.setUserID_(rs.getString(COL_USER_ID_));
        fgacthiidentitylink.setGroupID_(rs.getString(COL_GROUP_ID_));
        fgacthiidentitylink.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthiidentitylink.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthiidentitylink.setOperationType_(rs.getString(COL_OPERATION_TYPE_));
        fgacthiidentitylink.setAssignerID_(rs.getString(COL_ASSIGNER_ID_));
        fgacthiidentitylink.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthiidentitylink.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthiidentitylink.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthiidentitylink.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthiidentitylink;
    }
}
