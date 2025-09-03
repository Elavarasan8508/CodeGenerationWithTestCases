package com.bsit.codegeneration.record;

import java.util.List;

public record FgModCampaign(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Long isTemplate, Integer processID, String boResponse, String boStatus, Integer statusID, String comments, String description, Integer templateRefID, String purposeCode, String title, java.time.LocalDateTime applicationDate, java.time.LocalDateTime effectiveFrom, java.time.LocalDateTime effectiveTo, String template) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

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

        private Long isTemplate;

        private Integer processID;

        private String boResponse;

        private String boStatus;

        private Integer statusID;

        private String comments;

        private String description;

        private Integer templateRefID;

        private String purposeCode;

        private String title;

        private java.time.LocalDateTime applicationDate;

        private java.time.LocalDateTime effectiveFrom;

        private java.time.LocalDateTime effectiveTo;

        private String template;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder boResponse(String boResponse) {
            this.boResponse = boResponse;
            return this;
        }

        public Builder boStatus(String boStatus) {
            this.boStatus = boStatus;
            return this;
        }

        public Builder statusID(Integer statusID) {
            this.statusID = statusID;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder templateRefID(Integer templateRefID) {
            this.templateRefID = templateRefID;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder applicationDate(java.time.LocalDateTime applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder effectiveFrom(java.time.LocalDateTime effectiveFrom) {
            this.effectiveFrom = effectiveFrom;
            return this;
        }

        public Builder effectiveTo(java.time.LocalDateTime effectiveTo) {
            this.effectiveTo = effectiveTo;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public FgModCampaign build() {
            return new FgModCampaign(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, isTemplate, processID, boResponse, boStatus, statusID, comments, description, templateRefID, purposeCode, title, applicationDate, effectiveFrom, effectiveTo, template);
        }
    }
}
