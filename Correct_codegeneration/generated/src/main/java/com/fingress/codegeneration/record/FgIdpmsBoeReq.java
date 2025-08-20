package com.bsit.codegeneration.record;

public record FgIdpmsBoeReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String boeNumber, java.time.LocalDateTime boeDate, String portOfDis, String importAgency, String ieCode, java.time.LocalDateTime overduePeriod, String invoiceSlNo, String invNum, String termsOfInv, String invCcy, Long invAmt, String supplierName, String supplierAddr, String supplierCountry, String sellerName, String sellerAddr, String sellerCountry, Long utilizedInvAmt, Long osInvAmt, Long endorsedAmt, String closureIndicator, Long adjAmt, String adjReason, java.time.LocalDateTime extendedDate, String extendedBy, String remarks, String parentRefID, Long parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDesc, String reqType, String finalErrorDesc, String finalErrorCode, String finalStatus, String adCode, String docNo, java.time.LocalDateTime docDate, java.time.LocalDateTime letterDate, String letterNo, String approvedBy, Long checkbox, String rbiStatus, String rbiErrorDesc, String rbiErrorCode) {

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

        private Long endorsedAmt;

        private String closureIndicator;

        private Long adjAmt;

        private String adjReason;

        private java.time.LocalDateTime extendedDate;

        private String extendedBy;

        private String remarks;

        private String parentRefID;

        private Long parentVersionID;

        private String trracsStatus;

        private String trracsErrorCode;

        private String trracsErrorDesc;

        private String reqType;

        private String finalErrorDesc;

        private String finalErrorCode;

        private String finalStatus;

        private String adCode;

        private String docNo;

        private java.time.LocalDateTime docDate;

        private java.time.LocalDateTime letterDate;

        private String letterNo;

        private String approvedBy;

        private Long checkbox;

        private String rbiStatus;

        private String rbiErrorDesc;

        private String rbiErrorCode;

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

        public Builder endorsedAmt(Long endorsedAmt) {
            this.endorsedAmt = endorsedAmt;
            return this;
        }

        public Builder closureIndicator(String closureIndicator) {
            this.closureIndicator = closureIndicator;
            return this;
        }

        public Builder adjAmt(Long adjAmt) {
            this.adjAmt = adjAmt;
            return this;
        }

        public Builder adjReason(String adjReason) {
            this.adjReason = adjReason;
            return this;
        }

        public Builder extendedDate(java.time.LocalDateTime extendedDate) {
            this.extendedDate = extendedDate;
            return this;
        }

        public Builder extendedBy(String extendedBy) {
            this.extendedBy = extendedBy;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
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

        public Builder trracsStatus(String trracsStatus) {
            this.trracsStatus = trracsStatus;
            return this;
        }

        public Builder trracsErrorCode(String trracsErrorCode) {
            this.trracsErrorCode = trracsErrorCode;
            return this;
        }

        public Builder trracsErrorDesc(String trracsErrorDesc) {
            this.trracsErrorDesc = trracsErrorDesc;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            this.finalErrorDesc = finalErrorDesc;
            return this;
        }

        public Builder finalErrorCode(String finalErrorCode) {
            this.finalErrorCode = finalErrorCode;
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            this.finalStatus = finalStatus;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder docNo(String docNo) {
            this.docNo = docNo;
            return this;
        }

        public Builder docDate(java.time.LocalDateTime docDate) {
            this.docDate = docDate;
            return this;
        }

        public Builder letterDate(java.time.LocalDateTime letterDate) {
            this.letterDate = letterDate;
            return this;
        }

        public Builder letterNo(String letterNo) {
            this.letterNo = letterNo;
            return this;
        }

        public Builder approvedBy(String approvedBy) {
            this.approvedBy = approvedBy;
            return this;
        }

        public Builder checkbox(Long checkbox) {
            this.checkbox = checkbox;
            return this;
        }

        public Builder rbiStatus(String rbiStatus) {
            this.rbiStatus = rbiStatus;
            return this;
        }

        public Builder rbiErrorDesc(String rbiErrorDesc) {
            this.rbiErrorDesc = rbiErrorDesc;
            return this;
        }

        public Builder rbiErrorCode(String rbiErrorCode) {
            this.rbiErrorCode = rbiErrorCode;
            return this;
        }

        public FgIdpmsBoeReq build() {
            return new FgIdpmsBoeReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, boeNumber, boeDate, portOfDis, importAgency, ieCode, overduePeriod, invoiceSlNo, invNum, termsOfInv, invCcy, invAmt, supplierName, supplierAddr, supplierCountry, sellerName, sellerAddr, sellerCountry, utilizedInvAmt, osInvAmt, endorsedAmt, closureIndicator, adjAmt, adjReason, extendedDate, extendedBy, remarks, parentRefID, parentVersionID, trracsStatus, trracsErrorCode, trracsErrorDesc, reqType, finalErrorDesc, finalErrorCode, finalStatus, adCode, docNo, docDate, letterDate, letterNo, approvedBy, checkbox, rbiStatus, rbiErrorDesc, rbiErrorCode);
        }
    }
}
