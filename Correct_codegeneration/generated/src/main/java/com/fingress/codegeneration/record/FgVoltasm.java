package com.bsit.codegeneration.record;

public record FgVoltasm(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String clientCode, String productCode, String paymentType, String paymentRefNo, java.time.LocalDateTime paymentDate, java.time.LocalDateTime instrumentDate, Long amount, String bankCodeIndicator, String beneficiaryCode, String beneficiaryName, String beneficiaryBank, String beneficiaryBranch, String location, String printLocation, Long instrumentNo, String beneficiaryAddress1, String beneficiaryAddress2, String beneficiaryAddress3, String beneficiaryAddress4, String beneficiaryEmail, String beneficiaryMobile, String debitNarration, String creditNarration, String paymentDetails1, String paymentDetails2, String paymentDetails3, String paymentDetails4, String srNo, String documentNo, String invRefNo, java.time.LocalDateTime invDate, Long invAmount, Long otherDeductions, Long tdsAmount, Long totalDeductedAmount, Long netAmountPayable, String uploadRefID, Long lineNo, String uploadLayoutUuid, String beneficiaryAccNo, String drAcNo, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {

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

        private String clientCode;

        private String productCode;

        private String paymentType;

        private String paymentRefNo;

        private java.time.LocalDateTime paymentDate;

        private java.time.LocalDateTime instrumentDate;

        private Long amount;

        private String bankCodeIndicator;

        private String beneficiaryCode;

        private String beneficiaryName;

        private String beneficiaryBank;

        private String beneficiaryBranch;

        private String location;

        private String printLocation;

        private Long instrumentNo;

        private String beneficiaryAddress1;

        private String beneficiaryAddress2;

        private String beneficiaryAddress3;

        private String beneficiaryAddress4;

        private String beneficiaryEmail;

        private String beneficiaryMobile;

        private String debitNarration;

        private String creditNarration;

        private String paymentDetails1;

        private String paymentDetails2;

        private String paymentDetails3;

        private String paymentDetails4;

        private String srNo;

        private String documentNo;

        private String invRefNo;

        private java.time.LocalDateTime invDate;

        private Long invAmount;

        private Long otherDeductions;

        private Long tdsAmount;

        private Long totalDeductedAmount;

        private Long netAmountPayable;

        private String uploadRefID;

        private Long lineNo;

        private String uploadLayoutUuid;

        private String beneficiaryAccNo;

        private String drAcNo;

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

        public Builder clientCode(String clientCode) {
            this.clientCode = clientCode;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder paymentRefNo(String paymentRefNo) {
            this.paymentRefNo = paymentRefNo;
            return this;
        }

        public Builder paymentDate(java.time.LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder instrumentDate(java.time.LocalDateTime instrumentDate) {
            this.instrumentDate = instrumentDate;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            this.bankCodeIndicator = bankCodeIndicator;
            return this;
        }

        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder beneficiaryBank(String beneficiaryBank) {
            this.beneficiaryBank = beneficiaryBank;
            return this;
        }

        public Builder beneficiaryBranch(String beneficiaryBranch) {
            this.beneficiaryBranch = beneficiaryBranch;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder printLocation(String printLocation) {
            this.printLocation = printLocation;
            return this;
        }

        public Builder instrumentNo(Long instrumentNo) {
            this.instrumentNo = instrumentNo;
            return this;
        }

        public Builder beneficiaryAddress1(String beneficiaryAddress1) {
            this.beneficiaryAddress1 = beneficiaryAddress1;
            return this;
        }

        public Builder beneficiaryAddress2(String beneficiaryAddress2) {
            this.beneficiaryAddress2 = beneficiaryAddress2;
            return this;
        }

        public Builder beneficiaryAddress3(String beneficiaryAddress3) {
            this.beneficiaryAddress3 = beneficiaryAddress3;
            return this;
        }

        public Builder beneficiaryAddress4(String beneficiaryAddress4) {
            this.beneficiaryAddress4 = beneficiaryAddress4;
            return this;
        }

        public Builder beneficiaryEmail(String beneficiaryEmail) {
            this.beneficiaryEmail = beneficiaryEmail;
            return this;
        }

        public Builder beneficiaryMobile(String beneficiaryMobile) {
            this.beneficiaryMobile = beneficiaryMobile;
            return this;
        }

        public Builder debitNarration(String debitNarration) {
            this.debitNarration = debitNarration;
            return this;
        }

        public Builder creditNarration(String creditNarration) {
            this.creditNarration = creditNarration;
            return this;
        }

        public Builder paymentDetails1(String paymentDetails1) {
            this.paymentDetails1 = paymentDetails1;
            return this;
        }

        public Builder paymentDetails2(String paymentDetails2) {
            this.paymentDetails2 = paymentDetails2;
            return this;
        }

        public Builder paymentDetails3(String paymentDetails3) {
            this.paymentDetails3 = paymentDetails3;
            return this;
        }

        public Builder paymentDetails4(String paymentDetails4) {
            this.paymentDetails4 = paymentDetails4;
            return this;
        }

        public Builder srNo(String srNo) {
            this.srNo = srNo;
            return this;
        }

        public Builder documentNo(String documentNo) {
            this.documentNo = documentNo;
            return this;
        }

        public Builder invRefNo(String invRefNo) {
            this.invRefNo = invRefNo;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invAmount(Long invAmount) {
            this.invAmount = invAmount;
            return this;
        }

        public Builder otherDeductions(Long otherDeductions) {
            this.otherDeductions = otherDeductions;
            return this;
        }

        public Builder tdsAmount(Long tdsAmount) {
            this.tdsAmount = tdsAmount;
            return this;
        }

        public Builder totalDeductedAmount(Long totalDeductedAmount) {
            this.totalDeductedAmount = totalDeductedAmount;
            return this;
        }

        public Builder netAmountPayable(Long netAmountPayable) {
            this.netAmountPayable = netAmountPayable;
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

        public Builder uploadLayoutUuid(String uploadLayoutUuid) {
            this.uploadLayoutUuid = uploadLayoutUuid;
            return this;
        }

        public Builder beneficiaryAccNo(String beneficiaryAccNo) {
            this.beneficiaryAccNo = beneficiaryAccNo;
            return this;
        }

        public Builder drAcNo(String drAcNo) {
            this.drAcNo = drAcNo;
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

        public FgVoltasm build() {
            return new FgVoltasm(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, clientCode, productCode, paymentType, paymentRefNo, paymentDate, instrumentDate, amount, bankCodeIndicator, beneficiaryCode, beneficiaryName, beneficiaryBank, beneficiaryBranch, location, printLocation, instrumentNo, beneficiaryAddress1, beneficiaryAddress2, beneficiaryAddress3, beneficiaryAddress4, beneficiaryEmail, beneficiaryMobile, debitNarration, creditNarration, paymentDetails1, paymentDetails2, paymentDetails3, paymentDetails4, srNo, documentNo, invRefNo, invDate, invAmount, otherDeductions, tdsAmount, totalDeductedAmount, netAmountPayable, uploadRefID, lineNo, uploadLayoutUuid, beneficiaryAccNo, drAcNo, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, fileName);
        }
    }
}
