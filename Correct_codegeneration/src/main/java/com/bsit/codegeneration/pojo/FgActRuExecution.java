package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuExecution {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String procInstID_;

    private String businessKey_;

    private String parentID_;

    private String procDefID_;

    private String superExec_;

    private String superCaseExec_;

    private String caseInstID_;

    private String actID_;

    private String actInstID_;

    private Integer isActive_;

    private Integer isConcurrent_;

    private Integer isScope_;

    private Integer isEventScope_;

    private java.math.BigDecimal suspensionState_;

    private java.math.BigDecimal cachedEntState_;

    private java.math.BigDecimal sequenceCounter_;

    private String tenantID_;

    private String rootProcInstID_;

    public FgActRuExecution() {
    }

    public FgActRuExecution(String ID_, java.math.BigDecimal rev_, String procInstID_, String businessKey_, String parentID_, String procDefID_, String superExec_, String superCaseExec_, String caseInstID_, String actID_, String actInstID_, Integer isActive_, Integer isConcurrent_, Integer isScope_, Integer isEventScope_, java.math.BigDecimal suspensionState_, java.math.BigDecimal cachedEntState_, java.math.BigDecimal sequenceCounter_, String tenantID_, String rootProcInstID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.procInstID_ = procInstID_;
        this.businessKey_ = businessKey_;
        this.parentID_ = parentID_;
        this.procDefID_ = procDefID_;
        this.superExec_ = superExec_;
        this.superCaseExec_ = superCaseExec_;
        this.caseInstID_ = caseInstID_;
        this.actID_ = actID_;
        this.actInstID_ = actInstID_;
        this.isActive_ = isActive_;
        this.isConcurrent_ = isConcurrent_;
        this.isScope_ = isScope_;
        this.isEventScope_ = isEventScope_;
        this.suspensionState_ = suspensionState_;
        this.cachedEntState_ = cachedEntState_;
        this.sequenceCounter_ = sequenceCounter_;
        this.tenantID_ = tenantID_;
        this.rootProcInstID_ = rootProcInstID_;
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

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getBusinessKey_() {
        return businessKey_;
    }

    public void setBusinessKey_(String businessKey_) {
        this.businessKey_ = businessKey_;
    }

    public String getParentID_() {
        return parentID_;
    }

    public void setParentID_(String parentID_) {
        this.parentID_ = parentID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getSuperExec_() {
        return superExec_;
    }

    public void setSuperExec_(String superExec_) {
        this.superExec_ = superExec_;
    }

    public String getSuperCaseExec_() {
        return superCaseExec_;
    }

    public void setSuperCaseExec_(String superCaseExec_) {
        this.superCaseExec_ = superCaseExec_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
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

    public Integer getIsActive_() {
        return isActive_;
    }

    public void setIsActive_(Integer isActive_) {
        this.isActive_ = isActive_;
    }

    public Integer getIsConcurrent_() {
        return isConcurrent_;
    }

    public void setIsConcurrent_(Integer isConcurrent_) {
        this.isConcurrent_ = isConcurrent_;
    }

    public Integer getIsScope_() {
        return isScope_;
    }

    public void setIsScope_(Integer isScope_) {
        this.isScope_ = isScope_;
    }

    public Integer getIsEventScope_() {
        return isEventScope_;
    }

    public void setIsEventScope_(Integer isEventScope_) {
        this.isEventScope_ = isEventScope_;
    }

    public java.math.BigDecimal getSuspensionState_() {
        return suspensionState_;
    }

    public void setSuspensionState_(java.math.BigDecimal suspensionState_) {
        this.suspensionState_ = suspensionState_;
    }

    public java.math.BigDecimal getCachedEntState_() {
        return cachedEntState_;
    }

    public void setCachedEntState_(java.math.BigDecimal cachedEntState_) {
        this.cachedEntState_ = cachedEntState_;
    }

    public java.math.BigDecimal getSequenceCounter_() {
        return sequenceCounter_;
    }

    public void setSequenceCounter_(java.math.BigDecimal sequenceCounter_) {
        this.sequenceCounter_ = sequenceCounter_;
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

    public static class Builder {

        private FgActRuExecution instance = new FgActRuExecution();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder businessKey_(String businessKey_) {
            instance.setBusinessKey_(businessKey_);
            return this;
        }

        public Builder parentID_(String parentID_) {
            instance.setParentID_(parentID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder superExec_(String superExec_) {
            instance.setSuperExec_(superExec_);
            return this;
        }

        public Builder superCaseExec_(String superCaseExec_) {
            instance.setSuperCaseExec_(superCaseExec_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
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

        public Builder isActive_(Integer isActive_) {
            instance.setIsActive_(isActive_);
            return this;
        }

        public Builder isConcurrent_(Integer isConcurrent_) {
            instance.setIsConcurrent_(isConcurrent_);
            return this;
        }

        public Builder isScope_(Integer isScope_) {
            instance.setIsScope_(isScope_);
            return this;
        }

        public Builder isEventScope_(Integer isEventScope_) {
            instance.setIsEventScope_(isEventScope_);
            return this;
        }

        public Builder suspensionState_(java.math.BigDecimal suspensionState_) {
            instance.setSuspensionState_(suspensionState_);
            return this;
        }

        public Builder cachedEntState_(java.math.BigDecimal cachedEntState_) {
            instance.setCachedEntState_(cachedEntState_);
            return this;
        }

        public Builder sequenceCounter_(java.math.BigDecimal sequenceCounter_) {
            instance.setSequenceCounter_(sequenceCounter_);
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

        public FgActRuExecution build() {
            return instance;
        }
    }
}
