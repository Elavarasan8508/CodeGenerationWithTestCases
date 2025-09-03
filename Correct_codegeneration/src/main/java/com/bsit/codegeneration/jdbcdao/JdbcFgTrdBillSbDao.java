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

public class JdbcFgTrdBillSbDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdBillSbDao.class);

    private static final String TABLE = "FG_TRD_BILL_SB";

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

    private static final String COL_SHIPPINGBILL_NO = "SHIPPINGBILL_NO";

    private static final String COL_SB_DATE = "SB_DATE";

    private static final String COL_FORM_NO = "FORM_NO";

    private static final String COL_PORT_CODE = "PORT_CODE";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_FOB_CCY = "FOB_CCY";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_UTIL_FOB_AMT = "UTIL_FOB_AMT";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_EXP_AGENCY = "EXP_AGENCY";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_LEO_DATE = "LEO_DATE";

    private static final String COL_OS_PERIOD = "OS_PERIOD";

    private static final String COL_AD_BILL_NO = "AD_BILL_NO";

    private static final String COL_SB_STATUS = "SB_STATUS";

    private static final String COL_EXP_TYPE = "EXP_TYPE";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_STATUS = "INV_STATUS";

    private static final String COL_FREIGHT_AMT = "FREIGHT_AMT";

    private static final String COL_FREIGHT_CCY = "FREIGHT_CCY";

    private static final String COL_UTIL_FREIGHT_AMT = "UTIL_FREIGHT_AMT";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_INS_CCY = "INS_CCY";

    private static final String COL_UTIL_INS_AMT = "UTIL_INS_AMT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SHIPPINGBILL_NO, COL_SB_DATE, COL_FORM_NO, COL_PORT_CODE, COL_FOB_AMT, COL_FOB_CCY, COL_IE_CODE, COL_UTIL_FOB_AMT, COL_INV_SL_NO, COL_INV_NO, COL_EXP_AGENCY, COL_AD_CODE, COL_LEO_DATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_SB_STATUS, COL_EXP_TYPE, COL_INV_DATE, COL_INV_STATUS, COL_FREIGHT_AMT, COL_FREIGHT_CCY, COL_UTIL_FREIGHT_AMT, COL_INS_AMT, COL_INS_CCY, COL_UTIL_INS_AMT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPPINGBILL_NO, SB_DATE, FORM_NO, PORT_CODE, FOB_AMT, FOB_CCY, IE_CODE, UTIL_FOB_AMT, INV_SL_NO, INV_NO, EXP_AGENCY, AD_CODE, LEO_DATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, EXP_TYPE, INV_DATE, INV_STATUS, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPPINGBILL_NO, SB_DATE, FORM_NO, PORT_CODE, FOB_AMT, FOB_CCY, IE_CODE, UTIL_FOB_AMT, INV_SL_NO, INV_NO, EXP_AGENCY, AD_CODE, LEO_DATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, EXP_TYPE, INV_DATE, INV_STATUS, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SHIPPINGBILL_NO, COL_SB_DATE, COL_FORM_NO, COL_PORT_CODE, COL_FOB_AMT, COL_FOB_CCY, COL_IE_CODE, COL_UTIL_FOB_AMT, COL_INV_SL_NO, COL_INV_NO, COL_EXP_AGENCY, COL_AD_CODE, COL_LEO_DATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_SB_STATUS, COL_EXP_TYPE, COL_INV_DATE, COL_INV_STATUS, COL_FREIGHT_AMT, COL_FREIGHT_CCY, COL_UTIL_FREIGHT_AMT, COL_INS_AMT, COL_INS_CCY, COL_UTIL_INS_AMT, COL_ID);

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

    public int insert(Connection conn, FgTrdBillSb fgtrdbillsb) throws SQLException {
        logger.debug("Inserting fgtrdbillsb: {}", fgtrdbillsb);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdBillSbParams(ps, fgtrdbillsb);
            ps.executeUpdate();
            return fgtrdbillsb.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdBillSb> fgtrdbillsbs) throws SQLException {
        if (fgtrdbillsbs == null || fgtrdbillsbs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdbillsbs.size(); i++) {
            if (fgtrdbillsbs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillSb>> batches = chunkList(fgtrdbillsbs, batchSize);
        int[] totalResults = new int[fgtrdbillsbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdBillSb fgtrdbillsb : batch) {
                        setFgTrdBillSbParams(ps, fgtrdbillsb);
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

    public FgTrdBillSb findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdBillSb> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdBillSb> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdBillSb fgtrdbillsb) throws SQLException {
        if (fgtrdbillsb.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdBillSbParams(ps, fgtrdbillsb);
            ps.setInt(40, fgtrdbillsb.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdBillSb> fgtrdbillsbs) throws SQLException {
        if (fgtrdbillsbs == null || fgtrdbillsbs.isEmpty())
            return new int[0];
        for (FgTrdBillSb fgtrdbillsb : fgtrdbillsbs) {
            if (fgtrdbillsb == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdbillsb.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillSb>> batches = chunkList(fgtrdbillsbs, batchSize);
        int[] totalResults = new int[fgtrdbillsbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdBillSb fgtrdbillsb : batch) {
                        setFgTrdBillSbParams(ps, fgtrdbillsb);
                        ps.setInt(40, fgtrdbillsb.getID());
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

    private void setFgTrdBillSbParams(PreparedStatement ps, FgTrdBillSb fgtrdbillsb) throws SQLException {
        Integer val1 = fgtrdbillsb.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdbillsb.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdbillsb.getTypeCode());
        ps.setString(4, fgtrdbillsb.getSubTypeCode());
        ps.setString(5, fgtrdbillsb.getActiveCode());
        ps.setString(6, fgtrdbillsb.getStageCode());
        ps.setString(7, fgtrdbillsb.getStatusCode());
        ps.setString(8, fgtrdbillsb.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdbillsb.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdbillsb.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdbillsb.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdbillsb.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdbillsb.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdbillsb.getTemplate());
        java.math.BigDecimal val15 = fgtrdbillsb.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdbillsb.getShippingbillNo());
        java.time.LocalDateTime val17 = fgtrdbillsb.getSbDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrdbillsb.getFormNo());
        ps.setString(19, fgtrdbillsb.getPortCode());
        java.math.BigDecimal val20 = fgtrdbillsb.getFobAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgtrdbillsb.getFobCcy());
        ps.setString(22, fgtrdbillsb.getIeCode());
        java.math.BigDecimal val23 = fgtrdbillsb.getUtilFobAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        java.math.BigDecimal val24 = fgtrdbillsb.getInvSlNo();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        ps.setString(25, fgtrdbillsb.getInvNo());
        ps.setString(26, fgtrdbillsb.getExpAgency());
        ps.setString(27, fgtrdbillsb.getAdCode());
        java.time.LocalDateTime val28 = fgtrdbillsb.getLeoDate();
        if (val28 != null) {
            ps.setTimestamp(28, java.sql.Timestamp.valueOf(val28));
        } else {
            ps.setNull(28, Types.TIMESTAMP);
        }
        java.math.BigDecimal val29 = fgtrdbillsb.getOsPeriod();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgtrdbillsb.getAdBillNo());
        ps.setString(31, fgtrdbillsb.getSbStatus());
        ps.setString(32, fgtrdbillsb.getExpType());
        java.time.LocalDateTime val33 = fgtrdbillsb.getInvDate();
        if (val33 != null) {
            ps.setTimestamp(33, java.sql.Timestamp.valueOf(val33));
        } else {
            ps.setNull(33, Types.TIMESTAMP);
        }
        ps.setString(34, fgtrdbillsb.getInvStatus());
        java.math.BigDecimal val35 = fgtrdbillsb.getFreightAmt();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgtrdbillsb.getFreightCcy());
        java.math.BigDecimal val37 = fgtrdbillsb.getUtilFreightAmt();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = fgtrdbillsb.getInsAmt();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgtrdbillsb.getInsCcy());
        java.math.BigDecimal val40 = fgtrdbillsb.getUtilInsAmt();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
    }

    private FgTrdBillSb extract(ResultSet rs) throws SQLException {
        FgTrdBillSb fgtrdbillsb = new FgTrdBillSb();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdbillsb.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdbillsb.setReferenceID(REFERENCE_ID);
        fgtrdbillsb.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdbillsb.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdbillsb.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdbillsb.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdbillsb.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdbillsb.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdbillsb.setCreatedBy(CREATED_BY);
        fgtrdbillsb.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdbillsb.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdbillsb.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdbillsb.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdbillsb.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdbillsb.setIsTemplate(IS_TEMPLATE);
        fgtrdbillsb.setShippingbillNo(rs.getString(COL_SHIPPINGBILL_NO));
        Timestamp SB_DATE = rs.getTimestamp(COL_SB_DATE);
        if (SB_DATE != null)
            fgtrdbillsb.setSbDate(SB_DATE.toLocalDateTime());
        fgtrdbillsb.setFormNo(rs.getString(COL_FORM_NO));
        fgtrdbillsb.setPortCode(rs.getString(COL_PORT_CODE));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setFobAmt(FOB_AMT);
        fgtrdbillsb.setFobCcy(rs.getString(COL_FOB_CCY));
        fgtrdbillsb.setIeCode(rs.getString(COL_IE_CODE));
        java.math.BigDecimal UTIL_FOB_AMT = rs.getObject(COL_UTIL_FOB_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setUtilFobAmt(UTIL_FOB_AMT);
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        fgtrdbillsb.setInvSlNo(INV_SL_NO);
        fgtrdbillsb.setInvNo(rs.getString(COL_INV_NO));
        fgtrdbillsb.setExpAgency(rs.getString(COL_EXP_AGENCY));
        fgtrdbillsb.setAdCode(rs.getString(COL_AD_CODE));
        Timestamp LEO_DATE = rs.getTimestamp(COL_LEO_DATE);
        if (LEO_DATE != null)
            fgtrdbillsb.setLeoDate(LEO_DATE.toLocalDateTime());
        java.math.BigDecimal OS_PERIOD = rs.getObject(COL_OS_PERIOD, java.math.BigDecimal.class);
        fgtrdbillsb.setOsPeriod(OS_PERIOD);
        fgtrdbillsb.setAdBillNo(rs.getString(COL_AD_BILL_NO));
        fgtrdbillsb.setSbStatus(rs.getString(COL_SB_STATUS));
        fgtrdbillsb.setExpType(rs.getString(COL_EXP_TYPE));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgtrdbillsb.setInvDate(INV_DATE.toLocalDateTime());
        fgtrdbillsb.setInvStatus(rs.getString(COL_INV_STATUS));
        java.math.BigDecimal FREIGHT_AMT = rs.getObject(COL_FREIGHT_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setFreightAmt(FREIGHT_AMT);
        fgtrdbillsb.setFreightCcy(rs.getString(COL_FREIGHT_CCY));
        java.math.BigDecimal UTIL_FREIGHT_AMT = rs.getObject(COL_UTIL_FREIGHT_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setUtilFreightAmt(UTIL_FREIGHT_AMT);
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setInsAmt(INS_AMT);
        fgtrdbillsb.setInsCcy(rs.getString(COL_INS_CCY));
        java.math.BigDecimal UTIL_INS_AMT = rs.getObject(COL_UTIL_INS_AMT, java.math.BigDecimal.class);
        fgtrdbillsb.setUtilInsAmt(UTIL_INS_AMT);
        return fgtrdbillsb;
    }
}
