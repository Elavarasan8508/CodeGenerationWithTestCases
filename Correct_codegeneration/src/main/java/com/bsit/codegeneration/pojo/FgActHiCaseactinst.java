package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiCaseactinst {

    private String ID_;

    private String parentActInstID_;

    private String caseDefID_;

    private String caseInstID_;

    private String caseActID_;

    private String taskID_;

    private String callProcInstID_;

    private String callCaseInstID_;

    private String caseActName_;

    private String caseActType_;

    private String createTime_;

    private String endTime_;

    private Integer duration_;

    private java.math.BigDecimal state_;

    private Integer required_;

    private String tenantID_;

    public FgActHiCaseactinst() {
    }

    public FgActHiCaseactinst(String ID_, String parentActInstID_, String caseDefID_, String caseInstID_, String caseActID_, String taskID_, String callProcInstID_, String callCaseInstID_, String caseActName_, String caseActType_, String createTime_, String endTime_, Integer duration_, java.math.BigDecimal state_, Integer required_, String tenantID_) {
        this.ID_ = ID_;
        this.parentActInstID_ = parentActInstID_;
        this.caseDefID_ = caseDefID_;
        this.caseInstID_ = caseInstID_;
        this.caseActID_ = caseActID_;
        this.taskID_ = taskID_;
        this.callProcInstID_ = callProcInstID_;
        this.callCaseInstID_ = callCaseInstID_;
        this.caseActName_ = caseActName_;
        this.caseActType_ = caseActType_;
        this.createTime_ = createTime_;
        this.endTime_ = endTime_;
        this.duration_ = duration_;
        this.state_ = state_;
        this.required_ = required_;
        this.tenantID_ = tenantID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getParentActInstID_() {
        return parentActInstID_;
    }

    public void setParentActInstID_(String parentActInstID_) {
        this.parentActInstID_ = parentActInstID_;
    }

    public String getCaseDefID_() {
        return caseDefID_;
    }

    public void setCaseDefID_(String caseDefID_) {
        this.caseDefID_ = caseDefID_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getCaseActID_() {
        return caseActID_;
    }

    public void setCaseActID_(String caseActID_) {
        this.caseActID_ = caseActID_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
    }

    public String getCallProcInstID_() {
        return callProcInstID_;
    }

    public void setCallProcInstID_(String callProcInstID_) {
        this.callProcInstID_ = callProcInstID_;
    }

    public String getCallCaseInstID_() {
        return callCaseInstID_;
    }

    public void setCallCaseInstID_(String callCaseInstID_) {
        this.callCaseInstID_ = callCaseInstID_;
    }

    public String getCaseActName_() {
        return caseActName_;
    }

    public void setCaseActName_(String caseActName_) {
        this.caseActName_ = caseActName_;
    }

    public String getCaseActType_() {
        return caseActType_;
    }

    public void setCaseActType_(String caseActType_) {
        this.caseActType_ = caseActType_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
    }

    public String getEndTime_() {
        return endTime_;
    }

    public void setEndTime_(String endTime_) {
        this.endTime_ = endTime_;
    }

    public Integer getDuration_() {
        return duration_;
    }

    public void setDuration_(Integer duration_) {
        this.duration_ = duration_;
    }

    public java.math.BigDecimal getState_() {
        return state_;
    }

    public void setState_(java.math.BigDecimal state_) {
        this.state_ = state_;
    }

    public Integer getRequired_() {
        return required_;
    }

    public void setRequired_(Integer required_) {
        this.required_ = required_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public static class Builder {

        private FgActHiCaseactinst instance = new FgActHiCaseactinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder parentActInstID_(String parentActInstID_) {
            instance.setParentActInstID_(parentActInstID_);
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            instance.setCaseDefID_(caseDefID_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder caseActID_(String caseActID_) {
            instance.setCaseActID_(caseActID_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
            return this;
        }

        public Builder callProcInstID_(String callProcInstID_) {
            instance.setCallProcInstID_(callProcInstID_);
            return this;
        }

        public Builder callCaseInstID_(String callCaseInstID_) {
            instance.setCallCaseInstID_(callCaseInstID_);
            return this;
        }

        public Builder caseActName_(String caseActName_) {
            instance.setCaseActName_(caseActName_);
            return this;
        }

        public Builder caseActType_(String caseActType_) {
            instance.setCaseActType_(caseActType_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
            return this;
        }

        public Builder endTime_(String endTime_) {
            instance.setEndTime_(endTime_);
            return this;
        }

        public Builder duration_(Integer duration_) {
            instance.setDuration_(duration_);
            return this;
        }

        public Builder state_(java.math.BigDecimal state_) {
            instance.setState_(state_);
            return this;
        }

        public Builder required_(Integer required_) {
            instance.setRequired_(required_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public FgActHiCaseactinst build() {
            return instance;
        }
    }
}
