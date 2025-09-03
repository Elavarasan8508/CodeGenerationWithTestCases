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
import com.bsit.codegeneration.entity.FgOrganizationParty;

public interface FgOrganizationPartyDao {

    /**
     * Inserts a new FgOrganizationParty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ORGANIZATION_PARTY (ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, UUID, UPLOAD_REF_ID, ORGANIZATION_TYPE, PARTY_LINK_TYPE, PARENT_LINK_TYPE, MOBILE_NUMBER, EMAIL_ID, FIRST_NAME, LAST_NAME, APPLICANT_PARTY, GENDER, CUSTOMER_ID, DOB, CURRENT_ADDRESS, LICENSE_NO, PAN_NO, ADDRESS1, ADDRESS2, CITY_CODE, COUNTRY, PIN_CODE, IDENTIFIER_SUB_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, ROLE_CODE, PRODUCT_ID, TEMPLATE, IS_TEMPLATE, ORG_TYPE_CODE, ORG_SUB_TYPE_CODE, USER_ACTION_CODE, ACTIVE_CODE) VALUES (:id, :versionId, :isMasterVersion, :isoCode, :languageCode, :name, :timeZoneCode, :typeCode, :subTypeCode, :referenceId, :abbvName, :currencyCode, :description, :configStatusCode, :ownerPartyCode, :addlCode01, :addlCode02, :addlCode03, :addlCode04, :addlCode05, :addlCode06, :addlCode07, :addlCode08, :addlCode09, :addlCode10, :addlCode11, :addlCode12, :addlCode13, :addlCode14, :addlCode15, :addlCode16, :addlCode17, :addlCode18, :addlCode19, :addlCode20, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :branchName, :branchCode, :attachmentId, :partySubTypeCode, :democracyTypeCode, :democracySubTypeCode, :constitutionTypeCode, :parentPartyCode, :systemSourceCode, :empCode, :taskReasonCode, :taskReasonText, :masterTemplate, :transactionType, :regStatus, :migrationStatusCode, :migrationSysCode, :migrationSysRefCode, :migrationDatetime, :stageCode, :boStatusCode, :boStatusReference, :boStatusReasson, :boStatusMessage, :portalEnablementStatusCode, :uuid, :uploadRefId, :organizationType, :partyLinkType, :parentLinkType, :mobileNumber, :emailId, :firstName, :lastName, :applicantParty, :gender, :customerId, :dob, :currentAddress, :licenseNo, :panNo, :address1, :address2, :cityCode, :country, :pinCode, :identifierSubTypeCode, :identityNo, :issuerCode, :issuerName, :roleCode, :productId, :template, :isTemplate, :orgTypeCode, :orgSubTypeCode, :userActionCode, :activeCode)")
    public int insert(@BindBean FgOrganizationParty fgorganizationparty);

    /**
     * Finds a FgOrganizationParty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ORGANIZATION_PARTY WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgOrganizationParty.class)
    public Optional<FgOrganizationParty> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ORGANIZATION_PARTY")
    @RegisterBeanMapper(FgOrganizationParty.class)
    public List<FgOrganizationParty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ORGANIZATION_PARTY ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgOrganizationParty.class)
    public List<FgOrganizationParty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgOrganizationParty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ORGANIZATION_PARTY SET IS_MASTER_VERSION = :isMasterVersion, ISO_CODE = :isoCode, LANGUAGE_CODE = :languageCode, NAME = :name, TIME_ZONE_CODE = :timeZoneCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, REFERENCE_ID = :referenceId, ABBV_NAME = :abbvName, CURRENCY_CODE = :currencyCode, DESCRIPTION = :description, CONFIG_STATUS_CODE = :configStatusCode, OWNER_PARTY_CODE = :ownerPartyCode, ADDL_CODE_01 = :addlCode01, ADDL_CODE_02 = :addlCode02, ADDL_CODE_03 = :addlCode03, ADDL_CODE_04 = :addlCode04, ADDL_CODE_05 = :addlCode05, ADDL_CODE_06 = :addlCode06, ADDL_CODE_07 = :addlCode07, ADDL_CODE_08 = :addlCode08, ADDL_CODE_09 = :addlCode09, ADDL_CODE_10 = :addlCode10, ADDL_CODE_11 = :addlCode11, ADDL_CODE_12 = :addlCode12, ADDL_CODE_13 = :addlCode13, ADDL_CODE_14 = :addlCode14, ADDL_CODE_15 = :addlCode15, ADDL_CODE_16 = :addlCode16, ADDL_CODE_17 = :addlCode17, ADDL_CODE_18 = :addlCode18, ADDL_CODE_19 = :addlCode19, ADDL_CODE_20 = :addlCode20, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, BRANCH_NAME = :branchName, BRANCH_CODE = :branchCode, ATTACHMENT_ID = :attachmentId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, DEMOCRACY_TYPE_CODE = :democracyTypeCode, DEMOCRACY_SUB_TYPE_CODE = :democracySubTypeCode, CONSTITUTION_TYPE_CODE = :constitutionTypeCode, PARENT_PARTY_CODE = :parentPartyCode, SYSTEM_SOURCE_CODE = :systemSourceCode, EMP_CODE = :empCode, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, MASTER_TEMPLATE = :masterTemplate, TRANSACTION_TYPE = :transactionType, REG_STATUS = :regStatus, MIGRATION_STATUS_CODE = :migrationStatusCode, MIGRATION_SYS_CODE = :migrationSysCode, MIGRATION_SYS_REF_CODE = :migrationSysRefCode, MIGRATION_DATETIME = :migrationDatetime, STAGE_CODE = :stageCode, BO_STATUS_CODE = :boStatusCode, BO_STATUS_REFERENCE = :boStatusReference, BO_STATUS_REASSON = :boStatusReasson, BO_STATUS_MESSAGE = :boStatusMessage, PORTAL_ENABLEMENT_STATUS_CODE = :portalEnablementStatusCode, UUID = :uuid, UPLOAD_REF_ID = :uploadRefId, ORGANIZATION_TYPE = :organizationType, PARTY_LINK_TYPE = :partyLinkType, PARENT_LINK_TYPE = :parentLinkType, MOBILE_NUMBER = :mobileNumber, EMAIL_ID = :emailId, FIRST_NAME = :firstName, LAST_NAME = :lastName, APPLICANT_PARTY = :applicantParty, GENDER = :gender, CUSTOMER_ID = :customerId, DOB = :dob, CURRENT_ADDRESS = :currentAddress, LICENSE_NO = :licenseNo, PAN_NO = :panNo, ADDRESS1 = :address1, ADDRESS2 = :address2, CITY_CODE = :cityCode, COUNTRY = :country, PIN_CODE = :pinCode, IDENTIFIER_SUB_TYPE_CODE = :identifierSubTypeCode, IDENTITY_NO = :identityNo, ISSUER_CODE = :issuerCode, ISSUER_NAME = :issuerName, ROLE_CODE = :roleCode, PRODUCT_ID = :productId, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORG_TYPE_CODE = :orgTypeCode, ORG_SUB_TYPE_CODE = :orgSubTypeCode, USER_ACTION_CODE = :userActionCode, ACTIVE_CODE = :activeCode WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgOrganizationParty fgorganizationparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORGANIZATION_PARTY WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ORGANIZATION_PARTY")
    public long countAll();

    /**
     * Bulk insert multiple FgOrganizationParty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ORGANIZATION_PARTY (ID, VERSION_ID, IS_MASTER_VERSION, ISO_CODE, LANGUAGE_CODE, NAME, TIME_ZONE_CODE, TYPE_CODE, SUB_TYPE_CODE, REFERENCE_ID, ABBV_NAME, CURRENCY_CODE, DESCRIPTION, CONFIG_STATUS_CODE, OWNER_PARTY_CODE, ADDL_CODE_01, ADDL_CODE_02, ADDL_CODE_03, ADDL_CODE_04, ADDL_CODE_05, ADDL_CODE_06, ADDL_CODE_07, ADDL_CODE_08, ADDL_CODE_09, ADDL_CODE_10, ADDL_CODE_11, ADDL_CODE_12, ADDL_CODE_13, ADDL_CODE_14, ADDL_CODE_15, ADDL_CODE_16, ADDL_CODE_17, ADDL_CODE_18, ADDL_CODE_19, ADDL_CODE_20, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, BRANCH_NAME, BRANCH_CODE, ATTACHMENT_ID, PARTY_SUB_TYPE_CODE, DEMOCRACY_TYPE_CODE, DEMOCRACY_SUB_TYPE_CODE, CONSTITUTION_TYPE_CODE, PARENT_PARTY_CODE, SYSTEM_SOURCE_CODE, EMP_CODE, TASK_REASON_CODE, TASK_REASON_TEXT, MASTER_TEMPLATE, TRANSACTION_TYPE, REG_STATUS, MIGRATION_STATUS_CODE, MIGRATION_SYS_CODE, MIGRATION_SYS_REF_CODE, MIGRATION_DATETIME, STAGE_CODE, BO_STATUS_CODE, BO_STATUS_REFERENCE, BO_STATUS_REASSON, BO_STATUS_MESSAGE, PORTAL_ENABLEMENT_STATUS_CODE, UUID, UPLOAD_REF_ID, ORGANIZATION_TYPE, PARTY_LINK_TYPE, PARENT_LINK_TYPE, MOBILE_NUMBER, EMAIL_ID, FIRST_NAME, LAST_NAME, APPLICANT_PARTY, GENDER, CUSTOMER_ID, DOB, CURRENT_ADDRESS, LICENSE_NO, PAN_NO, ADDRESS1, ADDRESS2, CITY_CODE, COUNTRY, PIN_CODE, IDENTIFIER_SUB_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, ROLE_CODE, PRODUCT_ID, TEMPLATE, IS_TEMPLATE, ORG_TYPE_CODE, ORG_SUB_TYPE_CODE, USER_ACTION_CODE, ACTIVE_CODE) VALUES (:id, :versionId, :isMasterVersion, :isoCode, :languageCode, :name, :timeZoneCode, :typeCode, :subTypeCode, :referenceId, :abbvName, :currencyCode, :description, :configStatusCode, :ownerPartyCode, :addlCode01, :addlCode02, :addlCode03, :addlCode04, :addlCode05, :addlCode06, :addlCode07, :addlCode08, :addlCode09, :addlCode10, :addlCode11, :addlCode12, :addlCode13, :addlCode14, :addlCode15, :addlCode16, :addlCode17, :addlCode18, :addlCode19, :addlCode20, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :branchName, :branchCode, :attachmentId, :partySubTypeCode, :democracyTypeCode, :democracySubTypeCode, :constitutionTypeCode, :parentPartyCode, :systemSourceCode, :empCode, :taskReasonCode, :taskReasonText, :masterTemplate, :transactionType, :regStatus, :migrationStatusCode, :migrationSysCode, :migrationSysRefCode, :migrationDatetime, :stageCode, :boStatusCode, :boStatusReference, :boStatusReasson, :boStatusMessage, :portalEnablementStatusCode, :uuid, :uploadRefId, :organizationType, :partyLinkType, :parentLinkType, :mobileNumber, :emailId, :firstName, :lastName, :applicantParty, :gender, :customerId, :dob, :currentAddress, :licenseNo, :panNo, :address1, :address2, :cityCode, :country, :pinCode, :identifierSubTypeCode, :identityNo, :issuerCode, :issuerName, :roleCode, :productId, :template, :isTemplate, :orgTypeCode, :orgSubTypeCode, :userActionCode, :activeCode)")
    public int[] bulkInsert(@BindBean List<FgOrganizationParty> fgorganizationpartys);

    /**
     * Bulk update multiple FgOrganizationParty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ORGANIZATION_PARTY SET IS_MASTER_VERSION = :isMasterVersion, ISO_CODE = :isoCode, LANGUAGE_CODE = :languageCode, NAME = :name, TIME_ZONE_CODE = :timeZoneCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, REFERENCE_ID = :referenceId, ABBV_NAME = :abbvName, CURRENCY_CODE = :currencyCode, DESCRIPTION = :description, CONFIG_STATUS_CODE = :configStatusCode, OWNER_PARTY_CODE = :ownerPartyCode, ADDL_CODE_01 = :addlCode01, ADDL_CODE_02 = :addlCode02, ADDL_CODE_03 = :addlCode03, ADDL_CODE_04 = :addlCode04, ADDL_CODE_05 = :addlCode05, ADDL_CODE_06 = :addlCode06, ADDL_CODE_07 = :addlCode07, ADDL_CODE_08 = :addlCode08, ADDL_CODE_09 = :addlCode09, ADDL_CODE_10 = :addlCode10, ADDL_CODE_11 = :addlCode11, ADDL_CODE_12 = :addlCode12, ADDL_CODE_13 = :addlCode13, ADDL_CODE_14 = :addlCode14, ADDL_CODE_15 = :addlCode15, ADDL_CODE_16 = :addlCode16, ADDL_CODE_17 = :addlCode17, ADDL_CODE_18 = :addlCode18, ADDL_CODE_19 = :addlCode19, ADDL_CODE_20 = :addlCode20, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, BRANCH_NAME = :branchName, BRANCH_CODE = :branchCode, ATTACHMENT_ID = :attachmentId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, DEMOCRACY_TYPE_CODE = :democracyTypeCode, DEMOCRACY_SUB_TYPE_CODE = :democracySubTypeCode, CONSTITUTION_TYPE_CODE = :constitutionTypeCode, PARENT_PARTY_CODE = :parentPartyCode, SYSTEM_SOURCE_CODE = :systemSourceCode, EMP_CODE = :empCode, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, MASTER_TEMPLATE = :masterTemplate, TRANSACTION_TYPE = :transactionType, REG_STATUS = :regStatus, MIGRATION_STATUS_CODE = :migrationStatusCode, MIGRATION_SYS_CODE = :migrationSysCode, MIGRATION_SYS_REF_CODE = :migrationSysRefCode, MIGRATION_DATETIME = :migrationDatetime, STAGE_CODE = :stageCode, BO_STATUS_CODE = :boStatusCode, BO_STATUS_REFERENCE = :boStatusReference, BO_STATUS_REASSON = :boStatusReasson, BO_STATUS_MESSAGE = :boStatusMessage, PORTAL_ENABLEMENT_STATUS_CODE = :portalEnablementStatusCode, UUID = :uuid, UPLOAD_REF_ID = :uploadRefId, ORGANIZATION_TYPE = :organizationType, PARTY_LINK_TYPE = :partyLinkType, PARENT_LINK_TYPE = :parentLinkType, MOBILE_NUMBER = :mobileNumber, EMAIL_ID = :emailId, FIRST_NAME = :firstName, LAST_NAME = :lastName, APPLICANT_PARTY = :applicantParty, GENDER = :gender, CUSTOMER_ID = :customerId, DOB = :dob, CURRENT_ADDRESS = :currentAddress, LICENSE_NO = :licenseNo, PAN_NO = :panNo, ADDRESS1 = :address1, ADDRESS2 = :address2, CITY_CODE = :cityCode, COUNTRY = :country, PIN_CODE = :pinCode, IDENTIFIER_SUB_TYPE_CODE = :identifierSubTypeCode, IDENTITY_NO = :identityNo, ISSUER_CODE = :issuerCode, ISSUER_NAME = :issuerName, ROLE_CODE = :roleCode, PRODUCT_ID = :productId, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORG_TYPE_CODE = :orgTypeCode, ORG_SUB_TYPE_CODE = :orgSubTypeCode, USER_ACTION_CODE = :userActionCode, ACTIVE_CODE = :activeCode WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgOrganizationParty> fgorganizationpartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORGANIZATION_PARTY WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ORGANIZATION_PARTY WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgOrganizationParty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ORGANIZATION_PARTY WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgOrganizationParty.class)
    public List<FgOrganizationParty> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
