package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgVault {

    private Integer ID;

    private Integer entityRefID;

    private String entitySubTypeCode;

    private String vaultType;

    private String vaultData;

    private String activeCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private Integer entityID;

    private Integer entityVersionID;

    public FgVault() {
    }

    public FgVault(Integer ID, Integer entityRefID, String entitySubTypeCode, String vaultType, String vaultData, String activeCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, Integer entityID, Integer entityVersionID) {
        this.ID = ID;
        this.entityRefID = entityRefID;
        this.entitySubTypeCode = entitySubTypeCode;
        this.vaultType = vaultType;
        this.vaultData = vaultData;
        this.activeCode = activeCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.entityID = entityID;
        this.entityVersionID = entityVersionID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getEntityRefID() {
        return entityRefID;
    }

    public void setEntityRefID(Integer entityRefID) {
        this.entityRefID = entityRefID;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getVaultType() {
        return vaultType;
    }

    public void setVaultType(String vaultType) {
        this.vaultType = vaultType;
    }

    public String getVaultData() {
        return vaultData;
    }

    public void setVaultData(String vaultData) {
        this.vaultData = vaultData;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
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

    public Integer getEntityID() {
        return entityID;
    }

    public void setEntityID(Integer entityID) {
        this.entityID = entityID;
    }

    public Integer getEntityVersionID() {
        return entityVersionID;
    }

    public void setEntityVersionID(Integer entityVersionID) {
        this.entityVersionID = entityVersionID;
    }

    public static class Builder {

        private FgVault instance = new FgVault();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            instance.setEntityRefID(entityRefID);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder vaultType(String vaultType) {
            instance.setVaultType(vaultType);
            return this;
        }

        public Builder vaultData(String vaultData) {
            instance.setVaultData(vaultData);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
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

        public Builder entityID(Integer entityID) {
            instance.setEntityID(entityID);
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            instance.setEntityVersionID(entityVersionID);
            return this;
        }

        public FgVault build() {
            return instance;
        }
    }
}
