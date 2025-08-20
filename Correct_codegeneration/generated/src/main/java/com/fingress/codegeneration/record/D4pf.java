package com.bsit.codegeneration.record;

public record D4pf(String d4branch, String d4brr, String d4dflg, Long d4dteh, Long d4dte, Long d4brar, Long d4dlm, String mntInBo) {

    public static class Builder {

        private String d4branch;

        private String d4brr;

        private String d4dflg;

        private Long d4dteh;

        private Long d4dte;

        private Long d4brar;

        private Long d4dlm;

        private String mntInBo;

        public Builder d4branch(String d4branch) {
            this.d4branch = d4branch;
            return this;
        }

        public Builder d4brr(String d4brr) {
            this.d4brr = d4brr;
            return this;
        }

        public Builder d4dflg(String d4dflg) {
            this.d4dflg = d4dflg;
            return this;
        }

        public Builder d4dteh(Long d4dteh) {
            this.d4dteh = d4dteh;
            return this;
        }

        public Builder d4dte(Long d4dte) {
            this.d4dte = d4dte;
            return this;
        }

        public Builder d4brar(Long d4brar) {
            this.d4brar = d4brar;
            return this;
        }

        public Builder d4dlm(Long d4dlm) {
            this.d4dlm = d4dlm;
            return this;
        }

        public Builder mntInBo(String mntInBo) {
            this.mntInBo = mntInBo;
            return this;
        }

        public D4pf build() {
            return new D4pf(d4branch, d4brr, d4dflg, d4dteh, d4dte, d4brar, d4dlm, mntInBo);
        }
    }
}
