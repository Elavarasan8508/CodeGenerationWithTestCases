package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuEventSubscr {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String eventType_;

    private String eventName_;

    private String executionID_;

    private String procInstID_;

    private String activityID_;

    private String configuration_;

    private String created_;

    private String tenantID_;

    public FgActRuEventSubscr() {
    }

    public FgActRuEventSubscr(String ID_, java.math.BigDecimal rev_, String eventType_, String eventName_, String executionID_, String procInstID_, String activityID_, String configuration_, String created_, String tenantID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.eventType_ = eventType_;
        this.eventName_ = eventName_;
        this.executionID_ = executionID_;
        this.procInstID_ = procInstID_;
        this.activityID_ = activityID_;
        this.configuration_ = configuration_;
        this.created_ = created_;
        this.tenantID_ = tenantID_;
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

    public String getEventType_() {
        return eventType_;
    }

    public void setEventType_(String eventType_) {
        this.eventType_ = eventType_;
    }

    public String getEventName_() {
        return eventName_;
    }

    public void setEventName_(String eventName_) {
        this.eventName_ = eventName_;
    }

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getActivityID_() {
        return activityID_;
    }

    public void setActivityID_(String activityID_) {
        this.activityID_ = activityID_;
    }

    public String getConfiguration_() {
        return configuration_;
    }

    public void setConfiguration_(String configuration_) {
        this.configuration_ = configuration_;
    }

    public String getCreated_() {
        return created_;
    }

    public void setCreated_(String created_) {
        this.created_ = created_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public static class Builder {

        private FgActRuEventSubscr instance = new FgActRuEventSubscr();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder eventType_(String eventType_) {
            instance.setEventType_(eventType_);
            return this;
        }

        public Builder eventName_(String eventName_) {
            instance.setEventName_(eventName_);
            return this;
        }

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder activityID_(String activityID_) {
            instance.setActivityID_(activityID_);
            return this;
        }

        public Builder configuration_(String configuration_) {
            instance.setConfiguration_(configuration_);
            return this;
        }

        public Builder created_(String created_) {
            instance.setCreated_(created_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public FgActRuEventSubscr build() {
            return instance;
        }
    }
}
