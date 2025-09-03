package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgApplication {

    private Integer ID;

    private String code;

    private String name;

    private String subTitle;

    private String icon;

    private String description;

    private String navigationSchema;

    private Integer isSecured;

    private String activeCode;

    private String applicationType;

    private String uuid;

    private String tags;

    private String appTitle;

    private String deviceChannel;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String masterTemplate;

    private String masterContentHash;

    private Integer isMasterVersion;

    private Integer versionID;

    public FgApplication() {
    }

    public FgApplication(Integer ID, String code, String name, String subTitle, String icon, String description, String navigationSchema, Integer isSecured, String activeCode, String applicationType, String uuid, String tags, String appTitle, String deviceChannel, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String masterTemplate, String masterContentHash, Integer isMasterVersion, Integer versionID) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.subTitle = subTitle;
        this.icon = icon;
        this.description = description;
        this.navigationSchema = navigationSchema;
        this.isSecured = isSecured;
        this.activeCode = activeCode;
        this.applicationType = applicationType;
        this.uuid = uuid;
        this.tags = tags;
        this.appTitle = appTitle;
        this.deviceChannel = deviceChannel;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.masterTemplate = masterTemplate;
        this.masterContentHash = masterContentHash;
        this.isMasterVersion = isMasterVersion;
        this.versionID = versionID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNavigationSchema() {
        return navigationSchema;
    }

    public void setNavigationSchema(String navigationSchema) {
        this.navigationSchema = navigationSchema;
    }

    public Integer getIsSecured() {
        return isSecured;
    }

    public void setIsSecured(Integer isSecured) {
        this.isSecured = isSecured;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getDeviceChannel() {
        return deviceChannel;
    }

    public void setDeviceChannel(String deviceChannel) {
        this.deviceChannel = deviceChannel;
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

    public String getMasterTemplate() {
        return masterTemplate;
    }

    public void setMasterTemplate(String masterTemplate) {
        this.masterTemplate = masterTemplate;
    }

    public String getMasterContentHash() {
        return masterContentHash;
    }

    public void setMasterContentHash(String masterContentHash) {
        this.masterContentHash = masterContentHash;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public static class Builder {

        private FgApplication instance = new FgApplication();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder subTitle(String subTitle) {
            instance.setSubTitle(subTitle);
            return this;
        }

        public Builder icon(String icon) {
            instance.setIcon(icon);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder navigationSchema(String navigationSchema) {
            instance.setNavigationSchema(navigationSchema);
            return this;
        }

        public Builder isSecured(Integer isSecured) {
            instance.setIsSecured(isSecured);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder applicationType(String applicationType) {
            instance.setApplicationType(applicationType);
            return this;
        }

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder tags(String tags) {
            instance.setTags(tags);
            return this;
        }

        public Builder appTitle(String appTitle) {
            instance.setAppTitle(appTitle);
            return this;
        }

        public Builder deviceChannel(String deviceChannel) {
            instance.setDeviceChannel(deviceChannel);
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

        public Builder masterTemplate(String masterTemplate) {
            instance.setMasterTemplate(masterTemplate);
            return this;
        }

        public Builder masterContentHash(String masterContentHash) {
            instance.setMasterContentHash(masterContentHash);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public FgApplication build() {
            return instance;
        }
    }
}
