package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgTdAccountMaster {

    private String debitAccNum;

    private String accUserName;

    private String userType;

    private java.math.BigDecimal availBalance;

    private String acctType;

    private String acctName;

    private String schemeCode;

    private String ccy;

    public FgTdAccountMaster() {
    }

    public FgTdAccountMaster(String debitAccNum, String accUserName, String userType, java.math.BigDecimal availBalance, String acctType, String acctName, String schemeCode, String ccy) {
        this.debitAccNum = debitAccNum;
        this.accUserName = accUserName;
        this.userType = userType;
        this.availBalance = availBalance;
        this.acctType = acctType;
        this.acctName = acctName;
        this.schemeCode = schemeCode;
        this.ccy = ccy;
    }

    public String getDebitAccNum() {
        return debitAccNum;
    }

    public void setDebitAccNum(String debitAccNum) {
        this.debitAccNum = debitAccNum;
    }

    public String getAccUserName() {
        return accUserName;
    }

    public void setAccUserName(String accUserName) {
        this.accUserName = accUserName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public java.math.BigDecimal getAvailBalance() {
        return availBalance;
    }

    public void setAvailBalance(java.math.BigDecimal availBalance) {
        this.availBalance = availBalance;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public static class Builder {

        private FgTdAccountMaster instance = new FgTdAccountMaster();

        public Builder debitAccNum(String debitAccNum) {
            instance.setDebitAccNum(debitAccNum);
            return this;
        }

        public Builder accUserName(String accUserName) {
            instance.setAccUserName(accUserName);
            return this;
        }

        public Builder userType(String userType) {
            instance.setUserType(userType);
            return this;
        }

        public Builder availBalance(java.math.BigDecimal availBalance) {
            instance.setAvailBalance(availBalance);
            return this;
        }

        public Builder acctType(String acctType) {
            instance.setAcctType(acctType);
            return this;
        }

        public Builder acctName(String acctName) {
            instance.setAcctName(acctName);
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            instance.setSchemeCode(schemeCode);
            return this;
        }

        public Builder ccy(String ccy) {
            instance.setCcy(ccy);
            return this;
        }

        public FgTdAccountMaster build() {
            return instance;
        }
    }
}
