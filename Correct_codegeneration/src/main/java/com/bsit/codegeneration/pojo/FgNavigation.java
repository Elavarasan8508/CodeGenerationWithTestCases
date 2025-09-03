package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgNavigation {

    private Integer ID;

    private String appliedDate;

    private String typeCode;

    private String subTypeCode;

    private String navigationContent;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    public FgNavigation() {
    }

    public FgNavigation(Integer ID, String appliedDate, String typeCode, String subTypeCode, String navigationContent, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn) {
        this.ID = ID;
        this.appliedDate = appliedDate;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.navigationContent = navigationContent;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
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

    public String getNavigationContent() {
        return navigationContent;
    }

    public void setNavigationContent(String navigationContent) {
        this.navigationContent = navigationContent;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public static class Builder {

        private FgNavigation instance = new FgNavigation();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder appliedDate(String appliedDate) {
            instance.setAppliedDate(appliedDate);
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

        public Builder navigationContent(String navigationContent) {
            instance.setNavigationContent(navigationContent);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
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

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public FgNavigation build() {
            return instance;
        }
    }
}
