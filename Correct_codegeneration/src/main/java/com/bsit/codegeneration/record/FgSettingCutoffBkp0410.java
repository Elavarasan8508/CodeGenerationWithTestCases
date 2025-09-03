package com.bsit.codegeneration.record;

import java.util.List;

public record FgSettingCutoffBkp0410(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String scopeType, String productCode, String scopeLevel, String scopeValue, String subProductCode, Integer versionID, Long isMasterVersion, String rateType, String entityCode, Integer uploadRefID, String fgGroupScope, String fgRoleScope, String corporateCrn, String entityName) {

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

        private String scopeType;

        private String productCode;

        private String scopeLevel;

        private String scopeValue;

        private String subProductCode;

        private Integer versionID;

        private Long isMasterVersion;

        private String rateType;

        private String entityCode;

        private Integer uploadRefID;

        private String fgGroupScope;

        private String fgRoleScope;

        private String corporateCrn;

        private String entityName;

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

        public Builder scopeType(String scopeType) {
            this.scopeType = scopeType;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder scopeLevel(String scopeLevel) {
            this.scopeLevel = scopeLevel;
            return this;
        }

        public Builder scopeValue(String scopeValue) {
            this.scopeValue = scopeValue;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder rateType(String rateType) {
            this.rateType = rateType;
            return this;
        }

        public Builder entityCode(String entityCode) {
            this.entityCode = entityCode;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder fgGroupScope(String fgGroupScope) {
            this.fgGroupScope = fgGroupScope;
            return this;
        }

        public Builder fgRoleScope(String fgRoleScope) {
            this.fgRoleScope = fgRoleScope;
            return this;
        }

        public Builder corporateCrn(String corporateCrn) {
            this.corporateCrn = corporateCrn;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public FgSettingCutoffBkp0410 build() {
            return new FgSettingCutoffBkp0410(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, scopeType, productCode, scopeLevel, scopeValue, subProductCode, versionID, isMasterVersion, rateType, entityCode, uploadRefID, fgGroupScope, fgRoleScope, corporateCrn, entityName);
        }
    }
}
