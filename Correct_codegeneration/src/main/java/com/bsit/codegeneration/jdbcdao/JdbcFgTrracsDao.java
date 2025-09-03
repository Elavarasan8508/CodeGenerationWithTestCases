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

public class JdbcFgTrracsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrracsDao.class);

    private static final String TABLE = "FG_TRRACS";

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

    private static final String COL_SB_NO = "SB_NO";

    private static final String COL_SB_DATE = "SB_DATE";

    private static final String COL_INVOICE_CCY = "INVOICE_CCY";

    private static final String COL_IE_CODE_SB = "IE_CODE_SB";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_FORM_NO = "FORM_NO";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_IRM_NO = "IRM_NO";

    private static final String COL_IRM_AD = "IRM_AD";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_IRM_DATE = "IRM_DATE";

    private static final String COL_IRM_NAME = "IRM_NAME";

    private static final String COL_IRM_COUNTRY = "IRM_COUNTRY";

    private static final String COL_IRM_BANK_COUNTRY = "IRM_BANK_COUNTRY";

    private static final String COL_BOE_NUM = "BOE_NUM";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_PORT_OF_DIS = "PORT_OF_DIS";

    private static final String COL_IMPORT_AGENCY = "IMPORT_AGENCY";

    private static final String COL_INV_NUM = "INV_NUM";

    private static final String COL_TERMS_OF_INV = "TERMS_OF_INV";

    private static final String COL_INVOICE_SL_NO = "INVOICE_SL_NO";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String COL_ORM_NUMBER = "ORM_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_ORM_AMOUNT = "ORM_AMOUNT";

    private static final String COL_ORM_UTILIZED_AMT = "ORM_UTILIZED_AMT";

    private static final String COL_ORM_CCY = "ORM_CCY";

    private static final String COL_ORM_DATE = "ORM_DATE";

    private static final String COL_IE_NAME = "IE_NAME";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_IRM_BANK_NAME = "IRM_BANK_NAME";

    private static final String COL_IRM_SWIFT_BANK_REF_NO = "IRM_SWIFT_BANK_REF_NO";

    private static final String COL_OS_AMT_IRM = "OS_AMT_IRM";

    private static final String COL_INV_CCY = "INV_CCY";

    private static final String COL_OS_INV_AMT = "OS_INV_AMT";

    private static final String COL_BENE_NAME = "BENE_NAME";

    private static final String COL_BENE_COUNTRY = "BENE_COUNTRY";

    private static final String COL_REMITTER_BANK_NAME = "REMITTER_BANK_NAME";

    private static final String COL_PUR_OF_REMIT = "PUR_OF_REMIT";

    private static final String COL_OVERDUE_PERIOD = "OVERDUE_PERIOD";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_SUPPLIER_ADDR = "SUPPLIER_ADDR";

    private static final String COL_SUPPLIER_COUNTRY = "SUPPLIER_COUNTRY";

    private static final String COL_SELLER_NAME = "SELLER_NAME";

    private static final String COL_SELLER_ADDR = "SELLER_ADDR";

    private static final String COL_SELLER_COUNTRY = "SELLER_COUNTRY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_UTILIZED_INV_AMT = "UTILIZED_INV_AMT";

    private static final String COL_ORM_OS_AMT = "ORM_OS_AMT";

    private static final String COL_IE_CODE_ORM = "IE_CODE_ORM";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SB_NO, COL_SB_DATE, COL_INVOICE_CCY, COL_IE_CODE_SB, COL_PORT_CODE, COL_FORM_NO, COL_INV_SL_NO, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_IRM_CCY, COL_IRM_DATE, COL_IRM_NAME, COL_IRM_COUNTRY, COL_IRM_BANK_COUNTRY, COL_BOE_NUM, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_INV_NUM, COL_TERMS_OF_INV, COL_INVOICE_SL_NO, COL_INV_AMT, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_INV_NO, COL_IRM_BANK_NAME, COL_IRM_SWIFT_BANK_REF_NO, COL_OS_AMT_IRM, COL_INV_CCY, COL_OS_INV_AMT, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT, COL_OVERDUE_PERIOD, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_IE_CODE, COL_UTILIZED_INV_AMT, COL_ORM_OS_AMT, COL_IE_CODE_ORM);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SB_NO, SB_DATE, INVOICE_CCY, IE_CODE_SB, PORT_CODE, FORM_NO, INV_SL_NO, IRM_NO, IRM_AD, IRM_AMT, IRM_CCY, IRM_DATE, IRM_NAME, IRM_COUNTRY, IRM_BANK_COUNTRY, BOE_NUM, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, INV_NUM, TERMS_OF_INV, INVOICE_SL_NO, INV_AMT, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_CCY, ORM_DATE, IE_NAME, INV_NO, IRM_BANK_NAME, IRM_SWIFT_BANK_REF_NO, OS_AMT_IRM, INV_CCY, OS_INV_AMT, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, OVERDUE_PERIOD, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, IE_CODE, UTILIZED_INV_AMT, ORM_OS_AMT, IE_CODE_ORM", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SB_NO, SB_DATE, INVOICE_CCY, IE_CODE_SB, PORT_CODE, FORM_NO, INV_SL_NO, IRM_NO, IRM_AD, IRM_AMT, IRM_CCY, IRM_DATE, IRM_NAME, IRM_COUNTRY, IRM_BANK_COUNTRY, BOE_NUM, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, INV_NUM, TERMS_OF_INV, INVOICE_SL_NO, INV_AMT, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_CCY, ORM_DATE, IE_NAME, INV_NO, IRM_BANK_NAME, IRM_SWIFT_BANK_REF_NO, OS_AMT_IRM, INV_CCY, OS_INV_AMT, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, OVERDUE_PERIOD, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, IE_CODE, UTILIZED_INV_AMT, ORM_OS_AMT, IE_CODE_ORM", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SB_NO, COL_SB_DATE, COL_INVOICE_CCY, COL_IE_CODE_SB, COL_PORT_CODE, COL_FORM_NO, COL_INV_SL_NO, COL_IRM_NO, COL_IRM_AD, COL_IRM_AMT, COL_IRM_CCY, COL_IRM_DATE, COL_IRM_NAME, COL_IRM_COUNTRY, COL_IRM_BANK_COUNTRY, COL_BOE_NUM, COL_BOE_DATE, COL_PORT_OF_DIS, COL_IMPORT_AGENCY, COL_INV_NUM, COL_TERMS_OF_INV, COL_INVOICE_SL_NO, COL_INV_AMT, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_INV_NO, COL_IRM_BANK_NAME, COL_IRM_SWIFT_BANK_REF_NO, COL_OS_AMT_IRM, COL_INV_CCY, COL_OS_INV_AMT, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT, COL_OVERDUE_PERIOD, COL_SUPPLIER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SELLER_NAME, COL_SELLER_ADDR, COL_SELLER_COUNTRY, COL_IE_CODE, COL_UTILIZED_INV_AMT, COL_ORM_OS_AMT, COL_IE_CODE_ORM, COL_ID);

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

    public int insert(Connection conn, FgTrracs fgtrracs) throws SQLException {
        logger.debug("Inserting fgtrracs: {}", fgtrracs);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrracsParams(ps, fgtrracs);
            ps.executeUpdate();
            return fgtrracs.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrracs> fgtrracss) throws SQLException {
        if (fgtrracss == null || fgtrracss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrracss.size(); i++) {
            if (fgtrracss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrracs>> batches = chunkList(fgtrracss, batchSize);
        int[] totalResults = new int[fgtrracss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrracs> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrracs fgtrracs : batch) {
                        setFgTrracsParams(ps, fgtrracs);
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

    public FgTrracs findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrracs> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrracs> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrracs fgtrracs) throws SQLException {
        if (fgtrracs.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrracsParams(ps, fgtrracs);
            ps.setInt(66, fgtrracs.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrracs> fgtrracss) throws SQLException {
        if (fgtrracss == null || fgtrracss.isEmpty())
            return new int[0];
        for (FgTrracs fgtrracs : fgtrracss) {
            if (fgtrracs == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrracs.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrracs>> batches = chunkList(fgtrracss, batchSize);
        int[] totalResults = new int[fgtrracss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrracs> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrracs fgtrracs : batch) {
                        setFgTrracsParams(ps, fgtrracs);
                        ps.setInt(66, fgtrracs.getID());
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

    private void setFgTrracsParams(PreparedStatement ps, FgTrracs fgtrracs) throws SQLException {
        Integer val1 = fgtrracs.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrracs.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrracs.getTypeCode());
        ps.setString(4, fgtrracs.getSubTypeCode());
        ps.setString(5, fgtrracs.getActiveCode());
        ps.setString(6, fgtrracs.getStageCode());
        ps.setString(7, fgtrracs.getStatusCode());
        ps.setString(8, fgtrracs.getCreatedOn());
        java.math.BigDecimal val9 = fgtrracs.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrracs.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrracs.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrracs.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrracs.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrracs.getTemplate());
        java.math.BigDecimal val15 = fgtrracs.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrracs.getSbNo());
        java.time.LocalDateTime val17 = fgtrracs.getSbDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrracs.getInvoiceCcy());
        ps.setString(19, fgtrracs.getIeCodeSb());
        ps.setString(20, fgtrracs.getPortCode());
        ps.setString(21, fgtrracs.getFormNo());
        java.math.BigDecimal val22 = fgtrracs.getInvSlNo();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        ps.setString(23, fgtrracs.getIrmNo());
        ps.setString(24, fgtrracs.getIrmAd());
        java.math.BigDecimal val25 = fgtrracs.getIrmAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgtrracs.getIrmCcy());
        java.time.LocalDateTime val27 = fgtrracs.getIrmDate();
        if (val27 != null) {
            ps.setTimestamp(27, java.sql.Timestamp.valueOf(val27));
        } else {
            ps.setNull(27, Types.TIMESTAMP);
        }
        ps.setString(28, fgtrracs.getIrmName());
        ps.setString(29, fgtrracs.getIrmCountry());
        ps.setString(30, fgtrracs.getIrmBankCountry());
        ps.setString(31, fgtrracs.getBoeNum());
        java.time.LocalDateTime val32 = fgtrracs.getBoeDate();
        if (val32 != null) {
            ps.setTimestamp(32, java.sql.Timestamp.valueOf(val32));
        } else {
            ps.setNull(32, Types.TIMESTAMP);
        }
        ps.setString(33, fgtrracs.getPortOfDis());
        ps.setString(34, fgtrracs.getImportAgency());
        ps.setString(35, fgtrracs.getInvNum());
        ps.setString(36, fgtrracs.getTermsOfInv());
        ps.setString(37, fgtrracs.getInvoiceSlNo());
        java.math.BigDecimal val38 = fgtrracs.getInvAmt();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgtrracs.getOrmNumber());
        ps.setString(40, fgtrracs.getAdCode());
        java.math.BigDecimal val41 = fgtrracs.getOrmAmount();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        java.math.BigDecimal val42 = fgtrracs.getOrmUtilizedAmt();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        ps.setString(43, fgtrracs.getOrmCcy());
        java.time.LocalDateTime val44 = fgtrracs.getOrmDate();
        if (val44 != null) {
            ps.setTimestamp(44, java.sql.Timestamp.valueOf(val44));
        } else {
            ps.setNull(44, Types.TIMESTAMP);
        }
        ps.setString(45, fgtrracs.getIeName());
        ps.setString(46, fgtrracs.getInvNo());
        ps.setString(47, fgtrracs.getIrmBankName());
        ps.setString(48, fgtrracs.getIrmSwiftBankRefNo());
        java.math.BigDecimal val49 = fgtrracs.getOsAmtIrm();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        ps.setString(50, fgtrracs.getInvCcy());
        java.math.BigDecimal val51 = fgtrracs.getOsInvAmt();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        ps.setString(52, fgtrracs.getBeneName());
        ps.setString(53, fgtrracs.getBeneCountry());
        ps.setString(54, fgtrracs.getRemitterBankName());
        ps.setString(55, fgtrracs.getPurOfRemit());
        java.time.LocalDateTime val56 = fgtrracs.getOverduePeriod();
        if (val56 != null) {
            ps.setTimestamp(56, java.sql.Timestamp.valueOf(val56));
        } else {
            ps.setNull(56, Types.TIMESTAMP);
        }
        ps.setString(57, fgtrracs.getSupplierName());
        ps.setString(58, fgtrracs.getSupplierAddr());
        ps.setString(59, fgtrracs.getSupplierCountry());
        ps.setString(60, fgtrracs.getSellerName());
        ps.setString(61, fgtrracs.getSellerAddr());
        ps.setString(62, fgtrracs.getSellerCountry());
        ps.setString(63, fgtrracs.getIeCode());
        java.math.BigDecimal val64 = fgtrracs.getUtilizedInvAmt();
        if (val64 != null) {
            ps.setBigDecimal(64, val64);
        } else {
            ps.setNull(64, Types.DECIMAL);
        }
        java.math.BigDecimal val65 = fgtrracs.getOrmOsAmt();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        ps.setString(66, fgtrracs.getIeCodeOrm());
    }

    private FgTrracs extract(ResultSet rs) throws SQLException {
        FgTrracs fgtrracs = new FgTrracs();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrracs.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrracs.setReferenceID(REFERENCE_ID);
        fgtrracs.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrracs.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrracs.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrracs.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrracs.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrracs.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrracs.setCreatedBy(CREATED_BY);
        fgtrracs.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrracs.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrracs.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrracs.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrracs.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrracs.setIsTemplate(IS_TEMPLATE);
        fgtrracs.setSbNo(rs.getString(COL_SB_NO));
        Timestamp SB_DATE = rs.getTimestamp(COL_SB_DATE);
        if (SB_DATE != null)
            fgtrracs.setSbDate(SB_DATE.toLocalDateTime());
        fgtrracs.setInvoiceCcy(rs.getString(COL_INVOICE_CCY));
        fgtrracs.setIeCodeSb(rs.getString(COL_IE_CODE_SB));
        fgtrracs.setPortCode(rs.getString(COL_PORT_CODE));
        fgtrracs.setFormNo(rs.getString(COL_FORM_NO));
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        fgtrracs.setInvSlNo(INV_SL_NO);
        fgtrracs.setIrmNo(rs.getString(COL_IRM_NO));
        fgtrracs.setIrmAd(rs.getString(COL_IRM_AD));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgtrracs.setIrmAmt(IRM_AMT);
        fgtrracs.setIrmCcy(rs.getString(COL_IRM_CCY));
        Timestamp IRM_DATE = rs.getTimestamp(COL_IRM_DATE);
        if (IRM_DATE != null)
            fgtrracs.setIrmDate(IRM_DATE.toLocalDateTime());
        fgtrracs.setIrmName(rs.getString(COL_IRM_NAME));
        fgtrracs.setIrmCountry(rs.getString(COL_IRM_COUNTRY));
        fgtrracs.setIrmBankCountry(rs.getString(COL_IRM_BANK_COUNTRY));
        fgtrracs.setBoeNum(rs.getString(COL_BOE_NUM));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgtrracs.setBoeDate(BOE_DATE.toLocalDateTime());
        fgtrracs.setPortOfDis(rs.getString(COL_PORT_OF_DIS));
        fgtrracs.setImportAgency(rs.getString(COL_IMPORT_AGENCY));
        fgtrracs.setInvNum(rs.getString(COL_INV_NUM));
        fgtrracs.setTermsOfInv(rs.getString(COL_TERMS_OF_INV));
        fgtrracs.setInvoiceSlNo(rs.getString(COL_INVOICE_SL_NO));
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        fgtrracs.setInvAmt(INV_AMT);
        fgtrracs.setOrmNumber(rs.getString(COL_ORM_NUMBER));
        fgtrracs.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal ORM_AMOUNT = rs.getObject(COL_ORM_AMOUNT, java.math.BigDecimal.class);
        fgtrracs.setOrmAmount(ORM_AMOUNT);
        java.math.BigDecimal ORM_UTILIZED_AMT = rs.getObject(COL_ORM_UTILIZED_AMT, java.math.BigDecimal.class);
        fgtrracs.setOrmUtilizedAmt(ORM_UTILIZED_AMT);
        fgtrracs.setOrmCcy(rs.getString(COL_ORM_CCY));
        Timestamp ORM_DATE = rs.getTimestamp(COL_ORM_DATE);
        if (ORM_DATE != null)
            fgtrracs.setOrmDate(ORM_DATE.toLocalDateTime());
        fgtrracs.setIeName(rs.getString(COL_IE_NAME));
        fgtrracs.setInvNo(rs.getString(COL_INV_NO));
        fgtrracs.setIrmBankName(rs.getString(COL_IRM_BANK_NAME));
        fgtrracs.setIrmSwiftBankRefNo(rs.getString(COL_IRM_SWIFT_BANK_REF_NO));
        java.math.BigDecimal OS_AMT_IRM = rs.getObject(COL_OS_AMT_IRM, java.math.BigDecimal.class);
        fgtrracs.setOsAmtIrm(OS_AMT_IRM);
        fgtrracs.setInvCcy(rs.getString(COL_INV_CCY));
        java.math.BigDecimal OS_INV_AMT = rs.getObject(COL_OS_INV_AMT, java.math.BigDecimal.class);
        fgtrracs.setOsInvAmt(OS_INV_AMT);
        fgtrracs.setBeneName(rs.getString(COL_BENE_NAME));
        fgtrracs.setBeneCountry(rs.getString(COL_BENE_COUNTRY));
        fgtrracs.setRemitterBankName(rs.getString(COL_REMITTER_BANK_NAME));
        fgtrracs.setPurOfRemit(rs.getString(COL_PUR_OF_REMIT));
        Timestamp OVERDUE_PERIOD = rs.getTimestamp(COL_OVERDUE_PERIOD);
        if (OVERDUE_PERIOD != null)
            fgtrracs.setOverduePeriod(OVERDUE_PERIOD.toLocalDateTime());
        fgtrracs.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        fgtrracs.setSupplierAddr(rs.getString(COL_SUPPLIER_ADDR));
        fgtrracs.setSupplierCountry(rs.getString(COL_SUPPLIER_COUNTRY));
        fgtrracs.setSellerName(rs.getString(COL_SELLER_NAME));
        fgtrracs.setSellerAddr(rs.getString(COL_SELLER_ADDR));
        fgtrracs.setSellerCountry(rs.getString(COL_SELLER_COUNTRY));
        fgtrracs.setIeCode(rs.getString(COL_IE_CODE));
        java.math.BigDecimal UTILIZED_INV_AMT = rs.getObject(COL_UTILIZED_INV_AMT, java.math.BigDecimal.class);
        fgtrracs.setUtilizedInvAmt(UTILIZED_INV_AMT);
        java.math.BigDecimal ORM_OS_AMT = rs.getObject(COL_ORM_OS_AMT, java.math.BigDecimal.class);
        fgtrracs.setOrmOsAmt(ORM_OS_AMT);
        fgtrracs.setIeCodeOrm(rs.getString(COL_IE_CODE_ORM));
        return fgtrracs;
    }
}
