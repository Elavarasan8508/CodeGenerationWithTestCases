package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ScfFileTxn {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private String anchorCrn;

    private String fileMasterRefNo;

    private String fileLinesRefNo;

    private String txnNo;

    private java.time.LocalDateTime txnDate;

    private String txnCurrency;

    private java.time.LocalDateTime txnDueDate;

    private java.math.BigDecimal txnAmount;

    private String counterPartyCrn;

    private String counterPartyName;

    private String productType;

    private String inputBranch;

    private String behalfOfBranch;

    private java.math.BigDecimal financeAmount;

    private String debitPartyCrn;

    private java.time.LocalDateTime effectiveDate;

    private java.math.BigDecimal financingAmount;

    private String creditPartyCrn;

    private java.math.BigDecimal interestRate;

    private java.math.BigDecimal marginRate;

    private java.time.LocalDateTime maturityDate;

    private java.math.BigDecimal penaltyPercent;

    private java.time.LocalDateTime interestStartDate;

    private String interestType;

    private java.math.BigDecimal rateType;

    private String baseCode;

    private Long tenor;

    private Long interestPeriod;

    private Long contractPeriod;

    private Long gracePeriod;

    private Integer buyerID;

    private Integer sellerID;

    private String financeRefNo;

    private String paymentType;

    private java.time.LocalDateTime paymentDate;

    private String debitAccNo;

    private java.math.BigDecimal paymentAmount;

    private String beneName;

    private String beneBranch;

    private String utrNumber;

    private java.time.LocalDateTime processingDate;

    private String cmsRefNo;

    private String fileName;

    private String status;

    private String remarks;

    private Integer batchRefID;

    private String limitNode1;

    private String valStatus;

    private String valRemarks;

    private String valReqFilename;

    private Integer valReqEventRefID;

    private String valReqStartTime;

    private String valReqEndTime;

    private String valReqStatus;

    private String valReqRemarks;

    private String valResFilename;

    private Integer valResEventRefID;

    private String valResStartTime;

    private String valResEndTime;

    private String valResStatus;

    private String valResRemarks;

    private String finpayReqFilename;

    private Integer finpayReqEventRefID;

    private String finpayReqStartTime;

    private String finpayReqEndTime;

    private String finpayReqStatus;

    private String finpayReqRemarks;

    private String finpayResFilename;

    private Integer finpayResEventRefID;

    private String finpayResStartTime;

    private String finpayResEndTime;

    private String finpayResStatus;

    private String finpayResRemarks;

    private String finpayEodFilename;

    private Integer finpayEodEventRefID;

    private String finpayEodStartTime;

    private String finpayEodEndTime;

    private String finpayEodStatus;

    private String finpayEodRemarks;

    private String cmsReqFilename;

    private Integer cmsReqEventRefID;

    private String cmsReqStartTime;

    private String cmsReqEndTime;

    private String cmsReqStatus;

    private String cmsReqRemarks;

    private String cmsResFilename;

    private Integer cmsResEventRefID;

    private String cmsResStartTime;

    private String cmsResEndTime;

    private String cmsResStatus;

    private String cmsResRemarks;

    private Integer fbtiReqCorrID;

    private Integer fbtiReqEventRefID;

    private String fbtiReqStartTime;

    private String fbtiReqEndTime;

    private String fbtiReqStatus;

    private String fbtiReqRemarks;

    private Integer fbtiResCorrID;

    private Integer fbtiResEventRefID;

    private String fbtiResStartTime;

    private String fbtiResEndTime;

    private String fbtiResStatus;

    private String fbtiResRemarks;

    private String currentEventName;

    private Integer valLineNo;

    private String valLineContent;

    private String limitNode2;

    private String eodStatus;

    private String finpayLineContent;

    private String valueDate;

    private String paymentMode;

    private String beneAccNo;

    private java.math.BigDecimal netPayment;

    private java.math.BigDecimal advanceInterest;

    private java.math.BigDecimal spreadRate;

    private String anchorName;

    private String sourceOfCreation;

    private java.math.BigDecimal charges;

    private String clientCode;

    private String sourceSystem;

    private String displaySourceSystem;

    private Integer eventFinpayID;

    private java.time.LocalDateTime instrumentDate;

    private String bankCodeIndicator;

    private String beneficiaryCode;

    private String beneficiaryBank;

    private String location;

    private String printLocation;

    private Integer instrumentNumber;

    private String beneficiaryAddress1;

    private String beneficiaryAddress2;

    private String beneficiaryAddress3;

    private String beneficiaryAddress4;

    private String beneficiaryEmail;

    private Long beneficiaryMobile;

    private String debitNarration;

    private String creditNarration;

    private String paymentDetails1;

    private String paymentDetails2;

    private String paymentDetails3;

    private String paymentDetails4;

    private String enrichment1;

    private String enrichment2;

    private String enrichment3;

    private String enrichment4;

    private String enrichment5;

    private String enrichment6;

    private String enrichment7;

    private String enrichment8;

    private String enrichment9;

    private String enrichment10;

    private String enrichment11;

    private String enrichment12;

    private String enrichment13;

    private String enrichment14;

    private String enrichment15;

    private String enrichment16;

    private String enrichment17;

    private String enrichment18;

    private String enrichment19;

    private String enrichment20;

    private java.math.BigDecimal origTxnAmount;

    private String creditPartyName;

    private String counterPartyRole;

    public ScfFileTxn() {
    }

    public ScfFileTxn(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String anchorCrn, String fileMasterRefNo, String fileLinesRefNo, String txnNo, java.time.LocalDateTime txnDate, String txnCurrency, java.time.LocalDateTime txnDueDate, java.math.BigDecimal txnAmount, String counterPartyCrn, String counterPartyName, String productType, String inputBranch, String behalfOfBranch, java.math.BigDecimal financeAmount, String debitPartyCrn, java.time.LocalDateTime effectiveDate, java.math.BigDecimal financingAmount, String creditPartyCrn, java.math.BigDecimal interestRate, java.math.BigDecimal marginRate, java.time.LocalDateTime maturityDate, java.math.BigDecimal penaltyPercent, java.time.LocalDateTime interestStartDate, String interestType, java.math.BigDecimal rateType, String baseCode, Long tenor, Long interestPeriod, Long contractPeriod, Long gracePeriod, Integer buyerID, Integer sellerID, String financeRefNo, String paymentType, java.time.LocalDateTime paymentDate, String debitAccNo, java.math.BigDecimal paymentAmount, String beneName, String beneBranch, String utrNumber, java.time.LocalDateTime processingDate, String cmsRefNo, String fileName, String status, String remarks, Integer batchRefID, String limitNode1, String valStatus, String valRemarks, String valReqFilename, Integer valReqEventRefID, String valReqStartTime, String valReqEndTime, String valReqStatus, String valReqRemarks, String valResFilename, Integer valResEventRefID, String valResStartTime, String valResEndTime, String valResStatus, String valResRemarks, String finpayReqFilename, Integer finpayReqEventRefID, String finpayReqStartTime, String finpayReqEndTime, String finpayReqStatus, String finpayReqRemarks, String finpayResFilename, Integer finpayResEventRefID, String finpayResStartTime, String finpayResEndTime, String finpayResStatus, String finpayResRemarks, String finpayEodFilename, Integer finpayEodEventRefID, String finpayEodStartTime, String finpayEodEndTime, String finpayEodStatus, String finpayEodRemarks, String cmsReqFilename, Integer cmsReqEventRefID, String cmsReqStartTime, String cmsReqEndTime, String cmsReqStatus, String cmsReqRemarks, String cmsResFilename, Integer cmsResEventRefID, String cmsResStartTime, String cmsResEndTime, String cmsResStatus, String cmsResRemarks, Integer fbtiReqCorrID, Integer fbtiReqEventRefID, String fbtiReqStartTime, String fbtiReqEndTime, String fbtiReqStatus, String fbtiReqRemarks, Integer fbtiResCorrID, Integer fbtiResEventRefID, String fbtiResStartTime, String fbtiResEndTime, String fbtiResStatus, String fbtiResRemarks, String currentEventName, Integer valLineNo, String valLineContent, String limitNode2, String eodStatus, String finpayLineContent, String valueDate, String paymentMode, String beneAccNo, java.math.BigDecimal netPayment, java.math.BigDecimal advanceInterest, java.math.BigDecimal spreadRate, String anchorName, String sourceOfCreation, java.math.BigDecimal charges, String clientCode, String sourceSystem, String displaySourceSystem, Integer eventFinpayID, java.time.LocalDateTime instrumentDate, String bankCodeIndicator, String beneficiaryCode, String beneficiaryBank, String location, String printLocation, Integer instrumentNumber, String beneficiaryAddress1, String beneficiaryAddress2, String beneficiaryAddress3, String beneficiaryAddress4, String beneficiaryEmail, Long beneficiaryMobile, String debitNarration, String creditNarration, String paymentDetails1, String paymentDetails2, String paymentDetails3, String paymentDetails4, String enrichment1, String enrichment2, String enrichment3, String enrichment4, String enrichment5, String enrichment6, String enrichment7, String enrichment8, String enrichment9, String enrichment10, String enrichment11, String enrichment12, String enrichment13, String enrichment14, String enrichment15, String enrichment16, String enrichment17, String enrichment18, String enrichment19, String enrichment20, java.math.BigDecimal origTxnAmount, String creditPartyName, String counterPartyRole) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.anchorCrn = anchorCrn;
        this.fileMasterRefNo = fileMasterRefNo;
        this.fileLinesRefNo = fileLinesRefNo;
        this.txnNo = txnNo;
        this.txnDate = txnDate;
        this.txnCurrency = txnCurrency;
        this.txnDueDate = txnDueDate;
        this.txnAmount = txnAmount;
        this.counterPartyCrn = counterPartyCrn;
        this.counterPartyName = counterPartyName;
        this.productType = productType;
        this.inputBranch = inputBranch;
        this.behalfOfBranch = behalfOfBranch;
        this.financeAmount = financeAmount;
        this.debitPartyCrn = debitPartyCrn;
        this.effectiveDate = effectiveDate;
        this.financingAmount = financingAmount;
        this.creditPartyCrn = creditPartyCrn;
        this.interestRate = interestRate;
        this.marginRate = marginRate;
        this.maturityDate = maturityDate;
        this.penaltyPercent = penaltyPercent;
        this.interestStartDate = interestStartDate;
        this.interestType = interestType;
        this.rateType = rateType;
        this.baseCode = baseCode;
        this.tenor = tenor;
        this.interestPeriod = interestPeriod;
        this.contractPeriod = contractPeriod;
        this.gracePeriod = gracePeriod;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.financeRefNo = financeRefNo;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
        this.debitAccNo = debitAccNo;
        this.paymentAmount = paymentAmount;
        this.beneName = beneName;
        this.beneBranch = beneBranch;
        this.utrNumber = utrNumber;
        this.processingDate = processingDate;
        this.cmsRefNo = cmsRefNo;
        this.fileName = fileName;
        this.status = status;
        this.remarks = remarks;
        this.batchRefID = batchRefID;
        this.limitNode1 = limitNode1;
        this.valStatus = valStatus;
        this.valRemarks = valRemarks;
        this.valReqFilename = valReqFilename;
        this.valReqEventRefID = valReqEventRefID;
        this.valReqStartTime = valReqStartTime;
        this.valReqEndTime = valReqEndTime;
        this.valReqStatus = valReqStatus;
        this.valReqRemarks = valReqRemarks;
        this.valResFilename = valResFilename;
        this.valResEventRefID = valResEventRefID;
        this.valResStartTime = valResStartTime;
        this.valResEndTime = valResEndTime;
        this.valResStatus = valResStatus;
        this.valResRemarks = valResRemarks;
        this.finpayReqFilename = finpayReqFilename;
        this.finpayReqEventRefID = finpayReqEventRefID;
        this.finpayReqStartTime = finpayReqStartTime;
        this.finpayReqEndTime = finpayReqEndTime;
        this.finpayReqStatus = finpayReqStatus;
        this.finpayReqRemarks = finpayReqRemarks;
        this.finpayResFilename = finpayResFilename;
        this.finpayResEventRefID = finpayResEventRefID;
        this.finpayResStartTime = finpayResStartTime;
        this.finpayResEndTime = finpayResEndTime;
        this.finpayResStatus = finpayResStatus;
        this.finpayResRemarks = finpayResRemarks;
        this.finpayEodFilename = finpayEodFilename;
        this.finpayEodEventRefID = finpayEodEventRefID;
        this.finpayEodStartTime = finpayEodStartTime;
        this.finpayEodEndTime = finpayEodEndTime;
        this.finpayEodStatus = finpayEodStatus;
        this.finpayEodRemarks = finpayEodRemarks;
        this.cmsReqFilename = cmsReqFilename;
        this.cmsReqEventRefID = cmsReqEventRefID;
        this.cmsReqStartTime = cmsReqStartTime;
        this.cmsReqEndTime = cmsReqEndTime;
        this.cmsReqStatus = cmsReqStatus;
        this.cmsReqRemarks = cmsReqRemarks;
        this.cmsResFilename = cmsResFilename;
        this.cmsResEventRefID = cmsResEventRefID;
        this.cmsResStartTime = cmsResStartTime;
        this.cmsResEndTime = cmsResEndTime;
        this.cmsResStatus = cmsResStatus;
        this.cmsResRemarks = cmsResRemarks;
        this.fbtiReqCorrID = fbtiReqCorrID;
        this.fbtiReqEventRefID = fbtiReqEventRefID;
        this.fbtiReqStartTime = fbtiReqStartTime;
        this.fbtiReqEndTime = fbtiReqEndTime;
        this.fbtiReqStatus = fbtiReqStatus;
        this.fbtiReqRemarks = fbtiReqRemarks;
        this.fbtiResCorrID = fbtiResCorrID;
        this.fbtiResEventRefID = fbtiResEventRefID;
        this.fbtiResStartTime = fbtiResStartTime;
        this.fbtiResEndTime = fbtiResEndTime;
        this.fbtiResStatus = fbtiResStatus;
        this.fbtiResRemarks = fbtiResRemarks;
        this.currentEventName = currentEventName;
        this.valLineNo = valLineNo;
        this.valLineContent = valLineContent;
        this.limitNode2 = limitNode2;
        this.eodStatus = eodStatus;
        this.finpayLineContent = finpayLineContent;
        this.valueDate = valueDate;
        this.paymentMode = paymentMode;
        this.beneAccNo = beneAccNo;
        this.netPayment = netPayment;
        this.advanceInterest = advanceInterest;
        this.spreadRate = spreadRate;
        this.anchorName = anchorName;
        this.sourceOfCreation = sourceOfCreation;
        this.charges = charges;
        this.clientCode = clientCode;
        this.sourceSystem = sourceSystem;
        this.displaySourceSystem = displaySourceSystem;
        this.eventFinpayID = eventFinpayID;
        this.instrumentDate = instrumentDate;
        this.bankCodeIndicator = bankCodeIndicator;
        this.beneficiaryCode = beneficiaryCode;
        this.beneficiaryBank = beneficiaryBank;
        this.location = location;
        this.printLocation = printLocation;
        this.instrumentNumber = instrumentNumber;
        this.beneficiaryAddress1 = beneficiaryAddress1;
        this.beneficiaryAddress2 = beneficiaryAddress2;
        this.beneficiaryAddress3 = beneficiaryAddress3;
        this.beneficiaryAddress4 = beneficiaryAddress4;
        this.beneficiaryEmail = beneficiaryEmail;
        this.beneficiaryMobile = beneficiaryMobile;
        this.debitNarration = debitNarration;
        this.creditNarration = creditNarration;
        this.paymentDetails1 = paymentDetails1;
        this.paymentDetails2 = paymentDetails2;
        this.paymentDetails3 = paymentDetails3;
        this.paymentDetails4 = paymentDetails4;
        this.enrichment1 = enrichment1;
        this.enrichment2 = enrichment2;
        this.enrichment3 = enrichment3;
        this.enrichment4 = enrichment4;
        this.enrichment5 = enrichment5;
        this.enrichment6 = enrichment6;
        this.enrichment7 = enrichment7;
        this.enrichment8 = enrichment8;
        this.enrichment9 = enrichment9;
        this.enrichment10 = enrichment10;
        this.enrichment11 = enrichment11;
        this.enrichment12 = enrichment12;
        this.enrichment13 = enrichment13;
        this.enrichment14 = enrichment14;
        this.enrichment15 = enrichment15;
        this.enrichment16 = enrichment16;
        this.enrichment17 = enrichment17;
        this.enrichment18 = enrichment18;
        this.enrichment19 = enrichment19;
        this.enrichment20 = enrichment20;
        this.origTxnAmount = origTxnAmount;
        this.creditPartyName = creditPartyName;
        this.counterPartyRole = counterPartyRole;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getAnchorCrn() {
        return anchorCrn;
    }

    public void setAnchorCrn(String anchorCrn) {
        this.anchorCrn = anchorCrn;
    }

    public String getFileMasterRefNo() {
        return fileMasterRefNo;
    }

    public void setFileMasterRefNo(String fileMasterRefNo) {
        this.fileMasterRefNo = fileMasterRefNo;
    }

    public String getFileLinesRefNo() {
        return fileLinesRefNo;
    }

    public void setFileLinesRefNo(String fileLinesRefNo) {
        this.fileLinesRefNo = fileLinesRefNo;
    }

    public String getTxnNo() {
        return txnNo;
    }

    public void setTxnNo(String txnNo) {
        this.txnNo = txnNo;
    }

    public java.time.LocalDateTime getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(java.time.LocalDateTime txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnCurrency() {
        return txnCurrency;
    }

    public void setTxnCurrency(String txnCurrency) {
        this.txnCurrency = txnCurrency;
    }

    public java.time.LocalDateTime getTxnDueDate() {
        return txnDueDate;
    }

    public void setTxnDueDate(java.time.LocalDateTime txnDueDate) {
        this.txnDueDate = txnDueDate;
    }

    public java.math.BigDecimal getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(java.math.BigDecimal txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getCounterPartyCrn() {
        return counterPartyCrn;
    }

    public void setCounterPartyCrn(String counterPartyCrn) {
        this.counterPartyCrn = counterPartyCrn;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public void setCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getInputBranch() {
        return inputBranch;
    }

    public void setInputBranch(String inputBranch) {
        this.inputBranch = inputBranch;
    }

    public String getBehalfOfBranch() {
        return behalfOfBranch;
    }

    public void setBehalfOfBranch(String behalfOfBranch) {
        this.behalfOfBranch = behalfOfBranch;
    }

    public java.math.BigDecimal getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(java.math.BigDecimal financeAmount) {
        this.financeAmount = financeAmount;
    }

    public String getDebitPartyCrn() {
        return debitPartyCrn;
    }

    public void setDebitPartyCrn(String debitPartyCrn) {
        this.debitPartyCrn = debitPartyCrn;
    }

    public java.time.LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public java.math.BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(java.math.BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getCreditPartyCrn() {
        return creditPartyCrn;
    }

    public void setCreditPartyCrn(String creditPartyCrn) {
        this.creditPartyCrn = creditPartyCrn;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public java.math.BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(java.math.BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.math.BigDecimal getPenaltyPercent() {
        return penaltyPercent;
    }

    public void setPenaltyPercent(java.math.BigDecimal penaltyPercent) {
        this.penaltyPercent = penaltyPercent;
    }

    public java.time.LocalDateTime getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(java.time.LocalDateTime interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public java.math.BigDecimal getRateType() {
        return rateType;
    }

    public void setRateType(java.math.BigDecimal rateType) {
        this.rateType = rateType;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Long getTenor() {
        return tenor;
    }

    public void setTenor(Long tenor) {
        this.tenor = tenor;
    }

    public Long getInterestPeriod() {
        return interestPeriod;
    }

    public void setInterestPeriod(Long interestPeriod) {
        this.interestPeriod = interestPeriod;
    }

    public Long getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Long contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Long getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Long gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Integer getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public String getFinanceRefNo() {
        return financeRefNo;
    }

    public void setFinanceRefNo(String financeRefNo) {
        this.financeRefNo = financeRefNo;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public java.time.LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(java.time.LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDebitAccNo() {
        return debitAccNo;
    }

    public void setDebitAccNo(String debitAccNo) {
        this.debitAccNo = debitAccNo;
    }

    public java.math.BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(java.math.BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getBeneName() {
        return beneName;
    }

    public void setBeneName(String beneName) {
        this.beneName = beneName;
    }

    public String getBeneBranch() {
        return beneBranch;
    }

    public void setBeneBranch(String beneBranch) {
        this.beneBranch = beneBranch;
    }

    public String getUtrNumber() {
        return utrNumber;
    }

    public void setUtrNumber(String utrNumber) {
        this.utrNumber = utrNumber;
    }

    public java.time.LocalDateTime getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(java.time.LocalDateTime processingDate) {
        this.processingDate = processingDate;
    }

    public String getCmsRefNo() {
        return cmsRefNo;
    }

    public void setCmsRefNo(String cmsRefNo) {
        this.cmsRefNo = cmsRefNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBatchRefID() {
        return batchRefID;
    }

    public void setBatchRefID(Integer batchRefID) {
        this.batchRefID = batchRefID;
    }

    public String getLimitNode1() {
        return limitNode1;
    }

    public void setLimitNode1(String limitNode1) {
        this.limitNode1 = limitNode1;
    }

    public String getValStatus() {
        return valStatus;
    }

    public void setValStatus(String valStatus) {
        this.valStatus = valStatus;
    }

    public String getValRemarks() {
        return valRemarks;
    }

    public void setValRemarks(String valRemarks) {
        this.valRemarks = valRemarks;
    }

    public String getValReqFilename() {
        return valReqFilename;
    }

    public void setValReqFilename(String valReqFilename) {
        this.valReqFilename = valReqFilename;
    }

    public Integer getValReqEventRefID() {
        return valReqEventRefID;
    }

    public void setValReqEventRefID(Integer valReqEventRefID) {
        this.valReqEventRefID = valReqEventRefID;
    }

    public String getValReqStartTime() {
        return valReqStartTime;
    }

    public void setValReqStartTime(String valReqStartTime) {
        this.valReqStartTime = valReqStartTime;
    }

    public String getValReqEndTime() {
        return valReqEndTime;
    }

    public void setValReqEndTime(String valReqEndTime) {
        this.valReqEndTime = valReqEndTime;
    }

    public String getValReqStatus() {
        return valReqStatus;
    }

    public void setValReqStatus(String valReqStatus) {
        this.valReqStatus = valReqStatus;
    }

    public String getValReqRemarks() {
        return valReqRemarks;
    }

    public void setValReqRemarks(String valReqRemarks) {
        this.valReqRemarks = valReqRemarks;
    }

    public String getValResFilename() {
        return valResFilename;
    }

    public void setValResFilename(String valResFilename) {
        this.valResFilename = valResFilename;
    }

    public Integer getValResEventRefID() {
        return valResEventRefID;
    }

    public void setValResEventRefID(Integer valResEventRefID) {
        this.valResEventRefID = valResEventRefID;
    }

    public String getValResStartTime() {
        return valResStartTime;
    }

    public void setValResStartTime(String valResStartTime) {
        this.valResStartTime = valResStartTime;
    }

    public String getValResEndTime() {
        return valResEndTime;
    }

    public void setValResEndTime(String valResEndTime) {
        this.valResEndTime = valResEndTime;
    }

    public String getValResStatus() {
        return valResStatus;
    }

    public void setValResStatus(String valResStatus) {
        this.valResStatus = valResStatus;
    }

    public String getValResRemarks() {
        return valResRemarks;
    }

    public void setValResRemarks(String valResRemarks) {
        this.valResRemarks = valResRemarks;
    }

    public String getFinpayReqFilename() {
        return finpayReqFilename;
    }

    public void setFinpayReqFilename(String finpayReqFilename) {
        this.finpayReqFilename = finpayReqFilename;
    }

    public Integer getFinpayReqEventRefID() {
        return finpayReqEventRefID;
    }

    public void setFinpayReqEventRefID(Integer finpayReqEventRefID) {
        this.finpayReqEventRefID = finpayReqEventRefID;
    }

    public String getFinpayReqStartTime() {
        return finpayReqStartTime;
    }

    public void setFinpayReqStartTime(String finpayReqStartTime) {
        this.finpayReqStartTime = finpayReqStartTime;
    }

    public String getFinpayReqEndTime() {
        return finpayReqEndTime;
    }

    public void setFinpayReqEndTime(String finpayReqEndTime) {
        this.finpayReqEndTime = finpayReqEndTime;
    }

    public String getFinpayReqStatus() {
        return finpayReqStatus;
    }

    public void setFinpayReqStatus(String finpayReqStatus) {
        this.finpayReqStatus = finpayReqStatus;
    }

    public String getFinpayReqRemarks() {
        return finpayReqRemarks;
    }

    public void setFinpayReqRemarks(String finpayReqRemarks) {
        this.finpayReqRemarks = finpayReqRemarks;
    }

    public String getFinpayResFilename() {
        return finpayResFilename;
    }

    public void setFinpayResFilename(String finpayResFilename) {
        this.finpayResFilename = finpayResFilename;
    }

    public Integer getFinpayResEventRefID() {
        return finpayResEventRefID;
    }

    public void setFinpayResEventRefID(Integer finpayResEventRefID) {
        this.finpayResEventRefID = finpayResEventRefID;
    }

    public String getFinpayResStartTime() {
        return finpayResStartTime;
    }

    public void setFinpayResStartTime(String finpayResStartTime) {
        this.finpayResStartTime = finpayResStartTime;
    }

    public String getFinpayResEndTime() {
        return finpayResEndTime;
    }

    public void setFinpayResEndTime(String finpayResEndTime) {
        this.finpayResEndTime = finpayResEndTime;
    }

    public String getFinpayResStatus() {
        return finpayResStatus;
    }

    public void setFinpayResStatus(String finpayResStatus) {
        this.finpayResStatus = finpayResStatus;
    }

    public String getFinpayResRemarks() {
        return finpayResRemarks;
    }

    public void setFinpayResRemarks(String finpayResRemarks) {
        this.finpayResRemarks = finpayResRemarks;
    }

    public String getFinpayEodFilename() {
        return finpayEodFilename;
    }

    public void setFinpayEodFilename(String finpayEodFilename) {
        this.finpayEodFilename = finpayEodFilename;
    }

    public Integer getFinpayEodEventRefID() {
        return finpayEodEventRefID;
    }

    public void setFinpayEodEventRefID(Integer finpayEodEventRefID) {
        this.finpayEodEventRefID = finpayEodEventRefID;
    }

    public String getFinpayEodStartTime() {
        return finpayEodStartTime;
    }

    public void setFinpayEodStartTime(String finpayEodStartTime) {
        this.finpayEodStartTime = finpayEodStartTime;
    }

    public String getFinpayEodEndTime() {
        return finpayEodEndTime;
    }

    public void setFinpayEodEndTime(String finpayEodEndTime) {
        this.finpayEodEndTime = finpayEodEndTime;
    }

    public String getFinpayEodStatus() {
        return finpayEodStatus;
    }

    public void setFinpayEodStatus(String finpayEodStatus) {
        this.finpayEodStatus = finpayEodStatus;
    }

    public String getFinpayEodRemarks() {
        return finpayEodRemarks;
    }

    public void setFinpayEodRemarks(String finpayEodRemarks) {
        this.finpayEodRemarks = finpayEodRemarks;
    }

    public String getCmsReqFilename() {
        return cmsReqFilename;
    }

    public void setCmsReqFilename(String cmsReqFilename) {
        this.cmsReqFilename = cmsReqFilename;
    }

    public Integer getCmsReqEventRefID() {
        return cmsReqEventRefID;
    }

    public void setCmsReqEventRefID(Integer cmsReqEventRefID) {
        this.cmsReqEventRefID = cmsReqEventRefID;
    }

    public String getCmsReqStartTime() {
        return cmsReqStartTime;
    }

    public void setCmsReqStartTime(String cmsReqStartTime) {
        this.cmsReqStartTime = cmsReqStartTime;
    }

    public String getCmsReqEndTime() {
        return cmsReqEndTime;
    }

    public void setCmsReqEndTime(String cmsReqEndTime) {
        this.cmsReqEndTime = cmsReqEndTime;
    }

    public String getCmsReqStatus() {
        return cmsReqStatus;
    }

    public void setCmsReqStatus(String cmsReqStatus) {
        this.cmsReqStatus = cmsReqStatus;
    }

    public String getCmsReqRemarks() {
        return cmsReqRemarks;
    }

    public void setCmsReqRemarks(String cmsReqRemarks) {
        this.cmsReqRemarks = cmsReqRemarks;
    }

    public String getCmsResFilename() {
        return cmsResFilename;
    }

    public void setCmsResFilename(String cmsResFilename) {
        this.cmsResFilename = cmsResFilename;
    }

    public Integer getCmsResEventRefID() {
        return cmsResEventRefID;
    }

    public void setCmsResEventRefID(Integer cmsResEventRefID) {
        this.cmsResEventRefID = cmsResEventRefID;
    }

    public String getCmsResStartTime() {
        return cmsResStartTime;
    }

    public void setCmsResStartTime(String cmsResStartTime) {
        this.cmsResStartTime = cmsResStartTime;
    }

    public String getCmsResEndTime() {
        return cmsResEndTime;
    }

    public void setCmsResEndTime(String cmsResEndTime) {
        this.cmsResEndTime = cmsResEndTime;
    }

    public String getCmsResStatus() {
        return cmsResStatus;
    }

    public void setCmsResStatus(String cmsResStatus) {
        this.cmsResStatus = cmsResStatus;
    }

    public String getCmsResRemarks() {
        return cmsResRemarks;
    }

    public void setCmsResRemarks(String cmsResRemarks) {
        this.cmsResRemarks = cmsResRemarks;
    }

    public Integer getFbtiReqCorrID() {
        return fbtiReqCorrID;
    }

    public void setFbtiReqCorrID(Integer fbtiReqCorrID) {
        this.fbtiReqCorrID = fbtiReqCorrID;
    }

    public Integer getFbtiReqEventRefID() {
        return fbtiReqEventRefID;
    }

    public void setFbtiReqEventRefID(Integer fbtiReqEventRefID) {
        this.fbtiReqEventRefID = fbtiReqEventRefID;
    }

    public String getFbtiReqStartTime() {
        return fbtiReqStartTime;
    }

    public void setFbtiReqStartTime(String fbtiReqStartTime) {
        this.fbtiReqStartTime = fbtiReqStartTime;
    }

    public String getFbtiReqEndTime() {
        return fbtiReqEndTime;
    }

    public void setFbtiReqEndTime(String fbtiReqEndTime) {
        this.fbtiReqEndTime = fbtiReqEndTime;
    }

    public String getFbtiReqStatus() {
        return fbtiReqStatus;
    }

    public void setFbtiReqStatus(String fbtiReqStatus) {
        this.fbtiReqStatus = fbtiReqStatus;
    }

    public String getFbtiReqRemarks() {
        return fbtiReqRemarks;
    }

    public void setFbtiReqRemarks(String fbtiReqRemarks) {
        this.fbtiReqRemarks = fbtiReqRemarks;
    }

    public Integer getFbtiResCorrID() {
        return fbtiResCorrID;
    }

    public void setFbtiResCorrID(Integer fbtiResCorrID) {
        this.fbtiResCorrID = fbtiResCorrID;
    }

    public Integer getFbtiResEventRefID() {
        return fbtiResEventRefID;
    }

    public void setFbtiResEventRefID(Integer fbtiResEventRefID) {
        this.fbtiResEventRefID = fbtiResEventRefID;
    }

    public String getFbtiResStartTime() {
        return fbtiResStartTime;
    }

    public void setFbtiResStartTime(String fbtiResStartTime) {
        this.fbtiResStartTime = fbtiResStartTime;
    }

    public String getFbtiResEndTime() {
        return fbtiResEndTime;
    }

    public void setFbtiResEndTime(String fbtiResEndTime) {
        this.fbtiResEndTime = fbtiResEndTime;
    }

    public String getFbtiResStatus() {
        return fbtiResStatus;
    }

    public void setFbtiResStatus(String fbtiResStatus) {
        this.fbtiResStatus = fbtiResStatus;
    }

    public String getFbtiResRemarks() {
        return fbtiResRemarks;
    }

    public void setFbtiResRemarks(String fbtiResRemarks) {
        this.fbtiResRemarks = fbtiResRemarks;
    }

    public String getCurrentEventName() {
        return currentEventName;
    }

    public void setCurrentEventName(String currentEventName) {
        this.currentEventName = currentEventName;
    }

    public Integer getValLineNo() {
        return valLineNo;
    }

    public void setValLineNo(Integer valLineNo) {
        this.valLineNo = valLineNo;
    }

    public String getValLineContent() {
        return valLineContent;
    }

    public void setValLineContent(String valLineContent) {
        this.valLineContent = valLineContent;
    }

    public String getLimitNode2() {
        return limitNode2;
    }

    public void setLimitNode2(String limitNode2) {
        this.limitNode2 = limitNode2;
    }

    public String getEodStatus() {
        return eodStatus;
    }

    public void setEodStatus(String eodStatus) {
        this.eodStatus = eodStatus;
    }

    public String getFinpayLineContent() {
        return finpayLineContent;
    }

    public void setFinpayLineContent(String finpayLineContent) {
        this.finpayLineContent = finpayLineContent;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBeneAccNo() {
        return beneAccNo;
    }

    public void setBeneAccNo(String beneAccNo) {
        this.beneAccNo = beneAccNo;
    }

    public java.math.BigDecimal getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(java.math.BigDecimal netPayment) {
        this.netPayment = netPayment;
    }

    public java.math.BigDecimal getAdvanceInterest() {
        return advanceInterest;
    }

    public void setAdvanceInterest(java.math.BigDecimal advanceInterest) {
        this.advanceInterest = advanceInterest;
    }

    public java.math.BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(java.math.BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public String getSourceOfCreation() {
        return sourceOfCreation;
    }

    public void setSourceOfCreation(String sourceOfCreation) {
        this.sourceOfCreation = sourceOfCreation;
    }

    public java.math.BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(java.math.BigDecimal charges) {
        this.charges = charges;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getDisplaySourceSystem() {
        return displaySourceSystem;
    }

    public void setDisplaySourceSystem(String displaySourceSystem) {
        this.displaySourceSystem = displaySourceSystem;
    }

    public Integer getEventFinpayID() {
        return eventFinpayID;
    }

    public void setEventFinpayID(Integer eventFinpayID) {
        this.eventFinpayID = eventFinpayID;
    }

    public java.time.LocalDateTime getInstrumentDate() {
        return instrumentDate;
    }

    public void setInstrumentDate(java.time.LocalDateTime instrumentDate) {
        this.instrumentDate = instrumentDate;
    }

    public String getBankCodeIndicator() {
        return bankCodeIndicator;
    }

    public void setBankCodeIndicator(String bankCodeIndicator) {
        this.bankCodeIndicator = bankCodeIndicator;
    }

    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(String beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public String getBeneficiaryBank() {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(String beneficiaryBank) {
        this.beneficiaryBank = beneficiaryBank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrintLocation() {
        return printLocation;
    }

    public void setPrintLocation(String printLocation) {
        this.printLocation = printLocation;
    }

    public Integer getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(Integer instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public String getBeneficiaryAddress1() {
        return beneficiaryAddress1;
    }

    public void setBeneficiaryAddress1(String beneficiaryAddress1) {
        this.beneficiaryAddress1 = beneficiaryAddress1;
    }

    public String getBeneficiaryAddress2() {
        return beneficiaryAddress2;
    }

    public void setBeneficiaryAddress2(String beneficiaryAddress2) {
        this.beneficiaryAddress2 = beneficiaryAddress2;
    }

    public String getBeneficiaryAddress3() {
        return beneficiaryAddress3;
    }

    public void setBeneficiaryAddress3(String beneficiaryAddress3) {
        this.beneficiaryAddress3 = beneficiaryAddress3;
    }

    public String getBeneficiaryAddress4() {
        return beneficiaryAddress4;
    }

    public void setBeneficiaryAddress4(String beneficiaryAddress4) {
        this.beneficiaryAddress4 = beneficiaryAddress4;
    }

    public String getBeneficiaryEmail() {
        return beneficiaryEmail;
    }

    public void setBeneficiaryEmail(String beneficiaryEmail) {
        this.beneficiaryEmail = beneficiaryEmail;
    }

    public Long getBeneficiaryMobile() {
        return beneficiaryMobile;
    }

    public void setBeneficiaryMobile(Long beneficiaryMobile) {
        this.beneficiaryMobile = beneficiaryMobile;
    }

    public String getDebitNarration() {
        return debitNarration;
    }

    public void setDebitNarration(String debitNarration) {
        this.debitNarration = debitNarration;
    }

    public String getCreditNarration() {
        return creditNarration;
    }

    public void setCreditNarration(String creditNarration) {
        this.creditNarration = creditNarration;
    }

    public String getPaymentDetails1() {
        return paymentDetails1;
    }

    public void setPaymentDetails1(String paymentDetails1) {
        this.paymentDetails1 = paymentDetails1;
    }

    public String getPaymentDetails2() {
        return paymentDetails2;
    }

    public void setPaymentDetails2(String paymentDetails2) {
        this.paymentDetails2 = paymentDetails2;
    }

    public String getPaymentDetails3() {
        return paymentDetails3;
    }

    public void setPaymentDetails3(String paymentDetails3) {
        this.paymentDetails3 = paymentDetails3;
    }

    public String getPaymentDetails4() {
        return paymentDetails4;
    }

    public void setPaymentDetails4(String paymentDetails4) {
        this.paymentDetails4 = paymentDetails4;
    }

    public String getEnrichment1() {
        return enrichment1;
    }

    public void setEnrichment1(String enrichment1) {
        this.enrichment1 = enrichment1;
    }

    public String getEnrichment2() {
        return enrichment2;
    }

    public void setEnrichment2(String enrichment2) {
        this.enrichment2 = enrichment2;
    }

    public String getEnrichment3() {
        return enrichment3;
    }

    public void setEnrichment3(String enrichment3) {
        this.enrichment3 = enrichment3;
    }

    public String getEnrichment4() {
        return enrichment4;
    }

    public void setEnrichment4(String enrichment4) {
        this.enrichment4 = enrichment4;
    }

    public String getEnrichment5() {
        return enrichment5;
    }

    public void setEnrichment5(String enrichment5) {
        this.enrichment5 = enrichment5;
    }

    public String getEnrichment6() {
        return enrichment6;
    }

    public void setEnrichment6(String enrichment6) {
        this.enrichment6 = enrichment6;
    }

    public String getEnrichment7() {
        return enrichment7;
    }

    public void setEnrichment7(String enrichment7) {
        this.enrichment7 = enrichment7;
    }

    public String getEnrichment8() {
        return enrichment8;
    }

    public void setEnrichment8(String enrichment8) {
        this.enrichment8 = enrichment8;
    }

    public String getEnrichment9() {
        return enrichment9;
    }

    public void setEnrichment9(String enrichment9) {
        this.enrichment9 = enrichment9;
    }

    public String getEnrichment10() {
        return enrichment10;
    }

    public void setEnrichment10(String enrichment10) {
        this.enrichment10 = enrichment10;
    }

    public String getEnrichment11() {
        return enrichment11;
    }

    public void setEnrichment11(String enrichment11) {
        this.enrichment11 = enrichment11;
    }

    public String getEnrichment12() {
        return enrichment12;
    }

    public void setEnrichment12(String enrichment12) {
        this.enrichment12 = enrichment12;
    }

    public String getEnrichment13() {
        return enrichment13;
    }

    public void setEnrichment13(String enrichment13) {
        this.enrichment13 = enrichment13;
    }

    public String getEnrichment14() {
        return enrichment14;
    }

    public void setEnrichment14(String enrichment14) {
        this.enrichment14 = enrichment14;
    }

    public String getEnrichment15() {
        return enrichment15;
    }

    public void setEnrichment15(String enrichment15) {
        this.enrichment15 = enrichment15;
    }

    public String getEnrichment16() {
        return enrichment16;
    }

    public void setEnrichment16(String enrichment16) {
        this.enrichment16 = enrichment16;
    }

    public String getEnrichment17() {
        return enrichment17;
    }

    public void setEnrichment17(String enrichment17) {
        this.enrichment17 = enrichment17;
    }

    public String getEnrichment18() {
        return enrichment18;
    }

    public void setEnrichment18(String enrichment18) {
        this.enrichment18 = enrichment18;
    }

    public String getEnrichment19() {
        return enrichment19;
    }

    public void setEnrichment19(String enrichment19) {
        this.enrichment19 = enrichment19;
    }

    public String getEnrichment20() {
        return enrichment20;
    }

    public void setEnrichment20(String enrichment20) {
        this.enrichment20 = enrichment20;
    }

    public java.math.BigDecimal getOrigTxnAmount() {
        return origTxnAmount;
    }

    public void setOrigTxnAmount(java.math.BigDecimal origTxnAmount) {
        this.origTxnAmount = origTxnAmount;
    }

    public String getCreditPartyName() {
        return creditPartyName;
    }

    public void setCreditPartyName(String creditPartyName) {
        this.creditPartyName = creditPartyName;
    }

    public String getCounterPartyRole() {
        return counterPartyRole;
    }

    public void setCounterPartyRole(String counterPartyRole) {
        this.counterPartyRole = counterPartyRole;
    }

    public static class Builder {

        private ScfFileTxn instance = new ScfFileTxn();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            instance.setAnchorCrn(anchorCrn);
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            instance.setFileMasterRefNo(fileMasterRefNo);
            return this;
        }

        public Builder fileLinesRefNo(String fileLinesRefNo) {
            instance.setFileLinesRefNo(fileLinesRefNo);
            return this;
        }

        public Builder txnNo(String txnNo) {
            instance.setTxnNo(txnNo);
            return this;
        }

        public Builder txnDate(java.time.LocalDateTime txnDate) {
            instance.setTxnDate(txnDate);
            return this;
        }

        public Builder txnCurrency(String txnCurrency) {
            instance.setTxnCurrency(txnCurrency);
            return this;
        }

        public Builder txnDueDate(java.time.LocalDateTime txnDueDate) {
            instance.setTxnDueDate(txnDueDate);
            return this;
        }

        public Builder txnAmount(java.math.BigDecimal txnAmount) {
            instance.setTxnAmount(txnAmount);
            return this;
        }

        public Builder counterPartyCrn(String counterPartyCrn) {
            instance.setCounterPartyCrn(counterPartyCrn);
            return this;
        }

        public Builder counterPartyName(String counterPartyName) {
            instance.setCounterPartyName(counterPartyName);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public Builder inputBranch(String inputBranch) {
            instance.setInputBranch(inputBranch);
            return this;
        }

        public Builder behalfOfBranch(String behalfOfBranch) {
            instance.setBehalfOfBranch(behalfOfBranch);
            return this;
        }

        public Builder financeAmount(java.math.BigDecimal financeAmount) {
            instance.setFinanceAmount(financeAmount);
            return this;
        }

        public Builder debitPartyCrn(String debitPartyCrn) {
            instance.setDebitPartyCrn(debitPartyCrn);
            return this;
        }

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            instance.setEffectiveDate(effectiveDate);
            return this;
        }

        public Builder financingAmount(java.math.BigDecimal financingAmount) {
            instance.setFinancingAmount(financingAmount);
            return this;
        }

        public Builder creditPartyCrn(String creditPartyCrn) {
            instance.setCreditPartyCrn(creditPartyCrn);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder marginRate(java.math.BigDecimal marginRate) {
            instance.setMarginRate(marginRate);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder penaltyPercent(java.math.BigDecimal penaltyPercent) {
            instance.setPenaltyPercent(penaltyPercent);
            return this;
        }

        public Builder interestStartDate(java.time.LocalDateTime interestStartDate) {
            instance.setInterestStartDate(interestStartDate);
            return this;
        }

        public Builder interestType(String interestType) {
            instance.setInterestType(interestType);
            return this;
        }

        public Builder rateType(java.math.BigDecimal rateType) {
            instance.setRateType(rateType);
            return this;
        }

        public Builder baseCode(String baseCode) {
            instance.setBaseCode(baseCode);
            return this;
        }

        public Builder tenor(Long tenor) {
            instance.setTenor(tenor);
            return this;
        }

        public Builder interestPeriod(Long interestPeriod) {
            instance.setInterestPeriod(interestPeriod);
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            instance.setContractPeriod(contractPeriod);
            return this;
        }

        public Builder gracePeriod(Long gracePeriod) {
            instance.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder buyerID(Integer buyerID) {
            instance.setBuyerID(buyerID);
            return this;
        }

        public Builder sellerID(Integer sellerID) {
            instance.setSellerID(sellerID);
            return this;
        }

        public Builder financeRefNo(String financeRefNo) {
            instance.setFinanceRefNo(financeRefNo);
            return this;
        }

        public Builder paymentType(String paymentType) {
            instance.setPaymentType(paymentType);
            return this;
        }

        public Builder paymentDate(java.time.LocalDateTime paymentDate) {
            instance.setPaymentDate(paymentDate);
            return this;
        }

        public Builder debitAccNo(String debitAccNo) {
            instance.setDebitAccNo(debitAccNo);
            return this;
        }

        public Builder paymentAmount(java.math.BigDecimal paymentAmount) {
            instance.setPaymentAmount(paymentAmount);
            return this;
        }

        public Builder beneName(String beneName) {
            instance.setBeneName(beneName);
            return this;
        }

        public Builder beneBranch(String beneBranch) {
            instance.setBeneBranch(beneBranch);
            return this;
        }

        public Builder utrNumber(String utrNumber) {
            instance.setUtrNumber(utrNumber);
            return this;
        }

        public Builder processingDate(java.time.LocalDateTime processingDate) {
            instance.setProcessingDate(processingDate);
            return this;
        }

        public Builder cmsRefNo(String cmsRefNo) {
            instance.setCmsRefNo(cmsRefNo);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            instance.setBatchRefID(batchRefID);
            return this;
        }

        public Builder limitNode1(String limitNode1) {
            instance.setLimitNode1(limitNode1);
            return this;
        }

        public Builder valStatus(String valStatus) {
            instance.setValStatus(valStatus);
            return this;
        }

        public Builder valRemarks(String valRemarks) {
            instance.setValRemarks(valRemarks);
            return this;
        }

        public Builder valReqFilename(String valReqFilename) {
            instance.setValReqFilename(valReqFilename);
            return this;
        }

        public Builder valReqEventRefID(Integer valReqEventRefID) {
            instance.setValReqEventRefID(valReqEventRefID);
            return this;
        }

        public Builder valReqStartTime(String valReqStartTime) {
            instance.setValReqStartTime(valReqStartTime);
            return this;
        }

        public Builder valReqEndTime(String valReqEndTime) {
            instance.setValReqEndTime(valReqEndTime);
            return this;
        }

        public Builder valReqStatus(String valReqStatus) {
            instance.setValReqStatus(valReqStatus);
            return this;
        }

        public Builder valReqRemarks(String valReqRemarks) {
            instance.setValReqRemarks(valReqRemarks);
            return this;
        }

        public Builder valResFilename(String valResFilename) {
            instance.setValResFilename(valResFilename);
            return this;
        }

        public Builder valResEventRefID(Integer valResEventRefID) {
            instance.setValResEventRefID(valResEventRefID);
            return this;
        }

        public Builder valResStartTime(String valResStartTime) {
            instance.setValResStartTime(valResStartTime);
            return this;
        }

        public Builder valResEndTime(String valResEndTime) {
            instance.setValResEndTime(valResEndTime);
            return this;
        }

        public Builder valResStatus(String valResStatus) {
            instance.setValResStatus(valResStatus);
            return this;
        }

        public Builder valResRemarks(String valResRemarks) {
            instance.setValResRemarks(valResRemarks);
            return this;
        }

        public Builder finpayReqFilename(String finpayReqFilename) {
            instance.setFinpayReqFilename(finpayReqFilename);
            return this;
        }

        public Builder finpayReqEventRefID(Integer finpayReqEventRefID) {
            instance.setFinpayReqEventRefID(finpayReqEventRefID);
            return this;
        }

        public Builder finpayReqStartTime(String finpayReqStartTime) {
            instance.setFinpayReqStartTime(finpayReqStartTime);
            return this;
        }

        public Builder finpayReqEndTime(String finpayReqEndTime) {
            instance.setFinpayReqEndTime(finpayReqEndTime);
            return this;
        }

        public Builder finpayReqStatus(String finpayReqStatus) {
            instance.setFinpayReqStatus(finpayReqStatus);
            return this;
        }

        public Builder finpayReqRemarks(String finpayReqRemarks) {
            instance.setFinpayReqRemarks(finpayReqRemarks);
            return this;
        }

        public Builder finpayResFilename(String finpayResFilename) {
            instance.setFinpayResFilename(finpayResFilename);
            return this;
        }

        public Builder finpayResEventRefID(Integer finpayResEventRefID) {
            instance.setFinpayResEventRefID(finpayResEventRefID);
            return this;
        }

        public Builder finpayResStartTime(String finpayResStartTime) {
            instance.setFinpayResStartTime(finpayResStartTime);
            return this;
        }

        public Builder finpayResEndTime(String finpayResEndTime) {
            instance.setFinpayResEndTime(finpayResEndTime);
            return this;
        }

        public Builder finpayResStatus(String finpayResStatus) {
            instance.setFinpayResStatus(finpayResStatus);
            return this;
        }

        public Builder finpayResRemarks(String finpayResRemarks) {
            instance.setFinpayResRemarks(finpayResRemarks);
            return this;
        }

        public Builder finpayEodFilename(String finpayEodFilename) {
            instance.setFinpayEodFilename(finpayEodFilename);
            return this;
        }

        public Builder finpayEodEventRefID(Integer finpayEodEventRefID) {
            instance.setFinpayEodEventRefID(finpayEodEventRefID);
            return this;
        }

        public Builder finpayEodStartTime(String finpayEodStartTime) {
            instance.setFinpayEodStartTime(finpayEodStartTime);
            return this;
        }

        public Builder finpayEodEndTime(String finpayEodEndTime) {
            instance.setFinpayEodEndTime(finpayEodEndTime);
            return this;
        }

        public Builder finpayEodStatus(String finpayEodStatus) {
            instance.setFinpayEodStatus(finpayEodStatus);
            return this;
        }

        public Builder finpayEodRemarks(String finpayEodRemarks) {
            instance.setFinpayEodRemarks(finpayEodRemarks);
            return this;
        }

        public Builder cmsReqFilename(String cmsReqFilename) {
            instance.setCmsReqFilename(cmsReqFilename);
            return this;
        }

        public Builder cmsReqEventRefID(Integer cmsReqEventRefID) {
            instance.setCmsReqEventRefID(cmsReqEventRefID);
            return this;
        }

        public Builder cmsReqStartTime(String cmsReqStartTime) {
            instance.setCmsReqStartTime(cmsReqStartTime);
            return this;
        }

        public Builder cmsReqEndTime(String cmsReqEndTime) {
            instance.setCmsReqEndTime(cmsReqEndTime);
            return this;
        }

        public Builder cmsReqStatus(String cmsReqStatus) {
            instance.setCmsReqStatus(cmsReqStatus);
            return this;
        }

        public Builder cmsReqRemarks(String cmsReqRemarks) {
            instance.setCmsReqRemarks(cmsReqRemarks);
            return this;
        }

        public Builder cmsResFilename(String cmsResFilename) {
            instance.setCmsResFilename(cmsResFilename);
            return this;
        }

        public Builder cmsResEventRefID(Integer cmsResEventRefID) {
            instance.setCmsResEventRefID(cmsResEventRefID);
            return this;
        }

        public Builder cmsResStartTime(String cmsResStartTime) {
            instance.setCmsResStartTime(cmsResStartTime);
            return this;
        }

        public Builder cmsResEndTime(String cmsResEndTime) {
            instance.setCmsResEndTime(cmsResEndTime);
            return this;
        }

        public Builder cmsResStatus(String cmsResStatus) {
            instance.setCmsResStatus(cmsResStatus);
            return this;
        }

        public Builder cmsResRemarks(String cmsResRemarks) {
            instance.setCmsResRemarks(cmsResRemarks);
            return this;
        }

        public Builder fbtiReqCorrID(Integer fbtiReqCorrID) {
            instance.setFbtiReqCorrID(fbtiReqCorrID);
            return this;
        }

        public Builder fbtiReqEventRefID(Integer fbtiReqEventRefID) {
            instance.setFbtiReqEventRefID(fbtiReqEventRefID);
            return this;
        }

        public Builder fbtiReqStartTime(String fbtiReqStartTime) {
            instance.setFbtiReqStartTime(fbtiReqStartTime);
            return this;
        }

        public Builder fbtiReqEndTime(String fbtiReqEndTime) {
            instance.setFbtiReqEndTime(fbtiReqEndTime);
            return this;
        }

        public Builder fbtiReqStatus(String fbtiReqStatus) {
            instance.setFbtiReqStatus(fbtiReqStatus);
            return this;
        }

        public Builder fbtiReqRemarks(String fbtiReqRemarks) {
            instance.setFbtiReqRemarks(fbtiReqRemarks);
            return this;
        }

        public Builder fbtiResCorrID(Integer fbtiResCorrID) {
            instance.setFbtiResCorrID(fbtiResCorrID);
            return this;
        }

        public Builder fbtiResEventRefID(Integer fbtiResEventRefID) {
            instance.setFbtiResEventRefID(fbtiResEventRefID);
            return this;
        }

        public Builder fbtiResStartTime(String fbtiResStartTime) {
            instance.setFbtiResStartTime(fbtiResStartTime);
            return this;
        }

        public Builder fbtiResEndTime(String fbtiResEndTime) {
            instance.setFbtiResEndTime(fbtiResEndTime);
            return this;
        }

        public Builder fbtiResStatus(String fbtiResStatus) {
            instance.setFbtiResStatus(fbtiResStatus);
            return this;
        }

        public Builder fbtiResRemarks(String fbtiResRemarks) {
            instance.setFbtiResRemarks(fbtiResRemarks);
            return this;
        }

        public Builder currentEventName(String currentEventName) {
            instance.setCurrentEventName(currentEventName);
            return this;
        }

        public Builder valLineNo(Integer valLineNo) {
            instance.setValLineNo(valLineNo);
            return this;
        }

        public Builder valLineContent(String valLineContent) {
            instance.setValLineContent(valLineContent);
            return this;
        }

        public Builder limitNode2(String limitNode2) {
            instance.setLimitNode2(limitNode2);
            return this;
        }

        public Builder eodStatus(String eodStatus) {
            instance.setEodStatus(eodStatus);
            return this;
        }

        public Builder finpayLineContent(String finpayLineContent) {
            instance.setFinpayLineContent(finpayLineContent);
            return this;
        }

        public Builder valueDate(String valueDate) {
            instance.setValueDate(valueDate);
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            instance.setPaymentMode(paymentMode);
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            instance.setBeneAccNo(beneAccNo);
            return this;
        }

        public Builder netPayment(java.math.BigDecimal netPayment) {
            instance.setNetPayment(netPayment);
            return this;
        }

        public Builder advanceInterest(java.math.BigDecimal advanceInterest) {
            instance.setAdvanceInterest(advanceInterest);
            return this;
        }

        public Builder spreadRate(java.math.BigDecimal spreadRate) {
            instance.setSpreadRate(spreadRate);
            return this;
        }

        public Builder anchorName(String anchorName) {
            instance.setAnchorName(anchorName);
            return this;
        }

        public Builder sourceOfCreation(String sourceOfCreation) {
            instance.setSourceOfCreation(sourceOfCreation);
            return this;
        }

        public Builder charges(java.math.BigDecimal charges) {
            instance.setCharges(charges);
            return this;
        }

        public Builder clientCode(String clientCode) {
            instance.setClientCode(clientCode);
            return this;
        }

        public Builder sourceSystem(String sourceSystem) {
            instance.setSourceSystem(sourceSystem);
            return this;
        }

        public Builder displaySourceSystem(String displaySourceSystem) {
            instance.setDisplaySourceSystem(displaySourceSystem);
            return this;
        }

        public Builder eventFinpayID(Integer eventFinpayID) {
            instance.setEventFinpayID(eventFinpayID);
            return this;
        }

        public Builder instrumentDate(java.time.LocalDateTime instrumentDate) {
            instance.setInstrumentDate(instrumentDate);
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            instance.setBankCodeIndicator(bankCodeIndicator);
            return this;
        }

        public Builder beneficiaryCode(String beneficiaryCode) {
            instance.setBeneficiaryCode(beneficiaryCode);
            return this;
        }

        public Builder beneficiaryBank(String beneficiaryBank) {
            instance.setBeneficiaryBank(beneficiaryBank);
            return this;
        }

        public Builder location(String location) {
            instance.setLocation(location);
            return this;
        }

        public Builder printLocation(String printLocation) {
            instance.setPrintLocation(printLocation);
            return this;
        }

        public Builder instrumentNumber(Integer instrumentNumber) {
            instance.setInstrumentNumber(instrumentNumber);
            return this;
        }

        public Builder beneficiaryAddress1(String beneficiaryAddress1) {
            instance.setBeneficiaryAddress1(beneficiaryAddress1);
            return this;
        }

        public Builder beneficiaryAddress2(String beneficiaryAddress2) {
            instance.setBeneficiaryAddress2(beneficiaryAddress2);
            return this;
        }

        public Builder beneficiaryAddress3(String beneficiaryAddress3) {
            instance.setBeneficiaryAddress3(beneficiaryAddress3);
            return this;
        }

        public Builder beneficiaryAddress4(String beneficiaryAddress4) {
            instance.setBeneficiaryAddress4(beneficiaryAddress4);
            return this;
        }

        public Builder beneficiaryEmail(String beneficiaryEmail) {
            instance.setBeneficiaryEmail(beneficiaryEmail);
            return this;
        }

        public Builder beneficiaryMobile(Long beneficiaryMobile) {
            instance.setBeneficiaryMobile(beneficiaryMobile);
            return this;
        }

        public Builder debitNarration(String debitNarration) {
            instance.setDebitNarration(debitNarration);
            return this;
        }

        public Builder creditNarration(String creditNarration) {
            instance.setCreditNarration(creditNarration);
            return this;
        }

        public Builder paymentDetails1(String paymentDetails1) {
            instance.setPaymentDetails1(paymentDetails1);
            return this;
        }

        public Builder paymentDetails2(String paymentDetails2) {
            instance.setPaymentDetails2(paymentDetails2);
            return this;
        }

        public Builder paymentDetails3(String paymentDetails3) {
            instance.setPaymentDetails3(paymentDetails3);
            return this;
        }

        public Builder paymentDetails4(String paymentDetails4) {
            instance.setPaymentDetails4(paymentDetails4);
            return this;
        }

        public Builder enrichment1(String enrichment1) {
            instance.setEnrichment1(enrichment1);
            return this;
        }

        public Builder enrichment2(String enrichment2) {
            instance.setEnrichment2(enrichment2);
            return this;
        }

        public Builder enrichment3(String enrichment3) {
            instance.setEnrichment3(enrichment3);
            return this;
        }

        public Builder enrichment4(String enrichment4) {
            instance.setEnrichment4(enrichment4);
            return this;
        }

        public Builder enrichment5(String enrichment5) {
            instance.setEnrichment5(enrichment5);
            return this;
        }

        public Builder enrichment6(String enrichment6) {
            instance.setEnrichment6(enrichment6);
            return this;
        }

        public Builder enrichment7(String enrichment7) {
            instance.setEnrichment7(enrichment7);
            return this;
        }

        public Builder enrichment8(String enrichment8) {
            instance.setEnrichment8(enrichment8);
            return this;
        }

        public Builder enrichment9(String enrichment9) {
            instance.setEnrichment9(enrichment9);
            return this;
        }

        public Builder enrichment10(String enrichment10) {
            instance.setEnrichment10(enrichment10);
            return this;
        }

        public Builder enrichment11(String enrichment11) {
            instance.setEnrichment11(enrichment11);
            return this;
        }

        public Builder enrichment12(String enrichment12) {
            instance.setEnrichment12(enrichment12);
            return this;
        }

        public Builder enrichment13(String enrichment13) {
            instance.setEnrichment13(enrichment13);
            return this;
        }

        public Builder enrichment14(String enrichment14) {
            instance.setEnrichment14(enrichment14);
            return this;
        }

        public Builder enrichment15(String enrichment15) {
            instance.setEnrichment15(enrichment15);
            return this;
        }

        public Builder enrichment16(String enrichment16) {
            instance.setEnrichment16(enrichment16);
            return this;
        }

        public Builder enrichment17(String enrichment17) {
            instance.setEnrichment17(enrichment17);
            return this;
        }

        public Builder enrichment18(String enrichment18) {
            instance.setEnrichment18(enrichment18);
            return this;
        }

        public Builder enrichment19(String enrichment19) {
            instance.setEnrichment19(enrichment19);
            return this;
        }

        public Builder enrichment20(String enrichment20) {
            instance.setEnrichment20(enrichment20);
            return this;
        }

        public Builder origTxnAmount(java.math.BigDecimal origTxnAmount) {
            instance.setOrigTxnAmount(origTxnAmount);
            return this;
        }

        public Builder creditPartyName(String creditPartyName) {
            instance.setCreditPartyName(creditPartyName);
            return this;
        }

        public Builder counterPartyRole(String counterPartyRole) {
            instance.setCounterPartyRole(counterPartyRole);
            return this;
        }

        public ScfFileTxn build() {
            return instance;
        }
    }
}
