package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgEkycReq {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

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

    private Integer versionID;

    private Integer isMasterVersion;

    private String entityTypeCode;

    private String entitySubTypeCode;

    private Integer entityReferenceID;

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

    private Integer currentTxnID;

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

    private Integer opsUserID;

    private String annualIncomeSlab;

    private String annualIncome;

    private Long emailLinkOtpCount;

    private String aadhaarUid;

    public FgEkycReq() {
    }

    public FgEkycReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String clientCrnRef, String firstName, String lastName, String email, String mobile, String fatherName, String motherMaidenName, String occupation, String gender, String maritalStatus, Integer versionID, Integer isMasterVersion, String entityTypeCode, String entitySubTypeCode, Integer entityReferenceID, String userName, String entityCustomerCrn, String entityApplicantUserCrn, String aadhaarOption, String applicantPartyCode, String expiresOn, String ekycDisplayStatus, String emailStatusCode, String mobileStatusCode, String tcStatusCode, String aadhaarConsentStatusCode, String aadhaarVerifyStatusCode, String aadhaarInfoStatusCode, String panLinkStatusCode, String panNameStatusCode, String panVerifyStatusCode, String personalInfoStatusCode, String aadhaarIDReferenceEnc, String aadhaarVidReferenceEnc, String aadhaarIDReferenceMask, String aadhaarVidReferenceMask, String panIDReferenceEnc, String currentStepCode, String issuingPartyCode, Long resendAttemptCnt, String resendLastAttemptOn, String aadhaarConsentLangCode, String aadhaarMobile, String aadhaarName, String aadhaarAddress, String aadhaarGender, String productReqAccountRef, Integer currentTxnID, String panNumber, String resendAttemptLockExpTime, Long submitOtpCount, String validateOtpGenerateTime, String aadhaarDob, String ekycLinkStatus, String homeBranch, String parentAccountNo, String accountType, String newUserCrn, String remarks, String accountLinkStatus, Long regenLinkCount, Integer opsUserID, String annualIncomeSlab, String annualIncome, Long emailLinkOtpCount, String aadhaarUid) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.clientCrnRef = clientCrnRef;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.fatherName = fatherName;
        this.motherMaidenName = motherMaidenName;
        this.occupation = occupation;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.entityReferenceID = entityReferenceID;
        this.userName = userName;
        this.entityCustomerCrn = entityCustomerCrn;
        this.entityApplicantUserCrn = entityApplicantUserCrn;
        this.aadhaarOption = aadhaarOption;
        this.applicantPartyCode = applicantPartyCode;
        this.expiresOn = expiresOn;
        this.ekycDisplayStatus = ekycDisplayStatus;
        this.emailStatusCode = emailStatusCode;
        this.mobileStatusCode = mobileStatusCode;
        this.tcStatusCode = tcStatusCode;
        this.aadhaarConsentStatusCode = aadhaarConsentStatusCode;
        this.aadhaarVerifyStatusCode = aadhaarVerifyStatusCode;
        this.aadhaarInfoStatusCode = aadhaarInfoStatusCode;
        this.panLinkStatusCode = panLinkStatusCode;
        this.panNameStatusCode = panNameStatusCode;
        this.panVerifyStatusCode = panVerifyStatusCode;
        this.personalInfoStatusCode = personalInfoStatusCode;
        this.aadhaarIDReferenceEnc = aadhaarIDReferenceEnc;
        this.aadhaarVidReferenceEnc = aadhaarVidReferenceEnc;
        this.aadhaarIDReferenceMask = aadhaarIDReferenceMask;
        this.aadhaarVidReferenceMask = aadhaarVidReferenceMask;
        this.panIDReferenceEnc = panIDReferenceEnc;
        this.currentStepCode = currentStepCode;
        this.issuingPartyCode = issuingPartyCode;
        this.resendAttemptCnt = resendAttemptCnt;
        this.resendLastAttemptOn = resendLastAttemptOn;
        this.aadhaarConsentLangCode = aadhaarConsentLangCode;
        this.aadhaarMobile = aadhaarMobile;
        this.aadhaarName = aadhaarName;
        this.aadhaarAddress = aadhaarAddress;
        this.aadhaarGender = aadhaarGender;
        this.productReqAccountRef = productReqAccountRef;
        this.currentTxnID = currentTxnID;
        this.panNumber = panNumber;
        this.resendAttemptLockExpTime = resendAttemptLockExpTime;
        this.submitOtpCount = submitOtpCount;
        this.validateOtpGenerateTime = validateOtpGenerateTime;
        this.aadhaarDob = aadhaarDob;
        this.ekycLinkStatus = ekycLinkStatus;
        this.homeBranch = homeBranch;
        this.parentAccountNo = parentAccountNo;
        this.accountType = accountType;
        this.newUserCrn = newUserCrn;
        this.remarks = remarks;
        this.accountLinkStatus = accountLinkStatus;
        this.regenLinkCount = regenLinkCount;
        this.opsUserID = opsUserID;
        this.annualIncomeSlab = annualIncomeSlab;
        this.annualIncome = annualIncome;
        this.emailLinkOtpCount = emailLinkOtpCount;
        this.aadhaarUid = aadhaarUid;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getClientCrnRef() {
        return clientCrnRef;
    }

    public void setClientCrnRef(String clientCrnRef) {
        this.clientCrnRef = clientCrnRef;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public Integer getEntityReferenceID() {
        return entityReferenceID;
    }

    public void setEntityReferenceID(Integer entityReferenceID) {
        this.entityReferenceID = entityReferenceID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEntityCustomerCrn() {
        return entityCustomerCrn;
    }

    public void setEntityCustomerCrn(String entityCustomerCrn) {
        this.entityCustomerCrn = entityCustomerCrn;
    }

    public String getEntityApplicantUserCrn() {
        return entityApplicantUserCrn;
    }

    public void setEntityApplicantUserCrn(String entityApplicantUserCrn) {
        this.entityApplicantUserCrn = entityApplicantUserCrn;
    }

    public String getAadhaarOption() {
        return aadhaarOption;
    }

    public void setAadhaarOption(String aadhaarOption) {
        this.aadhaarOption = aadhaarOption;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getEkycDisplayStatus() {
        return ekycDisplayStatus;
    }

    public void setEkycDisplayStatus(String ekycDisplayStatus) {
        this.ekycDisplayStatus = ekycDisplayStatus;
    }

    public String getEmailStatusCode() {
        return emailStatusCode;
    }

    public void setEmailStatusCode(String emailStatusCode) {
        this.emailStatusCode = emailStatusCode;
    }

    public String getMobileStatusCode() {
        return mobileStatusCode;
    }

    public void setMobileStatusCode(String mobileStatusCode) {
        this.mobileStatusCode = mobileStatusCode;
    }

    public String getTcStatusCode() {
        return tcStatusCode;
    }

    public void setTcStatusCode(String tcStatusCode) {
        this.tcStatusCode = tcStatusCode;
    }

    public String getAadhaarConsentStatusCode() {
        return aadhaarConsentStatusCode;
    }

    public void setAadhaarConsentStatusCode(String aadhaarConsentStatusCode) {
        this.aadhaarConsentStatusCode = aadhaarConsentStatusCode;
    }

    public String getAadhaarVerifyStatusCode() {
        return aadhaarVerifyStatusCode;
    }

    public void setAadhaarVerifyStatusCode(String aadhaarVerifyStatusCode) {
        this.aadhaarVerifyStatusCode = aadhaarVerifyStatusCode;
    }

    public String getAadhaarInfoStatusCode() {
        return aadhaarInfoStatusCode;
    }

    public void setAadhaarInfoStatusCode(String aadhaarInfoStatusCode) {
        this.aadhaarInfoStatusCode = aadhaarInfoStatusCode;
    }

    public String getPanLinkStatusCode() {
        return panLinkStatusCode;
    }

    public void setPanLinkStatusCode(String panLinkStatusCode) {
        this.panLinkStatusCode = panLinkStatusCode;
    }

    public String getPanNameStatusCode() {
        return panNameStatusCode;
    }

    public void setPanNameStatusCode(String panNameStatusCode) {
        this.panNameStatusCode = panNameStatusCode;
    }

    public String getPanVerifyStatusCode() {
        return panVerifyStatusCode;
    }

    public void setPanVerifyStatusCode(String panVerifyStatusCode) {
        this.panVerifyStatusCode = panVerifyStatusCode;
    }

    public String getPersonalInfoStatusCode() {
        return personalInfoStatusCode;
    }

    public void setPersonalInfoStatusCode(String personalInfoStatusCode) {
        this.personalInfoStatusCode = personalInfoStatusCode;
    }

    public String getAadhaarIDReferenceEnc() {
        return aadhaarIDReferenceEnc;
    }

    public void setAadhaarIDReferenceEnc(String aadhaarIDReferenceEnc) {
        this.aadhaarIDReferenceEnc = aadhaarIDReferenceEnc;
    }

    public String getAadhaarVidReferenceEnc() {
        return aadhaarVidReferenceEnc;
    }

    public void setAadhaarVidReferenceEnc(String aadhaarVidReferenceEnc) {
        this.aadhaarVidReferenceEnc = aadhaarVidReferenceEnc;
    }

    public String getAadhaarIDReferenceMask() {
        return aadhaarIDReferenceMask;
    }

    public void setAadhaarIDReferenceMask(String aadhaarIDReferenceMask) {
        this.aadhaarIDReferenceMask = aadhaarIDReferenceMask;
    }

    public String getAadhaarVidReferenceMask() {
        return aadhaarVidReferenceMask;
    }

    public void setAadhaarVidReferenceMask(String aadhaarVidReferenceMask) {
        this.aadhaarVidReferenceMask = aadhaarVidReferenceMask;
    }

    public String getPanIDReferenceEnc() {
        return panIDReferenceEnc;
    }

    public void setPanIDReferenceEnc(String panIDReferenceEnc) {
        this.panIDReferenceEnc = panIDReferenceEnc;
    }

    public String getCurrentStepCode() {
        return currentStepCode;
    }

    public void setCurrentStepCode(String currentStepCode) {
        this.currentStepCode = currentStepCode;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
    }

    public Long getResendAttemptCnt() {
        return resendAttemptCnt;
    }

    public void setResendAttemptCnt(Long resendAttemptCnt) {
        this.resendAttemptCnt = resendAttemptCnt;
    }

    public String getResendLastAttemptOn() {
        return resendLastAttemptOn;
    }

    public void setResendLastAttemptOn(String resendLastAttemptOn) {
        this.resendLastAttemptOn = resendLastAttemptOn;
    }

    public String getAadhaarConsentLangCode() {
        return aadhaarConsentLangCode;
    }

    public void setAadhaarConsentLangCode(String aadhaarConsentLangCode) {
        this.aadhaarConsentLangCode = aadhaarConsentLangCode;
    }

    public String getAadhaarMobile() {
        return aadhaarMobile;
    }

    public void setAadhaarMobile(String aadhaarMobile) {
        this.aadhaarMobile = aadhaarMobile;
    }

    public String getAadhaarName() {
        return aadhaarName;
    }

    public void setAadhaarName(String aadhaarName) {
        this.aadhaarName = aadhaarName;
    }

    public String getAadhaarAddress() {
        return aadhaarAddress;
    }

    public void setAadhaarAddress(String aadhaarAddress) {
        this.aadhaarAddress = aadhaarAddress;
    }

    public String getAadhaarGender() {
        return aadhaarGender;
    }

    public void setAadhaarGender(String aadhaarGender) {
        this.aadhaarGender = aadhaarGender;
    }

    public String getProductReqAccountRef() {
        return productReqAccountRef;
    }

    public void setProductReqAccountRef(String productReqAccountRef) {
        this.productReqAccountRef = productReqAccountRef;
    }

    public Integer getCurrentTxnID() {
        return currentTxnID;
    }

    public void setCurrentTxnID(Integer currentTxnID) {
        this.currentTxnID = currentTxnID;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getResendAttemptLockExpTime() {
        return resendAttemptLockExpTime;
    }

    public void setResendAttemptLockExpTime(String resendAttemptLockExpTime) {
        this.resendAttemptLockExpTime = resendAttemptLockExpTime;
    }

    public Long getSubmitOtpCount() {
        return submitOtpCount;
    }

    public void setSubmitOtpCount(Long submitOtpCount) {
        this.submitOtpCount = submitOtpCount;
    }

    public String getValidateOtpGenerateTime() {
        return validateOtpGenerateTime;
    }

    public void setValidateOtpGenerateTime(String validateOtpGenerateTime) {
        this.validateOtpGenerateTime = validateOtpGenerateTime;
    }

    public String getAadhaarDob() {
        return aadhaarDob;
    }

    public void setAadhaarDob(String aadhaarDob) {
        this.aadhaarDob = aadhaarDob;
    }

    public String getEkycLinkStatus() {
        return ekycLinkStatus;
    }

    public void setEkycLinkStatus(String ekycLinkStatus) {
        this.ekycLinkStatus = ekycLinkStatus;
    }

    public String getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.homeBranch = homeBranch;
    }

    public String getParentAccountNo() {
        return parentAccountNo;
    }

    public void setParentAccountNo(String parentAccountNo) {
        this.parentAccountNo = parentAccountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getNewUserCrn() {
        return newUserCrn;
    }

    public void setNewUserCrn(String newUserCrn) {
        this.newUserCrn = newUserCrn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAccountLinkStatus() {
        return accountLinkStatus;
    }

    public void setAccountLinkStatus(String accountLinkStatus) {
        this.accountLinkStatus = accountLinkStatus;
    }

    public Long getRegenLinkCount() {
        return regenLinkCount;
    }

    public void setRegenLinkCount(Long regenLinkCount) {
        this.regenLinkCount = regenLinkCount;
    }

    public Integer getOpsUserID() {
        return opsUserID;
    }

    public void setOpsUserID(Integer opsUserID) {
        this.opsUserID = opsUserID;
    }

    public String getAnnualIncomeSlab() {
        return annualIncomeSlab;
    }

    public void setAnnualIncomeSlab(String annualIncomeSlab) {
        this.annualIncomeSlab = annualIncomeSlab;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Long getEmailLinkOtpCount() {
        return emailLinkOtpCount;
    }

    public void setEmailLinkOtpCount(Long emailLinkOtpCount) {
        this.emailLinkOtpCount = emailLinkOtpCount;
    }

    public String getAadhaarUid() {
        return aadhaarUid;
    }

    public void setAadhaarUid(String aadhaarUid) {
        this.aadhaarUid = aadhaarUid;
    }

    public static class Builder {

        private FgEkycReq instance = new FgEkycReq();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder clientCrnRef(String clientCrnRef) {
            instance.setClientCrnRef(clientCrnRef);
            return this;
        }

        public Builder firstName(String firstName) {
            instance.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            instance.setLastName(lastName);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder fatherName(String fatherName) {
            instance.setFatherName(fatherName);
            return this;
        }

        public Builder motherMaidenName(String motherMaidenName) {
            instance.setMotherMaidenName(motherMaidenName);
            return this;
        }

        public Builder occupation(String occupation) {
            instance.setOccupation(occupation);
            return this;
        }

        public Builder gender(String gender) {
            instance.setGender(gender);
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            instance.setMaritalStatus(maritalStatus);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder entityReferenceID(Integer entityReferenceID) {
            instance.setEntityReferenceID(entityReferenceID);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder entityCustomerCrn(String entityCustomerCrn) {
            instance.setEntityCustomerCrn(entityCustomerCrn);
            return this;
        }

        public Builder entityApplicantUserCrn(String entityApplicantUserCrn) {
            instance.setEntityApplicantUserCrn(entityApplicantUserCrn);
            return this;
        }

        public Builder aadhaarOption(String aadhaarOption) {
            instance.setAadhaarOption(aadhaarOption);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder expiresOn(String expiresOn) {
            instance.setExpiresOn(expiresOn);
            return this;
        }

        public Builder ekycDisplayStatus(String ekycDisplayStatus) {
            instance.setEkycDisplayStatus(ekycDisplayStatus);
            return this;
        }

        public Builder emailStatusCode(String emailStatusCode) {
            instance.setEmailStatusCode(emailStatusCode);
            return this;
        }

        public Builder mobileStatusCode(String mobileStatusCode) {
            instance.setMobileStatusCode(mobileStatusCode);
            return this;
        }

        public Builder tcStatusCode(String tcStatusCode) {
            instance.setTcStatusCode(tcStatusCode);
            return this;
        }

        public Builder aadhaarConsentStatusCode(String aadhaarConsentStatusCode) {
            instance.setAadhaarConsentStatusCode(aadhaarConsentStatusCode);
            return this;
        }

        public Builder aadhaarVerifyStatusCode(String aadhaarVerifyStatusCode) {
            instance.setAadhaarVerifyStatusCode(aadhaarVerifyStatusCode);
            return this;
        }

        public Builder aadhaarInfoStatusCode(String aadhaarInfoStatusCode) {
            instance.setAadhaarInfoStatusCode(aadhaarInfoStatusCode);
            return this;
        }

        public Builder panLinkStatusCode(String panLinkStatusCode) {
            instance.setPanLinkStatusCode(panLinkStatusCode);
            return this;
        }

        public Builder panNameStatusCode(String panNameStatusCode) {
            instance.setPanNameStatusCode(panNameStatusCode);
            return this;
        }

        public Builder panVerifyStatusCode(String panVerifyStatusCode) {
            instance.setPanVerifyStatusCode(panVerifyStatusCode);
            return this;
        }

        public Builder personalInfoStatusCode(String personalInfoStatusCode) {
            instance.setPersonalInfoStatusCode(personalInfoStatusCode);
            return this;
        }

        public Builder aadhaarIDReferenceEnc(String aadhaarIDReferenceEnc) {
            instance.setAadhaarIDReferenceEnc(aadhaarIDReferenceEnc);
            return this;
        }

        public Builder aadhaarVidReferenceEnc(String aadhaarVidReferenceEnc) {
            instance.setAadhaarVidReferenceEnc(aadhaarVidReferenceEnc);
            return this;
        }

        public Builder aadhaarIDReferenceMask(String aadhaarIDReferenceMask) {
            instance.setAadhaarIDReferenceMask(aadhaarIDReferenceMask);
            return this;
        }

        public Builder aadhaarVidReferenceMask(String aadhaarVidReferenceMask) {
            instance.setAadhaarVidReferenceMask(aadhaarVidReferenceMask);
            return this;
        }

        public Builder panIDReferenceEnc(String panIDReferenceEnc) {
            instance.setPanIDReferenceEnc(panIDReferenceEnc);
            return this;
        }

        public Builder currentStepCode(String currentStepCode) {
            instance.setCurrentStepCode(currentStepCode);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
            return this;
        }

        public Builder resendAttemptCnt(Long resendAttemptCnt) {
            instance.setResendAttemptCnt(resendAttemptCnt);
            return this;
        }

        public Builder resendLastAttemptOn(String resendLastAttemptOn) {
            instance.setResendLastAttemptOn(resendLastAttemptOn);
            return this;
        }

        public Builder aadhaarConsentLangCode(String aadhaarConsentLangCode) {
            instance.setAadhaarConsentLangCode(aadhaarConsentLangCode);
            return this;
        }

        public Builder aadhaarMobile(String aadhaarMobile) {
            instance.setAadhaarMobile(aadhaarMobile);
            return this;
        }

        public Builder aadhaarName(String aadhaarName) {
            instance.setAadhaarName(aadhaarName);
            return this;
        }

        public Builder aadhaarAddress(String aadhaarAddress) {
            instance.setAadhaarAddress(aadhaarAddress);
            return this;
        }

        public Builder aadhaarGender(String aadhaarGender) {
            instance.setAadhaarGender(aadhaarGender);
            return this;
        }

        public Builder productReqAccountRef(String productReqAccountRef) {
            instance.setProductReqAccountRef(productReqAccountRef);
            return this;
        }

        public Builder currentTxnID(Integer currentTxnID) {
            instance.setCurrentTxnID(currentTxnID);
            return this;
        }

        public Builder panNumber(String panNumber) {
            instance.setPanNumber(panNumber);
            return this;
        }

        public Builder resendAttemptLockExpTime(String resendAttemptLockExpTime) {
            instance.setResendAttemptLockExpTime(resendAttemptLockExpTime);
            return this;
        }

        public Builder submitOtpCount(Long submitOtpCount) {
            instance.setSubmitOtpCount(submitOtpCount);
            return this;
        }

        public Builder validateOtpGenerateTime(String validateOtpGenerateTime) {
            instance.setValidateOtpGenerateTime(validateOtpGenerateTime);
            return this;
        }

        public Builder aadhaarDob(String aadhaarDob) {
            instance.setAadhaarDob(aadhaarDob);
            return this;
        }

        public Builder ekycLinkStatus(String ekycLinkStatus) {
            instance.setEkycLinkStatus(ekycLinkStatus);
            return this;
        }

        public Builder homeBranch(String homeBranch) {
            instance.setHomeBranch(homeBranch);
            return this;
        }

        public Builder parentAccountNo(String parentAccountNo) {
            instance.setParentAccountNo(parentAccountNo);
            return this;
        }

        public Builder accountType(String accountType) {
            instance.setAccountType(accountType);
            return this;
        }

        public Builder newUserCrn(String newUserCrn) {
            instance.setNewUserCrn(newUserCrn);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder accountLinkStatus(String accountLinkStatus) {
            instance.setAccountLinkStatus(accountLinkStatus);
            return this;
        }

        public Builder regenLinkCount(Long regenLinkCount) {
            instance.setRegenLinkCount(regenLinkCount);
            return this;
        }

        public Builder opsUserID(Integer opsUserID) {
            instance.setOpsUserID(opsUserID);
            return this;
        }

        public Builder annualIncomeSlab(String annualIncomeSlab) {
            instance.setAnnualIncomeSlab(annualIncomeSlab);
            return this;
        }

        public Builder annualIncome(String annualIncome) {
            instance.setAnnualIncome(annualIncome);
            return this;
        }

        public Builder emailLinkOtpCount(Long emailLinkOtpCount) {
            instance.setEmailLinkOtpCount(emailLinkOtpCount);
            return this;
        }

        public Builder aadhaarUid(String aadhaarUid) {
            instance.setAadhaarUid(aadhaarUid);
            return this;
        }

        public FgEkycReq build() {
            return instance;
        }
    }
}
