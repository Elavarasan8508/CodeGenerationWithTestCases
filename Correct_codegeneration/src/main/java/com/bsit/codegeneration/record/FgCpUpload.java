package com.bsit.codegeneration.record;

import java.util.List;

public record FgCpUpload(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantPartyCode, String issuingPartyCode, Long isTemplate, Integer uuid, Integer layoutTemplateID, Integer dmsEventID, String totalCount, String successCount, String errorCount, String entityTypeCode, String entitySubTypeCode, Integer layoutTemplateVersionID, String authLevelCode, String fileName, String categorySubType, String taskReason, Integer uploadRefID, String formatName, String displayStatus) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private Long isTemplate;

        private Integer uuid;

        private Integer layoutTemplateID;

        private Integer dmsEventID;

        private String totalCount;

        private String successCount;

        private String errorCount;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private Integer layoutTemplateVersionID;

        private String authLevelCode;

        private String fileName;

        private String categorySubType;

        private String taskReason;

        private Integer uploadRefID;

        private String formatName;

        private String displayStatus;

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

        public Builder processID(Integer processID) {
            this.processID = processID;
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

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder uuid(Integer uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder totalCount(String totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder successCount(String successCount) {
            this.successCount = successCount;
            return this;
        }

        public Builder errorCount(String errorCount) {
            this.errorCount = errorCount;
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

        public Builder layoutTemplateVersionID(Integer layoutTemplateVersionID) {
            this.layoutTemplateVersionID = layoutTemplateVersionID;
            return this;
        }

        public Builder authLevelCode(String authLevelCode) {
            this.authLevelCode = authLevelCode;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder categorySubType(String categorySubType) {
            this.categorySubType = categorySubType;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder formatName(String formatName) {
            this.formatName = formatName;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public FgCpUpload build() {
            return new FgCpUpload(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantPartyCode, issuingPartyCode, isTemplate, uuid, layoutTemplateID, dmsEventID, totalCount, successCount, errorCount, entityTypeCode, entitySubTypeCode, layoutTemplateVersionID, authLevelCode, fileName, categorySubType, taskReason, uploadRefID, formatName, displayStatus);
        }
    }
}
