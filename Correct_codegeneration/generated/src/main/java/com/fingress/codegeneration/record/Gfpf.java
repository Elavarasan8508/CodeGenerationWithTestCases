package com.bsit.codegeneration.record;

public record Gfpf(String ieCode, String cif) {

    public static class Builder {

        private String ieCode;

        private String cif;

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder cif(String cif) {
            this.cif = cif;
            return this;
        }

        public Gfpf build() {
            return new Gfpf(ieCode, cif);
        }
    }
}
