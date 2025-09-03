package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgAlkemBd {

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

    private String invoiceCurrency;

    private String exportCountrySap;

    private String customerDescription;

    private String countrySoldToPart;

    private String countryCodeSoldTo;

    private String bLAwbNo;

    private java.time.LocalDateTime billOfLandingAwb;

    private String materialNo;

    private String productDescription;

    private String finalInvNo;

    private java.time.LocalDateTime finalInvDate;

    private String customsInvNo;

    private java.time.LocalDateTime customsInvDate;

    private String shippingBillNo;

    private java.time.LocalDateTime shippingBillDate;

    private String portCode;

    private String portLoad;

    private java.time.LocalDateTime billDueDate;

    private Integer uploadRefID;

    private String iecCode;

    private java.math.BigDecimal finalInvAmount;

    private java.math.BigDecimal invoiceValue;

    private java.math.BigDecimal invoiceQuantity;

    private java.math.BigDecimal declaredDeducted;

    private Long lineNo;

    private String hsCode;

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

    private String bankRefNo;

    private java.time.LocalDateTime baseDate;

    private java.math.BigDecimal billAmount;

    private String billCcy;

    private String buyerCountry1;

    private String buyerCountry2;

    private Integer buyerID;

    private String buyerName;

    private String chargesDbtAccNo;

    private String collectingBank;

    private String customerCrn;

    private String destPortCode;

    private String goodsCode;

    private String goodsDesc;

    private String hsnCode;

    private String incoterms;

    private java.time.LocalDateTime invDate;

    private String invNo;

    private String pordCodeForLoading;

    private java.math.BigDecimal shippingBillAmount;

    private String shippingBillCcy;

    private String softexNumber;

    private Integer tenorInDays;

    private String thirdParty;

    private String thirdPartyAdd;

    private String thirdPartyCountry;

    private String thirdPartyName;

    private String vesselOFlightName;

    public FgAlkemBd() {
    }

    public FgAlkemBd(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String invoiceCurrency, String exportCountrySap, String customerDescription, String countrySoldToPart, String countryCodeSoldTo, String bLAwbNo, java.time.LocalDateTime billOfLandingAwb, String materialNo, String productDescription, String finalInvNo, java.time.LocalDateTime finalInvDate, String customsInvNo, java.time.LocalDateTime customsInvDate, String shippingBillNo, java.time.LocalDateTime shippingBillDate, String portCode, String portLoad, java.time.LocalDateTime billDueDate, Integer uploadRefID, String iecCode, java.math.BigDecimal finalInvAmount, java.math.BigDecimal invoiceValue, java.math.BigDecimal invoiceQuantity, java.math.BigDecimal declaredDeducted, Long lineNo, String hsCode, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName, String bankRefNo, java.time.LocalDateTime baseDate, java.math.BigDecimal billAmount, String billCcy, String buyerCountry1, String buyerCountry2, Integer buyerID, String buyerName, String chargesDbtAccNo, String collectingBank, String customerCrn, String destPortCode, String goodsCode, String goodsDesc, String hsnCode, String incoterms, java.time.LocalDateTime invDate, String invNo, String pordCodeForLoading, java.math.BigDecimal shippingBillAmount, String shippingBillCcy, String softexNumber, Integer tenorInDays, String thirdParty, String thirdPartyAdd, String thirdPartyCountry, String thirdPartyName, String vesselOFlightName) {
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
        this.invoiceCurrency = invoiceCurrency;
        this.exportCountrySap = exportCountrySap;
        this.customerDescription = customerDescription;
        this.countrySoldToPart = countrySoldToPart;
        this.countryCodeSoldTo = countryCodeSoldTo;
        this.bLAwbNo = bLAwbNo;
        this.billOfLandingAwb = billOfLandingAwb;
        this.materialNo = materialNo;
        this.productDescription = productDescription;
        this.finalInvNo = finalInvNo;
        this.finalInvDate = finalInvDate;
        this.customsInvNo = customsInvNo;
        this.customsInvDate = customsInvDate;
        this.shippingBillNo = shippingBillNo;
        this.shippingBillDate = shippingBillDate;
        this.portCode = portCode;
        this.portLoad = portLoad;
        this.billDueDate = billDueDate;
        this.uploadRefID = uploadRefID;
        this.iecCode = iecCode;
        this.finalInvAmount = finalInvAmount;
        this.invoiceValue = invoiceValue;
        this.invoiceQuantity = invoiceQuantity;
        this.declaredDeducted = declaredDeducted;
        this.lineNo = lineNo;
        this.hsCode = hsCode;
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
        this.bankRefNo = bankRefNo;
        this.baseDate = baseDate;
        this.billAmount = billAmount;
        this.billCcy = billCcy;
        this.buyerCountry1 = buyerCountry1;
        this.buyerCountry2 = buyerCountry2;
        this.buyerID = buyerID;
        this.buyerName = buyerName;
        this.chargesDbtAccNo = chargesDbtAccNo;
        this.collectingBank = collectingBank;
        this.customerCrn = customerCrn;
        this.destPortCode = destPortCode;
        this.goodsCode = goodsCode;
        this.goodsDesc = goodsDesc;
        this.hsnCode = hsnCode;
        this.incoterms = incoterms;
        this.invDate = invDate;
        this.invNo = invNo;
        this.pordCodeForLoading = pordCodeForLoading;
        this.shippingBillAmount = shippingBillAmount;
        this.shippingBillCcy = shippingBillCcy;
        this.softexNumber = softexNumber;
        this.tenorInDays = tenorInDays;
        this.thirdParty = thirdParty;
        this.thirdPartyAdd = thirdPartyAdd;
        this.thirdPartyCountry = thirdPartyCountry;
        this.thirdPartyName = thirdPartyName;
        this.vesselOFlightName = vesselOFlightName;
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

    public String getInvoiceCurrency() {
        return invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) {
        this.invoiceCurrency = invoiceCurrency;
    }

    public String getExportCountrySap() {
        return exportCountrySap;
    }

    public void setExportCountrySap(String exportCountrySap) {
        this.exportCountrySap = exportCountrySap;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getCountrySoldToPart() {
        return countrySoldToPart;
    }

    public void setCountrySoldToPart(String countrySoldToPart) {
        this.countrySoldToPart = countrySoldToPart;
    }

    public String getCountryCodeSoldTo() {
        return countryCodeSoldTo;
    }

    public void setCountryCodeSoldTo(String countryCodeSoldTo) {
        this.countryCodeSoldTo = countryCodeSoldTo;
    }

    public String getBLAwbNo() {
        return bLAwbNo;
    }

    public void setBLAwbNo(String bLAwbNo) {
        this.bLAwbNo = bLAwbNo;
    }

    public java.time.LocalDateTime getBillOfLandingAwb() {
        return billOfLandingAwb;
    }

    public void setBillOfLandingAwb(java.time.LocalDateTime billOfLandingAwb) {
        this.billOfLandingAwb = billOfLandingAwb;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getFinalInvNo() {
        return finalInvNo;
    }

    public void setFinalInvNo(String finalInvNo) {
        this.finalInvNo = finalInvNo;
    }

    public java.time.LocalDateTime getFinalInvDate() {
        return finalInvDate;
    }

    public void setFinalInvDate(java.time.LocalDateTime finalInvDate) {
        this.finalInvDate = finalInvDate;
    }

    public String getCustomsInvNo() {
        return customsInvNo;
    }

    public void setCustomsInvNo(String customsInvNo) {
        this.customsInvNo = customsInvNo;
    }

    public java.time.LocalDateTime getCustomsInvDate() {
        return customsInvDate;
    }

    public void setCustomsInvDate(java.time.LocalDateTime customsInvDate) {
        this.customsInvDate = customsInvDate;
    }

    public String getShippingBillNo() {
        return shippingBillNo;
    }

    public void setShippingBillNo(String shippingBillNo) {
        this.shippingBillNo = shippingBillNo;
    }

    public java.time.LocalDateTime getShippingBillDate() {
        return shippingBillDate;
    }

    public void setShippingBillDate(java.time.LocalDateTime shippingBillDate) {
        this.shippingBillDate = shippingBillDate;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getPortLoad() {
        return portLoad;
    }

    public void setPortLoad(String portLoad) {
        this.portLoad = portLoad;
    }

    public java.time.LocalDateTime getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(java.time.LocalDateTime billDueDate) {
        this.billDueDate = billDueDate;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getIecCode() {
        return iecCode;
    }

    public void setIecCode(String iecCode) {
        this.iecCode = iecCode;
    }

    public java.math.BigDecimal getFinalInvAmount() {
        return finalInvAmount;
    }

    public void setFinalInvAmount(java.math.BigDecimal finalInvAmount) {
        this.finalInvAmount = finalInvAmount;
    }

    public java.math.BigDecimal getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(java.math.BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public java.math.BigDecimal getInvoiceQuantity() {
        return invoiceQuantity;
    }

    public void setInvoiceQuantity(java.math.BigDecimal invoiceQuantity) {
        this.invoiceQuantity = invoiceQuantity;
    }

    public java.math.BigDecimal getDeclaredDeducted() {
        return declaredDeducted;
    }

    public void setDeclaredDeducted(java.math.BigDecimal declaredDeducted) {
        this.declaredDeducted = declaredDeducted;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
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

    public String getBankRefNo() {
        return bankRefNo;
    }

    public void setBankRefNo(String bankRefNo) {
        this.bankRefNo = bankRefNo;
    }

    public java.time.LocalDateTime getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(java.time.LocalDateTime baseDate) {
        this.baseDate = baseDate;
    }

    public java.math.BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(java.math.BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCcy() {
        return billCcy;
    }

    public void setBillCcy(String billCcy) {
        this.billCcy = billCcy;
    }

    public String getBuyerCountry1() {
        return buyerCountry1;
    }

    public void setBuyerCountry1(String buyerCountry1) {
        this.buyerCountry1 = buyerCountry1;
    }

    public String getBuyerCountry2() {
        return buyerCountry2;
    }

    public void setBuyerCountry2(String buyerCountry2) {
        this.buyerCountry2 = buyerCountry2;
    }

    public Integer getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getChargesDbtAccNo() {
        return chargesDbtAccNo;
    }

    public void setChargesDbtAccNo(String chargesDbtAccNo) {
        this.chargesDbtAccNo = chargesDbtAccNo;
    }

    public String getCollectingBank() {
        return collectingBank;
    }

    public void setCollectingBank(String collectingBank) {
        this.collectingBank = collectingBank;
    }

    public String getCustomerCrn() {
        return customerCrn;
    }

    public void setCustomerCrn(String customerCrn) {
        this.customerCrn = customerCrn;
    }

    public String getDestPortCode() {
        return destPortCode;
    }

    public void setDestPortCode(String destPortCode) {
        this.destPortCode = destPortCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getPordCodeForLoading() {
        return pordCodeForLoading;
    }

    public void setPordCodeForLoading(String pordCodeForLoading) {
        this.pordCodeForLoading = pordCodeForLoading;
    }

    public java.math.BigDecimal getShippingBillAmount() {
        return shippingBillAmount;
    }

    public void setShippingBillAmount(java.math.BigDecimal shippingBillAmount) {
        this.shippingBillAmount = shippingBillAmount;
    }

    public String getShippingBillCcy() {
        return shippingBillCcy;
    }

    public void setShippingBillCcy(String shippingBillCcy) {
        this.shippingBillCcy = shippingBillCcy;
    }

    public String getSoftexNumber() {
        return softexNumber;
    }

    public void setSoftexNumber(String softexNumber) {
        this.softexNumber = softexNumber;
    }

    public Integer getTenorInDays() {
        return tenorInDays;
    }

    public void setTenorInDays(Integer tenorInDays) {
        this.tenorInDays = tenorInDays;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getThirdPartyAdd() {
        return thirdPartyAdd;
    }

    public void setThirdPartyAdd(String thirdPartyAdd) {
        this.thirdPartyAdd = thirdPartyAdd;
    }

    public String getThirdPartyCountry() {
        return thirdPartyCountry;
    }

    public void setThirdPartyCountry(String thirdPartyCountry) {
        this.thirdPartyCountry = thirdPartyCountry;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getVesselOFlightName() {
        return vesselOFlightName;
    }

    public void setVesselOFlightName(String vesselOFlightName) {
        this.vesselOFlightName = vesselOFlightName;
    }

    public static class Builder {

        private FgAlkemBd instance = new FgAlkemBd();

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

        public Builder invoiceCurrency(String invoiceCurrency) {
            instance.setInvoiceCurrency(invoiceCurrency);
            return this;
        }

        public Builder exportCountrySap(String exportCountrySap) {
            instance.setExportCountrySap(exportCountrySap);
            return this;
        }

        public Builder customerDescription(String customerDescription) {
            instance.setCustomerDescription(customerDescription);
            return this;
        }

        public Builder countrySoldToPart(String countrySoldToPart) {
            instance.setCountrySoldToPart(countrySoldToPart);
            return this;
        }

        public Builder countryCodeSoldTo(String countryCodeSoldTo) {
            instance.setCountryCodeSoldTo(countryCodeSoldTo);
            return this;
        }

        public Builder bLAwbNo(String bLAwbNo) {
            instance.setBLAwbNo(bLAwbNo);
            return this;
        }

        public Builder billOfLandingAwb(java.time.LocalDateTime billOfLandingAwb) {
            instance.setBillOfLandingAwb(billOfLandingAwb);
            return this;
        }

        public Builder materialNo(String materialNo) {
            instance.setMaterialNo(materialNo);
            return this;
        }

        public Builder productDescription(String productDescription) {
            instance.setProductDescription(productDescription);
            return this;
        }

        public Builder finalInvNo(String finalInvNo) {
            instance.setFinalInvNo(finalInvNo);
            return this;
        }

        public Builder finalInvDate(java.time.LocalDateTime finalInvDate) {
            instance.setFinalInvDate(finalInvDate);
            return this;
        }

        public Builder customsInvNo(String customsInvNo) {
            instance.setCustomsInvNo(customsInvNo);
            return this;
        }

        public Builder customsInvDate(java.time.LocalDateTime customsInvDate) {
            instance.setCustomsInvDate(customsInvDate);
            return this;
        }

        public Builder shippingBillNo(String shippingBillNo) {
            instance.setShippingBillNo(shippingBillNo);
            return this;
        }

        public Builder shippingBillDate(java.time.LocalDateTime shippingBillDate) {
            instance.setShippingBillDate(shippingBillDate);
            return this;
        }

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
            return this;
        }

        public Builder portLoad(String portLoad) {
            instance.setPortLoad(portLoad);
            return this;
        }

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            instance.setBillDueDate(billDueDate);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder iecCode(String iecCode) {
            instance.setIecCode(iecCode);
            return this;
        }

        public Builder finalInvAmount(java.math.BigDecimal finalInvAmount) {
            instance.setFinalInvAmount(finalInvAmount);
            return this;
        }

        public Builder invoiceValue(java.math.BigDecimal invoiceValue) {
            instance.setInvoiceValue(invoiceValue);
            return this;
        }

        public Builder invoiceQuantity(java.math.BigDecimal invoiceQuantity) {
            instance.setInvoiceQuantity(invoiceQuantity);
            return this;
        }

        public Builder declaredDeducted(java.math.BigDecimal declaredDeducted) {
            instance.setDeclaredDeducted(declaredDeducted);
            return this;
        }

        public Builder lineNo(Long lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public Builder hsCode(String hsCode) {
            instance.setHsCode(hsCode);
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

        public Builder bankRefNo(String bankRefNo) {
            instance.setBankRefNo(bankRefNo);
            return this;
        }

        public Builder baseDate(java.time.LocalDateTime baseDate) {
            instance.setBaseDate(baseDate);
            return this;
        }

        public Builder billAmount(java.math.BigDecimal billAmount) {
            instance.setBillAmount(billAmount);
            return this;
        }

        public Builder billCcy(String billCcy) {
            instance.setBillCcy(billCcy);
            return this;
        }

        public Builder buyerCountry1(String buyerCountry1) {
            instance.setBuyerCountry1(buyerCountry1);
            return this;
        }

        public Builder buyerCountry2(String buyerCountry2) {
            instance.setBuyerCountry2(buyerCountry2);
            return this;
        }

        public Builder buyerID(Integer buyerID) {
            instance.setBuyerID(buyerID);
            return this;
        }

        public Builder buyerName(String buyerName) {
            instance.setBuyerName(buyerName);
            return this;
        }

        public Builder chargesDbtAccNo(String chargesDbtAccNo) {
            instance.setChargesDbtAccNo(chargesDbtAccNo);
            return this;
        }

        public Builder collectingBank(String collectingBank) {
            instance.setCollectingBank(collectingBank);
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            instance.setCustomerCrn(customerCrn);
            return this;
        }

        public Builder destPortCode(String destPortCode) {
            instance.setDestPortCode(destPortCode);
            return this;
        }

        public Builder goodsCode(String goodsCode) {
            instance.setGoodsCode(goodsCode);
            return this;
        }

        public Builder goodsDesc(String goodsDesc) {
            instance.setGoodsDesc(goodsDesc);
            return this;
        }

        public Builder hsnCode(String hsnCode) {
            instance.setHsnCode(hsnCode);
            return this;
        }

        public Builder incoterms(String incoterms) {
            instance.setIncoterms(incoterms);
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder pordCodeForLoading(String pordCodeForLoading) {
            instance.setPordCodeForLoading(pordCodeForLoading);
            return this;
        }

        public Builder shippingBillAmount(java.math.BigDecimal shippingBillAmount) {
            instance.setShippingBillAmount(shippingBillAmount);
            return this;
        }

        public Builder shippingBillCcy(String shippingBillCcy) {
            instance.setShippingBillCcy(shippingBillCcy);
            return this;
        }

        public Builder softexNumber(String softexNumber) {
            instance.setSoftexNumber(softexNumber);
            return this;
        }

        public Builder tenorInDays(Integer tenorInDays) {
            instance.setTenorInDays(tenorInDays);
            return this;
        }

        public Builder thirdParty(String thirdParty) {
            instance.setThirdParty(thirdParty);
            return this;
        }

        public Builder thirdPartyAdd(String thirdPartyAdd) {
            instance.setThirdPartyAdd(thirdPartyAdd);
            return this;
        }

        public Builder thirdPartyCountry(String thirdPartyCountry) {
            instance.setThirdPartyCountry(thirdPartyCountry);
            return this;
        }

        public Builder thirdPartyName(String thirdPartyName) {
            instance.setThirdPartyName(thirdPartyName);
            return this;
        }

        public Builder vesselOFlightName(String vesselOFlightName) {
            instance.setVesselOFlightName(vesselOFlightName);
            return this;
        }

        public FgAlkemBd build() {
            return instance;
        }
    }
}
