package com.bsit.codegeneration.record;

public record FgLayoutTemplate(Long ID, String fileExtension, String fileType, String name, String template, String typeCode, String subTypeCode, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String processID, String referenceID, String category, String content, String uuid, String categoryType, String categorySubType, String tags, Long versionID, Long isMasterVersion, String stageCode, String applicantPartyCode, String deviceType, Long versionNo, String masterContentHash, String templateHash, String masterTemplate) {

    public static class Builder {

        private Long ID;

        private String fileExtension;

        private String fileType;

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

        private String processID;

        private String referenceID;

        private String category;

        private String content;

        private String uuid;

        private String categoryType;

        private String categorySubType;

        private String tags;

        private Long versionID;

        private Long isMasterVersion;

        private String stageCode;

        private String applicantPartyCode;

        private String deviceType;

        private Long versionNo;

        private String masterContentHash;

        private String templateHash;

        private String masterTemplate;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder fileExtension(String fileExtension) {
            this.fileExtension = fileExtension;
            return this;
        }

        public Builder fileType(String fileType) {
            this.fileType = fileType;
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder categoryType(String categoryType) {
            this.categoryType = categoryType;
            return this;
        }

        public Builder categorySubType(String categorySubType) {
            this.categorySubType = categorySubType;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
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

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder deviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public Builder versionNo(Long versionNo) {
            this.versionNo = versionNo;
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

        public Builder masterTemplate(String masterTemplate) {
            this.masterTemplate = masterTemplate;
            return this;
        }

        public FgLayoutTemplate build() {
            return new FgLayoutTemplate(ID, fileExtension, fileType, name, template, typeCode, subTypeCode, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, processID, referenceID, category, content, uuid, categoryType, categorySubType, tags, versionID, isMasterVersion, stageCode, applicantPartyCode, deviceType, versionNo, masterContentHash, templateHash, masterTemplate);
        }
    }
}
