package com.bsit.codegeneration.record;

import java.util.List;

public record FgFinanceTransactions(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String fileName, String anchorCrn, String invNo, java.time.LocalDateTime invDate, Long invAmt, String counterPartyCrn, String counterPartyName, String inputBranch, String behalfOfBranch, String debitPartyCrn, java.time.LocalDateTime effectiveDate, Long financingAmount, String creditPartyCrn, String creditPartyName, Long spreadRate, Long interestRate, Long marginRate, java.time.LocalDateTime maturityDate, Long penaltyPercent, java.time.LocalDateTime intStartDate, String interestType, String rateType, String baseCode, Long tenorInDays, Long intPeriodInDays, String productType, Long contractPeriod, Long gracePeriod, String limitNode1, String limitNode2, String paymentMode, String beneBranch, String beneAccNo, String status, Integer batchRefID, String remarks, Long advanceInterest, Long netPayment, String valDate, String utrNumber, Long charges, String tiStatus, Integer tiBatchRefID, String tiRemarks, Integer uploadRefID, String entitySubTypeCode, String entityTypeCode, String financeFileGenerated, Integer entityRefID, String financeRemarks, String sellerIDCrn, String buyerIDCrn, String cpRole, String beneLei, Long financeAmount, Integer layoutTemplateID, String layoutName, String valueDate) {

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

        private String fileName;

        private String anchorCrn;

        private String invNo;

        private java.time.LocalDateTime invDate;

        private Long invAmt;

        private String counterPartyCrn;

        private String counterPartyName;

        private String inputBranch;

        private String behalfOfBranch;

        private String debitPartyCrn;

        private java.time.LocalDateTime effectiveDate;

        private Long financingAmount;

        private String creditPartyCrn;

        private String creditPartyName;

        private Long spreadRate;

        private Long interestRate;

        private Long marginRate;

        private java.time.LocalDateTime maturityDate;

        private Long penaltyPercent;

        private java.time.LocalDateTime intStartDate;

        private String interestType;

        private String rateType;

        private String baseCode;

        private Long tenorInDays;

        private Long intPeriodInDays;

        private String productType;

        private Long contractPeriod;

        private Long gracePeriod;

        private String limitNode1;

        private String limitNode2;

        private String paymentMode;

        private String beneBranch;

        private String beneAccNo;

        private String status;

        private Integer batchRefID;

        private String remarks;

        private Long advanceInterest;

        private Long netPayment;

        private String valDate;

        private String utrNumber;

        private Long charges;

        private String tiStatus;

        private Integer tiBatchRefID;

        private String tiRemarks;

        private Integer uploadRefID;

        private String entitySubTypeCode;

        private String entityTypeCode;

        private String financeFileGenerated;

        private Integer entityRefID;

        private String financeRemarks;

        private String sellerIDCrn;

        private String buyerIDCrn;

        private String cpRole;

        private String beneLei;

        private Long financeAmount;

        private Integer layoutTemplateID;

        private String layoutName;

        private String valueDate;

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

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
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

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder financingAmount(Long financingAmount) {
            this.financingAmount = financingAmount;
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

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder marginRate(Long marginRate) {
            this.marginRate = marginRate;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder penaltyPercent(Long penaltyPercent) {
            this.penaltyPercent = penaltyPercent;
            return this;
        }

        public Builder intStartDate(java.time.LocalDateTime intStartDate) {
            this.intStartDate = intStartDate;
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

        public Builder tenorInDays(Long tenorInDays) {
            this.tenorInDays = tenorInDays;
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            this.intPeriodInDays = intPeriodInDays;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            this.contractPeriod = contractPeriod;
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

        public Builder paymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
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

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            this.batchRefID = batchRefID;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
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

        public Builder valDate(String valDate) {
            this.valDate = valDate;
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

        public Builder tiStatus(String tiStatus) {
            this.tiStatus = tiStatus;
            return this;
        }

        public Builder tiBatchRefID(Integer tiBatchRefID) {
            this.tiBatchRefID = tiBatchRefID;
            return this;
        }

        public Builder tiRemarks(String tiRemarks) {
            this.tiRemarks = tiRemarks;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder financeFileGenerated(String financeFileGenerated) {
            this.financeFileGenerated = financeFileGenerated;
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder financeRemarks(String financeRemarks) {
            this.financeRemarks = financeRemarks;
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

        public Builder financeAmount(Long financeAmount) {
            this.financeAmount = financeAmount;
            return this;
        }

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder valueDate(String valueDate) {
            this.valueDate = valueDate;
            return this;
        }

        public FgFinanceTransactions build() {
            return new FgFinanceTransactions(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, fileName, anchorCrn, invNo, invDate, invAmt, counterPartyCrn, counterPartyName, inputBranch, behalfOfBranch, debitPartyCrn, effectiveDate, financingAmount, creditPartyCrn, creditPartyName, spreadRate, interestRate, marginRate, maturityDate, penaltyPercent, intStartDate, interestType, rateType, baseCode, tenorInDays, intPeriodInDays, productType, contractPeriod, gracePeriod, limitNode1, limitNode2, paymentMode, beneBranch, beneAccNo, status, batchRefID, remarks, advanceInterest, netPayment, valDate, utrNumber, charges, tiStatus, tiBatchRefID, tiRemarks, uploadRefID, entitySubTypeCode, entityTypeCode, financeFileGenerated, entityRefID, financeRemarks, sellerIDCrn, buyerIDCrn, cpRole, beneLei, financeAmount, layoutTemplateID, layoutName, valueDate);
        }
    }
}
