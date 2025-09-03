package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgMandml {

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

    private String recordIndicator;

    private String vendorName;

    private String payeeName;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String payeeType;

    private String payeeAccount;

    private String ifsc;

    private String invoiceNumber;

    private String currencyCode;

    private java.math.BigDecimal amount;

    private java.time.LocalDateTime startDate;

    private java.time.LocalDateTime endDate;

    private Integer transID;

    private java.math.BigDecimal interestRate;

    private String email;

    private Integer uploadRefID;

    private Long lineNo;

    private String clientCode;

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

    private String issuingPartyCode;

    private String applicantPartyCode;

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

    private String layoutName;

    private java.time.LocalDateTime customMaturityDate;

    private String layoutUuid;

    private String loanRequestType;

    private String financeParty;

    private String financeRequestStatus;

    private Integer layoutTemplateID;

    private String financeRequested;

    public FgMandml() {
    }

    public FgMandml(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String recordIndicator, String vendorName, String payeeName, String address1, String address2, String address3, String city, String payeeType, String payeeAccount, String ifsc, String invoiceNumber, String currencyCode, java.math.BigDecimal amount, java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, Integer transID, java.math.BigDecimal interestRate, String email, Integer uploadRefID, Long lineNo, String clientCode, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String issuingPartyCode, String applicantPartyCode, String fileName, String batchStatus, Integer batchRefID, String batchRemarks, String tiStatus, Integer tiBatchRefID, String tiRemarks, String tnxDisplayStatus, Integer tnxDisplayBatchID, String tnxDisplayRemarks, java.math.BigDecimal advanceInterest, java.math.BigDecimal netPayment, String valueDate, String utrNumber, java.math.BigDecimal charges, String layoutName, java.time.LocalDateTime customMaturityDate, String layoutUuid, String loanRequestType, String financeParty, String financeRequestStatus, Integer layoutTemplateID, String financeRequested) {
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
        this.recordIndicator = recordIndicator;
        this.vendorName = vendorName;
        this.payeeName = payeeName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.payeeType = payeeType;
        this.payeeAccount = payeeAccount;
        this.ifsc = ifsc;
        this.invoiceNumber = invoiceNumber;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transID = transID;
        this.interestRate = interestRate;
        this.email = email;
        this.uploadRefID = uploadRefID;
        this.lineNo = lineNo;
        this.clientCode = clientCode;
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
        this.issuingPartyCode = issuingPartyCode;
        this.applicantPartyCode = applicantPartyCode;
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
        this.layoutName = layoutName;
        this.customMaturityDate = customMaturityDate;
        this.layoutUuid = layoutUuid;
        this.loanRequestType = loanRequestType;
        this.financeParty = financeParty;
        this.financeRequestStatus = financeRequestStatus;
        this.layoutTemplateID = layoutTemplateID;
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

    public String getRecordIndicator() {
        return recordIndicator;
    }

    public void setRecordIndicator(String recordIndicator) {
        this.recordIndicator = recordIndicator;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public java.time.LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(java.time.LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public java.time.LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(java.time.LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getTransID() {
        return transID;
    }

    public void setTransID(Integer transID) {
        this.transID = transID;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
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

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
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

    public Integer getLayoutTemplateID() {
        return layoutTemplateID;
    }

    public void setLayoutTemplateID(Integer layoutTemplateID) {
        this.layoutTemplateID = layoutTemplateID;
    }

    public String getFinanceRequested() {
        return financeRequested;
    }

    public void setFinanceRequested(String financeRequested) {
        this.financeRequested = financeRequested;
    }

    public static class Builder {

        private FgMandml instance = new FgMandml();

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

        public Builder recordIndicator(String recordIndicator) {
            instance.setRecordIndicator(recordIndicator);
            return this;
        }

        public Builder vendorName(String vendorName) {
            instance.setVendorName(vendorName);
            return this;
        }

        public Builder payeeName(String payeeName) {
            instance.setPayeeName(payeeName);
            return this;
        }

        public Builder address1(String address1) {
            instance.setAddress1(address1);
            return this;
        }

        public Builder address2(String address2) {
            instance.setAddress2(address2);
            return this;
        }

        public Builder address3(String address3) {
            instance.setAddress3(address3);
            return this;
        }

        public Builder city(String city) {
            instance.setCity(city);
            return this;
        }

        public Builder payeeType(String payeeType) {
            instance.setPayeeType(payeeType);
            return this;
        }

        public Builder payeeAccount(String payeeAccount) {
            instance.setPayeeAccount(payeeAccount);
            return this;
        }

        public Builder ifsc(String ifsc) {
            instance.setIfsc(ifsc);
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            instance.setInvoiceNumber(invoiceNumber);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public Builder transID(Integer transID) {
            instance.setTransID(transID);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
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

        public Builder clientCode(String clientCode) {
            instance.setClientCode(clientCode);
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

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
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

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            instance.setLayoutTemplateID(layoutTemplateID);
            return this;
        }

        public Builder financeRequested(String financeRequested) {
            instance.setFinanceRequested(financeRequested);
            return this;
        }

        public FgMandml build() {
            return instance;
        }
    }
}
