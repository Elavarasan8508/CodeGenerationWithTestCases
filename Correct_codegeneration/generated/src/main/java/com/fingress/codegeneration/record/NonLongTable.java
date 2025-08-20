package com.bsit.codegeneration.record;

public record NonLongTable(Long ID, String price) {

    public static class Builder {

        private Long ID;

        private String price;

        public Builder ID(Long ID) {
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
