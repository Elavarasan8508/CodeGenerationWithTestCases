package com.bsit.codegeneration.record;

public record ScfFileLines(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String anchorCrn, String fileMasterRefNo, Long lineNo, String lineContent, String lineContentHashValue, String lineRecordType, String lineStatus, String lineStatusRemarks, String lineHashValStatus, String lineHashValRemarks, String fileEventRefNo) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String anchorCrn;

        private String fileMasterRefNo;

        private Long lineNo;

        private String lineContent;

        private String lineContentHashValue;

        private String lineRecordType;

        private String lineStatus;

        private String lineStatusRemarks;

        private String lineHashValStatus;

        private String lineHashValRemarks;

        private String fileEventRefNo;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            this.fileMasterRefNo = fileMasterRefNo;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder lineContent(String lineContent) {
            this.lineContent = lineContent;
            return this;
        }

        public Builder lineContentHashValue(String lineContentHashValue) {
            this.lineContentHashValue = lineContentHashValue;
            return this;
        }

        public Builder lineRecordType(String lineRecordType) {
            this.lineRecordType = lineRecordType;
            return this;
        }

        public Builder lineStatus(String lineStatus) {
            this.lineStatus = lineStatus;
            return this;
        }

        public Builder lineStatusRemarks(String lineStatusRemarks) {
            this.lineStatusRemarks = lineStatusRemarks;
            return this;
        }

        public Builder lineHashValStatus(String lineHashValStatus) {
            this.lineHashValStatus = lineHashValStatus;
            return this;
        }

        public Builder lineHashValRemarks(String lineHashValRemarks) {
            this.lineHashValRemarks = lineHashValRemarks;
            return this;
        }

        public Builder fileEventRefNo(String fileEventRefNo) {
            this.fileEventRefNo = fileEventRefNo;
            return this;
        }

        public ScfFileLines build() {
            return new ScfFileLines(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, anchorCrn, fileMasterRefNo, lineNo, lineContent, lineContentHashValue, lineRecordType, lineStatus, lineStatusRemarks, lineHashValStatus, lineHashValRemarks, fileEventRefNo);
        }
    }
}
