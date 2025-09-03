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

public class JdbcFgModBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModBatchDao.class);

    private static final String TABLE = "FG_MOD_BATCH";

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

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_COMMENTS = "COMMENTS";

    private static final String COL_PURPOSE_CODE = "PURPOSE_CODE";

    private static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    private static final String COL_TOTAL_COUNT = "TOTAL_COUNT";

    private static final String COL_SOURCE_REF_ID = "SOURCE_REF_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_FINANCE_DISPLAY_STATUS = "FINANCE_DISPLAY_STATUS";

    private static final String COL_PROGRAM_CODE = "PROGRAM_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PROCESS_ID, COL_COMMENTS, COL_PURPOSE_CODE, COL_TOTAL_AMOUNT, COL_TOTAL_COUNT, COL_SOURCE_REF_ID, COL_APPLICANT_PARTY_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, COMMENTS, PURPOSE_CODE, TOTAL_AMOUNT, TOTAL_COUNT, SOURCE_REF_ID, APPLICANT_PARTY_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, COMMENTS, PURPOSE_CODE, TOTAL_AMOUNT, TOTAL_COUNT, SOURCE_REF_ID, APPLICANT_PARTY_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_PROCESS_ID, COL_COMMENTS, COL_PURPOSE_CODE, COL_TOTAL_AMOUNT, COL_TOTAL_COUNT, COL_SOURCE_REF_ID, COL_APPLICANT_PARTY_CODE, COL_FINANCE_DISPLAY_STATUS, COL_PROGRAM_CODE, COL_ID);

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

    public int insert(Connection conn, FgModBatch fgmodbatch) throws SQLException {
        logger.debug("Inserting fgmodbatch: {}", fgmodbatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModBatchParams(ps, fgmodbatch);
            ps.executeUpdate();
            return fgmodbatch.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModBatch> fgmodbatchs) throws SQLException {
        if (fgmodbatchs == null || fgmodbatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodbatchs.size(); i++) {
            if (fgmodbatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModBatch>> batches = chunkList(fgmodbatchs, batchSize);
        int[] totalResults = new int[fgmodbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModBatch fgmodbatch : batch) {
                        setFgModBatchParams(ps, fgmodbatch);
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

    public FgModBatch findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModBatch fgmodbatch) throws SQLException {
        if (fgmodbatch.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModBatchParams(ps, fgmodbatch);
            ps.setInt(26, fgmodbatch.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModBatch> fgmodbatchs) throws SQLException {
        if (fgmodbatchs == null || fgmodbatchs.isEmpty())
            return new int[0];
        for (FgModBatch fgmodbatch : fgmodbatchs) {
            if (fgmodbatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodbatch.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModBatch>> batches = chunkList(fgmodbatchs, batchSize);
        int[] totalResults = new int[fgmodbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModBatch fgmodbatch : batch) {
                        setFgModBatchParams(ps, fgmodbatch);
                        ps.setInt(26, fgmodbatch.getID());
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

    private void setFgModBatchParams(PreparedStatement ps, FgModBatch fgmodbatch) throws SQLException {
        Integer val1 = fgmodbatch.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodbatch.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodbatch.getTypeCode());
        ps.setString(4, fgmodbatch.getSubTypeCode());
        ps.setString(5, fgmodbatch.getActiveCode());
        ps.setString(6, fgmodbatch.getStageCode());
        ps.setString(7, fgmodbatch.getStatusCode());
        ps.setString(8, fgmodbatch.getCreatedOn());
        java.math.BigDecimal val9 = fgmodbatch.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodbatch.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmodbatch.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmodbatch.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgmodbatch.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgmodbatch.getTemplate());
        java.math.BigDecimal val15 = fgmodbatch.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        Integer val16 = fgmodbatch.getVersionID();
        if (val16 != null) {
            ps.setInt(16, val16);
        } else {
            ps.setNull(16, Types.INTEGER);
        }
        java.math.BigDecimal val17 = fgmodbatch.getIsMasterVersion();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        Integer val18 = fgmodbatch.getProcessID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        ps.setString(19, fgmodbatch.getComments());
        ps.setString(20, fgmodbatch.getPurposeCode());
        java.math.BigDecimal val21 = fgmodbatch.getTotalAmount();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = fgmodbatch.getTotalCount();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        Integer val23 = fgmodbatch.getSourceRefID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, fgmodbatch.getApplicantPartyCode());
        ps.setString(25, fgmodbatch.getFinanceDisplayStatus());
        ps.setString(26, fgmodbatch.getProgramCode());
    }

    private FgModBatch extract(ResultSet rs) throws SQLException {
        FgModBatch fgmodbatch = new FgModBatch();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodbatch.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodbatch.setReferenceID(REFERENCE_ID);
        fgmodbatch.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodbatch.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmodbatch.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodbatch.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmodbatch.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodbatch.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodbatch.setCreatedBy(CREATED_BY);
        fgmodbatch.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodbatch.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodbatch.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodbatch.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodbatch.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgmodbatch.setIsTemplate(IS_TEMPLATE);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodbatch.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodbatch.setIsMasterVersion(IS_MASTER_VERSION);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgmodbatch.setProcessID(PROCESS_ID);
        fgmodbatch.setComments(rs.getString(COL_COMMENTS));
        fgmodbatch.setPurposeCode(rs.getString(COL_PURPOSE_CODE));
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgmodbatch.setTotalAmount(TOTAL_AMOUNT);
        java.math.BigDecimal TOTAL_COUNT = rs.getObject(COL_TOTAL_COUNT, java.math.BigDecimal.class);
        fgmodbatch.setTotalCount(TOTAL_COUNT);
        Integer SOURCE_REF_ID = rs.getObject(COL_SOURCE_REF_ID, Integer.class);
        fgmodbatch.setSourceRefID(SOURCE_REF_ID);
        fgmodbatch.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        fgmodbatch.setFinanceDisplayStatus(rs.getString(COL_FINANCE_DISPLAY_STATUS));
        fgmodbatch.setProgramCode(rs.getString(COL_PROGRAM_CODE));
        return fgmodbatch;
    }
}
