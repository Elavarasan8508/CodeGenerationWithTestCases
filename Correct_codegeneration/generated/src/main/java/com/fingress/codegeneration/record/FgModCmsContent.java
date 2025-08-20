package com.bsit.codegeneration.record;

public record FgModCmsContent(Long ID, Long versionID, String ownerPartyCode, String ownerTypeCode, String spaceCode, String contentRefNo, String entityTypeCode, String entitySubTypeCode, String name, String title, String subTitle, String description, String contentData, Long isMasterVersion, String publishDate, String expireDate, String stageCode, String statusCode, String activeCode, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private Long versionID;

        private String ownerPartyCode;

        private String ownerTypeCode;

        private String spaceCode;

        private String contentRefNo;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String name;

        private String title;

        private String subTitle;

        private String description;

        private String contentData;

        private Long isMasterVersion;

        private String publishDate;

        private String expireDate;

        private String stageCode;

        private String statusCode;

        private String activeCode;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            this.ownerPartyCode = ownerPartyCode;
            return this;
        }

        public Builder ownerTypeCode(String ownerTypeCode) {
            this.ownerTypeCode = ownerTypeCode;
            return this;
        }

        public Builder spaceCode(String spaceCode) {
            this.spaceCode = spaceCode;
            return this;
        }

        public Builder contentRefNo(String contentRefNo) {
            this.contentRefNo = contentRefNo;
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

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder contentData(String contentData) {
            this.contentData = contentData;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
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

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
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

        public FgModCmsContent build() {
            return new FgModCmsContent(ID, versionID, ownerPartyCode, ownerTypeCode, spaceCode, contentRefNo, entityTypeCode, entitySubTypeCode, name, title, subTitle, description, contentData, isMasterVersion, publishDate, expireDate, stageCode, statusCode, activeCode, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
