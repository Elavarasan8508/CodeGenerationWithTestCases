package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class D4pf {

    private String d4branch;

    private String d4brr;

    private String d4dflg;

    private Integer d4dteh;

    private Integer d4dte;

    private java.math.BigDecimal d4brar;

    private Integer d4dlm;

    private String mntInBo;

    public D4pf() {
    }

    public D4pf(String d4branch, String d4brr, String d4dflg, Integer d4dteh, Integer d4dte, java.math.BigDecimal d4brar, Integer d4dlm, String mntInBo) {
        this.d4branch = d4branch;
        this.d4brr = d4brr;
        this.d4dflg = d4dflg;
        this.d4dteh = d4dteh;
        this.d4dte = d4dte;
        this.d4brar = d4brar;
        this.d4dlm = d4dlm;
        this.mntInBo = mntInBo;
    }

    public String getD4branch() {
        return d4branch;
    }

    public void setD4branch(String d4branch) {
        this.d4branch = d4branch;
    }

    public String getD4brr() {
        return d4brr;
    }

    public void setD4brr(String d4brr) {
        this.d4brr = d4brr;
    }

    public String getD4dflg() {
        return d4dflg;
    }

    public void setD4dflg(String d4dflg) {
        this.d4dflg = d4dflg;
    }

    public Integer getD4dteh() {
        return d4dteh;
    }

    public void setD4dteh(Integer d4dteh) {
        this.d4dteh = d4dteh;
    }

    public Integer getD4dte() {
        return d4dte;
    }

    public void setD4dte(Integer d4dte) {
        this.d4dte = d4dte;
    }

    public java.math.BigDecimal getD4brar() {
        return d4brar;
    }

    public void setD4brar(java.math.BigDecimal d4brar) {
        this.d4brar = d4brar;
    }

    public Integer getD4dlm() {
        return d4dlm;
    }

    public void setD4dlm(Integer d4dlm) {
        this.d4dlm = d4dlm;
    }

    public String getMntInBo() {
        return mntInBo;
    }

    public void setMntInBo(String mntInBo) {
        this.mntInBo = mntInBo;
    }

    public static class Builder {

        private D4pf instance = new D4pf();

        public Builder d4branch(String d4branch) {
            instance.setD4branch(d4branch);
            return this;
        }

        public Builder d4brr(String d4brr) {
            instance.setD4brr(d4brr);
            return this;
        }

        public Builder d4dflg(String d4dflg) {
            instance.setD4dflg(d4dflg);
            return this;
        }

        public Builder d4dteh(Integer d4dteh) {
            instance.setD4dteh(d4dteh);
            return this;
        }

        public Builder d4dte(Integer d4dte) {
            instance.setD4dte(d4dte);
            return this;
        }

        public Builder d4brar(java.math.BigDecimal d4brar) {
            instance.setD4brar(d4brar);
            return this;
        }

        public Builder d4dlm(Integer d4dlm) {
            instance.setD4dlm(d4dlm);
            return this;
        }

        public Builder mntInBo(String mntInBo) {
            instance.setMntInBo(mntInBo);
            return this;
        }

        public D4pf build() {
            return instance;
        }
    }
}
