package com.bsit.codegeneration.record;

public record TdAccountList(String applicantParty, String accountName, String tdAccount, String accountNo, Long liqDepositAmount, Long maturityAmount, String accountSchemeCode, java.time.LocalDateTime startDate, java.time.LocalDateTime liqMaturityDate, String startDateDisplay, String liqMaturityDateDisplay, Long availableBalance, java.time.LocalDateTime endDate, String freezeedAccount, Long lienAmount, Long liqInterestRate) {

    public static class Builder {

        private String applicantParty;

        private String accountName;

        private String tdAccount;

        private String accountNo;

        private Long liqDepositAmount;

        private Long maturityAmount;

        private String accountSchemeCode;

        private java.time.LocalDateTime startDate;

        private java.time.LocalDateTime liqMaturityDate;

        private String startDateDisplay;

        private String liqMaturityDateDisplay;

        private Long availableBalance;

        private java.time.LocalDateTime endDate;

        private String freezeedAccount;

        private Long lienAmount;

        private Long liqInterestRate;

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder tdAccount(String tdAccount) {
            this.tdAccount = tdAccount;
            return this;
        }

        public Builder accountNo(String accountNo) {
            this.accountNo = accountNo;
            return this;
        }

        public Builder liqDepositAmount(Long liqDepositAmount) {
            this.liqDepositAmount = liqDepositAmount;
            return this;
        }

        public Builder maturityAmount(Long maturityAmount) {
            this.maturityAmount = maturityAmount;
            return this;
        }

        public Builder accountSchemeCode(String accountSchemeCode) {
            this.accountSchemeCode = accountSchemeCode;
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder liqMaturityDate(java.time.LocalDateTime liqMaturityDate) {
            this.liqMaturityDate = liqMaturityDate;
            return this;
        }

        public Builder startDateDisplay(String startDateDisplay) {
            this.startDateDisplay = startDateDisplay;
            return this;
        }

        public Builder liqMaturityDateDisplay(String liqMaturityDateDisplay) {
            this.liqMaturityDateDisplay = liqMaturityDateDisplay;
            return this;
        }

        public Builder availableBalance(Long availableBalance) {
            this.availableBalance = availableBalance;
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder freezeedAccount(String freezeedAccount) {
            this.freezeedAccount = freezeedAccount;
            return this;
        }

        public Builder lienAmount(Long lienAmount) {
            this.lienAmount = lienAmount;
            return this;
        }

        public Builder liqInterestRate(Long liqInterestRate) {
            this.liqInterestRate = liqInterestRate;
            return this;
        }

        public TdAccountList build() {
            return new TdAccountList(applicantParty, accountName, tdAccount, accountNo, liqDepositAmount, maturityAmount, accountSchemeCode, startDate, liqMaturityDate, startDateDisplay, liqMaturityDateDisplay, availableBalance, endDate, freezeedAccount, lienAmount, liqInterestRate);
        }
    }
}
