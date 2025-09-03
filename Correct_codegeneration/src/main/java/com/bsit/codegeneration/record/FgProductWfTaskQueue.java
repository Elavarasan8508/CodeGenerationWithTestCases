package com.bsit.codegeneration.record;

import java.util.List;

public record FgProductWfTaskQueue(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Integer entityRefID, String entityTypeCode, String entitySubTypeCode, Integer entityVersionID, String entityCode, String entityName, String actionCode, String actionReasonCode, String applicantParty, String perfPartyCode, String perfUserCode, String categoryCode, String configStatusCode, Integer entityID, String entityActionCode, Integer processID, Integer taskID, String taskName, String layoutName, Integer groupID) {

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

        private String template;

        private Long isTemplate;

        private Integer entityRefID;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private Integer entityVersionID;

        private String entityCode;

        private String entityName;

        private String actionCode;

        private String actionReasonCode;

        private String applicantParty;

        private String perfPartyCode;

        private String perfUserCode;

        private String categoryCode;

        private String configStatusCode;

        private Integer entityID;

        private String entityActionCode;

        private Integer processID;

        private Integer taskID;

        private String taskName;

        private String layoutName;

        private Integer groupID;

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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            this.entityRefID = entityRefID;
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

        public Builder entityVersionID(Integer entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder entityCode(String entityCode) {
            this.entityCode = entityCode;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder actionCode(String actionCode) {
            this.actionCode = actionCode;
            return this;
        }

        public Builder actionReasonCode(String actionReasonCode) {
            this.actionReasonCode = actionReasonCode;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder perfPartyCode(String perfPartyCode) {
            this.perfPartyCode = perfPartyCode;
            return this;
        }

        public Builder perfUserCode(String perfUserCode) {
            this.perfUserCode = perfUserCode;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder configStatusCode(String configStatusCode) {
            this.configStatusCode = configStatusCode;
            return this;
        }

        public Builder entityID(Integer entityID) {
            this.entityID = entityID;
            return this;
        }

        public Builder entityActionCode(String entityActionCode) {
            this.entityActionCode = entityActionCode;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder taskID(Integer taskID) {
            this.taskID = taskID;
            return this;
        }

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder groupID(Integer groupID) {
            this.groupID = groupID;
            return this;
        }

        public FgProductWfTaskQueue build() {
            return new FgProductWfTaskQueue(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, entityRefID, entityTypeCode, entitySubTypeCode, entityVersionID, entityCode, entityName, actionCode, actionReasonCode, applicantParty, perfPartyCode, perfUserCode, categoryCode, configStatusCode, entityID, entityActionCode, processID, taskID, taskName, layoutName, groupID);
        }
    }
}
