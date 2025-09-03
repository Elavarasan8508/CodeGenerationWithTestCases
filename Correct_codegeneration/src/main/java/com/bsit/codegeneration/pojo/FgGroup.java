package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgGroup {

    private Integer ID;

    private String name;

    private String description;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String code;

    private String typeCode;

    private String subTypeCode;

    private String partyTypeCode;

    private Integer referenceID;

    private String configStatusCode;

    private String orgTypeCode;

    private String orgCode;

    private FgGroupPermission group;

    private FgPermission permission;

    private List<FgGroupPermission> fgGroupPermissionList;

    private List<FgGroupRole> fgGroupRoleList;

    private List<FgPartyGroup> fgPartyGroupList;

    private List<FgUserGroup> fgUserGroupList;

    public FgGroup() {
    }

    public FgGroup(Integer ID, String name, String description, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String code, String typeCode, String subTypeCode, String partyTypeCode, Integer referenceID, String configStatusCode, String orgTypeCode, String orgCode, FgGroupPermission group, FgPermission permission) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.code = code;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.partyTypeCode = partyTypeCode;
        this.referenceID = referenceID;
        this.configStatusCode = configStatusCode;
        this.orgTypeCode = orgTypeCode;
        this.orgCode = orgCode;
        this.group = group;
        this.permission = permission;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getConfigStatusCode() {
        return configStatusCode;
    }

    public void setConfigStatusCode(String configStatusCode) {
        this.configStatusCode = configStatusCode;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public FgGroupPermission getGroup() {
        return group;
    }

    public void setGroup(FgGroupPermission group) {
        this.group = group;
    }

    public FgPermission getPermission() {
        return permission;
    }

    public void setPermission(FgPermission permission) {
        this.permission = permission;
    }

    public List<FgGroupPermission> getFgGroupPermissionList() {
        return fgGroupPermissionList;
    }

    public void setFgGroupPermissionList(List<FgGroupPermission> fgGroupPermissionList) {
        this.fgGroupPermissionList = fgGroupPermissionList;
    }

    public List<FgGroupRole> getFgGroupRoleList() {
        return fgGroupRoleList;
    }

    public void setFgGroupRoleList(List<FgGroupRole> fgGroupRoleList) {
        this.fgGroupRoleList = fgGroupRoleList;
    }

    public List<FgPartyGroup> getFgPartyGroupList() {
        return fgPartyGroupList;
    }

    public void setFgPartyGroupList(List<FgPartyGroup> fgPartyGroupList) {
        this.fgPartyGroupList = fgPartyGroupList;
    }

    public List<FgUserGroup> getFgUserGroupList() {
        return fgUserGroupList;
    }

    public void setFgUserGroupList(List<FgUserGroup> fgUserGroupList) {
        this.fgUserGroupList = fgUserGroupList;
    }

    public static class Builder {

        private FgGroup instance = new FgGroup();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
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

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            instance.setPartyTypeCode(partyTypeCode);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder configStatusCode(String configStatusCode) {
            instance.setConfigStatusCode(configStatusCode);
            return this;
        }

        public Builder orgTypeCode(String orgTypeCode) {
            instance.setOrgTypeCode(orgTypeCode);
            return this;
        }

        public Builder orgCode(String orgCode) {
            instance.setOrgCode(orgCode);
            return this;
        }

        public Builder group(FgGroupPermission group) {
            instance.setGroup(group);
            return this;
        }

        public Builder permission(FgPermission permission) {
            instance.setPermission(permission);
            return this;
        }

        public Builder fgGroupPermissionList(List<FgGroupPermission> fgGroupPermissionList) {
            instance.setFgGroupPermissionList(fgGroupPermissionList);
            return this;
        }

        public Builder fgGroupRoleList(List<FgGroupRole> fgGroupRoleList) {
            instance.setFgGroupRoleList(fgGroupRoleList);
            return this;
        }

        public Builder fgPartyGroupList(List<FgPartyGroup> fgPartyGroupList) {
            instance.setFgPartyGroupList(fgPartyGroupList);
            return this;
        }

        public Builder fgUserGroupList(List<FgUserGroup> fgUserGroupList) {
            instance.setFgUserGroupList(fgUserGroupList);
            return this;
        }

        public FgGroup build() {
            return instance;
        }
    }
}
