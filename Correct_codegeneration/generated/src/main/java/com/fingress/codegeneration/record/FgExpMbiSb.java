package com.bsit.codegeneration.record;

public record FgExpMbiSb(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String shipbillno, java.time.LocalDateTime shipbilldate, String formno, String ieCode, String expAgency, String adcode, java.time.LocalDateTime leodate, Long osPeriod, String adBillNo, String sbStatus, Long invSlNo, String invNo, String portcode, String expType, java.time.LocalDateTime invDate, String invStatus, Long fobAmt, String fobcurrcode, Long utilFobAmt, Long frieghtAmt, String frieghtcurrcode, Long utilFrieghtAmt, Long insAmt, String inscurrcode, Long utilInsAmt, String hsCode, String goodDesc, String portOfDest, String transportDocNo, String billNo, Long sbAmount, Long sbOsAmt, Long totalSettledAmt, Long billUtilAmt, Long billAmt, String parentRefID, Long parentVersionID, Long sbShortfall, String sbReason, Long endorsedAmt, String billType) {

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

        private String shipbillno;

        private java.time.LocalDateTime shipbilldate;

        private String formno;

        private String ieCode;

        private String expAgency;

        private String adcode;

        private java.time.LocalDateTime leodate;

        private Long osPeriod;

        private String adBillNo;

        private String sbStatus;

        private Long invSlNo;

        private String invNo;

        private String portcode;

        private String expType;

        private java.time.LocalDateTime invDate;

        private String invStatus;

        private Long fobAmt;

        private String fobcurrcode;

        private Long utilFobAmt;

        private Long frieghtAmt;

        private String frieghtcurrcode;

        private Long utilFrieghtAmt;

        private Long insAmt;

        private String inscurrcode;

        private Long utilInsAmt;

        private String hsCode;

        private String goodDesc;

        private String portOfDest;

        private String transportDocNo;

        private String billNo;

        private Long sbAmount;

        private Long sbOsAmt;

        private Long totalSettledAmt;

        private Long billUtilAmt;

        private Long billAmt;

        private String parentRefID;

        private Long parentVersionID;

        private Long sbShortfall;

        private String sbReason;

        private Long endorsedAmt;

        private String billType;

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

        public Builder shipbillno(String shipbillno) {
            this.shipbillno = shipbillno;
            return this;
        }

        public Builder shipbilldate(java.time.LocalDateTime shipbilldate) {
            this.shipbilldate = shipbilldate;
            return this;
        }

        public Builder formno(String formno) {
            this.formno = formno;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder expAgency(String expAgency) {
            this.expAgency = expAgency;
            return this;
        }

        public Builder adcode(String adcode) {
            this.adcode = adcode;
            return this;
        }

        public Builder leodate(java.time.LocalDateTime leodate) {
            this.leodate = leodate;
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

        public Builder invSlNo(Long invSlNo) {
            this.invSlNo = invSlNo;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder portcode(String portcode) {
            this.portcode = portcode;
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

        public Builder fobAmt(Long fobAmt) {
            this.fobAmt = fobAmt;
            return this;
        }

        public Builder fobcurrcode(String fobcurrcode) {
            this.fobcurrcode = fobcurrcode;
            return this;
        }

        public Builder utilFobAmt(Long utilFobAmt) {
            this.utilFobAmt = utilFobAmt;
            return this;
        }

        public Builder frieghtAmt(Long frieghtAmt) {
            this.frieghtAmt = frieghtAmt;
            return this;
        }

        public Builder frieghtcurrcode(String frieghtcurrcode) {
            this.frieghtcurrcode = frieghtcurrcode;
            return this;
        }

        public Builder utilFrieghtAmt(Long utilFrieghtAmt) {
            this.utilFrieghtAmt = utilFrieghtAmt;
            return this;
        }

        public Builder insAmt(Long insAmt) {
            this.insAmt = insAmt;
            return this;
        }

        public Builder inscurrcode(String inscurrcode) {
            this.inscurrcode = inscurrcode;
            return this;
        }

        public Builder utilInsAmt(Long utilInsAmt) {
            this.utilInsAmt = utilInsAmt;
            return this;
        }

        public Builder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public Builder goodDesc(String goodDesc) {
            this.goodDesc = goodDesc;
            return this;
        }

        public Builder portOfDest(String portOfDest) {
            this.portOfDest = portOfDest;
            return this;
        }

        public Builder transportDocNo(String transportDocNo) {
            this.transportDocNo = transportDocNo;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder sbAmount(Long sbAmount) {
            this.sbAmount = sbAmount;
            return this;
        }

        public Builder sbOsAmt(Long sbOsAmt) {
            this.sbOsAmt = sbOsAmt;
            return this;
        }

        public Builder totalSettledAmt(Long totalSettledAmt) {
            this.totalSettledAmt = totalSettledAmt;
            return this;
        }

        public Builder billUtilAmt(Long billUtilAmt) {
            this.billUtilAmt = billUtilAmt;
            return this;
        }

        public Builder billAmt(Long billAmt) {
            this.billAmt = billAmt;
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

        public Builder sbShortfall(Long sbShortfall) {
            this.sbShortfall = sbShortfall;
            return this;
        }

        public Builder sbReason(String sbReason) {
            this.sbReason = sbReason;
            return this;
        }

        public Builder endorsedAmt(Long endorsedAmt) {
            this.endorsedAmt = endorsedAmt;
            return this;
        }

        public Builder billType(String billType) {
            this.billType = billType;
            return this;
        }

        public FgExpMbiSb build() {
            return new FgExpMbiSb(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, shipbillno, shipbilldate, formno, ieCode, expAgency, adcode, leodate, osPeriod, adBillNo, sbStatus, invSlNo, invNo, portcode, expType, invDate, invStatus, fobAmt, fobcurrcode, utilFobAmt, frieghtAmt, frieghtcurrcode, utilFrieghtAmt, insAmt, inscurrcode, utilInsAmt, hsCode, goodDesc, portOfDest, transportDocNo, billNo, sbAmount, sbOsAmt, totalSettledAmt, billUtilAmt, billAmt, parentRefID, parentVersionID, sbShortfall, sbReason, endorsedAmt, billType);
        }
    }
}
