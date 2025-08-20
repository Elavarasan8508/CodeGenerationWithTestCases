package com.bsit.codegeneration.record;

public record Shippingbilldata(String status, String shipbillno, java.time.LocalDateTime shipbilldate, String portcode, String formno, Long shippingbillamount, String shippingbillcurr, Long utilizedAmt, Long unutilizedAmt, String billrefno, String counterParty) {

    public static class Builder {

        private String status;

        private String shipbillno;

        private java.time.LocalDateTime shipbilldate;

        private String portcode;

        private String formno;

        private Long shippingbillamount;

        private String shippingbillcurr;

        private Long utilizedAmt;

        private Long unutilizedAmt;

        private String billrefno;

        private String counterParty;

        public Builder status(String status) {
            this.status = status;
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

        public Builder portcode(String portcode) {
            this.portcode = portcode;
            return this;
        }

        public Builder formno(String formno) {
            this.formno = formno;
            return this;
        }

        public Builder shippingbillamount(Long shippingbillamount) {
            this.shippingbillamount = shippingbillamount;
            return this;
        }

        public Builder shippingbillcurr(String shippingbillcurr) {
            this.shippingbillcurr = shippingbillcurr;
            return this;
        }

        public Builder utilizedAmt(Long utilizedAmt) {
            this.utilizedAmt = utilizedAmt;
            return this;
        }

        public Builder unutilizedAmt(Long unutilizedAmt) {
            this.unutilizedAmt = unutilizedAmt;
            return this;
        }

        public Builder billrefno(String billrefno) {
            this.billrefno = billrefno;
            return this;
        }

        public Builder counterParty(String counterParty) {
            this.counterParty = counterParty;
            return this;
        }

        public Shippingbilldata build() {
            return new Shippingbilldata(status, shipbillno, shipbilldate, portcode, formno, shippingbillamount, shippingbillcurr, utilizedAmt, unutilizedAmt, billrefno, counterParty);
        }
    }
}
