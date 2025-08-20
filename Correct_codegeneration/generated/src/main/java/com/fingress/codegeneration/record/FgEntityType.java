package com.bsit.codegeneration.record;

public record FgEntityType(Long ID, String categoryCode, String code, String name, String parentTypeCode, Long isMaster, Long isProduct, String entityClassCode, Long configStatusCode, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String templateSchema, Long isAnalyticsEnabled, Long isReportEnabled, String tags, Long isPublic, String masterTemplate, String masterContentHash, String templateHash, Long versionID, Long isMasterVersion) {

    public static class Builder {

        private Long ID;

        private String categoryCode;

        private String code;

        private String name;

        private String parentTypeCode;

        private Long isMaster;

        private Long isProduct;

        private String entityClassCode;

        private Long configStatusCode;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String templateSchema;

        private Long isAnalyticsEnabled;

        private Long isReportEnabled;

        private String tags;

        private Long isPublic;

        private String masterTemplate;

        private String masterContentHash;

        private String templateHash;

        private Long versionID;

        private Long isMasterVersion;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
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

        public Builder parentTypeCode(String parentTypeCode) {
            this.parentTypeCode = parentTypeCode;
            return this;
        }

        public Builder isMaster(Long isMaster) {
            this.isMaster = isMaster;
            return this;
        }

        public Builder isProduct(Long isProduct) {
            this.isProduct = isProduct;
            return this;
        }

        public Builder entityClassCode(String entityClassCode) {
            this.entityClassCode = entityClassCode;
            return this;
        }

        public Builder configStatusCode(Long configStatusCode) {
            this.configStatusCode = configStatusCode;
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

        public Builder templateSchema(String templateSchema) {
            this.templateSchema = templateSchema;
            return this;
        }

        public Builder isAnalyticsEnabled(Long isAnalyticsEnabled) {
            this.isAnalyticsEnabled = isAnalyticsEnabled;
            return this;
        }

        public Builder isReportEnabled(Long isReportEnabled) {
            this.isReportEnabled = isReportEnabled;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder isPublic(Long isPublic) {
            this.isPublic = isPublic;
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

        public Builder templateHash(String templateHash) {
            this.templateHash = templateHash;
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

        public FgEntityType build() {
            return new FgEntityType(ID, categoryCode, code, name, parentTypeCode, isMaster, isProduct, entityClassCode, configStatusCode, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, templateSchema, isAnalyticsEnabled, isReportEnabled, tags, isPublic, masterTemplate, masterContentHash, templateHash, versionID, isMasterVersion);
        }
    }
}
