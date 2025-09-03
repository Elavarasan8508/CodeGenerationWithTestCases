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
import com.bsit.codegeneration.entity.FgEkycReq;

public interface FgEkycReqDao {

    /**
     * Inserts a new FgEkycReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EKYC_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CRN_REF, FIRST_NAME, LAST_NAME, EMAIL, MOBILE, FATHER_NAME, MOTHER_MAIDEN_NAME, OCCUPATION, GENDER, MARITAL_STATUS, VERSION_ID, IS_MASTER_VERSION, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, USER_NAME, ENTITY_CUSTOMER_CRN, ENTITY_APPLICANT_USER_CRN, AADHAAR_OPTION, APPLICANT_PARTY_CODE, EXPIRES_ON, EKYC_DISPLAY_STATUS, EMAIL_STATUS_CODE, MOBILE_STATUS_CODE, TC_STATUS_CODE, AADHAAR_CONSENT_STATUS_CODE, AADHAAR_VERIFY_STATUS_CODE, AADHAAR_INFO_STATUS_CODE, PAN_LINK_STATUS_CODE, PAN_NAME_STATUS_CODE, PAN_VERIFY_STATUS_CODE, PERSONAL_INFO_STATUS_CODE, AADHAAR_ID_REFERENCE_ENC, AADHAAR_VID_REFERENCE_ENC, AADHAAR_ID_REFERENCE_MASK, AADHAAR_VID_REFERENCE_MASK, PAN_ID_REFERENCE_ENC, CURRENT_STEP_CODE, ISSUING_PARTY_CODE, RESEND_ATTEMPT_CNT, RESEND_LAST_ATTEMPT_ON, AADHAAR_CONSENT_LANG_CODE, AADHAAR_MOBILE, AADHAAR_NAME, AADHAAR_ADDRESS, AADHAAR_GENDER, PRODUCT_REQ_ACCOUNT_REF, CURRENT_TXN_ID, PAN_NUMBER, RESEND_ATTEMPT_LOCK_EXP_TIME, SUBMIT_OTP_COUNT, VALIDATE_OTP_GENERATE_TIME, AADHAAR_DOB, EKYC_LINK_STATUS, HOME_BRANCH, PARENT_ACCOUNT_NO, ACCOUNT_TYPE, NEW_USER_CRN, REMARKS, ACCOUNT_LINK_STATUS, REGEN_LINK_COUNT, OPS_USER_ID, ANNUAL_INCOME_SLAB, ANNUAL_INCOME, EMAIL_LINK_OTP_COUNT, AADHAAR_UID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :clientCrnRef, :firstName, :lastName, :email, :mobile, :fatherName, :motherMaidenName, :occupation, :gender, :maritalStatus, :versionId, :isMasterVersion, :entityTypeCode, :entitySubTypeCode, :entityReferenceId, :userName, :entityCustomerCrn, :entityApplicantUserCrn, :aadhaarOption, :applicantPartyCode, :expiresOn, :ekycDisplayStatus, :emailStatusCode, :mobileStatusCode, :tcStatusCode, :aadhaarConsentStatusCode, :aadhaarVerifyStatusCode, :aadhaarInfoStatusCode, :panLinkStatusCode, :panNameStatusCode, :panVerifyStatusCode, :personalInfoStatusCode, :aadhaarIdReferenceEnc, :aadhaarVidReferenceEnc, :aadhaarIdReferenceMask, :aadhaarVidReferenceMask, :panIdReferenceEnc, :currentStepCode, :issuingPartyCode, :resendAttemptCnt, :resendLastAttemptOn, :aadhaarConsentLangCode, :aadhaarMobile, :aadhaarName, :aadhaarAddress, :aadhaarGender, :productReqAccountRef, :currentTxnId, :panNumber, :resendAttemptLockExpTime, :submitOtpCount, :validateOtpGenerateTime, :aadhaarDob, :ekycLinkStatus, :homeBranch, :parentAccountNo, :accountType, :newUserCrn, :remarks, :accountLinkStatus, :regenLinkCount, :opsUserId, :annualIncomeSlab, :annualIncome, :emailLinkOtpCount, :aadhaarUid)")
    public int insert(@BindBean FgEkycReq fgekycreq);

    /**
     * Finds a FgEkycReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EKYC_REQ WHERE FG_EKYC_REQ_id = :id")
    @RegisterBeanMapper(FgEkycReq.class)
    public Optional<FgEkycReq> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EKYC_REQ")
    @RegisterBeanMapper(FgEkycReq.class)
    public List<FgEkycReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EKYC_REQ ORDER BY FG_EKYC_REQ_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEkycReq.class)
    public List<FgEkycReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEkycReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EKYC_REQ SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CLIENT_CRN_REF = :clientCrnRef, FIRST_NAME = :firstName, LAST_NAME = :lastName, EMAIL = :email, MOBILE = :mobile, FATHER_NAME = :fatherName, MOTHER_MAIDEN_NAME = :motherMaidenName, OCCUPATION = :occupation, GENDER = :gender, MARITAL_STATUS = :maritalStatus, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId, USER_NAME = :userName, ENTITY_CUSTOMER_CRN = :entityCustomerCrn, ENTITY_APPLICANT_USER_CRN = :entityApplicantUserCrn, AADHAAR_OPTION = :aadhaarOption, APPLICANT_PARTY_CODE = :applicantPartyCode, EXPIRES_ON = :expiresOn, EKYC_DISPLAY_STATUS = :ekycDisplayStatus, EMAIL_STATUS_CODE = :emailStatusCode, MOBILE_STATUS_CODE = :mobileStatusCode, TC_STATUS_CODE = :tcStatusCode, AADHAAR_CONSENT_STATUS_CODE = :aadhaarConsentStatusCode, AADHAAR_VERIFY_STATUS_CODE = :aadhaarVerifyStatusCode, AADHAAR_INFO_STATUS_CODE = :aadhaarInfoStatusCode, PAN_LINK_STATUS_CODE = :panLinkStatusCode, PAN_NAME_STATUS_CODE = :panNameStatusCode, PAN_VERIFY_STATUS_CODE = :panVerifyStatusCode, PERSONAL_INFO_STATUS_CODE = :personalInfoStatusCode, AADHAAR_ID_REFERENCE_ENC = :aadhaarIdReferenceEnc, AADHAAR_VID_REFERENCE_ENC = :aadhaarVidReferenceEnc, AADHAAR_ID_REFERENCE_MASK = :aadhaarIdReferenceMask, AADHAAR_VID_REFERENCE_MASK = :aadhaarVidReferenceMask, PAN_ID_REFERENCE_ENC = :panIdReferenceEnc, CURRENT_STEP_CODE = :currentStepCode, ISSUING_PARTY_CODE = :issuingPartyCode, RESEND_ATTEMPT_CNT = :resendAttemptCnt, RESEND_LAST_ATTEMPT_ON = :resendLastAttemptOn, AADHAAR_CONSENT_LANG_CODE = :aadhaarConsentLangCode, AADHAAR_MOBILE = :aadhaarMobile, AADHAAR_NAME = :aadhaarName, AADHAAR_ADDRESS = :aadhaarAddress, AADHAAR_GENDER = :aadhaarGender, PRODUCT_REQ_ACCOUNT_REF = :productReqAccountRef, CURRENT_TXN_ID = :currentTxnId, PAN_NUMBER = :panNumber, RESEND_ATTEMPT_LOCK_EXP_TIME = :resendAttemptLockExpTime, SUBMIT_OTP_COUNT = :submitOtpCount, VALIDATE_OTP_GENERATE_TIME = :validateOtpGenerateTime, AADHAAR_DOB = :aadhaarDob, EKYC_LINK_STATUS = :ekycLinkStatus, HOME_BRANCH = :homeBranch, PARENT_ACCOUNT_NO = :parentAccountNo, ACCOUNT_TYPE = :accountType, NEW_USER_CRN = :newUserCrn, REMARKS = :remarks, ACCOUNT_LINK_STATUS = :accountLinkStatus, REGEN_LINK_COUNT = :regenLinkCount, OPS_USER_ID = :opsUserId, ANNUAL_INCOME_SLAB = :annualIncomeSlab, ANNUAL_INCOME = :annualIncome, EMAIL_LINK_OTP_COUNT = :emailLinkOtpCount, AADHAAR_UID = :aadhaarUid WHERE FG_EKYC_REQ_id = :fgEkycReqId")
    public int update(@BindBean FgEkycReq fgekycreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EKYC_REQ WHERE FG_EKYC_REQ_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EKYC_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgEkycReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EKYC_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CRN_REF, FIRST_NAME, LAST_NAME, EMAIL, MOBILE, FATHER_NAME, MOTHER_MAIDEN_NAME, OCCUPATION, GENDER, MARITAL_STATUS, VERSION_ID, IS_MASTER_VERSION, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, USER_NAME, ENTITY_CUSTOMER_CRN, ENTITY_APPLICANT_USER_CRN, AADHAAR_OPTION, APPLICANT_PARTY_CODE, EXPIRES_ON, EKYC_DISPLAY_STATUS, EMAIL_STATUS_CODE, MOBILE_STATUS_CODE, TC_STATUS_CODE, AADHAAR_CONSENT_STATUS_CODE, AADHAAR_VERIFY_STATUS_CODE, AADHAAR_INFO_STATUS_CODE, PAN_LINK_STATUS_CODE, PAN_NAME_STATUS_CODE, PAN_VERIFY_STATUS_CODE, PERSONAL_INFO_STATUS_CODE, AADHAAR_ID_REFERENCE_ENC, AADHAAR_VID_REFERENCE_ENC, AADHAAR_ID_REFERENCE_MASK, AADHAAR_VID_REFERENCE_MASK, PAN_ID_REFERENCE_ENC, CURRENT_STEP_CODE, ISSUING_PARTY_CODE, RESEND_ATTEMPT_CNT, RESEND_LAST_ATTEMPT_ON, AADHAAR_CONSENT_LANG_CODE, AADHAAR_MOBILE, AADHAAR_NAME, AADHAAR_ADDRESS, AADHAAR_GENDER, PRODUCT_REQ_ACCOUNT_REF, CURRENT_TXN_ID, PAN_NUMBER, RESEND_ATTEMPT_LOCK_EXP_TIME, SUBMIT_OTP_COUNT, VALIDATE_OTP_GENERATE_TIME, AADHAAR_DOB, EKYC_LINK_STATUS, HOME_BRANCH, PARENT_ACCOUNT_NO, ACCOUNT_TYPE, NEW_USER_CRN, REMARKS, ACCOUNT_LINK_STATUS, REGEN_LINK_COUNT, OPS_USER_ID, ANNUAL_INCOME_SLAB, ANNUAL_INCOME, EMAIL_LINK_OTP_COUNT, AADHAAR_UID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :clientCrnRef, :firstName, :lastName, :email, :mobile, :fatherName, :motherMaidenName, :occupation, :gender, :maritalStatus, :versionId, :isMasterVersion, :entityTypeCode, :entitySubTypeCode, :entityReferenceId, :userName, :entityCustomerCrn, :entityApplicantUserCrn, :aadhaarOption, :applicantPartyCode, :expiresOn, :ekycDisplayStatus, :emailStatusCode, :mobileStatusCode, :tcStatusCode, :aadhaarConsentStatusCode, :aadhaarVerifyStatusCode, :aadhaarInfoStatusCode, :panLinkStatusCode, :panNameStatusCode, :panVerifyStatusCode, :personalInfoStatusCode, :aadhaarIdReferenceEnc, :aadhaarVidReferenceEnc, :aadhaarIdReferenceMask, :aadhaarVidReferenceMask, :panIdReferenceEnc, :currentStepCode, :issuingPartyCode, :resendAttemptCnt, :resendLastAttemptOn, :aadhaarConsentLangCode, :aadhaarMobile, :aadhaarName, :aadhaarAddress, :aadhaarGender, :productReqAccountRef, :currentTxnId, :panNumber, :resendAttemptLockExpTime, :submitOtpCount, :validateOtpGenerateTime, :aadhaarDob, :ekycLinkStatus, :homeBranch, :parentAccountNo, :accountType, :newUserCrn, :remarks, :accountLinkStatus, :regenLinkCount, :opsUserId, :annualIncomeSlab, :annualIncome, :emailLinkOtpCount, :aadhaarUid)")
    public int[] bulkInsert(@BindBean List<FgEkycReq> fgekycreqs);

    /**
     * Bulk update multiple FgEkycReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EKYC_REQ SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CLIENT_CRN_REF = :clientCrnRef, FIRST_NAME = :firstName, LAST_NAME = :lastName, EMAIL = :email, MOBILE = :mobile, FATHER_NAME = :fatherName, MOTHER_MAIDEN_NAME = :motherMaidenName, OCCUPATION = :occupation, GENDER = :gender, MARITAL_STATUS = :maritalStatus, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId, USER_NAME = :userName, ENTITY_CUSTOMER_CRN = :entityCustomerCrn, ENTITY_APPLICANT_USER_CRN = :entityApplicantUserCrn, AADHAAR_OPTION = :aadhaarOption, APPLICANT_PARTY_CODE = :applicantPartyCode, EXPIRES_ON = :expiresOn, EKYC_DISPLAY_STATUS = :ekycDisplayStatus, EMAIL_STATUS_CODE = :emailStatusCode, MOBILE_STATUS_CODE = :mobileStatusCode, TC_STATUS_CODE = :tcStatusCode, AADHAAR_CONSENT_STATUS_CODE = :aadhaarConsentStatusCode, AADHAAR_VERIFY_STATUS_CODE = :aadhaarVerifyStatusCode, AADHAAR_INFO_STATUS_CODE = :aadhaarInfoStatusCode, PAN_LINK_STATUS_CODE = :panLinkStatusCode, PAN_NAME_STATUS_CODE = :panNameStatusCode, PAN_VERIFY_STATUS_CODE = :panVerifyStatusCode, PERSONAL_INFO_STATUS_CODE = :personalInfoStatusCode, AADHAAR_ID_REFERENCE_ENC = :aadhaarIdReferenceEnc, AADHAAR_VID_REFERENCE_ENC = :aadhaarVidReferenceEnc, AADHAAR_ID_REFERENCE_MASK = :aadhaarIdReferenceMask, AADHAAR_VID_REFERENCE_MASK = :aadhaarVidReferenceMask, PAN_ID_REFERENCE_ENC = :panIdReferenceEnc, CURRENT_STEP_CODE = :currentStepCode, ISSUING_PARTY_CODE = :issuingPartyCode, RESEND_ATTEMPT_CNT = :resendAttemptCnt, RESEND_LAST_ATTEMPT_ON = :resendLastAttemptOn, AADHAAR_CONSENT_LANG_CODE = :aadhaarConsentLangCode, AADHAAR_MOBILE = :aadhaarMobile, AADHAAR_NAME = :aadhaarName, AADHAAR_ADDRESS = :aadhaarAddress, AADHAAR_GENDER = :aadhaarGender, PRODUCT_REQ_ACCOUNT_REF = :productReqAccountRef, CURRENT_TXN_ID = :currentTxnId, PAN_NUMBER = :panNumber, RESEND_ATTEMPT_LOCK_EXP_TIME = :resendAttemptLockExpTime, SUBMIT_OTP_COUNT = :submitOtpCount, VALIDATE_OTP_GENERATE_TIME = :validateOtpGenerateTime, AADHAAR_DOB = :aadhaarDob, EKYC_LINK_STATUS = :ekycLinkStatus, HOME_BRANCH = :homeBranch, PARENT_ACCOUNT_NO = :parentAccountNo, ACCOUNT_TYPE = :accountType, NEW_USER_CRN = :newUserCrn, REMARKS = :remarks, ACCOUNT_LINK_STATUS = :accountLinkStatus, REGEN_LINK_COUNT = :regenLinkCount, OPS_USER_ID = :opsUserId, ANNUAL_INCOME_SLAB = :annualIncomeSlab, ANNUAL_INCOME = :annualIncome, EMAIL_LINK_OTP_COUNT = :emailLinkOtpCount, AADHAAR_UID = :aadhaarUid WHERE FG_EKYC_REQ_id = :fgEkycReqId")
    public int[] bulkUpdate(@BindBean List<FgEkycReq> fgekycreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EKYC_REQ WHERE FG_EKYC_REQ_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EKYC_REQ WHERE FG_EKYC_REQ_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgEkycReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EKYC_REQ WHERE FG_EKYC_REQ_id IN (<ids>)")
    @RegisterBeanMapper(FgEkycReq.class)
    public List<FgEkycReq> findByIds(@BindList("ids") Collection<Integer> ids);
}
