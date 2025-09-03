package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActReDecisionDef {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String category_;

    private String name_;

    private String key_;

    private java.math.BigDecimal version_;

    private String deploymentID_;

    private String resourceName_;

    private String dgrmResourceName_;

    private String decReqID_;

    private String decReqKey_;

    private String tenantID_;

    private java.math.BigDecimal historyTtl_;

    private String versionTag_;

    public FgActReDecisionDef() {
    }

    public FgActReDecisionDef(String ID_, java.math.BigDecimal rev_, String category_, String name_, String key_, java.math.BigDecimal version_, String deploymentID_, String resourceName_, String dgrmResourceName_, String decReqID_, String decReqKey_, String tenantID_, java.math.BigDecimal historyTtl_, String versionTag_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.category_ = category_;
        this.name_ = name_;
        this.key_ = key_;
        this.version_ = version_;
        this.deploymentID_ = deploymentID_;
        this.resourceName_ = resourceName_;
        this.dgrmResourceName_ = dgrmResourceName_;
        this.decReqID_ = decReqID_;
        this.decReqKey_ = decReqKey_;
        this.tenantID_ = tenantID_;
        this.historyTtl_ = historyTtl_;
        this.versionTag_ = versionTag_;
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

    public String getCategory_() {
        return category_;
    }

    public void setCategory_(String category_) {
        this.category_ = category_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

    public java.math.BigDecimal getVersion_() {
        return version_;
    }

    public void setVersion_(java.math.BigDecimal version_) {
        this.version_ = version_;
    }

    public String getDeploymentID_() {
        return deploymentID_;
    }

    public void setDeploymentID_(String deploymentID_) {
        this.deploymentID_ = deploymentID_;
    }

    public String getResourceName_() {
        return resourceName_;
    }

    public void setResourceName_(String resourceName_) {
        this.resourceName_ = resourceName_;
    }

    public String getDgrmResourceName_() {
        return dgrmResourceName_;
    }

    public void setDgrmResourceName_(String dgrmResourceName_) {
        this.dgrmResourceName_ = dgrmResourceName_;
    }

    public String getDecReqID_() {
        return decReqID_;
    }

    public void setDecReqID_(String decReqID_) {
        this.decReqID_ = decReqID_;
    }

    public String getDecReqKey_() {
        return decReqKey_;
    }

    public void setDecReqKey_(String decReqKey_) {
        this.decReqKey_ = decReqKey_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public java.math.BigDecimal getHistoryTtl_() {
        return historyTtl_;
    }

    public void setHistoryTtl_(java.math.BigDecimal historyTtl_) {
        this.historyTtl_ = historyTtl_;
    }

    public String getVersionTag_() {
        return versionTag_;
    }

    public void setVersionTag_(String versionTag_) {
        this.versionTag_ = versionTag_;
    }

    public static class Builder {

        private FgActReDecisionDef instance = new FgActReDecisionDef();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder category_(String category_) {
            instance.setCategory_(category_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder key_(String key_) {
            instance.setKey_(key_);
            return this;
        }

        public Builder version_(java.math.BigDecimal version_) {
            instance.setVersion_(version_);
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            instance.setDeploymentID_(deploymentID_);
            return this;
        }

        public Builder resourceName_(String resourceName_) {
            instance.setResourceName_(resourceName_);
            return this;
        }

        public Builder dgrmResourceName_(String dgrmResourceName_) {
            instance.setDgrmResourceName_(dgrmResourceName_);
            return this;
        }

        public Builder decReqID_(String decReqID_) {
            instance.setDecReqID_(decReqID_);
            return this;
        }

        public Builder decReqKey_(String decReqKey_) {
            instance.setDecReqKey_(decReqKey_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder historyTtl_(java.math.BigDecimal historyTtl_) {
            instance.setHistoryTtl_(historyTtl_);
            return this;
        }

        public Builder versionTag_(String versionTag_) {
            instance.setVersionTag_(versionTag_);
            return this;
        }

        public FgActReDecisionDef build() {
            return instance;
        }
    }
}
