package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class CoreMdmSubProduct {

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

    private String applicantParty;

    private String fulfillmentParty;

    private Integer isTemplate;

    private String productCode;

    private String productName;

    private String productDescription;

    private String productGroupCode;

    private String productSubgroupCode;

    private Integer assetLiabilityApplicable;

    private Integer creditLineApplicable;

    private String autoClosureApplicable;

    private String recourseApplicable;

    private Long minTenorAllowed;

    private Long maxTenorAllowed;

    private String graceDays;

    private String maxFinancePercent;

    private java.math.BigDecimal recoursePercent;

    private java.math.BigDecimal holidayTreatment;

    private Long noOfDaysFromGraceDays;

    private String multipleDisbursementAllowed;

    private Long noOfDisbursementsAllowed;

    private String disbursementSchedule;

    private Long disbursementDays;

    private String prePaymentAllowed;

    private String partRepaymentAllowed;

    private String autoDebitAllowed;

    private String allowedMode;

    private Long noOfRetries;

    private String autoDebitType;

    private String intraDayDebitFrequency;

    private String timeOfFirstDebit;

    private String preClosureAllowed;

    private String allowDebitCreditAdjustments;

    private java.math.BigDecimal repaymentAmountAllocation;

    private String allocationRule;

    private String appropriationSequence;

    private String npaAppropriationSequence;

    private String penaltyCalculationFrom;

    private java.math.BigDecimal feesAndChargesScheme;

    private String alertsNotificationsScheme;

    private String advicesScheme;

    private String assetScheme;

    private String limitAndCollateralScheme;

    private String npaDelinquency;

    private String productStatusCode;

    private Integer suffixID;

    private String suffixName;

    private String suffixDescription;

    private String sourceSystemCode;

    private String baShortName;

    private String classification;

    private String subProductCode;

    private String subProductDescription;

    private String primaryParty;

    private String financingMethod;

    private String anchorParty;

    private String borrowerParty;

    private Integer exposureMaintananceReq;

    private String invoiceBy;

    private String financeBy;

    private Integer interestCalculation;

    private Integer accrualAmortize;

    private String financeDebitParty;

    private String financeToParty;

    private String subProductName;

    private String segmentCode;

    private Integer cutoffApplicable;

    private Integer chargesApplicable;

    private Integer holidayApplicable;

    private Integer allowPayment;

    private Integer allowCollection;

    private Integer versionID;

    private Integer isMasterVersion;

    private Integer uploadRefID;

    public CoreMdmSubProduct() {
    }

    public CoreMdmSubProduct(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String productCode, String productName, String productDescription, String productGroupCode, String productSubgroupCode, Integer assetLiabilityApplicable, Integer creditLineApplicable, String autoClosureApplicable, String recourseApplicable, Long minTenorAllowed, Long maxTenorAllowed, String graceDays, String maxFinancePercent, java.math.BigDecimal recoursePercent, java.math.BigDecimal holidayTreatment, Long noOfDaysFromGraceDays, String multipleDisbursementAllowed, Long noOfDisbursementsAllowed, String disbursementSchedule, Long disbursementDays, String prePaymentAllowed, String partRepaymentAllowed, String autoDebitAllowed, String allowedMode, Long noOfRetries, String autoDebitType, String intraDayDebitFrequency, String timeOfFirstDebit, String preClosureAllowed, String allowDebitCreditAdjustments, java.math.BigDecimal repaymentAmountAllocation, String allocationRule, String appropriationSequence, String npaAppropriationSequence, String penaltyCalculationFrom, java.math.BigDecimal feesAndChargesScheme, String alertsNotificationsScheme, String advicesScheme, String assetScheme, String limitAndCollateralScheme, String npaDelinquency, String productStatusCode, Integer suffixID, String suffixName, String suffixDescription, String sourceSystemCode, String baShortName, String classification, String subProductCode, String subProductDescription, String primaryParty, String financingMethod, String anchorParty, String borrowerParty, Integer exposureMaintananceReq, String invoiceBy, String financeBy, Integer interestCalculation, Integer accrualAmortize, String financeDebitParty, String financeToParty, String subProductName, String segmentCode, Integer cutoffApplicable, Integer chargesApplicable, Integer holidayApplicable, Integer allowPayment, Integer allowCollection, Integer versionID, Integer isMasterVersion, Integer uploadRefID) {
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
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productGroupCode = productGroupCode;
        this.productSubgroupCode = productSubgroupCode;
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
        this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
        this.multipleDisbursementAllowed = multipleDisbursementAllowed;
        this.noOfDisbursementsAllowed = noOfDisbursementsAllowed;
        this.disbursementSchedule = disbursementSchedule;
        this.disbursementDays = disbursementDays;
        this.prePaymentAllowed = prePaymentAllowed;
        this.partRepaymentAllowed = partRepaymentAllowed;
        this.autoDebitAllowed = autoDebitAllowed;
        this.allowedMode = allowedMode;
        this.noOfRetries = noOfRetries;
        this.autoDebitType = autoDebitType;
        this.intraDayDebitFrequency = intraDayDebitFrequency;
        this.timeOfFirstDebit = timeOfFirstDebit;
        this.preClosureAllowed = preClosureAllowed;
        this.allowDebitCreditAdjustments = allowDebitCreditAdjustments;
        this.repaymentAmountAllocation = repaymentAmountAllocation;
        this.allocationRule = allocationRule;
        this.appropriationSequence = appropriationSequence;
        this.npaAppropriationSequence = npaAppropriationSequence;
        this.penaltyCalculationFrom = penaltyCalculationFrom;
        this.feesAndChargesScheme = feesAndChargesScheme;
        this.alertsNotificationsScheme = alertsNotificationsScheme;
        this.advicesScheme = advicesScheme;
        this.assetScheme = assetScheme;
        this.limitAndCollateralScheme = limitAndCollateralScheme;
        this.npaDelinquency = npaDelinquency;
        this.productStatusCode = productStatusCode;
        this.suffixID = suffixID;
        this.suffixName = suffixName;
        this.suffixDescription = suffixDescription;
        this.sourceSystemCode = sourceSystemCode;
        this.baShortName = baShortName;
        this.classification = classification;
        this.subProductCode = subProductCode;
        this.subProductDescription = subProductDescription;
        this.primaryParty = primaryParty;
        this.financingMethod = financingMethod;
        this.anchorParty = anchorParty;
        this.borrowerParty = borrowerParty;
        this.exposureMaintananceReq = exposureMaintananceReq;
        this.invoiceBy = invoiceBy;
        this.financeBy = financeBy;
        this.interestCalculation = interestCalculation;
        this.accrualAmortize = accrualAmortize;
        this.financeDebitParty = financeDebitParty;
        this.financeToParty = financeToParty;
        this.subProductName = subProductName;
        this.segmentCode = segmentCode;
        this.cutoffApplicable = cutoffApplicable;
        this.chargesApplicable = chargesApplicable;
        this.holidayApplicable = holidayApplicable;
        this.allowPayment = allowPayment;
        this.allowCollection = allowCollection;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.uploadRefID = uploadRefID;
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

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getProductSubgroupCode() {
        return productSubgroupCode;
    }

    public void setProductSubgroupCode(String productSubgroupCode) {
        this.productSubgroupCode = productSubgroupCode;
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

    public String getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(String graceDays) {
        this.graceDays = graceDays;
    }

    public String getMaxFinancePercent() {
        return maxFinancePercent;
    }

    public void setMaxFinancePercent(String maxFinancePercent) {
        this.maxFinancePercent = maxFinancePercent;
    }

    public java.math.BigDecimal getRecoursePercent() {
        return recoursePercent;
    }

    public void setRecoursePercent(java.math.BigDecimal recoursePercent) {
        this.recoursePercent = recoursePercent;
    }

    public java.math.BigDecimal getHolidayTreatment() {
        return holidayTreatment;
    }

    public void setHolidayTreatment(java.math.BigDecimal holidayTreatment) {
        this.holidayTreatment = holidayTreatment;
    }

    public Long getNoOfDaysFromGraceDays() {
        return noOfDaysFromGraceDays;
    }

    public void setNoOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
        this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
    }

    public String getMultipleDisbursementAllowed() {
        return multipleDisbursementAllowed;
    }

    public void setMultipleDisbursementAllowed(String multipleDisbursementAllowed) {
        this.multipleDisbursementAllowed = multipleDisbursementAllowed;
    }

    public Long getNoOfDisbursementsAllowed() {
        return noOfDisbursementsAllowed;
    }

    public void setNoOfDisbursementsAllowed(Long noOfDisbursementsAllowed) {
        this.noOfDisbursementsAllowed = noOfDisbursementsAllowed;
    }

    public String getDisbursementSchedule() {
        return disbursementSchedule;
    }

    public void setDisbursementSchedule(String disbursementSchedule) {
        this.disbursementSchedule = disbursementSchedule;
    }

    public Long getDisbursementDays() {
        return disbursementDays;
    }

    public void setDisbursementDays(Long disbursementDays) {
        this.disbursementDays = disbursementDays;
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

    public Long getNoOfRetries() {
        return noOfRetries;
    }

    public void setNoOfRetries(Long noOfRetries) {
        this.noOfRetries = noOfRetries;
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

    public String getTimeOfFirstDebit() {
        return timeOfFirstDebit;
    }

    public void setTimeOfFirstDebit(String timeOfFirstDebit) {
        this.timeOfFirstDebit = timeOfFirstDebit;
    }

    public String getPreClosureAllowed() {
        return preClosureAllowed;
    }

    public void setPreClosureAllowed(String preClosureAllowed) {
        this.preClosureAllowed = preClosureAllowed;
    }

    public String getAllowDebitCreditAdjustments() {
        return allowDebitCreditAdjustments;
    }

    public void setAllowDebitCreditAdjustments(String allowDebitCreditAdjustments) {
        this.allowDebitCreditAdjustments = allowDebitCreditAdjustments;
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

    public String getLimitAndCollateralScheme() {
        return limitAndCollateralScheme;
    }

    public void setLimitAndCollateralScheme(String limitAndCollateralScheme) {
        this.limitAndCollateralScheme = limitAndCollateralScheme;
    }

    public String getNpaDelinquency() {
        return npaDelinquency;
    }

    public void setNpaDelinquency(String npaDelinquency) {
        this.npaDelinquency = npaDelinquency;
    }

    public String getProductStatusCode() {
        return productStatusCode;
    }

    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    public Integer getSuffixID() {
        return suffixID;
    }

    public void setSuffixID(Integer suffixID) {
        this.suffixID = suffixID;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public String getSuffixDescription() {
        return suffixDescription;
    }

    public void setSuffixDescription(String suffixDescription) {
        this.suffixDescription = suffixDescription;
    }

    public String getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(String sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public String getBaShortName() {
        return baShortName;
    }

    public void setBaShortName(String baShortName) {
        this.baShortName = baShortName;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public Integer getExposureMaintananceReq() {
        return exposureMaintananceReq;
    }

    public void setExposureMaintananceReq(Integer exposureMaintananceReq) {
        this.exposureMaintananceReq = exposureMaintananceReq;
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

    public Integer getAccrualAmortize() {
        return accrualAmortize;
    }

    public void setAccrualAmortize(Integer accrualAmortize) {
        this.accrualAmortize = accrualAmortize;
    }

    public String getFinanceDebitParty() {
        return financeDebitParty;
    }

    public void setFinanceDebitParty(String financeDebitParty) {
        this.financeDebitParty = financeDebitParty;
    }

    public String getFinanceToParty() {
        return financeToParty;
    }

    public void setFinanceToParty(String financeToParty) {
        this.financeToParty = financeToParty;
    }

    public String getSubProductName() {
        return subProductName;
    }

    public void setSubProductName(String subProductName) {
        this.subProductName = subProductName;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public Integer getCutoffApplicable() {
        return cutoffApplicable;
    }

    public void setCutoffApplicable(Integer cutoffApplicable) {
        this.cutoffApplicable = cutoffApplicable;
    }

    public Integer getChargesApplicable() {
        return chargesApplicable;
    }

    public void setChargesApplicable(Integer chargesApplicable) {
        this.chargesApplicable = chargesApplicable;
    }

    public Integer getHolidayApplicable() {
        return holidayApplicable;
    }

    public void setHolidayApplicable(Integer holidayApplicable) {
        this.holidayApplicable = holidayApplicable;
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

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public static class Builder {

        private CoreMdmSubProduct instance = new CoreMdmSubProduct();

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

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
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

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder productName(String productName) {
            instance.setProductName(productName);
            return this;
        }

        public Builder productDescription(String productDescription) {
            instance.setProductDescription(productDescription);
            return this;
        }

        public Builder productGroupCode(String productGroupCode) {
            instance.setProductGroupCode(productGroupCode);
            return this;
        }

        public Builder productSubgroupCode(String productSubgroupCode) {
            instance.setProductSubgroupCode(productSubgroupCode);
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

        public Builder graceDays(String graceDays) {
            instance.setGraceDays(graceDays);
            return this;
        }

        public Builder maxFinancePercent(String maxFinancePercent) {
            instance.setMaxFinancePercent(maxFinancePercent);
            return this;
        }

        public Builder recoursePercent(java.math.BigDecimal recoursePercent) {
            instance.setRecoursePercent(recoursePercent);
            return this;
        }

        public Builder holidayTreatment(java.math.BigDecimal holidayTreatment) {
            instance.setHolidayTreatment(holidayTreatment);
            return this;
        }

        public Builder noOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
            instance.setNoOfDaysFromGraceDays(noOfDaysFromGraceDays);
            return this;
        }

        public Builder multipleDisbursementAllowed(String multipleDisbursementAllowed) {
            instance.setMultipleDisbursementAllowed(multipleDisbursementAllowed);
            return this;
        }

        public Builder noOfDisbursementsAllowed(Long noOfDisbursementsAllowed) {
            instance.setNoOfDisbursementsAllowed(noOfDisbursementsAllowed);
            return this;
        }

        public Builder disbursementSchedule(String disbursementSchedule) {
            instance.setDisbursementSchedule(disbursementSchedule);
            return this;
        }

        public Builder disbursementDays(Long disbursementDays) {
            instance.setDisbursementDays(disbursementDays);
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

        public Builder noOfRetries(Long noOfRetries) {
            instance.setNoOfRetries(noOfRetries);
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

        public Builder timeOfFirstDebit(String timeOfFirstDebit) {
            instance.setTimeOfFirstDebit(timeOfFirstDebit);
            return this;
        }

        public Builder preClosureAllowed(String preClosureAllowed) {
            instance.setPreClosureAllowed(preClosureAllowed);
            return this;
        }

        public Builder allowDebitCreditAdjustments(String allowDebitCreditAdjustments) {
            instance.setAllowDebitCreditAdjustments(allowDebitCreditAdjustments);
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

        public Builder limitAndCollateralScheme(String limitAndCollateralScheme) {
            instance.setLimitAndCollateralScheme(limitAndCollateralScheme);
            return this;
        }

        public Builder npaDelinquency(String npaDelinquency) {
            instance.setNpaDelinquency(npaDelinquency);
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            instance.setProductStatusCode(productStatusCode);
            return this;
        }

        public Builder suffixID(Integer suffixID) {
            instance.setSuffixID(suffixID);
            return this;
        }

        public Builder suffixName(String suffixName) {
            instance.setSuffixName(suffixName);
            return this;
        }

        public Builder suffixDescription(String suffixDescription) {
            instance.setSuffixDescription(suffixDescription);
            return this;
        }

        public Builder sourceSystemCode(String sourceSystemCode) {
            instance.setSourceSystemCode(sourceSystemCode);
            return this;
        }

        public Builder baShortName(String baShortName) {
            instance.setBaShortName(baShortName);
            return this;
        }

        public Builder classification(String classification) {
            instance.setClassification(classification);
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

        public Builder anchorParty(String anchorParty) {
            instance.setAnchorParty(anchorParty);
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            instance.setBorrowerParty(borrowerParty);
            return this;
        }

        public Builder exposureMaintananceReq(Integer exposureMaintananceReq) {
            instance.setExposureMaintananceReq(exposureMaintananceReq);
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

        public Builder accrualAmortize(Integer accrualAmortize) {
            instance.setAccrualAmortize(accrualAmortize);
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            instance.setFinanceDebitParty(financeDebitParty);
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            instance.setFinanceToParty(financeToParty);
            return this;
        }

        public Builder subProductName(String subProductName) {
            instance.setSubProductName(subProductName);
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            instance.setSegmentCode(segmentCode);
            return this;
        }

        public Builder cutoffApplicable(Integer cutoffApplicable) {
            instance.setCutoffApplicable(cutoffApplicable);
            return this;
        }

        public Builder chargesApplicable(Integer chargesApplicable) {
            instance.setChargesApplicable(chargesApplicable);
            return this;
        }

        public Builder holidayApplicable(Integer holidayApplicable) {
            instance.setHolidayApplicable(holidayApplicable);
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

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public CoreMdmSubProduct build() {
            return instance;
        }
    }
}
