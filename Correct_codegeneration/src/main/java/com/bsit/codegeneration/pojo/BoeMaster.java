package com.bsit.codegeneration.pojo;

public class BoeMaster {

    private String boeNumber;

    private Integer adCodeID;

    public BoeMaster() {
    }

    public BoeMaster(String boeNumber, Integer adCodeID) {
        this.boeNumber = boeNumber;
        this.adCodeID = adCodeID;
    }

    public String getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(String boeNumber) {
        this.boeNumber = boeNumber;
    }

    public Integer getAdCodeID() {
        return adCodeID;
    }

    public void setAdCodeID(Integer adCodeID) {
        this.adCodeID = adCodeID;
    }

    public static class Builder {

        private BoeMaster instance = new BoeMaster();

        public Builder boeNumber(String boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder adCodeID(Integer adCodeID) {
            instance.setAdCodeID(adCodeID);
            return this;
        }

        public BoeMaster build() {
            return instance;
        }
    }
}
