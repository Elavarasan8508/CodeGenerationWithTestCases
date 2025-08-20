package com.bsit.codegeneration.record;

public record FgTrdDiVersion(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String irNostroNumber, java.time.LocalDateTime irValueDate, String irCurCode, Long irAmt, String curCode, Long amt, Long tradeDspAmt, Long fundsDspAmt, Long toBeDisposedAmt, Long bankToBeBook, Long bookNewDeal, Long providedTrdDspAmt, Long toBeDspTrdAmt, Long ofcMaxDspAmt, Long ofcDspAmt, Long elcMaxDspAmt, Long elcDspAmt, Long providedFundDspAmt, Long toBeDspFundAmt, Long postShipDspAmt, Long preShipMaxDspAmt, Long preShipDspAmt, String preRemAmtAccNo, Long accMaxDspAmt, Long accDspAmt, String remAmtAccNo, String applicantParty, String issuingParty, String irReferenceID, String custRefID, String detailsCharge, String irRemInfo, String remitterName, String beneficiaryName, String swiftMsgType, String processID, String stageCode, Long checkbox8, String remitterAddressLine2, String remitterAddressLine1, String beneficiaryAddressLine1, String beneficiaryAddressLine2, String boRefID, String productStatus, String taskID, String dmsEventID, Long stepperCompletionPercentage, Long lteaIndicator, String generalDetails, String disposalInstruction, String tradeDisposal, String fundsDisposal, String declaration, String attachments, String preview, String irOrdrInstitution, String copyFrom, String debitAccNo, Long misProduct, Long xarProduct, Long preRemAmtAccNoCb, String sender, String ordAccno, String ordName, String ordAddr1, String ordAddr2, String ordAddr3, String benefNo, String benefName, String benefAddr1, String benefAddr2, String benefAddr3, String swiftMessageData, String tiMasterRef, String preRemtAccNoCur, String remtAccNoCur, String debitAccNoCur, String ackMessage, String ackStatus, String fgTrdPurposeCode, String fgTrdAccounts, String fgTrdFxRate, String fgTrdPostLoans, String fgTrdPreLoans, String fgTrdLc, String fgTrdApplFxRate, Long versionID, Long isMasterVersion) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String irNostroNumber;

        private java.time.LocalDateTime irValueDate;

        private String irCurCode;

        private Long irAmt;

        private String curCode;

        private Long amt;

        private Long tradeDspAmt;

        private Long fundsDspAmt;

        private Long toBeDisposedAmt;

        private Long bankToBeBook;

        private Long bookNewDeal;

        private Long providedTrdDspAmt;

        private Long toBeDspTrdAmt;

        private Long ofcMaxDspAmt;

        private Long ofcDspAmt;

        private Long elcMaxDspAmt;

        private Long elcDspAmt;

        private Long providedFundDspAmt;

        private Long toBeDspFundAmt;

        private Long postShipDspAmt;

        private Long preShipMaxDspAmt;

        private Long preShipDspAmt;

        private String preRemAmtAccNo;

        private Long accMaxDspAmt;

        private Long accDspAmt;

        private String remAmtAccNo;

        private String applicantParty;

        private String issuingParty;

        private String irReferenceID;

        private String custRefID;

        private String detailsCharge;

        private String irRemInfo;

        private String remitterName;

        private String beneficiaryName;

        private String swiftMsgType;

        private String processID;

        private String stageCode;

        private Long checkbox8;

        private String remitterAddressLine2;

        private String remitterAddressLine1;

        private String beneficiaryAddressLine1;

        private String beneficiaryAddressLine2;

        private String boRefID;

        private String productStatus;

        private String taskID;

        private String dmsEventID;

        private Long stepperCompletionPercentage;

        private Long lteaIndicator;

        private String generalDetails;

        private String disposalInstruction;

        private String tradeDisposal;

        private String fundsDisposal;

        private String declaration;

        private String attachments;

        private String preview;

        private String irOrdrInstitution;

        private String copyFrom;

        private String debitAccNo;

        private Long misProduct;

        private Long xarProduct;

        private Long preRemAmtAccNoCb;

        private String sender;

        private String ordAccno;

        private String ordName;

        private String ordAddr1;

        private String ordAddr2;

        private String ordAddr3;

        private String benefNo;

        private String benefName;

        private String benefAddr1;

        private String benefAddr2;

        private String benefAddr3;

        private String swiftMessageData;

        private String tiMasterRef;

        private String preRemtAccNoCur;

        private String remtAccNoCur;

        private String debitAccNoCur;

        private String ackMessage;

        private String ackStatus;

        private String fgTrdPurposeCode;

        private String fgTrdAccounts;

        private String fgTrdFxRate;

        private String fgTrdPostLoans;

        private String fgTrdPreLoans;

        private String fgTrdLc;

        private String fgTrdApplFxRate;

        private Long versionID;

        private Long isMasterVersion;

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

        public Builder irNostroNumber(String irNostroNumber) {
            this.irNostroNumber = irNostroNumber;
            return this;
        }

        public Builder irValueDate(java.time.LocalDateTime irValueDate) {
            this.irValueDate = irValueDate;
            return this;
        }

        public Builder irCurCode(String irCurCode) {
            this.irCurCode = irCurCode;
            return this;
        }

        public Builder irAmt(Long irAmt) {
            this.irAmt = irAmt;
            return this;
        }

        public Builder curCode(String curCode) {
            this.curCode = curCode;
            return this;
        }

        public Builder amt(Long amt) {
            this.amt = amt;
            return this;
        }

        public Builder tradeDspAmt(Long tradeDspAmt) {
            this.tradeDspAmt = tradeDspAmt;
            return this;
        }

        public Builder fundsDspAmt(Long fundsDspAmt) {
            this.fundsDspAmt = fundsDspAmt;
            return this;
        }

        public Builder toBeDisposedAmt(Long toBeDisposedAmt) {
            this.toBeDisposedAmt = toBeDisposedAmt;
            return this;
        }

        public Builder bankToBeBook(Long bankToBeBook) {
            this.bankToBeBook = bankToBeBook;
            return this;
        }

        public Builder bookNewDeal(Long bookNewDeal) {
            this.bookNewDeal = bookNewDeal;
            return this;
        }

        public Builder providedTrdDspAmt(Long providedTrdDspAmt) {
            this.providedTrdDspAmt = providedTrdDspAmt;
            return this;
        }

        public Builder toBeDspTrdAmt(Long toBeDspTrdAmt) {
            this.toBeDspTrdAmt = toBeDspTrdAmt;
            return this;
        }

        public Builder ofcMaxDspAmt(Long ofcMaxDspAmt) {
            this.ofcMaxDspAmt = ofcMaxDspAmt;
            return this;
        }

        public Builder ofcDspAmt(Long ofcDspAmt) {
            this.ofcDspAmt = ofcDspAmt;
            return this;
        }

        public Builder elcMaxDspAmt(Long elcMaxDspAmt) {
            this.elcMaxDspAmt = elcMaxDspAmt;
            return this;
        }

        public Builder elcDspAmt(Long elcDspAmt) {
            this.elcDspAmt = elcDspAmt;
            return this;
        }

        public Builder providedFundDspAmt(Long providedFundDspAmt) {
            this.providedFundDspAmt = providedFundDspAmt;
            return this;
        }

        public Builder toBeDspFundAmt(Long toBeDspFundAmt) {
            this.toBeDspFundAmt = toBeDspFundAmt;
            return this;
        }

        public Builder postShipDspAmt(Long postShipDspAmt) {
            this.postShipDspAmt = postShipDspAmt;
            return this;
        }

        public Builder preShipMaxDspAmt(Long preShipMaxDspAmt) {
            this.preShipMaxDspAmt = preShipMaxDspAmt;
            return this;
        }

        public Builder preShipDspAmt(Long preShipDspAmt) {
            this.preShipDspAmt = preShipDspAmt;
            return this;
        }

        public Builder preRemAmtAccNo(String preRemAmtAccNo) {
            this.preRemAmtAccNo = preRemAmtAccNo;
            return this;
        }

        public Builder accMaxDspAmt(Long accMaxDspAmt) {
            this.accMaxDspAmt = accMaxDspAmt;
            return this;
        }

        public Builder accDspAmt(Long accDspAmt) {
            this.accDspAmt = accDspAmt;
            return this;
        }

        public Builder remAmtAccNo(String remAmtAccNo) {
            this.remAmtAccNo = remAmtAccNo;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder issuingParty(String issuingParty) {
            this.issuingParty = issuingParty;
            return this;
        }

        public Builder irReferenceID(String irReferenceID) {
            this.irReferenceID = irReferenceID;
            return this;
        }

        public Builder custRefID(String custRefID) {
            this.custRefID = custRefID;
            return this;
        }

        public Builder detailsCharge(String detailsCharge) {
            this.detailsCharge = detailsCharge;
            return this;
        }

        public Builder irRemInfo(String irRemInfo) {
            this.irRemInfo = irRemInfo;
            return this;
        }

        public Builder remitterName(String remitterName) {
            this.remitterName = remitterName;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder swiftMsgType(String swiftMsgType) {
            this.swiftMsgType = swiftMsgType;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder checkbox8(Long checkbox8) {
            this.checkbox8 = checkbox8;
            return this;
        }

        public Builder remitterAddressLine2(String remitterAddressLine2) {
            this.remitterAddressLine2 = remitterAddressLine2;
            return this;
        }

        public Builder remitterAddressLine1(String remitterAddressLine1) {
            this.remitterAddressLine1 = remitterAddressLine1;
            return this;
        }

        public Builder beneficiaryAddressLine1(String beneficiaryAddressLine1) {
            this.beneficiaryAddressLine1 = beneficiaryAddressLine1;
            return this;
        }

        public Builder beneficiaryAddressLine2(String beneficiaryAddressLine2) {
            this.beneficiaryAddressLine2 = beneficiaryAddressLine2;
            return this;
        }

        public Builder boRefID(String boRefID) {
            this.boRefID = boRefID;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder taskID(String taskID) {
            this.taskID = taskID;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder stepperCompletionPercentage(Long stepperCompletionPercentage) {
            this.stepperCompletionPercentage = stepperCompletionPercentage;
            return this;
        }

        public Builder lteaIndicator(Long lteaIndicator) {
            this.lteaIndicator = lteaIndicator;
            return this;
        }

        public Builder generalDetails(String generalDetails) {
            this.generalDetails = generalDetails;
            return this;
        }

        public Builder disposalInstruction(String disposalInstruction) {
            this.disposalInstruction = disposalInstruction;
            return this;
        }

        public Builder tradeDisposal(String tradeDisposal) {
            this.tradeDisposal = tradeDisposal;
            return this;
        }

        public Builder fundsDisposal(String fundsDisposal) {
            this.fundsDisposal = fundsDisposal;
            return this;
        }

        public Builder declaration(String declaration) {
            this.declaration = declaration;
            return this;
        }

        public Builder attachments(String attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder preview(String preview) {
            this.preview = preview;
            return this;
        }

        public Builder irOrdrInstitution(String irOrdrInstitution) {
            this.irOrdrInstitution = irOrdrInstitution;
            return this;
        }

        public Builder copyFrom(String copyFrom) {
            this.copyFrom = copyFrom;
            return this;
        }

        public Builder debitAccNo(String debitAccNo) {
            this.debitAccNo = debitAccNo;
            return this;
        }

        public Builder misProduct(Long misProduct) {
            this.misProduct = misProduct;
            return this;
        }

        public Builder xarProduct(Long xarProduct) {
            this.xarProduct = xarProduct;
            return this;
        }

        public Builder preRemAmtAccNoCb(Long preRemAmtAccNoCb) {
            this.preRemAmtAccNoCb = preRemAmtAccNoCb;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder ordAccno(String ordAccno) {
            this.ordAccno = ordAccno;
            return this;
        }

        public Builder ordName(String ordName) {
            this.ordName = ordName;
            return this;
        }

        public Builder ordAddr1(String ordAddr1) {
            this.ordAddr1 = ordAddr1;
            return this;
        }

        public Builder ordAddr2(String ordAddr2) {
            this.ordAddr2 = ordAddr2;
            return this;
        }

        public Builder ordAddr3(String ordAddr3) {
            this.ordAddr3 = ordAddr3;
            return this;
        }

        public Builder benefNo(String benefNo) {
            this.benefNo = benefNo;
            return this;
        }

        public Builder benefName(String benefName) {
            this.benefName = benefName;
            return this;
        }

        public Builder benefAddr1(String benefAddr1) {
            this.benefAddr1 = benefAddr1;
            return this;
        }

        public Builder benefAddr2(String benefAddr2) {
            this.benefAddr2 = benefAddr2;
            return this;
        }

        public Builder benefAddr3(String benefAddr3) {
            this.benefAddr3 = benefAddr3;
            return this;
        }

        public Builder swiftMessageData(String swiftMessageData) {
            this.swiftMessageData = swiftMessageData;
            return this;
        }

        public Builder tiMasterRef(String tiMasterRef) {
            this.tiMasterRef = tiMasterRef;
            return this;
        }

        public Builder preRemtAccNoCur(String preRemtAccNoCur) {
            this.preRemtAccNoCur = preRemtAccNoCur;
            return this;
        }

        public Builder remtAccNoCur(String remtAccNoCur) {
            this.remtAccNoCur = remtAccNoCur;
            return this;
        }

        public Builder debitAccNoCur(String debitAccNoCur) {
            this.debitAccNoCur = debitAccNoCur;
            return this;
        }

        public Builder ackMessage(String ackMessage) {
            this.ackMessage = ackMessage;
            return this;
        }

        public Builder ackStatus(String ackStatus) {
            this.ackStatus = ackStatus;
            return this;
        }

        public Builder fgTrdPurposeCode(String fgTrdPurposeCode) {
            this.fgTrdPurposeCode = fgTrdPurposeCode;
            return this;
        }

        public Builder fgTrdAccounts(String fgTrdAccounts) {
            this.fgTrdAccounts = fgTrdAccounts;
            return this;
        }

        public Builder fgTrdFxRate(String fgTrdFxRate) {
            this.fgTrdFxRate = fgTrdFxRate;
            return this;
        }

        public Builder fgTrdPostLoans(String fgTrdPostLoans) {
            this.fgTrdPostLoans = fgTrdPostLoans;
            return this;
        }

        public Builder fgTrdPreLoans(String fgTrdPreLoans) {
            this.fgTrdPreLoans = fgTrdPreLoans;
            return this;
        }

        public Builder fgTrdLc(String fgTrdLc) {
            this.fgTrdLc = fgTrdLc;
            return this;
        }

        public Builder fgTrdApplFxRate(String fgTrdApplFxRate) {
            this.fgTrdApplFxRate = fgTrdApplFxRate;
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

        public FgTrdDiVersion build() {
            return new FgTrdDiVersion(ID, referenceID, typeCode, subTypeCode, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, irNostroNumber, irValueDate, irCurCode, irAmt, curCode, amt, tradeDspAmt, fundsDspAmt, toBeDisposedAmt, bankToBeBook, bookNewDeal, providedTrdDspAmt, toBeDspTrdAmt, ofcMaxDspAmt, ofcDspAmt, elcMaxDspAmt, elcDspAmt, providedFundDspAmt, toBeDspFundAmt, postShipDspAmt, preShipMaxDspAmt, preShipDspAmt, preRemAmtAccNo, accMaxDspAmt, accDspAmt, remAmtAccNo, applicantParty, issuingParty, irReferenceID, custRefID, detailsCharge, irRemInfo, remitterName, beneficiaryName, swiftMsgType, processID, stageCode, checkbox8, remitterAddressLine2, remitterAddressLine1, beneficiaryAddressLine1, beneficiaryAddressLine2, boRefID, productStatus, taskID, dmsEventID, stepperCompletionPercentage, lteaIndicator, generalDetails, disposalInstruction, tradeDisposal, fundsDisposal, declaration, attachments, preview, irOrdrInstitution, copyFrom, debitAccNo, misProduct, xarProduct, preRemAmtAccNoCb, sender, ordAccno, ordName, ordAddr1, ordAddr2, ordAddr3, benefNo, benefName, benefAddr1, benefAddr2, benefAddr3, swiftMessageData, tiMasterRef, preRemtAccNoCur, remtAccNoCur, debitAccNoCur, ackMessage, ackStatus, fgTrdPurposeCode, fgTrdAccounts, fgTrdFxRate, fgTrdPostLoans, fgTrdPreLoans, fgTrdLc, fgTrdApplFxRate, versionID, isMasterVersion);
        }
    }
}
