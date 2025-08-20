package com.bsit.codegeneration.record;

public record FgUploadEntityAttribute(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String relCategory, String relEntityType, String relEntityRefNo, String relEntyRefVersion, String relAttributeType, String relAttributeKey, String relAttributeValue, String uploadRefNo, String relEntitySubType, String relEntityAttribute) {

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

        private String relCategory;

        private String relEntityType;

        private String relEntityRefNo;

        private String relEntyRefVersion;

        private String relAttributeType;

        private String relAttributeKey;

        private String relAttributeValue;

        private String uploadRefNo;

        private String relEntitySubType;

        private String relEntityAttribute;

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

        public Builder relCategory(String relCategory) {
            this.relCategory = relCategory;
            return this;
        }

        public Builder relEntityType(String relEntityType) {
            this.relEntityType = relEntityType;
            return this;
        }

        public Builder relEntityRefNo(String relEntityRefNo) {
            this.relEntityRefNo = relEntityRefNo;
            return this;
        }

        public Builder relEntyRefVersion(String relEntyRefVersion) {
            this.relEntyRefVersion = relEntyRefVersion;
            return this;
        }

        public Builder relAttributeType(String relAttributeType) {
            this.relAttributeType = relAttributeType;
            return this;
        }

        public Builder relAttributeKey(String relAttributeKey) {
            this.relAttributeKey = relAttributeKey;
            return this;
        }

        public Builder relAttributeValue(String relAttributeValue) {
            this.relAttributeValue = relAttributeValue;
            return this;
        }

        public Builder uploadRefNo(String uploadRefNo) {
            this.uploadRefNo = uploadRefNo;
            return this;
        }

        public Builder relEntitySubType(String relEntitySubType) {
            this.relEntitySubType = relEntitySubType;
            return this;
        }

        public Builder relEntityAttribute(String relEntityAttribute) {
            this.relEntityAttribute = relEntityAttribute;
            return this;
        }

        public FgUploadEntityAttribute build() {
            return new FgUploadEntityAttribute(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, relCategory, relEntityType, relEntityRefNo, relEntyRefVersion, relAttributeType, relAttributeKey, relAttributeValue, uploadRefNo, relEntitySubType, relEntityAttribute);
        }
    }
}
