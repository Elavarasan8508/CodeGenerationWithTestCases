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
import com.bsit.codegeneration.entity.FgProductReq;

public interface FgProductReqDao {

    /**
     * Inserts a new FgProductReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, APPLICANT_USER_CRN, APPLICATION_DATE, APPROVAL_DATE, PROCESSED_DATE, USER_ROLE, USER_CRN, USER_NAME, USER_EMAIL, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CUSTOMER_CITY, CUSTOMER_PINCODE, PRODUCT_CODES, CONTACT_NAME, CONTACT_DESIGNATION, CONTACT_EMAIL, CONTACT_PHONE, CONTACT_MOBILE, PARENT_ACCOUNT_NO, ACCOUNTS, REPORT_NAME, REPORT_RECIPIENT_EMAIL, APPLICATION_STAGE, APPLICATION_STATUS, REJECT_REASON_CODE, REJECT_REASON, NOTIFICATION_ENABLED, ACC_PROCESSED_DATE, CUSTOMER_STATE, CUSTOMER_NAME, APPROVAL_STATUS, APPROVAL_DESCRIPTION, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FULLFILMENT_PARTY, PRODUCT_CODE, NAME, DESCRIPTION, ACTIVE, CUSTOMER_TYPE, FAILURE_REASON, PARENT_ACCOUNT_NO1, APPLICANT_USER_NAME, PROD_NAME_DESC, CUSTOMER_TYPE_DESC, TASK_ACTION, TASK_REASON, SIGNATORY_DATE, SIGNATORY_DESC, ENRICH_COMMENTS, FULLFILMENT_COMMENTS, PRODUCT_DISPLAY_STATUS, SHOW_AUTH_STEPPER, AUTHORISATION_TYPE, MODE_OF_OPERATION, SLAB_TYPE, TAT_START_TIME, TAT_END_TIME, USERROLE_TRADE, PARENT_ACCOUNT_NAME, DISPLAY_STATUS, PARENT_ACCOUNT_NO_DISPLAY, PARENT_ACCOUNT_NO_ORG) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customerCrn, :applicantUserCrn, :applicationDate, :approvalDate, :processedDate, :userRole, :userCrn, :userName, :userEmail, :addressLine1, :addressLine2, :addressLine3, :customerCity, :customerPincode, :productCodes, :contactName, :contactDesignation, :contactEmail, :contactPhone, :contactMobile, :parentAccountNo, :accounts, :reportName, :reportRecipientEmail, :applicationStage, :applicationStatus, :rejectReasonCode, :rejectReason, :notificationEnabled, :accProcessedDate, :customerState, :customerName, :approvalStatus, :approvalDescription, :processId, :versionId, :isMasterVersion, :applicantPartyCode, :issuingPartyCode, :fullfilmentParty, :productCode, :name, :description, :active, :customerType, :failureReason, :parentAccountNo1, :applicantUserName, :prodNameDesc, :customerTypeDesc, :taskAction, :taskReason, :signatoryDate, :signatoryDesc, :enrichComments, :fullfilmentComments, :productDisplayStatus, :showAuthStepper, :authorisationType, :modeOfOperation, :slabType, :tatStartTime, :tatEndTime, :userroleTrade, :parentAccountName, :displayStatus, :parentAccountNoDisplay, :parentAccountNoOrg)")
    public int insert(@BindBean FgProductReq fgproductreq);

    /**
     * Finds a FgProductReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_REQ WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgProductReq.class)
    public Optional<FgProductReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_REQ")
    @RegisterBeanMapper(FgProductReq.class)
    public List<FgProductReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_REQ ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductReq.class)
    public List<FgProductReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, APPLICANT_USER_CRN = :applicantUserCrn, APPLICATION_DATE = :applicationDate, APPROVAL_DATE = :approvalDate, PROCESSED_DATE = :processedDate, USER_ROLE = :userRole, USER_CRN = :userCrn, USER_NAME = :userName, USER_EMAIL = :userEmail, ADDRESS_LINE_1 = :addressLine1, ADDRESS_LINE_2 = :addressLine2, ADDRESS_LINE_3 = :addressLine3, CUSTOMER_CITY = :customerCity, CUSTOMER_PINCODE = :customerPincode, PRODUCT_CODES = :productCodes, CONTACT_NAME = :contactName, CONTACT_DESIGNATION = :contactDesignation, CONTACT_EMAIL = :contactEmail, CONTACT_PHONE = :contactPhone, CONTACT_MOBILE = :contactMobile, PARENT_ACCOUNT_NO = :parentAccountNo, ACCOUNTS = :accounts, REPORT_NAME = :reportName, REPORT_RECIPIENT_EMAIL = :reportRecipientEmail, APPLICATION_STAGE = :applicationStage, APPLICATION_STATUS = :applicationStatus, REJECT_REASON_CODE = :rejectReasonCode, REJECT_REASON = :rejectReason, NOTIFICATION_ENABLED = :notificationEnabled, ACC_PROCESSED_DATE = :accProcessedDate, CUSTOMER_STATE = :customerState, CUSTOMER_NAME = :customerName, APPROVAL_STATUS = :approvalStatus, APPROVAL_DESCRIPTION = :approvalDescription, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FULLFILMENT_PARTY = :fullfilmentParty, PRODUCT_CODE = :productCode, NAME = :name, DESCRIPTION = :description, ACTIVE = :active, CUSTOMER_TYPE = :customerType, FAILURE_REASON = :failureReason, PARENT_ACCOUNT_NO1 = :parentAccountNo1, APPLICANT_USER_NAME = :applicantUserName, PROD_NAME_DESC = :prodNameDesc, CUSTOMER_TYPE_DESC = :customerTypeDesc, TASK_ACTION = :taskAction, TASK_REASON = :taskReason, SIGNATORY_DATE = :signatoryDate, SIGNATORY_DESC = :signatoryDesc, ENRICH_COMMENTS = :enrichComments, FULLFILMENT_COMMENTS = :fullfilmentComments, PRODUCT_DISPLAY_STATUS = :productDisplayStatus, SHOW_AUTH_STEPPER = :showAuthStepper, AUTHORISATION_TYPE = :authorisationType, MODE_OF_OPERATION = :modeOfOperation, SLAB_TYPE = :slabType, TAT_START_TIME = :tatStartTime, TAT_END_TIME = :tatEndTime, USERROLE_TRADE = :userroleTrade, PARENT_ACCOUNT_NAME = :parentAccountName, DISPLAY_STATUS = :displayStatus, PARENT_ACCOUNT_NO_DISPLAY = :parentAccountNoDisplay, PARENT_ACCOUNT_NO_ORG = :parentAccountNoOrg WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgProductReq fgproductreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_REQ WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgProductReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, APPLICANT_USER_CRN, APPLICATION_DATE, APPROVAL_DATE, PROCESSED_DATE, USER_ROLE, USER_CRN, USER_NAME, USER_EMAIL, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CUSTOMER_CITY, CUSTOMER_PINCODE, PRODUCT_CODES, CONTACT_NAME, CONTACT_DESIGNATION, CONTACT_EMAIL, CONTACT_PHONE, CONTACT_MOBILE, PARENT_ACCOUNT_NO, ACCOUNTS, REPORT_NAME, REPORT_RECIPIENT_EMAIL, APPLICATION_STAGE, APPLICATION_STATUS, REJECT_REASON_CODE, REJECT_REASON, NOTIFICATION_ENABLED, ACC_PROCESSED_DATE, CUSTOMER_STATE, CUSTOMER_NAME, APPROVAL_STATUS, APPROVAL_DESCRIPTION, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FULLFILMENT_PARTY, PRODUCT_CODE, NAME, DESCRIPTION, ACTIVE, CUSTOMER_TYPE, FAILURE_REASON, PARENT_ACCOUNT_NO1, APPLICANT_USER_NAME, PROD_NAME_DESC, CUSTOMER_TYPE_DESC, TASK_ACTION, TASK_REASON, SIGNATORY_DATE, SIGNATORY_DESC, ENRICH_COMMENTS, FULLFILMENT_COMMENTS, PRODUCT_DISPLAY_STATUS, SHOW_AUTH_STEPPER, AUTHORISATION_TYPE, MODE_OF_OPERATION, SLAB_TYPE, TAT_START_TIME, TAT_END_TIME, USERROLE_TRADE, PARENT_ACCOUNT_NAME, DISPLAY_STATUS, PARENT_ACCOUNT_NO_DISPLAY, PARENT_ACCOUNT_NO_ORG) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customerCrn, :applicantUserCrn, :applicationDate, :approvalDate, :processedDate, :userRole, :userCrn, :userName, :userEmail, :addressLine1, :addressLine2, :addressLine3, :customerCity, :customerPincode, :productCodes, :contactName, :contactDesignation, :contactEmail, :contactPhone, :contactMobile, :parentAccountNo, :accounts, :reportName, :reportRecipientEmail, :applicationStage, :applicationStatus, :rejectReasonCode, :rejectReason, :notificationEnabled, :accProcessedDate, :customerState, :customerName, :approvalStatus, :approvalDescription, :processId, :versionId, :isMasterVersion, :applicantPartyCode, :issuingPartyCode, :fullfilmentParty, :productCode, :name, :description, :active, :customerType, :failureReason, :parentAccountNo1, :applicantUserName, :prodNameDesc, :customerTypeDesc, :taskAction, :taskReason, :signatoryDate, :signatoryDesc, :enrichComments, :fullfilmentComments, :productDisplayStatus, :showAuthStepper, :authorisationType, :modeOfOperation, :slabType, :tatStartTime, :tatEndTime, :userroleTrade, :parentAccountName, :displayStatus, :parentAccountNoDisplay, :parentAccountNoOrg)")
    public int[] bulkInsert(@BindBean List<FgProductReq> fgproductreqs);

    /**
     * Bulk update multiple FgProductReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, APPLICANT_USER_CRN = :applicantUserCrn, APPLICATION_DATE = :applicationDate, APPROVAL_DATE = :approvalDate, PROCESSED_DATE = :processedDate, USER_ROLE = :userRole, USER_CRN = :userCrn, USER_NAME = :userName, USER_EMAIL = :userEmail, ADDRESS_LINE_1 = :addressLine1, ADDRESS_LINE_2 = :addressLine2, ADDRESS_LINE_3 = :addressLine3, CUSTOMER_CITY = :customerCity, CUSTOMER_PINCODE = :customerPincode, PRODUCT_CODES = :productCodes, CONTACT_NAME = :contactName, CONTACT_DESIGNATION = :contactDesignation, CONTACT_EMAIL = :contactEmail, CONTACT_PHONE = :contactPhone, CONTACT_MOBILE = :contactMobile, PARENT_ACCOUNT_NO = :parentAccountNo, ACCOUNTS = :accounts, REPORT_NAME = :reportName, REPORT_RECIPIENT_EMAIL = :reportRecipientEmail, APPLICATION_STAGE = :applicationStage, APPLICATION_STATUS = :applicationStatus, REJECT_REASON_CODE = :rejectReasonCode, REJECT_REASON = :rejectReason, NOTIFICATION_ENABLED = :notificationEnabled, ACC_PROCESSED_DATE = :accProcessedDate, CUSTOMER_STATE = :customerState, CUSTOMER_NAME = :customerName, APPROVAL_STATUS = :approvalStatus, APPROVAL_DESCRIPTION = :approvalDescription, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FULLFILMENT_PARTY = :fullfilmentParty, PRODUCT_CODE = :productCode, NAME = :name, DESCRIPTION = :description, ACTIVE = :active, CUSTOMER_TYPE = :customerType, FAILURE_REASON = :failureReason, PARENT_ACCOUNT_NO1 = :parentAccountNo1, APPLICANT_USER_NAME = :applicantUserName, PROD_NAME_DESC = :prodNameDesc, CUSTOMER_TYPE_DESC = :customerTypeDesc, TASK_ACTION = :taskAction, TASK_REASON = :taskReason, SIGNATORY_DATE = :signatoryDate, SIGNATORY_DESC = :signatoryDesc, ENRICH_COMMENTS = :enrichComments, FULLFILMENT_COMMENTS = :fullfilmentComments, PRODUCT_DISPLAY_STATUS = :productDisplayStatus, SHOW_AUTH_STEPPER = :showAuthStepper, AUTHORISATION_TYPE = :authorisationType, MODE_OF_OPERATION = :modeOfOperation, SLAB_TYPE = :slabType, TAT_START_TIME = :tatStartTime, TAT_END_TIME = :tatEndTime, USERROLE_TRADE = :userroleTrade, PARENT_ACCOUNT_NAME = :parentAccountName, DISPLAY_STATUS = :displayStatus, PARENT_ACCOUNT_NO_DISPLAY = :parentAccountNoDisplay, PARENT_ACCOUNT_NO_ORG = :parentAccountNoOrg WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgProductReq> fgproductreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_REQ WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_REQ WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_REQ WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgProductReq.class)
    public List<FgProductReq> findByIds(@BindList("ids") Collection<String> ids);
}
