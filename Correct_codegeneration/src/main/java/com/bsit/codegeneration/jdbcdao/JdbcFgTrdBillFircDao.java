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

public class JdbcFgTrdBillFircDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTrdBillFircDao.class);

    private static final String TABLE = "FG_TRD_BILL_FIRC";

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

    private static final String COL_FIRC_NO = "FIRC_NO";

    private static final String COL_FIRC_DATE = "FIRC_DATE";

    private static final String COL_FIRC_CCY = "FIRC_CCY";

    private static final String COL_FIRC_AMT = "FIRC_AMT";

    private static final String COL_FIRC_UTIL_AMT = "FIRC_UTIL_AMT";

    private static final String COL_FIRC_OS_AMT = "FIRC_OS_AMT";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FIRC_NO, COL_FIRC_DATE, COL_FIRC_CCY, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_AD_CODE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NO, FIRC_DATE, FIRC_CCY, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, AD_CODE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NO, FIRC_DATE, FIRC_CCY, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, AD_CODE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_FIRC_NO, COL_FIRC_DATE, COL_FIRC_CCY, COL_FIRC_AMT, COL_FIRC_UTIL_AMT, COL_FIRC_OS_AMT, COL_AD_CODE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_ID);

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

    public int insert(Connection conn, FgTrdBillFirc fgtrdbillfirc) throws SQLException {
        logger.debug("Inserting fgtrdbillfirc: {}", fgtrdbillfirc);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTrdBillFircParams(ps, fgtrdbillfirc);
            ps.executeUpdate();
            return fgtrdbillfirc.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTrdBillFirc> fgtrdbillfircs) throws SQLException {
        if (fgtrdbillfircs == null || fgtrdbillfircs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtrdbillfircs.size(); i++) {
            if (fgtrdbillfircs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillFirc>> batches = chunkList(fgtrdbillfircs, batchSize);
        int[] totalResults = new int[fgtrdbillfircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillFirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTrdBillFirc fgtrdbillfirc : batch) {
                        setFgTrdBillFircParams(ps, fgtrdbillfirc);
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

    public FgTrdBillFirc findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTrdBillFirc> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTrdBillFirc> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTrdBillFirc fgtrdbillfirc) throws SQLException {
        if (fgtrdbillfirc.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTrdBillFircParams(ps, fgtrdbillfirc);
            ps.setInt(26, fgtrdbillfirc.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTrdBillFirc> fgtrdbillfircs) throws SQLException {
        if (fgtrdbillfircs == null || fgtrdbillfircs.isEmpty())
            return new int[0];
        for (FgTrdBillFirc fgtrdbillfirc : fgtrdbillfircs) {
            if (fgtrdbillfirc == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtrdbillfirc.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTrdBillFirc>> batches = chunkList(fgtrdbillfircs, batchSize);
        int[] totalResults = new int[fgtrdbillfircs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTrdBillFirc> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTrdBillFirc fgtrdbillfirc : batch) {
                        setFgTrdBillFircParams(ps, fgtrdbillfirc);
                        ps.setInt(26, fgtrdbillfirc.getID());
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

    private void setFgTrdBillFircParams(PreparedStatement ps, FgTrdBillFirc fgtrdbillfirc) throws SQLException {
        Integer val1 = fgtrdbillfirc.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtrdbillfirc.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtrdbillfirc.getTypeCode());
        ps.setString(4, fgtrdbillfirc.getSubTypeCode());
        ps.setString(5, fgtrdbillfirc.getActiveCode());
        ps.setString(6, fgtrdbillfirc.getStageCode());
        ps.setString(7, fgtrdbillfirc.getStatusCode());
        ps.setString(8, fgtrdbillfirc.getCreatedOn());
        java.math.BigDecimal val9 = fgtrdbillfirc.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgtrdbillfirc.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgtrdbillfirc.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgtrdbillfirc.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgtrdbillfirc.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgtrdbillfirc.getTemplate());
        java.math.BigDecimal val15 = fgtrdbillfirc.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgtrdbillfirc.getFircNo());
        java.time.LocalDateTime val17 = fgtrdbillfirc.getFircDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgtrdbillfirc.getFircCcy());
        java.math.BigDecimal val19 = fgtrdbillfirc.getFircAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgtrdbillfirc.getFircUtilAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgtrdbillfirc.getFircOsAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgtrdbillfirc.getAdCode());
        ps.setString(23, fgtrdbillfirc.getIeCode());
        ps.setString(24, fgtrdbillfirc.getRemitterName());
        ps.setString(25, fgtrdbillfirc.getRemitterCountry());
        ps.setString(26, fgtrdbillfirc.getRemitBankCountry());
    }

    private FgTrdBillFirc extract(ResultSet rs) throws SQLException {
        FgTrdBillFirc fgtrdbillfirc = new FgTrdBillFirc();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtrdbillfirc.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtrdbillfirc.setReferenceID(REFERENCE_ID);
        fgtrdbillfirc.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtrdbillfirc.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtrdbillfirc.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtrdbillfirc.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtrdbillfirc.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgtrdbillfirc.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtrdbillfirc.setCreatedBy(CREATED_BY);
        fgtrdbillfirc.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtrdbillfirc.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtrdbillfirc.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtrdbillfirc.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtrdbillfirc.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtrdbillfirc.setIsTemplate(IS_TEMPLATE);
        fgtrdbillfirc.setFircNo(rs.getString(COL_FIRC_NO));
        Timestamp FIRC_DATE = rs.getTimestamp(COL_FIRC_DATE);
        if (FIRC_DATE != null)
            fgtrdbillfirc.setFircDate(FIRC_DATE.toLocalDateTime());
        fgtrdbillfirc.setFircCcy(rs.getString(COL_FIRC_CCY));
        java.math.BigDecimal FIRC_AMT = rs.getObject(COL_FIRC_AMT, java.math.BigDecimal.class);
        fgtrdbillfirc.setFircAmt(FIRC_AMT);
        java.math.BigDecimal FIRC_UTIL_AMT = rs.getObject(COL_FIRC_UTIL_AMT, java.math.BigDecimal.class);
        fgtrdbillfirc.setFircUtilAmt(FIRC_UTIL_AMT);
        java.math.BigDecimal FIRC_OS_AMT = rs.getObject(COL_FIRC_OS_AMT, java.math.BigDecimal.class);
        fgtrdbillfirc.setFircOsAmt(FIRC_OS_AMT);
        fgtrdbillfirc.setAdCode(rs.getString(COL_AD_CODE));
        fgtrdbillfirc.setIeCode(rs.getString(COL_IE_CODE));
        fgtrdbillfirc.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgtrdbillfirc.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgtrdbillfirc.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        return fgtrdbillfirc;
    }
}
