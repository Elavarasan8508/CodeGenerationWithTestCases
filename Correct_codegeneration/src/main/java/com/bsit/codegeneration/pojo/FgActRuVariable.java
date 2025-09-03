package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuVariable {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String type_;

    private String name_;

    private String executionID_;

    private String procInstID_;

    private String caseExecutionID_;

    private String caseInstID_;

    private String taskID_;

    private String bytearrayID_;

    private java.math.BigDecimal double_;

    private java.math.BigDecimal long_;

    private String text_;

    private String text2_;

    private String varScope_;

    private java.math.BigDecimal sequenceCounter_;

    private Integer isConcurrentLocal_;

    private String tenantID_;

    private String procDefID_;

    private String batchID_;

    public FgActRuVariable() {
    }

    public FgActRuVariable(String ID_, java.math.BigDecimal rev_, String type_, String name_, String executionID_, String procInstID_, String caseExecutionID_, String caseInstID_, String taskID_, String bytearrayID_, java.math.BigDecimal double_, java.math.BigDecimal long_, String text_, String text2_, String varScope_, java.math.BigDecimal sequenceCounter_, Integer isConcurrentLocal_, String tenantID_, String procDefID_, String batchID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.type_ = type_;
        this.name_ = name_;
        this.executionID_ = executionID_;
        this.procInstID_ = procInstID_;
        this.caseExecutionID_ = caseExecutionID_;
        this.caseInstID_ = caseInstID_;
        this.taskID_ = taskID_;
        this.bytearrayID_ = bytearrayID_;
        this.double_ = double_;
        this.long_ = long_;
        this.text_ = text_;
        this.text2_ = text2_;
        this.varScope_ = varScope_;
        this.sequenceCounter_ = sequenceCounter_;
        this.isConcurrentLocal_ = isConcurrentLocal_;
        this.tenantID_ = tenantID_;
        this.procDefID_ = procDefID_;
        this.batchID_ = batchID_;
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

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
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

    public String getCaseExecutionID_() {
        return caseExecutionID_;
    }

    public void setCaseExecutionID_(String caseExecutionID_) {
        this.caseExecutionID_ = caseExecutionID_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
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

    public String getVarScope_() {
        return varScope_;
    }

    public void setVarScope_(String varScope_) {
        this.varScope_ = varScope_;
    }

    public java.math.BigDecimal getSequenceCounter_() {
        return sequenceCounter_;
    }

    public void setSequenceCounter_(java.math.BigDecimal sequenceCounter_) {
        this.sequenceCounter_ = sequenceCounter_;
    }

    public Integer getIsConcurrentLocal_() {
        return isConcurrentLocal_;
    }

    public void setIsConcurrentLocal_(Integer isConcurrentLocal_) {
        this.isConcurrentLocal_ = isConcurrentLocal_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getBatchID_() {
        return batchID_;
    }

    public void setBatchID_(String batchID_) {
        this.batchID_ = batchID_;
    }

    public static class Builder {

        private FgActRuVariable instance = new FgActRuVariable();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
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

        public Builder caseExecutionID_(String caseExecutionID_) {
            instance.setCaseExecutionID_(caseExecutionID_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
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

        public Builder varScope_(String varScope_) {
            instance.setVarScope_(varScope_);
            return this;
        }

        public Builder sequenceCounter_(java.math.BigDecimal sequenceCounter_) {
            instance.setSequenceCounter_(sequenceCounter_);
            return this;
        }

        public Builder isConcurrentLocal_(Integer isConcurrentLocal_) {
            instance.setIsConcurrentLocal_(isConcurrentLocal_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder batchID_(String batchID_) {
            instance.setBatchID_(batchID_);
            return this;
        }

        public FgActRuVariable build() {
            return instance;
        }
    }
}
