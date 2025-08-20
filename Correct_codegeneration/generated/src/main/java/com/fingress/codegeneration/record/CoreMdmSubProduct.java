package com.bsit.codegeneration.record;

public record CoreMdmSubProduct(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String productCode, String productName, String productDescription, String productGroupCode, String productSubgroupCode, Long assetLiabilityApplicable, Long creditLineApplicable, String autoClosureApplicable, String recourseApplicable, Long minTenorAllowed, Long maxTenorAllowed, String graceDays, String maxFinancePercent, Long recoursePercent, Long holidayTreatment, Long noOfDaysFromGraceDays, String multipleDisbursementAllowed, Long noOfDisbursementsAllowed, String disbursementSchedule, Long disbursementDays, String prePaymentAllowed, String partRepaymentAllowed, String autoDebitAllowed, String allowedMode, Long noOfRetries, String autoDebitType, String intraDayDebitFrequency, String timeOfFirstDebit, String preClosureAllowed, String allowDebitCreditAdjustments, String repaymentAmountAllocation, String allocationRule, String appropriationSequence, String npaAppropriationSequence, String penaltyCalculationFrom, String feesAndChargesScheme, String alertsNotificationsScheme, String advicesScheme, String assetScheme, String limitAndCollateralScheme, String npaDelinquency, String productStatusCode, Long suffixID, String suffixName, String suffixDescription, String sourceSystemCode, String baShortName, String classification, String subProductCode, String subProductDescription, String primaryParty, String financingMethod, String anchorParty, String borrowerParty, Long exposureMaintananceReq, String invoiceBy, String financeBy, Long interestCalculation, Long accrualAmortize, String financeDebitParty, String financeToParty, String subProductName, String segmentCode, Long cutoffApplicable, Long chargesApplicable, Long holidayApplicable, Long allowPayment, Long allowCollection, Long versionID, Long isMasterVersion, String uploadRefID) {

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

        private String productCode;

        private String productName;

        private String productDescription;

        private String productGroupCode;

        private String productSubgroupCode;

        private Long assetLiabilityApplicable;

        private Long creditLineApplicable;

        private String autoClosureApplicable;

        private String recourseApplicable;

        private Long minTenorAllowed;

        private Long maxTenorAllowed;

        private String graceDays;

        private String maxFinancePercent;

        private Long recoursePercent;

        private Long holidayTreatment;

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

        private String repaymentAmountAllocation;

        private String allocationRule;

        private String appropriationSequence;

        private String npaAppropriationSequence;

        private String penaltyCalculationFrom;

        private String feesAndChargesScheme;

        private String alertsNotificationsScheme;

        private String advicesScheme;

        private String assetScheme;

        private String limitAndCollateralScheme;

        private String npaDelinquency;

        private String productStatusCode;

        private Long suffixID;

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

        private Long exposureMaintananceReq;

        private String invoiceBy;

        private String financeBy;

        private Long interestCalculation;

        private Long accrualAmortize;

        private String financeDebitParty;

        private String financeToParty;

        private String subProductName;

        private String segmentCode;

        private Long cutoffApplicable;

        private Long chargesApplicable;

        private Long holidayApplicable;

        private Long allowPayment;

        private Long allowCollection;

        private Long versionID;

        private Long isMasterVersion;

        private String uploadRefID;

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

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder productGroupCode(String productGroupCode) {
            this.productGroupCode = productGroupCode;
            return this;
        }

        public Builder productSubgroupCode(String productSubgroupCode) {
            this.productSubgroupCode = productSubgroupCode;
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

        public Builder graceDays(String graceDays) {
            this.graceDays = graceDays;
            return this;
        }

        public Builder maxFinancePercent(String maxFinancePercent) {
            this.maxFinancePercent = maxFinancePercent;
            return this;
        }

        public Builder recoursePercent(Long recoursePercent) {
            this.recoursePercent = recoursePercent;
            return this;
        }

        public Builder holidayTreatment(Long holidayTreatment) {
            this.holidayTreatment = holidayTreatment;
            return this;
        }

        public Builder noOfDaysFromGraceDays(Long noOfDaysFromGraceDays) {
            this.noOfDaysFromGraceDays = noOfDaysFromGraceDays;
            return this;
        }

        public Builder multipleDisbursementAllowed(String multipleDisbursementAllowed) {
            this.multipleDisbursementAllowed = multipleDisbursementAllowed;
            return this;
        }

        public Builder noOfDisbursementsAllowed(Long noOfDisbursementsAllowed) {
            this.noOfDisbursementsAllowed = noOfDisbursementsAllowed;
            return this;
        }

        public Builder disbursementSchedule(String disbursementSchedule) {
            this.disbursementSchedule = disbursementSchedule;
            return this;
        }

        public Builder disbursementDays(Long disbursementDays) {
            this.disbursementDays = disbursementDays;
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

        public Builder noOfRetries(Long noOfRetries) {
            this.noOfRetries = noOfRetries;
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

        public Builder timeOfFirstDebit(String timeOfFirstDebit) {
            this.timeOfFirstDebit = timeOfFirstDebit;
            return this;
        }

        public Builder preClosureAllowed(String preClosureAllowed) {
            this.preClosureAllowed = preClosureAllowed;
            return this;
        }

        public Builder allowDebitCreditAdjustments(String allowDebitCreditAdjustments) {
            this.allowDebitCreditAdjustments = allowDebitCreditAdjustments;
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

        public Builder limitAndCollateralScheme(String limitAndCollateralScheme) {
            this.limitAndCollateralScheme = limitAndCollateralScheme;
            return this;
        }

        public Builder npaDelinquency(String npaDelinquency) {
            this.npaDelinquency = npaDelinquency;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public Builder suffixID(Long suffixID) {
            this.suffixID = suffixID;
            return this;
        }

        public Builder suffixName(String suffixName) {
            this.suffixName = suffixName;
            return this;
        }

        public Builder suffixDescription(String suffixDescription) {
            this.suffixDescription = suffixDescription;
            return this;
        }

        public Builder sourceSystemCode(String sourceSystemCode) {
            this.sourceSystemCode = sourceSystemCode;
            return this;
        }

        public Builder baShortName(String baShortName) {
            this.baShortName = baShortName;
            return this;
        }

        public Builder classification(String classification) {
            this.classification = classification;
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

        public Builder anchorParty(String anchorParty) {
            this.anchorParty = anchorParty;
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            this.borrowerParty = borrowerParty;
            return this;
        }

        public Builder exposureMaintananceReq(Long exposureMaintananceReq) {
            this.exposureMaintananceReq = exposureMaintananceReq;
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

        public Builder accrualAmortize(Long accrualAmortize) {
            this.accrualAmortize = accrualAmortize;
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            this.financeDebitParty = financeDebitParty;
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            this.financeToParty = financeToParty;
            return this;
        }

        public Builder subProductName(String subProductName) {
            this.subProductName = subProductName;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder cutoffApplicable(Long cutoffApplicable) {
            this.cutoffApplicable = cutoffApplicable;
            return this;
        }

        public Builder chargesApplicable(Long chargesApplicable) {
            this.chargesApplicable = chargesApplicable;
            return this;
        }

        public Builder holidayApplicable(Long holidayApplicable) {
            this.holidayApplicable = holidayApplicable;
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

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public CoreMdmSubProduct build() {
            return new CoreMdmSubProduct(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, productCode, productName, productDescription, productGroupCode, productSubgroupCode, assetLiabilityApplicable, creditLineApplicable, autoClosureApplicable, recourseApplicable, minTenorAllowed, maxTenorAllowed, graceDays, maxFinancePercent, recoursePercent, holidayTreatment, noOfDaysFromGraceDays, multipleDisbursementAllowed, noOfDisbursementsAllowed, disbursementSchedule, disbursementDays, prePaymentAllowed, partRepaymentAllowed, autoDebitAllowed, allowedMode, noOfRetries, autoDebitType, intraDayDebitFrequency, timeOfFirstDebit, preClosureAllowed, allowDebitCreditAdjustments, repaymentAmountAllocation, allocationRule, appropriationSequence, npaAppropriationSequence, penaltyCalculationFrom, feesAndChargesScheme, alertsNotificationsScheme, advicesScheme, assetScheme, limitAndCollateralScheme, npaDelinquency, productStatusCode, suffixID, suffixName, suffixDescription, sourceSystemCode, baShortName, classification, subProductCode, subProductDescription, primaryParty, financingMethod, anchorParty, borrowerParty, exposureMaintananceReq, invoiceBy, financeBy, interestCalculation, accrualAmortize, financeDebitParty, financeToParty, subProductName, segmentCode, cutoffApplicable, chargesApplicable, holidayApplicable, allowPayment, allowCollection, versionID, isMasterVersion, uploadRefID);
        }
    }
}
