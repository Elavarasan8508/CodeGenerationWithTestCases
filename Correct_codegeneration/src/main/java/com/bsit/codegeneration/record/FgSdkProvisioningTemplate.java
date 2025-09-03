package com.bsit.codegeneration.record;

import java.util.List;

public record FgSdkProvisioningTemplate(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer uploadRefID, Integer attachmentID, Integer parentID, Integer parentRefID, Integer parentVersionID, Long isTemplate, String templateName, String templateCode, String templateDescription, String templateType, String ruleTemplate, String modelSubtypeCode, String actionType) {

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

        private Integer uploadRefID;

        private Integer attachmentID;

        private Integer parentID;

        private Integer parentRefID;

        private Integer parentVersionID;

        private Long isTemplate;

        private String templateName;

        private String templateCode;

        private String templateDescription;

        private String templateType;

        private String ruleTemplate;

        private String modelSubtypeCode;

        private String actionType;

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

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder attachmentID(Integer attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public Builder parentID(Integer parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder templateDescription(String templateDescription) {
            this.templateDescription = templateDescription;
            return this;
        }

        public Builder templateType(String templateType) {
            this.templateType = templateType;
            return this;
        }

        public Builder ruleTemplate(String ruleTemplate) {
            this.ruleTemplate = ruleTemplate;
            return this;
        }

        public Builder modelSubtypeCode(String modelSubtypeCode) {
            this.modelSubtypeCode = modelSubtypeCode;
            return this;
        }

        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        public FgSdkProvisioningTemplate build() {
            return new FgSdkProvisioningTemplate(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, uploadRefID, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, templateName, templateCode, templateDescription, templateType, ruleTemplate, modelSubtypeCode, actionType);
        }
    }
}
