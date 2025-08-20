package com.bsit.codegeneration.record;

public record FgOrmFuInv(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String invNo, String hsCode, String portOfLoading, String vesselName, String parentRefID, Long parentVersionID, java.time.LocalDateTime invDate, Long invAmount, String invCcy, String boeNum, java.time.LocalDateTime boeDate, String transportDocNum, String portOfDischarge, String goodsDes, String boeAdCode, String countryOrigGood, String boeNumber, Long lineNo, String migrationBoeSuplCountry, String sellerName, String supplierAddr, String supplierCountry, String supplierName) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

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

        private String invNo;

        private String hsCode;

        private String portOfLoading;

        private String vesselName;

        private String parentRefID;

        private Long parentVersionID;

        private java.time.LocalDateTime invDate;

        private Long invAmount;

        private String invCcy;

        private String boeNum;

        private java.time.LocalDateTime boeDate;

        private String transportDocNum;

        private String portOfDischarge;

        private String goodsDes;

        private String boeAdCode;

        private String countryOrigGood;

        private String boeNumber;

        private Long lineNo;

        private String migrationBoeSuplCountry;

        private String sellerName;

        private String supplierAddr;

        private String supplierCountry;

        private String supplierName;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
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

        public Builder processID(String processID) {
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

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public Builder portOfLoading(String portOfLoading) {
            this.portOfLoading = portOfLoading;
            return this;
        }

        public Builder vesselName(String vesselName) {
            this.vesselName = vesselName;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invAmount(Long invAmount) {
            this.invAmount = invAmount;
            return this;
        }

        public Builder invCcy(String invCcy) {
            this.invCcy = invCcy;
            return this;
        }

        public Builder boeNum(String boeNum) {
            this.boeNum = boeNum;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder transportDocNum(String transportDocNum) {
            this.transportDocNum = transportDocNum;
            return this;
        }

        public Builder portOfDischarge(String portOfDischarge) {
            this.portOfDischarge = portOfDischarge;
            return this;
        }

        public Builder goodsDes(String goodsDes) {
            this.goodsDes = goodsDes;
            return this;
        }

        public Builder boeAdCode(String boeAdCode) {
            this.boeAdCode = boeAdCode;
            return this;
        }

        public Builder countryOrigGood(String countryOrigGood) {
            this.countryOrigGood = countryOrigGood;
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder migrationBoeSuplCountry(String migrationBoeSuplCountry) {
            this.migrationBoeSuplCountry = migrationBoeSuplCountry;
            return this;
        }

        public Builder sellerName(String sellerName) {
            this.sellerName = sellerName;
            return this;
        }

        public Builder supplierAddr(String supplierAddr) {
            this.supplierAddr = supplierAddr;
            return this;
        }

        public Builder supplierCountry(String supplierCountry) {
            this.supplierCountry = supplierCountry;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public FgOrmFuInv build() {
            return new FgOrmFuInv(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, invNo, hsCode, portOfLoading, vesselName, parentRefID, parentVersionID, invDate, invAmount, invCcy, boeNum, boeDate, transportDocNum, portOfDischarge, goodsDes, boeAdCode, countryOrigGood, boeNumber, lineNo, migrationBoeSuplCountry, sellerName, supplierAddr, supplierCountry, supplierName);
        }
    }
}
