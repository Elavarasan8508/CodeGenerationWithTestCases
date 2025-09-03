package com.bsit.codegeneration.record;

import java.util.List;

public record LimitRenewalReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, Long corpCrn, String corpCrnName, Long userCrn, String userCrnName, java.time.LocalDateTime nextReviewDate, Long technicalFees, Long adminChrgs, Long procFee, Long totalGst, String remarks, String offerReference, String productStatusCode) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

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

        private Long corpCrn;

        private String corpCrnName;

        private Long userCrn;

        private String userCrnName;

        private java.time.LocalDateTime nextReviewDate;

        private Long technicalFees;

        private Long adminChrgs;

        private Long procFee;

        private Long totalGst;

        private String remarks;

        private String offerReference;

        private String productStatusCode;

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

        public Builder processID(Integer processID) {
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

        public Builder corpCrn(Long corpCrn) {
            this.corpCrn = corpCrn;
            return this;
        }

        public Builder corpCrnName(String corpCrnName) {
            this.corpCrnName = corpCrnName;
            return this;
        }

        public Builder userCrn(Long userCrn) {
            this.userCrn = userCrn;
            return this;
        }

        public Builder userCrnName(String userCrnName) {
            this.userCrnName = userCrnName;
            return this;
        }

        public Builder nextReviewDate(java.time.LocalDateTime nextReviewDate) {
            this.nextReviewDate = nextReviewDate;
            return this;
        }

        public Builder technicalFees(Long technicalFees) {
            this.technicalFees = technicalFees;
            return this;
        }

        public Builder adminChrgs(Long adminChrgs) {
            this.adminChrgs = adminChrgs;
            return this;
        }

        public Builder procFee(Long procFee) {
            this.procFee = procFee;
            return this;
        }

        public Builder totalGst(Long totalGst) {
            this.totalGst = totalGst;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder offerReference(String offerReference) {
            this.offerReference = offerReference;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public LimitRenewalReq build() {
            return new LimitRenewalReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, corpCrn, corpCrnName, userCrn, userCrnName, nextReviewDate, technicalFees, adminChrgs, procFee, totalGst, remarks, offerReference, productStatusCode);
        }
    }
}
