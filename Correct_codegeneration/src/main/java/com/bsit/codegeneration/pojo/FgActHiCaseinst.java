package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiCaseinst {

    private String ID_;

    private String caseInstID_;

    private String businessKey_;

    private String caseDefID_;

    private String createTime_;

    private String closeTime_;

    private Integer duration_;

    private java.math.BigDecimal state_;

    private String createUserID_;

    private String superCaseInstanceID_;

    private String superProcessInstanceID_;

    private String tenantID_;

    public FgActHiCaseinst() {
    }

    public FgActHiCaseinst(String ID_, String caseInstID_, String businessKey_, String caseDefID_, String createTime_, String closeTime_, Integer duration_, java.math.BigDecimal state_, String createUserID_, String superCaseInstanceID_, String superProcessInstanceID_, String tenantID_) {
        this.ID_ = ID_;
        this.caseInstID_ = caseInstID_;
        this.businessKey_ = businessKey_;
        this.caseDefID_ = caseDefID_;
        this.createTime_ = createTime_;
        this.closeTime_ = closeTime_;
        this.duration_ = duration_;
        this.state_ = state_;
        this.createUserID_ = createUserID_;
        this.superCaseInstanceID_ = superCaseInstanceID_;
        this.superProcessInstanceID_ = superProcessInstanceID_;
        this.tenantID_ = tenantID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getBusinessKey_() {
        return businessKey_;
    }

    public void setBusinessKey_(String businessKey_) {
        this.businessKey_ = businessKey_;
    }

    public String getCaseDefID_() {
        return caseDefID_;
    }

    public void setCaseDefID_(String caseDefID_) {
        this.caseDefID_ = caseDefID_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
    }

    public String getCloseTime_() {
        return closeTime_;
    }

    public void setCloseTime_(String closeTime_) {
        this.closeTime_ = closeTime_;
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

    public String getCreateUserID_() {
        return createUserID_;
    }

    public void setCreateUserID_(String createUserID_) {
        this.createUserID_ = createUserID_;
    }

    public String getSuperCaseInstanceID_() {
        return superCaseInstanceID_;
    }

    public void setSuperCaseInstanceID_(String superCaseInstanceID_) {
        this.superCaseInstanceID_ = superCaseInstanceID_;
    }

    public String getSuperProcessInstanceID_() {
        return superProcessInstanceID_;
    }

    public void setSuperProcessInstanceID_(String superProcessInstanceID_) {
        this.superProcessInstanceID_ = superProcessInstanceID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public static class Builder {

        private FgActHiCaseinst instance = new FgActHiCaseinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder businessKey_(String businessKey_) {
            instance.setBusinessKey_(businessKey_);
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            instance.setCaseDefID_(caseDefID_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
            return this;
        }

        public Builder closeTime_(String closeTime_) {
            instance.setCloseTime_(closeTime_);
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

        public Builder createUserID_(String createUserID_) {
            instance.setCreateUserID_(createUserID_);
            return this;
        }

        public Builder superCaseInstanceID_(String superCaseInstanceID_) {
            instance.setSuperCaseInstanceID_(superCaseInstanceID_);
            return this;
        }

        public Builder superProcessInstanceID_(String superProcessInstanceID_) {
            instance.setSuperProcessInstanceID_(superProcessInstanceID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public FgActHiCaseinst build() {
            return instance;
        }
    }
}
