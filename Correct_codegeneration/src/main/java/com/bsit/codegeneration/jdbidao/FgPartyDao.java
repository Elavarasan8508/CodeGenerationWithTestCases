package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.FgParty;

public interface FgPartyDao {

    /**
     * Inserts a new FgParty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY (ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, UPLOAD_REF_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, CHANNEL, CHANNEL_TYPE, TEMPLATE) VALUES (:id, :versionId, :isMasterVersion, :isoCode, :languageCode, :name, :timeZoneCode, :typeCode, :subTypeCode, :referenceId, :abbvName, :currencyCode, :description, :configStatusCode, :ownerPartyCode, :addlCode01, :addlCode02, :addlCode03, :addlCode04, :addlCode05, :addlCode06, :addlCode07, :addlCode08, :addlCode09, :addlCode10, :addlCode11, :addlCode12, :addlCode13, :addlCode14, :addlCode15, :addlCode16, :addlCode17, :addlCode18, :addlCode19, :addlCode20, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :uploadRefId, :branchName, :branchCode, :attachmentId, :partySubTypeCode, :democracyTypeCode, :democracySubTypeCode, :constitutionTypeCode, :parentPartyCode, :systemSourceCode, :empCode, :taskReasonCode, :taskReasonText, :masterTemplate, :transactionType, :regStatus, :migrationStatusCode, :migrationSysCode, :migrationSysRefCode, :migrationDatetime, :stageCode, :boStatusCode, :boStatusReference, :boStatusReasson, :boStatusMessage, :portalEnablementStatusCode, :channel, :channelType, :template)")
    public int insert(@BindBean FgParty fgparty);

    /**
     * Finds a FgParty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgParty.class)
    public Optional<FgParty> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY")
    @RegisterBeanMapper(FgParty.class)
    public List<FgParty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgParty.class)
    public List<FgParty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgParty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY SET IS_MASTER_VERSION = :isMasterVersion, ISO_CODE = :isoCode, LANGUAGE_CODE = :languageCode, NAME = :name, TIME_ZONE_CODE = :timeZoneCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, REFERENCE_ID = :referenceId, ABBV_NAME = :abbvName, CURRENCY_CODE = :currencyCode, DESCRIPTION = :description, CONFIG_STATUS_CODE = :configStatusCode, OWNER_PARTY_CODE = :ownerPartyCode, ADDL_CODE_01 = :addlCode01, ADDL_CODE_02 = :addlCode02, ADDL_CODE_03 = :addlCode03, ADDL_CODE_04 = :addlCode04, ADDL_CODE_05 = :addlCode05, ADDL_CODE_06 = :addlCode06, ADDL_CODE_07 = :addlCode07, ADDL_CODE_08 = :addlCode08, ADDL_CODE_09 = :addlCode09, ADDL_CODE_10 = :addlCode10, ADDL_CODE_11 = :addlCode11, ADDL_CODE_12 = :addlCode12, ADDL_CODE_13 = :addlCode13, ADDL_CODE_14 = :addlCode14, ADDL_CODE_15 = :addlCode15, ADDL_CODE_16 = :addlCode16, ADDL_CODE_17 = :addlCode17, ADDL_CODE_18 = :addlCode18, ADDL_CODE_19 = :addlCode19, ADDL_CODE_20 = :addlCode20, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, BRANCH_NAME = :branchName, BRANCH_CODE = :branchCode, ATTACHMENT_ID = :attachmentId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, DEMOCRACY_TYPE_CODE = :democracyTypeCode, DEMOCRACY_SUB_TYPE_CODE = :democracySubTypeCode, CONSTITUTION_TYPE_CODE = :constitutionTypeCode, PARENT_PARTY_CODE = :parentPartyCode, SYSTEM_SOURCE_CODE = :systemSourceCode, EMP_CODE = :empCode, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, MASTER_TEMPLATE = :masterTemplate, TRANSACTION_TYPE = :transactionType, REG_STATUS = :regStatus, MIGRATION_STATUS_CODE = :migrationStatusCode, MIGRATION_SYS_CODE = :migrationSysCode, MIGRATION_SYS_REF_CODE = :migrationSysRefCode, MIGRATION_DATETIME = :migrationDatetime, STAGE_CODE = :stageCode, BO_STATUS_CODE = :boStatusCode, BO_STATUS_REFERENCE = :boStatusReference, BO_STATUS_REASSON = :boStatusReasson, BO_STATUS_MESSAGE = :boStatusMessage, PORTAL_ENABLEMENT_STATUS_CODE = :portalEnablementStatusCode, CHANNEL = :channel, CHANNEL_TYPE = :channelType, TEMPLATE = :template WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgParty fgparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY")
    public long countAll();

    /**
     * Bulk insert multiple FgParty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY (ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, UPLOAD_REF_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, CHANNEL, CHANNEL_TYPE, TEMPLATE) VALUES (:id, :versionId, :isMasterVersion, :isoCode, :languageCode, :name, :timeZoneCode, :typeCode, :subTypeCode, :referenceId, :abbvName, :currencyCode, :description, :configStatusCode, :ownerPartyCode, :addlCode01, :addlCode02, :addlCode03, :addlCode04, :addlCode05, :addlCode06, :addlCode07, :addlCode08, :addlCode09, :addlCode10, :addlCode11, :addlCode12, :addlCode13, :addlCode14, :addlCode15, :addlCode16, :addlCode17, :addlCode18, :addlCode19, :addlCode20, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :uploadRefId, :branchName, :branchCode, :attachmentId, :partySubTypeCode, :democracyTypeCode, :democracySubTypeCode, :constitutionTypeCode, :parentPartyCode, :systemSourceCode, :empCode, :taskReasonCode, :taskReasonText, :masterTemplate, :transactionType, :regStatus, :migrationStatusCode, :migrationSysCode, :migrationSysRefCode, :migrationDatetime, :stageCode, :boStatusCode, :boStatusReference, :boStatusReasson, :boStatusMessage, :portalEnablementStatusCode, :channel, :channelType, :template)")
    public int[] bulkInsert(@BindBean List<FgParty> fgpartys);

    /**
     * Bulk update multiple FgParty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY SET IS_MASTER_VERSION = :isMasterVersion, ISO_CODE = :isoCode, LANGUAGE_CODE = :languageCode, NAME = :name, TIME_ZONE_CODE = :timeZoneCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, REFERENCE_ID = :referenceId, ABBV_NAME = :abbvName, CURRENCY_CODE = :currencyCode, DESCRIPTION = :description, CONFIG_STATUS_CODE = :configStatusCode, OWNER_PARTY_CODE = :ownerPartyCode, ADDL_CODE_01 = :addlCode01, ADDL_CODE_02 = :addlCode02, ADDL_CODE_03 = :addlCode03, ADDL_CODE_04 = :addlCode04, ADDL_CODE_05 = :addlCode05, ADDL_CODE_06 = :addlCode06, ADDL_CODE_07 = :addlCode07, ADDL_CODE_08 = :addlCode08, ADDL_CODE_09 = :addlCode09, ADDL_CODE_10 = :addlCode10, ADDL_CODE_11 = :addlCode11, ADDL_CODE_12 = :addlCode12, ADDL_CODE_13 = :addlCode13, ADDL_CODE_14 = :addlCode14, ADDL_CODE_15 = :addlCode15, ADDL_CODE_16 = :addlCode16, ADDL_CODE_17 = :addlCode17, ADDL_CODE_18 = :addlCode18, ADDL_CODE_19 = :addlCode19, ADDL_CODE_20 = :addlCode20, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, BRANCH_NAME = :branchName, BRANCH_CODE = :branchCode, ATTACHMENT_ID = :attachmentId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, DEMOCRACY_TYPE_CODE = :democracyTypeCode, DEMOCRACY_SUB_TYPE_CODE = :democracySubTypeCode, CONSTITUTION_TYPE_CODE = :constitutionTypeCode, PARENT_PARTY_CODE = :parentPartyCode, SYSTEM_SOURCE_CODE = :systemSourceCode, EMP_CODE = :empCode, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, MASTER_TEMPLATE = :masterTemplate, TRANSACTION_TYPE = :transactionType, REG_STATUS = :regStatus, MIGRATION_STATUS_CODE = :migrationStatusCode, MIGRATION_SYS_CODE = :migrationSysCode, MIGRATION_SYS_REF_CODE = :migrationSysRefCode, MIGRATION_DATETIME = :migrationDatetime, STAGE_CODE = :stageCode, BO_STATUS_CODE = :boStatusCode, BO_STATUS_REFERENCE = :boStatusReference, BO_STATUS_REASSON = :boStatusReasson, BO_STATUS_MESSAGE = :boStatusMessage, PORTAL_ENABLEMENT_STATUS_CODE = :portalEnablementStatusCode, CHANNEL = :channel, CHANNEL_TYPE = :channelType, TEMPLATE = :template WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgParty> fgpartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgParty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgParty.class)
    public List<FgParty> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
