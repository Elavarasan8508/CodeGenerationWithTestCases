package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuMeterLog {

    private String ID_;

    private String name_;

    private String reporter_;

    private java.math.BigDecimal value_;

    private String timestamp_;

    private java.math.BigDecimal milliseconds_;

    public FgActRuMeterLog() {
    }

    public FgActRuMeterLog(String ID_, String name_, String reporter_, java.math.BigDecimal value_, String timestamp_, java.math.BigDecimal milliseconds_) {
        this.ID_ = ID_;
        this.name_ = name_;
        this.reporter_ = reporter_;
        this.value_ = value_;
        this.timestamp_ = timestamp_;
        this.milliseconds_ = milliseconds_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getReporter_() {
        return reporter_;
    }

    public void setReporter_(String reporter_) {
        this.reporter_ = reporter_;
    }

    public java.math.BigDecimal getValue_() {
        return value_;
    }

    public void setValue_(java.math.BigDecimal value_) {
        this.value_ = value_;
    }

    public String getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(String timestamp_) {
        this.timestamp_ = timestamp_;
    }

    public java.math.BigDecimal getMilliseconds_() {
        return milliseconds_;
    }

    public void setMilliseconds_(java.math.BigDecimal milliseconds_) {
        this.milliseconds_ = milliseconds_;
    }

    public static class Builder {

        private FgActRuMeterLog instance = new FgActRuMeterLog();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder reporter_(String reporter_) {
            instance.setReporter_(reporter_);
            return this;
        }

        public Builder value_(java.math.BigDecimal value_) {
            instance.setValue_(value_);
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            instance.setTimestamp_(timestamp_);
            return this;
        }

        public Builder milliseconds_(java.math.BigDecimal milliseconds_) {
            instance.setMilliseconds_(milliseconds_);
            return this;
        }

        public FgActRuMeterLog build() {
            return instance;
        }
    }
}
