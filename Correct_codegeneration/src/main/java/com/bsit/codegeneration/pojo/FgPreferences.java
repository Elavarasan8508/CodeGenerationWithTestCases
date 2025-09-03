package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPreferences {

    private Integer ID;

    private Integer versionID;

    private String typeCode;

    private String subTypeCode;

    private String prefCategoryCode;

    private String prefTypeCode;

    private String prefCode;

    private String orgPartyCode;

    private String orgPartySubTypeCode;

    private String userPartyCode;

    private String userPartySubTypeCode;

    private String name;

    private String description;

    private String template;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgPreferences() {
    }

    public FgPreferences(Integer ID, Integer versionID, String typeCode, String subTypeCode, String prefCategoryCode, String prefTypeCode, String prefCode, String orgPartyCode, String orgPartySubTypeCode, String userPartyCode, String userPartySubTypeCode, String name, String description, String template, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.versionID = versionID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.prefCategoryCode = prefCategoryCode;
        this.prefTypeCode = prefTypeCode;
        this.prefCode = prefCode;
        this.orgPartyCode = orgPartyCode;
        this.orgPartySubTypeCode = orgPartySubTypeCode;
        this.userPartyCode = userPartyCode;
        this.userPartySubTypeCode = userPartySubTypeCode;
        this.name = name;
        this.description = description;
        this.template = template;
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

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
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

    public String getOrgPartyCode() {
        return orgPartyCode;
    }

    public void setOrgPartyCode(String orgPartyCode) {
        this.orgPartyCode = orgPartyCode;
    }

    public String getOrgPartySubTypeCode() {
        return orgPartySubTypeCode;
    }

    public void setOrgPartySubTypeCode(String orgPartySubTypeCode) {
        this.orgPartySubTypeCode = orgPartySubTypeCode;
    }

    public String getUserPartyCode() {
        return userPartyCode;
    }

    public void setUserPartyCode(String userPartyCode) {
        this.userPartyCode = userPartyCode;
    }

    public String getUserPartySubTypeCode() {
        return userPartySubTypeCode;
    }

    public void setUserPartySubTypeCode(String userPartySubTypeCode) {
        this.userPartySubTypeCode = userPartySubTypeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
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

        private FgPreferences instance = new FgPreferences();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
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

        public Builder orgPartyCode(String orgPartyCode) {
            instance.setOrgPartyCode(orgPartyCode);
            return this;
        }

        public Builder orgPartySubTypeCode(String orgPartySubTypeCode) {
            instance.setOrgPartySubTypeCode(orgPartySubTypeCode);
            return this;
        }

        public Builder userPartyCode(String userPartyCode) {
            instance.setUserPartyCode(userPartyCode);
            return this;
        }

        public Builder userPartySubTypeCode(String userPartySubTypeCode) {
            instance.setUserPartySubTypeCode(userPartySubTypeCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
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

        public FgPreferences build() {
            return instance;
        }
    }
}
