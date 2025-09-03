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

public class JdbcFgExpMbiXarDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgExpMbiXarDao.class);

    private static final String TABLE = "FG_EXP_MBI_XAR";

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

    private static final String COL_IRM_NO = "IRM_NO";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_IRM_UTIL_AMT = "IRM_UTIL_AMT";

    private static final String COL_IRM_OS_AMT = "IRM_OS_AMT";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_IRM_DATE = "IRM_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String COL_REMIT_BANK_NAME = "REMIT_BANK_NAME";

    private static final String COL_XAR_BANK_REF = "XAR_BANK_REF";

    private static final String COL_PURPOSE_OF_REMITTANCE = "PURPOSE_OF_REMITTANCE";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_SETTLED_AMT = "SETTLED_AMT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NO, COL_AD_CODE, COL_IRM_AMT, COL_IRM_UTIL_AMT, COL_IRM_OS_AMT, COL_IRM_CCY, COL_IRM_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_REMIT_BANK_NAME, COL_XAR_BANK_REF, COL_PURPOSE_OF_REMITTANCE, COL_BILL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SETTLED_AMT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, AD_CODE, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IRM_CCY, IRM_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, REMIT_BANK_NAME, XAR_BANK_REF, PURPOSE_OF_REMITTANCE, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, AD_CODE, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IRM_CCY, IRM_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, REMIT_BANK_NAME, XAR_BANK_REF, PURPOSE_OF_REMITTANCE, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NO, COL_AD_CODE, COL_IRM_AMT, COL_IRM_UTIL_AMT, COL_IRM_OS_AMT, COL_IRM_CCY, COL_IRM_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_REMIT_BANK_NAME, COL_XAR_BANK_REF, COL_PURPOSE_OF_REMITTANCE, COL_BILL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SETTLED_AMT, COL_ID);

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

    public int insert(Connection conn, FgExpMbiXar fgexpmbixar) throws SQLException {
        logger.debug("Inserting fgexpmbixar: {}", fgexpmbixar);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgExpMbiXarParams(ps, fgexpmbixar);
            ps.executeUpdate();
            return fgexpmbixar.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgExpMbiXar> fgexpmbixars) throws SQLException {
        if (fgexpmbixars == null || fgexpmbixars.isEmpty())
            return new int[0];
        for (int i = 0; i < fgexpmbixars.size(); i++) {
            if (fgexpmbixars.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiXar>> batches = chunkList(fgexpmbixars, batchSize);
        int[] totalResults = new int[fgexpmbixars.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiXar> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgExpMbiXar fgexpmbixar : batch) {
                        setFgExpMbiXarParams(ps, fgexpmbixar);
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

    public FgExpMbiXar findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgExpMbiXar> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgExpMbiXar> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgExpMbiXar fgexpmbixar) throws SQLException {
        if (fgexpmbixar.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgExpMbiXarParams(ps, fgexpmbixar);
            ps.setInt(34, fgexpmbixar.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgExpMbiXar> fgexpmbixars) throws SQLException {
        if (fgexpmbixars == null || fgexpmbixars.isEmpty())
            return new int[0];
        for (FgExpMbiXar fgexpmbixar : fgexpmbixars) {
            if (fgexpmbixar == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgexpmbixar.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiXar>> batches = chunkList(fgexpmbixars, batchSize);
        int[] totalResults = new int[fgexpmbixars.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiXar> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgExpMbiXar fgexpmbixar : batch) {
                        setFgExpMbiXarParams(ps, fgexpmbixar);
                        ps.setInt(34, fgexpmbixar.getID());
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

    private void setFgExpMbiXarParams(PreparedStatement ps, FgExpMbiXar fgexpmbixar) throws SQLException {
        Integer val1 = fgexpmbixar.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgexpmbixar.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgexpmbixar.getTypeCode());
        ps.setString(4, fgexpmbixar.getSubTypeCode());
        ps.setString(5, fgexpmbixar.getActiveCode());
        ps.setString(6, fgexpmbixar.getStageCode());
        ps.setString(7, fgexpmbixar.getStatusCode());
        Integer val8 = fgexpmbixar.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgexpmbixar.getCreatedOn());
        java.math.BigDecimal val10 = fgexpmbixar.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgexpmbixar.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgexpmbixar.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgexpmbixar.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgexpmbixar.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgexpmbixar.getTemplate());
        java.math.BigDecimal val16 = fgexpmbixar.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgexpmbixar.getIrmNo());
        ps.setString(18, fgexpmbixar.getAdCode());
        java.math.BigDecimal val19 = fgexpmbixar.getIrmAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgexpmbixar.getIrmUtilAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgexpmbixar.getIrmOsAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgexpmbixar.getIrmCcy());
        java.time.LocalDateTime val23 = fgexpmbixar.getIrmDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, fgexpmbixar.getIeCode());
        ps.setString(25, fgexpmbixar.getRemitterName());
        ps.setString(26, fgexpmbixar.getRemitterCountry());
        ps.setString(27, fgexpmbixar.getRemitBankCountry());
        ps.setString(28, fgexpmbixar.getRemitBankName());
        ps.setString(29, fgexpmbixar.getXarBankRef());
        ps.setString(30, fgexpmbixar.getPurposeOfRemittance());
        ps.setString(31, fgexpmbixar.getBillNo());
        Integer val32 = fgexpmbixar.getParentRefID();
        if (val32 != null) {
            ps.setInt(32, val32);
        } else {
            ps.setNull(32, Types.INTEGER);
        }
        Integer val33 = fgexpmbixar.getParentVersionID();
        if (val33 != null) {
            ps.setInt(33, val33);
        } else {
            ps.setNull(33, Types.INTEGER);
        }
        java.math.BigDecimal val34 = fgexpmbixar.getSettledAmt();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
    }

    private FgExpMbiXar extract(ResultSet rs) throws SQLException {
        FgExpMbiXar fgexpmbixar = new FgExpMbiXar();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgexpmbixar.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgexpmbixar.setReferenceID(REFERENCE_ID);
        fgexpmbixar.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgexpmbixar.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgexpmbixar.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgexpmbixar.setStageCode(rs.getString(COL_STAGE_CODE));
        fgexpmbixar.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgexpmbixar.setProcessID(PROCESS_ID);
        fgexpmbixar.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgexpmbixar.setCreatedBy(CREATED_BY);
        fgexpmbixar.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgexpmbixar.setLastUpdatedBy(LAST_UPDATED_BY);
        fgexpmbixar.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgexpmbixar.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgexpmbixar.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgexpmbixar.setIsTemplate(IS_TEMPLATE);
        fgexpmbixar.setIrmNo(rs.getString(COL_IRM_NO));
        fgexpmbixar.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgexpmbixar.setIrmAmt(IRM_AMT);
        java.math.BigDecimal IRM_UTIL_AMT = rs.getObject(COL_IRM_UTIL_AMT, java.math.BigDecimal.class);
        fgexpmbixar.setIrmUtilAmt(IRM_UTIL_AMT);
        java.math.BigDecimal IRM_OS_AMT = rs.getObject(COL_IRM_OS_AMT, java.math.BigDecimal.class);
        fgexpmbixar.setIrmOsAmt(IRM_OS_AMT);
        fgexpmbixar.setIrmCcy(rs.getString(COL_IRM_CCY));
        Timestamp IRM_DATE = rs.getTimestamp(COL_IRM_DATE);
        if (IRM_DATE != null)
            fgexpmbixar.setIrmDate(IRM_DATE.toLocalDateTime());
        fgexpmbixar.setIeCode(rs.getString(COL_IE_CODE));
        fgexpmbixar.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgexpmbixar.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgexpmbixar.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        fgexpmbixar.setRemitBankName(rs.getString(COL_REMIT_BANK_NAME));
        fgexpmbixar.setXarBankRef(rs.getString(COL_XAR_BANK_REF));
        fgexpmbixar.setPurposeOfRemittance(rs.getString(COL_PURPOSE_OF_REMITTANCE));
        fgexpmbixar.setBillNo(rs.getString(COL_BILL_NO));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgexpmbixar.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgexpmbixar.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal SETTLED_AMT = rs.getObject(COL_SETTLED_AMT, java.math.BigDecimal.class);
        fgexpmbixar.setSettledAmt(SETTLED_AMT);
        return fgexpmbixar;
    }
}
