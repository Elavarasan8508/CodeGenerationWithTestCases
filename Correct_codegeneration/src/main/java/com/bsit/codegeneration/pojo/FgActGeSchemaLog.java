package com.bsit.codegeneration.pojo;

public class FgActGeSchemaLog {

    private String ID_;

    private String timestamp_;

    private String version_;

    public FgActGeSchemaLog() {
    }

    public FgActGeSchemaLog(String ID_, String timestamp_, String version_) {
        this.ID_ = ID_;
        this.timestamp_ = timestamp_;
        this.version_ = version_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(String timestamp_) {
        this.timestamp_ = timestamp_;
    }

    public String getVersion_() {
        return version_;
    }

    public void setVersion_(String version_) {
        this.version_ = version_;
    }

    public static class Builder {

        private FgActGeSchemaLog instance = new FgActGeSchemaLog();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            instance.setTimestamp_(timestamp_);
            return this;
        }

        public Builder version_(String version_) {
            instance.setVersion_(version_);
            return this;
        }

        public FgActGeSchemaLog build() {
            return instance;
        }
    }
}
