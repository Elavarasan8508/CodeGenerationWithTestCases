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

public class JdbcFgPartyClassificationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyClassificationDao.class);

    private static final String TABLE = "FG_PARTY_CLASSIFICATION";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_CLASS_TYPE_CODE = "CLASS_TYPE_CODE";

    private static final String COL_CLASS_SUB_TYPE_CODE = "CLASS_SUB_TYPE_CODE";

    private static final String COL_VALID_FROM = "VALID_FROM";

    private static final String COL_VALID_TO = "VALID_TO";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_DEMOGRAPHIC_TYPE_CODE = "DEMOGRAPHIC_TYPE_CODE";

    private static final String COL_DEMOGRAPHIC_SUB_TYPE_CODE = "DEMOGRAPHIC_SUB_TYPE_CODE";

    private static final String COL_SYS_DEFINED = "SYS_DEFINED";

    private static final String COL_SYSTEM_SOURCE_CODE = "SYSTEM_SOURCE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_CLASS_TYPE_CODE, COL_CLASS_SUB_TYPE_CODE, COL_VALID_FROM, COL_VALID_TO, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_DEMOGRAPHIC_TYPE_CODE, COL_DEMOGRAPHIC_SUB_TYPE_CODE, COL_SYS_DEFINED, COL_SYSTEM_SOURCE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED, SYSTEM_SOURCE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_CLASS_TYPE_CODE, COL_CLASS_SUB_TYPE_CODE, COL_VALID_FROM, COL_VALID_TO, COL_COMMENTS, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_DEMOGRAPHIC_TYPE_CODE, COL_DEMOGRAPHIC_SUB_TYPE_CODE, COL_SYS_DEFINED, COL_SYSTEM_SOURCE_CODE, COL_ID);

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

    public int insert(Connection conn, FgPartyClassification fgpartyclassification) throws SQLException {
        logger.debug("Inserting fgpartyclassification: {}", fgpartyclassification);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyClassificationParams(ps, fgpartyclassification);
            ps.executeUpdate();
            return fgpartyclassification.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyClassification> fgpartyclassifications) throws SQLException {
        if (fgpartyclassifications == null || fgpartyclassifications.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartyclassifications.size(); i++) {
            if (fgpartyclassifications.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyClassification>> batches = chunkList(fgpartyclassifications, batchSize);
        int[] totalResults = new int[fgpartyclassifications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyClassification> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyClassification fgpartyclassification : batch) {
                        setFgPartyClassificationParams(ps, fgpartyclassification);
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

    public FgPartyClassification findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyClassification> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyClassification> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPartyClassification fgpartyclassification) throws SQLException {
        if (fgpartyclassification.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyClassificationParams(ps, fgpartyclassification);
            ps.setInt(22, fgpartyclassification.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyClassification> fgpartyclassifications) throws SQLException {
        if (fgpartyclassifications == null || fgpartyclassifications.isEmpty())
            return new int[0];
        for (FgPartyClassification fgpartyclassification : fgpartyclassifications) {
            if (fgpartyclassification == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartyclassification.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyClassification>> batches = chunkList(fgpartyclassifications, batchSize);
        int[] totalResults = new int[fgpartyclassifications.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyClassification> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyClassification fgpartyclassification : batch) {
                        setFgPartyClassificationParams(ps, fgpartyclassification);
                        ps.setInt(22, fgpartyclassification.getID());
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

    private void setFgPartyClassificationParams(PreparedStatement ps, FgPartyClassification fgpartyclassification) throws SQLException {
        Integer val1 = fgpartyclassification.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpartyclassification.getPartyID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgpartyclassification.getPartyVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgpartyclassification.getPartySubTypeCode());
        ps.setString(5, fgpartyclassification.getPartyCode());
        ps.setString(6, fgpartyclassification.getClassTypeCode());
        ps.setString(7, fgpartyclassification.getClassSubTypeCode());
        java.time.LocalDateTime val8 = fgpartyclassification.getValidFrom();
        if (val8 != null) {
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(val8));
        } else {
            ps.setNull(8, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val9 = fgpartyclassification.getValidTo();
        if (val9 != null) {
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(val9));
        } else {
            ps.setNull(9, Types.TIMESTAMP);
        }
        ps.setString(10, fgpartyclassification.getComments());
        ps.setString(11, fgpartyclassification.getActiveCode());
        ps.setString(12, fgpartyclassification.getStatusCode());
        ps.setString(13, fgpartyclassification.getCreatedOn());
        java.math.BigDecimal val14 = fgpartyclassification.getCreatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgpartyclassification.getLastUpdatedOn());
        java.math.BigDecimal val16 = fgpartyclassification.getLastUpdatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgpartyclassification.getLastAuthorisedOn());
        java.math.BigDecimal val18 = fgpartyclassification.getLastAuthorisedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgpartyclassification.getDemographicTypeCode());
        ps.setString(20, fgpartyclassification.getDemographicSubTypeCode());
        java.math.BigDecimal val21 = fgpartyclassification.getSysDefined();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgpartyclassification.getSystemSourceCode());
    }

    private FgPartyClassification extract(ResultSet rs) throws SQLException {
        FgPartyClassification fgpartyclassification = new FgPartyClassification();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartyclassification.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgpartyclassification.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgpartyclassification.setPartyVersionID(PARTY_VERSION_ID);
        fgpartyclassification.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgpartyclassification.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgpartyclassification.setClassTypeCode(rs.getString(COL_CLASS_TYPE_CODE));
        fgpartyclassification.setClassSubTypeCode(rs.getString(COL_CLASS_SUB_TYPE_CODE));
        Timestamp VALID_FROM = rs.getTimestamp(COL_VALID_FROM);
        if (VALID_FROM != null)
            fgpartyclassification.setValidFrom(VALID_FROM.toLocalDateTime());
        Timestamp VALID_TO = rs.getTimestamp(COL_VALID_TO);
        if (VALID_TO != null)
            fgpartyclassification.setValidTo(VALID_TO.toLocalDateTime());
        fgpartyclassification.setComments(rs.getString(COL_COMMENTS));
        fgpartyclassification.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartyclassification.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartyclassification.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartyclassification.setCreatedBy(CREATED_BY);
        fgpartyclassification.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartyclassification.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartyclassification.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartyclassification.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartyclassification.setDemographicTypeCode(rs.getString(COL_DEMOGRAPHIC_TYPE_CODE));
        fgpartyclassification.setDemographicSubTypeCode(rs.getString(COL_DEMOGRAPHIC_SUB_TYPE_CODE));
        java.math.BigDecimal SYS_DEFINED = rs.getObject(COL_SYS_DEFINED, java.math.BigDecimal.class);
        fgpartyclassification.setSysDefined(SYS_DEFINED);
        fgpartyclassification.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        return fgpartyclassification;
    }
}
