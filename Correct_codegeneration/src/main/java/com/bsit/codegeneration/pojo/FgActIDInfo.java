package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActIDInfo {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String userID_;

    private String type_;

    private String key_;

    private String value_;

    private byte[] password_;

    private String parentID_;

    public FgActIDInfo() {
    }

    public FgActIDInfo(String ID_, java.math.BigDecimal rev_, String userID_, String type_, String key_, String value_, byte[] password_, String parentID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.userID_ = userID_;
        this.type_ = type_;
        this.key_ = key_;
        this.value_ = value_;
        this.password_ = password_;
        this.parentID_ = parentID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public java.math.BigDecimal getRev_() {
        return rev_;
    }

    public void setRev_(java.math.BigDecimal rev_) {
        this.rev_ = rev_;
    }

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

    public String getValue_() {
        return value_;
    }

    public void setValue_(String value_) {
        this.value_ = value_;
    }

    public byte[] getPassword_() {
        return password_;
    }

    public void setPassword_(byte[] password_) {
        this.password_ = password_;
    }

    public String getParentID_() {
        return parentID_;
    }

    public void setParentID_(String parentID_) {
        this.parentID_ = parentID_;
    }

    public static class Builder {

        private FgActIDInfo instance = new FgActIDInfo();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder key_(String key_) {
            instance.setKey_(key_);
            return this;
        }

        public Builder value_(String value_) {
            instance.setValue_(value_);
            return this;
        }

        public Builder password_(byte[] password_) {
            instance.setPassword_(password_);
            return this;
        }

        public Builder parentID_(String parentID_) {
            instance.setParentID_(parentID_);
            return this;
        }

        public FgActIDInfo build() {
            return instance;
        }
    }
}
