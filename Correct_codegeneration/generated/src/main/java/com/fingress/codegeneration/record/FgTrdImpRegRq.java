package com.bsit.codegeneration.record;

public record FgTrdImpRegRq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Long boeNumber, java.time.LocalDateTime boeDate, String ieCode, Long invoiceNumber, String portCode, String productStatus, String bankCode, String bankName, String tranReq, String reqType, String processID, String applicantParty, String issuingParty, String dmsEventID, String taskReason, Long nameMatch, Long checkbox, String bankUserID) {

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

        private Long boeNumber;

        private java.time.LocalDateTime boeDate;

        private String ieCode;

        private Long invoiceNumber;

        private String portCode;

        private String productStatus;

        private String bankCode;

        private String bankName;

        private String tranReq;

        private String reqType;

        private String processID;

        private String applicantParty;

        private String issuingParty;

        private String dmsEventID;

        private String taskReason;

        private Long nameMatch;

        private Long checkbox;

        private String bankUserID;

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

        public Builder bankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder tranReq(String tranReq) {
            this.tranReq = tranReq;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
            return this;
        }

        public Builder processID(String processID) {
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

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder nameMatch(Long nameMatch) {
            this.nameMatch = nameMatch;
            return this;
        }

        public Builder checkbox(Long checkbox) {
            this.checkbox = checkbox;
            return this;
        }

        public Builder bankUserID(String bankUserID) {
            this.bankUserID = bankUserID;
            return this;
        }

        public FgTrdImpRegRq build() {
            return new FgTrdImpRegRq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, boeNumber, boeDate, ieCode, invoiceNumber, portCode, productStatus, bankCode, bankName, tranReq, reqType, processID, applicantParty, issuingParty, dmsEventID, taskReason, nameMatch, checkbox, bankUserID);
        }
    }
}
