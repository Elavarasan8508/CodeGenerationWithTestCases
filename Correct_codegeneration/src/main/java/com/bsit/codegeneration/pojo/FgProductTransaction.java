package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgProductTransaction {

    private Integer ID;

    private Integer paymentID;

    private Integer entityReferenceID;

    private java.time.LocalDateTime transactionDate;

    private String currencyCode;

    private java.math.BigDecimal transactionAmount;

    private String description;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    public FgProductTransaction() {
    }

    public FgProductTransaction(Integer ID, Integer paymentID, Integer entityReferenceID, java.time.LocalDateTime transactionDate, String currencyCode, java.math.BigDecimal transactionAmount, String description, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy) {
        this.ID = ID;
        this.paymentID = paymentID;
        this.entityReferenceID = entityReferenceID;
        this.transactionDate = transactionDate;
        this.currencyCode = currencyCode;
        this.transactionAmount = transactionAmount;
        this.description = description;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getEntityReferenceID() {
        return entityReferenceID;
    }

    public void setEntityReferenceID(Integer entityReferenceID) {
        this.entityReferenceID = entityReferenceID;
    }

    public java.time.LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(java.time.LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public java.math.BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(java.math.BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public static class Builder {

        private FgProductTransaction instance = new FgProductTransaction();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder paymentID(Integer paymentID) {
            instance.setPaymentID(paymentID);
            return this;
        }

        public Builder entityReferenceID(Integer entityReferenceID) {
            instance.setEntityReferenceID(entityReferenceID);
            return this;
        }

        public Builder transactionDate(java.time.LocalDateTime transactionDate) {
            instance.setTransactionDate(transactionDate);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder transactionAmount(java.math.BigDecimal transactionAmount) {
            instance.setTransactionAmount(transactionAmount);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
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

        public FgProductTransaction build() {
            return instance;
        }
    }
}
