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

public class JdbcFgLayoutMappingDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgLayoutMappingDao.class);

    private static final String TABLE = "FG_LAYOUT_MAPPING";

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

    private static final String COL_LAYOUT_MAPPING = "LAYOUT_MAPPING";

    private static final String COL_LIST_MAPPING = "LIST_MAPPING";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_LIST_ID = "LIST_ID";

    private static final String COL_LAYOUT_UUID = "LAYOUT_UUID";

    private static final String COL_LIST_UUID = "LIST_UUID";

    private static final String COL_TYPE = "TYPE";

    private static final String COL_FORM_ID = "FORM_ID";

    private static final String COL_FORM_MAPPING = "FORM_MAPPING";

    private static final String COL_FORM_UUID = "FORM_UUID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LAYOUT_MAPPING, COL_LIST_MAPPING, COL_LAYOUT_ID, COL_LIST_ID, COL_LAYOUT_UUID, COL_LIST_UUID, COL_TYPE, COL_FORM_ID, COL_FORM_MAPPING, COL_FORM_UUID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_MAPPING, LIST_MAPPING, LAYOUT_ID, LIST_ID, LAYOUT_UUID, LIST_UUID, TYPE, FORM_ID, FORM_MAPPING, FORM_UUID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_MAPPING, LIST_MAPPING, LAYOUT_ID, LIST_ID, LAYOUT_UUID, LIST_UUID, TYPE, FORM_ID, FORM_MAPPING, FORM_UUID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_LAYOUT_MAPPING, COL_LIST_MAPPING, COL_LAYOUT_ID, COL_LIST_ID, COL_LAYOUT_UUID, COL_LIST_UUID, COL_TYPE, COL_FORM_ID, COL_FORM_MAPPING, COL_FORM_UUID, COL_ID);

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

    public int insert(Connection conn, FgLayoutMapping fglayoutmapping) throws SQLException {
        logger.debug("Inserting fglayoutmapping: {}", fglayoutmapping);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgLayoutMappingParams(ps, fglayoutmapping);
            ps.executeUpdate();
            return fglayoutmapping.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgLayoutMapping> fglayoutmappings) throws SQLException {
        if (fglayoutmappings == null || fglayoutmappings.isEmpty())
            return new int[0];
        for (int i = 0; i < fglayoutmappings.size(); i++) {
            if (fglayoutmappings.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutMapping>> batches = chunkList(fglayoutmappings, batchSize);
        int[] totalResults = new int[fglayoutmappings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutMapping> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgLayoutMapping fglayoutmapping : batch) {
                        setFgLayoutMappingParams(ps, fglayoutmapping);
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

    public FgLayoutMapping findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgLayoutMapping> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgLayoutMapping> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgLayoutMapping fglayoutmapping) throws SQLException {
        if (fglayoutmapping.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgLayoutMappingParams(ps, fglayoutmapping);
            ps.setInt(28, fglayoutmapping.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgLayoutMapping> fglayoutmappings) throws SQLException {
        if (fglayoutmappings == null || fglayoutmappings.isEmpty())
            return new int[0];
        for (FgLayoutMapping fglayoutmapping : fglayoutmappings) {
            if (fglayoutmapping == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fglayoutmapping.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgLayoutMapping>> batches = chunkList(fglayoutmappings, batchSize);
        int[] totalResults = new int[fglayoutmappings.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgLayoutMapping> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgLayoutMapping fglayoutmapping : batch) {
                        setFgLayoutMappingParams(ps, fglayoutmapping);
                        ps.setInt(28, fglayoutmapping.getID());
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

    private void setFgLayoutMappingParams(PreparedStatement ps, FgLayoutMapping fglayoutmapping) throws SQLException {
        Integer val1 = fglayoutmapping.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fglayoutmapping.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fglayoutmapping.getTypeCode());
        ps.setString(4, fglayoutmapping.getSubTypeCode());
        ps.setString(5, fglayoutmapping.getActiveCode());
        ps.setString(6, fglayoutmapping.getStageCode());
        ps.setString(7, fglayoutmapping.getStatusCode());
        Integer val8 = fglayoutmapping.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fglayoutmapping.getCreatedOn());
        java.math.BigDecimal val10 = fglayoutmapping.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fglayoutmapping.getLastUpdatedOn());
        java.math.BigDecimal val12 = fglayoutmapping.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fglayoutmapping.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fglayoutmapping.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fglayoutmapping.getTemplate());
        ps.setString(16, fglayoutmapping.getApplicantParty());
        ps.setString(17, fglayoutmapping.getFulfillmentParty());
        java.math.BigDecimal val18 = fglayoutmapping.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fglayoutmapping.getLayoutMapping());
        ps.setString(20, fglayoutmapping.getListMapping());
        Integer val21 = fglayoutmapping.getLayoutID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        Integer val22 = fglayoutmapping.getListID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fglayoutmapping.getLayoutUuid());
        ps.setString(24, fglayoutmapping.getListUuid());
        ps.setString(25, fglayoutmapping.getType());
        Integer val26 = fglayoutmapping.getFormID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        ps.setString(27, fglayoutmapping.getFormMapping());
        ps.setString(28, fglayoutmapping.getFormUuid());
    }

    private FgLayoutMapping extract(ResultSet rs) throws SQLException {
        FgLayoutMapping fglayoutmapping = new FgLayoutMapping();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fglayoutmapping.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fglayoutmapping.setReferenceID(REFERENCE_ID);
        fglayoutmapping.setTypeCode(rs.getString(COL_TYPE_CODE));
        fglayoutmapping.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fglayoutmapping.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fglayoutmapping.setStageCode(rs.getString(COL_STAGE_CODE));
        fglayoutmapping.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fglayoutmapping.setProcessID(PROCESS_ID);
        fglayoutmapping.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fglayoutmapping.setCreatedBy(CREATED_BY);
        fglayoutmapping.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fglayoutmapping.setLastUpdatedBy(LAST_UPDATED_BY);
        fglayoutmapping.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fglayoutmapping.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fglayoutmapping.setTemplate(rs.getString(COL_TEMPLATE));
        fglayoutmapping.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fglayoutmapping.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fglayoutmapping.setIsTemplate(IS_TEMPLATE);
        fglayoutmapping.setLayoutMapping(rs.getString(COL_LAYOUT_MAPPING));
        fglayoutmapping.setListMapping(rs.getString(COL_LIST_MAPPING));
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        fglayoutmapping.setLayoutID(LAYOUT_ID);
        Integer LIST_ID = rs.getObject(COL_LIST_ID, Integer.class);
        fglayoutmapping.setListID(LIST_ID);
        fglayoutmapping.setLayoutUuid(rs.getString(COL_LAYOUT_UUID));
        fglayoutmapping.setListUuid(rs.getString(COL_LIST_UUID));
        fglayoutmapping.setType(rs.getString(COL_TYPE));
        Integer FORM_ID = rs.getObject(COL_FORM_ID, Integer.class);
        fglayoutmapping.setFormID(FORM_ID);
        fglayoutmapping.setFormMapping(rs.getString(COL_FORM_MAPPING));
        fglayoutmapping.setFormUuid(rs.getString(COL_FORM_UUID));
        return fglayoutmapping;
    }
}
