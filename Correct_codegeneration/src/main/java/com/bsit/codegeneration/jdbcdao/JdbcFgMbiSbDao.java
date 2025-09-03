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

public class JdbcFgMbiSbDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMbiSbDao.class);

    private static final String TABLE = "FG_MBI_SB";

    private static final String COL_BILL_ID = "BILL_ID";

    private static final String COL_INVOICE_ID = "INVOICE_ID";

    private static final String COL_SHIPPING_BILL_STATUS = "SHIPPING_BILL_STATUS";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_SHIPBILLDATE = "SHIPBILLDATE";

    private static final String COL_LEODATE = "LEODATE";

    private static final String COL_ADCODE = "ADCODE";

    private static final String COL_PORTCODE = "PORTCODE";

    private static final String COL_EXPORT_AGENCY = "EXPORT_AGENCY";

    private static final String COL_EXP_TYPE = "EXP_TYPE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_AD_BILL_NUMBER = "AD_BILL_NUMBER";

    private static final String COL_INVOICE_STATUS = "INVOICE_STATUS";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_FOBCURRCODE = "FOBCURRCODE";

    private static final String COL_FRIEGHTCURRCODE = "FRIEGHTCURRCODE";

    private static final String COL_INSCURRCODE = "INSCURRCODE";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_UTIL_FOB_AMT = "UTIL_FOB_AMT";

    private static final String COL_FRIEGHT_AMT = "FRIEGHT_AMT";

    private static final String COL_UTIL_FRIEGHT_AMT = "UTIL_FRIEGHT_AMT";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_UTIL_INS_AMT = "UTIL_INS_AMT";

    private static final String COL_LEO_DATE = "LEO_DATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_BILL_ID, COL_INVOICE_ID, COL_SHIPPING_BILL_STATUS, COL_BILL_NO, COL_FORMNO, COL_SHIPBILLDATE, COL_LEODATE, COL_ADCODE, COL_PORTCODE, COL_EXPORT_AGENCY, COL_EXP_TYPE, COL_IE_CODE, COL_AD_BILL_NUMBER, COL_INVOICE_STATUS, COL_INV_NO, COL_INV_DATE, COL_INV_SL_NO, COL_FOBCURRCODE, COL_FRIEGHTCURRCODE, COL_INSCURRCODE, COL_FOB_AMT, COL_UTIL_FOB_AMT, COL_FRIEGHT_AMT, COL_UTIL_FRIEGHT_AMT, COL_INS_AMT, COL_UTIL_INS_AMT, COL_LEO_DATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, BILL_NO, FORMNO, SHIPBILLDATE, LEODATE, ADCODE, PORTCODE, EXPORT_AGENCY, EXP_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INV_NO, INV_DATE, INV_SL_NO, FOBCURRCODE, FRIEGHTCURRCODE, INSCURRCODE, FOB_AMT, UTIL_FOB_AMT, FRIEGHT_AMT, UTIL_FRIEGHT_AMT, INS_AMT, UTIL_INS_AMT, LEO_DATE", TABLE, COL_BILL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, BILL_NO, FORMNO, SHIPBILLDATE, LEODATE, ADCODE, PORTCODE, EXPORT_AGENCY, EXP_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INV_NO, INV_DATE, INV_SL_NO, FOBCURRCODE, FRIEGHTCURRCODE, INSCURRCODE, FOB_AMT, UTIL_FOB_AMT, FRIEGHT_AMT, UTIL_FRIEGHT_AMT, INS_AMT, UTIL_INS_AMT, LEO_DATE", TABLE, COL_BILL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_INVOICE_ID, COL_SHIPPING_BILL_STATUS, COL_BILL_NO, COL_FORMNO, COL_SHIPBILLDATE, COL_LEODATE, COL_ADCODE, COL_PORTCODE, COL_EXPORT_AGENCY, COL_EXP_TYPE, COL_IE_CODE, COL_AD_BILL_NUMBER, COL_INVOICE_STATUS, COL_INV_NO, COL_INV_DATE, COL_INV_SL_NO, COL_FOBCURRCODE, COL_FRIEGHTCURRCODE, COL_INSCURRCODE, COL_FOB_AMT, COL_UTIL_FOB_AMT, COL_FRIEGHT_AMT, COL_UTIL_FRIEGHT_AMT, COL_INS_AMT, COL_UTIL_INS_AMT, COL_LEO_DATE, COL_BILL_ID);

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

    public int insert(Connection conn, FgMbiSb fgmbisb) throws SQLException {
        logger.debug("Inserting fgmbisb: {}", fgmbisb);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMbiSbParams(ps, fgmbisb);
            ps.executeUpdate();
            return fgmbisb.getBillID();
        }
    }

    public int[] insertAll(Connection conn, List<FgMbiSb> fgmbisbs) throws SQLException {
        if (fgmbisbs == null || fgmbisbs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmbisbs.size(); i++) {
            if (fgmbisbs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiSb>> batches = chunkList(fgmbisbs, batchSize);
        int[] totalResults = new int[fgmbisbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMbiSb fgmbisb : batch) {
                        setFgMbiSbParams(ps, fgmbisb);
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

    public FgMbiSb findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMbiSb> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMbiSb> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMbiSb fgmbisb) throws SQLException {
        if (fgmbisb.getBillID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMbiSbParams(ps, fgmbisb);
            ps.setInt(27, fgmbisb.getBillID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMbiSb> fgmbisbs) throws SQLException {
        if (fgmbisbs == null || fgmbisbs.isEmpty())
            return new int[0];
        for (FgMbiSb fgmbisb : fgmbisbs) {
            if (fgmbisb == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmbisb.getBillID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMbiSb>> batches = chunkList(fgmbisbs, batchSize);
        int[] totalResults = new int[fgmbisbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMbiSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMbiSb fgmbisb : batch) {
                        setFgMbiSbParams(ps, fgmbisb);
                        ps.setInt(27, fgmbisb.getBillID());
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

    private void setFgMbiSbParams(PreparedStatement ps, FgMbiSb fgmbisb) throws SQLException {
        Integer val1 = fgmbisb.getBillID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmbisb.getInvoiceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmbisb.getShippingBillStatus());
        ps.setString(4, fgmbisb.getBillNo());
        ps.setString(5, fgmbisb.getFormno());
        java.time.LocalDateTime val6 = fgmbisb.getShipbilldate();
        if (val6 != null) {
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(val6));
        } else {
            ps.setNull(6, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val7 = fgmbisb.getLeodate();
        if (val7 != null) {
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(val7));
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
        ps.setString(8, fgmbisb.getAdcode());
        ps.setString(9, fgmbisb.getPortcode());
        ps.setString(10, fgmbisb.getExportAgency());
        ps.setString(11, fgmbisb.getExpType());
        ps.setString(12, fgmbisb.getIeCode());
        ps.setString(13, fgmbisb.getAdBillNumber());
        ps.setString(14, fgmbisb.getInvoiceStatus());
        ps.setString(15, fgmbisb.getInvNo());
        java.time.LocalDateTime val16 = fgmbisb.getInvDate();
        if (val16 != null) {
            ps.setTimestamp(16, java.sql.Timestamp.valueOf(val16));
        } else {
            ps.setNull(16, Types.TIMESTAMP);
        }
        java.math.BigDecimal val17 = fgmbisb.getInvSlNo();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgmbisb.getFobcurrcode());
        ps.setString(19, fgmbisb.getFrieghtcurrcode());
        ps.setString(20, fgmbisb.getInscurrcode());
        java.math.BigDecimal val21 = fgmbisb.getFobAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgmbisb.getUtilFobAmt();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = fgmbisb.getFrieghtAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgmbisb.getUtilFrieghtAmt();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = fgmbisb.getInsAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = fgmbisb.getUtilInsAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        java.time.LocalDateTime val27 = fgmbisb.getLeoDate();
        if (val27 != null) {
            ps.setTimestamp(27, java.sql.Timestamp.valueOf(val27));
        } else {
            ps.setNull(27, Types.TIMESTAMP);
        }
    }

    private FgMbiSb extract(ResultSet rs) throws SQLException {
        FgMbiSb fgmbisb = new FgMbiSb();
        Integer BILL_ID = rs.getObject(COL_BILL_ID, Integer.class);
        fgmbisb.setBillID(BILL_ID);
        Integer INVOICE_ID = rs.getObject(COL_INVOICE_ID, Integer.class);
        fgmbisb.setInvoiceID(INVOICE_ID);
        fgmbisb.setShippingBillStatus(rs.getString(COL_SHIPPING_BILL_STATUS));
        fgmbisb.setBillNo(rs.getString(COL_BILL_NO));
        fgmbisb.setFormno(rs.getString(COL_FORMNO));
        Timestamp SHIPBILLDATE = rs.getTimestamp(COL_SHIPBILLDATE);
        if (SHIPBILLDATE != null)
            fgmbisb.setShipbilldate(SHIPBILLDATE.toLocalDateTime());
        Timestamp LEODATE = rs.getTimestamp(COL_LEODATE);
        if (LEODATE != null)
            fgmbisb.setLeodate(LEODATE.toLocalDateTime());
        fgmbisb.setAdcode(rs.getString(COL_ADCODE));
        fgmbisb.setPortcode(rs.getString(COL_PORTCODE));
        fgmbisb.setExportAgency(rs.getString(COL_EXPORT_AGENCY));
        fgmbisb.setExpType(rs.getString(COL_EXP_TYPE));
        fgmbisb.setIeCode(rs.getString(COL_IE_CODE));
        fgmbisb.setAdBillNumber(rs.getString(COL_AD_BILL_NUMBER));
        fgmbisb.setInvoiceStatus(rs.getString(COL_INVOICE_STATUS));
        fgmbisb.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgmbisb.setInvDate(INV_DATE.toLocalDateTime());
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        fgmbisb.setInvSlNo(INV_SL_NO);
        fgmbisb.setFobcurrcode(rs.getString(COL_FOBCURRCODE));
        fgmbisb.setFrieghtcurrcode(rs.getString(COL_FRIEGHTCURRCODE));
        fgmbisb.setInscurrcode(rs.getString(COL_INSCURRCODE));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgmbisb.setFobAmt(FOB_AMT);
        java.math.BigDecimal UTIL_FOB_AMT = rs.getObject(COL_UTIL_FOB_AMT, java.math.BigDecimal.class);
        fgmbisb.setUtilFobAmt(UTIL_FOB_AMT);
        java.math.BigDecimal FRIEGHT_AMT = rs.getObject(COL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgmbisb.setFrieghtAmt(FRIEGHT_AMT);
        java.math.BigDecimal UTIL_FRIEGHT_AMT = rs.getObject(COL_UTIL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgmbisb.setUtilFrieghtAmt(UTIL_FRIEGHT_AMT);
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgmbisb.setInsAmt(INS_AMT);
        java.math.BigDecimal UTIL_INS_AMT = rs.getObject(COL_UTIL_INS_AMT, java.math.BigDecimal.class);
        fgmbisb.setUtilInsAmt(UTIL_INS_AMT);
        Timestamp LEO_DATE = rs.getTimestamp(COL_LEO_DATE);
        if (LEO_DATE != null)
            fgmbisb.setLeoDate(LEO_DATE.toLocalDateTime());
        return fgmbisb;
    }
}
