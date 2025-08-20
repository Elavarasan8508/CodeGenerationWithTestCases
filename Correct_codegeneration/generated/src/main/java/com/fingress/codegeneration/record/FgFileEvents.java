package com.bsit.codegeneration.record;

public record FgFileEvents(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String anchorCrn, String eventType, String eventCode, String eventName, String eventSource, String eventTarget, String entityName, Long recordCount, String fileAttachRefNo, String eventStatus, String eventRemarks, String fileName, String fileMasterRefNo, String eventBatchID, String displaySource, String displayTarget, String layoutName, Long layoutTemplateID, Long layoutTemplateVersionID, String uploadRefID, String entitySubTypeCode, String entityTypeCode) {

    public static class Builder {

        private String ID;

        private String referenceID;

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

        private String template;

        private Long isTemplate;

        private String anchorCrn;

        private String eventType;

        private String eventCode;

        private String eventName;

        private String eventSource;

        private String eventTarget;

        private String entityName;

        private Long recordCount;

        private String fileAttachRefNo;

        private String eventStatus;

        private String eventRemarks;

        private String fileName;

        private String fileMasterRefNo;

        private String eventBatchID;

        private String displaySource;

        private String displayTarget;

        private String layoutName;

        private Long layoutTemplateID;

        private Long layoutTemplateVersionID;

        private String uploadRefID;

        private String entitySubTypeCode;

        private String entityTypeCode;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder eventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder eventSource(String eventSource) {
            this.eventSource = eventSource;
            return this;
        }

        public Builder eventTarget(String eventTarget) {
            this.eventTarget = eventTarget;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder recordCount(Long recordCount) {
            this.recordCount = recordCount;
            return this;
        }

        public Builder fileAttachRefNo(String fileAttachRefNo) {
            this.fileAttachRefNo = fileAttachRefNo;
            return this;
        }

        public Builder eventStatus(String eventStatus) {
            this.eventStatus = eventStatus;
            return this;
        }

        public Builder eventRemarks(String eventRemarks) {
            this.eventRemarks = eventRemarks;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            this.fileMasterRefNo = fileMasterRefNo;
            return this;
        }

        public Builder eventBatchID(String eventBatchID) {
            this.eventBatchID = eventBatchID;
            return this;
        }

        public Builder displaySource(String displaySource) {
            this.displaySource = displaySource;
            return this;
        }

        public Builder displayTarget(String displayTarget) {
            this.displayTarget = displayTarget;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder layoutTemplateVersionID(Long layoutTemplateVersionID) {
            this.layoutTemplateVersionID = layoutTemplateVersionID;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public FgFileEvents build() {
            return new FgFileEvents(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, anchorCrn, eventType, eventCode, eventName, eventSource, eventTarget, entityName, recordCount, fileAttachRefNo, eventStatus, eventRemarks, fileName, fileMasterRefNo, eventBatchID, displaySource, displayTarget, layoutName, layoutTemplateID, layoutTemplateVersionID, uploadRefID, entitySubTypeCode, entityTypeCode);
        }
    }
}
