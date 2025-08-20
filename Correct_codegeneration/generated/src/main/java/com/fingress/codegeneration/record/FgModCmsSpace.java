package com.bsit.codegeneration.record;

public record FgModCmsSpace(Long ID, Long versionID, String spaceCode, String parentSpaceCode, String partyTypeCode, String partySubTypeCode, String entityTypeCode, String entitySubTypeCode, String visibilityCode, String name, String description, String publishDate, String expireDate, String statusCode, String activeCode, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn, Long isMasterVersion) {

    public static class Builder {

        private Long ID;

        private Long versionID;

        private String spaceCode;

        private String parentSpaceCode;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String visibilityCode;

        private String name;

        private String description;

        private String publishDate;

        private String expireDate;

        private String statusCode;

        private String activeCode;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private Long isMasterVersion;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder spaceCode(String spaceCode) {
            this.spaceCode = spaceCode;
            return this;
        }

        public Builder parentSpaceCode(String parentSpaceCode) {
            this.parentSpaceCode = parentSpaceCode;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
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

        public Builder visibilityCode(String visibilityCode) {
            this.visibilityCode = visibilityCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder publishDate(String publishDate) {
            this.publishDate = publishDate;
            return this;
        }

        public Builder expireDate(String expireDate) {
            this.expireDate = expireDate;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
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

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
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

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public FgModCmsSpace build() {
            return new FgModCmsSpace(ID, versionID, spaceCode, parentSpaceCode, partyTypeCode, partySubTypeCode, entityTypeCode, entitySubTypeCode, visibilityCode, name, description, publishDate, expireDate, statusCode, activeCode, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn, isMasterVersion);
        }
    }
}
