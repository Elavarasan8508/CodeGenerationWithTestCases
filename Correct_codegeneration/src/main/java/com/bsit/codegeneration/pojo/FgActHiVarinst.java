package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiVarinst {

    private String ID_;

    private String procDefKey_;

    private String procDefID_;

    private String procInstID_;

    private String executionID_;

    private String actInstID_;

    private String caseDefKey_;

    private String caseDefID_;

    private String caseInstID_;

    private String caseExecutionID_;

    private String taskID_;

    private String name_;

    private String varType_;

    private java.math.BigDecimal rev_;

    private String bytearrayID_;

    private java.math.BigDecimal double_;

    private java.math.BigDecimal long_;

    private String text_;

    private String text2_;

    private String tenantID_;

    private String state_;

    private String createTime_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiVarinst() {
    }

    public FgActHiVarinst(String ID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String actInstID_, String caseDefKey_, String caseDefID_, String caseInstID_, String caseExecutionID_, String taskID_, String name_, String varType_, java.math.BigDecimal rev_, String bytearrayID_, java.math.BigDecimal double_, java.math.BigDecimal long_, String text_, String text2_, String tenantID_, String state_, String createTime_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.procDefKey_ = procDefKey_;
        this.procDefID_ = procDefID_;
        this.procInstID_ = procInstID_;
        this.executionID_ = executionID_;
        this.actInstID_ = actInstID_;
        this.caseDefKey_ = caseDefKey_;
        this.caseDefID_ = caseDefID_;
        this.caseInstID_ = caseInstID_;
        this.caseExecutionID_ = caseExecutionID_;
        this.taskID_ = taskID_;
        this.name_ = name_;
        this.varType_ = varType_;
        this.rev_ = rev_;
        this.bytearrayID_ = bytearrayID_;
        this.double_ = double_;
        this.long_ = long_;
        this.text_ = text_;
        this.text2_ = text2_;
        this.tenantID_ = tenantID_;
        this.state_ = state_;
        this.createTime_ = createTime_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getProcDefKey_() {
        return procDefKey_;
    }

    public void setProcDefKey_(String procDefKey_) {
        this.procDefKey_ = procDefKey_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getActInstID_() {
        return actInstID_;
    }

    public void setActInstID_(String actInstID_) {
        this.actInstID_ = actInstID_;
    }

    public String getCaseDefKey_() {
        return caseDefKey_;
    }

    public void setCaseDefKey_(String caseDefKey_) {
        this.caseDefKey_ = caseDefKey_;
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

    public String getCaseExecutionID_() {
        return caseExecutionID_;
    }

    public void setCaseExecutionID_(String caseExecutionID_) {
        this.caseExecutionID_ = caseExecutionID_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getVarType_() {
        return varType_;
    }

    public void setVarType_(String varType_) {
        this.varType_ = varType_;
    }

    public java.math.BigDecimal getRev_() {
        return rev_;
    }

    public void setRev_(java.math.BigDecimal rev_) {
        this.rev_ = rev_;
    }

    public String getBytearrayID_() {
        return bytearrayID_;
    }

    public void setBytearrayID_(String bytearrayID_) {
        this.bytearrayID_ = bytearrayID_;
    }

    public java.math.BigDecimal getDouble_() {
        return double_;
    }

    public void setDouble_(java.math.BigDecimal double_) {
        this.double_ = double_;
    }

    public java.math.BigDecimal getLong_() {
        return long_;
    }

    public void setLong_(java.math.BigDecimal long_) {
        this.long_ = long_;
    }

    public String getText_() {
        return text_;
    }

    public void setText_(String text_) {
        this.text_ = text_;
    }

    public String getText2_() {
        return text2_;
    }

    public void setText2_(String text2_) {
        this.text2_ = text2_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getState_() {
        return state_;
    }

    public void setState_(String state_) {
        this.state_ = state_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
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

        private FgActHiVarinst instance = new FgActHiVarinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            instance.setActInstID_(actInstID_);
            return this;
        }

        public Builder caseDefKey_(String caseDefKey_) {
            instance.setCaseDefKey_(caseDefKey_);
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

        public Builder caseExecutionID_(String caseExecutionID_) {
            instance.setCaseExecutionID_(caseExecutionID_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder varType_(String varType_) {
            instance.setVarType_(varType_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder bytearrayID_(String bytearrayID_) {
            instance.setBytearrayID_(bytearrayID_);
            return this;
        }

        public Builder double_(java.math.BigDecimal double_) {
            instance.setDouble_(double_);
            return this;
        }

        public Builder long_(java.math.BigDecimal long_) {
            instance.setLong_(long_);
            return this;
        }

        public Builder text_(String text_) {
            instance.setText_(text_);
            return this;
        }

        public Builder text2_(String text2_) {
            instance.setText2_(text2_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder state_(String state_) {
            instance.setState_(state_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
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

        public FgActHiVarinst build() {
            return instance;
        }
    }
}
