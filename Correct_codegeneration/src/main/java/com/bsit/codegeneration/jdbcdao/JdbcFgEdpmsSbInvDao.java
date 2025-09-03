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

public class JdbcFgEdpmsSbInvDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEdpmsSbInvDao.class);

    private static final String TABLE = "FG_EDPMS_SB_INV";

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

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_FOBCURRCODE = "FOBCURRCODE";

    private static final String COL_FOB_AMT = "FOB_AMT";

    private static final String COL_FRIEGHTCURRCODE = "FRIEGHTCURRCODE";

    private static final String COL_FRIEGHT_AMT = "FRIEGHT_AMT";

    private static final String COL_INSCURRCODE = "INSCURRCODE";

    private static final String COL_INS_AMT = "INS_AMT";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_BILL_NO, COL_SHIPBILLNO, COL_FORMNO, COL_INV_SL_NO, COL_INV_NO, COL_INV_DATE, COL_FOBCURRCODE, COL_FOB_AMT, COL_FRIEGHTCURRCODE, COL_FRIEGHT_AMT, COL_INSCURRCODE, COL_INS_AMT, COL_IE_CODE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_SL_NO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, IE_CODE, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_SL_NO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, IE_CODE, PARENT_REF_ID, PARENT_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_BILL_NO, COL_SHIPBILLNO, COL_FORMNO, COL_INV_SL_NO, COL_INV_NO, COL_INV_DATE, COL_FOBCURRCODE, COL_FOB_AMT, COL_FRIEGHTCURRCODE, COL_FRIEGHT_AMT, COL_INSCURRCODE, COL_INS_AMT, COL_IE_CODE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgEdpmsSbInv fgedpmssbinv) throws SQLException {
        logger.debug("Inserting fgedpmssbinv: {}", fgedpmssbinv);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEdpmsSbInvParams(ps, fgedpmssbinv);
            ps.executeUpdate();
            return fgedpmssbinv.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEdpmsSbInv> fgedpmssbinvs) throws SQLException {
        if (fgedpmssbinvs == null || fgedpmssbinvs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgedpmssbinvs.size(); i++) {
            if (fgedpmssbinvs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsSbInv>> batches = chunkList(fgedpmssbinvs, batchSize);
        int[] totalResults = new int[fgedpmssbinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsSbInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEdpmsSbInv fgedpmssbinv : batch) {
                        setFgEdpmsSbInvParams(ps, fgedpmssbinv);
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

    public FgEdpmsSbInv findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEdpmsSbInv> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEdpmsSbInv> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEdpmsSbInv fgedpmssbinv) throws SQLException {
        if (fgedpmssbinv.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEdpmsSbInvParams(ps, fgedpmssbinv);
            ps.setInt(33, fgedpmssbinv.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEdpmsSbInv> fgedpmssbinvs) throws SQLException {
        if (fgedpmssbinvs == null || fgedpmssbinvs.isEmpty())
            return new int[0];
        for (FgEdpmsSbInv fgedpmssbinv : fgedpmssbinvs) {
            if (fgedpmssbinv == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgedpmssbinv.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsSbInv>> batches = chunkList(fgedpmssbinvs, batchSize);
        int[] totalResults = new int[fgedpmssbinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsSbInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEdpmsSbInv fgedpmssbinv : batch) {
                        setFgEdpmsSbInvParams(ps, fgedpmssbinv);
                        ps.setInt(33, fgedpmssbinv.getID());
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

    private void setFgEdpmsSbInvParams(PreparedStatement ps, FgEdpmsSbInv fgedpmssbinv) throws SQLException {
        Integer val1 = fgedpmssbinv.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgedpmssbinv.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgedpmssbinv.getTypeCode());
        ps.setString(4, fgedpmssbinv.getSubTypeCode());
        ps.setString(5, fgedpmssbinv.getActiveCode());
        ps.setString(6, fgedpmssbinv.getStageCode());
        ps.setString(7, fgedpmssbinv.getStatusCode());
        Integer val8 = fgedpmssbinv.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgedpmssbinv.getCreatedOn());
        java.math.BigDecimal val10 = fgedpmssbinv.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgedpmssbinv.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgedpmssbinv.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgedpmssbinv.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgedpmssbinv.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgedpmssbinv.getTemplate());
        ps.setString(16, fgedpmssbinv.getApplicantParty());
        ps.setString(17, fgedpmssbinv.getFulfillmentParty());
        java.math.BigDecimal val18 = fgedpmssbinv.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgedpmssbinv.getBillNo());
        ps.setString(20, fgedpmssbinv.getShipbillno());
        ps.setString(21, fgedpmssbinv.getFormno());
        ps.setString(22, fgedpmssbinv.getInvSlNo());
        ps.setString(23, fgedpmssbinv.getInvNo());
        java.time.LocalDateTime val24 = fgedpmssbinv.getInvDate();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        ps.setString(25, fgedpmssbinv.getFobcurrcode());
        java.math.BigDecimal val26 = fgedpmssbinv.getFobAmt();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgedpmssbinv.getFrieghtcurrcode());
        java.math.BigDecimal val28 = fgedpmssbinv.getFrieghtAmt();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, fgedpmssbinv.getInscurrcode());
        java.math.BigDecimal val30 = fgedpmssbinv.getInsAmt();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, fgedpmssbinv.getIeCode());
        Integer val32 = fgedpmssbinv.getParentRefID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        Integer val33 = fgedpmssbinv.getParentVersionID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
    }

    private FgEdpmsSbInv extract(ResultSet rs) throws SQLException {
        FgEdpmsSbInv fgedpmssbinv = new FgEdpmsSbInv();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgedpmssbinv.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgedpmssbinv.setReferenceID(REFERENCE_ID);
        fgedpmssbinv.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgedpmssbinv.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgedpmssbinv.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgedpmssbinv.setStageCode(rs.getString(COL_STAGE_CODE));
        fgedpmssbinv.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgedpmssbinv.setProcessID(PROCESS_ID);
        fgedpmssbinv.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgedpmssbinv.setCreatedBy(CREATED_BY);
        fgedpmssbinv.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgedpmssbinv.setLastUpdatedBy(LAST_UPDATED_BY);
        fgedpmssbinv.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgedpmssbinv.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgedpmssbinv.setTemplate(rs.getString(COL_TEMPLATE));
        fgedpmssbinv.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgedpmssbinv.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgedpmssbinv.setIsTemplate(IS_TEMPLATE);
        fgedpmssbinv.setBillNo(rs.getString(COL_BILL_NO));
        fgedpmssbinv.setShipbillno(rs.getString(COL_SHIPBILLNO));
        fgedpmssbinv.setFormno(rs.getString(COL_FORMNO));
        fgedpmssbinv.setInvSlNo(rs.getString(COL_INV_SL_NO));
        fgedpmssbinv.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgedpmssbinv.setInvDate(INV_DATE.toLocalDateTime());
        fgedpmssbinv.setFobcurrcode(rs.getString(COL_FOBCURRCODE));
        java.math.BigDecimal FOB_AMT = rs.getObject(COL_FOB_AMT, java.math.BigDecimal.class);
        fgedpmssbinv.setFobAmt(FOB_AMT);
        fgedpmssbinv.setFrieghtcurrcode(rs.getString(COL_FRIEGHTCURRCODE));
        java.math.BigDecimal FRIEGHT_AMT = rs.getObject(COL_FRIEGHT_AMT, java.math.BigDecimal.class);
        fgedpmssbinv.setFrieghtAmt(FRIEGHT_AMT);
        fgedpmssbinv.setInscurrcode(rs.getString(COL_INSCURRCODE));
        java.math.BigDecimal INS_AMT = rs.getObject(COL_INS_AMT, java.math.BigDecimal.class);
        fgedpmssbinv.setInsAmt(INS_AMT);
        fgedpmssbinv.setIeCode(rs.getString(COL_IE_CODE));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgedpmssbinv.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgedpmssbinv.setParentVersionID(PARENT_VERSION_ID);
        return fgedpmssbinv;
    }
}
