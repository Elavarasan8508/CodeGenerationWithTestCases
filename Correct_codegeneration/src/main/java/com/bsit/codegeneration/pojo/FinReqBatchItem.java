package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinReqBatchItem {

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

    private String batchRefNum;

    private Integer uploadRefID;

    private Integer instrumentID;

    private java.time.LocalDateTime loanDueDate;

    private java.math.BigDecimal requestAmount;

    private java.math.BigDecimal invoiceAmount;

    private String fileContent;

    private String customerCrn;

    private Integer tnxRefID;

    private java.math.BigDecimal financeAmount;

    private java.math.BigDecimal financingAmount;

    private Long tenorInDays;

    private Long intPeriodInDays;

    private Long contractPeriod;

    private Integer parentRefID;

    private String invNo;

    private java.time.LocalDateTime invDate;

    private java.math.BigDecimal invAmt;

    private java.time.LocalDateTime maturityDate;

    private Integer removeBatchItem;

    private String txnTypeCode;

    private String txnSubTypeCode;

    private Integer parentVersionID;

    private Integer layoutID;

    private String cpCode;

    private String fileName;

    private String tnxDisplayRemarks;

    private Integer tnxDisplayBatchID;

    private String tnxDisplayStatus;

    private String paymentMode;

    private java.math.BigDecimal interestRate;

    private String anchorName;

    private String counterPartyCrn;

    private String counterPartyName;

    private String inputBranch;

    private String behalfOfBranch;

    private String debitPartyCrn;

    private String creditPartyCrn;

    private String creditPartyName;

    private java.math.BigDecimal spreadRate;

    private java.math.BigDecimal marginRate;

    private java.math.BigDecimal penaltyPercent;

    private String interestType;

    private java.math.BigDecimal rateType;

    private String baseCode;

    private String productType;

    private Long gracePeriod;

    private String limitNode1;

    private String limitNode2;

    private String beneBranch;

    private String beneAccNo;

    private String sellerIDCrn;

    private String buyerIDCrn;

    private String cpRole;

    private String beneLei;

    private java.math.BigDecimal advanceInterest;

    private java.math.BigDecimal netPayment;

    private String valueDate;

    private String utrNumber;

    private java.math.BigDecimal charges;

    private java.time.LocalDateTime utrDate;

    public FinReqBatchItem() {
    }

    public FinReqBatchItem(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String batchRefNum, Integer uploadRefID, Integer instrumentID, java.time.LocalDateTime loanDueDate, java.math.BigDecimal requestAmount, java.math.BigDecimal invoiceAmount, String fileContent, String customerCrn, Integer tnxRefID, java.math.BigDecimal financeAmount, java.math.BigDecimal financingAmount, Long tenorInDays, Long intPeriodInDays, Long contractPeriod, Integer parentRefID, String invNo, java.time.LocalDateTime invDate, java.math.BigDecimal invAmt, java.time.LocalDateTime maturityDate, Integer removeBatchItem, String txnTypeCode, String txnSubTypeCode, Integer parentVersionID, Integer layoutID, String cpCode, String fileName, String tnxDisplayRemarks, Integer tnxDisplayBatchID, String tnxDisplayStatus, String paymentMode, java.math.BigDecimal interestRate, String anchorName, String counterPartyCrn, String counterPartyName, String inputBranch, String behalfOfBranch, String debitPartyCrn, String creditPartyCrn, String creditPartyName, java.math.BigDecimal spreadRate, java.math.BigDecimal marginRate, java.math.BigDecimal penaltyPercent, String interestType, java.math.BigDecimal rateType, String baseCode, String productType, Long gracePeriod, String limitNode1, String limitNode2, String beneBranch, String beneAccNo, String sellerIDCrn, String buyerIDCrn, String cpRole, String beneLei, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valueDate, String utrNumber, java.math.BigDecimal charges, java.time.LocalDateTime utrDate) {
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
        this.batchRefNum = batchRefNum;
        this.uploadRefID = uploadRefID;
        this.instrumentID = instrumentID;
        this.loanDueDate = loanDueDate;
        this.requestAmount = requestAmount;
        this.invoiceAmount = invoiceAmount;
        this.fileContent = fileContent;
        this.customerCrn = customerCrn;
        this.tnxRefID = tnxRefID;
        this.financeAmount = financeAmount;
        this.financingAmount = financingAmount;
        this.tenorInDays = tenorInDays;
        this.intPeriodInDays = intPeriodInDays;
        this.contractPeriod = contractPeriod;
        this.parentRefID = parentRefID;
        this.invNo = invNo;
        this.invDate = invDate;
        this.invAmt = invAmt;
        this.maturityDate = maturityDate;
        this.removeBatchItem = removeBatchItem;
        this.txnTypeCode = txnTypeCode;
        this.txnSubTypeCode = txnSubTypeCode;
        this.parentVersionID = parentVersionID;
        this.layoutID = layoutID;
        this.cpCode = cpCode;
        this.fileName = fileName;
        this.tnxDisplayRemarks = tnxDisplayRemarks;
        this.tnxDisplayBatchID = tnxDisplayBatchID;
        this.tnxDisplayStatus = tnxDisplayStatus;
        this.paymentMode = paymentMode;
        this.interestRate = interestRate;
        this.anchorName = anchorName;
        this.counterPartyCrn = counterPartyCrn;
        this.counterPartyName = counterPartyName;
        this.inputBranch = inputBranch;
        this.behalfOfBranch = behalfOfBranch;
        this.debitPartyCrn = debitPartyCrn;
        this.creditPartyCrn = creditPartyCrn;
        this.creditPartyName = creditPartyName;
        this.spreadRate = spreadRate;
        this.marginRate = marginRate;
        this.penaltyPercent = penaltyPercent;
        this.interestType = interestType;
        this.rateType = rateType;
        this.baseCode = baseCode;
        this.productType = productType;
        this.gracePeriod = gracePeriod;
        this.limitNode1 = limitNode1;
        this.limitNode2 = limitNode2;
        this.beneBranch = beneBranch;
        this.beneAccNo = beneAccNo;
        this.sellerIDCrn = sellerIDCrn;
        this.buyerIDCrn = buyerIDCrn;
        this.cpRole = cpRole;
        this.beneLei = beneLei;
        this.advanceInterest = advanceInterest;
        this.netPayment = netPayment;
        this.valueDate = valueDate;
        this.utrNumber = utrNumber;
        this.charges = charges;
        this.utrDate = utrDate;
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

    public String getBatchRefNum() {
        return batchRefNum;
    }

    public void setBatchRefNum(String batchRefNum) {
        this.batchRefNum = batchRefNum;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Integer getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(Integer instrumentID) {
        this.instrumentID = instrumentID;
    }

    public java.time.LocalDateTime getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(java.time.LocalDateTime loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public java.math.BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(java.math.BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
    }

    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getCustomerCrn() {
        return customerCrn;
    }

    public void setCustomerCrn(String customerCrn) {
        this.customerCrn = customerCrn;
    }

    public Integer getTnxRefID() {
        return tnxRefID;
    }

    public void setTnxRefID(Integer tnxRefID) {
        this.tnxRefID = tnxRefID;
    }

    public java.math.BigDecimal getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(java.math.BigDecimal financeAmount) {
        this.financeAmount = financeAmount;
    }

    public java.math.BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(java.math.BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public Long getTenorInDays() {
        return tenorInDays;
    }

    public void setTenorInDays(Long tenorInDays) {
        this.tenorInDays = tenorInDays;
    }

    public Long getIntPeriodInDays() {
        return intPeriodInDays;
    }

    public void setIntPeriodInDays(Long intPeriodInDays) {
        this.intPeriodInDays = intPeriodInDays;
    }

    public Long getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Long contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public java.math.BigDecimal getInvAmt() {
        return invAmt;
    }

    public void setInvAmt(java.math.BigDecimal invAmt) {
        this.invAmt = invAmt;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Integer getRemoveBatchItem() {
        return removeBatchItem;
    }

    public void setRemoveBatchItem(Integer removeBatchItem) {
        this.removeBatchItem = removeBatchItem;
    }

    public String getTxnTypeCode() {
        return txnTypeCode;
    }

    public void setTxnTypeCode(String txnTypeCode) {
        this.txnTypeCode = txnTypeCode;
    }

    public String getTxnSubTypeCode() {
        return txnSubTypeCode;
    }

    public void setTxnSubTypeCode(String txnSubTypeCode) {
        this.txnSubTypeCode = txnSubTypeCode;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public Integer getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(Integer layoutID) {
        this.layoutID = layoutID;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTnxDisplayRemarks() {
        return tnxDisplayRemarks;
    }

    public void setTnxDisplayRemarks(String tnxDisplayRemarks) {
        this.tnxDisplayRemarks = tnxDisplayRemarks;
    }

    public Integer getTnxDisplayBatchID() {
        return tnxDisplayBatchID;
    }

    public void setTnxDisplayBatchID(Integer tnxDisplayBatchID) {
        this.tnxDisplayBatchID = tnxDisplayBatchID;
    }

    public String getTnxDisplayStatus() {
        return tnxDisplayStatus;
    }

    public void setTnxDisplayStatus(String tnxDisplayStatus) {
        this.tnxDisplayStatus = tnxDisplayStatus;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public String getCounterPartyCrn() {
        return counterPartyCrn;
    }

    public void setCounterPartyCrn(String counterPartyCrn) {
        this.counterPartyCrn = counterPartyCrn;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public void setCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
    }

    public String getInputBranch() {
        return inputBranch;
    }

    public void setInputBranch(String inputBranch) {
        this.inputBranch = inputBranch;
    }

    public String getBehalfOfBranch() {
        return behalfOfBranch;
    }

    public void setBehalfOfBranch(String behalfOfBranch) {
        this.behalfOfBranch = behalfOfBranch;
    }

    public String getDebitPartyCrn() {
        return debitPartyCrn;
    }

    public void setDebitPartyCrn(String debitPartyCrn) {
        this.debitPartyCrn = debitPartyCrn;
    }

    public String getCreditPartyCrn() {
        return creditPartyCrn;
    }

    public void setCreditPartyCrn(String creditPartyCrn) {
        this.creditPartyCrn = creditPartyCrn;
    }

    public String getCreditPartyName() {
        return creditPartyName;
    }

    public void setCreditPartyName(String creditPartyName) {
        this.creditPartyName = creditPartyName;
    }

    public java.math.BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(java.math.BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public java.math.BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(java.math.BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public java.math.BigDecimal getPenaltyPercent() {
        return penaltyPercent;
    }

    public void setPenaltyPercent(java.math.BigDecimal penaltyPercent) {
        this.penaltyPercent = penaltyPercent;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public java.math.BigDecimal getRateType() {
        return rateType;
    }

    public void setRateType(java.math.BigDecimal rateType) {
        this.rateType = rateType;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Long gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public String getLimitNode1() {
        return limitNode1;
    }

    public void setLimitNode1(String limitNode1) {
        this.limitNode1 = limitNode1;
    }

    public String getLimitNode2() {
        return limitNode2;
    }

    public void setLimitNode2(String limitNode2) {
        this.limitNode2 = limitNode2;
    }

    public String getBeneBranch() {
        return beneBranch;
    }

    public void setBeneBranch(String beneBranch) {
        this.beneBranch = beneBranch;
    }

    public String getBeneAccNo() {
        return beneAccNo;
    }

    public void setBeneAccNo(String beneAccNo) {
        this.beneAccNo = beneAccNo;
    }

    public String getSellerIDCrn() {
        return sellerIDCrn;
    }

    public void setSellerIDCrn(String sellerIDCrn) {
        this.sellerIDCrn = sellerIDCrn;
    }

    public String getBuyerIDCrn() {
        return buyerIDCrn;
    }

    public void setBuyerIDCrn(String buyerIDCrn) {
        this.buyerIDCrn = buyerIDCrn;
    }

    public String getCpRole() {
        return cpRole;
    }

    public void setCpRole(String cpRole) {
        this.cpRole = cpRole;
    }

    public String getBeneLei() {
        return beneLei;
    }

    public void setBeneLei(String beneLei) {
        this.beneLei = beneLei;
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

    public java.time.LocalDateTime getUtrDate() {
        return utrDate;
    }

    public void setUtrDate(java.time.LocalDateTime utrDate) {
        this.utrDate = utrDate;
    }

    public static class Builder {

        private FinReqBatchItem instance = new FinReqBatchItem();

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

        public Builder batchRefNum(String batchRefNum) {
            instance.setBatchRefNum(batchRefNum);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder instrumentID(Integer instrumentID) {
            instance.setInstrumentID(instrumentID);
            return this;
        }

        public Builder loanDueDate(java.time.LocalDateTime loanDueDate) {
            instance.setLoanDueDate(loanDueDate);
            return this;
        }

        public Builder requestAmount(java.math.BigDecimal requestAmount) {
            instance.setRequestAmount(requestAmount);
            return this;
        }

        public Builder invoiceAmount(java.math.BigDecimal invoiceAmount) {
            instance.setInvoiceAmount(invoiceAmount);
            return this;
        }

        public Builder fileContent(String fileContent) {
            instance.setFileContent(fileContent);
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            instance.setCustomerCrn(customerCrn);
            return this;
        }

        public Builder tnxRefID(Integer tnxRefID) {
            instance.setTnxRefID(tnxRefID);
            return this;
        }

        public Builder financeAmount(java.math.BigDecimal financeAmount) {
            instance.setFinanceAmount(financeAmount);
            return this;
        }

        public Builder financingAmount(java.math.BigDecimal financingAmount) {
            instance.setFinancingAmount(financingAmount);
            return this;
        }

        public Builder tenorInDays(Long tenorInDays) {
            instance.setTenorInDays(tenorInDays);
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            instance.setIntPeriodInDays(intPeriodInDays);
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            instance.setContractPeriod(contractPeriod);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder invAmt(java.math.BigDecimal invAmt) {
            instance.setInvAmt(invAmt);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder removeBatchItem(Integer removeBatchItem) {
            instance.setRemoveBatchItem(removeBatchItem);
            return this;
        }

        public Builder txnTypeCode(String txnTypeCode) {
            instance.setTxnTypeCode(txnTypeCode);
            return this;
        }

        public Builder txnSubTypeCode(String txnSubTypeCode) {
            instance.setTxnSubTypeCode(txnSubTypeCode);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder layoutID(Integer layoutID) {
            instance.setLayoutID(layoutID);
            return this;
        }

        public Builder cpCode(String cpCode) {
            instance.setCpCode(cpCode);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            instance.setTnxDisplayRemarks(tnxDisplayRemarks);
            return this;
        }

        public Builder tnxDisplayBatchID(Integer tnxDisplayBatchID) {
            instance.setTnxDisplayBatchID(tnxDisplayBatchID);
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            instance.setTnxDisplayStatus(tnxDisplayStatus);
            return this;
        }

        public Builder paymentMode(String paymentMode) {
            instance.setPaymentMode(paymentMode);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder anchorName(String anchorName) {
            instance.setAnchorName(anchorName);
            return this;
        }

        public Builder counterPartyCrn(String counterPartyCrn) {
            instance.setCounterPartyCrn(counterPartyCrn);
            return this;
        }

        public Builder counterPartyName(String counterPartyName) {
            instance.setCounterPartyName(counterPartyName);
            return this;
        }

        public Builder inputBranch(String inputBranch) {
            instance.setInputBranch(inputBranch);
            return this;
        }

        public Builder behalfOfBranch(String behalfOfBranch) {
            instance.setBehalfOfBranch(behalfOfBranch);
            return this;
        }

        public Builder debitPartyCrn(String debitPartyCrn) {
            instance.setDebitPartyCrn(debitPartyCrn);
            return this;
        }

        public Builder creditPartyCrn(String creditPartyCrn) {
            instance.setCreditPartyCrn(creditPartyCrn);
            return this;
        }

        public Builder creditPartyName(String creditPartyName) {
            instance.setCreditPartyName(creditPartyName);
            return this;
        }

        public Builder spreadRate(java.math.BigDecimal spreadRate) {
            instance.setSpreadRate(spreadRate);
            return this;
        }

        public Builder marginRate(java.math.BigDecimal marginRate) {
            instance.setMarginRate(marginRate);
            return this;
        }

        public Builder penaltyPercent(java.math.BigDecimal penaltyPercent) {
            instance.setPenaltyPercent(penaltyPercent);
            return this;
        }

        public Builder interestType(String interestType) {
            instance.setInterestType(interestType);
            return this;
        }

        public Builder rateType(java.math.BigDecimal rateType) {
            instance.setRateType(rateType);
            return this;
        }

        public Builder baseCode(String baseCode) {
            instance.setBaseCode(baseCode);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public Builder gracePeriod(Long gracePeriod) {
            instance.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder limitNode1(String limitNode1) {
            instance.setLimitNode1(limitNode1);
            return this;
        }

        public Builder limitNode2(String limitNode2) {
            instance.setLimitNode2(limitNode2);
            return this;
        }

        public Builder beneBranch(String beneBranch) {
            instance.setBeneBranch(beneBranch);
            return this;
        }

        public Builder beneAccNo(String beneAccNo) {
            instance.setBeneAccNo(beneAccNo);
            return this;
        }

        public Builder sellerIDCrn(String sellerIDCrn) {
            instance.setSellerIDCrn(sellerIDCrn);
            return this;
        }

        public Builder buyerIDCrn(String buyerIDCrn) {
            instance.setBuyerIDCrn(buyerIDCrn);
            return this;
        }

        public Builder cpRole(String cpRole) {
            instance.setCpRole(cpRole);
            return this;
        }

        public Builder beneLei(String beneLei) {
            instance.setBeneLei(beneLei);
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

        public Builder utrDate(java.time.LocalDateTime utrDate) {
            instance.setUtrDate(utrDate);
            return this;
        }

        public FinReqBatchItem build() {
            return instance;
        }
    }
}
