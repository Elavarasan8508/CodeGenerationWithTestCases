package com.bsit.codegeneration.record;

public record BoeMaster(String boeNumber, String adCodeID) {

    public static class Builder {

        private String boeNumber;

        private String adCodeID;

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder adCodeID(String adCodeID) {
            this.adCodeID = adCodeID;
            return this;
        }

        public BoeMaster build() {
            return new BoeMaster(boeNumber, adCodeID);
        }
    }
}
