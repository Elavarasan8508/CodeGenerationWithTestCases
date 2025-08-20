package com.bsit.codegeneration.record;

public record LosLoanReqEvent(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String eventComments, java.time.LocalDateTime eventDueDate, String eventRespondedOn, String eventCompletedOm, String eventExpiredOn, String uploadRefID, String rejectionReasonCode, String rejectionComments, String eventCategoryCode, String eventTypeCode, String eventOccurredOn, String eventTriggerRole, String actionComments, Long actionRequiredFlag, String actionTypeCode, String actionStatusCode, String actionPerformerRole, String loanRequestReference, String productCode, String subProductCode, String segmentCode, Long versionID, Long isMasterVersion, String eventSubject, String productStatusCode, String acceptanceParty) {

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

        private String eventComments;

        private java.time.LocalDateTime eventDueDate;

        private String eventRespondedOn;

        private String eventCompletedOm;

        private String eventExpiredOn;

        private String uploadRefID;

        private String rejectionReasonCode;

        private String rejectionComments;

        private String eventCategoryCode;

        private String eventTypeCode;

        private String eventOccurredOn;

        private String eventTriggerRole;

        private String actionComments;

        private Long actionRequiredFlag;

        private String actionTypeCode;

        private String actionStatusCode;

        private String actionPerformerRole;

        private String loanRequestReference;

        private String productCode;

        private String subProductCode;

        private String segmentCode;

        private Long versionID;

        private Long isMasterVersion;

        private String eventSubject;

        private String productStatusCode;

        private String acceptanceParty;

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

        public Builder eventComments(String eventComments) {
            this.eventComments = eventComments;
            return this;
        }

        public Builder eventDueDate(java.time.LocalDateTime eventDueDate) {
            this.eventDueDate = eventDueDate;
            return this;
        }

        public Builder eventRespondedOn(String eventRespondedOn) {
            this.eventRespondedOn = eventRespondedOn;
            return this;
        }

        public Builder eventCompletedOm(String eventCompletedOm) {
            this.eventCompletedOm = eventCompletedOm;
            return this;
        }

        public Builder eventExpiredOn(String eventExpiredOn) {
            this.eventExpiredOn = eventExpiredOn;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder rejectionReasonCode(String rejectionReasonCode) {
            this.rejectionReasonCode = rejectionReasonCode;
            return this;
        }

        public Builder rejectionComments(String rejectionComments) {
            this.rejectionComments = rejectionComments;
            return this;
        }

        public Builder eventCategoryCode(String eventCategoryCode) {
            this.eventCategoryCode = eventCategoryCode;
            return this;
        }

        public Builder eventTypeCode(String eventTypeCode) {
            this.eventTypeCode = eventTypeCode;
            return this;
        }

        public Builder eventOccurredOn(String eventOccurredOn) {
            this.eventOccurredOn = eventOccurredOn;
            return this;
        }

        public Builder eventTriggerRole(String eventTriggerRole) {
            this.eventTriggerRole = eventTriggerRole;
            return this;
        }

        public Builder actionComments(String actionComments) {
            this.actionComments = actionComments;
            return this;
        }

        public Builder actionRequiredFlag(Long actionRequiredFlag) {
            this.actionRequiredFlag = actionRequiredFlag;
            return this;
        }

        public Builder actionTypeCode(String actionTypeCode) {
            this.actionTypeCode = actionTypeCode;
            return this;
        }

        public Builder actionStatusCode(String actionStatusCode) {
            this.actionStatusCode = actionStatusCode;
            return this;
        }

        public Builder actionPerformerRole(String actionPerformerRole) {
            this.actionPerformerRole = actionPerformerRole;
            return this;
        }

        public Builder loanRequestReference(String loanRequestReference) {
            this.loanRequestReference = loanRequestReference;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
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

        public Builder eventSubject(String eventSubject) {
            this.eventSubject = eventSubject;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public Builder acceptanceParty(String acceptanceParty) {
            this.acceptanceParty = acceptanceParty;
            return this;
        }

        public LosLoanReqEvent build() {
            return new LosLoanReqEvent(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, eventComments, eventDueDate, eventRespondedOn, eventCompletedOm, eventExpiredOn, uploadRefID, rejectionReasonCode, rejectionComments, eventCategoryCode, eventTypeCode, eventOccurredOn, eventTriggerRole, actionComments, actionRequiredFlag, actionTypeCode, actionStatusCode, actionPerformerRole, loanRequestReference, productCode, subProductCode, segmentCode, versionID, isMasterVersion, eventSubject, productStatusCode, acceptanceParty);
        }
    }
}
