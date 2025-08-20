package com.bsit.codegeneration.record;

public record FgTdOtpReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, Long otpCount, Long otpResent, Long otpFailedCount, String otpSentTime, String otpLockedTime, String otpUnlockTime, String userCrn, String entityTypeCode, String mobileMasked, String emailMasked) {

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

        private Long otpCount;

        private Long otpResent;

        private Long otpFailedCount;

        private String otpSentTime;

        private String otpLockedTime;

        private String otpUnlockTime;

        private String userCrn;

        private String entityTypeCode;

        private String mobileMasked;

        private String emailMasked;

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

        public Builder otpCount(Long otpCount) {
            this.otpCount = otpCount;
            return this;
        }

        public Builder otpResent(Long otpResent) {
            this.otpResent = otpResent;
            return this;
        }

        public Builder otpFailedCount(Long otpFailedCount) {
            this.otpFailedCount = otpFailedCount;
            return this;
        }

        public Builder otpSentTime(String otpSentTime) {
            this.otpSentTime = otpSentTime;
            return this;
        }

        public Builder otpLockedTime(String otpLockedTime) {
            this.otpLockedTime = otpLockedTime;
            return this;
        }

        public Builder otpUnlockTime(String otpUnlockTime) {
            this.otpUnlockTime = otpUnlockTime;
            return this;
        }

        public Builder userCrn(String userCrn) {
            this.userCrn = userCrn;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder mobileMasked(String mobileMasked) {
            this.mobileMasked = mobileMasked;
            return this;
        }

        public Builder emailMasked(String emailMasked) {
            this.emailMasked = emailMasked;
            return this;
        }

        public FgTdOtpReq build() {
            return new FgTdOtpReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, otpCount, otpResent, otpFailedCount, otpSentTime, otpLockedTime, otpUnlockTime, userCrn, entityTypeCode, mobileMasked, emailMasked);
        }
    }
}
