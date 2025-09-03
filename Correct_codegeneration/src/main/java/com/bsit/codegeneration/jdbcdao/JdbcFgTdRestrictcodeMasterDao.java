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

public class JdbcFgTdRestrictcodeMasterDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgTdRestrictcodeMasterDao.class);

    private static final String TABLE = "FG_TD_RESTRICTCODE_MASTER";

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

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_SCHEME_DESCRIPTION = "SCHEME_DESCRIPTION";

    private static final String COL_TYPE = "TYPE";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_TASK_REASON = "TASK_REASON";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_SCHEME_TYPE = "SCHEME_TYPE";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_ORIGIN = "ORIGIN";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_CODE, COL_SCHEME_DESCRIPTION, COL_TYPE, COL_USER_ID, COL_TASK_REASON, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_SCHEME_TYPE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ORIGIN);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_CODE, SCHEME_DESCRIPTION, TYPE, USER_ID, TASK_REASON, VERSION_ID, IS_MASTER_VERSION, SCHEME_TYPE, PARENT_REF_ID, PARENT_VERSION_ID, ORIGIN", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_CODE, SCHEME_DESCRIPTION, TYPE, USER_ID, TASK_REASON, VERSION_ID, IS_MASTER_VERSION, SCHEME_TYPE, PARENT_REF_ID, PARENT_VERSION_ID, ORIGIN", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_SCHEME_CODE, COL_SCHEME_DESCRIPTION, COL_TYPE, COL_USER_ID, COL_TASK_REASON, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_SCHEME_TYPE, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_ORIGIN, COL_ID);

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

    public int insert(Connection conn, FgTdRestrictcodeMaster fgtdrestrictcodemaster) throws SQLException {
        logger.debug("Inserting fgtdrestrictcodemaster: {}", fgtdrestrictcodemaster);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgTdRestrictcodeMasterParams(ps, fgtdrestrictcodemaster);
            ps.executeUpdate();
            return fgtdrestrictcodemaster.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgTdRestrictcodeMaster> fgtdrestrictcodemasters) throws SQLException {
        if (fgtdrestrictcodemasters == null || fgtdrestrictcodemasters.isEmpty())
            return new int[0];
        for (int i = 0; i < fgtdrestrictcodemasters.size(); i++) {
            if (fgtdrestrictcodemasters.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdRestrictcodeMaster>> batches = chunkList(fgtdrestrictcodemasters, batchSize);
        int[] totalResults = new int[fgtdrestrictcodemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdRestrictcodeMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgTdRestrictcodeMaster fgtdrestrictcodemaster : batch) {
                        setFgTdRestrictcodeMasterParams(ps, fgtdrestrictcodemaster);
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

    public FgTdRestrictcodeMaster findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgTdRestrictcodeMaster> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgTdRestrictcodeMaster> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgTdRestrictcodeMaster fgtdrestrictcodemaster) throws SQLException {
        if (fgtdrestrictcodemaster.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgTdRestrictcodeMasterParams(ps, fgtdrestrictcodemaster);
            ps.setInt(29, fgtdrestrictcodemaster.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgTdRestrictcodeMaster> fgtdrestrictcodemasters) throws SQLException {
        if (fgtdrestrictcodemasters == null || fgtdrestrictcodemasters.isEmpty())
            return new int[0];
        for (FgTdRestrictcodeMaster fgtdrestrictcodemaster : fgtdrestrictcodemasters) {
            if (fgtdrestrictcodemaster == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgtdrestrictcodemaster.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgTdRestrictcodeMaster>> batches = chunkList(fgtdrestrictcodemasters, batchSize);
        int[] totalResults = new int[fgtdrestrictcodemasters.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgTdRestrictcodeMaster> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgTdRestrictcodeMaster fgtdrestrictcodemaster : batch) {
                        setFgTdRestrictcodeMasterParams(ps, fgtdrestrictcodemaster);
                        ps.setInt(29, fgtdrestrictcodemaster.getID());
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

    private void setFgTdRestrictcodeMasterParams(PreparedStatement ps, FgTdRestrictcodeMaster fgtdrestrictcodemaster) throws SQLException {
        Integer val1 = fgtdrestrictcodemaster.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgtdrestrictcodemaster.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgtdrestrictcodemaster.getTypeCode());
        ps.setString(4, fgtdrestrictcodemaster.getSubTypeCode());
        ps.setString(5, fgtdrestrictcodemaster.getActiveCode());
        ps.setString(6, fgtdrestrictcodemaster.getStageCode());
        ps.setString(7, fgtdrestrictcodemaster.getStatusCode());
        Integer val8 = fgtdrestrictcodemaster.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgtdrestrictcodemaster.getCreatedOn());
        java.math.BigDecimal val10 = fgtdrestrictcodemaster.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgtdrestrictcodemaster.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgtdrestrictcodemaster.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgtdrestrictcodemaster.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgtdrestrictcodemaster.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgtdrestrictcodemaster.getTemplate());
        ps.setString(16, fgtdrestrictcodemaster.getApplicantParty());
        ps.setString(17, fgtdrestrictcodemaster.getFulfillmentParty());
        java.math.BigDecimal val18 = fgtdrestrictcodemaster.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgtdrestrictcodemaster.getSchemeCode());
        ps.setString(20, fgtdrestrictcodemaster.getSchemeDescription());
        ps.setString(21, fgtdrestrictcodemaster.getType());
        Integer val22 = fgtdrestrictcodemaster.getUserID();
        if (val22 != null) {
            ps.setInt(22, val22);
        } else {
            ps.setNull(22, Types.INTEGER);
        }
        ps.setString(23, fgtdrestrictcodemaster.getTaskReason());
        Integer val24 = fgtdrestrictcodemaster.getVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgtdrestrictcodemaster.getIsMasterVersion();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgtdrestrictcodemaster.getSchemeType());
        Integer val27 = fgtdrestrictcodemaster.getParentRefID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        Integer val28 = fgtdrestrictcodemaster.getParentVersionID();
        if (val28 != null) {
            ps.setInt(28, val28);
        } else {
            ps.setNull(28, Types.INTEGER);
        }
        ps.setString(29, fgtdrestrictcodemaster.getOrigin());
    }

    private FgTdRestrictcodeMaster extract(ResultSet rs) throws SQLException {
        FgTdRestrictcodeMaster fgtdrestrictcodemaster = new FgTdRestrictcodeMaster();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgtdrestrictcodemaster.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgtdrestrictcodemaster.setReferenceID(REFERENCE_ID);
        fgtdrestrictcodemaster.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgtdrestrictcodemaster.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgtdrestrictcodemaster.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgtdrestrictcodemaster.setStageCode(rs.getString(COL_STAGE_CODE));
        fgtdrestrictcodemaster.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgtdrestrictcodemaster.setProcessID(PROCESS_ID);
        fgtdrestrictcodemaster.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgtdrestrictcodemaster.setCreatedBy(CREATED_BY);
        fgtdrestrictcodemaster.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgtdrestrictcodemaster.setLastUpdatedBy(LAST_UPDATED_BY);
        fgtdrestrictcodemaster.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgtdrestrictcodemaster.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgtdrestrictcodemaster.setTemplate(rs.getString(COL_TEMPLATE));
        fgtdrestrictcodemaster.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgtdrestrictcodemaster.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgtdrestrictcodemaster.setIsTemplate(IS_TEMPLATE);
        fgtdrestrictcodemaster.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        fgtdrestrictcodemaster.setSchemeDescription(rs.getString(COL_SCHEME_DESCRIPTION));
        fgtdrestrictcodemaster.setType(rs.getString(COL_TYPE));
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        fgtdrestrictcodemaster.setUserID(USER_ID);
        fgtdrestrictcodemaster.setTaskReason(rs.getString(COL_TASK_REASON));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgtdrestrictcodemaster.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgtdrestrictcodemaster.setIsMasterVersion(IS_MASTER_VERSION);
        fgtdrestrictcodemaster.setSchemeType(rs.getString(COL_SCHEME_TYPE));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgtdrestrictcodemaster.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgtdrestrictcodemaster.setParentVersionID(PARENT_VERSION_ID);
        fgtdrestrictcodemaster.setOrigin(rs.getString(COL_ORIGIN));
        return fgtdrestrictcodemaster;
    }
}
