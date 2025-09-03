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

public class JdbcScfTxnBatchItemDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcScfTxnBatchItemDao.class);

    private static final String TABLE = "SCF_TXN_BATCH_ITEM";

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

    private static final String COL_BATCH_REF_ID = "BATCH_REF_ID";

    private static final String COL_TXN_REF_ID = "TXN_REF_ID";

    private static final String COL_ANCHOR_CRN = "ANCHOR_CRN";

    private static final String COL_TXN_TYPE_CODE = "TXN_TYPE_CODE";

    private static final String COL_TXN_SUB_TYPE_CODE = "TXN_SUB_TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BATCH_REF_ID, COL_TXN_REF_ID, COL_ANCHOR_CRN, COL_TXN_TYPE_CODE, COL_TXN_SUB_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BATCH_REF_ID, TXN_REF_ID, ANCHOR_CRN, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BATCH_REF_ID, TXN_REF_ID, ANCHOR_CRN, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BATCH_REF_ID, COL_TXN_REF_ID, COL_ANCHOR_CRN, COL_TXN_TYPE_CODE, COL_TXN_SUB_TYPE_CODE, COL_ID);

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

    public int insert(Connection conn, ScfTxnBatchItem scftxnbatchitem) throws SQLException {
        logger.debug("Inserting scftxnbatchitem: {}", scftxnbatchitem);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setScfTxnBatchItemParams(ps, scftxnbatchitem);
            ps.executeUpdate();
            return scftxnbatchitem.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ScfTxnBatchItem> scftxnbatchitems) throws SQLException {
        if (scftxnbatchitems == null || scftxnbatchitems.isEmpty())
            return new int[0];
        for (int i = 0; i < scftxnbatchitems.size(); i++) {
            if (scftxnbatchitems.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfTxnBatchItem>> batches = chunkList(scftxnbatchitems, batchSize);
        int[] totalResults = new int[scftxnbatchitems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfTxnBatchItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ScfTxnBatchItem scftxnbatchitem : batch) {
                        setScfTxnBatchItemParams(ps, scftxnbatchitem);
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

    public ScfTxnBatchItem findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ScfTxnBatchItem> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ScfTxnBatchItem> list = new ArrayList<>();
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

    public boolean update(Connection conn, ScfTxnBatchItem scftxnbatchitem) throws SQLException {
        if (scftxnbatchitem.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setScfTxnBatchItemParams(ps, scftxnbatchitem);
            ps.setInt(20, scftxnbatchitem.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ScfTxnBatchItem> scftxnbatchitems) throws SQLException {
        if (scftxnbatchitems == null || scftxnbatchitems.isEmpty())
            return new int[0];
        for (ScfTxnBatchItem scftxnbatchitem : scftxnbatchitems) {
            if (scftxnbatchitem == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (scftxnbatchitem.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ScfTxnBatchItem>> batches = chunkList(scftxnbatchitems, batchSize);
        int[] totalResults = new int[scftxnbatchitems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ScfTxnBatchItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ScfTxnBatchItem scftxnbatchitem : batch) {
                        setScfTxnBatchItemParams(ps, scftxnbatchitem);
                        ps.setInt(20, scftxnbatchitem.getID());
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

    private void setScfTxnBatchItemParams(PreparedStatement ps, ScfTxnBatchItem scftxnbatchitem) throws SQLException {
        Integer val1 = scftxnbatchitem.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = scftxnbatchitem.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, scftxnbatchitem.getTypeCode());
        ps.setString(4, scftxnbatchitem.getSubTypeCode());
        ps.setString(5, scftxnbatchitem.getActiveCode());
        ps.setString(6, scftxnbatchitem.getStageCode());
        ps.setString(7, scftxnbatchitem.getStatusCode());
        ps.setString(8, scftxnbatchitem.getCreatedOn());
        java.math.BigDecimal val9 = scftxnbatchitem.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, scftxnbatchitem.getLastUpdatedOn());
        java.math.BigDecimal val11 = scftxnbatchitem.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, scftxnbatchitem.getLastAuthorisedOn());
        java.math.BigDecimal val13 = scftxnbatchitem.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, scftxnbatchitem.getTemplate());
        java.math.BigDecimal val15 = scftxnbatchitem.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = scftxnbatchitem.getBatchRefID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        Integer val17 = scftxnbatchitem.getTxnRefID();
        if (val17 != null) {
            ps.setInt(17, val17);
        } else {
            ps.setNull(17, Types.INTEGER);
        }
        ps.setString(18, scftxnbatchitem.getAnchorCrn());
        ps.setString(19, scftxnbatchitem.getTxnTypeCode());
        ps.setString(20, scftxnbatchitem.getTxnSubTypeCode());
    }

    private ScfTxnBatchItem extract(ResultSet rs) throws SQLException {
        ScfTxnBatchItem scftxnbatchitem = new ScfTxnBatchItem();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        scftxnbatchitem.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        scftxnbatchitem.setReferenceID(REFERENCE_ID);
        scftxnbatchitem.setTypeCode(rs.getString(COL_TYPE_CODE));
        scftxnbatchitem.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        scftxnbatchitem.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        scftxnbatchitem.setStageCode(rs.getString(COL_STAGE_CODE));
        scftxnbatchitem.setStatusCode(rs.getString(COL_STATUS_CODE));
        scftxnbatchitem.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        scftxnbatchitem.setCreatedBy(CREATED_BY);
        scftxnbatchitem.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        scftxnbatchitem.setLastUpdatedBy(LAST_UPDATED_BY);
        scftxnbatchitem.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        scftxnbatchitem.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        scftxnbatchitem.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        scftxnbatchitem.setIsTemplate(IS_TEMPLATE);
        Integer BATCH_REF_ID = rs.getObject(COL_BATCH_REF_ID, Integer.class);
        scftxnbatchitem.setBatchRefID(BATCH_REF_ID);
        Integer TXN_REF_ID = rs.getObject(COL_TXN_REF_ID, Integer.class);
        scftxnbatchitem.setTxnRefID(TXN_REF_ID);
        scftxnbatchitem.setAnchorCrn(rs.getString(COL_ANCHOR_CRN));
        scftxnbatchitem.setTxnTypeCode(rs.getString(COL_TXN_TYPE_CODE));
        scftxnbatchitem.setTxnSubTypeCode(rs.getString(COL_TXN_SUB_TYPE_CODE));
        return scftxnbatchitem;
    }
}
