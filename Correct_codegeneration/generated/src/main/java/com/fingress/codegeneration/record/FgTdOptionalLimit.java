package com.bsit.codegeneration.record;

public record FgTdOptionalLimit(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String schemeCode, Long tenorStartDays, Long tenorEndDays, Long tenorMinAmount, Long tenorMaxAmount, java.time.LocalDateTime valueDate, String parentRefID, String parentVersionID, Long versionID, Long isMasterVersion, String taskReason, java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, String origin) {

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

        private Long isTemplate;

        private String schemeCode;

        private Long tenorStartDays;

        private Long tenorEndDays;

        private Long tenorMinAmount;

        private Long tenorMaxAmount;

        private java.time.LocalDateTime valueDate;

        private String parentRefID;

        private String parentVersionID;

        private Long versionID;

        private Long isMasterVersion;

        private String taskReason;

        private java.time.LocalDateTime startDate;

        private java.time.LocalDateTime endDate;

        private String origin;

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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder tenorStartDays(Long tenorStartDays) {
            this.tenorStartDays = tenorStartDays;
            return this;
        }

        public Builder tenorEndDays(Long tenorEndDays) {
            this.tenorEndDays = tenorEndDays;
            return this;
        }

        public Builder tenorMinAmount(Long tenorMinAmount) {
            this.tenorMinAmount = tenorMinAmount;
            return this;
        }

        public Builder tenorMaxAmount(Long tenorMaxAmount) {
            this.tenorMaxAmount = tenorMaxAmount;
            return this;
        }

        public Builder valueDate(java.time.LocalDateTime valueDate) {
            this.valueDate = valueDate;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(String parentVersionID) {
            this.parentVersionID = parentVersionID;
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

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public FgTdOptionalLimit build() {
            return new FgTdOptionalLimit(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, schemeCode, tenorStartDays, tenorEndDays, tenorMinAmount, tenorMaxAmount, valueDate, parentRefID, parentVersionID, versionID, isMasterVersion, taskReason, startDate, endDate, origin);
        }
    }
}
