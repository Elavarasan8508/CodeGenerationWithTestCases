package com.bsit.codegeneration.record;

public record FgChetakKonet(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String crnNo, String operativeAcc, String buySuplrName, String commrInvNo, String commrInvCurrency, Long commrInvAmount, Long miscFreightCharge, String goodDescr, String paymentTerm, String countryOfOrigin, String boeNo, String adCode, String portOfDischarge, String portOfLoading, String blNum, String flightName, String custRefNo, String paymentDetails, String fxContractRefNo, String uploadRefID, Long lineNo, String dueOrValueDate, String blDate, String shipmentDate, String commrInvDate, String boeDate, String hawbDate, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {

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

        private String crnNo;

        private String operativeAcc;

        private String buySuplrName;

        private String commrInvNo;

        private String commrInvCurrency;

        private Long commrInvAmount;

        private Long miscFreightCharge;

        private String goodDescr;

        private String paymentTerm;

        private String countryOfOrigin;

        private String boeNo;

        private String adCode;

        private String portOfDischarge;

        private String portOfLoading;

        private String blNum;

        private String flightName;

        private String custRefNo;

        private String paymentDetails;

        private String fxContractRefNo;

        private String uploadRefID;

        private Long lineNo;

        private String dueOrValueDate;

        private String blDate;

        private String shipmentDate;

        private String commrInvDate;

        private String boeDate;

        private String hawbDate;

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

        public Builder crnNo(String crnNo) {
            this.crnNo = crnNo;
            return this;
        }

        public Builder operativeAcc(String operativeAcc) {
            this.operativeAcc = operativeAcc;
            return this;
        }

        public Builder buySuplrName(String buySuplrName) {
            this.buySuplrName = buySuplrName;
            return this;
        }

        public Builder commrInvNo(String commrInvNo) {
            this.commrInvNo = commrInvNo;
            return this;
        }

        public Builder commrInvCurrency(String commrInvCurrency) {
            this.commrInvCurrency = commrInvCurrency;
            return this;
        }

        public Builder commrInvAmount(Long commrInvAmount) {
            this.commrInvAmount = commrInvAmount;
            return this;
        }

        public Builder miscFreightCharge(Long miscFreightCharge) {
            this.miscFreightCharge = miscFreightCharge;
            return this;
        }

        public Builder goodDescr(String goodDescr) {
            this.goodDescr = goodDescr;
            return this;
        }

        public Builder paymentTerm(String paymentTerm) {
            this.paymentTerm = paymentTerm;
            return this;
        }

        public Builder countryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
            return this;
        }

        public Builder boeNo(String boeNo) {
            this.boeNo = boeNo;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder portOfDischarge(String portOfDischarge) {
            this.portOfDischarge = portOfDischarge;
            return this;
        }

        public Builder portOfLoading(String portOfLoading) {
            this.portOfLoading = portOfLoading;
            return this;
        }

        public Builder blNum(String blNum) {
            this.blNum = blNum;
            return this;
        }

        public Builder flightName(String flightName) {
            this.flightName = flightName;
            return this;
        }

        public Builder custRefNo(String custRefNo) {
            this.custRefNo = custRefNo;
            return this;
        }

        public Builder paymentDetails(String paymentDetails) {
            this.paymentDetails = paymentDetails;
            return this;
        }

        public Builder fxContractRefNo(String fxContractRefNo) {
            this.fxContractRefNo = fxContractRefNo;
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

        public Builder dueOrValueDate(String dueOrValueDate) {
            this.dueOrValueDate = dueOrValueDate;
            return this;
        }

        public Builder blDate(String blDate) {
            this.blDate = blDate;
            return this;
        }

        public Builder shipmentDate(String shipmentDate) {
            this.shipmentDate = shipmentDate;
            return this;
        }

        public Builder commrInvDate(String commrInvDate) {
            this.commrInvDate = commrInvDate;
            return this;
        }

        public Builder boeDate(String boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder hawbDate(String hawbDate) {
            this.hawbDate = hawbDate;
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

        public FgChetakKonet build() {
            return new FgChetakKonet(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, crnNo, operativeAcc, buySuplrName, commrInvNo, commrInvCurrency, commrInvAmount, miscFreightCharge, goodDescr, paymentTerm, countryOfOrigin, boeNo, adCode, portOfDischarge, portOfLoading, blNum, flightName, custRefNo, paymentDetails, fxContractRefNo, uploadRefID, lineNo, dueOrValueDate, blDate, shipmentDate, commrInvDate, boeDate, hawbDate, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, fileName);
        }
    }
}
