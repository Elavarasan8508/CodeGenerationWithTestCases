package com.bsit.codegeneration.record;

public record FgProvisioningRule(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, String uploadRefID, String attachmentID, String parentID, String parentRefID, Long parentVersionID, Long isTemplate, String targetOrgType, String targetOrgPartyCode, String ruleType, String targetOrgEntityCode, String modelSubtypeCode, String ruleInheritanceFlag, String inheritanceTargetSubtype, String modRuleTemplate, String provisioningStatus, String provisioningDate, String provisioningError, String provisioiningRemarks, String actionCode, String deploymentID, String version) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantParty;

        private String fulfillmentParty;

        private String uploadRefID;

        private String attachmentID;

        private String parentID;

        private String parentRefID;

        private Long parentVersionID;

        private Long isTemplate;

        private String targetOrgType;

        private String targetOrgPartyCode;

        private String ruleType;

        private String targetOrgEntityCode;

        private String modelSubtypeCode;

        private String ruleInheritanceFlag;

        private String inheritanceTargetSubtype;

        private String modRuleTemplate;

        private String provisioningStatus;

        private String provisioningDate;

        private String provisioningError;

        private String provisioiningRemarks;

        private String actionCode;

        private String deploymentID;

        private String version;

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

        public Builder processID(String processID) {
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

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder attachmentID(String attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public Builder parentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder targetOrgType(String targetOrgType) {
            this.targetOrgType = targetOrgType;
            return this;
        }

        public Builder targetOrgPartyCode(String targetOrgPartyCode) {
            this.targetOrgPartyCode = targetOrgPartyCode;
            return this;
        }

        public Builder ruleType(String ruleType) {
            this.ruleType = ruleType;
            return this;
        }

        public Builder targetOrgEntityCode(String targetOrgEntityCode) {
            this.targetOrgEntityCode = targetOrgEntityCode;
            return this;
        }

        public Builder modelSubtypeCode(String modelSubtypeCode) {
            this.modelSubtypeCode = modelSubtypeCode;
            return this;
        }

        public Builder ruleInheritanceFlag(String ruleInheritanceFlag) {
            this.ruleInheritanceFlag = ruleInheritanceFlag;
            return this;
        }

        public Builder inheritanceTargetSubtype(String inheritanceTargetSubtype) {
            this.inheritanceTargetSubtype = inheritanceTargetSubtype;
            return this;
        }

        public Builder modRuleTemplate(String modRuleTemplate) {
            this.modRuleTemplate = modRuleTemplate;
            return this;
        }

        public Builder provisioningStatus(String provisioningStatus) {
            this.provisioningStatus = provisioningStatus;
            return this;
        }

        public Builder provisioningDate(String provisioningDate) {
            this.provisioningDate = provisioningDate;
            return this;
        }

        public Builder provisioningError(String provisioningError) {
            this.provisioningError = provisioningError;
            return this;
        }

        public Builder provisioiningRemarks(String provisioiningRemarks) {
            this.provisioiningRemarks = provisioiningRemarks;
            return this;
        }

        public Builder actionCode(String actionCode) {
            this.actionCode = actionCode;
            return this;
        }

        public Builder deploymentID(String deploymentID) {
            this.deploymentID = deploymentID;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public FgProvisioningRule build() {
            return new FgProvisioningRule(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, uploadRefID, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, targetOrgType, targetOrgPartyCode, ruleType, targetOrgEntityCode, modelSubtypeCode, ruleInheritanceFlag, inheritanceTargetSubtype, modRuleTemplate, provisioningStatus, provisioningDate, provisioningError, provisioiningRemarks, actionCode, deploymentID, version);
        }
    }
}
