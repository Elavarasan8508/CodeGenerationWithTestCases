package com.bsit.codegeneration.record;

public record FgTrdPostings(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String customer, String nostroReference, String portalReference, String postingRequest, String status, String postingResponse, String tiMasterRef, String tiProductCode, String theirReference, String product, String tiStatus, Long eventSerial, String eventPrefix, String billNo) {

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

        private String customer;

        private String nostroReference;

        private String portalReference;

        private String postingRequest;

        private String status;

        private String postingResponse;

        private String tiMasterRef;

        private String tiProductCode;

        private String theirReference;

        private String product;

        private String tiStatus;

        private Long eventSerial;

        private String eventPrefix;

        private String billNo;

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

        public Builder customer(String customer) {
            this.customer = customer;
            return this;
        }

        public Builder nostroReference(String nostroReference) {
            this.nostroReference = nostroReference;
            return this;
        }

        public Builder portalReference(String portalReference) {
            this.portalReference = portalReference;
            return this;
        }

        public Builder postingRequest(String postingRequest) {
            this.postingRequest = postingRequest;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder postingResponse(String postingResponse) {
            this.postingResponse = postingResponse;
            return this;
        }

        public Builder tiMasterRef(String tiMasterRef) {
            this.tiMasterRef = tiMasterRef;
            return this;
        }

        public Builder tiProductCode(String tiProductCode) {
            this.tiProductCode = tiProductCode;
            return this;
        }

        public Builder theirReference(String theirReference) {
            this.theirReference = theirReference;
            return this;
        }

        public Builder product(String product) {
            this.product = product;
            return this;
        }

        public Builder tiStatus(String tiStatus) {
            this.tiStatus = tiStatus;
            return this;
        }

        public Builder eventSerial(Long eventSerial) {
            this.eventSerial = eventSerial;
            return this;
        }

        public Builder eventPrefix(String eventPrefix) {
            this.eventPrefix = eventPrefix;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public FgTrdPostings build() {
            return new FgTrdPostings(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, customer, nostroReference, portalReference, postingRequest, status, postingResponse, tiMasterRef, tiProductCode, theirReference, product, tiStatus, eventSerial, eventPrefix, billNo);
        }
    }
}
