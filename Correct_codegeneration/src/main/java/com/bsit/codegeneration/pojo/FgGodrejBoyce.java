package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgGodrejBoyce {

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

    private Integer sellerID;

    private String supplierName;

    private Integer buyerID;

    private java.time.LocalDateTime invoiceDate;

    private String invoiceNo;

    private java.math.BigDecimal invoiceAmount;

    private String currency;

    private java.time.LocalDateTime dueDate;

    private String referenceNo;

    private Integer uploadRefID;

    private String remarks;

    private Long lineNo;

    private String srNo;

    private String test1;

    private String test2;

    private String test3;

    private String test4;

    private java.math.BigDecimal authEquivalentAmount;

    private String authEquivalentCurrency;

    private java.math.BigDecimal displayEquivalentAmount;

    private String displayEquivalentCurrency;

    private java.math.BigDecimal equivalentAmount;

    private String equivalentCurrency;

    private java.math.BigDecimal authFxBaseRate;

    private java.math.BigDecimal displayFxBaseRate;

    private String applicantPartyCode;

    private String issuingPartyCode;

    private String applicantParty;

    private Integer layoutTemplateID;

    private String layoutName;

    private String fileName;

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

    private String freeText1;

    private String freeText2;

    private String freeText3;

    private String programType;

    private java.time.LocalDateTime customMaturityDate;

    private Integer layoutID;

    private String layoutUuid;

    private String loanRequestType;

    private Integer portalBatchRefID;

    private String financeParty;

    private String financeRequestStatus;

    private String financeRequested;

    public FgGodrejBoyce() {
    }

    public FgGodrejBoyce(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Integer sellerID, String supplierName, Integer buyerID, java.time.LocalDateTime invoiceDate, String invoiceNo, java.math.BigDecimal invoiceAmount, String currency, java.time.LocalDateTime dueDate, String referenceNo, Integer uploadRefID, String remarks, Long lineNo, String srNo, String test1, String test2, String test3, String test4, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String applicantParty, Integer layoutTemplateID, String layoutName, String fileName, String batchStatus, Integer batchRefID, String batchRemarks, String tiStatus, Integer tiBatchRefID, String tiRemarks, String tnxDisplayStatus, Integer tnxDisplayBatchID, String tnxDisplayRemarks, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valueDate, String utrNumber, java.math.BigDecimal charges, String freeText1, String freeText2, String freeText3, String programType, java.time.LocalDateTime customMaturityDate, Integer layoutID, String layoutUuid, String loanRequestType, Integer portalBatchRefID, String financeParty, String financeRequestStatus, String financeRequested) {
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
        this.sellerID = sellerID;
        this.supplierName = supplierName;
        this.buyerID = buyerID;
        this.invoiceDate = invoiceDate;
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
        this.currency = currency;
        this.dueDate = dueDate;
        this.referenceNo = referenceNo;
        this.uploadRefID = uploadRefID;
        this.remarks = remarks;
        this.lineNo = lineNo;
        this.srNo = srNo;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
        this.authEquivalentAmount = authEquivalentAmount;
        this.authEquivalentCurrency = authEquivalentCurrency;
        this.displayEquivalentAmount = displayEquivalentAmount;
        this.displayEquivalentCurrency = displayEquivalentCurrency;
        this.equivalentAmount = equivalentAmount;
        this.equivalentCurrency = equivalentCurrency;
        this.authFxBaseRate = authFxBaseRate;
        this.displayFxBaseRate = displayFxBaseRate;
        this.applicantPartyCode = applicantPartyCode;
        this.issuingPartyCode = issuingPartyCode;
        this.applicantParty = applicantParty;
        this.layoutTemplateID = layoutTemplateID;
        this.layoutName = layoutName;
        this.fileName = fileName;
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
        this.freeText1 = freeText1;
        this.freeText2 = freeText2;
        this.freeText3 = freeText3;
        this.programType = programType;
        this.customMaturityDate = customMaturityDate;
        this.layoutID = layoutID;
        this.layoutUuid = layoutUuid;
        this.loanRequestType = loanRequestType;
        this.portalBatchRefID = portalBatchRefID;
        this.financeParty = financeParty;
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

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public java.time.LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(java.time.LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public java.time.LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.time.LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }

    public String getTest4() {
        return test4;
    }

    public void setTest4(String test4) {
        this.test4 = test4;
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

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getFreeText1() {
        return freeText1;
    }

    public void setFreeText1(String freeText1) {
        this.freeText1 = freeText1;
    }

    public String getFreeText2() {
        return freeText2;
    }

    public void setFreeText2(String freeText2) {
        this.freeText2 = freeText2;
    }

    public String getFreeText3() {
        return freeText3;
    }

    public void setFreeText3(String freeText3) {
        this.freeText3 = freeText3;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public java.time.LocalDateTime getCustomMaturityDate() {
        return customMaturityDate;
    }

    public void setCustomMaturityDate(java.time.LocalDateTime customMaturityDate) {
        this.customMaturityDate = customMaturityDate;
    }

    public Integer getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(Integer layoutID) {
        this.layoutID = layoutID;
    }

    public String getLayoutUuid() {
        return layoutUuid;
    }

    public void setLayoutUuid(String layoutUuid) {
        this.layoutUuid = layoutUuid;
    }

    public String getLoanRequestType() {
        return loanRequestType;
    }

    public void setLoanRequestType(String loanRequestType) {
        this.loanRequestType = loanRequestType;
    }

    public Integer getPortalBatchRefID() {
        return portalBatchRefID;
    }

    public void setPortalBatchRefID(Integer portalBatchRefID) {
        this.portalBatchRefID = portalBatchRefID;
    }

    public String getFinanceParty() {
        return financeParty;
    }

    public void setFinanceParty(String financeParty) {
        this.financeParty = financeParty;
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

        private FgGodrejBoyce instance = new FgGodrejBoyce();

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

        public Builder sellerID(Integer sellerID) {
            instance.setSellerID(sellerID);
            return this;
        }

        public Builder supplierName(String supplierName) {
            instance.setSupplierName(supplierName);
            return this;
        }

        public Builder buyerID(Integer buyerID) {
            instance.setBuyerID(buyerID);
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            instance.setInvoiceDate(invoiceDate);
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            instance.setInvoiceNo(invoiceNo);
            return this;
        }

        public Builder invoiceAmount(java.math.BigDecimal invoiceAmount) {
            instance.setInvoiceAmount(invoiceAmount);
            return this;
        }

        public Builder currency(String currency) {
            instance.setCurrency(currency);
            return this;
        }

        public Builder dueDate(java.time.LocalDateTime dueDate) {
            instance.setDueDate(dueDate);
            return this;
        }

        public Builder referenceNo(String referenceNo) {
            instance.setReferenceNo(referenceNo);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder lineNo(Long lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public Builder srNo(String srNo) {
            instance.setSrNo(srNo);
            return this;
        }

        public Builder test1(String test1) {
            instance.setTest1(test1);
            return this;
        }

        public Builder test2(String test2) {
            instance.setTest2(test2);
            return this;
        }

        public Builder test3(String test3) {
            instance.setTest3(test3);
            return this;
        }

        public Builder test4(String test4) {
            instance.setTest4(test4);
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

        public Builder equivalentAmount(java.math.BigDecimal equivalentAmount) {
            instance.setEquivalentAmount(equivalentAmount);
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            instance.setEquivalentCurrency(equivalentCurrency);
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

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
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

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
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

        public Builder freeText1(String freeText1) {
            instance.setFreeText1(freeText1);
            return this;
        }

        public Builder freeText2(String freeText2) {
            instance.setFreeText2(freeText2);
            return this;
        }

        public Builder freeText3(String freeText3) {
            instance.setFreeText3(freeText3);
            return this;
        }

        public Builder programType(String programType) {
            instance.setProgramType(programType);
            return this;
        }

        public Builder customMaturityDate(java.time.LocalDateTime customMaturityDate) {
            instance.setCustomMaturityDate(customMaturityDate);
            return this;
        }

        public Builder layoutID(Integer layoutID) {
            instance.setLayoutID(layoutID);
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            instance.setLayoutUuid(layoutUuid);
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            instance.setLoanRequestType(loanRequestType);
            return this;
        }

        public Builder portalBatchRefID(Integer portalBatchRefID) {
            instance.setPortalBatchRefID(portalBatchRefID);
            return this;
        }

        public Builder financeParty(String financeParty) {
            instance.setFinanceParty(financeParty);
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

        public FgGodrejBoyce build() {
            return instance;
        }
    }
}
