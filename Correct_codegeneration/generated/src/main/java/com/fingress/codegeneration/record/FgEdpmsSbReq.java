package com.bsit.codegeneration.record;

public record FgEdpmsSbReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String existAd, String newAd, String adjRefNo, Long invSlNo, String invNo, String adjInd, Long adjAmt, String billClInd, String extRefNo, String extBy, java.time.LocalDateTime extDateSb, String remarksSb, String bankRefNo, Long amtUtil, String portcode, String expType, String shipbillno, java.time.LocalDateTime shipbilldate, String formno, String adCode, String ieCode, String expAgency, java.time.LocalDateTime leoDate, Long osPeriod, String adBillNo, String status, java.time.LocalDateTime invDate, String invStatus, Long fobAmt, String fobCcy, Long utilFobAmt, Long freightAmt, String freightCcy, Long utilFreightAmt, Long insAmt, String insCcy, Long utilInsAmt, String masterID, String detailID, String parentRefID, Long parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDecs, String counterParty, String writeOffBy, String writeOffReason, Long sbAmount, String sbCcy, Long sbUtilAmt, Long sbOsAmt, String billrefno, String billNo, String reqType, String remarks, String finalErrorDesc, String finalStatus) {

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

        private String existAd;

        private String newAd;

        private String adjRefNo;

        private Long invSlNo;

        private String invNo;

        private String adjInd;

        private Long adjAmt;

        private String billClInd;

        private String extRefNo;

        private String extBy;

        private java.time.LocalDateTime extDateSb;

        private String remarksSb;

        private String bankRefNo;

        private Long amtUtil;

        private String portcode;

        private String expType;

        private String shipbillno;

        private java.time.LocalDateTime shipbilldate;

        private String formno;

        private String adCode;

        private String ieCode;

        private String expAgency;

        private java.time.LocalDateTime leoDate;

        private Long osPeriod;

        private String adBillNo;

        private String status;

        private java.time.LocalDateTime invDate;

        private String invStatus;

        private Long fobAmt;

        private String fobCcy;

        private Long utilFobAmt;

        private Long freightAmt;

        private String freightCcy;

        private Long utilFreightAmt;

        private Long insAmt;

        private String insCcy;

        private Long utilInsAmt;

        private String masterID;

        private String detailID;

        private String parentRefID;

        private Long parentVersionID;

        private String trracsStatus;

        private String trracsErrorCode;

        private String trracsErrorDecs;

        private String counterParty;

        private String writeOffBy;

        private String writeOffReason;

        private Long sbAmount;

        private String sbCcy;

        private Long sbUtilAmt;

        private Long sbOsAmt;

        private String billrefno;

        private String billNo;

        private String reqType;

        private String remarks;

        private String finalErrorDesc;

        private String finalStatus;

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

        public Builder existAd(String existAd) {
            this.existAd = existAd;
            return this;
        }

        public Builder newAd(String newAd) {
            this.newAd = newAd;
            return this;
        }

        public Builder adjRefNo(String adjRefNo) {
            this.adjRefNo = adjRefNo;
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

        public Builder adjInd(String adjInd) {
            this.adjInd = adjInd;
            return this;
        }

        public Builder adjAmt(Long adjAmt) {
            this.adjAmt = adjAmt;
            return this;
        }

        public Builder billClInd(String billClInd) {
            this.billClInd = billClInd;
            return this;
        }

        public Builder extRefNo(String extRefNo) {
            this.extRefNo = extRefNo;
            return this;
        }

        public Builder extBy(String extBy) {
            this.extBy = extBy;
            return this;
        }

        public Builder extDateSb(java.time.LocalDateTime extDateSb) {
            this.extDateSb = extDateSb;
            return this;
        }

        public Builder remarksSb(String remarksSb) {
            this.remarksSb = remarksSb;
            return this;
        }

        public Builder bankRefNo(String bankRefNo) {
            this.bankRefNo = bankRefNo;
            return this;
        }

        public Builder amtUtil(Long amtUtil) {
            this.amtUtil = amtUtil;
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

        public Builder adCode(String adCode) {
            this.adCode = adCode;
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

        public Builder status(String status) {
            this.status = status;
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

        public Builder fobCcy(String fobCcy) {
            this.fobCcy = fobCcy;
            return this;
        }

        public Builder utilFobAmt(Long utilFobAmt) {
            this.utilFobAmt = utilFobAmt;
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

        public Builder masterID(String masterID) {
            this.masterID = masterID;
            return this;
        }

        public Builder detailID(String detailID) {
            this.detailID = detailID;
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

        public Builder trracsErrorDecs(String trracsErrorDecs) {
            this.trracsErrorDecs = trracsErrorDecs;
            return this;
        }

        public Builder counterParty(String counterParty) {
            this.counterParty = counterParty;
            return this;
        }

        public Builder writeOffBy(String writeOffBy) {
            this.writeOffBy = writeOffBy;
            return this;
        }

        public Builder writeOffReason(String writeOffReason) {
            this.writeOffReason = writeOffReason;
            return this;
        }

        public Builder sbAmount(Long sbAmount) {
            this.sbAmount = sbAmount;
            return this;
        }

        public Builder sbCcy(String sbCcy) {
            this.sbCcy = sbCcy;
            return this;
        }

        public Builder sbUtilAmt(Long sbUtilAmt) {
            this.sbUtilAmt = sbUtilAmt;
            return this;
        }

        public Builder sbOsAmt(Long sbOsAmt) {
            this.sbOsAmt = sbOsAmt;
            return this;
        }

        public Builder billrefno(String billrefno) {
            this.billrefno = billrefno;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            this.finalErrorDesc = finalErrorDesc;
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            this.finalStatus = finalStatus;
            return this;
        }

        public FgEdpmsSbReq build() {
            return new FgEdpmsSbReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, existAd, newAd, adjRefNo, invSlNo, invNo, adjInd, adjAmt, billClInd, extRefNo, extBy, extDateSb, remarksSb, bankRefNo, amtUtil, portcode, expType, shipbillno, shipbilldate, formno, adCode, ieCode, expAgency, leoDate, osPeriod, adBillNo, status, invDate, invStatus, fobAmt, fobCcy, utilFobAmt, freightAmt, freightCcy, utilFreightAmt, insAmt, insCcy, utilInsAmt, masterID, detailID, parentRefID, parentVersionID, trracsStatus, trracsErrorCode, trracsErrorDecs, counterParty, writeOffBy, writeOffReason, sbAmount, sbCcy, sbUtilAmt, sbOsAmt, billrefno, billNo, reqType, remarks, finalErrorDesc, finalStatus);
        }
    }
}
