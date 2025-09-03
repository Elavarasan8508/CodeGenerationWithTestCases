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

public class JdbcFgBoeDataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBoeDataDao.class);

    private static final String TABLE = "FG_BOE_DATA";

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

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_PORT_OF_DIS = "PORT_OF_DIS";

    private static final String COL_IMPORT_AGENCY = "IMPORT_AGENCY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_OVERDUE_PERIOD = "OVERDUE_PERIOD";

    private static final String COL_INVOICE_SL_NO = "INVOICE_SL_NO";

    private static final String COL_INV_NUM = "INV_NUM";

    private static final String COL_TERMS_OF_INV = "TERMS_OF_INV";

    private static final String COL_INV_CCY = "INV_CCY";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_SUPPLIER_ADDR = "SUPPLIER_ADDR";

    private static final String COL_SUPPLIER_COUNTRY = "SUPPLIER_COUNTRY";

    private static final String COL_SELLER_NAME = "SELLER_NAME";

    private static final String COL_SELLER_ADDR = "SELLER_ADDR";

    private static final String COL_SELLER_COUNTRY = "SELLER_COUNTRY";

    private static final String COL_UTILIZED_INV_AMT = "UTILIZED_INV_AMT";

    private static final String COL_OS_INV_AMT = "OS_INV_AMT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_IE_CODE, COL_OVERDUE_PERIOD, COL_INVOICE_SL_NO, COL_INV_NUM, COL_TERMS_OF_INV, COL_INV_CCY, COL_INV_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_UTILIZED_INV_AMT, COL_OS_INV_AMT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BOE_NUMBER, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_IE_CODE, COL_OVERDUE_PERIOD, COL_INVOICE_SL_NO, COL_INV_NUM, COL_TERMS_OF_INV, COL_INV_CCY, COL_INV_AMT, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_UTILIZED_INV_AMT, COL_OS_INV_AMT, COL_ID);

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

    public int insert(Connection conn, FgBoeData fgboedata) throws SQLException {
        logger.debug("Inserting fgboedata: {}", fgboedata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBoeDataParams(ps, fgboedata);
            ps.executeUpdate();
            return fgboedata.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBoeData> fgboedatas) throws SQLException {
        if (fgboedatas == null || fgboedatas.isEmpty())
            return new int[0];
        for (int i = 0; i < fgboedatas.size(); i++) {
            if (fgboedatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBoeData>> batches = chunkList(fgboedatas, batchSize);
        int[] totalResults = new int[fgboedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBoeData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBoeData fgboedata : batch) {
                        setFgBoeDataParams(ps, fgboedata);
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

    public FgBoeData findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBoeData> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBoeData> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBoeData fgboedata) throws SQLException {
        if (fgboedata.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBoeDataParams(ps, fgboedata);
            ps.setInt(34, fgboedata.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBoeData> fgboedatas) throws SQLException {
        if (fgboedatas == null || fgboedatas.isEmpty())
            return new int[0];
        for (FgBoeData fgboedata : fgboedatas) {
            if (fgboedata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgboedata.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBoeData>> batches = chunkList(fgboedatas, batchSize);
        int[] totalResults = new int[fgboedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBoeData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBoeData fgboedata : batch) {
                        setFgBoeDataParams(ps, fgboedata);
                        ps.setInt(34, fgboedata.getID());
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

    private void setFgBoeDataParams(PreparedStatement ps, FgBoeData fgboedata) throws SQLException {
        Integer val1 = fgboedata.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgboedata.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgboedata.getTypeCode());
        ps.setString(4, fgboedata.getSubTypeCode());
        ps.setString(5, fgboedata.getActiveCode());
        ps.setString(6, fgboedata.getStageCode());
        ps.setString(7, fgboedata.getStatusCode());
        ps.setString(8, fgboedata.getCreatedOn());
        java.math.BigDecimal val9 = fgboedata.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgboedata.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgboedata.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgboedata.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgboedata.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgboedata.getTemplate());
        java.math.BigDecimal val15 = fgboedata.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgboedata.getBoeNumber());
        java.time.LocalDateTime val17 = fgboedata.getBoeDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgboedata.getPortOfDis());
        ps.setString(19, fgboedata.getImportAgency());
        ps.setString(20, fgboedata.getIeCode());
        java.time.LocalDateTime val21 = fgboedata.getOverduePeriod();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        ps.setString(22, fgboedata.getInvoiceSlNo());
        ps.setString(23, fgboedata.getInvNum());
        ps.setString(24, fgboedata.getTermsOfInv());
        ps.setString(25, fgboedata.getInvCcy());
        java.math.BigDecimal val26 = fgboedata.getInvAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgboedata.getSupplierName());
        ps.setString(28, fgboedata.getSupplierAddr());
        ps.setString(29, fgboedata.getSupplierCountry());
        ps.setString(30, fgboedata.getSellerName());
        ps.setString(31, fgboedata.getSellerAddr());
        ps.setString(32, fgboedata.getSellerCountry());
        java.math.BigDecimal val33 = fgboedata.getUtilizedInvAmt();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = fgboedata.getOsInvAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
    }

    private FgBoeData extract(ResultSet rs) throws SQLException {
        FgBoeData fgboedata = new FgBoeData();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgboedata.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgboedata.setReferenceID(REFERENCE_ID);
        fgboedata.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgboedata.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgboedata.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgboedata.setStageCode(rs.getString(COL_STAGE_CODE));
        fgboedata.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgboedata.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgboedata.setCreatedBy(CREATED_BY);
        fgboedata.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgboedata.setLastUpdatedBy(LAST_UPDATED_BY);
        fgboedata.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgboedata.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgboedata.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgboedata.setIsTemplate(IS_TEMPLATE);
        fgboedata.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgboedata.setBoeDate(BOE_DATE.toLocalDateTime());
        fgboedata.setPortOfDis(rs.getString(COL_PORT_OF_DIS));
        fgboedata.setImportAgency(rs.getString(COL_IMPORT_AGENCY));
        fgboedata.setIeCode(rs.getString(COL_IE_CODE));
        Timestamp OVERDUE_PERIOD = rs.getTimestamp(COL_OVERDUE_PERIOD);
        if (OVERDUE_PERIOD != null)
            fgboedata.setOverduePeriod(OVERDUE_PERIOD.toLocalDateTime());
        fgboedata.setInvoiceSlNo(rs.getString(COL_INVOICE_SL_NO));
        fgboedata.setInvNum(rs.getString(COL_INV_NUM));
        fgboedata.setTermsOfInv(rs.getString(COL_TERMS_OF_INV));
        fgboedata.setInvCcy(rs.getString(COL_INV_CCY));
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        fgboedata.setInvAmt(INV_AMT);
        fgboedata.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        fgboedata.setSupplierAddr(rs.getString(COL_SUPPLIER_ADDR));
        fgboedata.setSupplierCountry(rs.getString(COL_SUPPLIER_COUNTRY));
        fgboedata.setSellerName(rs.getString(COL_SELLER_NAME));
        fgboedata.setSellerAddr(rs.getString(COL_SELLER_ADDR));
        fgboedata.setSellerCountry(rs.getString(COL_SELLER_COUNTRY));
        java.math.BigDecimal UTILIZED_INV_AMT = rs.getObject(COL_UTILIZED_INV_AMT, java.math.BigDecimal.class);
        fgboedata.setUtilizedInvAmt(UTILIZED_INV_AMT);
        java.math.BigDecimal OS_INV_AMT = rs.getObject(COL_OS_INV_AMT, java.math.BigDecimal.class);
        fgboedata.setOsInvAmt(OS_INV_AMT);
        return fgboedata;
    }
}
