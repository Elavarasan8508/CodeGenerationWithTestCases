package com.bsit.codegeneration.record;

public record FxRateTd(String intTblCode, String crncyCode, String intSlabSrlNum, Long maxPeriodRunMths, Long maxPeriodRunDays, Long beginSlabAmount, Long maxSlabAmount, Long nrmlIntPcnt) {

    public static class Builder {

        private String intTblCode;

        private String crncyCode;

        private String intSlabSrlNum;

        private Long maxPeriodRunMths;

        private Long maxPeriodRunDays;

        private Long beginSlabAmount;

        private Long maxSlabAmount;

        private Long nrmlIntPcnt;

        public Builder intTblCode(String intTblCode) {
            this.intTblCode = intTblCode;
            return this;
        }

        public Builder crncyCode(String crncyCode) {
            this.crncyCode = crncyCode;
            return this;
        }

        public Builder intSlabSrlNum(String intSlabSrlNum) {
            this.intSlabSrlNum = intSlabSrlNum;
            return this;
        }

        public Builder maxPeriodRunMths(Long maxPeriodRunMths) {
            this.maxPeriodRunMths = maxPeriodRunMths;
            return this;
        }

        public Builder maxPeriodRunDays(Long maxPeriodRunDays) {
            this.maxPeriodRunDays = maxPeriodRunDays;
            return this;
        }

        public Builder beginSlabAmount(Long beginSlabAmount) {
            this.beginSlabAmount = beginSlabAmount;
            return this;
        }

        public Builder maxSlabAmount(Long maxSlabAmount) {
            this.maxSlabAmount = maxSlabAmount;
            return this;
        }

        public Builder nrmlIntPcnt(Long nrmlIntPcnt) {
            this.nrmlIntPcnt = nrmlIntPcnt;
            return this;
        }

        public FxRateTd build() {
            return new FxRateTd(intTblCode, crncyCode, intSlabSrlNum, maxPeriodRunMths, maxPeriodRunDays, beginSlabAmount, maxSlabAmount, nrmlIntPcnt);
        }
    }
}
