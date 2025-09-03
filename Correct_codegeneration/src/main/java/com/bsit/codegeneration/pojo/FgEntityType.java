package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgEntityType {

    private Integer ID;

    private String categoryCode;

    private String code;

    private String name;

    private String parentTypeCode;

    private Integer isMaster;

    private Integer isProduct;

    private String entityClassCode;

    private Integer configStatusCode;

    private String description;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String templateSchema;

    private Integer isAnalyticsEnabled;

    private Integer isReportEnabled;

    private String tags;

    private Integer isPublic;

    private String masterTemplate;

    private String masterContentHash;

    private String templateHash;

    private Integer versionID;

    private Integer isMasterVersion;

    public FgEntityType() {
    }

    public FgEntityType(Integer ID, String categoryCode, String code, String name, String parentTypeCode, Integer isMaster, Integer isProduct, String entityClassCode, Integer configStatusCode, String description, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String templateSchema, Integer isAnalyticsEnabled, Integer isReportEnabled, String tags, Integer isPublic, String masterTemplate, String masterContentHash, String templateHash, Integer versionID, Integer isMasterVersion) {
        this.ID = ID;
        this.categoryCode = categoryCode;
        this.code = code;
        this.name = name;
        this.parentTypeCode = parentTypeCode;
        this.isMaster = isMaster;
        this.isProduct = isProduct;
        this.entityClassCode = entityClassCode;
        this.configStatusCode = configStatusCode;
        this.description = description;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.templateSchema = templateSchema;
        this.isAnalyticsEnabled = isAnalyticsEnabled;
        this.isReportEnabled = isReportEnabled;
        this.tags = tags;
        this.isPublic = isPublic;
        this.masterTemplate = masterTemplate;
        this.masterContentHash = masterContentHash;
        this.templateHash = templateHash;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTypeCode() {
        return parentTypeCode;
    }

    public void setParentTypeCode(String parentTypeCode) {
        this.parentTypeCode = parentTypeCode;
    }

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    public Integer getIsProduct() {
        return isProduct;
    }

    public void setIsProduct(Integer isProduct) {
        this.isProduct = isProduct;
    }

    public String getEntityClassCode() {
        return entityClassCode;
    }

    public void setEntityClassCode(String entityClassCode) {
        this.entityClassCode = entityClassCode;
    }

    public Integer getConfigStatusCode() {
        return configStatusCode;
    }

    public void setConfigStatusCode(Integer configStatusCode) {
        this.configStatusCode = configStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
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

    public String getTemplateSchema() {
        return templateSchema;
    }

    public void setTemplateSchema(String templateSchema) {
        this.templateSchema = templateSchema;
    }

    public Integer getIsAnalyticsEnabled() {
        return isAnalyticsEnabled;
    }

    public void setIsAnalyticsEnabled(Integer isAnalyticsEnabled) {
        this.isAnalyticsEnabled = isAnalyticsEnabled;
    }

    public Integer getIsReportEnabled() {
        return isReportEnabled;
    }

    public void setIsReportEnabled(Integer isReportEnabled) {
        this.isReportEnabled = isReportEnabled;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getMasterTemplate() {
        return masterTemplate;
    }

    public void setMasterTemplate(String masterTemplate) {
        this.masterTemplate = masterTemplate;
    }

    public String getMasterContentHash() {
        return masterContentHash;
    }

    public void setMasterContentHash(String masterContentHash) {
        this.masterContentHash = masterContentHash;
    }

    public String getTemplateHash() {
        return templateHash;
    }

    public void setTemplateHash(String templateHash) {
        this.templateHash = templateHash;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public static class Builder {

        private FgEntityType instance = new FgEntityType();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            instance.setCategoryCode(categoryCode);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder parentTypeCode(String parentTypeCode) {
            instance.setParentTypeCode(parentTypeCode);
            return this;
        }

        public Builder isMaster(Integer isMaster) {
            instance.setIsMaster(isMaster);
            return this;
        }

        public Builder isProduct(Integer isProduct) {
            instance.setIsProduct(isProduct);
            return this;
        }

        public Builder entityClassCode(String entityClassCode) {
            instance.setEntityClassCode(entityClassCode);
            return this;
        }

        public Builder configStatusCode(Integer configStatusCode) {
            instance.setConfigStatusCode(configStatusCode);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
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

        public Builder templateSchema(String templateSchema) {
            instance.setTemplateSchema(templateSchema);
            return this;
        }

        public Builder isAnalyticsEnabled(Integer isAnalyticsEnabled) {
            instance.setIsAnalyticsEnabled(isAnalyticsEnabled);
            return this;
        }

        public Builder isReportEnabled(Integer isReportEnabled) {
            instance.setIsReportEnabled(isReportEnabled);
            return this;
        }

        public Builder tags(String tags) {
            instance.setTags(tags);
            return this;
        }

        public Builder isPublic(Integer isPublic) {
            instance.setIsPublic(isPublic);
            return this;
        }

        public Builder masterTemplate(String masterTemplate) {
            instance.setMasterTemplate(masterTemplate);
            return this;
        }

        public Builder masterContentHash(String masterContentHash) {
            instance.setMasterContentHash(masterContentHash);
            return this;
        }

        public Builder templateHash(String templateHash) {
            instance.setTemplateHash(templateHash);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public FgEntityType build() {
            return instance;
        }
    }
}
