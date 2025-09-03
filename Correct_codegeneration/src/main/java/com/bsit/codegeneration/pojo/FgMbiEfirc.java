package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgMbiEfirc {

    private String fircNumber;

    private String adCode;

    private java.math.BigDecimal fircAmt;

    private java.math.BigDecimal fircUtilAmt;

    private java.math.BigDecimal fircOsAmt;

    private String fircCcy;

    private java.time.LocalDateTime fircDate;

    private String ieCode;

    private String remitterName;

    private String remitterCountry;

    private String remitBankCountry;

    public FgMbiEfirc() {
    }

    public FgMbiEfirc(String fircNumber, String adCode, java.math.BigDecimal fircAmt, java.math.BigDecimal fircUtilAmt, java.math.BigDecimal fircOsAmt, String fircCcy, java.time.LocalDateTime fircDate, String ieCode, String remitterName, String remitterCountry, String remitBankCountry) {
        this.fircNumber = fircNumber;
        this.adCode = adCode;
        this.fircAmt = fircAmt;
        this.fircUtilAmt = fircUtilAmt;
        this.fircOsAmt = fircOsAmt;
        this.fircCcy = fircCcy;
        this.fircDate = fircDate;
        this.ieCode = ieCode;
        this.remitterName = remitterName;
        this.remitterCountry = remitterCountry;
        this.remitBankCountry = remitBankCountry;
    }

    public String getFircNumber() {
        return fircNumber;
    }

    public void setFircNumber(String fircNumber) {
        this.fircNumber = fircNumber;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public java.math.BigDecimal getFircAmt() {
        return fircAmt;
    }

    public void setFircAmt(java.math.BigDecimal fircAmt) {
        this.fircAmt = fircAmt;
    }

    public java.math.BigDecimal getFircUtilAmt() {
        return fircUtilAmt;
    }

    public void setFircUtilAmt(java.math.BigDecimal fircUtilAmt) {
        this.fircUtilAmt = fircUtilAmt;
    }

    public java.math.BigDecimal getFircOsAmt() {
        return fircOsAmt;
    }

    public void setFircOsAmt(java.math.BigDecimal fircOsAmt) {
        this.fircOsAmt = fircOsAmt;
    }

    public String getFircCcy() {
        return fircCcy;
    }

    public void setFircCcy(String fircCcy) {
        this.fircCcy = fircCcy;
    }

    public java.time.LocalDateTime getFircDate() {
        return fircDate;
    }

    public void setFircDate(java.time.LocalDateTime fircDate) {
        this.fircDate = fircDate;
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

    public static class Builder {

        private FgMbiEfirc instance = new FgMbiEfirc();

        public Builder fircNumber(String fircNumber) {
            instance.setFircNumber(fircNumber);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder fircAmt(java.math.BigDecimal fircAmt) {
            instance.setFircAmt(fircAmt);
            return this;
        }

        public Builder fircUtilAmt(java.math.BigDecimal fircUtilAmt) {
            instance.setFircUtilAmt(fircUtilAmt);
            return this;
        }

        public Builder fircOsAmt(java.math.BigDecimal fircOsAmt) {
            instance.setFircOsAmt(fircOsAmt);
            return this;
        }

        public Builder fircCcy(String fircCcy) {
            instance.setFircCcy(fircCcy);
            return this;
        }

        public Builder fircDate(java.time.LocalDateTime fircDate) {
            instance.setFircDate(fircDate);
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

        public FgMbiEfirc build() {
            return instance;
        }
    }
}
