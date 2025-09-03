package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgPermission {

    private Integer ID;

    private String classCode;

    private String fieldCode;

    private String typeCode;

    private String categoryCode;

    private String subTypeCode;

    private String operationCode;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgRolePermission permission;

    private FgGroup group;

    private List<FgGroupPermission> fgGroupPermissionList;

    private List<FgRolePermission> fgRolePermissionList;

    public FgPermission() {
    }

    public FgPermission(Integer ID, String classCode, String fieldCode, String typeCode, String categoryCode, String subTypeCode, String operationCode, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgRolePermission permission, FgGroup group) {
        this.ID = ID;
        this.classCode = classCode;
        this.fieldCode = fieldCode;
        this.typeCode = typeCode;
        this.categoryCode = categoryCode;
        this.subTypeCode = subTypeCode;
        this.operationCode = operationCode;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.permission = permission;
        this.group = group;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
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

    public FgRolePermission getPermission() {
        return permission;
    }

    public void setPermission(FgRolePermission permission) {
        this.permission = permission;
    }

    public FgGroup getGroup() {
        return group;
    }

    public void setGroup(FgGroup group) {
        this.group = group;
    }

    public List<FgGroupPermission> getFgGroupPermissionList() {
        return fgGroupPermissionList;
    }

    public void setFgGroupPermissionList(List<FgGroupPermission> fgGroupPermissionList) {
        this.fgGroupPermissionList = fgGroupPermissionList;
    }

    public List<FgRolePermission> getFgRolePermissionList() {
        return fgRolePermissionList;
    }

    public void setFgRolePermissionList(List<FgRolePermission> fgRolePermissionList) {
        this.fgRolePermissionList = fgRolePermissionList;
    }

    public static class Builder {

        private FgPermission instance = new FgPermission();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder classCode(String classCode) {
            instance.setClassCode(classCode);
            return this;
        }

        public Builder fieldCode(String fieldCode) {
            instance.setFieldCode(fieldCode);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            instance.setCategoryCode(categoryCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder operationCode(String operationCode) {
            instance.setOperationCode(operationCode);
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

        public Builder permission(FgRolePermission permission) {
            instance.setPermission(permission);
            return this;
        }

        public Builder group(FgGroup group) {
            instance.setGroup(group);
            return this;
        }

        public Builder fgGroupPermissionList(List<FgGroupPermission> fgGroupPermissionList) {
            instance.setFgGroupPermissionList(fgGroupPermissionList);
            return this;
        }

        public Builder fgRolePermissionList(List<FgRolePermission> fgRolePermissionList) {
            instance.setFgRolePermissionList(fgRolePermissionList);
            return this;
        }

        public FgPermission build() {
            return instance;
        }
    }
}
