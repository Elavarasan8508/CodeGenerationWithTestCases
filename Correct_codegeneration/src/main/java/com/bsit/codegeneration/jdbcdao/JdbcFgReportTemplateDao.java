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

public class JdbcFgReportTemplateDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgReportTemplateDao.class);

    private static final String TABLE = "FG_REPORT_TEMPLATE";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_TEMPLATE_TYPE = "TEMPLATE_TYPE";

    private static final String COL_REPORT_TYPE = "REPORT_TYPE";

    private static final String COL_FILE_NAME = "FILE_NAME";

    private static final String COL_FILE_TYPE = "FILE_TYPE";

    private static final String COL_FILE_SIZE = "FILE_SIZE";

    private static final String COL_TEMPLATE_VALUE = "TEMPLATE_VALUE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_NAME = "NAME";

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PARTY_CODE, COL_TEMPLATE_TYPE, COL_REPORT_TYPE, COL_FILE_NAME, COL_FILE_TYPE, COL_FILE_SIZE, COL_TEMPLATE_VALUE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_NAME, COL_ATTACHMENT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARTY_CODE, TEMPLATE_TYPE, REPORT_TYPE, FILE_NAME, FILE_TYPE, FILE_SIZE, TEMPLATE_VALUE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, NAME, ATTACHMENT_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARTY_CODE, TEMPLATE_TYPE, REPORT_TYPE, FILE_NAME, FILE_TYPE, FILE_SIZE, TEMPLATE_VALUE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, NAME, ATTACHMENT_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PARTY_CODE, COL_TEMPLATE_TYPE, COL_REPORT_TYPE, COL_FILE_NAME, COL_FILE_TYPE, COL_FILE_SIZE, COL_TEMPLATE_VALUE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_NAME, COL_ATTACHMENT_ID, COL_ID);

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

    public int insert(Connection conn, FgReportTemplate fgreporttemplate) throws SQLException {
        logger.debug("Inserting fgreporttemplate: {}", fgreporttemplate);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgReportTemplateParams(ps, fgreporttemplate);
            ps.executeUpdate();
            return fgreporttemplate.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgReportTemplate> fgreporttemplates) throws SQLException {
        if (fgreporttemplates == null || fgreporttemplates.isEmpty())
            return new int[0];
        for (int i = 0; i < fgreporttemplates.size(); i++) {
            if (fgreporttemplates.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgReportTemplate>> batches = chunkList(fgreporttemplates, batchSize);
        int[] totalResults = new int[fgreporttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgReportTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgReportTemplate fgreporttemplate : batch) {
                        setFgReportTemplateParams(ps, fgreporttemplate);
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

    public FgReportTemplate findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgReportTemplate> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgReportTemplate> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgReportTemplate fgreporttemplate) throws SQLException {
        if (fgreporttemplate.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgReportTemplateParams(ps, fgreporttemplate);
            ps.setInt(21, fgreporttemplate.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgReportTemplate> fgreporttemplates) throws SQLException {
        if (fgreporttemplates == null || fgreporttemplates.isEmpty())
            return new int[0];
        for (FgReportTemplate fgreporttemplate : fgreporttemplates) {
            if (fgreporttemplate == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgreporttemplate.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgReportTemplate>> batches = chunkList(fgreporttemplates, batchSize);
        int[] totalResults = new int[fgreporttemplates.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgReportTemplate> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgReportTemplate fgreporttemplate : batch) {
                        setFgReportTemplateParams(ps, fgreporttemplate);
                        ps.setInt(21, fgreporttemplate.getID());
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

    private void setFgReportTemplateParams(PreparedStatement ps, FgReportTemplate fgreporttemplate) throws SQLException {
        Integer val1 = fgreporttemplate.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgreporttemplate.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgreporttemplate.getTypeCode());
        ps.setString(4, fgreporttemplate.getSubTypeCode());
        ps.setString(5, fgreporttemplate.getPartyCode());
        ps.setString(6, fgreporttemplate.getTemplateType());
        ps.setString(7, fgreporttemplate.getReportType());
        ps.setString(8, fgreporttemplate.getFileName());
        ps.setString(9, fgreporttemplate.getFileType());
        ps.setString(10, fgreporttemplate.getFileSize());
        ps.setString(11, fgreporttemplate.getTemplateValue());
        ps.setString(12, fgreporttemplate.getActiveCode());
        ps.setString(13, fgreporttemplate.getStatusCode());
        ps.setString(14, fgreporttemplate.getCreatedOn());
        java.math.BigDecimal val15 = fgreporttemplate.getCreatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgreporttemplate.getLastUpdatedOn());
        java.math.BigDecimal val17 = fgreporttemplate.getLastUpdatedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgreporttemplate.getLastAuthorisedOn());
        java.math.BigDecimal val19 = fgreporttemplate.getLastAuthorisedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgreporttemplate.getName());
        Integer val21 = fgreporttemplate.getAttachmentID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
    }

    private FgReportTemplate extract(ResultSet rs) throws SQLException {
        FgReportTemplate fgreporttemplate = new FgReportTemplate();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgreporttemplate.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgreporttemplate.setReferenceID(REFERENCE_ID);
        fgreporttemplate.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgreporttemplate.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgreporttemplate.setPartyCode(rs.getString(COL_PARTY_CODE));
        fgreporttemplate.setTemplateType(rs.getString(COL_TEMPLATE_TYPE));
        fgreporttemplate.setReportType(rs.getString(COL_REPORT_TYPE));
        fgreporttemplate.setFileName(rs.getString(COL_FILE_NAME));
        fgreporttemplate.setFileType(rs.getString(COL_FILE_TYPE));
        fgreporttemplate.setFileSize(rs.getString(COL_FILE_SIZE));
        fgreporttemplate.setTemplateValue(rs.getString(COL_TEMPLATE_VALUE));
        fgreporttemplate.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgreporttemplate.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgreporttemplate.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgreporttemplate.setCreatedBy(CREATED_BY);
        fgreporttemplate.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgreporttemplate.setLastUpdatedBy(LAST_UPDATED_BY);
        fgreporttemplate.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgreporttemplate.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgreporttemplate.setName(rs.getString(COL_NAME));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgreporttemplate.setAttachmentID(ATTACHMENT_ID);
        return fgreporttemplate;
    }
}
