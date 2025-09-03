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

public class JdbcTabRefDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTabRefDao.class);

    private static final String TABLE = "TAB_REF";

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

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_TD_CODE1 = "TD_CODE1";

    private static final String COL_TD_CODE2 = "TD_CODE2";

    private static final String COL_TD_CODE3 = "TD_CODE3";

    private static final String COL_TD_CODE4 = "TD_CODE4";

    private static final String COL_TD_CODE5 = "TD_CODE5";

    private static final String COL_TD_CODE6 = "TD_CODE6";

    private static final String COL_TD_CODE7 = "TD_CODE7";

    private static final String COL_TD_CODE8 = "TD_CODE8";

    private static final String COL_TD_CODE9 = "TD_CODE9";

    private static final String COL_TD_CODE10 = "TD_CODE10";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TD_CODE1, COL_TD_CODE2, COL_TD_CODE3, COL_TD_CODE4, COL_TD_CODE5, COL_TD_CODE6, COL_TD_CODE7, COL_TD_CODE8, COL_TD_CODE9, COL_TD_CODE10);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_CODE1, TD_CODE2, TD_CODE3, TD_CODE4, TD_CODE5, TD_CODE6, TD_CODE7, TD_CODE8, TD_CODE9, TD_CODE10", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_CODE1, TD_CODE2, TD_CODE3, TD_CODE4, TD_CODE5, TD_CODE6, TD_CODE7, TD_CODE8, TD_CODE9, TD_CODE10", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_TD_CODE1, COL_TD_CODE2, COL_TD_CODE3, COL_TD_CODE4, COL_TD_CODE5, COL_TD_CODE6, COL_TD_CODE7, COL_TD_CODE8, COL_TD_CODE9, COL_TD_CODE10, COL_ID);

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

    public int insert(Connection conn, TabRef tabref) throws SQLException {
        logger.debug("Inserting tabref: {}", tabref);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setTabRefParams(ps, tabref);
            ps.executeUpdate();
            return tabref.getID();
        }
    }

    public int[] insertAll(Connection conn, List<TabRef> tabrefs) throws SQLException {
        if (tabrefs == null || tabrefs.isEmpty())
            return new int[0];
        for (int i = 0; i < tabrefs.size(); i++) {
            if (tabrefs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TabRef>> batches = chunkList(tabrefs, batchSize);
        int[] totalResults = new int[tabrefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TabRef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (TabRef tabref : batch) {
                        setTabRefParams(ps, tabref);
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

    public TabRef findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<TabRef> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<TabRef> list = new ArrayList<>();
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

    public boolean update(Connection conn, TabRef tabref) throws SQLException {
        if (tabref.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setTabRefParams(ps, tabref);
            ps.setInt(28, tabref.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<TabRef> tabrefs) throws SQLException {
        if (tabrefs == null || tabrefs.isEmpty())
            return new int[0];
        for (TabRef tabref : tabrefs) {
            if (tabref == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (tabref.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TabRef>> batches = chunkList(tabrefs, batchSize);
        int[] totalResults = new int[tabrefs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TabRef> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (TabRef tabref : batch) {
                        setTabRefParams(ps, tabref);
                        ps.setInt(28, tabref.getID());
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

    private void setTabRefParams(PreparedStatement ps, TabRef tabref) throws SQLException {
        Integer val1 = tabref.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = tabref.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, tabref.getTypeCode());
        ps.setString(4, tabref.getSubTypeCode());
        ps.setString(5, tabref.getActiveCode());
        ps.setString(6, tabref.getStageCode());
        ps.setString(7, tabref.getStatusCode());
        Integer val8 = tabref.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, tabref.getCreatedOn());
        java.math.BigDecimal val10 = tabref.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, tabref.getLastUpdatedOn());
        java.math.BigDecimal val12 = tabref.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, tabref.getLastAuthorisedOn());
        java.math.BigDecimal val14 = tabref.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, tabref.getTemplate());
        ps.setString(16, tabref.getApplicantParty());
        ps.setString(17, tabref.getFulfillmentParty());
        java.math.BigDecimal val18 = tabref.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, tabref.getTdCode1());
        java.time.LocalDateTime val20 = tabref.getTdCode2();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, tabref.getTdCode3());
        ps.setString(22, tabref.getTdCode4());
        ps.setString(23, tabref.getTdCode5());
        ps.setString(24, tabref.getTdCode6());
        ps.setString(25, tabref.getTdCode7());
        ps.setString(26, tabref.getTdCode8());
        ps.setString(27, tabref.getTdCode9());
        ps.setString(28, tabref.getTdCode10());
    }

    private TabRef extract(ResultSet rs) throws SQLException {
        TabRef tabref = new TabRef();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        tabref.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        tabref.setReferenceID(REFERENCE_ID);
        tabref.setTypeCode(rs.getString(COL_TYPE_CODE));
        tabref.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        tabref.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        tabref.setStageCode(rs.getString(COL_STAGE_CODE));
        tabref.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        tabref.setProcessID(PROCESS_ID);
        tabref.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        tabref.setCreatedBy(CREATED_BY);
        tabref.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        tabref.setLastUpdatedBy(LAST_UPDATED_BY);
        tabref.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        tabref.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        tabref.setTemplate(rs.getString(COL_TEMPLATE));
        tabref.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        tabref.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        tabref.setIsTemplate(IS_TEMPLATE);
        tabref.setTdCode1(rs.getString(COL_TD_CODE1));
        Timestamp TD_CODE2 = rs.getTimestamp(COL_TD_CODE2);
        if (TD_CODE2 != null)
            tabref.setTdCode2(TD_CODE2.toLocalDateTime());
        tabref.setTdCode3(rs.getString(COL_TD_CODE3));
        tabref.setTdCode4(rs.getString(COL_TD_CODE4));
        tabref.setTdCode5(rs.getString(COL_TD_CODE5));
        tabref.setTdCode6(rs.getString(COL_TD_CODE6));
        tabref.setTdCode7(rs.getString(COL_TD_CODE7));
        tabref.setTdCode8(rs.getString(COL_TD_CODE8));
        tabref.setTdCode9(rs.getString(COL_TD_CODE9));
        tabref.setTdCode10(rs.getString(COL_TD_CODE10));
        return tabref;
    }
}
