package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class APIOutstandingOrmDetail {

    private String ormNumber;

    private String adCode;

    private java.math.BigDecimal remittanceAmount;

    private java.math.BigDecimal remittanceUtilizedAmount;

    private java.math.BigDecimal remittanceUnutilizedAmount;

    private String remittanceCurrency;

    private java.time.LocalDateTime remittanceDate;

    private String ieName;

    private String ieCode;

    private String beneficiaryName;

    private String beneficiaryCountry;

    private String purposeOfRemittance;

    public APIOutstandingOrmDetail() {
    }

    public APIOutstandingOrmDetail(String ormNumber, String adCode, java.math.BigDecimal remittanceAmount, java.math.BigDecimal remittanceUtilizedAmount, java.math.BigDecimal remittanceUnutilizedAmount, String remittanceCurrency, java.time.LocalDateTime remittanceDate, String ieName, String ieCode, String beneficiaryName, String beneficiaryCountry, String purposeOfRemittance) {
        this.ormNumber = ormNumber;
        this.adCode = adCode;
        this.remittanceAmount = remittanceAmount;
        this.remittanceUtilizedAmount = remittanceUtilizedAmount;
        this.remittanceUnutilizedAmount = remittanceUnutilizedAmount;
        this.remittanceCurrency = remittanceCurrency;
        this.remittanceDate = remittanceDate;
        this.ieName = ieName;
        this.ieCode = ieCode;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryCountry = beneficiaryCountry;
        this.purposeOfRemittance = purposeOfRemittance;
    }

    public String getOrmNumber() {
        return ormNumber;
    }

    public void setOrmNumber(String ormNumber) {
        this.ormNumber = ormNumber;
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

    public java.math.BigDecimal getRemittanceUtilizedAmount() {
        return remittanceUtilizedAmount;
    }

    public void setRemittanceUtilizedAmount(java.math.BigDecimal remittanceUtilizedAmount) {
        this.remittanceUtilizedAmount = remittanceUtilizedAmount;
    }

    public java.math.BigDecimal getRemittanceUnutilizedAmount() {
        return remittanceUnutilizedAmount;
    }

    public void setRemittanceUnutilizedAmount(java.math.BigDecimal remittanceUnutilizedAmount) {
        this.remittanceUnutilizedAmount = remittanceUnutilizedAmount;
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

    public String getIeName() {
        return ieName;
    }

    public void setIeName(String ieName) {
        this.ieName = ieName;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryCountry() {
        return beneficiaryCountry;
    }

    public void setBeneficiaryCountry(String beneficiaryCountry) {
        this.beneficiaryCountry = beneficiaryCountry;
    }

    public String getPurposeOfRemittance() {
        return purposeOfRemittance;
    }

    public void setPurposeOfRemittance(String purposeOfRemittance) {
        this.purposeOfRemittance = purposeOfRemittance;
    }

    public static class Builder {

        private APIOutstandingOrmDetail instance = new APIOutstandingOrmDetail();

        public Builder ormNumber(String ormNumber) {
            instance.setOrmNumber(ormNumber);
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

        public Builder remittanceUtilizedAmount(java.math.BigDecimal remittanceUtilizedAmount) {
            instance.setRemittanceUtilizedAmount(remittanceUtilizedAmount);
            return this;
        }

        public Builder remittanceUnutilizedAmount(java.math.BigDecimal remittanceUnutilizedAmount) {
            instance.setRemittanceUnutilizedAmount(remittanceUnutilizedAmount);
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

        public Builder ieName(String ieName) {
            instance.setIeName(ieName);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            instance.setBeneficiaryName(beneficiaryName);
            return this;
        }

        public Builder beneficiaryCountry(String beneficiaryCountry) {
            instance.setBeneficiaryCountry(beneficiaryCountry);
            return this;
        }

        public Builder purposeOfRemittance(String purposeOfRemittance) {
            instance.setPurposeOfRemittance(purposeOfRemittance);
            return this;
        }

        public APIOutstandingOrmDetail build() {
            return instance;
        }
    }
}
