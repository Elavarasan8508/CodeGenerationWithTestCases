package com.bsit.codegeneration.record;

public record FgAgentRepository(Long ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String purposeCode, String agentCategory, String agentType, String agentScope, String agentPoolCode, String ownerOrgType, String ownerOrgCode, String scopeOrgType, String scopeOrgCode, String startTime, String lastRunTime, String lastRunStatus, String lastHealthTime, String lastHealthStatus) {

    public static class Builder {

        private Long ID;

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

        private String purposeCode;

        private String agentCategory;

        private String agentType;

        private String agentScope;

        private String agentPoolCode;

        private String ownerOrgType;

        private String ownerOrgCode;

        private String scopeOrgType;

        private String scopeOrgCode;

        private String startTime;

        private String lastRunTime;

        private String lastRunStatus;

        private String lastHealthTime;

        private String lastHealthStatus;

        public Builder ID(Long ID) {
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

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder agentCategory(String agentCategory) {
            this.agentCategory = agentCategory;
            return this;
        }

        public Builder agentType(String agentType) {
            this.agentType = agentType;
            return this;
        }

        public Builder agentScope(String agentScope) {
            this.agentScope = agentScope;
            return this;
        }

        public Builder agentPoolCode(String agentPoolCode) {
            this.agentPoolCode = agentPoolCode;
            return this;
        }

        public Builder ownerOrgType(String ownerOrgType) {
            this.ownerOrgType = ownerOrgType;
            return this;
        }

        public Builder ownerOrgCode(String ownerOrgCode) {
            this.ownerOrgCode = ownerOrgCode;
            return this;
        }

        public Builder scopeOrgType(String scopeOrgType) {
            this.scopeOrgType = scopeOrgType;
            return this;
        }

        public Builder scopeOrgCode(String scopeOrgCode) {
            this.scopeOrgCode = scopeOrgCode;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder lastRunTime(String lastRunTime) {
            this.lastRunTime = lastRunTime;
            return this;
        }

        public Builder lastRunStatus(String lastRunStatus) {
            this.lastRunStatus = lastRunStatus;
            return this;
        }

        public Builder lastHealthTime(String lastHealthTime) {
            this.lastHealthTime = lastHealthTime;
            return this;
        }

        public Builder lastHealthStatus(String lastHealthStatus) {
            this.lastHealthStatus = lastHealthStatus;
            return this;
        }

        public FgAgentRepository build() {
            return new FgAgentRepository(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, purposeCode, agentCategory, agentType, agentScope, agentPoolCode, ownerOrgType, ownerOrgCode, scopeOrgType, scopeOrgCode, startTime, lastRunTime, lastRunStatus, lastHealthTime, lastHealthStatus);
        }
    }
}
