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

public class JdbcFgRulesDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgRulesDao.class);

    private static final String TABLE = "FG_RULES";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TYPE = "TYPE";

    private static final String COL_GUIDANCE = "GUIDANCE";

    private static final String COL_SEVERITY = "SEVERITY";

    private static final String COL_CONDITION = "CONDITION";

    private static final String COL_CONFIG_KEY = "CONFIG_KEY";

    private static final String COL_KEY_VALUE = "KEY_VALUE";

    private static final String COL_COUNT = "COUNT";

    private static final String COL_COLUMN_DATA = "COLUMN_DATA";

    private static final String COL_DATA_SOURCE = "DATA_SOURCE";

    private static final String COL_DATA_SET = "DATA_SET";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_DESCRIPTION, COL_TYPE, COL_GUIDANCE, COL_SEVERITY, COL_CONDITION, COL_CONFIG_KEY, COL_KEY_VALUE, COL_COUNT, COL_COLUMN_DATA, COL_DATA_SOURCE, COL_DATA_SET);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DESCRIPTION, TYPE, GUIDANCE, SEVERITY, CONDITION, CONFIG_KEY, KEY_VALUE, COUNT, COLUMN_DATA, DATA_SOURCE, DATA_SET", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DESCRIPTION, TYPE, GUIDANCE, SEVERITY, CONDITION, CONFIG_KEY, KEY_VALUE, COUNT, COLUMN_DATA, DATA_SOURCE, DATA_SET", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_NAME, COL_DESCRIPTION, COL_TYPE, COL_GUIDANCE, COL_SEVERITY, COL_CONDITION, COL_CONFIG_KEY, COL_KEY_VALUE, COL_COUNT, COL_COLUMN_DATA, COL_DATA_SOURCE, COL_DATA_SET, COL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID);

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

    public int insert(Connection conn, FgRules fgrules) throws SQLException {
        logger.debug("Inserting fgrules: {}", fgrules);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgRulesParams(ps, fgrules);
            ps.executeUpdate();
            return fgrules.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgRules> fgruless) throws SQLException {
        if (fgruless == null || fgruless.isEmpty())
            return new int[0];
        for (int i = 0; i < fgruless.size(); i++) {
            if (fgruless.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRules>> batches = chunkList(fgruless, batchSize);
        int[] totalResults = new int[fgruless.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRules> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgRules fgrules : batch) {
                        setFgRulesParams(ps, fgrules);
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

    public FgRules findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgRules> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgRules> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgRules fgrules) throws SQLException {
        if (fgrules.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgRulesParams(ps, fgrules);
            ps.setInt(28, fgrules.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgRules> fgruless) throws SQLException {
        if (fgruless == null || fgruless.isEmpty())
            return new int[0];
        for (FgRules fgrules : fgruless) {
            if (fgrules == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgrules.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgRules>> batches = chunkList(fgruless, batchSize);
        int[] totalResults = new int[fgruless.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgRules> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgRules fgrules : batch) {
                        setFgRulesParams(ps, fgrules);
                        ps.setInt(28, fgrules.getID());
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

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Integer> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
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

    private void setFgRulesParams(PreparedStatement ps, FgRules fgrules) throws SQLException {
        Integer val1 = fgrules.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgrules.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgrules.getTypeCode());
        ps.setString(4, fgrules.getSubTypeCode());
        ps.setString(5, fgrules.getActiveCode());
        ps.setString(6, fgrules.getStageCode());
        ps.setString(7, fgrules.getStatusCode());
        Integer val8 = fgrules.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgrules.getCreatedOn());
        java.math.BigDecimal val10 = fgrules.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgrules.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgrules.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgrules.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgrules.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgrules.getTemplate());
        java.math.BigDecimal val16 = fgrules.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgrules.getName());
        ps.setString(18, fgrules.getDescription());
        ps.setString(19, fgrules.getType());
        ps.setString(20, fgrules.getGuidance());
        ps.setString(21, fgrules.getSeverity());
        ps.setString(22, fgrules.getCondition());
        ps.setString(23, fgrules.getConfigKey());
        ps.setString(24, fgrules.getKeyValue());
        ps.setString(25, fgrules.getCount());
        ps.setString(26, fgrules.getColumnData());
        ps.setString(27, fgrules.getDataSource());
        ps.setString(28, fgrules.getDataSet());
    }

    private FgRules extract(ResultSet rs) throws SQLException {
        FgRules fgrules = new FgRules();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgrules.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgrules.setReferenceID(REFERENCE_ID);
        fgrules.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgrules.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgrules.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgrules.setStageCode(rs.getString(COL_STAGE_CODE));
        fgrules.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgrules.setProcessID(PROCESS_ID);
        fgrules.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgrules.setCreatedBy(CREATED_BY);
        fgrules.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgrules.setLastUpdatedBy(LAST_UPDATED_BY);
        fgrules.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgrules.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgrules.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgrules.setIsTemplate(IS_TEMPLATE);
        fgrules.setName(rs.getString(COL_NAME));
        fgrules.setDescription(rs.getString(COL_DESCRIPTION));
        fgrules.setType(rs.getString(COL_TYPE));
        fgrules.setGuidance(rs.getString(COL_GUIDANCE));
        fgrules.setSeverity(rs.getString(COL_SEVERITY));
        fgrules.setCondition(rs.getString(COL_CONDITION));
        fgrules.setConfigKey(rs.getString(COL_CONFIG_KEY));
        fgrules.setKeyValue(rs.getString(COL_KEY_VALUE));
        fgrules.setCount(rs.getString(COL_COUNT));
        fgrules.setColumnData(rs.getString(COL_COLUMN_DATA));
        fgrules.setDataSource(rs.getString(COL_DATA_SOURCE));
        fgrules.setDataSet(rs.getString(COL_DATA_SET));
        return fgrules;
    }
}
