package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TdAccountList {

    private String applicantParty;

    private String accountName;

    private String tdAccount;

    private String accountNo;

    private java.math.BigDecimal liqDepositAmount;

    private java.math.BigDecimal maturityAmount;

    private String accountSchemeCode;

    private java.time.LocalDateTime startDate;

    private java.time.LocalDateTime liqMaturityDate;

    private String startDateDisplay;

    private String liqMaturityDateDisplay;

    private java.math.BigDecimal availableBalance;

    private java.time.LocalDateTime endDate;

    private String freezeedAccount;

    private java.math.BigDecimal lienAmount;

    private java.math.BigDecimal liqInterestRate;

    public TdAccountList() {
    }

    public TdAccountList(String applicantParty, String accountName, String tdAccount, String accountNo, java.math.BigDecimal liqDepositAmount, java.math.BigDecimal maturityAmount, String accountSchemeCode, java.time.LocalDateTime startDate, java.time.LocalDateTime liqMaturityDate, String startDateDisplay, String liqMaturityDateDisplay, java.math.BigDecimal availableBalance, java.time.LocalDateTime endDate, String freezeedAccount, java.math.BigDecimal lienAmount, java.math.BigDecimal liqInterestRate) {
        this.applicantParty = applicantParty;
        this.accountName = accountName;
        this.tdAccount = tdAccount;
        this.accountNo = accountNo;
        this.liqDepositAmount = liqDepositAmount;
        this.maturityAmount = maturityAmount;
        this.accountSchemeCode = accountSchemeCode;
        this.startDate = startDate;
        this.liqMaturityDate = liqMaturityDate;
        this.startDateDisplay = startDateDisplay;
        this.liqMaturityDateDisplay = liqMaturityDateDisplay;
        this.availableBalance = availableBalance;
        this.endDate = endDate;
        this.freezeedAccount = freezeedAccount;
        this.lienAmount = lienAmount;
        this.liqInterestRate = liqInterestRate;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTdAccount() {
        return tdAccount;
    }

    public void setTdAccount(String tdAccount) {
        this.tdAccount = tdAccount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public java.math.BigDecimal getLiqDepositAmount() {
        return liqDepositAmount;
    }

    public void setLiqDepositAmount(java.math.BigDecimal liqDepositAmount) {
        this.liqDepositAmount = liqDepositAmount;
    }

    public java.math.BigDecimal getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(java.math.BigDecimal maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public String getAccountSchemeCode() {
        return accountSchemeCode;
    }

    public void setAccountSchemeCode(String accountSchemeCode) {
        this.accountSchemeCode = accountSchemeCode;
    }

    public java.time.LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(java.time.LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public java.time.LocalDateTime getLiqMaturityDate() {
        return liqMaturityDate;
    }

    public void setLiqMaturityDate(java.time.LocalDateTime liqMaturityDate) {
        this.liqMaturityDate = liqMaturityDate;
    }

    public String getStartDateDisplay() {
        return startDateDisplay;
    }

    public void setStartDateDisplay(String startDateDisplay) {
        this.startDateDisplay = startDateDisplay;
    }

    public String getLiqMaturityDateDisplay() {
        return liqMaturityDateDisplay;
    }

    public void setLiqMaturityDateDisplay(String liqMaturityDateDisplay) {
        this.liqMaturityDateDisplay = liqMaturityDateDisplay;
    }

    public java.math.BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(java.math.BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public java.time.LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(java.time.LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getFreezeedAccount() {
        return freezeedAccount;
    }

    public void setFreezeedAccount(String freezeedAccount) {
        this.freezeedAccount = freezeedAccount;
    }

    public java.math.BigDecimal getLienAmount() {
        return lienAmount;
    }

    public void setLienAmount(java.math.BigDecimal lienAmount) {
        this.lienAmount = lienAmount;
    }

    public java.math.BigDecimal getLiqInterestRate() {
        return liqInterestRate;
    }

    public void setLiqInterestRate(java.math.BigDecimal liqInterestRate) {
        this.liqInterestRate = liqInterestRate;
    }

    public static class Builder {

        private TdAccountList instance = new TdAccountList();

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder accountName(String accountName) {
            instance.setAccountName(accountName);
            return this;
        }

        public Builder tdAccount(String tdAccount) {
            instance.setTdAccount(tdAccount);
            return this;
        }

        public Builder accountNo(String accountNo) {
            instance.setAccountNo(accountNo);
            return this;
        }

        public Builder liqDepositAmount(java.math.BigDecimal liqDepositAmount) {
            instance.setLiqDepositAmount(liqDepositAmount);
            return this;
        }

        public Builder maturityAmount(java.math.BigDecimal maturityAmount) {
            instance.setMaturityAmount(maturityAmount);
            return this;
        }

        public Builder accountSchemeCode(String accountSchemeCode) {
            instance.setAccountSchemeCode(accountSchemeCode);
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public Builder liqMaturityDate(java.time.LocalDateTime liqMaturityDate) {
            instance.setLiqMaturityDate(liqMaturityDate);
            return this;
        }

        public Builder startDateDisplay(String startDateDisplay) {
            instance.setStartDateDisplay(startDateDisplay);
            return this;
        }

        public Builder liqMaturityDateDisplay(String liqMaturityDateDisplay) {
            instance.setLiqMaturityDateDisplay(liqMaturityDateDisplay);
            return this;
        }

        public Builder availableBalance(java.math.BigDecimal availableBalance) {
            instance.setAvailableBalance(availableBalance);
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public Builder freezeedAccount(String freezeedAccount) {
            instance.setFreezeedAccount(freezeedAccount);
            return this;
        }

        public Builder lienAmount(java.math.BigDecimal lienAmount) {
            instance.setLienAmount(lienAmount);
            return this;
        }

        public Builder liqInterestRate(java.math.BigDecimal liqInterestRate) {
            instance.setLiqInterestRate(liqInterestRate);
            return this;
        }

        public TdAccountList build() {
            return instance;
        }
    }
}
