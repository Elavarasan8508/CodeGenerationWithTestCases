package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgRolePermission {

    private Integer ID;

    private Integer permissionID;

    private Integer roleID;

    private Integer roleVersionID;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgPermission permission;

    public FgRolePermission() {
    }

    public FgRolePermission(Integer ID, Integer permissionID, Integer roleID, Integer roleVersionID, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgPermission permission) {
        this.ID = ID;
        this.permissionID = permissionID;
        this.roleID = roleID;
        this.roleVersionID = roleVersionID;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
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

    public FgPermission getPermission() {
        return permission;
    }

    public void setPermission(FgPermission permission) {
        this.permission = permission;
    }

    public static class Builder {

        private FgRolePermission instance = new FgRolePermission();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder permissionID(Integer permissionID) {
            instance.setPermissionID(permissionID);
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

        public Builder permission(FgPermission permission) {
            instance.setPermission(permission);
            return this;
        }

        public FgRolePermission build() {
            return instance;
        }
    }
}
