package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyRole {

    private Integer ID;

    private Integer partyID;

    private Integer partyVersionID;

    private Integer roleID;

    private Integer roleVersionID;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    private FgParty party;

    private FgParty partyVersion;

    private FgRole roleVersion;

    private FgRole role;

    public FgPartyRole() {
    }

    public FgPartyRole(Integer ID, Integer partyID, Integer partyVersionID, Integer roleID, Integer roleVersionID, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn, FgParty party, FgParty partyVersion, FgRole roleVersion, FgRole role) {
        this.ID = ID;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.roleID = roleID;
        this.roleVersionID = roleVersionID;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.party = party;
        this.partyVersion = partyVersion;
        this.roleVersion = roleVersion;
        this.role = role;
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

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getRoleVersionID() {
        return roleVersionID;
    }

    public void setRoleVersionID(Integer roleVersionID) {
        this.roleVersionID = roleVersionID;
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

    public FgRole getRoleVersion() {
        return roleVersion;
    }

    public void setRoleVersion(FgRole roleVersion) {
        this.roleVersion = roleVersion;
    }

    public FgRole getRole() {
        return role;
    }

    public void setRole(FgRole role) {
        this.role = role;
    }

    public static class Builder {

        private FgPartyRole instance = new FgPartyRole();

        public Builder ID(Integer ID) {
            instance.setID(ID);
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

        public Builder roleID(Integer roleID) {
            instance.setRoleID(roleID);
            return this;
        }

        public Builder roleVersionID(Integer roleVersionID) {
            instance.setRoleVersionID(roleVersionID);
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

        public Builder party(FgParty party) {
            instance.setParty(party);
            return this;
        }

        public Builder partyVersion(FgParty partyVersion) {
            instance.setPartyVersion(partyVersion);
            return this;
        }

        public Builder roleVersion(FgRole roleVersion) {
            instance.setRoleVersion(roleVersion);
            return this;
        }

        public Builder role(FgRole role) {
            instance.setRole(role);
            return this;
        }

        public FgPartyRole build() {
            return instance;
        }
    }
}
