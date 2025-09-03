package com.bsit.codegeneration.pojo;

public class Cvpf {

    private Integer cvyoc;

    private String cvccy;

    private String cvcna;

    private String cvcld;

    private String cvdiw;

    private String cvdiy;

    private Integer cvdoo;

    private String mntInBo;

    public Cvpf() {
    }

    public Cvpf(Integer cvyoc, String cvccy, String cvcna, String cvcld, String cvdiw, String cvdiy, Integer cvdoo, String mntInBo) {
        this.cvyoc = cvyoc;
        this.cvccy = cvccy;
        this.cvcna = cvcna;
        this.cvcld = cvcld;
        this.cvdiw = cvdiw;
        this.cvdiy = cvdiy;
        this.cvdoo = cvdoo;
        this.mntInBo = mntInBo;
    }

    public Integer getCvyoc() {
        return cvyoc;
    }

    public void setCvyoc(Integer cvyoc) {
        this.cvyoc = cvyoc;
    }

    public String getCvccy() {
        return cvccy;
    }

    public void setCvccy(String cvccy) {
        this.cvccy = cvccy;
    }

    public String getCvcna() {
        return cvcna;
    }

    public void setCvcna(String cvcna) {
        this.cvcna = cvcna;
    }

    public String getCvcld() {
        return cvcld;
    }

    public void setCvcld(String cvcld) {
        this.cvcld = cvcld;
    }

    public String getCvdiw() {
        return cvdiw;
    }

    public void setCvdiw(String cvdiw) {
        this.cvdiw = cvdiw;
    }

    public String getCvdiy() {
        return cvdiy;
    }

    public void setCvdiy(String cvdiy) {
        this.cvdiy = cvdiy;
    }

    public Integer getCvdoo() {
        return cvdoo;
    }

    public void setCvdoo(Integer cvdoo) {
        this.cvdoo = cvdoo;
    }

    public String getMntInBo() {
        return mntInBo;
    }

    public void setMntInBo(String mntInBo) {
        this.mntInBo = mntInBo;
    }

    public static class Builder {

        private Cvpf instance = new Cvpf();

        public Builder cvyoc(Integer cvyoc) {
            instance.setCvyoc(cvyoc);
            return this;
        }

        public Builder cvccy(String cvccy) {
            instance.setCvccy(cvccy);
            return this;
        }

        public Builder cvcna(String cvcna) {
            instance.setCvcna(cvcna);
            return this;
        }

        public Builder cvcld(String cvcld) {
            instance.setCvcld(cvcld);
            return this;
        }

        public Builder cvdiw(String cvdiw) {
            instance.setCvdiw(cvdiw);
            return this;
        }

        public Builder cvdiy(String cvdiy) {
            instance.setCvdiy(cvdiy);
            return this;
        }

        public Builder cvdoo(Integer cvdoo) {
            instance.setCvdoo(cvdoo);
            return this;
        }

        public Builder mntInBo(String mntInBo) {
            instance.setMntInBo(mntInBo);
            return this;
        }

        public Cvpf build() {
            return instance;
        }
    }
}
