package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdBillIrm {

    private String irmNumber;

    private String adCode;

    private java.math.BigDecimal irmAmt;

    private java.math.BigDecimal irmOsAmt;

    private String irmCcy;

    private java.time.LocalDateTime remittanceDate;

    private String ieCode;

    private String remitterName;

    public FgTrdBillIrm() {
    }

    public FgTrdBillIrm(String irmNumber, String adCode, java.math.BigDecimal irmAmt, java.math.BigDecimal irmOsAmt, String irmCcy, java.time.LocalDateTime remittanceDate, String ieCode, String remitterName) {
        this.irmNumber = irmNumber;
        this.adCode = adCode;
        this.irmAmt = irmAmt;
        this.irmOsAmt = irmOsAmt;
        this.irmCcy = irmCcy;
        this.remittanceDate = remittanceDate;
        this.ieCode = ieCode;
        this.remitterName = remitterName;
    }

    public String getIrmNumber() {
        return irmNumber;
    }

    public void setIrmNumber(String irmNumber) {
        this.irmNumber = irmNumber;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
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

    public String getIrmCcy() {
        return irmCcy;
    }

    public void setIrmCcy(String irmCcy) {
        this.irmCcy = irmCcy;
    }

    public java.time.LocalDateTime getRemittanceDate() {
        return remittanceDate;
    }

    public void setRemittanceDate(java.time.LocalDateTime remittanceDate) {
        this.remittanceDate = remittanceDate;
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

    public static class Builder {

        private FgTrdBillIrm instance = new FgTrdBillIrm();

        public Builder irmNumber(String irmNumber) {
            instance.setIrmNumber(irmNumber);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
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

        public Builder irmCcy(String irmCcy) {
            instance.setIrmCcy(irmCcy);
            return this;
        }

        public Builder remittanceDate(java.time.LocalDateTime remittanceDate) {
            instance.setRemittanceDate(remittanceDate);
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

        public FgTrdBillIrm build() {
            return instance;
        }
    }
}
