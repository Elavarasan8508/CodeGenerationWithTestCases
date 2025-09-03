package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgPartyMemberRole {

    private Integer ID;

    private String partyTypeCode;

    private String partyCode;

    private Integer partyRefID;

    private Integer partyVersionID;

    private String roleCode;

    private java.time.LocalDateTime effectiveFrom;

    private java.time.LocalDateTime effectiveTo;

    private String description;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String systemSourceCode;

    public FgPartyMemberRole() {
    }

    public FgPartyMemberRole(Integer ID, String partyTypeCode, String partyCode, Integer partyRefID, Integer partyVersionID, String roleCode, java.time.LocalDateTime effectiveFrom, java.time.LocalDateTime effectiveTo, String description, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String systemSourceCode) {
        this.ID = ID;
        this.partyTypeCode = partyTypeCode;
        this.partyCode = partyCode;
        this.partyRefID = partyRefID;
        this.partyVersionID = partyVersionID;
        this.roleCode = roleCode;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.description = description;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.systemSourceCode = systemSourceCode;
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

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public Integer getPartyRefID() {
        return partyRefID;
    }

    public void setPartyRefID(Integer partyRefID) {
        this.partyRefID = partyRefID;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public java.time.LocalDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(java.time.LocalDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public java.time.LocalDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(java.time.LocalDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
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

    public static class Builder {

        private FgPartyMemberRole instance = new FgPartyMemberRole();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            instance.setPartyTypeCode(partyTypeCode);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder partyRefID(Integer partyRefID) {
            instance.setPartyRefID(partyRefID);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder roleCode(String roleCode) {
            instance.setRoleCode(roleCode);
            return this;
        }

        public Builder effectiveFrom(java.time.LocalDateTime effectiveFrom) {
            instance.setEffectiveFrom(effectiveFrom);
            return this;
        }

        public Builder effectiveTo(java.time.LocalDateTime effectiveTo) {
            instance.setEffectiveTo(effectiveTo);
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

        public FgPartyMemberRole build() {
            return instance;
        }
    }
}
