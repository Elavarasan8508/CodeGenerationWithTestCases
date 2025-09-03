package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiExtTaskLog {

    private String ID_;

    private String timestamp_;

    private String extTaskID_;

    private java.math.BigDecimal retries_;

    private String topicName_;

    private String workerID_;

    private java.math.BigDecimal priority_;

    private String errorMsg_;

    private String errorDetailsID_;

    private String actID_;

    private String actInstID_;

    private String executionID_;

    private String procInstID_;

    private String procDefID_;

    private String procDefKey_;

    private String tenantID_;

    private java.math.BigDecimal state_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiExtTaskLog() {
    }

    public FgActHiExtTaskLog(String ID_, String timestamp_, String extTaskID_, java.math.BigDecimal retries_, String topicName_, String workerID_, java.math.BigDecimal priority_, String errorMsg_, String errorDetailsID_, String actID_, String actInstID_, String executionID_, String procInstID_, String procDefID_, String procDefKey_, String tenantID_, java.math.BigDecimal state_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.timestamp_ = timestamp_;
        this.extTaskID_ = extTaskID_;
        this.retries_ = retries_;
        this.topicName_ = topicName_;
        this.workerID_ = workerID_;
        this.priority_ = priority_;
        this.errorMsg_ = errorMsg_;
        this.errorDetailsID_ = errorDetailsID_;
        this.actID_ = actID_;
        this.actInstID_ = actInstID_;
        this.executionID_ = executionID_;
        this.procInstID_ = procInstID_;
        this.procDefID_ = procDefID_;
        this.procDefKey_ = procDefKey_;
        this.tenantID_ = tenantID_;
        this.state_ = state_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
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

    public String getExtTaskID_() {
        return extTaskID_;
    }

    public void setExtTaskID_(String extTaskID_) {
        this.extTaskID_ = extTaskID_;
    }

    public java.math.BigDecimal getRetries_() {
        return retries_;
    }

    public void setRetries_(java.math.BigDecimal retries_) {
        this.retries_ = retries_;
    }

    public String getTopicName_() {
        return topicName_;
    }

    public void setTopicName_(String topicName_) {
        this.topicName_ = topicName_;
    }

    public String getWorkerID_() {
        return workerID_;
    }

    public void setWorkerID_(String workerID_) {
        this.workerID_ = workerID_;
    }

    public java.math.BigDecimal getPriority_() {
        return priority_;
    }

    public void setPriority_(java.math.BigDecimal priority_) {
        this.priority_ = priority_;
    }

    public String getErrorMsg_() {
        return errorMsg_;
    }

    public void setErrorMsg_(String errorMsg_) {
        this.errorMsg_ = errorMsg_;
    }

    public String getErrorDetailsID_() {
        return errorDetailsID_;
    }

    public void setErrorDetailsID_(String errorDetailsID_) {
        this.errorDetailsID_ = errorDetailsID_;
    }

    public String getActID_() {
        return actID_;
    }

    public void setActID_(String actID_) {
        this.actID_ = actID_;
    }

    public String getActInstID_() {
        return actInstID_;
    }

    public void setActInstID_(String actInstID_) {
        this.actInstID_ = actInstID_;
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

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getProcDefKey_() {
        return procDefKey_;
    }

    public void setProcDefKey_(String procDefKey_) {
        this.procDefKey_ = procDefKey_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public java.math.BigDecimal getState_() {
        return state_;
    }

    public void setState_(java.math.BigDecimal state_) {
        this.state_ = state_;
    }

    public String getRootProcInstID_() {
        return rootProcInstID_;
    }

    public void setRootProcInstID_(String rootProcInstID_) {
        this.rootProcInstID_ = rootProcInstID_;
    }

    public String getRemovalTime_() {
        return removalTime_;
    }

    public void setRemovalTime_(String removalTime_) {
        this.removalTime_ = removalTime_;
    }

    public static class Builder {

        private FgActHiExtTaskLog instance = new FgActHiExtTaskLog();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            instance.setTimestamp_(timestamp_);
            return this;
        }

        public Builder extTaskID_(String extTaskID_) {
            instance.setExtTaskID_(extTaskID_);
            return this;
        }

        public Builder retries_(java.math.BigDecimal retries_) {
            instance.setRetries_(retries_);
            return this;
        }

        public Builder topicName_(String topicName_) {
            instance.setTopicName_(topicName_);
            return this;
        }

        public Builder workerID_(String workerID_) {
            instance.setWorkerID_(workerID_);
            return this;
        }

        public Builder priority_(java.math.BigDecimal priority_) {
            instance.setPriority_(priority_);
            return this;
        }

        public Builder errorMsg_(String errorMsg_) {
            instance.setErrorMsg_(errorMsg_);
            return this;
        }

        public Builder errorDetailsID_(String errorDetailsID_) {
            instance.setErrorDetailsID_(errorDetailsID_);
            return this;
        }

        public Builder actID_(String actID_) {
            instance.setActID_(actID_);
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            instance.setActInstID_(actInstID_);
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

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder state_(java.math.BigDecimal state_) {
            instance.setState_(state_);
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public FgActHiExtTaskLog build() {
            return instance;
        }
    }
}
