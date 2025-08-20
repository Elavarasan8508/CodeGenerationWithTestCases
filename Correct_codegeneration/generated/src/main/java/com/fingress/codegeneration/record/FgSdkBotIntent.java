package com.bsit.codegeneration.record;

public record FgSdkBotIntent(Long ID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String intentModel, String intentName, String parentIntent, String dataset, String intentType, Long authorization, Long show, String prompt, String phraseName, String phraseStatus, String parameterField, String parameterDatatype, String parameter, String parameterStatus, Long input, Long required, String APIMethod, String content, String parentRefID, Long parentVersionID) {

    public static class Builder {

        private Long ID;

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

        private String intentModel;

        private String intentName;

        private String parentIntent;

        private String dataset;

        private String intentType;

        private Long authorization;

        private Long show;

        private String prompt;

        private String phraseName;

        private String phraseStatus;

        private String parameterField;

        private String parameterDatatype;

        private String parameter;

        private String parameterStatus;

        private Long input;

        private Long required;

        private String APIMethod;

        private String content;

        private String parentRefID;

        private Long parentVersionID;

        public Builder ID(Long ID) {
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

        public Builder intentModel(String intentModel) {
            this.intentModel = intentModel;
            return this;
        }

        public Builder intentName(String intentName) {
            this.intentName = intentName;
            return this;
        }

        public Builder parentIntent(String parentIntent) {
            this.parentIntent = parentIntent;
            return this;
        }

        public Builder dataset(String dataset) {
            this.dataset = dataset;
            return this;
        }

        public Builder intentType(String intentType) {
            this.intentType = intentType;
            return this;
        }

        public Builder authorization(Long authorization) {
            this.authorization = authorization;
            return this;
        }

        public Builder show(Long show) {
            this.show = show;
            return this;
        }

        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder phraseName(String phraseName) {
            this.phraseName = phraseName;
            return this;
        }

        public Builder phraseStatus(String phraseStatus) {
            this.phraseStatus = phraseStatus;
            return this;
        }

        public Builder parameterField(String parameterField) {
            this.parameterField = parameterField;
            return this;
        }

        public Builder parameterDatatype(String parameterDatatype) {
            this.parameterDatatype = parameterDatatype;
            return this;
        }

        public Builder parameter(String parameter) {
            this.parameter = parameter;
            return this;
        }

        public Builder parameterStatus(String parameterStatus) {
            this.parameterStatus = parameterStatus;
            return this;
        }

        public Builder input(Long input) {
            this.input = input;
            return this;
        }

        public Builder required(Long required) {
            this.required = required;
            return this;
        }

        public Builder APIMethod(String APIMethod) {
            this.APIMethod = APIMethod;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
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

        public FgSdkBotIntent build() {
            return new FgSdkBotIntent(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, intentModel, intentName, parentIntent, dataset, intentType, authorization, show, prompt, phraseName, phraseStatus, parameterField, parameterDatatype, parameter, parameterStatus, input, required, APIMethod, content, parentRefID, parentVersionID);
        }
    }
}
