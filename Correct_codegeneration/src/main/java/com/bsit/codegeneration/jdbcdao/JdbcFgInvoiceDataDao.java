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

public class JdbcFgInvoiceDataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgInvoiceDataDao.class);

    private static final String TABLE = "FG_INVOICE_DATA";

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

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_DATE = "DATE";

    private static final String COL_COMPANY_NAME = "COMPANY_NAME";

    private static final String COL_CONTACT_NO = "CONTACT_NO";

    private static final String COL_SERVICE_FEE = "SERVICE_FEE";

    private static final String COL_COMPANY_ADDR = "COMPANY_ADDR";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INVOICE_NUMBER, COL_DATE, COL_COMPANY_NAME, COL_CONTACT_NO, COL_SERVICE_FEE, COL_COMPANY_ADDR);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_NUMBER, DATE, COMPANY_NAME, CONTACT_NO, SERVICE_FEE, COMPANY_ADDR", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_NUMBER, DATE, COMPANY_NAME, CONTACT_NO, SERVICE_FEE, COMPANY_ADDR", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_INVOICE_NUMBER, COL_DATE, COL_COMPANY_NAME, COL_CONTACT_NO, COL_SERVICE_FEE, COL_COMPANY_ADDR, COL_ID);

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

    public int insert(Connection conn, FgInvoiceData fginvoicedata) throws SQLException {
        logger.debug("Inserting fginvoicedata: {}", fginvoicedata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgInvoiceDataParams(ps, fginvoicedata);
            ps.executeUpdate();
            return fginvoicedata.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgInvoiceData> fginvoicedatas) throws SQLException {
        if (fginvoicedatas == null || fginvoicedatas.isEmpty())
            return new int[0];
        for (int i = 0; i < fginvoicedatas.size(); i++) {
            if (fginvoicedatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgInvoiceData>> batches = chunkList(fginvoicedatas, batchSize);
        int[] totalResults = new int[fginvoicedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgInvoiceData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgInvoiceData fginvoicedata : batch) {
                        setFgInvoiceDataParams(ps, fginvoicedata);
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

    public FgInvoiceData findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgInvoiceData> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgInvoiceData> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgInvoiceData fginvoicedata) throws SQLException {
        if (fginvoicedata.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgInvoiceDataParams(ps, fginvoicedata);
            ps.setInt(21, fginvoicedata.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgInvoiceData> fginvoicedatas) throws SQLException {
        if (fginvoicedatas == null || fginvoicedatas.isEmpty())
            return new int[0];
        for (FgInvoiceData fginvoicedata : fginvoicedatas) {
            if (fginvoicedata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fginvoicedata.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgInvoiceData>> batches = chunkList(fginvoicedatas, batchSize);
        int[] totalResults = new int[fginvoicedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgInvoiceData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgInvoiceData fginvoicedata : batch) {
                        setFgInvoiceDataParams(ps, fginvoicedata);
                        ps.setInt(21, fginvoicedata.getID());
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

    private void setFgInvoiceDataParams(PreparedStatement ps, FgInvoiceData fginvoicedata) throws SQLException {
        Integer val1 = fginvoicedata.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fginvoicedata.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fginvoicedata.getTypeCode());
        ps.setString(4, fginvoicedata.getSubTypeCode());
        ps.setString(5, fginvoicedata.getActiveCode());
        ps.setString(6, fginvoicedata.getStageCode());
        ps.setString(7, fginvoicedata.getStatusCode());
        ps.setString(8, fginvoicedata.getCreatedOn());
        java.math.BigDecimal val9 = fginvoicedata.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fginvoicedata.getLastUpdatedOn());
        java.math.BigDecimal val11 = fginvoicedata.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fginvoicedata.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fginvoicedata.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fginvoicedata.getTemplate());
        java.math.BigDecimal val15 = fginvoicedata.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fginvoicedata.getInvoiceNumber());
        java.time.LocalDateTime val17 = fginvoicedata.getDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fginvoicedata.getCompanyName());
        java.math.BigDecimal val19 = fginvoicedata.getContactNo();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fginvoicedata.getServiceFee();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fginvoicedata.getCompanyAddr());
    }

    private FgInvoiceData extract(ResultSet rs) throws SQLException {
        FgInvoiceData fginvoicedata = new FgInvoiceData();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fginvoicedata.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fginvoicedata.setReferenceID(REFERENCE_ID);
        fginvoicedata.setTypeCode(rs.getString(COL_TYPE_CODE));
        fginvoicedata.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fginvoicedata.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fginvoicedata.setStageCode(rs.getString(COL_STAGE_CODE));
        fginvoicedata.setStatusCode(rs.getString(COL_STATUS_CODE));
        fginvoicedata.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fginvoicedata.setCreatedBy(CREATED_BY);
        fginvoicedata.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fginvoicedata.setLastUpdatedBy(LAST_UPDATED_BY);
        fginvoicedata.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fginvoicedata.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fginvoicedata.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fginvoicedata.setIsTemplate(IS_TEMPLATE);
        fginvoicedata.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        Timestamp DATE = rs.getTimestamp(COL_DATE);
        if (DATE != null)
            fginvoicedata.setDate(DATE.toLocalDateTime());
        fginvoicedata.setCompanyName(rs.getString(COL_COMPANY_NAME));
        java.math.BigDecimal CONTACT_NO = rs.getObject(COL_CONTACT_NO, java.math.BigDecimal.class);
        fginvoicedata.setContactNo(CONTACT_NO);
        java.math.BigDecimal SERVICE_FEE = rs.getObject(COL_SERVICE_FEE, java.math.BigDecimal.class);
        fginvoicedata.setServiceFee(SERVICE_FEE);
        fginvoicedata.setCompanyAddr(rs.getString(COL_COMPANY_ADDR));
        return fginvoicedata;
    }
}
