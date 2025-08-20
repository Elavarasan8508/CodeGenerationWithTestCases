package com.bsit.codegeneration.record;

public record FgChetakImport(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String theirRef, String collectingBank, String behalfOfBranch, String drawer, String draweeCustomerID, String draweeNameAddress, String draweeCountry, String chargeDebitAccNo, Long collectionAmount, String collectionCurrency, String shipmentToCountry, String shipmentFromCountry, String hsCode, String goodsCode, String goodsDescription, String incoterms, String portOfDestination, String portOfLoading, String transportDocNumber, java.time.LocalDateTime transportDocDate, String invoiceNo, java.time.LocalDateTime invoiceDate, String formType, String shippingBillNo, java.time.LocalDateTime billDate, String portCode, String formNo, Long shippingAmount, String shippingCurrency, Long reasonShortShpAmt, Long shortShpAmt, Long repaymentAmount, Long shortCollectionAmt, String remittanceNo, String fircNo, Long remittanceAmt, Long utilizationAmt, String remittanceAdCode, String remitersName, java.time.LocalDateTime remitersDate, String remiterCountry, String cifNo, java.time.LocalDateTime leoDate, String exportAgency, String exportType, String destinationCountry, String ieCode, String adCode, String customsNo, String shippingInvSrNo, String shippingInvNo, java.time.LocalDateTime shippingInvDate, Long fobAmount, Long frightAmount, Long insAmt, Long commissionAmt, Long discountAmt, Long deductionAmt, Long packageAmt, String uploadRefID, Long lineNo, Long equivalentAmount, String equivalentCurrency, String displayCurrency, Long displayAmount, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {

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

        private String theirRef;

        private String collectingBank;

        private String behalfOfBranch;

        private String drawer;

        private String draweeCustomerID;

        private String draweeNameAddress;

        private String draweeCountry;

        private String chargeDebitAccNo;

        private Long collectionAmount;

        private String collectionCurrency;

        private String shipmentToCountry;

        private String shipmentFromCountry;

        private String hsCode;

        private String goodsCode;

        private String goodsDescription;

        private String incoterms;

        private String portOfDestination;

        private String portOfLoading;

        private String transportDocNumber;

        private java.time.LocalDateTime transportDocDate;

        private String invoiceNo;

        private java.time.LocalDateTime invoiceDate;

        private String formType;

        private String shippingBillNo;

        private java.time.LocalDateTime billDate;

        private String portCode;

        private String formNo;

        private Long shippingAmount;

        private String shippingCurrency;

        private Long reasonShortShpAmt;

        private Long shortShpAmt;

        private Long repaymentAmount;

        private Long shortCollectionAmt;

        private String remittanceNo;

        private String fircNo;

        private Long remittanceAmt;

        private Long utilizationAmt;

        private String remittanceAdCode;

        private String remitersName;

        private java.time.LocalDateTime remitersDate;

        private String remiterCountry;

        private String cifNo;

        private java.time.LocalDateTime leoDate;

        private String exportAgency;

        private String exportType;

        private String destinationCountry;

        private String ieCode;

        private String adCode;

        private String customsNo;

        private String shippingInvSrNo;

        private String shippingInvNo;

        private java.time.LocalDateTime shippingInvDate;

        private Long fobAmount;

        private Long frightAmount;

        private Long insAmt;

        private Long commissionAmt;

        private Long discountAmt;

        private Long deductionAmt;

        private Long packageAmt;

        private String uploadRefID;

        private Long lineNo;

        private Long equivalentAmount;

        private String equivalentCurrency;

        private String displayCurrency;

        private Long displayAmount;

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

        public Builder theirRef(String theirRef) {
            this.theirRef = theirRef;
            return this;
        }

        public Builder collectingBank(String collectingBank) {
            this.collectingBank = collectingBank;
            return this;
        }

        public Builder behalfOfBranch(String behalfOfBranch) {
            this.behalfOfBranch = behalfOfBranch;
            return this;
        }

        public Builder drawer(String drawer) {
            this.drawer = drawer;
            return this;
        }

        public Builder draweeCustomerID(String draweeCustomerID) {
            this.draweeCustomerID = draweeCustomerID;
            return this;
        }

        public Builder draweeNameAddress(String draweeNameAddress) {
            this.draweeNameAddress = draweeNameAddress;
            return this;
        }

        public Builder draweeCountry(String draweeCountry) {
            this.draweeCountry = draweeCountry;
            return this;
        }

        public Builder chargeDebitAccNo(String chargeDebitAccNo) {
            this.chargeDebitAccNo = chargeDebitAccNo;
            return this;
        }

        public Builder collectionAmount(Long collectionAmount) {
            this.collectionAmount = collectionAmount;
            return this;
        }

        public Builder collectionCurrency(String collectionCurrency) {
            this.collectionCurrency = collectionCurrency;
            return this;
        }

        public Builder shipmentToCountry(String shipmentToCountry) {
            this.shipmentToCountry = shipmentToCountry;
            return this;
        }

        public Builder shipmentFromCountry(String shipmentFromCountry) {
            this.shipmentFromCountry = shipmentFromCountry;
            return this;
        }

        public Builder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public Builder goodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
            return this;
        }

        public Builder goodsDescription(String goodsDescription) {
            this.goodsDescription = goodsDescription;
            return this;
        }

        public Builder incoterms(String incoterms) {
            this.incoterms = incoterms;
            return this;
        }

        public Builder portOfDestination(String portOfDestination) {
            this.portOfDestination = portOfDestination;
            return this;
        }

        public Builder portOfLoading(String portOfLoading) {
            this.portOfLoading = portOfLoading;
            return this;
        }

        public Builder transportDocNumber(String transportDocNumber) {
            this.transportDocNumber = transportDocNumber;
            return this;
        }

        public Builder transportDocDate(java.time.LocalDateTime transportDocDate) {
            this.transportDocDate = transportDocDate;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder formType(String formType) {
            this.formType = formType;
            return this;
        }

        public Builder shippingBillNo(String shippingBillNo) {
            this.shippingBillNo = shippingBillNo;
            return this;
        }

        public Builder billDate(java.time.LocalDateTime billDate) {
            this.billDate = billDate;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder formNo(String formNo) {
            this.formNo = formNo;
            return this;
        }

        public Builder shippingAmount(Long shippingAmount) {
            this.shippingAmount = shippingAmount;
            return this;
        }

        public Builder shippingCurrency(String shippingCurrency) {
            this.shippingCurrency = shippingCurrency;
            return this;
        }

        public Builder reasonShortShpAmt(Long reasonShortShpAmt) {
            this.reasonShortShpAmt = reasonShortShpAmt;
            return this;
        }

        public Builder shortShpAmt(Long shortShpAmt) {
            this.shortShpAmt = shortShpAmt;
            return this;
        }

        public Builder repaymentAmount(Long repaymentAmount) {
            this.repaymentAmount = repaymentAmount;
            return this;
        }

        public Builder shortCollectionAmt(Long shortCollectionAmt) {
            this.shortCollectionAmt = shortCollectionAmt;
            return this;
        }

        public Builder remittanceNo(String remittanceNo) {
            this.remittanceNo = remittanceNo;
            return this;
        }

        public Builder fircNo(String fircNo) {
            this.fircNo = fircNo;
            return this;
        }

        public Builder remittanceAmt(Long remittanceAmt) {
            this.remittanceAmt = remittanceAmt;
            return this;
        }

        public Builder utilizationAmt(Long utilizationAmt) {
            this.utilizationAmt = utilizationAmt;
            return this;
        }

        public Builder remittanceAdCode(String remittanceAdCode) {
            this.remittanceAdCode = remittanceAdCode;
            return this;
        }

        public Builder remitersName(String remitersName) {
            this.remitersName = remitersName;
            return this;
        }

        public Builder remitersDate(java.time.LocalDateTime remitersDate) {
            this.remitersDate = remitersDate;
            return this;
        }

        public Builder remiterCountry(String remiterCountry) {
            this.remiterCountry = remiterCountry;
            return this;
        }

        public Builder cifNo(String cifNo) {
            this.cifNo = cifNo;
            return this;
        }

        public Builder leoDate(java.time.LocalDateTime leoDate) {
            this.leoDate = leoDate;
            return this;
        }

        public Builder exportAgency(String exportAgency) {
            this.exportAgency = exportAgency;
            return this;
        }

        public Builder exportType(String exportType) {
            this.exportType = exportType;
            return this;
        }

        public Builder destinationCountry(String destinationCountry) {
            this.destinationCountry = destinationCountry;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder customsNo(String customsNo) {
            this.customsNo = customsNo;
            return this;
        }

        public Builder shippingInvSrNo(String shippingInvSrNo) {
            this.shippingInvSrNo = shippingInvSrNo;
            return this;
        }

        public Builder shippingInvNo(String shippingInvNo) {
            this.shippingInvNo = shippingInvNo;
            return this;
        }

        public Builder shippingInvDate(java.time.LocalDateTime shippingInvDate) {
            this.shippingInvDate = shippingInvDate;
            return this;
        }

        public Builder fobAmount(Long fobAmount) {
            this.fobAmount = fobAmount;
            return this;
        }

        public Builder frightAmount(Long frightAmount) {
            this.frightAmount = frightAmount;
            return this;
        }

        public Builder insAmt(Long insAmt) {
            this.insAmt = insAmt;
            return this;
        }

        public Builder commissionAmt(Long commissionAmt) {
            this.commissionAmt = commissionAmt;
            return this;
        }

        public Builder discountAmt(Long discountAmt) {
            this.discountAmt = discountAmt;
            return this;
        }

        public Builder deductionAmt(Long deductionAmt) {
            this.deductionAmt = deductionAmt;
            return this;
        }

        public Builder packageAmt(Long packageAmt) {
            this.packageAmt = packageAmt;
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

        public Builder equivalentAmount(Long equivalentAmount) {
            this.equivalentAmount = equivalentAmount;
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            this.equivalentCurrency = equivalentCurrency;
            return this;
        }

        public Builder displayCurrency(String displayCurrency) {
            this.displayCurrency = displayCurrency;
            return this;
        }

        public Builder displayAmount(Long displayAmount) {
            this.displayAmount = displayAmount;
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

        public FgChetakImport build() {
            return new FgChetakImport(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, theirRef, collectingBank, behalfOfBranch, drawer, draweeCustomerID, draweeNameAddress, draweeCountry, chargeDebitAccNo, collectionAmount, collectionCurrency, shipmentToCountry, shipmentFromCountry, hsCode, goodsCode, goodsDescription, incoterms, portOfDestination, portOfLoading, transportDocNumber, transportDocDate, invoiceNo, invoiceDate, formType, shippingBillNo, billDate, portCode, formNo, shippingAmount, shippingCurrency, reasonShortShpAmt, shortShpAmt, repaymentAmount, shortCollectionAmt, remittanceNo, fircNo, remittanceAmt, utilizationAmt, remittanceAdCode, remitersName, remitersDate, remiterCountry, cifNo, leoDate, exportAgency, exportType, destinationCountry, ieCode, adCode, customsNo, shippingInvSrNo, shippingInvNo, shippingInvDate, fobAmount, frightAmount, insAmt, commissionAmt, discountAmt, deductionAmt, packageAmt, uploadRefID, lineNo, equivalentAmount, equivalentCurrency, displayCurrency, displayAmount, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, fileName);
        }
    }
}
