package com.bsit.codegeneration.record;

public record APIOutstandingOrmDetail(String ormNumber, String adCode, Long remittanceAmount, Long remittanceUtilizedAmount, Long remittanceUnutilizedAmount, String remittanceCurrency, java.time.LocalDateTime remittanceDate, String ieName, String ieCode, String beneficiaryName, String beneficiaryCountry, String purposeOfRemittance) {

    public static class Builder {

        private String ormNumber;

        private String adCode;

        private Long remittanceAmount;

        private Long remittanceUtilizedAmount;

        private Long remittanceUnutilizedAmount;

        private String remittanceCurrency;

        private java.time.LocalDateTime remittanceDate;

        private String ieName;

        private String ieCode;

        private String beneficiaryName;

        private String beneficiaryCountry;

        private String purposeOfRemittance;

        public Builder ormNumber(String ormNumber) {
            this.ormNumber = ormNumber;
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

        public Builder remittanceUtilizedAmount(Long remittanceUtilizedAmount) {
            this.remittanceUtilizedAmount = remittanceUtilizedAmount;
            return this;
        }

        public Builder remittanceUnutilizedAmount(Long remittanceUnutilizedAmount) {
            this.remittanceUnutilizedAmount = remittanceUnutilizedAmount;
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

        public Builder ieName(String ieName) {
            this.ieName = ieName;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder beneficiaryCountry(String beneficiaryCountry) {
            this.beneficiaryCountry = beneficiaryCountry;
            return this;
        }

        public Builder purposeOfRemittance(String purposeOfRemittance) {
            this.purposeOfRemittance = purposeOfRemittance;
            return this;
        }

        public APIOutstandingOrmDetail build() {
            return new APIOutstandingOrmDetail(ormNumber, adCode, remittanceAmount, remittanceUtilizedAmount, remittanceUnutilizedAmount, remittanceCurrency, remittanceDate, ieName, ieCode, beneficiaryName, beneficiaryCountry, purposeOfRemittance);
        }
    }
}
