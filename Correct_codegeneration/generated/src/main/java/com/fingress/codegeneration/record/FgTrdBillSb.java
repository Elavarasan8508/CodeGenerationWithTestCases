package com.bsit.codegeneration.record;

public record FgTrdBillSb(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String shippingbillNo, java.time.LocalDateTime sbDate, String formNo, String portCode, Long fobAmt, String fobCcy, String ieCode, Long utilFobAmt, Long invSlNo, String invNo, String expAgency, String adCode, java.time.LocalDateTime leoDate, Long osPeriod, String adBillNo, String sbStatus, String expType, java.time.LocalDateTime invDate, String invStatus, Long freightAmt, String freightCcy, Long utilFreightAmt, Long insAmt, String insCcy, Long utilInsAmt) {

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

        private String shippingbillNo;

        private java.time.LocalDateTime sbDate;

        private String formNo;

        private String portCode;

        private Long fobAmt;

        private String fobCcy;

        private String ieCode;

        private Long utilFobAmt;

        private Long invSlNo;

        private String invNo;

        private String expAgency;

        private String adCode;

        private java.time.LocalDateTime leoDate;

        private Long osPeriod;

        private String adBillNo;

        private String sbStatus;

        private String expType;

        private java.time.LocalDateTime invDate;

        private String invStatus;

        private Long freightAmt;

        private String freightCcy;

        private Long utilFreightAmt;

        private Long insAmt;

        private String insCcy;

        private Long utilInsAmt;

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

        public Builder shippingbillNo(String shippingbillNo) {
            this.shippingbillNo = shippingbillNo;
            return this;
        }

        public Builder sbDate(java.time.LocalDateTime sbDate) {
            this.sbDate = sbDate;
            return this;
        }

        public Builder formNo(String formNo) {
            this.formNo = formNo;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder fobAmt(Long fobAmt) {
            this.fobAmt = fobAmt;
            return this;
        }

        public Builder fobCcy(String fobCcy) {
            this.fobCcy = fobCcy;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder utilFobAmt(Long utilFobAmt) {
            this.utilFobAmt = utilFobAmt;
            return this;
        }

        public Builder invSlNo(Long invSlNo) {
            this.invSlNo = invSlNo;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder expAgency(String expAgency) {
            this.expAgency = expAgency;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder leoDate(java.time.LocalDateTime leoDate) {
            this.leoDate = leoDate;
            return this;
        }

        public Builder osPeriod(Long osPeriod) {
            this.osPeriod = osPeriod;
            return this;
        }

        public Builder adBillNo(String adBillNo) {
            this.adBillNo = adBillNo;
            return this;
        }

        public Builder sbStatus(String sbStatus) {
            this.sbStatus = sbStatus;
            return this;
        }

        public Builder expType(String expType) {
            this.expType = expType;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invStatus(String invStatus) {
            this.invStatus = invStatus;
            return this;
        }

        public Builder freightAmt(Long freightAmt) {
            this.freightAmt = freightAmt;
            return this;
        }

        public Builder freightCcy(String freightCcy) {
            this.freightCcy = freightCcy;
            return this;
        }

        public Builder utilFreightAmt(Long utilFreightAmt) {
            this.utilFreightAmt = utilFreightAmt;
            return this;
        }

        public Builder insAmt(Long insAmt) {
            this.insAmt = insAmt;
            return this;
        }

        public Builder insCcy(String insCcy) {
            this.insCcy = insCcy;
            return this;
        }

        public Builder utilInsAmt(Long utilInsAmt) {
            this.utilInsAmt = utilInsAmt;
            return this;
        }

        public FgTrdBillSb build() {
            return new FgTrdBillSb(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, shippingbillNo, sbDate, formNo, portCode, fobAmt, fobCcy, ieCode, utilFobAmt, invSlNo, invNo, expAgency, adCode, leoDate, osPeriod, adBillNo, sbStatus, expType, invDate, invStatus, freightAmt, freightCcy, utilFreightAmt, insAmt, insCcy, utilInsAmt);
        }
    }
}
