package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyContent {

    private Integer ID;

    private Integer partyID;

    private Integer partyVersionID;

    private String partySubType;

    private String partyCode;

    private String contentTypeCode;

    private String contentSubTypeCode;

    private String contentDocNo;

    private String contentFileName;

    private String contentStorageCode;

    private Integer contentAttachmentID;

    private Integer contentDmsID;

    private String contentDmsURL;

    private String contentTags;

    private String comments;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    public FgPartyContent() {
    }

    public FgPartyContent(Integer ID, Integer partyID, Integer partyVersionID, String partySubType, String partyCode, String contentTypeCode, String contentSubTypeCode, String contentDocNo, String contentFileName, String contentStorageCode, Integer contentAttachmentID, Integer contentDmsID, String contentDmsURL, String contentTags, String comments, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy) {
        this.ID = ID;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.partySubType = partySubType;
        this.partyCode = partyCode;
        this.contentTypeCode = contentTypeCode;
        this.contentSubTypeCode = contentSubTypeCode;
        this.contentDocNo = contentDocNo;
        this.contentFileName = contentFileName;
        this.contentStorageCode = contentStorageCode;
        this.contentAttachmentID = contentAttachmentID;
        this.contentDmsID = contentDmsID;
        this.contentDmsURL = contentDmsURL;
        this.contentTags = contentTags;
        this.comments = comments;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
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

    public String getPartySubType() {
        return partySubType;
    }

    public void setPartySubType(String partySubType) {
        this.partySubType = partySubType;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getContentTypeCode() {
        return contentTypeCode;
    }

    public void setContentTypeCode(String contentTypeCode) {
        this.contentTypeCode = contentTypeCode;
    }

    public String getContentSubTypeCode() {
        return contentSubTypeCode;
    }

    public void setContentSubTypeCode(String contentSubTypeCode) {
        this.contentSubTypeCode = contentSubTypeCode;
    }

    public String getContentDocNo() {
        return contentDocNo;
    }

    public void setContentDocNo(String contentDocNo) {
        this.contentDocNo = contentDocNo;
    }

    public String getContentFileName() {
        return contentFileName;
    }

    public void setContentFileName(String contentFileName) {
        this.contentFileName = contentFileName;
    }

    public String getContentStorageCode() {
        return contentStorageCode;
    }

    public void setContentStorageCode(String contentStorageCode) {
        this.contentStorageCode = contentStorageCode;
    }

    public Integer getContentAttachmentID() {
        return contentAttachmentID;
    }

    public void setContentAttachmentID(Integer contentAttachmentID) {
        this.contentAttachmentID = contentAttachmentID;
    }

    public Integer getContentDmsID() {
        return contentDmsID;
    }

    public void setContentDmsID(Integer contentDmsID) {
        this.contentDmsID = contentDmsID;
    }

    public String getContentDmsURL() {
        return contentDmsURL;
    }

    public void setContentDmsURL(String contentDmsURL) {
        this.contentDmsURL = contentDmsURL;
    }

    public String getContentTags() {
        return contentTags;
    }

    public void setContentTags(String contentTags) {
        this.contentTags = contentTags;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public static class Builder {

        private FgPartyContent instance = new FgPartyContent();

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

        public Builder partySubType(String partySubType) {
            instance.setPartySubType(partySubType);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder contentTypeCode(String contentTypeCode) {
            instance.setContentTypeCode(contentTypeCode);
            return this;
        }

        public Builder contentSubTypeCode(String contentSubTypeCode) {
            instance.setContentSubTypeCode(contentSubTypeCode);
            return this;
        }

        public Builder contentDocNo(String contentDocNo) {
            instance.setContentDocNo(contentDocNo);
            return this;
        }

        public Builder contentFileName(String contentFileName) {
            instance.setContentFileName(contentFileName);
            return this;
        }

        public Builder contentStorageCode(String contentStorageCode) {
            instance.setContentStorageCode(contentStorageCode);
            return this;
        }

        public Builder contentAttachmentID(Integer contentAttachmentID) {
            instance.setContentAttachmentID(contentAttachmentID);
            return this;
        }

        public Builder contentDmsID(Integer contentDmsID) {
            instance.setContentDmsID(contentDmsID);
            return this;
        }

        public Builder contentDmsURL(String contentDmsURL) {
            instance.setContentDmsURL(contentDmsURL);
            return this;
        }

        public Builder contentTags(String contentTags) {
            instance.setContentTags(contentTags);
            return this;
        }

        public Builder comments(String comments) {
            instance.setComments(comments);
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

        public FgPartyContent build() {
            return instance;
        }
    }
}
