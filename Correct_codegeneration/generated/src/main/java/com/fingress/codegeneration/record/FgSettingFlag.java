package com.bsit.codegeneration.record;

public record FgSettingFlag(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String settingName, String settingKey, String settingCode, String settingDescription, String settingTag, String ownerPartyCode, String entitySubType, String settingEnvironment, String applicationType, String propertyType, String settingStatus, String settingValue, String settingDefaultValue, String encryptionflag, String processID, String deploymentStatus, String programSelect) {

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

        private String settingName;

        private String settingKey;

        private String settingCode;

        private String settingDescription;

        private String settingTag;

        private String ownerPartyCode;

        private String entitySubType;

        private String settingEnvironment;

        private String applicationType;

        private String propertyType;

        private String settingStatus;

        private String settingValue;

        private String settingDefaultValue;

        private String encryptionflag;

        private String processID;

        private String deploymentStatus;

        private String programSelect;

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

        public Builder settingName(String settingName) {
            this.settingName = settingName;
            return this;
        }

        public Builder settingKey(String settingKey) {
            this.settingKey = settingKey;
            return this;
        }

        public Builder settingCode(String settingCode) {
            this.settingCode = settingCode;
            return this;
        }

        public Builder settingDescription(String settingDescription) {
            this.settingDescription = settingDescription;
            return this;
        }

        public Builder settingTag(String settingTag) {
            this.settingTag = settingTag;
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            this.ownerPartyCode = ownerPartyCode;
            return this;
        }

        public Builder entitySubType(String entitySubType) {
            this.entitySubType = entitySubType;
            return this;
        }

        public Builder settingEnvironment(String settingEnvironment) {
            this.settingEnvironment = settingEnvironment;
            return this;
        }

        public Builder applicationType(String applicationType) {
            this.applicationType = applicationType;
            return this;
        }

        public Builder propertyType(String propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder settingStatus(String settingStatus) {
            this.settingStatus = settingStatus;
            return this;
        }

        public Builder settingValue(String settingValue) {
            this.settingValue = settingValue;
            return this;
        }

        public Builder settingDefaultValue(String settingDefaultValue) {
            this.settingDefaultValue = settingDefaultValue;
            return this;
        }

        public Builder encryptionflag(String encryptionflag) {
            this.encryptionflag = encryptionflag;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder deploymentStatus(String deploymentStatus) {
            this.deploymentStatus = deploymentStatus;
            return this;
        }

        public Builder programSelect(String programSelect) {
            this.programSelect = programSelect;
            return this;
        }

        public FgSettingFlag build() {
            return new FgSettingFlag(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, settingName, settingKey, settingCode, settingDescription, settingTag, ownerPartyCode, entitySubType, settingEnvironment, applicationType, propertyType, settingStatus, settingValue, settingDefaultValue, encryptionflag, processID, deploymentStatus, programSelect);
        }
    }
}
