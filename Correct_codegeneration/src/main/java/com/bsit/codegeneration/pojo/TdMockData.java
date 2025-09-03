package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TdMockData {

    private Integer bankID;

    private String accountName;

    private String tdAccountNo;

    private String tdAccTemp;

    private Integer cifID;

    private java.math.BigDecimal depositAmount;

    private java.math.BigDecimal maturityAmount;

    private java.time.LocalDateTime effectiveDate;

    private java.time.LocalDateTime maturityDate;

    private java.math.BigDecimal availableAmount;

    private java.time.LocalDateTime endDate;

    private java.math.BigDecimal interestRate;

    private String linkedAccount;

    private String branch;

    public TdMockData() {
    }

    public TdMockData(Integer bankID, String accountName, String tdAccountNo, String tdAccTemp, Integer cifID, java.math.BigDecimal depositAmount, java.math.BigDecimal maturityAmount, java.time.LocalDateTime effectiveDate, java.time.LocalDateTime maturityDate, java.math.BigDecimal availableAmount, java.time.LocalDateTime endDate, java.math.BigDecimal interestRate, String linkedAccount, String branch) {
        this.bankID = bankID;
        this.accountName = accountName;
        this.tdAccountNo = tdAccountNo;
        this.tdAccTemp = tdAccTemp;
        this.cifID = cifID;
        this.depositAmount = depositAmount;
        this.maturityAmount = maturityAmount;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.availableAmount = availableAmount;
        this.endDate = endDate;
        this.interestRate = interestRate;
        this.linkedAccount = linkedAccount;
        this.branch = branch;
    }

    public Integer getBankID() {
        return bankID;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTdAccountNo() {
        return tdAccountNo;
    }

    public void setTdAccountNo(String tdAccountNo) {
        this.tdAccountNo = tdAccountNo;
    }

    public String getTdAccTemp() {
        return tdAccTemp;
    }

    public void setTdAccTemp(String tdAccTemp) {
        this.tdAccTemp = tdAccTemp;
    }

    public Integer getCifID() {
        return cifID;
    }

    public void setCifID(Integer cifID) {
        this.cifID = cifID;
    }

    public java.math.BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(java.math.BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public java.math.BigDecimal getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(java.math.BigDecimal maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public java.time.LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static class Builder {

        private TdMockData instance = new TdMockData();

        public Builder bankID(Integer bankID) {
            instance.setBankID(bankID);
            return this;
        }

        public Builder accountName(String accountName) {
            instance.setAccountName(accountName);
            return this;
        }

        public Builder tdAccountNo(String tdAccountNo) {
            instance.setTdAccountNo(tdAccountNo);
            return this;
        }

        public Builder tdAccTemp(String tdAccTemp) {
            instance.setTdAccTemp(tdAccTemp);
            return this;
        }

        public Builder cifID(Integer cifID) {
            instance.setCifID(cifID);
            return this;
        }

        public Builder depositAmount(java.math.BigDecimal depositAmount) {
            instance.setDepositAmount(depositAmount);
            return this;
        }

        public Builder maturityAmount(java.math.BigDecimal maturityAmount) {
            instance.setMaturityAmount(maturityAmount);
            return this;
        }

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            instance.setEffectiveDate(effectiveDate);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
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

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder linkedAccount(String linkedAccount) {
            instance.setLinkedAccount(linkedAccount);
            return this;
        }

        public Builder branch(String branch) {
            instance.setBranch(branch);
            return this;
        }

        public TdMockData build() {
            return instance;
        }
    }
}
