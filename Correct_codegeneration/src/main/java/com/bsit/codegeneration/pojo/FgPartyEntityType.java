package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyEntityType {

    private Integer ID;

    private Boolean isEnabled;

    private Integer partyReferenceID;

    private String entityCategoryCode;

    private String entityTypeCode;

    private String userObjectType;

    private Integer userObjectReferenceID;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String entityTypeName;

    private Integer partyID;

    private Integer partyVersionID;

    private Integer userObjectID;

    private Integer userObjectVersionID;

    private String template;

    private String entityAction;

    public FgPartyEntityType() {
    }

    public FgPartyEntityType(Integer ID, Boolean isEnabled, Integer partyReferenceID, String entityCategoryCode, String entityTypeCode, String userObjectType, Integer userObjectReferenceID, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String entityTypeName, Integer partyID, Integer partyVersionID, Integer userObjectID, Integer userObjectVersionID, String template, String entityAction) {
        this.ID = ID;
        this.isEnabled = isEnabled;
        this.partyReferenceID = partyReferenceID;
        this.entityCategoryCode = entityCategoryCode;
        this.entityTypeCode = entityTypeCode;
        this.userObjectType = userObjectType;
        this.userObjectReferenceID = userObjectReferenceID;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.entityTypeName = entityTypeName;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.userObjectID = userObjectID;
        this.userObjectVersionID = userObjectVersionID;
        this.template = template;
        this.entityAction = entityAction;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getPartyReferenceID() {
        return partyReferenceID;
    }

    public void setPartyReferenceID(Integer partyReferenceID) {
        this.partyReferenceID = partyReferenceID;
    }

    public String getEntityCategoryCode() {
        return entityCategoryCode;
    }

    public void setEntityCategoryCode(String entityCategoryCode) {
        this.entityCategoryCode = entityCategoryCode;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getUserObjectType() {
        return userObjectType;
    }

    public void setUserObjectType(String userObjectType) {
        this.userObjectType = userObjectType;
    }

    public Integer getUserObjectReferenceID() {
        return userObjectReferenceID;
    }

    public void setUserObjectReferenceID(Integer userObjectReferenceID) {
        this.userObjectReferenceID = userObjectReferenceID;
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

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    public Integer getPartyID() {
        return partyID;
    }

    public void setPartyID(Integer partyID) {
        this.partyID = partyID;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public Integer getUserObjectID() {
        return userObjectID;
    }

    public void setUserObjectID(Integer userObjectID) {
        this.userObjectID = userObjectID;
    }

    public Integer getUserObjectVersionID() {
        return userObjectVersionID;
    }

    public void setUserObjectVersionID(Integer userObjectVersionID) {
        this.userObjectVersionID = userObjectVersionID;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getEntityAction() {
        return entityAction;
    }

    public void setEntityAction(String entityAction) {
        this.entityAction = entityAction;
    }

    public static class Builder {

        private FgPartyEntityType instance = new FgPartyEntityType();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder isEnabled(Boolean isEnabled) {
            instance.setIsEnabled(isEnabled);
            return this;
        }

        public Builder partyReferenceID(Integer partyReferenceID) {
            instance.setPartyReferenceID(partyReferenceID);
            return this;
        }

        public Builder entityCategoryCode(String entityCategoryCode) {
            instance.setEntityCategoryCode(entityCategoryCode);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder userObjectType(String userObjectType) {
            instance.setUserObjectType(userObjectType);
            return this;
        }

        public Builder userObjectReferenceID(Integer userObjectReferenceID) {
            instance.setUserObjectReferenceID(userObjectReferenceID);
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

        public Builder entityTypeName(String entityTypeName) {
            instance.setEntityTypeName(entityTypeName);
            return this;
        }

        public Builder partyID(Integer partyID) {
            instance.setPartyID(partyID);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder userObjectID(Integer userObjectID) {
            instance.setUserObjectID(userObjectID);
            return this;
        }

        public Builder userObjectVersionID(Integer userObjectVersionID) {
            instance.setUserObjectVersionID(userObjectVersionID);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder entityAction(String entityAction) {
            instance.setEntityAction(entityAction);
            return this;
        }

        public FgPartyEntityType build() {
            return instance;
        }
    }
}
