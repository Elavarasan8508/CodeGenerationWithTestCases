package com.bsit.codegeneration.record;

import java.util.List;

public record FgAlertCode(Integer ID, String entitySubTypeCode, String entityTypeCode, String name, String template, String typeCode, String subTypeCode, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Integer processID, Integer referenceID, Integer partyID, Integer partyVersionID, Integer versionID, Long isMasterVersion, String stageCode, String applicantPartyCode) {

    public static class Builder {

        private Integer ID;

        private String entitySubTypeCode;

        private String entityTypeCode;

        private String name;

        private String template;

        private String typeCode;

        private String subTypeCode;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Integer processID;

        private Integer referenceID;

        private Integer partyID;

        private Integer partyVersionID;

        private Integer versionID;

        private Long isMasterVersion;

        private String stageCode;

        private String applicantPartyCode;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
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

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
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

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
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

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public FgAlertCode build() {
            return new FgAlertCode(ID, entitySubTypeCode, entityTypeCode, name, template, typeCode, subTypeCode, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, processID, referenceID, partyID, partyVersionID, versionID, isMasterVersion, stageCode, applicantPartyCode);
        }
    }
}
