package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgUploadAdvice {

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

    private String vendorCode;

    private String invoiceNumber;

    private java.time.LocalDateTime invoiceDate;

    private java.time.LocalDateTime billDueDate;

    private String currency;

    private java.math.BigDecimal invoiceAmount;

    private String invoiceRef;

    private String serialNo;

    private String documentNo;

    private java.math.BigDecimal otherDeductions;

    private java.math.BigDecimal totalDeductedAmount;

    private java.math.BigDecimal netAmountPayable;

    private java.time.LocalDateTime boeDate;

    private String paymentDetails6;

    private String paymentDetails7;

    private String paymentDetails8;

    private String paymentDetails9;

    private String paymentDetails10;

    private String clientRefNo;

    private java.time.LocalDateTime invoiceDrNoteDate;

    private String invoiceDrNoteNo;

    private String tenure;

    private java.math.BigDecimal interestRate;

    private java.math.BigDecimal amountA;

    private java.math.BigDecimal amountB;

    private java.math.BigDecimal amountC;

    private java.math.BigDecimal invoiceDebitNoteAmount;

    private String narration;

    private String billNo;

    private java.math.BigDecimal netAmount;

    private java.time.LocalDateTime billDate;

    private String hundiNumber;

    private String lineNoOfAdvice;

    private String annexureTextContent;

    private String invoiceDateSomany;

    private Integer parentRefID;

    private Integer parentVersionID;

    private java.math.BigDecimal discountRate;

    private java.math.BigDecimal grossAmount;

    private java.math.BigDecimal tdsAmount;

    private String bankCharges;

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

    public FgUploadAdvice() {
    }

    public FgUploadAdvice(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String vendorCode, String invoiceNumber, java.time.LocalDateTime invoiceDate, java.time.LocalDateTime billDueDate, String currency, java.math.BigDecimal invoiceAmount, String invoiceRef, String serialNo, String documentNo, java.math.BigDecimal otherDeductions, java.math.BigDecimal totalDeductedAmount, java.math.BigDecimal netAmountPayable, java.time.LocalDateTime boeDate, String paymentDetails6, String paymentDetails7, String paymentDetails8, String paymentDetails9, String paymentDetails10, String clientRefNo, java.time.LocalDateTime invoiceDrNoteDate, String invoiceDrNoteNo, String tenure, java.math.BigDecimal interestRate, java.math.BigDecimal amountA, java.math.BigDecimal amountB, java.math.BigDecimal amountC, java.math.BigDecimal invoiceDebitNoteAmount, String narration, String billNo, java.math.BigDecimal netAmount, java.time.LocalDateTime billDate, String hundiNumber, String lineNoOfAdvice, String annexureTextContent, String invoiceDateSomany, Integer parentRefID, Integer parentVersionID, java.math.BigDecimal discountRate, java.math.BigDecimal grossAmount, java.math.BigDecimal tdsAmount, String bankCharges, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate) {
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
        this.vendorCode = vendorCode;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.billDueDate = billDueDate;
        this.currency = currency;
        this.invoiceAmount = invoiceAmount;
        this.invoiceRef = invoiceRef;
        this.serialNo = serialNo;
        this.documentNo = documentNo;
        this.otherDeductions = otherDeductions;
        this.totalDeductedAmount = totalDeductedAmount;
        this.netAmountPayable = netAmountPayable;
        this.boeDate = boeDate;
        this.paymentDetails6 = paymentDetails6;
        this.paymentDetails7 = paymentDetails7;
        this.paymentDetails8 = paymentDetails8;
        this.paymentDetails9 = paymentDetails9;
        this.paymentDetails10 = paymentDetails10;
        this.clientRefNo = clientRefNo;
        this.invoiceDrNoteDate = invoiceDrNoteDate;
        this.invoiceDrNoteNo = invoiceDrNoteNo;
        this.tenure = tenure;
        this.interestRate = interestRate;
        this.amountA = amountA;
        this.amountB = amountB;
        this.amountC = amountC;
        this.invoiceDebitNoteAmount = invoiceDebitNoteAmount;
        this.narration = narration;
        this.billNo = billNo;
        this.netAmount = netAmount;
        this.billDate = billDate;
        this.hundiNumber = hundiNumber;
        this.lineNoOfAdvice = lineNoOfAdvice;
        this.annexureTextContent = annexureTextContent;
        this.invoiceDateSomany = invoiceDateSomany;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.discountRate = discountRate;
        this.grossAmount = grossAmount;
        this.tdsAmount = tdsAmount;
        this.bankCharges = bankCharges;
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

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
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

    public java.time.LocalDateTime getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(java.time.LocalDateTime billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public java.math.BigDecimal getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(java.math.BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
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

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public String getPaymentDetails6() {
        return paymentDetails6;
    }

    public void setPaymentDetails6(String paymentDetails6) {
        this.paymentDetails6 = paymentDetails6;
    }

    public String getPaymentDetails7() {
        return paymentDetails7;
    }

    public void setPaymentDetails7(String paymentDetails7) {
        this.paymentDetails7 = paymentDetails7;
    }

    public String getPaymentDetails8() {
        return paymentDetails8;
    }

    public void setPaymentDetails8(String paymentDetails8) {
        this.paymentDetails8 = paymentDetails8;
    }

    public String getPaymentDetails9() {
        return paymentDetails9;
    }

    public void setPaymentDetails9(String paymentDetails9) {
        this.paymentDetails9 = paymentDetails9;
    }

    public String getPaymentDetails10() {
        return paymentDetails10;
    }

    public void setPaymentDetails10(String paymentDetails10) {
        this.paymentDetails10 = paymentDetails10;
    }

    public String getClientRefNo() {
        return clientRefNo;
    }

    public void setClientRefNo(String clientRefNo) {
        this.clientRefNo = clientRefNo;
    }

    public java.time.LocalDateTime getInvoiceDrNoteDate() {
        return invoiceDrNoteDate;
    }

    public void setInvoiceDrNoteDate(java.time.LocalDateTime invoiceDrNoteDate) {
        this.invoiceDrNoteDate = invoiceDrNoteDate;
    }

    public String getInvoiceDrNoteNo() {
        return invoiceDrNoteNo;
    }

    public void setInvoiceDrNoteNo(String invoiceDrNoteNo) {
        this.invoiceDrNoteNo = invoiceDrNoteNo;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public java.math.BigDecimal getAmountA() {
        return amountA;
    }

    public void setAmountA(java.math.BigDecimal amountA) {
        this.amountA = amountA;
    }

    public java.math.BigDecimal getAmountB() {
        return amountB;
    }

    public void setAmountB(java.math.BigDecimal amountB) {
        this.amountB = amountB;
    }

    public java.math.BigDecimal getAmountC() {
        return amountC;
    }

    public void setAmountC(java.math.BigDecimal amountC) {
        this.amountC = amountC;
    }

    public java.math.BigDecimal getInvoiceDebitNoteAmount() {
        return invoiceDebitNoteAmount;
    }

    public void setInvoiceDebitNoteAmount(java.math.BigDecimal invoiceDebitNoteAmount) {
        this.invoiceDebitNoteAmount = invoiceDebitNoteAmount;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public java.math.BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(java.math.BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public java.time.LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(java.time.LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public String getHundiNumber() {
        return hundiNumber;
    }

    public void setHundiNumber(String hundiNumber) {
        this.hundiNumber = hundiNumber;
    }

    public String getLineNoOfAdvice() {
        return lineNoOfAdvice;
    }

    public void setLineNoOfAdvice(String lineNoOfAdvice) {
        this.lineNoOfAdvice = lineNoOfAdvice;
    }

    public String getAnnexureTextContent() {
        return annexureTextContent;
    }

    public void setAnnexureTextContent(String annexureTextContent) {
        this.annexureTextContent = annexureTextContent;
    }

    public String getInvoiceDateSomany() {
        return invoiceDateSomany;
    }

    public void setInvoiceDateSomany(String invoiceDateSomany) {
        this.invoiceDateSomany = invoiceDateSomany;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public java.math.BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(java.math.BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public java.math.BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(java.math.BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public java.math.BigDecimal getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(java.math.BigDecimal tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public String getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(String bankCharges) {
        this.bankCharges = bankCharges;
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

    public static class Builder {

        private FgUploadAdvice instance = new FgUploadAdvice();

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

        public Builder vendorCode(String vendorCode) {
            instance.setVendorCode(vendorCode);
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

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            instance.setBillDueDate(billDueDate);
            return this;
        }

        public Builder currency(String currency) {
            instance.setCurrency(currency);
            return this;
        }

        public Builder invoiceAmount(java.math.BigDecimal invoiceAmount) {
            instance.setInvoiceAmount(invoiceAmount);
            return this;
        }

        public Builder invoiceRef(String invoiceRef) {
            instance.setInvoiceRef(invoiceRef);
            return this;
        }

        public Builder serialNo(String serialNo) {
            instance.setSerialNo(serialNo);
            return this;
        }

        public Builder documentNo(String documentNo) {
            instance.setDocumentNo(documentNo);
            return this;
        }

        public Builder otherDeductions(java.math.BigDecimal otherDeductions) {
            instance.setOtherDeductions(otherDeductions);
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

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder paymentDetails6(String paymentDetails6) {
            instance.setPaymentDetails6(paymentDetails6);
            return this;
        }

        public Builder paymentDetails7(String paymentDetails7) {
            instance.setPaymentDetails7(paymentDetails7);
            return this;
        }

        public Builder paymentDetails8(String paymentDetails8) {
            instance.setPaymentDetails8(paymentDetails8);
            return this;
        }

        public Builder paymentDetails9(String paymentDetails9) {
            instance.setPaymentDetails9(paymentDetails9);
            return this;
        }

        public Builder paymentDetails10(String paymentDetails10) {
            instance.setPaymentDetails10(paymentDetails10);
            return this;
        }

        public Builder clientRefNo(String clientRefNo) {
            instance.setClientRefNo(clientRefNo);
            return this;
        }

        public Builder invoiceDrNoteDate(java.time.LocalDateTime invoiceDrNoteDate) {
            instance.setInvoiceDrNoteDate(invoiceDrNoteDate);
            return this;
        }

        public Builder invoiceDrNoteNo(String invoiceDrNoteNo) {
            instance.setInvoiceDrNoteNo(invoiceDrNoteNo);
            return this;
        }

        public Builder tenure(String tenure) {
            instance.setTenure(tenure);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder amountA(java.math.BigDecimal amountA) {
            instance.setAmountA(amountA);
            return this;
        }

        public Builder amountB(java.math.BigDecimal amountB) {
            instance.setAmountB(amountB);
            return this;
        }

        public Builder amountC(java.math.BigDecimal amountC) {
            instance.setAmountC(amountC);
            return this;
        }

        public Builder invoiceDebitNoteAmount(java.math.BigDecimal invoiceDebitNoteAmount) {
            instance.setInvoiceDebitNoteAmount(invoiceDebitNoteAmount);
            return this;
        }

        public Builder narration(String narration) {
            instance.setNarration(narration);
            return this;
        }

        public Builder billNo(String billNo) {
            instance.setBillNo(billNo);
            return this;
        }

        public Builder netAmount(java.math.BigDecimal netAmount) {
            instance.setNetAmount(netAmount);
            return this;
        }

        public Builder billDate(java.time.LocalDateTime billDate) {
            instance.setBillDate(billDate);
            return this;
        }

        public Builder hundiNumber(String hundiNumber) {
            instance.setHundiNumber(hundiNumber);
            return this;
        }

        public Builder lineNoOfAdvice(String lineNoOfAdvice) {
            instance.setLineNoOfAdvice(lineNoOfAdvice);
            return this;
        }

        public Builder annexureTextContent(String annexureTextContent) {
            instance.setAnnexureTextContent(annexureTextContent);
            return this;
        }

        public Builder invoiceDateSomany(String invoiceDateSomany) {
            instance.setInvoiceDateSomany(invoiceDateSomany);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder discountRate(java.math.BigDecimal discountRate) {
            instance.setDiscountRate(discountRate);
            return this;
        }

        public Builder grossAmount(java.math.BigDecimal grossAmount) {
            instance.setGrossAmount(grossAmount);
            return this;
        }

        public Builder tdsAmount(java.math.BigDecimal tdsAmount) {
            instance.setTdsAmount(tdsAmount);
            return this;
        }

        public Builder bankCharges(String bankCharges) {
            instance.setBankCharges(bankCharges);
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

        public FgUploadAdvice build() {
            return instance;
        }
    }
}
