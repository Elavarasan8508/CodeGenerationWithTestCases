package com.bsit.codegeneration.pojo;

public class Gfpf {

    private String ieCode;

    private String cif;

    public Gfpf() {
    }

    public Gfpf(String ieCode, String cif) {
        this.ieCode = ieCode;
        this.cif = cif;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public static class Builder {

        private Gfpf instance = new Gfpf();

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder cif(String cif) {
            instance.setCif(cif);
            return this;
        }

        public Gfpf build() {
            return instance;
        }
    }
}
