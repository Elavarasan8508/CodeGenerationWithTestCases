package com.bsit.codegeneration.record;

public record FgEventNotification(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String entityRefID, String entityVersionID, String entityTypeCode, String entitySubTypeCode, String eventType, String eventStatus, String channel, String notificationPurpose, String stages, String eventTemplateID, String recipientMobileNumber, String recipientEmailAddress, String sendersEmailAddress, String subject, String content, Long attachments) {

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

        private String entityRefID;

        private String entityVersionID;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String eventType;

        private String eventStatus;

        private String channel;

        private String notificationPurpose;

        private String stages;

        private String eventTemplateID;

        private String recipientMobileNumber;

        private String recipientEmailAddress;

        private String sendersEmailAddress;

        private String subject;

        private String content;

        private Long attachments;

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

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionID(String entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder eventStatus(String eventStatus) {
            this.eventStatus = eventStatus;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder notificationPurpose(String notificationPurpose) {
            this.notificationPurpose = notificationPurpose;
            return this;
        }

        public Builder stages(String stages) {
            this.stages = stages;
            return this;
        }

        public Builder eventTemplateID(String eventTemplateID) {
            this.eventTemplateID = eventTemplateID;
            return this;
        }

        public Builder recipientMobileNumber(String recipientMobileNumber) {
            this.recipientMobileNumber = recipientMobileNumber;
            return this;
        }

        public Builder recipientEmailAddress(String recipientEmailAddress) {
            this.recipientEmailAddress = recipientEmailAddress;
            return this;
        }

        public Builder sendersEmailAddress(String sendersEmailAddress) {
            this.sendersEmailAddress = sendersEmailAddress;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder attachments(Long attachments) {
            this.attachments = attachments;
            return this;
        }

        public FgEventNotification build() {
            return new FgEventNotification(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, entityRefID, entityVersionID, entityTypeCode, entitySubTypeCode, eventType, eventStatus, channel, notificationPurpose, stages, eventTemplateID, recipientMobileNumber, recipientEmailAddress, sendersEmailAddress, subject, content, attachments);
        }
    }
}
