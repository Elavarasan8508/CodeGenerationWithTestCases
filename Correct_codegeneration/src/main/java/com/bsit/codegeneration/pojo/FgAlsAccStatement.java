package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgAlsAccStatement {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String applicantParty;

    private String fulfillmentParty;

    private Integer isTemplate;

    private String txnType;

    private java.time.LocalDateTime transactionDate;

    private String virtualAccountNumber;

    private java.time.LocalDateTime valueDate;

    private String remarks;

    private String particulars;

    private String currency;

    private java.math.BigDecimal debitAmount;

    private java.math.BigDecimal creditAmount;

    private java.math.BigDecimal balance;

    private String txnStatus;

    private String ledgerType;

    private String tiTheirReference;

    public FgAlsAccStatement() {
    }

    public FgAlsAccStatement(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String txnType, java.time.LocalDateTime transactionDate, String virtualAccountNumber, java.time.LocalDateTime valueDate, String remarks, String particulars, String currency, java.math.BigDecimal debitAmount, java.math.BigDecimal creditAmount, java.math.BigDecimal balance, String txnStatus, String ledgerType, String tiTheirReference) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.txnType = txnType;
        this.transactionDate = transactionDate;
        this.virtualAccountNumber = virtualAccountNumber;
        this.valueDate = valueDate;
        this.remarks = remarks;
        this.particulars = particulars;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.balance = balance;
        this.txnStatus = txnStatus;
        this.ledgerType = ledgerType;
        this.tiTheirReference = tiTheirReference;
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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public java.time.LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(java.time.LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getVirtualAccountNumber() {
        return virtualAccountNumber;
    }

    public void setVirtualAccountNumber(String virtualAccountNumber) {
        this.virtualAccountNumber = virtualAccountNumber;
    }

    public java.time.LocalDateTime getValueDate() {
        return valueDate;
    }

    public void setValueDate(java.time.LocalDateTime valueDate) {
        this.valueDate = valueDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public java.math.BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(java.math.BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public java.math.BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(java.math.BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public java.math.BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(java.math.BigDecimal balance) {
        this.balance = balance;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getLedgerType() {
        return ledgerType;
    }

    public void setLedgerType(String ledgerType) {
        this.ledgerType = ledgerType;
    }

    public String getTiTheirReference() {
        return tiTheirReference;
    }

    public void setTiTheirReference(String tiTheirReference) {
        this.tiTheirReference = tiTheirReference;
    }

    public static class Builder {

        private FgAlsAccStatement instance = new FgAlsAccStatement();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder txnType(String txnType) {
            instance.setTxnType(txnType);
            return this;
        }

        public Builder transactionDate(java.time.LocalDateTime transactionDate) {
            instance.setTransactionDate(transactionDate);
            return this;
        }

        public Builder virtualAccountNumber(String virtualAccountNumber) {
            instance.setVirtualAccountNumber(virtualAccountNumber);
            return this;
        }

        public Builder valueDate(java.time.LocalDateTime valueDate) {
            instance.setValueDate(valueDate);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder particulars(String particulars) {
            instance.setParticulars(particulars);
            return this;
        }

        public Builder currency(String currency) {
            instance.setCurrency(currency);
            return this;
        }

        public Builder debitAmount(java.math.BigDecimal debitAmount) {
            instance.setDebitAmount(debitAmount);
            return this;
        }

        public Builder creditAmount(java.math.BigDecimal creditAmount) {
            instance.setCreditAmount(creditAmount);
            return this;
        }

        public Builder balance(java.math.BigDecimal balance) {
            instance.setBalance(balance);
            return this;
        }

        public Builder txnStatus(String txnStatus) {
            instance.setTxnStatus(txnStatus);
            return this;
        }

        public Builder ledgerType(String ledgerType) {
            instance.setLedgerType(ledgerType);
            return this;
        }

        public Builder tiTheirReference(String tiTheirReference) {
            instance.setTiTheirReference(tiTheirReference);
            return this;
        }

        public FgAlsAccStatement build() {
            return instance;
        }
    }
}
