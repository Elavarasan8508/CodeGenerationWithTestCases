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

public class JdbcFgExpMbiFircDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgExpMbiFircDao.class);

    private static final String TABLE = "FG_EXP_MBI_FIRC";

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

    private static final String COL_FIRC_NUMBER = "FIRC_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_FIRC_AMT = "FIRC_AMT";

    private static final String COL_FIRC_UTIL_AMT = "FIRC_UTIL_AMT";

    private static final String COL_FIRC_OS_AMT = "FIRC_OS_AMT";

    private static final String COL_FIRC_CCY = "FIRC_CCY";

    private static final String COL_FIRC_DATE = "FIRC_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_SETTLED_AMT = "SETTLED_AMT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FIRC_NUMBER, COL_AD_CODE, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_FIRC_CCY, COL_FIRC_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_BILL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SETTLED_AMT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FIRC_NUMBER, COL_AD_CODE, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_FIRC_CCY, COL_FIRC_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_BILL_NO, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_SETTLED_AMT, COL_ID);

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

    public int insert(Connection conn, FgExpMbiFirc fgexpmbifirc) throws SQLException {
        logger.debug("Inserting fgexpmbifirc: {}", fgexpmbifirc);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgExpMbiFircParams(ps, fgexpmbifirc);
            ps.executeUpdate();
            return fgexpmbifirc.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgExpMbiFirc> fgexpmbifircs) throws SQLException {
        if (fgexpmbifircs == null || fgexpmbifircs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgexpmbifircs.size(); i++) {
            if (fgexpmbifircs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiFirc>> batches = chunkList(fgexpmbifircs, batchSize);
        int[] totalResults = new int[fgexpmbifircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiFirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgExpMbiFirc fgexpmbifirc : batch) {
                        setFgExpMbiFircParams(ps, fgexpmbifirc);
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

    public FgExpMbiFirc findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgExpMbiFirc> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgExpMbiFirc> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgExpMbiFirc fgexpmbifirc) throws SQLException {
        if (fgexpmbifirc.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgExpMbiFircParams(ps, fgexpmbifirc);
            ps.setInt(31, fgexpmbifirc.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgExpMbiFirc> fgexpmbifircs) throws SQLException {
        if (fgexpmbifircs == null || fgexpmbifircs.isEmpty())
            return new int[0];
        for (FgExpMbiFirc fgexpmbifirc : fgexpmbifircs) {
            if (fgexpmbifirc == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgexpmbifirc.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgExpMbiFirc>> batches = chunkList(fgexpmbifircs, batchSize);
        int[] totalResults = new int[fgexpmbifircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgExpMbiFirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgExpMbiFirc fgexpmbifirc : batch) {
                        setFgExpMbiFircParams(ps, fgexpmbifirc);
                        ps.setInt(31, fgexpmbifirc.getID());
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

    private void setFgExpMbiFircParams(PreparedStatement ps, FgExpMbiFirc fgexpmbifirc) throws SQLException {
        Integer val1 = fgexpmbifirc.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgexpmbifirc.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgexpmbifirc.getTypeCode());
        ps.setString(4, fgexpmbifirc.getSubTypeCode());
        ps.setString(5, fgexpmbifirc.getActiveCode());
        ps.setString(6, fgexpmbifirc.getStageCode());
        ps.setString(7, fgexpmbifirc.getStatusCode());
        Integer val8 = fgexpmbifirc.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgexpmbifirc.getCreatedOn());
        java.math.BigDecimal val10 = fgexpmbifirc.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgexpmbifirc.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgexpmbifirc.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgexpmbifirc.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgexpmbifirc.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgexpmbifirc.getTemplate());
        java.math.BigDecimal val16 = fgexpmbifirc.getIsTemplate();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgexpmbifirc.getFircNumber());
        ps.setString(18, fgexpmbifirc.getAdCode());
        java.math.BigDecimal val19 = fgexpmbifirc.getFircAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgexpmbifirc.getFircUtilAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgexpmbifirc.getFircOsAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgexpmbifirc.getFircCcy());
        java.time.LocalDateTime val23 = fgexpmbifirc.getFircDate();
        if (val23 != null) {
            ps.setTimestamp(23, java.sql.Timestamp.valueOf(val23));
        } else {
            ps.setNull(23, Types.TIMESTAMP);
        }
        ps.setString(24, fgexpmbifirc.getIeCode());
        ps.setString(25, fgexpmbifirc.getRemitterName());
        ps.setString(26, fgexpmbifirc.getRemitterCountry());
        ps.setString(27, fgexpmbifirc.getRemitBankCountry());
        ps.setString(28, fgexpmbifirc.getBillNo());
        Integer val29 = fgexpmbifirc.getParentRefID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        Integer val30 = fgexpmbifirc.getParentVersionID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        java.math.BigDecimal val31 = fgexpmbifirc.getSettledAmt();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
    }

    private FgExpMbiFirc extract(ResultSet rs) throws SQLException {
        FgExpMbiFirc fgexpmbifirc = new FgExpMbiFirc();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgexpmbifirc.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgexpmbifirc.setReferenceID(REFERENCE_ID);
        fgexpmbifirc.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgexpmbifirc.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgexpmbifirc.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgexpmbifirc.setStageCode(rs.getString(COL_STAGE_CODE));
        fgexpmbifirc.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgexpmbifirc.setProcessID(PROCESS_ID);
        fgexpmbifirc.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgexpmbifirc.setCreatedBy(CREATED_BY);
        fgexpmbifirc.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgexpmbifirc.setLastUpdatedBy(LAST_UPDATED_BY);
        fgexpmbifirc.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgexpmbifirc.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgexpmbifirc.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgexpmbifirc.setIsTemplate(IS_TEMPLATE);
        fgexpmbifirc.setFircNumber(rs.getString(COL_FIRC_NUMBER));
        fgexpmbifirc.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal FIRC_AMT = rs.getObject(COL_FIRC_AMT, java.math.BigDecimal.class);
        fgexpmbifirc.setFircAmt(FIRC_AMT);
        java.math.BigDecimal FIRC_UTIL_AMT = rs.getObject(COL_FIRC_UTIL_AMT, java.math.BigDecimal.class);
        fgexpmbifirc.setFircUtilAmt(FIRC_UTIL_AMT);
        java.math.BigDecimal FIRC_OS_AMT = rs.getObject(COL_FIRC_OS_AMT, java.math.BigDecimal.class);
        fgexpmbifirc.setFircOsAmt(FIRC_OS_AMT);
        fgexpmbifirc.setFircCcy(rs.getString(COL_FIRC_CCY));
        Timestamp FIRC_DATE = rs.getTimestamp(COL_FIRC_DATE);
        if (FIRC_DATE != null)
            fgexpmbifirc.setFircDate(FIRC_DATE.toLocalDateTime());
        fgexpmbifirc.setIeCode(rs.getString(COL_IE_CODE));
        fgexpmbifirc.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgexpmbifirc.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgexpmbifirc.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        fgexpmbifirc.setBillNo(rs.getString(COL_BILL_NO));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgexpmbifirc.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgexpmbifirc.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal SETTLED_AMT = rs.getObject(COL_SETTLED_AMT, java.math.BigDecimal.class);
        fgexpmbifirc.setSettledAmt(SETTLED_AMT);
        return fgexpmbifirc;
    }
}
