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

public class JdbcFgUploadEntityAttributeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgUploadEntityAttributeDao.class);

    private static final String TABLE = "FG_UPLOAD_ENTITY_ATTRIBUTE";

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

    private static final String COL_REL_CATEGORY = "REL_CATEGORY";

    private static final String COL_REL_ENTITY_TYPE = "REL_ENTITY_TYPE";

    private static final String COL_REL_ENTITY_REF_NO = "REL_ENTITY_REF_NO";

    private static final String COL_REL_ENTY_REF_VERSION = "REL_ENTY_REF_VERSION";

    private static final String COL_REL_ATTRIBUTE_TYPE = "REL_ATTRIBUTE_TYPE";

    private static final String COL_REL_ATTRIBUTE_KEY = "REL_ATTRIBUTE_KEY";

    private static final String COL_REL_ATTRIBUTE_VALUE = "REL_ATTRIBUTE_VALUE";

    private static final String COL_UPLOAD_REF_NO = "UPLOAD_REF_NO";

    private static final String COL_REL_ENTITY_SUB_TYPE = "REL_ENTITY_SUB_TYPE";

    private static final String COL_REL_ENTITY_ATTRIBUTE = "REL_ENTITY_ATTRIBUTE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_REL_CATEGORY, COL_REL_ENTITY_TYPE, COL_REL_ENTITY_REF_NO, COL_REL_ENTY_REF_VERSION, COL_REL_ATTRIBUTE_TYPE, COL_REL_ATTRIBUTE_KEY, COL_REL_ATTRIBUTE_VALUE, COL_UPLOAD_REF_NO, COL_REL_ENTITY_SUB_TYPE, COL_REL_ENTITY_ATTRIBUTE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REL_CATEGORY, REL_ENTITY_TYPE, REL_ENTITY_REF_NO, REL_ENTY_REF_VERSION, REL_ATTRIBUTE_TYPE, REL_ATTRIBUTE_KEY, REL_ATTRIBUTE_VALUE, UPLOAD_REF_NO, REL_ENTITY_SUB_TYPE, REL_ENTITY_ATTRIBUTE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REL_CATEGORY, REL_ENTITY_TYPE, REL_ENTITY_REF_NO, REL_ENTY_REF_VERSION, REL_ATTRIBUTE_TYPE, REL_ATTRIBUTE_KEY, REL_ATTRIBUTE_VALUE, UPLOAD_REF_NO, REL_ENTITY_SUB_TYPE, REL_ENTITY_ATTRIBUTE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_REL_CATEGORY, COL_REL_ENTITY_TYPE, COL_REL_ENTITY_REF_NO, COL_REL_ENTY_REF_VERSION, COL_REL_ATTRIBUTE_TYPE, COL_REL_ATTRIBUTE_KEY, COL_REL_ATTRIBUTE_VALUE, COL_UPLOAD_REF_NO, COL_REL_ENTITY_SUB_TYPE, COL_REL_ENTITY_ATTRIBUTE, COL_ID);

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

    public int insert(Connection conn, FgUploadEntityAttribute fguploadentityattribute) throws SQLException {
        logger.debug("Inserting fguploadentityattribute: {}", fguploadentityattribute);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgUploadEntityAttributeParams(ps, fguploadentityattribute);
            ps.executeUpdate();
            return fguploadentityattribute.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgUploadEntityAttribute> fguploadentityattributes) throws SQLException {
        if (fguploadentityattributes == null || fguploadentityattributes.isEmpty())
            return new int[0];
        for (int i = 0; i < fguploadentityattributes.size(); i++) {
            if (fguploadentityattributes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUploadEntityAttribute>> batches = chunkList(fguploadentityattributes, batchSize);
        int[] totalResults = new int[fguploadentityattributes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUploadEntityAttribute> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgUploadEntityAttribute fguploadentityattribute : batch) {
                        setFgUploadEntityAttributeParams(ps, fguploadentityattribute);
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

    public FgUploadEntityAttribute findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgUploadEntityAttribute> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgUploadEntityAttribute> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgUploadEntityAttribute fguploadentityattribute) throws SQLException {
        if (fguploadentityattribute.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgUploadEntityAttributeParams(ps, fguploadentityattribute);
            ps.setInt(25, fguploadentityattribute.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgUploadEntityAttribute> fguploadentityattributes) throws SQLException {
        if (fguploadentityattributes == null || fguploadentityattributes.isEmpty())
            return new int[0];
        for (FgUploadEntityAttribute fguploadentityattribute : fguploadentityattributes) {
            if (fguploadentityattribute == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fguploadentityattribute.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgUploadEntityAttribute>> batches = chunkList(fguploadentityattributes, batchSize);
        int[] totalResults = new int[fguploadentityattributes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgUploadEntityAttribute> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgUploadEntityAttribute fguploadentityattribute : batch) {
                        setFgUploadEntityAttributeParams(ps, fguploadentityattribute);
                        ps.setInt(25, fguploadentityattribute.getID());
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

    private void setFgUploadEntityAttributeParams(PreparedStatement ps, FgUploadEntityAttribute fguploadentityattribute) throws SQLException {
        Integer val1 = fguploadentityattribute.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fguploadentityattribute.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fguploadentityattribute.getTypeCode());
        ps.setString(4, fguploadentityattribute.getSubTypeCode());
        ps.setString(5, fguploadentityattribute.getActiveCode());
        ps.setString(6, fguploadentityattribute.getStageCode());
        ps.setString(7, fguploadentityattribute.getStatusCode());
        ps.setString(8, fguploadentityattribute.getCreatedOn());
        java.math.BigDecimal val9 = fguploadentityattribute.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fguploadentityattribute.getLastUpdatedOn());
        java.math.BigDecimal val11 = fguploadentityattribute.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fguploadentityattribute.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fguploadentityattribute.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fguploadentityattribute.getTemplate());
        java.math.BigDecimal val15 = fguploadentityattribute.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fguploadentityattribute.getRelCategory());
        ps.setString(17, fguploadentityattribute.getRelEntityType());
        ps.setString(18, fguploadentityattribute.getRelEntityRefNo());
        ps.setString(19, fguploadentityattribute.getRelEntyRefVersion());
        ps.setString(20, fguploadentityattribute.getRelAttributeType());
        ps.setString(21, fguploadentityattribute.getRelAttributeKey());
        ps.setString(22, fguploadentityattribute.getRelAttributeValue());
        ps.setString(23, fguploadentityattribute.getUploadRefNo());
        ps.setString(24, fguploadentityattribute.getRelEntitySubType());
        ps.setString(25, fguploadentityattribute.getRelEntityAttribute());
    }

    private FgUploadEntityAttribute extract(ResultSet rs) throws SQLException {
        FgUploadEntityAttribute fguploadentityattribute = new FgUploadEntityAttribute();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fguploadentityattribute.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fguploadentityattribute.setReferenceID(REFERENCE_ID);
        fguploadentityattribute.setTypeCode(rs.getString(COL_TYPE_CODE));
        fguploadentityattribute.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fguploadentityattribute.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fguploadentityattribute.setStageCode(rs.getString(COL_STAGE_CODE));
        fguploadentityattribute.setStatusCode(rs.getString(COL_STATUS_CODE));
        fguploadentityattribute.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fguploadentityattribute.setCreatedBy(CREATED_BY);
        fguploadentityattribute.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fguploadentityattribute.setLastUpdatedBy(LAST_UPDATED_BY);
        fguploadentityattribute.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fguploadentityattribute.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fguploadentityattribute.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fguploadentityattribute.setIsTemplate(IS_TEMPLATE);
        fguploadentityattribute.setRelCategory(rs.getString(COL_REL_CATEGORY));
        fguploadentityattribute.setRelEntityType(rs.getString(COL_REL_ENTITY_TYPE));
        fguploadentityattribute.setRelEntityRefNo(rs.getString(COL_REL_ENTITY_REF_NO));
        fguploadentityattribute.setRelEntyRefVersion(rs.getString(COL_REL_ENTY_REF_VERSION));
        fguploadentityattribute.setRelAttributeType(rs.getString(COL_REL_ATTRIBUTE_TYPE));
        fguploadentityattribute.setRelAttributeKey(rs.getString(COL_REL_ATTRIBUTE_KEY));
        fguploadentityattribute.setRelAttributeValue(rs.getString(COL_REL_ATTRIBUTE_VALUE));
        fguploadentityattribute.setUploadRefNo(rs.getString(COL_UPLOAD_REF_NO));
        fguploadentityattribute.setRelEntitySubType(rs.getString(COL_REL_ENTITY_SUB_TYPE));
        fguploadentityattribute.setRelEntityAttribute(rs.getString(COL_REL_ENTITY_ATTRIBUTE));
        return fguploadentityattribute;
    }
}
