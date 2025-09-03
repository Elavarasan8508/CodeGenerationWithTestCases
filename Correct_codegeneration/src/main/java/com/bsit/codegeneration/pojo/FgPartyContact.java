package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyContact {

    private Integer ID;

    private Integer partyID;

    private String purposeCode;

    private String reference;

    private String typeCode;

    private Integer partyVersionID;

    private String description;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String systemSourceCode;

    private Integer sysDefined;

    private FgParty party;

    private FgParty partyVersion;

    public FgPartyContact() {
    }

    public FgPartyContact(Integer ID, Integer partyID, String purposeCode, String reference, String typeCode, Integer partyVersionID, String description, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String systemSourceCode, Integer sysDefined, FgParty party, FgParty partyVersion) {
        this.ID = ID;
        this.partyID = partyID;
        this.purposeCode = purposeCode;
        this.reference = reference;
        this.typeCode = typeCode;
        this.partyVersionID = partyVersionID;
        this.description = description;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.systemSourceCode = systemSourceCode;
        this.sysDefined = sysDefined;
        this.party = party;
        this.partyVersion = partyVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPartyID() {
        return partyID;
    }

    public void setPartyID(Integer partyID) {
        this.partyID = partyID;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSystemSourceCode() {
        return systemSourceCode;
    }

    public void setSystemSourceCode(String systemSourceCode) {
        this.systemSourceCode = systemSourceCode;
    }

    public Integer getSysDefined() {
        return sysDefined;
    }

    public void setSysDefined(Integer sysDefined) {
        this.sysDefined = sysDefined;
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

        private FgPartyContact instance = new FgPartyContact();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder partyID(Integer partyID) {
            instance.setPartyID(partyID);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder reference(String reference) {
            instance.setReference(reference);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
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

        public Builder systemSourceCode(String systemSourceCode) {
            instance.setSystemSourceCode(systemSourceCode);
            return this;
        }

        public Builder sysDefined(Integer sysDefined) {
            instance.setSysDefined(sysDefined);
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

        public FgPartyContact build() {
            return instance;
        }
    }
}
