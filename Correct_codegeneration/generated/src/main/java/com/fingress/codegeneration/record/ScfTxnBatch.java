package com.bsit.codegeneration.record;

public record ScfTxnBatch(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String anchorCrn, String fileMasterRefNo, String scfReqRefNo, Long txnBatchCount, String productType, String utrRefNo, String financeRefNo, String status, String remarks, String eventsPayResRefNo, String cmsRefNo, String purposeCode, Long totalCount, Long totalAmount) {

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

        private String anchorCrn;

        private String fileMasterRefNo;

        private String scfReqRefNo;

        private Long txnBatchCount;

        private String productType;

        private String utrRefNo;

        private String financeRefNo;

        private String status;

        private String remarks;

        private String eventsPayResRefNo;

        private String cmsRefNo;

        private String purposeCode;

        private Long totalCount;

        private Long totalAmount;

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

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            this.fileMasterRefNo = fileMasterRefNo;
            return this;
        }

        public Builder scfReqRefNo(String scfReqRefNo) {
            this.scfReqRefNo = scfReqRefNo;
            return this;
        }

        public Builder txnBatchCount(Long txnBatchCount) {
            this.txnBatchCount = txnBatchCount;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder utrRefNo(String utrRefNo) {
            this.utrRefNo = utrRefNo;
            return this;
        }

        public Builder financeRefNo(String financeRefNo) {
            this.financeRefNo = financeRefNo;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder eventsPayResRefNo(String eventsPayResRefNo) {
            this.eventsPayResRefNo = eventsPayResRefNo;
            return this;
        }

        public Builder cmsRefNo(String cmsRefNo) {
            this.cmsRefNo = cmsRefNo;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public ScfTxnBatch build() {
            return new ScfTxnBatch(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, anchorCrn, fileMasterRefNo, scfReqRefNo, txnBatchCount, productType, utrRefNo, financeRefNo, status, remarks, eventsPayResRefNo, cmsRefNo, purposeCode, totalCount, totalAmount);
        }
    }
}
