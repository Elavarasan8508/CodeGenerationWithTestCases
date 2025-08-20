package com.bsit.codegeneration.record;

public record APIOutstandingEfircDetail(String fircNumber, Long remittanceAmount, Long amountUtilized, Long amountOutstanding, String swiftCode, java.time.LocalDateTime fircIssueDate, String ieCode, String remitterName, String remitterCountry, String remitterBankCountry, String fircAdCode) {

    public static class Builder {

        private String fircNumber;

        private Long remittanceAmount;

        private Long amountUtilized;

        private Long amountOutstanding;

        private String swiftCode;

        private java.time.LocalDateTime fircIssueDate;

        private String ieCode;

        private String remitterName;

        private String remitterCountry;

        private String remitterBankCountry;

        private String fircAdCode;

        public Builder fircNumber(String fircNumber) {
            this.fircNumber = fircNumber;
            return this;
        }

        public Builder remittanceAmount(Long remittanceAmount) {
            this.remittanceAmount = remittanceAmount;
            return this;
        }

        public Builder amountUtilized(Long amountUtilized) {
            this.amountUtilized = amountUtilized;
            return this;
        }

        public Builder amountOutstanding(Long amountOutstanding) {
            this.amountOutstanding = amountOutstanding;
            return this;
        }

        public Builder swiftCode(String swiftCode) {
            this.swiftCode = swiftCode;
            return this;
        }

        public Builder fircIssueDate(java.time.LocalDateTime fircIssueDate) {
            this.fircIssueDate = fircIssueDate;
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

        public Builder remitterBankCountry(String remitterBankCountry) {
            this.remitterBankCountry = remitterBankCountry;
            return this;
        }

        public Builder fircAdCode(String fircAdCode) {
            this.fircAdCode = fircAdCode;
            return this;
        }

        public APIOutstandingEfircDetail build() {
            return new APIOutstandingEfircDetail(fircNumber, remittanceAmount, amountUtilized, amountOutstanding, swiftCode, fircIssueDate, ieCode, remitterName, remitterCountry, remitterBankCountry, fircAdCode);
        }
    }
}
