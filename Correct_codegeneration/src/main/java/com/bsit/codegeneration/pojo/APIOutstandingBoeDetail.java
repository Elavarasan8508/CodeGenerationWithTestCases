package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class APIOutstandingBoeDetail {

    private String boeNumber;

    private java.time.LocalDateTime boeDate;

    private String dischargePort;

    private String importAgency;

    private String ieCode;

    private Integer invoiceSerialNumber;

    private String invoiceNumber;

    private String invoiceTerm;

    private String supplierName;

    private String supplierAddress;

    private String supplierCountry;

    private String sellerName;

    private String sellerAddress;

    private String sellerCountry;

    private String fobCurrency;

    private java.math.BigDecimal fobValue;

    private java.math.BigDecimal utilizedFobValue;

    private Integer referenceID;

    public APIOutstandingBoeDetail() {
    }

    public APIOutstandingBoeDetail(String boeNumber, java.time.LocalDateTime boeDate, String dischargePort, String importAgency, String ieCode, Integer invoiceSerialNumber, String invoiceNumber, String invoiceTerm, String supplierName, String supplierAddress, String supplierCountry, String sellerName, String sellerAddress, String sellerCountry, String fobCurrency, java.math.BigDecimal fobValue, java.math.BigDecimal utilizedFobValue, Integer referenceID) {
        this.boeNumber = boeNumber;
        this.boeDate = boeDate;
        this.dischargePort = dischargePort;
        this.importAgency = importAgency;
        this.ieCode = ieCode;
        this.invoiceSerialNumber = invoiceSerialNumber;
        this.invoiceNumber = invoiceNumber;
        this.invoiceTerm = invoiceTerm;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierCountry = supplierCountry;
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerCountry = sellerCountry;
        this.fobCurrency = fobCurrency;
        this.fobValue = fobValue;
        this.utilizedFobValue = utilizedFobValue;
        this.referenceID = referenceID;
    }

    public String getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(String boeNumber) {
        this.boeNumber = boeNumber;
    }

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public String getDischargePort() {
        return dischargePort;
    }

    public void setDischargePort(String dischargePort) {
        this.dischargePort = dischargePort;
    }

    public String getImportAgency() {
        return importAgency;
    }

    public void setImportAgency(String importAgency) {
        this.importAgency = importAgency;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public Integer getInvoiceSerialNumber() {
        return invoiceSerialNumber;
    }

    public void setInvoiceSerialNumber(Integer invoiceSerialNumber) {
        this.invoiceSerialNumber = invoiceSerialNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceTerm() {
        return invoiceTerm;
    }

    public void setInvoiceTerm(String invoiceTerm) {
        this.invoiceTerm = invoiceTerm;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerCountry() {
        return sellerCountry;
    }

    public void setSellerCountry(String sellerCountry) {
        this.sellerCountry = sellerCountry;
    }

    public String getFobCurrency() {
        return fobCurrency;
    }

    public void setFobCurrency(String fobCurrency) {
        this.fobCurrency = fobCurrency;
    }

    public java.math.BigDecimal getFobValue() {
        return fobValue;
    }

    public void setFobValue(java.math.BigDecimal fobValue) {
        this.fobValue = fobValue;
    }

    public java.math.BigDecimal getUtilizedFobValue() {
        return utilizedFobValue;
    }

    public void setUtilizedFobValue(java.math.BigDecimal utilizedFobValue) {
        this.utilizedFobValue = utilizedFobValue;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public static class Builder {

        private APIOutstandingBoeDetail instance = new APIOutstandingBoeDetail();

        public Builder boeNumber(String boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder dischargePort(String dischargePort) {
            instance.setDischargePort(dischargePort);
            return this;
        }

        public Builder importAgency(String importAgency) {
            instance.setImportAgency(importAgency);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder invoiceSerialNumber(Integer invoiceSerialNumber) {
            instance.setInvoiceSerialNumber(invoiceSerialNumber);
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            instance.setInvoiceNumber(invoiceNumber);
            return this;
        }

        public Builder invoiceTerm(String invoiceTerm) {
            instance.setInvoiceTerm(invoiceTerm);
            return this;
        }

        public Builder supplierName(String supplierName) {
            instance.setSupplierName(supplierName);
            return this;
        }

        public Builder supplierAddress(String supplierAddress) {
            instance.setSupplierAddress(supplierAddress);
            return this;
        }

        public Builder supplierCountry(String supplierCountry) {
            instance.setSupplierCountry(supplierCountry);
            return this;
        }

        public Builder sellerName(String sellerName) {
            instance.setSellerName(sellerName);
            return this;
        }

        public Builder sellerAddress(String sellerAddress) {
            instance.setSellerAddress(sellerAddress);
            return this;
        }

        public Builder sellerCountry(String sellerCountry) {
            instance.setSellerCountry(sellerCountry);
            return this;
        }

        public Builder fobCurrency(String fobCurrency) {
            instance.setFobCurrency(fobCurrency);
            return this;
        }

        public Builder fobValue(java.math.BigDecimal fobValue) {
            instance.setFobValue(fobValue);
            return this;
        }

        public Builder utilizedFobValue(java.math.BigDecimal utilizedFobValue) {
            instance.setUtilizedFobValue(utilizedFobValue);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public APIOutstandingBoeDetail build() {
            return instance;
        }
    }
}
