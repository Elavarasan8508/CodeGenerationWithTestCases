package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiDecinst {

    private String ID_;

    private String decDefID_;

    private String decDefKey_;

    private String decDefName_;

    private String procDefKey_;

    private String procDefID_;

    private String procInstID_;

    private String caseDefKey_;

    private String caseDefID_;

    private String caseInstID_;

    private String actInstID_;

    private String actID_;

    private String evalTime_;

    private java.math.BigDecimal collectValue_;

    private String userID_;

    private String rootDecInstID_;

    private String decReqID_;

    private String decReqKey_;

    private String tenantID_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiDecinst() {
    }

    public FgActHiDecinst(String ID_, String decDefID_, String decDefKey_, String decDefName_, String procDefKey_, String procDefID_, String procInstID_, String caseDefKey_, String caseDefID_, String caseInstID_, String actInstID_, String actID_, String evalTime_, java.math.BigDecimal collectValue_, String userID_, String rootDecInstID_, String decReqID_, String decReqKey_, String tenantID_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.decDefID_ = decDefID_;
        this.decDefKey_ = decDefKey_;
        this.decDefName_ = decDefName_;
        this.procDefKey_ = procDefKey_;
        this.procDefID_ = procDefID_;
        this.procInstID_ = procInstID_;
        this.caseDefKey_ = caseDefKey_;
        this.caseDefID_ = caseDefID_;
        this.caseInstID_ = caseInstID_;
        this.actInstID_ = actInstID_;
        this.actID_ = actID_;
        this.evalTime_ = evalTime_;
        this.collectValue_ = collectValue_;
        this.userID_ = userID_;
        this.rootDecInstID_ = rootDecInstID_;
        this.decReqID_ = decReqID_;
        this.decReqKey_ = decReqKey_;
        this.tenantID_ = tenantID_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getDecDefID_() {
        return decDefID_;
    }

    public void setDecDefID_(String decDefID_) {
        this.decDefID_ = decDefID_;
    }

    public String getDecDefKey_() {
        return decDefKey_;
    }

    public void setDecDefKey_(String decDefKey_) {
        this.decDefKey_ = decDefKey_;
    }

    public String getDecDefName_() {
        return decDefName_;
    }

    public void setDecDefName_(String decDefName_) {
        this.decDefName_ = decDefName_;
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

    public String getActInstID_() {
        return actInstID_;
    }

    public void setActInstID_(String actInstID_) {
        this.actInstID_ = actInstID_;
    }

    public String getActID_() {
        return actID_;
    }

    public void setActID_(String actID_) {
        this.actID_ = actID_;
    }

    public String getEvalTime_() {
        return evalTime_;
    }

    public void setEvalTime_(String evalTime_) {
        this.evalTime_ = evalTime_;
    }

    public java.math.BigDecimal getCollectValue_() {
        return collectValue_;
    }

    public void setCollectValue_(java.math.BigDecimal collectValue_) {
        this.collectValue_ = collectValue_;
    }

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public String getRootDecInstID_() {
        return rootDecInstID_;
    }

    public void setRootDecInstID_(String rootDecInstID_) {
        this.rootDecInstID_ = rootDecInstID_;
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

        private FgActHiDecinst instance = new FgActHiDecinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder decDefID_(String decDefID_) {
            instance.setDecDefID_(decDefID_);
            return this;
        }

        public Builder decDefKey_(String decDefKey_) {
            instance.setDecDefKey_(decDefKey_);
            return this;
        }

        public Builder decDefName_(String decDefName_) {
            instance.setDecDefName_(decDefName_);
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

        public Builder actInstID_(String actInstID_) {
            instance.setActInstID_(actInstID_);
            return this;
        }

        public Builder actID_(String actID_) {
            instance.setActID_(actID_);
            return this;
        }

        public Builder evalTime_(String evalTime_) {
            instance.setEvalTime_(evalTime_);
            return this;
        }

        public Builder collectValue_(java.math.BigDecimal collectValue_) {
            instance.setCollectValue_(collectValue_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder rootDecInstID_(String rootDecInstID_) {
            instance.setRootDecInstID_(rootDecInstID_);
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

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public FgActHiDecinst build() {
            return instance;
        }
    }
}
