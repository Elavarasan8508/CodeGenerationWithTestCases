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

public class JdbcFgActRuIncidentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActRuIncidentDao.class);

    private static final String TABLE = "FG_ACT_RU_INCIDENT";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_INCIDENT_TIMESTAMP_ = "INCIDENT_TIMESTAMP_";

    private static final String COL_INCIDENT_MSG_ = "INCIDENT_MSG_";

    private static final String COL_INCIDENT_TYPE_ = "INCIDENT_TYPE_";

    private static final String COL_EXECUTION_ID_ = "EXECUTION_ID_";

    private static final String COL_ACTIVITY_ID_ = "ACTIVITY_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_CAUSE_INCIDENT_ID_ = "CAUSE_INCIDENT_ID_";

    private static final String COL_ROOT_CAUSE_INCIDENT_ID_ = "ROOT_CAUSE_INCIDENT_ID_";

    private static final String COL_CONFIGURATION_ = "CONFIGURATION_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_JOB_DEF_ID_ = "JOB_DEF_ID_";

    private static final String COL_FAILED_ACTIVITY_ID_ = "FAILED_ACTIVITY_ID_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_INCIDENT_TIMESTAMP_, COL_INCIDENT_MSG_, COL_INCIDENT_TYPE_, COL_EXECUTION_ID_, COL_ACTIVITY_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_CAUSE_INCIDENT_ID_, COL_ROOT_CAUSE_INCIDENT_ID_, COL_CONFIGURATION_, COL_TENANT_ID_, COL_JOB_DEF_ID_, COL_FAILED_ACTIVITY_ID_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_", TABLE, COL_ID_);

    private static final String SELECT_BY_CAUSE_INCIDENT_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_", TABLE, COL_CAUSE_INCIDENT_ID_);

    private static final String SELECT_BY_ROOT_CAUSE_INCIDENT_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_", TABLE, COL_ROOT_CAUSE_INCIDENT_ID_);

    private static final String SELECT_BY_JOB_DEF_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_", TABLE, COL_JOB_DEF_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_INCIDENT_TIMESTAMP_, COL_INCIDENT_MSG_, COL_INCIDENT_TYPE_, COL_EXECUTION_ID_, COL_ACTIVITY_ID_, COL_PROC_INST_ID_, COL_PROC_DEF_ID_, COL_CAUSE_INCIDENT_ID_, COL_ROOT_CAUSE_INCIDENT_ID_, COL_CONFIGURATION_, COL_TENANT_ID_, COL_JOB_DEF_ID_, COL_FAILED_ACTIVITY_ID_, COL_ID_);

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

    public String insert(Connection conn, FgActRuIncident fgactruincident) throws SQLException {
        logger.debug("Inserting fgactruincident: {}", fgactruincident);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActRuIncidentParams(ps, fgactruincident);
            ps.executeUpdate();
            return fgactruincident.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActRuIncident> fgactruincidents) throws SQLException {
        if (fgactruincidents == null || fgactruincidents.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactruincidents.size(); i++) {
            if (fgactruincidents.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuIncident>> batches = chunkList(fgactruincidents, batchSize);
        int[] totalResults = new int[fgactruincidents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuIncident> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActRuIncident fgactruincident : batch) {
                        setFgActRuIncidentParams(ps, fgactruincident);
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

    public FgActRuIncident findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActRuIncident> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActRuIncident> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActRuIncident fgactruincident) throws SQLException {
        if (fgactruincident.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActRuIncidentParams(ps, fgactruincident);
            ps.setString(15, fgactruincident.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActRuIncident> fgactruincidents) throws SQLException {
        if (fgactruincidents == null || fgactruincidents.isEmpty())
            return new int[0];
        for (FgActRuIncident fgactruincident : fgactruincidents) {
            if (fgactruincident == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactruincident.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActRuIncident>> batches = chunkList(fgactruincidents, batchSize);
        int[] totalResults = new int[fgactruincidents.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActRuIncident> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActRuIncident fgactruincident : batch) {
                        setFgActRuIncidentParams(ps, fgactruincident);
                        ps.setString(15, fgactruincident.getID_());
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

    public List<FgActRuIncident> findByCauseIncidentID_(Connection conn, String causeIncidentID_) throws SQLException {
        List<FgActRuIncident> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CAUSE_INCIDENT_ID__SQL)) {
            ps.setString(1, causeIncidentID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuIncident> findByRootCauseIncidentID_(Connection conn, String rootCauseIncidentID_) throws SQLException {
        List<FgActRuIncident> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ROOT_CAUSE_INCIDENT_ID__SQL)) {
            ps.setString(1, rootCauseIncidentID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgActRuIncident> findByJobDefID_(Connection conn, String jobDefID_) throws SQLException {
        List<FgActRuIncident> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_JOB_DEF_ID__SQL)) {
            ps.setString(1, jobDefID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActRuIncidentParams(PreparedStatement ps, FgActRuIncident fgactruincident) throws SQLException {
        ps.setString(1, fgactruincident.getID_());
        java.math.BigDecimal val2 = fgactruincident.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactruincident.getIncidentTimestamp_());
        ps.setString(4, fgactruincident.getIncidentMsg_());
        ps.setString(5, fgactruincident.getIncidentType_());
        ps.setString(6, fgactruincident.getExecutionID_());
        ps.setString(7, fgactruincident.getActivityID_());
        ps.setString(8, fgactruincident.getProcInstID_());
        ps.setString(9, fgactruincident.getProcDefID_());
        if (fgactruincident.getCauseIncidentID_() != null) {
            ps.setString(10, fgactruincident.getCauseIncidentID_().getFgActRuIncidentID());
        } else {
            ps.setNull(10, Types.VARCHAR);
        }
        if (fgactruincident.getRootCauseIncidentID_() != null) {
            ps.setString(11, fgactruincident.getRootCauseIncidentID_().getFgActRuIncidentID());
        } else {
            ps.setNull(11, Types.VARCHAR);
        }
        ps.setString(12, fgactruincident.getConfiguration_());
        ps.setString(13, fgactruincident.getTenantID_());
        if (fgactruincident.getJobDefID_() != null) {
            ps.setString(14, fgactruincident.getJobDefID_().getFgActRuJobdefID());
        } else {
            ps.setNull(14, Types.VARCHAR);
        }
        ps.setString(15, fgactruincident.getFailedActivityID_());
    }

    private FgActRuIncident extract(ResultSet rs) throws SQLException {
        FgActRuIncident fgactruincident = new FgActRuIncident();
        fgactruincident.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactruincident.setRev_(REV_);
        fgactruincident.setIncidentTimestamp_(rs.getString(COL_INCIDENT_TIMESTAMP_));
        fgactruincident.setIncidentMsg_(rs.getString(COL_INCIDENT_MSG_));
        fgactruincident.setIncidentType_(rs.getString(COL_INCIDENT_TYPE_));
        fgactruincident.setExecutionID_(rs.getString(COL_EXECUTION_ID_));
        fgactruincident.setActivityID_(rs.getString(COL_ACTIVITY_ID_));
        fgactruincident.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgactruincident.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        String CAUSE_INCIDENT_ID_ = rs.getObject(COL_CAUSE_INCIDENT_ID_, String.class);
        fgactruincident.setCauseIncidentID_(CAUSE_INCIDENT_ID_);
        if (CAUSE_INCIDENT_ID_ != null) {
            FgActRuIncident causeIncidentID_ = new FgActRuIncident();
            causeIncidentID_.setFgActRuIncidentID(CAUSE_INCIDENT_ID_);
            fgactruincident.setCauseIncidentID_(causeIncidentID_);
        }
        String ROOT_CAUSE_INCIDENT_ID_ = rs.getObject(COL_ROOT_CAUSE_INCIDENT_ID_, String.class);
        fgactruincident.setRootCauseIncidentID_(ROOT_CAUSE_INCIDENT_ID_);
        if (ROOT_CAUSE_INCIDENT_ID_ != null) {
            FgActRuIncident rootCauseIncidentID_ = new FgActRuIncident();
            rootCauseIncidentID_.setFgActRuIncidentID(ROOT_CAUSE_INCIDENT_ID_);
            fgactruincident.setRootCauseIncidentID_(rootCauseIncidentID_);
        }
        fgactruincident.setConfiguration_(rs.getString(COL_CONFIGURATION_));
        fgactruincident.setTenantID_(rs.getString(COL_TENANT_ID_));
        String JOB_DEF_ID_ = rs.getObject(COL_JOB_DEF_ID_, String.class);
        fgactruincident.setJobDefID_(JOB_DEF_ID_);
        if (JOB_DEF_ID_ != null) {
            FgActRuJobdef jobDefID_ = new FgActRuJobdef();
            jobDefID_.setFgActRuJobdefID(JOB_DEF_ID_);
            fgactruincident.setJobDefID_(jobDefID_);
        }
        fgactruincident.setFailedActivityID_(rs.getString(COL_FAILED_ACTIVITY_ID_));
        return fgactruincident;
    }
}
