package com.bsit.codegeneration.record;

public record FgIrNostroStagging(String ID, String nostroNumber, String nostroXml, String insertedOn, String status, String node) {

    public static class Builder {

        private String ID;

        private String nostroNumber;

        private String nostroXml;

        private String insertedOn;

        private String status;

        private String node;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder nostroNumber(String nostroNumber) {
            this.nostroNumber = nostroNumber;
            return this;
        }

        public Builder nostroXml(String nostroXml) {
            this.nostroXml = nostroXml;
            return this;
        }

        public Builder insertedOn(String insertedOn) {
            this.insertedOn = insertedOn;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder node(String node) {
            this.node = node;
            return this;
        }

        public FgIrNostroStagging build() {
            return new FgIrNostroStagging(ID, nostroNumber, nostroXml, insertedOn, status, node);
        }
    }
}
