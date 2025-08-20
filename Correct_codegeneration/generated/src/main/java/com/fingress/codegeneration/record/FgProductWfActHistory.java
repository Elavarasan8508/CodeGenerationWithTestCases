package com.bsit.codegeneration.record;

public record FgProductWfActHistory(String wfProcessID, String wfDefinitionID, String wfActivityID, String wfActivityTypeCode, String perfPartyCode, String perfPartyUserCode, String wfActivityStartDate, String wfActivityEndDate, String wfActivityResultCode, String wfActivityActionCode, String activeCode, String statusCode, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn, String stageCode, String message, String wfTaskName, String entityRefID, Long entityVersionID, String entityTypeCode, String entitySubTypeCode, String ID, String taskConsent, Long isTaskConsent) {

    public static class Builder {

        private String wfProcessID;

        private String wfDefinitionID;

        private String wfActivityID;

        private String wfActivityTypeCode;

        private String perfPartyCode;

        private String perfPartyUserCode;

        private String wfActivityStartDate;

        private String wfActivityEndDate;

        private String wfActivityResultCode;

        private String wfActivityActionCode;

        private String activeCode;

        private String statusCode;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private String stageCode;

        private String message;

        private String wfTaskName;

        private String entityRefID;

        private Long entityVersionID;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String ID;

        private String taskConsent;

        private Long isTaskConsent;

        public Builder wfProcessID(String wfProcessID) {
            this.wfProcessID = wfProcessID;
            return this;
        }

        public Builder wfDefinitionID(String wfDefinitionID) {
            this.wfDefinitionID = wfDefinitionID;
            return this;
        }

        public Builder wfActivityID(String wfActivityID) {
            this.wfActivityID = wfActivityID;
            return this;
        }

        public Builder wfActivityTypeCode(String wfActivityTypeCode) {
            this.wfActivityTypeCode = wfActivityTypeCode;
            return this;
        }

        public Builder perfPartyCode(String perfPartyCode) {
            this.perfPartyCode = perfPartyCode;
            return this;
        }

        public Builder perfPartyUserCode(String perfPartyUserCode) {
            this.perfPartyUserCode = perfPartyUserCode;
            return this;
        }

        public Builder wfActivityStartDate(String wfActivityStartDate) {
            this.wfActivityStartDate = wfActivityStartDate;
            return this;
        }

        public Builder wfActivityEndDate(String wfActivityEndDate) {
            this.wfActivityEndDate = wfActivityEndDate;
            return this;
        }

        public Builder wfActivityResultCode(String wfActivityResultCode) {
            this.wfActivityResultCode = wfActivityResultCode;
            return this;
        }

        public Builder wfActivityActionCode(String wfActivityActionCode) {
            this.wfActivityActionCode = wfActivityActionCode;
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

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder wfTaskName(String wfTaskName) {
            this.wfTaskName = wfTaskName;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionID(Long entityVersionID) {
            this.entityVersionID = entityVersionID;
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

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder taskConsent(String taskConsent) {
            this.taskConsent = taskConsent;
            return this;
        }

        public Builder isTaskConsent(Long isTaskConsent) {
            this.isTaskConsent = isTaskConsent;
            return this;
        }

        public FgProductWfActHistory build() {
            return new FgProductWfActHistory(wfProcessID, wfDefinitionID, wfActivityID, wfActivityTypeCode, perfPartyCode, perfPartyUserCode, wfActivityStartDate, wfActivityEndDate, wfActivityResultCode, wfActivityActionCode, activeCode, statusCode, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn, stageCode, message, wfTaskName, entityRefID, entityVersionID, entityTypeCode, entitySubTypeCode, ID, taskConsent, isTaskConsent);
        }
    }
}
