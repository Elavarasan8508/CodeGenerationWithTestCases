package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyAddress {

    private Integer ID;

    private String purposeCode;

    private Integer addressID;

    private Integer partyID;

    private Integer partyVersionID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgAddress address;

    private FgParty party;

    private FgParty partyVersion;

    public FgPartyAddress() {
    }

    public FgPartyAddress(Integer ID, String purposeCode, Integer addressID, Integer partyID, Integer partyVersionID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgAddress address, FgParty party, FgParty partyVersion) {
        this.ID = ID;
        this.purposeCode = purposeCode;
        this.addressID = addressID;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.address = address;
        this.party = party;
        this.partyVersion = partyVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
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

    public FgAddress getAddress() {
        return address;
    }

    public void setAddress(FgAddress address) {
        this.address = address;
    }

    public FgParty getParty() {
        return party;
    }

    public void setParty(FgParty party) {
        this.party = party;
    }

    public FgParty getPartyVersion() {
        return partyVersion;
    }

    public void setPartyVersion(FgParty partyVersion) {
        this.partyVersion = partyVersion;
    }

    public static class Builder {

        private FgPartyAddress instance = new FgPartyAddress();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder addressID(Integer addressID) {
            instance.setAddressID(addressID);
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

        public Builder address(FgAddress address) {
            instance.setAddress(address);
            return this;
        }

        public Builder party(FgParty party) {
            instance.setParty(party);
            return this;
        }

        public Builder partyVersion(FgParty partyVersion) {
            instance.setPartyVersion(partyVersion);
            return this;
        }

        public FgPartyAddress build() {
            return instance;
        }
    }
}
