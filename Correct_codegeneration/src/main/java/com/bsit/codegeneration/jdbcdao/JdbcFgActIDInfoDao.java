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

public class JdbcFgActIDInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActIDInfoDao.class);

    private static final String TABLE = "FG_ACT_ID_INFO";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_KEY_ = "KEY_";

    private static final String COL_VALUE_ = "VALUE_";

    private static final String COL_PASSWORD_ = "PASSWORD_";

    private static final String COL_PARENT_ID_ = "PARENT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_USER_ID_, COL_TYPE_, COL_KEY_, COL_VALUE_, COL_PASSWORD_, COL_PARENT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PASSWORD_, PARENT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PASSWORD_, PARENT_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_USER_ID_, COL_TYPE_, COL_KEY_, COL_VALUE_, COL_PASSWORD_, COL_PARENT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActIDInfo fgactidinfo) throws SQLException {
        logger.debug("Inserting fgactidinfo: {}", fgactidinfo);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActIDInfoParams(ps, fgactidinfo);
            ps.executeUpdate();
            return fgactidinfo.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActIDInfo> fgactidinfos) throws SQLException {
        if (fgactidinfos == null || fgactidinfos.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactidinfos.size(); i++) {
            if (fgactidinfos.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDInfo>> batches = chunkList(fgactidinfos, batchSize);
        int[] totalResults = new int[fgactidinfos.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDInfo> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActIDInfo fgactidinfo : batch) {
                        setFgActIDInfoParams(ps, fgactidinfo);
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

    public FgActIDInfo findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActIDInfo> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActIDInfo> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActIDInfo fgactidinfo) throws SQLException {
        if (fgactidinfo.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActIDInfoParams(ps, fgactidinfo);
            ps.setString(8, fgactidinfo.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActIDInfo> fgactidinfos) throws SQLException {
        if (fgactidinfos == null || fgactidinfos.isEmpty())
            return new int[0];
        for (FgActIDInfo fgactidinfo : fgactidinfos) {
            if (fgactidinfo == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactidinfo.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActIDInfo>> batches = chunkList(fgactidinfos, batchSize);
        int[] totalResults = new int[fgactidinfos.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActIDInfo> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActIDInfo fgactidinfo : batch) {
                        setFgActIDInfoParams(ps, fgactidinfo);
                        ps.setString(8, fgactidinfo.getID_());
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

    private void setFgActIDInfoParams(PreparedStatement ps, FgActIDInfo fgactidinfo) throws SQLException {
        ps.setString(1, fgactidinfo.getID_());
        java.math.BigDecimal val2 = fgactidinfo.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactidinfo.getUserID_());
        ps.setString(4, fgactidinfo.getType_());
        ps.setString(5, fgactidinfo.getKey_());
        ps.setString(6, fgactidinfo.getValue_());
        ps.setBytes(7, fgactidinfo.getPassword_());
        ps.setString(8, fgactidinfo.getParentID_());
    }

    private FgActIDInfo extract(ResultSet rs) throws SQLException {
        FgActIDInfo fgactidinfo = new FgActIDInfo();
        fgactidinfo.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactidinfo.setRev_(REV_);
        fgactidinfo.setUserID_(rs.getString(COL_USER_ID_));
        fgactidinfo.setType_(rs.getString(COL_TYPE_));
        fgactidinfo.setKey_(rs.getString(COL_KEY_));
        fgactidinfo.setValue_(rs.getString(COL_VALUE_));
        fgactidinfo.setPassword_(rs.getBytes(COL_PASSWORD_));
        fgactidinfo.setParentID_(rs.getString(COL_PARENT_ID_));
        return fgactidinfo;
    }
}
