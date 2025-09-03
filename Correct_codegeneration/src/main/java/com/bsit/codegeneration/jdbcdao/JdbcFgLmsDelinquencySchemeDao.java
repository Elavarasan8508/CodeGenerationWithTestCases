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

public class JdbcFgLmsDelinquencySchemeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLmsDelinquencySchemeDao.class);

    private static final String TABLE = "FG_LMS_DELINQUENCY_SCHEME";

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

    private static final String COL_DELINQUENCY_SCHEME_CODE = "DELINQUENCY_SCHEME_CODE";

    private static final String COL_DELINQUENCY_NAME = "DELINQUENCY_NAME";

    private static final String COL_ASSET_CLASSIFICATION = "ASSET_CLASSIFICATION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_DELINQUENCY_SCHEME_CODE, COL_DELINQUENCY_NAME, COL_ASSET_CLASSIFICATION, COL_VERSION_ID, COL_IS_MASTER_VERSION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME, ASSET_CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME, ASSET_CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_DELINQUENCY_SCHEME_CODE, COL_DELINQUENCY_NAME, COL_ASSET_CLASSIFICATION, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID);

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

    public int insert(Connection conn, FgLmsDelinquencyScheme fglmsdelinquencyscheme) throws SQLException {
        logger.debug("Inserting fglmsdelinquencyscheme: {}", fglmsdelinquencyscheme);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLmsDelinquencySchemeParams(ps, fglmsdelinquencyscheme);
            ps.executeUpdate();
            return fglmsdelinquencyscheme.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLmsDelinquencyScheme> fglmsdelinquencyschemes) throws SQLException {
        if (fglmsdelinquencyschemes == null || fglmsdelinquencyschemes.isEmpty())
            return new int[0];
        for (int i = 0; i < fglmsdelinquencyschemes.size(); i++) {
            if (fglmsdelinquencyschemes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsDelinquencyScheme>> batches = chunkList(fglmsdelinquencyschemes, batchSize);
        int[] totalResults = new int[fglmsdelinquencyschemes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsDelinquencyScheme> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLmsDelinquencyScheme fglmsdelinquencyscheme : batch) {
                        setFgLmsDelinquencySchemeParams(ps, fglmsdelinquencyscheme);
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

    public FgLmsDelinquencyScheme findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLmsDelinquencyScheme> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLmsDelinquencyScheme> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLmsDelinquencyScheme fglmsdelinquencyscheme) throws SQLException {
        if (fglmsdelinquencyscheme.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLmsDelinquencySchemeParams(ps, fglmsdelinquencyscheme);
            ps.setInt(23, fglmsdelinquencyscheme.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLmsDelinquencyScheme> fglmsdelinquencyschemes) throws SQLException {
        if (fglmsdelinquencyschemes == null || fglmsdelinquencyschemes.isEmpty())
            return new int[0];
        for (FgLmsDelinquencyScheme fglmsdelinquencyscheme : fglmsdelinquencyschemes) {
            if (fglmsdelinquencyscheme == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglmsdelinquencyscheme.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLmsDelinquencyScheme>> batches = chunkList(fglmsdelinquencyschemes, batchSize);
        int[] totalResults = new int[fglmsdelinquencyschemes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLmsDelinquencyScheme> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLmsDelinquencyScheme fglmsdelinquencyscheme : batch) {
                        setFgLmsDelinquencySchemeParams(ps, fglmsdelinquencyscheme);
                        ps.setInt(23, fglmsdelinquencyscheme.getID());
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

    private void setFgLmsDelinquencySchemeParams(PreparedStatement ps, FgLmsDelinquencyScheme fglmsdelinquencyscheme) throws SQLException {
        Integer val1 = fglmsdelinquencyscheme.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fglmsdelinquencyscheme.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fglmsdelinquencyscheme.getTypeCode());
        ps.setString(4, fglmsdelinquencyscheme.getSubTypeCode());
        ps.setString(5, fglmsdelinquencyscheme.getActiveCode());
        ps.setString(6, fglmsdelinquencyscheme.getStageCode());
        ps.setString(7, fglmsdelinquencyscheme.getStatusCode());
        Integer val8 = fglmsdelinquencyscheme.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fglmsdelinquencyscheme.getCreatedOn());
        java.math.BigDecimal val10 = fglmsdelinquencyscheme.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fglmsdelinquencyscheme.getLastUpdatedOn());
        java.math.BigDecimal val12 = fglmsdelinquencyscheme.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglmsdelinquencyscheme.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fglmsdelinquencyscheme.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglmsdelinquencyscheme.getTemplate());
        ps.setString(16, fglmsdelinquencyscheme.getApplicantParty());
        ps.setString(17, fglmsdelinquencyscheme.getFulfillmentParty());
        java.math.BigDecimal val18 = fglmsdelinquencyscheme.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fglmsdelinquencyscheme.getDelinquencySchemeCode());
        ps.setString(20, fglmsdelinquencyscheme.getDelinquencyName());
        ps.setString(21, fglmsdelinquencyscheme.getAssetClassification());
        Integer val22 = fglmsdelinquencyscheme.getVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        java.math.BigDecimal val23 = fglmsdelinquencyscheme.getIsMasterVersion();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
    }

    private FgLmsDelinquencyScheme extract(ResultSet rs) throws SQLException {
        FgLmsDelinquencyScheme fglmsdelinquencyscheme = new FgLmsDelinquencyScheme();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglmsdelinquencyscheme.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglmsdelinquencyscheme.setReferenceID(REFERENCE_ID);
        fglmsdelinquencyscheme.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglmsdelinquencyscheme.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglmsdelinquencyscheme.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglmsdelinquencyscheme.setStageCode(rs.getString(COL_STAGE_CODE));
        fglmsdelinquencyscheme.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglmsdelinquencyscheme.setProcessID(PROCESS_ID);
        fglmsdelinquencyscheme.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglmsdelinquencyscheme.setCreatedBy(CREATED_BY);
        fglmsdelinquencyscheme.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglmsdelinquencyscheme.setLastUpdatedBy(LAST_UPDATED_BY);
        fglmsdelinquencyscheme.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglmsdelinquencyscheme.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fglmsdelinquencyscheme.setTemplate(rs.getString(COL_TEMPLATE));
        fglmsdelinquencyscheme.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fglmsdelinquencyscheme.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fglmsdelinquencyscheme.setIsTemplate(IS_TEMPLATE);
        fglmsdelinquencyscheme.setDelinquencySchemeCode(rs.getString(COL_DELINQUENCY_SCHEME_CODE));
        fglmsdelinquencyscheme.setDelinquencyName(rs.getString(COL_DELINQUENCY_NAME));
        fglmsdelinquencyscheme.setAssetClassification(rs.getString(COL_ASSET_CLASSIFICATION));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fglmsdelinquencyscheme.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fglmsdelinquencyscheme.setIsMasterVersion(IS_MASTER_VERSION);
        return fglmsdelinquencyscheme;
    }
}
