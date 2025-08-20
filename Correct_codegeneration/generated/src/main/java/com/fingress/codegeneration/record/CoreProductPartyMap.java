package com.bsit.codegeneration.record;

public record CoreProductPartyMap(String ID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String processID, String subProductCode, String subProductDescription, String primaryParty, String financingMethod, Long assetLiabilityApplicable, Long creditLineApplicable, String autoClosureApplicable, String recourseApplicable, Long minTenorAllowed, Long maxTenorAllowed, Long graceDays, Long maxFinancePercent, Long recoursePercent, String holidayTreatment, String multipleDisbursementAllowed, Long noOfDisbursementAllowed, String prePaymentAllowed, String partRepaymentAllowed, String autoDebitAllowed, String allowedMode, String preClosureAllowed, String allowDebitCreditAdjust, String recessionPeriod, String repaymentAmountAllocation, String allocationRule, String appropriationSequence, String npaAppropriationSequence, String penaltyCalculationFrom, Long noOfRetries, String disbursementSchedule, String autoDebitType, String intraDayDebitFrequency, Long disbursementDays, String feesAndChargesScheme, String alertsNotificationsScheme, String advicesScheme, String assetScheme, String limitCollateralScheme, String npaDelinquencyWriteoff, String allowedBranches, String allowedCustomerType, String timeOfFirstDebit, Long noOfDaysFromGraceDays, String customerID, String customerProducts, String maxDuration, String minDuration, Long stalePeriod, String acceptanceRequired, String disbursementAccount, String marginAccount, String onlineChargesAcc, String batchBillingChargesAcc, String interestCollectionAcc, String settlementAutoDebitAc, String anchorParty, String borrowerParty, String invoiceBy, String financeBy, Long interestCalculation, Long exposureMaintananceReq, String accrualFrequency, String limitID, String limitType, String limitEffectiveDate, String limitExpiryDate, Long limitAmount, Long limitUtilizedLimit, Long limitAvailableLimit, Long limitRecoursePercent, String limitRecourseApplicable, String financeToParty, String financeDebitParty, String productStatusCode, String segmentCode, String productCode, String productName, String subProductName, Long allowPayment, Long allowCollection, String applicantParty, String fulfillmentParty) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String applicantPartyCode;

        private String applicantRefID;

        private String issuingPartyCode;

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

        private String processID;

        private String subProductCode;

        private String subProductDescription;

        private String primaryParty;

        private String financingMethod;

        private Long assetLiabilityApplicable;

        private Long creditLineApplicable;

        private String autoClosureApplicable;

        private String recourseApplicable;

        private Long minTenorAllowed;

        private Long maxTenorAllowed;

        private Long graceDays;

        private Long maxFinancePercent;

        private Long recoursePercent;

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

        private String repaymentAmountAllocation;

        private String allocationRule;

        private String appropriationSequence;

        private String npaAppropriationSequence;

        private String penaltyCalculationFrom;

        private Long noOfRetries;

        private String disbursementSchedule;

        private String autoDebitType;

        private String intraDayDebitFrequency;

        private Long disbursementDays;

        private String feesAndChargesScheme;

        private String alertsNotificationsScheme;

        private String advicesScheme;

        private String assetScheme;

        private String limitCollateralScheme;

        private String npaDelinquencyWriteoff;

        private String allowedBranches;

        private String allowedCustomerType;

        private String timeOfFirstDebit;

        private Long noOfDaysFromGraceDays;

        private String customerID;

        private String customerProducts;

        private String maxDuration;

        private String minDuration;

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

        private Long interestCalculation;

        private Long exposureMaintananceReq;

        private String accrualFrequency;

        private String limitID;

        private String limitType;

        private String limitEffectiveDate;

        private String limitExpiryDate;

        private Long limitAmount;

        private Long limitUtilizedLimit;

        private Long limitAvailableLimit;

        private Long limitRecoursePercent;

        private String limitRecourseApplicable;

        private String financeToParty;

        private String financeDebitParty;

        private String productStatusCode;

        private String segmentCode;

        private String productCode;

        private String productName;

        private String subProductName;

        private Long allowPayment;

        private Long allowCollection;

        private String applicantParty;

        private String fulfillmentParty;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder applicantRefID(String applicantRefID) {
            this.applicantRefID = applicantRefID;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder subProductDescription(String subProductDescription) {
            this.subProductDescription = subProductDescription;
            return this;
        }

        public Builder primaryParty(String primaryParty) {
            this.primaryParty = primaryParty;
            return this;
        }

        public Builder financingMethod(String financingMethod) {
            this.financingMethod = financingMethod;
            return this;
        }

        public Builder assetLiabilityApplicable(Long assetLiabilityApplicable) {
            this.assetLiabilityApplicable = assetLiabilityApplicable;
            return this;
        }

        public Builder creditLineApplicable(Long creditLineApplicable) {
            this.creditLineApplicable = creditLineApplicable;
            return this;
        }

        public Builder autoClosureApplicable(String autoClosureApplicable) {
            this.autoClosureApplicable = autoClosureApplicable;
            return this;
        }

        public Builder recourseApplicable(String recourseApplicable) {
            this.recourseApplicable = recourseApplicable;
            return this;
        }

        public Builder minTenorAllowed(Long minTenorAllowed) {
            this.minTenorAllowed = minTenorAllowed;
            return this;
        }

        public Builder maxTenorAllowed(Long maxTenorAllowed) {
            this.maxTenorAllowed = maxTenorAllowed;
            return this;
        }

        public Builder graceDays(Long graceDays) {
            this.graceDays = graceDays;
            return this;
        }

        public Builder maxFinancePercent(Long maxFinancePercent) {
            this.maxFinancePercent = maxFinancePercent;
            return this;
        }

        public Builder recoursePercent(Long recoursePercent) {
            this.recoursePercent = recoursePercent;
            return this;
        }

        public Builder holidayTreatment(String holidayTreatment) {
            this.holidayTreatment = holidayTreatment;
            return this;
        }

        public Builder multipleDisbursementAllowed(String multipleDisbursementAllowed) {
            this.multipleDisbursementAllowed = multipleDisbursementAllowed;
            return this;
        }

        public Builder noOfDisbursementAllowed(Long noOfDisbursementAllowed) {
            this.noOfDisbursementAllowed = noOfDisbursementAllowed;
            return this;
        }

        public Builder prePaymentAllowed(String prePaymentAllowed) {
            this.prePaymentAllowed = prePaymentAllowed;
            return this;
        }

        public Builder partRepaymentAllowed(String partRepaymentAllowed) {
            this.partRepaymentAllowed = partRepaymentAllowed;
            return this;
        }

        public Builder autoDebitAllowed(String autoDebitAllowed) {
            this.autoDebitAllowed = autoDebitAllowed;
            return this;
        }

        public Builder allowedMode(String allowedMode) {
            this.allowedMode = allowedMode;
            return this;
        }

        public Builder preClosureAllowed(String preClosureAllowed) {
            this.preClosureAllowed = preClosureAllowed;
            return this;
        }

        public Builder allowDebitCreditAdjust(String allowDebitCreditAdjust) {
            this.allowDebitCreditAdjust = allowDebitCreditAdjust;
            return this;
        }

        public Builder recessionPeriod(String recessionPeriod) {
            this.recessionPeriod = recessionPeriod;
            return this;
        }

        public Builder repaymentAmountAllocation(String repaymentAmountAllocation) {
            this.repaymentAmountAllocation = repaymentAmountAllocation;
            return this;
        }

        public Builder allocationRule(String allocationRule) {
            this.allocationRule = allocationRule;
            return this;
        }

        public Builder appropriationSequence(String appropriationSequence) {
            this.appropriationSequence = appropriationSequence;
            return this;
        }

        public Builder npaAppropriationSequence(String npaAppropriationSequence) {
            this.npaAppropriationSequence = npaAppropriationSequence;
            return this;
        }

        public Builder penaltyCalculationFrom(String penaltyCalculationFrom) {
            this.penaltyCalculationFrom = penaltyCalculationFrom;
            return this;
        }

        public Builder noOfRetries(Long noOfRetries) {
            this.noOfRetries = noOfRetries;
            return this;
        }

        public Builder disbursementSchedule(String disbursementSchedule) {
            this.disbursementSchedule = disbursementSchedule;
            return this;
        }

        public Builder autoDebitType(String autoDebitType) {
            this.autoDebitType = autoDebitType;
            return this;
        }

        public Builder intraDayDebitFrequency(String intraDayDebitFrequency) {
            this.intraDayDebitFrequency = intraDayDebitFrequency;
            return this;
        }

        public Builder disbursementDays(Long disbursementDays) {
            this.disbursementDays = disbursementDays;
            return this;
        }

        public Builder feesAndChargesScheme(String feesAndChargesScheme) {
            this.feesAndChargesScheme = feesAndChargesScheme;
            return this;
        }

        public Builder alertsNotificationsScheme(String alertsNotificationsScheme) {
            this.alertsNotificationsScheme = alertsNotificationsScheme;
            return this;
        }

        public Builder advicesScheme(String advicesScheme) {
            this.advicesScheme = advicesScheme;
            return this;
        }

        public Builder assetScheme(String assetScheme) {
            this.assetScheme = assetScheme;
            return this;
        }

        public Builder limitCollateralScheme(String limitCollateralScheme) {
            this.limitCollateralScheme = limitCollateralScheme;
            return this;
        }

        public Builder npaDelinquencyWriteoff(String npaDelinquencyWriteoff) {
            this.npaDelinquencyWriteoff = npaDelinquencyWriteoff;
            return this;
        }

        public Builder allowedBranches(String allowedBranches) {
            this.allowedBranches = allowedBranches;
            return this;
        }

        public Builder allowedCustomerType(String allowedCustomerType) {
            this.allowedCustomerType = allowedCustomerType;
            return this;
        }

        public Builder timeOfFirstDebit(String timeOfFirstDebit) {
            this.timeOfFirstDebit = timeOfFirstDebit;
            return this;
        }

        public Builder noOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
            this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
            return this;
        }

        public Builder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder customerProducts(String customerProducts) {
            this.customerProducts = customerProducts;
            return this;
        }

        public Builder maxDuration(String maxDuration) {
            this.maxDuration = maxDuration;
            return this;
        }

        public Builder minDuration(String minDuration) {
            this.minDuration = minDuration;
            return this;
        }

        public Builder stalePeriod(Long stalePeriod) {
            this.stalePeriod = stalePeriod;
            return this;
        }

        public Builder acceptanceRequired(String acceptanceRequired) {
            this.acceptanceRequired = acceptanceRequired;
            return this;
        }

        public Builder disbursementAccount(String disbursementAccount) {
            this.disbursementAccount = disbursementAccount;
            return this;
        }

        public Builder marginAccount(String marginAccount) {
            this.marginAccount = marginAccount;
            return this;
        }

        public Builder onlineChargesAcc(String onlineChargesAcc) {
            this.onlineChargesAcc = onlineChargesAcc;
            return this;
        }

        public Builder batchBillingChargesAcc(String batchBillingChargesAcc) {
            this.batchBillingChargesAcc = batchBillingChargesAcc;
            return this;
        }

        public Builder interestCollectionAcc(String interestCollectionAcc) {
            this.interestCollectionAcc = interestCollectionAcc;
            return this;
        }

        public Builder settlementAutoDebitAc(String settlementAutoDebitAc) {
            this.settlementAutoDebitAc = settlementAutoDebitAc;
            return this;
        }

        public Builder anchorParty(String anchorParty) {
            this.anchorParty = anchorParty;
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            this.borrowerParty = borrowerParty;
            return this;
        }

        public Builder invoiceBy(String invoiceBy) {
            this.invoiceBy = invoiceBy;
            return this;
        }

        public Builder financeBy(String financeBy) {
            this.financeBy = financeBy;
            return this;
        }

        public Builder interestCalculation(Long interestCalculation) {
            this.interestCalculation = interestCalculation;
            return this;
        }

        public Builder exposureMaintananceReq(Long exposureMaintananceReq) {
            this.exposureMaintananceReq = exposureMaintananceReq;
            return this;
        }

        public Builder accrualFrequency(String accrualFrequency) {
            this.accrualFrequency = accrualFrequency;
            return this;
        }

        public Builder limitID(String limitID) {
            this.limitID = limitID;
            return this;
        }

        public Builder limitType(String limitType) {
            this.limitType = limitType;
            return this;
        }

        public Builder limitEffectiveDate(String limitEffectiveDate) {
            this.limitEffectiveDate = limitEffectiveDate;
            return this;
        }

        public Builder limitExpiryDate(String limitExpiryDate) {
            this.limitExpiryDate = limitExpiryDate;
            return this;
        }

        public Builder limitAmount(Long limitAmount) {
            this.limitAmount = limitAmount;
            return this;
        }

        public Builder limitUtilizedLimit(Long limitUtilizedLimit) {
            this.limitUtilizedLimit = limitUtilizedLimit;
            return this;
        }

        public Builder limitAvailableLimit(Long limitAvailableLimit) {
            this.limitAvailableLimit = limitAvailableLimit;
            return this;
        }

        public Builder limitRecoursePercent(Long limitRecoursePercent) {
            this.limitRecoursePercent = limitRecoursePercent;
            return this;
        }

        public Builder limitRecourseApplicable(String limitRecourseApplicable) {
            this.limitRecourseApplicable = limitRecourseApplicable;
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            this.financeToParty = financeToParty;
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            this.financeDebitParty = financeDebitParty;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder subProductName(String subProductName) {
            this.subProductName = subProductName;
            return this;
        }

        public Builder allowPayment(Long allowPayment) {
            this.allowPayment = allowPayment;
            return this;
        }

        public Builder allowCollection(Long allowCollection) {
            this.allowCollection = allowCollection;
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

        public CoreProductPartyMap build() {
            return new CoreProductPartyMap(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, processID, subProductCode, subProductDescription, primaryParty, financingMethod, assetLiabilityApplicable, creditLineApplicable, autoClosureApplicable, recourseApplicable, minTenorAllowed, maxTenorAllowed, graceDays, maxFinancePercent, recoursePercent, holidayTreatment, multipleDisbursementAllowed, noOfDisbursementAllowed, prePaymentAllowed, partRepaymentAllowed, autoDebitAllowed, allowedMode, preClosureAllowed, allowDebitCreditAdjust, recessionPeriod, repaymentAmountAllocation, allocationRule, appropriationSequence, npaAppropriationSequence, penaltyCalculationFrom, noOfRetries, disbursementSchedule, autoDebitType, intraDayDebitFrequency, disbursementDays, feesAndChargesScheme, alertsNotificationsScheme, advicesScheme, assetScheme, limitCollateralScheme, npaDelinquencyWriteoff, allowedBranches, allowedCustomerType, timeOfFirstDebit, noOfDaysFromGraceDays, customerID, customerProducts, maxDuration, minDuration, stalePeriod, acceptanceRequired, disbursementAccount, marginAccount, onlineChargesAcc, batchBillingChargesAcc, interestCollectionAcc, settlementAutoDebitAc, anchorParty, borrowerParty, invoiceBy, financeBy, interestCalculation, exposureMaintananceReq, accrualFrequency, limitID, limitType, limitEffectiveDate, limitExpiryDate, limitAmount, limitUtilizedLimit, limitAvailableLimit, limitRecoursePercent, limitRecourseApplicable, financeToParty, financeDebitParty, productStatusCode, segmentCode, productCode, productName, subProductName, allowPayment, allowCollection, applicantParty, fulfillmentParty);
        }
    }
}
