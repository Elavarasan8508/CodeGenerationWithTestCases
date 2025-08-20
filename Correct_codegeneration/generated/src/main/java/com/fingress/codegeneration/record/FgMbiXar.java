package com.bsit.codegeneration.record;

public record FgMbiXar(String irmNo, java.time.LocalDateTime irmDate, String adCode, String irmCcy, Long irmAmt, Long irmOsAmt, Long irmUtilAmt, String ieCode, String remitterName, String remitterCountry, String remitBankCountry, String purposeOfRemittance) {

    public static class Builder {

        private String irmNo;

        private java.time.LocalDateTime irmDate;

        private String adCode;

        private String irmCcy;

        private Long irmAmt;

        private Long irmOsAmt;

        private Long irmUtilAmt;

        private String ieCode;

        private String remitterName;

        private String remitterCountry;

        private String remitBankCountry;

        private String purposeOfRemittance;

        public Builder irmNo(String irmNo) {
            this.irmNo = irmNo;
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            this.irmDate = irmDate;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
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

        public Builder irmUtilAmt(Long irmUtilAmt) {
            this.irmUtilAmt = irmUtilAmt;
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

        public Builder remitterCountry(String remitterCountry) {
            this.remitterCountry = remitterCountry;
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            this.remitBankCountry = remitBankCountry;
            return this;
        }

        public Builder purposeOfRemittance(String purposeOfRemittance) {
            this.purposeOfRemittance = purposeOfRemittance;
            return this;
        }

        public FgMbiXar build() {
            return new FgMbiXar(irmNo, irmDate, adCode, irmCcy, irmAmt, irmOsAmt, irmUtilAmt, ieCode, remitterName, remitterCountry, remitBankCountry, purposeOfRemittance);
        }
    }
}
