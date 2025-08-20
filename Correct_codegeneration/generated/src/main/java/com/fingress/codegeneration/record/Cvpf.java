package com.bsit.codegeneration.record;

public record Cvpf(Long cvyoc, String cvccy, String cvcna, String cvcld, String cvdiw, String cvdiy, Long cvdoo, String mntInBo) {

    public static class Builder {

        private Long cvyoc;

        private String cvccy;

        private String cvcna;

        private String cvcld;

        private String cvdiw;

        private String cvdiy;

        private Long cvdoo;

        private String mntInBo;

        public Builder cvyoc(Long cvyoc) {
            this.cvyoc = cvyoc;
            return this;
        }

        public Builder cvccy(String cvccy) {
            this.cvccy = cvccy;
            return this;
        }

        public Builder cvcna(String cvcna) {
            this.cvcna = cvcna;
            return this;
        }

        public Builder cvcld(String cvcld) {
            this.cvcld = cvcld;
            return this;
        }

        public Builder cvdiw(String cvdiw) {
            this.cvdiw = cvdiw;
            return this;
        }

        public Builder cvdiy(String cvdiy) {
            this.cvdiy = cvdiy;
            return this;
        }

        public Builder cvdoo(Long cvdoo) {
            this.cvdoo = cvdoo;
            return this;
        }

        public Builder mntInBo(String mntInBo) {
            this.mntInBo = mntInBo;
            return this;
        }

        public Cvpf build() {
            return new Cvpf(cvyoc, cvccy, cvcna, cvcld, cvdiw, cvdiy, cvdoo, mntInBo);
        }
    }
}
