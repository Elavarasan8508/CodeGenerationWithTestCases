package com.bsit.codegeneration.record;

public record FgScheduleCode(Long ID, java.time.LocalDateTime endDate, String name, String processingType, java.time.LocalDateTime startDate, String template, String typeCode, Long partyID, Long partyVersionID, String description, String applicantPartyCode, String configRefID, String categoryCode, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String subTypeCode, String entityTypeCode, String entitySubTypeCode, String processID, String referenceID, Long versionID, Long isMasterVersion, String stageCode) {

    public static class Builder {

        private Long ID;

        private java.time.LocalDateTime endDate;

        private String name;

        private String processingType;

        private java.time.LocalDateTime startDate;

        private String template;

        private String typeCode;

        private Long partyID;

        private Long partyVersionID;

        private String description;

        private String applicantPartyCode;

        private String configRefID;

        private String categoryCode;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String subTypeCode;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String processID;

        private String referenceID;

        private Long versionID;

        private Long isMasterVersion;

        private String stageCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder processingType(String processingType) {
            this.processingType = processingType;
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            this.startDate = startDate;
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

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder configRefID(String configRefID) {
            this.configRefID = configRefID;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
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

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
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

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public FgScheduleCode build() {
            return new FgScheduleCode(ID, endDate, name, processingType, startDate, template, typeCode, partyID, partyVersionID, description, applicantPartyCode, configRefID, categoryCode, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, subTypeCode, entityTypeCode, entitySubTypeCode, processID, referenceID, versionID, isMasterVersion, stageCode);
        }
    }
}
