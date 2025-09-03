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

public class JdbcFgActGeBytearrayDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActGeBytearrayDao.class);

    private static final String TABLE = "FG_ACT_GE_BYTEARRAY";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_BYTES_ = "BYTES_";

    private static final String COL_GENERATED_ = "GENERATED_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_TYPE_ = "TYPE_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_NAME_, COL_DEPLOYMENT_ID_, COL_BYTES_, COL_GENERATED_, COL_TENANT_ID_, COL_TYPE_, COL_CREATE_TIME_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_BY_DEPLOYMENT_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_DEPLOYMENT_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_NAME_, COL_DEPLOYMENT_ID_, COL_BYTES_, COL_GENERATED_, COL_TENANT_ID_, COL_TYPE_, COL_CREATE_TIME_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActGeBytearray fgactgebytearray) throws SQLException {
        logger.debug("Inserting fgactgebytearray: {}", fgactgebytearray);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActGeBytearrayParams(ps, fgactgebytearray);
            ps.executeUpdate();
            return fgactgebytearray.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActGeBytearray> fgactgebytearrays) throws SQLException {
        if (fgactgebytearrays == null || fgactgebytearrays.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactgebytearrays.size(); i++) {
            if (fgactgebytearrays.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActGeBytearray>> batches = chunkList(fgactgebytearrays, batchSize);
        int[] totalResults = new int[fgactgebytearrays.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActGeBytearray> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActGeBytearray fgactgebytearray : batch) {
                        setFgActGeBytearrayParams(ps, fgactgebytearray);
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

    public FgActGeBytearray findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActGeBytearray> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActGeBytearray> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActGeBytearray fgactgebytearray) throws SQLException {
        if (fgactgebytearray.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActGeBytearrayParams(ps, fgactgebytearray);
            ps.setString(11, fgactgebytearray.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActGeBytearray> fgactgebytearrays) throws SQLException {
        if (fgactgebytearrays == null || fgactgebytearrays.isEmpty())
            return new int[0];
        for (FgActGeBytearray fgactgebytearray : fgactgebytearrays) {
            if (fgactgebytearray == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactgebytearray.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActGeBytearray>> batches = chunkList(fgactgebytearrays, batchSize);
        int[] totalResults = new int[fgactgebytearrays.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActGeBytearray> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActGeBytearray fgactgebytearray : batch) {
                        setFgActGeBytearrayParams(ps, fgactgebytearray);
                        ps.setString(11, fgactgebytearray.getID_());
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

    public List<FgActGeBytearray> findByDeploymentID_(Connection conn, String deploymentID_) throws SQLException {
        List<FgActGeBytearray> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_DEPLOYMENT_ID__SQL)) {
            ps.setString(1, deploymentID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActGeBytearrayParams(PreparedStatement ps, FgActGeBytearray fgactgebytearray) throws SQLException {
        ps.setString(1, fgactgebytearray.getID_());
        java.math.BigDecimal val2 = fgactgebytearray.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactgebytearray.getName_());
        if (fgactgebytearray.getDeploymentID_() != null) {
            ps.setString(4, fgactgebytearray.getDeploymentID_().getFgActReDeploymentID());
        } else {
            ps.setNull(4, Types.VARCHAR);
        }
        ps.setBytes(5, fgactgebytearray.getBytes_());
        java.math.BigDecimal val6 = fgactgebytearray.getGenerated_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgactgebytearray.getTenantID_());
        java.math.BigDecimal val8 = fgactgebytearray.getType_();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgactgebytearray.getCreateTime_());
        ps.setString(10, fgactgebytearray.getRootProcInstID_());
        ps.setString(11, fgactgebytearray.getRemovalTime_());
    }

    private FgActGeBytearray extract(ResultSet rs) throws SQLException {
        FgActGeBytearray fgactgebytearray = new FgActGeBytearray();
        fgactgebytearray.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactgebytearray.setRev_(REV_);
        fgactgebytearray.setName_(rs.getString(COL_NAME_));
        String DEPLOYMENT_ID_ = rs.getObject(COL_DEPLOYMENT_ID_, String.class);
        fgactgebytearray.setDeploymentID_(DEPLOYMENT_ID_);
        if (DEPLOYMENT_ID_ != null) {
            FgActReDeployment deploymentID_ = new FgActReDeployment();
            deploymentID_.setFgActReDeploymentID(DEPLOYMENT_ID_);
            fgactgebytearray.setDeploymentID_(deploymentID_);
        }
        fgactgebytearray.setBytes_(rs.getBytes(COL_BYTES_));
        java.math.BigDecimal GENERATED_ = rs.getObject(COL_GENERATED_, java.math.BigDecimal.class);
        fgactgebytearray.setGenerated_(GENERATED_);
        fgactgebytearray.setTenantID_(rs.getString(COL_TENANT_ID_));
        java.math.BigDecimal TYPE_ = rs.getObject(COL_TYPE_, java.math.BigDecimal.class);
        fgactgebytearray.setType_(TYPE_);
        fgactgebytearray.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        fgactgebytearray.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgactgebytearray.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgactgebytearray;
    }
}
