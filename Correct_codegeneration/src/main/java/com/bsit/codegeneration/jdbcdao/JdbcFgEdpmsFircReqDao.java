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

public class JdbcFgEdpmsFircReqDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgEdpmsFircReqDao.class);

    private static final String TABLE = "FG_EDPMS_FIRC_REQ";

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

    private static final String COL_IRM_NUMBER = "IRM_NUMBER";

    private static final String COL_REMITTANCE_DATE = "REMITTANCE_DATE";

    private static final String COL_IRM_CCY = "IRM_CCY";

    private static final String COL_IRM_AMT = "IRM_AMT";

    private static final String COL_IRM_UTIL_AMT = "IRM_UTIL_AMT";

    private static final String COL_IRM_OS_AMT = "IRM_OS_AMT";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMIT_BANK_COUNTRY = "REMIT_BANK_COUNTRY";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_FIRC_AMT = "FIRC_AMT";

    private static final String COL_FIRC_NUMBER = "FIRC_NUMBER";

    private static final String COL_FINAL_ERROR_DESC = "FINAL_ERROR_DESC";

    private static final String COL_FINAL_STATUS = "FINAL_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NUMBER, COL_REMITTANCE_DATE, COL_IRM_CCY, COL_IRM_AMT, COL_IRM_UTIL_AMT, COL_IRM_OS_AMT, COL_IE_CODE, COL_AD_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_FIRC_AMT, COL_FIRC_NUMBER, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NUMBER, REMITTANCE_DATE, IRM_CCY, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IE_CODE, AD_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PARENT_REF_ID, PARENT_VERSION_ID, FIRC_AMT, FIRC_NUMBER, FINAL_ERROR_DESC, FINAL_STATUS", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NUMBER, REMITTANCE_DATE, IRM_CCY, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IE_CODE, AD_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PARENT_REF_ID, PARENT_VERSION_ID, FIRC_AMT, FIRC_NUMBER, FINAL_ERROR_DESC, FINAL_STATUS", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_IRM_NUMBER, COL_REMITTANCE_DATE, COL_IRM_CCY, COL_IRM_AMT, COL_IRM_UTIL_AMT, COL_IRM_OS_AMT, COL_IE_CODE, COL_AD_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMIT_BANK_COUNTRY, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_FIRC_AMT, COL_FIRC_NUMBER, COL_FINAL_ERROR_DESC, COL_FINAL_STATUS, COL_ID);

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

    public int insert(Connection conn, FgEdpmsFircReq fgedpmsfircreq) throws SQLException {
        logger.debug("Inserting fgedpmsfircreq: {}", fgedpmsfircreq);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgEdpmsFircReqParams(ps, fgedpmsfircreq);
            ps.executeUpdate();
            return fgedpmsfircreq.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgEdpmsFircReq> fgedpmsfircreqs) throws SQLException {
        if (fgedpmsfircreqs == null || fgedpmsfircreqs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgedpmsfircreqs.size(); i++) {
            if (fgedpmsfircreqs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsFircReq>> batches = chunkList(fgedpmsfircreqs, batchSize);
        int[] totalResults = new int[fgedpmsfircreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsFircReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgEdpmsFircReq fgedpmsfircreq : batch) {
                        setFgEdpmsFircReqParams(ps, fgedpmsfircreq);
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

    public FgEdpmsFircReq findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgEdpmsFircReq> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgEdpmsFircReq> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgEdpmsFircReq fgedpmsfircreq) throws SQLException {
        if (fgedpmsfircreq.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgEdpmsFircReqParams(ps, fgedpmsfircreq);
            ps.setInt(32, fgedpmsfircreq.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgEdpmsFircReq> fgedpmsfircreqs) throws SQLException {
        if (fgedpmsfircreqs == null || fgedpmsfircreqs.isEmpty())
            return new int[0];
        for (FgEdpmsFircReq fgedpmsfircreq : fgedpmsfircreqs) {
            if (fgedpmsfircreq == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgedpmsfircreq.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgEdpmsFircReq>> batches = chunkList(fgedpmsfircreqs, batchSize);
        int[] totalResults = new int[fgedpmsfircreqs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgEdpmsFircReq> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgEdpmsFircReq fgedpmsfircreq : batch) {
                        setFgEdpmsFircReqParams(ps, fgedpmsfircreq);
                        ps.setInt(32, fgedpmsfircreq.getID());
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

    private void setFgEdpmsFircReqParams(PreparedStatement ps, FgEdpmsFircReq fgedpmsfircreq) throws SQLException {
        Integer val1 = fgedpmsfircreq.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgedpmsfircreq.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgedpmsfircreq.getTypeCode());
        ps.setString(4, fgedpmsfircreq.getSubTypeCode());
        ps.setString(5, fgedpmsfircreq.getActiveCode());
        ps.setString(6, fgedpmsfircreq.getStageCode());
        ps.setString(7, fgedpmsfircreq.getStatusCode());
        ps.setString(8, fgedpmsfircreq.getCreatedOn());
        java.math.BigDecimal val9 = fgedpmsfircreq.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgedpmsfircreq.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgedpmsfircreq.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgedpmsfircreq.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgedpmsfircreq.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgedpmsfircreq.getTemplate());
        java.math.BigDecimal val15 = fgedpmsfircreq.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgedpmsfircreq.getIrmNumber());
        java.time.LocalDateTime val17 = fgedpmsfircreq.getRemittanceDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        ps.setString(18, fgedpmsfircreq.getIrmCcy());
        java.math.BigDecimal val19 = fgedpmsfircreq.getIrmAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgedpmsfircreq.getIrmUtilAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        java.math.BigDecimal val21 = fgedpmsfircreq.getIrmOsAmt();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgedpmsfircreq.getIeCode());
        ps.setString(23, fgedpmsfircreq.getAdCode());
        ps.setString(24, fgedpmsfircreq.getRemitterName());
        ps.setString(25, fgedpmsfircreq.getRemitterCountry());
        ps.setString(26, fgedpmsfircreq.getRemitBankCountry());
        Integer val27 = fgedpmsfircreq.getParentRefID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        Integer val28 = fgedpmsfircreq.getParentVersionID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        java.math.BigDecimal val29 = fgedpmsfircreq.getFircAmt();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, fgedpmsfircreq.getFircNumber());
        ps.setString(31, fgedpmsfircreq.getFinalErrorDesc());
        ps.setString(32, fgedpmsfircreq.getFinalStatus());
    }

    private FgEdpmsFircReq extract(ResultSet rs) throws SQLException {
        FgEdpmsFircReq fgedpmsfircreq = new FgEdpmsFircReq();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgedpmsfircreq.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgedpmsfircreq.setReferenceID(REFERENCE_ID);
        fgedpmsfircreq.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgedpmsfircreq.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgedpmsfircreq.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgedpmsfircreq.setStageCode(rs.getString(COL_STAGE_CODE));
        fgedpmsfircreq.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgedpmsfircreq.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgedpmsfircreq.setCreatedBy(CREATED_BY);
        fgedpmsfircreq.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgedpmsfircreq.setLastUpdatedBy(LAST_UPDATED_BY);
        fgedpmsfircreq.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgedpmsfircreq.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgedpmsfircreq.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgedpmsfircreq.setIsTemplate(IS_TEMPLATE);
        fgedpmsfircreq.setIrmNumber(rs.getString(COL_IRM_NUMBER));
        Timestamp REMITTANCE_DATE = rs.getTimestamp(COL_REMITTANCE_DATE);
        if (REMITTANCE_DATE != null)
            fgedpmsfircreq.setRemittanceDate(REMITTANCE_DATE.toLocalDateTime());
        fgedpmsfircreq.setIrmCcy(rs.getString(COL_IRM_CCY));
        java.math.BigDecimal IRM_AMT = rs.getObject(COL_IRM_AMT, java.math.BigDecimal.class);
        fgedpmsfircreq.setIrmAmt(IRM_AMT);
        java.math.BigDecimal IRM_UTIL_AMT = rs.getObject(COL_IRM_UTIL_AMT, java.math.BigDecimal.class);
        fgedpmsfircreq.setIrmUtilAmt(IRM_UTIL_AMT);
        java.math.BigDecimal IRM_OS_AMT = rs.getObject(COL_IRM_OS_AMT, java.math.BigDecimal.class);
        fgedpmsfircreq.setIrmOsAmt(IRM_OS_AMT);
        fgedpmsfircreq.setIeCode(rs.getString(COL_IE_CODE));
        fgedpmsfircreq.setAdCode(rs.getString(COL_AD_CODE));
        fgedpmsfircreq.setRemitterName(rs.getString(COL_REMITTER_NAME));
        fgedpmsfircreq.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        fgedpmsfircreq.setRemitBankCountry(rs.getString(COL_REMIT_BANK_COUNTRY));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgedpmsfircreq.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgedpmsfircreq.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal FIRC_AMT = rs.getObject(COL_FIRC_AMT, java.math.BigDecimal.class);
        fgedpmsfircreq.setFircAmt(FIRC_AMT);
        fgedpmsfircreq.setFircNumber(rs.getString(COL_FIRC_NUMBER));
        fgedpmsfircreq.setFinalErrorDesc(rs.getString(COL_FINAL_ERROR_DESC));
        fgedpmsfircreq.setFinalStatus(rs.getString(COL_FINAL_STATUS));
        return fgedpmsfircreq;
    }
}
