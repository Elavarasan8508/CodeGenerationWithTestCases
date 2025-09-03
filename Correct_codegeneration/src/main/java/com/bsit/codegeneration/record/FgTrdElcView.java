package com.bsit.codegeneration.record;

import java.util.List;

public record FgTrdElcView(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Integer kotakBillRefID, Integer issBankLcRefID, String tenor, String curCode, java.time.LocalDateTime lodgeDate, Long outstandingAmt, Long dspAmt, Long deduction, String reason, String applicantName, String applicantParty) {

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

        private Integer kotakBillRefID;

        private Integer issBankLcRefID;

        private String tenor;

        private String curCode;

        private java.time.LocalDateTime lodgeDate;

        private Long outstandingAmt;

        private Long dspAmt;

        private Long deduction;

        private String reason;

        private String applicantName;

        private String applicantParty;

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

        public Builder kotakBillRefID(Integer kotakBillRefID) {
            this.kotakBillRefID = kotakBillRefID;
            return this;
        }

        public Builder issBankLcRefID(Integer issBankLcRefID) {
            this.issBankLcRefID = issBankLcRefID;
            return this;
        }

        public Builder tenor(String tenor) {
            this.tenor = tenor;
            return this;
        }

        public Builder curCode(String curCode) {
            this.curCode = curCode;
            return this;
        }

        public Builder lodgeDate(java.time.LocalDateTime lodgeDate) {
            this.lodgeDate = lodgeDate;
            return this;
        }

        public Builder outstandingAmt(Long outstandingAmt) {
            this.outstandingAmt = outstandingAmt;
            return this;
        }

        public Builder dspAmt(Long dspAmt) {
            this.dspAmt = dspAmt;
            return this;
        }

        public Builder deduction(Long deduction) {
            this.deduction = deduction;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder applicantName(String applicantName) {
            this.applicantName = applicantName;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public FgTrdElcView build() {
            return new FgTrdElcView(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, kotakBillRefID, issBankLcRefID, tenor, curCode, lodgeDate, outstandingAmt, dspAmt, deduction, reason, applicantName, applicantParty);
        }
    }
}
