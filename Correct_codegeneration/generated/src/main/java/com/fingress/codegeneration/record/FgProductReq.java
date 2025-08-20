package com.bsit.codegeneration.record;

public record FgProductReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String customerCrn, String applicantUserCrn, java.time.LocalDateTime applicationDate, java.time.LocalDateTime approvalDate, java.time.LocalDateTime processedDate, String userRole, String userCrn, String userName, String userEmail, String addressLine1, String addressLine2, String addressLine3, String customerCity, String customerPincode, String productCodes, String contactName, String contactDesignation, String contactEmail, Long contactPhone, Long contactMobile, String parentAccountNo, String accounts, String reportName, String reportRecipientEmail, String applicationStage, String applicationStatus, String rejectReasonCode, String rejectReason, String notificationEnabled, java.time.LocalDateTime accProcessedDate, String customerState, String customerName, String approvalStatus, String approvalDescription, String processID, Long versionID, Long isMasterVersion, String applicantPartyCode, String issuingPartyCode, String fullfilmentParty, String productCode, String name, String description, String active, String customerType, String failureReason, String parentAccountNo1, String applicantUserName, String prodNameDesc, String customerTypeDesc, String taskAction, String taskReason, java.time.LocalDateTime signatoryDate, String signatoryDesc, String enrichComments, String fullfilmentComments, String productDisplayStatus, String showAuthStepper, String authorisationType, String modeOfOperation, String slabType, String tatStartTime, String tatEndTime, String userroleTrade, String parentAccountName, String displayStatus, String parentAccountNoDisplay, String parentAccountNoOrg) {

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

        private String processID;

        private Long versionID;

        private Long isMasterVersion;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private String fullfilmentParty;

        private String productCode;

        private String name;

        private String description;

        private String active;

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

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder applicantUserCrn(String applicantUserCrn) {
            this.applicantUserCrn = applicantUserCrn;
            return this;
        }

        public Builder applicationDate(java.time.LocalDateTime applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder approvalDate(java.time.LocalDateTime approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        public Builder processedDate(java.time.LocalDateTime processedDate) {
            this.processedDate = processedDate;
            return this;
        }

        public Builder userRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder userCrn(String userCrn) {
            this.userCrn = userCrn;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder addressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        public Builder customerCity(String customerCity) {
            this.customerCity = customerCity;
            return this;
        }

        public Builder customerPincode(String customerPincode) {
            this.customerPincode = customerPincode;
            return this;
        }

        public Builder productCodes(String productCodes) {
            this.productCodes = productCodes;
            return this;
        }

        public Builder contactName(String contactName) {
            this.contactName = contactName;
            return this;
        }

        public Builder contactDesignation(String contactDesignation) {
            this.contactDesignation = contactDesignation;
            return this;
        }

        public Builder contactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }

        public Builder contactPhone(Long contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public Builder contactMobile(Long contactMobile) {
            this.contactMobile = contactMobile;
            return this;
        }

        public Builder parentAccountNo(String parentAccountNo) {
            this.parentAccountNo = parentAccountNo;
            return this;
        }

        public Builder accounts(String accounts) {
            this.accounts = accounts;
            return this;
        }

        public Builder reportName(String reportName) {
            this.reportName = reportName;
            return this;
        }

        public Builder reportRecipientEmail(String reportRecipientEmail) {
            this.reportRecipientEmail = reportRecipientEmail;
            return this;
        }

        public Builder applicationStage(String applicationStage) {
            this.applicationStage = applicationStage;
            return this;
        }

        public Builder applicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
            return this;
        }

        public Builder rejectReasonCode(String rejectReasonCode) {
            this.rejectReasonCode = rejectReasonCode;
            return this;
        }

        public Builder rejectReason(String rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder notificationEnabled(String notificationEnabled) {
            this.notificationEnabled = notificationEnabled;
            return this;
        }

        public Builder accProcessedDate(java.time.LocalDateTime accProcessedDate) {
            this.accProcessedDate = accProcessedDate;
            return this;
        }

        public Builder customerState(String customerState) {
            this.customerState = customerState;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder approvalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
            return this;
        }

        public Builder approvalDescription(String approvalDescription) {
            this.approvalDescription = approvalDescription;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
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

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder fullfilmentParty(String fullfilmentParty) {
            this.fullfilmentParty = fullfilmentParty;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder active(String active) {
            this.active = active;
            return this;
        }

        public Builder customerType(String customerType) {
            this.customerType = customerType;
            return this;
        }

        public Builder failureReason(String failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        public Builder parentAccountNo1(String parentAccountNo1) {
            this.parentAccountNo1 = parentAccountNo1;
            return this;
        }

        public Builder applicantUserName(String applicantUserName) {
            this.applicantUserName = applicantUserName;
            return this;
        }

        public Builder prodNameDesc(String prodNameDesc) {
            this.prodNameDesc = prodNameDesc;
            return this;
        }

        public Builder customerTypeDesc(String customerTypeDesc) {
            this.customerTypeDesc = customerTypeDesc;
            return this;
        }

        public Builder taskAction(String taskAction) {
            this.taskAction = taskAction;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder signatoryDate(java.time.LocalDateTime signatoryDate) {
            this.signatoryDate = signatoryDate;
            return this;
        }

        public Builder signatoryDesc(String signatoryDesc) {
            this.signatoryDesc = signatoryDesc;
            return this;
        }

        public Builder enrichComments(String enrichComments) {
            this.enrichComments = enrichComments;
            return this;
        }

        public Builder fullfilmentComments(String fullfilmentComments) {
            this.fullfilmentComments = fullfilmentComments;
            return this;
        }

        public Builder productDisplayStatus(String productDisplayStatus) {
            this.productDisplayStatus = productDisplayStatus;
            return this;
        }

        public Builder showAuthStepper(String showAuthStepper) {
            this.showAuthStepper = showAuthStepper;
            return this;
        }

        public Builder authorisationType(String authorisationType) {
            this.authorisationType = authorisationType;
            return this;
        }

        public Builder modeOfOperation(String modeOfOperation) {
            this.modeOfOperation = modeOfOperation;
            return this;
        }

        public Builder slabType(String slabType) {
            this.slabType = slabType;
            return this;
        }

        public Builder tatStartTime(String tatStartTime) {
            this.tatStartTime = tatStartTime;
            return this;
        }

        public Builder tatEndTime(String tatEndTime) {
            this.tatEndTime = tatEndTime;
            return this;
        }

        public Builder userroleTrade(String userroleTrade) {
            this.userroleTrade = userroleTrade;
            return this;
        }

        public Builder parentAccountName(String parentAccountName) {
            this.parentAccountName = parentAccountName;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder parentAccountNoDisplay(String parentAccountNoDisplay) {
            this.parentAccountNoDisplay = parentAccountNoDisplay;
            return this;
        }

        public Builder parentAccountNoOrg(String parentAccountNoOrg) {
            this.parentAccountNoOrg = parentAccountNoOrg;
            return this;
        }

        public FgProductReq build() {
            return new FgProductReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, customerCrn, applicantUserCrn, applicationDate, approvalDate, processedDate, userRole, userCrn, userName, userEmail, addressLine1, addressLine2, addressLine3, customerCity, customerPincode, productCodes, contactName, contactDesignation, contactEmail, contactPhone, contactMobile, parentAccountNo, accounts, reportName, reportRecipientEmail, applicationStage, applicationStatus, rejectReasonCode, rejectReason, notificationEnabled, accProcessedDate, customerState, customerName, approvalStatus, approvalDescription, processID, versionID, isMasterVersion, applicantPartyCode, issuingPartyCode, fullfilmentParty, productCode, name, description, active, customerType, failureReason, parentAccountNo1, applicantUserName, prodNameDesc, customerTypeDesc, taskAction, taskReason, signatoryDate, signatoryDesc, enrichComments, fullfilmentComments, productDisplayStatus, showAuthStepper, authorisationType, modeOfOperation, slabType, tatStartTime, tatEndTime, userroleTrade, parentAccountName, displayStatus, parentAccountNoDisplay, parentAccountNoOrg);
        }
    }
}
