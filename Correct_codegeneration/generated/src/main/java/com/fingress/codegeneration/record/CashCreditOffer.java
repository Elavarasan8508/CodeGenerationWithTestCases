package com.bsit.codegeneration.record;

public record CashCreditOffer(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, String uploadRefID, String attachmentID, String parentID, String parentRefID, Long parentVersionID, Long isTemplate, String offerID, String name, String description, String offerTypeCode, java.time.LocalDateTime offerStartDate, java.time.LocalDateTime offerEndDate, String interestTypeCode, Long rateOfInterest, String benchmarkCode, String resetFrequencyPeriodCode, String tenorUom, Long tenorMin, Long tenorMax, String processingModeCode, Long offerSpreadPercentage, Long ftpCode, Long versionID, Long isMasterVersion, String productCode, String subProductCode, String segmentCode) {

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

        private String offerID;

        private String name;

        private String description;

        private String offerTypeCode;

        private java.time.LocalDateTime offerStartDate;

        private java.time.LocalDateTime offerEndDate;

        private String interestTypeCode;

        private Long rateOfInterest;

        private String benchmarkCode;

        private String resetFrequencyPeriodCode;

        private String tenorUom;

        private Long tenorMin;

        private Long tenorMax;

        private String processingModeCode;

        private Long offerSpreadPercentage;

        private Long ftpCode;

        private Long versionID;

        private Long isMasterVersion;

        private String productCode;

        private String subProductCode;

        private String segmentCode;

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

        public Builder offerID(String offerID) {
            this.offerID = offerID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder offerTypeCode(String offerTypeCode) {
            this.offerTypeCode = offerTypeCode;
            return this;
        }

        public Builder offerStartDate(java.time.LocalDateTime offerStartDate) {
            this.offerStartDate = offerStartDate;
            return this;
        }

        public Builder offerEndDate(java.time.LocalDateTime offerEndDate) {
            this.offerEndDate = offerEndDate;
            return this;
        }

        public Builder interestTypeCode(String interestTypeCode) {
            this.interestTypeCode = interestTypeCode;
            return this;
        }

        public Builder rateOfInterest(Long rateOfInterest) {
            this.rateOfInterest = rateOfInterest;
            return this;
        }

        public Builder benchmarkCode(String benchmarkCode) {
            this.benchmarkCode = benchmarkCode;
            return this;
        }

        public Builder resetFrequencyPeriodCode(String resetFrequencyPeriodCode) {
            this.resetFrequencyPeriodCode = resetFrequencyPeriodCode;
            return this;
        }

        public Builder tenorUom(String tenorUom) {
            this.tenorUom = tenorUom;
            return this;
        }

        public Builder tenorMin(Long tenorMin) {
            this.tenorMin = tenorMin;
            return this;
        }

        public Builder tenorMax(Long tenorMax) {
            this.tenorMax = tenorMax;
            return this;
        }

        public Builder processingModeCode(String processingModeCode) {
            this.processingModeCode = processingModeCode;
            return this;
        }

        public Builder offerSpreadPercentage(Long offerSpreadPercentage) {
            this.offerSpreadPercentage = offerSpreadPercentage;
            return this;
        }

        public Builder ftpCode(Long ftpCode) {
            this.ftpCode = ftpCode;
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

        public CashCreditOffer build() {
            return new CashCreditOffer(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, uploadRefID, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, offerID, name, description, offerTypeCode, offerStartDate, offerEndDate, interestTypeCode, rateOfInterest, benchmarkCode, resetFrequencyPeriodCode, tenorUom, tenorMin, tenorMax, processingModeCode, offerSpreadPercentage, ftpCode, versionID, isMasterVersion, productCode, subProductCode, segmentCode);
        }
    }
}
