package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class APIOutstandingIrmDetail {

    private String irmNumber;

    private String adCode;

    private java.math.BigDecimal remittanceAmount;

    private java.math.BigDecimal amountOutstanding;

    private String remittanceCurrency;

    private java.time.LocalDateTime remittanceDate;

    private String ieCode;

    private String remitterName;

    public APIOutstandingIrmDetail() {
    }

    public APIOutstandingIrmDetail(String irmNumber, String adCode, java.math.BigDecimal remittanceAmount, java.math.BigDecimal amountOutstanding, String remittanceCurrency, java.time.LocalDateTime remittanceDate, String ieCode, String remitterName) {
        this.irmNumber = irmNumber;
        this.adCode = adCode;
        this.remittanceAmount = remittanceAmount;
        this.amountOutstanding = amountOutstanding;
        this.remittanceCurrency = remittanceCurrency;
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

    public java.math.BigDecimal getRemittanceAmount() {
        return remittanceAmount;
    }

    public void setRemittanceAmount(java.math.BigDecimal remittanceAmount) {
        this.remittanceAmount = remittanceAmount;
    }

    public java.math.BigDecimal getAmountOutstanding() {
        return amountOutstanding;
    }

    public void setAmountOutstanding(java.math.BigDecimal amountOutstanding) {
        this.amountOutstanding = amountOutstanding;
    }

    public String getRemittanceCurrency() {
        return remittanceCurrency;
    }

    public void setRemittanceCurrency(String remittanceCurrency) {
        this.remittanceCurrency = remittanceCurrency;
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

        private APIOutstandingIrmDetail instance = new APIOutstandingIrmDetail();

        public Builder irmNumber(String irmNumber) {
            instance.setIrmNumber(irmNumber);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder remittanceAmount(java.math.BigDecimal remittanceAmount) {
            instance.setRemittanceAmount(remittanceAmount);
            return this;
        }

        public Builder amountOutstanding(java.math.BigDecimal amountOutstanding) {
            instance.setAmountOutstanding(amountOutstanding);
            return this;
        }

        public Builder remittanceCurrency(String remittanceCurrency) {
            instance.setRemittanceCurrency(remittanceCurrency);
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

        public APIOutstandingIrmDetail build() {
            return instance;
        }
    }
}
