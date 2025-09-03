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

public class JdbcFgOrganizationPartyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgOrganizationPartyDao.class);

    private static final String TABLE = "FG_ORGANIZATION_PARTY";

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

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

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

    private static final String COL_UUID = "UUID";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_ORGANIZATION_TYPE = "ORGANIZATION_TYPE";

    private static final String COL_PARTY_LINK_TYPE = "PARTY_LINK_TYPE";

    private static final String COL_PARENT_LINK_TYPE = "PARENT_LINK_TYPE";

    private static final String COL_MOBILE_NUMBER = "MOBILE_NUMBER";

    private static final String COL_EMAIL_ID = "EMAIL_ID";

    private static final String COL_FIRST_NAME = "FIRST_NAME";

    private static final String COL_LAST_NAME = "LAST_NAME";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_GENDER = "GENDER";

    private static final String COL_CUSTOMER_ID = "CUSTOMER_ID";

    private static final String COL_DOB = "DOB";

    private static final String COL_CURRENT_ADDRESS = "CURRENT_ADDRESS";

    private static final String COL_LICENSE_NO = "LICENSE_NO";

    private static final String COL_PAN_NO = "PAN_NO";

    private static final String COL_ADDRESS1 = "ADDRESS1";

    private static final String COL_ADDRESS2 = "ADDRESS2";

    private static final String COL_CITY_CODE = "CITY_CODE";

    private static final String COL_COUNTRY = "COUNTRY";

    private static final String COL_PIN_CODE = "PIN_CODE";

    private static final String COL_IDENTIFIER_SUB_TYPE_CODE = "IDENTIFIER_SUB_TYPE_CODE";

    private static final String COL_IDENTITY_NO = "IDENTITY_NO";

    private static final String COL_ISSUER_CODE = "ISSUER_CODE";

    private static final String COL_ISSUER_NAME = "ISSUER_NAME";

    private static final String COL_ROLE_CODE = "ROLE_CODE";

    private static final String COL_PRODUCT_ID = "PRODUCT_ID";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ORG_TYPE_CODE = "ORG_TYPE_CODE";

    private static final String COL_ORG_SUB_TYPE_CODE = "ORG_SUB_TYPE_CODE";

    private static final String COL_USER_ACTION_CODE = "USER_ACTION_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ISO_CODE, COL_LANGUAGE_CODE, COL_NAME, COL_TIME_ZONE_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_REFERENCE_ID, COL_ABBV_NAME, COL_CURRENCY_CODE, COL_DESCRIPTION, COL_CONFIG_STATUS_CODE, COL_OWNER_PARTY_CODE, COL_ADDL_CODE_01, COL_ADDL_CODE_02, COL_ADDL_CODE_03, COL_ADDL_CODE_04, COL_ADDL_CODE_05, COL_ADDL_CODE_06, COL_ADDL_CODE_07, COL_ADDL_CODE_08, COL_ADDL_CODE_09, COL_ADDL_CODE_10, COL_ADDL_CODE_11, COL_ADDL_CODE_12, COL_ADDL_CODE_13, COL_ADDL_CODE_14, COL_ADDL_CODE_15, COL_ADDL_CODE_16, COL_ADDL_CODE_17, COL_ADDL_CODE_18, COL_ADDL_CODE_19, COL_ADDL_CODE_20, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_BRANCH_NAME, COL_BRANCH_CODE, COL_ATTACHMENT_ID, COL_PARTY_SUB_TYPE_CODE, COL_DEMOCRACY_TYPE_CODE, COL_DEMOCRACY_SUB_TYPE_CODE, COL_CONSTITUTION_TYPE_CODE, COL_PARENT_PARTY_CODE, COL_SYSTEM_SOURCE_CODE, COL_EMP_CODE, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_MASTER_TEMPLATE, COL_TRANSACTION_TYPE, COL_REG_STATUS, COL_MIGRATION_STATUS_CODE, COL_MIGRATION_SYS_CODE, COL_MIGRATION_SYS_REF_CODE, COL_MIGRATION_DATETIME, COL_STAGE_CODE, COL_BO_STATUS_CODE, COL_BO_STATUS_REFERENCE, COL_BO_STATUS_REASSON, COL_BO_STATUS_MESSAGE, COL_PORTAL_ENABLEMENT_STATUS_CODE, COL_UUID, COL_UPLOAD_REF_ID, COL_ORGANIZATION_TYPE, COL_PARTY_LINK_TYPE, COL_PARENT_LINK_TYPE, COL_MOBILE_NUMBER, COL_EMAIL_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_APPLICANT_PARTY, COL_GENDER, COL_CUSTOMER_ID, COL_DOB, COL_CURRENT_ADDRESS, COL_LICENSE_NO, COL_PAN_NO, COL_ADDRESS1, COL_ADDRESS2, COL_CITY_CODE, COL_COUNTRY, COL_PIN_CODE, COL_IDENTIFIER_SUB_TYPE_CODE, COL_IDENTITY_NO, COL_ISSUER_CODE, COL_ISSUER_NAME, COL_ROLE_CODE, COL_PRODUCT_ID, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORG_TYPE_CODE, COL_ORG_SUB_TYPE_CODE, COL_USER_ACTION_CODE, COL_ACTIVE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, UUID, UPLOAD_REF_ID, ORGANIZATION_TYPE, PARTY_LINK_TYPE, PARENT_LINK_TYPE, MOBILE_NUMBER, EMAIL_ID, FIRST_NAME, LAST_NAME, APPLICANT_PARTY, GENDER, CUSTOMER_ID, DOB, CURRENT_ADDRESS, LICENSE_NO, PAN_NO, ADDRESS1, ADDRESS2, CITY_CODE, COUNTRY, PIN_CODE, IDENTIFIER_SUB_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, ROLE_CODE, PRODUCT_ID, TEMPLATE, IS_TEMPLATE, ORG_TYPE_CODE, ORG_SUB_TYPE_CODE, USER_ACTION_CODE, ACTIVE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, UUID, UPLOAD_REF_ID, ORGANIZATION_TYPE, PARTY_LINK_TYPE, PARENT_LINK_TYPE, MOBILE_NUMBER, EMAIL_ID, FIRST_NAME, LAST_NAME, APPLICANT_PARTY, GENDER, CUSTOMER_ID, DOB, CURRENT_ADDRESS, LICENSE_NO, PAN_NO, ADDRESS1, ADDRESS2, CITY_CODE, COUNTRY, PIN_CODE, IDENTIFIER_SUB_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, ROLE_CODE, PRODUCT_ID, TEMPLATE, IS_TEMPLATE, ORG_TYPE_CODE, ORG_SUB_TYPE_CODE, USER_ACTION_CODE, ACTIVE_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ISO_CODE, COL_LANGUAGE_CODE, COL_NAME, COL_TIME_ZONE_CODE, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_REFERENCE_ID, COL_ABBV_NAME, COL_CURRENCY_CODE, COL_DESCRIPTION, COL_CONFIG_STATUS_CODE, COL_OWNER_PARTY_CODE, COL_ADDL_CODE_01, COL_ADDL_CODE_02, COL_ADDL_CODE_03, COL_ADDL_CODE_04, COL_ADDL_CODE_05, COL_ADDL_CODE_06, COL_ADDL_CODE_07, COL_ADDL_CODE_08, COL_ADDL_CODE_09, COL_ADDL_CODE_10, COL_ADDL_CODE_11, COL_ADDL_CODE_12, COL_ADDL_CODE_13, COL_ADDL_CODE_14, COL_ADDL_CODE_15, COL_ADDL_CODE_16, COL_ADDL_CODE_17, COL_ADDL_CODE_18, COL_ADDL_CODE_19, COL_ADDL_CODE_20, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PROCESS_ID, COL_BRANCH_NAME, COL_BRANCH_CODE, COL_ATTACHMENT_ID, COL_PARTY_SUB_TYPE_CODE, COL_DEMOCRACY_TYPE_CODE, COL_DEMOCRACY_SUB_TYPE_CODE, COL_CONSTITUTION_TYPE_CODE, COL_PARENT_PARTY_CODE, COL_SYSTEM_SOURCE_CODE, COL_EMP_CODE, COL_TASK_REASON_CODE, COL_TASK_REASON_TEXT, COL_MASTER_TEMPLATE, COL_TRANSACTION_TYPE, COL_REG_STATUS, COL_MIGRATION_STATUS_CODE, COL_MIGRATION_SYS_CODE, COL_MIGRATION_SYS_REF_CODE, COL_MIGRATION_DATETIME, COL_STAGE_CODE, COL_BO_STATUS_CODE, COL_BO_STATUS_REFERENCE, COL_BO_STATUS_REASSON, COL_BO_STATUS_MESSAGE, COL_PORTAL_ENABLEMENT_STATUS_CODE, COL_UUID, COL_UPLOAD_REF_ID, COL_ORGANIZATION_TYPE, COL_PARTY_LINK_TYPE, COL_PARENT_LINK_TYPE, COL_MOBILE_NUMBER, COL_EMAIL_ID, COL_FIRST_NAME, COL_LAST_NAME, COL_APPLICANT_PARTY, COL_GENDER, COL_CUSTOMER_ID, COL_DOB, COL_CURRENT_ADDRESS, COL_LICENSE_NO, COL_PAN_NO, COL_ADDRESS1, COL_ADDRESS2, COL_CITY_CODE, COL_COUNTRY, COL_PIN_CODE, COL_IDENTIFIER_SUB_TYPE_CODE, COL_IDENTITY_NO, COL_ISSUER_CODE, COL_ISSUER_NAME, COL_ROLE_CODE, COL_PRODUCT_ID, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORG_TYPE_CODE, COL_ORG_SUB_TYPE_CODE, COL_USER_ACTION_CODE, COL_ACTIVE_CODE, COL_ID);

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

    public int insert(Connection conn, FgOrganizationParty fgorganizationparty) throws SQLException {
        logger.debug("Inserting fgorganizationparty: {}", fgorganizationparty);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgOrganizationPartyParams(ps, fgorganizationparty);
            ps.executeUpdate();
            return fgorganizationparty.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgOrganizationParty> fgorganizationpartys) throws SQLException {
        if (fgorganizationpartys == null || fgorganizationpartys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgorganizationpartys.size(); i++) {
            if (fgorganizationpartys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrganizationParty>> batches = chunkList(fgorganizationpartys, batchSize);
        int[] totalResults = new int[fgorganizationpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrganizationParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgOrganizationParty fgorganizationparty : batch) {
                        setFgOrganizationPartyParams(ps, fgorganizationparty);
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

    public FgOrganizationParty findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgOrganizationParty> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgOrganizationParty> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgOrganizationParty fgorganizationparty) throws SQLException {
        if (fgorganizationparty.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgOrganizationPartyParams(ps, fgorganizationparty);
            ps.setInt(101, fgorganizationparty.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgOrganizationParty> fgorganizationpartys) throws SQLException {
        if (fgorganizationpartys == null || fgorganizationpartys.isEmpty())
            return new int[0];
        for (FgOrganizationParty fgorganizationparty : fgorganizationpartys) {
            if (fgorganizationparty == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgorganizationparty.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrganizationParty>> batches = chunkList(fgorganizationpartys, batchSize);
        int[] totalResults = new int[fgorganizationpartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrganizationParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgOrganizationParty fgorganizationparty : batch) {
                        setFgOrganizationPartyParams(ps, fgorganizationparty);
                        ps.setInt(101, fgorganizationparty.getID());
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

    private void setFgOrganizationPartyParams(PreparedStatement ps, FgOrganizationParty fgorganizationparty) throws SQLException {
        Integer val1 = fgorganizationparty.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgorganizationparty.getVersionID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.math.BigDecimal val3 = fgorganizationparty.getIsMasterVersion();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        ps.setString(4, fgorganizationparty.getIsoCode());
        ps.setString(5, fgorganizationparty.getLanguageCode());
        ps.setString(6, fgorganizationparty.getName());
        ps.setString(7, fgorganizationparty.getTimeZoneCode());
        ps.setString(8, fgorganizationparty.getTypeCode());
        ps.setString(9, fgorganizationparty.getSubTypeCode());
        Integer val10 = fgorganizationparty.getReferenceID();
        if (val10 != null) {
            ps.setInt(10, val10);
        } else {
            ps.setNull(10, Types.INTEGER);
        }
        ps.setString(11, fgorganizationparty.getAbbvName());
        ps.setString(12, fgorganizationparty.getCurrencyCode());
        ps.setString(13, fgorganizationparty.getDescription());
        ps.setString(14, fgorganizationparty.getConfigStatusCode());
        ps.setString(15, fgorganizationparty.getOwnerPartyCode());
        ps.setString(16, fgorganizationparty.getAddlCode01());
        ps.setString(17, fgorganizationparty.getAddlCode02());
        ps.setString(18, fgorganizationparty.getAddlCode03());
        ps.setString(19, fgorganizationparty.getAddlCode04());
        ps.setString(20, fgorganizationparty.getAddlCode05());
        ps.setString(21, fgorganizationparty.getAddlCode06());
        ps.setString(22, fgorganizationparty.getAddlCode07());
        ps.setString(23, fgorganizationparty.getAddlCode08());
        ps.setString(24, fgorganizationparty.getAddlCode09());
        ps.setString(25, fgorganizationparty.getAddlCode10());
        ps.setString(26, fgorganizationparty.getAddlCode11());
        ps.setString(27, fgorganizationparty.getAddlCode12());
        ps.setString(28, fgorganizationparty.getAddlCode13());
        ps.setString(29, fgorganizationparty.getAddlCode14());
        ps.setString(30, fgorganizationparty.getAddlCode15());
        ps.setString(31, fgorganizationparty.getAddlCode16());
        ps.setString(32, fgorganizationparty.getAddlCode17());
        ps.setString(33, fgorganizationparty.getAddlCode18());
        ps.setString(34, fgorganizationparty.getAddlCode19());
        ps.setString(35, fgorganizationparty.getAddlCode20());
        ps.setString(36, fgorganizationparty.getStatusCode());
        ps.setString(37, fgorganizationparty.getCreatedOn());
        java.math.BigDecimal val38 = fgorganizationparty.getCreatedBy();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        ps.setString(39, fgorganizationparty.getLastUpdatedOn());
        java.math.BigDecimal val40 = fgorganizationparty.getLastUpdatedBy();
        if (val40 != null) {
            ps.setBigDecimal(40, val40);
        } else {
            ps.setNull(40, Types.DECIMAL);
        }
        ps.setString(41, fgorganizationparty.getLastAuthorisedOn());
        java.math.BigDecimal val42 = fgorganizationparty.getLastAuthorisedBy();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        Integer val43 = fgorganizationparty.getProcessID();
        if (val43 != null) {
            ps.setInt(43, val43);
        } else {
            ps.setNull(43, Types.INTEGER);
        }
        ps.setString(44, fgorganizationparty.getBranchName());
        ps.setString(45, fgorganizationparty.getBranchCode());
        Integer val46 = fgorganizationparty.getAttachmentID();
        if (val46 != null) {
            ps.setInt(46, val46);
        } else {
            ps.setNull(46, Types.INTEGER);
        }
        ps.setString(47, fgorganizationparty.getPartySubTypeCode());
        ps.setString(48, fgorganizationparty.getDemocracyTypeCode());
        ps.setString(49, fgorganizationparty.getDemocracySubTypeCode());
        ps.setString(50, fgorganizationparty.getConstitutionTypeCode());
        ps.setString(51, fgorganizationparty.getParentPartyCode());
        ps.setString(52, fgorganizationparty.getSystemSourceCode());
        ps.setString(53, fgorganizationparty.getEmpCode());
        ps.setString(54, fgorganizationparty.getTaskReasonCode());
        ps.setString(55, fgorganizationparty.getTaskReasonText());
        ps.setString(56, fgorganizationparty.getMasterTemplate());
        ps.setString(57, fgorganizationparty.getTransactionType());
        ps.setString(58, fgorganizationparty.getRegStatus());
        ps.setString(59, fgorganizationparty.getMigrationStatusCode());
        ps.setString(60, fgorganizationparty.getMigrationSysCode());
        ps.setString(61, fgorganizationparty.getMigrationSysRefCode());
        ps.setString(62, fgorganizationparty.getMigrationDatetime());
        ps.setString(63, fgorganizationparty.getStageCode());
        ps.setString(64, fgorganizationparty.getBoStatusCode());
        ps.setString(65, fgorganizationparty.getBoStatusReference());
        ps.setString(66, fgorganizationparty.getBoStatusReasson());
        ps.setString(67, fgorganizationparty.getBoStatusMessage());
        ps.setString(68, fgorganizationparty.getPortalEnablementStatusCode());
        ps.setString(69, fgorganizationparty.getUuid());
        Integer val70 = fgorganizationparty.getUploadRefID();
        if (val70 != null) {
            ps.setInt(70, val70);
        } else {
            ps.setNull(70, Types.INTEGER);
        }
        ps.setString(71, fgorganizationparty.getOrganizationType());
        ps.setString(72, fgorganizationparty.getPartyLinkType());
        ps.setString(73, fgorganizationparty.getParentLinkType());
        ps.setString(74, fgorganizationparty.getMobileNumber());
        Integer val75 = fgorganizationparty.getEmailID();
        if (val75 != null) {
            ps.setInt(75, val75);
        } else {
            ps.setNull(75, Types.INTEGER);
        }
        ps.setString(76, fgorganizationparty.getFirstName());
        ps.setString(77, fgorganizationparty.getLastName());
        ps.setString(78, fgorganizationparty.getApplicantParty());
        ps.setString(79, fgorganizationparty.getGender());
        Integer val80 = fgorganizationparty.getCustomerID();
        if (val80 != null) {
            ps.setInt(80, val80);
        } else {
            ps.setNull(80, Types.INTEGER);
        }
        ps.setString(81, fgorganizationparty.getDob());
        ps.setString(82, fgorganizationparty.getCurrentAddress());
        ps.setString(83, fgorganizationparty.getLicenseNo());
        ps.setString(84, fgorganizationparty.getPanNo());
        ps.setString(85, fgorganizationparty.getAddress1());
        ps.setString(86, fgorganizationparty.getAddress2());
        ps.setString(87, fgorganizationparty.getCityCode());
        ps.setString(88, fgorganizationparty.getCountry());
        ps.setString(89, fgorganizationparty.getPinCode());
        ps.setString(90, fgorganizationparty.getIdentifierSubTypeCode());
        ps.setString(91, fgorganizationparty.getIdentityNo());
        ps.setString(92, fgorganizationparty.getIssuerCode());
        ps.setString(93, fgorganizationparty.getIssuerName());
        ps.setString(94, fgorganizationparty.getRoleCode());
        Integer val95 = fgorganizationparty.getProductID();
        if (val95 != null) {
            ps.setInt(95, val95);
        } else {
            ps.setNull(95, Types.INTEGER);
        }
        ps.setString(96, fgorganizationparty.getTemplate());
        ps.setString(97, fgorganizationparty.getIsTemplate());
        ps.setString(98, fgorganizationparty.getOrgTypeCode());
        ps.setString(99, fgorganizationparty.getOrgSubTypeCode());
        ps.setString(100, fgorganizationparty.getUserActionCode());
        ps.setString(101, fgorganizationparty.getActiveCode());
    }

    private FgOrganizationParty extract(ResultSet rs) throws SQLException {
        FgOrganizationParty fgorganizationparty = new FgOrganizationParty();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgorganizationparty.setID(ID);
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgorganizationparty.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgorganizationparty.setIsMasterVersion(IS_MASTER_VERSION);
        fgorganizationparty.setIsoCode(rs.getString(COL_ISO_CODE));
        fgorganizationparty.setLanguageCode(rs.getString(COL_LANGUAGE_CODE));
        fgorganizationparty.setName(rs.getString(COL_NAME));
        fgorganizationparty.setTimeZoneCode(rs.getString(COL_TIME_ZONE_CODE));
        fgorganizationparty.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgorganizationparty.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgorganizationparty.setReferenceID(REFERENCE_ID);
        fgorganizationparty.setAbbvName(rs.getString(COL_ABBV_NAME));
        fgorganizationparty.setCurrencyCode(rs.getString(COL_CURRENCY_CODE));
        fgorganizationparty.setDescription(rs.getString(COL_DESCRIPTION));
        fgorganizationparty.setConfigStatusCode(rs.getString(COL_CONFIG_STATUS_CODE));
        fgorganizationparty.setOwnerPartyCode(rs.getString(COL_OWNER_PARTY_CODE));
        fgorganizationparty.setAddlCode01(rs.getString(COL_ADDL_CODE_01));
        fgorganizationparty.setAddlCode02(rs.getString(COL_ADDL_CODE_02));
        fgorganizationparty.setAddlCode03(rs.getString(COL_ADDL_CODE_03));
        fgorganizationparty.setAddlCode04(rs.getString(COL_ADDL_CODE_04));
        fgorganizationparty.setAddlCode05(rs.getString(COL_ADDL_CODE_05));
        fgorganizationparty.setAddlCode06(rs.getString(COL_ADDL_CODE_06));
        fgorganizationparty.setAddlCode07(rs.getString(COL_ADDL_CODE_07));
        fgorganizationparty.setAddlCode08(rs.getString(COL_ADDL_CODE_08));
        fgorganizationparty.setAddlCode09(rs.getString(COL_ADDL_CODE_09));
        fgorganizationparty.setAddlCode10(rs.getString(COL_ADDL_CODE_10));
        fgorganizationparty.setAddlCode11(rs.getString(COL_ADDL_CODE_11));
        fgorganizationparty.setAddlCode12(rs.getString(COL_ADDL_CODE_12));
        fgorganizationparty.setAddlCode13(rs.getString(COL_ADDL_CODE_13));
        fgorganizationparty.setAddlCode14(rs.getString(COL_ADDL_CODE_14));
        fgorganizationparty.setAddlCode15(rs.getString(COL_ADDL_CODE_15));
        fgorganizationparty.setAddlCode16(rs.getString(COL_ADDL_CODE_16));
        fgorganizationparty.setAddlCode17(rs.getString(COL_ADDL_CODE_17));
        fgorganizationparty.setAddlCode18(rs.getString(COL_ADDL_CODE_18));
        fgorganizationparty.setAddlCode19(rs.getString(COL_ADDL_CODE_19));
        fgorganizationparty.setAddlCode20(rs.getString(COL_ADDL_CODE_20));
        fgorganizationparty.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgorganizationparty.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgorganizationparty.setCreatedBy(CREATED_BY);
        fgorganizationparty.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgorganizationparty.setLastUpdatedBy(LAST_UPDATED_BY);
        fgorganizationparty.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgorganizationparty.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgorganizationparty.setProcessID(PROCESS_ID);
        fgorganizationparty.setBranchName(rs.getString(COL_BRANCH_NAME));
        fgorganizationparty.setBranchCode(rs.getString(COL_BRANCH_CODE));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        fgorganizationparty.setAttachmentID(ATTACHMENT_ID);
        fgorganizationparty.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgorganizationparty.setDemocracyTypeCode(rs.getString(COL_DEMOCRACY_TYPE_CODE));
        fgorganizationparty.setDemocracySubTypeCode(rs.getString(COL_DEMOCRACY_SUB_TYPE_CODE));
        fgorganizationparty.setConstitutionTypeCode(rs.getString(COL_CONSTITUTION_TYPE_CODE));
        fgorganizationparty.setParentPartyCode(rs.getString(COL_PARENT_PARTY_CODE));
        fgorganizationparty.setSystemSourceCode(rs.getString(COL_SYSTEM_SOURCE_CODE));
        fgorganizationparty.setEmpCode(rs.getString(COL_EMP_CODE));
        fgorganizationparty.setTaskReasonCode(rs.getString(COL_TASK_REASON_CODE));
        fgorganizationparty.setTaskReasonText(rs.getString(COL_TASK_REASON_TEXT));
        fgorganizationparty.setMasterTemplate(rs.getString(COL_MASTER_TEMPLATE));
        fgorganizationparty.setTransactionType(rs.getString(COL_TRANSACTION_TYPE));
        fgorganizationparty.setRegStatus(rs.getString(COL_REG_STATUS));
        fgorganizationparty.setMigrationStatusCode(rs.getString(COL_MIGRATION_STATUS_CODE));
        fgorganizationparty.setMigrationSysCode(rs.getString(COL_MIGRATION_SYS_CODE));
        fgorganizationparty.setMigrationSysRefCode(rs.getString(COL_MIGRATION_SYS_REF_CODE));
        fgorganizationparty.setMigrationDatetime(rs.getString(COL_MIGRATION_DATETIME));
        fgorganizationparty.setStageCode(rs.getString(COL_STAGE_CODE));
        fgorganizationparty.setBoStatusCode(rs.getString(COL_BO_STATUS_CODE));
        fgorganizationparty.setBoStatusReference(rs.getString(COL_BO_STATUS_REFERENCE));
        fgorganizationparty.setBoStatusReasson(rs.getString(COL_BO_STATUS_REASSON));
        fgorganizationparty.setBoStatusMessage(rs.getString(COL_BO_STATUS_MESSAGE));
        fgorganizationparty.setPortalEnablementStatusCode(rs.getString(COL_PORTAL_ENABLEMENT_STATUS_CODE));
        fgorganizationparty.setUuid(rs.getString(COL_UUID));
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        fgorganizationparty.setUploadRefID(UPLOAD_REF_ID);
        fgorganizationparty.setOrganizationType(rs.getString(COL_ORGANIZATION_TYPE));
        fgorganizationparty.setPartyLinkType(rs.getString(COL_PARTY_LINK_TYPE));
        fgorganizationparty.setParentLinkType(rs.getString(COL_PARENT_LINK_TYPE));
        fgorganizationparty.setMobileNumber(rs.getString(COL_MOBILE_NUMBER));
        Integer EMAIL_ID = rs.getObject(COL_EMAIL_ID, Integer.class);
        fgorganizationparty.setEmailID(EMAIL_ID);
        fgorganizationparty.setFirstName(rs.getString(COL_FIRST_NAME));
        fgorganizationparty.setLastName(rs.getString(COL_LAST_NAME));
        fgorganizationparty.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgorganizationparty.setGender(rs.getString(COL_GENDER));
        Integer CUSTOMER_ID = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        fgorganizationparty.setCustomerID(CUSTOMER_ID);
        fgorganizationparty.setDob(rs.getString(COL_DOB));
        fgorganizationparty.setCurrentAddress(rs.getString(COL_CURRENT_ADDRESS));
        fgorganizationparty.setLicenseNo(rs.getString(COL_LICENSE_NO));
        fgorganizationparty.setPanNo(rs.getString(COL_PAN_NO));
        fgorganizationparty.setAddress1(rs.getString(COL_ADDRESS1));
        fgorganizationparty.setAddress2(rs.getString(COL_ADDRESS2));
        fgorganizationparty.setCityCode(rs.getString(COL_CITY_CODE));
        fgorganizationparty.setCountry(rs.getString(COL_COUNTRY));
        fgorganizationparty.setPinCode(rs.getString(COL_PIN_CODE));
        fgorganizationparty.setIdentifierSubTypeCode(rs.getString(COL_IDENTIFIER_SUB_TYPE_CODE));
        fgorganizationparty.setIdentityNo(rs.getString(COL_IDENTITY_NO));
        fgorganizationparty.setIssuerCode(rs.getString(COL_ISSUER_CODE));
        fgorganizationparty.setIssuerName(rs.getString(COL_ISSUER_NAME));
        fgorganizationparty.setRoleCode(rs.getString(COL_ROLE_CODE));
        Integer PRODUCT_ID = rs.getObject(COL_PRODUCT_ID, Integer.class);
        fgorganizationparty.setProductID(PRODUCT_ID);
        fgorganizationparty.setTemplate(rs.getString(COL_TEMPLATE));
        fgorganizationparty.setIsTemplate(rs.getString(COL_IS_TEMPLATE));
        fgorganizationparty.setOrgTypeCode(rs.getString(COL_ORG_TYPE_CODE));
        fgorganizationparty.setOrgSubTypeCode(rs.getString(COL_ORG_SUB_TYPE_CODE));
        fgorganizationparty.setUserActionCode(rs.getString(COL_USER_ACTION_CODE));
        fgorganizationparty.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        return fgorganizationparty;
    }
}
