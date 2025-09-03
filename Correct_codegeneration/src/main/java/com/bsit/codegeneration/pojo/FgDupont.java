package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgDupont {

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

    private String raisedBy;

    private java.time.LocalDateTime uploadDate;

    private String vendorName;

    private String crn;

    private java.time.LocalDateTime invoiceDate;

    private String invoiceNumber;

    private java.time.LocalDateTime dueDateOfInvoice;

    private String currency;

    private String state;

    private String vendorCode;

    private java.time.LocalDateTime discountingDate;

    private Integer uploadRefID;

    private java.math.BigDecimal invoiceAmount;

    private java.math.BigDecimal fundingAmount;

    private Long lineNo;

    private String customerAcNo;

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

    private String applicantPartyCode;

    private String issuingPartyCode;

    private java.math.BigDecimal advanceInterest;

    private java.math.BigDecimal netPayment;

    private String valueDate;

    private String utrNumber;

    private java.math.BigDecimal charges;

    private String layoutName;

    private java.time.LocalDateTime customMaturityDate;

    private String layoutUuid;

    private String loanRequestType;

    private String financeParty;

    private String financeRequestStatus;

    private String financeRequested;

    private Integer layoutTemplateID;

    public FgDupont() {
    }

    public FgDupont(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String raisedBy, java.time.LocalDateTime uploadDate, String vendorName, String crn, java.time.LocalDateTime invoiceDate, String invoiceNumber, java.time.LocalDateTime dueDateOfInvoice, String currency, String state, String vendorCode, java.time.LocalDateTime discountingDate, Integer uploadRefID, java.math.BigDecimal invoiceAmount, java.math.BigDecimal fundingAmount, Long lineNo, String customerAcNo, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String fileName, String batchStatus, Integer batchRefID, String batchRemarks, String tiStatus, Integer tiBatchRefID, String tiRemarks, String tnxDisplayStatus, Integer tnxDisplayBatchID, String tnxDisplayRemarks, String applicantPartyCode, String issuingPartyCode, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valueDate, String utrNumber, java.math.BigDecimal charges, String layoutName, java.time.LocalDateTime customMaturityDate, String layoutUuid, String loanRequestType, String financeParty, String financeRequestStatus, String financeRequested, Integer layoutTemplateID) {
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
        this.raisedBy = raisedBy;
        this.uploadDate = uploadDate;
        this.vendorName = vendorName;
        this.crn = crn;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.dueDateOfInvoice = dueDateOfInvoice;
        this.currency = currency;
        this.state = state;
        this.vendorCode = vendorCode;
        this.discountingDate = discountingDate;
        this.uploadRefID = uploadRefID;
        this.invoiceAmount = invoiceAmount;
        this.fundingAmount = fundingAmount;
        this.lineNo = lineNo;
        this.customerAcNo = customerAcNo;
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
        this.applicantPartyCode = applicantPartyCode;
        this.issuingPartyCode = issuingPartyCode;
        this.advanceInterest = advanceInterest;
        this.netPayment = netPayment;
        this.valueDate = valueDate;
        this.utrNumber = utrNumber;
        this.charges = charges;
        this.layoutName = layoutName;
        this.customMaturityDate = customMaturityDate;
        this.layoutUuid = layoutUuid;
        this.loanRequestType = loanRequestType;
        this.financeParty = financeParty;
        this.financeRequestStatus = financeRequestStatus;
        this.financeRequested = financeRequested;
        this.layoutTemplateID = layoutTemplateID;
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

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public java.time.LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(java.time.LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public java.time.LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(java.time.LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public java.time.LocalDateTime getDueDateOfInvoice() {
        return dueDateOfInvoice;
    }

    public void setDueDateOfInvoice(java.time.LocalDateTime dueDateOfInvoice) {
        this.dueDateOfInvoice = dueDateOfInvoice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public java.time.LocalDateTime getDiscountingDate() {
        return discountingDate;
    }

    public void setDiscountingDate(java.time.LocalDateTime discountingDate) {
        this.discountingDate = discountingDate;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public java.math.BigDecimal getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(java.math.BigDecimal fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public String getCustomerAcNo() {
        return customerAcNo;
    }

    public void setCustomerAcNo(String customerAcNo) {
        this.customerAcNo = customerAcNo;
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

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
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

    public String getLoanRequestType() {
        return loanRequestType;
    }

    public void setLoanRequestType(String loanRequestType) {
        this.loanRequestType = loanRequestType;
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

    public Integer getLayoutTemplateID() {
        return layoutTemplateID;
    }

    public void setLayoutTemplateID(Integer layoutTemplateID) {
        this.layoutTemplateID = layoutTemplateID;
    }

    public static class Builder {

        private FgDupont instance = new FgDupont();

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

        public Builder raisedBy(String raisedBy) {
            instance.setRaisedBy(raisedBy);
            return this;
        }

        public Builder uploadDate(java.time.LocalDateTime uploadDate) {
            instance.setUploadDate(uploadDate);
            return this;
        }

        public Builder vendorName(String vendorName) {
            instance.setVendorName(vendorName);
            return this;
        }

        public Builder crn(String crn) {
            instance.setCrn(crn);
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            instance.setInvoiceDate(invoiceDate);
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            instance.setInvoiceNumber(invoiceNumber);
            return this;
        }

        public Builder dueDateOfInvoice(java.time.LocalDateTime dueDateOfInvoice) {
            instance.setDueDateOfInvoice(dueDateOfInvoice);
            return this;
        }

        public Builder currency(String currency) {
            instance.setCurrency(currency);
            return this;
        }

        public Builder state(String state) {
            instance.setState(state);
            return this;
        }

        public Builder vendorCode(String vendorCode) {
            instance.setVendorCode(vendorCode);
            return this;
        }

        public Builder discountingDate(java.time.LocalDateTime discountingDate) {
            instance.setDiscountingDate(discountingDate);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder invoiceAmount(java.math.BigDecimal invoiceAmount) {
            instance.setInvoiceAmount(invoiceAmount);
            return this;
        }

        public Builder fundingAmount(java.math.BigDecimal fundingAmount) {
            instance.setFundingAmount(fundingAmount);
            return this;
        }

        public Builder lineNo(Long lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public Builder customerAcNo(String customerAcNo) {
            instance.setCustomerAcNo(customerAcNo);
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

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
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

        public Builder layoutName(String layoutName) {
            instance.setLayoutName(layoutName);
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

        public Builder loanRequestType(String loanRequestType) {
            instance.setLoanRequestType(loanRequestType);
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

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            instance.setLayoutTemplateID(layoutTemplateID);
            return this;
        }

        public FgDupont build() {
            return instance;
        }
    }
}
