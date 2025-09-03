package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FxRateTd {

    private String intTblCode;

    private String crncyCode;

    private String intSlabSrlNum;

    private Integer maxPeriodRunMths;

    private Integer maxPeriodRunDays;

    private java.math.BigDecimal beginSlabAmount;

    private java.math.BigDecimal maxSlabAmount;

    private java.math.BigDecimal nrmlIntPcnt;

    public FxRateTd() {
    }

    public FxRateTd(String intTblCode, String crncyCode, String intSlabSrlNum, Integer maxPeriodRunMths, Integer maxPeriodRunDays, java.math.BigDecimal beginSlabAmount, java.math.BigDecimal maxSlabAmount, java.math.BigDecimal nrmlIntPcnt) {
        this.intTblCode = intTblCode;
        this.crncyCode = crncyCode;
        this.intSlabSrlNum = intSlabSrlNum;
        this.maxPeriodRunMths = maxPeriodRunMths;
        this.maxPeriodRunDays = maxPeriodRunDays;
        this.beginSlabAmount = beginSlabAmount;
        this.maxSlabAmount = maxSlabAmount;
        this.nrmlIntPcnt = nrmlIntPcnt;
    }

    public String getIntTblCode() {
        return intTblCode;
    }

    public void setIntTblCode(String intTblCode) {
        this.intTblCode = intTblCode;
    }

    public String getCrncyCode() {
        return crncyCode;
    }

    public void setCrncyCode(String crncyCode) {
        this.crncyCode = crncyCode;
    }

    public String getIntSlabSrlNum() {
        return intSlabSrlNum;
    }

    public void setIntSlabSrlNum(String intSlabSrlNum) {
        this.intSlabSrlNum = intSlabSrlNum;
    }

    public Integer getMaxPeriodRunMths() {
        return maxPeriodRunMths;
    }

    public void setMaxPeriodRunMths(Integer maxPeriodRunMths) {
        this.maxPeriodRunMths = maxPeriodRunMths;
    }

    public Integer getMaxPeriodRunDays() {
        return maxPeriodRunDays;
    }

    public void setMaxPeriodRunDays(Integer maxPeriodRunDays) {
        this.maxPeriodRunDays = maxPeriodRunDays;
    }

    public java.math.BigDecimal getBeginSlabAmount() {
        return beginSlabAmount;
    }

    public void setBeginSlabAmount(java.math.BigDecimal beginSlabAmount) {
        this.beginSlabAmount = beginSlabAmount;
    }

    public java.math.BigDecimal getMaxSlabAmount() {
        return maxSlabAmount;
    }

    public void setMaxSlabAmount(java.math.BigDecimal maxSlabAmount) {
        this.maxSlabAmount = maxSlabAmount;
    }

    public java.math.BigDecimal getNrmlIntPcnt() {
        return nrmlIntPcnt;
    }

    public void setNrmlIntPcnt(java.math.BigDecimal nrmlIntPcnt) {
        this.nrmlIntPcnt = nrmlIntPcnt;
    }

    public static class Builder {

        private FxRateTd instance = new FxRateTd();

        public Builder intTblCode(String intTblCode) {
            instance.setIntTblCode(intTblCode);
            return this;
        }

        public Builder crncyCode(String crncyCode) {
            instance.setCrncyCode(crncyCode);
            return this;
        }

        public Builder intSlabSrlNum(String intSlabSrlNum) {
            instance.setIntSlabSrlNum(intSlabSrlNum);
            return this;
        }

        public Builder maxPeriodRunMths(Integer maxPeriodRunMths) {
            instance.setMaxPeriodRunMths(maxPeriodRunMths);
            return this;
        }

        public Builder maxPeriodRunDays(Integer maxPeriodRunDays) {
            instance.setMaxPeriodRunDays(maxPeriodRunDays);
            return this;
        }

        public Builder beginSlabAmount(java.math.BigDecimal beginSlabAmount) {
            instance.setBeginSlabAmount(beginSlabAmount);
            return this;
        }

        public Builder maxSlabAmount(java.math.BigDecimal maxSlabAmount) {
            instance.setMaxSlabAmount(maxSlabAmount);
            return this;
        }

        public Builder nrmlIntPcnt(java.math.BigDecimal nrmlIntPcnt) {
            instance.setNrmlIntPcnt(nrmlIntPcnt);
            return this;
        }

        public FxRateTd build() {
            return instance;
        }
    }
}
