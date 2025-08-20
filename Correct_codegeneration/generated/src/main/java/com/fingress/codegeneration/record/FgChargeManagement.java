package com.bsit.codegeneration.record;

public record FgChargeManagement(Long ID, String referenceID, Long versionID, String partyCode, String partySubTypeCode, String productCode, String eventCode, String categoryCode, String chargeTypeCode, String chargeStatusCode, String chargeCode, String currencyCode, String taxCode, String chargeBasisCode, Long isRecurring, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, Long chargeAmount, String uomCode, Long limitAmount, Long freeLimit, String limitPeriodCode, Long chargePercentage, String statusCode, String activeCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template) {

    public static class Builder {

        private Long ID;

        private String referenceID;

        private Long versionID;

        private String partyCode;

        private String partySubTypeCode;

        private String productCode;

        private String eventCode;

        private String categoryCode;

        private String chargeTypeCode;

        private String chargeStatusCode;

        private String chargeCode;

        private String currencyCode;

        private String taxCode;

        private String chargeBasisCode;

        private Long isRecurring;

        private java.time.LocalDateTime validFrom;

        private java.time.LocalDateTime validTo;

        private Long chargeAmount;

        private String uomCode;

        private Long limitAmount;

        private Long freeLimit;

        private String limitPeriodCode;

        private Long chargePercentage;

        private String statusCode;

        private String activeCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder eventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder chargeTypeCode(String chargeTypeCode) {
            this.chargeTypeCode = chargeTypeCode;
            return this;
        }

        public Builder chargeStatusCode(String chargeStatusCode) {
            this.chargeStatusCode = chargeStatusCode;
            return this;
        }

        public Builder chargeCode(String chargeCode) {
            this.chargeCode = chargeCode;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder taxCode(String taxCode) {
            this.taxCode = taxCode;
            return this;
        }

        public Builder chargeBasisCode(String chargeBasisCode) {
            this.chargeBasisCode = chargeBasisCode;
            return this;
        }

        public Builder isRecurring(Long isRecurring) {
            this.isRecurring = isRecurring;
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            this.validFrom = validFrom;
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            this.validTo = validTo;
            return this;
        }

        public Builder chargeAmount(Long chargeAmount) {
            this.chargeAmount = chargeAmount;
            return this;
        }

        public Builder uomCode(String uomCode) {
            this.uomCode = uomCode;
            return this;
        }

        public Builder limitAmount(Long limitAmount) {
            this.limitAmount = limitAmount;
            return this;
        }

        public Builder freeLimit(Long freeLimit) {
            this.freeLimit = freeLimit;
            return this;
        }

        public Builder limitPeriodCode(String limitPeriodCode) {
            this.limitPeriodCode = limitPeriodCode;
            return this;
        }

        public Builder chargePercentage(Long chargePercentage) {
            this.chargePercentage = chargePercentage;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
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

        public FgChargeManagement build() {
            return new FgChargeManagement(ID, referenceID, versionID, partyCode, partySubTypeCode, productCode, eventCode, categoryCode, chargeTypeCode, chargeStatusCode, chargeCode, currencyCode, taxCode, chargeBasisCode, isRecurring, validFrom, validTo, chargeAmount, uomCode, limitAmount, freeLimit, limitPeriodCode, chargePercentage, statusCode, activeCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template);
        }
    }
}
