package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class APIOutstandingEfircDetail {

    private String fircNumber;

    private java.math.BigDecimal remittanceAmount;

    private java.math.BigDecimal amountUtilized;

    private java.math.BigDecimal amountOutstanding;

    private String swiftCode;

    private java.time.LocalDateTime fircIssueDate;

    private String ieCode;

    private String remitterName;

    private String remitterCountry;

    private String remitterBankCountry;

    private String fircAdCode;

    public APIOutstandingEfircDetail() {
    }

    public APIOutstandingEfircDetail(String fircNumber, java.math.BigDecimal remittanceAmount, java.math.BigDecimal amountUtilized, java.math.BigDecimal amountOutstanding, String swiftCode, java.time.LocalDateTime fircIssueDate, String ieCode, String remitterName, String remitterCountry, String remitterBankCountry, String fircAdCode) {
        this.fircNumber = fircNumber;
        this.remittanceAmount = remittanceAmount;
        this.amountUtilized = amountUtilized;
        this.amountOutstanding = amountOutstanding;
        this.swiftCode = swiftCode;
        this.fircIssueDate = fircIssueDate;
        this.ieCode = ieCode;
        this.remitterName = remitterName;
        this.remitterCountry = remitterCountry;
        this.remitterBankCountry = remitterBankCountry;
        this.fircAdCode = fircAdCode;
    }

    public String getFircNumber() {
        return fircNumber;
    }

    public void setFircNumber(String fircNumber) {
        this.fircNumber = fircNumber;
    }

    public java.math.BigDecimal getRemittanceAmount() {
        return remittanceAmount;
    }

    public void setRemittanceAmount(java.math.BigDecimal remittanceAmount) {
        this.remittanceAmount = remittanceAmount;
    }

    public java.math.BigDecimal getAmountUtilized() {
        return amountUtilized;
    }

    public void setAmountUtilized(java.math.BigDecimal amountUtilized) {
        this.amountUtilized = amountUtilized;
    }

    public java.math.BigDecimal getAmountOutstanding() {
        return amountOutstanding;
    }

    public void setAmountOutstanding(java.math.BigDecimal amountOutstanding) {
        this.amountOutstanding = amountOutstanding;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public java.time.LocalDateTime getFircIssueDate() {
        return fircIssueDate;
    }

    public void setFircIssueDate(java.time.LocalDateTime fircIssueDate) {
        this.fircIssueDate = fircIssueDate;
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

    public String getRemitterBankCountry() {
        return remitterBankCountry;
    }

    public void setRemitterBankCountry(String remitterBankCountry) {
        this.remitterBankCountry = remitterBankCountry;
    }

    public String getFircAdCode() {
        return fircAdCode;
    }

    public void setFircAdCode(String fircAdCode) {
        this.fircAdCode = fircAdCode;
    }

    public static class Builder {

        private APIOutstandingEfircDetail instance = new APIOutstandingEfircDetail();

        public Builder fircNumber(String fircNumber) {
            instance.setFircNumber(fircNumber);
            return this;
        }

        public Builder remittanceAmount(java.math.BigDecimal remittanceAmount) {
            instance.setRemittanceAmount(remittanceAmount);
            return this;
        }

        public Builder amountUtilized(java.math.BigDecimal amountUtilized) {
            instance.setAmountUtilized(amountUtilized);
            return this;
        }

        public Builder amountOutstanding(java.math.BigDecimal amountOutstanding) {
            instance.setAmountOutstanding(amountOutstanding);
            return this;
        }

        public Builder swiftCode(String swiftCode) {
            instance.setSwiftCode(swiftCode);
            return this;
        }

        public Builder fircIssueDate(java.time.LocalDateTime fircIssueDate) {
            instance.setFircIssueDate(fircIssueDate);
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

        public Builder remitterBankCountry(String remitterBankCountry) {
            instance.setRemitterBankCountry(remitterBankCountry);
            return this;
        }

        public Builder fircAdCode(String fircAdCode) {
            instance.setFircAdCode(fircAdCode);
            return this;
        }

        public APIOutstandingEfircDetail build() {
            return instance;
        }
    }
}
