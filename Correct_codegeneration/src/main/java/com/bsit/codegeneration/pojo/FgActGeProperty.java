package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActGeProperty {

    private String name_;

    private String value_;

    private java.math.BigDecimal rev_;

    public FgActGeProperty() {
    }

    public FgActGeProperty(String name_, String value_, java.math.BigDecimal rev_) {
        this.name_ = name_;
        this.value_ = value_;
        this.rev_ = rev_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getValue_() {
        return value_;
    }

    public void setValue_(String value_) {
        this.value_ = value_;
    }

    public java.math.BigDecimal getRev_() {
        return rev_;
    }

    public void setRev_(java.math.BigDecimal rev_) {
        this.rev_ = rev_;
    }

    public static class Builder {

        private FgActGeProperty instance = new FgActGeProperty();

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder value_(String value_) {
            instance.setValue_(value_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public FgActGeProperty build() {
            return instance;
        }
    }
}
