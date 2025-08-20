package com.bsit.codegeneration.record;

public record FgOnlineImport(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Long finalInvAmount, String finalInvNo, java.time.LocalDateTime finalInvDate, String customsInvNo, java.time.LocalDateTime customsInvDate, String shippingBillNo, java.time.LocalDateTime shippingBillDate, String portCode, String portLoad, Long declaredDeducted, java.time.LocalDateTime billDueDate, String iecCode, String invoiceCurrency, String exportCountrySap, Long invQuantity, Long invoiceValue, String customerDescription, String countrySoldToPart, String countryCodeSoldTo, String bLAwbNo, java.time.LocalDateTime billOfLandingAwb, String materialNo, String productDescription, String uploadRefID, Long lineNo, String hsCode, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {

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

        private Long finalInvAmount;

        private String finalInvNo;

        private java.time.LocalDateTime finalInvDate;

        private String customsInvNo;

        private java.time.LocalDateTime customsInvDate;

        private String shippingBillNo;

        private java.time.LocalDateTime shippingBillDate;

        private String portCode;

        private String portLoad;

        private Long declaredDeducted;

        private java.time.LocalDateTime billDueDate;

        private String iecCode;

        private String invoiceCurrency;

        private String exportCountrySap;

        private Long invQuantity;

        private Long invoiceValue;

        private String customerDescription;

        private String countrySoldToPart;

        private String countryCodeSoldTo;

        private String bLAwbNo;

        private java.time.LocalDateTime billOfLandingAwb;

        private String materialNo;

        private String productDescription;

        private String uploadRefID;

        private Long lineNo;

        private String hsCode;

        private Long equivalentAmount;

        private String equivalentCurrency;

        private Long displayAmount;

        private String displayCurrency;

        private Long authEquivalentAmount;

        private String authEquivalentCurrency;

        private Long displayEquivalentAmount;

        private String displayEquivalentCurrency;

        private Long authFxBaseRate;

        private Long displayFxBaseRate;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private String fileName;

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

        public Builder finalInvAmount(Long finalInvAmount) {
            this.finalInvAmount = finalInvAmount;
            return this;
        }

        public Builder finalInvNo(String finalInvNo) {
            this.finalInvNo = finalInvNo;
            return this;
        }

        public Builder finalInvDate(java.time.LocalDateTime finalInvDate) {
            this.finalInvDate = finalInvDate;
            return this;
        }

        public Builder customsInvNo(String customsInvNo) {
            this.customsInvNo = customsInvNo;
            return this;
        }

        public Builder customsInvDate(java.time.LocalDateTime customsInvDate) {
            this.customsInvDate = customsInvDate;
            return this;
        }

        public Builder shippingBillNo(String shippingBillNo) {
            this.shippingBillNo = shippingBillNo;
            return this;
        }

        public Builder shippingBillDate(java.time.LocalDateTime shippingBillDate) {
            this.shippingBillDate = shippingBillDate;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder portLoad(String portLoad) {
            this.portLoad = portLoad;
            return this;
        }

        public Builder declaredDeducted(Long declaredDeducted) {
            this.declaredDeducted = declaredDeducted;
            return this;
        }

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            this.billDueDate = billDueDate;
            return this;
        }

        public Builder iecCode(String iecCode) {
            this.iecCode = iecCode;
            return this;
        }

        public Builder invoiceCurrency(String invoiceCurrency) {
            this.invoiceCurrency = invoiceCurrency;
            return this;
        }

        public Builder exportCountrySap(String exportCountrySap) {
            this.exportCountrySap = exportCountrySap;
            return this;
        }

        public Builder invQuantity(Long invQuantity) {
            this.invQuantity = invQuantity;
            return this;
        }

        public Builder invoiceValue(Long invoiceValue) {
            this.invoiceValue = invoiceValue;
            return this;
        }

        public Builder customerDescription(String customerDescription) {
            this.customerDescription = customerDescription;
            return this;
        }

        public Builder countrySoldToPart(String countrySoldToPart) {
            this.countrySoldToPart = countrySoldToPart;
            return this;
        }

        public Builder countryCodeSoldTo(String countryCodeSoldTo) {
            this.countryCodeSoldTo = countryCodeSoldTo;
            return this;
        }

        public Builder bLAwbNo(String bLAwbNo) {
            this.bLAwbNo = bLAwbNo;
            return this;
        }

        public Builder billOfLandingAwb(java.time.LocalDateTime billOfLandingAwb) {
            this.billOfLandingAwb = billOfLandingAwb;
            return this;
        }

        public Builder materialNo(String materialNo) {
            this.materialNo = materialNo;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public Builder equivalentAmount(Long equivalentAmount) {
            this.equivalentAmount = equivalentAmount;
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            this.equivalentCurrency = equivalentCurrency;
            return this;
        }

        public Builder displayAmount(Long displayAmount) {
            this.displayAmount = displayAmount;
            return this;
        }

        public Builder displayCurrency(String displayCurrency) {
            this.displayCurrency = displayCurrency;
            return this;
        }

        public Builder authEquivalentAmount(Long authEquivalentAmount) {
            this.authEquivalentAmount = authEquivalentAmount;
            return this;
        }

        public Builder authEquivalentCurrency(String authEquivalentCurrency) {
            this.authEquivalentCurrency = authEquivalentCurrency;
            return this;
        }

        public Builder displayEquivalentAmount(Long displayEquivalentAmount) {
            this.displayEquivalentAmount = displayEquivalentAmount;
            return this;
        }

        public Builder displayEquivalentCurrency(String displayEquivalentCurrency) {
            this.displayEquivalentCurrency = displayEquivalentCurrency;
            return this;
        }

        public Builder authFxBaseRate(Long authFxBaseRate) {
            this.authFxBaseRate = authFxBaseRate;
            return this;
        }

        public Builder displayFxBaseRate(Long displayFxBaseRate) {
            this.displayFxBaseRate = displayFxBaseRate;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public FgOnlineImport build() {
            return new FgOnlineImport(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, finalInvAmount, finalInvNo, finalInvDate, customsInvNo, customsInvDate, shippingBillNo, shippingBillDate, portCode, portLoad, declaredDeducted, billDueDate, iecCode, invoiceCurrency, exportCountrySap, invQuantity, invoiceValue, customerDescription, countrySoldToPart, countryCodeSoldTo, bLAwbNo, billOfLandingAwb, materialNo, productDescription, uploadRefID, lineNo, hsCode, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, fileName);
        }
    }
}
