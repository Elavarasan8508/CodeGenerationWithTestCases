package com.bsit.codegeneration.pojo;

public class FgIrNostroStagging {

    private Integer ID;

    private String nostroNumber;

    private String nostroXml;

    private String insertedOn;

    private String status;

    private String node;

    public FgIrNostroStagging() {
    }

    public FgIrNostroStagging(Integer ID, String nostroNumber, String nostroXml, String insertedOn, String status, String node) {
        this.ID = ID;
        this.nostroNumber = nostroNumber;
        this.nostroXml = nostroXml;
        this.insertedOn = insertedOn;
        this.status = status;
        this.node = node;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNostroNumber() {
        return nostroNumber;
    }

    public void setNostroNumber(String nostroNumber) {
        this.nostroNumber = nostroNumber;
    }

    public String getNostroXml() {
        return nostroXml;
    }

    public void setNostroXml(String nostroXml) {
        this.nostroXml = nostroXml;
    }

    public String getInsertedOn() {
        return insertedOn;
    }

    public void setInsertedOn(String insertedOn) {
        this.insertedOn = insertedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public static class Builder {

        private FgIrNostroStagging instance = new FgIrNostroStagging();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder nostroNumber(String nostroNumber) {
            instance.setNostroNumber(nostroNumber);
            return this;
        }

        public Builder nostroXml(String nostroXml) {
            instance.setNostroXml(nostroXml);
            return this;
        }

        public Builder insertedOn(String insertedOn) {
            instance.setInsertedOn(insertedOn);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder node(String node) {
            instance.setNode(node);
            return this;
        }

        public FgIrNostroStagging build() {
            return instance;
        }
    }
}
