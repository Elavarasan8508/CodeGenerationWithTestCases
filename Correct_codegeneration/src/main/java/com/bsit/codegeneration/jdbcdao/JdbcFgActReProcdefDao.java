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

public class JdbcFgActReProcdefDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActReProcdefDao.class);

    private static final String TABLE = "FG_ACT_RE_PROCDEF";

    private static final String COL_ID_ = "ID_";

    private static final String COL_REV_ = "REV_";

    private static final String COL_CATEGORY_ = "CATEGORY_";

    private static final String COL_NAME_ = "NAME_";

    private static final String COL_KEY_ = "KEY_";

    private static final String COL_VERSION_ = "VERSION_";

    private static final String COL_DEPLOYMENT_ID_ = "DEPLOYMENT_ID_";

    private static final String COL_RESOURCE_NAME_ = "RESOURCE_NAME_";

    private static final String COL_DGRM_RESOURCE_NAME_ = "DGRM_RESOURCE_NAME_";

    private static final String COL_HAS_START_FORM_KEY_ = "HAS_START_FORM_KEY_";

    private static final String COL_SUSPENSION_STATE_ = "SUSPENSION_STATE_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_VERSION_TAG_ = "VERSION_TAG_";

    private static final String COL_HISTORY_TTL_ = "HISTORY_TTL_";

    private static final String COL_STARTABLE_ = "STARTABLE_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_REV_, COL_CATEGORY_, COL_NAME_, COL_KEY_, COL_VERSION_, COL_DEPLOYMENT_ID_, COL_RESOURCE_NAME_, COL_DGRM_RESOURCE_NAME_, COL_HAS_START_FORM_KEY_, COL_SUSPENSION_STATE_, COL_TENANT_ID_, COL_VERSION_TAG_, COL_HISTORY_TTL_, COL_STARTABLE_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_, VERSION_TAG_, HISTORY_TTL_, STARTABLE_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_, VERSION_TAG_, HISTORY_TTL_, STARTABLE_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REV_, COL_CATEGORY_, COL_NAME_, COL_KEY_, COL_VERSION_, COL_DEPLOYMENT_ID_, COL_RESOURCE_NAME_, COL_DGRM_RESOURCE_NAME_, COL_HAS_START_FORM_KEY_, COL_SUSPENSION_STATE_, COL_TENANT_ID_, COL_VERSION_TAG_, COL_HISTORY_TTL_, COL_STARTABLE_, COL_ID_);

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

    public String insert(Connection conn, FgActReProcdef fgactreprocdef) throws SQLException {
        logger.debug("Inserting fgactreprocdef: {}", fgactreprocdef);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActReProcdefParams(ps, fgactreprocdef);
            ps.executeUpdate();
            return fgactreprocdef.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActReProcdef> fgactreprocdefs) throws SQLException {
        if (fgactreprocdefs == null || fgactreprocdefs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgactreprocdefs.size(); i++) {
            if (fgactreprocdefs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActReProcdef>> batches = chunkList(fgactreprocdefs, batchSize);
        int[] totalResults = new int[fgactreprocdefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActReProcdef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActReProcdef fgactreprocdef : batch) {
                        setFgActReProcdefParams(ps, fgactreprocdef);
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

    public FgActReProcdef findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActReProcdef> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActReProcdef> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActReProcdef fgactreprocdef) throws SQLException {
        if (fgactreprocdef.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActReProcdefParams(ps, fgactreprocdef);
            ps.setString(15, fgactreprocdef.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActReProcdef> fgactreprocdefs) throws SQLException {
        if (fgactreprocdefs == null || fgactreprocdefs.isEmpty())
            return new int[0];
        for (FgActReProcdef fgactreprocdef : fgactreprocdefs) {
            if (fgactreprocdef == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgactreprocdef.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActReProcdef>> batches = chunkList(fgactreprocdefs, batchSize);
        int[] totalResults = new int[fgactreprocdefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActReProcdef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActReProcdef fgactreprocdef : batch) {
                        setFgActReProcdefParams(ps, fgactreprocdef);
                        ps.setString(15, fgactreprocdef.getID_());
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

    private void setFgActReProcdefParams(PreparedStatement ps, FgActReProcdef fgactreprocdef) throws SQLException {
        ps.setString(1, fgactreprocdef.getID_());
        java.math.BigDecimal val2 = fgactreprocdef.getRev_();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, fgactreprocdef.getCategory_());
        ps.setString(4, fgactreprocdef.getName_());
        ps.setString(5, fgactreprocdef.getKey_());
        java.math.BigDecimal val6 = fgactreprocdef.getVersion_();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgactreprocdef.getDeploymentID_());
        ps.setString(8, fgactreprocdef.getResourceName_());
        ps.setString(9, fgactreprocdef.getDgrmResourceName_());
        java.math.BigDecimal val10 = fgactreprocdef.getHasStartFormKey_();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        java.math.BigDecimal val11 = fgactreprocdef.getSuspensionState_();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgactreprocdef.getTenantID_());
        ps.setString(13, fgactreprocdef.getVersionTag_());
        java.math.BigDecimal val14 = fgactreprocdef.getHistoryTtl_();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgactreprocdef.getStartable_();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
    }

    private FgActReProcdef extract(ResultSet rs) throws SQLException {
        FgActReProcdef fgactreprocdef = new FgActReProcdef();
        fgactreprocdef.setID_(rs.getString(COL_ID_));
        java.math.BigDecimal REV_ = rs.getObject(COL_REV_, java.math.BigDecimal.class);
        fgactreprocdef.setRev_(REV_);
        fgactreprocdef.setCategory_(rs.getString(COL_CATEGORY_));
        fgactreprocdef.setName_(rs.getString(COL_NAME_));
        fgactreprocdef.setKey_(rs.getString(COL_KEY_));
        java.math.BigDecimal VERSION_ = rs.getObject(COL_VERSION_, java.math.BigDecimal.class);
        fgactreprocdef.setVersion_(VERSION_);
        fgactreprocdef.setDeploymentID_(rs.getString(COL_DEPLOYMENT_ID_));
        fgactreprocdef.setResourceName_(rs.getString(COL_RESOURCE_NAME_));
        fgactreprocdef.setDgrmResourceName_(rs.getString(COL_DGRM_RESOURCE_NAME_));
        java.math.BigDecimal HAS_START_FORM_KEY_ = rs.getObject(COL_HAS_START_FORM_KEY_, java.math.BigDecimal.class);
        fgactreprocdef.setHasStartFormKey_(HAS_START_FORM_KEY_);
        java.math.BigDecimal SUSPENSION_STATE_ = rs.getObject(COL_SUSPENSION_STATE_, java.math.BigDecimal.class);
        fgactreprocdef.setSuspensionState_(SUSPENSION_STATE_);
        fgactreprocdef.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgactreprocdef.setVersionTag_(rs.getString(COL_VERSION_TAG_));
        java.math.BigDecimal HISTORY_TTL_ = rs.getObject(COL_HISTORY_TTL_, java.math.BigDecimal.class);
        fgactreprocdef.setHistoryTtl_(HISTORY_TTL_);
        java.math.BigDecimal STARTABLE_ = rs.getObject(COL_STARTABLE_, java.math.BigDecimal.class);
        fgactreprocdef.setStartable_(STARTABLE_);
        return fgactreprocdef;
    }
}
