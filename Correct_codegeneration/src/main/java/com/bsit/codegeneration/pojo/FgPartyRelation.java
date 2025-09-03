package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyRelation {

    private Integer ID;

    private String partyFromRoleCode;

    private String partyToRoleCode;

    private Integer fromPartyID;

    private Integer fromPartyVersionID;

    private Integer toPartyID;

    private Integer toPartyVersionID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String fromPartyUserCode;

    private Integer fromPartyUserID;

    private Integer fromPartyUserVersionID;

    private FgParty fromParty;

    private FgParty toParty;

    private FgParty fromPartyVersion;

    private FgParty toPartyVersion;

    public FgPartyRelation() {
    }

    public FgPartyRelation(Integer ID, String partyFromRoleCode, String partyToRoleCode, Integer fromPartyID, Integer fromPartyVersionID, Integer toPartyID, Integer toPartyVersionID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String fromPartyUserCode, Integer fromPartyUserID, Integer fromPartyUserVersionID, FgParty fromParty, FgParty toParty, FgParty fromPartyVersion, FgParty toPartyVersion) {
        this.ID = ID;
        this.partyFromRoleCode = partyFromRoleCode;
        this.partyToRoleCode = partyToRoleCode;
        this.fromPartyID = fromPartyID;
        this.fromPartyVersionID = fromPartyVersionID;
        this.toPartyID = toPartyID;
        this.toPartyVersionID = toPartyVersionID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.fromPartyUserCode = fromPartyUserCode;
        this.fromPartyUserID = fromPartyUserID;
        this.fromPartyUserVersionID = fromPartyUserVersionID;
        this.fromParty = fromParty;
        this.toParty = toParty;
        this.fromPartyVersion = fromPartyVersion;
        this.toPartyVersion = toPartyVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPartyFromRoleCode() {
        return partyFromRoleCode;
    }

    public void setPartyFromRoleCode(String partyFromRoleCode) {
        this.partyFromRoleCode = partyFromRoleCode;
    }

    public String getPartyToRoleCode() {
        return partyToRoleCode;
    }

    public void setPartyToRoleCode(String partyToRoleCode) {
        this.partyToRoleCode = partyToRoleCode;
    }

    public Integer getFromPartyID() {
        return fromPartyID;
    }

    public void setFromPartyID(Integer fromPartyID) {
        this.fromPartyID = fromPartyID;
    }

    public Integer getFromPartyVersionID() {
        return fromPartyVersionID;
    }

    public void setFromPartyVersionID(Integer fromPartyVersionID) {
        this.fromPartyVersionID = fromPartyVersionID;
    }

    public Integer getToPartyID() {
        return toPartyID;
    }

    public void setToPartyID(Integer toPartyID) {
        this.toPartyID = toPartyID;
    }

    public Integer getToPartyVersionID() {
        return toPartyVersionID;
    }

    public void setToPartyVersionID(Integer toPartyVersionID) {
        this.toPartyVersionID = toPartyVersionID;
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

    public String getFromPartyUserCode() {
        return fromPartyUserCode;
    }

    public void setFromPartyUserCode(String fromPartyUserCode) {
        this.fromPartyUserCode = fromPartyUserCode;
    }

    public Integer getFromPartyUserID() {
        return fromPartyUserID;
    }

    public void setFromPartyUserID(Integer fromPartyUserID) {
        this.fromPartyUserID = fromPartyUserID;
    }

    public Integer getFromPartyUserVersionID() {
        return fromPartyUserVersionID;
    }

    public void setFromPartyUserVersionID(Integer fromPartyUserVersionID) {
        this.fromPartyUserVersionID = fromPartyUserVersionID;
    }

    public FgParty getFromParty() {
        return fromParty;
    }

    public void setFromParty(FgParty fromParty) {
        this.fromParty = fromParty;
    }

    public FgParty getToParty() {
        return toParty;
    }

    public void setToParty(FgParty toParty) {
        this.toParty = toParty;
    }

    public FgParty getFromPartyVersion() {
        return fromPartyVersion;
    }

    public void setFromPartyVersion(FgParty fromPartyVersion) {
        this.fromPartyVersion = fromPartyVersion;
    }

    public FgParty getToPartyVersion() {
        return toPartyVersion;
    }

    public void setToPartyVersion(FgParty toPartyVersion) {
        this.toPartyVersion = toPartyVersion;
    }

    public static class Builder {

        private FgPartyRelation instance = new FgPartyRelation();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder partyFromRoleCode(String partyFromRoleCode) {
            instance.setPartyFromRoleCode(partyFromRoleCode);
            return this;
        }

        public Builder partyToRoleCode(String partyToRoleCode) {
            instance.setPartyToRoleCode(partyToRoleCode);
            return this;
        }

        public Builder fromPartyID(Integer fromPartyID) {
            instance.setFromPartyID(fromPartyID);
            return this;
        }

        public Builder fromPartyVersionID(Integer fromPartyVersionID) {
            instance.setFromPartyVersionID(fromPartyVersionID);
            return this;
        }

        public Builder toPartyID(Integer toPartyID) {
            instance.setToPartyID(toPartyID);
            return this;
        }

        public Builder toPartyVersionID(Integer toPartyVersionID) {
            instance.setToPartyVersionID(toPartyVersionID);
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

        public Builder fromPartyUserCode(String fromPartyUserCode) {
            instance.setFromPartyUserCode(fromPartyUserCode);
            return this;
        }

        public Builder fromPartyUserID(Integer fromPartyUserID) {
            instance.setFromPartyUserID(fromPartyUserID);
            return this;
        }

        public Builder fromPartyUserVersionID(Integer fromPartyUserVersionID) {
            instance.setFromPartyUserVersionID(fromPartyUserVersionID);
            return this;
        }

        public Builder fromParty(FgParty fromParty) {
            instance.setFromParty(fromParty);
            return this;
        }

        public Builder toParty(FgParty toParty) {
            instance.setToParty(toParty);
            return this;
        }

        public Builder fromPartyVersion(FgParty fromPartyVersion) {
            instance.setFromPartyVersion(fromPartyVersion);
            return this;
        }

        public Builder toPartyVersion(FgParty toPartyVersion) {
            instance.setToPartyVersion(toPartyVersion);
            return this;
        }

        public FgPartyRelation build() {
            return instance;
        }
    }
}
