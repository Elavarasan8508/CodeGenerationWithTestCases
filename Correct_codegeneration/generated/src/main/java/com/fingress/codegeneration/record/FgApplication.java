package com.bsit.codegeneration.record;

public record FgApplication(Long ID, String code, String name, String subTitle, String icon, String description, String navigationSchema, Long isSecured, String activeCode, String applicationType, String uuid, String tags, String appTitle, String deviceChannel, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String masterTemplate, String masterContentHash, Long isMasterVersion, String versionID) {

    public static class Builder {

        private Long ID;

        private String code;

        private String name;

        private String subTitle;

        private String icon;

        private String description;

        private String navigationSchema;

        private Long isSecured;

        private String activeCode;

        private String applicationType;

        private String uuid;

        private String tags;

        private String appTitle;

        private String deviceChannel;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String masterTemplate;

        private String masterContentHash;

        private Long isMasterVersion;

        private String versionID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder navigationSchema(String navigationSchema) {
            this.navigationSchema = navigationSchema;
            return this;
        }

        public Builder isSecured(Long isSecured) {
            this.isSecured = isSecured;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder applicationType(String applicationType) {
            this.applicationType = applicationType;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder appTitle(String appTitle) {
            this.appTitle = appTitle;
            return this;
        }

        public Builder deviceChannel(String deviceChannel) {
            this.deviceChannel = deviceChannel;
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

        public Builder masterTemplate(String masterTemplate) {
            this.masterTemplate = masterTemplate;
            return this;
        }

        public Builder masterContentHash(String masterContentHash) {
            this.masterContentHash = masterContentHash;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder versionID(String versionID) {
            this.versionID = versionID;
            return this;
        }

        public FgApplication build() {
            return new FgApplication(ID, code, name, subTitle, icon, description, navigationSchema, isSecured, activeCode, applicationType, uuid, tags, appTitle, deviceChannel, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, masterTemplate, masterContentHash, isMasterVersion, versionID);
        }
    }
}
