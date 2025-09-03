package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgVoltasm {

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

    private String clientCode;

    private String productCode;

    private String paymentType;

    private String paymentRefNo;

    private java.time.LocalDateTime paymentDate;

    private java.time.LocalDateTime instrumentDate;

    private java.math.BigDecimal amount;

    private String bankCodeIndicator;

    private String beneficiaryCode;

    private String beneficiaryName;

    private String beneficiaryBank;

    private String beneficiaryBranch;

    private String location;

    private String printLocation;

    private Long instrumentNo;

    private String beneficiaryAddress1;

    private String beneficiaryAddress2;

    private String beneficiaryAddress3;

    private String beneficiaryAddress4;

    private String beneficiaryEmail;

    private String beneficiaryMobile;

    private String debitNarration;

    private String creditNarration;

    private String paymentDetails1;

    private String paymentDetails2;

    private String paymentDetails3;

    private String paymentDetails4;

    private String srNo;

    private String documentNo;

    private String invRefNo;

    private java.time.LocalDateTime invDate;

    private java.math.BigDecimal invAmount;

    private java.math.BigDecimal otherDeductions;

    private java.math.BigDecimal tdsAmount;

    private java.math.BigDecimal totalDeductedAmount;

    private java.math.BigDecimal netAmountPayable;

    private Integer uploadRefID;

    private Long lineNo;

    private String uploadLayoutUuid;

    private String beneficiaryAccNo;

    private String drAcNo;

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

    private String fileName;

    public FgVoltasm() {
    }

    public FgVoltasm(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String clientCode, String productCode, String paymentType, String paymentRefNo, java.time.LocalDateTime paymentDate, java.time.LocalDateTime instrumentDate, java.math.BigDecimal amount, String bankCodeIndicator, String beneficiaryCode, String beneficiaryName, String beneficiaryBank, String beneficiaryBranch, String location, String printLocation, Long instrumentNo, String beneficiaryAddress1, String beneficiaryAddress2, String beneficiaryAddress3, String beneficiaryAddress4, String beneficiaryEmail, String beneficiaryMobile, String debitNarration, String creditNarration, String paymentDetails1, String paymentDetails2, String paymentDetails3, String paymentDetails4, String srNo, String documentNo, String invRefNo, java.time.LocalDateTime invDate, java.math.BigDecimal invAmount, java.math.BigDecimal otherDeductions, java.math.BigDecimal tdsAmount, java.math.BigDecimal totalDeductedAmount, java.math.BigDecimal netAmountPayable, Integer uploadRefID, Long lineNo, String uploadLayoutUuid, String beneficiaryAccNo, String drAcNo, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {
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
        this.clientCode = clientCode;
        this.productCode = productCode;
        this.paymentType = paymentType;
        this.paymentRefNo = paymentRefNo;
        this.paymentDate = paymentDate;
        this.instrumentDate = instrumentDate;
        this.amount = amount;
        this.bankCodeIndicator = bankCodeIndicator;
        this.beneficiaryCode = beneficiaryCode;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryBank = beneficiaryBank;
        this.beneficiaryBranch = beneficiaryBranch;
        this.location = location;
        this.printLocation = printLocation;
        this.instrumentNo = instrumentNo;
        this.beneficiaryAddress1 = beneficiaryAddress1;
        this.beneficiaryAddress2 = beneficiaryAddress2;
        this.beneficiaryAddress3 = beneficiaryAddress3;
        this.beneficiaryAddress4 = beneficiaryAddress4;
        this.beneficiaryEmail = beneficiaryEmail;
        this.beneficiaryMobile = beneficiaryMobile;
        this.debitNarration = debitNarration;
        this.creditNarration = creditNarration;
        this.paymentDetails1 = paymentDetails1;
        this.paymentDetails2 = paymentDetails2;
        this.paymentDetails3 = paymentDetails3;
        this.paymentDetails4 = paymentDetails4;
        this.srNo = srNo;
        this.documentNo = documentNo;
        this.invRefNo = invRefNo;
        this.invDate = invDate;
        this.invAmount = invAmount;
        this.otherDeductions = otherDeductions;
        this.tdsAmount = tdsAmount;
        this.totalDeductedAmount = totalDeductedAmount;
        this.netAmountPayable = netAmountPayable;
        this.uploadRefID = uploadRefID;
        this.lineNo = lineNo;
        this.uploadLayoutUuid = uploadLayoutUuid;
        this.beneficiaryAccNo = beneficiaryAccNo;
        this.drAcNo = drAcNo;
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
        this.fileName = fileName;
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
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

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankCodeIndicator() {
        return bankCodeIndicator;
    }

    public void setBankCodeIndicator(String bankCodeIndicator) {
        this.bankCodeIndicator = bankCodeIndicator;
    }

    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(String beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryBank() {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(String beneficiaryBank) {
        this.beneficiaryBank = beneficiaryBank;
    }

    public String getBeneficiaryBranch() {
        return beneficiaryBranch;
    }

    public void setBeneficiaryBranch(String beneficiaryBranch) {
        this.beneficiaryBranch = beneficiaryBranch;
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

    public Long getInstrumentNo() {
        return instrumentNo;
    }

    public void setInstrumentNo(Long instrumentNo) {
        this.instrumentNo = instrumentNo;
    }

    public String getBeneficiaryAddress1() {
        return beneficiaryAddress1;
    }

    public void setBeneficiaryAddress1(String beneficiaryAddress1) {
        this.beneficiaryAddress1 = beneficiaryAddress1;
    }

    public String getBeneficiaryAddress2() {
        return beneficiaryAddress2;
    }

    public void setBeneficiaryAddress2(String beneficiaryAddress2) {
        this.beneficiaryAddress2 = beneficiaryAddress2;
    }

    public String getBeneficiaryAddress3() {
        return beneficiaryAddress3;
    }

    public void setBeneficiaryAddress3(String beneficiaryAddress3) {
        this.beneficiaryAddress3 = beneficiaryAddress3;
    }

    public String getBeneficiaryAddress4() {
        return beneficiaryAddress4;
    }

    public void setBeneficiaryAddress4(String beneficiaryAddress4) {
        this.beneficiaryAddress4 = beneficiaryAddress4;
    }

    public String getBeneficiaryEmail() {
        return beneficiaryEmail;
    }

    public void setBeneficiaryEmail(String beneficiaryEmail) {
        this.beneficiaryEmail = beneficiaryEmail;
    }

    public String getBeneficiaryMobile() {
        return beneficiaryMobile;
    }

    public void setBeneficiaryMobile(String beneficiaryMobile) {
        this.beneficiaryMobile = beneficiaryMobile;
    }

    public String getDebitNarration() {
        return debitNarration;
    }

    public void setDebitNarration(String debitNarration) {
        this.debitNarration = debitNarration;
    }

    public String getCreditNarration() {
        return creditNarration;
    }

    public void setCreditNarration(String creditNarration) {
        this.creditNarration = creditNarration;
    }

    public String getPaymentDetails1() {
        return paymentDetails1;
    }

    public void setPaymentDetails1(String paymentDetails1) {
        this.paymentDetails1 = paymentDetails1;
    }

    public String getPaymentDetails2() {
        return paymentDetails2;
    }

    public void setPaymentDetails2(String paymentDetails2) {
        this.paymentDetails2 = paymentDetails2;
    }

    public String getPaymentDetails3() {
        return paymentDetails3;
    }

    public void setPaymentDetails3(String paymentDetails3) {
        this.paymentDetails3 = paymentDetails3;
    }

    public String getPaymentDetails4() {
        return paymentDetails4;
    }

    public void setPaymentDetails4(String paymentDetails4) {
        this.paymentDetails4 = paymentDetails4;
    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getInvRefNo() {
        return invRefNo;
    }

    public void setInvRefNo(String invRefNo) {
        this.invRefNo = invRefNo;
    }

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public java.math.BigDecimal getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(java.math.BigDecimal invAmount) {
        this.invAmount = invAmount;
    }

    public java.math.BigDecimal getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(java.math.BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    public java.math.BigDecimal getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(java.math.BigDecimal tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public java.math.BigDecimal getTotalDeductedAmount() {
        return totalDeductedAmount;
    }

    public void setTotalDeductedAmount(java.math.BigDecimal totalDeductedAmount) {
        this.totalDeductedAmount = totalDeductedAmount;
    }

    public java.math.BigDecimal getNetAmountPayable() {
        return netAmountPayable;
    }

    public void setNetAmountPayable(java.math.BigDecimal netAmountPayable) {
        this.netAmountPayable = netAmountPayable;
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

    public String getUploadLayoutUuid() {
        return uploadLayoutUuid;
    }

    public void setUploadLayoutUuid(String uploadLayoutUuid) {
        this.uploadLayoutUuid = uploadLayoutUuid;
    }

    public String getBeneficiaryAccNo() {
        return beneficiaryAccNo;
    }

    public void setBeneficiaryAccNo(String beneficiaryAccNo) {
        this.beneficiaryAccNo = beneficiaryAccNo;
    }

    public String getDrAcNo() {
        return drAcNo;
    }

    public void setDrAcNo(String drAcNo) {
        this.drAcNo = drAcNo;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static class Builder {

        private FgVoltasm instance = new FgVoltasm();

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

        public Builder clientCode(String clientCode) {
            instance.setClientCode(clientCode);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder paymentType(String paymentType) {
            instance.setPaymentType(paymentType);
            return this;
        }

        public Builder paymentRefNo(String paymentRefNo) {
            instance.setPaymentRefNo(paymentRefNo);
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

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder bankCodeIndicator(String bankCodeIndicator) {
            instance.setBankCodeIndicator(bankCodeIndicator);
            return this;
        }

        public Builder beneficiaryCode(String beneficiaryCode) {
            instance.setBeneficiaryCode(beneficiaryCode);
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            instance.setBeneficiaryName(beneficiaryName);
            return this;
        }

        public Builder beneficiaryBank(String beneficiaryBank) {
            instance.setBeneficiaryBank(beneficiaryBank);
            return this;
        }

        public Builder beneficiaryBranch(String beneficiaryBranch) {
            instance.setBeneficiaryBranch(beneficiaryBranch);
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

        public Builder instrumentNo(Long instrumentNo) {
            instance.setInstrumentNo(instrumentNo);
            return this;
        }

        public Builder beneficiaryAddress1(String beneficiaryAddress1) {
            instance.setBeneficiaryAddress1(beneficiaryAddress1);
            return this;
        }

        public Builder beneficiaryAddress2(String beneficiaryAddress2) {
            instance.setBeneficiaryAddress2(beneficiaryAddress2);
            return this;
        }

        public Builder beneficiaryAddress3(String beneficiaryAddress3) {
            instance.setBeneficiaryAddress3(beneficiaryAddress3);
            return this;
        }

        public Builder beneficiaryAddress4(String beneficiaryAddress4) {
            instance.setBeneficiaryAddress4(beneficiaryAddress4);
            return this;
        }

        public Builder beneficiaryEmail(String beneficiaryEmail) {
            instance.setBeneficiaryEmail(beneficiaryEmail);
            return this;
        }

        public Builder beneficiaryMobile(String beneficiaryMobile) {
            instance.setBeneficiaryMobile(beneficiaryMobile);
            return this;
        }

        public Builder debitNarration(String debitNarration) {
            instance.setDebitNarration(debitNarration);
            return this;
        }

        public Builder creditNarration(String creditNarration) {
            instance.setCreditNarration(creditNarration);
            return this;
        }

        public Builder paymentDetails1(String paymentDetails1) {
            instance.setPaymentDetails1(paymentDetails1);
            return this;
        }

        public Builder paymentDetails2(String paymentDetails2) {
            instance.setPaymentDetails2(paymentDetails2);
            return this;
        }

        public Builder paymentDetails3(String paymentDetails3) {
            instance.setPaymentDetails3(paymentDetails3);
            return this;
        }

        public Builder paymentDetails4(String paymentDetails4) {
            instance.setPaymentDetails4(paymentDetails4);
            return this;
        }

        public Builder srNo(String srNo) {
            instance.setSrNo(srNo);
            return this;
        }

        public Builder documentNo(String documentNo) {
            instance.setDocumentNo(documentNo);
            return this;
        }

        public Builder invRefNo(String invRefNo) {
            instance.setInvRefNo(invRefNo);
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder invAmount(java.math.BigDecimal invAmount) {
            instance.setInvAmount(invAmount);
            return this;
        }

        public Builder otherDeductions(java.math.BigDecimal otherDeductions) {
            instance.setOtherDeductions(otherDeductions);
            return this;
        }

        public Builder tdsAmount(java.math.BigDecimal tdsAmount) {
            instance.setTdsAmount(tdsAmount);
            return this;
        }

        public Builder totalDeductedAmount(java.math.BigDecimal totalDeductedAmount) {
            instance.setTotalDeductedAmount(totalDeductedAmount);
            return this;
        }

        public Builder netAmountPayable(java.math.BigDecimal netAmountPayable) {
            instance.setNetAmountPayable(netAmountPayable);
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

        public Builder uploadLayoutUuid(String uploadLayoutUuid) {
            instance.setUploadLayoutUuid(uploadLayoutUuid);
            return this;
        }

        public Builder beneficiaryAccNo(String beneficiaryAccNo) {
            instance.setBeneficiaryAccNo(beneficiaryAccNo);
            return this;
        }

        public Builder drAcNo(String drAcNo) {
            instance.setDrAcNo(drAcNo);
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

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public FgVoltasm build() {
            return instance;
        }
    }
}
