package com.bsit.codegeneration.record;

public record FgOrmFu(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String remittanceType, String purposeCode, String purposeOfRem, String regularatoryReport, String capitalGoods, String transportDocNo, String countryProviding, String transferRef, String customerRef, String entity, String beneCountry, String beneAcct, String chargeInstruction, java.time.LocalDateTime executionDate, String paymentInstruction, String issuingBank, String issuersRef, String interBankSwift, String interBankName, String interBankAddr1, String interBankAddr2, String interBankAddr3, String chargeAcct, String attachments, String portDischarge, String duplicateCheck, String others, Long debitAcctno, String trasactionCcy, Long trasactionAmt, String supplierName, String supplierAcctno, String supplierAddr1, String supplierAddr2, String supplierAddr3, String notifyParties, String originOfGoods, String thirdPartyName, String thirdPartyAddr1, String thirdPartyAddr2, String thirdPartyAddr3, String consignorName, String consignorAddr1, String consignorAddr2, String consignorAddr3, String consigneeName, String consigneeAddr1, String consigneeAddr2, String consigneeAddr3, String boeDate, String supplierBankSwift, String fxDealRef, String goodsDesc, String purposeOfPayment, String gstin, Long chargeAcctno, String supplierInstruction, String uploadRefID, String displayStatus, String boeNumber, String fccStatus, String fccStage, String fccComments, String beneCurrency, String issuingBankName, String txnStatus, String txnReference, String fileName, String APIErrorDesc, String lineNo, String applicantPartyCode, String issuingPartyCode, String rateDetails, String dealType, String beneBanSwift, String bankAbbvName) {

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

        private String remittanceType;

        private String purposeCode;

        private String purposeOfRem;

        private String regularatoryReport;

        private String capitalGoods;

        private String transportDocNo;

        private String countryProviding;

        private String transferRef;

        private String customerRef;

        private String entity;

        private String beneCountry;

        private String beneAcct;

        private String chargeInstruction;

        private java.time.LocalDateTime executionDate;

        private String paymentInstruction;

        private String issuingBank;

        private String issuersRef;

        private String interBankSwift;

        private String interBankName;

        private String interBankAddr1;

        private String interBankAddr2;

        private String interBankAddr3;

        private String chargeAcct;

        private String attachments;

        private String portDischarge;

        private String duplicateCheck;

        private String others;

        private Long debitAcctno;

        private String trasactionCcy;

        private Long trasactionAmt;

        private String supplierName;

        private String supplierAcctno;

        private String supplierAddr1;

        private String supplierAddr2;

        private String supplierAddr3;

        private String notifyParties;

        private String originOfGoods;

        private String thirdPartyName;

        private String thirdPartyAddr1;

        private String thirdPartyAddr2;

        private String thirdPartyAddr3;

        private String consignorName;

        private String consignorAddr1;

        private String consignorAddr2;

        private String consignorAddr3;

        private String consigneeName;

        private String consigneeAddr1;

        private String consigneeAddr2;

        private String consigneeAddr3;

        private String boeDate;

        private String supplierBankSwift;

        private String fxDealRef;

        private String goodsDesc;

        private String purposeOfPayment;

        private String gstin;

        private Long chargeAcctno;

        private String supplierInstruction;

        private String uploadRefID;

        private String displayStatus;

        private String boeNumber;

        private String fccStatus;

        private String fccStage;

        private String fccComments;

        private String beneCurrency;

        private String issuingBankName;

        private String txnStatus;

        private String txnReference;

        private String fileName;

        private String APIErrorDesc;

        private String lineNo;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private String rateDetails;

        private String dealType;

        private String beneBanSwift;

        private String bankAbbvName;

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

        public Builder remittanceType(String remittanceType) {
            this.remittanceType = remittanceType;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder purposeOfRem(String purposeOfRem) {
            this.purposeOfRem = purposeOfRem;
            return this;
        }

        public Builder regularatoryReport(String regularatoryReport) {
            this.regularatoryReport = regularatoryReport;
            return this;
        }

        public Builder capitalGoods(String capitalGoods) {
            this.capitalGoods = capitalGoods;
            return this;
        }

        public Builder transportDocNo(String transportDocNo) {
            this.transportDocNo = transportDocNo;
            return this;
        }

        public Builder countryProviding(String countryProviding) {
            this.countryProviding = countryProviding;
            return this;
        }

        public Builder transferRef(String transferRef) {
            this.transferRef = transferRef;
            return this;
        }

        public Builder customerRef(String customerRef) {
            this.customerRef = customerRef;
            return this;
        }

        public Builder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public Builder beneCountry(String beneCountry) {
            this.beneCountry = beneCountry;
            return this;
        }

        public Builder beneAcct(String beneAcct) {
            this.beneAcct = beneAcct;
            return this;
        }

        public Builder chargeInstruction(String chargeInstruction) {
            this.chargeInstruction = chargeInstruction;
            return this;
        }

        public Builder executionDate(java.time.LocalDateTime executionDate) {
            this.executionDate = executionDate;
            return this;
        }

        public Builder paymentInstruction(String paymentInstruction) {
            this.paymentInstruction = paymentInstruction;
            return this;
        }

        public Builder issuingBank(String issuingBank) {
            this.issuingBank = issuingBank;
            return this;
        }

        public Builder issuersRef(String issuersRef) {
            this.issuersRef = issuersRef;
            return this;
        }

        public Builder interBankSwift(String interBankSwift) {
            this.interBankSwift = interBankSwift;
            return this;
        }

        public Builder interBankName(String interBankName) {
            this.interBankName = interBankName;
            return this;
        }

        public Builder interBankAddr1(String interBankAddr1) {
            this.interBankAddr1 = interBankAddr1;
            return this;
        }

        public Builder interBankAddr2(String interBankAddr2) {
            this.interBankAddr2 = interBankAddr2;
            return this;
        }

        public Builder interBankAddr3(String interBankAddr3) {
            this.interBankAddr3 = interBankAddr3;
            return this;
        }

        public Builder chargeAcct(String chargeAcct) {
            this.chargeAcct = chargeAcct;
            return this;
        }

        public Builder attachments(String attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder portDischarge(String portDischarge) {
            this.portDischarge = portDischarge;
            return this;
        }

        public Builder duplicateCheck(String duplicateCheck) {
            this.duplicateCheck = duplicateCheck;
            return this;
        }

        public Builder others(String others) {
            this.others = others;
            return this;
        }

        public Builder debitAcctno(Long debitAcctno) {
            this.debitAcctno = debitAcctno;
            return this;
        }

        public Builder trasactionCcy(String trasactionCcy) {
            this.trasactionCcy = trasactionCcy;
            return this;
        }

        public Builder trasactionAmt(Long trasactionAmt) {
            this.trasactionAmt = trasactionAmt;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder supplierAcctno(String supplierAcctno) {
            this.supplierAcctno = supplierAcctno;
            return this;
        }

        public Builder supplierAddr1(String supplierAddr1) {
            this.supplierAddr1 = supplierAddr1;
            return this;
        }

        public Builder supplierAddr2(String supplierAddr2) {
            this.supplierAddr2 = supplierAddr2;
            return this;
        }

        public Builder supplierAddr3(String supplierAddr3) {
            this.supplierAddr3 = supplierAddr3;
            return this;
        }

        public Builder notifyParties(String notifyParties) {
            this.notifyParties = notifyParties;
            return this;
        }

        public Builder originOfGoods(String originOfGoods) {
            this.originOfGoods = originOfGoods;
            return this;
        }

        public Builder thirdPartyName(String thirdPartyName) {
            this.thirdPartyName = thirdPartyName;
            return this;
        }

        public Builder thirdPartyAddr1(String thirdPartyAddr1) {
            this.thirdPartyAddr1 = thirdPartyAddr1;
            return this;
        }

        public Builder thirdPartyAddr2(String thirdPartyAddr2) {
            this.thirdPartyAddr2 = thirdPartyAddr2;
            return this;
        }

        public Builder thirdPartyAddr3(String thirdPartyAddr3) {
            this.thirdPartyAddr3 = thirdPartyAddr3;
            return this;
        }

        public Builder consignorName(String consignorName) {
            this.consignorName = consignorName;
            return this;
        }

        public Builder consignorAddr1(String consignorAddr1) {
            this.consignorAddr1 = consignorAddr1;
            return this;
        }

        public Builder consignorAddr2(String consignorAddr2) {
            this.consignorAddr2 = consignorAddr2;
            return this;
        }

        public Builder consignorAddr3(String consignorAddr3) {
            this.consignorAddr3 = consignorAddr3;
            return this;
        }

        public Builder consigneeName(String consigneeName) {
            this.consigneeName = consigneeName;
            return this;
        }

        public Builder consigneeAddr1(String consigneeAddr1) {
            this.consigneeAddr1 = consigneeAddr1;
            return this;
        }

        public Builder consigneeAddr2(String consigneeAddr2) {
            this.consigneeAddr2 = consigneeAddr2;
            return this;
        }

        public Builder consigneeAddr3(String consigneeAddr3) {
            this.consigneeAddr3 = consigneeAddr3;
            return this;
        }

        public Builder boeDate(String boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder supplierBankSwift(String supplierBankSwift) {
            this.supplierBankSwift = supplierBankSwift;
            return this;
        }

        public Builder fxDealRef(String fxDealRef) {
            this.fxDealRef = fxDealRef;
            return this;
        }

        public Builder goodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
            return this;
        }

        public Builder purposeOfPayment(String purposeOfPayment) {
            this.purposeOfPayment = purposeOfPayment;
            return this;
        }

        public Builder gstin(String gstin) {
            this.gstin = gstin;
            return this;
        }

        public Builder chargeAcctno(Long chargeAcctno) {
            this.chargeAcctno = chargeAcctno;
            return this;
        }

        public Builder supplierInstruction(String supplierInstruction) {
            this.supplierInstruction = supplierInstruction;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder fccStatus(String fccStatus) {
            this.fccStatus = fccStatus;
            return this;
        }

        public Builder fccStage(String fccStage) {
            this.fccStage = fccStage;
            return this;
        }

        public Builder fccComments(String fccComments) {
            this.fccComments = fccComments;
            return this;
        }

        public Builder beneCurrency(String beneCurrency) {
            this.beneCurrency = beneCurrency;
            return this;
        }

        public Builder issuingBankName(String issuingBankName) {
            this.issuingBankName = issuingBankName;
            return this;
        }

        public Builder txnStatus(String txnStatus) {
            this.txnStatus = txnStatus;
            return this;
        }

        public Builder txnReference(String txnReference) {
            this.txnReference = txnReference;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder APIErrorDesc(String APIErrorDesc) {
            this.APIErrorDesc = APIErrorDesc;
            return this;
        }

        public Builder lineNo(String lineNo) {
            this.lineNo = lineNo;
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

        public Builder rateDetails(String rateDetails) {
            this.rateDetails = rateDetails;
            return this;
        }

        public Builder dealType(String dealType) {
            this.dealType = dealType;
            return this;
        }

        public Builder beneBanSwift(String beneBanSwift) {
            this.beneBanSwift = beneBanSwift;
            return this;
        }

        public Builder bankAbbvName(String bankAbbvName) {
            this.bankAbbvName = bankAbbvName;
            return this;
        }

        public FgOrmFu build() {
            return new FgOrmFu(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, remittanceType, purposeCode, purposeOfRem, regularatoryReport, capitalGoods, transportDocNo, countryProviding, transferRef, customerRef, entity, beneCountry, beneAcct, chargeInstruction, executionDate, paymentInstruction, issuingBank, issuersRef, interBankSwift, interBankName, interBankAddr1, interBankAddr2, interBankAddr3, chargeAcct, attachments, portDischarge, duplicateCheck, others, debitAcctno, trasactionCcy, trasactionAmt, supplierName, supplierAcctno, supplierAddr1, supplierAddr2, supplierAddr3, notifyParties, originOfGoods, thirdPartyName, thirdPartyAddr1, thirdPartyAddr2, thirdPartyAddr3, consignorName, consignorAddr1, consignorAddr2, consignorAddr3, consigneeName, consigneeAddr1, consigneeAddr2, consigneeAddr3, boeDate, supplierBankSwift, fxDealRef, goodsDesc, purposeOfPayment, gstin, chargeAcctno, supplierInstruction, uploadRefID, displayStatus, boeNumber, fccStatus, fccStage, fccComments, beneCurrency, issuingBankName, txnStatus, txnReference, fileName, APIErrorDesc, lineNo, applicantPartyCode, issuingPartyCode, rateDetails, dealType, beneBanSwift, bankAbbvName);
        }
    }
}
