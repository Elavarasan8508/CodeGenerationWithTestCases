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

public class JdbcFgTrdApplFxRateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdApplFxRateDao.class);

    private static final String TABLE = "FG_TRD_APPL_FX_RATE";

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

    private static final String COL_DEAL_REFERENCE = "DEAL_REFERENCE";

    private static final String COL_BUYING_CUR = "BUYING_CUR";

    private static final String COL_BUYING_AMT = "BUYING_AMT";

    private static final String COL_SELLING_CUR = "SELLING_CUR";

    private static final String COL_SELLING_AMT = "SELLING_AMT";

    private static final String COL_FX_RATE = "FX_RATE";

    private static final String COL_BUY_AMT_ALLOC = "BUY_AMT_ALLOC";

    private static final String COL_SELL_AMT_ALLOC = "SELL_AMT_ALLOC";

    private static final String COL_ENTITY_REF_ID = "ENTITY_REF_ID";

    private static final String COL_IR_REFERENCE_ID = "IR_REFERENCE_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_DEAL_TYPE = "DEAL_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_DEAL_REFERENCE, COL_BUYING_CUR, COL_BUYING_AMT, COL_SELLING_CUR, COL_SELLING_AMT, COL_FX_RATE, COL_BUY_AMT_ALLOC, COL_SELL_AMT_ALLOC, COL_ENTITY_REF_ID, COL_IR_REFERENCE_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_DEAL_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, DEAL_REFERENCE, BUYING_CUR, BUYING_AMT, SELLING_CUR, SELLING_AMT, FX_RATE, BUY_AMT_ALLOC, SELL_AMT_ALLOC, ENTITY_REF_ID, IR_REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, DEAL_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, DEAL_REFERENCE, BUYING_CUR, BUYING_AMT, SELLING_CUR, SELLING_AMT, FX_RATE, BUY_AMT_ALLOC, SELL_AMT_ALLOC, ENTITY_REF_ID, IR_REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, DEAL_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_DEAL_REFERENCE, COL_BUYING_CUR, COL_BUYING_AMT, COL_SELLING_CUR, COL_SELLING_AMT, COL_FX_RATE, COL_BUY_AMT_ALLOC, COL_SELL_AMT_ALLOC, COL_ENTITY_REF_ID, COL_IR_REFERENCE_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_DEAL_TYPE, COL_ID);

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

    public int insert(Connection conn, FgTrdApplFxRate fgtrdapplfxrate) throws SQLException {
        logger.debug("Inserting fgtrdapplfxrate: {}", fgtrdapplfxrate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdApplFxRateParams(ps, fgtrdapplfxrate);
            ps.executeUpdate();
            return fgtrdapplfxrate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdApplFxRate> fgtrdapplfxrates) throws SQLException {
        if (fgtrdapplfxrates == null || fgtrdapplfxrates.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdapplfxrates.size(); i++) {
            if (fgtrdapplfxrates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdApplFxRate>> batches = chunkList(fgtrdapplfxrates, batchSize);
        int[] totalResults = new int[fgtrdapplfxrates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdApplFxRate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdApplFxRate fgtrdapplfxrate : batch) {
                        setFgTrdApplFxRateParams(ps, fgtrdapplfxrate);
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

    public FgTrdApplFxRate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdApplFxRate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdApplFxRate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdApplFxRate fgtrdapplfxrate) throws SQLException {
        if (fgtrdapplfxrate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdApplFxRateParams(ps, fgtrdapplfxrate);
            ps.setInt(28, fgtrdapplfxrate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdApplFxRate> fgtrdapplfxrates) throws SQLException {
        if (fgtrdapplfxrates == null || fgtrdapplfxrates.isEmpty())
            return new int[0];
        for (FgTrdApplFxRate fgtrdapplfxrate : fgtrdapplfxrates) {
            if (fgtrdapplfxrate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdapplfxrate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdApplFxRate>> batches = chunkList(fgtrdapplfxrates, batchSize);
        int[] totalResults = new int[fgtrdapplfxrates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdApplFxRate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdApplFxRate fgtrdapplfxrate : batch) {
                        setFgTrdApplFxRateParams(ps, fgtrdapplfxrate);
                        ps.setInt(28, fgtrdapplfxrate.getID());
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

    private void setFgTrdApplFxRateParams(PreparedStatement ps, FgTrdApplFxRate fgtrdapplfxrate) throws SQLException {
        Integer val1 = fgtrdapplfxrate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdapplfxrate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdapplfxrate.getTypeCode());
        ps.setString(4, fgtrdapplfxrate.getSubTypeCode());
        ps.setString(5, fgtrdapplfxrate.getActiveCode());
        ps.setString(6, fgtrdapplfxrate.getStageCode());
        ps.setString(7, fgtrdapplfxrate.getStatusCode());
        ps.setString(8, fgtrdapplfxrate.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdapplfxrate.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdapplfxrate.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdapplfxrate.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdapplfxrate.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdapplfxrate.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdapplfxrate.getTemplate());
        java.math.BigDecimal val15 = fgtrdapplfxrate.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdapplfxrate.getDealReference());
        ps.setString(17, fgtrdapplfxrate.getBuyingCur());
        java.math.BigDecimal val18 = fgtrdapplfxrate.getBuyingAmt();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtrdapplfxrate.getSellingCur());
        java.math.BigDecimal val20 = fgtrdapplfxrate.getSellingAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdapplfxrate.getFxRate();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgtrdapplfxrate.getBuyAmtAlloc();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgtrdapplfxrate.getSellAmtAlloc();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        Integer val24 = fgtrdapplfxrate.getEntityRefID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        Integer val25 = fgtrdapplfxrate.getIrReferenceID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgtrdapplfxrate.getParentRefID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgtrdapplfxrate.getParentVersionID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        ps.setString(28, fgtrdapplfxrate.getDealType());
    }

    private FgTrdApplFxRate extract(ResultSet rs) throws SQLException {
        FgTrdApplFxRate fgtrdapplfxrate = new FgTrdApplFxRate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdapplfxrate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdapplfxrate.setReferenceID(REFERENCE_ID);
        fgtrdapplfxrate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdapplfxrate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdapplfxrate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdapplfxrate.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdapplfxrate.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdapplfxrate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdapplfxrate.setCreatedBy(CREATED_BY);
        fgtrdapplfxrate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdapplfxrate.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdapplfxrate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdapplfxrate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdapplfxrate.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdapplfxrate.setIsTemplate(IS_TEMPLATE);
        fgtrdapplfxrate.setDealReference(rs.getString(COL_DEAL_REFERENCE));
        fgtrdapplfxrate.setBuyingCur(rs.getString(COL_BUYING_CUR));
        java.math.BigDecimal BUYING_AMT = rs.getObject(COL_BUYING_AMT, java.math.BigDecimal.class);
        fgtrdapplfxrate.setBuyingAmt(BUYING_AMT);
        fgtrdapplfxrate.setSellingCur(rs.getString(COL_SELLING_CUR));
        java.math.BigDecimal SELLING_AMT = rs.getObject(COL_SELLING_AMT, java.math.BigDecimal.class);
        fgtrdapplfxrate.setSellingAmt(SELLING_AMT);
        java.math.BigDecimal FX_RATE = rs.getObject(COL_FX_RATE, java.math.BigDecimal.class);
        fgtrdapplfxrate.setFxRate(FX_RATE);
        java.math.BigDecimal BUY_AMT_ALLOC = rs.getObject(COL_BUY_AMT_ALLOC, java.math.BigDecimal.class);
        fgtrdapplfxrate.setBuyAmtAlloc(BUY_AMT_ALLOC);
        java.math.BigDecimal SELL_AMT_ALLOC = rs.getObject(COL_SELL_AMT_ALLOC, java.math.BigDecimal.class);
        fgtrdapplfxrate.setSellAmtAlloc(SELL_AMT_ALLOC);
        Integer ENTITY_REF_ID = rs.getObject(COL_ENTITY_REF_ID, Integer.class);
        fgtrdapplfxrate.setEntityRefID(ENTITY_REF_ID);
        Integer IR_REFERENCE_ID = rs.getObject(COL_IR_REFERENCE_ID, Integer.class);
        fgtrdapplfxrate.setIrReferenceID(IR_REFERENCE_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtrdapplfxrate.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtrdapplfxrate.setParentVersionID(PARENT_VERSION_ID);
        fgtrdapplfxrate.setDealType(rs.getString(COL_DEAL_TYPE));
        return fgtrdapplfxrate;
    }
}
