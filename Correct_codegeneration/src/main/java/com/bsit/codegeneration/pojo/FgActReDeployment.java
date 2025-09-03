package com.bsit.codegeneration.pojo;

import java.util.List;

public class FgActReDeployment {

    private String ID_;

    private String name_;

    private String deployTime_;

    private String source_;

    private String tenantID_;

    private List<FgActGeBytearray> fgActGeBytearrayList;

    public FgActReDeployment() {
    }

    public FgActReDeployment(String ID_, String name_, String deployTime_, String source_, String tenantID_) {
        this.ID_ = ID_;
        this.name_ = name_;
        this.deployTime_ = deployTime_;
        this.source_ = source_;
        this.tenantID_ = tenantID_;
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

    public String getDeployTime_() {
        return deployTime_;
    }

    public void setDeployTime_(String deployTime_) {
        this.deployTime_ = deployTime_;
    }

    public String getSource_() {
        return source_;
    }

    public void setSource_(String source_) {
        this.source_ = source_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public List<FgActGeBytearray> getFgActGeBytearrayList() {
        return fgActGeBytearrayList;
    }

    public void setFgActGeBytearrayList(List<FgActGeBytearray> fgActGeBytearrayList) {
        this.fgActGeBytearrayList = fgActGeBytearrayList;
    }

    public static class Builder {

        private FgActReDeployment instance = new FgActReDeployment();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder deployTime_(String deployTime_) {
            instance.setDeployTime_(deployTime_);
            return this;
        }

        public Builder source_(String source_) {
            instance.setSource_(source_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder fgActGeBytearrayList(List<FgActGeBytearray> fgActGeBytearrayList) {
            instance.setFgActGeBytearrayList(fgActGeBytearrayList);
            return this;
        }

        public FgActReDeployment build() {
            return instance;
        }
    }
}
