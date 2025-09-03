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

public class JdbcFgSettingFlagDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSettingFlagDao.class);

    private static final String TABLE = "FG_SETTING_FLAG";

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

    private static final String COL_SETTING_NAME = "SETTING_NAME";

    private static final String COL_SETTING_KEY = "SETTING_KEY";

    private static final String COL_SETTING_CODE = "SETTING_CODE";

    private static final String COL_SETTING_DESCRIPTION = "SETTING_DESCRIPTION";

    private static final String COL_SETTING_TAG = "SETTING_TAG";

    private static final String COL_OWNER_PARTY_CODE = "OWNER_PARTY_CODE";

    private static final String COL_ENTITY_SUB_TYPE = "ENTITY_SUB_TYPE";

    private static final String COL_SETTING_ENVIRONMENT = "SETTING_ENVIRONMENT";

    private static final String COL_APPLICATION_TYPE = "APPLICATION_TYPE";

    private static final String COL_PROPERTY_TYPE = "PROPERTY_TYPE";

    private static final String COL_SETTING_STATUS = "SETTING_STATUS";

    private static final String COL_SETTING_VALUE = "SETTING_VALUE";

    private static final String COL_SETTING_DEFAULT_VALUE = "SETTING_DEFAULT_VALUE";

    private static final String COL_ENCRYPTIONFLAG = "ENCRYPTIONFLAG";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_DEPLOYMENT_STATUS = "DEPLOYMENT_STATUS";

    private static final String COL_PROGRAM_SELECT = "PROGRAM_SELECT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SETTING_NAME, COL_SETTING_KEY, COL_SETTING_CODE, COL_SETTING_DESCRIPTION, COL_SETTING_TAG, COL_OWNER_PARTY_CODE, COL_ENTITY_SUB_TYPE, COL_SETTING_ENVIRONMENT, COL_APPLICATION_TYPE, COL_PROPERTY_TYPE, COL_SETTING_STATUS, COL_SETTING_VALUE, COL_SETTING_DEFAULT_VALUE, COL_ENCRYPTIONFLAG, COL_PROCESS_ID, COL_DEPLOYMENT_STATUS, COL_PROGRAM_SELECT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SETTING_NAME, SETTING_KEY, SETTING_CODE, SETTING_DESCRIPTION, SETTING_TAG, OWNER_PARTY_CODE, ENTITY_SUB_TYPE, SETTING_ENVIRONMENT, APPLICATION_TYPE, PROPERTY_TYPE, SETTING_STATUS, SETTING_VALUE, SETTING_DEFAULT_VALUE, ENCRYPTIONFLAG, PROCESS_ID, DEPLOYMENT_STATUS, PROGRAM_SELECT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SETTING_NAME, SETTING_KEY, SETTING_CODE, SETTING_DESCRIPTION, SETTING_TAG, OWNER_PARTY_CODE, ENTITY_SUB_TYPE, SETTING_ENVIRONMENT, APPLICATION_TYPE, PROPERTY_TYPE, SETTING_STATUS, SETTING_VALUE, SETTING_DEFAULT_VALUE, ENCRYPTIONFLAG, PROCESS_ID, DEPLOYMENT_STATUS, PROGRAM_SELECT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_SETTING_NAME, COL_SETTING_KEY, COL_SETTING_CODE, COL_SETTING_DESCRIPTION, COL_SETTING_TAG, COL_OWNER_PARTY_CODE, COL_ENTITY_SUB_TYPE, COL_SETTING_ENVIRONMENT, COL_APPLICATION_TYPE, COL_PROPERTY_TYPE, COL_SETTING_STATUS, COL_SETTING_VALUE, COL_SETTING_DEFAULT_VALUE, COL_ENCRYPTIONFLAG, COL_PROCESS_ID, COL_DEPLOYMENT_STATUS, COL_PROGRAM_SELECT, COL_ID);

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

    public int insert(Connection conn, FgSettingFlag fgsettingflag) throws SQLException {
        logger.debug("Inserting fgsettingflag: {}", fgsettingflag);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSettingFlagParams(ps, fgsettingflag);
            ps.executeUpdate();
            return fgsettingflag.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSettingFlag> fgsettingflags) throws SQLException {
        if (fgsettingflags == null || fgsettingflags.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsettingflags.size(); i++) {
            if (fgsettingflags.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettingFlag>> batches = chunkList(fgsettingflags, batchSize);
        int[] totalResults = new int[fgsettingflags.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettingFlag> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSettingFlag fgsettingflag : batch) {
                        setFgSettingFlagParams(ps, fgsettingflag);
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

    public FgSettingFlag findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSettingFlag> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSettingFlag> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSettingFlag fgsettingflag) throws SQLException {
        if (fgsettingflag.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSettingFlagParams(ps, fgsettingflag);
            ps.setInt(32, fgsettingflag.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSettingFlag> fgsettingflags) throws SQLException {
        if (fgsettingflags == null || fgsettingflags.isEmpty())
            return new int[0];
        for (FgSettingFlag fgsettingflag : fgsettingflags) {
            if (fgsettingflag == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsettingflag.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettingFlag>> batches = chunkList(fgsettingflags, batchSize);
        int[] totalResults = new int[fgsettingflags.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettingFlag> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSettingFlag fgsettingflag : batch) {
                        setFgSettingFlagParams(ps, fgsettingflag);
                        ps.setInt(32, fgsettingflag.getID());
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

    private void setFgSettingFlagParams(PreparedStatement ps, FgSettingFlag fgsettingflag) throws SQLException {
        Integer val1 = fgsettingflag.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsettingflag.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsettingflag.getTypeCode());
        ps.setString(4, fgsettingflag.getSubTypeCode());
        ps.setString(5, fgsettingflag.getActiveCode());
        ps.setString(6, fgsettingflag.getStageCode());
        ps.setString(7, fgsettingflag.getStatusCode());
        ps.setString(8, fgsettingflag.getCreatedOn());
        java.math.BigDecimal val9 = fgsettingflag.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgsettingflag.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgsettingflag.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgsettingflag.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgsettingflag.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgsettingflag.getTemplate());
        java.math.BigDecimal val15 = fgsettingflag.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgsettingflag.getSettingName());
        ps.setString(17, fgsettingflag.getSettingKey());
        ps.setString(18, fgsettingflag.getSettingCode());
        ps.setString(19, fgsettingflag.getSettingDescription());
        ps.setString(20, fgsettingflag.getSettingTag());
        ps.setString(21, fgsettingflag.getOwnerPartyCode());
        ps.setString(22, fgsettingflag.getEntitySubType());
        ps.setString(23, fgsettingflag.getSettingEnvironment());
        ps.setString(24, fgsettingflag.getApplicationType());
        ps.setString(25, fgsettingflag.getPropertyType());
        ps.setString(26, fgsettingflag.getSettingStatus());
        ps.setString(27, fgsettingflag.getSettingValue());
        ps.setString(28, fgsettingflag.getSettingDefaultValue());
        ps.setString(29, fgsettingflag.getEncryptionflag());
        Integer val30 = fgsettingflag.getProcessID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        ps.setString(31, fgsettingflag.getDeploymentStatus());
        ps.setString(32, fgsettingflag.getProgramSelect());
    }

    private FgSettingFlag extract(ResultSet rs) throws SQLException {
        FgSettingFlag fgsettingflag = new FgSettingFlag();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsettingflag.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsettingflag.setReferenceID(REFERENCE_ID);
        fgsettingflag.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsettingflag.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsettingflag.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsettingflag.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsettingflag.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgsettingflag.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsettingflag.setCreatedBy(CREATED_BY);
        fgsettingflag.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsettingflag.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsettingflag.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsettingflag.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsettingflag.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsettingflag.setIsTemplate(IS_TEMPLATE);
        fgsettingflag.setSettingName(rs.getString(COL_SETTING_NAME));
        fgsettingflag.setSettingKey(rs.getString(COL_SETTING_KEY));
        fgsettingflag.setSettingCode(rs.getString(COL_SETTING_CODE));
        fgsettingflag.setSettingDescription(rs.getString(COL_SETTING_DESCRIPTION));
        fgsettingflag.setSettingTag(rs.getString(COL_SETTING_TAG));
        fgsettingflag.setOwnerPartyCode(rs.getString(COL_OWNER_PARTY_CODE));
        fgsettingflag.setEntitySubType(rs.getString(COL_ENTITY_SUB_TYPE));
        fgsettingflag.setSettingEnvironment(rs.getString(COL_SETTING_ENVIRONMENT));
        fgsettingflag.setApplicationType(rs.getString(COL_APPLICATION_TYPE));
        fgsettingflag.setPropertyType(rs.getString(COL_PROPERTY_TYPE));
        fgsettingflag.setSettingStatus(rs.getString(COL_SETTING_STATUS));
        fgsettingflag.setSettingValue(rs.getString(COL_SETTING_VALUE));
        fgsettingflag.setSettingDefaultValue(rs.getString(COL_SETTING_DEFAULT_VALUE));
        fgsettingflag.setEncryptionflag(rs.getString(COL_ENCRYPTIONFLAG));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgsettingflag.setProcessID(PROCESS_ID);
        fgsettingflag.setDeploymentStatus(rs.getString(COL_DEPLOYMENT_STATUS));
        fgsettingflag.setProgramSelect(rs.getString(COL_PROGRAM_SELECT));
        return fgsettingflag;
    }
}
