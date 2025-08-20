package com.bsit.codegeneration.record;

public record DoSmartCollect(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantUserCrn, String fulfillmentParty, Long isTemplate, String companyName, String accountNumber, String mailingAddress, String contactPerson, Long contactMobileNumber, String applicationReference, String reportingFrequency, String productName, String productDisplayStatus, String tatStartTime, String tatEndTime, String existingUserName, String userEmail, String issuingPartyCode, String customerTypeDesc, String applicantUserName, String makerComments, String taskReason, String companyCrn) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantUserCrn;

        private String fulfillmentParty;

        private Long isTemplate;

        private String companyName;

        private String accountNumber;

        private String mailingAddress;

        private String contactPerson;

        private Long contactMobileNumber;

        private String applicationReference;

        private String reportingFrequency;

        private String productName;

        private String productDisplayStatus;

        private String tatStartTime;

        private String tatEndTime;

        private String existingUserName;

        private String userEmail;

        private String issuingPartyCode;

        private String customerTypeDesc;

        private String applicantUserName;

        private String makerComments;

        private String taskReason;

        private String companyCrn;

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

        public Builder processID(String processID) {
            this.processID = processID;
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

        public Builder applicantUserCrn(String applicantUserCrn) {
            this.applicantUserCrn = applicantUserCrn;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder mailingAddress(String mailingAddress) {
            this.mailingAddress = mailingAddress;
            return this;
        }

        public Builder contactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder contactMobileNumber(Long contactMobileNumber) {
            this.contactMobileNumber = contactMobileNumber;
            return this;
        }

        public Builder applicationReference(String applicationReference) {
            this.applicationReference = applicationReference;
            return this;
        }

        public Builder reportingFrequency(String reportingFrequency) {
            this.reportingFrequency = reportingFrequency;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productDisplayStatus(String productDisplayStatus) {
            this.productDisplayStatus = productDisplayStatus;
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

        public Builder existingUserName(String existingUserName) {
            this.existingUserName = existingUserName;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder customerTypeDesc(String customerTypeDesc) {
            this.customerTypeDesc = customerTypeDesc;
            return this;
        }

        public Builder applicantUserName(String applicantUserName) {
            this.applicantUserName = applicantUserName;
            return this;
        }

        public Builder makerComments(String makerComments) {
            this.makerComments = makerComments;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder companyCrn(String companyCrn) {
            this.companyCrn = companyCrn;
            return this;
        }

        public DoSmartCollect build() {
            return new DoSmartCollect(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantUserCrn, fulfillmentParty, isTemplate, companyName, accountNumber, mailingAddress, contactPerson, contactMobileNumber, applicationReference, reportingFrequency, productName, productDisplayStatus, tatStartTime, tatEndTime, existingUserName, userEmail, issuingPartyCode, customerTypeDesc, applicantUserName, makerComments, taskReason, companyCrn);
        }
    }
}
