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

public class JdbcFgProjectsDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProjectsDao.class);

    private static final String TABLE = "FG_PROJECTS";

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

    private static final String COL_PROJECT_NAME = "PROJECT_NAME";

    private static final String COL_START_DATE = "START_DATE";

    private static final String COL_END_DATE = "END_DATE";

    private static final String COL_PROJECT_TITLE = "PROJECT_TITLE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_SUB_PROJECT = "SUB_PROJECT";

    private static final String COL_CATEGORY = "CATEGORY";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_ATTRIBUTE_GUARANTEE = "ATTRIBUTE_GUARANTEE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PROJECT_NAME, COL_START_DATE, COL_END_DATE, COL_PROJECT_TITLE, COL_DESCRIPTION, COL_SUB_PROJECT, COL_CATEGORY, COL_PROCESS_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ATTRIBUTE_GUARANTEE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROJECT_NAME, START_DATE, END_DATE, PROJECT_TITLE, DESCRIPTION, SUB_PROJECT, CATEGORY, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROJECT_NAME, START_DATE, END_DATE, PROJECT_TITLE, DESCRIPTION, SUB_PROJECT, CATEGORY, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_PROJECT_NAME, COL_START_DATE, COL_END_DATE, COL_PROJECT_TITLE, COL_DESCRIPTION, COL_SUB_PROJECT, COL_CATEGORY, COL_PROCESS_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ATTRIBUTE_GUARANTEE, COL_ID);

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

    public int insert(Connection conn, FgProjects fgprojects) throws SQLException {
        logger.debug("Inserting fgprojects: {}", fgprojects);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProjectsParams(ps, fgprojects);
            ps.executeUpdate();
            return fgprojects.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProjects> fgprojectss) throws SQLException {
        if (fgprojectss == null || fgprojectss.isEmpty())
            return new int[0];
        for (int i = 0; i < fgprojectss.size(); i++) {
            if (fgprojectss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProjects>> batches = chunkList(fgprojectss, batchSize);
        int[] totalResults = new int[fgprojectss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProjects> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProjects fgprojects : batch) {
                        setFgProjectsParams(ps, fgprojects);
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

    public FgProjects findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProjects> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProjects> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProjects fgprojects) throws SQLException {
        if (fgprojects.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProjectsParams(ps, fgprojects);
            ps.setInt(26, fgprojects.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProjects> fgprojectss) throws SQLException {
        if (fgprojectss == null || fgprojectss.isEmpty())
            return new int[0];
        for (FgProjects fgprojects : fgprojectss) {
            if (fgprojects == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgprojects.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProjects>> batches = chunkList(fgprojectss, batchSize);
        int[] totalResults = new int[fgprojectss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProjects> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProjects fgprojects : batch) {
                        setFgProjectsParams(ps, fgprojects);
                        ps.setInt(26, fgprojects.getID());
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

    private void setFgProjectsParams(PreparedStatement ps, FgProjects fgprojects) throws SQLException {
        Integer val1 = fgprojects.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgprojects.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgprojects.getTypeCode());
        ps.setString(4, fgprojects.getSubTypeCode());
        ps.setString(5, fgprojects.getActiveCode());
        ps.setString(6, fgprojects.getStageCode());
        ps.setString(7, fgprojects.getStatusCode());
        ps.setString(8, fgprojects.getCreatedOn());
        java.math.BigDecimal val9 = fgprojects.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgprojects.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgprojects.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgprojects.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgprojects.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgprojects.getTemplate());
        java.math.BigDecimal val15 = fgprojects.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgprojects.getProjectName());
        java.time.LocalDateTime val17 = fgprojects.getStartDate();
        if (val17 != null) {
            ps.setTimestamp(17, java.sql.Timestamp.valueOf(val17));
        } else {
            ps.setNull(17, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val18 = fgprojects.getEndDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        ps.setString(19, fgprojects.getProjectTitle());
        ps.setString(20, fgprojects.getDescription());
        ps.setString(21, fgprojects.getSubProject());
        ps.setString(22, fgprojects.getCategory());
        Integer val23 = fgprojects.getProcessID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fgprojects.getVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.math.BigDecimal val25 = fgprojects.getIsMasterVersion();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgprojects.getAttributeGuarantee());
    }

    private FgProjects extract(ResultSet rs) throws SQLException {
        FgProjects fgprojects = new FgProjects();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgprojects.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgprojects.setReferenceID(REFERENCE_ID);
        fgprojects.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgprojects.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgprojects.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgprojects.setStageCode(rs.getString(COL_STAGE_CODE));
        fgprojects.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgprojects.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgprojects.setCreatedBy(CREATED_BY);
        fgprojects.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgprojects.setLastUpdatedBy(LAST_UPDATED_BY);
        fgprojects.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgprojects.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgprojects.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgprojects.setIsTemplate(IS_TEMPLATE);
        fgprojects.setProjectName(rs.getString(COL_PROJECT_NAME));
        Timestamp START_DATE = rs.getTimestamp(COL_START_DATE);
        if (START_DATE != null)
            fgprojects.setStartDate(START_DATE.toLocalDateTime());
        Timestamp END_DATE = rs.getTimestamp(COL_END_DATE);
        if (END_DATE != null)
            fgprojects.setEndDate(END_DATE.toLocalDateTime());
        fgprojects.setProjectTitle(rs.getString(COL_PROJECT_TITLE));
        fgprojects.setDescription(rs.getString(COL_DESCRIPTION));
        fgprojects.setSubProject(rs.getString(COL_SUB_PROJECT));
        fgprojects.setCategory(rs.getString(COL_CATEGORY));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgprojects.setProcessID(PROCESS_ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgprojects.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgprojects.setIsMasterVersion(IS_MASTER_VERSION);
        fgprojects.setAttributeGuarantee(rs.getString(COL_ATTRIBUTE_GUARANTEE));
        return fgprojects;
    }
}
