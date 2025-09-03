package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgGroupPermission {

    private Integer ID;

    private Integer permissionID;

    private Integer groupID;

    private Integer groupVersionID;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgGroup group;

    private FgPermission permission;

    public FgGroupPermission() {
    }

    public FgGroupPermission(Integer ID, Integer permissionID, Integer groupID, Integer groupVersionID, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgGroup group, FgPermission permission) {
        this.ID = ID;
        this.permissionID = permissionID;
        this.groupID = groupID;
        this.groupVersionID = groupVersionID;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.group = group;
        this.permission = permission;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
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

    public FgPermission getPermission() {
        return permission;
    }

    public void setPermission(FgPermission permission) {
        this.permission = permission;
    }

    public static class Builder {

        private FgGroupPermission instance = new FgGroupPermission();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder permissionID(Integer permissionID) {
            instance.setPermissionID(permissionID);
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

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
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

        public Builder permission(FgPermission permission) {
            instance.setPermission(permission);
            return this;
        }

        public FgGroupPermission build() {
            return instance;
        }
    }
}
