package com.bsit.codegeneration.record;

import java.util.List;

public record FgTrdImpRegRqVer(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Long boeNumber, java.time.LocalDateTime boeDate, String ieCode, Long invoiceNumber, String portCode, String productStatus, String reqType, Integer processID, String applicantParty, String issuingParty, Integer dmsEventID, Long checkbox, String ackMessage, String ackStatus, Long nameMatch, String generalDetails, String attachments, String preview, Long stepperCompletionPercentage, String taskReason, Integer bankUserID, Integer versionID, Long isMasterVersion) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

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

        private Long boeNumber;

        private java.time.LocalDateTime boeDate;

        private String ieCode;

        private Long invoiceNumber;

        private String portCode;

        private String productStatus;

        private String reqType;

        private Integer processID;

        private String applicantParty;

        private String issuingParty;

        private Integer dmsEventID;

        private Long checkbox;

        private String ackMessage;

        private String ackStatus;

        private Long nameMatch;

        private String generalDetails;

        private String attachments;

        private String preview;

        private Long stepperCompletionPercentage;

        private String taskReason;

        private Integer bankUserID;

        private Integer versionID;

        private Long isMasterVersion;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
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

        public Builder boeNumber(Long boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder invoiceNumber(Long invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder issuingParty(String issuingParty) {
            this.issuingParty = issuingParty;
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder checkbox(Long checkbox) {
            this.checkbox = checkbox;
            return this;
        }

        public Builder ackMessage(String ackMessage) {
            this.ackMessage = ackMessage;
            return this;
        }

        public Builder ackStatus(String ackStatus) {
            this.ackStatus = ackStatus;
            return this;
        }

        public Builder nameMatch(Long nameMatch) {
            this.nameMatch = nameMatch;
            return this;
        }

        public Builder generalDetails(String generalDetails) {
            this.generalDetails = generalDetails;
            return this;
        }

        public Builder attachments(String attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder preview(String preview) {
            this.preview = preview;
            return this;
        }

        public Builder stepperCompletionPercentage(Long stepperCompletionPercentage) {
            this.stepperCompletionPercentage = stepperCompletionPercentage;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder bankUserID(Integer bankUserID) {
            this.bankUserID = bankUserID;
            return this;
        }

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public FgTrdImpRegRqVer build() {
            return new FgTrdImpRegRqVer(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, boeNumber, boeDate, ieCode, invoiceNumber, portCode, productStatus, reqType, processID, applicantParty, issuingParty, dmsEventID, checkbox, ackMessage, ackStatus, nameMatch, generalDetails, attachments, preview, stepperCompletionPercentage, taskReason, bankUserID, versionID, isMasterVersion);
        }
    }
}
