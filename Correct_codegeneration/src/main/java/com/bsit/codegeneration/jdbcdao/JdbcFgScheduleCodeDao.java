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

public class JdbcFgScheduleCodeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgScheduleCodeDao.class);

    private static final String TABLE = "FG_SCHEDULE_CODE";

    private static final String COL_ID = "ID";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_NAME = "NAME";

    private static final String COL_PROCESSING_TYPE = "PROCESSING_TYPE";

    private static final String COL_START_DATE = "START_DATE";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_APPLICANT_PARTY_CODE = "APPLICANT_PARTY_CODE";

    private static final String COL_CONFIG_REF_ID = "CONFIG_REF_ID";

    private static final String COL_CATEGORY_CODE = "CATEGORY_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ENTITY_TYPE_CODE = "ENTITY_TYPE_CODE";

    private static final String COL_ENTITY_SUB_TYPE_CODE = "ENTITY_SUB_TYPE_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_END_DATE, COL_NAME, COL_PROCESSING_TYPE, COL_START_DATE, COL_TEMPLATE, COL_TYPE_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_DESCRIPTION, COL_APPLICANT_PARTY_CODE, COL_CONFIG_REF_ID, COL_CATEGORY_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_PROCESS_ID, COL_REFERENCE_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE", TABLE, COL_ID);

    private static final String SELECT_BY_PARTY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE", TABLE, COL_PARTY_ID);

    private static final String SELECT_BY_PARTY_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE", TABLE, COL_PARTY_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_END_DATE, COL_NAME, COL_PROCESSING_TYPE, COL_START_DATE, COL_TEMPLATE, COL_TYPE_CODE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_DESCRIPTION, COL_APPLICANT_PARTY_CODE, COL_CONFIG_REF_ID, COL_CATEGORY_CODE, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SUB_TYPE_CODE, COL_ENTITY_TYPE_CODE, COL_ENTITY_SUB_TYPE_CODE, COL_PROCESS_ID, COL_REFERENCE_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_STAGE_CODE, COL_ID);

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

    public int insert(Connection conn, FgScheduleCode fgschedulecode) throws SQLException {
        logger.debug("Inserting fgschedulecode: {}", fgschedulecode);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgScheduleCodeParams(ps, fgschedulecode);
            ps.executeUpdate();
            return fgschedulecode.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgScheduleCode> fgschedulecodes) throws SQLException {
        if (fgschedulecodes == null || fgschedulecodes.isEmpty())
            return new int[0];
        for (int i = 0; i < fgschedulecodes.size(); i++) {
            if (fgschedulecodes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgScheduleCode>> batches = chunkList(fgschedulecodes, batchSize);
        int[] totalResults = new int[fgschedulecodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgScheduleCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgScheduleCode fgschedulecode : batch) {
                        setFgScheduleCodeParams(ps, fgschedulecode);
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

    public FgScheduleCode findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgScheduleCode> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgScheduleCode> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgScheduleCode fgschedulecode) throws SQLException {
        if (fgschedulecode.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgScheduleCodeParams(ps, fgschedulecode);
            ps.setInt(29, fgschedulecode.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgScheduleCode> fgschedulecodes) throws SQLException {
        if (fgschedulecodes == null || fgschedulecodes.isEmpty())
            return new int[0];
        for (FgScheduleCode fgschedulecode : fgschedulecodes) {
            if (fgschedulecode == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgschedulecode.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgScheduleCode>> batches = chunkList(fgschedulecodes, batchSize);
        int[] totalResults = new int[fgschedulecodes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgScheduleCode> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgScheduleCode fgschedulecode : batch) {
                        setFgScheduleCodeParams(ps, fgschedulecode);
                        ps.setInt(29, fgschedulecode.getID());
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

    public List<FgScheduleCode> findByPartyID(Connection conn, int partyID) throws SQLException {
        List<FgScheduleCode> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PARTY_ID_SQL)) {
            ps.setInt(1, partyID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FgScheduleCode> findByPartyVersionID(Connection conn, int partyVersionID) throws SQLException {
        List<FgScheduleCode> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_PARTY_VERSION_ID_SQL)) {
            ps.setInt(1, partyVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgScheduleCodeParams(PreparedStatement ps, FgScheduleCode fgschedulecode) throws SQLException {
        Integer val1 = fgschedulecode.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        java.time.LocalDateTime val2 = fgschedulecode.getEndDate();
        if (val2 != null) {
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(val2));
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
        ps.setString(3, fgschedulecode.getName());
        ps.setString(4, fgschedulecode.getProcessingType());
        java.time.LocalDateTime val5 = fgschedulecode.getStartDate();
        if (val5 != null) {
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(val5));
        } else {
            ps.setNull(5, Types.TIMESTAMP);
        }
        ps.setString(6, fgschedulecode.getTemplate());
        ps.setString(7, fgschedulecode.getTypeCode());
        if (fgschedulecode.getParty() != null) {
            ps.setInt(8, fgschedulecode.getParty().getFgPartyID());
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        if (fgschedulecode.getPartyVersion() != null) {
            ps.setInt(9, fgschedulecode.getPartyVersion().getFgPartyID());
        } else {
            ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, fgschedulecode.getDescription());
        ps.setString(11, fgschedulecode.getApplicantPartyCode());
        Integer val12 = fgschedulecode.getConfigRefID();
        if (val12 != null) {
            ps.setInt(12, val12);
        } else {
            ps.setNull(12, Types.INTEGER);
        }
        ps.setString(13, fgschedulecode.getCategoryCode());
        ps.setString(14, fgschedulecode.getActiveCode());
        ps.setString(15, fgschedulecode.getStatusCode());
        ps.setString(16, fgschedulecode.getCreatedOn());
        java.math.BigDecimal val17 = fgschedulecode.getCreatedBy();
        if (val17 != null) {
            ps.setBigDecimal(17, val17);
        } else {
            ps.setNull(17, Types.DECIMAL);
        }
        ps.setString(18, fgschedulecode.getLastUpdatedOn());
        java.math.BigDecimal val19 = fgschedulecode.getLastUpdatedBy();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgschedulecode.getLastAuthorisedOn());
        java.math.BigDecimal val21 = fgschedulecode.getLastAuthorisedBy();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        ps.setString(22, fgschedulecode.getSubTypeCode());
        ps.setString(23, fgschedulecode.getEntityTypeCode());
        ps.setString(24, fgschedulecode.getEntitySubTypeCode());
        Integer val25 = fgschedulecode.getProcessID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        Integer val26 = fgschedulecode.getReferenceID();
        if (val26 != null) {
            ps.setInt(26, val26);
        } else {
            ps.setNull(26, Types.INTEGER);
        }
        Integer val27 = fgschedulecode.getVersionID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = fgschedulecode.getIsMasterVersion();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        ps.setString(29, fgschedulecode.getStageCode());
    }

    private FgScheduleCode extract(ResultSet rs) throws SQLException {
        FgScheduleCode fgschedulecode = new FgScheduleCode();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgschedulecode.setID(ID);
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            fgschedulecode.setEndDate(END_DATE.toLocalDateTime());
        fgschedulecode.setName(rs.getString(COL_NAME));
        fgschedulecode.setProcessingType(rs.getString(COL_PROCESSING_TYPE));
        Timestamp START_DATE = rs.getTimestamp(COL_START_DATE);
        if (START_DATE != null)
            fgschedulecode.setStartDate(START_DATE.toLocalDateTime());
        fgschedulecode.setTemplate(rs.getString(COL_TEMPLATE));
        fgschedulecode.setTypeCode(rs.getString(COL_TYPE_CODE));
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgschedulecode.setPartyID(PARTY_ID);
        if (PARTY_ID != null) {
            FgParty party = new FgParty();
            party.setFgPartyID(PARTY_ID);
            fgschedulecode.setParty(party);
        }
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgschedulecode.setPartyVersionID(PARTY_VERSION_ID);
        if (PARTY_VERSION_ID != null) {
            FgParty partyVersion = new FgParty();
            partyVersion.setFgPartyID(PARTY_VERSION_ID);
            fgschedulecode.setPartyVersion(partyVersion);
        }
        fgschedulecode.setDescription(rs.getString(COL_DESCRIPTION));
        fgschedulecode.setApplicantPartyCode(rs.getString(COL_APPLICANT_PARTY_CODE));
        Integer CONFIG_REF_ID = rs.getObject(COL_CONFIG_REF_ID, Integer.class);
        fgschedulecode.setConfigRefID(CONFIG_REF_ID);
        fgschedulecode.setCategoryCode(rs.getString(COL_CATEGORY_CODE));
        fgschedulecode.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgschedulecode.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgschedulecode.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgschedulecode.setCreatedBy(CREATED_BY);
        fgschedulecode.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgschedulecode.setLastUpdatedBy(LAST_UPDATED_BY);
        fgschedulecode.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgschedulecode.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgschedulecode.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgschedulecode.setEntityTypeCode(rs.getString(COL_ENTITY_TYPE_CODE));
        fgschedulecode.setEntitySubTypeCode(rs.getString(COL_ENTITY_SUB_TYPE_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgschedulecode.setProcessID(PROCESS_ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgschedulecode.setReferenceID(REFERENCE_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgschedulecode.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgschedulecode.setIsMasterVersion(IS_MASTER_VERSION);
        fgschedulecode.setStageCode(rs.getString(COL_STAGE_CODE));
        return fgschedulecode;
    }
}
