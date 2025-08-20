package com.bsit.codegeneration.record;

public record FgMandml(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String recordIndicator, String vendorName, String payeeName, String address1, String address2, String address3, String city, String payeeType, String payeeAccount, String ifsc, String invoiceNumber, String currencyCode, Long amount, java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, String transID, Long interestRate, String email, String uploadRefID, Long lineNo, String clientCode, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String issuingPartyCode, String applicantPartyCode, String fileName, String batchStatus, String batchRefID, String batchRemarks, String tiStatus, String tiBatchRefID, String tiRemarks, String tnxDisplayStatus, String tnxDisplayBatchID, String tnxDisplayRemarks, Long advanceInterest, Long netPayment, String valueDate, String utrNumber, Long charges, String layoutName, java.time.LocalDateTime customMaturityDate, String layoutUuid, String loanRequestType, String financeParty, String financeRequestStatus, Long layoutTemplateID, String financeRequested) {

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

        private String recordIndicator;

        private String vendorName;

        private String payeeName;

        private String address1;

        private String address2;

        private String address3;

        private String city;

        private String payeeType;

        private String payeeAccount;

        private String ifsc;

        private String invoiceNumber;

        private String currencyCode;

        private Long amount;

        private java.time.LocalDateTime startDate;

        private java.time.LocalDateTime endDate;

        private String transID;

        private Long interestRate;

        private String email;

        private String uploadRefID;

        private Long lineNo;

        private String clientCode;

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

        private String issuingPartyCode;

        private String applicantPartyCode;

        private String fileName;

        private String batchStatus;

        private String batchRefID;

        private String batchRemarks;

        private String tiStatus;

        private String tiBatchRefID;

        private String tiRemarks;

        private String tnxDisplayStatus;

        private String tnxDisplayBatchID;

        private String tnxDisplayRemarks;

        private Long advanceInterest;

        private Long netPayment;

        private String valueDate;

        private String utrNumber;

        private Long charges;

        private String layoutName;

        private java.time.LocalDateTime customMaturityDate;

        private String layoutUuid;

        private String loanRequestType;

        private String financeParty;

        private String financeRequestStatus;

        private Long layoutTemplateID;

        private String financeRequested;

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

        public Builder recordIndicator(String recordIndicator) {
            this.recordIndicator = recordIndicator;
            return this;
        }

        public Builder vendorName(String vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        public Builder payeeName(String payeeName) {
            this.payeeName = payeeName;
            return this;
        }

        public Builder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Builder address3(String address3) {
            this.address3 = address3;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder payeeType(String payeeType) {
            this.payeeType = payeeType;
            return this;
        }

        public Builder payeeAccount(String payeeAccount) {
            this.payeeAccount = payeeAccount;
            return this;
        }

        public Builder ifsc(String ifsc) {
            this.ifsc = ifsc;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
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

        public Builder transID(String transID) {
            this.transID = transID;
            return this;
        }

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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

        public Builder clientCode(String clientCode) {
            this.clientCode = clientCode;
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

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder batchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
            return this;
        }

        public Builder batchRefID(String batchRefID) {
            this.batchRefID = batchRefID;
            return this;
        }

        public Builder batchRemarks(String batchRemarks) {
            this.batchRemarks = batchRemarks;
            return this;
        }

        public Builder tiStatus(String tiStatus) {
            this.tiStatus = tiStatus;
            return this;
        }

        public Builder tiBatchRefID(String tiBatchRefID) {
            this.tiBatchRefID = tiBatchRefID;
            return this;
        }

        public Builder tiRemarks(String tiRemarks) {
            this.tiRemarks = tiRemarks;
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            this.tnxDisplayStatus = tnxDisplayStatus;
            return this;
        }

        public Builder tnxDisplayBatchID(String tnxDisplayBatchID) {
            this.tnxDisplayBatchID = tnxDisplayBatchID;
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            this.tnxDisplayRemarks = tnxDisplayRemarks;
            return this;
        }

        public Builder advanceInterest(Long advanceInterest) {
            this.advanceInterest = advanceInterest;
            return this;
        }

        public Builder netPayment(Long netPayment) {
            this.netPayment = netPayment;
            return this;
        }

        public Builder valueDate(String valueDate) {
            this.valueDate = valueDate;
            return this;
        }

        public Builder utrNumber(String utrNumber) {
            this.utrNumber = utrNumber;
            return this;
        }

        public Builder charges(Long charges) {
            this.charges = charges;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder customMaturityDate(java.time.LocalDateTime customMaturityDate) {
            this.customMaturityDate = customMaturityDate;
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            this.layoutUuid = layoutUuid;
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            this.loanRequestType = loanRequestType;
            return this;
        }

        public Builder financeParty(String financeParty) {
            this.financeParty = financeParty;
            return this;
        }

        public Builder financeRequestStatus(String financeRequestStatus) {
            this.financeRequestStatus = financeRequestStatus;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder financeRequested(String financeRequested) {
            this.financeRequested = financeRequested;
            return this;
        }

        public FgMandml build() {
            return new FgMandml(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, recordIndicator, vendorName, payeeName, address1, address2, address3, city, payeeType, payeeAccount, ifsc, invoiceNumber, currencyCode, amount, startDate, endDate, transID, interestRate, email, uploadRefID, lineNo, clientCode, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, issuingPartyCode, applicantPartyCode, fileName, batchStatus, batchRefID, batchRemarks, tiStatus, tiBatchRefID, tiRemarks, tnxDisplayStatus, tnxDisplayBatchID, tnxDisplayRemarks, advanceInterest, netPayment, valueDate, utrNumber, charges, layoutName, customMaturityDate, layoutUuid, loanRequestType, financeParty, financeRequestStatus, layoutTemplateID, financeRequested);
        }
    }
}
