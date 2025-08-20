package com.bsit.codegeneration.record;

public record FgLayoutMapping(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String layoutMapping, String listMapping, Long layoutID, Long listID, String layoutUuid, String listUuid, String type, Long formID, String formMapping, String formUuid) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private String layoutMapping;

        private String listMapping;

        private Long layoutID;

        private Long listID;

        private String layoutUuid;

        private String listUuid;

        private String type;

        private Long formID;

        private String formMapping;

        private String formUuid;

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

        public Builder processID(String processID) {
            this.processID = processID;
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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder layoutMapping(String layoutMapping) {
            this.layoutMapping = layoutMapping;
            return this;
        }

        public Builder listMapping(String listMapping) {
            this.listMapping = listMapping;
            return this;
        }

        public Builder layoutID(Long layoutID) {
            this.layoutID = layoutID;
            return this;
        }

        public Builder listID(Long listID) {
            this.listID = listID;
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            this.layoutUuid = layoutUuid;
            return this;
        }

        public Builder listUuid(String listUuid) {
            this.listUuid = listUuid;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder formID(Long formID) {
            this.formID = formID;
            return this;
        }

        public Builder formMapping(String formMapping) {
            this.formMapping = formMapping;
            return this;
        }

        public Builder formUuid(String formUuid) {
            this.formUuid = formUuid;
            return this;
        }

        public FgLayoutMapping build() {
            return new FgLayoutMapping(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, layoutMapping, listMapping, layoutID, listID, layoutUuid, listUuid, type, formID, formMapping, formUuid);
        }
    }
}
