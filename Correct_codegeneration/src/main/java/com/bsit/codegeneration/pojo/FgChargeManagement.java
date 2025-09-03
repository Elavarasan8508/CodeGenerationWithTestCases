package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgChargeManagement {

    private Integer ID;

    private Integer referenceID;

    private Integer versionID;

    private String partyCode;

    private String partySubTypeCode;

    private String productCode;

    private String eventCode;

    private String categoryCode;

    private String chargeTypeCode;

    private String chargeStatusCode;

    private String chargeCode;

    private String currencyCode;

    private String taxCode;

    private String chargeBasisCode;

    private Integer isRecurring;

    private java.time.LocalDateTime validFrom;

    private java.time.LocalDateTime validTo;

    private java.math.BigDecimal chargeAmount;

    private String uomCode;

    private java.math.BigDecimal limitAmount;

    private java.math.BigDecimal freeLimit;

    private String limitPeriodCode;

    private java.math.BigDecimal chargePercentage;

    private String statusCode;

    private String activeCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    public FgChargeManagement() {
    }

    public FgChargeManagement(Integer ID, Integer referenceID, Integer versionID, String partyCode, String partySubTypeCode, String productCode, String eventCode, String categoryCode, String chargeTypeCode, String chargeStatusCode, String chargeCode, String currencyCode, String taxCode, String chargeBasisCode, Integer isRecurring, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, java.math.BigDecimal chargeAmount, String uomCode, java.math.BigDecimal limitAmount, java.math.BigDecimal freeLimit, String limitPeriodCode, java.math.BigDecimal chargePercentage, String statusCode, String activeCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.versionID = versionID;
        this.partyCode = partyCode;
        this.partySubTypeCode = partySubTypeCode;
        this.productCode = productCode;
        this.eventCode = eventCode;
        this.categoryCode = categoryCode;
        this.chargeTypeCode = chargeTypeCode;
        this.chargeStatusCode = chargeStatusCode;
        this.chargeCode = chargeCode;
        this.currencyCode = currencyCode;
        this.taxCode = taxCode;
        this.chargeBasisCode = chargeBasisCode;
        this.isRecurring = isRecurring;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.chargeAmount = chargeAmount;
        this.uomCode = uomCode;
        this.limitAmount = limitAmount;
        this.freeLimit = freeLimit;
        this.limitPeriodCode = limitPeriodCode;
        this.chargePercentage = chargePercentage;
        this.statusCode = statusCode;
        this.activeCode = activeCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getPartySubTypeCode() {
        return partySubTypeCode;
    }

    public void setPartySubTypeCode(String partySubTypeCode) {
        this.partySubTypeCode = partySubTypeCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getChargeTypeCode() {
        return chargeTypeCode;
    }

    public void setChargeTypeCode(String chargeTypeCode) {
        this.chargeTypeCode = chargeTypeCode;
    }

    public String getChargeStatusCode() {
        return chargeStatusCode;
    }

    public void setChargeStatusCode(String chargeStatusCode) {
        this.chargeStatusCode = chargeStatusCode;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getChargeBasisCode() {
        return chargeBasisCode;
    }

    public void setChargeBasisCode(String chargeBasisCode) {
        this.chargeBasisCode = chargeBasisCode;
    }

    public Integer getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(Integer isRecurring) {
        this.isRecurring = isRecurring;
    }

    public java.time.LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(java.time.LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public java.time.LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(java.time.LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public java.math.BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(java.math.BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public java.math.BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(java.math.BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public java.math.BigDecimal getFreeLimit() {
        return freeLimit;
    }

    public void setFreeLimit(java.math.BigDecimal freeLimit) {
        this.freeLimit = freeLimit;
    }

    public String getLimitPeriodCode() {
        return limitPeriodCode;
    }

    public void setLimitPeriodCode(String limitPeriodCode) {
        this.limitPeriodCode = limitPeriodCode;
    }

    public java.math.BigDecimal getChargePercentage() {
        return chargePercentage;
    }

    public void setChargePercentage(java.math.BigDecimal chargePercentage) {
        this.chargePercentage = chargePercentage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public static class Builder {

        private FgChargeManagement instance = new FgChargeManagement();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            instance.setPartySubTypeCode(partySubTypeCode);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder eventCode(String eventCode) {
            instance.setEventCode(eventCode);
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            instance.setCategoryCode(categoryCode);
            return this;
        }

        public Builder chargeTypeCode(String chargeTypeCode) {
            instance.setChargeTypeCode(chargeTypeCode);
            return this;
        }

        public Builder chargeStatusCode(String chargeStatusCode) {
            instance.setChargeStatusCode(chargeStatusCode);
            return this;
        }

        public Builder chargeCode(String chargeCode) {
            instance.setChargeCode(chargeCode);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder taxCode(String taxCode) {
            instance.setTaxCode(taxCode);
            return this;
        }

        public Builder chargeBasisCode(String chargeBasisCode) {
            instance.setChargeBasisCode(chargeBasisCode);
            return this;
        }

        public Builder isRecurring(Integer isRecurring) {
            instance.setIsRecurring(isRecurring);
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            instance.setValidFrom(validFrom);
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            instance.setValidTo(validTo);
            return this;
        }

        public Builder chargeAmount(java.math.BigDecimal chargeAmount) {
            instance.setChargeAmount(chargeAmount);
            return this;
        }

        public Builder uomCode(String uomCode) {
            instance.setUomCode(uomCode);
            return this;
        }

        public Builder limitAmount(java.math.BigDecimal limitAmount) {
            instance.setLimitAmount(limitAmount);
            return this;
        }

        public Builder freeLimit(java.math.BigDecimal freeLimit) {
            instance.setFreeLimit(freeLimit);
            return this;
        }

        public Builder limitPeriodCode(String limitPeriodCode) {
            instance.setLimitPeriodCode(limitPeriodCode);
            return this;
        }

        public Builder chargePercentage(java.math.BigDecimal chargePercentage) {
            instance.setChargePercentage(chargePercentage);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public FgChargeManagement build() {
            return instance;
        }
    }
}
