package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgMbiXar {

    private String irmNo;

    private java.time.LocalDateTime irmDate;

    private String adCode;

    private String irmCcy;

    private java.math.BigDecimal irmAmt;

    private java.math.BigDecimal irmOsAmt;

    private java.math.BigDecimal irmUtilAmt;

    private String ieCode;

    private String remitterName;

    private String remitterCountry;

    private String remitBankCountry;

    private String purposeOfRemittance;

    public FgMbiXar() {
    }

    public FgMbiXar(String irmNo, java.time.LocalDateTime irmDate, String adCode, String irmCcy, java.math.BigDecimal irmAmt, java.math.BigDecimal irmOsAmt, java.math.BigDecimal irmUtilAmt, String ieCode, String remitterName, String remitterCountry, String remitBankCountry, String purposeOfRemittance) {
        this.irmNo = irmNo;
        this.irmDate = irmDate;
        this.adCode = adCode;
        this.irmCcy = irmCcy;
        this.irmAmt = irmAmt;
        this.irmOsAmt = irmOsAmt;
        this.irmUtilAmt = irmUtilAmt;
        this.ieCode = ieCode;
        this.remitterName = remitterName;
        this.remitterCountry = remitterCountry;
        this.remitBankCountry = remitBankCountry;
        this.purposeOfRemittance = purposeOfRemittance;
    }

    public String getIrmNo() {
        return irmNo;
    }

    public void setIrmNo(String irmNo) {
        this.irmNo = irmNo;
    }

    public java.time.LocalDateTime getIrmDate() {
        return irmDate;
    }

    public void setIrmDate(java.time.LocalDateTime irmDate) {
        this.irmDate = irmDate;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getIrmCcy() {
        return irmCcy;
    }

    public void setIrmCcy(String irmCcy) {
        this.irmCcy = irmCcy;
    }

    public java.math.BigDecimal getIrmAmt() {
        return irmAmt;
    }

    public void setIrmAmt(java.math.BigDecimal irmAmt) {
        this.irmAmt = irmAmt;
    }

    public java.math.BigDecimal getIrmOsAmt() {
        return irmOsAmt;
    }

    public void setIrmOsAmt(java.math.BigDecimal irmOsAmt) {
        this.irmOsAmt = irmOsAmt;
    }

    public java.math.BigDecimal getIrmUtilAmt() {
        return irmUtilAmt;
    }

    public void setIrmUtilAmt(java.math.BigDecimal irmUtilAmt) {
        this.irmUtilAmt = irmUtilAmt;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName;
    }

    public String getRemitterCountry() {
        return remitterCountry;
    }

    public void setRemitterCountry(String remitterCountry) {
        this.remitterCountry = remitterCountry;
    }

    public String getRemitBankCountry() {
        return remitBankCountry;
    }

    public void setRemitBankCountry(String remitBankCountry) {
        this.remitBankCountry = remitBankCountry;
    }

    public String getPurposeOfRemittance() {
        return purposeOfRemittance;
    }

    public void setPurposeOfRemittance(String purposeOfRemittance) {
        this.purposeOfRemittance = purposeOfRemittance;
    }

    public static class Builder {

        private FgMbiXar instance = new FgMbiXar();

        public Builder irmNo(String irmNo) {
            instance.setIrmNo(irmNo);
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            instance.setIrmDate(irmDate);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            instance.setIrmCcy(irmCcy);
            return this;
        }

        public Builder irmAmt(java.math.BigDecimal irmAmt) {
            instance.setIrmAmt(irmAmt);
            return this;
        }

        public Builder irmOsAmt(java.math.BigDecimal irmOsAmt) {
            instance.setIrmOsAmt(irmOsAmt);
            return this;
        }

        public Builder irmUtilAmt(java.math.BigDecimal irmUtilAmt) {
            instance.setIrmUtilAmt(irmUtilAmt);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder remitterName(String remitterName) {
            instance.setRemitterName(remitterName);
            return this;
        }

        public Builder remitterCountry(String remitterCountry) {
            instance.setRemitterCountry(remitterCountry);
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            instance.setRemitBankCountry(remitBankCountry);
            return this;
        }

        public Builder purposeOfRemittance(String purposeOfRemittance) {
            instance.setPurposeOfRemittance(purposeOfRemittance);
            return this;
        }

        public FgMbiXar build() {
            return instance;
        }
    }
}
