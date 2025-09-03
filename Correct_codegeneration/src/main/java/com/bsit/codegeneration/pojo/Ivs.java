package com.bsit.codegeneration.pojo;

public class Ivs {

    private Integer ID;

    private String schemecode;

    private Double debitinterest;

    public Ivs() {
    }

    public Ivs(Integer ID, String schemecode, Double debitinterest) {
        this.ID = ID;
        this.schemecode = schemecode;
        this.debitinterest = debitinterest;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSchemecode() {
        return schemecode;
    }

    public void setSchemecode(String schemecode) {
        this.schemecode = schemecode;
    }

    public Double getDebitinterest() {
        return debitinterest;
    }

    public void setDebitinterest(Double debitinterest) {
        this.debitinterest = debitinterest;
    }

    public static class Builder {

        private Ivs instance = new Ivs();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder schemecode(String schemecode) {
            instance.setSchemecode(schemecode);
            return this;
        }

        public Builder debitinterest(Double debitinterest) {
            instance.setDebitinterest(debitinterest);
            return this;
        }

        public Ivs build() {
            return instance;
        }
    }
}
