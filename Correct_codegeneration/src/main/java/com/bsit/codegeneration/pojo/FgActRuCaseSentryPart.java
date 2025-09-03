package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuCaseSentryPart {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String caseInstID_;

    private String caseExecID_;

    private String sentryID_;

    private String type_;

    private String sourceCaseExecID_;

    private String standardEvent_;

    private String source_;

    private String variableEvent_;

    private String variableName_;

    private Integer satisfied_;

    private String tenantID_;

    public FgActRuCaseSentryPart() {
    }

    public FgActRuCaseSentryPart(String ID_, java.math.BigDecimal rev_, String caseInstID_, String caseExecID_, String sentryID_, String type_, String sourceCaseExecID_, String standardEvent_, String source_, String variableEvent_, String variableName_, Integer satisfied_, String tenantID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.caseInstID_ = caseInstID_;
        this.caseExecID_ = caseExecID_;
        this.sentryID_ = sentryID_;
        this.type_ = type_;
        this.sourceCaseExecID_ = sourceCaseExecID_;
        this.standardEvent_ = standardEvent_;
        this.source_ = source_;
        this.variableEvent_ = variableEvent_;
        this.variableName_ = variableName_;
        this.satisfied_ = satisfied_;
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

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getCaseExecID_() {
        return caseExecID_;
    }

    public void setCaseExecID_(String caseExecID_) {
        this.caseExecID_ = caseExecID_;
    }

    public String getSentryID_() {
        return sentryID_;
    }

    public void setSentryID_(String sentryID_) {
        this.sentryID_ = sentryID_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getSourceCaseExecID_() {
        return sourceCaseExecID_;
    }

    public void setSourceCaseExecID_(String sourceCaseExecID_) {
        this.sourceCaseExecID_ = sourceCaseExecID_;
    }

    public String getStandardEvent_() {
        return standardEvent_;
    }

    public void setStandardEvent_(String standardEvent_) {
        this.standardEvent_ = standardEvent_;
    }

    public String getSource_() {
        return source_;
    }

    public void setSource_(String source_) {
        this.source_ = source_;
    }

    public String getVariableEvent_() {
        return variableEvent_;
    }

    public void setVariableEvent_(String variableEvent_) {
        this.variableEvent_ = variableEvent_;
    }

    public String getVariableName_() {
        return variableName_;
    }

    public void setVariableName_(String variableName_) {
        this.variableName_ = variableName_;
    }

    public Integer getSatisfied_() {
        return satisfied_;
    }

    public void setSatisfied_(Integer satisfied_) {
        this.satisfied_ = satisfied_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public static class Builder {

        private FgActRuCaseSentryPart instance = new FgActRuCaseSentryPart();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder caseExecID_(String caseExecID_) {
            instance.setCaseExecID_(caseExecID_);
            return this;
        }

        public Builder sentryID_(String sentryID_) {
            instance.setSentryID_(sentryID_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder sourceCaseExecID_(String sourceCaseExecID_) {
            instance.setSourceCaseExecID_(sourceCaseExecID_);
            return this;
        }

        public Builder standardEvent_(String standardEvent_) {
            instance.setStandardEvent_(standardEvent_);
            return this;
        }

        public Builder source_(String source_) {
            instance.setSource_(source_);
            return this;
        }

        public Builder variableEvent_(String variableEvent_) {
            instance.setVariableEvent_(variableEvent_);
            return this;
        }

        public Builder variableName_(String variableName_) {
            instance.setVariableName_(variableName_);
            return this;
        }

        public Builder satisfied_(Integer satisfied_) {
            instance.setSatisfied_(satisfied_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public FgActRuCaseSentryPart build() {
            return instance;
        }
    }
}
