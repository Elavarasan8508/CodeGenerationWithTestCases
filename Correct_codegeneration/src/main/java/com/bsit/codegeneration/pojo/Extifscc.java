package com.bsit.codegeneration.pojo;

public class Extifscc {

    private String ifscsn;

    private String ifsc;

    private String bank;

    private String branch;

    private String braadd;

    private String city;

    private String state;

    private String rtgs;

    public Extifscc() {
    }

    public Extifscc(String ifscsn, String ifsc, String bank, String branch, String braadd, String city, String state, String rtgs) {
        this.ifscsn = ifscsn;
        this.ifsc = ifsc;
        this.bank = bank;
        this.branch = branch;
        this.braadd = braadd;
        this.city = city;
        this.state = state;
        this.rtgs = rtgs;
    }

    public String getIfscsn() {
        return ifscsn;
    }

    public void setIfscsn(String ifscsn) {
        this.ifscsn = ifscsn;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBraadd() {
        return braadd;
    }

    public void setBraadd(String braadd) {
        this.braadd = braadd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRtgs() {
        return rtgs;
    }

    public void setRtgs(String rtgs) {
        this.rtgs = rtgs;
    }

    public static class Builder {

        private Extifscc instance = new Extifscc();

        public Builder ifscsn(String ifscsn) {
            instance.setIfscsn(ifscsn);
            return this;
        }

        public Builder ifsc(String ifsc) {
            instance.setIfsc(ifsc);
            return this;
        }

        public Builder bank(String bank) {
            instance.setBank(bank);
            return this;
        }

        public Builder branch(String branch) {
            instance.setBranch(branch);
            return this;
        }

        public Builder braadd(String braadd) {
            instance.setBraadd(braadd);
            return this;
        }

        public Builder city(String city) {
            instance.setCity(city);
            return this;
        }

        public Builder state(String state) {
            instance.setState(state);
            return this;
        }

        public Builder rtgs(String rtgs) {
            instance.setRtgs(rtgs);
            return this;
        }

        public Extifscc build() {
            return instance;
        }
    }
}
