package com.bsit.codegeneration.record;

public record FgProductEntityLock(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String userCode, String orgCode, Long entityVersion, Long attemptCount, String actionCode, String lockTime, String expiryTime, String userRole, Long lockCount, String entityTypeCode, String entitySubTypeCode, String entityReferenceID, Long resendAttemptCount) {

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

        private String userCode;

        private String orgCode;

        private Long entityVersion;

        private Long attemptCount;

        private String actionCode;

        private String lockTime;

        private String expiryTime;

        private String userRole;

        private Long lockCount;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String entityReferenceID;

        private Long resendAttemptCount;

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

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder entityVersion(Long entityVersion) {
            this.entityVersion = entityVersion;
            return this;
        }

        public Builder attemptCount(Long attemptCount) {
            this.attemptCount = attemptCount;
            return this;
        }

        public Builder actionCode(String actionCode) {
            this.actionCode = actionCode;
            return this;
        }

        public Builder lockTime(String lockTime) {
            this.lockTime = lockTime;
            return this;
        }

        public Builder expiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }

        public Builder userRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder lockCount(Long lockCount) {
            this.lockCount = lockCount;
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

        public Builder entityReferenceID(String entityReferenceID) {
            this.entityReferenceID = entityReferenceID;
            return this;
        }

        public Builder resendAttemptCount(Long resendAttemptCount) {
            this.resendAttemptCount = resendAttemptCount;
            return this;
        }

        public FgProductEntityLock build() {
            return new FgProductEntityLock(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, userCode, orgCode, entityVersion, attemptCount, actionCode, lockTime, expiryTime, userRole, lockCount, entityTypeCode, entitySubTypeCode, entityReferenceID, resendAttemptCount);
        }
    }
}
