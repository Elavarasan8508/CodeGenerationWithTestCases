package com.bsit.codegeneration.record;

public record FgTdTenure(String tenure, String interestRates, String recommended, String interest, String days) {

    public static class Builder {

        private String tenure;

        private String interestRates;

        private String recommended;

        private String interest;

        private String days;

        public Builder tenure(String tenure) {
            this.tenure = tenure;
            return this;
        }

        public Builder interestRates(String interestRates) {
            this.interestRates = interestRates;
            return this;
        }

        public Builder recommended(String recommended) {
            this.recommended = recommended;
            return this;
        }

        public Builder interest(String interest) {
            this.interest = interest;
            return this;
        }

        public Builder days(String days) {
            this.days = days;
            return this;
        }

        public FgTdTenure build() {
            return new FgTdTenure(tenure, interestRates, recommended, interest, days);
        }
    }
}
