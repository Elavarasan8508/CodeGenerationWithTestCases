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

public class JdbcFgExpMbiSbDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgExpMbiSbDao.class);

    private static final String TABLE = "FG_EXP_MBI_SB";

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

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_SHIPBILLDATE = "SHIPBILLDATE";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_EXP_AGENCY = "EXP_AGENCY";

    private static final String COL_ADCODE = "ADCODE";

    private static final String COL_LEODATE = "LEODATE";

    private static final String COL_OS_PERIOD = "OS_PERIOD";

    private static final String COL_AD_BILL_NO = "AD_BILL_NO";

    private static final String COL_SB_STATUS = "SB_STATUS";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_PORTCODE = "PORTCODE";

    private static final String COL_EXP_TYPE = "EXP_TYPE";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_STATUS = "INV_STATUS";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_FOBCURRCODE = "FOBCURRCODE";

    private static final String COL_UTIL_FOB_AMT = "UTIL_FOB_AMT";

    private static final String COL_FRIEGHT_AMT = "FRIEGHT_AMT";

    private static final String COL_FRIEGHTCURRCODE = "FRIEGHTCURRCODE";

    private static final String COL_UTIL_FRIEGHT_AMT = "UTIL_FRIEGHT_AMT";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_INSCURRCODE = "INSCURRCODE";

    private static final String COL_UTIL_INS_AMT = "UTIL_INS_AMT";

    private static final String COL_HS_CODE = "HS_CODE";

    private static final String COL_GOOD_DESC = "GOOD_DESC";

    private static final String COL_PORT_OF_DEST = "PORT_OF_DEST";

    private static final String COL_TRANSPORT_DOC_NO = "TRANSPORT_DOC_NO";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_SB_AMOUNT = "SB_AMOUNT";

    private static final String COL_SB_OS_AMT = "SB_OS_AMT";

    private static final String COL_TOTAL_SETTLED_AMT = "TOTAL_SETTLED_AMT";

    private static final String COL_BILL_UTIL_AMT = "BILL_UTIL_AMT";

    private static final String COL_BILL_AMT = "BILL_AMT";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_SB_SHORTFALL = "SB_SHORTFALL";

    private static final String COL_SB_REASON = "SB_REASON";

    private static final String COL_ENDORSED_AMT = "ENDORSED_AMT";

    private static final String COL_BILL_TYPE = "BILL_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_IE_CODE, COL_EXP_AGENCY, COL_ADCODE, COL_LEODATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_SB_STATUS, COL_INV_SL_NO, COL_INV_NO, COL_PORTCODE, COL_EXP_TYPE, COL_INV_DATE, COL_INV_STATUS, COL_FOB_AMT, COL_FOBCURRCODE, COL_UTIL_FOB_AMT, COL_FRIEGHT_AMT, COL_FRIEGHTCURRCODE, COL_UTIL_FRIEGHT_AMT, COL_INS_AMT, COL_INSCURRCODE, COL_UTIL_INS_AMT, COL_HS_CODE, COL_GOOD_DESC, COL_PORT_OF_DEST, COL_TRANSPORT_DOC_NO, COL_BILL_NO, COL_SB_AMOUNT, COL_SB_OS_AMT, COL_TOTAL_SETTLED_AMT, COL_BILL_UTIL_AMT, COL_BILL_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SB_SHORTFALL, COL_SB_REASON, COL_ENDORSED_AMT, COL_BILL_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPBILLNO, SHIPBILLDATE, FORMNO, IE_CODE, EXP_AGENCY, ADCODE, LEODATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, INV_SL_NO, INV_NO, PORTCODE, EXP_TYPE, INV_DATE, INV_STATUS, FOB_AMT, FOBCURRCODE, UTIL_FOB_AMT, FRIEGHT_AMT, FRIEGHTCURRCODE, UTIL_FRIEGHT_AMT, INS_AMT, INSCURRCODE, UTIL_INS_AMT, HS_CODE, GOOD_DESC, PORT_OF_DEST, TRANSPORT_DOC_NO, BILL_NO, SB_AMOUNT, SB_OS_AMT, TOTAL_SETTLED_AMT, BILL_UTIL_AMT, BILL_AMT, PARENT_REF_ID, PARENT_VERSION_ID, SB_SHORTFALL, SB_REASON, ENDORSED_AMT, BILL_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPBILLNO, SHIPBILLDATE, FORMNO, IE_CODE, EXP_AGENCY, ADCODE, LEODATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, INV_SL_NO, INV_NO, PORTCODE, EXP_TYPE, INV_DATE, INV_STATUS, FOB_AMT, FOBCURRCODE, UTIL_FOB_AMT, FRIEGHT_AMT, FRIEGHTCURRCODE, UTIL_FRIEGHT_AMT, INS_AMT, INSCURRCODE, UTIL_INS_AMT, HS_CODE, GOOD_DESC, PORT_OF_DEST, TRANSPORT_DOC_NO, BILL_NO, SB_AMOUNT, SB_OS_AMT, TOTAL_SETTLED_AMT, BILL_UTIL_AMT, BILL_AMT, PARENT_REF_ID, PARENT_VERSION_ID, SB_SHORTFALL, SB_REASON, ENDORSED_AMT, BILL_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_IE_CODE, COL_EXP_AGENCY, COL_ADCODE, COL_LEODATE, COL_OS_PERIOD, COL_AD_BILL_NO, COL_SB_STATUS, COL_INV_SL_NO, COL_INV_NO, COL_PORTCODE, COL_EXP_TYPE, COL_INV_DATE, COL_INV_STATUS, COL_FOB_AMT, COL_FOBCURRCODE, COL_UTIL_FOB_AMT, COL_FRIEGHT_AMT, COL_FRIEGHTCURRCODE, COL_UTIL_FRIEGHT_AMT, COL_INS_AMT, COL_INSCURRCODE, COL_UTIL_INS_AMT, COL_HS_CODE, COL_GOOD_DESC, COL_PORT_OF_DEST, COL_TRANSPORT_DOC_NO, COL_BILL_NO, COL_SB_AMOUNT, COL_SB_OS_AMT, COL_TOTAL_SETTLED_AMT, COL_BILL_UTIL_AMT, COL_BILL_AMT, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SB_SHORTFALL, COL_SB_REASON, COL_ENDORSED_AMT, COL_BILL_TYPE, COL_ID);

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

    public int insert(Connection conn, FgExpMbiSb fgexpmbisb) throws SQLException {
        logger.debug("Inserting fgexpmbisb: {}", fgexpmbisb);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgExpMbiSbParams(ps, fgexpmbisb);
            ps.executeUpdate();
            return fgexpmbisb.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgExpMbiSb> fgexpmbisbs) throws SQLException {
        if (fgexpmbisbs == null || fgexpmbisbs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgexpmbisbs.size(); i++) {
            if (fgexpmbisbs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiSb>> batches = chunkList(fgexpmbisbs, batchSize);
        int[] totalResults = new int[fgexpmbisbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgExpMbiSb fgexpmbisb : batch) {
                        setFgExpMbiSbParams(ps, fgexpmbisb);
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

    public FgExpMbiSb findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgExpMbiSb> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgExpMbiSb> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgExpMbiSb fgexpmbisb) throws SQLException {
        if (fgexpmbisb.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgExpMbiSbParams(ps, fgexpmbisb);
            ps.setInt(56, fgexpmbisb.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgExpMbiSb> fgexpmbisbs) throws SQLException {
        if (fgexpmbisbs == null || fgexpmbisbs.isEmpty())
            return new int[0];
        for (FgExpMbiSb fgexpmbisb : fgexpmbisbs) {
            if (fgexpmbisb == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgexpmbisb.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiSb>> batches = chunkList(fgexpmbisbs, batchSize);
        int[] totalResults = new int[fgexpmbisbs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiSb> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgExpMbiSb fgexpmbisb : batch) {
                        setFgExpMbiSbParams(ps, fgexpmbisb);
                        ps.setInt(56, fgexpmbisb.getID());
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

    private void setFgExpMbiSbParams(PreparedStatement ps, FgExpMbiSb fgexpmbisb) throws SQLException {
        Integer val1 = fgexpmbisb.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgexpmbisb.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgexpmbisb.getTypeCode());
        ps.setString(4, fgexpmbisb.getSubTypeCode());
        ps.setString(5, fgexpmbisb.getActiveCode());
        ps.setString(6, fgexpmbisb.getStageCode());
        ps.setString(7, fgexpmbisb.getStatusCode());
        ps.setString(8, fgexpmbisb.getCreatedOn());
        java.math.BigDecimal val9 = fgexpmbisb.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgexpmbisb.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgexpmbisb.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgexpmbisb.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgexpmbisb.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgexpmbisb.getTemplate());
        java.math.BigDecimal val15 = fgexpmbisb.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgexpmbisb.getShipbillno());
        java.time.LocalDateTime val17 = fgexpmbisb.getShipbilldate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgexpmbisb.getFormno());
        ps.setString(19, fgexpmbisb.getIeCode());
        ps.setString(20, fgexpmbisb.getExpAgency());
        ps.setString(21, fgexpmbisb.getAdcode());
        java.time.LocalDateTime val22 = fgexpmbisb.getLeodate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        java.math.BigDecimal val23 = fgexpmbisb.getOsPeriod();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgexpmbisb.getAdBillNo());
        ps.setString(25, fgexpmbisb.getSbStatus());
        java.math.BigDecimal val26 = fgexpmbisb.getInvSlNo();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgexpmbisb.getInvNo());
        ps.setString(28, fgexpmbisb.getPortcode());
        ps.setString(29, fgexpmbisb.getExpType());
        java.time.LocalDateTime val30 = fgexpmbisb.getInvDate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        ps.setString(31, fgexpmbisb.getInvStatus());
        java.math.BigDecimal val32 = fgexpmbisb.getFobAmt();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        ps.setString(33, fgexpmbisb.getFobcurrcode());
        java.math.BigDecimal val34 = fgexpmbisb.getUtilFobAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        java.math.BigDecimal val35 = fgexpmbisb.getFrieghtAmt();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        ps.setString(36, fgexpmbisb.getFrieghtcurrcode());
        java.math.BigDecimal val37 = fgexpmbisb.getUtilFrieghtAmt();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = fgexpmbisb.getInsAmt();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgexpmbisb.getInscurrcode());
        java.math.BigDecimal val40 = fgexpmbisb.getUtilInsAmt();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgexpmbisb.getHsCode());
        ps.setString(42, fgexpmbisb.getGoodDesc());
        ps.setString(43, fgexpmbisb.getPortOfDest());
        ps.setString(44, fgexpmbisb.getTransportDocNo());
        ps.setString(45, fgexpmbisb.getBillNo());
        java.math.BigDecimal val46 = fgexpmbisb.getSbAmount();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = fgexpmbisb.getSbOsAmt();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = fgexpmbisb.getTotalSettledAmt();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        java.math.BigDecimal val49 = fgexpmbisb.getBillUtilAmt();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = fgexpmbisb.getBillAmt();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        Integer val51 = fgexpmbisb.getParentRefID();
        if (val51 != null) {
            ps.setInt(51, val51);
        } else {
            ps.setNull(51, Types.INTEGER);
        }
        Integer val52 = fgexpmbisb.getParentVersionID();
        if (val52 != null) {
            ps.setInt(52, val52);
        } else {
            ps.setNull(52, Types.INTEGER);
        }
        java.math.BigDecimal val53 = fgexpmbisb.getSbShortfall();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        ps.setString(54, fgexpmbisb.getSbReason());
        java.math.BigDecimal val55 = fgexpmbisb.getEndorsedAmt();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, fgexpmbisb.getBillType());
    }

    private FgExpMbiSb extract(ResultSet rs) throws SQLException {
        FgExpMbiSb fgexpmbisb = new FgExpMbiSb();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgexpmbisb.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgexpmbisb.setReferenceID(REFERENCE_ID);
        fgexpmbisb.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgexpmbisb.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgexpmbisb.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgexpmbisb.setStageCode(rs.getString(COL_STAGE_CODE));
        fgexpmbisb.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgexpmbisb.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgexpmbisb.setCreatedBy(CREATED_BY);
        fgexpmbisb.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgexpmbisb.setLastUpdatedBy(LAST_UPDATED_BY);
        fgexpmbisb.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgexpmbisb.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgexpmbisb.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgexpmbisb.setIsTemplate(IS_TEMPLATE);
        fgexpmbisb.setShipbillno(rs.getString(COL_SHIPBILLNO));
        Timestamp SHIPBILLDATE = rs.getTimestamp(COL_SHIPBILLDATE);
        if (SHIPBILLDATE != null)
            fgexpmbisb.setShipbilldate(SHIPBILLDATE.toLocalDateTime());
        fgexpmbisb.setFormno(rs.getString(COL_FORMNO));
        fgexpmbisb.setIeCode(rs.getString(COL_IE_CODE));
        fgexpmbisb.setExpAgency(rs.getString(COL_EXP_AGENCY));
        fgexpmbisb.setAdcode(rs.getString(COL_ADCODE));
        Timestamp LEODATE = rs.getTimestamp(COL_LEODATE);
        if (LEODATE != null)
            fgexpmbisb.setLeodate(LEODATE.toLocalDateTime());
        java.math.BigDecimal OS_PERIOD = rs.getObject(COL_OS_PERIOD, java.math.BigDecimal.class);
        fgexpmbisb.setOsPeriod(OS_PERIOD);
        fgexpmbisb.setAdBillNo(rs.getString(COL_AD_BILL_NO));
        fgexpmbisb.setSbStatus(rs.getString(COL_SB_STATUS));
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        fgexpmbisb.setInvSlNo(INV_SL_NO);
        fgexpmbisb.setInvNo(rs.getString(COL_INV_NO));
        fgexpmbisb.setPortcode(rs.getString(COL_PORTCODE));
        fgexpmbisb.setExpType(rs.getString(COL_EXP_TYPE));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgexpmbisb.setInvDate(INV_DATE.toLocalDateTime());
        fgexpmbisb.setInvStatus(rs.getString(COL_INV_STATUS));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setFobAmt(FOB_AMT);
        fgexpmbisb.setFobcurrcode(rs.getString(COL_FOBCURRCODE));
        java.math.BigDecimal UTIL_FOB_AMT = rs.getObject(COL_UTIL_FOB_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setUtilFobAmt(UTIL_FOB_AMT);
        java.math.BigDecimal FRIEGHT_AMT = rs.getObject(COL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setFrieghtAmt(FRIEGHT_AMT);
        fgexpmbisb.setFrieghtcurrcode(rs.getString(COL_FRIEGHTCURRCODE));
        java.math.BigDecimal UTIL_FRIEGHT_AMT = rs.getObject(COL_UTIL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setUtilFrieghtAmt(UTIL_FRIEGHT_AMT);
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setInsAmt(INS_AMT);
        fgexpmbisb.setInscurrcode(rs.getString(COL_INSCURRCODE));
        java.math.BigDecimal UTIL_INS_AMT = rs.getObject(COL_UTIL_INS_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setUtilInsAmt(UTIL_INS_AMT);
        fgexpmbisb.setHsCode(rs.getString(COL_HS_CODE));
        fgexpmbisb.setGoodDesc(rs.getString(COL_GOOD_DESC));
        fgexpmbisb.setPortOfDest(rs.getString(COL_PORT_OF_DEST));
        fgexpmbisb.setTransportDocNo(rs.getString(COL_TRANSPORT_DOC_NO));
        fgexpmbisb.setBillNo(rs.getString(COL_BILL_NO));
        java.math.BigDecimal SB_AMOUNT = rs.getObject(COL_SB_AMOUNT, java.math.BigDecimal.class);
        fgexpmbisb.setSbAmount(SB_AMOUNT);
        java.math.BigDecimal SB_OS_AMT = rs.getObject(COL_SB_OS_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setSbOsAmt(SB_OS_AMT);
        java.math.BigDecimal TOTAL_SETTLED_AMT = rs.getObject(COL_TOTAL_SETTLED_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setTotalSettledAmt(TOTAL_SETTLED_AMT);
        java.math.BigDecimal BILL_UTIL_AMT = rs.getObject(COL_BILL_UTIL_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setBillUtilAmt(BILL_UTIL_AMT);
        java.math.BigDecimal BILL_AMT = rs.getObject(COL_BILL_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setBillAmt(BILL_AMT);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgexpmbisb.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgexpmbisb.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal SB_SHORTFALL = rs.getObject(COL_SB_SHORTFALL, java.math.BigDecimal.class);
        fgexpmbisb.setSbShortfall(SB_SHORTFALL);
        fgexpmbisb.setSbReason(rs.getString(COL_SB_REASON));
        java.math.BigDecimal ENDORSED_AMT = rs.getObject(COL_ENDORSED_AMT, java.math.BigDecimal.class);
        fgexpmbisb.setEndorsedAmt(ENDORSED_AMT);
        fgexpmbisb.setBillType(rs.getString(COL_BILL_TYPE));
        return fgexpmbisb;
    }
}
