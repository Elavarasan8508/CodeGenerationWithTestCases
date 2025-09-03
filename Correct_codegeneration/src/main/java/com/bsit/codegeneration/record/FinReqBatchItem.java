package com.bsit.codegeneration.record;

import java.util.List;

public record FinReqBatchItem(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String batchRefNum, Integer uploadRefID, Integer instrumentID, java.time.LocalDateTime loanDueDate, Long requestAmount, Long invoiceAmount, String fileContent, String customerCrn, Integer tnxRefID, Long financeAmount, Long financingAmount, Long tenorInDays, Long intPeriodInDays, Long contractPeriod, Integer parentRefID, String invNo, java.time.LocalDateTime invDate, Long invAmt, java.time.LocalDateTime maturityDate, Long removeBatchItem, String txnTypeCode, String txnSubTypeCode, Integer parentVersionID, Integer layoutID, String cpCode, String fileName, String tnxDisplayRemarks, Integer tnxDisplayBatchID, String tnxDisplayStatus, String paymentMode, Long interestRate, String anchorName, String counterPartyCrn, String counterPartyName, String inputBranch, String behalfOfBranch, String debitPartyCrn, String creditPartyCrn, String creditPartyName, Long spreadRate, Long marginRate, Long penaltyPercent, String interestType, String rateType, String baseCode, String productType, Long gracePeriod, String limitNode1, String limitNode2, String beneBranch, String beneAccNo, String sellerIDCrn, String buyerIDCrn, String cpRole, String beneLei, Long advanceInterest, Long netPayment, String valueDate, String utrNumber, Long charges, java.time.LocalDateTime utrDate) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

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

        private String batchRefNum;

        private Integer uploadRefID;

        private Integer instrumentID;

        private java.time.LocalDateTime loanDueDate;

        private Long requestAmount;

        private Long invoiceAmount;

        private String fileContent;

        private String customerCrn;

        private Integer tnxRefID;

        private Long financeAmount;

        private Long financingAmount;

        private Long tenorInDays;

        private Long intPeriodInDays;

        private Long contractPeriod;

        private Integer parentRefID;

        private String invNo;

        private java.time.LocalDateTime invDate;

        private Long invAmt;

        private java.time.LocalDateTime maturityDate;

        private Long removeBatchItem;

        private String txnTypeCode;

        private String txnSubTypeCode;

        private Integer parentVersionID;

        private Integer layoutID;

        private String cpCode;

        private String fileName;

        private String tnxDisplayRemarks;

        private Integer tnxDisplayBatchID;

        private String tnxDisplayStatus;

        private String paymentMode;

        private Long interestRate;

        private String anchorName;

        private String counterPartyCrn;

        private String counterPartyName;

        private String inputBranch;

        private String behalfOfBranch;

        private String debitPartyCrn;

        private String creditPartyCrn;

        private String creditPartyName;

        private Long spreadRate;

        private Long marginRate;

        private Long penaltyPercent;

        private String interestType;

        private String rateType;

        private String baseCode;

        private String productType;

        private Long gracePeriod;

        private String limitNode1;

        private String limitNode2;

        private String beneBranch;

        private String beneAccNo;

        private String sellerIDCrn;

        private String buyerIDCrn;

        private String cpRole;

        private String beneLei;

        private Long advanceInterest;

        private Long netPayment;

        private String valueDate;

        private String utrNumber;

        private Long charges;

        private java.time.LocalDateTime utrDate;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
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

        public Builder processID(Integer processID) {
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

        public Builder batchRefNum(String batchRefNum) {
            this.batchRefNum = batchRefNum;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder instrumentID(Integer instrumentID) {
            this.instrumentID = instrumentID;
            return this;
        }

        public Builder loanDueDate(java.time.LocalDateTime loanDueDate) {
            this.loanDueDate = loanDueDate;
            return this;
        }

        public Builder requestAmount(Long requestAmount) {
            this.requestAmount = requestAmount;
            return this;
        }

        public Builder invoiceAmount(Long invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder fileContent(String fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder tnxRefID(Integer tnxRefID) {
            this.tnxRefID = tnxRefID;
            return this;
        }

        public Builder financeAmount(Long financeAmount) {
            this.financeAmount = financeAmount;
            return this;
        }

        public Builder financingAmount(Long financingAmount) {
            this.financingAmount = financingAmount;
            return this;
        }

        public Builder tenorInDays(Long tenorInDays) {
            this.tenorInDays = tenorInDays;
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            this.intPeriodInDays = intPeriodInDays;
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            this.contractPeriod = contractPeriod;
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invAmt(Long invAmt) {
            this.invAmt = invAmt;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder removeBatchItem(Long removeBatchItem) {
            this.removeBatchItem = removeBatchItem;
            return this;
        }

        public Builder txnTypeCode(String txnTypeCode) {
            this.txnTypeCode = txnTypeCode;
            return this;
        }

        public Builder txnSubTypeCode(String txnSubTypeCode) {
            this.txnSubTypeCode = txnSubTypeCode;
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder layoutID(Integer layoutID) {
            this.layoutID = layoutID;
            return this;
        }

        public Builder cpCode(String cpCode) {
            this.cpCode = cpCode;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            this.tnxDisplayRemarks = tnxDisplayRemarks;
            return this;
        }

        public Builder tnxDisplayBatchID(Integer tnxDisplayBatchID) {
            this.tnxDisplayBatchID = tnxDisplayBatchID;
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            this.tnxDisplayStatus = tnxDisplayStatus;
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder anchorName(String anchorName) {
            this.anchorName = anchorName;
            return this;
        }

        public Builder counterPartyCrn(String counterPartyCrn) {
            this.counterPartyCrn = counterPartyCrn;
            return this;
        }

        public Builder counterPartyName(String counterPartyName) {
            this.counterPartyName = counterPartyName;
            return this;
        }

        public Builder inputBranch(String inputBranch) {
            this.inputBranch = inputBranch;
            return this;
        }

        public Builder behalfOfBranch(String behalfOfBranch) {
            this.behalfOfBranch = behalfOfBranch;
            return this;
        }

        public Builder debitPartyCrn(String debitPartyCrn) {
            this.debitPartyCrn = debitPartyCrn;
            return this;
        }

        public Builder creditPartyCrn(String creditPartyCrn) {
            this.creditPartyCrn = creditPartyCrn;
            return this;
        }

        public Builder creditPartyName(String creditPartyName) {
            this.creditPartyName = creditPartyName;
            return this;
        }

        public Builder spreadRate(Long spreadRate) {
            this.spreadRate = spreadRate;
            return this;
        }

        public Builder marginRate(Long marginRate) {
            this.marginRate = marginRate;
            return this;
        }

        public Builder penaltyPercent(Long penaltyPercent) {
            this.penaltyPercent = penaltyPercent;
            return this;
        }

        public Builder interestType(String interestType) {
            this.interestType = interestType;
            return this;
        }

        public Builder rateType(String rateType) {
            this.rateType = rateType;
            return this;
        }

        public Builder baseCode(String baseCode) {
            this.baseCode = baseCode;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder gracePeriod(Long gracePeriod) {
            this.gracePeriod = gracePeriod;
            return this;
        }

        public Builder limitNode1(String limitNode1) {
            this.limitNode1 = limitNode1;
            return this;
        }

        public Builder limitNode2(String limitNode2) {
            this.limitNode2 = limitNode2;
            return this;
        }

        public Builder beneBranch(String beneBranch) {
            this.beneBranch = beneBranch;
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            this.beneAccNo = beneAccNo;
            return this;
        }

        public Builder sellerIDCrn(String sellerIDCrn) {
            this.sellerIDCrn = sellerIDCrn;
            return this;
        }

        public Builder buyerIDCrn(String buyerIDCrn) {
            this.buyerIDCrn = buyerIDCrn;
            return this;
        }

        public Builder cpRole(String cpRole) {
            this.cpRole = cpRole;
            return this;
        }

        public Builder beneLei(String beneLei) {
            this.beneLei = beneLei;
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

        public Builder utrDate(java.time.LocalDateTime utrDate) {
            this.utrDate = utrDate;
            return this;
        }

        public FinReqBatchItem build() {
            return new FinReqBatchItem(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, batchRefNum, uploadRefID, instrumentID, loanDueDate, requestAmount, invoiceAmount, fileContent, customerCrn, tnxRefID, financeAmount, financingAmount, tenorInDays, intPeriodInDays, contractPeriod, parentRefID, invNo, invDate, invAmt, maturityDate, removeBatchItem, txnTypeCode, txnSubTypeCode, parentVersionID, layoutID, cpCode, fileName, tnxDisplayRemarks, tnxDisplayBatchID, tnxDisplayStatus, paymentMode, interestRate, anchorName, counterPartyCrn, counterPartyName, inputBranch, behalfOfBranch, debitPartyCrn, creditPartyCrn, creditPartyName, spreadRate, marginRate, penaltyPercent, interestType, rateType, baseCode, productType, gracePeriod, limitNode1, limitNode2, beneBranch, beneAccNo, sellerIDCrn, buyerIDCrn, cpRole, beneLei, advanceInterest, netPayment, valueDate, utrNumber, charges, utrDate);
        }
    }
}
