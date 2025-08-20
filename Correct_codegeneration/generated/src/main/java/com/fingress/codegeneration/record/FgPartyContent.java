package com.bsit.codegeneration.record;

public record FgPartyContent(Long ID, Long partyID, Long partyVersionID, String partySubType, String partyCode, String contentTypeCode, String contentSubTypeCode, String contentDocNo, String contentFileName, String contentStorageCode, String contentAttachmentID, String contentDmsID, String contentDmsURL, String contentTags, String comments, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private Long partyID;

        private Long partyVersionID;

        private String partySubType;

        private String partyCode;

        private String contentTypeCode;

        private String contentSubTypeCode;

        private String contentDocNo;

        private String contentFileName;

        private String contentStorageCode;

        private String contentAttachmentID;

        private String contentDmsID;

        private String contentDmsURL;

        private String contentTags;

        private String comments;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Long ID) {
            this.ID = ID;
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

        public Builder partySubType(String partySubType) {
            this.partySubType = partySubType;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder contentTypeCode(String contentTypeCode) {
            this.contentTypeCode = contentTypeCode;
            return this;
        }

        public Builder contentSubTypeCode(String contentSubTypeCode) {
            this.contentSubTypeCode = contentSubTypeCode;
            return this;
        }

        public Builder contentDocNo(String contentDocNo) {
            this.contentDocNo = contentDocNo;
            return this;
        }

        public Builder contentFileName(String contentFileName) {
            this.contentFileName = contentFileName;
            return this;
        }

        public Builder contentStorageCode(String contentStorageCode) {
            this.contentStorageCode = contentStorageCode;
            return this;
        }

        public Builder contentAttachmentID(String contentAttachmentID) {
            this.contentAttachmentID = contentAttachmentID;
            return this;
        }

        public Builder contentDmsID(String contentDmsID) {
            this.contentDmsID = contentDmsID;
            return this;
        }

        public Builder contentDmsURL(String contentDmsURL) {
            this.contentDmsURL = contentDmsURL;
            return this;
        }

        public Builder contentTags(String contentTags) {
            this.contentTags = contentTags;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
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

        public FgPartyContent build() {
            return new FgPartyContent(ID, partyID, partyVersionID, partySubType, partyCode, contentTypeCode, contentSubTypeCode, contentDocNo, contentFileName, contentStorageCode, contentAttachmentID, contentDmsID, contentDmsURL, contentTags, comments, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
