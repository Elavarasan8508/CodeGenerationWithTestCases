package com.bsit.codegeneration.record;

public record GtpXchRates(String bankAbbvName, String isoCode, String baseIsoCode, String brchCode, Long buyTtRate, String euroInCurrency, Long euroRate, Long midTtRate, Long patyVal, Long sellTtRate, String updateDate, String startValueDate, String endValueDate) {

    public static class Builder {

        private String bankAbbvName;

        private String isoCode;

        private String baseIsoCode;

        private String brchCode;

        private Long buyTtRate;

        private String euroInCurrency;

        private Long euroRate;

        private Long midTtRate;

        private Long patyVal;

        private Long sellTtRate;

        private String updateDate;

        private String startValueDate;

        private String endValueDate;

        public Builder bankAbbvName(String bankAbbvName) {
            this.bankAbbvName = bankAbbvName;
            return this;
        }

        public Builder isoCode(String isoCode) {
            this.isoCode = isoCode;
            return this;
        }

        public Builder baseIsoCode(String baseIsoCode) {
            this.baseIsoCode = baseIsoCode;
            return this;
        }

        public Builder brchCode(String brchCode) {
            this.brchCode = brchCode;
            return this;
        }

        public Builder buyTtRate(Long buyTtRate) {
            this.buyTtRate = buyTtRate;
            return this;
        }

        public Builder euroInCurrency(String euroInCurrency) {
            this.euroInCurrency = euroInCurrency;
            return this;
        }

        public Builder euroRate(Long euroRate) {
            this.euroRate = euroRate;
            return this;
        }

        public Builder midTtRate(Long midTtRate) {
            this.midTtRate = midTtRate;
            return this;
        }

        public Builder patyVal(Long patyVal) {
            this.patyVal = patyVal;
            return this;
        }

        public Builder sellTtRate(Long sellTtRate) {
            this.sellTtRate = sellTtRate;
            return this;
        }

        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Builder startValueDate(String startValueDate) {
            this.startValueDate = startValueDate;
            return this;
        }

        public Builder endValueDate(String endValueDate) {
            this.endValueDate = endValueDate;
            return this;
        }

        public GtpXchRates build() {
            return new GtpXchRates(bankAbbvName, isoCode, baseIsoCode, brchCode, buyTtRate, euroInCurrency, euroRate, midTtRate, patyVal, sellTtRate, updateDate, startValueDate, endValueDate);
        }
    }
}
