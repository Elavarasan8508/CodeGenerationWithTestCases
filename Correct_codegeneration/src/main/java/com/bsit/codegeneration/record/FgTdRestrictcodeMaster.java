package com.bsit.codegeneration.record;

import java.util.List;

public record FgTdRestrictcodeMaster(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String schemeCode, String schemeDescription, String type, Integer userID, String taskReason, Integer versionID, Long isMasterVersion, String schemeType, Integer parentRefID, Integer parentVersionID, String origin) {

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

        private String schemeCode;

        private String schemeDescription;

        private String type;

        private Integer userID;

        private String taskReason;

        private Integer versionID;

        private Long isMasterVersion;

        private String schemeType;

        private Integer parentRefID;

        private Integer parentVersionID;

        private String origin;

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

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder schemeDescription(String schemeDescription) {
            this.schemeDescription = schemeDescription;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder userID(Integer userID) {
            this.userID = userID;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
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

        public Builder schemeType(String schemeType) {
            this.schemeType = schemeType;
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public FgTdRestrictcodeMaster build() {
            return new FgTdRestrictcodeMaster(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, schemeCode, schemeDescription, type, userID, taskReason, versionID, isMasterVersion, schemeType, parentRefID, parentVersionID, origin);
        }
    }
}
