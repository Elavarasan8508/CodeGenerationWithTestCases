package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPreferencesRelation {

    private Integer ID;

    private String prefCategoryCode;

    private String prefTypeCode;

    private String prefCode;

    private String scopeCode;

    private String scopeValue;

    private String description;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgPreferencesRelation() {
    }

    public FgPreferencesRelation(Integer ID, String prefCategoryCode, String prefTypeCode, String prefCode, String scopeCode, String scopeValue, String description, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.prefCategoryCode = prefCategoryCode;
        this.prefTypeCode = prefTypeCode;
        this.prefCode = prefCode;
        this.scopeCode = scopeCode;
        this.scopeValue = scopeValue;
        this.description = description;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPrefCategoryCode() {
        return prefCategoryCode;
    }

    public void setPrefCategoryCode(String prefCategoryCode) {
        this.prefCategoryCode = prefCategoryCode;
    }

    public String getPrefTypeCode() {
        return prefTypeCode;
    }

    public void setPrefTypeCode(String prefTypeCode) {
        this.prefTypeCode = prefTypeCode;
    }

    public String getPrefCode() {
        return prefCode;
    }

    public void setPrefCode(String prefCode) {
        this.prefCode = prefCode;
    }

    public String getScopeCode() {
        return scopeCode;
    }

    public void setScopeCode(String scopeCode) {
        this.scopeCode = scopeCode;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
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

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public static class Builder {

        private FgPreferencesRelation instance = new FgPreferencesRelation();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder prefCategoryCode(String prefCategoryCode) {
            instance.setPrefCategoryCode(prefCategoryCode);
            return this;
        }

        public Builder prefTypeCode(String prefTypeCode) {
            instance.setPrefTypeCode(prefTypeCode);
            return this;
        }

        public Builder prefCode(String prefCode) {
            instance.setPrefCode(prefCode);
            return this;
        }

        public Builder scopeCode(String scopeCode) {
            instance.setScopeCode(scopeCode);
            return this;
        }

        public Builder scopeValue(String scopeValue) {
            instance.setScopeValue(scopeValue);
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

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public FgPreferencesRelation build() {
            return instance;
        }
    }
}
