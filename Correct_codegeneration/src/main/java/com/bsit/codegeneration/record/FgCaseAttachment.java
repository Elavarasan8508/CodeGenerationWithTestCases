package com.bsit.codegeneration.record;

import java.util.List;

public record FgCaseAttachment(Integer ID, Integer referenceID, String applicantPartyCode, Integer applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Integer versionID, Long isMasterVersion, Integer processID, Integer uploadRefID, String fgFileTitle, String fgDocPurpose, String fgFilename, String fgFiletype, String fgFilesize, java.time.LocalDateTime fgFileCreatedOn) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String applicantPartyCode;

        private Integer applicantRefID;

        private String issuingPartyCode;

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

        private Integer uploadRefID;

        private String fgFileTitle;

        private String fgDocPurpose;

        private String fgFilename;

        private String fgFiletype;

        private String fgFilesize;

        private java.time.LocalDateTime fgFileCreatedOn;

        public Builder ID(Integer ID) {
            this.ID = ID;
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

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder fgFileTitle(String fgFileTitle) {
            this.fgFileTitle = fgFileTitle;
            return this;
        }

        public Builder fgDocPurpose(String fgDocPurpose) {
            this.fgDocPurpose = fgDocPurpose;
            return this;
        }

        public Builder fgFilename(String fgFilename) {
            this.fgFilename = fgFilename;
            return this;
        }

        public Builder fgFiletype(String fgFiletype) {
            this.fgFiletype = fgFiletype;
            return this;
        }

        public Builder fgFilesize(String fgFilesize) {
            this.fgFilesize = fgFilesize;
            return this;
        }

        public Builder fgFileCreatedOn(java.time.LocalDateTime fgFileCreatedOn) {
            this.fgFileCreatedOn = fgFileCreatedOn;
            return this;
        }

        public FgCaseAttachment build() {
            return new FgCaseAttachment(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, versionID, isMasterVersion, processID, uploadRefID, fgFileTitle, fgDocPurpose, fgFilename, fgFiletype, fgFilesize, fgFileCreatedOn);
        }
    }
}
