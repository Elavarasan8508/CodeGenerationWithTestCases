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

public class JdbcAPIOutstandingBoeDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAPIOutstandingBoeDetailDao.class);

    private static final String TABLE = "API_OUTSTANDING_BOE_DETAIL";

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_DISCHARGE_PORT = "DISCHARGE_PORT";

    private static final String COL_IMPORT_AGENCY = "IMPORT_AGENCY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_INVOICE_SERIAL_NUMBER = "INVOICE_SERIAL_NUMBER";

    private static final String COL_INVOICE_NUMBER = "INVOICE_NUMBER";

    private static final String COL_INVOICE_TERM = "INVOICE_TERM";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_SUPPLIER_ADDRESS = "SUPPLIER_ADDRESS";

    private static final String COL_SUPPLIER_COUNTRY = "SUPPLIER_COUNTRY";

    private static final String COL_SELLER_NAME = "SELLER_NAME";

    private static final String COL_SELLER_ADDRESS = "SELLER_ADDRESS";

    private static final String COL_SELLER_COUNTRY = "SELLER_COUNTRY";

    private static final String COL_FOB_CURRENCY = "FOB_CURRENCY";

    private static final String COL_FOB_VALUE = "FOB_VALUE";

    private static final String COL_UTILIZED_FOB_VALUE = "UTILIZED_FOB_VALUE";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_BOE_NUMBER, COL_BOE_DATE, COL_DISCHARGE_PORT, COL_IMPORT_AGENCY, COL_IE_CODE, COL_INVOICE_SERIAL_NUMBER, COL_INVOICE_NUMBER, COL_INVOICE_TERM, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDRESS, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDRESS, COL_SELLER_COUNTRY, COL_FOB_CURRENCY, COL_FOB_VALUE, COL_UTILIZED_FOB_VALUE, COL_REFERENCE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("BOE_NUMBER, BOE_DATE, DISCHARGE_PORT, IMPORT_AGENCY, IE_CODE, INVOICE_SERIAL_NUMBER, INVOICE_NUMBER, INVOICE_TERM, SUPPLIER_NAME, SUPPLIER_ADDRESS, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDRESS, SELLER_COUNTRY, FOB_CURRENCY, FOB_VALUE, UTILIZED_FOB_VALUE, REFERENCE_ID", TABLE, COL_REFERENCE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("BOE_NUMBER, BOE_DATE, DISCHARGE_PORT, IMPORT_AGENCY, IE_CODE, INVOICE_SERIAL_NUMBER, INVOICE_NUMBER, INVOICE_TERM, SUPPLIER_NAME, SUPPLIER_ADDRESS, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDRESS, SELLER_COUNTRY, FOB_CURRENCY, FOB_VALUE, UTILIZED_FOB_VALUE, REFERENCE_ID", TABLE, COL_REFERENCE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_BOE_NUMBER, COL_BOE_DATE, COL_DISCHARGE_PORT, COL_IMPORT_AGENCY, COL_IE_CODE, COL_INVOICE_SERIAL_NUMBER, COL_INVOICE_NUMBER, COL_INVOICE_TERM, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDRESS, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDRESS, COL_SELLER_COUNTRY, COL_FOB_CURRENCY, COL_FOB_VALUE, COL_UTILIZED_FOB_VALUE, COL_REFERENCE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID);

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

    public int insert(Connection conn, APIOutstandingBoeDetail apioutstandingboedetail) throws SQLException {
        logger.debug("Inserting apioutstandingboedetail: {}", apioutstandingboedetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setAPIOutstandingBoeDetailParams(ps, apioutstandingboedetail);
            ps.executeUpdate();
            return apioutstandingboedetail.getReferenceID();
        }
    }

    public int[] insertAll(Connection conn, List<APIOutstandingBoeDetail> apioutstandingboedetails) throws SQLException {
        if (apioutstandingboedetails == null || apioutstandingboedetails.isEmpty())
            return new int[0];
        for (int i = 0; i < apioutstandingboedetails.size(); i++) {
            if (apioutstandingboedetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingBoeDetail>> batches = chunkList(apioutstandingboedetails, batchSize);
        int[] totalResults = new int[apioutstandingboedetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingBoeDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (APIOutstandingBoeDetail apioutstandingboedetail : batch) {
                        setAPIOutstandingBoeDetailParams(ps, apioutstandingboedetail);
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

    public APIOutstandingBoeDetail findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<APIOutstandingBoeDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<APIOutstandingBoeDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, APIOutstandingBoeDetail apioutstandingboedetail) throws SQLException {
        if (apioutstandingboedetail.getReferenceID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAPIOutstandingBoeDetailParams(ps, apioutstandingboedetail);
            ps.setInt(18, apioutstandingboedetail.getReferenceID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<APIOutstandingBoeDetail> apioutstandingboedetails) throws SQLException {
        if (apioutstandingboedetails == null || apioutstandingboedetails.isEmpty())
            return new int[0];
        for (APIOutstandingBoeDetail apioutstandingboedetail : apioutstandingboedetails) {
            if (apioutstandingboedetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (apioutstandingboedetail.getReferenceID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingBoeDetail>> batches = chunkList(apioutstandingboedetails, batchSize);
        int[] totalResults = new int[apioutstandingboedetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingBoeDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (APIOutstandingBoeDetail apioutstandingboedetail : batch) {
                        setAPIOutstandingBoeDetailParams(ps, apioutstandingboedetail);
                        ps.setInt(18, apioutstandingboedetail.getReferenceID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_REFERENCE_ID, placeholders);
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

    private void setAPIOutstandingBoeDetailParams(PreparedStatement ps, APIOutstandingBoeDetail apioutstandingboedetail) throws SQLException {
        ps.setString(1, apioutstandingboedetail.getBoeNumber());
        java.time.LocalDateTime val2 = apioutstandingboedetail.getBoeDate();
        if (val2 != null) {
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(val2));
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
        ps.setString(3, apioutstandingboedetail.getDischargePort());
        ps.setString(4, apioutstandingboedetail.getImportAgency());
        ps.setString(5, apioutstandingboedetail.getIeCode());
        java.math.BigDecimal val6 = apioutstandingboedetail.getInvoiceSerialNumber();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, apioutstandingboedetail.getInvoiceNumber());
        ps.setString(8, apioutstandingboedetail.getInvoiceTerm());
        ps.setString(9, apioutstandingboedetail.getSupplierName());
        ps.setString(10, apioutstandingboedetail.getSupplierAddress());
        ps.setString(11, apioutstandingboedetail.getSupplierCountry());
        ps.setString(12, apioutstandingboedetail.getSellerName());
        ps.setString(13, apioutstandingboedetail.getSellerAddress());
        ps.setString(14, apioutstandingboedetail.getSellerCountry());
        ps.setString(15, apioutstandingboedetail.getFobCurrency());
        java.math.BigDecimal val16 = apioutstandingboedetail.getFobValue();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        java.math.BigDecimal val17 = apioutstandingboedetail.getUtilizedFobValue();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        Integer val18 = apioutstandingboedetail.getReferenceID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
    }

    private APIOutstandingBoeDetail extract(ResultSet rs) throws SQLException {
        APIOutstandingBoeDetail apioutstandingboedetail = new APIOutstandingBoeDetail();
        apioutstandingboedetail.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            apioutstandingboedetail.setBoeDate(BOE_DATE.toLocalDateTime());
        apioutstandingboedetail.setDischargePort(rs.getString(COL_DISCHARGE_PORT));
        apioutstandingboedetail.setImportAgency(rs.getString(COL_IMPORT_AGENCY));
        apioutstandingboedetail.setIeCode(rs.getString(COL_IE_CODE));
        java.math.BigDecimal INVOICE_SERIAL_NUMBER = rs.getObject(COL_INVOICE_SERIAL_NUMBER, java.math.BigDecimal.class);
        apioutstandingboedetail.setInvoiceSerialNumber(INVOICE_SERIAL_NUMBER);
        apioutstandingboedetail.setInvoiceNumber(rs.getString(COL_INVOICE_NUMBER));
        apioutstandingboedetail.setInvoiceTerm(rs.getString(COL_INVOICE_TERM));
        apioutstandingboedetail.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        apioutstandingboedetail.setSupplierAddress(rs.getString(COL_SUPPLIER_ADDRESS));
        apioutstandingboedetail.setSupplierCountry(rs.getString(COL_SUPPLIER_COUNTRY));
        apioutstandingboedetail.setSellerName(rs.getString(COL_SELLER_NAME));
        apioutstandingboedetail.setSellerAddress(rs.getString(COL_SELLER_ADDRESS));
        apioutstandingboedetail.setSellerCountry(rs.getString(COL_SELLER_COUNTRY));
        apioutstandingboedetail.setFobCurrency(rs.getString(COL_FOB_CURRENCY));
        java.math.BigDecimal FOB_VALUE = rs.getObject(COL_FOB_VALUE, java.math.BigDecimal.class);
        apioutstandingboedetail.setFobValue(FOB_VALUE);
        java.math.BigDecimal UTILIZED_FOB_VALUE = rs.getObject(COL_UTILIZED_FOB_VALUE, java.math.BigDecimal.class);
        apioutstandingboedetail.setUtilizedFobValue(UTILIZED_FOB_VALUE);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        apioutstandingboedetail.setReferenceID(REFERENCE_ID);
        return apioutstandingboedetail;
    }
}
