package com.bsit.codegeneration.record;

public record FgMbiSb(String billID, String invoiceID, String shippingBillStatus, String billNo, String formno, java.time.LocalDateTime shipbilldate, java.time.LocalDateTime leodate, String adcode, String portcode, String exportAgency, String expType, String ieCode, String adBillNumber, String invoiceStatus, String invNo, java.time.LocalDateTime invDate, Long invSlNo, String fobcurrcode, String frieghtcurrcode, String inscurrcode, Long fobAmt, Long utilFobAmt, Long frieghtAmt, Long utilFrieghtAmt, Long insAmt, Long utilInsAmt, java.time.LocalDateTime leoDate) {

    public static class Builder {

        private String billID;

        private String invoiceID;

        private String shippingBillStatus;

        private String billNo;

        private String formno;

        private java.time.LocalDateTime shipbilldate;

        private java.time.LocalDateTime leodate;

        private String adcode;

        private String portcode;

        private String exportAgency;

        private String expType;

        private String ieCode;

        private String adBillNumber;

        private String invoiceStatus;

        private String invNo;

        private java.time.LocalDateTime invDate;

        private Long invSlNo;

        private String fobcurrcode;

        private String frieghtcurrcode;

        private String inscurrcode;

        private Long fobAmt;

        private Long utilFobAmt;

        private Long frieghtAmt;

        private Long utilFrieghtAmt;

        private Long insAmt;

        private Long utilInsAmt;

        private java.time.LocalDateTime leoDate;

        public Builder billID(String billID) {
            this.billID = billID;
            return this;
        }

        public Builder invoiceID(String invoiceID) {
            this.invoiceID = invoiceID;
            return this;
        }

        public Builder shippingBillStatus(String shippingBillStatus) {
            this.shippingBillStatus = shippingBillStatus;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder formno(String formno) {
            this.formno = formno;
            return this;
        }

        public Builder shipbilldate(java.time.LocalDateTime shipbilldate) {
            this.shipbilldate = shipbilldate;
            return this;
        }

        public Builder leodate(java.time.LocalDateTime leodate) {
            this.leodate = leodate;
            return this;
        }

        public Builder adcode(String adcode) {
            this.adcode = adcode;
            return this;
        }

        public Builder portcode(String portcode) {
            this.portcode = portcode;
            return this;
        }

        public Builder exportAgency(String exportAgency) {
            this.exportAgency = exportAgency;
            return this;
        }

        public Builder expType(String expType) {
            this.expType = expType;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder adBillNumber(String adBillNumber) {
            this.adBillNumber = adBillNumber;
            return this;
        }

        public Builder invoiceStatus(String invoiceStatus) {
            this.invoiceStatus = invoiceStatus;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder invSlNo(Long invSlNo) {
            this.invSlNo = invSlNo;
            return this;
        }

        public Builder fobcurrcode(String fobcurrcode) {
            this.fobcurrcode = fobcurrcode;
            return this;
        }

        public Builder frieghtcurrcode(String frieghtcurrcode) {
            this.frieghtcurrcode = frieghtcurrcode;
            return this;
        }

        public Builder inscurrcode(String inscurrcode) {
            this.inscurrcode = inscurrcode;
            return this;
        }

        public Builder fobAmt(Long fobAmt) {
            this.fobAmt = fobAmt;
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

        public Builder utilFrieghtAmt(Long utilFrieghtAmt) {
            this.utilFrieghtAmt = utilFrieghtAmt;
            return this;
        }

        public Builder insAmt(Long insAmt) {
            this.insAmt = insAmt;
            return this;
        }

        public Builder utilInsAmt(Long utilInsAmt) {
            this.utilInsAmt = utilInsAmt;
            return this;
        }

        public Builder leoDate(java.time.LocalDateTime leoDate) {
            this.leoDate = leoDate;
            return this;
        }

        public FgMbiSb build() {
            return new FgMbiSb(billID, invoiceID, shippingBillStatus, billNo, formno, shipbilldate, leodate, adcode, portcode, exportAgency, expType, ieCode, adBillNumber, invoiceStatus, invNo, invDate, invSlNo, fobcurrcode, frieghtcurrcode, inscurrcode, fobAmt, utilFobAmt, frieghtAmt, utilFrieghtAmt, insAmt, utilInsAmt, leoDate);
        }
    }
}
