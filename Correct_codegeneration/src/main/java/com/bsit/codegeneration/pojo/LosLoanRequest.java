package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LosLoanRequest {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String fulfillmentParty;

    private Integer isTemplate;

    private java.math.BigDecimal utilizedAmount;

    private java.math.BigDecimal outstandingAmount;

    private String limitNodeReference;

    private Long requestTenor;

    private String requestStatusCode;

    private java.time.LocalDateTime requestDisbursementDate;

    private String rmPartyReference;

    private Integer parentFacilityLimitID;

    private Integer facilityLimitID;

    private String leiNumber;

    private String leiStatusCode;

    private String interestTypeCode;

    private String offerCode;

    private Long tenorMin;

    private Long tenorMax;

    private String processingModeCode;

    private String resetFrequenctPeriodCode;

    private String loanAccountNumber;

    private java.time.LocalDateTime loanStartDate;

    private java.math.BigDecimal sanctionedAmountCcyCode;

    private java.math.BigDecimal sanctionedAmount;

    private String applicantParty;

    private String sanctionedDate;

    private String disbursementAccount;

    private java.time.LocalDateTime disbursedDate;

    private String settlementAccount;

    private Integer wcdlLimitAvailable;

    private Integer wcdlFacilityValidity;

    private Integer loanOverdueCheck;

    private Integer coolingPeriodCheck;

    private Integer leiAvailableCheck;

    private String internalRatingTypeCode;

    private String internalRatingValue;

    private Integer rarocStatusCheck;

    private Integer rarocFacilityCheck;

    private Integer pslAvailabilityCheck;

    private String flowTypeCode;

    private Integer digitalFlowFlag;

    private String lobCode;

    private String requestDate;

    private String requestCategoryCode;

    private String requestTypeCode;

    private String requestCurrencyCode;

    private java.math.BigDecimal requestAmount;

    private String requestTenorUom;

    private String orgCifCode;

    private String orgUserCifCode;

    private String facilityTypeCode;

    private java.math.BigDecimal rateOfInterest;

    private String tenorUom;

    private String productCode;

    private String subProductCode;

    private String externalRatingTypeCode;

    private String externalRatingValue;

    private String offerTypeCode;

    private String acceptanceParty;

    private String assessmentParty;

    private String productStatusCode;

    private String acceptanceReasonCode;

    private String acceptanceComments;

    private java.time.LocalDateTime acceptanceDate;

    private String assessmentReasonCode;

    private String assessmentComments;

    private java.time.LocalDateTime assessmentDate;

    private String tenureDays;

    private Integer uploadRefID;

    private String routingCode;

    private String routingTypeCode;

    private String bankCode;

    private Integer transactionID;

    private String offerBenchmark;

    private java.math.BigDecimal availableLimit;

    private String priority;

    private String schemeCode;

    private String accountOpeningDate;

    private String notes;

    private String repricingPlan;

    private java.math.BigDecimal rateFixingMethod;

    private java.time.LocalDateTime peggingReviewDate;

    private String peggingFrequency;

    private java.math.BigDecimal interestRateCode;

    private java.math.BigDecimal spread;

    private java.math.BigDecimal customerPreferentialInterest;

    private String penalInterestTableCode;

    private String penalPreferentialPercentage;

    private String holdInOptAccForAmtDue;

    private String repaymentMethod;

    private String recyOnlyIntByAccDebit;

    private Long operativeAccountNo;

    private String huntingRequired;

    private String strucRepaymentSchedule;

    private String equatedInstalment;

    private String noOfInstalment;

    private java.time.LocalDateTime instalmentStartDate;

    private String instalmentFrequency;

    private String interestFrequency;

    private java.time.LocalDateTime instlFrequencyStartDate;

    private java.time.LocalDateTime interestFrequencyStartDate;

    private String moratoriumPeriod;

    private java.time.LocalDateTime moratoriumInterestStartDate;

    private String moratoriumPeriodIntFreq;

    private java.time.LocalDateTime moratoriumIntFreqStartDate;

    private String subsectorCode;

    private String sectorCode;

    private String modeOfAdvance;

    private String rolloverFlag;

    private String disbAuthRemarks;

    private String paymentMode;

    private java.math.BigDecimal amount;

    private String beneficiaryAccountNo;

    private String beneficiaryAccountType;

    private String beneficiaryName;

    private String beneficiaryAddress;

    private String ifscCode;

    private String paymentProduct;

    private java.math.BigDecimal ccyRate;

    private String beneficiaryType;

    private String beneficiaryLeiNumber;

    private String makerTempNo;

    private String amtInWords;

    private java.math.BigDecimal drawingPower;

    private java.math.BigDecimal limitAsPerSystem;

    private String disbTillDtUnderContract;

    private java.math.BigDecimal freeLimitsForDisb;

    private String disbTillDtUnderFacility;

    private java.math.BigDecimal poLimit;

    private java.math.BigDecimal systemFreePoLimit;

    private java.time.LocalDateTime maturityDate;

    private java.math.BigDecimal loanSpread;

    private java.math.BigDecimal minRarocSpread;

    private java.math.BigDecimal minFbilFimmdaSpread;

    private java.time.LocalDateTime brDate;

    private String termSheet;

    private String pricingSheet;

    private String pslUpdation;

    private String pfCollected;

    private String internalConditions;

    private java.math.BigDecimal overdues;

    private String branch;

    private java.math.BigDecimal minLoanAmt;

    private java.math.BigDecimal maxLoanAmt;

    private java.math.BigDecimal sanctionLimit;

    private String operationType;

    private java.time.LocalDateTime uploadedDate;

    private String segmentCode;

    private java.math.BigDecimal disbursementAmount;

    private String remarks;

    private String orgCifName;

    private String segmentTeams;

    private Integer isAcceptLoanAgreement;

    private String recoveryAccountNo;

    private String taskReason;

    private String downloadStatus;

    private String downloadTime;

    private String reverseFileStatus;

    private String endUse;

    private String reverseStatus;

    private String spreadDisplay;

    private String resetFrequency;

    private String resetFreqUom;

    private Integer resetFreqValue;

    private java.math.BigDecimal overallLimit;

    private java.math.BigDecimal gst;

    private java.math.BigDecimal procFee;

    private String benchmark;

    private java.math.BigDecimal roiBenchmark;

    private java.time.LocalDateTime interestStartDate;

    private String alertStatus;

    private String userCrn;

    private String makerTaskConsent;

    private Integer reverseUploadRefID;

    private Integer offerVersionID;

    private String tenureDaysList;

    private String rmName;

    private String amtInWordsReqLetter;

    private String stpStatus;

    public LosLoanRequest() {
    }

    public LosLoanRequest(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String fulfillmentParty, Integer isTemplate, java.math.BigDecimal utilizedAmount, java.math.BigDecimal outstandingAmount, String limitNodeReference, Long requestTenor, String requestStatusCode, java.time.LocalDateTime requestDisbursementDate, String rmPartyReference, Integer parentFacilityLimitID, Integer facilityLimitID, String leiNumber, String leiStatusCode, String interestTypeCode, String offerCode, Long tenorMin, Long tenorMax, String processingModeCode, String resetFrequenctPeriodCode, String loanAccountNumber, java.time.LocalDateTime loanStartDate, java.math.BigDecimal sanctionedAmountCcyCode, java.math.BigDecimal sanctionedAmount, String applicantParty, String sanctionedDate, String disbursementAccount, java.time.LocalDateTime disbursedDate, String settlementAccount, Integer wcdlLimitAvailable, Integer wcdlFacilityValidity, Integer loanOverdueCheck, Integer coolingPeriodCheck, Integer leiAvailableCheck, String internalRatingTypeCode, String internalRatingValue, Integer rarocStatusCheck, Integer rarocFacilityCheck, Integer pslAvailabilityCheck, String flowTypeCode, Integer digitalFlowFlag, String lobCode, String requestDate, String requestCategoryCode, String requestTypeCode, String requestCurrencyCode, java.math.BigDecimal requestAmount, String requestTenorUom, String orgCifCode, String orgUserCifCode, String facilityTypeCode, java.math.BigDecimal rateOfInterest, String tenorUom, String productCode, String subProductCode, String externalRatingTypeCode, String externalRatingValue, String offerTypeCode, String acceptanceParty, String assessmentParty, String productStatusCode, String acceptanceReasonCode, String acceptanceComments, java.time.LocalDateTime acceptanceDate, String assessmentReasonCode, String assessmentComments, java.time.LocalDateTime assessmentDate, String tenureDays, Integer uploadRefID, String routingCode, String routingTypeCode, String bankCode, Integer transactionID, String offerBenchmark, java.math.BigDecimal availableLimit, String priority, String schemeCode, String accountOpeningDate, String notes, String repricingPlan, java.math.BigDecimal rateFixingMethod, java.time.LocalDateTime peggingReviewDate, String peggingFrequency, java.math.BigDecimal interestRateCode, java.math.BigDecimal spread, java.math.BigDecimal customerPreferentialInterest, String penalInterestTableCode, String penalPreferentialPercentage, String holdInOptAccForAmtDue, String repaymentMethod, String recyOnlyIntByAccDebit, Long operativeAccountNo, String huntingRequired, String strucRepaymentSchedule, String equatedInstalment, String noOfInstalment, java.time.LocalDateTime instalmentStartDate, String instalmentFrequency, String interestFrequency, java.time.LocalDateTime instlFrequencyStartDate, java.time.LocalDateTime interestFrequencyStartDate, String moratoriumPeriod, java.time.LocalDateTime moratoriumInterestStartDate, String moratoriumPeriodIntFreq, java.time.LocalDateTime moratoriumIntFreqStartDate, String subsectorCode, String sectorCode, String modeOfAdvance, String rolloverFlag, String disbAuthRemarks, String paymentMode, java.math.BigDecimal amount, String beneficiaryAccountNo, String beneficiaryAccountType, String beneficiaryName, String beneficiaryAddress, String ifscCode, String paymentProduct, java.math.BigDecimal ccyRate, String beneficiaryType, String beneficiaryLeiNumber, String makerTempNo, String amtInWords, java.math.BigDecimal drawingPower, java.math.BigDecimal limitAsPerSystem, String disbTillDtUnderContract, java.math.BigDecimal freeLimitsForDisb, String disbTillDtUnderFacility, java.math.BigDecimal poLimit, java.math.BigDecimal systemFreePoLimit, java.time.LocalDateTime maturityDate, java.math.BigDecimal loanSpread, java.math.BigDecimal minRarocSpread, java.math.BigDecimal minFbilFimmdaSpread, java.time.LocalDateTime brDate, String termSheet, String pricingSheet, String pslUpdation, String pfCollected, String internalConditions, java.math.BigDecimal overdues, String branch, java.math.BigDecimal minLoanAmt, java.math.BigDecimal maxLoanAmt, java.math.BigDecimal sanctionLimit, String operationType, java.time.LocalDateTime uploadedDate, String segmentCode, java.math.BigDecimal disbursementAmount, String remarks, String orgCifName, String segmentTeams, Integer isAcceptLoanAgreement, String recoveryAccountNo, String taskReason, String downloadStatus, String downloadTime, String reverseFileStatus, String endUse, String reverseStatus, String spreadDisplay, String resetFrequency, String resetFreqUom, Integer resetFreqValue, java.math.BigDecimal overallLimit, java.math.BigDecimal gst, java.math.BigDecimal procFee, String benchmark, java.math.BigDecimal roiBenchmark, java.time.LocalDateTime interestStartDate, String alertStatus, String userCrn, String makerTaskConsent, Integer reverseUploadRefID, Integer offerVersionID, String tenureDaysList, String rmName, String amtInWordsReqLetter, String stpStatus) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.utilizedAmount = utilizedAmount;
        this.outstandingAmount = outstandingAmount;
        this.limitNodeReference = limitNodeReference;
        this.requestTenor = requestTenor;
        this.requestStatusCode = requestStatusCode;
        this.requestDisbursementDate = requestDisbursementDate;
        this.rmPartyReference = rmPartyReference;
        this.parentFacilityLimitID = parentFacilityLimitID;
        this.facilityLimitID = facilityLimitID;
        this.leiNumber = leiNumber;
        this.leiStatusCode = leiStatusCode;
        this.interestTypeCode = interestTypeCode;
        this.offerCode = offerCode;
        this.tenorMin = tenorMin;
        this.tenorMax = tenorMax;
        this.processingModeCode = processingModeCode;
        this.resetFrequenctPeriodCode = resetFrequenctPeriodCode;
        this.loanAccountNumber = loanAccountNumber;
        this.loanStartDate = loanStartDate;
        this.sanctionedAmountCcyCode = sanctionedAmountCcyCode;
        this.sanctionedAmount = sanctionedAmount;
        this.applicantParty = applicantParty;
        this.sanctionedDate = sanctionedDate;
        this.disbursementAccount = disbursementAccount;
        this.disbursedDate = disbursedDate;
        this.settlementAccount = settlementAccount;
        this.wcdlLimitAvailable = wcdlLimitAvailable;
        this.wcdlFacilityValidity = wcdlFacilityValidity;
        this.loanOverdueCheck = loanOverdueCheck;
        this.coolingPeriodCheck = coolingPeriodCheck;
        this.leiAvailableCheck = leiAvailableCheck;
        this.internalRatingTypeCode = internalRatingTypeCode;
        this.internalRatingValue = internalRatingValue;
        this.rarocStatusCheck = rarocStatusCheck;
        this.rarocFacilityCheck = rarocFacilityCheck;
        this.pslAvailabilityCheck = pslAvailabilityCheck;
        this.flowTypeCode = flowTypeCode;
        this.digitalFlowFlag = digitalFlowFlag;
        this.lobCode = lobCode;
        this.requestDate = requestDate;
        this.requestCategoryCode = requestCategoryCode;
        this.requestTypeCode = requestTypeCode;
        this.requestCurrencyCode = requestCurrencyCode;
        this.requestAmount = requestAmount;
        this.requestTenorUom = requestTenorUom;
        this.orgCifCode = orgCifCode;
        this.orgUserCifCode = orgUserCifCode;
        this.facilityTypeCode = facilityTypeCode;
        this.rateOfInterest = rateOfInterest;
        this.tenorUom = tenorUom;
        this.productCode = productCode;
        this.subProductCode = subProductCode;
        this.externalRatingTypeCode = externalRatingTypeCode;
        this.externalRatingValue = externalRatingValue;
        this.offerTypeCode = offerTypeCode;
        this.acceptanceParty = acceptanceParty;
        this.assessmentParty = assessmentParty;
        this.productStatusCode = productStatusCode;
        this.acceptanceReasonCode = acceptanceReasonCode;
        this.acceptanceComments = acceptanceComments;
        this.acceptanceDate = acceptanceDate;
        this.assessmentReasonCode = assessmentReasonCode;
        this.assessmentComments = assessmentComments;
        this.assessmentDate = assessmentDate;
        this.tenureDays = tenureDays;
        this.uploadRefID = uploadRefID;
        this.routingCode = routingCode;
        this.routingTypeCode = routingTypeCode;
        this.bankCode = bankCode;
        this.transactionID = transactionID;
        this.offerBenchmark = offerBenchmark;
        this.availableLimit = availableLimit;
        this.priority = priority;
        this.schemeCode = schemeCode;
        this.accountOpeningDate = accountOpeningDate;
        this.notes = notes;
        this.repricingPlan = repricingPlan;
        this.rateFixingMethod = rateFixingMethod;
        this.peggingReviewDate = peggingReviewDate;
        this.peggingFrequency = peggingFrequency;
        this.interestRateCode = interestRateCode;
        this.spread = spread;
        this.customerPreferentialInterest = customerPreferentialInterest;
        this.penalInterestTableCode = penalInterestTableCode;
        this.penalPreferentialPercentage = penalPreferentialPercentage;
        this.holdInOptAccForAmtDue = holdInOptAccForAmtDue;
        this.repaymentMethod = repaymentMethod;
        this.recyOnlyIntByAccDebit = recyOnlyIntByAccDebit;
        this.operativeAccountNo = operativeAccountNo;
        this.huntingRequired = huntingRequired;
        this.strucRepaymentSchedule = strucRepaymentSchedule;
        this.equatedInstalment = equatedInstalment;
        this.noOfInstalment = noOfInstalment;
        this.instalmentStartDate = instalmentStartDate;
        this.instalmentFrequency = instalmentFrequency;
        this.interestFrequency = interestFrequency;
        this.instlFrequencyStartDate = instlFrequencyStartDate;
        this.interestFrequencyStartDate = interestFrequencyStartDate;
        this.moratoriumPeriod = moratoriumPeriod;
        this.moratoriumInterestStartDate = moratoriumInterestStartDate;
        this.moratoriumPeriodIntFreq = moratoriumPeriodIntFreq;
        this.moratoriumIntFreqStartDate = moratoriumIntFreqStartDate;
        this.subsectorCode = subsectorCode;
        this.sectorCode = sectorCode;
        this.modeOfAdvance = modeOfAdvance;
        this.rolloverFlag = rolloverFlag;
        this.disbAuthRemarks = disbAuthRemarks;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryAccountType = beneficiaryAccountType;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryAddress = beneficiaryAddress;
        this.ifscCode = ifscCode;
        this.paymentProduct = paymentProduct;
        this.ccyRate = ccyRate;
        this.beneficiaryType = beneficiaryType;
        this.beneficiaryLeiNumber = beneficiaryLeiNumber;
        this.makerTempNo = makerTempNo;
        this.amtInWords = amtInWords;
        this.drawingPower = drawingPower;
        this.limitAsPerSystem = limitAsPerSystem;
        this.disbTillDtUnderContract = disbTillDtUnderContract;
        this.freeLimitsForDisb = freeLimitsForDisb;
        this.disbTillDtUnderFacility = disbTillDtUnderFacility;
        this.poLimit = poLimit;
        this.systemFreePoLimit = systemFreePoLimit;
        this.maturityDate = maturityDate;
        this.loanSpread = loanSpread;
        this.minRarocSpread = minRarocSpread;
        this.minFbilFimmdaSpread = minFbilFimmdaSpread;
        this.brDate = brDate;
        this.termSheet = termSheet;
        this.pricingSheet = pricingSheet;
        this.pslUpdation = pslUpdation;
        this.pfCollected = pfCollected;
        this.internalConditions = internalConditions;
        this.overdues = overdues;
        this.branch = branch;
        this.minLoanAmt = minLoanAmt;
        this.maxLoanAmt = maxLoanAmt;
        this.sanctionLimit = sanctionLimit;
        this.operationType = operationType;
        this.uploadedDate = uploadedDate;
        this.segmentCode = segmentCode;
        this.disbursementAmount = disbursementAmount;
        this.remarks = remarks;
        this.orgCifName = orgCifName;
        this.segmentTeams = segmentTeams;
        this.isAcceptLoanAgreement = isAcceptLoanAgreement;
        this.recoveryAccountNo = recoveryAccountNo;
        this.taskReason = taskReason;
        this.downloadStatus = downloadStatus;
        this.downloadTime = downloadTime;
        this.reverseFileStatus = reverseFileStatus;
        this.endUse = endUse;
        this.reverseStatus = reverseStatus;
        this.spreadDisplay = spreadDisplay;
        this.resetFrequency = resetFrequency;
        this.resetFreqUom = resetFreqUom;
        this.resetFreqValue = resetFreqValue;
        this.overallLimit = overallLimit;
        this.gst = gst;
        this.procFee = procFee;
        this.benchmark = benchmark;
        this.roiBenchmark = roiBenchmark;
        this.interestStartDate = interestStartDate;
        this.alertStatus = alertStatus;
        this.userCrn = userCrn;
        this.makerTaskConsent = makerTaskConsent;
        this.reverseUploadRefID = reverseUploadRefID;
        this.offerVersionID = offerVersionID;
        this.tenureDaysList = tenureDaysList;
        this.rmName = rmName;
        this.amtInWordsReqLetter = amtInWordsReqLetter;
        this.stpStatus = stpStatus;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public java.math.BigDecimal getUtilizedAmount() {
        return utilizedAmount;
    }

    public void setUtilizedAmount(java.math.BigDecimal utilizedAmount) {
        this.utilizedAmount = utilizedAmount;
    }

    public java.math.BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(java.math.BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getLimitNodeReference() {
        return limitNodeReference;
    }

    public void setLimitNodeReference(String limitNodeReference) {
        this.limitNodeReference = limitNodeReference;
    }

    public Long getRequestTenor() {
        return requestTenor;
    }

    public void setRequestTenor(Long requestTenor) {
        this.requestTenor = requestTenor;
    }

    public String getRequestStatusCode() {
        return requestStatusCode;
    }

    public void setRequestStatusCode(String requestStatusCode) {
        this.requestStatusCode = requestStatusCode;
    }

    public java.time.LocalDateTime getRequestDisbursementDate() {
        return requestDisbursementDate;
    }

    public void setRequestDisbursementDate(java.time.LocalDateTime requestDisbursementDate) {
        this.requestDisbursementDate = requestDisbursementDate;
    }

    public String getRmPartyReference() {
        return rmPartyReference;
    }

    public void setRmPartyReference(String rmPartyReference) {
        this.rmPartyReference = rmPartyReference;
    }

    public Integer getParentFacilityLimitID() {
        return parentFacilityLimitID;
    }

    public void setParentFacilityLimitID(Integer parentFacilityLimitID) {
        this.parentFacilityLimitID = parentFacilityLimitID;
    }

    public Integer getFacilityLimitID() {
        return facilityLimitID;
    }

    public void setFacilityLimitID(Integer facilityLimitID) {
        this.facilityLimitID = facilityLimitID;
    }

    public String getLeiNumber() {
        return leiNumber;
    }

    public void setLeiNumber(String leiNumber) {
        this.leiNumber = leiNumber;
    }

    public String getLeiStatusCode() {
        return leiStatusCode;
    }

    public void setLeiStatusCode(String leiStatusCode) {
        this.leiStatusCode = leiStatusCode;
    }

    public String getInterestTypeCode() {
        return interestTypeCode;
    }

    public void setInterestTypeCode(String interestTypeCode) {
        this.interestTypeCode = interestTypeCode;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public Long getTenorMin() {
        return tenorMin;
    }

    public void setTenorMin(Long tenorMin) {
        this.tenorMin = tenorMin;
    }

    public Long getTenorMax() {
        return tenorMax;
    }

    public void setTenorMax(Long tenorMax) {
        this.tenorMax = tenorMax;
    }

    public String getProcessingModeCode() {
        return processingModeCode;
    }

    public void setProcessingModeCode(String processingModeCode) {
        this.processingModeCode = processingModeCode;
    }

    public String getResetFrequenctPeriodCode() {
        return resetFrequenctPeriodCode;
    }

    public void setResetFrequenctPeriodCode(String resetFrequenctPeriodCode) {
        this.resetFrequenctPeriodCode = resetFrequenctPeriodCode;
    }

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public java.time.LocalDateTime getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(java.time.LocalDateTime loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public java.math.BigDecimal getSanctionedAmountCcyCode() {
        return sanctionedAmountCcyCode;
    }

    public void setSanctionedAmountCcyCode(java.math.BigDecimal sanctionedAmountCcyCode) {
        this.sanctionedAmountCcyCode = sanctionedAmountCcyCode;
    }

    public java.math.BigDecimal getSanctionedAmount() {
        return sanctionedAmount;
    }

    public void setSanctionedAmount(java.math.BigDecimal sanctionedAmount) {
        this.sanctionedAmount = sanctionedAmount;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getSanctionedDate() {
        return sanctionedDate;
    }

    public void setSanctionedDate(String sanctionedDate) {
        this.sanctionedDate = sanctionedDate;
    }

    public String getDisbursementAccount() {
        return disbursementAccount;
    }

    public void setDisbursementAccount(String disbursementAccount) {
        this.disbursementAccount = disbursementAccount;
    }

    public java.time.LocalDateTime getDisbursedDate() {
        return disbursedDate;
    }

    public void setDisbursedDate(java.time.LocalDateTime disbursedDate) {
        this.disbursedDate = disbursedDate;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }

    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }

    public Integer getWcdlLimitAvailable() {
        return wcdlLimitAvailable;
    }

    public void setWcdlLimitAvailable(Integer wcdlLimitAvailable) {
        this.wcdlLimitAvailable = wcdlLimitAvailable;
    }

    public Integer getWcdlFacilityValidity() {
        return wcdlFacilityValidity;
    }

    public void setWcdlFacilityValidity(Integer wcdlFacilityValidity) {
        this.wcdlFacilityValidity = wcdlFacilityValidity;
    }

    public Integer getLoanOverdueCheck() {
        return loanOverdueCheck;
    }

    public void setLoanOverdueCheck(Integer loanOverdueCheck) {
        this.loanOverdueCheck = loanOverdueCheck;
    }

    public Integer getCoolingPeriodCheck() {
        return coolingPeriodCheck;
    }

    public void setCoolingPeriodCheck(Integer coolingPeriodCheck) {
        this.coolingPeriodCheck = coolingPeriodCheck;
    }

    public Integer getLeiAvailableCheck() {
        return leiAvailableCheck;
    }

    public void setLeiAvailableCheck(Integer leiAvailableCheck) {
        this.leiAvailableCheck = leiAvailableCheck;
    }

    public String getInternalRatingTypeCode() {
        return internalRatingTypeCode;
    }

    public void setInternalRatingTypeCode(String internalRatingTypeCode) {
        this.internalRatingTypeCode = internalRatingTypeCode;
    }

    public String getInternalRatingValue() {
        return internalRatingValue;
    }

    public void setInternalRatingValue(String internalRatingValue) {
        this.internalRatingValue = internalRatingValue;
    }

    public Integer getRarocStatusCheck() {
        return rarocStatusCheck;
    }

    public void setRarocStatusCheck(Integer rarocStatusCheck) {
        this.rarocStatusCheck = rarocStatusCheck;
    }

    public Integer getRarocFacilityCheck() {
        return rarocFacilityCheck;
    }

    public void setRarocFacilityCheck(Integer rarocFacilityCheck) {
        this.rarocFacilityCheck = rarocFacilityCheck;
    }

    public Integer getPslAvailabilityCheck() {
        return pslAvailabilityCheck;
    }

    public void setPslAvailabilityCheck(Integer pslAvailabilityCheck) {
        this.pslAvailabilityCheck = pslAvailabilityCheck;
    }

    public String getFlowTypeCode() {
        return flowTypeCode;
    }

    public void setFlowTypeCode(String flowTypeCode) {
        this.flowTypeCode = flowTypeCode;
    }

    public Integer getDigitalFlowFlag() {
        return digitalFlowFlag;
    }

    public void setDigitalFlowFlag(Integer digitalFlowFlag) {
        this.digitalFlowFlag = digitalFlowFlag;
    }

    public String getLobCode() {
        return lobCode;
    }

    public void setLobCode(String lobCode) {
        this.lobCode = lobCode;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestCategoryCode() {
        return requestCategoryCode;
    }

    public void setRequestCategoryCode(String requestCategoryCode) {
        this.requestCategoryCode = requestCategoryCode;
    }

    public String getRequestTypeCode() {
        return requestTypeCode;
    }

    public void setRequestTypeCode(String requestTypeCode) {
        this.requestTypeCode = requestTypeCode;
    }

    public String getRequestCurrencyCode() {
        return requestCurrencyCode;
    }

    public void setRequestCurrencyCode(String requestCurrencyCode) {
        this.requestCurrencyCode = requestCurrencyCode;
    }

    public java.math.BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(java.math.BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getRequestTenorUom() {
        return requestTenorUom;
    }

    public void setRequestTenorUom(String requestTenorUom) {
        this.requestTenorUom = requestTenorUom;
    }

    public String getOrgCifCode() {
        return orgCifCode;
    }

    public void setOrgCifCode(String orgCifCode) {
        this.orgCifCode = orgCifCode;
    }

    public String getOrgUserCifCode() {
        return orgUserCifCode;
    }

    public void setOrgUserCifCode(String orgUserCifCode) {
        this.orgUserCifCode = orgUserCifCode;
    }

    public String getFacilityTypeCode() {
        return facilityTypeCode;
    }

    public void setFacilityTypeCode(String facilityTypeCode) {
        this.facilityTypeCode = facilityTypeCode;
    }

    public java.math.BigDecimal getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(java.math.BigDecimal rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getTenorUom() {
        return tenorUom;
    }

    public void setTenorUom(String tenorUom) {
        this.tenorUom = tenorUom;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public String getExternalRatingTypeCode() {
        return externalRatingTypeCode;
    }

    public void setExternalRatingTypeCode(String externalRatingTypeCode) {
        this.externalRatingTypeCode = externalRatingTypeCode;
    }

    public String getExternalRatingValue() {
        return externalRatingValue;
    }

    public void setExternalRatingValue(String externalRatingValue) {
        this.externalRatingValue = externalRatingValue;
    }

    public String getOfferTypeCode() {
        return offerTypeCode;
    }

    public void setOfferTypeCode(String offerTypeCode) {
        this.offerTypeCode = offerTypeCode;
    }

    public String getAcceptanceParty() {
        return acceptanceParty;
    }

    public void setAcceptanceParty(String acceptanceParty) {
        this.acceptanceParty = acceptanceParty;
    }

    public String getAssessmentParty() {
        return assessmentParty;
    }

    public void setAssessmentParty(String assessmentParty) {
        this.assessmentParty = assessmentParty;
    }

    public String getProductStatusCode() {
        return productStatusCode;
    }

    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    public String getAcceptanceReasonCode() {
        return acceptanceReasonCode;
    }

    public void setAcceptanceReasonCode(String acceptanceReasonCode) {
        this.acceptanceReasonCode = acceptanceReasonCode;
    }

    public String getAcceptanceComments() {
        return acceptanceComments;
    }

    public void setAcceptanceComments(String acceptanceComments) {
        this.acceptanceComments = acceptanceComments;
    }

    public java.time.LocalDateTime getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(java.time.LocalDateTime acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getAssessmentReasonCode() {
        return assessmentReasonCode;
    }

    public void setAssessmentReasonCode(String assessmentReasonCode) {
        this.assessmentReasonCode = assessmentReasonCode;
    }

    public String getAssessmentComments() {
        return assessmentComments;
    }

    public void setAssessmentComments(String assessmentComments) {
        this.assessmentComments = assessmentComments;
    }

    public java.time.LocalDateTime getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(java.time.LocalDateTime assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getTenureDays() {
        return tenureDays;
    }

    public void setTenureDays(String tenureDays) {
        this.tenureDays = tenureDays;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public String getRoutingTypeCode() {
        return routingTypeCode;
    }

    public void setRoutingTypeCode(String routingTypeCode) {
        this.routingTypeCode = routingTypeCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public String getOfferBenchmark() {
        return offerBenchmark;
    }

    public void setOfferBenchmark(String offerBenchmark) {
        this.offerBenchmark = offerBenchmark;
    }

    public java.math.BigDecimal getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(java.math.BigDecimal availableLimit) {
        this.availableLimit = availableLimit;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRepricingPlan() {
        return repricingPlan;
    }

    public void setRepricingPlan(String repricingPlan) {
        this.repricingPlan = repricingPlan;
    }

    public java.math.BigDecimal getRateFixingMethod() {
        return rateFixingMethod;
    }

    public void setRateFixingMethod(java.math.BigDecimal rateFixingMethod) {
        this.rateFixingMethod = rateFixingMethod;
    }

    public java.time.LocalDateTime getPeggingReviewDate() {
        return peggingReviewDate;
    }

    public void setPeggingReviewDate(java.time.LocalDateTime peggingReviewDate) {
        this.peggingReviewDate = peggingReviewDate;
    }

    public String getPeggingFrequency() {
        return peggingFrequency;
    }

    public void setPeggingFrequency(String peggingFrequency) {
        this.peggingFrequency = peggingFrequency;
    }

    public java.math.BigDecimal getInterestRateCode() {
        return interestRateCode;
    }

    public void setInterestRateCode(java.math.BigDecimal interestRateCode) {
        this.interestRateCode = interestRateCode;
    }

    public java.math.BigDecimal getSpread() {
        return spread;
    }

    public void setSpread(java.math.BigDecimal spread) {
        this.spread = spread;
    }

    public java.math.BigDecimal getCustomerPreferentialInterest() {
        return customerPreferentialInterest;
    }

    public void setCustomerPreferentialInterest(java.math.BigDecimal customerPreferentialInterest) {
        this.customerPreferentialInterest = customerPreferentialInterest;
    }

    public String getPenalInterestTableCode() {
        return penalInterestTableCode;
    }

    public void setPenalInterestTableCode(String penalInterestTableCode) {
        this.penalInterestTableCode = penalInterestTableCode;
    }

    public String getPenalPreferentialPercentage() {
        return penalPreferentialPercentage;
    }

    public void setPenalPreferentialPercentage(String penalPreferentialPercentage) {
        this.penalPreferentialPercentage = penalPreferentialPercentage;
    }

    public String getHoldInOptAccForAmtDue() {
        return holdInOptAccForAmtDue;
    }

    public void setHoldInOptAccForAmtDue(String holdInOptAccForAmtDue) {
        this.holdInOptAccForAmtDue = holdInOptAccForAmtDue;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public String getRecyOnlyIntByAccDebit() {
        return recyOnlyIntByAccDebit;
    }

    public void setRecyOnlyIntByAccDebit(String recyOnlyIntByAccDebit) {
        this.recyOnlyIntByAccDebit = recyOnlyIntByAccDebit;
    }

    public Long getOperativeAccountNo() {
        return operativeAccountNo;
    }

    public void setOperativeAccountNo(Long operativeAccountNo) {
        this.operativeAccountNo = operativeAccountNo;
    }

    public String getHuntingRequired() {
        return huntingRequired;
    }

    public void setHuntingRequired(String huntingRequired) {
        this.huntingRequired = huntingRequired;
    }

    public String getStrucRepaymentSchedule() {
        return strucRepaymentSchedule;
    }

    public void setStrucRepaymentSchedule(String strucRepaymentSchedule) {
        this.strucRepaymentSchedule = strucRepaymentSchedule;
    }

    public String getEquatedInstalment() {
        return equatedInstalment;
    }

    public void setEquatedInstalment(String equatedInstalment) {
        this.equatedInstalment = equatedInstalment;
    }

    public String getNoOfInstalment() {
        return noOfInstalment;
    }

    public void setNoOfInstalment(String noOfInstalment) {
        this.noOfInstalment = noOfInstalment;
    }

    public java.time.LocalDateTime getInstalmentStartDate() {
        return instalmentStartDate;
    }

    public void setInstalmentStartDate(java.time.LocalDateTime instalmentStartDate) {
        this.instalmentStartDate = instalmentStartDate;
    }

    public String getInstalmentFrequency() {
        return instalmentFrequency;
    }

    public void setInstalmentFrequency(String instalmentFrequency) {
        this.instalmentFrequency = instalmentFrequency;
    }

    public String getInterestFrequency() {
        return interestFrequency;
    }

    public void setInterestFrequency(String interestFrequency) {
        this.interestFrequency = interestFrequency;
    }

    public java.time.LocalDateTime getInstlFrequencyStartDate() {
        return instlFrequencyStartDate;
    }

    public void setInstlFrequencyStartDate(java.time.LocalDateTime instlFrequencyStartDate) {
        this.instlFrequencyStartDate = instlFrequencyStartDate;
    }

    public java.time.LocalDateTime getInterestFrequencyStartDate() {
        return interestFrequencyStartDate;
    }

    public void setInterestFrequencyStartDate(java.time.LocalDateTime interestFrequencyStartDate) {
        this.interestFrequencyStartDate = interestFrequencyStartDate;
    }

    public String getMoratoriumPeriod() {
        return moratoriumPeriod;
    }

    public void setMoratoriumPeriod(String moratoriumPeriod) {
        this.moratoriumPeriod = moratoriumPeriod;
    }

    public java.time.LocalDateTime getMoratoriumInterestStartDate() {
        return moratoriumInterestStartDate;
    }

    public void setMoratoriumInterestStartDate(java.time.LocalDateTime moratoriumInterestStartDate) {
        this.moratoriumInterestStartDate = moratoriumInterestStartDate;
    }

    public String getMoratoriumPeriodIntFreq() {
        return moratoriumPeriodIntFreq;
    }

    public void setMoratoriumPeriodIntFreq(String moratoriumPeriodIntFreq) {
        this.moratoriumPeriodIntFreq = moratoriumPeriodIntFreq;
    }

    public java.time.LocalDateTime getMoratoriumIntFreqStartDate() {
        return moratoriumIntFreqStartDate;
    }

    public void setMoratoriumIntFreqStartDate(java.time.LocalDateTime moratoriumIntFreqStartDate) {
        this.moratoriumIntFreqStartDate = moratoriumIntFreqStartDate;
    }

    public String getSubsectorCode() {
        return subsectorCode;
    }

    public void setSubsectorCode(String subsectorCode) {
        this.subsectorCode = subsectorCode;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getModeOfAdvance() {
        return modeOfAdvance;
    }

    public void setModeOfAdvance(String modeOfAdvance) {
        this.modeOfAdvance = modeOfAdvance;
    }

    public String getRolloverFlag() {
        return rolloverFlag;
    }

    public void setRolloverFlag(String rolloverFlag) {
        this.rolloverFlag = rolloverFlag;
    }

    public String getDisbAuthRemarks() {
        return disbAuthRemarks;
    }

    public void setDisbAuthRemarks(String disbAuthRemarks) {
        this.disbAuthRemarks = disbAuthRemarks;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(String beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public String getBeneficiaryAccountType() {
        return beneficiaryAccountType;
    }

    public void setBeneficiaryAccountType(String beneficiaryAccountType) {
        this.beneficiaryAccountType = beneficiaryAccountType;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(String beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getPaymentProduct() {
        return paymentProduct;
    }

    public void setPaymentProduct(String paymentProduct) {
        this.paymentProduct = paymentProduct;
    }

    public java.math.BigDecimal getCcyRate() {
        return ccyRate;
    }

    public void setCcyRate(java.math.BigDecimal ccyRate) {
        this.ccyRate = ccyRate;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public String getBeneficiaryLeiNumber() {
        return beneficiaryLeiNumber;
    }

    public void setBeneficiaryLeiNumber(String beneficiaryLeiNumber) {
        this.beneficiaryLeiNumber = beneficiaryLeiNumber;
    }

    public String getMakerTempNo() {
        return makerTempNo;
    }

    public void setMakerTempNo(String makerTempNo) {
        this.makerTempNo = makerTempNo;
    }

    public String getAmtInWords() {
        return amtInWords;
    }

    public void setAmtInWords(String amtInWords) {
        this.amtInWords = amtInWords;
    }

    public java.math.BigDecimal getDrawingPower() {
        return drawingPower;
    }

    public void setDrawingPower(java.math.BigDecimal drawingPower) {
        this.drawingPower = drawingPower;
    }

    public java.math.BigDecimal getLimitAsPerSystem() {
        return limitAsPerSystem;
    }

    public void setLimitAsPerSystem(java.math.BigDecimal limitAsPerSystem) {
        this.limitAsPerSystem = limitAsPerSystem;
    }

    public String getDisbTillDtUnderContract() {
        return disbTillDtUnderContract;
    }

    public void setDisbTillDtUnderContract(String disbTillDtUnderContract) {
        this.disbTillDtUnderContract = disbTillDtUnderContract;
    }

    public java.math.BigDecimal getFreeLimitsForDisb() {
        return freeLimitsForDisb;
    }

    public void setFreeLimitsForDisb(java.math.BigDecimal freeLimitsForDisb) {
        this.freeLimitsForDisb = freeLimitsForDisb;
    }

    public String getDisbTillDtUnderFacility() {
        return disbTillDtUnderFacility;
    }

    public void setDisbTillDtUnderFacility(String disbTillDtUnderFacility) {
        this.disbTillDtUnderFacility = disbTillDtUnderFacility;
    }

    public java.math.BigDecimal getPoLimit() {
        return poLimit;
    }

    public void setPoLimit(java.math.BigDecimal poLimit) {
        this.poLimit = poLimit;
    }

    public java.math.BigDecimal getSystemFreePoLimit() {
        return systemFreePoLimit;
    }

    public void setSystemFreePoLimit(java.math.BigDecimal systemFreePoLimit) {
        this.systemFreePoLimit = systemFreePoLimit;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.math.BigDecimal getLoanSpread() {
        return loanSpread;
    }

    public void setLoanSpread(java.math.BigDecimal loanSpread) {
        this.loanSpread = loanSpread;
    }

    public java.math.BigDecimal getMinRarocSpread() {
        return minRarocSpread;
    }

    public void setMinRarocSpread(java.math.BigDecimal minRarocSpread) {
        this.minRarocSpread = minRarocSpread;
    }

    public java.math.BigDecimal getMinFbilFimmdaSpread() {
        return minFbilFimmdaSpread;
    }

    public void setMinFbilFimmdaSpread(java.math.BigDecimal minFbilFimmdaSpread) {
        this.minFbilFimmdaSpread = minFbilFimmdaSpread;
    }

    public java.time.LocalDateTime getBrDate() {
        return brDate;
    }

    public void setBrDate(java.time.LocalDateTime brDate) {
        this.brDate = brDate;
    }

    public String getTermSheet() {
        return termSheet;
    }

    public void setTermSheet(String termSheet) {
        this.termSheet = termSheet;
    }

    public String getPricingSheet() {
        return pricingSheet;
    }

    public void setPricingSheet(String pricingSheet) {
        this.pricingSheet = pricingSheet;
    }

    public String getPslUpdation() {
        return pslUpdation;
    }

    public void setPslUpdation(String pslUpdation) {
        this.pslUpdation = pslUpdation;
    }

    public String getPfCollected() {
        return pfCollected;
    }

    public void setPfCollected(String pfCollected) {
        this.pfCollected = pfCollected;
    }

    public String getInternalConditions() {
        return internalConditions;
    }

    public void setInternalConditions(String internalConditions) {
        this.internalConditions = internalConditions;
    }

    public java.math.BigDecimal getOverdues() {
        return overdues;
    }

    public void setOverdues(java.math.BigDecimal overdues) {
        this.overdues = overdues;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public java.math.BigDecimal getMinLoanAmt() {
        return minLoanAmt;
    }

    public void setMinLoanAmt(java.math.BigDecimal minLoanAmt) {
        this.minLoanAmt = minLoanAmt;
    }

    public java.math.BigDecimal getMaxLoanAmt() {
        return maxLoanAmt;
    }

    public void setMaxLoanAmt(java.math.BigDecimal maxLoanAmt) {
        this.maxLoanAmt = maxLoanAmt;
    }

    public java.math.BigDecimal getSanctionLimit() {
        return sanctionLimit;
    }

    public void setSanctionLimit(java.math.BigDecimal sanctionLimit) {
        this.sanctionLimit = sanctionLimit;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public java.time.LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(java.time.LocalDateTime uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public java.math.BigDecimal getDisbursementAmount() {
        return disbursementAmount;
    }

    public void setDisbursementAmount(java.math.BigDecimal disbursementAmount) {
        this.disbursementAmount = disbursementAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrgCifName() {
        return orgCifName;
    }

    public void setOrgCifName(String orgCifName) {
        this.orgCifName = orgCifName;
    }

    public String getSegmentTeams() {
        return segmentTeams;
    }

    public void setSegmentTeams(String segmentTeams) {
        this.segmentTeams = segmentTeams;
    }

    public Integer getIsAcceptLoanAgreement() {
        return isAcceptLoanAgreement;
    }

    public void setIsAcceptLoanAgreement(Integer isAcceptLoanAgreement) {
        this.isAcceptLoanAgreement = isAcceptLoanAgreement;
    }

    public String getRecoveryAccountNo() {
        return recoveryAccountNo;
    }

    public void setRecoveryAccountNo(String recoveryAccountNo) {
        this.recoveryAccountNo = recoveryAccountNo;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public String getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(String downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public String getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getReverseFileStatus() {
        return reverseFileStatus;
    }

    public void setReverseFileStatus(String reverseFileStatus) {
        this.reverseFileStatus = reverseFileStatus;
    }

    public String getEndUse() {
        return endUse;
    }

    public void setEndUse(String endUse) {
        this.endUse = endUse;
    }

    public String getReverseStatus() {
        return reverseStatus;
    }

    public void setReverseStatus(String reverseStatus) {
        this.reverseStatus = reverseStatus;
    }

    public String getSpreadDisplay() {
        return spreadDisplay;
    }

    public void setSpreadDisplay(String spreadDisplay) {
        this.spreadDisplay = spreadDisplay;
    }

    public String getResetFrequency() {
        return resetFrequency;
    }

    public void setResetFrequency(String resetFrequency) {
        this.resetFrequency = resetFrequency;
    }

    public String getResetFreqUom() {
        return resetFreqUom;
    }

    public void setResetFreqUom(String resetFreqUom) {
        this.resetFreqUom = resetFreqUom;
    }

    public Integer getResetFreqValue() {
        return resetFreqValue;
    }

    public void setResetFreqValue(Integer resetFreqValue) {
        this.resetFreqValue = resetFreqValue;
    }

    public java.math.BigDecimal getOverallLimit() {
        return overallLimit;
    }

    public void setOverallLimit(java.math.BigDecimal overallLimit) {
        this.overallLimit = overallLimit;
    }

    public java.math.BigDecimal getGst() {
        return gst;
    }

    public void setGst(java.math.BigDecimal gst) {
        this.gst = gst;
    }

    public java.math.BigDecimal getProcFee() {
        return procFee;
    }

    public void setProcFee(java.math.BigDecimal procFee) {
        this.procFee = procFee;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public java.math.BigDecimal getRoiBenchmark() {
        return roiBenchmark;
    }

    public void setRoiBenchmark(java.math.BigDecimal roiBenchmark) {
        this.roiBenchmark = roiBenchmark;
    }

    public java.time.LocalDateTime getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(java.time.LocalDateTime interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus;
    }

    public String getUserCrn() {
        return userCrn;
    }

    public void setUserCrn(String userCrn) {
        this.userCrn = userCrn;
    }

    public String getMakerTaskConsent() {
        return makerTaskConsent;
    }

    public void setMakerTaskConsent(String makerTaskConsent) {
        this.makerTaskConsent = makerTaskConsent;
    }

    public Integer getReverseUploadRefID() {
        return reverseUploadRefID;
    }

    public void setReverseUploadRefID(Integer reverseUploadRefID) {
        this.reverseUploadRefID = reverseUploadRefID;
    }

    public Integer getOfferVersionID() {
        return offerVersionID;
    }

    public void setOfferVersionID(Integer offerVersionID) {
        this.offerVersionID = offerVersionID;
    }

    public String getTenureDaysList() {
        return tenureDaysList;
    }

    public void setTenureDaysList(String tenureDaysList) {
        this.tenureDaysList = tenureDaysList;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getAmtInWordsReqLetter() {
        return amtInWordsReqLetter;
    }

    public void setAmtInWordsReqLetter(String amtInWordsReqLetter) {
        this.amtInWordsReqLetter = amtInWordsReqLetter;
    }

    public String getStpStatus() {
        return stpStatus;
    }

    public void setStpStatus(String stpStatus) {
        this.stpStatus = stpStatus;
    }

    public static class Builder {

        private LosLoanRequest instance = new LosLoanRequest();

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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder utilizedAmount(java.math.BigDecimal utilizedAmount) {
            instance.setUtilizedAmount(utilizedAmount);
            return this;
        }

        public Builder outstandingAmount(java.math.BigDecimal outstandingAmount) {
            instance.setOutstandingAmount(outstandingAmount);
            return this;
        }

        public Builder limitNodeReference(String limitNodeReference) {
            instance.setLimitNodeReference(limitNodeReference);
            return this;
        }

        public Builder requestTenor(Long requestTenor) {
            instance.setRequestTenor(requestTenor);
            return this;
        }

        public Builder requestStatusCode(String requestStatusCode) {
            instance.setRequestStatusCode(requestStatusCode);
            return this;
        }

        public Builder requestDisbursementDate(java.time.LocalDateTime requestDisbursementDate) {
            instance.setRequestDisbursementDate(requestDisbursementDate);
            return this;
        }

        public Builder rmPartyReference(String rmPartyReference) {
            instance.setRmPartyReference(rmPartyReference);
            return this;
        }

        public Builder parentFacilityLimitID(Integer parentFacilityLimitID) {
            instance.setParentFacilityLimitID(parentFacilityLimitID);
            return this;
        }

        public Builder facilityLimitID(Integer facilityLimitID) {
            instance.setFacilityLimitID(facilityLimitID);
            return this;
        }

        public Builder leiNumber(String leiNumber) {
            instance.setLeiNumber(leiNumber);
            return this;
        }

        public Builder leiStatusCode(String leiStatusCode) {
            instance.setLeiStatusCode(leiStatusCode);
            return this;
        }

        public Builder interestTypeCode(String interestTypeCode) {
            instance.setInterestTypeCode(interestTypeCode);
            return this;
        }

        public Builder offerCode(String offerCode) {
            instance.setOfferCode(offerCode);
            return this;
        }

        public Builder tenorMin(Long tenorMin) {
            instance.setTenorMin(tenorMin);
            return this;
        }

        public Builder tenorMax(Long tenorMax) {
            instance.setTenorMax(tenorMax);
            return this;
        }

        public Builder processingModeCode(String processingModeCode) {
            instance.setProcessingModeCode(processingModeCode);
            return this;
        }

        public Builder resetFrequenctPeriodCode(String resetFrequenctPeriodCode) {
            instance.setResetFrequenctPeriodCode(resetFrequenctPeriodCode);
            return this;
        }

        public Builder loanAccountNumber(String loanAccountNumber) {
            instance.setLoanAccountNumber(loanAccountNumber);
            return this;
        }

        public Builder loanStartDate(java.time.LocalDateTime loanStartDate) {
            instance.setLoanStartDate(loanStartDate);
            return this;
        }

        public Builder sanctionedAmountCcyCode(java.math.BigDecimal sanctionedAmountCcyCode) {
            instance.setSanctionedAmountCcyCode(sanctionedAmountCcyCode);
            return this;
        }

        public Builder sanctionedAmount(java.math.BigDecimal sanctionedAmount) {
            instance.setSanctionedAmount(sanctionedAmount);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder sanctionedDate(String sanctionedDate) {
            instance.setSanctionedDate(sanctionedDate);
            return this;
        }

        public Builder disbursementAccount(String disbursementAccount) {
            instance.setDisbursementAccount(disbursementAccount);
            return this;
        }

        public Builder disbursedDate(java.time.LocalDateTime disbursedDate) {
            instance.setDisbursedDate(disbursedDate);
            return this;
        }

        public Builder settlementAccount(String settlementAccount) {
            instance.setSettlementAccount(settlementAccount);
            return this;
        }

        public Builder wcdlLimitAvailable(Integer wcdlLimitAvailable) {
            instance.setWcdlLimitAvailable(wcdlLimitAvailable);
            return this;
        }

        public Builder wcdlFacilityValidity(Integer wcdlFacilityValidity) {
            instance.setWcdlFacilityValidity(wcdlFacilityValidity);
            return this;
        }

        public Builder loanOverdueCheck(Integer loanOverdueCheck) {
            instance.setLoanOverdueCheck(loanOverdueCheck);
            return this;
        }

        public Builder coolingPeriodCheck(Integer coolingPeriodCheck) {
            instance.setCoolingPeriodCheck(coolingPeriodCheck);
            return this;
        }

        public Builder leiAvailableCheck(Integer leiAvailableCheck) {
            instance.setLeiAvailableCheck(leiAvailableCheck);
            return this;
        }

        public Builder internalRatingTypeCode(String internalRatingTypeCode) {
            instance.setInternalRatingTypeCode(internalRatingTypeCode);
            return this;
        }

        public Builder internalRatingValue(String internalRatingValue) {
            instance.setInternalRatingValue(internalRatingValue);
            return this;
        }

        public Builder rarocStatusCheck(Integer rarocStatusCheck) {
            instance.setRarocStatusCheck(rarocStatusCheck);
            return this;
        }

        public Builder rarocFacilityCheck(Integer rarocFacilityCheck) {
            instance.setRarocFacilityCheck(rarocFacilityCheck);
            return this;
        }

        public Builder pslAvailabilityCheck(Integer pslAvailabilityCheck) {
            instance.setPslAvailabilityCheck(pslAvailabilityCheck);
            return this;
        }

        public Builder flowTypeCode(String flowTypeCode) {
            instance.setFlowTypeCode(flowTypeCode);
            return this;
        }

        public Builder digitalFlowFlag(Integer digitalFlowFlag) {
            instance.setDigitalFlowFlag(digitalFlowFlag);
            return this;
        }

        public Builder lobCode(String lobCode) {
            instance.setLobCode(lobCode);
            return this;
        }

        public Builder requestDate(String requestDate) {
            instance.setRequestDate(requestDate);
            return this;
        }

        public Builder requestCategoryCode(String requestCategoryCode) {
            instance.setRequestCategoryCode(requestCategoryCode);
            return this;
        }

        public Builder requestTypeCode(String requestTypeCode) {
            instance.setRequestTypeCode(requestTypeCode);
            return this;
        }

        public Builder requestCurrencyCode(String requestCurrencyCode) {
            instance.setRequestCurrencyCode(requestCurrencyCode);
            return this;
        }

        public Builder requestAmount(java.math.BigDecimal requestAmount) {
            instance.setRequestAmount(requestAmount);
            return this;
        }

        public Builder requestTenorUom(String requestTenorUom) {
            instance.setRequestTenorUom(requestTenorUom);
            return this;
        }

        public Builder orgCifCode(String orgCifCode) {
            instance.setOrgCifCode(orgCifCode);
            return this;
        }

        public Builder orgUserCifCode(String orgUserCifCode) {
            instance.setOrgUserCifCode(orgUserCifCode);
            return this;
        }

        public Builder facilityTypeCode(String facilityTypeCode) {
            instance.setFacilityTypeCode(facilityTypeCode);
            return this;
        }

        public Builder rateOfInterest(java.math.BigDecimal rateOfInterest) {
            instance.setRateOfInterest(rateOfInterest);
            return this;
        }

        public Builder tenorUom(String tenorUom) {
            instance.setTenorUom(tenorUom);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            instance.setSubProductCode(subProductCode);
            return this;
        }

        public Builder externalRatingTypeCode(String externalRatingTypeCode) {
            instance.setExternalRatingTypeCode(externalRatingTypeCode);
            return this;
        }

        public Builder externalRatingValue(String externalRatingValue) {
            instance.setExternalRatingValue(externalRatingValue);
            return this;
        }

        public Builder offerTypeCode(String offerTypeCode) {
            instance.setOfferTypeCode(offerTypeCode);
            return this;
        }

        public Builder acceptanceParty(String acceptanceParty) {
            instance.setAcceptanceParty(acceptanceParty);
            return this;
        }

        public Builder assessmentParty(String assessmentParty) {
            instance.setAssessmentParty(assessmentParty);
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            instance.setProductStatusCode(productStatusCode);
            return this;
        }

        public Builder acceptanceReasonCode(String acceptanceReasonCode) {
            instance.setAcceptanceReasonCode(acceptanceReasonCode);
            return this;
        }

        public Builder acceptanceComments(String acceptanceComments) {
            instance.setAcceptanceComments(acceptanceComments);
            return this;
        }

        public Builder acceptanceDate(java.time.LocalDateTime acceptanceDate) {
            instance.setAcceptanceDate(acceptanceDate);
            return this;
        }

        public Builder assessmentReasonCode(String assessmentReasonCode) {
            instance.setAssessmentReasonCode(assessmentReasonCode);
            return this;
        }

        public Builder assessmentComments(String assessmentComments) {
            instance.setAssessmentComments(assessmentComments);
            return this;
        }

        public Builder assessmentDate(java.time.LocalDateTime assessmentDate) {
            instance.setAssessmentDate(assessmentDate);
            return this;
        }

        public Builder tenureDays(String tenureDays) {
            instance.setTenureDays(tenureDays);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder routingCode(String routingCode) {
            instance.setRoutingCode(routingCode);
            return this;
        }

        public Builder routingTypeCode(String routingTypeCode) {
            instance.setRoutingTypeCode(routingTypeCode);
            return this;
        }

        public Builder bankCode(String bankCode) {
            instance.setBankCode(bankCode);
            return this;
        }

        public Builder transactionID(Integer transactionID) {
            instance.setTransactionID(transactionID);
            return this;
        }

        public Builder offerBenchmark(String offerBenchmark) {
            instance.setOfferBenchmark(offerBenchmark);
            return this;
        }

        public Builder availableLimit(java.math.BigDecimal availableLimit) {
            instance.setAvailableLimit(availableLimit);
            return this;
        }

        public Builder priority(String priority) {
            instance.setPriority(priority);
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            instance.setSchemeCode(schemeCode);
            return this;
        }

        public Builder accountOpeningDate(String accountOpeningDate) {
            instance.setAccountOpeningDate(accountOpeningDate);
            return this;
        }

        public Builder notes(String notes) {
            instance.setNotes(notes);
            return this;
        }

        public Builder repricingPlan(String repricingPlan) {
            instance.setRepricingPlan(repricingPlan);
            return this;
        }

        public Builder rateFixingMethod(java.math.BigDecimal rateFixingMethod) {
            instance.setRateFixingMethod(rateFixingMethod);
            return this;
        }

        public Builder peggingReviewDate(java.time.LocalDateTime peggingReviewDate) {
            instance.setPeggingReviewDate(peggingReviewDate);
            return this;
        }

        public Builder peggingFrequency(String peggingFrequency) {
            instance.setPeggingFrequency(peggingFrequency);
            return this;
        }

        public Builder interestRateCode(java.math.BigDecimal interestRateCode) {
            instance.setInterestRateCode(interestRateCode);
            return this;
        }

        public Builder spread(java.math.BigDecimal spread) {
            instance.setSpread(spread);
            return this;
        }

        public Builder customerPreferentialInterest(java.math.BigDecimal customerPreferentialInterest) {
            instance.setCustomerPreferentialInterest(customerPreferentialInterest);
            return this;
        }

        public Builder penalInterestTableCode(String penalInterestTableCode) {
            instance.setPenalInterestTableCode(penalInterestTableCode);
            return this;
        }

        public Builder penalPreferentialPercentage(String penalPreferentialPercentage) {
            instance.setPenalPreferentialPercentage(penalPreferentialPercentage);
            return this;
        }

        public Builder holdInOptAccForAmtDue(String holdInOptAccForAmtDue) {
            instance.setHoldInOptAccForAmtDue(holdInOptAccForAmtDue);
            return this;
        }

        public Builder repaymentMethod(String repaymentMethod) {
            instance.setRepaymentMethod(repaymentMethod);
            return this;
        }

        public Builder recyOnlyIntByAccDebit(String recyOnlyIntByAccDebit) {
            instance.setRecyOnlyIntByAccDebit(recyOnlyIntByAccDebit);
            return this;
        }

        public Builder operativeAccountNo(Long operativeAccountNo) {
            instance.setOperativeAccountNo(operativeAccountNo);
            return this;
        }

        public Builder huntingRequired(String huntingRequired) {
            instance.setHuntingRequired(huntingRequired);
            return this;
        }

        public Builder strucRepaymentSchedule(String strucRepaymentSchedule) {
            instance.setStrucRepaymentSchedule(strucRepaymentSchedule);
            return this;
        }

        public Builder equatedInstalment(String equatedInstalment) {
            instance.setEquatedInstalment(equatedInstalment);
            return this;
        }

        public Builder noOfInstalment(String noOfInstalment) {
            instance.setNoOfInstalment(noOfInstalment);
            return this;
        }

        public Builder instalmentStartDate(java.time.LocalDateTime instalmentStartDate) {
            instance.setInstalmentStartDate(instalmentStartDate);
            return this;
        }

        public Builder instalmentFrequency(String instalmentFrequency) {
            instance.setInstalmentFrequency(instalmentFrequency);
            return this;
        }

        public Builder interestFrequency(String interestFrequency) {
            instance.setInterestFrequency(interestFrequency);
            return this;
        }

        public Builder instlFrequencyStartDate(java.time.LocalDateTime instlFrequencyStartDate) {
            instance.setInstlFrequencyStartDate(instlFrequencyStartDate);
            return this;
        }

        public Builder interestFrequencyStartDate(java.time.LocalDateTime interestFrequencyStartDate) {
            instance.setInterestFrequencyStartDate(interestFrequencyStartDate);
            return this;
        }

        public Builder moratoriumPeriod(String moratoriumPeriod) {
            instance.setMoratoriumPeriod(moratoriumPeriod);
            return this;
        }

        public Builder moratoriumInterestStartDate(java.time.LocalDateTime moratoriumInterestStartDate) {
            instance.setMoratoriumInterestStartDate(moratoriumInterestStartDate);
            return this;
        }

        public Builder moratoriumPeriodIntFreq(String moratoriumPeriodIntFreq) {
            instance.setMoratoriumPeriodIntFreq(moratoriumPeriodIntFreq);
            return this;
        }

        public Builder moratoriumIntFreqStartDate(java.time.LocalDateTime moratoriumIntFreqStartDate) {
            instance.setMoratoriumIntFreqStartDate(moratoriumIntFreqStartDate);
            return this;
        }

        public Builder subsectorCode(String subsectorCode) {
            instance.setSubsectorCode(subsectorCode);
            return this;
        }

        public Builder sectorCode(String sectorCode) {
            instance.setSectorCode(sectorCode);
            return this;
        }

        public Builder modeOfAdvance(String modeOfAdvance) {
            instance.setModeOfAdvance(modeOfAdvance);
            return this;
        }

        public Builder rolloverFlag(String rolloverFlag) {
            instance.setRolloverFlag(rolloverFlag);
            return this;
        }

        public Builder disbAuthRemarks(String disbAuthRemarks) {
            instance.setDisbAuthRemarks(disbAuthRemarks);
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            instance.setPaymentMode(paymentMode);
            return this;
        }

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder beneficiaryAccountNo(String beneficiaryAccountNo) {
            instance.setBeneficiaryAccountNo(beneficiaryAccountNo);
            return this;
        }

        public Builder beneficiaryAccountType(String beneficiaryAccountType) {
            instance.setBeneficiaryAccountType(beneficiaryAccountType);
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            instance.setBeneficiaryName(beneficiaryName);
            return this;
        }

        public Builder beneficiaryAddress(String beneficiaryAddress) {
            instance.setBeneficiaryAddress(beneficiaryAddress);
            return this;
        }

        public Builder ifscCode(String ifscCode) {
            instance.setIfscCode(ifscCode);
            return this;
        }

        public Builder paymentProduct(String paymentProduct) {
            instance.setPaymentProduct(paymentProduct);
            return this;
        }

        public Builder ccyRate(java.math.BigDecimal ccyRate) {
            instance.setCcyRate(ccyRate);
            return this;
        }

        public Builder beneficiaryType(String beneficiaryType) {
            instance.setBeneficiaryType(beneficiaryType);
            return this;
        }

        public Builder beneficiaryLeiNumber(String beneficiaryLeiNumber) {
            instance.setBeneficiaryLeiNumber(beneficiaryLeiNumber);
            return this;
        }

        public Builder makerTempNo(String makerTempNo) {
            instance.setMakerTempNo(makerTempNo);
            return this;
        }

        public Builder amtInWords(String amtInWords) {
            instance.setAmtInWords(amtInWords);
            return this;
        }

        public Builder drawingPower(java.math.BigDecimal drawingPower) {
            instance.setDrawingPower(drawingPower);
            return this;
        }

        public Builder limitAsPerSystem(java.math.BigDecimal limitAsPerSystem) {
            instance.setLimitAsPerSystem(limitAsPerSystem);
            return this;
        }

        public Builder disbTillDtUnderContract(String disbTillDtUnderContract) {
            instance.setDisbTillDtUnderContract(disbTillDtUnderContract);
            return this;
        }

        public Builder freeLimitsForDisb(java.math.BigDecimal freeLimitsForDisb) {
            instance.setFreeLimitsForDisb(freeLimitsForDisb);
            return this;
        }

        public Builder disbTillDtUnderFacility(String disbTillDtUnderFacility) {
            instance.setDisbTillDtUnderFacility(disbTillDtUnderFacility);
            return this;
        }

        public Builder poLimit(java.math.BigDecimal poLimit) {
            instance.setPoLimit(poLimit);
            return this;
        }

        public Builder systemFreePoLimit(java.math.BigDecimal systemFreePoLimit) {
            instance.setSystemFreePoLimit(systemFreePoLimit);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder loanSpread(java.math.BigDecimal loanSpread) {
            instance.setLoanSpread(loanSpread);
            return this;
        }

        public Builder minRarocSpread(java.math.BigDecimal minRarocSpread) {
            instance.setMinRarocSpread(minRarocSpread);
            return this;
        }

        public Builder minFbilFimmdaSpread(java.math.BigDecimal minFbilFimmdaSpread) {
            instance.setMinFbilFimmdaSpread(minFbilFimmdaSpread);
            return this;
        }

        public Builder brDate(java.time.LocalDateTime brDate) {
            instance.setBrDate(brDate);
            return this;
        }

        public Builder termSheet(String termSheet) {
            instance.setTermSheet(termSheet);
            return this;
        }

        public Builder pricingSheet(String pricingSheet) {
            instance.setPricingSheet(pricingSheet);
            return this;
        }

        public Builder pslUpdation(String pslUpdation) {
            instance.setPslUpdation(pslUpdation);
            return this;
        }

        public Builder pfCollected(String pfCollected) {
            instance.setPfCollected(pfCollected);
            return this;
        }

        public Builder internalConditions(String internalConditions) {
            instance.setInternalConditions(internalConditions);
            return this;
        }

        public Builder overdues(java.math.BigDecimal overdues) {
            instance.setOverdues(overdues);
            return this;
        }

        public Builder branch(String branch) {
            instance.setBranch(branch);
            return this;
        }

        public Builder minLoanAmt(java.math.BigDecimal minLoanAmt) {
            instance.setMinLoanAmt(minLoanAmt);
            return this;
        }

        public Builder maxLoanAmt(java.math.BigDecimal maxLoanAmt) {
            instance.setMaxLoanAmt(maxLoanAmt);
            return this;
        }

        public Builder sanctionLimit(java.math.BigDecimal sanctionLimit) {
            instance.setSanctionLimit(sanctionLimit);
            return this;
        }

        public Builder operationType(String operationType) {
            instance.setOperationType(operationType);
            return this;
        }

        public Builder uploadedDate(java.time.LocalDateTime uploadedDate) {
            instance.setUploadedDate(uploadedDate);
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            instance.setSegmentCode(segmentCode);
            return this;
        }

        public Builder disbursementAmount(java.math.BigDecimal disbursementAmount) {
            instance.setDisbursementAmount(disbursementAmount);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder orgCifName(String orgCifName) {
            instance.setOrgCifName(orgCifName);
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            instance.setSegmentTeams(segmentTeams);
            return this;
        }

        public Builder isAcceptLoanAgreement(Integer isAcceptLoanAgreement) {
            instance.setIsAcceptLoanAgreement(isAcceptLoanAgreement);
            return this;
        }

        public Builder recoveryAccountNo(String recoveryAccountNo) {
            instance.setRecoveryAccountNo(recoveryAccountNo);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder downloadStatus(String downloadStatus) {
            instance.setDownloadStatus(downloadStatus);
            return this;
        }

        public Builder downloadTime(String downloadTime) {
            instance.setDownloadTime(downloadTime);
            return this;
        }

        public Builder reverseFileStatus(String reverseFileStatus) {
            instance.setReverseFileStatus(reverseFileStatus);
            return this;
        }

        public Builder endUse(String endUse) {
            instance.setEndUse(endUse);
            return this;
        }

        public Builder reverseStatus(String reverseStatus) {
            instance.setReverseStatus(reverseStatus);
            return this;
        }

        public Builder spreadDisplay(String spreadDisplay) {
            instance.setSpreadDisplay(spreadDisplay);
            return this;
        }

        public Builder resetFrequency(String resetFrequency) {
            instance.setResetFrequency(resetFrequency);
            return this;
        }

        public Builder resetFreqUom(String resetFreqUom) {
            instance.setResetFreqUom(resetFreqUom);
            return this;
        }

        public Builder resetFreqValue(Integer resetFreqValue) {
            instance.setResetFreqValue(resetFreqValue);
            return this;
        }

        public Builder overallLimit(java.math.BigDecimal overallLimit) {
            instance.setOverallLimit(overallLimit);
            return this;
        }

        public Builder gst(java.math.BigDecimal gst) {
            instance.setGst(gst);
            return this;
        }

        public Builder procFee(java.math.BigDecimal procFee) {
            instance.setProcFee(procFee);
            return this;
        }

        public Builder benchmark(String benchmark) {
            instance.setBenchmark(benchmark);
            return this;
        }

        public Builder roiBenchmark(java.math.BigDecimal roiBenchmark) {
            instance.setRoiBenchmark(roiBenchmark);
            return this;
        }

        public Builder interestStartDate(java.time.LocalDateTime interestStartDate) {
            instance.setInterestStartDate(interestStartDate);
            return this;
        }

        public Builder alertStatus(String alertStatus) {
            instance.setAlertStatus(alertStatus);
            return this;
        }

        public Builder userCrn(String userCrn) {
            instance.setUserCrn(userCrn);
            return this;
        }

        public Builder makerTaskConsent(String makerTaskConsent) {
            instance.setMakerTaskConsent(makerTaskConsent);
            return this;
        }

        public Builder reverseUploadRefID(Integer reverseUploadRefID) {
            instance.setReverseUploadRefID(reverseUploadRefID);
            return this;
        }

        public Builder offerVersionID(Integer offerVersionID) {
            instance.setOfferVersionID(offerVersionID);
            return this;
        }

        public Builder tenureDaysList(String tenureDaysList) {
            instance.setTenureDaysList(tenureDaysList);
            return this;
        }

        public Builder rmName(String rmName) {
            instance.setRmName(rmName);
            return this;
        }

        public Builder amtInWordsReqLetter(String amtInWordsReqLetter) {
            instance.setAmtInWordsReqLetter(amtInWordsReqLetter);
            return this;
        }

        public Builder stpStatus(String stpStatus) {
            instance.setStpStatus(stpStatus);
            return this;
        }

        public LosLoanRequest build() {
            return instance;
        }
    }
}
