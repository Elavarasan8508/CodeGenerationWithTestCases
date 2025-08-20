package com.bsit.codegeneration.record;

public record FgSdkScheduleRule(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String scheduleType, String subscriptionName, String ownerOrgTypeCode, String ownerOrgCode, String subscriberOrgTypeCode, String subscriberOrgCode, String cronExpression, String scheduleChannelCode, String alertTemplateID, String externalEmail, String channelEmailTitle, String channelEmailContent, String scheduleStartDate, String scheduleEndDate, String h2hDatasourceID, String h2hDatasetID, String entitySubTypeCode, String sourceRefID, Long versionID, Long isMasterVersion, String cronObj) {

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

        private String scheduleType;

        private String subscriptionName;

        private String ownerOrgTypeCode;

        private String ownerOrgCode;

        private String subscriberOrgTypeCode;

        private String subscriberOrgCode;

        private String cronExpression;

        private String scheduleChannelCode;

        private String alertTemplateID;

        private String externalEmail;

        private String channelEmailTitle;

        private String channelEmailContent;

        private String scheduleStartDate;

        private String scheduleEndDate;

        private String h2hDatasourceID;

        private String h2hDatasetID;

        private String entitySubTypeCode;

        private String sourceRefID;

        private Long versionID;

        private Long isMasterVersion;

        private String cronObj;

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

        public Builder scheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }

        public Builder subscriptionName(String subscriptionName) {
            this.subscriptionName = subscriptionName;
            return this;
        }

        public Builder ownerOrgTypeCode(String ownerOrgTypeCode) {
            this.ownerOrgTypeCode = ownerOrgTypeCode;
            return this;
        }

        public Builder ownerOrgCode(String ownerOrgCode) {
            this.ownerOrgCode = ownerOrgCode;
            return this;
        }

        public Builder subscriberOrgTypeCode(String subscriberOrgTypeCode) {
            this.subscriberOrgTypeCode = subscriberOrgTypeCode;
            return this;
        }

        public Builder subscriberOrgCode(String subscriberOrgCode) {
            this.subscriberOrgCode = subscriberOrgCode;
            return this;
        }

        public Builder cronExpression(String cronExpression) {
            this.cronExpression = cronExpression;
            return this;
        }

        public Builder scheduleChannelCode(String scheduleChannelCode) {
            this.scheduleChannelCode = scheduleChannelCode;
            return this;
        }

        public Builder alertTemplateID(String alertTemplateID) {
            this.alertTemplateID = alertTemplateID;
            return this;
        }

        public Builder externalEmail(String externalEmail) {
            this.externalEmail = externalEmail;
            return this;
        }

        public Builder channelEmailTitle(String channelEmailTitle) {
            this.channelEmailTitle = channelEmailTitle;
            return this;
        }

        public Builder channelEmailContent(String channelEmailContent) {
            this.channelEmailContent = channelEmailContent;
            return this;
        }

        public Builder scheduleStartDate(String scheduleStartDate) {
            this.scheduleStartDate = scheduleStartDate;
            return this;
        }

        public Builder scheduleEndDate(String scheduleEndDate) {
            this.scheduleEndDate = scheduleEndDate;
            return this;
        }

        public Builder h2hDatasourceID(String h2hDatasourceID) {
            this.h2hDatasourceID = h2hDatasourceID;
            return this;
        }

        public Builder h2hDatasetID(String h2hDatasetID) {
            this.h2hDatasetID = h2hDatasetID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder sourceRefID(String sourceRefID) {
            this.sourceRefID = sourceRefID;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder cronObj(String cronObj) {
            this.cronObj = cronObj;
            return this;
        }

        public FgSdkScheduleRule build() {
            return new FgSdkScheduleRule(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, scheduleType, subscriptionName, ownerOrgTypeCode, ownerOrgCode, subscriberOrgTypeCode, subscriberOrgCode, cronExpression, scheduleChannelCode, alertTemplateID, externalEmail, channelEmailTitle, channelEmailContent, scheduleStartDate, scheduleEndDate, h2hDatasourceID, h2hDatasetID, entitySubTypeCode, sourceRefID, versionID, isMasterVersion, cronObj);
        }
    }
}
