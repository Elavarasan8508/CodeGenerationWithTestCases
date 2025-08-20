package com.bsit.codegeneration.record;

public record Shippinginvoicedata(String billNo, String shipbillno, java.time.LocalDateTime shipbilldate, String formno, Long invSlNo, String invNo, java.time.LocalDateTime invDate, String ieCode) {

    public static class Builder {

        private String billNo;

        private String shipbillno;

        private java.time.LocalDateTime shipbilldate;

        private String formno;

        private Long invSlNo;

        private String invNo;

        private java.time.LocalDateTime invDate;

        private String ieCode;

        public Builder billNo(String billNo) {
            this.billNo = billNo;
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

        public Builder invSlNo(Long invSlNo) {
            this.invSlNo = invSlNo;
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

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Shippinginvoicedata build() {
            return new Shippinginvoicedata(billNo, shipbillno, shipbilldate, formno, invSlNo, invNo, invDate, ieCode);
        }
    }
}
