package com.bsit.codegeneration.record;

public record FgModCaseEntity(Long ID, Long versionID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String processID, String templateJson, String activeCode, String statusCode, String stageCode, Long isMasterVersion, Long createdBy, String createdOn, Long lastAuthorisedBy, String lastAuthorisedOn, Long lastUpdatedBy, String lastUpdatedOn, Long attachmentID) {

    public static class Builder {

        private Long ID;

        private Long versionID;

        private String referenceID;

        private String applicantPartyCode;

        private String applicantRefID;

        private String issuingPartyCode;

        private String typeCode;

        private String subTypeCode;

        private String processID;

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

        private Long attachmentID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder applicantRefID(String applicantRefID) {
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

        public Builder processID(String processID) {
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

        public Builder attachmentID(Long attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public FgModCaseEntity build() {
            return new FgModCaseEntity(ID, versionID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, processID, templateJson, activeCode, statusCode, stageCode, isMasterVersion, createdBy, createdOn, lastAuthorisedBy, lastAuthorisedOn, lastUpdatedBy, lastUpdatedOn, attachmentID);
        }
    }
}
