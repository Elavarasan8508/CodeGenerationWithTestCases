package com.bsit.codegeneration.record;

public record ScfFileTxn(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String anchorCrn, String fileMasterRefNo, String fileLinesRefNo, String txnNo, java.time.LocalDateTime txnDate, String txnCurrency, java.time.LocalDateTime txnDueDate, Long txnAmount, String counterPartyCrn, String counterPartyName, String productType, String inputBranch, String behalfOfBranch, Long financeAmount, String debitPartyCrn, java.time.LocalDateTime effectiveDate, Long financingAmount, String creditPartyCrn, Long interestRate, Long marginRate, java.time.LocalDateTime maturityDate, Long penaltyPercent, java.time.LocalDateTime interestStartDate, String interestType, String rateType, String baseCode, Long tenor, Long interestPeriod, Long contractPeriod, Long gracePeriod, String buyerID, String sellerID, String financeRefNo, String paymentType, java.time.LocalDateTime paymentDate, String debitAccNo, Long paymentAmount, String beneName, String beneBranch, String utrNumber, java.time.LocalDateTime processingDate, String cmsRefNo, String fileName, String status, String remarks, String batchRefID, String limitNode1, String valStatus, String valRemarks, String valReqFilename, String valReqEventRefID, String valReqStartTime, String valReqEndTime, String valReqStatus, String valReqRemarks, String valResFilename, String valResEventRefID, String valResStartTime, String valResEndTime, String valResStatus, String valResRemarks, String finpayReqFilename, String finpayReqEventRefID, String finpayReqStartTime, String finpayReqEndTime, String finpayReqStatus, String finpayReqRemarks, String finpayResFilename, String finpayResEventRefID, String finpayResStartTime, String finpayResEndTime, String finpayResStatus, String finpayResRemarks, String finpayEodFilename, String finpayEodEventRefID, String finpayEodStartTime, String finpayEodEndTime, String finpayEodStatus, String finpayEodRemarks, String cmsReqFilename, String cmsReqEventRefID, String cmsReqStartTime, String cmsReqEndTime, String cmsReqStatus, String cmsReqRemarks, String cmsResFilename, String cmsResEventRefID, String cmsResStartTime, String cmsResEndTime, String cmsResStatus, String cmsResRemarks, String fbtiReqCorrID, String fbtiReqEventRefID, String fbtiReqStartTime, String fbtiReqEndTime, String fbtiReqStatus, String fbtiReqRemarks, String fbtiResCorrID, String fbtiResEventRefID, String fbtiResStartTime, String fbtiResEndTime, String fbtiResStatus, String fbtiResRemarks, String currentEventName, Long valLineNo, String valLineContent, String limitNode2, String eodStatus, String finpayLineContent, String valueDate, String paymentMode, String beneAccNo, Long netPayment, Long advanceInterest, Long spreadRate, String anchorName, String sourceOfCreation, Long charges, String clientCode, String sourceSystem, String displaySourceSystem, String eventFinpayID, java.time.LocalDateTime instrumentDate, String bankCodeIndicator, String beneficiaryCode, String beneficiaryBank, String location, String printLocation, Long instrumentNumber, String beneficiaryAddress1, String beneficiaryAddress2, String beneficiaryAddress3, String beneficiaryAddress4, String beneficiaryEmail, Long beneficiaryMobile, String debitNarration, String creditNarration, String paymentDetails1, String paymentDetails2, String paymentDetails3, String paymentDetails4, String enrichment1, String enrichment2, String enrichment3, String enrichment4, String enrichment5, String enrichment6, String enrichment7, String enrichment8, String enrichment9, String enrichment10, String enrichment11, String enrichment12, String enrichment13, String enrichment14, String enrichment15, String enrichment16, String enrichment17, String enrichment18, String enrichment19, String enrichment20, Long origTxnAmount, String creditPartyName, String counterPartyRole) {

    public static class Builder {

        private String ID;

        private String referenceID;

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

        private String anchorCrn;

        private String fileMasterRefNo;

        private String fileLinesRefNo;

        private String txnNo;

        private java.time.LocalDateTime txnDate;

        private String txnCurrency;

        private java.time.LocalDateTime txnDueDate;

        private Long txnAmount;

        private String counterPartyCrn;

        private String counterPartyName;

        private String productType;

        private String inputBranch;

        private String behalfOfBranch;

        private Long financeAmount;

        private String debitPartyCrn;

        private java.time.LocalDateTime effectiveDate;

        private Long financingAmount;

        private String creditPartyCrn;

        private Long interestRate;

        private Long marginRate;

        private java.time.LocalDateTime maturityDate;

        private Long penaltyPercent;

        private java.time.LocalDateTime interestStartDate;

        private String interestType;

        private String rateType;

        private String baseCode;

        private Long tenor;

        private Long interestPeriod;

        private Long contractPeriod;

        private Long gracePeriod;

        private String buyerID;

        private String sellerID;

        private String financeRefNo;

        private String paymentType;

        private java.time.LocalDateTime paymentDate;

        private String debitAccNo;

        private Long paymentAmount;

        private String beneName;

        private String beneBranch;

        private String utrNumber;

        private java.time.LocalDateTime processingDate;

        private String cmsRefNo;

        private String fileName;

        private String status;

        private String remarks;

        private String batchRefID;

        private String limitNode1;

        private String valStatus;

        private String valRemarks;

        private String valReqFilename;

        private String valReqEventRefID;

        private String valReqStartTime;

        private String valReqEndTime;

        private String valReqStatus;

        private String valReqRemarks;

        private String valResFilename;

        private String valResEventRefID;

        private String valResStartTime;

        private String valResEndTime;

        private String valResStatus;

        private String valResRemarks;

        private String finpayReqFilename;

        private String finpayReqEventRefID;

        private String finpayReqStartTime;

        private String finpayReqEndTime;

        private String finpayReqStatus;

        private String finpayReqRemarks;

        private String finpayResFilename;

        private String finpayResEventRefID;

        private String finpayResStartTime;

        private String finpayResEndTime;

        private String finpayResStatus;

        private String finpayResRemarks;

        private String finpayEodFilename;

        private String finpayEodEventRefID;

        private String finpayEodStartTime;

        private String finpayEodEndTime;

        private String finpayEodStatus;

        private String finpayEodRemarks;

        private String cmsReqFilename;

        private String cmsReqEventRefID;

        private String cmsReqStartTime;

        private String cmsReqEndTime;

        private String cmsReqStatus;

        private String cmsReqRemarks;

        private String cmsResFilename;

        private String cmsResEventRefID;

        private String cmsResStartTime;

        private String cmsResEndTime;

        private String cmsResStatus;

        private String cmsResRemarks;

        private String fbtiReqCorrID;

        private String fbtiReqEventRefID;

        private String fbtiReqStartTime;

        private String fbtiReqEndTime;

        private String fbtiReqStatus;

        private String fbtiReqRemarks;

        private String fbtiResCorrID;

        private String fbtiResEventRefID;

        private String fbtiResStartTime;

        private String fbtiResEndTime;

        private String fbtiResStatus;

        private String fbtiResRemarks;

        private String currentEventName;

        private Long valLineNo;

        private String valLineContent;

        private String limitNode2;

        private String eodStatus;

        private String finpayLineContent;

        private String valueDate;

        private String paymentMode;

        private String beneAccNo;

        private Long netPayment;

        private Long advanceInterest;

        private Long spreadRate;

        private String anchorName;

        private String sourceOfCreation;

        private Long charges;

        private String clientCode;

        private String sourceSystem;

        private String displaySourceSystem;

        private String eventFinpayID;

        private java.time.LocalDateTime instrumentDate;

        private String bankCodeIndicator;

        private String beneficiaryCode;

        private String beneficiaryBank;

        private String location;

        private String printLocation;

        private Long instrumentNumber;

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

        private Long origTxnAmount;

        private String creditPartyName;

        private String counterPartyRole;

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

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            this.fileMasterRefNo = fileMasterRefNo;
            return this;
        }

        public Builder fileLinesRefNo(String fileLinesRefNo) {
            this.fileLinesRefNo = fileLinesRefNo;
            return this;
        }

        public Builder txnNo(String txnNo) {
            this.txnNo = txnNo;
            return this;
        }

        public Builder txnDate(java.time.LocalDateTime txnDate) {
            this.txnDate = txnDate;
            return this;
        }

        public Builder txnCurrency(String txnCurrency) {
            this.txnCurrency = txnCurrency;
            return this;
        }

        public Builder txnDueDate(java.time.LocalDateTime txnDueDate) {
            this.txnDueDate = txnDueDate;
            return this;
        }

        public Builder txnAmount(Long txnAmount) {
            this.txnAmount = txnAmount;
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

        public Builder productType(String productType) {
            this.productType = productType;
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

        public Builder financeAmount(Long financeAmount) {
            this.financeAmount = financeAmount;
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

        public Builder interestStartDate(java.time.LocalDateTime interestStartDate) {
            this.interestStartDate = interestStartDate;
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

        public Builder tenor(Long tenor) {
            this.tenor = tenor;
            return this;
        }

        public Builder interestPeriod(Long interestPeriod) {
            this.interestPeriod = interestPeriod;
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

        public Builder buyerID(String buyerID) {
            this.buyerID = buyerID;
            return this;
        }

        public Builder sellerID(String sellerID) {
            this.sellerID = sellerID;
            return this;
        }

        public Builder financeRefNo(String financeRefNo) {
            this.financeRefNo = financeRefNo;
            return this;
        }

        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder paymentDate(java.time.LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder debitAccNo(String debitAccNo) {
            this.debitAccNo = debitAccNo;
            return this;
        }

        public Builder paymentAmount(Long paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder beneName(String beneName) {
            this.beneName = beneName;
            return this;
        }

        public Builder beneBranch(String beneBranch) {
            this.beneBranch = beneBranch;
            return this;
        }

        public Builder utrNumber(String utrNumber) {
            this.utrNumber = utrNumber;
            return this;
        }

        public Builder processingDate(java.time.LocalDateTime processingDate) {
            this.processingDate = processingDate;
            return this;
        }

        public Builder cmsRefNo(String cmsRefNo) {
            this.cmsRefNo = cmsRefNo;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder batchRefID(String batchRefID) {
            this.batchRefID = batchRefID;
            return this;
        }

        public Builder limitNode1(String limitNode1) {
            this.limitNode1 = limitNode1;
            return this;
        }

        public Builder valStatus(String valStatus) {
            this.valStatus = valStatus;
            return this;
        }

        public Builder valRemarks(String valRemarks) {
            this.valRemarks = valRemarks;
            return this;
        }

        public Builder valReqFilename(String valReqFilename) {
            this.valReqFilename = valReqFilename;
            return this;
        }

        public Builder valReqEventRefID(String valReqEventRefID) {
            this.valReqEventRefID = valReqEventRefID;
            return this;
        }

        public Builder valReqStartTime(String valReqStartTime) {
            this.valReqStartTime = valReqStartTime;
            return this;
        }

        public Builder valReqEndTime(String valReqEndTime) {
            this.valReqEndTime = valReqEndTime;
            return this;
        }

        public Builder valReqStatus(String valReqStatus) {
            this.valReqStatus = valReqStatus;
            return this;
        }

        public Builder valReqRemarks(String valReqRemarks) {
            this.valReqRemarks = valReqRemarks;
            return this;
        }

        public Builder valResFilename(String valResFilename) {
            this.valResFilename = valResFilename;
            return this;
        }

        public Builder valResEventRefID(String valResEventRefID) {
            this.valResEventRefID = valResEventRefID;
            return this;
        }

        public Builder valResStartTime(String valResStartTime) {
            this.valResStartTime = valResStartTime;
            return this;
        }

        public Builder valResEndTime(String valResEndTime) {
            this.valResEndTime = valResEndTime;
            return this;
        }

        public Builder valResStatus(String valResStatus) {
            this.valResStatus = valResStatus;
            return this;
        }

        public Builder valResRemarks(String valResRemarks) {
            this.valResRemarks = valResRemarks;
            return this;
        }

        public Builder finpayReqFilename(String finpayReqFilename) {
            this.finpayReqFilename = finpayReqFilename;
            return this;
        }

        public Builder finpayReqEventRefID(String finpayReqEventRefID) {
            this.finpayReqEventRefID = finpayReqEventRefID;
            return this;
        }

        public Builder finpayReqStartTime(String finpayReqStartTime) {
            this.finpayReqStartTime = finpayReqStartTime;
            return this;
        }

        public Builder finpayReqEndTime(String finpayReqEndTime) {
            this.finpayReqEndTime = finpayReqEndTime;
            return this;
        }

        public Builder finpayReqStatus(String finpayReqStatus) {
            this.finpayReqStatus = finpayReqStatus;
            return this;
        }

        public Builder finpayReqRemarks(String finpayReqRemarks) {
            this.finpayReqRemarks = finpayReqRemarks;
            return this;
        }

        public Builder finpayResFilename(String finpayResFilename) {
            this.finpayResFilename = finpayResFilename;
            return this;
        }

        public Builder finpayResEventRefID(String finpayResEventRefID) {
            this.finpayResEventRefID = finpayResEventRefID;
            return this;
        }

        public Builder finpayResStartTime(String finpayResStartTime) {
            this.finpayResStartTime = finpayResStartTime;
            return this;
        }

        public Builder finpayResEndTime(String finpayResEndTime) {
            this.finpayResEndTime = finpayResEndTime;
            return this;
        }

        public Builder finpayResStatus(String finpayResStatus) {
            this.finpayResStatus = finpayResStatus;
            return this;
        }

        public Builder finpayResRemarks(String finpayResRemarks) {
            this.finpayResRemarks = finpayResRemarks;
            return this;
        }

        public Builder finpayEodFilename(String finpayEodFilename) {
            this.finpayEodFilename = finpayEodFilename;
            return this;
        }

        public Builder finpayEodEventRefID(String finpayEodEventRefID) {
            this.finpayEodEventRefID = finpayEodEventRefID;
            return this;
        }

        public Builder finpayEodStartTime(String finpayEodStartTime) {
            this.finpayEodStartTime = finpayEodStartTime;
            return this;
        }

        public Builder finpayEodEndTime(String finpayEodEndTime) {
            this.finpayEodEndTime = finpayEodEndTime;
            return this;
        }

        public Builder finpayEodStatus(String finpayEodStatus) {
            this.finpayEodStatus = finpayEodStatus;
            return this;
        }

        public Builder finpayEodRemarks(String finpayEodRemarks) {
            this.finpayEodRemarks = finpayEodRemarks;
            return this;
        }

        public Builder cmsReqFilename(String cmsReqFilename) {
            this.cmsReqFilename = cmsReqFilename;
            return this;
        }

        public Builder cmsReqEventRefID(String cmsReqEventRefID) {
            this.cmsReqEventRefID = cmsReqEventRefID;
            return this;
        }

        public Builder cmsReqStartTime(String cmsReqStartTime) {
            this.cmsReqStartTime = cmsReqStartTime;
            return this;
        }

        public Builder cmsReqEndTime(String cmsReqEndTime) {
            this.cmsReqEndTime = cmsReqEndTime;
            return this;
        }

        public Builder cmsReqStatus(String cmsReqStatus) {
            this.cmsReqStatus = cmsReqStatus;
            return this;
        }

        public Builder cmsReqRemarks(String cmsReqRemarks) {
            this.cmsReqRemarks = cmsReqRemarks;
            return this;
        }

        public Builder cmsResFilename(String cmsResFilename) {
            this.cmsResFilename = cmsResFilename;
            return this;
        }

        public Builder cmsResEventRefID(String cmsResEventRefID) {
            this.cmsResEventRefID = cmsResEventRefID;
            return this;
        }

        public Builder cmsResStartTime(String cmsResStartTime) {
            this.cmsResStartTime = cmsResStartTime;
            return this;
        }

        public Builder cmsResEndTime(String cmsResEndTime) {
            this.cmsResEndTime = cmsResEndTime;
            return this;
        }

        public Builder cmsResStatus(String cmsResStatus) {
            this.cmsResStatus = cmsResStatus;
            return this;
        }

        public Builder cmsResRemarks(String cmsResRemarks) {
            this.cmsResRemarks = cmsResRemarks;
            return this;
        }

        public Builder fbtiReqCorrID(String fbtiReqCorrID) {
            this.fbtiReqCorrID = fbtiReqCorrID;
            return this;
        }

        public Builder fbtiReqEventRefID(String fbtiReqEventRefID) {
            this.fbtiReqEventRefID = fbtiReqEventRefID;
            return this;
        }

        public Builder fbtiReqStartTime(String fbtiReqStartTime) {
            this.fbtiReqStartTime = fbtiReqStartTime;
            return this;
        }

        public Builder fbtiReqEndTime(String fbtiReqEndTime) {
            this.fbtiReqEndTime = fbtiReqEndTime;
            return this;
        }

        public Builder fbtiReqStatus(String fbtiReqStatus) {
            this.fbtiReqStatus = fbtiReqStatus;
            return this;
        }

        public Builder fbtiReqRemarks(String fbtiReqRemarks) {
            this.fbtiReqRemarks = fbtiReqRemarks;
            return this;
        }

        public Builder fbtiResCorrID(String fbtiResCorrID) {
            this.fbtiResCorrID = fbtiResCorrID;
            return this;
        }

        public Builder fbtiResEventRefID(String fbtiResEventRefID) {
            this.fbtiResEventRefID = fbtiResEventRefID;
            return this;
        }

        public Builder fbtiResStartTime(String fbtiResStartTime) {
            this.fbtiResStartTime = fbtiResStartTime;
            return this;
        }

        public Builder fbtiResEndTime(String fbtiResEndTime) {
            this.fbtiResEndTime = fbtiResEndTime;
            return this;
        }

        public Builder fbtiResStatus(String fbtiResStatus) {
            this.fbtiResStatus = fbtiResStatus;
            return this;
        }

        public Builder fbtiResRemarks(String fbtiResRemarks) {
            this.fbtiResRemarks = fbtiResRemarks;
            return this;
        }

        public Builder currentEventName(String currentEventName) {
            this.currentEventName = currentEventName;
            return this;
        }

        public Builder valLineNo(Long valLineNo) {
            this.valLineNo = valLineNo;
            return this;
        }

        public Builder valLineContent(String valLineContent) {
            this.valLineContent = valLineContent;
            return this;
        }

        public Builder limitNode2(String limitNode2) {
            this.limitNode2 = limitNode2;
            return this;
        }

        public Builder eodStatus(String eodStatus) {
            this.eodStatus = eodStatus;
            return this;
        }

        public Builder finpayLineContent(String finpayLineContent) {
            this.finpayLineContent = finpayLineContent;
            return this;
        }

        public Builder valueDate(String valueDate) {
            this.valueDate = valueDate;
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            this.beneAccNo = beneAccNo;
            return this;
        }

        public Builder netPayment(Long netPayment) {
            this.netPayment = netPayment;
            return this;
        }

        public Builder advanceInterest(Long advanceInterest) {
            this.advanceInterest = advanceInterest;
            return this;
        }

        public Builder spreadRate(Long spreadRate) {
            this.spreadRate = spreadRate;
            return this;
        }

        public Builder anchorName(String anchorName) {
            this.anchorName = anchorName;
            return this;
        }

        public Builder sourceOfCreation(String sourceOfCreation) {
            this.sourceOfCreation = sourceOfCreation;
            return this;
        }

        public Builder charges(Long charges) {
            this.charges = charges;
            return this;
        }

        public Builder clientCode(String clientCode) {
            this.clientCode = clientCode;
            return this;
        }

        public Builder sourceSystem(String sourceSystem) {
            this.sourceSystem = sourceSystem;
            return this;
        }

        public Builder displaySourceSystem(String displaySourceSystem) {
            this.displaySourceSystem = displaySourceSystem;
            return this;
        }

        public Builder eventFinpayID(String eventFinpayID) {
            this.eventFinpayID = eventFinpayID;
            return this;
        }

        public Builder instrumentDate(java.time.LocalDateTime instrumentDate) {
            this.instrumentDate = instrumentDate;
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            this.bankCodeIndicator = bankCodeIndicator;
            return this;
        }

        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        public Builder beneficiaryBank(String beneficiaryBank) {
            this.beneficiaryBank = beneficiaryBank;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder printLocation(String printLocation) {
            this.printLocation = printLocation;
            return this;
        }

        public Builder instrumentNumber(Long instrumentNumber) {
            this.instrumentNumber = instrumentNumber;
            return this;
        }

        public Builder beneficiaryAddress1(String beneficiaryAddress1) {
            this.beneficiaryAddress1 = beneficiaryAddress1;
            return this;
        }

        public Builder beneficiaryAddress2(String beneficiaryAddress2) {
            this.beneficiaryAddress2 = beneficiaryAddress2;
            return this;
        }

        public Builder beneficiaryAddress3(String beneficiaryAddress3) {
            this.beneficiaryAddress3 = beneficiaryAddress3;
            return this;
        }

        public Builder beneficiaryAddress4(String beneficiaryAddress4) {
            this.beneficiaryAddress4 = beneficiaryAddress4;
            return this;
        }

        public Builder beneficiaryEmail(String beneficiaryEmail) {
            this.beneficiaryEmail = beneficiaryEmail;
            return this;
        }

        public Builder beneficiaryMobile(Long beneficiaryMobile) {
            this.beneficiaryMobile = beneficiaryMobile;
            return this;
        }

        public Builder debitNarration(String debitNarration) {
            this.debitNarration = debitNarration;
            return this;
        }

        public Builder creditNarration(String creditNarration) {
            this.creditNarration = creditNarration;
            return this;
        }

        public Builder paymentDetails1(String paymentDetails1) {
            this.paymentDetails1 = paymentDetails1;
            return this;
        }

        public Builder paymentDetails2(String paymentDetails2) {
            this.paymentDetails2 = paymentDetails2;
            return this;
        }

        public Builder paymentDetails3(String paymentDetails3) {
            this.paymentDetails3 = paymentDetails3;
            return this;
        }

        public Builder paymentDetails4(String paymentDetails4) {
            this.paymentDetails4 = paymentDetails4;
            return this;
        }

        public Builder enrichment1(String enrichment1) {
            this.enrichment1 = enrichment1;
            return this;
        }

        public Builder enrichment2(String enrichment2) {
            this.enrichment2 = enrichment2;
            return this;
        }

        public Builder enrichment3(String enrichment3) {
            this.enrichment3 = enrichment3;
            return this;
        }

        public Builder enrichment4(String enrichment4) {
            this.enrichment4 = enrichment4;
            return this;
        }

        public Builder enrichment5(String enrichment5) {
            this.enrichment5 = enrichment5;
            return this;
        }

        public Builder enrichment6(String enrichment6) {
            this.enrichment6 = enrichment6;
            return this;
        }

        public Builder enrichment7(String enrichment7) {
            this.enrichment7 = enrichment7;
            return this;
        }

        public Builder enrichment8(String enrichment8) {
            this.enrichment8 = enrichment8;
            return this;
        }

        public Builder enrichment9(String enrichment9) {
            this.enrichment9 = enrichment9;
            return this;
        }

        public Builder enrichment10(String enrichment10) {
            this.enrichment10 = enrichment10;
            return this;
        }

        public Builder enrichment11(String enrichment11) {
            this.enrichment11 = enrichment11;
            return this;
        }

        public Builder enrichment12(String enrichment12) {
            this.enrichment12 = enrichment12;
            return this;
        }

        public Builder enrichment13(String enrichment13) {
            this.enrichment13 = enrichment13;
            return this;
        }

        public Builder enrichment14(String enrichment14) {
            this.enrichment14 = enrichment14;
            return this;
        }

        public Builder enrichment15(String enrichment15) {
            this.enrichment15 = enrichment15;
            return this;
        }

        public Builder enrichment16(String enrichment16) {
            this.enrichment16 = enrichment16;
            return this;
        }

        public Builder enrichment17(String enrichment17) {
            this.enrichment17 = enrichment17;
            return this;
        }

        public Builder enrichment18(String enrichment18) {
            this.enrichment18 = enrichment18;
            return this;
        }

        public Builder enrichment19(String enrichment19) {
            this.enrichment19 = enrichment19;
            return this;
        }

        public Builder enrichment20(String enrichment20) {
            this.enrichment20 = enrichment20;
            return this;
        }

        public Builder origTxnAmount(Long origTxnAmount) {
            this.origTxnAmount = origTxnAmount;
            return this;
        }

        public Builder creditPartyName(String creditPartyName) {
            this.creditPartyName = creditPartyName;
            return this;
        }

        public Builder counterPartyRole(String counterPartyRole) {
            this.counterPartyRole = counterPartyRole;
            return this;
        }

        public ScfFileTxn build() {
            return new ScfFileTxn(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, anchorCrn, fileMasterRefNo, fileLinesRefNo, txnNo, txnDate, txnCurrency, txnDueDate, txnAmount, counterPartyCrn, counterPartyName, productType, inputBranch, behalfOfBranch, financeAmount, debitPartyCrn, effectiveDate, financingAmount, creditPartyCrn, interestRate, marginRate, maturityDate, penaltyPercent, interestStartDate, interestType, rateType, baseCode, tenor, interestPeriod, contractPeriod, gracePeriod, buyerID, sellerID, financeRefNo, paymentType, paymentDate, debitAccNo, paymentAmount, beneName, beneBranch, utrNumber, processingDate, cmsRefNo, fileName, status, remarks, batchRefID, limitNode1, valStatus, valRemarks, valReqFilename, valReqEventRefID, valReqStartTime, valReqEndTime, valReqStatus, valReqRemarks, valResFilename, valResEventRefID, valResStartTime, valResEndTime, valResStatus, valResRemarks, finpayReqFilename, finpayReqEventRefID, finpayReqStartTime, finpayReqEndTime, finpayReqStatus, finpayReqRemarks, finpayResFilename, finpayResEventRefID, finpayResStartTime, finpayResEndTime, finpayResStatus, finpayResRemarks, finpayEodFilename, finpayEodEventRefID, finpayEodStartTime, finpayEodEndTime, finpayEodStatus, finpayEodRemarks, cmsReqFilename, cmsReqEventRefID, cmsReqStartTime, cmsReqEndTime, cmsReqStatus, cmsReqRemarks, cmsResFilename, cmsResEventRefID, cmsResStartTime, cmsResEndTime, cmsResStatus, cmsResRemarks, fbtiReqCorrID, fbtiReqEventRefID, fbtiReqStartTime, fbtiReqEndTime, fbtiReqStatus, fbtiReqRemarks, fbtiResCorrID, fbtiResEventRefID, fbtiResStartTime, fbtiResEndTime, fbtiResStatus, fbtiResRemarks, currentEventName, valLineNo, valLineContent, limitNode2, eodStatus, finpayLineContent, valueDate, paymentMode, beneAccNo, netPayment, advanceInterest, spreadRate, anchorName, sourceOfCreation, charges, clientCode, sourceSystem, displaySourceSystem, eventFinpayID, instrumentDate, bankCodeIndicator, beneficiaryCode, beneficiaryBank, location, printLocation, instrumentNumber, beneficiaryAddress1, beneficiaryAddress2, beneficiaryAddress3, beneficiaryAddress4, beneficiaryEmail, beneficiaryMobile, debitNarration, creditNarration, paymentDetails1, paymentDetails2, paymentDetails3, paymentDetails4, enrichment1, enrichment2, enrichment3, enrichment4, enrichment5, enrichment6, enrichment7, enrichment8, enrichment9, enrichment10, enrichment11, enrichment12, enrichment13, enrichment14, enrichment15, enrichment16, enrichment17, enrichment18, enrichment19, enrichment20, origTxnAmount, creditPartyName, counterPartyRole);
        }
    }
}
