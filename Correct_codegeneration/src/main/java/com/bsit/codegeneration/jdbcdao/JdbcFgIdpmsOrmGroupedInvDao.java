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

public class JdbcFgIdpmsOrmGroupedInvDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgIdpmsOrmGroupedInvDao.class);

    private static final String TABLE = "FG_IDPMS_ORM_GROUPED_INV";

    private static final String COL_INV_NUM = "INV_NUM";

    private static final String COL_UTIL_AMT = "UTIL_AMT";

    private static final String COL_ENDORSED_AMT = "ENDORSED_AMT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_INV_NUM, COL_UTIL_AMT, COL_ENDORSED_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TEMPLATE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("INV_NUM, UTIL_AMT, ENDORSED_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY", TABLE, COL_PARENT_REF_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("INV_NUM, UTIL_AMT, ENDORSED_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY", TABLE, COL_PARENT_REF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_INV_NUM, COL_UTIL_AMT, COL_ENDORSED_AMT, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_TEMPLATE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_LAST_UPDATED_ON, COL_LAST_AUTHORISED_ON, COL_CREATED_BY, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_BY, COL_PARENT_REF_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PARENT_REF_ID);

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

    public int insert(Connection conn, FgIdpmsOrmGroupedInv fgidpmsormgroupedinv) throws SQLException {
        logger.debug("Inserting fgidpmsormgroupedinv: {}", fgidpmsormgroupedinv);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgIdpmsOrmGroupedInvParams(ps, fgidpmsormgroupedinv);
            ps.executeUpdate();
            return fgidpmsormgroupedinv.getParentRefID();
        }
    }

    public int[] insertAll(Connection conn, List<FgIdpmsOrmGroupedInv> fgidpmsormgroupedinvs) throws SQLException {
        if (fgidpmsormgroupedinvs == null || fgidpmsormgroupedinvs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgidpmsormgroupedinvs.size(); i++) {
            if (fgidpmsormgroupedinvs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsOrmGroupedInv>> batches = chunkList(fgidpmsormgroupedinvs, batchSize);
        int[] totalResults = new int[fgidpmsormgroupedinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsOrmGroupedInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgIdpmsOrmGroupedInv fgidpmsormgroupedinv : batch) {
                        setFgIdpmsOrmGroupedInvParams(ps, fgidpmsormgroupedinv);
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

    public FgIdpmsOrmGroupedInv findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgIdpmsOrmGroupedInv> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgIdpmsOrmGroupedInv> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgIdpmsOrmGroupedInv fgidpmsormgroupedinv) throws SQLException {
        if (fgidpmsormgroupedinv.getParentRefID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgIdpmsOrmGroupedInvParams(ps, fgidpmsormgroupedinv);
            ps.setInt(21, fgidpmsormgroupedinv.getParentRefID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgIdpmsOrmGroupedInv> fgidpmsormgroupedinvs) throws SQLException {
        if (fgidpmsormgroupedinvs == null || fgidpmsormgroupedinvs.isEmpty())
            return new int[0];
        for (FgIdpmsOrmGroupedInv fgidpmsormgroupedinv : fgidpmsormgroupedinvs) {
            if (fgidpmsormgroupedinv == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgidpmsormgroupedinv.getParentRefID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgIdpmsOrmGroupedInv>> batches = chunkList(fgidpmsormgroupedinvs, batchSize);
        int[] totalResults = new int[fgidpmsormgroupedinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgIdpmsOrmGroupedInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgIdpmsOrmGroupedInv fgidpmsormgroupedinv : batch) {
                        setFgIdpmsOrmGroupedInvParams(ps, fgidpmsormgroupedinv);
                        ps.setInt(21, fgidpmsormgroupedinv.getParentRefID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PARENT_REF_ID, placeholders);
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

    private void setFgIdpmsOrmGroupedInvParams(PreparedStatement ps, FgIdpmsOrmGroupedInv fgidpmsormgroupedinv) throws SQLException {
        ps.setString(1, fgidpmsormgroupedinv.getInvNum());
        java.math.BigDecimal val2 = fgidpmsormgroupedinv.getUtilAmt();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        java.math.BigDecimal val3 = fgidpmsormgroupedinv.getEndorsedAmt();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        Integer val4 = fgidpmsormgroupedinv.getParentRefID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        Integer val5 = fgidpmsormgroupedinv.getParentVersionID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        java.math.BigDecimal val6 = fgidpmsormgroupedinv.getIsTemplate();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgidpmsormgroupedinv.getTemplate());
        Integer val8 = fgidpmsormgroupedinv.getID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        Integer val9 = fgidpmsormgroupedinv.getReferenceID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, fgidpmsormgroupedinv.getTypeCode());
        ps.setString(11, fgidpmsormgroupedinv.getSubTypeCode());
        ps.setString(12, fgidpmsormgroupedinv.getActiveCode());
        ps.setString(13, fgidpmsormgroupedinv.getStageCode());
        ps.setString(14, fgidpmsormgroupedinv.getStatusCode());
        Integer val15 = fgidpmsormgroupedinv.getProcessID();
        if (val15 != null) {
            ps.setInt(15, val15);
        } else {
            ps.setNull(15, Types.INTEGER);
        }
        java.time.LocalDateTime val16 = fgidpmsormgroupedinv.getCreatedOn();
        if (val16 != null) {
            ps.setTimestamp(16, java.sql.Timestamp.valueOf(val16));
        } else {
            ps.setNull(16, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val17 = fgidpmsormgroupedinv.getLastUpdatedOn();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val18 = fgidpmsormgroupedinv.getLastAuthorisedOn();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        ps.setString(19, fgidpmsormgroupedinv.getCreatedBy());
        ps.setString(20, fgidpmsormgroupedinv.getLastUpdatedBy());
        ps.setString(21, fgidpmsormgroupedinv.getLastAuthorisedBy());
    }

    private FgIdpmsOrmGroupedInv extract(ResultSet rs) throws SQLException {
        FgIdpmsOrmGroupedInv fgidpmsormgroupedinv = new FgIdpmsOrmGroupedInv();
        fgidpmsormgroupedinv.setInvNum(rs.getString(COL_INV_NUM));
        java.math.BigDecimal UTIL_AMT = rs.getObject(COL_UTIL_AMT, java.math.BigDecimal.class);
        fgidpmsormgroupedinv.setUtilAmt(UTIL_AMT);
        java.math.BigDecimal ENDORSED_AMT = rs.getObject(COL_ENDORSED_AMT, java.math.BigDecimal.class);
        fgidpmsormgroupedinv.setEndorsedAmt(ENDORSED_AMT);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgidpmsormgroupedinv.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgidpmsormgroupedinv.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgidpmsormgroupedinv.setIsTemplate(IS_TEMPLATE);
        fgidpmsormgroupedinv.setTemplate(rs.getString(COL_TEMPLATE));
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgidpmsormgroupedinv.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgidpmsormgroupedinv.setReferenceID(REFERENCE_ID);
        fgidpmsormgroupedinv.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgidpmsormgroupedinv.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgidpmsormgroupedinv.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgidpmsormgroupedinv.setStageCode(rs.getString(COL_STAGE_CODE));
        fgidpmsormgroupedinv.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgidpmsormgroupedinv.setProcessID(PROCESS_ID);
        Timestamp CREATED_ON = rs.getTimestamp(COL_CREATED_ON);
        if (CREATED_ON != null)
            fgidpmsormgroupedinv.setCreatedOn(CREATED_ON.toLocalDateTime());
        Timestamp LAST_UPDATED_ON = rs.getTimestamp(COL_LAST_UPDATED_ON);
        if (LAST_UPDATED_ON != null)
            fgidpmsormgroupedinv.setLastUpdatedOn(LAST_UPDATED_ON.toLocalDateTime());
        Timestamp LAST_AUTHORISED_ON = rs.getTimestamp(COL_LAST_AUTHORISED_ON);
        if (LAST_AUTHORISED_ON != null)
            fgidpmsormgroupedinv.setLastAuthorisedOn(LAST_AUTHORISED_ON.toLocalDateTime());
        fgidpmsormgroupedinv.setCreatedBy(rs.getString(COL_CREATED_BY));
        fgidpmsormgroupedinv.setLastUpdatedBy(rs.getString(COL_LAST_UPDATED_BY));
        fgidpmsormgroupedinv.setLastAuthorisedBy(rs.getString(COL_LAST_AUTHORISED_BY));
        return fgidpmsormgroupedinv;
    }
}
