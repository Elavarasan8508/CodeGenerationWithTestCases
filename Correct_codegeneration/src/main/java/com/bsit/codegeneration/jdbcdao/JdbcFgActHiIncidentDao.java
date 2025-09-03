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

public class JdbcFgActHiIncidentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiIncidentDao.class);

    private static final String TABLE = "FG_ACT_HI_INCIDENT";

    private static final String COL_ID_ = "ID_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_END_TIME_ = "END_TIME_";

    private static final String COL_INCIDENT_MSG_ = "INCIDENT_MSG_";

    private static final String COL_INCIDENT_TYPE_ = "INCIDENT_TYPE_";

    private static final String COL_ACTIVITY_ID_ = "ACTIVITY_ID_";

    private static final String COL_CAUSE_INCIDENT_ID_ = "CAUSE_INCIDENT_ID_";

    private static final String COL_ROOT_CAUSE_INCIDENT_ID_ = "ROOT_CAUSE_INCIDENT_ID_";

    private static final String COL_CONFIGURATION_ = "CONFIGURATION_";

    private static final String COL_INCIDENT_STATE_ = "INCIDENT_STATE_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_JOB_DEF_ID_ = "JOB_DEF_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String COL_HISTORY_CONFIGURATION_ = "HISTORY_CONFIGURATION_";

    private static final String COL_FAILED_ACTIVITY_ID_ = "FAILED_ACTIVITY_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CREATE_TIME_, COL_END_TIME_, COL_INCIDENT_MSG_, COL_INCIDENT_TYPE_, COL_ACTIVITY_ID_, COL_CAUSE_INCIDENT_ID_, COL_ROOT_CAUSE_INCIDENT_ID_, COL_CONFIGURATION_, COL_INCIDENT_STATE_, COL_TENANT_ID_, COL_JOB_DEF_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_HISTORY_CONFIGURATION_, COL_FAILED_ACTIVITY_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CREATE_TIME_, END_TIME_, INCIDENT_MSG_, INCIDENT_TYPE_, ACTIVITY_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, INCIDENT_STATE_, TENANT_ID_, JOB_DEF_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CREATE_TIME_, END_TIME_, INCIDENT_MSG_, INCIDENT_TYPE_, ACTIVITY_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, INCIDENT_STATE_, TENANT_ID_, JOB_DEF_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_EXECUTION_ID_, COL_CREATE_TIME_, COL_END_TIME_, COL_INCIDENT_MSG_, COL_INCIDENT_TYPE_, COL_ACTIVITY_ID_, COL_CAUSE_INCIDENT_ID_, COL_ROOT_CAUSE_INCIDENT_ID_, COL_CONFIGURATION_, COL_INCIDENT_STATE_, COL_TENANT_ID_, COL_JOB_DEF_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_HISTORY_CONFIGURATION_, COL_FAILED_ACTIVITY_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActHiIncident fgacthiincident) throws SQLException {
        logger.debug("Inserting fgacthiincident: {}", fgacthiincident);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiIncidentParams(ps, fgacthiincident);
            ps.executeUpdate();
            return fgacthiincident.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiIncident> fgacthiincidents) throws SQLException {
        if (fgacthiincidents == null || fgacthiincidents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthiincidents.size(); i++) {
            if (fgacthiincidents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiIncident>> batches = chunkList(fgacthiincidents, batchSize);
        int[] totalResults = new int[fgacthiincidents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiIncident> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiIncident fgacthiincident : batch) {
                        setFgActHiIncidentParams(ps, fgacthiincident);
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

    public FgActHiIncident findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiIncident> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiIncident> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiIncident fgacthiincident) throws SQLException {
        if (fgacthiincident.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiIncidentParams(ps, fgacthiincident);
            ps.setString(20, fgacthiincident.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiIncident> fgacthiincidents) throws SQLException {
        if (fgacthiincidents == null || fgacthiincidents.isEmpty())
            return new int[0];
        for (FgActHiIncident fgacthiincident : fgacthiincidents) {
            if (fgacthiincident == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthiincident.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiIncident>> batches = chunkList(fgacthiincidents, batchSize);
        int[] totalResults = new int[fgacthiincidents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiIncident> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiIncident fgacthiincident : batch) {
                        setFgActHiIncidentParams(ps, fgacthiincident);
                        ps.setString(20, fgacthiincident.getID_());
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

    private void setFgActHiIncidentParams(PreparedStatement ps, FgActHiIncident fgacthiincident) throws SQLException {
        ps.setString(1, fgacthiincident.getID_());
        ps.setString(2, fgacthiincident.getProcDefKey_());
        ps.setString(3, fgacthiincident.getProcDefID_());
        ps.setString(4, fgacthiincident.getProcInstID_());
        ps.setString(5, fgacthiincident.getExecutionID_());
        ps.setString(6, fgacthiincident.getCreateTime_());
        ps.setString(7, fgacthiincident.getEndTime_());
        ps.setString(8, fgacthiincident.getIncidentMsg_());
        ps.setString(9, fgacthiincident.getIncidentType_());
        ps.setString(10, fgacthiincident.getActivityID_());
        ps.setString(11, fgacthiincident.getCauseIncidentID_());
        ps.setString(12, fgacthiincident.getRootCauseIncidentID_());
        ps.setString(13, fgacthiincident.getConfiguration_());
        java.math.BigDecimal val14 = fgacthiincident.getIncidentState_();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgacthiincident.getTenantID_());
        ps.setString(16, fgacthiincident.getJobDefID_());
        ps.setString(17, fgacthiincident.getRootProcInstID_());
        ps.setString(18, fgacthiincident.getRemovalTime_());
        ps.setString(19, fgacthiincident.getHistoryConfiguration_());
        ps.setString(20, fgacthiincident.getFailedActivityID_());
    }

    private FgActHiIncident extract(ResultSet rs) throws SQLException {
        FgActHiIncident fgacthiincident = new FgActHiIncident();
        fgacthiincident.setID_(rs.getString(COL_ID_));
        fgacthiincident.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthiincident.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthiincident.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthiincident.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgacthiincident.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        fgacthiincident.setEndTime_(rs.getString(COL_END_TIME_));
        fgacthiincident.setIncidentMsg_(rs.getString(COL_INCIDENT_MSG_));
        fgacthiincident.setIncidentType_(rs.getString(COL_INCIDENT_TYPE_));
        fgacthiincident.setActivityID_(rs.getString(COL_ACTIVITY_ID_));
        fgacthiincident.setCauseIncidentID_(rs.getString(COL_CAUSE_INCIDENT_ID_));
        fgacthiincident.setRootCauseIncidentID_(rs.getString(COL_ROOT_CAUSE_INCIDENT_ID_));
        fgacthiincident.setConfiguration_(rs.getString(COL_CONFIGURATION_));
        java.math.BigDecimal INCIDENT_STATE_ = rs.getObject(COL_INCIDENT_STATE_, java.math.BigDecimal.class);
        fgacthiincident.setIncidentState_(INCIDENT_STATE_);
        fgacthiincident.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthiincident.setJobDefID_(rs.getString(COL_JOB_DEF_ID_));
        fgacthiincident.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthiincident.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        fgacthiincident.setHistoryConfiguration_(rs.getString(COL_HISTORY_CONFIGURATION_));
        fgacthiincident.setFailedActivityID_(rs.getString(COL_FAILED_ACTIVITY_ID_));
        return fgacthiincident;
    }
}
