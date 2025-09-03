package com.bsit.codegeneration.record;

import java.util.List;

public record NonLongTable(Integer ID, String price) {

    public static class Builder {

        private Integer ID;

        private String price;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public NonLongTable build() {
            return new NonLongTable(ID, price);
        }
    }
}
