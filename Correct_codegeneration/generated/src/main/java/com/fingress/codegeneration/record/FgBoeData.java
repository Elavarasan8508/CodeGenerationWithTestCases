package com.bsit.codegeneration.record;

public record FgBoeData(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String boeNumber, java.time.LocalDateTime boeDate, String portOfDis, String importAgency, String ieCode, java.time.LocalDateTime overduePeriod, String invoiceSlNo, String invNum, String termsOfInv, String invCcy, Long invAmt, String supplierName, String supplierAddr, String supplierCountry, String sellerName, String sellerAddr, String sellerCountry, Long utilizedInvAmt, Long osInvAmt) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String boeNumber;

        private java.time.LocalDateTime boeDate;

        private String portOfDis;

        private String importAgency;

        private String ieCode;

        private java.time.LocalDateTime overduePeriod;

        private String invoiceSlNo;

        private String invNum;

        private String termsOfInv;

        private String invCcy;

        private Long invAmt;

        private String supplierName;

        private String supplierAddr;

        private String supplierCountry;

        private String sellerName;

        private String sellerAddr;

        private String sellerCountry;

        private Long utilizedInvAmt;

        private Long osInvAmt;

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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder portOfDis(String portOfDis) {
            this.portOfDis = portOfDis;
            return this;
        }

        public Builder importAgency(String importAgency) {
            this.importAgency = importAgency;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder overduePeriod(java.time.LocalDateTime overduePeriod) {
            this.overduePeriod = overduePeriod;
            return this;
        }

        public Builder invoiceSlNo(String invoiceSlNo) {
            this.invoiceSlNo = invoiceSlNo;
            return this;
        }

        public Builder invNum(String invNum) {
            this.invNum = invNum;
            return this;
        }

        public Builder termsOfInv(String termsOfInv) {
            this.termsOfInv = termsOfInv;
            return this;
        }

        public Builder invCcy(String invCcy) {
            this.invCcy = invCcy;
            return this;
        }

        public Builder invAmt(Long invAmt) {
            this.invAmt = invAmt;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
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

        public Builder sellerName(String sellerName) {
            this.sellerName = sellerName;
            return this;
        }

        public Builder sellerAddr(String sellerAddr) {
            this.sellerAddr = sellerAddr;
            return this;
        }

        public Builder sellerCountry(String sellerCountry) {
            this.sellerCountry = sellerCountry;
            return this;
        }

        public Builder utilizedInvAmt(Long utilizedInvAmt) {
            this.utilizedInvAmt = utilizedInvAmt;
            return this;
        }

        public Builder osInvAmt(Long osInvAmt) {
            this.osInvAmt = osInvAmt;
            return this;
        }

        public FgBoeData build() {
            return new FgBoeData(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, boeNumber, boeDate, portOfDis, importAgency, ieCode, overduePeriod, invoiceSlNo, invNum, termsOfInv, invCcy, invAmt, supplierName, supplierAddr, supplierCountry, sellerName, sellerAddr, sellerCountry, utilizedInvAmt, osInvAmt);
        }
    }
}
