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

public class JdbcFgActIDMembershipDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActIDMembershipDao.class);

    private static final String TABLE = "FG_ACT_ID_MEMBERSHIP";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_GROUP_ID_ = "GROUP_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?)
        """.formatted(TABLE, COL_USER_ID_, COL_GROUP_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("USER_ID_, GROUP_ID_", TABLE, COL_USER_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("USER_ID_, GROUP_ID_", TABLE, COL_USER_ID_);

    private static final String SELECT_BY_GROUP_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("USER_ID_, GROUP_ID_", TABLE, COL_GROUP_ID_);

    private static final String SELECT_BY_USER_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("USER_ID_, GROUP_ID_", TABLE, COL_USER_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_GROUP_ID_, COL_USER_ID_);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_USER_ID_);

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

    public String insert(Connection conn, FgActIDMembership fgactidmembership) throws SQLException {
        logger.debug("Inserting fgactidmembership: {}", fgactidmembership);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActIDMembershipParams(ps, fgactidmembership);
            ps.executeUpdate();
            return fgactidmembership.getUserID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActIDMembership> fgactidmemberships) throws SQLException {
        if (fgactidmemberships == null || fgactidmemberships.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactidmemberships.size(); i++) {
            if (fgactidmemberships.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDMembership>> batches = chunkList(fgactidmemberships, batchSize);
        int[] totalResults = new int[fgactidmemberships.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDMembership> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActIDMembership fgactidmembership : batch) {
                        setFgActIDMembershipParams(ps, fgactidmembership);
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

    public FgActIDMembership findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActIDMembership> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActIDMembership> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActIDMembership fgactidmembership) throws SQLException {
        if (fgactidmembership.getUserID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActIDMembershipParams(ps, fgactidmembership);
            ps.setString(2, fgactidmembership.getUserID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActIDMembership> fgactidmemberships) throws SQLException {
        if (fgactidmemberships == null || fgactidmemberships.isEmpty())
            return new int[0];
        for (FgActIDMembership fgactidmembership : fgactidmemberships) {
            if (fgactidmembership == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactidmembership.getUserID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDMembership>> batches = chunkList(fgactidmemberships, batchSize);
        int[] totalResults = new int[fgactidmemberships.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDMembership> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActIDMembership fgactidmembership : batch) {
                        setFgActIDMembershipParams(ps, fgactidmembership);
                        ps.setString(2, fgactidmembership.getUserID_());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_USER_ID_, placeholders);
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

    public List<FgActIDMembership> findByGroupID_(Connection conn, String groupID_) throws SQLException {
        List<FgActIDMembership> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_GROUP_ID__SQL)) {
            ps.setString(1, groupID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActIDMembership> findByUserID_(Connection conn, String userID_) throws SQLException {
        List<FgActIDMembership> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_USER_ID__SQL)) {
            ps.setString(1, userID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActIDMembershipParams(PreparedStatement ps, FgActIDMembership fgactidmembership) throws SQLException {
        if (fgactidmembership.getUserID_() != null) {
            ps.setString(1, fgactidmembership.getUserID_().getFgActIDUserID());
        } else {
            ps.setNull(1, Types.VARCHAR);
        }
        if (fgactidmembership.getGroupID_() != null) {
            ps.setString(2, fgactidmembership.getGroupID_().getFgActIDGroupID());
        } else {
            ps.setNull(2, Types.VARCHAR);
        }
    }

    private FgActIDMembership extract(ResultSet rs) throws SQLException {
        FgActIDMembership fgactidmembership = new FgActIDMembership();
        String USER_ID_ = rs.getObject(COL_USER_ID_, String.class);
        fgactidmembership.setUserID_(USER_ID_);
        if (USER_ID_ != null) {
            FgActIDUser userID_ = new FgActIDUser();
            userID_.setFgActIDUserID(USER_ID_);
            fgactidmembership.setUserID_(userID_);
        }
        String GROUP_ID_ = rs.getObject(COL_GROUP_ID_, String.class);
        fgactidmembership.setGroupID_(GROUP_ID_);
        if (GROUP_ID_ != null) {
            FgActIDGroup groupID_ = new FgActIDGroup();
            groupID_.setFgActIDGroupID(GROUP_ID_);
            fgactidmembership.setGroupID_(groupID_);
        }
        return fgactidmembership;
    }
}
