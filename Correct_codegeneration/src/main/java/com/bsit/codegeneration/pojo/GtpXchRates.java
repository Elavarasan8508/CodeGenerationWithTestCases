package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class GtpXchRates {

    private String bankAbbvName;

    private String isoCode;

    private String baseIsoCode;

    private String brchCode;

    private java.math.BigDecimal buyTtRate;

    private String euroInCurrency;

    private java.math.BigDecimal euroRate;

    private java.math.BigDecimal midTtRate;

    private Long patyVal;

    private java.math.BigDecimal sellTtRate;

    private String updateDate;

    private String startValueDate;

    private String endValueDate;

    public GtpXchRates() {
    }

    public GtpXchRates(String bankAbbvName, String isoCode, String baseIsoCode, String brchCode, java.math.BigDecimal buyTtRate, String euroInCurrency, java.math.BigDecimal euroRate, java.math.BigDecimal midTtRate, Long patyVal, java.math.BigDecimal sellTtRate, String updateDate, String startValueDate, String endValueDate) {
        this.bankAbbvName = bankAbbvName;
        this.isoCode = isoCode;
        this.baseIsoCode = baseIsoCode;
        this.brchCode = brchCode;
        this.buyTtRate = buyTtRate;
        this.euroInCurrency = euroInCurrency;
        this.euroRate = euroRate;
        this.midTtRate = midTtRate;
        this.patyVal = patyVal;
        this.sellTtRate = sellTtRate;
        this.updateDate = updateDate;
        this.startValueDate = startValueDate;
        this.endValueDate = endValueDate;
    }

    public String getBankAbbvName() {
        return bankAbbvName;
    }

    public void setBankAbbvName(String bankAbbvName) {
        this.bankAbbvName = bankAbbvName;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getBaseIsoCode() {
        return baseIsoCode;
    }

    public void setBaseIsoCode(String baseIsoCode) {
        this.baseIsoCode = baseIsoCode;
    }

    public String getBrchCode() {
        return brchCode;
    }

    public void setBrchCode(String brchCode) {
        this.brchCode = brchCode;
    }

    public java.math.BigDecimal getBuyTtRate() {
        return buyTtRate;
    }

    public void setBuyTtRate(java.math.BigDecimal buyTtRate) {
        this.buyTtRate = buyTtRate;
    }

    public String getEuroInCurrency() {
        return euroInCurrency;
    }

    public void setEuroInCurrency(String euroInCurrency) {
        this.euroInCurrency = euroInCurrency;
    }

    public java.math.BigDecimal getEuroRate() {
        return euroRate;
    }

    public void setEuroRate(java.math.BigDecimal euroRate) {
        this.euroRate = euroRate;
    }

    public java.math.BigDecimal getMidTtRate() {
        return midTtRate;
    }

    public void setMidTtRate(java.math.BigDecimal midTtRate) {
        this.midTtRate = midTtRate;
    }

    public Long getPatyVal() {
        return patyVal;
    }

    public void setPatyVal(Long patyVal) {
        this.patyVal = patyVal;
    }

    public java.math.BigDecimal getSellTtRate() {
        return sellTtRate;
    }

    public void setSellTtRate(java.math.BigDecimal sellTtRate) {
        this.sellTtRate = sellTtRate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getStartValueDate() {
        return startValueDate;
    }

    public void setStartValueDate(String startValueDate) {
        this.startValueDate = startValueDate;
    }

    public String getEndValueDate() {
        return endValueDate;
    }

    public void setEndValueDate(String endValueDate) {
        this.endValueDate = endValueDate;
    }

    public static class Builder {

        private GtpXchRates instance = new GtpXchRates();

        public Builder bankAbbvName(String bankAbbvName) {
            instance.setBankAbbvName(bankAbbvName);
            return this;
        }

        public Builder isoCode(String isoCode) {
            instance.setIsoCode(isoCode);
            return this;
        }

        public Builder baseIsoCode(String baseIsoCode) {
            instance.setBaseIsoCode(baseIsoCode);
            return this;
        }

        public Builder brchCode(String brchCode) {
            instance.setBrchCode(brchCode);
            return this;
        }

        public Builder buyTtRate(java.math.BigDecimal buyTtRate) {
            instance.setBuyTtRate(buyTtRate);
            return this;
        }

        public Builder euroInCurrency(String euroInCurrency) {
            instance.setEuroInCurrency(euroInCurrency);
            return this;
        }

        public Builder euroRate(java.math.BigDecimal euroRate) {
            instance.setEuroRate(euroRate);
            return this;
        }

        public Builder midTtRate(java.math.BigDecimal midTtRate) {
            instance.setMidTtRate(midTtRate);
            return this;
        }

        public Builder patyVal(Long patyVal) {
            instance.setPatyVal(patyVal);
            return this;
        }

        public Builder sellTtRate(java.math.BigDecimal sellTtRate) {
            instance.setSellTtRate(sellTtRate);
            return this;
        }

        public Builder updateDate(String updateDate) {
            instance.setUpdateDate(updateDate);
            return this;
        }

        public Builder startValueDate(String startValueDate) {
            instance.setStartValueDate(startValueDate);
            return this;
        }

        public Builder endValueDate(String endValueDate) {
            instance.setEndValueDate(endValueDate);
            return this;
        }

        public GtpXchRates build() {
            return instance;
        }
    }
}
