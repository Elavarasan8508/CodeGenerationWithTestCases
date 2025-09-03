package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgGroupRole {

    private Integer ID;

    private Integer groupID;

    private Integer groupVersionID;

    private Integer roleID;

    private Integer roleVersionID;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgGroup group;

    private FgRole role;

    private FgRole roleVersion;

    public FgGroupRole() {
    }

    public FgGroupRole(Integer ID, Integer groupID, Integer groupVersionID, Integer roleID, Integer roleVersionID, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgGroup group, FgRole role, FgRole roleVersion) {
        this.ID = ID;
        this.groupID = groupID;
        this.groupVersionID = groupVersionID;
        this.roleID = roleID;
        this.roleVersionID = roleVersionID;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.group = group;
        this.role = role;
        this.roleVersion = roleVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getGroupVersionID() {
        return groupVersionID;
    }

    public void setGroupVersionID(Integer groupVersionID) {
        this.groupVersionID = groupVersionID;
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

    public FgGroup getGroup() {
        return group;
    }

    public void setGroup(FgGroup group) {
        this.group = group;
    }

    public FgRole getRole() {
        return role;
    }

    public void setRole(FgRole role) {
        this.role = role;
    }

    public FgRole getRoleVersion() {
        return roleVersion;
    }

    public void setRoleVersion(FgRole roleVersion) {
        this.roleVersion = roleVersion;
    }

    public static class Builder {

        private FgGroupRole instance = new FgGroupRole();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder groupID(Integer groupID) {
            instance.setGroupID(groupID);
            return this;
        }

        public Builder groupVersionID(Integer groupVersionID) {
            instance.setGroupVersionID(groupVersionID);
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

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder group(FgGroup group) {
            instance.setGroup(group);
            return this;
        }

        public Builder role(FgRole role) {
            instance.setRole(role);
            return this;
        }

        public Builder roleVersion(FgRole roleVersion) {
            instance.setRoleVersion(roleVersion);
            return this;
        }

        public FgGroupRole build() {
            return instance;
        }
    }
}
