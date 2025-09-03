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

public class JdbcFgPartyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyDao.class);

    private static final String TABLE = "FG_PARTY";

    private static final String COL_ID = "ID";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_ISO_CODE = "ISO_CODE";

    private static final String COL_LANGUAGE_CODE = "LANGUAGE_CODE";

    private static final String COL_NAME = "NAME";

    private static final String COL_TIME_ZONE_CODE = "TIME_ZONE_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_ABBV_NAME = "ABBV_NAME";

    private static final String COL_CURRENCY_CODE = "CURRENCY_CODE";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_CONFIG_STATUS_CODE = "CONFIG_STATUS_CODE";

    private static final String COL_OWNER_PARTY_CODE = "OWNER_PARTY_CODE";

    private static final String COL_ADDL_CODE_01 = "ADDL_CODE_01";

    private static final String COL_ADDL_CODE_02 = "ADDL_CODE_02";

    private static final String COL_ADDL_CODE_03 = "ADDL_CODE_03";

    private static final String COL_ADDL_CODE_04 = "ADDL_CODE_04";

    private static final String COL_ADDL_CODE_05 = "ADDL_CODE_05";

    private static final String COL_ADDL_CODE_06 = "ADDL_CODE_06";

    private static final String COL_ADDL_CODE_07 = "ADDL_CODE_07";

    private static final String COL_ADDL_CODE_08 = "ADDL_CODE_08";

    private static final String COL_ADDL_CODE_09 = "ADDL_CODE_09";

    private static final String COL_ADDL_CODE_10 = "ADDL_CODE_10";

    private static final String COL_ADDL_CODE_11 = "ADDL_CODE_11";

    private static final String COL_ADDL_CODE_12 = "ADDL_CODE_12";

    private static final String COL_ADDL_CODE_13 = "ADDL_CODE_13";

    private static final String COL_ADDL_CODE_14 = "ADDL_CODE_14";

    private static final String COL_ADDL_CODE_15 = "ADDL_CODE_15";

    private static final String COL_ADDL_CODE_16 = "ADDL_CODE_16";

    private static final String COL_ADDL_CODE_17 = "ADDL_CODE_17";

    private static final String COL_ADDL_CODE_18 = "ADDL_CODE_18";

    private static final String COL_ADDL_CODE_19 = "ADDL_CODE_19";

    private static final String COL_ADDL_CODE_20 = "ADDL_CODE_20";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_BRANCH_NAME = "BRANCH_NAME";

    private static final String COL_BRANCH_CODE = "BRANCH_CODE";

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_DEMOCRACY_TYPE_CODE = "DEMOCRACY_TYPE_CODE";

    private static final String COL_DEMOCRACY_SUB_TYPE_CODE = "DEMOCRACY_SUB_TYPE_CODE";

    private static final String COL_CONSTITUTION_TYPE_CODE = "CONSTITUTION_TYPE_CODE";

    private static final String COL_PARENT_PARTY_CODE = "PARENT_PARTY_CODE";

    private static final String COL_SYSTEM_SOURCE_CODE = "SYSTEM_SOURCE_CODE";

    private static final String COL_EMP_CODE = "EMP_CODE";

    private static final String COL_TASK_REASON_CODE = "TASK_REASON_CODE";

    private static final String COL_TASK_REASON_TEXT = "TASK_REASON_TEXT";

    private static final String COL_MASTER_TEMPLATE = "MASTER_TEMPLATE";

    private static final String COL_TRANSACTION_TYPE = "TRANSACTION_TYPE";

    private static final String COL_REG_STATUS = "REG_STATUS";

    private static final String COL_MIGRATION_STATUS_CODE = "MIGRATION_STATUS_CODE";

    private static final String COL_MIGRATION_SYS_CODE = "MIGRATION_SYS_CODE";

    private static final String COL_MIGRATION_SYS_REF_CODE = "MIGRATION_SYS_REF_CODE";

    private static final String COL_MIGRATION_DATETIME = "MIGRATION_DATETIME";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_BO_STATUS_CODE = "BO_STATUS_CODE";

    private static final String COL_BO_STATUS_REFERENCE = "BO_STATUS_REFERENCE";

    private static final String COL_BO_STATUS_REASSON = "BO_STATUS_REASSON";

    private static final String COL_BO_STATUS_MESSAGE = "BO_STATUS_MESSAGE";

    private static final String COL_PORTAL_ENABLEMENT_STATUS_CODE = "PORTAL_ENABLEMENT_STATUS_CODE";

    private static final String COL_CHANNEL = "CHANNEL";

    private static final String COL_CHANNEL_TYPE = "CHANNEL_TYPE";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ISO_CODE, COL_LANGUAGE_CODE, COL_NAME, COL_TIME_ZONE_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_REFERENCE_ID, COL_ABBV_NAME, COL_CURRENCY_CODE, COL_DESCRIPTION, COL_CONFIG_STATUS_CODE, COL_OWNER_PARTY_CODE, COL_ADDL_CODE_01, COL_ADDL_CODE_02, COL_ADDL_CODE_03, COL_ADDL_CODE_04, COL_ADDL_CODE_05, COL_ADDL_CODE_06, COL_ADDL_CODE_07, COL_ADDL_CODE_08, COL_ADDL_CODE_09, COL_ADDL_CODE_10, COL_ADDL_CODE_11, COL_ADDL_CODE_12, COL_ADDL_CODE_13, COL_ADDL_CODE_14, COL_ADDL_CODE_15, COL_ADDL_CODE_16, COL_ADDL_CODE_17, COL_ADDL_CODE_18, COL_ADDL_CODE_19, COL_ADDL_CODE_20, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_BRANCH_NAME, COL_BRANCH_CODE, COL_ATTACHMENT_ID, COL_PARTY_SUB_TYPE_CODE, COL_DEMOCRACY_TYPE_CODE, COL_DEMOCRACY_SUB_TYPE_CODE, COL_CONSTITUTION_TYPE_CODE, COL_PARENT_PARTY_CODE, COL_SYSTEM_SOURCE_CODE, COL_EMP_CODE, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_MASTER_TEMPLATE, COL_TRANSACTION_TYPE, COL_REG_STATUS, COL_MIGRATION_STATUS_CODE, COL_MIGRATION_SYS_CODE, COL_MIGRATION_SYS_REF_CODE, COL_MIGRATION_DATETIME, COL_STAGE_CODE, COL_BO_STATUS_CODE, COL_BO_STATUS_REFERENCE, COL_BO_STATUS_REASSON, COL_BO_STATUS_MESSAGE, COL_PORTAL_ENABLEMENT_STATUS_CODE, COL_CHANNEL, COL_CHANNEL_TYPE, COL_TEMPLATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, UPLOAD_REF_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, CHANNEL, CHANNEL_TYPE, TEMPLATE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, UPLOAD_REF_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, CHANNEL, CHANNEL_TYPE, TEMPLATE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ISO_CODE, COL_LANGUAGE_CODE, COL_NAME, COL_TIME_ZONE_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_REFERENCE_ID, COL_ABBV_NAME, COL_CURRENCY_CODE, COL_DESCRIPTION, COL_CONFIG_STATUS_CODE, COL_OWNER_PARTY_CODE, COL_ADDL_CODE_01, COL_ADDL_CODE_02, COL_ADDL_CODE_03, COL_ADDL_CODE_04, COL_ADDL_CODE_05, COL_ADDL_CODE_06, COL_ADDL_CODE_07, COL_ADDL_CODE_08, COL_ADDL_CODE_09, COL_ADDL_CODE_10, COL_ADDL_CODE_11, COL_ADDL_CODE_12, COL_ADDL_CODE_13, COL_ADDL_CODE_14, COL_ADDL_CODE_15, COL_ADDL_CODE_16, COL_ADDL_CODE_17, COL_ADDL_CODE_18, COL_ADDL_CODE_19, COL_ADDL_CODE_20, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_UPLOAD_REF_ID, COL_BRANCH_NAME, COL_BRANCH_CODE, COL_ATTACHMENT_ID, COL_PARTY_SUB_TYPE_CODE, COL_DEMOCRACY_TYPE_CODE, COL_DEMOCRACY_SUB_TYPE_CODE, COL_CONSTITUTION_TYPE_CODE, COL_PARENT_PARTY_CODE, COL_SYSTEM_SOURCE_CODE, COL_EMP_CODE, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_MASTER_TEMPLATE, COL_TRANSACTION_TYPE, COL_REG_STATUS, COL_MIGRATION_STATUS_CODE, COL_MIGRATION_SYS_CODE, COL_MIGRATION_SYS_REF_CODE, COL_MIGRATION_DATETIME, COL_STAGE_CODE, COL_BO_STATUS_CODE, COL_BO_STATUS_REFERENCE, COL_BO_STATUS_REASSON, COL_BO_STATUS_MESSAGE, COL_PORTAL_ENABLEMENT_STATUS_CODE, COL_CHANNEL, COL_CHANNEL_TYPE, COL_TEMPLATE, COL_ID);

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

    public int insert(Connection conn, FgParty fgparty) throws SQLException {
        logger.debug("Inserting fgparty: {}", fgparty);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyParams(ps, fgparty);
            ps.executeUpdate();
            return fgparty.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgParty> fgpartys) throws SQLException {
        if (fgpartys == null || fgpartys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartys.size(); i++) {
            if (fgpartys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgParty>> batches = chunkList(fgpartys, batchSize);
        int[] totalResults = new int[fgpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgParty fgparty : batch) {
                        setFgPartyParams(ps, fgparty);
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

    public FgParty findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgParty> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgParty> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgParty fgparty) throws SQLException {
        if (fgparty.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyParams(ps, fgparty);
            ps.setInt(73, fgparty.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgParty> fgpartys) throws SQLException {
        if (fgpartys == null || fgpartys.isEmpty())
            return new int[0];
        for (FgParty fgparty : fgpartys) {
            if (fgparty == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgparty.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgParty>> batches = chunkList(fgpartys, batchSize);
        int[] totalResults = new int[fgpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgParty fgparty : batch) {
                        setFgPartyParams(ps, fgparty);
                        ps.setInt(73, fgparty.getID());
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

    private void setFgPartyParams(PreparedStatement ps, FgParty fgparty) throws SQLException {
        Integer val1 = fgparty.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgparty.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.math.BigDecimal val3 = fgparty.getIsMasterVersion();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        ps.setString(4, fgparty.getIsoCode());
        ps.setString(5, fgparty.getLanguageCode());
        ps.setString(6, fgparty.getName());
        ps.setString(7, fgparty.getTimeZoneCode());
        ps.setString(8, fgparty.getTypeCode());
        ps.setString(9, fgparty.getSubTypeCode());
        Integer val10 = fgparty.getReferenceID();
        if (val10 != null) {
            ps.setInt(10, val10);
        } else {
            ps.setNull(10, Types.INTEGER);
        }
        ps.setString(11, fgparty.getAbbvName());
        ps.setString(12, fgparty.getCurrencyCode());
        ps.setString(13, fgparty.getDescription());
        ps.setString(14, fgparty.getConfigStatusCode());
        ps.setString(15, fgparty.getOwnerPartyCode());
        ps.setString(16, fgparty.getAddlCode01());
        ps.setString(17, fgparty.getAddlCode02());
        ps.setString(18, fgparty.getAddlCode03());
        ps.setString(19, fgparty.getAddlCode04());
        ps.setString(20, fgparty.getAddlCode05());
        ps.setString(21, fgparty.getAddlCode06());
        ps.setString(22, fgparty.getAddlCode07());
        ps.setString(23, fgparty.getAddlCode08());
        ps.setString(24, fgparty.getAddlCode09());
        ps.setString(25, fgparty.getAddlCode10());
        ps.setString(26, fgparty.getAddlCode11());
        ps.setString(27, fgparty.getAddlCode12());
        ps.setString(28, fgparty.getAddlCode13());
        ps.setString(29, fgparty.getAddlCode14());
        ps.setString(30, fgparty.getAddlCode15());
        ps.setString(31, fgparty.getAddlCode16());
        ps.setString(32, fgparty.getAddlCode17());
        ps.setString(33, fgparty.getAddlCode18());
        ps.setString(34, fgparty.getAddlCode19());
        ps.setString(35, fgparty.getAddlCode20());
        ps.setString(36, fgparty.getActiveCode());
        ps.setString(37, fgparty.getStatusCode());
        ps.setString(38, fgparty.getCreatedOn());
        java.math.BigDecimal val39 = fgparty.getCreatedBy();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, fgparty.getLastUpdatedOn());
        java.math.BigDecimal val41 = fgparty.getLastUpdatedBy();
        if (val41 != null) {
            ps.setBigDecimal(41, val41);
        } else {
            ps.setNull(41, Types.DECIMAL);
        }
        ps.setString(42, fgparty.getLastAuthorisedOn());
        java.math.BigDecimal val43 = fgparty.getLastAuthorisedBy();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
        Integer val44 = fgparty.getProcessID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        Integer val45 = fgparty.getUploadRefID();
        if (val45 != null) {
            ps.setInt(45, val45);
        } else {
            ps.setNull(45, Types.INTEGER);
        }
        ps.setString(46, fgparty.getBranchName());
        ps.setString(47, fgparty.getBranchCode());
        Integer val48 = fgparty.getAttachmentID();
        if (val48 != null) {
            ps.setInt(48, val48);
        } else {
            ps.setNull(48, Types.INTEGER);
        }
        ps.setString(49, fgparty.getPartySubTypeCode());
        ps.setString(50, fgparty.getDemocracyTypeCode());
        ps.setString(51, fgparty.getDemocracySubTypeCode());
        ps.setString(52, fgparty.getConstitutionTypeCode());
        ps.setString(53, fgparty.getParentPartyCode());
        ps.setString(54, fgparty.getSystemSourceCode());
        ps.setString(55, fgparty.getEmpCode());
        ps.setString(56, fgparty.getTaskReasonCode());
        ps.setString(57, fgparty.getTaskReasonText());
        ps.setString(58, fgparty.getMasterTemplate());
        ps.setString(59, fgparty.getTransactionType());
        ps.setString(60, fgparty.getRegStatus());
        ps.setString(61, fgparty.getMigrationStatusCode());
        ps.setString(62, fgparty.getMigrationSysCode());
        ps.setString(63, fgparty.getMigrationSysRefCode());
        ps.setString(64, fgparty.getMigrationDatetime());
        ps.setString(65, fgparty.getStageCode());
        ps.setString(66, fgparty.getBoStatusCode());
        ps.setString(67, fgparty.getBoStatusReference());
        ps.setString(68, fgparty.getBoStatusReasson());
        ps.setString(69, fgparty.getBoStatusMessage());
        ps.setString(70, fgparty.getPortalEnablementStatusCode());
        ps.setString(71, fgparty.getChannel());
        ps.setString(72, fgparty.getChannelType());
        ps.setString(73, fgparty.getTemplate());
    }

    private FgParty extract(ResultSet rs) throws SQLException {
        FgParty fgparty = new FgParty();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgparty.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgparty.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgparty.setIsMasterVersion(IS_MASTER_VERSION);
        fgparty.setIsoCode(rs.getString(COL_ISO_CODE));
        fgparty.setLanguageCode(rs.getString(COL_LANGUAGE_CODE));
        fgparty.setName(rs.getString(COL_NAME));
        fgparty.setTimeZoneCode(rs.getString(COL_TIME_ZONE_CODE));
        fgparty.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgparty.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgparty.setReferenceID(REFERENCE_ID);
        fgparty.setAbbvName(rs.getString(COL_ABBV_NAME));
        fgparty.setCurrencyCode(rs.getString(COL_CURRENCY_CODE));
        fgparty.setDescription(rs.getString(COL_DESCRIPTION));
        fgparty.setConfigStatusCode(rs.getString(COL_CONFIG_STATUS_CODE));
        fgparty.setOwnerPartyCode(rs.getString(COL_OWNER_PARTY_CODE));
        fgparty.setAddlCode01(rs.getString(COL_ADDL_CODE_01));
        fgparty.setAddlCode02(rs.getString(COL_ADDL_CODE_02));
        fgparty.setAddlCode03(rs.getString(COL_ADDL_CODE_03));
        fgparty.setAddlCode04(rs.getString(COL_ADDL_CODE_04));
        fgparty.setAddlCode05(rs.getString(COL_ADDL_CODE_05));
        fgparty.setAddlCode06(rs.getString(COL_ADDL_CODE_06));
        fgparty.setAddlCode07(rs.getString(COL_ADDL_CODE_07));
        fgparty.setAddlCode08(rs.getString(COL_ADDL_CODE_08));
        fgparty.setAddlCode09(rs.getString(COL_ADDL_CODE_09));
        fgparty.setAddlCode10(rs.getString(COL_ADDL_CODE_10));
        fgparty.setAddlCode11(rs.getString(COL_ADDL_CODE_11));
        fgparty.setAddlCode12(rs.getString(COL_ADDL_CODE_12));
        fgparty.setAddlCode13(rs.getString(COL_ADDL_CODE_13));
        fgparty.setAddlCode14(rs.getString(COL_ADDL_CODE_14));
        fgparty.setAddlCode15(rs.getString(COL_ADDL_CODE_15));
        fgparty.setAddlCode16(rs.getString(COL_ADDL_CODE_16));
        fgparty.setAddlCode17(rs.getString(COL_ADDL_CODE_17));
        fgparty.setAddlCode18(rs.getString(COL_ADDL_CODE_18));
        fgparty.setAddlCode19(rs.getString(COL_ADDL_CODE_19));
        fgparty.setAddlCode20(rs.getString(COL_ADDL_CODE_20));
        fgparty.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgparty.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgparty.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgparty.setCreatedBy(CREATED_BY);
        fgparty.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgparty.setLastUpdatedBy(LAST_UPDATED_BY);
        fgparty.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgparty.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgparty.setProcessID(PROCESS_ID);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgparty.setUploadRefID(UPLOAD_REF_ID);
        fgparty.setBranchName(rs.getString(COL_BRANCH_NAME));
        fgparty.setBranchCode(rs.getString(COL_BRANCH_CODE));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgparty.setAttachmentID(ATTACHMENT_ID);
        fgparty.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgparty.setDemocracyTypeCode(rs.getString(COL_DEMOCRACY_TYPE_CODE));
        fgparty.setDemocracySubTypeCode(rs.getString(COL_DEMOCRACY_SUB_TYPE_CODE));
        fgparty.setConstitutionTypeCode(rs.getString(COL_CONSTITUTION_TYPE_CODE));
        fgparty.setParentPartyCode(rs.getString(COL_PARENT_PARTY_CODE));
        fgparty.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        fgparty.setEmpCode(rs.getString(COL_EMP_CODE));
        fgparty.setTaskReasonCode(rs.getString(COL_TASK_REASON_CODE));
        fgparty.setTaskReasonText(rs.getString(COL_TASK_REASON_TEXT));
        fgparty.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        fgparty.setTransactionType(rs.getString(COL_TRANSACTION_TYPE));
        fgparty.setRegStatus(rs.getString(COL_REG_STATUS));
        fgparty.setMigrationStatusCode(rs.getString(COL_MIGRATION_STATUS_CODE));
        fgparty.setMigrationSysCode(rs.getString(COL_MIGRATION_SYS_CODE));
        fgparty.setMigrationSysRefCode(rs.getString(COL_MIGRATION_SYS_REF_CODE));
        fgparty.setMigrationDatetime(rs.getString(COL_MIGRATION_DATETIME));
        fgparty.setStageCode(rs.getString(COL_STAGE_CODE));
        fgparty.setBoStatusCode(rs.getString(COL_BO_STATUS_CODE));
        fgparty.setBoStatusReference(rs.getString(COL_BO_STATUS_REFERENCE));
        fgparty.setBoStatusReasson(rs.getString(COL_BO_STATUS_REASSON));
        fgparty.setBoStatusMessage(rs.getString(COL_BO_STATUS_MESSAGE));
        fgparty.setPortalEnablementStatusCode(rs.getString(COL_PORTAL_ENABLEMENT_STATUS_CODE));
        fgparty.setChannel(rs.getString(COL_CHANNEL));
        fgparty.setChannelType(rs.getString(COL_CHANNEL_TYPE));
        fgparty.setTemplate(rs.getString(COL_TEMPLATE));
        return fgparty;
    }
}
