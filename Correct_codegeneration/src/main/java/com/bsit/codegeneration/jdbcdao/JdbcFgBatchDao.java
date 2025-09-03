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

public class JdbcFgBatchDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgBatchDao.class);

    private static final String TABLE = "FG_BATCH";

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

    private static final String COL_RECORD_IDENTIFIER = "RECORD_IDENTIFIER";

    private static final String COL_TOT_INSTRUMENTS = "TOT_INSTRUMENTS";

    private static final String COL_TOTAL_AMOUNT = "TOTAL_AMOUNT";

    private static final String COL_BATCH_REF_NO = "BATCH_REF_NO";

    private static final String COL_BATCH_DATE = "BATCH_DATE";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_PMNT_HDR_IDENTIFIER = "PMNT_HDR_IDENTIFIER";

    private static final String COL_PMNT_DATE_FOR_FILE = "PMNT_DATE_FOR_FILE";

    private static final String COL_COUNT_OF_INSTRUCTION = "COUNT_OF_INSTRUCTION";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RECORD_IDENTIFIER, COL_TOT_INSTRUMENTS, COL_TOTAL_AMOUNT, COL_BATCH_REF_NO, COL_BATCH_DATE, COL_PRODUCT_CODE, COL_UPLOAD_REF_ID, COL_PMNT_HDR_IDENTIFIER, COL_PMNT_DATE_FOR_FILE, COL_COUNT_OF_INSTRUCTION);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_IDENTIFIER, TOT_INSTRUMENTS, TOTAL_AMOUNT, BATCH_REF_NO, BATCH_DATE, PRODUCT_CODE, UPLOAD_REF_ID, PMNT_HDR_IDENTIFIER, PMNT_DATE_FOR_FILE, COUNT_OF_INSTRUCTION", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_IDENTIFIER, TOT_INSTRUMENTS, TOTAL_AMOUNT, BATCH_REF_NO, BATCH_DATE, PRODUCT_CODE, UPLOAD_REF_ID, PMNT_HDR_IDENTIFIER, PMNT_DATE_FOR_FILE, COUNT_OF_INSTRUCTION", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_RECORD_IDENTIFIER, COL_TOT_INSTRUMENTS, COL_TOTAL_AMOUNT, COL_BATCH_REF_NO, COL_BATCH_DATE, COL_PRODUCT_CODE, COL_UPLOAD_REF_ID, COL_PMNT_HDR_IDENTIFIER, COL_PMNT_DATE_FOR_FILE, COL_COUNT_OF_INSTRUCTION, COL_ID);

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

    public int insert(Connection conn, FgBatch fgbatch) throws SQLException {
        logger.debug("Inserting fgbatch: {}", fgbatch);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgBatchParams(ps, fgbatch);
            ps.executeUpdate();
            return fgbatch.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgBatch> fgbatchs) throws SQLException {
        if (fgbatchs == null || fgbatchs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgbatchs.size(); i++) {
            if (fgbatchs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBatch>> batches = chunkList(fgbatchs, batchSize);
        int[] totalResults = new int[fgbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgBatch fgbatch : batch) {
                        setFgBatchParams(ps, fgbatch);
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

    public FgBatch findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgBatch> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgBatch> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgBatch fgbatch) throws SQLException {
        if (fgbatch.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgBatchParams(ps, fgbatch);
            ps.setInt(25, fgbatch.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgBatch> fgbatchs) throws SQLException {
        if (fgbatchs == null || fgbatchs.isEmpty())
            return new int[0];
        for (FgBatch fgbatch : fgbatchs) {
            if (fgbatch == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgbatch.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgBatch>> batches = chunkList(fgbatchs, batchSize);
        int[] totalResults = new int[fgbatchs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgBatch> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgBatch fgbatch : batch) {
                        setFgBatchParams(ps, fgbatch);
                        ps.setInt(25, fgbatch.getID());
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

    private void setFgBatchParams(PreparedStatement ps, FgBatch fgbatch) throws SQLException {
        Integer val1 = fgbatch.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgbatch.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgbatch.getTypeCode());
        ps.setString(4, fgbatch.getSubTypeCode());
        ps.setString(5, fgbatch.getActiveCode());
        ps.setString(6, fgbatch.getStageCode());
        ps.setString(7, fgbatch.getStatusCode());
        ps.setString(8, fgbatch.getCreatedOn());
        java.math.BigDecimal val9 = fgbatch.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgbatch.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgbatch.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgbatch.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgbatch.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgbatch.getTemplate());
        java.math.BigDecimal val15 = fgbatch.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgbatch.getRecordIdentifier());
        java.math.BigDecimal val17 = fgbatch.getTotInstruments();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        java.math.BigDecimal val18 = fgbatch.getTotalAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgbatch.getBatchRefNo());
        java.time.LocalDateTime val20 = fgbatch.getBatchDate();
        if (val20 != null) {
            ps.setTimestamp(20, java.sql.Timestamp.valueOf(val20));
        } else {
            ps.setNull(20, Types.TIMESTAMP);
        }
        ps.setString(21, fgbatch.getProductCode());
        Integer val22 = fgbatch.getUploadRefID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fgbatch.getPmntHdrIdentifier());
        java.time.LocalDateTime val24 = fgbatch.getPmntDateForFile();
        if (val24 != null) {
            ps.setTimestamp(24, java.sql.Timestamp.valueOf(val24));
        } else {
            ps.setNull(24, Types.TIMESTAMP);
        }
        java.math.BigDecimal val25 = fgbatch.getCountOfInstruction();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
    }

    private FgBatch extract(ResultSet rs) throws SQLException {
        FgBatch fgbatch = new FgBatch();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgbatch.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgbatch.setReferenceID(REFERENCE_ID);
        fgbatch.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgbatch.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgbatch.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgbatch.setStageCode(rs.getString(COL_STAGE_CODE));
        fgbatch.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgbatch.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgbatch.setCreatedBy(CREATED_BY);
        fgbatch.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgbatch.setLastUpdatedBy(LAST_UPDATED_BY);
        fgbatch.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgbatch.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgbatch.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgbatch.setIsTemplate(IS_TEMPLATE);
        fgbatch.setRecordIdentifier(rs.getString(COL_RECORD_IDENTIFIER));
        java.math.BigDecimal TOT_INSTRUMENTS = rs.getObject(COL_TOT_INSTRUMENTS, java.math.BigDecimal.class);
        fgbatch.setTotInstruments(TOT_INSTRUMENTS);
        java.math.BigDecimal TOTAL_AMOUNT = rs.getObject(COL_TOTAL_AMOUNT, java.math.BigDecimal.class);
        fgbatch.setTotalAmount(TOTAL_AMOUNT);
        fgbatch.setBatchRefNo(rs.getString(COL_BATCH_REF_NO));
        Timestamp BATCH_DATE = rs.getTimestamp(COL_BATCH_DATE);
        if (BATCH_DATE != null)
            fgbatch.setBatchDate(BATCH_DATE.toLocalDateTime());
        fgbatch.setProductCode(rs.getString(COL_PRODUCT_CODE));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgbatch.setUploadRefID(UPLOAD_REF_ID);
        fgbatch.setPmntHdrIdentifier(rs.getString(COL_PMNT_HDR_IDENTIFIER));
        Timestamp PMNT_DATE_FOR_FILE = rs.getTimestamp(COL_PMNT_DATE_FOR_FILE);
        if (PMNT_DATE_FOR_FILE != null)
            fgbatch.setPmntDateForFile(PMNT_DATE_FOR_FILE.toLocalDateTime());
        java.math.BigDecimal COUNT_OF_INSTRUCTION = rs.getObject(COL_COUNT_OF_INSTRUCTION, java.math.BigDecimal.class);
        fgbatch.setCountOfInstruction(COUNT_OF_INSTRUCTION);
        return fgbatch;
    }
}
