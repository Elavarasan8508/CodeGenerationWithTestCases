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

public class JdbcFgActIDUserDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActIDUserDao.class);

    private static final String TABLE = "FG_ACT_ID_USER";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_FIRST_ = "FIRST_";

    private static final String COL_LAST_ = "LAST_";

    private static final String COL_EMAIL_ = "EMAIL_";

    private static final String COL_PWD_ = "PWD_";

    private static final String COL_SALT_ = "SALT_";

    private static final String COL_PICTURE_ID_ = "PICTURE_ID_";

    private static final String COL_LOCK_EXP_TIME_ = "LOCK_EXP_TIME_";

    private static final String COL_ATTEMPTS_ = "ATTEMPTS_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_FIRST_, COL_LAST_, COL_EMAIL_, COL_PWD_, COL_SALT_, COL_PICTURE_ID_, COL_LOCK_EXP_TIME_, COL_ATTEMPTS_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, SALT_, PICTURE_ID_, LOCK_EXP_TIME_, ATTEMPTS_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, SALT_, PICTURE_ID_, LOCK_EXP_TIME_, ATTEMPTS_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_FIRST_, COL_LAST_, COL_EMAIL_, COL_PWD_, COL_SALT_, COL_PICTURE_ID_, COL_LOCK_EXP_TIME_, COL_ATTEMPTS_, COL_ID_);

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

    public String insert(Connection conn, FgActIDUser fgactiduser) throws SQLException {
        logger.debug("Inserting fgactiduser: {}", fgactiduser);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActIDUserParams(ps, fgactiduser);
            ps.executeUpdate();
            return fgactiduser.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActIDUser> fgactidusers) throws SQLException {
        if (fgactidusers == null || fgactidusers.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactidusers.size(); i++) {
            if (fgactidusers.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDUser>> batches = chunkList(fgactidusers, batchSize);
        int[] totalResults = new int[fgactidusers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDUser> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActIDUser fgactiduser : batch) {
                        setFgActIDUserParams(ps, fgactiduser);
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

    public FgActIDUser findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActIDUser> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActIDUser> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActIDUser fgactiduser) throws SQLException {
        if (fgactiduser.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActIDUserParams(ps, fgactiduser);
            ps.setString(10, fgactiduser.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActIDUser> fgactidusers) throws SQLException {
        if (fgactidusers == null || fgactidusers.isEmpty())
            return new int[0];
        for (FgActIDUser fgactiduser : fgactidusers) {
            if (fgactiduser == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactiduser.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDUser>> batches = chunkList(fgactidusers, batchSize);
        int[] totalResults = new int[fgactidusers.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDUser> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActIDUser fgactiduser : batch) {
                        setFgActIDUserParams(ps, fgactiduser);
                        ps.setString(10, fgactiduser.getID_());
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

    private void setFgActIDUserParams(PreparedStatement ps, FgActIDUser fgactiduser) throws SQLException {
        ps.setString(1, fgactiduser.getID_());
        java.math.BigDecimal val2 = fgactiduser.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactiduser.getFirst_());
        ps.setString(4, fgactiduser.getLast_());
        ps.setString(5, fgactiduser.getEmail_());
        ps.setString(6, fgactiduser.getPwd_());
        ps.setString(7, fgactiduser.getSalt_());
        ps.setString(8, fgactiduser.getPictureID_());
        ps.setString(9, fgactiduser.getLockExpTime_());
        java.math.BigDecimal val10 = fgactiduser.getAttempts_();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
    }

    private FgActIDUser extract(ResultSet rs) throws SQLException {
        FgActIDUser fgactiduser = new FgActIDUser();
        fgactiduser.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactiduser.setRev_(REV_);
        fgactiduser.setFirst_(rs.getString(COL_FIRST_));
        fgactiduser.setLast_(rs.getString(COL_LAST_));
        fgactiduser.setEmail_(rs.getString(COL_EMAIL_));
        fgactiduser.setPwd_(rs.getString(COL_PWD_));
        fgactiduser.setSalt_(rs.getString(COL_SALT_));
        fgactiduser.setPictureID_(rs.getString(COL_PICTURE_ID_));
        fgactiduser.setLockExpTime_(rs.getString(COL_LOCK_EXP_TIME_));
        java.math.BigDecimal ATTEMPTS_ = rs.getObject(COL_ATTEMPTS_, java.math.BigDecimal.class);
        fgactiduser.setAttempts_(ATTEMPTS_);
        return fgactiduser;
    }
}
