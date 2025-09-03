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

public class JdbcFgActHiProcinstDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiProcinstDao.class);

    private static final String TABLE = "FG_ACT_HI_PROCINST";

    private static final String COL_ID_ = "ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_BUSINESS_KEY_ = "BUSINESS_KEY_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_START_TIME_ = "START_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_DURATION_ = "DURATION_";

    private static final String COL_START_USER_ID_ = "START_USER_ID_";

    private static final String COL_START_ACT_ID_ = "START_ACT_ID_";

    private static final String COL_END_ACT_ID_ = "END_ACT_ID_";

    private static final String COL_SUPER_PROCESS_INSTANCE_ID_ = "SUPER_PROCESS_INSTANCE_ID_";

    private static final String COL_SUPER_CASE_INSTANCE_ID_ = "SUPER_CASE_INSTANCE_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_DELETE_REASON_ = "DELETE_REASON_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_STATE_ = "STATE_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_PROC_INST_ID_, COL_BUSINESS_KEY_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_START_USER_ID_, COL_START_ACT_ID_, COL_END_ACT_ID_, COL_SUPER_PROCESS_INSTANCE_ID_, COL_SUPER_CASE_INSTANCE_ID_, COL_CASE_INST_ID_, COL_DELETE_REASON_, COL_TENANT_ID_, COL_STATE_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, PROC_INST_ID_, BUSINESS_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, START_TIME_, END_TIME_, DURATION_, START_USER_ID_, START_ACT_ID_, END_ACT_ID_, SUPER_PROCESS_INSTANCE_ID_, SUPER_CASE_INSTANCE_ID_, CASE_INST_ID_, DELETE_REASON_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, PROC_INST_ID_, BUSINESS_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, START_TIME_, END_TIME_, DURATION_, START_USER_ID_, START_ACT_ID_, END_ACT_ID_, SUPER_PROCESS_INSTANCE_ID_, SUPER_CASE_INSTANCE_ID_, CASE_INST_ID_, DELETE_REASON_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PROC_INST_ID_, COL_BUSINESS_KEY_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_START_TIME_, COL_END_TIME_, COL_DURATION_, COL_START_USER_ID_, COL_START_ACT_ID_, COL_END_ACT_ID_, COL_SUPER_PROCESS_INSTANCE_ID_, COL_SUPER_CASE_INSTANCE_ID_, COL_CASE_INST_ID_, COL_DELETE_REASON_, COL_TENANT_ID_, COL_STATE_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiProcinst fgacthiprocinst) throws SQLException {
        logger.debug("Inserting fgacthiprocinst: {}", fgacthiprocinst);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiProcinstParams(ps, fgacthiprocinst);
            ps.executeUpdate();
            return fgacthiprocinst.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiProcinst> fgacthiprocinsts) throws SQLException {
        if (fgacthiprocinsts == null || fgacthiprocinsts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthiprocinsts.size(); i++) {
            if (fgacthiprocinsts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiProcinst>> batches = chunkList(fgacthiprocinsts, batchSize);
        int[] totalResults = new int[fgacthiprocinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiProcinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiProcinst fgacthiprocinst : batch) {
                        setFgActHiProcinstParams(ps, fgacthiprocinst);
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

    public FgActHiProcinst findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiProcinst> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiProcinst> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiProcinst fgacthiprocinst) throws SQLException {
        if (fgacthiprocinst.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiProcinstParams(ps, fgacthiprocinst);
            ps.setString(19, fgacthiprocinst.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiProcinst> fgacthiprocinsts) throws SQLException {
        if (fgacthiprocinsts == null || fgacthiprocinsts.isEmpty())
            return new int[0];
        for (FgActHiProcinst fgacthiprocinst : fgacthiprocinsts) {
            if (fgacthiprocinst == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthiprocinst.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiProcinst>> batches = chunkList(fgacthiprocinsts, batchSize);
        int[] totalResults = new int[fgacthiprocinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiProcinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiProcinst fgacthiprocinst : batch) {
                        setFgActHiProcinstParams(ps, fgacthiprocinst);
                        ps.setString(19, fgacthiprocinst.getID_());
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

    private void setFgActHiProcinstParams(PreparedStatement ps, FgActHiProcinst fgacthiprocinst) throws SQLException {
        ps.setString(1, fgacthiprocinst.getID_());
        ps.setString(2, fgacthiprocinst.getProcInstID_());
        ps.setString(3, fgacthiprocinst.getBusinessKey_());
        ps.setString(4, fgacthiprocinst.getProcDefKey_());
        ps.setString(5, fgacthiprocinst.getProcDefID_());
        ps.setString(6, fgacthiprocinst.getStartTime_());
        ps.setString(7, fgacthiprocinst.getEndTime_());
        Integer val8 = fgacthiprocinst.getDuration_();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgacthiprocinst.getStartUserID_());
        ps.setString(10, fgacthiprocinst.getStartActID_());
        ps.setString(11, fgacthiprocinst.getEndActID_());
        ps.setString(12, fgacthiprocinst.getSuperProcessInstanceID_());
        ps.setString(13, fgacthiprocinst.getSuperCaseInstanceID_());
        ps.setString(14, fgacthiprocinst.getCaseInstID_());
        ps.setString(15, fgacthiprocinst.getDeleteReason_());
        ps.setString(16, fgacthiprocinst.getTenantID_());
        ps.setString(17, fgacthiprocinst.getState_());
        ps.setString(18, fgacthiprocinst.getRootProcInstID_());
        ps.setString(19, fgacthiprocinst.getRemovalTime_());
    }

    private FgActHiProcinst extract(ResultSet rs) throws SQLException {
        FgActHiProcinst fgacthiprocinst = new FgActHiProcinst();
        fgacthiprocinst.setID_(rs.getString(COL_ID_));
        fgacthiprocinst.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthiprocinst.setBusinessKey_(rs.getString(COL_BUSINESS_KEY_));
        fgacthiprocinst.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthiprocinst.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthiprocinst.setStartTime_(rs.getString(COL_START_TIME_));
        fgacthiprocinst.setEndTime_(rs.getString(COL_END_TIME_));
        Integer DURATION_ = rs.getObject(COL_DURATION_, Integer.class);
        fgacthiprocinst.setDuration_(DURATION_);
        fgacthiprocinst.setStartUserID_(rs.getString(COL_START_USER_ID_));
        fgacthiprocinst.setStartActID_(rs.getString(COL_START_ACT_ID_));
        fgacthiprocinst.setEndActID_(rs.getString(COL_END_ACT_ID_));
        fgacthiprocinst.setSuperProcessInstanceID_(rs.getString(COL_SUPER_PROCESS_INSTANCE_ID_));
        fgacthiprocinst.setSuperCaseInstanceID_(rs.getString(COL_SUPER_CASE_INSTANCE_ID_));
        fgacthiprocinst.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthiprocinst.setDeleteReason_(rs.getString(COL_DELETE_REASON_));
        fgacthiprocinst.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthiprocinst.setState_(rs.getString(COL_STATE_));
        fgacthiprocinst.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthiprocinst.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthiprocinst;
    }
}
