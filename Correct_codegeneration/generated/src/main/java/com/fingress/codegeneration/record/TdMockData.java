package com.bsit.codegeneration.record;

public record TdMockData(String bankID, String accountName, String tdAccountNo, String tdAccTemp, String cifID, Long depositAmount, Long maturityAmount, java.time.LocalDateTime effectiveDate, java.time.LocalDateTime maturityDate, Long availableAmount, java.time.LocalDateTime endDate, Long interestRate, String linkedAccount, String branch) {

    public static class Builder {

        private String bankID;

        private String accountName;

        private String tdAccountNo;

        private String tdAccTemp;

        private String cifID;

        private Long depositAmount;

        private Long maturityAmount;

        private java.time.LocalDateTime effectiveDate;

        private java.time.LocalDateTime maturityDate;

        private Long availableAmount;

        private java.time.LocalDateTime endDate;

        private Long interestRate;

        private String linkedAccount;

        private String branch;

        public Builder bankID(String bankID) {
            this.bankID = bankID;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder tdAccountNo(String tdAccountNo) {
            this.tdAccountNo = tdAccountNo;
            return this;
        }

        public Builder tdAccTemp(String tdAccTemp) {
            this.tdAccTemp = tdAccTemp;
            return this;
        }

        public Builder cifID(String cifID) {
            this.cifID = cifID;
            return this;
        }

        public Builder depositAmount(Long depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public Builder maturityAmount(Long maturityAmount) {
            this.maturityAmount = maturityAmount;
            return this;
        }

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
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

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder linkedAccount(String linkedAccount) {
            this.linkedAccount = linkedAccount;
            return this;
        }

        public Builder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public TdMockData build() {
            return new TdMockData(bankID, accountName, tdAccountNo, tdAccTemp, cifID, depositAmount, maturityAmount, effectiveDate, maturityDate, availableAmount, endDate, interestRate, linkedAccount, branch);
        }
    }
}
