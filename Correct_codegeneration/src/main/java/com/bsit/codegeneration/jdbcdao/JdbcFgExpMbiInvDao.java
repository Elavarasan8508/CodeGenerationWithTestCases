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

public class JdbcFgExpMbiInvDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgExpMbiInvDao.class);

    private static final String TABLE = "FG_EXP_MBI_INV";

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

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_FOBCURRCODE = "FOBCURRCODE";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_FRIEGHTCURRCODE = "FRIEGHTCURRCODE";

    private static final String COL_FRIEGHT_AMT = "FRIEGHT_AMT";

    private static final String COL_INSCURRCODE = "INSCURRCODE";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_UTIL_FOB_AMT = "UTIL_FOB_AMT";

    private static final String COL_UTIL_FRIEGHT_AMT = "UTIL_FRIEGHT_AMT";

    private static final String COL_UTIL_INS_AMT = "UTIL_INS_AMT";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BILL_NO, COL_SHIPBILLNO, COL_FORMNO, COL_INV_NO, COL_INV_DATE, COL_FOBCURRCODE, COL_FOB_AMT, COL_FRIEGHTCURRCODE, COL_FRIEGHT_AMT, COL_INSCURRCODE, COL_INS_AMT, COL_UTIL_FOB_AMT, COL_UTIL_FRIEGHT_AMT, COL_UTIL_INS_AMT, COL_INV_SL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, UTIL_FOB_AMT, UTIL_FRIEGHT_AMT, UTIL_INS_AMT, INV_SL_NO, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, UTIL_FOB_AMT, UTIL_FRIEGHT_AMT, UTIL_INS_AMT, INV_SL_NO, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_BILL_NO, COL_SHIPBILLNO, COL_FORMNO, COL_INV_NO, COL_INV_DATE, COL_FOBCURRCODE, COL_FOB_AMT, COL_FRIEGHTCURRCODE, COL_FRIEGHT_AMT, COL_INSCURRCODE, COL_INS_AMT, COL_UTIL_FOB_AMT, COL_UTIL_FRIEGHT_AMT, COL_UTIL_INS_AMT, COL_INV_SL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgExpMbiInv fgexpmbiinv) throws SQLException {
        logger.debug("Inserting fgexpmbiinv: {}", fgexpmbiinv);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgExpMbiInvParams(ps, fgexpmbiinv);
            ps.executeUpdate();
            return fgexpmbiinv.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgExpMbiInv> fgexpmbiinvs) throws SQLException {
        if (fgexpmbiinvs == null || fgexpmbiinvs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgexpmbiinvs.size(); i++) {
            if (fgexpmbiinvs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiInv>> batches = chunkList(fgexpmbiinvs, batchSize);
        int[] totalResults = new int[fgexpmbiinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgExpMbiInv fgexpmbiinv : batch) {
                        setFgExpMbiInvParams(ps, fgexpmbiinv);
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

    public FgExpMbiInv findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgExpMbiInv> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgExpMbiInv> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgExpMbiInv fgexpmbiinv) throws SQLException {
        if (fgexpmbiinv.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgExpMbiInvParams(ps, fgexpmbiinv);
            ps.setInt(33, fgexpmbiinv.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgExpMbiInv> fgexpmbiinvs) throws SQLException {
        if (fgexpmbiinvs == null || fgexpmbiinvs.isEmpty())
            return new int[0];
        for (FgExpMbiInv fgexpmbiinv : fgexpmbiinvs) {
            if (fgexpmbiinv == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgexpmbiinv.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiInv>> batches = chunkList(fgexpmbiinvs, batchSize);
        int[] totalResults = new int[fgexpmbiinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgExpMbiInv fgexpmbiinv : batch) {
                        setFgExpMbiInvParams(ps, fgexpmbiinv);
                        ps.setInt(33, fgexpmbiinv.getID());
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

    private void setFgExpMbiInvParams(PreparedStatement ps, FgExpMbiInv fgexpmbiinv) throws SQLException {
        Integer val1 = fgexpmbiinv.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgexpmbiinv.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgexpmbiinv.getTypeCode());
        ps.setString(4, fgexpmbiinv.getSubTypeCode());
        ps.setString(5, fgexpmbiinv.getActiveCode());
        ps.setString(6, fgexpmbiinv.getStageCode());
        ps.setString(7, fgexpmbiinv.getStatusCode());
        Integer val8 = fgexpmbiinv.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgexpmbiinv.getCreatedOn());
        java.math.BigDecimal val10 = fgexpmbiinv.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgexpmbiinv.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgexpmbiinv.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgexpmbiinv.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgexpmbiinv.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgexpmbiinv.getTemplate());
        java.math.BigDecimal val16 = fgexpmbiinv.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgexpmbiinv.getBillNo());
        ps.setString(18, fgexpmbiinv.getShipbillno());
        ps.setString(19, fgexpmbiinv.getFormno());
        ps.setString(20, fgexpmbiinv.getInvNo());
        java.time.LocalDateTime val21 = fgexpmbiinv.getInvDate();
        if (val21 != null) {
            ps.setTimestamp(21, java.sql.Timestamp.valueOf(val21));
        } else {
            ps.setNull(21, Types.TIMESTAMP);
        }
        ps.setString(22, fgexpmbiinv.getFobcurrcode());
        java.math.BigDecimal val23 = fgexpmbiinv.getFobAmt();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, fgexpmbiinv.getFrieghtcurrcode());
        java.math.BigDecimal val25 = fgexpmbiinv.getFrieghtAmt();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgexpmbiinv.getInscurrcode());
        java.math.BigDecimal val27 = fgexpmbiinv.getInsAmt();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        java.math.BigDecimal val28 = fgexpmbiinv.getUtilFobAmt();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        java.math.BigDecimal val29 = fgexpmbiinv.getUtilFrieghtAmt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = fgexpmbiinv.getUtilInsAmt();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgexpmbiinv.getInvSlNo());
        Integer val32 = fgexpmbiinv.getParentRefID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        Integer val33 = fgexpmbiinv.getParentVersionID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
    }

    private FgExpMbiInv extract(ResultSet rs) throws SQLException {
        FgExpMbiInv fgexpmbiinv = new FgExpMbiInv();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgexpmbiinv.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgexpmbiinv.setReferenceID(REFERENCE_ID);
        fgexpmbiinv.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgexpmbiinv.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgexpmbiinv.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgexpmbiinv.setStageCode(rs.getString(COL_STAGE_CODE));
        fgexpmbiinv.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgexpmbiinv.setProcessID(PROCESS_ID);
        fgexpmbiinv.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgexpmbiinv.setCreatedBy(CREATED_BY);
        fgexpmbiinv.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgexpmbiinv.setLastUpdatedBy(LAST_UPDATED_BY);
        fgexpmbiinv.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgexpmbiinv.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgexpmbiinv.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgexpmbiinv.setIsTemplate(IS_TEMPLATE);
        fgexpmbiinv.setBillNo(rs.getString(COL_BILL_NO));
        fgexpmbiinv.setShipbillno(rs.getString(COL_SHIPBILLNO));
        fgexpmbiinv.setFormno(rs.getString(COL_FORMNO));
        fgexpmbiinv.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgexpmbiinv.setInvDate(INV_DATE.toLocalDateTime());
        fgexpmbiinv.setFobcurrcode(rs.getString(COL_FOBCURRCODE));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setFobAmt(FOB_AMT);
        fgexpmbiinv.setFrieghtcurrcode(rs.getString(COL_FRIEGHTCURRCODE));
        java.math.BigDecimal FRIEGHT_AMT = rs.getObject(COL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setFrieghtAmt(FRIEGHT_AMT);
        fgexpmbiinv.setInscurrcode(rs.getString(COL_INSCURRCODE));
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setInsAmt(INS_AMT);
        java.math.BigDecimal UTIL_FOB_AMT = rs.getObject(COL_UTIL_FOB_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setUtilFobAmt(UTIL_FOB_AMT);
        java.math.BigDecimal UTIL_FRIEGHT_AMT = rs.getObject(COL_UTIL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setUtilFrieghtAmt(UTIL_FRIEGHT_AMT);
        java.math.BigDecimal UTIL_INS_AMT = rs.getObject(COL_UTIL_INS_AMT, java.math.BigDecimal.class);
        fgexpmbiinv.setUtilInsAmt(UTIL_INS_AMT);
        fgexpmbiinv.setInvSlNo(rs.getString(COL_INV_SL_NO));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgexpmbiinv.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgexpmbiinv.setParentVersionID(PARENT_VERSION_ID);
        return fgexpmbiinv;
    }
}
