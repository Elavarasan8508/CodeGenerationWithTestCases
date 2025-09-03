package com.bsit.codegeneration.record;

import java.util.List;

public record BoeMaster(String boeNumber, Integer adCodeID) {

    public static class Builder {

        private String boeNumber;

        private Integer adCodeID;

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder adCodeID(Integer adCodeID) {
            this.adCodeID = adCodeID;
            return this;
        }

        public BoeMaster build() {
            return new BoeMaster(boeNumber, adCodeID);
        }
    }
}
