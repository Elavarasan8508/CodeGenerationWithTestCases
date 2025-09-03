package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgTdTenure {

    private String tenure;

    private java.math.BigDecimal interestRates;

    private String recommended;

    private String interest;

    private String days;

    public FgTdTenure() {
    }

    public FgTdTenure(String tenure, java.math.BigDecimal interestRates, String recommended, String interest, String days) {
        this.tenure = tenure;
        this.interestRates = interestRates;
        this.recommended = recommended;
        this.interest = interest;
        this.days = days;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public java.math.BigDecimal getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(java.math.BigDecimal interestRates) {
        this.interestRates = interestRates;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public static class Builder {

        private FgTdTenure instance = new FgTdTenure();

        public Builder tenure(String tenure) {
            instance.setTenure(tenure);
            return this;
        }

        public Builder interestRates(java.math.BigDecimal interestRates) {
            instance.setInterestRates(interestRates);
            return this;
        }

        public Builder recommended(String recommended) {
            instance.setRecommended(recommended);
            return this;
        }

        public Builder interest(String interest) {
            instance.setInterest(interest);
            return this;
        }

        public Builder days(String days) {
            instance.setDays(days);
            return this;
        }

        public FgTdTenure build() {
            return instance;
        }
    }
}
