package com.bsit.codegeneration.record;

public record FgBatchDetail(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String paymentRefNo, String paymentType, java.time.LocalDateTime paymentDate, java.time.LocalDateTime instrumentDate, Long instrumentNumber, String drDescription, String drRefNo, String crRefNo, String bankCodeIndicator, String beneCode, String beneName, String beneBank, String beneBankAndIfscCode, String location, String printLocation, String beneAdd1, String beneAdd2, String beneAdd3, String beneAdd4, String beneAdd5, String beneCity, String beneState, String beneEmail, String paymentDet1, String paymentDet2, String paymentDet3, String paymentDet4, String deliveryMode, String transactionType, String hundiNumber, String boeTenor, String boeTenor1, java.time.LocalDateTime boeDate, java.time.LocalDateTime boeDueDate, java.time.LocalDateTime boeDueDateDelHolidays, java.time.LocalDateTime boeDueDateActualPrepay, String chequeNumber, String drawerCode, String drwrCollectionAreaName, String drwrFullName, String drwrLocationCode, String drwrAddressLine, String drwrBsnsAreaCode, String drwrBsnsAreaName, String drwrBankName, String drweMicrCode, String drweBankIfcCode, String accType, String drweFullName, String drweAddrLine1, String drweAddrLine2, String drweAddrLine3, String drweAddrLine4, String drweAddrLine5, String drweLocationCode, String drweBsnsAreaCode, String ddPayableLocation, String countOfAnnxrRec, String custSpecialsRefNo, String drwrCollectionAreaCode, String uploadRefID, Long lineNo, String drwrAccNoOtherBank, String drweBmsAcNo, Long layoutTemplateID, String layoutName, Long beneZipcode, Long boeAmount, Long amount, String drAcNo, String beneMobile, String beneAccNo, String clientCodeDynamic, String fileName, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String batchStatus, String batchRefID, String batchRemarks, String tiStatus, String tiBatchRefID, String tiRemarks, String tnxDisplayStatus, String tnxDisplayBatchID, String tnxDisplayRemarks, Long advanceInterest, Long netPayment, String valueDate, String utrNumber, Long charges, String checkBox, String companyCode, String companyName, Long fiscalYear, String customerCode, String customerName, String gstInvNo, String invoiceNumber, java.time.LocalDateTime invoiceDate, Long invAmount, String grnNo, java.time.LocalDateTime grnDate, String paymentTerm, java.time.LocalDateTime dueDate, String typeOfTransaction, String financeParty, String loanRequestType, java.time.LocalDateTime customMaturityDate, String layoutUuid, String financeRequestStatus, String financeRequested) {

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

        private String paymentRefNo;

        private String paymentType;

        private java.time.LocalDateTime paymentDate;

        private java.time.LocalDateTime instrumentDate;

        private Long instrumentNumber;

        private String drDescription;

        private String drRefNo;

        private String crRefNo;

        private String bankCodeIndicator;

        private String beneCode;

        private String beneName;

        private String beneBank;

        private String beneBankAndIfscCode;

        private String location;

        private String printLocation;

        private String beneAdd1;

        private String beneAdd2;

        private String beneAdd3;

        private String beneAdd4;

        private String beneAdd5;

        private String beneCity;

        private String beneState;

        private String beneEmail;

        private String paymentDet1;

        private String paymentDet2;

        private String paymentDet3;

        private String paymentDet4;

        private String deliveryMode;

        private String transactionType;

        private String hundiNumber;

        private String boeTenor;

        private String boeTenor1;

        private java.time.LocalDateTime boeDate;

        private java.time.LocalDateTime boeDueDate;

        private java.time.LocalDateTime boeDueDateDelHolidays;

        private java.time.LocalDateTime boeDueDateActualPrepay;

        private String chequeNumber;

        private String drawerCode;

        private String drwrCollectionAreaName;

        private String drwrFullName;

        private String drwrLocationCode;

        private String drwrAddressLine;

        private String drwrBsnsAreaCode;

        private String drwrBsnsAreaName;

        private String drwrBankName;

        private String drweMicrCode;

        private String drweBankIfcCode;

        private String accType;

        private String drweFullName;

        private String drweAddrLine1;

        private String drweAddrLine2;

        private String drweAddrLine3;

        private String drweAddrLine4;

        private String drweAddrLine5;

        private String drweLocationCode;

        private String drweBsnsAreaCode;

        private String ddPayableLocation;

        private String countOfAnnxrRec;

        private String custSpecialsRefNo;

        private String drwrCollectionAreaCode;

        private String uploadRefID;

        private Long lineNo;

        private String drwrAccNoOtherBank;

        private String drweBmsAcNo;

        private Long layoutTemplateID;

        private String layoutName;

        private Long beneZipcode;

        private Long boeAmount;

        private Long amount;

        private String drAcNo;

        private String beneMobile;

        private String beneAccNo;

        private String clientCodeDynamic;

        private String fileName;

        private Long equivalentAmount;

        private String equivalentCurrency;

        private Long displayAmount;

        private String displayCurrency;

        private Long authEquivalentAmount;

        private String authEquivalentCurrency;

        private Long displayEquivalentAmount;

        private String displayEquivalentCurrency;

        private Long authFxBaseRate;

        private Long displayFxBaseRate;

        private String applicantPartyCode;

        private String issuingPartyCode;

        private String batchStatus;

        private String batchRefID;

        private String batchRemarks;

        private String tiStatus;

        private String tiBatchRefID;

        private String tiRemarks;

        private String tnxDisplayStatus;

        private String tnxDisplayBatchID;

        private String tnxDisplayRemarks;

        private Long advanceInterest;

        private Long netPayment;

        private String valueDate;

        private String utrNumber;

        private Long charges;

        private String checkBox;

        private String companyCode;

        private String companyName;

        private Long fiscalYear;

        private String customerCode;

        private String customerName;

        private String gstInvNo;

        private String invoiceNumber;

        private java.time.LocalDateTime invoiceDate;

        private Long invAmount;

        private String grnNo;

        private java.time.LocalDateTime grnDate;

        private String paymentTerm;

        private java.time.LocalDateTime dueDate;

        private String typeOfTransaction;

        private String financeParty;

        private String loanRequestType;

        private java.time.LocalDateTime customMaturityDate;

        private String layoutUuid;

        private String financeRequestStatus;

        private String financeRequested;

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

        public Builder paymentRefNo(String paymentRefNo) {
            this.paymentRefNo = paymentRefNo;
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

        public Builder instrumentDate(java.time.LocalDateTime instrumentDate) {
            this.instrumentDate = instrumentDate;
            return this;
        }

        public Builder instrumentNumber(Long instrumentNumber) {
            this.instrumentNumber = instrumentNumber;
            return this;
        }

        public Builder drDescription(String drDescription) {
            this.drDescription = drDescription;
            return this;
        }

        public Builder drRefNo(String drRefNo) {
            this.drRefNo = drRefNo;
            return this;
        }

        public Builder crRefNo(String crRefNo) {
            this.crRefNo = crRefNo;
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            this.bankCodeIndicator = bankCodeIndicator;
            return this;
        }

        public Builder beneCode(String beneCode) {
            this.beneCode = beneCode;
            return this;
        }

        public Builder beneName(String beneName) {
            this.beneName = beneName;
            return this;
        }

        public Builder beneBank(String beneBank) {
            this.beneBank = beneBank;
            return this;
        }

        public Builder beneBankAndIfscCode(String beneBankAndIfscCode) {
            this.beneBankAndIfscCode = beneBankAndIfscCode;
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

        public Builder beneAdd1(String beneAdd1) {
            this.beneAdd1 = beneAdd1;
            return this;
        }

        public Builder beneAdd2(String beneAdd2) {
            this.beneAdd2 = beneAdd2;
            return this;
        }

        public Builder beneAdd3(String beneAdd3) {
            this.beneAdd3 = beneAdd3;
            return this;
        }

        public Builder beneAdd4(String beneAdd4) {
            this.beneAdd4 = beneAdd4;
            return this;
        }

        public Builder beneAdd5(String beneAdd5) {
            this.beneAdd5 = beneAdd5;
            return this;
        }

        public Builder beneCity(String beneCity) {
            this.beneCity = beneCity;
            return this;
        }

        public Builder beneState(String beneState) {
            this.beneState = beneState;
            return this;
        }

        public Builder beneEmail(String beneEmail) {
            this.beneEmail = beneEmail;
            return this;
        }

        public Builder paymentDet1(String paymentDet1) {
            this.paymentDet1 = paymentDet1;
            return this;
        }

        public Builder paymentDet2(String paymentDet2) {
            this.paymentDet2 = paymentDet2;
            return this;
        }

        public Builder paymentDet3(String paymentDet3) {
            this.paymentDet3 = paymentDet3;
            return this;
        }

        public Builder paymentDet4(String paymentDet4) {
            this.paymentDet4 = paymentDet4;
            return this;
        }

        public Builder deliveryMode(String deliveryMode) {
            this.deliveryMode = deliveryMode;
            return this;
        }

        public Builder transactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder hundiNumber(String hundiNumber) {
            this.hundiNumber = hundiNumber;
            return this;
        }

        public Builder boeTenor(String boeTenor) {
            this.boeTenor = boeTenor;
            return this;
        }

        public Builder boeTenor1(String boeTenor1) {
            this.boeTenor1 = boeTenor1;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder boeDueDate(java.time.LocalDateTime boeDueDate) {
            this.boeDueDate = boeDueDate;
            return this;
        }

        public Builder boeDueDateDelHolidays(java.time.LocalDateTime boeDueDateDelHolidays) {
            this.boeDueDateDelHolidays = boeDueDateDelHolidays;
            return this;
        }

        public Builder boeDueDateActualPrepay(java.time.LocalDateTime boeDueDateActualPrepay) {
            this.boeDueDateActualPrepay = boeDueDateActualPrepay;
            return this;
        }

        public Builder chequeNumber(String chequeNumber) {
            this.chequeNumber = chequeNumber;
            return this;
        }

        public Builder drawerCode(String drawerCode) {
            this.drawerCode = drawerCode;
            return this;
        }

        public Builder drwrCollectionAreaName(String drwrCollectionAreaName) {
            this.drwrCollectionAreaName = drwrCollectionAreaName;
            return this;
        }

        public Builder drwrFullName(String drwrFullName) {
            this.drwrFullName = drwrFullName;
            return this;
        }

        public Builder drwrLocationCode(String drwrLocationCode) {
            this.drwrLocationCode = drwrLocationCode;
            return this;
        }

        public Builder drwrAddressLine(String drwrAddressLine) {
            this.drwrAddressLine = drwrAddressLine;
            return this;
        }

        public Builder drwrBsnsAreaCode(String drwrBsnsAreaCode) {
            this.drwrBsnsAreaCode = drwrBsnsAreaCode;
            return this;
        }

        public Builder drwrBsnsAreaName(String drwrBsnsAreaName) {
            this.drwrBsnsAreaName = drwrBsnsAreaName;
            return this;
        }

        public Builder drwrBankName(String drwrBankName) {
            this.drwrBankName = drwrBankName;
            return this;
        }

        public Builder drweMicrCode(String drweMicrCode) {
            this.drweMicrCode = drweMicrCode;
            return this;
        }

        public Builder drweBankIfcCode(String drweBankIfcCode) {
            this.drweBankIfcCode = drweBankIfcCode;
            return this;
        }

        public Builder accType(String accType) {
            this.accType = accType;
            return this;
        }

        public Builder drweFullName(String drweFullName) {
            this.drweFullName = drweFullName;
            return this;
        }

        public Builder drweAddrLine1(String drweAddrLine1) {
            this.drweAddrLine1 = drweAddrLine1;
            return this;
        }

        public Builder drweAddrLine2(String drweAddrLine2) {
            this.drweAddrLine2 = drweAddrLine2;
            return this;
        }

        public Builder drweAddrLine3(String drweAddrLine3) {
            this.drweAddrLine3 = drweAddrLine3;
            return this;
        }

        public Builder drweAddrLine4(String drweAddrLine4) {
            this.drweAddrLine4 = drweAddrLine4;
            return this;
        }

        public Builder drweAddrLine5(String drweAddrLine5) {
            this.drweAddrLine5 = drweAddrLine5;
            return this;
        }

        public Builder drweLocationCode(String drweLocationCode) {
            this.drweLocationCode = drweLocationCode;
            return this;
        }

        public Builder drweBsnsAreaCode(String drweBsnsAreaCode) {
            this.drweBsnsAreaCode = drweBsnsAreaCode;
            return this;
        }

        public Builder ddPayableLocation(String ddPayableLocation) {
            this.ddPayableLocation = ddPayableLocation;
            return this;
        }

        public Builder countOfAnnxrRec(String countOfAnnxrRec) {
            this.countOfAnnxrRec = countOfAnnxrRec;
            return this;
        }

        public Builder custSpecialsRefNo(String custSpecialsRefNo) {
            this.custSpecialsRefNo = custSpecialsRefNo;
            return this;
        }

        public Builder drwrCollectionAreaCode(String drwrCollectionAreaCode) {
            this.drwrCollectionAreaCode = drwrCollectionAreaCode;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder drwrAccNoOtherBank(String drwrAccNoOtherBank) {
            this.drwrAccNoOtherBank = drwrAccNoOtherBank;
            return this;
        }

        public Builder drweBmsAcNo(String drweBmsAcNo) {
            this.drweBmsAcNo = drweBmsAcNo;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder beneZipcode(Long beneZipcode) {
            this.beneZipcode = beneZipcode;
            return this;
        }

        public Builder boeAmount(Long boeAmount) {
            this.boeAmount = boeAmount;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder drAcNo(String drAcNo) {
            this.drAcNo = drAcNo;
            return this;
        }

        public Builder beneMobile(String beneMobile) {
            this.beneMobile = beneMobile;
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            this.beneAccNo = beneAccNo;
            return this;
        }

        public Builder clientCodeDynamic(String clientCodeDynamic) {
            this.clientCodeDynamic = clientCodeDynamic;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder equivalentAmount(Long equivalentAmount) {
            this.equivalentAmount = equivalentAmount;
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            this.equivalentCurrency = equivalentCurrency;
            return this;
        }

        public Builder displayAmount(Long displayAmount) {
            this.displayAmount = displayAmount;
            return this;
        }

        public Builder displayCurrency(String displayCurrency) {
            this.displayCurrency = displayCurrency;
            return this;
        }

        public Builder authEquivalentAmount(Long authEquivalentAmount) {
            this.authEquivalentAmount = authEquivalentAmount;
            return this;
        }

        public Builder authEquivalentCurrency(String authEquivalentCurrency) {
            this.authEquivalentCurrency = authEquivalentCurrency;
            return this;
        }

        public Builder displayEquivalentAmount(Long displayEquivalentAmount) {
            this.displayEquivalentAmount = displayEquivalentAmount;
            return this;
        }

        public Builder displayEquivalentCurrency(String displayEquivalentCurrency) {
            this.displayEquivalentCurrency = displayEquivalentCurrency;
            return this;
        }

        public Builder authFxBaseRate(Long authFxBaseRate) {
            this.authFxBaseRate = authFxBaseRate;
            return this;
        }

        public Builder displayFxBaseRate(Long displayFxBaseRate) {
            this.displayFxBaseRate = displayFxBaseRate;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
            return this;
        }

        public Builder batchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
            return this;
        }

        public Builder batchRefID(String batchRefID) {
            this.batchRefID = batchRefID;
            return this;
        }

        public Builder batchRemarks(String batchRemarks) {
            this.batchRemarks = batchRemarks;
            return this;
        }

        public Builder tiStatus(String tiStatus) {
            this.tiStatus = tiStatus;
            return this;
        }

        public Builder tiBatchRefID(String tiBatchRefID) {
            this.tiBatchRefID = tiBatchRefID;
            return this;
        }

        public Builder tiRemarks(String tiRemarks) {
            this.tiRemarks = tiRemarks;
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            this.tnxDisplayStatus = tnxDisplayStatus;
            return this;
        }

        public Builder tnxDisplayBatchID(String tnxDisplayBatchID) {
            this.tnxDisplayBatchID = tnxDisplayBatchID;
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            this.tnxDisplayRemarks = tnxDisplayRemarks;
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

        public Builder valueDate(String valueDate) {
            this.valueDate = valueDate;
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

        public Builder checkBox(String checkBox) {
            this.checkBox = checkBox;
            return this;
        }

        public Builder companyCode(String companyCode) {
            this.companyCode = companyCode;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder fiscalYear(Long fiscalYear) {
            this.fiscalYear = fiscalYear;
            return this;
        }

        public Builder customerCode(String customerCode) {
            this.customerCode = customerCode;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder gstInvNo(String gstInvNo) {
            this.gstInvNo = gstInvNo;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invAmount(Long invAmount) {
            this.invAmount = invAmount;
            return this;
        }

        public Builder grnNo(String grnNo) {
            this.grnNo = grnNo;
            return this;
        }

        public Builder grnDate(java.time.LocalDateTime grnDate) {
            this.grnDate = grnDate;
            return this;
        }

        public Builder paymentTerm(String paymentTerm) {
            this.paymentTerm = paymentTerm;
            return this;
        }

        public Builder dueDate(java.time.LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder typeOfTransaction(String typeOfTransaction) {
            this.typeOfTransaction = typeOfTransaction;
            return this;
        }

        public Builder financeParty(String financeParty) {
            this.financeParty = financeParty;
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            this.loanRequestType = loanRequestType;
            return this;
        }

        public Builder customMaturityDate(java.time.LocalDateTime customMaturityDate) {
            this.customMaturityDate = customMaturityDate;
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            this.layoutUuid = layoutUuid;
            return this;
        }

        public Builder financeRequestStatus(String financeRequestStatus) {
            this.financeRequestStatus = financeRequestStatus;
            return this;
        }

        public Builder financeRequested(String financeRequested) {
            this.financeRequested = financeRequested;
            return this;
        }

        public FgBatchDetail build() {
            return new FgBatchDetail(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, paymentRefNo, paymentType, paymentDate, instrumentDate, instrumentNumber, drDescription, drRefNo, crRefNo, bankCodeIndicator, beneCode, beneName, beneBank, beneBankAndIfscCode, location, printLocation, beneAdd1, beneAdd2, beneAdd3, beneAdd4, beneAdd5, beneCity, beneState, beneEmail, paymentDet1, paymentDet2, paymentDet3, paymentDet4, deliveryMode, transactionType, hundiNumber, boeTenor, boeTenor1, boeDate, boeDueDate, boeDueDateDelHolidays, boeDueDateActualPrepay, chequeNumber, drawerCode, drwrCollectionAreaName, drwrFullName, drwrLocationCode, drwrAddressLine, drwrBsnsAreaCode, drwrBsnsAreaName, drwrBankName, drweMicrCode, drweBankIfcCode, accType, drweFullName, drweAddrLine1, drweAddrLine2, drweAddrLine3, drweAddrLine4, drweAddrLine5, drweLocationCode, drweBsnsAreaCode, ddPayableLocation, countOfAnnxrRec, custSpecialsRefNo, drwrCollectionAreaCode, uploadRefID, lineNo, drwrAccNoOtherBank, drweBmsAcNo, layoutTemplateID, layoutName, beneZipcode, boeAmount, amount, drAcNo, beneMobile, beneAccNo, clientCodeDynamic, fileName, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate, applicantPartyCode, issuingPartyCode, batchStatus, batchRefID, batchRemarks, tiStatus, tiBatchRefID, tiRemarks, tnxDisplayStatus, tnxDisplayBatchID, tnxDisplayRemarks, advanceInterest, netPayment, valueDate, utrNumber, charges, checkBox, companyCode, companyName, fiscalYear, customerCode, customerName, gstInvNo, invoiceNumber, invoiceDate, invAmount, grnNo, grnDate, paymentTerm, dueDate, typeOfTransaction, financeParty, loanRequestType, customMaturityDate, layoutUuid, financeRequestStatus, financeRequested);
        }
    }
}
