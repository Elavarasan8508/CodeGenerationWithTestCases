package com.bsit.codegeneration.record;

import java.util.List;

public record FgModCaseEntity(Integer ID, Integer versionID, Integer referenceID, String applicantPartyCode, Integer applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, Integer processID, String templateJson, String activeCode, String statusCode, String stageCode, Long isMasterVersion, Long createdBy, String createdOn, Long lastAuthorisedBy, String lastAuthorisedOn, Long lastUpdatedBy, String lastUpdatedOn, Integer attachmentID) {

    public static class Builder {

        private Integer ID;

        private Integer versionID;

        private Integer referenceID;

        private String applicantPartyCode;

        private Integer applicantRefID;

        private String issuingPartyCode;

        private String typeCode;

        private String subTypeCode;

        private Integer processID;

        private String templateJson;

        private String activeCode;

        private String statusCode;

        private String stageCode;

        private Long isMasterVersion;

        private Long createdBy;

        private String createdOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Integer attachmentID;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder applicantRefID(Integer applicantRefID) {
            this.applicantRefID = applicantRefID;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
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

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder templateJson(String templateJson) {
            this.templateJson = templateJson;
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

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder attachmentID(Integer attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public FgModCaseEntity build() {
            return new FgModCaseEntity(ID, versionID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, processID, templateJson, activeCode, statusCode, stageCode, isMasterVersion, createdBy, createdOn, lastAuthorisedBy, lastAuthorisedOn, lastUpdatedBy, lastUpdatedOn, attachmentID);
        }
    }
}
