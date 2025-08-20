package com.bsit.codegeneration.record;

public record FgSdkBusinessCode(String ID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String codeType, String parentType, String parentCode, String templateCode, String description, String codeValue, String name, String activecode, String parentRefID, Long parentVersionID) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String applicantPartyCode;

        private String applicantRefID;

        private String issuingPartyCode;

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

        private String codeType;

        private String parentType;

        private String parentCode;

        private String templateCode;

        private String description;

        private String codeValue;

        private String name;

        private String activecode;

        private String parentRefID;

        private Long parentVersionID;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder applicantRefID(String applicantRefID) {
            this.applicantRefID = applicantRefID;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
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

        public Builder codeType(String codeType) {
            this.codeType = codeType;
            return this;
        }

        public Builder parentType(String parentType) {
            this.parentType = parentType;
            return this;
        }

        public Builder parentCode(String parentCode) {
            this.parentCode = parentCode;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder codeValue(String codeValue) {
            this.codeValue = codeValue;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder activecode(String activecode) {
            this.activecode = activecode;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public FgSdkBusinessCode build() {
            return new FgSdkBusinessCode(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, codeType, parentType, parentCode, templateCode, description, codeValue, name, activecode, parentRefID, parentVersionID);
        }
    }
}
