package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgClearanceErp {

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

    private String invoiceNo;

    private java.time.LocalDateTime invoiceDate;

    private java.math.BigDecimal invoiceAmount;

    private String shipperName;

    private String shipperAdrs1;

    private String shipperAdrs2;

    private String receiverName;

    private String receiverAdrs1;

    private String receiverAdrs2;

    public FgClearanceErp() {
    }

    public FgClearanceErp(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String invoiceNo, java.time.LocalDateTime invoiceDate, java.math.BigDecimal invoiceAmount, String shipperName, String shipperAdrs1, String shipperAdrs2, String receiverName, String receiverAdrs1, String receiverAdrs2) {
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
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.shipperName = shipperName;
        this.shipperAdrs1 = shipperAdrs1;
        this.shipperAdrs2 = shipperAdrs2;
        this.receiverName = receiverName;
        this.receiverAdrs1 = receiverAdrs1;
        this.receiverAdrs2 = receiverAdrs2;
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

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public java.time.LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(java.time.LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperAdrs1() {
        return shipperAdrs1;
    }

    public void setShipperAdrs1(String shipperAdrs1) {
        this.shipperAdrs1 = shipperAdrs1;
    }

    public String getShipperAdrs2() {
        return shipperAdrs2;
    }

    public void setShipperAdrs2(String shipperAdrs2) {
        this.shipperAdrs2 = shipperAdrs2;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAdrs1() {
        return receiverAdrs1;
    }

    public void setReceiverAdrs1(String receiverAdrs1) {
        this.receiverAdrs1 = receiverAdrs1;
    }

    public String getReceiverAdrs2() {
        return receiverAdrs2;
    }

    public void setReceiverAdrs2(String receiverAdrs2) {
        this.receiverAdrs2 = receiverAdrs2;
    }

    public static class Builder {

        private FgClearanceErp instance = new FgClearanceErp();

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

        public Builder invoiceNo(String invoiceNo) {
            instance.setInvoiceNo(invoiceNo);
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            instance.setInvoiceDate(invoiceDate);
            return this;
        }

        public Builder invoiceAmount(java.math.BigDecimal invoiceAmount) {
            instance.setInvoiceAmount(invoiceAmount);
            return this;
        }

        public Builder shipperName(String shipperName) {
            instance.setShipperName(shipperName);
            return this;
        }

        public Builder shipperAdrs1(String shipperAdrs1) {
            instance.setShipperAdrs1(shipperAdrs1);
            return this;
        }

        public Builder shipperAdrs2(String shipperAdrs2) {
            instance.setShipperAdrs2(shipperAdrs2);
            return this;
        }

        public Builder receiverName(String receiverName) {
            instance.setReceiverName(receiverName);
            return this;
        }

        public Builder receiverAdrs1(String receiverAdrs1) {
            instance.setReceiverAdrs1(receiverAdrs1);
            return this;
        }

        public Builder receiverAdrs2(String receiverAdrs2) {
            instance.setReceiverAdrs2(receiverAdrs2);
            return this;
        }

        public FgClearanceErp build() {
            return instance;
        }
    }
}
