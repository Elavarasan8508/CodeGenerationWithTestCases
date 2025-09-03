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

public class JdbcFgActReDecisionDefDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActReDecisionDefDao.class);

    private static final String TABLE = "FG_ACT_RE_DECISION_DEF";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_CATEGORY_ = "CATEGORY_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_KEY_ = "KEY_";

    private static final String COL_VERSION_ = "VERSION_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_RESOURCE_NAME_ = "RESOURCE_NAME_";

    private static final String COL_DGRM_RESOURCE_NAME_ = "DGRM_RESOURCE_NAME_";

    private static final String COL_DEC_REQ_ID_ = "DEC_REQ_ID_";

    private static final String COL_DEC_REQ_KEY_ = "DEC_REQ_KEY_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_HISTORY_TTL_ = "HISTORY_TTL_";

    private static final String COL_VERSION_TAG_ = "VERSION_TAG_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_CATEGORY_, COL_NAME_, COL_KEY_, COL_VERSION_, COL_DEPLOYMENT_ID_, COL_RESOURCE_NAME_, COL_DGRM_RESOURCE_NAME_, COL_DEC_REQ_ID_, COL_DEC_REQ_KEY_, COL_TENANT_ID_, COL_HISTORY_TTL_, COL_VERSION_TAG_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_", TABLE, COL_ID_);

    private static final String SELECT_BY_DEC_REQ_ID__SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_", TABLE, COL_DEC_REQ_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_CATEGORY_, COL_NAME_, COL_KEY_, COL_VERSION_, COL_DEPLOYMENT_ID_, COL_RESOURCE_NAME_, COL_DGRM_RESOURCE_NAME_, COL_DEC_REQ_ID_, COL_DEC_REQ_KEY_, COL_TENANT_ID_, COL_HISTORY_TTL_, COL_VERSION_TAG_, COL_ID_);

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

    public String insert(Connection conn, FgActReDecisionDef fgactredecisiondef) throws SQLException {
        logger.debug("Inserting fgactredecisiondef: {}", fgactredecisiondef);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActReDecisionDefParams(ps, fgactredecisiondef);
            ps.executeUpdate();
            return fgactredecisiondef.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActReDecisionDef> fgactredecisiondefs) throws SQLException {
        if (fgactredecisiondefs == null || fgactredecisiondefs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactredecisiondefs.size(); i++) {
            if (fgactredecisiondefs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActReDecisionDef>> batches = chunkList(fgactredecisiondefs, batchSize);
        int[] totalResults = new int[fgactredecisiondefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActReDecisionDef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActReDecisionDef fgactredecisiondef : batch) {
                        setFgActReDecisionDefParams(ps, fgactredecisiondef);
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

    public FgActReDecisionDef findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActReDecisionDef> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActReDecisionDef> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActReDecisionDef fgactredecisiondef) throws SQLException {
        if (fgactredecisiondef.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActReDecisionDefParams(ps, fgactredecisiondef);
            ps.setString(14, fgactredecisiondef.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActReDecisionDef> fgactredecisiondefs) throws SQLException {
        if (fgactredecisiondefs == null || fgactredecisiondefs.isEmpty())
            return new int[0];
        for (FgActReDecisionDef fgactredecisiondef : fgactredecisiondefs) {
            if (fgactredecisiondef == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactredecisiondef.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActReDecisionDef>> batches = chunkList(fgactredecisiondefs, batchSize);
        int[] totalResults = new int[fgactredecisiondefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActReDecisionDef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActReDecisionDef fgactredecisiondef : batch) {
                        setFgActReDecisionDefParams(ps, fgactredecisiondef);
                        ps.setString(14, fgactredecisiondef.getID_());
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

    public List<FgActReDecisionDef> findByDecReqID_(Connection conn, String decReqID_) throws SQLException {
        List<FgActReDecisionDef> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_DEC_REQ_ID__SQL)) {
            ps.setString(1, decReqID_);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgActReDecisionDefParams(PreparedStatement ps, FgActReDecisionDef fgactredecisiondef) throws SQLException {
        ps.setString(1, fgactredecisiondef.getID_());
        java.math.BigDecimal val2 = fgactredecisiondef.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactredecisiondef.getCategory_());
        ps.setString(4, fgactredecisiondef.getName_());
        ps.setString(5, fgactredecisiondef.getKey_());
        java.math.BigDecimal val6 = fgactredecisiondef.getVersion_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgactredecisiondef.getDeploymentID_());
        ps.setString(8, fgactredecisiondef.getResourceName_());
        ps.setString(9, fgactredecisiondef.getDgrmResourceName_());
        if (fgactredecisiondef.getDecReqID_() != null) {
            ps.setString(10, fgactredecisiondef.getDecReqID_().getFgActReDecisionReqDefID());
        } else {
            ps.setNull(10, Types.VARCHAR);
        }
        ps.setString(11, fgactredecisiondef.getDecReqKey_());
        ps.setString(12, fgactredecisiondef.getTenantID_());
        java.math.BigDecimal val13 = fgactredecisiondef.getHistoryTtl_();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgactredecisiondef.getVersionTag_());
    }

    private FgActReDecisionDef extract(ResultSet rs) throws SQLException {
        FgActReDecisionDef fgactredecisiondef = new FgActReDecisionDef();
        fgactredecisiondef.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactredecisiondef.setRev_(REV_);
        fgactredecisiondef.setCategory_(rs.getString(COL_CATEGORY_));
        fgactredecisiondef.setName_(rs.getString(COL_NAME_));
        fgactredecisiondef.setKey_(rs.getString(COL_KEY_));
        java.math.BigDecimal VERSION_ = rs.getObject(COL_VERSION_, java.math.BigDecimal.class);
        fgactredecisiondef.setVersion_(VERSION_);
        fgactredecisiondef.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        fgactredecisiondef.setResourceName_(rs.getString(COL_RESOURCE_NAME_));
        fgactredecisiondef.setDgrmResourceName_(rs.getString(COL_DGRM_RESOURCE_NAME_));
        String DEC_REQ_ID_ = rs.getObject(COL_DEC_REQ_ID_, String.class);
        fgactredecisiondef.setDecReqID_(DEC_REQ_ID_);
        if (DEC_REQ_ID_ != null) {
            FgActReDecisionReqDef decReqID_ = new FgActReDecisionReqDef();
            decReqID_.setFgActReDecisionReqDefID(DEC_REQ_ID_);
            fgactredecisiondef.setDecReqID_(decReqID_);
        }
        fgactredecisiondef.setDecReqKey_(rs.getString(COL_DEC_REQ_KEY_));
        fgactredecisiondef.setTenantID_(rs.getString(COL_TENANT_ID_));
        java.math.BigDecimal HISTORY_TTL_ = rs.getObject(COL_HISTORY_TTL_, java.math.BigDecimal.class);
        fgactredecisiondef.setHistoryTtl_(HISTORY_TTL_);
        fgactredecisiondef.setVersionTag_(rs.getString(COL_VERSION_TAG_));
        return fgactredecisiondef;
    }
}
