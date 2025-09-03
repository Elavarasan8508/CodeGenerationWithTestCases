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

public class JdbcAPIOutstandingBillDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAPIOutstandingBillDetailDao.class);

    private static final String TABLE = "API_OUTSTANDING_BILL_DETAIL";

    private static final String COL_INSURANCE_AMOUNT = "INSURANCE_AMOUNT";

    private static final String COL_UTILIZED_INSURANCE_AMOUNT = "UTILIZED_INSURANCE_AMOUNT";

    private static final String COL_BILL_ID = "BILL_ID";

    private static final String COL_INVOICE_ID = "INVOICE_ID";

    private static final String COL_SHIPPING_BILL_STATUS = "SHIPPING_BILL_STATUS";

    private static final String COL_SHIPPINGBILL_NO = "SHIPPINGBILL_NO";

    private static final String COL_FORM_NO = "FORM_NO";

    private static final String COL_SHIPPINGBILL_DATE = "SHIPPINGBILL_DATE";

    private static final String COL_LEO_DATE = "LEO_DATE";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_PORT_OF_LOADING = "PORT_OF_LOADING";

    private static final String COL_EXPORT_AGENCY = "EXPORT_AGENCY";

    private static final String COL_EXPORT_TYPE = "EXPORT_TYPE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_AD_BILL_NUMBER = "AD_BILL_NUMBER";

    private static final String COL_INVOICE_STATUS = "INVOICE_STATUS";

    private static final String COL_INVOICE_NO = "INVOICE_NO";

    private static final String COL_INVOICE_DATE = "INVOICE_DATE";

    private static final String COL_INVOICE_SERIAL_NO = "INVOICE_SERIAL_NO";

    private static final String COL_FOB_CURRENCY = "FOB_CURRENCY";

    private static final String COL_FRIEGHT_CURRENCY = "FRIEGHT_CURRENCY";

    private static final String COL_INSURANCE_CURRENCY = "INSURANCE_CURRENCY";

    private static final String COL_FOB_AMOUNT = "FOB_AMOUNT";

    private static final String COL_UTILIZED_FOB_AMOUNT = "UTILIZED_FOB_AMOUNT";

    private static final String COL_FREIGHT_AMOUNT = "FREIGHT_AMOUNT";

    private static final String COL_UTILIZED_FREIGHT_AMOUNT = "UTILIZED_FREIGHT_AMOUNT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_INSURANCE_AMOUNT, COL_UTILIZED_INSURANCE_AMOUNT, COL_BILL_ID, COL_INVOICE_ID, COL_SHIPPING_BILL_STATUS, COL_SHIPPINGBILL_NO, COL_FORM_NO, COL_SHIPPINGBILL_DATE, COL_LEO_DATE, COL_AD_CODE, COL_PORT_OF_LOADING, COL_EXPORT_AGENCY, COL_EXPORT_TYPE, COL_IE_CODE, COL_AD_BILL_NUMBER, COL_INVOICE_STATUS, COL_INVOICE_NO, COL_INVOICE_DATE, COL_INVOICE_SERIAL_NO, COL_FOB_CURRENCY, COL_FRIEGHT_CURRENCY, COL_INSURANCE_CURRENCY, COL_FOB_AMOUNT, COL_UTILIZED_FOB_AMOUNT, COL_FREIGHT_AMOUNT, COL_UTILIZED_FREIGHT_AMOUNT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT, BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT", TABLE, COL_BILL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT, BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT", TABLE, COL_BILL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_INSURANCE_AMOUNT, COL_UTILIZED_INSURANCE_AMOUNT, COL_INVOICE_ID, COL_SHIPPING_BILL_STATUS, COL_SHIPPINGBILL_NO, COL_FORM_NO, COL_SHIPPINGBILL_DATE, COL_LEO_DATE, COL_AD_CODE, COL_PORT_OF_LOADING, COL_EXPORT_AGENCY, COL_EXPORT_TYPE, COL_IE_CODE, COL_AD_BILL_NUMBER, COL_INVOICE_STATUS, COL_INVOICE_NO, COL_INVOICE_DATE, COL_INVOICE_SERIAL_NO, COL_FOB_CURRENCY, COL_FRIEGHT_CURRENCY, COL_INSURANCE_CURRENCY, COL_FOB_AMOUNT, COL_UTILIZED_FOB_AMOUNT, COL_FREIGHT_AMOUNT, COL_UTILIZED_FREIGHT_AMOUNT, COL_BILL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_BILL_ID);

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

    public int insert(Connection conn, APIOutstandingBillDetail apioutstandingbilldetail) throws SQLException {
        logger.debug("Inserting apioutstandingbilldetail: {}", apioutstandingbilldetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setAPIOutstandingBillDetailParams(ps, apioutstandingbilldetail);
            ps.executeUpdate();
            return apioutstandingbilldetail.getBillID();
        }
    }

    public int[] insertAll(Connection conn, List<APIOutstandingBillDetail> apioutstandingbilldetails) throws SQLException {
        if (apioutstandingbilldetails == null || apioutstandingbilldetails.isEmpty())
            return new int[0];
        for (int i = 0; i < apioutstandingbilldetails.size(); i++) {
            if (apioutstandingbilldetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingBillDetail>> batches = chunkList(apioutstandingbilldetails, batchSize);
        int[] totalResults = new int[apioutstandingbilldetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingBillDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (APIOutstandingBillDetail apioutstandingbilldetail : batch) {
                        setAPIOutstandingBillDetailParams(ps, apioutstandingbilldetail);
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

    public APIOutstandingBillDetail findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<APIOutstandingBillDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<APIOutstandingBillDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, APIOutstandingBillDetail apioutstandingbilldetail) throws SQLException {
        if (apioutstandingbilldetail.getBillID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAPIOutstandingBillDetailParams(ps, apioutstandingbilldetail);
            ps.setInt(26, apioutstandingbilldetail.getBillID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<APIOutstandingBillDetail> apioutstandingbilldetails) throws SQLException {
        if (apioutstandingbilldetails == null || apioutstandingbilldetails.isEmpty())
            return new int[0];
        for (APIOutstandingBillDetail apioutstandingbilldetail : apioutstandingbilldetails) {
            if (apioutstandingbilldetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (apioutstandingbilldetail.getBillID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingBillDetail>> batches = chunkList(apioutstandingbilldetails, batchSize);
        int[] totalResults = new int[apioutstandingbilldetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingBillDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (APIOutstandingBillDetail apioutstandingbilldetail : batch) {
                        setAPIOutstandingBillDetailParams(ps, apioutstandingbilldetail);
                        ps.setInt(26, apioutstandingbilldetail.getBillID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_BILL_ID, placeholders);
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

    private void setAPIOutstandingBillDetailParams(PreparedStatement ps, APIOutstandingBillDetail apioutstandingbilldetail) throws SQLException {
        java.math.BigDecimal val1 = apioutstandingbilldetail.getInsuranceAmount();
        if (val1 != null) {
            ps.setBigDecimal(1, val1);
        } else {
            ps.setNull(1, Types.DECIMAL);
        }
        java.math.BigDecimal val2 = apioutstandingbilldetail.getUtilizedInsuranceAmount();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        Integer val3 = apioutstandingbilldetail.getBillID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        Integer val4 = apioutstandingbilldetail.getInvoiceID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, apioutstandingbilldetail.getShippingBillStatus());
        ps.setString(6, apioutstandingbilldetail.getShippingbillNo());
        ps.setString(7, apioutstandingbilldetail.getFormNo());
        java.time.LocalDateTime val8 = apioutstandingbilldetail.getShippingbillDate();
        if (val8 != null) {
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(val8));
        } else {
            ps.setNull(8, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val9 = apioutstandingbilldetail.getLeoDate();
        if (val9 != null) {
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(val9));
        } else {
            ps.setNull(9, Types.TIMESTAMP);
        }
        ps.setString(10, apioutstandingbilldetail.getAdCode());
        ps.setString(11, apioutstandingbilldetail.getPortOfLoading());
        ps.setString(12, apioutstandingbilldetail.getExportAgency());
        ps.setString(13, apioutstandingbilldetail.getExportType());
        ps.setString(14, apioutstandingbilldetail.getIeCode());
        ps.setString(15, apioutstandingbilldetail.getAdBillNumber());
        ps.setString(16, apioutstandingbilldetail.getInvoiceStatus());
        ps.setString(17, apioutstandingbilldetail.getInvoiceNo());
        java.time.LocalDateTime val18 = apioutstandingbilldetail.getInvoiceDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        ps.setString(19, apioutstandingbilldetail.getInvoiceSerialNo());
        ps.setString(20, apioutstandingbilldetail.getFobCurrency());
        ps.setString(21, apioutstandingbilldetail.getFrieghtCurrency());
        ps.setString(22, apioutstandingbilldetail.getInsuranceCurrency());
        java.math.BigDecimal val23 = apioutstandingbilldetail.getFobAmount();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = apioutstandingbilldetail.getUtilizedFobAmount();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = apioutstandingbilldetail.getFreightAmount();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = apioutstandingbilldetail.getUtilizedFreightAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
    }

    private APIOutstandingBillDetail extract(ResultSet rs) throws SQLException {
        APIOutstandingBillDetail apioutstandingbilldetail = new APIOutstandingBillDetail();
        java.math.BigDecimal INSURANCE_AMOUNT = rs.getObject(COL_INSURANCE_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setInsuranceAmount(INSURANCE_AMOUNT);
        java.math.BigDecimal UTILIZED_INSURANCE_AMOUNT = rs.getObject(COL_UTILIZED_INSURANCE_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setUtilizedInsuranceAmount(UTILIZED_INSURANCE_AMOUNT);
        Integer BILL_ID = rs.getObject(COL_BILL_ID, Integer.class);
        apioutstandingbilldetail.setBillID(BILL_ID);
        Integer INVOICE_ID = rs.getObject(COL_INVOICE_ID, Integer.class);
        apioutstandingbilldetail.setInvoiceID(INVOICE_ID);
        apioutstandingbilldetail.setShippingBillStatus(rs.getString(COL_SHIPPING_BILL_STATUS));
        apioutstandingbilldetail.setShippingbillNo(rs.getString(COL_SHIPPINGBILL_NO));
        apioutstandingbilldetail.setFormNo(rs.getString(COL_FORM_NO));
        Timestamp SHIPPINGBILL_DATE = rs.getTimestamp(COL_SHIPPINGBILL_DATE);
        if (SHIPPINGBILL_DATE != null)
            apioutstandingbilldetail.setShippingbillDate(SHIPPINGBILL_DATE.toLocalDateTime());
        Timestamp LEO_DATE = rs.getTimestamp(COL_LEO_DATE);
        if (LEO_DATE != null)
            apioutstandingbilldetail.setLeoDate(LEO_DATE.toLocalDateTime());
        apioutstandingbilldetail.setAdCode(rs.getString(COL_AD_CODE));
        apioutstandingbilldetail.setPortOfLoading(rs.getString(COL_PORT_OF_LOADING));
        apioutstandingbilldetail.setExportAgency(rs.getString(COL_EXPORT_AGENCY));
        apioutstandingbilldetail.setExportType(rs.getString(COL_EXPORT_TYPE));
        apioutstandingbilldetail.setIeCode(rs.getString(COL_IE_CODE));
        apioutstandingbilldetail.setAdBillNumber(rs.getString(COL_AD_BILL_NUMBER));
        apioutstandingbilldetail.setInvoiceStatus(rs.getString(COL_INVOICE_STATUS));
        apioutstandingbilldetail.setInvoiceNo(rs.getString(COL_INVOICE_NO));
        Timestamp INVOICE_DATE = rs.getTimestamp(COL_INVOICE_DATE);
        if (INVOICE_DATE != null)
            apioutstandingbilldetail.setInvoiceDate(INVOICE_DATE.toLocalDateTime());
        apioutstandingbilldetail.setInvoiceSerialNo(rs.getString(COL_INVOICE_SERIAL_NO));
        apioutstandingbilldetail.setFobCurrency(rs.getString(COL_FOB_CURRENCY));
        apioutstandingbilldetail.setFrieghtCurrency(rs.getString(COL_FRIEGHT_CURRENCY));
        apioutstandingbilldetail.setInsuranceCurrency(rs.getString(COL_INSURANCE_CURRENCY));
        java.math.BigDecimal FOB_AMOUNT = rs.getObject(COL_FOB_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setFobAmount(FOB_AMOUNT);
        java.math.BigDecimal UTILIZED_FOB_AMOUNT = rs.getObject(COL_UTILIZED_FOB_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setUtilizedFobAmount(UTILIZED_FOB_AMOUNT);
        java.math.BigDecimal FREIGHT_AMOUNT = rs.getObject(COL_FREIGHT_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setFreightAmount(FREIGHT_AMOUNT);
        java.math.BigDecimal UTILIZED_FREIGHT_AMOUNT = rs.getObject(COL_UTILIZED_FREIGHT_AMOUNT, java.math.BigDecimal.class);
        apioutstandingbilldetail.setUtilizedFreightAmount(UTILIZED_FREIGHT_AMOUNT);
        return apioutstandingbilldetail;
    }
}
