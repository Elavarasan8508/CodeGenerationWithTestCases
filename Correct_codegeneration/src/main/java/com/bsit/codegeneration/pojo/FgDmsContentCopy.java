package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgDmsContentCopy {

    private Integer ID;

    private String dmsDocPath;

    private Integer dmsDocReferenceID;

    private byte[] fileContent;

    private String fileName;

    private String fileSize;

    private String fileType;

    private String title;

    private Integer dmsEventID;

    private String description;

    private String filePurposeCode;

    private String dmsReference;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    public FgDmsContentCopy() {
    }

    public FgDmsContentCopy(Integer ID, String dmsDocPath, Integer dmsDocReferenceID, byte[] fileContent, String fileName, String fileSize, String fileType, String title, Integer dmsEventID, String description, String filePurposeCode, String dmsReference, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy) {
        this.ID = ID;
        this.dmsDocPath = dmsDocPath;
        this.dmsDocReferenceID = dmsDocReferenceID;
        this.fileContent = fileContent;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.title = title;
        this.dmsEventID = dmsEventID;
        this.description = description;
        this.filePurposeCode = filePurposeCode;
        this.dmsReference = dmsReference;
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

    public String getDmsDocPath() {
        return dmsDocPath;
    }

    public void setDmsDocPath(String dmsDocPath) {
        this.dmsDocPath = dmsDocPath;
    }

    public Integer getDmsDocReferenceID() {
        return dmsDocReferenceID;
    }

    public void setDmsDocReferenceID(Integer dmsDocReferenceID) {
        this.dmsDocReferenceID = dmsDocReferenceID;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDmsEventID() {
        return dmsEventID;
    }

    public void setDmsEventID(Integer dmsEventID) {
        this.dmsEventID = dmsEventID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePurposeCode() {
        return filePurposeCode;
    }

    public void setFilePurposeCode(String filePurposeCode) {
        this.filePurposeCode = filePurposeCode;
    }

    public String getDmsReference() {
        return dmsReference;
    }

    public void setDmsReference(String dmsReference) {
        this.dmsReference = dmsReference;
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

        private FgDmsContentCopy instance = new FgDmsContentCopy();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder dmsDocPath(String dmsDocPath) {
            instance.setDmsDocPath(dmsDocPath);
            return this;
        }

        public Builder dmsDocReferenceID(Integer dmsDocReferenceID) {
            instance.setDmsDocReferenceID(dmsDocReferenceID);
            return this;
        }

        public Builder fileContent(byte[] fileContent) {
            instance.setFileContent(fileContent);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder fileSize(String fileSize) {
            instance.setFileSize(fileSize);
            return this;
        }

        public Builder fileType(String fileType) {
            instance.setFileType(fileType);
            return this;
        }

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            instance.setDmsEventID(dmsEventID);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder filePurposeCode(String filePurposeCode) {
            instance.setFilePurposeCode(filePurposeCode);
            return this;
        }

        public Builder dmsReference(String dmsReference) {
            instance.setDmsReference(dmsReference);
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

        public FgDmsContentCopy build() {
            return instance;
        }
    }
}
