package com.bsit.codegeneration.record;

public record FgMbiEfirc(String fircNumber, String adCode, Long fircAmt, Long fircUtilAmt, Long fircOsAmt, String fircCcy, java.time.LocalDateTime fircDate, String ieCode, String remitterName, String remitterCountry, String remitBankCountry) {

    public static class Builder {

        private String fircNumber;

        private String adCode;

        private Long fircAmt;

        private Long fircUtilAmt;

        private Long fircOsAmt;

        private String fircCcy;

        private java.time.LocalDateTime fircDate;

        private String ieCode;

        private String remitterName;

        private String remitterCountry;

        private String remitBankCountry;

        public Builder fircNumber(String fircNumber) {
            this.fircNumber = fircNumber;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder fircAmt(Long fircAmt) {
            this.fircAmt = fircAmt;
            return this;
        }

        public Builder fircUtilAmt(Long fircUtilAmt) {
            this.fircUtilAmt = fircUtilAmt;
            return this;
        }

        public Builder fircOsAmt(Long fircOsAmt) {
            this.fircOsAmt = fircOsAmt;
            return this;
        }

        public Builder fircCcy(String fircCcy) {
            this.fircCcy = fircCcy;
            return this;
        }

        public Builder fircDate(java.time.LocalDateTime fircDate) {
            this.fircDate = fircDate;
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

        public FgMbiEfirc build() {
            return new FgMbiEfirc(fircNumber, adCode, fircAmt, fircUtilAmt, fircOsAmt, fircCcy, fircDate, ieCode, remitterName, remitterCountry, remitBankCountry);
        }
    }
}
