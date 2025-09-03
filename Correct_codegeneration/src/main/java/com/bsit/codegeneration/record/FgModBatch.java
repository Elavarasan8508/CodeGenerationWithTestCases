package com.bsit.codegeneration.record;

import java.util.List;

public record FgModBatch(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Integer versionID, Long isMasterVersion, Integer processID, String comments, String purposeCode, Long totalAmount, Long totalCount, Integer sourceRefID, String applicantPartyCode, String financeDisplayStatus, String programCode) {

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

        private Integer versionID;

        private Long isMasterVersion;

        private Integer processID;

        private String comments;

        private String purposeCode;

        private Long totalAmount;

        private Long totalCount;

        private Integer sourceRefID;

        private String applicantPartyCode;

        private String financeDisplayStatus;

        private String programCode;

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

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder sourceRefID(Integer sourceRefID) {
            this.sourceRefID = sourceRefID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder financeDisplayStatus(String financeDisplayStatus) {
            this.financeDisplayStatus = financeDisplayStatus;
            return this;
        }

        public Builder programCode(String programCode) {
            this.programCode = programCode;
            return this;
        }

        public FgModBatch build() {
            return new FgModBatch(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, versionID, isMasterVersion, processID, comments, purposeCode, totalAmount, totalCount, sourceRefID, applicantPartyCode, financeDisplayStatus, programCode);
        }
    }
}
