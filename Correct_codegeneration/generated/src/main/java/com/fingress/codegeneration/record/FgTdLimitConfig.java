package com.bsit.codegeneration.record;

public record FgTdLimitConfig(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Long liqMaxLimit, Long minBookLimit, Long maxBookLimit, Long dailyBookingLimit, Long tenorMaxAmount, Long tenorMinDays, Long tenorMaxDays, String schemeCodes, Long aboveAmt, Long belowAmt, Long aStartNumber, String aStartType, Long aEndNumber, String aEndType, Long bStartNumber, String bStartType, Long bEndNumber, String bEndType, Long versionID, Long isMasterVersion, String parentRefID, String parentID, Long parentVersionID, String aboveRange, String belowRange, String taskReason, Long minTenor, Long maxTenor, String minTenorType, String maxTenorType, String origin, String tdType) {

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

        private Long liqMaxLimit;

        private Long minBookLimit;

        private Long maxBookLimit;

        private Long dailyBookingLimit;

        private Long tenorMaxAmount;

        private Long tenorMinDays;

        private Long tenorMaxDays;

        private String schemeCodes;

        private Long aboveAmt;

        private Long belowAmt;

        private Long aStartNumber;

        private String aStartType;

        private Long aEndNumber;

        private String aEndType;

        private Long bStartNumber;

        private String bStartType;

        private Long bEndNumber;

        private String bEndType;

        private Long versionID;

        private Long isMasterVersion;

        private String parentRefID;

        private String parentID;

        private Long parentVersionID;

        private String aboveRange;

        private String belowRange;

        private String taskReason;

        private Long minTenor;

        private Long maxTenor;

        private String minTenorType;

        private String maxTenorType;

        private String origin;

        private String tdType;

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

        public Builder liqMaxLimit(Long liqMaxLimit) {
            this.liqMaxLimit = liqMaxLimit;
            return this;
        }

        public Builder minBookLimit(Long minBookLimit) {
            this.minBookLimit = minBookLimit;
            return this;
        }

        public Builder maxBookLimit(Long maxBookLimit) {
            this.maxBookLimit = maxBookLimit;
            return this;
        }

        public Builder dailyBookingLimit(Long dailyBookingLimit) {
            this.dailyBookingLimit = dailyBookingLimit;
            return this;
        }

        public Builder tenorMaxAmount(Long tenorMaxAmount) {
            this.tenorMaxAmount = tenorMaxAmount;
            return this;
        }

        public Builder tenorMinDays(Long tenorMinDays) {
            this.tenorMinDays = tenorMinDays;
            return this;
        }

        public Builder tenorMaxDays(Long tenorMaxDays) {
            this.tenorMaxDays = tenorMaxDays;
            return this;
        }

        public Builder schemeCodes(String schemeCodes) {
            this.schemeCodes = schemeCodes;
            return this;
        }

        public Builder aboveAmt(Long aboveAmt) {
            this.aboveAmt = aboveAmt;
            return this;
        }

        public Builder belowAmt(Long belowAmt) {
            this.belowAmt = belowAmt;
            return this;
        }

        public Builder aStartNumber(Long aStartNumber) {
            this.aStartNumber = aStartNumber;
            return this;
        }

        public Builder aStartType(String aStartType) {
            this.aStartType = aStartType;
            return this;
        }

        public Builder aEndNumber(Long aEndNumber) {
            this.aEndNumber = aEndNumber;
            return this;
        }

        public Builder aEndType(String aEndType) {
            this.aEndType = aEndType;
            return this;
        }

        public Builder bStartNumber(Long bStartNumber) {
            this.bStartNumber = bStartNumber;
            return this;
        }

        public Builder bStartType(String bStartType) {
            this.bStartType = bStartType;
            return this;
        }

        public Builder bEndNumber(Long bEndNumber) {
            this.bEndNumber = bEndNumber;
            return this;
        }

        public Builder bEndType(String bEndType) {
            this.bEndType = bEndType;
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

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder aboveRange(String aboveRange) {
            this.aboveRange = aboveRange;
            return this;
        }

        public Builder belowRange(String belowRange) {
            this.belowRange = belowRange;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder minTenor(Long minTenor) {
            this.minTenor = minTenor;
            return this;
        }

        public Builder maxTenor(Long maxTenor) {
            this.maxTenor = maxTenor;
            return this;
        }

        public Builder minTenorType(String minTenorType) {
            this.minTenorType = minTenorType;
            return this;
        }

        public Builder maxTenorType(String maxTenorType) {
            this.maxTenorType = maxTenorType;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder tdType(String tdType) {
            this.tdType = tdType;
            return this;
        }

        public FgTdLimitConfig build() {
            return new FgTdLimitConfig(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, liqMaxLimit, minBookLimit, maxBookLimit, dailyBookingLimit, tenorMaxAmount, tenorMinDays, tenorMaxDays, schemeCodes, aboveAmt, belowAmt, aStartNumber, aStartType, aEndNumber, aEndType, bStartNumber, bStartType, bEndNumber, bEndType, versionID, isMasterVersion, parentRefID, parentID, parentVersionID, aboveRange, belowRange, taskReason, minTenor, maxTenor, minTenorType, maxTenorType, origin, tdType);
        }
    }
}
