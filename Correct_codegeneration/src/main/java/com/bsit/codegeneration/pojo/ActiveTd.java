package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActiveTd {

    private java.time.LocalDateTime effectiveDate;

    private java.math.BigDecimal availableAmount;

    private java.time.LocalDateTime endDate;

    private java.time.LocalDateTime maturityDate;

    private String accountName;

    private java.math.BigDecimal maturityAmount;

    private String tdAccountNo;

    private java.math.BigDecimal interestRate;

    private String linkedAccount;

    private String rn;

    private java.math.BigDecimal depositAmount;

    public ActiveTd() {
    }

    public ActiveTd(java.time.LocalDateTime effectiveDate, java.math.BigDecimal availableAmount, java.time.LocalDateTime endDate, java.time.LocalDateTime maturityDate, String accountName, java.math.BigDecimal maturityAmount, String tdAccountNo, java.math.BigDecimal interestRate, String linkedAccount, String rn, java.math.BigDecimal depositAmount) {
        this.effectiveDate = effectiveDate;
        this.availableAmount = availableAmount;
        this.endDate = endDate;
        this.maturityDate = maturityDate;
        this.accountName = accountName;
        this.maturityAmount = maturityAmount;
        this.tdAccountNo = tdAccountNo;
        this.interestRate = interestRate;
        this.linkedAccount = linkedAccount;
        this.rn = rn;
        this.depositAmount = depositAmount;
    }

    public java.time.LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public java.math.BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(java.math.BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public java.time.LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(java.time.LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public java.math.BigDecimal getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(java.math.BigDecimal maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public String getTdAccountNo() {
        return tdAccountNo;
    }

    public void setTdAccountNo(String tdAccountNo) {
        this.tdAccountNo = tdAccountNo;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getLinkedAccount() {
        return linkedAccount;
    }

    public void setLinkedAccount(String linkedAccount) {
        this.linkedAccount = linkedAccount;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public java.math.BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(java.math.BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public static class Builder {

        private ActiveTd instance = new ActiveTd();

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            instance.setEffectiveDate(effectiveDate);
            return this;
        }

        public Builder availableAmount(java.math.BigDecimal availableAmount) {
            instance.setAvailableAmount(availableAmount);
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder accountName(String accountName) {
            instance.setAccountName(accountName);
            return this;
        }

        public Builder maturityAmount(java.math.BigDecimal maturityAmount) {
            instance.setMaturityAmount(maturityAmount);
            return this;
        }

        public Builder tdAccountNo(String tdAccountNo) {
            instance.setTdAccountNo(tdAccountNo);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder linkedAccount(String linkedAccount) {
            instance.setLinkedAccount(linkedAccount);
            return this;
        }

        public Builder rn(String rn) {
            instance.setRn(rn);
            return this;
        }

        public Builder depositAmount(java.math.BigDecimal depositAmount) {
            instance.setDepositAmount(depositAmount);
            return this;
        }

        public ActiveTd build() {
            return instance;
        }
    }
}
