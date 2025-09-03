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

public class JdbcFgActRuJobdefDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuJobdefDao.class);

    private static final String TABLE = "FG_ACT_RU_JOBDEF";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_JOB_TYPE_ = "JOB_TYPE_";

    private static final String COL_JOB_CONFIGURATION_ = "JOB_CONFIGURATION_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_JOB_PRIORITY_ = "JOB_PRIORITY_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_ACT_ID_, COL_JOB_TYPE_, COL_JOB_CONFIGURATION_, COL_SUSPENSION_STATE_, COL_JOB_PRIORITY_, COL_TENANT_ID_, COL_DEPLOYMENT_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, JOB_TYPE_, JOB_CONFIGURATION_, SUSPENSION_STATE_, JOB_PRIORITY_, TENANT_ID_, DEPLOYMENT_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, JOB_TYPE_, JOB_CONFIGURATION_, SUSPENSION_STATE_, JOB_PRIORITY_, TENANT_ID_, DEPLOYMENT_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_PROC_DEF_ID_, COL_PROC_DEF_KEY_, COL_ACT_ID_, COL_JOB_TYPE_, COL_JOB_CONFIGURATION_, COL_SUSPENSION_STATE_, COL_JOB_PRIORITY_, COL_TENANT_ID_, COL_DEPLOYMENT_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuJobdef fgactrujobdef) throws SQLException {
        logger.debug("Inserting fgactrujobdef: {}", fgactrujobdef);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuJobdefParams(ps, fgactrujobdef);
            ps.executeUpdate();
            return fgactrujobdef.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuJobdef> fgactrujobdefs) throws SQLException {
        if (fgactrujobdefs == null || fgactrujobdefs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactrujobdefs.size(); i++) {
            if (fgactrujobdefs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuJobdef>> batches = chunkList(fgactrujobdefs, batchSize);
        int[] totalResults = new int[fgactrujobdefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuJobdef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuJobdef fgactrujobdef : batch) {
                        setFgActRuJobdefParams(ps, fgactrujobdef);
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

    public FgActRuJobdef findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuJobdef> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuJobdef> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuJobdef fgactrujobdef) throws SQLException {
        if (fgactrujobdef.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuJobdefParams(ps, fgactrujobdef);
            ps.setString(11, fgactrujobdef.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuJobdef> fgactrujobdefs) throws SQLException {
        if (fgactrujobdefs == null || fgactrujobdefs.isEmpty())
            return new int[0];
        for (FgActRuJobdef fgactrujobdef : fgactrujobdefs) {
            if (fgactrujobdef == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactrujobdef.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuJobdef>> batches = chunkList(fgactrujobdefs, batchSize);
        int[] totalResults = new int[fgactrujobdefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuJobdef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuJobdef fgactrujobdef : batch) {
                        setFgActRuJobdefParams(ps, fgactrujobdef);
                        ps.setString(11, fgactrujobdef.getID_());
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

    private void setFgActRuJobdefParams(PreparedStatement ps, FgActRuJobdef fgactrujobdef) throws SQLException {
        ps.setString(1, fgactrujobdef.getID_());
        java.math.BigDecimal val2 = fgactrujobdef.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactrujobdef.getProcDefID_());
        ps.setString(4, fgactrujobdef.getProcDefKey_());
        ps.setString(5, fgactrujobdef.getActID_());
        ps.setString(6, fgactrujobdef.getJobType_());
        ps.setString(7, fgactrujobdef.getJobConfiguration_());
        java.math.BigDecimal val8 = fgactrujobdef.getSuspensionState_();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = fgactrujobdef.getJobPriority_();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgactrujobdef.getTenantID_());
        ps.setString(11, fgactrujobdef.getDeploymentID_());
    }

    private FgActRuJobdef extract(ResultSet rs) throws SQLException {
        FgActRuJobdef fgactrujobdef = new FgActRuJobdef();
        fgactrujobdef.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactrujobdef.setRev_(REV_);
        fgactrujobdef.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgactrujobdef.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgactrujobdef.setActID_(rs.getString(COL_ACT_ID_));
        fgactrujobdef.setJobType_(rs.getString(COL_JOB_TYPE_));
        fgactrujobdef.setJobConfiguration_(rs.getString(COL_JOB_CONFIGURATION_));
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactrujobdef.setSuspensionState_(SUSPENSION_STATE_);
        java.math.BigDecimal JOB_PRIORITY_ = rs.getObject(COL_JOB_PRIORITY_, java.math.BigDecimal.class);
        fgactrujobdef.setJobPriority_(JOB_PRIORITY_);
        fgactrujobdef.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactrujobdef.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        return fgactrujobdef;
    }
}
