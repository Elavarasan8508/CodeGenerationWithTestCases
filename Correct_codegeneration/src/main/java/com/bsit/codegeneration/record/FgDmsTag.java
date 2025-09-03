package com.bsit.codegeneration.record;

import java.util.List;

public record FgDmsTag(Integer ID, String tagName, Integer dmsContentID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgDmsContent fgDmsContent) {

    public static class Builder {

        private Integer ID;

        private String tagName;

        private Integer dmsContentID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgDmsContent fgDmsContent;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder tagName(String tagName) {
            this.tagName = tagName;
            return this;
        }

        public Builder dmsContentID(Integer dmsContentID) {
            this.dmsContentID = dmsContentID;
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

        public Builder fgDmsContent(FgDmsContent fgDmsContent) {
            this.fgDmsContent = fgDmsContent;
            return this;
        }

        public FgDmsTag build() {
            return new FgDmsTag(ID, tagName, dmsContentID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgDmsContent);
        }
    }
}
