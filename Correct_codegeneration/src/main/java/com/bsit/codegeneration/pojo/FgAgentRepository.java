package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgAgentRepository {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

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

    public FgAgentRepository() {
    }

    public FgAgentRepository(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String purposeCode, String agentCategory, String agentType, String agentScope, String agentPoolCode, String ownerOrgType, String ownerOrgCode, String scopeOrgType, String scopeOrgCode, String startTime, String lastRunTime, String lastRunStatus, String lastHealthTime, String lastHealthStatus) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.purposeCode = purposeCode;
        this.agentCategory = agentCategory;
        this.agentType = agentType;
        this.agentScope = agentScope;
        this.agentPoolCode = agentPoolCode;
        this.ownerOrgType = ownerOrgType;
        this.ownerOrgCode = ownerOrgCode;
        this.scopeOrgType = scopeOrgType;
        this.scopeOrgCode = scopeOrgCode;
        this.startTime = startTime;
        this.lastRunTime = lastRunTime;
        this.lastRunStatus = lastRunStatus;
        this.lastHealthTime = lastHealthTime;
        this.lastHealthStatus = lastHealthStatus;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getAgentCategory() {
        return agentCategory;
    }

    public void setAgentCategory(String agentCategory) {
        this.agentCategory = agentCategory;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAgentScope() {
        return agentScope;
    }

    public void setAgentScope(String agentScope) {
        this.agentScope = agentScope;
    }

    public String getAgentPoolCode() {
        return agentPoolCode;
    }

    public void setAgentPoolCode(String agentPoolCode) {
        this.agentPoolCode = agentPoolCode;
    }

    public String getOwnerOrgType() {
        return ownerOrgType;
    }

    public void setOwnerOrgType(String ownerOrgType) {
        this.ownerOrgType = ownerOrgType;
    }

    public String getOwnerOrgCode() {
        return ownerOrgCode;
    }

    public void setOwnerOrgCode(String ownerOrgCode) {
        this.ownerOrgCode = ownerOrgCode;
    }

    public String getScopeOrgType() {
        return scopeOrgType;
    }

    public void setScopeOrgType(String scopeOrgType) {
        this.scopeOrgType = scopeOrgType;
    }

    public String getScopeOrgCode() {
        return scopeOrgCode;
    }

    public void setScopeOrgCode(String scopeOrgCode) {
        this.scopeOrgCode = scopeOrgCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(String lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public String getLastRunStatus() {
        return lastRunStatus;
    }

    public void setLastRunStatus(String lastRunStatus) {
        this.lastRunStatus = lastRunStatus;
    }

    public String getLastHealthTime() {
        return lastHealthTime;
    }

    public void setLastHealthTime(String lastHealthTime) {
        this.lastHealthTime = lastHealthTime;
    }

    public String getLastHealthStatus() {
        return lastHealthStatus;
    }

    public void setLastHealthStatus(String lastHealthStatus) {
        this.lastHealthStatus = lastHealthStatus;
    }

    public static class Builder {

        private FgAgentRepository instance = new FgAgentRepository();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder agentCategory(String agentCategory) {
            instance.setAgentCategory(agentCategory);
            return this;
        }

        public Builder agentType(String agentType) {
            instance.setAgentType(agentType);
            return this;
        }

        public Builder agentScope(String agentScope) {
            instance.setAgentScope(agentScope);
            return this;
        }

        public Builder agentPoolCode(String agentPoolCode) {
            instance.setAgentPoolCode(agentPoolCode);
            return this;
        }

        public Builder ownerOrgType(String ownerOrgType) {
            instance.setOwnerOrgType(ownerOrgType);
            return this;
        }

        public Builder ownerOrgCode(String ownerOrgCode) {
            instance.setOwnerOrgCode(ownerOrgCode);
            return this;
        }

        public Builder scopeOrgType(String scopeOrgType) {
            instance.setScopeOrgType(scopeOrgType);
            return this;
        }

        public Builder scopeOrgCode(String scopeOrgCode) {
            instance.setScopeOrgCode(scopeOrgCode);
            return this;
        }

        public Builder startTime(String startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder lastRunTime(String lastRunTime) {
            instance.setLastRunTime(lastRunTime);
            return this;
        }

        public Builder lastRunStatus(String lastRunStatus) {
            instance.setLastRunStatus(lastRunStatus);
            return this;
        }

        public Builder lastHealthTime(String lastHealthTime) {
            instance.setLastHealthTime(lastHealthTime);
            return this;
        }

        public Builder lastHealthStatus(String lastHealthStatus) {
            instance.setLastHealthStatus(lastHealthStatus);
            return this;
        }

        public FgAgentRepository build() {
            return instance;
        }
    }
}
