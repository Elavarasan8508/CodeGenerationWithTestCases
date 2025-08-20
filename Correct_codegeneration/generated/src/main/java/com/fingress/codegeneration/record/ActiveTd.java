package com.bsit.codegeneration.record;

public record ActiveTd(java.time.LocalDateTime effectiveDate, Long availableAmount, java.time.LocalDateTime endDate, java.time.LocalDateTime maturityDate, String accountName, Long maturityAmount, String tdAccountNo, Long interestRate, String linkedAccount, String rn, Long depositAmount) {

    public static class Builder {

        private java.time.LocalDateTime effectiveDate;

        private Long availableAmount;

        private java.time.LocalDateTime endDate;

        private java.time.LocalDateTime maturityDate;

        private String accountName;

        private Long maturityAmount;

        private String tdAccountNo;

        private Long interestRate;

        private String linkedAccount;

        private String rn;

        private Long depositAmount;

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder availableAmount(Long availableAmount) {
            this.availableAmount = availableAmount;
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder maturityAmount(Long maturityAmount) {
            this.maturityAmount = maturityAmount;
            return this;
        }

        public Builder tdAccountNo(String tdAccountNo) {
            this.tdAccountNo = tdAccountNo;
            return this;
        }

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder linkedAccount(String linkedAccount) {
            this.linkedAccount = linkedAccount;
            return this;
        }

        public Builder rn(String rn) {
            this.rn = rn;
            return this;
        }

        public Builder depositAmount(Long depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public ActiveTd build() {
            return new ActiveTd(effectiveDate, availableAmount, endDate, maturityDate, accountName, maturityAmount, tdAccountNo, interestRate, linkedAccount, rn, depositAmount);
        }
    }
}
