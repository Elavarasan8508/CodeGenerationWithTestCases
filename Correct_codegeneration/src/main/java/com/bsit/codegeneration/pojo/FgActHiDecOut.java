package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiDecOut {

    private String ID_;

    private String decInstID_;

    private String clauseID_;

    private String clauseName_;

    private String ruleID_;

    private java.math.BigDecimal ruleOrder_;

    private String varName_;

    private String varType_;

    private String bytearrayID_;

    private java.math.BigDecimal double_;

    private java.math.BigDecimal long_;

    private String text_;

    private String text2_;

    private String tenantID_;

    private String createTime_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiDecOut() {
    }

    public FgActHiDecOut(String ID_, String decInstID_, String clauseID_, String clauseName_, String ruleID_, java.math.BigDecimal ruleOrder_, String varName_, String varType_, String bytearrayID_, java.math.BigDecimal double_, java.math.BigDecimal long_, String text_, String text2_, String tenantID_, String createTime_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.decInstID_ = decInstID_;
        this.clauseID_ = clauseID_;
        this.clauseName_ = clauseName_;
        this.ruleID_ = ruleID_;
        this.ruleOrder_ = ruleOrder_;
        this.varName_ = varName_;
        this.varType_ = varType_;
        this.bytearrayID_ = bytearrayID_;
        this.double_ = double_;
        this.long_ = long_;
        this.text_ = text_;
        this.text2_ = text2_;
        this.tenantID_ = tenantID_;
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

    public String getDecInstID_() {
        return decInstID_;
    }

    public void setDecInstID_(String decInstID_) {
        this.decInstID_ = decInstID_;
    }

    public String getClauseID_() {
        return clauseID_;
    }

    public void setClauseID_(String clauseID_) {
        this.clauseID_ = clauseID_;
    }

    public String getClauseName_() {
        return clauseName_;
    }

    public void setClauseName_(String clauseName_) {
        this.clauseName_ = clauseName_;
    }

    public String getRuleID_() {
        return ruleID_;
    }

    public void setRuleID_(String ruleID_) {
        this.ruleID_ = ruleID_;
    }

    public java.math.BigDecimal getRuleOrder_() {
        return ruleOrder_;
    }

    public void setRuleOrder_(java.math.BigDecimal ruleOrder_) {
        this.ruleOrder_ = ruleOrder_;
    }

    public String getVarName_() {
        return varName_;
    }

    public void setVarName_(String varName_) {
        this.varName_ = varName_;
    }

    public String getVarType_() {
        return varType_;
    }

    public void setVarType_(String varType_) {
        this.varType_ = varType_;
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

        private FgActHiDecOut instance = new FgActHiDecOut();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder decInstID_(String decInstID_) {
            instance.setDecInstID_(decInstID_);
            return this;
        }

        public Builder clauseID_(String clauseID_) {
            instance.setClauseID_(clauseID_);
            return this;
        }

        public Builder clauseName_(String clauseName_) {
            instance.setClauseName_(clauseName_);
            return this;
        }

        public Builder ruleID_(String ruleID_) {
            instance.setRuleID_(ruleID_);
            return this;
        }

        public Builder ruleOrder_(java.math.BigDecimal ruleOrder_) {
            instance.setRuleOrder_(ruleOrder_);
            return this;
        }

        public Builder varName_(String varName_) {
            instance.setVarName_(varName_);
            return this;
        }

        public Builder varType_(String varType_) {
            instance.setVarType_(varType_);
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

        public FgActHiDecOut build() {
            return instance;
        }
    }
}
