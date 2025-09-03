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

public class JdbcFgTrdPurposeCodeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdPurposeCodeDao.class);

    private static final String TABLE = "FG_TRD_PURPOSE_CODE";

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

    private static final String COL_CUR_CODE = "CUR_CODE";

    private static final String COL_AMT = "AMT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_XAR_LTEA_INDICATOR = "XAR_LTEA_INDICATOR";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_DESCRIPTION, COL_TYPE, COL_CUR_CODE, COL_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_PRODUCT_CODE, COL_IR_REFERENCE_ID, COL_XAR_LTEA_INDICATOR);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, CUR_CODE, AMT, PARENT_REF_ID, PARENT_VERSION_ID, PRODUCT_CODE, IR_REFERENCE_ID, XAR_LTEA_INDICATOR", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, CUR_CODE, AMT, PARENT_REF_ID, PARENT_VERSION_ID, PRODUCT_CODE, IR_REFERENCE_ID, XAR_LTEA_INDICATOR", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PURPOSE_CODE, COL_DESCRIPTION, COL_TYPE, COL_CUR_CODE, COL_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_PRODUCT_CODE, COL_IR_REFERENCE_ID, COL_XAR_LTEA_INDICATOR, COL_ID);

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

    public int insert(Connection conn, FgTrdPurposeCode fgtrdpurposecode) throws SQLException {
        logger.debug("Inserting fgtrdpurposecode: {}", fgtrdpurposecode);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdPurposeCodeParams(ps, fgtrdpurposecode);
            ps.executeUpdate();
            return fgtrdpurposecode.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdPurposeCode> fgtrdpurposecodes) throws SQLException {
        if (fgtrdpurposecodes == null || fgtrdpurposecodes.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdpurposecodes.size(); i++) {
            if (fgtrdpurposecodes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPurposeCode>> batches = chunkList(fgtrdpurposecodes, batchSize);
        int[] totalResults = new int[fgtrdpurposecodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPurposeCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdPurposeCode fgtrdpurposecode : batch) {
                        setFgTrdPurposeCodeParams(ps, fgtrdpurposecode);
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

    public FgTrdPurposeCode findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdPurposeCode> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdPurposeCode> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdPurposeCode fgtrdpurposecode) throws SQLException {
        if (fgtrdpurposecode.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdPurposeCodeParams(ps, fgtrdpurposecode);
            ps.setInt(25, fgtrdpurposecode.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdPurposeCode> fgtrdpurposecodes) throws SQLException {
        if (fgtrdpurposecodes == null || fgtrdpurposecodes.isEmpty())
            return new int[0];
        for (FgTrdPurposeCode fgtrdpurposecode : fgtrdpurposecodes) {
            if (fgtrdpurposecode == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdpurposecode.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPurposeCode>> batches = chunkList(fgtrdpurposecodes, batchSize);
        int[] totalResults = new int[fgtrdpurposecodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPurposeCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdPurposeCode fgtrdpurposecode : batch) {
                        setFgTrdPurposeCodeParams(ps, fgtrdpurposecode);
                        ps.setInt(25, fgtrdpurposecode.getID());
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

    private void setFgTrdPurposeCodeParams(PreparedStatement ps, FgTrdPurposeCode fgtrdpurposecode) throws SQLException {
        Integer val1 = fgtrdpurposecode.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdpurposecode.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdpurposecode.getTypeCode());
        ps.setString(4, fgtrdpurposecode.getSubTypeCode());
        ps.setString(5, fgtrdpurposecode.getActiveCode());
        ps.setString(6, fgtrdpurposecode.getStageCode());
        ps.setString(7, fgtrdpurposecode.getStatusCode());
        ps.setString(8, fgtrdpurposecode.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdpurposecode.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdpurposecode.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdpurposecode.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdpurposecode.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdpurposecode.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdpurposecode.getTemplate());
        java.math.BigDecimal val15 = fgtrdpurposecode.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdpurposecode.getPurposeCode());
        ps.setString(17, fgtrdpurposecode.getDescription());
        ps.setString(18, fgtrdpurposecode.getType());
        ps.setString(19, fgtrdpurposecode.getCurCode());
        java.math.BigDecimal val20 = fgtrdpurposecode.getAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        Integer val21 = fgtrdpurposecode.getParentRefID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fgtrdpurposecode.getParentVersionID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fgtrdpurposecode.getProductCode());
        Integer val24 = fgtrdpurposecode.getIrReferenceID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgtrdpurposecode.getXarLteaIndicator();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
    }

    private FgTrdPurposeCode extract(ResultSet rs) throws SQLException {
        FgTrdPurposeCode fgtrdpurposecode = new FgTrdPurposeCode();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdpurposecode.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdpurposecode.setReferenceID(REFERENCE_ID);
        fgtrdpurposecode.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdpurposecode.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdpurposecode.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdpurposecode.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdpurposecode.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdpurposecode.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdpurposecode.setCreatedBy(CREATED_BY);
        fgtrdpurposecode.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdpurposecode.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdpurposecode.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdpurposecode.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdpurposecode.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdpurposecode.setIsTemplate(IS_TEMPLATE);
        fgtrdpurposecode.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        fgtrdpurposecode.setDescription(rs.getString(COL_DESCRIPTION));
        fgtrdpurposecode.setType(rs.getString(COL_TYPE));
        fgtrdpurposecode.setCurCode(rs.getString(COL_CUR_CODE));
        java.math.BigDecimal AMT = rs.getObject(COL_AMT, java.math.BigDecimal.class);
        fgtrdpurposecode.setAmt(AMT);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtrdpurposecode.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtrdpurposecode.setParentVersionID(PARENT_VERSION_ID);
        fgtrdpurposecode.setProductCode(rs.getString(COL_PRODUCT_CODE));
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrdpurposecode.setIrReferenceID(IR_REFERENCE_ID);
        java.math.BigDecimal XAR_LTEA_INDICATOR = rs.getObject(COL_XAR_LTEA_INDICATOR, java.math.BigDecimal.class);
        fgtrdpurposecode.setXarLteaIndicator(XAR_LTEA_INDICATOR);
        return fgtrdpurposecode;
    }
}
