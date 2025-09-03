package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgOrmFu {

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

    private String remittanceType;

    private String purposeCode;

    private String purposeOfRem;

    private String regularatoryReport;

    private String capitalGoods;

    private String transportDocNo;

    private String countryProviding;

    private String transferRef;

    private String customerRef;

    private String entity;

    private String beneCountry;

    private String beneAcct;

    private String chargeInstruction;

    private java.time.LocalDateTime executionDate;

    private String paymentInstruction;

    private String issuingBank;

    private String issuersRef;

    private String interBankSwift;

    private String interBankName;

    private String interBankAddr1;

    private String interBankAddr2;

    private String interBankAddr3;

    private String chargeAcct;

    private String attachments;

    private String portDischarge;

    private String duplicateCheck;

    private String others;

    private java.math.BigDecimal debitAcctno;

    private String trasactionCcy;

    private java.math.BigDecimal trasactionAmt;

    private String supplierName;

    private String supplierAcctno;

    private String supplierAddr1;

    private String supplierAddr2;

    private String supplierAddr3;

    private String notifyParties;

    private String originOfGoods;

    private String thirdPartyName;

    private String thirdPartyAddr1;

    private String thirdPartyAddr2;

    private String thirdPartyAddr3;

    private String consignorName;

    private String consignorAddr1;

    private String consignorAddr2;

    private String consignorAddr3;

    private String consigneeName;

    private String consigneeAddr1;

    private String consigneeAddr2;

    private String consigneeAddr3;

    private String boeDate;

    private String supplierBankSwift;

    private String fxDealRef;

    private String goodsDesc;

    private String purposeOfPayment;

    private String gstin;

    private java.math.BigDecimal chargeAcctno;

    private String supplierInstruction;

    private Integer uploadRefID;

    private String displayStatus;

    private String boeNumber;

    private String fccStatus;

    private String fccStage;

    private String fccComments;

    private String beneCurrency;

    private String issuingBankName;

    private String txnStatus;

    private String txnReference;

    private String fileName;

    private String APIErrorDesc;

    private String lineNo;

    private String applicantPartyCode;

    private String issuingPartyCode;

    private java.math.BigDecimal rateDetails;

    private String dealType;

    private String beneBanSwift;

    private String bankAbbvName;

    public FgOrmFu() {
    }

    public FgOrmFu(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String remittanceType, String purposeCode, String purposeOfRem, String regularatoryReport, String capitalGoods, String transportDocNo, String countryProviding, String transferRef, String customerRef, String entity, String beneCountry, String beneAcct, String chargeInstruction, java.time.LocalDateTime executionDate, String paymentInstruction, String issuingBank, String issuersRef, String interBankSwift, String interBankName, String interBankAddr1, String interBankAddr2, String interBankAddr3, String chargeAcct, String attachments, String portDischarge, String duplicateCheck, String others, java.math.BigDecimal debitAcctno, String trasactionCcy, java.math.BigDecimal trasactionAmt, String supplierName, String supplierAcctno, String supplierAddr1, String supplierAddr2, String supplierAddr3, String notifyParties, String originOfGoods, String thirdPartyName, String thirdPartyAddr1, String thirdPartyAddr2, String thirdPartyAddr3, String consignorName, String consignorAddr1, String consignorAddr2, String consignorAddr3, String consigneeName, String consigneeAddr1, String consigneeAddr2, String consigneeAddr3, String boeDate, String supplierBankSwift, String fxDealRef, String goodsDesc, String purposeOfPayment, String gstin, java.math.BigDecimal chargeAcctno, String supplierInstruction, Integer uploadRefID, String displayStatus, String boeNumber, String fccStatus, String fccStage, String fccComments, String beneCurrency, String issuingBankName, String txnStatus, String txnReference, String fileName, String APIErrorDesc, String lineNo, String applicantPartyCode, String issuingPartyCode, java.math.BigDecimal rateDetails, String dealType, String beneBanSwift, String bankAbbvName) {
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
        this.remittanceType = remittanceType;
        this.purposeCode = purposeCode;
        this.purposeOfRem = purposeOfRem;
        this.regularatoryReport = regularatoryReport;
        this.capitalGoods = capitalGoods;
        this.transportDocNo = transportDocNo;
        this.countryProviding = countryProviding;
        this.transferRef = transferRef;
        this.customerRef = customerRef;
        this.entity = entity;
        this.beneCountry = beneCountry;
        this.beneAcct = beneAcct;
        this.chargeInstruction = chargeInstruction;
        this.executionDate = executionDate;
        this.paymentInstruction = paymentInstruction;
        this.issuingBank = issuingBank;
        this.issuersRef = issuersRef;
        this.interBankSwift = interBankSwift;
        this.interBankName = interBankName;
        this.interBankAddr1 = interBankAddr1;
        this.interBankAddr2 = interBankAddr2;
        this.interBankAddr3 = interBankAddr3;
        this.chargeAcct = chargeAcct;
        this.attachments = attachments;
        this.portDischarge = portDischarge;
        this.duplicateCheck = duplicateCheck;
        this.others = others;
        this.debitAcctno = debitAcctno;
        this.trasactionCcy = trasactionCcy;
        this.trasactionAmt = trasactionAmt;
        this.supplierName = supplierName;
        this.supplierAcctno = supplierAcctno;
        this.supplierAddr1 = supplierAddr1;
        this.supplierAddr2 = supplierAddr2;
        this.supplierAddr3 = supplierAddr3;
        this.notifyParties = notifyParties;
        this.originOfGoods = originOfGoods;
        this.thirdPartyName = thirdPartyName;
        this.thirdPartyAddr1 = thirdPartyAddr1;
        this.thirdPartyAddr2 = thirdPartyAddr2;
        this.thirdPartyAddr3 = thirdPartyAddr3;
        this.consignorName = consignorName;
        this.consignorAddr1 = consignorAddr1;
        this.consignorAddr2 = consignorAddr2;
        this.consignorAddr3 = consignorAddr3;
        this.consigneeName = consigneeName;
        this.consigneeAddr1 = consigneeAddr1;
        this.consigneeAddr2 = consigneeAddr2;
        this.consigneeAddr3 = consigneeAddr3;
        this.boeDate = boeDate;
        this.supplierBankSwift = supplierBankSwift;
        this.fxDealRef = fxDealRef;
        this.goodsDesc = goodsDesc;
        this.purposeOfPayment = purposeOfPayment;
        this.gstin = gstin;
        this.chargeAcctno = chargeAcctno;
        this.supplierInstruction = supplierInstruction;
        this.uploadRefID = uploadRefID;
        this.displayStatus = displayStatus;
        this.boeNumber = boeNumber;
        this.fccStatus = fccStatus;
        this.fccStage = fccStage;
        this.fccComments = fccComments;
        this.beneCurrency = beneCurrency;
        this.issuingBankName = issuingBankName;
        this.txnStatus = txnStatus;
        this.txnReference = txnReference;
        this.fileName = fileName;
        this.APIErrorDesc = APIErrorDesc;
        this.lineNo = lineNo;
        this.applicantPartyCode = applicantPartyCode;
        this.issuingPartyCode = issuingPartyCode;
        this.rateDetails = rateDetails;
        this.dealType = dealType;
        this.beneBanSwift = beneBanSwift;
        this.bankAbbvName = bankAbbvName;
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

    public String getRemittanceType() {
        return remittanceType;
    }

    public void setRemittanceType(String remittanceType) {
        this.remittanceType = remittanceType;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getPurposeOfRem() {
        return purposeOfRem;
    }

    public void setPurposeOfRem(String purposeOfRem) {
        this.purposeOfRem = purposeOfRem;
    }

    public String getRegularatoryReport() {
        return regularatoryReport;
    }

    public void setRegularatoryReport(String regularatoryReport) {
        this.regularatoryReport = regularatoryReport;
    }

    public String getCapitalGoods() {
        return capitalGoods;
    }

    public void setCapitalGoods(String capitalGoods) {
        this.capitalGoods = capitalGoods;
    }

    public String getTransportDocNo() {
        return transportDocNo;
    }

    public void setTransportDocNo(String transportDocNo) {
        this.transportDocNo = transportDocNo;
    }

    public String getCountryProviding() {
        return countryProviding;
    }

    public void setCountryProviding(String countryProviding) {
        this.countryProviding = countryProviding;
    }

    public String getTransferRef() {
        return transferRef;
    }

    public void setTransferRef(String transferRef) {
        this.transferRef = transferRef;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getBeneCountry() {
        return beneCountry;
    }

    public void setBeneCountry(String beneCountry) {
        this.beneCountry = beneCountry;
    }

    public String getBeneAcct() {
        return beneAcct;
    }

    public void setBeneAcct(String beneAcct) {
        this.beneAcct = beneAcct;
    }

    public String getChargeInstruction() {
        return chargeInstruction;
    }

    public void setChargeInstruction(String chargeInstruction) {
        this.chargeInstruction = chargeInstruction;
    }

    public java.time.LocalDateTime getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(java.time.LocalDateTime executionDate) {
        this.executionDate = executionDate;
    }

    public String getPaymentInstruction() {
        return paymentInstruction;
    }

    public void setPaymentInstruction(String paymentInstruction) {
        this.paymentInstruction = paymentInstruction;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getIssuersRef() {
        return issuersRef;
    }

    public void setIssuersRef(String issuersRef) {
        this.issuersRef = issuersRef;
    }

    public String getInterBankSwift() {
        return interBankSwift;
    }

    public void setInterBankSwift(String interBankSwift) {
        this.interBankSwift = interBankSwift;
    }

    public String getInterBankName() {
        return interBankName;
    }

    public void setInterBankName(String interBankName) {
        this.interBankName = interBankName;
    }

    public String getInterBankAddr1() {
        return interBankAddr1;
    }

    public void setInterBankAddr1(String interBankAddr1) {
        this.interBankAddr1 = interBankAddr1;
    }

    public String getInterBankAddr2() {
        return interBankAddr2;
    }

    public void setInterBankAddr2(String interBankAddr2) {
        this.interBankAddr2 = interBankAddr2;
    }

    public String getInterBankAddr3() {
        return interBankAddr3;
    }

    public void setInterBankAddr3(String interBankAddr3) {
        this.interBankAddr3 = interBankAddr3;
    }

    public String getChargeAcct() {
        return chargeAcct;
    }

    public void setChargeAcct(String chargeAcct) {
        this.chargeAcct = chargeAcct;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getPortDischarge() {
        return portDischarge;
    }

    public void setPortDischarge(String portDischarge) {
        this.portDischarge = portDischarge;
    }

    public String getDuplicateCheck() {
        return duplicateCheck;
    }

    public void setDuplicateCheck(String duplicateCheck) {
        this.duplicateCheck = duplicateCheck;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public java.math.BigDecimal getDebitAcctno() {
        return debitAcctno;
    }

    public void setDebitAcctno(java.math.BigDecimal debitAcctno) {
        this.debitAcctno = debitAcctno;
    }

    public String getTrasactionCcy() {
        return trasactionCcy;
    }

    public void setTrasactionCcy(String trasactionCcy) {
        this.trasactionCcy = trasactionCcy;
    }

    public java.math.BigDecimal getTrasactionAmt() {
        return trasactionAmt;
    }

    public void setTrasactionAmt(java.math.BigDecimal trasactionAmt) {
        this.trasactionAmt = trasactionAmt;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAcctno() {
        return supplierAcctno;
    }

    public void setSupplierAcctno(String supplierAcctno) {
        this.supplierAcctno = supplierAcctno;
    }

    public String getSupplierAddr1() {
        return supplierAddr1;
    }

    public void setSupplierAddr1(String supplierAddr1) {
        this.supplierAddr1 = supplierAddr1;
    }

    public String getSupplierAddr2() {
        return supplierAddr2;
    }

    public void setSupplierAddr2(String supplierAddr2) {
        this.supplierAddr2 = supplierAddr2;
    }

    public String getSupplierAddr3() {
        return supplierAddr3;
    }

    public void setSupplierAddr3(String supplierAddr3) {
        this.supplierAddr3 = supplierAddr3;
    }

    public String getNotifyParties() {
        return notifyParties;
    }

    public void setNotifyParties(String notifyParties) {
        this.notifyParties = notifyParties;
    }

    public String getOriginOfGoods() {
        return originOfGoods;
    }

    public void setOriginOfGoods(String originOfGoods) {
        this.originOfGoods = originOfGoods;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getThirdPartyAddr1() {
        return thirdPartyAddr1;
    }

    public void setThirdPartyAddr1(String thirdPartyAddr1) {
        this.thirdPartyAddr1 = thirdPartyAddr1;
    }

    public String getThirdPartyAddr2() {
        return thirdPartyAddr2;
    }

    public void setThirdPartyAddr2(String thirdPartyAddr2) {
        this.thirdPartyAddr2 = thirdPartyAddr2;
    }

    public String getThirdPartyAddr3() {
        return thirdPartyAddr3;
    }

    public void setThirdPartyAddr3(String thirdPartyAddr3) {
        this.thirdPartyAddr3 = thirdPartyAddr3;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    public String getConsignorAddr1() {
        return consignorAddr1;
    }

    public void setConsignorAddr1(String consignorAddr1) {
        this.consignorAddr1 = consignorAddr1;
    }

    public String getConsignorAddr2() {
        return consignorAddr2;
    }

    public void setConsignorAddr2(String consignorAddr2) {
        this.consignorAddr2 = consignorAddr2;
    }

    public String getConsignorAddr3() {
        return consignorAddr3;
    }

    public void setConsignorAddr3(String consignorAddr3) {
        this.consignorAddr3 = consignorAddr3;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddr1() {
        return consigneeAddr1;
    }

    public void setConsigneeAddr1(String consigneeAddr1) {
        this.consigneeAddr1 = consigneeAddr1;
    }

    public String getConsigneeAddr2() {
        return consigneeAddr2;
    }

    public void setConsigneeAddr2(String consigneeAddr2) {
        this.consigneeAddr2 = consigneeAddr2;
    }

    public String getConsigneeAddr3() {
        return consigneeAddr3;
    }

    public void setConsigneeAddr3(String consigneeAddr3) {
        this.consigneeAddr3 = consigneeAddr3;
    }

    public String getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(String boeDate) {
        this.boeDate = boeDate;
    }

    public String getSupplierBankSwift() {
        return supplierBankSwift;
    }

    public void setSupplierBankSwift(String supplierBankSwift) {
        this.supplierBankSwift = supplierBankSwift;
    }

    public String getFxDealRef() {
        return fxDealRef;
    }

    public void setFxDealRef(String fxDealRef) {
        this.fxDealRef = fxDealRef;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public java.math.BigDecimal getChargeAcctno() {
        return chargeAcctno;
    }

    public void setChargeAcctno(java.math.BigDecimal chargeAcctno) {
        this.chargeAcctno = chargeAcctno;
    }

    public String getSupplierInstruction() {
        return supplierInstruction;
    }

    public void setSupplierInstruction(String supplierInstruction) {
        this.supplierInstruction = supplierInstruction;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(String boeNumber) {
        this.boeNumber = boeNumber;
    }

    public String getFccStatus() {
        return fccStatus;
    }

    public void setFccStatus(String fccStatus) {
        this.fccStatus = fccStatus;
    }

    public String getFccStage() {
        return fccStage;
    }

    public void setFccStage(String fccStage) {
        this.fccStage = fccStage;
    }

    public String getFccComments() {
        return fccComments;
    }

    public void setFccComments(String fccComments) {
        this.fccComments = fccComments;
    }

    public String getBeneCurrency() {
        return beneCurrency;
    }

    public void setBeneCurrency(String beneCurrency) {
        this.beneCurrency = beneCurrency;
    }

    public String getIssuingBankName() {
        return issuingBankName;
    }

    public void setIssuingBankName(String issuingBankName) {
        this.issuingBankName = issuingBankName;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getTxnReference() {
        return txnReference;
    }

    public void setTxnReference(String txnReference) {
        this.txnReference = txnReference;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAPIErrorDesc() {
        return APIErrorDesc;
    }

    public void setAPIErrorDesc(String APIErrorDesc) {
        this.APIErrorDesc = APIErrorDesc;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
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

    public java.math.BigDecimal getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(java.math.BigDecimal rateDetails) {
        this.rateDetails = rateDetails;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getBeneBanSwift() {
        return beneBanSwift;
    }

    public void setBeneBanSwift(String beneBanSwift) {
        this.beneBanSwift = beneBanSwift;
    }

    public String getBankAbbvName() {
        return bankAbbvName;
    }

    public void setBankAbbvName(String bankAbbvName) {
        this.bankAbbvName = bankAbbvName;
    }

    public static class Builder {

        private FgOrmFu instance = new FgOrmFu();

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

        public Builder remittanceType(String remittanceType) {
            instance.setRemittanceType(remittanceType);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder purposeOfRem(String purposeOfRem) {
            instance.setPurposeOfRem(purposeOfRem);
            return this;
        }

        public Builder regularatoryReport(String regularatoryReport) {
            instance.setRegularatoryReport(regularatoryReport);
            return this;
        }

        public Builder capitalGoods(String capitalGoods) {
            instance.setCapitalGoods(capitalGoods);
            return this;
        }

        public Builder transportDocNo(String transportDocNo) {
            instance.setTransportDocNo(transportDocNo);
            return this;
        }

        public Builder countryProviding(String countryProviding) {
            instance.setCountryProviding(countryProviding);
            return this;
        }

        public Builder transferRef(String transferRef) {
            instance.setTransferRef(transferRef);
            return this;
        }

        public Builder customerRef(String customerRef) {
            instance.setCustomerRef(customerRef);
            return this;
        }

        public Builder entity(String entity) {
            instance.setEntity(entity);
            return this;
        }

        public Builder beneCountry(String beneCountry) {
            instance.setBeneCountry(beneCountry);
            return this;
        }

        public Builder beneAcct(String beneAcct) {
            instance.setBeneAcct(beneAcct);
            return this;
        }

        public Builder chargeInstruction(String chargeInstruction) {
            instance.setChargeInstruction(chargeInstruction);
            return this;
        }

        public Builder executionDate(java.time.LocalDateTime executionDate) {
            instance.setExecutionDate(executionDate);
            return this;
        }

        public Builder paymentInstruction(String paymentInstruction) {
            instance.setPaymentInstruction(paymentInstruction);
            return this;
        }

        public Builder issuingBank(String issuingBank) {
            instance.setIssuingBank(issuingBank);
            return this;
        }

        public Builder issuersRef(String issuersRef) {
            instance.setIssuersRef(issuersRef);
            return this;
        }

        public Builder interBankSwift(String interBankSwift) {
            instance.setInterBankSwift(interBankSwift);
            return this;
        }

        public Builder interBankName(String interBankName) {
            instance.setInterBankName(interBankName);
            return this;
        }

        public Builder interBankAddr1(String interBankAddr1) {
            instance.setInterBankAddr1(interBankAddr1);
            return this;
        }

        public Builder interBankAddr2(String interBankAddr2) {
            instance.setInterBankAddr2(interBankAddr2);
            return this;
        }

        public Builder interBankAddr3(String interBankAddr3) {
            instance.setInterBankAddr3(interBankAddr3);
            return this;
        }

        public Builder chargeAcct(String chargeAcct) {
            instance.setChargeAcct(chargeAcct);
            return this;
        }

        public Builder attachments(String attachments) {
            instance.setAttachments(attachments);
            return this;
        }

        public Builder portDischarge(String portDischarge) {
            instance.setPortDischarge(portDischarge);
            return this;
        }

        public Builder duplicateCheck(String duplicateCheck) {
            instance.setDuplicateCheck(duplicateCheck);
            return this;
        }

        public Builder others(String others) {
            instance.setOthers(others);
            return this;
        }

        public Builder debitAcctno(java.math.BigDecimal debitAcctno) {
            instance.setDebitAcctno(debitAcctno);
            return this;
        }

        public Builder trasactionCcy(String trasactionCcy) {
            instance.setTrasactionCcy(trasactionCcy);
            return this;
        }

        public Builder trasactionAmt(java.math.BigDecimal trasactionAmt) {
            instance.setTrasactionAmt(trasactionAmt);
            return this;
        }

        public Builder supplierName(String supplierName) {
            instance.setSupplierName(supplierName);
            return this;
        }

        public Builder supplierAcctno(String supplierAcctno) {
            instance.setSupplierAcctno(supplierAcctno);
            return this;
        }

        public Builder supplierAddr1(String supplierAddr1) {
            instance.setSupplierAddr1(supplierAddr1);
            return this;
        }

        public Builder supplierAddr2(String supplierAddr2) {
            instance.setSupplierAddr2(supplierAddr2);
            return this;
        }

        public Builder supplierAddr3(String supplierAddr3) {
            instance.setSupplierAddr3(supplierAddr3);
            return this;
        }

        public Builder notifyParties(String notifyParties) {
            instance.setNotifyParties(notifyParties);
            return this;
        }

        public Builder originOfGoods(String originOfGoods) {
            instance.setOriginOfGoods(originOfGoods);
            return this;
        }

        public Builder thirdPartyName(String thirdPartyName) {
            instance.setThirdPartyName(thirdPartyName);
            return this;
        }

        public Builder thirdPartyAddr1(String thirdPartyAddr1) {
            instance.setThirdPartyAddr1(thirdPartyAddr1);
            return this;
        }

        public Builder thirdPartyAddr2(String thirdPartyAddr2) {
            instance.setThirdPartyAddr2(thirdPartyAddr2);
            return this;
        }

        public Builder thirdPartyAddr3(String thirdPartyAddr3) {
            instance.setThirdPartyAddr3(thirdPartyAddr3);
            return this;
        }

        public Builder consignorName(String consignorName) {
            instance.setConsignorName(consignorName);
            return this;
        }

        public Builder consignorAddr1(String consignorAddr1) {
            instance.setConsignorAddr1(consignorAddr1);
            return this;
        }

        public Builder consignorAddr2(String consignorAddr2) {
            instance.setConsignorAddr2(consignorAddr2);
            return this;
        }

        public Builder consignorAddr3(String consignorAddr3) {
            instance.setConsignorAddr3(consignorAddr3);
            return this;
        }

        public Builder consigneeName(String consigneeName) {
            instance.setConsigneeName(consigneeName);
            return this;
        }

        public Builder consigneeAddr1(String consigneeAddr1) {
            instance.setConsigneeAddr1(consigneeAddr1);
            return this;
        }

        public Builder consigneeAddr2(String consigneeAddr2) {
            instance.setConsigneeAddr2(consigneeAddr2);
            return this;
        }

        public Builder consigneeAddr3(String consigneeAddr3) {
            instance.setConsigneeAddr3(consigneeAddr3);
            return this;
        }

        public Builder boeDate(String boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder supplierBankSwift(String supplierBankSwift) {
            instance.setSupplierBankSwift(supplierBankSwift);
            return this;
        }

        public Builder fxDealRef(String fxDealRef) {
            instance.setFxDealRef(fxDealRef);
            return this;
        }

        public Builder goodsDesc(String goodsDesc) {
            instance.setGoodsDesc(goodsDesc);
            return this;
        }

        public Builder purposeOfPayment(String purposeOfPayment) {
            instance.setPurposeOfPayment(purposeOfPayment);
            return this;
        }

        public Builder gstin(String gstin) {
            instance.setGstin(gstin);
            return this;
        }

        public Builder chargeAcctno(java.math.BigDecimal chargeAcctno) {
            instance.setChargeAcctno(chargeAcctno);
            return this;
        }

        public Builder supplierInstruction(String supplierInstruction) {
            instance.setSupplierInstruction(supplierInstruction);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            instance.setDisplayStatus(displayStatus);
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder fccStatus(String fccStatus) {
            instance.setFccStatus(fccStatus);
            return this;
        }

        public Builder fccStage(String fccStage) {
            instance.setFccStage(fccStage);
            return this;
        }

        public Builder fccComments(String fccComments) {
            instance.setFccComments(fccComments);
            return this;
        }

        public Builder beneCurrency(String beneCurrency) {
            instance.setBeneCurrency(beneCurrency);
            return this;
        }

        public Builder issuingBankName(String issuingBankName) {
            instance.setIssuingBankName(issuingBankName);
            return this;
        }

        public Builder txnStatus(String txnStatus) {
            instance.setTxnStatus(txnStatus);
            return this;
        }

        public Builder txnReference(String txnReference) {
            instance.setTxnReference(txnReference);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder APIErrorDesc(String APIErrorDesc) {
            instance.setAPIErrorDesc(APIErrorDesc);
            return this;
        }

        public Builder lineNo(String lineNo) {
            instance.setLineNo(lineNo);
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

        public Builder rateDetails(java.math.BigDecimal rateDetails) {
            instance.setRateDetails(rateDetails);
            return this;
        }

        public Builder dealType(String dealType) {
            instance.setDealType(dealType);
            return this;
        }

        public Builder beneBanSwift(String beneBanSwift) {
            instance.setBeneBanSwift(beneBanSwift);
            return this;
        }

        public Builder bankAbbvName(String bankAbbvName) {
            instance.setBankAbbvName(bankAbbvName);
            return this;
        }

        public FgOrmFu build() {
            return instance;
        }
    }
}
