package com.bsit.codegeneration.record;

public record FgTrdBillIrm(String irmNumber, String adCode, Long irmAmt, Long irmOsAmt, String irmCcy, java.time.LocalDateTime remittanceDate, String ieCode, String remitterName) {

    public static class Builder {

        private String irmNumber;

        private String adCode;

        private Long irmAmt;

        private Long irmOsAmt;

        private String irmCcy;

        private java.time.LocalDateTime remittanceDate;

        private String ieCode;

        private String remitterName;

        public Builder irmNumber(String irmNumber) {
            this.irmNumber = irmNumber;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder irmAmt(Long irmAmt) {
            this.irmAmt = irmAmt;
            return this;
        }

        public Builder irmOsAmt(Long irmOsAmt) {
            this.irmOsAmt = irmOsAmt;
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
            return this;
        }

        public Builder remittanceDate(java.time.LocalDateTime remittanceDate) {
            this.remittanceDate = remittanceDate;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder remitterName(String remitterName) {
            this.remitterName = remitterName;
            return this;
        }

        public FgTrdBillIrm build() {
            return new FgTrdBillIrm(irmNumber, adCode, irmAmt, irmOsAmt, irmCcy, remittanceDate, ieCode, remitterName);
        }
    }
}
