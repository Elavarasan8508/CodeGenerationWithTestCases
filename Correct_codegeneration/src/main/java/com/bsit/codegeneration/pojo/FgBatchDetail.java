package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgBatchDetail {

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

    private String paymentRefNo;

    private String paymentType;

    private java.time.LocalDateTime paymentDate;

    private java.time.LocalDateTime instrumentDate;

    private java.math.BigDecimal instrumentNumber;

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

    private Integer uploadRefID;

    private Long lineNo;

    private String drwrAccNoOtherBank;

    private String drweBmsAcNo;

    private Integer layoutTemplateID;

    private String layoutName;

    private java.math.BigDecimal beneZipcode;

    private java.math.BigDecimal boeAmount;

    private java.math.BigDecimal amount;

    private String drAcNo;

    private String beneMobile;

    private String beneAccNo;

    private String clientCodeDynamic;

    private String fileName;

    private java.math.BigDecimal equivalentAmount;

    private String equivalentCurrency;

    private java.math.BigDecimal displayAmount;

    private String displayCurrency;

    private java.math.BigDecimal authEquivalentAmount;

    private String authEquivalentCurrency;

    private java.math.BigDecimal displayEquivalentAmount;

    private String displayEquivalentCurrency;

    private java.math.BigDecimal authFxBaseRate;

    private java.math.BigDecimal displayFxBaseRate;

    private String applicantPartyCode;

    private String issuingPartyCode;

    private String batchStatus;

    private Integer batchRefID;

    private String batchRemarks;

    private String tiStatus;

    private Integer tiBatchRefID;

    private String tiRemarks;

    private String tnxDisplayStatus;

    private Integer tnxDisplayBatchID;

    private String tnxDisplayRemarks;

    private java.math.BigDecimal advanceInterest;

    private java.math.BigDecimal netPayment;

    private String valueDate;

    private String utrNumber;

    private java.math.BigDecimal charges;

    private String checkBox;

    private String companyCode;

    private String companyName;

    private java.math.BigDecimal fiscalYear;

    private String customerCode;

    private String customerName;

    private String gstInvNo;

    private String invoiceNumber;

    private java.time.LocalDateTime invoiceDate;

    private java.math.BigDecimal invAmount;

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

    public FgBatchDetail() {
    }

    public FgBatchDetail(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String paymentRefNo, String paymentType, java.time.LocalDateTime paymentDate, java.time.LocalDateTime instrumentDate, java.math.BigDecimal instrumentNumber, String drDescription, String drRefNo, String crRefNo, String bankCodeIndicator, String beneCode, String beneName, String beneBank, String beneBankAndIfscCode, String location, String printLocation, String beneAdd1, String beneAdd2, String beneAdd3, String beneAdd4, String beneAdd5, String beneCity, String beneState, String beneEmail, String paymentDet1, String paymentDet2, String paymentDet3, String paymentDet4, String deliveryMode, String transactionType, String hundiNumber, String boeTenor, String boeTenor1, java.time.LocalDateTime boeDate, java.time.LocalDateTime boeDueDate, java.time.LocalDateTime boeDueDateDelHolidays, java.time.LocalDateTime boeDueDateActualPrepay, String chequeNumber, String drawerCode, String drwrCollectionAreaName, String drwrFullName, String drwrLocationCode, String drwrAddressLine, String drwrBsnsAreaCode, String drwrBsnsAreaName, String drwrBankName, String drweMicrCode, String drweBankIfcCode, String accType, String drweFullName, String drweAddrLine1, String drweAddrLine2, String drweAddrLine3, String drweAddrLine4, String drweAddrLine5, String drweLocationCode, String drweBsnsAreaCode, String ddPayableLocation, String countOfAnnxrRec, String custSpecialsRefNo, String drwrCollectionAreaCode, Integer uploadRefID, Long lineNo, String drwrAccNoOtherBank, String drweBmsAcNo, Integer layoutTemplateID, String layoutName, java.math.BigDecimal beneZipcode, java.math.BigDecimal boeAmount, java.math.BigDecimal amount, String drAcNo, String beneMobile, String beneAccNo, String clientCodeDynamic, String fileName, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String batchStatus, Integer batchRefID, String batchRemarks, String tiStatus, Integer tiBatchRefID, String tiRemarks, String tnxDisplayStatus, Integer tnxDisplayBatchID, String tnxDisplayRemarks, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valueDate, String utrNumber, java.math.BigDecimal charges, String checkBox, String companyCode, String companyName, java.math.BigDecimal fiscalYear, String customerCode, String customerName, String gstInvNo, String invoiceNumber, java.time.LocalDateTime invoiceDate, java.math.BigDecimal invAmount, String grnNo, java.time.LocalDateTime grnDate, String paymentTerm, java.time.LocalDateTime dueDate, String typeOfTransaction, String financeParty, String loanRequestType, java.time.LocalDateTime customMaturityDate, String layoutUuid, String financeRequestStatus, String financeRequested) {
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
        this.paymentRefNo = paymentRefNo;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
        this.instrumentDate = instrumentDate;
        this.instrumentNumber = instrumentNumber;
        this.drDescription = drDescription;
        this.drRefNo = drRefNo;
        this.crRefNo = crRefNo;
        this.bankCodeIndicator = bankCodeIndicator;
        this.beneCode = beneCode;
        this.beneName = beneName;
        this.beneBank = beneBank;
        this.beneBankAndIfscCode = beneBankAndIfscCode;
        this.location = location;
        this.printLocation = printLocation;
        this.beneAdd1 = beneAdd1;
        this.beneAdd2 = beneAdd2;
        this.beneAdd3 = beneAdd3;
        this.beneAdd4 = beneAdd4;
        this.beneAdd5 = beneAdd5;
        this.beneCity = beneCity;
        this.beneState = beneState;
        this.beneEmail = beneEmail;
        this.paymentDet1 = paymentDet1;
        this.paymentDet2 = paymentDet2;
        this.paymentDet3 = paymentDet3;
        this.paymentDet4 = paymentDet4;
        this.deliveryMode = deliveryMode;
        this.transactionType = transactionType;
        this.hundiNumber = hundiNumber;
        this.boeTenor = boeTenor;
        this.boeTenor1 = boeTenor1;
        this.boeDate = boeDate;
        this.boeDueDate = boeDueDate;
        this.boeDueDateDelHolidays = boeDueDateDelHolidays;
        this.boeDueDateActualPrepay = boeDueDateActualPrepay;
        this.chequeNumber = chequeNumber;
        this.drawerCode = drawerCode;
        this.drwrCollectionAreaName = drwrCollectionAreaName;
        this.drwrFullName = drwrFullName;
        this.drwrLocationCode = drwrLocationCode;
        this.drwrAddressLine = drwrAddressLine;
        this.drwrBsnsAreaCode = drwrBsnsAreaCode;
        this.drwrBsnsAreaName = drwrBsnsAreaName;
        this.drwrBankName = drwrBankName;
        this.drweMicrCode = drweMicrCode;
        this.drweBankIfcCode = drweBankIfcCode;
        this.accType = accType;
        this.drweFullName = drweFullName;
        this.drweAddrLine1 = drweAddrLine1;
        this.drweAddrLine2 = drweAddrLine2;
        this.drweAddrLine3 = drweAddrLine3;
        this.drweAddrLine4 = drweAddrLine4;
        this.drweAddrLine5 = drweAddrLine5;
        this.drweLocationCode = drweLocationCode;
        this.drweBsnsAreaCode = drweBsnsAreaCode;
        this.ddPayableLocation = ddPayableLocation;
        this.countOfAnnxrRec = countOfAnnxrRec;
        this.custSpecialsRefNo = custSpecialsRefNo;
        this.drwrCollectionAreaCode = drwrCollectionAreaCode;
        this.uploadRefID = uploadRefID;
        this.lineNo = lineNo;
        this.drwrAccNoOtherBank = drwrAccNoOtherBank;
        this.drweBmsAcNo = drweBmsAcNo;
        this.layoutTemplateID = layoutTemplateID;
        this.layoutName = layoutName;
        this.beneZipcode = beneZipcode;
        this.boeAmount = boeAmount;
        this.amount = amount;
        this.drAcNo = drAcNo;
        this.beneMobile = beneMobile;
        this.beneAccNo = beneAccNo;
        this.clientCodeDynamic = clientCodeDynamic;
        this.fileName = fileName;
        this.equivalentAmount = equivalentAmount;
        this.equivalentCurrency = equivalentCurrency;
        this.displayAmount = displayAmount;
        this.displayCurrency = displayCurrency;
        this.authEquivalentAmount = authEquivalentAmount;
        this.authEquivalentCurrency = authEquivalentCurrency;
        this.displayEquivalentAmount = displayEquivalentAmount;
        this.displayEquivalentCurrency = displayEquivalentCurrency;
        this.authFxBaseRate = authFxBaseRate;
        this.displayFxBaseRate = displayFxBaseRate;
        this.applicantPartyCode = applicantPartyCode;
        this.issuingPartyCode = issuingPartyCode;
        this.batchStatus = batchStatus;
        this.batchRefID = batchRefID;
        this.batchRemarks = batchRemarks;
        this.tiStatus = tiStatus;
        this.tiBatchRefID = tiBatchRefID;
        this.tiRemarks = tiRemarks;
        this.tnxDisplayStatus = tnxDisplayStatus;
        this.tnxDisplayBatchID = tnxDisplayBatchID;
        this.tnxDisplayRemarks = tnxDisplayRemarks;
        this.advanceInterest = advanceInterest;
        this.netPayment = netPayment;
        this.valueDate = valueDate;
        this.utrNumber = utrNumber;
        this.charges = charges;
        this.checkBox = checkBox;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.fiscalYear = fiscalYear;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.gstInvNo = gstInvNo;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invAmount = invAmount;
        this.grnNo = grnNo;
        this.grnDate = grnDate;
        this.paymentTerm = paymentTerm;
        this.dueDate = dueDate;
        this.typeOfTransaction = typeOfTransaction;
        this.financeParty = financeParty;
        this.loanRequestType = loanRequestType;
        this.customMaturityDate = customMaturityDate;
        this.layoutUuid = layoutUuid;
        this.financeRequestStatus = financeRequestStatus;
        this.financeRequested = financeRequested;
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

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
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

    public java.time.LocalDateTime getInstrumentDate() {
        return instrumentDate;
    }

    public void setInstrumentDate(java.time.LocalDateTime instrumentDate) {
        this.instrumentDate = instrumentDate;
    }

    public java.math.BigDecimal getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(java.math.BigDecimal instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public String getDrDescription() {
        return drDescription;
    }

    public void setDrDescription(String drDescription) {
        this.drDescription = drDescription;
    }

    public String getDrRefNo() {
        return drRefNo;
    }

    public void setDrRefNo(String drRefNo) {
        this.drRefNo = drRefNo;
    }

    public String getCrRefNo() {
        return crRefNo;
    }

    public void setCrRefNo(String crRefNo) {
        this.crRefNo = crRefNo;
    }

    public String getBankCodeIndicator() {
        return bankCodeIndicator;
    }

    public void setBankCodeIndicator(String bankCodeIndicator) {
        this.bankCodeIndicator = bankCodeIndicator;
    }

    public String getBeneCode() {
        return beneCode;
    }

    public void setBeneCode(String beneCode) {
        this.beneCode = beneCode;
    }

    public String getBeneName() {
        return beneName;
    }

    public void setBeneName(String beneName) {
        this.beneName = beneName;
    }

    public String getBeneBank() {
        return beneBank;
    }

    public void setBeneBank(String beneBank) {
        this.beneBank = beneBank;
    }

    public String getBeneBankAndIfscCode() {
        return beneBankAndIfscCode;
    }

    public void setBeneBankAndIfscCode(String beneBankAndIfscCode) {
        this.beneBankAndIfscCode = beneBankAndIfscCode;
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

    public String getBeneAdd1() {
        return beneAdd1;
    }

    public void setBeneAdd1(String beneAdd1) {
        this.beneAdd1 = beneAdd1;
    }

    public String getBeneAdd2() {
        return beneAdd2;
    }

    public void setBeneAdd2(String beneAdd2) {
        this.beneAdd2 = beneAdd2;
    }

    public String getBeneAdd3() {
        return beneAdd3;
    }

    public void setBeneAdd3(String beneAdd3) {
        this.beneAdd3 = beneAdd3;
    }

    public String getBeneAdd4() {
        return beneAdd4;
    }

    public void setBeneAdd4(String beneAdd4) {
        this.beneAdd4 = beneAdd4;
    }

    public String getBeneAdd5() {
        return beneAdd5;
    }

    public void setBeneAdd5(String beneAdd5) {
        this.beneAdd5 = beneAdd5;
    }

    public String getBeneCity() {
        return beneCity;
    }

    public void setBeneCity(String beneCity) {
        this.beneCity = beneCity;
    }

    public String getBeneState() {
        return beneState;
    }

    public void setBeneState(String beneState) {
        this.beneState = beneState;
    }

    public String getBeneEmail() {
        return beneEmail;
    }

    public void setBeneEmail(String beneEmail) {
        this.beneEmail = beneEmail;
    }

    public String getPaymentDet1() {
        return paymentDet1;
    }

    public void setPaymentDet1(String paymentDet1) {
        this.paymentDet1 = paymentDet1;
    }

    public String getPaymentDet2() {
        return paymentDet2;
    }

    public void setPaymentDet2(String paymentDet2) {
        this.paymentDet2 = paymentDet2;
    }

    public String getPaymentDet3() {
        return paymentDet3;
    }

    public void setPaymentDet3(String paymentDet3) {
        this.paymentDet3 = paymentDet3;
    }

    public String getPaymentDet4() {
        return paymentDet4;
    }

    public void setPaymentDet4(String paymentDet4) {
        this.paymentDet4 = paymentDet4;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getHundiNumber() {
        return hundiNumber;
    }

    public void setHundiNumber(String hundiNumber) {
        this.hundiNumber = hundiNumber;
    }

    public String getBoeTenor() {
        return boeTenor;
    }

    public void setBoeTenor(String boeTenor) {
        this.boeTenor = boeTenor;
    }

    public String getBoeTenor1() {
        return boeTenor1;
    }

    public void setBoeTenor1(String boeTenor1) {
        this.boeTenor1 = boeTenor1;
    }

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public java.time.LocalDateTime getBoeDueDate() {
        return boeDueDate;
    }

    public void setBoeDueDate(java.time.LocalDateTime boeDueDate) {
        this.boeDueDate = boeDueDate;
    }

    public java.time.LocalDateTime getBoeDueDateDelHolidays() {
        return boeDueDateDelHolidays;
    }

    public void setBoeDueDateDelHolidays(java.time.LocalDateTime boeDueDateDelHolidays) {
        this.boeDueDateDelHolidays = boeDueDateDelHolidays;
    }

    public java.time.LocalDateTime getBoeDueDateActualPrepay() {
        return boeDueDateActualPrepay;
    }

    public void setBoeDueDateActualPrepay(java.time.LocalDateTime boeDueDateActualPrepay) {
        this.boeDueDateActualPrepay = boeDueDateActualPrepay;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getDrawerCode() {
        return drawerCode;
    }

    public void setDrawerCode(String drawerCode) {
        this.drawerCode = drawerCode;
    }

    public String getDrwrCollectionAreaName() {
        return drwrCollectionAreaName;
    }

    public void setDrwrCollectionAreaName(String drwrCollectionAreaName) {
        this.drwrCollectionAreaName = drwrCollectionAreaName;
    }

    public String getDrwrFullName() {
        return drwrFullName;
    }

    public void setDrwrFullName(String drwrFullName) {
        this.drwrFullName = drwrFullName;
    }

    public String getDrwrLocationCode() {
        return drwrLocationCode;
    }

    public void setDrwrLocationCode(String drwrLocationCode) {
        this.drwrLocationCode = drwrLocationCode;
    }

    public String getDrwrAddressLine() {
        return drwrAddressLine;
    }

    public void setDrwrAddressLine(String drwrAddressLine) {
        this.drwrAddressLine = drwrAddressLine;
    }

    public String getDrwrBsnsAreaCode() {
        return drwrBsnsAreaCode;
    }

    public void setDrwrBsnsAreaCode(String drwrBsnsAreaCode) {
        this.drwrBsnsAreaCode = drwrBsnsAreaCode;
    }

    public String getDrwrBsnsAreaName() {
        return drwrBsnsAreaName;
    }

    public void setDrwrBsnsAreaName(String drwrBsnsAreaName) {
        this.drwrBsnsAreaName = drwrBsnsAreaName;
    }

    public String getDrwrBankName() {
        return drwrBankName;
    }

    public void setDrwrBankName(String drwrBankName) {
        this.drwrBankName = drwrBankName;
    }

    public String getDrweMicrCode() {
        return drweMicrCode;
    }

    public void setDrweMicrCode(String drweMicrCode) {
        this.drweMicrCode = drweMicrCode;
    }

    public String getDrweBankIfcCode() {
        return drweBankIfcCode;
    }

    public void setDrweBankIfcCode(String drweBankIfcCode) {
        this.drweBankIfcCode = drweBankIfcCode;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getDrweFullName() {
        return drweFullName;
    }

    public void setDrweFullName(String drweFullName) {
        this.drweFullName = drweFullName;
    }

    public String getDrweAddrLine1() {
        return drweAddrLine1;
    }

    public void setDrweAddrLine1(String drweAddrLine1) {
        this.drweAddrLine1 = drweAddrLine1;
    }

    public String getDrweAddrLine2() {
        return drweAddrLine2;
    }

    public void setDrweAddrLine2(String drweAddrLine2) {
        this.drweAddrLine2 = drweAddrLine2;
    }

    public String getDrweAddrLine3() {
        return drweAddrLine3;
    }

    public void setDrweAddrLine3(String drweAddrLine3) {
        this.drweAddrLine3 = drweAddrLine3;
    }

    public String getDrweAddrLine4() {
        return drweAddrLine4;
    }

    public void setDrweAddrLine4(String drweAddrLine4) {
        this.drweAddrLine4 = drweAddrLine4;
    }

    public String getDrweAddrLine5() {
        return drweAddrLine5;
    }

    public void setDrweAddrLine5(String drweAddrLine5) {
        this.drweAddrLine5 = drweAddrLine5;
    }

    public String getDrweLocationCode() {
        return drweLocationCode;
    }

    public void setDrweLocationCode(String drweLocationCode) {
        this.drweLocationCode = drweLocationCode;
    }

    public String getDrweBsnsAreaCode() {
        return drweBsnsAreaCode;
    }

    public void setDrweBsnsAreaCode(String drweBsnsAreaCode) {
        this.drweBsnsAreaCode = drweBsnsAreaCode;
    }

    public String getDdPayableLocation() {
        return ddPayableLocation;
    }

    public void setDdPayableLocation(String ddPayableLocation) {
        this.ddPayableLocation = ddPayableLocation;
    }

    public String getCountOfAnnxrRec() {
        return countOfAnnxrRec;
    }

    public void setCountOfAnnxrRec(String countOfAnnxrRec) {
        this.countOfAnnxrRec = countOfAnnxrRec;
    }

    public String getCustSpecialsRefNo() {
        return custSpecialsRefNo;
    }

    public void setCustSpecialsRefNo(String custSpecialsRefNo) {
        this.custSpecialsRefNo = custSpecialsRefNo;
    }

    public String getDrwrCollectionAreaCode() {
        return drwrCollectionAreaCode;
    }

    public void setDrwrCollectionAreaCode(String drwrCollectionAreaCode) {
        this.drwrCollectionAreaCode = drwrCollectionAreaCode;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public String getDrwrAccNoOtherBank() {
        return drwrAccNoOtherBank;
    }

    public void setDrwrAccNoOtherBank(String drwrAccNoOtherBank) {
        this.drwrAccNoOtherBank = drwrAccNoOtherBank;
    }

    public String getDrweBmsAcNo() {
        return drweBmsAcNo;
    }

    public void setDrweBmsAcNo(String drweBmsAcNo) {
        this.drweBmsAcNo = drweBmsAcNo;
    }

    public Integer getLayoutTemplateID() {
        return layoutTemplateID;
    }

    public void setLayoutTemplateID(Integer layoutTemplateID) {
        this.layoutTemplateID = layoutTemplateID;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public java.math.BigDecimal getBeneZipcode() {
        return beneZipcode;
    }

    public void setBeneZipcode(java.math.BigDecimal beneZipcode) {
        this.beneZipcode = beneZipcode;
    }

    public java.math.BigDecimal getBoeAmount() {
        return boeAmount;
    }

    public void setBoeAmount(java.math.BigDecimal boeAmount) {
        this.boeAmount = boeAmount;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public String getDrAcNo() {
        return drAcNo;
    }

    public void setDrAcNo(String drAcNo) {
        this.drAcNo = drAcNo;
    }

    public String getBeneMobile() {
        return beneMobile;
    }

    public void setBeneMobile(String beneMobile) {
        this.beneMobile = beneMobile;
    }

    public String getBeneAccNo() {
        return beneAccNo;
    }

    public void setBeneAccNo(String beneAccNo) {
        this.beneAccNo = beneAccNo;
    }

    public String getClientCodeDynamic() {
        return clientCodeDynamic;
    }

    public void setClientCodeDynamic(String clientCodeDynamic) {
        this.clientCodeDynamic = clientCodeDynamic;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public java.math.BigDecimal getEquivalentAmount() {
        return equivalentAmount;
    }

    public void setEquivalentAmount(java.math.BigDecimal equivalentAmount) {
        this.equivalentAmount = equivalentAmount;
    }

    public String getEquivalentCurrency() {
        return equivalentCurrency;
    }

    public void setEquivalentCurrency(String equivalentCurrency) {
        this.equivalentCurrency = equivalentCurrency;
    }

    public java.math.BigDecimal getDisplayAmount() {
        return displayAmount;
    }

    public void setDisplayAmount(java.math.BigDecimal displayAmount) {
        this.displayAmount = displayAmount;
    }

    public String getDisplayCurrency() {
        return displayCurrency;
    }

    public void setDisplayCurrency(String displayCurrency) {
        this.displayCurrency = displayCurrency;
    }

    public java.math.BigDecimal getAuthEquivalentAmount() {
        return authEquivalentAmount;
    }

    public void setAuthEquivalentAmount(java.math.BigDecimal authEquivalentAmount) {
        this.authEquivalentAmount = authEquivalentAmount;
    }

    public String getAuthEquivalentCurrency() {
        return authEquivalentCurrency;
    }

    public void setAuthEquivalentCurrency(String authEquivalentCurrency) {
        this.authEquivalentCurrency = authEquivalentCurrency;
    }

    public java.math.BigDecimal getDisplayEquivalentAmount() {
        return displayEquivalentAmount;
    }

    public void setDisplayEquivalentAmount(java.math.BigDecimal displayEquivalentAmount) {
        this.displayEquivalentAmount = displayEquivalentAmount;
    }

    public String getDisplayEquivalentCurrency() {
        return displayEquivalentCurrency;
    }

    public void setDisplayEquivalentCurrency(String displayEquivalentCurrency) {
        this.displayEquivalentCurrency = displayEquivalentCurrency;
    }

    public java.math.BigDecimal getAuthFxBaseRate() {
        return authFxBaseRate;
    }

    public void setAuthFxBaseRate(java.math.BigDecimal authFxBaseRate) {
        this.authFxBaseRate = authFxBaseRate;
    }

    public java.math.BigDecimal getDisplayFxBaseRate() {
        return displayFxBaseRate;
    }

    public void setDisplayFxBaseRate(java.math.BigDecimal displayFxBaseRate) {
        this.displayFxBaseRate = displayFxBaseRate;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Integer getBatchRefID() {
        return batchRefID;
    }

    public void setBatchRefID(Integer batchRefID) {
        this.batchRefID = batchRefID;
    }

    public String getBatchRemarks() {
        return batchRemarks;
    }

    public void setBatchRemarks(String batchRemarks) {
        this.batchRemarks = batchRemarks;
    }

    public String getTiStatus() {
        return tiStatus;
    }

    public void setTiStatus(String tiStatus) {
        this.tiStatus = tiStatus;
    }

    public Integer getTiBatchRefID() {
        return tiBatchRefID;
    }

    public void setTiBatchRefID(Integer tiBatchRefID) {
        this.tiBatchRefID = tiBatchRefID;
    }

    public String getTiRemarks() {
        return tiRemarks;
    }

    public void setTiRemarks(String tiRemarks) {
        this.tiRemarks = tiRemarks;
    }

    public String getTnxDisplayStatus() {
        return tnxDisplayStatus;
    }

    public void setTnxDisplayStatus(String tnxDisplayStatus) {
        this.tnxDisplayStatus = tnxDisplayStatus;
    }

    public Integer getTnxDisplayBatchID() {
        return tnxDisplayBatchID;
    }

    public void setTnxDisplayBatchID(Integer tnxDisplayBatchID) {
        this.tnxDisplayBatchID = tnxDisplayBatchID;
    }

    public String getTnxDisplayRemarks() {
        return tnxDisplayRemarks;
    }

    public void setTnxDisplayRemarks(String tnxDisplayRemarks) {
        this.tnxDisplayRemarks = tnxDisplayRemarks;
    }

    public java.math.BigDecimal getAdvanceInterest() {
        return advanceInterest;
    }

    public void setAdvanceInterest(java.math.BigDecimal advanceInterest) {
        this.advanceInterest = advanceInterest;
    }

    public java.math.BigDecimal getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(java.math.BigDecimal netPayment) {
        this.netPayment = netPayment;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getUtrNumber() {
        return utrNumber;
    }

    public void setUtrNumber(String utrNumber) {
        this.utrNumber = utrNumber;
    }

    public java.math.BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(java.math.BigDecimal charges) {
        this.charges = charges;
    }

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public java.math.BigDecimal getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(java.math.BigDecimal fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGstInvNo() {
        return gstInvNo;
    }

    public void setGstInvNo(String gstInvNo) {
        this.gstInvNo = gstInvNo;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public java.time.LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(java.time.LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public java.math.BigDecimal getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(java.math.BigDecimal invAmount) {
        this.invAmount = invAmount;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public java.time.LocalDateTime getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(java.time.LocalDateTime grnDate) {
        this.grnDate = grnDate;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public java.time.LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.time.LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getFinanceParty() {
        return financeParty;
    }

    public void setFinanceParty(String financeParty) {
        this.financeParty = financeParty;
    }

    public String getLoanRequestType() {
        return loanRequestType;
    }

    public void setLoanRequestType(String loanRequestType) {
        this.loanRequestType = loanRequestType;
    }

    public java.time.LocalDateTime getCustomMaturityDate() {
        return customMaturityDate;
    }

    public void setCustomMaturityDate(java.time.LocalDateTime customMaturityDate) {
        this.customMaturityDate = customMaturityDate;
    }

    public String getLayoutUuid() {
        return layoutUuid;
    }

    public void setLayoutUuid(String layoutUuid) {
        this.layoutUuid = layoutUuid;
    }

    public String getFinanceRequestStatus() {
        return financeRequestStatus;
    }

    public void setFinanceRequestStatus(String financeRequestStatus) {
        this.financeRequestStatus = financeRequestStatus;
    }

    public String getFinanceRequested() {
        return financeRequested;
    }

    public void setFinanceRequested(String financeRequested) {
        this.financeRequested = financeRequested;
    }

    public static class Builder {

        private FgBatchDetail instance = new FgBatchDetail();

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

        public Builder paymentRefNo(String paymentRefNo) {
            instance.setPaymentRefNo(paymentRefNo);
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

        public Builder instrumentDate(java.time.LocalDateTime instrumentDate) {
            instance.setInstrumentDate(instrumentDate);
            return this;
        }

        public Builder instrumentNumber(java.math.BigDecimal instrumentNumber) {
            instance.setInstrumentNumber(instrumentNumber);
            return this;
        }

        public Builder drDescription(String drDescription) {
            instance.setDrDescription(drDescription);
            return this;
        }

        public Builder drRefNo(String drRefNo) {
            instance.setDrRefNo(drRefNo);
            return this;
        }

        public Builder crRefNo(String crRefNo) {
            instance.setCrRefNo(crRefNo);
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            instance.setBankCodeIndicator(bankCodeIndicator);
            return this;
        }

        public Builder beneCode(String beneCode) {
            instance.setBeneCode(beneCode);
            return this;
        }

        public Builder beneName(String beneName) {
            instance.setBeneName(beneName);
            return this;
        }

        public Builder beneBank(String beneBank) {
            instance.setBeneBank(beneBank);
            return this;
        }

        public Builder beneBankAndIfscCode(String beneBankAndIfscCode) {
            instance.setBeneBankAndIfscCode(beneBankAndIfscCode);
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

        public Builder beneAdd1(String beneAdd1) {
            instance.setBeneAdd1(beneAdd1);
            return this;
        }

        public Builder beneAdd2(String beneAdd2) {
            instance.setBeneAdd2(beneAdd2);
            return this;
        }

        public Builder beneAdd3(String beneAdd3) {
            instance.setBeneAdd3(beneAdd3);
            return this;
        }

        public Builder beneAdd4(String beneAdd4) {
            instance.setBeneAdd4(beneAdd4);
            return this;
        }

        public Builder beneAdd5(String beneAdd5) {
            instance.setBeneAdd5(beneAdd5);
            return this;
        }

        public Builder beneCity(String beneCity) {
            instance.setBeneCity(beneCity);
            return this;
        }

        public Builder beneState(String beneState) {
            instance.setBeneState(beneState);
            return this;
        }

        public Builder beneEmail(String beneEmail) {
            instance.setBeneEmail(beneEmail);
            return this;
        }

        public Builder paymentDet1(String paymentDet1) {
            instance.setPaymentDet1(paymentDet1);
            return this;
        }

        public Builder paymentDet2(String paymentDet2) {
            instance.setPaymentDet2(paymentDet2);
            return this;
        }

        public Builder paymentDet3(String paymentDet3) {
            instance.setPaymentDet3(paymentDet3);
            return this;
        }

        public Builder paymentDet4(String paymentDet4) {
            instance.setPaymentDet4(paymentDet4);
            return this;
        }

        public Builder deliveryMode(String deliveryMode) {
            instance.setDeliveryMode(deliveryMode);
            return this;
        }

        public Builder transactionType(String transactionType) {
            instance.setTransactionType(transactionType);
            return this;
        }

        public Builder hundiNumber(String hundiNumber) {
            instance.setHundiNumber(hundiNumber);
            return this;
        }

        public Builder boeTenor(String boeTenor) {
            instance.setBoeTenor(boeTenor);
            return this;
        }

        public Builder boeTenor1(String boeTenor1) {
            instance.setBoeTenor1(boeTenor1);
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder boeDueDate(java.time.LocalDateTime boeDueDate) {
            instance.setBoeDueDate(boeDueDate);
            return this;
        }

        public Builder boeDueDateDelHolidays(java.time.LocalDateTime boeDueDateDelHolidays) {
            instance.setBoeDueDateDelHolidays(boeDueDateDelHolidays);
            return this;
        }

        public Builder boeDueDateActualPrepay(java.time.LocalDateTime boeDueDateActualPrepay) {
            instance.setBoeDueDateActualPrepay(boeDueDateActualPrepay);
            return this;
        }

        public Builder chequeNumber(String chequeNumber) {
            instance.setChequeNumber(chequeNumber);
            return this;
        }

        public Builder drawerCode(String drawerCode) {
            instance.setDrawerCode(drawerCode);
            return this;
        }

        public Builder drwrCollectionAreaName(String drwrCollectionAreaName) {
            instance.setDrwrCollectionAreaName(drwrCollectionAreaName);
            return this;
        }

        public Builder drwrFullName(String drwrFullName) {
            instance.setDrwrFullName(drwrFullName);
            return this;
        }

        public Builder drwrLocationCode(String drwrLocationCode) {
            instance.setDrwrLocationCode(drwrLocationCode);
            return this;
        }

        public Builder drwrAddressLine(String drwrAddressLine) {
            instance.setDrwrAddressLine(drwrAddressLine);
            return this;
        }

        public Builder drwrBsnsAreaCode(String drwrBsnsAreaCode) {
            instance.setDrwrBsnsAreaCode(drwrBsnsAreaCode);
            return this;
        }

        public Builder drwrBsnsAreaName(String drwrBsnsAreaName) {
            instance.setDrwrBsnsAreaName(drwrBsnsAreaName);
            return this;
        }

        public Builder drwrBankName(String drwrBankName) {
            instance.setDrwrBankName(drwrBankName);
            return this;
        }

        public Builder drweMicrCode(String drweMicrCode) {
            instance.setDrweMicrCode(drweMicrCode);
            return this;
        }

        public Builder drweBankIfcCode(String drweBankIfcCode) {
            instance.setDrweBankIfcCode(drweBankIfcCode);
            return this;
        }

        public Builder accType(String accType) {
            instance.setAccType(accType);
            return this;
        }

        public Builder drweFullName(String drweFullName) {
            instance.setDrweFullName(drweFullName);
            return this;
        }

        public Builder drweAddrLine1(String drweAddrLine1) {
            instance.setDrweAddrLine1(drweAddrLine1);
            return this;
        }

        public Builder drweAddrLine2(String drweAddrLine2) {
            instance.setDrweAddrLine2(drweAddrLine2);
            return this;
        }

        public Builder drweAddrLine3(String drweAddrLine3) {
            instance.setDrweAddrLine3(drweAddrLine3);
            return this;
        }

        public Builder drweAddrLine4(String drweAddrLine4) {
            instance.setDrweAddrLine4(drweAddrLine4);
            return this;
        }

        public Builder drweAddrLine5(String drweAddrLine5) {
            instance.setDrweAddrLine5(drweAddrLine5);
            return this;
        }

        public Builder drweLocationCode(String drweLocationCode) {
            instance.setDrweLocationCode(drweLocationCode);
            return this;
        }

        public Builder drweBsnsAreaCode(String drweBsnsAreaCode) {
            instance.setDrweBsnsAreaCode(drweBsnsAreaCode);
            return this;
        }

        public Builder ddPayableLocation(String ddPayableLocation) {
            instance.setDdPayableLocation(ddPayableLocation);
            return this;
        }

        public Builder countOfAnnxrRec(String countOfAnnxrRec) {
            instance.setCountOfAnnxrRec(countOfAnnxrRec);
            return this;
        }

        public Builder custSpecialsRefNo(String custSpecialsRefNo) {
            instance.setCustSpecialsRefNo(custSpecialsRefNo);
            return this;
        }

        public Builder drwrCollectionAreaCode(String drwrCollectionAreaCode) {
            instance.setDrwrCollectionAreaCode(drwrCollectionAreaCode);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder lineNo(Long lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public Builder drwrAccNoOtherBank(String drwrAccNoOtherBank) {
            instance.setDrwrAccNoOtherBank(drwrAccNoOtherBank);
            return this;
        }

        public Builder drweBmsAcNo(String drweBmsAcNo) {
            instance.setDrweBmsAcNo(drweBmsAcNo);
            return this;
        }

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            instance.setLayoutTemplateID(layoutTemplateID);
            return this;
        }

        public Builder layoutName(String layoutName) {
            instance.setLayoutName(layoutName);
            return this;
        }

        public Builder beneZipcode(java.math.BigDecimal beneZipcode) {
            instance.setBeneZipcode(beneZipcode);
            return this;
        }

        public Builder boeAmount(java.math.BigDecimal boeAmount) {
            instance.setBoeAmount(boeAmount);
            return this;
        }

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder drAcNo(String drAcNo) {
            instance.setDrAcNo(drAcNo);
            return this;
        }

        public Builder beneMobile(String beneMobile) {
            instance.setBeneMobile(beneMobile);
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            instance.setBeneAccNo(beneAccNo);
            return this;
        }

        public Builder clientCodeDynamic(String clientCodeDynamic) {
            instance.setClientCodeDynamic(clientCodeDynamic);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder equivalentAmount(java.math.BigDecimal equivalentAmount) {
            instance.setEquivalentAmount(equivalentAmount);
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            instance.setEquivalentCurrency(equivalentCurrency);
            return this;
        }

        public Builder displayAmount(java.math.BigDecimal displayAmount) {
            instance.setDisplayAmount(displayAmount);
            return this;
        }

        public Builder displayCurrency(String displayCurrency) {
            instance.setDisplayCurrency(displayCurrency);
            return this;
        }

        public Builder authEquivalentAmount(java.math.BigDecimal authEquivalentAmount) {
            instance.setAuthEquivalentAmount(authEquivalentAmount);
            return this;
        }

        public Builder authEquivalentCurrency(String authEquivalentCurrency) {
            instance.setAuthEquivalentCurrency(authEquivalentCurrency);
            return this;
        }

        public Builder displayEquivalentAmount(java.math.BigDecimal displayEquivalentAmount) {
            instance.setDisplayEquivalentAmount(displayEquivalentAmount);
            return this;
        }

        public Builder displayEquivalentCurrency(String displayEquivalentCurrency) {
            instance.setDisplayEquivalentCurrency(displayEquivalentCurrency);
            return this;
        }

        public Builder authFxBaseRate(java.math.BigDecimal authFxBaseRate) {
            instance.setAuthFxBaseRate(authFxBaseRate);
            return this;
        }

        public Builder displayFxBaseRate(java.math.BigDecimal displayFxBaseRate) {
            instance.setDisplayFxBaseRate(displayFxBaseRate);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
            return this;
        }

        public Builder batchStatus(String batchStatus) {
            instance.setBatchStatus(batchStatus);
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            instance.setBatchRefID(batchRefID);
            return this;
        }

        public Builder batchRemarks(String batchRemarks) {
            instance.setBatchRemarks(batchRemarks);
            return this;
        }

        public Builder tiStatus(String tiStatus) {
            instance.setTiStatus(tiStatus);
            return this;
        }

        public Builder tiBatchRefID(Integer tiBatchRefID) {
            instance.setTiBatchRefID(tiBatchRefID);
            return this;
        }

        public Builder tiRemarks(String tiRemarks) {
            instance.setTiRemarks(tiRemarks);
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            instance.setTnxDisplayStatus(tnxDisplayStatus);
            return this;
        }

        public Builder tnxDisplayBatchID(Integer tnxDisplayBatchID) {
            instance.setTnxDisplayBatchID(tnxDisplayBatchID);
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            instance.setTnxDisplayRemarks(tnxDisplayRemarks);
            return this;
        }

        public Builder advanceInterest(java.math.BigDecimal advanceInterest) {
            instance.setAdvanceInterest(advanceInterest);
            return this;
        }

        public Builder netPayment(java.math.BigDecimal netPayment) {
            instance.setNetPayment(netPayment);
            return this;
        }

        public Builder valueDate(String valueDate) {
            instance.setValueDate(valueDate);
            return this;
        }

        public Builder utrNumber(String utrNumber) {
            instance.setUtrNumber(utrNumber);
            return this;
        }

        public Builder charges(java.math.BigDecimal charges) {
            instance.setCharges(charges);
            return this;
        }

        public Builder checkBox(String checkBox) {
            instance.setCheckBox(checkBox);
            return this;
        }

        public Builder companyCode(String companyCode) {
            instance.setCompanyCode(companyCode);
            return this;
        }

        public Builder companyName(String companyName) {
            instance.setCompanyName(companyName);
            return this;
        }

        public Builder fiscalYear(java.math.BigDecimal fiscalYear) {
            instance.setFiscalYear(fiscalYear);
            return this;
        }

        public Builder customerCode(String customerCode) {
            instance.setCustomerCode(customerCode);
            return this;
        }

        public Builder customerName(String customerName) {
            instance.setCustomerName(customerName);
            return this;
        }

        public Builder gstInvNo(String gstInvNo) {
            instance.setGstInvNo(gstInvNo);
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            instance.setInvoiceNumber(invoiceNumber);
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            instance.setInvoiceDate(invoiceDate);
            return this;
        }

        public Builder invAmount(java.math.BigDecimal invAmount) {
            instance.setInvAmount(invAmount);
            return this;
        }

        public Builder grnNo(String grnNo) {
            instance.setGrnNo(grnNo);
            return this;
        }

        public Builder grnDate(java.time.LocalDateTime grnDate) {
            instance.setGrnDate(grnDate);
            return this;
        }

        public Builder paymentTerm(String paymentTerm) {
            instance.setPaymentTerm(paymentTerm);
            return this;
        }

        public Builder dueDate(java.time.LocalDateTime dueDate) {
            instance.setDueDate(dueDate);
            return this;
        }

        public Builder typeOfTransaction(String typeOfTransaction) {
            instance.setTypeOfTransaction(typeOfTransaction);
            return this;
        }

        public Builder financeParty(String financeParty) {
            instance.setFinanceParty(financeParty);
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            instance.setLoanRequestType(loanRequestType);
            return this;
        }

        public Builder customMaturityDate(java.time.LocalDateTime customMaturityDate) {
            instance.setCustomMaturityDate(customMaturityDate);
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            instance.setLayoutUuid(layoutUuid);
            return this;
        }

        public Builder financeRequestStatus(String financeRequestStatus) {
            instance.setFinanceRequestStatus(financeRequestStatus);
            return this;
        }

        public Builder financeRequested(String financeRequested) {
            instance.setFinanceRequested(financeRequested);
            return this;
        }

        public FgBatchDetail build() {
            return instance;
        }
    }
}
