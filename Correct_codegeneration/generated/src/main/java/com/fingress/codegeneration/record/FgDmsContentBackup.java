package com.bsit.codegeneration.record;

public record FgDmsContentBackup(Long ID, String dmsDocPath, String dmsDocReferenceID, String fileContent, String fileName, String fileSize, String fileType, String title, Long dmsEventID, String description, String filePurposeCode, String dmsReference, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private String dmsDocPath;

        private String dmsDocReferenceID;

        private String fileContent;

        private String fileName;

        private String fileSize;

        private String fileType;

        private String title;

        private Long dmsEventID;

        private String description;

        private String filePurposeCode;

        private String dmsReference;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder dmsDocPath(String dmsDocPath) {
            this.dmsDocPath = dmsDocPath;
            return this;
        }

        public Builder dmsDocReferenceID(String dmsDocReferenceID) {
            this.dmsDocReferenceID = dmsDocReferenceID;
            return this;
        }

        public Builder fileContent(String fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileSize(String fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder dmsEventID(Long dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder filePurposeCode(String filePurposeCode) {
            this.filePurposeCode = filePurposeCode;
            return this;
        }

        public Builder dmsReference(String dmsReference) {
            this.dmsReference = dmsReference;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public FgDmsContentBackup build() {
            return new FgDmsContentBackup(ID, dmsDocPath, dmsDocReferenceID, fileContent, fileName, fileSize, fileType, title, dmsEventID, description, filePurposeCode, dmsReference, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
