package com.bsit.codegeneration.record;

public record Ivs(String ID, String schemecode, Long debitinterest) {

    public static class Builder {

        private String ID;

        private String schemecode;

        private Long debitinterest;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder schemecode(String schemecode) {
            this.schemecode = schemecode;
            return this;
        }

        public Builder debitinterest(Long debitinterest) {
            this.debitinterest = debitinterest;
            return this;
        }

        public Ivs build() {
            return new Ivs(ID, schemecode, debitinterest);
        }
    }
}
