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

public class JdbcTestPostProcessorDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTestPostProcessorDao.class);

    private static final String TABLE = "TEST_POST_PROCESSOR";

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

    private static final String COL_VALUE1 = "VALUE1";

    private static final String COL_VALUE2 = "VALUE2";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_ENTITY_REFERENCE_ID = "ENTITY_REFERENCE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_VALUE1, COL_VALUE2, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_VALUE1, COL_VALUE2, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_ENTITY_REFERENCE_ID, COL_ID);

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

    public int insert(Connection conn, TestPostProcessor testpostprocessor) throws SQLException {
        logger.debug("Inserting testpostprocessor: {}", testpostprocessor);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setTestPostProcessorParams(ps, testpostprocessor);
            ps.executeUpdate();
            return testpostprocessor.getID();
        }
    }

    public int[] insertAll(Connection conn, List<TestPostProcessor> testpostprocessors) throws SQLException {
        if (testpostprocessors == null || testpostprocessors.isEmpty())
            return new int[0];
        for (int i = 0; i < testpostprocessors.size(); i++) {
            if (testpostprocessors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TestPostProcessor>> batches = chunkList(testpostprocessors, batchSize);
        int[] totalResults = new int[testpostprocessors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TestPostProcessor> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (TestPostProcessor testpostprocessor : batch) {
                        setTestPostProcessorParams(ps, testpostprocessor);
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

    public TestPostProcessor findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<TestPostProcessor> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<TestPostProcessor> list = new ArrayList<>();
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

    public boolean update(Connection conn, TestPostProcessor testpostprocessor) throws SQLException {
        if (testpostprocessor.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setTestPostProcessorParams(ps, testpostprocessor);
            ps.setInt(23, testpostprocessor.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<TestPostProcessor> testpostprocessors) throws SQLException {
        if (testpostprocessors == null || testpostprocessors.isEmpty())
            return new int[0];
        for (TestPostProcessor testpostprocessor : testpostprocessors) {
            if (testpostprocessor == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (testpostprocessor.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<TestPostProcessor>> batches = chunkList(testpostprocessors, batchSize);
        int[] totalResults = new int[testpostprocessors.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<TestPostProcessor> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (TestPostProcessor testpostprocessor : batch) {
                        setTestPostProcessorParams(ps, testpostprocessor);
                        ps.setInt(23, testpostprocessor.getID());
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

    private void setTestPostProcessorParams(PreparedStatement ps, TestPostProcessor testpostprocessor) throws SQLException {
        Integer val1 = testpostprocessor.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = testpostprocessor.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, testpostprocessor.getTypeCode());
        ps.setString(4, testpostprocessor.getSubTypeCode());
        ps.setString(5, testpostprocessor.getActiveCode());
        ps.setString(6, testpostprocessor.getStageCode());
        ps.setString(7, testpostprocessor.getStatusCode());
        Integer val8 = testpostprocessor.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, testpostprocessor.getCreatedOn());
        java.math.BigDecimal val10 = testpostprocessor.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, testpostprocessor.getLastUpdatedOn());
        java.math.BigDecimal val12 = testpostprocessor.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, testpostprocessor.getLastAuthorisedOn());
        java.math.BigDecimal val14 = testpostprocessor.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, testpostprocessor.getTemplate());
        ps.setString(16, testpostprocessor.getApplicantParty());
        ps.setString(17, testpostprocessor.getFulfillmentParty());
        java.math.BigDecimal val18 = testpostprocessor.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, testpostprocessor.getValue1());
        ps.setString(20, testpostprocessor.getValue2());
        ps.setString(21, testpostprocessor.getEntityTypeCode());
        ps.setString(22, testpostprocessor.getEntitySubTypeCode());
        Integer val23 = testpostprocessor.getEntityReferenceID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
    }

    private TestPostProcessor extract(ResultSet rs) throws SQLException {
        TestPostProcessor testpostprocessor = new TestPostProcessor();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        testpostprocessor.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        testpostprocessor.setReferenceID(REFERENCE_ID);
        testpostprocessor.setTypeCode(rs.getString(COL_TYPE_CODE));
        testpostprocessor.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        testpostprocessor.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        testpostprocessor.setStageCode(rs.getString(COL_STAGE_CODE));
        testpostprocessor.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        testpostprocessor.setProcessID(PROCESS_ID);
        testpostprocessor.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        testpostprocessor.setCreatedBy(CREATED_BY);
        testpostprocessor.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        testpostprocessor.setLastUpdatedBy(LAST_UPDATED_BY);
        testpostprocessor.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        testpostprocessor.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        testpostprocessor.setTemplate(rs.getString(COL_TEMPLATE));
        testpostprocessor.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        testpostprocessor.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        testpostprocessor.setIsTemplate(IS_TEMPLATE);
        testpostprocessor.setValue1(rs.getString(COL_VALUE1));
        testpostprocessor.setValue2(rs.getString(COL_VALUE2));
        testpostprocessor.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        testpostprocessor.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer ENTITY_REFERENCE_ID = rs.getObject(COL_ENTITY_REFERENCE_ID, Integer.class);
        testpostprocessor.setEntityReferenceID(ENTITY_REFERENCE_ID);
        return testpostprocessor;
    }
}
