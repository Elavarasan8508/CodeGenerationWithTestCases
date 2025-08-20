package com.bsit.codegeneration.record;

public record FgLmsAssetSchemes(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, java.time.LocalDateTime effectiveDate, java.time.LocalDateTime expiryDate, String assetSchemeCode, String assetSchemeName, String assetClassificationBasedOn, String forwardMovement, String backwardMovement, Long pastDueDaysFrom, Long pastDueDaysTo, String delinquencyStageName, String delinquencyStageCode, String stopAccrual, String derecognizeIncome, Long provision, Long erosionFrom, Long erosionTo, String isIncomeDerecognized, String schemeName, String schemeDescription, String productCode, String productDescription, String product, Long versionID, Long isMasterVersion, java.time.LocalDateTime effectiveDateCharge, java.time.LocalDateTime expiryDateCharge) {

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

        private java.time.LocalDateTime effectiveDate;

        private java.time.LocalDateTime expiryDate;

        private String assetSchemeCode;

        private String assetSchemeName;

        private String assetClassificationBasedOn;

        private String forwardMovement;

        private String backwardMovement;

        private Long pastDueDaysFrom;

        private Long pastDueDaysTo;

        private String delinquencyStageName;

        private String delinquencyStageCode;

        private String stopAccrual;

        private String derecognizeIncome;

        private Long provision;

        private Long erosionFrom;

        private Long erosionTo;

        private String isIncomeDerecognized;

        private String schemeName;

        private String schemeDescription;

        private String productCode;

        private String productDescription;

        private String product;

        private Long versionID;

        private Long isMasterVersion;

        private java.time.LocalDateTime effectiveDateCharge;

        private java.time.LocalDateTime expiryDateCharge;

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

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder expiryDate(java.time.LocalDateTime expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder assetSchemeCode(String assetSchemeCode) {
            this.assetSchemeCode = assetSchemeCode;
            return this;
        }

        public Builder assetSchemeName(String assetSchemeName) {
            this.assetSchemeName = assetSchemeName;
            return this;
        }

        public Builder assetClassificationBasedOn(String assetClassificationBasedOn) {
            this.assetClassificationBasedOn = assetClassificationBasedOn;
            return this;
        }

        public Builder forwardMovement(String forwardMovement) {
            this.forwardMovement = forwardMovement;
            return this;
        }

        public Builder backwardMovement(String backwardMovement) {
            this.backwardMovement = backwardMovement;
            return this;
        }

        public Builder pastDueDaysFrom(Long pastDueDaysFrom) {
            this.pastDueDaysFrom = pastDueDaysFrom;
            return this;
        }

        public Builder pastDueDaysTo(Long pastDueDaysTo) {
            this.pastDueDaysTo = pastDueDaysTo;
            return this;
        }

        public Builder delinquencyStageName(String delinquencyStageName) {
            this.delinquencyStageName = delinquencyStageName;
            return this;
        }

        public Builder delinquencyStageCode(String delinquencyStageCode) {
            this.delinquencyStageCode = delinquencyStageCode;
            return this;
        }

        public Builder stopAccrual(String stopAccrual) {
            this.stopAccrual = stopAccrual;
            return this;
        }

        public Builder derecognizeIncome(String derecognizeIncome) {
            this.derecognizeIncome = derecognizeIncome;
            return this;
        }

        public Builder provision(Long provision) {
            this.provision = provision;
            return this;
        }

        public Builder erosionFrom(Long erosionFrom) {
            this.erosionFrom = erosionFrom;
            return this;
        }

        public Builder erosionTo(Long erosionTo) {
            this.erosionTo = erosionTo;
            return this;
        }

        public Builder isIncomeDerecognized(String isIncomeDerecognized) {
            this.isIncomeDerecognized = isIncomeDerecognized;
            return this;
        }

        public Builder schemeName(String schemeName) {
            this.schemeName = schemeName;
            return this;
        }

        public Builder schemeDescription(String schemeDescription) {
            this.schemeDescription = schemeDescription;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder product(String product) {
            this.product = product;
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

        public Builder effectiveDateCharge(java.time.LocalDateTime effectiveDateCharge) {
            this.effectiveDateCharge = effectiveDateCharge;
            return this;
        }

        public Builder expiryDateCharge(java.time.LocalDateTime expiryDateCharge) {
            this.expiryDateCharge = expiryDateCharge;
            return this;
        }

        public FgLmsAssetSchemes build() {
            return new FgLmsAssetSchemes(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, effectiveDate, expiryDate, assetSchemeCode, assetSchemeName, assetClassificationBasedOn, forwardMovement, backwardMovement, pastDueDaysFrom, pastDueDaysTo, delinquencyStageName, delinquencyStageCode, stopAccrual, derecognizeIncome, provision, erosionFrom, erosionTo, isIncomeDerecognized, schemeName, schemeDescription, productCode, productDescription, product, versionID, isMasterVersion, effectiveDateCharge, expiryDateCharge);
        }
    }
}
