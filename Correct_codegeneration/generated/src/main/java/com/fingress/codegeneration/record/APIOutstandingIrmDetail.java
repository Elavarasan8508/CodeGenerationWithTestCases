package com.bsit.codegeneration.record;

public record APIOutstandingIrmDetail(String irmNumber, String adCode, Long remittanceAmount, Long amountOutstanding, String remittanceCurrency, java.time.LocalDateTime remittanceDate, String ieCode, String remitterName) {

    public static class Builder {

        private String irmNumber;

        private String adCode;

        private Long remittanceAmount;

        private Long amountOutstanding;

        private String remittanceCurrency;

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

        public Builder remittanceAmount(Long remittanceAmount) {
            this.remittanceAmount = remittanceAmount;
            return this;
        }

        public Builder amountOutstanding(Long amountOutstanding) {
            this.amountOutstanding = amountOutstanding;
            return this;
        }

        public Builder remittanceCurrency(String remittanceCurrency) {
            this.remittanceCurrency = remittanceCurrency;
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

        public APIOutstandingIrmDetail build() {
            return new APIOutstandingIrmDetail(irmNumber, adCode, remittanceAmount, amountOutstanding, remittanceCurrency, remittanceDate, ieCode, remitterName);
        }
    }
}
