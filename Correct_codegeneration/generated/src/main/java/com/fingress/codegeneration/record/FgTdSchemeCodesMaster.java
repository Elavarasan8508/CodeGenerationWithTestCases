package com.bsit.codegeneration.record;

public record FgTdSchemeCodesMaster(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String tenor, String interestValue, String finSchemeCode, String interestCalculation, Long startTenor, Long endTenor, Long versionID, Long isMasterVersion, String taskReason, String parentVersionID, String parentRefID, String origin, String accountSchemeCode, String tdType, Long minAmount, Long maxAmount, String tdRequest) {

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

        private String tenor;

        private String interestValue;

        private String finSchemeCode;

        private String interestCalculation;

        private Long startTenor;

        private Long endTenor;

        private Long versionID;

        private Long isMasterVersion;

        private String taskReason;

        private String parentVersionID;

        private String parentRefID;

        private String origin;

        private String accountSchemeCode;

        private String tdType;

        private Long minAmount;

        private Long maxAmount;

        private String tdRequest;

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

        public Builder tenor(String tenor) {
            this.tenor = tenor;
            return this;
        }

        public Builder interestValue(String interestValue) {
            this.interestValue = interestValue;
            return this;
        }

        public Builder finSchemeCode(String finSchemeCode) {
            this.finSchemeCode = finSchemeCode;
            return this;
        }

        public Builder interestCalculation(String interestCalculation) {
            this.interestCalculation = interestCalculation;
            return this;
        }

        public Builder startTenor(Long startTenor) {
            this.startTenor = startTenor;
            return this;
        }

        public Builder endTenor(Long endTenor) {
            this.endTenor = endTenor;
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

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder parentVersionID(String parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder accountSchemeCode(String accountSchemeCode) {
            this.accountSchemeCode = accountSchemeCode;
            return this;
        }

        public Builder tdType(String tdType) {
            this.tdType = tdType;
            return this;
        }

        public Builder minAmount(Long minAmount) {
            this.minAmount = minAmount;
            return this;
        }

        public Builder maxAmount(Long maxAmount) {
            this.maxAmount = maxAmount;
            return this;
        }

        public Builder tdRequest(String tdRequest) {
            this.tdRequest = tdRequest;
            return this;
        }

        public FgTdSchemeCodesMaster build() {
            return new FgTdSchemeCodesMaster(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, tenor, interestValue, finSchemeCode, interestCalculation, startTenor, endTenor, versionID, isMasterVersion, taskReason, parentVersionID, parentRefID, origin, accountSchemeCode, tdType, minAmount, maxAmount, tdRequest);
        }
    }
}
