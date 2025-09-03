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

public class JdbcFgModCaseEntityDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModCaseEntityDao.class);

    private static final String TABLE = "FG_MOD_CASE_ENTITY";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_APPLICANT_REF_ID = "APPLICANT_REF_ID";

    private static final String COL_ISSUING_PARTY_CODE = "ISSUING_PARTY_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_TEMPLATE_JSON = "TEMPLATE_JSON";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PROCESS_ID, COL_TEMPLATE_JSON, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_STAGE_CODE, COL_IS_MASTER_VERSION, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_ATTACHMENT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, PROCESS_ID, TEMPLATE_JSON, ACTIVE_CODE, STATUS_CODE, STAGE_CODE, IS_MASTER_VERSION, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, ATTACHMENT_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, PROCESS_ID, TEMPLATE_JSON, ACTIVE_CODE, STATUS_CODE, STAGE_CODE, IS_MASTER_VERSION, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, ATTACHMENT_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_REFERENCE_ID, COL_APPLICANT_PARTY_CODE, COL_APPLICANT_REF_ID, COL_ISSUING_PARTY_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_PROCESS_ID, COL_TEMPLATE_JSON, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_STAGE_CODE, COL_IS_MASTER_VERSION, COL_CREATED_BY, COL_CREATED_ON, COL_LAST_AUTHORISED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_UPDATED_BY, COL_LAST_UPDATED_ON, COL_ATTACHMENT_ID, COL_ID);

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

    public int insert(Connection conn, FgModCaseEntity fgmodcaseentity) throws SQLException {
        logger.debug("Inserting fgmodcaseentity: {}", fgmodcaseentity);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModCaseEntityParams(ps, fgmodcaseentity);
            ps.executeUpdate();
            return fgmodcaseentity.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModCaseEntity> fgmodcaseentitys) throws SQLException {
        if (fgmodcaseentitys == null || fgmodcaseentitys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodcaseentitys.size(); i++) {
            if (fgmodcaseentitys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCaseEntity>> batches = chunkList(fgmodcaseentitys, batchSize);
        int[] totalResults = new int[fgmodcaseentitys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCaseEntity> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModCaseEntity fgmodcaseentity : batch) {
                        setFgModCaseEntityParams(ps, fgmodcaseentity);
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

    public FgModCaseEntity findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModCaseEntity> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModCaseEntity> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModCaseEntity fgmodcaseentity) throws SQLException {
        if (fgmodcaseentity.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModCaseEntityParams(ps, fgmodcaseentity);
            ps.setInt(21, fgmodcaseentity.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModCaseEntity> fgmodcaseentitys) throws SQLException {
        if (fgmodcaseentitys == null || fgmodcaseentitys.isEmpty())
            return new int[0];
        for (FgModCaseEntity fgmodcaseentity : fgmodcaseentitys) {
            if (fgmodcaseentity == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodcaseentity.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModCaseEntity>> batches = chunkList(fgmodcaseentitys, batchSize);
        int[] totalResults = new int[fgmodcaseentitys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModCaseEntity> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModCaseEntity fgmodcaseentity : batch) {
                        setFgModCaseEntityParams(ps, fgmodcaseentity);
                        ps.setInt(21, fgmodcaseentity.getID());
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

    private void setFgModCaseEntityParams(PreparedStatement ps, FgModCaseEntity fgmodcaseentity) throws SQLException {
        Integer val1 = fgmodcaseentity.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodcaseentity.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgmodcaseentity.getReferenceID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        ps.setString(4, fgmodcaseentity.getApplicantPartyCode());
        Integer val5 = fgmodcaseentity.getApplicantRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgmodcaseentity.getIssuingPartyCode());
        ps.setString(7, fgmodcaseentity.getTypeCode());
        ps.setString(8, fgmodcaseentity.getSubTypeCode());
        Integer val9 = fgmodcaseentity.getProcessID();
        if (val9 != null) {
            ps.setInt(9, val9);
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, fgmodcaseentity.getTemplateJson());
        ps.setString(11, fgmodcaseentity.getActiveCode());
        ps.setString(12, fgmodcaseentity.getStatusCode());
        ps.setString(13, fgmodcaseentity.getStageCode());
        java.math.BigDecimal val14 = fgmodcaseentity.getIsMasterVersion();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        java.math.BigDecimal val15 = fgmodcaseentity.getCreatedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgmodcaseentity.getCreatedOn());
        java.math.BigDecimal val17 = fgmodcaseentity.getLastAuthorisedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgmodcaseentity.getLastAuthorisedOn());
        java.math.BigDecimal val19 = fgmodcaseentity.getLastUpdatedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgmodcaseentity.getLastUpdatedOn());
        Integer val21 = fgmodcaseentity.getAttachmentID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
    }

    private FgModCaseEntity extract(ResultSet rs) throws SQLException {
        FgModCaseEntity fgmodcaseentity = new FgModCaseEntity();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodcaseentity.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmodcaseentity.setVersionID(VERSION_ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodcaseentity.setReferenceID(REFERENCE_ID);
        fgmodcaseentity.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer APPLICANT_REF_ID = rs.getObject(COL_APPLICANT_REF_ID, Integer.class);
        fgmodcaseentity.setApplicantRefID(APPLICANT_REF_ID);
        fgmodcaseentity.setIssuingPartyCode(rs.getString(COL_ISSUING_PARTY_CODE));
        fgmodcaseentity.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodcaseentity.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgmodcaseentity.setProcessID(PROCESS_ID);
        fgmodcaseentity.setTemplateJson(rs.getString(COL_TEMPLATE_JSON));
        fgmodcaseentity.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodcaseentity.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodcaseentity.setStageCode(rs.getString(COL_STAGE_CODE));
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmodcaseentity.setIsMasterVersion(IS_MASTER_VERSION);
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodcaseentity.setCreatedBy(CREATED_BY);
        fgmodcaseentity.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodcaseentity.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgmodcaseentity.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodcaseentity.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodcaseentity.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgmodcaseentity.setAttachmentID(ATTACHMENT_ID);
        return fgmodcaseentity;
    }
}
