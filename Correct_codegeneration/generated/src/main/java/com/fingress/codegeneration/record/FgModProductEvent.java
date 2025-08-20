package com.bsit.codegeneration.record;

public record FgModProductEvent(Long ID, Long versionID, Long isMasterVersion, String referenceID, String parentRefID, Long parentVersionID, String typeCode, String subTypeCode, String eventCode, String eventStageCode, Long eventFormID, String eventBoRefNo, String eventBoCode, String entityRefID, Long entityVersionNo, String entityTypeCode, String entitySubTypeCode, String entityBoRefNo, String entityBoCode, String template, String stageCode, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String processID, String eventStatusCode, String eventTypeCode, String eventSubTypeCode) {

    public static class Builder {

        private Long ID;

        private Long versionID;

        private Long isMasterVersion;

        private String referenceID;

        private String parentRefID;

        private Long parentVersionID;

        private String typeCode;

        private String subTypeCode;

        private String eventCode;

        private String eventStageCode;

        private Long eventFormID;

        private String eventBoRefNo;

        private String eventBoCode;

        private String entityRefID;

        private Long entityVersionNo;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String entityBoRefNo;

        private String entityBoCode;

        private String template;

        private String stageCode;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String processID;

        private String eventStatusCode;

        private String eventTypeCode;

        private String eventSubTypeCode;

        public Builder ID(Long ID) {
            this.ID = ID;
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

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
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

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder eventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder eventStageCode(String eventStageCode) {
            this.eventStageCode = eventStageCode;
            return this;
        }

        public Builder eventFormID(Long eventFormID) {
            this.eventFormID = eventFormID;
            return this;
        }

        public Builder eventBoRefNo(String eventBoRefNo) {
            this.eventBoRefNo = eventBoRefNo;
            return this;
        }

        public Builder eventBoCode(String eventBoCode) {
            this.eventBoCode = eventBoCode;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionNo(Long entityVersionNo) {
            this.entityVersionNo = entityVersionNo;
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

        public Builder entityBoRefNo(String entityBoRefNo) {
            this.entityBoRefNo = entityBoRefNo;
            return this;
        }

        public Builder entityBoCode(String entityBoCode) {
            this.entityBoCode = entityBoCode;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder eventStatusCode(String eventStatusCode) {
            this.eventStatusCode = eventStatusCode;
            return this;
        }

        public Builder eventTypeCode(String eventTypeCode) {
            this.eventTypeCode = eventTypeCode;
            return this;
        }

        public Builder eventSubTypeCode(String eventSubTypeCode) {
            this.eventSubTypeCode = eventSubTypeCode;
            return this;
        }

        public FgModProductEvent build() {
            return new FgModProductEvent(ID, versionID, isMasterVersion, referenceID, parentRefID, parentVersionID, typeCode, subTypeCode, eventCode, eventStageCode, eventFormID, eventBoRefNo, eventBoCode, entityRefID, entityVersionNo, entityTypeCode, entitySubTypeCode, entityBoRefNo, entityBoCode, template, stageCode, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, processID, eventStatusCode, eventTypeCode, eventSubTypeCode);
        }
    }
}
