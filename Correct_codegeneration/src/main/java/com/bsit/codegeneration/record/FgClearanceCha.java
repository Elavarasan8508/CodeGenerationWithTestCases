package com.bsit.codegeneration.record;

import java.util.List;

public record FgClearanceCha(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String invoiceNo, java.time.LocalDateTime invoiceDate, Long invoiceAmount, String shipperName, String shipperAdrs1, String shipperAdrs2, String receiverName, String receiverAdrs1, String receiverAdrs2) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private String invoiceNo;

        private java.time.LocalDateTime invoiceDate;

        private Long invoiceAmount;

        private String shipperName;

        private String shipperAdrs1;

        private String shipperAdrs2;

        private String receiverName;

        private String receiverAdrs1;

        private String receiverAdrs2;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceAmount(Long invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder shipperName(String shipperName) {
            this.shipperName = shipperName;
            return this;
        }

        public Builder shipperAdrs1(String shipperAdrs1) {
            this.shipperAdrs1 = shipperAdrs1;
            return this;
        }

        public Builder shipperAdrs2(String shipperAdrs2) {
            this.shipperAdrs2 = shipperAdrs2;
            return this;
        }

        public Builder receiverName(String receiverName) {
            this.receiverName = receiverName;
            return this;
        }

        public Builder receiverAdrs1(String receiverAdrs1) {
            this.receiverAdrs1 = receiverAdrs1;
            return this;
        }

        public Builder receiverAdrs2(String receiverAdrs2) {
            this.receiverAdrs2 = receiverAdrs2;
            return this;
        }

        public FgClearanceCha build() {
            return new FgClearanceCha(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, invoiceNo, invoiceDate, invoiceAmount, shipperName, shipperAdrs1, shipperAdrs2, receiverName, receiverAdrs1, receiverAdrs2);
        }
    }
}
