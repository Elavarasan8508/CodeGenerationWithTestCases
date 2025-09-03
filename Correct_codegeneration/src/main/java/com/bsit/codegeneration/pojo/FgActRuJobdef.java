package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActRuJobdef {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String procDefID_;

    private String procDefKey_;

    private String actID_;

    private String jobType_;

    private String jobConfiguration_;

    private java.math.BigDecimal suspensionState_;

    private java.math.BigDecimal jobPriority_;

    private String tenantID_;

    private String deploymentID_;

    private List<FgActRuBatch> fgActRuBatchList;

    private List<FgActRuIncident> fgActRuIncidentList;

    public FgActRuJobdef() {
    }

    public FgActRuJobdef(String ID_, java.math.BigDecimal rev_, String procDefID_, String procDefKey_, String actID_, String jobType_, String jobConfiguration_, java.math.BigDecimal suspensionState_, java.math.BigDecimal jobPriority_, String tenantID_, String deploymentID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.procDefID_ = procDefID_;
        this.procDefKey_ = procDefKey_;
        this.actID_ = actID_;
        this.jobType_ = jobType_;
        this.jobConfiguration_ = jobConfiguration_;
        this.suspensionState_ = suspensionState_;
        this.jobPriority_ = jobPriority_;
        this.tenantID_ = tenantID_;
        this.deploymentID_ = deploymentID_;
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

    public String getJobType_() {
        return jobType_;
    }

    public void setJobType_(String jobType_) {
        this.jobType_ = jobType_;
    }

    public String getJobConfiguration_() {
        return jobConfiguration_;
    }

    public void setJobConfiguration_(String jobConfiguration_) {
        this.jobConfiguration_ = jobConfiguration_;
    }

    public java.math.BigDecimal getSuspensionState_() {
        return suspensionState_;
    }

    public void setSuspensionState_(java.math.BigDecimal suspensionState_) {
        this.suspensionState_ = suspensionState_;
    }

    public java.math.BigDecimal getJobPriority_() {
        return jobPriority_;
    }

    public void setJobPriority_(java.math.BigDecimal jobPriority_) {
        this.jobPriority_ = jobPriority_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getDeploymentID_() {
        return deploymentID_;
    }

    public void setDeploymentID_(String deploymentID_) {
        this.deploymentID_ = deploymentID_;
    }

    public List<FgActRuBatch> getFgActRuBatchList() {
        return fgActRuBatchList;
    }

    public void setFgActRuBatchList(List<FgActRuBatch> fgActRuBatchList) {
        this.fgActRuBatchList = fgActRuBatchList;
    }

    public List<FgActRuIncident> getFgActRuIncidentList() {
        return fgActRuIncidentList;
    }

    public void setFgActRuIncidentList(List<FgActRuIncident> fgActRuIncidentList) {
        this.fgActRuIncidentList = fgActRuIncidentList;
    }

    public static class Builder {

        private FgActRuJobdef instance = new FgActRuJobdef();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
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

        public Builder jobType_(String jobType_) {
            instance.setJobType_(jobType_);
            return this;
        }

        public Builder jobConfiguration_(String jobConfiguration_) {
            instance.setJobConfiguration_(jobConfiguration_);
            return this;
        }

        public Builder suspensionState_(java.math.BigDecimal suspensionState_) {
            instance.setSuspensionState_(suspensionState_);
            return this;
        }

        public Builder jobPriority_(java.math.BigDecimal jobPriority_) {
            instance.setJobPriority_(jobPriority_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            instance.setDeploymentID_(deploymentID_);
            return this;
        }

        public Builder fgActRuBatchList(List<FgActRuBatch> fgActRuBatchList) {
            instance.setFgActRuBatchList(fgActRuBatchList);
            return this;
        }

        public Builder fgActRuIncidentList(List<FgActRuIncident> fgActRuIncidentList) {
            instance.setFgActRuIncidentList(fgActRuIncidentList);
            return this;
        }

        public FgActRuJobdef build() {
            return instance;
        }
    }
}
