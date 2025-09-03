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

public class JdbcFgActHiCommentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiCommentDao.class);

    private static final String TABLE = "FG_ACT_HI_COMMENT";

    private static final String COL_ID_ = "ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_TIME_ = "TIME_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_TASK_ID_ = "TASK_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_ACTION_ = "ACTION_";

    private static final String COL_MESSAGE_ = "MESSAGE_";

    private static final String COL_FULL_MSG_ = "FULL_MSG_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_TYPE_, COL_TIME_, COL_USER_ID_, COL_TASK_ID_, COL_PROC_INST_ID_, COL_ACTION_, COL_MESSAGE_, COL_FULL_MSG_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, TYPE_, TIME_, USER_ID_, TASK_ID_, PROC_INST_ID_, ACTION_, MESSAGE_, FULL_MSG_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, TYPE_, TIME_, USER_ID_, TASK_ID_, PROC_INST_ID_, ACTION_, MESSAGE_, FULL_MSG_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TYPE_, COL_TIME_, COL_USER_ID_, COL_TASK_ID_, COL_PROC_INST_ID_, COL_ACTION_, COL_MESSAGE_, COL_FULL_MSG_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiComment fgacthicomment) throws SQLException {
        logger.debug("Inserting fgacthicomment: {}", fgacthicomment);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiCommentParams(ps, fgacthicomment);
            ps.executeUpdate();
            return fgacthicomment.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiComment> fgacthicomments) throws SQLException {
        if (fgacthicomments == null || fgacthicomments.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthicomments.size(); i++) {
            if (fgacthicomments.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiComment>> batches = chunkList(fgacthicomments, batchSize);
        int[] totalResults = new int[fgacthicomments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiComment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiComment fgacthicomment : batch) {
                        setFgActHiCommentParams(ps, fgacthicomment);
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

    public FgActHiComment findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiComment> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiComment> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiComment fgacthicomment) throws SQLException {
        if (fgacthicomment.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiCommentParams(ps, fgacthicomment);
            ps.setString(12, fgacthicomment.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiComment> fgacthicomments) throws SQLException {
        if (fgacthicomments == null || fgacthicomments.isEmpty())
            return new int[0];
        for (FgActHiComment fgacthicomment : fgacthicomments) {
            if (fgacthicomment == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthicomment.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiComment>> batches = chunkList(fgacthicomments, batchSize);
        int[] totalResults = new int[fgacthicomments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiComment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiComment fgacthicomment : batch) {
                        setFgActHiCommentParams(ps, fgacthicomment);
                        ps.setString(12, fgacthicomment.getID_());
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

    private void setFgActHiCommentParams(PreparedStatement ps, FgActHiComment fgacthicomment) throws SQLException {
        ps.setString(1, fgacthicomment.getID_());
        ps.setString(2, fgacthicomment.getType_());
        ps.setString(3, fgacthicomment.getTime_());
        ps.setString(4, fgacthicomment.getUserID_());
        ps.setString(5, fgacthicomment.getTaskID_());
        ps.setString(6, fgacthicomment.getProcInstID_());
        ps.setString(7, fgacthicomment.getAction_());
        ps.setString(8, fgacthicomment.getMessage_());
        ps.setBytes(9, fgacthicomment.getFullMsg_());
        ps.setString(10, fgacthicomment.getTenantID_());
        ps.setString(11, fgacthicomment.getRootProcInstID_());
        ps.setString(12, fgacthicomment.getRemovalTime_());
    }

    private FgActHiComment extract(ResultSet rs) throws SQLException {
        FgActHiComment fgacthicomment = new FgActHiComment();
        fgacthicomment.setID_(rs.getString(COL_ID_));
        fgacthicomment.setType_(rs.getString(COL_TYPE_));
        fgacthicomment.setTime_(rs.getString(COL_TIME_));
        fgacthicomment.setUserID_(rs.getString(COL_USER_ID_));
        fgacthicomment.setTaskID_(rs.getString(COL_TASK_ID_));
        fgacthicomment.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthicomment.setAction_(rs.getString(COL_ACTION_));
        fgacthicomment.setMessage_(rs.getString(COL_MESSAGE_));
        fgacthicomment.setFullMsg_(rs.getBytes(COL_FULL_MSG_));
        fgacthicomment.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthicomment.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthicomment.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthicomment;
    }
}
