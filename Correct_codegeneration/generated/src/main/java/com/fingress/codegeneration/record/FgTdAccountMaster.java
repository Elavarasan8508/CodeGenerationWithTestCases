package com.bsit.codegeneration.record;

public record FgTdAccountMaster(String debitAccNum, String accUserName, String userType, Long availBalance, String acctType, String acctName, String schemeCode, String ccy) {

    public static class Builder {

        private String debitAccNum;

        private String accUserName;

        private String userType;

        private Long availBalance;

        private String acctType;

        private String acctName;

        private String schemeCode;

        private String ccy;

        public Builder debitAccNum(String debitAccNum) {
            this.debitAccNum = debitAccNum;
            return this;
        }

        public Builder accUserName(String accUserName) {
            this.accUserName = accUserName;
            return this;
        }

        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder availBalance(Long availBalance) {
            this.availBalance = availBalance;
            return this;
        }

        public Builder acctType(String acctType) {
            this.acctType = acctType;
            return this;
        }

        public Builder acctName(String acctName) {
            this.acctName = acctName;
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder ccy(String ccy) {
            this.ccy = ccy;
            return this;
        }

        public FgTdAccountMaster build() {
            return new FgTdAccountMaster(debitAccNum, accUserName, userType, availBalance, acctType, acctName, schemeCode, ccy);
        }
    }
}
