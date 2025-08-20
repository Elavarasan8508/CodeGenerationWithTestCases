package com.bsit.codegeneration.record;

public record Extifscc(String ifscsn, String ifsc, String bank, String branch, String braadd, String city, String state, String rtgs) {

    public static class Builder {

        private String ifscsn;

        private String ifsc;

        private String bank;

        private String branch;

        private String braadd;

        private String city;

        private String state;

        private String rtgs;

        public Builder ifscsn(String ifscsn) {
            this.ifscsn = ifscsn;
            return this;
        }

        public Builder ifsc(String ifsc) {
            this.ifsc = ifsc;
            return this;
        }

        public Builder bank(String bank) {
            this.bank = bank;
            return this;
        }

        public Builder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder braadd(String braadd) {
            this.braadd = braadd;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder rtgs(String rtgs) {
            this.rtgs = rtgs;
            return this;
        }

        public Extifscc build() {
            return new Extifscc(ifscsn, ifsc, bank, branch, braadd, city, state, rtgs);
        }
    }
}
