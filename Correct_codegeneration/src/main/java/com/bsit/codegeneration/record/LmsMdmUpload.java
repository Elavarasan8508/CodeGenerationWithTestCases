package com.bsit.codegeneration.record;

import java.util.List;

public record LmsMdmUpload(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, Integer layoutTemplateID, Integer dmsEventID, String totalCount, String successCount, String errorCount, Long totalAmount, Long totalSuccessAmount, Long totalFailedAmount, String partyRoleCode, String entityTypeCode, String entitySubTypeCode, String fileStatus, String taskReasonCode, String taskReasonText, Long warningCount, String layoutName, Integer layoutTemplateVersionID, String authLevelCode, String taskReason, String fileName, String displayStatus, Integer uploadRefID, String entityName, String tnxTypeCode, String reverseFileStatus, String segmentTeams) {

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

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private Integer layoutTemplateID;

        private Integer dmsEventID;

        private String totalCount;

        private String successCount;

        private String errorCount;

        private Long totalAmount;

        private Long totalSuccessAmount;

        private Long totalFailedAmount;

        private String partyRoleCode;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String fileStatus;

        private String taskReasonCode;

        private String taskReasonText;

        private Long warningCount;

        private String layoutName;

        private Integer layoutTemplateVersionID;

        private String authLevelCode;

        private String taskReason;

        private String fileName;

        private String displayStatus;

        private Integer uploadRefID;

        private String entityName;

        private String tnxTypeCode;

        private String reverseFileStatus;

        private String segmentTeams;

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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
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

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder totalSuccessAmount(Long totalSuccessAmount) {
            this.totalSuccessAmount = totalSuccessAmount;
            return this;
        }

        public Builder totalFailedAmount(Long totalFailedAmount) {
            this.totalFailedAmount = totalFailedAmount;
            return this;
        }

        public Builder partyRoleCode(String partyRoleCode) {
            this.partyRoleCode = partyRoleCode;
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

        public Builder fileStatus(String fileStatus) {
            this.fileStatus = fileStatus;
            return this;
        }

        public Builder taskReasonCode(String taskReasonCode) {
            this.taskReasonCode = taskReasonCode;
            return this;
        }

        public Builder taskReasonText(String taskReasonText) {
            this.taskReasonText = taskReasonText;
            return this;
        }

        public Builder warningCount(Long warningCount) {
            this.warningCount = warningCount;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
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

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder tnxTypeCode(String tnxTypeCode) {
            this.tnxTypeCode = tnxTypeCode;
            return this;
        }

        public Builder reverseFileStatus(String reverseFileStatus) {
            this.reverseFileStatus = reverseFileStatus;
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            this.segmentTeams = segmentTeams;
            return this;
        }

        public LmsMdmUpload build() {
            return new LmsMdmUpload(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, layoutTemplateID, dmsEventID, totalCount, successCount, errorCount, totalAmount, totalSuccessAmount, totalFailedAmount, partyRoleCode, entityTypeCode, entitySubTypeCode, fileStatus, taskReasonCode, taskReasonText, warningCount, layoutName, layoutTemplateVersionID, authLevelCode, taskReason, fileName, displayStatus, uploadRefID, entityName, tnxTypeCode, reverseFileStatus, segmentTeams);
        }
    }
}
