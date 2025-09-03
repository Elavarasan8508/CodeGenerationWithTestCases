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

public class JdbcFgTrdPostingsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdPostingsDao.class);

    private static final String TABLE = "FG_TRD_POSTINGS";

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

    private static final String COL_CUSTOMER = "CUSTOMER";

    private static final String COL_NOSTRO_REFERENCE = "NOSTRO_REFERENCE";

    private static final String COL_PORTAL_REFERENCE = "PORTAL_REFERENCE";

    private static final String COL_POSTING_REQUEST = "POSTING_REQUEST";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_POSTING_RESPONSE = "POSTING_RESPONSE";

    private static final String COL_TI_MASTER_REF = "TI_MASTER_REF";

    private static final String COL_TI_PRODUCT_CODE = "TI_PRODUCT_CODE";

    private static final String COL_THEIR_REFERENCE = "THEIR_REFERENCE";

    private static final String COL_PRODUCT = "PRODUCT";

    private static final String COL_TI_STATUS = "TI_STATUS";

    private static final String COL_EVENT_SERIAL = "EVENT_SERIAL";

    private static final String COL_EVENT_PREFIX = "EVENT_PREFIX";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUSTOMER, COL_NOSTRO_REFERENCE, COL_PORTAL_REFERENCE, COL_POSTING_REQUEST, COL_STATUS, COL_POSTING_RESPONSE, COL_TI_MASTER_REF, COL_TI_PRODUCT_CODE, COL_THEIR_REFERENCE, COL_PRODUCT, COL_TI_STATUS, COL_EVENT_SERIAL, COL_EVENT_PREFIX, COL_BILL_NO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER, NOSTRO_REFERENCE, PORTAL_REFERENCE, POSTING_REQUEST, STATUS, POSTING_RESPONSE, TI_MASTER_REF, TI_PRODUCT_CODE, THEIR_REFERENCE, PRODUCT, TI_STATUS, EVENT_SERIAL, EVENT_PREFIX, BILL_NO", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER, NOSTRO_REFERENCE, PORTAL_REFERENCE, POSTING_REQUEST, STATUS, POSTING_RESPONSE, TI_MASTER_REF, TI_PRODUCT_CODE, THEIR_REFERENCE, PRODUCT, TI_STATUS, EVENT_SERIAL, EVENT_PREFIX, BILL_NO", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_CUSTOMER, COL_NOSTRO_REFERENCE, COL_PORTAL_REFERENCE, COL_POSTING_REQUEST, COL_STATUS, COL_POSTING_RESPONSE, COL_TI_MASTER_REF, COL_TI_PRODUCT_CODE, COL_THEIR_REFERENCE, COL_PRODUCT, COL_TI_STATUS, COL_EVENT_SERIAL, COL_EVENT_PREFIX, COL_BILL_NO, COL_ID);

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

    public int insert(Connection conn, FgTrdPostings fgtrdpostings) throws SQLException {
        logger.debug("Inserting fgtrdpostings: {}", fgtrdpostings);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdPostingsParams(ps, fgtrdpostings);
            ps.executeUpdate();
            return fgtrdpostings.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdPostings> fgtrdpostingss) throws SQLException {
        if (fgtrdpostingss == null || fgtrdpostingss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdpostingss.size(); i++) {
            if (fgtrdpostingss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostings>> batches = chunkList(fgtrdpostingss, batchSize);
        int[] totalResults = new int[fgtrdpostingss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostings> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdPostings fgtrdpostings : batch) {
                        setFgTrdPostingsParams(ps, fgtrdpostings);
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

    public FgTrdPostings findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdPostings> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdPostings> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdPostings fgtrdpostings) throws SQLException {
        if (fgtrdpostings.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdPostingsParams(ps, fgtrdpostings);
            ps.setInt(29, fgtrdpostings.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdPostings> fgtrdpostingss) throws SQLException {
        if (fgtrdpostingss == null || fgtrdpostingss.isEmpty())
            return new int[0];
        for (FgTrdPostings fgtrdpostings : fgtrdpostingss) {
            if (fgtrdpostings == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdpostings.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdPostings>> batches = chunkList(fgtrdpostingss, batchSize);
        int[] totalResults = new int[fgtrdpostingss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdPostings> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdPostings fgtrdpostings : batch) {
                        setFgTrdPostingsParams(ps, fgtrdpostings);
                        ps.setInt(29, fgtrdpostings.getID());
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

    private void setFgTrdPostingsParams(PreparedStatement ps, FgTrdPostings fgtrdpostings) throws SQLException {
        Integer val1 = fgtrdpostings.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdpostings.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdpostings.getTypeCode());
        ps.setString(4, fgtrdpostings.getSubTypeCode());
        ps.setString(5, fgtrdpostings.getActiveCode());
        ps.setString(6, fgtrdpostings.getStageCode());
        ps.setString(7, fgtrdpostings.getStatusCode());
        ps.setString(8, fgtrdpostings.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdpostings.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdpostings.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdpostings.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdpostings.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdpostings.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdpostings.getTemplate());
        java.math.BigDecimal val15 = fgtrdpostings.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdpostings.getCustomer());
        ps.setString(17, fgtrdpostings.getNostroReference());
        ps.setString(18, fgtrdpostings.getPortalReference());
        ps.setString(19, fgtrdpostings.getPostingRequest());
        ps.setString(20, fgtrdpostings.getStatus());
        ps.setString(21, fgtrdpostings.getPostingResponse());
        ps.setString(22, fgtrdpostings.getTiMasterRef());
        ps.setString(23, fgtrdpostings.getTiProductCode());
        ps.setString(24, fgtrdpostings.getTheirReference());
        ps.setString(25, fgtrdpostings.getProduct());
        ps.setString(26, fgtrdpostings.getTiStatus());
        java.math.BigDecimal val27 = fgtrdpostings.getEventSerial();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgtrdpostings.getEventPrefix());
        ps.setString(29, fgtrdpostings.getBillNo());
    }

    private FgTrdPostings extract(ResultSet rs) throws SQLException {
        FgTrdPostings fgtrdpostings = new FgTrdPostings();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdpostings.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdpostings.setReferenceID(REFERENCE_ID);
        fgtrdpostings.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdpostings.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdpostings.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdpostings.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdpostings.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdpostings.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdpostings.setCreatedBy(CREATED_BY);
        fgtrdpostings.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdpostings.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdpostings.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdpostings.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdpostings.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdpostings.setIsTemplate(IS_TEMPLATE);
        fgtrdpostings.setCustomer(rs.getString(COL_CUSTOMER));
        fgtrdpostings.setNostroReference(rs.getString(COL_NOSTRO_REFERENCE));
        fgtrdpostings.setPortalReference(rs.getString(COL_PORTAL_REFERENCE));
        fgtrdpostings.setPostingRequest(rs.getString(COL_POSTING_REQUEST));
        fgtrdpostings.setStatus(rs.getString(COL_STATUS));
        fgtrdpostings.setPostingResponse(rs.getString(COL_POSTING_RESPONSE));
        fgtrdpostings.setTiMasterRef(rs.getString(COL_TI_MASTER_REF));
        fgtrdpostings.setTiProductCode(rs.getString(COL_TI_PRODUCT_CODE));
        fgtrdpostings.setTheirReference(rs.getString(COL_THEIR_REFERENCE));
        fgtrdpostings.setProduct(rs.getString(COL_PRODUCT));
        fgtrdpostings.setTiStatus(rs.getString(COL_TI_STATUS));
        java.math.BigDecimal EVENT_SERIAL = rs.getObject(COL_EVENT_SERIAL, java.math.BigDecimal.class);
        fgtrdpostings.setEventSerial(EVENT_SERIAL);
        fgtrdpostings.setEventPrefix(rs.getString(COL_EVENT_PREFIX));
        fgtrdpostings.setBillNo(rs.getString(COL_BILL_NO));
        return fgtrdpostings;
    }
}
