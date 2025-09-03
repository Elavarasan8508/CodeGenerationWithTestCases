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

public class JdbcFgClearanceErpDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgClearanceErpDao.class);

    private static final String TABLE = "FG_CLEARANCE_ERP";

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

    private static final String COL_INVOICE_NO = "INVOICE_NO";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_INVOICE_AMOUNT = "INVOICE_AMOUNT";

    private static final String COL_SHIPPER_NAME = "SHIPPER_NAME";

    private static final String COL_SHIPPER_ADRS_1 = "SHIPPER_ADRS_1";

    private static final String COL_SHIPPER_ADRS_2 = "SHIPPER_ADRS_2";

    private static final String COL_RECEIVER_NAME = "RECEIVER_NAME";

    private static final String COL_RECEIVER_ADRS_1 = "RECEIVER_ADRS_1";

    private static final String COL_RECEIVER_ADRS_2 = "RECEIVER_ADRS_2";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INVOICE_NO, COL_INVOICE_DATE, COL_INVOICE_AMOUNT, COL_SHIPPER_NAME, COL_SHIPPER_ADRS_1, COL_SHIPPER_ADRS_2, COL_RECEIVER_NAME, COL_RECEIVER_ADRS_1, COL_RECEIVER_ADRS_2);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, INVOICE_DATE, INVOICE_AMOUNT, SHIPPER_NAME, SHIPPER_ADRS_1, SHIPPER_ADRS_2, RECEIVER_NAME, RECEIVER_ADRS_1, RECEIVER_ADRS_2", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, INVOICE_DATE, INVOICE_AMOUNT, SHIPPER_NAME, SHIPPER_ADRS_1, SHIPPER_ADRS_2, RECEIVER_NAME, RECEIVER_ADRS_1, RECEIVER_ADRS_2", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INVOICE_NO, COL_INVOICE_DATE, COL_INVOICE_AMOUNT, COL_SHIPPER_NAME, COL_SHIPPER_ADRS_1, COL_SHIPPER_ADRS_2, COL_RECEIVER_NAME, COL_RECEIVER_ADRS_1, COL_RECEIVER_ADRS_2, COL_ID);

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

    public int insert(Connection conn, FgClearanceErp fgclearanceerp) throws SQLException {
        logger.debug("Inserting fgclearanceerp: {}", fgclearanceerp);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgClearanceErpParams(ps, fgclearanceerp);
            ps.executeUpdate();
            return fgclearanceerp.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgClearanceErp> fgclearanceerps) throws SQLException {
        if (fgclearanceerps == null || fgclearanceerps.isEmpty())
            return new int[0];
        for (int i = 0; i < fgclearanceerps.size(); i++) {
            if (fgclearanceerps.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgClearanceErp>> batches = chunkList(fgclearanceerps, batchSize);
        int[] totalResults = new int[fgclearanceerps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgClearanceErp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgClearanceErp fgclearanceerp : batch) {
                        setFgClearanceErpParams(ps, fgclearanceerp);
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

    public FgClearanceErp findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgClearanceErp> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgClearanceErp> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgClearanceErp fgclearanceerp) throws SQLException {
        if (fgclearanceerp.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgClearanceErpParams(ps, fgclearanceerp);
            ps.setInt(27, fgclearanceerp.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgClearanceErp> fgclearanceerps) throws SQLException {
        if (fgclearanceerps == null || fgclearanceerps.isEmpty())
            return new int[0];
        for (FgClearanceErp fgclearanceerp : fgclearanceerps) {
            if (fgclearanceerp == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgclearanceerp.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgClearanceErp>> batches = chunkList(fgclearanceerps, batchSize);
        int[] totalResults = new int[fgclearanceerps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgClearanceErp> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgClearanceErp fgclearanceerp : batch) {
                        setFgClearanceErpParams(ps, fgclearanceerp);
                        ps.setInt(27, fgclearanceerp.getID());
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

    private void setFgClearanceErpParams(PreparedStatement ps, FgClearanceErp fgclearanceerp) throws SQLException {
        Integer val1 = fgclearanceerp.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgclearanceerp.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgclearanceerp.getTypeCode());
        ps.setString(4, fgclearanceerp.getSubTypeCode());
        ps.setString(5, fgclearanceerp.getActiveCode());
        ps.setString(6, fgclearanceerp.getStageCode());
        ps.setString(7, fgclearanceerp.getStatusCode());
        Integer val8 = fgclearanceerp.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgclearanceerp.getCreatedOn());
        java.math.BigDecimal val10 = fgclearanceerp.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgclearanceerp.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgclearanceerp.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgclearanceerp.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgclearanceerp.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgclearanceerp.getTemplate());
        ps.setString(16, fgclearanceerp.getApplicantParty());
        ps.setString(17, fgclearanceerp.getFulfillmentParty());
        java.math.BigDecimal val18 = fgclearanceerp.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgclearanceerp.getInvoiceNo());
        java.time.LocalDateTime val20 = fgclearanceerp.getInvoiceDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        java.math.BigDecimal val21 = fgclearanceerp.getInvoiceAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgclearanceerp.getShipperName());
        ps.setString(23, fgclearanceerp.getShipperAdrs1());
        ps.setString(24, fgclearanceerp.getShipperAdrs2());
        ps.setString(25, fgclearanceerp.getReceiverName());
        ps.setString(26, fgclearanceerp.getReceiverAdrs1());
        ps.setString(27, fgclearanceerp.getReceiverAdrs2());
    }

    private FgClearanceErp extract(ResultSet rs) throws SQLException {
        FgClearanceErp fgclearanceerp = new FgClearanceErp();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgclearanceerp.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgclearanceerp.setReferenceID(REFERENCE_ID);
        fgclearanceerp.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgclearanceerp.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgclearanceerp.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgclearanceerp.setStageCode(rs.getString(COL_STAGE_CODE));
        fgclearanceerp.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgclearanceerp.setProcessID(PROCESS_ID);
        fgclearanceerp.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgclearanceerp.setCreatedBy(CREATED_BY);
        fgclearanceerp.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgclearanceerp.setLastUpdatedBy(LAST_UPDATED_BY);
        fgclearanceerp.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgclearanceerp.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgclearanceerp.setTemplate(rs.getString(COL_TEMPLATE));
        fgclearanceerp.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgclearanceerp.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgclearanceerp.setIsTemplate(IS_TEMPLATE);
        fgclearanceerp.setInvoiceNo(rs.getString(COL_INVOICE_NO));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            fgclearanceerp.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        java.math.BigDecimal INVOICE_AMOUNT = rs.getObject(COL_INVOICE_AMOUNT, java.math.BigDecimal.class);
        fgclearanceerp.setInvoiceAmount(INVOICE_AMOUNT);
        fgclearanceerp.setShipperName(rs.getString(COL_SHIPPER_NAME));
        fgclearanceerp.setShipperAdrs1(rs.getString(COL_SHIPPER_ADRS_1));
        fgclearanceerp.setShipperAdrs2(rs.getString(COL_SHIPPER_ADRS_2));
        fgclearanceerp.setReceiverName(rs.getString(COL_RECEIVER_NAME));
        fgclearanceerp.setReceiverAdrs1(rs.getString(COL_RECEIVER_ADRS_1));
        fgclearanceerp.setReceiverAdrs2(rs.getString(COL_RECEIVER_ADRS_2));
        return fgclearanceerp;
    }
}
