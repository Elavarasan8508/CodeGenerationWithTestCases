package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgOnlineImport {

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

    private java.math.BigDecimal finalInvAmount;

    private String finalInvNo;

    private java.time.LocalDateTime finalInvDate;

    private String customsInvNo;

    private java.time.LocalDateTime customsInvDate;

    private String shippingBillNo;

    private java.time.LocalDateTime shippingBillDate;

    private String portCode;

    private String portLoad;

    private java.math.BigDecimal declaredDeducted;

    private java.time.LocalDateTime billDueDate;

    private String iecCode;

    private String invoiceCurrency;

    private String exportCountrySap;

    private java.math.BigDecimal invQuantity;

    private java.math.BigDecimal invoiceValue;

    private String customerDescription;

    private String countrySoldToPart;

    private String countryCodeSoldTo;

    private String bLAwbNo;

    private java.time.LocalDateTime billOfLandingAwb;

    private String materialNo;

    private String productDescription;

    private Integer uploadRefID;

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

    public FgOnlineImport() {
    }

    public FgOnlineImport(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, java.math.BigDecimal finalInvAmount, String finalInvNo, java.time.LocalDateTime finalInvDate, String customsInvNo, java.time.LocalDateTime customsInvDate, String shippingBillNo, java.time.LocalDateTime shippingBillDate, String portCode, String portLoad, java.math.BigDecimal declaredDeducted, java.time.LocalDateTime billDueDate, String iecCode, String invoiceCurrency, String exportCountrySap, java.math.BigDecimal invQuantity, java.math.BigDecimal invoiceValue, String customerDescription, String countrySoldToPart, String countryCodeSoldTo, String bLAwbNo, java.time.LocalDateTime billOfLandingAwb, String materialNo, String productDescription, Integer uploadRefID, Long lineNo, String hsCode, java.math.BigDecimal equivalentAmount, String equivalentCurrency, java.math.BigDecimal displayAmount, String displayCurrency, java.math.BigDecimal authEquivalentAmount, String authEquivalentCurrency, java.math.BigDecimal displayEquivalentAmount, String displayEquivalentCurrency, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, String issuingPartyCode, String fileName) {
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
        this.finalInvAmount = finalInvAmount;
        this.finalInvNo = finalInvNo;
        this.finalInvDate = finalInvDate;
        this.customsInvNo = customsInvNo;
        this.customsInvDate = customsInvDate;
        this.shippingBillNo = shippingBillNo;
        this.shippingBillDate = shippingBillDate;
        this.portCode = portCode;
        this.portLoad = portLoad;
        this.declaredDeducted = declaredDeducted;
        this.billDueDate = billDueDate;
        this.iecCode = iecCode;
        this.invoiceCurrency = invoiceCurrency;
        this.exportCountrySap = exportCountrySap;
        this.invQuantity = invQuantity;
        this.invoiceValue = invoiceValue;
        this.customerDescription = customerDescription;
        this.countrySoldToPart = countrySoldToPart;
        this.countryCodeSoldTo = countryCodeSoldTo;
        this.bLAwbNo = bLAwbNo;
        this.billOfLandingAwb = billOfLandingAwb;
        this.materialNo = materialNo;
        this.productDescription = productDescription;
        this.uploadRefID = uploadRefID;
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

    public java.math.BigDecimal getFinalInvAmount() {
        return finalInvAmount;
    }

    public void setFinalInvAmount(java.math.BigDecimal finalInvAmount) {
        this.finalInvAmount = finalInvAmount;
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

    public java.math.BigDecimal getDeclaredDeducted() {
        return declaredDeducted;
    }

    public void setDeclaredDeducted(java.math.BigDecimal declaredDeducted) {
        this.declaredDeducted = declaredDeducted;
    }

    public java.time.LocalDateTime getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(java.time.LocalDateTime billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getIecCode() {
        return iecCode;
    }

    public void setIecCode(String iecCode) {
        this.iecCode = iecCode;
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

    public java.math.BigDecimal getInvQuantity() {
        return invQuantity;
    }

    public void setInvQuantity(java.math.BigDecimal invQuantity) {
        this.invQuantity = invQuantity;
    }

    public java.math.BigDecimal getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(java.math.BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
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

    public static class Builder {

        private FgOnlineImport instance = new FgOnlineImport();

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

        public Builder finalInvAmount(java.math.BigDecimal finalInvAmount) {
            instance.setFinalInvAmount(finalInvAmount);
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

        public Builder declaredDeducted(java.math.BigDecimal declaredDeducted) {
            instance.setDeclaredDeducted(declaredDeducted);
            return this;
        }

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            instance.setBillDueDate(billDueDate);
            return this;
        }

        public Builder iecCode(String iecCode) {
            instance.setIecCode(iecCode);
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

        public Builder invQuantity(java.math.BigDecimal invQuantity) {
            instance.setInvQuantity(invQuantity);
            return this;
        }

        public Builder invoiceValue(java.math.BigDecimal invoiceValue) {
            instance.setInvoiceValue(invoiceValue);
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

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
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

        public FgOnlineImport build() {
            return instance;
        }
    }
}
