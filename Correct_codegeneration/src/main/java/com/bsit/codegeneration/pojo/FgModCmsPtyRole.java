package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgModCmsPtyRole {

    private Integer ID;

    private String partyTypeCode;

    private String partySubTypeCode;

    private String partyRefNo;

    private Integer partyVersionID;

    private String partyRole;

    private String spaceRefNo;

    private Integer spaceVersionID;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgModCmsPtyRole() {
    }

    public FgModCmsPtyRole(Integer ID, String partyTypeCode, String partySubTypeCode, String partyRefNo, Integer partyVersionID, String partyRole, String spaceRefNo, Integer spaceVersionID, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.partyTypeCode = partyTypeCode;
        this.partySubTypeCode = partySubTypeCode;
        this.partyRefNo = partyRefNo;
        this.partyVersionID = partyVersionID;
        this.partyRole = partyRole;
        this.spaceRefNo = spaceRefNo;
        this.spaceVersionID = spaceVersionID;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getPartySubTypeCode() {
        return partySubTypeCode;
    }

    public void setPartySubTypeCode(String partySubTypeCode) {
        this.partySubTypeCode = partySubTypeCode;
    }

    public String getPartyRefNo() {
        return partyRefNo;
    }

    public void setPartyRefNo(String partyRefNo) {
        this.partyRefNo = partyRefNo;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(String partyRole) {
        this.partyRole = partyRole;
    }

    public String getSpaceRefNo() {
        return spaceRefNo;
    }

    public void setSpaceRefNo(String spaceRefNo) {
        this.spaceRefNo = spaceRefNo;
    }

    public Integer getSpaceVersionID() {
        return spaceVersionID;
    }

    public void setSpaceVersionID(Integer spaceVersionID) {
        this.spaceVersionID = spaceVersionID;
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

        private FgModCmsPtyRole instance = new FgModCmsPtyRole();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            instance.setPartyTypeCode(partyTypeCode);
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            instance.setPartySubTypeCode(partySubTypeCode);
            return this;
        }

        public Builder partyRefNo(String partyRefNo) {
            instance.setPartyRefNo(partyRefNo);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder partyRole(String partyRole) {
            instance.setPartyRole(partyRole);
            return this;
        }

        public Builder spaceRefNo(String spaceRefNo) {
            instance.setSpaceRefNo(spaceRefNo);
            return this;
        }

        public Builder spaceVersionID(Integer spaceVersionID) {
            instance.setSpaceVersionID(spaceVersionID);
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

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
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

        public FgModCmsPtyRole build() {
            return instance;
        }
    }
}
