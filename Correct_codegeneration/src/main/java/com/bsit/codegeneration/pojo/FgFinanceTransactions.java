package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgFinanceTransactions {

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

    private String fileName;

    private String anchorCrn;

    private String invNo;

    private java.time.LocalDateTime invDate;

    private java.math.BigDecimal invAmt;

    private String counterPartyCrn;

    private String counterPartyName;

    private String inputBranch;

    private String behalfOfBranch;

    private String debitPartyCrn;

    private java.time.LocalDateTime effectiveDate;

    private java.math.BigDecimal financingAmount;

    private String creditPartyCrn;

    private String creditPartyName;

    private java.math.BigDecimal spreadRate;

    private java.math.BigDecimal interestRate;

    private java.math.BigDecimal marginRate;

    private java.time.LocalDateTime maturityDate;

    private java.math.BigDecimal penaltyPercent;

    private java.time.LocalDateTime intStartDate;

    private String interestType;

    private java.math.BigDecimal rateType;

    private String baseCode;

    private Long tenorInDays;

    private Long intPeriodInDays;

    private String productType;

    private Long contractPeriod;

    private Long gracePeriod;

    private String limitNode1;

    private String limitNode2;

    private String paymentMode;

    private String beneBranch;

    private String beneAccNo;

    private String status;

    private Integer batchRefID;

    private String remarks;

    private java.math.BigDecimal advanceInterest;

    private java.math.BigDecimal netPayment;

    private String valDate;

    private String utrNumber;

    private java.math.BigDecimal charges;

    private String tiStatus;

    private Integer tiBatchRefID;

    private String tiRemarks;

    private Integer uploadRefID;

    private String entitySubTypeCode;

    private String entityTypeCode;

    private java.math.BigDecimal financeFileGenerated;

    private Integer entityRefID;

    private String financeRemarks;

    private String sellerIDCrn;

    private String buyerIDCrn;

    private String cpRole;

    private String beneLei;

    private java.math.BigDecimal financeAmount;

    private Integer layoutTemplateID;

    private String layoutName;

    private String valueDate;

    public FgFinanceTransactions() {
    }

    public FgFinanceTransactions(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String fileName, String anchorCrn, String invNo, java.time.LocalDateTime invDate, java.math.BigDecimal invAmt, String counterPartyCrn, String counterPartyName, String inputBranch, String behalfOfBranch, String debitPartyCrn, java.time.LocalDateTime effectiveDate, java.math.BigDecimal financingAmount, String creditPartyCrn, String creditPartyName, java.math.BigDecimal spreadRate, java.math.BigDecimal interestRate, java.math.BigDecimal marginRate, java.time.LocalDateTime maturityDate, java.math.BigDecimal penaltyPercent, java.time.LocalDateTime intStartDate, String interestType, java.math.BigDecimal rateType, String baseCode, Long tenorInDays, Long intPeriodInDays, String productType, Long contractPeriod, Long gracePeriod, String limitNode1, String limitNode2, String paymentMode, String beneBranch, String beneAccNo, String status, Integer batchRefID, String remarks, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valDate, String utrNumber, java.math.BigDecimal charges, String tiStatus, Integer tiBatchRefID, String tiRemarks, Integer uploadRefID, String entitySubTypeCode, String entityTypeCode, java.math.BigDecimal financeFileGenerated, Integer entityRefID, String financeRemarks, String sellerIDCrn, String buyerIDCrn, String cpRole, String beneLei, java.math.BigDecimal financeAmount, Integer layoutTemplateID, String layoutName, String valueDate) {
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
        this.fileName = fileName;
        this.anchorCrn = anchorCrn;
        this.invNo = invNo;
        this.invDate = invDate;
        this.invAmt = invAmt;
        this.counterPartyCrn = counterPartyCrn;
        this.counterPartyName = counterPartyName;
        this.inputBranch = inputBranch;
        this.behalfOfBranch = behalfOfBranch;
        this.debitPartyCrn = debitPartyCrn;
        this.effectiveDate = effectiveDate;
        this.financingAmount = financingAmount;
        this.creditPartyCrn = creditPartyCrn;
        this.creditPartyName = creditPartyName;
        this.spreadRate = spreadRate;
        this.interestRate = interestRate;
        this.marginRate = marginRate;
        this.maturityDate = maturityDate;
        this.penaltyPercent = penaltyPercent;
        this.intStartDate = intStartDate;
        this.interestType = interestType;
        this.rateType = rateType;
        this.baseCode = baseCode;
        this.tenorInDays = tenorInDays;
        this.intPeriodInDays = intPeriodInDays;
        this.productType = productType;
        this.contractPeriod = contractPeriod;
        this.gracePeriod = gracePeriod;
        this.limitNode1 = limitNode1;
        this.limitNode2 = limitNode2;
        this.paymentMode = paymentMode;
        this.beneBranch = beneBranch;
        this.beneAccNo = beneAccNo;
        this.status = status;
        this.batchRefID = batchRefID;
        this.remarks = remarks;
        this.advanceInterest = advanceInterest;
        this.netPayment = netPayment;
        this.valDate = valDate;
        this.utrNumber = utrNumber;
        this.charges = charges;
        this.tiStatus = tiStatus;
        this.tiBatchRefID = tiBatchRefID;
        this.tiRemarks = tiRemarks;
        this.uploadRefID = uploadRefID;
        this.entitySubTypeCode = entitySubTypeCode;
        this.entityTypeCode = entityTypeCode;
        this.financeFileGenerated = financeFileGenerated;
        this.entityRefID = entityRefID;
        this.financeRemarks = financeRemarks;
        this.sellerIDCrn = sellerIDCrn;
        this.buyerIDCrn = buyerIDCrn;
        this.cpRole = cpRole;
        this.beneLei = beneLei;
        this.financeAmount = financeAmount;
        this.layoutTemplateID = layoutTemplateID;
        this.layoutName = layoutName;
        this.valueDate = valueDate;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAnchorCrn() {
        return anchorCrn;
    }

    public void setAnchorCrn(String anchorCrn) {
        this.anchorCrn = anchorCrn;
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

    public java.time.LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public java.math.BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(java.math.BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
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

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public java.math.BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(java.math.BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.math.BigDecimal getPenaltyPercent() {
        return penaltyPercent;
    }

    public void setPenaltyPercent(java.math.BigDecimal penaltyPercent) {
        this.penaltyPercent = penaltyPercent;
    }

    public java.time.LocalDateTime getIntStartDate() {
        return intStartDate;
    }

    public void setIntStartDate(java.time.LocalDateTime intStartDate) {
        this.intStartDate = intStartDate;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Long contractPeriod) {
        this.contractPeriod = contractPeriod;
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

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBatchRefID() {
        return batchRefID;
    }

    public void setBatchRefID(Integer batchRefID) {
        this.batchRefID = batchRefID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getValDate() {
        return valDate;
    }

    public void setValDate(String valDate) {
        this.valDate = valDate;
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

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public java.math.BigDecimal getFinanceFileGenerated() {
        return financeFileGenerated;
    }

    public void setFinanceFileGenerated(java.math.BigDecimal financeFileGenerated) {
        this.financeFileGenerated = financeFileGenerated;
    }

    public Integer getEntityRefID() {
        return entityRefID;
    }

    public void setEntityRefID(Integer entityRefID) {
        this.entityRefID = entityRefID;
    }

    public String getFinanceRemarks() {
        return financeRemarks;
    }

    public void setFinanceRemarks(String financeRemarks) {
        this.financeRemarks = financeRemarks;
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

    public java.math.BigDecimal getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(java.math.BigDecimal financeAmount) {
        this.financeAmount = financeAmount;
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

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public static class Builder {

        private FgFinanceTransactions instance = new FgFinanceTransactions();

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

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            instance.setAnchorCrn(anchorCrn);
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

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            instance.setEffectiveDate(effectiveDate);
            return this;
        }

        public Builder financingAmount(java.math.BigDecimal financingAmount) {
            instance.setFinancingAmount(financingAmount);
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

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder marginRate(java.math.BigDecimal marginRate) {
            instance.setMarginRate(marginRate);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder penaltyPercent(java.math.BigDecimal penaltyPercent) {
            instance.setPenaltyPercent(penaltyPercent);
            return this;
        }

        public Builder intStartDate(java.time.LocalDateTime intStartDate) {
            instance.setIntStartDate(intStartDate);
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

        public Builder tenorInDays(Long tenorInDays) {
            instance.setTenorInDays(tenorInDays);
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            instance.setIntPeriodInDays(intPeriodInDays);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            instance.setContractPeriod(contractPeriod);
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

        public Builder paymentMode(String paymentMode) {
            instance.setPaymentMode(paymentMode);
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

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            instance.setBatchRefID(batchRefID);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
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

        public Builder valDate(String valDate) {
            instance.setValDate(valDate);
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

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder financeFileGenerated(java.math.BigDecimal financeFileGenerated) {
            instance.setFinanceFileGenerated(financeFileGenerated);
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            instance.setEntityRefID(entityRefID);
            return this;
        }

        public Builder financeRemarks(String financeRemarks) {
            instance.setFinanceRemarks(financeRemarks);
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

        public Builder financeAmount(java.math.BigDecimal financeAmount) {
            instance.setFinanceAmount(financeAmount);
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

        public Builder valueDate(String valueDate) {
            instance.setValueDate(valueDate);
            return this;
        }

        public FgFinanceTransactions build() {
            return instance;
        }
    }
}
