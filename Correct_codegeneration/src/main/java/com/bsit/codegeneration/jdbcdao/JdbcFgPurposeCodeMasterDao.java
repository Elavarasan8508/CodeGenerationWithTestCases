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

public class JdbcFgPurposeCodeMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPurposeCodeMasterDao.class);

    private static final String TABLE = "FG_PURPOSE_CODE_MASTER";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TYPE = "TYPE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_MT103 = "MT103";

    private static final String COL_MT202 = "MT202";

    private static final String COL_MT103_202 = "MT103_202";

    private static final String COL_REQ_TYPE = "REQ_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_DESCRIPTION, COL_TYPE, COL_PRODUCT_CODE, COL_MT103, COL_MT202, COL_MT103_202, COL_REQ_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, PRODUCT_CODE, MT103, MT202, MT103_202, REQ_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, PRODUCT_CODE, MT103, MT202, MT103_202, REQ_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_DESCRIPTION, COL_TYPE, COL_PRODUCT_CODE, COL_MT103, COL_MT202, COL_MT103_202, COL_REQ_TYPE, COL_ID);

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

    public int insert(Connection conn, FgPurposeCodeMaster fgpurposecodemaster) throws SQLException {
        logger.debug("Inserting fgpurposecodemaster: {}", fgpurposecodemaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPurposeCodeMasterParams(ps, fgpurposecodemaster);
            ps.executeUpdate();
            return fgpurposecodemaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPurposeCodeMaster> fgpurposecodemasters) throws SQLException {
        if (fgpurposecodemasters == null || fgpurposecodemasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpurposecodemasters.size(); i++) {
            if (fgpurposecodemasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPurposeCodeMaster>> batches = chunkList(fgpurposecodemasters, batchSize);
        int[] totalResults = new int[fgpurposecodemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPurposeCodeMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPurposeCodeMaster fgpurposecodemaster : batch) {
                        setFgPurposeCodeMasterParams(ps, fgpurposecodemaster);
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

    public FgPurposeCodeMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPurposeCodeMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPurposeCodeMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgPurposeCodeMaster fgpurposecodemaster) throws SQLException {
        if (fgpurposecodemaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPurposeCodeMasterParams(ps, fgpurposecodemaster);
            ps.setInt(23, fgpurposecodemaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPurposeCodeMaster> fgpurposecodemasters) throws SQLException {
        if (fgpurposecodemasters == null || fgpurposecodemasters.isEmpty())
            return new int[0];
        for (FgPurposeCodeMaster fgpurposecodemaster : fgpurposecodemasters) {
            if (fgpurposecodemaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpurposecodemaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPurposeCodeMaster>> batches = chunkList(fgpurposecodemasters, batchSize);
        int[] totalResults = new int[fgpurposecodemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPurposeCodeMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPurposeCodeMaster fgpurposecodemaster : batch) {
                        setFgPurposeCodeMasterParams(ps, fgpurposecodemaster);
                        ps.setInt(23, fgpurposecodemaster.getID());
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

    private void setFgPurposeCodeMasterParams(PreparedStatement ps, FgPurposeCodeMaster fgpurposecodemaster) throws SQLException {
        Integer val1 = fgpurposecodemaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgpurposecodemaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgpurposecodemaster.getTypeCode());
        ps.setString(4, fgpurposecodemaster.getSubTypeCode());
        ps.setString(5, fgpurposecodemaster.getActiveCode());
        ps.setString(6, fgpurposecodemaster.getStageCode());
        ps.setString(7, fgpurposecodemaster.getStatusCode());
        ps.setString(8, fgpurposecodemaster.getCreatedOn());
        java.math.BigDecimal val9 = fgpurposecodemaster.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgpurposecodemaster.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgpurposecodemaster.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgpurposecodemaster.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgpurposecodemaster.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgpurposecodemaster.getTemplate());
        java.math.BigDecimal val15 = fgpurposecodemaster.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgpurposecodemaster.getPurposeCode());
        ps.setString(17, fgpurposecodemaster.getDescription());
        ps.setString(18, fgpurposecodemaster.getType());
        ps.setString(19, fgpurposecodemaster.getProductCode());
        ps.setString(20, fgpurposecodemaster.getMt103());
        ps.setString(21, fgpurposecodemaster.getMt202());
        ps.setString(22, fgpurposecodemaster.getMt103202());
        ps.setString(23, fgpurposecodemaster.getReqType());
    }

    private FgPurposeCodeMaster extract(ResultSet rs) throws SQLException {
        FgPurposeCodeMaster fgpurposecodemaster = new FgPurposeCodeMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpurposecodemaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgpurposecodemaster.setReferenceID(REFERENCE_ID);
        fgpurposecodemaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgpurposecodemaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgpurposecodemaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpurposecodemaster.setStageCode(rs.getString(COL_STAGE_CODE));
        fgpurposecodemaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpurposecodemaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpurposecodemaster.setCreatedBy(CREATED_BY);
        fgpurposecodemaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpurposecodemaster.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpurposecodemaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpurposecodemaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpurposecodemaster.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgpurposecodemaster.setIsTemplate(IS_TEMPLATE);
        fgpurposecodemaster.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgpurposecodemaster.setDescription(rs.getString(COL_DESCRIPTION));
        fgpurposecodemaster.setType(rs.getString(COL_TYPE));
        fgpurposecodemaster.setProductCode(rs.getString(COL_PRODUCT_CODE));
        fgpurposecodemaster.setMt103(rs.getString(COL_MT103));
        fgpurposecodemaster.setMt202(rs.getString(COL_MT202));
        fgpurposecodemaster.setMt103202(rs.getString(COL_MT103_202));
        fgpurposecodemaster.setReqType(rs.getString(COL_REQ_TYPE));
        return fgpurposecodemaster;
    }
}
