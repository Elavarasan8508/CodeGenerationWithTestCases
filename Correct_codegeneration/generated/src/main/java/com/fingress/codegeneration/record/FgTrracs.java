package com.bsit.codegeneration.record;

public record FgTrracs(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String sbNo, java.time.LocalDateTime sbDate, String invoiceCcy, String ieCodeSb, String portCode, String formNo, Long invSlNo, String irmNo, String irmAd, Long irmAmt, String irmCcy, java.time.LocalDateTime irmDate, String irmName, String irmCountry, String irmBankCountry, String boeNum, java.time.LocalDateTime boeDate, String portOfDis, String importAgency, String invNum, String termsOfInv, String invoiceSlNo, Long invAmt, String ormNumber, String adCode, Long ormAmount, Long ormUtilizedAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String invNo, String irmBankName, String irmSwiftBankRefNo, Long osAmtIrm, String invCcy, Long osInvAmt, String beneName, String beneCountry, String remitterBankName, String purOfRemit, java.time.LocalDateTime overduePeriod, String supplierName, String supplierAddr, String supplierCountry, String sellerName, String sellerAddr, String sellerCountry, String ieCode, Long utilizedInvAmt, Long ormOsAmt, String ieCodeOrm) {

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

        private String sbNo;

        private java.time.LocalDateTime sbDate;

        private String invoiceCcy;

        private String ieCodeSb;

        private String portCode;

        private String formNo;

        private Long invSlNo;

        private String irmNo;

        private String irmAd;

        private Long irmAmt;

        private String irmCcy;

        private java.time.LocalDateTime irmDate;

        private String irmName;

        private String irmCountry;

        private String irmBankCountry;

        private String boeNum;

        private java.time.LocalDateTime boeDate;

        private String portOfDis;

        private String importAgency;

        private String invNum;

        private String termsOfInv;

        private String invoiceSlNo;

        private Long invAmt;

        private String ormNumber;

        private String adCode;

        private Long ormAmount;

        private Long ormUtilizedAmt;

        private String ormCcy;

        private java.time.LocalDateTime ormDate;

        private String ieName;

        private String invNo;

        private String irmBankName;

        private String irmSwiftBankRefNo;

        private Long osAmtIrm;

        private String invCcy;

        private Long osInvAmt;

        private String beneName;

        private String beneCountry;

        private String remitterBankName;

        private String purOfRemit;

        private java.time.LocalDateTime overduePeriod;

        private String supplierName;

        private String supplierAddr;

        private String supplierCountry;

        private String sellerName;

        private String sellerAddr;

        private String sellerCountry;

        private String ieCode;

        private Long utilizedInvAmt;

        private Long ormOsAmt;

        private String ieCodeOrm;

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

        public Builder sbNo(String sbNo) {
            this.sbNo = sbNo;
            return this;
        }

        public Builder sbDate(java.time.LocalDateTime sbDate) {
            this.sbDate = sbDate;
            return this;
        }

        public Builder invoiceCcy(String invoiceCcy) {
            this.invoiceCcy = invoiceCcy;
            return this;
        }

        public Builder ieCodeSb(String ieCodeSb) {
            this.ieCodeSb = ieCodeSb;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder formNo(String formNo) {
            this.formNo = formNo;
            return this;
        }

        public Builder invSlNo(Long invSlNo) {
            this.invSlNo = invSlNo;
            return this;
        }

        public Builder irmNo(String irmNo) {
            this.irmNo = irmNo;
            return this;
        }

        public Builder irmAd(String irmAd) {
            this.irmAd = irmAd;
            return this;
        }

        public Builder irmAmt(Long irmAmt) {
            this.irmAmt = irmAmt;
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            this.irmDate = irmDate;
            return this;
        }

        public Builder irmName(String irmName) {
            this.irmName = irmName;
            return this;
        }

        public Builder irmCountry(String irmCountry) {
            this.irmCountry = irmCountry;
            return this;
        }

        public Builder irmBankCountry(String irmBankCountry) {
            this.irmBankCountry = irmBankCountry;
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

        public Builder portOfDis(String portOfDis) {
            this.portOfDis = portOfDis;
            return this;
        }

        public Builder importAgency(String importAgency) {
            this.importAgency = importAgency;
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

        public Builder invoiceSlNo(String invoiceSlNo) {
            this.invoiceSlNo = invoiceSlNo;
            return this;
        }

        public Builder invAmt(Long invAmt) {
            this.invAmt = invAmt;
            return this;
        }

        public Builder ormNumber(String ormNumber) {
            this.ormNumber = ormNumber;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder ormAmount(Long ormAmount) {
            this.ormAmount = ormAmount;
            return this;
        }

        public Builder ormUtilizedAmt(Long ormUtilizedAmt) {
            this.ormUtilizedAmt = ormUtilizedAmt;
            return this;
        }

        public Builder ormCcy(String ormCcy) {
            this.ormCcy = ormCcy;
            return this;
        }

        public Builder ormDate(java.time.LocalDateTime ormDate) {
            this.ormDate = ormDate;
            return this;
        }

        public Builder ieName(String ieName) {
            this.ieName = ieName;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder irmBankName(String irmBankName) {
            this.irmBankName = irmBankName;
            return this;
        }

        public Builder irmSwiftBankRefNo(String irmSwiftBankRefNo) {
            this.irmSwiftBankRefNo = irmSwiftBankRefNo;
            return this;
        }

        public Builder osAmtIrm(Long osAmtIrm) {
            this.osAmtIrm = osAmtIrm;
            return this;
        }

        public Builder invCcy(String invCcy) {
            this.invCcy = invCcy;
            return this;
        }

        public Builder osInvAmt(Long osInvAmt) {
            this.osInvAmt = osInvAmt;
            return this;
        }

        public Builder beneName(String beneName) {
            this.beneName = beneName;
            return this;
        }

        public Builder beneCountry(String beneCountry) {
            this.beneCountry = beneCountry;
            return this;
        }

        public Builder remitterBankName(String remitterBankName) {
            this.remitterBankName = remitterBankName;
            return this;
        }

        public Builder purOfRemit(String purOfRemit) {
            this.purOfRemit = purOfRemit;
            return this;
        }

        public Builder overduePeriod(java.time.LocalDateTime overduePeriod) {
            this.overduePeriod = overduePeriod;
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

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder utilizedInvAmt(Long utilizedInvAmt) {
            this.utilizedInvAmt = utilizedInvAmt;
            return this;
        }

        public Builder ormOsAmt(Long ormOsAmt) {
            this.ormOsAmt = ormOsAmt;
            return this;
        }

        public Builder ieCodeOrm(String ieCodeOrm) {
            this.ieCodeOrm = ieCodeOrm;
            return this;
        }

        public FgTrracs build() {
            return new FgTrracs(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, sbNo, sbDate, invoiceCcy, ieCodeSb, portCode, formNo, invSlNo, irmNo, irmAd, irmAmt, irmCcy, irmDate, irmName, irmCountry, irmBankCountry, boeNum, boeDate, portOfDis, importAgency, invNum, termsOfInv, invoiceSlNo, invAmt, ormNumber, adCode, ormAmount, ormUtilizedAmt, ormCcy, ormDate, ieName, invNo, irmBankName, irmSwiftBankRefNo, osAmtIrm, invCcy, osInvAmt, beneName, beneCountry, remitterBankName, purOfRemit, overduePeriod, supplierName, supplierAddr, supplierCountry, sellerName, sellerAddr, sellerCountry, ieCode, utilizedInvAmt, ormOsAmt, ieCodeOrm);
        }
    }
}
