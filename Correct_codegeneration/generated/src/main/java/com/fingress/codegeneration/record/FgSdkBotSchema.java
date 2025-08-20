package com.bsit.codegeneration.record;

public record FgSdkBotSchema(String ID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String botName, String version, String status, String description, String language, java.time.LocalDateTime publishDate, String sessionTimeOut, String idleTimeOut) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String applicantPartyCode;

        private String applicantRefID;

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

        private String botName;

        private String version;

        private String status;

        private String description;

        private String language;

        private java.time.LocalDateTime publishDate;

        private String sessionTimeOut;

        private String idleTimeOut;

        public Builder ID(String ID) {
            this.ID = ID;
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

        public Builder botName(String botName) {
            this.botName = botName;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder publishDate(java.time.LocalDateTime publishDate) {
            this.publishDate = publishDate;
            return this;
        }

        public Builder sessionTimeOut(String sessionTimeOut) {
            this.sessionTimeOut = sessionTimeOut;
            return this;
        }

        public Builder idleTimeOut(String idleTimeOut) {
            this.idleTimeOut = idleTimeOut;
            return this;
        }

        public FgSdkBotSchema build() {
            return new FgSdkBotSchema(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, botName, version, status, description, language, publishDate, sessionTimeOut, idleTimeOut);
        }
    }
}
