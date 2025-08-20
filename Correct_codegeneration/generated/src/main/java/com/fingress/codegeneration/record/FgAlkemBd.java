package com.bsit.codegeneration.record;

public record FgAlkemBd(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String invoiceCurrency, String exportCountrySap, String customerDescription, String countrySoldToPart, String countryCodeSoldTo, String bLAwbNo, java.time.LocalDateTime billOfLandingAwb, String materialNo, String productDescription, String finalInvNo, java.time.LocalDateTime finalInvDate, String customsInvNo, java.time.LocalDateTime customsInvDate, String shippingBillNo, java.time.LocalDateTime shippingBillDate, String portCode, String portLoad, java.time.LocalDateTime billDueDate, String uploadRefID, String iecCode, Long finalInvAmount, Long invoiceValue, Long invoiceQuantity, Long declaredDeducted, Long lineNo, String hsCode, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName, String bankRefNo, java.time.LocalDateTime baseDate, Long billAmount, String billCcy, String buyerCountry1, String buyerCountry2, String buyerID, String buyerName, String chargesDbtAccNo, String collectingBank, String customerCrn, String destPortCode, String goodsCode, String goodsDesc, String hsnCode, String incoterms, java.time.LocalDateTime invDate, String invNo, String pordCodeForLoading, Long shippingBillAmount, String shippingBillCcy, String softexNumber, Long tenorInDays, String thirdParty, String thirdPartyAdd, String thirdPartyCountry, String thirdPartyName, String vesselOFlightName) {

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

        private String invoiceCurrency;

        private String exportCountrySap;

        private String customerDescription;

        private String countrySoldToPart;

        private String countryCodeSoldTo;

        private String bLAwbNo;

        private java.time.LocalDateTime billOfLandingAwb;

        private String materialNo;

        private String productDescription;

        private String finalInvNo;

        private java.time.LocalDateTime finalInvDate;

        private String customsInvNo;

        private java.time.LocalDateTime customsInvDate;

        private String shippingBillNo;

        private java.time.LocalDateTime shippingBillDate;

        private String portCode;

        private String portLoad;

        private java.time.LocalDateTime billDueDate;

        private String uploadRefID;

        private String iecCode;

        private Long finalInvAmount;

        private Long invoiceValue;

        private Long invoiceQuantity;

        private Long declaredDeducted;

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

        private String bankRefNo;

        private java.time.LocalDateTime baseDate;

        private Long billAmount;

        private String billCcy;

        private String buyerCountry1;

        private String buyerCountry2;

        private String buyerID;

        private String buyerName;

        private String chargesDbtAccNo;

        private String collectingBank;

        private String customerCrn;

        private String destPortCode;

        private String goodsCode;

        private String goodsDesc;

        private String hsnCode;

        private String incoterms;

        private java.time.LocalDateTime invDate;

        private String invNo;

        private String pordCodeForLoading;

        private Long shippingBillAmount;

        private String shippingBillCcy;

        private String softexNumber;

        private Long tenorInDays;

        private String thirdParty;

        private String thirdPartyAdd;

        private String thirdPartyCountry;

        private String thirdPartyName;

        private String vesselOFlightName;

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

        public Builder invoiceCurrency(String invoiceCurrency) {
            this.invoiceCurrency = invoiceCurrency;
            return this;
        }

        public Builder exportCountrySap(String exportCountrySap) {
            this.exportCountrySap = exportCountrySap;
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

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            this.billDueDate = billDueDate;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder iecCode(String iecCode) {
            this.iecCode = iecCode;
            return this;
        }

        public Builder finalInvAmount(Long finalInvAmount) {
            this.finalInvAmount = finalInvAmount;
            return this;
        }

        public Builder invoiceValue(Long invoiceValue) {
            this.invoiceValue = invoiceValue;
            return this;
        }

        public Builder invoiceQuantity(Long invoiceQuantity) {
            this.invoiceQuantity = invoiceQuantity;
            return this;
        }

        public Builder declaredDeducted(Long declaredDeducted) {
            this.declaredDeducted = declaredDeducted;
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

        public Builder bankRefNo(String bankRefNo) {
            this.bankRefNo = bankRefNo;
            return this;
        }

        public Builder baseDate(java.time.LocalDateTime baseDate) {
            this.baseDate = baseDate;
            return this;
        }

        public Builder billAmount(Long billAmount) {
            this.billAmount = billAmount;
            return this;
        }

        public Builder billCcy(String billCcy) {
            this.billCcy = billCcy;
            return this;
        }

        public Builder buyerCountry1(String buyerCountry1) {
            this.buyerCountry1 = buyerCountry1;
            return this;
        }

        public Builder buyerCountry2(String buyerCountry2) {
            this.buyerCountry2 = buyerCountry2;
            return this;
        }

        public Builder buyerID(String buyerID) {
            this.buyerID = buyerID;
            return this;
        }

        public Builder buyerName(String buyerName) {
            this.buyerName = buyerName;
            return this;
        }

        public Builder chargesDbtAccNo(String chargesDbtAccNo) {
            this.chargesDbtAccNo = chargesDbtAccNo;
            return this;
        }

        public Builder collectingBank(String collectingBank) {
            this.collectingBank = collectingBank;
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder destPortCode(String destPortCode) {
            this.destPortCode = destPortCode;
            return this;
        }

        public Builder goodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
            return this;
        }

        public Builder goodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
            return this;
        }

        public Builder hsnCode(String hsnCode) {
            this.hsnCode = hsnCode;
            return this;
        }

        public Builder incoterms(String incoterms) {
            this.incoterms = incoterms;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder pordCodeForLoading(String pordCodeForLoading) {
            this.pordCodeForLoading = pordCodeForLoading;
            return this;
        }

        public Builder shippingBillAmount(Long shippingBillAmount) {
            this.shippingBillAmount = shippingBillAmount;
            return this;
        }

        public Builder shippingBillCcy(String shippingBillCcy) {
            this.shippingBillCcy = shippingBillCcy;
            return this;
        }

        public Builder softexNumber(String softexNumber) {
            this.softexNumber = softexNumber;
            return this;
        }

        public Builder tenorInDays(Long tenorInDays) {
            this.tenorInDays = tenorInDays;
            return this;
        }

        public Builder thirdParty(String thirdParty) {
            this.thirdParty = thirdParty;
            return this;
        }

        public Builder thirdPartyAdd(String thirdPartyAdd) {
            this.thirdPartyAdd = thirdPartyAdd;
            return this;
        }

        public Builder thirdPartyCountry(String thirdPartyCountry) {
            this.thirdPartyCountry = thirdPartyCountry;
            return this;
        }

        public Builder thirdPartyName(String thirdPartyName) {
            this.thirdPartyName = thirdPartyName;
            return this;
        }

        public Builder vesselOFlightName(String vesselOFlightName) {
            this.vesselOFlightName = vesselOFlightName;
            return this;
        }

        public FgAlkemBd build() {
            return new FgAlkemBd(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, invoiceCurrency, exportCountrySap, customerDescription, countrySoldToPart, countryCodeSoldTo, bLAwbNo, billOfLandingAwb, materialNo, productDescription, finalInvNo, finalInvDate, customsInvNo, customsInvDate, shippingBillNo, shippingBillDate, portCode, portLoad, billDueDate, uploadRefID, iecCode, finalInvAmount, invoiceValue, invoiceQuantity, declaredDeducted, lineNo, hsCode, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, fileName, bankRefNo, baseDate, billAmount, billCcy, buyerCountry1, buyerCountry2, buyerID, buyerName, chargesDbtAccNo, collectingBank, customerCrn, destPortCode, goodsCode, goodsDesc, hsnCode, incoterms, invDate, invNo, pordCodeForLoading, shippingBillAmount, shippingBillCcy, softexNumber, tenorInDays, thirdParty, thirdPartyAdd, thirdPartyCountry, thirdPartyName, vesselOFlightName);
        }
    }
}
