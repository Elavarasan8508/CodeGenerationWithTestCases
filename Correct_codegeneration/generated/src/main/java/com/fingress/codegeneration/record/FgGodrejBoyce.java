package com.bsit.codegeneration.record;

public record FgGodrejBoyce(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String sellerID, String supplierName, String buyerID, java.time.LocalDateTime invoiceDate, String invoiceNo, Long invoiceAmount, String currency, java.time.LocalDateTime dueDate, String referenceNo, String uploadRefID, String remarks, Long lineNo, String srNo, String test1, String test2, String test3, String test4, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long equivalentAmount, String equivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String applicantParty, Long layoutTemplateID, String layoutName, String fileName, String batchStatus, String batchRefID, String batchRemarks, String tiStatus, String tiBatchRefID, String tiRemarks, String tnxDisplayStatus, String tnxDisplayBatchID, String tnxDisplayRemarks, Long advanceInterest, Long netPayment, String valueDate, String utrNumber, Long charges, String freeText1, String freeText2, String freeText3, String programType, java.time.LocalDateTime customMaturityDate, String layoutID, String layoutUuid, String loanRequestType, String portalBatchRefID, String financeParty, String financeRequestStatus, String financeRequested) {

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

        private String sellerID;

        private String supplierName;

        private String buyerID;

        private java.time.LocalDateTime invoiceDate;

        private String invoiceNo;

        private Long invoiceAmount;

        private String currency;

        private java.time.LocalDateTime dueDate;

        private String referenceNo;

        private String uploadRefID;

        private String remarks;

        private Long lineNo;

        private String srNo;

        private String test1;

        private String test2;

        private String test3;

        private String test4;

        private Long authEquivalentAmount;

        private String authEquivalentCurrency;

        private Long displayEquivalentAmount;

        private String displayEquivalentCurrency;

        private Long equivalentAmount;

        private String equivalentCurrency;

        private Long authFxBaseRate;

        private Long displayFxBaseRate;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private String applicantParty;

        private Long layoutTemplateID;

        private String layoutName;

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

        private String freeText1;

        private String freeText2;

        private String freeText3;

        private String programType;

        private java.time.LocalDateTime customMaturityDate;

        private String layoutID;

        private String layoutUuid;

        private String loanRequestType;

        private String portalBatchRefID;

        private String financeParty;

        private String financeRequestStatus;

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

        public Builder sellerID(String sellerID) {
            this.sellerID = sellerID;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder buyerID(String buyerID) {
            this.buyerID = buyerID;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder invoiceAmount(Long invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder dueDate(java.time.LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder referenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder srNo(String srNo) {
            this.srNo = srNo;
            return this;
        }

        public Builder test1(String test1) {
            this.test1 = test1;
            return this;
        }

        public Builder test2(String test2) {
            this.test2 = test2;
            return this;
        }

        public Builder test3(String test3) {
            this.test3 = test3;
            return this;
        }

        public Builder test4(String test4) {
            this.test4 = test4;
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

        public Builder equivalentAmount(Long equivalentAmount) {
            this.equivalentAmount = equivalentAmount;
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            this.equivalentCurrency = equivalentCurrency;
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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
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

        public Builder freeText1(String freeText1) {
            this.freeText1 = freeText1;
            return this;
        }

        public Builder freeText2(String freeText2) {
            this.freeText2 = freeText2;
            return this;
        }

        public Builder freeText3(String freeText3) {
            this.freeText3 = freeText3;
            return this;
        }

        public Builder programType(String programType) {
            this.programType = programType;
            return this;
        }

        public Builder customMaturityDate(java.time.LocalDateTime customMaturityDate) {
            this.customMaturityDate = customMaturityDate;
            return this;
        }

        public Builder layoutID(String layoutID) {
            this.layoutID = layoutID;
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

        public Builder portalBatchRefID(String portalBatchRefID) {
            this.portalBatchRefID = portalBatchRefID;
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

        public Builder financeRequested(String financeRequested) {
            this.financeRequested = financeRequested;
            return this;
        }

        public FgGodrejBoyce build() {
            return new FgGodrejBoyce(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, sellerID, supplierName, buyerID, invoiceDate, invoiceNo, invoiceAmount, currency, dueDate, referenceNo, uploadRefID, remarks, lineNo, srNo, test1, test2, test3, test4, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, equivalentAmount, equivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, applicantParty, layoutTemplateID, layoutName, fileName, batchStatus, batchRefID, batchRemarks, tiStatus, tiBatchRefID, tiRemarks, tnxDisplayStatus, tnxDisplayBatchID, tnxDisplayRemarks, advanceInterest, netPayment, valueDate, utrNumber, charges, freeText1, freeText2, freeText3, programType, customMaturityDate, layoutID, layoutUuid, loanRequestType, portalBatchRefID, financeParty, financeRequestStatus, financeRequested);
        }
    }
}
