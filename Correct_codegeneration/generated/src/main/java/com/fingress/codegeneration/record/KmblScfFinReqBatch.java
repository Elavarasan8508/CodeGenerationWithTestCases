package com.bsit.codegeneration.record;

public record KmblScfFinReqBatch(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String partyType, String customerCrn, String programLayout, java.time.LocalDateTime batchValueDate, String loanRefID, java.time.LocalDateTime loanDueDate, Long requestAmount, String ccy, String returnText, Long batchAmount, String limitNodeReference, Long snapshotLimit, String remarks) {

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

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private String partyType;

        private String customerCrn;

        private String programLayout;

        private java.time.LocalDateTime batchValueDate;

        private String loanRefID;

        private java.time.LocalDateTime loanDueDate;

        private Long requestAmount;

        private String ccy;

        private String returnText;

        private Long batchAmount;

        private String limitNodeReference;

        private Long snapshotLimit;

        private String remarks;

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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
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

        public Builder partyType(String partyType) {
            this.partyType = partyType;
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder programLayout(String programLayout) {
            this.programLayout = programLayout;
            return this;
        }

        public Builder batchValueDate(java.time.LocalDateTime batchValueDate) {
            this.batchValueDate = batchValueDate;
            return this;
        }

        public Builder loanRefID(String loanRefID) {
            this.loanRefID = loanRefID;
            return this;
        }

        public Builder loanDueDate(java.time.LocalDateTime loanDueDate) {
            this.loanDueDate = loanDueDate;
            return this;
        }

        public Builder requestAmount(Long requestAmount) {
            this.requestAmount = requestAmount;
            return this;
        }

        public Builder ccy(String ccy) {
            this.ccy = ccy;
            return this;
        }

        public Builder returnText(String returnText) {
            this.returnText = returnText;
            return this;
        }

        public Builder batchAmount(Long batchAmount) {
            this.batchAmount = batchAmount;
            return this;
        }

        public Builder limitNodeReference(String limitNodeReference) {
            this.limitNodeReference = limitNodeReference;
            return this;
        }

        public Builder snapshotLimit(Long snapshotLimit) {
            this.snapshotLimit = snapshotLimit;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public KmblScfFinReqBatch build() {
            return new KmblScfFinReqBatch(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, partyType, customerCrn, programLayout, batchValueDate, loanRefID, loanDueDate, requestAmount, ccy, returnText, batchAmount, limitNodeReference, snapshotLimit, remarks);
        }
    }
}
