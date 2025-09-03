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
import com.bsit.codegeneration.entity.DoSmartCollect;

public interface DoSmartCollectDao {

    /**
     * Inserts a new DoSmartCollect and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO DO_SMART_COLLECT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_USER_CRN, FULFILLMENT_PARTY, IS_TEMPLATE, COMPANY_NAME, ACCOUNT_NUMBER, MAILING_ADDRESS, CONTACT_PERSON, CONTACT_MOBILE_NUMBER, APPLICATION_REFERENCE, REPORTING_FREQUENCY, PRODUCT_NAME, PRODUCT_DISPLAY_STATUS, TAT_START_TIME, TAT_END_TIME, EXISTING_USER_NAME, USER_EMAIL, ISSUING_PARTY_CODE, CUSTOMER_TYPE_DESC, APPLICANT_USER_NAME, MAKER_COMMENTS, TASK_REASON, COMPANY_CRN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantUserCrn, :fulfillmentParty, :isTemplate, :companyName, :accountNumber, :mailingAddress, :contactPerson, :contactMobileNumber, :applicationReference, :reportingFrequency, :productName, :productDisplayStatus, :tatStartTime, :tatEndTime, :existingUserName, :userEmail, :issuingPartyCode, :customerTypeDesc, :applicantUserName, :makerComments, :taskReason, :companyCrn)")
    public int insert(@BindBean DoSmartCollect dosmartcollect);

    /**
     * Finds a DoSmartCollect by its ID.
     */
    @SqlQuery("SELECT * FROM DO_SMART_COLLECT WHERE ID = :id")
    @RegisterBeanMapper(DoSmartCollect.class)
    public Optional<DoSmartCollect> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM DO_SMART_COLLECT")
    @RegisterBeanMapper(DoSmartCollect.class)
    public List<DoSmartCollect> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM DO_SMART_COLLECT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(DoSmartCollect.class)
    public List<DoSmartCollect> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a DoSmartCollect and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE DO_SMART_COLLECT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_USER_CRN = :applicantUserCrn, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, COMPANY_NAME = :companyName, ACCOUNT_NUMBER = :accountNumber, MAILING_ADDRESS = :mailingAddress, CONTACT_PERSON = :contactPerson, CONTACT_MOBILE_NUMBER = :contactMobileNumber, APPLICATION_REFERENCE = :applicationReference, REPORTING_FREQUENCY = :reportingFrequency, PRODUCT_NAME = :productName, PRODUCT_DISPLAY_STATUS = :productDisplayStatus, TAT_START_TIME = :tatStartTime, TAT_END_TIME = :tatEndTime, EXISTING_USER_NAME = :existingUserName, USER_EMAIL = :userEmail, ISSUING_PARTY_CODE = :issuingPartyCode, CUSTOMER_TYPE_DESC = :customerTypeDesc, APPLICANT_USER_NAME = :applicantUserName, MAKER_COMMENTS = :makerComments, TASK_REASON = :taskReason, COMPANY_CRN = :companyCrn WHERE ID = :id")
    public int update(@BindBean DoSmartCollect dosmartcollect);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM DO_SMART_COLLECT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM DO_SMART_COLLECT")
    public long countAll();

    /**
     * Bulk insert multiple DoSmartCollect entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO DO_SMART_COLLECT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_USER_CRN, FULFILLMENT_PARTY, IS_TEMPLATE, COMPANY_NAME, ACCOUNT_NUMBER, MAILING_ADDRESS, CONTACT_PERSON, CONTACT_MOBILE_NUMBER, APPLICATION_REFERENCE, REPORTING_FREQUENCY, PRODUCT_NAME, PRODUCT_DISPLAY_STATUS, TAT_START_TIME, TAT_END_TIME, EXISTING_USER_NAME, USER_EMAIL, ISSUING_PARTY_CODE, CUSTOMER_TYPE_DESC, APPLICANT_USER_NAME, MAKER_COMMENTS, TASK_REASON, COMPANY_CRN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantUserCrn, :fulfillmentParty, :isTemplate, :companyName, :accountNumber, :mailingAddress, :contactPerson, :contactMobileNumber, :applicationReference, :reportingFrequency, :productName, :productDisplayStatus, :tatStartTime, :tatEndTime, :existingUserName, :userEmail, :issuingPartyCode, :customerTypeDesc, :applicantUserName, :makerComments, :taskReason, :companyCrn)")
    public int[] bulkInsert(@BindBean List<DoSmartCollect> dosmartcollects);

    /**
     * Bulk update multiple DoSmartCollect entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE DO_SMART_COLLECT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_USER_CRN = :applicantUserCrn, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, COMPANY_NAME = :companyName, ACCOUNT_NUMBER = :accountNumber, MAILING_ADDRESS = :mailingAddress, CONTACT_PERSON = :contactPerson, CONTACT_MOBILE_NUMBER = :contactMobileNumber, APPLICATION_REFERENCE = :applicationReference, REPORTING_FREQUENCY = :reportingFrequency, PRODUCT_NAME = :productName, PRODUCT_DISPLAY_STATUS = :productDisplayStatus, TAT_START_TIME = :tatStartTime, TAT_END_TIME = :tatEndTime, EXISTING_USER_NAME = :existingUserName, USER_EMAIL = :userEmail, ISSUING_PARTY_CODE = :issuingPartyCode, CUSTOMER_TYPE_DESC = :customerTypeDesc, APPLICANT_USER_NAME = :applicantUserName, MAKER_COMMENTS = :makerComments, TASK_REASON = :taskReason, COMPANY_CRN = :companyCrn WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<DoSmartCollect> dosmartcollects);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM DO_SMART_COLLECT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM DO_SMART_COLLECT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple DoSmartCollect records by their IDs.
     */
    @SqlQuery("SELECT * FROM DO_SMART_COLLECT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(DoSmartCollect.class)
    public List<DoSmartCollect> findByIds(@BindList("ids") Collection<String> ids);
}
