package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class CoreProductPartyMap {

    private Integer ID;

    private Integer referenceID;

    private String applicantPartyCode;

    private Integer applicantRefID;

    private String issuingPartyCode;

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

    private Integer processID;

    private String subProductCode;

    private String subProductDescription;

    private String primaryParty;

    private String financingMethod;

    private Integer assetLiabilityApplicable;

    private Integer creditLineApplicable;

    private String autoClosureApplicable;

    private String recourseApplicable;

    private Long minTenorAllowed;

    private Long maxTenorAllowed;

    private Long graceDays;

    private java.math.BigDecimal maxFinancePercent;

    private java.math.BigDecimal recoursePercent;

    private String holidayTreatment;

    private String multipleDisbursementAllowed;

    private Long noOfDisbursementAllowed;

    private String prePaymentAllowed;

    private String partRepaymentAllowed;

    private String autoDebitAllowed;

    private String allowedMode;

    private String preClosureAllowed;

    private String allowDebitCreditAdjust;

    private String recessionPeriod;

    private java.math.BigDecimal repaymentAmountAllocation;

    private String allocationRule;

    private String appropriationSequence;

    private String npaAppropriationSequence;

    private String penaltyCalculationFrom;

    private Long noOfRetries;

    private String disbursementSchedule;

    private String autoDebitType;

    private String intraDayDebitFrequency;

    private Long disbursementDays;

    private java.math.BigDecimal feesAndChargesScheme;

    private String alertsNotificationsScheme;

    private String advicesScheme;

    private String assetScheme;

    private String limitCollateralScheme;

    private String npaDelinquencyWriteoff;

    private String allowedBranches;

    private String allowedCustomerType;

    private String timeOfFirstDebit;

    private Long noOfDaysFromGraceDays;

    private Integer customerID;

    private String customerProducts;

    private Integer maxDuration;

    private Integer minDuration;

    private Long stalePeriod;

    private String acceptanceRequired;

    private String disbursementAccount;

    private String marginAccount;

    private String onlineChargesAcc;

    private String batchBillingChargesAcc;

    private String interestCollectionAcc;

    private String settlementAutoDebitAc;

    private String anchorParty;

    private String borrowerParty;

    private String invoiceBy;

    private String financeBy;

    private Integer interestCalculation;

    private Integer exposureMaintananceReq;

    private String accrualFrequency;

    private Integer limitID;

    private String limitType;

    private String limitEffectiveDate;

    private String limitExpiryDate;

    private java.math.BigDecimal limitAmount;

    private java.math.BigDecimal limitUtilizedLimit;

    private java.math.BigDecimal limitAvailableLimit;

    private java.math.BigDecimal limitRecoursePercent;

    private String limitRecourseApplicable;

    private String financeToParty;

    private String financeDebitParty;

    private String productStatusCode;

    private String segmentCode;

    private String productCode;

    private String productName;

    private String subProductName;

    private Integer allowPayment;

    private Integer allowCollection;

    private String applicantParty;

    private String fulfillmentParty;

    public CoreProductPartyMap() {
    }

    public CoreProductPartyMap(Integer ID, Integer referenceID, String applicantPartyCode, Integer applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Integer processID, String subProductCode, String subProductDescription, String primaryParty, String financingMethod, Integer assetLiabilityApplicable, Integer creditLineApplicable, String autoClosureApplicable, String recourseApplicable, Long minTenorAllowed, Long maxTenorAllowed, Long graceDays, java.math.BigDecimal maxFinancePercent, java.math.BigDecimal recoursePercent, String holidayTreatment, String multipleDisbursementAllowed, Long noOfDisbursementAllowed, String prePaymentAllowed, String partRepaymentAllowed, String autoDebitAllowed, String allowedMode, String preClosureAllowed, String allowDebitCreditAdjust, String recessionPeriod, java.math.BigDecimal repaymentAmountAllocation, String allocationRule, String appropriationSequence, String npaAppropriationSequence, String penaltyCalculationFrom, Long noOfRetries, String disbursementSchedule, String autoDebitType, String intraDayDebitFrequency, Long disbursementDays, java.math.BigDecimal feesAndChargesScheme, String alertsNotificationsScheme, String advicesScheme, String assetScheme, String limitCollateralScheme, String npaDelinquencyWriteoff, String allowedBranches, String allowedCustomerType, String timeOfFirstDebit, Long noOfDaysFromGraceDays, Integer customerID, String customerProducts, Integer maxDuration, Integer minDuration, Long stalePeriod, String acceptanceRequired, String disbursementAccount, String marginAccount, String onlineChargesAcc, String batchBillingChargesAcc, String interestCollectionAcc, String settlementAutoDebitAc, String anchorParty, String borrowerParty, String invoiceBy, String financeBy, Integer interestCalculation, Integer exposureMaintananceReq, String accrualFrequency, Integer limitID, String limitType, String limitEffectiveDate, String limitExpiryDate, java.math.BigDecimal limitAmount, java.math.BigDecimal limitUtilizedLimit, java.math.BigDecimal limitAvailableLimit, java.math.BigDecimal limitRecoursePercent, String limitRecourseApplicable, String financeToParty, String financeDebitParty, String productStatusCode, String segmentCode, String productCode, String productName, String subProductName, Integer allowPayment, Integer allowCollection, String applicantParty, String fulfillmentParty) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.applicantPartyCode = applicantPartyCode;
        this.applicantRefID = applicantRefID;
        this.issuingPartyCode = issuingPartyCode;
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
        this.processID = processID;
        this.subProductCode = subProductCode;
        this.subProductDescription = subProductDescription;
        this.primaryParty = primaryParty;
        this.financingMethod = financingMethod;
        this.assetLiabilityApplicable = assetLiabilityApplicable;
        this.creditLineApplicable = creditLineApplicable;
        this.autoClosureApplicable = autoClosureApplicable;
        this.recourseApplicable = recourseApplicable;
        this.minTenorAllowed = minTenorAllowed;
        this.maxTenorAllowed = maxTenorAllowed;
        this.graceDays = graceDays;
        this.maxFinancePercent = maxFinancePercent;
        this.recoursePercent = recoursePercent;
        this.holidayTreatment = holidayTreatment;
        this.multipleDisbursementAllowed = multipleDisbursementAllowed;
        this.noOfDisbursementAllowed = noOfDisbursementAllowed;
        this.prePaymentAllowed = prePaymentAllowed;
        this.partRepaymentAllowed = partRepaymentAllowed;
        this.autoDebitAllowed = autoDebitAllowed;
        this.allowedMode = allowedMode;
        this.preClosureAllowed = preClosureAllowed;
        this.allowDebitCreditAdjust = allowDebitCreditAdjust;
        this.recessionPeriod = recessionPeriod;
        this.repaymentAmountAllocation = repaymentAmountAllocation;
        this.allocationRule = allocationRule;
        this.appropriationSequence = appropriationSequence;
        this.npaAppropriationSequence = npaAppropriationSequence;
        this.penaltyCalculationFrom = penaltyCalculationFrom;
        this.noOfRetries = noOfRetries;
        this.disbursementSchedule = disbursementSchedule;
        this.autoDebitType = autoDebitType;
        this.intraDayDebitFrequency = intraDayDebitFrequency;
        this.disbursementDays = disbursementDays;
        this.feesAndChargesScheme = feesAndChargesScheme;
        this.alertsNotificationsScheme = alertsNotificationsScheme;
        this.advicesScheme = advicesScheme;
        this.assetScheme = assetScheme;
        this.limitCollateralScheme = limitCollateralScheme;
        this.npaDelinquencyWriteoff = npaDelinquencyWriteoff;
        this.allowedBranches = allowedBranches;
        this.allowedCustomerType = allowedCustomerType;
        this.timeOfFirstDebit = timeOfFirstDebit;
        this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
        this.customerID = customerID;
        this.customerProducts = customerProducts;
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
        this.stalePeriod = stalePeriod;
        this.acceptanceRequired = acceptanceRequired;
        this.disbursementAccount = disbursementAccount;
        this.marginAccount = marginAccount;
        this.onlineChargesAcc = onlineChargesAcc;
        this.batchBillingChargesAcc = batchBillingChargesAcc;
        this.interestCollectionAcc = interestCollectionAcc;
        this.settlementAutoDebitAc = settlementAutoDebitAc;
        this.anchorParty = anchorParty;
        this.borrowerParty = borrowerParty;
        this.invoiceBy = invoiceBy;
        this.financeBy = financeBy;
        this.interestCalculation = interestCalculation;
        this.exposureMaintananceReq = exposureMaintananceReq;
        this.accrualFrequency = accrualFrequency;
        this.limitID = limitID;
        this.limitType = limitType;
        this.limitEffectiveDate = limitEffectiveDate;
        this.limitExpiryDate = limitExpiryDate;
        this.limitAmount = limitAmount;
        this.limitUtilizedLimit = limitUtilizedLimit;
        this.limitAvailableLimit = limitAvailableLimit;
        this.limitRecoursePercent = limitRecoursePercent;
        this.limitRecourseApplicable = limitRecourseApplicable;
        this.financeToParty = financeToParty;
        this.financeDebitParty = financeDebitParty;
        this.productStatusCode = productStatusCode;
        this.segmentCode = segmentCode;
        this.productCode = productCode;
        this.productName = productName;
        this.subProductName = subProductName;
        this.allowPayment = allowPayment;
        this.allowCollection = allowCollection;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
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

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public Integer getApplicantRefID() {
        return applicantRefID;
    }

    public void setApplicantRefID(Integer applicantRefID) {
        this.applicantRefID = applicantRefID;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public String getSubProductDescription() {
        return subProductDescription;
    }

    public void setSubProductDescription(String subProductDescription) {
        this.subProductDescription = subProductDescription;
    }

    public String getPrimaryParty() {
        return primaryParty;
    }

    public void setPrimaryParty(String primaryParty) {
        this.primaryParty = primaryParty;
    }

    public String getFinancingMethod() {
        return financingMethod;
    }

    public void setFinancingMethod(String financingMethod) {
        this.financingMethod = financingMethod;
    }

    public Integer getAssetLiabilityApplicable() {
        return assetLiabilityApplicable;
    }

    public void setAssetLiabilityApplicable(Integer assetLiabilityApplicable) {
        this.assetLiabilityApplicable = assetLiabilityApplicable;
    }

    public Integer getCreditLineApplicable() {
        return creditLineApplicable;
    }

    public void setCreditLineApplicable(Integer creditLineApplicable) {
        this.creditLineApplicable = creditLineApplicable;
    }

    public String getAutoClosureApplicable() {
        return autoClosureApplicable;
    }

    public void setAutoClosureApplicable(String autoClosureApplicable) {
        this.autoClosureApplicable = autoClosureApplicable;
    }

    public String getRecourseApplicable() {
        return recourseApplicable;
    }

    public void setRecourseApplicable(String recourseApplicable) {
        this.recourseApplicable = recourseApplicable;
    }

    public Long getMinTenorAllowed() {
        return minTenorAllowed;
    }

    public void setMinTenorAllowed(Long minTenorAllowed) {
        this.minTenorAllowed = minTenorAllowed;
    }

    public Long getMaxTenorAllowed() {
        return maxTenorAllowed;
    }

    public void setMaxTenorAllowed(Long maxTenorAllowed) {
        this.maxTenorAllowed = maxTenorAllowed;
    }

    public Long getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(Long graceDays) {
        this.graceDays = graceDays;
    }

    public java.math.BigDecimal getMaxFinancePercent() {
        return maxFinancePercent;
    }

    public void setMaxFinancePercent(java.math.BigDecimal maxFinancePercent) {
        this.maxFinancePercent = maxFinancePercent;
    }

    public java.math.BigDecimal getRecoursePercent() {
        return recoursePercent;
    }

    public void setRecoursePercent(java.math.BigDecimal recoursePercent) {
        this.recoursePercent = recoursePercent;
    }

    public String getHolidayTreatment() {
        return holidayTreatment;
    }

    public void setHolidayTreatment(String holidayTreatment) {
        this.holidayTreatment = holidayTreatment;
    }

    public String getMultipleDisbursementAllowed() {
        return multipleDisbursementAllowed;
    }

    public void setMultipleDisbursementAllowed(String multipleDisbursementAllowed) {
        this.multipleDisbursementAllowed = multipleDisbursementAllowed;
    }

    public Long getNoOfDisbursementAllowed() {
        return noOfDisbursementAllowed;
    }

    public void setNoOfDisbursementAllowed(Long noOfDisbursementAllowed) {
        this.noOfDisbursementAllowed = noOfDisbursementAllowed;
    }

    public String getPrePaymentAllowed() {
        return prePaymentAllowed;
    }

    public void setPrePaymentAllowed(String prePaymentAllowed) {
        this.prePaymentAllowed = prePaymentAllowed;
    }

    public String getPartRepaymentAllowed() {
        return partRepaymentAllowed;
    }

    public void setPartRepaymentAllowed(String partRepaymentAllowed) {
        this.partRepaymentAllowed = partRepaymentAllowed;
    }

    public String getAutoDebitAllowed() {
        return autoDebitAllowed;
    }

    public void setAutoDebitAllowed(String autoDebitAllowed) {
        this.autoDebitAllowed = autoDebitAllowed;
    }

    public String getAllowedMode() {
        return allowedMode;
    }

    public void setAllowedMode(String allowedMode) {
        this.allowedMode = allowedMode;
    }

    public String getPreClosureAllowed() {
        return preClosureAllowed;
    }

    public void setPreClosureAllowed(String preClosureAllowed) {
        this.preClosureAllowed = preClosureAllowed;
    }

    public String getAllowDebitCreditAdjust() {
        return allowDebitCreditAdjust;
    }

    public void setAllowDebitCreditAdjust(String allowDebitCreditAdjust) {
        this.allowDebitCreditAdjust = allowDebitCreditAdjust;
    }

    public String getRecessionPeriod() {
        return recessionPeriod;
    }

    public void setRecessionPeriod(String recessionPeriod) {
        this.recessionPeriod = recessionPeriod;
    }

    public java.math.BigDecimal getRepaymentAmountAllocation() {
        return repaymentAmountAllocation;
    }

    public void setRepaymentAmountAllocation(java.math.BigDecimal repaymentAmountAllocation) {
        this.repaymentAmountAllocation = repaymentAmountAllocation;
    }

    public String getAllocationRule() {
        return allocationRule;
    }

    public void setAllocationRule(String allocationRule) {
        this.allocationRule = allocationRule;
    }

    public String getAppropriationSequence() {
        return appropriationSequence;
    }

    public void setAppropriationSequence(String appropriationSequence) {
        this.appropriationSequence = appropriationSequence;
    }

    public String getNpaAppropriationSequence() {
        return npaAppropriationSequence;
    }

    public void setNpaAppropriationSequence(String npaAppropriationSequence) {
        this.npaAppropriationSequence = npaAppropriationSequence;
    }

    public String getPenaltyCalculationFrom() {
        return penaltyCalculationFrom;
    }

    public void setPenaltyCalculationFrom(String penaltyCalculationFrom) {
        this.penaltyCalculationFrom = penaltyCalculationFrom;
    }

    public Long getNoOfRetries() {
        return noOfRetries;
    }

    public void setNoOfRetries(Long noOfRetries) {
        this.noOfRetries = noOfRetries;
    }

    public String getDisbursementSchedule() {
        return disbursementSchedule;
    }

    public void setDisbursementSchedule(String disbursementSchedule) {
        this.disbursementSchedule = disbursementSchedule;
    }

    public String getAutoDebitType() {
        return autoDebitType;
    }

    public void setAutoDebitType(String autoDebitType) {
        this.autoDebitType = autoDebitType;
    }

    public String getIntraDayDebitFrequency() {
        return intraDayDebitFrequency;
    }

    public void setIntraDayDebitFrequency(String intraDayDebitFrequency) {
        this.intraDayDebitFrequency = intraDayDebitFrequency;
    }

    public Long getDisbursementDays() {
        return disbursementDays;
    }

    public void setDisbursementDays(Long disbursementDays) {
        this.disbursementDays = disbursementDays;
    }

    public java.math.BigDecimal getFeesAndChargesScheme() {
        return feesAndChargesScheme;
    }

    public void setFeesAndChargesScheme(java.math.BigDecimal feesAndChargesScheme) {
        this.feesAndChargesScheme = feesAndChargesScheme;
    }

    public String getAlertsNotificationsScheme() {
        return alertsNotificationsScheme;
    }

    public void setAlertsNotificationsScheme(String alertsNotificationsScheme) {
        this.alertsNotificationsScheme = alertsNotificationsScheme;
    }

    public String getAdvicesScheme() {
        return advicesScheme;
    }

    public void setAdvicesScheme(String advicesScheme) {
        this.advicesScheme = advicesScheme;
    }

    public String getAssetScheme() {
        return assetScheme;
    }

    public void setAssetScheme(String assetScheme) {
        this.assetScheme = assetScheme;
    }

    public String getLimitCollateralScheme() {
        return limitCollateralScheme;
    }

    public void setLimitCollateralScheme(String limitCollateralScheme) {
        this.limitCollateralScheme = limitCollateralScheme;
    }

    public String getNpaDelinquencyWriteoff() {
        return npaDelinquencyWriteoff;
    }

    public void setNpaDelinquencyWriteoff(String npaDelinquencyWriteoff) {
        this.npaDelinquencyWriteoff = npaDelinquencyWriteoff;
    }

    public String getAllowedBranches() {
        return allowedBranches;
    }

    public void setAllowedBranches(String allowedBranches) {
        this.allowedBranches = allowedBranches;
    }

    public String getAllowedCustomerType() {
        return allowedCustomerType;
    }

    public void setAllowedCustomerType(String allowedCustomerType) {
        this.allowedCustomerType = allowedCustomerType;
    }

    public String getTimeOfFirstDebit() {
        return timeOfFirstDebit;
    }

    public void setTimeOfFirstDebit(String timeOfFirstDebit) {
        this.timeOfFirstDebit = timeOfFirstDebit;
    }

    public Long getNoOfDaysFromGraceDays() {
        return noOfDaysFromGraceDays;
    }

    public void setNoOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
        this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerProducts() {
        return customerProducts;
    }

    public void setCustomerProducts(String customerProducts) {
        this.customerProducts = customerProducts;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public Long getStalePeriod() {
        return stalePeriod;
    }

    public void setStalePeriod(Long stalePeriod) {
        this.stalePeriod = stalePeriod;
    }

    public String getAcceptanceRequired() {
        return acceptanceRequired;
    }

    public void setAcceptanceRequired(String acceptanceRequired) {
        this.acceptanceRequired = acceptanceRequired;
    }

    public String getDisbursementAccount() {
        return disbursementAccount;
    }

    public void setDisbursementAccount(String disbursementAccount) {
        this.disbursementAccount = disbursementAccount;
    }

    public String getMarginAccount() {
        return marginAccount;
    }

    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount;
    }

    public String getOnlineChargesAcc() {
        return onlineChargesAcc;
    }

    public void setOnlineChargesAcc(String onlineChargesAcc) {
        this.onlineChargesAcc = onlineChargesAcc;
    }

    public String getBatchBillingChargesAcc() {
        return batchBillingChargesAcc;
    }

    public void setBatchBillingChargesAcc(String batchBillingChargesAcc) {
        this.batchBillingChargesAcc = batchBillingChargesAcc;
    }

    public String getInterestCollectionAcc() {
        return interestCollectionAcc;
    }

    public void setInterestCollectionAcc(String interestCollectionAcc) {
        this.interestCollectionAcc = interestCollectionAcc;
    }

    public String getSettlementAutoDebitAc() {
        return settlementAutoDebitAc;
    }

    public void setSettlementAutoDebitAc(String settlementAutoDebitAc) {
        this.settlementAutoDebitAc = settlementAutoDebitAc;
    }

    public String getAnchorParty() {
        return anchorParty;
    }

    public void setAnchorParty(String anchorParty) {
        this.anchorParty = anchorParty;
    }

    public String getBorrowerParty() {
        return borrowerParty;
    }

    public void setBorrowerParty(String borrowerParty) {
        this.borrowerParty = borrowerParty;
    }

    public String getInvoiceBy() {
        return invoiceBy;
    }

    public void setInvoiceBy(String invoiceBy) {
        this.invoiceBy = invoiceBy;
    }

    public String getFinanceBy() {
        return financeBy;
    }

    public void setFinanceBy(String financeBy) {
        this.financeBy = financeBy;
    }

    public Integer getInterestCalculation() {
        return interestCalculation;
    }

    public void setInterestCalculation(Integer interestCalculation) {
        this.interestCalculation = interestCalculation;
    }

    public Integer getExposureMaintananceReq() {
        return exposureMaintananceReq;
    }

    public void setExposureMaintananceReq(Integer exposureMaintananceReq) {
        this.exposureMaintananceReq = exposureMaintananceReq;
    }

    public String getAccrualFrequency() {
        return accrualFrequency;
    }

    public void setAccrualFrequency(String accrualFrequency) {
        this.accrualFrequency = accrualFrequency;
    }

    public Integer getLimitID() {
        return limitID;
    }

    public void setLimitID(Integer limitID) {
        this.limitID = limitID;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getLimitEffectiveDate() {
        return limitEffectiveDate;
    }

    public void setLimitEffectiveDate(String limitEffectiveDate) {
        this.limitEffectiveDate = limitEffectiveDate;
    }

    public String getLimitExpiryDate() {
        return limitExpiryDate;
    }

    public void setLimitExpiryDate(String limitExpiryDate) {
        this.limitExpiryDate = limitExpiryDate;
    }

    public java.math.BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(java.math.BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public java.math.BigDecimal getLimitUtilizedLimit() {
        return limitUtilizedLimit;
    }

    public void setLimitUtilizedLimit(java.math.BigDecimal limitUtilizedLimit) {
        this.limitUtilizedLimit = limitUtilizedLimit;
    }

    public java.math.BigDecimal getLimitAvailableLimit() {
        return limitAvailableLimit;
    }

    public void setLimitAvailableLimit(java.math.BigDecimal limitAvailableLimit) {
        this.limitAvailableLimit = limitAvailableLimit;
    }

    public java.math.BigDecimal getLimitRecoursePercent() {
        return limitRecoursePercent;
    }

    public void setLimitRecoursePercent(java.math.BigDecimal limitRecoursePercent) {
        this.limitRecoursePercent = limitRecoursePercent;
    }

    public String getLimitRecourseApplicable() {
        return limitRecourseApplicable;
    }

    public void setLimitRecourseApplicable(String limitRecourseApplicable) {
        this.limitRecourseApplicable = limitRecourseApplicable;
    }

    public String getFinanceToParty() {
        return financeToParty;
    }

    public void setFinanceToParty(String financeToParty) {
        this.financeToParty = financeToParty;
    }

    public String getFinanceDebitParty() {
        return financeDebitParty;
    }

    public void setFinanceDebitParty(String financeDebitParty) {
        this.financeDebitParty = financeDebitParty;
    }

    public String getProductStatusCode() {
        return productStatusCode;
    }

    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSubProductName() {
        return subProductName;
    }

    public void setSubProductName(String subProductName) {
        this.subProductName = subProductName;
    }

    public Integer getAllowPayment() {
        return allowPayment;
    }

    public void setAllowPayment(Integer allowPayment) {
        this.allowPayment = allowPayment;
    }

    public Integer getAllowCollection() {
        return allowCollection;
    }

    public void setAllowCollection(Integer allowCollection) {
        this.allowCollection = allowCollection;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public static class Builder {

        private CoreProductPartyMap instance = new CoreProductPartyMap();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder applicantRefID(Integer applicantRefID) {
            instance.setApplicantRefID(applicantRefID);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            instance.setSubProductCode(subProductCode);
            return this;
        }

        public Builder subProductDescription(String subProductDescription) {
            instance.setSubProductDescription(subProductDescription);
            return this;
        }

        public Builder primaryParty(String primaryParty) {
            instance.setPrimaryParty(primaryParty);
            return this;
        }

        public Builder financingMethod(String financingMethod) {
            instance.setFinancingMethod(financingMethod);
            return this;
        }

        public Builder assetLiabilityApplicable(Integer assetLiabilityApplicable) {
            instance.setAssetLiabilityApplicable(assetLiabilityApplicable);
            return this;
        }

        public Builder creditLineApplicable(Integer creditLineApplicable) {
            instance.setCreditLineApplicable(creditLineApplicable);
            return this;
        }

        public Builder autoClosureApplicable(String autoClosureApplicable) {
            instance.setAutoClosureApplicable(autoClosureApplicable);
            return this;
        }

        public Builder recourseApplicable(String recourseApplicable) {
            instance.setRecourseApplicable(recourseApplicable);
            return this;
        }

        public Builder minTenorAllowed(Long minTenorAllowed) {
            instance.setMinTenorAllowed(minTenorAllowed);
            return this;
        }

        public Builder maxTenorAllowed(Long maxTenorAllowed) {
            instance.setMaxTenorAllowed(maxTenorAllowed);
            return this;
        }

        public Builder graceDays(Long graceDays) {
            instance.setGraceDays(graceDays);
            return this;
        }

        public Builder maxFinancePercent(java.math.BigDecimal maxFinancePercent) {
            instance.setMaxFinancePercent(maxFinancePercent);
            return this;
        }

        public Builder recoursePercent(java.math.BigDecimal recoursePercent) {
            instance.setRecoursePercent(recoursePercent);
            return this;
        }

        public Builder holidayTreatment(String holidayTreatment) {
            instance.setHolidayTreatment(holidayTreatment);
            return this;
        }

        public Builder multipleDisbursementAllowed(String multipleDisbursementAllowed) {
            instance.setMultipleDisbursementAllowed(multipleDisbursementAllowed);
            return this;
        }

        public Builder noOfDisbursementAllowed(Long noOfDisbursementAllowed) {
            instance.setNoOfDisbursementAllowed(noOfDisbursementAllowed);
            return this;
        }

        public Builder prePaymentAllowed(String prePaymentAllowed) {
            instance.setPrePaymentAllowed(prePaymentAllowed);
            return this;
        }

        public Builder partRepaymentAllowed(String partRepaymentAllowed) {
            instance.setPartRepaymentAllowed(partRepaymentAllowed);
            return this;
        }

        public Builder autoDebitAllowed(String autoDebitAllowed) {
            instance.setAutoDebitAllowed(autoDebitAllowed);
            return this;
        }

        public Builder allowedMode(String allowedMode) {
            instance.setAllowedMode(allowedMode);
            return this;
        }

        public Builder preClosureAllowed(String preClosureAllowed) {
            instance.setPreClosureAllowed(preClosureAllowed);
            return this;
        }

        public Builder allowDebitCreditAdjust(String allowDebitCreditAdjust) {
            instance.setAllowDebitCreditAdjust(allowDebitCreditAdjust);
            return this;
        }

        public Builder recessionPeriod(String recessionPeriod) {
            instance.setRecessionPeriod(recessionPeriod);
            return this;
        }

        public Builder repaymentAmountAllocation(java.math.BigDecimal repaymentAmountAllocation) {
            instance.setRepaymentAmountAllocation(repaymentAmountAllocation);
            return this;
        }

        public Builder allocationRule(String allocationRule) {
            instance.setAllocationRule(allocationRule);
            return this;
        }

        public Builder appropriationSequence(String appropriationSequence) {
            instance.setAppropriationSequence(appropriationSequence);
            return this;
        }

        public Builder npaAppropriationSequence(String npaAppropriationSequence) {
            instance.setNpaAppropriationSequence(npaAppropriationSequence);
            return this;
        }

        public Builder penaltyCalculationFrom(String penaltyCalculationFrom) {
            instance.setPenaltyCalculationFrom(penaltyCalculationFrom);
            return this;
        }

        public Builder noOfRetries(Long noOfRetries) {
            instance.setNoOfRetries(noOfRetries);
            return this;
        }

        public Builder disbursementSchedule(String disbursementSchedule) {
            instance.setDisbursementSchedule(disbursementSchedule);
            return this;
        }

        public Builder autoDebitType(String autoDebitType) {
            instance.setAutoDebitType(autoDebitType);
            return this;
        }

        public Builder intraDayDebitFrequency(String intraDayDebitFrequency) {
            instance.setIntraDayDebitFrequency(intraDayDebitFrequency);
            return this;
        }

        public Builder disbursementDays(Long disbursementDays) {
            instance.setDisbursementDays(disbursementDays);
            return this;
        }

        public Builder feesAndChargesScheme(java.math.BigDecimal feesAndChargesScheme) {
            instance.setFeesAndChargesScheme(feesAndChargesScheme);
            return this;
        }

        public Builder alertsNotificationsScheme(String alertsNotificationsScheme) {
            instance.setAlertsNotificationsScheme(alertsNotificationsScheme);
            return this;
        }

        public Builder advicesScheme(String advicesScheme) {
            instance.setAdvicesScheme(advicesScheme);
            return this;
        }

        public Builder assetScheme(String assetScheme) {
            instance.setAssetScheme(assetScheme);
            return this;
        }

        public Builder limitCollateralScheme(String limitCollateralScheme) {
            instance.setLimitCollateralScheme(limitCollateralScheme);
            return this;
        }

        public Builder npaDelinquencyWriteoff(String npaDelinquencyWriteoff) {
            instance.setNpaDelinquencyWriteoff(npaDelinquencyWriteoff);
            return this;
        }

        public Builder allowedBranches(String allowedBranches) {
            instance.setAllowedBranches(allowedBranches);
            return this;
        }

        public Builder allowedCustomerType(String allowedCustomerType) {
            instance.setAllowedCustomerType(allowedCustomerType);
            return this;
        }

        public Builder timeOfFirstDebit(String timeOfFirstDebit) {
            instance.setTimeOfFirstDebit(timeOfFirstDebit);
            return this;
        }

        public Builder noOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
            instance.setNoOfDaysFromGraceDays(noOfDaysFromGraceDays);
            return this;
        }

        public Builder customerID(Integer customerID) {
            instance.setCustomerID(customerID);
            return this;
        }

        public Builder customerProducts(String customerProducts) {
            instance.setCustomerProducts(customerProducts);
            return this;
        }

        public Builder maxDuration(Integer maxDuration) {
            instance.setMaxDuration(maxDuration);
            return this;
        }

        public Builder minDuration(Integer minDuration) {
            instance.setMinDuration(minDuration);
            return this;
        }

        public Builder stalePeriod(Long stalePeriod) {
            instance.setStalePeriod(stalePeriod);
            return this;
        }

        public Builder acceptanceRequired(String acceptanceRequired) {
            instance.setAcceptanceRequired(acceptanceRequired);
            return this;
        }

        public Builder disbursementAccount(String disbursementAccount) {
            instance.setDisbursementAccount(disbursementAccount);
            return this;
        }

        public Builder marginAccount(String marginAccount) {
            instance.setMarginAccount(marginAccount);
            return this;
        }

        public Builder onlineChargesAcc(String onlineChargesAcc) {
            instance.setOnlineChargesAcc(onlineChargesAcc);
            return this;
        }

        public Builder batchBillingChargesAcc(String batchBillingChargesAcc) {
            instance.setBatchBillingChargesAcc(batchBillingChargesAcc);
            return this;
        }

        public Builder interestCollectionAcc(String interestCollectionAcc) {
            instance.setInterestCollectionAcc(interestCollectionAcc);
            return this;
        }

        public Builder settlementAutoDebitAc(String settlementAutoDebitAc) {
            instance.setSettlementAutoDebitAc(settlementAutoDebitAc);
            return this;
        }

        public Builder anchorParty(String anchorParty) {
            instance.setAnchorParty(anchorParty);
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            instance.setBorrowerParty(borrowerParty);
            return this;
        }

        public Builder invoiceBy(String invoiceBy) {
            instance.setInvoiceBy(invoiceBy);
            return this;
        }

        public Builder financeBy(String financeBy) {
            instance.setFinanceBy(financeBy);
            return this;
        }

        public Builder interestCalculation(Integer interestCalculation) {
            instance.setInterestCalculation(interestCalculation);
            return this;
        }

        public Builder exposureMaintananceReq(Integer exposureMaintananceReq) {
            instance.setExposureMaintananceReq(exposureMaintananceReq);
            return this;
        }

        public Builder accrualFrequency(String accrualFrequency) {
            instance.setAccrualFrequency(accrualFrequency);
            return this;
        }

        public Builder limitID(Integer limitID) {
            instance.setLimitID(limitID);
            return this;
        }

        public Builder limitType(String limitType) {
            instance.setLimitType(limitType);
            return this;
        }

        public Builder limitEffectiveDate(String limitEffectiveDate) {
            instance.setLimitEffectiveDate(limitEffectiveDate);
            return this;
        }

        public Builder limitExpiryDate(String limitExpiryDate) {
            instance.setLimitExpiryDate(limitExpiryDate);
            return this;
        }

        public Builder limitAmount(java.math.BigDecimal limitAmount) {
            instance.setLimitAmount(limitAmount);
            return this;
        }

        public Builder limitUtilizedLimit(java.math.BigDecimal limitUtilizedLimit) {
            instance.setLimitUtilizedLimit(limitUtilizedLimit);
            return this;
        }

        public Builder limitAvailableLimit(java.math.BigDecimal limitAvailableLimit) {
            instance.setLimitAvailableLimit(limitAvailableLimit);
            return this;
        }

        public Builder limitRecoursePercent(java.math.BigDecimal limitRecoursePercent) {
            instance.setLimitRecoursePercent(limitRecoursePercent);
            return this;
        }

        public Builder limitRecourseApplicable(String limitRecourseApplicable) {
            instance.setLimitRecourseApplicable(limitRecourseApplicable);
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            instance.setFinanceToParty(financeToParty);
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            instance.setFinanceDebitParty(financeDebitParty);
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            instance.setProductStatusCode(productStatusCode);
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            instance.setSegmentCode(segmentCode);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder productName(String productName) {
            instance.setProductName(productName);
            return this;
        }

        public Builder subProductName(String subProductName) {
            instance.setSubProductName(subProductName);
            return this;
        }

        public Builder allowPayment(Integer allowPayment) {
            instance.setAllowPayment(allowPayment);
            return this;
        }

        public Builder allowCollection(Integer allowCollection) {
            instance.setAllowCollection(allowCollection);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public CoreProductPartyMap build() {
            return instance;
        }
    }
}
