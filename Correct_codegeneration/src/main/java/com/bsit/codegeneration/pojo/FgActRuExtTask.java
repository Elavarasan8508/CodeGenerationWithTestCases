package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuExtTask {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String workerID_;

    private String topicName_;

    private java.math.BigDecimal retries_;

    private String errorMsg_;

    private String errorDetailsID_;

    private String lockExpTime_;

    private java.math.BigDecimal suspensionState_;

    private String executionID_;

    private String procInstID_;

    private String procDefID_;

    private String procDefKey_;

    private String actID_;

    private String actInstID_;

    private String tenantID_;

    private java.math.BigDecimal priority_;

    public FgActRuExtTask() {
    }

    public FgActRuExtTask(String ID_, java.math.BigDecimal rev_, String workerID_, String topicName_, java.math.BigDecimal retries_, String errorMsg_, String errorDetailsID_, String lockExpTime_, java.math.BigDecimal suspensionState_, String executionID_, String procInstID_, String procDefID_, String procDefKey_, String actID_, String actInstID_, String tenantID_, java.math.BigDecimal priority_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.workerID_ = workerID_;
        this.topicName_ = topicName_;
        this.retries_ = retries_;
        this.errorMsg_ = errorMsg_;
        this.errorDetailsID_ = errorDetailsID_;
        this.lockExpTime_ = lockExpTime_;
        this.suspensionState_ = suspensionState_;
        this.executionID_ = executionID_;
        this.procInstID_ = procInstID_;
        this.procDefID_ = procDefID_;
        this.procDefKey_ = procDefKey_;
        this.actID_ = actID_;
        this.actInstID_ = actInstID_;
        this.tenantID_ = tenantID_;
        this.priority_ = priority_;
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

    public String getWorkerID_() {
        return workerID_;
    }

    public void setWorkerID_(String workerID_) {
        this.workerID_ = workerID_;
    }

    public String getTopicName_() {
        return topicName_;
    }

    public void setTopicName_(String topicName_) {
        this.topicName_ = topicName_;
    }

    public java.math.BigDecimal getRetries_() {
        return retries_;
    }

    public void setRetries_(java.math.BigDecimal retries_) {
        this.retries_ = retries_;
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

    public String getLockExpTime_() {
        return lockExpTime_;
    }

    public void setLockExpTime_(String lockExpTime_) {
        this.lockExpTime_ = lockExpTime_;
    }

    public java.math.BigDecimal getSuspensionState_() {
        return suspensionState_;
    }

    public void setSuspensionState_(java.math.BigDecimal suspensionState_) {
        this.suspensionState_ = suspensionState_;
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

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public java.math.BigDecimal getPriority_() {
        return priority_;
    }

    public void setPriority_(java.math.BigDecimal priority_) {
        this.priority_ = priority_;
    }

    public static class Builder {

        private FgActRuExtTask instance = new FgActRuExtTask();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder workerID_(String workerID_) {
            instance.setWorkerID_(workerID_);
            return this;
        }

        public Builder topicName_(String topicName_) {
            instance.setTopicName_(topicName_);
            return this;
        }

        public Builder retries_(java.math.BigDecimal retries_) {
            instance.setRetries_(retries_);
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

        public Builder lockExpTime_(String lockExpTime_) {
            instance.setLockExpTime_(lockExpTime_);
            return this;
        }

        public Builder suspensionState_(java.math.BigDecimal suspensionState_) {
            instance.setSuspensionState_(suspensionState_);
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

        public Builder actID_(String actID_) {
            instance.setActID_(actID_);
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            instance.setActInstID_(actInstID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder priority_(java.math.BigDecimal priority_) {
            instance.setPriority_(priority_);
            return this;
        }

        public FgActRuExtTask build() {
            return instance;
        }
    }
}
