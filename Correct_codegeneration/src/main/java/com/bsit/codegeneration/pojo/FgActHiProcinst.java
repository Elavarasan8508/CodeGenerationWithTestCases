package com.bsit.codegeneration.pojo;

public class FgActHiProcinst {

    private String ID_;

    private String procInstID_;

    private String businessKey_;

    private String procDefKey_;

    private String procDefID_;

    private String startTime_;

    private String endTime_;

    private Integer duration_;

    private String startUserID_;

    private String startActID_;

    private String endActID_;

    private String superProcessInstanceID_;

    private String superCaseInstanceID_;

    private String caseInstID_;

    private String deleteReason_;

    private String tenantID_;

    private String state_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiProcinst() {
    }

    public FgActHiProcinst(String ID_, String procInstID_, String businessKey_, String procDefKey_, String procDefID_, String startTime_, String endTime_, Integer duration_, String startUserID_, String startActID_, String endActID_, String superProcessInstanceID_, String superCaseInstanceID_, String caseInstID_, String deleteReason_, String tenantID_, String state_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.procInstID_ = procInstID_;
        this.businessKey_ = businessKey_;
        this.procDefKey_ = procDefKey_;
        this.procDefID_ = procDefID_;
        this.startTime_ = startTime_;
        this.endTime_ = endTime_;
        this.duration_ = duration_;
        this.startUserID_ = startUserID_;
        this.startActID_ = startActID_;
        this.endActID_ = endActID_;
        this.superProcessInstanceID_ = superProcessInstanceID_;
        this.superCaseInstanceID_ = superCaseInstanceID_;
        this.caseInstID_ = caseInstID_;
        this.deleteReason_ = deleteReason_;
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

    public String getStartTime_() {
        return startTime_;
    }

    public void setStartTime_(String startTime_) {
        this.startTime_ = startTime_;
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

    public String getStartUserID_() {
        return startUserID_;
    }

    public void setStartUserID_(String startUserID_) {
        this.startUserID_ = startUserID_;
    }

    public String getStartActID_() {
        return startActID_;
    }

    public void setStartActID_(String startActID_) {
        this.startActID_ = startActID_;
    }

    public String getEndActID_() {
        return endActID_;
    }

    public void setEndActID_(String endActID_) {
        this.endActID_ = endActID_;
    }

    public String getSuperProcessInstanceID_() {
        return superProcessInstanceID_;
    }

    public void setSuperProcessInstanceID_(String superProcessInstanceID_) {
        this.superProcessInstanceID_ = superProcessInstanceID_;
    }

    public String getSuperCaseInstanceID_() {
        return superCaseInstanceID_;
    }

    public void setSuperCaseInstanceID_(String superCaseInstanceID_) {
        this.superCaseInstanceID_ = superCaseInstanceID_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getDeleteReason_() {
        return deleteReason_;
    }

    public void setDeleteReason_(String deleteReason_) {
        this.deleteReason_ = deleteReason_;
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

        private FgActHiProcinst instance = new FgActHiProcinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
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

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder startTime_(String startTime_) {
            instance.setStartTime_(startTime_);
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

        public Builder startUserID_(String startUserID_) {
            instance.setStartUserID_(startUserID_);
            return this;
        }

        public Builder startActID_(String startActID_) {
            instance.setStartActID_(startActID_);
            return this;
        }

        public Builder endActID_(String endActID_) {
            instance.setEndActID_(endActID_);
            return this;
        }

        public Builder superProcessInstanceID_(String superProcessInstanceID_) {
            instance.setSuperProcessInstanceID_(superProcessInstanceID_);
            return this;
        }

        public Builder superCaseInstanceID_(String superCaseInstanceID_) {
            instance.setSuperCaseInstanceID_(superCaseInstanceID_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder deleteReason_(String deleteReason_) {
            instance.setDeleteReason_(deleteReason_);
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

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public FgActHiProcinst build() {
            return instance;
        }
    }
}
