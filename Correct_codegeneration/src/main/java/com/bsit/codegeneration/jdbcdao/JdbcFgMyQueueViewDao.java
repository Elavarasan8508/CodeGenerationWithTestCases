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

public class JdbcFgMyQueueViewDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMyQueueViewDao.class);

    private static final String TABLE = "FG_MY_QUEUE_VIEW";

    private static final String COL_ID_ = "ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_GROUP_ID_ = "GROUP_ID_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_PROC_INST_ID_, COL_NAME_, COL_GROUP_ID_, COL_TENANT_ID_, COL_PROC_DEF_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, PROC_INST_ID_, NAME_, GROUP_ID_, TENANT_ID_, PROC_DEF_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, PROC_INST_ID_, NAME_, GROUP_ID_, TENANT_ID_, PROC_DEF_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PROC_INST_ID_, COL_NAME_, COL_GROUP_ID_, COL_TENANT_ID_, COL_PROC_DEF_ID_, COL_ID_);

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

    public String insert(Connection conn, FgMyQueueView fgmyqueueview) throws SQLException {
        logger.debug("Inserting fgmyqueueview: {}", fgmyqueueview);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMyQueueViewParams(ps, fgmyqueueview);
            ps.executeUpdate();
            return fgmyqueueview.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgMyQueueView> fgmyqueueviews) throws SQLException {
        if (fgmyqueueviews == null || fgmyqueueviews.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmyqueueviews.size(); i++) {
            if (fgmyqueueviews.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMyQueueView>> batches = chunkList(fgmyqueueviews, batchSize);
        int[] totalResults = new int[fgmyqueueviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMyQueueView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMyQueueView fgmyqueueview : batch) {
                        setFgMyQueueViewParams(ps, fgmyqueueview);
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

    public FgMyQueueView findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMyQueueView> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMyQueueView> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMyQueueView fgmyqueueview) throws SQLException {
        if (fgmyqueueview.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMyQueueViewParams(ps, fgmyqueueview);
            ps.setString(6, fgmyqueueview.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMyQueueView> fgmyqueueviews) throws SQLException {
        if (fgmyqueueviews == null || fgmyqueueviews.isEmpty())
            return new int[0];
        for (FgMyQueueView fgmyqueueview : fgmyqueueviews) {
            if (fgmyqueueview == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmyqueueview.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMyQueueView>> batches = chunkList(fgmyqueueviews, batchSize);
        int[] totalResults = new int[fgmyqueueviews.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMyQueueView> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMyQueueView fgmyqueueview : batch) {
                        setFgMyQueueViewParams(ps, fgmyqueueview);
                        ps.setString(6, fgmyqueueview.getID_());
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

    private void setFgMyQueueViewParams(PreparedStatement ps, FgMyQueueView fgmyqueueview) throws SQLException {
        ps.setString(1, fgmyqueueview.getID_());
        ps.setString(2, fgmyqueueview.getProcInstID_());
        ps.setString(3, fgmyqueueview.getName_());
        ps.setString(4, fgmyqueueview.getGroupID_());
        ps.setString(5, fgmyqueueview.getTenantID_());
        ps.setString(6, fgmyqueueview.getProcDefID_());
    }

    private FgMyQueueView extract(ResultSet rs) throws SQLException {
        FgMyQueueView fgmyqueueview = new FgMyQueueView();
        fgmyqueueview.setID_(rs.getString(COL_ID_));
        fgmyqueueview.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgmyqueueview.setName_(rs.getString(COL_NAME_));
        fgmyqueueview.setGroupID_(rs.getString(COL_GROUP_ID_));
        fgmyqueueview.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgmyqueueview.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        return fgmyqueueview;
    }
}
