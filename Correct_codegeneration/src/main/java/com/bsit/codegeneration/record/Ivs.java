package com.bsit.codegeneration.record;

import java.util.List;

public record Ivs(Integer ID, String schemecode, Long debitinterest) {

    public static class Builder {

        private Integer ID;

        private String schemecode;

        private Long debitinterest;

        public Builder ID(Integer ID) {
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
