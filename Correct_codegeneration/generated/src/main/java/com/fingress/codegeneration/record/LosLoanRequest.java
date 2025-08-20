package com.bsit.codegeneration.record;

public record LosLoanRequest(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String fulfillmentParty, Long isTemplate, Long utilizedAmount, Long outstandingAmount, String limitNodeReference, Long requestTenor, String requestStatusCode, java.time.LocalDateTime requestDisbursementDate, String rmPartyReference, String parentFacilityLimitID, String facilityLimitID, String leiNumber, String leiStatusCode, String interestTypeCode, String offerCode, Long tenorMin, Long tenorMax, String processingModeCode, String resetFrequenctPeriodCode, String loanAccountNumber, java.time.LocalDateTime loanStartDate, String sanctionedAmountCcyCode, Long sanctionedAmount, String applicantParty, String sanctionedDate, String disbursementAccount, java.time.LocalDateTime disbursedDate, String settlementAccount, Long wcdlLimitAvailable, Long wcdlFacilityValidity, Long loanOverdueCheck, Long coolingPeriodCheck, Long leiAvailableCheck, String internalRatingTypeCode, String internalRatingValue, Long rarocStatusCheck, Long rarocFacilityCheck, Long pslAvailabilityCheck, String flowTypeCode, Long digitalFlowFlag, String lobCode, String requestDate, String requestCategoryCode, String requestTypeCode, String requestCurrencyCode, Long requestAmount, String requestTenorUom, String orgCifCode, String orgUserCifCode, String facilityTypeCode, Long rateOfInterest, String tenorUom, String productCode, String subProductCode, String externalRatingTypeCode, String externalRatingValue, String offerTypeCode, String acceptanceParty, String assessmentParty, String productStatusCode, String acceptanceReasonCode, String acceptanceComments, java.time.LocalDateTime acceptanceDate, String assessmentReasonCode, String assessmentComments, java.time.LocalDateTime assessmentDate, String tenureDays, String uploadRefID, String routingCode, String routingTypeCode, String bankCode, String transactionID, String offerBenchmark, Long availableLimit, String priority, String schemeCode, String accountOpeningDate, String notes, String repricingPlan, String rateFixingMethod, java.time.LocalDateTime peggingReviewDate, String peggingFrequency, String interestRateCode, Long spread, Long customerPreferentialInterest, String penalInterestTableCode, String penalPreferentialPercentage, String holdInOptAccForAmtDue, String repaymentMethod, String recyOnlyIntByAccDebit, Long operativeAccountNo, String huntingRequired, String strucRepaymentSchedule, String equatedInstalment, String noOfInstalment, java.time.LocalDateTime instalmentStartDate, String instalmentFrequency, String interestFrequency, java.time.LocalDateTime instlFrequencyStartDate, java.time.LocalDateTime interestFrequencyStartDate, String moratoriumPeriod, java.time.LocalDateTime moratoriumInterestStartDate, String moratoriumPeriodIntFreq, java.time.LocalDateTime moratoriumIntFreqStartDate, String subsectorCode, String sectorCode, String modeOfAdvance, String rolloverFlag, String disbAuthRemarks, String paymentMode, Long amount, String beneficiaryAccountNo, String beneficiaryAccountType, String beneficiaryName, String beneficiaryAddress, String ifscCode, String paymentProduct, Long ccyRate, String beneficiaryType, String beneficiaryLeiNumber, String makerTempNo, String amtInWords, Long drawingPower, Long limitAsPerSystem, String disbTillDtUnderContract, Long freeLimitsForDisb, String disbTillDtUnderFacility, Long poLimit, Long systemFreePoLimit, java.time.LocalDateTime maturityDate, Long loanSpread, Long minRarocSpread, Long minFbilFimmdaSpread, java.time.LocalDateTime brDate, String termSheet, String pricingSheet, String pslUpdation, String pfCollected, String internalConditions, Long overdues, String branch, Long minLoanAmt, Long maxLoanAmt, Long sanctionLimit, String operationType, java.time.LocalDateTime uploadedDate, String segmentCode, Long disbursementAmount, String remarks, String orgCifName, String segmentTeams, Long isAcceptLoanAgreement, String recoveryAccountNo, String taskReason, String downloadStatus, String downloadTime, String reverseFileStatus, String endUse, String reverseStatus, String spreadDisplay, String resetFrequency, String resetFreqUom, Long resetFreqValue, Long overallLimit, Long gst, Long procFee, String benchmark, Long roiBenchmark, java.time.LocalDateTime interestStartDate, String alertStatus, String userCrn, String makerTaskConsent, String reverseUploadRefID, Long offerVersionID, String tenureDaysList, String rmName, String amtInWordsReqLetter, String stpStatus) {

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

        private String fulfillmentParty;

        private Long isTemplate;

        private Long utilizedAmount;

        private Long outstandingAmount;

        private String limitNodeReference;

        private Long requestTenor;

        private String requestStatusCode;

        private java.time.LocalDateTime requestDisbursementDate;

        private String rmPartyReference;

        private String parentFacilityLimitID;

        private String facilityLimitID;

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

        private String sanctionedAmountCcyCode;

        private Long sanctionedAmount;

        private String applicantParty;

        private String sanctionedDate;

        private String disbursementAccount;

        private java.time.LocalDateTime disbursedDate;

        private String settlementAccount;

        private Long wcdlLimitAvailable;

        private Long wcdlFacilityValidity;

        private Long loanOverdueCheck;

        private Long coolingPeriodCheck;

        private Long leiAvailableCheck;

        private String internalRatingTypeCode;

        private String internalRatingValue;

        private Long rarocStatusCheck;

        private Long rarocFacilityCheck;

        private Long pslAvailabilityCheck;

        private String flowTypeCode;

        private Long digitalFlowFlag;

        private String lobCode;

        private String requestDate;

        private String requestCategoryCode;

        private String requestTypeCode;

        private String requestCurrencyCode;

        private Long requestAmount;

        private String requestTenorUom;

        private String orgCifCode;

        private String orgUserCifCode;

        private String facilityTypeCode;

        private Long rateOfInterest;

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

        private String uploadRefID;

        private String routingCode;

        private String routingTypeCode;

        private String bankCode;

        private String transactionID;

        private String offerBenchmark;

        private Long availableLimit;

        private String priority;

        private String schemeCode;

        private String accountOpeningDate;

        private String notes;

        private String repricingPlan;

        private String rateFixingMethod;

        private java.time.LocalDateTime peggingReviewDate;

        private String peggingFrequency;

        private String interestRateCode;

        private Long spread;

        private Long customerPreferentialInterest;

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

        private Long amount;

        private String beneficiaryAccountNo;

        private String beneficiaryAccountType;

        private String beneficiaryName;

        private String beneficiaryAddress;

        private String ifscCode;

        private String paymentProduct;

        private Long ccyRate;

        private String beneficiaryType;

        private String beneficiaryLeiNumber;

        private String makerTempNo;

        private String amtInWords;

        private Long drawingPower;

        private Long limitAsPerSystem;

        private String disbTillDtUnderContract;

        private Long freeLimitsForDisb;

        private String disbTillDtUnderFacility;

        private Long poLimit;

        private Long systemFreePoLimit;

        private java.time.LocalDateTime maturityDate;

        private Long loanSpread;

        private Long minRarocSpread;

        private Long minFbilFimmdaSpread;

        private java.time.LocalDateTime brDate;

        private String termSheet;

        private String pricingSheet;

        private String pslUpdation;

        private String pfCollected;

        private String internalConditions;

        private Long overdues;

        private String branch;

        private Long minLoanAmt;

        private Long maxLoanAmt;

        private Long sanctionLimit;

        private String operationType;

        private java.time.LocalDateTime uploadedDate;

        private String segmentCode;

        private Long disbursementAmount;

        private String remarks;

        private String orgCifName;

        private String segmentTeams;

        private Long isAcceptLoanAgreement;

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

        private Long resetFreqValue;

        private Long overallLimit;

        private Long gst;

        private Long procFee;

        private String benchmark;

        private Long roiBenchmark;

        private java.time.LocalDateTime interestStartDate;

        private String alertStatus;

        private String userCrn;

        private String makerTaskConsent;

        private String reverseUploadRefID;

        private Long offerVersionID;

        private String tenureDaysList;

        private String rmName;

        private String amtInWordsReqLetter;

        private String stpStatus;

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

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder utilizedAmount(Long utilizedAmount) {
            this.utilizedAmount = utilizedAmount;
            return this;
        }

        public Builder outstandingAmount(Long outstandingAmount) {
            this.outstandingAmount = outstandingAmount;
            return this;
        }

        public Builder limitNodeReference(String limitNodeReference) {
            this.limitNodeReference = limitNodeReference;
            return this;
        }

        public Builder requestTenor(Long requestTenor) {
            this.requestTenor = requestTenor;
            return this;
        }

        public Builder requestStatusCode(String requestStatusCode) {
            this.requestStatusCode = requestStatusCode;
            return this;
        }

        public Builder requestDisbursementDate(java.time.LocalDateTime requestDisbursementDate) {
            this.requestDisbursementDate = requestDisbursementDate;
            return this;
        }

        public Builder rmPartyReference(String rmPartyReference) {
            this.rmPartyReference = rmPartyReference;
            return this;
        }

        public Builder parentFacilityLimitID(String parentFacilityLimitID) {
            this.parentFacilityLimitID = parentFacilityLimitID;
            return this;
        }

        public Builder facilityLimitID(String facilityLimitID) {
            this.facilityLimitID = facilityLimitID;
            return this;
        }

        public Builder leiNumber(String leiNumber) {
            this.leiNumber = leiNumber;
            return this;
        }

        public Builder leiStatusCode(String leiStatusCode) {
            this.leiStatusCode = leiStatusCode;
            return this;
        }

        public Builder interestTypeCode(String interestTypeCode) {
            this.interestTypeCode = interestTypeCode;
            return this;
        }

        public Builder offerCode(String offerCode) {
            this.offerCode = offerCode;
            return this;
        }

        public Builder tenorMin(Long tenorMin) {
            this.tenorMin = tenorMin;
            return this;
        }

        public Builder tenorMax(Long tenorMax) {
            this.tenorMax = tenorMax;
            return this;
        }

        public Builder processingModeCode(String processingModeCode) {
            this.processingModeCode = processingModeCode;
            return this;
        }

        public Builder resetFrequenctPeriodCode(String resetFrequenctPeriodCode) {
            this.resetFrequenctPeriodCode = resetFrequenctPeriodCode;
            return this;
        }

        public Builder loanAccountNumber(String loanAccountNumber) {
            this.loanAccountNumber = loanAccountNumber;
            return this;
        }

        public Builder loanStartDate(java.time.LocalDateTime loanStartDate) {
            this.loanStartDate = loanStartDate;
            return this;
        }

        public Builder sanctionedAmountCcyCode(String sanctionedAmountCcyCode) {
            this.sanctionedAmountCcyCode = sanctionedAmountCcyCode;
            return this;
        }

        public Builder sanctionedAmount(Long sanctionedAmount) {
            this.sanctionedAmount = sanctionedAmount;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder sanctionedDate(String sanctionedDate) {
            this.sanctionedDate = sanctionedDate;
            return this;
        }

        public Builder disbursementAccount(String disbursementAccount) {
            this.disbursementAccount = disbursementAccount;
            return this;
        }

        public Builder disbursedDate(java.time.LocalDateTime disbursedDate) {
            this.disbursedDate = disbursedDate;
            return this;
        }

        public Builder settlementAccount(String settlementAccount) {
            this.settlementAccount = settlementAccount;
            return this;
        }

        public Builder wcdlLimitAvailable(Long wcdlLimitAvailable) {
            this.wcdlLimitAvailable = wcdlLimitAvailable;
            return this;
        }

        public Builder wcdlFacilityValidity(Long wcdlFacilityValidity) {
            this.wcdlFacilityValidity = wcdlFacilityValidity;
            return this;
        }

        public Builder loanOverdueCheck(Long loanOverdueCheck) {
            this.loanOverdueCheck = loanOverdueCheck;
            return this;
        }

        public Builder coolingPeriodCheck(Long coolingPeriodCheck) {
            this.coolingPeriodCheck = coolingPeriodCheck;
            return this;
        }

        public Builder leiAvailableCheck(Long leiAvailableCheck) {
            this.leiAvailableCheck = leiAvailableCheck;
            return this;
        }

        public Builder internalRatingTypeCode(String internalRatingTypeCode) {
            this.internalRatingTypeCode = internalRatingTypeCode;
            return this;
        }

        public Builder internalRatingValue(String internalRatingValue) {
            this.internalRatingValue = internalRatingValue;
            return this;
        }

        public Builder rarocStatusCheck(Long rarocStatusCheck) {
            this.rarocStatusCheck = rarocStatusCheck;
            return this;
        }

        public Builder rarocFacilityCheck(Long rarocFacilityCheck) {
            this.rarocFacilityCheck = rarocFacilityCheck;
            return this;
        }

        public Builder pslAvailabilityCheck(Long pslAvailabilityCheck) {
            this.pslAvailabilityCheck = pslAvailabilityCheck;
            return this;
        }

        public Builder flowTypeCode(String flowTypeCode) {
            this.flowTypeCode = flowTypeCode;
            return this;
        }

        public Builder digitalFlowFlag(Long digitalFlowFlag) {
            this.digitalFlowFlag = digitalFlowFlag;
            return this;
        }

        public Builder lobCode(String lobCode) {
            this.lobCode = lobCode;
            return this;
        }

        public Builder requestDate(String requestDate) {
            this.requestDate = requestDate;
            return this;
        }

        public Builder requestCategoryCode(String requestCategoryCode) {
            this.requestCategoryCode = requestCategoryCode;
            return this;
        }

        public Builder requestTypeCode(String requestTypeCode) {
            this.requestTypeCode = requestTypeCode;
            return this;
        }

        public Builder requestCurrencyCode(String requestCurrencyCode) {
            this.requestCurrencyCode = requestCurrencyCode;
            return this;
        }

        public Builder requestAmount(Long requestAmount) {
            this.requestAmount = requestAmount;
            return this;
        }

        public Builder requestTenorUom(String requestTenorUom) {
            this.requestTenorUom = requestTenorUom;
            return this;
        }

        public Builder orgCifCode(String orgCifCode) {
            this.orgCifCode = orgCifCode;
            return this;
        }

        public Builder orgUserCifCode(String orgUserCifCode) {
            this.orgUserCifCode = orgUserCifCode;
            return this;
        }

        public Builder facilityTypeCode(String facilityTypeCode) {
            this.facilityTypeCode = facilityTypeCode;
            return this;
        }

        public Builder rateOfInterest(Long rateOfInterest) {
            this.rateOfInterest = rateOfInterest;
            return this;
        }

        public Builder tenorUom(String tenorUom) {
            this.tenorUom = tenorUom;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder externalRatingTypeCode(String externalRatingTypeCode) {
            this.externalRatingTypeCode = externalRatingTypeCode;
            return this;
        }

        public Builder externalRatingValue(String externalRatingValue) {
            this.externalRatingValue = externalRatingValue;
            return this;
        }

        public Builder offerTypeCode(String offerTypeCode) {
            this.offerTypeCode = offerTypeCode;
            return this;
        }

        public Builder acceptanceParty(String acceptanceParty) {
            this.acceptanceParty = acceptanceParty;
            return this;
        }

        public Builder assessmentParty(String assessmentParty) {
            this.assessmentParty = assessmentParty;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public Builder acceptanceReasonCode(String acceptanceReasonCode) {
            this.acceptanceReasonCode = acceptanceReasonCode;
            return this;
        }

        public Builder acceptanceComments(String acceptanceComments) {
            this.acceptanceComments = acceptanceComments;
            return this;
        }

        public Builder acceptanceDate(java.time.LocalDateTime acceptanceDate) {
            this.acceptanceDate = acceptanceDate;
            return this;
        }

        public Builder assessmentReasonCode(String assessmentReasonCode) {
            this.assessmentReasonCode = assessmentReasonCode;
            return this;
        }

        public Builder assessmentComments(String assessmentComments) {
            this.assessmentComments = assessmentComments;
            return this;
        }

        public Builder assessmentDate(java.time.LocalDateTime assessmentDate) {
            this.assessmentDate = assessmentDate;
            return this;
        }

        public Builder tenureDays(String tenureDays) {
            this.tenureDays = tenureDays;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder routingCode(String routingCode) {
            this.routingCode = routingCode;
            return this;
        }

        public Builder routingTypeCode(String routingTypeCode) {
            this.routingTypeCode = routingTypeCode;
            return this;
        }

        public Builder bankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public Builder transactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public Builder offerBenchmark(String offerBenchmark) {
            this.offerBenchmark = offerBenchmark;
            return this;
        }

        public Builder availableLimit(Long availableLimit) {
            this.availableLimit = availableLimit;
            return this;
        }

        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder accountOpeningDate(String accountOpeningDate) {
            this.accountOpeningDate = accountOpeningDate;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder repricingPlan(String repricingPlan) {
            this.repricingPlan = repricingPlan;
            return this;
        }

        public Builder rateFixingMethod(String rateFixingMethod) {
            this.rateFixingMethod = rateFixingMethod;
            return this;
        }

        public Builder peggingReviewDate(java.time.LocalDateTime peggingReviewDate) {
            this.peggingReviewDate = peggingReviewDate;
            return this;
        }

        public Builder peggingFrequency(String peggingFrequency) {
            this.peggingFrequency = peggingFrequency;
            return this;
        }

        public Builder interestRateCode(String interestRateCode) {
            this.interestRateCode = interestRateCode;
            return this;
        }

        public Builder spread(Long spread) {
            this.spread = spread;
            return this;
        }

        public Builder customerPreferentialInterest(Long customerPreferentialInterest) {
            this.customerPreferentialInterest = customerPreferentialInterest;
            return this;
        }

        public Builder penalInterestTableCode(String penalInterestTableCode) {
            this.penalInterestTableCode = penalInterestTableCode;
            return this;
        }

        public Builder penalPreferentialPercentage(String penalPreferentialPercentage) {
            this.penalPreferentialPercentage = penalPreferentialPercentage;
            return this;
        }

        public Builder holdInOptAccForAmtDue(String holdInOptAccForAmtDue) {
            this.holdInOptAccForAmtDue = holdInOptAccForAmtDue;
            return this;
        }

        public Builder repaymentMethod(String repaymentMethod) {
            this.repaymentMethod = repaymentMethod;
            return this;
        }

        public Builder recyOnlyIntByAccDebit(String recyOnlyIntByAccDebit) {
            this.recyOnlyIntByAccDebit = recyOnlyIntByAccDebit;
            return this;
        }

        public Builder operativeAccountNo(Long operativeAccountNo) {
            this.operativeAccountNo = operativeAccountNo;
            return this;
        }

        public Builder huntingRequired(String huntingRequired) {
            this.huntingRequired = huntingRequired;
            return this;
        }

        public Builder strucRepaymentSchedule(String strucRepaymentSchedule) {
            this.strucRepaymentSchedule = strucRepaymentSchedule;
            return this;
        }

        public Builder equatedInstalment(String equatedInstalment) {
            this.equatedInstalment = equatedInstalment;
            return this;
        }

        public Builder noOfInstalment(String noOfInstalment) {
            this.noOfInstalment = noOfInstalment;
            return this;
        }

        public Builder instalmentStartDate(java.time.LocalDateTime instalmentStartDate) {
            this.instalmentStartDate = instalmentStartDate;
            return this;
        }

        public Builder instalmentFrequency(String instalmentFrequency) {
            this.instalmentFrequency = instalmentFrequency;
            return this;
        }

        public Builder interestFrequency(String interestFrequency) {
            this.interestFrequency = interestFrequency;
            return this;
        }

        public Builder instlFrequencyStartDate(java.time.LocalDateTime instlFrequencyStartDate) {
            this.instlFrequencyStartDate = instlFrequencyStartDate;
            return this;
        }

        public Builder interestFrequencyStartDate(java.time.LocalDateTime interestFrequencyStartDate) {
            this.interestFrequencyStartDate = interestFrequencyStartDate;
            return this;
        }

        public Builder moratoriumPeriod(String moratoriumPeriod) {
            this.moratoriumPeriod = moratoriumPeriod;
            return this;
        }

        public Builder moratoriumInterestStartDate(java.time.LocalDateTime moratoriumInterestStartDate) {
            this.moratoriumInterestStartDate = moratoriumInterestStartDate;
            return this;
        }

        public Builder moratoriumPeriodIntFreq(String moratoriumPeriodIntFreq) {
            this.moratoriumPeriodIntFreq = moratoriumPeriodIntFreq;
            return this;
        }

        public Builder moratoriumIntFreqStartDate(java.time.LocalDateTime moratoriumIntFreqStartDate) {
            this.moratoriumIntFreqStartDate = moratoriumIntFreqStartDate;
            return this;
        }

        public Builder subsectorCode(String subsectorCode) {
            this.subsectorCode = subsectorCode;
            return this;
        }

        public Builder sectorCode(String sectorCode) {
            this.sectorCode = sectorCode;
            return this;
        }

        public Builder modeOfAdvance(String modeOfAdvance) {
            this.modeOfAdvance = modeOfAdvance;
            return this;
        }

        public Builder rolloverFlag(String rolloverFlag) {
            this.rolloverFlag = rolloverFlag;
            return this;
        }

        public Builder disbAuthRemarks(String disbAuthRemarks) {
            this.disbAuthRemarks = disbAuthRemarks;
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder beneficiaryAccountNo(String beneficiaryAccountNo) {
            this.beneficiaryAccountNo = beneficiaryAccountNo;
            return this;
        }

        public Builder beneficiaryAccountType(String beneficiaryAccountType) {
            this.beneficiaryAccountType = beneficiaryAccountType;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder beneficiaryAddress(String beneficiaryAddress) {
            this.beneficiaryAddress = beneficiaryAddress;
            return this;
        }

        public Builder ifscCode(String ifscCode) {
            this.ifscCode = ifscCode;
            return this;
        }

        public Builder paymentProduct(String paymentProduct) {
            this.paymentProduct = paymentProduct;
            return this;
        }

        public Builder ccyRate(Long ccyRate) {
            this.ccyRate = ccyRate;
            return this;
        }

        public Builder beneficiaryType(String beneficiaryType) {
            this.beneficiaryType = beneficiaryType;
            return this;
        }

        public Builder beneficiaryLeiNumber(String beneficiaryLeiNumber) {
            this.beneficiaryLeiNumber = beneficiaryLeiNumber;
            return this;
        }

        public Builder makerTempNo(String makerTempNo) {
            this.makerTempNo = makerTempNo;
            return this;
        }

        public Builder amtInWords(String amtInWords) {
            this.amtInWords = amtInWords;
            return this;
        }

        public Builder drawingPower(Long drawingPower) {
            this.drawingPower = drawingPower;
            return this;
        }

        public Builder limitAsPerSystem(Long limitAsPerSystem) {
            this.limitAsPerSystem = limitAsPerSystem;
            return this;
        }

        public Builder disbTillDtUnderContract(String disbTillDtUnderContract) {
            this.disbTillDtUnderContract = disbTillDtUnderContract;
            return this;
        }

        public Builder freeLimitsForDisb(Long freeLimitsForDisb) {
            this.freeLimitsForDisb = freeLimitsForDisb;
            return this;
        }

        public Builder disbTillDtUnderFacility(String disbTillDtUnderFacility) {
            this.disbTillDtUnderFacility = disbTillDtUnderFacility;
            return this;
        }

        public Builder poLimit(Long poLimit) {
            this.poLimit = poLimit;
            return this;
        }

        public Builder systemFreePoLimit(Long systemFreePoLimit) {
            this.systemFreePoLimit = systemFreePoLimit;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder loanSpread(Long loanSpread) {
            this.loanSpread = loanSpread;
            return this;
        }

        public Builder minRarocSpread(Long minRarocSpread) {
            this.minRarocSpread = minRarocSpread;
            return this;
        }

        public Builder minFbilFimmdaSpread(Long minFbilFimmdaSpread) {
            this.minFbilFimmdaSpread = minFbilFimmdaSpread;
            return this;
        }

        public Builder brDate(java.time.LocalDateTime brDate) {
            this.brDate = brDate;
            return this;
        }

        public Builder termSheet(String termSheet) {
            this.termSheet = termSheet;
            return this;
        }

        public Builder pricingSheet(String pricingSheet) {
            this.pricingSheet = pricingSheet;
            return this;
        }

        public Builder pslUpdation(String pslUpdation) {
            this.pslUpdation = pslUpdation;
            return this;
        }

        public Builder pfCollected(String pfCollected) {
            this.pfCollected = pfCollected;
            return this;
        }

        public Builder internalConditions(String internalConditions) {
            this.internalConditions = internalConditions;
            return this;
        }

        public Builder overdues(Long overdues) {
            this.overdues = overdues;
            return this;
        }

        public Builder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder minLoanAmt(Long minLoanAmt) {
            this.minLoanAmt = minLoanAmt;
            return this;
        }

        public Builder maxLoanAmt(Long maxLoanAmt) {
            this.maxLoanAmt = maxLoanAmt;
            return this;
        }

        public Builder sanctionLimit(Long sanctionLimit) {
            this.sanctionLimit = sanctionLimit;
            return this;
        }

        public Builder operationType(String operationType) {
            this.operationType = operationType;
            return this;
        }

        public Builder uploadedDate(java.time.LocalDateTime uploadedDate) {
            this.uploadedDate = uploadedDate;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder disbursementAmount(Long disbursementAmount) {
            this.disbursementAmount = disbursementAmount;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder orgCifName(String orgCifName) {
            this.orgCifName = orgCifName;
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            this.segmentTeams = segmentTeams;
            return this;
        }

        public Builder isAcceptLoanAgreement(Long isAcceptLoanAgreement) {
            this.isAcceptLoanAgreement = isAcceptLoanAgreement;
            return this;
        }

        public Builder recoveryAccountNo(String recoveryAccountNo) {
            this.recoveryAccountNo = recoveryAccountNo;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder downloadStatus(String downloadStatus) {
            this.downloadStatus = downloadStatus;
            return this;
        }

        public Builder downloadTime(String downloadTime) {
            this.downloadTime = downloadTime;
            return this;
        }

        public Builder reverseFileStatus(String reverseFileStatus) {
            this.reverseFileStatus = reverseFileStatus;
            return this;
        }

        public Builder endUse(String endUse) {
            this.endUse = endUse;
            return this;
        }

        public Builder reverseStatus(String reverseStatus) {
            this.reverseStatus = reverseStatus;
            return this;
        }

        public Builder spreadDisplay(String spreadDisplay) {
            this.spreadDisplay = spreadDisplay;
            return this;
        }

        public Builder resetFrequency(String resetFrequency) {
            this.resetFrequency = resetFrequency;
            return this;
        }

        public Builder resetFreqUom(String resetFreqUom) {
            this.resetFreqUom = resetFreqUom;
            return this;
        }

        public Builder resetFreqValue(Long resetFreqValue) {
            this.resetFreqValue = resetFreqValue;
            return this;
        }

        public Builder overallLimit(Long overallLimit) {
            this.overallLimit = overallLimit;
            return this;
        }

        public Builder gst(Long gst) {
            this.gst = gst;
            return this;
        }

        public Builder procFee(Long procFee) {
            this.procFee = procFee;
            return this;
        }

        public Builder benchmark(String benchmark) {
            this.benchmark = benchmark;
            return this;
        }

        public Builder roiBenchmark(Long roiBenchmark) {
            this.roiBenchmark = roiBenchmark;
            return this;
        }

        public Builder interestStartDate(java.time.LocalDateTime interestStartDate) {
            this.interestStartDate = interestStartDate;
            return this;
        }

        public Builder alertStatus(String alertStatus) {
            this.alertStatus = alertStatus;
            return this;
        }

        public Builder userCrn(String userCrn) {
            this.userCrn = userCrn;
            return this;
        }

        public Builder makerTaskConsent(String makerTaskConsent) {
            this.makerTaskConsent = makerTaskConsent;
            return this;
        }

        public Builder reverseUploadRefID(String reverseUploadRefID) {
            this.reverseUploadRefID = reverseUploadRefID;
            return this;
        }

        public Builder offerVersionID(Long offerVersionID) {
            this.offerVersionID = offerVersionID;
            return this;
        }

        public Builder tenureDaysList(String tenureDaysList) {
            this.tenureDaysList = tenureDaysList;
            return this;
        }

        public Builder rmName(String rmName) {
            this.rmName = rmName;
            return this;
        }

        public Builder amtInWordsReqLetter(String amtInWordsReqLetter) {
            this.amtInWordsReqLetter = amtInWordsReqLetter;
            return this;
        }

        public Builder stpStatus(String stpStatus) {
            this.stpStatus = stpStatus;
            return this;
        }

        public LosLoanRequest build() {
            return new LosLoanRequest(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, fulfillmentParty, isTemplate, utilizedAmount, outstandingAmount, limitNodeReference, requestTenor, requestStatusCode, requestDisbursementDate, rmPartyReference, parentFacilityLimitID, facilityLimitID, leiNumber, leiStatusCode, interestTypeCode, offerCode, tenorMin, tenorMax, processingModeCode, resetFrequenctPeriodCode, loanAccountNumber, loanStartDate, sanctionedAmountCcyCode, sanctionedAmount, applicantParty, sanctionedDate, disbursementAccount, disbursedDate, settlementAccount, wcdlLimitAvailable, wcdlFacilityValidity, loanOverdueCheck, coolingPeriodCheck, leiAvailableCheck, internalRatingTypeCode, internalRatingValue, rarocStatusCheck, rarocFacilityCheck, pslAvailabilityCheck, flowTypeCode, digitalFlowFlag, lobCode, requestDate, requestCategoryCode, requestTypeCode, requestCurrencyCode, requestAmount, requestTenorUom, orgCifCode, orgUserCifCode, facilityTypeCode, rateOfInterest, tenorUom, productCode, subProductCode, externalRatingTypeCode, externalRatingValue, offerTypeCode, acceptanceParty, assessmentParty, productStatusCode, acceptanceReasonCode, acceptanceComments, acceptanceDate, assessmentReasonCode, assessmentComments, assessmentDate, tenureDays, uploadRefID, routingCode, routingTypeCode, bankCode, transactionID, offerBenchmark, availableLimit, priority, schemeCode, accountOpeningDate, notes, repricingPlan, rateFixingMethod, peggingReviewDate, peggingFrequency, interestRateCode, spread, customerPreferentialInterest, penalInterestTableCode, penalPreferentialPercentage, holdInOptAccForAmtDue, repaymentMethod, recyOnlyIntByAccDebit, operativeAccountNo, huntingRequired, strucRepaymentSchedule, equatedInstalment, noOfInstalment, instalmentStartDate, instalmentFrequency, interestFrequency, instlFrequencyStartDate, interestFrequencyStartDate, moratoriumPeriod, moratoriumInterestStartDate, moratoriumPeriodIntFreq, moratoriumIntFreqStartDate, subsectorCode, sectorCode, modeOfAdvance, rolloverFlag, disbAuthRemarks, paymentMode, amount, beneficiaryAccountNo, beneficiaryAccountType, beneficiaryName, beneficiaryAddress, ifscCode, paymentProduct, ccyRate, beneficiaryType, beneficiaryLeiNumber, makerTempNo, amtInWords, drawingPower, limitAsPerSystem, disbTillDtUnderContract, freeLimitsForDisb, disbTillDtUnderFacility, poLimit, systemFreePoLimit, maturityDate, loanSpread, minRarocSpread, minFbilFimmdaSpread, brDate, termSheet, pricingSheet, pslUpdation, pfCollected, internalConditions, overdues, branch, minLoanAmt, maxLoanAmt, sanctionLimit, operationType, uploadedDate, segmentCode, disbursementAmount, remarks, orgCifName, segmentTeams, isAcceptLoanAgreement, recoveryAccountNo, taskReason, downloadStatus, downloadTime, reverseFileStatus, endUse, reverseStatus, spreadDisplay, resetFrequency, resetFreqUom, resetFreqValue, overallLimit, gst, procFee, benchmark, roiBenchmark, interestStartDate, alertStatus, userCrn, makerTaskConsent, reverseUploadRefID, offerVersionID, tenureDaysList, rmName, amtInWordsReqLetter, stpStatus);
        }
    }
}
