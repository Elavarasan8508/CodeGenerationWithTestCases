package com.bsit.codegeneration.record;

public record FgEkycReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String clientCrnRef, String firstName, String lastName, String email, String mobile, String fatherName, String motherMaidenName, String occupation, String gender, String maritalStatus, Long versionID, Long isMasterVersion, String entityTypeCode, String entitySubTypeCode, String entityReferenceID, String userName, String entityCustomerCrn, String entityApplicantUserCrn, String aadhaarOption, String applicantPartyCode, String expiresOn, String ekycDisplayStatus, String emailStatusCode, String mobileStatusCode, String tcStatusCode, String aadhaarConsentStatusCode, String aadhaarVerifyStatusCode, String aadhaarInfoStatusCode, String panLinkStatusCode, String panNameStatusCode, String panVerifyStatusCode, String personalInfoStatusCode, String aadhaarIDReferenceEnc, String aadhaarVidReferenceEnc, String aadhaarIDReferenceMask, String aadhaarVidReferenceMask, String panIDReferenceEnc, String currentStepCode, String issuingPartyCode, Long resendAttemptCnt, String resendLastAttemptOn, String aadhaarConsentLangCode, String aadhaarMobile, String aadhaarName, String aadhaarAddress, String aadhaarGender, String productReqAccountRef, String currentTxnID, String panNumber, String resendAttemptLockExpTime, Long submitOtpCount, String validateOtpGenerateTime, String aadhaarDob, String ekycLinkStatus, String homeBranch, String parentAccountNo, String accountType, String newUserCrn, String remarks, String accountLinkStatus, Long regenLinkCount, String opsUserID, String annualIncomeSlab, String annualIncome, Long emailLinkOtpCount, String aadhaarUid) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String clientCrnRef;

        private String firstName;

        private String lastName;

        private String email;

        private String mobile;

        private String fatherName;

        private String motherMaidenName;

        private String occupation;

        private String gender;

        private String maritalStatus;

        private Long versionID;

        private Long isMasterVersion;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String entityReferenceID;

        private String userName;

        private String entityCustomerCrn;

        private String entityApplicantUserCrn;

        private String aadhaarOption;

        private String applicantPartyCode;

        private String expiresOn;

        private String ekycDisplayStatus;

        private String emailStatusCode;

        private String mobileStatusCode;

        private String tcStatusCode;

        private String aadhaarConsentStatusCode;

        private String aadhaarVerifyStatusCode;

        private String aadhaarInfoStatusCode;

        private String panLinkStatusCode;

        private String panNameStatusCode;

        private String panVerifyStatusCode;

        private String personalInfoStatusCode;

        private String aadhaarIDReferenceEnc;

        private String aadhaarVidReferenceEnc;

        private String aadhaarIDReferenceMask;

        private String aadhaarVidReferenceMask;

        private String panIDReferenceEnc;

        private String currentStepCode;

        private String issuingPartyCode;

        private Long resendAttemptCnt;

        private String resendLastAttemptOn;

        private String aadhaarConsentLangCode;

        private String aadhaarMobile;

        private String aadhaarName;

        private String aadhaarAddress;

        private String aadhaarGender;

        private String productReqAccountRef;

        private String currentTxnID;

        private String panNumber;

        private String resendAttemptLockExpTime;

        private Long submitOtpCount;

        private String validateOtpGenerateTime;

        private String aadhaarDob;

        private String ekycLinkStatus;

        private String homeBranch;

        private String parentAccountNo;

        private String accountType;

        private String newUserCrn;

        private String remarks;

        private String accountLinkStatus;

        private Long regenLinkCount;

        private String opsUserID;

        private String annualIncomeSlab;

        private String annualIncome;

        private Long emailLinkOtpCount;

        private String aadhaarUid;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder clientCrnRef(String clientCrnRef) {
            this.clientCrnRef = clientCrnRef;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder motherMaidenName(String motherMaidenName) {
            this.motherMaidenName = motherMaidenName;
            return this;
        }

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder entityReferenceID(String entityReferenceID) {
            this.entityReferenceID = entityReferenceID;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder entityCustomerCrn(String entityCustomerCrn) {
            this.entityCustomerCrn = entityCustomerCrn;
            return this;
        }

        public Builder entityApplicantUserCrn(String entityApplicantUserCrn) {
            this.entityApplicantUserCrn = entityApplicantUserCrn;
            return this;
        }

        public Builder aadhaarOption(String aadhaarOption) {
            this.aadhaarOption = aadhaarOption;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder expiresOn(String expiresOn) {
            this.expiresOn = expiresOn;
            return this;
        }

        public Builder ekycDisplayStatus(String ekycDisplayStatus) {
            this.ekycDisplayStatus = ekycDisplayStatus;
            return this;
        }

        public Builder emailStatusCode(String emailStatusCode) {
            this.emailStatusCode = emailStatusCode;
            return this;
        }

        public Builder mobileStatusCode(String mobileStatusCode) {
            this.mobileStatusCode = mobileStatusCode;
            return this;
        }

        public Builder tcStatusCode(String tcStatusCode) {
            this.tcStatusCode = tcStatusCode;
            return this;
        }

        public Builder aadhaarConsentStatusCode(String aadhaarConsentStatusCode) {
            this.aadhaarConsentStatusCode = aadhaarConsentStatusCode;
            return this;
        }

        public Builder aadhaarVerifyStatusCode(String aadhaarVerifyStatusCode) {
            this.aadhaarVerifyStatusCode = aadhaarVerifyStatusCode;
            return this;
        }

        public Builder aadhaarInfoStatusCode(String aadhaarInfoStatusCode) {
            this.aadhaarInfoStatusCode = aadhaarInfoStatusCode;
            return this;
        }

        public Builder panLinkStatusCode(String panLinkStatusCode) {
            this.panLinkStatusCode = panLinkStatusCode;
            return this;
        }

        public Builder panNameStatusCode(String panNameStatusCode) {
            this.panNameStatusCode = panNameStatusCode;
            return this;
        }

        public Builder panVerifyStatusCode(String panVerifyStatusCode) {
            this.panVerifyStatusCode = panVerifyStatusCode;
            return this;
        }

        public Builder personalInfoStatusCode(String personalInfoStatusCode) {
            this.personalInfoStatusCode = personalInfoStatusCode;
            return this;
        }

        public Builder aadhaarIDReferenceEnc(String aadhaarIDReferenceEnc) {
            this.aadhaarIDReferenceEnc = aadhaarIDReferenceEnc;
            return this;
        }

        public Builder aadhaarVidReferenceEnc(String aadhaarVidReferenceEnc) {
            this.aadhaarVidReferenceEnc = aadhaarVidReferenceEnc;
            return this;
        }

        public Builder aadhaarIDReferenceMask(String aadhaarIDReferenceMask) {
            this.aadhaarIDReferenceMask = aadhaarIDReferenceMask;
            return this;
        }

        public Builder aadhaarVidReferenceMask(String aadhaarVidReferenceMask) {
            this.aadhaarVidReferenceMask = aadhaarVidReferenceMask;
            return this;
        }

        public Builder panIDReferenceEnc(String panIDReferenceEnc) {
            this.panIDReferenceEnc = panIDReferenceEnc;
            return this;
        }

        public Builder currentStepCode(String currentStepCode) {
            this.currentStepCode = currentStepCode;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder resendAttemptCnt(Long resendAttemptCnt) {
            this.resendAttemptCnt = resendAttemptCnt;
            return this;
        }

        public Builder resendLastAttemptOn(String resendLastAttemptOn) {
            this.resendLastAttemptOn = resendLastAttemptOn;
            return this;
        }

        public Builder aadhaarConsentLangCode(String aadhaarConsentLangCode) {
            this.aadhaarConsentLangCode = aadhaarConsentLangCode;
            return this;
        }

        public Builder aadhaarMobile(String aadhaarMobile) {
            this.aadhaarMobile = aadhaarMobile;
            return this;
        }

        public Builder aadhaarName(String aadhaarName) {
            this.aadhaarName = aadhaarName;
            return this;
        }

        public Builder aadhaarAddress(String aadhaarAddress) {
            this.aadhaarAddress = aadhaarAddress;
            return this;
        }

        public Builder aadhaarGender(String aadhaarGender) {
            this.aadhaarGender = aadhaarGender;
            return this;
        }

        public Builder productReqAccountRef(String productReqAccountRef) {
            this.productReqAccountRef = productReqAccountRef;
            return this;
        }

        public Builder currentTxnID(String currentTxnID) {
            this.currentTxnID = currentTxnID;
            return this;
        }

        public Builder panNumber(String panNumber) {
            this.panNumber = panNumber;
            return this;
        }

        public Builder resendAttemptLockExpTime(String resendAttemptLockExpTime) {
            this.resendAttemptLockExpTime = resendAttemptLockExpTime;
            return this;
        }

        public Builder submitOtpCount(Long submitOtpCount) {
            this.submitOtpCount = submitOtpCount;
            return this;
        }

        public Builder validateOtpGenerateTime(String validateOtpGenerateTime) {
            this.validateOtpGenerateTime = validateOtpGenerateTime;
            return this;
        }

        public Builder aadhaarDob(String aadhaarDob) {
            this.aadhaarDob = aadhaarDob;
            return this;
        }

        public Builder ekycLinkStatus(String ekycLinkStatus) {
            this.ekycLinkStatus = ekycLinkStatus;
            return this;
        }

        public Builder homeBranch(String homeBranch) {
            this.homeBranch = homeBranch;
            return this;
        }

        public Builder parentAccountNo(String parentAccountNo) {
            this.parentAccountNo = parentAccountNo;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder newUserCrn(String newUserCrn) {
            this.newUserCrn = newUserCrn;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder accountLinkStatus(String accountLinkStatus) {
            this.accountLinkStatus = accountLinkStatus;
            return this;
        }

        public Builder regenLinkCount(Long regenLinkCount) {
            this.regenLinkCount = regenLinkCount;
            return this;
        }

        public Builder opsUserID(String opsUserID) {
            this.opsUserID = opsUserID;
            return this;
        }

        public Builder annualIncomeSlab(String annualIncomeSlab) {
            this.annualIncomeSlab = annualIncomeSlab;
            return this;
        }

        public Builder annualIncome(String annualIncome) {
            this.annualIncome = annualIncome;
            return this;
        }

        public Builder emailLinkOtpCount(Long emailLinkOtpCount) {
            this.emailLinkOtpCount = emailLinkOtpCount;
            return this;
        }

        public Builder aadhaarUid(String aadhaarUid) {
            this.aadhaarUid = aadhaarUid;
            return this;
        }

        public FgEkycReq build() {
            return new FgEkycReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, clientCrnRef, firstName, lastName, email, mobile, fatherName, motherMaidenName, occupation, gender, maritalStatus, versionID, isMasterVersion, entityTypeCode, entitySubTypeCode, entityReferenceID, userName, entityCustomerCrn, entityApplicantUserCrn, aadhaarOption, applicantPartyCode, expiresOn, ekycDisplayStatus, emailStatusCode, mobileStatusCode, tcStatusCode, aadhaarConsentStatusCode, aadhaarVerifyStatusCode, aadhaarInfoStatusCode, panLinkStatusCode, panNameStatusCode, panVerifyStatusCode, personalInfoStatusCode, aadhaarIDReferenceEnc, aadhaarVidReferenceEnc, aadhaarIDReferenceMask, aadhaarVidReferenceMask, panIDReferenceEnc, currentStepCode, issuingPartyCode, resendAttemptCnt, resendLastAttemptOn, aadhaarConsentLangCode, aadhaarMobile, aadhaarName, aadhaarAddress, aadhaarGender, productReqAccountRef, currentTxnID, panNumber, resendAttemptLockExpTime, submitOtpCount, validateOtpGenerateTime, aadhaarDob, ekycLinkStatus, homeBranch, parentAccountNo, accountType, newUserCrn, remarks, accountLinkStatus, regenLinkCount, opsUserID, annualIncomeSlab, annualIncome, emailLinkOtpCount, aadhaarUid);
        }
    }
}
