package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgProductReq {

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

    private String customerCrn;

    private String applicantUserCrn;

    private java.time.LocalDateTime applicationDate;

    private java.time.LocalDateTime approvalDate;

    private java.time.LocalDateTime processedDate;

    private String userRole;

    private String userCrn;

    private String userName;

    private String userEmail;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String customerCity;

    private String customerPincode;

    private String productCodes;

    private String contactName;

    private String contactDesignation;

    private String contactEmail;

    private Long contactPhone;

    private Long contactMobile;

    private String parentAccountNo;

    private String accounts;

    private String reportName;

    private String reportRecipientEmail;

    private String applicationStage;

    private String applicationStatus;

    private String rejectReasonCode;

    private String rejectReason;

    private String notificationEnabled;

    private java.time.LocalDateTime accProcessedDate;

    private String customerState;

    private String customerName;

    private String approvalStatus;

    private String approvalDescription;

    private Integer processID;

    private Integer versionID;

    private Integer isMasterVersion;

    private String applicantPartyCode;

    private String issuingPartyCode;

    private String fullfilmentParty;

    private String productCode;

    private String name;

    private String description;

    private Boolean active;

    private String customerType;

    private String failureReason;

    private String parentAccountNo1;

    private String applicantUserName;

    private String prodNameDesc;

    private String customerTypeDesc;

    private String taskAction;

    private String taskReason;

    private java.time.LocalDateTime signatoryDate;

    private String signatoryDesc;

    private String enrichComments;

    private String fullfilmentComments;

    private String productDisplayStatus;

    private String showAuthStepper;

    private String authorisationType;

    private String modeOfOperation;

    private String slabType;

    private String tatStartTime;

    private String tatEndTime;

    private String userroleTrade;

    private String parentAccountName;

    private String displayStatus;

    private String parentAccountNoDisplay;

    private String parentAccountNoOrg;

    public FgProductReq() {
    }

    public FgProductReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String customerCrn, String applicantUserCrn, java.time.LocalDateTime applicationDate, java.time.LocalDateTime approvalDate, java.time.LocalDateTime processedDate, String userRole, String userCrn, String userName, String userEmail, String addressLine1, String addressLine2, String addressLine3, String customerCity, String customerPincode, String productCodes, String contactName, String contactDesignation, String contactEmail, Long contactPhone, Long contactMobile, String parentAccountNo, String accounts, String reportName, String reportRecipientEmail, String applicationStage, String applicationStatus, String rejectReasonCode, String rejectReason, String notificationEnabled, java.time.LocalDateTime accProcessedDate, String customerState, String customerName, String approvalStatus, String approvalDescription, Integer processID, Integer versionID, Integer isMasterVersion, String applicantPartyCode, String issuingPartyCode, String fullfilmentParty, String productCode, String name, String description, Boolean active, String customerType, String failureReason, String parentAccountNo1, String applicantUserName, String prodNameDesc, String customerTypeDesc, String taskAction, String taskReason, java.time.LocalDateTime signatoryDate, String signatoryDesc, String enrichComments, String fullfilmentComments, String productDisplayStatus, String showAuthStepper, String authorisationType, String modeOfOperation, String slabType, String tatStartTime, String tatEndTime, String userroleTrade, String parentAccountName, String displayStatus, String parentAccountNoDisplay, String parentAccountNoOrg) {
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
        this.customerCrn = customerCrn;
        this.applicantUserCrn = applicantUserCrn;
        this.applicationDate = applicationDate;
        this.approvalDate = approvalDate;
        this.processedDate = processedDate;
        this.userRole = userRole;
        this.userCrn = userCrn;
        this.userName = userName;
        this.userEmail = userEmail;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.customerCity = customerCity;
        this.customerPincode = customerPincode;
        this.productCodes = productCodes;
        this.contactName = contactName;
        this.contactDesignation = contactDesignation;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactMobile = contactMobile;
        this.parentAccountNo = parentAccountNo;
        this.accounts = accounts;
        this.reportName = reportName;
        this.reportRecipientEmail = reportRecipientEmail;
        this.applicationStage = applicationStage;
        this.applicationStatus = applicationStatus;
        this.rejectReasonCode = rejectReasonCode;
        this.rejectReason = rejectReason;
        this.notificationEnabled = notificationEnabled;
        this.accProcessedDate = accProcessedDate;
        this.customerState = customerState;
        this.customerName = customerName;
        this.approvalStatus = approvalStatus;
        this.approvalDescription = approvalDescription;
        this.processID = processID;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.applicantPartyCode = applicantPartyCode;
        this.issuingPartyCode = issuingPartyCode;
        this.fullfilmentParty = fullfilmentParty;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.active = active;
        this.customerType = customerType;
        this.failureReason = failureReason;
        this.parentAccountNo1 = parentAccountNo1;
        this.applicantUserName = applicantUserName;
        this.prodNameDesc = prodNameDesc;
        this.customerTypeDesc = customerTypeDesc;
        this.taskAction = taskAction;
        this.taskReason = taskReason;
        this.signatoryDate = signatoryDate;
        this.signatoryDesc = signatoryDesc;
        this.enrichComments = enrichComments;
        this.fullfilmentComments = fullfilmentComments;
        this.productDisplayStatus = productDisplayStatus;
        this.showAuthStepper = showAuthStepper;
        this.authorisationType = authorisationType;
        this.modeOfOperation = modeOfOperation;
        this.slabType = slabType;
        this.tatStartTime = tatStartTime;
        this.tatEndTime = tatEndTime;
        this.userroleTrade = userroleTrade;
        this.parentAccountName = parentAccountName;
        this.displayStatus = displayStatus;
        this.parentAccountNoDisplay = parentAccountNoDisplay;
        this.parentAccountNoOrg = parentAccountNoOrg;
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

    public String getCustomerCrn() {
        return customerCrn;
    }

    public void setCustomerCrn(String customerCrn) {
        this.customerCrn = customerCrn;
    }

    public String getApplicantUserCrn() {
        return applicantUserCrn;
    }

    public void setApplicantUserCrn(String applicantUserCrn) {
        this.applicantUserCrn = applicantUserCrn;
    }

    public java.time.LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(java.time.LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public java.time.LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(java.time.LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public java.time.LocalDateTime getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(java.time.LocalDateTime processedDate) {
        this.processedDate = processedDate;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserCrn() {
        return userCrn;
    }

    public void setUserCrn(String userCrn) {
        this.userCrn = userCrn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerPincode() {
        return customerPincode;
    }

    public void setCustomerPincode(String customerPincode) {
        this.customerPincode = customerPincode;
    }

    public String getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(String productCodes) {
        this.productCodes = productCodes;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactDesignation() {
        return contactDesignation;
    }

    public void setContactDesignation(String contactDesignation) {
        this.contactDesignation = contactDesignation;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(Long contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getParentAccountNo() {
        return parentAccountNo;
    }

    public void setParentAccountNo(String parentAccountNo) {
        this.parentAccountNo = parentAccountNo;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportRecipientEmail() {
        return reportRecipientEmail;
    }

    public void setReportRecipientEmail(String reportRecipientEmail) {
        this.reportRecipientEmail = reportRecipientEmail;
    }

    public String getApplicationStage() {
        return applicationStage;
    }

    public void setApplicationStage(String applicationStage) {
        this.applicationStage = applicationStage;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getRejectReasonCode() {
        return rejectReasonCode;
    }

    public void setRejectReasonCode(String rejectReasonCode) {
        this.rejectReasonCode = rejectReasonCode;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(String notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public java.time.LocalDateTime getAccProcessedDate() {
        return accProcessedDate;
    }

    public void setAccProcessedDate(java.time.LocalDateTime accProcessedDate) {
        this.accProcessedDate = accProcessedDate;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalDescription() {
        return approvalDescription;
    }

    public void setApprovalDescription(String approvalDescription) {
        this.approvalDescription = approvalDescription;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
    }

    public String getFullfilmentParty() {
        return fullfilmentParty;
    }

    public void setFullfilmentParty(String fullfilmentParty) {
        this.fullfilmentParty = fullfilmentParty;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getParentAccountNo1() {
        return parentAccountNo1;
    }

    public void setParentAccountNo1(String parentAccountNo1) {
        this.parentAccountNo1 = parentAccountNo1;
    }

    public String getApplicantUserName() {
        return applicantUserName;
    }

    public void setApplicantUserName(String applicantUserName) {
        this.applicantUserName = applicantUserName;
    }

    public String getProdNameDesc() {
        return prodNameDesc;
    }

    public void setProdNameDesc(String prodNameDesc) {
        this.prodNameDesc = prodNameDesc;
    }

    public String getCustomerTypeDesc() {
        return customerTypeDesc;
    }

    public void setCustomerTypeDesc(String customerTypeDesc) {
        this.customerTypeDesc = customerTypeDesc;
    }

    public String getTaskAction() {
        return taskAction;
    }

    public void setTaskAction(String taskAction) {
        this.taskAction = taskAction;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public java.time.LocalDateTime getSignatoryDate() {
        return signatoryDate;
    }

    public void setSignatoryDate(java.time.LocalDateTime signatoryDate) {
        this.signatoryDate = signatoryDate;
    }

    public String getSignatoryDesc() {
        return signatoryDesc;
    }

    public void setSignatoryDesc(String signatoryDesc) {
        this.signatoryDesc = signatoryDesc;
    }

    public String getEnrichComments() {
        return enrichComments;
    }

    public void setEnrichComments(String enrichComments) {
        this.enrichComments = enrichComments;
    }

    public String getFullfilmentComments() {
        return fullfilmentComments;
    }

    public void setFullfilmentComments(String fullfilmentComments) {
        this.fullfilmentComments = fullfilmentComments;
    }

    public String getProductDisplayStatus() {
        return productDisplayStatus;
    }

    public void setProductDisplayStatus(String productDisplayStatus) {
        this.productDisplayStatus = productDisplayStatus;
    }

    public String getShowAuthStepper() {
        return showAuthStepper;
    }

    public void setShowAuthStepper(String showAuthStepper) {
        this.showAuthStepper = showAuthStepper;
    }

    public String getAuthorisationType() {
        return authorisationType;
    }

    public void setAuthorisationType(String authorisationType) {
        this.authorisationType = authorisationType;
    }

    public String getModeOfOperation() {
        return modeOfOperation;
    }

    public void setModeOfOperation(String modeOfOperation) {
        this.modeOfOperation = modeOfOperation;
    }

    public String getSlabType() {
        return slabType;
    }

    public void setSlabType(String slabType) {
        this.slabType = slabType;
    }

    public String getTatStartTime() {
        return tatStartTime;
    }

    public void setTatStartTime(String tatStartTime) {
        this.tatStartTime = tatStartTime;
    }

    public String getTatEndTime() {
        return tatEndTime;
    }

    public void setTatEndTime(String tatEndTime) {
        this.tatEndTime = tatEndTime;
    }

    public String getUserroleTrade() {
        return userroleTrade;
    }

    public void setUserroleTrade(String userroleTrade) {
        this.userroleTrade = userroleTrade;
    }

    public String getParentAccountName() {
        return parentAccountName;
    }

    public void setParentAccountName(String parentAccountName) {
        this.parentAccountName = parentAccountName;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getParentAccountNoDisplay() {
        return parentAccountNoDisplay;
    }

    public void setParentAccountNoDisplay(String parentAccountNoDisplay) {
        this.parentAccountNoDisplay = parentAccountNoDisplay;
    }

    public String getParentAccountNoOrg() {
        return parentAccountNoOrg;
    }

    public void setParentAccountNoOrg(String parentAccountNoOrg) {
        this.parentAccountNoOrg = parentAccountNoOrg;
    }

    public static class Builder {

        private FgProductReq instance = new FgProductReq();

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

        public Builder customerCrn(String customerCrn) {
            instance.setCustomerCrn(customerCrn);
            return this;
        }

        public Builder applicantUserCrn(String applicantUserCrn) {
            instance.setApplicantUserCrn(applicantUserCrn);
            return this;
        }

        public Builder applicationDate(java.time.LocalDateTime applicationDate) {
            instance.setApplicationDate(applicationDate);
            return this;
        }

        public Builder approvalDate(java.time.LocalDateTime approvalDate) {
            instance.setApprovalDate(approvalDate);
            return this;
        }

        public Builder processedDate(java.time.LocalDateTime processedDate) {
            instance.setProcessedDate(processedDate);
            return this;
        }

        public Builder userRole(String userRole) {
            instance.setUserRole(userRole);
            return this;
        }

        public Builder userCrn(String userCrn) {
            instance.setUserCrn(userCrn);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder userEmail(String userEmail) {
            instance.setUserEmail(userEmail);
            return this;
        }

        public Builder addressLine1(String addressLine1) {
            instance.setAddressLine1(addressLine1);
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            instance.setAddressLine2(addressLine2);
            return this;
        }

        public Builder addressLine3(String addressLine3) {
            instance.setAddressLine3(addressLine3);
            return this;
        }

        public Builder customerCity(String customerCity) {
            instance.setCustomerCity(customerCity);
            return this;
        }

        public Builder customerPincode(String customerPincode) {
            instance.setCustomerPincode(customerPincode);
            return this;
        }

        public Builder productCodes(String productCodes) {
            instance.setProductCodes(productCodes);
            return this;
        }

        public Builder contactName(String contactName) {
            instance.setContactName(contactName);
            return this;
        }

        public Builder contactDesignation(String contactDesignation) {
            instance.setContactDesignation(contactDesignation);
            return this;
        }

        public Builder contactEmail(String contactEmail) {
            instance.setContactEmail(contactEmail);
            return this;
        }

        public Builder contactPhone(Long contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder contactMobile(Long contactMobile) {
            instance.setContactMobile(contactMobile);
            return this;
        }

        public Builder parentAccountNo(String parentAccountNo) {
            instance.setParentAccountNo(parentAccountNo);
            return this;
        }

        public Builder accounts(String accounts) {
            instance.setAccounts(accounts);
            return this;
        }

        public Builder reportName(String reportName) {
            instance.setReportName(reportName);
            return this;
        }

        public Builder reportRecipientEmail(String reportRecipientEmail) {
            instance.setReportRecipientEmail(reportRecipientEmail);
            return this;
        }

        public Builder applicationStage(String applicationStage) {
            instance.setApplicationStage(applicationStage);
            return this;
        }

        public Builder applicationStatus(String applicationStatus) {
            instance.setApplicationStatus(applicationStatus);
            return this;
        }

        public Builder rejectReasonCode(String rejectReasonCode) {
            instance.setRejectReasonCode(rejectReasonCode);
            return this;
        }

        public Builder rejectReason(String rejectReason) {
            instance.setRejectReason(rejectReason);
            return this;
        }

        public Builder notificationEnabled(String notificationEnabled) {
            instance.setNotificationEnabled(notificationEnabled);
            return this;
        }

        public Builder accProcessedDate(java.time.LocalDateTime accProcessedDate) {
            instance.setAccProcessedDate(accProcessedDate);
            return this;
        }

        public Builder customerState(String customerState) {
            instance.setCustomerState(customerState);
            return this;
        }

        public Builder customerName(String customerName) {
            instance.setCustomerName(customerName);
            return this;
        }

        public Builder approvalStatus(String approvalStatus) {
            instance.setApprovalStatus(approvalStatus);
            return this;
        }

        public Builder approvalDescription(String approvalDescription) {
            instance.setApprovalDescription(approvalDescription);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
            return this;
        }

        public Builder fullfilmentParty(String fullfilmentParty) {
            instance.setFullfilmentParty(fullfilmentParty);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder active(Boolean active) {
            instance.setActive(active);
            return this;
        }

        public Builder customerType(String customerType) {
            instance.setCustomerType(customerType);
            return this;
        }

        public Builder failureReason(String failureReason) {
            instance.setFailureReason(failureReason);
            return this;
        }

        public Builder parentAccountNo1(String parentAccountNo1) {
            instance.setParentAccountNo1(parentAccountNo1);
            return this;
        }

        public Builder applicantUserName(String applicantUserName) {
            instance.setApplicantUserName(applicantUserName);
            return this;
        }

        public Builder prodNameDesc(String prodNameDesc) {
            instance.setProdNameDesc(prodNameDesc);
            return this;
        }

        public Builder customerTypeDesc(String customerTypeDesc) {
            instance.setCustomerTypeDesc(customerTypeDesc);
            return this;
        }

        public Builder taskAction(String taskAction) {
            instance.setTaskAction(taskAction);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder signatoryDate(java.time.LocalDateTime signatoryDate) {
            instance.setSignatoryDate(signatoryDate);
            return this;
        }

        public Builder signatoryDesc(String signatoryDesc) {
            instance.setSignatoryDesc(signatoryDesc);
            return this;
        }

        public Builder enrichComments(String enrichComments) {
            instance.setEnrichComments(enrichComments);
            return this;
        }

        public Builder fullfilmentComments(String fullfilmentComments) {
            instance.setFullfilmentComments(fullfilmentComments);
            return this;
        }

        public Builder productDisplayStatus(String productDisplayStatus) {
            instance.setProductDisplayStatus(productDisplayStatus);
            return this;
        }

        public Builder showAuthStepper(String showAuthStepper) {
            instance.setShowAuthStepper(showAuthStepper);
            return this;
        }

        public Builder authorisationType(String authorisationType) {
            instance.setAuthorisationType(authorisationType);
            return this;
        }

        public Builder modeOfOperation(String modeOfOperation) {
            instance.setModeOfOperation(modeOfOperation);
            return this;
        }

        public Builder slabType(String slabType) {
            instance.setSlabType(slabType);
            return this;
        }

        public Builder tatStartTime(String tatStartTime) {
            instance.setTatStartTime(tatStartTime);
            return this;
        }

        public Builder tatEndTime(String tatEndTime) {
            instance.setTatEndTime(tatEndTime);
            return this;
        }

        public Builder userroleTrade(String userroleTrade) {
            instance.setUserroleTrade(userroleTrade);
            return this;
        }

        public Builder parentAccountName(String parentAccountName) {
            instance.setParentAccountName(parentAccountName);
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            instance.setDisplayStatus(displayStatus);
            return this;
        }

        public Builder parentAccountNoDisplay(String parentAccountNoDisplay) {
            instance.setParentAccountNoDisplay(parentAccountNoDisplay);
            return this;
        }

        public Builder parentAccountNoOrg(String parentAccountNoOrg) {
            instance.setParentAccountNoOrg(parentAccountNoOrg);
            return this;
        }

        public FgProductReq build() {
            return instance;
        }
    }
}
