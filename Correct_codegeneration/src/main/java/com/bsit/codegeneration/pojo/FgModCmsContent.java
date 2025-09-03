package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgModCmsContent {

    private Integer ID;

    private Integer versionID;

    private String ownerPartyCode;

    private String ownerTypeCode;

    private String spaceCode;

    private String contentRefNo;

    private String entityTypeCode;

    private String entitySubTypeCode;

    private String name;

    private String title;

    private String subTitle;

    private String description;

    private String contentData;

    private Integer isMasterVersion;

    private String publishDate;

    private String expireDate;

    private String stageCode;

    private String statusCode;

    private String activeCode;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgModCmsContent() {
    }

    public FgModCmsContent(Integer ID, Integer versionID, String ownerPartyCode, String ownerTypeCode, String spaceCode, String contentRefNo, String entityTypeCode, String entitySubTypeCode, String name, String title, String subTitle, String description, String contentData, Integer isMasterVersion, String publishDate, String expireDate, String stageCode, String statusCode, String activeCode, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.versionID = versionID;
        this.ownerPartyCode = ownerPartyCode;
        this.ownerTypeCode = ownerTypeCode;
        this.spaceCode = spaceCode;
        this.contentRefNo = contentRefNo;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.name = name;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.contentData = contentData;
        this.isMasterVersion = isMasterVersion;
        this.publishDate = publishDate;
        this.expireDate = expireDate;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.activeCode = activeCode;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public String getOwnerPartyCode() {
        return ownerPartyCode;
    }

    public void setOwnerPartyCode(String ownerPartyCode) {
        this.ownerPartyCode = ownerPartyCode;
    }

    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode;
    }

    public String getContentRefNo() {
        return contentRefNo;
    }

    public void setContentRefNo(String contentRefNo) {
        this.contentRefNo = contentRefNo;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentData() {
        return contentData;
    }

    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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

    public static class Builder {

        private FgModCmsContent instance = new FgModCmsContent();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            instance.setOwnerPartyCode(ownerPartyCode);
            return this;
        }

        public Builder ownerTypeCode(String ownerTypeCode) {
            instance.setOwnerTypeCode(ownerTypeCode);
            return this;
        }

        public Builder spaceCode(String spaceCode) {
            instance.setSpaceCode(spaceCode);
            return this;
        }

        public Builder contentRefNo(String contentRefNo) {
            instance.setContentRefNo(contentRefNo);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public Builder subTitle(String subTitle) {
            instance.setSubTitle(subTitle);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder contentData(String contentData) {
            instance.setContentData(contentData);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder publishDate(String publishDate) {
            instance.setPublishDate(publishDate);
            return this;
        }

        public Builder expireDate(String expireDate) {
            instance.setExpireDate(expireDate);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
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

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public FgModCmsContent build() {
            return instance;
        }
    }
}
