package com.bsit.codegeneration.record;

public record FgMfaToken(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, String uploadRefID, String attachmentID, String parentID, String parentRefID, Long parentVersionID, Long isTemplate, String uuid, String orgCode, String userCode, String eventTypeCode, String entityTypeCode, String entityTypeReference, String channel, String primary, String secondary, String factorStage, String failureReason, String content, String primaryTriggeredOn, String primaryExpireOn, String secondaryTriggeredOn, String secondaryExpireOn, String lockedOn, String releaseOn, Long attemptCount, Long isLocked, String authenticationCode, String deliveryChannel) {

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

        private String uploadRefID;

        private String attachmentID;

        private String parentID;

        private String parentRefID;

        private Long parentVersionID;

        private Long isTemplate;

        private String uuid;

        private String orgCode;

        private String userCode;

        private String eventTypeCode;

        private String entityTypeCode;

        private String entityTypeReference;

        private String channel;

        private String primary;

        private String secondary;

        private String factorStage;

        private String failureReason;

        private String content;

        private String primaryTriggeredOn;

        private String primaryExpireOn;

        private String secondaryTriggeredOn;

        private String secondaryExpireOn;

        private String lockedOn;

        private String releaseOn;

        private Long attemptCount;

        private Long isLocked;

        private String authenticationCode;

        private String deliveryChannel;

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

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder attachmentID(String attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public Builder parentID(String parentID) {
            this.parentID = parentID;
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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder eventTypeCode(String eventTypeCode) {
            this.eventTypeCode = eventTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entityTypeReference(String entityTypeReference) {
            this.entityTypeReference = entityTypeReference;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder primary(String primary) {
            this.primary = primary;
            return this;
        }

        public Builder secondary(String secondary) {
            this.secondary = secondary;
            return this;
        }

        public Builder factorStage(String factorStage) {
            this.factorStage = factorStage;
            return this;
        }

        public Builder failureReason(String failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder primaryTriggeredOn(String primaryTriggeredOn) {
            this.primaryTriggeredOn = primaryTriggeredOn;
            return this;
        }

        public Builder primaryExpireOn(String primaryExpireOn) {
            this.primaryExpireOn = primaryExpireOn;
            return this;
        }

        public Builder secondaryTriggeredOn(String secondaryTriggeredOn) {
            this.secondaryTriggeredOn = secondaryTriggeredOn;
            return this;
        }

        public Builder secondaryExpireOn(String secondaryExpireOn) {
            this.secondaryExpireOn = secondaryExpireOn;
            return this;
        }

        public Builder lockedOn(String lockedOn) {
            this.lockedOn = lockedOn;
            return this;
        }

        public Builder releaseOn(String releaseOn) {
            this.releaseOn = releaseOn;
            return this;
        }

        public Builder attemptCount(Long attemptCount) {
            this.attemptCount = attemptCount;
            return this;
        }

        public Builder isLocked(Long isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Builder authenticationCode(String authenticationCode) {
            this.authenticationCode = authenticationCode;
            return this;
        }

        public Builder deliveryChannel(String deliveryChannel) {
            this.deliveryChannel = deliveryChannel;
            return this;
        }

        public FgMfaToken build() {
            return new FgMfaToken(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, uploadRefID, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, uuid, orgCode, userCode, eventTypeCode, entityTypeCode, entityTypeReference, channel, primary, secondary, factorStage, failureReason, content, primaryTriggeredOn, primaryExpireOn, secondaryTriggeredOn, secondaryExpireOn, lockedOn, releaseOn, attemptCount, isLocked, authenticationCode, deliveryChannel);
        }
    }
}
